package com.tencent.mobileqq.msgbackup.transport;

import aubu;
import aucf;
import auey;
import aufh;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class MsgBackupTransportProcessor$3
  implements Runnable
{
  public MsgBackupTransportProcessor$3(auey paramauey, String paramString) {}
  
  public void run()
  {
    aucf.a().g();
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    auey.a(this.this$0, localBaseApplication);
    this.this$0.jdField_a_of_type_Int = 2;
    this.this$0.jdField_a_of_type_Long = this.this$0.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.createSession(2, Long.parseLong(this.a), this.this$0.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupNotifier);
    if (this.this$0.a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "confirmOnlinePush11b MBRROLE_SERVER session is invalidate panic error!");
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
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "after start called with ret = " + i + ", ipv4 = " + aufh.a(this.this$0.c.ipv4) + ", udpport = " + this.this$0.c.port + ", tcpport = " + this.this$0.d.port);
    }
    aubu.a().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.transport.MsgBackupTransportProcessor.3
 * JD-Core Version:    0.7.0.1
 */