package com.tencent.mobileqq.filemanager.core;

import com.tencent.qphone.base.util.QLog;

class FileUploader$3
  implements Runnable
{
  FileUploader$3(FileUploader paramFileUploader) {}
  
  public void run()
  {
    if (FileUploader.a(this.this$0)) {
      return;
    }
    QLog.i("FtnHttpUploader<FileAssistant>", 1, "Id[" + FileUploader.b(this.this$0) + "] resend");
    if (FileUploader.a(this.this$0) != null) {
      FileUploader.a(this.this$0).i();
    }
    FileUploader.a(this.this$0, 0L);
    FileUploader.a(this.this$0, 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FileUploader.3
 * JD-Core Version:    0.7.0.1
 */