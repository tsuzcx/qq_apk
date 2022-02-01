package com.tencent.mobileqq.utils;

import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.TimeUnit;
import org.apache.http.conn.ClientConnectionManager;

public class HttpDownloadUtil$IdleConnectionMonitorThread
  extends Thread
{
  private final ClientConnectionManager jdField_a_of_type_OrgApacheHttpConnClientConnectionManager;
  private volatile boolean jdField_a_of_type_Boolean;
  
  public HttpDownloadUtil$IdleConnectionMonitorThread(ClientConnectionManager paramClientConnectionManager)
  {
    this.jdField_a_of_type_OrgApacheHttpConnClientConnectionManager = paramClientConnectionManager;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    try
    {
      notifyAll();
      return;
    }
    finally {}
  }
  
  public void run()
  {
    while (!this.jdField_a_of_type_Boolean)
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
        this.jdField_a_of_type_OrgApacheHttpConnClientConnectionManager.closeExpiredConnections();
        this.jdField_a_of_type_OrgApacheHttpConnClientConnectionManager.closeIdleConnections(60L, TimeUnit.SECONDS);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.HttpDownloadUtil.IdleConnectionMonitorThread
 * JD-Core Version:    0.7.0.1
 */