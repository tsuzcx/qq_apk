package rx.internal.operators;

import rx.Subscriber;

final class OperatorWindowWithObservable$BoundarySubscriber<T, U>
  extends Subscriber<U>
{
  final OperatorWindowWithObservable.SourceSubscriber<T> sub;
  
  public OperatorWindowWithObservable$BoundarySubscriber(Subscriber<?> paramSubscriber, OperatorWindowWithObservable.SourceSubscriber<T> paramSourceSubscriber)
  {
    this.sub = paramSourceSubscriber;
  }
  
  public void onCompleted()
  {
    this.sub.onCompleted();
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.sub.onError(paramThrowable);
  }
  
  public void onNext(U paramU)
  {
    this.sub.replaceWindow();
  }
  
  public void onStart()
  {
    request(9223372036854775807L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.internal.operators.OperatorWindowWithObservable.BoundarySubscriber
 * JD-Core Version:    0.7.0.1
 */