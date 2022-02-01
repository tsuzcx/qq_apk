package com.tencent.mobileqq.filemanager.app;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.uftwrapper.QFileTroopTransferWrapper;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;

class QFileMsgForwardManager$TroopUploadTaskExcuter
  extends QFileMsgForwardManager.TaskExcuter
{
  private String b;
  private String c;
  private long d;
  private Bundle e;
  private long f;
  private QFileMsgForwardManager.OnUploadCallback g;
  private UUID h;
  private boolean i = false;
  
  private QFileMsgForwardManager$TroopUploadTaskExcuter(QFileMsgForwardManager paramQFileMsgForwardManager, String paramString1, String paramString2)
  {
    super(paramQFileMsgForwardManager);
    this.b = paramString1;
    this.c = paramString2;
    this.e = new Bundle();
    this.e.putString("_m_ForwardFileName", this.b);
    this.e.putString("_m_ForwardFilePath", this.c);
    paramQFileMsgForwardManager = new StringBuilder();
    paramQFileMsgForwardManager.append("TroopUploadTaskExcuter begin filename ");
    paramQFileMsgForwardManager.append(this.b);
    QLog.d("FileMultiMsgManager<FileAssistant>", 1, paramQFileMsgForwardManager.toString());
  }
  
  void a(String paramString, int paramInt)
  {
    paramString = new StringBuilder();
    paramString.append("TroopUploadTaskExcuter stopped WorkerId[");
    paramString.append(this.h);
    paramString.append("] filename ");
    paramString.append(this.b);
    QLog.d("FileMultiMsgManager<FileAssistant>", 1, paramString.toString());
    this.i = true;
    QFileMsgForwardManager.a(this.a).getFileManagerEngine().m().a(this.h);
  }
  
  void a(String paramString, int paramInt, QFileMsgForwardManager.OnUploadCallback paramOnUploadCallback)
  {
    if (paramOnUploadCallback == null)
    {
      paramString = new StringBuilder();
      paramString.append("TroopUploadTaskExcuter run but callback is null filename ");
      paramString.append(this.b);
      QLog.e("FileMultiMsgManager<FileAssistant>", 1, paramString.toString());
      return;
    }
    this.g = paramOnUploadCallback;
    this.f = Long.parseLong(paramString);
    this.e.putString("_m_ForwardReceiverUin", String.valueOf(this.f));
    this.h = QFileMsgForwardManager.a(this.a).getFileManagerEngine().m().a(this.f, this.c, new QFileMsgForwardManager.TroopUploadTaskExcuter.1(this));
    paramString = new StringBuilder();
    paramString.append("TroopUploadTaskExcuter run WorkerId[");
    paramString.append(this.h);
    paramString.append("] filename ");
    paramString.append(this.b);
    QLog.d("FileMultiMsgManager<FileAssistant>", 1, paramString.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.QFileMsgForwardManager.TroopUploadTaskExcuter
 * JD-Core Version:    0.7.0.1
 */