package rx;

import java.lang.Iterable<+Lrx.Single<+TT;>;>;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import rx.annotations.Beta;
import rx.annotations.Experimental;
import rx.exceptions.Exceptions;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func0;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.functions.Func3;
import rx.functions.Func4;
import rx.functions.Func5;
import rx.functions.Func6;
import rx.functions.Func7;
import rx.functions.Func8;
import rx.functions.Func9;
import rx.functions.FuncN;
import rx.internal.operators.OnSubscribeToObservableFuture;
import rx.internal.operators.OperatorDelay;
import rx.internal.operators.OperatorDoAfterTerminate;
import rx.internal.operators.OperatorDoOnEach;
import rx.internal.operators.OperatorDoOnSubscribe;
import rx.internal.operators.OperatorDoOnUnsubscribe;
import rx.internal.operators.OperatorMap;
import rx.internal.operators.OperatorObserveOn;
import rx.internal.operators.OperatorOnErrorResumeNextViaFunction;
import rx.internal.operators.OperatorTimeout;
import rx.internal.operators.SingleOnSubscribeUsing;
import rx.internal.operators.SingleOperatorOnErrorResumeNext;
import rx.internal.operators.SingleOperatorZip;
import rx.internal.util.ScalarSynchronousSingle;
import rx.internal.util.UtilityFunctions;
import rx.observers.SafeSubscriber;
import rx.plugins.RxJavaPlugins;
import rx.plugins.RxJavaSingleExecutionHook;
import rx.schedulers.Schedulers;
import rx.singles.BlockingSingle;
import rx.subscriptions.Subscriptions;

@Beta
public class Single<T>
{
  static RxJavaSingleExecutionHook hook = RxJavaPlugins.getInstance().getSingleExecutionHook();
  final Observable.OnSubscribe<T> onSubscribe;
  
  private Single(Observable.OnSubscribe<T> paramOnSubscribe)
  {
    this.onSubscribe = paramOnSubscribe;
  }
  
  protected Single(Single.OnSubscribe<T> paramOnSubscribe)
  {
    this.onSubscribe = new Single.1(this, paramOnSubscribe);
  }
  
  private static <T> Observable<T> asObservable(Single<T> paramSingle)
  {
    return Observable.create(paramSingle.onSubscribe);
  }
  
  public static <T> Observable<T> concat(Single<? extends T> paramSingle1, Single<? extends T> paramSingle2)
  {
    return Observable.concat(asObservable(paramSingle1), asObservable(paramSingle2));
  }
  
  public static <T> Observable<T> concat(Single<? extends T> paramSingle1, Single<? extends T> paramSingle2, Single<? extends T> paramSingle3)
  {
    return Observable.concat(asObservable(paramSingle1), asObservable(paramSingle2), asObservable(paramSingle3));
  }
  
  public static <T> Observable<T> concat(Single<? extends T> paramSingle1, Single<? extends T> paramSingle2, Single<? extends T> paramSingle3, Single<? extends T> paramSingle4)
  {
    return Observable.concat(asObservable(paramSingle1), asObservable(paramSingle2), asObservable(paramSingle3), asObservable(paramSingle4));
  }
  
  public static <T> Observable<T> concat(Single<? extends T> paramSingle1, Single<? extends T> paramSingle2, Single<? extends T> paramSingle3, Single<? extends T> paramSingle4, Single<? extends T> paramSingle5)
  {
    return Observable.concat(asObservable(paramSingle1), asObservable(paramSingle2), asObservable(paramSingle3), asObservable(paramSingle4), asObservable(paramSingle5));
  }
  
  public static <T> Observable<T> concat(Single<? extends T> paramSingle1, Single<? extends T> paramSingle2, Single<? extends T> paramSingle3, Single<? extends T> paramSingle4, Single<? extends T> paramSingle5, Single<? extends T> paramSingle6)
  {
    return Observable.concat(asObservable(paramSingle1), asObservable(paramSingle2), asObservable(paramSingle3), asObservable(paramSingle4), asObservable(paramSingle5), asObservable(paramSingle6));
  }
  
