package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import alud;
import android.app.Activity;
import android.content.pm.PackageManager;
import bdgm;
import bdjz;
import com.tencent.mobileqq.mini.webview.JsRuntime;

class InternalJSPlugin$4
  implements Runnable
{
  InternalJSPlugin$4(InternalJSPlugin paramInternalJSPlugin, Activity paramActivity, String paramString1, String paramString2, PackageManager paramPackageManager, String paramString3, JsRuntime paramJsRuntime, String paramString4, int paramInt) {}
  
  public void run()
  {
    bdgm.a(this.val$activity, 230, null, String.format(alud.a(2131706193), new Object[] { this.val$appName }), alud.a(2131706200), alud.a(2131706201), new InternalJSPlugin.4.1(this), new InternalJSPlugin.4.2(this)).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.InternalJSPlugin.4
 * JD-Core Version:    0.7.0.1
 */