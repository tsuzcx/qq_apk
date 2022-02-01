package com.tencent.mobileqq.webview.swift.component;

import com.tencent.biz.common.util.Util;
import com.tencent.mobileqq.webview.cookie.SetCookiesCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

class SwiftBrowserCookieMonster$1$1
  implements Runnable
{
  SwiftBrowserCookieMonster$1$1(SwiftBrowserCookieMonster.1 param1) {}
  
  public void run()
  {
    Iterator localIterator = this.a.this$0.q.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject3 = (String)localIterator.next();
      Object localObject2 = (CopyOnWriteArrayList)this.a.this$0.q.get(localObject3);
      if (this.a.a == null) {
        localObject1 = MobileQQ.sMobileQQ.waitAppRuntime(null);
      } else {
        localObject1 = this.a.a;
      }
      Object localObject1 = this.a.this$0.a((String)localObject3, (AppRuntime)localObject1);
      localObject2 = ((CopyOnWriteArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (SetCookiesCallback)((Iterator)localObject2).next();
        StringBuilder localStringBuilder;
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("post callback onSetCookiesFinished ");
          localStringBuilder.append(Util.b((String)localObject1, new String[0]));
          localStringBuilder.append(", errorCode: ");
          localStringBuilder.append(this.a.this$0.t);
          QLog.i("SwiftBrowserCookieMonster", 2, localStringBuilder.toString());
        }
        if (this.a.this$0.r)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("cookie is wrong, need do jump ptlogin! ");
          localStringBuilder.append(Util.b((String)localObject1, new String[0]));
          QLog.i("SwiftBrowserCookieMonster", 1, localStringBuilder.toString());
        }
        ((SetCookiesCallback)localObject3).a((String)localObject1, null, this.a.this$0.t);
      }
    }
    if ((!this.a.this$0.r) && (this.a.this$0.t <= 0L))
    {
      this.a.this$0.q.clear();
      return;
    }
    this.a.this$0.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster.1.1
 * JD-Core Version:    0.7.0.1
 */