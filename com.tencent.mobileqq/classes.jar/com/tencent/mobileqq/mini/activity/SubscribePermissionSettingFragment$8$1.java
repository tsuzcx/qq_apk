package com.tencent.mobileqq.mini.activity;

import com.tencent.mobileqq.widget.QQToast;

class SubscribePermissionSettingFragment$8$1
  implements Runnable
{
  SubscribePermissionSettingFragment$8$1(SubscribePermissionSettingFragment.8 param8, long paramLong) {}
  
  public void run()
  {
    boolean bool = false;
    if (this.val$finalErrCode == -101510007L) {
      QQToast.a(this.this$1.this$0.getActivity(), this.this$1.this$0.getString(2131694176), 0).a();
    }
    for (;;)
    {
      SubscribePermissionSettingFragment localSubscribePermissionSettingFragment = this.this$1.this$0;
      int i = this.this$1.val$position;
      if (!this.this$1.val$isChecked) {
        bool = true;
      }
      SubscribePermissionSettingFragment.access$100(localSubscribePermissionSettingFragment, i, bool, this.this$1.val$clickItem);
      return;
      QQToast.a(this.this$1.this$0.getActivity(), this.this$1.this$0.getString(2131694194), 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.activity.SubscribePermissionSettingFragment.8.1
 * JD-Core Version:    0.7.0.1
 */