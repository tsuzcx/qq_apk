package com.tencent.mobileqq.filemanager.core;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.FileAssistantReportData;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;

class FileManagerRSWorker$8
  implements Runnable
{
  FileManagerRSWorker$8(FileManagerRSWorker paramFileManagerRSWorker) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "Running RSWorker:" + MessageCache.a());
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      if ("run task sessionid[" + String.valueOf(this.this$0.c) + "]," + " actionType[" + String.valueOf(this.this$0.jdField_b_of_type_Int) + "], " + "strUin[" + this.this$0.e == null) {
        break label380;
      }
      localObject = FileManagerUtil.e(this.this$0.e);
    }
    for (;;)
    {
      QLog.i("FileManagerRSWorker<FileAssistant>", 2, (String)localObject);
      if (NetworkUtil.d(BaseApplicationImpl.getContext())) {
        break;
      }
      this.this$0.a(0);
      this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.this$0.jdField_b_of_type_Long, this.this$0.c, this.this$0.e, this.this$0.jdField_a_of_type_Int, 1, null, 2, null);
      FileManagerUtil.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.this$0.j, this.this$0.jdField_g_of_type_Long, FileManagerRSWorker.a(this.this$0), this.this$0.e, this.this$0.jdField_g_of_type_JavaLangString, this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9004L, "", 0L, 0L, this.this$0.d, "", "", FileManagerRSWorker.a(this.this$0), "NoNetWork", null);
      FileManagerUtil.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.this$0.k, this.this$0.jdField_g_of_type_Long, FileManagerRSWorker.a(this.this$0), this.this$0.e, this.this$0.jdField_g_of_type_JavaLangString, this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9004L, "", 0L, 0L, this.this$0.d, "", "", FileManagerRSWorker.b(this.this$0), "NoNetWork", null);
      return;
      label380:
      if ("null], filePath[" + this.this$0.jdField_b_of_type_JavaLangString != null) {
        localObject = this.this$0.jdField_b_of_type_JavaLangString;
      } else {
        localObject = "null], uniseq[" + String.valueOf(this.this$0.jdField_b_of_type_Long) + "]";
      }
    }
    this.this$0.jdField_g_of_type_Long = System.currentTimeMillis();
    this.this$0.i = 0L;
    this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 2;
    switch (this.this$0.jdField_b_of_type_Int)
    {
    }
    for (;;)
    {
      this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(true, 3, null);
      return;
      localObject = new FileManagerReporter.FileAssistantReportData();
      ((FileManagerReporter.FileAssistantReportData)localObject).jdField_b_of_type_JavaLangString = "send_file_number";
      FileManagerReporter.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (FileManagerReporter.FileAssistantReportData)localObject);
      this.this$0.b();
      continue;
      localObject = new FileManagerReporter.FileAssistantReportData();
      ((FileManagerReporter.FileAssistantReportData)localObject).jdField_b_of_type_JavaLangString = "rece_file_number";
      FileManagerReporter.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (FileManagerReporter.FileAssistantReportData)localObject);
      this.this$0.f();
      continue;
      this.this$0.h();
      continue;
      FileManagerRSWorker.a(this.this$0);
      continue;
      this.this$0.i();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FileManagerRSWorker.8
 * JD-Core Version:    0.7.0.1
 */