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
      QQToast.makeText(this.this$1.this$0.getBaseActivity(), this.this$1.this$0.getString(2131891763), 0).show();
      return;
    }
    QQToast.makeText(this.this$1.this$0.getBaseActivity(), this.this$1.this$0.getString(2131891788), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.out.activity.PermissionSettingFragment.3.1
 * JD-Core Version:    0.7.0.1
 */