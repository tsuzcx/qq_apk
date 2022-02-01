package com.tencent.mobileqq.webview.swift.utils;

import com.tencent.mobileqq.webview.swift.SwiftReuseTouchWebView;
import com.tencent.qphone.base.util.QLog;

class SwiftWebAccelerator$4
  implements Runnable
{
  SwiftWebAccelerator$4(SwiftWebAccelerator paramSwiftWebAccelerator, SwiftReuseTouchWebView paramSwiftReuseTouchWebView) {}
  
  public void run()
  {
    try
    {
      this.a.destroy();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("WebLog_SwiftWebAccelerator", 1, "doMainStep_WarnUpWebView error:" + localException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.utils.SwiftWebAccelerator.4
 * JD-Core Version:    0.7.0.1
 */