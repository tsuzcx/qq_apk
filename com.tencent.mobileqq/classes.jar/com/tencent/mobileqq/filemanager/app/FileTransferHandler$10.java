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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OLfilesession[");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append("] Handle upload progress notify. speed=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(" progress =");
    localStringBuilder.append(this.b);
    QLog.i("FileTransferHandler<FileAssistant>", 1, localStringBuilder.toString());
    this.this$0.a.getOnlineFileSessionCenter().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.FileTransferHandler.10
 * JD-Core Version:    0.7.0.1
 */