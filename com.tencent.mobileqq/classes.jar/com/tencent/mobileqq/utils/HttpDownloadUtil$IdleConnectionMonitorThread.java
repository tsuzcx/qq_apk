package com.tencent.mobileqq.utils;

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
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 17	com/tencent/mobileqq/utils/HttpDownloadUtil$IdleConnectionMonitorThread:jdField_a_of_type_Boolean	Z
    //   4: ifne +81 -> 85
    //   7: aload_0
    //   8: monitorenter
    //   9: aload_0
    //   10: ldc2_w 28
    //   13: invokevirtual 33	java/lang/Object:wait	(J)V
    //   16: aload_0
    //   17: monitorexit
    //   18: aload_0
    //   19: getfield 14	com/tencent/mobileqq/utils/HttpDownloadUtil$IdleConnectionMonitorThread:jdField_a_of_type_OrgApacheHttpConnClientConnectionManager	Lorg/apache/http/conn/ClientConnectionManager;
    //   22: invokeinterface 38 1 0
    //   27: aload_0
    //   28: getfield 14	com/tencent/mobileqq/utils/HttpDownloadUtil$IdleConnectionMonitorThread:jdField_a_of_type_OrgApacheHttpConnClientConnectionManager	Lorg/apache/http/conn/ClientConnectionManager;
    //   31: ldc2_w 39
    //   34: getstatic 46	java/util/concurrent/TimeUnit:SECONDS	Ljava/util/concurrent/TimeUnit;
    //   37: invokeinterface 50 4 0
    //   42: invokestatic 56	java/lang/System:currentTimeMillis	()J
    //   45: getstatic 61	com/tencent/mobileqq/utils/HttpDownloadUtil:a	J
    //   48: lsub
    //   49: ldc2_w 62
    //   52: lcmp
    //   53: ifle -53 -> 0
    //   56: aload_0
    //   57: invokevirtual 65	com/tencent/mobileqq/utils/HttpDownloadUtil$IdleConnectionMonitorThread:a	()V
    //   60: goto -60 -> 0
    //   63: astore_1
    //   64: aload_0
    //   65: monitorexit
    //   66: aload_1
    //   67: athrow
    //   68: astore_1
    //   69: ldc 67
    //   71: iconst_1
    //   72: ldc 69
    //   74: aload_1
    //   75: invokestatic 75	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   78: goto -36 -> 42
    //   81: astore_1
    //   82: goto -66 -> 16
    //   85: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	86	0	this	IdleConnectionMonitorThread
    //   63	4	1	localObject	Object
    //   68	7	1	localThrowable	java.lang.Throwable
    //   81	1	1	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   9	16	63	finally
    //   16	18	63	finally
    //   64	66	63	finally
    //   18	42	68	java/lang/Throwable
    //   9	16	81	java/lang/InterruptedException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.utils.HttpDownloadUtil.IdleConnectionMonitorThread
 * JD-Core Version:    0.7.0.1
 */