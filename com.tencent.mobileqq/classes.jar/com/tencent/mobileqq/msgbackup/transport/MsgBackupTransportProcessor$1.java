package com.tencent.mobileqq.msgbackup.transport;

import android.content.Context;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msgbackup.authentication.MsgBackupAuthProcessor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class MsgBackupTransportProcessor$1
  implements Runnable
{
  MsgBackupTransportProcessor$1(MsgBackupTransportProcessor paramMsgBackupTransportProcessor, String paramString) {}
  
  public void run()
  {
    try
    {
      Object localObject = BaseApplication.getContext();
      MsgBackupTransportProcessor.a(this.this$0, (Context)localObject);
      this.this$0.c = 1;
      int i = NetConnInfoCenter.getActiveNetIpFamily(true);
      this.this$0.k = this.this$0.a.createSession(1, Long.parseLong(this.a), i, this.this$0.b);
      if (this.this$0.j())
      {
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "startAsClient session is invalidate panic error!");
        }
      }
      else
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("createSession end, operator = ");
          ((StringBuilder)localObject).append(this.this$0.k);
          QLog.d("MsgBackup", 2, ((StringBuilder)localObject).toString());
        }
        i = this.this$0.a.start(this.this$0.k, this.this$0.d, this.this$0.e, this.this$0.f);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("start ret = ");
          ((StringBuilder)localObject).append(i);
          ((StringBuilder)localObject).append(", ip = ");
          ((StringBuilder)localObject).append(this.this$0.d[0]);
          ((StringBuilder)localObject).append(", udpport = ");
          ((StringBuilder)localObject).append(this.this$0.e);
          ((StringBuilder)localObject).append(", tcpport = ");
          ((StringBuilder)localObject).append(this.this$0.f);
          QLog.d("MsgBackup", 2, ((StringBuilder)localObject).toString());
        }
        MsgBackupAuthProcessor.a().b();
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("MsgBackup", 1, "startAsClient occur error", localException);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.transport.MsgBackupTransportProcessor.1
 * JD-Core Version:    0.7.0.1
 */