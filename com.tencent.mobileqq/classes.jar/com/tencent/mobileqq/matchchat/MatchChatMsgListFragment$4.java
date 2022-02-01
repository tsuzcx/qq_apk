package com.tencent.mobileqq.matchchat;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.qqexpand.utils.IExpandReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.AdvancedTipsBar;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MatchChatMsgListFragment$4
  implements View.OnClickListener
{
  MatchChatMsgListFragment$4(MatchChatMsgListFragment paramMatchChatMsgListFragment) {}
  
  public void onClick(View paramView)
  {
    ((IExpandReportUtils)QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("click#message_page#hidden", true, -1L, -1L, null, true, true);
    MatchChatMsgUtil.b(this.a.a);
    MatchChatMsgListFragment.a(this.a).setVisibility(8);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.matchchat.MatchChatMsgListFragment.4
 * JD-Core Version:    0.7.0.1
 */