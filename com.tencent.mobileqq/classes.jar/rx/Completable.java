package rx;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import rx.annotations.Experimental;
import rx.exceptions.Exceptions;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Actions;
import rx.functions.Func0;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.internal.operators.CompletableOnSubscribeConcat;
import rx.internal.operators.CompletableOnSubscribeConcatArray;
import rx.internal.operators.CompletableOnSubscribeConcatIterable;
import rx.internal.operators.CompletableOnSubscribeMerge;
import rx.internal.operators.CompletableOnSubscribeMergeArray;
import rx.internal.operators.CompletableOnSubscribeMergeDelayErrorArray;
import rx.internal.operators.CompletableOnSubscribeMergeDelayErrorIterable;
import rx.internal.operators.CompletableOnSubscribeMergeIterable;
import rx.internal.operators.CompletableOnSubscribeTimeout;
import rx.internal.util.UtilityFunctions;
import rx.plugins.RxJavaErrorHandler;
import rx.plugins.RxJavaPlugins;
import rx.schedulers.Schedulers;
import rx.subscriptions.MultipleAssignmentSubscription;

@Experimental
public class Completable
{
  static final Completable COMPLETE = create(new Completable.1());
  static final RxJavaErrorHandler ERROR_HANDLER = RxJavaPlugins.getInstance().getErrorHandler();
  static final Completable NEVER = create(new Completable.2());
  private final Completable.CompletableOnSubscribe onSubscribe;
  
  protected Completable(Completable.CompletableOnSubscribe paramCompletableOnSubscribe)
  {
    this.onSubscribe = paramCompletableOnSubscribe;
  }
  
  public static Completable amb(Iterable<? extends Completable> paramIterable)
  {
    requireNonNull(paramIterable);
    return create(new Completable.4(paramIterable));
  }
  
  public static Completable amb(Completable... paramVarArgs)
  {
    requireNonNull(paramVarArgs);
    if (paramVarArgs.length == 0) {
      return complete();
    }
    if (paramVarArgs.length == 1) {
      return paramVarArgs[0];
    }
    return create(new Completable.3(paramVarArgs));
  }
  
  public static Completable complete()
  {
    return COMPLETE;
  }
  
  public static Completable concat(Iterable<? extends Completable> paramIterable)
  {
    requireNonNull(paramIterable);
    return create(new CompletableOnSubscribeConcatIterable(paramIterable));
  }
  
  public static Completable concat(Observable<? extends Completable> paramObservable)
  {
    return concat(paramObservable, 2);
  }
  
  public static Completable concat(Observable<? extends Completable> paramObservable, int paramInt)
  {
    requireNonNull(paramObservable);
    if (paramInt < 1) {
      throw new IllegalArgumentException("prefetch > 0 required but it was " + paramInt);
    }
    return create(new CompletableOnSubscribeConcat(paramObservable, paramInt));
  }
  
  public static Completable concat(Completable... paramVarArgs)
  {
    requireNonNull(paramVarArgs);
    if (paramVarArgs.length == 0) {
      return complete();
    }
    if (paramVarArgs.length == 1) {
      return paramVarArgs[0];
    }
    return create(new CompletableOnSubscribeConcatArray(paramVarArgs));
  }
  
  public static Completable create(Completable.CompletableOnSubscribe paramCompletableOnSubscribe)
  {
    requireNonNull(paramCompletableOnSubscribe);
    try
    {
      paramCompletableOnSubscribe = new Completable(paramCompletableOnSubscribe);
      return paramCompletableOnSubscribe;
    }
    catch (NullPointerException paramCompletableOnSubscribe)
    {
      throw paramCompletableOnSubscribe;
    }
    catch (Throwable paramCompletableOnSubscribe)
    {
      ERROR_HANDLER.handleError(paramCompletableOnSubscribe);
      throw toNpe(paramCompletableOnSubscribe);
    }
  }
  
  public static Completable defer(Func0<? extends Completable> paramFunc0)
  {
    requireNonNull(paramFunc0);
    return create(new Completable.5(paramFunc0));
  }
  
  private static void deliverUncaughtException(Throwable paramThrowable)
  {
    Thread localThread = Thread.currentThread();
    localThread.getUncaughtExceptionHandler().uncaughtException(localThread, paramThrowable);
  }
  
  public static Completable error(Throwable paramThrowable)
  {
    requireNonNull(paramThrowable);
    return create(new Completable.7(paramThrowable));
  }
  
