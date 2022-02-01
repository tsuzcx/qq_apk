package cooperation.qzone;

import android.content.Context;
import com.tencent.component.network.utils.NetworkUtils;
import cooperation.qzone.util.NetworkState;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.DefaultHttpRoutePlanner;
import org.apache.http.impl.conn.SingleClientConnManager;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;

public class QZoneHttpUtil
{
  private static final int CONNECTION_TIMEOUT = 20000;
  public static final int DEFAULT_CONNECT_TIMEOUT = 60000;
  public static final int DEFAULT_READ_TIMEOUT = 60000;
  public static final String GET = "GET";
  public static final String GZIP = "gzip";
  public static final String HEADER_CONTENT_ENCODING = "Content-Encoding";
  public static final String HEADER_HOST = "Host";
  public static final String HEADER_X_ONLINE_HOST = "X-Online-Host";
  public static final int HTTP_CLIENT_ERROR = 400;
  public static final int HTTP_CODE_ERROR = 4096;
  public static final int HTTP_CONNECT_ERROR = 1024;
  public static final int HTTP_REDIRECT = 300;
  public static final int HTTP_SERVER_ERROR = 500;
  public static final int HTTP_SUCCESS = 200;
  public static final int HTTP_URL_NOT_AVALIBLE = 2048;
  public static final String POST = "POST";
  public static final char PROTOCOL_HOST_SPLITTER = '/';
  public static final char PROTOCOL_PORT_SPLITTER = ':';
  public static final String PROTOCOL_PREFIX = "https://";
  public static final int PROTOCOL_PREFIX_LENGTH = 8;
  private static final int SO_TIMEOUT = 45000;
  
  public static HttpClient createHttpClient(boolean paramBoolean)
  {
    Object localObject2 = new BasicHttpParams();
    HttpConnectionParams.setStaleCheckingEnabled((HttpParams)localObject2, false);
    HttpConnectionParams.setConnectionTimeout((HttpParams)localObject2, 20000);
    HttpConnectionParams.setTcpNoDelay((HttpParams)localObject2, true);
    HttpConnectionParams.setSoTimeout((HttpParams)localObject2, 45000);
    HttpConnectionParams.setSocketBufferSize((HttpParams)localObject2, 8192);
    HttpProtocolParams.setVersion((HttpParams)localObject2, HttpVersion.HTTP_1_1);
    HttpProtocolParams.setUserAgent((HttpParams)localObject2, "android-qzone");
    Object localObject1 = new SchemeRegistry();
    ((SchemeRegistry)localObject1).register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
    try
    {
      ((SchemeRegistry)localObject1).register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
      label98:
      if (paramBoolean) {
        localObject1 = new ThreadSafeClientConnManager((HttpParams)localObject2, (SchemeRegistry)localObject1);
      } else {
        localObject1 = new SingleClientConnManager((HttpParams)localObject2, (SchemeRegistry)localObject1);
      }
      localObject2 = new DefaultHttpClient((ClientConnectionManager)localObject1, (HttpParams)localObject2);
      ((DefaultHttpClient)localObject2).setRoutePlanner(new DefaultHttpRoutePlanner(((ClientConnectionManager)localObject1).getSchemeRegistry()));
      return localObject2;
    }
    catch (Exception localException)
    {
      break label98;
    }
  }
  
  public static HttpPost createHttpPost(Context paramContext, String paramString, HttpEntity paramHttpEntity, QZoneHttpUtil.RequestOptions paramRequestOptions)
  {
    Object localObject = prepareUrl(paramString);
    paramString = prepareHost((String)localObject);
    localObject = new HttpPost((String)localObject);
    ((HttpPost)localObject).addHeader("Host", paramString);
    ((HttpPost)localObject).addHeader("x-online-host", paramString);
    if ((paramHttpEntity instanceof ByteArrayEntity)) {
      ((HttpPost)localObject).addHeader("Content-Type", "application/octet-stream");
    }
    ((HttpPost)localObject).setEntity(paramHttpEntity);
    prepareRequest(paramContext, (HttpRequest)localObject, paramRequestOptions);
    return localObject;
  }
  
