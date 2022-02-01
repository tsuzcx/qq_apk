package com.tencent.mobileqq.mvvm;

import androidx.lifecycle.ViewModel;

public abstract class BaseViewModel<T extends BaseRepository>
  extends ViewModel
{
  protected T z;
  
  public BaseViewModel(T paramT)
  {
    this.z = paramT;
  }
  
  protected void onCleared()
  {
    super.onCleared();
    BaseRepository localBaseRepository = this.z;
    if (localBaseRepository != null) {
      localBaseRepository.bN_();
    }
  }
  
  public T v()
  {
    return this.z;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mvvm.BaseViewModel
 * JD-Core Version:    0.7.0.1
 */