package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

class InternalJSPlugin$5$1
  implements DialogInterface.OnClickListener
{
  InternalJSPlugin$5$1(InternalJSPlugin.5 param5) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QLog.d("InternalJSPlugin", 1, "confirmOpenAppDetailPage downloadUrl : " + this.this$1.val$downloadUrl);
    if (!TextUtils.isEmpty(this.this$1.val$downloadUrl))
    {
      QLog.d("InternalJSPlugin", 1, "手Q下载");
      InternalJSPlugin.access$100(this.this$1.this$0, this.this$1.val$activity, this.this$1.val$nativeAppId, this.this$1.val$packageName, this.this$1.val$appName, this.this$1.val$downloadUrl);
    }
    for (;;)
    {
      this.this$1.this$0.jsPluginEngine.callbackJsEventOK(this.this$1.val$webview, this.this$1.val$eventName, null, this.this$1.val$callbackId);
      return;
      QLog.d("InternalJSPlugin", 1, "应用宝微下载");
      InternalJSPlugin.access$200(this.this$1.this$0, this.this$1.val$activity, this.this$1.val$nativeAppId, this.this$1.val$packageName);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.InternalJSPlugin.5.1
 * JD-Core Version:    0.7.0.1
 */