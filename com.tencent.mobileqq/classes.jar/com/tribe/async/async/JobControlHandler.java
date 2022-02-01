package com.tribe.async.async;

import android.support.annotation.NonNull;
import java.util.concurrent.Executor;

public abstract interface JobControlHandler
{
  public abstract boolean accept(@NonNull Job paramJob);
  
  public abstract void handleCancel(@NonNull JobController.CancelCommand paramCancelCommand);
  
  public abstract void handleDone(@NonNull Worker paramWorker);
  
  public abstract void handleExecute(@NonNull Executor[] paramArrayOfExecutor, @NonNull Worker paramWorker);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tribe.async.async.JobControlHandler
 * JD-Core Version:    0.7.0.1
 */