package rx.internal.util;

import java.util.concurrent.CountDownLatch;
import rx.Subscription;
import rx.annotations.Experimental;

@Experimental
public final class BlockingUtils
{
  @Experimental
  public static void awaitForComplete(CountDownLatch paramCountDownLatch, Subscription paramSubscription)
  {
    if (paramCountDownLatch.getCount() == 0L) {
      return;
    }
    try
    {
      paramCountDownLatch.await();
      return;
    }
    catch (InterruptedException paramCountDownLatch)
    {
      paramSubscription.unsubscribe();
      Thread.currentThread().interrupt();
      throw new RuntimeException("Interrupted while waiting for subscription to complete.", paramCountDownLatch);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.internal.util.BlockingUtils
 * JD-Core Version:    0.7.0.1
 */