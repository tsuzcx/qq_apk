package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import Wallet.FocusMpIdRsp;
import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import anzj;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.widget.QQToast;
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
      QQToast.a(this.this$0.jsPluginEngine.appBrandRuntime.activity, 0, anzj.a(2131701639), 1).b(this.this$0.jsPluginEngine.appBrandRuntime.activity.getResources().getDimensionPixelSize(2131299011));
      return;
    }
    QQToast.a(this.this$0.jsPluginEngine.appBrandRuntime.activity, 0, anzj.a(2131701643), 1).b(this.this$0.jsPluginEngine.appBrandRuntime.activity.getResources().getDimensionPixelSize(2131299011));
    this.this$0.jsPluginEngine.callbackJsEventOK(this.val$webview, this.val$event, null, this.val$callbackId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.DataJsPlugin.14
 * JD-Core Version:    0.7.0.1
 */