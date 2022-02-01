package rx.internal.operators;

import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func1;

final class OperatorTakeUntilPredicate$ParentSubscriber
  extends Subscriber<T>
{
  private final Subscriber<? super T> child;
  private boolean done = false;
  
  OperatorTakeUntilPredicate$ParentSubscriber(Subscriber<? super T> paramSubscriber)
  {
    Object localObject;
    this.child = localObject;
  }
  
  void downstreamRequest(long paramLong)
  {
    request(paramLong);
  }
  
  public void onCompleted()
  {
    if (!this.done) {
      this.child.onCompleted();
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    if (!this.done) {
      this.child.onError(paramThrowable);
    }
  }
  
  public void onNext(T paramT)
  {
    this.child.onNext(paramT);
    try
    {
      boolean bool = ((Boolean)this.this$0.stopPredicate.call(paramT)).booleanValue();
      if (bool)
      {
        this.done = true;
        this.child.onCompleted();
        unsubscribe();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      this.done = true;
      Exceptions.throwOrReport(localThrowable, this.child, paramT);
      unsubscribe();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     rx.internal.operators.OperatorTakeUntilPredicate.ParentSubscriber
 * JD-Core Version:    0.7.0.1
 */