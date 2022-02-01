package com.tencent.qqmini.minigame.gpkg;

import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

final class GpkgManager$2
  implements Runnable
{
  GpkgManager$2(MiniAppInfo paramMiniAppInfo) {}
  
  public void run()
  {
    ApkgMainProcessManager.checkShouldLoadPkgInMainProcess(this.val$gameConfig, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.gpkg.GpkgManager.2
 * JD-Core Version:    0.7.0.1
 */