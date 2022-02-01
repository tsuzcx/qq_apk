package rx;

import rx.functions.Action0;
import rx.internal.util.SubscriptionList;

class Completable$22$1$1
  implements Action0
{
  Completable$22$1$1(Completable.22.1 param1) {}
  
  public void call()
  {
    try
    {
      this.this$2.val$s.onCompleted();
      return;
    }
    finally
    {
      this.this$2.val$ad.unsubscribe();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rx.Completable.22.1.1
 * JD-Core Version:    0.7.0.1
 */