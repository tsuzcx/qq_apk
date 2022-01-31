package rx;

import rx.functions.Func1;

class Observable$20
  implements Func1<Observable<T>, Observable<R>>
{
  Observable$20(Observable paramObservable, Func1 paramFunc1, Scheduler paramScheduler) {}
  
  public Observable<R> call(Observable<T> paramObservable)
  {
    return ((Observable)this.val$selector.call(paramObservable)).observeOn(this.val$scheduler);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rx.Observable.20
 * JD-Core Version:    0.7.0.1
 */