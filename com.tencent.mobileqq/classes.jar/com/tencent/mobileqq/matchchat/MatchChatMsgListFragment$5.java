package com.tencent.mobileqq.matchchat;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.qqexpand.utils.IExpandReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MatchChatMsgListFragment$5
  implements View.OnClickListener
{
  MatchChatMsgListFragment$5(MatchChatMsgListFragment paramMatchChatMsgListFragment) {}
  
  public void onClick(View paramView)
  {
    ((IExpandReportUtils)QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("click#message_page#go_setting", true, -1L, -1L, null, true, true);
    AllInOne localAllInOne = new AllInOne(this.a.a.getCurrentAccountUin(), 0);
    ProfileActivity.a(this.a.getActivity(), localAllInOne, 1031);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.matchchat.MatchChatMsgListFragment.5
 * JD-Core Version:    0.7.0.1
 */