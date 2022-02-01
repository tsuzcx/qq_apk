package com.tribe.async.async;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class SegmentsJob<IN, PROGRESS, OUT>
  extends Job<IN, PROGRESS, OUT>
{
  private Error mError;
  private JobSegment<IN, OUT> mJobSegment;
  private OUT mResult;
  
  public SegmentsJob()
  {
    this("SegmentsJob");
  }
  
  public SegmentsJob(@NonNull String paramString)
  {
    super(paramString);
  }
  
  public void attachJobSegment(JobSegment<IN, OUT> paramJobSegment)
  {
    this.mJobSegment = paramJobSegment;
  }
  
  protected OUT doInBackground(@NonNull JobContext paramJobContext, @Nullable IN... paramVarArgs)
  {
    if (this.mJobSegment == null) {
      throw new RuntimeException("Please call attachJobSegment first.");
    }
    this.mJobSegment.attachJobContext(paramJobContext);
    this.mJobSegment.observe(new SegmentsJob.InnerStreamFunctionListener(this, null));
    if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
      this.mJobSegment.apply(paramVarArgs[0]);
    }
    for (;;)
    {
      return this.mResult;
      this.mJobSegment.apply(null);
    }
  }
  
  public Error getError()
  {
    return this.mError;
  }
  
  public OUT getResult()
  {
    return this.mResult;
  }
  
  protected void onCancelled()
  {
    this.mJobSegment.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tribe.async.async.SegmentsJob
 * JD-Core Version:    0.7.0.1
 */