package com.tencent.qqmini.sdk.minigame.plugins;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import bekr;
import bexk;

class OpenDataJsPlugin$9$2
  implements DialogInterface.OnClickListener
{
  OpenDataJsPlugin$9$2(OpenDataJsPlugin.9 param9) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface != null) {}
    try
    {
      paramDialogInterface.dismiss();
      bexk.a().e("OpenDataJsPlugin", "handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE cancel");
      bexk.a("handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE cancel");
      this.this$1.val$req.a("cancel");
      return;
    }
    catch (Throwable paramDialogInterface)
    {
      bexk.a().e("OpenDataJsPlugin", "handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE error " + paramDialogInterface.getMessage());
      bexk.a("handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE error " + paramDialogInterface.getMessage());
      this.this$1.val$req.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.plugins.OpenDataJsPlugin.9.2
 * JD-Core Version:    0.7.0.1
 */