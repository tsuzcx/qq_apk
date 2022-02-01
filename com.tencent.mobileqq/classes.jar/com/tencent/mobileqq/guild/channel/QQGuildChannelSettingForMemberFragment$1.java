package com.tencent.mobileqq.guild.channel;

import com.tencent.mobileqq.guild.widget.GuildSwitchButton;
import com.tencent.mobileqq.qqguildsdk.callback.ISetChannelMsgNotifyTypeCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class QQGuildChannelSettingForMemberFragment$1
  implements ISetChannelMsgNotifyTypeCallback
{
  QQGuildChannelSettingForMemberFragment$1(QQGuildChannelSettingForMemberFragment paramQQGuildChannelSettingForMemberFragment) {}
  
  public void a(int paramInt, IGProChannelInfo paramIGProChannelInfo, String paramString)
  {
    if (QLog.isColorLevel())
    {
      paramIGProChannelInfo = new StringBuilder();
      paramIGProChannelInfo.append("set msg notify result = ");
      paramIGProChannelInfo.append(paramInt);
      paramIGProChannelInfo.append(" channelUin = ");
      paramIGProChannelInfo.append(QQGuildChannelSettingForMemberFragment.a(this.a));
      QLog.d("QQGuildChannelSettingForMemberFragment", 2, paramIGProChannelInfo.toString());
    }
    if (paramInt == 0) {
      return;
    }
    paramIGProChannelInfo = this.a.getQBaseActivity();
    boolean bool = false;
    if (paramIGProChannelInfo != null) {
      QQToast.makeText(this.a.getQBaseActivity(), 1, 2131890321, 0).show();
    }
    QQGuildChannelSettingForMemberFragment.b(this.a).setOnCheckedChangeListener(null);
    if (QLog.isColorLevel())
    {
      paramIGProChannelInfo = new StringBuilder();
      paramIGProChannelInfo.append("onSetChannelMsgNotfiyTypeResult. channelId: ");
      paramIGProChannelInfo.append(QQGuildChannelSettingForMemberFragment.c(this.a).getChannelUin());
      paramIGProChannelInfo.append(", getFinalMsgNotify: ");
      paramIGProChannelInfo.append(QQGuildChannelSettingForMemberFragment.c(this.a).getFinalMsgNotify());
      QLog.d("QQGuildChannelSettingForMemberFragment", 2, paramIGProChannelInfo.toString());
    }
    paramIGProChannelInfo = QQGuildChannelSettingForMemberFragment.b(this.a);
    if (QQGuildChannelSettingForMemberFragment.c(this.a).getFinalMsgNotify() == 1) {
      bool = true;
    }
    paramIGProChannelInfo.setChecked(bool);
    QQGuildChannelSettingForMemberFragment.b(this.a).setOnCheckedChangeListener(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.channel.QQGuildChannelSettingForMemberFragment.1
 * JD-Core Version:    0.7.0.1
 */