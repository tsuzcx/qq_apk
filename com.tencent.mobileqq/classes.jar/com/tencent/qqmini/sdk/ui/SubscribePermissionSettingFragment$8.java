package com.tencent.qqmini.sdk.ui;

import android.support.v4.app.FragmentActivity;
import com.tencent.qqmini.sdk.auth.AuthState;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.model.SubscribeItemModel;
import org.json.JSONObject;

class SubscribePermissionSettingFragment$8
  implements AsyncResult
{
  SubscribePermissionSettingFragment$8(SubscribePermissionSettingFragment paramSubscribePermissionSettingFragment, int paramInt, boolean paramBoolean, SubscribeItemModel paramSubscribeItemModel) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    long l = -1L;
    if (paramJSONObject != null)
    {
      QMLog.e("SubscribePermissionSettingFragment", "onCheckedChanged, setting.appMsgSubscribed_setAuthorize:" + paramBoolean + ",ret" + paramJSONObject.toString());
      l = paramJSONObject.optLong("retCode");
    }
    if ((!paramBoolean) || (l == -101510007L))
    {
      this.this$0.getActivity().runOnUiThread(new SubscribePermissionSettingFragment.8.1(this, l));
      paramJSONObject = this.this$0.authState;
      if (this.val$isChecked) {
        break label107;
      }
    }
    label107:
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramJSONObject.setAuthState("setting.appMsgSubscribed", paramBoolean);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ui.SubscribePermissionSettingFragment.8
 * JD-Core Version:    0.7.0.1
 */