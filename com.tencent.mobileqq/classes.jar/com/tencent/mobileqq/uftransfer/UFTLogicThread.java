package com.tencent.mobileqq.uftransfer;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.mobileqq.uftransfer.depend.UFTLog;

public class UFTLogicThread
{
  private static UFTLogicThread a;
  private HandlerThread b;
  private Handler c;
  
  private UFTLogicThread()
  {
    b();
  }
  
  public static UFTLogicThread a()
  {
    try
    {
      if (a == null) {
        a = new UFTLogicThread();
      } else {
        a.b();
      }
      UFTLogicThread localUFTLogicThread = a;
      return localUFTLogicThread;
    }
    finally {}
  }
  
  private void b()
  {
    try
    {
      HandlerThread localHandlerThread = this.b;
      if (localHandlerThread != null) {
        return;
      }
      this.b = new HandlerThread("UFTTransferLogicThread");
      this.b.start();
      this.c = new Handler(this.b.getLooper());
      UFTLog.b("[UFTTransfer] UFTLogicThread", 1, "transfer logicThread start...");
      return;
    }
    finally {}
  }
  
  public void a(Runnable paramRunnable)
  {
    if (paramRunnable == null) {
      return;
    }
    this.c.post(paramRunnable);
  }
  
  public void a(Runnable paramRunnable, long paramLong)
  {
    if (paramRunnable == null) {
      return;
    }
    this.c.postDelayed(paramRunnable, paramLong);
  }
  
  public void b(Runnable paramRunnable)
  {
    if (paramRunnable == null) {
      return;
    }
    if (Thread.currentThread() != this.c.getLooper().getThread())
    {
      this.c.post(paramRunnable);
      return;
    }
    paramRunnable.run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.UFTLogicThread
 * JD-Core Version:    0.7.0.1
 */