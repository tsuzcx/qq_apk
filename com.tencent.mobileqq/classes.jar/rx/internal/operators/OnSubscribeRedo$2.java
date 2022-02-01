package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Action0;
import rx.internal.producers.ProducerArbiter;
import rx.subjects.BehaviorSubject;
import rx.subscriptions.SerialSubscription;

class OnSubscribeRedo$2
  implements Action0
{
  OnSubscribeRedo$2(OnSubscribeRedo paramOnSubscribeRedo, Subscriber paramSubscriber, BehaviorSubject paramBehaviorSubject, ProducerArbiter paramProducerArbiter, AtomicLong paramAtomicLong, SerialSubscription paramSerialSubscription) {}
  
  public void call()
  {
    if (this.val$child.isUnsubscribed()) {
      return;
    }
    OnSubscribeRedo.2.1 local1 = new OnSubscribeRedo.2.1(this);
    this.val$sourceSubscriptions.set(local1);
    this.this$0.source.unsafeSubscribe(local1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     rx.internal.operators.OnSubscribeRedo.2
 * JD-Core Version:    0.7.0.1
 */