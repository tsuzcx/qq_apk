package com.tencent.qqmini.sdk.plugins;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

class InternalJSPlugin$8$2
  implements DialogInterface.OnClickListener
{
  InternalJSPlugin$8$2(InternalJSPlugin.8 param8) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QMLog.e("InternalJSPlugin", "cancel");
    paramDialogInterface = InternalJSPlugin.access$700(this.this$1.this$0, 5);
    this.this$1.val$req.fail(paramDialogInterface, "click download cancel");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.InternalJSPlugin.8.2
 * JD-Core Version:    0.7.0.1
 */