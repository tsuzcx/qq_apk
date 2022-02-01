package rx.internal.util;

import java.io.PrintStream;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;
import rx.Subscription;
import rx.functions.Func1;

public final class IndexedRingBuffer<E>
  implements Subscription
{
  private static final ObjectPool<IndexedRingBuffer<?>> POOL = new IndexedRingBuffer.1();
  static final int SIZE = _size;
  static int _size = 256;
  private final IndexedRingBuffer.ElementSection<E> elements = new IndexedRingBuffer.ElementSection();
  final AtomicInteger index = new AtomicInteger();
  private final IndexedRingBuffer.IndexSection removed = new IndexedRingBuffer.IndexSection();
  final AtomicInteger removedIndex = new AtomicInteger();
  
  static
  {
    if (PlatformDependent.isAndroid()) {
      _size = 8;
    }
    String str = System.getProperty("rx.indexed-ring-buffer.size");
    if (str != null) {
      try
      {
        _size = Integer.parseInt(str);
      }
      catch (Exception localException)
      {
        PrintStream localPrintStream = System.err;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Failed to set 'rx.indexed-ring-buffer.size' with value ");
        localStringBuilder.append(str);
        localStringBuilder.append(" => ");
        localStringBuilder.append(localException.getMessage());
        localPrintStream.println(localStringBuilder.toString());
      }
    }
  }
  
  private int forEach(Func1<? super E, Boolean> paramFunc1, int paramInt1, int paramInt2)
  {
    int k = this.index.get();
    IndexedRingBuffer.ElementSection localElementSection = this.elements;
    int j;
    int i;
    if (paramInt1 >= SIZE)
    {
      localElementSection = getElementSection(paramInt1);
      j = SIZE;
      i = paramInt1;
      j = paramInt1 % j;
      paramInt1 = i;
      i = j;
    }
    else
    {
      j = paramInt1;
      i = paramInt1;
      paramInt1 = j;
    }
    for (;;)
    {
      j = paramInt1;
      if (localElementSection == null) {
        break;
      }
      while (i < SIZE)
      {
        j = paramInt1;
        if (paramInt1 >= k) {
          break label165;
        }
        if (paramInt1 >= paramInt2) {
          return paramInt1;
        }
        Object localObject = localElementSection.array.get(i);
        if ((localObject != null) && (!((Boolean)paramFunc1.call(localObject)).booleanValue())) {
          return paramInt1;
        }
        i += 1;
        paramInt1 += 1;
      }
      localElementSection = (IndexedRingBuffer.ElementSection)localElementSection.next.get();
      i = 0;
    }
    label165:
    return j;
  }
  
  private IndexedRingBuffer.ElementSection<E> getElementSection(int paramInt)
  {
    int i = SIZE;
    if (paramInt < i) {
      return this.elements;
    }
    i = paramInt / i;
    IndexedRingBuffer.ElementSection localElementSection = this.elements;
    paramInt = 0;
    while (paramInt < i)
    {
      localElementSection = localElementSection.getNext();
      paramInt += 1;
    }
    return localElementSection;
  }
  
  private int getIndexForAdd()
  {
    try
    {
      int i = getIndexFromPreviouslyRemoved();
      int j;
      if (i >= 0)
      {
        if (i < SIZE)
        {
          i = this.removed.getAndSet(i, -1);
        }
        else
        {
          j = SIZE;
          i = getIndexSection(i).getAndSet(i % j, -1);
        }
        j = i;
        if (i == this.index.get())
        {
          this.index.getAndIncrement();
          j = i;
        }
      }
      else
      {
        j = this.index.getAndIncrement();
      }
      return j;
    }
    finally {}
  }
  
  private int getIndexFromPreviouslyRemoved()
  {
    try
    {
      int j;
      boolean bool;
      do
      {
        int i = this.removedIndex.get();
        if (i <= 0) {
          break;
        }
        AtomicInteger localAtomicInteger = this.removedIndex;
        j = i - 1;
        bool = localAtomicInteger.compareAndSet(i, j);
      } while (!bool);
      return j;
      return -1;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  private IndexedRingBuffer.IndexSection getIndexSection(int paramInt)
  {
    int i = SIZE;
    if (paramInt < i) {
      return this.removed;
    }
    i = paramInt / i;
    IndexedRingBuffer.IndexSection localIndexSection = this.removed;
    paramInt = 0;
    while (paramInt < i)
    {
      localIndexSection = localIndexSection.getNext();
      paramInt += 1;
    }
    return localIndexSection;
  }
  
  public static <T> IndexedRingBuffer<T> getInstance()
  {
    return (IndexedRingBuffer)POOL.borrowObject();
  }
  
  private void pushRemovedIndex(int paramInt)
  {
    try
    {
      int i = this.removedIndex.getAndIncrement();
      if (i < SIZE)
      {
        this.removed.set(i, paramInt);
      }
      else
      {
        int j = SIZE;
        getIndexSection(i).set(i % j, paramInt);
      }
      return;
    }
    finally {}
  }
  
  public int add(E paramE)
  {
    int i = getIndexForAdd();
    int j = SIZE;
    if (i < j)
    {
      this.elements.array.set(i, paramE);
      return i;
    }
    getElementSection(i).array.set(i % j, paramE);
    return i;
  }
  
  public int forEach(Func1<? super E, Boolean> paramFunc1)
  {
    return forEach(paramFunc1, 0);
  }
  
  public int forEach(Func1<? super E, Boolean> paramFunc1, int paramInt)
  {
    int i = forEach(paramFunc1, paramInt, this.index.get());
    if ((paramInt > 0) && (i == this.index.get())) {
      return forEach(paramFunc1, 0, paramInt);
    }
    paramInt = i;
    if (i == this.index.get()) {
      paramInt = 0;
    }
    return paramInt;
  }
  
  public boolean isUnsubscribed()
  {
    return false;
  }
  
  public void releaseToPool()
  {
    int k = this.index.get();
    IndexedRingBuffer.ElementSection localElementSection = this.elements;
    int i = 0;
    while (localElementSection != null)
    {
      int j = 0;
      while (j < SIZE)
      {
        if (i >= k) {
          break label75;
        }
        localElementSection.array.set(j, null);
        j += 1;
        i += 1;
      }
      localElementSection = (IndexedRingBuffer.ElementSection)localElementSection.next.get();
    }
    label75:
    this.index.set(0);
    this.removedIndex.set(0);
    POOL.returnObject(this);
  }
  
  public E remove(int paramInt)
  {
    int i = SIZE;
    Object localObject;
    if (paramInt < i) {
      localObject = this.elements.array.getAndSet(paramInt, null);
    } else {
      localObject = getElementSection(paramInt).array.getAndSet(paramInt % i, null);
    }
    pushRemovedIndex(paramInt);
    return localObject;
  }
  
  public void unsubscribe()
  {
    releaseToPool();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.internal.util.IndexedRingBuffer
 * JD-Core Version:    0.7.0.1
 */