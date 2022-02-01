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
    if (paramE != null)
    {
      long l3 = this.mask;
      long[] arrayOfLong = this.sequenceBuffer;
      long l1 = 9223372036854775807L;
      long l2;
      long l4;
      do
      {
        do
        {
          long l5;
          do
          {
            do
            {
              l2 = lvProducerIndex();
              l4 = calcSequenceOffset(l2);
              l5 = lvSequence(arrayOfLong, l4) - l2;
              if (l5 != 0L) {
                break;
              }
              l5 = l2 + 1L;
            } while (!casProducerIndex(l2, l5));
            spElement(calcElementOffset(l2), paramE);
            soSequence(arrayOfLong, l4, l5);
            return true;
          } while (l5 >= 0L);
          l4 = l2 - (l3 + 1L);
        } while (l4 > l1);
        l2 = lvConsumerIndex();
        l1 = l2;
      } while (l4 > l2);
      return false;
    }
    paramE = new NullPointerException("Null is not a valid element");
    for (;;)
    {
      throw paramE;
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
    long l1 = -1L;
    long l3;
    long l2;
    do
    {
      long l5;
      do
      {
        long l4;
        do
        {
          l3 = lvConsumerIndex();
          l2 = calcSequenceOffset(l3);
          l5 = lvSequence(arrayOfLong, l2);
          l4 = l3 + 1L;
          l5 -= l4;
          if (l5 != 0L) {
            break;
          }
        } while (!casConsumerIndex(l3, l4));
        l1 = calcElementOffset(l3);
        Object localObject = lpElement(l1);
        spElement(l1, null);
        soSequence(arrayOfLong, l2, l3 + this.mask + 1L);
        return localObject;
      } while ((l5 >= 0L) || (l3 < l1));
      l2 = lvProducerIndex();
      l1 = l2;
    } while (l3 != l2);
    return null;
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
 * Qualified Name:     rx.internal.util.unsafe.MpmcArrayQueue
 * JD-Core Version:    0.7.0.1
 */