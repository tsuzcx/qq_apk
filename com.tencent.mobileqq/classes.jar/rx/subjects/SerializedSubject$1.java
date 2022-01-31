package rx.subjects;

import rx.Observable.OnSubscribe;
import rx.Subscriber;

class SerializedSubject$1
  implements Observable.OnSubscribe<R>
{
  SerializedSubject$1(Subject paramSubject) {}
  
  public void call(Subscriber<? super R> paramSubscriber)
  {
    this.val$actual.unsafeSubscribe(paramSubscriber);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rx.subjects.SerializedSubject.1
 * JD-Core Version:    0.7.0.1
 */