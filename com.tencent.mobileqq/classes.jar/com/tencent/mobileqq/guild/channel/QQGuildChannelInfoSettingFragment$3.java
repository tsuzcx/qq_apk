package com.tencent.mobileqq.guild.channel;

import com.tencent.mobileqq.guild.widget.GuildSwitchButton;
import com.tencent.mobileqq.qqguildsdk.callback.ISetChannelMsgNotifyTypeCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class QQGuildChannelInfoSettingFragment$3
  implements ISetChannelMsgNotifyTypeCallback
{
  QQGuildChannelInfoSettingFragment$3(QQGuildChannelInfoSettingFragment paramQQGuildChannelInfoSettingFragment) {}
  
  public void a(int paramInt, IGProChannelInfo paramIGProChannelInfo, String paramString)
  {
    if (QLog.isColorLevel())
    {
      paramIGProChannelInfo = new StringBuilder();
      paramIGProChannelInfo.append("set msg notify result = ");
      paramIGProChannelInfo.append(paramInt);
      QLog.d("QQGuildChannelInfoSettingFragment", 2, paramIGProChannelInfo.toString());
    }
    if (paramInt != 0)
    {
      paramIGProChannelInfo = this.a.getQBaseActivity();
      boolean bool = false;
      if (paramIGProChannelInfo != null) {
        QQToast.makeText(this.a.getQBaseActivity(), 1, 2131890321, 0).show();
      }
      QQGuildChannelInfoSettingFragment.b(this.a).setOnCheckedChangeListener(null);
      if (QLog.isColorLevel())
      {
        paramIGProChannelInfo = new StringBuilder();
        paramIGProChannelInfo.append("onSetChannelMsgNotfiyTypeResult. channelId: ");
        paramIGProChannelInfo.append(this.a.o.getChannelUin());
        paramIGProChannelInfo.append(", getMsgNotify: ");
        paramIGProChannelInfo.append(this.a.o.getMsgNotify());
        QLog.d("QQGuildChannelInfoSettingFragment", 2, paramIGProChannelInfo.toString());
      }
      paramIGProChannelInfo = QQGuildChannelInfoSettingFragment.b(this.a);
      if (this.a.o.getMsgNotify() == 1) {
        bool = true;
      }
      paramIGProChannelInfo.setChecked(bool);
      QQGuildChannelInfoSettingFragment.b(this.a).setOnCheckedChangeListener(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.channel.QQGuildChannelInfoSettingFragment.3
 * JD-Core Version:    0.7.0.1
 */