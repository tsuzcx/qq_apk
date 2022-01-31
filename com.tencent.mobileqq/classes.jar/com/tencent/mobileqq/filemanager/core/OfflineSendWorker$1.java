package com.tencent.mobileqq.filemanager.core;

import aqwn;
import aqye;
import arrp;
import arrq;
import bdin;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

public class OfflineSendWorker$1
  implements Runnable
{
  public OfflineSendWorker$1(aqye paramaqye) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("OfflineSendWorker<FileAssistant>", 2, "OfflineSendWorker run task sessionid[" + this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "],filePath[" + this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath() + "]");
    }
    if (!bdin.d(BaseApplicationImpl.getContext()))
    {
      aqye.a(this.this$0, 0);
      this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 15, null, 2, null);
      aqye.a(this.this$0, 0L, 9004, "NoNetWork");
      aqye.b(this.this$0, 0L, 9004, "NoNetWork");
      return;
    }
    this.this$0.jdField_a_of_type_Long = System.currentTimeMillis();
    this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 2;
    arrq localarrq = new arrq();
    localarrq.b = "send_file_number";
    arrp.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), localarrq);
    this.this$0.m();
    this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true, 3, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.OfflineSendWorker.1
 * JD-Core Version:    0.7.0.1
 */