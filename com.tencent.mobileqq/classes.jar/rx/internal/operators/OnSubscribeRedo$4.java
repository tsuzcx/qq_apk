package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Scheduler.Worker;
import rx.Subscriber;
import rx.functions.Action0;

class OnSubscribeRedo$4
  implements Action0
{
  OnSubscribeRedo$4(OnSubscribeRedo paramOnSubscribeRedo, Observable paramObservable, Subscriber paramSubscriber, AtomicLong paramAtomicLong, Scheduler.Worker paramWorker, Action0 paramAction0, AtomicBoolean paramAtomicBoolean) {}
  
  public void call()
  {
    this.val$restarts.unsafeSubscribe(new OnSubscribeRedo.4.1(this, this.val$child));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rx.internal.operators.OnSubscribeRedo.4
 * JD-Core Version:    0.7.0.1
 */