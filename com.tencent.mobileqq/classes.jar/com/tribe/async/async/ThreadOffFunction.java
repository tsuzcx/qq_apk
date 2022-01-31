package com.tribe.async.async;

import android.support.annotation.NonNull;
import com.tribe.async.reactive.StreamFunction;
import java.util.concurrent.Future;

public class ThreadOffFunction<IN>
  extends StreamFunction<IN, IN>
{
  private Future mFuture;
  private final int mJobType;
  private boolean mNeedSchedule;
  private final String mTAG;
  
  public ThreadOffFunction(int paramInt)
  {
    this("ThreadOffFunction", paramInt);
  }
  
  public ThreadOffFunction(@NonNull String paramString, int paramInt)
  {
    this.mJobType = paramInt;
    this.mTAG = paramString;
  }
  
  public void call(IN paramIN)
  {
    ThreadOffFunction.ThreadOffJob localThreadOffJob = new ThreadOffFunction.ThreadOffJob(this, this.mTAG, null);
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
    ThreadOffFunction.ThreadOffErrJob localThreadOffErrJob = new ThreadOffFunction.ThreadOffErrJob(this, this.mTAG, null);
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
  
  public void setNeedSchedule(boolean paramBoolean)
  {
    this.mNeedSchedule = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tribe.async.async.ThreadOffFunction
 * JD-Core Version:    0.7.0.1
 */