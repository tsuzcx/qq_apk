package com.tencent.mobileqq.webview.swift.utils;

import android.os.Bundle;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster;

class SwiftWebAccelerator$5$1
  implements Runnable
{
  SwiftWebAccelerator$5$1(SwiftWebAccelerator.5 param5, int paramInt) {}
  
  public void run()
  {
    if (this.a == 202)
    {
      localObject = new String[2];
      int i = 0;
      localObject[0] = "https://qc.vip.qq.com/";
      localObject[1] = "https://m.gamecenter.qq.com";
      int j = localObject.length;
      while (i < j)
      {
        String str = localObject[i];
        SwiftBrowserCookieMonster localSwiftBrowserCookieMonster = SwiftBrowserCookieMonster.c(str);
        if (localSwiftBrowserCookieMonster != null) {
          localSwiftBrowserCookieMonster.a(str, null, null, null);
        }
        i += 1;
      }
    }
    Object localObject = SwiftBrowserCookieMonster.c("https://zb.vip.qq.com/");
    if (localObject != null) {
      ((SwiftBrowserCookieMonster)localObject).a("https://zb.vip.qq.com/", null, null, null);
    }
    this.b.b.putBoolean("_should_set_cookie_", true);
    this.b.this$0.a(this.b.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.utils.SwiftWebAccelerator.5.1
 * JD-Core Version:    0.7.0.1
 */