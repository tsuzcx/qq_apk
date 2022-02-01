package com.tencent.mobileqq.filemanageraux.discoperation;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.discoperation.FileHttpUtils;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class DiscFileOperator$2
  implements Runnable
{
  DiscFileOperator$2(DiscFileOperator paramDiscFileOperator) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("DiscFileOperator<FileAssistant>", 1, "run sendFile:" + MessageCache.a());
    }
    if (!NetworkUtil.d(BaseApplication.getContext()))
    {
      this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
      this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 1, null, 2, null);
      this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerauxDiscoperationFileReportData.a = 9004L;
      this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerauxDiscoperationFileReportData.jdField_c_of_type_JavaLangString = "NoNetWork";
      this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerauxDiscoperationFileReportData.b();
      this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    }
    do
    {
      return;
      if (this.this$0.jdField_a_of_type_Boolean)
      {
        QLog.w("DiscFileOperator<FileAssistant>", 1, "nID[" + this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "] user canceled!");
        return;
      }
      String str1 = null;
      if ((this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5 == null) || (this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5.length() != 32))
      {
        str1 = FileHttpUtils.a(FileManagerUtil.e(this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath()));
        this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5 = str1;
      }
      String str2 = null;
      if ((this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5 == null) || (this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5.length() != 40))
      {
        str2 = FileHttpUtils.a(FileManagerUtil.a(this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath()));
        this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileSHA = str2;
      }
      this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
      this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 2;
      this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerauxDiscoperationFileReportData.e = str1;
      this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerauxDiscoperationFileReportData.f = str2;
      this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerauxDiscoperationFileReportData.jdField_c_of_type_Long = System.currentTimeMillis();
      this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileTransferHandler().a(this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileSHA, this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName, this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.this$0);
    } while (!QLog.isColorLevel());
    QLog.i("DiscFileOperator<FileAssistant>", 1, "nID[" + this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]Send CS Request!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.discoperation.DiscFileOperator.2
 * JD-Core Version:    0.7.0.1
 */