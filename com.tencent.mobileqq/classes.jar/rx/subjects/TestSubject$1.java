package rx.subjects;

import rx.functions.Action1;

final class TestSubject$1
  implements Action1<SubjectSubscriptionManager.SubjectObserver<T>>
{
  TestSubject$1(SubjectSubscriptionManager paramSubjectSubscriptionManager) {}
  
  public void call(SubjectSubscriptionManager.SubjectObserver<T> paramSubjectObserver)
  {
    paramSubjectObserver.emitFirst(this.val$state.getLatest(), this.val$state.nl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.subjects.TestSubject.1
 * JD-Core Version:    0.7.0.1
 */