  public static <T> Observable<T> concat(Single<? extends T> paramSingle1, Single<? extends T> paramSingle2, Single<? extends T> paramSingle3, Single<? extends T> paramSingle4, Single<? extends T> paramSingle5, Single<? extends T> paramSingle6, Single<? extends T> paramSingle7)
  {
    return Observable.concat(asObservable(paramSingle1), asObservable(paramSingle2), asObservable(paramSingle3), asObservable(paramSingle4), asObservable(paramSingle5), asObservable(paramSingle6), asObservable(paramSingle7));
  }
  
  public static <T> Observable<T> concat(Single<? extends T> paramSingle1, Single<? extends T> paramSingle2, Single<? extends T> paramSingle3, Single<? extends T> paramSingle4, Single<? extends T> paramSingle5, Single<? extends T> paramSingle6, Single<? extends T> paramSingle7, Single<? extends T> paramSingle8)
  {
    return Observable.concat(asObservable(paramSingle1), asObservable(paramSingle2), asObservable(paramSingle3), asObservable(paramSingle4), asObservable(paramSingle5), asObservable(paramSingle6), asObservable(paramSingle7), asObservable(paramSingle8));
  }
  
  public static <T> Observable<T> concat(Single<? extends T> paramSingle1, Single<? extends T> paramSingle2, Single<? extends T> paramSingle3, Single<? extends T> paramSingle4, Single<? extends T> paramSingle5, Single<? extends T> paramSingle6, Single<? extends T> paramSingle7, Single<? extends T> paramSingle8, Single<? extends T> paramSingle9)
  {
    return Observable.concat(asObservable(paramSingle1), asObservable(paramSingle2), asObservable(paramSingle3), asObservable(paramSingle4), asObservable(paramSingle5), asObservable(paramSingle6), asObservable(paramSingle7), asObservable(paramSingle8), asObservable(paramSingle9));
  }
  
  public static <T> Single<T> create(Single.OnSubscribe<T> paramOnSubscribe)
  {
    return new Single(hook.onCreate(paramOnSubscribe));
  }
  
  @Experimental
  public static <T> Single<T> defer(Callable<Single<T>> paramCallable)
  {
    return create(new Single.25(paramCallable));
  }
  
  public static <T> Single<T> error(Throwable paramThrowable)
  {
    return create(new Single.3(paramThrowable));
  }
  
  public static <T> Single<T> from(Future<? extends T> paramFuture)
  {
    return new Single(OnSubscribeToObservableFuture.toObservableFuture(paramFuture));
  }
  
  public static <T> Single<T> from(Future<? extends T> paramFuture, long paramLong, TimeUnit paramTimeUnit)
  {
    return new Single(OnSubscribeToObservableFuture.toObservableFuture(paramFuture, paramLong, paramTimeUnit));
  }
  
  public static <T> Single<T> from(Future<? extends T> paramFuture, Scheduler paramScheduler)
  {
    return new Single(OnSubscribeToObservableFuture.toObservableFuture(paramFuture)).subscribeOn(paramScheduler);
  }
  
  @Experimental
  public static <T> Single<T> fromCallable(Callable<? extends T> paramCallable)
  {
    return create(new Single.4(paramCallable));
  }
  
  static <T> Single<? extends T>[] iterableToArray(Iterable<? extends Single<? extends T>> paramIterable)
  {
    if ((paramIterable instanceof Collection))
    {
      paramIterable = (Collection)paramIterable;
      return (Single[])paramIterable.toArray(new Single[paramIterable.size()]);
    }
    Object localObject = new Single[8];
    Iterator localIterator = paramIterable.iterator();
    paramIterable = (Iterable<? extends Single<? extends T>>)localObject;
    int i = 0;
    while (localIterator.hasNext())
    {
      Single localSingle = (Single)localIterator.next();
      localObject = paramIterable;
      if (i == paramIterable.length)
      {
        localObject = new Single[(i >> 2) + i];
        System.arraycopy(paramIterable, 0, localObject, 0, i);
      }
      localObject[i] = localSingle;
      i += 1;
      paramIterable = (Iterable<? extends Single<? extends T>>)localObject;
    }
    if (paramIterable.length == i) {
      return paramIterable;
    }
    localObject = new Single[i];
    System.arraycopy(paramIterable, 0, localObject, 0, i);
    return localObject;
  }
  
