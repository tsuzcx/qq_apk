package com.tencent.tbs.log.file;

import com.tencent.tbs.log.LogItem;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class FilePrinter$Worker
  implements Runnable
{
  private BlockingQueue<LogItem> logs = new LinkedBlockingQueue();
  private volatile boolean started;
  
  private FilePrinter$Worker(FilePrinter paramFilePrinter) {}
  
  public void close()
  {
    try
    {
      this.logs.clear();
      this.started = false;
      return;
    }
    finally {}
  }
  
  void enqueue(LogItem paramLogItem)
  {
    try
    {
      this.logs.put(paramLogItem);
      return;
    }
    catch (InterruptedException paramLogItem)
    {
      paramLogItem.printStackTrace();
    }
  }
  
  boolean isStarted()
  {
    try
    {
      boolean bool = this.started;
      return bool;
    }
    finally {}
  }
  
  public void run()
  {
    try
    {
      for (;;)
      {
        LogItem localLogItem = (LogItem)this.logs.take();
        if (localLogItem == null) {
          break;
        }
        FilePrinter.access$200(this.this$0, localLogItem);
      }
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      localInterruptedException.printStackTrace();
      try
      {
        this.started = false;
        return;
      }
      finally
      {
        for (;;)
        {
          throw localObject;
        }
      }
    }
  }
  
  /* Error */
  void start()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 68	java/lang/Thread
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 71	java/lang/Thread:<init>	(Ljava/lang/Runnable;)V
    //   10: invokevirtual 73	java/lang/Thread:start	()V
    //   13: aload_0
    //   14: iconst_1
    //   15: putfield 37	com/tencent/tbs/log/file/FilePrinter$Worker:started	Z
    //   18: goto +12 -> 30
    //   21: astore_1
    //   22: goto +11 -> 33
    //   25: astore_1
    //   26: aload_1
    //   27: invokevirtual 74	java/lang/Exception:printStackTrace	()V
    //   30: aload_0
    //   31: monitorexit
    //   32: return
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_1
    //   36: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	37	0	this	Worker
    //   21	1	1	localObject	Object
    //   25	11	1	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   2	18	21	finally
    //   26	30	21	finally
    //   30	32	21	finally
    //   33	35	21	finally
    //   2	18	25	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.log.file.FilePrinter.Worker
 * JD-Core Version:    0.7.0.1
 */