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
      GameLog.getInstance().e("OpenDataPlugin", "handleNativeRequest API_SHARE_MESSAGE_TO_FRIEND cancel");
      GameLog.vconsoleLog("handleNativeRequest API_SHARE_MESSAGE_TO_FRIEND cancel");
      this.this$1.this$0.jsPluginEngine.callbackJsEventFail(this.this$1.val$jsRuntime, "shareMessageToFriend", null, "cancel", this.this$1.val$callbackId);
      return;
    }
    catch (Throwable paramDialogInterface)
    {
      GameLog.getInstance().e("OpenDataPlugin", "handleNativeRequest API_SHARE_MESSAGE_TO_FRIEND error " + paramDialogInterface.getMessage());
      GameLog.vconsoleLog("handleNativeRequest API_SHARE_MESSAGE_TO_FRIEND error " + paramDialogInterface.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.jsapi.plugins.OpenDataPlugin.5.2
 * JD-Core Version:    0.7.0.1
 */