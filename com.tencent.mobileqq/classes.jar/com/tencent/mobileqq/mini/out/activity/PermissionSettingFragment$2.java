package com.tencent.mobileqq.mini.out.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.mini.activity.SubMsgPermissionSettingFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PermissionSettingFragment$2
  implements View.OnClickListener
{
  PermissionSettingFragment$2(PermissionSettingFragment paramPermissionSettingFragment) {}
  
  public void onClick(View paramView)
  {
    SubMsgPermissionSettingFragment.launch(this.this$0.getActivity(), this.this$0.appId);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.out.activity.PermissionSettingFragment.2
 * JD-Core Version:    0.7.0.1
 */