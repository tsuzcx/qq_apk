package okhttp3;

import java.io.InterruptedIOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import okhttp3.internal.NamedRunnable;

final class RealCall$AsyncCall
  extends NamedRunnable
{
  private final Callback responseCallback;
  
  static
  {
    if (!RealCall.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  RealCall$AsyncCall(RealCall paramRealCall, Callback paramCallback)
  {
    super("OkHttp %s", new Object[] { paramRealCall.redactedUrl() });
    this.responseCallback = paramCallback;
  }
  
  /* Error */
  public void execute()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: iconst_0
    //   3: istore_1
    //   4: aload_0
    //   5: getfield 27	okhttp3/RealCall$AsyncCall:this$0	Lokhttp3/RealCall;
    //   8: getfield 49	okhttp3/RealCall:timeout	Lokio/AsyncTimeout;
    //   11: invokevirtual 54	okio/AsyncTimeout:enter	()V
    //   14: aload_0
    //   15: getfield 27	okhttp3/RealCall$AsyncCall:this$0	Lokhttp3/RealCall;
    //   18: invokevirtual 58	okhttp3/RealCall:getResponseWithInterceptorChain	()Lokhttp3/Response;
    //   21: astore_3
    //   22: iconst_1
    //   23: istore_2
    //   24: iconst_1
    //   25: istore_1
    //   26: aload_0
    //   27: getfield 40	okhttp3/RealCall$AsyncCall:responseCallback	Lokhttp3/Callback;
    //   30: aload_0
    //   31: getfield 27	okhttp3/RealCall$AsyncCall:this$0	Lokhttp3/RealCall;
    //   34: aload_3
    //   35: invokeinterface 64 3 0
    //   40: aload_0
    //   41: getfield 27	okhttp3/RealCall$AsyncCall:this$0	Lokhttp3/RealCall;
    //   44: getfield 68	okhttp3/RealCall:client	Lokhttp3/OkHttpClient;
    //   47: invokevirtual 74	okhttp3/OkHttpClient:dispatcher	()Lokhttp3/Dispatcher;
    //   50: aload_0
    //   51: invokevirtual 80	okhttp3/Dispatcher:finished	(Lokhttp3/RealCall$AsyncCall;)V
    //   54: return
    //   55: astore_3
    //   56: aload_0
    //   57: getfield 27	okhttp3/RealCall$AsyncCall:this$0	Lokhttp3/RealCall;
    //   60: aload_3
    //   61: invokevirtual 84	okhttp3/RealCall:timeoutExit	(Ljava/io/IOException;)Ljava/io/IOException;
    //   64: astore_3
    //   65: iload_1
    //   66: ifeq +51 -> 117
    //   69: invokestatic 90	okhttp3/internal/platform/Platform:get	()Lokhttp3/internal/platform/Platform;
    //   72: iconst_4
    //   73: new 92	java/lang/StringBuilder
    //   76: dup
    //   77: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   80: ldc 96
    //   82: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: aload_0
    //   86: getfield 27	okhttp3/RealCall$AsyncCall:this$0	Lokhttp3/RealCall;
    //   89: invokevirtual 103	okhttp3/RealCall:toLoggableString	()Ljava/lang/String;
    //   92: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: aload_3
    //   99: invokevirtual 110	okhttp3/internal/platform/Platform:log	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   102: aload_0
    //   103: getfield 27	okhttp3/RealCall$AsyncCall:this$0	Lokhttp3/RealCall;
    //   106: getfield 68	okhttp3/RealCall:client	Lokhttp3/OkHttpClient;
    //   109: invokevirtual 74	okhttp3/OkHttpClient:dispatcher	()Lokhttp3/Dispatcher;
    //   112: aload_0
    //   113: invokevirtual 80	okhttp3/Dispatcher:finished	(Lokhttp3/RealCall$AsyncCall;)V
    //   116: return
    //   117: aload_0
    //   118: getfield 27	okhttp3/RealCall$AsyncCall:this$0	Lokhttp3/RealCall;
    //   121: invokestatic 114	okhttp3/RealCall:access$000	(Lokhttp3/RealCall;)Lokhttp3/EventListener;
    //   124: aload_0
    //   125: getfield 27	okhttp3/RealCall$AsyncCall:this$0	Lokhttp3/RealCall;
    //   128: aload_3
    //   129: invokevirtual 120	okhttp3/EventListener:callFailed	(Lokhttp3/Call;Ljava/io/IOException;)V
    //   132: aload_0
    //   133: getfield 40	okhttp3/RealCall$AsyncCall:responseCallback	Lokhttp3/Callback;
    //   136: aload_0
    //   137: getfield 27	okhttp3/RealCall$AsyncCall:this$0	Lokhttp3/RealCall;
    //   140: aload_3
    //   141: invokeinterface 123 3 0
    //   146: goto -44 -> 102
    //   149: astore_3
    //   150: aload_0
    //   151: getfield 27	okhttp3/RealCall$AsyncCall:this$0	Lokhttp3/RealCall;
    //   154: getfield 68	okhttp3/RealCall:client	Lokhttp3/OkHttpClient;
    //   157: invokevirtual 74	okhttp3/OkHttpClient:dispatcher	()Lokhttp3/Dispatcher;
    //   160: aload_0
    //   161: invokevirtual 80	okhttp3/Dispatcher:finished	(Lokhttp3/RealCall$AsyncCall;)V
    //   164: aload_3
    //   165: athrow
    //   166: astore_3
    //   167: aload_0
    //   168: getfield 27	okhttp3/RealCall$AsyncCall:this$0	Lokhttp3/RealCall;
    //   171: invokevirtual 126	okhttp3/RealCall:cancel	()V
    //   174: iload_2
    //   175: ifne +46 -> 221
    //   178: new 43	java/io/IOException
    //   181: dup
    //   182: new 92	java/lang/StringBuilder
    //   185: dup
    //   186: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   189: ldc 128
    //   191: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: aload_3
    //   195: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   198: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   201: invokespecial 134	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   204: astore 4
    //   206: aload_0
    //   207: getfield 40	okhttp3/RealCall$AsyncCall:responseCallback	Lokhttp3/Callback;
    //   210: aload_0
    //   211: getfield 27	okhttp3/RealCall$AsyncCall:this$0	Lokhttp3/RealCall;
    //   214: aload 4
    //   216: invokeinterface 123 3 0
    //   221: aload_3
    //   222: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	223	0	this	AsyncCall
    //   3	63	1	i	int
    //   1	174	2	j	int
    //   21	14	3	localResponse	Response
    //   55	6	3	localIOException1	java.io.IOException
    //   64	77	3	localIOException2	java.io.IOException
    //   149	16	3	localObject	Object
    //   166	56	3	localThrowable	java.lang.Throwable
    //   204	11	4	localIOException3	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   14	22	55	java/io/IOException
    //   26	40	55	java/io/IOException
    //   14	22	149	finally
    //   26	40	149	finally
    //   56	65	149	finally
    //   69	102	149	finally
    //   117	146	149	finally
    //   167	174	149	finally
    //   178	221	149	finally
    //   221	223	149	finally
    //   14	22	166	java/lang/Throwable
    //   26	40	166	java/lang/Throwable
  }
  
  void executeOn(ExecutorService paramExecutorService)
  {
    assert (!Thread.holdsLock(this.this$0.client.dispatcher()));
    try
    {
      paramExecutorService.execute(this);
      return;
    }
    catch (RejectedExecutionException paramExecutorService)
    {
      InterruptedIOException localInterruptedIOException = new InterruptedIOException("executor rejected");
      localInterruptedIOException.initCause(paramExecutorService);
      RealCall.access$000(this.this$0).callFailed(this.this$0, localInterruptedIOException);
      this.responseCallback.onFailure(this.this$0, localInterruptedIOException);
      return;
    }
    finally
    {
      this.this$0.client.dispatcher().finished(this);
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     okhttp3.RealCall.AsyncCall
 * JD-Core Version:    0.7.0.1
 */