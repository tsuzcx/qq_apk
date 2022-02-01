package com.tribe.async.async;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tribe.async.utils.AssertUtils;

class ThreadOffFunction$ThreadOffErrJob
  extends Job<Error, Void, Error>
{
  private ThreadOffFunction$ThreadOffErrJob(ThreadOffFunction paramThreadOffFunction, String paramString)
  {
    super(paramThreadOffFunction.toString());
  }
  
  protected Error doInBackground(@NonNull JobContext paramJobContext, @Nullable Error... paramVarArgs)
  {
    AssertUtils.checkNotNull(paramVarArgs);
    boolean bool;
    if (paramVarArgs.length > 0) {
      bool = true;
    } else {
      bool = false;
    }
    AssertUtils.assertTrue(bool);
    paramJobContext = paramVarArgs[0];
    ThreadOffFunction.access$400(this.this$0, paramJobContext);
    return paramJobContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tribe.async.async.ThreadOffFunction.ThreadOffErrJob
 * JD-Core Version:    0.7.0.1
 */