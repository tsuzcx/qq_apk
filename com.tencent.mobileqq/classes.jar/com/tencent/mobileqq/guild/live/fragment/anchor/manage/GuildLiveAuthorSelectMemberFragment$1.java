package com.tencent.mobileqq.guild.live.fragment.anchor.manage;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class GuildLiveAuthorSelectMemberFragment$1
  implements View.OnClickListener
{
  GuildLiveAuthorSelectMemberFragment$1(GuildLiveAuthorSelectMemberFragment paramGuildLiveAuthorSelectMemberFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.onBackEvent();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.fragment.anchor.manage.GuildLiveAuthorSelectMemberFragment.1
 * JD-Core Version:    0.7.0.1
 */