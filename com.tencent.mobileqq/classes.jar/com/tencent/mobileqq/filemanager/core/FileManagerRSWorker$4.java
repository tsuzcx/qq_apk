package com.tencent.mobileqq.filemanager.core;

import aqwt;
import arrr;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.OutputStream;

public class FileManagerRSWorker$4
  implements Runnable
{
  public FileManagerRSWorker$4(aqwt paramaqwt) {}
  
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
      this.this$0.jdField_a_of_type_Long = arrr.a(this.this$0.d);
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "nSessionId[" + this.this$0.c + "]retry request Httpmsg,rd[" + String.valueOf(this.this$0.jdField_a_of_type_Long) + "]");
      aqwt.a(this.this$0, this.this$0.jdField_a_of_type_Long, this.this$0.h);
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
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FileManagerRSWorker.4
 * JD-Core Version:    0.7.0.1
 */