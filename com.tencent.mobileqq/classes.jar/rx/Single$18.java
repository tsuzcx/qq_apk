package rx;

class Single$18
  extends Subscriber<T>
{
  Single$18(Single paramSingle, SingleSubscriber paramSingleSubscriber) {}
  
  public void onCompleted() {}
  
  public void onError(Throwable paramThrowable)
  {
    this.val$te.onError(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    this.val$te.onSuccess(paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rx.Single.18
 * JD-Core Version:    0.7.0.1
 */