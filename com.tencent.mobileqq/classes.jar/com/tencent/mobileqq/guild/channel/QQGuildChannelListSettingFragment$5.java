package com.tencent.mobileqq.guild.channel;

import android.view.View;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class QQGuildChannelListSettingFragment$5
  implements ActionSheet.OnButtonClickListener
{
  QQGuildChannelListSettingFragment$5(QQGuildChannelListSettingFragment paramQQGuildChannelListSettingFragment, GuildChannelInfoUIData paramGuildChannelInfoUIData) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          return;
        }
        QQGuildChannelListSettingFragment.a(this.b, this.a);
        QQGuildChannelListSettingFragment.e(this.b).dismiss();
        return;
      }
      ((IQQGuildRouterApi)QRoute.api(IQQGuildRouterApi.class)).openGuildChannelModifyCategorySetting(this.b.getContext(), this.b.l(), QQGuildChannelListSettingFragment.d(this.b), this.a.b, this.a.e);
      QQGuildChannelListSettingFragment.e(this.b).dismiss();
      return;
    }
    ((IQQGuildRouterApi)QRoute.api(IQQGuildRouterApi.class)).openCreateGuildChannel(this.b.getContext(), this.b.l(), QQGuildChannelListSettingFragment.d(this.b), "list_setting", this.a.b, this.a.e);
    QQGuildChannelListSettingFragment.e(this.b).dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.channel.QQGuildChannelListSettingFragment.5
 * JD-Core Version:    0.7.0.1
 */