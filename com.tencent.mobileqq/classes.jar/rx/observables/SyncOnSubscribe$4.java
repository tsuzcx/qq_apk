package rx.observables;

import rx.Observer;
import rx.functions.Action1;
import rx.functions.Func2;

final class SyncOnSubscribe$4
  implements Func2<Void, Observer<? super T>, Void>
{
  SyncOnSubscribe$4(Action1 paramAction1) {}
  
  public Void call(Void paramVoid, Observer<? super T> paramObserver)
  {
    this.val$next.call(paramObserver);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     rx.observables.SyncOnSubscribe.4
 * JD-Core Version:    0.7.0.1
 */