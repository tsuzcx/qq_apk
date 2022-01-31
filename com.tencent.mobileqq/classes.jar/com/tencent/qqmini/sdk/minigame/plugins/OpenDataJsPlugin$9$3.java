package com.tencent.qqmini.sdk.minigame.plugins;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import beka;
import bewt;

class OpenDataJsPlugin$9$3
  implements DialogInterface.OnCancelListener
{
  OpenDataJsPlugin$9$3(OpenDataJsPlugin.9 param9) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    bewt.a().e("OpenDataJsPlugin", "handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE cancel");
    bewt.a("handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE cancel");
    this.this$1.val$req.a("cancel");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.plugins.OpenDataJsPlugin.9.3
 * JD-Core Version:    0.7.0.1
 */