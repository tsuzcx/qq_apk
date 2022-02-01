package rx.internal.operators;

import java.util.concurrent.atomic.AtomicInteger;
import rx.Producer;
import rx.Scheduler.Worker;
import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Func2;
import rx.internal.producers.ProducerArbiter;

class OperatorRetryWithPredicate$SourceSubscriber$1$1
  extends Subscriber<T>
{
  boolean done;
  
  OperatorRetryWithPredicate$SourceSubscriber$1$1(OperatorRetryWithPredicate.SourceSubscriber.1 param1, Action0 paramAction0) {}
  
  public void onCompleted()
  {
    if (!this.done)
    {
      this.done = true;
      this.this$1.this$0.child.onCompleted();
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    if (!this.done)
    {
      this.done = true;
      if ((((Boolean)this.this$1.this$0.predicate.call(Integer.valueOf(this.this$1.this$0.attempts.get()), paramThrowable)).booleanValue()) && (!this.this$1.this$0.inner.isUnsubscribed()))
      {
        this.this$1.this$0.inner.schedule(this.val$_self);
        return;
      }
      this.this$1.this$0.child.onError(paramThrowable);
    }
  }
  
  public void onNext(T paramT)
  {
    if (!this.done)
    {
      this.this$1.this$0.child.onNext(paramT);
      this.this$1.this$0.pa.produced(1L);
    }
  }
  
  public void setProducer(Producer paramProducer)
  {
    this.this$1.this$0.pa.setProducer(paramProducer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.internal.operators.OperatorRetryWithPredicate.SourceSubscriber.1.1
 * JD-Core Version:    0.7.0.1
 */