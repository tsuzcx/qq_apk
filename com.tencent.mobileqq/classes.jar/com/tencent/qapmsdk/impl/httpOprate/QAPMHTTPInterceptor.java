package com.tencent.qapmsdk.impl.httpOprate;

import android.text.TextUtils;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.impl.instrumentation.QAPMTransactionState;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Request.Builder;

public class QAPMHTTPInterceptor
  implements Interceptor
{
  private static final String TAG = "QAM_Impl_QAPMHTTPInterceptor";
  private final AtomicInteger atomicInteger = new AtomicInteger(0);
  private final IDataCollect dataCollect = new HttpDataCollect();
  
  public QAPMHTTPInterceptor()
  {
    Logger.INSTANCE.d(new String[] { "QAM_Impl_QAPMHTTPInterceptor", "OkHttpInstrumentation3 - wrapping Instructor" });
  }
  
  /* Error */
  private int getQueueTime(Request paramRequest, long paramLong)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 51
    //   3: invokevirtual 57	okhttp3/Request:header	(Ljava/lang/String;)Ljava/lang/String;
    //   6: invokestatic 63	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   9: lstore 5
    //   11: lload_2
    //   12: lload 5
    //   14: lsub
    //   15: l2i
    //   16: istore 4
    //   18: aload_1
    //   19: invokevirtual 67	okhttp3/Request:newBuilder	()Lokhttp3/Request$Builder;
    //   22: ldc 51
    //   24: invokevirtual 73	okhttp3/Request$Builder:removeHeader	(Ljava/lang/String;)Lokhttp3/Request$Builder;
    //   27: pop
    //   28: iload 4
    //   30: ireturn
    //   31: astore_1
    //   32: iconst_0
    //   33: istore 4
    //   35: getstatic 36	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   38: iconst_3
    //   39: anewarray 38	java/lang/String
    //   42: dup
    //   43: iconst_0
    //   44: ldc 10
    //   46: aastore
    //   47: dup
    //   48: iconst_1
    //   49: ldc 75
    //   51: aastore
    //   52: dup
    //   53: iconst_2
    //   54: aload_1
    //   55: invokevirtual 79	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   58: aastore
    //   59: invokevirtual 82	com/tencent/qapmsdk/common/logger/Logger:e	([Ljava/lang/String;)V
    //   62: iload 4
    //   64: ireturn
    //   65: astore_1
    //   66: goto -31 -> 35
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	69	0	this	QAPMHTTPInterceptor
    //   0	69	1	paramRequest	Request
    //   0	69	2	paramLong	long
    //   16	47	4	i	int
    //   9	4	5	l	long
    // Exception table:
    //   from	to	target	type
    //   0	11	31	java/lang/Exception
    //   18	28	65	java/lang/Exception
  }
  
  private Request getQueueTime(Request paramRequest, QAPMTransactionState paramQAPMTransactionState)
  {
    try
    {
      Request.Builder localBuilder = paramRequest.newBuilder();
      QAPMTransactionState localQAPMTransactionState = paramQAPMTransactionState;
      if (paramQAPMTransactionState == null) {
        localQAPMTransactionState = new QAPMTransactionState();
      }
      localQAPMTransactionState.setQueueTime(getQueueTime(paramRequest, localQAPMTransactionState.getStartTime()));
      paramQAPMTransactionState = localBuilder.build();
      return paramQAPMTransactionState;
    }
    catch (Exception paramQAPMTransactionState)
    {
      Logger.INSTANCE.e(new String[] { "QAM_Impl_QAPMHTTPInterceptor", "QAPMOkHttp3Interceptor_  setCrossProcessHeader---> has an error : ", paramQAPMTransactionState.toString() });
    }
    return paramRequest;
  }
  
  private Request restoreHead(Request paramRequest)
  {
    Request localRequest = paramRequest;
    try
    {
      if (!TextUtils.isEmpty(paramRequest.header("X-QAPM-Qt"))) {
        localRequest = paramRequest.newBuilder().removeHeader("X-QAPM-Qt").build();
      }
      return localRequest;
    }
    catch (Exception localException)
    {
      Logger.INSTANCE.e(new String[] { "QAM_Impl_QAPMHTTPInterceptor", "dropQtHeader error:", localException.getMessage() });
    }
    return paramRequest;
  }
  
  /* Error */
  public okhttp3.Response intercept(okhttp3.Interceptor.Chain paramChain)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokeinterface 123 1 0
    //   6: astore 5
    //   8: aload 5
    //   10: ifnull +301 -> 311
    //   13: invokestatic 129	com/tencent/qapmsdk/impl/util/TraceUtil:getCanMonitorHttp	()Z
    //   16: ifeq +295 -> 311
    //   19: new 85	com/tencent/qapmsdk/impl/instrumentation/QAPMTransactionState
    //   22: dup
    //   23: invokespecial 86	com/tencent/qapmsdk/impl/instrumentation/QAPMTransactionState:<init>	()V
    //   26: astore 6
    //   28: aload 5
    //   30: astore 4
    //   32: aload 6
    //   34: iconst_0
    //   35: invokevirtual 132	com/tencent/qapmsdk/impl/instrumentation/QAPMTransactionState:setAppPhase	(I)V
    //   38: aload 5
    //   40: astore 4
    //   42: aload 6
    //   44: getstatic 138	com/tencent/qapmsdk/impl/harvest/HttpLibType:OkHttp	Lcom/tencent/qapmsdk/impl/harvest/HttpLibType;
    //   47: invokevirtual 142	com/tencent/qapmsdk/impl/instrumentation/QAPMTransactionState:setHttpLibType	(Lcom/tencent/qapmsdk/impl/harvest/HttpLibType;)V
    //   50: aload 5
    //   52: astore 4
    //   54: aload_0
    //   55: getfield 23	com/tencent/qapmsdk/impl/httpOprate/QAPMHTTPInterceptor:dataCollect	Lcom/tencent/qapmsdk/impl/httpOprate/IDataCollect;
    //   58: invokeinterface 147 1 0
    //   63: istore_2
    //   64: iload_2
    //   65: ifne +11 -> 76
    //   68: aload 5
    //   70: astore_3
    //   71: aload 5
    //   73: ifnull +45 -> 118
    //   76: aload 5
    //   78: astore_3
    //   79: aload_0
    //   80: aload 5
    //   82: aload 6
    //   84: invokespecial 149	com/tencent/qapmsdk/impl/httpOprate/QAPMHTTPInterceptor:getQueueTime	(Lokhttp3/Request;Lcom/tencent/qapmsdk/impl/instrumentation/QAPMTransactionState;)Lokhttp3/Request;
    //   87: astore 4
    //   89: aload_0
    //   90: aload 4
    //   92: invokespecial 151	com/tencent/qapmsdk/impl/httpOprate/QAPMHTTPInterceptor:restoreHead	(Lokhttp3/Request;)Lokhttp3/Request;
    //   95: astore_3
    //   96: aload_3
    //   97: astore 4
    //   99: aload 4
    //   101: astore_3
    //   102: aload_0
    //   103: getfield 23	com/tencent/qapmsdk/impl/httpOprate/QAPMHTTPInterceptor:dataCollect	Lcom/tencent/qapmsdk/impl/httpOprate/IDataCollect;
    //   106: aload 4
    //   108: aload 6
    //   110: invokeinterface 155 3 0
    //   115: aload 4
    //   117: astore_3
    //   118: aload_1
    //   119: aload_3
    //   120: invokeinterface 159 2 0
    //   125: astore_1
    //   126: aload 6
    //   128: aload_1
    //   129: ldc 161
    //   131: invokevirtual 164	okhttp3/Response:header	(Ljava/lang/String;)Ljava/lang/String;
    //   134: invokestatic 169	com/tencent/qapmsdk/impl/util/StringUtil:contentType	(Ljava/lang/String;)Ljava/lang/String;
    //   137: invokevirtual 173	com/tencent/qapmsdk/impl/instrumentation/QAPMTransactionState:setContentType	(Ljava/lang/String;)V
    //   140: aload_0
    //   141: getfield 23	com/tencent/qapmsdk/impl/httpOprate/QAPMHTTPInterceptor:dataCollect	Lcom/tencent/qapmsdk/impl/httpOprate/IDataCollect;
    //   144: invokeinterface 147 1 0
    //   149: ifne +7 -> 156
    //   152: aload_1
    //   153: ifnull +15 -> 168
    //   156: aload_0
    //   157: getfield 23	com/tencent/qapmsdk/impl/httpOprate/QAPMHTTPInterceptor:dataCollect	Lcom/tencent/qapmsdk/impl/httpOprate/IDataCollect;
    //   160: aload_1
    //   161: aload 6
    //   163: invokeinterface 177 3 0
    //   168: aload_1
    //   169: areturn
    //   170: astore 5
    //   172: aload_3
    //   173: astore 4
    //   175: getstatic 36	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   178: ldc 10
    //   180: ldc 179
    //   182: aload 5
    //   184: invokevirtual 183	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   187: goto -69 -> 118
    //   190: astore_3
    //   191: getstatic 36	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   194: ldc 10
    //   196: ldc 185
    //   198: aload_3
    //   199: invokevirtual 183	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   202: aload 4
    //   204: astore_3
    //   205: goto -87 -> 118
    //   208: astore_3
    //   209: getstatic 36	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   212: ldc 10
    //   214: ldc 187
    //   216: aload_3
    //   217: invokevirtual 183	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   220: goto -80 -> 140
    //   223: astore_1
    //   224: aload_0
    //   225: getfield 23	com/tencent/qapmsdk/impl/httpOprate/QAPMHTTPInterceptor:dataCollect	Lcom/tencent/qapmsdk/impl/httpOprate/IDataCollect;
    //   228: invokeinterface 147 1 0
    //   233: ifeq +15 -> 248
    //   236: aload_0
    //   237: getfield 23	com/tencent/qapmsdk/impl/httpOprate/QAPMHTTPInterceptor:dataCollect	Lcom/tencent/qapmsdk/impl/httpOprate/IDataCollect;
    //   240: aload 6
    //   242: aload_1
    //   243: invokeinterface 191 3 0
    //   248: aload_1
    //   249: athrow
    //   250: astore_3
    //   251: getstatic 36	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   254: iconst_3
    //   255: anewarray 38	java/lang/String
    //   258: dup
    //   259: iconst_0
    //   260: ldc 10
    //   262: aastore
    //   263: dup
    //   264: iconst_1
    //   265: ldc 193
    //   267: aastore
    //   268: dup
    //   269: iconst_2
    //   270: aload_3
    //   271: invokevirtual 104	java/lang/Exception:toString	()Ljava/lang/String;
    //   274: aastore
    //   275: invokevirtual 82	com/tencent/qapmsdk/common/logger/Logger:e	([Ljava/lang/String;)V
    //   278: goto -30 -> 248
    //   281: astore_3
    //   282: getstatic 36	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   285: iconst_3
    //   286: anewarray 38	java/lang/String
    //   289: dup
    //   290: iconst_0
    //   291: ldc 10
    //   293: aastore
    //   294: dup
    //   295: iconst_1
    //   296: ldc 195
    //   298: aastore
    //   299: dup
    //   300: iconst_2
    //   301: aload_3
    //   302: invokevirtual 104	java/lang/Exception:toString	()Ljava/lang/String;
    //   305: aastore
    //   306: invokevirtual 82	com/tencent/qapmsdk/common/logger/Logger:e	([Ljava/lang/String;)V
    //   309: aload_1
    //   310: areturn
    //   311: aload 5
    //   313: ifnonnull +13 -> 326
    //   316: new 118	java/io/IOException
    //   319: dup
    //   320: ldc 197
    //   322: invokespecial 199	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   325: athrow
    //   326: aload_1
    //   327: aload 5
    //   329: invokeinterface 159 2 0
    //   334: areturn
    //   335: astore 5
    //   337: aload 4
    //   339: astore_3
    //   340: goto -168 -> 172
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	343	0	this	QAPMHTTPInterceptor
    //   0	343	1	paramChain	okhttp3.Interceptor.Chain
    //   63	2	2	bool	boolean
    //   70	103	3	localObject1	Object
    //   190	9	3	localException1	Exception
    //   204	1	3	localObject2	Object
    //   208	9	3	localException2	Exception
    //   250	21	3	localException3	Exception
    //   281	21	3	localException4	Exception
    //   339	1	3	localObject3	Object
    //   30	308	4	localObject4	Object
    //   6	75	5	localRequest	Request
    //   170	158	5	localException5	Exception
    //   335	1	5	localException6	Exception
    //   26	215	6	localQAPMTransactionState	QAPMTransactionState
    // Exception table:
    //   from	to	target	type
    //   79	89	170	java/lang/Exception
    //   102	115	170	java/lang/Exception
    //   32	38	190	java/lang/Exception
    //   42	50	190	java/lang/Exception
    //   54	64	190	java/lang/Exception
    //   175	187	190	java/lang/Exception
    //   126	140	208	java/lang/Exception
    //   118	126	223	java/io/IOException
    //   126	140	223	java/io/IOException
    //   209	220	223	java/io/IOException
    //   236	248	250	java/lang/Exception
    //   156	168	281	java/lang/Exception
    //   89	96	335	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.httpOprate.QAPMHTTPInterceptor
 * JD-Core Version:    0.7.0.1
 */