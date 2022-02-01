package com.tencent.mobileqq.guild.channel;

import android.view.View;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class QQGuildChannelListSettingFragment$7
  implements ActionSheet.OnButtonClickListener
{
  QQGuildChannelListSettingFragment$7(QQGuildChannelListSettingFragment paramQQGuildChannelListSettingFragment, GuildChannelInfoUIData paramGuildChannelInfoUIData) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt != 0) {
      return;
    }
    QQGuildChannelListSettingFragment.a(this.b, this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.channel.QQGuildChannelListSettingFragment.7
 * JD-Core Version:    0.7.0.1
 */