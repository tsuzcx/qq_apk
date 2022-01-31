package com.tencent.mobileqq.minigame.gpkg;

import com.tencent.mobileqq.mini.apkg.MiniAppInfo;

final class GpkgManager$5
  implements GpkgManager.OnInitGpkgListener
{
  GpkgManager$5(GpkgManager.OnInitGpkgListener paramOnInitGpkgListener) {}
  
  public void onDownloadGpkgProgress(MiniAppInfo paramMiniAppInfo, float paramFloat, long paramLong) {}
  
  public void onInitGpkgInfo(int paramInt, MiniGamePkg paramMiniGamePkg, String paramString)
  {
    if (paramInt == 0) {
      if (this.val$listener != null) {
        this.val$listener.onInitGpkgInfo(0, paramMiniGamePkg, null);
      }
    }
    while (this.val$listener == null) {
      return;
    }
    this.val$listener.onInitGpkgInfo(paramInt, null, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.gpkg.GpkgManager.5
 * JD-Core Version:    0.7.0.1
 */