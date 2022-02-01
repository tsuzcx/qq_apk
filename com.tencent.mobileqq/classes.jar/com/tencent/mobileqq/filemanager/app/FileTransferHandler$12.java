package com.tencent.mobileqq.filemanager.app;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

class FileTransferHandler$12
  implements Runnable
{
  FileTransferHandler$12(FileTransferHandler paramFileTransferHandler, FileManagerEntity paramFileManagerEntity) {}
  
  public void run()
  {
    StringBuilder localStringBuilder;
    if (this.a.nFileType == 0)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Id[");
      localStringBuilder.append(this.a.nSessionId);
      localStringBuilder.append("]Send CCMsg, but not size and thumb, try download Pic Thumb");
      QLog.i("FileTransferHandler<FileAssistant>", 1, localStringBuilder.toString());
      this.this$0.a.getFileManagerEngine().d(this.a, 7);
      return;
    }
    if (this.a.nFileType == 2)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Id[");
      localStringBuilder.append(this.a.nSessionId);
      localStringBuilder.append("]Send CCMsg, but not size and thumb, try download Video Thumb");
      QLog.i("FileTransferHandler<FileAssistant>", 1, localStringBuilder.toString());
      this.this$0.a.getFileManagerEngine().c(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.FileTransferHandler.12
 * JD-Core Version:    0.7.0.1
 */