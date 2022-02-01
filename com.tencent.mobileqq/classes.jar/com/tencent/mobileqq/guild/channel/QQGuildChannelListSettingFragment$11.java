package com.tencent.mobileqq.guild.channel;

import android.view.View;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class QQGuildChannelListSettingFragment$11
  implements ActionSheet.OnButtonClickListener
{
  QQGuildChannelListSettingFragment$11(QQGuildChannelListSettingFragment paramQQGuildChannelListSettingFragment) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return;
      }
      this.a.i();
      QQGuildChannelListSettingFragment.i(this.a).dismiss();
      return;
    }
    ((IQQGuildRouterApi)QRoute.api(IQQGuildRouterApi.class)).openGuildChannelCategorySort(this.a.getContext(), this.a.l(), QQGuildChannelListSettingFragment.d(this.a), 257);
    QQGuildChannelListSettingFragment.i(this.a).dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.channel.QQGuildChannelListSettingFragment.11
 * JD-Core Version:    0.7.0.1
 */