package org.apache.commons.io.monitor;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadFactory;

public final class FileAlterationMonitor
  implements Runnable
{
  private final long interval;
  private final List<FileAlterationObserver> observers = new CopyOnWriteArrayList();
  private volatile boolean running = false;
  private Thread thread = null;
  private ThreadFactory threadFactory;
  
  public FileAlterationMonitor()
  {
    this(10000L);
  }
  
  public FileAlterationMonitor(long paramLong)
  {
    this.interval = paramLong;
  }
  
  public FileAlterationMonitor(long paramLong, FileAlterationObserver... paramVarArgs)
  {
    this(paramLong);
    if (paramVarArgs != null)
    {
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        addObserver(paramVarArgs[i]);
        i += 1;
      }
    }
  }
  
  public void addObserver(FileAlterationObserver paramFileAlterationObserver)
  {
    if (paramFileAlterationObserver != null) {
      this.observers.add(paramFileAlterationObserver);
    }
  }
  
  public long getInterval()
  {
    return this.interval;
  }
  
  public Iterable<FileAlterationObserver> getObservers()
  {
    return this.observers;
  }
  
  public void removeObserver(FileAlterationObserver paramFileAlterationObserver)
  {
    while ((paramFileAlterationObserver != null) && (this.observers.remove(paramFileAlterationObserver))) {}
  }
  
  public void run()
  {
    while (this.running)
    {
      Iterator localIterator = this.observers.iterator();
      while (localIterator.hasNext()) {
        ((FileAlterationObserver)localIterator.next()).checkAndNotify();
      }
      if (!this.running) {
        return;
      }
      try
      {
        Thread.sleep(this.interval);
      }
      catch (InterruptedException localInterruptedException)
      {
        label59:
        break label59;
      }
    }
  }
  
  public void setThreadFactory(ThreadFactory paramThreadFactory)
  {
    try
    {
      this.threadFactory = paramThreadFactory;
      return;
    }
    finally
    {
      paramThreadFactory = finally;
      throw paramThreadFactory;
    }
  }
  
  public void start()
  {
    try
    {
      if (!this.running)
      {
        Iterator localIterator = this.observers.iterator();
        while (localIterator.hasNext()) {
          ((FileAlterationObserver)localIterator.next()).initialize();
        }
        this.running = true;
        if (this.threadFactory != null) {
          this.thread = this.threadFactory.newThread(this);
        } else {
          this.thread = new Thread(this);
        }
        this.thread.start();
        return;
      }
      throw new IllegalStateException("Monitor is already running");
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void stop()
  {
    try
    {
      stop(this.interval);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void stop(long paramLong)
  {
    try
    {
      if (this.running) {
        this.running = false;
      }
    }
    finally
    {
      label25:
      Iterator localIterator;
      for (;;)
      {
        throw localObject;
      }
    }
    try
    {
      this.thread.join(paramLong);
    }
    catch (InterruptedException localInterruptedException)
    {
      break label25;
    }
    Thread.currentThread().interrupt();
    localIterator = this.observers.iterator();
    while (localIterator.hasNext()) {
      ((FileAlterationObserver)localIterator.next()).destroy();
    }
    return;
    throw new IllegalStateException("Monitor is not running");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.apache.commons.io.monitor.FileAlterationMonitor
 * JD-Core Version:    0.7.0.1
 */