package com.tencent.mobileqq.guild.privatechannel.dialog;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class GuildPrivateSubSelectMemberFragment$1
  implements View.OnClickListener
{
  GuildPrivateSubSelectMemberFragment$1(GuildPrivateSubSelectMemberFragment paramGuildPrivateSubSelectMemberFragment) {}
  
  public void onClick(View paramView)
  {
    GuildPrivateSubSelectMemberFragment.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.privatechannel.dialog.GuildPrivateSubSelectMemberFragment.1
 * JD-Core Version:    0.7.0.1
 */