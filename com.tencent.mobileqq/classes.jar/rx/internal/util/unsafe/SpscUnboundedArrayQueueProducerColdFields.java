package rx.internal.util.unsafe;

abstract class SpscUnboundedArrayQueueProducerColdFields<E>
  extends SpscUnboundedArrayQueueProducerFields<E>
{
  protected E[] producerBuffer;
  protected long producerLookAhead;
  protected int producerLookAheadStep;
  protected long producerMask;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rx.internal.util.unsafe.SpscUnboundedArrayQueueProducerColdFields
 * JD-Core Version:    0.7.0.1
 */