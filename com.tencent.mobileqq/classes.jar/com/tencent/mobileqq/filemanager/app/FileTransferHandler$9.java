package com.tencent.mobileqq.filemanager.app;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.OnlineFileSessionCenter;
import com.tencent.qphone.base.util.QLog;

class FileTransferHandler$9
  implements Runnable
{
  FileTransferHandler$9(FileTransferHandler paramFileTransferHandler, long paramLong, int paramInt, String paramString1, String paramString2) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OLfilesession[");
    localStringBuilder.append(this.a);
    localStringBuilder.append("] Handle upload failed notify. retCode =");
    localStringBuilder.append(this.b);
    localStringBuilder.append("(1:cancel upload) reason=");
    localStringBuilder.append(this.c);
    QLog.i("FileTransferHandler<FileAssistant>", 1, localStringBuilder.toString());
    int i = this.b;
    if (1 == i)
    {
      this.this$0.a.getOnlineFileSessionCenter().b(this.d, this.a);
      return;
    }
    if (2 == i)
    {
      this.this$0.a.getOnlineFileSessionCenter().b(this.d, this.a);
      return;
    }
    if (3 == i)
    {
      this.this$0.a.getOnlineFileSessionCenter().d(this.d, this.a);
      return;
    }
    this.this$0.a.getOnlineFileSessionCenter().b(this.d, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.FileTransferHandler.9
 * JD-Core Version:    0.7.0.1
 */