package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class UIJsPlugin$13$2
  implements DialogInterface.OnCancelListener
{
  UIJsPlugin$13$2(UIJsPlugin.13 param13) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.this$1.this$0.jsPluginEngine.callbackJsEventFail(this.this$1.val$webview, this.this$1.val$event, null, this.this$1.val$callbackId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.UIJsPlugin.13.2
 * JD-Core Version:    0.7.0.1
 */