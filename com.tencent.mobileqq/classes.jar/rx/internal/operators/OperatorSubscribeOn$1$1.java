package rx.internal.operators;

import rx.Producer;
import rx.Scheduler.Worker;
import rx.Subscriber;

class OperatorSubscribeOn$1$1
  extends Subscriber<T>
{
  OperatorSubscribeOn$1$1(OperatorSubscribeOn.1 param1, Subscriber paramSubscriber, Thread paramThread)
  {
    super(paramSubscriber);
  }
  
  public void onCompleted()
  {
    try
    {
      this.this$1.val$subscriber.onCompleted();
      return;
    }
    finally
    {
      this.this$1.val$inner.unsubscribe();
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    try
    {
      this.this$1.val$subscriber.onError(paramThrowable);
      return;
    }
    finally
    {
      this.this$1.val$inner.unsubscribe();
    }
  }
  
  public void onNext(T paramT)
  {
    this.this$1.val$subscriber.onNext(paramT);
  }
  
  public void setProducer(Producer paramProducer)
  {
    this.this$1.val$subscriber.setProducer(new OperatorSubscribeOn.1.1.1(this, paramProducer));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     rx.internal.operators.OperatorSubscribeOn.1.1
 * JD-Core Version:    0.7.0.1
 */