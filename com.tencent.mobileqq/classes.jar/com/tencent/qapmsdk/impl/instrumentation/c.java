package com.tencent.qapmsdk.impl.instrumentation;

import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.common.network.NetworkWatcher;
import com.tencent.qapmsdk.impl.g.a;
import java.io.IOException;
import java.net.ConnectException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.Map;
import java.util.TreeMap;
import javax.net.ssl.SSLException;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.RequestLine;
import org.apache.http.StatusLine;
import org.apache.http.auth.AuthenticationException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpTrace;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.entity.HttpEntityWrapper;

public class c
{
  public static Map<String, Object> a(HttpResponse paramHttpResponse)
  {
    TreeMap localTreeMap = new TreeMap();
    if (paramHttpResponse != null)
    {
      paramHttpResponse = paramHttpResponse.getAllHeaders();
      if (paramHttpResponse != null)
      {
        int i = 0;
        while (i < paramHttpResponse.length)
        {
          Object localObject = paramHttpResponse[i];
          localTreeMap.put(localObject.getName(), localObject.getValue());
          i += 1;
        }
      }
    }
    return localTreeMap;
  }
  
  public static HttpRequest a(h paramh, HttpHost paramHttpHost, HttpRequest paramHttpRequest)
  {
    if (paramHttpRequest == null) {
      return paramHttpRequest;
    }
    paramHttpHost = paramHttpRequest.getRequestLine();
    String str1 = null;
    if (paramHttpHost != null)
    {
      String str2 = paramHttpHost.getUri();
      paramHttpHost = str2;
      if (str2.contains("?"))
      {
        int i = str2.indexOf("?");
        paramHttpHost = str2.substring(0, i);
        str1 = str2.substring(i + 1);
      }
    }
    else
    {
      paramHttpHost = null;
    }
    paramh.f(paramHttpHost);
    paramh.b(str1);
    paramh.a(str1);
    paramh.a(com.tencent.qapmsdk.impl.b.b.c);
    a(paramh, paramHttpRequest, str1);
    paramh.c(NetworkWatcher.INSTANCE.activeNetworkCarrier());
    b(paramh, paramHttpRequest);
    return paramHttpRequest;
  }
  
  public static HttpRequest a(HttpRequest paramHttpRequest)
  {
    return paramHttpRequest;
  }
  
  public static HttpResponse a(h paramh, HttpResponse paramHttpResponse)
  {
    try
    {
      paramh.c(paramHttpResponse.getStatusLine().getStatusCode());
      Object localObject = paramHttpResponse.getHeaders("Content-Type");
      if ((localObject != null) && (localObject.length > 0)) {
        paramh.g(a.a(localObject[0].getValue()));
      }
      localObject = paramHttpResponse.getHeaders("Content-Length");
      if (localObject != null)
      {
        int i = localObject.length;
        if (i > 0) {
          try
          {
            long l = Long.parseLong(localObject[0].getValue());
            paramh.d(l);
            localObject = paramHttpResponse.getEntity();
            if (localObject == null)
            {
              paramHttpResponse.setEntity((HttpEntity)null);
              return paramHttpResponse;
            }
            if ((localObject instanceof HttpEntityWrapper))
            {
              paramHttpResponse.setEntity(new com.tencent.qapmsdk.impl.instrumentation.a.d(paramHttpResponse, paramh, l));
              return paramHttpResponse;
            }
            paramHttpResponse.setEntity(new com.tencent.qapmsdk.impl.instrumentation.a.c(paramHttpResponse, paramh, l));
            return paramHttpResponse;
          }
          catch (NumberFormatException paramh)
          {
            Logger.INSTANCE.e(new String[] { "QAPM_Impl_QAPMHttpClientUtil", "Failed to parse content length: ", paramh.toString() });
            return paramHttpResponse;
          }
        }
      }
      if (paramHttpResponse.getEntity() != null)
      {
        if ((paramHttpResponse.getEntity() instanceof HttpEntityWrapper))
        {
          paramHttpResponse.setEntity(new com.tencent.qapmsdk.impl.instrumentation.a.d(paramHttpResponse, paramh, -1L));
          return paramHttpResponse;
        }
        paramHttpResponse.setEntity(new com.tencent.qapmsdk.impl.instrumentation.a.c(paramHttpResponse, paramh, -1L));
        return paramHttpResponse;
      }
      paramh.d(0L);
      b(paramh, (HttpResponse)null);
      return paramHttpResponse;
    }
    catch (Exception paramh)
    {
      Logger.INSTANCE.e(new String[] { "QAPM_Impl_QAPMHttpClientUtil", " java.lang.NoSuchMethodError: org.apache.http.HttpResponse.getHeaders", paramh.toString() });
    }
    return paramHttpResponse;
  }
  
