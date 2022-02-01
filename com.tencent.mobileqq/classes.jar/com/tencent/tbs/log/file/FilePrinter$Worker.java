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
      finally {}
    }
  }
  
  void start()
  {
    try
    {
      new Thread(this).start();
      this.started = true;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.log.file.FilePrinter.Worker
 * JD-Core Version:    0.7.0.1
 */