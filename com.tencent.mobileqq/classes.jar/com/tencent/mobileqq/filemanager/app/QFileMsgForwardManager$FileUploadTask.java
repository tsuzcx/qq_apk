package com.tencent.mobileqq.filemanager.app;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;

class QFileMsgForwardManager$FileUploadTask
{
  int jdField_a_of_type_Int;
  MessageRecord jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  QFileMsgForwardManager.OnUploadCallback jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$OnUploadCallback;
  QFileMsgForwardManager.TaskExcuter jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$TaskExcuter;
  String jdField_a_of_type_JavaLangString;
  int jdField_b_of_type_Int = 0;
  String jdField_b_of_type_JavaLangString;
  
  QFileMsgForwardManager$FileUploadTask(QFileMsgForwardManager paramQFileMsgForwardManager, String paramString1, String paramString2, int paramInt, MessageRecord paramMessageRecord)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageRecord;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$OnUploadCallback = new QFileMsgForwardManager.FileUploadTask.1(this, paramQFileMsgForwardManager, paramMessageRecord);
  }
  
  void a()
  {
    StringBuilder localStringBuilder;
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$TaskExcuter != null) && (this.jdField_b_of_type_Int == 0))
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("task excute : run task suc. status[");
        localStringBuilder.append(this.jdField_b_of_type_Int);
        localStringBuilder.append("]");
        QLog.i("FileMultiMsgManager<FileAssistant>", 1, localStringBuilder.toString());
      }
      this.jdField_b_of_type_Int = 1;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$TaskExcuter.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$OnUploadCallback);
      return;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("task excute : run task fail. status[");
      localStringBuilder.append(this.jdField_b_of_type_Int);
      localStringBuilder.append("]");
      QLog.i("FileMultiMsgManager<FileAssistant>", 1, localStringBuilder.toString());
    }
  }
  
  void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$TaskExcuter != null)
    {
      int i = this.jdField_b_of_type_Int;
      if ((i == 1) || (i == 0))
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$TaskExcuter.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int);
        this.jdField_b_of_type_Int = 4;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.QFileMsgForwardManager.FileUploadTask
 * JD-Core Version:    0.7.0.1
 */