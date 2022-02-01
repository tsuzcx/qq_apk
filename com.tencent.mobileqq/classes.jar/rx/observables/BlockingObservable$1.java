package rx.observables;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
import rx.Subscriber;
import rx.functions.Action1;

class BlockingObservable$1
  extends Subscriber<T>
{
  BlockingObservable$1(BlockingObservable paramBlockingObservable, CountDownLatch paramCountDownLatch, AtomicReference paramAtomicReference, Action1 paramAction1) {}
  
  public void onCompleted()
  {
    this.val$latch.countDown();
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.val$exceptionFromOnError.set(paramThrowable);
    this.val$latch.countDown();
  }
  
  public void onNext(T paramT)
  {
    this.val$onNext.call(paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     rx.observables.BlockingObservable.1
 * JD-Core Version:    0.7.0.1
 */