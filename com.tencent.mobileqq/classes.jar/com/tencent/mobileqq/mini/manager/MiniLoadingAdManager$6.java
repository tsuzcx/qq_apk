package com.tencent.mobileqq.mini.manager;

import com.tencent.component.network.downloader.Downloader.DownloadMode;
import com.tencent.mobileqq.mini.reuse.MiniappDownloadUtil;

final class MiniLoadingAdManager$6
  implements Runnable
{
  MiniLoadingAdManager$6(MiniLoadingAdManager.CachedAdInfo paramCachedAdInfo) {}
  
  public void run()
  {
    MiniappDownloadUtil.getInstance().download(this.val$cachedAdInfo.url, this.val$cachedAdInfo.filePath, false, MiniLoadingAdManager.CachedAdInfo.access$400(this.val$cachedAdInfo), Downloader.DownloadMode.OkHttpMode, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.manager.MiniLoadingAdManager.6
 * JD-Core Version:    0.7.0.1
 */