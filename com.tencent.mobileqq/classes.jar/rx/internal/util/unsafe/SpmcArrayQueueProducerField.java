package rx.internal.util.unsafe;

import sun.misc.Unsafe;

abstract class SpmcArrayQueueProducerField<E>
  extends SpmcArrayQueueL1Pad<E>
{
  protected static final long P_INDEX_OFFSET = UnsafeAccess.addressOf(SpmcArrayQueueProducerField.class, "producerIndex");
  private volatile long producerIndex;
  
  public SpmcArrayQueueProducerField(int paramInt)
  {
    super(paramInt);
  }
  
  protected final long lvProducerIndex()
  {
    return this.producerIndex;
  }
  
  protected final void soTail(long paramLong)
  {
    UnsafeAccess.UNSAFE.putOrderedLong(this, P_INDEX_OFFSET, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rx.internal.util.unsafe.SpmcArrayQueueProducerField
 * JD-Core Version:    0.7.0.1
 */