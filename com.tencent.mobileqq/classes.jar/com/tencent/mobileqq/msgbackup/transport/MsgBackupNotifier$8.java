package com.tencent.mobileqq.msgbackup.transport;

import com.tencent.mobileqq.msgbackup.controller.MsgBackupManager;

class MsgBackupNotifier$8
  implements Runnable
{
  MsgBackupNotifier$8(MsgBackupNotifier paramMsgBackupNotifier, String paramString1, int paramInt1, int paramInt2, String paramString2, long paramLong) {}
  
  public void run()
  {
    MsgBackupManager.a().d().a(this.a, this.b, this.c, this.d, this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.transport.MsgBackupNotifier.8
 * JD-Core Version:    0.7.0.1
 */