  public static Completable error(Func0<? extends Throwable> paramFunc0)
  {
    requireNonNull(paramFunc0);
    return create(new Completable.6(paramFunc0));
  }
  
  public static Completable fromAction(Action0 paramAction0)
  {
    requireNonNull(paramAction0);
    return create(new Completable.8(paramAction0));
  }
  
  public static Completable fromCallable(Callable<?> paramCallable)
  {
    requireNonNull(paramCallable);
    return create(new Completable.9(paramCallable));
  }
  
  public static Completable fromFuture(Future<?> paramFuture)
  {
    requireNonNull(paramFuture);
    return fromObservable(Observable.from(paramFuture));
  }
  
  public static Completable fromObservable(Observable<?> paramObservable)
  {
    requireNonNull(paramObservable);
    return create(new Completable.10(paramObservable));
  }
  
  public static Completable fromSingle(Single<?> paramSingle)
  {
    requireNonNull(paramSingle);
    return create(new Completable.11(paramSingle));
  }
  
  public static Completable merge(Iterable<? extends Completable> paramIterable)
  {
    requireNonNull(paramIterable);
    return create(new CompletableOnSubscribeMergeIterable(paramIterable));
  }
  
  public static Completable merge(Observable<? extends Completable> paramObservable)
  {
    return merge0(paramObservable, 2147483647, false);
  }
  
  public static Completable merge(Observable<? extends Completable> paramObservable, int paramInt)
  {
    return merge0(paramObservable, paramInt, false);
  }
  
  public static Completable merge(Completable... paramVarArgs)
  {
    requireNonNull(paramVarArgs);
    if (paramVarArgs.length == 0) {
      return complete();
    }
    if (paramVarArgs.length == 1) {
      return paramVarArgs[0];
    }
    return create(new CompletableOnSubscribeMergeArray(paramVarArgs));
  }
  
  protected static Completable merge0(Observable<? extends Completable> paramObservable, int paramInt, boolean paramBoolean)
  {
    requireNonNull(paramObservable);
    if (paramInt < 1) {
      throw new IllegalArgumentException("maxConcurrency > 0 required but it was " + paramInt);
    }
    return create(new CompletableOnSubscribeMerge(paramObservable, paramInt, paramBoolean));
  }
  
  public static Completable mergeDelayError(Iterable<? extends Completable> paramIterable)
  {
    requireNonNull(paramIterable);
    return create(new CompletableOnSubscribeMergeDelayErrorIterable(paramIterable));
  }
  
  public static Completable mergeDelayError(Observable<? extends Completable> paramObservable)
  {
    return merge0(paramObservable, 2147483647, true);
  }
  
  public static Completable mergeDelayError(Observable<? extends Completable> paramObservable, int paramInt)
  {
    return merge0(paramObservable, paramInt, true);
  }
  
  public static Completable mergeDelayError(Completable... paramVarArgs)
  {
    requireNonNull(paramVarArgs);
    return create(new CompletableOnSubscribeMergeDelayErrorArray(paramVarArgs));
  }
  
  public static Completable never()
  {
    return NEVER;
  }
  
  static <T> T requireNonNull(T paramT)
  {
    if (paramT == null) {
      throw new NullPointerException();
    }
    return paramT;
  }
  
  public static Completable timer(long paramLong, TimeUnit paramTimeUnit)
  {
    return timer(paramLong, paramTimeUnit, Schedulers.computation());
  }
  
  public static Completable timer(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    requireNonNull(paramTimeUnit);
    requireNonNull(paramScheduler);
    return create(new Completable.12(paramScheduler, paramLong, paramTimeUnit));
  }
  
  static NullPointerException toNpe(Throwable paramThrowable)
  {
    NullPointerException localNullPointerException = new NullPointerException("Actually not, but can't pass out an exception otherwise...");
    localNullPointerException.initCause(paramThrowable);
    return localNullPointerException;
  }
  
  public static <R> Completable using(Func0<R> paramFunc0, Func1<? super R, ? extends Completable> paramFunc1, Action1<? super R> paramAction1)
  {
    return using(paramFunc0, paramFunc1, paramAction1, true);
  }
  
  public static <R> Completable using(Func0<R> paramFunc0, Func1<? super R, ? extends Completable> paramFunc1, Action1<? super R> paramAction1, boolean paramBoolean)
  {
    requireNonNull(paramFunc0);
    requireNonNull(paramFunc1);
    requireNonNull(paramAction1);
    return create(new Completable.13(paramFunc0, paramFunc1, paramAction1, paramBoolean));
  }
  
