package com.tencent.qqmini.sdk.core.manager;

import com.tencent.qqmini.sdk.core.utils.ParcelableUtil;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener.DownloadResult;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.io.File;
import java.util.List;
import java.util.Map;

class PreCacheManager$4
  implements DownloaderProxy.DownloadListener
{
  PreCacheManager$4(PreCacheManager paramPreCacheManager, String paramString1, String paramString2, PreCacheManager.OnCacheListener paramOnCacheListener, PreCacheManager.PreCacheDescData paramPreCacheDescData, String paramString3, MiniAppInfo paramMiniAppInfo, String paramString4) {}
  
  public void onDownloadFailed(int paramInt, String paramString)
  {
    QMLog.i("minisdk-start_PreCacheManager", this.val$logPrefix + " fetch PreCache url failed! url=" + this.val$queryUrl);
    if (this.val$listener != null) {
      this.val$listener.onCacheUpdated(false, false);
    }
  }
  
  public void onDownloadHeadersReceived(int paramInt, Map<String, List<String>> paramMap) {}
  
  public void onDownloadProgress(float paramFloat, long paramLong1, long paramLong2) {}
  
  public void onDownloadSucceed(int paramInt, String paramString, DownloaderProxy.DownloadListener.DownloadResult paramDownloadResult)
  {
    try
    {
      paramString = new File(paramString);
      QMLog.i("minisdk-start_PreCacheManager", this.val$logPrefix + " fetch PreCache succful. url" + this.val$queryUrl + " length=" + paramString.length());
      if (paramString.length() <= PreCacheManager.access$200())
      {
        this.val$cacheInfo.timeStamp = System.currentTimeMillis();
        this.val$cacheInfo.filePath = this.val$tmpFilePath;
        paramString = MiniAppFileManager.getPreCacheFilePath(this.val$miniAppConfig.appId, this.val$cacheType, this.val$cacheInfo.getCacheKey(this.val$cacheType) + "_index");
        ParcelableUtil.writeParcelableToFile(this.val$cacheInfo, paramString);
        QMLog.i("minisdk-start_PreCacheManager", this.val$logPrefix + " save PreCache info. index=" + paramString + " content=" + this.val$tmpFilePath);
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
        QMLog.i("minisdk-start_PreCacheManager", this.val$logPrefix + " fetch PreCache exception!", paramString);
      } while (this.val$listener == null);
      this.val$listener.onCacheUpdated(false, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.manager.PreCacheManager.4
 * JD-Core Version:    0.7.0.1
 */