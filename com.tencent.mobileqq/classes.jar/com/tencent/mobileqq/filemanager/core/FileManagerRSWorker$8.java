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
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Running RSWorker:");
      ((StringBuilder)localObject).append(MessageCache.a());
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("run task sessionid[");
      ((StringBuilder)localObject).append(String.valueOf(this.this$0.c));
      ((StringBuilder)localObject).append("],");
      ((StringBuilder)localObject).append(" actionType[");
      ((StringBuilder)localObject).append(String.valueOf(this.this$0.jdField_b_of_type_Int));
      ((StringBuilder)localObject).append("], ");
      ((StringBuilder)localObject).append("strUin[");
      ((StringBuilder)localObject).append(this.this$0.e);
      if (((StringBuilder)localObject).toString() != null)
      {
        localObject = FileManagerUtil.d(this.this$0.e);
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("null], filePath[");
        ((StringBuilder)localObject).append(this.this$0.jdField_b_of_type_JavaLangString);
        if (((StringBuilder)localObject).toString() != null)
        {
          localObject = this.this$0.jdField_b_of_type_JavaLangString;
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("null], uniseq[");
          ((StringBuilder)localObject).append(String.valueOf(this.this$0.jdField_b_of_type_Long));
          ((StringBuilder)localObject).append("]");
          localObject = ((StringBuilder)localObject).toString();
        }
      }
      QLog.i("FileManagerRSWorker<FileAssistant>", 2, (String)localObject);
    }
    if (!NetworkUtil.isNetSupport(BaseApplicationImpl.getContext()))
    {
      this.this$0.a(0);
      this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.this$0.jdField_b_of_type_Long, this.this$0.c, this.this$0.e, this.this$0.jdField_a_of_type_Int, 1, null, 2, null);
      FileManagerUtil.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.this$0.j, this.this$0.jdField_g_of_type_Long, FileManagerRSWorker.a(this.this$0), this.this$0.e, this.this$0.jdField_g_of_type_JavaLangString, this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9004L, "", 0L, 0L, this.this$0.d, "", "", FileManagerRSWorker.a(this.this$0), "NoNetWork", null);
      FileManagerUtil.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.this$0.k, this.this$0.jdField_g_of_type_Long, FileManagerRSWorker.a(this.this$0), this.this$0.e, this.this$0.jdField_g_of_type_JavaLangString, this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9004L, "", 0L, 0L, this.this$0.d, "", "", FileManagerRSWorker.b(this.this$0), "NoNetWork", null);
      return;
    }
    this.this$0.jdField_g_of_type_Long = System.currentTimeMillis();
    Object localObject = this.this$0;
    ((FileManagerRSWorker)localObject).i = 0L;
    ((FileManagerRSWorker)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 2;
    int i = this.this$0.jdField_b_of_type_Int;
    if (i != 0)
    {
      if (i != 1) {
        if (i != 5)
        {
          if (i != 6)
          {
            if (i != 8)
            {
              if (i != 50) {
                break label669;
              }
              FileManagerRSWorker.a(this.this$0);
              break label669;
            }
          }
          else
          {
            this.this$0.i();
            break label669;
          }
        }
        else
        {
          this.this$0.h();
          break label669;
        }
      }
      localObject = new FileManagerReporter.FileAssistantReportData();
      ((FileManagerReporter.FileAssistantReportData)localObject).jdField_b_of_type_JavaLangString = "rece_file_number";
      FileManagerReporter.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (FileManagerReporter.FileAssistantReportData)localObject);
      this.this$0.a();
    }
    else
    {
      localObject = new FileManagerReporter.FileAssistantReportData();
      ((FileManagerReporter.FileAssistantReportData)localObject).jdField_b_of_type_JavaLangString = "send_file_number";
      FileManagerReporter.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (FileManagerReporter.FileAssistantReportData)localObject);
      this.this$0.b();
    }
    label669:
    this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(true, 3, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FileManagerRSWorker.8
 * JD-Core Version:    0.7.0.1
 */