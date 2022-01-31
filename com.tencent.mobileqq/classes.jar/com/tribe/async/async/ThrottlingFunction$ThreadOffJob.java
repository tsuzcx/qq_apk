package com.tribe.async.async;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

class ThrottlingFunction$ThreadOffJob
  extends Job<IN, Void, IN>
{
  private ThrottlingFunction$ThreadOffJob(ThrottlingFunction paramThrottlingFunction, String paramString)
  {
    super(paramString);
  }
  
  protected IN doInBackground(@NonNull JobContext paramJobContext, @Nullable IN... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length <= 0))
    {
      ThrottlingFunction.access$400(this.this$0, null);
      return null;
    }
    ThrottlingFunction.access$500(this.this$0, paramVarArgs[0]);
    return paramVarArgs[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tribe.async.async.ThrottlingFunction.ThreadOffJob
 * JD-Core Version:    0.7.0.1
 */