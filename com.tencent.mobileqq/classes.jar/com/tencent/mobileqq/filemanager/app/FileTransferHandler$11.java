package com.tencent.mobileqq.filemanager.app;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.OnlineFileSessionCenter;
import com.tencent.qphone.base.util.QLog;

class FileTransferHandler$11
  implements Runnable
{
  FileTransferHandler$11(FileTransferHandler paramFileTransferHandler, long paramLong1, String paramString1, int paramInt, String paramString2, long paramLong2) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OLfilesession[");
    localStringBuilder.append(this.a);
    localStringBuilder.append("] upload competed:");
    QLog.i("FileTransferHandler<FileAssistant>", 1, localStringBuilder.toString());
    this.this$0.a.getOnlineFileSessionCenter().a(this.b, this.a, this.c, this.d, this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.FileTransferHandler.11
 * JD-Core Version:    0.7.0.1
 */