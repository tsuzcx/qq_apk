package com.tencent.qqmini.minigame.gpkg;

import android.os.Bundle;
import com.tencent.qqmini.sdk.launcher.ipc.MiniCmdCallback.Stub;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

final class ApkgMainProcessManager$4
  extends MiniCmdCallback.Stub
{
  ApkgMainProcessManager$4(MiniAppInfo paramMiniAppInfo) {}
  
  public void onCmdResult(boolean paramBoolean, Bundle paramBundle)
  {
    paramBundle = new StringBuilder();
    paramBundle.append("removeSubProcessLoadTask() called with: miniAppConfig = [");
    paramBundle.append(this.val$miniAppConfig);
    paramBundle.append("]");
    QMLog.d("ApkgMainProcessManager", paramBundle.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.minigame.gpkg.ApkgMainProcessManager.4
 * JD-Core Version:    0.7.0.1
 */