package com.tencent.mobileqq.msgbackup.transport;

import augd;
import augo;
import aujh;
import aujq;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class MsgBackupTransportProcessor$2
  implements Runnable
{
  public MsgBackupTransportProcessor$2(aujh paramaujh, String paramString, boolean paramBoolean) {}
  
  public void run()
  {
    augo.a().g();
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    aujh.a(this.this$0, localBaseApplication);
    this.this$0.jdField_a_of_type_Int = 2;
    this.this$0.jdField_a_of_type_Long = this.this$0.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.createSession(2, Long.parseLong(this.jdField_a_of_type_JavaLangString), this.this$0.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupNotifier);
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
    this.this$0.c = new MsgBackupEndPoint();
    this.this$0.d = new MsgBackupEndPoint();
    int i = this.this$0.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.start(this.this$0.jdField_a_of_type_Long, this.this$0.c, this.this$0.d);
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "after start as server called with ret = " + i + ", ipv4 = " + aujq.a(this.this$0.c.ipv4) + ", udpport = " + this.this$0.c.port + ", tcpport = " + this.this$0.d.port);
    }
    augd.a().a(this.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.transport.MsgBackupTransportProcessor.2
 * JD-Core Version:    0.7.0.1
 */