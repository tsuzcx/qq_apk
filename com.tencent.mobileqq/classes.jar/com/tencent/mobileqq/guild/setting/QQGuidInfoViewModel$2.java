package com.tencent.mobileqq.guild.setting;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider.Factory;

final class QQGuidInfoViewModel$2
  implements ViewModelProvider.Factory
{
  @NonNull
  public <T extends ViewModel> T create(@NonNull Class<T> paramClass)
  {
    return new QQGuidInfoViewModel(new QQGuildInfoRepository());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.setting.QQGuidInfoViewModel.2
 * JD-Core Version:    0.7.0.1
 */