  public static <T> Single<T> just(T paramT)
  {
    return ScalarSynchronousSingle.create(paramT);
  }
  
  private <R> Single<R> lift(Observable.Operator<? extends R, ? super T> paramOperator)
  {
    return new Single(new Single.2(this, paramOperator));
  }
  
  public static <T> Observable<T> merge(Single<? extends T> paramSingle1, Single<? extends T> paramSingle2)
  {
    return Observable.merge(asObservable(paramSingle1), asObservable(paramSingle2));
  }
  
  public static <T> Observable<T> merge(Single<? extends T> paramSingle1, Single<? extends T> paramSingle2, Single<? extends T> paramSingle3)
  {
    return Observable.merge(asObservable(paramSingle1), asObservable(paramSingle2), asObservable(paramSingle3));
  }
  
  public static <T> Observable<T> merge(Single<? extends T> paramSingle1, Single<? extends T> paramSingle2, Single<? extends T> paramSingle3, Single<? extends T> paramSingle4)
  {
    return Observable.merge(asObservable(paramSingle1), asObservable(paramSingle2), asObservable(paramSingle3), asObservable(paramSingle4));
  }
  
  public static <T> Observable<T> merge(Single<? extends T> paramSingle1, Single<? extends T> paramSingle2, Single<? extends T> paramSingle3, Single<? extends T> paramSingle4, Single<? extends T> paramSingle5)
  {
    return Observable.merge(asObservable(paramSingle1), asObservable(paramSingle2), asObservable(paramSingle3), asObservable(paramSingle4), asObservable(paramSingle5));
  }
  
  public static <T> Observable<T> merge(Single<? extends T> paramSingle1, Single<? extends T> paramSingle2, Single<? extends T> paramSingle3, Single<? extends T> paramSingle4, Single<? extends T> paramSingle5, Single<? extends T> paramSingle6)
  {
    return Observable.merge(asObservable(paramSingle1), asObservable(paramSingle2), asObservable(paramSingle3), asObservable(paramSingle4), asObservable(paramSingle5), asObservable(paramSingle6));
  }
  
  public static <T> Observable<T> merge(Single<? extends T> paramSingle1, Single<? extends T> paramSingle2, Single<? extends T> paramSingle3, Single<? extends T> paramSingle4, Single<? extends T> paramSingle5, Single<? extends T> paramSingle6, Single<? extends T> paramSingle7)
  {
    return Observable.merge(asObservable(paramSingle1), asObservable(paramSingle2), asObservable(paramSingle3), asObservable(paramSingle4), asObservable(paramSingle5), asObservable(paramSingle6), asObservable(paramSingle7));
  }
  
  public static <T> Observable<T> merge(Single<? extends T> paramSingle1, Single<? extends T> paramSingle2, Single<? extends T> paramSingle3, Single<? extends T> paramSingle4, Single<? extends T> paramSingle5, Single<? extends T> paramSingle6, Single<? extends T> paramSingle7, Single<? extends T> paramSingle8)
  {
    return Observable.merge(asObservable(paramSingle1), asObservable(paramSingle2), asObservable(paramSingle3), asObservable(paramSingle4), asObservable(paramSingle5), asObservable(paramSingle6), asObservable(paramSingle7), asObservable(paramSingle8));
  }
  
  public static <T> Observable<T> merge(Single<? extends T> paramSingle1, Single<? extends T> paramSingle2, Single<? extends T> paramSingle3, Single<? extends T> paramSingle4, Single<? extends T> paramSingle5, Single<? extends T> paramSingle6, Single<? extends T> paramSingle7, Single<? extends T> paramSingle8, Single<? extends T> paramSingle9)
  {
    return Observable.merge(asObservable(paramSingle1), asObservable(paramSingle2), asObservable(paramSingle3), asObservable(paramSingle4), asObservable(paramSingle5), asObservable(paramSingle6), asObservable(paramSingle7), asObservable(paramSingle8), asObservable(paramSingle9));
  }
  
