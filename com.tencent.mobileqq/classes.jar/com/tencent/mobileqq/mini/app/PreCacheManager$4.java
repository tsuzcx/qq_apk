package com.tencent.mobileqq.mini.app;

import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.DownloadResult.Content;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.mobileqq.mini.util.ParcelableUtil;
import com.tencent.qphone.base.util.QLog;

class PreCacheManager$4
  implements Downloader.DownloadListener
{
  PreCacheManager$4(PreCacheManager paramPreCacheManager, String paramString1, PreCacheManager.OnCacheListener paramOnCacheListener, PreCacheManager.PreCacheDescData paramPreCacheDescData, String paramString2, MiniAppConfig paramMiniAppConfig, String paramString3) {}
  
  public void onDownloadCanceled(String paramString)
  {
    QLog.i("miniapp-start_PreCacheManager", 1, this.val$logPrefix + " fetch PreCache url canceled! url=" + paramString);
    if (this.val$listener != null) {
      this.val$listener.onCacheUpdated(false, false);
    }
  }
  
  public void onDownloadFailed(String paramString, DownloadResult paramDownloadResult)
  {
    QLog.i("miniapp-start_PreCacheManager", 1, this.val$logPrefix + " fetch PreCache url failed! url=" + paramString);
    if (this.val$listener != null) {
      this.val$listener.onCacheUpdated(false, false);
    }
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat) {}
  
  public void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult)
  {
    try
    {
      QLog.i("miniapp-start_PreCacheManager", 1, this.val$logPrefix + " fetch PreCache succful. url" + paramString + " length=" + paramDownloadResult.getContent().length);
      if (paramDownloadResult.getContent().length <= PreCacheManager.access$200(this.this$0))
      {
        this.val$cacheInfo.timeStamp = System.currentTimeMillis();
        this.val$cacheInfo.filePath = this.val$tmpFilePath;
        MiniAppFileManager.getInstance();
        paramString = MiniAppFileManager.getPreCacheFilePath(this.val$miniAppConfig.config.appId, this.val$cacheType, this.val$cacheInfo.getCacheKey() + "_index");
        ParcelableUtil.writeParcelableToFile(this.val$cacheInfo, paramString);
        QLog.i("miniapp-start_PreCacheManager", 1, this.val$logPrefix + " save PreCache info. index=" + paramString + " content=" + this.val$tmpFilePath);
        if (this.val$listener != null) {
          this.val$listener.onCacheUpdated(true, true);
        }
      }
      return;
    }
    catch (Throwable paramString)
    {
      do
      {
        QLog.i("miniapp-start_PreCacheManager", 1, this.val$logPrefix + " fetch PreCache exception!", paramString);
      } while (this.val$listener == null);
      this.val$listener.onCacheUpdated(false, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.app.PreCacheManager.4
 * JD-Core Version:    0.7.0.1
 */