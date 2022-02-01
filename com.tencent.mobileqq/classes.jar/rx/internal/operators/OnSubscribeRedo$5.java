package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import rx.Producer;
import rx.Scheduler.Worker;
import rx.functions.Action0;
import rx.internal.producers.ProducerArbiter;

class OnSubscribeRedo$5
  implements Producer
{
  OnSubscribeRedo$5(OnSubscribeRedo paramOnSubscribeRedo, AtomicLong paramAtomicLong, ProducerArbiter paramProducerArbiter, AtomicBoolean paramAtomicBoolean, Scheduler.Worker paramWorker, Action0 paramAction0) {}
  
  public void request(long paramLong)
  {
    if (paramLong > 0L)
    {
      BackpressureUtils.getAndAddRequest(this.val$consumerCapacity, paramLong);
      this.val$arbiter.request(paramLong);
      if (this.val$resumeBoundary.compareAndSet(true, false)) {
        this.val$worker.schedule(this.val$subscribeToSource);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rx.internal.operators.OnSubscribeRedo.5
 * JD-Core Version:    0.7.0.1
 */