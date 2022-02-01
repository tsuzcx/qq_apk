package com.tencent.qqmini.proxyimpl;

import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import com.tencent.mobileqq.mini.manager.MiniLoadingAdManager.CachedAdInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.ILoadingAdListener;

class AdProxyImpl$5
  implements Downloader.DownloadListener
{
  AdProxyImpl$5(AdProxyImpl paramAdProxyImpl, AdProxy.ILoadingAdListener paramILoadingAdListener, String paramString, long paramLong, MiniLoadingAdManager.CachedAdInfo paramCachedAdInfo) {}
  
  public void onDownloadCanceled(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("processSelectAdWithUncachedAd download url= ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" canceled");
    QLog.d("MiniLoadingAdManager", 1, localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$ILoadingAdListener.onDownloadAdEnd(null, -1L, null);
  }
  
  public void onDownloadFailed(String paramString, DownloadResult paramDownloadResult)
  {
    paramDownloadResult = new StringBuilder();
    paramDownloadResult.append("processSelectAdWithUncachedAd download url= ");
    paramDownloadResult.append(paramString);
    paramDownloadResult.append(" failed");
    QLog.d("MiniLoadingAdManager", 1, paramDownloadResult.toString());
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$ILoadingAdListener.onDownloadAdEnd(null, -1L, null);
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat) {}
  
  public void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult)
  {
    paramDownloadResult = new StringBuilder();
    paramDownloadResult.append("processSelectAdWithUncachedAd download url= ");
    paramDownloadResult.append(paramString);
    paramDownloadResult.append(" succeed");
    QLog.d("MiniLoadingAdManager", 1, paramDownloadResult.toString());
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$ILoadingAdListener.onDownloadAdEnd(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqMiniManagerMiniLoadingAdManager$CachedAdInfo.filePath);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.AdProxyImpl.5
 * JD-Core Version:    0.7.0.1
 */