package com.tencent.mobileqq.filemanager.app;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.OnlineFileSessionCenter;
import com.tencent.qphone.base.util.QLog;

class FileTransferHandler$6
  implements Runnable
{
  FileTransferHandler$6(FileTransferHandler paramFileTransferHandler, long paramLong, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OLfilesession[");
    localStringBuilder.append(this.a);
    localStringBuilder.append("]  handle recv onlinefile resp. sucess =");
    localStringBuilder.append(this.b);
    QLog.i("FileTransferHandler<FileAssistant>", 1, localStringBuilder.toString());
    this.this$0.a.getOnlineFileSessionCenter().a(this.c, this.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.FileTransferHandler.6
 * JD-Core Version:    0.7.0.1
 */