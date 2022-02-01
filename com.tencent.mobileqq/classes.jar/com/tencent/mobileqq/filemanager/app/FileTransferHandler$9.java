package com.tencent.mobileqq.filemanager.app;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.OnlineFileSessionCenter;
import com.tencent.qphone.base.util.QLog;

class FileTransferHandler$9
  implements Runnable
{
  FileTransferHandler$9(FileTransferHandler paramFileTransferHandler, long paramLong, int paramInt, String paramString1, String paramString2) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OLfilesession[");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append("] Handle upload failed notify. retCode =");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append("(1:cancel upload) reason=");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    QLog.i("FileTransferHandler<FileAssistant>", 1, localStringBuilder.toString());
    int i = this.jdField_a_of_type_Int;
    if (1 == i)
    {
      this.this$0.a.getOnlineFileSessionCenter().a(this.b, this.jdField_a_of_type_Long);
      return;
    }
    if (2 == i)
    {
      this.this$0.a.getOnlineFileSessionCenter().a(this.b, this.jdField_a_of_type_Long);
      return;
    }
    if (3 == i)
    {
      this.this$0.a.getOnlineFileSessionCenter().c(this.b, this.jdField_a_of_type_Long);
      return;
    }
    this.this$0.a.getOnlineFileSessionCenter().a(this.b, this.jdField_a_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.FileTransferHandler.9
 * JD-Core Version:    0.7.0.1
 */