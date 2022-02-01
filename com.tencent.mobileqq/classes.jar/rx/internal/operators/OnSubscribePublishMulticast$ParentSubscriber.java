package rx.internal.operators;

import rx.Producer;
import rx.Subscriber;

final class OnSubscribePublishMulticast$ParentSubscriber<T>
  extends Subscriber<T>
{
  final OnSubscribePublishMulticast<T> state;
  
  public OnSubscribePublishMulticast$ParentSubscriber(OnSubscribePublishMulticast<T> paramOnSubscribePublishMulticast)
  {
    this.state = paramOnSubscribePublishMulticast;
  }
  
  public void onCompleted()
  {
    this.state.onCompleted();
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.state.onError(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    this.state.onNext(paramT);
  }
  
  public void setProducer(Producer paramProducer)
  {
    this.state.setProducer(paramProducer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     rx.internal.operators.OnSubscribePublishMulticast.ParentSubscriber
 * JD-Core Version:    0.7.0.1
 */