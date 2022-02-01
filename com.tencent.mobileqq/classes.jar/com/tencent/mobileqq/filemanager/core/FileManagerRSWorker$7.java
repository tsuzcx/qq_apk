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
        this.this$0.a(this.this$0.f, 0L);
        return;
      }
      this.this$0.b();
      return;
    }
    if (this.this$0.f.equalsIgnoreCase(""))
    {
      this.this$0.f();
      return;
    }
    try
    {
      if (this.this$0.jdField_a_of_type_JavaIoOutputStream != null) {
        this.this$0.jdField_a_of_type_JavaIoOutputStream.flush();
      }
      this.this$0.jdField_a_of_type_Long = FileManagerUtil.a(this.this$0.d);
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "nSessionId[" + this.this$0.c + "]retry request Httpmsg,rd[" + String.valueOf(this.this$0.jdField_a_of_type_Long) + "]");
      FileManagerRSWorker.a(this.this$0, this.this$0.jdField_a_of_type_Long, this.this$0.i);
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        QLog.e("FileManagerRSWorker<FileAssistant>", 1, localIOException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FileManagerRSWorker.7
 * JD-Core Version:    0.7.0.1
 */