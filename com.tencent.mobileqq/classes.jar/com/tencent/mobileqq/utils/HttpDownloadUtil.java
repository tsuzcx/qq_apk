package com.tencent.mobileqq.utils;

import android.net.NetworkInfo;
import android.os.Build.VERSION;
import com.tencent.mobileqq.emoticon.DownloadInfo;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qqutils.api.IQQUtilsApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.TlsSniSocketFactory;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import mqq.app.AppRuntime;
import org.apache.http.Header;
import org.apache.http.HttpVersion;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpProtocolParams;

public class HttpDownloadUtil
{
  public static final int DOWNLOAD_CONNECT_EXCEPTION = 17;
  public static final int DOWNLOAD_DATA_LOSSY = 8;
  @Deprecated
  public static final int DOWNLOAD_ENCRYPT_EXCEPTION = 7;
  public static final int DOWNLOAD_EOF_EXCEPTION = 19;
  public static final int DOWNLOAD_EXCEPTION = 5;
  public static final int DOWNLOAD_HEADER_XERRNO_PARSE_FAILED = 32;
  public static final int DOWNLOAD_HTTP_CONNECT_TIMEOUT = 2;
  public static final int DOWNLOAD_HTTP_RETRY_EXCEPTION = 18;
  public static final int DOWNLOAD_HTTP_SO_TIMEOUT = 3;
  public static final int DOWNLOAD_IS_HTML = 15;
  public static final int DOWNLOAD_LOCAL_FILESYSTEM_FAIL = 12;
  public static final int DOWNLOAD_NETWORK_FAIL = 1;
  public static final int DOWNLOAD_NETWORK_UNUSABLE = 9;
  public static final int DOWNLOAD_REDIRECT_ERROR = 20;
  public static final int DOWNLOAD_SAVE_FILE_FAIL = 4;
  public static final int DOWNLOAD_SC_NOT_MODIFIED = 16;
  public static final int DOWNLOAD_SOCKET_EXCEPTION = 11;
  public static final int DOWNLOAD_STORGE_EXCEPTION = 33;
  public static final int DOWNLOAD_SUCCESS = 0;
  public static final int DOWNLOAD_UNKNOWN_HOST = 10;
  public static final int DOWNLOAD_URL_RESP_NO_OK = 14;
  public static final int DOWNLOAD_URL_STRING_ILLEGAL = 13;
  public static final int DOWNLOAD_USER_CANCEL = 6;
  public static final int DOWNLOAD_VERIFY_LOST_KEY = 30;
  public static final int DOWNLOAD_VERIFY_UNMATCH_KEY = 31;
  public static final int FRIEND_PROFILE_IMAGE_AVATAR_HTTP_DOWNLOAD_ACTION = 10001;
  public static final int MAX_RETRY_DOWNLOAD_COUNT = 2;
  public static final int MAX_RETRY_DOWNLOAD_COUNT_EMOSM = 2;
  public static String PROTOCOL_HTTPS;
  public static final int RESOURCE_EXIST = 19;
  public static final String TAG = "HttpDownloadUtil";
  public static final int UNZIP_FAIL = 17;
  public static final int UNZIP_SUCCESS = 18;
  public static final DefaultHttpClient client;
  private static boolean forceDirect;
  private static boolean forceDomain;
  static HttpDownloadUtil.IdleConnectionMonitorThread idleConnectionMonitorThread;
  private static String lastApn;
  static long lastUseTime = ;
  private static boolean sShutdownSniSupport;
  private static boolean sShutdownSniSupportInited;
  
  static
  {
    BasicHttpParams localBasicHttpParams = new BasicHttpParams();
    HttpProtocolParams.setVersion(localBasicHttpParams, HttpVersion.HTTP_1_1);
    HttpProtocolParams.setContentCharset(localBasicHttpParams, "ISO-8859-1");
    HttpProtocolParams.setUseExpectContinue(localBasicHttpParams, true);
    Object localObject = new SchemeRegistry();
    ((SchemeRegistry)localObject).register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
    for (;;)
    {
      try
      {
        if ((Build.VERSION.SDK_INT < 23) && (!shutdownSniSupport())) {
          continue;
        }
        SSLSocketFactory localSSLSocketFactory = SSLSocketFactory.getSocketFactory();
        localSSLSocketFactory.setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
        ((SchemeRegistry)localObject).register(new Scheme("https", localSSLSocketFactory, 443));
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("HttpDownloadUtil", 2, "createHttpClient():Can't support https on this devices.", localException);
        continue;
      }
      localObject = new ThreadSafeClientConnManager(localBasicHttpParams, (SchemeRegistry)localObject);
      client = new DefaultHttpClient((ClientConnectionManager)localObject, localBasicHttpParams);
      client.setHttpRequestRetryHandler(new DefaultHttpRequestRetryHandler());
      idleConnectionMonitorThread = new HttpDownloadUtil.IdleConnectionMonitorThread((ClientConnectionManager)localObject);
      idleConnectionMonitorThread.setName("IdleConnectionMonitorThread");
      idleConnectionMonitorThread.start();
      lastApn = null;
      forceDirect = false;
      forceDomain = false;
      PROTOCOL_HTTPS = "https://";
      return;
      ((SchemeRegistry)localObject).register(new Scheme("https", new TlsSniSocketFactory(HttpDownloadUtil.class.getSimpleName()), 443));
    }
  }
  
