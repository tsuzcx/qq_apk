package com.tribe.async.async;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tribe.async.reactive.StreamFunction.StreamFunctionListener;

public class SegmentsJob<IN, PROGRESS, OUT>
  extends Job<IN, PROGRESS, OUT>
{
  private Error mError;
  private JobSegment<IN, OUT> mJobSegment;
  private OUT mResult;
  
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
    this.mJobSegment.observe(new InnerStreamFunctionListener(null));
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
  
  private class InnerStreamFunctionListener
    implements StreamFunction.StreamFunctionListener<OUT>
  {
    private InnerStreamFunctionListener() {}
    
    public void onCancel() {}
    
    public void onError(Error paramError)
    {
      SegmentsJob.access$202(SegmentsJob.this, paramError);
    }
    
    public void onResult(OUT paramOUT)
    {
      SegmentsJob.access$102(SegmentsJob.this, paramOUT);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tribe.async.async.SegmentsJob
 * JD-Core Version:    0.7.0.1
 */