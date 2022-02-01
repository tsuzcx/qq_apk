package rx;

import rx.functions.Action0;
import rx.functions.Action1;

class Completable$17
  implements Completable.CompletableOnSubscribe
{
  Completable$17(Completable paramCompletable, Action0 paramAction01, Action0 paramAction02, Action1 paramAction11, Action1 paramAction12, Action0 paramAction03) {}
  
  public void call(Completable.CompletableSubscriber paramCompletableSubscriber)
  {
    this.this$0.subscribe(new Completable.17.1(this, paramCompletableSubscriber));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rx.Completable.17
 * JD-Core Version:    0.7.0.1
 */