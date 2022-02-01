package rx.subjects;

import java.util.concurrent.atomic.AtomicReference;
import rx.Observable.OnSubscribe;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Actions;
import rx.internal.operators.NotificationLite;
import rx.subscriptions.Subscriptions;

final class SubjectSubscriptionManager<T>
  extends AtomicReference<SubjectSubscriptionManager.State<T>>
  implements Observable.OnSubscribe<T>
{
  boolean active = true;
  volatile Object latest;
  public final NotificationLite<T> nl = NotificationLite.instance();
  Action1<SubjectSubscriptionManager.SubjectObserver<T>> onAdded = Actions.empty();
  Action1<SubjectSubscriptionManager.SubjectObserver<T>> onStart = Actions.empty();
  Action1<SubjectSubscriptionManager.SubjectObserver<T>> onTerminated = Actions.empty();
  
  public SubjectSubscriptionManager()
  {
    super(SubjectSubscriptionManager.State.EMPTY);
  }
  
  boolean add(SubjectSubscriptionManager.SubjectObserver<T> paramSubjectObserver)
  {
    SubjectSubscriptionManager.State localState;
    do
    {
      localState = (SubjectSubscriptionManager.State)get();
      if (localState.terminated)
      {
        this.onTerminated.call(paramSubjectObserver);
        return false;
      }
    } while (!compareAndSet(localState, localState.add(paramSubjectObserver)));
    this.onAdded.call(paramSubjectObserver);
    return true;
  }
  
  void addUnsubscriber(Subscriber<? super T> paramSubscriber, SubjectSubscriptionManager.SubjectObserver<T> paramSubjectObserver)
  {
    paramSubscriber.add(Subscriptions.create(new SubjectSubscriptionManager.1(this, paramSubjectObserver)));
  }
  
  public void call(Subscriber<? super T> paramSubscriber)
  {
    SubjectSubscriptionManager.SubjectObserver localSubjectObserver = new SubjectSubscriptionManager.SubjectObserver(paramSubscriber);
    addUnsubscriber(paramSubscriber, localSubjectObserver);
    this.onStart.call(localSubjectObserver);
    if ((!paramSubscriber.isUnsubscribed()) && (add(localSubjectObserver)) && (paramSubscriber.isUnsubscribed())) {
      remove(localSubjectObserver);
    }
  }
  
  Object getLatest()
  {
    return this.latest;
  }
  
  SubjectSubscriptionManager.SubjectObserver<T>[] next(Object paramObject)
  {
    setLatest(paramObject);
    return ((SubjectSubscriptionManager.State)get()).observers;
  }
  
  SubjectSubscriptionManager.SubjectObserver<T>[] observers()
  {
    return ((SubjectSubscriptionManager.State)get()).observers;
  }
  
  void remove(SubjectSubscriptionManager.SubjectObserver<T> paramSubjectObserver)
  {
    SubjectSubscriptionManager.State localState1;
    SubjectSubscriptionManager.State localState2;
    do
    {
      localState1 = (SubjectSubscriptionManager.State)get();
      if (localState1.terminated) {}
      do
      {
        return;
        localState2 = localState1.remove(paramSubjectObserver);
      } while (localState2 == localState1);
    } while (!compareAndSet(localState1, localState2));
  }
  
  void setLatest(Object paramObject)
  {
    this.latest = paramObject;
  }
  
  SubjectSubscriptionManager.SubjectObserver<T>[] terminate(Object paramObject)
  {
    setLatest(paramObject);
    this.active = false;
    if (((SubjectSubscriptionManager.State)get()).terminated) {
      return SubjectSubscriptionManager.State.NO_OBSERVERS;
    }
    return ((SubjectSubscriptionManager.State)getAndSet(SubjectSubscriptionManager.State.TERMINATED)).observers;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rx.subjects.SubjectSubscriptionManager
 * JD-Core Version:    0.7.0.1
 */