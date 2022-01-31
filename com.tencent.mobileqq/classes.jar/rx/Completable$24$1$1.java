package rx;

import rx.subscriptions.SerialSubscription;

class Completable$24$1$1
  implements Completable.CompletableSubscriber
{
  Completable$24$1$1(Completable.24.1 param1) {}
  
  public void onCompleted()
  {
    this.this$2.val$s.onCompleted();
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.this$2.val$s.onError(paramThrowable);
  }
  
  public void onSubscribe(Subscription paramSubscription)
  {
    this.this$2.val$sd.set(paramSubscription);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rx.Completable.24.1.1
 * JD-Core Version:    0.7.0.1
 */