package rx.internal.operators;

import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Observable.Operator;
import rx.Subscriber;
import rx.Subscription;
import rx.observers.SerializedSubscriber;

public final class OperatorSampleWithObservable<T, U>
  implements Observable.Operator<T, T>
{
  static final Object EMPTY_TOKEN = new Object();
  final Observable<U> sampler;
  
  public OperatorSampleWithObservable(Observable<U> paramObservable)
  {
    this.sampler = paramObservable;
  }
  
  public Subscriber<? super T> call(Subscriber<? super T> paramSubscriber)
  {
    Object localObject = new SerializedSubscriber(paramSubscriber);
    AtomicReference localAtomicReference2 = new AtomicReference(EMPTY_TOKEN);
    AtomicReference localAtomicReference1 = new AtomicReference();
    OperatorSampleWithObservable.1 local1 = new OperatorSampleWithObservable.1(this, localAtomicReference2, (SerializedSubscriber)localObject, localAtomicReference1);
    localObject = new OperatorSampleWithObservable.2(this, localAtomicReference2, (SerializedSubscriber)localObject, local1);
    localAtomicReference1.lazySet(localObject);
    paramSubscriber.add((Subscription)localObject);
    paramSubscriber.add(local1);
    this.sampler.unsafeSubscribe(local1);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rx.internal.operators.OperatorSampleWithObservable
 * JD-Core Version:    0.7.0.1
 */