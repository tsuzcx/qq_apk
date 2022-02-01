package com.tencent.mobileqq.guild.util;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import java.util.concurrent.atomic.AtomicBoolean;

class SingleLiveEvent$1
  implements Observer<T>
{
  SingleLiveEvent$1(SingleLiveEvent paramSingleLiveEvent, Observer paramObserver) {}
  
  public void onChanged(@Nullable T paramT)
  {
    if (SingleLiveEvent.a(this.b).compareAndSet(true, false)) {
      this.a.onChanged(paramT);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.util.SingleLiveEvent.1
 * JD-Core Version:    0.7.0.1
 */