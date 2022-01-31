package rx.internal.operators;

import rx.Completable.CompletableSubscriber;
import rx.Subscription;
import rx.subscriptions.SerialSubscription;

final class CompletableOnSubscribeConcat$CompletableConcatSubscriber$ConcatInnerSubscriber
  implements Completable.CompletableSubscriber
{
  CompletableOnSubscribeConcat$CompletableConcatSubscriber$ConcatInnerSubscriber(CompletableOnSubscribeConcat.CompletableConcatSubscriber paramCompletableConcatSubscriber) {}
  
  public void onCompleted()
  {
    this.this$0.innerComplete();
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.this$0.innerError(paramThrowable);
  }
  
  public void onSubscribe(Subscription paramSubscription)
  {
    this.this$0.sr.set(paramSubscription);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.internal.operators.CompletableOnSubscribeConcat.CompletableConcatSubscriber.ConcatInnerSubscriber
 * JD-Core Version:    0.7.0.1
 */