package com.tencent.mobileqq.mini.manager;

import com.tencent.component.network.downloader.Downloader.DownloadListener;
import com.tencent.component.network.downloader.Downloader.DownloadMode;
import com.tencent.mobileqq.mini.reuse.MiniappDownloadUtil;
import com.tencent.qphone.base.util.QLog;

class MiniLoadingAdManager$3
  implements Runnable
{
  MiniLoadingAdManager$3(MiniLoadingAdManager paramMiniLoadingAdManager, MiniLoadingAdManager.CachedAdInfo paramCachedAdInfo, Downloader.DownloadListener paramDownloadListener) {}
  
  public void run()
  {
    QLog.d("MiniLoadingAdManager", 1, "processSelectAdWithUncachedAd download newCachedAdInfo.url= " + this.val$newCachedAdInfo.url + " start");
    MiniappDownloadUtil.getInstance().download(this.val$newCachedAdInfo.url, this.val$newCachedAdInfo.filePath, false, this.val$listener, Downloader.DownloadMode.OkHttpMode, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.manager.MiniLoadingAdManager.3
 * JD-Core Version:    0.7.0.1
 */