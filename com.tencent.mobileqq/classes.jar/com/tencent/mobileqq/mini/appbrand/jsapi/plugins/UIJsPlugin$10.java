package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.page.AbsAppBrandPage;
import com.tencent.mobileqq.mini.appbrand.page.AppBrandPageContainer;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import java.util.Iterator;
import java.util.LinkedList;

class UIJsPlugin$10
  implements Runnable
{
  UIJsPlugin$10(UIJsPlugin paramUIJsPlugin, JsRuntime paramJsRuntime, String paramString, int paramInt) {}
  
  public void run()
  {
    Iterator localIterator = ((AppBrandPageContainer)this.this$0.jsPluginEngine.appBrandRuntime.getContainer()).pageLinkedList.iterator();
    while (localIterator.hasNext()) {
      ((AbsAppBrandPage)localIterator.next()).stopPullDownRefresh();
    }
    this.this$0.jsPluginEngine.callbackJsEventOK(this.val$webview, this.val$event, null, this.val$callbackId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.UIJsPlugin.10
 * JD-Core Version:    0.7.0.1
 */