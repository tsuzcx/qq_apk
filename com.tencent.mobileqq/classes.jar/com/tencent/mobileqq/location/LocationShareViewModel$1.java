package com.tencent.mobileqq.location;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider.Factory;

final class LocationShareViewModel$1
  implements ViewModelProvider.Factory
{
  @NonNull
  public <T extends ViewModel> T create(@NonNull Class<T> paramClass)
  {
    return new LocationShareViewModel(new LocationShareRepository());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.LocationShareViewModel.1
 * JD-Core Version:    0.7.0.1
 */