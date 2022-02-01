package com.tencent.mobileqq.webviewplugin;

import cooperation.qzone.mobilereport.MobileReportManager;

class WebViewJumpPlugin$4
  implements Runnable
{
  WebViewJumpPlugin$4(WebViewJumpPlugin paramWebViewJumpPlugin, String paramString1, String paramString2) {}
  
  public void run()
  {
    MobileReportManager.getInstance().reportH5DomainClick(this.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.webviewplugin.WebViewJumpPlugin.4
 * JD-Core Version:    0.7.0.1
 */