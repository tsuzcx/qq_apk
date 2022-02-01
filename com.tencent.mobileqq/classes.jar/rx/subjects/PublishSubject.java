package rx.subjects;

import java.util.ArrayList;
import java.util.List;
import rx.Observable.OnSubscribe;
import rx.annotations.Beta;
import rx.exceptions.Exceptions;
import rx.internal.operators.NotificationLite;

public final class PublishSubject<T>
  extends Subject<T, T>
{
  private final NotificationLite<T> nl = NotificationLite.instance();
  final SubjectSubscriptionManager<T> state;
  
  protected PublishSubject(Observable.OnSubscribe<T> paramOnSubscribe, SubjectSubscriptionManager<T> paramSubjectSubscriptionManager)
  {
    super(paramOnSubscribe);
    this.state = paramSubjectSubscriptionManager;
  }
  
  public static <T> PublishSubject<T> create()
  {
    SubjectSubscriptionManager localSubjectSubscriptionManager = new SubjectSubscriptionManager();
    localSubjectSubscriptionManager.onTerminated = new PublishSubject.1(localSubjectSubscriptionManager);
    return new PublishSubject(localSubjectSubscriptionManager, localSubjectSubscriptionManager);
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
  public boolean hasCompleted()
  {
    Object localObject = this.state.getLatest();
    return (localObject != null) && (!this.nl.isError(localObject));
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
  
  public void onCompleted()
  {
    if (this.state.active)
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
    if (this.state.active)
    {
      Object localObject2 = this.nl.error(paramThrowable);
      SubjectSubscriptionManager.SubjectObserver[] arrayOfSubjectObserver = this.state.terminate(localObject2);
      int j = arrayOfSubjectObserver.length;
      int i = 0;
      paramThrowable = null;
      for (;;)
      {
        if (i < j)
        {
          Object localObject1 = arrayOfSubjectObserver[i];
          try
          {
            ((SubjectSubscriptionManager.SubjectObserver)localObject1).emitNext(localObject2, this.state.nl);
            i += 1;
          }
          catch (Throwable localThrowable)
          {
            for (;;)
            {
              localObject1 = paramThrowable;
              if (paramThrowable == null) {
                localObject1 = new ArrayList();
              }
              ((List)localObject1).add(localThrowable);
              paramThrowable = (Throwable)localObject1;
            }
          }
        }
      }
      Exceptions.throwIfAny(paramThrowable);
    }
  }
  
  public void onNext(T paramT)
  {
    SubjectSubscriptionManager.SubjectObserver[] arrayOfSubjectObserver = this.state.observers();
    int j = arrayOfSubjectObserver.length;
    int i = 0;
    while (i < j)
    {
      arrayOfSubjectObserver[i].onNext(paramT);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     rx.subjects.PublishSubject
 * JD-Core Version:    0.7.0.1
 */