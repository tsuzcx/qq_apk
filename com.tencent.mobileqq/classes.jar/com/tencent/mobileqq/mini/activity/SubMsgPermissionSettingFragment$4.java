package com.tencent.mobileqq.mini.activity;

import NS_MINI_INTERFACE.INTERFACE.StSubscribeMessage;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.mini.widget.AuthDetailDialog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SubMsgPermissionSettingFragment$4
  implements View.OnClickListener
{
  SubMsgPermissionSettingFragment$4(SubMsgPermissionSettingFragment paramSubMsgPermissionSettingFragment) {}
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag() instanceof INTERFACE.StSubscribeMessage))
    {
      INTERFACE.StSubscribeMessage localStSubscribeMessage = (INTERFACE.StSubscribeMessage)paramView.getTag();
      new AuthDetailDialog(this.this$0.getActivity(), localStSubscribeMessage, -1, -1, 2).show();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.activity.SubMsgPermissionSettingFragment.4
 * JD-Core Version:    0.7.0.1
 */