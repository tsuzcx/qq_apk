package com.tribe.async.async;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tribe.async.reactive.StreamFunction;
import com.tribe.async.utils.AssertUtils;
import java.util.concurrent.Future;

public class ThreadOffFunction<IN>
  extends StreamFunction<IN, IN>
{
  private Future mFuture;
  private final int mJobType;
  private boolean mNeedSchedule;
  
  public ThreadOffFunction(int paramInt)
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
        ThreadOffFunction.this.notifyError(paramJobContext);
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
        ThreadOffFunction.this.notifyResult(null);
        return null;
      }
      ThreadOffFunction.this.notifyResult(paramVarArgs[0]);
      return paramVarArgs[0];
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tribe.async.async.ThreadOffFunction
 * JD-Core Version:    0.7.0.1
 */