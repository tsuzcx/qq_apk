package com.tencent.mobileqq.mini.entry;

import android.os.Bundle;
import com.tencent.mobileqq.mini.launch.CmdCallback.Stub;
import com.tencent.qphone.base.util.QLog;

final class MiniAppUtils$6
  extends CmdCallback.Stub
{
  public void onCmdResult(boolean paramBoolean, Bundle paramBundle)
  {
    QLog.d("MiniAppUtils", 2, "onCmdResult() called with: succ = " + paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppUtils.6
 * JD-Core Version:    0.7.0.1
 */