package com.tencent.qapmsdk.impl.instrumentation;

import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.impl.g.b;
import com.tencent.qapmsdk.impl.instrumentation.a.e;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;

public class QAPMInstrumentationHttpClient
{
  private static final String TAG = "QAPM_Impl_QAPMInstrumentationHttpClient";
  
  private static HttpRequest dispatchHttpClientRequest(HttpRequest paramHttpRequest, h paramh)
  {
    return paramHttpRequest;
  }
  
  private static HttpRequest doExec(HttpHost paramHttpHost, HttpRequest paramHttpRequest, h paramh)
  {
    return c.a(paramh, paramHttpHost, paramHttpRequest);
  }
  
  private static HttpResponse doExec(HttpResponse paramHttpResponse, h paramh)
  {
    return c.a(paramh, paramHttpResponse);
  }
  
  private static <T> ResponseHandler<? extends T> doExec(ResponseHandler<? extends T> paramResponseHandler, h paramh)
  {
    return e.a(paramResponseHandler, paramh);
  }
  
  private static HttpUriRequest doExec(HttpUriRequest paramHttpUriRequest, h paramh)
  {
    return c.a(paramh, paramHttpUriRequest);
  }
  
  /* Error */
  @QAPMReplaceCallSite
  public static <T> T execute(org.apache.http.client.HttpClient paramHttpClient, HttpHost paramHttpHost, HttpRequest paramHttpRequest, ResponseHandler<? extends T> paramResponseHandler)
  {
    // Byte code:
    //   0: invokestatic 53	com/tencent/qapmsdk/impl/g/b:c	()Z
    //   3: ifne +13 -> 16
    //   6: aload_0
    //   7: aload_1
    //   8: aload_2
    //   9: aload_3
    //   10: invokeinterface 58 4 0
    //   15: areturn
    //   16: getstatic 64	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   19: iconst_2
    //   20: anewarray 66	java/lang/String
    //   23: dup
    //   24: iconst_0
    //   25: ldc 8
    //   27: aastore
    //   28: dup
    //   29: iconst_1
    //   30: ldc 68
    //   32: aastore
    //   33: invokevirtual 72	com/tencent/qapmsdk/common/logger/Logger:d	([Ljava/lang/String;)V
    //   36: new 74	com/tencent/qapmsdk/impl/instrumentation/h
    //   39: dup
    //   40: invokespecial 75	com/tencent/qapmsdk/impl/instrumentation/h:<init>	()V
    //   43: astore 5
    //   45: aload 5
    //   47: iconst_0
    //   48: invokevirtual 79	com/tencent/qapmsdk/impl/instrumentation/h:b	(I)V
    //   51: aload_2
    //   52: aload 5
    //   54: invokestatic 81	com/tencent/qapmsdk/impl/instrumentation/QAPMInstrumentationHttpClient:dispatchHttpClientRequest	(Lorg/apache/http/HttpRequest;Lcom/tencent/qapmsdk/impl/instrumentation/h;)Lorg/apache/http/HttpRequest;
    //   57: astore 4
    //   59: aload 4
    //   61: astore_2
    //   62: aload_0
    //   63: aload_1
    //   64: aload_1
    //   65: aload_2
    //   66: invokestatic 84	com/tencent/qapmsdk/impl/instrumentation/c:a	(Lorg/apache/http/HttpRequest;)Lorg/apache/http/HttpRequest;
    //   69: aload 5
    //   71: invokestatic 86	com/tencent/qapmsdk/impl/instrumentation/QAPMInstrumentationHttpClient:doExec	(Lorg/apache/http/HttpHost;Lorg/apache/http/HttpRequest;Lcom/tencent/qapmsdk/impl/instrumentation/h;)Lorg/apache/http/HttpRequest;
    //   74: aload_3
    //   75: aload 5
    //   77: invokestatic 88	com/tencent/qapmsdk/impl/instrumentation/QAPMInstrumentationHttpClient:doExec	(Lorg/apache/http/client/ResponseHandler;Lcom/tencent/qapmsdk/impl/instrumentation/h;)Lorg/apache/http/client/ResponseHandler;
    //   80: invokeinterface 58 4 0
    //   85: astore_0
    //   86: aload_0
    //   87: areturn
    //   88: astore 4
    //   90: getstatic 64	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   93: iconst_3
    //   94: anewarray 66	java/lang/String
    //   97: dup
    //   98: iconst_0
    //   99: ldc 8
    //   101: aastore
    //   102: dup
    //   103: iconst_1
    //   104: ldc 90
    //   106: aastore
    //   107: dup
    //   108: iconst_2
    //   109: aload 4
    //   111: invokevirtual 94	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   114: aastore
    //   115: invokevirtual 97	com/tencent/qapmsdk/common/logger/Logger:e	([Ljava/lang/String;)V
    //   118: goto -56 -> 62
    //   121: astore_0
    //   122: aload 5
    //   124: aload_0
    //   125: invokestatic 101	com/tencent/qapmsdk/impl/instrumentation/QAPMInstrumentationHttpClient:httpClientError	(Lcom/tencent/qapmsdk/impl/instrumentation/h;Ljava/lang/Exception;)V
    //   128: aload_0
    //   129: athrow
    //   130: astore_0
    //   131: aload 5
    //   133: aload_0
    //   134: invokestatic 101	com/tencent/qapmsdk/impl/instrumentation/QAPMInstrumentationHttpClient:httpClientError	(Lcom/tencent/qapmsdk/impl/instrumentation/h;Ljava/lang/Exception;)V
    //   137: aload_0
    //   138: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	139	0	paramHttpClient	org.apache.http.client.HttpClient
    //   0	139	1	paramHttpHost	HttpHost
    //   0	139	2	paramHttpRequest	HttpRequest
    //   0	139	3	paramResponseHandler	ResponseHandler<? extends T>
    //   57	3	4	localHttpRequest	HttpRequest
    //   88	22	4	localException	Exception
    //   43	89	5	localh	h
    // Exception table:
    //   from	to	target	type
    //   45	59	88	java/lang/Exception
    //   62	86	121	org/apache/http/client/ClientProtocolException
    //   62	86	130	java/io/IOException
  }
  
