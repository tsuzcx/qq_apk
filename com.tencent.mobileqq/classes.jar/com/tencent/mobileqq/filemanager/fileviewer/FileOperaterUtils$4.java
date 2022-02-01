package com.tencent.mobileqq.filemanager.fileviewer;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavReport;

final class FileOperaterUtils$4
  implements View.OnClickListener
{
  FileOperaterUtils$4(FileManagerEntity paramFileManagerEntity, IFileBrowser paramIFileBrowser) {}
  
  public void onClick(View paramView)
  {
    for (;;)
    {
      try
      {
        localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
        int i = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        if ((i != 1) && (i != 2) && (i != 4)) {
          continue;
        }
        new QfavBuilder(3).a(localQQAppInterface, BaseActivity.sTopActivity, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, null, false);
        if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser != null) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.c()))
        {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(3);
          FileManagerUtil.a(localQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
        }
      }
      catch (Exception localException)
      {
        QQAppInterface localQQAppInterface;
        continue;
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType == 0) && (FileUtil.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath())))
      {
        QfavBuilder.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath()).a(localQQAppInterface).a(BaseActivity.sTopActivity, localQQAppInterface.getAccount());
        QfavReport.a(localQQAppInterface, 7, 3);
      }
      else if (QLog.isColorLevel())
      {
        QLog.i("FileOperaterUtils", 2, "FileVideoMediaPlayHelperthis is a local file, but favorite fail. [Uuid] = " + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid + " [status] = " + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status + " [fileType] = " + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FileOperaterUtils.4
 * JD-Core Version:    0.7.0.1
 */