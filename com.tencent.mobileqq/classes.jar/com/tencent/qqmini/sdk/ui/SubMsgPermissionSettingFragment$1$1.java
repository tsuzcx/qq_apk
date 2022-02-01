package com.tencent.qqmini.sdk.ui;

import android.support.v4.app.FragmentActivity;
import android.widget.CompoundButton;
import com.tencent.qqmini.sdk.auth.AuthState;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

class SubMsgPermissionSettingFragment$1$1
  implements AsyncResult
{
  SubMsgPermissionSettingFragment$1$1(SubMsgPermissionSettingFragment.1 param1, String paramString, CompoundButton paramCompoundButton, boolean paramBoolean) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    long l;
    if (paramJSONObject != null)
    {
      String str = SubMsgPermissionSettingFragment.access$100();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCheckedChanged, ");
      localStringBuilder.append(this.val$scopeName);
      localStringBuilder.append("_setAuthorize:");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(",ret");
      localStringBuilder.append(paramJSONObject.toString());
      QMLog.e(str, localStringBuilder.toString());
      l = paramJSONObject.optLong("retCode");
    }
    else
    {
      l = -1L;
    }
    if ((!paramBoolean) || (l == -101510007L))
    {
      this.this$1.this$0.getActivity().runOnUiThread(new SubMsgPermissionSettingFragment.1.1.1(this, l));
      SubMsgPermissionSettingFragment.access$002(this.this$1.this$0, true);
      this.val$buttonView.setChecked(this.val$isChecked ^ true);
      this.this$1.this$0.authState.setAuthState(this.val$scopeName, true ^ this.val$isChecked);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ui.SubMsgPermissionSettingFragment.1.1
 * JD-Core Version:    0.7.0.1
 */