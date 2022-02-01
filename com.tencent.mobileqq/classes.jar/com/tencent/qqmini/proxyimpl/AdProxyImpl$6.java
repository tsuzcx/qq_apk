package com.tencent.qqmini.proxyimpl;

import com.tencent.component.network.downloader.Downloader.DownloadListener;
import com.tencent.component.network.downloader.Downloader.DownloadMode;
import com.tencent.mobileqq.mini.manager.MiniLoadingAdManager.CachedAdInfo;
import com.tencent.mobileqq.mini.reuse.MiniappDownloadUtil;
import com.tencent.qphone.base.util.QLog;

class AdProxyImpl$6
  implements Runnable
{
  AdProxyImpl$6(AdProxyImpl paramAdProxyImpl, MiniLoadingAdManager.CachedAdInfo paramCachedAdInfo, Downloader.DownloadListener paramDownloadListener) {}
  
  public void run()
  {
    QLog.d("MiniLoadingAdManager", 1, "processSelectAdWithUncachedAd download newCachedAdInfo.url= " + this.jdField_a_of_type_ComTencentMobileqqMiniManagerMiniLoadingAdManager$CachedAdInfo.url + " start");
    MiniappDownloadUtil.getInstance().download(this.jdField_a_of_type_ComTencentMobileqqMiniManagerMiniLoadingAdManager$CachedAdInfo.url, this.jdField_a_of_type_ComTencentMobileqqMiniManagerMiniLoadingAdManager$CachedAdInfo.filePath, false, this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener, Downloader.DownloadMode.OkHttpMode, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.AdProxyImpl.6
 * JD-Core Version:    0.7.0.1
 */