  public static <T> Single<T> merge(Single<? extends Single<? extends T>> paramSingle)
  {
    if ((paramSingle instanceof ScalarSynchronousSingle)) {
      return ((ScalarSynchronousSingle)paramSingle).scalarFlatMap(UtilityFunctions.identity());
    }
    return create(new Single.5(paramSingle));
  }
  
  private Single<Observable<T>> nest()
  {
    return just(asObservable(this));
  }
  
  @Experimental
  public static <T, Resource> Single<T> using(Func0<Resource> paramFunc0, Func1<? super Resource, ? extends Single<? extends T>> paramFunc1, Action1<? super Resource> paramAction1)
  {
    return using(paramFunc0, paramFunc1, paramAction1, false);
  }
  
  @Experimental
  public static <T, Resource> Single<T> using(Func0<Resource> paramFunc0, Func1<? super Resource, ? extends Single<? extends T>> paramFunc1, Action1<? super Resource> paramAction1, boolean paramBoolean)
  {
    if (paramFunc0 == null) {
      throw new NullPointerException("resourceFactory is null");
    }
    if (paramFunc1 == null) {
      throw new NullPointerException("singleFactory is null");
    }
    if (paramAction1 == null) {
      throw new NullPointerException("disposeAction is null");
    }
    return create(new SingleOnSubscribeUsing(paramFunc0, paramFunc1, paramAction1, paramBoolean));
  }
  
  public static <R> Single<R> zip(Iterable<? extends Single<?>> paramIterable, FuncN<? extends R> paramFuncN)
  {
    return SingleOperatorZip.zip(iterableToArray(paramIterable), paramFuncN);
  }
  
  public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Single<R> zip(Single<? extends T1> paramSingle, Single<? extends T2> paramSingle1, Single<? extends T3> paramSingle2, Single<? extends T4> paramSingle3, Single<? extends T5> paramSingle4, Single<? extends T6> paramSingle5, Single<? extends T7> paramSingle6, Single<? extends T8> paramSingle7, Single<? extends T9> paramSingle8, Func9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> paramFunc9)
  {
    paramFunc9 = new Single.13(paramFunc9);
    return SingleOperatorZip.zip(new Single[] { paramSingle, paramSingle1, paramSingle2, paramSingle3, paramSingle4, paramSingle5, paramSingle6, paramSingle7, paramSingle8 }, paramFunc9);
  }
  
  public static <T1, T2, T3, T4, T5, T6, T7, T8, R> Single<R> zip(Single<? extends T1> paramSingle, Single<? extends T2> paramSingle1, Single<? extends T3> paramSingle2, Single<? extends T4> paramSingle3, Single<? extends T5> paramSingle4, Single<? extends T6> paramSingle5, Single<? extends T7> paramSingle6, Single<? extends T8> paramSingle7, Func8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> paramFunc8)
  {
    paramFunc8 = new Single.12(paramFunc8);
    return SingleOperatorZip.zip(new Single[] { paramSingle, paramSingle1, paramSingle2, paramSingle3, paramSingle4, paramSingle5, paramSingle6, paramSingle7 }, paramFunc8);
  }
  
  public static <T1, T2, T3, T4, T5, T6, T7, R> Single<R> zip(Single<? extends T1> paramSingle, Single<? extends T2> paramSingle1, Single<? extends T3> paramSingle2, Single<? extends T4> paramSingle3, Single<? extends T5> paramSingle4, Single<? extends T6> paramSingle5, Single<? extends T7> paramSingle6, Func7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> paramFunc7)
  {
    paramFunc7 = new Single.11(paramFunc7);
    return SingleOperatorZip.zip(new Single[] { paramSingle, paramSingle1, paramSingle2, paramSingle3, paramSingle4, paramSingle5, paramSingle6 }, paramFunc7);
  }
  
