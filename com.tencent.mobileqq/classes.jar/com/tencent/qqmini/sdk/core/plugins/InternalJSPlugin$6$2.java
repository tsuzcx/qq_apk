package com.tencent.qqmini.sdk.core.plugins;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import bdfz;
import bdnw;

class InternalJSPlugin$6$2
  implements DialogInterface.OnClickListener
{
  InternalJSPlugin$6$2(InternalJSPlugin.6 param6) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    bdnw.d("InternalJSPlugin", "cancel");
    this.this$1.val$req.a("click cancel");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.InternalJSPlugin.6.2
 * JD-Core Version:    0.7.0.1
 */