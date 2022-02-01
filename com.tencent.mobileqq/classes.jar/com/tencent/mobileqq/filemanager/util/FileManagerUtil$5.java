package com.tencent.mobileqq.filemanager.util;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

final class FileManagerUtil$5
  implements FMDialogUtil.FMDialogInterface
{
  FileManagerUtil$5(FileManagerEntity paramFileManagerEntity, QQAppInterface paramQQAppInterface) {}
  
  public void a()
  {
    FileManagerUtil.c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.FileManagerUtil.5
 * JD-Core Version:    0.7.0.1
 */