package rx;

final class Completable$11
  implements Completable.CompletableOnSubscribe
{
  Completable$11(Single paramSingle) {}
  
  public void call(Completable.CompletableSubscriber paramCompletableSubscriber)
  {
    Completable.11.1 local1 = new Completable.11.1(this, paramCompletableSubscriber);
    paramCompletableSubscriber.onSubscribe(local1);
    this.val$single.subscribe(local1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     rx.Completable.11
 * JD-Core Version:    0.7.0.1
 */