  private static boolean checkValid(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo == null) {
      if (QLog.isColorLevel()) {
        QLog.d("HttpDownloadUtil", 2, "DownloadInfo is null.");
      }
    }
    do
    {
      return false;
      if (paramDownloadInfo.file != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("HttpDownloadUtil", 2, "DownloadInfo.file is null.");
    return false;
    return true;
  }
  
  static void copyRespHeader(HttpURLConnection paramHttpURLConnection, DownloadInfo paramDownloadInfo)
  {
    if ((paramHttpURLConnection == null) || (paramDownloadInfo == null)) {}
    do
    {
      return;
      if (paramHttpURLConnection.getHeaderField("X-FailNo") != null) {
        paramDownloadInfo.respXFailNo = paramHttpURLConnection.getHeaderField("X-FailNo");
      }
    } while (paramHttpURLConnection.getHeaderField("X-ErrNo") == null);
    paramDownloadInfo.respXErrNo = paramHttpURLConnection.getHeaderField("X-ErrNo");
  }
  
  /* Error */
  private static int download(AppRuntime paramAppRuntime, DownloadInfo paramDownloadInfo, NetworkInfo paramNetworkInfo, HttpDownloadUtil.HttpDownloadListener paramHttpDownloadListener)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 277	com/tencent/mobileqq/utils/HttpDownloadUtil:checkValid	(Lcom/tencent/mobileqq/emoticon/DownloadInfo;)Z
    //   4: ifne +9 -> 13
    //   7: iconst_5
    //   8: istore 6
    //   10: iload 6
    //   12: ireturn
    //   13: new 279	java/net/URL
    //   16: dup
    //   17: aload_1
    //   18: getfield 282	com/tencent/mobileqq/emoticon/DownloadInfo:reqUrl	Ljava/lang/String;
    //   21: invokespecial 283	java/net/URL:<init>	(Ljava/lang/String;)V
    //   24: astore 26
    //   26: invokestatic 90	java/lang/System:currentTimeMillis	()J
    //   29: lstore 12
    //   31: new 4	java/lang/Object
    //   34: dup
    //   35: invokespecial 231	java/lang/Object:<init>	()V
    //   38: astore 27
    //   40: aload_1
    //   41: getfield 245	com/tencent/mobileqq/emoticon/DownloadInfo:file	Ljava/io/File;
    //   44: invokevirtual 289	java/io/File:getParentFile	()Ljava/io/File;
    //   47: astore_0
    //   48: aload_0
    //   49: ifnull +139 -> 188
    //   52: aload_0
    //   53: invokevirtual 292	java/io/File:exists	()Z
    //   56: ifne +132 -> 188
    //   59: aload_0
    //   60: invokevirtual 295	java/io/File:mkdirs	()Z
    //   63: ifne +125 -> 188
    //   66: aload_3
    //   67: ifnull +15 -> 82
    //   70: aload_3
    //   71: aload 26
    //   73: invokevirtual 298	java/net/URL:toString	()Ljava/lang/String;
    //   76: iconst_4
    //   77: invokeinterface 304 3 0
    //   82: invokestatic 223	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   85: ifeq +32 -> 117
    //   88: ldc 66
    //   90: iconst_2
    //   91: new 306	java/lang/StringBuilder
    //   94: dup
    //   95: invokespecial 307	java/lang/StringBuilder:<init>	()V
    //   98: ldc_w 309
    //   101: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: aload_1
    //   105: getfield 282	com/tencent/mobileqq/emoticon/DownloadInfo:reqUrl	Ljava/lang/String;
    //   108: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: invokevirtual 314	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   114: invokestatic 239	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   117: iconst_4
    //   118: ireturn
    //   119: astore_0
    //   120: aload_0
    //   121: invokevirtual 317	java/net/MalformedURLException:printStackTrace	()V
    //   124: aload_1
    //   125: aload_0
    //   126: invokestatic 323	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   129: putfield 326	com/tencent/mobileqq/emoticon/DownloadInfo:errorDetail	Ljava/lang/String;
    //   132: iconst_5
    //   133: ireturn
    //   134: astore_0
    //   135: aload_3
    //   136: ifnull +15 -> 151
    //   139: aload_3
    //   140: aload 26
    //   142: invokevirtual 298	java/net/URL:toString	()Ljava/lang/String;
    //   145: iconst_4
    //   146: invokeinterface 304 3 0
    //   151: invokestatic 223	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   154: ifeq +32 -> 186
    //   157: ldc 66
    //   159: iconst_2
    //   160: new 306	java/lang/StringBuilder
    //   163: dup
    //   164: invokespecial 307	java/lang/StringBuilder:<init>	()V
    //   167: ldc_w 309
    //   170: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: aload_1
    //   174: getfield 282	com/tencent/mobileqq/emoticon/DownloadInfo:reqUrl	Ljava/lang/String;
    //   177: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: invokevirtual 314	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   183: invokestatic 239	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   186: iconst_4
    //   187: ireturn
    //   188: aconst_null
    //   189: astore 18
    //   191: aload_1
    //   192: getfield 282	com/tencent/mobileqq/emoticon/DownloadInfo:reqUrl	Ljava/lang/String;
    //   195: astore_0
    //   196: new 328	org/apache/http/client/methods/HttpGet
    //   199: dup
    //   200: aload_0
    //   201: invokespecial 329	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   204: astore 25
    //   206: new 94	org/apache/http/params/BasicHttpParams
    //   209: dup
    //   210: invokespecial 97	org/apache/http/params/BasicHttpParams:<init>	()V
    //   213: astore 28
    //   215: aload 28
    //   217: ldc_w 331
    //   220: ldc_w 332
    //   223: invokestatic 337	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   226: invokeinterface 343 3 0
    //   231: pop
    //   232: aload 28
    //   234: ldc_w 345
    //   237: ldc_w 332
    //   240: invokestatic 337	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   243: invokeinterface 343 3 0
    //   248: pop
    //   249: invokestatic 350	android/net/Proxy:getDefaultHost	()Ljava/lang/String;
    //   252: astore_0
    //   253: invokestatic 354	android/net/Proxy:getDefaultPort	()I
    //   256: istore 5
    //   258: iconst_0
    //   259: istore 4
    //   261: aload_2
    //   262: ifnull +94 -> 356
    //   265: aload_2
    //   266: invokevirtual 359	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   269: astore 17
    //   271: aload_2
    //   272: invokestatic 365	com/tencent/mobileqq/utils/NetworkUtil:a	(Landroid/net/NetworkInfo;)Z
    //   275: ifeq +49 -> 324
    //   278: aload 17
    //   280: ifnull +14 -> 294
    //   283: aload 17
    //   285: ldc_w 367
    //   288: invokevirtual 371	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   291: ifeq +33 -> 324
    //   294: aload_0
    //   295: ifnull +29 -> 324
    //   298: iload 5
    //   300: ifle +24 -> 324
    //   303: aload 28
    //   305: ldc_w 373
    //   308: new 375	org/apache/http/HttpHost
    //   311: dup
    //   312: aload_0
    //   313: iload 5
    //   315: invokespecial 377	org/apache/http/HttpHost:<init>	(Ljava/lang/String;I)V
    //   318: invokeinterface 343 3 0
    //   323: pop
    //   324: aload_2
    //   325: invokestatic 365	com/tencent/mobileqq/utils/NetworkUtil:a	(Landroid/net/NetworkInfo;)Z
    //   328: ifeq +548 -> 876
    //   331: sipush 2048
    //   334: istore 4
    //   336: aload 28
    //   338: ldc_w 379
    //   341: iload 4
    //   343: invokeinterface 383 3 0
    //   348: pop
    //   349: aload 25
    //   351: aload 28
    //   353: invokevirtual 387	org/apache/http/client/methods/HttpGet:setParams	(Lorg/apache/http/params/HttpParams;)V
    //   356: new 285	java/io/File
    //   359: dup
    //   360: aload_1
    //   361: invokevirtual 390	com/tencent/mobileqq/emoticon/DownloadInfo:getLoadingTmpPath	()Ljava/lang/String;
    //   364: invokespecial 391	java/io/File:<init>	(Ljava/lang/String;)V
    //   367: astore 29
    //   369: aload 29
    //   371: invokevirtual 292	java/io/File:exists	()Z
    //   374: ifeq +9 -> 383
    //   377: aload 29
    //   379: invokevirtual 394	java/io/File:delete	()Z
    //   382: pop
    //   383: aconst_null
    //   384: astore_0
    //   385: iconst_m1
    //   386: istore 9
    //   388: iconst_5
    //   389: istore 10
    //   391: iload 9
    //   393: ifne +38 -> 431
    //   396: aload 28
    //   398: ldc_w 373
    //   401: new 375	org/apache/http/HttpHost
    //   404: dup
    //   405: aload 26
    //   407: invokevirtual 397	java/net/URL:getHost	()Ljava/lang/String;
    //   410: aload 26
    //   412: invokevirtual 400	java/net/URL:getPort	()I
    //   415: invokespecial 377	org/apache/http/HttpHost:<init>	(Ljava/lang/String;I)V
    //   418: invokeinterface 343 3 0
    //   423: pop
    //   424: aload 25
    //   426: aload 28
    //   428: invokevirtual 387	org/apache/http/client/methods/HttpGet:setParams	(Lorg/apache/http/params/HttpParams;)V
    //   431: aload 18
    //   433: astore 23
    //   435: aload_0
    //   436: astore 19
    //   438: iload 4
    //   440: istore 6
    //   442: aload 18
    //   444: astore 22
    //   446: aload_0
    //   447: astore 20
    //   449: iload 4
    //   451: istore 8
    //   453: aload 18
    //   455: astore 24
    //   457: aload_0
    //   458: astore 21
    //   460: iload 10
    //   462: istore 7
    //   464: getstatic 175	com/tencent/mobileqq/utils/HttpDownloadUtil:client	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   467: new 375	org/apache/http/HttpHost
    //   470: dup
    //   471: aload 26
    //   473: invokevirtual 397	java/net/URL:getHost	()Ljava/lang/String;
    //   476: invokespecial 401	org/apache/http/HttpHost:<init>	(Ljava/lang/String;)V
    //   479: aload 25
    //   481: invokevirtual 405	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/HttpHost;Lorg/apache/http/HttpRequest;)Lorg/apache/http/HttpResponse;
    //   484: astore 17
    //   486: aload 18
    //   488: astore 23
    //   490: aload_0
    //   491: astore 19
    //   493: iload 4
    //   495: istore 6
    //   497: aload 18
    //   499: astore 22
    //   501: aload_0
    //   502: astore 20
    //   504: iload 4
    //   506: istore 8
    //   508: aload 18
    //   510: astore 24
    //   512: aload_0
    //   513: astore 21
    //   515: iload 10
    //   517: istore 7
    //   519: aload 17
    //   521: invokeinterface 411 1 0
    //   526: astore 30
    //   528: aload 18
    //   530: astore 23
    //   532: aload_0
    //   533: astore 19
    //   535: iload 4
    //   537: istore 6
    //   539: aload 18
    //   541: astore 22
    //   543: aload_0
    //   544: astore 20
    //   546: iload 4
    //   548: istore 8
    //   550: aload 18
    //   552: astore 24
    //   554: aload_0
    //   555: astore 21
    //   557: iload 10
    //   559: istore 7
    //   561: aload 17
    //   563: invokeinterface 415 1 0
    //   568: pop
    //   569: aload 18
    //   571: astore 23
    //   573: aload_0
    //   574: astore 19
    //   576: iload 4
    //   578: istore 6
    //   580: aload 18
    //   582: astore 22
    //   584: aload_0
    //   585: astore 20
    //   587: iload 4
    //   589: istore 8
    //   591: aload 18
    //   593: astore 24
    //   595: aload_0
    //   596: astore 21
    //   598: iload 10
    //   600: istore 7
    //   602: aload 30
    //   604: invokeinterface 420 1 0
    //   609: istore 5
    //   611: aload_3
    //   612: ifnull +49 -> 661
    //   615: aload 18
    //   617: astore 23
    //   619: aload_0
    //   620: astore 19
    //   622: iload 4
    //   624: istore 6
    //   626: aload 18
    //   628: astore 22
    //   630: aload_0
    //   631: astore 20
    //   633: iload 4
    //   635: istore 8
    //   637: aload 18
    //   639: astore 24
    //   641: aload_0
    //   642: astore 21
    //   644: iload 10
    //   646: istore 7
    //   648: aload_3
    //   649: aload 26
    //   651: invokevirtual 298	java/net/URL:toString	()Ljava/lang/String;
    //   654: iload 5
    //   656: invokeinterface 422 3 0
    //   661: aload 18
    //   663: astore 23
    //   665: aload_0
    //   666: astore 19
    //   668: iload 4
    //   670: istore 6
    //   672: aload 18
    //   674: astore 22
    //   676: aload_0
    //   677: astore 20
    //   679: iload 4
    //   681: istore 8
    //   683: aload 18
    //   685: astore 24
    //   687: aload_0
    //   688: astore 21
    //   690: iload 10
    //   692: istore 7
    //   694: aload 17
    //   696: invokeinterface 426 1 0
    //   701: astore_0
    //   702: sipush 200
    //   705: iload 5
    //   707: if_icmpne +1198 -> 1905
    //   710: aload 18
    //   712: astore 23
    //   714: aload_0
    //   715: astore 19
    //   717: iload 4
    //   719: istore 6
    //   721: aload 18
    //   723: astore 22
    //   725: aload_0
    //   726: astore 20
    //   728: iload 4
    //   730: istore 8
    //   732: aload 18
    //   734: astore 24
    //   736: aload_0
    //   737: astore 21
    //   739: iload 10
    //   741: istore 7
    //   743: aload_0
    //   744: invokeinterface 431 1 0
    //   749: lstore 14
    //   751: aconst_null
    //   752: astore 19
    //   754: iconst_0
    //   755: istore 5
    //   757: new 433	java/io/FileOutputStream
    //   760: dup
    //   761: aload 29
    //   763: invokespecial 436	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   766: astore 17
    //   768: aload_0
    //   769: invokeinterface 440 1 0
    //   774: astore 18
    //   776: aload 18
    //   778: astore 19
    //   780: iload 4
    //   782: ifne +1636 -> 2418
    //   785: sipush 2048
    //   788: istore 4
    //   790: iload 4
    //   792: newarray byte
    //   794: astore 18
    //   796: iload 5
    //   798: i2l
    //   799: lload 14
    //   801: lcmp
    //   802: ifge +82 -> 884
    //   805: aload 19
    //   807: aload 18
    //   809: invokevirtual 446	java/io/InputStream:read	([B)I
    //   812: istore 6
    //   814: aload 17
    //   816: aload 18
    //   818: iconst_0
    //   819: iload 6
    //   821: invokevirtual 452	java/io/OutputStream:write	([BII)V
    //   824: iload 5
    //   826: iload 6
    //   828: iadd
    //   829: istore 5
    //   831: aload_3
    //   832: ifnull +1583 -> 2415
    //   835: aload_3
    //   836: aload 26
    //   838: invokevirtual 298	java/net/URL:toString	()Ljava/lang/String;
    //   841: lload 14
    //   843: iload 5
    //   845: i2l
    //   846: invokeinterface 455 6 0
    //   851: goto -55 -> 796
    //   854: astore 17
    //   856: new 328	org/apache/http/client/methods/HttpGet
    //   859: dup
    //   860: aload_0
    //   861: invokestatic 458	com/tencent/mobileqq/utils/HttpDownloadUtil:getEscapeSequence	(Ljava/lang/String;)Ljava/lang/String;
    //   864: invokespecial 329	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   867: astore 25
    //   869: goto -663 -> 206
    //   872: astore_0
    //   873: bipush 13
    //   875: ireturn
    //   876: sipush 4096
    //   879: istore 4
    //   881: goto -545 -> 336
    //   884: iload 5
    //   886: i2l
    //   887: lload 14
    //   889: lcmp
    //   890: ifne +540 -> 1430
    //   893: iconst_0
    //   894: istore 10
    //   896: iconst_0
    //   897: istore 11
    //   899: iconst_0
    //   900: istore 8
    //   902: iload 8
    //   904: istore 5
    //   906: iload 10
    //   908: istore 6
    //   910: iload 11
    //   912: istore 7
    //   914: invokestatic 223	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   917: ifeq +44 -> 961
    //   920: iload 10
    //   922: istore 6
    //   924: iload 11
    //   926: istore 7
    //   928: ldc 66
    //   930: iconst_2
    //   931: new 306	java/lang/StringBuilder
    //   934: dup
    //   935: invokespecial 307	java/lang/StringBuilder:<init>	()V
    //   938: ldc_w 460
    //   941: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   944: aload_1
    //   945: getfield 282	com/tencent/mobileqq/emoticon/DownloadInfo:reqUrl	Ljava/lang/String;
    //   948: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   951: invokevirtual 314	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   954: invokestatic 239	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   957: iload 8
    //   959: istore 5
    //   961: iload 5
    //   963: istore 6
    //   965: iload 5
    //   967: istore 7
    //   969: invokestatic 223	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   972: ifeq +53 -> 1025
    //   975: iload 5
    //   977: istore 6
    //   979: iload 5
    //   981: istore 7
    //   983: ldc_w 461
    //   986: iconst_2
    //   987: new 306	java/lang/StringBuilder
    //   990: dup
    //   991: invokespecial 307	java/lang/StringBuilder:<init>	()V
    //   994: ldc_w 463
    //   997: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1000: invokestatic 90	java/lang/System:currentTimeMillis	()J
    //   1003: invokevirtual 466	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1006: ldc_w 468
    //   1009: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1012: aload_1
    //   1013: getfield 282	com/tencent/mobileqq/emoticon/DownloadInfo:reqUrl	Ljava/lang/String;
    //   1016: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1019: invokevirtual 314	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1022: invokestatic 239	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1025: iload 5
    //   1027: istore 6
    //   1029: iload 5
    //   1031: istore 7
    //   1033: aload_1
    //   1034: getfield 471	com/tencent/mobileqq/emoticon/DownloadInfo:action	I
    //   1037: tableswitch	default:+1384 -> 2421, 10001:+553->1590
    //   1057: iconst_2
    //   1058: istore 6
    //   1060: iload 5
    //   1062: istore 7
    //   1064: aload_2
    //   1065: invokestatic 365	com/tencent/mobileqq/utils/NetworkUtil:a	(Landroid/net/NetworkInfo;)Z
    //   1068: ifeq +809 -> 1877
    //   1071: iload 5
    //   1073: istore 6
    //   1075: iload 5
    //   1077: istore 7
    //   1079: aload 29
    //   1081: invokestatic 90	java/lang/System:currentTimeMillis	()J
    //   1084: invokevirtual 475	java/io/File:setLastModified	(J)Z
    //   1087: pop
    //   1088: iload 5
    //   1090: istore 6
    //   1092: iload 5
    //   1094: istore 7
    //   1096: invokestatic 223	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1099: ifeq +66 -> 1165
    //   1102: iload 5
    //   1104: istore 6
    //   1106: iload 5
    //   1108: istore 7
    //   1110: ldc 66
    //   1112: iconst_2
    //   1113: new 306	java/lang/StringBuilder
    //   1116: dup
    //   1117: invokespecial 307	java/lang/StringBuilder:<init>	()V
    //   1120: ldc_w 477
    //   1123: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1126: invokestatic 90	java/lang/System:currentTimeMillis	()J
    //   1129: lload 12
    //   1131: lsub
    //   1132: invokevirtual 466	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1135: ldc_w 479
    //   1138: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1141: lload 14
    //   1143: invokevirtual 466	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1146: ldc_w 481
    //   1149: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1152: aload_1
    //   1153: getfield 282	com/tencent/mobileqq/emoticon/DownloadInfo:reqUrl	Ljava/lang/String;
    //   1156: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1159: invokevirtual 314	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1162: invokestatic 484	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1165: aload 19
    //   1167: ifnull +1245 -> 2412
    //   1170: iload 5
    //   1172: istore 7
    //   1174: iload 4
    //   1176: istore 6
    //   1178: aload 17
    //   1180: astore 20
    //   1182: iload 4
    //   1184: istore 8
    //   1186: aload 17
    //   1188: astore 21
    //   1190: aload 17
    //   1192: astore 22
    //   1194: aload 19
    //   1196: invokevirtual 487	java/io/InputStream:close	()V
    //   1199: iload 5
    //   1201: ifne +46 -> 1247
    //   1204: aload 17
    //   1206: astore 23
    //   1208: aload_0
    //   1209: astore 19
    //   1211: iload 4
    //   1213: istore 6
    //   1215: aload 17
    //   1217: astore 22
    //   1219: aload_0
    //   1220: astore 20
    //   1222: iload 4
    //   1224: istore 8
    //   1226: aload 17
    //   1228: astore 24
    //   1230: aload_0
    //   1231: astore 21
    //   1233: iload 5
    //   1235: istore 7
    //   1237: aload 29
    //   1239: aload_1
    //   1240: getfield 245	com/tencent/mobileqq/emoticon/DownloadInfo:file	Ljava/io/File;
    //   1243: invokevirtual 491	java/io/File:renameTo	(Ljava/io/File;)Z
    //   1246: pop
    //   1247: aload_3
    //   1248: ifnull +49 -> 1297
    //   1251: aload 17
    //   1253: astore 23
    //   1255: aload_0
    //   1256: astore 19
    //   1258: iload 4
    //   1260: istore 6
    //   1262: aload 17
    //   1264: astore 22
    //   1266: aload_0
    //   1267: astore 20
    //   1269: iload 4
    //   1271: istore 8
    //   1273: aload 17
    //   1275: astore 24
    //   1277: aload_0
    //   1278: astore 21
    //   1280: iload 5
    //   1282: istore 7
    //   1284: aload_3
    //   1285: aload 26
    //   1287: invokevirtual 298	java/net/URL:toString	()Ljava/lang/String;
    //   1290: iload 5
    //   1292: invokeinterface 304 3 0
    //   1297: aload_0
    //   1298: ifnull +9 -> 1307
    //   1301: aload_0
    //   1302: invokeinterface 494 1 0
    //   1307: aload 17
    //   1309: ifnull +1090 -> 2399
    //   1312: aload 17
    //   1314: invokevirtual 495	java/io/OutputStream:close	()V
    //   1317: aload 17
    //   1319: astore 19
    //   1321: aload_0
    //   1322: astore 18
    //   1324: iload 9
    //   1326: iconst_1
    //   1327: iadd
    //   1328: istore 9
    //   1330: invokestatic 223	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1333: ifeq +43 -> 1376
    //   1336: ldc 66
    //   1338: iconst_2
    //   1339: new 306	java/lang/StringBuilder
    //   1342: dup
    //   1343: invokespecial 307	java/lang/StringBuilder:<init>	()V
    //   1346: ldc_w 497
    //   1349: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1352: iload 5
    //   1354: invokevirtual 500	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1357: ldc_w 502
    //   1360: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1363: aload_1
    //   1364: getfield 282	com/tencent/mobileqq/emoticon/DownloadInfo:reqUrl	Ljava/lang/String;
    //   1367: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1370: invokevirtual 314	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1373: invokestatic 239	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1376: iload 9
    //   1378: iconst_2
    //   1379: if_icmpge +22 -> 1401
    //   1382: iload 5
    //   1384: ifeq +17 -> 1401
    //   1387: aload 27
    //   1389: monitorenter
    //   1390: aload 27
    //   1392: ldc2_w 503
    //   1395: invokevirtual 508	java/lang/Object:wait	(J)V
    //   1398: aload 27
    //   1400: monitorexit
    //   1401: iload 5
    //   1403: istore 6
    //   1405: iload 5
    //   1407: ifeq -1397 -> 10
    //   1410: iload 5
    //   1412: istore 6
    //   1414: iload 9
    //   1416: iconst_2
    //   1417: if_icmpge -1407 -> 10
    //   1420: aload 18
    //   1422: astore_0
    //   1423: aload 19
    //   1425: astore 18
    //   1427: goto -1039 -> 388
    //   1430: bipush 8
    //   1432: istore 8
    //   1434: iload 8
    //   1436: istore 6
    //   1438: iload 8
    //   1440: istore 7
    //   1442: invokestatic 223	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1445: ifeq +62 -> 1507
    //   1448: iload 8
    //   1450: istore 6
    //   1452: iload 8
    //   1454: istore 7
    //   1456: ldc 66
    //   1458: iconst_2
    //   1459: new 306	java/lang/StringBuilder
    //   1462: dup
    //   1463: invokespecial 307	java/lang/StringBuilder:<init>	()V
    //   1466: ldc_w 510
    //   1469: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1472: iload 5
    //   1474: invokevirtual 500	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1477: ldc_w 512
    //   1480: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1483: lload 14
    //   1485: invokevirtual 466	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1488: ldc_w 514
    //   1491: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1494: aload_1
    //   1495: getfield 282	com/tencent/mobileqq/emoticon/DownloadInfo:reqUrl	Ljava/lang/String;
    //   1498: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1501: invokevirtual 314	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1504: invokestatic 239	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1507: iload 8
    //   1509: istore 5
    //   1511: iload 8
    //   1513: istore 6
    //   1515: iload 8
    //   1517: istore 7
    //   1519: aload 29
    //   1521: invokevirtual 292	java/io/File:exists	()Z
    //   1524: ifeq -563 -> 961
    //   1527: iload 8
    //   1529: istore 6
    //   1531: iload 8
    //   1533: istore 7
    //   1535: aload 29
    //   1537: invokevirtual 394	java/io/File:delete	()Z
    //   1540: pop
    //   1541: iload 8
    //   1543: istore 5
    //   1545: goto -584 -> 961
    //   1548: astore 18
    //   1550: iload 6
    //   1552: istore 5
    //   1554: aload 18
    //   1556: instanceof 516
    //   1559: ifne +15 -> 1574
    //   1562: aload 18
    //   1564: instanceof 518
    //   1567: istore 16
    //   1569: iload 16
    //   1571: ifeq +309 -> 1880
    //   1574: iconst_3
    //   1575: istore 5
    //   1577: aload 19
    //   1579: ifnull +830 -> 2409
    //   1582: aload 19
    //   1584: invokevirtual 487	java/io/InputStream:close	()V
    //   1587: goto -388 -> 1199
    //   1590: iload 5
    //   1592: istore 6
    //   1594: iload 5
    //   1596: istore 7
    //   1598: aload_2
    //   1599: invokestatic 365	com/tencent/mobileqq/utils/NetworkUtil:a	(Landroid/net/NetworkInfo;)Z
    //   1602: ifeq +272 -> 1874
    //   1605: goto -534 -> 1071
    //   1608: astore 18
    //   1610: iload 7
    //   1612: istore 5
    //   1614: aload 19
    //   1616: ifnull +32 -> 1648
    //   1619: iload 5
    //   1621: istore 7
    //   1623: iload 4
    //   1625: istore 6
    //   1627: aload 17
    //   1629: astore 20
    //   1631: iload 4
    //   1633: istore 8
    //   1635: aload 17
    //   1637: astore 21
    //   1639: aload 17
    //   1641: astore 22
    //   1643: aload 19
    //   1645: invokevirtual 487	java/io/InputStream:close	()V
    //   1648: iload 5
    //   1650: istore 7
    //   1652: iload 4
    //   1654: istore 6
    //   1656: aload 17
    //   1658: astore 20
    //   1660: iload 4
    //   1662: istore 8
    //   1664: aload 17
    //   1666: astore 21
    //   1668: aload 17
    //   1670: astore 22
    //   1672: aload 18
    //   1674: athrow
    //   1675: astore 18
    //   1677: aload 20
    //   1679: astore 17
    //   1681: iload 7
    //   1683: istore 5
    //   1685: aload_0
    //   1686: astore 20
    //   1688: aload 17
    //   1690: astore 19
    //   1692: aload 18
    //   1694: invokevirtual 519	java/io/IOException:printStackTrace	()V
    //   1697: aload_0
    //   1698: astore 20
    //   1700: aload 17
    //   1702: astore 19
    //   1704: aload 18
    //   1706: instanceof 521
    //   1709: ifeq +260 -> 1969
    //   1712: bipush 10
    //   1714: istore 7
    //   1716: aload_0
    //   1717: astore 20
    //   1719: aload 17
    //   1721: astore 19
    //   1723: ldc 66
    //   1725: iconst_2
    //   1726: new 306	java/lang/StringBuilder
    //   1729: dup
    //   1730: invokespecial 307	java/lang/StringBuilder:<init>	()V
    //   1733: ldc_w 523
    //   1736: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1739: iload 7
    //   1741: invokevirtual 500	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1744: ldc_w 525
    //   1747: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1750: aload_1
    //   1751: getfield 282	com/tencent/mobileqq/emoticon/DownloadInfo:reqUrl	Ljava/lang/String;
    //   1754: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1757: ldc_w 527
    //   1760: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1763: aload 18
    //   1765: invokevirtual 530	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1768: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1771: invokevirtual 314	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1774: invokestatic 533	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1777: aload_3
    //   1778: ifnull +23 -> 1801
    //   1781: aload_0
    //   1782: astore 20
    //   1784: aload 17
    //   1786: astore 19
    //   1788: aload_3
    //   1789: aload 26
    //   1791: invokevirtual 298	java/net/URL:toString	()Ljava/lang/String;
    //   1794: iload 7
    //   1796: invokeinterface 304 3 0
    //   1801: aload_0
    //   1802: ifnull +9 -> 1811
    //   1805: aload_0
    //   1806: invokeinterface 494 1 0
    //   1811: aload_0
    //   1812: astore 18
    //   1814: iload 6
    //   1816: istore 4
    //   1818: aload 17
    //   1820: astore 19
    //   1822: iload 7
    //   1824: istore 5
    //   1826: aload 17
    //   1828: ifnull -504 -> 1324
    //   1831: aload 17
    //   1833: invokevirtual 495	java/io/OutputStream:close	()V
    //   1836: aload_0
    //   1837: astore 18
    //   1839: iload 6
    //   1841: istore 4
    //   1843: aload 17
    //   1845: astore 19
    //   1847: iload 7
    //   1849: istore 5
    //   1851: goto -527 -> 1324
    //   1854: astore 18
    //   1856: aload_0
    //   1857: astore 18
    //   1859: iload 6
    //   1861: istore 4
    //   1863: aload 17
    //   1865: astore 19
    //   1867: iload 7
    //   1869: istore 5
    //   1871: goto -547 -> 1324
    //   1874: goto -803 -> 1071
    //   1877: goto -806 -> 1071
    //   1880: aload 18
    //   1882: instanceof 535
    //   1885: istore 16
    //   1887: iload 16
    //   1889: ifeq +10 -> 1899
    //   1892: bipush 11
    //   1894: istore 5
    //   1896: goto -319 -> 1577
    //   1899: iconst_4
    //   1900: istore 5
    //   1902: goto -325 -> 1577
    //   1905: aload_3
    //   1906: ifnull +34 -> 1940
    //   1909: aload 18
    //   1911: astore 23
    //   1913: aload_0
    //   1914: astore 19
    //   1916: iload 4
    //   1918: istore 6
    //   1920: aload 18
    //   1922: astore 22
    //   1924: aload_0
    //   1925: astore 20
    //   1927: aload_3
    //   1928: aload 26
    //   1930: invokevirtual 298	java/net/URL:toString	()Ljava/lang/String;
    //   1933: iload 5
    //   1935: invokeinterface 304 3 0
    //   1940: aload 18
    //   1942: astore 17
    //   1944: goto -647 -> 1297
    //   1947: astore 18
    //   1949: aload 18
    //   1951: invokevirtual 519	java/io/IOException:printStackTrace	()V
    //   1954: goto -647 -> 1307
    //   1957: astore 18
    //   1959: aload_0
    //   1960: astore 18
    //   1962: aload 17
    //   1964: astore 19
    //   1966: goto -642 -> 1324
    //   1969: aload_0
    //   1970: astore 20
    //   1972: aload 17
    //   1974: astore 19
    //   1976: aload 18
    //   1978: instanceof 516
    //   1981: ifne +443 -> 2424
    //   1984: aload_0
    //   1985: astore 20
    //   1987: aload 17
    //   1989: astore 19
    //   1991: aload 18
    //   1993: instanceof 518
    //   1996: ifeq +6 -> 2002
    //   1999: goto +425 -> 2424
    //   2002: aload_0
    //   2003: astore 20
    //   2005: aload 17
    //   2007: astore 19
    //   2009: aload 18
    //   2011: instanceof 535
    //   2014: ifeq +23 -> 2037
    //   2017: aload_0
    //   2018: astore 20
    //   2020: aload 17
    //   2022: astore 19
    //   2024: aload_1
    //   2025: bipush 11
    //   2027: putfield 538	com/tencent/mobileqq/emoticon/DownloadInfo:resultCode	I
    //   2030: iload 5
    //   2032: istore 7
    //   2034: goto -318 -> 1716
    //   2037: iconst_4
    //   2038: istore 7
    //   2040: goto -324 -> 1716
    //   2043: astore 18
    //   2045: aload 18
    //   2047: invokevirtual 519	java/io/IOException:printStackTrace	()V
    //   2050: goto -239 -> 1811
    //   2053: astore 18
    //   2055: iload 8
    //   2057: istore 6
    //   2059: aload 21
    //   2061: astore 17
    //   2063: aload_0
    //   2064: astore 20
    //   2066: aload 17
    //   2068: astore 19
    //   2070: aload 18
    //   2072: invokevirtual 539	java/lang/Exception:printStackTrace	()V
    //   2075: iconst_5
    //   2076: istore 7
    //   2078: aload_3
    //   2079: ifnull +22 -> 2101
    //   2082: aload_0
    //   2083: astore 20
    //   2085: aload 17
    //   2087: astore 19
    //   2089: aload_3
    //   2090: aload 26
    //   2092: invokevirtual 298	java/net/URL:toString	()Ljava/lang/String;
    //   2095: iconst_5
    //   2096: invokeinterface 304 3 0
    //   2101: aload_0
    //   2102: ifnull +9 -> 2111
    //   2105: aload_0
    //   2106: invokeinterface 494 1 0
    //   2111: aload_0
    //   2112: astore 18
    //   2114: iload 6
    //   2116: istore 4
    //   2118: aload 17
    //   2120: astore 19
    //   2122: iload 7
    //   2124: istore 5
    //   2126: aload 17
    //   2128: ifnull -804 -> 1324
    //   2131: aload 17
    //   2133: invokevirtual 495	java/io/OutputStream:close	()V
    //   2136: aload_0
    //   2137: astore 18
    //   2139: iload 6
    //   2141: istore 4
    //   2143: aload 17
    //   2145: astore 19
    //   2147: iload 7
    //   2149: istore 5
    //   2151: goto -827 -> 1324
    //   2154: astore 18
    //   2156: aload_0
    //   2157: astore 18
    //   2159: iload 6
    //   2161: istore 4
    //   2163: aload 17
    //   2165: astore 19
    //   2167: iload 7
    //   2169: istore 5
    //   2171: goto -847 -> 1324
    //   2174: astore 18
    //   2176: aload 18
    //   2178: invokevirtual 519	java/io/IOException:printStackTrace	()V
    //   2181: goto -70 -> 2111
    //   2184: astore_1
    //   2185: aload 22
    //   2187: astore_2
    //   2188: aload_0
    //   2189: ifnull +9 -> 2198
    //   2192: aload_0
    //   2193: invokeinterface 494 1 0
    //   2198: aload_2
    //   2199: ifnull +7 -> 2206
    //   2202: aload_2
    //   2203: invokevirtual 495	java/io/OutputStream:close	()V
    //   2206: aload_1
    //   2207: athrow
    //   2208: astore_0
    //   2209: aload_0
    //   2210: invokevirtual 519	java/io/IOException:printStackTrace	()V
    //   2213: goto -15 -> 2198
    //   2216: astore_0
    //   2217: aload 27
    //   2219: monitorexit
    //   2220: aload_0
    //   2221: athrow
    //   2222: astore_0
    //   2223: goto -17 -> 2206
    //   2226: astore_0
    //   2227: goto -829 -> 1398
    //   2230: astore_1
    //   2231: aload 17
    //   2233: astore_2
    //   2234: goto -46 -> 2188
    //   2237: astore_1
    //   2238: aload 23
    //   2240: astore_2
    //   2241: aload 19
    //   2243: astore_0
    //   2244: goto -56 -> 2188
    //   2247: astore_1
    //   2248: aload 20
    //   2250: astore_0
    //   2251: aload 19
    //   2253: astore_2
    //   2254: goto -66 -> 2188
    //   2257: astore 18
    //   2259: iload 4
    //   2261: istore 6
    //   2263: goto -200 -> 2063
    //   2266: astore 18
    //   2268: aload 22
    //   2270: astore 17
    //   2272: aload 20
    //   2274: astore_0
    //   2275: goto -212 -> 2063
    //   2278: astore 18
    //   2280: iload 4
    //   2282: istore 6
    //   2284: goto -599 -> 1685
    //   2287: astore 18
    //   2289: iload 8
    //   2291: istore 6
    //   2293: aload 24
    //   2295: astore 17
    //   2297: aload 21
    //   2299: astore_0
    //   2300: iload 7
    //   2302: istore 5
    //   2304: goto -619 -> 1685
    //   2307: astore 19
    //   2309: aload 18
    //   2311: astore 17
    //   2313: aload 19
    //   2315: astore 18
    //   2317: iload 4
    //   2319: istore 6
    //   2321: goto -636 -> 1685
    //   2324: astore 18
    //   2326: iconst_5
    //   2327: istore 5
    //   2329: goto -715 -> 1614
    //   2332: astore 18
    //   2334: goto -720 -> 1614
    //   2337: astore 20
    //   2339: aconst_null
    //   2340: astore 19
    //   2342: aload 18
    //   2344: astore 17
    //   2346: iconst_5
    //   2347: istore 5
    //   2349: aload 20
    //   2351: astore 18
    //   2353: goto -739 -> 1614
    //   2356: astore 18
    //   2358: aconst_null
    //   2359: astore 19
    //   2361: iconst_5
    //   2362: istore 5
    //   2364: goto -750 -> 1614
    //   2367: astore 18
    //   2369: iconst_5
    //   2370: istore 5
    //   2372: goto -818 -> 1554
    //   2375: astore 20
    //   2377: aload 18
    //   2379: astore 17
    //   2381: iconst_5
    //   2382: istore 5
    //   2384: aload 20
    //   2386: astore 18
    //   2388: goto -834 -> 1554
    //   2391: astore 18
    //   2393: iconst_5
    //   2394: istore 5
    //   2396: goto -842 -> 1554
    //   2399: aload_0
    //   2400: astore 18
    //   2402: aload 17
    //   2404: astore 19
    //   2406: goto -1082 -> 1324
    //   2409: goto -1210 -> 1199
    //   2412: goto -1213 -> 1199
    //   2415: goto -1619 -> 796
    //   2418: goto -1628 -> 790
    //   2421: goto -1365 -> 1056
    //   2424: iconst_2
    //   2425: istore 7
    //   2427: goto -711 -> 1716
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2430	0	paramAppRuntime	AppRuntime
    //   0	2430	1	paramDownloadInfo	DownloadInfo
    //   0	2430	2	paramNetworkInfo	NetworkInfo
    //   0	2430	3	paramHttpDownloadListener	HttpDownloadUtil.HttpDownloadListener
    //   259	2059	4	i	int
    //   256	2139	5	j	int
    //   8	2312	6	k	int
    //   462	1964	7	m	int
    //   451	1839	8	n	int
    //   386	1032	9	i1	int
    //   389	532	10	i2	int
    //   897	28	11	i3	int
    //   29	1101	12	l1	long
    //   749	735	14	l2	long
    //   1567	321	16	bool	boolean
    //   269	546	17	localObject1	Object
    //   854	815	17	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   1679	724	17	localObject2	Object
    //   189	1237	18	localObject3	Object
    //   1548	15	18	localIOException1	java.io.IOException
    //   1608	65	18	localObject4	Object
    //   1675	89	18	localIOException2	java.io.IOException
    //   1812	26	18	localAppRuntime1	AppRuntime
    //   1854	1	18	localIOException3	java.io.IOException
    //   1857	84	18	localAppRuntime2	AppRuntime
    //   1947	3	18	localIOException4	java.io.IOException
    //   1957	1	18	localIOException5	java.io.IOException
    //   1960	50	18	localAppRuntime3	AppRuntime
    //   2043	3	18	localIOException6	java.io.IOException
    //   2053	18	18	localException1	Exception
    //   2112	26	18	localAppRuntime4	AppRuntime
    //   2154	1	18	localIOException7	java.io.IOException
    //   2157	1	18	localAppRuntime5	AppRuntime
    //   2174	3	18	localIOException8	java.io.IOException
    //   2257	1	18	localException2	Exception
    //   2266	1	18	localException3	Exception
    //   2278	1	18	localIOException9	java.io.IOException
    //   2287	23	18	localIOException10	java.io.IOException
    //   2315	1	18	localObject5	Object
    //   2324	1	18	localObject6	Object
    //   2332	11	18	localObject7	Object
    //   2351	1	18	localObject8	Object
    //   2356	1	18	localObject9	Object
    //   2367	11	18	localIOException11	java.io.IOException
    //   2386	1	18	localObject10	Object
    //   2391	1	18	localIOException12	java.io.IOException
    //   2400	1	18	localAppRuntime6	AppRuntime
    //   436	1816	19	localObject11	Object
    //   2307	7	19	localIOException13	java.io.IOException
    //   2340	65	19	localObject12	Object
    //   447	1826	20	localObject13	Object
    //   2337	13	20	localObject14	Object
    //   2375	10	20	localIOException14	java.io.IOException
    //   458	1840	21	localObject15	Object
    //   444	1825	22	localObject16	Object
    //   433	1806	23	localObject17	Object
    //   455	1839	24	localObject18	Object
    //   204	664	25	localHttpGet	org.apache.http.client.methods.HttpGet
    //   24	2067	26	localURL	URL
    //   38	2180	27	localObject19	Object
    //   213	214	28	localBasicHttpParams	BasicHttpParams
    //   367	1169	29	localFile	File
    //   526	77	30	localStatusLine	org.apache.http.StatusLine
    // Exception table:
    //   from	to	target	type
    //   13	26	119	java/net/MalformedURLException
    //   40	48	134	java/lang/Exception
    //   52	66	134	java/lang/Exception
    //   70	82	134	java/lang/Exception
    //   82	117	134	java/lang/Exception
    //   196	206	854	java/lang/IllegalArgumentException
    //   856	869	872	java/lang/IllegalArgumentException
    //   914	920	1548	java/io/IOException
    //   928	957	1548	java/io/IOException
    //   969	975	1548	java/io/IOException
    //   983	1025	1548	java/io/IOException
    //   1033	1056	1548	java/io/IOException
    //   1064	1071	1548	java/io/IOException
    //   1079	1088	1548	java/io/IOException
    //   1096	1102	1548	java/io/IOException
    //   1110	1165	1548	java/io/IOException
    //   1442	1448	1548	java/io/IOException
    //   1456	1507	1548	java/io/IOException
    //   1519	1527	1548	java/io/IOException
    //   1535	1541	1548	java/io/IOException
    //   1598	1605	1548	java/io/IOException
    //   914	920	1608	finally
    //   928	957	1608	finally
    //   969	975	1608	finally
    //   983	1025	1608	finally
    //   1033	1056	1608	finally
    //   1064	1071	1608	finally
    //   1079	1088	1608	finally
    //   1096	1102	1608	finally
    //   1110	1165	1608	finally
    //   1442	1448	1608	finally
    //   1456	1507	1608	finally
    //   1519	1527	1608	finally
    //   1535	1541	1608	finally
    //   1598	1605	1608	finally
    //   1194	1199	1675	java/io/IOException
    //   1643	1648	1675	java/io/IOException
    //   1672	1675	1675	java/io/IOException
    //   1831	1836	1854	java/io/IOException
    //   1301	1307	1947	java/io/IOException
    //   1312	1317	1957	java/io/IOException
    //   1805	1811	2043	java/io/IOException
    //   1194	1199	2053	java/lang/Exception
    //   1643	1648	2053	java/lang/Exception
    //   1672	1675	2053	java/lang/Exception
    //   2131	2136	2154	java/io/IOException
    //   2105	2111	2174	java/io/IOException
    //   1194	1199	2184	finally
    //   1643	1648	2184	finally
    //   1672	1675	2184	finally
    //   2192	2198	2208	java/io/IOException
    //   1390	1398	2216	finally
    //   1398	1401	2216	finally
    //   2217	2220	2216	finally
    //   2202	2206	2222	java/io/IOException
    //   1390	1398	2226	java/lang/InterruptedException
    //   1582	1587	2230	finally
    //   464	486	2237	finally
    //   519	528	2237	finally
    //   561	569	2237	finally
    //   602	611	2237	finally
    //   648	661	2237	finally
    //   694	702	2237	finally
    //   743	751	2237	finally
    //   1237	1247	2237	finally
    //   1284	1297	2237	finally
    //   1927	1940	2237	finally
    //   1692	1697	2247	finally
    //   1704	1712	2247	finally
    //   1723	1777	2247	finally
    //   1788	1801	2247	finally
    //   1976	1984	2247	finally
    //   1991	1999	2247	finally
    //   2009	2017	2247	finally
    //   2024	2030	2247	finally
    //   2070	2075	2247	finally
    //   2089	2101	2247	finally
    //   1582	1587	2257	java/lang/Exception
    //   464	486	2266	java/lang/Exception
    //   519	528	2266	java/lang/Exception
    //   561	569	2266	java/lang/Exception
    //   602	611	2266	java/lang/Exception
    //   648	661	2266	java/lang/Exception
    //   694	702	2266	java/lang/Exception
    //   743	751	2266	java/lang/Exception
    //   1237	1247	2266	java/lang/Exception
    //   1284	1297	2266	java/lang/Exception
    //   1927	1940	2266	java/lang/Exception
    //   1582	1587	2278	java/io/IOException
    //   464	486	2287	java/io/IOException
    //   519	528	2287	java/io/IOException
    //   561	569	2287	java/io/IOException
    //   602	611	2287	java/io/IOException
    //   648	661	2287	java/io/IOException
    //   694	702	2287	java/io/IOException
    //   743	751	2287	java/io/IOException
    //   1237	1247	2287	java/io/IOException
    //   1284	1297	2287	java/io/IOException
    //   1927	1940	2307	java/io/IOException
    //   790	796	2324	finally
    //   805	824	2324	finally
    //   835	851	2324	finally
    //   1554	1569	2332	finally
    //   1880	1887	2332	finally
    //   757	768	2337	finally
    //   768	776	2356	finally
    //   790	796	2367	java/io/IOException
    //   805	824	2367	java/io/IOException
    //   835	851	2367	java/io/IOException
    //   757	768	2375	java/io/IOException
    //   768	776	2391	java/io/IOException
  }
  