  public static <T1, T2, T3, T4, T5, T6, R> Single<R> zip(Single<? extends T1> paramSingle, Single<? extends T2> paramSingle1, Single<? extends T3> paramSingle2, Single<? extends T4> paramSingle3, Single<? extends T5> paramSingle4, Single<? extends T6> paramSingle5, Func6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> paramFunc6)
  {
    paramFunc6 = new Single.10(paramFunc6);
    return SingleOperatorZip.zip(new Single[] { paramSingle, paramSingle1, paramSingle2, paramSingle3, paramSingle4, paramSingle5 }, paramFunc6);
  }
  
  public static <T1, T2, T3, T4, T5, R> Single<R> zip(Single<? extends T1> paramSingle, Single<? extends T2> paramSingle1, Single<? extends T3> paramSingle2, Single<? extends T4> paramSingle3, Single<? extends T5> paramSingle4, Func5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> paramFunc5)
  {
    paramFunc5 = new Single.9(paramFunc5);
    return SingleOperatorZip.zip(new Single[] { paramSingle, paramSingle1, paramSingle2, paramSingle3, paramSingle4 }, paramFunc5);
  }
  
  public static <T1, T2, T3, T4, R> Single<R> zip(Single<? extends T1> paramSingle, Single<? extends T2> paramSingle1, Single<? extends T3> paramSingle2, Single<? extends T4> paramSingle3, Func4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> paramFunc4)
  {
    paramFunc4 = new Single.8(paramFunc4);
    return SingleOperatorZip.zip(new Single[] { paramSingle, paramSingle1, paramSingle2, paramSingle3 }, paramFunc4);
  }
  
  public static <T1, T2, T3, R> Single<R> zip(Single<? extends T1> paramSingle, Single<? extends T2> paramSingle1, Single<? extends T3> paramSingle2, Func3<? super T1, ? super T2, ? super T3, ? extends R> paramFunc3)
  {
    paramFunc3 = new Single.7(paramFunc3);
    return SingleOperatorZip.zip(new Single[] { paramSingle, paramSingle1, paramSingle2 }, paramFunc3);
  }
  
  public static <T1, T2, R> Single<R> zip(Single<? extends T1> paramSingle, Single<? extends T2> paramSingle1, Func2<? super T1, ? super T2, ? extends R> paramFunc2)
  {
    paramFunc2 = new Single.6(paramFunc2);
    return SingleOperatorZip.zip(new Single[] { paramSingle, paramSingle1 }, paramFunc2);
  }
  
  public <R> Single<R> compose(Single.Transformer<? super T, ? extends R> paramTransformer)
  {
    return (Single)paramTransformer.call(this);
  }
  
  public final Observable<T> concatWith(Single<? extends T> paramSingle)
  {
    return concat(this, paramSingle);
  }
  
  @Experimental
  public final Single<T> delay(long paramLong, TimeUnit paramTimeUnit)
  {
    return delay(paramLong, paramTimeUnit, Schedulers.computation());
  }
  
  @Experimental
  public final Single<T> delay(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    return lift(new OperatorDelay(paramLong, paramTimeUnit, paramScheduler));
  }
  
  @Experimental
  public final Single<T> doAfterTerminate(Action0 paramAction0)
  {
    return lift(new OperatorDoAfterTerminate(paramAction0));
  }
  
  @Experimental
  public final Single<T> doOnError(Action1<Throwable> paramAction1)
  {
    return lift(new OperatorDoOnEach(new Single.23(this, paramAction1)));
  }
  
  @Experimental
  public final Single<T> doOnSubscribe(Action0 paramAction0)
  {
    return lift(new OperatorDoOnSubscribe(paramAction0));
  }
  
  @Experimental
  public final Single<T> doOnSuccess(Action1<? super T> paramAction1)
  {
    return lift(new OperatorDoOnEach(new Single.24(this, paramAction1)));
  }
  
  @Experimental
  public final Single<T> doOnUnsubscribe(Action0 paramAction0)
  {
    return lift(new OperatorDoOnUnsubscribe(paramAction0));
  }
  
