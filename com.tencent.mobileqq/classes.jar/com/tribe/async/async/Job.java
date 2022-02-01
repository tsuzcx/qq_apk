package com.tribe.async.async;

import android.os.Process;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tribe.async.utils.AssertUtils;
import java.lang.reflect.Array;
import java.util.concurrent.Callable;

public abstract class Job<Params, Progress, Result>
  implements Callable<Result>
{
  public static final int TYPE_CPU = 2;
  public static final int TYPE_DISK_READ = 4;
  public static final int TYPE_DISK_WRITE = 8;
  public static final int TYPE_NETWORK = 16;
  private JobContext mJobContext;
  @Nullable
  private Params mParams;
  private final String mTAG;
  private int mType = 2;
  
  @Deprecated
  public Job()
  {
    this("Job");
  }
  
  public Job(@NonNull String paramString)
  {
    this.mTAG = paramString;
  }
  
  public static JobContext stubJobContext()
  {
    return new StubJobContext();
  }
  
  public Result call()
  {
    Process.setThreadPriority(10);
    Object[] arrayOfObject = null;
    if (this.mParams != null)
    {
      arrayOfObject = (Object[])Array.newInstance(this.mParams.getClass(), 1);
      arrayOfObject[0] = this.mParams;
    }
    AssertUtils.checkNotNull(this.mJobContext);
    return doInBackground(this.mJobContext, arrayOfObject);
  }
  
  protected boolean checkParams(@Nullable Params paramParams)
  {
    return true;
  }
  
  protected abstract Result doInBackground(@NonNull JobContext paramJobContext, @Nullable Params... paramVarArgs);
  
  public int getJobType()
  {
    return this.mType;
  }
  
  @Nullable
  public Params getParams()
  {
    return this.mParams;
  }
  
  public boolean isCancelled()
  {
    return this.mJobContext.isJobCancelled();
  }
  
  protected void onCancelled() {}
  
  public void onPost() {}
  
  protected void onResult(@Nullable Result paramResult) {}
  
  public void publishProgress(Progress paramProgress)
  {
    if (this.mJobContext != null) {
      this.mJobContext.publishJobProgress(paramProgress);
    }
  }
  
  void setJobContext(JobContext paramJobContext)
  {
    this.mJobContext = paramJobContext;
  }
  
  public void setJobType(int paramInt)
  {
    this.mType = paramInt;
  }
  
  public void setParams(@Nullable Params paramParams)
  {
    this.mParams = paramParams;
    if (!checkParams(paramParams)) {
      throw new IllegalArgumentException("params is incorrect! \n" + toString());
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("Job{");
    localStringBuilder.append("mTAG='").append(this.mTAG).append("', ");
    localStringBuilder.append("mType= ").append(this.mType);
    localStringBuilder.append(", mParams=").append(this.mParams);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tribe.async.async.Job
 * JD-Core Version:    0.7.0.1
 */