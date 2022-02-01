package com.tencent.mobileqq.msgbackup.controller;

import com.tencent.mobileqq.msgbackup.authentication.MsgBackupObserver;
import com.tencent.mobileqq.msgbackup.data.MsgBackupGetQrRsp;
import com.tencent.qphone.base.util.QLog;

class MsgBackupManager$2
  extends MsgBackupObserver
{
  MsgBackupManager$2(MsgBackupManager paramMsgBackupManager) {}
  
  public void a(boolean paramBoolean, Object paramObject)
  {
    super.a(paramBoolean, paramObject);
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup.BackupAndMigrateManager", 2, "onGetQrResponse: " + paramObject + ", isSuccess: " + paramBoolean);
    }
    if ((paramBoolean) && ((paramObject instanceof MsgBackupGetQrRsp))) {
      MsgBackupManager.a(this.a, (MsgBackupGetQrRsp)paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.controller.MsgBackupManager.2
 * JD-Core Version:    0.7.0.1
 */