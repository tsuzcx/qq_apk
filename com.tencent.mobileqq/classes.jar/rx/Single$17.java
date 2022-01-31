package rx;

class Single$17
  extends SingleSubscriber<T>
{
  Single$17(Single paramSingle, Observer paramObserver) {}
  
  public void onError(Throwable paramThrowable)
  {
    this.val$observer.onError(paramThrowable);
  }
  
  public void onSuccess(T paramT)
  {
    this.val$observer.onNext(paramT);
    this.val$observer.onCompleted();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rx.Single.17
 * JD-Core Version:    0.7.0.1
 */