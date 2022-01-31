package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.Observable;
import rx.Observable.Operator;
import rx.Subscriber;
import rx.observers.SerializedSubscriber;

public final class OperatorSkipUntil<T, U>
  implements Observable.Operator<T, T>
{
  final Observable<U> other;
  
  public OperatorSkipUntil(Observable<U> paramObservable)
  {
    this.other = paramObservable;
  }
  
  public Subscriber<? super T> call(Subscriber<? super T> paramSubscriber)
  {
    SerializedSubscriber localSerializedSubscriber = new SerializedSubscriber(paramSubscriber);
    AtomicBoolean localAtomicBoolean = new AtomicBoolean();
    OperatorSkipUntil.1 local1 = new OperatorSkipUntil.1(this, localAtomicBoolean, localSerializedSubscriber);
    paramSubscriber.add(local1);
    this.other.unsafeSubscribe(local1);
    return new OperatorSkipUntil.2(this, paramSubscriber, localAtomicBoolean, localSerializedSubscriber);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.internal.operators.OperatorSkipUntil
 * JD-Core Version:    0.7.0.1
 */