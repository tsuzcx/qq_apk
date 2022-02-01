package com.tencent.mobileqq.webview.swift.component;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import noe;

class SwiftBrowserCookieMonster$1
  implements Runnable
{
  SwiftBrowserCookieMonster$1(SwiftBrowserCookieMonster paramSwiftBrowserCookieMonster, AppRuntime paramAppRuntime, Intent paramIntent) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_MqqAppAppRuntime == null)
    {
      ??? = BaseApplicationImpl.getApplication().getRuntime();
      if (this.this$0.b.get() == 2)
      {
        if (??? != null)
        {
          long l = System.currentTimeMillis();
          BrowserAppInterface.a(((AppRuntime)???).getAccount());
          if (QLog.isColorLevel()) {
            QLog.i("SwiftBrowserCookieMonster", 2, "SwiftBrowserCookieMonster: removeLastUinCookies,cost=" + (System.currentTimeMillis() - l));
          }
        }
        this.this$0.c();
        if (QLog.isColorLevel()) {
          QLog.i("SwiftBrowserCookieMonster", 2, "start set all cookies " + noe.b(this.this$0.l, new String[0]));
        }
        this.this$0.a(this.this$0.a(this.jdField_a_of_type_AndroidContentIntent, (AppRuntime)???), true);
        if (!this.this$0.b.compareAndSet(2, 3)) {}
      }
    }
    for (;;)
    {
      synchronized (this.this$0.b)
      {
        this.this$0.b.notifyAll();
        if (this.this$0.a > 0L)
        {
          this.this$0.g();
          QLog.e("SwiftBrowserCookieMonster", 1, "set cookie error :" + this.this$0.a);
          noe.b("Web_qqbrowser_check_and_set_cookies");
          new Handler(Looper.getMainLooper()).post(new SwiftBrowserCookieMonster.1.1(this));
          return;
          ??? = this.jdField_a_of_type_MqqAppAppRuntime;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("SwiftBrowserCookieMonster", 2, "set cookie success: now start post handle callback");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster.1
 * JD-Core Version:    0.7.0.1
 */