package com.tencent.mobileqq.filemanager.app;

import android.os.Bundle;
import com.tencent.mobileqq.troop.filemanager.upload.TroopFileUploadMgr;
import com.tencent.mobileqq.troop.filemanager.upload.TroopFileUploadMgr.ITroopFileUploadWorkerListener;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;

class QFileMsgForwardManager$TroopUploadTaskExcuter
  extends QFileMsgForwardManager.TaskExcuter
{
  private long jdField_a_of_type_Long;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private QFileMsgForwardManager.OnUploadCallback jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$OnUploadCallback;
  private TroopFileUploadMgr.ITroopFileUploadWorkerListener jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadTroopFileUploadMgr$ITroopFileUploadWorkerListener = new QFileMsgForwardManager.TroopUploadTaskExcuter.1(this);
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
    QLog.d("FileMultiMsgManager<FileAssistant>", 1, "TroopUploadTaskExcuter begin filename " + this.jdField_a_of_type_JavaLangString);
  }
  
  void a(String paramString, int paramInt)
  {
    QLog.d("FileMultiMsgManager<FileAssistant>", 1, "TroopUploadTaskExcuter stopped WorkerId[" + this.jdField_a_of_type_JavaUtilUUID + "] filename " + this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Boolean = true;
    TroopFileUploadMgr.a().a(this.jdField_a_of_type_JavaUtilUUID, null);
  }
  
  void a(String paramString, int paramInt, QFileMsgForwardManager.OnUploadCallback paramOnUploadCallback)
  {
    if (paramOnUploadCallback == null)
    {
      QLog.e("FileMultiMsgManager<FileAssistant>", 1, "TroopUploadTaskExcuter run but callback is null filename " + this.jdField_a_of_type_JavaLangString);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$OnUploadCallback = paramOnUploadCallback;
    this.jdField_b_of_type_Long = Long.parseLong(paramString);
    this.jdField_a_of_type_AndroidOsBundle.putString("_m_ForwardReceiverUin", String.valueOf(this.jdField_b_of_type_Long));
    this.jdField_a_of_type_JavaUtilUUID = UUID.randomUUID();
    QLog.d("FileMultiMsgManager<FileAssistant>", 1, "TroopUploadTaskExcuter run WorkerId[" + this.jdField_a_of_type_JavaUtilUUID + "] filename " + this.jdField_a_of_type_JavaLangString);
    TroopFileUploadMgr.a().a(this.jdField_a_of_type_JavaUtilUUID, this.jdField_b_of_type_Long, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadTroopFileUploadMgr$ITroopFileUploadWorkerListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.QFileMsgForwardManager.TroopUploadTaskExcuter
 * JD-Core Version:    0.7.0.1
 */