  /* Error */
  @QAPMReplaceCallSite
  public static <T> T execute(org.apache.http.client.HttpClient paramHttpClient, HttpHost paramHttpHost, HttpRequest paramHttpRequest, ResponseHandler<? extends T> paramResponseHandler, org.apache.http.protocol.HttpContext paramHttpContext)
  {
    // Byte code:
    //   0: invokestatic 53	com/tencent/qapmsdk/impl/g/b:c	()Z
    //   3: ifne +15 -> 18
    //   6: aload_0
    //   7: aload_1
    //   8: aload_2
    //   9: aload_3
    //   10: aload 4
    //   12: invokeinterface 107 5 0
    //   17: areturn
    //   18: getstatic 64	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   21: iconst_2
    //   22: anewarray 66	java/lang/String
    //   25: dup
    //   26: iconst_0
    //   27: ldc 8
    //   29: aastore
    //   30: dup
    //   31: iconst_1
    //   32: ldc 68
    //   34: aastore
    //   35: invokevirtual 72	com/tencent/qapmsdk/common/logger/Logger:d	([Ljava/lang/String;)V
    //   38: new 74	com/tencent/qapmsdk/impl/instrumentation/h
    //   41: dup
    //   42: invokespecial 75	com/tencent/qapmsdk/impl/instrumentation/h:<init>	()V
    //   45: astore 6
    //   47: aload 6
    //   49: iconst_0
    //   50: invokevirtual 79	com/tencent/qapmsdk/impl/instrumentation/h:b	(I)V
    //   53: aload_2
    //   54: aload 6
    //   56: invokestatic 81	com/tencent/qapmsdk/impl/instrumentation/QAPMInstrumentationHttpClient:dispatchHttpClientRequest	(Lorg/apache/http/HttpRequest;Lcom/tencent/qapmsdk/impl/instrumentation/h;)Lorg/apache/http/HttpRequest;
    //   59: astore 5
    //   61: aload 5
    //   63: astore_2
    //   64: aload_0
    //   65: aload_1
    //   66: aload_1
    //   67: aload_2
    //   68: invokestatic 84	com/tencent/qapmsdk/impl/instrumentation/c:a	(Lorg/apache/http/HttpRequest;)Lorg/apache/http/HttpRequest;
    //   71: aload 6
    //   73: invokestatic 86	com/tencent/qapmsdk/impl/instrumentation/QAPMInstrumentationHttpClient:doExec	(Lorg/apache/http/HttpHost;Lorg/apache/http/HttpRequest;Lcom/tencent/qapmsdk/impl/instrumentation/h;)Lorg/apache/http/HttpRequest;
    //   76: aload_3
    //   77: aload 6
    //   79: invokestatic 88	com/tencent/qapmsdk/impl/instrumentation/QAPMInstrumentationHttpClient:doExec	(Lorg/apache/http/client/ResponseHandler;Lcom/tencent/qapmsdk/impl/instrumentation/h;)Lorg/apache/http/client/ResponseHandler;
    //   82: aload 4
    //   84: invokeinterface 107 5 0
    //   89: astore_0
    //   90: aload_0
    //   91: areturn
    //   92: astore 5
    //   94: getstatic 64	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   97: iconst_3
    //   98: anewarray 66	java/lang/String
    //   101: dup
    //   102: iconst_0
    //   103: ldc 8
    //   105: aastore
    //   106: dup
    //   107: iconst_1
    //   108: ldc 90
    //   110: aastore
    //   111: dup
    //   112: iconst_2
    //   113: aload 5
    //   115: invokevirtual 94	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   118: aastore
    //   119: invokevirtual 97	com/tencent/qapmsdk/common/logger/Logger:e	([Ljava/lang/String;)V
    //   122: goto -58 -> 64
    //   125: astore_0
    //   126: aload 6
    //   128: aload_0
    //   129: invokestatic 101	com/tencent/qapmsdk/impl/instrumentation/QAPMInstrumentationHttpClient:httpClientError	(Lcom/tencent/qapmsdk/impl/instrumentation/h;Ljava/lang/Exception;)V
    //   132: aload_0
    //   133: athrow
    //   134: astore_0
    //   135: aload 6
    //   137: aload_0
    //   138: invokestatic 101	com/tencent/qapmsdk/impl/instrumentation/QAPMInstrumentationHttpClient:httpClientError	(Lcom/tencent/qapmsdk/impl/instrumentation/h;Ljava/lang/Exception;)V
    //   141: aload_0
    //   142: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	143	0	paramHttpClient	org.apache.http.client.HttpClient
    //   0	143	1	paramHttpHost	HttpHost
    //   0	143	2	paramHttpRequest	HttpRequest
    //   0	143	3	paramResponseHandler	ResponseHandler<? extends T>
    //   0	143	4	paramHttpContext	org.apache.http.protocol.HttpContext
    //   59	3	5	localHttpRequest	HttpRequest
    //   92	22	5	localException	Exception
    //   45	91	6	localh	h
    // Exception table:
    //   from	to	target	type
    //   47	61	92	java/lang/Exception
    //   64	90	125	org/apache/http/client/ClientProtocolException
    //   64	90	134	java/io/IOException
  }
  
