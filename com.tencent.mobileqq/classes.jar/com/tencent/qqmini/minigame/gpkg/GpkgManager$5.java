package com.tencent.qqmini.minigame.gpkg;

import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

final class GpkgManager$5
  implements GpkgManager.OnInitGpkgListener
{
  GpkgManager$5(GpkgManager.OnInitGpkgListener paramOnInitGpkgListener) {}
  
  public void onDownloadGpkgProgress(MiniAppInfo paramMiniAppInfo, float paramFloat, long paramLong) {}
  
  public void onInitGpkgInfo(int paramInt, MiniGamePkg paramMiniGamePkg, String paramString, GpkgManager.Info paramInfo)
  {
    if (paramInt == 0)
    {
      paramString = this.val$listener;
      if (paramString != null) {
        paramString.onInitGpkgInfo(0, paramMiniGamePkg, null, paramInfo);
      }
    }
    else
    {
      paramMiniGamePkg = this.val$listener;
      if (paramMiniGamePkg != null) {
        paramMiniGamePkg.onInitGpkgInfo(paramInt, null, paramString, paramInfo);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.minigame.gpkg.GpkgManager.5
 * JD-Core Version:    0.7.0.1
 */