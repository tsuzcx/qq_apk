package com.tencent.qqmini.sdk.minigame.plugins;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import beka;
import bewt;

class OpenDataJsPlugin$9$1
  implements DialogInterface.OnClickListener
{
  OpenDataJsPlugin$9$1(OpenDataJsPlugin.9 param9) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface != null) {}
    try
    {
      paramDialogInterface.dismiss();
      OpenDataJsPlugin.access$000(this.this$1.this$0, this.this$1.val$toUser, this.this$1.val$nick, this.this$1.val$title, this.this$1.val$imageUrl, this.this$1.val$imageUrlId, this.this$1.val$req);
      return;
    }
    catch (Throwable paramDialogInterface)
    {
      bewt.a().e("OpenDataJsPlugin", "handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE error " + paramDialogInterface.getMessage());
      bewt.a("handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE error " + paramDialogInterface.getMessage());
      this.this$1.val$req.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.plugins.OpenDataJsPlugin.9.1
 * JD-Core Version:    0.7.0.1
 */