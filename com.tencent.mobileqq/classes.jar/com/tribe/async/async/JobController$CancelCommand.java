package com.tribe.async.async;

import com.tribe.async.dispatch.Dispatcher.Command;
import com.tribe.async.utils.AssertUtils;
import java.util.concurrent.Future;

public class JobController$CancelCommand
  implements Dispatcher.Command
{
  public final Future future;
  public final boolean mayInterrupt;
  
  public JobController$CancelCommand(Future paramFuture, boolean paramBoolean)
  {
    AssertUtils.checkNotNull(paramFuture);
    this.future = paramFuture;
    this.mayInterrupt = paramBoolean;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CancelCommand").append("{");
    localStringBuilder.append("job=").append(((Worker)this.future).getJob());
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tribe.async.async.JobController.CancelCommand
 * JD-Core Version:    0.7.0.1
 */