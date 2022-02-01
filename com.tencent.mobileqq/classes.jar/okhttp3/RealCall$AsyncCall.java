package okhttp3;

import okhttp3.internal.NamedRunnable;

final class RealCall$AsyncCall
  extends NamedRunnable
{
  private final Callback responseCallback;
  
  RealCall$AsyncCall(RealCall paramRealCall, Callback paramCallback)
  {
    super("OkHttp %s", new Object[] { paramRealCall.redactedUrl() });
    this.responseCallback = paramCallback;
  }
  
  /* Error */
  protected void execute()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 18	okhttp3/RealCall$AsyncCall:this$0	Lokhttp3/RealCall;
    //   4: getfield 42	okhttp3/RealCall:timeout	Lokio/AsyncTimeout;
    //   7: invokevirtual 47	okio/AsyncTimeout:enter	()V
    //   10: aload_0
    //   11: getfield 18	okhttp3/RealCall$AsyncCall:this$0	Lokhttp3/RealCall;
    //   14: invokevirtual 51	okhttp3/RealCall:getResponseWithInterceptorChain	()Lokhttp3/Response;
    //   17: astore_3
    //   18: iconst_1
    //   19: istore_2
    //   20: iconst_1
    //   21: istore_1
    //   22: aload_0
    //   23: getfield 33	okhttp3/RealCall$AsyncCall:responseCallback	Lokhttp3/Callback;
    //   26: aload_0
    //   27: getfield 18	okhttp3/RealCall$AsyncCall:this$0	Lokhttp3/RealCall;
    //   30: aload_3
    //   31: invokeinterface 57 3 0
    //   36: aload_0
    //   37: getfield 18	okhttp3/RealCall$AsyncCall:this$0	Lokhttp3/RealCall;
    //   40: getfield 61	okhttp3/RealCall:client	Lokhttp3/OkHttpClient;
    //   43: invokevirtual 67	okhttp3/OkHttpClient:dispatcher	()Lokhttp3/Dispatcher;
    //   46: aload_0
    //   47: invokevirtual 73	okhttp3/Dispatcher:finished	(Lokhttp3/RealCall$AsyncCall;)V
    //   50: return
    //   51: astore_3
    //   52: goto +16 -> 68
    //   55: astore_3
    //   56: iload_2
    //   57: istore_1
    //   58: goto +76 -> 134
    //   61: astore_3
    //   62: goto +167 -> 229
    //   65: astore_3
    //   66: iconst_0
    //   67: istore_1
    //   68: aload_0
    //   69: getfield 18	okhttp3/RealCall$AsyncCall:this$0	Lokhttp3/RealCall;
    //   72: invokevirtual 76	okhttp3/RealCall:cancel	()V
    //   75: iload_1
    //   76: ifne +56 -> 132
    //   79: new 78	java/lang/StringBuilder
    //   82: dup
    //   83: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   86: astore 4
    //   88: aload 4
    //   90: ldc 82
    //   92: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: pop
    //   96: aload 4
    //   98: aload_3
    //   99: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   102: pop
    //   103: new 36	java/io/IOException
    //   106: dup
    //   107: aload 4
    //   109: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: invokespecial 95	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   115: astore 4
    //   117: aload_0
    //   118: getfield 33	okhttp3/RealCall$AsyncCall:responseCallback	Lokhttp3/Callback;
    //   121: aload_0
    //   122: getfield 18	okhttp3/RealCall$AsyncCall:this$0	Lokhttp3/RealCall;
    //   125: aload 4
    //   127: invokeinterface 99 3 0
    //   132: aload_3
    //   133: athrow
    //   134: aload_0
    //   135: getfield 18	okhttp3/RealCall$AsyncCall:this$0	Lokhttp3/RealCall;
    //   138: aload_3
    //   139: invokevirtual 103	okhttp3/RealCall:timeoutExit	(Ljava/io/IOException;)Ljava/io/IOException;
    //   142: astore_3
    //   143: iload_1
    //   144: ifeq +53 -> 197
    //   147: invokestatic 109	okhttp3/internal/platform/Platform:get	()Lokhttp3/internal/platform/Platform;
    //   150: astore 4
    //   152: new 78	java/lang/StringBuilder
    //   155: dup
    //   156: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   159: astore 5
    //   161: aload 5
    //   163: ldc 111
    //   165: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: pop
    //   169: aload 5
    //   171: aload_0
    //   172: getfield 18	okhttp3/RealCall$AsyncCall:this$0	Lokhttp3/RealCall;
    //   175: invokevirtual 114	okhttp3/RealCall:toLoggableString	()Ljava/lang/String;
    //   178: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: pop
    //   182: aload 4
    //   184: iconst_4
    //   185: aload 5
    //   187: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   190: aload_3
    //   191: invokevirtual 118	okhttp3/internal/platform/Platform:log	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   194: goto -158 -> 36
    //   197: aload_0
    //   198: getfield 18	okhttp3/RealCall$AsyncCall:this$0	Lokhttp3/RealCall;
    //   201: invokestatic 122	okhttp3/RealCall:access$000	(Lokhttp3/RealCall;)Lokhttp3/EventListener;
    //   204: aload_0
    //   205: getfield 18	okhttp3/RealCall$AsyncCall:this$0	Lokhttp3/RealCall;
    //   208: aload_3
    //   209: invokevirtual 127	okhttp3/EventListener:callFailed	(Lokhttp3/Call;Ljava/io/IOException;)V
    //   212: aload_0
    //   213: getfield 33	okhttp3/RealCall$AsyncCall:responseCallback	Lokhttp3/Callback;
    //   216: aload_0
    //   217: getfield 18	okhttp3/RealCall$AsyncCall:this$0	Lokhttp3/RealCall;
    //   220: aload_3
    //   221: invokeinterface 99 3 0
    //   226: goto -190 -> 36
    //   229: aload_0
    //   230: getfield 18	okhttp3/RealCall$AsyncCall:this$0	Lokhttp3/RealCall;
    //   233: getfield 61	okhttp3/RealCall:client	Lokhttp3/OkHttpClient;
    //   236: invokevirtual 67	okhttp3/OkHttpClient:dispatcher	()Lokhttp3/Dispatcher;
    //   239: aload_0
    //   240: invokevirtual 73	okhttp3/Dispatcher:finished	(Lokhttp3/RealCall$AsyncCall;)V
    //   243: goto +5 -> 248
    //   246: aload_3
    //   247: athrow
    //   248: goto -2 -> 246
    //   251: astore_3
    //   252: iconst_0
    //   253: istore_1
    //   254: goto -120 -> 134
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	257	0	this	AsyncCall
    //   21	233	1	i	int
    //   19	38	2	j	int
    //   17	14	3	localResponse	Response
    //   51	1	3	localThrowable1	java.lang.Throwable
    //   55	1	3	localIOException1	java.io.IOException
    //   61	1	3	localObject1	Object
    //   65	74	3	localThrowable2	java.lang.Throwable
    //   142	105	3	localIOException2	java.io.IOException
    //   251	1	3	localIOException3	java.io.IOException
    //   86	97	4	localObject2	Object
    //   159	27	5	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   22	36	51	java/lang/Throwable
    //   22	36	55	java/io/IOException
    //   10	18	61	finally
    //   22	36	61	finally
    //   68	75	61	finally
    //   79	132	61	finally
    //   132	134	61	finally
    //   134	143	61	finally
    //   147	194	61	finally
    //   197	226	61	finally
    //   10	18	65	java/lang/Throwable
    //   10	18	251	java/io/IOException
  }
  
  /* Error */
  void executeOn(java.util.concurrent.ExecutorService paramExecutorService)
  {
    // Byte code:
    //   0: aload_1
    //   1: aload_0
    //   2: invokeinterface 136 2 0
    //   7: return
    //   8: astore_1
    //   9: goto +64 -> 73
    //   12: astore_1
    //   13: new 138	java/io/InterruptedIOException
    //   16: dup
    //   17: ldc 140
    //   19: invokespecial 141	java/io/InterruptedIOException:<init>	(Ljava/lang/String;)V
    //   22: astore_2
    //   23: aload_2
    //   24: aload_1
    //   25: invokevirtual 145	java/io/InterruptedIOException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   28: pop
    //   29: aload_0
    //   30: getfield 18	okhttp3/RealCall$AsyncCall:this$0	Lokhttp3/RealCall;
    //   33: invokestatic 122	okhttp3/RealCall:access$000	(Lokhttp3/RealCall;)Lokhttp3/EventListener;
    //   36: aload_0
    //   37: getfield 18	okhttp3/RealCall$AsyncCall:this$0	Lokhttp3/RealCall;
    //   40: aload_2
    //   41: invokevirtual 127	okhttp3/EventListener:callFailed	(Lokhttp3/Call;Ljava/io/IOException;)V
    //   44: aload_0
    //   45: getfield 33	okhttp3/RealCall$AsyncCall:responseCallback	Lokhttp3/Callback;
    //   48: aload_0
    //   49: getfield 18	okhttp3/RealCall$AsyncCall:this$0	Lokhttp3/RealCall;
    //   52: aload_2
    //   53: invokeinterface 99 3 0
    //   58: aload_0
    //   59: getfield 18	okhttp3/RealCall$AsyncCall:this$0	Lokhttp3/RealCall;
    //   62: getfield 61	okhttp3/RealCall:client	Lokhttp3/OkHttpClient;
    //   65: invokevirtual 67	okhttp3/OkHttpClient:dispatcher	()Lokhttp3/Dispatcher;
    //   68: aload_0
    //   69: invokevirtual 73	okhttp3/Dispatcher:finished	(Lokhttp3/RealCall$AsyncCall;)V
    //   72: return
    //   73: aload_0
    //   74: getfield 18	okhttp3/RealCall$AsyncCall:this$0	Lokhttp3/RealCall;
    //   77: getfield 61	okhttp3/RealCall:client	Lokhttp3/OkHttpClient;
    //   80: invokevirtual 67	okhttp3/OkHttpClient:dispatcher	()Lokhttp3/Dispatcher;
    //   83: aload_0
    //   84: invokevirtual 73	okhttp3/Dispatcher:finished	(Lokhttp3/RealCall$AsyncCall;)V
    //   87: aload_1
    //   88: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	this	AsyncCall
    //   0	89	1	paramExecutorService	java.util.concurrent.ExecutorService
    //   22	31	2	localInterruptedIOException	java.io.InterruptedIOException
    // Exception table:
    //   from	to	target	type
    //   0	7	8	finally
    //   13	58	8	finally
    //   0	7	12	java/util/concurrent/RejectedExecutionException
  }
  
  RealCall get()
  {
    return this.this$0;
  }
  
  String host()
  {
    return this.this$0.originalRequest.url().host();
  }
  
  Request request()
  {
    return this.this$0.originalRequest;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okhttp3.RealCall.AsyncCall
 * JD-Core Version:    0.7.0.1
 */