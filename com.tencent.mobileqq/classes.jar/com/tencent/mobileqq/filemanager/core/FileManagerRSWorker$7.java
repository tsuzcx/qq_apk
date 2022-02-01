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
    if (this.this$0.b == 0)
    {
      if (this.this$0.f != null)
      {
        FileManagerRSWorker localFileManagerRSWorker = this.this$0;
        localFileManagerRSWorker.a(localFileManagerRSWorker.f, 0L);
        return;
      }
      this.this$0.b();
      return;
    }
    if (this.this$0.f.equalsIgnoreCase(""))
    {
      this.this$0.a();
      return;
    }
    try
    {
      if (this.this$0.jdField_a_of_type_JavaIoOutputStream != null) {
        this.this$0.jdField_a_of_type_JavaIoOutputStream.flush();
      }
    }
    catch (IOException localIOException)
    {
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, localIOException.getMessage());
    }
    Object localObject = this.this$0;
    ((FileManagerRSWorker)localObject).jdField_a_of_type_Long = FileManagerUtil.a(((FileManagerRSWorker)localObject).d);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("nSessionId[");
    ((StringBuilder)localObject).append(this.this$0.c);
    ((StringBuilder)localObject).append("]retry request Httpmsg,rd[");
    ((StringBuilder)localObject).append(String.valueOf(this.this$0.jdField_a_of_type_Long));
    ((StringBuilder)localObject).append("]");
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    localObject = this.this$0;
    FileManagerRSWorker.a((FileManagerRSWorker)localObject, ((FileManagerRSWorker)localObject).jdField_a_of_type_Long, this.this$0.i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FileManagerRSWorker.7
 * JD-Core Version:    0.7.0.1
 */