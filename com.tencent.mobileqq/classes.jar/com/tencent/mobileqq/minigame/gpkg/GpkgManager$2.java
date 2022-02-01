package com.tencent.mobileqq.minigame.gpkg;

import android.os.Bundle;
import android.os.SystemClock;
import com.tencent.mobileqq.mini.apkg.ApkgMainProcessManager;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.launch.CmdCallback.Stub;
import com.tencent.qphone.base.util.QLog;

final class GpkgManager$2
  extends CmdCallback.Stub
{
  GpkgManager$2(long paramLong, MiniAppConfig paramMiniAppConfig, GpkgManager.OnInitGpkgListener paramOnInitGpkgListener) {}
  
  public void onCmdResult(boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean)
    {
      paramBoolean = paramBundle.getBoolean("HAS_DOWNLOAD");
      l = paramBundle.getLong("DOWNLOAD_TIME_MS");
      if (paramBoolean) {
        QLog.i("[minigame] GpkgManager", 1, "[Gpkg] download gpkg in main process cost time:" + l + "ms  actually time cost in mini process is:" + (SystemClock.uptimeMillis() - this.val$startTime) + "ms");
      }
      ApkgMainProcessManager.queueSubProcessLoadTask(this.val$gameConfig);
      GpkgManager.access$000(this.val$gameConfig, this.val$wrapperListener);
    }
    while (paramBundle == null) {
      return;
    }
    float f = paramBundle.getFloat("PROGRESS");
    long l = paramBundle.getLong("TOTAL_SIZE");
    this.val$wrapperListener.onDownloadGpkgProgress(this.val$gameConfig.config, f, l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.gpkg.GpkgManager.2
 * JD-Core Version:    0.7.0.1
 */