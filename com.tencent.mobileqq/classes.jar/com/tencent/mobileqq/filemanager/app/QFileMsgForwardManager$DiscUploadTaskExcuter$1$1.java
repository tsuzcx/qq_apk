package com.tencent.mobileqq.filemanager.app;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerRSCenter;
import com.tencent.qphone.base.util.QLog;

class QFileMsgForwardManager$DiscUploadTaskExcuter$1$1
  implements NewDiscFileUploader.UploaderCallback
{
  QFileMsgForwardManager$DiscUploadTaskExcuter$1$1(QFileMsgForwardManager.DiscUploadTaskExcuter.1 param1, String paramString) {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileMultiMsgManager<FileAssistant>", 1, this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$DiscUploadTaskExcuter$1.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$DiscUploadTaskExcuter.jdField_a_of_type_JavaLangString + " start upload Discfile success");
      }
      QFileMsgForwardManager.DiscUploadTaskExcuter.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$DiscUploadTaskExcuter$1.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$DiscUploadTaskExcuter).putString("_m_ForwardUuid", this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$DiscUploadTaskExcuter$1.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$OnUploadCallback.a(this.jdField_a_of_type_JavaLangString, QFileMsgForwardManager.DiscUploadTaskExcuter.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$DiscUploadTaskExcuter$1.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$DiscUploadTaskExcuter));
    }
    for (;;)
    {
      QFileMsgForwardManager.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$DiscUploadTaskExcuter$1.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$DiscUploadTaskExcuter.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager).getFileManagerRSCenter().a(QFileMsgForwardManager.DiscUploadTaskExcuter.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$DiscUploadTaskExcuter$1.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$DiscUploadTaskExcuter));
      return;
      QLog.e("FileMultiMsg", 1, this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$DiscUploadTaskExcuter$1.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$DiscUploadTaskExcuter.jdField_a_of_type_JavaLangString + " sendDiscFile faild");
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$DiscUploadTaskExcuter$1.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$OnUploadCallback.a(QFileMsgForwardManager.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$DiscUploadTaskExcuter$1.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$DiscUploadTaskExcuter.jdField_a_of_type_Long, false), true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.QFileMsgForwardManager.DiscUploadTaskExcuter.1.1
 * JD-Core Version:    0.7.0.1
 */