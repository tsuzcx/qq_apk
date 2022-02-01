package com.tencent.mobileqq.mvvm;

import androidx.lifecycle.ViewModel;

public abstract class BaseViewModel<T extends BaseRepository>
  extends ViewModel
{
  protected T a;
  
  public BaseViewModel(T paramT)
  {
    this.a = paramT;
  }
  
  protected void onCleared()
  {
    super.onCleared();
    BaseRepository localBaseRepository = this.a;
    if (localBaseRepository != null) {
      localBaseRepository.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.mvvm.BaseViewModel
 * JD-Core Version:    0.7.0.1
 */