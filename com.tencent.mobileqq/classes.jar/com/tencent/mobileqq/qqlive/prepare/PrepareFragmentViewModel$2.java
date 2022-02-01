package com.tencent.mobileqq.qqlive.prepare;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider.Factory;

final class PrepareFragmentViewModel$2
  implements ViewModelProvider.Factory
{
  @NonNull
  public <T extends ViewModel> T create(@NonNull Class<T> paramClass)
  {
    return new PrepareFragmentViewModel(new PrepareDataRepository());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.prepare.PrepareFragmentViewModel.2
 * JD-Core Version:    0.7.0.1
 */