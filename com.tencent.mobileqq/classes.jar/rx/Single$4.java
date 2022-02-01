package rx;

import java.util.concurrent.Callable;
import rx.exceptions.Exceptions;

final class Single$4
  implements Single.OnSubscribe<T>
{
  Single$4(Callable paramCallable) {}
  
  public void call(SingleSubscriber<? super T> paramSingleSubscriber)
  {
    try
    {
      Object localObject = this.val$func.call();
      paramSingleSubscriber.onSuccess(localObject);
      return;
    }
    catch (Throwable localThrowable)
    {
      Exceptions.throwIfFatal(localThrowable);
      paramSingleSubscriber.onError(localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     rx.Single.4
 * JD-Core Version:    0.7.0.1
 */