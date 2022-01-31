package rx.subjects;

import rx.functions.Action1;

final class ReplaySubject$3
  implements Action1<SubjectSubscriptionManager.SubjectObserver<T>>
{
  ReplaySubject$3(ReplaySubject.UnboundedReplayState paramUnboundedReplayState) {}
  
  public void call(SubjectSubscriptionManager.SubjectObserver<T> paramSubjectObserver)
  {
    Integer localInteger2 = (Integer)paramSubjectObserver.index();
    Integer localInteger1 = localInteger2;
    if (localInteger2 == null) {
      localInteger1 = Integer.valueOf(0);
    }
    this.val$state.replayObserverFromIndex(localInteger1, paramSubjectObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     rx.subjects.ReplaySubject.3
 * JD-Core Version:    0.7.0.1
 */