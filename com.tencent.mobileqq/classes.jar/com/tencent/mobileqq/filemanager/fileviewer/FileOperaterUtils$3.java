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
  FileOperaterUtils$3(FileManagerEntity paramFileManagerEntity, Activity paramActivity) {}
  
  public void onClick(View paramView)
  {
    try
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
      FileManagerReporter.FileAssistantReportData localFileAssistantReportData = new FileManagerReporter.FileAssistantReportData();
      localFileAssistantReportData.b = "file_forward";
      localFileAssistantReportData.c = 71;
      localFileAssistantReportData.e = this.a.fileSize;
      localFileAssistantReportData.d = FileUtil.a(this.a.fileName);
      localFileAssistantReportData.f = FileManagerUtil.b(this.a.getCloudType(), this.a.peerType);
      FileManagerReporter.a(localQQAppInterface.getCurrentAccountUin(), localFileAssistantReportData);
      QFileUtils.c(localQQAppInterface, this.b, this.a);
      label96:
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (Exception localException)
    {
      break label96;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FileOperaterUtils.3
 * JD-Core Version:    0.7.0.1
 */