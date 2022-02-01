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
    if (this == paramObject) {}
    do
    {
      do
      {
        return true;
        if (paramObject == null) {
          return false;
        }
        if (getClass() != paramObject.getClass()) {
          return false;
        }
        paramObject = (SynchronizedQueue)paramObject;
        if (this.list != null) {
          break;
        }
      } while (paramObject.list == null);
      return false;
    } while (this.list.equals(paramObject.list));
    return false;
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
  
  /* Error */
  public boolean offer(T paramT)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 23	rx/internal/util/SynchronizedQueue:size	I
    //   6: iconst_m1
    //   7: if_icmple +31 -> 38
    //   10: aload_0
    //   11: getfield 21	rx/internal/util/SynchronizedQueue:list	Ljava/util/LinkedList;
    //   14: invokevirtual 78	java/util/LinkedList:size	()I
    //   17: istore_2
    //   18: aload_0
    //   19: getfield 23	rx/internal/util/SynchronizedQueue:size	I
    //   22: istore_3
    //   23: iload_2
    //   24: iconst_1
    //   25: iadd
    //   26: iload_3
    //   27: if_icmple +11 -> 38
    //   30: iconst_0
    //   31: istore 4
    //   33: aload_0
    //   34: monitorexit
    //   35: iload 4
    //   37: ireturn
    //   38: aload_0
    //   39: getfield 21	rx/internal/util/SynchronizedQueue:list	Ljava/util/LinkedList;
    //   42: aload_1
    //   43: invokevirtual 80	java/util/LinkedList:offer	(Ljava/lang/Object;)Z
    //   46: istore 4
    //   48: goto -15 -> 33
    //   51: astore_1
    //   52: aload_0
    //   53: monitorexit
    //   54: aload_1
    //   55: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	56	0	this	SynchronizedQueue
    //   0	56	1	paramT	T
    //   17	9	2	i	int
    //   22	6	3	j	int
    //   31	16	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	23	51	finally
    //   38	48	51	finally
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rx.internal.util.SynchronizedQueue
 * JD-Core Version:    0.7.0.1
 */