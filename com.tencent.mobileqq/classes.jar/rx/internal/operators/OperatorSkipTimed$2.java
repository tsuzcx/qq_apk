package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.Subscriber;

class OperatorSkipTimed$2
  extends Subscriber<T>
{
  OperatorSkipTimed$2(OperatorSkipTimed paramOperatorSkipTimed, Subscriber paramSubscriber1, AtomicBoolean paramAtomicBoolean, Subscriber paramSubscriber2)
  {
    super(paramSubscriber1);
  }
  
  public void onCompleted()
  {
    try
    {
      this.val$child.onCompleted();
      return;
    }
    finally
    {
      unsubscribe();
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    try
    {
      this.val$child.onError(paramThrowable);
      return;
    }
    finally
    {
      unsubscribe();
    }
  }
  
  public void onNext(T paramT)
  {
    if (this.val$gate.get()) {
      this.val$child.onNext(paramT);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     rx.internal.operators.OperatorSkipTimed.2
 * JD-Core Version:    0.7.0.1
 */