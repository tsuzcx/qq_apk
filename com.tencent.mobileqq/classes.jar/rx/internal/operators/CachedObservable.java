package rx.internal.operators;

import rx.Observable;
import rx.Observable.OnSubscribe;

public final class CachedObservable<T>
  extends Observable<T>
{
  private final CachedObservable.CacheState<T> state;
  
  private CachedObservable(Observable.OnSubscribe<T> paramOnSubscribe, CachedObservable.CacheState<T> paramCacheState)
  {
    super(paramOnSubscribe);
    this.state = paramCacheState;
  }
  
  public static <T> CachedObservable<T> from(Observable<? extends T> paramObservable)
  {
    return from(paramObservable, 16);
  }
  
  public static <T> CachedObservable<T> from(Observable<? extends T> paramObservable, int paramInt)
  {
    if (paramInt >= 1)
    {
      paramObservable = new CachedObservable.CacheState(paramObservable, paramInt);
      return new CachedObservable(new CachedObservable.CachedSubscribe(paramObservable), paramObservable);
    }
    throw new IllegalArgumentException("capacityHint > 0 required");
  }
  
  boolean hasObservers()
  {
    return this.state.producers.length != 0;
  }
  
  boolean isConnected()
  {
    return this.state.isConnected;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.internal.operators.CachedObservable
 * JD-Core Version:    0.7.0.1
 */