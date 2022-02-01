package rx;

import java.util.Arrays;
import rx.exceptions.CompositeException;
import rx.functions.Func1;
import rx.subscriptions.SerialSubscription;

class Completable$24$1
  implements Completable.CompletableSubscriber
{
  Completable$24$1(Completable.24 param24, Completable.CompletableSubscriber paramCompletableSubscriber, SerialSubscription paramSerialSubscription) {}
  
  public void onCompleted()
  {
    this.val$s.onCompleted();
  }
  
  public void onError(Throwable paramThrowable)
  {
    try
    {
      Completable localCompletable = (Completable)this.this$1.val$errorMapper.call(paramThrowable);
      if (localCompletable == null)
      {
        paramThrowable = new CompositeException(Arrays.asList(new Throwable[] { paramThrowable, new NullPointerException("The completable returned is null") }));
        this.val$s.onError(paramThrowable);
        return;
      }
      localCompletable.subscribe(new Completable.24.1.1(this));
      return;
    }
    catch (Throwable localThrowable)
    {
      paramThrowable = new CompositeException(Arrays.asList(new Throwable[] { paramThrowable, localThrowable }));
      this.val$s.onError(paramThrowable);
    }
  }
  
  public void onSubscribe(Subscription paramSubscription)
  {
    this.val$sd.set(paramSubscription);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.Completable.24.1
 * JD-Core Version:    0.7.0.1
 */