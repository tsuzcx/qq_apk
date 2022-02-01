package com.tencent.mobileqq.guild.client;

import androidx.lifecycle.Observer;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.profilecard.main.ShowToastModel;
import com.tencent.mobileqq.guild.util.QQGuildUtil;

class GuildClientTitleDisplaySettingFragment$4
  implements Observer<ShowToastModel>
{
  GuildClientTitleDisplaySettingFragment$4(GuildClientTitleDisplaySettingFragment paramGuildClientTitleDisplaySettingFragment) {}
  
  public void a(ShowToastModel paramShowToastModel)
  {
    if (paramShowToastModel.c() == -952356)
    {
      QQGuildUtil.c(this.a.getQBaseActivity().getString(2131890358));
      return;
    }
    if (paramShowToastModel.c() == -952358) {
      QQGuildUtil.c(this.a.getQBaseActivity().getString(2131890356));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.client.GuildClientTitleDisplaySettingFragment.4
 * JD-Core Version:    0.7.0.1
 */