package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.page.AbsAppBrandPage;
import com.tencent.mobileqq.mini.appbrand.page.AppBrandPageContainer;
import com.tencent.mobileqq.mini.ui.NavigationBar;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.mini.widget.TabBarView;

class EmbeddedVideoJsPlugin$2
  implements Runnable
{
  EmbeddedVideoJsPlugin$2(EmbeddedVideoJsPlugin paramEmbeddedVideoJsPlugin, JsRuntime paramJsRuntime, String paramString, int paramInt) {}
  
  public void run()
  {
    AbsAppBrandPage localAbsAppBrandPage = ((AppBrandPageContainer)this.this$0.jsPluginEngine.appBrandRuntime.getContainer()).getPageByWebViewId(this.val$webview.getPageWebViewId());
    if (localAbsAppBrandPage != null)
    {
      EmbeddedVideoJsPlugin.access$002(this.this$0, localAbsAppBrandPage.getNavBar().getVisibility());
      localAbsAppBrandPage.getNavBar().setVisibility(8);
      EmbeddedVideoJsPlugin.access$102(this.this$0, localAbsAppBrandPage.getTabBar().getVisibility());
      localAbsAppBrandPage.getTabBar().setVisibility(8);
      EmbeddedVideoJsPlugin.access$200(this.this$0);
      this.this$0.jsPluginEngine.callbackJsEventOK(this.val$webview, this.val$eventName, null, this.val$callbackId);
      return;
    }
    this.this$0.jsPluginEngine.callbackJsEventFail(this.val$webview, this.val$eventName, null, this.val$callbackId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.EmbeddedVideoJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */