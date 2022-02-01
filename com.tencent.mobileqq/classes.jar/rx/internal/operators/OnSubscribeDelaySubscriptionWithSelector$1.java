package rx.internal.operators;

import rx.Observable;
import rx.Subscriber;
import rx.observers.Subscribers;

class OnSubscribeDelaySubscriptionWithSelector$1
  extends Subscriber<U>
{
  OnSubscribeDelaySubscriptionWithSelector$1(OnSubscribeDelaySubscriptionWithSelector paramOnSubscribeDelaySubscriptionWithSelector, Subscriber paramSubscriber) {}
  
  public void onCompleted()
  {
    this.this$0.source.unsafeSubscribe(Subscribers.wrap(this.val$child));
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.val$child.onError(paramThrowable);
  }
  
  public void onNext(U paramU) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.internal.operators.OnSubscribeDelaySubscriptionWithSelector.1
 * JD-Core Version:    0.7.0.1
 */