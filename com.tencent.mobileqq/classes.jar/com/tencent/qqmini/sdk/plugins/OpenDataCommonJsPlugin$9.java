package com.tencent.qqmini.sdk.plugins;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

class OpenDataCommonJsPlugin$9
  implements DialogInterface.OnClickListener
{
  OpenDataCommonJsPlugin$9(OpenDataCommonJsPlugin paramOpenDataCommonJsPlugin, String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, Boolean paramBoolean, RequestEvent paramRequestEvent, String paramString8, String paramString9, int paramInt2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface != null) {}
    try
    {
      paramDialogInterface.dismiss();
      OpenDataCommonJsPlugin.access$700(this.this$0, OpenDataCommonJsPlugin.access$1200(this.this$0), "share_modifyFriendInteractiveStorage", "success", 1, null);
      OpenDataCommonJsPlugin.access$1300(this.this$0, this.val$key, this.val$opNum, this.val$operation, this.val$toUser, this.val$nick, this.val$title, this.val$imageUrl, this.val$imageUrlId, this.val$quiet, this.val$req, this.val$action, this.val$object, this.val$ratio);
      return;
    }
    catch (Throwable paramDialogInterface)
    {
      QMLog.e("OpenDataCommonJsPlugin", "handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE error " + paramDialogInterface);
      this.val$req.fail(paramDialogInterface.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.OpenDataCommonJsPlugin.9
 * JD-Core Version:    0.7.0.1
 */