package com.tribe.async.async;

import android.support.annotation.NonNull;
import com.tribe.async.utils.AssertUtils;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

public class JobController$DefaultJobControlHandler
  implements JobControlHandler
{
  public boolean accept(@NonNull Job paramJob)
  {
    return true;
  }
  
  public void handleCancel(@NonNull JobController.CancelCommand paramCancelCommand)
  {
    Future localFuture = paramCancelCommand.future;
    boolean bool = paramCancelCommand.mayInterrupt;
    if (localFuture != null) {
      localFuture.cancel(bool);
    }
  }
  
  public void handleDone(@NonNull Worker paramWorker) {}
  
  public void handleExecute(@NonNull Executor[] paramArrayOfExecutor, @NonNull Worker paramWorker)
  {
    if (paramArrayOfExecutor.length > 0) {}
    for (boolean bool = true;; bool = false)
    {
      AssertUtils.assertTrue(bool);
      int i = paramWorker.getJobType();
      Bosses.get().getExecutor(i).execute(paramWorker);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tribe.async.async.JobController.DefaultJobControlHandler
 * JD-Core Version:    0.7.0.1
 */