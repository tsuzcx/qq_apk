package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import Wallet.FocusMpIdRsp;
import ajya;
import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import bcql;
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
      bcql.a(this.this$0.jsPluginEngine.appBrandRuntime.activity, 0, ajya.a(2131702741), 1).b(this.this$0.jsPluginEngine.appBrandRuntime.activity.getResources().getDimensionPixelSize(2131298865));
      return;
    }
    bcql.a(this.this$0.jsPluginEngine.appBrandRuntime.activity, 0, ajya.a(2131702745), 1).b(this.this$0.jsPluginEngine.appBrandRuntime.activity.getResources().getDimensionPixelSize(2131298865));
    this.this$0.jsPluginEngine.callbackJsEventOK(this.val$webview, this.val$event, null, this.val$callbackId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.DataJsPlugin.14
 * JD-Core Version:    0.7.0.1
 */