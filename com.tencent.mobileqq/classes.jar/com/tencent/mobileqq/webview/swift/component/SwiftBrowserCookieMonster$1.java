package com.tencent.mobileqq.webview.swift.component;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import com.tencent.biz.common.util.Util;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webprocess.temp.api.IWebviewApi;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

class SwiftBrowserCookieMonster$1
  implements Runnable
{
  SwiftBrowserCookieMonster$1(SwiftBrowserCookieMonster paramSwiftBrowserCookieMonster, AppRuntime paramAppRuntime, Intent paramIntent) {}
  
  public void run()
  {
    Object localObject2 = this.jdField_a_of_type_MqqAppAppRuntime;
    ??? = localObject2;
    if (localObject2 == null) {
      ??? = MobileQQ.sMobileQQ.waitAppRuntime(null);
    }
    if (this.this$0.b.get() == 2)
    {
      if (??? != null)
      {
        long l = System.currentTimeMillis();
        ((IWebviewApi)QRoute.api(IWebviewApi.class)).removeLastUinCookies(((AppRuntime)???).getAccount());
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("SwiftBrowserCookieMonster: removeLastUinCookies,cost=");
          ((StringBuilder)localObject2).append(System.currentTimeMillis() - l);
          QLog.i("SwiftBrowserCookieMonster", 2, ((StringBuilder)localObject2).toString());
        }
      }
      this.this$0.c();
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("start set all cookies ");
        ((StringBuilder)localObject2).append(Util.b(this.this$0.l, new String[0]));
        QLog.i("SwiftBrowserCookieMonster", 2, ((StringBuilder)localObject2).toString());
      }
      localObject2 = this.this$0;
      ((SwiftBrowserCookieMonster)localObject2).a(((SwiftBrowserCookieMonster)localObject2).a(this.jdField_a_of_type_AndroidContentIntent, (AppRuntime)???), true);
      if (this.this$0.b.compareAndSet(2, 3)) {
        synchronized (this.this$0.b)
        {
          this.this$0.b.notifyAll();
          if (this.this$0.a > 0L)
          {
            this.this$0.g();
            ??? = new StringBuilder();
            ((StringBuilder)???).append("set cookie error :");
            ((StringBuilder)???).append(this.this$0.a);
            QLog.e("SwiftBrowserCookieMonster", 1, ((StringBuilder)???).toString());
          }
          else if (QLog.isColorLevel())
          {
            QLog.i("SwiftBrowserCookieMonster", 2, "set cookie success: now start post handle callback");
          }
        }
      }
      Util.b("Web_qqbrowser_check_and_set_cookies");
      new Handler(Looper.getMainLooper()).post(new SwiftBrowserCookieMonster.1.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster.1
 * JD-Core Version:    0.7.0.1
 */