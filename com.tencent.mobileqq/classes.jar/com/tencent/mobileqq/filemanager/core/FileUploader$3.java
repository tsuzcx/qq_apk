package com.tencent.mobileqq.filemanager.core;

import atvg;
import atvi;
import com.tencent.qphone.base.util.QLog;

public class FileUploader$3
  implements Runnable
{
  public FileUploader$3(atvg paramatvg) {}
  
  public void run()
  {
    if (atvg.a(this.this$0)) {
      return;
    }
    QLog.i("FtnHttpUploader<FileAssistant>", 1, "Id[" + atvg.b(this.this$0) + "] resend");
    if (atvg.a(this.this$0) != null) {
      atvg.a(this.this$0).i();
    }
    atvg.a(this.this$0, 0L);
    atvg.a(this.this$0, 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FileUploader.3
 * JD-Core Version:    0.7.0.1
 */