package com.tencent.mobileqq.extendfriend.fragment;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.uitls.ApolloConstant;
import com.tencent.mobileqq.apollo.api.uitls.IApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.extendfriend.utils.ExpandReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ExtendFriendApolloGuideDialogFragment$2
  implements View.OnClickListener
{
  ExtendFriendApolloGuideDialogFragment$2(ExtendFriendApolloGuideDialogFragment paramExtendFriendApolloGuideDialogFragment) {}
  
  public void onClick(View paramView)
  {
    if (((IApolloManagerService)ExtendFriendApolloGuideDialogFragment.a(this.a).getRuntimeService(IApolloManagerService.class, "all")).is3dAvailable(ExtendFriendApolloGuideDialogFragment.a(this.a))) {}
    for (String str = ApolloConstant.u;; str = ApolloConstant.v)
    {
      ((IApolloUtil)QRoute.api(IApolloUtil.class)).openApolloStore(ExtendFriendApolloGuideDialogFragment.a(this.a), null, "extendFriend", str, null);
      ReportController.b(ExtendFriendApolloGuideDialogFragment.a(this.a).app, "dc00898", "", "", "0X800B443", "0X800B443", 1, 0, "", "", "", "");
      ExpandReportUtils.a("click#dress_guide_page#go_dress", true, -1L, -1L, null, true, true);
      ExtendFriendApolloGuideDialogFragment.a(this.a);
      ExtendFriendApolloGuideDialogFragment.a(this.a).setVisibility(8);
      this.a.dismiss();
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.fragment.ExtendFriendApolloGuideDialogFragment.2
 * JD-Core Version:    0.7.0.1
 */