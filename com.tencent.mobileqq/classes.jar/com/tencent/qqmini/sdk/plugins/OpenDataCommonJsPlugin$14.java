package com.tencent.qqmini.sdk.plugins;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

class OpenDataCommonJsPlugin$14
  implements DialogInterface.OnClickListener
{
  OpenDataCommonJsPlugin$14(OpenDataCommonJsPlugin paramOpenDataCommonJsPlugin) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface != null) {}
    try
    {
      paramDialogInterface.dismiss();
      OpenDataCommonJsPlugin.access$1000(this.a, OpenDataCommonJsPlugin.access$1100(this.a), "share_modifyFriendInteractiveStorage", "fail", 2, "negative button click");
      QMLog.e("OpenDataCommonJsPlugin", "handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE   share cancel");
      return;
    }
    catch (Throwable paramDialogInterface)
    {
      QMLog.e("OpenDataCommonJsPlugin", "handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE share cancel error " + paramDialogInterface.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.OpenDataCommonJsPlugin.14
 * JD-Core Version:    0.7.0.1
 */