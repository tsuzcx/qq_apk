package com.tencent.mobileqq.mini.apkg;

import android.os.Bundle;
import com.tencent.mobileqq.mini.launch.CmdCallback;
import com.tencent.mobileqq.mini.launch.CmdCallback.Stub;

final class ApkgMainProcessManager$2
  extends CmdCallback.Stub
{
  ApkgMainProcessManager$2(CmdCallback paramCmdCallback) {}
  
  public void onCmdResult(boolean paramBoolean, Bundle paramBundle)
  {
    if (this.val$cmdCallback != null) {
      this.val$cmdCallback.onCmdResult(paramBoolean, paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.apkg.ApkgMainProcessManager.2
 * JD-Core Version:    0.7.0.1
 */