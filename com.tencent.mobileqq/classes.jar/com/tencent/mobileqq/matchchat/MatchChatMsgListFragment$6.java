package com.tencent.mobileqq.matchchat;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.extendfriend.utils.ExpandReportUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MatchChatMsgListFragment$6
  implements View.OnClickListener
{
  MatchChatMsgListFragment$6(MatchChatMsgListFragment paramMatchChatMsgListFragment) {}
  
  public void onClick(View paramView)
  {
    ExpandReportUtils.a("click#message_page#go_setting", true, -1L, -1L, null, true, true);
    ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(this.a.a.getCurrentAccountUin(), 0);
    ProfileActivity.b(this.a.getActivity(), localAllInOne, 1031);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.matchchat.MatchChatMsgListFragment.6
 * JD-Core Version:    0.7.0.1
 */