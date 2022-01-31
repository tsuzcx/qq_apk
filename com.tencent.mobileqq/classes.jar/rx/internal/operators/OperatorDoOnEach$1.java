package rx.internal.operators;

import java.util.Arrays;
import rx.Observer;
import rx.Subscriber;
import rx.exceptions.CompositeException;
import rx.exceptions.Exceptions;

class OperatorDoOnEach$1
  extends Subscriber<T>
{
  private boolean done = false;
  
  OperatorDoOnEach$1(OperatorDoOnEach paramOperatorDoOnEach, Subscriber paramSubscriber1, Subscriber paramSubscriber2)
  {
    super(paramSubscriber1);
  }
  
  public void onCompleted()
  {
    if (this.done) {
      return;
    }
    try
    {
      this.this$0.doOnEachObserver.onCompleted();
      this.done = true;
      this.val$observer.onCompleted();
      return;
    }
    catch (Throwable localThrowable)
    {
      Exceptions.throwOrReport(localThrowable, this);
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    Exceptions.throwIfFatal(paramThrowable);
    if (this.done) {
      return;
    }
    this.done = true;
    try
    {
      this.this$0.doOnEachObserver.onError(paramThrowable);
      this.val$observer.onError(paramThrowable);
      return;
    }
    catch (Throwable localThrowable)
    {
      Exceptions.throwIfFatal(localThrowable);
      this.val$observer.onError(new CompositeException(Arrays.asList(new Throwable[] { paramThrowable, localThrowable })));
    }
  }
  
  public void onNext(T paramT)
  {
    if (this.done) {
      return;
    }
    try
    {
      this.this$0.doOnEachObserver.onNext(paramT);
      this.val$observer.onNext(paramT);
      return;
    }
    catch (Throwable localThrowable)
    {
      Exceptions.throwOrReport(localThrowable, this, paramT);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     rx.internal.operators.OperatorDoOnEach.1
 * JD-Core Version:    0.7.0.1
 */