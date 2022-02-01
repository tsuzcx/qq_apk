package com.tencent.mobileqq.filemanager.core;

import com.tencent.mobileqq.app.QQAppInterface;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

class FileManagerRSWorker$1
  implements Runnable
{
  FileManagerRSWorker$1(FileManagerRSWorker paramFileManagerRSWorker) {}
  
  public void run()
  {
    try
    {
      if (this.this$0.jdField_a_of_type_JavaIoOutputStream == null) {
        this.this$0.jdField_a_of_type_JavaIoOutputStream = new FileOutputStream(this.this$0.d, true);
      }
      if (this.this$0.b == 1) {
        this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(this.this$0.c, 2002);
      }
      this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
      this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 2;
      FileManagerRSWorker.a(this.this$0, this.this$0.jdField_a_of_type_Long, this.this$0.i);
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      localFileNotFoundException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FileManagerRSWorker.1
 * JD-Core Version:    0.7.0.1
 */