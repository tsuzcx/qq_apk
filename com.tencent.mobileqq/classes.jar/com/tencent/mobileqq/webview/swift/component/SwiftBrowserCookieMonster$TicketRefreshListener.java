package com.tencent.mobileqq.webview.swift.component;

import android.content.Intent;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;
import mqq.app.TicketManagerListener;

class SwiftBrowserCookieMonster$TicketRefreshListener
  implements TicketManagerListener
{
  public void onTicketRefreshed()
  {
    QLog.i("SwiftBrowserCookieMonster", 1, "TicketManager invoke onTicketRefreshed");
    SwiftBrowserCookieMonster.d();
    SwiftBrowserCookieMonster.b(MobileQQ.sMobileQQ.waitAppRuntime(null), new Intent());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster.TicketRefreshListener
 * JD-Core Version:    0.7.0.1
 */