  /* Error */
  @QAPMReplaceCallSite
  public static <T> T execute(org.apache.http.client.HttpClient paramHttpClient, HttpUriRequest paramHttpUriRequest, ResponseHandler<? extends T> paramResponseHandler)
  {
    // Byte code:
    //   0: invokestatic 53	com/tencent/qapmsdk/impl/g/b:c	()Z
    //   3: ifne +12 -> 15
    //   6: aload_0
    //   7: aload_1
    //   8: aload_2
    //   9: invokeinterface 112 3 0
    //   14: areturn
    //   15: getstatic 64	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   18: iconst_2
    //   19: anewarray 66	java/lang/String
    //   22: dup
    //   23: iconst_0
    //   24: ldc 8
    //   26: aastore
    //   27: dup
    //   28: iconst_1
    //   29: ldc 68
    //   31: aastore
    //   32: invokevirtual 72	com/tencent/qapmsdk/common/logger/Logger:d	([Ljava/lang/String;)V
    //   35: new 74	com/tencent/qapmsdk/impl/instrumentation/h
    //   38: dup
    //   39: invokespecial 75	com/tencent/qapmsdk/impl/instrumentation/h:<init>	()V
    //   42: astore 4
    //   44: aload 4
    //   46: iconst_0
    //   47: invokevirtual 79	com/tencent/qapmsdk/impl/instrumentation/h:b	(I)V
    //   50: aload_1
    //   51: aload 4
    //   53: invokestatic 81	com/tencent/qapmsdk/impl/instrumentation/QAPMInstrumentationHttpClient:dispatchHttpClientRequest	(Lorg/apache/http/HttpRequest;Lcom/tencent/qapmsdk/impl/instrumentation/h;)Lorg/apache/http/HttpRequest;
    //   56: checkcast 114	org/apache/http/client/methods/HttpUriRequest
    //   59: astore_3
    //   60: aload_3
    //   61: astore_1
    //   62: aload_0
    //   63: aload_1
    //   64: invokestatic 84	com/tencent/qapmsdk/impl/instrumentation/c:a	(Lorg/apache/http/HttpRequest;)Lorg/apache/http/HttpRequest;
    //   67: checkcast 114	org/apache/http/client/methods/HttpUriRequest
    //   70: aload 4
    //   72: invokestatic 116	com/tencent/qapmsdk/impl/instrumentation/QAPMInstrumentationHttpClient:doExec	(Lorg/apache/http/client/methods/HttpUriRequest;Lcom/tencent/qapmsdk/impl/instrumentation/h;)Lorg/apache/http/client/methods/HttpUriRequest;
    //   75: aload_2
    //   76: aload 4
    //   78: invokestatic 88	com/tencent/qapmsdk/impl/instrumentation/QAPMInstrumentationHttpClient:doExec	(Lorg/apache/http/client/ResponseHandler;Lcom/tencent/qapmsdk/impl/instrumentation/h;)Lorg/apache/http/client/ResponseHandler;
    //   81: invokeinterface 112 3 0
    //   86: astore_0
    //   87: aload_0
    //   88: areturn
    //   89: astore_3
    //   90: getstatic 64	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   93: iconst_3
    //   94: anewarray 66	java/lang/String
    //   97: dup
    //   98: iconst_0
    //   99: ldc 8
    //   101: aastore
    //   102: dup
    //   103: iconst_1
    //   104: ldc 90
    //   106: aastore
    //   107: dup
    //   108: iconst_2
    //   109: aload_3
    //   110: invokevirtual 94	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   113: aastore
    //   114: invokevirtual 97	com/tencent/qapmsdk/common/logger/Logger:e	([Ljava/lang/String;)V
    //   117: goto -55 -> 62
    //   120: astore_0
    //   121: aload 4
    //   123: aload_0
    //   124: invokestatic 101	com/tencent/qapmsdk/impl/instrumentation/QAPMInstrumentationHttpClient:httpClientError	(Lcom/tencent/qapmsdk/impl/instrumentation/h;Ljava/lang/Exception;)V
    //   127: aload_0
    //   128: athrow
    //   129: astore_0
    //   130: aload 4
    //   132: aload_0
    //   133: invokestatic 101	com/tencent/qapmsdk/impl/instrumentation/QAPMInstrumentationHttpClient:httpClientError	(Lcom/tencent/qapmsdk/impl/instrumentation/h;Ljava/lang/Exception;)V
    //   136: aload_0
    //   137: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	138	0	paramHttpClient	org.apache.http.client.HttpClient
    //   0	138	1	paramHttpUriRequest	HttpUriRequest
    //   0	138	2	paramResponseHandler	ResponseHandler<? extends T>
    //   59	2	3	localHttpUriRequest	HttpUriRequest
    //   89	21	3	localException	Exception
    //   42	89	4	localh	h
    // Exception table:
    //   from	to	target	type
    //   44	60	89	java/lang/Exception
    //   62	87	120	org/apache/http/client/ClientProtocolException
    //   62	87	129	java/io/IOException
  }
  
