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
    if ((this.a.a.g != null) && (this.a.a.g.length() != 0))
    {
      boolean bool = this.a.a.jdField_a_of_type_Boolean;
      String str = "javascript:qpreview.onClientResponse('showFileList', {})";
      if (bool)
      {
        QLog.i("<FileAssistant>FilePreviewActivity", 1, "javascript:qpreview.onClientResponse('showFileList', {})");
      }
      else
      {
        QLog.i("<FileAssistant>FilePreviewActivity", 1, "javascript:qpreview.onClientResponse('addMorePage',{})");
        str = "javascript:qpreview.onClientResponse('addMorePage',{})";
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("mWebView.loadUrl(");
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(")");
      QLog.i("<FileAssistant>FilePreviewActivity", 1, ((StringBuilder)localObject).toString());
      localObject = new FileManagerReporter.FileAssistantReportData();
      ((FileManagerReporter.FileAssistantReportData)localObject).b = "sf_preview_again";
      ((FileManagerReporter.FileAssistantReportData)localObject).c = FileUtil.a(this.a.a.b);
      ((FileManagerReporter.FileAssistantReportData)localObject).jdField_a_of_type_Long = this.a.a.jdField_a_of_type_Long;
      FileManagerReporter.a(this.a.a.app.getCurrentAccountUin(), (FileManagerReporter.FileAssistantReportData)localObject);
      try
      {
        this.a.a.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.loadUrl(str);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
    }
    this.a.a.d = false;
    FilePreviewActivity.a(this.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.6.1
 * JD-Core Version:    0.7.0.1
 */