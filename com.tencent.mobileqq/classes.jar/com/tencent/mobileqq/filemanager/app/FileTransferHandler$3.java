package com.tencent.mobileqq.filemanager.app;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.FileManagerProxy;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.qphone.base.util.QLog;

class FileTransferHandler$3
  implements Runnable
{
  FileTransferHandler$3(FileTransferHandler paramFileTransferHandler, String paramString, int paramInt, short paramShort, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    FileManagerEntity localFileManagerEntity = this.this$0.a.getFileManagerDataCenter().a(this.a, this.b);
    if (localFileManagerEntity != null)
    {
      localFileManagerEntity.msgSeq = this.c;
      localFileManagerEntity.msgUid = this.d;
      localFileManagerEntity.msgTime = this.e;
      this.this$0.a.getFileManagerProxy().f(localFileManagerEntity);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("online change to offline, update offline msg seq , uid and msgTime");
        localStringBuilder.append(FileManagerUtil.c(localFileManagerEntity));
        QLog.d("FileTransferHandler<FileAssistant>", 2, localStringBuilder.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.FileTransferHandler.3
 * JD-Core Version:    0.7.0.1
 */