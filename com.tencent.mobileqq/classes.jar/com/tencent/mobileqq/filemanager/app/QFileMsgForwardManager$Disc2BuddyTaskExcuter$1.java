package com.tencent.mobileqq.filemanager.app;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class QFileMsgForwardManager$Disc2BuddyTaskExcuter$1
  implements FileForwardManager.ForwarResult
{
  QFileMsgForwardManager$Disc2BuddyTaskExcuter$1(QFileMsgForwardManager.Disc2BuddyTaskExcuter paramDisc2BuddyTaskExcuter, String paramString, QFileMsgForwardManager.OnUploadCallback paramOnUploadCallback) {}
  
  public void a(int paramInt, String paramString)
  {
    QLog.e("FileMultiMsgManager<FileAssistant>", 1, "Disc2BuddyTaskExcuter onFaild：");
    boolean bool2 = false;
    boolean bool1 = false;
    if ((paramInt != -100001) && (paramInt != -100002) && (paramInt != -100003))
    {
      if ((paramInt == -6101) || (paramInt == -7003))
      {
        boolean bool3 = true;
        bool1 = bool2;
        bool2 = bool3;
        break label66;
      }
    }
    else {
      bool1 = true;
    }
    bool2 = false;
    label66:
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$Disc2BuddyTaskExcuter.jdField_a_of_type_JavaLangString);
      paramString.append(" Disc2BuddyTaskExcuter send faild:");
      paramString.append(paramInt);
      QLog.e("FileMultiMsgManager<FileAssistant>", 1, paramString.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$OnUploadCallback.a(QFileMsgForwardManager.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$Disc2BuddyTaskExcuter.jdField_a_of_type_Long, bool2), bool1);
  }
  
  public void a(String paramString1, String paramString2)
  {
    paramString2 = new Bundle();
    paramString2.putString("_m_ForwardFileType", "1");
    paramString2.putString("_m_ForwardReceiverUin", this.jdField_a_of_type_JavaLangString);
    paramString2.putString("_m_ForwardFileName", this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$Disc2BuddyTaskExcuter.jdField_a_of_type_JavaLangString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$Disc2BuddyTaskExcuter.jdField_a_of_type_Long);
    localStringBuilder.append("");
    paramString2.putString("_m_ForwardSize", localStringBuilder.toString());
    paramString2.putString("_m_ForwardMd5", this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$Disc2BuddyTaskExcuter.c);
    paramString2.putString("_m_ForwardDeadTime", "0");
    paramString2.putString("_m_ForwardImgWidth", this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$Disc2BuddyTaskExcuter.e);
    paramString2.putString("_m_ForwardImgHeight", this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$Disc2BuddyTaskExcuter.f);
    paramString2.putString("_m_ForwardUuid", paramString1);
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$Disc2BuddyTaskExcuter.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(" Disc2BuddyTaskExcuter send success");
      QLog.e("FileMultiMsgManager<FileAssistant>", 1, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$OnUploadCallback.a(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.QFileMsgForwardManager.Disc2BuddyTaskExcuter.1
 * JD-Core Version:    0.7.0.1
 */