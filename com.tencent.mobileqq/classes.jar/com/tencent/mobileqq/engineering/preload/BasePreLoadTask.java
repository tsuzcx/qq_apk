package com.tencent.mobileqq.engineering.preload;

import com.tencent.mobileqq.engineering.preload.inter.OnPreLoadListener;

public abstract class BasePreLoadTask<T>
{
  public boolean mIsOnlyRunOnce = true;
  public long mPreloadExpiredTime = 0L;
  
  public abstract void onRemove();
  
  public abstract void startLoadData(OnPreLoadListener<T> paramOnPreLoadListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.engineering.preload.BasePreLoadTask
 * JD-Core Version:    0.7.0.1
 */