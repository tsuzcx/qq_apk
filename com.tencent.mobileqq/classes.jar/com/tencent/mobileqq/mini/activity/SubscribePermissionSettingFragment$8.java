package com.tencent.mobileqq.mini.activity;

import android.support.v4.app.FragmentActivity;
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
    boolean bool = true;
    long l = -1L;
    if (paramJSONObject != null)
    {
      QLog.e("SubscribePermissionSettingFragment", 1, "onCheckedChanged, setting.appMsgSubscribed_setAuthorize:" + paramBoolean + ",ret" + paramJSONObject.toString());
      l = paramJSONObject.optLong("retCode");
    }
    if ((!paramBoolean) || (l == -101510007L))
    {
      this.this$0.getActivity().runOnUiThread(new SubscribePermissionSettingFragment.8.1(this, l));
      paramJSONObject = SubscribePermissionSettingFragment.access$1200(this.this$0);
      if (this.val$isChecked) {
        break label114;
      }
    }
    label114:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      paramJSONObject.setAuthorize("setting.appMsgSubscribed", paramBoolean);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.activity.SubscribePermissionSettingFragment.8
 * JD-Core Version:    0.7.0.1
 */