package com.tencent.mobileqq.mini.activity;

import com.tencent.mobileqq.widget.QQToast;

class SubscribePermissionSettingFragment$7$1
  implements Runnable
{
  SubscribePermissionSettingFragment$7$1(SubscribePermissionSettingFragment.7 param7) {}
  
  public void run()
  {
    boolean bool = false;
    QQToast.a(this.this$1.this$0.getActivity(), this.this$1.this$0.getString(2131693992), 0).a();
    SubscribePermissionSettingFragment localSubscribePermissionSettingFragment = this.this$1.this$0;
    int i = this.this$1.val$position;
    if (!this.this$1.val$isChecked) {
      bool = true;
    }
    SubscribePermissionSettingFragment.access$100(localSubscribePermissionSettingFragment, i, bool, this.this$1.val$clickItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.activity.SubscribePermissionSettingFragment.7.1
 * JD-Core Version:    0.7.0.1
 */