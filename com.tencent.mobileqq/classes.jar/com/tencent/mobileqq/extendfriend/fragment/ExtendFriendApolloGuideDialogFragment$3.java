package com.tencent.mobileqq.extendfriend.fragment;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.extendfriend.utils.ExpandReportUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ExtendFriendApolloGuideDialogFragment$3
  implements View.OnClickListener
{
  ExtendFriendApolloGuideDialogFragment$3(ExtendFriendApolloGuideDialogFragment paramExtendFriendApolloGuideDialogFragment) {}
  
  public void onClick(View paramView)
  {
    ReportController.b(ExtendFriendApolloGuideDialogFragment.a(this.a).app, "dc00898", "", "", "0X800B446", "0X800B446", 1, 0, "", "", "", "");
    ExpandReportUtils.a("click#dress_guide_page#go_dress", true, -1L, -1L, null, true, true);
    ExtendFriendApolloGuideDialogFragment.a(this.a, "https://cmshow.qq.com/act_apollo/h5_act/cmshow3dsite/dist/html/reserve.html?_wv=3&adtag=extendFriend");
    ExtendFriendApolloGuideDialogFragment.a(this.a);
    ExtendFriendApolloGuideDialogFragment.a(this.a).setVisibility(8);
    this.a.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.fragment.ExtendFriendApolloGuideDialogFragment.3
 * JD-Core Version:    0.7.0.1
 */