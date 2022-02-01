package rx;

import rx.functions.Func1;

class Observable$24
  implements Func1<Observable<? extends Notification<?>>, Observable<?>>
{
  Observable$24(Observable paramObservable, Func1 paramFunc1) {}
  
  public Observable<?> call(Observable<? extends Notification<?>> paramObservable)
  {
    return (Observable)this.val$notificationHandler.call(paramObservable.map(new Observable.24.1(this)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rx.Observable.24
 * JD-Core Version:    0.7.0.1
 */