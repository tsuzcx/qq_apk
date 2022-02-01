package com.tencent.mobileqq.msgbackup.transport;

import awzh;
import axcm;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class MsgBackupTransportProcessor$4
  implements Runnable
{
  public MsgBackupTransportProcessor$4(axcm paramaxcm, String paramString) {}
  
  public void run()
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    axcm.a(this.this$0, localBaseApplication);
    this.this$0.jdField_a_of_type_Int = 1;
    int i = NetConnInfoCenter.getActiveNetIpFamily(true);
    this.this$0.jdField_a_of_type_Long = this.this$0.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.createSession(1, Long.parseLong(this.a), i, this.this$0.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupNotifier);
    if (this.this$0.a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "confirmOnlinePush11b: restore session is invalidate panic error!");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "confirmOnlinePush11b: restore createSession = " + this.this$0.jdField_a_of_type_Long);
    }
    i = this.this$0.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.start(this.this$0.jdField_a_of_type_Long, this.this$0.jdField_a_of_type_ArrayOfJavaLangString, this.this$0.jdField_a_of_type_JavaLangInteger, this.this$0.b);
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "confirmOnlinePush11b: restore start ret = " + i + ", ip = " + this.this$0.jdField_a_of_type_ArrayOfJavaLangString[0] + ", udpport = " + this.this$0.jdField_a_of_type_JavaLangInteger + ", tcpport = " + this.this$0.b);
    }
    awzh.a().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.transport.MsgBackupTransportProcessor.4
 * JD-Core Version:    0.7.0.1
 */