package rx.subjects;

import rx.functions.Action1;

final class ReplaySubject$1
  implements Action1<SubjectSubscriptionManager.SubjectObserver<T>>
{
  ReplaySubject$1(ReplaySubject.UnboundedReplayState paramUnboundedReplayState) {}
  
  public void call(SubjectSubscriptionManager.SubjectObserver<T> paramSubjectObserver)
  {
    paramSubjectObserver.index(Integer.valueOf(this.val$state.replayObserverFromIndex(Integer.valueOf(0), paramSubjectObserver).intValue()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.subjects.ReplaySubject.1
 * JD-Core Version:    0.7.0.1
 */