package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import alpo;
import android.app.Activity;
import android.content.pm.PackageManager;
import bdcd;
import bdfq;
import com.tencent.mobileqq.mini.webview.JsRuntime;

class InternalJSPlugin$4
  implements Runnable
{
  InternalJSPlugin$4(InternalJSPlugin paramInternalJSPlugin, Activity paramActivity, String paramString1, String paramString2, PackageManager paramPackageManager, String paramString3, JsRuntime paramJsRuntime, String paramString4, int paramInt) {}
  
  public void run()
  {
    bdcd.a(this.val$activity, 230, null, String.format(alpo.a(2131706181), new Object[] { this.val$appName }), alpo.a(2131706188), alpo.a(2131706189), new InternalJSPlugin.4.1(this), new InternalJSPlugin.4.2(this)).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.InternalJSPlugin.4
 * JD-Core Version:    0.7.0.1
 */