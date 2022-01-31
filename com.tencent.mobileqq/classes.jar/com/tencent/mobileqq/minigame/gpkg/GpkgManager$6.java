package com.tencent.mobileqq.minigame.gpkg;

import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader.DownloadListener;

final class GpkgManager$6
  implements Downloader.DownloadListener
{
  GpkgManager$6(MiniGamePkg paramMiniGamePkg, String paramString1, String paramString2, GpkgManager.OnInitGpkgListener paramOnInitGpkgListener) {}
  
  public void onDownloadCanceled(String paramString)
  {
    GpkgManager.access$200(false, 0, 0L, 0.0F, "", null, this.val$miniGamePkg, this.val$savePath, this.val$subRoot, this.val$listener);
  }
  
  public void onDownloadFailed(String paramString, DownloadResult paramDownloadResult)
  {
    GpkgManager.access$200(false, -1, 0L, 0.0F, paramString, paramDownloadResult, this.val$miniGamePkg, this.val$savePath, this.val$subRoot, this.val$listener);
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat)
  {
    GpkgManager.access$200(false, 2, paramLong, paramFloat, paramString, null, this.val$miniGamePkg, this.val$savePath, this.val$subRoot, this.val$listener);
  }
  
  public void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult)
  {
    String str = GpkgManager.access$000(this.val$savePath);
    GpkgManager.access$200(true, 1, 0L, 0.0F, paramString, paramDownloadResult, this.val$miniGamePkg, str, this.val$subRoot, this.val$listener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.gpkg.GpkgManager.6
 * JD-Core Version:    0.7.0.1
 */