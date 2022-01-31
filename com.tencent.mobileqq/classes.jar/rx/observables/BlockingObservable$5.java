package rx.observables;

import java.util.concurrent.BlockingQueue;
import rx.Subscriber;
import rx.internal.operators.NotificationLite;

class BlockingObservable$5
  extends Subscriber<T>
{
  BlockingObservable$5(BlockingObservable paramBlockingObservable, BlockingQueue paramBlockingQueue, NotificationLite paramNotificationLite) {}
  
  public void onCompleted()
  {
    this.val$queue.offer(this.val$nl.completed());
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.val$queue.offer(this.val$nl.error(paramThrowable));
  }
  
  public void onNext(T paramT)
  {
    this.val$queue.offer(this.val$nl.next(paramT));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rx.observables.BlockingObservable.5
 * JD-Core Version:    0.7.0.1
 */