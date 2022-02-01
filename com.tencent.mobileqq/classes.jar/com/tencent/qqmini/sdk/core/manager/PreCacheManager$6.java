package com.tencent.qqmini.sdk.core.manager;

import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener.DownloadResult;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.List;
import java.util.Map;

class PreCacheManager$6
  implements DownloaderProxy.DownloadListener
{
  PreCacheManager$6(PreCacheManager paramPreCacheManager, String paramString1, String paramString2) {}
  
  public void onDownloadFailed(int paramInt, String paramString)
  {
    paramString = new StringBuilder();
    paramString.append("[Resource Cache] download Resource url failed! url=");
    paramString.append(this.val$url);
    paramString.append(" path=");
    paramString.append(this.val$path);
    QMLog.i("minisdk-start_PreCacheManager", paramString.toString());
  }
  
  public void onDownloadHeadersReceived(int paramInt, Map<String, List<String>> paramMap) {}
  
  public void onDownloadProgress(float paramFloat, long paramLong1, long paramLong2) {}
  
  public void onDownloadSucceed(int paramInt, String paramString, DownloaderProxy.DownloadListener.DownloadResult paramDownloadResult)
  {
    paramString = new StringBuilder();
    paramString.append("[Resource Cache] download Resource url succeed! url=");
    paramString.append(this.val$url);
    QMLog.i("minisdk-start_PreCacheManager", paramString.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.manager.PreCacheManager.6
 * JD-Core Version:    0.7.0.1
 */