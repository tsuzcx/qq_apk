package com.tencent.mobileqq.filemanager.app;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;

class QFileMsgForwardManager$Buddy2BuddyTaskExcuter
  extends QFileMsgForwardManager.TaskExcuter
{
  protected String a;
  protected String b;
  protected String c;
  protected String d;
  protected String e;
  protected String f;
  protected String g;
  protected long h;
  protected String i;
  
  QFileMsgForwardManager$Buddy2BuddyTaskExcuter(QFileMsgForwardManager paramQFileMsgForwardManager, MessageRecord paramMessageRecord)
  {
    super(paramQFileMsgForwardManager);
    this.a = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardFileName");
    this.h = Long.parseLong(paramMessageRecord.getExtInfoFromExtStr("_m_ForwardSize"));
    this.b = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardUuid");
    this.c = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardFileIdCrc");
    this.d = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardMd5");
    this.e = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardFilePath");
    this.f = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardImgWidth");
    this.g = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardImgHeight");
    this.i = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardStatusPaused");
  }
  
  void a(String paramString, int paramInt) {}
  
  void a(String paramString, int paramInt, QFileMsgForwardManager.OnUploadCallback paramOnUploadCallback)
  {
    if ("1".equals(this.i))
    {
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("start Buddy2BuddyTaskExcuter:");
        paramString.append(this.a);
        paramString.append(" faild, file is upload paused");
        QLog.i("FileMultiMsgManager<FileAssistant>", 1, paramString.toString());
      }
      paramOnUploadCallback.a(QFileMsgForwardManager.a(this.h, false), false);
      return;
    }
    Object localObject = this.b;
    if ((localObject != null) && (((String)localObject).length() != 0))
    {
      localObject = QFileMsgForwardManager.a(this.j).getFileManagerEngine().b();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("start forwardOfflineFileToX[");
        localStringBuilder.append(this.a);
        localStringBuilder.append("]");
        QLog.i("FileMultiMsgManager<FileAssistant>", 1, localStringBuilder.toString());
      }
      ((FileForwardManager)localObject).a(paramString, paramInt, this.b, this.c, this.a, this.h, 3, new QFileMsgForwardManager.Buddy2BuddyTaskExcuter.1(this, paramString, paramOnUploadCallback));
      return;
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("start Buddy2BuddyTaskExcuter:");
      paramString.append(this.a);
      paramString.append(" faild, file uuid is null");
      QLog.i("FileMultiMsgManager<FileAssistant>", 1, paramString.toString());
    }
    paramOnUploadCallback.a(QFileMsgForwardManager.a(this.h, true), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.QFileMsgForwardManager.Buddy2BuddyTaskExcuter
 * JD-Core Version:    0.7.0.1
 */