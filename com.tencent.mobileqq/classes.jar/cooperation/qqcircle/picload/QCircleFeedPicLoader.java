package cooperation.qqcircle.picload;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.tencent.biz.richframework.delegate.impl.RFLog;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mqq.api.IThreadManagerApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleConstants;
import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.mobileqq.qcircle.api.interfaces.QCirclePicStateListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.SharePreferenceUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.picload.avatar.QCircleAvatarLoader;
import java.util.HashMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;

public class QCircleFeedPicLoader
{
  public static final int DEFAULT_COMPARE_VALUE = 0;
  public static final int DEFAULT_DOWN_SPEED = -1;
  public static final int DEFAULT_TIME_COST = -1;
  public static final String DOWNLOAD_ROOT_PATH = QCircleConstants.QCIRCLE_DOWNLOAD_ROOT_PATH + "feed_pic/";
  public static final long ONE_KB = 1024L;
  public static final float ONE_SECONDS = 1000.0F;
  public static final float RATE_SAMPLE_SIZE = 1.4F;
  public static final int SCALE = 2;
  public static final int STATE_CANCEL = 4;
  public static final int STATE_DECODE = 5;
  public static final int STATE_DECODE_FAILED = 8;
  public static final int STATE_DOWNING = 2;
  public static final int STATE_DOWNLOAD_SUCCESS = 3;
  public static final int STATE_DOWN_FAILED = 7;
  public static final int STATE_PREPARE = 1;
  public static final int STATE_SUCCESS = 6;
  public static final int STEP_SAMPLE_SIZE = 2;
  public static final String TAG = "QCircleFeedPicLoader";
  private static HashMap<String, String> mDecodeValueMap;
  public static AtomicInteger sAtomicInteger = new AtomicInteger(10000);
  private static int sCacheTime = 259200000;
  private static volatile QCircleFeedPicLoader sInstance;
  private static HashMap<String, String> sKeyHashMap;
  private final byte[] mCacheLock = new byte[1];
  private ThreadPoolExecutor mDecodeExecutor;
  private ConcurrentHashMap<String, PicDecodeTask> mDecodeTasks;
  private ThreadPoolExecutor mDownLoadExecutor;
  private ConcurrentHashMap<String, PicDownLoadTask> mDownLoadTasks;
  private MQLruCache<String, Object> mImageCache = GlobalImageCache.a;
  private ThreadPoolExecutor mPreloadDecodeExecutor;
  private ThreadPoolExecutor mPreloadDownLoadExecutor;
  private Handler mReportHandler;
  private Handler mUIHandler;
  
  private QCircleFeedPicLoader()
  {
    int i = Runtime.getRuntime().availableProcessors();
    this.mDownLoadExecutor = createPool(i + 1, i * 2 + 1);
    this.mDecodeExecutor = createPool(i + 1, i * 2 + 1);
    this.mPreloadDecodeExecutor = createPool(i + 1, i * 2 + 1);
    this.mPreloadDownLoadExecutor = createPool(i + 1, i * 2 + 1);
    this.mDownLoadTasks = new ConcurrentHashMap();
    this.mDecodeTasks = new ConcurrentHashMap();
    sKeyHashMap = new HashMap();
    mDecodeValueMap = new HashMap();
    this.mUIHandler = new Handler(Looper.getMainLooper());
    HandlerThread localHandlerThread = new HandlerThread("qcircle_report_handler", 0);
    localHandlerThread.start();
    this.mReportHandler = new Handler(localHandlerThread.getLooper());
    ((IThreadManagerApi)QRoute.api(IThreadManagerApi.class)).execute(new QCircleFeedPicLoader.1(this), 64, null, false);
  }
  
