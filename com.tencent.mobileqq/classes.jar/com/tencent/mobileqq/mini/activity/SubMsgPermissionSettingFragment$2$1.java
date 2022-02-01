package com.tencent.mobileqq.mini.activity;

import NS_MINI_INTERFACE.INTERFACE.StSubscribeMessage;
import android.widget.CompoundButton;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.widget.QQToast;
import org.json.JSONObject;

class SubMsgPermissionSettingFragment$2$1
  implements MiniAppCmdInterface
{
  SubMsgPermissionSettingFragment$2$1(SubMsgPermissionSettingFragment.2 param2, INTERFACE.StSubscribeMessage paramStSubscribeMessage, boolean paramBoolean, CompoundButton paramCompoundButton) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    boolean bool = true;
    if (paramBoolean)
    {
      SubMsgPermissionSettingFragment.access$200(this.this$1.this$0).updateSubMsgItem(this.val$curSubItem, this.val$isChecked);
      return;
    }
    QQToast.a(this.this$1.this$0.getActivity(), this.this$1.this$0.getString(2131693804), 0).a();
    SubMsgPermissionSettingFragment.access$002(this.this$1.this$0, true);
    paramJSONObject = this.val$buttonView;
    if (!this.val$isChecked) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      paramJSONObject.setChecked(paramBoolean);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.activity.SubMsgPermissionSettingFragment.2.1
 * JD-Core Version:    0.7.0.1
 */