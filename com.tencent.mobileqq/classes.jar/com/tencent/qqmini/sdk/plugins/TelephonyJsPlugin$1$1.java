package com.tencent.qqmini.sdk.plugins;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.qqmini.sdk.action.PhoneNumberAction.PhoneNumberActionCallback;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.StorageUtil;
import org.json.JSONObject;

class TelephonyJsPlugin$1$1
  implements PhoneNumberAction.PhoneNumberActionCallback
{
  TelephonyJsPlugin$1$1(TelephonyJsPlugin.1 param1) {}
  
  public void onGetAuthDialogRet(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      Object localObject = ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getAccount();
      SharedPreferences.Editor localEditor = StorageUtil.getPreference().edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("_PhoneNumber");
      localEditor.putString(localStringBuilder.toString(), paramJSONObject.optString("purePhoneNumber")).commit();
      paramJSONObject.remove("countryCode");
      paramJSONObject.remove("purePhoneNumber");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getPhoneNumber ret : ");
      ((StringBuilder)localObject).append(paramJSONObject);
      QMLog.d("TelephonyJsPlugin", ((StringBuilder)localObject).toString());
      this.this$1.val$req.ok(paramJSONObject);
      return;
    }
    this.this$1.val$req.fail("auth deny, no permission");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.TelephonyJsPlugin.1.1
 * JD-Core Version:    0.7.0.1
 */