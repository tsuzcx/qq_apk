package rx.internal.util;

import java.util.Queue;
import rx.internal.util.unsafe.SpmcArrayQueue;

final class RxRingBuffer$2
  extends ObjectPool<Queue<Object>>
{
  protected SpmcArrayQueue<Object> createObject()
  {
    return new SpmcArrayQueue(RxRingBuffer.SIZE);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rx.internal.util.RxRingBuffer.2
 * JD-Core Version:    0.7.0.1
 */