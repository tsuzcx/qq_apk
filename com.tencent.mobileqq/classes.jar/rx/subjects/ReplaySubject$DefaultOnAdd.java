package rx.subjects;

import rx.functions.Action1;

final class ReplaySubject$DefaultOnAdd<T>
  implements Action1<SubjectSubscriptionManager.SubjectObserver<T>>
{
  final ReplaySubject.BoundedState<T> state;
  
  public ReplaySubject$DefaultOnAdd(ReplaySubject.BoundedState<T> paramBoundedState)
  {
    this.state = paramBoundedState;
  }
  
  public void call(SubjectSubscriptionManager.SubjectObserver<T> paramSubjectObserver)
  {
    ReplaySubject.BoundedState localBoundedState = this.state;
    paramSubjectObserver.index(localBoundedState.replayObserverFromIndex(localBoundedState.head(), paramSubjectObserver));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.subjects.ReplaySubject.DefaultOnAdd
 * JD-Core Version:    0.7.0.1
 */