  public static HttpUriRequest a(h paramh, HttpUriRequest paramHttpUriRequest)
  {
    if (paramHttpUriRequest == null) {
      return paramHttpUriRequest;
    }
    Object localObject = paramHttpUriRequest.getRequestLine();
    String str1 = null;
    if (localObject != null)
    {
      String str2 = ((RequestLine)localObject).getUri();
      localObject = str2;
      if (str2.contains("?"))
      {
        int i = str2.indexOf("?");
        localObject = str2.substring(0, i);
        str1 = str2.substring(i + 1);
      }
    }
    else
    {
      localObject = paramHttpUriRequest.getURI().toString();
    }
    paramh.f((String)localObject);
    paramh.c(NetworkWatcher.INSTANCE.activeNetworkCarrier());
    paramh.e(paramHttpUriRequest.getMethod());
    paramh.b(str1);
    paramh.a(str1);
    paramh.a(com.tencent.qapmsdk.impl.b.b.c);
    a(paramh, paramHttpUriRequest, str1);
    b(paramh, paramHttpUriRequest);
    return paramHttpUriRequest;
  }
  
  public static void a(h paramh, Exception paramException)
  {
    if ((paramException instanceof IOException))
    {
      if (i.a(paramException))
      {
        paramh.a(911, paramException.toString());
        paramh.c(911);
        return;
      }
      String str = paramException.getMessage();
      if ((str != null) && (str.contains("ftruncate failed: ENOENT (No such file or directory)")))
      {
        paramh.a(917, paramException.toString());
        paramh.c(917);
        return;
      }
    }
    if ((paramException instanceof UnknownHostException))
    {
      paramh.a(901, paramException.toString());
      paramh.c(901);
      return;
    }
    if ((!(paramException instanceof SocketTimeoutException)) && (!(paramException instanceof ConnectTimeoutException)))
    {
      if ((paramException instanceof ConnectException))
      {
        paramh.a(902, paramException.toString());
        paramh.c(902);
        return;
      }
      if ((paramException instanceof MalformedURLException))
      {
        paramh.a(900, paramException.toString());
        paramh.c(900);
        return;
      }
      if ((paramException instanceof SSLException))
      {
        paramh.a(908, paramException.toString());
        paramh.c(908);
        return;
      }
      if ((paramException instanceof HttpResponseException))
      {
        paramh.c(((HttpResponseException)paramException).getStatusCode());
        return;
      }
      if ((paramException instanceof ClientProtocolException))
      {
        paramh.a(904, paramException.toString());
        paramh.c(904);
        return;
      }
      if ((paramException instanceof AuthenticationException))
      {
        paramh.a(907, paramException.toString());
        paramh.c(907);
        return;
      }
      paramh.a(-1, paramException.toString());
      paramh.c(-1);
      return;
    }
    paramh.a(903, paramException.toString());
    paramh.c(903);
  }
  
