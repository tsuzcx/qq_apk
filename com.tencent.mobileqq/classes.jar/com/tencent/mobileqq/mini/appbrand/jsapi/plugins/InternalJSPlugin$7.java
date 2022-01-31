package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import alpo;
import android.app.Activity;
import android.util.Log;
import bdcd;
import bdfq;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;

class InternalJSPlugin$7
  implements Runnable
{
  InternalJSPlugin$7(InternalJSPlugin paramInternalJSPlugin, Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, JsRuntime paramJsRuntime, String paramString5, int paramInt) {}
  
  public void run()
  {
    bdfq localbdfq = bdcd.a(this.val$activity, 230, alpo.a(2131706187), String.format(alpo.a(2131706185), new Object[] { this.val$appName }), alpo.a(2131706182), alpo.a(2131706180), new InternalJSPlugin.7.1(this), new InternalJSPlugin.7.2(this));
    try
    {
      localbdfq.show();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("InternalJSPlugin", 1, "confirmOpenAppDetailPage, Exception: " + Log.getStackTraceString(localException));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.InternalJSPlugin.7
 * JD-Core Version:    0.7.0.1
 */