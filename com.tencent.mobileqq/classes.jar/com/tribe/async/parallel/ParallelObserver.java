package com.tribe.async.parallel;

import android.support.annotation.NonNull;
import android.util.SparseArray;
import com.tribe.async.log.SLog;

public abstract class ParallelObserver
  implements Observer
{
  private static final int MAX_FUNCTION_COUNT = 100;
  private static final String TAG = "vianhuang.SimpleParallelObserver";
  private Object[] mFunctionResults = new Object[100];
  private boolean mIsCancel = false;
  private int mObserverFunctionCount = 0;
  private SparseArray<Integer> mObserverFunctions = new SparseArray();
  private boolean mSuccess = true;
  
  private boolean isAllFunctionComplete()
  {
    return this.mObserverFunctions.size() <= 0;
  }
  
  public final void addObserverFunction(Integer paramInteger)
  {
    try
    {
      SLog.d("vianhuang.SimpleParallelObserver", "add a function that need be observed. functionCode = %d", new Object[] { paramInteger });
      if (this.mObserverFunctions.size() == 100) {
        throw new IllegalStateException("you can't add more than 100 functions.");
      }
    }
    finally {}
    int i = this.mObserverFunctions.size();
    this.mObserverFunctions.put(paramInteger.intValue(), Integer.valueOf(i));
    this.mObserverFunctionCount = this.mObserverFunctions.size();
  }
  
  public <Result> Result getFunctionResult(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramInt >= 0)
    {
      localObject1 = localObject2;
      if (paramInt < this.mObserverFunctionCount) {
        localObject1 = this.mFunctionResults[paramInt];
      }
    }
    SLog.i("vianhuang.SimpleParallelObserver", "get the %d function's result is %s.", new Object[] { Integer.valueOf(paramInt), localObject1 });
    return localObject1;
  }
  
  public abstract void onCancel();
  
  public abstract void onOneFuncErr(int paramInt, @NonNull Error paramError);
  
  public abstract void onOneFuncSuc(int paramInt, Object paramObject);
  
  public final void onOneFunctionErr(Integer paramInteger, @NonNull Error paramError)
  {
    if (this.mIsCancel) {
      SLog.d("vianhuang.SimpleParallelObserver", "one function error while stream is cancel.");
    }
    for (;;)
    {
      return;
      int i = ((Integer)this.mObserverFunctions.get(paramInteger.intValue())).intValue();
      int j = this.mObserverFunctionCount;
      if (i < 0)
      {
        SLog.w("vianhuang.SimpleParallelObserver", "can't find this error function in observing queue, just ignore.");
        return;
      }
      SLog.d("vianhuang.SimpleParallelObserver", "on one function error. functionCode = %d, error = %s.", new Object[] { paramInteger, paramError });
      try
      {
        this.mSuccess = false;
        this.mObserverFunctions.delete(paramInteger.intValue());
        onOneFuncErr(j - (i + 1), paramError);
        if (!isAllFunctionComplete()) {
          continue;
        }
        SLog.d("vianhuang.SimpleParallelObserver", "all functions had completed. result = %s.", new Object[] { Boolean.valueOf(this.mSuccess) });
        onAllFunctionComplete(this.mSuccess);
        return;
      }
      finally {}
    }
  }
  
  public final void onOneFunctionSuc(Integer paramInteger, Object paramObject)
  {
    if (this.mIsCancel) {
      SLog.d("vianhuang.SimpleParallelObserver", "one function success while stream is cancel.");
    }
    for (;;)
    {
      return;
      if (this.mObserverFunctions.get(paramInteger.intValue()) == null)
      {
        SLog.w("vianhuang.SimpleParallelObserver", "can't find this successful function in observing queue, just ignore.");
        return;
      }
      int i = ((Integer)this.mObserverFunctions.get(paramInteger.intValue())).intValue();
      i = this.mObserverFunctionCount - (i + 1);
      SLog.d("vianhuang.SimpleParallelObserver", "on one function success. functionCode = %d, result = %s.", new Object[] { paramInteger, paramObject });
      try
      {
        this.mObserverFunctions.delete(paramInteger.intValue());
        this.mFunctionResults[i] = paramObject;
        onOneFuncSuc(i, paramObject);
        if (!isAllFunctionComplete()) {
          continue;
        }
        onAllFunctionComplete(this.mSuccess);
        return;
      }
      finally {}
    }
  }
  
  public final void onStreamCancel()
  {
    this.mIsCancel = true;
    onCancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tribe.async.parallel.ParallelObserver
 * JD-Core Version:    0.7.0.1
 */