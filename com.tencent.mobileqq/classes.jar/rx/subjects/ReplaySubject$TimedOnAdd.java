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
    if (!this.state.terminated) {}
    for (ReplaySubject.NodeList.Node localNode = this.state.replayObserverFromIndexTest(this.state.head(), paramSubjectObserver, this.scheduler.now());; localNode = this.state.replayObserverFromIndex(this.state.head(), paramSubjectObserver))
    {
      paramSubjectObserver.index(localNode);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.subjects.ReplaySubject.TimedOnAdd
 * JD-Core Version:    0.7.0.1
 */