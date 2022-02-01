package rx.internal.operators;

import rx.Subscriber;
import rx.functions.Action0;

final class OperatorTakeTimed$TakeSubscriber<T>
  extends Subscriber<T>
  implements Action0
{
  final Subscriber<? super T> child;
  
  public OperatorTakeTimed$TakeSubscriber(Subscriber<? super T> paramSubscriber)
  {
    super(paramSubscriber);
    this.child = paramSubscriber;
  }
  
  public void call()
  {
    onCompleted();
  }
  
  public void onCompleted()
  {
    this.child.onCompleted();
    unsubscribe();
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.child.onError(paramThrowable);
    unsubscribe();
  }
  
  public void onNext(T paramT)
  {
    this.child.onNext(paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.internal.operators.OperatorTakeTimed.TakeSubscriber
 * JD-Core Version:    0.7.0.1
 */