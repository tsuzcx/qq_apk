package com.tencent.mobileqq.filemanager.fileviewer;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.FileAssistantReportData;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class FileOperaterUtils$3
  implements View.OnClickListener
{
  FileOperaterUtils$3(FileManagerEntity paramFileManagerEntity, Activity paramActivity, IFileBrowser paramIFileBrowser) {}
  
  public void onClick(View paramView)
  {
    try
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
      FileManagerReporter.FileAssistantReportData localFileAssistantReportData = new FileManagerReporter.FileAssistantReportData();
      localFileAssistantReportData.b = "file_forward";
      localFileAssistantReportData.jdField_a_of_type_Int = 71;
      localFileAssistantReportData.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize;
      localFileAssistantReportData.c = FileUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
      localFileAssistantReportData.d = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getCloudType(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType);
      FileManagerReporter.a(localQQAppInterface.getCurrentAccountUin(), localFileAssistantReportData);
      QFileUtils.b(localQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser != null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(2);
      }
      label113:
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (Exception localException)
    {
      break label113;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FileOperaterUtils.3
 * JD-Core Version:    0.7.0.1
 */