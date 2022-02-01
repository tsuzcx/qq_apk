package com.tencent.mtt.supportui.utils.struct;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public final class WeakEventHub<T>
{
  private final ArrayList<WeakReference<T>> a = new ArrayList();
  
  public Iterable<T> getNotifyListeners()
  {
    ArrayList localArrayList2 = new ArrayList(this.a.size());
    synchronized (this.a)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (WeakReference)localIterator.next();
        if (localObject2 != null)
        {
          localObject2 = ((WeakReference)localObject2).get();
          if (localObject2 == null) {
            localIterator.remove();
          } else {
            localArrayList2.add(localObject2);
          }
        }
      }
      return localArrayList2;
    }
    for (;;)
    {
      throw localObject1;
    }
  }
  
  public void registerListener(T paramT)
  {
    if (paramT == null) {
      return;
    }
    synchronized (this.a)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = ((WeakReference)localIterator.next()).get();
        if (localObject == null) {
          localIterator.remove();
        } else if (localObject == paramT) {
          return;
        }
      }
      this.a.add(new WeakReference(paramT));
      return;
    }
    for (;;)
    {
      throw paramT;
    }
  }
  
  public int size()
  {
    return this.a.size();
  }
  
  public void unregisterListener(T paramT)
  {
    ArrayList localArrayList = this.a;
    if (paramT != null) {}
    try
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (WeakReference)localIterator.next();
        if (localObject != null)
        {
          localObject = ((WeakReference)localObject).get();
          if ((localObject == null) || (localObject == paramT)) {
            localIterator.remove();
          }
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramT;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.supportui.utils.struct.WeakEventHub
 * JD-Core Version:    0.7.0.1
 */