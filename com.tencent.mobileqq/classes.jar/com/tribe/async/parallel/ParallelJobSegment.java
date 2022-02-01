package com.tribe.async.parallel;

import android.support.annotation.NonNull;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.async.JobContext;
import com.tribe.async.reactive.StreamFunction;
import java.util.concurrent.Future;

public abstract class ParallelJobSegment<IN, OUT>
  extends StreamFunction<IN, OUT>
{
  private Future mFuture;
  private int mJobType = 2;
  private boolean mNeedSchedule;
  private String mTAG;
  
  @Deprecated
  public ParallelJobSegment(int paramInt)
  {
    this("ParallelJobSegment", paramInt);
  }
  
  public ParallelJobSegment(String paramString)
  {
    this(paramString, 2);
  }
  
  public ParallelJobSegment(@NonNull String paramString, int paramInt)
  {
    this.mTAG = paramString;
    this.mJobType = paramInt;
  }
  
  public void call(IN paramIN)
  {
    ParallelJobSegment.ThreadOffJob localThreadOffJob = new ParallelJobSegment.ThreadOffJob(this, this.mTAG, null);
    localThreadOffJob.setJobType(this.mJobType);
    if (this.mNeedSchedule)
    {
      this.mFuture = Bosses.get().scheduleJob(localThreadOffJob, paramIN);
      return;
    }
    this.mFuture = Bosses.get().postJob(localThreadOffJob, paramIN);
  }
  
  public void error(Error paramError)
  {
    ParallelJobSegment.ThreadOffErrJob localThreadOffErrJob = new ParallelJobSegment.ThreadOffErrJob(this, this.mTAG, null);
    localThreadOffErrJob.setJobType(this.mJobType);
    if (this.mNeedSchedule)
    {
      this.mFuture = Bosses.get().scheduleJob(localThreadOffErrJob, paramError);
      return;
    }
    this.mFuture = Bosses.get().postJob(localThreadOffErrJob, paramError);
  }
  
  public void onCancel()
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tribe.async.parallel.ParallelJobSegment
 * JD-Core Version:    0.7.0.1
 */