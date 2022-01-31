package com.tencent.mobileqq.webview.swift.component;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;
import nau;
import oicq.wlogin_sdk.request.Ticket;

final class SwiftBrowserCookieMonster$3
  implements Runnable
{
  SwiftBrowserCookieMonster$3(AppRuntime paramAppRuntime) {}
  
  public void run()
  {
    String str;
    if ((SwiftBrowserCookieMonster.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 2) && (this.a != null) && (this.a.isLogin()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("SwiftBrowserCookieMonster", 2, "get common keys: " + this.a.getAccount());
      }
      ??? = (TicketManager)this.a.getManager(2);
      str = this.a.getAccount();
      if (TextUtils.isEmpty(SwiftBrowserCookieMonster.jdField_a_of_type_JavaLangString))
      {
        SwiftBrowserCookieMonster.jdField_a_of_type_JavaLangString = ((TicketManager)???).getSkey(str);
        if (TextUtils.isEmpty(SwiftBrowserCookieMonster.jdField_a_of_type_JavaLangString)) {
          break label361;
        }
        QLog.i("SwiftBrowserCookieMonster", 1, nau.c("skey=" + SwiftBrowserCookieMonster.jdField_a_of_type_JavaLangString, new String[0]));
      }
    }
    for (;;)
    {
      Ticket localTicket = ((TicketManager)???).GetLocalTicket(str, 4096);
      if (localTicket != null) {
        QLog.i("SwiftBrowserCookieMonster", 1, "last refresh skey time: " + localTicket._create_time);
      }
      if (TextUtils.isEmpty(SwiftBrowserCookieMonster.b)) {
        SwiftBrowserCookieMonster.b = ((TicketManager)???).getSuperkey(str);
      }
      if (TextUtils.isEmpty(SwiftBrowserCookieMonster.d))
      {
        SwiftBrowserCookieMonster.d = ((TicketManager)???).getStweb(str);
        if (TextUtils.isEmpty(SwiftBrowserCookieMonster.d)) {
          break label372;
        }
        QLog.i("SwiftBrowserCookieMonster", 1, nau.c("sTwxWeb=" + SwiftBrowserCookieMonster.d, new String[0]));
        label270:
        localTicket = ((TicketManager)???).GetLocalTicket(str, 32);
        if (localTicket != null) {
          QLog.i("SwiftBrowserCookieMonster", 1, "last refresh sTwxWeb time: " + localTicket._create_time);
        }
      }
      if (TextUtils.isEmpty(SwiftBrowserCookieMonster.e)) {
        SwiftBrowserCookieMonster.e = ((TicketManager)???).getA2(str);
      }
      synchronized (SwiftBrowserCookieMonster.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger)
      {
        if (SwiftBrowserCookieMonster.b())
        {
          SwiftBrowserCookieMonster.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.compareAndSet(2, 3);
          SwiftBrowserCookieMonster.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.notifyAll();
          return;
          label361:
          QLog.e("SwiftBrowserCookieMonster", 1, "skey is null!");
          continue;
          label372:
          QLog.e("SwiftBrowserCookieMonster", 1, "sTwxWeb is null!");
          break label270;
        }
        SwiftBrowserCookieMonster.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.compareAndSet(2, 1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster.3
 * JD-Core Version:    0.7.0.1
 */