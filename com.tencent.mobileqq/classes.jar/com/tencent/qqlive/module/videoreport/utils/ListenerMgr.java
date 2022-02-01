package com.tencent.qqlive.module.videoreport.utils;

import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ListenerMgr<T>
{
  private static boolean isDebug = false;
  private final ConcurrentLinkedQueue<WeakReference<T>> mListenerQueue = new ConcurrentLinkedQueue();
  
  public static void setDebug(boolean paramBoolean)
  {
    isDebug = paramBoolean;
  }
  
  public void clear()
  {
    synchronized (this.mListenerQueue)
    {
      this.mListenerQueue.clear();
      return;
    }
  }
  
  public void register(T paramT)
  {
    if (paramT == null) {
      return;
    }
    ConcurrentLinkedQueue localConcurrentLinkedQueue = this.mListenerQueue;
    int i = 0;
    try
    {
      Iterator localIterator = this.mListenerQueue.iterator();
      while (localIterator.hasNext())
      {
        localObject = ((WeakReference)localIterator.next()).get();
        if (localObject != null) {
          break label99;
        }
        localIterator.remove();
      }
      if (i == 0)
      {
        paramT = new WeakReference(paramT);
        this.mListenerQueue.add(paramT);
      }
      return;
    }
    finally
    {
      for (;;)
      {
        Object localObject;
        for (;;)
        {
          throw paramT;
        }
        label99:
        if (localObject == paramT) {
          i = 1;
        }
      }
    }
  }
  
  public int size()
  {
    synchronized (this.mListenerQueue)
    {
      int i = this.mListenerQueue.size();
      return i;
    }
  }
  
  public void startNotify(ListenerMgr.INotifyCallback<T> paramINotifyCallback)
  {
    for (;;)
    {
      synchronized (this.mListenerQueue)
      {
        if (this.mListenerQueue.size() > 0)
        {
          localObject1 = new ConcurrentLinkedQueue(this.mListenerQueue);
          if (localObject1 == null) {}
        }
      }
      Object localObject1 = null;
    }
  }
  
  public void unregister(T paramT)
  {
    if (paramT == null) {
      return;
    }
    synchronized (this.mListenerQueue)
    {
      Iterator localIterator = this.mListenerQueue.iterator();
      while (localIterator.hasNext()) {
        if (((WeakReference)localIterator.next()).get() == paramT)
        {
          localIterator.remove();
          return;
        }
      }
      return;
    }
    for (;;)
    {
      throw paramT;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.utils.ListenerMgr
 * JD-Core Version:    0.7.0.1
 */