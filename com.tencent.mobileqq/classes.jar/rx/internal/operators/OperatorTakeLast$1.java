package rx.internal.operators;

import java.util.Deque;
import rx.Subscriber;

class OperatorTakeLast$1
  extends Subscriber<T>
{
  OperatorTakeLast$1(OperatorTakeLast paramOperatorTakeLast, Subscriber paramSubscriber1, Deque paramDeque, NotificationLite paramNotificationLite, TakeLastQueueProducer paramTakeLastQueueProducer, Subscriber paramSubscriber2)
  {
    super(paramSubscriber1);
  }
  
  public void onCompleted()
  {
    this.val$deque.offer(this.val$notification.completed());
    this.val$producer.startEmitting();
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.val$deque.clear();
    this.val$subscriber.onError(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    if (this.this$0.count == 0) {
      return;
    }
    if (this.val$deque.size() == this.this$0.count) {
      this.val$deque.removeFirst();
    }
    this.val$deque.offerLast(this.val$notification.next(paramT));
  }
  
  public void onStart()
  {
    request(9223372036854775807L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     rx.internal.operators.OperatorTakeLast.1
 * JD-Core Version:    0.7.0.1
 */