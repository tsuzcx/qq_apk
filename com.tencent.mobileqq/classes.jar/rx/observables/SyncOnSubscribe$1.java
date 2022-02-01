package rx.observables;

import rx.Observer;
import rx.functions.Action2;
import rx.functions.Func2;

final class SyncOnSubscribe$1
  implements Func2<S, Observer<? super T>, S>
{
  SyncOnSubscribe$1(Action2 paramAction2) {}
  
  public S call(S paramS, Observer<? super T> paramObserver)
  {
    this.val$next.call(paramS, paramObserver);
    return paramS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.observables.SyncOnSubscribe.1
 * JD-Core Version:    0.7.0.1
 */