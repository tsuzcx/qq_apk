package cooperation.qqcircle.picload;

import android.graphics.Bitmap;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.util.SharePreferenceUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.QCircleConstants;
import cooperation.qqcircle.report.QCircleQualityReporter;
import java.util.HashMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;

public class QCircleFeedPicLoader
{
  private static int CACHE_TIME = 259200000;
  private static final String DOWNLOAD_ROOT_PATH = QCircleConstants.QCIRCLE_DOWNLOAD_ROOT_PATH + "feed_pic/";
  public static int STATE_CANCEL;
  public static int STATE_DECODE;
  public static int STATE_DECODE_FAILED;
  public static int STATE_DOWNING;
  public static int STATE_DOWNLOAD_SUCCESS;
  public static int STATE_DOWN_FAILED;
  public static int STATE_PREPARE;
  public static int STATE_SUCCESS;
  public static String TAG = "QCircleFeedPicLoader";
  private static QCircleFeedPicLoader mInstance;
  private static HashMap<String, String> mKeyHashMap;
  private final AtomicInteger mAtomicInteger = new AtomicInteger(10000);
  private final byte[] mCacheLock = new byte[1];
  private ThreadPoolExecutor mDecodeExecutor;
  private ConcurrentHashMap<String, QCircleFeedPicLoader.PicDeCodeTask> mDecodeTasks;
  private ThreadPoolExecutor mDownLoadExecutor;
  private ConcurrentHashMap<String, QCircleFeedPicLoader.PicDownLoadTask> mDownLoadTasks;
  private ThreadPoolExecutor mPreloadDecodeExecutor;
  private ThreadPoolExecutor mPreloadDownLoadExecutor;
  private Handler mUIHandler;
  private MQLruCache<String, Object> sImageCache;
  
  static
  {
    STATE_PREPARE = 1;
    STATE_DOWNING = 2;
    STATE_DOWNLOAD_SUCCESS = 3;
    STATE_CANCEL = 4;
    STATE_DECODE = 5;
    STATE_SUCCESS = 6;
    STATE_DOWN_FAILED = 7;
    STATE_DECODE_FAILED = 8;
  }
  
  private QCircleFeedPicLoader()
  {
    if (this.sImageCache == null) {
      this.sImageCache = BaseApplicationImpl.sImageCache;
    }
    int i = Runtime.getRuntime().availableProcessors();
    if (this.mDownLoadExecutor == null) {
      this.mDownLoadExecutor = createPool(i + 1, i * 2 + 1);
    }
    if (this.mDecodeExecutor == null) {
      this.mDecodeExecutor = createPool(i + 1, i * 2 + 1);
    }
    if (this.mPreloadDecodeExecutor == null) {
      this.mPreloadDecodeExecutor = createPool(i + 1, i * 2 + 1);
    }
    if (this.mPreloadDownLoadExecutor == null) {
      this.mPreloadDownLoadExecutor = createPool(i + 1, i * 2 + 1);
    }
    if (this.mDownLoadTasks == null) {
      this.mDownLoadTasks = new ConcurrentHashMap();
    }
    if (this.mDecodeTasks == null) {
      this.mDecodeTasks = new ConcurrentHashMap();
    }
    if (mKeyHashMap == null) {
      mKeyHashMap = new HashMap();
    }
    this.mUIHandler = new Handler(Looper.getMainLooper());
    ThreadManager.getFileThreadHandler().post(new QCircleFeedPicLoader.1(this));
  }
  
