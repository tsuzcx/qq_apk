package com.tencent.mobileqq.mini.activity;

import com.tencent.mobileqq.widget.QQToast;

class SubscribePermissionSettingFragment$8$1
  implements Runnable
{
  SubscribePermissionSettingFragment$8$1(SubscribePermissionSettingFragment.8 param8, long paramLong) {}
  
  public void run()
  {
    if (this.val$finalErrCode == -101510007L) {
      QQToast.a(this.this$1.this$0.getBaseActivity(), this.this$1.this$0.getString(2131694135), 0).a();
    } else {
      QQToast.a(this.this$1.this$0.getBaseActivity(), this.this$1.this$0.getString(2131694158), 0).a();
    }
    SubscribePermissionSettingFragment.access$100(this.this$1.this$0, this.this$1.val$position, this.this$1.val$isChecked ^ true, this.this$1.val$clickItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.activity.SubscribePermissionSettingFragment.8.1
 * JD-Core Version:    0.7.0.1
 */