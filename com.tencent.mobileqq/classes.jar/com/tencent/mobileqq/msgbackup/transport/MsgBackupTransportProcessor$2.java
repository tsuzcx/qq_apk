package com.tencent.mobileqq.msgbackup.transport;

import android.content.Context;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msgbackup.authentication.MsgBackupAuthProcessor;
import com.tencent.mobileqq.msgbackup.controller.MsgBackupManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class MsgBackupTransportProcessor$2
  implements Runnable
{
  MsgBackupTransportProcessor$2(MsgBackupTransportProcessor paramMsgBackupTransportProcessor, String paramString, boolean paramBoolean) {}
  
  public void run()
  {
    MsgBackupManager.a().j();
    Object localObject = BaseApplication.getContext();
    MsgBackupTransportProcessor.a(this.this$0, (Context)localObject);
    this.this$0.c = 2;
    int i = NetConnInfoCenter.getActiveNetIpFamily(true);
    localObject = this.this$0;
    ((MsgBackupTransportProcessor)localObject).k = ((MsgBackupTransportProcessor)localObject).a.createSession(2, Long.parseLong(this.a), i, this.this$0.b);
    if (this.this$0.j())
    {
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "startAsServer session is invalidate panic error!");
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("createSession end, session = ");
      ((StringBuilder)localObject).append(this.this$0.k);
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, ((StringBuilder)localObject).toString());
    }
    i = this.this$0.a.start(this.this$0.k, this.this$0.g, this.this$0.h, this.this$0.i);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("start ret = ");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(", ip = ");
      ((StringBuilder)localObject).append(this.this$0.g[0]);
      ((StringBuilder)localObject).append(", udpport = ");
      ((StringBuilder)localObject).append(this.this$0.h);
      ((StringBuilder)localObject).append(", tcpport = ");
      ((StringBuilder)localObject).append(this.this$0.i);
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, ((StringBuilder)localObject).toString());
    }
    MsgBackupAuthProcessor.a().a(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.transport.MsgBackupTransportProcessor.2
 * JD-Core Version:    0.7.0.1
 */