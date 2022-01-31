package rx.internal.operators;

import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Scheduler;
import rx.Scheduler.Worker;
import rx.Subscriber;

public final class OperatorSubscribeOn<T>
  implements Observable.OnSubscribe<T>
{
  final Scheduler scheduler;
  final Observable<T> source;
  
  public OperatorSubscribeOn(Observable<T> paramObservable, Scheduler paramScheduler)
  {
    this.scheduler = paramScheduler;
    this.source = paramObservable;
  }
  
  public void call(Subscriber<? super T> paramSubscriber)
  {
    Scheduler.Worker localWorker = this.scheduler.createWorker();
    paramSubscriber.add(localWorker);
    localWorker.schedule(new OperatorSubscribeOn.1(this, paramSubscriber, localWorker));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rx.internal.operators.OperatorSubscribeOn
 * JD-Core Version:    0.7.0.1
 */