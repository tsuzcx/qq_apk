package com.tencent.qqmini.sdk.core.plugins;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import bgkd;
import com.tencent.qqmini.sdk.log.QMLog;

class InternalJSPlugin$5$2
  implements DialogInterface.OnClickListener
{
  InternalJSPlugin$5$2(InternalJSPlugin.5 param5) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QMLog.e("InternalJSPlugin", "cancel");
    this.this$1.val$req.a("click cancel");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.InternalJSPlugin.5.2
 * JD-Core Version:    0.7.0.1
 */