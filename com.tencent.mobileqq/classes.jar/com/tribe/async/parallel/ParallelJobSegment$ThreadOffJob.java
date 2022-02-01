package com.tribe.async.parallel;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tribe.async.async.Job;
import com.tribe.async.async.JobContext;

class ParallelJobSegment$ThreadOffJob
  extends Job<IN, Void, IN>
{
  @Deprecated
  private ParallelJobSegment$ThreadOffJob(ParallelJobSegment paramParallelJobSegment)
  {
    this(paramParallelJobSegment, "ParallelJobSegment.ThreadOffJob");
  }
  
  private ParallelJobSegment$ThreadOffJob(ParallelJobSegment paramParallelJobSegment, String paramString)
  {
    super(paramString);
  }
  
  public IN doInBackground(@NonNull JobContext paramJobContext, @Nullable IN... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length <= 0))
    {
      this.this$0.runSegment(paramJobContext, null);
      return null;
    }
    this.this$0.runSegment(paramJobContext, paramVarArgs[0]);
    return paramVarArgs[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tribe.async.parallel.ParallelJobSegment.ThreadOffJob
 * JD-Core Version:    0.7.0.1
 */