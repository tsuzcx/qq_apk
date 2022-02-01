package rx.internal.operators;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable.OnSubscribe;
import rx.Subscriber;
import rx.subjects.Subject;

class OperatorMulticast$1
  implements Observable.OnSubscribe<R>
{
  OperatorMulticast$1(Object paramObject, AtomicReference paramAtomicReference, List paramList) {}
  
  public void call(Subscriber<? super R> paramSubscriber)
  {
    synchronized (this.val$guard)
    {
      if (this.val$connectedSubject.get() == null)
      {
        this.val$waitingForConnect.add(paramSubscriber);
        return;
      }
      ((Subject)this.val$connectedSubject.get()).unsafeSubscribe(paramSubscriber);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rx.internal.operators.OperatorMulticast.1
 * JD-Core Version:    0.7.0.1
 */