  public static void a(h paramh, HttpRequest paramHttpRequest)
  {
    if ((paramHttpRequest instanceof HttpOptions))
    {
      paramh.a(com.tencent.qapmsdk.impl.b.d.g);
      return;
    }
    if ((paramHttpRequest instanceof HttpGet))
    {
      paramh.a(com.tencent.qapmsdk.impl.b.d.a);
      return;
    }
    if ((paramHttpRequest instanceof HttpHead))
    {
      paramh.a(com.tencent.qapmsdk.impl.b.d.e);
      return;
    }
    if ((paramHttpRequest instanceof HttpPost))
    {
      paramh.a(com.tencent.qapmsdk.impl.b.d.b);
      return;
    }
    if ((paramHttpRequest instanceof HttpPut))
    {
      paramh.a(com.tencent.qapmsdk.impl.b.d.c);
      return;
    }
    if ((paramHttpRequest instanceof HttpDelete))
    {
      paramh.a(com.tencent.qapmsdk.impl.b.d.d);
      return;
    }
    if ((paramHttpRequest instanceof HttpTrace))
    {
      paramh.a(com.tencent.qapmsdk.impl.b.d.f);
      return;
    }
    paramh.a(com.tencent.qapmsdk.impl.b.d.a);
  }
  
  private static void a(h paramh, HttpRequest paramHttpRequest, String paramString)
  {
    a(paramh, paramHttpRequest);
    i.b(paramh, paramh.b());
    paramHttpRequest = new c.1(paramHttpRequest);
    i.a(paramh.d(), paramHttpRequest, paramh);
  }
  
  private static void b(h paramh, HttpRequest paramHttpRequest)
  {
    if ((paramHttpRequest instanceof HttpEntityEnclosingRequest))
    {
      paramHttpRequest = (HttpEntityEnclosingRequest)paramHttpRequest;
      if (paramHttpRequest.getEntity() != null) {
        paramHttpRequest.setEntity(new com.tencent.qapmsdk.impl.instrumentation.a.b(paramHttpRequest.getEntity(), paramh));
      }
    }
  }
  