  public final <R> Single<R> flatMap(Func1<? super T, ? extends Single<? extends R>> paramFunc1)
  {
    if ((this instanceof ScalarSynchronousSingle)) {
      return ((ScalarSynchronousSingle)this).scalarFlatMap(paramFunc1);
    }
    return merge(map(paramFunc1));
  }
  
  public final <R> Observable<R> flatMapObservable(Func1<? super T, ? extends Observable<? extends R>> paramFunc1)
  {
    return Observable.merge(asObservable(map(paramFunc1)));
  }
  
  public final <R> Single<R> map(Func1<? super T, ? extends R> paramFunc1)
  {
    return lift(new OperatorMap(paramFunc1));
  }
  
  public final Observable<T> mergeWith(Single<? extends T> paramSingle)
  {
    return merge(this, paramSingle);
  }
  
  public final Single<T> observeOn(Scheduler paramScheduler)
  {
    if ((this instanceof ScalarSynchronousSingle)) {
      return ((ScalarSynchronousSingle)this).scalarScheduleOn(paramScheduler);
    }
    return lift(new OperatorObserveOn(paramScheduler, false));
  }
  
  @Experimental
  public final Single<T> onErrorResumeNext(Single<? extends T> paramSingle)
  {
    return new Single(SingleOperatorOnErrorResumeNext.withOther(this, paramSingle));
  }
  
  @Experimental
  public final Single<T> onErrorResumeNext(Func1<Throwable, ? extends Single<? extends T>> paramFunc1)
  {
    return new Single(SingleOperatorOnErrorResumeNext.withFunction(this, paramFunc1));
  }
  
  public final Single<T> onErrorReturn(Func1<Throwable, ? extends T> paramFunc1)
  {
    return lift(OperatorOnErrorResumeNextViaFunction.withSingle(paramFunc1));
  }
  
  public final Single<T> retry()
  {
    return toObservable().retry().toSingle();
  }
  
  public final Single<T> retry(long paramLong)
  {
    return toObservable().retry(paramLong).toSingle();
  }
  
  public final Single<T> retry(Func2<Integer, Throwable, Boolean> paramFunc2)
  {
    return toObservable().retry(paramFunc2).toSingle();
  }
  
  public final Single<T> retryWhen(Func1<Observable<? extends Throwable>, ? extends Observable<?>> paramFunc1)
  {
    return toObservable().retryWhen(paramFunc1).toSingle();
  }
  
  public final Subscription subscribe()
  {
    return subscribe(new Single.14(this));
  }
  
  public final Subscription subscribe(Observer<? super T> paramObserver)
  {
    if (paramObserver == null) {
      throw new NullPointerException("observer is null");
    }
    return subscribe(new Single.17(this, paramObserver));
  }
  
  public final Subscription subscribe(SingleSubscriber<? super T> paramSingleSubscriber)
  {
    Single.18 local18 = new Single.18(this, paramSingleSubscriber);
    paramSingleSubscriber.add(local18);
    subscribe(local18);
    return local18;
  }
  
  public final Subscription subscribe(Subscriber<? super T> paramSubscriber)
  {
    if (paramSubscriber == null) {
      throw new IllegalArgumentException("observer can not be null");
    }
    if (this.onSubscribe == null) {
      throw new IllegalStateException("onSubscribe function can not be null.");
    }
    paramSubscriber.onStart();
    Object localObject = paramSubscriber;
    if (!(paramSubscriber instanceof SafeSubscriber)) {
      localObject = new SafeSubscriber(paramSubscriber);
    }
    try
    {
      hook.onSubscribeStart(this, this.onSubscribe).call(localObject);
      paramSubscriber = hook.onSubscribeReturn((Subscription)localObject);
      return paramSubscriber;
    }
    catch (Throwable paramSubscriber)
    {
      Exceptions.throwIfFatal(paramSubscriber);
      try
      {
        ((Subscriber)localObject).onError(hook.onSubscribeError(paramSubscriber));
        return Subscriptions.empty();
      }
      catch (Throwable localThrowable)
      {
        Exceptions.throwIfFatal(localThrowable);
        paramSubscriber = new RuntimeException("Error occurred attempting to subscribe [" + paramSubscriber.getMessage() + "] and then again while trying to pass to onError.", localThrowable);
        hook.onSubscribeError(paramSubscriber);
        throw paramSubscriber;
      }
    }
  }
  
