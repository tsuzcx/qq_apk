package com.tencent.mobileqq.filemanager.app;

import atqx;
import atrd;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

public class FileTransferHandler$12
  implements Runnable
{
  public FileTransferHandler$12(atrd paramatrd, FileManagerEntity paramFileManagerEntity) {}
  
  public void run()
  {
    if (this.a.nFileType == 0)
    {
      QLog.i("FileTransferHandler<FileAssistant>", 1, "Id[" + this.a.nSessionId + "]Send CCMsg, but not size and thumb, try download Pic Thumb");
      this.this$0.a.a().b(this.a, 7);
    }
    while (this.a.nFileType != 2) {
      return;
    }
    QLog.i("FileTransferHandler<FileAssistant>", 1, "Id[" + this.a.nSessionId + "]Send CCMsg, but not size and thumb, try download Video Thumb");
    this.this$0.a.a().b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.FileTransferHandler.12
 * JD-Core Version:    0.7.0.1
 */