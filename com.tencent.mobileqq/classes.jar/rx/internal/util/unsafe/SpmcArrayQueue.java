package rx.internal.util.unsafe;

public final class SpmcArrayQueue<E>
  extends SpmcArrayQueueL3Pad<E>
{
  public SpmcArrayQueue(int paramInt)
  {
    super(paramInt);
  }
  
  public boolean isEmpty()
  {
    return lvConsumerIndex() == lvProducerIndex();
  }
  
  public boolean offer(E paramE)
  {
    if (paramE == null) {
      throw new NullPointerException("Null is not a valid element");
    }
    Object[] arrayOfObject = this.buffer;
    long l1 = this.mask;
    long l2 = lvProducerIndex();
    long l3 = calcElementOffset(l2);
    if (lvElement(arrayOfObject, l3) != null)
    {
      if (l2 - lvConsumerIndex() > l1) {
        return false;
      }
      while (lvElement(arrayOfObject, l3) != null) {}
    }
    spElement(arrayOfObject, l3, paramE);
    soTail(1L + l2);
    return true;
  }
  
  public E peek()
  {
    long l1 = lvProducerIndexCache();
    Object localObject;
    do
    {
      long l2 = lvConsumerIndex();
      if (l2 >= l1)
      {
        long l3 = lvProducerIndex();
        if (l2 >= l3) {
          return null;
        }
        svProducerIndexCache(l3);
      }
      localObject = lvElement(calcElementOffset(l2));
    } while (localObject == null);
    return localObject;
  }
  
  public E poll()
  {
    long l1 = lvProducerIndexCache();
    long l2;
    do
    {
      l2 = lvConsumerIndex();
      if (l2 >= l1)
      {
        long l3 = lvProducerIndex();
        if (l2 >= l3) {
          return null;
        }
        svProducerIndexCache(l3);
      }
    } while (!casHead(l2, 1L + l2));
    l1 = calcElementOffset(l2);
    Object[] arrayOfObject = this.buffer;
    Object localObject = lpElement(arrayOfObject, l1);
    soElement(arrayOfObject, l1, null);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rx.internal.util.unsafe.SpmcArrayQueue
 * JD-Core Version:    0.7.0.1
 */