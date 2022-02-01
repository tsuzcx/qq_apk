package com.tencent.mobileqq.filemanager.core;

import com.tencent.mobileqq.app.QQAppInterface;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

class FileManagerRSWorker$4
  implements Runnable
{
  FileManagerRSWorker$4(FileManagerRSWorker paramFileManagerRSWorker, String paramString) {}
  
  public void run()
  {
    try
    {
      if (this.this$0.u == null) {
        this.this$0.u = new FileOutputStream(this.this$0.e, true);
      }
      this.this$0.a.getFileManagerDataCenter().a(this.this$0.r, 2002);
      this.this$0.B.status = 0;
      this.this$0.a.getFileManagerDataCenter().c(this.this$0.B);
      this.this$0.B.status = 2;
      this.this$0.t = this.a;
      FileManagerRSWorker.a(this.this$0, this.this$0.o, this.this$0.t);
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      localFileNotFoundException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FileManagerRSWorker.4
 * JD-Core Version:    0.7.0.1
 */