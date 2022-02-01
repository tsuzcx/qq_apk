package com.tencent.qqmini.sdk.ui;

import NS_MINI_INTERFACE.INTERFACE.StSubscribeMessage;
import android.widget.CompoundButton;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.widget.MiniToast;
import org.json.JSONObject;

class SubMsgPermissionSettingFragment$2$1
  implements AsyncResult
{
  SubMsgPermissionSettingFragment$2$1(SubMsgPermissionSettingFragment.2 param2, INTERFACE.StSubscribeMessage paramStSubscribeMessage, boolean paramBoolean, CompoundButton paramCompoundButton) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      SubMsgPermissionSettingFragment.access$200(this.this$1.this$0).updateSubMsgItem(this.val$curSubItem, this.val$isChecked);
      return;
    }
    MiniToast.makeText(this.this$1.this$0.getActivity(), "请求失败，请稍后重试", 0).show();
    SubMsgPermissionSettingFragment.access$002(this.this$1.this$0, true);
    this.val$buttonView.setChecked(true ^ this.val$isChecked);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ui.SubMsgPermissionSettingFragment.2.1
 * JD-Core Version:    0.7.0.1
 */