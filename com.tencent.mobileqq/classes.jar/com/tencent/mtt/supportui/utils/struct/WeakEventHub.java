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
    for (;;)
    {
      Object localObject;
      synchronized (this.a)
      {
        Iterator localIterator = this.a.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (WeakReference)localIterator.next();
        if (localObject == null) {
          continue;
        }
        localObject = ((WeakReference)localObject).get();
        if (localObject == null) {
          localIterator.remove();
        }
      }
      localIterable.add(localObject);
    }
    return localIterable;
  }
  
  public void registerListener(T paramT)
  {
    if (paramT == null) {
      return;
    }
    for (;;)
    {
      Object localObject;
      synchronized (this.a)
      {
        Iterator localIterator = this.a.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = ((WeakReference)localIterator.next()).get();
        if (localObject == null) {
          localIterator.remove();
        }
      }
      if (localObject == paramT) {
        return;
      }
    }
    this.a.add(new WeakReference(paramT));
  }
  
  public int size()
  {
    return this.a.size();
  }
  
  public void unregisterListener(T paramT)
  {
    ArrayList localArrayList = this.a;
    if (paramT != null) {
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
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.supportui.utils.struct.WeakEventHub
 * JD-Core Version:    0.7.0.1
 */