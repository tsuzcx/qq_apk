package com.tencent.tvkbeacon.core.b;

import android.content.Context;
import android.net.Proxy;
import com.tencent.tvkbeacon.core.c.c;
import java.util.Date;
import java.util.Locale;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

final class e$a
  extends e
{
  private int a = 20000;
  private int b = 30000;
  private int c = 2000;
  private int d = 2;
  private int e = 3;
  private long f = 5000L;
  private Context g;
  
  public e$a(Context paramContext)
  {
    this.g = paramContext;
  }
  
  private b a(String paramString1, byte[] paramArrayOfByte, String paramString2, int paramInt)
  {
    if (paramString1 == null)
    {
      c.d("[net] destUrl is null.", new Object[0]);
      return null;
    }
    HttpClient localHttpClient;
    if (paramArrayOfByte != null) {
      try
      {
        paramArrayOfByte = new ByteArrayEntity(paramArrayOfByte);
        localHttpClient = a(paramString2, paramInt);
        if (localHttpClient == null)
        {
          c.d("[net] no httpClient!", new Object[0]);
          return null;
        }
      }
      catch (Throwable paramString1)
      {
        paramArrayOfByte = null;
      }
    }
    for (;;)
    {
      c.a(paramString1);
      c.d("[net] execute error:%s", new Object[] { paramString1.toString() });
      if (paramArrayOfByte != null) {
        paramArrayOfByte.abort();
      }
      throw new Exception(paramString1.toString());
      paramArrayOfByte = new ByteArrayEntity("".getBytes());
      break;
      paramString2 = new HttpPost(paramString1);
      try
      {
        paramString2.setHeader("wup_version", "3.0");
        paramString2.setHeader("TYPE_COMPRESS", "2");
        paramString2.setHeader("encr_type", "rsapost");
        paramString1 = com.tencent.tvkbeacon.core.strategy.d.a(this.g);
        if (paramString1 != null) {
          paramString2.setHeader("bea_key", paramString1.c());
        }
        paramString2.setEntity(paramArrayOfByte);
        paramString1 = new BasicHttpContext();
        paramArrayOfByte = localHttpClient.execute(paramString2, paramString1);
        c.h("[net] execute request:\n %s", new Object[] { ((HttpRequest)paramString1.getAttribute("http.request")).getRequestLine().toString() });
        paramString1 = new b(paramArrayOfByte, paramString2);
        return paramString1;
      }
      catch (Throwable paramString1)
      {
        paramArrayOfByte = paramString2;
      }
    }
  }
  
  private HttpClient a(String paramString, int paramInt)
  {
    try
    {
      Object localObject = new BasicHttpParams();
      HttpConnectionParams.setConnectionTimeout((HttpParams)localObject, 30000);
      HttpConnectionParams.setSoTimeout((HttpParams)localObject, 20000);
      HttpConnectionParams.setSocketBufferSize((HttpParams)localObject, 2000);
      ((BasicHttpParams)localObject).setBooleanParameter("http.protocol.handle-redirects", false);
      DefaultHttpClient localDefaultHttpClient = new DefaultHttpClient((HttpParams)localObject);
      HttpProtocolParams.setUseExpectContinue((HttpParams)localObject, false);
      localDefaultHttpClient.setHttpRequestRetryHandler(new e.a.1(this));
      if ((paramString != null) && (paramString.toLowerCase(Locale.US).contains("wap")) && (paramInt != 2))
      {
        c.a("[net] use proxy: %s, try time: %s", new Object[] { paramString, Integer.valueOf(paramInt) });
        localObject = Proxy.getDefaultHost();
        paramInt = Proxy.getDefaultPort();
        paramString = localDefaultHttpClient;
        if (localObject != null)
        {
          paramString = new HttpHost((String)localObject, paramInt);
          localDefaultHttpClient.getParams().setParameter("http.route.default-proxy", paramString);
          return localDefaultHttpClient;
        }
      }
      else
      {
        if (paramString != null) {
          c.a("[net] Don't use proxy: %s, try time: %s", new Object[] { paramString, Integer.valueOf(paramInt) });
        }
        localDefaultHttpClient.getParams().removeParameter("http.route.default-proxy");
        return localDefaultHttpClient;
      }
    }
    catch (Throwable paramString)
    {
      c.a(paramString);
      c.d("[net] httpclient error!", new Object[0]);
      paramString = null;
    }
    return paramString;
  }
  
  /* Error */
  private byte[] a(HttpResponse paramHttpResponse, HttpPost paramHttpPost)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aload_1
    //   4: ifnonnull +10 -> 14
    //   7: aload 6
    //   9: astore 4
    //   11: aload 4
    //   13: areturn
    //   14: aload_1
    //   15: invokeinterface 257 1 0
    //   20: invokeinterface 262 1 0
    //   25: istore_3
    //   26: iload_3
    //   27: sipush 200
    //   30: if_icmpeq +31 -> 61
    //   33: ldc_w 264
    //   36: iconst_2
    //   37: anewarray 43	java/lang/Object
    //   40: dup
    //   41: iconst_0
    //   42: iload_3
    //   43: invokestatic 214	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   46: aastore
    //   47: dup
    //   48: iconst_1
    //   49: aload_1
    //   50: invokeinterface 257 1 0
    //   55: aastore
    //   56: invokestatic 266	com/tencent/tvkbeacon/core/c/c:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   59: aconst_null
    //   60: areturn
    //   61: aload_1
    //   62: ldc_w 268
    //   65: invokeinterface 271 2 0
    //   70: ifeq +65 -> 135
    //   73: aload_1
    //   74: ldc_w 273
    //   77: invokeinterface 271 2 0
    //   82: ifeq +53 -> 135
    //   85: aload_1
    //   86: ldc_w 268
    //   89: invokeinterface 277 2 0
    //   94: invokeinterface 282 1 0
    //   99: astore 4
    //   101: aload_1
    //   102: ldc_w 273
    //   105: invokeinterface 277 2 0
    //   110: invokeinterface 282 1 0
    //   115: astore 5
    //   117: aload_0
    //   118: getfield 35	com/tencent/tvkbeacon/core/b/e$a:g	Landroid/content/Context;
    //   121: invokestatic 107	com/tencent/tvkbeacon/core/strategy/d:a	(Landroid/content/Context;)Lcom/tencent/tvkbeacon/core/strategy/d;
    //   124: aload_0
    //   125: getfield 35	com/tencent/tvkbeacon/core/b/e$a:g	Landroid/content/Context;
    //   128: aload 4
    //   130: aload 5
    //   132: invokevirtual 285	com/tencent/tvkbeacon/core/strategy/d:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   135: aload_1
    //   136: invokeinterface 289 1 0
    //   141: astore_1
    //   142: aload_1
    //   143: ifnonnull +15 -> 158
    //   146: ldc_w 291
    //   149: iconst_0
    //   150: anewarray 43	java/lang/Object
    //   153: invokestatic 48	com/tencent/tvkbeacon/core/c/c:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   156: aconst_null
    //   157: areturn
    //   158: new 293	java/io/BufferedInputStream
    //   161: dup
    //   162: new 295	java/io/DataInputStream
    //   165: dup
    //   166: aload_1
    //   167: invokeinterface 301 1 0
    //   172: invokespecial 304	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   175: invokespecial 305	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   178: astore 4
    //   180: aload 4
    //   182: astore_1
    //   183: new 307	java/io/ByteArrayOutputStream
    //   186: dup
    //   187: invokespecial 308	java/io/ByteArrayOutputStream:<init>	()V
    //   190: astore 5
    //   192: aload 4
    //   194: astore_1
    //   195: aload 4
    //   197: invokevirtual 311	java/io/BufferedInputStream:read	()I
    //   200: istore_3
    //   201: iload_3
    //   202: iconst_m1
    //   203: if_icmpeq +70 -> 273
    //   206: aload 4
    //   208: astore_1
    //   209: aload 5
    //   211: iload_3
    //   212: invokevirtual 315	java/io/ByteArrayOutputStream:write	(I)V
    //   215: goto -23 -> 192
    //   218: astore 5
    //   220: aload 4
    //   222: astore_1
    //   223: aload 5
    //   225: invokestatic 61	com/tencent/tvkbeacon/core/c/c:a	(Ljava/lang/Throwable;)V
    //   228: aload 4
    //   230: astore_1
    //   231: ldc_w 317
    //   234: iconst_1
    //   235: anewarray 43	java/lang/Object
    //   238: dup
    //   239: iconst_0
    //   240: aload 5
    //   242: invokevirtual 67	java/lang/Throwable:toString	()Ljava/lang/String;
    //   245: aastore
    //   246: invokestatic 48	com/tencent/tvkbeacon/core/c/c:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   249: aload 4
    //   251: ifnull +8 -> 259
    //   254: aload 4
    //   256: invokevirtual 320	java/io/BufferedInputStream:close	()V
    //   259: aload 6
    //   261: astore 4
    //   263: aload_2
    //   264: ifnull -253 -> 11
    //   267: aload_2
    //   268: invokevirtual 72	org/apache/http/client/methods/HttpPost:abort	()V
    //   271: aconst_null
    //   272: areturn
    //   273: aload 4
    //   275: astore_1
    //   276: aload 5
    //   278: invokevirtual 323	java/io/ByteArrayOutputStream:flush	()V
    //   281: aload 4
    //   283: astore_1
    //   284: aload 5
    //   286: invokevirtual 326	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   289: astore 5
    //   291: aload 5
    //   293: astore_1
    //   294: aload 4
    //   296: invokevirtual 320	java/io/BufferedInputStream:close	()V
    //   299: aload_1
    //   300: astore 4
    //   302: aload_2
    //   303: ifnull -292 -> 11
    //   306: aload_2
    //   307: invokevirtual 72	org/apache/http/client/methods/HttpPost:abort	()V
    //   310: aload_1
    //   311: areturn
    //   312: astore 4
    //   314: aload 4
    //   316: invokestatic 61	com/tencent/tvkbeacon/core/c/c:a	(Ljava/lang/Throwable;)V
    //   319: goto -20 -> 299
    //   322: astore_1
    //   323: aload_1
    //   324: invokestatic 61	com/tencent/tvkbeacon/core/c/c:a	(Ljava/lang/Throwable;)V
    //   327: goto -68 -> 259
    //   330: astore 4
    //   332: aconst_null
    //   333: astore_1
    //   334: aload_1
    //   335: ifnull +7 -> 342
    //   338: aload_1
    //   339: invokevirtual 320	java/io/BufferedInputStream:close	()V
    //   342: aload_2
    //   343: ifnull +7 -> 350
    //   346: aload_2
    //   347: invokevirtual 72	org/apache/http/client/methods/HttpPost:abort	()V
    //   350: aload 4
    //   352: athrow
    //   353: astore_1
    //   354: aload_1
    //   355: invokestatic 61	com/tencent/tvkbeacon/core/c/c:a	(Ljava/lang/Throwable;)V
    //   358: goto -16 -> 342
    //   361: astore 4
    //   363: goto -29 -> 334
    //   366: astore 5
    //   368: aconst_null
    //   369: astore 4
    //   371: goto -151 -> 220
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	374	0	this	a
    //   0	374	1	paramHttpResponse	HttpResponse
    //   0	374	2	paramHttpPost	HttpPost
    //   25	187	3	i	int
    //   9	292	4	localObject1	Object
    //   312	3	4	localThrowable1	Throwable
    //   330	21	4	localObject2	Object
    //   361	1	4	localObject3	Object
    //   369	1	4	localObject4	Object
    //   115	95	5	localObject5	Object
    //   218	67	5	localThrowable2	Throwable
    //   289	3	5	arrayOfByte	byte[]
    //   366	1	5	localThrowable3	Throwable
    //   1	259	6	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   183	192	218	java/lang/Throwable
    //   195	201	218	java/lang/Throwable
    //   209	215	218	java/lang/Throwable
    //   276	281	218	java/lang/Throwable
    //   284	291	218	java/lang/Throwable
    //   294	299	312	java/lang/Throwable
    //   254	259	322	java/lang/Throwable
    //   158	180	330	finally
    //   338	342	353	java/lang/Throwable
    //   183	192	361	finally
    //   195	201	361	finally
    //   209	215	361	finally
    //   223	228	361	finally
    //   231	249	361	finally
    //   276	281	361	finally
    //   284	291	361	finally
    //   158	180	366	java/lang/Throwable
  }
  
  public final boolean a()
  {
    return false;
  }
  
  public final byte[] a(String paramString, byte[] paramArrayOfByte, a parama, d paramd)
  {
    if (paramString == null)
    {
      c.d("[net] destUrl is null.", new Object[0]);
      return null;
    }
    c.b("[net] HTTP requestCmd(%d) moduleId(%d) eventCnt(%d)", new Object[] { Integer.valueOf(parama.a), Integer.valueOf(parama.b), Integer.valueOf(parama.e) });
    int j = 0;
    if (paramArrayOfByte == null) {}
    int i;
    Object localObject1;
    Object localObject3;
    int k;
    Object localObject2;
    int m;
    for (long l2 = 0L;; l2 = paramArrayOfByte.length)
    {
      c.h("[net] request url:%s sz:%d", new Object[] { paramString, Long.valueOf(l2) });
      i = 0;
      localObject1 = null;
      localObject3 = paramString;
      paramString = "";
      k = 0;
      localObject2 = "";
      m = k + 1;
      if ((k >= 3) || (j >= 2)) {
        break label816;
      }
      if (i == 0) {
        break;
      }
      throw new Exception("net redirect");
    }
    if (m > 1)
    {
      c.h("[net] try time:".concat(String.valueOf(m)), new Object[0]);
      if ((m == 2) && (parama.c() == 2)) {
        parama.b(false);
      }
      b();
    }
    Object localObject5 = com.tencent.tvkbeacon.core.c.d.c(this.g);
    paramd.a((String)localObject3, l2, (String)localObject5, m);
    long l1 = new Date().getTime();
    try
    {
      localObject5 = a((String)localObject3, paramArrayOfByte, (String)localObject5, m);
      localObject1 = localObject2;
      localObject2 = localObject5;
    }
    catch (Exception localException2)
    {
      long l3;
      Object localObject7 = localException2.toString();
      if (!paramString.equals(localObject7)) {
        break label475;
      }
      label475:
      for (localObject2 = (String)localObject2 + m + ":same ";; localObject2 = (String)localObject2 + m + ":" + (String)localObject7 + " ")
      {
        localObject6 = localObject1;
        paramString = (String)localObject7;
        localObject1 = localObject2;
        localObject2 = localObject6;
        break;
      }
      paramString = a((HttpResponse)localObject6, ((b)localObject2).b);
      if (paramString != null) {
        break label549;
      }
      label549:
      for (l1 = 0L;; l1 = paramString.length)
      {
        paramd.a(l1, l4);
        return paramString;
      }
      if (i2 == 301) {
        break label589;
      }
    }
    long l4 = new Date().getTime() - l1;
    int i2;
    Object localObject6;
    if (localObject2 != null)
    {
      localObject5 = ((b)localObject2).a;
      localObject7 = ((HttpResponse)localObject5).getEntity();
      l1 = 0L;
      if (localObject7 != null)
      {
        l3 = ((HttpEntity)localObject7).getContentLength();
        l1 = l3;
        if (l3 < 0L) {
          l1 = 0L;
        }
      }
      i2 = ((HttpResponse)localObject5).getStatusLine().getStatusCode();
      c.h("[net] response code:%d ", new Object[] { Integer.valueOf(i2) });
      if (i2 == 200) {
        if (((HttpResponse)localObject5).containsHeader("encrypt-status"))
        {
          c.d("[net] svr encry failed: " + ((HttpResponse)localObject5).getFirstHeader("encrypt-status").getValue(), new Object[0]);
          return null;
        }
      }
      if ((i2 == 302) || (i2 == 303) || (i2 == 307))
      {
        label589:
        k = 1;
        label592:
        if (k == 0) {
          break label851;
        }
        m = 1;
        localObject3 = ((HttpResponse)localObject6).getFirstHeader("Location");
        if (localObject3 != null) {
          break label672;
        }
        c.d("[net] redirect code:" + i2 + " Location is null! return", new Object[0]);
      }
    }
    for (;;)
    {
      try
      {
        if (((b)localObject2).b != null) {
          ((b)localObject2).b.abort();
        }
        return null;
        k = 0;
        break label592;
        label672:
        n = j + 1;
        i1 = 0;
        localObject6 = ((Header)localObject3).getValue();
        c.h("[net] redirect code:%d , to:%s", new Object[] { Integer.valueOf(i2), localObject6 });
        i = m;
        j = n;
        k = i1;
        localObject3 = localObject6;
        try
        {
          if (((b)localObject2).b != null)
          {
            ((b)localObject2).b.abort();
            localObject3 = localObject6;
            k = i1;
            j = n;
            i = m;
          }
        }
        catch (Exception localException1)
        {
          label816:
          i = m;
          j = n;
          k = i1;
          Object localObject4 = localObject6;
          continue;
        }
        paramd.a(l1, l4);
        localObject6 = localObject2;
        localObject2 = localObject1;
        localObject1 = localObject6;
        break;
        paramd.a(0L, l4);
        localObject6 = localObject2;
        k = m;
        localObject2 = localObject1;
        localObject1 = localObject6;
        break;
        throw new Exception((String)localObject2);
      }
      catch (Exception paramString)
      {
        int n;
        int i1;
        continue;
      }
      label851:
      k = m;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tvkbeacon.core.b.e.a
 * JD-Core Version:    0.7.0.1
 */