package com.tencent.mobileqq.mini.out.activity;

import android.widget.CompoundButton;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.mini.app.AuthorizeCenter;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class PermissionSettingFragment$3
  implements MiniAppCmdInterface
{
  PermissionSettingFragment$3(PermissionSettingFragment paramPermissionSettingFragment, String paramString, boolean paramBoolean, CompoundButton paramCompoundButton) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    String str = PermissionSettingFragment.access$000();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onCheckedChanged, setAuthorize:");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(",ret");
    localStringBuilder.append(paramJSONObject);
    QLog.e(str, 1, localStringBuilder.toString());
    long l;
    if (paramJSONObject != null) {
      l = paramJSONObject.optLong("retCode");
    } else {
      l = -1L;
    }
    if ((!paramBoolean) || (l == -101510007L))
    {
      this.this$0.getBaseActivity().runOnUiThread(new PermissionSettingFragment.3.1(this, l));
      PermissionSettingFragment.access$300(this.this$0).changeChecked(this.val$scopeName, this.val$isChecked ^ true);
      PermissionSettingFragment.access$402(this.this$0, true);
      this.val$buttonView.setChecked(this.val$isChecked ^ true);
      this.this$0.authorizeCenter.setAuthorize(this.val$scopeName, this.val$isChecked ^ true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.out.activity.PermissionSettingFragment.3
 * JD-Core Version:    0.7.0.1
 */