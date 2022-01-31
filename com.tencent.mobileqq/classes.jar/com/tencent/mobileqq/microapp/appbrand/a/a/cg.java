package com.tencent.mobileqq.microapp.appbrand.a.a;

import com.tencent.mobileqq.microapp.webview.BaseAppBrandWebview;
import com.tencent.mobileqq.microapp.widget.f;

final class cg
  implements Runnable
{
  cg(bj parambj, BaseAppBrandWebview paramBaseAppBrandWebview, String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, boolean paramBoolean) {}
  
  public void run()
  {
    f localf = new f(this.k.a.b());
    localf.setOnDismissListener(new ch(this, localf));
    localf.a(this.d, this.e, this.f, this.g, this.h, this.i, this.j, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.appbrand.a.a.cg
 * JD-Core Version:    0.7.0.1
 */