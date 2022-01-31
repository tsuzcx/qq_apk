package rx;

import rx.functions.Action0;
import rx.internal.util.SubscriptionList;

class Completable$22$1$2
  implements Action0
{
  Completable$22$1$2(Completable.22.1 param1, Throwable paramThrowable) {}
  
  public void call()
  {
    try
    {
      this.this$2.val$s.onError(this.val$e);
      return;
    }
    finally
    {
      this.this$2.val$ad.unsubscribe();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     rx.Completable.22.1.2
 * JD-Core Version:    0.7.0.1
 */