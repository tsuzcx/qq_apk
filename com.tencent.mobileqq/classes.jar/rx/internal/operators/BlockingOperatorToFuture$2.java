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
    if (localThrowable == null)
    {
      if (!this.cancelled) {
        return this.val$value.get();
      }
      throw new CancellationException("Subscription unsubscribed");
    }
    throw new ExecutionException("Observable onError", localThrowable);
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Timed out after ");
    localStringBuilder.append(paramTimeUnit.toMillis(paramLong));
    localStringBuilder.append("ms waiting for underlying Observable.");
    throw new TimeoutException(localStringBuilder.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.internal.operators.BlockingOperatorToFuture.2
 * JD-Core Version:    0.7.0.1
 */