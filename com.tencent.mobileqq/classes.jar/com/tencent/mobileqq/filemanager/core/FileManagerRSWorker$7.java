package com.tencent.mobileqq.filemanager.core;

import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.OutputStream;

class FileManagerRSWorker$7
  implements Runnable
{
  FileManagerRSWorker$7(FileManagerRSWorker paramFileManagerRSWorker) {}
  
  public void run()
  {
    if (this.this$0.n == 0)
    {
      if (this.this$0.h != null)
      {
        FileManagerRSWorker localFileManagerRSWorker = this.this$0;
        localFileManagerRSWorker.a(localFileManagerRSWorker.h, 0L);
        return;
      }
      this.this$0.s();
      return;
    }
    if (this.this$0.h.equalsIgnoreCase(""))
    {
      this.this$0.d();
      return;
    }
    try
    {
      if (this.this$0.u != null) {
        this.this$0.u.flush();
      }
    }
    catch (IOException localIOException)
    {
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, localIOException.getMessage());
    }
    Object localObject = this.this$0;
    ((FileManagerRSWorker)localObject).o = FileManagerUtil.h(((FileManagerRSWorker)localObject).e);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("nSessionId[");
    ((StringBuilder)localObject).append(this.this$0.r);
    ((StringBuilder)localObject).append("]retry request Httpmsg,rd[");
    ((StringBuilder)localObject).append(String.valueOf(this.this$0.o));
    ((StringBuilder)localObject).append("]");
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    localObject = this.this$0;
    FileManagerRSWorker.a((FileManagerRSWorker)localObject, ((FileManagerRSWorker)localObject).o, this.this$0.t);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FileManagerRSWorker.7
 * JD-Core Version:    0.7.0.1
 */