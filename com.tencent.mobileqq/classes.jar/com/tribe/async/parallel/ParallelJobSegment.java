package com.tribe.async.parallel;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.async.Job;
import com.tribe.async.async.JobContext;
import com.tribe.async.reactive.StreamFunction;
import com.tribe.async.utils.AssertUtils;
import java.util.concurrent.Future;

public abstract class ParallelJobSegment<IN, OUT>
  extends StreamFunction<IN, OUT>
{
  private Future mFuture;
  private int mJobType = 2;
  private boolean mNeedSchedule;
  
  public ParallelJobSegment() {}
  
  public ParallelJobSegment(int paramInt)
  {
    this.mJobType = paramInt;
  }
  
  protected void call(IN paramIN)
  {
    ThreadOffJob localThreadOffJob = new ThreadOffJob(null);
    localThreadOffJob.setJobType(this.mJobType);
    if (this.mNeedSchedule)
    {
      this.mFuture = Bosses.get().scheduleJob(localThreadOffJob, paramIN);
      return;
    }
    this.mFuture = Bosses.get().postJob(localThreadOffJob, paramIN);
  }
  
  protected void error(Error paramError)
  {
    ThreadOffErrJob localThreadOffErrJob = new ThreadOffErrJob(null);
    localThreadOffErrJob.setJobType(this.mJobType);
    if (this.mNeedSchedule)
    {
      this.mFuture = Bosses.get().scheduleJob(localThreadOffErrJob, paramError);
      return;
    }
    this.mFuture = Bosses.get().postJob(localThreadOffErrJob, paramError);
  }
  
  protected void onCancel()
  {
    if (this.mFuture == null) {
      return;
    }
    if (this.mNeedSchedule)
    {
      Bosses.get().cancelJob(this.mFuture, true);
      return;
    }
    this.mFuture.cancel(true);
  }
  
  protected abstract void runSegment(JobContext paramJobContext, IN paramIN);
  
  public void setNeedSchedule(boolean paramBoolean)
  {
    this.mNeedSchedule = paramBoolean;
  }
  
  private class ThreadOffErrJob
    extends Job<Error, Void, Error>
  {
    private ThreadOffErrJob() {}
    
    protected Error doInBackground(@NonNull JobContext paramJobContext, @Nullable Error... paramVarArgs)
    {
      AssertUtils.checkNotNull(paramVarArgs);
      if (paramVarArgs.length > 0) {}
      for (boolean bool = true;; bool = false)
      {
        AssertUtils.assertTrue(bool);
        paramJobContext = paramVarArgs[0];
        ParallelJobSegment.this.notifyError(paramJobContext);
        return paramJobContext;
      }
    }
  }
  
  private class ThreadOffJob
    extends Job<IN, Void, IN>
  {
    private ThreadOffJob() {}
    
    protected IN doInBackground(@NonNull JobContext paramJobContext, @Nullable IN... paramVarArgs)
    {
      if ((paramVarArgs == null) || (paramVarArgs.length <= 0))
      {
        ParallelJobSegment.this.runSegment(paramJobContext, null);
        return null;
      }
      ParallelJobSegment.this.runSegment(paramJobContext, paramVarArgs[0]);
      return paramVarArgs[0];
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tribe.async.parallel.ParallelJobSegment
 * JD-Core Version:    0.7.0.1
 */