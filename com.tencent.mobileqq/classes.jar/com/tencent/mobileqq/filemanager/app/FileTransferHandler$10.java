package com.tencent.mobileqq.filemanager.app;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.OnlineFileSessionCenter;
import com.tencent.qphone.base.util.QLog;

class FileTransferHandler$10
  implements Runnable
{
  FileTransferHandler$10(FileTransferHandler paramFileTransferHandler, long paramLong, int paramInt1, int paramInt2, String paramString) {}
  
  public void run()
  {
    QLog.i("FileTransferHandler<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "] Handle upload progress notify. speed=" + this.jdField_a_of_type_Int + " progress =" + this.b);
    this.this$0.a.getOnlineFileSessionCenter().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.FileTransferHandler.10
 * JD-Core Version:    0.7.0.1
 */