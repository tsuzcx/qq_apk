package com.tencent.mobileqq.msgbackup.transport;

import awng;
import awnr;
import awql;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class MsgBackupTransportProcessor$2
  implements Runnable
{
  public MsgBackupTransportProcessor$2(awql paramawql, String paramString, boolean paramBoolean) {}
  
  public void run()
  {
    awnr.a().g();
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    awql.a(this.this$0, localBaseApplication);
    this.this$0.jdField_a_of_type_Int = 2;
    int i = NetConnInfoCenter.getActiveNetIpFamily(true);
    this.this$0.jdField_a_of_type_Long = this.this$0.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.createSession(2, Long.parseLong(this.jdField_a_of_type_JavaLangString), i, this.this$0.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupNotifier);
    if (this.this$0.a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "startAsServer session is invalidate panic error!");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "createSession end, session = " + this.this$0.jdField_a_of_type_Long);
    }
    i = this.this$0.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.start(this.this$0.jdField_a_of_type_Long, this.this$0.b, this.this$0.c, this.this$0.d);
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "start ret = " + i + ", ip = " + this.this$0.b[0] + ", udpport = " + this.this$0.c + ", tcpport = " + this.this$0.d);
    }
    awng.a().a(this.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.transport.MsgBackupTransportProcessor.2
 * JD-Core Version:    0.7.0.1
 */