package rx.internal.operators;

import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.internal.producers.ProducerArbiter;
import rx.subscriptions.SerialSubscription;

final class OperatorSwitchIfEmpty$ParentSubscriber<T>
  extends Subscriber<T>
{
  private final Observable<? extends T> alternate;
  private final ProducerArbiter arbiter;
  private final Subscriber<? super T> child;
  private boolean empty = true;
  private final SerialSubscription ssub;
  
  OperatorSwitchIfEmpty$ParentSubscriber(Subscriber<? super T> paramSubscriber, SerialSubscription paramSerialSubscription, ProducerArbiter paramProducerArbiter, Observable<? extends T> paramObservable)
  {
    this.child = paramSubscriber;
    this.ssub = paramSerialSubscription;
    this.arbiter = paramProducerArbiter;
    this.alternate = paramObservable;
  }
  
  private void subscribeToAlternate()
  {
    OperatorSwitchIfEmpty.AlternateSubscriber localAlternateSubscriber = new OperatorSwitchIfEmpty.AlternateSubscriber(this.child, this.arbiter);
    this.ssub.set(localAlternateSubscriber);
    this.alternate.unsafeSubscribe(localAlternateSubscriber);
  }
  
  public void onCompleted()
  {
    if (!this.empty) {
      this.child.onCompleted();
    }
    while (this.child.isUnsubscribed()) {
      return;
    }
    subscribeToAlternate();
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.child.onError(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    this.empty = false;
    this.child.onNext(paramT);
    this.arbiter.produced(1L);
  }
  
  public void setProducer(Producer paramProducer)
  {
    this.arbiter.setProducer(paramProducer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rx.internal.operators.OperatorSwitchIfEmpty.ParentSubscriber
 * JD-Core Version:    0.7.0.1
 */