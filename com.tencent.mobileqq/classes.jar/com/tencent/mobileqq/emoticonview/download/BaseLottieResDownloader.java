package com.tencent.mobileqq.emoticonview.download;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.emoticonview.anisticker.AniStickerHelper.Builder;
import com.tencent.mobileqq.emoticonview.anisticker.AniStickerLottie;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rlottie.AXrLottie.Loader;
import com.tencent.rlottie.AXrLottieDrawable;
import com.tencent.util.UiThreadUtil;
import mqq.app.MobileQQ;

public abstract class BaseLottieResDownloader<T>
  implements IEmoticonLottieResDownloader
{
  protected static final String TAG = "BaseLottieResDownloader";
  
  public abstract void addReloadDrawable();
  
  public abstract void downloadSvgRes();
  
  public abstract String getCacheKey();
  
  public abstract String getFilePath();
  
  public AXrLottieDrawable loadLottie(Context paramContext, String paramString, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (AniStickerLottie.cacheEnabled())) {
      paramBoolean1 = true;
    } else {
      paramBoolean1 = false;
    }
    return AXrLottie.Loader.a(paramContext, paramString, paramInt1, paramInt2, paramBoolean1, paramBoolean2);
  }
  
  public void loadLottieRes(String paramString, AniStickerHelper.Builder paramBuilder, LoadListener paramLoadListener)
  {
    if (checkFileExists()) {}
    for (;;)
    {
      try
      {
        BaseApplication localBaseApplication = MobileQQ.getContext();
        String str = getFilePath();
        int i = paramBuilder.viewWidth;
        int j = paramBuilder.viewHeight;
        if (paramBuilder.showLastFrame) {
          break label119;
        }
        bool = true;
        runOnMainThread(new BaseLottieResDownloader.1(this, paramLoadListener, loadLottie(localBaseApplication, str, i, j, bool, true)));
      }
      catch (Exception paramBuilder)
      {
        runOnMainThread(new BaseLottieResDownloader.2(this, paramLoadListener, paramBuilder));
      }
      trySvgDownloadIfNeed(paramString);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("BaseLottieResDownloader", 2, "lottie file no found.");
      }
      addReloadDrawable();
      onLottieResLoading(paramLoadListener);
      return;
      label119:
      boolean bool = false;
    }
  }
  
  protected void onLottieResLoading(LoadListener paramLoadListener)
  {
    if (paramLoadListener == null) {
      return;
    }
    runOnMainThread(new BaseLottieResDownloader.3(this, paramLoadListener));
  }
  
  public void runOnMainThread(Runnable paramRunnable)
  {
    UiThreadUtil.c(paramRunnable);
  }
  
  public abstract void setOptions(T paramT);
  
  protected void trySvgDownloadIfNeed(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (!FileUtils.fileExists(paramString))) {
      downloadSvgRes();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.download.BaseLottieResDownloader
 * JD-Core Version:    0.7.0.1
 */