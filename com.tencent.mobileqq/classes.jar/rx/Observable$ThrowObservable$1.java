package rx;

class Observable$ThrowObservable$1
  implements Observable.OnSubscribe<T>
{
  Observable$ThrowObservable$1(Throwable paramThrowable) {}
  
  public void call(Subscriber<? super T> paramSubscriber)
  {
    paramSubscriber.onError(this.val$exception);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.Observable.ThrowObservable.1
 * JD-Core Version:    0.7.0.1
 */