package com.tencent.qav.observer;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class FilterableObservable
{
  private final List<FilterableObserver> a = new Vector();
  private final List<FilterableObserver> b = new Vector();
  private Handler c;
  private Handler d;
  
  FilterableObservable()
  {
    if (this.c == null) {
      this.c = new Handler(Looper.getMainLooper());
    }
    if (this.d == null)
    {
      HandlerThread localHandlerThread = new HandlerThread("FilterableObservable-bg-thread");
      localHandlerThread.start();
      this.d = new Handler(localHandlerThread.getLooper());
    }
  }
  
  private void a(FilterableObserver paramFilterableObserver, Handler paramHandler, int paramInt, Object... paramVarArgs)
  {
    paramHandler.post(new FilterableObservable.1(this, paramFilterableObserver, paramInt, paramVarArgs));
  }
  
  public void a()
  {
    try
    {
      this.a.clear();
      this.b.clear();
      if (this.d != null) {
        this.d.getLooper().quit();
      }
      this.c = null;
      this.d = null;
      return;
    }
    finally {}
  }
  
  public void a(FilterableObserver paramFilterableObserver)
  {
    if (paramFilterableObserver != null) {}
    try
    {
      this.a.remove(paramFilterableObserver);
      this.b.remove(paramFilterableObserver);
    }
    finally {}
  }
  
  public void a(FilterableObserver paramFilterableObserver, boolean paramBoolean)
  {
    if (paramBoolean) {}
    try
    {
      this.b.add(paramFilterableObserver);
      break label31;
      this.a.add(paramFilterableObserver);
      label31:
      return;
    }
    finally {}
  }
  
  public void a(Class<? extends FilterableObserver> paramClass, int paramInt, Object... paramVarArgs)
  {
    synchronized (this.a)
    {
      Iterator localIterator = this.a.iterator();
      FilterableObserver localFilterableObserver;
      while (localIterator.hasNext())
      {
        localFilterableObserver = (FilterableObserver)localIterator.next();
        if ((paramClass != null) && (localFilterableObserver != null) && (paramClass.isAssignableFrom(localFilterableObserver.getClass()))) {
          a(localFilterableObserver, this.c, paramInt, paramVarArgs);
        }
      }
      synchronized (this.b)
      {
        localIterator = this.b.iterator();
        while (localIterator.hasNext())
        {
          localFilterableObserver = (FilterableObserver)localIterator.next();
          if ((paramClass != null) && (localFilterableObserver != null) && (paramClass.isAssignableFrom(localFilterableObserver.getClass()))) {
            a(localFilterableObserver, this.d, paramInt, paramVarArgs);
          }
        }
        return;
      }
    }
    for (;;)
    {
      throw paramClass;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qav.observer.FilterableObservable
 * JD-Core Version:    0.7.0.1
 */