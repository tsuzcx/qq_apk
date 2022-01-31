package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import Wallet.FocusMpIdRsp;
import ajjy;
import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import bbmy;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import mqq.observer.BusinessObserver;

class DataJsPlugin$14
  implements BusinessObserver
{
  DataJsPlugin$14(DataJsPlugin paramDataJsPlugin, JsRuntime paramJsRuntime, String paramString, int paramInt) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    paramBundle = (FocusMpIdRsp)paramBundle.getSerializable("rsp");
    if ((paramBundle == null) || (paramBundle.err_code != 0))
    {
      this.this$0.jsPluginEngine.callbackJsEventFail(this.val$webview, this.val$event, null, this.val$callbackId);
      bbmy.a(this.this$0.jsPluginEngine.appBrandRuntime.activity, 0, ajjy.a(2131636946), 1).b(this.this$0.jsPluginEngine.appBrandRuntime.activity.getResources().getDimensionPixelSize(2131167766));
      return;
    }
    bbmy.a(this.this$0.jsPluginEngine.appBrandRuntime.activity, 0, ajjy.a(2131636950), 1).b(this.this$0.jsPluginEngine.appBrandRuntime.activity.getResources().getDimensionPixelSize(2131167766));
    this.this$0.jsPluginEngine.callbackJsEventOK(this.val$webview, this.val$event, null, this.val$callbackId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.DataJsPlugin.14
 * JD-Core Version:    0.7.0.1
 */