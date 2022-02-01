package com.tencent.mobileqq.mini.activity;

import bhht;
import com.tencent.mobileqq.widget.QQToast;

class SubMsgPermissionSettingFragment$3$1
  implements Runnable
{
  SubMsgPermissionSettingFragment$3$1(SubMsgPermissionSettingFragment.3 param3, boolean paramBoolean) {}
  
  public void run()
  {
    SubMsgPermissionSettingFragment.access$400(this.this$1.this$0).dismiss();
    if (!this.val$isSuc) {
      QQToast.a(this.this$1.this$0.getActivity(), this.this$1.this$0.getString(2131693804), 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.activity.SubMsgPermissionSettingFragment.3.1
 * JD-Core Version:    0.7.0.1
 */