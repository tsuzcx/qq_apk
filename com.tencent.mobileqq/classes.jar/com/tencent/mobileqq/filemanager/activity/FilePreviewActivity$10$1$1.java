package com.tencent.mobileqq.filemanager.activity;

import com.tencent.mobileqq.filemanager.widget.FileWebView;
import com.tencent.qphone.base.util.QLog;

class FilePreviewActivity$10$1$1
  implements Runnable
{
  FilePreviewActivity$10$1$1(FilePreviewActivity.10.1 param1) {}
  
  public void run()
  {
    this.a.a.a.L = System.currentTimeMillis();
    try
    {
      this.a.a.a.d.loadUrl("javascript:qpreview.onClientResponse('addMorePage',{})");
      QLog.i("<FileAssistant>FilePreviewActivity", 1, "javascript:qpreview.onClientResponse('addMorePage',{})");
      return;
    }
    catch (Exception localException)
    {
      QLog.e("<FileAssistant>FilePreviewActivity", 1, localException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.10.1.1
 * JD-Core Version:    0.7.0.1
 */