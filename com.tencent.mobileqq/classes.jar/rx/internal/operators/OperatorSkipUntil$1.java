package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.Subscriber;
import rx.observers.SerializedSubscriber;

class OperatorSkipUntil$1
  extends Subscriber<U>
{
  OperatorSkipUntil$1(OperatorSkipUntil paramOperatorSkipUntil, AtomicBoolean paramAtomicBoolean, SerializedSubscriber paramSerializedSubscriber) {}
  
  public void onCompleted()
  {
    unsubscribe();
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.val$s.onError(paramThrowable);
    this.val$s.unsubscribe();
  }
  
  public void onNext(U paramU)
  {
    this.val$gate.set(true);
    unsubscribe();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.internal.operators.OperatorSkipUntil.1
 * JD-Core Version:    0.7.0.1
 */