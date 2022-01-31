package org.junit.internal.runners;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.junit.runners.model.TestTimedOutException;

class MethodRoadie$1
  implements Runnable
{
  MethodRoadie$1(MethodRoadie paramMethodRoadie, long paramLong) {}
  
  public void run()
  {
    ExecutorService localExecutorService = Executors.newSingleThreadExecutor();
    Future localFuture = localExecutorService.submit(new MethodRoadie.1.1(this));
    localExecutorService.shutdown();
    try
    {
      if (!localExecutorService.awaitTermination(this.val$timeout, TimeUnit.MILLISECONDS)) {
        localExecutorService.shutdownNow();
      }
      localFuture.get(0L, TimeUnit.MILLISECONDS);
      return;
    }
    catch (TimeoutException localTimeoutException)
    {
      this.this$0.addFailure(new TestTimedOutException(this.val$timeout, TimeUnit.MILLISECONDS));
      return;
    }
    catch (Exception localException)
    {
      this.this$0.addFailure(localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     org.junit.internal.runners.MethodRoadie.1
 * JD-Core Version:    0.7.0.1
 */