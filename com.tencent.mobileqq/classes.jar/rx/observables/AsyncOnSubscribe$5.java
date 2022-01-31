package rx.observables;

import rx.functions.Action0;
import rx.functions.Action1;

final class AsyncOnSubscribe$5
  implements Action1<Void>
{
  AsyncOnSubscribe$5(Action0 paramAction0) {}
  
  public void call(Void paramVoid)
  {
    this.val$onUnsubscribe.call();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rx.observables.AsyncOnSubscribe.5
 * JD-Core Version:    0.7.0.1
 */