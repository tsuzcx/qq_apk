package com.tribe.async.async;

import com.tribe.async.reactive.StreamFunction;

public abstract class JobSegment<IN, OUT>
  extends StreamFunction<IN, OUT>
{
  private JobContext mJobContext;
  
  public void attachJobContext(JobContext paramJobContext)
  {
    this.mJobContext = paramJobContext;
  }
  
  protected void call(IN paramIN)
  {
    if (this.mJobContext == null) {
      this.mJobContext = new StubJobContext();
    }
    runSegment(this.mJobContext, paramIN);
  }
  
  protected void onCancel()
  {
    JobContext localJobContext = this.mJobContext;
    if ((localJobContext != null) && ((localJobContext instanceof StubJobContext))) {
      ((StubJobContext)localJobContext).setCanceled(true);
    }
  }
  
  protected abstract void runSegment(JobContext paramJobContext, IN paramIN);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tribe.async.async.JobSegment
 * JD-Core Version:    0.7.0.1
 */