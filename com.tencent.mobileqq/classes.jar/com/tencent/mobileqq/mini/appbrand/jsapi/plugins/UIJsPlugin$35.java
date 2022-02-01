package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.page.AbsAppBrandPage;
import com.tencent.mobileqq.mini.appbrand.page.AppBrandPage;
import com.tencent.mobileqq.mini.appbrand.page.AppBrandPageContainer;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.minigame.jsapi.GameBrandRuntime;
import com.tencent.mobileqq.minigame.ui.GameActivity;
import org.json.JSONObject;

class UIJsPlugin$35
  implements Runnable
{
  UIJsPlugin$35(UIJsPlugin paramUIJsPlugin, JSONObject paramJSONObject, JsRuntime paramJsRuntime, String paramString, int paramInt) {}
  
  public void run()
  {
    boolean bool;
    if (this.this$0.isMiniGameRuntime())
    {
      if (!(((GameBrandRuntime)this.this$0.jsPluginEngine.appBrandRuntime).activity instanceof GameActivity)) {
        break label153;
      }
      bool = ((GameActivity)((GameBrandRuntime)this.this$0.jsPluginEngine.appBrandRuntime).activity).showMiniAIOEntrance(this.val$jsonObject);
    }
    for (;;)
    {
      if (bool)
      {
        this.this$0.jsPluginEngine.callbackJsEventOK(this.val$webview, this.val$event, null, this.val$callbackId);
        return;
        AbsAppBrandPage localAbsAppBrandPage = ((AppBrandPageContainer)this.this$0.jsPluginEngine.appBrandRuntime.getContainer()).getCurrentPage();
        if ((localAbsAppBrandPage instanceof AppBrandPage)) {
          bool = ((AppBrandPage)localAbsAppBrandPage).showMiniAIOEntrance(this.val$jsonObject);
        }
      }
      else
      {
        this.this$0.jsPluginEngine.callbackJsEventFail(this.val$webview, this.val$event, null, this.val$callbackId);
        return;
      }
      label153:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.UIJsPlugin.35
 * JD-Core Version:    0.7.0.1
 */