package rx;

class Completable$11$1
  extends SingleSubscriber<Object>
{
  Completable$11$1(Completable.11 param11, Completable.CompletableSubscriber paramCompletableSubscriber) {}
  
  public void onError(Throwable paramThrowable)
  {
    this.val$s.onError(paramThrowable);
  }
  
  public void onSuccess(Object paramObject)
  {
    this.val$s.onCompleted();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.Completable.11.1
 * JD-Core Version:    0.7.0.1
 */