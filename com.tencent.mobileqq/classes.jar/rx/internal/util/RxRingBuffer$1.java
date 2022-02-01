package rx.internal.util;

import java.util.Queue;
import rx.internal.util.unsafe.SpscArrayQueue;

final class RxRingBuffer$1
  extends ObjectPool<Queue<Object>>
{
  protected SpscArrayQueue<Object> createObject()
  {
    return new SpscArrayQueue(RxRingBuffer.SIZE);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rx.internal.util.RxRingBuffer.1
 * JD-Core Version:    0.7.0.1
 */