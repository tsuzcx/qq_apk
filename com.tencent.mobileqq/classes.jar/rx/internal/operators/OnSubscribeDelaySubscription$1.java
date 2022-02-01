package rx.internal.operators;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action0;
import rx.observers.Subscribers;

class OnSubscribeDelaySubscription$1
  implements Action0
{
  OnSubscribeDelaySubscription$1(OnSubscribeDelaySubscription paramOnSubscribeDelaySubscription, Subscriber paramSubscriber) {}
  
  public void call()
  {
    if (!this.val$s.isUnsubscribed()) {
      this.this$0.source.unsafeSubscribe(Subscribers.wrap(this.val$s));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.internal.operators.OnSubscribeDelaySubscription.1
 * JD-Core Version:    0.7.0.1
 */