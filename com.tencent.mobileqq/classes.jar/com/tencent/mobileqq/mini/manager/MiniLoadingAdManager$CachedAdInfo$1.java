package com.tencent.mobileqq.mini.manager;

import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import com.tencent.qphone.base.util.QLog;

class MiniLoadingAdManager$CachedAdInfo$1
  implements Downloader.DownloadListener
{
  MiniLoadingAdManager$CachedAdInfo$1(MiniLoadingAdManager.CachedAdInfo paramCachedAdInfo) {}
  
  public void onDownloadCanceled(String paramString) {}
  
  public void onDownloadFailed(String paramString, DownloadResult paramDownloadResult) {}
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat) {}
  
  public void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult)
  {
    QLog.d("MiniLoadingAdManager", 1, "onDownloadSucceed url：" + paramString + " filePath:" + this.this$0.filePath);
    MiniLoadingAdManager.CachedAdInfo.access$500(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.manager.MiniLoadingAdManager.CachedAdInfo.1
 * JD-Core Version:    0.7.0.1
 */