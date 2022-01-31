package rx.internal.operators;

import java.util.Queue;
import rx.Subscriber;
import rx.internal.util.atomic.SpscAtomicArrayQueue;
import rx.internal.util.unsafe.SpscArrayQueue;
import rx.internal.util.unsafe.UnsafeAccess;

final class OperatorEagerConcatMap$EagerInnerSubscriber<T>
  extends Subscriber<T>
{
  volatile boolean done;
  Throwable error;
  final NotificationLite<T> nl;
  final OperatorEagerConcatMap.EagerOuterSubscriber<?, T> parent;
  final Queue<Object> queue;
  
  public OperatorEagerConcatMap$EagerInnerSubscriber(OperatorEagerConcatMap.EagerOuterSubscriber<?, T> paramEagerOuterSubscriber, int paramInt)
  {
    this.parent = paramEagerOuterSubscriber;
    if (UnsafeAccess.isUnsafeAvailable()) {}
    for (paramEagerOuterSubscriber = new SpscArrayQueue(paramInt);; paramEagerOuterSubscriber = new SpscAtomicArrayQueue(paramInt))
    {
      this.queue = paramEagerOuterSubscriber;
      this.nl = NotificationLite.instance();
      request(paramInt);
      return;
    }
  }
  
  public void onCompleted()
  {
    this.done = true;
    this.parent.drain();
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.error = paramThrowable;
    this.done = true;
    this.parent.drain();
  }
  
  public void onNext(T paramT)
  {
    this.queue.offer(this.nl.next(paramT));
    this.parent.drain();
  }
  
  void requestMore(long paramLong)
  {
    request(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     rx.internal.operators.OperatorEagerConcatMap.EagerInnerSubscriber
 * JD-Core Version:    0.7.0.1
 */