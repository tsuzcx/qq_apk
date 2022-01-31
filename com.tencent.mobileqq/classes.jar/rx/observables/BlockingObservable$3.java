package rx.observables;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
import rx.Subscriber;

class BlockingObservable$3
  extends Subscriber<T>
{
  BlockingObservable$3(BlockingObservable paramBlockingObservable, CountDownLatch paramCountDownLatch, AtomicReference paramAtomicReference1, AtomicReference paramAtomicReference2) {}
  
  public void onCompleted()
  {
    this.val$latch.countDown();
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.val$returnException.set(paramThrowable);
    this.val$latch.countDown();
  }
  
  public void onNext(T paramT)
  {
    this.val$returnItem.set(paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     rx.observables.BlockingObservable.3
 * JD-Core Version:    0.7.0.1
 */