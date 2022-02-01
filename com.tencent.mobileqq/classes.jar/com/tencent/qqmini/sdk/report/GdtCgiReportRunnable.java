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
    //   0: aconst_null
    //   1: astore_1
    //   2: aconst_null
    //   3: astore_3
    //   4: new 28	java/net/URL
    //   7: dup
    //   8: aload_0
    //   9: getfield 22	com/tencent/qqmini/sdk/report/GdtCgiReportRunnable:cgiUrl	Ljava/lang/String;
    //   12: invokespecial 30	java/net/URL:<init>	(Ljava/lang/String;)V
    //   15: invokevirtual 34	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   18: checkcast 36	java/net/HttpURLConnection
    //   21: astore_2
    //   22: aload_2
    //   23: ldc 38
    //   25: ldc 40
    //   27: invokevirtual 44	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   30: aload_2
    //   31: invokevirtual 47	java/net/HttpURLConnection:connect	()V
    //   34: aload_2
    //   35: invokevirtual 51	java/net/HttpURLConnection:getResponseCode	()I
    //   38: sipush 200
    //   41: if_icmpne +8 -> 49
    //   44: aload_0
    //   45: iconst_1
    //   46: putfield 20	com/tencent/qqmini/sdk/report/GdtCgiReportRunnable:mSuccess	Z
    //   49: aload_2
    //   50: ifnull +7 -> 57
    //   53: aload_2
    //   54: invokevirtual 54	java/net/HttpURLConnection:disconnect	()V
    //   57: return
    //   58: astore_1
    //   59: aload_3
    //   60: astore_2
    //   61: aload_1
    //   62: astore_3
    //   63: aload_2
    //   64: astore_1
    //   65: ldc 10
    //   67: ldc 56
    //   69: iconst_1
    //   70: anewarray 4	java/lang/Object
    //   73: dup
    //   74: iconst_0
    //   75: aload_0
    //   76: getfield 22	com/tencent/qqmini/sdk/report/GdtCgiReportRunnable:cgiUrl	Ljava/lang/String;
    //   79: aastore
    //   80: invokestatic 62	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   83: aload_3
    //   84: invokestatic 68	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   87: aload_2
    //   88: ifnull -31 -> 57
    //   91: aload_2
    //   92: invokevirtual 54	java/net/HttpURLConnection:disconnect	()V
    //   95: return
    //   96: astore_3
    //   97: aload_1
    //   98: astore_2
    //   99: aload_3
    //   100: astore_1
    //   101: aload_2
    //   102: ifnull +7 -> 109
    //   105: aload_2
    //   106: invokevirtual 54	java/net/HttpURLConnection:disconnect	()V
    //   109: aload_1
    //   110: athrow
    //   111: astore_1
    //   112: goto -11 -> 101
    //   115: astore_3
    //   116: goto -53 -> 63
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	119	0	this	GdtCgiReportRunnable
    //   1	1	1	localObject1	Object
    //   58	4	1	localThrowable1	java.lang.Throwable
    //   64	46	1	localObject2	Object
    //   111	1	1	localObject3	Object
    //   21	85	2	localObject4	Object
    //   3	81	3	localThrowable2	java.lang.Throwable
    //   96	4	3	localObject5	Object
    //   115	1	3	localThrowable3	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   4	22	58	java/lang/Throwable
    //   4	22	96	finally
    //   65	87	96	finally
    //   22	49	111	finally
    //   22	49	115	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.report.GdtCgiReportRunnable
 * JD-Core Version:    0.7.0.1
 */