package com.tencent.mobileqq.mini.activity;

import android.content.res.Resources;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;

class SubscribePermissionSettingFragment$5
  implements Runnable
{
  SubscribePermissionSettingFragment$5(SubscribePermissionSettingFragment paramSubscribePermissionSettingFragment) {}
  
  public void run()
  {
    if (SubscribePermissionSettingFragment.access$700(this.this$0) == null)
    {
      SubscribePermissionSettingFragment localSubscribePermissionSettingFragment = this.this$0;
      SubscribePermissionSettingFragment.access$702(localSubscribePermissionSettingFragment, new QQProgressDialog(localSubscribePermissionSettingFragment.getBaseActivity()));
    }
    if (!SubscribePermissionSettingFragment.access$700(this.this$0).isShowing())
    {
      SubscribePermissionSettingFragment.access$700(this.this$0).a(this.this$0.getBaseActivity().getResources().getString(2131892324));
      SubscribePermissionSettingFragment.access$700(this.this$0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.activity.SubscribePermissionSettingFragment.5
 * JD-Core Version:    0.7.0.1
 */