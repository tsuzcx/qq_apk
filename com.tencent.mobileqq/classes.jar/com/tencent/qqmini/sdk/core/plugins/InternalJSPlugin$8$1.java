package com.tencent.qqmini.sdk.core.plugins;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import bgok;
import com.tencent.qqmini.sdk.log.QMLog;

class InternalJSPlugin$8$1
  implements DialogInterface.OnClickListener
{
  InternalJSPlugin$8$1(InternalJSPlugin.8 param8) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QMLog.d("InternalJSPlugin", "confirmOpenAppDetailPage downloadUrl : " + this.this$1.val$downloadUrl);
    InternalJSPlugin.access$200(this.this$1.this$0, this.this$1.val$activity, this.this$1.val$nativeAppId, this.this$1.val$packageName, this.this$1.val$appName, this.this$1.val$downloadUrl);
    this.this$1.val$req.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.InternalJSPlugin.8.1
 * JD-Core Version:    0.7.0.1
 */