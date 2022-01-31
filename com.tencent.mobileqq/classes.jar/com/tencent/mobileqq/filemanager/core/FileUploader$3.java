package com.tencent.mobileqq.filemanager.core;

import aqsv;
import aqsx;
import com.tencent.qphone.base.util.QLog;

public class FileUploader$3
  implements Runnable
{
  public FileUploader$3(aqsv paramaqsv) {}
  
  public void run()
  {
    if (aqsv.a(this.this$0)) {
      return;
    }
    QLog.i("FtnHttpUploader<FileAssistant>", 1, "Id[" + aqsv.b(this.this$0) + "] resend");
    if (aqsv.a(this.this$0) != null) {
      aqsv.a(this.this$0).i();
    }
    aqsv.a(this.this$0, 0L);
    aqsv.a(this.this$0, 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FileUploader.3
 * JD-Core Version:    0.7.0.1
 */