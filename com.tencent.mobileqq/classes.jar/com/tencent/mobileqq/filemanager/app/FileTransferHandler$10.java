package com.tencent.mobileqq.filemanager.app;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.OnlineFileSessionCenter;
import com.tencent.qphone.base.util.QLog;

class FileTransferHandler$10
  implements Runnable
{
  FileTransferHandler$10(FileTransferHandler paramFileTransferHandler, long paramLong, int paramInt1, int paramInt2, String paramString) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OLfilesession[");
    localStringBuilder.append(this.a);
    localStringBuilder.append("] Handle upload progress notify. speed=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" progress =");
    localStringBuilder.append(this.c);
    QLog.i("FileTransferHandler<FileAssistant>", 1, localStringBuilder.toString());
    this.this$0.a.getOnlineFileSessionCenter().a(this.d, this.a, this.b, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.FileTransferHandler.10
 * JD-Core Version:    0.7.0.1
 */