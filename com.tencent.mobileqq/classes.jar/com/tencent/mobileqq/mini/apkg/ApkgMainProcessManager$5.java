package com.tencent.mobileqq.mini.apkg;

import android.os.Bundle;
import com.tencent.mobileqq.mini.launch.CmdCallback.Stub;
import com.tencent.qphone.base.util.QLog;

final class ApkgMainProcessManager$5
  extends CmdCallback.Stub
{
  ApkgMainProcessManager$5(MiniAppConfig paramMiniAppConfig) {}
  
  public void onCmdResult(boolean paramBoolean, Bundle paramBundle)
  {
    QLog.d("ApkgMainProcessManager", 2, "queueSubProcessLoadTask() called with: miniAppConfig = [" + this.val$miniAppConfig + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.apkg.ApkgMainProcessManager.5
 * JD-Core Version:    0.7.0.1
 */