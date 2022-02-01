package com.tencent.mobileqq.guild.profilecard.manage;

import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.guild.profilecard.main.ShowToastModel;
import com.tencent.mobileqq.guild.util.QQGuildUtil;

class GuildProfileManageComponent$1
  implements Observer<ShowToastModel>
{
  GuildProfileManageComponent$1(GuildProfileManageComponent paramGuildProfileManageComponent) {}
  
  public void a(ShowToastModel paramShowToastModel)
  {
    if (TextUtils.isEmpty(paramShowToastModel.a())) {
      return;
    }
    if (paramShowToastModel.b())
    {
      QQGuildUtil.c(paramShowToastModel.a());
      return;
    }
    QQGuildUtil.a(GuildProfileManageComponent.access$000(this.a).getContext(), paramShowToastModel.c(), paramShowToastModel.a(), paramShowToastModel.d());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.profilecard.manage.GuildProfileManageComponent.1
 * JD-Core Version:    0.7.0.1
 */