  /* Error */
  public static int download(String paramString, java.io.File paramFile)
  {
    // Byte code:
    //   0: invokestatic 202	cooperation/qzone/util/NetworkState:isWap	()Z
    //   3: istore 4
    //   5: aconst_null
    //   6: astore 9
    //   8: aconst_null
    //   9: astore 10
    //   11: aconst_null
    //   12: astore 11
    //   14: aconst_null
    //   15: astore 5
    //   17: aconst_null
    //   18: astore 12
    //   20: iload 4
    //   22: ifeq +11 -> 33
    //   25: getstatic 208	cooperation/qzone/QZoneHttpUtil$HttpProxy:Default	Lcooperation/qzone/QZoneHttpUtil$HttpProxy;
    //   28: astore 7
    //   30: goto +6 -> 36
    //   33: aconst_null
    //   34: astore 7
    //   36: aload 7
    //   38: ifnull +490 -> 528
    //   41: aload_0
    //   42: invokestatic 212	cooperation/qzone/QZoneHttpUtil:splitUrl	(Ljava/lang/String;)[Ljava/lang/String;
    //   45: astore 8
    //   47: new 214	java/lang/StringBuilder
    //   50: dup
    //   51: invokespecial 215	java/lang/StringBuilder:<init>	()V
    //   54: astore_0
    //   55: aload_0
    //   56: aload 7
    //   58: invokevirtual 219	cooperation/qzone/QZoneHttpUtil$HttpProxy:toString	()Ljava/lang/String;
    //   61: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: pop
    //   65: aload_0
    //   66: aload 8
    //   68: iconst_1
    //   69: aaload
    //   70: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: pop
    //   74: aload_0
    //   75: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: astore_0
    //   79: goto +3 -> 82
    //   82: aload_0
    //   83: invokevirtual 229	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   86: ldc 49
    //   88: invokevirtual 233	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   91: ifeq +6 -> 97
    //   94: goto +10 -> 104
    //   97: ldc 49
    //   99: aload_0
    //   100: invokevirtual 236	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   103: astore_0
    //   104: new 238	java/net/URL
    //   107: dup
    //   108: aload_0
    //   109: invokespecial 239	java/net/URL:<init>	(Ljava/lang/String;)V
    //   112: invokevirtual 243	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   115: checkcast 245	java/net/HttpURLConnection
    //   118: astore_0
    //   119: aload 11
    //   121: astore 5
    //   123: aload_0
    //   124: astore 6
    //   126: aload_0
    //   127: sipush 30000
    //   130: invokevirtual 249	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   133: aload 11
    //   135: astore 5
    //   137: aload_0
    //   138: astore 6
    //   140: aload_0
    //   141: sipush 15000
    //   144: invokevirtual 252	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   147: aload 11
    //   149: astore 5
    //   151: aload_0
    //   152: astore 6
    //   154: aload_0
    //   155: ldc 13
    //   157: invokevirtual 255	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   160: aload 11
    //   162: astore 5
    //   164: aload_0
    //   165: astore 6
    //   167: aload_0
    //   168: iconst_1
    //   169: invokevirtual 259	java/net/HttpURLConnection:setDoInput	(Z)V
    //   172: aload 7
    //   174: ifnull +20 -> 194
    //   177: aload 11
    //   179: astore 5
    //   181: aload_0
    //   182: astore 6
    //   184: aload_0
    //   185: ldc 25
    //   187: aload 8
    //   189: iconst_0
    //   190: aaload
    //   191: invokevirtual 262	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   194: aload 11
    //   196: astore 5
    //   198: aload_0
    //   199: astore 6
    //   201: aload_0
    //   202: invokevirtual 266	java/net/HttpURLConnection:getResponseCode	()I
    //   205: istore_3
    //   206: aload 12
    //   208: astore 7
    //   210: aload 11
    //   212: astore 5
    //   214: aload_0
    //   215: astore 6
    //   217: iload_3
    //   218: invokestatic 270	cooperation/qzone/QZoneHttpUtil:isSuccess	(I)Z
    //   221: ifeq +103 -> 324
    //   224: aload 11
    //   226: astore 5
    //   228: aload_0
    //   229: astore 6
    //   231: new 272	java/io/BufferedOutputStream
    //   234: dup
    //   235: new 274	java/io/FileOutputStream
    //   238: dup
    //   239: aload_1
    //   240: iconst_1
    //   241: invokespecial 277	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   244: invokespecial 280	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   247: astore_1
    //   248: aload_0
    //   249: invokevirtual 284	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   252: astore 5
    //   254: sipush 8192
    //   257: newarray byte
    //   259: astore 6
    //   261: aload 5
    //   263: aload 6
    //   265: iconst_0
    //   266: aload 6
    //   268: arraylength
    //   269: invokevirtual 290	java/io/InputStream:read	([BII)I
    //   272: istore_2
    //   273: iconst_m1
    //   274: iload_2
    //   275: if_icmpeq +14 -> 289
    //   278: aload_1
    //   279: aload 6
    //   281: iconst_0
    //   282: iload_2
    //   283: invokevirtual 294	java/io/BufferedOutputStream:write	([BII)V
    //   286: goto -25 -> 261
    //   289: aload_1
    //   290: invokevirtual 297	java/io/BufferedOutputStream:flush	()V
    //   293: aload_1
    //   294: invokevirtual 300	java/io/BufferedOutputStream:close	()V
    //   297: aload_1
    //   298: astore 7
    //   300: goto +24 -> 324
    //   303: astore 6
    //   305: aload_1
    //   306: astore 5
    //   308: aload 6
    //   310: astore_1
    //   311: goto +184 -> 495
    //   314: astore 7
    //   316: goto +68 -> 384
    //   319: astore 7
    //   321: goto +119 -> 440
    //   324: ldc_w 302
    //   327: invokestatic 308	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   330: checkcast 302	com/tencent/qzonehub/api/IDataUtils
    //   333: aload 7
    //   335: invokeinterface 312 2 0
    //   340: pop
    //   341: iload_3
    //   342: istore_2
    //   343: aload_0
    //   344: ifnull +145 -> 489
    //   347: iload_3
    //   348: istore_2
    //   349: aload_0
    //   350: invokevirtual 315	java/net/HttpURLConnection:disconnect	()V
    //   353: iload_2
    //   354: ireturn
    //   355: astore 7
    //   357: aload 9
    //   359: astore_1
    //   360: goto +24 -> 384
    //   363: astore 7
    //   365: aload 10
    //   367: astore_1
    //   368: goto +72 -> 440
    //   371: astore_1
    //   372: aconst_null
    //   373: astore_0
    //   374: goto +121 -> 495
    //   377: astore 7
    //   379: aconst_null
    //   380: astore_0
    //   381: aload 9
    //   383: astore_1
    //   384: aload_1
    //   385: astore 5
    //   387: aload_0
    //   388: astore 6
    //   390: ldc_w 317
    //   393: iconst_1
    //   394: ldc_w 319
    //   397: aload 7
    //   399: invokestatic 325	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   402: sipush 4096
    //   405: istore_3
    //   406: ldc_w 302
    //   409: invokestatic 308	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   412: checkcast 302	com/tencent/qzonehub/api/IDataUtils
    //   415: aload_1
    //   416: invokeinterface 312 2 0
    //   421: pop
    //   422: iload_3
    //   423: istore_2
    //   424: aload_0
    //   425: ifnull +64 -> 489
    //   428: iload_3
    //   429: istore_2
    //   430: goto -81 -> 349
    //   433: astore 7
    //   435: aconst_null
    //   436: astore_0
    //   437: aload 10
    //   439: astore_1
    //   440: aload_1
    //   441: astore 5
    //   443: aload_0
    //   444: astore 6
    //   446: ldc_w 317
    //   449: iconst_1
    //   450: ldc_w 327
    //   453: aload 7
    //   455: invokestatic 325	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   458: sipush 1024
    //   461: istore_3
    //   462: ldc_w 302
    //   465: invokestatic 308	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   468: checkcast 302	com/tencent/qzonehub/api/IDataUtils
    //   471: aload_1
    //   472: invokeinterface 312 2 0
    //   477: pop
    //   478: iload_3
    //   479: istore_2
    //   480: aload_0
    //   481: ifnull +8 -> 489
    //   484: iload_3
    //   485: istore_2
    //   486: goto -137 -> 349
    //   489: iload_2
    //   490: ireturn
    //   491: astore_1
    //   492: aload 6
    //   494: astore_0
    //   495: ldc_w 302
    //   498: invokestatic 308	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   501: checkcast 302	com/tencent/qzonehub/api/IDataUtils
    //   504: aload 5
    //   506: invokeinterface 312 2 0
    //   511: pop
    //   512: aload_0
    //   513: ifnull +7 -> 520
    //   516: aload_0
    //   517: invokevirtual 315	java/net/HttpURLConnection:disconnect	()V
    //   520: goto +5 -> 525
    //   523: aload_1
    //   524: athrow
    //   525: goto -2 -> 523
    //   528: aconst_null
    //   529: astore 8
    //   531: goto -449 -> 82
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	534	0	paramString	String
    //   0	534	1	paramFile	java.io.File
    //   272	218	2	i	int
    //   205	280	3	j	int
    //   3	18	4	bool	boolean
    //   15	490	5	localObject1	Object
    //   124	156	6	localObject2	Object
    //   303	6	6	localObject3	Object
    //   388	105	6	str	String
    //   28	271	7	localObject4	Object
    //   314	1	7	localException1	Exception
    //   319	15	7	localIOException1	java.io.IOException
    //   355	1	7	localException2	Exception
    //   363	1	7	localIOException2	java.io.IOException
    //   377	21	7	localException3	Exception
    //   433	21	7	localIOException3	java.io.IOException
    //   45	485	8	arrayOfString	String[]
    //   6	376	9	localObject5	Object
    //   9	429	10	localObject6	Object
    //   12	213	11	localObject7	Object
    //   18	189	12	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   248	261	303	finally
    //   261	273	303	finally
    //   278	286	303	finally
    //   289	297	303	finally
    //   248	261	314	java/lang/Exception
    //   261	273	314	java/lang/Exception
    //   278	286	314	java/lang/Exception
    //   289	297	314	java/lang/Exception
    //   248	261	319	java/io/IOException
    //   261	273	319	java/io/IOException
    //   278	286	319	java/io/IOException
    //   289	297	319	java/io/IOException
    //   126	133	355	java/lang/Exception
    //   140	147	355	java/lang/Exception
    //   154	160	355	java/lang/Exception
    //   167	172	355	java/lang/Exception
    //   184	194	355	java/lang/Exception
    //   201	206	355	java/lang/Exception
    //   217	224	355	java/lang/Exception
    //   231	248	355	java/lang/Exception
    //   126	133	363	java/io/IOException
    //   140	147	363	java/io/IOException
    //   154	160	363	java/io/IOException
    //   167	172	363	java/io/IOException
    //   184	194	363	java/io/IOException
    //   201	206	363	java/io/IOException
    //   217	224	363	java/io/IOException
    //   231	248	363	java/io/IOException
    //   41	79	371	finally
    //   82	94	371	finally
    //   97	104	371	finally
    //   104	119	371	finally
    //   41	79	377	java/lang/Exception
    //   82	94	377	java/lang/Exception
    //   97	104	377	java/lang/Exception
    //   104	119	377	java/lang/Exception
    //   41	79	433	java/io/IOException
    //   82	94	433	java/io/IOException
    //   97	104	433	java/io/IOException
    //   104	119	433	java/io/IOException
    //   126	133	491	finally
    //   140	147	491	finally
    //   154	160	491	finally
    //   167	172	491	finally
    //   184	194	491	finally
    //   201	206	491	finally
    //   217	224	491	finally
    //   231	248	491	finally
    //   390	402	491	finally
    //   446	458	491	finally
  }
  
