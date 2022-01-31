package com.tencent.qqmini.sdk.minigame.plugins;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import bhaj;

class OpenDataJsPlugin$8$2
  implements DialogInterface.OnClickListener
{
  OpenDataJsPlugin$8$2(OpenDataJsPlugin.8 param8) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface != null) {}
    try
    {
      paramDialogInterface.dismiss();
      bhaj.a().e("OpenDataJsPlugin", "handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE   share cancel");
      bhaj.a("handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE   share cancel");
      return;
    }
    catch (Throwable paramDialogInterface)
    {
      bhaj.a().e("OpenDataJsPlugin", "handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE share cancel error " + paramDialogInterface.getMessage());
      bhaj.a("handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE share cancel error " + paramDialogInterface.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.plugins.OpenDataJsPlugin.8.2
 * JD-Core Version:    0.7.0.1
 */