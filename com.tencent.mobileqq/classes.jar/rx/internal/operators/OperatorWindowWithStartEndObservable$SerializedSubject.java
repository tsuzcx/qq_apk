package rx.internal.operators;

import rx.Observable;
import rx.Observer;
import rx.observers.SerializedObserver;

final class OperatorWindowWithStartEndObservable$SerializedSubject<T>
{
  final Observer<T> consumer;
  final Observable<T> producer;
  
  public OperatorWindowWithStartEndObservable$SerializedSubject(Observer<T> paramObserver, Observable<T> paramObservable)
  {
    this.consumer = new SerializedObserver(paramObserver);
    this.producer = paramObservable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     rx.internal.operators.OperatorWindowWithStartEndObservable.SerializedSubject
 * JD-Core Version:    0.7.0.1
 */