package com.tencent.mobileqq.kandian.repo.feeds.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Observable<T>
{
  private T a;
  private List<Observer<T>> b = new ArrayList();
  
  public Observable(T paramT)
  {
    this.a = paramT;
  }
  
  public T a()
  {
    return this.a;
  }
  
  public void a(Observer<T> paramObserver)
  {
    try
    {
      if (!this.b.contains(paramObserver)) {
        this.b.add(paramObserver);
      }
      return;
    }
    finally
    {
      paramObserver = finally;
      throw paramObserver;
    }
  }
  
  public void a(T paramT)
  {
    this.a = paramT;
    b();
  }
  
  public void b()
  {
    try
    {
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext()) {
        ((Observer)localIterator.next()).a(this);
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void b(Observer<T> paramObserver)
  {
    try
    {
      this.b.remove(paramObserver);
      return;
    }
    finally
    {
      paramObserver = finally;
      throw paramObserver;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.entity.Observable
 * JD-Core Version:    0.7.0.1
 */