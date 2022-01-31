package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.page.AbsAppBrandPage;
import com.tencent.mobileqq.mini.appbrand.page.AppBrandPageContainer;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONObject;

class UIJsPlugin$15
  implements Runnable
{
  UIJsPlugin$15(UIJsPlugin paramUIJsPlugin, String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt) {}
  
  public void run()
  {
    try
    {
      if ("light".equals(new JSONObject(this.val$jsonParams).optString("textStyle", "light"))) {}
      for (((AppBrandPageContainer)this.this$0.jsPluginEngine.appBrandRuntime.getContainer()).refreshStyleColor = -1;; ((AppBrandPageContainer)this.this$0.jsPluginEngine.appBrandRuntime.getContainer()).refreshStyleColor = -16777216)
      {
        Iterator localIterator = ((AppBrandPageContainer)this.this$0.jsPluginEngine.appBrandRuntime.getContainer()).pageLinkedList.iterator();
        while (localIterator.hasNext()) {
          ((AbsAppBrandPage)localIterator.next()).notifyChangePullDownRefreshStyle();
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("[mini] UIJsPlugin", 1, this.val$event + " error.", localException);
      }
      this.this$0.jsPluginEngine.callbackJsEventOK(this.val$webview, this.val$event, null, this.val$callbackId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.UIJsPlugin.15
 * JD-Core Version:    0.7.0.1
 */