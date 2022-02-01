package rx.internal.util;

import rx.Scheduler;
import rx.Single;
import rx.functions.Func1;
import rx.internal.schedulers.EventLoopsScheduler;

public final class ScalarSynchronousSingle<T>
  extends Single<T>
{
  final T value;
  
  protected ScalarSynchronousSingle(T paramT)
  {
    super(new ScalarSynchronousSingle.1(paramT));
    this.value = paramT;
  }
  
  public static final <T> ScalarSynchronousSingle<T> create(T paramT)
  {
    return new ScalarSynchronousSingle(paramT);
  }
  
  public T get()
  {
    return this.value;
  }
  
  public <R> Single<R> scalarFlatMap(Func1<? super T, ? extends Single<? extends R>> paramFunc1)
  {
    return create(new ScalarSynchronousSingle.2(this, paramFunc1));
  }
  
  public Single<T> scalarScheduleOn(Scheduler paramScheduler)
  {
    if ((paramScheduler instanceof EventLoopsScheduler)) {
      return create(new ScalarSynchronousSingle.DirectScheduledEmission((EventLoopsScheduler)paramScheduler, this.value));
    }
    return create(new ScalarSynchronousSingle.NormalScheduledEmission(paramScheduler, this.value));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.internal.util.ScalarSynchronousSingle
 * JD-Core Version:    0.7.0.1
 */