package com.tencent.mobileqq.filemanager.app;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class QFileMsgForwardManager$Buddy2BuddyTaskExcuter$1
  implements FileForwardManager.ForwarResult
{
  QFileMsgForwardManager$Buddy2BuddyTaskExcuter$1(QFileMsgForwardManager.Buddy2BuddyTaskExcuter paramBuddy2BuddyTaskExcuter, String paramString, QFileMsgForwardManager.OnUploadCallback paramOnUploadCallback) {}
  
  public void a(int paramInt, String paramString)
  {
    boolean bool2 = false;
    QLog.e("FileMultiMsgManager<FileAssistant>", 1, "Buddy2BuddyTaskExcuter faild");
    boolean bool1;
    if ((paramInt == -100001) || (paramInt == -100002) || (paramInt == -100003)) {
      bool1 = true;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileMultiMsgManager<FileAssistant>", 1, "start forwardOfflineFileToX[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$Buddy2BuddyTaskExcuter.jdField_a_of_type_JavaLangString + "] faild:" + paramInt);
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$OnUploadCallback.a(QFileMsgForwardManager.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$Buddy2BuddyTaskExcuter.jdField_a_of_type_Long, bool2), bool1);
      return;
      if ((paramInt == -6101) || (paramInt == -7003))
      {
        bool1 = false;
        bool2 = true;
      }
      else
      {
        bool1 = false;
      }
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("_m_ForwardFileType", "1");
    localBundle.putString("_m_ForwardReceiverUin", this.jdField_a_of_type_JavaLangString);
    localBundle.putString("_m_ForwardFileName", this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$Buddy2BuddyTaskExcuter.jdField_a_of_type_JavaLangString);
    localBundle.putString("_m_ForwardSize", this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$Buddy2BuddyTaskExcuter.jdField_a_of_type_Long + "");
    localBundle.putString("_m_ForwardMd5", this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$Buddy2BuddyTaskExcuter.d);
    localBundle.putString("_m_ForwardUuid", paramString1);
    localBundle.putString("_m_ForwardFileIdCrc", paramString2);
    localBundle.putString("_m_ForwardDeadTime", "0");
    localBundle.putString("_m_ForwardImgWidth", this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$Buddy2BuddyTaskExcuter.f);
    localBundle.putString("_m_ForwardImgHeight", this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$Buddy2BuddyTaskExcuter.g);
    if (QLog.isColorLevel()) {
      QLog.i("FileMultiMsgManager<FileAssistant>", 1, "start forwardOfflineFileToX[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$Buddy2BuddyTaskExcuter.jdField_a_of_type_JavaLangString + "] success");
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$OnUploadCallback.a(paramString1, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.QFileMsgForwardManager.Buddy2BuddyTaskExcuter.1
 * JD-Core Version:    0.7.0.1
 */