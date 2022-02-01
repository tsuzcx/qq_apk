package com.tencent.qqmini.sdk.plugins;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

class OpenDataCommonJsPlugin$17
  implements DialogInterface.OnCancelListener
{
  OpenDataCommonJsPlugin$17(OpenDataCommonJsPlugin paramOpenDataCommonJsPlugin, RequestEvent paramRequestEvent) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    QMLog.e("OpenDataCommonJsPlugin", "handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE cancel");
    this.a.fail("cancel");
    paramDialogInterface = this.b;
    OpenDataCommonJsPlugin.access$1000(paramDialogInterface, OpenDataCommonJsPlugin.access$1500(paramDialogInterface), "share_modifyFriendInteractiveStorage", "fail", 1, "cancel");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.OpenDataCommonJsPlugin.17
 * JD-Core Version:    0.7.0.1
 */