package com.tencent.mobileqq.extendfriend.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.extendfriend.utils.ExtendFriendReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ExtendFriendCampusFragment$4
  implements View.OnClickListener
{
  ExtendFriendCampusFragment$4(ExtendFriendCampusFragment paramExtendFriendCampusFragment) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a != null)
    {
      this.a.a.a();
      ExtendFriendReport.a().b(3);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.fragment.ExtendFriendCampusFragment.4
 * JD-Core Version:    0.7.0.1
 */