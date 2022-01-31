package com.tencent.mobileqq.webprocess;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.smtt.sdk.TbsDownloader;
import mqq.app.AppRuntime;

class WebProcessReceiver$2
  implements Runnable
{
  WebProcessReceiver$2(WebProcessReceiver paramWebProcessReceiver, boolean paramBoolean1, AppRuntime paramAppRuntime, boolean paramBoolean2) {}
  
  public void run()
  {
    BrowserAppInterface localBrowserAppInterface;
    boolean bool2;
    if ((TbsDownloader.needDownload(BaseApplicationImpl.getApplication(), this.jdField_a_of_type_Boolean)) && ((this.jdField_a_of_type_MqqAppAppRuntime instanceof BrowserAppInterface)))
    {
      localBrowserAppInterface = (BrowserAppInterface)this.jdField_a_of_type_MqqAppAppRuntime;
      bool2 = this.jdField_a_of_type_Boolean;
      if (this.b) {
        break label53;
      }
    }
    label53:
    for (boolean bool1 = true;; bool1 = false)
    {
      localBrowserAppInterface.a(false, bool2, bool1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.webprocess.WebProcessReceiver.2
 * JD-Core Version:    0.7.0.1
 */