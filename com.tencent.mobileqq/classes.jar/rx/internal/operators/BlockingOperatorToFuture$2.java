package rx.internal.operators;

import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import rx.Subscription;

final class BlockingOperatorToFuture$2
  implements Future<T>
{
  private volatile boolean cancelled = false;
  
  BlockingOperatorToFuture$2(CountDownLatch paramCountDownLatch, Subscription paramSubscription, AtomicReference paramAtomicReference1, AtomicReference paramAtomicReference2) {}
  
  private T getValue()
  {
    Throwable localThrowable = (Throwable)this.val$error.get();
    if (localThrowable != null) {
      throw new ExecutionException("Observable onError", localThrowable);
    }
    if (this.cancelled) {
      throw new CancellationException("Subscription unsubscribed");
    }
    return this.val$value.get();
  }
  
  public boolean cancel(boolean paramBoolean)
  {
    if (this.val$finished.getCount() > 0L)
    {
      this.cancelled = true;
      this.val$s.unsubscribe();
      this.val$finished.countDown();
      return true;
    }
    return false;
  }
  
  public T get()
  {
    this.val$finished.await();
    return getValue();
  }
  
  public T get(long paramLong, TimeUnit paramTimeUnit)
  {
    if (this.val$finished.await(paramLong, paramTimeUnit)) {
      return getValue();
    }
    throw new TimeoutException("Timed out after " + paramTimeUnit.toMillis(paramLong) + "ms waiting for underlying Observable.");
  }
  
  public boolean isCancelled()
  {
    return this.cancelled;
  }
  
  public boolean isDone()
  {
    return this.val$finished.getCount() == 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     rx.internal.operators.BlockingOperatorToFuture.2
 * JD-Core Version:    0.7.0.1
 */