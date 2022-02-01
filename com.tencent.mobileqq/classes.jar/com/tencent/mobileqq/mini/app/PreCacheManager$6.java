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
    QLog.i("miniapp-start_PreCacheManager", 1, "[Resource Cache] download Resource url canceled! url=" + paramString);
  }
  
  public void onDownloadFailed(String paramString, DownloadResult paramDownloadResult)
  {
    QLog.i("miniapp-start_PreCacheManager", 1, "[Resource Cache] download Resource url failed! url=" + paramString + " path=" + this.val$path);
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat) {}
  
  public void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult)
  {
    QLog.i("miniapp-start_PreCacheManager", 1, "[Resource Cache] download Resource url succeed! url=" + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.app.PreCacheManager.6
 * JD-Core Version:    0.7.0.1
 */