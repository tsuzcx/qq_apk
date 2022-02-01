package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.minigame.utils.GameLog;

class OpenDataPlugin$6
  implements DialogInterface.OnClickListener
{
  OpenDataPlugin$6(OpenDataPlugin paramOpenDataPlugin, String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, Boolean paramBoolean, JsRuntime paramJsRuntime, int paramInt2, String paramString8, String paramString9, int paramInt3) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface != null) {}
    try
    {
      paramDialogInterface.dismiss();
      OpenDataPlugin.access$300(this.this$0, this.val$key, this.val$opNum, this.val$operation, this.val$toUser, this.val$nick, this.val$title, this.val$imageUrl, this.val$imageUrlId, this.val$quiet, this.val$jsRuntime, this.val$callbackId, this.val$action, this.val$object, this.val$ratio);
      return;
    }
    catch (Throwable paramDialogInterface)
    {
      GameLog.getInstance().e("OpenDataPlugin", "handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE error " + paramDialogInterface.getMessage());
      GameLog.vconsoleLog("handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE error " + paramDialogInterface.getMessage());
      this.this$0.jsPluginEngine.callbackJsEventFail(this.val$jsRuntime, "modifyFriendInteractiveStorage", null, this.val$callbackId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.OpenDataPlugin.6
 * JD-Core Version:    0.7.0.1
 */