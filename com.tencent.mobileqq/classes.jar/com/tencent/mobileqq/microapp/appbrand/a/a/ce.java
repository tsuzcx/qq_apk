package com.tencent.mobileqq.microapp.appbrand.a.a;

import com.tencent.mobileqq.microapp.appbrand.a;
import com.tencent.mobileqq.microapp.appbrand.page.AbsAppBrandPage;
import com.tencent.mobileqq.microapp.appbrand.page.AppBrandPageContainer;
import com.tencent.mobileqq.microapp.appbrand.page.WebviewContainer;
import com.tencent.mobileqq.microapp.webview.BaseAppBrandWebview;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedList;

final class ce
  implements Runnable
{
  ce(bj parambj, String paramString, BaseAppBrandWebview paramBaseAppBrandWebview, int paramInt) {}
  
  public void run()
  {
    Object localObject = this.d.a.a.g.pageLinkedList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((AbsAppBrandPage)((Iterator)localObject).next()).stopPullDownRefresh();
    }
    localObject = this.d.a.a.g.getCurrentWebviewContainer();
    if (localObject == null)
    {
      QLog.w("UIJsPlugin", 2, "handleNativeRequest event=" + this.a + "， top page not found");
      this.d.a.b(this.b, this.a, null, this.c);
      return;
    }
    ((WebviewContainer)localObject).startPullDownRefresh();
    this.d.a.a(this.b, this.a, null, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.appbrand.a.a.ce
 * JD-Core Version:    0.7.0.1
 */