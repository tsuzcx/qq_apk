package rx.observables;

import rx.Observer;
import rx.functions.Action1;
import rx.functions.Func2;

final class SyncOnSubscribe$3
  implements Func2<Void, Observer<? super T>, Void>
{
  SyncOnSubscribe$3(Action1 paramAction1) {}
  
  public Void call(Void paramVoid, Observer<? super T> paramObserver)
  {
    this.val$next.call(paramObserver);
    return paramVoid;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     rx.observables.SyncOnSubscribe.3
 * JD-Core Version:    0.7.0.1
 */