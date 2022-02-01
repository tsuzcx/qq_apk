package rx.observables;

import rx.Observable.OnSubscribe;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.annotations.Experimental;
import rx.exceptions.Exceptions;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Action2;
import rx.functions.Func0;
import rx.functions.Func2;

@Experimental
public abstract class SyncOnSubscribe<S, T>
  implements Observable.OnSubscribe<T>
{
  @Experimental
  public static <S, T> SyncOnSubscribe<S, T> createSingleState(Func0<? extends S> paramFunc0, Action2<? super S, ? super Observer<? super T>> paramAction2)
  {
    return new SyncOnSubscribe.SyncOnSubscribeImpl(paramFunc0, new SyncOnSubscribe.1(paramAction2));
  }
  
  @Experimental
  public static <S, T> SyncOnSubscribe<S, T> createSingleState(Func0<? extends S> paramFunc0, Action2<? super S, ? super Observer<? super T>> paramAction2, Action1<? super S> paramAction1)
  {
    return new SyncOnSubscribe.SyncOnSubscribeImpl(paramFunc0, new SyncOnSubscribe.2(paramAction2), paramAction1);
  }
  
  @Experimental
  public static <S, T> SyncOnSubscribe<S, T> createStateful(Func0<? extends S> paramFunc0, Func2<? super S, ? super Observer<? super T>, ? extends S> paramFunc2)
  {
    return new SyncOnSubscribe.SyncOnSubscribeImpl(paramFunc0, paramFunc2);
  }
  
  @Experimental
  public static <S, T> SyncOnSubscribe<S, T> createStateful(Func0<? extends S> paramFunc0, Func2<? super S, ? super Observer<? super T>, ? extends S> paramFunc2, Action1<? super S> paramAction1)
  {
    return new SyncOnSubscribe.SyncOnSubscribeImpl(paramFunc0, paramFunc2, paramAction1);
  }
  
  @Experimental
  public static <T> SyncOnSubscribe<Void, T> createStateless(Action1<? super Observer<? super T>> paramAction1)
  {
    return new SyncOnSubscribe.SyncOnSubscribeImpl(new SyncOnSubscribe.3(paramAction1));
  }
  
  @Experimental
  public static <T> SyncOnSubscribe<Void, T> createStateless(Action1<? super Observer<? super T>> paramAction1, Action0 paramAction0)
  {
    return new SyncOnSubscribe.SyncOnSubscribeImpl(new SyncOnSubscribe.4(paramAction1), new SyncOnSubscribe.5(paramAction0));
  }
  
  public final void call(Subscriber<? super T> paramSubscriber)
  {
    try
    {
      Object localObject = generateState();
      localObject = new SyncOnSubscribe.SubscriptionProducer(paramSubscriber, this, localObject);
      paramSubscriber.add((Subscription)localObject);
      paramSubscriber.setProducer((Producer)localObject);
      return;
    }
    catch (Throwable localThrowable)
    {
      Exceptions.throwIfFatal(localThrowable);
      paramSubscriber.onError(localThrowable);
    }
  }
  
  protected abstract S generateState();
  
  protected abstract S next(S paramS, Observer<? super T> paramObserver);
  
  protected void onUnsubscribe(S paramS) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.observables.SyncOnSubscribe
 * JD-Core Version:    0.7.0.1
 */