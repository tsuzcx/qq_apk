package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import amtj;
import android.app.Activity;
import android.content.pm.PackageManager;
import bfur;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.utils.QQCustomDialog;

class InternalJSPlugin$4
  implements Runnable
{
  InternalJSPlugin$4(InternalJSPlugin paramInternalJSPlugin, Activity paramActivity, String paramString1, String paramString2, PackageManager paramPackageManager, String paramString3, JsRuntime paramJsRuntime, String paramString4, int paramInt) {}
  
  public void run()
  {
    bfur.a(this.val$activity, 230, null, String.format(amtj.a(2131704931), new Object[] { this.val$appName }), amtj.a(2131704938), amtj.a(2131704939), new InternalJSPlugin.4.1(this), new InternalJSPlugin.4.2(this)).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.InternalJSPlugin.4
 * JD-Core Version:    0.7.0.1
 */