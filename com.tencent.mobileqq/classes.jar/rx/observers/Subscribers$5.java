package rx.observers;

import rx.Subscriber;

final class Subscribers$5
  extends Subscriber<T>
{
  Subscribers$5(Subscriber paramSubscriber1, Subscriber paramSubscriber2)
  {
    super(paramSubscriber1);
  }
  
  public void onCompleted()
  {
    this.val$subscriber.onCompleted();
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.val$subscriber.onError(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    this.val$subscriber.onNext(paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rx.observers.Subscribers.5
 * JD-Core Version:    0.7.0.1
 */