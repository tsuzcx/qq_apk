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
    paramSubjectObserver.index(this.state.replayObserverFromIndex(this.state.head(), paramSubjectObserver));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.subjects.ReplaySubject.DefaultOnAdd
 * JD-Core Version:    0.7.0.1
 */