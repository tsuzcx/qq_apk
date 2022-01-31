package rx.internal.util.unsafe;

public class MpmcArrayQueue<E>
  extends MpmcArrayQueueConsumerField<E>
{
  long p30;
  long p31;
  long p32;
  long p33;
  long p34;
  long p35;
  long p36;
  long p37;
  long p40;
  long p41;
  long p42;
  long p43;
  long p44;
  long p45;
  long p46;
  
  public MpmcArrayQueue(int paramInt)
  {
    super(Math.max(2, paramInt));
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
    long l3 = this.mask + 1L;
    long[] arrayOfLong = this.sequenceBuffer;
    long l1;
    for (long l2 = 9223372036854775807L;; l2 = l1)
    {
      long l4 = lvProducerIndex();
      long l5 = calcSequenceOffset(l4);
      long l6 = lvSequence(arrayOfLong, l5) - l4;
      if (l6 == 0L)
      {
        l1 = l2;
        if (casProducerIndex(l4, 1L + l4))
        {
          spElement(calcElementOffset(l4), paramE);
          soSequence(arrayOfLong, l5, 1L + l4);
          return true;
        }
      }
      else
      {
        l1 = l2;
        if (l6 < 0L)
        {
          l1 = l2;
          if (l4 - l3 <= l2)
          {
            l2 = lvConsumerIndex();
            l1 = l2;
            if (l4 - l3 <= l2) {
              return false;
            }
          }
        }
      }
    }
  }
  
  public E peek()
  {
    long l;
    Object localObject;
    do
    {
      l = lvConsumerIndex();
      localObject = lpElement(calcElementOffset(l));
    } while ((localObject == null) && (l != lvProducerIndex()));
    return localObject;
  }
  
  public E poll()
  {
    long[] arrayOfLong = this.sequenceBuffer;
    long l1;
    for (long l2 = -1L;; l2 = l1)
    {
      long l3 = lvConsumerIndex();
      long l4 = calcSequenceOffset(l3);
      long l5 = lvSequence(arrayOfLong, l4) - (1L + l3);
      if (l5 == 0L)
      {
        l1 = l2;
        if (casConsumerIndex(l3, 1L + l3))
        {
          l1 = calcElementOffset(l3);
          Object localObject = lpElement(l1);
          spElement(l1, null);
          soSequence(arrayOfLong, l4, this.mask + l3 + 1L);
          return localObject;
        }
      }
      else
      {
        l1 = l2;
        if (l5 < 0L)
        {
          l1 = l2;
          if (l3 >= l2)
          {
            l2 = lvProducerIndex();
            l1 = l2;
            if (l3 == l2) {
              return null;
            }
          }
        }
      }
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.internal.util.unsafe.MpmcArrayQueue
 * JD-Core Version:    0.7.0.1
 */