  /* Error */
  @QAPMReplaceCallSite
  public static <T> T execute(org.apache.http.client.HttpClient paramHttpClient, HttpUriRequest paramHttpUriRequest, ResponseHandler<? extends T> paramResponseHandler, org.apache.http.protocol.HttpContext paramHttpContext)
  {
    // Byte code:
    //   0: invokestatic 53	com/tencent/qapmsdk/impl/g/b:c	()Z
    //   3: ifne +13 -> 16
    //   6: aload_0
    //   7: aload_1
    //   8: aload_2
    //   9: aload_3
    //   10: invokeinterface 121 4 0
    //   15: areturn
    //   16: getstatic 64	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   19: iconst_2
    //   20: anewarray 66	java/lang/String
    //   23: dup
    //   24: iconst_0
    //   25: ldc 8
    //   27: aastore
    //   28: dup
    //   29: iconst_1
    //   30: ldc 68
    //   32: aastore
    //   33: invokevirtual 72	com/tencent/qapmsdk/common/logger/Logger:d	([Ljava/lang/String;)V
    //   36: new 74	com/tencent/qapmsdk/impl/instrumentation/h
    //   39: dup
    //   40: invokespecial 75	com/tencent/qapmsdk/impl/instrumentation/h:<init>	()V
    //   43: astore 5
    //   45: aload 5
    //   47: iconst_0
    //   48: invokevirtual 79	com/tencent/qapmsdk/impl/instrumentation/h:b	(I)V
    //   51: aload_1
    //   52: aload 5
    //   54: invokestatic 81	com/tencent/qapmsdk/impl/instrumentation/QAPMInstrumentationHttpClient:dispatchHttpClientRequest	(Lorg/apache/http/HttpRequest;Lcom/tencent/qapmsdk/impl/instrumentation/h;)Lorg/apache/http/HttpRequest;
    //   57: checkcast 114	org/apache/http/client/methods/HttpUriRequest
    //   60: astore 4
    //   62: aload 4
    //   64: astore_1
    //   65: aload_0
    //   66: aload_1
    //   67: invokestatic 84	com/tencent/qapmsdk/impl/instrumentation/c:a	(Lorg/apache/http/HttpRequest;)Lorg/apache/http/HttpRequest;
    //   70: checkcast 114	org/apache/http/client/methods/HttpUriRequest
    //   73: aload 5
    //   75: invokestatic 116	com/tencent/qapmsdk/impl/instrumentation/QAPMInstrumentationHttpClient:doExec	(Lorg/apache/http/client/methods/HttpUriRequest;Lcom/tencent/qapmsdk/impl/instrumentation/h;)Lorg/apache/http/client/methods/HttpUriRequest;
    //   78: aload_2
    //   79: aload 5
    //   81: invokestatic 88	com/tencent/qapmsdk/impl/instrumentation/QAPMInstrumentationHttpClient:doExec	(Lorg/apache/http/client/ResponseHandler;Lcom/tencent/qapmsdk/impl/instrumentation/h;)Lorg/apache/http/client/ResponseHandler;
    //   84: aload_3
    //   85: invokeinterface 121 4 0
    //   90: astore_0
    //   91: aload_0
    //   92: areturn
    //   93: astore 4
    //   95: getstatic 64	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   98: iconst_3
    //   99: anewarray 66	java/lang/String
    //   102: dup
    //   103: iconst_0
    //   104: ldc 8
    //   106: aastore
    //   107: dup
    //   108: iconst_1
    //   109: ldc 90
    //   111: aastore
    //   112: dup
    //   113: iconst_2
    //   114: aload 4
    //   116: invokevirtual 94	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   119: aastore
    //   120: invokevirtual 97	com/tencent/qapmsdk/common/logger/Logger:e	([Ljava/lang/String;)V
    //   123: goto -58 -> 65
    //   126: astore_0
    //   127: aload 5
    //   129: aload_0
    //   130: invokestatic 101	com/tencent/qapmsdk/impl/instrumentation/QAPMInstrumentationHttpClient:httpClientError	(Lcom/tencent/qapmsdk/impl/instrumentation/h;Ljava/lang/Exception;)V
    //   133: aload_0
    //   134: athrow
    //   135: astore_0
    //   136: aload 5
    //   138: aload_0
    //   139: invokestatic 101	com/tencent/qapmsdk/impl/instrumentation/QAPMInstrumentationHttpClient:httpClientError	(Lcom/tencent/qapmsdk/impl/instrumentation/h;Ljava/lang/Exception;)V
    //   142: aload_0
    //   143: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	144	0	paramHttpClient	org.apache.http.client.HttpClient
    //   0	144	1	paramHttpUriRequest	HttpUriRequest
    //   0	144	2	paramResponseHandler	ResponseHandler<? extends T>
    //   0	144	3	paramHttpContext	org.apache.http.protocol.HttpContext
    //   60	3	4	localHttpUriRequest	HttpUriRequest
    //   93	22	4	localException	Exception
    //   43	94	5	localh	h
    // Exception table:
    //   from	to	target	type
    //   45	62	93	java/lang/Exception
    //   65	91	126	org/apache/http/client/ClientProtocolException
    //   65	91	135	java/io/IOException
  }
  
