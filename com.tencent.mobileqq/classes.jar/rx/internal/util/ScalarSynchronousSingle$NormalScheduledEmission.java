package rx.internal.util;

import rx.Scheduler;
import rx.Scheduler.Worker;
import rx.Single.OnSubscribe;
import rx.SingleSubscriber;

final class ScalarSynchronousSingle$NormalScheduledEmission<T>
  implements Single.OnSubscribe<T>
{
  private final Scheduler scheduler;
  private final T value;
  
  ScalarSynchronousSingle$NormalScheduledEmission(Scheduler paramScheduler, T paramT)
  {
    this.scheduler = paramScheduler;
    this.value = paramT;
  }
  
  public void call(SingleSubscriber<? super T> paramSingleSubscriber)
  {
    Scheduler.Worker localWorker = this.scheduler.createWorker();
    paramSingleSubscriber.add(localWorker);
    localWorker.schedule(new ScalarSynchronousSingle.ScalarSynchronousSingleAction(paramSingleSubscriber, this.value));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.internal.util.ScalarSynchronousSingle.NormalScheduledEmission
 * JD-Core Version:    0.7.0.1
 */