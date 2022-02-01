package com.tencent.mobileqq.filemanager.core;

import atup;
import atuv;
import com.tencent.mobileqq.app.QQAppInterface;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class FileManagerRSWorker$2
  implements Runnable
{
  public FileManagerRSWorker$2(atuv paramatuv) {}
  
  public void run()
  {
    try
    {
      if (this.this$0.jdField_a_of_type_JavaIoOutputStream == null) {
        this.this$0.jdField_a_of_type_JavaIoOutputStream = new FileOutputStream(this.this$0.d, true);
      }
      if (this.this$0.b == 1) {
        this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.this$0.c, 2002);
      }
      this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
      this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 2;
      atuv.a(this.this$0, this.this$0.jdField_a_of_type_Long, this.this$0.i);
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      localFileNotFoundException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FileManagerRSWorker.2
 * JD-Core Version:    0.7.0.1
 */