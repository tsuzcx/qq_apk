package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.minigame.utils.GameLog;

class OpenDataPlugin$5$1
  implements DialogInterface.OnClickListener
{
  OpenDataPlugin$5$1(OpenDataPlugin.5 param5) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface != null) {}
    try
    {
      paramDialogInterface.dismiss();
      OpenDataPlugin.access$000(this.this$1.this$0, this.this$1.val$toUser, this.this$1.val$nick, this.this$1.val$title, this.this$1.val$imageUrl, this.this$1.val$imageUrlId, this.this$1.val$jsRuntime, this.this$1.val$callbackId, "shareMessageToFriend");
      return;
    }
    catch (Throwable paramDialogInterface)
    {
      GameLog.getInstance().e("OpenDataPlugin", "handleNativeRequest API_SHARE_MESSAGE_TO_FRIEND error " + paramDialogInterface.getMessage());
      GameLog.vconsoleLog("handleNativeRequest API_SHARE_MESSAGE_TO_FRIEND error " + paramDialogInterface.getMessage());
      this.this$1.this$0.jsPluginEngine.callbackJsEventFail(this.this$1.val$jsRuntime, "shareMessageToFriend", null, this.this$1.val$callbackId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.OpenDataPlugin.5.1
 * JD-Core Version:    0.7.0.1
 */