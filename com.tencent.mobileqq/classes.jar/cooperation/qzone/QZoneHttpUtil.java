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
    //   4: astore 7
    //   6: aconst_null
    //   7: astore 8
    //   9: aconst_null
    //   10: astore 6
    //   12: invokestatic 209	cooperation/qzone/util/NetworkState:isWap	()Z
    //   15: ifeq +233 -> 248
    //   18: getstatic 215	cooperation/qzone/QZoneHttpUtil$HttpProxy:Default	Lcooperation/qzone/QZoneHttpUtil$HttpProxy;
    //   21: astore 4
    //   23: aload 4
    //   25: ifnull +399 -> 424
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
    //   69: ifeq +185 -> 254
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
    //   140: ifeq +135 -> 275
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
    //   187: if_icmpeq +77 -> 264
    //   190: aload_1
    //   191: aload 5
    //   193: iconst_0
    //   194: iload_3
    //   195: invokevirtual 295	java/io/BufferedOutputStream:write	([BII)V
    //   198: goto -25 -> 173
    //   201: astore 5
    //   203: aload_1
    //   204: astore 6
    //   206: aload_0
    //   207: astore_1
    //   208: aload 6
    //   210: astore 4
    //   212: ldc_w 297
    //   215: iconst_1
    //   216: ldc_w 299
    //   219: aload 5
    //   221: invokestatic 305	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   224: sipush 1024
    //   227: istore_3
    //   228: aload 6
    //   230: invokestatic 311	cooperation/qzone/util/DataUtils:closeDataObject	(Ljava/lang/Object;)Z
    //   233: pop
    //   234: iload_3
    //   235: istore_2
    //   236: aload_0
    //   237: ifnull +9 -> 246
    //   240: aload_0
    //   241: invokevirtual 314	java/net/HttpURLConnection:disconnect	()V
    //   244: iload_3
    //   245: istore_2
    //   246: iload_2
    //   247: ireturn
    //   248: aconst_null
    //   249: astore 4
    //   251: goto -228 -> 23
    //   254: ldc 49
    //   256: aload_0
    //   257: invokevirtual 317	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   260: astore_0
    //   261: goto -189 -> 72
    //   264: aload_1
    //   265: invokevirtual 320	java/io/BufferedOutputStream:flush	()V
    //   268: aload_1
    //   269: invokevirtual 323	java/io/BufferedOutputStream:close	()V
    //   272: aload_1
    //   273: astore 4
    //   275: aload 4
    //   277: invokestatic 311	cooperation/qzone/util/DataUtils:closeDataObject	(Ljava/lang/Object;)Z
    //   280: pop
    //   281: aload_0
    //   282: ifnull +140 -> 422
    //   285: aload_0
    //   286: invokevirtual 314	java/net/HttpURLConnection:disconnect	()V
    //   289: iload_2
    //   290: ireturn
    //   291: astore 5
    //   293: aconst_null
    //   294: astore_0
    //   295: aload 7
    //   297: astore 6
    //   299: aload_0
    //   300: astore_1
    //   301: aload 6
    //   303: astore 4
    //   305: ldc_w 297
    //   308: iconst_1
    //   309: ldc_w 325
    //   312: aload 5
    //   314: invokestatic 305	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   317: sipush 4096
    //   320: istore_2
    //   321: aload 6
    //   323: invokestatic 311	cooperation/qzone/util/DataUtils:closeDataObject	(Ljava/lang/Object;)Z
    //   326: pop
    //   327: aload_0
    //   328: ifnull -82 -> 246
    //   331: aload_0
    //   332: invokevirtual 314	java/net/HttpURLConnection:disconnect	()V
    //   335: sipush 4096
    //   338: ireturn
    //   339: astore_0
    //   340: aconst_null
    //   341: astore_1
    //   342: aload 8
    //   344: astore 4
    //   346: aload 4
    //   348: invokestatic 311	cooperation/qzone/util/DataUtils:closeDataObject	(Ljava/lang/Object;)Z
    //   351: pop
    //   352: aload_1
    //   353: ifnull +7 -> 360
    //   356: aload_1
    //   357: invokevirtual 314	java/net/HttpURLConnection:disconnect	()V
    //   360: aload_0
    //   361: athrow
    //   362: astore 4
    //   364: aload_0
    //   365: astore_1
    //   366: aload 4
    //   368: astore_0
    //   369: aload 8
    //   371: astore 4
    //   373: goto -27 -> 346
    //   376: astore 5
    //   378: aload_1
    //   379: astore 4
    //   381: aload_0
    //   382: astore_1
    //   383: aload 5
    //   385: astore_0
    //   386: goto -40 -> 346
    //   389: astore_0
    //   390: goto -44 -> 346
    //   393: astore 5
    //   395: aload 7
    //   397: astore 6
    //   399: goto -100 -> 299
    //   402: astore 5
    //   404: aload_1
    //   405: astore 6
    //   407: goto -108 -> 299
    //   410: astore 5
    //   412: aconst_null
    //   413: astore_0
    //   414: goto -208 -> 206
    //   417: astore 5
    //   419: goto -213 -> 206
    //   422: iload_2
    //   423: ireturn
    //   424: aconst_null
    //   425: astore 5
    //   427: goto -367 -> 60
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	430	0	paramString	String
    //   0	430	1	paramFile	java.io.File
    //   131	292	2	i	int
    //   184	61	3	j	int
    //   21	326	4	localObject1	Object
    //   362	5	4	localObject2	Object
    //   371	9	4	localObject3	Object
    //   32	160	5	localObject4	Object
    //   201	19	5	localIOException1	java.io.IOException
    //   291	22	5	localException1	Exception
    //   376	8	5	localObject5	Object
    //   393	1	5	localException2	Exception
    //   402	1	5	localException3	Exception
    //   410	1	5	localIOException2	java.io.IOException
    //   417	1	5	localIOException3	java.io.IOException
    //   425	1	5	localObject6	Object
    //   10	396	6	localObject7	Object
    //   4	392	7	localObject8	Object
    //   7	363	8	localObject9	Object
    //   1	132	9	localObject10	Object
    // Exception table:
    //   from	to	target	type
    //   160	173	201	java/io/IOException
    //   173	185	201	java/io/IOException
    //   190	198	201	java/io/IOException
    //   264	272	201	java/io/IOException
    //   28	60	291	java/lang/Exception
    //   60	72	291	java/lang/Exception
    //   72	87	291	java/lang/Exception
    //   254	261	291	java/lang/Exception
    //   28	60	339	finally
    //   60	72	339	finally
    //   72	87	339	finally
    //   254	261	339	finally
    //   87	112	362	finally
    //   117	127	362	finally
    //   127	132	362	finally
    //   136	160	362	finally
    //   160	173	376	finally
    //   173	185	376	finally
    //   190	198	376	finally
    //   264	272	376	finally
    //   212	224	389	finally
    //   305	317	389	finally
    //   87	112	393	java/lang/Exception
    //   117	127	393	java/lang/Exception
    //   127	132	393	java/lang/Exception
    //   136	160	393	java/lang/Exception
    //   160	173	402	java/lang/Exception
    //   173	185	402	java/lang/Exception
    //   190	198	402	java/lang/Exception
    //   264	272	402	java/lang/Exception
    //   28	60	410	java/io/IOException
    //   60	72	410	java/io/IOException
    //   72	87	410	java/io/IOException
    //   254	261	410	java/io/IOException
    //   87	112	417	java/io/IOException
    //   117	127	417	java/io/IOException
    //   127	132	417	java/io/IOException
    //   136	160	417	java/io/IOException
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.QZoneHttpUtil
 * JD-Core Version:    0.7.0.1
 */