package com.tencent.qqmini.sdk.core.manager;

import com.tencent.qqmini.sdk.core.utils.ParcelableUtil;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener.DownloadResult;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.io.File;
import java.util.List;
import java.util.Map;

class PreCacheManager$3
  implements DownloaderProxy.DownloadListener
{
  PreCacheManager$3(PreCacheManager paramPreCacheManager, String paramString1, String paramString2, PreCacheManager.OnCacheListener paramOnCacheListener, PreCacheManager.PreCacheDescData paramPreCacheDescData, String paramString3, MiniAppInfo paramMiniAppInfo, String paramString4) {}
  
  public void onDownloadFailed(int paramInt, String paramString)
  {
    paramString = new StringBuilder();
    paramString.append(this.val$logPrefix);
    paramString.append(" fetch PreCache url failed! url=");
    paramString.append(this.val$queryUrl);
    QMLog.i("minisdk-start_PreCacheManager", paramString.toString());
    paramString = this.val$listener;
    if (paramString != null) {
      paramString.onCacheUpdated(false, false);
    }
  }
  
  public void onDownloadHeadersReceived(int paramInt, Map<String, List<String>> paramMap) {}
  
  public void onDownloadProgress(float paramFloat, long paramLong1, long paramLong2) {}
  
  public void onDownloadSucceed(int paramInt, String paramString, DownloaderProxy.DownloadListener.DownloadResult paramDownloadResult)
  {
    try
    {
      paramString = new File(paramString);
      paramDownloadResult = new StringBuilder();
      paramDownloadResult.append(this.val$logPrefix);
      paramDownloadResult.append(" fetch PreCache succful. url");
      paramDownloadResult.append(this.val$queryUrl);
      paramDownloadResult.append(" length=");
      paramDownloadResult.append(paramString.length());
      QMLog.i("minisdk-start_PreCacheManager", paramDownloadResult.toString());
      if (paramString.length() <= PreCacheManager.access$200())
      {
        this.val$cacheInfo.timeStamp = System.currentTimeMillis();
        this.val$cacheInfo.filePath = this.val$tmpFilePath;
        paramString = this.val$miniAppConfig.appId;
        paramDownloadResult = this.val$cacheType;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.val$cacheInfo.getCacheKey(this.val$cacheType));
        localStringBuilder.append("_index");
        paramString = MiniAppFileManager.getPreCacheFilePath(paramString, paramDownloadResult, localStringBuilder.toString());
        ParcelableUtil.writeParcelableToFile(this.val$cacheInfo, paramString);
        paramDownloadResult = new StringBuilder();
        paramDownloadResult.append(this.val$logPrefix);
        paramDownloadResult.append(" save PreCache info. index=");
        paramDownloadResult.append(paramString);
        paramDownloadResult.append(" content=");
        paramDownloadResult.append(this.val$tmpFilePath);
        QMLog.i("minisdk-start_PreCacheManager", paramDownloadResult.toString());
        if (this.val$listener != null)
        {
          this.val$listener.onCacheUpdated(true, true);
          return;
        }
      }
    }
    catch (Throwable paramString)
    {
      paramDownloadResult = new StringBuilder();
      paramDownloadResult.append(this.val$logPrefix);
      paramDownloadResult.append(" fetch PreCache exception!");
      QMLog.i("minisdk-start_PreCacheManager", paramDownloadResult.toString(), paramString);
      paramString = this.val$listener;
      if (paramString != null) {
        paramString.onCacheUpdated(false, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.manager.PreCacheManager.3
 * JD-Core Version:    0.7.0.1
 */