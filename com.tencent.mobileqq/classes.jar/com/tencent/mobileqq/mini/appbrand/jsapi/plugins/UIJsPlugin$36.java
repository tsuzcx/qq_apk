package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.page.AbsAppBrandPage;
import com.tencent.mobileqq.mini.appbrand.page.AppBrandPage;
import com.tencent.mobileqq.mini.appbrand.page.AppBrandPageContainer;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.minigame.jsapi.GameBrandRuntime;
import com.tencent.mobileqq.minigame.ui.GameActivity;

class UIJsPlugin$36
  implements Runnable
{
  UIJsPlugin$36(UIJsPlugin paramUIJsPlugin, JsRuntime paramJsRuntime, String paramString, int paramInt) {}
  
  public void run()
  {
    if (this.this$0.isMiniGameRuntime()) {
      if ((((GameBrandRuntime)this.this$0.jsPluginEngine.appBrandRuntime).activity instanceof GameActivity)) {
        ((GameActivity)((GameBrandRuntime)this.this$0.jsPluginEngine.appBrandRuntime).activity).hideMiniAIOEntrance();
      }
    }
    for (;;)
    {
      this.this$0.jsPluginEngine.callbackJsEventOK(this.val$webview, this.val$event, null, this.val$callbackId);
      return;
      AbsAppBrandPage localAbsAppBrandPage = ((AppBrandPageContainer)this.this$0.jsPluginEngine.appBrandRuntime.getContainer()).getCurrentPage();
      if ((localAbsAppBrandPage instanceof AppBrandPage)) {
        ((AppBrandPage)localAbsAppBrandPage).hideMiniAIOEntrance();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.UIJsPlugin.36
 * JD-Core Version:    0.7.0.1
 */