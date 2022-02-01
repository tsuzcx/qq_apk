package rx.internal.operators;

import java.util.ArrayDeque;
import java.util.Deque;
import rx.Subscriber;

class OperatorSkipLast$1
  extends Subscriber<T>
{
  private final Deque<Object> deque = new ArrayDeque();
  private final NotificationLite<T> on = NotificationLite.instance();
  
  OperatorSkipLast$1(OperatorSkipLast paramOperatorSkipLast, Subscriber paramSubscriber1, Subscriber paramSubscriber2)
  {
    super(paramSubscriber1);
  }
  
  public void onCompleted()
  {
    this.val$subscriber.onCompleted();
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.val$subscriber.onError(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    if (this.this$0.count == 0)
    {
      this.val$subscriber.onNext(paramT);
      return;
    }
    if (this.deque.size() == this.this$0.count) {
      this.val$subscriber.onNext(this.on.getValue(this.deque.removeFirst()));
    }
    for (;;)
    {
      this.deque.offerLast(this.on.next(paramT));
      return;
      request(1L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     rx.internal.operators.OperatorSkipLast.1
 * JD-Core Version:    0.7.0.1
 */