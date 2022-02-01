package com.tencent.mobileqq.guild.channel;

import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.guild.widget.CharacterCountEditText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QQGuildChannelNameSettingFragment$1
  implements View.OnClickListener
{
  QQGuildChannelNameSettingFragment$1(QQGuildChannelNameSettingFragment paramQQGuildChannelNameSettingFragment) {}
  
  public void onClick(View paramView)
  {
    if ((QQGuildChannelNameSettingFragment.a(this.a).getText() != null) && (QQGuildChannelNameSettingFragment.a(this.a).getText().length() > 0)) {
      QQGuildChannelNameSettingFragment.a(this.a).setText("");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.channel.QQGuildChannelNameSettingFragment.1
 * JD-Core Version:    0.7.0.1
 */