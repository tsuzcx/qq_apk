package com.tencent.mobileqq.filemanager.fileviewer;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.FileAssistantReportData;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class FileOperaterUtils$8
  implements View.OnClickListener
{
  FileOperaterUtils$8(IFileBrowser paramIFileBrowser, FileManagerEntity paramFileManagerEntity) {}
  
  public void onClick(View paramView)
  {
    try
    {
      FileManagerReporter.FileAssistantReportData localFileAssistantReportData = new FileManagerReporter.FileAssistantReportData();
      localFileAssistantReportData.b = "file_forward";
      localFileAssistantReportData.a = 9;
      FileManagerReporter.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().getCurrentAccountUin(), localFileAssistantReportData);
      QFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      label61:
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (Exception localException)
    {
      break label61;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FileOperaterUtils.8
 * JD-Core Version:    0.7.0.1
 */