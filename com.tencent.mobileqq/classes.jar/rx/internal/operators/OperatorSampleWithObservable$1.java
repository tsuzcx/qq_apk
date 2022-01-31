package rx.internal.operators;

import java.util.concurrent.atomic.AtomicReference;
import rx.Subscriber;
import rx.Subscription;
import rx.observers.SerializedSubscriber;

class OperatorSampleWithObservable$1
  extends Subscriber<U>
{
  OperatorSampleWithObservable$1(OperatorSampleWithObservable paramOperatorSampleWithObservable, AtomicReference paramAtomicReference1, SerializedSubscriber paramSerializedSubscriber, AtomicReference paramAtomicReference2) {}
  
  public void onCompleted()
  {
    this.val$s.onCompleted();
    ((Subscription)this.val$main.get()).unsubscribe();
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.val$s.onError(paramThrowable);
    ((Subscription)this.val$main.get()).unsubscribe();
  }
  
  public void onNext(U paramU)
  {
    paramU = this.val$value.getAndSet(OperatorSampleWithObservable.EMPTY_TOKEN);
    if (paramU != OperatorSampleWithObservable.EMPTY_TOKEN) {
      this.val$s.onNext(paramU);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.internal.operators.OperatorSampleWithObservable.1
 * JD-Core Version:    0.7.0.1
 */