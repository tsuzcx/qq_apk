package com.tencent.qqlive.module.videoreport.utils;

import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.task.ThreadUtils;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ListenerMgr<T>
{
  private static boolean sIsDebug = false;
  private final ConcurrentLinkedQueue<WeakReference<T>> mListenerQueue = new ConcurrentLinkedQueue();
  
  public static void setDebug(boolean paramBoolean)
  {
    sIsDebug = paramBoolean;
  }
  
  private void throwRuntimeExceptionInMain(Throwable paramThrowable)
  {
    ThreadUtils.runOnUiThread(new ListenerMgr.1(this, paramThrowable));
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
    Object localObject1;
    synchronized (this.mListenerQueue)
    {
      if (this.mListenerQueue.size() > 0)
      {
        localObject1 = new ConcurrentLinkedQueue(this.mListenerQueue);
        if (localObject1 == null) {
          return;
        }
        try
        {
          localObject1 = ((ConcurrentLinkedQueue)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            ??? = ((WeakReference)((Iterator)localObject1).next()).get();
            if (??? != null)
            {
              try
              {
                paramINotifyCallback.onNotify(???);
              }
              catch (Throwable localThrowable)
              {
                Log.e("crash", localThrowable.toString());
              }
              if (sIsDebug) {
                throwRuntimeExceptionInMain(localThrowable);
              }
            }
          }
          return;
        }
        catch (Throwable paramINotifyCallback)
        {
          Log.e("crash", paramINotifyCallback.toString());
        }
      }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.utils.ListenerMgr
 * JD-Core Version:    0.7.0.1
 */