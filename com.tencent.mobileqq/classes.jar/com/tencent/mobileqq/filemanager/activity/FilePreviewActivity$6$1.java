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
    if ((this.a.a.p != null) && (this.a.a.p.length() != 0))
    {
      boolean bool = this.a.a.l;
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
      ((FileManagerReporter.FileAssistantReportData)localObject).d = FileUtil.a(this.a.a.f);
      ((FileManagerReporter.FileAssistantReportData)localObject).e = this.a.a.s;
      FileManagerReporter.a(this.a.a.app.getCurrentAccountUin(), (FileManagerReporter.FileAssistantReportData)localObject);
      try
      {
        this.a.a.d.loadUrl(str);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
    }
    this.a.a.H = false;
    FilePreviewActivity.c(this.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.6.1
 * JD-Core Version:    0.7.0.1
 */