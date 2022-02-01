package com.tencent.qqmini.sdk.ui;

import android.support.v4.app.FragmentActivity;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import org.json.JSONObject;

class SubMsgPermissionSettingFragment$3
  implements AsyncResult
{
  SubMsgPermissionSettingFragment$3(SubMsgPermissionSettingFragment paramSubMsgPermissionSettingFragment) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    SubMsgPermissionSettingFragment.access$300(this.this$0, paramBoolean, paramJSONObject);
    if (this.this$0.getActivity() != null) {
      this.this$0.getActivity().runOnUiThread(new SubMsgPermissionSettingFragment.3.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ui.SubMsgPermissionSettingFragment.3
 * JD-Core Version:    0.7.0.1
 */