package com.tencent.mobileqq.filemanager.core;

import aqxe;
import aqxg;
import com.tencent.qphone.base.util.QLog;

public class FileUploader$3
  implements Runnable
{
  public FileUploader$3(aqxe paramaqxe) {}
  
  public void run()
  {
    if (aqxe.a(this.this$0)) {
      return;
    }
    QLog.i("FtnHttpUploader<FileAssistant>", 1, "Id[" + aqxe.b(this.this$0) + "] resend");
    if (aqxe.a(this.this$0) != null) {
      aqxe.a(this.this$0).i();
    }
    aqxe.a(this.this$0, 0L);
    aqxe.a(this.this$0, 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FileUploader.3
 * JD-Core Version:    0.7.0.1
 */