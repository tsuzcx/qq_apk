package com.tencent.mobileqq.filemanager.app;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.OnlineFileSessionCenter;
import com.tencent.qphone.base.util.QLog;

class FileTransferHandler$6
  implements Runnable
{
  FileTransferHandler$6(FileTransferHandler paramFileTransferHandler, long paramLong, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OLfilesession[");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append("]  handle recv onlinefile resp. sucess =");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    QLog.i("FileTransferHandler<FileAssistant>", 1, localStringBuilder.toString());
    this.this$0.a.getOnlineFileSessionCenter().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long, this.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.FileTransferHandler.6
 * JD-Core Version:    0.7.0.1
 */