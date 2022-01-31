package rx.observables;

import rx.Observable;
import rx.Observer;
import rx.functions.Action3;
import rx.functions.Func3;

final class AsyncOnSubscribe$1
  implements Func3<S, Long, Observer<Observable<? extends T>>, S>
{
  AsyncOnSubscribe$1(Action3 paramAction3) {}
  
  public S call(S paramS, Long paramLong, Observer<Observable<? extends T>> paramObserver)
  {
    this.val$next.call(paramS, paramLong, paramObserver);
    return paramS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     rx.observables.AsyncOnSubscribe.1
 * JD-Core Version:    0.7.0.1
 */