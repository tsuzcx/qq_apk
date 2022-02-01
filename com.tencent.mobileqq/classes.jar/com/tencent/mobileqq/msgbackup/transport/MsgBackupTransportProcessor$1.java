package com.tencent.mobileqq.msgbackup.transport;

import avtf;
import avwk;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class MsgBackupTransportProcessor$1
  implements Runnable
{
  public MsgBackupTransportProcessor$1(avwk paramavwk, String paramString) {}
  
  public void run()
  {
    try
    {
      BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
      avwk.a(this.this$0, localBaseApplication);
      this.this$0.jdField_a_of_type_Int = 1;
      int i = NetConnInfoCenter.getActiveNetIpFamily(true);
      this.this$0.jdField_a_of_type_Long = this.this$0.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.createSession(1, Long.parseLong(this.a), i, this.this$0.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupNotifier);
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
        i = this.this$0.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.start(this.this$0.jdField_a_of_type_Long, this.this$0.jdField_a_of_type_ArrayOfJavaLangString, this.this$0.jdField_a_of_type_JavaLangInteger, this.this$0.b);
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup", 2, "start ret = " + i + ", ip = " + this.this$0.jdField_a_of_type_ArrayOfJavaLangString[0] + ", udpport = " + this.this$0.jdField_a_of_type_JavaLangInteger + ", tcpport = " + this.this$0.b);
        }
        avtf.a().a();
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("MsgBackup", 1, "startAsClient occur error", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.transport.MsgBackupTransportProcessor.1
 * JD-Core Version:    0.7.0.1
 */