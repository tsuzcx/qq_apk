package com.tencent.mobileqq.mini.out.activity;

import android.support.v4.app.FragmentActivity;
import android.widget.CompoundButton;
import com.tencent.mobileqq.mini.app.AuthorizeCenter;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class PermissionSettingFragment$2
  implements MiniAppCmdInterface
{
  PermissionSettingFragment$2(PermissionSettingFragment paramPermissionSettingFragment, String paramString, boolean paramBoolean, CompoundButton paramCompoundButton) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    boolean bool = true;
    QLog.e(PermissionSettingFragment.access$000(), 1, "onCheckedChanged, setAuthorize:" + paramBoolean + ",ret" + paramJSONObject.toString());
    long l = -1L;
    if (paramJSONObject != null) {
      l = paramJSONObject.optLong("retCode");
    }
    String str;
    if ((!paramBoolean) || (l == -101510007L))
    {
      this.this$0.getActivity().runOnUiThread(new PermissionSettingFragment.2.1(this, l));
      paramJSONObject = PermissionSettingFragment.access$300(this.this$0);
      str = this.val$scopeName;
      if (this.val$isChecked) {
        break label179;
      }
      paramBoolean = true;
      paramJSONObject.changeChecked(str, paramBoolean);
      PermissionSettingFragment.access$402(this.this$0, true);
      paramJSONObject = this.val$buttonView;
      if (this.val$isChecked) {
        break label184;
      }
      paramBoolean = true;
      label143:
      paramJSONObject.setChecked(paramBoolean);
      paramJSONObject = this.this$0.authorizeCenter;
      str = this.val$scopeName;
      if (this.val$isChecked) {
        break label189;
      }
    }
    label179:
    label184:
    label189:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      paramJSONObject.setAuthorize(str, paramBoolean);
      return;
      paramBoolean = false;
      break;
      paramBoolean = false;
      break label143;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.out.activity.PermissionSettingFragment.2
 * JD-Core Version:    0.7.0.1
 */