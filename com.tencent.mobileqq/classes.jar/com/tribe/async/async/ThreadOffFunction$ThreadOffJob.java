package com.tribe.async.async;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

class ThreadOffFunction$ThreadOffJob
  extends Job<IN, Void, IN>
{
  private ThreadOffFunction$ThreadOffJob(ThreadOffFunction paramThreadOffFunction, String paramString)
  {
    super(paramString);
  }
  
  protected IN doInBackground(@NonNull JobContext paramJobContext, @Nullable IN... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length <= 0))
    {
      ThreadOffFunction.access$200(this.this$0, null);
      return null;
    }
    ThreadOffFunction.access$300(this.this$0, paramVarArgs[0]);
    return paramVarArgs[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tribe.async.async.ThreadOffFunction.ThreadOffJob
 * JD-Core Version:    0.7.0.1
 */