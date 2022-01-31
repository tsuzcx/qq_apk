package com.tencent.qqmini.sdk.minigame.plugins;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import bgok;
import bhaj;

class OpenDataJsPlugin$9
  implements DialogInterface.OnClickListener
{
  OpenDataJsPlugin$9(OpenDataJsPlugin paramOpenDataJsPlugin, String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, Boolean paramBoolean, bgok parambgok, String paramString8, String paramString9) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface != null) {}
    try
    {
      paramDialogInterface.dismiss();
      OpenDataJsPlugin.access$800(this.this$0, this.val$key, this.val$opNum, this.val$operation, this.val$toUser, this.val$nick, this.val$title, this.val$imageUrl, this.val$imageUrlId, this.val$quiet, this.val$req, this.val$action, this.val$object);
      return;
    }
    catch (Throwable paramDialogInterface)
    {
      bhaj.a().e("OpenDataJsPlugin", "handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE error " + paramDialogInterface.getMessage());
      bhaj.a("handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE error " + paramDialogInterface.getMessage());
      this.val$req.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.plugins.OpenDataJsPlugin.9
 * JD-Core Version:    0.7.0.1
 */