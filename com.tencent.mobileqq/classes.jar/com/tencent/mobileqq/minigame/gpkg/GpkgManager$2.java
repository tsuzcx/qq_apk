package com.tencent.mobileqq.minigame.gpkg;

import com.tencent.mobileqq.mini.apkg.ApkgMainProcessManager;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;

final class GpkgManager$2
  implements Runnable
{
  GpkgManager$2(MiniAppConfig paramMiniAppConfig) {}
  
  public void run()
  {
    ApkgMainProcessManager.checkShouldLoadPkgInMainProcess(this.val$gameConfig, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.gpkg.GpkgManager.2
 * JD-Core Version:    0.7.0.1
 */