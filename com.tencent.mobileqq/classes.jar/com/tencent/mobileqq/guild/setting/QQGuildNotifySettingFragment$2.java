package com.tencent.mobileqq.guild.setting;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.guild.api.IGuildAdapterService;
import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.qqguildsdk.callback.ISetChannelMsgNotifyTypeCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.widget.ActionSheet;

class QQGuildNotifySettingFragment$2
  implements ISetChannelMsgNotifyTypeCallback
{
  QQGuildNotifySettingFragment$2(QQGuildNotifySettingFragment paramQQGuildNotifySettingFragment) {}
  
  public void a(int paramInt, IGProChannelInfo paramIGProChannelInfo, String paramString)
  {
    if (paramInt == 0)
    {
      QQGuildNotifySettingFragment.a(this.a).dismiss();
      paramIGProChannelInfo = ((IGuildAdapterService)this.a.l().getRuntimeService(IGuildAdapterService.class, "")).getChannelList(QQGuildNotifySettingFragment.b(this.a).getGuildID(), true);
      QQGuildNotifySettingFragment.c(this.a).a(paramIGProChannelInfo);
      return;
    }
    QQGuildUtil.c("消息通知设置失败");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.setting.QQGuildNotifySettingFragment.2
 * JD-Core Version:    0.7.0.1
 */