  public final Completable ambWith(Completable paramCompletable)
  {
    requireNonNull(paramCompletable);
    return amb(new Completable[] { this, paramCompletable });
  }
  
  public final <T> Observable<T> andThen(Observable<T> paramObservable)
  {
    requireNonNull(paramObservable);
    return paramObservable.delaySubscription(toObservable());
  }
  
  public final void await()
  {
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    Throwable[] arrayOfThrowable = new Throwable[1];
    subscribe(new Completable.14(this, localCountDownLatch, arrayOfThrowable));
    if (localCountDownLatch.getCount() == 0L) {
      if (arrayOfThrowable[0] != null) {
        Exceptions.propagate(arrayOfThrowable[0]);
      }
    }
    for (;;)
    {
      return;
      try
      {
        localCountDownLatch.await();
        if (arrayOfThrowable[0] == null) {
          continue;
        }
        Exceptions.propagate(arrayOfThrowable[0]);
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        throw Exceptions.propagate(localInterruptedException);
      }
    }
  }
  
  public final boolean await(long paramLong, TimeUnit paramTimeUnit)
  {
    boolean bool2 = true;
    requireNonNull(paramTimeUnit);
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    Throwable[] arrayOfThrowable = new Throwable[1];
    subscribe(new Completable.15(this, localCountDownLatch, arrayOfThrowable));
    boolean bool1;
    if (localCountDownLatch.getCount() == 0L)
    {
      bool1 = bool2;
      if (arrayOfThrowable[0] != null)
      {
        Exceptions.propagate(arrayOfThrowable[0]);
        bool1 = bool2;
      }
    }
    for (;;)
    {
      return bool1;
      try
      {
        bool2 = localCountDownLatch.await(paramLong, paramTimeUnit);
        bool1 = bool2;
        if (!bool2) {
          continue;
        }
        bool1 = bool2;
        if (arrayOfThrowable[0] == null) {
          continue;
        }
        Exceptions.propagate(arrayOfThrowable[0]);
        return bool2;
      }
      catch (InterruptedException paramTimeUnit)
      {
        throw Exceptions.propagate(paramTimeUnit);
      }
    }
  }
  
  public final Completable compose(Completable.CompletableTransformer paramCompletableTransformer)
  {
    return (Completable)to(paramCompletableTransformer);
  }
  
  public final Completable concatWith(Completable paramCompletable)
  {
    requireNonNull(paramCompletable);
    return concat(new Completable[] { this, paramCompletable });
  }
  
  public final Completable delay(long paramLong, TimeUnit paramTimeUnit)
  {
    return delay(paramLong, paramTimeUnit, Schedulers.computation(), false);
  }
  
  public final Completable delay(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    return delay(paramLong, paramTimeUnit, paramScheduler, false);
  }
  
  public final Completable delay(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler, boolean paramBoolean)
  {
    requireNonNull(paramTimeUnit);
    requireNonNull(paramScheduler);
    return create(new Completable.16(this, paramScheduler, paramLong, paramTimeUnit, paramBoolean));
  }
  
  public final Completable doAfterTerminate(Action0 paramAction0)
  {
    return doOnLifecycle(Actions.empty(), Actions.empty(), Actions.empty(), paramAction0, Actions.empty());
  }
  
  @Deprecated
  public final Completable doOnComplete(Action0 paramAction0)
  {
    return doOnCompleted(paramAction0);
  }
  
  public final Completable doOnCompleted(Action0 paramAction0)
  {
    return doOnLifecycle(Actions.empty(), Actions.empty(), paramAction0, Actions.empty(), Actions.empty());
  }
  
  public final Completable doOnError(Action1<? super Throwable> paramAction1)
  {
    return doOnLifecycle(Actions.empty(), paramAction1, Actions.empty(), Actions.empty(), Actions.empty());
  }
  
  protected final Completable doOnLifecycle(Action1<? super Subscription> paramAction1, Action1<? super Throwable> paramAction11, Action0 paramAction01, Action0 paramAction02, Action0 paramAction03)
  {
    requireNonNull(paramAction1);
    requireNonNull(paramAction11);
    requireNonNull(paramAction01);
    requireNonNull(paramAction02);
    requireNonNull(paramAction03);
    return create(new Completable.17(this, paramAction01, paramAction02, paramAction11, paramAction1, paramAction03));
  }
  
  public final Completable doOnSubscribe(Action1<? super Subscription> paramAction1)
  {
    return doOnLifecycle(paramAction1, Actions.empty(), Actions.empty(), Actions.empty(), Actions.empty());
  }
  
