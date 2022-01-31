package com.tencent.mobileqq.minigame.jsapi.plugins;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BaseJsPluginEngine;
import com.tencent.mobileqq.minigame.utils.GameLog;

class OpenDataPlugin$5$2
  implements DialogInterface.OnClickListener
{
  OpenDataPlugin$5$2(OpenDataPlugin.5 param5) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface != null) {}
    try
    {
      paramDialogInterface.dismiss();
      GameLog.getInstance().e("OpenDataPlugin", "handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE cancel");
      GameLog.vconsoleLog("handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE cancel");
      this.this$1.this$0.jsPluginEngine.callbackJsEventFail(this.this$1.val$jsRuntime, "modifyFriendInteractiveStorage", null, "cancel", this.this$1.val$callbackId);
      return;
    }
    catch (Throwable paramDialogInterface)
    {
      GameLog.getInstance().e("OpenDataPlugin", "handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE error " + paramDialogInterface.getMessage());
      GameLog.vconsoleLog("handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE error " + paramDialogInterface.getMessage());
      this.this$1.this$0.jsPluginEngine.callbackJsEventFail(this.this$1.val$jsRuntime, "modifyFriendInteractiveStorage", null, this.this$1.val$callbackId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.jsapi.plugins.OpenDataPlugin.5.2
 * JD-Core Version:    0.7.0.1
 */