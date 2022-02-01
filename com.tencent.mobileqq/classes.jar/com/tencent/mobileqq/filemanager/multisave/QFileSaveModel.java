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
  protected ChatMessage a;
  protected QFileSaveReqUiCallback a;
  
  public QFileSaveModel(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
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
    QLog.e("QFileSaveModel<QFile>", 1, "buildFileSaveModel: message is not support. messageType[" + paramChatMessage.getClass().getName() + "]");
    return null;
  }
  
  public abstract long a();
  
  public abstract QFileControlReq a();
  
  public abstract String a();
  
  public void a(QFileSaveReqUiCallback paramQFileSaveReqUiCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerMultisaveQFileSaveReqUiCallback = paramQFileSaveReqUiCallback;
  }
  
  public abstract boolean a();
  
  public abstract String b();
  
  public abstract boolean b();
  
  public abstract boolean c();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.multisave.QFileSaveModel
 * JD-Core Version:    0.7.0.1
 */