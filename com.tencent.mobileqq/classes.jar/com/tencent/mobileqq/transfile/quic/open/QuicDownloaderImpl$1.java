package com.tencent.mobileqq.transfile.quic.open;

class QuicDownloaderImpl$1
  implements Runnable
{
  QuicDownloaderImpl$1(QuicDownloaderImpl paramQuicDownloaderImpl, String paramString1, QuicDownloader.Builder paramBuilder, String paramString2, String paramString3) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 18	com/tencent/mobileqq/transfile/quic/open/QuicDownloaderImpl$1:this$0	Lcom/tencent/mobileqq/transfile/quic/open/QuicDownloaderImpl;
    //   4: invokestatic 39	com/tencent/mobileqq/transfile/quic/open/QuicDownloaderImpl:access$000	(Lcom/tencent/mobileqq/transfile/quic/open/QuicDownloaderImpl;)Ljava/util/concurrent/ConcurrentHashMap;
    //   7: aload_0
    //   8: getfield 20	com/tencent/mobileqq/transfile/quic/open/QuicDownloaderImpl$1:val$tempPath	Ljava/lang/String;
    //   11: invokevirtual 45	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   14: checkcast 47	java/lang/Long
    //   17: astore_1
    //   18: aload_0
    //   19: getfield 22	com/tencent/mobileqq/transfile/quic/open/QuicDownloaderImpl$1:val$builder	Lcom/tencent/mobileqq/transfile/quic/open/QuicDownloader$Builder;
    //   22: getfield 53	com/tencent/mobileqq/transfile/quic/open/QuicDownloader$Builder:mDownloadListener	Lcom/tencent/mobileqq/transfile/quic/report/DownloadListener;
    //   25: astore_3
    //   26: aload_3
    //   27: ifnull +57 -> 84
    //   30: aload_3
    //   31: invokeinterface 59 1 0
    //   36: ifeq +48 -> 84
    //   39: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   42: ifeq +11 -> 53
    //   45: ldc 66
    //   47: iconst_4
    //   48: ldc 68
    //   50: invokestatic 72	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   53: aload_0
    //   54: getfield 20	com/tencent/mobileqq/transfile/quic/open/QuicDownloaderImpl$1:val$tempPath	Ljava/lang/String;
    //   57: invokestatic 78	com/tencent/mobileqq/transfile/quic/internal/QuicDownloadRunnable:removeRunningTask	(Ljava/lang/String;)V
    //   60: aload_0
    //   61: getfield 18	com/tencent/mobileqq/transfile/quic/open/QuicDownloaderImpl$1:this$0	Lcom/tencent/mobileqq/transfile/quic/open/QuicDownloaderImpl;
    //   64: aload_0
    //   65: getfield 22	com/tencent/mobileqq/transfile/quic/open/QuicDownloaderImpl$1:val$builder	Lcom/tencent/mobileqq/transfile/quic/open/QuicDownloader$Builder;
    //   68: aload_0
    //   69: getfield 24	com/tencent/mobileqq/transfile/quic/open/QuicDownloaderImpl$1:val$savePath	Ljava/lang/String;
    //   72: aload_0
    //   73: getfield 26	com/tencent/mobileqq/transfile/quic/open/QuicDownloaderImpl$1:val$path	Ljava/lang/String;
    //   76: aload_0
    //   77: getfield 20	com/tencent/mobileqq/transfile/quic/open/QuicDownloaderImpl$1:val$tempPath	Ljava/lang/String;
    //   80: invokestatic 82	com/tencent/mobileqq/transfile/quic/open/QuicDownloaderImpl:access$100	(Lcom/tencent/mobileqq/transfile/quic/open/QuicDownloaderImpl;Lcom/tencent/mobileqq/transfile/quic/open/QuicDownloader$Builder;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   83: return
    //   84: new 74	com/tencent/mobileqq/transfile/quic/internal/QuicDownloadRunnable
    //   87: dup
    //   88: invokespecial 83	com/tencent/mobileqq/transfile/quic/internal/QuicDownloadRunnable:<init>	()V
    //   91: astore_2
    //   92: new 85	com/tencent/mobileqq/transfile/quic/internal/QuicDownloadTask
    //   95: dup
    //   96: aload_2
    //   97: aload_0
    //   98: getfield 26	com/tencent/mobileqq/transfile/quic/open/QuicDownloaderImpl$1:val$path	Ljava/lang/String;
    //   101: aload_0
    //   102: getfield 24	com/tencent/mobileqq/transfile/quic/open/QuicDownloaderImpl$1:val$savePath	Ljava/lang/String;
    //   105: aload_0
    //   106: getfield 20	com/tencent/mobileqq/transfile/quic/open/QuicDownloaderImpl$1:val$tempPath	Ljava/lang/String;
    //   109: aload_0
    //   110: getfield 22	com/tencent/mobileqq/transfile/quic/open/QuicDownloaderImpl$1:val$builder	Lcom/tencent/mobileqq/transfile/quic/open/QuicDownloader$Builder;
    //   113: getfield 89	com/tencent/mobileqq/transfile/quic/open/QuicDownloader$Builder:mHeaders	Ljava/util/Map;
    //   116: aload_3
    //   117: invokespecial 92	com/tencent/mobileqq/transfile/quic/internal/QuicDownloadTask:<init>	(Lcom/tencent/mobileqq/transfile/quic/internal/ITaskHandler;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Lcom/tencent/mobileqq/transfile/quic/report/DownloadListener;)V
    //   120: astore_3
    //   121: aload_3
    //   122: invokevirtual 95	com/tencent/mobileqq/transfile/quic/internal/QuicDownloadTask:initDownloadFile	()V
    //   125: aload_1
    //   126: ifnull +18 -> 144
    //   129: aload_3
    //   130: getfield 99	com/tencent/mobileqq/transfile/quic/internal/QuicDownloadTask:report	Lcom/tencent/mobileqq/transfile/quic/report/QuicNetReport;
    //   133: invokestatic 105	java/lang/System:currentTimeMillis	()J
    //   136: aload_1
    //   137: invokevirtual 108	java/lang/Long:longValue	()J
    //   140: lsub
    //   141: putfield 114	com/tencent/mobileqq/transfile/quic/report/QuicNetReport:waitCost	J
    //   144: aload_3
    //   145: getfield 99	com/tencent/mobileqq/transfile/quic/internal/QuicDownloadTask:report	Lcom/tencent/mobileqq/transfile/quic/report/QuicNetReport;
    //   148: aload_0
    //   149: getfield 22	com/tencent/mobileqq/transfile/quic/open/QuicDownloaderImpl$1:val$builder	Lcom/tencent/mobileqq/transfile/quic/open/QuicDownloader$Builder;
    //   152: getfield 117	com/tencent/mobileqq/transfile/quic/open/QuicDownloader$Builder:mIp	Ljava/lang/String;
    //   155: putfield 120	com/tencent/mobileqq/transfile/quic/report/QuicNetReport:ip	Ljava/lang/String;
    //   158: aload_3
    //   159: getfield 99	com/tencent/mobileqq/transfile/quic/internal/QuicDownloadTask:report	Lcom/tencent/mobileqq/transfile/quic/report/QuicNetReport;
    //   162: aload_0
    //   163: getfield 22	com/tencent/mobileqq/transfile/quic/open/QuicDownloaderImpl$1:val$builder	Lcom/tencent/mobileqq/transfile/quic/open/QuicDownloader$Builder;
    //   166: getfield 124	com/tencent/mobileqq/transfile/quic/open/QuicDownloader$Builder:mPort	I
    //   169: putfield 127	com/tencent/mobileqq/transfile/quic/report/QuicNetReport:port	I
    //   172: aload_3
    //   173: getfield 99	com/tencent/mobileqq/transfile/quic/internal/QuicDownloadTask:report	Lcom/tencent/mobileqq/transfile/quic/report/QuicNetReport;
    //   176: aload_0
    //   177: getfield 22	com/tencent/mobileqq/transfile/quic/open/QuicDownloaderImpl$1:val$builder	Lcom/tencent/mobileqq/transfile/quic/open/QuicDownloader$Builder;
    //   180: getfield 131	com/tencent/mobileqq/transfile/quic/open/QuicDownloader$Builder:mIsIpv6	Z
    //   183: putfield 134	com/tencent/mobileqq/transfile/quic/report/QuicNetReport:isIpv6	Z
    //   186: aload_3
    //   187: getfield 99	com/tencent/mobileqq/transfile/quic/internal/QuicDownloadTask:report	Lcom/tencent/mobileqq/transfile/quic/report/QuicNetReport;
    //   190: aload_0
    //   191: getfield 22	com/tencent/mobileqq/transfile/quic/open/QuicDownloaderImpl$1:val$builder	Lcom/tencent/mobileqq/transfile/quic/open/QuicDownloader$Builder;
    //   194: getfield 137	com/tencent/mobileqq/transfile/quic/open/QuicDownloader$Builder:mRttHost	Ljava/lang/String;
    //   197: putfield 140	com/tencent/mobileqq/transfile/quic/report/QuicNetReport:rttHost	Ljava/lang/String;
    //   200: aload_3
    //   201: getfield 99	com/tencent/mobileqq/transfile/quic/internal/QuicDownloadTask:report	Lcom/tencent/mobileqq/transfile/quic/report/QuicNetReport;
    //   204: aload_0
    //   205: getfield 22	com/tencent/mobileqq/transfile/quic/open/QuicDownloaderImpl$1:val$builder	Lcom/tencent/mobileqq/transfile/quic/open/QuicDownloader$Builder;
    //   208: getfield 143	com/tencent/mobileqq/transfile/quic/open/QuicDownloader$Builder:mBussinessId	I
    //   211: putfield 146	com/tencent/mobileqq/transfile/quic/report/QuicNetReport:businessId	I
    //   214: aload_3
    //   215: getfield 99	com/tencent/mobileqq/transfile/quic/internal/QuicDownloadTask:report	Lcom/tencent/mobileqq/transfile/quic/report/QuicNetReport;
    //   218: aload_0
    //   219: getfield 22	com/tencent/mobileqq/transfile/quic/open/QuicDownloaderImpl$1:val$builder	Lcom/tencent/mobileqq/transfile/quic/open/QuicDownloader$Builder;
    //   222: getfield 149	com/tencent/mobileqq/transfile/quic/open/QuicDownloader$Builder:mTimeOut	I
    //   225: putfield 152	com/tencent/mobileqq/transfile/quic/report/QuicNetReport:timeOut	I
    //   228: aload_3
    //   229: aload_0
    //   230: getfield 22	com/tencent/mobileqq/transfile/quic/open/QuicDownloaderImpl$1:val$builder	Lcom/tencent/mobileqq/transfile/quic/open/QuicDownloader$Builder;
    //   233: getfield 149	com/tencent/mobileqq/transfile/quic/open/QuicDownloader$Builder:mTimeOut	I
    //   236: putfield 153	com/tencent/mobileqq/transfile/quic/internal/QuicDownloadTask:timeOut	I
    //   239: ldc 155
    //   241: monitorenter
    //   242: getstatic 159	com/tencent/mobileqq/transfile/quic/open/QuicDownloader:sLastStats	Lcom/tencent/mobileqq/transfile/quic/report/QuicNetReport$Stats;
    //   245: ifnull +53 -> 298
    //   248: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   251: ifeq +33 -> 284
    //   254: ldc 66
    //   256: iconst_2
    //   257: new 161	java/lang/StringBuilder
    //   260: dup
    //   261: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   264: ldc 164
    //   266: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: getstatic 159	com/tencent/mobileqq/transfile/quic/open/QuicDownloader:sLastStats	Lcom/tencent/mobileqq/transfile/quic/report/QuicNetReport$Stats;
    //   272: invokevirtual 174	com/tencent/mobileqq/transfile/quic/report/QuicNetReport$Stats:toString	()Ljava/lang/String;
    //   275: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   281: invokestatic 72	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   284: aload_3
    //   285: getfield 99	com/tencent/mobileqq/transfile/quic/internal/QuicDownloadTask:report	Lcom/tencent/mobileqq/transfile/quic/report/QuicNetReport;
    //   288: getstatic 159	com/tencent/mobileqq/transfile/quic/open/QuicDownloader:sLastStats	Lcom/tencent/mobileqq/transfile/quic/report/QuicNetReport$Stats;
    //   291: putfield 178	com/tencent/mobileqq/transfile/quic/report/QuicNetReport:lastStats	Lcom/tencent/mobileqq/transfile/quic/report/QuicNetReport$Stats;
    //   294: aconst_null
    //   295: putstatic 159	com/tencent/mobileqq/transfile/quic/open/QuicDownloader:sLastStats	Lcom/tencent/mobileqq/transfile/quic/report/QuicNetReport$Stats;
    //   298: ldc 155
    //   300: monitorexit
    //   301: aload_3
    //   302: aload_0
    //   303: getfield 22	com/tencent/mobileqq/transfile/quic/open/QuicDownloaderImpl$1:val$builder	Lcom/tencent/mobileqq/transfile/quic/open/QuicDownloader$Builder;
    //   306: getfield 181	com/tencent/mobileqq/transfile/quic/open/QuicDownloader$Builder:mIsQuicEncryption	Z
    //   309: putfield 184	com/tencent/mobileqq/transfile/quic/internal/QuicDownloadTask:encryption	Z
    //   312: aload_3
    //   313: aload_0
    //   314: getfield 22	com/tencent/mobileqq/transfile/quic/open/QuicDownloaderImpl$1:val$builder	Lcom/tencent/mobileqq/transfile/quic/open/QuicDownloader$Builder;
    //   317: getfield 187	com/tencent/mobileqq/transfile/quic/open/QuicDownloader$Builder:mFec	I
    //   320: putfield 190	com/tencent/mobileqq/transfile/quic/internal/QuicDownloadTask:fec	I
    //   323: aload_2
    //   324: aload_3
    //   325: invokevirtual 194	com/tencent/mobileqq/transfile/quic/internal/QuicDownloadRunnable:enqueue	(Lcom/tencent/mobileqq/transfile/quic/internal/QuicDownloadTask;)V
    //   328: return
    //   329: astore_1
    //   330: aload_0
    //   331: getfield 20	com/tencent/mobileqq/transfile/quic/open/QuicDownloaderImpl$1:val$tempPath	Ljava/lang/String;
    //   334: invokestatic 78	com/tencent/mobileqq/transfile/quic/internal/QuicDownloadRunnable:removeRunningTask	(Ljava/lang/String;)V
    //   337: aload_0
    //   338: getfield 18	com/tencent/mobileqq/transfile/quic/open/QuicDownloaderImpl$1:this$0	Lcom/tencent/mobileqq/transfile/quic/open/QuicDownloaderImpl;
    //   341: aload_0
    //   342: getfield 22	com/tencent/mobileqq/transfile/quic/open/QuicDownloaderImpl$1:val$builder	Lcom/tencent/mobileqq/transfile/quic/open/QuicDownloader$Builder;
    //   345: aload_0
    //   346: getfield 24	com/tencent/mobileqq/transfile/quic/open/QuicDownloaderImpl$1:val$savePath	Ljava/lang/String;
    //   349: aload_0
    //   350: getfield 26	com/tencent/mobileqq/transfile/quic/open/QuicDownloaderImpl$1:val$path	Ljava/lang/String;
    //   353: aload_0
    //   354: getfield 20	com/tencent/mobileqq/transfile/quic/open/QuicDownloaderImpl$1:val$tempPath	Ljava/lang/String;
    //   357: iconst_2
    //   358: aload_1
    //   359: invokevirtual 197	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   362: invokestatic 201	com/tencent/mobileqq/transfile/quic/open/QuicDownloaderImpl:access$200	(Lcom/tencent/mobileqq/transfile/quic/open/QuicDownloaderImpl;Lcom/tencent/mobileqq/transfile/quic/open/QuicDownloader$Builder;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V
    //   365: return
    //   366: astore_1
    //   367: ldc 155
    //   369: monitorexit
    //   370: aload_1
    //   371: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	372	0	this	1
    //   17	120	1	localLong	java.lang.Long
    //   329	30	1	localException	java.lang.Exception
    //   366	5	1	localObject1	Object
    //   91	233	2	localQuicDownloadRunnable	com.tencent.mobileqq.transfile.quic.internal.QuicDownloadRunnable
    //   25	300	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   92	125	329	java/lang/Exception
    //   242	284	366	finally
    //   284	298	366	finally
    //   298	301	366	finally
    //   367	370	366	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.quic.open.QuicDownloaderImpl.1
 * JD-Core Version:    0.7.0.1
 */