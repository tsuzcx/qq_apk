package com.tencent.mobileqq.msgbackup.transport;

import aubu;
import auey;
import aufh;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class MsgBackupTransportProcessor$4
  implements Runnable
{
  public MsgBackupTransportProcessor$4(auey paramauey, String paramString) {}
  
  public void run()
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    auey.a(this.this$0, localBaseApplication);
    this.this$0.jdField_a_of_type_Int = 1;
    this.this$0.jdField_a_of_type_Long = this.this$0.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.createSession(1, Long.parseLong(this.a), this.this$0.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupNotifier);
    if (this.this$0.a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "confirmOnlinePush11b MBRROLE_CLIENT session is invalidate panic error!");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "createSession end, session = " + this.this$0.jdField_a_of_type_Long);
    }
    this.this$0.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint = new MsgBackupEndPoint();
    this.this$0.b = new MsgBackupEndPoint();
    int i = this.this$0.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.start(this.this$0.jdField_a_of_type_Long, this.this$0.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint, this.this$0.b);
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "after start called with ret = " + i + ", ipv4 = " + aufh.a(this.this$0.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.ipv4) + ", udpport = " + this.this$0.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.port + ", tcpport = " + this.this$0.b.port);
    }
    aubu.a().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.transport.MsgBackupTransportProcessor.4
 * JD-Core Version:    0.7.0.1
 */