  /* Error */
  @QAPMReplaceCallSite
  public static HttpResponse execute(org.apache.http.client.HttpClient paramHttpClient, HttpHost paramHttpHost, HttpRequest paramHttpRequest)
  {
    // Byte code:
    //   0: invokestatic 53	com/tencent/qapmsdk/impl/g/b:c	()Z
    //   3: ifne +12 -> 15
    //   6: aload_0
    //   7: aload_1
    //   8: aload_2
    //   9: invokeinterface 126 3 0
    //   14: areturn
    //   15: getstatic 64	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   18: iconst_2
    //   19: anewarray 66	java/lang/String
    //   22: dup
    //   23: iconst_0
    //   24: ldc 8
    //   26: aastore
    //   27: dup
    //   28: iconst_1
    //   29: ldc 68
    //   31: aastore
    //   32: invokevirtual 72	com/tencent/qapmsdk/common/logger/Logger:d	([Ljava/lang/String;)V
    //   35: new 74	com/tencent/qapmsdk/impl/instrumentation/h
    //   38: dup
    //   39: invokespecial 75	com/tencent/qapmsdk/impl/instrumentation/h:<init>	()V
    //   42: astore 4
    //   44: aload 4
    //   46: iconst_0
    //   47: invokevirtual 79	com/tencent/qapmsdk/impl/instrumentation/h:b	(I)V
    //   50: aload_2
    //   51: aload 4
    //   53: invokestatic 81	com/tencent/qapmsdk/impl/instrumentation/QAPMInstrumentationHttpClient:dispatchHttpClientRequest	(Lorg/apache/http/HttpRequest;Lcom/tencent/qapmsdk/impl/instrumentation/h;)Lorg/apache/http/HttpRequest;
    //   56: astore_3
    //   57: aload_3
    //   58: astore_2
    //   59: aload_0
    //   60: aload_1
    //   61: aload_1
    //   62: aload_2
    //   63: invokestatic 84	com/tencent/qapmsdk/impl/instrumentation/c:a	(Lorg/apache/http/HttpRequest;)Lorg/apache/http/HttpRequest;
    //   66: aload 4
    //   68: invokestatic 86	com/tencent/qapmsdk/impl/instrumentation/QAPMInstrumentationHttpClient:doExec	(Lorg/apache/http/HttpHost;Lorg/apache/http/HttpRequest;Lcom/tencent/qapmsdk/impl/instrumentation/h;)Lorg/apache/http/HttpRequest;
    //   71: invokeinterface 126 3 0
    //   76: aload 4
    //   78: invokestatic 128	com/tencent/qapmsdk/impl/instrumentation/QAPMInstrumentationHttpClient:doExec	(Lorg/apache/http/HttpResponse;Lcom/tencent/qapmsdk/impl/instrumentation/h;)Lorg/apache/http/HttpResponse;
    //   81: astore_0
    //   82: aload_0
    //   83: areturn
    //   84: astore_3
    //   85: getstatic 64	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   88: iconst_3
    //   89: anewarray 66	java/lang/String
    //   92: dup
    //   93: iconst_0
    //   94: ldc 8
    //   96: aastore
    //   97: dup
    //   98: iconst_1
    //   99: ldc 90
    //   101: aastore
    //   102: dup
    //   103: iconst_2
    //   104: aload_3
    //   105: invokevirtual 94	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   108: aastore
    //   109: invokevirtual 97	com/tencent/qapmsdk/common/logger/Logger:e	([Ljava/lang/String;)V
    //   112: goto -53 -> 59
    //   115: astore_0
    //   116: aload 4
    //   118: aload_0
    //   119: invokestatic 101	com/tencent/qapmsdk/impl/instrumentation/QAPMInstrumentationHttpClient:httpClientError	(Lcom/tencent/qapmsdk/impl/instrumentation/h;Ljava/lang/Exception;)V
    //   122: aload_0
    //   123: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	124	0	paramHttpClient	org.apache.http.client.HttpClient
    //   0	124	1	paramHttpHost	HttpHost
    //   0	124	2	paramHttpRequest	HttpRequest
    //   56	2	3	localHttpRequest	HttpRequest
    //   84	21	3	localException	Exception
    //   42	75	4	localh	h
    // Exception table:
    //   from	to	target	type
    //   44	57	84	java/lang/Exception
    //   59	82	115	java/io/IOException
  }
  
