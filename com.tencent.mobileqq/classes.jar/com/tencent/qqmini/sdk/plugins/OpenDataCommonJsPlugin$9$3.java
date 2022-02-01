package com.tencent.qqmini.sdk.plugins;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

class OpenDataCommonJsPlugin$9$3
  implements DialogInterface.OnCancelListener
{
  OpenDataCommonJsPlugin$9$3(OpenDataCommonJsPlugin.9 param9) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    QMLog.e("OpenDataCommonJsPlugin", "handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE share cancel");
    OpenDataCommonJsPlugin.access$700(this.this$1.this$0, OpenDataCommonJsPlugin.access$900(this.this$1.this$0), "share_modifyFriendInteractiveStorage", "fail", 2, "cancel");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.OpenDataCommonJsPlugin.9.3
 * JD-Core Version:    0.7.0.1
 */