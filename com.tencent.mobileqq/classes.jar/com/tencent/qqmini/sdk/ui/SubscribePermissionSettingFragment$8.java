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
    long l;
    if (paramJSONObject != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCheckedChanged, setting.appMsgSubscribed_setAuthorize:");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(",ret");
      localStringBuilder.append(paramJSONObject.toString());
      QMLog.e("SubscribePermissionSettingFragment", localStringBuilder.toString());
      l = paramJSONObject.optLong("retCode");
    }
    else
    {
      l = -1L;
    }
    if ((!paramBoolean) || (l == -101510007L))
    {
      this.this$0.getActivity().runOnUiThread(new SubscribePermissionSettingFragment.8.1(this, l));
      this.this$0.authState.setAuthState("setting.appMsgSubscribed", this.val$isChecked ^ true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ui.SubscribePermissionSettingFragment.8
 * JD-Core Version:    0.7.0.1
 */