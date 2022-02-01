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
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.HttpsURLConnection;
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

public class nnr
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
    //   3: iconst_1
    //   4: istore 4
    //   6: iconst_1
    //   7: istore 5
    //   9: ldc 73
    //   11: iconst_1
    //   12: new 75	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   19: ldc 78
    //   21: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_0
    //   25: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   34: aload_0
    //   35: invokestatic 98	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   38: ifne +17 -> 55
    //   41: aload_1
    //   42: invokestatic 98	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   45: ifne +10 -> 55
    //   48: aload_2
    //   49: invokestatic 98	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   52: ifeq +5 -> 57
    //   55: aconst_null
    //   56: areturn
    //   57: new 100	java/net/URL
    //   60: dup
    //   61: aload_0
    //   62: invokespecial 103	java/net/URL:<init>	(Ljava/lang/String;)V
    //   65: invokevirtual 107	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   68: checkcast 109	javax/net/ssl/HttpsURLConnection
    //   71: astore 7
    //   73: iload 5
    //   75: istore_3
    //   76: new 111	nnt
    //   79: dup
    //   80: invokespecial 112	nnt:<init>	()V
    //   83: astore_0
    //   84: iload 5
    //   86: istore_3
    //   87: aload 7
    //   89: new 114	bhve
    //   92: dup
    //   93: ldc 116
    //   95: aload_0
    //   96: invokespecial 119	bhve:<init>	(Ljava/lang/String;Ljavax/net/ssl/HostnameVerifier;)V
    //   99: invokevirtual 123	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   102: iload 5
    //   104: istore_3
    //   105: aload 7
    //   107: aload_0
    //   108: invokevirtual 127	javax/net/ssl/HttpsURLConnection:setHostnameVerifier	(Ljavax/net/ssl/HostnameVerifier;)V
    //   111: iload 5
    //   113: istore_3
    //   114: aload 7
    //   116: sipush 5000
    //   119: invokevirtual 131	javax/net/ssl/HttpsURLConnection:setConnectTimeout	(I)V
    //   122: iload 5
    //   124: istore_3
    //   125: aload 7
    //   127: sipush 30000
    //   130: invokevirtual 134	javax/net/ssl/HttpsURLConnection:setReadTimeout	(I)V
    //   133: iload 5
    //   135: istore_3
    //   136: aload 7
    //   138: ldc 136
    //   140: invokevirtual 139	javax/net/ssl/HttpsURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   143: iload 5
    //   145: istore_3
    //   146: aload 7
    //   148: ldc 141
    //   150: ldc 143
    //   152: invokevirtual 147	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   155: iload 5
    //   157: istore_3
    //   158: aload 7
    //   160: ldc 149
    //   162: new 75	java/lang/StringBuilder
    //   165: dup
    //   166: ldc 151
    //   168: invokespecial 152	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   171: ldc 154
    //   173: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: getstatic 158	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   179: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: ldc 154
    //   184: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: getstatic 163	android/os/Build:DEVICE	Ljava/lang/String;
    //   190: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: ldc 154
    //   195: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: getstatic 166	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   201: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: ldc 154
    //   206: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: ldc 168
    //   211: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   217: invokevirtual 147	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   220: iload 5
    //   222: istore_3
    //   223: aload 7
    //   225: ldc 170
    //   227: ldc 172
    //   229: invokevirtual 147	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   232: iload 5
    //   234: istore_3
    //   235: aload 7
    //   237: ldc 174
    //   239: ldc 116
    //   241: invokevirtual 147	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   244: iload 5
    //   246: istore_3
    //   247: invokestatic 180	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   250: invokevirtual 184	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   253: iconst_2
    //   254: invokevirtual 190	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   257: checkcast 192	mqq/manager/TicketManager
    //   260: aload_1
    //   261: ldc 116
    //   263: invokeinterface 196 3 0
    //   268: astore_0
    //   269: iload 5
    //   271: istore_3
    //   272: aload_0
    //   273: invokestatic 98	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   276: ifne +118 -> 394
    //   279: iload 5
    //   281: istore_3
    //   282: aload 7
    //   284: ldc 198
    //   286: new 75	java/lang/StringBuilder
    //   289: dup
    //   290: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   293: ldc 200
    //   295: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: aload_1
    //   299: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: ldc 202
    //   304: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: aload_0
    //   308: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   314: invokevirtual 147	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   317: iload 5
    //   319: istore_3
    //   320: aload 7
    //   322: invokevirtual 205	javax/net/ssl/HttpsURLConnection:getResponseCode	()I
    //   325: istore 6
    //   327: iload 6
    //   329: sipush 200
    //   332: if_icmpeq +155 -> 487
    //   335: iload 5
    //   337: istore_3
    //   338: ldc 73
    //   340: iconst_1
    //   341: new 75	java/lang/StringBuilder
    //   344: dup
    //   345: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   348: ldc 207
    //   350: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: iload 6
    //   355: invokevirtual 210	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   358: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   361: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   364: iload 5
    //   366: istore_3
    //   367: new 212	com/tencent/util/Pair
    //   370: dup
    //   371: iload 6
    //   373: invokestatic 216	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   376: ldc 218
    //   378: invokespecial 221	com/tencent/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   381: astore_0
    //   382: aload 7
    //   384: ifnull +8 -> 392
    //   387: aload 7
    //   389: invokevirtual 224	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   392: aload_0
    //   393: areturn
    //   394: iload 5
    //   396: istore_3
    //   397: aload 7
    //   399: ldc 198
    //   401: new 75	java/lang/StringBuilder
    //   404: dup
    //   405: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   408: ldc 226
    //   410: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   413: aload_1
    //   414: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   417: ldc 228
    //   419: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   422: aload_2
    //   423: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   426: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   429: invokevirtual 147	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   432: goto -115 -> 317
    //   435: astore_1
    //   436: aload 7
    //   438: astore_0
    //   439: ldc 73
    //   441: iconst_1
    //   442: new 75	java/lang/StringBuilder
    //   445: dup
    //   446: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   449: ldc 230
    //   451: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   454: aload_1
    //   455: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   458: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   461: invokestatic 236	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   464: aload_0
    //   465: ifnull +256 -> 721
    //   468: aload_0
    //   469: invokevirtual 224	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   472: aconst_null
    //   473: astore_0
    //   474: new 212	com/tencent/util/Pair
    //   477: dup
    //   478: iload_3
    //   479: invokestatic 216	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   482: aload_0
    //   483: invokespecial 221	com/tencent/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   486: areturn
    //   487: iload 5
    //   489: istore_3
    //   490: new 75	java/lang/StringBuilder
    //   493: dup
    //   494: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   497: astore_0
    //   498: iload 5
    //   500: istore_3
    //   501: new 238	java/io/BufferedReader
    //   504: dup
    //   505: new 240	java/io/InputStreamReader
    //   508: dup
    //   509: aload 7
    //   511: invokevirtual 244	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   514: invokespecial 247	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   517: invokespecial 250	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   520: astore_1
    //   521: iload 5
    //   523: istore_3
    //   524: aload_1
    //   525: invokevirtual 253	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   528: astore_2
    //   529: aload_2
    //   530: ifnull +34 -> 564
    //   533: iload 5
    //   535: istore_3
    //   536: aload_0
    //   537: aload_2
    //   538: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   541: ldc 255
    //   543: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   546: pop
    //   547: goto -26 -> 521
    //   550: astore_1
    //   551: aload 7
    //   553: astore_0
    //   554: aload_0
    //   555: ifnull +7 -> 562
    //   558: aload_0
    //   559: invokevirtual 224	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   562: aload_1
    //   563: athrow
    //   564: iload 5
    //   566: istore_3
    //   567: aload_1
    //   568: invokevirtual 258	java/io/BufferedReader:close	()V
    //   571: iload 5
    //   573: istore_3
    //   574: aload_0
    //   575: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   578: astore_0
    //   579: iload 5
    //   581: istore_3
    //   582: aload_0
    //   583: invokestatic 98	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   586: ifne +108 -> 694
    //   589: iload 5
    //   591: istore_3
    //   592: new 260	org/json/JSONObject
    //   595: dup
    //   596: aload_0
    //   597: invokespecial 261	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   600: astore_0
    //   601: iload 5
    //   603: istore_3
    //   604: aload_0
    //   605: ldc_w 263
    //   608: invokevirtual 266	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   611: istore 4
    //   613: iload 4
    //   615: ifne +49 -> 664
    //   618: iload 4
    //   620: istore_3
    //   621: aload_0
    //   622: ldc_w 268
    //   625: invokevirtual 271	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   628: ifeq +36 -> 664
    //   631: iload 4
    //   633: istore_3
    //   634: aload_0
    //   635: ldc_w 268
    //   638: invokevirtual 275	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   641: ldc_w 277
    //   644: invokevirtual 280	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   647: astore_0
    //   648: iload 4
    //   650: istore_3
    //   651: aload 7
    //   653: ifnull +73 -> 726
    //   656: aload 7
    //   658: invokevirtual 224	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   661: goto -187 -> 474
    //   664: iload 4
    //   666: istore_3
    //   667: ldc 73
    //   669: iconst_1
    //   670: new 75	java/lang/StringBuilder
    //   673: dup
    //   674: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   677: ldc_w 282
    //   680: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   683: iload 4
    //   685: invokevirtual 210	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   688: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   691: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   694: iload 4
    //   696: istore_3
    //   697: aload 8
    //   699: astore_0
    //   700: goto -49 -> 651
    //   703: astore_1
    //   704: aconst_null
    //   705: astore_0
    //   706: goto -152 -> 554
    //   709: astore_1
    //   710: goto -156 -> 554
    //   713: astore_1
    //   714: iconst_1
    //   715: istore_3
    //   716: aconst_null
    //   717: astore_0
    //   718: goto -279 -> 439
    //   721: aconst_null
    //   722: astore_0
    //   723: goto -249 -> 474
    //   726: goto -252 -> 474
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	729	0	paramString1	String
    //   0	729	1	paramString2	String
    //   0	729	2	paramString3	String
    //   75	641	3	i	int
    //   4	691	4	j	int
    //   7	595	5	k	int
    //   325	47	6	m	int
    //   71	586	7	localHttpsURLConnection	HttpsURLConnection
    //   1	697	8	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   76	84	435	java/lang/Exception
    //   87	102	435	java/lang/Exception
    //   105	111	435	java/lang/Exception
    //   114	122	435	java/lang/Exception
    //   125	133	435	java/lang/Exception
    //   136	143	435	java/lang/Exception
    //   146	155	435	java/lang/Exception
    //   158	220	435	java/lang/Exception
    //   223	232	435	java/lang/Exception
    //   235	244	435	java/lang/Exception
    //   247	269	435	java/lang/Exception
    //   272	279	435	java/lang/Exception
    //   282	317	435	java/lang/Exception
    //   320	327	435	java/lang/Exception
    //   338	364	435	java/lang/Exception
    //   367	382	435	java/lang/Exception
    //   397	432	435	java/lang/Exception
    //   490	498	435	java/lang/Exception
    //   501	521	435	java/lang/Exception
    //   524	529	435	java/lang/Exception
    //   536	547	435	java/lang/Exception
    //   567	571	435	java/lang/Exception
    //   574	579	435	java/lang/Exception
    //   582	589	435	java/lang/Exception
    //   592	601	435	java/lang/Exception
    //   604	613	435	java/lang/Exception
    //   621	631	435	java/lang/Exception
    //   634	648	435	java/lang/Exception
    //   667	694	435	java/lang/Exception
    //   76	84	550	finally
    //   87	102	550	finally
    //   105	111	550	finally
    //   114	122	550	finally
    //   125	133	550	finally
    //   136	143	550	finally
    //   146	155	550	finally
    //   158	220	550	finally
    //   223	232	550	finally
    //   235	244	550	finally
    //   247	269	550	finally
    //   272	279	550	finally
    //   282	317	550	finally
    //   320	327	550	finally
    //   338	364	550	finally
    //   367	382	550	finally
    //   397	432	550	finally
    //   490	498	550	finally
    //   501	521	550	finally
    //   524	529	550	finally
    //   536	547	550	finally
    //   567	571	550	finally
    //   574	579	550	finally
    //   582	589	550	finally
    //   592	601	550	finally
    //   604	613	550	finally
    //   621	631	550	finally
    //   634	648	550	finally
    //   667	694	550	finally
    //   57	73	703	finally
    //   439	464	709	finally
    //   57	73	713	java/lang/Exception
  }
  
  /* Error */
  public static ByteArrayOutputStream a(HttpResponse paramHttpResponse)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokeinterface 293 1 0
    //   6: astore 5
    //   8: aconst_null
    //   9: astore_2
    //   10: aconst_null
    //   11: astore 4
    //   13: aconst_null
    //   14: astore_3
    //   15: aload 5
    //   17: invokeinterface 298 1 0
    //   22: astore 5
    //   24: aload 5
    //   26: astore_3
    //   27: aload 5
    //   29: astore_2
    //   30: aload 5
    //   32: astore 4
    //   34: new 300	java/io/ByteArrayOutputStream
    //   37: dup
    //   38: invokespecial 301	java/io/ByteArrayOutputStream:<init>	()V
    //   41: astore 6
    //   43: aload 5
    //   45: astore_3
    //   46: aload 5
    //   48: astore_2
    //   49: aload 5
    //   51: astore 4
    //   53: aload_0
    //   54: ldc_w 303
    //   57: invokeinterface 307 2 0
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
    //   87: invokeinterface 312 1 0
    //   92: invokevirtual 317	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   95: ldc_w 319
    //   98: invokevirtual 322	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   101: ifeq +23 -> 124
    //   104: aload 5
    //   106: astore_3
    //   107: aload 5
    //   109: astore_2
    //   110: aload 5
    //   112: astore 4
    //   114: new 324	java/util/zip/GZIPInputStream
    //   117: dup
    //   118: aload 5
    //   120: invokespecial 325	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
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
    //   148: invokevirtual 331	java/io/InputStream:read	([B)I
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
    //   170: invokevirtual 335	java/io/ByteArrayOutputStream:write	([BII)V
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
    //   187: invokevirtual 336	java/io/InputStream:close	()V
    //   190: aload_0
    //   191: athrow
    //   192: aload_0
    //   193: ifnull +7 -> 200
    //   196: aload_0
    //   197: invokevirtual 336	java/io/InputStream:close	()V
    //   200: aload 6
    //   202: areturn
    //   203: astore_0
    //   204: aload 4
    //   206: astore_2
    //   207: new 287	java/io/IOException
    //   210: dup
    //   211: invokespecial 337	java/io/IOException:<init>	()V
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
    case 6: 
      return "5G";
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
        paramContext = a(paramContext, "https://openmobile.qq.com/api/url_change", "POST", paramString1, localBundle);
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
        while (str2.equals(zyx.c))
        {
          str1 = zyx.a(paramContext, str2);
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
          if (!str.equals(zyx.c)) {
            continue;
          }
          paramString3 = zyx.a(paramContext, str);
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
  
  public static String a(String paramString1, String paramString2, String paramString3, String paramString4, Map<String, String> paramMap1, Map<String, String> paramMap2, Map<String, String> paramMap3, boolean paramBoolean)
  {
    try
    {
      HttpsURLConnection localHttpsURLConnection = (HttpsURLConnection)new URL(paramString1).openConnection();
      nnu localnnu = new nnu(paramString2);
      if (!paramBoolean) {
        localHttpsURLConnection.setSSLSocketFactory(new bhve(paramString2, localnnu));
      }
      localHttpsURLConnection.setHostnameVerifier(localnnu);
      localHttpsURLConnection.setRequestProperty("Host", paramString2);
      paramString2 = a(localHttpsURLConnection, paramString1, paramString3, paramString4, paramMap1, paramMap2, paramMap3, paramBoolean);
      return paramString2;
    }
    catch (MalformedURLException paramString2)
    {
      QLog.e("Q.share.sdk", 1, new Object[] { "urlStr=", paramString1, ", MalformedURLException uploadImage|err=", paramString2 });
      return null;
    }
    catch (IOException paramString2)
    {
      QLog.e("Q.share.sdk", 1, new Object[] { "urlStr=", paramString1, ", IOException uploadImage|err=", paramString2 });
    }
    return null;
  }
  
  public static final String a(String paramString1, String paramString2, String paramString3, Map<String, String> paramMap1, Map<String, String> paramMap2, Map<String, String> paramMap3)
  {
    if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)) || (TextUtils.isEmpty(paramString1)))
    {
      QLog.d("Q.share.sdk", 1, "uploadImage param invalid");
      return null;
    }
    boolean bool = paramString1.startsWith("http://cgi.connect.qq.com/qqconnectopen/upload_share_image");
    try
    {
      paramString2 = a((HttpURLConnection)new URL(paramString1).openConnection(), paramString1, paramString2, paramString3, paramMap1, paramMap2, paramMap3, bool);
      return paramString2;
    }
    catch (MalformedURLException paramString2)
    {
      QLog.e("Q.share.sdk", 1, new Object[] { "urlStr=", paramString1, ", MalformedURLException uploadImage|err=", paramString2 });
      return null;
    }
    catch (IOException paramString2)
    {
      QLog.e("Q.share.sdk", 1, new Object[] { "urlStr=", paramString1, ", IOException uploadImage|err=", paramString2 });
    }
    return null;
  }
  
  /* Error */
  public static final String a(HttpURLConnection paramHttpURLConnection, String paramString1, String paramString2, String paramString3, Map<String, String> paramMap1, Map<String, String> paramMap2, Map<String, String> paramMap3, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: astore 10
    //   3: aload_0
    //   4: astore 9
    //   6: aload_0
    //   7: sipush 5000
    //   10: invokevirtual 563	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   13: aload_0
    //   14: astore 10
    //   16: aload_0
    //   17: astore 9
    //   19: aload_0
    //   20: sipush 30000
    //   23: invokevirtual 564	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   26: aload_0
    //   27: astore 10
    //   29: aload_0
    //   30: astore 9
    //   32: aload_0
    //   33: iconst_1
    //   34: invokevirtual 568	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   37: aload_0
    //   38: astore 10
    //   40: aload_0
    //   41: astore 9
    //   43: aload_0
    //   44: iconst_1
    //   45: invokevirtual 571	java/net/HttpURLConnection:setDoInput	(Z)V
    //   48: aload_0
    //   49: astore 10
    //   51: aload_0
    //   52: astore 9
    //   54: aload_0
    //   55: iconst_0
    //   56: invokevirtual 574	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   59: aload_0
    //   60: astore 10
    //   62: aload_0
    //   63: astore 9
    //   65: aload_0
    //   66: ldc_w 395
    //   69: invokevirtual 575	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   72: aload_0
    //   73: astore 10
    //   75: aload_0
    //   76: astore 9
    //   78: aload_0
    //   79: ldc 141
    //   81: ldc 143
    //   83: invokevirtual 576	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   86: aload_0
    //   87: astore 10
    //   89: aload_0
    //   90: astore 9
    //   92: aload_0
    //   93: ldc 149
    //   95: new 75	java/lang/StringBuilder
    //   98: dup
    //   99: ldc 151
    //   101: invokespecial 152	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   104: ldc 154
    //   106: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: getstatic 158	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   112: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: ldc 154
    //   117: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: getstatic 163	android/os/Build:DEVICE	Ljava/lang/String;
    //   123: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: ldc 154
    //   128: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: getstatic 166	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   134: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: ldc 154
    //   139: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: ldc 168
    //   144: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   150: invokevirtual 576	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   153: aload_0
    //   154: astore 10
    //   156: aload_0
    //   157: astore 9
    //   159: aload_0
    //   160: ldc_w 578
    //   163: new 75	java/lang/StringBuilder
    //   166: dup
    //   167: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   170: ldc_w 580
    //   173: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: ldc_w 582
    //   179: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   185: invokevirtual 576	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   188: aload 6
    //   190: astore 11
    //   192: aload 6
    //   194: ifnonnull +18 -> 212
    //   197: aload_0
    //   198: astore 10
    //   200: aload_0
    //   201: astore 9
    //   203: new 584	java/util/HashMap
    //   206: dup
    //   207: invokespecial 585	java/util/HashMap:<init>	()V
    //   210: astore 11
    //   212: iload 7
    //   214: ifeq +91 -> 305
    //   217: aload_0
    //   218: astore 10
    //   220: aload_0
    //   221: astore 9
    //   223: invokestatic 180	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   226: invokevirtual 184	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   229: iconst_2
    //   230: invokevirtual 190	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   233: checkcast 192	mqq/manager/TicketManager
    //   236: aload_2
    //   237: ldc 116
    //   239: invokeinterface 196 3 0
    //   244: astore 6
    //   246: aload_0
    //   247: astore 10
    //   249: aload_0
    //   250: astore 9
    //   252: aload 6
    //   254: invokestatic 98	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   257: ifne +48 -> 305
    //   260: aload_0
    //   261: astore 10
    //   263: aload_0
    //   264: astore 9
    //   266: aload 11
    //   268: ldc 198
    //   270: new 75	java/lang/StringBuilder
    //   273: dup
    //   274: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   277: ldc 200
    //   279: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: aload_2
    //   283: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: ldc 202
    //   288: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: aload 6
    //   293: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   299: invokeinterface 591 3 0
    //   304: pop
    //   305: aload_0
    //   306: astore 10
    //   308: aload_0
    //   309: astore 9
    //   311: aload 11
    //   313: ldc 198
    //   315: invokeinterface 594 2 0
    //   320: ifne +47 -> 367
    //   323: aload_0
    //   324: astore 10
    //   326: aload_0
    //   327: astore 9
    //   329: aload 11
    //   331: ldc 198
    //   333: new 75	java/lang/StringBuilder
    //   336: dup
    //   337: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   340: ldc 226
    //   342: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: aload_2
    //   346: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: ldc 228
    //   351: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   354: aload_3
    //   355: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   358: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   361: invokeinterface 591 3 0
    //   366: pop
    //   367: aload_0
    //   368: astore 10
    //   370: aload_0
    //   371: astore 9
    //   373: aload 11
    //   375: invokeinterface 597 1 0
    //   380: invokeinterface 479 1 0
    //   385: astore_2
    //   386: aload_0
    //   387: astore 10
    //   389: aload_0
    //   390: astore 9
    //   392: aload_2
    //   393: invokeinterface 484 1 0
    //   398: ifeq +141 -> 539
    //   401: aload_0
    //   402: astore 10
    //   404: aload_0
    //   405: astore 9
    //   407: aload_2
    //   408: invokeinterface 488 1 0
    //   413: checkcast 599	java/util/Map$Entry
    //   416: astore_3
    //   417: aload_0
    //   418: astore 10
    //   420: aload_0
    //   421: astore 9
    //   423: aload_0
    //   424: aload_3
    //   425: invokeinterface 602 1 0
    //   430: checkcast 314	java/lang/String
    //   433: aload_3
    //   434: invokeinterface 604 1 0
    //   439: checkcast 314	java/lang/String
    //   442: invokevirtual 576	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   445: goto -59 -> 386
    //   448: astore_3
    //   449: aconst_null
    //   450: astore_2
    //   451: aload 10
    //   453: astore_0
    //   454: aload_0
    //   455: astore 9
    //   457: ldc_w 464
    //   460: iconst_1
    //   461: new 75	java/lang/StringBuilder
    //   464: dup
    //   465: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   468: ldc_w 606
    //   471: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   474: aload_1
    //   475: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   478: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   481: aload_3
    //   482: invokestatic 609	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   485: aload_2
    //   486: astore_1
    //   487: aload_0
    //   488: ifnull +49 -> 537
    //   491: aload_0
    //   492: invokevirtual 610	java/net/HttpURLConnection:getResponseCode	()I
    //   495: istore 8
    //   497: invokestatic 462	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   500: ifeq +31 -> 531
    //   503: ldc_w 464
    //   506: iconst_2
    //   507: new 75	java/lang/StringBuilder
    //   510: dup
    //   511: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   514: ldc_w 612
    //   517: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   520: iload 8
    //   522: invokevirtual 210	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   525: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   528: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   531: aload_0
    //   532: invokevirtual 613	java/net/HttpURLConnection:disconnect	()V
    //   535: aload_2
    //   536: astore_1
    //   537: aload_1
    //   538: areturn
    //   539: aload_0
    //   540: astore 10
    //   542: aload_0
    //   543: astore 9
    //   545: new 615	java/io/DataOutputStream
    //   548: dup
    //   549: aload_0
    //   550: invokevirtual 619	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   553: invokespecial 622	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   556: astore_3
    //   557: aload 4
    //   559: ifnull +269 -> 828
    //   562: aload_0
    //   563: astore 10
    //   565: aload_0
    //   566: astore 9
    //   568: new 624	java/lang/StringBuffer
    //   571: dup
    //   572: invokespecial 625	java/lang/StringBuffer:<init>	()V
    //   575: astore_2
    //   576: aload_0
    //   577: astore 10
    //   579: aload_0
    //   580: astore 9
    //   582: aload 4
    //   584: invokeinterface 597 1 0
    //   589: invokeinterface 479 1 0
    //   594: astore 4
    //   596: aload_0
    //   597: astore 10
    //   599: aload_0
    //   600: astore 9
    //   602: aload 4
    //   604: invokeinterface 484 1 0
    //   609: ifeq +202 -> 811
    //   612: aload_0
    //   613: astore 10
    //   615: aload_0
    //   616: astore 9
    //   618: aload 4
    //   620: invokeinterface 488 1 0
    //   625: checkcast 599	java/util/Map$Entry
    //   628: astore 11
    //   630: aload_0
    //   631: astore 10
    //   633: aload_0
    //   634: astore 9
    //   636: aload 11
    //   638: invokeinterface 602 1 0
    //   643: checkcast 314	java/lang/String
    //   646: astore 6
    //   648: aload_0
    //   649: astore 10
    //   651: aload_0
    //   652: astore 9
    //   654: aload 11
    //   656: invokeinterface 604 1 0
    //   661: checkcast 314	java/lang/String
    //   664: astore 11
    //   666: aload 11
    //   668: ifnull -72 -> 596
    //   671: aload_0
    //   672: astore 10
    //   674: aload_0
    //   675: astore 9
    //   677: aload_2
    //   678: ldc_w 627
    //   681: invokevirtual 630	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   684: ldc_w 632
    //   687: invokevirtual 630	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   690: ldc_w 582
    //   693: invokevirtual 630	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   696: ldc_w 627
    //   699: invokevirtual 630	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   702: pop
    //   703: aload_0
    //   704: astore 10
    //   706: aload_0
    //   707: astore 9
    //   709: aload_2
    //   710: new 75	java/lang/StringBuilder
    //   713: dup
    //   714: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   717: ldc_w 634
    //   720: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   723: aload 6
    //   725: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   728: ldc_w 636
    //   731: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   734: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   737: invokevirtual 630	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   740: pop
    //   741: aload_0
    //   742: astore 10
    //   744: aload_0
    //   745: astore 9
    //   747: aload_2
    //   748: aload 11
    //   750: invokevirtual 630	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   753: pop
    //   754: goto -158 -> 596
    //   757: astore_0
    //   758: aload 9
    //   760: ifnull +49 -> 809
    //   763: aload 9
    //   765: invokevirtual 610	java/net/HttpURLConnection:getResponseCode	()I
    //   768: istore 8
    //   770: invokestatic 462	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   773: ifeq +31 -> 804
    //   776: ldc_w 464
    //   779: iconst_2
    //   780: new 75	java/lang/StringBuilder
    //   783: dup
    //   784: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   787: ldc_w 612
    //   790: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   793: iload 8
    //   795: invokevirtual 210	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   798: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   801: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   804: aload 9
    //   806: invokevirtual 613	java/net/HttpURLConnection:disconnect	()V
    //   809: aload_0
    //   810: athrow
    //   811: aload_0
    //   812: astore 10
    //   814: aload_0
    //   815: astore 9
    //   817: aload_3
    //   818: aload_2
    //   819: invokevirtual 637	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   822: invokevirtual 641	java/lang/String:getBytes	()[B
    //   825: invokevirtual 646	java/io/OutputStream:write	([B)V
    //   828: aload 5
    //   830: ifnull +529 -> 1359
    //   833: aload_0
    //   834: astore 10
    //   836: aload_0
    //   837: astore 9
    //   839: aload 5
    //   841: invokeinterface 597 1 0
    //   846: invokeinterface 479 1 0
    //   851: astore 4
    //   853: aload_0
    //   854: astore 10
    //   856: aload_0
    //   857: astore 9
    //   859: aload 4
    //   861: invokeinterface 484 1 0
    //   866: ifeq +493 -> 1359
    //   869: aload_0
    //   870: astore 10
    //   872: aload_0
    //   873: astore 9
    //   875: aload 4
    //   877: invokeinterface 488 1 0
    //   882: checkcast 599	java/util/Map$Entry
    //   885: astore_2
    //   886: aload_0
    //   887: astore 10
    //   889: aload_0
    //   890: astore 9
    //   892: aload_2
    //   893: invokeinterface 602 1 0
    //   898: checkcast 314	java/lang/String
    //   901: astore 6
    //   903: aload_0
    //   904: astore 10
    //   906: aload_0
    //   907: astore 9
    //   909: aload_2
    //   910: invokeinterface 604 1 0
    //   915: checkcast 314	java/lang/String
    //   918: astore_2
    //   919: aload_2
    //   920: ifnull -67 -> 853
    //   923: aload_0
    //   924: astore 10
    //   926: aload_0
    //   927: astore 9
    //   929: new 648	java/io/File
    //   932: dup
    //   933: aload_2
    //   934: invokespecial 649	java/io/File:<init>	(Ljava/lang/String;)V
    //   937: astore 5
    //   939: aload_0
    //   940: astore 10
    //   942: aload_0
    //   943: astore 9
    //   945: aload 5
    //   947: invokevirtual 652	java/io/File:getName	()Ljava/lang/String;
    //   950: astore 11
    //   952: aload_0
    //   953: astore 10
    //   955: aload_0
    //   956: astore 9
    //   958: aload 11
    //   960: ldc_w 654
    //   963: invokevirtual 657	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   966: ifeq +3 -> 969
    //   969: ldc_w 659
    //   972: astore_2
    //   973: ldc_w 659
    //   976: ifnull +640 -> 1616
    //   979: aload_0
    //   980: astore 10
    //   982: aload_0
    //   983: astore 9
    //   985: ldc_w 659
    //   988: ldc 218
    //   990: invokevirtual 426	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   993: ifeq +6 -> 999
    //   996: goto +620 -> 1616
    //   999: aload_0
    //   1000: astore 10
    //   1002: aload_0
    //   1003: astore 9
    //   1005: new 624	java/lang/StringBuffer
    //   1008: dup
    //   1009: invokespecial 625	java/lang/StringBuffer:<init>	()V
    //   1012: astore 12
    //   1014: aload_0
    //   1015: astore 10
    //   1017: aload_0
    //   1018: astore 9
    //   1020: aload 12
    //   1022: ldc_w 627
    //   1025: invokevirtual 630	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1028: ldc_w 632
    //   1031: invokevirtual 630	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1034: ldc_w 582
    //   1037: invokevirtual 630	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1040: ldc_w 627
    //   1043: invokevirtual 630	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1046: pop
    //   1047: aload_0
    //   1048: astore 10
    //   1050: aload_0
    //   1051: astore 9
    //   1053: aload 12
    //   1055: new 75	java/lang/StringBuilder
    //   1058: dup
    //   1059: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   1062: ldc_w 634
    //   1065: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1068: aload 6
    //   1070: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1073: ldc_w 661
    //   1076: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1079: aload 11
    //   1081: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1084: ldc_w 663
    //   1087: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1090: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1093: invokevirtual 630	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1096: pop
    //   1097: aload_0
    //   1098: astore 10
    //   1100: aload_0
    //   1101: astore 9
    //   1103: aload 12
    //   1105: new 75	java/lang/StringBuilder
    //   1108: dup
    //   1109: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   1112: ldc_w 665
    //   1115: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1118: aload_2
    //   1119: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1122: ldc_w 667
    //   1125: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1128: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1131: invokevirtual 630	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1134: pop
    //   1135: aload_0
    //   1136: astore 10
    //   1138: aload_0
    //   1139: astore 9
    //   1141: aload_3
    //   1142: aload 12
    //   1144: invokevirtual 637	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   1147: invokevirtual 641	java/lang/String:getBytes	()[B
    //   1150: invokevirtual 646	java/io/OutputStream:write	([B)V
    //   1153: aload_0
    //   1154: astore 10
    //   1156: aload_0
    //   1157: astore 9
    //   1159: new 669	java/io/BufferedInputStream
    //   1162: dup
    //   1163: new 669	java/io/BufferedInputStream
    //   1166: dup
    //   1167: new 671	java/io/FileInputStream
    //   1170: dup
    //   1171: aload 5
    //   1173: invokespecial 674	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   1176: invokespecial 675	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   1179: invokespecial 675	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   1182: astore_2
    //   1183: aload_0
    //   1184: astore 10
    //   1186: aload_0
    //   1187: astore 9
    //   1189: sipush 3072
    //   1192: newarray byte
    //   1194: astore 6
    //   1196: aload_2
    //   1197: aload 6
    //   1199: invokevirtual 676	java/io/BufferedInputStream:read	([B)I
    //   1202: istore 8
    //   1204: iload 8
    //   1206: iconst_m1
    //   1207: if_icmpeq +105 -> 1312
    //   1210: aload_3
    //   1211: aload 6
    //   1213: iconst_0
    //   1214: iload 8
    //   1216: invokevirtual 677	java/io/OutputStream:write	([BII)V
    //   1219: goto -23 -> 1196
    //   1222: astore 4
    //   1224: ldc_w 464
    //   1227: iconst_1
    //   1228: iconst_4
    //   1229: anewarray 4	java/lang/Object
    //   1232: dup
    //   1233: iconst_0
    //   1234: ldc_w 679
    //   1237: aastore
    //   1238: dup
    //   1239: iconst_1
    //   1240: aload 5
    //   1242: invokevirtual 683	java/io/File:length	()J
    //   1245: invokestatic 688	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1248: aastore
    //   1249: dup
    //   1250: iconst_2
    //   1251: ldc_w 690
    //   1254: aastore
    //   1255: dup
    //   1256: iconst_3
    //   1257: aload 5
    //   1259: invokevirtual 693	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1262: aastore
    //   1263: invokestatic 548	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   1266: aload_3
    //   1267: invokevirtual 696	java/io/OutputStream:flush	()V
    //   1270: aload_3
    //   1271: invokevirtual 697	java/io/OutputStream:close	()V
    //   1274: aload_0
    //   1275: invokevirtual 613	java/net/HttpURLConnection:disconnect	()V
    //   1278: aconst_null
    //   1279: astore 9
    //   1281: aconst_null
    //   1282: astore 10
    //   1284: aconst_null
    //   1285: astore_0
    //   1286: aload_2
    //   1287: invokevirtual 698	java/io/BufferedInputStream:close	()V
    //   1290: aload_0
    //   1291: astore_1
    //   1292: iconst_0
    //   1293: ifeq -756 -> 537
    //   1296: new 700	java/lang/NullPointerException
    //   1299: dup
    //   1300: invokespecial 701	java/lang/NullPointerException:<init>	()V
    //   1303: athrow
    //   1304: new 700	java/lang/NullPointerException
    //   1307: dup
    //   1308: invokespecial 701	java/lang/NullPointerException:<init>	()V
    //   1311: athrow
    //   1312: aload_0
    //   1313: astore 10
    //   1315: aload_0
    //   1316: astore 9
    //   1318: aload_2
    //   1319: invokevirtual 698	java/io/BufferedInputStream:close	()V
    //   1322: goto -469 -> 853
    //   1325: astore_0
    //   1326: ldc_w 464
    //   1329: iconst_1
    //   1330: ldc_w 703
    //   1333: aload_0
    //   1334: invokestatic 609	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1337: goto -33 -> 1304
    //   1340: astore_3
    //   1341: aload_0
    //   1342: astore 10
    //   1344: aload_0
    //   1345: astore 9
    //   1347: aload_2
    //   1348: invokevirtual 698	java/io/BufferedInputStream:close	()V
    //   1351: aload_0
    //   1352: astore 10
    //   1354: aload_0
    //   1355: astore 9
    //   1357: aload_3
    //   1358: athrow
    //   1359: aload_0
    //   1360: astore 10
    //   1362: aload_0
    //   1363: astore 9
    //   1365: aload_3
    //   1366: new 75	java/lang/StringBuilder
    //   1369: dup
    //   1370: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   1373: ldc_w 705
    //   1376: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1379: ldc_w 582
    //   1382: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1385: ldc_w 707
    //   1388: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1391: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1394: invokevirtual 641	java/lang/String:getBytes	()[B
    //   1397: invokevirtual 646	java/io/OutputStream:write	([B)V
    //   1400: aload_0
    //   1401: astore 10
    //   1403: aload_0
    //   1404: astore 9
    //   1406: aload_3
    //   1407: invokevirtual 696	java/io/OutputStream:flush	()V
    //   1410: aload_0
    //   1411: astore 10
    //   1413: aload_0
    //   1414: astore 9
    //   1416: aload_3
    //   1417: invokevirtual 697	java/io/OutputStream:close	()V
    //   1420: aload_0
    //   1421: astore 10
    //   1423: aload_0
    //   1424: astore 9
    //   1426: new 624	java/lang/StringBuffer
    //   1429: dup
    //   1430: invokespecial 625	java/lang/StringBuffer:<init>	()V
    //   1433: astore_2
    //   1434: aload_0
    //   1435: astore 10
    //   1437: aload_0
    //   1438: astore 9
    //   1440: new 238	java/io/BufferedReader
    //   1443: dup
    //   1444: new 240	java/io/InputStreamReader
    //   1447: dup
    //   1448: aload_0
    //   1449: invokevirtual 708	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   1452: invokespecial 247	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   1455: invokespecial 250	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   1458: astore_3
    //   1459: aload_0
    //   1460: astore 10
    //   1462: aload_0
    //   1463: astore 9
    //   1465: aload_3
    //   1466: invokevirtual 253	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   1469: astore 4
    //   1471: aload 4
    //   1473: ifnull +24 -> 1497
    //   1476: aload_0
    //   1477: astore 10
    //   1479: aload_0
    //   1480: astore 9
    //   1482: aload_2
    //   1483: aload 4
    //   1485: invokevirtual 630	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1488: ldc 255
    //   1490: invokevirtual 630	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1493: pop
    //   1494: goto -35 -> 1459
    //   1497: aload_0
    //   1498: astore 10
    //   1500: aload_0
    //   1501: astore 9
    //   1503: aload_2
    //   1504: invokevirtual 637	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   1507: astore_2
    //   1508: aload_0
    //   1509: astore 9
    //   1511: aload_3
    //   1512: invokevirtual 258	java/io/BufferedReader:close	()V
    //   1515: aload_2
    //   1516: astore_1
    //   1517: aload_0
    //   1518: ifnull -981 -> 537
    //   1521: aload_0
    //   1522: invokevirtual 610	java/net/HttpURLConnection:getResponseCode	()I
    //   1525: istore 8
    //   1527: invokestatic 462	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1530: ifeq +31 -> 1561
    //   1533: ldc_w 464
    //   1536: iconst_2
    //   1537: new 75	java/lang/StringBuilder
    //   1540: dup
    //   1541: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   1544: ldc_w 612
    //   1547: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1550: iload 8
    //   1552: invokevirtual 210	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1555: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1558: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1561: aload_0
    //   1562: invokevirtual 613	java/net/HttpURLConnection:disconnect	()V
    //   1565: aload_2
    //   1566: areturn
    //   1567: astore_1
    //   1568: ldc_w 464
    //   1571: iconst_1
    //   1572: ldc_w 703
    //   1575: aload_1
    //   1576: invokestatic 609	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1579: goto -18 -> 1561
    //   1582: astore_1
    //   1583: ldc_w 464
    //   1586: iconst_1
    //   1587: ldc_w 703
    //   1590: aload_1
    //   1591: invokestatic 609	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1594: goto -1063 -> 531
    //   1597: astore_1
    //   1598: ldc_w 464
    //   1601: iconst_1
    //   1602: ldc_w 703
    //   1605: aload_1
    //   1606: invokestatic 609	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1609: goto -805 -> 804
    //   1612: astore_3
    //   1613: goto -1159 -> 454
    //   1616: ldc_w 710
    //   1619: astore_2
    //   1620: goto -621 -> 999
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1623	0	paramHttpURLConnection	HttpURLConnection
    //   0	1623	1	paramString1	String
    //   0	1623	2	paramString2	String
    //   0	1623	3	paramString3	String
    //   0	1623	4	paramMap1	Map<String, String>
    //   0	1623	5	paramMap2	Map<String, String>
    //   0	1623	6	paramMap3	Map<String, String>
    //   0	1623	7	paramBoolean	boolean
    //   495	1056	8	i	int
    //   4	1506	9	localHttpURLConnection1	HttpURLConnection
    //   1	1498	10	localHttpURLConnection2	HttpURLConnection
    //   190	890	11	localObject	Object
    //   1012	131	12	localStringBuffer	java.lang.StringBuffer
    // Exception table:
    //   from	to	target	type
    //   6	13	448	java/lang/Exception
    //   19	26	448	java/lang/Exception
    //   32	37	448	java/lang/Exception
    //   43	48	448	java/lang/Exception
    //   54	59	448	java/lang/Exception
    //   65	72	448	java/lang/Exception
    //   78	86	448	java/lang/Exception
    //   92	153	448	java/lang/Exception
    //   159	188	448	java/lang/Exception
    //   203	212	448	java/lang/Exception
    //   223	246	448	java/lang/Exception
    //   252	260	448	java/lang/Exception
    //   266	305	448	java/lang/Exception
    //   311	323	448	java/lang/Exception
    //   329	367	448	java/lang/Exception
    //   373	386	448	java/lang/Exception
    //   392	401	448	java/lang/Exception
    //   407	417	448	java/lang/Exception
    //   423	445	448	java/lang/Exception
    //   545	557	448	java/lang/Exception
    //   568	576	448	java/lang/Exception
    //   582	596	448	java/lang/Exception
    //   602	612	448	java/lang/Exception
    //   618	630	448	java/lang/Exception
    //   636	648	448	java/lang/Exception
    //   654	666	448	java/lang/Exception
    //   677	703	448	java/lang/Exception
    //   709	741	448	java/lang/Exception
    //   747	754	448	java/lang/Exception
    //   817	828	448	java/lang/Exception
    //   839	853	448	java/lang/Exception
    //   859	869	448	java/lang/Exception
    //   875	886	448	java/lang/Exception
    //   892	903	448	java/lang/Exception
    //   909	919	448	java/lang/Exception
    //   929	939	448	java/lang/Exception
    //   945	952	448	java/lang/Exception
    //   958	969	448	java/lang/Exception
    //   985	996	448	java/lang/Exception
    //   1005	1014	448	java/lang/Exception
    //   1020	1047	448	java/lang/Exception
    //   1053	1097	448	java/lang/Exception
    //   1103	1135	448	java/lang/Exception
    //   1141	1153	448	java/lang/Exception
    //   1159	1183	448	java/lang/Exception
    //   1189	1196	448	java/lang/Exception
    //   1286	1290	448	java/lang/Exception
    //   1318	1322	448	java/lang/Exception
    //   1347	1351	448	java/lang/Exception
    //   1357	1359	448	java/lang/Exception
    //   1365	1400	448	java/lang/Exception
    //   1406	1410	448	java/lang/Exception
    //   1416	1420	448	java/lang/Exception
    //   1426	1434	448	java/lang/Exception
    //   1440	1459	448	java/lang/Exception
    //   1465	1471	448	java/lang/Exception
    //   1482	1494	448	java/lang/Exception
    //   1503	1508	448	java/lang/Exception
    //   6	13	757	finally
    //   19	26	757	finally
    //   32	37	757	finally
    //   43	48	757	finally
    //   54	59	757	finally
    //   65	72	757	finally
    //   78	86	757	finally
    //   92	153	757	finally
    //   159	188	757	finally
    //   203	212	757	finally
    //   223	246	757	finally
    //   252	260	757	finally
    //   266	305	757	finally
    //   311	323	757	finally
    //   329	367	757	finally
    //   373	386	757	finally
    //   392	401	757	finally
    //   407	417	757	finally
    //   423	445	757	finally
    //   457	485	757	finally
    //   545	557	757	finally
    //   568	576	757	finally
    //   582	596	757	finally
    //   602	612	757	finally
    //   618	630	757	finally
    //   636	648	757	finally
    //   654	666	757	finally
    //   677	703	757	finally
    //   709	741	757	finally
    //   747	754	757	finally
    //   817	828	757	finally
    //   839	853	757	finally
    //   859	869	757	finally
    //   875	886	757	finally
    //   892	903	757	finally
    //   909	919	757	finally
    //   929	939	757	finally
    //   945	952	757	finally
    //   958	969	757	finally
    //   985	996	757	finally
    //   1005	1014	757	finally
    //   1020	1047	757	finally
    //   1053	1097	757	finally
    //   1103	1135	757	finally
    //   1141	1153	757	finally
    //   1159	1183	757	finally
    //   1189	1196	757	finally
    //   1286	1290	757	finally
    //   1318	1322	757	finally
    //   1347	1351	757	finally
    //   1357	1359	757	finally
    //   1365	1400	757	finally
    //   1406	1410	757	finally
    //   1416	1420	757	finally
    //   1426	1434	757	finally
    //   1440	1459	757	finally
    //   1465	1471	757	finally
    //   1482	1494	757	finally
    //   1503	1508	757	finally
    //   1511	1515	757	finally
    //   1196	1204	1222	java/lang/OutOfMemoryError
    //   1210	1219	1222	java/lang/OutOfMemoryError
    //   1296	1304	1325	java/lang/Exception
    //   1196	1204	1340	finally
    //   1210	1219	1340	finally
    //   1224	1278	1340	finally
    //   1521	1561	1567	java/lang/Exception
    //   491	531	1582	java/lang/Exception
    //   763	804	1597	java/lang/Exception
    //   1511	1515	1612	java/lang/Exception
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
              break label328;
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
      label328:
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
        localObject1 = a(BaseApplication.getContext(), MsfSdkUtils.insertMtype("AppDepart", "https://openmobile.qq.com/api/shortUrl"), "POST", (Bundle)localObject4, (Bundle)localObject3);
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
            break label662;
          }
          QLog.d("HttpUtil", 2, "shortenUrl error retcode:" + i);
          break label662;
        }
        paramBundle = ((JSONObject)localObject1).getJSONObject("result");
        if (paramBundle == null)
        {
          if (!QLog.isColorLevel()) {
            break label665;
          }
          QLog.d("HttpUtil", 2, "shortenUrl error result");
          break label665;
        }
        paramBundle = paramBundle.getJSONArray("list");
        if (paramBundle == null)
        {
          if (!QLog.isColorLevel()) {
            break label668;
          }
          QLog.d("HttpUtil", 2, "shortenUrl error result");
          break label668;
        }
        if (paramBundle.length() == localArrayList.size())
        {
          i = 0;
          if (i < paramBundle.length())
          {
            localObject1 = paramBundle.getString(i);
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              break label671;
            }
            localHashMap.put(localArrayList.get(i), localObject1);
            break label671;
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
      label662:
      return localHashMap;
      label665:
      return localHashMap;
      label668:
      return localHashMap;
      label671:
      i += 1;
    }
  }
  
  public static nnv a(Context paramContext)
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
    if (bhnv.a((NetworkInfo)localObject))
    {
      localObject = a(paramContext);
      int i = a(paramContext);
      if ((!b((String)localObject)) && (i >= 0)) {
        return new nnv((String)localObject, i, null);
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
      zyx.a(paramContext, zyx.c);
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
        localObject = new kzm((KeyStore)localObject);
        ((SSLSocketFactory)localObject).setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
        if (!TextUtils.isEmpty(paramString)) {
          ((SSLSocketFactory)localObject).setHostnameVerifier(new nns(paramString));
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
        paramContext = new HttpHost(((nnv)localObject).jdField_a_of_type_JavaLangString, ((nnv)localObject).jdField_a_of_type_Int);
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
        while (str2.equals(zyx.c))
        {
          str1 = zyx.a(paramContext, str2);
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
          if (!str.equals(zyx.c)) {
            continue;
          }
          paramString3 = zyx.a(paramContext, str);
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
  
  public static int b()
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
    return 6;
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
 * Qualified Name:     nnr
 * JD-Core Version:    0.7.0.1
 */