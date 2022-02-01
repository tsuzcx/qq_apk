package rx;

class Single$5$1
  extends SingleSubscriber<Single<? extends T>>
{
  Single$5$1(Single.5 param5, SingleSubscriber paramSingleSubscriber) {}
  
  public void onError(Throwable paramThrowable)
  {
    this.val$child.onError(paramThrowable);
  }
  
  public void onSuccess(Single<? extends T> paramSingle)
  {
    paramSingle.subscribe(this.val$child);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     rx.Single.5.1
 * JD-Core Version:    0.7.0.1
 */