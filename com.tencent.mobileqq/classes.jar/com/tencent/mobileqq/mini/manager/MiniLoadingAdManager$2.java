package com.tencent.mobileqq.mini.manager;

import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.qphone.base.util.QLog;

class MiniLoadingAdManager$2
  implements Downloader.DownloadListener
{
  MiniLoadingAdManager$2(MiniLoadingAdManager paramMiniLoadingAdManager, MiniLoadingAdManager.OnChooseAdEndListener paramOnChooseAdEndListener, MiniLoadingAdManager.CachedAdInfo paramCachedAdInfo, GdtAd paramGdtAd) {}
  
  public void onDownloadCanceled(String paramString)
  {
    QLog.d("MiniLoadingAdManager", 1, "processSelectAdWithUncachedAd download url= " + paramString + " canceled");
    this.val$onChooseAdEndListener.onDownloadAdEnd(null, null);
  }
  
  public void onDownloadFailed(String paramString, DownloadResult paramDownloadResult)
  {
    QLog.d("MiniLoadingAdManager", 1, "processSelectAdWithUncachedAd download url= " + paramString + " failed");
    this.val$onChooseAdEndListener.onDownloadAdEnd(null, null);
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat) {}
  
  public void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult)
  {
    QLog.d("MiniLoadingAdManager", 1, "processSelectAdWithUncachedAd download url= " + paramString + " succeed");
    this.val$onChooseAdEndListener.onDownloadAdEnd(this.val$newCachedAdInfo.filePath, this.val$adInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.manager.MiniLoadingAdManager.2
 * JD-Core Version:    0.7.0.1
 */