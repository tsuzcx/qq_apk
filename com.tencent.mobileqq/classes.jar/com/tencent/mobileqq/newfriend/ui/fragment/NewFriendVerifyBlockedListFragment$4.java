package com.tencent.mobileqq.newfriend.ui.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.newfriend.api.impl.NewFriendVerificationServiceImpl;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;

class NewFriendVerifyBlockedListFragment$4
  implements View.OnClickListener
{
  NewFriendVerifyBlockedListFragment$4(NewFriendVerifyBlockedListFragment paramNewFriendVerifyBlockedListFragment) {}
  
  public void onClick(View paramView)
  {
    NewFriendVerificationServiceImpl.getService(NewFriendVerifyBlockedListFragment.a(this.a).getAppRuntime()).clearAddFriendBlockedList(NewFriendVerifyBlockedListFragment.a(this.a).getAppRuntime().getCurrentAccountUin());
    ReportController.b(null, "dc00898", "", "", "0X800A3A9", "0X800A3A9", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.ui.fragment.NewFriendVerifyBlockedListFragment.4
 * JD-Core Version:    0.7.0.1
 */