package rx.internal.operators;

import java.util.concurrent.atomic.AtomicReference;
import rx.Subscriber;
import rx.observers.SerializedSubscriber;

class OperatorWithLatestFrom$2
  extends Subscriber<U>
{
  OperatorWithLatestFrom$2(OperatorWithLatestFrom paramOperatorWithLatestFrom, AtomicReference paramAtomicReference, SerializedSubscriber paramSerializedSubscriber) {}
  
  public void onCompleted()
  {
    if (this.val$current.get() == OperatorWithLatestFrom.EMPTY)
    {
      this.val$s.onCompleted();
      this.val$s.unsubscribe();
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.val$s.onError(paramThrowable);
    this.val$s.unsubscribe();
  }
  
  public void onNext(U paramU)
  {
    this.val$current.set(paramU);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rx.internal.operators.OperatorWithLatestFrom.2
 * JD-Core Version:    0.7.0.1
 */