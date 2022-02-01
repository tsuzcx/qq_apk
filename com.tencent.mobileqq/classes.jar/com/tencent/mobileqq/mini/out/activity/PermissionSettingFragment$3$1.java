package com.tencent.mobileqq.mini.out.activity;

import com.tencent.mobileqq.widget.QQToast;

class PermissionSettingFragment$3$1
  implements Runnable
{
  PermissionSettingFragment$3$1(PermissionSettingFragment.3 param3, long paramLong) {}
  
  public void run()
  {
    if (this.val$finalErrCode == -101510007L)
    {
      QQToast.a(this.this$1.this$0.getBaseActivity(), this.this$1.this$0.getString(2131694135), 0).a();
      return;
    }
    QQToast.a(this.this$1.this$0.getBaseActivity(), this.this$1.this$0.getString(2131694158), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.out.activity.PermissionSettingFragment.3.1
 * JD-Core Version:    0.7.0.1
 */