package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class InternalJSPlugin$5$1
  implements DialogInterface.OnClickListener
{
  InternalJSPlugin$5$1(InternalJSPlugin.5 param5) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    InternalJSPlugin.access$100(this.this$1.val$activity, this.this$1.val$appid, this.this$1.val$packageName);
    this.this$1.this$0.jsPluginEngine.callbackJsEventOK(this.this$1.val$webview, this.this$1.val$eventName, null, this.this$1.val$callbackId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.InternalJSPlugin.5.1
 * JD-Core Version:    0.7.0.1
 */