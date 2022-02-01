package rx;

import rx.functions.Action1;

class Observable$9
  implements Observer<T>
{
  Observable$9(Observable paramObservable, Action1 paramAction1) {}
  
  public final void onCompleted()
  {
    this.val$onNotification.call(Notification.createOnCompleted());
  }
  
  public final void onError(Throwable paramThrowable)
  {
    this.val$onNotification.call(Notification.createOnError(paramThrowable));
  }
  
  public final void onNext(T paramT)
  {
    this.val$onNotification.call(Notification.createOnNext(paramT));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rx.Observable.9
 * JD-Core Version:    0.7.0.1
 */