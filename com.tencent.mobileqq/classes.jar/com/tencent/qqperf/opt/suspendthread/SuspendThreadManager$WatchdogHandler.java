package com.tencent.qqperf.opt.suspendthread;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;

class SuspendThreadManager$WatchdogHandler
  extends Handler
{
  private SuspendThreadManager.GuardThreadHandler jdField_a_of_type_ComTencentQqperfOptSuspendthreadSuspendThreadManager$GuardThreadHandler;
  private Thread jdField_a_of_type_JavaLangThread;
  private boolean jdField_a_of_type_Boolean = false;
  
  public SuspendThreadManager$WatchdogHandler(SuspendThreadManager paramSuspendThreadManager, Looper paramLooper, Thread paramThread, SuspendThreadManager.GuardThreadHandler paramGuardThreadHandler)
  {
    super(paramLooper);
    this.jdField_a_of_type_JavaLangThread = paramThread;
    this.jdField_a_of_type_ComTencentQqperfOptSuspendthreadSuspendThreadManager$GuardThreadHandler = paramGuardThreadHandler;
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
    if (this.jdField_a_of_type_JavaLangThread.getState() == Thread.State.BLOCKED)
    {
      if (this.jdField_a_of_type_Boolean == true)
      {
        SuspendThreadManager.a(this.jdField_a_of_type_ComTencentQqperfOptSuspendthreadSuspendThreadManager, SuspendThreadManager.a());
        SuspendThreadManager.a(1);
        b();
        this.jdField_a_of_type_ComTencentQqperfOptSuspendthreadSuspendThreadManager$GuardThreadHandler.a();
        return;
      }
      this.jdField_a_of_type_Boolean = true;
      a();
      return;
    }
    if (!SuspendThreadManager.a().isEmpty())
    {
      this.jdField_a_of_type_Boolean = false;
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqperf.opt.suspendthread.SuspendThreadManager.WatchdogHandler
 * JD-Core Version:    0.7.0.1
 */