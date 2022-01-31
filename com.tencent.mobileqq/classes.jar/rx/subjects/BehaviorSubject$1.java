package rx.subjects;

import rx.functions.Action1;

final class BehaviorSubject$1
  implements Action1<SubjectSubscriptionManager.SubjectObserver<T>>
{
  BehaviorSubject$1(SubjectSubscriptionManager paramSubjectSubscriptionManager) {}
  
  public void call(SubjectSubscriptionManager.SubjectObserver<T> paramSubjectObserver)
  {
    paramSubjectObserver.emitFirst(this.val$state.getLatest(), this.val$state.nl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rx.subjects.BehaviorSubject.1
 * JD-Core Version:    0.7.0.1
 */