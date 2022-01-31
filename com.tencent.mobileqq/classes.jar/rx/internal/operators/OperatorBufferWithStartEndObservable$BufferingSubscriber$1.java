package rx.internal.operators;

import java.util.List;
import rx.Subscriber;
import rx.subscriptions.CompositeSubscription;

class OperatorBufferWithStartEndObservable$BufferingSubscriber$1
  extends Subscriber<TClosing>
{
  OperatorBufferWithStartEndObservable$BufferingSubscriber$1(OperatorBufferWithStartEndObservable.BufferingSubscriber paramBufferingSubscriber, List paramList) {}
  
  public void onCompleted()
  {
    this.this$1.closingSubscriptions.remove(this);
    this.this$1.endBuffer(this.val$chunk);
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.this$1.onError(paramThrowable);
  }
  
  public void onNext(TClosing paramTClosing)
  {
    this.this$1.closingSubscriptions.remove(this);
    this.this$1.endBuffer(this.val$chunk);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     rx.internal.operators.OperatorBufferWithStartEndObservable.BufferingSubscriber.1
 * JD-Core Version:    0.7.0.1
 */