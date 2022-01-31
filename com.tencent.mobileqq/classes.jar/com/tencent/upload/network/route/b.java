package com.tencent.upload.network.route;

import com.tencent.upload.common.UploadConfiguration;

public class b
{
  public static void a(String paramString, final a parama)
  {
    com.tencent.upload.common.b.c("DomainParser", "parse: start, domainName:" + paramString);
    if (paramString == null)
    {
      com.tencent.upload.common.b.c("DomainParser", "parse: return, domainName == null");
      return;
    }
    synchronized (new byte[0])
    {
      new Thread(new Runnable()
      {
        /* Error */
        public void run()
        {
          // Byte code:
          //   0: invokestatic 41	java/lang/Thread:currentThread	()Ljava/lang/Thread;
          //   3: invokevirtual 45	java/lang/Thread:getName	()Ljava/lang/String;
          //   6: astore_3
          //   7: aload_0
          //   8: getfield 20	com/tencent/upload/network/route/b$1:a	Ljava/lang/String;
          //   11: invokestatic 51	java/net/InetAddress:getByName	(Ljava/lang/String;)Ljava/net/InetAddress;
          //   14: invokevirtual 54	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
          //   17: astore_1
          //   18: ldc 56
          //   20: new 58	java/lang/StringBuilder
          //   23: dup
          //   24: invokespecial 59	java/lang/StringBuilder:<init>	()V
          //   27: ldc 61
          //   29: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   32: aload_1
          //   33: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   36: ldc 67
          //   38: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   41: aload_0
          //   42: getfield 20	com/tencent/upload/network/route/b$1:a	Ljava/lang/String;
          //   45: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   48: ldc 69
          //   50: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   53: aload_3
          //   54: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   57: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   60: invokestatic 77	com/tencent/upload/common/b:c	(Ljava/lang/String;Ljava/lang/String;)V
          //   63: aload_0
          //   64: getfield 22	com/tencent/upload/network/route/b$1:b	[B
          //   67: astore_2
          //   68: aload_2
          //   69: monitorenter
          //   70: aload_0
          //   71: getfield 24	com/tencent/upload/network/route/b$1:c	Lcom/tencent/upload/network/route/b$a;
          //   74: aload_1
          //   75: putfield 80	com/tencent/upload/network/route/b$a:a	Ljava/lang/String;
          //   78: ldc 56
          //   80: new 58	java/lang/StringBuilder
          //   83: dup
          //   84: invokespecial 59	java/lang/StringBuilder:<init>	()V
          //   87: ldc 82
          //   89: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   92: aload_0
          //   93: getfield 24	com/tencent/upload/network/route/b$1:c	Lcom/tencent/upload/network/route/b$a;
          //   96: getfield 80	com/tencent/upload/network/route/b$a:a	Ljava/lang/String;
          //   99: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   102: ldc 67
          //   104: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   107: aload_0
          //   108: getfield 20	com/tencent/upload/network/route/b$1:a	Ljava/lang/String;
          //   111: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   114: ldc 69
          //   116: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   119: aload_3
          //   120: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   123: ldc 84
          //   125: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   128: aload_0
          //   129: getfield 22	com/tencent/upload/network/route/b$1:b	[B
          //   132: invokevirtual 88	java/lang/Object:hashCode	()I
          //   135: invokevirtual 91	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
          //   138: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   141: invokestatic 77	com/tencent/upload/common/b:c	(Ljava/lang/String;Ljava/lang/String;)V
          //   144: aload_0
          //   145: getfield 22	com/tencent/upload/network/route/b$1:b	[B
          //   148: invokevirtual 94	java/lang/Object:notify	()V
          //   151: aload_2
          //   152: monitorexit
          //   153: return
          //   154: astore_2
          //   155: aconst_null
          //   156: astore_1
          //   157: ldc 56
          //   159: new 58	java/lang/StringBuilder
          //   162: dup
          //   163: invokespecial 59	java/lang/StringBuilder:<init>	()V
          //   166: ldc 96
          //   168: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   171: aload_2
          //   172: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
          //   175: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   178: invokestatic 102	com/tencent/upload/common/b:d	(Ljava/lang/String;Ljava/lang/String;)V
          //   181: goto -118 -> 63
          //   184: astore_2
          //   185: aconst_null
          //   186: astore_1
          //   187: ldc 56
          //   189: new 58	java/lang/StringBuilder
          //   192: dup
          //   193: invokespecial 59	java/lang/StringBuilder:<init>	()V
          //   196: ldc 104
          //   198: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   201: aload_2
          //   202: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
          //   205: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   208: invokestatic 102	com/tencent/upload/common/b:d	(Ljava/lang/String;Ljava/lang/String;)V
          //   211: goto -148 -> 63
          //   214: astore_2
          //   215: aconst_null
          //   216: astore_1
          //   217: ldc 56
          //   219: new 58	java/lang/StringBuilder
          //   222: dup
          //   223: invokespecial 59	java/lang/StringBuilder:<init>	()V
          //   226: ldc 106
          //   228: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   231: aload_2
          //   232: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
          //   235: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   238: invokestatic 102	com/tencent/upload/common/b:d	(Ljava/lang/String;Ljava/lang/String;)V
          //   241: goto -178 -> 63
          //   244: astore_1
          //   245: aload_2
          //   246: monitorexit
          //   247: aload_1
          //   248: athrow
          //   249: astore_2
          //   250: goto -33 -> 217
          //   253: astore_2
          //   254: goto -67 -> 187
          //   257: astore_2
          //   258: goto -101 -> 157
          // Local variable table:
          //   start	length	slot	name	signature
          //   0	261	0	this	1
          //   17	200	1	str1	String
          //   244	4	1	localObject	Object
          //   154	18	2	localUnknownHostException1	java.net.UnknownHostException
          //   184	18	2	localException1	java.lang.Exception
          //   214	32	2	localError1	java.lang.Error
          //   249	1	2	localError2	java.lang.Error
          //   253	1	2	localException2	java.lang.Exception
          //   257	1	2	localUnknownHostException2	java.net.UnknownHostException
          //   6	114	3	str2	String
          // Exception table:
          //   from	to	target	type
          //   7	18	154	java/net/UnknownHostException
          //   7	18	184	java/lang/Exception
          //   7	18	214	java/lang/Error
          //   70	153	244	finally
          //   245	247	244	finally
          //   18	63	249	java/lang/Error
          //   18	63	253	java/lang/Exception
          //   18	63	257	java/net/UnknownHostException
        }
      }, "domainParser" + System.currentTimeMillis()).start();
    }
    try
    {
      ???.wait(UploadConfiguration.getDomainNameParseTimeout());
      com.tencent.upload.common.b.c("DomainParser", "parse return, get domainName:" + paramString + " to ip:" + parama.a + " lock obj :" + ???.hashCode());
      return;
      paramString = finally;
      throw paramString;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        com.tencent.upload.common.b.d("DomainParser", "parse: wait:" + localInterruptedException);
      }
    }
  }
  
  public static final class a
  {
    public volatile String a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.upload.network.route.b
 * JD-Core Version:    0.7.0.1
 */