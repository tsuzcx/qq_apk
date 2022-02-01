package com.tencent.mobileqq.qqgift.business.qqlive;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider.Factory;
import com.tencent.mobileqq.qqgift.mvvm.business.QQGiftPanelRepository;

final class QQGiftPanelViewModelForLive$4
  implements ViewModelProvider.Factory
{
  @NonNull
  public <T extends ViewModel> T create(@NonNull Class<T> paramClass)
  {
    return new QQGiftPanelViewModelForLive(new QQGiftPanelRepository());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.business.qqlive.QQGiftPanelViewModelForLive.4
 * JD-Core Version:    0.7.0.1
 */