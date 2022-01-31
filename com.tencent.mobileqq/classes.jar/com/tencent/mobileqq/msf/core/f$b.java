package com.tencent.mobileqq.msf.core;

import com.tencent.mobileqq.a.a.a;
import com.tencent.mobileqq.monitor.MsfMonitorCallback;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ThreadPoolExecutor;

class f$b
  implements Runnable
{
  public ToServiceMsg a;
  
  f$b(f paramf, ToServiceMsg paramToServiceMsg)
  {
    this.a = paramToServiceMsg;
  }
  
  public void run()
  {
    do
    {
      try
      {
        if ((f.a(this.b) != null) && (f.a(this.b).mMsfMonitorCallback != null)) {
          f.a(this.b).mMsfMonitorCallback.handleStart(3);
        }
        Object localObject1 = Thread.currentThread().getName();
        int i = f.b(this.b).getActiveCount();
        if (QLog.isColorLevel()) {
          QLog.d("LightSender", 2, "threadName: " + (String)localObject1 + " threadPoolAccount: " + i);
        }
        localObject1 = this.a;
        if (localObject1 == null) {
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        QLog.d("LightSender", 1, "LightSender sendTask exception,", localException);
        return;
      }
      finally
      {
        if ((f.a(this.b) == null) || (f.a(this.b).mMsfMonitorCallback == null)) {
          break;
        }
        f.a(this.b).mMsfMonitorCallback.handleEnd(3);
      }
      f.c(this.b).add(this.a);
      a.a().c(this.a);
      this.b.c(this.a);
      this.b.b(this.a);
    } while ((f.a(this.b) == null) || (f.a(this.b).mMsfMonitorCallback == null));
    f.a(this.b).mMsfMonitorCallback.handleEnd(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.f.b
 * JD-Core Version:    0.7.0.1
 */