package com.tencent.mobileqq.guild.client;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider.Factory;
import com.tencent.mobileqq.guild.setting.QQGuildInfoRepository;

final class GuildClientManageViewModel$9
  implements ViewModelProvider.Factory
{
  @NonNull
  public <T extends ViewModel> T create(@NonNull Class<T> paramClass)
  {
    return new GuildClientManageViewModel(new QQGuildInfoRepository());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.client.GuildClientManageViewModel.9
 * JD-Core Version:    0.7.0.1
 */