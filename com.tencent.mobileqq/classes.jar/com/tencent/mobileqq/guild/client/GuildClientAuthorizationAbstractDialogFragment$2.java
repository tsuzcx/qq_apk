package com.tencent.mobileqq.guild.client;

import androidx.lifecycle.Observer;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.profilecard.main.ShowToastModel;
import com.tencent.mobileqq.guild.util.QQGuildUtil;

class GuildClientAuthorizationAbstractDialogFragment$2
  implements Observer<ShowToastModel>
{
  GuildClientAuthorizationAbstractDialogFragment$2(GuildClientAuthorizationAbstractDialogFragment paramGuildClientAuthorizationAbstractDialogFragment, QBaseActivity paramQBaseActivity) {}
  
  public void a(ShowToastModel paramShowToastModel)
  {
    if (paramShowToastModel.b())
    {
      if (this.b.c.c() == 2)
      {
        paramShowToastModel = this.a;
        QQGuildUtil.c(paramShowToastModel, paramShowToastModel.getString(2131890232));
      }
    }
    else
    {
      if (paramShowToastModel.c() == -952354)
      {
        QQGuildUtil.c(paramShowToastModel.a());
        this.b.dismiss();
        return;
      }
      if (this.b.c.c() == 2)
      {
        QQGuildUtil.c(this.a.getString(2131890354));
        return;
      }
      QQGuildUtil.c(this.a.getString(2131890355));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.client.GuildClientAuthorizationAbstractDialogFragment.2
 * JD-Core Version:    0.7.0.1
 */