package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import bdit;
import com.tencent.mobileqq.mini.appbrand.page.AbsAppBrandPage;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.mini.widget.ToastView;
import com.tencent.mobileqq.minigame.jsapi.GameJsRuntime;

class UIJsPlugin$4
  implements Runnable
{
  UIJsPlugin$4(UIJsPlugin paramUIJsPlugin, JsRuntime paramJsRuntime, String paramString, int paramInt) {}
  
  public void run()
  {
    if ((this.val$webview instanceof GameJsRuntime))
    {
      if (((UIJsPlugin.access$000(this.this$0) != null) && (UIJsPlugin.access$000(this.this$0).shown())) || (UIJsPlugin.access$100(this.this$0) != null))
      {
        if (UIJsPlugin.access$000(this.this$0) != null) {
          UIJsPlugin.access$000(this.this$0).hide();
        }
        if (UIJsPlugin.access$100(this.this$0) != null)
        {
          UIJsPlugin.access$100(this.this$0).a();
          UIJsPlugin.access$102(this.this$0, null);
        }
        this.this$0.jsPluginEngine.callbackJsEventOK(this.val$webview, this.val$event, null, this.val$callbackId);
        return;
      }
      this.this$0.jsPluginEngine.callbackJsEventFail(this.val$webview, this.val$event, null, "toast can't be found", this.val$callbackId);
      return;
    }
    if (this.this$0.lastPage != null)
    {
      if (this.this$0.lastPage.hasToastView())
      {
        this.this$0.lastPage.hideToastView();
        this.this$0.jsPluginEngine.callbackJsEventOK(this.val$webview, this.val$event, null, this.val$callbackId);
        return;
      }
      this.this$0.jsPluginEngine.callbackJsEventFail(this.val$webview, this.val$event, null, "toast can't be found", this.val$callbackId);
      return;
    }
    this.this$0.jsPluginEngine.callbackJsEventFail(this.val$webview, this.val$event, null, this.val$callbackId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.UIJsPlugin.4
 * JD-Core Version:    0.7.0.1
 */