  /* Error */
  private static void b(h paramh, HttpResponse paramHttpResponse)
  {
    // Byte code:
    //   0: invokestatic 309	com/tencent/qapmsdk/impl/g/b:c	()Z
    //   3: ifeq +430 -> 433
    //   6: aload_0
    //   7: invokevirtual 313	com/tencent/qapmsdk/impl/instrumentation/h:j	()Lcom/tencent/qapmsdk/impl/a/a/a;
    //   10: astore 8
    //   12: aload 8
    //   14: ifnonnull +25 -> 39
    //   17: getstatic 172	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   20: iconst_2
    //   21: anewarray 50	java/lang/String
    //   24: dup
    //   25: iconst_0
    //   26: ldc 174
    //   28: aastore
    //   29: dup
    //   30: iconst_1
    //   31: ldc_w 315
    //   34: aastore
    //   35: invokevirtual 317	com/tencent/qapmsdk/common/logger/Logger:d	([Ljava/lang/String;)V
    //   38: return
    //   39: aload_0
    //   40: invokevirtual 320	com/tencent/qapmsdk/impl/instrumentation/h:h	()Z
    //   43: ifeq +371 -> 414
    //   46: new 322	java/lang/StringBuilder
    //   49: dup
    //   50: invokespecial 323	java/lang/StringBuilder:<init>	()V
    //   53: astore 9
    //   55: aload_1
    //   56: ifnull +262 -> 318
    //   59: aconst_null
    //   60: astore 6
    //   62: aconst_null
    //   63: astore 7
    //   65: aconst_null
    //   66: astore 5
    //   68: aload 5
    //   70: astore_2
    //   71: aload 6
    //   73: astore_3
    //   74: aload 7
    //   76: astore 4
    //   78: aload_1
    //   79: invokeinterface 151 1 0
    //   84: instanceof 298
    //   87: ifne +32 -> 119
    //   90: aload 5
    //   92: astore_2
    //   93: aload 6
    //   95: astore_3
    //   96: aload 7
    //   98: astore 4
    //   100: aload_1
    //   101: new 325	com/tencent/qapmsdk/impl/instrumentation/a/a
    //   104: dup
    //   105: aload_1
    //   106: invokeinterface 151 1 0
    //   111: invokespecial 327	com/tencent/qapmsdk/impl/instrumentation/a/a:<init>	(Lorg/apache/http/HttpEntity;)V
    //   114: invokeinterface 157 2 0
    //   119: aload 5
    //   121: astore_2
    //   122: aload 6
    //   124: astore_3
    //   125: aload 7
    //   127: astore 4
    //   129: aload_1
    //   130: invokeinterface 151 1 0
    //   135: invokeinterface 331 1 0
    //   140: astore 5
    //   142: aload 5
    //   144: astore_2
    //   145: aload 5
    //   147: astore_3
    //   148: aload 5
    //   150: astore 4
    //   152: aload 5
    //   154: instanceof 333
    //   157: ifeq +30 -> 187
    //   160: aload 5
    //   162: astore_2
    //   163: aload 5
    //   165: astore_3
    //   166: aload 5
    //   168: astore 4
    //   170: aload 9
    //   172: aload 5
    //   174: checkcast 333	com/tencent/qapmsdk/impl/instrumentation/b/a
    //   177: invokevirtual 334	com/tencent/qapmsdk/impl/instrumentation/b/a:b	()Ljava/lang/String;
    //   180: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: pop
    //   184: goto +34 -> 218
    //   187: aload 5
    //   189: astore_2
    //   190: aload 5
    //   192: astore_3
    //   193: aload 5
    //   195: astore 4
    //   197: getstatic 172	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   200: iconst_2
    //   201: anewarray 50	java/lang/String
    //   204: dup
    //   205: iconst_0
    //   206: ldc 174
    //   208: aastore
    //   209: dup
    //   210: iconst_1
    //   211: ldc_w 340
    //   214: aastore
    //   215: invokevirtual 317	com/tencent/qapmsdk/common/logger/Logger:d	([Ljava/lang/String;)V
    //   218: aload 5
    //   220: ifnull +98 -> 318
    //   223: aload 5
    //   225: astore_3
    //   226: aload_3
    //   227: invokevirtual 345	java/io/InputStream:close	()V
    //   230: goto +88 -> 318
    //   233: astore_0
    //   234: goto +74 -> 308
    //   237: astore 4
    //   239: aload_3
    //   240: astore_2
    //   241: getstatic 172	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   244: iconst_2
    //   245: anewarray 50	java/lang/String
    //   248: dup
    //   249: iconst_0
    //   250: ldc 174
    //   252: aastore
    //   253: dup
    //   254: iconst_1
    //   255: aload 4
    //   257: invokevirtual 346	java/io/IOException:toString	()Ljava/lang/String;
    //   260: aastore
    //   261: invokevirtual 183	com/tencent/qapmsdk/common/logger/Logger:e	([Ljava/lang/String;)V
    //   264: aload_3
    //   265: ifnull +53 -> 318
    //   268: goto -42 -> 226
    //   271: astore_3
    //   272: aload 4
    //   274: astore_2
    //   275: getstatic 172	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   278: iconst_2
    //   279: anewarray 50	java/lang/String
    //   282: dup
    //   283: iconst_0
    //   284: ldc 174
    //   286: aastore
    //   287: dup
    //   288: iconst_1
    //   289: aload_3
    //   290: invokevirtual 347	java/lang/IllegalStateException:toString	()Ljava/lang/String;
    //   293: aastore
    //   294: invokevirtual 183	com/tencent/qapmsdk/common/logger/Logger:e	([Ljava/lang/String;)V
    //   297: aload 4
    //   299: ifnull +19 -> 318
    //   302: aload 4
    //   304: astore_3
    //   305: goto -79 -> 226
    //   308: aload_2
    //   309: ifnull +7 -> 316
    //   312: aload_2
    //   313: invokevirtual 345	java/io/InputStream:close	()V
    //   316: aload_0
    //   317: athrow
    //   318: aload_1
    //   319: invokestatic 349	com/tencent/qapmsdk/impl/instrumentation/c:a	(Lorg/apache/http/HttpResponse;)Ljava/util/Map;
    //   322: ldc 137
    //   324: aload_0
    //   325: invokevirtual 353	com/tencent/qapmsdk/impl/instrumentation/h:i	()J
    //   328: invokestatic 357	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   331: invokeinterface 360 3 0
    //   336: pop
    //   337: getstatic 172	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   340: iconst_3
    //   341: anewarray 50	java/lang/String
    //   344: dup
    //   345: iconst_0
    //   346: ldc 174
    //   348: aastore
    //   349: dup
    //   350: iconst_1
    //   351: ldc_w 362
    //   354: aastore
    //   355: dup
    //   356: iconst_2
    //   357: aload 9
    //   359: invokevirtual 363	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   362: aastore
    //   363: invokevirtual 317	com/tencent/qapmsdk/common/logger/Logger:d	([Ljava/lang/String;)V
    //   366: ldc_w 365
    //   369: astore_1
    //   370: aload_0
    //   371: invokevirtual 368	com/tencent/qapmsdk/impl/instrumentation/h:k	()Ljava/lang/String;
    //   374: ifnull +8 -> 382
    //   377: aload_0
    //   378: invokevirtual 368	com/tencent/qapmsdk/impl/instrumentation/h:k	()Ljava/lang/String;
    //   381: astore_1
    //   382: getstatic 172	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   385: iconst_3
    //   386: anewarray 50	java/lang/String
    //   389: dup
    //   390: iconst_0
    //   391: ldc 174
    //   393: aastore
    //   394: dup
    //   395: iconst_1
    //   396: ldc_w 370
    //   399: aastore
    //   400: dup
    //   401: iconst_2
    //   402: aload_1
    //   403: aastore
    //   404: invokevirtual 317	com/tencent/qapmsdk/common/logger/Logger:d	([Ljava/lang/String;)V
    //   407: aload 8
    //   409: aload_1
    //   410: invokestatic 375	com/tencent/qapmsdk/impl/d/a:a	(Lcom/tencent/qapmsdk/impl/a/a/a;Ljava/lang/String;)V
    //   413: return
    //   414: aload 8
    //   416: invokestatic 378	com/tencent/qapmsdk/impl/d/a:a	(Lcom/tencent/qapmsdk/impl/a/a/a;)V
    //   419: return
    //   420: astore_0
    //   421: getstatic 172	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   424: ldc 174
    //   426: ldc_w 380
    //   429: aload_0
    //   430: invokevirtual 384	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   433: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	434	0	paramh	h
    //   0	434	1	paramHttpResponse	HttpResponse
    //   70	243	2	localObject1	Object
    //   73	192	3	localObject2	Object
    //   271	19	3	localIllegalStateException	java.lang.IllegalStateException
    //   304	1	3	localObject3	Object
    //   76	120	4	localObject4	Object
    //   237	66	4	localIOException	IOException
    //   66	158	5	localInputStream	java.io.InputStream
    //   60	63	6	localObject5	Object
    //   63	63	7	localObject6	Object
    //   10	405	8	locala	com.tencent.qapmsdk.impl.a.a.a
    //   53	305	9	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   78	90	233	finally
    //   100	119	233	finally
    //   129	142	233	finally
    //   152	160	233	finally
    //   170	184	233	finally
    //   197	218	233	finally
    //   241	264	233	finally
    //   275	297	233	finally
    //   78	90	237	java/io/IOException
    //   100	119	237	java/io/IOException
    //   129	142	237	java/io/IOException
    //   152	160	237	java/io/IOException
    //   170	184	237	java/io/IOException
    //   197	218	237	java/io/IOException
    //   78	90	271	java/lang/IllegalStateException
    //   100	119	271	java/lang/IllegalStateException
    //   129	142	271	java/lang/IllegalStateException
    //   152	160	271	java/lang/IllegalStateException
    //   170	184	271	java/lang/IllegalStateException
    //   197	218	271	java/lang/IllegalStateException
    //   6	12	420	java/lang/Exception
    //   17	38	420	java/lang/Exception
    //   39	55	420	java/lang/Exception
    //   226	230	420	java/lang/Exception
    //   312	316	420	java/lang/Exception
    //   316	318	420	java/lang/Exception
    //   318	366	420	java/lang/Exception
    //   370	382	420	java/lang/Exception
    //   382	413	420	java/lang/Exception
    //   414	419	420	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.instrumentation.c
 * JD-Core Version:    0.7.0.1
 */