package com.tencent.mobileqq.filemanager.core;

import aoza;
import aozi;
import aozj;
import com.tencent.mobileqq.app.QQAppInterface;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class FileManagerRSWorker$1$4
  implements Runnable
{
  public FileManagerRSWorker$1$4(aozj paramaozj, String paramString) {}
  
  public void run()
  {
    try
    {
      if (this.jdField_a_of_type_Aozj.a.jdField_a_of_type_JavaIoOutputStream == null) {
        this.jdField_a_of_type_Aozj.a.jdField_a_of_type_JavaIoOutputStream = new FileOutputStream(this.jdField_a_of_type_Aozj.a.d, true);
      }
      this.jdField_a_of_type_Aozj.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Aozj.a.c, 2002);
      this.jdField_a_of_type_Aozj.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
      this.jdField_a_of_type_Aozj.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_Aozj.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      this.jdField_a_of_type_Aozj.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 2;
      this.jdField_a_of_type_Aozj.a.h = this.jdField_a_of_type_JavaLangString;
      aozi.a(this.jdField_a_of_type_Aozj.a, this.jdField_a_of_type_Aozj.a.jdField_a_of_type_Long, this.jdField_a_of_type_Aozj.a.h);
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      localFileNotFoundException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FileManagerRSWorker.1.4
 * JD-Core Version:    0.7.0.1
 */