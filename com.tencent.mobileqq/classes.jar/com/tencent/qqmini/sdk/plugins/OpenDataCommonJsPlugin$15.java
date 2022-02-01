package com.tencent.qqmini.sdk.plugins;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

class OpenDataCommonJsPlugin$15
  implements DialogInterface.OnCancelListener
{
  OpenDataCommonJsPlugin$15(OpenDataCommonJsPlugin paramOpenDataCommonJsPlugin) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    QMLog.e("OpenDataCommonJsPlugin", "handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE share cancel");
    OpenDataCommonJsPlugin.access$1000(this.a, OpenDataCommonJsPlugin.access$1200(this.a), "share_modifyFriendInteractiveStorage", "fail", 2, "cancel");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.OpenDataCommonJsPlugin.15
 * JD-Core Version:    0.7.0.1
 */