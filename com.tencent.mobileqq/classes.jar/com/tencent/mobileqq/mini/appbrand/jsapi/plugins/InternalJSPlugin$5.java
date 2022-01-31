package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import ajyc;
import android.app.Activity;
import android.util.Log;
import bbcv;
import bbgg;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;

class InternalJSPlugin$5
  implements Runnable
{
  InternalJSPlugin$5(InternalJSPlugin paramInternalJSPlugin, Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, JsRuntime paramJsRuntime, String paramString5, int paramInt) {}
  
  public void run()
  {
    bbgg localbbgg = bbcv.a(this.val$activity, 230, ajyc.a(2131705804), String.format(ajyc.a(2131705802), new Object[] { this.val$appName }), ajyc.a(2131705799), ajyc.a(2131705797), new InternalJSPlugin.5.1(this), new InternalJSPlugin.5.2(this));
    try
    {
      localbbgg.show();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("InternalJSPlugin", 1, "confirmOpenAppDetailPage, Exception: " + Log.getStackTraceString(localException));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.InternalJSPlugin.5
 * JD-Core Version:    0.7.0.1
 */