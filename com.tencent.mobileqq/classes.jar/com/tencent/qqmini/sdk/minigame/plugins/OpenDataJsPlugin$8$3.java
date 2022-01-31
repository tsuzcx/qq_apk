package com.tencent.qqmini.sdk.minigame.plugins;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import bgwc;

class OpenDataJsPlugin$8$3
  implements DialogInterface.OnCancelListener
{
  OpenDataJsPlugin$8$3(OpenDataJsPlugin.8 param8) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    bgwc.a().e("OpenDataJsPlugin", "handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE share cancel");
    bgwc.a("handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE share cancel");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.plugins.OpenDataJsPlugin.8.3
 * JD-Core Version:    0.7.0.1
 */