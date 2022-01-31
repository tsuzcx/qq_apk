package rx.subjects;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.Observable.OnSubscribe;
import rx.Scheduler;
import rx.annotations.Beta;
import rx.exceptions.Exceptions;
import rx.functions.Action1;
import rx.internal.operators.NotificationLite;
import rx.internal.util.UtilityFunctions;

public final class ReplaySubject<T>
  extends Subject<T, T>
{
  private static final Object[] EMPTY_ARRAY = new Object[0];
  final SubjectSubscriptionManager<T> ssm;
  final ReplaySubject.ReplayState<T, ?> state;
  
  ReplaySubject(Observable.OnSubscribe<T> paramOnSubscribe, SubjectSubscriptionManager<T> paramSubjectSubscriptionManager, ReplaySubject.ReplayState<T, ?> paramReplayState)
  {
    super(paramOnSubscribe);
    this.ssm = paramSubjectSubscriptionManager;
    this.state = paramReplayState;
  }
  
  private boolean caughtUp(SubjectSubscriptionManager.SubjectObserver<? super T> paramSubjectObserver)
  {
    boolean bool = true;
    if (!paramSubjectObserver.caughtUp)
    {
      if (this.state.replayObserver(paramSubjectObserver))
      {
        paramSubjectObserver.caughtUp = true;
        paramSubjectObserver.index(null);
      }
      bool = false;
    }
    return bool;
  }
  
  public static <T> ReplaySubject<T> create()
  {
    return create(16);
  }
  
  public static <T> ReplaySubject<T> create(int paramInt)
  {
    ReplaySubject.UnboundedReplayState localUnboundedReplayState = new ReplaySubject.UnboundedReplayState(paramInt);
    SubjectSubscriptionManager localSubjectSubscriptionManager = new SubjectSubscriptionManager();
    localSubjectSubscriptionManager.onStart = new ReplaySubject.1(localUnboundedReplayState);
    localSubjectSubscriptionManager.onAdded = new ReplaySubject.2(localUnboundedReplayState);
    localSubjectSubscriptionManager.onTerminated = new ReplaySubject.3(localUnboundedReplayState);
    return new ReplaySubject(localSubjectSubscriptionManager, localSubjectSubscriptionManager, localUnboundedReplayState);
  }
  
  static <T> ReplaySubject<T> createUnbounded()
  {
    ReplaySubject.BoundedState localBoundedState = new ReplaySubject.BoundedState(new ReplaySubject.EmptyEvictionPolicy(), UtilityFunctions.identity(), UtilityFunctions.identity());
    return createWithState(localBoundedState, new ReplaySubject.DefaultOnAdd(localBoundedState));
  }
  
  public static <T> ReplaySubject<T> createWithSize(int paramInt)
  {
    ReplaySubject.BoundedState localBoundedState = new ReplaySubject.BoundedState(new ReplaySubject.SizeEvictionPolicy(paramInt), UtilityFunctions.identity(), UtilityFunctions.identity());
    return createWithState(localBoundedState, new ReplaySubject.DefaultOnAdd(localBoundedState));
  }
  
  static <T> ReplaySubject<T> createWithState(ReplaySubject.BoundedState<T> paramBoundedState, Action1<SubjectSubscriptionManager.SubjectObserver<T>> paramAction1)
  {
    SubjectSubscriptionManager localSubjectSubscriptionManager = new SubjectSubscriptionManager();
    localSubjectSubscriptionManager.onStart = paramAction1;
    localSubjectSubscriptionManager.onAdded = new ReplaySubject.4(paramBoundedState);
    localSubjectSubscriptionManager.onTerminated = new ReplaySubject.5(paramBoundedState);
    return new ReplaySubject(localSubjectSubscriptionManager, localSubjectSubscriptionManager, paramBoundedState);
  }
  
  public static <T> ReplaySubject<T> createWithTime(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    paramTimeUnit = new ReplaySubject.BoundedState(new ReplaySubject.TimeEvictionPolicy(paramTimeUnit.toMillis(paramLong), paramScheduler), new ReplaySubject.AddTimestamped(paramScheduler), new ReplaySubject.RemoveTimestamped());
    return createWithState(paramTimeUnit, new ReplaySubject.TimedOnAdd(paramTimeUnit, paramScheduler));
  }
  
  public static <T> ReplaySubject<T> createWithTimeAndSize(long paramLong, TimeUnit paramTimeUnit, int paramInt, Scheduler paramScheduler)
  {
    paramTimeUnit = new ReplaySubject.BoundedState(new ReplaySubject.PairEvictionPolicy(new ReplaySubject.SizeEvictionPolicy(paramInt), new ReplaySubject.TimeEvictionPolicy(paramTimeUnit.toMillis(paramLong), paramScheduler)), new ReplaySubject.AddTimestamped(paramScheduler), new ReplaySubject.RemoveTimestamped());
    return createWithState(paramTimeUnit, new ReplaySubject.TimedOnAdd(paramTimeUnit, paramScheduler));
  }
  
  @Beta
  public Throwable getThrowable()
  {
    NotificationLite localNotificationLite = this.ssm.nl;
    Object localObject = this.ssm.getLatest();
    if (localNotificationLite.isError(localObject)) {
      return localNotificationLite.getError(localObject);
    }
    return null;
  }
  
  @Beta
  public T getValue()
  {
    return this.state.latest();
  }
  
  @Beta
  public Object[] getValues()
  {
    Object[] arrayOfObject2 = getValues((Object[])EMPTY_ARRAY);
    Object[] arrayOfObject1 = arrayOfObject2;
    if (arrayOfObject2 == EMPTY_ARRAY) {
      arrayOfObject1 = new Object[0];
    }
    return arrayOfObject1;
  }
  
  @Beta
  public T[] getValues(T[] paramArrayOfT)
  {
    return this.state.toArray(paramArrayOfT);
  }
  
  @Beta
  public boolean hasAnyValue()
  {
    return !this.state.isEmpty();
  }
  
  @Beta
  public boolean hasCompleted()
  {
    NotificationLite localNotificationLite = this.ssm.nl;
    Object localObject = this.ssm.getLatest();
    return (localObject != null) && (!localNotificationLite.isError(localObject));
  }
  
  public boolean hasObservers()
  {
    return this.ssm.observers().length > 0;
  }
  
  @Beta
  public boolean hasThrowable()
  {
    return this.ssm.nl.isError(this.ssm.getLatest());
  }
  
  @Beta
  public boolean hasValue()
  {
    return hasAnyValue();
  }
  
  public void onCompleted()
  {
    if (this.ssm.active)
    {
      this.state.complete();
      SubjectSubscriptionManager.SubjectObserver[] arrayOfSubjectObserver = this.ssm.terminate(NotificationLite.instance().completed());
      int j = arrayOfSubjectObserver.length;
      int i = 0;
      while (i < j)
      {
        SubjectSubscriptionManager.SubjectObserver localSubjectObserver = arrayOfSubjectObserver[i];
        if (caughtUp(localSubjectObserver)) {
          localSubjectObserver.onCompleted();
        }
        i += 1;
      }
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    if (this.ssm.active)
    {
      this.state.error(paramThrowable);
      SubjectSubscriptionManager.SubjectObserver[] arrayOfSubjectObserver = this.ssm.terminate(NotificationLite.instance().error(paramThrowable));
      int j = arrayOfSubjectObserver.length;
      int i = 0;
      Object localObject2;
      for (Object localObject1 = null;; localObject1 = localObject2)
      {
        if (i >= j) {
          break label123;
        }
        SubjectSubscriptionManager.SubjectObserver localSubjectObserver = arrayOfSubjectObserver[i];
        localObject2 = localObject1;
        try
        {
          if (caughtUp(localSubjectObserver))
          {
            localSubjectObserver.onError(paramThrowable);
            localObject2 = localObject1;
          }
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            localObject2 = localObject1;
            if (localObject1 == null) {
              localObject2 = new ArrayList();
            }
            ((List)localObject2).add(localThrowable);
          }
        }
        i += 1;
      }
      label123:
      Exceptions.throwIfAny(localObject1);
    }
  }
  
  public void onNext(T paramT)
  {
    if (this.ssm.active)
    {
      this.state.next(paramT);
      SubjectSubscriptionManager.SubjectObserver[] arrayOfSubjectObserver = this.ssm.observers();
      int j = arrayOfSubjectObserver.length;
      int i = 0;
      while (i < j)
      {
        SubjectSubscriptionManager.SubjectObserver localSubjectObserver = arrayOfSubjectObserver[i];
        if (caughtUp(localSubjectObserver)) {
          localSubjectObserver.onNext(paramT);
        }
        i += 1;
      }
    }
  }
  
  @Beta
  public int size()
  {
    return this.state.size();
  }
  
  int subscriberCount()
  {
    return ((SubjectSubscriptionManager.State)this.ssm.get()).observers.length;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rx.subjects.ReplaySubject
 * JD-Core Version:    0.7.0.1
 */