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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("processSelectAdWithUncachedAd download newCachedAdInfo.url= ");
    localStringBuilder.append(this.a.url);
    localStringBuilder.append(" start");
    QLog.d("MiniLoadingAdManager", 1, localStringBuilder.toString());
    MiniappDownloadUtil.getInstance().download(this.a.url, this.a.filePath, false, this.b, Downloader.DownloadMode.OkHttpMode, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.AdProxyImpl.6
 * JD-Core Version:    0.7.0.1
 */