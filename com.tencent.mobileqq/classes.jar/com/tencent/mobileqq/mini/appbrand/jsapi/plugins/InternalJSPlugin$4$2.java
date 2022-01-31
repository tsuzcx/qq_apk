package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class InternalJSPlugin$4$2
  implements DialogInterface.OnClickListener
{
  InternalJSPlugin$4$2(InternalJSPlugin.4 param4) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QLog.e("InternalJSPlugin", 2, "cancel");
    this.this$1.this$0.jsPluginEngine.callbackJsEventFail(this.this$1.val$webview, this.this$1.val$eventName, null, "click cancel", this.this$1.val$callbackId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.InternalJSPlugin.4.2
 * JD-Core Version:    0.7.0.1
 */