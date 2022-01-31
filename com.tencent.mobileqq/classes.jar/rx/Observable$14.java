package rx;

import rx.functions.Func1;

class Observable$14
  implements Func1<Observable<? extends Notification<?>>, Observable<?>>
{
  Observable$14(Observable paramObservable, Func1 paramFunc1) {}
  
  public Observable<?> call(Observable<? extends Notification<?>> paramObservable)
  {
    return (Observable)this.val$notificationHandler.call(paramObservable.map(new Observable.14.1(this)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     rx.Observable.14
 * JD-Core Version:    0.7.0.1
 */