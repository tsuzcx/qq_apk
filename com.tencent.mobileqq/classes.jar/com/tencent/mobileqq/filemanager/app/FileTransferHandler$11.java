package com.tencent.mobileqq.filemanager.app;

import aqtj;
import aqyj;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class FileTransferHandler$11
  implements Runnable
{
  public FileTransferHandler$11(aqtj paramaqtj, long paramLong1, String paramString1, int paramInt, String paramString2, long paramLong2) {}
  
  public void run()
  {
    QLog.i("FileTransferHandler<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "] upload competed:");
    this.this$0.a.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.jdField_b_of_type_JavaLangString, this.jdField_b_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.FileTransferHandler.11
 * JD-Core Version:    0.7.0.1
 */