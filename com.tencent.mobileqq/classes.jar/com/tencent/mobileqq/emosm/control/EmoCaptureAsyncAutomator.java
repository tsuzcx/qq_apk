package com.tencent.mobileqq.emosm.control;

import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class EmoCaptureAsyncAutomator
  extends EmoAutomator
  implements Runnable
{
  protected EmoAsyncStep e = null;
  protected final LinkedList<EmoAsyncStep> f = new LinkedList();
  protected ThreadPoolExecutor g;
  
  private void b()
  {
    this.g = new ThreadPoolExecutor(3, 3, 1000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(24), new EmoCaptureAsyncAutomator.MyThreadFactory(this, null));
    this.g.allowCoreThreadTimeOut(true);
  }
  
  private void c(EmoAsyncStep paramEmoAsyncStep)
  {
    this.f.add(paramEmoAsyncStep);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("addWaitingMode_Locked ");
      localStringBuilder.append(paramEmoAsyncStep.h);
      QLog.d("EmoCaptureAsyncAutomator", 2, localStringBuilder.toString());
    }
  }
  
  public void a(EmoAsyncStep paramEmoAsyncStep)
  {
    synchronized (this.d)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("CameraEmo, mCountRunning ");
      localStringBuilder.append(this.c);
      QLog.d("EmoCaptureAsyncAutomator", 1, localStringBuilder.toString());
      if (this.c < 3)
      {
        this.c += 1;
        if (this.g == null) {
          b();
        }
        this.g.execute(paramEmoAsyncStep);
      }
      else
      {
        this.d.add(paramEmoAsyncStep);
      }
      return;
    }
  }
  
  public void b(EmoAsyncStep paramEmoAsyncStep)
  {
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("start ");
      ((StringBuilder)???).append(paramEmoAsyncStep.h);
      QLog.d("EmoCaptureAsyncAutomator", 2, ((StringBuilder)???).toString());
    }
    synchronized (this.f)
    {
      if (this.e == null)
      {
        this.e = paramEmoAsyncStep;
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("run ");
          localStringBuilder.append(paramEmoAsyncStep.h);
          QLog.d("EmoCaptureAsyncAutomator", 2, localStringBuilder.toString());
        }
        if (this.g == null) {
          b();
        }
        this.g.execute(this);
      }
      else
      {
        c(paramEmoAsyncStep);
      }
      return;
    }
  }
  
  public void run()
  {
    for (;;)
    {
      ??? = this.e;
      if (??? != null) {
        ((EmoAsyncStep)???).run();
      }
      synchronized (this.f)
      {
        this.e = ((EmoAsyncStep)this.f.poll());
        if (this.e == null) {
          return;
        }
      }
    }
    for (;;)
    {
      throw localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.control.EmoCaptureAsyncAutomator
 * JD-Core Version:    0.7.0.1
 */