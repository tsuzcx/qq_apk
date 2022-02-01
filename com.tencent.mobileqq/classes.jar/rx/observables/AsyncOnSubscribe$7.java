package rx.observables;

import rx.Observable;
import rx.functions.Func1;

class AsyncOnSubscribe$7
  implements Func1<Observable<T>, Observable<T>>
{
  AsyncOnSubscribe$7(AsyncOnSubscribe paramAsyncOnSubscribe) {}
  
  public Observable<T> call(Observable<T> paramObservable)
  {
    return paramObservable.onBackpressureBuffer();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rx.observables.AsyncOnSubscribe.7
 * JD-Core Version:    0.7.0.1
 */