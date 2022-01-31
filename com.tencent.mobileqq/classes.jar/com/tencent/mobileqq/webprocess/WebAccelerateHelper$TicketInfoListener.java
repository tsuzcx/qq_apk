package com.tencent.mobileqq.webprocess;

import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;
import mqq.app.TicketManagerListener;

class WebAccelerateHelper$TicketInfoListener
  implements TicketManagerListener
{
  private WebAccelerateHelper$TicketInfoListener(WebAccelerateHelper paramWebAccelerateHelper) {}
  
  public void onTicketRefreshed()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebAccelerateHelper", 2, "TicketManager invoke onTicketRefreshed");
    }
    SwiftBrowserCookieMonster.d();
    SwiftBrowserCookieMonster.a(MobileQQ.sMobileQQ.waitAppRuntime(null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webprocess.WebAccelerateHelper.TicketInfoListener
 * JD-Core Version:    0.7.0.1
 */