package rx;

import rx.internal.producers.SingleProducer;

class Observable$7
  implements Observable.OnSubscribe<T>
{
  Observable$7(Observable paramObservable, Object paramObject) {}
  
  public void call(Subscriber<? super T> paramSubscriber)
  {
    paramSubscriber.setProducer(new SingleProducer(paramSubscriber, this.val$defaultValue));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     rx.Observable.7
 * JD-Core Version:    0.7.0.1
 */