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
    Object localObject = this.val$cmdCallback;
    if (localObject != null) {
      ((MiniCmdCallback)localObject).onCmdResult(paramBoolean, paramBundle);
    }
    if ((this.val$isApkg) || (paramBoolean))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onCmdResult() called with: succ = [");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append("], bundle = [");
      ((StringBuilder)localObject).append(paramBundle);
      ((StringBuilder)localObject).append("]");
      QMLog.d("ApkgMainProcessManager", ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.minigame.gpkg.ApkgMainProcessManager.1
 * JD-Core Version:    0.7.0.1
 */