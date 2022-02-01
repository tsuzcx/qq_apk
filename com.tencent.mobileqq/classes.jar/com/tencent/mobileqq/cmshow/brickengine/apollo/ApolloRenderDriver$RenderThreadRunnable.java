package com.tencent.mobileqq.cmshow.brickengine.apollo;

import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

class ApolloRenderDriver$RenderThreadRunnable
  extends IApolloRunnableTask
{
  WeakReference<ApolloEngine> a = null;
  private String b;
  private ReentrantLock c;
  
  public ApolloRenderDriver$RenderThreadRunnable(ApolloRenderDriver paramApolloRenderDriver, String paramString, ReentrantLock paramReentrantLock, ApolloEngine paramApolloEngine)
  {
    this.b = paramString;
    this.c = paramReentrantLock;
    this.a = new WeakReference(paramApolloEngine);
  }
  
  public void run()
  {
    this.c.lock();
    try
    {
      ApolloEngine localApolloEngine = (ApolloEngine)this.a.get();
      if (localApolloEngine != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("run js =");
        localStringBuilder.append(this.b);
        QLog.d("[cmshow]ApolloRenderDriver", 2, localStringBuilder.toString());
        localApolloEngine.execScriptString(this.b);
        if (!this.this$0.f.get()) {
          localApolloEngine.drawSpecialFrame(0.0D);
        }
      }
      return;
    }
    finally
    {
      this.c.unlock();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloRenderDriver.RenderThreadRunnable
 * JD-Core Version:    0.7.0.1
 */