  private Drawable bitmapTransferDrawable(Option paramOption, Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return new BitmapDrawable(MobileQQ.sMobileQQ.getApplicationContext().getResources());
    }
    byte[] arrayOfByte = paramBitmap.getNinePatchChunk();
    if (NinePatch.isNinePatchChunk(arrayOfByte))
    {
      paramBitmap = new NinePatchDrawable(MobileQQ.sMobileQQ.getApplicationContext().getResources(), paramBitmap, arrayOfByte, new Rect(), null);
      paramOption.setPicType(2);
      return paramBitmap;
    }
    return new BitmapDrawable(MobileQQ.sMobileQQ.getApplicationContext().getResources(), paramBitmap);
  }
  
  private void cancelDecode(String paramString)
  {
    if ((this.mDecodeTasks != null) && (!TextUtils.isEmpty(paramString)))
    {
      PicDecodeTask localPicDecodeTask = (PicDecodeTask)this.mDecodeTasks.get(paramString);
      if ((localPicDecodeTask != null) && (localPicDecodeTask.mOption.isFromPreload()))
      {
        this.mPreloadDecodeExecutor.getQueue().remove(localPicDecodeTask);
        this.mDecodeExecutor.getQueue().remove(localPicDecodeTask);
        this.mDecodeTasks.remove(paramString);
        localPicDecodeTask.cancel();
      }
    }
  }
  
  private void cancelDownload(String paramString)
  {
    if ((this.mDownLoadTasks != null) && (TextUtils.isEmpty(paramString)))
    {
      PicDownLoadTask localPicDownLoadTask = (PicDownLoadTask)this.mDownLoadTasks.get(paramString);
      if ((localPicDownLoadTask != null) && (localPicDownLoadTask.mOption.isFromPreload()))
      {
        this.mPreloadDownLoadExecutor.getQueue().remove(localPicDownLoadTask);
        this.mDownLoadExecutor.getQueue().remove(localPicDownLoadTask);
        this.mDownLoadTasks.remove(paramString);
        localPicDownLoadTask.cancel();
      }
    }
  }
  
  private void checkDeleteTime()
  {
    long l = System.currentTimeMillis();
    String str = SharePreferenceUtils.a(MobileQQ.sMobileQQ, "qcircle_pic_cache_time");
    if (!TextUtils.isEmpty(str))
    {
      if (l - Long.valueOf(str).longValue() >= sCacheTime)
      {
        FileUtils.a(DOWNLOAD_ROOT_PATH);
        SharePreferenceUtils.a(MobileQQ.sMobileQQ, "qcircle_pic_cache_time", String.valueOf(l));
      }
      return;
    }
    SharePreferenceUtils.a(MobileQQ.sMobileQQ, "qcircle_pic_cache_time", String.valueOf(l));
  }
  
  public static ThreadPoolExecutor createPool(int paramInt1, int paramInt2)
  {
    return new ThreadPoolExecutor(paramInt1, paramInt2, 120L, TimeUnit.SECONDS, new PriorityBlockingQueue(200, new QCircleFeedPicLoader.2()), Executors.defaultThreadFactory(), new QCircleFeedPicLoader.3());
  }
  
  private void doDownLoadPic(@NotNull Option paramOption, QCirclePicStateListener paramQCirclePicStateListener)
  {
    String str = getCacheKey(paramOption);
    if ((paramOption.isFromPreload()) && (this.mDownLoadTasks.containsKey(str))) {}
    do
    {
      return;
      localPicDownLoadTask = (PicDownLoadTask)this.mDownLoadTasks.get(str);
    } while ((localPicDownLoadTask != null) && (localPicDownLoadTask.mOption.getTargetView() != null) && (localPicDownLoadTask.mOption.getTargetView() == paramOption.getTargetView()));
    paramOption.mDownLoadStartTime = Long.valueOf(System.currentTimeMillis());
    PicDownLoadTask localPicDownLoadTask = new PicDownLoadTask(paramOption);
    localPicDownLoadTask.setStatusListener(paramQCirclePicStateListener);
    this.mDownLoadTasks.put(str, localPicDownLoadTask);
    if (paramOption.isFromPreload())
    {
      this.mPreloadDownLoadExecutor.execute(localPicDownLoadTask);
      return;
    }
    this.mDownLoadExecutor.execute(localPicDownLoadTask);
  }
  
  public static QCircleFeedPicLoader g()
  {
    if (sInstance == null) {}
    try
    {
      if (sInstance == null) {
        sInstance = new QCircleFeedPicLoader();
      }
      return sInstance;
    }
    finally {}
  }
  
  private Object getCache(String paramString)
  {
    synchronized (this.mCacheLock)
    {
      paramString = this.mImageCache.get(paramString);
      return paramString;
    }
  }
  
  private String getEncodeString(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      QLog.w("QCircleFeedPicLoader", 1, "[getEncodeString] current url is null, not encode key.");
    }
    Object localObject2;
    do
    {
      return paramString;
      Object localObject1 = "";
      String str = getUniKeyFromUrl(paramString);
      if (!TextUtils.isEmpty(str))
      {
        localObject2 = (String)mDecodeValueMap.get(str);
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject1 = MD5Utils.encodeHexStr(str);
          mDecodeValueMap.put(str, localObject1);
        }
      }
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = MD5Utils.encodeFileHexStr(paramString);
      }
    } while (localObject2 == null);
    return localObject2;
  }
  
  public static String getUniKeyFromUrl(String paramString)
  {
    Object localObject1;
    int i;
    if (!TextUtils.isEmpty(paramString))
    {
      if ((sKeyHashMap != null) && (sKeyHashMap.containsKey(paramString)))
      {
        localObject1 = (String)sKeyHashMap.get(paramString);
        return localObject1;
      }
      i = paramString.indexOf("://");
      if (i == -1) {
        break label167;
      }
    }
    label167:
    for (Object localObject2 = paramString.substring(i + 3);; localObject2 = paramString)
    {
      i = ((String)localObject2).indexOf("/");
      localObject1 = localObject2;
      if (i != -1) {
        localObject1 = ((String)localObject2).substring(i);
      }
      i = ((String)localObject1).lastIndexOf("#");
      localObject2 = localObject1;
      if (i != -1) {
        localObject2 = ((String)localObject1).substring(0, i);
      }
      i = ((String)localObject2).indexOf("tm=");
      localObject1 = localObject2;
      if (i != -1) {
        localObject1 = ((String)localObject2).substring(0, i);
      }
      i = ((String)localObject1).indexOf("ek=1");
      localObject2 = localObject1;
      if (i != -1) {
        localObject2 = ((String)localObject1).substring(0, i);
      }
      localObject1 = localObject2;
      if (sKeyHashMap == null) {
        break;
      }
      sKeyHashMap.put(paramString, localObject2);
      return localObject2;
      return "";
    }
  }
  
  private void postToMain(Option paramOption, Drawable paramDrawable, boolean paramBoolean)
  {
    if (paramOption == null) {
      return;
    }
    this.mUIHandler.post(new QCircleFeedPicLoader.5(this, paramOption, paramDrawable, paramBoolean));
  }
  
  public static Option setViewWidthHeight(Option paramOption, View paramView)
  {
    Option localOption = paramOption;
    if (paramOption == null) {
      localOption = new Option();
    }
    if ((paramView != null) && (paramView.getLayoutParams() != null))
    {
      localOption.setRequestHeight(paramView.getLayoutParams().height);
      localOption.setRequestWidth(paramView.getLayoutParams().width);
    }
    return localOption;
  }
  
  private void showInMain(Option paramOption, Drawable paramDrawable, boolean paramBoolean)
  {
    if (paramOption == null) {
      return;
    }
    if (paramOption.isValid())
    {
      if (paramOption.getTargetView() != null)
      {
        paramOption.getTargetView().setImageDrawable(null);
        paramOption.getTargetView().setImageDrawable(paramDrawable);
      }
      if (paramBoolean) {
        reportLoadResult(paramOption, 0);
      }
      RFLog.i("QCircleFeedPicLoader", RFLog.USR, "seq = " + paramOption.getSeq() + " cacheKey = " + paramOption.getCacheKey() + " showDrawable time " + (System.currentTimeMillis() - paramOption.mStartTime.longValue()) + "pic is valid");
      return;
    }
    RFLog.i("QCircleFeedPicLoader", RFLog.USR, "seq = " + paramOption.getSeq() + " cacheKey = " + paramOption.getCacheKey() + " showDrawable time " + (System.currentTimeMillis() - paramOption.mStartTime.longValue()) + "pic is unValid");
  }
  
  protected void addToCache(String paramString, Bitmap paramBitmap)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramBitmap != null) && (!paramBitmap.isRecycled())) {}
    synchronized (this.mCacheLock)
    {
      this.mImageCache.put(paramString, paramBitmap);
      this.mDecodeTasks.remove(paramString);
      return;
    }
  }
  
  public void cancel(@NotNull String paramString)
  {
    cancelDownload(paramString);
    cancelDecode(paramString);
  }
  
  protected void decodeFile(@NotNull Option paramOption, QCirclePicStateListener paramQCirclePicStateListener)
  {
    String str = getCacheKey(paramOption);
    if ((paramOption.isFromPreload()) && (this.mDecodeTasks.containsKey(str))) {}
    do
    {
      return;
      localPicDecodeTask = (PicDecodeTask)this.mDecodeTasks.get(str);
    } while ((localPicDecodeTask != null) && (localPicDecodeTask.mOption.getTargetView() != null) && (localPicDecodeTask.mOption.getTargetView() == paramOption.getTargetView()));
    paramOption.mDecodeStartTime = Long.valueOf(System.currentTimeMillis());
    PicDecodeTask localPicDecodeTask = new PicDecodeTask(paramOption);
    localPicDecodeTask.setStatusListener(paramQCirclePicStateListener);
    this.mDecodeTasks.put(str, localPicDecodeTask);
    if (paramOption.isFromPreload())
    {
      this.mPreloadDecodeExecutor.execute(localPicDecodeTask);
      return;
    }
    this.mDecodeExecutor.execute(localPicDecodeTask);
  }
  
  public void destroy()
  {
    ThreadManager.getSubThreadHandler().post(new QCircleFeedPicLoader.6(this));
  }
  
  public String getCacheKey(Option paramOption)
  {
    if (!TextUtils.isEmpty(paramOption.getUrl()))
    {
      StringBuilder localStringBuilder = new StringBuilder(getEncodeString(paramOption.getUrl()));
      localStringBuilder.append("#").append(paramOption.getRequestWidth()).append("_").append(paramOption.getRequestHeight());
      paramOption.setCacheKey(localStringBuilder.toString());
      return localStringBuilder.toString();
    }
    return "";
  }
  
  public String getPicLocalPath(Option paramOption)
  {
    if (FileUtils.c(paramOption.getUrl()))
    {
      str = paramOption.getUrl();
      paramOption.setLocalPath(str);
      return str;
    }
    String str = getEncodeString(paramOption.getUrl());
    str = DOWNLOAD_ROOT_PATH + str + ".suf";
    paramOption.setLocalPath(str);
    return str;
  }
  
  public String loadImage(@NotNull Option paramOption, QCirclePicStateListener paramQCirclePicStateListener)
  {
    String str = getCacheKey(paramOption);
    Object localObject = getCache(str);
    if (paramOption.getSeq() == 0) {
      paramOption.setSeq(sAtomicInteger.getAndIncrement());
    }
    if (paramOption.mStartTime == null) {
      paramOption.mStartTime = Long.valueOf(System.currentTimeMillis());
    }
    RFLog.i("QCircleFeedPicLoader", RFLog.USR, "seq = " + paramOption.getSeq() + " cacheKey = " + paramOption.getCacheKey() + " url = " + paramOption.getUrl() + " isFromPreload:" + paramOption.isFromPreload());
    if ((localObject instanceof Bitmap))
    {
      long l = System.currentTimeMillis();
      paramOption.mLoadType = 0;
      paramOption.setResultBitMap((Bitmap)localObject);
      showPic(paramOption, (Bitmap)localObject);
      if (paramQCirclePicStateListener != null) {
        paramQCirclePicStateListener.onStateChang(6, paramOption);
      }
      RFLog.i("QCircleFeedPicLoader", RFLog.USR, "seq = " + paramOption.getSeq() + " cacheKey = " + paramOption.getCacheKey() + " return in cache: " + paramOption.isFromPreload() + " costTime:" + (System.currentTimeMillis() - l));
      return str;
    }
    this.mDecodeExecutor.execute(new QCircleFeedPicLoader.4(this, paramOption, paramQCirclePicStateListener));
    return str;
  }
  
  public void release()
  {
    QCircleAvatarLoader.g().release();
    this.mDownLoadTasks.clear();
    this.mDecodeTasks.clear();
    this.mDecodeExecutor.getQueue().clear();
    this.mDownLoadExecutor.getQueue().clear();
    this.mPreloadDecodeExecutor.getQueue().clear();
    this.mPreloadDownLoadExecutor.getQueue().clear();
    sKeyHashMap.clear();
    QCirclePicDownLoader.g().release();
    QCircleNetSpeed.g().stop();
    RFLog.d("QCircleFeedPicLoader", RFLog.USR, "feed pic release");
  }
  
  protected void removeDownLoadTask(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      this.mDecodeTasks.remove(paramString);
    }
  }
  
  protected void reportLoadResult(Option paramOption, int paramInt)
  {
    if (paramOption != null)
    {
      double d = -1.0D;
      if (paramOption.mStartTime != null) {
        d = (float)(System.currentTimeMillis() - paramOption.mStartTime.longValue()) / 1000.0F;
      }
      this.mReportHandler.post(new QCircleFeedPicLoader.7(this, d, paramInt, paramOption));
    }
  }
  
  protected void showDrawable(Option paramOption, Drawable paramDrawable)
  {
    if ((paramOption != null) && (paramDrawable != null))
    {
      if (Looper.getMainLooper() == Looper.myLooper()) {
        showInMain(paramOption, paramDrawable, false);
      }
    }
    else {
      return;
    }
    postToMain(paramOption, paramDrawable, false);
  }
  
  protected void showPic(Option paramOption, Bitmap paramBitmap)
  {
    if ((paramOption != null) && (paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      paramBitmap = bitmapTransferDrawable(paramOption, paramBitmap);
      if (Looper.getMainLooper() == Looper.myLooper()) {
        showInMain(paramOption, paramBitmap, true);
      }
    }
    else
    {
      return;
    }
    postToMain(paramOption, paramBitmap, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqcircle.picload.QCircleFeedPicLoader
 * JD-Core Version:    0.7.0.1
 */