package rx;

import rx.internal.producers.SingleDelayedProducer;

class Single$1$1
  extends SingleSubscriber<T>
{
  Single$1$1(Single.1 param1, SingleDelayedProducer paramSingleDelayedProducer, Subscriber paramSubscriber) {}
  
  public void onError(Throwable paramThrowable)
  {
    this.val$child.onError(paramThrowable);
  }
  
  public void onSuccess(T paramT)
  {
    this.val$producer.setValue(paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rx.Single.1.1
 * JD-Core Version:    0.7.0.1
 */