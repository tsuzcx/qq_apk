package com.tencent.mobileqq.webview.swift.component;

import android.text.TextUtils;
import com.tencent.biz.common.util.Util;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;
import oicq.wlogin_sdk.request.Ticket;

final class SwiftBrowserCookieMonster$3
  implements Runnable
{
  SwiftBrowserCookieMonster$3(AppRuntime paramAppRuntime) {}
  
  public void run()
  {
    if (SwiftBrowserCookieMonster.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 2)
    {
      ??? = this.a;
      if ((??? != null) && (((AppRuntime)???).isLogin()))
      {
        if (QLog.isColorLevel())
        {
          ??? = new StringBuilder();
          ((StringBuilder)???).append("get common keys: ");
          ((StringBuilder)???).append(this.a.getAccount());
          QLog.i("SwiftBrowserCookieMonster", 2, ((StringBuilder)???).toString());
        }
        ??? = (TicketManager)this.a.getManager(2);
        String str = this.a.getAccount();
        Object localObject3;
        StringBuilder localStringBuilder;
        if (TextUtils.isEmpty(SwiftBrowserCookieMonster.jdField_a_of_type_JavaLangString))
        {
          SwiftBrowserCookieMonster.jdField_a_of_type_JavaLangString = ((TicketManager)???).getSkey(str);
          if (!TextUtils.isEmpty(SwiftBrowserCookieMonster.jdField_a_of_type_JavaLangString))
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("skey=");
            ((StringBuilder)localObject3).append(SwiftBrowserCookieMonster.jdField_a_of_type_JavaLangString);
            QLog.i("SwiftBrowserCookieMonster", 1, Util.c(((StringBuilder)localObject3).toString(), new String[0]));
          }
          else
          {
            QLog.e("SwiftBrowserCookieMonster", 1, "skey is null!");
          }
          localObject3 = ((TicketManager)???).getLocalTicket(str, 4096);
          if (localObject3 != null)
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("last refresh skey time: ");
            localStringBuilder.append(((Ticket)localObject3)._create_time);
            QLog.i("SwiftBrowserCookieMonster", 1, localStringBuilder.toString());
          }
        }
        if (TextUtils.isEmpty(SwiftBrowserCookieMonster.b)) {
          SwiftBrowserCookieMonster.b = ((TicketManager)???).getSuperkey(str);
        }
        if (TextUtils.isEmpty(SwiftBrowserCookieMonster.d))
        {
          SwiftBrowserCookieMonster.d = ((TicketManager)???).getStweb(str);
          if (!TextUtils.isEmpty(SwiftBrowserCookieMonster.d))
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("sTwxWeb=");
            ((StringBuilder)localObject3).append(SwiftBrowserCookieMonster.d);
            QLog.i("SwiftBrowserCookieMonster", 1, Util.c(((StringBuilder)localObject3).toString(), new String[0]));
          }
          else
          {
            QLog.e("SwiftBrowserCookieMonster", 1, "sTwxWeb is null!");
          }
          localObject3 = ((TicketManager)???).getLocalTicket(str, 32);
          if (localObject3 != null)
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("last refresh sTwxWeb time: ");
            localStringBuilder.append(((Ticket)localObject3)._create_time);
            QLog.i("SwiftBrowserCookieMonster", 1, localStringBuilder.toString());
          }
        }
        if (TextUtils.isEmpty(SwiftBrowserCookieMonster.e)) {
          SwiftBrowserCookieMonster.e = ((TicketManager)???).getA2(str);
        }
        synchronized (SwiftBrowserCookieMonster.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger)
        {
          if (SwiftBrowserCookieMonster.b()) {
            SwiftBrowserCookieMonster.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.compareAndSet(2, 3);
          } else {
            SwiftBrowserCookieMonster.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.compareAndSet(2, 1);
          }
          SwiftBrowserCookieMonster.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.notifyAll();
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster.3
 * JD-Core Version:    0.7.0.1
 */