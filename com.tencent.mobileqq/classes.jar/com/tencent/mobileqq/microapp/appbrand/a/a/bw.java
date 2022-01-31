package com.tencent.mobileqq.microapp.appbrand.a.a;

import com.tencent.mobileqq.microapp.appbrand.a;
import com.tencent.mobileqq.microapp.appbrand.page.AbsAppBrandPage;
import com.tencent.mobileqq.microapp.appbrand.page.AppBrandPageContainer;
import com.tencent.mobileqq.microapp.webview.BaseAppBrandWebview;
import com.tencent.qphone.base.util.QLog;

final class bw
  implements Runnable
{
  bw(bj parambj, String paramString1, BaseAppBrandWebview paramBaseAppBrandWebview, int paramInt, String paramString2, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.f.c != null) {
      this.f.c.hideToastView();
    }
    this.f.c = this.f.a.a.g.getCurrentPage();
    if (this.f.c == null)
    {
      QLog.w("UIJsPlugin", 2, "handleNativeRequest event=" + this.a + "， top page not found");
      this.f.a.b(this.b, this.a, null, this.c);
      return;
    }
    this.f.c.showToastView("loading", null, this.d, -1, this.e);
    this.f.a.a(this.b, this.a, null, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.appbrand.a.a.bw
 * JD-Core Version:    0.7.0.1
 */