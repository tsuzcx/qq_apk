package com.tencent.mobileqq.cmshow.brickengine.apollo;

import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

class ApolloRenderDriver$4
  extends IApolloRunnableTask
{
  ApolloRenderDriver$4(ApolloRenderDriver paramApolloRenderDriver, String[] paramArrayOfString) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloRenderDriver", 2, "start run.");
    }
    this.this$0.c.lock();
    int i = 0;
    try
    {
      while (i < this.a.length)
      {
        this.this$0.b.execScriptString(this.a[i]);
        i += 1;
      }
      this.this$0.c.unlock();
      if ((!this.this$0.f.get()) && (this.this$0.a != null)) {
        this.this$0.a.onRender();
      }
      return;
    }
    finally
    {
      this.this$0.c.unlock();
    }
    for (;;)
    {
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloRenderDriver.4
 * JD-Core Version:    0.7.0.1
 */