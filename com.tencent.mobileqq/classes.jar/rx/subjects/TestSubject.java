package rx.subjects;

import java.util.concurrent.TimeUnit;
import rx.Observable.OnSubscribe;
import rx.Observer;
import rx.Scheduler.Worker;
import rx.internal.operators.NotificationLite;
import rx.schedulers.TestScheduler;

public final class TestSubject<T>
  extends Subject<T, T>
{
  private final Scheduler.Worker innerScheduler;
  private final SubjectSubscriptionManager<T> state;
  
  protected TestSubject(Observable.OnSubscribe<T> paramOnSubscribe, SubjectSubscriptionManager<T> paramSubjectSubscriptionManager, TestScheduler paramTestScheduler)
  {
    super(paramOnSubscribe);
    this.state = paramSubjectSubscriptionManager;
    this.innerScheduler = paramTestScheduler.createWorker();
  }
  
  public static <T> TestSubject<T> create(TestScheduler paramTestScheduler)
  {
    SubjectSubscriptionManager localSubjectSubscriptionManager = new SubjectSubscriptionManager();
    localSubjectSubscriptionManager.onAdded = new TestSubject.1(localSubjectSubscriptionManager);
    localSubjectSubscriptionManager.onTerminated = localSubjectSubscriptionManager.onAdded;
    return new TestSubject(localSubjectSubscriptionManager, localSubjectSubscriptionManager, paramTestScheduler);
  }
  
  void _onCompleted()
  {
    if (this.state.active)
    {
      SubjectSubscriptionManager.SubjectObserver[] arrayOfSubjectObserver = this.state.terminate(NotificationLite.instance().completed());
      int j = arrayOfSubjectObserver.length;
      int i = 0;
      while (i < j)
      {
        arrayOfSubjectObserver[i].onCompleted();
        i += 1;
      }
    }
  }
  
  void _onError(Throwable paramThrowable)
  {
    if (this.state.active)
    {
      SubjectSubscriptionManager.SubjectObserver[] arrayOfSubjectObserver = this.state.terminate(NotificationLite.instance().error(paramThrowable));
      int j = arrayOfSubjectObserver.length;
      int i = 0;
      while (i < j)
      {
        arrayOfSubjectObserver[i].onError(paramThrowable);
        i += 1;
      }
    }
  }
  
  void _onNext(T paramT)
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
  
  public boolean hasObservers()
  {
    return this.state.observers().length > 0;
  }
  
  public void onCompleted()
  {
    onCompleted(0L);
  }
  
  public void onCompleted(long paramLong)
  {
    this.innerScheduler.schedule(new TestSubject.2(this), paramLong, TimeUnit.MILLISECONDS);
  }
  
  public void onError(Throwable paramThrowable)
  {
    onError(paramThrowable, 0L);
  }
  
  public void onError(Throwable paramThrowable, long paramLong)
  {
    this.innerScheduler.schedule(new TestSubject.3(this, paramThrowable), paramLong, TimeUnit.MILLISECONDS);
  }
  
  public void onNext(T paramT)
  {
    onNext(paramT, 0L);
  }
  
  public void onNext(T paramT, long paramLong)
  {
    this.innerScheduler.schedule(new TestSubject.4(this, paramT), paramLong, TimeUnit.MILLISECONDS);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.subjects.TestSubject
 * JD-Core Version:    0.7.0.1
 */