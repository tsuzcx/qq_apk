package com.tencent.mobileqq.dinifly;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class LottieTask$LottieFutureTask
  extends FutureTask<LottieResult<T>>
{
  LottieTask$LottieFutureTask(Callable<LottieResult<T>> paramCallable)
  {
    super(localCallable);
  }
  
  protected void done()
  {
    if (isCancelled()) {
      return;
    }
    try
    {
      LottieTask.access$300(this.this$0, (LottieResult)get());
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      LottieTask.access$300(this.this$0, new LottieResult(localInterruptedException));
      return;
    }
    catch (ExecutionException localExecutionException)
    {
      label24:
      break label24;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.LottieTask.LottieFutureTask
 * JD-Core Version:    0.7.0.1
 */