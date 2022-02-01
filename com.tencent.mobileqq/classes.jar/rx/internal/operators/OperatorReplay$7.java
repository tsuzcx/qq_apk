package rx.internal.operators;

import java.util.concurrent.atomic.AtomicReference;
import rx.Observable.OnSubscribe;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Func0;

final class OperatorReplay$7
  implements Observable.OnSubscribe<T>
{
  OperatorReplay$7(AtomicReference paramAtomicReference, Func0 paramFunc0) {}
  
  public void call(Subscriber<? super T> paramSubscriber)
  {
    Object localObject1;
    do
    {
      localObject2 = (OperatorReplay.ReplaySubscriber)this.val$curr.get();
      localObject1 = localObject2;
      if (localObject2 != null) {
        break;
      }
      localObject1 = new OperatorReplay.ReplaySubscriber(this.val$curr, (OperatorReplay.ReplayBuffer)this.val$bufferFactory.call());
      ((OperatorReplay.ReplaySubscriber)localObject1).init();
    } while (!this.val$curr.compareAndSet(localObject2, localObject1));
    Object localObject2 = new OperatorReplay.InnerProducer((OperatorReplay.ReplaySubscriber)localObject1, paramSubscriber);
    ((OperatorReplay.ReplaySubscriber)localObject1).add((OperatorReplay.InnerProducer)localObject2);
    paramSubscriber.add((Subscription)localObject2);
    ((OperatorReplay.ReplaySubscriber)localObject1).buffer.replay((OperatorReplay.InnerProducer)localObject2);
    paramSubscriber.setProducer((Producer)localObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rx.internal.operators.OperatorReplay.7
 * JD-Core Version:    0.7.0.1
 */