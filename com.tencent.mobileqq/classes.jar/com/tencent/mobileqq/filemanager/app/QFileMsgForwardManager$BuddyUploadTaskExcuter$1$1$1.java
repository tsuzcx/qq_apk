package com.tencent.mobileqq.filemanager.app;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerRSCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.qphone.base.util.QLog;

class QFileMsgForwardManager$BuddyUploadTaskExcuter$1$1$1
  implements NewFileUploader.UploaderCallback
{
  QFileMsgForwardManager$BuddyUploadTaskExcuter$1$1$1(QFileMsgForwardManager.BuddyUploadTaskExcuter.1.1 param1, ByteStringMicro paramByteStringMicro, String paramString) {}
  
  public void a(boolean paramBoolean)
  {
    QFileMsgForwardManager.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$BuddyUploadTaskExcuter$1$1.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$BuddyUploadTaskExcuter$1.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$BuddyUploadTaskExcuter.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager).getFileManagerRSCenter().a(QFileMsgForwardManager.BuddyUploadTaskExcuter.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$BuddyUploadTaskExcuter$1$1.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$BuddyUploadTaskExcuter$1.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$BuddyUploadTaskExcuter));
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileMultiMsgManager<FileAssistant>", 1, this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$BuddyUploadTaskExcuter$1$1.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$BuddyUploadTaskExcuter$1.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$BuddyUploadTaskExcuter.jdField_a_of_type_JavaLangString + " sendLocalFileToBuddyBySHA uploadFile success");
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$BuddyUploadTaskExcuter$1$1.jdField_a_of_type_ComTencentMobileqqFilemanagerAppProtocolManager.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$BuddyUploadTaskExcuter$1$1.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$BuddyUploadTaskExcuter$1.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro.toByteArray(), 5000, 3, null);
      QFileMsgForwardManager.BuddyUploadTaskExcuter.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$BuddyUploadTaskExcuter$1$1.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$BuddyUploadTaskExcuter$1.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$BuddyUploadTaskExcuter).putString("_m_ForwardUuid", this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$BuddyUploadTaskExcuter$1$1.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$BuddyUploadTaskExcuter$1.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$OnUploadCallback.a(this.jdField_a_of_type_JavaLangString, QFileMsgForwardManager.BuddyUploadTaskExcuter.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$BuddyUploadTaskExcuter$1$1.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$BuddyUploadTaskExcuter$1.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$BuddyUploadTaskExcuter));
      return;
    }
    QLog.e("FileMultiMsgManager<FileAssistant>", 1, this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$BuddyUploadTaskExcuter$1$1.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$BuddyUploadTaskExcuter$1.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$BuddyUploadTaskExcuter.jdField_a_of_type_JavaLangString + " BuddyUploadTaskExcuter faild");
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$BuddyUploadTaskExcuter$1$1.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$BuddyUploadTaskExcuter$1.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$OnUploadCallback.a(QFileMsgForwardManager.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$BuddyUploadTaskExcuter$1$1.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$BuddyUploadTaskExcuter$1.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$BuddyUploadTaskExcuter.jdField_a_of_type_Long, false), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.QFileMsgForwardManager.BuddyUploadTaskExcuter.1.1.1
 * JD-Core Version:    0.7.0.1
 */