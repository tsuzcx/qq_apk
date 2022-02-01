package rx.internal.operators;

import rx.Observable;
import rx.Observable.Operator;
import rx.Subscriber;
import rx.observers.SerializedSubscriber;

public final class OperatorTakeUntil<T, E>
  implements Observable.Operator<T, T>
{
  private final Observable<? extends E> other;
  
  public OperatorTakeUntil(Observable<? extends E> paramObservable)
  {
    this.other = paramObservable;
  }
  
  public Subscriber<? super T> call(Subscriber<? super T> paramSubscriber)
  {
    SerializedSubscriber localSerializedSubscriber = new SerializedSubscriber(paramSubscriber, false);
    OperatorTakeUntil.1 local1 = new OperatorTakeUntil.1(this, localSerializedSubscriber, false, localSerializedSubscriber);
    OperatorTakeUntil.2 local2 = new OperatorTakeUntil.2(this, local1);
    localSerializedSubscriber.add(local1);
    localSerializedSubscriber.add(local2);
    paramSubscriber.add(localSerializedSubscriber);
    this.other.unsafeSubscribe(local2);
    return local1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.internal.operators.OperatorTakeUntil
 * JD-Core Version:    0.7.0.1
 */