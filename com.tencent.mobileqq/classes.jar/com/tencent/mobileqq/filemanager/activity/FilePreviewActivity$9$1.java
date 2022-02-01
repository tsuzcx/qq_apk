package com.tencent.mobileqq.filemanager.activity;

import asyp;
import com.tencent.mobileqq.filemanager.widget.FileWebView;
import com.tencent.qphone.base.util.QLog;

public class FilePreviewActivity$9$1
  implements Runnable
{
  public FilePreviewActivity$9$1(asyp paramasyp) {}
  
  public void run()
  {
    try
    {
      this.a.a.a.loadUrl("javascript:qpreview.onClientResponse('addMorePage',{})");
      return;
    }
    catch (Exception localException)
    {
      QLog.e("<FileAssistant>FilePreviewActivity", 1, localException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.9.1
 * JD-Core Version:    0.7.0.1
 */