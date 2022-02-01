package rx.internal.operators;

import rx.Observable;
import rx.Observer;
import rx.observers.SerializedObserver;

final class OperatorWindowWithTime$CountedSerializedSubject<T>
{
  final Observer<T> consumer;
  int count;
  final Observable<T> producer;
  
  public OperatorWindowWithTime$CountedSerializedSubject(Observer<T> paramObserver, Observable<T> paramObservable)
  {
    this.consumer = new SerializedObserver(paramObserver);
    this.producer = paramObservable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.internal.operators.OperatorWindowWithTime.CountedSerializedSubject
 * JD-Core Version:    0.7.0.1
 */