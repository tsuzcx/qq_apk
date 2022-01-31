package rx.internal.util;

import rx.Single.OnSubscribe;
import rx.SingleSubscriber;

class ScalarSynchronousSingle$1
  implements Single.OnSubscribe<T>
{
  ScalarSynchronousSingle$1(Object paramObject) {}
  
  public void call(SingleSubscriber<? super T> paramSingleSubscriber)
  {
    paramSingleSubscriber.onSuccess(this.val$t);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     rx.internal.util.ScalarSynchronousSingle.1
 * JD-Core Version:    0.7.0.1
 */