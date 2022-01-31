package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.page.AbsAppBrandPage;
import com.tencent.mobileqq.mini.appbrand.page.AppBrandPageContainer;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedList;

class UIJsPlugin$11
  implements Runnable
{
  UIJsPlugin$11(UIJsPlugin paramUIJsPlugin, boolean paramBoolean, JsRuntime paramJsRuntime, String paramString, int paramInt) {}
  
  public void run()
  {
    Iterator localIterator = ((AppBrandPageContainer)this.this$0.jsPluginEngine.appBrandRuntime.getContainer()).pageLinkedList.iterator();
    while (localIterator.hasNext())
    {
      AbsAppBrandPage localAbsAppBrandPage = (AbsAppBrandPage)localIterator.next();
      QLog.e("[mini] UIJsPlugin", 2, "page.setEnablePullDownRefresh()");
      localAbsAppBrandPage.setDisablePullDownRefresh(this.val$disableRefresh);
    }
    this.this$0.jsPluginEngine.callbackJsEventOK(this.val$webview, this.val$event, null, this.val$callbackId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.UIJsPlugin.11
 * JD-Core Version:    0.7.0.1
 */