  public static int download(AppRuntime paramAppRuntime, URL paramURL, File paramFile, NetworkInfo paramNetworkInfo)
  {
    return download(paramAppRuntime, paramURL, paramFile, paramNetworkInfo, 2);
  }
  
  /* Error */
  private static int download(AppRuntime paramAppRuntime, URL paramURL, File paramFile, NetworkInfo paramNetworkInfo, int paramInt)
  {
    // Byte code:
    //   0: invokestatic 90	java/lang/System:currentTimeMillis	()J
    //   3: lstore 14
    //   5: iconst_5
    //   6: istore 5
    //   8: new 4	java/lang/Object
    //   11: dup
    //   12: invokespecial 231	java/lang/Object:<init>	()V
    //   15: astore 29
    //   17: aload_2
    //   18: ifnonnull +6 -> 24
    //   21: iload 5
    //   23: ireturn
    //   24: iload 4
    //   26: istore 6
    //   28: iload 4
    //   30: ifge +6 -> 36
    //   33: iconst_2
    //   34: istore 6
    //   36: aload_2
    //   37: invokevirtual 289	java/io/File:getParentFile	()Ljava/io/File;
    //   40: astore_0
    //   41: aload_0
    //   42: ifnull +15 -> 57
    //   45: aload_0
    //   46: invokevirtual 292	java/io/File:exists	()Z
    //   49: ifne +8 -> 57
    //   52: aload_0
    //   53: invokevirtual 295	java/io/File:mkdirs	()Z
    //   56: pop
    //   57: aconst_null
    //   58: astore_0
    //   59: aload_1
    //   60: invokevirtual 298	java/net/URL:toString	()Ljava/lang/String;
    //   63: astore 19
    //   65: new 328	org/apache/http/client/methods/HttpGet
    //   68: dup
    //   69: aload 19
    //   71: invokespecial 329	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   74: astore 27
    //   76: new 94	org/apache/http/params/BasicHttpParams
    //   79: dup
    //   80: invokespecial 97	org/apache/http/params/BasicHttpParams:<init>	()V
    //   83: astore 30
    //   85: sipush 20000
    //   88: istore 5
    //   90: ldc_w 332
    //   93: istore 4
    //   95: aload_3
    //   96: ifnull +105 -> 201
    //   99: invokestatic 350	android/net/Proxy:getDefaultHost	()Ljava/lang/String;
    //   102: astore 19
    //   104: invokestatic 354	android/net/Proxy:getDefaultPort	()I
    //   107: istore 4
    //   109: aload_3
    //   110: invokevirtual 359	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   113: astore 20
    //   115: aload_3
    //   116: invokestatic 365	com/tencent/mobileqq/utils/NetworkUtil:a	(Landroid/net/NetworkInfo;)Z
    //   119: ifeq +51 -> 170
    //   122: aload 20
    //   124: ifnull +14 -> 138
    //   127: aload 20
    //   129: ldc_w 367
    //   132: invokevirtual 371	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   135: ifeq +35 -> 170
    //   138: aload 19
    //   140: ifnull +30 -> 170
    //   143: iload 4
    //   145: ifle +25 -> 170
    //   148: aload 30
    //   150: ldc_w 373
    //   153: new 375	org/apache/http/HttpHost
    //   156: dup
    //   157: aload 19
    //   159: iload 4
    //   161: invokespecial 377	org/apache/http/HttpHost:<init>	(Ljava/lang/String;I)V
    //   164: invokeinterface 343 3 0
    //   169: pop
    //   170: aload_3
    //   171: invokestatic 365	com/tencent/mobileqq/utils/NetworkUtil:a	(Landroid/net/NetworkInfo;)Z
    //   174: ifeq +903 -> 1077
    //   177: sipush 20000
    //   180: istore 5
    //   182: ldc_w 332
    //   185: istore 4
    //   187: aload 30
    //   189: ldc_w 379
    //   192: sipush 2048
    //   195: invokeinterface 383 3 0
    //   200: pop
    //   201: aload 30
    //   203: ldc_w 331
    //   206: iload 5
    //   208: invokestatic 337	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   211: invokeinterface 343 3 0
    //   216: pop
    //   217: aload 30
    //   219: ldc_w 345
    //   222: iload 4
    //   224: invokestatic 337	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   227: invokeinterface 343 3 0
    //   232: pop
    //   233: aload 27
    //   235: aload 30
    //   237: invokevirtual 387	org/apache/http/client/methods/HttpGet:setParams	(Lorg/apache/http/params/HttpParams;)V
    //   240: aload_2
    //   241: invokevirtual 292	java/io/File:exists	()Z
    //   244: ifeq +8 -> 252
    //   247: aload_2
    //   248: invokevirtual 394	java/io/File:delete	()Z
    //   251: pop
    //   252: aconst_null
    //   253: astore 19
    //   255: iconst_m1
    //   256: istore 7
    //   258: aload_0
    //   259: astore_3
    //   260: aload 19
    //   262: astore_0
    //   263: iload 7
    //   265: ifne +36 -> 301
    //   268: aload 30
    //   270: ldc_w 373
    //   273: new 375	org/apache/http/HttpHost
    //   276: dup
    //   277: aload_1
    //   278: invokevirtual 397	java/net/URL:getHost	()Ljava/lang/String;
    //   281: aload_1
    //   282: invokevirtual 400	java/net/URL:getPort	()I
    //   285: invokespecial 377	org/apache/http/HttpHost:<init>	(Ljava/lang/String;I)V
    //   288: invokeinterface 343 3 0
    //   293: pop
    //   294: aload 27
    //   296: aload 30
    //   298: invokevirtual 387	org/apache/http/client/methods/HttpGet:setParams	(Lorg/apache/http/params/HttpParams;)V
    //   301: iconst_5
    //   302: istore 4
    //   304: aload_0
    //   305: astore 20
    //   307: aload_3
    //   308: astore 23
    //   310: aload_0
    //   311: astore 24
    //   313: aload_3
    //   314: astore 21
    //   316: aload_0
    //   317: astore 25
    //   319: aload_3
    //   320: astore 22
    //   322: aload_0
    //   323: astore 19
    //   325: aload_3
    //   326: astore 26
    //   328: getstatic 175	com/tencent/mobileqq/utils/HttpDownloadUtil:client	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   331: new 375	org/apache/http/HttpHost
    //   334: dup
    //   335: aload_1
    //   336: invokevirtual 397	java/net/URL:getHost	()Ljava/lang/String;
    //   339: invokespecial 401	org/apache/http/HttpHost:<init>	(Ljava/lang/String;)V
    //   342: aload 27
    //   344: invokevirtual 405	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/HttpHost;Lorg/apache/http/HttpRequest;)Lorg/apache/http/HttpResponse;
    //   347: astore 28
    //   349: aload_0
    //   350: astore 20
    //   352: aload_3
    //   353: astore 23
    //   355: aload_0
    //   356: astore 24
    //   358: aload_3
    //   359: astore 21
    //   361: aload_0
    //   362: astore 25
    //   364: aload_3
    //   365: astore 22
    //   367: aload_0
    //   368: astore 19
    //   370: aload_3
    //   371: astore 26
    //   373: aload 28
    //   375: invokeinterface 411 1 0
    //   380: invokeinterface 420 1 0
    //   385: istore 5
    //   387: aload_0
    //   388: astore 20
    //   390: aload_3
    //   391: astore 23
    //   393: aload_0
    //   394: astore 24
    //   396: aload_3
    //   397: astore 21
    //   399: aload_0
    //   400: astore 25
    //   402: aload_3
    //   403: astore 22
    //   405: aload_0
    //   406: astore 19
    //   408: aload_3
    //   409: astore 26
    //   411: aload 28
    //   413: invokeinterface 426 1 0
    //   418: astore_0
    //   419: sipush 200
    //   422: iload 5
    //   424: if_icmpne +830 -> 1254
    //   427: aload_0
    //   428: astore 20
    //   430: aload_3
    //   431: astore 23
    //   433: aload_0
    //   434: astore 24
    //   436: aload_3
    //   437: astore 21
    //   439: aload_0
    //   440: astore 25
    //   442: aload_3
    //   443: astore 22
    //   445: aload_0
    //   446: astore 19
    //   448: aload_3
    //   449: astore 26
    //   451: aload_0
    //   452: invokeinterface 431 1 0
    //   457: lstore 16
    //   459: lconst_0
    //   460: lstore 8
    //   462: aload_0
    //   463: astore 20
    //   465: aload_3
    //   466: astore 23
    //   468: aload_0
    //   469: astore 24
    //   471: aload_3
    //   472: astore 21
    //   474: aload_0
    //   475: astore 25
    //   477: aload_3
    //   478: astore 22
    //   480: new 549	java/io/BufferedOutputStream
    //   483: dup
    //   484: new 433	java/io/FileOutputStream
    //   487: dup
    //   488: aload_2
    //   489: invokespecial 436	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   492: invokespecial 552	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   495: astore 19
    //   497: lload 8
    //   499: lstore 10
    //   501: lload 8
    //   503: lstore 12
    //   505: aload 19
    //   507: astore 21
    //   509: aload 19
    //   511: astore 22
    //   513: aload 19
    //   515: astore 20
    //   517: aload_0
    //   518: aload 19
    //   520: invokeinterface 555 2 0
    //   525: lload 8
    //   527: lstore 10
    //   529: lload 8
    //   531: lstore 12
    //   533: aload 19
    //   535: astore 21
    //   537: aload 19
    //   539: astore 22
    //   541: aload 19
    //   543: astore 20
    //   545: aload 19
    //   547: invokevirtual 558	java/io/OutputStream:flush	()V
    //   550: lload 8
    //   552: lstore 10
    //   554: lload 8
    //   556: lstore 12
    //   558: aload 19
    //   560: astore 21
    //   562: aload 19
    //   564: astore 22
    //   566: aload 19
    //   568: astore 20
    //   570: aload_2
    //   571: invokevirtual 561	java/io/File:length	()J
    //   574: lstore 8
    //   576: lload 8
    //   578: lstore 10
    //   580: lload 8
    //   582: lstore 12
    //   584: aload 19
    //   586: astore 21
    //   588: aload 19
    //   590: astore 22
    //   592: aload 19
    //   594: astore 20
    //   596: aload_2
    //   597: invokestatic 90	java/lang/System:currentTimeMillis	()J
    //   600: invokevirtual 475	java/io/File:setLastModified	(J)Z
    //   603: pop
    //   604: lload 8
    //   606: lstore 10
    //   608: lload 8
    //   610: lstore 12
    //   612: aload 19
    //   614: astore 21
    //   616: aload 19
    //   618: astore 22
    //   620: aload 19
    //   622: astore 20
    //   624: invokestatic 223	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   627: ifeq +75 -> 702
    //   630: lload 8
    //   632: lstore 10
    //   634: lload 8
    //   636: lstore 12
    //   638: aload 19
    //   640: astore 21
    //   642: aload 19
    //   644: astore 22
    //   646: aload 19
    //   648: astore 20
    //   650: ldc 66
    //   652: iconst_2
    //   653: new 306	java/lang/StringBuilder
    //   656: dup
    //   657: invokespecial 307	java/lang/StringBuilder:<init>	()V
    //   660: ldc_w 477
    //   663: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   666: invokestatic 90	java/lang/System:currentTimeMillis	()J
    //   669: lload 14
    //   671: lsub
    //   672: invokevirtual 466	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   675: ldc_w 563
    //   678: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   681: lload 8
    //   683: invokevirtual 466	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   686: ldc_w 481
    //   689: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   692: aload_1
    //   693: invokevirtual 566	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   696: invokevirtual 314	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   699: invokestatic 484	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   702: aload 19
    //   704: astore_3
    //   705: iconst_0
    //   706: istore 4
    //   708: iload 4
    //   710: istore 5
    //   712: lload 16
    //   714: lconst_0
    //   715: lcmp
    //   716: ifle +75 -> 791
    //   719: iload 4
    //   721: istore 5
    //   723: lload 8
    //   725: lload 16
    //   727: lcmp
    //   728: ifge +63 -> 791
    //   731: invokestatic 223	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   734: ifeq +53 -> 787
    //   737: ldc 66
    //   739: iconst_2
    //   740: new 306	java/lang/StringBuilder
    //   743: dup
    //   744: invokespecial 307	java/lang/StringBuilder:<init>	()V
    //   747: ldc_w 568
    //   750: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   753: lload 16
    //   755: invokevirtual 466	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   758: ldc_w 570
    //   761: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   764: aload_2
    //   765: invokevirtual 561	java/io/File:length	()J
    //   768: invokevirtual 466	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   771: ldc_w 502
    //   774: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   777: aload_1
    //   778: invokevirtual 566	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   781: invokevirtual 314	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   784: invokestatic 533	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   787: bipush 8
    //   789: istore 5
    //   791: iload 5
    //   793: istore 4
    //   795: aload_0
    //   796: ifnull +9 -> 805
    //   799: aload_0
    //   800: invokeinterface 494 1 0
    //   805: aload_3
    //   806: ifnull +7 -> 813
    //   809: aload_3
    //   810: invokevirtual 495	java/io/OutputStream:close	()V
    //   813: iload 4
    //   815: ifeq +1368 -> 2183
    //   818: aload_2
    //   819: invokevirtual 289	java/io/File:getParentFile	()Ljava/io/File;
    //   822: astore 19
    //   824: aload 19
    //   826: ifnull +17 -> 843
    //   829: aload 19
    //   831: invokevirtual 292	java/io/File:exists	()Z
    //   834: ifne +9 -> 843
    //   837: aload 19
    //   839: invokevirtual 295	java/io/File:mkdirs	()Z
    //   842: pop
    //   843: aload_2
    //   844: invokevirtual 292	java/io/File:exists	()Z
    //   847: ifeq +36 -> 883
    //   850: aload_2
    //   851: invokevirtual 394	java/io/File:delete	()Z
    //   854: istore 18
    //   856: ldc 66
    //   858: iconst_1
    //   859: new 306	java/lang/StringBuilder
    //   862: dup
    //   863: invokespecial 307	java/lang/StringBuilder:<init>	()V
    //   866: ldc_w 572
    //   869: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   872: iload 18
    //   874: invokevirtual 575	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   877: invokevirtual 314	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   880: invokestatic 239	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   883: iload 7
    //   885: iconst_1
    //   886: iadd
    //   887: istore 7
    //   889: invokestatic 223	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   892: ifeq +40 -> 932
    //   895: ldc 66
    //   897: iconst_2
    //   898: new 306	java/lang/StringBuilder
    //   901: dup
    //   902: invokespecial 307	java/lang/StringBuilder:<init>	()V
    //   905: ldc_w 497
    //   908: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   911: iload 4
    //   913: invokevirtual 500	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   916: ldc_w 502
    //   919: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   922: aload_1
    //   923: invokevirtual 566	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   926: invokevirtual 314	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   929: invokestatic 239	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   932: iload 4
    //   934: ifeq +51 -> 985
    //   937: ldc 66
    //   939: iconst_1
    //   940: new 306	java/lang/StringBuilder
    //   943: dup
    //   944: invokespecial 307	java/lang/StringBuilder:<init>	()V
    //   947: ldc_w 497
    //   950: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   953: iload 4
    //   955: invokevirtual 500	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   958: ldc_w 502
    //   961: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   964: aload_1
    //   965: invokevirtual 566	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   968: ldc_w 577
    //   971: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   974: iload 7
    //   976: invokevirtual 500	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   979: invokevirtual 314	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   982: invokestatic 239	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   985: iload 4
    //   987: ifeq +23 -> 1010
    //   990: iload 7
    //   992: iconst_2
    //   993: if_icmpge +17 -> 1010
    //   996: aload 29
    //   998: monitorenter
    //   999: aload 29
    //   1001: ldc2_w 578
    //   1004: invokevirtual 508	java/lang/Object:wait	(J)V
    //   1007: aload 29
    //   1009: monitorexit
    //   1010: iload 4
    //   1012: istore 5
    //   1014: iload 4
    //   1016: ifeq -995 -> 21
    //   1019: iload 4
    //   1021: istore 5
    //   1023: iload 7
    //   1025: iload 6
    //   1027: if_icmpge -1006 -> 21
    //   1030: goto -767 -> 263
    //   1033: astore_0
    //   1034: ldc 66
    //   1036: iconst_1
    //   1037: ldc_w 581
    //   1040: invokestatic 239	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1043: iconst_4
    //   1044: ireturn
    //   1045: astore 20
    //   1047: new 328	org/apache/http/client/methods/HttpGet
    //   1050: dup
    //   1051: aload 19
    //   1053: invokestatic 458	com/tencent/mobileqq/utils/HttpDownloadUtil:getEscapeSequence	(Ljava/lang/String;)Ljava/lang/String;
    //   1056: invokespecial 329	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   1059: astore 27
    //   1061: goto -985 -> 76
    //   1064: astore_0
    //   1065: ldc 66
    //   1067: iconst_1
    //   1068: ldc_w 583
    //   1071: invokestatic 239	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1074: bipush 13
    //   1076: ireturn
    //   1077: sipush 10000
    //   1080: istore 5
    //   1082: sipush 30000
    //   1085: istore 4
    //   1087: aload 30
    //   1089: ldc_w 379
    //   1092: sipush 4096
    //   1095: invokeinterface 383 3 0
    //   1100: pop
    //   1101: goto -900 -> 201
    //   1104: astore_3
    //   1105: lload 10
    //   1107: lstore 8
    //   1109: aload 19
    //   1111: astore_3
    //   1112: aload_3
    //   1113: astore 21
    //   1115: aload_3
    //   1116: astore 22
    //   1118: aload_3
    //   1119: astore 20
    //   1121: ldc 66
    //   1123: iconst_1
    //   1124: new 306	java/lang/StringBuilder
    //   1127: dup
    //   1128: invokespecial 307	java/lang/StringBuilder:<init>	()V
    //   1131: ldc_w 585
    //   1134: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1137: aload_2
    //   1138: invokevirtual 292	java/io/File:exists	()Z
    //   1141: invokevirtual 575	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1144: ldc_w 587
    //   1147: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1150: aload_2
    //   1151: invokevirtual 289	java/io/File:getParentFile	()Ljava/io/File;
    //   1154: invokevirtual 292	java/io/File:exists	()Z
    //   1157: invokevirtual 575	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1160: invokevirtual 314	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1163: invokestatic 239	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1166: iconst_5
    //   1167: istore 4
    //   1169: goto -461 -> 708
    //   1172: astore 28
    //   1174: aload 19
    //   1176: astore_3
    //   1177: lload 12
    //   1179: lstore 8
    //   1181: aload_0
    //   1182: astore 20
    //   1184: aload_3
    //   1185: astore 23
    //   1187: aload_0
    //   1188: astore 24
    //   1190: aload_3
    //   1191: astore 21
    //   1193: aload_0
    //   1194: astore 25
    //   1196: aload_3
    //   1197: astore 22
    //   1199: aload_0
    //   1200: astore 19
    //   1202: aload_3
    //   1203: astore 26
    //   1205: invokestatic 223	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1208: ifeq +40 -> 1248
    //   1211: aload_0
    //   1212: astore 20
    //   1214: aload_3
    //   1215: astore 23
    //   1217: aload_0
    //   1218: astore 24
    //   1220: aload_3
    //   1221: astore 21
    //   1223: aload_0
    //   1224: astore 25
    //   1226: aload_3
    //   1227: astore 22
    //   1229: aload_0
    //   1230: astore 19
    //   1232: aload_3
    //   1233: astore 26
    //   1235: ldc 66
    //   1237: iconst_2
    //   1238: aload 28
    //   1240: invokevirtual 530	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1243: aload 28
    //   1245: invokestatic 589	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1248: iconst_4
    //   1249: istore 4
    //   1251: goto -543 -> 708
    //   1254: iload 5
    //   1256: istore 4
    //   1258: goto -463 -> 795
    //   1261: astore 19
    //   1263: aload 19
    //   1265: invokevirtual 519	java/io/IOException:printStackTrace	()V
    //   1268: goto -463 -> 805
    //   1271: astore 19
    //   1273: goto -390 -> 883
    //   1276: astore 20
    //   1278: iconst_5
    //   1279: istore 4
    //   1281: aload_0
    //   1282: astore 19
    //   1284: aload 20
    //   1286: astore_0
    //   1287: aload_3
    //   1288: astore 20
    //   1290: invokestatic 223	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1293: ifeq +30 -> 1323
    //   1296: ldc 66
    //   1298: iconst_2
    //   1299: new 306	java/lang/StringBuilder
    //   1302: dup
    //   1303: invokespecial 307	java/lang/StringBuilder:<init>	()V
    //   1306: ldc_w 591
    //   1309: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1312: aload_1
    //   1313: invokevirtual 566	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1316: invokevirtual 314	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1319: aload_0
    //   1320: invokestatic 589	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1323: aload_0
    //   1324: instanceof 521
    //   1327: istore 18
    //   1329: iload 18
    //   1331: ifeq +142 -> 1473
    //   1334: bipush 10
    //   1336: istore 5
    //   1338: aload 19
    //   1340: ifnull +10 -> 1350
    //   1343: aload 19
    //   1345: invokeinterface 494 1 0
    //   1350: aload 20
    //   1352: ifnull +8 -> 1360
    //   1355: aload 20
    //   1357: invokevirtual 495	java/io/OutputStream:close	()V
    //   1360: aload 19
    //   1362: astore_0
    //   1363: aload 20
    //   1365: astore_3
    //   1366: iload 5
    //   1368: istore 4
    //   1370: iload 5
    //   1372: ifeq -489 -> 883
    //   1375: aload_2
    //   1376: invokevirtual 289	java/io/File:getParentFile	()Ljava/io/File;
    //   1379: astore_0
    //   1380: aload_0
    //   1381: ifnull +15 -> 1396
    //   1384: aload_0
    //   1385: invokevirtual 292	java/io/File:exists	()Z
    //   1388: ifne +8 -> 1396
    //   1391: aload_0
    //   1392: invokevirtual 295	java/io/File:mkdirs	()Z
    //   1395: pop
    //   1396: aload 19
    //   1398: astore_0
    //   1399: aload 20
    //   1401: astore_3
    //   1402: iload 5
    //   1404: istore 4
    //   1406: aload_2
    //   1407: invokevirtual 292	java/io/File:exists	()Z
    //   1410: ifeq -527 -> 883
    //   1413: aload_2
    //   1414: invokevirtual 394	java/io/File:delete	()Z
    //   1417: istore 18
    //   1419: ldc 66
    //   1421: iconst_1
    //   1422: new 306	java/lang/StringBuilder
    //   1425: dup
    //   1426: invokespecial 307	java/lang/StringBuilder:<init>	()V
    //   1429: ldc_w 572
    //   1432: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1435: iload 18
    //   1437: invokevirtual 575	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1440: invokevirtual 314	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1443: invokestatic 239	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1446: aload 19
    //   1448: astore_0
    //   1449: aload 20
    //   1451: astore_3
    //   1452: iload 5
    //   1454: istore 4
    //   1456: goto -573 -> 883
    //   1459: astore_0
    //   1460: aload 19
    //   1462: astore_0
    //   1463: aload 20
    //   1465: astore_3
    //   1466: iload 5
    //   1468: istore 4
    //   1470: goto -587 -> 883
    //   1473: aload_0
    //   1474: instanceof 516
    //   1477: ifne +709 -> 2186
    //   1480: aload_0
    //   1481: instanceof 518
    //   1484: ifeq +6 -> 1490
    //   1487: goto +699 -> 2186
    //   1490: aload_0
    //   1491: instanceof 535
    //   1494: istore 18
    //   1496: iload 18
    //   1498: ifeq +10 -> 1508
    //   1501: bipush 11
    //   1503: istore 5
    //   1505: goto -167 -> 1338
    //   1508: iconst_4
    //   1509: istore 5
    //   1511: goto -173 -> 1338
    //   1514: astore_0
    //   1515: aload_0
    //   1516: invokevirtual 519	java/io/IOException:printStackTrace	()V
    //   1519: goto -169 -> 1350
    //   1522: astore_3
    //   1523: aload 21
    //   1525: astore 20
    //   1527: iload 4
    //   1529: istore 5
    //   1531: aload_3
    //   1532: astore 21
    //   1534: aload_0
    //   1535: astore 19
    //   1537: aload 19
    //   1539: astore_0
    //   1540: aload 20
    //   1542: astore_3
    //   1543: iload 5
    //   1545: istore 4
    //   1547: invokestatic 223	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1550: ifeq +41 -> 1591
    //   1553: aload 19
    //   1555: astore_0
    //   1556: aload 20
    //   1558: astore_3
    //   1559: iload 5
    //   1561: istore 4
    //   1563: ldc 66
    //   1565: iconst_2
    //   1566: new 306	java/lang/StringBuilder
    //   1569: dup
    //   1570: invokespecial 307	java/lang/StringBuilder:<init>	()V
    //   1573: ldc_w 593
    //   1576: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1579: aload_1
    //   1580: invokevirtual 566	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1583: invokevirtual 314	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1586: aload 21
    //   1588: invokestatic 589	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1591: iconst_5
    //   1592: istore 5
    //   1594: aload 19
    //   1596: ifnull +10 -> 1606
    //   1599: aload 19
    //   1601: invokeinterface 494 1 0
    //   1606: aload 20
    //   1608: ifnull +8 -> 1616
    //   1611: aload 20
    //   1613: invokevirtual 495	java/io/OutputStream:close	()V
    //   1616: aload_2
    //   1617: invokevirtual 289	java/io/File:getParentFile	()Ljava/io/File;
    //   1620: astore_0
    //   1621: aload_0
    //   1622: ifnull +15 -> 1637
    //   1625: aload_0
    //   1626: invokevirtual 292	java/io/File:exists	()Z
    //   1629: ifne +8 -> 1637
    //   1632: aload_0
    //   1633: invokevirtual 295	java/io/File:mkdirs	()Z
    //   1636: pop
    //   1637: aload 19
    //   1639: astore_0
    //   1640: aload 20
    //   1642: astore_3
    //   1643: iload 5
    //   1645: istore 4
    //   1647: aload_2
    //   1648: invokevirtual 292	java/io/File:exists	()Z
    //   1651: ifeq -768 -> 883
    //   1654: aload_2
    //   1655: invokevirtual 394	java/io/File:delete	()Z
    //   1658: istore 18
    //   1660: ldc 66
    //   1662: iconst_1
    //   1663: new 306	java/lang/StringBuilder
    //   1666: dup
    //   1667: invokespecial 307	java/lang/StringBuilder:<init>	()V
    //   1670: ldc_w 572
    //   1673: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1676: iload 18
    //   1678: invokevirtual 575	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1681: invokevirtual 314	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1684: invokestatic 239	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1687: aload 19
    //   1689: astore_0
    //   1690: aload 20
    //   1692: astore_3
    //   1693: iload 5
    //   1695: istore 4
    //   1697: goto -814 -> 883
    //   1700: astore_0
    //   1701: aload 19
    //   1703: astore_0
    //   1704: aload 20
    //   1706: astore_3
    //   1707: iload 5
    //   1709: istore 4
    //   1711: goto -828 -> 883
    //   1714: astore_0
    //   1715: aload_0
    //   1716: invokevirtual 519	java/io/IOException:printStackTrace	()V
    //   1719: goto -113 -> 1606
    //   1722: astore 21
    //   1724: aload 22
    //   1726: astore 20
    //   1728: iload 4
    //   1730: istore 5
    //   1732: aload_0
    //   1733: astore 19
    //   1735: aload 19
    //   1737: astore_0
    //   1738: aload 20
    //   1740: astore_3
    //   1741: iload 5
    //   1743: istore 4
    //   1745: invokestatic 223	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1748: ifeq +41 -> 1789
    //   1751: aload 19
    //   1753: astore_0
    //   1754: aload 20
    //   1756: astore_3
    //   1757: iload 5
    //   1759: istore 4
    //   1761: ldc 66
    //   1763: iconst_2
    //   1764: new 306	java/lang/StringBuilder
    //   1767: dup
    //   1768: invokespecial 307	java/lang/StringBuilder:<init>	()V
    //   1771: ldc_w 593
    //   1774: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1777: aload_1
    //   1778: invokevirtual 566	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1781: invokevirtual 314	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1784: aload 21
    //   1786: invokestatic 589	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1789: iconst_5
    //   1790: istore 5
    //   1792: aload 19
    //   1794: ifnull +10 -> 1804
    //   1797: aload 19
    //   1799: invokeinterface 494 1 0
    //   1804: aload 20
    //   1806: ifnull +8 -> 1814
    //   1809: aload 20
    //   1811: invokevirtual 495	java/io/OutputStream:close	()V
    //   1814: aload_2
    //   1815: invokevirtual 289	java/io/File:getParentFile	()Ljava/io/File;
    //   1818: astore_0
    //   1819: aload_0
    //   1820: ifnull +15 -> 1835
    //   1823: aload_0
    //   1824: invokevirtual 292	java/io/File:exists	()Z
    //   1827: ifne +8 -> 1835
    //   1830: aload_0
    //   1831: invokevirtual 295	java/io/File:mkdirs	()Z
    //   1834: pop
    //   1835: aload 19
    //   1837: astore_0
    //   1838: aload 20
    //   1840: astore_3
    //   1841: iload 5
    //   1843: istore 4
    //   1845: aload_2
    //   1846: invokevirtual 292	java/io/File:exists	()Z
    //   1849: ifeq -966 -> 883
    //   1852: aload_2
    //   1853: invokevirtual 394	java/io/File:delete	()Z
    //   1856: istore 18
    //   1858: ldc 66
    //   1860: iconst_1
    //   1861: new 306	java/lang/StringBuilder
    //   1864: dup
    //   1865: invokespecial 307	java/lang/StringBuilder:<init>	()V
    //   1868: ldc_w 572
    //   1871: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1874: iload 18
    //   1876: invokevirtual 575	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1879: invokevirtual 314	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1882: invokestatic 239	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1885: aload 19
    //   1887: astore_0
    //   1888: aload 20
    //   1890: astore_3
    //   1891: iload 5
    //   1893: istore 4
    //   1895: goto -1012 -> 883
    //   1898: astore_0
    //   1899: aload 19
    //   1901: astore_0
    //   1902: aload 20
    //   1904: astore_3
    //   1905: iload 5
    //   1907: istore 4
    //   1909: goto -1026 -> 883
    //   1912: astore_0
    //   1913: aload_0
    //   1914: invokevirtual 519	java/io/IOException:printStackTrace	()V
    //   1917: goto -113 -> 1804
    //   1920: astore_1
    //   1921: aload 20
    //   1923: astore_3
    //   1924: aload_0
    //   1925: ifnull +9 -> 1934
    //   1928: aload_0
    //   1929: invokeinterface 494 1 0
    //   1934: aload_3
    //   1935: ifnull +7 -> 1942
    //   1938: aload_3
    //   1939: invokevirtual 495	java/io/OutputStream:close	()V
    //   1942: iload 4
    //   1944: ifeq +64 -> 2008
    //   1947: aload_2
    //   1948: invokevirtual 289	java/io/File:getParentFile	()Ljava/io/File;
    //   1951: astore_0
    //   1952: aload_0
    //   1953: ifnull +15 -> 1968
    //   1956: aload_0
    //   1957: invokevirtual 292	java/io/File:exists	()Z
    //   1960: ifne +8 -> 1968
    //   1963: aload_0
    //   1964: invokevirtual 295	java/io/File:mkdirs	()Z
    //   1967: pop
    //   1968: aload_2
    //   1969: invokevirtual 292	java/io/File:exists	()Z
    //   1972: ifeq +36 -> 2008
    //   1975: aload_2
    //   1976: invokevirtual 394	java/io/File:delete	()Z
    //   1979: istore 18
    //   1981: ldc 66
    //   1983: iconst_1
    //   1984: new 306	java/lang/StringBuilder
    //   1987: dup
    //   1988: invokespecial 307	java/lang/StringBuilder:<init>	()V
    //   1991: ldc_w 572
    //   1994: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1997: iload 18
    //   1999: invokevirtual 575	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2002: invokevirtual 314	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2005: invokestatic 239	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2008: aload_1
    //   2009: athrow
    //   2010: astore_0
    //   2011: aload_0
    //   2012: invokevirtual 519	java/io/IOException:printStackTrace	()V
    //   2015: goto -81 -> 1934
    //   2018: astore_0
    //   2019: aload 29
    //   2021: monitorexit
    //   2022: aload_0
    //   2023: athrow
    //   2024: astore 19
    //   2026: goto -1213 -> 813
    //   2029: astore_0
    //   2030: goto -670 -> 1360
    //   2033: astore_0
    //   2034: goto -418 -> 1616
    //   2037: astore_0
    //   2038: goto -224 -> 1814
    //   2041: astore_0
    //   2042: goto -100 -> 1942
    //   2045: astore 19
    //   2047: goto -1040 -> 1007
    //   2050: astore_0
    //   2051: goto -43 -> 2008
    //   2054: astore_1
    //   2055: aload 23
    //   2057: astore_3
    //   2058: aload 20
    //   2060: astore_0
    //   2061: goto -137 -> 1924
    //   2064: astore_1
    //   2065: goto -141 -> 1924
    //   2068: astore_1
    //   2069: aload 19
    //   2071: astore_0
    //   2072: aload 20
    //   2074: astore_3
    //   2075: goto -151 -> 1924
    //   2078: astore_1
    //   2079: goto -155 -> 1924
    //   2082: astore_0
    //   2083: aload 24
    //   2085: astore 19
    //   2087: aload 21
    //   2089: astore 20
    //   2091: aload_0
    //   2092: astore 21
    //   2094: iload 4
    //   2096: istore 5
    //   2098: goto -363 -> 1735
    //   2101: astore 21
    //   2103: aload_0
    //   2104: astore 19
    //   2106: aload_3
    //   2107: astore 20
    //   2109: iload 4
    //   2111: istore 5
    //   2113: goto -378 -> 1735
    //   2116: astore 21
    //   2118: aload 25
    //   2120: astore 19
    //   2122: aload 22
    //   2124: astore 20
    //   2126: iload 4
    //   2128: istore 5
    //   2130: goto -593 -> 1537
    //   2133: astore 21
    //   2135: aload_0
    //   2136: astore 19
    //   2138: aload_3
    //   2139: astore 20
    //   2141: iload 4
    //   2143: istore 5
    //   2145: goto -608 -> 1537
    //   2148: astore_0
    //   2149: iconst_5
    //   2150: istore 4
    //   2152: aload 26
    //   2154: astore 20
    //   2156: goto -866 -> 1290
    //   2159: astore 21
    //   2161: aload_0
    //   2162: astore 19
    //   2164: aload_3
    //   2165: astore 20
    //   2167: aload 21
    //   2169: astore_0
    //   2170: goto -880 -> 1290
    //   2173: astore 28
    //   2175: goto -994 -> 1181
    //   2178: astore 19
    //   2180: goto -1068 -> 1112
    //   2183: goto -1300 -> 883
    //   2186: iconst_2
    //   2187: istore 5
    //   2189: goto -851 -> 1338
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2192	0	paramAppRuntime	AppRuntime
    //   0	2192	1	paramURL	URL
    //   0	2192	2	paramFile	File
    //   0	2192	3	paramNetworkInfo	NetworkInfo
    //   0	2192	4	paramInt	int
    //   6	2182	5	i	int
    //   26	1002	6	j	int
    //   256	772	7	k	int
    //   460	720	8	l1	long
    //   499	607	10	l2	long
    //   503	675	12	l3	long
    //   3	667	14	l4	long
    //   457	297	16	l5	long
    //   854	1144	18	bool	boolean
    //   63	1168	19	localObject1	Object
    //   1261	3	19	localIOException1	java.io.IOException
    //   1271	1	19	localException1	Exception
    //   1282	618	19	localAppRuntime1	AppRuntime
    //   2024	1	19	localIOException2	java.io.IOException
    //   2045	25	19	localInterruptedException	java.lang.InterruptedException
    //   2085	78	19	localObject2	Object
    //   2178	1	19	localFileNotFoundException	java.io.FileNotFoundException
    //   113	536	20	localObject3	Object
    //   1045	1	20	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   1119	94	20	localObject4	Object
    //   1276	9	20	localIOException3	java.io.IOException
    //   1288	878	20	localObject5	Object
    //   314	1273	21	localObject6	Object
    //   1722	366	21	localThrowable1	java.lang.Throwable
    //   2092	1	21	localAppRuntime2	AppRuntime
    //   2101	1	21	localThrowable2	java.lang.Throwable
    //   2116	1	21	localException2	Exception
    //   2133	1	21	localException3	Exception
    //   2159	9	21	localIOException4	java.io.IOException
    //   320	1803	22	localObject7	Object
    //   308	1748	23	localNetworkInfo1	NetworkInfo
    //   311	1773	24	localAppRuntime3	AppRuntime
    //   317	1802	25	localAppRuntime4	AppRuntime
    //   326	1827	26	localNetworkInfo2	NetworkInfo
    //   74	986	27	localHttpGet	org.apache.http.client.methods.HttpGet
    //   347	65	28	localHttpResponse	org.apache.http.HttpResponse
    //   1172	72	28	localIOException5	java.io.IOException
    //   2173	1	28	localIOException6	java.io.IOException
    //   15	2005	29	localObject8	Object
    //   83	1005	30	localBasicHttpParams	BasicHttpParams
    // Exception table:
    //   from	to	target	type
    //   36	41	1033	java/lang/Exception
    //   45	57	1033	java/lang/Exception
    //   65	76	1045	java/lang/IllegalArgumentException
    //   1047	1061	1064	java/lang/IllegalArgumentException
    //   517	525	1104	java/io/FileNotFoundException
    //   545	550	1104	java/io/FileNotFoundException
    //   570	576	1104	java/io/FileNotFoundException
    //   596	604	1104	java/io/FileNotFoundException
    //   624	630	1104	java/io/FileNotFoundException
    //   650	702	1104	java/io/FileNotFoundException
    //   517	525	1172	java/io/IOException
    //   545	550	1172	java/io/IOException
    //   570	576	1172	java/io/IOException
    //   596	604	1172	java/io/IOException
    //   624	630	1172	java/io/IOException
    //   650	702	1172	java/io/IOException
    //   799	805	1261	java/io/IOException
    //   818	824	1271	java/lang/Exception
    //   829	843	1271	java/lang/Exception
    //   843	883	1271	java/lang/Exception
    //   1121	1166	1276	java/io/IOException
    //   1375	1380	1459	java/lang/Exception
    //   1384	1396	1459	java/lang/Exception
    //   1406	1446	1459	java/lang/Exception
    //   1343	1350	1514	java/io/IOException
    //   517	525	1522	java/lang/Exception
    //   545	550	1522	java/lang/Exception
    //   570	576	1522	java/lang/Exception
    //   596	604	1522	java/lang/Exception
    //   624	630	1522	java/lang/Exception
    //   650	702	1522	java/lang/Exception
    //   1121	1166	1522	java/lang/Exception
    //   1616	1621	1700	java/lang/Exception
    //   1625	1637	1700	java/lang/Exception
    //   1647	1687	1700	java/lang/Exception
    //   1599	1606	1714	java/io/IOException
    //   517	525	1722	java/lang/Throwable
    //   545	550	1722	java/lang/Throwable
    //   570	576	1722	java/lang/Throwable
    //   596	604	1722	java/lang/Throwable
    //   624	630	1722	java/lang/Throwable
    //   650	702	1722	java/lang/Throwable
    //   1121	1166	1722	java/lang/Throwable
    //   1814	1819	1898	java/lang/Exception
    //   1823	1835	1898	java/lang/Exception
    //   1845	1885	1898	java/lang/Exception
    //   1797	1804	1912	java/io/IOException
    //   517	525	1920	finally
    //   545	550	1920	finally
    //   570	576	1920	finally
    //   596	604	1920	finally
    //   624	630	1920	finally
    //   650	702	1920	finally
    //   1121	1166	1920	finally
    //   1928	1934	2010	java/io/IOException
    //   999	1007	2018	finally
    //   1007	1010	2018	finally
    //   2019	2022	2018	finally
    //   809	813	2024	java/io/IOException
    //   1355	1360	2029	java/io/IOException
    //   1611	1616	2033	java/io/IOException
    //   1809	1814	2037	java/io/IOException
    //   1938	1942	2041	java/io/IOException
    //   999	1007	2045	java/lang/InterruptedException
    //   1947	1952	2050	java/lang/Exception
    //   1956	1968	2050	java/lang/Exception
    //   1968	2008	2050	java/lang/Exception
    //   328	349	2054	finally
    //   373	387	2054	finally
    //   411	419	2054	finally
    //   451	459	2054	finally
    //   480	497	2054	finally
    //   1205	1211	2054	finally
    //   1235	1248	2054	finally
    //   731	787	2064	finally
    //   1290	1323	2068	finally
    //   1323	1329	2068	finally
    //   1473	1487	2068	finally
    //   1490	1496	2068	finally
    //   1547	1553	2078	finally
    //   1563	1591	2078	finally
    //   1745	1751	2078	finally
    //   1761	1789	2078	finally
    //   328	349	2082	java/lang/Throwable
    //   373	387	2082	java/lang/Throwable
    //   411	419	2082	java/lang/Throwable
    //   451	459	2082	java/lang/Throwable
    //   480	497	2082	java/lang/Throwable
    //   1205	1211	2082	java/lang/Throwable
    //   1235	1248	2082	java/lang/Throwable
    //   731	787	2101	java/lang/Throwable
    //   328	349	2116	java/lang/Exception
    //   373	387	2116	java/lang/Exception
    //   411	419	2116	java/lang/Exception
    //   451	459	2116	java/lang/Exception
    //   480	497	2116	java/lang/Exception
    //   1205	1211	2116	java/lang/Exception
    //   1235	1248	2116	java/lang/Exception
    //   731	787	2133	java/lang/Exception
    //   328	349	2148	java/io/IOException
    //   373	387	2148	java/io/IOException
    //   411	419	2148	java/io/IOException
    //   451	459	2148	java/io/IOException
    //   1205	1211	2148	java/io/IOException
    //   1235	1248	2148	java/io/IOException
    //   731	787	2159	java/io/IOException
    //   480	497	2173	java/io/IOException
    //   480	497	2178	java/io/FileNotFoundException
  }
  
