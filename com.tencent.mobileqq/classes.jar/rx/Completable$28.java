package rx;

class Completable$28
  implements Completable.CompletableSubscriber
{
  Completable$28(Completable paramCompletable, Subscriber paramSubscriber) {}
  
  public void onCompleted()
  {
    this.val$sw.onCompleted();
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.val$sw.onError(paramThrowable);
  }
  
  public void onSubscribe(Subscription paramSubscription)
  {
    this.val$sw.add(paramSubscription);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     rx.Completable.28
 * JD-Core Version:    0.7.0.1
 */