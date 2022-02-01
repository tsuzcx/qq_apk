package rx.subjects;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import rx.Observable.OnSubscribe;
import rx.annotations.Beta;
import rx.exceptions.Exceptions;
import rx.internal.operators.NotificationLite;

public final class BehaviorSubject<T>
  extends Subject<T, T>
{
  private static final Object[] EMPTY_ARRAY = new Object[0];
  private final NotificationLite<T> nl = NotificationLite.instance();
  private final SubjectSubscriptionManager<T> state;
  
  protected BehaviorSubject(Observable.OnSubscribe<T> paramOnSubscribe, SubjectSubscriptionManager<T> paramSubjectSubscriptionManager)
  {
    super(paramOnSubscribe);
    this.state = paramSubjectSubscriptionManager;
  }
  
  public static <T> BehaviorSubject<T> create()
  {
    return create(null, false);
  }
  
  public static <T> BehaviorSubject<T> create(T paramT)
  {
    return create(paramT, true);
  }
  
  private static <T> BehaviorSubject<T> create(T paramT, boolean paramBoolean)
  {
    SubjectSubscriptionManager localSubjectSubscriptionManager = new SubjectSubscriptionManager();
    if (paramBoolean) {
      localSubjectSubscriptionManager.setLatest(NotificationLite.instance().next(paramT));
    }
    localSubjectSubscriptionManager.onAdded = new BehaviorSubject.1(localSubjectSubscriptionManager);
    localSubjectSubscriptionManager.onTerminated = localSubjectSubscriptionManager.onAdded;
    return new BehaviorSubject(localSubjectSubscriptionManager, localSubjectSubscriptionManager);
  }
  
  @Beta
  public Throwable getThrowable()
  {
    Object localObject = this.state.getLatest();
    if (this.nl.isError(localObject)) {
      return this.nl.getError(localObject);
    }
    return null;
  }
  
  @Beta
  public T getValue()
  {
    Object localObject = this.state.getLatest();
    if (this.nl.isNext(localObject)) {
      return this.nl.getValue(localObject);
    }
    return null;
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
    Object localObject2 = this.state.getLatest();
    if (this.nl.isNext(localObject2))
    {
      Object localObject1 = paramArrayOfT;
      if (paramArrayOfT.length == 0) {
        localObject1 = (Object[])Array.newInstance(paramArrayOfT.getClass().getComponentType(), 1);
      }
      localObject1[0] = this.nl.getValue(localObject2);
      localObject2 = localObject1;
      if (localObject1.length > 1)
      {
        localObject1[1] = null;
        return localObject1;
      }
    }
    else
    {
      localObject2 = paramArrayOfT;
      if (paramArrayOfT.length > 0)
      {
        paramArrayOfT[0] = null;
        localObject2 = paramArrayOfT;
      }
    }
    return localObject2;
  }
  
  @Beta
  public boolean hasCompleted()
  {
    Object localObject = this.state.getLatest();
    return this.nl.isCompleted(localObject);
  }
  
  public boolean hasObservers()
  {
    return this.state.observers().length > 0;
  }
  
  @Beta
  public boolean hasThrowable()
  {
    Object localObject = this.state.getLatest();
    return this.nl.isError(localObject);
  }
  
  @Beta
  public boolean hasValue()
  {
    Object localObject = this.state.getLatest();
    return this.nl.isNext(localObject);
  }
  
  public void onCompleted()
  {
    if ((this.state.getLatest() == null) || (this.state.active))
    {
      Object localObject = this.nl.completed();
      SubjectSubscriptionManager.SubjectObserver[] arrayOfSubjectObserver = this.state.terminate(localObject);
      int j = arrayOfSubjectObserver.length;
      int i = 0;
      while (i < j)
      {
        arrayOfSubjectObserver[i].emitNext(localObject, this.state.nl);
        i += 1;
      }
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    if ((this.state.getLatest() == null) || (this.state.active))
    {
      Object localObject2 = this.nl.error(paramThrowable);
      paramThrowable = null;
      SubjectSubscriptionManager.SubjectObserver[] arrayOfSubjectObserver = this.state.terminate(localObject2);
      int j = arrayOfSubjectObserver.length;
      int i = 0;
      while (i < j)
      {
        Object localObject1 = arrayOfSubjectObserver[i];
        try
        {
          ((SubjectSubscriptionManager.SubjectObserver)localObject1).emitNext(localObject2, this.state.nl);
        }
        catch (Throwable localThrowable)
        {
          localObject1 = paramThrowable;
          if (paramThrowable == null) {
            localObject1 = new ArrayList();
          }
          ((List)localObject1).add(localThrowable);
          paramThrowable = (Throwable)localObject1;
        }
        i += 1;
      }
      Exceptions.throwIfAny(paramThrowable);
    }
  }
  
  public void onNext(T paramT)
  {
    if ((this.state.getLatest() == null) || (this.state.active))
    {
      paramT = this.nl.next(paramT);
      SubjectSubscriptionManager.SubjectObserver[] arrayOfSubjectObserver = this.state.next(paramT);
      int j = arrayOfSubjectObserver.length;
      int i = 0;
      while (i < j)
      {
        arrayOfSubjectObserver[i].emitNext(paramT, this.state.nl);
        i += 1;
      }
    }
  }
  
  int subscriberCount()
  {
    return this.state.observers().length;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.subjects.BehaviorSubject
 * JD-Core Version:    0.7.0.1
 */