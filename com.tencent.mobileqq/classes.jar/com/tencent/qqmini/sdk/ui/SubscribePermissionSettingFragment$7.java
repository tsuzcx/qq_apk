package com.tencent.qqmini.sdk.ui;

import android.support.v4.app.FragmentActivity;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.model.SubscribeItemModel;
import org.json.JSONObject;

class SubscribePermissionSettingFragment$7
  implements AsyncResult
{
  SubscribePermissionSettingFragment$7(SubscribePermissionSettingFragment paramSubscribePermissionSettingFragment, int paramInt, boolean paramBoolean, SubscribeItemModel paramSubscribeItemModel) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (!paramBoolean) {
      this.this$0.getActivity().runOnUiThread(new SubscribePermissionSettingFragment.7.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ui.SubscribePermissionSettingFragment.7
 * JD-Core Version:    0.7.0.1
 */