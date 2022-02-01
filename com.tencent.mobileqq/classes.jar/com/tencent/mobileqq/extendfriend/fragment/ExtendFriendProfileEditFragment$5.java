package com.tencent.mobileqq.extendfriend.fragment;

import android.support.v4.app.FragmentActivity;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ExtendFriendProfileEditFragment$5
  implements CompoundButton.OnCheckedChangeListener
{
  ExtendFriendProfileEditFragment$5(ExtendFriendProfileEditFragment paramExtendFriendProfileEditFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    ExtendFriendProfileEditFragment.a(this.a.getActivity().app, paramBoolean, new ExtendFriendProfileEditFragment.5.1(this, paramBoolean));
    if (paramBoolean) {}
    for (String str = "0X8009F0F";; str = "0X8009F10")
    {
      ReportController.b(this.a.getActivity().app, "dc00898", "", "", str, str, 0, 0, "", "", "", "");
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.fragment.ExtendFriendProfileEditFragment.5
 * JD-Core Version:    0.7.0.1
 */