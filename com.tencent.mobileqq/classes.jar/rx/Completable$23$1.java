package rx;

import java.util.Arrays;
import rx.exceptions.CompositeException;
import rx.functions.Func1;

class Completable$23$1
  implements Completable.CompletableSubscriber
{
  Completable$23$1(Completable.23 param23, Completable.CompletableSubscriber paramCompletableSubscriber) {}
  
  public void onCompleted()
  {
    this.val$s.onCompleted();
  }
  
  public void onError(Throwable paramThrowable)
  {
    try
    {
      boolean bool = ((Boolean)this.this$1.val$predicate.call(paramThrowable)).booleanValue();
      if (bool)
      {
        this.val$s.onCompleted();
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      new CompositeException(Arrays.asList(new Throwable[] { paramThrowable, localThrowable }));
      return;
    }
    this.val$s.onError(paramThrowable);
  }
  
  public void onSubscribe(Subscription paramSubscription)
  {
    this.val$s.onSubscribe(paramSubscription);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     rx.Completable.23.1
 * JD-Core Version:    0.7.0.1
 */