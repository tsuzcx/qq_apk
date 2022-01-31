package com.tencent.tissue.miniapp.hdasync;

import android.os.Looper;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;

public abstract class BaseAction
{
  protected long delay = 0L;
  protected Looper looper;
  protected ExecutorService pool;
  private WeakReference<HdAsync> weakHdAsync;
  private WeakReference<Object> weakHost;
  
  public BaseAction(Looper paramLooper)
  {
    this.looper = paramLooper;
    this.pool = null;
  }
  
  public BaseAction(ExecutorService paramExecutorService)
  {
    this.pool = paramExecutorService;
    this.looper = null;
  }
  
  public abstract BaseResult call(Object paramObject);
  
  public HdAsync getHdAsync()
  {
    if (this.weakHdAsync != null) {
      return (HdAsync)this.weakHdAsync.get();
    }
    return null;
  }
  
  public Object getHost()
  {
    if (this.weakHost != null) {
      return this.weakHost.get();
    }
    return null;
  }
  
  public void setHdAsync(HdAsync paramHdAsync)
  {
    this.weakHdAsync = new WeakReference(paramHdAsync);
  }
  
  public void setHost(Object paramObject)
  {
    this.weakHost = new WeakReference(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.tissue.miniapp.hdasync.BaseAction
 * JD-Core Version:    0.7.0.1
 */