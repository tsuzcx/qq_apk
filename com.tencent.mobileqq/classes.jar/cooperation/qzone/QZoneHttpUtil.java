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
  public static final int PROTOCOL_PREFIX_LENGTH = "https://".length();
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
      if (paramBoolean) {}
      for (localObject1 = new ThreadSafeClientConnManager((HttpParams)localObject2, (SchemeRegistry)localObject1);; localObject1 = new SingleClientConnManager((HttpParams)localObject2, (SchemeRegistry)localObject1))
      {
        localObject2 = new DefaultHttpClient((ClientConnectionManager)localObject1, (HttpParams)localObject2);
        ((DefaultHttpClient)localObject2).setRoutePlanner(new DefaultHttpRoutePlanner(((ClientConnectionManager)localObject1).getSchemeRegistry()));
        return localObject2;
      }
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
    //   0: aconst_null
    //   1: astore 9
    //   3: aconst_null
    //   4: astore 6
    //   6: aconst_null
    //   7: astore 7
    //   9: aconst_null
    //   10: astore 8
    //   12: invokestatic 209	cooperation/qzone/util/NetworkState:isWap	()Z
    //   15: ifeq +242 -> 257
    //   18: getstatic 215	cooperation/qzone/QZoneHttpUtil$HttpProxy:Default	Lcooperation/qzone/QZoneHttpUtil$HttpProxy;
    //   21: astore 4
    //   23: aload 4
    //   25: ifnull +447 -> 472
    //   28: aload_0
    //   29: invokestatic 219	cooperation/qzone/QZoneHttpUtil:splitUrl	(Ljava/lang/String;)[Ljava/lang/String;
    //   32: astore 5
    //   34: new 221	java/lang/StringBuilder
    //   37: dup
    //   38: invokespecial 222	java/lang/StringBuilder:<init>	()V
    //   41: aload 4
    //   43: invokevirtual 226	cooperation/qzone/QZoneHttpUtil$HttpProxy:toString	()Ljava/lang/String;
    //   46: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: aload 5
    //   51: iconst_1
    //   52: aaload
    //   53: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: invokevirtual 231	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: astore_0
    //   60: aload_0
    //   61: invokevirtual 234	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   64: ldc 49
    //   66: invokevirtual 238	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   69: ifeq +194 -> 263
    //   72: new 240	java/net/URL
    //   75: dup
    //   76: aload_0
    //   77: invokespecial 241	java/net/URL:<init>	(Ljava/lang/String;)V
    //   80: invokevirtual 245	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   83: checkcast 247	java/net/HttpURLConnection
    //   86: astore_0
    //   87: aload_0
    //   88: sipush 30000
    //   91: invokevirtual 251	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   94: aload_0
    //   95: sipush 15000
    //   98: invokevirtual 254	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   101: aload_0
    //   102: ldc 13
    //   104: invokevirtual 257	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   107: aload_0
    //   108: iconst_1
    //   109: invokevirtual 261	java/net/HttpURLConnection:setDoInput	(Z)V
    //   112: aload 4
    //   114: ifnull +13 -> 127
    //   117: aload_0
    //   118: ldc 25
    //   120: aload 5
    //   122: iconst_0
    //   123: aaload
    //   124: invokevirtual 264	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   127: aload_0
    //   128: invokevirtual 267	java/net/HttpURLConnection:getResponseCode	()I
    //   131: istore_2
    //   132: aload 9
    //   134: astore 4
    //   136: iload_2
    //   137: invokestatic 271	cooperation/qzone/QZoneHttpUtil:isSuccess	(I)Z
    //   140: ifeq +144 -> 284
    //   143: new 273	java/io/BufferedOutputStream
    //   146: dup
    //   147: new 275	java/io/FileOutputStream
    //   150: dup
    //   151: aload_1
    //   152: iconst_1
    //   153: invokespecial 278	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   156: invokespecial 281	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   159: astore_1
    //   160: aload_0
    //   161: invokevirtual 285	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   164: astore 4
    //   166: sipush 8192
    //   169: newarray byte
    //   171: astore 5
    //   173: aload 4
    //   175: aload 5
    //   177: iconst_0
    //   178: aload 5
    //   180: arraylength
    //   181: invokevirtual 291	java/io/InputStream:read	([BII)I
    //   184: istore_3
    //   185: iconst_m1
    //   186: iload_3
    //   187: if_icmpeq +86 -> 273
    //   190: aload_1
    //   191: aload 5
    //   193: iconst_0
    //   194: iload_3
    //   195: invokevirtual 295	java/io/BufferedOutputStream:write	([BII)V
    //   198: goto -25 -> 173
    //   201: astore 5
    //   203: aload_1
    //   204: astore 6
    //   206: aload 6
    //   208: astore 4
    //   210: aload_0
    //   211: astore_1
    //   212: ldc_w 297
    //   215: iconst_1
    //   216: ldc_w 299
    //   219: aload 5
    //   221: invokestatic 305	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   224: sipush 1024
    //   227: istore_2
    //   228: ldc_w 307
    //   231: invokestatic 313	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   234: checkcast 307	com/tencent/qzonehub/api/IDataUtils
    //   237: aload 6
    //   239: invokeinterface 317 2 0
    //   244: pop
    //   245: aload_0
    //   246: ifnull +222 -> 468
    //   249: aload_0
    //   250: invokevirtual 320	java/net/HttpURLConnection:disconnect	()V
    //   253: sipush 1024
    //   256: ireturn
    //   257: aconst_null
    //   258: astore 4
    //   260: goto -237 -> 23
    //   263: ldc 49
    //   265: aload_0
    //   266: invokevirtual 323	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   269: astore_0
    //   270: goto -198 -> 72
    //   273: aload_1
    //   274: invokevirtual 326	java/io/BufferedOutputStream:flush	()V
    //   277: aload_1
    //   278: invokevirtual 329	java/io/BufferedOutputStream:close	()V
    //   281: aload_1
    //   282: astore 4
    //   284: ldc_w 307
    //   287: invokestatic 313	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   290: checkcast 307	com/tencent/qzonehub/api/IDataUtils
    //   293: aload 4
    //   295: invokeinterface 317 2 0
    //   300: pop
    //   301: aload_0
    //   302: ifnull +168 -> 470
    //   305: aload_0
    //   306: invokevirtual 320	java/net/HttpURLConnection:disconnect	()V
    //   309: iload_2
    //   310: ireturn
    //   311: astore 5
    //   313: aconst_null
    //   314: astore_0
    //   315: aload 6
    //   317: astore 4
    //   319: aload_0
    //   320: astore_1
    //   321: ldc_w 297
    //   324: iconst_1
    //   325: ldc_w 331
    //   328: aload 5
    //   330: invokestatic 305	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   333: sipush 4096
    //   336: istore_2
    //   337: ldc_w 307
    //   340: invokestatic 313	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   343: checkcast 307	com/tencent/qzonehub/api/IDataUtils
    //   346: aload 6
    //   348: invokeinterface 317 2 0
    //   353: pop
    //   354: aload_0
    //   355: ifnull +113 -> 468
    //   358: aload_0
    //   359: invokevirtual 320	java/net/HttpURLConnection:disconnect	()V
    //   362: sipush 4096
    //   365: ireturn
    //   366: astore_0
    //   367: aconst_null
    //   368: astore_1
    //   369: aload 7
    //   371: astore 4
    //   373: ldc_w 307
    //   376: invokestatic 313	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   379: checkcast 307	com/tencent/qzonehub/api/IDataUtils
    //   382: aload 4
    //   384: invokeinterface 317 2 0
    //   389: pop
    //   390: aload_1
    //   391: ifnull +7 -> 398
    //   394: aload_1
    //   395: invokevirtual 320	java/net/HttpURLConnection:disconnect	()V
    //   398: aload_0
    //   399: athrow
    //   400: astore 4
    //   402: aload_0
    //   403: astore_1
    //   404: aload 4
    //   406: astore_0
    //   407: aload 7
    //   409: astore 4
    //   411: goto -38 -> 373
    //   414: astore 4
    //   416: aload_0
    //   417: astore 5
    //   419: aload 4
    //   421: astore_0
    //   422: aload_1
    //   423: astore 4
    //   425: aload 5
    //   427: astore_1
    //   428: goto -55 -> 373
    //   431: astore_0
    //   432: goto -59 -> 373
    //   435: astore 5
    //   437: goto -122 -> 315
    //   440: astore 5
    //   442: aload_1
    //   443: astore 6
    //   445: goto -130 -> 315
    //   448: astore 5
    //   450: aconst_null
    //   451: astore_0
    //   452: aload 8
    //   454: astore 6
    //   456: goto -250 -> 206
    //   459: astore 5
    //   461: aload 8
    //   463: astore 6
    //   465: goto -259 -> 206
    //   468: iload_2
    //   469: ireturn
    //   470: iload_2
    //   471: ireturn
    //   472: aconst_null
    //   473: astore 5
    //   475: goto -415 -> 60
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	478	0	paramString	String
    //   0	478	1	paramFile	java.io.File
    //   131	340	2	i	int
    //   184	11	3	j	int
    //   21	362	4	localObject1	Object
    //   400	5	4	localObject2	Object
    //   409	1	4	localObject3	Object
    //   414	6	4	localObject4	Object
    //   423	1	4	localFile	java.io.File
    //   32	160	5	localObject5	Object
    //   201	19	5	localIOException1	java.io.IOException
    //   311	18	5	localException1	Exception
    //   417	9	5	str	String
    //   435	1	5	localException2	Exception
    //   440	1	5	localException3	Exception
    //   448	1	5	localIOException2	java.io.IOException
    //   459	1	5	localIOException3	java.io.IOException
    //   473	1	5	localObject6	Object
    //   4	460	6	localObject7	Object
    //   7	401	7	localObject8	Object
    //   10	452	8	localObject9	Object
    //   1	132	9	localObject10	Object
    // Exception table:
    //   from	to	target	type
    //   160	173	201	java/io/IOException
    //   173	185	201	java/io/IOException
    //   190	198	201	java/io/IOException
    //   273	281	201	java/io/IOException
    //   28	60	311	java/lang/Exception
    //   60	72	311	java/lang/Exception
    //   72	87	311	java/lang/Exception
    //   263	270	311	java/lang/Exception
    //   28	60	366	finally
    //   60	72	366	finally
    //   72	87	366	finally
    //   263	270	366	finally
    //   87	112	400	finally
    //   117	127	400	finally
    //   127	132	400	finally
    //   136	160	400	finally
    //   160	173	414	finally
    //   173	185	414	finally
    //   190	198	414	finally
    //   273	281	414	finally
    //   212	224	431	finally
    //   321	333	431	finally
    //   87	112	435	java/lang/Exception
    //   117	127	435	java/lang/Exception
    //   127	132	435	java/lang/Exception
    //   136	160	435	java/lang/Exception
    //   160	173	440	java/lang/Exception
    //   173	185	440	java/lang/Exception
    //   190	198	440	java/lang/Exception
    //   273	281	440	java/lang/Exception
    //   28	60	448	java/io/IOException
    //   60	72	448	java/io/IOException
    //   72	87	448	java/io/IOException
    //   263	270	448	java/io/IOException
    //   87	112	459	java/io/IOException
    //   117	127	459	java/io/IOException
    //   127	132	459	java/io/IOException
    //   136	160	459	java/io/IOException
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
    if (paramRequestOptions != null)
    {
      bool1 = paramRequestOptions.allowProxy;
      if (paramRequestOptions == null) {
        break label90;
      }
    }
    label90:
    for (boolean bool2 = paramRequestOptions.apnProxy;; bool2 = false)
    {
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
      return;
      bool1 = true;
      break;
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
    if ((paramString == null) || (paramString.length() < PROTOCOL_PREFIX_LENGTH)) {
      return arrayOfString;
    }
    if (paramString.toLowerCase().startsWith("https://"))
    {
      int j = paramString.indexOf('/', PROTOCOL_PREFIX_LENGTH);
      int i = j;
      if (j <= PROTOCOL_PREFIX_LENGTH) {
        i = paramString.length();
      }
      arrayOfString[0] = paramString.substring(PROTOCOL_PREFIX_LENGTH, i);
      if (i >= paramString.length()) {
        break label100;
      }
      arrayOfString[1] = paramString.substring(i, paramString.length());
    }
    for (;;)
    {
      return arrayOfString;
      paramString = "https://".concat(paramString);
      break;
      label100:
      arrayOfString[1] = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.QZoneHttpUtil
 * JD-Core Version:    0.7.0.1
 */