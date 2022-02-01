package com.tencent.qqmini.sdk.plugins;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

class OpenDataCommonJsPlugin$8$1
  implements DialogInterface.OnClickListener
{
  OpenDataCommonJsPlugin$8$1(OpenDataCommonJsPlugin.8 param8) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface != null) {}
    try
    {
      paramDialogInterface.dismiss();
      OpenDataCommonJsPlugin.access$500(this.this$1.this$0, this.this$1.val$openid, this.this$1.val$nick, this.this$1.val$title, this.this$1.val$imageUrl, this.this$1.val$imageUrlId, this.this$1.val$req);
      OpenDataCommonJsPlugin.access$700(this.this$1.this$0, OpenDataCommonJsPlugin.access$600(this.this$1.this$0), "share_modifyFriendInteractiveStorage", "success", 2, null);
      return;
    }
    catch (Throwable paramDialogInterface)
    {
      QMLog.e("OpenDataCommonJsPlugin", "handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE  share error " + paramDialogInterface.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.OpenDataCommonJsPlugin.8.1
 * JD-Core Version:    0.7.0.1
 */