package com.tencent.mobileqq.vas.widget.lottie;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.component.network.DownloaderFactory;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.image.Utils;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.mobileqq.qroute.annotation.PluginInterface;
import com.tencent.mobileqq.vas.VasConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

@Deprecated
@PluginInterface
public class LottieLoader
  implements Handler.Callback
{
  public static final String FILE_DATA_JSON = "data.json";
  public static final String FILE_IMAGES = "images/";
  public static final String FILE_IMAGE_CACHE_PREFIX = "apollo://lottie_";
  private static final int MSG_CODE_PLAY_ANIMATION = 1;
  public static final int STATE_FAILED = 2;
  public static final int STATE_INIT = 0;
  public static final int STATE_LOADING = 1;
  public static final int STATE_RES_DONE = 3;
  public static final String TAG = "LottieLoader";
  private boolean mAutoPlay;
  private WeakReference<Context> mContextRef;
  private LottieLoader.DecoderRunnable mDecoderRunnable = new LottieLoader.DecoderRunnable();
  private Downloader mDownloader;
  private boolean mIsDestroy = false;
  private boolean mIsLottieJsonLoaded = false;
  private String mLocalZipPath;
  private WeakReference<DiniFlyAnimationView> mLottieAnimView;
  private WeakReferenceHandler mMainHandler = new WeakReferenceHandler(paramContext.getMainLooper(), this);
  protected int mState = 0;
  private String mZipUrl;
  
  public LottieLoader(Context paramContext)
  {
    this.mContextRef = new WeakReference(paramContext);
    this.mDownloader = DownloaderFactory.getInstance(paramContext).getCommonDownloader();
  }
  
  private void init(boolean paramBoolean, File paramFile, String paramString)
  {
    if (paramBoolean) {}
    try
    {
      unZipFile(paramFile, paramString);
      if (!isLottieAnimJsonDone(paramString))
      {
        QLog.e("LottieLoader", 1, "Lottie Anim data.json not exit");
        return;
      }
      this.mState = 3;
      stop();
      sendPlayAnimMsg(paramString);
      return;
    }
    catch (Exception paramFile)
    {
      QLog.e("LottieLoader", 2, paramFile.getMessage());
      this.mState = 2;
    }
  }
  
  public static String makeApolloZipPath(String paramString)
  {
    paramString = Utils.Crc64String(paramString);
    String str = VasConstant.c;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append(paramString);
    localStringBuilder.append(".zip");
    return localStringBuilder.toString();
  }
  
  private void sendPlayAnimMsg(String paramString)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    Bundle localBundle = new Bundle();
    localBundle.putString("folder", paramString);
    localMessage.setData(localBundle);
    this.mMainHandler.sendMessage(localMessage);
  }
  
  private void setZipData(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    this.mAutoPlay = paramBoolean;
    if (!paramString2.equals(this.mLocalZipPath))
    {
      this.mLocalZipPath = paramString2;
      this.mState = 0;
    }
    paramString2 = zipPath2UnzipDir(this.mLocalZipPath);
    new File(paramString2).mkdirs();
    if (QLog.isColorLevel()) {
      QLog.d("LottieLoader", 2, new Object[] { "setZipData mState:", Integer.valueOf(this.mState), ",zipUrl:", paramString1, ",localZipPath:", this.mLocalZipPath });
    }
    paramBoolean = isLottieAnimJsonDone(paramString2);
    if (!paramBoolean)
    {
      QLog.w("LottieLoader", 1, "setZipData Lottie Anim data.json not exit");
      this.mState = 0;
    }
    int i = this.mState;
    if ((i != 2) && (i != 0))
    {
      if (i == 3) {
        init(false, null, paramString2);
      }
    }
    else
    {
      this.mIsLottieJsonLoaded = false;
      File localFile = new File(this.mLocalZipPath);
      if (paramBoolean)
      {
        init(false, localFile, paramString2);
        return;
      }
      if (localFile.exists())
      {
        init(true, localFile, paramString2);
        return;
      }
      download(paramString1, this.mLocalZipPath, paramString2);
    }
  }
  
  private void unZipFile(File paramFile, String paramString)
  {
    if ((paramFile.exists()) && (!TextUtils.isEmpty(paramString)) && (ZipUtils.getUncompressedFileSize(paramFile.getAbsolutePath()) < 838860800L)) {
      ZipUtils.unZipFile(paramFile, paramString);
    }
  }
  
  private String zipPath2UnzipDir(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      int i = paramString.lastIndexOf(".zip");
      String str = paramString;
      if (i > 0) {
        str = paramString.substring(0, i);
      }
      paramString = new StringBuilder();
      paramString.append(str);
      paramString.append(File.separator);
      return paramString.toString();
    }
    return "";
  }
  
  public void destroy()
  {
    stop();
    this.mIsLottieJsonLoaded = false;
    this.mIsDestroy = true;
  }
  
  protected void download(String paramString1, String paramString2, String paramString3)
  {
    this.mState = 1;
    paramString3 = new LottieLoader.2(this, paramString2, paramString3);
    this.mDownloader.download(paramString1, paramString2, false, paramString3);
  }
  
  public void fromFileWithCacheBitmap(Context paramContext, @NonNull DiniFlyAnimationView paramDiniFlyAnimationView, String paramString, boolean paramBoolean)
  {
    try
    {
      if (this.mLottieAnimView == null) {
        this.mLottieAnimView = new WeakReference(paramDiniFlyAnimationView);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("data.json");
      fromInputStreamWithCacheBitmap(paramContext, paramDiniFlyAnimationView, paramString, new FileInputStream(localStringBuilder.toString()), paramBoolean);
      return;
    }
    catch (Exception paramContext)
    {
      paramDiniFlyAnimationView = new StringBuilder();
      paramDiniFlyAnimationView.append("fromFileWithCacheBitmap:");
      paramDiniFlyAnimationView.append(paramContext);
      QLog.e("LottieLoader", 1, paramDiniFlyAnimationView.toString());
    }
  }
  
  public void fromInputStreamWithCacheBitmap(Context paramContext, @NonNull DiniFlyAnimationView paramDiniFlyAnimationView, String paramString, InputStream paramInputStream, boolean paramBoolean)
  {
    if (paramContext != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("LottieLoader", 2, new Object[] { "fromFileWithCacheBitmap animPathFolder:", paramString });
      }
      if (paramDiniFlyAnimationView.isAnimating()) {
        return;
      }
      if ((this.mIsLottieJsonLoaded) && (paramBoolean))
      {
        paramDiniFlyAnimationView.playAnimation();
        return;
      }
      try
      {
        LottieLoader.1 local1 = new LottieLoader.1(this, paramDiniFlyAnimationView, paramBoolean);
        Bundle localBundle = new Bundle();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("apollo://lottie_");
        if (TextUtils.isEmpty(this.mZipUrl)) {
          localObject = paramString;
        } else {
          localObject = this.mZipUrl;
        }
        localStringBuilder.append(Utils.Crc64String((String)localObject));
        localBundle.putString("key", localStringBuilder.toString());
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("images/");
        localBundle.putString("path", ((StringBuilder)localObject).toString());
        LottieComposition.Factory.fromInputStreamWithCacheBitmap(paramContext, paramInputStream, paramDiniFlyAnimationView.getLottieDrawable(), local1, localBundle, getMemoryCache());
        return;
      }
      catch (Exception paramContext)
      {
        paramDiniFlyAnimationView = new StringBuilder();
        paramDiniFlyAnimationView.append("playApolloGameBoxLottieAnim:");
        paramDiniFlyAnimationView.append(paramContext);
        QLog.e("LottieLoader", 1, paramDiniFlyAnimationView.toString());
      }
    }
  }
  
  public void fromNetworkWithCacheBitmap(@NonNull DiniFlyAnimationView paramDiniFlyAnimationView, String paramString)
  {
    fromNetworkWithCacheBitmap(paramDiniFlyAnimationView, paramString, makeApolloZipPath(paramString), true);
  }
  
  public void fromNetworkWithCacheBitmap(@NonNull DiniFlyAnimationView paramDiniFlyAnimationView, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    this.mLottieAnimView = new WeakReference(paramDiniFlyAnimationView);
    this.mZipUrl = paramString1;
    this.mDecoderRunnable.setZipData(this, paramString1, paramString2, paramBoolean);
    ThreadManager.removeJobFromThreadPool(this.mDecoderRunnable, 16);
    ThreadManager.excute(this.mDecoderRunnable, 16, null, true);
  }
  
  protected MQLruCache<String, Object> getMemoryCache()
  {
    return GlobalImageCache.a;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      WeakReference localWeakReference = this.mContextRef;
      if ((localWeakReference != null) && (localWeakReference.get() != null))
      {
        localWeakReference = this.mLottieAnimView;
        if ((localWeakReference != null) && (localWeakReference.get() != null))
        {
          paramMessage = paramMessage.getData().getString("folder");
          fromFileWithCacheBitmap((Context)this.mContextRef.get(), (DiniFlyAnimationView)this.mLottieAnimView.get(), paramMessage, this.mAutoPlay);
        }
      }
    }
    return false;
  }
  
  public boolean isLottieAnimJsonDone(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("data.json");
    return new File(localStringBuilder.toString()).exists();
  }
  
  protected void onDownloadFinish(boolean paramBoolean, String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDownloadFinish，result:");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" url:");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" zipFile:");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(" folder:");
      localStringBuilder.append(paramString3);
      QLog.d("LottieLoader", 2, localStringBuilder.toString());
    }
    paramString1 = this.mLocalZipPath;
    if ((paramString1 != null) && (!paramString1.equals(paramString2)))
    {
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("onDownloadFinish，zipFile unEqual mLocalZipPath:");
        paramString1.append(this.mLocalZipPath);
        QLog.d("LottieLoader", 2, paramString1.toString());
      }
      return;
    }
    if (paramBoolean)
    {
      paramString1 = new File(paramString2);
      if (paramString1.exists())
      {
        init(true, paramString1, paramString3);
        return;
      }
      this.mState = 2;
      return;
    }
    this.mState = 2;
  }
  
  public void stop()
  {
    ThreadManager.getUIHandler().post(new LottieLoader.3(this));
    WeakReferenceHandler localWeakReferenceHandler = this.mMainHandler;
    if (localWeakReferenceHandler != null) {
      localWeakReferenceHandler.removeCallbacksAndMessages(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.widget.lottie.LottieLoader
 * JD-Core Version:    0.7.0.1
 */