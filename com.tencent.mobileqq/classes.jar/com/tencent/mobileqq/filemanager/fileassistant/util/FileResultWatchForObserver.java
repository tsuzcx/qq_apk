package com.tencent.mobileqq.filemanager.fileassistant.util;

import android.text.TextUtils;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

public class FileResultWatchForObserver
{
  private FMObserver a = null;
  private MessageObserver b = null;
  
  public FileResultWatchForObserver(QQAppInterface paramQQAppInterface)
  {
    b(paramQQAppInterface);
  }
  
  private boolean a(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null)
    {
      QLog.e("FileResultWatchForObserver<FileAssistant>NDL", 1, "entity is null!");
      return false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("entity:");
    localStringBuilder.append(paramFileManagerEntity.nSessionId);
    localStringBuilder.append(", opType:");
    localStringBuilder.append(paramFileManagerEntity.nOpType);
    QLog.e("FileResultWatchForObserver<FileAssistant>NDL", 1, localStringBuilder.toString());
    if ((paramFileManagerEntity.nOpType != 0) && (paramFileManagerEntity.nOpType != 3) && (paramFileManagerEntity.nOpType != 7) && (paramFileManagerEntity.nOpType != 21) && (paramFileManagerEntity.nOpType != 24))
    {
      if (paramFileManagerEntity.nOpType == 37) {
        return true;
      }
      if ((paramFileManagerEntity.nOpType == 51) && (!TextUtils.isEmpty(paramFileManagerEntity.Uuid)))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("entity:");
        localStringBuilder.append(paramFileManagerEntity.nSessionId);
        localStringBuilder.append(", has uuid, Send to old dataline!");
        QLog.e("FileResultWatchForObserver<FileAssistant>NDL", 1, localStringBuilder.toString());
        return true;
      }
      return false;
    }
    return true;
  }
  
  private void b(QQAppInterface paramQQAppInterface)
  {
    d(paramQQAppInterface);
    c(paramQQAppInterface);
  }
  
  private void c(QQAppInterface paramQQAppInterface)
  {
    if (this.b != null)
    {
      QLog.w("FileResultWatchForObserver<FileAssistant>NDL", 1, "TextMsgSendResultObserver may be inited");
      return;
    }
    this.b = new FileResultWatchForObserver.1(this, paramQQAppInterface);
    paramQQAppInterface.addDefaultObservers(this.b);
  }
  
  private void d(QQAppInterface paramQQAppInterface)
  {
    if (this.a != null)
    {
      QLog.w("FileResultWatchForObserver<FileAssistant>NDL", 1, "FileResultWatchForObserver may be inited");
      return;
    }
    this.a = new FileResultWatchForObserver.2(this, paramQQAppInterface);
    paramQQAppInterface.getFileManagerNotifyCenter().addObserver(this.a);
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (this.a != null)
    {
      paramQQAppInterface.getFileManagerNotifyCenter().deleteObserver(this.a);
      this.a = null;
    }
    MessageObserver localMessageObserver = this.b;
    if (localMessageObserver != null)
    {
      paramQQAppInterface.removeObserver(localMessageObserver);
      this.b = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileassistant.util.FileResultWatchForObserver
 * JD-Core Version:    0.7.0.1
 */