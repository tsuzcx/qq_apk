package com.tencent.mobileqq.guild.profilecard.manage;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider.Factory;
import com.tencent.mobileqq.guild.setting.QQGuildInfoRepository;

final class GuildProfileManageViewModel$1
  implements ViewModelProvider.Factory
{
  @NonNull
  public <T extends ViewModel> T create(@NonNull Class<T> paramClass)
  {
    return new GuildProfileManageViewModel(new QQGuildInfoRepository());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.profilecard.manage.GuildProfileManageViewModel.1
 * JD-Core Version:    0.7.0.1
 */