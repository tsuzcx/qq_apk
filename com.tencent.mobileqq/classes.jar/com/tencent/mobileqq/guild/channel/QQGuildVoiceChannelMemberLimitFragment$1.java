package com.tencent.mobileqq.guild.channel;

import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QQGuildVoiceChannelMemberLimitFragment$1
  implements View.OnClickListener
{
  QQGuildVoiceChannelMemberLimitFragment$1(QQGuildVoiceChannelMemberLimitFragment paramQQGuildVoiceChannelMemberLimitFragment) {}
  
  public void onClick(View paramView)
  {
    if ((QQGuildVoiceChannelMemberLimitFragment.a(this.a).getText() != null) && (QQGuildVoiceChannelMemberLimitFragment.a(this.a).getText().length() > 0)) {
      QQGuildVoiceChannelMemberLimitFragment.a(this.a).setText("");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.channel.QQGuildVoiceChannelMemberLimitFragment.1
 * JD-Core Version:    0.7.0.1
 */