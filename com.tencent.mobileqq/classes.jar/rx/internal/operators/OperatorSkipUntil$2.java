package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.Subscriber;
import rx.observers.SerializedSubscriber;

class OperatorSkipUntil$2
  extends Subscriber<T>
{
  OperatorSkipUntil$2(OperatorSkipUntil paramOperatorSkipUntil, Subscriber paramSubscriber, AtomicBoolean paramAtomicBoolean, SerializedSubscriber paramSerializedSubscriber)
  {
    super(paramSubscriber);
  }
  
  public void onCompleted()
  {
    this.val$s.onCompleted();
    unsubscribe();
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.val$s.onError(paramThrowable);
    unsubscribe();
  }
  
  public void onNext(T paramT)
  {
    if (this.val$gate.get())
    {
      this.val$s.onNext(paramT);
      return;
    }
    request(1L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rx.internal.operators.OperatorSkipUntil.2
 * JD-Core Version:    0.7.0.1
 */