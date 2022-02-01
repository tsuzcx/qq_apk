package com.tencent.qqmini.sdk.report;

public class GdtCgiReportRunnable
  implements Runnable
{
  private static final String TAG = "GdtCgiReportRunnable";
  private String cgiUrl;
  protected boolean mSuccess = false;
  
  GdtCgiReportRunnable(String paramString)
  {
    this.cgiUrl = paramString;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: new 28	java/net/URL
    //   3: dup
    //   4: aload_0
    //   5: getfield 22	com/tencent/qqmini/sdk/report/GdtCgiReportRunnable:cgiUrl	Ljava/lang/String;
    //   8: invokespecial 30	java/net/URL:<init>	(Ljava/lang/String;)V
    //   11: invokevirtual 34	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   14: checkcast 36	java/net/HttpURLConnection
    //   17: astore_1
    //   18: aload_1
    //   19: astore_2
    //   20: aload_1
    //   21: ldc 38
    //   23: ldc 40
    //   25: invokevirtual 44	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   28: aload_1
    //   29: astore_2
    //   30: aload_1
    //   31: invokevirtual 47	java/net/HttpURLConnection:connect	()V
    //   34: aload_1
    //   35: astore_2
    //   36: aload_1
    //   37: invokevirtual 51	java/net/HttpURLConnection:getResponseCode	()I
    //   40: sipush 200
    //   43: if_icmpne +10 -> 53
    //   46: aload_1
    //   47: astore_2
    //   48: aload_0
    //   49: iconst_1
    //   50: putfield 20	com/tencent/qqmini/sdk/report/GdtCgiReportRunnable:mSuccess	Z
    //   53: aload_1
    //   54: ifnull +52 -> 106
    //   57: aload_1
    //   58: invokevirtual 54	java/net/HttpURLConnection:disconnect	()V
    //   61: return
    //   62: astore_3
    //   63: goto +12 -> 75
    //   66: astore_1
    //   67: aconst_null
    //   68: astore_2
    //   69: goto +39 -> 108
    //   72: astore_3
    //   73: aconst_null
    //   74: astore_1
    //   75: aload_1
    //   76: astore_2
    //   77: ldc 10
    //   79: ldc 56
    //   81: iconst_1
    //   82: anewarray 4	java/lang/Object
    //   85: dup
    //   86: iconst_0
    //   87: aload_0
    //   88: getfield 22	com/tencent/qqmini/sdk/report/GdtCgiReportRunnable:cgiUrl	Ljava/lang/String;
    //   91: aastore
    //   92: invokestatic 62	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   95: aload_3
    //   96: invokestatic 68	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   99: aload_1
    //   100: ifnull +6 -> 106
    //   103: goto -46 -> 57
    //   106: return
    //   107: astore_1
    //   108: aload_2
    //   109: ifnull +7 -> 116
    //   112: aload_2
    //   113: invokevirtual 54	java/net/HttpURLConnection:disconnect	()V
    //   116: goto +5 -> 121
    //   119: aload_1
    //   120: athrow
    //   121: goto -2 -> 119
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	124	0	this	GdtCgiReportRunnable
    //   17	41	1	localHttpURLConnection	java.net.HttpURLConnection
    //   66	1	1	localObject1	Object
    //   74	26	1	localObject2	Object
    //   107	13	1	localObject3	Object
    //   19	94	2	localObject4	Object
    //   62	1	3	localThrowable1	java.lang.Throwable
    //   72	24	3	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   20	28	62	java/lang/Throwable
    //   30	34	62	java/lang/Throwable
    //   36	46	62	java/lang/Throwable
    //   48	53	62	java/lang/Throwable
    //   0	18	66	finally
    //   0	18	72	java/lang/Throwable
    //   20	28	107	finally
    //   30	34	107	finally
    //   36	46	107	finally
    //   48	53	107	finally
    //   77	99	107	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.report.GdtCgiReportRunnable
 * JD-Core Version:    0.7.0.1
 */