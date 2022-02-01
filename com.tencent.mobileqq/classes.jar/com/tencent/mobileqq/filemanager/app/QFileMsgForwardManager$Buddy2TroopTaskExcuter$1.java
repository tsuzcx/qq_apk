package com.tencent.mobileqq.filemanager.app;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

class QFileMsgForwardManager$Buddy2TroopTaskExcuter$1
  implements FileForwardManager.ForwarResult
{
  QFileMsgForwardManager$Buddy2TroopTaskExcuter$1(QFileMsgForwardManager.Buddy2TroopTaskExcuter paramBuddy2TroopTaskExcuter, String paramString, QFileMsgForwardManager.OnUploadCallback paramOnUploadCallback) {}
  
  public void a(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Buddy2TroopTaskExcuter onFaild retcode[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("] retMsg[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("]");
    paramString = localStringBuilder.toString();
    boolean bool3 = true;
    QLog.e("FileMultiMsgManager<FileAssistant>", 1, paramString);
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool2 = bool3;
    boolean bool1 = bool5;
    if (paramInt != -100001)
    {
      bool2 = bool3;
      bool1 = bool5;
      if (paramInt != -100002) {
        if (paramInt == -100003)
        {
          bool2 = bool3;
          bool1 = bool5;
        }
        else
        {
          if (paramInt != -6101)
          {
            bool1 = bool4;
            if (paramInt != -7003) {}
          }
          else
          {
            bool1 = true;
          }
          bool2 = false;
        }
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$OnUploadCallback.a(QFileMsgForwardManager.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$Buddy2TroopTaskExcuter.jdField_a_of_type_Long, bool1), bool2);
  }
  
  public void a(String paramString1, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("_m_ForwardFileType", "3");
    localBundle.putString("_m_ForwardReceiverUin", this.jdField_a_of_type_JavaLangString);
    localBundle.putString("_m_ForwardFileName", this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$Buddy2TroopTaskExcuter.jdField_a_of_type_JavaLangString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$Buddy2TroopTaskExcuter.jdField_a_of_type_Long);
    localStringBuilder.append("");
    localBundle.putString("_m_ForwardSize", localStringBuilder.toString());
    localBundle.putString("_m_ForwardMd5", this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$Buddy2TroopTaskExcuter.d);
    localBundle.putString("_m_ForwardDeadTime", "0");
    localBundle.putString("_m_ForwardImgWidth", this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$Buddy2TroopTaskExcuter.e);
    localBundle.putString("_m_ForwardImgHeight", this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$Buddy2TroopTaskExcuter.f);
    localBundle.putString("_m_ForwardUuid", paramString1);
    localBundle.putString("_m_ForwardFileIdCrc", paramString2);
    int i;
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$Buddy2TroopTaskExcuter.e)) {
      i = 0;
    } else {
      i = Integer.parseInt(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$Buddy2TroopTaskExcuter.e);
    }
    int j;
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$Buddy2TroopTaskExcuter.f)) {
      j = 0;
    } else {
      j = Integer.parseInt(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$Buddy2TroopTaskExcuter.f);
    }
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$Buddy2TroopTaskExcuter.jdField_a_of_type_JavaLangString);
      paramString2.append(" Buddy2TroopTaskExcuter send success, send feeds");
      QLog.e("FileMultiMsgManager<FileAssistant>", 1, paramString2.toString());
    }
    QFileMsgForwardManager.a(QFileMsgForwardManager.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$Buddy2TroopTaskExcuter.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager), Long.parseLong(this.jdField_a_of_type_JavaLangString), 102, paramString1, this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$Buddy2TroopTaskExcuter.jdField_a_of_type_Long, 0, i, j, 0, false, localBundle, this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$OnUploadCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.QFileMsgForwardManager.Buddy2TroopTaskExcuter.1
 * JD-Core Version:    0.7.0.1
 */