  public final Subscription subscribe(Action1<? super T> paramAction1)
  {
    if (paramAction1 == null) {
      throw new IllegalArgumentException("onSuccess can not be null");
    }
    return subscribe(new Single.15(this, paramAction1));
  }
  
  public final Subscription subscribe(Action1<? super T> paramAction1, Action1<Throwable> paramAction11)
  {
    if (paramAction1 == null) {
      throw new IllegalArgumentException("onSuccess can not be null");
    }
    if (paramAction11 == null) {
      throw new IllegalArgumentException("onError can not be null");
    }
    return subscribe(new Single.16(this, paramAction11, paramAction1));
  }
  
  public final Single<T> subscribeOn(Scheduler paramScheduler)
  {
    if ((this instanceof ScalarSynchronousSingle)) {
      return ((ScalarSynchronousSingle)this).scalarScheduleOn(paramScheduler);
    }
    return create(new Single.19(this, paramScheduler));
  }
  
  public final Single<T> takeUntil(Completable paramCompletable)
  {
    return lift(new Single.20(this, paramCompletable));
  }
  
  public final <E> Single<T> takeUntil(Observable<? extends E> paramObservable)
  {
    return lift(new Single.21(this, paramObservable));
  }
  
  public final <E> Single<T> takeUntil(Single<? extends E> paramSingle)
  {
    return lift(new Single.22(this, paramSingle));
  }
  
  public final Single<T> timeout(long paramLong, TimeUnit paramTimeUnit)
  {
    return timeout(paramLong, paramTimeUnit, null, Schedulers.computation());
  }
  
  public final Single<T> timeout(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    return timeout(paramLong, paramTimeUnit, null, paramScheduler);
  }
  
  public final Single<T> timeout(long paramLong, TimeUnit paramTimeUnit, Single<? extends T> paramSingle)
  {
    return timeout(paramLong, paramTimeUnit, paramSingle, Schedulers.computation());
  }
  
  public final Single<T> timeout(long paramLong, TimeUnit paramTimeUnit, Single<? extends T> paramSingle, Scheduler paramScheduler)
  {
    Object localObject = paramSingle;
    if (paramSingle == null) {
      localObject = error(new TimeoutException());
    }
    return lift(new OperatorTimeout(paramLong, paramTimeUnit, asObservable((Single)localObject), paramScheduler));
  }
  
  @Experimental
  public final BlockingSingle<T> toBlocking()
  {
    return BlockingSingle.from(this);
  }
  
  public final Observable<T> toObservable()
  {
    return asObservable(this);
  }
  
  public final Subscription unsafeSubscribe(Subscriber<? super T> paramSubscriber)
  {
    try
    {
      paramSubscriber.onStart();
      hook.onSubscribeStart(this, this.onSubscribe).call(paramSubscriber);
      Subscription localSubscription = hook.onSubscribeReturn(paramSubscriber);
      return localSubscription;
    }
    catch (Throwable localThrowable)
    {
      Exceptions.throwIfFatal(localThrowable);
      try
      {
        paramSubscriber.onError(hook.onSubscribeError(localThrowable));
        return Subscriptions.unsubscribed();
      }
      catch (Throwable paramSubscriber)
      {
        Exceptions.throwIfFatal(paramSubscriber);
        paramSubscriber = new RuntimeException("Error occurred attempting to subscribe [" + localThrowable.getMessage() + "] and then again while trying to pass to onError.", paramSubscriber);
        hook.onSubscribeError(paramSubscriber);
        throw paramSubscriber;
      }
    }
  }
  
  public final <T2, R> Single<R> zipWith(Single<? extends T2> paramSingle, Func2<? super T, ? super T2, ? extends R> paramFunc2)
  {
    return zip(this, paramSingle, paramFunc2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.Single
 * JD-Core Version:    0.7.0.1
 */