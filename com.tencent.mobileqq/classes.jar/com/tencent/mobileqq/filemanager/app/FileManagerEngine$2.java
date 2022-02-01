package com.tencent.mobileqq.filemanager.app;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileCategoryUtil.GetApkPackageInfoCallback;

class FileManagerEngine$2
  implements FileCategoryUtil.GetApkPackageInfoCallback
{
  FileManagerEngine$2(FileManagerEngine paramFileManagerEngine, FileManagerEntity paramFileManagerEntity, Runnable paramRunnable) {}
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = paramString1;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strApkPackageName = paramString2;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileManagerEngine.a.getFileManagerEngine().a().a(paramString2, new FileManagerEngine.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.FileManagerEngine.2
 * JD-Core Version:    0.7.0.1
 */