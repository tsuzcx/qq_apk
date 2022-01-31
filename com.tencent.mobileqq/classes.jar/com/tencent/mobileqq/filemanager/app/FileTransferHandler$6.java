package com.tencent.mobileqq.filemanager.app;

import aowc;
import apbc;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class FileTransferHandler$6
  implements Runnable
{
  public FileTransferHandler$6(aowc paramaowc, long paramLong, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    QLog.i("FileTransferHandler<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "]  handle recv onlinefile resp. sucess =" + this.jdField_a_of_type_Boolean);
    this.this$0.a.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long, this.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.FileTransferHandler.6
 * JD-Core Version:    0.7.0.1
 */