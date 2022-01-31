package com.tencent.mobileqq.microapp.appbrand.a.a;

import com.tencent.mobileqq.microapp.appbrand.a;
import com.tencent.mobileqq.microapp.appbrand.page.AbsAppBrandPage;
import com.tencent.mobileqq.microapp.appbrand.page.AppBrandPageContainer;
import com.tencent.mobileqq.microapp.webview.BaseAppBrandWebview;
import java.util.Iterator;
import java.util.LinkedList;

final class cf
  implements Runnable
{
  cf(bj parambj, BaseAppBrandWebview paramBaseAppBrandWebview, String paramString, int paramInt) {}
  
  public void run()
  {
    Iterator localIterator = this.d.a.a.g.pageLinkedList.iterator();
    while (localIterator.hasNext()) {
      ((AbsAppBrandPage)localIterator.next()).stopPullDownRefresh();
    }
    this.d.a.a(this.a, this.b, null, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.appbrand.a.a.cf
 * JD-Core Version:    0.7.0.1
 */