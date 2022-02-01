package com.tribe.async.parallel;

import android.support.annotation.NonNull;
import com.tribe.async.log.SLog;

public class SimpleParallelObserver
  extends ParallelObserver
{
  private static final String TAG = "vianhuang.SimpleParallelObserver";
  
  public void onAllFunctionComplete(boolean paramBoolean)
  {
    SLog.i("vianhuang.SimpleParallelObserver", "on all function completed.");
  }
  
  public void onCancel()
  {
    SLog.i("vianhuang.SimpleParallelObserver", "on parallel stream been canceled.");
  }
  
  public void onOneFuncErr(int paramInt, @NonNull Error paramError)
  {
    SLog.i("vianhuang.SimpleParallelObserver", "on one function error. functionIndex = %d, error = %s.", new Object[] { Integer.valueOf(paramInt), paramError });
  }
  
  public void onOneFuncSuc(int paramInt, Object paramObject)
  {
    SLog.i("vianhuang.SimpleParallelObserver", "on one function success. functionIndex = %d, result = %s.", new Object[] { Integer.valueOf(paramInt), paramObject });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tribe.async.parallel.SimpleParallelObserver
 * JD-Core Version:    0.7.0.1
 */