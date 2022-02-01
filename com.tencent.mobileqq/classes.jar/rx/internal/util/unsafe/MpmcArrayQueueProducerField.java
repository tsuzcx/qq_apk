package rx.internal.util.unsafe;

import sun.misc.Unsafe;

abstract class MpmcArrayQueueProducerField<E>
  extends MpmcArrayQueueL1Pad<E>
{
  private static final long P_INDEX_OFFSET = UnsafeAccess.addressOf(MpmcArrayQueueProducerField.class, "producerIndex");
  private volatile long producerIndex;
  
  public MpmcArrayQueueProducerField(int paramInt)
  {
    super(paramInt);
  }
  
  protected final boolean casProducerIndex(long paramLong1, long paramLong2)
  {
    return UnsafeAccess.UNSAFE.compareAndSwapLong(this, P_INDEX_OFFSET, paramLong1, paramLong2);
  }
  
  protected final long lvProducerIndex()
  {
    return this.producerIndex;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     rx.internal.util.unsafe.MpmcArrayQueueProducerField
 * JD-Core Version:    0.7.0.1
 */