  public static HttpResponse executeHttpPost(Context paramContext, String paramString, HttpEntity paramHttpEntity)
  {
    return executeHttpPost(paramContext, paramString, paramHttpEntity, null);
  }
  
  public static HttpResponse executeHttpPost(Context paramContext, String paramString, HttpEntity paramHttpEntity, QZoneHttpUtil.RequestOptions paramRequestOptions)
  {
    return createHttpClient(false).execute(createHttpPost(paramContext, paramString, paramHttpEntity, paramRequestOptions));
  }
  
  public static boolean isSuccess(int paramInt)
  {
    return (paramInt >= 200) && (paramInt < 299);
  }
  
  private static String prepareHost(String paramString)
  {
    return new URL(paramString).getAuthority();
  }
  
  private static void prepareRequest(Context paramContext, HttpRequest paramHttpRequest, QZoneHttpUtil.RequestOptions paramRequestOptions)
  {
    boolean bool1;
    if (paramRequestOptions != null) {
      bool1 = paramRequestOptions.allowProxy;
    } else {
      bool1 = true;
    }
    boolean bool2;
    if (paramRequestOptions != null) {
      bool2 = paramRequestOptions.apnProxy;
    } else {
      bool2 = false;
    }
    if ((bool1) && (NetworkState.isMobile()))
    {
      paramContext = NetworkUtils.getProxy(paramContext, bool2);
      if (paramContext != null)
      {
        paramContext = (InetSocketAddress)paramContext.address();
        if (paramContext != null)
        {
          paramContext = new HttpHost(paramContext.getHostName(), paramContext.getPort());
          paramHttpRequest.getParams().setParameter("http.route.default-proxy", paramContext);
        }
      }
    }
  }
  
  private static String prepareUrl(String paramString)
  {
    String str = paramString.trim().replace(" ", "");
    int i = str.indexOf('#');
    paramString = str;
    if (i > 0) {
      paramString = str.substring(0, i);
    }
    return paramString;
  }
  
  public static String[] splitUrl(String paramString)
  {
    String[] arrayOfString = new String[2];
    if (paramString != null)
    {
      if (paramString.length() < PROTOCOL_PREFIX_LENGTH) {
        return arrayOfString;
      }
      if (!paramString.toLowerCase().startsWith("https://")) {
        paramString = "https://".concat(paramString);
      }
      int j = paramString.indexOf('/', PROTOCOL_PREFIX_LENGTH);
      int i = j;
      if (j <= PROTOCOL_PREFIX_LENGTH) {
        i = paramString.length();
      }
      arrayOfString[0] = paramString.substring(PROTOCOL_PREFIX_LENGTH, i);
      if (i < paramString.length())
      {
        arrayOfString[1] = paramString.substring(i, paramString.length());
        return arrayOfString;
      }
      arrayOfString[1] = "";
    }
    return arrayOfString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.QZoneHttpUtil
 * JD-Core Version:    0.7.0.1
 */