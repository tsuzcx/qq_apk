package com.tencent.mobileqq.guild.profilecard.baseprofile.card;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider.Factory;
import com.tencent.mobileqq.guild.setting.QQGuildInfoRepository;

final class GuildProfileCardViewModel$1
  implements ViewModelProvider.Factory
{
  @NonNull
  public <T extends ViewModel> T create(@NonNull Class<T> paramClass)
  {
    return new GuildProfileCardViewModel(new QQGuildInfoRepository());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.profilecard.baseprofile.card.GuildProfileCardViewModel.1
 * JD-Core Version:    0.7.0.1
 */