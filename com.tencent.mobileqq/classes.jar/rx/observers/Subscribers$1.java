package rx.observers;

import rx.Observer;
import rx.Subscriber;

final class Subscribers$1
  extends Subscriber<T>
{
  Subscribers$1(Observer paramObserver) {}
  
  public void onCompleted()
  {
    this.val$o.onCompleted();
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.val$o.onError(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    this.val$o.onNext(paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     rx.observers.Subscribers.1
 * JD-Core Version:    0.7.0.1
 */