  public final Completable doOnTerminate(Action0 paramAction0)
  {
    return doOnLifecycle(Actions.empty(), new Completable.18(this, paramAction0), paramAction0, Actions.empty(), Actions.empty());
  }
  
  public final Completable doOnUnsubscribe(Action0 paramAction0)
  {
    return doOnLifecycle(Actions.empty(), Actions.empty(), Actions.empty(), Actions.empty(), paramAction0);
  }
  
  public final Completable endWith(Completable paramCompletable)
  {
    return concatWith(paramCompletable);
  }
  
  public final <T> Observable<T> endWith(Observable<T> paramObservable)
  {
    return paramObservable.startWith(toObservable());
  }
  
  public final Throwable get()
  {
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    Throwable[] arrayOfThrowable = new Throwable[1];
    subscribe(new Completable.19(this, localCountDownLatch, arrayOfThrowable));
    if (localCountDownLatch.getCount() == 0L) {
      return arrayOfThrowable[0];
    }
    try
    {
      localCountDownLatch.await();
      return arrayOfThrowable[0];
    }
    catch (InterruptedException localInterruptedException)
    {
      throw Exceptions.propagate(localInterruptedException);
    }
  }
  
  public final Throwable get(long paramLong, TimeUnit paramTimeUnit)
  {
    requireNonNull(paramTimeUnit);
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    Throwable[] arrayOfThrowable = new Throwable[1];
    subscribe(new Completable.20(this, localCountDownLatch, arrayOfThrowable));
    if (localCountDownLatch.getCount() == 0L) {
      return arrayOfThrowable[0];
    }
    try
    {
      boolean bool = localCountDownLatch.await(paramLong, paramTimeUnit);
      if (bool) {
        return arrayOfThrowable[0];
      }
    }
    catch (InterruptedException paramTimeUnit)
    {
      throw Exceptions.propagate(paramTimeUnit);
    }
    Exceptions.propagate(new TimeoutException());
    return null;
  }
  
  public final Completable lift(Completable.CompletableOperator paramCompletableOperator)
  {
    requireNonNull(paramCompletableOperator);
    return create(new Completable.21(this, paramCompletableOperator));
  }
  
  public final Completable mergeWith(Completable paramCompletable)
  {
    requireNonNull(paramCompletable);
    return merge(new Completable[] { this, paramCompletable });
  }
  
  public final Completable observeOn(Scheduler paramScheduler)
  {
    requireNonNull(paramScheduler);
    return create(new Completable.22(this, paramScheduler));
  }
  
  public final Completable onErrorComplete()
  {
    return onErrorComplete(UtilityFunctions.alwaysTrue());
  }
  
  public final Completable onErrorComplete(Func1<? super Throwable, Boolean> paramFunc1)
  {
    requireNonNull(paramFunc1);
    return create(new Completable.23(this, paramFunc1));
  }
  
  public final Completable onErrorResumeNext(Func1<? super Throwable, ? extends Completable> paramFunc1)
  {
    requireNonNull(paramFunc1);
    return create(new Completable.24(this, paramFunc1));
  }
  
  public final Completable repeat()
  {
    return fromObservable(toObservable().repeat());
  }
  
  public final Completable repeat(long paramLong)
  {
    return fromObservable(toObservable().repeat(paramLong));
  }
  
  public final Completable repeatWhen(Func1<? super Observable<? extends Void>, ? extends Observable<?>> paramFunc1)
  {
    requireNonNull(paramFunc1);
    return fromObservable(toObservable().repeatWhen(paramFunc1));
  }
  
  public final Completable retry()
  {
    return fromObservable(toObservable().retry());
  }
  
  public final Completable retry(long paramLong)
  {
    return fromObservable(toObservable().retry(paramLong));
  }
  
  public final Completable retry(Func2<Integer, Throwable, Boolean> paramFunc2)
  {
    return fromObservable(toObservable().retry(paramFunc2));
  }
  
  public final Completable retryWhen(Func1<? super Observable<? extends Throwable>, ? extends Observable<?>> paramFunc1)
  {
    return fromObservable(toObservable().retryWhen(paramFunc1));
  }
  
  public final Completable startWith(Completable paramCompletable)
  {
    requireNonNull(paramCompletable);
    return concat(new Completable[] { paramCompletable, this });
  }
  
  public final <T> Observable<T> startWith(Observable<T> paramObservable)
  {
    requireNonNull(paramObservable);
    return toObservable().startWith(paramObservable);
  }
  
