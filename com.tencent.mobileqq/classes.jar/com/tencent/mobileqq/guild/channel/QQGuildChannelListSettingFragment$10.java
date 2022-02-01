package com.tencent.mobileqq.guild.channel;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.utils.QQCustomDialog;

class QQGuildChannelListSettingFragment$10
  implements DialogInterface.OnClickListener
{
  QQGuildChannelListSettingFragment$10(QQGuildChannelListSettingFragment paramQQGuildChannelListSettingFragment, GuildChannelInfoUIData paramGuildChannelInfoUIData) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QQGuildChannelListSettingFragment.a(this.b, this.a, true);
    QQGuildChannelListSettingFragment.h(this.b).dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.channel.QQGuildChannelListSettingFragment.10
 * JD-Core Version:    0.7.0.1
 */