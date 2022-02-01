package com.tencent.mobileqq.guild.channel;

import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.qqguildsdk.callback.IGetChannelCategoryCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.ActionSheet;

class QQGuildChannelListSettingFragment$8
  implements IGetChannelCategoryCallback
{
  QQGuildChannelListSettingFragment$8(QQGuildChannelListSettingFragment paramQQGuildChannelListSettingFragment) {}
  
  public void a(int paramInt, String paramString, IGProSecurityResult paramIGProSecurityResult)
  {
    if ((paramInt == 0) && (QQGuildUtil.a(paramIGProSecurityResult)))
    {
      if (QQGuildChannelListSettingFragment.f(this.a) != null) {
        QQGuildChannelListSettingFragment.f(this.a).dismiss();
      }
      if (QQGuildChannelListSettingFragment.g(this.a) != null) {
        QQGuildChannelListSettingFragment.g(this.a).dismiss();
      }
    }
    else
    {
      if (QQGuildChannelListSettingFragment.f(this.a) != null) {
        QQGuildChannelListSettingFragment.f(this.a).dismiss();
      }
      if (QQGuildChannelListSettingFragment.g(this.a) != null) {
        QQGuildChannelListSettingFragment.g(this.a).dismiss();
      }
      QQGuildUtil.a(BaseApplication.getContext(), paramInt, BaseApplication.getContext().getString(2131890287), paramIGProSecurityResult);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.channel.QQGuildChannelListSettingFragment.8
 * JD-Core Version:    0.7.0.1
 */