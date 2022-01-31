package rx.internal.util;

import rx.SingleSubscriber;
import rx.functions.Action0;

final class ScalarSynchronousSingle$ScalarSynchronousSingleAction<T>
  implements Action0
{
  private final SingleSubscriber<? super T> subscriber;
  private final T value;
  
  ScalarSynchronousSingle$ScalarSynchronousSingleAction(SingleSubscriber<? super T> paramSingleSubscriber, T paramT)
  {
    this.subscriber = paramSingleSubscriber;
    this.value = paramT;
  }
  
  public void call()
  {
    try
    {
      this.subscriber.onSuccess(this.value);
      return;
    }
    catch (Throwable localThrowable)
    {
      this.subscriber.onError(localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.internal.util.ScalarSynchronousSingle.ScalarSynchronousSingleAction
 * JD-Core Version:    0.7.0.1
 */