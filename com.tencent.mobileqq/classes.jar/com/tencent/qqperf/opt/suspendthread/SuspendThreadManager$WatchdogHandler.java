package com.tencent.qqperf.opt.suspendthread;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;

class SuspendThreadManager$WatchdogHandler
  extends Handler
{
  private Thread b;
  private SuspendThreadManager.GuardThreadHandler c;
  private boolean d = false;
  
  public SuspendThreadManager$WatchdogHandler(SuspendThreadManager paramSuspendThreadManager, Looper paramLooper, Thread paramThread, SuspendThreadManager.GuardThreadHandler paramGuardThreadHandler)
  {
    super(paramLooper);
    this.b = paramThread;
    this.c = paramGuardThreadHandler;
  }
  
  public void a()
  {
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    sendMessageDelayed(localMessage, 200L);
  }
  
  public void b()
  {
    removeMessages(1);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1) {
      return;
    }
    if (this.b.getState() == Thread.State.BLOCKED)
    {
      if (this.d == true)
      {
        SuspendThreadManager.a(this.a, SuspendThreadManager.f());
        SuspendThreadManager.a(1);
        b();
        this.c.a();
        return;
      }
      this.d = true;
      a();
      return;
    }
    if (!SuspendThreadManager.g().isEmpty())
    {
      this.d = false;
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqperf.opt.suspendthread.SuspendThreadManager.WatchdogHandler
 * JD-Core Version:    0.7.0.1
 */