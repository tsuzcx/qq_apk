package com.tribe.async.parallel;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tribe.async.async.Job;
import com.tribe.async.async.JobContext;
import com.tribe.async.utils.AssertUtils;

class ParallelJobSegment$ThreadOffErrJob
  extends Job<Error, Void, Error>
{
  private ParallelJobSegment$ThreadOffErrJob(ParallelJobSegment paramParallelJobSegment)
  {
    this(paramParallelJobSegment, "ParallelJobSegment.ThreadOffErrJob");
  }
  
  private ParallelJobSegment$ThreadOffErrJob(ParallelJobSegment paramParallelJobSegment, String paramString)
  {
    super(paramString);
  }
  
  protected Error doInBackground(@NonNull JobContext paramJobContext, @Nullable Error... paramVarArgs)
  {
    AssertUtils.checkNotNull(paramVarArgs);
    if (paramVarArgs.length > 0) {}
    for (boolean bool = true;; bool = false)
    {
      AssertUtils.assertTrue(bool);
      paramJobContext = paramVarArgs[0];
      ParallelJobSegment.access$200(this.this$0, paramJobContext);
      return paramJobContext;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tribe.async.parallel.ParallelJobSegment.ThreadOffErrJob
 * JD-Core Version:    0.7.0.1
 */