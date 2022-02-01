package com.tencent.mobileqq.newfriend.ui.fragment;

import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.IAddFriendTempApi;
import com.tencent.mobileqq.statistics.ReportController;

class NewFriendVerifyBlockedListFragment$5
  extends ClickableSpan
{
  NewFriendVerifyBlockedListFragment$5(NewFriendVerifyBlockedListFragment paramNewFriendVerifyBlockedListFragment) {}
  
  public void onClick(View paramView)
  {
    ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).gotoFriendSettingBrowser(NewFriendVerifyBlockedListFragment.a(this.a));
    ReportController.b(null, "dc00898", "", "", "0X800A3AA", "0X800A3AA", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.ui.fragment.NewFriendVerifyBlockedListFragment.5
 * JD-Core Version:    0.7.0.1
 */