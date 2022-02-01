package rx.internal.util.atomic;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

public final class SpscAtomicArrayQueue<E>
  extends AtomicReferenceArrayQueue<E>
{
  private static final Integer MAX_LOOK_AHEAD_STEP = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);
  final AtomicLong consumerIndex = new AtomicLong();
  final int lookAheadStep;
  final AtomicLong producerIndex = new AtomicLong();
  protected long producerLookAhead;
  
  public SpscAtomicArrayQueue(int paramInt)
  {
    super(paramInt);
    this.lookAheadStep = Math.min(paramInt / 4, MAX_LOOK_AHEAD_STEP.intValue());
  }
  
  private long lvConsumerIndex()
  {
    return this.consumerIndex.get();
  }
  
  private long lvProducerIndex()
  {
    return this.producerIndex.get();
  }
  
  private void soConsumerIndex(long paramLong)
  {
    this.consumerIndex.lazySet(paramLong);
  }
  
  private void soProducerIndex(long paramLong)
  {
    this.producerIndex.lazySet(paramLong);
  }
  
  public boolean isEmpty()
  {
    return lvProducerIndex() == lvConsumerIndex();
  }
  
  public boolean offer(E paramE)
  {
    if (paramE != null)
    {
      AtomicReferenceArray localAtomicReferenceArray = this.buffer;
      int i = this.mask;
      long l1 = this.producerIndex.get();
      int j = calcElementOffset(l1, i);
      if (l1 >= this.producerLookAhead)
      {
        long l2 = this.lookAheadStep + l1;
        if (lvElement(localAtomicReferenceArray, calcElementOffset(l2, i)) == null) {
          this.producerLookAhead = l2;
        } else if (lvElement(localAtomicReferenceArray, j) != null) {
          return false;
        }
      }
      soProducerIndex(l1 + 1L);
      soElement(localAtomicReferenceArray, j, paramE);
      return true;
    }
    throw new NullPointerException("Null is not a valid element");
  }
  
  public E peek()
  {
    return lvElement(calcElementOffset(this.consumerIndex.get()));
  }
  
  public E poll()
  {
    long l = this.consumerIndex.get();
    int i = calcElementOffset(l);
    AtomicReferenceArray localAtomicReferenceArray = this.buffer;
    Object localObject = lvElement(localAtomicReferenceArray, i);
    if (localObject == null) {
      return null;
    }
    soConsumerIndex(l + 1L);
    soElement(localAtomicReferenceArray, i, null);
    return localObject;
  }
  
  public int size()
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.internal.util.atomic.SpscAtomicArrayQueue
 * JD-Core Version:    0.7.0.1
 */