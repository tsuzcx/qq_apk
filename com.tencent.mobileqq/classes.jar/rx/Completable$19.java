package rx;

import java.util.concurrent.CountDownLatch;

class Completable$19
  implements Completable.CompletableSubscriber
{
  Completable$19(Completable paramCompletable, CountDownLatch paramCountDownLatch, Throwable[] paramArrayOfThrowable) {}
  
  public void onCompleted()
  {
    this.val$cdl.countDown();
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.val$err[0] = paramThrowable;
    this.val$cdl.countDown();
  }
  
  public void onSubscribe(Subscription paramSubscription) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.Completable.19
 * JD-Core Version:    0.7.0.1
 */