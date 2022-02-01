package com.tencent.mobileqq.filemanager.app;

import android.os.Bundle;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;

class QFileMsgForwardManager$FileUploadTask$1
  implements QFileMsgForwardManager.OnUploadCallback
{
  QFileMsgForwardManager$FileUploadTask$1(QFileMsgForwardManager.FileUploadTask paramFileUploadTask, QFileMsgForwardManager paramQFileMsgForwardManager, MessageRecord paramMessageRecord) {}
  
  public void a(String paramString, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FileMultiMsgManager<FileAssistant>", 1, "FileUploadTask success, multiUniseq[ " + this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$FileUploadTask.jdField_a_of_type_JavaLangString + "] uuid[" + paramString + "] fileMrUniseq[" + this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq + "]");
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$FileUploadTask.b = 2;
    QFileMsgForwardManager.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$FileUploadTask.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, paramBundle);
    QFileMsgForwardManager.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$FileUploadTask.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager, this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$FileUploadTask.jdField_a_of_type_JavaLangString);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FileMultiMsgManager<FileAssistant>", 1, "FileUploadTask fail, multiUniseq[ " + this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$FileUploadTask.jdField_a_of_type_JavaLangString + "] fileMrUniseq[" + this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq + "] canResume[" + paramBoolean + "] retMsg[" + paramString + "]");
    }
    if (paramBoolean) {}
    for (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$FileUploadTask.b = 4;; this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$FileUploadTask.b = 3)
    {
      QFileMsgForwardManager.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$FileUploadTask.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager, this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$FileUploadTask.jdField_a_of_type_JavaLangString);
      return;
      String str = HardCodeUtil.a(2131709667) + this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.getExtInfoFromExtStr("_m_ForwardFileName");
      paramString = str + "\n" + paramString;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.saveExtInfoToExtStr("_m_ForwardFaildReason", paramString);
      this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.saveExtInfoToExtStr("_m_ForwardFileStatus", "2");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.QFileMsgForwardManager.FileUploadTask.1
 * JD-Core Version:    0.7.0.1
 */