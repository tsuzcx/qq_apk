package com.tencent.mobileqq.webviewplugin;

import bgzx;
import cooperation.qzone.mobilereport.MobileReportManager;

public class WebViewJumpPlugin$4
  implements Runnable
{
  public WebViewJumpPlugin$4(bgzx parambgzx, String paramString1, String paramString2) {}
  
  public void run()
  {
    MobileReportManager.getInstance().reportH5DomainClick(this.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webviewplugin.WebViewJumpPlugin.4
 * JD-Core Version:    0.7.0.1
 */