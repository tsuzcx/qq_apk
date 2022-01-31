package rx.internal.util;

import rx.Single.OnSubscribe;
import rx.SingleSubscriber;
import rx.internal.schedulers.EventLoopsScheduler;

final class ScalarSynchronousSingle$DirectScheduledEmission<T>
  implements Single.OnSubscribe<T>
{
  private final EventLoopsScheduler es;
  private final T value;
  
  ScalarSynchronousSingle$DirectScheduledEmission(EventLoopsScheduler paramEventLoopsScheduler, T paramT)
  {
    this.es = paramEventLoopsScheduler;
    this.value = paramT;
  }
  
  public void call(SingleSubscriber<? super T> paramSingleSubscriber)
  {
    paramSingleSubscriber.add(this.es.scheduleDirect(new ScalarSynchronousSingle.ScalarSynchronousSingleAction(paramSingleSubscriber, this.value)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rx.internal.util.ScalarSynchronousSingle.DirectScheduledEmission
 * JD-Core Version:    0.7.0.1
 */