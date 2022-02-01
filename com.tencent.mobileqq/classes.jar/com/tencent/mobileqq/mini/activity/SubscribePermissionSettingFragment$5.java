package com.tencent.mobileqq.mini.activity;

import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;

class SubscribePermissionSettingFragment$5
  implements Runnable
{
  SubscribePermissionSettingFragment$5(SubscribePermissionSettingFragment paramSubscribePermissionSettingFragment) {}
  
  public void run()
  {
    if (SubscribePermissionSettingFragment.access$700(this.this$0) == null) {
      SubscribePermissionSettingFragment.access$702(this.this$0, new QQProgressDialog(this.this$0.getActivity()));
    }
    if (!SubscribePermissionSettingFragment.access$700(this.this$0).isShowing())
    {
      SubscribePermissionSettingFragment.access$700(this.this$0).a(this.this$0.getActivity().getResources().getString(2131694671));
      SubscribePermissionSettingFragment.access$700(this.this$0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.activity.SubscribePermissionSettingFragment.5
 * JD-Core Version:    0.7.0.1
 */