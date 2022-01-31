package com.tencent.mobileqq.microapp.appbrand.a.a;

import com.tencent.mobileqq.microapp.appbrand.a;
import com.tencent.mobileqq.microapp.appbrand.page.AppBrandPageContainer;
import com.tencent.mobileqq.microapp.appbrand.page.WebviewContainer;
import com.tencent.mobileqq.microapp.appbrand.utils.b;
import com.tencent.mobileqq.microapp.webview.BaseAppBrandWebview;
import java.io.File;

final class s
  implements Runnable
{
  s(f paramf, String paramString1, BaseAppBrandWebview paramBaseAppBrandWebview, String paramString2, int paramInt) {}
  
  public void run()
  {
    WebviewContainer localWebviewContainer = this.e.a.a.g.getCurrentWebviewContainer();
    if (localWebviewContainer != null)
    {
      localWebviewContainer.insertFileView(new File(b.a().d(this.a)));
      this.e.a.a(this.b, this.c, null, this.d);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.appbrand.a.a.s
 * JD-Core Version:    0.7.0.1
 */