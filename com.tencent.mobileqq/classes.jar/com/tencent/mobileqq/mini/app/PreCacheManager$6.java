package com.tencent.mobileqq.mini.app;

import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import com.tencent.qphone.base.util.QLog;

class PreCacheManager$6
  implements Downloader.DownloadListener
{
  PreCacheManager$6(PreCacheManager paramPreCacheManager, String paramString) {}
  
  public void onDownloadCanceled(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[Resource Cache] download Resource url canceled! url=");
    localStringBuilder.append(paramString);
    QLog.i("miniapp-start_PreCacheManager", 1, localStringBuilder.toString());
  }
  
  public void onDownloadFailed(String paramString, DownloadResult paramDownloadResult)
  {
    paramDownloadResult = new StringBuilder();
    paramDownloadResult.append("[Resource Cache] download Resource url failed! url=");
    paramDownloadResult.append(paramString);
    paramDownloadResult.append(" path=");
    paramDownloadResult.append(this.val$path);
    QLog.i("miniapp-start_PreCacheManager", 1, paramDownloadResult.toString());
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat) {}
  
  public void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult)
  {
    paramDownloadResult = new StringBuilder();
    paramDownloadResult.append("[Resource Cache] download Resource url succeed! url=");
    paramDownloadResult.append(paramString);
    QLog.i("miniapp-start_PreCacheManager", 1, paramDownloadResult.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.app.PreCacheManager.6
 * JD-Core Version:    0.7.0.1
 */