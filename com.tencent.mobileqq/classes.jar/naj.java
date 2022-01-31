import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.Proxy;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.utils.http.base.SNIVerifier;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class naj
{
  private static final SNIVerifier jdField_a_of_type_ComTencentComponentNetworkUtilsHttpBaseSNIVerifier = new SNIVerifier();
  private static boolean jdField_a_of_type_Boolean;
  
  public static int a()
  {
    if (!AppNetConnInfo.isNetSupport()) {}
    do
    {
      return 0;
      if (AppNetConnInfo.isWifiConn()) {
        return 1;
      }
    } while (!AppNetConnInfo.isMobileConn());
    switch (AppNetConnInfo.getMobileInfo())
    {
    case -1: 
    default: 
      return -1;
    case 0: 
    case 1: 
      return 2;
    case 2: 
      return 3;
    case 3: 
      return 4;
    }
    return 4;
  }
  
  public static int a(Context paramContext)
  {
    int i = -1;
    if (Build.VERSION.SDK_INT < 11) {
      if (paramContext != null)
      {
        int j = Proxy.getPort(paramContext);
        i = j;
        if (j < 0) {
          i = Proxy.getDefaultPort();
        }
      }
    }
    do
    {
      return i;
      return Proxy.getDefaultPort();
      paramContext = System.getProperty("http.proxyPort");
    } while (b(paramContext));
    try
    {
      i = Integer.parseInt(paramContext);
      return i;
    }
    catch (NumberFormatException paramContext) {}
    return -1;
  }
  
  /* Error */
  public static com.tencent.util.Pair<Integer, String> a(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +28 -> 34
    //   9: ldc 78
    //   11: iconst_2
    //   12: new 80	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   19: ldc 83
    //   21: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_0
    //   25: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: invokestatic 95	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   34: aload_0
    //   35: invokestatic 101	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   38: ifne +17 -> 55
    //   41: aload_1
    //   42: invokestatic 101	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   45: ifne +10 -> 55
    //   48: aload_2
    //   49: invokestatic 101	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   52: ifeq +5 -> 57
    //   55: aconst_null
    //   56: areturn
    //   57: iconst_1
    //   58: istore 4
    //   60: iconst_1
    //   61: istore 5
    //   63: new 103	java/net/URL
    //   66: dup
    //   67: aload_0
    //   68: invokespecial 106	java/net/URL:<init>	(Ljava/lang/String;)V
    //   71: invokevirtual 110	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   74: checkcast 112	java/net/HttpURLConnection
    //   77: astore 7
    //   79: iload 5
    //   81: istore_3
    //   82: aload 7
    //   84: sipush 5000
    //   87: invokevirtual 116	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   90: iload 5
    //   92: istore_3
    //   93: aload 7
    //   95: sipush 30000
    //   98: invokevirtual 119	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   101: iload 5
    //   103: istore_3
    //   104: aload 7
    //   106: ldc 121
    //   108: invokevirtual 124	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   111: iload 5
    //   113: istore_3
    //   114: aload 7
    //   116: ldc 126
    //   118: ldc 128
    //   120: invokevirtual 132	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   123: iload 5
    //   125: istore_3
    //   126: aload 7
    //   128: ldc 134
    //   130: new 80	java/lang/StringBuilder
    //   133: dup
    //   134: ldc 136
    //   136: invokespecial 137	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   139: ldc 139
    //   141: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: getstatic 143	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   147: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: ldc 139
    //   152: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: getstatic 148	android/os/Build:DEVICE	Ljava/lang/String;
    //   158: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: ldc 139
    //   163: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: getstatic 151	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   169: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: ldc 139
    //   174: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: ldc 153
    //   179: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   185: invokevirtual 132	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   188: iload 5
    //   190: istore_3
    //   191: aload 7
    //   193: ldc 155
    //   195: ldc 157
    //   197: invokevirtual 132	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   200: iload 5
    //   202: istore_3
    //   203: aload 7
    //   205: ldc 159
    //   207: ldc 161
    //   209: invokevirtual 132	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   212: iload 5
    //   214: istore_3
    //   215: invokestatic 167	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   218: invokevirtual 171	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   221: iconst_2
    //   222: invokevirtual 177	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   225: checkcast 179	mqq/manager/TicketManager
    //   228: aload_1
    //   229: ldc 161
    //   231: invokeinterface 183 3 0
    //   236: astore_0
    //   237: iload 5
    //   239: istore_3
    //   240: aload_0
    //   241: invokestatic 101	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   244: ifne +127 -> 371
    //   247: iload 5
    //   249: istore_3
    //   250: aload 7
    //   252: ldc 185
    //   254: new 80	java/lang/StringBuilder
    //   257: dup
    //   258: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   261: ldc 187
    //   263: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: aload_1
    //   267: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: ldc 189
    //   272: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: aload_0
    //   276: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   282: invokevirtual 132	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   285: iload 5
    //   287: istore_3
    //   288: aload 7
    //   290: invokevirtual 192	java/net/HttpURLConnection:getResponseCode	()I
    //   293: istore 6
    //   295: iload 6
    //   297: sipush 200
    //   300: if_icmpeq +170 -> 470
    //   303: iload 5
    //   305: istore_3
    //   306: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   309: ifeq +32 -> 341
    //   312: iload 5
    //   314: istore_3
    //   315: ldc 78
    //   317: iconst_2
    //   318: new 80	java/lang/StringBuilder
    //   321: dup
    //   322: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   325: ldc 194
    //   327: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: iload 6
    //   332: invokevirtual 197	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   335: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   338: invokestatic 95	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   341: iload 5
    //   343: istore_3
    //   344: new 199	com/tencent/util/Pair
    //   347: dup
    //   348: iload 6
    //   350: invokestatic 203	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   353: ldc 205
    //   355: invokespecial 208	com/tencent/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   358: astore_0
    //   359: aload 7
    //   361: ifnull +8 -> 369
    //   364: aload 7
    //   366: invokevirtual 211	java/net/HttpURLConnection:disconnect	()V
    //   369: aload_0
    //   370: areturn
    //   371: iload 5
    //   373: istore_3
    //   374: aload 7
    //   376: ldc 185
    //   378: new 80	java/lang/StringBuilder
    //   381: dup
    //   382: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   385: ldc 213
    //   387: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   390: aload_1
    //   391: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   394: ldc 215
    //   396: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   399: aload_2
    //   400: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   403: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   406: invokevirtual 132	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   409: goto -124 -> 285
    //   412: astore_1
    //   413: aload 7
    //   415: astore_0
    //   416: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   419: ifeq +28 -> 447
    //   422: ldc 78
    //   424: iconst_2
    //   425: new 80	java/lang/StringBuilder
    //   428: dup
    //   429: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   432: ldc 217
    //   434: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   437: aload_1
    //   438: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   441: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   444: invokestatic 223	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   447: aload_0
    //   448: ifnull +270 -> 718
    //   451: aload_0
    //   452: invokevirtual 211	java/net/HttpURLConnection:disconnect	()V
    //   455: aconst_null
    //   456: astore_0
    //   457: new 199	com/tencent/util/Pair
    //   460: dup
    //   461: iload_3
    //   462: invokestatic 203	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   465: aload_0
    //   466: invokespecial 208	com/tencent/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   469: areturn
    //   470: iload 5
    //   472: istore_3
    //   473: new 80	java/lang/StringBuilder
    //   476: dup
    //   477: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   480: astore_0
    //   481: iload 5
    //   483: istore_3
    //   484: new 225	java/io/BufferedReader
    //   487: dup
    //   488: new 227	java/io/InputStreamReader
    //   491: dup
    //   492: aload 7
    //   494: invokevirtual 231	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   497: invokespecial 234	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   500: invokespecial 237	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   503: astore_1
    //   504: iload 5
    //   506: istore_3
    //   507: aload_1
    //   508: invokevirtual 240	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   511: astore_2
    //   512: aload_2
    //   513: ifnull +34 -> 547
    //   516: iload 5
    //   518: istore_3
    //   519: aload_0
    //   520: aload_2
    //   521: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   524: ldc 242
    //   526: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   529: pop
    //   530: goto -26 -> 504
    //   533: astore_1
    //   534: aload 7
    //   536: astore_0
    //   537: aload_0
    //   538: ifnull +7 -> 545
    //   541: aload_0
    //   542: invokevirtual 211	java/net/HttpURLConnection:disconnect	()V
    //   545: aload_1
    //   546: athrow
    //   547: iload 5
    //   549: istore_3
    //   550: aload_1
    //   551: invokevirtual 245	java/io/BufferedReader:close	()V
    //   554: iload 5
    //   556: istore_3
    //   557: aload_0
    //   558: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   561: astore_0
    //   562: iload 5
    //   564: istore_3
    //   565: aload_0
    //   566: invokestatic 101	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   569: ifne +122 -> 691
    //   572: iload 5
    //   574: istore_3
    //   575: new 247	org/json/JSONObject
    //   578: dup
    //   579: aload_0
    //   580: invokespecial 248	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   583: astore_0
    //   584: iload 5
    //   586: istore_3
    //   587: aload_0
    //   588: ldc 250
    //   590: invokevirtual 253	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   593: istore 5
    //   595: iload 5
    //   597: ifne +47 -> 644
    //   600: iload 5
    //   602: istore_3
    //   603: aload_0
    //   604: ldc 255
    //   606: invokevirtual 258	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   609: ifeq +35 -> 644
    //   612: iload 5
    //   614: istore_3
    //   615: aload_0
    //   616: ldc 255
    //   618: invokevirtual 262	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   621: ldc_w 264
    //   624: invokevirtual 267	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   627: astore_0
    //   628: iload 5
    //   630: istore_3
    //   631: aload 7
    //   633: ifnull +90 -> 723
    //   636: aload 7
    //   638: invokevirtual 211	java/net/HttpURLConnection:disconnect	()V
    //   641: goto -184 -> 457
    //   644: iload 5
    //   646: istore_3
    //   647: iload 5
    //   649: istore 4
    //   651: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   654: ifeq +37 -> 691
    //   657: iload 5
    //   659: istore_3
    //   660: ldc 78
    //   662: iconst_2
    //   663: new 80	java/lang/StringBuilder
    //   666: dup
    //   667: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   670: ldc_w 269
    //   673: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   676: iload 5
    //   678: invokevirtual 197	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   681: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   684: invokestatic 95	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   687: iload 5
    //   689: istore 4
    //   691: iload 4
    //   693: istore_3
    //   694: aload 8
    //   696: astore_0
    //   697: goto -66 -> 631
    //   700: astore_1
    //   701: aconst_null
    //   702: astore_0
    //   703: goto -166 -> 537
    //   706: astore_1
    //   707: goto -170 -> 537
    //   710: astore_1
    //   711: iconst_1
    //   712: istore_3
    //   713: aconst_null
    //   714: astore_0
    //   715: goto -299 -> 416
    //   718: aconst_null
    //   719: astore_0
    //   720: goto -263 -> 457
    //   723: goto -266 -> 457
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	726	0	paramString1	String
    //   0	726	1	paramString2	String
    //   0	726	2	paramString3	String
    //   81	632	3	i	int
    //   58	634	4	j	int
    //   61	627	5	k	int
    //   293	56	6	m	int
    //   77	560	7	localHttpURLConnection	java.net.HttpURLConnection
    //   1	694	8	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   82	90	412	java/lang/Exception
    //   93	101	412	java/lang/Exception
    //   104	111	412	java/lang/Exception
    //   114	123	412	java/lang/Exception
    //   126	188	412	java/lang/Exception
    //   191	200	412	java/lang/Exception
    //   203	212	412	java/lang/Exception
    //   215	237	412	java/lang/Exception
    //   240	247	412	java/lang/Exception
    //   250	285	412	java/lang/Exception
    //   288	295	412	java/lang/Exception
    //   306	312	412	java/lang/Exception
    //   315	341	412	java/lang/Exception
    //   344	359	412	java/lang/Exception
    //   374	409	412	java/lang/Exception
    //   473	481	412	java/lang/Exception
    //   484	504	412	java/lang/Exception
    //   507	512	412	java/lang/Exception
    //   519	530	412	java/lang/Exception
    //   550	554	412	java/lang/Exception
    //   557	562	412	java/lang/Exception
    //   565	572	412	java/lang/Exception
    //   575	584	412	java/lang/Exception
    //   587	595	412	java/lang/Exception
    //   603	612	412	java/lang/Exception
    //   615	628	412	java/lang/Exception
    //   651	657	412	java/lang/Exception
    //   660	687	412	java/lang/Exception
    //   82	90	533	finally
    //   93	101	533	finally
    //   104	111	533	finally
    //   114	123	533	finally
    //   126	188	533	finally
    //   191	200	533	finally
    //   203	212	533	finally
    //   215	237	533	finally
    //   240	247	533	finally
    //   250	285	533	finally
    //   288	295	533	finally
    //   306	312	533	finally
    //   315	341	533	finally
    //   344	359	533	finally
    //   374	409	533	finally
    //   473	481	533	finally
    //   484	504	533	finally
    //   507	512	533	finally
    //   519	530	533	finally
    //   550	554	533	finally
    //   557	562	533	finally
    //   565	572	533	finally
    //   575	584	533	finally
    //   587	595	533	finally
    //   603	612	533	finally
    //   615	628	533	finally
    //   651	657	533	finally
    //   660	687	533	finally
    //   63	79	700	finally
    //   416	447	706	finally
    //   63	79	710	java/lang/Exception
  }
  
  /* Error */
  public static ByteArrayOutputStream a(HttpResponse paramHttpResponse)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokeinterface 280 1 0
    //   6: astore 5
    //   8: aconst_null
    //   9: astore_2
    //   10: aconst_null
    //   11: astore 4
    //   13: aconst_null
    //   14: astore_3
    //   15: aload 5
    //   17: invokeinterface 285 1 0
    //   22: astore 5
    //   24: aload 5
    //   26: astore_3
    //   27: aload 5
    //   29: astore_2
    //   30: aload 5
    //   32: astore 4
    //   34: new 287	java/io/ByteArrayOutputStream
    //   37: dup
    //   38: invokespecial 288	java/io/ByteArrayOutputStream:<init>	()V
    //   41: astore 6
    //   43: aload 5
    //   45: astore_3
    //   46: aload 5
    //   48: astore_2
    //   49: aload 5
    //   51: astore 4
    //   53: aload_0
    //   54: ldc_w 290
    //   57: invokeinterface 294 2 0
    //   62: astore 7
    //   64: aload 5
    //   66: astore_0
    //   67: aload 7
    //   69: ifnull +55 -> 124
    //   72: aload 5
    //   74: astore_0
    //   75: aload 5
    //   77: astore_3
    //   78: aload 5
    //   80: astore_2
    //   81: aload 5
    //   83: astore 4
    //   85: aload 7
    //   87: invokeinterface 299 1 0
    //   92: invokevirtual 304	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   95: ldc_w 306
    //   98: invokevirtual 309	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   101: ifeq +23 -> 124
    //   104: aload 5
    //   106: astore_3
    //   107: aload 5
    //   109: astore_2
    //   110: aload 5
    //   112: astore 4
    //   114: new 311	java/util/zip/GZIPInputStream
    //   117: dup
    //   118: aload 5
    //   120: invokespecial 312	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   123: astore_0
    //   124: aload_0
    //   125: astore_3
    //   126: aload_0
    //   127: astore_2
    //   128: aload_0
    //   129: astore 4
    //   131: sipush 512
    //   134: newarray byte
    //   136: astore 5
    //   138: aload_0
    //   139: astore_3
    //   140: aload_0
    //   141: astore_2
    //   142: aload_0
    //   143: astore 4
    //   145: aload_0
    //   146: aload 5
    //   148: invokevirtual 318	java/io/InputStream:read	([B)I
    //   151: istore_1
    //   152: iload_1
    //   153: iconst_m1
    //   154: if_icmpeq +38 -> 192
    //   157: aload_0
    //   158: astore_3
    //   159: aload_0
    //   160: astore_2
    //   161: aload_0
    //   162: astore 4
    //   164: aload 6
    //   166: aload 5
    //   168: iconst_0
    //   169: iload_1
    //   170: invokevirtual 322	java/io/ByteArrayOutputStream:write	([BII)V
    //   173: goto -35 -> 138
    //   176: astore_0
    //   177: aload_3
    //   178: astore_2
    //   179: aload_0
    //   180: athrow
    //   181: astore_0
    //   182: aload_2
    //   183: ifnull +7 -> 190
    //   186: aload_2
    //   187: invokevirtual 323	java/io/InputStream:close	()V
    //   190: aload_0
    //   191: athrow
    //   192: aload_0
    //   193: ifnull +7 -> 200
    //   196: aload_0
    //   197: invokevirtual 323	java/io/InputStream:close	()V
    //   200: aload 6
    //   202: areturn
    //   203: astore_0
    //   204: aload 4
    //   206: astore_2
    //   207: new 274	java/io/IOException
    //   210: dup
    //   211: invokespecial 324	java/io/IOException:<init>	()V
    //   214: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	215	0	paramHttpResponse	HttpResponse
    //   151	19	1	i	int
    //   9	198	2	localObject1	Object
    //   14	164	3	localObject2	Object
    //   11	194	4	localObject3	Object
    //   6	161	5	localObject4	Object
    //   41	160	6	localByteArrayOutputStream	ByteArrayOutputStream
    //   62	24	7	localHeader	org.apache.http.Header
    // Exception table:
    //   from	to	target	type
    //   15	24	176	java/io/IOException
    //   34	43	176	java/io/IOException
    //   53	64	176	java/io/IOException
    //   85	104	176	java/io/IOException
    //   114	124	176	java/io/IOException
    //   131	138	176	java/io/IOException
    //   145	152	176	java/io/IOException
    //   164	173	176	java/io/IOException
    //   15	24	181	finally
    //   34	43	181	finally
    //   53	64	181	finally
    //   85	104	181	finally
    //   114	124	181	finally
    //   131	138	181	finally
    //   145	152	181	finally
    //   164	173	181	finally
    //   179	181	181	finally
    //   207	215	181	finally
    //   15	24	203	java/lang/Exception
    //   34	43	203	java/lang/Exception
    //   53	64	203	java/lang/Exception
    //   85	104	203	java/lang/Exception
    //   114	124	203	java/lang/Exception
    //   131	138	203	java/lang/Exception
    //   145	152	203	java/lang/Exception
    //   164	173	203	java/lang/Exception
  }
  
  public static String a()
  {
    switch ()
    {
    default: 
      return null;
    case -1: 
      return "UNKNOWN";
    case 0: 
      return "NONE";
    case 1: 
      return "WIFI";
    case 2: 
      return "2G";
    case 3: 
      return "3G";
    case 4: 
      return "4G";
    }
    return "CABLE";
  }
  
  public static String a(Context paramContext)
  {
    if (Build.VERSION.SDK_INT < 11)
    {
      if (paramContext != null)
      {
        String str = Proxy.getHost(paramContext);
        paramContext = str;
        if (b(str)) {
          paramContext = Proxy.getDefaultHost();
        }
        return paramContext;
      }
      return Proxy.getDefaultHost();
    }
    return System.getProperty("http.proxyHost");
  }
  
  protected static final String a(Context paramContext, String paramString1, String paramString2, int paramInt, JSONArray paramJSONArray)
  {
    Bundle localBundle = new Bundle();
    String str = ((TicketManager)BaseApplicationImpl.getApplication().getRuntime().getManager(2)).getPskey(paramString1, "openmobile.qq.com");
    if (!TextUtils.isEmpty(str)) {
      localBundle.putString("cookie", "p_uin=" + paramString1 + ";p_skey=" + str);
    }
    for (;;)
    {
      localBundle.putString("Referer", "http://openmobile.qq.com/");
      paramString1 = new Bundle();
      paramString1.putString("type", String.valueOf(paramInt));
      paramString1.putString("value", paramJSONArray.toString());
      paramString1.putString("mType", "qb_share");
      try
      {
        paramContext = a(paramContext, "http://openmobile.qq.com/api/url_change", "POST", paramString1, localBundle);
        return paramContext;
      }
      catch (IOException paramContext)
      {
        QLog.d("zivonchen", 4, paramContext.getMessage());
      }
      localBundle.putString("cookie", "uin=" + paramString1 + ";skey=" + paramString2);
    }
    return null;
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2, Bundle paramBundle1, Bundle paramBundle2)
  {
    if (paramBundle1 == null) {
      paramBundle1 = new Bundle();
    }
    for (;;)
    {
      String str2 = Uri.parse(paramString1).getHost();
      try
      {
        HttpResponse localHttpResponse = a(paramContext, paramString1, null, paramString2, paramBundle1, paramBundle2);
        paramContext = localHttpResponse;
      }
      catch (IOException localIOException)
      {
        while (str2.equals(wij.c))
        {
          str1 = wij.a(paramContext, str2);
          if (str1 == null) {
            break label186;
          }
          paramString1 = paramString1.replace(str2, str1);
          QLog.d("QRHttpUtil", 2, "ClientProtocolException reopen: " + paramString1);
          paramContext = a(paramContext, paramString1, str2, paramString2, paramBundle1, paramBundle2);
        }
        throw str1;
      }
      if (paramContext == null) {
        throw new IOException("Http no response.");
      }
      label186:
      for (;;)
      {
        String str1;
        int i = paramContext.getStatusLine().getStatusCode();
        if (i == 200) {
          return a(paramContext);
        }
        throw new IOException("Http statusCode:" + i);
      }
    }
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2, Bundle paramBundle1, Bundle paramBundle2, String paramString3)
  {
    if (paramBundle1 == null) {
      paramBundle1 = new Bundle();
    }
    for (;;)
    {
      String str = Uri.parse(paramString1).getHost();
      for (;;)
      {
        try
        {
          if (!TextUtils.isEmpty(paramString3)) {
            continue;
          }
          paramString3 = a(paramContext, paramString1, str, paramString2, paramBundle1, paramBundle2);
          paramContext = paramString3;
        }
        catch (IOException paramString3)
        {
          if (!str.equals(wij.c)) {
            continue;
          }
          paramString3 = wij.a(paramContext, str);
          if (paramString3 == null) {
            break label265;
          }
          paramString1 = paramString1.replace(str, paramString3);
          QLog.d("QRHttpUtil", 2, "ClientProtocolException reopen: " + paramString1);
          paramContext = a(paramContext, paramString1, str, paramString2, paramBundle1, paramBundle2);
          continue;
          throw new IOException("0");
        }
        catch (OutOfMemoryError paramContext)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("HttpUtil", 2, "openRequest fail OutOfMemoryError");
          paramContext = null;
          continue;
          int i = paramContext.getStatusLine().getStatusCode();
          if (i != 200) {
            continue;
          }
          try
          {
            paramContext = a(paramContext);
            return paramContext;
          }
          catch (OutOfMemoryError paramContext)
          {
            throw new IOException("-1");
          }
          throw new IOException("" + i);
        }
        if (paramContext != null) {
          continue;
        }
        throw new IOException("0");
        paramString3 = a(paramContext, paramString1, str, paramString2, paramBundle1, paramBundle2, 15000, 30000, paramString3);
        paramContext = paramString3;
      }
      label265:
      for (;;) {}
    }
  }
  
  public static String a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramBundle.keySet().iterator();
    int i = 1;
    while (localIterator.hasNext())
    {
      Object localObject1 = (String)localIterator.next();
      Object localObject2 = paramBundle.get((String)localObject1);
      if (((localObject2 instanceof String)) || ((localObject2 instanceof String[]))) {
        if ((localObject2 instanceof String[]))
        {
          int j;
          if (i != 0)
          {
            i = 0;
            localStringBuilder.append(URLEncoder.encode((String)localObject1) + "=");
            localObject1 = (String[])paramBundle.getStringArray((String)localObject1);
            j = 0;
            label130:
            if (j >= localObject1.length) {
              break label205;
            }
            if (j != 0) {
              break label171;
            }
            localStringBuilder.append(URLEncoder.encode(localObject1[j]));
          }
          for (;;)
          {
            j += 1;
            break label130;
            localStringBuilder.append("&");
            break;
            label171:
            localStringBuilder.append(URLEncoder.encode("," + localObject1[j]));
          }
        }
        else
        {
          label205:
          if (i != 0) {
            i = 0;
          }
          for (;;)
          {
            localStringBuilder.append(URLEncoder.encode((String)localObject1) + "=" + URLEncoder.encode(paramBundle.getString((String)localObject1)));
            break;
            localStringBuilder.append("&");
          }
        }
      }
    }
    return localStringBuilder.toString();
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    return paramString.replace("&", "&amp;").replace("'", "&apos;").replace("\"", "&quot;").replace(" ", "&nbsp;").replace("<", "&lt;").replace(">", "&gt;");
  }
  
  /* Error */
  public static final String a(String paramString1, String paramString2, String paramString3, java.util.Map<String, String> paramMap1, java.util.Map<String, String> paramMap2, java.util.Map<String, String> paramMap3)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 101	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +17 -> 21
    //   7: aload_2
    //   8: invokestatic 101	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11: ifne +10 -> 21
    //   14: aload_0
    //   15: invokestatic 101	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   18: ifeq +7 -> 25
    //   21: aconst_null
    //   22: astore_0
    //   23: aload_0
    //   24: areturn
    //   25: new 103	java/net/URL
    //   28: dup
    //   29: aload_0
    //   30: invokespecial 106	java/net/URL:<init>	(Ljava/lang/String;)V
    //   33: invokevirtual 110	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   36: checkcast 112	java/net/HttpURLConnection
    //   39: astore 7
    //   41: aload 7
    //   43: sipush 5000
    //   46: invokevirtual 116	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   49: aload 7
    //   51: sipush 30000
    //   54: invokevirtual 119	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   57: aload 7
    //   59: iconst_1
    //   60: invokevirtual 519	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   63: aload 7
    //   65: iconst_1
    //   66: invokevirtual 522	java/net/HttpURLConnection:setDoInput	(Z)V
    //   69: aload 7
    //   71: iconst_0
    //   72: invokevirtual 525	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   75: aload 7
    //   77: ldc_w 380
    //   80: invokevirtual 124	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   83: aload 7
    //   85: ldc 126
    //   87: ldc 128
    //   89: invokevirtual 132	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   92: aload 7
    //   94: ldc 134
    //   96: new 80	java/lang/StringBuilder
    //   99: dup
    //   100: ldc 136
    //   102: invokespecial 137	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   105: ldc 139
    //   107: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: getstatic 143	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   113: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: ldc 139
    //   118: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: getstatic 148	android/os/Build:DEVICE	Ljava/lang/String;
    //   124: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: ldc 139
    //   129: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: getstatic 151	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   135: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: ldc 139
    //   140: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: ldc 153
    //   145: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   151: invokevirtual 132	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   154: aload 7
    //   156: ldc_w 527
    //   159: new 80	java/lang/StringBuilder
    //   162: dup
    //   163: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   166: ldc_w 529
    //   169: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: ldc_w 531
    //   175: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   181: invokevirtual 132	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   184: aload 5
    //   186: astore 8
    //   188: aload 5
    //   190: ifnonnull +12 -> 202
    //   193: new 533	java/util/HashMap
    //   196: dup
    //   197: invokespecial 534	java/util/HashMap:<init>	()V
    //   200: astore 8
    //   202: aload_0
    //   203: ldc_w 536
    //   206: invokevirtual 539	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   209: ifeq +73 -> 282
    //   212: invokestatic 167	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   215: invokevirtual 171	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   218: iconst_2
    //   219: invokevirtual 177	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   222: checkcast 179	mqq/manager/TicketManager
    //   225: aload_1
    //   226: ldc 161
    //   228: invokeinterface 183 3 0
    //   233: astore 5
    //   235: aload 5
    //   237: invokestatic 101	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   240: ifne +42 -> 282
    //   243: aload 8
    //   245: ldc 185
    //   247: new 80	java/lang/StringBuilder
    //   250: dup
    //   251: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   254: ldc 187
    //   256: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: aload_1
    //   260: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: ldc 189
    //   265: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: aload 5
    //   270: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   276: invokeinterface 545 3 0
    //   281: pop
    //   282: aload 8
    //   284: ldc 185
    //   286: invokeinterface 548 2 0
    //   291: ifne +41 -> 332
    //   294: aload 8
    //   296: ldc 185
    //   298: new 80	java/lang/StringBuilder
    //   301: dup
    //   302: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   305: ldc 213
    //   307: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: aload_1
    //   311: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: ldc 215
    //   316: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: aload_2
    //   320: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   326: invokeinterface 545 3 0
    //   331: pop
    //   332: aload 8
    //   334: invokeinterface 551 1 0
    //   339: invokeinterface 461 1 0
    //   344: astore_2
    //   345: aload_2
    //   346: invokeinterface 466 1 0
    //   351: ifeq +128 -> 479
    //   354: aload_2
    //   355: invokeinterface 470 1 0
    //   360: checkcast 553	java/util/Map$Entry
    //   363: astore_1
    //   364: aload 7
    //   366: aload_1
    //   367: invokeinterface 556 1 0
    //   372: checkcast 301	java/lang/String
    //   375: aload_1
    //   376: invokeinterface 558 1 0
    //   381: checkcast 301	java/lang/String
    //   384: invokevirtual 132	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   387: goto -42 -> 345
    //   390: astore_3
    //   391: aload 7
    //   393: astore_2
    //   394: aconst_null
    //   395: astore_1
    //   396: aload_2
    //   397: astore 4
    //   399: ldc_w 446
    //   402: iconst_1
    //   403: new 80	java/lang/StringBuilder
    //   406: dup
    //   407: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   410: ldc_w 560
    //   413: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   416: aload_0
    //   417: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   420: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   423: aload_3
    //   424: invokestatic 563	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   427: aload_1
    //   428: astore_0
    //   429: aload_2
    //   430: ifnull -407 -> 23
    //   433: aload_2
    //   434: invokevirtual 192	java/net/HttpURLConnection:getResponseCode	()I
    //   437: istore 6
    //   439: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   442: ifeq +31 -> 473
    //   445: ldc_w 446
    //   448: iconst_2
    //   449: new 80	java/lang/StringBuilder
    //   452: dup
    //   453: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   456: ldc_w 565
    //   459: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   462: iload 6
    //   464: invokevirtual 197	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   467: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   470: invokestatic 95	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   473: aload_2
    //   474: invokevirtual 211	java/net/HttpURLConnection:disconnect	()V
    //   477: aload_1
    //   478: areturn
    //   479: new 567	java/io/DataOutputStream
    //   482: dup
    //   483: aload 7
    //   485: invokevirtual 571	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   488: invokespecial 574	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   491: astore_2
    //   492: aload_3
    //   493: ifnull +210 -> 703
    //   496: new 576	java/lang/StringBuffer
    //   499: dup
    //   500: invokespecial 577	java/lang/StringBuffer:<init>	()V
    //   503: astore_1
    //   504: aload_3
    //   505: invokeinterface 551 1 0
    //   510: invokeinterface 461 1 0
    //   515: astore 5
    //   517: aload 5
    //   519: invokeinterface 466 1 0
    //   524: ifeq +168 -> 692
    //   527: aload 5
    //   529: invokeinterface 470 1 0
    //   534: checkcast 553	java/util/Map$Entry
    //   537: astore 8
    //   539: aload 8
    //   541: invokeinterface 556 1 0
    //   546: checkcast 301	java/lang/String
    //   549: astore_3
    //   550: aload 8
    //   552: invokeinterface 558 1 0
    //   557: checkcast 301	java/lang/String
    //   560: astore 8
    //   562: aload 8
    //   564: ifnull -47 -> 517
    //   567: aload_1
    //   568: ldc_w 579
    //   571: invokevirtual 582	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   574: ldc_w 584
    //   577: invokevirtual 582	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   580: ldc_w 531
    //   583: invokevirtual 582	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   586: ldc_w 579
    //   589: invokevirtual 582	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   592: pop
    //   593: aload_1
    //   594: new 80	java/lang/StringBuilder
    //   597: dup
    //   598: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   601: ldc_w 586
    //   604: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   607: aload_3
    //   608: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   611: ldc_w 588
    //   614: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   617: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   620: invokevirtual 582	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   623: pop
    //   624: aload_1
    //   625: aload 8
    //   627: invokevirtual 582	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   630: pop
    //   631: goto -114 -> 517
    //   634: astore_0
    //   635: aload 7
    //   637: astore 4
    //   639: aload 4
    //   641: ifnull +49 -> 690
    //   644: aload 4
    //   646: invokevirtual 192	java/net/HttpURLConnection:getResponseCode	()I
    //   649: istore 6
    //   651: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   654: ifeq +31 -> 685
    //   657: ldc_w 446
    //   660: iconst_2
    //   661: new 80	java/lang/StringBuilder
    //   664: dup
    //   665: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   668: ldc_w 565
    //   671: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   674: iload 6
    //   676: invokevirtual 197	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   679: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   682: invokestatic 95	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   685: aload 4
    //   687: invokevirtual 211	java/net/HttpURLConnection:disconnect	()V
    //   690: aload_0
    //   691: athrow
    //   692: aload_2
    //   693: aload_1
    //   694: invokevirtual 589	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   697: invokevirtual 593	java/lang/String:getBytes	()[B
    //   700: invokevirtual 598	java/io/OutputStream:write	([B)V
    //   703: aload 4
    //   705: ifnull +413 -> 1118
    //   708: aload 4
    //   710: invokeinterface 551 1 0
    //   715: invokeinterface 461 1 0
    //   720: astore_3
    //   721: aload_3
    //   722: invokeinterface 466 1 0
    //   727: ifeq +391 -> 1118
    //   730: aload_3
    //   731: invokeinterface 470 1 0
    //   736: checkcast 553	java/util/Map$Entry
    //   739: astore_1
    //   740: aload_1
    //   741: invokeinterface 556 1 0
    //   746: checkcast 301	java/lang/String
    //   749: astore 5
    //   751: aload_1
    //   752: invokeinterface 558 1 0
    //   757: checkcast 301	java/lang/String
    //   760: astore_1
    //   761: aload_1
    //   762: ifnull -41 -> 721
    //   765: new 600	java/io/File
    //   768: dup
    //   769: aload_1
    //   770: invokespecial 601	java/io/File:<init>	(Ljava/lang/String;)V
    //   773: astore 4
    //   775: aload 4
    //   777: invokevirtual 604	java/io/File:getName	()Ljava/lang/String;
    //   780: astore 8
    //   782: aload 8
    //   784: ldc_w 606
    //   787: invokevirtual 609	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   790: ifeq +3 -> 793
    //   793: ldc_w 611
    //   796: astore_1
    //   797: ldc_w 611
    //   800: ifnull +551 -> 1351
    //   803: ldc_w 611
    //   806: ldc 205
    //   808: invokevirtual 411	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   811: ifeq +6 -> 817
    //   814: goto +537 -> 1351
    //   817: new 576	java/lang/StringBuffer
    //   820: dup
    //   821: invokespecial 577	java/lang/StringBuffer:<init>	()V
    //   824: astore 9
    //   826: aload 9
    //   828: ldc_w 579
    //   831: invokevirtual 582	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   834: ldc_w 584
    //   837: invokevirtual 582	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   840: ldc_w 531
    //   843: invokevirtual 582	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   846: ldc_w 579
    //   849: invokevirtual 582	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   852: pop
    //   853: aload 9
    //   855: new 80	java/lang/StringBuilder
    //   858: dup
    //   859: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   862: ldc_w 586
    //   865: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   868: aload 5
    //   870: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   873: ldc_w 613
    //   876: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   879: aload 8
    //   881: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   884: ldc_w 615
    //   887: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   890: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   893: invokevirtual 582	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   896: pop
    //   897: aload 9
    //   899: new 80	java/lang/StringBuilder
    //   902: dup
    //   903: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   906: ldc_w 617
    //   909: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   912: aload_1
    //   913: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   916: ldc_w 619
    //   919: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   922: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   925: invokevirtual 582	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   928: pop
    //   929: aload_2
    //   930: aload 9
    //   932: invokevirtual 589	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   935: invokevirtual 593	java/lang/String:getBytes	()[B
    //   938: invokevirtual 598	java/io/OutputStream:write	([B)V
    //   941: new 621	java/io/BufferedInputStream
    //   944: dup
    //   945: new 621	java/io/BufferedInputStream
    //   948: dup
    //   949: new 623	java/io/FileInputStream
    //   952: dup
    //   953: aload 4
    //   955: invokespecial 626	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   958: invokespecial 627	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   961: invokespecial 627	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   964: astore 5
    //   966: sipush 3072
    //   969: newarray byte
    //   971: astore_1
    //   972: aload 5
    //   974: aload_1
    //   975: invokevirtual 628	java/io/BufferedInputStream:read	([B)I
    //   978: istore 6
    //   980: iload 6
    //   982: iconst_m1
    //   983: if_icmpeq +104 -> 1087
    //   986: aload_2
    //   987: aload_1
    //   988: iconst_0
    //   989: iload 6
    //   991: invokevirtual 629	java/io/OutputStream:write	([BII)V
    //   994: goto -22 -> 972
    //   997: astore_1
    //   998: ldc_w 446
    //   1001: iconst_1
    //   1002: iconst_4
    //   1003: anewarray 4	java/lang/Object
    //   1006: dup
    //   1007: iconst_0
    //   1008: ldc_w 631
    //   1011: aastore
    //   1012: dup
    //   1013: iconst_1
    //   1014: aload 4
    //   1016: invokevirtual 635	java/io/File:length	()J
    //   1019: invokestatic 640	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1022: aastore
    //   1023: dup
    //   1024: iconst_2
    //   1025: ldc_w 642
    //   1028: aastore
    //   1029: dup
    //   1030: iconst_3
    //   1031: aload 4
    //   1033: invokevirtual 645	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1036: aastore
    //   1037: invokestatic 648	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   1040: aload_2
    //   1041: invokevirtual 651	java/io/OutputStream:flush	()V
    //   1044: aload_2
    //   1045: invokevirtual 652	java/io/OutputStream:close	()V
    //   1048: aload 7
    //   1050: invokevirtual 211	java/net/HttpURLConnection:disconnect	()V
    //   1053: aconst_null
    //   1054: astore 4
    //   1056: aconst_null
    //   1057: astore_2
    //   1058: aconst_null
    //   1059: astore_1
    //   1060: aload 5
    //   1062: invokevirtual 653	java/io/BufferedInputStream:close	()V
    //   1065: aload_1
    //   1066: astore_0
    //   1067: iconst_0
    //   1068: ifeq -1045 -> 23
    //   1071: new 655	java/lang/NullPointerException
    //   1074: dup
    //   1075: invokespecial 656	java/lang/NullPointerException:<init>	()V
    //   1078: athrow
    //   1079: new 655	java/lang/NullPointerException
    //   1082: dup
    //   1083: invokespecial 656	java/lang/NullPointerException:<init>	()V
    //   1086: athrow
    //   1087: aload 5
    //   1089: invokevirtual 653	java/io/BufferedInputStream:close	()V
    //   1092: goto -371 -> 721
    //   1095: astore_0
    //   1096: ldc_w 446
    //   1099: iconst_1
    //   1100: ldc_w 658
    //   1103: aload_0
    //   1104: invokestatic 563	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1107: goto -28 -> 1079
    //   1110: astore_1
    //   1111: aload 5
    //   1113: invokevirtual 653	java/io/BufferedInputStream:close	()V
    //   1116: aload_1
    //   1117: athrow
    //   1118: aload_2
    //   1119: new 80	java/lang/StringBuilder
    //   1122: dup
    //   1123: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   1126: ldc_w 660
    //   1129: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1132: ldc_w 531
    //   1135: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1138: ldc_w 662
    //   1141: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1144: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1147: invokevirtual 593	java/lang/String:getBytes	()[B
    //   1150: invokevirtual 598	java/io/OutputStream:write	([B)V
    //   1153: aload_2
    //   1154: invokevirtual 651	java/io/OutputStream:flush	()V
    //   1157: aload_2
    //   1158: invokevirtual 652	java/io/OutputStream:close	()V
    //   1161: new 576	java/lang/StringBuffer
    //   1164: dup
    //   1165: invokespecial 577	java/lang/StringBuffer:<init>	()V
    //   1168: astore_1
    //   1169: new 225	java/io/BufferedReader
    //   1172: dup
    //   1173: new 227	java/io/InputStreamReader
    //   1176: dup
    //   1177: aload 7
    //   1179: invokevirtual 231	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   1182: invokespecial 234	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   1185: invokespecial 237	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   1188: astore_2
    //   1189: aload_2
    //   1190: invokevirtual 240	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   1193: astore_3
    //   1194: aload_3
    //   1195: ifnull +17 -> 1212
    //   1198: aload_1
    //   1199: aload_3
    //   1200: invokevirtual 582	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1203: ldc 242
    //   1205: invokevirtual 582	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1208: pop
    //   1209: goto -20 -> 1189
    //   1212: aload_1
    //   1213: invokevirtual 589	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   1216: astore_1
    //   1217: aload_2
    //   1218: invokevirtual 245	java/io/BufferedReader:close	()V
    //   1221: aload 7
    //   1223: ifnull +49 -> 1272
    //   1226: aload 7
    //   1228: invokevirtual 192	java/net/HttpURLConnection:getResponseCode	()I
    //   1231: istore 6
    //   1233: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1236: ifeq +31 -> 1267
    //   1239: ldc_w 446
    //   1242: iconst_2
    //   1243: new 80	java/lang/StringBuilder
    //   1246: dup
    //   1247: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   1250: ldc_w 565
    //   1253: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1256: iload 6
    //   1258: invokevirtual 197	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1261: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1264: invokestatic 95	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1267: aload 7
    //   1269: invokevirtual 211	java/net/HttpURLConnection:disconnect	()V
    //   1272: aload_1
    //   1273: areturn
    //   1274: astore_0
    //   1275: ldc_w 446
    //   1278: iconst_1
    //   1279: ldc_w 658
    //   1282: aload_0
    //   1283: invokestatic 563	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1286: goto -19 -> 1267
    //   1289: astore_0
    //   1290: ldc_w 446
    //   1293: iconst_1
    //   1294: ldc_w 658
    //   1297: aload_0
    //   1298: invokestatic 563	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1301: goto -828 -> 473
    //   1304: astore_1
    //   1305: ldc_w 446
    //   1308: iconst_1
    //   1309: ldc_w 658
    //   1312: aload_1
    //   1313: invokestatic 563	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1316: goto -631 -> 685
    //   1319: astore_0
    //   1320: aconst_null
    //   1321: astore 4
    //   1323: goto -684 -> 639
    //   1326: astore_0
    //   1327: goto -688 -> 639
    //   1330: astore_3
    //   1331: aconst_null
    //   1332: astore_2
    //   1333: aconst_null
    //   1334: astore_1
    //   1335: goto -939 -> 396
    //   1338: astore_3
    //   1339: aconst_null
    //   1340: astore_1
    //   1341: goto -945 -> 396
    //   1344: astore_3
    //   1345: aload 7
    //   1347: astore_2
    //   1348: goto -952 -> 396
    //   1351: ldc_w 664
    //   1354: astore_1
    //   1355: goto -538 -> 817
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1358	0	paramString1	String
    //   0	1358	1	paramString2	String
    //   0	1358	2	paramString3	String
    //   0	1358	3	paramMap1	java.util.Map<String, String>
    //   0	1358	4	paramMap2	java.util.Map<String, String>
    //   0	1358	5	paramMap3	java.util.Map<String, String>
    //   437	820	6	i	int
    //   39	1307	7	localHttpURLConnection	java.net.HttpURLConnection
    //   186	694	8	localObject	Object
    //   824	107	9	localStringBuffer	java.lang.StringBuffer
    // Exception table:
    //   from	to	target	type
    //   41	184	390	java/lang/Exception
    //   193	202	390	java/lang/Exception
    //   202	282	390	java/lang/Exception
    //   282	332	390	java/lang/Exception
    //   332	345	390	java/lang/Exception
    //   345	387	390	java/lang/Exception
    //   479	492	390	java/lang/Exception
    //   496	517	390	java/lang/Exception
    //   517	562	390	java/lang/Exception
    //   567	631	390	java/lang/Exception
    //   692	703	390	java/lang/Exception
    //   708	721	390	java/lang/Exception
    //   721	761	390	java/lang/Exception
    //   765	793	390	java/lang/Exception
    //   803	814	390	java/lang/Exception
    //   817	972	390	java/lang/Exception
    //   1087	1092	390	java/lang/Exception
    //   1111	1118	390	java/lang/Exception
    //   1118	1189	390	java/lang/Exception
    //   1189	1194	390	java/lang/Exception
    //   1198	1209	390	java/lang/Exception
    //   1212	1217	390	java/lang/Exception
    //   41	184	634	finally
    //   193	202	634	finally
    //   202	282	634	finally
    //   282	332	634	finally
    //   332	345	634	finally
    //   345	387	634	finally
    //   479	492	634	finally
    //   496	517	634	finally
    //   517	562	634	finally
    //   567	631	634	finally
    //   692	703	634	finally
    //   708	721	634	finally
    //   721	761	634	finally
    //   765	793	634	finally
    //   803	814	634	finally
    //   817	972	634	finally
    //   1087	1092	634	finally
    //   1111	1118	634	finally
    //   1118	1189	634	finally
    //   1189	1194	634	finally
    //   1198	1209	634	finally
    //   1212	1217	634	finally
    //   1217	1221	634	finally
    //   972	980	997	java/lang/OutOfMemoryError
    //   986	994	997	java/lang/OutOfMemoryError
    //   1071	1079	1095	java/lang/Exception
    //   972	980	1110	finally
    //   986	994	1110	finally
    //   998	1053	1110	finally
    //   1226	1267	1274	java/lang/Exception
    //   433	473	1289	java/lang/Exception
    //   644	685	1304	java/lang/Exception
    //   25	41	1319	finally
    //   399	427	1326	finally
    //   1060	1065	1326	finally
    //   25	41	1330	java/lang/Exception
    //   1060	1065	1338	java/lang/Exception
    //   1217	1221	1344	java/lang/Exception
  }
  
  public static String a(HttpResponse paramHttpResponse)
  {
    return new String(a(paramHttpResponse).toByteArray());
  }
  
  public static final HashMap<String, String> a(Context paramContext, String paramString1, String paramString2, int paramInt, HashMap<String, String> paramHashMap, Bundle paramBundle)
  {
    if (paramHashMap == null) {
      paramContext = new HashMap();
    }
    HashMap localHashMap;
    for (;;)
    {
      return paramContext;
      localHashMap = new HashMap(paramHashMap);
      JSONArray localJSONArray = new JSONArray();
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = paramHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        String str2 = (String)paramHashMap.get(str1);
        if (!TextUtils.isEmpty(str2))
        {
          localJSONArray.put(str2);
          localArrayList.add(str1);
        }
      }
      paramContext = a(paramContext, paramString1, paramString2, paramInt, localJSONArray);
      if (paramContext != null) {
        try
        {
          paramContext = new JSONObject(paramContext);
          paramInt = paramContext.getInt("retcode");
          if (paramBundle != null) {
            paramBundle.putInt("retcode", paramInt);
          }
          if (paramInt == 0)
          {
            paramContext = paramContext.getJSONObject("result");
            if (paramContext == null) {
              return localHashMap;
            }
            paramContext = paramContext.getJSONArray("list");
            if (paramContext == null) {
              return localHashMap;
            }
            if (paramContext.length() != localArrayList.size()) {
              break label325;
            }
            paramString1 = new HashMap();
            paramInt = 0;
            while (paramInt < paramContext.length())
            {
              paramString1.put(localArrayList.get(paramInt), paramContext.getString(paramInt));
              paramInt += 1;
            }
            if (QLog.isColorLevel()) {
              QLog.d("HttpUtil", 2, "batchUrlExchange results: " + paramString1.toString() + ", input: " + paramHashMap);
            }
            paramContext = paramString1;
            if (paramBundle == null) {
              continue;
            }
            paramBundle.putBoolean("isSuccess", true);
            return paramString1;
          }
        }
        catch (JSONException paramContext)
        {
          QLog.d("Q.share.sdk", 4, paramContext.getMessage());
        }
      }
    }
    for (;;)
    {
      return localHashMap;
      label325:
      QLog.e("Q.share.sdk", 4, "!!!!urlArray.length() != srcKeyArray.size()");
    }
  }
  
  public static HashMap<String, String> a(String paramString)
  {
    HashMap localHashMap = new HashMap();
    if (paramString == null) {}
    do
    {
      return localHashMap;
      paramString = d(paramString);
    } while (paramString == null);
    paramString = paramString.split("[&]");
    int j = paramString.length;
    int i = 0;
    label36:
    String[] arrayOfString;
    if (i < j)
    {
      arrayOfString = paramString[i].split("[=]");
      if (arrayOfString.length <= 1) {
        break label85;
      }
      localHashMap.put(URLDecoder.decode(arrayOfString[0]), URLDecoder.decode(arrayOfString[1]));
    }
    for (;;)
    {
      i += 1;
      break label36;
      break;
      label85:
      if (!TextUtils.isEmpty(arrayOfString[0])) {
        localHashMap.put(arrayOfString[0], "");
      }
    }
  }
  
  public static final HashMap<String, String> a(HashMap<String, String> paramHashMap)
  {
    return a(paramHashMap, null);
  }
  
  public static final HashMap<String, String> a(HashMap<String, String> paramHashMap, Bundle paramBundle)
  {
    if (paramHashMap == null) {
      return new HashMap();
    }
    HashMap localHashMap = new HashMap(paramHashMap);
    Object localObject1 = new JSONArray();
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = paramHashMap.keySet().iterator();
    Object localObject4;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (String)((Iterator)localObject2).next();
      localObject4 = (String)paramHashMap.get(localObject3);
      if (!TextUtils.isEmpty((CharSequence)localObject4))
      {
        ((JSONArray)localObject1).put(localObject4);
        localArrayList.add(localObject3);
      }
    }
    Object localObject3 = new Bundle();
    localObject2 = b();
    Object localObject5;
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject5 = (TicketManager)BaseApplicationImpl.getApplication().getRuntime().getManager(2);
      localObject4 = ((TicketManager)localObject5).getPskey((String)localObject2, "openmobile.qq.com");
      localObject5 = ((TicketManager)localObject5).getSkey((String)localObject2);
      if (TextUtils.isEmpty((CharSequence)localObject4)) {
        break label295;
      }
      ((Bundle)localObject3).putString("cookie", "p_uin=" + (String)localObject2 + ";p_skey=" + (String)localObject4);
    }
    for (;;)
    {
      ((Bundle)localObject3).putString("Referer", "http://openmobile.qq.com/");
      localObject4 = new Bundle();
      ((Bundle)localObject4).putString("value", ((JSONArray)localObject1).toString());
      ((Bundle)localObject4).putString("mType", "qb_share");
      localObject2 = null;
      try
      {
        localObject1 = a(BaseApplication.getContext(), MsfSdkUtils.insertMtype("AppDepart", "http://openmobile.qq.com/api/shortUrl"), "POST", (Bundle)localObject4, (Bundle)localObject3);
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          return localHashMap;
          label295:
          ((Bundle)localObject3).putString("cookie", "uin=" + (String)localObject2 + ";skey=" + (String)localObject5);
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          localObject1 = localObject2;
          if (QLog.isColorLevel())
          {
            QLog.d("HttpUtil", 2, localIOException.getMessage());
            localObject1 = localObject2;
          }
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          localObject1 = localObject2;
          if (QLog.isColorLevel())
          {
            QLog.d("HttpUtil", 2, localOutOfMemoryError.getMessage());
            localObject1 = localObject2;
          }
        }
      }
    }
    for (;;)
    {
      int i;
      try
      {
        localObject1 = new JSONObject((String)localObject1);
        i = ((JSONObject)localObject1).getInt("retcode");
        if (paramBundle != null) {
          paramBundle.putInt("retcode", i);
        }
        if (i != 0)
        {
          if (!QLog.isColorLevel()) {
            break label659;
          }
          QLog.d("HttpUtil", 2, "shortenUrl error retcode:" + i);
          break label659;
        }
        paramBundle = ((JSONObject)localObject1).getJSONObject("result");
        if (paramBundle == null)
        {
          if (!QLog.isColorLevel()) {
            break label662;
          }
          QLog.d("HttpUtil", 2, "shortenUrl error result");
          break label662;
        }
        paramBundle = paramBundle.getJSONArray("list");
        if (paramBundle == null)
        {
          if (!QLog.isColorLevel()) {
            break label665;
          }
          QLog.d("HttpUtil", 2, "shortenUrl error result");
          break label665;
        }
        if (paramBundle.length() == localArrayList.size())
        {
          i = 0;
          if (i < paramBundle.length())
          {
            localObject1 = paramBundle.getString(i);
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              break label668;
            }
            localHashMap.put(localArrayList.get(i), localObject1);
            break label668;
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("HttpUtil", 2, "shortenUrl error result size");
        }
      }
      catch (JSONException paramBundle)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("HttpUtil", 2, "shortenUrl parse response error");
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("HttpUtil", 2, "shortenUrl results: " + localHashMap.toString() + ", input: " + paramHashMap);
      }
      return localHashMap;
      label659:
      return localHashMap;
      label662:
      return localHashMap;
      label665:
      return localHashMap;
      label668:
      i += 1;
    }
  }
  
  public static nal a(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    Object localObject = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (localObject == null) {
      return null;
    }
    localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
    if (localObject == null) {
      return null;
    }
    if (bbfj.a((NetworkInfo)localObject))
    {
      localObject = a(paramContext);
      int i = a(paramContext);
      if ((!b((String)localObject)) && (i >= 0)) {
        return new nal((String)localObject, i, null);
      }
    }
    return null;
  }
  
  public static HttpResponse a(Context paramContext, String paramString1, String paramString2, String paramString3, Bundle paramBundle1, Bundle paramBundle2)
  {
    return a(paramContext, paramString1, paramString2, paramString3, paramBundle1, paramBundle2, 15000, 30000);
  }
  
  public static HttpResponse a(Context paramContext, String paramString1, String paramString2, String paramString3, Bundle paramBundle1, Bundle paramBundle2, int paramInt1, int paramInt2)
  {
    return a(paramContext, paramString1, paramString2, paramString3, paramBundle1, paramBundle2, paramInt1, paramInt2, null);
  }
  
  public static HttpResponse a(Context paramContext, String paramString1, String paramString2, String paramString3, Bundle paramBundle1, Bundle paramBundle2, int paramInt1, int paramInt2, String paramString4)
  {
    if (!jdField_a_of_type_Boolean)
    {
      jdField_a_of_type_Boolean = true;
      wij.a(paramContext, wij.c);
    }
    if (paramContext == null) {
      return null;
    }
    paramString4 = a(paramContext, paramInt1, paramInt2, paramString4);
    if (paramString4 == null) {
      return null;
    }
    QLog.d("QRHttpUtil", 2, paramString1);
    paramContext = paramString1;
    if (paramString1.contains("#")) {
      paramContext = paramString1.substring(0, paramString1.indexOf('#'));
    }
    paramString1 = paramContext.replace(" ", "%20");
    if ("GET".equals(paramString3))
    {
      paramString3 = a(paramBundle1);
      paramContext = paramString1;
      if (paramString3 != null)
      {
        paramContext = paramString1;
        if (paramString3.length() > 0)
        {
          paramBundle1 = new StringBuilder().append(paramString1);
          if (!paramString1.contains("?")) {
            break label254;
          }
          paramContext = "&";
        }
      }
      for (;;)
      {
        paramContext = paramContext + paramString3;
        try
        {
          paramContext = new HttpGet(paramContext);
          paramContext.addHeader("Accept-Encoding", "gzip");
          paramContext.addHeader("Connection", "close");
          if (paramBundle2 != null)
          {
            paramString1 = paramBundle2.keySet().iterator();
            while (paramString1.hasNext())
            {
              paramString3 = (String)paramString1.next();
              paramBundle1 = paramBundle2.get(paramString3);
              if ((paramBundle1 instanceof String))
              {
                paramContext.addHeader(paramString3, (String)paramBundle1);
                continue;
                label254:
                paramContext = "?";
              }
            }
          }
        }
        catch (Exception paramContext)
        {
          return null;
        }
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramString2)) {
        paramContext.getParams().setParameter("http.virtual-host", new HttpHost(paramString2));
      }
      try
      {
        paramContext = paramString4.execute(paramContext);
        return paramContext;
      }
      catch (IOException paramContext)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("QRHttpUtil", 2, "openRequest fail IOException", paramContext);
        return null;
      }
      catch (OutOfMemoryError paramContext)
      {
        if (!QLog.isColorLevel()) {
          break label708;
        }
        QLog.d("QRHttpUtil", 2, "openRequest fail OutOfMemoryError");
        return null;
      }
      catch (Exception paramContext)
      {
        if (!QLog.isColorLevel()) {
          break label728;
        }
        QLog.d("QRHttpUtil", 2, "openRequest fail Exception", paramContext);
      }
      paramString1 = new HttpPost(paramString1);
      paramString1.addHeader("Accept-Encoding", "gzip");
      paramString1.addHeader("Connection", "close");
      paramContext = "";
      paramInt1 = paramBundle1.getInt("PostBodyType");
      if (paramInt1 == 0)
      {
        paramContext = a(paramBundle1);
        paramString1.setHeader("Content-Type", "application/x-www-form-urlencoded");
      }
      for (;;)
      {
        paramContext = paramContext.getBytes();
        if (paramBundle2 == null) {
          break;
        }
        paramString3 = paramBundle2.keySet().iterator();
        Object localObject1;
        while (paramString3.hasNext())
        {
          paramBundle1 = (String)paramString3.next();
          localObject1 = paramBundle2.get(paramBundle1);
          if ((localObject1 instanceof String)) {
            paramString1.addHeader(paramBundle1, (String)localObject1);
          }
        }
        if (paramInt1 == 1)
        {
          paramString1.setHeader("Content-Type", "application/json; charset=UTF-8");
          paramBundle1.remove("PostBodyType");
          paramContext = new JSONObject();
          paramString3 = paramBundle1.keySet().iterator();
          while (paramString3.hasNext())
          {
            localObject1 = (String)paramString3.next();
            Object localObject2 = paramBundle1.get((String)localObject1);
            try
            {
              if (!(localObject2 instanceof String)) {
                break label560;
              }
              paramContext.put(URLEncoder.encode((String)localObject1), paramBundle1.getString((String)localObject1));
            }
            catch (JSONException localJSONException) {}
            if (QLog.isColorLevel())
            {
              QLog.d("QRHttpUtil", 2, "postBodyType=POST_BODY_TYPE_JSON parse Params to Json failed.");
              continue;
              label560:
              if (((localObject2 instanceof Long)) || ((localObject2 instanceof Integer)) || ((localObject2 instanceof Float)) || ((localObject2 instanceof Double)) || ((localObject2 instanceof Byte))) {
                paramContext.put(URLEncoder.encode(localJSONException), localObject2);
              } else if (((localObject2 instanceof JSONObject)) || ((localObject2 instanceof JSONArray))) {
                paramContext.put(URLEncoder.encode(localJSONException), localObject2);
              }
            }
          }
          paramContext = paramContext.toString();
        }
      }
      paramString1.setEntity(new ByteArrayEntity(paramContext));
      paramContext = paramString1;
    }
    label708:
    label728:
    return null;
  }
  
  private static HttpClient a(Context paramContext, int paramInt1, int paramInt2, String paramString)
  {
    Object localObject = null;
    if (paramContext == null)
    {
      paramContext = (Context)localObject;
      return paramContext;
    }
    if (Build.VERSION.SDK_INT < 16) {}
    for (;;)
    {
      try
      {
        localObject = KeyStore.getInstance(KeyStore.getDefaultType());
        ((KeyStore)localObject).load(null, null);
        localObject = new lae((KeyStore)localObject);
        ((SSLSocketFactory)localObject).setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
        if (!TextUtils.isEmpty(paramString)) {
          ((SSLSocketFactory)localObject).setHostnameVerifier(new nak(paramString));
        }
        paramString = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(paramString, paramInt1);
        HttpConnectionParams.setSoTimeout(paramString, paramInt2);
        HttpProtocolParams.setVersion(paramString, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setContentCharset(paramString, "UTF-8");
        HttpProtocolParams.setUserAgent(paramString, "AndroidSDK_" + Build.VERSION.SDK + "_" + Build.DEVICE + "_" + Build.VERSION.RELEASE);
        SchemeRegistry localSchemeRegistry = new SchemeRegistry();
        localSchemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        localSchemeRegistry.register(new Scheme("https", (SocketFactory)localObject, 443));
        paramString = new DefaultHttpClient(new ThreadSafeClientConnManager(paramString, localSchemeRegistry), paramString);
        localObject = a(paramContext);
        paramContext = paramString;
        if (localObject == null) {
          break;
        }
        paramContext = new HttpHost(((nal)localObject).jdField_a_of_type_JavaLangString, ((nal)localObject).jdField_a_of_type_Int);
        paramString.getParams().setParameter("http.route.default-proxy", paramContext);
        return paramString;
      }
      catch (Exception localException)
      {
        localSSLSocketFactory = SSLSocketFactory.getSocketFactory();
        localSSLSocketFactory.setHostnameVerifier(jdField_a_of_type_ComTencentComponentNetworkUtilsHttpBaseSNIVerifier);
        continue;
      }
      SSLSocketFactory localSSLSocketFactory = SSLSocketFactory.getSocketFactory();
    }
  }
  
  public static void a(Bundle paramBundle)
  {
    String str1 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    String str2 = ((TicketManager)BaseApplicationImpl.getApplication().getRuntime().getManager(2)).getSkey(str1);
    paramBundle.putString("cookie", "uin=" + str1 + ";skey=" + str2);
  }
  
  public static boolean a(Context paramContext)
  {
    if (paramContext == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HttpUtil", 2, "isConnect(), context == null");
      }
      return false;
    }
    try
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext != null)
      {
        paramContext = paramContext.getActiveNetworkInfo();
        if ((paramContext != null) && (paramContext.isConnected()))
        {
          paramContext = paramContext.getState();
          NetworkInfo.State localState = NetworkInfo.State.CONNECTED;
          if (paramContext == localState) {
            return true;
          }
        }
      }
    }
    catch (Exception paramContext)
    {
      QLog.d("HttpUtil", 2, paramContext.toString());
    }
    return false;
  }
  
  public static final boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((!paramString.startsWith("http://")) && (!paramString.startsWith("https://"))) {
      return false;
    }
    return true;
  }
  
  public static byte[] a(Context paramContext, String paramString1, String paramString2, Bundle paramBundle1, Bundle paramBundle2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return null;
    }
    if (paramBundle1 == null) {
      paramBundle1 = new Bundle();
    }
    for (;;)
    {
      String str2 = Uri.parse(paramString1).getHost();
      try
      {
        HttpResponse localHttpResponse = a(paramContext, paramString1, null, paramString2, paramBundle1, paramBundle2);
        paramContext = localHttpResponse;
      }
      catch (IOException localIOException)
      {
        while (str2.equals(wij.c))
        {
          str1 = wij.a(paramContext, str2);
          if (str1 == null) {
            break label198;
          }
          paramString1 = paramString1.replace(str2, str1);
          QLog.d("QRHttpUtil", 2, "ClientProtocolException reopen: " + paramString1);
          paramContext = a(paramContext, paramString1, str2, paramString2, paramBundle1, paramBundle2);
        }
        throw str1;
      }
      if (paramContext == null) {
        throw new IOException("Http no response.");
      }
      label198:
      for (;;)
      {
        String str1;
        int i = paramContext.getStatusLine().getStatusCode();
        if (i == 200) {
          return a(paramContext).toByteArray();
        }
        throw new IOException("Http statusCode:" + i);
      }
    }
  }
  
  public static byte[] a(Context paramContext, String paramString1, String paramString2, Bundle paramBundle1, Bundle paramBundle2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return null;
    }
    if (paramBundle1 == null) {
      paramBundle1 = new Bundle();
    }
    for (;;)
    {
      String str = Uri.parse(paramString1).getHost();
      for (;;)
      {
        try
        {
          if (!TextUtils.isEmpty(paramString3)) {
            continue;
          }
          paramString3 = a(paramContext, paramString1, str, paramString2, paramBundle1, paramBundle2);
          paramContext = paramString3;
        }
        catch (IOException paramString3)
        {
          if (!str.equals(wij.c)) {
            continue;
          }
          paramString3 = wij.a(paramContext, str);
          if (paramString3 == null) {
            break label241;
          }
          paramString1 = paramString1.replace(str, paramString3);
          QLog.d("QRHttpUtil", 2, "ClientProtocolException reopen: " + paramString1);
          paramContext = a(paramContext, paramString1, str, paramString2, paramBundle1, paramBundle2);
          continue;
          throw new IOException("0");
        }
        if (paramContext != null) {
          break label184;
        }
        throw new IOException("0");
        paramString3 = a(paramContext, paramString1, str, paramString2, paramBundle1, paramBundle2, 15000, 30000, paramString3);
        paramContext = paramString3;
      }
      label184:
      label241:
      for (;;)
      {
        int i = paramContext.getStatusLine().getStatusCode();
        if (i == 200) {
          return a(paramContext).toByteArray();
        }
        throw new IOException("" + i);
      }
    }
  }
  
  private static String b()
  {
    Object localObject1 = null;
    Object localObject2 = BaseApplicationImpl.getApplication();
    if (localObject2 != null) {
      localObject1 = ((BaseApplicationImpl)localObject2).getRuntime();
    }
    if (localObject1 == null) {
      localObject1 = "0";
    }
    do
    {
      return localObject1;
      localObject2 = ((AppRuntime)localObject1).getAccount();
      localObject1 = localObject2;
    } while (localObject2 != null);
    return "0";
  }
  
  public static String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    return paramString.replace("&apos;", "'").replace("&quot;", "\"").replace("&nbsp;", " ").replace("&lt;", "<").replace("&gt;", ">").replace("&amp;", "&");
  }
  
  private static boolean b(String paramString)
  {
    return (paramString == null) || (paramString.length() == 0);
  }
  
  public static String c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    Object localObject = new String[27];
    localObject[0] = "li";
    localObject[1] = "del";
    localObject[2] = "ins";
    localObject[3] = "fieldset";
    localObject[4] = "legend";
    localObject[5] = "tr";
    localObject[6] = "th";
    localObject[7] = "caption";
    localObject[8] = "thead";
    localObject[9] = "tbody";
    localObject[10] = "tfoot";
    localObject[11] = "p";
    localObject[12] = "h[1-6]";
    localObject[13] = "dl";
    localObject[14] = "dt";
    localObject[15] = "dd";
    localObject[16] = "ol";
    localObject[17] = "ul";
    localObject[18] = "dir";
    localObject[19] = "address";
    localObject[20] = "blockquote";
    localObject[21] = "center";
    localObject[22] = "hr";
    localObject[23] = "pre";
    localObject[24] = "form";
    localObject[25] = "textarea";
    localObject[26] = "table";
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      Matcher localMatcher = Pattern.compile("<(\\s*" + localObject[i] + ")[^>]*>").matcher(paramString);
      if (localMatcher.find()) {
        paramString = localMatcher.replaceAll(" ");
      }
      localMatcher = Pattern.compile("</?(\\s*" + localObject[i] + ")[^>]*>").matcher(paramString);
      if (localMatcher.find()) {
        paramString = localMatcher.replaceAll("\n");
      }
      i += 1;
    }
    localObject = Pattern.compile("<br>").matcher(paramString);
    if (((Matcher)localObject).find()) {
      paramString = ((Matcher)localObject).replaceAll("\n");
    }
    return paramString.replaceAll("<[^>]*>", "").replaceAll("[(/>)<]", "");
  }
  
  private static String d(String paramString)
  {
    Object localObject = null;
    String str = paramString.trim();
    String[] arrayOfString = str.split("[?]");
    paramString = localObject;
    if (str.length() > 1)
    {
      paramString = localObject;
      if (arrayOfString.length > 1)
      {
        paramString = localObject;
        if (arrayOfString[1] != null) {
          paramString = arrayOfString[1];
        }
      }
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     naj
 * JD-Core Version:    0.7.0.1
 */