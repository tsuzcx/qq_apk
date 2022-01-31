package rx.internal.operators;

import rx.Completable.CompletableSubscriber;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

class CompletableOnSubscribeTimeout$1$1
  implements Completable.CompletableSubscriber
{
  CompletableOnSubscribeTimeout$1$1(CompletableOnSubscribeTimeout.1 param1) {}
  
  public void onCompleted()
  {
    this.this$1.val$set.unsubscribe();
    this.this$1.val$s.onCompleted();
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.this$1.val$set.unsubscribe();
    this.this$1.val$s.onError(paramThrowable);
  }
  
  public void onSubscribe(Subscription paramSubscription)
  {
    this.this$1.val$set.add(paramSubscription);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     rx.internal.operators.CompletableOnSubscribeTimeout.1.1
 * JD-Core Version:    0.7.0.1
 */