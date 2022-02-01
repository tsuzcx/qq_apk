package com.tencent.mobileqq.mqq.api.impl;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.mobileqq.adapter.IThreadListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mqq.api.IThreadManagerApi;
import java.util.concurrent.Executor;
import mqq.os.MqqHandler;

public class ThreadManagerApiImpl
  implements IThreadManagerApi<MqqHandler>
{
  private com.tencent.mobileqq.app.ThreadPoolParams createThreadPoolParams(com.tencent.mobileqq.adapter.ThreadPoolParams paramThreadPoolParams)
  {
    com.tencent.mobileqq.app.ThreadPoolParams localThreadPoolParams = new com.tencent.mobileqq.app.ThreadPoolParams();
    if (paramThreadPoolParams != null)
    {
      localThreadPoolParams.poolThreadName = paramThreadPoolParams.jdField_a_of_type_JavaLangString;
      localThreadPoolParams.priority = paramThreadPoolParams.jdField_a_of_type_Int;
      localThreadPoolParams.corePoolsize = paramThreadPoolParams.b;
      localThreadPoolParams.maxPooolSize = paramThreadPoolParams.c;
      localThreadPoolParams.keepAliveTime = paramThreadPoolParams.d;
      localThreadPoolParams.queue = paramThreadPoolParams.jdField_a_of_type_JavaUtilConcurrentBlockingQueue;
    }
    return localThreadPoolParams;
  }
  
  public void execute(Runnable paramRunnable, int paramInt, IThreadListener paramIThreadListener, boolean paramBoolean)
  {
    ThreadManagerV2.excute(paramRunnable, paramInt, ThreadListenerAdapter.from(paramIThreadListener), paramBoolean);
  }
  
  public void executeOnFileThread(Runnable paramRunnable)
  {
    ThreadManagerV2.executeOnFileThread(paramRunnable);
  }
  
  public void executeOnSubThread(Runnable paramRunnable)
  {
    ThreadManagerV2.executeOnSubThread(paramRunnable);
  }
  
  public void executeOnSubThread(Runnable paramRunnable, boolean paramBoolean)
  {
    ThreadManagerV2.executeOnSubThread(paramRunnable, paramBoolean);
  }
  
  public Thread getFileThread()
  {
    return ThreadManagerV2.getFileThread();
  }
  
  public MqqHandler getFileThreadHandler()
  {
    return ThreadManager.getFileThreadHandler();
  }
  
  public Looper getFileThreadLooper()
  {
    return ThreadManagerV2.getFileThreadLooper();
  }
  
  public Thread getRecentThread()
  {
    return ThreadManagerV2.getRecentThread();
  }
  
  public Looper getRecentThreadLooper()
  {
    return ThreadManagerV2.getRecentThreadLooper();
  }
  
  public Thread getSubThread()
  {
    return ThreadManagerV2.getSubThread();
  }
  
  public MqqHandler getSubThreadHandler()
  {
    return ThreadManager.getSubThreadHandler();
  }
  
  public Looper getSubThreadLooper()
  {
    return ThreadManagerV2.getSubThreadLooper();
  }
  
  public MqqHandler getUIHandler()
  {
    return ThreadManager.getUIHandler();
  }
  
  public Handler getUIHandlerV2()
  {
    return ThreadManagerV2.getUIHandlerV2();
  }
  
  public HandlerThread newFreeHandlerThread(String paramString, int paramInt)
  {
    return ThreadManagerV2.newFreeHandlerThread(paramString, paramInt);
  }
  
  public Thread newFreeThread(Runnable paramRunnable, String paramString, int paramInt)
  {
    return ThreadManagerV2.newFreeThread(paramRunnable, paramString, paramInt);
  }
  
  public Executor newFreeThreadPool(com.tencent.mobileqq.adapter.ThreadPoolParams paramThreadPoolParams)
  {
    return ThreadManagerV2.newFreeThreadPool(createThreadPoolParams(paramThreadPoolParams));
  }
  
  public boolean removeJobFromThreadPool(Runnable paramRunnable, int paramInt)
  {
    return ThreadManagerV2.removeJobFromThreadPool(paramRunnable, paramInt);
  }
  
  public String reportCurrentState()
  {
    return ThreadManagerV2.reportCurrentState();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.mqq.api.impl.ThreadManagerApiImpl
 * JD-Core Version:    0.7.0.1
 */