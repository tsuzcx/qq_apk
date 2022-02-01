package rx.subjects;

import rx.Scheduler;
import rx.functions.Action1;

final class ReplaySubject$TimedOnAdd<T>
  implements Action1<SubjectSubscriptionManager.SubjectObserver<T>>
{
  final Scheduler scheduler;
  final ReplaySubject.BoundedState<T> state;
  
  public ReplaySubject$TimedOnAdd(ReplaySubject.BoundedState<T> paramBoundedState, Scheduler paramScheduler)
  {
    this.state = paramBoundedState;
    this.scheduler = paramScheduler;
  }
  
  public void call(SubjectSubscriptionManager.SubjectObserver<T> paramSubjectObserver)
  {
    Object localObject;
    if (!this.state.terminated)
    {
      localObject = this.state;
      localObject = ((ReplaySubject.BoundedState)localObject).replayObserverFromIndexTest(((ReplaySubject.BoundedState)localObject).head(), paramSubjectObserver, this.scheduler.now());
    }
    else
    {
      localObject = this.state;
      localObject = ((ReplaySubject.BoundedState)localObject).replayObserverFromIndex(((ReplaySubject.BoundedState)localObject).head(), paramSubjectObserver);
    }
    paramSubjectObserver.index(localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.subjects.ReplaySubject.TimedOnAdd
 * JD-Core Version:    0.7.0.1
 */