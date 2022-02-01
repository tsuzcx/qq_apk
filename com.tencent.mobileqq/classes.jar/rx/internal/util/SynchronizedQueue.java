package rx.internal.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class SynchronizedQueue<T>
  implements Queue<T>
{
  private final LinkedList<T> list = new LinkedList();
  private final int size;
  
  public SynchronizedQueue()
  {
    this.size = -1;
  }
  
  public SynchronizedQueue(int paramInt)
  {
    this.size = paramInt;
  }
  
  public boolean add(T paramT)
  {
    try
    {
      boolean bool = this.list.add(paramT);
      return bool;
    }
    finally
    {
      paramT = finally;
      throw paramT;
    }
  }
  
  public boolean addAll(Collection<? extends T> paramCollection)
  {
    try
    {
      boolean bool = this.list.addAll(paramCollection);
      return bool;
    }
    finally
    {
      paramCollection = finally;
      throw paramCollection;
    }
  }
  
  public void clear()
  {
    try
    {
      this.list.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public Object clone()
  {
    try
    {
      SynchronizedQueue localSynchronizedQueue = new SynchronizedQueue(this.size);
      localSynchronizedQueue.addAll(this.list);
      return localSynchronizedQueue;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean contains(Object paramObject)
  {
    try
    {
      boolean bool = this.list.contains(paramObject);
      return bool;
    }
    finally
    {
      paramObject = finally;
      throw paramObject;
    }
  }
  
  public boolean containsAll(Collection<?> paramCollection)
  {
    try
    {
      boolean bool = this.list.containsAll(paramCollection);
      return bool;
    }
    finally
    {
      paramCollection = finally;
      throw paramCollection;
    }
  }
  
  public T element()
  {
    try
    {
      Object localObject1 = this.list.element();
      return localObject1;
    }
    finally
    {
      localObject2 = finally;
      throw localObject2;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if (getClass() != paramObject.getClass()) {
      return false;
    }
    paramObject = (SynchronizedQueue)paramObject;
    LinkedList localLinkedList = this.list;
    if (localLinkedList == null)
    {
      if (paramObject.list != null) {
        return false;
      }
    }
    else if (!localLinkedList.equals(paramObject.list)) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    return this.list.hashCode();
  }
  
  public boolean isEmpty()
  {
    try
    {
      boolean bool = this.list.isEmpty();
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public Iterator<T> iterator()
  {
    try
    {
      Iterator localIterator = this.list.iterator();
      return localIterator;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean offer(T paramT)
  {
    try
    {
      if (this.size > -1)
      {
        int i = this.list.size();
        int j = this.size;
        if (i + 1 > j) {
          return false;
        }
      }
      boolean bool = this.list.offer(paramT);
      return bool;
    }
    finally {}
  }
  
  public T peek()
  {
    try
    {
      Object localObject1 = this.list.peek();
      return localObject1;
    }
    finally
    {
      localObject2 = finally;
      throw localObject2;
    }
  }
  
  public T poll()
  {
    try
    {
      Object localObject1 = this.list.poll();
      return localObject1;
    }
    finally
    {
      localObject2 = finally;
      throw localObject2;
    }
  }
  
  public T remove()
  {
    try
    {
      Object localObject1 = this.list.remove();
      return localObject1;
    }
    finally
    {
      localObject2 = finally;
      throw localObject2;
    }
  }
  
  public boolean remove(Object paramObject)
  {
    try
    {
      boolean bool = this.list.remove(paramObject);
      return bool;
    }
    finally
    {
      paramObject = finally;
      throw paramObject;
    }
  }
  
  public boolean removeAll(Collection<?> paramCollection)
  {
    try
    {
      boolean bool = this.list.removeAll(paramCollection);
      return bool;
    }
    finally
    {
      paramCollection = finally;
      throw paramCollection;
    }
  }
  
  public boolean retainAll(Collection<?> paramCollection)
  {
    try
    {
      boolean bool = this.list.retainAll(paramCollection);
      return bool;
    }
    finally
    {
      paramCollection = finally;
      throw paramCollection;
    }
  }
  
  public int size()
  {
    try
    {
      int i = this.list.size();
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public Object[] toArray()
  {
    try
    {
      Object[] arrayOfObject = this.list.toArray();
      return arrayOfObject;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public <R> R[] toArray(R[] paramArrayOfR)
  {
    try
    {
      paramArrayOfR = this.list.toArray(paramArrayOfR);
      return paramArrayOfR;
    }
    finally
    {
      paramArrayOfR = finally;
      throw paramArrayOfR;
    }
  }
  
  public String toString()
  {
    try
    {
      String str = this.list.toString();
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.internal.util.SynchronizedQueue
 * JD-Core Version:    0.7.0.1
 */