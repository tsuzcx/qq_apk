package com.tencent.mobileqq.resourcesgrab;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider.Factory;

final class ResourceGrabViewModel$2
  implements ViewModelProvider.Factory
{
  @NonNull
  public <T extends ViewModel> T create(@NonNull Class<T> paramClass)
  {
    return new ResourceGrabViewModel(new ResourceGrabRepository());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.resourcesgrab.ResourceGrabViewModel.2
 * JD-Core Version:    0.7.0.1
 */