  /* Error */
  @QAPMReplaceCallSite
  public static HttpResponse execute(org.apache.http.client.HttpClient paramHttpClient, HttpHost paramHttpHost, HttpRequest paramHttpRequest, org.apache.http.protocol.HttpContext paramHttpContext)
  {
    // Byte code:
    //   0: invokestatic 53	com/tencent/qapmsdk/impl/g/b:c	()Z
    //   3: ifne +13 -> 16
    //   6: aload_0
    //   7: aload_1
    //   8: aload_2
    //   9: aload_3
    //   10: invokeinterface 132 4 0
    //   15: areturn
    //   16: getstatic 64	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   19: iconst_2
    //   20: anewarray 66	java/lang/String
    //   23: dup
    //   24: iconst_0
    //   25: ldc 8
    //   27: aastore
    //   28: dup
    //   29: iconst_1
    //   30: ldc 68
    //   32: aastore
    //   33: invokevirtual 72	com/tencent/qapmsdk/common/logger/Logger:d	([Ljava/lang/String;)V
    //   36: new 74	com/tencent/qapmsdk/impl/instrumentation/h
    //   39: dup
    //   40: invokespecial 75	com/tencent/qapmsdk/impl/instrumentation/h:<init>	()V
    //   43: astore 5
    //   45: aload 5
    //   47: iconst_0
    //   48: invokevirtual 79	com/tencent/qapmsdk/impl/instrumentation/h:b	(I)V
    //   51: aload_2
    //   52: aload 5
    //   54: invokestatic 81	com/tencent/qapmsdk/impl/instrumentation/QAPMInstrumentationHttpClient:dispatchHttpClientRequest	(Lorg/apache/http/HttpRequest;Lcom/tencent/qapmsdk/impl/instrumentation/h;)Lorg/apache/http/HttpRequest;
    //   57: astore 4
    //   59: aload 4
    //   61: astore_2
    //   62: aload_0
    //   63: aload_1
    //   64: aload_1
    //   65: aload_2
    //   66: invokestatic 84	com/tencent/qapmsdk/impl/instrumentation/c:a	(Lorg/apache/http/HttpRequest;)Lorg/apache/http/HttpRequest;
    //   69: aload 5
    //   71: invokestatic 86	com/tencent/qapmsdk/impl/instrumentation/QAPMInstrumentationHttpClient:doExec	(Lorg/apache/http/HttpHost;Lorg/apache/http/HttpRequest;Lcom/tencent/qapmsdk/impl/instrumentation/h;)Lorg/apache/http/HttpRequest;
    //   74: aload_3
    //   75: invokeinterface 132 4 0
    //   80: aload 5
    //   82: invokestatic 128	com/tencent/qapmsdk/impl/instrumentation/QAPMInstrumentationHttpClient:doExec	(Lorg/apache/http/HttpResponse;Lcom/tencent/qapmsdk/impl/instrumentation/h;)Lorg/apache/http/HttpResponse;
    //   85: astore_0
    //   86: aload_0
    //   87: areturn
    //   88: astore 4
    //   90: getstatic 64	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   93: iconst_3
    //   94: anewarray 66	java/lang/String
    //   97: dup
    //   98: iconst_0
    //   99: ldc 8
    //   101: aastore
    //   102: dup
    //   103: iconst_1
    //   104: ldc 90
    //   106: aastore
    //   107: dup
    //   108: iconst_2
    //   109: aload 4
    //   111: invokevirtual 94	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   114: aastore
    //   115: invokevirtual 97	com/tencent/qapmsdk/common/logger/Logger:e	([Ljava/lang/String;)V
    //   118: goto -56 -> 62
    //   121: astore_0
    //   122: aload 5
    //   124: aload_0
    //   125: invokestatic 101	com/tencent/qapmsdk/impl/instrumentation/QAPMInstrumentationHttpClient:httpClientError	(Lcom/tencent/qapmsdk/impl/instrumentation/h;Ljava/lang/Exception;)V
    //   128: aload_0
    //   129: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	130	0	paramHttpClient	org.apache.http.client.HttpClient
    //   0	130	1	paramHttpHost	HttpHost
    //   0	130	2	paramHttpRequest	HttpRequest
    //   0	130	3	paramHttpContext	org.apache.http.protocol.HttpContext
    //   57	3	4	localHttpRequest	HttpRequest
    //   88	22	4	localException	Exception
    //   43	80	5	localh	h
    // Exception table:
    //   from	to	target	type
    //   45	59	88	java/lang/Exception
    //   62	86	121	java/io/IOException
  }
  
