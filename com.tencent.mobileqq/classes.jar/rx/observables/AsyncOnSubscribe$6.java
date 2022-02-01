package rx.observables;

import rx.Producer;
import rx.Subscriber;

class AsyncOnSubscribe$6
  extends Subscriber<T>
{
  AsyncOnSubscribe$6(AsyncOnSubscribe paramAsyncOnSubscribe, Subscriber paramSubscriber, AsyncOnSubscribe.AsyncOuterManager paramAsyncOuterManager) {}
  
  public void onCompleted()
  {
    this.val$actualSubscriber.onCompleted();
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.val$actualSubscriber.onError(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    this.val$actualSubscriber.onNext(paramT);
  }
  
  public void setProducer(Producer paramProducer)
  {
    this.val$outerProducer.setConcatProducer(paramProducer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.observables.AsyncOnSubscribe.6
 * JD-Core Version:    0.7.0.1
 */