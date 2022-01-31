package rx;

class Observable$30
  extends Subscriber<T>
{
  Observable$30(Observable paramObservable, Observer paramObserver) {}
  
  public void onCompleted()
  {
    this.val$observer.onCompleted();
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.val$observer.onError(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    this.val$observer.onNext(paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.Observable.30
 * JD-Core Version:    0.7.0.1
 */