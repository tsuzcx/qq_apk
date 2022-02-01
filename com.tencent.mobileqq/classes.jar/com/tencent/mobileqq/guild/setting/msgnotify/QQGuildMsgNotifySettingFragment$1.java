package com.tencent.mobileqq.guild.setting.msgnotify;

import com.tencent.mobileqq.qqguildsdk.callback.ISetChannelMsgNotifyTypeCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.widget.QQToast;

class QQGuildMsgNotifySettingFragment$1
  implements ISetChannelMsgNotifyTypeCallback
{
  QQGuildMsgNotifySettingFragment$1(QQGuildMsgNotifySettingFragment paramQQGuildMsgNotifySettingFragment) {}
  
  public void a(int paramInt, IGProChannelInfo paramIGProChannelInfo, String paramString)
  {
    if (paramInt != 0) {
      if (paramInt == 39006) {
        QQToast.makeText(this.a.getContext(), 1, 2131890536, 0).show();
      } else {
        QQToast.makeText(this.a.getContext(), 1, 2131890321, 0).show();
      }
    }
    paramIGProChannelInfo = this.a;
    paramIGProChannelInfo = QQGuildMsgNotifySettingFragment.a(paramIGProChannelInfo, paramIGProChannelInfo.l(), QQGuildMsgNotifySettingFragment.a(this.a));
    if (paramIGProChannelInfo != null)
    {
      QQGuildMsgNotifySettingFragment.b(this.a).a(paramIGProChannelInfo);
      QQGuildMsgNotifySettingFragment.b(this.a).notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.setting.msgnotify.QQGuildMsgNotifySettingFragment.1
 * JD-Core Version:    0.7.0.1
 */