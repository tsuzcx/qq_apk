package com.tencent.mobileqq.msgbackup.controller;

import com.tencent.mobileqq.msgbackup.util.MsgBackupUtil;

class MsgBackupManager$1
  implements Runnable
{
  MsgBackupManager$1(MsgBackupManager paramMsgBackupManager) {}
  
  public void run()
  {
    MsgBackupUtil.a("MsgBackup.BackupAndMigrateManager", "onDestory .....deleteMsgBackupFiles.", new Object[0]);
    this.this$0.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.controller.MsgBackupManager.1
 * JD-Core Version:    0.7.0.1
 */