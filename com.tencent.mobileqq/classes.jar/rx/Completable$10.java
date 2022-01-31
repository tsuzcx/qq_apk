package rx;

final class Completable$10
  implements Completable.CompletableOnSubscribe
{
  Completable$10(Observable paramObservable) {}
  
  public void call(Completable.CompletableSubscriber paramCompletableSubscriber)
  {
    Completable.10.1 local1 = new Completable.10.1(this, paramCompletableSubscriber);
    paramCompletableSubscriber.onSubscribe(local1);
    this.val$flowable.unsafeSubscribe(local1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rx.Completable.10
 * JD-Core Version:    0.7.0.1
 */