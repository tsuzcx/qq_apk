package com.tencent.qqmini.sdk.core.plugins;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import beka;
import besl;

class InternalJSPlugin$6$1
  implements DialogInterface.OnClickListener
{
  InternalJSPlugin$6$1(InternalJSPlugin.6 param6) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    besl.a("InternalJSPlugin", "confirmOpenAppDetailPage downloadUrl : " + this.this$1.val$downloadUrl);
    InternalJSPlugin.access$200(this.this$1.this$0, this.this$1.val$activity, this.this$1.val$nativeAppId, this.this$1.val$packageName, this.this$1.val$appName, this.this$1.val$downloadUrl);
    this.this$1.val$req.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.InternalJSPlugin.6.1
 * JD-Core Version:    0.7.0.1
 */