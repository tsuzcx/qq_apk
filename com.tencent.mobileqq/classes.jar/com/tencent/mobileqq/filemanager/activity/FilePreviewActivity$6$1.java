package com.tencent.mobileqq.filemanager.activity;

import athx;
import aunh;
import auni;
import auog;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.widget.FileWebView;
import com.tencent.qphone.base.util.QLog;

public class FilePreviewActivity$6$1
  implements Runnable
{
  public FilePreviewActivity$6$1(athx paramathx) {}
  
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
      auni localauni = new auni();
      localauni.b = "sf_preview_again";
      localauni.c = auog.a(this.a.a.b);
      localauni.jdField_a_of_type_Long = this.a.a.jdField_a_of_type_Long;
      aunh.a(this.a.a.app.getCurrentAccountUin(), localauni);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.6.1
 * JD-Core Version:    0.7.0.1
 */