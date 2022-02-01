package rx.observables;

import rx.Observable;
import rx.Observer;
import rx.functions.Action1;
import rx.functions.Func0;
import rx.functions.Func3;

final class AsyncOnSubscribe$AsyncOnSubscribeImpl<S, T>
  extends AsyncOnSubscribe<S, T>
{
  private final Func0<? extends S> generator;
  private final Func3<? super S, Long, ? super Observer<Observable<? extends T>>, ? extends S> next;
  private final Action1<? super S> onUnsubscribe;
  
  public AsyncOnSubscribe$AsyncOnSubscribeImpl(Func0<? extends S> paramFunc0, Func3<? super S, Long, ? super Observer<Observable<? extends T>>, ? extends S> paramFunc3)
  {
    this(paramFunc0, paramFunc3, null);
  }
  
  AsyncOnSubscribe$AsyncOnSubscribeImpl(Func0<? extends S> paramFunc0, Func3<? super S, Long, ? super Observer<Observable<? extends T>>, ? extends S> paramFunc3, Action1<? super S> paramAction1)
  {
    this.generator = paramFunc0;
    this.next = paramFunc3;
    this.onUnsubscribe = paramAction1;
  }
  
  public AsyncOnSubscribe$AsyncOnSubscribeImpl(Func3<S, Long, Observer<Observable<? extends T>>, S> paramFunc3)
  {
    this(null, paramFunc3, null);
  }
  
  public AsyncOnSubscribe$AsyncOnSubscribeImpl(Func3<S, Long, Observer<Observable<? extends T>>, S> paramFunc3, Action1<? super S> paramAction1)
  {
    this(null, paramFunc3, paramAction1);
  }
  
  protected S generateState()
  {
    if (this.generator == null) {
      return null;
    }
    return this.generator.call();
  }
  
  protected S next(S paramS, long paramLong, Observer<Observable<? extends T>> paramObserver)
  {
    return this.next.call(paramS, Long.valueOf(paramLong), paramObserver);
  }
  
  protected void onUnsubscribe(S paramS)
  {
    if (this.onUnsubscribe != null) {
      this.onUnsubscribe.call(paramS);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     rx.observables.AsyncOnSubscribe.AsyncOnSubscribeImpl
 * JD-Core Version:    0.7.0.1
 */