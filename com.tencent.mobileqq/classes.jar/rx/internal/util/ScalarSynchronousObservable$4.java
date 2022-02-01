package rx.internal.util;

import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Subscriber;
import rx.functions.Func1;
import rx.observers.Subscribers;

class ScalarSynchronousObservable$4
  implements Observable.OnSubscribe<R>
{
  ScalarSynchronousObservable$4(ScalarSynchronousObservable paramScalarSynchronousObservable, Func1 paramFunc1) {}
  
  public void call(Subscriber<? super R> paramSubscriber)
  {
    Observable localObservable = (Observable)this.val$func.call(this.this$0.t);
    if ((localObservable instanceof ScalarSynchronousObservable))
    {
      paramSubscriber.setProducer(ScalarSynchronousObservable.createProducer(paramSubscriber, ((ScalarSynchronousObservable)localObservable).t));
      return;
    }
    localObservable.unsafeSubscribe(Subscribers.wrap(paramSubscriber));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     rx.internal.util.ScalarSynchronousObservable.4
 * JD-Core Version:    0.7.0.1
 */