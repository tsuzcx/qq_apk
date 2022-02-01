package com.tencent.qqmini.sdk.plugins;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

class OpenDataCommonJsPlugin$16
  implements DialogInterface.OnClickListener
{
  OpenDataCommonJsPlugin$16(OpenDataCommonJsPlugin paramOpenDataCommonJsPlugin, String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, Boolean paramBoolean, RequestEvent paramRequestEvent, String paramString8, String paramString9, int paramInt2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface != null) {}
    try
    {
      paramDialogInterface.dismiss();
      OpenDataCommonJsPlugin.access$1000(this.n, OpenDataCommonJsPlugin.access$1300(this.n), "share_modifyFriendInteractiveStorage", "success", 1, null);
      OpenDataCommonJsPlugin.access$1400(this.n, this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m);
      return;
    }
    catch (Throwable paramDialogInterface)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE error ");
      localStringBuilder.append(paramDialogInterface);
      QMLog.e("OpenDataCommonJsPlugin", localStringBuilder.toString());
      this.j.fail(paramDialogInterface.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.OpenDataCommonJsPlugin.16
 * JD-Core Version:    0.7.0.1
 */