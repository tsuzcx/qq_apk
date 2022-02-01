package com.tencent.mobileqq.filemanager.app;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.discoperation.FileHttpUtils;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.qphone.base.util.QLog;

class QFileMsgForwardManager$BuddyUploadTaskExcuter$1
  implements Runnable
{
  QFileMsgForwardManager$BuddyUploadTaskExcuter$1(QFileMsgForwardManager.BuddyUploadTaskExcuter paramBuddyUploadTaskExcuter, String paramString, QFileMsgForwardManager.OnUploadCallback paramOnUploadCallback) {}
  
  public void run()
  {
    ProtocolManager localProtocolManager = QFileMsgForwardManager.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$BuddyUploadTaskExcuter.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager).getFileManagerEngine().a();
    byte[] arrayOfByte1 = FileManagerUtil.e(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$BuddyUploadTaskExcuter.b);
    byte[] arrayOfByte2 = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$BuddyUploadTaskExcuter.b);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$BuddyUploadTaskExcuter.jdField_a_of_type_Long = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$BuddyUploadTaskExcuter.b);
    QFileMsgForwardManager.BuddyUploadTaskExcuter.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$BuddyUploadTaskExcuter).putString("_m_ForwardSize", this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$BuddyUploadTaskExcuter.jdField_a_of_type_Long + "");
    QFileMsgForwardManager.BuddyUploadTaskExcuter.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$BuddyUploadTaskExcuter).putString("_m_ForwardSha", FileHttpUtils.a(arrayOfByte2));
    QFileMsgForwardManager.BuddyUploadTaskExcuter.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$BuddyUploadTaskExcuter).putString("_m_ForwardMd5", FileHttpUtils.a(arrayOfByte1));
    QFileMsgForwardManager.BuddyUploadTaskExcuter.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$BuddyUploadTaskExcuter).putString("_m_ForwardDeadTime", "0");
    if (QLog.isColorLevel()) {
      QLog.i("FileMultiMsgManager<FileAssistant>", 1, "start sendLocalFileToBuddyBySHA:" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$BuddyUploadTaskExcuter.jdField_a_of_type_JavaLangString);
    }
    localProtocolManager.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$BuddyUploadTaskExcuter.b, this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$BuddyUploadTaskExcuter.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$BuddyUploadTaskExcuter.jdField_a_of_type_Long, arrayOfByte1, arrayOfByte2, 5000, 3, new QFileMsgForwardManager.BuddyUploadTaskExcuter.1.1(this, localProtocolManager, arrayOfByte2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.QFileMsgForwardManager.BuddyUploadTaskExcuter.1
 * JD-Core Version:    0.7.0.1
 */