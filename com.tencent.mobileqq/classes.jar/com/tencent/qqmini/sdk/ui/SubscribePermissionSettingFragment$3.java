package com.tencent.qqmini.sdk.ui;

import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import org.json.JSONObject;

class SubscribePermissionSettingFragment$3
  implements AsyncResult
{
  SubscribePermissionSettingFragment$3(SubscribePermissionSettingFragment paramSubscribePermissionSettingFragment) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    SubscribePermissionSettingFragment localSubscribePermissionSettingFragment = this.this$0;
    SubscribePermissionSettingFragment.access$002(localSubscribePermissionSettingFragment, SubscribePermissionSettingFragment.access$400(localSubscribePermissionSettingFragment, paramBoolean, paramJSONObject));
    SubscribePermissionSettingFragment.access$500(this.this$0);
    paramJSONObject = this.this$0;
    SubscribePermissionSettingFragment.access$600(paramJSONObject, SubscribePermissionSettingFragment.access$000(paramJSONObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ui.SubscribePermissionSettingFragment.3
 * JD-Core Version:    0.7.0.1
 */