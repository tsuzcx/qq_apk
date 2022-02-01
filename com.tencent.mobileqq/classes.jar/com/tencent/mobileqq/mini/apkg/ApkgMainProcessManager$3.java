package com.tencent.mobileqq.mini.apkg;

import android.os.Bundle;
import com.tencent.mobileqq.mini.launch.CmdCallback;
import com.tencent.mobileqq.mini.launch.CmdCallback.Stub;
import com.tencent.qphone.base.util.QLog;

final class ApkgMainProcessManager$3
  extends CmdCallback.Stub
{
  ApkgMainProcessManager$3(CmdCallback paramCmdCallback) {}
  
  public void onCmdResult(boolean paramBoolean, Bundle paramBundle)
  {
    if (this.val$cmdCallback != null) {
      this.val$cmdCallback.onCmdResult(paramBoolean, paramBundle);
    }
    QLog.d("ApkgMainProcessManager", 2, "onCmdResult() called with: succ = [" + paramBoolean + "], bundle = [" + paramBundle + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.apkg.ApkgMainProcessManager.3
 * JD-Core Version:    0.7.0.1
 */