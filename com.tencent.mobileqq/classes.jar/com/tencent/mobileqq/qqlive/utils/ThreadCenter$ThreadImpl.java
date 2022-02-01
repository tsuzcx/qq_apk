package com.tencent.mobileqq.qqlive.utils;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class ThreadCenter$ThreadImpl
{
  private int a = 2;
  private ConcurrentHashMap<Integer, Handler> b = new ConcurrentHashMap();
  private Handler c;
  private ThreadPoolExecutor d;
  private ConcurrentHashMap<Object, Runnable> e = new ConcurrentHashMap();
  private ConcurrentHashMap<String, ThreadCenter.CoreHandler> f = new ConcurrentHashMap();
  private boolean g = false;
  
  ThreadCenter$ThreadImpl()
  {
    if (this.g) {
      return;
    }
    this.g = true;
    Object localObject = new HandlerThread("basetimer");
    ((HandlerThread)localObject).start();
    this.c = new Handler(((HandlerThread)localObject).getLooper());
    int i = Runtime.getRuntime().availableProcessors();
    if (i > 0) {
      this.a = i;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("thread pool size ");
    ((StringBuilder)localObject).append(this.a);
    Log.v("threadimpl_log", ((StringBuilder)localObject).toString());
    i = this.a;
    this.d = new ThreadPoolExecutor(i, i, 10L, TimeUnit.SECONDS, new PriorityBlockingQueue(30));
    a();
    Log.v("threadimpl_log", "thread create ok");
  }
  
  private void a()
  {
    this.c.postDelayed(new ThreadCenter.ThreadImpl.2(this), 300000L);
  }
  
  Handler a(String paramString)
  {
    Object localObject1;
    if (this.f.containsKey(paramString)) {
      localObject1 = (ThreadCenter.CoreHandler)this.f.get(paramString);
    } else {
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = new ThreadCenter.CoreHandler(paramString);
      this.f.put(paramString, localObject2);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("create new thread: ");
      ((StringBuilder)localObject1).append(paramString);
      Log.v("threadimpl_log", ((StringBuilder)localObject1).toString());
    }
    return ((ThreadCenter.CoreHandler)localObject2).b();
  }
  
  public void a(ThreadCenter.HandlerKeyable paramHandlerKeyable)
  {
    Handler localHandler = (Handler)this.b.get(Integer.valueOf(paramHandlerKeyable.hashCode()));
    if (localHandler != null)
    {
      localHandler.removeCallbacksAndMessages(null);
      this.b.remove(Integer.valueOf(paramHandlerKeyable.hashCode()));
    }
  }
  
  void a(ThreadCenter.HandlerKeyable paramHandlerKeyable, Runnable paramRunnable)
  {
    if (paramRunnable == null) {
      return;
    }
    paramHandlerKeyable = (Handler)this.b.get(Integer.valueOf(paramHandlerKeyable.hashCode()));
    if (paramHandlerKeyable != null) {
      paramHandlerKeyable.removeCallbacks(paramRunnable);
    }
  }
  
  void a(ThreadCenter.HandlerKeyable paramHandlerKeyable, Runnable paramRunnable, long paramLong, boolean paramBoolean)
  {
    if (paramRunnable == null) {
      return;
    }
    ThreadCenter.HandlerKeyable localHandlerKeyable = paramHandlerKeyable;
    if (paramHandlerKeyable == null) {
      localHandlerKeyable = ThreadCenter.c;
    }
    Handler localHandler = (Handler)this.b.get(Integer.valueOf(localHandlerKeyable.hashCode()));
    paramHandlerKeyable = localHandler;
    if (localHandler == null)
    {
      paramHandlerKeyable = new Handler(Looper.getMainLooper());
      this.b.put(Integer.valueOf(localHandlerKeyable.hashCode()), paramHandlerKeyable);
    }
    if (paramLong > 0L)
    {
      paramHandlerKeyable.postDelayed(paramRunnable, paramLong);
      return;
    }
    if (paramBoolean)
    {
      paramHandlerKeyable.postAtFrontOfQueue(paramRunnable);
      return;
    }
    paramHandlerKeyable.post(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.utils.ThreadCenter.ThreadImpl
 * JD-Core Version:    0.7.0.1
 */