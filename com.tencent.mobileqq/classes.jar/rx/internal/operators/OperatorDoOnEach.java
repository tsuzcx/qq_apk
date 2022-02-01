package rx.internal.operators;

import rx.Observable.Operator;
import rx.Observer;
import rx.Subscriber;

public class OperatorDoOnEach<T>
  implements Observable.Operator<T, T>
{
  final Observer<? super T> doOnEachObserver;
  
  public OperatorDoOnEach(Observer<? super T> paramObserver)
  {
    this.doOnEachObserver = paramObserver;
  }
  
  public Subscriber<? super T> call(Subscriber<? super T> paramSubscriber)
  {
    return new OperatorDoOnEach.1(this, paramSubscriber, paramSubscriber);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     rx.internal.operators.OperatorDoOnEach
 * JD-Core Version:    0.7.0.1
 */