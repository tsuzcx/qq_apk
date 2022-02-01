package com.tencent.mobileqq.guild.channel;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QQGuildVoiceChannelMemberLimitFragment$3
  implements View.OnClickListener
{
  QQGuildVoiceChannelMemberLimitFragment$3(QQGuildVoiceChannelMemberLimitFragment paramQQGuildVoiceChannelMemberLimitFragment) {}
  
  public void onClick(View paramView)
  {
    String str = QQGuildVoiceChannelMemberLimitFragment.a(this.a).getText().toString();
    QQGuildVoiceChannelMemberLimitFragment.a(this.a, str);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.channel.QQGuildVoiceChannelMemberLimitFragment.3
 * JD-Core Version:    0.7.0.1
 */