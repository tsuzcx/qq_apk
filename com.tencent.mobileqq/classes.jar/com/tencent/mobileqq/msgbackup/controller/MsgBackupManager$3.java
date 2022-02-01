package com.tencent.mobileqq.msgbackup.controller;

import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime.InterceptKickListener;
import mqq.app.AppRuntime.KickParams;

class MsgBackupManager$3
  implements AppRuntime.InterceptKickListener
{
  MsgBackupManager$3(MsgBackupManager paramMsgBackupManager) {}
  
  public void onInterceptKicked(AppRuntime.KickParams paramKickParams)
  {
    if (MsgBackupManager.a(this.a).get()) {
      MsgBackupManager.a(this.a, paramKickParams);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.controller.MsgBackupManager.3
 * JD-Core Version:    0.7.0.1
 */