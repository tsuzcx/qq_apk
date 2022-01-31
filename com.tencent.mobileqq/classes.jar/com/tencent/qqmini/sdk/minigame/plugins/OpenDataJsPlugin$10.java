package com.tencent.qqmini.sdk.minigame.plugins;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import bgok;
import bhaj;

class OpenDataJsPlugin$10
  implements DialogInterface.OnCancelListener
{
  OpenDataJsPlugin$10(OpenDataJsPlugin paramOpenDataJsPlugin, bgok parambgok) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    bhaj.a().e("OpenDataJsPlugin", "handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE cancel");
    bhaj.a("handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE cancel");
    this.val$req.a("cancel");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.plugins.OpenDataJsPlugin.10
 * JD-Core Version:    0.7.0.1
 */