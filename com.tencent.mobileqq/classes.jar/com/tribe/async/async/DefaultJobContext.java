package com.tribe.async.async;

import android.support.annotation.Nullable;
import android.util.SparseArray;
import com.tribe.async.utils.AssertUtils;
import java.lang.ref.WeakReference;

class DefaultJobContext<Progress>
  implements JobContext<Progress>
{
  @Nullable
  private JobContext.CancelListener mCancelListener;
  private volatile boolean mIsJobCancelled;
  private final SparseArray<Object> mValues = new SparseArray(1);
  private WeakReference<Worker<Progress, ?>> mWorkerRef;
  
  public DefaultJobContext(Worker<Progress, ?> paramWorker)
  {
    AssertUtils.checkNotNull(paramWorker);
    this.mWorkerRef = new WeakReference(paramWorker);
  }
  
  public Object getValue(int paramInt)
  {
    return this.mValues.get(paramInt);
  }
  
  public boolean isJobCancelled()
  {
    return this.mIsJobCancelled;
  }
  
  void notifyCancelListener()
  {
    if (this.mCancelListener != null) {
      this.mCancelListener.onCancel();
    }
  }
  
  public void publishJobProgress(Progress paramProgress)
  {
    AssertUtils.checkNotNull(paramProgress);
    Worker localWorker = (Worker)this.mWorkerRef.get();
    if (localWorker != null) {
      localWorker.notifyProgress(paramProgress);
    }
  }
  
  public void setCancelListener(@Nullable JobContext.CancelListener paramCancelListener)
  {
    this.mCancelListener = paramCancelListener;
  }
  
  void setJobCancelled(boolean paramBoolean)
  {
    this.mIsJobCancelled = paramBoolean;
  }
  
  public void setValue(int paramInt, Object paramObject)
  {
    AssertUtils.checkNotNull(paramObject);
    this.mValues.put(paramInt, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tribe.async.async.DefaultJobContext
 * JD-Core Version:    0.7.0.1
 */