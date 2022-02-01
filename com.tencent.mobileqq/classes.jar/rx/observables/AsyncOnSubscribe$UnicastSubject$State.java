package rx.observables;

import rx.Observable.OnSubscribe;
import rx.Subscriber;

final class AsyncOnSubscribe$UnicastSubject$State<T>
  implements Observable.OnSubscribe<T>
{
  Subscriber<? super T> subscriber;
  
  public void call(Subscriber<? super T> paramSubscriber)
  {
    try
    {
      if (this.subscriber == null)
      {
        this.subscriber = paramSubscriber;
        return;
      }
      paramSubscriber.onError(new IllegalStateException("There can be only one subscriber"));
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     rx.observables.AsyncOnSubscribe.UnicastSubject.State
 * JD-Core Version:    0.7.0.1
 */