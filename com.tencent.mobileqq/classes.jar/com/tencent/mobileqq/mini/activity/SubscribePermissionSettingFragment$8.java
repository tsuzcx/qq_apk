package com.tencent.mobileqq.mini.activity;

import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.mini.app.AuthorizeCenter;
import com.tencent.mobileqq.mini.model.SubscribeItemModel;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class SubscribePermissionSettingFragment$8
  implements MiniAppCmdInterface
{
  SubscribePermissionSettingFragment$8(SubscribePermissionSettingFragment paramSubscribePermissionSettingFragment, int paramInt, boolean paramBoolean, SubscribeItemModel paramSubscribeItemModel) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    long l;
    if (paramJSONObject != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCheckedChanged, setting.appMsgSubscribed_setAuthorize:");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(",ret");
      localStringBuilder.append(paramJSONObject.toString());
      QLog.e("SubscribePermissionSettingFragment", 1, localStringBuilder.toString());
      l = paramJSONObject.optLong("retCode");
    }
    else
    {
      l = -1L;
    }
    if ((!paramBoolean) || (l == -101510007L))
    {
      this.this$0.getBaseActivity().runOnUiThread(new SubscribePermissionSettingFragment.8.1(this, l));
      SubscribePermissionSettingFragment.access$1200(this.this$0).setAuthorize("setting.appMsgSubscribed", this.val$isChecked ^ true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.activity.SubscribePermissionSettingFragment.8
 * JD-Core Version:    0.7.0.1
 */