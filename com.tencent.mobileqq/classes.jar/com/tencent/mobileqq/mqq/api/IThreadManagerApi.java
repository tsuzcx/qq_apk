package com.tencent.mobileqq.mqq.api;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.mobileqq.adapter.IThreadListener;
import com.tencent.mobileqq.adapter.ThreadPoolParams;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.concurrent.Executor;

@QAPI(process={"all"})
public abstract interface IThreadManagerApi<T>
  extends QRouteApi
{
  public abstract void execute(Runnable paramRunnable, int paramInt, IThreadListener paramIThreadListener, boolean paramBoolean);
  
  public abstract void executeOnFileThread(Runnable paramRunnable);
  
  public abstract void executeOnSubThread(Runnable paramRunnable);
  
  public abstract void executeOnSubThread(Runnable paramRunnable, boolean paramBoolean);
  
  public abstract Thread getFileThread();
  
  public abstract T getFileThreadHandler();
  
  public abstract Looper getFileThreadLooper();
  
  public abstract Thread getRecentThread();
  
  public abstract Looper getRecentThreadLooper();
  
  public abstract Thread getSubThread();
  
  public abstract T getSubThreadHandler();
  
  public abstract Looper getSubThreadLooper();
  
  public abstract T getUIHandler();
  
  public abstract Handler getUIHandlerV2();
  
  public abstract HandlerThread newFreeHandlerThread(String paramString, int paramInt);
  
  public abstract Thread newFreeThread(Runnable paramRunnable, String paramString, int paramInt);
  
  public abstract Executor newFreeThreadPool(ThreadPoolParams paramThreadPoolParams);
  
  public abstract boolean removeJobFromThreadPool(Runnable paramRunnable, int paramInt);
  
  public abstract String reportCurrentState();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.mqq.api.IThreadManagerApi
 * JD-Core Version:    0.7.0.1
 */