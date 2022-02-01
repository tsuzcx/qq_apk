package com.tencent.mobileqq.msgbackup.transport;

import android.content.Context;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msgbackup.authentication.MsgBackupAuthProcessor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class MsgBackupTransportProcessor$4
  implements Runnable
{
  MsgBackupTransportProcessor$4(MsgBackupTransportProcessor paramMsgBackupTransportProcessor, String paramString) {}
  
  public void run()
  {
    Object localObject = BaseApplication.getContext();
    MsgBackupTransportProcessor.a(this.this$0, (Context)localObject);
    this.this$0.jdField_a_of_type_Int = 1;
    int i = NetConnInfoCenter.getActiveNetIpFamily(true);
    localObject = this.this$0;
    ((MsgBackupTransportProcessor)localObject).jdField_a_of_type_Long = ((MsgBackupTransportProcessor)localObject).jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.createSession(1, Long.parseLong(this.a), i, this.this$0.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupNotifier);
    if (this.this$0.a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "confirmOnlinePush11b: restore session is invalidate panic error!");
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("confirmOnlinePush11b: restore createSession = ");
      ((StringBuilder)localObject).append(this.this$0.jdField_a_of_type_Long);
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, ((StringBuilder)localObject).toString());
    }
    i = this.this$0.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.start(this.this$0.jdField_a_of_type_Long, this.this$0.jdField_a_of_type_ArrayOfJavaLangString, this.this$0.jdField_a_of_type_JavaLangInteger, this.this$0.b);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("confirmOnlinePush11b: restore start ret = ");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(", ip = ");
      ((StringBuilder)localObject).append(this.this$0.jdField_a_of_type_ArrayOfJavaLangString[0]);
      ((StringBuilder)localObject).append(", udpport = ");
      ((StringBuilder)localObject).append(this.this$0.jdField_a_of_type_JavaLangInteger);
      ((StringBuilder)localObject).append(", tcpport = ");
      ((StringBuilder)localObject).append(this.this$0.b);
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, ((StringBuilder)localObject).toString());
    }
    MsgBackupAuthProcessor.a().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.transport.MsgBackupTransportProcessor.4
 * JD-Core Version:    0.7.0.1
 */