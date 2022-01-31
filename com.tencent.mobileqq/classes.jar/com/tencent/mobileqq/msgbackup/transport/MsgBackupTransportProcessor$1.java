package com.tencent.mobileqq.msgbackup.transport;

import askt;
import asnx;
import asog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class MsgBackupTransportProcessor$1
  implements Runnable
{
  public MsgBackupTransportProcessor$1(asnx paramasnx, String paramString) {}
  
  public void run()
  {
    try
    {
      BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
      asnx.a(this.this$0, localBaseApplication);
      this.this$0.jdField_a_of_type_Int = 1;
      this.this$0.jdField_a_of_type_Long = this.this$0.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.createSession(1, Long.parseLong(this.a), this.this$0.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupNotifier);
      if (this.this$0.a())
      {
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "startAsClient session is invalidate panic error!");
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup", 2, "createSession end, operator = " + this.this$0.jdField_a_of_type_Long);
        }
        this.this$0.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint = new MsgBackupEndPoint();
        this.this$0.b = new MsgBackupEndPoint();
        int i = this.this$0.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.start(this.this$0.jdField_a_of_type_Long, this.this$0.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint, this.this$0.b);
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup", 2, "after start as client called with ret = " + i + ", ipv4 = " + asog.a(this.this$0.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.ipv4) + ", udpport = " + this.this$0.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.port + ", tcpport = " + this.this$0.b.port);
        }
        askt.a().a();
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("MsgBackup", 1, "startAsClient occur error", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.transport.MsgBackupTransportProcessor.1
 * JD-Core Version:    0.7.0.1
 */