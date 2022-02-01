package com.tencent.mobileqq.guild.client;

import androidx.lifecycle.Observer;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.profilecard.main.ShowToastModel;
import com.tencent.mobileqq.guild.util.QQGuildUtil;

class GuildClientManageFragment$10
  implements Observer<ShowToastModel>
{
  GuildClientManageFragment$10(GuildClientManageFragment paramGuildClientManageFragment) {}
  
  public void a(ShowToastModel paramShowToastModel)
  {
    if (paramShowToastModel.c() == -952354)
    {
      QQGuildUtil.c(paramShowToastModel.a());
      return;
    }
    if (!paramShowToastModel.b()) {
      QQGuildUtil.c(this.a.getQBaseActivity().getString(2131890355));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.client.GuildClientManageFragment.10
 * JD-Core Version:    0.7.0.1
 */