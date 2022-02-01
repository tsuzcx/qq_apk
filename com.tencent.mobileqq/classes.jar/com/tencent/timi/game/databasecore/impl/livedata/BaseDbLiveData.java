package com.tencent.timi.game.databasecore.impl.livedata;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class BaseDbLiveData<TableModel, ObserverType>
  extends LiveData<LoadDataWrapper<ObserverType>>
  implements LifecycleEventObserver, IDbLiveData<ObserverType>
{
  private AtomicInteger a = new AtomicInteger(0);
  private AtomicBoolean b = new AtomicBoolean(false);
  private DbDeleteLiveData c = new DbDeleteLiveData();
  private List<Observer<? super LoadDataWrapper<ObserverType>>> d = new ArrayList();
  private IDBObserver e = new BaseDbLiveData.1(this);
  
  private void b()
  {
    if (!this.b.get())
    {
      a(this.e);
      this.b.set(true);
    }
  }
  
  private void c()
  {
    if (this.b.get())
    {
      b(this.e);
      this.b.set(false);
    }
  }
  
  protected abstract void a(IDBObserver<TableModel> paramIDBObserver);
  
  public void a(LoadDataWrapper<ObserverType> paramLoadDataWrapper)
  {
    super.postValue(paramLoadDataWrapper);
  }
  
  protected abstract void b(IDBObserver<TableModel> paramIDBObserver);
  
  public void b(LoadDataWrapper<ObserverType> paramLoadDataWrapper)
  {
    super.setValue(paramLoadDataWrapper);
  }
  
  public void observe(@NonNull LifecycleOwner paramLifecycleOwner, @NonNull Observer<? super LoadDataWrapper<ObserverType>> paramObserver)
  {
    paramLifecycleOwner.getLifecycle().addObserver(this);
    super.observe(paramLifecycleOwner, paramObserver);
  }
  
  public void observeForever(@NonNull Observer<? super LoadDataWrapper<ObserverType>> paramObserver)
  {
    super.observeForever(paramObserver);
    this.a.incrementAndGet();
    this.d.add(paramObserver);
  }
  
  protected void onActive()
  {
    super.onActive();
    b();
  }
  
  protected void onInactive()
  {
    super.onInactive();
  }
  
  public void onStateChanged(@NonNull LifecycleOwner paramLifecycleOwner, @NonNull Lifecycle.Event paramEvent)
  {
    int i = BaseDbLiveData.2.a[paramEvent.ordinal()];
    if (i != 1)
    {
      if (i == 2) {}
    }
    else {
      b();
    }
    c();
  }
  
  public void removeObserver(@NonNull Observer<? super LoadDataWrapper<ObserverType>> paramObserver)
  {
    super.removeObserver(paramObserver);
    if (this.d.remove(paramObserver)) {
      this.a.decrementAndGet();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.databasecore.impl.livedata.BaseDbLiveData
 * JD-Core Version:    0.7.0.1
 */