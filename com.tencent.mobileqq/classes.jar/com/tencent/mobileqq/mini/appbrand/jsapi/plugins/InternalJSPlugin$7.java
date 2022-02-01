package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import amtj;
import android.app.Activity;
import android.util.Log;
import bfur;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

class InternalJSPlugin$7
  implements Runnable
{
  InternalJSPlugin$7(InternalJSPlugin paramInternalJSPlugin, Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, JsRuntime paramJsRuntime, String paramString5, int paramInt) {}
  
  public void run()
  {
    QQCustomDialog localQQCustomDialog = bfur.a(this.val$activity, 230, amtj.a(2131704937), String.format(amtj.a(2131704935), new Object[] { this.val$appName }), amtj.a(2131704932), amtj.a(2131704930), new InternalJSPlugin.7.1(this), new InternalJSPlugin.7.2(this));
    try
    {
      localQQCustomDialog.show();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("InternalJSPlugin", 1, "confirmOpenAppDetailPage, Exception: " + Log.getStackTraceString(localException));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.InternalJSPlugin.7
 * JD-Core Version:    0.7.0.1
 */