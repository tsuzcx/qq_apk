package com.tencent.mobileqq.newfriend.ui.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class NewFriendMoreSysMsgActivity$1
  implements View.OnClickListener
{
  NewFriendMoreSysMsgActivity$1(NewFriendMoreSysMsgActivity paramNewFriendMoreSysMsgActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.ui.activity.NewFriendMoreSysMsgActivity.1
 * JD-Core Version:    0.7.0.1
 */