package rx.observers;

import rx.Observer;
import rx.functions.Action0;
import rx.functions.Action1;

public final class Observers
{
  private static final Observer<Object> EMPTY = new Observers.1();
  
  private Observers()
  {
    throw new IllegalStateException("No instances!");
  }
  
  public static <T> Observer<T> create(Action1<? super T> paramAction1)
  {
    if (paramAction1 == null) {
      throw new IllegalArgumentException("onNext can not be null");
    }
    return new Observers.2(paramAction1);
  }
  
  public static <T> Observer<T> create(Action1<? super T> paramAction1, Action1<Throwable> paramAction11)
  {
    if (paramAction1 == null) {
      throw new IllegalArgumentException("onNext can not be null");
    }
    if (paramAction11 == null) {
      throw new IllegalArgumentException("onError can not be null");
    }
    return new Observers.3(paramAction11, paramAction1);
  }
  
  public static <T> Observer<T> create(Action1<? super T> paramAction1, Action1<Throwable> paramAction11, Action0 paramAction0)
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
    return new Observers.4(paramAction0, paramAction11, paramAction1);
  }
  
  public static <T> Observer<T> empty()
  {
    return EMPTY;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     rx.observers.Observers
 * JD-Core Version:    0.7.0.1
 */