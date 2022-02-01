package com.tencent.mobileqq.utils;

import android.net.NetworkInfo;
import android.os.Build.VERSION;
import com.tencent.mobileqq.emoticon.DownloadInfo;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.TlsSniSocketFactory;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.IUtilApi;
import com.tencent.util.UtilApi;
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
  public static final DefaultHttpClient CLIENT;
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
  public static String PROTOCOL_HTTPS = "https://";
  public static final int RESOURCE_EXIST = 19;
  public static final String TAG = "HttpDownloadUtil";
  public static final int UNZIP_FAIL = 17;
  public static final int UNZIP_SUCCESS = 18;
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
    try
    {
      int i = Build.VERSION.SDK_INT;
      if ((i < 23) && (!shutdownSniSupport()))
      {
        ((SchemeRegistry)localObject).register(new Scheme("https", new TlsSniSocketFactory(HttpDownloadUtil.class.getSimpleName()), 443));
      }
      else
      {
        SSLSocketFactory localSSLSocketFactory = SSLSocketFactory.getSocketFactory();
        localSSLSocketFactory.setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
        ((SchemeRegistry)localObject).register(new Scheme("https", localSSLSocketFactory, 443));
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("HttpDownloadUtil", 2, "createHttpClient():Can't support https on this devices.", localException);
      }
    }
    localObject = new ThreadSafeClientConnManager(localBasicHttpParams, (SchemeRegistry)localObject);
    CLIENT = new DefaultHttpClient((ClientConnectionManager)localObject, localBasicHttpParams);
    CLIENT.setHttpRequestRetryHandler(new DefaultHttpRequestRetryHandler());
    idleConnectionMonitorThread = new HttpDownloadUtil.IdleConnectionMonitorThread((ClientConnectionManager)localObject);
    idleConnectionMonitorThread.setName("IdleConnectionMonitorThread");
    idleConnectionMonitorThread.start();
    lastApn = null;
    forceDirect = false;
    forceDomain = false;
  }
  
  private static boolean checkValid(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HttpDownloadUtil", 2, "DownloadInfo is null.");
      }
      return false;
    }
    if (paramDownloadInfo.file == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HttpDownloadUtil", 2, "DownloadInfo.file is null.");
      }
      return false;
    }
    return true;
  }
  
  static void copyRespHeader(HttpURLConnection paramHttpURLConnection, DownloadInfo paramDownloadInfo)
  {
    if (paramHttpURLConnection != null)
    {
      if (paramDownloadInfo == null) {
        return;
      }
      if (paramHttpURLConnection.getHeaderField("X-FailNo") != null) {
        paramDownloadInfo.respXFailNo = paramHttpURLConnection.getHeaderField("X-FailNo");
      }
      if (paramHttpURLConnection.getHeaderField("X-ErrNo") != null) {
        paramDownloadInfo.respXErrNo = paramHttpURLConnection.getHeaderField("X-ErrNo");
      }
    }
  }
  
  /* Error */
  private static int download(AppRuntime paramAppRuntime, DownloadInfo paramDownloadInfo, NetworkInfo paramNetworkInfo, HttpDownloadUtil.HttpDownloadListener paramHttpDownloadListener)
  {
    // Byte code:
    //   0: aload_3
    //   1: astore 22
    //   3: aload_1
    //   4: invokestatic 277	com/tencent/mobileqq/utils/HttpDownloadUtil:checkValid	(Lcom/tencent/mobileqq/emoticon/DownloadInfo;)Z
    //   7: ifne +5 -> 12
    //   10: iconst_5
    //   11: ireturn
    //   12: new 279	java/net/URL
    //   15: dup
    //   16: aload_1
    //   17: getfield 282	com/tencent/mobileqq/emoticon/DownloadInfo:reqUrl	Ljava/lang/String;
    //   20: invokespecial 283	java/net/URL:<init>	(Ljava/lang/String;)V
    //   23: astore 32
    //   25: invokestatic 90	java/lang/System:currentTimeMillis	()J
    //   28: lstore 13
    //   30: new 4	java/lang/Object
    //   33: dup
    //   34: invokespecial 231	java/lang/Object:<init>	()V
    //   37: astore 33
    //   39: aload_1
    //   40: getfield 245	com/tencent/mobileqq/emoticon/DownloadInfo:file	Ljava/io/File;
    //   43: invokevirtual 289	java/io/File:getParentFile	()Ljava/io/File;
    //   46: astore_0
    //   47: aload_0
    //   48: ifnull +78 -> 126
    //   51: aload_0
    //   52: invokevirtual 292	java/io/File:exists	()Z
    //   55: ifne +71 -> 126
    //   58: aload_0
    //   59: invokevirtual 295	java/io/File:mkdirs	()Z
    //   62: ifne +64 -> 126
    //   65: aload 22
    //   67: ifnull +16 -> 83
    //   70: aload 22
    //   72: aload 32
    //   74: invokevirtual 298	java/net/URL:toString	()Ljava/lang/String;
    //   77: iconst_4
    //   78: invokeinterface 304 3 0
    //   83: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   86: ifeq +38 -> 124
    //   89: new 306	java/lang/StringBuilder
    //   92: dup
    //   93: invokespecial 307	java/lang/StringBuilder:<init>	()V
    //   96: astore_0
    //   97: aload_0
    //   98: ldc_w 309
    //   101: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: pop
    //   105: aload_0
    //   106: aload_1
    //   107: getfield 282	com/tencent/mobileqq/emoticon/DownloadInfo:reqUrl	Ljava/lang/String;
    //   110: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: pop
    //   114: ldc 68
    //   116: iconst_2
    //   117: aload_0
    //   118: invokevirtual 314	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   121: invokestatic 239	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   124: iconst_4
    //   125: ireturn
    //   126: aload_1
    //   127: getfield 282	com/tencent/mobileqq/emoticon/DownloadInfo:reqUrl	Ljava/lang/String;
    //   130: astore 18
    //   132: new 316	org/apache/http/client/methods/HttpGet
    //   135: dup
    //   136: aload 18
    //   138: invokespecial 317	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   141: astore_0
    //   142: goto +19 -> 161
    //   145: new 316	org/apache/http/client/methods/HttpGet
    //   148: dup
    //   149: aload 18
    //   151: invokestatic 320	com/tencent/mobileqq/utils/HttpDownloadUtil:getEscapeSequence	(Ljava/lang/String;)Ljava/lang/String;
    //   154: invokespecial 317	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   157: astore_0
    //   158: goto -16 -> 142
    //   161: new 94	org/apache/http/params/BasicHttpParams
    //   164: dup
    //   165: invokespecial 97	org/apache/http/params/BasicHttpParams:<init>	()V
    //   168: astore 19
    //   170: aload 19
    //   172: ldc_w 322
    //   175: ldc_w 323
    //   178: invokestatic 329	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   181: invokeinterface 335 3 0
    //   186: pop
    //   187: aload 19
    //   189: ldc_w 337
    //   192: ldc_w 323
    //   195: invokestatic 329	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   198: invokeinterface 335 3 0
    //   203: pop
    //   204: invokestatic 342	android/net/Proxy:getDefaultHost	()Ljava/lang/String;
    //   207: astore 18
    //   209: invokestatic 346	android/net/Proxy:getDefaultPort	()I
    //   212: istore 4
    //   214: aload_2
    //   215: ifnull +106 -> 321
    //   218: aload_2
    //   219: invokevirtual 351	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   222: astore 20
    //   224: aload_2
    //   225: invokestatic 357	com/tencent/mobileqq/utils/NetworkUtil:isMobileNetworkInfo	(Landroid/net/NetworkInfo;)Z
    //   228: ifeq +51 -> 279
    //   231: aload 20
    //   233: ifnull +14 -> 247
    //   236: aload 20
    //   238: ldc_w 359
    //   241: invokevirtual 365	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   244: ifeq +35 -> 279
    //   247: aload 18
    //   249: ifnull +30 -> 279
    //   252: iload 4
    //   254: ifle +25 -> 279
    //   257: aload 19
    //   259: ldc_w 367
    //   262: new 369	org/apache/http/HttpHost
    //   265: dup
    //   266: aload 18
    //   268: iload 4
    //   270: invokespecial 371	org/apache/http/HttpHost:<init>	(Ljava/lang/String;I)V
    //   273: invokeinterface 335 3 0
    //   278: pop
    //   279: aload_2
    //   280: invokestatic 357	com/tencent/mobileqq/utils/NetworkUtil:isMobileNetworkInfo	(Landroid/net/NetworkInfo;)Z
    //   283: ifeq +11 -> 294
    //   286: sipush 2048
    //   289: istore 4
    //   291: goto +8 -> 299
    //   294: sipush 4096
    //   297: istore 4
    //   299: aload 19
    //   301: ldc_w 373
    //   304: iload 4
    //   306: invokeinterface 377 3 0
    //   311: pop
    //   312: aload_0
    //   313: aload 19
    //   315: invokevirtual 381	org/apache/http/client/methods/HttpGet:setParams	(Lorg/apache/http/params/HttpParams;)V
    //   318: goto +6 -> 324
    //   321: iconst_0
    //   322: istore 4
    //   324: new 285	java/io/File
    //   327: dup
    //   328: aload_1
    //   329: invokevirtual 384	com/tencent/mobileqq/emoticon/DownloadInfo:getLoadingTmpPath	()Ljava/lang/String;
    //   332: invokespecial 385	java/io/File:<init>	(Ljava/lang/String;)V
    //   335: astore 18
    //   337: aload 18
    //   339: invokevirtual 292	java/io/File:exists	()Z
    //   342: ifeq +9 -> 351
    //   345: aload 18
    //   347: invokevirtual 388	java/io/File:delete	()Z
    //   350: pop
    //   351: aconst_null
    //   352: astore 21
    //   354: aload 21
    //   356: astore 25
    //   358: iconst_m1
    //   359: istore 9
    //   361: aload_0
    //   362: astore 20
    //   364: iload 9
    //   366: ifne +38 -> 404
    //   369: aload 19
    //   371: ldc_w 367
    //   374: new 369	org/apache/http/HttpHost
    //   377: dup
    //   378: aload 32
    //   380: invokevirtual 391	java/net/URL:getHost	()Ljava/lang/String;
    //   383: aload 32
    //   385: invokevirtual 394	java/net/URL:getPort	()I
    //   388: invokespecial 371	org/apache/http/HttpHost:<init>	(Ljava/lang/String;I)V
    //   391: invokeinterface 335 3 0
    //   396: pop
    //   397: aload 20
    //   399: aload 19
    //   401: invokevirtual 381	org/apache/http/client/methods/HttpGet:setParams	(Lorg/apache/http/params/HttpParams;)V
    //   404: aload 21
    //   406: astore 24
    //   408: aload 25
    //   410: astore 26
    //   412: getstatic 197	com/tencent/mobileqq/utils/HttpDownloadUtil:CLIENT	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   415: new 369	org/apache/http/HttpHost
    //   418: dup
    //   419: aload 32
    //   421: invokevirtual 391	java/net/URL:getHost	()Ljava/lang/String;
    //   424: invokespecial 395	org/apache/http/HttpHost:<init>	(Ljava/lang/String;)V
    //   427: aload 20
    //   429: invokevirtual 399	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/HttpHost;Lorg/apache/http/HttpRequest;)Lorg/apache/http/HttpResponse;
    //   432: astore_0
    //   433: aload 21
    //   435: astore 24
    //   437: aload 25
    //   439: astore 26
    //   441: aload_0
    //   442: invokeinterface 405 1 0
    //   447: astore 23
    //   449: aload 21
    //   451: astore 24
    //   453: aload 25
    //   455: astore 26
    //   457: aload_0
    //   458: invokeinterface 409 1 0
    //   463: pop
    //   464: aload 21
    //   466: astore 24
    //   468: aload 25
    //   470: astore 26
    //   472: aload 23
    //   474: invokeinterface 414 1 0
    //   479: istore 5
    //   481: aload 22
    //   483: ifnull +55 -> 538
    //   486: aload 21
    //   488: astore 24
    //   490: aload 25
    //   492: astore 26
    //   494: aload 22
    //   496: aload 32
    //   498: invokevirtual 298	java/net/URL:toString	()Ljava/lang/String;
    //   501: iload 5
    //   503: invokeinterface 417 3 0
    //   508: goto +30 -> 538
    //   511: astore 23
    //   513: aload 18
    //   515: astore_0
    //   516: aload 22
    //   518: astore 18
    //   520: iconst_5
    //   521: istore 5
    //   523: aload 23
    //   525: astore 22
    //   527: iload 4
    //   529: istore 6
    //   531: aload 25
    //   533: astore 23
    //   535: goto +1893 -> 2428
    //   538: aload 21
    //   540: astore 24
    //   542: aload 25
    //   544: astore 26
    //   546: aload_0
    //   547: invokeinterface 421 1 0
    //   552: astore 23
    //   554: sipush 200
    //   557: iload 5
    //   559: if_icmpne +1461 -> 2020
    //   562: aload 21
    //   564: astore 24
    //   566: aload 23
    //   568: astore 26
    //   570: aload 23
    //   572: invokeinterface 426 1 0
    //   577: lstore 11
    //   579: aload 18
    //   581: astore 26
    //   583: new 428	java/io/FileOutputStream
    //   586: dup
    //   587: aload 26
    //   589: invokespecial 431	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   592: astore_0
    //   593: aload 23
    //   595: invokeinterface 435 1 0
    //   600: astore 25
    //   602: iload 4
    //   604: istore 5
    //   606: iload 4
    //   608: ifne +8 -> 616
    //   611: sipush 2048
    //   614: istore 5
    //   616: iload 5
    //   618: newarray byte
    //   620: astore 27
    //   622: iconst_0
    //   623: istore 10
    //   625: aload 19
    //   627: astore 21
    //   629: aload 20
    //   631: astore 24
    //   633: aload 22
    //   635: astore 19
    //   637: aload 25
    //   639: astore 22
    //   641: iload 5
    //   643: istore 4
    //   645: iload 10
    //   647: i2l
    //   648: lstore 15
    //   650: lload 15
    //   652: lload 11
    //   654: lcmp
    //   655: ifge +145 -> 800
    //   658: aload 22
    //   660: aload 27
    //   662: invokevirtual 441	java/io/InputStream:read	([B)I
    //   665: istore 5
    //   667: aload_0
    //   668: aload 27
    //   670: iconst_0
    //   671: iload 5
    //   673: invokevirtual 447	java/io/OutputStream:write	([BII)V
    //   676: iload 10
    //   678: iload 5
    //   680: iadd
    //   681: istore 10
    //   683: aload 19
    //   685: ifnull +68 -> 753
    //   688: aload 32
    //   690: invokevirtual 298	java/net/URL:toString	()Ljava/lang/String;
    //   693: astore 28
    //   695: iload 10
    //   697: i2l
    //   698: lstore 15
    //   700: iload 4
    //   702: istore 5
    //   704: aload 22
    //   706: astore 25
    //   708: aload 24
    //   710: astore 20
    //   712: aload 21
    //   714: astore 19
    //   716: aload_3
    //   717: aload 28
    //   719: lload 11
    //   721: lload 15
    //   723: invokeinterface 450 6 0
    //   728: goto +25 -> 753
    //   731: astore 21
    //   733: iload 5
    //   735: istore 4
    //   737: aload 25
    //   739: astore 22
    //   741: goto +824 -> 1565
    //   744: astore 19
    //   746: iload 5
    //   748: istore 4
    //   750: goto +28 -> 778
    //   753: aload_3
    //   754: astore 19
    //   756: goto -111 -> 645
    //   759: astore 25
    //   761: aload 24
    //   763: astore 20
    //   765: aload 21
    //   767: astore 19
    //   769: aload 25
    //   771: astore 21
    //   773: goto +745 -> 1518
    //   776: astore 19
    //   778: iconst_5
    //   779: istore 6
    //   781: aload 24
    //   783: astore 20
    //   785: aload 21
    //   787: astore 24
    //   789: aload 19
    //   791: astore 21
    //   793: aload 24
    //   795: astore 19
    //   797: goto +792 -> 1589
    //   800: aload 22
    //   802: astore 25
    //   804: aload 24
    //   806: astore 20
    //   808: aload 21
    //   810: astore 19
    //   812: lload 15
    //   814: lload 11
    //   816: lcmp
    //   817: ifne +74 -> 891
    //   820: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   823: ifeq +42 -> 865
    //   826: new 306	java/lang/StringBuilder
    //   829: dup
    //   830: invokespecial 307	java/lang/StringBuilder:<init>	()V
    //   833: astore 27
    //   835: aload 27
    //   837: ldc_w 452
    //   840: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   843: pop
    //   844: aload 27
    //   846: aload_1
    //   847: getfield 282	com/tencent/mobileqq/emoticon/DownloadInfo:reqUrl	Ljava/lang/String;
    //   850: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   853: pop
    //   854: ldc 68
    //   856: iconst_2
    //   857: aload 27
    //   859: invokevirtual 314	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   862: invokestatic 239	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   865: iconst_0
    //   866: istore 5
    //   868: goto +236 -> 1104
    //   871: astore 21
    //   873: iconst_0
    //   874: istore 5
    //   876: aload 25
    //   878: astore 31
    //   880: goto +953 -> 1833
    //   883: astore 19
    //   885: iconst_0
    //   886: istore 6
    //   888: goto -107 -> 781
    //   891: bipush 8
    //   893: istore 6
    //   895: iload 6
    //   897: istore 7
    //   899: iload 6
    //   901: istore 8
    //   903: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   906: istore 17
    //   908: iload 17
    //   910: ifeq +152 -> 1062
    //   913: iload 6
    //   915: istore 8
    //   917: iload 6
    //   919: istore 7
    //   921: new 306	java/lang/StringBuilder
    //   924: dup
    //   925: invokespecial 307	java/lang/StringBuilder:<init>	()V
    //   928: astore 27
    //   930: iload 6
    //   932: istore 8
    //   934: iload 6
    //   936: istore 7
    //   938: aload 27
    //   940: ldc_w 454
    //   943: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   946: pop
    //   947: iload 6
    //   949: istore 8
    //   951: iload 6
    //   953: istore 7
    //   955: aload 27
    //   957: iload 10
    //   959: invokevirtual 457	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   962: pop
    //   963: iload 6
    //   965: istore 8
    //   967: iload 6
    //   969: istore 7
    //   971: aload 27
    //   973: ldc_w 459
    //   976: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   979: pop
    //   980: iload 6
    //   982: istore 8
    //   984: iload 6
    //   986: istore 7
    //   988: aload 27
    //   990: lload 11
    //   992: invokevirtual 462	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   995: pop
    //   996: iload 6
    //   998: istore 8
    //   1000: iload 6
    //   1002: istore 7
    //   1004: aload 27
    //   1006: ldc_w 464
    //   1009: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1012: pop
    //   1013: iload 6
    //   1015: istore 8
    //   1017: iload 6
    //   1019: istore 7
    //   1021: aload 27
    //   1023: aload_1
    //   1024: getfield 282	com/tencent/mobileqq/emoticon/DownloadInfo:reqUrl	Ljava/lang/String;
    //   1027: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1030: pop
    //   1031: iload 6
    //   1033: istore 8
    //   1035: iload 6
    //   1037: istore 7
    //   1039: ldc 68
    //   1041: iconst_2
    //   1042: aload 27
    //   1044: invokevirtual 314	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1047: invokestatic 239	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1050: goto +12 -> 1062
    //   1053: astore 19
    //   1055: iload 8
    //   1057: istore 6
    //   1059: goto -278 -> 781
    //   1062: iload 6
    //   1064: istore 7
    //   1066: iload 6
    //   1068: istore 8
    //   1070: aload 26
    //   1072: invokevirtual 292	java/io/File:exists	()Z
    //   1075: istore 17
    //   1077: iload 6
    //   1079: istore 5
    //   1081: iload 17
    //   1083: ifeq +21 -> 1104
    //   1086: iload 6
    //   1088: istore 8
    //   1090: iload 6
    //   1092: istore 7
    //   1094: aload 26
    //   1096: invokevirtual 388	java/io/File:delete	()Z
    //   1099: pop
    //   1100: iload 6
    //   1102: istore 5
    //   1104: iload 5
    //   1106: istore 7
    //   1108: iload 5
    //   1110: istore 8
    //   1112: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1115: istore 17
    //   1117: iload 17
    //   1119: ifeq +109 -> 1228
    //   1122: iload 5
    //   1124: istore 8
    //   1126: iload 5
    //   1128: istore 7
    //   1130: new 306	java/lang/StringBuilder
    //   1133: dup
    //   1134: invokespecial 307	java/lang/StringBuilder:<init>	()V
    //   1137: astore 27
    //   1139: iload 5
    //   1141: istore 8
    //   1143: iload 5
    //   1145: istore 7
    //   1147: aload 27
    //   1149: ldc_w 466
    //   1152: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1155: pop
    //   1156: iload 5
    //   1158: istore 8
    //   1160: iload 5
    //   1162: istore 7
    //   1164: aload 27
    //   1166: invokestatic 90	java/lang/System:currentTimeMillis	()J
    //   1169: invokevirtual 462	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1172: pop
    //   1173: iload 5
    //   1175: istore 8
    //   1177: iload 5
    //   1179: istore 7
    //   1181: aload 27
    //   1183: ldc_w 468
    //   1186: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1189: pop
    //   1190: iload 5
    //   1192: istore 8
    //   1194: iload 5
    //   1196: istore 7
    //   1198: aload 27
    //   1200: aload_1
    //   1201: getfield 282	com/tencent/mobileqq/emoticon/DownloadInfo:reqUrl	Ljava/lang/String;
    //   1204: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1207: pop
    //   1208: iload 5
    //   1210: istore 8
    //   1212: iload 5
    //   1214: istore 7
    //   1216: ldc_w 469
    //   1219: iconst_2
    //   1220: aload 27
    //   1222: invokevirtual 314	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1225: invokestatic 239	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1228: iload 5
    //   1230: istore 7
    //   1232: iload 5
    //   1234: istore 8
    //   1236: aload_1
    //   1237: getfield 472	com/tencent/mobileqq/emoticon/DownloadInfo:action	I
    //   1240: istore 6
    //   1242: iload 6
    //   1244: sipush 10001
    //   1247: if_icmpeq +33 -> 1280
    //   1250: iload 5
    //   1252: istore 8
    //   1254: iload 5
    //   1256: istore 7
    //   1258: aload_2
    //   1259: invokestatic 357	com/tencent/mobileqq/utils/NetworkUtil:isMobileNetworkInfo	(Landroid/net/NetworkInfo;)Z
    //   1262: istore 17
    //   1264: iload 17
    //   1266: ifeq +6 -> 1272
    //   1269: goto +3 -> 1272
    //   1272: goto +30 -> 1302
    //   1275: astore 21
    //   1277: goto +220 -> 1497
    //   1280: iload 5
    //   1282: istore 7
    //   1284: iload 5
    //   1286: istore 8
    //   1288: aload_2
    //   1289: invokestatic 357	com/tencent/mobileqq/utils/NetworkUtil:isMobileNetworkInfo	(Landroid/net/NetworkInfo;)Z
    //   1292: istore 17
    //   1294: iload 17
    //   1296: ifeq +6 -> 1302
    //   1299: goto -27 -> 1272
    //   1302: iload 5
    //   1304: istore 7
    //   1306: aload 26
    //   1308: invokestatic 90	java/lang/System:currentTimeMillis	()J
    //   1311: invokevirtual 476	java/io/File:setLastModified	(J)Z
    //   1314: pop
    //   1315: iload 5
    //   1317: istore 7
    //   1319: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1322: ifeq +112 -> 1434
    //   1325: iload 5
    //   1327: istore 7
    //   1329: new 306	java/lang/StringBuilder
    //   1332: dup
    //   1333: invokespecial 307	java/lang/StringBuilder:<init>	()V
    //   1336: astore 21
    //   1338: iload 5
    //   1340: istore 7
    //   1342: aload 21
    //   1344: ldc_w 478
    //   1347: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1350: pop
    //   1351: iload 5
    //   1353: istore 7
    //   1355: aload 21
    //   1357: invokestatic 90	java/lang/System:currentTimeMillis	()J
    //   1360: lload 13
    //   1362: lsub
    //   1363: invokevirtual 462	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1366: pop
    //   1367: iload 5
    //   1369: istore 7
    //   1371: aload 21
    //   1373: ldc_w 480
    //   1376: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1379: pop
    //   1380: iload 5
    //   1382: istore 7
    //   1384: aload 21
    //   1386: lload 11
    //   1388: invokevirtual 462	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1391: pop
    //   1392: iload 5
    //   1394: istore 7
    //   1396: aload 21
    //   1398: ldc_w 482
    //   1401: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1404: pop
    //   1405: iload 5
    //   1407: istore 7
    //   1409: aload 21
    //   1411: aload_1
    //   1412: getfield 282	com/tencent/mobileqq/emoticon/DownloadInfo:reqUrl	Ljava/lang/String;
    //   1415: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1418: pop
    //   1419: iload 5
    //   1421: istore 7
    //   1423: ldc 68
    //   1425: iconst_2
    //   1426: aload 21
    //   1428: invokevirtual 314	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1431: invokestatic 485	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1434: aload 25
    //   1436: ifnull +39 -> 1475
    //   1439: aload 25
    //   1441: invokevirtual 488	java/io/InputStream:close	()V
    //   1444: goto +31 -> 1475
    //   1447: astore_1
    //   1448: aload_0
    //   1449: astore 24
    //   1451: aload_1
    //   1452: astore_0
    //   1453: goto +1471 -> 2924
    //   1456: astore 22
    //   1458: aload_3
    //   1459: astore 18
    //   1461: aload_0
    //   1462: astore 21
    //   1464: aload 26
    //   1466: astore_0
    //   1467: goto +833 -> 2300
    //   1470: astore 22
    //   1472: goto +505 -> 1977
    //   1475: goto +243 -> 1718
    //   1478: astore 21
    //   1480: iload 7
    //   1482: istore 5
    //   1484: aload 25
    //   1486: astore 31
    //   1488: goto +345 -> 1833
    //   1491: astore 21
    //   1493: iload 8
    //   1495: istore 5
    //   1497: iload 5
    //   1499: istore 6
    //   1501: aload 25
    //   1503: astore 22
    //   1505: goto +84 -> 1589
    //   1508: astore 21
    //   1510: aload 25
    //   1512: astore 22
    //   1514: iload 5
    //   1516: istore 4
    //   1518: goto +47 -> 1565
    //   1521: astore 21
    //   1523: aload 25
    //   1525: astore 22
    //   1527: iload 5
    //   1529: istore 4
    //   1531: goto +55 -> 1586
    //   1534: astore 21
    //   1536: goto +26 -> 1562
    //   1539: astore 21
    //   1541: goto +42 -> 1583
    //   1544: astore 22
    //   1546: goto +9 -> 1555
    //   1549: astore 22
    //   1551: goto +25 -> 1576
    //   1554: astore_0
    //   1555: aload 21
    //   1557: astore_0
    //   1558: aload 22
    //   1560: astore 21
    //   1562: aconst_null
    //   1563: astore 22
    //   1565: iconst_5
    //   1566: istore 5
    //   1568: aload 22
    //   1570: astore 31
    //   1572: goto +261 -> 1833
    //   1575: astore_0
    //   1576: aload 21
    //   1578: astore_0
    //   1579: aload 22
    //   1581: astore 21
    //   1583: aconst_null
    //   1584: astore 22
    //   1586: iconst_5
    //   1587: istore 6
    //   1589: iconst_3
    //   1590: istore 7
    //   1592: iload 7
    //   1594: istore 5
    //   1596: aload 21
    //   1598: instanceof 490
    //   1601: ifne +40 -> 1641
    //   1604: aload 21
    //   1606: instanceof 492
    //   1609: ifeq +10 -> 1619
    //   1612: iload 7
    //   1614: istore 5
    //   1616: goto +25 -> 1641
    //   1619: aload 21
    //   1621: instanceof 494
    //   1624: istore 17
    //   1626: iload 17
    //   1628: ifeq +10 -> 1638
    //   1631: bipush 11
    //   1633: istore 5
    //   1635: goto +6 -> 1641
    //   1638: iconst_4
    //   1639: istore 5
    //   1641: aload 22
    //   1643: ifnull +75 -> 1718
    //   1646: iload 4
    //   1648: istore 6
    //   1650: aload_0
    //   1651: astore 21
    //   1653: aload 19
    //   1655: astore 27
    //   1657: aload 20
    //   1659: astore 25
    //   1661: aload_0
    //   1662: astore 24
    //   1664: aload 23
    //   1666: astore 26
    //   1668: aload 22
    //   1670: invokevirtual 488	java/io/InputStream:close	()V
    //   1673: goto +45 -> 1718
    //   1676: astore 22
    //   1678: aload_3
    //   1679: astore 24
    //   1681: iload 6
    //   1683: istore 4
    //   1685: aload 27
    //   1687: astore 19
    //   1689: aload 25
    //   1691: astore 20
    //   1693: goto +312 -> 2005
    //   1696: astore 22
    //   1698: aload 18
    //   1700: astore 24
    //   1702: aload_3
    //   1703: astore 18
    //   1705: iload 4
    //   1707: istore 6
    //   1709: aload_0
    //   1710: astore 21
    //   1712: aload 24
    //   1714: astore_0
    //   1715: goto +713 -> 2428
    //   1718: aload 18
    //   1720: astore 31
    //   1722: iload 5
    //   1724: ifne +43 -> 1767
    //   1727: iload 4
    //   1729: istore 6
    //   1731: aload_0
    //   1732: astore 21
    //   1734: aload 19
    //   1736: astore 27
    //   1738: aload 20
    //   1740: astore 25
    //   1742: aload_0
    //   1743: astore 24
    //   1745: aload 23
    //   1747: astore 26
    //   1749: aload 31
    //   1751: aload_1
    //   1752: getfield 245	com/tencent/mobileqq/emoticon/DownloadInfo:file	Ljava/io/File;
    //   1755: invokevirtual 498	java/io/File:renameTo	(Ljava/io/File;)Z
    //   1758: pop
    //   1759: goto +8 -> 1767
    //   1762: astore 22
    //   1764: goto +213 -> 1977
    //   1767: aload_3
    //   1768: astore 21
    //   1770: aload 21
    //   1772: ifnull +1292 -> 3064
    //   1775: iload 4
    //   1777: istore 7
    //   1779: aload_0
    //   1780: astore 28
    //   1782: aload 19
    //   1784: astore 27
    //   1786: aload 20
    //   1788: astore 25
    //   1790: iload 4
    //   1792: istore 6
    //   1794: aload_0
    //   1795: astore 22
    //   1797: iload 5
    //   1799: istore 8
    //   1801: aload 19
    //   1803: astore 29
    //   1805: aload 20
    //   1807: astore 30
    //   1809: aload_0
    //   1810: astore 24
    //   1812: aload 23
    //   1814: astore 26
    //   1816: aload 21
    //   1818: aload 32
    //   1820: invokevirtual 298	java/net/URL:toString	()Ljava/lang/String;
    //   1823: iload 5
    //   1825: invokeinterface 304 3 0
    //   1830: goto +1234 -> 3064
    //   1833: aload 31
    //   1835: ifnull +49 -> 1884
    //   1838: iload 4
    //   1840: istore 7
    //   1842: aload_0
    //   1843: astore 28
    //   1845: aload 19
    //   1847: astore 27
    //   1849: aload 20
    //   1851: astore 25
    //   1853: iload 4
    //   1855: istore 6
    //   1857: aload_0
    //   1858: astore 22
    //   1860: iload 5
    //   1862: istore 8
    //   1864: aload 19
    //   1866: astore 29
    //   1868: aload 20
    //   1870: astore 30
    //   1872: aload_0
    //   1873: astore 24
    //   1875: aload 23
    //   1877: astore 26
    //   1879: aload 31
    //   1881: invokevirtual 488	java/io/InputStream:close	()V
    //   1884: iload 4
    //   1886: istore 7
    //   1888: aload_0
    //   1889: astore 28
    //   1891: aload 19
    //   1893: astore 27
    //   1895: aload 20
    //   1897: astore 25
    //   1899: iload 4
    //   1901: istore 6
    //   1903: aload_0
    //   1904: astore 22
    //   1906: iload 5
    //   1908: istore 8
    //   1910: aload 19
    //   1912: astore 29
    //   1914: aload 20
    //   1916: astore 30
    //   1918: aload_0
    //   1919: astore 24
    //   1921: aload 23
    //   1923: astore 26
    //   1925: aload 21
    //   1927: athrow
    //   1928: aload_3
    //   1929: astore 24
    //   1931: astore 22
    //   1933: iload 7
    //   1935: istore 4
    //   1937: aload 28
    //   1939: astore 21
    //   1941: aload 27
    //   1943: astore 19
    //   1945: aload 25
    //   1947: astore 20
    //   1949: goto +56 -> 2005
    //   1952: astore 21
    //   1954: aload 30
    //   1956: astore 20
    //   1958: aload 29
    //   1960: astore 19
    //   1962: iload 8
    //   1964: istore 5
    //   1966: aload 22
    //   1968: astore_0
    //   1969: iload 6
    //   1971: istore 4
    //   1973: aload 21
    //   1975: astore 22
    //   1977: aload_3
    //   1978: astore 24
    //   1980: iload 4
    //   1982: istore 6
    //   1984: aload_0
    //   1985: astore 21
    //   1987: aload 18
    //   1989: astore_0
    //   1990: aload 24
    //   1992: astore 18
    //   1994: goto +434 -> 2428
    //   1997: astore_0
    //   1998: aload 22
    //   2000: astore 24
    //   2002: aload_0
    //   2003: astore 22
    //   2005: aload 18
    //   2007: astore_0
    //   2008: aload 24
    //   2010: astore 18
    //   2012: goto +288 -> 2300
    //   2015: astore 24
    //   2017: goto +393 -> 2410
    //   2020: aload 18
    //   2022: astore 25
    //   2024: aload 22
    //   2026: astore 27
    //   2028: iload 4
    //   2030: istore 6
    //   2032: aload 21
    //   2034: astore_0
    //   2035: aload 25
    //   2037: astore 18
    //   2039: aload 27
    //   2041: astore 29
    //   2043: iload 5
    //   2045: istore 8
    //   2047: aload 19
    //   2049: astore 30
    //   2051: aload 20
    //   2053: astore 31
    //   2055: aload 27
    //   2057: ifnull +83 -> 2140
    //   2060: aload 21
    //   2062: astore 24
    //   2064: aload 23
    //   2066: astore 26
    //   2068: aload 27
    //   2070: aload 32
    //   2072: invokevirtual 298	java/net/URL:toString	()Ljava/lang/String;
    //   2075: iload 5
    //   2077: invokeinterface 304 3 0
    //   2082: iload 4
    //   2084: istore 6
    //   2086: aload 21
    //   2088: astore_0
    //   2089: aload 25
    //   2091: astore 18
    //   2093: aload 27
    //   2095: astore 29
    //   2097: iload 5
    //   2099: istore 8
    //   2101: aload 19
    //   2103: astore 30
    //   2105: aload 20
    //   2107: astore 31
    //   2109: goto +31 -> 2140
    //   2112: astore 22
    //   2114: aload 25
    //   2116: astore_0
    //   2117: aload 27
    //   2119: astore 18
    //   2121: goto +179 -> 2300
    //   2124: astore 22
    //   2126: iload 4
    //   2128: istore 6
    //   2130: aload 25
    //   2132: astore_0
    //   2133: aload 27
    //   2135: astore 18
    //   2137: goto +291 -> 2428
    //   2140: aload 23
    //   2142: ifnull +20 -> 2162
    //   2145: aload 23
    //   2147: invokeinterface 501 1 0
    //   2152: goto +10 -> 2162
    //   2155: astore 19
    //   2157: aload 19
    //   2159: invokevirtual 504	java/io/IOException:printStackTrace	()V
    //   2162: iload 6
    //   2164: istore 5
    //   2166: aload_0
    //   2167: astore 22
    //   2169: aload 18
    //   2171: astore 24
    //   2173: aload 29
    //   2175: astore 26
    //   2177: iload 8
    //   2179: istore 7
    //   2181: aload 23
    //   2183: astore 25
    //   2185: aload 30
    //   2187: astore 27
    //   2189: aload 31
    //   2191: astore 28
    //   2193: aload_0
    //   2194: ifnull +581 -> 2775
    //   2197: aload 31
    //   2199: astore 20
    //   2201: aload 30
    //   2203: astore 19
    //   2205: iload 8
    //   2207: istore 4
    //   2209: aload 29
    //   2211: astore 26
    //   2213: aload 18
    //   2215: astore 24
    //   2217: aload_0
    //   2218: astore 21
    //   2220: iload 6
    //   2222: istore 5
    //   2224: aload 21
    //   2226: invokevirtual 505	java/io/OutputStream:close	()V
    //   2229: aload 21
    //   2231: astore 22
    //   2233: iload 4
    //   2235: istore 7
    //   2237: aload 23
    //   2239: astore 25
    //   2241: aload 19
    //   2243: astore 27
    //   2245: aload 20
    //   2247: astore 28
    //   2249: goto +526 -> 2775
    //   2252: aload 21
    //   2254: astore 22
    //   2256: iload 4
    //   2258: istore 7
    //   2260: aload 23
    //   2262: astore 25
    //   2264: aload 19
    //   2266: astore 27
    //   2268: aload 20
    //   2270: astore 28
    //   2272: goto +503 -> 2775
    //   2275: astore_0
    //   2276: aload 26
    //   2278: astore 23
    //   2280: goto +644 -> 2924
    //   2283: astore 24
    //   2285: aload 18
    //   2287: astore_0
    //   2288: aload 22
    //   2290: astore 18
    //   2292: aload 25
    //   2294: astore 23
    //   2296: aload 24
    //   2298: astore 22
    //   2300: aload 21
    //   2302: astore 24
    //   2304: aload 23
    //   2306: astore 26
    //   2308: aload 22
    //   2310: invokevirtual 506	java/lang/Exception:printStackTrace	()V
    //   2313: aload 18
    //   2315: ifnull +24 -> 2339
    //   2318: aload 21
    //   2320: astore 24
    //   2322: aload 23
    //   2324: astore 26
    //   2326: aload 18
    //   2328: aload 32
    //   2330: invokevirtual 298	java/net/URL:toString	()Ljava/lang/String;
    //   2333: iconst_5
    //   2334: invokeinterface 304 3 0
    //   2339: aload 23
    //   2341: ifnull +20 -> 2361
    //   2344: aload 23
    //   2346: invokeinterface 501 1 0
    //   2351: goto +10 -> 2361
    //   2354: astore 22
    //   2356: aload 22
    //   2358: invokevirtual 504	java/io/IOException:printStackTrace	()V
    //   2361: aload 21
    //   2363: ifnull +8 -> 2371
    //   2366: aload 21
    //   2368: invokevirtual 505	java/io/OutputStream:close	()V
    //   2371: iconst_5
    //   2372: istore 7
    //   2374: iload 4
    //   2376: istore 5
    //   2378: aload 21
    //   2380: astore 22
    //   2382: aload_0
    //   2383: astore 24
    //   2385: aload 18
    //   2387: astore 26
    //   2389: aload 23
    //   2391: astore 25
    //   2393: aload 19
    //   2395: astore 27
    //   2397: aload 20
    //   2399: astore 28
    //   2401: goto +374 -> 2775
    //   2404: astore 24
    //   2406: aload 25
    //   2408: astore 23
    //   2410: aload 18
    //   2412: astore_0
    //   2413: iconst_5
    //   2414: istore 5
    //   2416: aload 22
    //   2418: astore 18
    //   2420: iload 4
    //   2422: istore 6
    //   2424: aload 24
    //   2426: astore 22
    //   2428: aload 21
    //   2430: astore 24
    //   2432: aload 23
    //   2434: astore 26
    //   2436: aload 22
    //   2438: invokevirtual 504	java/io/IOException:printStackTrace	()V
    //   2441: aload 21
    //   2443: astore 24
    //   2445: aload 23
    //   2447: astore 26
    //   2449: aload 22
    //   2451: instanceof 508
    //   2454: ifeq +10 -> 2464
    //   2457: bipush 10
    //   2459: istore 4
    //   2461: goto +75 -> 2536
    //   2464: aload 21
    //   2466: astore 24
    //   2468: aload 23
    //   2470: astore 26
    //   2472: aload 22
    //   2474: instanceof 490
    //   2477: ifne +633 -> 3110
    //   2480: aload 21
    //   2482: astore 24
    //   2484: aload 23
    //   2486: astore 26
    //   2488: aload 22
    //   2490: instanceof 492
    //   2493: ifeq +6 -> 2499
    //   2496: goto +614 -> 3110
    //   2499: aload 21
    //   2501: astore 24
    //   2503: aload 23
    //   2505: astore 26
    //   2507: aload 22
    //   2509: instanceof 494
    //   2512: ifeq +592 -> 3104
    //   2515: aload 21
    //   2517: astore 24
    //   2519: aload 23
    //   2521: astore 26
    //   2523: aload_1
    //   2524: bipush 11
    //   2526: putfield 511	com/tencent/mobileqq/emoticon/DownloadInfo:resultCode	I
    //   2529: iload 5
    //   2531: istore 4
    //   2533: goto +3 -> 2536
    //   2536: aload 21
    //   2538: astore 24
    //   2540: aload 23
    //   2542: astore 26
    //   2544: new 306	java/lang/StringBuilder
    //   2547: dup
    //   2548: invokespecial 307	java/lang/StringBuilder:<init>	()V
    //   2551: astore 25
    //   2553: aload 21
    //   2555: astore 24
    //   2557: aload 23
    //   2559: astore 26
    //   2561: aload 25
    //   2563: ldc_w 513
    //   2566: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2569: pop
    //   2570: aload 21
    //   2572: astore 24
    //   2574: aload 23
    //   2576: astore 26
    //   2578: aload 25
    //   2580: iload 4
    //   2582: invokevirtual 457	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2585: pop
    //   2586: aload 21
    //   2588: astore 24
    //   2590: aload 23
    //   2592: astore 26
    //   2594: aload 25
    //   2596: ldc_w 515
    //   2599: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2602: pop
    //   2603: aload 21
    //   2605: astore 24
    //   2607: aload 23
    //   2609: astore 26
    //   2611: aload 25
    //   2613: aload_1
    //   2614: getfield 282	com/tencent/mobileqq/emoticon/DownloadInfo:reqUrl	Ljava/lang/String;
    //   2617: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2620: pop
    //   2621: aload 21
    //   2623: astore 24
    //   2625: aload 23
    //   2627: astore 26
    //   2629: aload 25
    //   2631: ldc_w 517
    //   2634: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2637: pop
    //   2638: aload 21
    //   2640: astore 24
    //   2642: aload 23
    //   2644: astore 26
    //   2646: aload 25
    //   2648: aload 22
    //   2650: invokevirtual 520	java/io/IOException:getMessage	()Ljava/lang/String;
    //   2653: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2656: pop
    //   2657: aload 21
    //   2659: astore 24
    //   2661: aload 23
    //   2663: astore 26
    //   2665: ldc 68
    //   2667: iconst_2
    //   2668: aload 25
    //   2670: invokevirtual 314	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2673: invokestatic 523	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   2676: aload 18
    //   2678: ifnull +25 -> 2703
    //   2681: aload 21
    //   2683: astore 24
    //   2685: aload 23
    //   2687: astore 26
    //   2689: aload 18
    //   2691: aload 32
    //   2693: invokevirtual 298	java/net/URL:toString	()Ljava/lang/String;
    //   2696: iload 4
    //   2698: invokeinterface 304 3 0
    //   2703: aload 23
    //   2705: ifnull +20 -> 2725
    //   2708: aload 23
    //   2710: invokeinterface 501 1 0
    //   2715: goto +10 -> 2725
    //   2718: astore 22
    //   2720: aload 22
    //   2722: invokevirtual 504	java/io/IOException:printStackTrace	()V
    //   2725: iload 6
    //   2727: istore 5
    //   2729: aload 21
    //   2731: astore 22
    //   2733: aload_0
    //   2734: astore 24
    //   2736: aload 18
    //   2738: astore 26
    //   2740: iload 4
    //   2742: istore 7
    //   2744: aload 23
    //   2746: astore 25
    //   2748: aload 19
    //   2750: astore 27
    //   2752: aload 20
    //   2754: astore 28
    //   2756: aload 21
    //   2758: ifnull +17 -> 2775
    //   2761: iload 6
    //   2763: istore 5
    //   2765: aload_0
    //   2766: astore 24
    //   2768: aload 18
    //   2770: astore 26
    //   2772: goto -548 -> 2224
    //   2775: iload 9
    //   2777: iconst_1
    //   2778: iadd
    //   2779: istore 9
    //   2781: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2784: ifeq +56 -> 2840
    //   2787: new 306	java/lang/StringBuilder
    //   2790: dup
    //   2791: invokespecial 307	java/lang/StringBuilder:<init>	()V
    //   2794: astore_0
    //   2795: aload_0
    //   2796: ldc_w 525
    //   2799: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2802: pop
    //   2803: aload_0
    //   2804: iload 7
    //   2806: invokevirtual 457	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2809: pop
    //   2810: aload_0
    //   2811: ldc_w 527
    //   2814: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2817: pop
    //   2818: aload_0
    //   2819: aload_1
    //   2820: getfield 282	com/tencent/mobileqq/emoticon/DownloadInfo:reqUrl	Ljava/lang/String;
    //   2823: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2826: pop
    //   2827: ldc 68
    //   2829: iconst_2
    //   2830: aload_0
    //   2831: invokevirtual 314	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2834: invokestatic 239	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2837: goto +3 -> 2840
    //   2840: iload 9
    //   2842: iconst_2
    //   2843: if_icmpge +37 -> 2880
    //   2846: iload 7
    //   2848: ifeq +32 -> 2880
    //   2851: aload 33
    //   2853: monitorenter
    //   2854: aload 33
    //   2856: ldc2_w 528
    //   2859: invokevirtual 533	java/lang/Object:wait	(J)V
    //   2862: goto +7 -> 2869
    //   2865: astore_0
    //   2866: goto +9 -> 2875
    //   2869: aload 33
    //   2871: monitorexit
    //   2872: goto +8 -> 2880
    //   2875: aload 33
    //   2877: monitorexit
    //   2878: aload_0
    //   2879: athrow
    //   2880: iload 7
    //   2882: ifeq +39 -> 2921
    //   2885: iload 9
    //   2887: iconst_2
    //   2888: if_icmplt +6 -> 2894
    //   2891: iload 7
    //   2893: ireturn
    //   2894: aload 27
    //   2896: astore 19
    //   2898: aload 28
    //   2900: astore 20
    //   2902: aload 24
    //   2904: astore 18
    //   2906: iload 5
    //   2908: istore 4
    //   2910: aload 22
    //   2912: astore 21
    //   2914: aload 26
    //   2916: astore 22
    //   2918: goto -2554 -> 364
    //   2921: iload 7
    //   2923: ireturn
    //   2924: aload 23
    //   2926: ifnull +18 -> 2944
    //   2929: aload 23
    //   2931: invokeinterface 501 1 0
    //   2936: goto +8 -> 2944
    //   2939: astore_1
    //   2940: aload_1
    //   2941: invokevirtual 504	java/io/IOException:printStackTrace	()V
    //   2944: aload 24
    //   2946: ifnull +8 -> 2954
    //   2949: aload 24
    //   2951: invokevirtual 505	java/io/OutputStream:close	()V
    //   2954: aload_0
    //   2955: athrow
    //   2956: bipush 13
    //   2958: ireturn
    //   2959: aload 22
    //   2961: ifnull +16 -> 2977
    //   2964: aload 22
    //   2966: aload 32
    //   2968: invokevirtual 298	java/net/URL:toString	()Ljava/lang/String;
    //   2971: iconst_4
    //   2972: invokeinterface 304 3 0
    //   2977: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2980: ifeq +38 -> 3018
    //   2983: new 306	java/lang/StringBuilder
    //   2986: dup
    //   2987: invokespecial 307	java/lang/StringBuilder:<init>	()V
    //   2990: astore_0
    //   2991: aload_0
    //   2992: ldc_w 309
    //   2995: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2998: pop
    //   2999: aload_0
    //   3000: aload_1
    //   3001: getfield 282	com/tencent/mobileqq/emoticon/DownloadInfo:reqUrl	Ljava/lang/String;
    //   3004: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3007: pop
    //   3008: ldc 68
    //   3010: iconst_2
    //   3011: aload_0
    //   3012: invokevirtual 314	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3015: invokestatic 239	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3018: iconst_4
    //   3019: ireturn
    //   3020: astore_0
    //   3021: aload_0
    //   3022: invokevirtual 534	java/net/MalformedURLException:printStackTrace	()V
    //   3025: aload_1
    //   3026: aload_0
    //   3027: invokestatic 537	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   3030: putfield 540	com/tencent/mobileqq/emoticon/DownloadInfo:errorDetail	Ljava/lang/String;
    //   3033: iconst_5
    //   3034: ireturn
    //   3035: astore_0
    //   3036: goto -77 -> 2959
    //   3039: astore_0
    //   3040: goto -2895 -> 145
    //   3043: astore_0
    //   3044: goto -88 -> 2956
    //   3047: astore_0
    //   3048: goto -796 -> 2252
    //   3051: astore 22
    //   3053: goto -682 -> 2371
    //   3056: astore_0
    //   3057: goto -188 -> 2869
    //   3060: astore_1
    //   3061: goto -107 -> 2954
    //   3064: aload 31
    //   3066: astore 18
    //   3068: iload 4
    //   3070: istore 6
    //   3072: aload 21
    //   3074: astore 29
    //   3076: iload 5
    //   3078: istore 8
    //   3080: aload 19
    //   3082: astore 30
    //   3084: aload 20
    //   3086: astore 31
    //   3088: goto -948 -> 2140
    //   3091: astore 21
    //   3093: iload 6
    //   3095: istore 5
    //   3097: aload 22
    //   3099: astore 31
    //   3101: goto -1268 -> 1833
    //   3104: iconst_4
    //   3105: istore 4
    //   3107: goto -571 -> 2536
    //   3110: iconst_2
    //   3111: istore 4
    //   3113: goto -577 -> 2536
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3116	0	paramAppRuntime	AppRuntime
    //   0	3116	1	paramDownloadInfo	DownloadInfo
    //   0	3116	2	paramNetworkInfo	NetworkInfo
    //   0	3116	3	paramHttpDownloadListener	HttpDownloadUtil.HttpDownloadListener
    //   212	1318	4	i	int
    //   479	1049	5	j	int
    //   529	971	6	k	int
    //   897	584	7	m	int
    //   901	593	8	n	int
    //   359	6	9	i1	int
    //   623	335	10	i2	int
    //   577	810	11	l1	long
    //   28	1333	13	l2	long
    //   648	165	15	l3	long
    //   906	389	17	bool	boolean
    //   130	1330	18	localObject1	Object
    //   168	547	19	localObject2	Object
    //   744	1	19	localIOException1	java.io.IOException
    //   754	14	19	localObject3	Object
    //   776	14	19	localIOException2	java.io.IOException
    //   795	16	19	localObject4	Object
    //   883	1	19	localIOException3	java.io.IOException
    //   1053	1	19	localIOException4	java.io.IOException
    //   222	585	20	localObject5	Object
    //   352	361	21	localObject6	Object
    //   731	35	21	localObject7	Object
    //   771	38	21	localObject8	Object
    //   871	1	21	localObject9	Object
    //   1275	1	21	localIOException5	java.io.IOException
    //   1336	127	21	localObject10	Object
    //   1478	1	21	localObject11	Object
    //   1491	1	21	localIOException6	java.io.IOException
    //   1508	1	21	localObject12	Object
    //   1521	1	21	localIOException7	java.io.IOException
    //   1534	1	21	localObject13	Object
    //   1539	1	21	localIOException8	java.io.IOException
    //   1	800	22	localObject14	Object
    //   1456	1	22	localException	Exception
    //   1470	1	22	localIOException9	java.io.IOException
    //   1503	23	22	localObject15	Object
    //   1544	1	22	localObject16	Object
    //   1549	1	22	localIOException10	java.io.IOException
    //   447	26	23	localStatusLine	org.apache.http.StatusLine
    //   511	13	23	localIOException11	java.io.IOException
    //   533	61	23	localObject17	Object
    //   406	1044	24	localObject18	Object
    //   356	382	25	localObject19	Object
    //   759	11	25	localObject20	Object
    //   802	722	25	localObject21	Object
    //   410	1055	26	localObject22	Object
    //   620	601	27	localObject23	Object
    //   693	25	28	str	String
    //   878	609	31	localObject24	Object
    //   23	666	32	localURL	URL
    //   37	1	33	localObject25	Object
    // Exception table:
    //   from	to	target	type
    //   494	508	511	java/io/IOException
    //   716	728	731	finally
    //   716	728	744	java/io/IOException
    //   658	676	759	finally
    //   688	695	759	finally
    //   658	676	776	java/io/IOException
    //   688	695	776	java/io/IOException
    //   820	865	871	finally
    //   820	865	883	java/io/IOException
    //   921	930	1053	java/io/IOException
    //   938	947	1053	java/io/IOException
    //   955	963	1053	java/io/IOException
    //   971	980	1053	java/io/IOException
    //   988	996	1053	java/io/IOException
    //   1004	1013	1053	java/io/IOException
    //   1021	1031	1053	java/io/IOException
    //   1039	1050	1053	java/io/IOException
    //   1094	1100	1053	java/io/IOException
    //   1130	1139	1053	java/io/IOException
    //   1147	1156	1053	java/io/IOException
    //   1164	1173	1053	java/io/IOException
    //   1181	1190	1053	java/io/IOException
    //   1198	1208	1053	java/io/IOException
    //   1216	1228	1053	java/io/IOException
    //   1258	1264	1053	java/io/IOException
    //   1306	1315	1275	java/io/IOException
    //   1319	1325	1275	java/io/IOException
    //   1329	1338	1275	java/io/IOException
    //   1342	1351	1275	java/io/IOException
    //   1355	1367	1275	java/io/IOException
    //   1371	1380	1275	java/io/IOException
    //   1384	1392	1275	java/io/IOException
    //   1396	1405	1275	java/io/IOException
    //   1409	1419	1275	java/io/IOException
    //   1423	1434	1275	java/io/IOException
    //   1439	1444	1447	finally
    //   1439	1444	1456	java/lang/Exception
    //   1439	1444	1470	java/io/IOException
    //   903	908	1478	finally
    //   921	930	1478	finally
    //   938	947	1478	finally
    //   955	963	1478	finally
    //   971	980	1478	finally
    //   988	996	1478	finally
    //   1004	1013	1478	finally
    //   1021	1031	1478	finally
    //   1039	1050	1478	finally
    //   1070	1077	1478	finally
    //   1094	1100	1478	finally
    //   1112	1117	1478	finally
    //   1130	1139	1478	finally
    //   1147	1156	1478	finally
    //   1164	1173	1478	finally
    //   1181	1190	1478	finally
    //   1198	1208	1478	finally
    //   1216	1228	1478	finally
    //   1236	1242	1478	finally
    //   1258	1264	1478	finally
    //   1288	1294	1478	finally
    //   1306	1315	1478	finally
    //   1319	1325	1478	finally
    //   1329	1338	1478	finally
    //   1342	1351	1478	finally
    //   1355	1367	1478	finally
    //   1371	1380	1478	finally
    //   1384	1392	1478	finally
    //   1396	1405	1478	finally
    //   1409	1419	1478	finally
    //   1423	1434	1478	finally
    //   903	908	1491	java/io/IOException
    //   1070	1077	1491	java/io/IOException
    //   1112	1117	1491	java/io/IOException
    //   1236	1242	1491	java/io/IOException
    //   1288	1294	1491	java/io/IOException
    //   616	622	1508	finally
    //   616	622	1521	java/io/IOException
    //   593	602	1534	finally
    //   593	602	1539	java/io/IOException
    //   583	593	1544	finally
    //   583	593	1549	java/io/IOException
    //   1668	1673	1676	java/lang/Exception
    //   1749	1759	1676	java/lang/Exception
    //   1668	1673	1696	java/io/IOException
    //   1749	1759	1762	java/io/IOException
    //   1816	1830	1928	java/lang/Exception
    //   1879	1884	1928	java/lang/Exception
    //   1925	1928	1928	java/lang/Exception
    //   1816	1830	1952	java/io/IOException
    //   1879	1884	1952	java/io/IOException
    //   1925	1928	1952	java/io/IOException
    //   570	579	1997	java/lang/Exception
    //   570	579	2015	java/io/IOException
    //   2068	2082	2112	java/lang/Exception
    //   2068	2082	2124	java/io/IOException
    //   2145	2152	2155	java/io/IOException
    //   412	433	2275	finally
    //   441	449	2275	finally
    //   457	464	2275	finally
    //   472	481	2275	finally
    //   494	508	2275	finally
    //   546	554	2275	finally
    //   570	579	2275	finally
    //   1668	1673	2275	finally
    //   1749	1759	2275	finally
    //   1816	1830	2275	finally
    //   1879	1884	2275	finally
    //   1925	1928	2275	finally
    //   2068	2082	2275	finally
    //   2308	2313	2275	finally
    //   2326	2339	2275	finally
    //   2436	2441	2275	finally
    //   2449	2457	2275	finally
    //   2472	2480	2275	finally
    //   2488	2496	2275	finally
    //   2507	2515	2275	finally
    //   2523	2529	2275	finally
    //   2544	2553	2275	finally
    //   2561	2570	2275	finally
    //   2578	2586	2275	finally
    //   2594	2603	2275	finally
    //   2611	2621	2275	finally
    //   2629	2638	2275	finally
    //   2646	2657	2275	finally
    //   2665	2676	2275	finally
    //   2689	2703	2275	finally
    //   412	433	2283	java/lang/Exception
    //   441	449	2283	java/lang/Exception
    //   457	464	2283	java/lang/Exception
    //   472	481	2283	java/lang/Exception
    //   494	508	2283	java/lang/Exception
    //   546	554	2283	java/lang/Exception
    //   2344	2351	2354	java/io/IOException
    //   412	433	2404	java/io/IOException
    //   441	449	2404	java/io/IOException
    //   457	464	2404	java/io/IOException
    //   472	481	2404	java/io/IOException
    //   546	554	2404	java/io/IOException
    //   2708	2715	2718	java/io/IOException
    //   2854	2862	2865	finally
    //   2869	2872	2865	finally
    //   2875	2878	2865	finally
    //   2929	2936	2939	java/io/IOException
    //   12	25	3020	java/net/MalformedURLException
    //   39	47	3035	java/lang/Exception
    //   51	65	3035	java/lang/Exception
    //   70	83	3035	java/lang/Exception
    //   83	124	3035	java/lang/Exception
    //   132	142	3039	java/lang/IllegalArgumentException
    //   145	158	3043	java/lang/IllegalArgumentException
    //   2224	2229	3047	java/io/IOException
    //   2366	2371	3051	java/io/IOException
    //   2854	2862	3056	java/lang/InterruptedException
    //   2949	2954	3060	java/io/IOException
    //   1596	1612	3091	finally
    //   1619	1626	3091	finally
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
    //   3: lstore 10
    //   5: new 4	java/lang/Object
    //   8: dup
    //   9: invokespecial 231	java/lang/Object:<init>	()V
    //   12: astore 24
    //   14: aload_2
    //   15: ifnonnull +5 -> 20
    //   18: iconst_5
    //   19: ireturn
    //   20: iload 4
    //   22: ifge +9 -> 31
    //   25: iconst_2
    //   26: istore 6
    //   28: goto +7 -> 35
    //   31: iload 4
    //   33: istore 6
    //   35: aload_2
    //   36: invokevirtual 289	java/io/File:getParentFile	()Ljava/io/File;
    //   39: astore_0
    //   40: aload_0
    //   41: ifnull +15 -> 56
    //   44: aload_0
    //   45: invokevirtual 292	java/io/File:exists	()Z
    //   48: ifne +8 -> 56
    //   51: aload_0
    //   52: invokevirtual 295	java/io/File:mkdirs	()Z
    //   55: pop
    //   56: aload_1
    //   57: invokevirtual 298	java/net/URL:toString	()Ljava/lang/String;
    //   60: astore 17
    //   62: new 316	org/apache/http/client/methods/HttpGet
    //   65: dup
    //   66: aload 17
    //   68: invokespecial 317	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   71: astore_0
    //   72: goto +16 -> 88
    //   75: new 316	org/apache/http/client/methods/HttpGet
    //   78: dup
    //   79: aload 17
    //   81: invokestatic 320	com/tencent/mobileqq/utils/HttpDownloadUtil:getEscapeSequence	(Ljava/lang/String;)Ljava/lang/String;
    //   84: invokespecial 317	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   87: astore_0
    //   88: new 94	org/apache/http/params/BasicHttpParams
    //   91: dup
    //   92: invokespecial 97	org/apache/http/params/BasicHttpParams:<init>	()V
    //   95: astore 21
    //   97: sipush 20000
    //   100: istore 5
    //   102: aload_3
    //   103: ifnull +125 -> 228
    //   106: invokestatic 342	android/net/Proxy:getDefaultHost	()Ljava/lang/String;
    //   109: astore 17
    //   111: invokestatic 346	android/net/Proxy:getDefaultPort	()I
    //   114: istore 4
    //   116: aload_3
    //   117: invokevirtual 351	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   120: astore 18
    //   122: aload_3
    //   123: invokestatic 357	com/tencent/mobileqq/utils/NetworkUtil:isMobileNetworkInfo	(Landroid/net/NetworkInfo;)Z
    //   126: ifeq +51 -> 177
    //   129: aload 18
    //   131: ifnull +14 -> 145
    //   134: aload 18
    //   136: ldc_w 359
    //   139: invokevirtual 365	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   142: ifeq +35 -> 177
    //   145: aload 17
    //   147: ifnull +30 -> 177
    //   150: iload 4
    //   152: ifle +25 -> 177
    //   155: aload 21
    //   157: ldc_w 367
    //   160: new 369	org/apache/http/HttpHost
    //   163: dup
    //   164: aload 17
    //   166: iload 4
    //   168: invokespecial 371	org/apache/http/HttpHost:<init>	(Ljava/lang/String;I)V
    //   171: invokeinterface 335 3 0
    //   176: pop
    //   177: aload_3
    //   178: invokestatic 357	com/tencent/mobileqq/utils/NetworkUtil:isMobileNetworkInfo	(Landroid/net/NetworkInfo;)Z
    //   181: ifeq +20 -> 201
    //   184: aload 21
    //   186: ldc_w 373
    //   189: sipush 2048
    //   192: invokeinterface 377 3 0
    //   197: pop
    //   198: goto +30 -> 228
    //   201: sipush 10000
    //   204: istore 5
    //   206: sipush 30000
    //   209: istore 4
    //   211: aload 21
    //   213: ldc_w 373
    //   216: sipush 4096
    //   219: invokeinterface 377 3 0
    //   224: pop
    //   225: goto +8 -> 233
    //   228: ldc_w 323
    //   231: istore 4
    //   233: aload 21
    //   235: ldc_w 322
    //   238: iload 5
    //   240: invokestatic 329	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   243: invokeinterface 335 3 0
    //   248: pop
    //   249: aload 21
    //   251: ldc_w 337
    //   254: iload 4
    //   256: invokestatic 329	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   259: invokeinterface 335 3 0
    //   264: pop
    //   265: aload_0
    //   266: aload 21
    //   268: invokevirtual 381	org/apache/http/client/methods/HttpGet:setParams	(Lorg/apache/http/params/HttpParams;)V
    //   271: aload_2
    //   272: invokevirtual 292	java/io/File:exists	()Z
    //   275: ifeq +8 -> 283
    //   278: aload_2
    //   279: invokevirtual 388	java/io/File:delete	()Z
    //   282: pop
    //   283: aconst_null
    //   284: astore_3
    //   285: aload_3
    //   286: astore 17
    //   288: iconst_m1
    //   289: istore 7
    //   291: aload_0
    //   292: astore 22
    //   294: iload 7
    //   296: ifne +36 -> 332
    //   299: aload 21
    //   301: ldc_w 367
    //   304: new 369	org/apache/http/HttpHost
    //   307: dup
    //   308: aload_1
    //   309: invokevirtual 391	java/net/URL:getHost	()Ljava/lang/String;
    //   312: aload_1
    //   313: invokevirtual 394	java/net/URL:getPort	()I
    //   316: invokespecial 371	org/apache/http/HttpHost:<init>	(Ljava/lang/String;I)V
    //   319: invokeinterface 335 3 0
    //   324: pop
    //   325: aload 22
    //   327: aload 21
    //   329: invokevirtual 381	org/apache/http/client/methods/HttpGet:setParams	(Lorg/apache/http/params/HttpParams;)V
    //   332: getstatic 197	com/tencent/mobileqq/utils/HttpDownloadUtil:CLIENT	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   335: new 369	org/apache/http/HttpHost
    //   338: dup
    //   339: aload_1
    //   340: invokevirtual 391	java/net/URL:getHost	()Ljava/lang/String;
    //   343: invokespecial 395	org/apache/http/HttpHost:<init>	(Ljava/lang/String;)V
    //   346: aload 22
    //   348: invokevirtual 399	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/HttpHost;Lorg/apache/http/HttpRequest;)Lorg/apache/http/HttpResponse;
    //   351: astore_0
    //   352: aload_0
    //   353: invokeinterface 405 1 0
    //   358: invokeinterface 414 1 0
    //   363: istore 5
    //   365: aload_0
    //   366: invokeinterface 421 1 0
    //   371: astore_0
    //   372: aload_0
    //   373: astore 18
    //   375: sipush 200
    //   378: iload 5
    //   380: if_icmpne +686 -> 1066
    //   383: aload 18
    //   385: invokeinterface 426 1 0
    //   390: lstore 12
    //   392: new 550	java/io/BufferedOutputStream
    //   395: dup
    //   396: new 428	java/io/FileOutputStream
    //   399: dup
    //   400: aload_2
    //   401: invokespecial 431	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   404: invokespecial 553	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   407: astore 17
    //   409: aload 18
    //   411: aload 17
    //   413: invokeinterface 556 2 0
    //   418: aload 17
    //   420: invokevirtual 559	java/io/OutputStream:flush	()V
    //   423: aload_2
    //   424: invokevirtual 562	java/io/File:length	()J
    //   427: lstore 8
    //   429: aload_2
    //   430: invokestatic 90	java/lang/System:currentTimeMillis	()J
    //   433: invokevirtual 476	java/io/File:setLastModified	(J)Z
    //   436: pop
    //   437: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   440: ifeq +92 -> 532
    //   443: new 306	java/lang/StringBuilder
    //   446: dup
    //   447: invokespecial 307	java/lang/StringBuilder:<init>	()V
    //   450: astore_3
    //   451: aload_3
    //   452: ldc_w 478
    //   455: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   458: pop
    //   459: invokestatic 90	java/lang/System:currentTimeMillis	()J
    //   462: lstore 14
    //   464: aload_3
    //   465: lload 14
    //   467: lload 10
    //   469: lsub
    //   470: invokevirtual 462	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   473: pop
    //   474: aload_3
    //   475: ldc_w 564
    //   478: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   481: pop
    //   482: aload_3
    //   483: lload 8
    //   485: invokevirtual 462	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   488: pop
    //   489: aload_3
    //   490: ldc_w 482
    //   493: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   496: pop
    //   497: aload_3
    //   498: aload_1
    //   499: invokevirtual 567	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   502: pop
    //   503: ldc 68
    //   505: iconst_2
    //   506: aload_3
    //   507: invokevirtual 314	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   510: invokestatic 485	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   513: goto +19 -> 532
    //   516: astore_1
    //   517: goto +61 -> 578
    //   520: astore_3
    //   521: goto +73 -> 594
    //   524: astore_3
    //   525: goto +83 -> 608
    //   528: astore_3
    //   529: goto +21 -> 550
    //   532: aload 17
    //   534: astore_3
    //   535: iconst_0
    //   536: istore 4
    //   538: goto +294 -> 832
    //   541: astore_3
    //   542: goto +52 -> 594
    //   545: astore_3
    //   546: goto +62 -> 608
    //   549: astore_3
    //   550: aload_3
    //   551: astore 23
    //   553: aload 17
    //   555: astore_3
    //   556: goto +94 -> 650
    //   559: aload 17
    //   561: astore_3
    //   562: goto +134 -> 696
    //   565: astore_3
    //   566: goto +28 -> 594
    //   569: astore_3
    //   570: goto +38 -> 608
    //   573: astore_3
    //   574: goto +48 -> 622
    //   577: astore_1
    //   578: aload_0
    //   579: astore 18
    //   581: aload_1
    //   582: astore_0
    //   583: aload 17
    //   585: astore_3
    //   586: aload 18
    //   588: astore 17
    //   590: goto +589 -> 1179
    //   593: astore_3
    //   594: aload 17
    //   596: astore 18
    //   598: aload_3
    //   599: astore 17
    //   601: aload 18
    //   603: astore_3
    //   604: goto +590 -> 1194
    //   607: astore_3
    //   608: aload 17
    //   610: astore 18
    //   612: aload_3
    //   613: astore 17
    //   615: aload 18
    //   617: astore_3
    //   618: goto +848 -> 1466
    //   621: astore_3
    //   622: aload 17
    //   624: astore 18
    //   626: aload_3
    //   627: astore 17
    //   629: aload 18
    //   631: astore_3
    //   632: goto +11 -> 643
    //   635: aload 17
    //   637: astore_3
    //   638: goto +1897 -> 2535
    //   641: astore 17
    //   643: lconst_0
    //   644: lstore 8
    //   646: aload 17
    //   648: astore 23
    //   650: aload_3
    //   651: astore 17
    //   653: aload_3
    //   654: astore 18
    //   656: aload_3
    //   657: astore 19
    //   659: aload_3
    //   660: astore 20
    //   662: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   665: ifeq +1864 -> 2529
    //   668: aload_3
    //   669: astore 17
    //   671: aload_3
    //   672: astore 18
    //   674: aload_3
    //   675: astore 19
    //   677: aload_3
    //   678: astore 20
    //   680: ldc 68
    //   682: iconst_2
    //   683: aload 23
    //   685: invokevirtual 520	java/io/IOException:getMessage	()Ljava/lang/String;
    //   688: aload 23
    //   690: invokestatic 569	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   693: goto +1836 -> 2529
    //   696: aload_3
    //   697: astore 17
    //   699: aload_3
    //   700: astore 18
    //   702: aload_3
    //   703: astore 19
    //   705: aload_3
    //   706: astore 20
    //   708: new 306	java/lang/StringBuilder
    //   711: dup
    //   712: invokespecial 307	java/lang/StringBuilder:<init>	()V
    //   715: astore 23
    //   717: aload_3
    //   718: astore 17
    //   720: aload_3
    //   721: astore 18
    //   723: aload_3
    //   724: astore 19
    //   726: aload_3
    //   727: astore 20
    //   729: aload 23
    //   731: ldc_w 571
    //   734: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   737: pop
    //   738: aload_3
    //   739: astore 17
    //   741: aload_3
    //   742: astore 18
    //   744: aload_3
    //   745: astore 19
    //   747: aload_3
    //   748: astore 20
    //   750: aload 23
    //   752: aload_2
    //   753: invokevirtual 292	java/io/File:exists	()Z
    //   756: invokevirtual 574	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   759: pop
    //   760: aload_3
    //   761: astore 17
    //   763: aload_3
    //   764: astore 18
    //   766: aload_3
    //   767: astore 19
    //   769: aload_3
    //   770: astore 20
    //   772: aload 23
    //   774: ldc_w 576
    //   777: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   780: pop
    //   781: aload_3
    //   782: astore 17
    //   784: aload_3
    //   785: astore 18
    //   787: aload_3
    //   788: astore 19
    //   790: aload_3
    //   791: astore 20
    //   793: aload 23
    //   795: aload_2
    //   796: invokevirtual 289	java/io/File:getParentFile	()Ljava/io/File;
    //   799: invokevirtual 292	java/io/File:exists	()Z
    //   802: invokevirtual 574	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   805: pop
    //   806: aload_3
    //   807: astore 17
    //   809: aload_3
    //   810: astore 18
    //   812: aload_3
    //   813: astore 19
    //   815: aload_3
    //   816: astore 20
    //   818: ldc 68
    //   820: iconst_1
    //   821: aload 23
    //   823: invokevirtual 314	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   826: invokestatic 239	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   829: iconst_5
    //   830: istore 4
    //   832: aload_0
    //   833: astore 17
    //   835: iload 4
    //   837: istore 5
    //   839: aload_3
    //   840: astore 18
    //   842: lload 12
    //   844: lconst_0
    //   845: lcmp
    //   846: ifle +223 -> 1069
    //   849: iload 4
    //   851: istore 5
    //   853: aload_3
    //   854: astore 18
    //   856: lload 8
    //   858: lload 12
    //   860: lcmp
    //   861: ifge +208 -> 1069
    //   864: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   867: ifeq +75 -> 942
    //   870: new 306	java/lang/StringBuilder
    //   873: dup
    //   874: invokespecial 307	java/lang/StringBuilder:<init>	()V
    //   877: astore 18
    //   879: aload 18
    //   881: ldc_w 578
    //   884: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   887: pop
    //   888: aload 18
    //   890: lload 12
    //   892: invokevirtual 462	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   895: pop
    //   896: aload 18
    //   898: ldc_w 580
    //   901: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   904: pop
    //   905: aload 18
    //   907: aload_2
    //   908: invokevirtual 562	java/io/File:length	()J
    //   911: invokevirtual 462	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   914: pop
    //   915: aload 18
    //   917: ldc_w 527
    //   920: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   923: pop
    //   924: aload 18
    //   926: aload_1
    //   927: invokevirtual 567	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   930: pop
    //   931: ldc 68
    //   933: iconst_2
    //   934: aload 18
    //   936: invokevirtual 314	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   939: invokestatic 523	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   942: bipush 8
    //   944: istore 5
    //   946: aload_3
    //   947: astore 18
    //   949: goto +120 -> 1069
    //   952: astore_0
    //   953: aload 17
    //   955: astore 18
    //   957: goto +1345 -> 2302
    //   960: astore 19
    //   962: aload 17
    //   964: astore_0
    //   965: iload 4
    //   967: istore 5
    //   969: goto +232 -> 1201
    //   972: astore 19
    //   974: aload 17
    //   976: astore_0
    //   977: iload 4
    //   979: istore 5
    //   981: goto +492 -> 1473
    //   984: astore 19
    //   986: aload 17
    //   988: astore_0
    //   989: iload 4
    //   991: istore 5
    //   993: goto +775 -> 1768
    //   996: astore_3
    //   997: aload_0
    //   998: astore_1
    //   999: aload_3
    //   1000: astore_0
    //   1001: aload 17
    //   1003: astore_3
    //   1004: aload_1
    //   1005: astore 17
    //   1007: goto +172 -> 1179
    //   1010: astore 17
    //   1012: aload 18
    //   1014: astore_3
    //   1015: goto +179 -> 1194
    //   1018: astore 17
    //   1020: aload 19
    //   1022: astore_3
    //   1023: goto +443 -> 1466
    //   1026: astore 17
    //   1028: aload 20
    //   1030: astore_3
    //   1031: goto +730 -> 1761
    //   1034: astore_0
    //   1035: aload 18
    //   1037: astore 17
    //   1039: goto +140 -> 1179
    //   1042: astore 17
    //   1044: aload 18
    //   1046: astore_0
    //   1047: goto +147 -> 1194
    //   1050: astore 17
    //   1052: aload 18
    //   1054: astore_0
    //   1055: goto +411 -> 1466
    //   1058: astore 17
    //   1060: aload 18
    //   1062: astore_0
    //   1063: goto +698 -> 1761
    //   1066: aload_3
    //   1067: astore 18
    //   1069: aload_0
    //   1070: ifnull +17 -> 1087
    //   1073: aload_0
    //   1074: invokeinterface 501 1 0
    //   1079: goto +8 -> 1087
    //   1082: astore_3
    //   1083: aload_3
    //   1084: invokevirtual 504	java/io/IOException:printStackTrace	()V
    //   1087: aload 18
    //   1089: ifnull +11 -> 1100
    //   1092: aload 18
    //   1094: invokevirtual 505	java/io/OutputStream:close	()V
    //   1097: goto +3 -> 1100
    //   1100: iload 5
    //   1102: ifeq +70 -> 1172
    //   1105: aload_2
    //   1106: invokevirtual 289	java/io/File:getParentFile	()Ljava/io/File;
    //   1109: astore_3
    //   1110: aload_3
    //   1111: ifnull +15 -> 1126
    //   1114: aload_3
    //   1115: invokevirtual 292	java/io/File:exists	()Z
    //   1118: ifne +8 -> 1126
    //   1121: aload_3
    //   1122: invokevirtual 295	java/io/File:mkdirs	()Z
    //   1125: pop
    //   1126: aload_2
    //   1127: invokevirtual 292	java/io/File:exists	()Z
    //   1130: ifeq +42 -> 1172
    //   1133: aload_2
    //   1134: invokevirtual 388	java/io/File:delete	()Z
    //   1137: istore 16
    //   1139: new 306	java/lang/StringBuilder
    //   1142: dup
    //   1143: invokespecial 307	java/lang/StringBuilder:<init>	()V
    //   1146: astore_3
    //   1147: aload_3
    //   1148: ldc_w 582
    //   1151: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1154: pop
    //   1155: aload_3
    //   1156: iload 16
    //   1158: invokevirtual 574	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1161: pop
    //   1162: ldc 68
    //   1164: iconst_1
    //   1165: aload_3
    //   1166: invokevirtual 314	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1169: invokestatic 239	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1172: aload_0
    //   1173: astore 17
    //   1175: goto +933 -> 2108
    //   1178: astore_0
    //   1179: iconst_5
    //   1180: istore 4
    //   1182: goto +1124 -> 2306
    //   1185: astore 18
    //   1187: aload 17
    //   1189: astore_0
    //   1190: aload 18
    //   1192: astore 17
    //   1194: iconst_5
    //   1195: istore 5
    //   1197: aload 17
    //   1199: astore 19
    //   1201: iload 5
    //   1203: istore 4
    //   1205: aload_3
    //   1206: astore 17
    //   1208: aload_0
    //   1209: astore 18
    //   1211: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1214: ifeq +81 -> 1295
    //   1217: iload 5
    //   1219: istore 4
    //   1221: aload_3
    //   1222: astore 17
    //   1224: aload_0
    //   1225: astore 18
    //   1227: new 306	java/lang/StringBuilder
    //   1230: dup
    //   1231: invokespecial 307	java/lang/StringBuilder:<init>	()V
    //   1234: astore 20
    //   1236: iload 5
    //   1238: istore 4
    //   1240: aload_3
    //   1241: astore 17
    //   1243: aload_0
    //   1244: astore 18
    //   1246: aload 20
    //   1248: ldc_w 584
    //   1251: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1254: pop
    //   1255: iload 5
    //   1257: istore 4
    //   1259: aload_3
    //   1260: astore 17
    //   1262: aload_0
    //   1263: astore 18
    //   1265: aload 20
    //   1267: aload_1
    //   1268: invokevirtual 567	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1271: pop
    //   1272: iload 5
    //   1274: istore 4
    //   1276: aload_3
    //   1277: astore 17
    //   1279: aload_0
    //   1280: astore 18
    //   1282: ldc 68
    //   1284: iconst_2
    //   1285: aload 20
    //   1287: invokevirtual 314	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1290: aload 19
    //   1292: invokestatic 569	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1295: aload_0
    //   1296: ifnull +19 -> 1315
    //   1299: aload_0
    //   1300: invokeinterface 501 1 0
    //   1305: goto +10 -> 1315
    //   1308: astore 17
    //   1310: aload 17
    //   1312: invokevirtual 504	java/io/IOException:printStackTrace	()V
    //   1315: aload_3
    //   1316: ifnull +7 -> 1323
    //   1319: aload_3
    //   1320: invokevirtual 505	java/io/OutputStream:close	()V
    //   1323: aload_3
    //   1324: astore 19
    //   1326: aload_0
    //   1327: astore 20
    //   1329: aload_2
    //   1330: invokevirtual 289	java/io/File:getParentFile	()Ljava/io/File;
    //   1333: astore 17
    //   1335: aload 17
    //   1337: ifnull +29 -> 1366
    //   1340: aload_3
    //   1341: astore 19
    //   1343: aload_0
    //   1344: astore 20
    //   1346: aload 17
    //   1348: invokevirtual 292	java/io/File:exists	()Z
    //   1351: ifne +15 -> 1366
    //   1354: aload_3
    //   1355: astore 19
    //   1357: aload_0
    //   1358: astore 20
    //   1360: aload 17
    //   1362: invokevirtual 295	java/io/File:mkdirs	()Z
    //   1365: pop
    //   1366: aload_3
    //   1367: astore 18
    //   1369: aload_0
    //   1370: astore 17
    //   1372: aload_3
    //   1373: astore 19
    //   1375: aload_0
    //   1376: astore 20
    //   1378: aload_2
    //   1379: invokevirtual 292	java/io/File:exists	()Z
    //   1382: ifeq +364 -> 1746
    //   1385: aload_3
    //   1386: astore 19
    //   1388: aload_0
    //   1389: astore 20
    //   1391: aload_2
    //   1392: invokevirtual 388	java/io/File:delete	()Z
    //   1395: istore 16
    //   1397: aload_3
    //   1398: astore 19
    //   1400: aload_0
    //   1401: astore 20
    //   1403: new 306	java/lang/StringBuilder
    //   1406: dup
    //   1407: invokespecial 307	java/lang/StringBuilder:<init>	()V
    //   1410: astore 17
    //   1412: aload_3
    //   1413: astore 19
    //   1415: aload_0
    //   1416: astore 20
    //   1418: aload 17
    //   1420: ldc_w 582
    //   1423: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1426: pop
    //   1427: aload_3
    //   1428: astore 19
    //   1430: aload_0
    //   1431: astore 20
    //   1433: aload 17
    //   1435: iload 16
    //   1437: invokevirtual 574	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1440: pop
    //   1441: aload_3
    //   1442: astore 19
    //   1444: aload_0
    //   1445: astore 20
    //   1447: aload 17
    //   1449: invokevirtual 314	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1452: astore 17
    //   1454: goto +272 -> 1726
    //   1457: astore 18
    //   1459: aload 17
    //   1461: astore_0
    //   1462: aload 18
    //   1464: astore 17
    //   1466: iconst_5
    //   1467: istore 5
    //   1469: aload 17
    //   1471: astore 19
    //   1473: iload 5
    //   1475: istore 4
    //   1477: aload_3
    //   1478: astore 17
    //   1480: aload_0
    //   1481: astore 18
    //   1483: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1486: ifeq +81 -> 1567
    //   1489: iload 5
    //   1491: istore 4
    //   1493: aload_3
    //   1494: astore 17
    //   1496: aload_0
    //   1497: astore 18
    //   1499: new 306	java/lang/StringBuilder
    //   1502: dup
    //   1503: invokespecial 307	java/lang/StringBuilder:<init>	()V
    //   1506: astore 20
    //   1508: iload 5
    //   1510: istore 4
    //   1512: aload_3
    //   1513: astore 17
    //   1515: aload_0
    //   1516: astore 18
    //   1518: aload 20
    //   1520: ldc_w 584
    //   1523: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1526: pop
    //   1527: iload 5
    //   1529: istore 4
    //   1531: aload_3
    //   1532: astore 17
    //   1534: aload_0
    //   1535: astore 18
    //   1537: aload 20
    //   1539: aload_1
    //   1540: invokevirtual 567	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1543: pop
    //   1544: iload 5
    //   1546: istore 4
    //   1548: aload_3
    //   1549: astore 17
    //   1551: aload_0
    //   1552: astore 18
    //   1554: ldc 68
    //   1556: iconst_2
    //   1557: aload 20
    //   1559: invokevirtual 314	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1562: aload 19
    //   1564: invokestatic 569	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1567: aload_0
    //   1568: ifnull +19 -> 1587
    //   1571: aload_0
    //   1572: invokeinterface 501 1 0
    //   1577: goto +10 -> 1587
    //   1580: astore 17
    //   1582: aload 17
    //   1584: invokevirtual 504	java/io/IOException:printStackTrace	()V
    //   1587: aload_3
    //   1588: ifnull +7 -> 1595
    //   1591: aload_3
    //   1592: invokevirtual 505	java/io/OutputStream:close	()V
    //   1595: aload_3
    //   1596: astore 19
    //   1598: aload_0
    //   1599: astore 20
    //   1601: aload_2
    //   1602: invokevirtual 289	java/io/File:getParentFile	()Ljava/io/File;
    //   1605: astore 17
    //   1607: aload 17
    //   1609: ifnull +29 -> 1638
    //   1612: aload_3
    //   1613: astore 19
    //   1615: aload_0
    //   1616: astore 20
    //   1618: aload 17
    //   1620: invokevirtual 292	java/io/File:exists	()Z
    //   1623: ifne +15 -> 1638
    //   1626: aload_3
    //   1627: astore 19
    //   1629: aload_0
    //   1630: astore 20
    //   1632: aload 17
    //   1634: invokevirtual 295	java/io/File:mkdirs	()Z
    //   1637: pop
    //   1638: aload_3
    //   1639: astore 18
    //   1641: aload_0
    //   1642: astore 17
    //   1644: aload_3
    //   1645: astore 19
    //   1647: aload_0
    //   1648: astore 20
    //   1650: aload_2
    //   1651: invokevirtual 292	java/io/File:exists	()Z
    //   1654: ifeq +92 -> 1746
    //   1657: aload_3
    //   1658: astore 19
    //   1660: aload_0
    //   1661: astore 20
    //   1663: aload_2
    //   1664: invokevirtual 388	java/io/File:delete	()Z
    //   1667: istore 16
    //   1669: aload_3
    //   1670: astore 19
    //   1672: aload_0
    //   1673: astore 20
    //   1675: new 306	java/lang/StringBuilder
    //   1678: dup
    //   1679: invokespecial 307	java/lang/StringBuilder:<init>	()V
    //   1682: astore 17
    //   1684: aload_3
    //   1685: astore 19
    //   1687: aload_0
    //   1688: astore 20
    //   1690: aload 17
    //   1692: ldc_w 582
    //   1695: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1698: pop
    //   1699: aload_3
    //   1700: astore 19
    //   1702: aload_0
    //   1703: astore 20
    //   1705: aload 17
    //   1707: iload 16
    //   1709: invokevirtual 574	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1712: pop
    //   1713: aload_3
    //   1714: astore 19
    //   1716: aload_0
    //   1717: astore 20
    //   1719: aload 17
    //   1721: invokevirtual 314	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1724: astore 17
    //   1726: aload_3
    //   1727: astore 19
    //   1729: aload_0
    //   1730: astore 20
    //   1732: ldc 68
    //   1734: iconst_1
    //   1735: aload 17
    //   1737: invokestatic 239	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1740: aload_0
    //   1741: astore 17
    //   1743: aload_3
    //   1744: astore 18
    //   1746: iconst_5
    //   1747: istore 5
    //   1749: goto +359 -> 2108
    //   1752: astore 18
    //   1754: aload 17
    //   1756: astore_0
    //   1757: aload 18
    //   1759: astore 17
    //   1761: iconst_5
    //   1762: istore 5
    //   1764: aload 17
    //   1766: astore 19
    //   1768: iload 5
    //   1770: istore 4
    //   1772: aload_3
    //   1773: astore 17
    //   1775: aload_0
    //   1776: astore 18
    //   1778: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1781: ifeq +81 -> 1862
    //   1784: iload 5
    //   1786: istore 4
    //   1788: aload_3
    //   1789: astore 17
    //   1791: aload_0
    //   1792: astore 18
    //   1794: new 306	java/lang/StringBuilder
    //   1797: dup
    //   1798: invokespecial 307	java/lang/StringBuilder:<init>	()V
    //   1801: astore 20
    //   1803: iload 5
    //   1805: istore 4
    //   1807: aload_3
    //   1808: astore 17
    //   1810: aload_0
    //   1811: astore 18
    //   1813: aload 20
    //   1815: ldc_w 586
    //   1818: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1821: pop
    //   1822: iload 5
    //   1824: istore 4
    //   1826: aload_3
    //   1827: astore 17
    //   1829: aload_0
    //   1830: astore 18
    //   1832: aload 20
    //   1834: aload_1
    //   1835: invokevirtual 567	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1838: pop
    //   1839: iload 5
    //   1841: istore 4
    //   1843: aload_3
    //   1844: astore 17
    //   1846: aload_0
    //   1847: astore 18
    //   1849: ldc 68
    //   1851: iconst_2
    //   1852: aload 20
    //   1854: invokevirtual 314	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1857: aload 19
    //   1859: invokestatic 569	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1862: iload 5
    //   1864: istore 4
    //   1866: aload_3
    //   1867: astore 17
    //   1869: aload_0
    //   1870: astore 18
    //   1872: aload 19
    //   1874: instanceof 508
    //   1877: ifeq +10 -> 1887
    //   1880: bipush 10
    //   1882: istore 4
    //   1884: goto +80 -> 1964
    //   1887: iload 5
    //   1889: istore 4
    //   1891: aload_3
    //   1892: astore 17
    //   1894: aload_0
    //   1895: astore 18
    //   1897: aload 19
    //   1899: instanceof 490
    //   1902: ifne +59 -> 1961
    //   1905: iload 5
    //   1907: istore 4
    //   1909: aload_3
    //   1910: astore 17
    //   1912: aload_0
    //   1913: astore 18
    //   1915: aload 19
    //   1917: instanceof 492
    //   1920: ifeq +6 -> 1926
    //   1923: goto +38 -> 1961
    //   1926: iload 5
    //   1928: istore 4
    //   1930: aload_3
    //   1931: astore 17
    //   1933: aload_0
    //   1934: astore 18
    //   1936: aload 19
    //   1938: instanceof 494
    //   1941: istore 16
    //   1943: iload 16
    //   1945: ifeq +10 -> 1955
    //   1948: bipush 11
    //   1950: istore 4
    //   1952: goto +12 -> 1964
    //   1955: iconst_4
    //   1956: istore 4
    //   1958: goto +6 -> 1964
    //   1961: iconst_2
    //   1962: istore 4
    //   1964: aload_0
    //   1965: ifnull +19 -> 1984
    //   1968: aload_0
    //   1969: invokeinterface 501 1 0
    //   1974: goto +10 -> 1984
    //   1977: astore 17
    //   1979: aload 17
    //   1981: invokevirtual 504	java/io/IOException:printStackTrace	()V
    //   1984: aload_3
    //   1985: ifnull +10 -> 1995
    //   1988: aload_3
    //   1989: invokevirtual 505	java/io/OutputStream:close	()V
    //   1992: goto +3 -> 1995
    //   1995: iload 4
    //   1997: istore 5
    //   1999: aload_3
    //   2000: astore 18
    //   2002: aload_0
    //   2003: astore 17
    //   2005: iload 4
    //   2007: ifeq +101 -> 2108
    //   2010: aload_2
    //   2011: invokevirtual 289	java/io/File:getParentFile	()Ljava/io/File;
    //   2014: astore 17
    //   2016: aload 17
    //   2018: ifnull +17 -> 2035
    //   2021: aload 17
    //   2023: invokevirtual 292	java/io/File:exists	()Z
    //   2026: ifne +9 -> 2035
    //   2029: aload 17
    //   2031: invokevirtual 295	java/io/File:mkdirs	()Z
    //   2034: pop
    //   2035: iload 4
    //   2037: istore 5
    //   2039: aload_3
    //   2040: astore 18
    //   2042: aload_0
    //   2043: astore 17
    //   2045: aload_2
    //   2046: invokevirtual 292	java/io/File:exists	()Z
    //   2049: ifeq +59 -> 2108
    //   2052: aload_2
    //   2053: invokevirtual 388	java/io/File:delete	()Z
    //   2056: istore 16
    //   2058: new 306	java/lang/StringBuilder
    //   2061: dup
    //   2062: invokespecial 307	java/lang/StringBuilder:<init>	()V
    //   2065: astore 17
    //   2067: aload 17
    //   2069: ldc_w 582
    //   2072: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2075: pop
    //   2076: aload 17
    //   2078: iload 16
    //   2080: invokevirtual 574	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2083: pop
    //   2084: ldc 68
    //   2086: iconst_1
    //   2087: aload 17
    //   2089: invokevirtual 314	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2092: invokestatic 239	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2095: iload 4
    //   2097: istore 5
    //   2099: aload_3
    //   2100: astore 18
    //   2102: aload_0
    //   2103: astore 17
    //   2105: goto +3 -> 2108
    //   2108: iload 7
    //   2110: iconst_1
    //   2111: iadd
    //   2112: istore 7
    //   2114: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2117: ifeq +50 -> 2167
    //   2120: new 306	java/lang/StringBuilder
    //   2123: dup
    //   2124: invokespecial 307	java/lang/StringBuilder:<init>	()V
    //   2127: astore_0
    //   2128: aload_0
    //   2129: ldc_w 525
    //   2132: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2135: pop
    //   2136: aload_0
    //   2137: iload 5
    //   2139: invokevirtual 457	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2142: pop
    //   2143: aload_0
    //   2144: ldc_w 527
    //   2147: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2150: pop
    //   2151: aload_0
    //   2152: aload_1
    //   2153: invokevirtual 567	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2156: pop
    //   2157: ldc 68
    //   2159: iconst_2
    //   2160: aload_0
    //   2161: invokevirtual 314	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2164: invokestatic 239	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2167: iload 5
    //   2169: ifeq +65 -> 2234
    //   2172: new 306	java/lang/StringBuilder
    //   2175: dup
    //   2176: invokespecial 307	java/lang/StringBuilder:<init>	()V
    //   2179: astore_0
    //   2180: aload_0
    //   2181: ldc_w 525
    //   2184: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2187: pop
    //   2188: aload_0
    //   2189: iload 5
    //   2191: invokevirtual 457	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2194: pop
    //   2195: aload_0
    //   2196: ldc_w 527
    //   2199: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2202: pop
    //   2203: aload_0
    //   2204: aload_1
    //   2205: invokevirtual 567	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2208: pop
    //   2209: aload_0
    //   2210: ldc_w 588
    //   2213: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2216: pop
    //   2217: aload_0
    //   2218: iload 7
    //   2220: invokevirtual 457	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2223: pop
    //   2224: ldc 68
    //   2226: iconst_1
    //   2227: aload_0
    //   2228: invokevirtual 314	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2231: invokestatic 239	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2234: iload 5
    //   2236: ifeq +38 -> 2274
    //   2239: iload 7
    //   2241: iconst_2
    //   2242: if_icmpge +32 -> 2274
    //   2245: aload 24
    //   2247: monitorenter
    //   2248: aload 24
    //   2250: ldc2_w 589
    //   2253: invokevirtual 533	java/lang/Object:wait	(J)V
    //   2256: goto +7 -> 2263
    //   2259: astore_0
    //   2260: goto +9 -> 2269
    //   2263: aload 24
    //   2265: monitorexit
    //   2266: goto +8 -> 2274
    //   2269: aload 24
    //   2271: monitorexit
    //   2272: aload_0
    //   2273: athrow
    //   2274: iload 5
    //   2276: ifeq +19 -> 2295
    //   2279: iload 7
    //   2281: iload 6
    //   2283: if_icmplt +6 -> 2289
    //   2286: iload 5
    //   2288: ireturn
    //   2289: aload 18
    //   2291: astore_3
    //   2292: goto -1998 -> 294
    //   2295: iload 5
    //   2297: ireturn
    //   2298: astore_0
    //   2299: aload 17
    //   2301: astore_3
    //   2302: aload 18
    //   2304: astore 17
    //   2306: aload 17
    //   2308: ifnull +18 -> 2326
    //   2311: aload 17
    //   2313: invokeinterface 501 1 0
    //   2318: goto +8 -> 2326
    //   2321: astore_1
    //   2322: aload_1
    //   2323: invokevirtual 504	java/io/IOException:printStackTrace	()V
    //   2326: aload_3
    //   2327: ifnull +10 -> 2337
    //   2330: aload_3
    //   2331: invokevirtual 505	java/io/OutputStream:close	()V
    //   2334: goto +3 -> 2337
    //   2337: iload 4
    //   2339: ifeq +70 -> 2409
    //   2342: aload_2
    //   2343: invokevirtual 289	java/io/File:getParentFile	()Ljava/io/File;
    //   2346: astore_1
    //   2347: aload_1
    //   2348: ifnull +15 -> 2363
    //   2351: aload_1
    //   2352: invokevirtual 292	java/io/File:exists	()Z
    //   2355: ifne +8 -> 2363
    //   2358: aload_1
    //   2359: invokevirtual 295	java/io/File:mkdirs	()Z
    //   2362: pop
    //   2363: aload_2
    //   2364: invokevirtual 292	java/io/File:exists	()Z
    //   2367: ifeq +42 -> 2409
    //   2370: aload_2
    //   2371: invokevirtual 388	java/io/File:delete	()Z
    //   2374: istore 16
    //   2376: new 306	java/lang/StringBuilder
    //   2379: dup
    //   2380: invokespecial 307	java/lang/StringBuilder:<init>	()V
    //   2383: astore_1
    //   2384: aload_1
    //   2385: ldc_w 582
    //   2388: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2391: pop
    //   2392: aload_1
    //   2393: iload 16
    //   2395: invokevirtual 574	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2398: pop
    //   2399: ldc 68
    //   2401: iconst_1
    //   2402: aload_1
    //   2403: invokevirtual 314	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2406: invokestatic 239	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2409: aload_0
    //   2410: athrow
    //   2411: ldc 68
    //   2413: iconst_1
    //   2414: ldc_w 592
    //   2417: invokestatic 239	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2420: bipush 13
    //   2422: ireturn
    //   2423: ldc 68
    //   2425: iconst_1
    //   2426: ldc_w 594
    //   2429: invokestatic 239	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2432: iconst_4
    //   2433: ireturn
    //   2434: astore_0
    //   2435: goto -12 -> 2423
    //   2438: astore_0
    //   2439: goto -2364 -> 75
    //   2442: astore_0
    //   2443: goto -32 -> 2411
    //   2446: astore 17
    //   2448: goto +87 -> 2535
    //   2451: astore_3
    //   2452: goto -1817 -> 635
    //   2455: astore_3
    //   2456: goto -1821 -> 635
    //   2459: astore_3
    //   2460: goto -1901 -> 559
    //   2463: astore_3
    //   2464: goto -1905 -> 559
    //   2467: astore_3
    //   2468: goto -1368 -> 1100
    //   2471: astore_3
    //   2472: goto -1300 -> 1172
    //   2475: astore 17
    //   2477: goto -1154 -> 1323
    //   2480: astore_0
    //   2481: aload 19
    //   2483: astore 18
    //   2485: aload 20
    //   2487: astore 17
    //   2489: goto -743 -> 1746
    //   2492: astore 17
    //   2494: goto -899 -> 1595
    //   2497: astore 17
    //   2499: goto -504 -> 1995
    //   2502: astore 17
    //   2504: iload 4
    //   2506: istore 5
    //   2508: aload_3
    //   2509: astore 18
    //   2511: aload_0
    //   2512: astore 17
    //   2514: goto -406 -> 2108
    //   2517: astore_0
    //   2518: goto -255 -> 2263
    //   2521: astore_1
    //   2522: goto -185 -> 2337
    //   2525: astore_1
    //   2526: goto -117 -> 2409
    //   2529: iconst_4
    //   2530: istore 4
    //   2532: goto -1700 -> 832
    //   2535: lconst_0
    //   2536: lstore 8
    //   2538: goto -1842 -> 696
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2541	0	paramAppRuntime	AppRuntime
    //   0	2541	1	paramURL	URL
    //   0	2541	2	paramFile	File
    //   0	2541	3	paramNetworkInfo	NetworkInfo
    //   0	2541	4	paramInt	int
    //   100	2407	5	i	int
    //   26	2258	6	j	int
    //   289	1995	7	k	int
    //   427	2110	8	l1	long
    //   3	465	10	l2	long
    //   390	501	12	l3	long
    //   462	4	14	l4	long
    //   1137	1257	16	bool	boolean
    //   60	576	17	localObject1	Object
    //   641	6	17	localIOException1	java.io.IOException
    //   651	355	17	localObject2	Object
    //   1010	1	17	localThrowable1	java.lang.Throwable
    //   1018	1	17	localException1	Exception
    //   1026	1	17	localIOException2	java.io.IOException
    //   1037	1	17	localObject3	Object
    //   1042	1	17	localThrowable2	java.lang.Throwable
    //   1050	1	17	localException2	Exception
    //   1058	1	17	localIOException3	java.io.IOException
    //   1173	105	17	localObject4	Object
    //   1308	3	17	localIOException4	java.io.IOException
    //   1333	217	17	localObject5	Object
    //   1580	3	17	localIOException5	java.io.IOException
    //   1605	327	17	localObject6	Object
    //   1977	3	17	localIOException6	java.io.IOException
    //   2003	309	17	localObject7	Object
    //   2446	1	17	localFileNotFoundException	java.io.FileNotFoundException
    //   2475	1	17	localIOException7	java.io.IOException
    //   2487	1	17	localObject8	Object
    //   2492	1	17	localIOException8	java.io.IOException
    //   2497	1	17	localIOException9	java.io.IOException
    //   2502	1	17	localException3	Exception
    //   2512	1	17	localAppRuntime1	AppRuntime
    //   120	973	18	localObject9	Object
    //   1185	6	18	localThrowable3	java.lang.Throwable
    //   1209	159	18	localObject10	Object
    //   1457	6	18	localException4	Exception
    //   1481	264	18	localObject11	Object
    //   1752	6	18	localIOException10	java.io.IOException
    //   1776	734	18	localObject12	Object
    //   657	157	19	localNetworkInfo	NetworkInfo
    //   960	1	19	localThrowable4	java.lang.Throwable
    //   972	1	19	localException5	Exception
    //   984	37	19	localIOException11	java.io.IOException
    //   1199	1283	19	localObject13	Object
    //   660	1826	20	localObject14	Object
    //   95	233	21	localBasicHttpParams	BasicHttpParams
    //   292	55	22	localAppRuntime2	AppRuntime
    //   551	271	23	localObject15	Object
    //   12	2258	24	localObject16	Object
    // Exception table:
    //   from	to	target	type
    //   464	513	516	finally
    //   464	513	520	java/lang/Throwable
    //   464	513	524	java/lang/Exception
    //   464	513	528	java/io/IOException
    //   429	464	541	java/lang/Throwable
    //   429	464	545	java/lang/Exception
    //   429	464	549	java/io/IOException
    //   423	429	565	java/lang/Throwable
    //   423	429	569	java/lang/Exception
    //   423	429	573	java/io/IOException
    //   409	423	577	finally
    //   423	429	577	finally
    //   429	464	577	finally
    //   409	423	593	java/lang/Throwable
    //   409	423	607	java/lang/Exception
    //   409	423	621	java/io/IOException
    //   392	409	641	java/io/IOException
    //   864	942	952	finally
    //   864	942	960	java/lang/Throwable
    //   864	942	972	java/lang/Exception
    //   864	942	984	java/io/IOException
    //   662	668	996	finally
    //   680	693	996	finally
    //   708	717	996	finally
    //   729	738	996	finally
    //   750	760	996	finally
    //   772	781	996	finally
    //   793	806	996	finally
    //   818	829	996	finally
    //   662	668	1010	java/lang/Throwable
    //   680	693	1010	java/lang/Throwable
    //   708	717	1010	java/lang/Throwable
    //   729	738	1010	java/lang/Throwable
    //   750	760	1010	java/lang/Throwable
    //   772	781	1010	java/lang/Throwable
    //   793	806	1010	java/lang/Throwable
    //   818	829	1010	java/lang/Throwable
    //   662	668	1018	java/lang/Exception
    //   680	693	1018	java/lang/Exception
    //   708	717	1018	java/lang/Exception
    //   729	738	1018	java/lang/Exception
    //   750	760	1018	java/lang/Exception
    //   772	781	1018	java/lang/Exception
    //   793	806	1018	java/lang/Exception
    //   818	829	1018	java/lang/Exception
    //   662	668	1026	java/io/IOException
    //   680	693	1026	java/io/IOException
    //   708	717	1026	java/io/IOException
    //   729	738	1026	java/io/IOException
    //   750	760	1026	java/io/IOException
    //   772	781	1026	java/io/IOException
    //   793	806	1026	java/io/IOException
    //   818	829	1026	java/io/IOException
    //   383	392	1034	finally
    //   392	409	1034	finally
    //   383	392	1042	java/lang/Throwable
    //   392	409	1042	java/lang/Throwable
    //   383	392	1050	java/lang/Exception
    //   392	409	1050	java/lang/Exception
    //   383	392	1058	java/io/IOException
    //   1073	1079	1082	java/io/IOException
    //   332	372	1178	finally
    //   332	372	1185	java/lang/Throwable
    //   1299	1305	1308	java/io/IOException
    //   332	372	1457	java/lang/Exception
    //   1571	1577	1580	java/io/IOException
    //   332	372	1752	java/io/IOException
    //   1968	1974	1977	java/io/IOException
    //   2248	2256	2259	finally
    //   2263	2266	2259	finally
    //   2269	2272	2259	finally
    //   1211	1217	2298	finally
    //   1227	1236	2298	finally
    //   1246	1255	2298	finally
    //   1265	1272	2298	finally
    //   1282	1295	2298	finally
    //   1483	1489	2298	finally
    //   1499	1508	2298	finally
    //   1518	1527	2298	finally
    //   1537	1544	2298	finally
    //   1554	1567	2298	finally
    //   1778	1784	2298	finally
    //   1794	1803	2298	finally
    //   1813	1822	2298	finally
    //   1832	1839	2298	finally
    //   1849	1862	2298	finally
    //   1872	1880	2298	finally
    //   1897	1905	2298	finally
    //   1915	1923	2298	finally
    //   1936	1943	2298	finally
    //   2311	2318	2321	java/io/IOException
    //   35	40	2434	java/lang/Exception
    //   44	56	2434	java/lang/Exception
    //   62	72	2438	java/lang/IllegalArgumentException
    //   75	88	2442	java/lang/IllegalArgumentException
    //   392	409	2446	java/io/FileNotFoundException
    //   409	423	2451	java/io/FileNotFoundException
    //   423	429	2455	java/io/FileNotFoundException
    //   429	464	2459	java/io/FileNotFoundException
    //   464	513	2463	java/io/FileNotFoundException
    //   1092	1097	2467	java/io/IOException
    //   1105	1110	2471	java/lang/Exception
    //   1114	1126	2471	java/lang/Exception
    //   1126	1172	2471	java/lang/Exception
    //   1319	1323	2475	java/io/IOException
    //   1329	1335	2480	java/lang/Exception
    //   1346	1354	2480	java/lang/Exception
    //   1360	1366	2480	java/lang/Exception
    //   1378	1385	2480	java/lang/Exception
    //   1391	1397	2480	java/lang/Exception
    //   1403	1412	2480	java/lang/Exception
    //   1418	1427	2480	java/lang/Exception
    //   1433	1441	2480	java/lang/Exception
    //   1447	1454	2480	java/lang/Exception
    //   1601	1607	2480	java/lang/Exception
    //   1618	1626	2480	java/lang/Exception
    //   1632	1638	2480	java/lang/Exception
    //   1650	1657	2480	java/lang/Exception
    //   1663	1669	2480	java/lang/Exception
    //   1675	1684	2480	java/lang/Exception
    //   1690	1699	2480	java/lang/Exception
    //   1705	1713	2480	java/lang/Exception
    //   1719	1726	2480	java/lang/Exception
    //   1732	1740	2480	java/lang/Exception
    //   1591	1595	2492	java/io/IOException
    //   1988	1992	2497	java/io/IOException
    //   2010	2016	2502	java/lang/Exception
    //   2021	2035	2502	java/lang/Exception
    //   2045	2095	2502	java/lang/Exception
    //   2248	2256	2517	java/lang/InterruptedException
    //   2330	2334	2521	java/io/IOException
    //   2342	2347	2525	java/lang/Exception
    //   2351	2363	2525	java/lang/Exception
    //   2363	2409	2525	java/lang/Exception
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
      return paramInt1 <= paramInt2;
    }
    return (paramDownloadInfo.resultCode != 0) && (paramInt1 <= paramInt2) && (paramDownloadInfo.resultCode != 16) && (paramDownloadInfo.resultCode != 6) && (NetworkUtil.isNetSupport(BaseApplication.getContext()));
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
    //   0: aload_1
    //   1: astore 21
    //   3: new 241	com/tencent/mobileqq/emoticon/DownloadInfo
    //   6: dup
    //   7: aload_0
    //   8: aconst_null
    //   9: iconst_0
    //   10: invokespecial 673	com/tencent/mobileqq/emoticon/DownloadInfo:<init>	(Ljava/lang/String;Ljava/io/File;I)V
    //   13: astore 24
    //   15: iload 5
    //   17: iconst_3
    //   18: if_icmplt +28 -> 46
    //   21: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   24: ifeq +12 -> 36
    //   27: ldc 68
    //   29: iconst_2
    //   30: ldc_w 675
    //   33: invokestatic 523	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   36: aload 24
    //   38: bipush 20
    //   40: putfield 511	com/tencent/mobileqq/emoticon/DownloadInfo:resultCode	I
    //   43: aload 24
    //   45: areturn
    //   46: new 279	java/net/URL
    //   49: dup
    //   50: aload 24
    //   52: getfield 282	com/tencent/mobileqq/emoticon/DownloadInfo:reqUrl	Ljava/lang/String;
    //   55: invokespecial 283	java/net/URL:<init>	(Ljava/lang/String;)V
    //   58: pop
    //   59: aload 24
    //   61: getfield 282	com/tencent/mobileqq/emoticon/DownloadInfo:reqUrl	Ljava/lang/String;
    //   64: astore 18
    //   66: new 316	org/apache/http/client/methods/HttpGet
    //   69: dup
    //   70: aload 18
    //   72: invokespecial 317	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   75: pop
    //   76: aload 18
    //   78: astore 22
    //   80: goto +26 -> 106
    //   83: new 316	org/apache/http/client/methods/HttpGet
    //   86: dup
    //   87: aload 18
    //   89: invokestatic 320	com/tencent/mobileqq/utils/HttpDownloadUtil:getEscapeSequence	(Ljava/lang/String;)Ljava/lang/String;
    //   92: invokespecial 317	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   95: pop
    //   96: aload 18
    //   98: invokestatic 320	com/tencent/mobileqq/utils/HttpDownloadUtil:getEscapeSequence	(Ljava/lang/String;)Ljava/lang/String;
    //   101: astore 18
    //   103: goto -27 -> 76
    //   106: new 4	java/lang/Object
    //   109: dup
    //   110: invokespecial 231	java/lang/Object:<init>	()V
    //   113: astore 20
    //   115: ldc2_w 528
    //   118: lstore 12
    //   120: aconst_null
    //   121: astore 18
    //   123: iconst_0
    //   124: istore 8
    //   126: aload_2
    //   127: astore 23
    //   129: invokestatic 606	com/tencent/mobileqq/msf/sdk/AppNetConnInfo:getRecentNetworkInfo	()Landroid/net/NetworkInfo;
    //   132: astore 25
    //   134: aload 25
    //   136: ifnonnull +98 -> 234
    //   139: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   142: ifeq +12 -> 154
    //   145: ldc 68
    //   147: iconst_2
    //   148: ldc_w 677
    //   151: invokestatic 523	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   154: aload 24
    //   156: iconst_1
    //   157: putfield 511	com/tencent/mobileqq/emoticon/DownloadInfo:resultCode	I
    //   160: iload 8
    //   162: iconst_1
    //   163: iadd
    //   164: istore 8
    //   166: iload 8
    //   168: iload_3
    //   169: if_icmplt +21 -> 190
    //   172: aload 21
    //   174: ifnull +13 -> 187
    //   177: aload 21
    //   179: aload 24
    //   181: invokeinterface 682 2 0
    //   186: pop
    //   187: aload 24
    //   189: areturn
    //   190: aload 20
    //   192: monitorenter
    //   193: aload 20
    //   195: lload 12
    //   197: invokevirtual 533	java/lang/Object:wait	(J)V
    //   200: lload 12
    //   202: ldc2_w 683
    //   205: lmul
    //   206: lstore 12
    //   208: goto +7 -> 215
    //   211: astore_0
    //   212: goto +17 -> 229
    //   215: aload 20
    //   217: monitorexit
    //   218: aload 21
    //   220: astore 19
    //   222: lload 12
    //   224: lstore 14
    //   226: goto +1837 -> 2063
    //   229: aload 20
    //   231: monitorexit
    //   232: aload_0
    //   233: athrow
    //   234: aload 25
    //   236: ifnull +38 -> 274
    //   239: aload 25
    //   241: invokevirtual 351	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   244: astore 19
    //   246: aload 25
    //   248: invokevirtual 687	android/net/NetworkInfo:getType	()I
    //   251: istore 9
    //   253: goto +27 -> 280
    //   256: astore 19
    //   258: aload 19
    //   260: astore 21
    //   262: goto +1205 -> 1467
    //   265: astore 19
    //   267: aload 19
    //   269: astore 21
    //   271: goto +1422 -> 1693
    //   274: iconst_m1
    //   275: istore 9
    //   277: aconst_null
    //   278: astore 19
    //   280: invokestatic 342	android/net/Proxy:getDefaultHost	()Ljava/lang/String;
    //   283: astore 25
    //   285: invokestatic 346	android/net/Proxy:getDefaultPort	()I
    //   288: istore 10
    //   290: aload 19
    //   292: invokestatic 692	com/tencent/mobileqq/utils/httputils/PkgTools:getApnType	(Ljava/lang/String;)Ljava/lang/String;
    //   295: astore 19
    //   297: aload 19
    //   299: getstatic 221	com/tencent/mobileqq/utils/HttpDownloadUtil:lastApn	Ljava/lang/String;
    //   302: invokevirtual 696	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   305: istore 11
    //   307: iload 11
    //   309: ifne +39 -> 348
    //   312: aload 19
    //   314: putstatic 221	com/tencent/mobileqq/utils/HttpDownloadUtil:lastApn	Ljava/lang/String;
    //   317: iload 9
    //   319: iconst_1
    //   320: if_icmpeq +24 -> 344
    //   323: aload 19
    //   325: getstatic 699	com/tencent/mobileqq/utils/httputils/PkgTools:APN_TYPE_CMWAP	Ljava/lang/String;
    //   328: invokevirtual 696	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   331: ifeq +6 -> 337
    //   334: goto +10 -> 344
    //   337: iconst_1
    //   338: putstatic 223	com/tencent/mobileqq/utils/HttpDownloadUtil:forceDirect	Z
    //   341: goto +7 -> 348
    //   344: iconst_0
    //   345: putstatic 223	com/tencent/mobileqq/utils/HttpDownloadUtil:forceDirect	Z
    //   348: iload 9
    //   350: iconst_1
    //   351: if_icmpne +29 -> 380
    //   354: ldc_w 701
    //   357: aload 25
    //   359: invokevirtual 696	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   362: ifne +14 -> 376
    //   365: ldc_w 703
    //   368: aload 25
    //   370: invokevirtual 696	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   373: ifeq +7 -> 380
    //   376: iconst_1
    //   377: putstatic 223	com/tencent/mobileqq/utils/HttpDownloadUtil:forceDirect	Z
    //   380: getstatic 223	com/tencent/mobileqq/utils/HttpDownloadUtil:forceDirect	Z
    //   383: istore 11
    //   385: iload 11
    //   387: ifne +114 -> 501
    //   390: aload 25
    //   392: ifnull +109 -> 501
    //   395: iload 10
    //   397: ifle +104 -> 501
    //   400: aload 19
    //   402: getstatic 699	com/tencent/mobileqq/utils/httputils/PkgTools:APN_TYPE_CMWAP	Ljava/lang/String;
    //   405: invokevirtual 696	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   408: ifne +75 -> 483
    //   411: aload 19
    //   413: getstatic 706	com/tencent/mobileqq/utils/httputils/PkgTools:APN_TYPE_UNIWAP	Ljava/lang/String;
    //   416: invokevirtual 696	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   419: ifne +64 -> 483
    //   422: aload 19
    //   424: getstatic 709	com/tencent/mobileqq/utils/httputils/PkgTools:APN_TYPE_3GWAP	Ljava/lang/String;
    //   427: invokevirtual 696	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   430: ifeq +6 -> 436
    //   433: goto +50 -> 483
    //   436: aload 19
    //   438: getstatic 712	com/tencent/mobileqq/utils/httputils/PkgTools:APN_TYPE_CTWAP	Ljava/lang/String;
    //   441: invokevirtual 696	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   444: ifeq +21 -> 465
    //   447: aload 22
    //   449: aload 25
    //   451: iload 10
    //   453: invokestatic 716	com/tencent/mobileqq/utils/httputils/PkgTools:getConnectionWithDefaultProxy	(Ljava/lang/String;Ljava/lang/String;I)Ljava/net/HttpURLConnection;
    //   456: astore 19
    //   458: aload 19
    //   460: astore 18
    //   462: goto +63 -> 525
    //   465: aload 22
    //   467: aload 25
    //   469: iload 10
    //   471: invokestatic 716	com/tencent/mobileqq/utils/httputils/PkgTools:getConnectionWithDefaultProxy	(Ljava/lang/String;Ljava/lang/String;I)Ljava/net/HttpURLConnection;
    //   474: astore 19
    //   476: aload 19
    //   478: astore 18
    //   480: goto +45 -> 525
    //   483: aload 22
    //   485: aload 25
    //   487: iload 10
    //   489: invokestatic 719	com/tencent/mobileqq/utils/httputils/PkgTools:getConnectionWithXOnlineHost	(Ljava/lang/String;Ljava/lang/String;I)Ljava/net/HttpURLConnection;
    //   492: astore 19
    //   494: aload 19
    //   496: astore 18
    //   498: goto +27 -> 525
    //   501: new 279	java/net/URL
    //   504: dup
    //   505: aload 22
    //   507: invokespecial 283	java/net/URL:<init>	(Ljava/lang/String;)V
    //   510: getstatic 725	java/net/Proxy:NO_PROXY	Ljava/net/Proxy;
    //   513: invokevirtual 729	java/net/URL:openConnection	(Ljava/net/Proxy;)Ljava/net/URLConnection;
    //   516: checkcast 253	java/net/HttpURLConnection
    //   519: astore 19
    //   521: aload 19
    //   523: astore 18
    //   525: aload 18
    //   527: astore 19
    //   529: aload 24
    //   531: aload 18
    //   533: putfield 733	com/tencent/mobileqq/emoticon/DownloadInfo:conn	Ljava/net/HttpURLConnection;
    //   536: aload 23
    //   538: ifnull +84 -> 622
    //   541: aload 18
    //   543: astore 19
    //   545: aload_2
    //   546: invokeinterface 738 1 0
    //   551: ifne +71 -> 622
    //   554: aload 18
    //   556: astore 19
    //   558: aload_2
    //   559: invokeinterface 742 1 0
    //   564: astore 25
    //   566: aload 18
    //   568: astore 19
    //   570: aload 25
    //   572: invokeinterface 747 1 0
    //   577: ifeq +45 -> 622
    //   580: aload 18
    //   582: astore 19
    //   584: aload 25
    //   586: invokeinterface 751 1 0
    //   591: checkcast 753	org/apache/http/Header
    //   594: astore 26
    //   596: aload 18
    //   598: astore 19
    //   600: aload 18
    //   602: aload 26
    //   604: invokeinterface 756 1 0
    //   609: aload 26
    //   611: invokeinterface 759 1 0
    //   616: invokevirtual 763	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   619: goto -53 -> 566
    //   622: aload 18
    //   624: astore 19
    //   626: aload 18
    //   628: ldc_w 765
    //   631: ldc_w 767
    //   634: invokevirtual 770	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   637: aload 18
    //   639: astore 19
    //   641: aload 18
    //   643: iload 6
    //   645: invokevirtual 774	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   648: aload 18
    //   650: astore 19
    //   652: aload 18
    //   654: iload 7
    //   656: invokevirtual 777	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   659: aload 18
    //   661: astore 19
    //   663: aload 18
    //   665: iconst_0
    //   666: invokevirtual 781	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   669: aload 18
    //   671: astore 19
    //   673: aload 18
    //   675: invokevirtual 784	java/net/HttpURLConnection:connect	()V
    //   678: aload 18
    //   680: astore 19
    //   682: aload 24
    //   684: aload 18
    //   686: invokevirtual 787	java/net/HttpURLConnection:getResponseCode	()I
    //   689: putfield 790	com/tencent/mobileqq/emoticon/DownloadInfo:httpRespCode	I
    //   692: aload 18
    //   694: astore 19
    //   696: aload 24
    //   698: aload 18
    //   700: invokevirtual 792	java/net/HttpURLConnection:getContentLength	()I
    //   703: putfield 795	com/tencent/mobileqq/emoticon/DownloadInfo:respContentLength	I
    //   706: aload 18
    //   708: astore 19
    //   710: aload 24
    //   712: aload 18
    //   714: invokevirtual 798	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
    //   717: putfield 801	com/tencent/mobileqq/emoticon/DownloadInfo:respContentType	Ljava/lang/String;
    //   720: aload 18
    //   722: astore 19
    //   724: aload 24
    //   726: aload 18
    //   728: invokevirtual 804	java/net/HttpURLConnection:getContentEncoding	()Ljava/lang/String;
    //   731: putfield 807	com/tencent/mobileqq/emoticon/DownloadInfo:respContentEncoding	Ljava/lang/String;
    //   734: aload 18
    //   736: astore 19
    //   738: aload 18
    //   740: aload 24
    //   742: invokestatic 809	com/tencent/mobileqq/utils/HttpDownloadUtil:copyRespHeader	(Ljava/net/HttpURLConnection;Lcom/tencent/mobileqq/emoticon/DownloadInfo;)V
    //   745: aload 18
    //   747: astore 19
    //   749: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   752: ifeq +139 -> 891
    //   755: aload 18
    //   757: astore 19
    //   759: new 306	java/lang/StringBuilder
    //   762: dup
    //   763: invokespecial 307	java/lang/StringBuilder:<init>	()V
    //   766: astore 25
    //   768: aload 18
    //   770: astore 19
    //   772: aload 25
    //   774: ldc_w 811
    //   777: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   780: pop
    //   781: aload 18
    //   783: astore 19
    //   785: aload 25
    //   787: aload_0
    //   788: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   791: pop
    //   792: aload 18
    //   794: astore 19
    //   796: aload 25
    //   798: ldc_w 813
    //   801: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   804: pop
    //   805: aload 18
    //   807: astore 19
    //   809: aload 25
    //   811: aload 24
    //   813: getfield 790	com/tencent/mobileqq/emoticon/DownloadInfo:httpRespCode	I
    //   816: invokevirtual 457	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   819: pop
    //   820: aload 18
    //   822: astore 19
    //   824: aload 25
    //   826: ldc_w 815
    //   829: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   832: pop
    //   833: aload 18
    //   835: astore 19
    //   837: aload 25
    //   839: aload 24
    //   841: getfield 795	com/tencent/mobileqq/emoticon/DownloadInfo:respContentLength	I
    //   844: invokevirtual 457	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   847: pop
    //   848: aload 18
    //   850: astore 19
    //   852: aload 25
    //   854: ldc_w 817
    //   857: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   860: pop
    //   861: aload 18
    //   863: astore 19
    //   865: aload 25
    //   867: aload 24
    //   869: getfield 801	com/tencent/mobileqq/emoticon/DownloadInfo:respContentType	Ljava/lang/String;
    //   872: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   875: pop
    //   876: aload 18
    //   878: astore 19
    //   880: ldc 68
    //   882: iconst_2
    //   883: aload 25
    //   885: invokevirtual 314	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   888: invokestatic 485	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   891: iload 4
    //   893: ifeq +45 -> 938
    //   896: aload 18
    //   898: astore 19
    //   900: aload 24
    //   902: iconst_0
    //   903: putfield 511	com/tencent/mobileqq/emoticon/DownloadInfo:resultCode	I
    //   906: aload 21
    //   908: ifnull +17 -> 925
    //   911: aload 18
    //   913: astore 19
    //   915: aload 21
    //   917: aload 24
    //   919: invokeinterface 682 2 0
    //   924: pop
    //   925: aload 18
    //   927: ifnull +8 -> 935
    //   930: aload 18
    //   932: invokevirtual 820	java/net/HttpURLConnection:disconnect	()V
    //   935: aload 24
    //   937: areturn
    //   938: aload 18
    //   940: astore 19
    //   942: aload 24
    //   944: getfield 790	com/tencent/mobileqq/emoticon/DownloadInfo:httpRespCode	I
    //   947: sipush 200
    //   950: if_icmpne +93 -> 1043
    //   953: aload 21
    //   955: ifnull +65 -> 1020
    //   958: aload 18
    //   960: astore 19
    //   962: aload 24
    //   964: iconst_0
    //   965: putfield 511	com/tencent/mobileqq/emoticon/DownloadInfo:resultCode	I
    //   968: aload 18
    //   970: astore 19
    //   972: aload 21
    //   974: aload 24
    //   976: invokeinterface 682 2 0
    //   981: ifeq +26 -> 1007
    //   984: aload 18
    //   986: astore 19
    //   988: aload 24
    //   990: iconst_0
    //   991: putfield 511	com/tencent/mobileqq/emoticon/DownloadInfo:resultCode	I
    //   994: aload 18
    //   996: ifnull +8 -> 1004
    //   999: aload 18
    //   1001: invokevirtual 820	java/net/HttpURLConnection:disconnect	()V
    //   1004: aload 24
    //   1006: areturn
    //   1007: aload 18
    //   1009: astore 19
    //   1011: aload 24
    //   1013: iconst_4
    //   1014: putfield 511	com/tencent/mobileqq/emoticon/DownloadInfo:resultCode	I
    //   1017: goto +73 -> 1090
    //   1020: aload 18
    //   1022: astore 19
    //   1024: aload 24
    //   1026: iconst_0
    //   1027: putfield 511	com/tencent/mobileqq/emoticon/DownloadInfo:resultCode	I
    //   1030: aload 18
    //   1032: ifnull +8 -> 1040
    //   1035: aload 18
    //   1037: invokevirtual 820	java/net/HttpURLConnection:disconnect	()V
    //   1040: aload 24
    //   1042: areturn
    //   1043: aload 18
    //   1045: astore 19
    //   1047: aload 24
    //   1049: getfield 790	com/tencent/mobileqq/emoticon/DownloadInfo:httpRespCode	I
    //   1052: sipush 302
    //   1055: if_icmpeq +52 -> 1107
    //   1058: aload 18
    //   1060: astore 19
    //   1062: aload 24
    //   1064: getfield 790	com/tencent/mobileqq/emoticon/DownloadInfo:httpRespCode	I
    //   1067: sipush 301
    //   1070: if_icmpne +6 -> 1076
    //   1073: goto +34 -> 1107
    //   1076: aload 18
    //   1078: astore 19
    //   1080: aload 24
    //   1082: aload 24
    //   1084: getfield 790	com/tencent/mobileqq/emoticon/DownloadInfo:httpRespCode	I
    //   1087: putfield 511	com/tencent/mobileqq/emoticon/DownloadInfo:resultCode	I
    //   1090: aload 18
    //   1092: ifnull +8 -> 1100
    //   1095: aload 18
    //   1097: invokevirtual 820	java/net/HttpURLConnection:disconnect	()V
    //   1100: lload 12
    //   1102: lstore 14
    //   1104: goto +886 -> 1990
    //   1107: aload 18
    //   1109: astore 19
    //   1111: aload 18
    //   1113: ldc_w 822
    //   1116: invokevirtual 257	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   1119: astore 21
    //   1121: aload 18
    //   1123: astore 19
    //   1125: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1128: ifeq +1076 -> 2204
    //   1131: aload 18
    //   1133: astore 19
    //   1135: new 306	java/lang/StringBuilder
    //   1138: dup
    //   1139: invokespecial 307	java/lang/StringBuilder:<init>	()V
    //   1142: astore 25
    //   1144: aload 18
    //   1146: astore 19
    //   1148: aload 25
    //   1150: ldc_w 824
    //   1153: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1156: pop
    //   1157: aload 18
    //   1159: astore 19
    //   1161: aload 25
    //   1163: aload 21
    //   1165: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1168: pop
    //   1169: aload 18
    //   1171: astore 19
    //   1173: ldc 68
    //   1175: iconst_2
    //   1176: aload 25
    //   1178: invokevirtual 314	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1181: invokestatic 523	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1184: goto +3 -> 1187
    //   1187: aload 18
    //   1189: astore 19
    //   1191: aload 21
    //   1193: invokestatic 829	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1196: ifeq +27 -> 1223
    //   1199: aload 18
    //   1201: astore 19
    //   1203: aload 24
    //   1205: bipush 20
    //   1207: putfield 511	com/tencent/mobileqq/emoticon/DownloadInfo:resultCode	I
    //   1210: aload 18
    //   1212: ifnull +8 -> 1220
    //   1215: aload 18
    //   1217: invokevirtual 820	java/net/HttpURLConnection:disconnect	()V
    //   1220: aload 24
    //   1222: areturn
    //   1223: aload 18
    //   1225: astore 19
    //   1227: aload 18
    //   1229: invokevirtual 820	java/net/HttpURLConnection:disconnect	()V
    //   1232: aload 23
    //   1234: ifnull +167 -> 1401
    //   1237: lload 12
    //   1239: lstore 14
    //   1241: lload 12
    //   1243: lstore 16
    //   1245: aload_2
    //   1246: invokeinterface 832 1 0
    //   1251: istore 10
    //   1253: iconst_0
    //   1254: istore 9
    //   1256: iload 9
    //   1258: iload 10
    //   1260: if_icmpge +956 -> 2216
    //   1263: lload 12
    //   1265: lstore 14
    //   1267: lload 12
    //   1269: lstore 16
    //   1271: aload 23
    //   1273: iload 9
    //   1275: invokeinterface 836 2 0
    //   1280: checkcast 753	org/apache/http/Header
    //   1283: astore 18
    //   1285: lload 12
    //   1287: lstore 14
    //   1289: lload 12
    //   1291: lstore 16
    //   1293: aload 18
    //   1295: invokeinterface 756 1 0
    //   1300: astore 19
    //   1302: aload 19
    //   1304: ldc_w 838
    //   1307: invokevirtual 696	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1310: ifeq +897 -> 2207
    //   1313: aload 23
    //   1315: aload 18
    //   1317: invokeinterface 841 2 0
    //   1322: pop
    //   1323: goto +3 -> 1326
    //   1326: lload 12
    //   1328: lstore 14
    //   1330: aload 23
    //   1332: new 843	org/apache/http/message/BasicHeader
    //   1335: dup
    //   1336: ldc_w 838
    //   1339: new 279	java/net/URL
    //   1342: dup
    //   1343: aload 21
    //   1345: invokespecial 283	java/net/URL:<init>	(Ljava/lang/String;)V
    //   1348: invokevirtual 391	java/net/URL:getHost	()Ljava/lang/String;
    //   1351: invokespecial 845	org/apache/http/message/BasicHeader:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   1354: invokeinterface 848 2 0
    //   1359: pop
    //   1360: lload 14
    //   1362: lstore 12
    //   1364: goto +37 -> 1401
    //   1367: astore 19
    //   1369: goto +14 -> 1383
    //   1372: astore 19
    //   1374: goto +21 -> 1395
    //   1377: astore 19
    //   1379: lload 14
    //   1381: lstore 12
    //   1383: aconst_null
    //   1384: astore 18
    //   1386: goto -1128 -> 258
    //   1389: astore 19
    //   1391: lload 16
    //   1393: lstore 12
    //   1395: aconst_null
    //   1396: astore 18
    //   1398: goto -1131 -> 267
    //   1401: aload 21
    //   1403: aload_1
    //   1404: aload_2
    //   1405: iload_3
    //   1406: iload 4
    //   1408: iload 5
    //   1410: iconst_1
    //   1411: iadd
    //   1412: iload 6
    //   1414: iload 7
    //   1416: invokestatic 666	com/tencent/mobileqq/utils/HttpDownloadUtil:queryDownloadInfo	(Ljava/lang/String;Lcom/tencent/mobileqq/utils/HttpDownloadUtil$DownloadInfoListener;Ljava/util/List;IZIII)Lcom/tencent/mobileqq/emoticon/DownloadInfo;
    //   1419: astore 18
    //   1421: aload 18
    //   1423: areturn
    //   1424: astore_0
    //   1425: aconst_null
    //   1426: astore 19
    //   1428: goto +656 -> 2084
    //   1431: astore 21
    //   1433: aconst_null
    //   1434: astore 18
    //   1436: goto +31 -> 1467
    //   1439: astore 21
    //   1441: aconst_null
    //   1442: astore 18
    //   1444: goto +249 -> 1693
    //   1447: astore 19
    //   1449: goto -1191 -> 258
    //   1452: astore 19
    //   1454: goto -1187 -> 267
    //   1457: astore_0
    //   1458: aload 18
    //   1460: astore 19
    //   1462: goto +622 -> 2084
    //   1465: astore 21
    //   1467: aload 18
    //   1469: astore 19
    //   1471: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1474: ifeq +12 -> 1486
    //   1477: aload 18
    //   1479: astore 19
    //   1481: aload 21
    //   1483: invokevirtual 506	java/lang/Exception:printStackTrace	()V
    //   1486: aload 18
    //   1488: astore 19
    //   1490: aload 24
    //   1492: iconst_5
    //   1493: putfield 511	com/tencent/mobileqq/emoticon/DownloadInfo:resultCode	I
    //   1496: aload 18
    //   1498: astore 19
    //   1500: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1503: ifeq +143 -> 1646
    //   1506: aload 18
    //   1508: astore 19
    //   1510: new 306	java/lang/StringBuilder
    //   1513: dup
    //   1514: invokespecial 307	java/lang/StringBuilder:<init>	()V
    //   1517: astore 23
    //   1519: aload 18
    //   1521: astore 19
    //   1523: aload 23
    //   1525: ldc_w 850
    //   1528: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1531: pop
    //   1532: aload 18
    //   1534: astore 19
    //   1536: aload 23
    //   1538: aload 24
    //   1540: getfield 511	com/tencent/mobileqq/emoticon/DownloadInfo:resultCode	I
    //   1543: invokevirtual 457	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1546: pop
    //   1547: aload 18
    //   1549: astore 19
    //   1551: aload 23
    //   1553: ldc_w 852
    //   1556: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1559: pop
    //   1560: aload 18
    //   1562: astore 19
    //   1564: aload 23
    //   1566: aload 24
    //   1568: getfield 790	com/tencent/mobileqq/emoticon/DownloadInfo:httpRespCode	I
    //   1571: invokevirtual 457	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1574: pop
    //   1575: aload 18
    //   1577: astore 19
    //   1579: aload 23
    //   1581: ldc_w 515
    //   1584: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1587: pop
    //   1588: aload 18
    //   1590: astore 19
    //   1592: aload 23
    //   1594: aload 24
    //   1596: getfield 282	com/tencent/mobileqq/emoticon/DownloadInfo:reqUrl	Ljava/lang/String;
    //   1599: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1602: pop
    //   1603: aload 18
    //   1605: astore 19
    //   1607: aload 23
    //   1609: ldc_w 517
    //   1612: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1615: pop
    //   1616: aload 18
    //   1618: astore 19
    //   1620: aload 23
    //   1622: aload 21
    //   1624: invokevirtual 853	java/lang/Exception:toString	()Ljava/lang/String;
    //   1627: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1630: pop
    //   1631: aload 18
    //   1633: astore 19
    //   1635: ldc 68
    //   1637: iconst_2
    //   1638: aload 23
    //   1640: invokevirtual 314	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1643: invokestatic 523	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1646: aload 18
    //   1648: astore 19
    //   1650: lload 12
    //   1652: lstore 14
    //   1654: iload 8
    //   1656: istore 9
    //   1658: aload 18
    //   1660: ifnull +20 -> 1680
    //   1663: aload 18
    //   1665: invokevirtual 820	java/net/HttpURLConnection:disconnect	()V
    //   1668: iload 8
    //   1670: istore 9
    //   1672: lload 12
    //   1674: lstore 14
    //   1676: aload 18
    //   1678: astore 19
    //   1680: aload 19
    //   1682: astore 18
    //   1684: iload 9
    //   1686: istore 8
    //   1688: goto +302 -> 1990
    //   1691: astore 21
    //   1693: iconst_5
    //   1694: istore 9
    //   1696: aload 18
    //   1698: astore 19
    //   1700: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1703: ifeq +12 -> 1715
    //   1706: aload 18
    //   1708: astore 19
    //   1710: aload 21
    //   1712: invokevirtual 504	java/io/IOException:printStackTrace	()V
    //   1715: aload 18
    //   1717: astore 19
    //   1719: aload 21
    //   1721: instanceof 508
    //   1724: ifeq +13 -> 1737
    //   1727: iload_3
    //   1728: istore 8
    //   1730: bipush 10
    //   1732: istore 9
    //   1734: goto +78 -> 1812
    //   1737: aload 18
    //   1739: astore 19
    //   1741: aload 21
    //   1743: instanceof 490
    //   1746: ifne +479 -> 2225
    //   1749: aload 18
    //   1751: astore 19
    //   1753: aload 21
    //   1755: instanceof 492
    //   1758: ifeq +6 -> 1764
    //   1761: goto +464 -> 2225
    //   1764: aload 18
    //   1766: astore 19
    //   1768: aload 21
    //   1770: instanceof 494
    //   1773: ifeq +17 -> 1790
    //   1776: aload 18
    //   1778: astore 19
    //   1780: aload 24
    //   1782: bipush 11
    //   1784: putfield 511	com/tencent/mobileqq/emoticon/DownloadInfo:resultCode	I
    //   1787: goto +25 -> 1812
    //   1790: aload 18
    //   1792: astore 19
    //   1794: aload 21
    //   1796: instanceof 269
    //   1799: ifeq +420 -> 2219
    //   1802: iload_3
    //   1803: istore 8
    //   1805: bipush 13
    //   1807: istore 9
    //   1809: goto +3 -> 1812
    //   1812: aload 18
    //   1814: astore 19
    //   1816: aload 24
    //   1818: iload 9
    //   1820: putfield 511	com/tencent/mobileqq/emoticon/DownloadInfo:resultCode	I
    //   1823: aload 18
    //   1825: astore 19
    //   1827: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1830: ifeq +140 -> 1970
    //   1833: aload 18
    //   1835: astore 19
    //   1837: new 306	java/lang/StringBuilder
    //   1840: dup
    //   1841: invokespecial 307	java/lang/StringBuilder:<init>	()V
    //   1844: astore 23
    //   1846: aload 18
    //   1848: astore 19
    //   1850: aload 23
    //   1852: ldc_w 850
    //   1855: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1858: pop
    //   1859: aload 18
    //   1861: astore 19
    //   1863: aload 23
    //   1865: iload 9
    //   1867: invokevirtual 457	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1870: pop
    //   1871: aload 18
    //   1873: astore 19
    //   1875: aload 23
    //   1877: ldc_w 855
    //   1880: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1883: pop
    //   1884: aload 18
    //   1886: astore 19
    //   1888: aload 23
    //   1890: aload 24
    //   1892: getfield 790	com/tencent/mobileqq/emoticon/DownloadInfo:httpRespCode	I
    //   1895: invokevirtual 457	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1898: pop
    //   1899: aload 18
    //   1901: astore 19
    //   1903: aload 23
    //   1905: ldc_w 515
    //   1908: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1911: pop
    //   1912: aload 18
    //   1914: astore 19
    //   1916: aload 23
    //   1918: aload 24
    //   1920: getfield 282	com/tencent/mobileqq/emoticon/DownloadInfo:reqUrl	Ljava/lang/String;
    //   1923: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1926: pop
    //   1927: aload 18
    //   1929: astore 19
    //   1931: aload 23
    //   1933: ldc_w 857
    //   1936: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1939: pop
    //   1940: aload 18
    //   1942: astore 19
    //   1944: aload 23
    //   1946: aload 21
    //   1948: invokevirtual 858	java/io/IOException:toString	()Ljava/lang/String;
    //   1951: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1954: pop
    //   1955: aload 18
    //   1957: astore 19
    //   1959: ldc 68
    //   1961: iconst_2
    //   1962: aload 23
    //   1964: invokevirtual 314	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1967: invokestatic 523	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1970: aload 18
    //   1972: astore 19
    //   1974: lload 12
    //   1976: lstore 14
    //   1978: iload 8
    //   1980: istore 9
    //   1982: aload 18
    //   1984: ifnull -304 -> 1680
    //   1987: goto -324 -> 1663
    //   1990: aload 20
    //   1992: astore 19
    //   1994: iload 8
    //   1996: iconst_1
    //   1997: iadd
    //   1998: istore 8
    //   2000: iload 8
    //   2002: iload_3
    //   2003: if_icmpge +39 -> 2042
    //   2006: aload 19
    //   2008: monitorenter
    //   2009: aload 19
    //   2011: lload 14
    //   2013: invokevirtual 533	java/lang/Object:wait	(J)V
    //   2016: lload 14
    //   2018: ldc2_w 683
    //   2021: lmul
    //   2022: lstore 14
    //   2024: goto +7 -> 2031
    //   2027: astore_0
    //   2028: goto +9 -> 2037
    //   2031: aload 19
    //   2033: monitorexit
    //   2034: goto +26 -> 2060
    //   2037: aload 19
    //   2039: monitorexit
    //   2040: aload_0
    //   2041: athrow
    //   2042: aload_1
    //   2043: astore 19
    //   2045: aload 19
    //   2047: ifnull +13 -> 2060
    //   2050: aload 19
    //   2052: aload 24
    //   2054: invokeinterface 682 2 0
    //   2059: pop
    //   2060: aload_1
    //   2061: astore 19
    //   2063: iload 8
    //   2065: iload_3
    //   2066: if_icmplt +6 -> 2072
    //   2069: aload 24
    //   2071: areturn
    //   2072: lload 14
    //   2074: lstore 12
    //   2076: aload 19
    //   2078: astore 21
    //   2080: goto -1954 -> 126
    //   2083: astore_0
    //   2084: aload 19
    //   2086: ifnull +8 -> 2094
    //   2089: aload 19
    //   2091: invokevirtual 820	java/net/HttpURLConnection:disconnect	()V
    //   2094: aload_0
    //   2095: athrow
    //   2096: astore_0
    //   2097: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2100: ifeq +13 -> 2113
    //   2103: ldc 68
    //   2105: iconst_2
    //   2106: aload_0
    //   2107: invokevirtual 859	java/lang/IllegalArgumentException:toString	()Ljava/lang/String;
    //   2110: invokestatic 523	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   2113: aload 24
    //   2115: bipush 13
    //   2117: putfield 511	com/tencent/mobileqq/emoticon/DownloadInfo:resultCode	I
    //   2120: aload 21
    //   2122: ifnull +13 -> 2135
    //   2125: aload 21
    //   2127: aload 24
    //   2129: invokeinterface 682 2 0
    //   2134: pop
    //   2135: aload 24
    //   2137: areturn
    //   2138: astore_0
    //   2139: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2142: ifeq +13 -> 2155
    //   2145: ldc 68
    //   2147: iconst_2
    //   2148: aload_0
    //   2149: invokevirtual 860	java/net/MalformedURLException:toString	()Ljava/lang/String;
    //   2152: invokestatic 523	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   2155: aload 24
    //   2157: aload_0
    //   2158: invokestatic 537	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   2161: putfield 540	com/tencent/mobileqq/emoticon/DownloadInfo:errorDetail	Ljava/lang/String;
    //   2164: aload 24
    //   2166: bipush 13
    //   2168: putfield 511	com/tencent/mobileqq/emoticon/DownloadInfo:resultCode	I
    //   2171: aload 21
    //   2173: ifnull +13 -> 2186
    //   2176: aload 21
    //   2178: aload 24
    //   2180: invokeinterface 682 2 0
    //   2185: pop
    //   2186: aload 24
    //   2188: areturn
    //   2189: astore 19
    //   2191: goto -2108 -> 83
    //   2194: astore 19
    //   2196: goto -1981 -> 215
    //   2199: astore 21
    //   2201: goto -170 -> 2031
    //   2204: goto -1017 -> 1187
    //   2207: iload 9
    //   2209: iconst_1
    //   2210: iadd
    //   2211: istore 9
    //   2213: goto -957 -> 1256
    //   2216: goto -890 -> 1326
    //   2219: iconst_4
    //   2220: istore 9
    //   2222: goto -410 -> 1812
    //   2225: iconst_2
    //   2226: istore 9
    //   2228: goto -416 -> 1812
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2231	0	paramString	String
    //   0	2231	1	paramDownloadInfoListener	HttpDownloadUtil.DownloadInfoListener
    //   0	2231	2	paramList	List<Header>
    //   0	2231	3	paramInt1	int
    //   0	2231	4	paramBoolean	boolean
    //   0	2231	5	paramInt2	int
    //   0	2231	6	paramInt3	int
    //   0	2231	7	paramInt4	int
    //   124	1943	8	i	int
    //   251	1976	9	j	int
    //   288	973	10	k	int
    //   305	81	11	bool	boolean
    //   118	1957	12	l1	long
    //   224	1849	14	l2	long
    //   1243	149	16	l3	long
    //   64	1919	18	localObject1	Object
    //   220	25	19	localObject2	Object
    //   256	3	19	localException1	Exception
    //   265	3	19	localIOException1	java.io.IOException
    //   278	1025	19	localObject3	Object
    //   1367	1	19	localException2	Exception
    //   1372	1	19	localIOException2	java.io.IOException
    //   1377	1	19	localException3	Exception
    //   1389	1	19	localIOException3	java.io.IOException
    //   1426	1	19	localObject4	Object
    //   1447	1	19	localException4	Exception
    //   1452	1	19	localIOException4	java.io.IOException
    //   1460	630	19	localObject5	Object
    //   2189	1	19	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   2194	1	19	localInterruptedException1	java.lang.InterruptedException
    //   113	1878	20	localObject6	Object
    //   1	1401	21	localObject7	Object
    //   1431	1	21	localException5	Exception
    //   1439	1	21	localIOException5	java.io.IOException
    //   1465	158	21	localException6	Exception
    //   1691	256	21	localIOException6	java.io.IOException
    //   2078	99	21	localObject8	Object
    //   2199	1	21	localInterruptedException2	java.lang.InterruptedException
    //   78	428	22	localObject9	Object
    //   127	1836	23	localObject10	Object
    //   13	2174	24	localDownloadInfo	DownloadInfo
    //   132	1045	25	localObject11	Object
    //   594	16	26	localHeader	Header
    // Exception table:
    //   from	to	target	type
    //   193	200	211	finally
    //   215	218	211	finally
    //   229	232	211	finally
    //   239	253	256	java/lang/Exception
    //   312	317	256	java/lang/Exception
    //   323	334	256	java/lang/Exception
    //   337	341	256	java/lang/Exception
    //   344	348	256	java/lang/Exception
    //   354	376	256	java/lang/Exception
    //   376	380	256	java/lang/Exception
    //   400	433	256	java/lang/Exception
    //   436	458	256	java/lang/Exception
    //   465	476	256	java/lang/Exception
    //   483	494	256	java/lang/Exception
    //   239	253	265	java/io/IOException
    //   312	317	265	java/io/IOException
    //   323	334	265	java/io/IOException
    //   337	341	265	java/io/IOException
    //   344	348	265	java/io/IOException
    //   354	376	265	java/io/IOException
    //   376	380	265	java/io/IOException
    //   400	433	265	java/io/IOException
    //   436	458	265	java/io/IOException
    //   465	476	265	java/io/IOException
    //   483	494	265	java/io/IOException
    //   1302	1323	1367	java/lang/Exception
    //   1330	1360	1367	java/lang/Exception
    //   1302	1323	1372	java/io/IOException
    //   1330	1360	1372	java/io/IOException
    //   1245	1253	1377	java/lang/Exception
    //   1271	1285	1377	java/lang/Exception
    //   1293	1302	1377	java/lang/Exception
    //   1245	1253	1389	java/io/IOException
    //   1271	1285	1389	java/io/IOException
    //   1293	1302	1389	java/io/IOException
    //   1245	1253	1424	finally
    //   1271	1285	1424	finally
    //   1293	1302	1424	finally
    //   1302	1323	1424	finally
    //   1330	1360	1424	finally
    //   1401	1421	1424	finally
    //   1401	1421	1431	java/lang/Exception
    //   1401	1421	1439	java/io/IOException
    //   529	536	1447	java/lang/Exception
    //   545	554	1447	java/lang/Exception
    //   558	566	1447	java/lang/Exception
    //   570	580	1447	java/lang/Exception
    //   584	596	1447	java/lang/Exception
    //   600	619	1447	java/lang/Exception
    //   626	637	1447	java/lang/Exception
    //   641	648	1447	java/lang/Exception
    //   652	659	1447	java/lang/Exception
    //   663	669	1447	java/lang/Exception
    //   673	678	1447	java/lang/Exception
    //   682	692	1447	java/lang/Exception
    //   696	706	1447	java/lang/Exception
    //   710	720	1447	java/lang/Exception
    //   724	734	1447	java/lang/Exception
    //   738	745	1447	java/lang/Exception
    //   749	755	1447	java/lang/Exception
    //   759	768	1447	java/lang/Exception
    //   772	781	1447	java/lang/Exception
    //   785	792	1447	java/lang/Exception
    //   796	805	1447	java/lang/Exception
    //   809	820	1447	java/lang/Exception
    //   824	833	1447	java/lang/Exception
    //   837	848	1447	java/lang/Exception
    //   852	861	1447	java/lang/Exception
    //   865	876	1447	java/lang/Exception
    //   880	891	1447	java/lang/Exception
    //   900	906	1447	java/lang/Exception
    //   915	925	1447	java/lang/Exception
    //   942	953	1447	java/lang/Exception
    //   962	968	1447	java/lang/Exception
    //   972	984	1447	java/lang/Exception
    //   988	994	1447	java/lang/Exception
    //   1011	1017	1447	java/lang/Exception
    //   1024	1030	1447	java/lang/Exception
    //   1047	1058	1447	java/lang/Exception
    //   1062	1073	1447	java/lang/Exception
    //   1080	1090	1447	java/lang/Exception
    //   1111	1121	1447	java/lang/Exception
    //   1125	1131	1447	java/lang/Exception
    //   1135	1144	1447	java/lang/Exception
    //   1148	1157	1447	java/lang/Exception
    //   1161	1169	1447	java/lang/Exception
    //   1173	1184	1447	java/lang/Exception
    //   1191	1199	1447	java/lang/Exception
    //   1203	1210	1447	java/lang/Exception
    //   1227	1232	1447	java/lang/Exception
    //   529	536	1452	java/io/IOException
    //   545	554	1452	java/io/IOException
    //   558	566	1452	java/io/IOException
    //   570	580	1452	java/io/IOException
    //   584	596	1452	java/io/IOException
    //   600	619	1452	java/io/IOException
    //   626	637	1452	java/io/IOException
    //   641	648	1452	java/io/IOException
    //   652	659	1452	java/io/IOException
    //   663	669	1452	java/io/IOException
    //   673	678	1452	java/io/IOException
    //   682	692	1452	java/io/IOException
    //   696	706	1452	java/io/IOException
    //   710	720	1452	java/io/IOException
    //   724	734	1452	java/io/IOException
    //   738	745	1452	java/io/IOException
    //   749	755	1452	java/io/IOException
    //   759	768	1452	java/io/IOException
    //   772	781	1452	java/io/IOException
    //   785	792	1452	java/io/IOException
    //   796	805	1452	java/io/IOException
    //   809	820	1452	java/io/IOException
    //   824	833	1452	java/io/IOException
    //   837	848	1452	java/io/IOException
    //   852	861	1452	java/io/IOException
    //   865	876	1452	java/io/IOException
    //   880	891	1452	java/io/IOException
    //   900	906	1452	java/io/IOException
    //   915	925	1452	java/io/IOException
    //   942	953	1452	java/io/IOException
    //   962	968	1452	java/io/IOException
    //   972	984	1452	java/io/IOException
    //   988	994	1452	java/io/IOException
    //   1011	1017	1452	java/io/IOException
    //   1024	1030	1452	java/io/IOException
    //   1047	1058	1452	java/io/IOException
    //   1062	1073	1452	java/io/IOException
    //   1080	1090	1452	java/io/IOException
    //   1111	1121	1452	java/io/IOException
    //   1125	1131	1452	java/io/IOException
    //   1135	1144	1452	java/io/IOException
    //   1148	1157	1452	java/io/IOException
    //   1161	1169	1452	java/io/IOException
    //   1173	1184	1452	java/io/IOException
    //   1191	1199	1452	java/io/IOException
    //   1203	1210	1452	java/io/IOException
    //   1227	1232	1452	java/io/IOException
    //   239	253	1457	finally
    //   280	307	1457	finally
    //   312	317	1457	finally
    //   323	334	1457	finally
    //   337	341	1457	finally
    //   344	348	1457	finally
    //   354	376	1457	finally
    //   376	380	1457	finally
    //   380	385	1457	finally
    //   400	433	1457	finally
    //   436	458	1457	finally
    //   465	476	1457	finally
    //   483	494	1457	finally
    //   501	521	1457	finally
    //   280	307	1465	java/lang/Exception
    //   380	385	1465	java/lang/Exception
    //   501	521	1465	java/lang/Exception
    //   280	307	1691	java/io/IOException
    //   380	385	1691	java/io/IOException
    //   501	521	1691	java/io/IOException
    //   2009	2016	2027	finally
    //   2031	2034	2027	finally
    //   2037	2040	2027	finally
    //   529	536	2083	finally
    //   545	554	2083	finally
    //   558	566	2083	finally
    //   570	580	2083	finally
    //   584	596	2083	finally
    //   600	619	2083	finally
    //   626	637	2083	finally
    //   641	648	2083	finally
    //   652	659	2083	finally
    //   663	669	2083	finally
    //   673	678	2083	finally
    //   682	692	2083	finally
    //   696	706	2083	finally
    //   710	720	2083	finally
    //   724	734	2083	finally
    //   738	745	2083	finally
    //   749	755	2083	finally
    //   759	768	2083	finally
    //   772	781	2083	finally
    //   785	792	2083	finally
    //   796	805	2083	finally
    //   809	820	2083	finally
    //   824	833	2083	finally
    //   837	848	2083	finally
    //   852	861	2083	finally
    //   865	876	2083	finally
    //   880	891	2083	finally
    //   900	906	2083	finally
    //   915	925	2083	finally
    //   942	953	2083	finally
    //   962	968	2083	finally
    //   972	984	2083	finally
    //   988	994	2083	finally
    //   1011	1017	2083	finally
    //   1024	1030	2083	finally
    //   1047	1058	2083	finally
    //   1062	1073	2083	finally
    //   1080	1090	2083	finally
    //   1111	1121	2083	finally
    //   1125	1131	2083	finally
    //   1135	1144	2083	finally
    //   1148	1157	2083	finally
    //   1161	1169	2083	finally
    //   1173	1184	2083	finally
    //   1191	1199	2083	finally
    //   1203	1210	2083	finally
    //   1227	1232	2083	finally
    //   1471	1477	2083	finally
    //   1481	1486	2083	finally
    //   1490	1496	2083	finally
    //   1500	1506	2083	finally
    //   1510	1519	2083	finally
    //   1523	1532	2083	finally
    //   1536	1547	2083	finally
    //   1551	1560	2083	finally
    //   1564	1575	2083	finally
    //   1579	1588	2083	finally
    //   1592	1603	2083	finally
    //   1607	1616	2083	finally
    //   1620	1631	2083	finally
    //   1635	1646	2083	finally
    //   1700	1706	2083	finally
    //   1710	1715	2083	finally
    //   1719	1727	2083	finally
    //   1741	1749	2083	finally
    //   1753	1761	2083	finally
    //   1768	1776	2083	finally
    //   1780	1787	2083	finally
    //   1794	1802	2083	finally
    //   1816	1823	2083	finally
    //   1827	1833	2083	finally
    //   1837	1846	2083	finally
    //   1850	1859	2083	finally
    //   1863	1871	2083	finally
    //   1875	1884	2083	finally
    //   1888	1899	2083	finally
    //   1903	1912	2083	finally
    //   1916	1927	2083	finally
    //   1931	1940	2083	finally
    //   1944	1955	2083	finally
    //   1959	1970	2083	finally
    //   83	103	2096	java/lang/IllegalArgumentException
    //   46	59	2138	java/net/MalformedURLException
    //   66	76	2189	java/lang/IllegalArgumentException
    //   193	200	2194	java/lang/InterruptedException
    //   2009	2016	2199	java/lang/InterruptedException
  }
  
  public static boolean shutdownSniSupport()
  {
    if (!sShutdownSniSupportInited)
    {
      sShutdownSniSupportInited = true;
      try
      {
        Object localObject = UtilApi.a.a();
        if (QLog.isColorLevel())
        {
          localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("shutdownSniSupport:");
          localStringBuilder2.append((String)localObject);
          QLog.d("HttpDownloadUtil", 2, localStringBuilder2.toString());
        }
        localObject = ((String)localObject).split("\\|");
        if (localObject.length > 15) {
          sShutdownSniSupport = localObject[15].equals("1");
        }
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder2;
        if (QLog.isColorLevel())
        {
          localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("shutdownSniSupport e:");
          localStringBuilder2.append(localException.toString());
          QLog.d("HttpDownloadUtil", 2, localStringBuilder2.toString());
        }
      }
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("shutdownSniSupport ");
      localStringBuilder1.append(sShutdownSniSupport);
      QLog.d("HttpDownloadUtil", 2, localStringBuilder1.toString());
    }
    return sShutdownSniSupport;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.HttpDownloadUtil
 * JD-Core Version:    0.7.0.1
 */