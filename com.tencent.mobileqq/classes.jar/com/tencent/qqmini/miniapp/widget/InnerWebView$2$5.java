package com.tencent.qqmini.miniapp.widget;

import com.tencent.qqmini.sdk.action.CheckLocationAction.CheckLocationPermissionCallback;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;

class InnerWebView$2$5
  implements CheckLocationAction.CheckLocationPermissionCallback
{
  InnerWebView$2$5(InnerWebView.2 param2, GeolocationPermissionsCallback paramGeolocationPermissionsCallback, String paramString) {}
  
  public void onCheckLocationPermissionAction(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onGeolocationPermissionsShowPrompt isConfirm : ");
    localStringBuilder.append(paramBoolean);
    QMLog.w("InnerWebView", localStringBuilder.toString());
    this.a.invoke(this.b, paramBoolean, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.InnerWebView.2.5
 * JD-Core Version:    0.7.0.1
 */