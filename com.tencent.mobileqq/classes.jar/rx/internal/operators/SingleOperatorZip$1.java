package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import rx.Single;
import rx.Single.OnSubscribe;
import rx.SingleSubscriber;
import rx.functions.FuncN;
import rx.subscriptions.CompositeSubscription;

final class SingleOperatorZip$1
  implements Single.OnSubscribe<R>
{
  SingleOperatorZip$1(Single[] paramArrayOfSingle, FuncN paramFuncN) {}
  
  public void call(SingleSubscriber<? super R> paramSingleSubscriber)
  {
    AtomicInteger localAtomicInteger = new AtomicInteger(this.val$singles.length);
    AtomicBoolean localAtomicBoolean = new AtomicBoolean();
    Object[] arrayOfObject = new Object[this.val$singles.length];
    CompositeSubscription localCompositeSubscription = new CompositeSubscription();
    paramSingleSubscriber.add(localCompositeSubscription);
    int i = 0;
    for (;;)
    {
      if ((i >= this.val$singles.length) || (localCompositeSubscription.isUnsubscribed()) || (localAtomicBoolean.get())) {}
      SingleOperatorZip.1.1 local1;
      do
      {
        return;
        local1 = new SingleOperatorZip.1.1(this, arrayOfObject, i, localAtomicInteger, paramSingleSubscriber, localAtomicBoolean);
        localCompositeSubscription.add(local1);
      } while ((localCompositeSubscription.isUnsubscribed()) || (localAtomicBoolean.get()));
      this.val$singles[i].subscribe(local1);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.internal.operators.SingleOperatorZip.1
 * JD-Core Version:    0.7.0.1
 */