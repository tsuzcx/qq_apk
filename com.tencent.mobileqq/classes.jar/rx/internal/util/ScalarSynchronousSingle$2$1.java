package rx.internal.util;

import rx.SingleSubscriber;
import rx.Subscriber;

class ScalarSynchronousSingle$2$1
  extends Subscriber<R>
{
  ScalarSynchronousSingle$2$1(ScalarSynchronousSingle.2 param2, SingleSubscriber paramSingleSubscriber) {}
  
  public void onCompleted() {}
  
  public void onError(Throwable paramThrowable)
  {
    this.val$child.onError(paramThrowable);
  }
  
  public void onNext(R paramR)
  {
    this.val$child.onSuccess(paramR);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rx.internal.util.ScalarSynchronousSingle.2.1
 * JD-Core Version:    0.7.0.1
 */