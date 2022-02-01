package com.tencent.mobileqq.mini.activity;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SubscribePermissionSettingFragment$1
  implements View.OnClickListener
{
  SubscribePermissionSettingFragment$1(SubscribePermissionSettingFragment paramSubscribePermissionSettingFragment) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131369231) {
      this.this$0.getActivity().finish();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.activity.SubscribePermissionSettingFragment.1
 * JD-Core Version:    0.7.0.1
 */