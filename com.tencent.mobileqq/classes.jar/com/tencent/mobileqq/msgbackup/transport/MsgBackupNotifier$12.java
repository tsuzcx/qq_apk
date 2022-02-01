package com.tencent.mobileqq.msgbackup.transport;

import com.tencent.mobileqq.msgbackup.controller.MsgBackupManager;

class MsgBackupNotifier$12
  implements Runnable
{
  MsgBackupNotifier$12(MsgBackupNotifier paramMsgBackupNotifier, long paramLong, String paramString1, int paramInt, String paramString2) {}
  
  public void run()
  {
    MsgBackupManager.a().d().a(this.a, this.b, this.c, this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.transport.MsgBackupNotifier.12
 * JD-Core Version:    0.7.0.1
 */