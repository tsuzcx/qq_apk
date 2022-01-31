package com.tencent.mobileqq.filemanager.core;

import aoza;
import aozi;
import aozj;
import com.tencent.mobileqq.app.QQAppInterface;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class FileManagerRSWorker$1$2
  implements Runnable
{
  public FileManagerRSWorker$1$2(aozj paramaozj) {}
  
  public void run()
  {
    try
    {
      if (this.a.a.jdField_a_of_type_JavaIoOutputStream == null) {
        this.a.a.jdField_a_of_type_JavaIoOutputStream = new FileOutputStream(this.a.a.d, true);
      }
      if (this.a.a.b == 1) {
        this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.a.c, 2002);
      }
      this.a.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
      this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.a.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      this.a.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 2;
      aozi.a(this.a.a, this.a.a.jdField_a_of_type_Long, this.a.a.h);
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      localFileNotFoundException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FileManagerRSWorker.1.2
 * JD-Core Version:    0.7.0.1
 */