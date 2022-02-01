package com.tencent.qqmini.minigame.gpkg;

import android.os.Bundle;
import com.tencent.qqmini.sdk.launcher.ipc.MiniCmdCallback;
import com.tencent.qqmini.sdk.launcher.ipc.MiniCmdCallback.Stub;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

final class ApkgMainProcessManager$2
  extends MiniCmdCallback.Stub
{
  ApkgMainProcessManager$2(MiniCmdCallback paramMiniCmdCallback) {}
  
  public void onCmdResult(boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject = this.val$cmdCallback;
    if (localObject != null) {
      ((MiniCmdCallback)localObject).onCmdResult(paramBoolean, paramBundle);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onCmdResult() called with: succ = [");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append("], bundle = [");
    ((StringBuilder)localObject).append(paramBundle);
    ((StringBuilder)localObject).append("]");
    QMLog.d("ApkgMainProcessManager", ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.gpkg.ApkgMainProcessManager.2
 * JD-Core Version:    0.7.0.1
 */