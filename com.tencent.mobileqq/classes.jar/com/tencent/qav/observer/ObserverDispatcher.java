package com.tencent.qav.observer;

public class ObserverDispatcher
  extends FilterableObservable
{
  private static final Object a = new Object();
  private static ObserverDispatcher b;
  
  public static ObserverDispatcher b()
  {
    if (b == null) {
      synchronized (a)
      {
        if (b == null) {
          b = new ObserverDispatcher();
        }
      }
    }
    return b;
  }
  
  public void a()
  {
    super.a();
    b = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qav.observer.ObserverDispatcher
 * JD-Core Version:    0.7.0.1
 */