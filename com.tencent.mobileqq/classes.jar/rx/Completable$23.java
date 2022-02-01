package rx;

import rx.functions.Func1;

class Completable$23
  implements Completable.CompletableOnSubscribe
{
  Completable$23(Completable paramCompletable, Func1 paramFunc1) {}
  
  public void call(Completable.CompletableSubscriber paramCompletableSubscriber)
  {
    this.this$0.subscribe(new Completable.23.1(this, paramCompletableSubscriber));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     rx.Completable.23
 * JD-Core Version:    0.7.0.1
 */