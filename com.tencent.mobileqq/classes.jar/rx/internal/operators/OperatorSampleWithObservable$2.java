package rx.internal.operators;

import java.util.concurrent.atomic.AtomicReference;
import rx.Subscriber;
import rx.observers.SerializedSubscriber;

class OperatorSampleWithObservable$2
  extends Subscriber<T>
{
  OperatorSampleWithObservable$2(OperatorSampleWithObservable paramOperatorSampleWithObservable, AtomicReference paramAtomicReference, SerializedSubscriber paramSerializedSubscriber, Subscriber paramSubscriber) {}
  
  public void onCompleted()
  {
    this.val$s.onCompleted();
    this.val$samplerSub.unsubscribe();
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.val$s.onError(paramThrowable);
    this.val$samplerSub.unsubscribe();
  }
  
  public void onNext(T paramT)
  {
    this.val$value.set(paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.internal.operators.OperatorSampleWithObservable.2
 * JD-Core Version:    0.7.0.1
 */