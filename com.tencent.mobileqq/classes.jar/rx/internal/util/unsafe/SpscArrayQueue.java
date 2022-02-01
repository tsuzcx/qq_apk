package rx.internal.util.unsafe;

import sun.misc.Unsafe;

public final class SpscArrayQueue<E>
  extends SpscArrayQueueL3Pad<E>
{
  public SpscArrayQueue(int paramInt)
  {
    super(paramInt);
  }
  
  private long lvConsumerIndex()
  {
    return UnsafeAccess.UNSAFE.getLongVolatile(this, C_INDEX_OFFSET);
  }
  
  private long lvProducerIndex()
  {
    return UnsafeAccess.UNSAFE.getLongVolatile(this, P_INDEX_OFFSET);
  }
  
  private void soConsumerIndex(long paramLong)
  {
    UnsafeAccess.UNSAFE.putOrderedLong(this, C_INDEX_OFFSET, paramLong);
  }
  
  private void soProducerIndex(long paramLong)
  {
    UnsafeAccess.UNSAFE.putOrderedLong(this, P_INDEX_OFFSET, paramLong);
  }
  
  public boolean isEmpty()
  {
    return lvProducerIndex() == lvConsumerIndex();
  }
  
  public boolean offer(E paramE)
  {
    if (paramE != null)
    {
      Object[] arrayOfObject = this.buffer;
      long l1 = this.producerIndex;
      long l2 = calcElementOffset(l1);
      if (lvElement(arrayOfObject, l2) != null) {
        return false;
      }
      soProducerIndex(l1 + 1L);
      soElement(arrayOfObject, l2, paramE);
      return true;
    }
    throw new NullPointerException("null elements not allowed");
  }
  
  public E peek()
  {
    return lvElement(calcElementOffset(this.consumerIndex));
  }
  
  public E poll()
  {
    long l1 = this.consumerIndex;
    long l2 = calcElementOffset(l1);
    Object[] arrayOfObject = this.buffer;
    Object localObject = lvElement(arrayOfObject, l2);
    if (localObject == null) {
      return null;
    }
    soConsumerIndex(l1 + 1L);
    soElement(arrayOfObject, l2, null);
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
 * Qualified Name:     rx.internal.util.unsafe.SpscArrayQueue
 * JD-Core Version:    0.7.0.1
 */