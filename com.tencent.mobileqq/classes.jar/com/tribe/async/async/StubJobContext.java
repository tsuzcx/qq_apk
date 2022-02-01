package com.tribe.async.async;

import android.support.annotation.Nullable;
import android.util.SparseArray;
import com.tribe.async.utils.AssertUtils;

public class StubJobContext
  implements JobContext
{
  private JobContext.CancelListener mCancelListener;
  private volatile boolean mCanceled;
  private final SparseArray<Object> mValues = new SparseArray(1);
  
  @Nullable
  public Object getValue(int paramInt)
  {
    synchronized (this.mValues)
    {
      Object localObject1 = this.mValues.get(paramInt);
      return localObject1;
    }
  }
  
  public boolean isJobCancelled()
  {
    return this.mCanceled;
  }
  
  public void publishJobProgress(Object paramObject) {}
  
  public void setCancelListener(@Nullable JobContext.CancelListener paramCancelListener)
  {
    this.mCancelListener = paramCancelListener;
  }
  
  void setCanceled(boolean paramBoolean)
  {
    this.mCanceled = paramBoolean;
    if (paramBoolean)
    {
      JobContext.CancelListener localCancelListener = this.mCancelListener;
      if (localCancelListener != null) {
        localCancelListener.onCancel();
      }
    }
  }
  
  public void setValue(int paramInt, Object paramObject)
  {
    AssertUtils.checkNotNull(paramObject);
    synchronized (this.mValues)
    {
      this.mValues.put(paramInt, paramObject);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tribe.async.async.StubJobContext
 * JD-Core Version:    0.7.0.1
 */