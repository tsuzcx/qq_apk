package rx.observers;

import rx.Observer;
import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Action1;

public final class Subscribers
{
  private Subscribers()
  {
    throw new IllegalStateException("No instances!");
  }
  
  public static <T> Subscriber<T> create(Action1<? super T> paramAction1)
  {
    if (paramAction1 == null) {
      throw new IllegalArgumentException("onNext can not be null");
    }
    return new Subscribers.2(paramAction1);
  }
  
  public static <T> Subscriber<T> create(Action1<? super T> paramAction1, Action1<Throwable> paramAction11)
  {
    if (paramAction1 == null) {
      throw new IllegalArgumentException("onNext can not be null");
    }
    if (paramAction11 == null) {
      throw new IllegalArgumentException("onError can not be null");
    }
    return new Subscribers.3(paramAction11, paramAction1);
  }
  
  public static <T> Subscriber<T> create(Action1<? super T> paramAction1, Action1<Throwable> paramAction11, Action0 paramAction0)
  {
    if (paramAction1 == null) {
      throw new IllegalArgumentException("onNext can not be null");
    }
    if (paramAction11 == null) {
      throw new IllegalArgumentException("onError can not be null");
    }
    if (paramAction0 == null) {
      throw new IllegalArgumentException("onComplete can not be null");
    }
    return new Subscribers.4(paramAction0, paramAction11, paramAction1);
  }
  
  public static <T> Subscriber<T> empty()
  {
    return from(Observers.empty());
  }
  
  public static <T> Subscriber<T> from(Observer<? super T> paramObserver)
  {
    return new Subscribers.1(paramObserver);
  }
  
  public static <T> Subscriber<T> wrap(Subscriber<? super T> paramSubscriber)
  {
    return new Subscribers.5(paramSubscriber, paramSubscriber);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.observers.Subscribers
 * JD-Core Version:    0.7.0.1
 */