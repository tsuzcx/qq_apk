package com.tencent.mobileqq.msgbackup.transport;

import avtf;
import avtq;
import avwk;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class MsgBackupTransportProcessor$3
  implements Runnable
{
  public MsgBackupTransportProcessor$3(avwk paramavwk, String paramString) {}
  
  public void run()
  {
    avtq.a().g();
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    avwk.a(this.this$0, localBaseApplication);
    this.this$0.jdField_a_of_type_Int = 2;
    int i = NetConnInfoCenter.getActiveNetIpFamily(true);
    this.this$0.jdField_a_of_type_Long = this.this$0.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.createSession(2, Long.parseLong(this.a), i, this.this$0.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupNotifier);
    if (this.this$0.a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "confirmOnlinePush11b: backup session is invalidate panic error!");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "confirmOnlinePush11b: backup createSession = " + this.this$0.jdField_a_of_type_Long);
    }
    i = this.this$0.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.start(this.this$0.jdField_a_of_type_Long, this.this$0.b, this.this$0.c, this.this$0.d);
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "confirmOnlinePush11b: backup start ret = " + i + ", ip = " + this.this$0.b[0] + ", udpport = " + this.this$0.c + ", tcpport = " + this.this$0.d);
    }
    avtf.a().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.transport.MsgBackupTransportProcessor.3
 * JD-Core Version:    0.7.0.1
 */