package com.tencent.qqmini.minigame.gpkg;

import android.os.Bundle;
import com.tencent.qqmini.sdk.launcher.ipc.MiniCmdCallback;
import com.tencent.qqmini.sdk.launcher.ipc.MiniCmdCallback.Stub;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

final class ApkgMainProcessManager$1
  extends MiniCmdCallback.Stub
{
  ApkgMainProcessManager$1(MiniCmdCallback paramMiniCmdCallback, boolean paramBoolean) {}
  
  public void onCmdResult(boolean paramBoolean, Bundle paramBundle)
  {
    if (this.val$cmdCallback != null) {
      this.val$cmdCallback.onCmdResult(paramBoolean, paramBundle);
    }
    if ((this.val$isApkg) || (paramBoolean)) {
      QMLog.d("ApkgMainProcessManager", "onCmdResult() called with: succ = [" + paramBoolean + "], bundle = [" + paramBundle + "]");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.gpkg.ApkgMainProcessManager.1
 * JD-Core Version:    0.7.0.1
 */