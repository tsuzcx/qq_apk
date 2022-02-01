package rx.internal.operators;

import java.util.concurrent.atomic.AtomicReference;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func2;
import rx.observers.SerializedSubscriber;

class OperatorWithLatestFrom$1
  extends Subscriber<T>
{
  OperatorWithLatestFrom$1(OperatorWithLatestFrom paramOperatorWithLatestFrom, Subscriber paramSubscriber, boolean paramBoolean, AtomicReference paramAtomicReference, SerializedSubscriber paramSerializedSubscriber)
  {
    super(paramSubscriber, paramBoolean);
  }
  
  public void onCompleted()
  {
    this.val$s.onCompleted();
    this.val$s.unsubscribe();
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.val$s.onError(paramThrowable);
    this.val$s.unsubscribe();
  }
  
  public void onNext(T paramT)
  {
    Object localObject = this.val$current.get();
    if (localObject != OperatorWithLatestFrom.EMPTY) {
      try
      {
        paramT = this.this$0.resultSelector.call(paramT, localObject);
        this.val$s.onNext(paramT);
        return;
      }
      catch (Throwable paramT)
      {
        Exceptions.throwOrReport(paramT, this);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.internal.operators.OperatorWithLatestFrom.1
 * JD-Core Version:    0.7.0.1
 */