package com.tencent.mobileqq.filemanager.app;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;

class QFileMsgForwardManager$FileUploadTask
{
  String a;
  QFileMsgForwardManager.TaskExcuter b;
  QFileMsgForwardManager.OnUploadCallback c;
  MessageRecord d;
  String e;
  int f;
  int g = 0;
  
  QFileMsgForwardManager$FileUploadTask(QFileMsgForwardManager paramQFileMsgForwardManager, String paramString1, String paramString2, int paramInt, MessageRecord paramMessageRecord)
  {
    this.a = paramString1;
    this.f = paramInt;
    this.e = paramString2;
    this.d = paramMessageRecord;
    this.c = new QFileMsgForwardManager.FileUploadTask.1(this, paramQFileMsgForwardManager, paramMessageRecord);
  }
  
  void a()
  {
    StringBuilder localStringBuilder;
    if ((this.b != null) && (this.g == 0))
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("task excute : run task suc. status[");
        localStringBuilder.append(this.g);
        localStringBuilder.append("]");
        QLog.i("FileMultiMsgManager<FileAssistant>", 1, localStringBuilder.toString());
      }
      this.g = 1;
      this.b.a(this.e, this.f, this.c);
      return;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("task excute : run task fail. status[");
      localStringBuilder.append(this.g);
      localStringBuilder.append("]");
      QLog.i("FileMultiMsgManager<FileAssistant>", 1, localStringBuilder.toString());
    }
  }
  
  void b()
  {
    if (this.b != null)
    {
      int i = this.g;
      if ((i == 1) || (i == 0))
      {
        this.b.a(this.e, this.f);
        this.g = 4;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.QFileMsgForwardManager.FileUploadTask
 * JD-Core Version:    0.7.0.1
 */