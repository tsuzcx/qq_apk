package com.tencent.qqmini.sdk.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PermissionSettingFragment$2
  implements View.OnClickListener
{
  PermissionSettingFragment$2(PermissionSettingFragment paramPermissionSettingFragment) {}
  
  public void onClick(View paramView)
  {
    SubscribePermissionSettingFragment.launch(this.this$0.getActivity(), this.this$0.appId);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ui.PermissionSettingFragment.2
 * JD-Core Version:    0.7.0.1
 */