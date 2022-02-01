package com.tencent.mobileqq.guild.setting.popup;

import android.text.TextUtils;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.guild.profilecard.main.ShowToastModel;
import com.tencent.mobileqq.guild.util.QQGuildUtil;

class GuildMainSettingDialogFragment$4
  implements Observer<ShowToastModel>
{
  GuildMainSettingDialogFragment$4(GuildMainSettingDialogFragment paramGuildMainSettingDialogFragment) {}
  
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
    QQGuildUtil.a(this.a.getContext(), paramShowToastModel.c(), paramShowToastModel.a(), paramShowToastModel.d());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.setting.popup.GuildMainSettingDialogFragment.4
 * JD-Core Version:    0.7.0.1
 */