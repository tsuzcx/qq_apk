package rx.internal.operators;

import rx.Observable;
import rx.Observer;

final class OperatorWindowWithTime$State<T>
{
  static final State<Object> EMPTY = new State(null, null, 0);
  final Observer<T> consumer;
  final int count;
  final Observable<T> producer;
  
  public OperatorWindowWithTime$State(Observer<T> paramObserver, Observable<T> paramObservable, int paramInt)
  {
    this.consumer = paramObserver;
    this.producer = paramObservable;
    this.count = paramInt;
  }
  
  public static <T> State<T> empty()
  {
    return EMPTY;
  }
  
  public State<T> clear()
  {
    return empty();
  }
  
  public State<T> create(Observer<T> paramObserver, Observable<T> paramObservable)
  {
    return new State(paramObserver, paramObservable, 0);
  }
  
  public State<T> next()
  {
    return new State(this.consumer, this.producer, this.count + 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rx.internal.operators.OperatorWindowWithTime.State
 * JD-Core Version:    0.7.0.1
 */