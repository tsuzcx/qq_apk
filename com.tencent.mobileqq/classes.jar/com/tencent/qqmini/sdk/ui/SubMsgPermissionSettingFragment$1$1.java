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
    boolean bool = true;
    long l = -1L;
    if (paramJSONObject != null)
    {
      QMLog.e(SubMsgPermissionSettingFragment.access$100(), "onCheckedChanged, " + this.val$scopeName + "_setAuthorize:" + paramBoolean + ",ret" + paramJSONObject.toString());
      l = paramJSONObject.optLong("retCode");
    }
    String str;
    if ((!paramBoolean) || (l == -101510007L))
    {
      this.this$1.this$0.getActivity().runOnUiThread(new SubMsgPermissionSettingFragment.1.1.1(this, l));
      SubMsgPermissionSettingFragment.access$002(this.this$1.this$0, true);
      paramJSONObject = this.val$buttonView;
      if (this.val$isChecked) {
        break label169;
      }
      paramBoolean = true;
      paramJSONObject.setChecked(paramBoolean);
      paramJSONObject = this.this$1.this$0.authState;
      str = this.val$scopeName;
      if (this.val$isChecked) {
        break label174;
      }
    }
    label169:
    label174:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      paramJSONObject.setAuthState(str, paramBoolean);
      return;
      paramBoolean = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ui.SubMsgPermissionSettingFragment.1.1
 * JD-Core Version:    0.7.0.1
 */