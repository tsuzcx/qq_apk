package com.tencent.mobileqq.guild.base;

import com.tencent.mobileqq.guild.util.SingleLiveEvent;
import com.tencent.mobileqq.mvvm.BaseRepository;
import com.tencent.mobileqq.mvvm.BaseViewModel;

public abstract class BaseGuildViewModel<T extends BaseRepository>
  extends BaseViewModel<T>
{
  public SingleLiveEvent<BaseGuildViewModel.ToastEvent> a = new SingleLiveEvent();
  
  public BaseGuildViewModel(T paramT)
  {
    super(paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.base.BaseGuildViewModel
 * JD-Core Version:    0.7.0.1
 */