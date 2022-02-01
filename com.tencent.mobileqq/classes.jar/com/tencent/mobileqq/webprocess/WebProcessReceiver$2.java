package com.tencent.mobileqq.webprocess;

import com.tencent.mobileqq.webview.util.ITbsDownloader;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.smtt.sdk.TbsDownloader;
import mqq.app.AppRuntime;

class WebProcessReceiver$2
  implements Runnable
{
  WebProcessReceiver$2(WebProcessReceiver paramWebProcessReceiver, boolean paramBoolean1, AppRuntime paramAppRuntime, boolean paramBoolean2) {}
  
  public void run()
  {
    if (TbsDownloader.needDownload(BaseApplication.getContext(), this.a))
    {
      AppRuntime localAppRuntime = this.b;
      if ((localAppRuntime instanceof ITbsDownloader)) {
        ((ITbsDownloader)localAppRuntime).a(false, this.a, this.c ^ true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webprocess.WebProcessReceiver.2
 * JD-Core Version:    0.7.0.1
 */