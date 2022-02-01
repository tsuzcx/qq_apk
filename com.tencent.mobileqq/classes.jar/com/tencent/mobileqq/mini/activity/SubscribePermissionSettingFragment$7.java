package com.tencent.mobileqq.mini.activity;

import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.mini.model.SubscribeItemModel;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import org.json.JSONObject;

class SubscribePermissionSettingFragment$7
  implements MiniAppCmdInterface
{
  SubscribePermissionSettingFragment$7(SubscribePermissionSettingFragment paramSubscribePermissionSettingFragment, int paramInt, boolean paramBoolean, SubscribeItemModel paramSubscribeItemModel) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (!paramBoolean) {
      this.this$0.getActivity().runOnUiThread(new SubscribePermissionSettingFragment.7.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.activity.SubscribePermissionSettingFragment.7
 * JD-Core Version:    0.7.0.1
 */