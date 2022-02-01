package com.tencent.mobileqq.filemanager.app;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;

class QFileMsgForwardManager$Disc2DiscTaskExcuter
  extends QFileMsgForwardManager.TaskExcuter
{
  protected String a;
  protected String b;
  protected String c;
  protected String d;
  protected String e;
  protected String f;
  protected long g;
  protected String h;
  
  QFileMsgForwardManager$Disc2DiscTaskExcuter(QFileMsgForwardManager paramQFileMsgForwardManager, MessageRecord paramMessageRecord)
  {
    super(paramQFileMsgForwardManager);
    this.a = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardFileName");
    this.g = Long.parseLong(paramMessageRecord.getExtInfoFromExtStr("_m_ForwardSize"));
    this.b = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardUuid");
    this.c = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardMd5");
    this.d = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardReceiverUin");
    this.e = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardImgWidth");
    this.f = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardImgHeight");
    this.h = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardStatusPaused");
  }
  
  void a(String paramString, int paramInt) {}
  
  void a(String paramString, int paramInt, QFileMsgForwardManager.OnUploadCallback paramOnUploadCallback)
  {
    if ("1".equals(this.h))
    {
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("start Disc2DiscTaskExcuter:");
        paramString.append(this.a);
        paramString.append(" faild, file is upload paused");
        QLog.i("FileMultiMsgManager<FileAssistant>", 1, paramString.toString());
      }
      paramOnUploadCallback.a(QFileMsgForwardManager.a(this.g, false), false);
      return;
    }
    String str = this.b;
    if ((str != null) && (str.length() != 0))
    {
      QFileMsgForwardManager.a(this.i).getFileManagerEngine().b().a(paramString, paramInt, this.d, 106, this.b, this.a, this.g, this.c, new QFileMsgForwardManager.Disc2DiscTaskExcuter.1(this, paramString, paramOnUploadCallback));
      return;
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append(this.a);
      paramString.append(" Disc2DiscTaskExcuter send faild uuid is null");
      QLog.e("FileMultiMsgManager<FileAssistant>", 1, paramString.toString());
    }
    paramOnUploadCallback.a(QFileMsgForwardManager.a(this.g, true), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.QFileMsgForwardManager.Disc2DiscTaskExcuter
 * JD-Core Version:    0.7.0.1
 */