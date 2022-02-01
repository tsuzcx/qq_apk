package com.tencent.mobileqq.filemanager.app;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

class QFileMsgForwardManager$Disc2TroopTaskExcuter$1
  implements FileForwardManager.ForwarResult
{
  QFileMsgForwardManager$Disc2TroopTaskExcuter$1(QFileMsgForwardManager.Disc2TroopTaskExcuter paramDisc2TroopTaskExcuter, String paramString, QFileMsgForwardManager.OnUploadCallback paramOnUploadCallback) {}
  
  public void a(int paramInt, String paramString)
  {
    QLog.e("FileMultiMsgManager<FileAssistant>", 1, "Disc2TroopTaskExcuter onFaild：");
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
      paramString.append(this.c.a);
      paramString.append(" Disc2TroopTaskExcuter send faild:");
      paramString.append(paramInt);
      QLog.e("FileMultiMsgManager<FileAssistant>", 1, paramString.toString());
    }
    this.b.a(QFileMsgForwardManager.a(this.c.g, bool2), bool1);
  }
  
  public void a(String paramString1, String paramString2)
  {
    paramString2 = new Bundle();
    paramString2.putString("_m_ForwardFileType", "3");
    paramString2.putString("_m_ForwardReceiverUin", this.a);
    paramString2.putString("_m_ForwardFileName", this.c.a);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.c.g);
    localStringBuilder.append("");
    paramString2.putString("_m_ForwardSize", localStringBuilder.toString());
    paramString2.putString("_m_ForwardMd5", this.c.c);
    paramString2.putString("_m_ForwardDeadTime", "0");
    paramString2.putString("_m_ForwardImgWidth", this.c.e);
    paramString2.putString("_m_ForwardImgHeight", this.c.f);
    paramString2.putString("_m_ForwardUuid", paramString1);
    int i;
    if (TextUtils.isEmpty(this.c.e)) {
      i = 0;
    } else {
      i = Integer.parseInt(this.c.e);
    }
    int j;
    if (TextUtils.isEmpty(this.c.f)) {
      j = 0;
    } else {
      j = Integer.parseInt(this.c.f);
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.c.a);
      localStringBuilder.append(" Disc2TroopTaskExcuter send success send feeds");
      QLog.e("FileMultiMsgManager<FileAssistant>", 1, localStringBuilder.toString());
    }
    QFileMsgForwardManager.a(QFileMsgForwardManager.a(this.c.i), Long.parseLong(this.a), 102, paramString1, this.c.g, 0, i, j, 0, false, paramString2, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.QFileMsgForwardManager.Disc2TroopTaskExcuter.1
 * JD-Core Version:    0.7.0.1
 */