  public final Subscription subscribe()
  {
    MultipleAssignmentSubscription localMultipleAssignmentSubscription = new MultipleAssignmentSubscription();
    subscribe(new Completable.25(this, localMultipleAssignmentSubscription));
    return localMultipleAssignmentSubscription;
  }
  
  public final Subscription subscribe(Action0 paramAction0)
  {
    requireNonNull(paramAction0);
    MultipleAssignmentSubscription localMultipleAssignmentSubscription = new MultipleAssignmentSubscription();
    subscribe(new Completable.26(this, paramAction0, localMultipleAssignmentSubscription));
    return localMultipleAssignmentSubscription;
  }
  
  public final Subscription subscribe(Action1<? super Throwable> paramAction1, Action0 paramAction0)
  {
    requireNonNull(paramAction1);
    requireNonNull(paramAction0);
    MultipleAssignmentSubscription localMultipleAssignmentSubscription = new MultipleAssignmentSubscription();
    subscribe(new Completable.27(this, paramAction0, localMultipleAssignmentSubscription, paramAction1));
    return localMultipleAssignmentSubscription;
  }
  
  public final void subscribe(Completable.CompletableSubscriber paramCompletableSubscriber)
  {
    requireNonNull(paramCompletableSubscriber);
    try
    {
      this.onSubscribe.call(paramCompletableSubscriber);
      return;
    }
    catch (NullPointerException paramCompletableSubscriber)
    {
      throw paramCompletableSubscriber;
    }
    catch (Throwable paramCompletableSubscriber)
    {
      ERROR_HANDLER.handleError(paramCompletableSubscriber);
      throw toNpe(paramCompletableSubscriber);
    }
  }
  
  public final <T> void subscribe(Subscriber<T> paramSubscriber)
  {
    requireNonNull(paramSubscriber);
    if (paramSubscriber == null) {}
    try
    {
      throw new NullPointerException("The RxJavaPlugins.onSubscribe returned a null Subscriber");
    }
    catch (NullPointerException paramSubscriber)
    {
      throw paramSubscriber;
      subscribe(new Completable.28(this, paramSubscriber));
      return;
    }
    catch (Throwable paramSubscriber)
    {
      ERROR_HANDLER.handleError(paramSubscriber);
      throw toNpe(paramSubscriber);
    }
  }
  
  public final Completable subscribeOn(Scheduler paramScheduler)
  {
    requireNonNull(paramScheduler);
    return create(new Completable.29(this, paramScheduler));
  }
  
  public final Completable timeout(long paramLong, TimeUnit paramTimeUnit)
  {
    return timeout0(paramLong, paramTimeUnit, Schedulers.computation(), null);
  }
  
  public final Completable timeout(long paramLong, TimeUnit paramTimeUnit, Completable paramCompletable)
  {
    requireNonNull(paramCompletable);
    return timeout0(paramLong, paramTimeUnit, Schedulers.computation(), paramCompletable);
  }
  
  public final Completable timeout(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    return timeout0(paramLong, paramTimeUnit, paramScheduler, null);
  }
  
  public final Completable timeout(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler, Completable paramCompletable)
  {
    requireNonNull(paramCompletable);
    return timeout0(paramLong, paramTimeUnit, paramScheduler, paramCompletable);
  }
  
  public final Completable timeout0(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler, Completable paramCompletable)
  {
    requireNonNull(paramTimeUnit);
    requireNonNull(paramScheduler);
    return create(new CompletableOnSubscribeTimeout(this, paramLong, paramTimeUnit, paramScheduler, paramCompletable));
  }
  
  public final <U> U to(Func1<? super Completable, U> paramFunc1)
  {
    return paramFunc1.call(this);
  }
  
  public final <T> Observable<T> toObservable()
  {
    return Observable.create(new Completable.30(this));
  }
  
  public final <T> Single<T> toSingle(Func0<? extends T> paramFunc0)
  {
    requireNonNull(paramFunc0);
    return Single.create(new Completable.31(this, paramFunc0));
  }
  
  public final <T> Single<T> toSingleDefault(T paramT)
  {
    requireNonNull(paramT);
    return toSingle(new Completable.32(this, paramT));
  }
  
  public final Completable unsubscribeOn(Scheduler paramScheduler)
  {
    requireNonNull(paramScheduler);
    return create(new Completable.33(this, paramScheduler));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rx.Completable
 * JD-Core Version:    0.7.0.1
 */