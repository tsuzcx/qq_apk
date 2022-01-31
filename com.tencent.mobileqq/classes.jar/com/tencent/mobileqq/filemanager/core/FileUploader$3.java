package com.tencent.mobileqq.filemanager.core;

import aozt;
import aozv;
import com.tencent.qphone.base.util.QLog;

public class FileUploader$3
  implements Runnable
{
  public FileUploader$3(aozt paramaozt) {}
  
  public void run()
  {
    if (aozt.a(this.this$0)) {
      return;
    }
    QLog.i("FtnHttpUploader<FileAssistant>", 1, "Id[" + aozt.b(this.this$0) + "] resend");
    if (aozt.a(this.this$0) != null) {
      aozt.a(this.this$0).i();
    }
    aozt.a(this.this$0, 0L);
    aozt.a(this.this$0, 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FileUploader.3
 * JD-Core Version:    0.7.0.1
 */