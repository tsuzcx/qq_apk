package com.tencent.mobileqq.filemanager.app;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class QFileMsgForwardManager$Buddy2BuddyTaskExcuter$1
  implements FileForwardManager.ForwarResult
{
  QFileMsgForwardManager$Buddy2BuddyTaskExcuter$1(QFileMsgForwardManager.Buddy2BuddyTaskExcuter paramBuddy2BuddyTaskExcuter, String paramString, QFileMsgForwardManager.OnUploadCallback paramOnUploadCallback) {}
  
  public void a(int paramInt, String paramString)
  {
    QLog.e("FileMultiMsgManager<FileAssistant>", 1, "Buddy2BuddyTaskExcuter faild");
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
      paramString.append("start forwardOfflineFileToX[");
      paramString.append(this.c.a);
      paramString.append("] faild:");
      paramString.append(paramInt);
      QLog.i("FileMultiMsgManager<FileAssistant>", 1, paramString.toString());
    }
    this.b.a(QFileMsgForwardManager.a(this.c.h, bool2), bool1);
  }
  
  public void a(String paramString1, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("_m_ForwardFileType", "1");
    localBundle.putString("_m_ForwardReceiverUin", this.a);
    localBundle.putString("_m_ForwardFileName", this.c.a);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.c.h);
    localStringBuilder.append("");
    localBundle.putString("_m_ForwardSize", localStringBuilder.toString());
    localBundle.putString("_m_ForwardMd5", this.c.d);
    localBundle.putString("_m_ForwardUuid", paramString1);
    localBundle.putString("_m_ForwardFileIdCrc", paramString2);
    localBundle.putString("_m_ForwardDeadTime", "0");
    localBundle.putString("_m_ForwardImgWidth", this.c.f);
    localBundle.putString("_m_ForwardImgHeight", this.c.g);
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("start forwardOfflineFileToX[");
      paramString2.append(this.c.a);
      paramString2.append("] success");
      QLog.i("FileMultiMsgManager<FileAssistant>", 1, paramString2.toString());
    }
    this.b.a(paramString1, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.QFileMsgForwardManager.Buddy2BuddyTaskExcuter.1
 * JD-Core Version:    0.7.0.1
 */