package rx.internal.util.unsafe;

abstract class SpscArrayQueueProducerFields<E>
  extends SpscArrayQueueL1Pad<E>
{
  protected static final long P_INDEX_OFFSET = UnsafeAccess.addressOf(SpscArrayQueueProducerFields.class, "producerIndex");
  protected long producerIndex;
  protected long producerLookAhead;
  
  public SpscArrayQueueProducerFields(int paramInt)
  {
    super(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.internal.util.unsafe.SpscArrayQueueProducerFields
 * JD-Core Version:    0.7.0.1
 */