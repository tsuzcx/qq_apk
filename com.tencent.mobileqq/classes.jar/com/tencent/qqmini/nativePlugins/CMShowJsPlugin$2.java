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
    localStringBuilder.append(CMShowJsPlugin.a(this.jdField_a_of_type_ComTencentQqminiNativePluginsCMShowJsPlugin).appId);
    QLog.i("CMShowJsPlugin", 2, localStringBuilder.toString());
    if (paramBoolean)
    {
      CMShowJsPlugin.a(this.jdField_a_of_type_ComTencentQqminiNativePluginsCMShowJsPlugin, this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentQqminiSdkAuthAuthState.setAuthState(this.b, true);
      CMShowJsPlugin.a(this.jdField_a_of_type_ComTencentQqminiNativePluginsCMShowJsPlugin, this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreModelRequestEvent);
      return;
    }
    this.jdField_a_of_type_ComTencentQqminiSdkAuthAuthState.setAuthState(this.b, false);
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreModelRequestEvent.fail();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.nativePlugins.CMShowJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */