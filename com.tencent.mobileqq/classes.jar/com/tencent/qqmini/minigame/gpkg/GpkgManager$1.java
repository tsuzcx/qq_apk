package com.tencent.qqmini.minigame.gpkg;

import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

final class GpkgManager$1
  implements GpkgManager.OnInitGpkgListener
{
  GpkgManager$1(MiniAppInfo paramMiniAppInfo, GpkgManager.OnInitGpkgListener paramOnInitGpkgListener) {}
  
  public void onDownloadGpkgProgress(MiniAppInfo paramMiniAppInfo, float paramFloat, long paramLong)
  {
    GpkgManager.OnInitGpkgListener localOnInitGpkgListener = this.val$listener;
    if (localOnInitGpkgListener != null) {
      localOnInitGpkgListener.onDownloadGpkgProgress(paramMiniAppInfo, paramFloat, paramLong);
    }
  }
  
  public void onInitGpkgInfo(int paramInt, MiniGamePkg paramMiniGamePkg, String paramString, GpkgManager.Info paramInfo)
  {
    ApkgMainProcessManager.removeSubProcessLoadTask(this.val$gameConfig);
    GpkgManager.OnInitGpkgListener localOnInitGpkgListener = this.val$listener;
    if (localOnInitGpkgListener != null) {
      localOnInitGpkgListener.onInitGpkgInfo(paramInt, paramMiniGamePkg, paramString, paramInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.minigame.gpkg.GpkgManager.1
 * JD-Core Version:    0.7.0.1
 */