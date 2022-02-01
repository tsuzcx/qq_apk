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
    Observer localObserver = this.mLastObserver;
    if (localObserver != null) {
      localObserver.onCancel();
    }
  }
  
  public boolean isCanceled()
  {
    return this.mIsCanceled;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tribe.async.reactive.BaseDataPusher
 * JD-Core Version:    0.7.0.1
 */