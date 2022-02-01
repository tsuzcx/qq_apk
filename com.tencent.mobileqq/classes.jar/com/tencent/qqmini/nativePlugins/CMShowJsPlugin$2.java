package com.tencent.qqmini.nativePlugins;

import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.action.PhoneNumberAction.PhoneNumberActionCallback;
import com.tencent.qqmini.sdk.auth.AuthState;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import org.json.JSONObject;

class CMShowJsPlugin$2
  implements PhoneNumberAction.PhoneNumberActionCallback
{
  CMShowJsPlugin$2(CMShowJsPlugin paramCMShowJsPlugin, String paramString1, AuthState paramAuthState, String paramString2, RequestEvent paramRequestEvent) {}
  
  public void onGetAuthDialogRet(boolean paramBoolean, JSONObject paramJSONObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("showRequestPermissionDialog ret: ");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(", ");
    localStringBuilder.append(paramJSONObject);
    localStringBuilder.append(", ");
    localStringBuilder.append(CMShowJsPlugin.a(this.e).appId);
    QLog.i("CMShowJsPlugin", 2, localStringBuilder.toString());
    if (paramBoolean)
    {
      CMShowJsPlugin.a(this.e, this.a);
      this.b.setAuthState(this.c, true);
      CMShowJsPlugin.a(this.e, this.d);
      return;
    }
    this.b.setAuthState(this.c, false);
    this.d.fail();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.nativePlugins.CMShowJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */