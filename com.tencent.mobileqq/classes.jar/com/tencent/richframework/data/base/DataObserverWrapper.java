package com.tencent.richframework.data.base;

import androidx.lifecycle.Observer;
import java.lang.ref.WeakReference;

public class DataObserverWrapper<T>
  implements Observer<T>
{
  private final WeakReference<Observer<T>> a;
  
  public DataObserverWrapper(Observer<T> paramObserver)
  {
    this.a = new WeakReference(paramObserver);
  }
  
  public void onChanged(T paramT)
  {
    Observer localObserver = (Observer)this.a.get();
    if (localObserver == null) {
      return;
    }
    localObserver.onChanged(paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.richframework.data.base.DataObserverWrapper
 * JD-Core Version:    0.7.0.1
 */