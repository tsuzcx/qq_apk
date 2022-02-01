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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doMainStep_WarnUpWebView error:");
      localStringBuilder.append(localException.toString());
      QLog.e("WebLog_SwiftWebAccelerator", 1, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.utils.SwiftWebAccelerator.4
 * JD-Core Version:    0.7.0.1
 */