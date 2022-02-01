package org.apache.commons.io;

class ThreadMonitor
  implements Runnable
{
  private final Thread thread;
  private final long timeout;
  
  private ThreadMonitor(Thread paramThread, long paramLong)
  {
    this.thread = paramThread;
    this.timeout = paramLong;
  }
  
  private static void sleep(long paramLong)
  {
    long l3 = System.currentTimeMillis();
    long l1 = paramLong;
    long l2;
    do
    {
      Thread.sleep(l1);
      l2 = l3 + paramLong - System.currentTimeMillis();
      l1 = l2;
    } while (l2 > 0L);
  }
  
  public static Thread start(long paramLong)
  {
    return start(Thread.currentThread(), paramLong);
  }
  
  public static Thread start(Thread paramThread, long paramLong)
  {
    if (paramLong > 0L)
    {
      paramThread = new Thread(new ThreadMonitor(paramThread, paramLong), ThreadMonitor.class.getSimpleName());
      paramThread.setDaemon(true);
      paramThread.start();
      return paramThread;
    }
    return null;
  }
  
  public static void stop(Thread paramThread)
  {
    if (paramThread != null) {
      paramThread.interrupt();
    }
  }
  
  public void run()
  {
    try
    {
      sleep(this.timeout);
      this.thread.interrupt();
      return;
    }
    catch (InterruptedException localInterruptedException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.apache.commons.io.ThreadMonitor
 * JD-Core Version:    0.7.0.1
 */