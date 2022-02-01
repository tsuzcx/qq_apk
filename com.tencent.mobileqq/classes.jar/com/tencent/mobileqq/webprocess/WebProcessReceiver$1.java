package com.tencent.mobileqq.webprocess;

import com.tencent.mobileqq.webview.util.ITbsDownloader;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.smtt.sdk.TbsDownloader;
import mqq.app.AppRuntime;

class WebProcessReceiver$1
  implements Runnable
{
  WebProcessReceiver$1(WebProcessReceiver paramWebProcessReceiver, boolean paramBoolean1, AppRuntime paramAppRuntime, boolean paramBoolean2) {}
  
  public void run()
  {
    if (TbsDownloader.needDownload(BaseApplication.getContext(), this.jdField_a_of_type_Boolean))
    {
      AppRuntime localAppRuntime = this.jdField_a_of_type_MqqAppAppRuntime;
      if ((localAppRuntime instanceof ITbsDownloader)) {
        ((ITbsDownloader)localAppRuntime).a(false, this.jdField_a_of_type_Boolean, this.b ^ true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webprocess.WebProcessReceiver.1
 * JD-Core Version:    0.7.0.1
 */