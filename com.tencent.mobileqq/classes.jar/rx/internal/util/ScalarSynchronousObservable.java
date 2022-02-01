package rx.internal.util;

import rx.Observable;
import rx.Producer;
import rx.Scheduler;
import rx.Subscriber;
import rx.functions.Func1;
import rx.internal.producers.SingleProducer;
import rx.internal.schedulers.EventLoopsScheduler;

public final class ScalarSynchronousObservable<T>
  extends Observable<T>
{
  static final boolean STRONG_MODE = Boolean.valueOf(System.getProperty("rx.just.strong-mode", "false")).booleanValue();
  final T t;
  
  protected ScalarSynchronousObservable(T paramT)
  {
    super(new ScalarSynchronousObservable.1(paramT));
    this.t = paramT;
  }
  
  public static <T> ScalarSynchronousObservable<T> create(T paramT)
  {
    return new ScalarSynchronousObservable(paramT);
  }
  
  static <T> Producer createProducer(Subscriber<? super T> paramSubscriber, T paramT)
  {
    if (STRONG_MODE) {
      return new SingleProducer(paramSubscriber, paramT);
    }
    return new ScalarSynchronousObservable.WeakSingleProducer(paramSubscriber, paramT);
  }
  
  public T get()
  {
    return this.t;
  }
  
  public <R> Observable<R> scalarFlatMap(Func1<? super T, ? extends Observable<? extends R>> paramFunc1)
  {
    return create(new ScalarSynchronousObservable.4(this, paramFunc1));
  }
  
  public Observable<T> scalarScheduleOn(Scheduler paramScheduler)
  {
    if ((paramScheduler instanceof EventLoopsScheduler)) {
      paramScheduler = new ScalarSynchronousObservable.2(this, (EventLoopsScheduler)paramScheduler);
    } else {
      paramScheduler = new ScalarSynchronousObservable.3(this, paramScheduler);
    }
    return create(new ScalarSynchronousObservable.ScalarAsyncOnSubscribe(this.t, paramScheduler));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.internal.util.ScalarSynchronousObservable
 * JD-Core Version:    0.7.0.1
 */