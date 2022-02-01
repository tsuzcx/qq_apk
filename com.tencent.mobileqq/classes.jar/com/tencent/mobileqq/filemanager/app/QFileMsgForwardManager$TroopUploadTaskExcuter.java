package com.tencent.mobileqq.filemanager.app;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.uftwrapper.QFileTroopTransferWrapper;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;

class QFileMsgForwardManager$TroopUploadTaskExcuter
  extends QFileMsgForwardManager.TaskExcuter
{
  private long jdField_a_of_type_Long;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private QFileMsgForwardManager.OnUploadCallback jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$OnUploadCallback;
  private String jdField_a_of_type_JavaLangString;
  private UUID jdField_a_of_type_JavaUtilUUID;
  private boolean jdField_a_of_type_Boolean = false;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  
  private QFileMsgForwardManager$TroopUploadTaskExcuter(QFileMsgForwardManager paramQFileMsgForwardManager, String paramString1, String paramString2)
  {
    super(paramQFileMsgForwardManager);
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_AndroidOsBundle = new Bundle();
    this.jdField_a_of_type_AndroidOsBundle.putString("_m_ForwardFileName", this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidOsBundle.putString("_m_ForwardFilePath", this.jdField_b_of_type_JavaLangString);
    paramQFileMsgForwardManager = new StringBuilder();
    paramQFileMsgForwardManager.append("TroopUploadTaskExcuter begin filename ");
    paramQFileMsgForwardManager.append(this.jdField_a_of_type_JavaLangString);
    QLog.d("FileMultiMsgManager<FileAssistant>", 1, paramQFileMsgForwardManager.toString());
  }
  
  void a(String paramString, int paramInt)
  {
    paramString = new StringBuilder();
    paramString.append("TroopUploadTaskExcuter stopped WorkerId[");
    paramString.append(this.jdField_a_of_type_JavaUtilUUID);
    paramString.append("] filename ");
    paramString.append(this.jdField_a_of_type_JavaLangString);
    QLog.d("FileMultiMsgManager<FileAssistant>", 1, paramString.toString());
    this.jdField_a_of_type_Boolean = true;
    QFileMsgForwardManager.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager).getFileManagerEngine().a().a(this.jdField_a_of_type_JavaUtilUUID);
  }
  
  void a(String paramString, int paramInt, QFileMsgForwardManager.OnUploadCallback paramOnUploadCallback)
  {
    if (paramOnUploadCallback == null)
    {
      paramString = new StringBuilder();
      paramString.append("TroopUploadTaskExcuter run but callback is null filename ");
      paramString.append(this.jdField_a_of_type_JavaLangString);
      QLog.e("FileMultiMsgManager<FileAssistant>", 1, paramString.toString());
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$OnUploadCallback = paramOnUploadCallback;
    this.jdField_b_of_type_Long = Long.parseLong(paramString);
    this.jdField_a_of_type_AndroidOsBundle.putString("_m_ForwardReceiverUin", String.valueOf(this.jdField_b_of_type_Long));
    this.jdField_a_of_type_JavaUtilUUID = QFileMsgForwardManager.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager).getFileManagerEngine().a().a(this.jdField_b_of_type_Long, this.jdField_b_of_type_JavaLangString, new QFileMsgForwardManager.TroopUploadTaskExcuter.1(this));
    paramString = new StringBuilder();
    paramString.append("TroopUploadTaskExcuter run WorkerId[");
    paramString.append(this.jdField_a_of_type_JavaUtilUUID);
    paramString.append("] filename ");
    paramString.append(this.jdField_a_of_type_JavaLangString);
    QLog.d("FileMultiMsgManager<FileAssistant>", 1, paramString.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.QFileMsgForwardManager.TroopUploadTaskExcuter
 * JD-Core Version:    0.7.0.1
 */