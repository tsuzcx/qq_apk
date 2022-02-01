package com.tencent.qav.observer;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class FilterableObservable
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  private final List<FilterableObserver> jdField_a_of_type_JavaUtilList = new Vector();
  private Handler jdField_b_of_type_AndroidOsHandler;
  private final List<FilterableObserver> jdField_b_of_type_JavaUtilList = new Vector();
  
  FilterableObservable()
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    }
    if (this.jdField_b_of_type_AndroidOsHandler == null)
    {
      HandlerThread localHandlerThread = new HandlerThread("FilterableObservable-bg-thread");
      localHandlerThread.start();
      this.jdField_b_of_type_AndroidOsHandler = new Handler(localHandlerThread.getLooper());
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
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_b_of_type_JavaUtilList.clear();
      if (this.jdField_b_of_type_AndroidOsHandler != null) {
        this.jdField_b_of_type_AndroidOsHandler.getLooper().quit();
      }
      this.jdField_a_of_type_AndroidOsHandler = null;
      this.jdField_b_of_type_AndroidOsHandler = null;
      return;
    }
    finally {}
  }
  
  public void a(FilterableObserver paramFilterableObserver)
  {
    if (paramFilterableObserver != null) {}
    try
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramFilterableObserver);
      this.jdField_b_of_type_JavaUtilList.remove(paramFilterableObserver);
    }
    finally {}
  }
  
  public void a(FilterableObserver paramFilterableObserver, boolean paramBoolean)
  {
    if (paramBoolean) {}
    try
    {
      this.jdField_b_of_type_JavaUtilList.add(paramFilterableObserver);
      break label31;
      this.jdField_a_of_type_JavaUtilList.add(paramFilterableObserver);
      label31:
      return;
    }
    finally {}
  }
  
  public void a(Class<? extends FilterableObserver> paramClass, int paramInt, Object... paramVarArgs)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      FilterableObserver localFilterableObserver;
      while (localIterator.hasNext())
      {
        localFilterableObserver = (FilterableObserver)localIterator.next();
        if ((paramClass != null) && (localFilterableObserver != null) && (paramClass.isAssignableFrom(localFilterableObserver.getClass()))) {
          a(localFilterableObserver, this.jdField_a_of_type_AndroidOsHandler, paramInt, paramVarArgs);
        }
      }
      synchronized (this.jdField_b_of_type_JavaUtilList)
      {
        localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext())
        {
          localFilterableObserver = (FilterableObserver)localIterator.next();
          if ((paramClass != null) && (localFilterableObserver != null) && (paramClass.isAssignableFrom(localFilterableObserver.getClass()))) {
            a(localFilterableObserver, this.jdField_b_of_type_AndroidOsHandler, paramInt, paramVarArgs);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qav.observer.FilterableObservable
 * JD-Core Version:    0.7.0.1
 */