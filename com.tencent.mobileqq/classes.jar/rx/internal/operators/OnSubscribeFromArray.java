package rx.internal.operators;

import rx.Observable.OnSubscribe;
import rx.Subscriber;

public final class OnSubscribeFromArray<T>
  implements Observable.OnSubscribe<T>
{
  final T[] array;
  
  public OnSubscribeFromArray(T[] paramArrayOfT)
  {
    this.array = paramArrayOfT;
  }
  
  public void call(Subscriber<? super T> paramSubscriber)
  {
    paramSubscriber.setProducer(new OnSubscribeFromArray.FromArrayProducer(paramSubscriber, this.array));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     rx.internal.operators.OnSubscribeFromArray
 * JD-Core Version:    0.7.0.1
 */