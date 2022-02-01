package com.tencent.qqmini.sdk.plugins;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

class OpenDataCommonJsPlugin$13
  implements DialogInterface.OnClickListener
{
  OpenDataCommonJsPlugin$13(OpenDataCommonJsPlugin paramOpenDataCommonJsPlugin, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, RequestEvent paramRequestEvent) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface != null) {}
    try
    {
      paramDialogInterface.dismiss();
      OpenDataCommonJsPlugin.access$800(this.this$0, this.val$openid, this.val$nick, this.val$title, this.val$imageUrl, this.val$imageUrlId, this.val$req);
      OpenDataCommonJsPlugin.access$1000(this.this$0, OpenDataCommonJsPlugin.access$900(this.this$0), "share_modifyFriendInteractiveStorage", "success", 2, null);
      return;
    }
    catch (Throwable paramDialogInterface)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE  share error ");
      localStringBuilder.append(paramDialogInterface.getMessage());
      QMLog.e("OpenDataCommonJsPlugin", localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.OpenDataCommonJsPlugin.13
 * JD-Core Version:    0.7.0.1
 */