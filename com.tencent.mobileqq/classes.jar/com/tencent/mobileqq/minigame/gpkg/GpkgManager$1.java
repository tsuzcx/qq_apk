package com.tencent.mobileqq.minigame.gpkg;

import android.os.Bundle;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.launch.CmdCallback.Stub;

final class GpkgManager$1
  extends CmdCallback.Stub
{
  GpkgManager$1(MiniAppConfig paramMiniAppConfig, GpkgManager.OnInitGpkgListener paramOnInitGpkgListener) {}
  
  public void onCmdResult(boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean) {
      GpkgManager.access$000(this.val$gameConfig, this.val$listener);
    }
    while (paramBundle == null) {
      return;
    }
    float f = paramBundle.getFloat("PROGRESS");
    long l = paramBundle.getLong("TOTAL_SIZE");
    this.val$listener.onDownloadGpkgProgress(this.val$gameConfig.config, f, l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.gpkg.GpkgManager.1
 * JD-Core Version:    0.7.0.1
 */