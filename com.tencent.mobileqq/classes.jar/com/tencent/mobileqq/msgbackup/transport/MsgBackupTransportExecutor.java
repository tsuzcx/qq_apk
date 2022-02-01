package com.tencent.mobileqq.msgbackup.transport;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadPoolParams;
import com.tencent.mobileqq.msgbackup.util.MsgBackupUtil;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

public class MsgBackupTransportExecutor
{
  private static MsgBackupTransportExecutor b;
  private Executor a;
  private AtomicBoolean c = new AtomicBoolean(false);
  
  private MsgBackupTransportExecutor()
  {
    if (this.a == null)
    {
      int i = Runtime.getRuntime().availableProcessors();
      ThreadPoolParams localThreadPoolParams = new ThreadPoolParams();
      localThreadPoolParams.corePoolsize = i;
      localThreadPoolParams.maxPooolSize = i;
      localThreadPoolParams.priority = 5;
      localThreadPoolParams.poolThreadName = "msgbackup_Tranport_Executor";
      this.a = ThreadManager.newFreeThreadPool(localThreadPoolParams);
    }
  }
  
  public static MsgBackupTransportExecutor a()
  {
    try
    {
      if (b == null) {
        b = new MsgBackupTransportExecutor();
      }
      MsgBackupTransportExecutor localMsgBackupTransportExecutor = b;
      return localMsgBackupTransportExecutor;
    }
    finally {}
  }
  
  public void a(Runnable paramRunnable)
  {
    Executor localExecutor = this.a;
    if (localExecutor == null)
    {
      MsgBackupUtil.a("MsgBackupMsgBackupTransportExecutor", "thread pool is destroyed!", new Object[0]);
      return;
    }
    localExecutor.execute(paramRunnable);
  }
  
  public void b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("msgbackup destroy-------------> destroyed = ");
    localStringBuilder.append(this.c.get());
    MsgBackupUtil.a("MsgBackupMsgBackupTransportExecutor", localStringBuilder.toString(), new Object[0]);
    if (this.c.get()) {
      return;
    }
    this.c.set(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.transport.MsgBackupTransportExecutor
 * JD-Core Version:    0.7.0.1
 */