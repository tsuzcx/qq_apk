package com.tencent.mobileqq.guild.util;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import java.util.concurrent.atomic.AtomicBoolean;

public class SingleLiveEvent<T>
  extends MutableLiveData<T>
{
  private final AtomicBoolean a = new AtomicBoolean(false);
  
  public void observe(@NonNull LifecycleOwner paramLifecycleOwner, @NonNull Observer<? super T> paramObserver)
  {
    super.observe(paramLifecycleOwner, new SingleLiveEvent.1(this, paramObserver));
  }
  
  @MainThread
  public void setValue(@Nullable T paramT)
  {
    this.a.set(true);
    super.setValue(paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.util.SingleLiveEvent
 * JD-Core Version:    0.7.0.1
 */