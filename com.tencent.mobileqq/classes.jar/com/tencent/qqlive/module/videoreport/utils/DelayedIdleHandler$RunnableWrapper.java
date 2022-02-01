package com.tencent.qqlive.module.videoreport.utils;

import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;

class DelayedIdleHandler$RunnableWrapper
  implements Runnable
{
  private DelayedIdleHandler.DelayedRunnable mTask;
  
  public DelayedIdleHandler$RunnableWrapper(DelayedIdleHandler paramDelayedIdleHandler, DelayedIdleHandler.DelayedRunnable paramDelayedRunnable)
  {
    this.mTask = paramDelayedRunnable;
  }
  
  public void run()
  {
    if (VideoReportInner.getInstance().isDebugMode())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("run by handler, task = ");
      localStringBuilder.append(this.mTask);
      Log.d("DelayedIdleHandler", localStringBuilder.toString());
    }
    this.mTask.run(1);
    DelayedIdleHandler.access$100(this.this$0, this.mTask);
    DelayedIdleHandler.access$200(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.utils.DelayedIdleHandler.RunnableWrapper
 * JD-Core Version:    0.7.0.1
 */