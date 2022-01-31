package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import alud;
import android.app.Activity;
import android.util.Log;
import bdgm;
import bdjz;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;

class InternalJSPlugin$7
  implements Runnable
{
  InternalJSPlugin$7(InternalJSPlugin paramInternalJSPlugin, Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, JsRuntime paramJsRuntime, String paramString5, int paramInt) {}
  
  public void run()
  {
    bdjz localbdjz = bdgm.a(this.val$activity, 230, alud.a(2131706199), String.format(alud.a(2131706197), new Object[] { this.val$appName }), alud.a(2131706194), alud.a(2131706192), new InternalJSPlugin.7.1(this), new InternalJSPlugin.7.2(this));
    try
    {
      localbdjz.show();
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