  public static boolean download(AppRuntime paramAppRuntime, String paramString, File paramFile)
  {
    return downloadData(paramAppRuntime, paramString, paramFile) == 0;
  }
  
  public static boolean download(AppRuntime paramAppRuntime, URL paramURL, File paramFile)
  {
    return download(paramAppRuntime, paramURL, paramFile, AppNetConnInfo.getRecentNetworkInfo(), 2) == 0;
  }
  
  public static int downloadData(AppRuntime paramAppRuntime, DownloadInfo paramDownloadInfo, HttpDownloadUtil.HttpDownloadListener paramHttpDownloadListener)
  {
    NetworkInfo localNetworkInfo = AppNetConnInfo.getRecentNetworkInfo();
    if (localNetworkInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("HttpDownloadUtil", 2, "Download failed-----------activeNetworkInfo is null");
      }
      return 9;
    }
    return download(paramAppRuntime, paramDownloadInfo, localNetworkInfo, paramHttpDownloadListener);
  }
  
  public static int downloadData(AppRuntime paramAppRuntime, String paramString, File paramFile)
  {
    return downloadData(paramAppRuntime, paramString, paramFile, 2);
  }
  
  public static int downloadData(AppRuntime paramAppRuntime, String paramString, File paramFile, int paramInt)
  {
    NetworkInfo localNetworkInfo = AppNetConnInfo.getRecentNetworkInfo();
    if (localNetworkInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("HttpDownloadUtil", 2, "Download failed-----------activeNetworkInfo is null");
      }
      return 1;
    }
    try
    {
      paramString = new URL(paramString);
      return download(paramAppRuntime, paramString, paramFile, localNetworkInfo, paramInt);
    }
    catch (MalformedURLException paramAppRuntime)
    {
      paramAppRuntime.printStackTrace();
    }
    return 5;
  }
  
  private static boolean emoNeed2Try(DownloadInfo paramDownloadInfo, int paramInt1, int paramInt2)
  {
    if (paramDownloadInfo == null) {
      if (paramInt1 > paramInt2) {}
    }
    while ((paramDownloadInfo.resultCode != 0) && (paramInt1 <= paramInt2) && (paramDownloadInfo.resultCode != 16) && (paramDownloadInfo.resultCode != 6) && (NetworkUtil.d(BaseApplication.getContext())))
    {
      return true;
      return false;
    }
    return false;
  }
  
  public static String getEscapeSequence(String paramString)
  {
    return paramString.replaceAll("\\{", "%7B").replaceAll("\\}", "%7D").replaceAll("\\|", "%7C");
  }
  
  public static DownloadInfo queryDownloadInfo(String paramString, HttpDownloadUtil.DownloadInfoListener paramDownloadInfoListener)
  {
    return queryDownloadInfo(paramString, paramDownloadInfoListener, null, 2, true);
  }
  
  public static DownloadInfo queryDownloadInfo(String paramString, HttpDownloadUtil.DownloadInfoListener paramDownloadInfoListener, List<Header> paramList, int paramInt, boolean paramBoolean)
  {
    int i = NetworkCenter.getInstance().getNetType();
    return queryDownloadInfo(paramString, paramDownloadInfoListener, paramList, paramInt, paramBoolean, 0, HttpDownloadUtil.TimeoutParam.b(i), HttpDownloadUtil.TimeoutParam.a(i));
  }
  
  public static DownloadInfo queryDownloadInfo(String paramString, HttpDownloadUtil.DownloadInfoListener paramDownloadInfoListener, List<Header> paramList, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3)
  {
    return queryDownloadInfo(paramString, paramDownloadInfoListener, paramList, paramInt1, paramBoolean, 0, paramInt2, paramInt3);
  }
  
  /* Error */
  private static DownloadInfo queryDownloadInfo(String paramString, HttpDownloadUtil.DownloadInfoListener paramDownloadInfoListener, List<Header> paramList, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, int paramInt4)
  {
    // Byte code:
    //   0: new 241	com/tencent/mobileqq/emoticon/DownloadInfo
    //   3: dup
    //   4: aload_0
    //   5: aconst_null
    //   6: iconst_0
    //   7: invokespecial 671	com/tencent/mobileqq/emoticon/DownloadInfo:<init>	(Ljava/lang/String;Ljava/io/File;I)V
    //   10: astore 20
    //   12: iload 5
    //   14: iconst_3
    //   15: if_icmplt +30 -> 45
    //   18: invokestatic 223	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   21: ifeq +12 -> 33
    //   24: ldc 66
    //   26: iconst_2
    //   27: ldc_w 673
    //   30: invokestatic 533	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   33: aload 20
    //   35: bipush 20
    //   37: putfield 538	com/tencent/mobileqq/emoticon/DownloadInfo:resultCode	I
    //   40: aload 20
    //   42: astore_0
    //   43: aload_0
    //   44: areturn
    //   45: new 279	java/net/URL
    //   48: dup
    //   49: aload 20
    //   51: getfield 282	com/tencent/mobileqq/emoticon/DownloadInfo:reqUrl	Ljava/lang/String;
    //   54: invokespecial 283	java/net/URL:<init>	(Ljava/lang/String;)V
    //   57: pop
    //   58: aload 20
    //   60: getfield 282	com/tencent/mobileqq/emoticon/DownloadInfo:reqUrl	Ljava/lang/String;
    //   63: astore 18
    //   65: new 328	org/apache/http/client/methods/HttpGet
    //   68: dup
    //   69: aload 18
    //   71: invokespecial 329	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   74: pop
    //   75: new 4	java/lang/Object
    //   78: dup
    //   79: invokespecial 231	java/lang/Object:<init>	()V
    //   82: astore 21
    //   84: aconst_null
    //   85: astore 14
    //   87: iconst_0
    //   88: istore 9
    //   90: ldc2_w 503
    //   93: lstore 11
    //   95: invokestatic 605	com/tencent/mobileqq/msf/sdk/AppNetConnInfo:getRecentNetworkInfo	()Landroid/net/NetworkInfo;
    //   98: astore 22
    //   100: aload 22
    //   102: ifnonnull +196 -> 298
    //   105: invokestatic 223	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   108: ifeq +12 -> 120
    //   111: ldc 66
    //   113: iconst_2
    //   114: ldc_w 675
    //   117: invokestatic 533	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   120: aload 20
    //   122: iconst_1
    //   123: putfield 538	com/tencent/mobileqq/emoticon/DownloadInfo:resultCode	I
    //   126: iload 9
    //   128: iconst_1
    //   129: iadd
    //   130: istore 8
    //   132: iload 8
    //   134: iload_3
    //   135: if_icmplt +133 -> 268
    //   138: aload_1
    //   139: ifnull +12 -> 151
    //   142: aload_1
    //   143: aload 20
    //   145: invokeinterface 680 2 0
    //   150: pop
    //   151: aload 20
    //   153: areturn
    //   154: astore_0
    //   155: invokestatic 223	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   158: ifeq +13 -> 171
    //   161: ldc 66
    //   163: iconst_2
    //   164: aload_0
    //   165: invokevirtual 681	java/net/MalformedURLException:toString	()Ljava/lang/String;
    //   168: invokestatic 533	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   171: aload 20
    //   173: aload_0
    //   174: invokestatic 323	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   177: putfield 326	com/tencent/mobileqq/emoticon/DownloadInfo:errorDetail	Ljava/lang/String;
    //   180: aload 20
    //   182: bipush 13
    //   184: putfield 538	com/tencent/mobileqq/emoticon/DownloadInfo:resultCode	I
    //   187: aload_1
    //   188: ifnull +12 -> 200
    //   191: aload_1
    //   192: aload 20
    //   194: invokeinterface 680 2 0
    //   199: pop
    //   200: aload 20
    //   202: areturn
    //   203: astore 14
    //   205: new 328	org/apache/http/client/methods/HttpGet
    //   208: dup
    //   209: aload 18
    //   211: invokestatic 458	com/tencent/mobileqq/utils/HttpDownloadUtil:getEscapeSequence	(Ljava/lang/String;)Ljava/lang/String;
    //   214: invokespecial 329	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   217: pop
    //   218: aload 18
    //   220: invokestatic 458	com/tencent/mobileqq/utils/HttpDownloadUtil:getEscapeSequence	(Ljava/lang/String;)Ljava/lang/String;
    //   223: astore 18
    //   225: goto -150 -> 75
    //   228: astore_0
    //   229: invokestatic 223	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   232: ifeq +13 -> 245
    //   235: ldc 66
    //   237: iconst_2
    //   238: aload_0
    //   239: invokevirtual 682	java/lang/IllegalArgumentException:toString	()Ljava/lang/String;
    //   242: invokestatic 533	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   245: aload 20
    //   247: bipush 13
    //   249: putfield 538	com/tencent/mobileqq/emoticon/DownloadInfo:resultCode	I
    //   252: aload_1
    //   253: ifnull +12 -> 265
    //   256: aload_1
    //   257: aload 20
    //   259: invokeinterface 680 2 0
    //   264: pop
    //   265: aload 20
    //   267: areturn
    //   268: aload 21
    //   270: monitorenter
    //   271: aload 21
    //   273: lload 11
    //   275: invokevirtual 508	java/lang/Object:wait	(J)V
    //   278: lload 11
    //   280: ldc2_w 683
    //   283: lmul
    //   284: lstore 11
    //   286: aload 21
    //   288: monitorexit
    //   289: goto +2073 -> 2362
    //   292: astore_0
    //   293: aload 21
    //   295: monitorexit
    //   296: aload_0
    //   297: athrow
    //   298: aconst_null
    //   299: astore 19
    //   301: iconst_m1
    //   302: istore 8
    //   304: aload 22
    //   306: ifnull +41 -> 347
    //   309: aload 14
    //   311: astore 17
    //   313: aload 14
    //   315: astore 16
    //   317: aload 14
    //   319: astore 15
    //   321: aload 22
    //   323: invokevirtual 359	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   326: astore 19
    //   328: aload 14
    //   330: astore 17
    //   332: aload 14
    //   334: astore 16
    //   336: aload 14
    //   338: astore 15
    //   340: aload 22
    //   342: invokevirtual 687	android/net/NetworkInfo:getType	()I
    //   345: istore 8
    //   347: aload 14
    //   349: astore 17
    //   351: aload 14
    //   353: astore 16
    //   355: aload 14
    //   357: astore 15
    //   359: invokestatic 350	android/net/Proxy:getDefaultHost	()Ljava/lang/String;
    //   362: astore 22
    //   364: aload 14
    //   366: astore 17
    //   368: aload 14
    //   370: astore 16
    //   372: aload 14
    //   374: astore 15
    //   376: invokestatic 354	android/net/Proxy:getDefaultPort	()I
    //   379: istore 10
    //   381: aload 14
    //   383: astore 17
    //   385: aload 14
    //   387: astore 16
    //   389: aload 14
    //   391: astore 15
    //   393: aload 19
    //   395: invokestatic 692	com/tencent/mobileqq/utils/httputils/PkgTools:getApnType	(Ljava/lang/String;)Ljava/lang/String;
    //   398: astore 19
    //   400: aload 14
    //   402: astore 17
    //   404: aload 14
    //   406: astore 16
    //   408: aload 14
    //   410: astore 15
    //   412: aload 19
    //   414: getstatic 200	com/tencent/mobileqq/utils/HttpDownloadUtil:lastApn	Ljava/lang/String;
    //   417: invokevirtual 696	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   420: ifne +65 -> 485
    //   423: aload 14
    //   425: astore 17
    //   427: aload 14
    //   429: astore 16
    //   431: aload 14
    //   433: astore 15
    //   435: aload 19
    //   437: putstatic 200	com/tencent/mobileqq/utils/HttpDownloadUtil:lastApn	Ljava/lang/String;
    //   440: iload 8
    //   442: iconst_1
    //   443: if_icmpeq +26 -> 469
    //   446: aload 14
    //   448: astore 17
    //   450: aload 14
    //   452: astore 16
    //   454: aload 14
    //   456: astore 15
    //   458: aload 19
    //   460: getstatic 699	com/tencent/mobileqq/utils/httputils/PkgTools:APN_TYPE_CMWAP	Ljava/lang/String;
    //   463: invokevirtual 696	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   466: ifeq +558 -> 1024
    //   469: aload 14
    //   471: astore 17
    //   473: aload 14
    //   475: astore 16
    //   477: aload 14
    //   479: astore 15
    //   481: iconst_0
    //   482: putstatic 202	com/tencent/mobileqq/utils/HttpDownloadUtil:forceDirect	Z
    //   485: iload 8
    //   487: iconst_1
    //   488: if_icmpne +65 -> 553
    //   491: aload 14
    //   493: astore 17
    //   495: aload 14
    //   497: astore 16
    //   499: aload 14
    //   501: astore 15
    //   503: ldc_w 701
    //   506: aload 22
    //   508: invokevirtual 696	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   511: ifne +26 -> 537
    //   514: aload 14
    //   516: astore 17
    //   518: aload 14
    //   520: astore 16
    //   522: aload 14
    //   524: astore 15
    //   526: ldc_w 703
    //   529: aload 22
    //   531: invokevirtual 696	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   534: ifeq +19 -> 553
    //   537: aload 14
    //   539: astore 17
    //   541: aload 14
    //   543: astore 16
    //   545: aload 14
    //   547: astore 15
    //   549: iconst_1
    //   550: putstatic 202	com/tencent/mobileqq/utils/HttpDownloadUtil:forceDirect	Z
    //   553: aload 14
    //   555: astore 17
    //   557: aload 14
    //   559: astore 16
    //   561: aload 14
    //   563: astore 15
    //   565: getstatic 202	com/tencent/mobileqq/utils/HttpDownloadUtil:forceDirect	Z
    //   568: ifne +704 -> 1272
    //   571: aload 22
    //   573: ifnull +699 -> 1272
    //   576: iload 10
    //   578: ifle +694 -> 1272
    //   581: aload 14
    //   583: astore 17
    //   585: aload 14
    //   587: astore 16
    //   589: aload 14
    //   591: astore 15
    //   593: aload 19
    //   595: getstatic 699	com/tencent/mobileqq/utils/httputils/PkgTools:APN_TYPE_CMWAP	Ljava/lang/String;
    //   598: invokevirtual 696	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   601: ifne +49 -> 650
    //   604: aload 14
    //   606: astore 17
    //   608: aload 14
    //   610: astore 16
    //   612: aload 14
    //   614: astore 15
    //   616: aload 19
    //   618: getstatic 706	com/tencent/mobileqq/utils/httputils/PkgTools:APN_TYPE_UNIWAP	Ljava/lang/String;
    //   621: invokevirtual 696	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   624: ifne +26 -> 650
    //   627: aload 14
    //   629: astore 17
    //   631: aload 14
    //   633: astore 16
    //   635: aload 14
    //   637: astore 15
    //   639: aload 19
    //   641: getstatic 709	com/tencent/mobileqq/utils/httputils/PkgTools:APN_TYPE_3GWAP	Ljava/lang/String;
    //   644: invokevirtual 696	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   647: ifeq +550 -> 1197
    //   650: aload 14
    //   652: astore 17
    //   654: aload 14
    //   656: astore 16
    //   658: aload 14
    //   660: astore 15
    //   662: aload 18
    //   664: aload 22
    //   666: iload 10
    //   668: invokestatic 713	com/tencent/mobileqq/utils/httputils/PkgTools:getConnectionWithXOnlineHost	(Ljava/lang/String;Ljava/lang/String;I)Ljava/net/HttpURLConnection;
    //   671: astore 14
    //   673: aload 14
    //   675: astore 17
    //   677: aload 14
    //   679: astore 16
    //   681: aload 14
    //   683: astore 15
    //   685: aload 20
    //   687: aload 14
    //   689: putfield 717	com/tencent/mobileqq/emoticon/DownloadInfo:conn	Ljava/net/HttpURLConnection;
    //   692: aload_2
    //   693: ifnull +614 -> 1307
    //   696: aload 14
    //   698: astore 17
    //   700: aload 14
    //   702: astore 16
    //   704: aload 14
    //   706: astore 15
    //   708: aload_2
    //   709: invokeinterface 722 1 0
    //   714: ifne +593 -> 1307
    //   717: aload 14
    //   719: astore 17
    //   721: aload 14
    //   723: astore 16
    //   725: aload 14
    //   727: astore 15
    //   729: aload_2
    //   730: invokeinterface 726 1 0
    //   735: astore 19
    //   737: aload 14
    //   739: astore 17
    //   741: aload 14
    //   743: astore 16
    //   745: aload 14
    //   747: astore 15
    //   749: aload 19
    //   751: invokeinterface 731 1 0
    //   756: ifeq +551 -> 1307
    //   759: aload 14
    //   761: astore 17
    //   763: aload 14
    //   765: astore 16
    //   767: aload 14
    //   769: astore 15
    //   771: aload 19
    //   773: invokeinterface 735 1 0
    //   778: checkcast 737	org/apache/http/Header
    //   781: astore 22
    //   783: aload 14
    //   785: astore 17
    //   787: aload 14
    //   789: astore 16
    //   791: aload 14
    //   793: astore 15
    //   795: aload 14
    //   797: aload 22
    //   799: invokeinterface 740 1 0
    //   804: aload 22
    //   806: invokeinterface 743 1 0
    //   811: invokevirtual 747	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   814: goto -77 -> 737
    //   817: astore 16
    //   819: aload 17
    //   821: astore 14
    //   823: aload 14
    //   825: astore 15
    //   827: invokestatic 223	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   830: ifeq +12 -> 842
    //   833: aload 14
    //   835: astore 15
    //   837: aload 16
    //   839: invokevirtual 519	java/io/IOException:printStackTrace	()V
    //   842: iconst_5
    //   843: istore 8
    //   845: aload 14
    //   847: astore 15
    //   849: aload 16
    //   851: instanceof 521
    //   854: ifeq +1357 -> 2211
    //   857: bipush 10
    //   859: istore 8
    //   861: iload_3
    //   862: istore 9
    //   864: aload 14
    //   866: astore 15
    //   868: aload 20
    //   870: iload 8
    //   872: putfield 538	com/tencent/mobileqq/emoticon/DownloadInfo:resultCode	I
    //   875: aload 14
    //   877: astore 15
    //   879: invokestatic 223	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   882: ifeq +76 -> 958
    //   885: aload 14
    //   887: astore 15
    //   889: ldc 66
    //   891: iconst_2
    //   892: new 306	java/lang/StringBuilder
    //   895: dup
    //   896: invokespecial 307	java/lang/StringBuilder:<init>	()V
    //   899: ldc_w 749
    //   902: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   905: iload 8
    //   907: invokevirtual 500	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   910: ldc_w 751
    //   913: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   916: aload 20
    //   918: getfield 754	com/tencent/mobileqq/emoticon/DownloadInfo:httpRespCode	I
    //   921: invokevirtual 500	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   924: ldc_w 525
    //   927: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   930: aload 20
    //   932: getfield 282	com/tencent/mobileqq/emoticon/DownloadInfo:reqUrl	Ljava/lang/String;
    //   935: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   938: ldc_w 756
    //   941: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   944: aload 16
    //   946: invokevirtual 757	java/io/IOException:toString	()Ljava/lang/String;
    //   949: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   952: invokevirtual 314	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   955: invokestatic 533	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   958: aload 14
    //   960: astore 15
    //   962: iload 9
    //   964: istore 8
    //   966: aload 14
    //   968: ifnull +16 -> 984
    //   971: aload 14
    //   973: invokevirtual 760	java/net/HttpURLConnection:disconnect	()V
    //   976: iload 9
    //   978: istore 8
    //   980: aload 14
    //   982: astore 15
    //   984: iload 8
    //   986: iconst_1
    //   987: iadd
    //   988: istore 8
    //   990: iload 8
    //   992: iload_3
    //   993: if_icmpge +1309 -> 2302
    //   996: aload 21
    //   998: monitorenter
    //   999: aload 21
    //   1001: lload 11
    //   1003: invokevirtual 508	java/lang/Object:wait	(J)V
    //   1006: lload 11
    //   1008: ldc2_w 683
    //   1011: lmul
    //   1012: lstore 11
    //   1014: aload 21
    //   1016: monitorexit
    //   1017: aload 15
    //   1019: astore 14
    //   1021: goto +1341 -> 2362
    //   1024: aload 14
    //   1026: astore 17
    //   1028: aload 14
    //   1030: astore 16
    //   1032: aload 14
    //   1034: astore 15
    //   1036: iconst_1
    //   1037: putstatic 202	com/tencent/mobileqq/utils/HttpDownloadUtil:forceDirect	Z
    //   1040: goto -555 -> 485
    //   1043: astore 15
    //   1045: aload 16
    //   1047: astore 14
    //   1049: aload 15
    //   1051: astore 16
    //   1053: aload 14
    //   1055: astore 15
    //   1057: invokestatic 223	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1060: ifeq +12 -> 1072
    //   1063: aload 14
    //   1065: astore 15
    //   1067: aload 16
    //   1069: invokevirtual 539	java/lang/Exception:printStackTrace	()V
    //   1072: aload 14
    //   1074: astore 15
    //   1076: aload 20
    //   1078: iconst_5
    //   1079: putfield 538	com/tencent/mobileqq/emoticon/DownloadInfo:resultCode	I
    //   1082: aload 14
    //   1084: astore 15
    //   1086: invokestatic 223	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1089: ifeq +79 -> 1168
    //   1092: aload 14
    //   1094: astore 15
    //   1096: ldc 66
    //   1098: iconst_2
    //   1099: new 306	java/lang/StringBuilder
    //   1102: dup
    //   1103: invokespecial 307	java/lang/StringBuilder:<init>	()V
    //   1106: ldc_w 749
    //   1109: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1112: aload 20
    //   1114: getfield 538	com/tencent/mobileqq/emoticon/DownloadInfo:resultCode	I
    //   1117: invokevirtual 500	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1120: ldc_w 762
    //   1123: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1126: aload 20
    //   1128: getfield 754	com/tencent/mobileqq/emoticon/DownloadInfo:httpRespCode	I
    //   1131: invokevirtual 500	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1134: ldc_w 525
    //   1137: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1140: aload 20
    //   1142: getfield 282	com/tencent/mobileqq/emoticon/DownloadInfo:reqUrl	Ljava/lang/String;
    //   1145: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1148: ldc_w 527
    //   1151: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1154: aload 16
    //   1156: invokevirtual 763	java/lang/Exception:toString	()Ljava/lang/String;
    //   1159: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1162: invokevirtual 314	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1165: invokestatic 533	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1168: aload 14
    //   1170: astore 15
    //   1172: iload 9
    //   1174: istore 8
    //   1176: aload 14
    //   1178: ifnull -194 -> 984
    //   1181: aload 14
    //   1183: invokevirtual 760	java/net/HttpURLConnection:disconnect	()V
    //   1186: aload 14
    //   1188: astore 15
    //   1190: iload 9
    //   1192: istore 8
    //   1194: goto -210 -> 984
    //   1197: aload 14
    //   1199: astore 17
    //   1201: aload 14
    //   1203: astore 16
    //   1205: aload 14
    //   1207: astore 15
    //   1209: aload 19
    //   1211: getstatic 766	com/tencent/mobileqq/utils/httputils/PkgTools:APN_TYPE_CTWAP	Ljava/lang/String;
    //   1214: invokevirtual 696	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1217: ifeq +29 -> 1246
    //   1220: aload 14
    //   1222: astore 17
    //   1224: aload 14
    //   1226: astore 16
    //   1228: aload 14
    //   1230: astore 15
    //   1232: aload 18
    //   1234: aload 22
    //   1236: iload 10
    //   1238: invokestatic 769	com/tencent/mobileqq/utils/httputils/PkgTools:getConnectionWithDefaultProxy	(Ljava/lang/String;Ljava/lang/String;I)Ljava/net/HttpURLConnection;
    //   1241: astore 14
    //   1243: goto -570 -> 673
    //   1246: aload 14
    //   1248: astore 17
    //   1250: aload 14
    //   1252: astore 16
    //   1254: aload 14
    //   1256: astore 15
    //   1258: aload 18
    //   1260: aload 22
    //   1262: iload 10
    //   1264: invokestatic 769	com/tencent/mobileqq/utils/httputils/PkgTools:getConnectionWithDefaultProxy	(Ljava/lang/String;Ljava/lang/String;I)Ljava/net/HttpURLConnection;
    //   1267: astore 14
    //   1269: goto -596 -> 673
    //   1272: aload 14
    //   1274: astore 17
    //   1276: aload 14
    //   1278: astore 16
    //   1280: aload 14
    //   1282: astore 15
    //   1284: new 279	java/net/URL
    //   1287: dup
    //   1288: aload 18
    //   1290: invokespecial 283	java/net/URL:<init>	(Ljava/lang/String;)V
    //   1293: getstatic 775	java/net/Proxy:NO_PROXY	Ljava/net/Proxy;
    //   1296: invokevirtual 779	java/net/URL:openConnection	(Ljava/net/Proxy;)Ljava/net/URLConnection;
    //   1299: checkcast 253	java/net/HttpURLConnection
    //   1302: astore 14
    //   1304: goto -631 -> 673
    //   1307: aload 14
    //   1309: astore 17
    //   1311: aload 14
    //   1313: astore 16
    //   1315: aload 14
    //   1317: astore 15
    //   1319: aload 14
    //   1321: ldc_w 781
    //   1324: ldc_w 783
    //   1327: invokevirtual 786	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1330: aload 14
    //   1332: astore 17
    //   1334: aload 14
    //   1336: astore 16
    //   1338: aload 14
    //   1340: astore 15
    //   1342: aload 14
    //   1344: iload 6
    //   1346: invokevirtual 790	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   1349: aload 14
    //   1351: astore 17
    //   1353: aload 14
    //   1355: astore 16
    //   1357: aload 14
    //   1359: astore 15
    //   1361: aload 14
    //   1363: iload 7
    //   1365: invokevirtual 793	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   1368: aload 14
    //   1370: astore 17
    //   1372: aload 14
    //   1374: astore 16
    //   1376: aload 14
    //   1378: astore 15
    //   1380: aload 14
    //   1382: iconst_0
    //   1383: invokevirtual 797	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   1386: aload 14
    //   1388: astore 17
    //   1390: aload 14
    //   1392: astore 16
    //   1394: aload 14
    //   1396: astore 15
    //   1398: aload 14
    //   1400: invokevirtual 800	java/net/HttpURLConnection:connect	()V
    //   1403: aload 14
    //   1405: astore 17
    //   1407: aload 14
    //   1409: astore 16
    //   1411: aload 14
    //   1413: astore 15
    //   1415: aload 20
    //   1417: aload 14
    //   1419: invokevirtual 803	java/net/HttpURLConnection:getResponseCode	()I
    //   1422: putfield 754	com/tencent/mobileqq/emoticon/DownloadInfo:httpRespCode	I
    //   1425: aload 14
    //   1427: astore 17
    //   1429: aload 14
    //   1431: astore 16
    //   1433: aload 14
    //   1435: astore 15
    //   1437: aload 20
    //   1439: aload 14
    //   1441: invokevirtual 805	java/net/HttpURLConnection:getContentLength	()I
    //   1444: putfield 808	com/tencent/mobileqq/emoticon/DownloadInfo:respContentLength	I
    //   1447: aload 14
    //   1449: astore 17
    //   1451: aload 14
    //   1453: astore 16
    //   1455: aload 14
    //   1457: astore 15
    //   1459: aload 20
    //   1461: aload 14
    //   1463: invokevirtual 811	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
    //   1466: putfield 814	com/tencent/mobileqq/emoticon/DownloadInfo:respContentType	Ljava/lang/String;
    //   1469: aload 14
    //   1471: astore 17
    //   1473: aload 14
    //   1475: astore 16
    //   1477: aload 14
    //   1479: astore 15
    //   1481: aload 20
    //   1483: aload 14
    //   1485: invokevirtual 817	java/net/HttpURLConnection:getContentEncoding	()Ljava/lang/String;
    //   1488: putfield 820	com/tencent/mobileqq/emoticon/DownloadInfo:respContentEncoding	Ljava/lang/String;
    //   1491: aload 14
    //   1493: astore 17
    //   1495: aload 14
    //   1497: astore 16
    //   1499: aload 14
    //   1501: astore 15
    //   1503: aload 14
    //   1505: aload 20
    //   1507: invokestatic 822	com/tencent/mobileqq/utils/HttpDownloadUtil:copyRespHeader	(Ljava/net/HttpURLConnection;Lcom/tencent/mobileqq/emoticon/DownloadInfo;)V
    //   1510: aload 14
    //   1512: astore 17
    //   1514: aload 14
    //   1516: astore 16
    //   1518: aload 14
    //   1520: astore 15
    //   1522: invokestatic 223	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1525: ifeq +83 -> 1608
    //   1528: aload 14
    //   1530: astore 17
    //   1532: aload 14
    //   1534: astore 16
    //   1536: aload 14
    //   1538: astore 15
    //   1540: ldc 66
    //   1542: iconst_2
    //   1543: new 306	java/lang/StringBuilder
    //   1546: dup
    //   1547: invokespecial 307	java/lang/StringBuilder:<init>	()V
    //   1550: ldc_w 824
    //   1553: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1556: aload_0
    //   1557: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1560: ldc_w 826
    //   1563: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1566: aload 20
    //   1568: getfield 754	com/tencent/mobileqq/emoticon/DownloadInfo:httpRespCode	I
    //   1571: invokevirtual 500	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1574: ldc_w 828
    //   1577: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1580: aload 20
    //   1582: getfield 808	com/tencent/mobileqq/emoticon/DownloadInfo:respContentLength	I
    //   1585: invokevirtual 500	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1588: ldc_w 830
    //   1591: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1594: aload 20
    //   1596: getfield 814	com/tencent/mobileqq/emoticon/DownloadInfo:respContentType	Ljava/lang/String;
    //   1599: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1602: invokevirtual 314	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1605: invokestatic 484	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1608: iload 4
    //   1610: ifeq +59 -> 1669
    //   1613: aload 14
    //   1615: astore 17
    //   1617: aload 14
    //   1619: astore 16
    //   1621: aload 14
    //   1623: astore 15
    //   1625: aload 20
    //   1627: iconst_0
    //   1628: putfield 538	com/tencent/mobileqq/emoticon/DownloadInfo:resultCode	I
    //   1631: aload_1
    //   1632: ifnull +24 -> 1656
    //   1635: aload 14
    //   1637: astore 17
    //   1639: aload 14
    //   1641: astore 16
    //   1643: aload 14
    //   1645: astore 15
    //   1647: aload_1
    //   1648: aload 20
    //   1650: invokeinterface 680 2 0
    //   1655: pop
    //   1656: aload 14
    //   1658: ifnull +8 -> 1666
    //   1661: aload 14
    //   1663: invokevirtual 760	java/net/HttpURLConnection:disconnect	()V
    //   1666: aload 20
    //   1668: areturn
    //   1669: aload 14
    //   1671: astore 17
    //   1673: aload 14
    //   1675: astore 16
    //   1677: aload 14
    //   1679: astore 15
    //   1681: aload 20
    //   1683: getfield 754	com/tencent/mobileqq/emoticon/DownloadInfo:httpRespCode	I
    //   1686: sipush 200
    //   1689: if_icmpne +157 -> 1846
    //   1692: aload_1
    //   1693: ifnull +122 -> 1815
    //   1696: aload 14
    //   1698: astore 17
    //   1700: aload 14
    //   1702: astore 16
    //   1704: aload 14
    //   1706: astore 15
    //   1708: aload 20
    //   1710: iconst_0
    //   1711: putfield 538	com/tencent/mobileqq/emoticon/DownloadInfo:resultCode	I
    //   1714: aload 14
    //   1716: astore 17
    //   1718: aload 14
    //   1720: astore 16
    //   1722: aload 14
    //   1724: astore 15
    //   1726: aload_1
    //   1727: aload 20
    //   1729: invokeinterface 680 2 0
    //   1734: ifeq +34 -> 1768
    //   1737: aload 14
    //   1739: astore 17
    //   1741: aload 14
    //   1743: astore 16
    //   1745: aload 14
    //   1747: astore 15
    //   1749: aload 20
    //   1751: iconst_0
    //   1752: putfield 538	com/tencent/mobileqq/emoticon/DownloadInfo:resultCode	I
    //   1755: aload 14
    //   1757: ifnull +8 -> 1765
    //   1760: aload 14
    //   1762: invokevirtual 760	java/net/HttpURLConnection:disconnect	()V
    //   1765: aload 20
    //   1767: areturn
    //   1768: aload 14
    //   1770: astore 17
    //   1772: aload 14
    //   1774: astore 16
    //   1776: aload 14
    //   1778: astore 15
    //   1780: aload 20
    //   1782: iconst_4
    //   1783: putfield 538	com/tencent/mobileqq/emoticon/DownloadInfo:resultCode	I
    //   1786: aload 14
    //   1788: astore 15
    //   1790: iload 9
    //   1792: istore 8
    //   1794: aload 14
    //   1796: ifnull -812 -> 984
    //   1799: aload 14
    //   1801: invokevirtual 760	java/net/HttpURLConnection:disconnect	()V
    //   1804: aload 14
    //   1806: astore 15
    //   1808: iload 9
    //   1810: istore 8
    //   1812: goto -828 -> 984
    //   1815: aload 14
    //   1817: astore 17
    //   1819: aload 14
    //   1821: astore 16
    //   1823: aload 14
    //   1825: astore 15
    //   1827: aload 20
    //   1829: iconst_0
    //   1830: putfield 538	com/tencent/mobileqq/emoticon/DownloadInfo:resultCode	I
    //   1833: aload 14
    //   1835: ifnull +8 -> 1843
    //   1838: aload 14
    //   1840: invokevirtual 760	java/net/HttpURLConnection:disconnect	()V
    //   1843: aload 20
    //   1845: areturn
    //   1846: aload 14
    //   1848: astore 17
    //   1850: aload 14
    //   1852: astore 16
    //   1854: aload 14
    //   1856: astore 15
    //   1858: aload 20
    //   1860: getfield 754	com/tencent/mobileqq/emoticon/DownloadInfo:httpRespCode	I
    //   1863: sipush 302
    //   1866: if_icmpeq +26 -> 1892
    //   1869: aload 14
    //   1871: astore 17
    //   1873: aload 14
    //   1875: astore 16
    //   1877: aload 14
    //   1879: astore 15
    //   1881: aload 20
    //   1883: getfield 754	com/tencent/mobileqq/emoticon/DownloadInfo:httpRespCode	I
    //   1886: sipush 301
    //   1889: if_icmpne +284 -> 2173
    //   1892: aload 14
    //   1894: astore 17
    //   1896: aload 14
    //   1898: astore 16
    //   1900: aload 14
    //   1902: astore 15
    //   1904: aload 14
    //   1906: ldc_w 832
    //   1909: invokevirtual 257	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   1912: astore 19
    //   1914: aload 14
    //   1916: astore 17
    //   1918: aload 14
    //   1920: astore 16
    //   1922: aload 14
    //   1924: astore 15
    //   1926: invokestatic 223	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1929: ifeq +42 -> 1971
    //   1932: aload 14
    //   1934: astore 17
    //   1936: aload 14
    //   1938: astore 16
    //   1940: aload 14
    //   1942: astore 15
    //   1944: ldc 66
    //   1946: iconst_2
    //   1947: new 306	java/lang/StringBuilder
    //   1950: dup
    //   1951: invokespecial 307	java/lang/StringBuilder:<init>	()V
    //   1954: ldc_w 834
    //   1957: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1960: aload 19
    //   1962: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1965: invokevirtual 314	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1968: invokestatic 533	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1971: aload 14
    //   1973: astore 17
    //   1975: aload 14
    //   1977: astore 16
    //   1979: aload 14
    //   1981: astore 15
    //   1983: aload 19
    //   1985: invokestatic 839	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1988: ifeq +35 -> 2023
    //   1991: aload 14
    //   1993: astore 17
    //   1995: aload 14
    //   1997: astore 16
    //   1999: aload 14
    //   2001: astore 15
    //   2003: aload 20
    //   2005: bipush 20
    //   2007: putfield 538	com/tencent/mobileqq/emoticon/DownloadInfo:resultCode	I
    //   2010: aload 14
    //   2012: ifnull +8 -> 2020
    //   2015: aload 14
    //   2017: invokevirtual 760	java/net/HttpURLConnection:disconnect	()V
    //   2020: aload 20
    //   2022: areturn
    //   2023: aload 14
    //   2025: astore 17
    //   2027: aload 14
    //   2029: astore 16
    //   2031: aload 14
    //   2033: astore 15
    //   2035: aload 14
    //   2037: invokevirtual 760	java/net/HttpURLConnection:disconnect	()V
    //   2040: aload_2
    //   2041: ifnull +88 -> 2129
    //   2044: aload_2
    //   2045: invokeinterface 842 1 0
    //   2050: istore 10
    //   2052: iconst_0
    //   2053: istore 8
    //   2055: iload 8
    //   2057: iload 10
    //   2059: if_icmpge +41 -> 2100
    //   2062: aload_2
    //   2063: iload 8
    //   2065: invokeinterface 846 2 0
    //   2070: checkcast 737	org/apache/http/Header
    //   2073: astore 14
    //   2075: aload 14
    //   2077: invokeinterface 740 1 0
    //   2082: ldc_w 848
    //   2085: invokevirtual 696	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2088: ifeq +76 -> 2164
    //   2091: aload_2
    //   2092: aload 14
    //   2094: invokeinterface 851 2 0
    //   2099: pop
    //   2100: aload_2
    //   2101: new 853	org/apache/http/message/BasicHeader
    //   2104: dup
    //   2105: ldc_w 848
    //   2108: new 279	java/net/URL
    //   2111: dup
    //   2112: aload 19
    //   2114: invokespecial 283	java/net/URL:<init>	(Ljava/lang/String;)V
    //   2117: invokevirtual 397	java/net/URL:getHost	()Ljava/lang/String;
    //   2120: invokespecial 855	org/apache/http/message/BasicHeader:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   2123: invokeinterface 858 2 0
    //   2128: pop
    //   2129: aload 19
    //   2131: aload_1
    //   2132: aload_2
    //   2133: iload_3
    //   2134: iload 4
    //   2136: iload 5
    //   2138: iconst_1
    //   2139: iadd
    //   2140: iload 6
    //   2142: iload 7
    //   2144: invokestatic 664	com/tencent/mobileqq/utils/HttpDownloadUtil:queryDownloadInfo	(Ljava/lang/String;Lcom/tencent/mobileqq/utils/HttpDownloadUtil$DownloadInfoListener;Ljava/util/List;IZIII)Lcom/tencent/mobileqq/emoticon/DownloadInfo;
    //   2147: astore 14
    //   2149: aload 14
    //   2151: astore_0
    //   2152: iconst_0
    //   2153: ifeq -2110 -> 43
    //   2156: new 860	java/lang/NullPointerException
    //   2159: dup
    //   2160: invokespecial 861	java/lang/NullPointerException:<init>	()V
    //   2163: athrow
    //   2164: iload 8
    //   2166: iconst_1
    //   2167: iadd
    //   2168: istore 8
    //   2170: goto -115 -> 2055
    //   2173: aload 14
    //   2175: astore 17
    //   2177: aload 14
    //   2179: astore 16
    //   2181: aload 14
    //   2183: astore 15
    //   2185: aload 20
    //   2187: aload 20
    //   2189: getfield 754	com/tencent/mobileqq/emoticon/DownloadInfo:httpRespCode	I
    //   2192: putfield 538	com/tencent/mobileqq/emoticon/DownloadInfo:resultCode	I
    //   2195: goto -409 -> 1786
    //   2198: astore_0
    //   2199: aload 15
    //   2201: ifnull +8 -> 2209
    //   2204: aload 15
    //   2206: invokevirtual 760	java/net/HttpURLConnection:disconnect	()V
    //   2209: aload_0
    //   2210: athrow
    //   2211: aload 14
    //   2213: astore 15
    //   2215: aload 16
    //   2217: instanceof 516
    //   2220: ifne +151 -> 2371
    //   2223: aload 14
    //   2225: astore 15
    //   2227: aload 16
    //   2229: instanceof 518
    //   2232: ifeq +6 -> 2238
    //   2235: goto +136 -> 2371
    //   2238: aload 14
    //   2240: astore 15
    //   2242: aload 16
    //   2244: instanceof 535
    //   2247: ifeq +17 -> 2264
    //   2250: aload 14
    //   2252: astore 15
    //   2254: aload 20
    //   2256: bipush 11
    //   2258: putfield 538	com/tencent/mobileqq/emoticon/DownloadInfo:resultCode	I
    //   2261: goto -1397 -> 864
    //   2264: aload 14
    //   2266: astore 15
    //   2268: aload 16
    //   2270: instanceof 269
    //   2273: istore 13
    //   2275: iload 13
    //   2277: ifeq +13 -> 2290
    //   2280: bipush 13
    //   2282: istore 8
    //   2284: iload_3
    //   2285: istore 9
    //   2287: goto -1423 -> 864
    //   2290: iconst_4
    //   2291: istore 8
    //   2293: goto -1429 -> 864
    //   2296: astore_0
    //   2297: aload 21
    //   2299: monitorexit
    //   2300: aload_0
    //   2301: athrow
    //   2302: aload_1
    //   2303: ifnull +12 -> 2315
    //   2306: aload_1
    //   2307: aload 20
    //   2309: invokeinterface 680 2 0
    //   2314: pop
    //   2315: aload 15
    //   2317: astore 14
    //   2319: goto +43 -> 2362
    //   2322: astore 15
    //   2324: goto -2038 -> 286
    //   2327: astore 14
    //   2329: goto -1315 -> 1014
    //   2332: astore_0
    //   2333: aconst_null
    //   2334: astore 15
    //   2336: goto -137 -> 2199
    //   2339: astore 16
    //   2341: aconst_null
    //   2342: astore 14
    //   2344: goto -1291 -> 1053
    //   2347: astore 16
    //   2349: aconst_null
    //   2350: astore 14
    //   2352: goto -1529 -> 823
    //   2355: iload 8
    //   2357: istore 9
    //   2359: goto -2264 -> 95
    //   2362: iload 8
    //   2364: iload_3
    //   2365: if_icmplt -10 -> 2355
    //   2368: aload 20
    //   2370: areturn
    //   2371: iconst_2
    //   2372: istore 8
    //   2374: goto -1510 -> 864
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2377	0	paramString	String
    //   0	2377	1	paramDownloadInfoListener	HttpDownloadUtil.DownloadInfoListener
    //   0	2377	2	paramList	List<Header>
    //   0	2377	3	paramInt1	int
    //   0	2377	4	paramBoolean	boolean
    //   0	2377	5	paramInt2	int
    //   0	2377	6	paramInt3	int
    //   0	2377	7	paramInt4	int
    //   130	2243	8	i	int
    //   88	2270	9	j	int
    //   379	1681	10	k	int
    //   93	920	11	l	long
    //   2273	3	13	bool	boolean
    //   85	1	14	localObject1	Object
    //   203	456	14	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   671	1647	14	localObject2	Object
    //   2327	1	14	localInterruptedException1	java.lang.InterruptedException
    //   2342	9	14	localObject3	Object
    //   319	716	15	localObject4	Object
    //   1043	7	15	localException1	Exception
    //   1055	1261	15	localObject5	Object
    //   2322	1	15	localInterruptedException2	java.lang.InterruptedException
    //   2334	1	15	localObject6	Object
    //   315	475	16	localObject7	Object
    //   817	128	16	localIOException1	java.io.IOException
    //   1030	1239	16	localObject8	Object
    //   2339	1	16	localException2	Exception
    //   2347	1	16	localIOException2	java.io.IOException
    //   311	1865	17	localObject9	Object
    //   63	1226	18	str	String
    //   299	1831	19	localObject10	Object
    //   10	2359	20	localDownloadInfo	DownloadInfo
    //   82	2216	21	localObject11	Object
    //   98	1163	22	localObject12	Object
    // Exception table:
    //   from	to	target	type
    //   45	58	154	java/net/MalformedURLException
    //   65	75	203	java/lang/IllegalArgumentException
    //   205	225	228	java/lang/IllegalArgumentException
    //   271	278	292	finally
    //   286	289	292	finally
    //   293	296	292	finally
    //   321	328	817	java/io/IOException
    //   340	347	817	java/io/IOException
    //   359	364	817	java/io/IOException
    //   376	381	817	java/io/IOException
    //   393	400	817	java/io/IOException
    //   412	423	817	java/io/IOException
    //   435	440	817	java/io/IOException
    //   458	469	817	java/io/IOException
    //   481	485	817	java/io/IOException
    //   503	514	817	java/io/IOException
    //   526	537	817	java/io/IOException
    //   549	553	817	java/io/IOException
    //   565	571	817	java/io/IOException
    //   593	604	817	java/io/IOException
    //   616	627	817	java/io/IOException
    //   639	650	817	java/io/IOException
    //   662	673	817	java/io/IOException
    //   685	692	817	java/io/IOException
    //   708	717	817	java/io/IOException
    //   729	737	817	java/io/IOException
    //   749	759	817	java/io/IOException
    //   771	783	817	java/io/IOException
    //   795	814	817	java/io/IOException
    //   1036	1040	817	java/io/IOException
    //   1209	1220	817	java/io/IOException
    //   1232	1243	817	java/io/IOException
    //   1258	1269	817	java/io/IOException
    //   1284	1304	817	java/io/IOException
    //   1319	1330	817	java/io/IOException
    //   1342	1349	817	java/io/IOException
    //   1361	1368	817	java/io/IOException
    //   1380	1386	817	java/io/IOException
    //   1398	1403	817	java/io/IOException
    //   1415	1425	817	java/io/IOException
    //   1437	1447	817	java/io/IOException
    //   1459	1469	817	java/io/IOException
    //   1481	1491	817	java/io/IOException
    //   1503	1510	817	java/io/IOException
    //   1522	1528	817	java/io/IOException
    //   1540	1608	817	java/io/IOException
    //   1625	1631	817	java/io/IOException
    //   1647	1656	817	java/io/IOException
    //   1681	1692	817	java/io/IOException
    //   1708	1714	817	java/io/IOException
    //   1726	1737	817	java/io/IOException
    //   1749	1755	817	java/io/IOException
    //   1780	1786	817	java/io/IOException
    //   1827	1833	817	java/io/IOException
    //   1858	1869	817	java/io/IOException
    //   1881	1892	817	java/io/IOException
    //   1904	1914	817	java/io/IOException
    //   1926	1932	817	java/io/IOException
    //   1944	1971	817	java/io/IOException
    //   1983	1991	817	java/io/IOException
    //   2003	2010	817	java/io/IOException
    //   2035	2040	817	java/io/IOException
    //   2185	2195	817	java/io/IOException
    //   321	328	1043	java/lang/Exception
    //   340	347	1043	java/lang/Exception
    //   359	364	1043	java/lang/Exception
    //   376	381	1043	java/lang/Exception
    //   393	400	1043	java/lang/Exception
    //   412	423	1043	java/lang/Exception
    //   435	440	1043	java/lang/Exception
    //   458	469	1043	java/lang/Exception
    //   481	485	1043	java/lang/Exception
    //   503	514	1043	java/lang/Exception
    //   526	537	1043	java/lang/Exception
    //   549	553	1043	java/lang/Exception
    //   565	571	1043	java/lang/Exception
    //   593	604	1043	java/lang/Exception
    //   616	627	1043	java/lang/Exception
    //   639	650	1043	java/lang/Exception
    //   662	673	1043	java/lang/Exception
    //   685	692	1043	java/lang/Exception
    //   708	717	1043	java/lang/Exception
    //   729	737	1043	java/lang/Exception
    //   749	759	1043	java/lang/Exception
    //   771	783	1043	java/lang/Exception
    //   795	814	1043	java/lang/Exception
    //   1036	1040	1043	java/lang/Exception
    //   1209	1220	1043	java/lang/Exception
    //   1232	1243	1043	java/lang/Exception
    //   1258	1269	1043	java/lang/Exception
    //   1284	1304	1043	java/lang/Exception
    //   1319	1330	1043	java/lang/Exception
    //   1342	1349	1043	java/lang/Exception
    //   1361	1368	1043	java/lang/Exception
    //   1380	1386	1043	java/lang/Exception
    //   1398	1403	1043	java/lang/Exception
    //   1415	1425	1043	java/lang/Exception
    //   1437	1447	1043	java/lang/Exception
    //   1459	1469	1043	java/lang/Exception
    //   1481	1491	1043	java/lang/Exception
    //   1503	1510	1043	java/lang/Exception
    //   1522	1528	1043	java/lang/Exception
    //   1540	1608	1043	java/lang/Exception
    //   1625	1631	1043	java/lang/Exception
    //   1647	1656	1043	java/lang/Exception
    //   1681	1692	1043	java/lang/Exception
    //   1708	1714	1043	java/lang/Exception
    //   1726	1737	1043	java/lang/Exception
    //   1749	1755	1043	java/lang/Exception
    //   1780	1786	1043	java/lang/Exception
    //   1827	1833	1043	java/lang/Exception
    //   1858	1869	1043	java/lang/Exception
    //   1881	1892	1043	java/lang/Exception
    //   1904	1914	1043	java/lang/Exception
    //   1926	1932	1043	java/lang/Exception
    //   1944	1971	1043	java/lang/Exception
    //   1983	1991	1043	java/lang/Exception
    //   2003	2010	1043	java/lang/Exception
    //   2035	2040	1043	java/lang/Exception
    //   2185	2195	1043	java/lang/Exception
    //   321	328	2198	finally
    //   340	347	2198	finally
    //   359	364	2198	finally
    //   376	381	2198	finally
    //   393	400	2198	finally
    //   412	423	2198	finally
    //   435	440	2198	finally
    //   458	469	2198	finally
    //   481	485	2198	finally
    //   503	514	2198	finally
    //   526	537	2198	finally
    //   549	553	2198	finally
    //   565	571	2198	finally
    //   593	604	2198	finally
    //   616	627	2198	finally
    //   639	650	2198	finally
    //   662	673	2198	finally
    //   685	692	2198	finally
    //   708	717	2198	finally
    //   729	737	2198	finally
    //   749	759	2198	finally
    //   771	783	2198	finally
    //   795	814	2198	finally
    //   827	833	2198	finally
    //   837	842	2198	finally
    //   849	857	2198	finally
    //   868	875	2198	finally
    //   879	885	2198	finally
    //   889	958	2198	finally
    //   1036	1040	2198	finally
    //   1057	1063	2198	finally
    //   1067	1072	2198	finally
    //   1076	1082	2198	finally
    //   1086	1092	2198	finally
    //   1096	1168	2198	finally
    //   1209	1220	2198	finally
    //   1232	1243	2198	finally
    //   1258	1269	2198	finally
    //   1284	1304	2198	finally
    //   1319	1330	2198	finally
    //   1342	1349	2198	finally
    //   1361	1368	2198	finally
    //   1380	1386	2198	finally
    //   1398	1403	2198	finally
    //   1415	1425	2198	finally
    //   1437	1447	2198	finally
    //   1459	1469	2198	finally
    //   1481	1491	2198	finally
    //   1503	1510	2198	finally
    //   1522	1528	2198	finally
    //   1540	1608	2198	finally
    //   1625	1631	2198	finally
    //   1647	1656	2198	finally
    //   1681	1692	2198	finally
    //   1708	1714	2198	finally
    //   1726	1737	2198	finally
    //   1749	1755	2198	finally
    //   1780	1786	2198	finally
    //   1827	1833	2198	finally
    //   1858	1869	2198	finally
    //   1881	1892	2198	finally
    //   1904	1914	2198	finally
    //   1926	1932	2198	finally
    //   1944	1971	2198	finally
    //   1983	1991	2198	finally
    //   2003	2010	2198	finally
    //   2035	2040	2198	finally
    //   2185	2195	2198	finally
    //   2215	2223	2198	finally
    //   2227	2235	2198	finally
    //   2242	2250	2198	finally
    //   2254	2261	2198	finally
    //   2268	2275	2198	finally
    //   999	1006	2296	finally
    //   1014	1017	2296	finally
    //   2297	2300	2296	finally
    //   271	278	2322	java/lang/InterruptedException
    //   999	1006	2327	java/lang/InterruptedException
    //   2044	2052	2332	finally
    //   2062	2100	2332	finally
    //   2100	2129	2332	finally
    //   2129	2149	2332	finally
    //   2044	2052	2339	java/lang/Exception
    //   2062	2100	2339	java/lang/Exception
    //   2100	2129	2339	java/lang/Exception
    //   2129	2149	2339	java/lang/Exception
    //   2044	2052	2347	java/io/IOException
    //   2062	2100	2347	java/io/IOException
    //   2100	2129	2347	java/io/IOException
    //   2129	2149	2347	java/io/IOException
  }
  
  public static boolean shutdownSniSupport()
  {
    if (!sShutdownSniSupportInited) {
      sShutdownSniSupportInited = true;
    }
    try
    {
      Object localObject = ((IQQUtilsApi)QRoute.api(IQQUtilsApi.class)).getFeatureValueAioConfig();
      if (QLog.isColorLevel()) {
        QLog.d("HttpDownloadUtil", 2, "shutdownSniSupport:" + (String)localObject);
      }
      localObject = ((String)localObject).split("\\|");
      if (localObject.length > 15) {
        sShutdownSniSupport = localObject[15].equals("1");
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("HttpDownloadUtil", 2, "shutdownSniSupport e:" + localException.toString());
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("HttpDownloadUtil", 2, "shutdownSniSupport " + sShutdownSniSupport);
    }
    return sShutdownSniSupport;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.HttpDownloadUtil
 * JD-Core Version:    0.7.0.1
 */