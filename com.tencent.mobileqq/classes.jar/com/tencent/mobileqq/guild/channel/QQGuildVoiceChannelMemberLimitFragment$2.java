package com.tencent.mobileqq.guild.channel;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.InputMethodUtil;

class QQGuildVoiceChannelMemberLimitFragment$2
  implements View.OnClickListener
{
  QQGuildVoiceChannelMemberLimitFragment$2(QQGuildVoiceChannelMemberLimitFragment paramQQGuildVoiceChannelMemberLimitFragment) {}
  
  public void onClick(View paramView)
  {
    InputMethodUtil.b(QQGuildVoiceChannelMemberLimitFragment.a(this.a));
    this.a.onBackEvent();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.channel.QQGuildVoiceChannelMemberLimitFragment.2
 * JD-Core Version:    0.7.0.1
 */