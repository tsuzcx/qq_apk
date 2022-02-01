package com.tencent.mobileqq.filemanager.multisave;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForDLFile;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.qphone.base.util.QLog;

public abstract class QFileSaveModel
{
  protected QQAppInterface a;
  protected ChatMessage b;
  protected QFileSaveReqUiCallback c;
  
  public QFileSaveModel(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    this.a = paramQQAppInterface;
    this.b = paramChatMessage;
  }
  
  public static QFileSaveModel a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    if (paramChatMessage == null)
    {
      QLog.e("QFileSaveModel<QFile>", 1, "buildFileSaveModel: message is null");
      return null;
    }
    if ((paramChatMessage instanceof MessageForFile)) {
      return new OfflineFileSaveModel(paramQQAppInterface, paramChatMessage);
    }
    if ((paramChatMessage instanceof MessageForTroopFile)) {
      return new TroopFileSaveModel(paramQQAppInterface, paramChatMessage);
    }
    if ((paramChatMessage instanceof MessageForDLFile)) {
      return new DatalineFileSaveModel(paramQQAppInterface, paramChatMessage);
    }
    paramQQAppInterface = new StringBuilder();
    paramQQAppInterface.append("buildFileSaveModel: message is not support. messageType[");
    paramQQAppInterface.append(paramChatMessage.getClass().getName());
    paramQQAppInterface.append("]");
    QLog.e("QFileSaveModel<QFile>", 1, paramQQAppInterface.toString());
    return null;
  }
  
  public void a(QFileSaveReqUiCallback paramQFileSaveReqUiCallback)
  {
    this.c = paramQFileSaveReqUiCallback;
  }
  
  public abstract boolean a();
  
  public abstract boolean b();
  
  public abstract String c();
  
  public abstract boolean d();
  
  public abstract QFileControlReq e();
  
  public abstract String f();
  
  public abstract long g();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.multisave.QFileSaveModel
 * JD-Core Version:    0.7.0.1
 */