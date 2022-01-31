package rx.internal.operators;

import java.util.concurrent.atomic.AtomicInteger;
import rx.Observable;
import rx.functions.Action0;
import rx.subscriptions.SerialSubscription;

class OperatorRetryWithPredicate$SourceSubscriber$1
  implements Action0
{
  OperatorRetryWithPredicate$SourceSubscriber$1(OperatorRetryWithPredicate.SourceSubscriber paramSourceSubscriber, Observable paramObservable) {}
  
  public void call()
  {
    this.this$0.attempts.incrementAndGet();
    OperatorRetryWithPredicate.SourceSubscriber.1.1 local1 = new OperatorRetryWithPredicate.SourceSubscriber.1.1(this, this);
    this.this$0.serialSubscription.set(local1);
    this.val$o.unsafeSubscribe(local1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.internal.operators.OperatorRetryWithPredicate.SourceSubscriber.1
 * JD-Core Version:    0.7.0.1
 */