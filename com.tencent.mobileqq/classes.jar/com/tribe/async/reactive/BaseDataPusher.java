package com.tribe.async.reactive;

public class BaseDataPusher<T>
  extends DataPusher<T>
{
  private volatile boolean mIsCanceled;
  protected Observer<T> mLastObserver;
  
  public void apply(Observer<T> paramObserver)
  {
    this.mLastObserver = paramObserver;
    this.mIsCanceled = false;
  }
  
  public void cancel()
  {
    this.mIsCanceled = true;
    if (this.mLastObserver != null) {
      this.mLastObserver.onCancel();
    }
  }
  
  public boolean isCanceled()
  {
    return this.mIsCanceled;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tribe.async.reactive.BaseDataPusher
 * JD-Core Version:    0.7.0.1
 */