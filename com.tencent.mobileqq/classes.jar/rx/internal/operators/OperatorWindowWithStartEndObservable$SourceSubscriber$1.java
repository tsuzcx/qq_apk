package rx.internal.operators;

import rx.Subscriber;
import rx.subscriptions.CompositeSubscription;

class OperatorWindowWithStartEndObservable$SourceSubscriber$1
  extends Subscriber<V>
{
  boolean once = true;
  
  OperatorWindowWithStartEndObservable$SourceSubscriber$1(OperatorWindowWithStartEndObservable.SourceSubscriber paramSourceSubscriber, OperatorWindowWithStartEndObservable.SerializedSubject paramSerializedSubject) {}
  
  public void onCompleted()
  {
    if (this.once)
    {
      this.once = false;
      this.this$1.endWindow(this.val$s);
      this.this$1.csub.remove(this);
    }
  }
  
  public void onError(Throwable paramThrowable) {}
  
  public void onNext(V paramV)
  {
    onCompleted();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rx.internal.operators.OperatorWindowWithStartEndObservable.SourceSubscriber.1
 * JD-Core Version:    0.7.0.1
 */