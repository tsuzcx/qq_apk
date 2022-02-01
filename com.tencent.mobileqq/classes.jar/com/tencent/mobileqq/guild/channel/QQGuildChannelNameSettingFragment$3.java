package com.tencent.mobileqq.guild.channel;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.guild.widget.CharacterCountEditText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.InputMethodUtil;

class QQGuildChannelNameSettingFragment$3
  implements View.OnClickListener
{
  QQGuildChannelNameSettingFragment$3(QQGuildChannelNameSettingFragment paramQQGuildChannelNameSettingFragment) {}
  
  public void onClick(View paramView)
  {
    if (QQGuildChannelNameSettingFragment.a(this.a) != null) {
      InputMethodUtil.b(QQGuildChannelNameSettingFragment.a(this.a));
    }
    String str = QQGuildChannelNameSettingFragment.a(this.a).getText().toString();
    QQGuildChannelNameSettingFragment.a(this.a, str);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.channel.QQGuildChannelNameSettingFragment.3
 * JD-Core Version:    0.7.0.1
 */