  private void addToCache(String paramString, Bitmap paramBitmap)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramBitmap != null) && (!paramBitmap.isRecycled())) {}
    synchronized (this.mCacheLock)
    {
      this.sImageCache.put(paramString, paramBitmap);
      this.mDecodeTasks.remove(paramString);
      return;
    }
  }
  
  private Drawable bitmapTransferDrawable(Option paramOption, Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return new BitmapDrawable(BaseApplicationImpl.getContext().getResources());
    }
    byte[] arrayOfByte = paramBitmap.getNinePatchChunk();
    if (NinePatch.isNinePatchChunk(arrayOfByte))
    {
      paramBitmap = new NinePatchDrawable(BaseApplicationImpl.getContext().getResources(), paramBitmap, arrayOfByte, new Rect(), null);
      paramOption.mPicType = 2;
      return paramBitmap;
    }
    return new BitmapDrawable(BaseApplicationImpl.getContext().getResources(), paramBitmap);
  }
  
  private void cancelDecode(String paramString)
  {
    if ((this.mDecodeTasks != null) && (!TextUtils.isEmpty(paramString)))
    {
      QCircleFeedPicLoader.PicDeCodeTask localPicDeCodeTask = (QCircleFeedPicLoader.PicDeCodeTask)this.mDecodeTasks.get(paramString);
      if ((localPicDeCodeTask != null) && (localPicDeCodeTask.mOption.isFromPreload()))
      {
        this.mPreloadDecodeExecutor.getQueue().remove(localPicDeCodeTask);
        this.mDecodeExecutor.getQueue().remove(localPicDeCodeTask);
        this.mDecodeTasks.remove(paramString);
        localPicDeCodeTask.cancel();
      }
    }
  }
  
  private void cancelDownload(String paramString)
  {
    if ((this.mDownLoadTasks != null) && (TextUtils.isEmpty(paramString)))
    {
      QCircleFeedPicLoader.PicDownLoadTask localPicDownLoadTask = (QCircleFeedPicLoader.PicDownLoadTask)this.mDownLoadTasks.get(paramString);
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
    String str = SharePreferenceUtils.get(BaseApplicationImpl.getApplication(), "qcircle_pic_cache_time");
    if (!TextUtils.isEmpty(str))
    {
      if (l - Long.valueOf(str).longValue() >= CACHE_TIME)
      {
        FileUtils.deleteDirectory(DOWNLOAD_ROOT_PATH);
        SharePreferenceUtils.set(BaseApplicationImpl.getApplication(), "qcircle_pic_cache_time", String.valueOf(l));
      }
      return;
    }
    SharePreferenceUtils.set(BaseApplicationImpl.getApplication(), "qcircle_pic_cache_time", String.valueOf(l));
  }
  
  private ThreadPoolExecutor createPool(int paramInt1, int paramInt2)
  {
    return new ThreadPoolExecutor(paramInt1, paramInt2, 120L, TimeUnit.SECONDS, new PriorityBlockingQueue(200, new QCircleFeedPicLoader.2(this)), Executors.defaultThreadFactory(), new QCircleFeedPicLoader.3(this));
  }
  
  private void decodeFile(@NotNull Option paramOption, QCircleFeedPicLoader.QCirclePicStateListener paramQCirclePicStateListener)
  {
    String str = getCacheKey(paramOption);
    if ((paramOption.isFromPreload()) && (this.mDecodeTasks.containsKey(str))) {}
    do
    {
      return;
      localPicDeCodeTask = (QCircleFeedPicLoader.PicDeCodeTask)this.mDecodeTasks.get(str);
    } while ((localPicDeCodeTask != null) && (localPicDeCodeTask.mOption.getTargetView() == paramOption.getTargetView()));
    paramOption.mDecodeStartTime = Long.valueOf(System.currentTimeMillis());
    QCircleFeedPicLoader.PicDeCodeTask localPicDeCodeTask = new QCircleFeedPicLoader.PicDeCodeTask(this, paramOption);
    localPicDeCodeTask.setStatusListener(paramQCirclePicStateListener);
    this.mDecodeTasks.put(str, localPicDeCodeTask);
    if (paramOption.isFromPreload())
    {
      this.mPreloadDecodeExecutor.execute(localPicDeCodeTask);
      return;
    }
    this.mDecodeExecutor.execute(localPicDeCodeTask);
  }
  
  private void doDownLoadPic(@NotNull Option paramOption, QCircleFeedPicLoader.QCirclePicStateListener paramQCirclePicStateListener)
  {
    String str = getCacheKey(paramOption);
    if ((paramOption.isFromPreload()) && (this.mDownLoadTasks.containsKey(str))) {}
    do
    {
      return;
      localPicDownLoadTask = (QCircleFeedPicLoader.PicDownLoadTask)this.mDownLoadTasks.get(str);
    } while ((localPicDownLoadTask != null) && (localPicDownLoadTask.mOption.getTargetView() == paramOption.getTargetView()));
    paramOption.mDownLoadStartTime = Long.valueOf(System.currentTimeMillis());
    QCircleFeedPicLoader.PicDownLoadTask localPicDownLoadTask = new QCircleFeedPicLoader.PicDownLoadTask(this, paramOption);
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
    if (mInstance == null) {}
    try
    {
      if (mInstance == null) {
        mInstance = new QCircleFeedPicLoader();
      }
      return mInstance;
    }
    finally {}
  }
  
  private Object getCache(String paramString)
  {
    synchronized (this.mCacheLock)
    {
      paramString = this.sImageCache.get(paramString);
      return paramString;
    }
  }
  
  public static String getUniKeyFromUrl(String paramString)
  {
    int i;
    if (!TextUtils.isEmpty(paramString))
    {
      if (mKeyHashMap.containsKey(paramString)) {
        return (String)mKeyHashMap.get(paramString);
      }
      i = paramString.indexOf("://");
      if (i == -1) {
        break label151;
      }
    }
    label151:
    for (Object localObject2 = paramString.substring(i + 3);; localObject2 = paramString)
    {
      i = ((String)localObject2).indexOf("/");
      Object localObject1 = localObject2;
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
      mKeyHashMap.put(paramString, localObject2);
      return localObject2;
      return "";
    }
  }
  
  private void reportDecodeResult(Option paramOption, int paramInt)
  {
    if (paramOption != null)
    {
      double d = -1.0D;
      if (paramOption.mDecodeStartTime != null) {
        d = (float)(System.currentTimeMillis() - paramOption.mDecodeStartTime.longValue()) / 1000.0F;
      }
      QCircleQualityReporter.reportImageQualityEvent("image_decode_ret", String.valueOf(d), String.valueOf(paramInt), paramOption.getUrl(), paramOption.mPicType);
    }
  }
  
  private void reportDownloadResult(Option paramOption, int paramInt)
  {
    if (paramOption != null)
    {
      double d = -1.0D;
      if (paramOption.mDownLoadStartTime != null) {
        d = (float)(System.currentTimeMillis() - paramOption.mDownLoadStartTime.longValue()) / 1000.0F;
      }
      QCircleQualityReporter.reportImageQualityEvent("image_download_ret", String.valueOf(d), String.valueOf(paramInt), paramOption.getUrl() + "  iP:" + paramOption.getIP(), paramOption.mPicType);
    }
  }
  
  private void reportLoadResult(Option paramOption, int paramInt)
  {
    if (paramOption != null)
    {
      double d = -1.0D;
      if (paramOption.mStartTime != null) {
        d = (float)(System.currentTimeMillis() - paramOption.mStartTime.longValue()) / 1000.0F;
      }
      QCircleQualityReporter.reportImageQualityEvent("image_load_ret", String.valueOf(d), String.valueOf(paramInt), paramOption.getUrl(), paramOption.mLoadType);
    }
  }
  
  private void showDrawable(Option paramOption, Drawable paramDrawable)
  {
    if ((paramOption != null) && (paramDrawable != null))
    {
      if (Looper.getMainLooper() != Looper.myLooper()) {
        break label187;
      }
      if (paramOption.isValid())
      {
        if (paramOption.getTargetView() != null)
        {
          paramOption.getTargetView().setImageDrawable(null);
          paramOption.getTargetView().setImageDrawable(paramDrawable);
        }
        QLog.i(TAG, 1, "seq = " + paramOption.getSeq() + " cacheKey = " + paramOption.getCacheKey() + " showDrawable time " + (System.currentTimeMillis() - paramOption.mStartTime.longValue()) + "pic is valid");
      }
    }
    else
    {
      return;
    }
    QLog.i(TAG, 1, "seq = " + paramOption.getSeq() + " cacheKey = " + paramOption.getCacheKey() + " showDrawable time " + (System.currentTimeMillis() - paramOption.mStartTime.longValue()) + "pic is unValid");
    return;
    label187:
    this.mUIHandler.post(new QCircleFeedPicLoader.6(this, paramOption, paramDrawable));
  }
  
  private void showPic(Option paramOption, Bitmap paramBitmap)
  {
    if ((paramOption != null) && (paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      paramBitmap = bitmapTransferDrawable(paramOption, paramBitmap);
      if (Looper.getMainLooper() != Looper.myLooper()) {
        break label207;
      }
      if (paramOption.isValid())
      {
        if (paramOption.getTargetView() != null)
        {
          paramOption.getTargetView().setImageDrawable(null);
          paramOption.getTargetView().setImageDrawable(paramBitmap);
        }
        reportLoadResult(paramOption, 0);
        QLog.i(TAG, 1, "seq = " + paramOption.getSeq() + " cacheKey = " + paramOption.getCacheKey() + " the total time " + (System.currentTimeMillis() - paramOption.mStartTime.longValue()) + " pic is valid");
      }
    }
    else
    {
      return;
    }
    QLog.i(TAG, 1, "seq = " + paramOption.getSeq() + " cacheKey = " + paramOption.getCacheKey() + " the total time " + (System.currentTimeMillis() - paramOption.mStartTime.longValue()) + " pic is unValid");
    return;
    label207:
    this.mUIHandler.post(new QCircleFeedPicLoader.5(this, paramOption, paramBitmap));
  }
  
  public void cancel(@NotNull String paramString)
  {
    cancelDownload(paramString);
    cancelDecode(paramString);
  }
  
  public void destroy()
  {
    ThreadManager.getSubThreadHandler().post(new QCircleFeedPicLoader.7(this));
  }
  
  public String getCacheKey(Option paramOption)
  {
    if (!TextUtils.isEmpty(paramOption.getUrl()))
    {
      Object localObject2 = MD5Utils.encodeHexStr(getUniKeyFromUrl(paramOption.getUrl()));
      Object localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = MD5Utils.encodeFileHexStr(paramOption.getUrl());
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = paramOption.getUrl();
      }
      localObject1 = new StringBuilder((String)localObject2);
      ((StringBuilder)localObject1).append("#").append(paramOption.getRequestWidth()).append("_").append(paramOption.getRequestHeight());
      paramOption.setCacheKey(((StringBuilder)localObject1).toString());
      return ((StringBuilder)localObject1).toString();
    }
    return "";
  }
  
  public String getPicLocalPath(Option paramOption)
  {
    if (FileUtils.isLocalPath(paramOption.getUrl()))
    {
      localObject1 = paramOption.getUrl();
      paramOption.setLocalPath((String)localObject1);
      return localObject1;
    }
    Object localObject2 = MD5Utils.encodeHexStr(getUniKeyFromUrl(paramOption.getUrl()));
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = MD5Utils.encodeFileHexStr(paramOption.getUrl());
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = paramOption.getUrl();
    }
    localObject1 = DOWNLOAD_ROOT_PATH + (String)localObject2 + ".suf";
    paramOption.setLocalPath((String)localObject1);
    return localObject1;
  }
  
  public String loadImage(@NotNull Option paramOption, QCircleFeedPicLoader.QCirclePicStateListener paramQCirclePicStateListener)
  {
    String str = getCacheKey(paramOption);
    Object localObject = getCache(str);
    paramOption.setSeq(this.mAtomicInteger.getAndIncrement());
    paramOption.mStartTime = Long.valueOf(System.currentTimeMillis());
    QLog.i(TAG, 1, "seq = " + paramOption.getSeq() + " cacheKey = " + paramOption.getCacheKey() + " url = " + paramOption.getUrl() + " isFromPreload:" + paramOption.isFromPreload());
    if ((localObject instanceof Bitmap))
    {
      long l = System.currentTimeMillis();
      paramOption.mLoadType = 0;
      paramOption.setResultBitMap((Bitmap)localObject);
      showPic(paramOption, (Bitmap)localObject);
      if (paramQCirclePicStateListener != null) {
        paramQCirclePicStateListener.onStateChang(STATE_SUCCESS, paramOption);
      }
      QLog.i(TAG, 1, "seq = " + paramOption.getSeq() + " cacheKey = " + paramOption.getCacheKey() + " return in cache: " + paramOption.isFromPreload() + " costTime:" + (System.currentTimeMillis() - l));
      return str;
    }
    this.mDecodeExecutor.execute(new QCircleFeedPicLoader.4(this, paramOption, paramQCirclePicStateListener));
    return str;
  }
  
  public void release()
  {
    this.mDownLoadTasks.clear();
    this.mDecodeTasks.clear();
    this.mDecodeExecutor.getQueue().clear();
    this.mDownLoadExecutor.getQueue().clear();
    this.mPreloadDecodeExecutor.getQueue().clear();
    this.mPreloadDownLoadExecutor.getQueue().clear();
    mKeyHashMap.clear();
    QCirclePicDownLoader.g().release();
    QLog.d(TAG, 1, "feed pic release");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.picload.QCircleFeedPicLoader
 * JD-Core Version:    0.7.0.1
 */