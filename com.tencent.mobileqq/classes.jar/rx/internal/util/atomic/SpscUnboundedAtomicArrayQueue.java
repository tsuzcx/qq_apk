package rx.internal.util.atomic;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import rx.internal.util.unsafe.Pow2;

public final class SpscUnboundedAtomicArrayQueue<T>
  implements Queue<T>
{
  static final AtomicLongFieldUpdater<SpscUnboundedAtomicArrayQueue> CONSUMER_INDEX = AtomicLongFieldUpdater.newUpdater(SpscUnboundedAtomicArrayQueue.class, "consumerIndex");
  private static final Object HAS_NEXT = new Object();
  static final int MAX_LOOK_AHEAD_STEP = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
  static final AtomicLongFieldUpdater<SpscUnboundedAtomicArrayQueue> PRODUCER_INDEX = AtomicLongFieldUpdater.newUpdater(SpscUnboundedAtomicArrayQueue.class, "producerIndex");
  protected AtomicReferenceArray<Object> consumerBuffer;
  protected volatile long consumerIndex;
  protected int consumerMask;
  protected AtomicReferenceArray<Object> producerBuffer;
  protected volatile long producerIndex;
  protected long producerLookAhead;
  protected int producerLookAheadStep;
  protected int producerMask;
  
  public SpscUnboundedAtomicArrayQueue(int paramInt)
  {
    paramInt = Pow2.roundToPowerOfTwo(Math.max(8, paramInt));
    int i = paramInt - 1;
    AtomicReferenceArray localAtomicReferenceArray = new AtomicReferenceArray(paramInt + 1);
    this.producerBuffer = localAtomicReferenceArray;
    this.producerMask = i;
    adjustLookAheadStep(paramInt);
    this.consumerBuffer = localAtomicReferenceArray;
    this.consumerMask = i;
    this.producerLookAhead = (i - 1);
    soProducerIndex(0L);
  }
  
  private void adjustLookAheadStep(int paramInt)
  {
    this.producerLookAheadStep = Math.min(paramInt / 4, MAX_LOOK_AHEAD_STEP);
  }
  
  private static int calcDirectOffset(int paramInt)
  {
    return paramInt;
  }
  
  private static int calcWrappedOffset(long paramLong, int paramInt)
  {
    return calcDirectOffset((int)paramLong & paramInt);
  }
  
  private long lpConsumerIndex()
  {
    return this.consumerIndex;
  }
  
  private long lpProducerIndex()
  {
    return this.producerIndex;
  }
  
  private long lvConsumerIndex()
  {
    return this.consumerIndex;
  }
  
  private static <E> Object lvElement(AtomicReferenceArray<Object> paramAtomicReferenceArray, int paramInt)
  {
    return paramAtomicReferenceArray.get(paramInt);
  }
  
  private AtomicReferenceArray<Object> lvNext(AtomicReferenceArray<Object> paramAtomicReferenceArray)
  {
    return (AtomicReferenceArray)lvElement(paramAtomicReferenceArray, calcDirectOffset(paramAtomicReferenceArray.length() - 1));
  }
  
  private long lvProducerIndex()
  {
    return this.producerIndex;
  }
  
  private T newBufferPeek(AtomicReferenceArray<Object> paramAtomicReferenceArray, long paramLong, int paramInt)
  {
    this.consumerBuffer = paramAtomicReferenceArray;
    return lvElement(paramAtomicReferenceArray, calcWrappedOffset(paramLong, paramInt));
  }
  
  private T newBufferPoll(AtomicReferenceArray<Object> paramAtomicReferenceArray, long paramLong, int paramInt)
  {
    this.consumerBuffer = paramAtomicReferenceArray;
    paramInt = calcWrappedOffset(paramLong, paramInt);
    Object localObject = lvElement(paramAtomicReferenceArray, paramInt);
    if (localObject == null) {
      return null;
    }
    soConsumerIndex(1L + paramLong);
    soElement(paramAtomicReferenceArray, paramInt, null);
    return localObject;
  }
  
  private void resize(AtomicReferenceArray<Object> paramAtomicReferenceArray, long paramLong1, int paramInt, T paramT, long paramLong2)
  {
    AtomicReferenceArray localAtomicReferenceArray = new AtomicReferenceArray(paramAtomicReferenceArray.length());
    this.producerBuffer = localAtomicReferenceArray;
    this.producerLookAhead = (paramLong1 + paramLong2 - 1L);
    soProducerIndex(paramLong1 + 1L);
    soElement(localAtomicReferenceArray, paramInt, paramT);
    soNext(paramAtomicReferenceArray, localAtomicReferenceArray);
    soElement(paramAtomicReferenceArray, paramInt, HAS_NEXT);
  }
  
  private void soConsumerIndex(long paramLong)
  {
    CONSUMER_INDEX.lazySet(this, paramLong);
  }
  
  private static void soElement(AtomicReferenceArray<Object> paramAtomicReferenceArray, int paramInt, Object paramObject)
  {
    paramAtomicReferenceArray.lazySet(paramInt, paramObject);
  }
  
  private void soNext(AtomicReferenceArray<Object> paramAtomicReferenceArray1, AtomicReferenceArray<Object> paramAtomicReferenceArray2)
  {
    soElement(paramAtomicReferenceArray1, calcDirectOffset(paramAtomicReferenceArray1.length() - 1), paramAtomicReferenceArray2);
  }
  
  private void soProducerIndex(long paramLong)
  {
    PRODUCER_INDEX.lazySet(this, paramLong);
  }
  
  private boolean writeToQueue(AtomicReferenceArray<Object> paramAtomicReferenceArray, T paramT, long paramLong, int paramInt)
  {
    soProducerIndex(1L + paramLong);
    soElement(paramAtomicReferenceArray, paramInt, paramT);
    return true;
  }
  
  public boolean add(T paramT)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean addAll(Collection<? extends T> paramCollection)
  {
    throw new UnsupportedOperationException();
  }
  
  public void clear()
  {
    while ((poll() != null) || (!isEmpty())) {}
  }
  
  public boolean contains(Object paramObject)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean containsAll(Collection<?> paramCollection)
  {
    throw new UnsupportedOperationException();
  }
  
  public T element()
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean isEmpty()
  {
    return lvProducerIndex() == lvConsumerIndex();
  }
  
  public final Iterator<T> iterator()
  {
    throw new UnsupportedOperationException();
  }
  
  public final boolean offer(T paramT)
  {
    if (paramT == null) {
      throw new NullPointerException();
    }
    AtomicReferenceArray localAtomicReferenceArray = this.producerBuffer;
    long l = lpProducerIndex();
    int i = this.producerMask;
    int j = calcWrappedOffset(l, i);
    if (l < this.producerLookAhead) {
      return writeToQueue(localAtomicReferenceArray, paramT, l, j);
    }
    int k = this.producerLookAheadStep;
    if (lvElement(localAtomicReferenceArray, calcWrappedOffset(k + l, i)) == null)
    {
      this.producerLookAhead = (k + l - 1L);
      return writeToQueue(localAtomicReferenceArray, paramT, l, j);
    }
    if (lvElement(localAtomicReferenceArray, calcWrappedOffset(1L + l, i)) != null) {
      return writeToQueue(localAtomicReferenceArray, paramT, l, j);
    }
    resize(localAtomicReferenceArray, l, j, paramT, i);
    return true;
  }
  
  public final T peek()
  {
    AtomicReferenceArray localAtomicReferenceArray = this.consumerBuffer;
    long l = lpConsumerIndex();
    int i = this.consumerMask;
    Object localObject2 = lvElement(localAtomicReferenceArray, calcWrappedOffset(l, i));
    Object localObject1 = localObject2;
    if (localObject2 == HAS_NEXT) {
      localObject1 = newBufferPeek(lvNext(localAtomicReferenceArray), l, i);
    }
    return localObject1;
  }
  
  public final T poll()
  {
    AtomicReferenceArray localAtomicReferenceArray = this.consumerBuffer;
    long l = lpConsumerIndex();
    int j = this.consumerMask;
    int k = calcWrappedOffset(l, j);
    Object localObject = lvElement(localAtomicReferenceArray, k);
    if (localObject == HAS_NEXT) {}
    for (int i = 1; (localObject != null) && (i == 0); i = 0)
    {
      soConsumerIndex(l + 1L);
      soElement(localAtomicReferenceArray, k, null);
      return localObject;
    }
    if (i != 0) {
      return newBufferPoll(lvNext(localAtomicReferenceArray), l, j);
    }
    return null;
  }
  
  public T remove()
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean remove(Object paramObject)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean removeAll(Collection<?> paramCollection)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean retainAll(Collection<?> paramCollection)
  {
    throw new UnsupportedOperationException();
  }
  
  public final int size()
  {
    long l2;
    for (long l1 = lvConsumerIndex();; l1 = l2)
    {
      long l3 = lvProducerIndex();
      l2 = lvConsumerIndex();
      if (l1 == l2) {
        return (int)(l3 - l2);
      }
    }
  }
  
  public Object[] toArray()
  {
    throw new UnsupportedOperationException();
  }
  
  public <E> E[] toArray(E[] paramArrayOfE)
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.internal.util.atomic.SpscUnboundedAtomicArrayQueue
 * JD-Core Version:    0.7.0.1
 */