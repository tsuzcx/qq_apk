package com.tencent.mobileqq.newfriend.ui.adapter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class NewFriendMoreSysMsgAdapter$2
  implements View.OnClickListener
{
  NewFriendMoreSysMsgAdapter$2(NewFriendMoreSysMsgAdapter paramNewFriendMoreSysMsgAdapter, AppInterface paramAppInterface) {}
  
  public void onClick(View paramView)
  {
    ReportController.b(this.a, "dc00898", "", "", "0X800A327", "0X800A327", 0, 0, "", "", "", "");
    NewFriendMoreSysMsgAdapter.a(this.b);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.ui.adapter.NewFriendMoreSysMsgAdapter.2
 * JD-Core Version:    0.7.0.1
 */