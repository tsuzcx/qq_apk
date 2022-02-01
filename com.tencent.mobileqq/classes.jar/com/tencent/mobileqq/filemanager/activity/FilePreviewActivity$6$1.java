package com.tencent.mobileqq.filemanager.activity;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.FileAssistantReportData;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.widget.FileWebView;
import com.tencent.qphone.base.util.QLog;

class FilePreviewActivity$6$1
  implements Runnable
{
  FilePreviewActivity$6$1(FilePreviewActivity.6 param6) {}
  
  public void run()
  {
    if ((this.a.a.g == null) || (this.a.a.g.length() == 0))
    {
      this.a.a.d = false;
      FilePreviewActivity.a(this.a.a);
      return;
    }
    String str1;
    if (this.a.a.jdField_a_of_type_Boolean)
    {
      str1 = "javascript:qpreview.onClientResponse('showFileList', {})";
      QLog.i("<FileAssistant>FilePreviewActivity", 1, "javascript:qpreview.onClientResponse('showFileList', {})");
    }
    for (;;)
    {
      QLog.i("<FileAssistant>FilePreviewActivity", 1, "mWebView.loadUrl(" + str1 + ")");
      FileManagerReporter.FileAssistantReportData localFileAssistantReportData = new FileManagerReporter.FileAssistantReportData();
      localFileAssistantReportData.b = "sf_preview_again";
      localFileAssistantReportData.c = FileUtil.a(this.a.a.b);
      localFileAssistantReportData.jdField_a_of_type_Long = this.a.a.jdField_a_of_type_Long;
      FileManagerReporter.a(this.a.a.app.getCurrentAccountUin(), localFileAssistantReportData);
      try
      {
        this.a.a.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.loadUrl(str1);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      String str2 = "javascript:qpreview.onClientResponse('addMorePage',{})";
      QLog.i("<FileAssistant>FilePreviewActivity", 1, "javascript:qpreview.onClientResponse('addMorePage',{})");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.6.1
 * JD-Core Version:    0.7.0.1
 */