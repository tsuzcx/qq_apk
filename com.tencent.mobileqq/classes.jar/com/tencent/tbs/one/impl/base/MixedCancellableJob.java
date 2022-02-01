package com.tencent.tbs.one.impl.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MixedCancellableJob<T>
  extends CancellableJob<T>
{
  private CancellableJob<T> mCurrentJob;
  private List<CancellableJob<T>> mJobs;
  
  public MixedCancellableJob(CancellableJob<T>[] paramArrayOfCancellableJob)
  {
    this.mJobs = new ArrayList(Arrays.asList(paramArrayOfCancellableJob));
  }
  
  private void runNextJob()
  {
    this.mCurrentJob = ((CancellableJob)this.mJobs.remove(0));
    if (this.mJobs.size() == 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.mCurrentJob.start(new MixedCancellableJob.1(this, bool));
      return;
    }
  }
  
  public void cancel()
  {
    super.cancel();
    if (this.mCurrentJob != null) {
      this.mCurrentJob.cancel();
    }
  }
  
  protected void run()
  {
    runNextJob();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.base.MixedCancellableJob
 * JD-Core Version:    0.7.0.1
 */