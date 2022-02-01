package rx.internal.util;

import rx.Observable.OnSubscribe;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action0;
import rx.functions.Func1;

final class ScalarSynchronousObservable$ScalarAsyncOnSubscribe<T>
  implements Observable.OnSubscribe<T>
{
  final Func1<Action0, Subscription> onSchedule;
  final T value;
  
  ScalarSynchronousObservable$ScalarAsyncOnSubscribe(T paramT, Func1<Action0, Subscription> paramFunc1)
  {
    this.value = paramT;
    this.onSchedule = paramFunc1;
  }
  
  public void call(Subscriber<? super T> paramSubscriber)
  {
    paramSubscriber.setProducer(new ScalarSynchronousObservable.ScalarAsyncProducer(paramSubscriber, this.value, this.onSchedule));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rx.internal.util.ScalarSynchronousObservable.ScalarAsyncOnSubscribe
 * JD-Core Version:    0.7.0.1
 */