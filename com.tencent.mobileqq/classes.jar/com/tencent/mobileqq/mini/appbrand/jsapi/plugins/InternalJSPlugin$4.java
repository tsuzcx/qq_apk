package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.app.Activity;
import android.content.pm.PackageManager;
import anzj;
import bhlq;
import bhpc;
import com.tencent.mobileqq.mini.webview.JsRuntime;

class InternalJSPlugin$4
  implements Runnable
{
  InternalJSPlugin$4(InternalJSPlugin paramInternalJSPlugin, Activity paramActivity, String paramString1, String paramString2, PackageManager paramPackageManager, String paramString3, JsRuntime paramJsRuntime, String paramString4, int paramInt) {}
  
  public void run()
  {
    bhlq.a(this.val$activity, 230, null, String.format(anzj.a(2131704701), new Object[] { this.val$appName }), anzj.a(2131704708), anzj.a(2131704709), new InternalJSPlugin.4.1(this), new InternalJSPlugin.4.2(this)).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.InternalJSPlugin.4
 * JD-Core Version:    0.7.0.1
 */