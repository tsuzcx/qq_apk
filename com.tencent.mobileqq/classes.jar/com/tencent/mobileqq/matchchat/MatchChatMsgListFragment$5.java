package com.tencent.mobileqq.matchchat;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.extendfriend.utils.ExpandReportUtils;
import com.tencent.mobileqq.widget.AdvancedTipsBar;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MatchChatMsgListFragment$5
  implements View.OnClickListener
{
  MatchChatMsgListFragment$5(MatchChatMsgListFragment paramMatchChatMsgListFragment) {}
  
  public void onClick(View paramView)
  {
    ExpandReportUtils.a("click#message_page#hidden", true, -1L, -1L, null, true, true);
    MatchChatMsgUtil.b(this.a.a);
    MatchChatMsgListFragment.a(this.a).setVisibility(8);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.matchchat.MatchChatMsgListFragment.5
 * JD-Core Version:    0.7.0.1
 */