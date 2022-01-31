package rx.observables;

import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.annotations.Experimental;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Action2;
import rx.functions.Action3;
import rx.functions.Func0;
import rx.functions.Func3;

@Experimental
public abstract class AsyncOnSubscribe<S, T>
  implements Observable.OnSubscribe<T>
{
  @Experimental
  public static <S, T> AsyncOnSubscribe<S, T> createSingleState(Func0<? extends S> paramFunc0, Action3<? super S, Long, ? super Observer<Observable<? extends T>>> paramAction3)
  {
    return new AsyncOnSubscribe.AsyncOnSubscribeImpl(paramFunc0, new AsyncOnSubscribe.1(paramAction3));
  }
  
  @Experimental
  public static <S, T> AsyncOnSubscribe<S, T> createSingleState(Func0<? extends S> paramFunc0, Action3<? super S, Long, ? super Observer<Observable<? extends T>>> paramAction3, Action1<? super S> paramAction1)
  {
    return new AsyncOnSubscribe.AsyncOnSubscribeImpl(paramFunc0, new AsyncOnSubscribe.2(paramAction3), paramAction1);
  }
  
  @Experimental
  public static <S, T> AsyncOnSubscribe<S, T> createStateful(Func0<? extends S> paramFunc0, Func3<? super S, Long, ? super Observer<Observable<? extends T>>, ? extends S> paramFunc3)
  {
    return new AsyncOnSubscribe.AsyncOnSubscribeImpl(paramFunc0, paramFunc3);
  }
  
  @Experimental
  public static <S, T> AsyncOnSubscribe<S, T> createStateful(Func0<? extends S> paramFunc0, Func3<? super S, Long, ? super Observer<Observable<? extends T>>, ? extends S> paramFunc3, Action1<? super S> paramAction1)
  {
    return new AsyncOnSubscribe.AsyncOnSubscribeImpl(paramFunc0, paramFunc3, paramAction1);
  }
  
  @Experimental
  public static <T> AsyncOnSubscribe<Void, T> createStateless(Action2<Long, ? super Observer<Observable<? extends T>>> paramAction2)
  {
    return new AsyncOnSubscribe.AsyncOnSubscribeImpl(new AsyncOnSubscribe.3(paramAction2));
  }
  
  @Experimental
  public static <T> AsyncOnSubscribe<Void, T> createStateless(Action2<Long, ? super Observer<Observable<? extends T>>> paramAction2, Action0 paramAction0)
  {
    return new AsyncOnSubscribe.AsyncOnSubscribeImpl(new AsyncOnSubscribe.4(paramAction2), new AsyncOnSubscribe.5(paramAction0));
  }
  
  public final void call(Subscriber<? super T> paramSubscriber)
  {
    try
    {
      Object localObject = generateState();
      AsyncOnSubscribe.UnicastSubject localUnicastSubject = AsyncOnSubscribe.UnicastSubject.create();
      localObject = new AsyncOnSubscribe.AsyncOuterManager(this, localObject, localUnicastSubject);
      AsyncOnSubscribe.6 local6 = new AsyncOnSubscribe.6(this, paramSubscriber, (AsyncOnSubscribe.AsyncOuterManager)localObject);
      localUnicastSubject.onBackpressureBuffer().concatMap(new AsyncOnSubscribe.7(this)).unsafeSubscribe(local6);
      paramSubscriber.add(local6);
      paramSubscriber.add((Subscription)localObject);
      paramSubscriber.setProducer((Producer)localObject);
      return;
    }
    catch (Throwable localThrowable)
    {
      paramSubscriber.onError(localThrowable);
    }
  }
  
  protected abstract S generateState();
  
  protected abstract S next(S paramS, long paramLong, Observer<Observable<? extends T>> paramObserver);
  
  protected void onUnsubscribe(S paramS) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     rx.observables.AsyncOnSubscribe
 * JD-Core Version:    0.7.0.1
 */