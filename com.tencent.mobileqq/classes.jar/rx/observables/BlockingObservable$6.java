package rx.observables;

import java.util.concurrent.BlockingQueue;
import rx.Producer;
import rx.Subscriber;
import rx.internal.operators.NotificationLite;

class BlockingObservable$6
  extends Subscriber<T>
{
  BlockingObservable$6(BlockingObservable paramBlockingObservable, BlockingQueue paramBlockingQueue, NotificationLite paramNotificationLite, Producer[] paramArrayOfProducer) {}
  
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
  
  public void onStart()
  {
    this.val$queue.offer(BlockingObservable.ON_START);
  }
  
  public void setProducer(Producer paramProducer)
  {
    this.val$theProducer[0] = paramProducer;
    this.val$queue.offer(BlockingObservable.SET_PRODUCER);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     rx.observables.BlockingObservable.6
 * JD-Core Version:    0.7.0.1
 */