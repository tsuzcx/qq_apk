package com.tencent.mobileqq.utils;

import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.TimeUnit;
import org.apache.http.conn.ClientConnectionManager;

public class HttpDownloadUtil$IdleConnectionMonitorThread
  extends Thread
{
  private final ClientConnectionManager a;
  private volatile boolean b;
  
  public HttpDownloadUtil$IdleConnectionMonitorThread(ClientConnectionManager paramClientConnectionManager)
  {
    this.a = paramClientConnectionManager;
  }
  
  public void a()
  {
    this.b = true;
    try
    {
      notifyAll();
      return;
    }
    finally {}
  }
  
  public void run()
  {
    while (!this.b)
    {
      try
      {
        try
        {
          wait(30000L);
        }
        finally
        {
          break label83;
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        label23:
        label83:
        break label23;
      }
      try
      {
        this.a.closeExpiredConnections();
        this.a.closeIdleConnections(60L, TimeUnit.SECONDS);
      }
      catch (Throwable localThrowable)
      {
        QLog.e("HttpDownloadUtil", 1, "", localThrowable);
      }
      if (System.currentTimeMillis() - HttpDownloadUtil.lastUseTime > 300000L)
      {
        a();
        continue;
        throw localThrowable;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.HttpDownloadUtil.IdleConnectionMonitorThread
 * JD-Core Version:    0.7.0.1
 */