  /* Error */
  @QAPMReplaceCallSite
  public static HttpResponse execute(org.apache.http.client.HttpClient paramHttpClient, HttpUriRequest paramHttpUriRequest)
  {
    // Byte code:
    //   0: invokestatic 53	com/tencent/qapmsdk/impl/g/b:c	()Z
    //   3: ifne +11 -> 14
    //   6: aload_0
    //   7: aload_1
    //   8: invokeinterface 136 2 0
    //   13: areturn
    //   14: getstatic 64	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   17: iconst_2
    //   18: anewarray 66	java/lang/String
    //   21: dup
    //   22: iconst_0
    //   23: ldc 8
    //   25: aastore
    //   26: dup
    //   27: iconst_1
    //   28: ldc 68
    //   30: aastore
    //   31: invokevirtual 72	com/tencent/qapmsdk/common/logger/Logger:d	([Ljava/lang/String;)V
    //   34: new 74	com/tencent/qapmsdk/impl/instrumentation/h
    //   37: dup
    //   38: invokespecial 75	com/tencent/qapmsdk/impl/instrumentation/h:<init>	()V
    //   41: astore_3
    //   42: aload_3
    //   43: iconst_0
    //   44: invokevirtual 79	com/tencent/qapmsdk/impl/instrumentation/h:b	(I)V
    //   47: aload_1
    //   48: aload_3
    //   49: invokestatic 81	com/tencent/qapmsdk/impl/instrumentation/QAPMInstrumentationHttpClient:dispatchHttpClientRequest	(Lorg/apache/http/HttpRequest;Lcom/tencent/qapmsdk/impl/instrumentation/h;)Lorg/apache/http/HttpRequest;
    //   52: checkcast 114	org/apache/http/client/methods/HttpUriRequest
    //   55: astore_2
    //   56: aload_2
    //   57: astore_1
    //   58: aload_0
    //   59: aload_1
    //   60: invokestatic 84	com/tencent/qapmsdk/impl/instrumentation/c:a	(Lorg/apache/http/HttpRequest;)Lorg/apache/http/HttpRequest;
    //   63: checkcast 114	org/apache/http/client/methods/HttpUriRequest
    //   66: aload_3
    //   67: invokestatic 116	com/tencent/qapmsdk/impl/instrumentation/QAPMInstrumentationHttpClient:doExec	(Lorg/apache/http/client/methods/HttpUriRequest;Lcom/tencent/qapmsdk/impl/instrumentation/h;)Lorg/apache/http/client/methods/HttpUriRequest;
    //   70: invokeinterface 136 2 0
    //   75: aload_3
    //   76: invokestatic 128	com/tencent/qapmsdk/impl/instrumentation/QAPMInstrumentationHttpClient:doExec	(Lorg/apache/http/HttpResponse;Lcom/tencent/qapmsdk/impl/instrumentation/h;)Lorg/apache/http/HttpResponse;
    //   79: astore_0
    //   80: aload_0
    //   81: areturn
    //   82: astore_2
    //   83: getstatic 64	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   86: iconst_3
    //   87: anewarray 66	java/lang/String
    //   90: dup
    //   91: iconst_0
    //   92: ldc 8
    //   94: aastore
    //   95: dup
    //   96: iconst_1
    //   97: ldc 90
    //   99: aastore
    //   100: dup
    //   101: iconst_2
    //   102: aload_2
    //   103: invokevirtual 94	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   106: aastore
    //   107: invokevirtual 97	com/tencent/qapmsdk/common/logger/Logger:e	([Ljava/lang/String;)V
    //   110: goto -52 -> 58
    //   113: astore_0
    //   114: aload_3
    //   115: aload_0
    //   116: invokestatic 101	com/tencent/qapmsdk/impl/instrumentation/QAPMInstrumentationHttpClient:httpClientError	(Lcom/tencent/qapmsdk/impl/instrumentation/h;Ljava/lang/Exception;)V
    //   119: aload_0
    //   120: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	121	0	paramHttpClient	org.apache.http.client.HttpClient
    //   0	121	1	paramHttpUriRequest	HttpUriRequest
    //   55	2	2	localHttpUriRequest	HttpUriRequest
    //   82	21	2	localException	Exception
    //   41	74	3	localh	h
    // Exception table:
    //   from	to	target	type
    //   42	56	82	java/lang/Exception
    //   58	80	113	java/io/IOException
  }
  
