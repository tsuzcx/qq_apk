package rx.subjects;

import rx.functions.Action1;
import rx.internal.operators.NotificationLite;

final class AsyncSubject$1
  implements Action1<SubjectSubscriptionManager.SubjectObserver<T>>
{
  AsyncSubject$1(SubjectSubscriptionManager paramSubjectSubscriptionManager) {}
  
  public void call(SubjectSubscriptionManager.SubjectObserver<T> paramSubjectObserver)
  {
    Object localObject = this.val$state.getLatest();
    NotificationLite localNotificationLite = this.val$state.nl;
    paramSubjectObserver.accept(localObject, localNotificationLite);
    if ((localObject == null) || ((!localNotificationLite.isCompleted(localObject)) && (!localNotificationLite.isError(localObject)))) {
      paramSubjectObserver.onCompleted();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.subjects.AsyncSubject.1
 * JD-Core Version:    0.7.0.1
 */