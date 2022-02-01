package com.tencent.mobileqq.filemanager.fileassistant.util;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.qphone.base.util.QLog;

class FileResultWatchForObserver$2
  extends FMObserver
{
  FileResultWatchForObserver$2(FileResultWatchForObserver paramFileResultWatchForObserver, QQAppInterface paramQQAppInterface) {}
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    paramString2 = new StringBuilder();
    paramString2.append(paramLong2);
    paramString2.append(" transfer end, isSucc:");
    paramString2.append(paramBoolean);
    QLog.i("FileResultWatchForObserver<FileAssistant>NDL", 1, paramString2.toString());
    if (!paramBoolean) {
      return;
    }
    paramString2 = QFileAssistantUtils.b(this.a);
    if (paramString2 == null)
    {
      paramString1 = new StringBuilder();
      paramString1.append(paramLong2);
      paramString1.append(" transfer end, datalineUin is null");
      QLog.i("FileResultWatchForObserver<FileAssistant>NDL", 1, paramString1.toString());
      return;
    }
    if (!paramString2.equalsIgnoreCase(paramString1))
    {
      paramString1 = new StringBuilder();
      paramString1.append(paramLong2);
      paramString1.append(" transfer end, is not datalineUin");
      QLog.i("FileResultWatchForObserver<FileAssistant>NDL", 1, paramString1.toString());
      return;
    }
    paramString1 = this.a.getFileManagerDataCenter().a(paramLong2);
    if (!FileResultWatchForObserver.a(this.b, paramString1))
    {
      paramString1 = new StringBuilder();
      paramString1.append(paramLong2);
      paramString1.append(" transfer end, is not send to old dataline");
      QLog.i("FileResultWatchForObserver<FileAssistant>NDL", 1, paramString1.toString());
      return;
    }
    this.a.getFileManagerEngine().g(paramString1);
    paramString1 = new StringBuilder();
    paramString1.append(paramLong2);
    paramString1.append(" transfer end, forward to old dataline");
    QLog.i("FileResultWatchForObserver<FileAssistant>NDL", 1, paramString1.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileassistant.util.FileResultWatchForObserver.2
 * JD-Core Version:    0.7.0.1
 */