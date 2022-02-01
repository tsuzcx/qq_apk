package com.tencent.qqmini.sdk.plugins;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

class InternalJSPlugin$8$1
  implements DialogInterface.OnClickListener
{
  InternalJSPlugin$8$1(InternalJSPlugin.8 param8) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QMLog.d("InternalJSPlugin", "confirmOpenAppDetailPage downloadUrl : " + this.this$1.val$downloadUrl);
    InternalJSPlugin.access$1000(this.this$1.this$0, this.this$1.val$activity, this.this$1.val$nativeAppId, this.this$1.val$packageName, this.this$1.val$appName, this.this$1.val$downloadUrl);
    this.this$1.val$req.ok();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.InternalJSPlugin.8.1
 * JD-Core Version:    0.7.0.1
 */