  /* Error */
  @QAPMReplaceCallSite
  public static HttpResponse execute(org.apache.http.client.HttpClient paramHttpClient, HttpUriRequest paramHttpUriRequest, org.apache.http.protocol.HttpContext paramHttpContext)
  {
    // Byte code:
    //   0: invokestatic 53	com/tencent/qapmsdk/impl/g/b:c	()Z
    //   3: ifne +12 -> 15
    //   6: aload_0
    //   7: aload_1
    //   8: aload_2
    //   9: invokeinterface 140 3 0
    //   14: areturn
    //   15: getstatic 64	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   18: iconst_2
    //   19: anewarray 66	java/lang/String
    //   22: dup
    //   23: iconst_0
    //   24: ldc 8
    //   26: aastore
    //   27: dup
    //   28: iconst_1
    //   29: ldc 68
    //   31: aastore
    //   32: invokevirtual 72	com/tencent/qapmsdk/common/logger/Logger:d	([Ljava/lang/String;)V
    //   35: new 74	com/tencent/qapmsdk/impl/instrumentation/h
    //   38: dup
    //   39: invokespecial 75	com/tencent/qapmsdk/impl/instrumentation/h:<init>	()V
    //   42: astore 4
    //   44: aload 4
    //   46: iconst_0
    //   47: invokevirtual 79	com/tencent/qapmsdk/impl/instrumentation/h:b	(I)V
    //   50: aload_1
    //   51: aload 4
    //   53: invokestatic 81	com/tencent/qapmsdk/impl/instrumentation/QAPMInstrumentationHttpClient:dispatchHttpClientRequest	(Lorg/apache/http/HttpRequest;Lcom/tencent/qapmsdk/impl/instrumentation/h;)Lorg/apache/http/HttpRequest;
    //   56: checkcast 114	org/apache/http/client/methods/HttpUriRequest
    //   59: astore_3
    //   60: aload_3
    //   61: astore_1
    //   62: aload_0
    //   63: aload_1
    //   64: invokestatic 84	com/tencent/qapmsdk/impl/instrumentation/c:a	(Lorg/apache/http/HttpRequest;)Lorg/apache/http/HttpRequest;
    //   67: checkcast 114	org/apache/http/client/methods/HttpUriRequest
    //   70: aload 4
    //   72: invokestatic 116	com/tencent/qapmsdk/impl/instrumentation/QAPMInstrumentationHttpClient:doExec	(Lorg/apache/http/client/methods/HttpUriRequest;Lcom/tencent/qapmsdk/impl/instrumentation/h;)Lorg/apache/http/client/methods/HttpUriRequest;
    //   75: aload_2
    //   76: invokeinterface 140 3 0
    //   81: aload 4
    //   83: invokestatic 128	com/tencent/qapmsdk/impl/instrumentation/QAPMInstrumentationHttpClient:doExec	(Lorg/apache/http/HttpResponse;Lcom/tencent/qapmsdk/impl/instrumentation/h;)Lorg/apache/http/HttpResponse;
    //   86: astore_0
    //   87: aload_0
    //   88: areturn
    //   89: astore_3
    //   90: getstatic 64	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   93: iconst_3
    //   94: anewarray 66	java/lang/String
    //   97: dup
    //   98: iconst_0
    //   99: ldc 8
    //   101: aastore
    //   102: dup
    //   103: iconst_1
    //   104: ldc 90
    //   106: aastore
    //   107: dup
    //   108: iconst_2
    //   109: aload_3
    //   110: invokevirtual 94	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   113: aastore
    //   114: invokevirtual 97	com/tencent/qapmsdk/common/logger/Logger:e	([Ljava/lang/String;)V
    //   117: goto -55 -> 62
    //   120: astore_0
    //   121: aload 4
    //   123: aload_0
    //   124: invokestatic 101	com/tencent/qapmsdk/impl/instrumentation/QAPMInstrumentationHttpClient:httpClientError	(Lcom/tencent/qapmsdk/impl/instrumentation/h;Ljava/lang/Exception;)V
    //   127: aload_0
    //   128: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	129	0	paramHttpClient	org.apache.http.client.HttpClient
    //   0	129	1	paramHttpUriRequest	HttpUriRequest
    //   0	129	2	paramHttpContext	org.apache.http.protocol.HttpContext
    //   59	2	3	localHttpUriRequest	HttpUriRequest
    //   89	21	3	localException	Exception
    //   42	80	4	localh	h
    // Exception table:
    //   from	to	target	type
    //   44	60	89	java/lang/Exception
    //   62	87	120	java/io/IOException
  }
  
  private static void httpClientError(h paramh, Exception paramException)
  {
    com.tencent.qapmsdk.impl.a.a.a locala;
    try
    {
      if (!b.c()) {
        return;
      }
      if (paramh.f()) {
        return;
      }
      c.a(paramh, paramException);
      locala = paramh.j();
      if (locala == null)
      {
        Logger.INSTANCE.d(new String[] { "QAPM_Impl_QAPMInstrumentationHttpClient", "transactionData is null" });
        return;
      }
    }
    catch (Exception paramh)
    {
      Logger.INSTANCE.e(new String[] { "QAPM_Impl_QAPMInstrumentationHttpClient", "error httpClientError e:", paramh.getMessage() });
      return;
    }
    if (paramh.h())
    {
      paramException = "";
      if (paramh.k() != null) {
        paramException = paramh.k();
      }
      Logger.INSTANCE.d(new String[] { "QAPM_Impl_QAPMInstrumentationHttpClient", "error message:", paramException });
      com.tencent.qapmsdk.impl.d.a.a(locala, paramException);
      return;
    }
    com.tencent.qapmsdk.impl.d.a.a(locala);
  }
  
  @QAPMReplaceCallSite
  public static DefaultHttpClient initDefaultHttpClient()
  {
    return new DefaultHttpClient();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.instrumentation.QAPMInstrumentationHttpClient
 * JD-Core Version:    0.7.0.1
 */