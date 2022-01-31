package rx;

class Completable$21
  implements Completable.CompletableOnSubscribe
{
  Completable$21(Completable paramCompletable, Completable.CompletableOperator paramCompletableOperator) {}
  
  public void call(Completable.CompletableSubscriber paramCompletableSubscriber)
  {
    try
    {
      paramCompletableSubscriber = (Completable.CompletableSubscriber)this.val$onLift.call(paramCompletableSubscriber);
      this.this$0.subscribe(paramCompletableSubscriber);
      return;
    }
    catch (NullPointerException paramCompletableSubscriber)
    {
      throw paramCompletableSubscriber;
    }
    catch (Throwable paramCompletableSubscriber)
    {
      throw Completable.toNpe(paramCompletableSubscriber);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.Completable.21
 * JD-Core Version:    0.7.0.1
 */