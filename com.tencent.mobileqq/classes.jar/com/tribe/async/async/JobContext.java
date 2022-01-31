package com.tribe.async.async;

import android.support.annotation.Nullable;

public abstract interface JobContext<Progress>
{
  @Nullable
  public abstract Object getValue(int paramInt);
  
  public abstract boolean isJobCancelled();
  
  public abstract void publishJobProgress(Progress paramProgress);
  
  public abstract void setCancelListener(@Nullable CancelListener paramCancelListener);
  
  public abstract void setValue(int paramInt, Object paramObject);
  
  public static abstract interface CancelListener
  {
    public abstract void onCancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tribe.async.async.JobContext
 * JD-Core Version:    0.7.0.1
 */