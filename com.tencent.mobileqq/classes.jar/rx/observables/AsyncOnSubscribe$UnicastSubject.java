package rx.observables;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;

final class AsyncOnSubscribe$UnicastSubject<T>
  extends Observable<T>
  implements Observer<T>
{
  private AsyncOnSubscribe.UnicastSubject.State<T> state;
  
  protected AsyncOnSubscribe$UnicastSubject(AsyncOnSubscribe.UnicastSubject.State<T> paramState)
  {
    super(paramState);
    this.state = paramState;
  }
  
  public static <T> UnicastSubject<T> create()
  {
    return new UnicastSubject(new AsyncOnSubscribe.UnicastSubject.State());
  }
  
  public void onCompleted()
  {
    this.state.subscriber.onCompleted();
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.state.subscriber.onError(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    this.state.subscriber.onNext(paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.observables.AsyncOnSubscribe.UnicastSubject
 * JD-Core Version:    0.7.0.1
 */