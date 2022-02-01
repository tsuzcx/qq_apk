package rx.internal.operators;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
import rx.Subscriber;

final class BlockingOperatorToFuture$1
  extends Subscriber<T>
{
  BlockingOperatorToFuture$1(CountDownLatch paramCountDownLatch, AtomicReference paramAtomicReference1, AtomicReference paramAtomicReference2) {}
  
  public void onCompleted()
  {
    this.val$finished.countDown();
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.val$error.compareAndSet(null, paramThrowable);
    this.val$finished.countDown();
  }
  
  public void onNext(T paramT)
  {
    this.val$value.set(paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     rx.internal.operators.BlockingOperatorToFuture.1
 * JD-Core Version:    0.7.0.1
 */