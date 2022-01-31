package rx.internal.operators;

import rx.Subscriber;

final class OperatorDoOnRequest$ParentSubscriber<T>
  extends Subscriber<T>
{
  private final Subscriber<? super T> child;
  
  OperatorDoOnRequest$ParentSubscriber(Subscriber<? super T> paramSubscriber)
  {
    this.child = paramSubscriber;
    request(0L);
  }
  
  private void requestMore(long paramLong)
  {
    request(paramLong);
  }
  
  public void onCompleted()
  {
    this.child.onCompleted();
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.child.onError(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    this.child.onNext(paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     rx.internal.operators.OperatorDoOnRequest.ParentSubscriber
 * JD-Core Version:    0.7.0.1
 */