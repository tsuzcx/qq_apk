package rx.internal.operators;

import rx.Subscriber;

final class OperatorWindowWithObservableFactory$BoundarySubscriber<T, U>
  extends Subscriber<U>
{
  boolean done;
  final OperatorWindowWithObservableFactory.SourceSubscriber<T, U> sub;
  
  public OperatorWindowWithObservableFactory$BoundarySubscriber(Subscriber<?> paramSubscriber, OperatorWindowWithObservableFactory.SourceSubscriber<T, U> paramSourceSubscriber)
  {
    this.sub = paramSourceSubscriber;
  }
  
  public void onCompleted()
  {
    if (!this.done)
    {
      this.done = true;
      this.sub.onCompleted();
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.sub.onError(paramThrowable);
  }
  
  public void onNext(U paramU)
  {
    if (!this.done)
    {
      this.done = true;
      this.sub.replaceWindow();
    }
  }
  
  public void onStart()
  {
    request(9223372036854775807L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.internal.operators.OperatorWindowWithObservableFactory.BoundarySubscriber
 * JD-Core Version:    0.7.0.1
 */