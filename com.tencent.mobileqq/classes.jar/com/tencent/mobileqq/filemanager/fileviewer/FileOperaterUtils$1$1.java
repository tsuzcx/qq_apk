package com.tencent.mobileqq.filemanager.fileviewer;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;

class FileOperaterUtils$1$1
  implements FMDialogUtil.FMDialogInterface
{
  FileOperaterUtils$1$1(FileOperaterUtils.1 param1) {}
  
  public void a()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    localQQAppInterface.getFileManagerEngine().a(this.a.jdField_a_of_type_JavaLangString, null, localQQAppInterface.getAccount(), 0, false);
    FileManagerUtil.a(this.a.jdField_a_of_type_JavaLangString);
    FMToastUtil.d(BaseActivity.sTopActivity.getString(2131692733));
    if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser != null)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(1);
      if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.c())
      {
        long l = this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().b();
        FileManagerUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(), l);
      }
    }
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FileOperaterUtils.1.1
 * JD-Core Version:    0.7.0.1
 */