package com.tencent.mobileqq.mini.out.activity;

import com.tencent.mobileqq.widget.QQToast;

class PermissionSettingFragment$2$1
  implements Runnable
{
  PermissionSettingFragment$2$1(PermissionSettingFragment.2 param2, long paramLong) {}
  
  public void run()
  {
    if (this.val$finalErrCode == -101510007L)
    {
      QQToast.a(this.this$1.this$0.getActivity(), this.this$1.this$0.getString(2131694416), 0).a();
      return;
    }
    QQToast.a(this.this$1.this$0.getActivity(), this.this$1.this$0.getString(2131694422), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.out.activity.PermissionSettingFragment.2.1
 * JD-Core Version:    0.7.0.1
 */