package rx;

class Completable$10$1
  extends Subscriber<Object>
{
  Completable$10$1(Completable.10 param10, Completable.CompletableSubscriber paramCompletableSubscriber) {}
  
  public void onCompleted()
  {
    this.val$cs.onCompleted();
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.val$cs.onError(paramThrowable);
  }
  
  public void onNext(Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rx.Completable.10.1
 * JD-Core Version:    0.7.0.1
 */