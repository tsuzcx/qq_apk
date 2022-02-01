package rx.internal.operators;

import rx.Observable;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func1;
import rx.observers.SerializedSubscriber;
import rx.subjects.PublishSubject;

class OperatorDelayWithSelector$1
  extends Subscriber<T>
{
  OperatorDelayWithSelector$1(OperatorDelayWithSelector paramOperatorDelayWithSelector, Subscriber paramSubscriber, PublishSubject paramPublishSubject, SerializedSubscriber paramSerializedSubscriber)
  {
    super(paramSubscriber);
  }
  
  public void onCompleted()
  {
    this.val$delayedEmissions.onCompleted();
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.val$child.onError(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    try
    {
      this.val$delayedEmissions.onNext(((Observable)this.this$0.itemDelay.call(paramT)).take(1).defaultIfEmpty(null).map(new OperatorDelayWithSelector.1.1(this, paramT)));
      return;
    }
    catch (Throwable paramT)
    {
      Exceptions.throwOrReport(paramT, this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rx.internal.operators.OperatorDelayWithSelector.1
 * JD-Core Version:    0.7.0.1
 */