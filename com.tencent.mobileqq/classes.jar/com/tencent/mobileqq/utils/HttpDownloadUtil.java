package com.tencent.mobileqq.utils;

import android.net.NetworkInfo;
import android.net.Proxy;
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
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.List;
import mqq.app.AppRuntime;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpVersion;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.message.BasicHeader;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.jetbrains.annotations.NotNull;

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
    //   1: astore 19
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
    //   23: astore 44
    //   25: invokestatic 90	java/lang/System:currentTimeMillis	()J
    //   28: lstore 14
    //   30: new 4	java/lang/Object
    //   33: dup
    //   34: invokespecial 231	java/lang/Object:<init>	()V
    //   37: astore 43
    //   39: aload_1
    //   40: aload 19
    //   42: aload 44
    //   44: invokestatic 287	com/tencent/mobileqq/utils/HttpDownloadUtil:makeParentDirsFailed	(Lcom/tencent/mobileqq/emoticon/DownloadInfo;Lcom/tencent/mobileqq/utils/HttpDownloadUtil$HttpDownloadListener;Ljava/net/URL;)Z
    //   47: ifeq +5 -> 52
    //   50: iconst_4
    //   51: ireturn
    //   52: aload_1
    //   53: getfield 282	com/tencent/mobileqq/emoticon/DownloadInfo:reqUrl	Ljava/lang/String;
    //   56: astore 20
    //   58: new 289	org/apache/http/client/methods/HttpGet
    //   61: dup
    //   62: aload 20
    //   64: invokespecial 290	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   67: astore_0
    //   68: goto +19 -> 87
    //   71: new 289	org/apache/http/client/methods/HttpGet
    //   74: dup
    //   75: aload 20
    //   77: invokestatic 293	com/tencent/mobileqq/utils/HttpDownloadUtil:getEscapeSequence	(Ljava/lang/String;)Ljava/lang/String;
    //   80: invokespecial 290	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   83: astore_0
    //   84: goto -16 -> 68
    //   87: new 94	org/apache/http/params/BasicHttpParams
    //   90: dup
    //   91: invokespecial 97	org/apache/http/params/BasicHttpParams:<init>	()V
    //   94: astore 21
    //   96: aload 21
    //   98: ldc_w 295
    //   101: ldc_w 296
    //   104: invokestatic 302	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   107: invokeinterface 308 3 0
    //   112: pop
    //   113: aload 21
    //   115: ldc_w 310
    //   118: ldc_w 296
    //   121: invokestatic 302	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   124: invokeinterface 308 3 0
    //   129: pop
    //   130: invokestatic 315	android/net/Proxy:getDefaultHost	()Ljava/lang/String;
    //   133: astore 20
    //   135: invokestatic 319	android/net/Proxy:getDefaultPort	()I
    //   138: istore 4
    //   140: aload_2
    //   141: ifnull +106 -> 247
    //   144: aload_2
    //   145: invokevirtual 324	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   148: astore 22
    //   150: aload_2
    //   151: invokestatic 330	com/tencent/mobileqq/utils/NetworkUtil:isMobileNetworkInfo	(Landroid/net/NetworkInfo;)Z
    //   154: ifeq +51 -> 205
    //   157: aload 22
    //   159: ifnull +14 -> 173
    //   162: aload 22
    //   164: ldc_w 332
    //   167: invokevirtual 338	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   170: ifeq +35 -> 205
    //   173: aload 20
    //   175: ifnull +30 -> 205
    //   178: iload 4
    //   180: ifle +25 -> 205
    //   183: aload 21
    //   185: ldc_w 340
    //   188: new 342	org/apache/http/HttpHost
    //   191: dup
    //   192: aload 20
    //   194: iload 4
    //   196: invokespecial 345	org/apache/http/HttpHost:<init>	(Ljava/lang/String;I)V
    //   199: invokeinterface 308 3 0
    //   204: pop
    //   205: aload_2
    //   206: invokestatic 330	com/tencent/mobileqq/utils/NetworkUtil:isMobileNetworkInfo	(Landroid/net/NetworkInfo;)Z
    //   209: ifeq +11 -> 220
    //   212: sipush 2048
    //   215: istore 4
    //   217: goto +8 -> 225
    //   220: sipush 4096
    //   223: istore 4
    //   225: aload 21
    //   227: ldc_w 347
    //   230: iload 4
    //   232: invokeinterface 351 3 0
    //   237: pop
    //   238: aload_0
    //   239: aload 21
    //   241: invokevirtual 355	org/apache/http/client/methods/HttpGet:setParams	(Lorg/apache/http/params/HttpParams;)V
    //   244: goto +6 -> 250
    //   247: iconst_0
    //   248: istore 4
    //   250: new 357	java/io/File
    //   253: dup
    //   254: aload_1
    //   255: invokevirtual 360	com/tencent/mobileqq/emoticon/DownloadInfo:getLoadingTmpPath	()Ljava/lang/String;
    //   258: invokespecial 361	java/io/File:<init>	(Ljava/lang/String;)V
    //   261: astore 22
    //   263: aload 22
    //   265: invokevirtual 364	java/io/File:exists	()Z
    //   268: ifeq +9 -> 277
    //   271: aload 22
    //   273: invokevirtual 367	java/io/File:delete	()Z
    //   276: pop
    //   277: aconst_null
    //   278: astore 24
    //   280: aload 24
    //   282: astore 23
    //   284: iconst_m1
    //   285: istore 11
    //   287: aload_0
    //   288: astore 20
    //   290: aload 19
    //   292: astore_0
    //   293: aload 24
    //   295: astore 19
    //   297: iload 11
    //   299: ifne +38 -> 337
    //   302: aload 21
    //   304: ldc_w 340
    //   307: new 342	org/apache/http/HttpHost
    //   310: dup
    //   311: aload 44
    //   313: invokevirtual 370	java/net/URL:getHost	()Ljava/lang/String;
    //   316: aload 44
    //   318: invokevirtual 373	java/net/URL:getPort	()I
    //   321: invokespecial 345	org/apache/http/HttpHost:<init>	(Ljava/lang/String;I)V
    //   324: invokeinterface 308 3 0
    //   329: pop
    //   330: aload 20
    //   332: aload 21
    //   334: invokevirtual 355	org/apache/http/client/methods/HttpGet:setParams	(Lorg/apache/http/params/HttpParams;)V
    //   337: aload 19
    //   339: astore 25
    //   341: aload 23
    //   343: astore 24
    //   345: getstatic 197	com/tencent/mobileqq/utils/HttpDownloadUtil:CLIENT	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   348: new 342	org/apache/http/HttpHost
    //   351: dup
    //   352: aload 44
    //   354: invokevirtual 370	java/net/URL:getHost	()Ljava/lang/String;
    //   357: invokespecial 374	org/apache/http/HttpHost:<init>	(Ljava/lang/String;)V
    //   360: aload 20
    //   362: invokevirtual 378	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/HttpHost;Lorg/apache/http/HttpRequest;)Lorg/apache/http/HttpResponse;
    //   365: astore 26
    //   367: aload 19
    //   369: astore 25
    //   371: aload 23
    //   373: astore 24
    //   375: aload 26
    //   377: invokeinterface 384 1 0
    //   382: astore 27
    //   384: aload 19
    //   386: astore 25
    //   388: aload 23
    //   390: astore 24
    //   392: aload 26
    //   394: invokeinterface 388 1 0
    //   399: pop
    //   400: aload 19
    //   402: astore 25
    //   404: aload 23
    //   406: astore 24
    //   408: aload 27
    //   410: invokeinterface 393 1 0
    //   415: istore 5
    //   417: aload_0
    //   418: ifnull +47 -> 465
    //   421: aload 19
    //   423: astore 25
    //   425: aload 23
    //   427: astore 24
    //   429: aload_0
    //   430: aload 44
    //   432: invokevirtual 396	java/net/URL:toString	()Ljava/lang/String;
    //   435: iload 5
    //   437: invokeinterface 401 3 0
    //   442: goto +23 -> 465
    //   445: astore 24
    //   447: aload 20
    //   449: astore 28
    //   451: iconst_5
    //   452: istore 6
    //   454: aload 24
    //   456: astore 20
    //   458: aload 22
    //   460: astore 32
    //   462: goto +1881 -> 2343
    //   465: aload 19
    //   467: astore 25
    //   469: aload 23
    //   471: astore 24
    //   473: aload 26
    //   475: invokeinterface 405 1 0
    //   480: astore 26
    //   482: aload 26
    //   484: astore 23
    //   486: sipush 200
    //   489: iload 5
    //   491: if_icmpne +1466 -> 1957
    //   494: aload 23
    //   496: invokeinterface 410 1 0
    //   501: lstore 12
    //   503: new 412	java/io/FileOutputStream
    //   506: dup
    //   507: aload 22
    //   509: invokespecial 415	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   512: astore_0
    //   513: aload 23
    //   515: invokeinterface 419 1 0
    //   520: astore 24
    //   522: iload 4
    //   524: ifne +11 -> 535
    //   527: sipush 2048
    //   530: istore 4
    //   532: goto +3 -> 535
    //   535: iload 4
    //   537: newarray byte
    //   539: astore 25
    //   541: aload 22
    //   543: astore 19
    //   545: iconst_0
    //   546: istore 5
    //   548: aload 20
    //   550: astore 22
    //   552: aload 23
    //   554: astore 20
    //   556: aload 24
    //   558: astore 23
    //   560: iload 5
    //   562: i2l
    //   563: lstore 16
    //   565: lload 16
    //   567: lload 12
    //   569: lcmp
    //   570: ifge +136 -> 706
    //   573: aload 23
    //   575: aload 25
    //   577: invokevirtual 425	java/io/InputStream:read	([B)I
    //   580: istore 6
    //   582: aload_0
    //   583: aload 25
    //   585: iconst_0
    //   586: iload 6
    //   588: invokevirtual 431	java/io/OutputStream:write	([BII)V
    //   591: iload 6
    //   593: iload 5
    //   595: iadd
    //   596: istore 5
    //   598: aload_3
    //   599: ifnull +50 -> 649
    //   602: aload 44
    //   604: invokevirtual 396	java/net/URL:toString	()Ljava/lang/String;
    //   607: astore 24
    //   609: iload 5
    //   611: i2l
    //   612: lstore 16
    //   614: aload_3
    //   615: aload 24
    //   617: lload 12
    //   619: lload 16
    //   621: invokeinterface 434 6 0
    //   626: goto +23 -> 649
    //   629: astore 24
    //   631: goto +23 -> 654
    //   634: astore 24
    //   636: goto +47 -> 683
    //   639: astore 24
    //   641: goto +13 -> 654
    //   644: astore 24
    //   646: goto +37 -> 683
    //   649: goto -89 -> 560
    //   652: astore 24
    //   654: aload 21
    //   656: astore 25
    //   658: aload 20
    //   660: astore 26
    //   662: aload 23
    //   664: astore 21
    //   666: aload 22
    //   668: astore 20
    //   670: aload 24
    //   672: astore 23
    //   674: aload 26
    //   676: astore 24
    //   678: goto +670 -> 1348
    //   681: astore 24
    //   683: aload 23
    //   685: astore 26
    //   687: aload 24
    //   689: astore 23
    //   691: aload 19
    //   693: astore 25
    //   695: aload 22
    //   697: astore 19
    //   699: aload 26
    //   701: astore 24
    //   703: goto +687 -> 1390
    //   706: aload 23
    //   708: astore 24
    //   710: aload_3
    //   711: astore 31
    //   713: lload 16
    //   715: lload 12
    //   717: lcmp
    //   718: ifne +78 -> 796
    //   721: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   724: ifeq +42 -> 766
    //   727: new 436	java/lang/StringBuilder
    //   730: dup
    //   731: invokespecial 437	java/lang/StringBuilder:<init>	()V
    //   734: astore 23
    //   736: aload 23
    //   738: ldc_w 439
    //   741: invokevirtual 443	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   744: pop
    //   745: aload 23
    //   747: aload_1
    //   748: getfield 282	com/tencent/mobileqq/emoticon/DownloadInfo:reqUrl	Ljava/lang/String;
    //   751: invokevirtual 443	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   754: pop
    //   755: ldc 68
    //   757: iconst_2
    //   758: aload 23
    //   760: invokevirtual 444	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   763: invokestatic 239	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   766: iconst_0
    //   767: istore 5
    //   769: goto +153 -> 922
    //   772: astore 23
    //   774: iconst_0
    //   775: istore 5
    //   777: aload 24
    //   779: astore 42
    //   781: goto +1030 -> 1811
    //   784: astore 23
    //   786: iconst_0
    //   787: istore 5
    //   789: aload 24
    //   791: astore 42
    //   793: goto +612 -> 1405
    //   796: bipush 8
    //   798: istore 6
    //   800: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   803: istore 18
    //   805: iload 18
    //   807: ifeq +89 -> 896
    //   810: new 436	java/lang/StringBuilder
    //   813: dup
    //   814: invokespecial 437	java/lang/StringBuilder:<init>	()V
    //   817: astore 23
    //   819: aload 23
    //   821: ldc_w 446
    //   824: invokevirtual 443	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   827: pop
    //   828: aload 23
    //   830: iload 5
    //   832: invokevirtual 449	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   835: pop
    //   836: aload 23
    //   838: ldc_w 451
    //   841: invokevirtual 443	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   844: pop
    //   845: aload 23
    //   847: lload 12
    //   849: invokevirtual 454	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   852: pop
    //   853: aload 23
    //   855: ldc_w 456
    //   858: invokevirtual 443	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   861: pop
    //   862: aload 23
    //   864: aload_1
    //   865: getfield 282	com/tencent/mobileqq/emoticon/DownloadInfo:reqUrl	Ljava/lang/String;
    //   868: invokevirtual 443	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   871: pop
    //   872: ldc 68
    //   874: iconst_2
    //   875: aload 23
    //   877: invokevirtual 444	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   880: invokestatic 239	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   883: goto +13 -> 896
    //   886: astore 23
    //   888: goto +348 -> 1236
    //   891: astore 23
    //   893: goto +356 -> 1249
    //   896: aload 19
    //   898: invokevirtual 364	java/io/File:exists	()Z
    //   901: istore 18
    //   903: iload 6
    //   905: istore 5
    //   907: iload 18
    //   909: ifeq +13 -> 922
    //   912: aload 19
    //   914: invokevirtual 367	java/io/File:delete	()Z
    //   917: pop
    //   918: iload 6
    //   920: istore 5
    //   922: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   925: istore 18
    //   927: iload 18
    //   929: ifeq +78 -> 1007
    //   932: new 436	java/lang/StringBuilder
    //   935: dup
    //   936: invokespecial 437	java/lang/StringBuilder:<init>	()V
    //   939: astore 23
    //   941: aload 23
    //   943: ldc_w 458
    //   946: invokevirtual 443	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   949: pop
    //   950: aload 23
    //   952: invokestatic 90	java/lang/System:currentTimeMillis	()J
    //   955: invokevirtual 454	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   958: pop
    //   959: aload 23
    //   961: ldc_w 460
    //   964: invokevirtual 443	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   967: pop
    //   968: aload 23
    //   970: aload_1
    //   971: getfield 282	com/tencent/mobileqq/emoticon/DownloadInfo:reqUrl	Ljava/lang/String;
    //   974: invokevirtual 443	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   977: pop
    //   978: ldc_w 461
    //   981: iconst_2
    //   982: aload 23
    //   984: invokevirtual 444	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   987: invokestatic 239	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   990: goto +17 -> 1007
    //   993: astore 23
    //   995: goto +223 -> 1218
    //   998: astore 23
    //   1000: aload 24
    //   1002: astore 42
    //   1004: goto +401 -> 1405
    //   1007: aload_1
    //   1008: aload_2
    //   1009: invokestatic 465	com/tencent/mobileqq/utils/HttpDownloadUtil:handleTags	(Lcom/tencent/mobileqq/emoticon/DownloadInfo;Landroid/net/NetworkInfo;)V
    //   1012: invokestatic 90	java/lang/System:currentTimeMillis	()J
    //   1015: lstore 16
    //   1017: aload 19
    //   1019: astore 32
    //   1021: aload 32
    //   1023: lload 16
    //   1025: invokevirtual 469	java/io/File:setLastModified	(J)Z
    //   1028: pop
    //   1029: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1032: ifeq +80 -> 1112
    //   1035: new 436	java/lang/StringBuilder
    //   1038: dup
    //   1039: invokespecial 437	java/lang/StringBuilder:<init>	()V
    //   1042: astore 23
    //   1044: aload 23
    //   1046: ldc_w 471
    //   1049: invokevirtual 443	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1052: pop
    //   1053: aload 23
    //   1055: invokestatic 90	java/lang/System:currentTimeMillis	()J
    //   1058: lload 14
    //   1060: lsub
    //   1061: invokevirtual 454	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1064: pop
    //   1065: aload 23
    //   1067: ldc_w 473
    //   1070: invokevirtual 443	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1073: pop
    //   1074: aload 23
    //   1076: lload 12
    //   1078: invokevirtual 454	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1081: pop
    //   1082: aload 23
    //   1084: ldc_w 475
    //   1087: invokevirtual 443	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1090: pop
    //   1091: aload 23
    //   1093: aload_1
    //   1094: getfield 282	com/tencent/mobileqq/emoticon/DownloadInfo:reqUrl	Ljava/lang/String;
    //   1097: invokevirtual 443	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1100: pop
    //   1101: ldc 68
    //   1103: iconst_2
    //   1104: aload 23
    //   1106: invokevirtual 444	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1109: invokestatic 478	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1112: aload 24
    //   1114: ifnull +62 -> 1176
    //   1117: aload 24
    //   1119: invokevirtual 481	java/io/InputStream:close	()V
    //   1122: goto +54 -> 1176
    //   1125: astore_1
    //   1126: aload_0
    //   1127: astore 19
    //   1129: aload_1
    //   1130: astore_0
    //   1131: goto +1603 -> 2734
    //   1134: astore 23
    //   1136: aload_0
    //   1137: astore 19
    //   1139: aload 23
    //   1141: astore_0
    //   1142: aload 22
    //   1144: astore 29
    //   1146: goto +1607 -> 2753
    //   1149: astore 19
    //   1151: aload 20
    //   1153: astore 23
    //   1155: aload 19
    //   1157: astore 20
    //   1159: aload_0
    //   1160: astore 19
    //   1162: aload 31
    //   1164: astore_0
    //   1165: iload 5
    //   1167: istore 6
    //   1169: aload 22
    //   1171: astore 28
    //   1173: goto +1170 -> 2343
    //   1176: iload 5
    //   1178: istore 10
    //   1180: iload 4
    //   1182: istore 5
    //   1184: aload_0
    //   1185: astore 23
    //   1187: aload 32
    //   1189: astore 39
    //   1191: aload 22
    //   1193: astore 40
    //   1195: aload 20
    //   1197: astore 24
    //   1199: aload 21
    //   1201: astore 41
    //   1203: goto +377 -> 1580
    //   1206: astore 23
    //   1208: goto +10 -> 1218
    //   1211: astore 23
    //   1213: goto +14 -> 1227
    //   1216: astore 23
    //   1218: aload 24
    //   1220: astore 42
    //   1222: goto +589 -> 1811
    //   1225: astore 23
    //   1227: aload 24
    //   1229: astore 42
    //   1231: goto +174 -> 1405
    //   1234: astore 23
    //   1236: bipush 8
    //   1238: istore 5
    //   1240: aload 24
    //   1242: astore 42
    //   1244: goto +567 -> 1811
    //   1247: astore 23
    //   1249: bipush 8
    //   1251: istore 5
    //   1253: aload 24
    //   1255: astore 42
    //   1257: goto +148 -> 1405
    //   1260: astore 19
    //   1262: aload 21
    //   1264: astore 25
    //   1266: aload 23
    //   1268: astore 26
    //   1270: aload 19
    //   1272: astore 23
    //   1274: aload 22
    //   1276: astore 19
    //   1278: aload 24
    //   1280: astore 21
    //   1282: aload 26
    //   1284: astore 24
    //   1286: goto +62 -> 1348
    //   1289: astore 25
    //   1291: aload 23
    //   1293: astore 26
    //   1295: aload 20
    //   1297: astore 19
    //   1299: aload 25
    //   1301: astore 23
    //   1303: aload 22
    //   1305: astore 25
    //   1307: aload 26
    //   1309: astore 20
    //   1311: goto +79 -> 1390
    //   1314: astore 23
    //   1316: goto +13 -> 1329
    //   1319: astore 23
    //   1321: goto +54 -> 1375
    //   1324: astore 23
    //   1326: aload 19
    //   1328: astore_0
    //   1329: aload 26
    //   1331: astore 24
    //   1333: aconst_null
    //   1334: astore 19
    //   1336: aload 21
    //   1338: astore 25
    //   1340: aload 19
    //   1342: astore 21
    //   1344: aload 22
    //   1346: astore 19
    //   1348: iconst_5
    //   1349: istore 5
    //   1351: aload 20
    //   1353: astore 22
    //   1355: aload 21
    //   1357: astore 42
    //   1359: aload 24
    //   1361: astore 20
    //   1363: aload 25
    //   1365: astore 21
    //   1367: goto +444 -> 1811
    //   1370: astore 23
    //   1372: aload 19
    //   1374: astore_0
    //   1375: aload 20
    //   1377: astore 19
    //   1379: aconst_null
    //   1380: astore 24
    //   1382: aload 26
    //   1384: astore 20
    //   1386: aload 22
    //   1388: astore 25
    //   1390: iconst_5
    //   1391: istore 5
    //   1393: aload 24
    //   1395: astore 42
    //   1397: aload 19
    //   1399: astore 22
    //   1401: aload 25
    //   1403: astore 19
    //   1405: aload_3
    //   1406: astore 30
    //   1408: aload 23
    //   1410: instanceof 483
    //   1413: ifne +39 -> 1452
    //   1416: aload 23
    //   1418: instanceof 485
    //   1421: ifeq +6 -> 1427
    //   1424: goto +28 -> 1452
    //   1427: aload 23
    //   1429: instanceof 487
    //   1432: istore 18
    //   1434: iload 18
    //   1436: ifeq +10 -> 1446
    //   1439: bipush 11
    //   1441: istore 9
    //   1443: goto +12 -> 1455
    //   1446: iconst_4
    //   1447: istore 9
    //   1449: goto +6 -> 1455
    //   1452: iconst_3
    //   1453: istore 9
    //   1455: iload 4
    //   1457: istore 5
    //   1459: aload_0
    //   1460: astore 23
    //   1462: aload 19
    //   1464: astore 39
    //   1466: iload 9
    //   1468: istore 10
    //   1470: aload 22
    //   1472: astore 40
    //   1474: aload 20
    //   1476: astore 24
    //   1478: aload 21
    //   1480: astore 41
    //   1482: aload 42
    //   1484: ifnull +96 -> 1580
    //   1487: aload_0
    //   1488: astore 36
    //   1490: aload 20
    //   1492: astore 33
    //   1494: iload 4
    //   1496: istore 7
    //   1498: aload_0
    //   1499: astore 37
    //   1501: aload 19
    //   1503: astore 34
    //   1505: aload 30
    //   1507: astore 31
    //   1509: aload 22
    //   1511: astore 29
    //   1513: aload 20
    //   1515: astore 27
    //   1517: aload 21
    //   1519: astore 25
    //   1521: iload 4
    //   1523: istore 8
    //   1525: aload_0
    //   1526: astore 35
    //   1528: aload 19
    //   1530: astore 32
    //   1532: iload 9
    //   1534: istore 6
    //   1536: aload 22
    //   1538: astore 28
    //   1540: aload 20
    //   1542: astore 38
    //   1544: aload 21
    //   1546: astore 26
    //   1548: aload 42
    //   1550: invokevirtual 481	java/io/InputStream:close	()V
    //   1553: aload 21
    //   1555: astore 41
    //   1557: aload 20
    //   1559: astore 24
    //   1561: aload 22
    //   1563: astore 40
    //   1565: iload 9
    //   1567: istore 10
    //   1569: aload 19
    //   1571: astore 39
    //   1573: aload_0
    //   1574: astore 23
    //   1576: iload 4
    //   1578: istore 5
    //   1580: aload_3
    //   1581: astore_0
    //   1582: iload 10
    //   1584: ifne +79 -> 1663
    //   1587: aload 23
    //   1589: astore 36
    //   1591: aload 24
    //   1593: astore 33
    //   1595: iload 5
    //   1597: istore 7
    //   1599: aload 23
    //   1601: astore 37
    //   1603: aload 39
    //   1605: astore 34
    //   1607: aload_0
    //   1608: astore 31
    //   1610: aload 40
    //   1612: astore 29
    //   1614: aload 24
    //   1616: astore 27
    //   1618: aload 41
    //   1620: astore 25
    //   1622: iload 5
    //   1624: istore 8
    //   1626: aload 23
    //   1628: astore 35
    //   1630: aload 39
    //   1632: astore 32
    //   1634: aload_0
    //   1635: astore 30
    //   1637: iload 10
    //   1639: istore 6
    //   1641: aload 40
    //   1643: astore 28
    //   1645: aload 24
    //   1647: astore 38
    //   1649: aload 41
    //   1651: astore 26
    //   1653: aload 39
    //   1655: aload_1
    //   1656: getfield 245	com/tencent/mobileqq/emoticon/DownloadInfo:file	Ljava/io/File;
    //   1659: invokevirtual 491	java/io/File:renameTo	(Ljava/io/File;)Z
    //   1662: pop
    //   1663: iload 5
    //   1665: istore 7
    //   1667: aload 23
    //   1669: astore 29
    //   1671: aload 39
    //   1673: astore 28
    //   1675: aload_0
    //   1676: astore 25
    //   1678: iload 10
    //   1680: istore 6
    //   1682: aload 40
    //   1684: astore 26
    //   1686: aload 24
    //   1688: astore 30
    //   1690: aload 41
    //   1692: astore 27
    //   1694: aload_0
    //   1695: ifnull +466 -> 2161
    //   1698: aload 23
    //   1700: astore 36
    //   1702: aload 24
    //   1704: astore 33
    //   1706: iload 5
    //   1708: istore 7
    //   1710: aload 23
    //   1712: astore 37
    //   1714: aload 39
    //   1716: astore 34
    //   1718: aload_0
    //   1719: astore 31
    //   1721: aload 40
    //   1723: astore 29
    //   1725: aload 24
    //   1727: astore 27
    //   1729: aload 41
    //   1731: astore 25
    //   1733: iload 5
    //   1735: istore 8
    //   1737: aload 23
    //   1739: astore 35
    //   1741: aload 39
    //   1743: astore 32
    //   1745: aload_0
    //   1746: astore 30
    //   1748: iload 10
    //   1750: istore 6
    //   1752: aload 40
    //   1754: astore 28
    //   1756: aload 24
    //   1758: astore 38
    //   1760: aload 41
    //   1762: astore 26
    //   1764: aload_0
    //   1765: aload 44
    //   1767: invokevirtual 396	java/net/URL:toString	()Ljava/lang/String;
    //   1770: iload 10
    //   1772: invokeinterface 494 3 0
    //   1777: iload 5
    //   1779: istore 7
    //   1781: aload 23
    //   1783: astore 29
    //   1785: aload 39
    //   1787: astore 28
    //   1789: aload_0
    //   1790: astore 25
    //   1792: iload 10
    //   1794: istore 6
    //   1796: aload 40
    //   1798: astore 26
    //   1800: aload 24
    //   1802: astore 30
    //   1804: aload 41
    //   1806: astore 27
    //   1808: goto +353 -> 2161
    //   1811: aload_3
    //   1812: astore 24
    //   1814: aload 42
    //   1816: ifnull +73 -> 1889
    //   1819: aload_0
    //   1820: astore 36
    //   1822: aload 20
    //   1824: astore 33
    //   1826: iload 4
    //   1828: istore 7
    //   1830: aload_0
    //   1831: astore 37
    //   1833: aload 19
    //   1835: astore 34
    //   1837: aload 24
    //   1839: astore 31
    //   1841: aload 22
    //   1843: astore 29
    //   1845: aload 20
    //   1847: astore 27
    //   1849: aload 21
    //   1851: astore 25
    //   1853: iload 4
    //   1855: istore 8
    //   1857: aload_0
    //   1858: astore 35
    //   1860: aload 19
    //   1862: astore 32
    //   1864: aload 24
    //   1866: astore 30
    //   1868: iload 5
    //   1870: istore 6
    //   1872: aload 22
    //   1874: astore 28
    //   1876: aload 20
    //   1878: astore 38
    //   1880: aload 21
    //   1882: astore 26
    //   1884: aload 42
    //   1886: invokevirtual 481	java/io/InputStream:close	()V
    //   1889: aload_0
    //   1890: astore 36
    //   1892: aload 20
    //   1894: astore 33
    //   1896: iload 4
    //   1898: istore 7
    //   1900: aload_0
    //   1901: astore 37
    //   1903: aload 19
    //   1905: astore 34
    //   1907: aload 24
    //   1909: astore 31
    //   1911: aload 22
    //   1913: astore 29
    //   1915: aload 20
    //   1917: astore 27
    //   1919: aload 21
    //   1921: astore 25
    //   1923: iload 4
    //   1925: istore 8
    //   1927: aload_0
    //   1928: astore 35
    //   1930: aload 19
    //   1932: astore 32
    //   1934: aload 24
    //   1936: astore 30
    //   1938: iload 5
    //   1940: istore 6
    //   1942: aload 22
    //   1944: astore 28
    //   1946: aload 20
    //   1948: astore 38
    //   1950: aload 21
    //   1952: astore 26
    //   1954: aload 23
    //   1956: athrow
    //   1957: iload 4
    //   1959: istore 7
    //   1961: aload 19
    //   1963: astore 29
    //   1965: aload 22
    //   1967: astore 28
    //   1969: aload_0
    //   1970: astore 25
    //   1972: iload 5
    //   1974: istore 6
    //   1976: aload 20
    //   1978: astore 26
    //   1980: aload 23
    //   1982: astore 30
    //   1984: aload 21
    //   1986: astore 27
    //   1988: aload_0
    //   1989: ifnull +172 -> 2161
    //   1992: aload 19
    //   1994: astore 36
    //   1996: aload 23
    //   1998: astore 33
    //   2000: iload 4
    //   2002: istore 7
    //   2004: aload 19
    //   2006: astore 37
    //   2008: aload 22
    //   2010: astore 34
    //   2012: aload_0
    //   2013: astore 31
    //   2015: aload 20
    //   2017: astore 29
    //   2019: aload 23
    //   2021: astore 27
    //   2023: aload 21
    //   2025: astore 25
    //   2027: iload 4
    //   2029: istore 8
    //   2031: aload 19
    //   2033: astore 35
    //   2035: aload 22
    //   2037: astore 32
    //   2039: aload_0
    //   2040: astore 30
    //   2042: iload 5
    //   2044: istore 6
    //   2046: aload 20
    //   2048: astore 28
    //   2050: aload 23
    //   2052: astore 38
    //   2054: aload 21
    //   2056: astore 26
    //   2058: aload_0
    //   2059: aload 44
    //   2061: invokevirtual 396	java/net/URL:toString	()Ljava/lang/String;
    //   2064: iload 5
    //   2066: invokeinterface 494 3 0
    //   2071: iload 4
    //   2073: istore 7
    //   2075: aload 19
    //   2077: astore 29
    //   2079: aload 22
    //   2081: astore 28
    //   2083: aload_0
    //   2084: astore 25
    //   2086: iload 5
    //   2088: istore 6
    //   2090: aload 20
    //   2092: astore 26
    //   2094: aload 23
    //   2096: astore 30
    //   2098: aload 21
    //   2100: astore 27
    //   2102: goto +59 -> 2161
    //   2105: astore_0
    //   2106: aload 36
    //   2108: astore 19
    //   2110: goto +620 -> 2730
    //   2113: astore_0
    //   2114: iload 7
    //   2116: istore 4
    //   2118: aload 37
    //   2120: astore 19
    //   2122: aload 34
    //   2124: astore 32
    //   2126: aload 27
    //   2128: astore 20
    //   2130: aload 25
    //   2132: astore 21
    //   2134: goto +619 -> 2753
    //   2137: astore 20
    //   2139: aload 38
    //   2141: astore 23
    //   2143: iload 8
    //   2145: istore 4
    //   2147: aload 35
    //   2149: astore 19
    //   2151: aload 30
    //   2153: astore_0
    //   2154: aload 26
    //   2156: astore 21
    //   2158: goto +185 -> 2343
    //   2161: aload 30
    //   2163: ifnull +18 -> 2181
    //   2166: aload 30
    //   2168: invokeinterface 497 1 0
    //   2173: goto +8 -> 2181
    //   2176: astore_0
    //   2177: aload_0
    //   2178: invokevirtual 500	java/io/IOException:printStackTrace	()V
    //   2181: aload 29
    //   2183: ifnull +8 -> 2191
    //   2186: aload 29
    //   2188: invokevirtual 501	java/io/OutputStream:close	()V
    //   2191: aload 30
    //   2193: astore 24
    //   2195: iload 7
    //   2197: istore 5
    //   2199: aload 29
    //   2201: astore 20
    //   2203: aload 28
    //   2205: astore 22
    //   2207: goto +254 -> 2461
    //   2210: astore_0
    //   2211: aload 25
    //   2213: astore 19
    //   2215: aload 24
    //   2217: astore 20
    //   2219: goto +390 -> 2609
    //   2222: astore 24
    //   2224: aload 20
    //   2226: astore 26
    //   2228: aload 24
    //   2230: astore 20
    //   2232: aload 19
    //   2234: astore 25
    //   2236: aload 23
    //   2238: astore 24
    //   2240: aload 20
    //   2242: invokevirtual 502	java/lang/Exception:printStackTrace	()V
    //   2245: aload_0
    //   2246: ifnull +23 -> 2269
    //   2249: aload 19
    //   2251: astore 25
    //   2253: aload 23
    //   2255: astore 24
    //   2257: aload_0
    //   2258: aload 44
    //   2260: invokevirtual 396	java/net/URL:toString	()Ljava/lang/String;
    //   2263: iconst_5
    //   2264: invokeinterface 494 3 0
    //   2269: aload 23
    //   2271: ifnull +20 -> 2291
    //   2274: aload 23
    //   2276: invokeinterface 497 1 0
    //   2281: goto +10 -> 2291
    //   2284: astore 20
    //   2286: aload 20
    //   2288: invokevirtual 500	java/io/IOException:printStackTrace	()V
    //   2291: aload 19
    //   2293: ifnull +8 -> 2301
    //   2296: aload 19
    //   2298: invokevirtual 501	java/io/OutputStream:close	()V
    //   2301: iconst_5
    //   2302: istore 6
    //   2304: iload 4
    //   2306: istore 5
    //   2308: aload 19
    //   2310: astore 20
    //   2312: aload 23
    //   2314: astore 24
    //   2316: aload_0
    //   2317: astore 25
    //   2319: aload 21
    //   2321: astore 27
    //   2323: goto +138 -> 2461
    //   2326: astore 24
    //   2328: iconst_5
    //   2329: istore 6
    //   2331: aload 20
    //   2333: astore 28
    //   2335: aload 22
    //   2337: astore 32
    //   2339: aload 24
    //   2341: astore 20
    //   2343: aload 19
    //   2345: astore 25
    //   2347: aload 23
    //   2349: astore 24
    //   2351: aload_1
    //   2352: aload_0
    //   2353: aload 44
    //   2355: iload 6
    //   2357: aload 20
    //   2359: invokestatic 506	com/tencent/mobileqq/utils/HttpDownloadUtil:handleIOException	(Lcom/tencent/mobileqq/emoticon/DownloadInfo;Lcom/tencent/mobileqq/utils/HttpDownloadUtil$HttpDownloadListener;Ljava/net/URL;ILjava/io/IOException;)I
    //   2362: istore 7
    //   2364: aload 23
    //   2366: ifnull +20 -> 2386
    //   2369: aload 23
    //   2371: invokeinterface 497 1 0
    //   2376: goto +10 -> 2386
    //   2379: astore 20
    //   2381: aload 20
    //   2383: invokevirtual 500	java/io/IOException:printStackTrace	()V
    //   2386: iload 4
    //   2388: istore 5
    //   2390: aload 19
    //   2392: astore 20
    //   2394: aload 32
    //   2396: astore 22
    //   2398: aload 23
    //   2400: astore 24
    //   2402: aload_0
    //   2403: astore 25
    //   2405: iload 7
    //   2407: istore 6
    //   2409: aload 28
    //   2411: astore 26
    //   2413: aload 21
    //   2415: astore 27
    //   2417: aload 19
    //   2419: ifnull +42 -> 2461
    //   2422: aload 19
    //   2424: invokevirtual 501	java/io/OutputStream:close	()V
    //   2427: iload 4
    //   2429: istore 5
    //   2431: aload 19
    //   2433: astore 20
    //   2435: aload 32
    //   2437: astore 22
    //   2439: aload 23
    //   2441: astore 24
    //   2443: aload_0
    //   2444: astore 25
    //   2446: iload 7
    //   2448: istore 6
    //   2450: aload 28
    //   2452: astore 26
    //   2454: aload 21
    //   2456: astore 27
    //   2458: goto +3 -> 2461
    //   2461: iload 11
    //   2463: iconst_1
    //   2464: iadd
    //   2465: istore 11
    //   2467: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2470: ifeq +56 -> 2526
    //   2473: new 436	java/lang/StringBuilder
    //   2476: dup
    //   2477: invokespecial 437	java/lang/StringBuilder:<init>	()V
    //   2480: astore_0
    //   2481: aload_0
    //   2482: ldc_w 508
    //   2485: invokevirtual 443	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2488: pop
    //   2489: aload_0
    //   2490: iload 6
    //   2492: invokevirtual 449	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2495: pop
    //   2496: aload_0
    //   2497: ldc_w 510
    //   2500: invokevirtual 443	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2503: pop
    //   2504: aload_0
    //   2505: aload_1
    //   2506: getfield 282	com/tencent/mobileqq/emoticon/DownloadInfo:reqUrl	Ljava/lang/String;
    //   2509: invokevirtual 443	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2512: pop
    //   2513: ldc 68
    //   2515: iconst_2
    //   2516: aload_0
    //   2517: invokevirtual 444	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2520: invokestatic 239	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2523: goto +3 -> 2526
    //   2526: iload 11
    //   2528: iconst_2
    //   2529: if_icmpge +37 -> 2566
    //   2532: iload 6
    //   2534: ifeq +32 -> 2566
    //   2537: aload 43
    //   2539: monitorenter
    //   2540: aload 43
    //   2542: ldc2_w 511
    //   2545: invokevirtual 516	java/lang/Object:wait	(J)V
    //   2548: goto +7 -> 2555
    //   2551: astore_0
    //   2552: goto +9 -> 2561
    //   2555: aload 43
    //   2557: monitorexit
    //   2558: goto +8 -> 2566
    //   2561: aload 43
    //   2563: monitorexit
    //   2564: aload_0
    //   2565: athrow
    //   2566: iload 6
    //   2568: ifeq +38 -> 2606
    //   2571: iload 11
    //   2573: iconst_2
    //   2574: if_icmplt +6 -> 2580
    //   2577: iload 6
    //   2579: ireturn
    //   2580: aload 27
    //   2582: astore 21
    //   2584: iload 5
    //   2586: istore 4
    //   2588: aload 20
    //   2590: astore 19
    //   2592: aload 24
    //   2594: astore 23
    //   2596: aload 25
    //   2598: astore_0
    //   2599: aload 26
    //   2601: astore 20
    //   2603: goto -2306 -> 297
    //   2606: iload 6
    //   2608: ireturn
    //   2609: aload 20
    //   2611: ifnull +18 -> 2629
    //   2614: aload 20
    //   2616: invokeinterface 497 1 0
    //   2621: goto +8 -> 2629
    //   2624: astore_1
    //   2625: aload_1
    //   2626: invokevirtual 500	java/io/IOException:printStackTrace	()V
    //   2629: aload 19
    //   2631: ifnull +8 -> 2639
    //   2634: aload 19
    //   2636: invokevirtual 501	java/io/OutputStream:close	()V
    //   2639: aload_0
    //   2640: athrow
    //   2641: bipush 13
    //   2643: ireturn
    //   2644: astore_0
    //   2645: aload_0
    //   2646: invokevirtual 517	java/net/MalformedURLException:printStackTrace	()V
    //   2649: aload_1
    //   2650: aload_0
    //   2651: invokestatic 520	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   2654: putfield 523	com/tencent/mobileqq/emoticon/DownloadInfo:errorDetail	Ljava/lang/String;
    //   2657: iconst_5
    //   2658: ireturn
    //   2659: astore_0
    //   2660: goto -2589 -> 71
    //   2663: astore_0
    //   2664: goto -23 -> 2641
    //   2667: astore_0
    //   2668: goto -477 -> 2191
    //   2671: astore 20
    //   2673: goto -372 -> 2301
    //   2676: astore 20
    //   2678: iload 4
    //   2680: istore 5
    //   2682: aload 19
    //   2684: astore 20
    //   2686: aload 32
    //   2688: astore 22
    //   2690: aload 23
    //   2692: astore 24
    //   2694: aload_0
    //   2695: astore 25
    //   2697: iload 7
    //   2699: istore 6
    //   2701: aload 28
    //   2703: astore 26
    //   2705: aload 21
    //   2707: astore 27
    //   2709: goto -248 -> 2461
    //   2712: astore_0
    //   2713: goto -158 -> 2555
    //   2716: astore_1
    //   2717: goto -78 -> 2639
    //   2720: astore 23
    //   2722: goto -911 -> 1811
    //   2725: astore_0
    //   2726: aload 23
    //   2728: astore 33
    //   2730: aload 33
    //   2732: astore 20
    //   2734: goto -125 -> 2609
    //   2737: astore_0
    //   2738: aload_3
    //   2739: astore 31
    //   2741: aload 20
    //   2743: astore 29
    //   2745: aload 23
    //   2747: astore 20
    //   2749: aload 22
    //   2751: astore 32
    //   2753: aload 20
    //   2755: astore 23
    //   2757: aload_0
    //   2758: astore 20
    //   2760: aload 32
    //   2762: astore 22
    //   2764: aload 31
    //   2766: astore_0
    //   2767: aload 29
    //   2769: astore 26
    //   2771: goto -539 -> 2232
    //   2774: astore 24
    //   2776: aload_3
    //   2777: astore_0
    //   2778: goto -450 -> 2328
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2781	0	paramAppRuntime	AppRuntime
    //   0	2781	1	paramDownloadInfo	DownloadInfo
    //   0	2781	2	paramNetworkInfo	NetworkInfo
    //   0	2781	3	paramHttpDownloadListener	HttpDownloadUtil.HttpDownloadListener
    //   138	2541	4	i	int
    //   415	2266	5	j	int
    //   452	2248	6	k	int
    //   1496	1202	7	m	int
    //   1523	621	8	n	int
    //   1441	125	9	i1	int
    //   1178	615	10	i2	int
    //   285	2290	11	i3	int
    //   501	576	12	l1	long
    //   28	1031	14	l2	long
    //   563	461	16	l3	long
    //   803	632	18	bool	boolean
    //   1	1137	19	localObject1	Object
    //   1149	7	19	localIOException1	IOException
    //   1160	1	19	localAppRuntime	AppRuntime
    //   1260	11	19	localObject2	Object
    //   1276	1407	19	localObject3	Object
    //   56	2073	20	localObject4	Object
    //   2137	1	20	localIOException2	IOException
    //   2201	40	20	localObject5	Object
    //   2284	3	20	localIOException3	IOException
    //   2310	48	20	localObject6	Object
    //   2379	3	20	localIOException4	IOException
    //   2392	223	20	localObject7	Object
    //   2671	1	20	localIOException5	IOException
    //   2676	1	20	localIOException6	IOException
    //   2684	75	20	localObject8	Object
    //   94	2612	21	localObject9	Object
    //   148	2615	22	localObject10	Object
    //   282	477	23	localObject11	Object
    //   772	1	23	localObject12	Object
    //   784	1	23	localIOException7	IOException
    //   817	59	23	localStringBuilder1	StringBuilder
    //   886	1	23	localObject13	Object
    //   891	1	23	localIOException8	IOException
    //   939	44	23	localStringBuilder2	StringBuilder
    //   993	1	23	localObject14	Object
    //   998	1	23	localIOException9	IOException
    //   1042	63	23	localStringBuilder3	StringBuilder
    //   1134	6	23	localException1	Exception
    //   1153	33	23	localObject15	Object
    //   1206	1	23	localObject16	Object
    //   1211	1	23	localIOException10	IOException
    //   1216	1	23	localObject17	Object
    //   1225	1	23	localIOException11	IOException
    //   1234	1	23	localObject18	Object
    //   1247	20	23	localIOException12	IOException
    //   1272	30	23	localObject19	Object
    //   1314	1	23	localObject20	Object
    //   1319	1	23	localIOException13	IOException
    //   1324	1	23	localObject21	Object
    //   1370	58	23	localIOException14	IOException
    //   1460	1231	23	localObject22	Object
    //   2720	26	23	localObject23	Object
    //   2755	1	23	localObject24	Object
    //   278	150	24	localObject25	Object
    //   445	10	24	localIOException15	IOException
    //   471	145	24	localObject26	Object
    //   629	1	24	localObject27	Object
    //   634	1	24	localIOException16	IOException
    //   639	1	24	localObject28	Object
    //   644	1	24	localIOException17	IOException
    //   652	19	24	localObject29	Object
    //   676	1	24	localObject30	Object
    //   681	7	24	localIOException18	IOException
    //   701	1515	24	localObject31	Object
    //   2222	7	24	localException2	Exception
    //   2238	77	24	localObject32	Object
    //   2326	14	24	localIOException19	IOException
    //   2349	344	24	localObject33	Object
    //   2774	1	24	localIOException20	IOException
    //   339	926	25	localObject34	Object
    //   1289	11	25	localIOException21	IOException
    //   1305	1391	25	localObject35	Object
    //   365	2405	26	localObject36	Object
    //   382	2326	27	localObject37	Object
    //   449	2253	28	localObject38	Object
    //   1144	1624	29	localObject39	Object
    //   1406	786	30	localObject40	Object
    //   711	2054	31	localObject41	Object
    //   460	2301	32	localObject42	Object
    //   1492	1239	33	localObject43	Object
    //   1503	620	34	localObject44	Object
    //   1526	622	35	localObject45	Object
    //   1488	619	36	localObject46	Object
    //   1499	620	37	localObject47	Object
    //   1542	598	38	localObject48	Object
    //   1189	597	39	localObject49	Object
    //   1193	604	40	localObject50	Object
    //   1201	604	41	localObject51	Object
    //   779	1106	42	localObject52	Object
    //   37	2525	43	localObject53	Object
    //   23	2331	44	localURL	URL
    // Exception table:
    //   from	to	target	type
    //   429	442	445	java/io/IOException
    //   614	626	629	finally
    //   614	626	634	java/io/IOException
    //   602	609	639	finally
    //   602	609	644	java/io/IOException
    //   573	591	652	finally
    //   573	591	681	java/io/IOException
    //   721	766	772	finally
    //   721	766	784	java/io/IOException
    //   810	883	886	finally
    //   912	918	886	finally
    //   810	883	891	java/io/IOException
    //   912	918	891	java/io/IOException
    //   932	990	993	finally
    //   932	990	998	java/io/IOException
    //   1117	1122	1125	finally
    //   1117	1122	1134	java/lang/Exception
    //   1117	1122	1149	java/io/IOException
    //   1021	1112	1206	finally
    //   1021	1112	1211	java/io/IOException
    //   922	927	1216	finally
    //   1007	1017	1216	finally
    //   922	927	1225	java/io/IOException
    //   1007	1017	1225	java/io/IOException
    //   800	805	1234	finally
    //   896	903	1234	finally
    //   800	805	1247	java/io/IOException
    //   896	903	1247	java/io/IOException
    //   535	541	1260	finally
    //   535	541	1289	java/io/IOException
    //   513	522	1314	finally
    //   513	522	1319	java/io/IOException
    //   503	513	1324	finally
    //   503	513	1370	java/io/IOException
    //   1548	1553	2105	finally
    //   1653	1663	2105	finally
    //   1764	1777	2105	finally
    //   1884	1889	2105	finally
    //   1954	1957	2105	finally
    //   2058	2071	2105	finally
    //   1548	1553	2113	java/lang/Exception
    //   1653	1663	2113	java/lang/Exception
    //   1764	1777	2113	java/lang/Exception
    //   1884	1889	2113	java/lang/Exception
    //   1954	1957	2113	java/lang/Exception
    //   2058	2071	2113	java/lang/Exception
    //   1548	1553	2137	java/io/IOException
    //   1653	1663	2137	java/io/IOException
    //   1764	1777	2137	java/io/IOException
    //   1884	1889	2137	java/io/IOException
    //   1954	1957	2137	java/io/IOException
    //   2058	2071	2137	java/io/IOException
    //   2166	2173	2176	java/io/IOException
    //   345	367	2210	finally
    //   375	384	2210	finally
    //   392	400	2210	finally
    //   408	417	2210	finally
    //   429	442	2210	finally
    //   473	482	2210	finally
    //   2240	2245	2210	finally
    //   2257	2269	2210	finally
    //   2351	2364	2210	finally
    //   345	367	2222	java/lang/Exception
    //   375	384	2222	java/lang/Exception
    //   392	400	2222	java/lang/Exception
    //   408	417	2222	java/lang/Exception
    //   429	442	2222	java/lang/Exception
    //   473	482	2222	java/lang/Exception
    //   2274	2281	2284	java/io/IOException
    //   345	367	2326	java/io/IOException
    //   375	384	2326	java/io/IOException
    //   392	400	2326	java/io/IOException
    //   408	417	2326	java/io/IOException
    //   473	482	2326	java/io/IOException
    //   2369	2376	2379	java/io/IOException
    //   2540	2548	2551	finally
    //   2555	2558	2551	finally
    //   2561	2564	2551	finally
    //   2614	2621	2624	java/io/IOException
    //   12	25	2644	java/net/MalformedURLException
    //   58	68	2659	java/lang/IllegalArgumentException
    //   71	84	2663	java/lang/IllegalArgumentException
    //   2186	2191	2667	java/io/IOException
    //   2296	2301	2671	java/io/IOException
    //   2422	2427	2676	java/io/IOException
    //   2540	2548	2712	java/lang/InterruptedException
    //   2634	2639	2716	java/io/IOException
    //   1408	1424	2720	finally
    //   1427	1434	2720	finally
    //   494	503	2725	finally
    //   494	503	2737	java/lang/Exception
    //   494	503	2774	java/io/IOException
  }
  
  public static int download(AppRuntime paramAppRuntime, URL paramURL, File paramFile, NetworkInfo paramNetworkInfo)
  {
    return download(paramAppRuntime, paramURL, paramFile, paramNetworkInfo, 2);
  }
  
  private static int download(AppRuntime paramAppRuntime, URL paramURL, File paramFile, NetworkInfo paramNetworkInfo, int paramInt)
  {
    long l = System.currentTimeMillis();
    Object localObject = new Object();
    if (paramFile == null) {
      return 5;
    }
    if (paramInt < 0) {
      paramInt = 2;
    }
    label133:
    try
    {
      paramAppRuntime = paramFile.getParentFile();
      if ((paramAppRuntime != null) && (!paramAppRuntime.exists())) {
        paramAppRuntime.mkdirs();
      }
      str = paramURL.toString();
    }
    catch (Exception paramAppRuntime)
    {
      String str;
      label71:
      label121:
      break label133;
    }
    try
    {
      paramAppRuntime = new HttpGet(str);
    }
    catch (IllegalArgumentException paramAppRuntime)
    {
      break label71;
    }
    try
    {
      paramAppRuntime = new HttpGet(getEscapeSequence(str));
      paramNetworkInfo = getHttpParams(paramNetworkInfo);
      paramAppRuntime.setParams(paramNetworkInfo);
      if (paramFile.exists()) {
        paramFile.delete();
      }
      return handleHttpRequest(paramURL, paramInt, l, localObject, null, paramAppRuntime, paramNetworkInfo, paramFile);
    }
    catch (IllegalArgumentException paramAppRuntime)
    {
      break label121;
    }
    QLog.d("HttpDownloadUtil", 1, "Download. result=DOWNLOAD_URL_STRING_ILLEGAL as new HttpGet exception.");
    return 13;
    QLog.d("HttpDownloadUtil", 1, "Download. result=DOWNLOAD_SAVE_FILE_FAIL as file exception.");
    return 4;
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
  
  @NotNull
  private static HttpParams getHttpParams(NetworkInfo paramNetworkInfo)
  {
    BasicHttpParams localBasicHttpParams = new BasicHttpParams();
    int k = 60000;
    int m = 20000;
    int j = k;
    int i = m;
    if (paramNetworkInfo != null)
    {
      String str1 = Proxy.getDefaultHost();
      i = Proxy.getDefaultPort();
      String str2 = paramNetworkInfo.getExtraInfo();
      if ((NetworkUtil.isMobileNetworkInfo(paramNetworkInfo)) && ((str2 == null) || (str2.endsWith("wap"))) && (str1 != null) && (i > 0)) {
        localBasicHttpParams.setParameter("http.route.default-proxy", new HttpHost(str1, i));
      }
      if (NetworkUtil.isMobileNetworkInfo(paramNetworkInfo))
      {
        localBasicHttpParams.setIntParameter("http.socket.buffer-size", 2048);
        j = k;
        i = m;
      }
      else
      {
        i = 10000;
        j = 30000;
        localBasicHttpParams.setIntParameter("http.socket.buffer-size", 4096);
      }
    }
    localBasicHttpParams.setParameter("http.connection.timeout", Integer.valueOf(i));
    localBasicHttpParams.setParameter("http.socket.timeout", Integer.valueOf(j));
    return localBasicHttpParams;
  }
  
  private static int getResultForIOException(URL paramURL, int paramInt, IOException paramIOException)
  {
    boolean bool = QLog.isColorLevel();
    paramInt = 2;
    if (bool)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Download fail 1. url=");
      localStringBuilder.append(paramURL);
      QLog.d("HttpDownloadUtil", 2, localStringBuilder.toString(), paramIOException);
    }
    if ((paramIOException instanceof UnknownHostException)) {
      return 10;
    }
    if (!(paramIOException instanceof ConnectTimeoutException))
    {
      if ((paramIOException instanceof SocketTimeoutException)) {
        return 2;
      }
      if ((paramIOException instanceof SocketException)) {
        return 11;
      }
      paramInt = 4;
    }
    return paramInt;
  }
  
  private static void handleAddHeaders(List<Header> paramList, String paramString)
  {
    if (paramList != null)
    {
      int j = paramList.size();
      int i = 0;
      while (i < j)
      {
        Header localHeader = (Header)paramList.get(i);
        if (localHeader.getName().equals("Host"))
        {
          paramList.remove(localHeader);
          break;
        }
        i += 1;
      }
      paramList.add(new BasicHeader("Host", new URL(paramString).getHost()));
    }
  }
  
  private static void handleFinally(int paramInt, OutputStream paramOutputStream, File paramFile, HttpEntity paramHttpEntity)
  {
    if (paramHttpEntity != null) {
      try
      {
        paramHttpEntity.consumeContent();
      }
      catch (IOException paramHttpEntity)
      {
        paramHttpEntity.printStackTrace();
      }
    }
    if (paramOutputStream != null) {}
    try
    {
      paramOutputStream.close();
    }
    catch (IOException paramOutputStream)
    {
      for (;;)
      {
        try
        {
          paramOutputStream = paramFile.getParentFile();
          if ((paramOutputStream != null) && (!paramOutputStream.exists())) {
            paramOutputStream.mkdirs();
          }
          if (paramFile.exists())
          {
            boolean bool = paramFile.delete();
            paramOutputStream = new StringBuilder();
            paramOutputStream.append("delete file in finally: ");
            paramOutputStream.append(bool);
            QLog.d("HttpDownloadUtil", 1, paramOutputStream.toString());
          }
          return;
        }
        catch (Exception paramOutputStream) {}
        paramOutputStream = paramOutputStream;
      }
    }
    if (paramInt != 0) {}
  }
  
  /* Error */
  private static int handleHttpRequest(URL paramURL, int paramInt, long paramLong, Object paramObject, OutputStream paramOutputStream, HttpGet paramHttpGet, HttpParams paramHttpParams, File paramFile)
  {
    // Byte code:
    //   0: aload 5
    //   2: astore 16
    //   4: aconst_null
    //   5: astore 5
    //   7: iconst_m1
    //   8: istore 11
    //   10: iload 11
    //   12: ifne +39 -> 51
    //   15: aload 7
    //   17: ldc_w 340
    //   20: new 342	org/apache/http/HttpHost
    //   23: dup
    //   24: aload_0
    //   25: invokevirtual 370	java/net/URL:getHost	()Ljava/lang/String;
    //   28: aload_0
    //   29: invokevirtual 373	java/net/URL:getPort	()I
    //   32: invokespecial 345	org/apache/http/HttpHost:<init>	(Ljava/lang/String;I)V
    //   35: invokeinterface 308 3 0
    //   40: pop
    //   41: aload 6
    //   43: aload 7
    //   45: invokevirtual 355	org/apache/http/client/methods/HttpGet:setParams	(Lorg/apache/http/params/HttpParams;)V
    //   48: goto +3 -> 51
    //   51: aload 16
    //   53: astore 20
    //   55: aload 5
    //   57: astore 24
    //   59: getstatic 197	com/tencent/mobileqq/utils/HttpDownloadUtil:CLIENT	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   62: astore 25
    //   64: aload 16
    //   66: astore 20
    //   68: aload 5
    //   70: astore 24
    //   72: new 342	org/apache/http/HttpHost
    //   75: dup
    //   76: aload_0
    //   77: invokevirtual 370	java/net/URL:getHost	()Ljava/lang/String;
    //   80: invokespecial 374	org/apache/http/HttpHost:<init>	(Ljava/lang/String;)V
    //   83: astore 26
    //   85: aload 16
    //   87: astore 18
    //   89: aload 5
    //   91: astore 21
    //   93: aload 16
    //   95: astore 19
    //   97: aload 5
    //   99: astore 22
    //   101: aload 16
    //   103: astore 17
    //   105: aload 5
    //   107: astore 23
    //   109: aload 16
    //   111: astore 20
    //   113: aload 5
    //   115: astore 24
    //   117: aload 25
    //   119: aload 26
    //   121: aload 6
    //   123: invokevirtual 378	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/HttpHost;Lorg/apache/http/HttpRequest;)Lorg/apache/http/HttpResponse;
    //   126: astore 25
    //   128: aload 16
    //   130: astore 18
    //   132: aload 5
    //   134: astore 21
    //   136: aload 16
    //   138: astore 19
    //   140: aload 5
    //   142: astore 22
    //   144: aload 16
    //   146: astore 17
    //   148: aload 5
    //   150: astore 23
    //   152: aload 16
    //   154: astore 20
    //   156: aload 5
    //   158: astore 24
    //   160: aload 25
    //   162: invokeinterface 384 1 0
    //   167: invokeinterface 393 1 0
    //   172: istore 9
    //   174: aload 16
    //   176: astore 18
    //   178: aload 5
    //   180: astore 21
    //   182: aload 16
    //   184: astore 19
    //   186: aload 5
    //   188: astore 22
    //   190: aload 16
    //   192: astore 17
    //   194: aload 5
    //   196: astore 23
    //   198: aload 16
    //   200: astore 20
    //   202: aload 5
    //   204: astore 24
    //   206: aload 25
    //   208: invokeinterface 405 1 0
    //   213: astore 5
    //   215: sipush 200
    //   218: iload 9
    //   220: if_icmpne +804 -> 1024
    //   223: aload 16
    //   225: astore 18
    //   227: aload 5
    //   229: astore 21
    //   231: aload 16
    //   233: astore 19
    //   235: aload 5
    //   237: astore 22
    //   239: aload 16
    //   241: astore 17
    //   243: aload 5
    //   245: astore 23
    //   247: aload 16
    //   249: astore 20
    //   251: aload 5
    //   253: astore 24
    //   255: aload 5
    //   257: invokeinterface 410 1 0
    //   262: lstore 14
    //   264: aload 16
    //   266: astore 18
    //   268: aload 5
    //   270: astore 21
    //   272: aload 16
    //   274: astore 19
    //   276: aload 5
    //   278: astore 22
    //   280: aload 16
    //   282: astore 20
    //   284: aload 5
    //   286: astore 24
    //   288: new 661	java/io/BufferedOutputStream
    //   291: dup
    //   292: new 412	java/io/FileOutputStream
    //   295: dup
    //   296: aload 8
    //   298: invokespecial 415	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   301: invokespecial 664	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   304: astore 17
    //   306: aload 5
    //   308: aload 17
    //   310: invokeinterface 667 2 0
    //   315: aload 17
    //   317: invokevirtual 670	java/io/OutputStream:flush	()V
    //   320: aload 8
    //   322: invokevirtual 673	java/io/File:length	()J
    //   325: lstore 12
    //   327: aload 17
    //   329: astore 16
    //   331: aload 8
    //   333: invokestatic 90	java/lang/System:currentTimeMillis	()J
    //   336: invokevirtual 469	java/io/File:setLastModified	(J)Z
    //   339: pop
    //   340: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   343: ifeq +76 -> 419
    //   346: new 436	java/lang/StringBuilder
    //   349: dup
    //   350: invokespecial 437	java/lang/StringBuilder:<init>	()V
    //   353: astore 18
    //   355: aload 18
    //   357: ldc_w 471
    //   360: invokevirtual 443	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   363: pop
    //   364: aload 18
    //   366: invokestatic 90	java/lang/System:currentTimeMillis	()J
    //   369: lload_2
    //   370: lsub
    //   371: invokevirtual 454	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   374: pop
    //   375: aload 18
    //   377: ldc_w 675
    //   380: invokevirtual 443	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   383: pop
    //   384: aload 18
    //   386: lload 12
    //   388: invokevirtual 454	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   391: pop
    //   392: aload 18
    //   394: ldc_w 475
    //   397: invokevirtual 443	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: pop
    //   401: aload 18
    //   403: aload_0
    //   404: invokevirtual 609	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   407: pop
    //   408: ldc 68
    //   410: iconst_2
    //   411: aload 18
    //   413: invokevirtual 444	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   416: invokestatic 478	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   419: iconst_0
    //   420: istore 9
    //   422: goto +423 -> 845
    //   425: astore_0
    //   426: goto +19 -> 445
    //   429: astore 16
    //   431: goto +23 -> 454
    //   434: astore 16
    //   436: goto +27 -> 463
    //   439: astore 16
    //   441: goto +34 -> 475
    //   444: astore_0
    //   445: aload 17
    //   447: astore 20
    //   449: goto +618 -> 1067
    //   452: astore 16
    //   454: aload 17
    //   456: astore 18
    //   458: goto +629 -> 1087
    //   461: astore 16
    //   463: aload 17
    //   465: astore 18
    //   467: goto +769 -> 1236
    //   470: astore 16
    //   472: lconst_0
    //   473: lstore 12
    //   475: aload 16
    //   477: astore 25
    //   479: aload 17
    //   481: astore 16
    //   483: goto +18 -> 501
    //   486: lconst_0
    //   487: lstore 12
    //   489: aload 17
    //   491: astore 16
    //   493: goto +94 -> 587
    //   496: astore 25
    //   498: lconst_0
    //   499: lstore 12
    //   501: aload 16
    //   503: astore 18
    //   505: aload 5
    //   507: astore 21
    //   509: aload 16
    //   511: astore 19
    //   513: aload 5
    //   515: astore 22
    //   517: aload 16
    //   519: astore 17
    //   521: aload 5
    //   523: astore 23
    //   525: aload 16
    //   527: astore 20
    //   529: aload 5
    //   531: astore 24
    //   533: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   536: ifeq +936 -> 1472
    //   539: aload 16
    //   541: astore 18
    //   543: aload 5
    //   545: astore 21
    //   547: aload 16
    //   549: astore 19
    //   551: aload 5
    //   553: astore 22
    //   555: aload 16
    //   557: astore 17
    //   559: aload 5
    //   561: astore 23
    //   563: aload 16
    //   565: astore 20
    //   567: aload 5
    //   569: astore 24
    //   571: ldc 68
    //   573: iconst_2
    //   574: aload 25
    //   576: invokevirtual 678	java/io/IOException:getMessage	()Ljava/lang/String;
    //   579: aload 25
    //   581: invokestatic 611	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   584: goto +888 -> 1472
    //   587: aload 16
    //   589: astore 18
    //   591: aload 5
    //   593: astore 21
    //   595: aload 16
    //   597: astore 19
    //   599: aload 5
    //   601: astore 22
    //   603: aload 16
    //   605: astore 17
    //   607: aload 5
    //   609: astore 23
    //   611: aload 16
    //   613: astore 20
    //   615: aload 5
    //   617: astore 24
    //   619: new 436	java/lang/StringBuilder
    //   622: dup
    //   623: invokespecial 437	java/lang/StringBuilder:<init>	()V
    //   626: astore 25
    //   628: aload 16
    //   630: astore 18
    //   632: aload 5
    //   634: astore 21
    //   636: aload 16
    //   638: astore 19
    //   640: aload 5
    //   642: astore 22
    //   644: aload 16
    //   646: astore 17
    //   648: aload 5
    //   650: astore 23
    //   652: aload 16
    //   654: astore 20
    //   656: aload 5
    //   658: astore 24
    //   660: aload 25
    //   662: ldc_w 680
    //   665: invokevirtual 443	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   668: pop
    //   669: aload 16
    //   671: astore 18
    //   673: aload 5
    //   675: astore 21
    //   677: aload 16
    //   679: astore 19
    //   681: aload 5
    //   683: astore 22
    //   685: aload 16
    //   687: astore 17
    //   689: aload 5
    //   691: astore 23
    //   693: aload 16
    //   695: astore 20
    //   697: aload 5
    //   699: astore 24
    //   701: aload 25
    //   703: aload 8
    //   705: invokevirtual 364	java/io/File:exists	()Z
    //   708: invokevirtual 655	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   711: pop
    //   712: aload 16
    //   714: astore 18
    //   716: aload 5
    //   718: astore 21
    //   720: aload 16
    //   722: astore 19
    //   724: aload 5
    //   726: astore 22
    //   728: aload 16
    //   730: astore 17
    //   732: aload 5
    //   734: astore 23
    //   736: aload 16
    //   738: astore 20
    //   740: aload 5
    //   742: astore 24
    //   744: aload 25
    //   746: ldc_w 682
    //   749: invokevirtual 443	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   752: pop
    //   753: aload 16
    //   755: astore 18
    //   757: aload 5
    //   759: astore 21
    //   761: aload 16
    //   763: astore 19
    //   765: aload 5
    //   767: astore 22
    //   769: aload 16
    //   771: astore 17
    //   773: aload 5
    //   775: astore 23
    //   777: aload 16
    //   779: astore 20
    //   781: aload 5
    //   783: astore 24
    //   785: aload 25
    //   787: aload 8
    //   789: invokevirtual 531	java/io/File:getParentFile	()Ljava/io/File;
    //   792: invokevirtual 364	java/io/File:exists	()Z
    //   795: invokevirtual 655	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   798: pop
    //   799: aload 16
    //   801: astore 18
    //   803: aload 5
    //   805: astore 21
    //   807: aload 16
    //   809: astore 19
    //   811: aload 5
    //   813: astore 22
    //   815: aload 16
    //   817: astore 17
    //   819: aload 5
    //   821: astore 23
    //   823: aload 16
    //   825: astore 20
    //   827: aload 5
    //   829: astore 24
    //   831: ldc 68
    //   833: iconst_1
    //   834: aload 25
    //   836: invokevirtual 444	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   839: invokestatic 239	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   842: iconst_5
    //   843: istore 9
    //   845: iload 9
    //   847: istore 10
    //   849: lload 14
    //   851: lconst_0
    //   852: lcmp
    //   853: ifle +164 -> 1017
    //   856: iload 9
    //   858: istore 10
    //   860: lload 12
    //   862: lload 14
    //   864: lcmp
    //   865: ifge +152 -> 1017
    //   868: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   871: ifeq +76 -> 947
    //   874: new 436	java/lang/StringBuilder
    //   877: dup
    //   878: invokespecial 437	java/lang/StringBuilder:<init>	()V
    //   881: astore 17
    //   883: aload 17
    //   885: ldc_w 684
    //   888: invokevirtual 443	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   891: pop
    //   892: aload 17
    //   894: lload 14
    //   896: invokevirtual 454	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   899: pop
    //   900: aload 17
    //   902: ldc_w 686
    //   905: invokevirtual 443	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   908: pop
    //   909: aload 17
    //   911: aload 8
    //   913: invokevirtual 673	java/io/File:length	()J
    //   916: invokevirtual 454	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   919: pop
    //   920: aload 17
    //   922: ldc_w 510
    //   925: invokevirtual 443	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   928: pop
    //   929: aload 17
    //   931: aload_0
    //   932: invokevirtual 609	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   935: pop
    //   936: ldc 68
    //   938: iconst_2
    //   939: aload 17
    //   941: invokevirtual 444	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   944: invokestatic 564	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   947: bipush 8
    //   949: istore 10
    //   951: goto +66 -> 1017
    //   954: astore_0
    //   955: aload 16
    //   957: astore 20
    //   959: aload 5
    //   961: astore 16
    //   963: goto +475 -> 1438
    //   966: astore 19
    //   968: aload 16
    //   970: astore 18
    //   972: aload 5
    //   974: astore 17
    //   976: iload 9
    //   978: istore 10
    //   980: goto +118 -> 1098
    //   983: astore 19
    //   985: aload 16
    //   987: astore 18
    //   989: aload 5
    //   991: astore 17
    //   993: iload 9
    //   995: istore 10
    //   997: goto +250 -> 1247
    //   1000: astore 19
    //   1002: aload 16
    //   1004: astore 17
    //   1006: aload 5
    //   1008: astore 18
    //   1010: iload 9
    //   1012: istore 10
    //   1014: goto +340 -> 1354
    //   1017: iload 10
    //   1019: istore 9
    //   1021: goto +367 -> 1388
    //   1024: goto +364 -> 1388
    //   1027: astore 16
    //   1029: aload 21
    //   1031: astore 5
    //   1033: goto +54 -> 1087
    //   1036: astore 16
    //   1038: aload 19
    //   1040: astore 18
    //   1042: aload 22
    //   1044: astore 5
    //   1046: goto +190 -> 1236
    //   1049: astore 18
    //   1051: aload 17
    //   1053: astore 16
    //   1055: aload 23
    //   1057: astore 5
    //   1059: goto +441 -> 1500
    //   1062: astore_0
    //   1063: aload 24
    //   1065: astore 5
    //   1067: iconst_5
    //   1068: istore 9
    //   1070: aload 5
    //   1072: astore 16
    //   1074: goto +364 -> 1438
    //   1077: astore 17
    //   1079: aload 16
    //   1081: astore 18
    //   1083: aload 17
    //   1085: astore 16
    //   1087: iconst_5
    //   1088: istore 10
    //   1090: aload 5
    //   1092: astore 17
    //   1094: aload 16
    //   1096: astore 19
    //   1098: aload 18
    //   1100: astore 5
    //   1102: aload 17
    //   1104: astore 16
    //   1106: iload 10
    //   1108: istore 9
    //   1110: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1113: ifeq +89 -> 1202
    //   1116: aload 18
    //   1118: astore 5
    //   1120: aload 17
    //   1122: astore 16
    //   1124: iload 10
    //   1126: istore 9
    //   1128: new 436	java/lang/StringBuilder
    //   1131: dup
    //   1132: invokespecial 437	java/lang/StringBuilder:<init>	()V
    //   1135: astore 20
    //   1137: aload 18
    //   1139: astore 5
    //   1141: aload 17
    //   1143: astore 16
    //   1145: iload 10
    //   1147: istore 9
    //   1149: aload 20
    //   1151: ldc_w 688
    //   1154: invokevirtual 443	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1157: pop
    //   1158: aload 18
    //   1160: astore 5
    //   1162: aload 17
    //   1164: astore 16
    //   1166: iload 10
    //   1168: istore 9
    //   1170: aload 20
    //   1172: aload_0
    //   1173: invokevirtual 609	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1176: pop
    //   1177: aload 18
    //   1179: astore 5
    //   1181: aload 17
    //   1183: astore 16
    //   1185: iload 10
    //   1187: istore 9
    //   1189: ldc 68
    //   1191: iconst_2
    //   1192: aload 20
    //   1194: invokevirtual 444	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1197: aload 19
    //   1199: invokestatic 611	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1202: iconst_5
    //   1203: aload 18
    //   1205: aload 8
    //   1207: aload 17
    //   1209: invokestatic 690	com/tencent/mobileqq/utils/HttpDownloadUtil:handleFinally	(ILjava/io/OutputStream;Ljava/io/File;Lorg/apache/http/HttpEntity;)V
    //   1212: iconst_5
    //   1213: istore 9
    //   1215: aload 18
    //   1217: astore 16
    //   1219: aload 17
    //   1221: astore 5
    //   1223: goto +176 -> 1399
    //   1226: astore 17
    //   1228: aload 16
    //   1230: astore 18
    //   1232: aload 17
    //   1234: astore 16
    //   1236: iconst_5
    //   1237: istore 10
    //   1239: aload 5
    //   1241: astore 17
    //   1243: aload 16
    //   1245: astore 19
    //   1247: aload 18
    //   1249: astore 5
    //   1251: aload 17
    //   1253: astore 16
    //   1255: iload 10
    //   1257: istore 9
    //   1259: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1262: ifeq +222 -> 1484
    //   1265: aload 18
    //   1267: astore 5
    //   1269: aload 17
    //   1271: astore 16
    //   1273: iload 10
    //   1275: istore 9
    //   1277: new 436	java/lang/StringBuilder
    //   1280: dup
    //   1281: invokespecial 437	java/lang/StringBuilder:<init>	()V
    //   1284: astore 20
    //   1286: aload 18
    //   1288: astore 5
    //   1290: aload 17
    //   1292: astore 16
    //   1294: iload 10
    //   1296: istore 9
    //   1298: aload 20
    //   1300: ldc_w 688
    //   1303: invokevirtual 443	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1306: pop
    //   1307: aload 18
    //   1309: astore 5
    //   1311: aload 17
    //   1313: astore 16
    //   1315: iload 10
    //   1317: istore 9
    //   1319: aload 20
    //   1321: aload_0
    //   1322: invokevirtual 609	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1325: pop
    //   1326: aload 18
    //   1328: astore 5
    //   1330: aload 17
    //   1332: astore 16
    //   1334: iload 10
    //   1336: istore 9
    //   1338: ldc 68
    //   1340: iconst_2
    //   1341: aload 20
    //   1343: invokevirtual 444	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1346: aload 19
    //   1348: invokestatic 611	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1351: goto +133 -> 1484
    //   1354: aload 17
    //   1356: astore 5
    //   1358: aload 18
    //   1360: astore 16
    //   1362: iload 10
    //   1364: istore 9
    //   1366: aload_0
    //   1367: iload 10
    //   1369: aload 19
    //   1371: invokestatic 692	com/tencent/mobileqq/utils/HttpDownloadUtil:getResultForIOException	(Ljava/net/URL;ILjava/io/IOException;)I
    //   1374: istore 10
    //   1376: iload 10
    //   1378: istore 9
    //   1380: aload 18
    //   1382: astore 5
    //   1384: aload 17
    //   1386: astore 16
    //   1388: iload 9
    //   1390: aload 16
    //   1392: aload 8
    //   1394: aload 5
    //   1396: invokestatic 690	com/tencent/mobileqq/utils/HttpDownloadUtil:handleFinally	(ILjava/io/OutputStream;Ljava/io/File;Lorg/apache/http/HttpEntity;)V
    //   1399: iload 11
    //   1401: iconst_1
    //   1402: iadd
    //   1403: istore 10
    //   1405: aload_0
    //   1406: aload 4
    //   1408: iload 9
    //   1410: iload 10
    //   1412: invokestatic 696	com/tencent/mobileqq/utils/HttpDownloadUtil:waitBeforeRetry	(Ljava/net/URL;Ljava/lang/Object;II)V
    //   1415: iload 9
    //   1417: ifeq +13 -> 1430
    //   1420: iload 10
    //   1422: istore 11
    //   1424: iload 10
    //   1426: iload_1
    //   1427: if_icmplt -1417 -> 10
    //   1430: iload 9
    //   1432: ireturn
    //   1433: astore_0
    //   1434: aload 5
    //   1436: astore 20
    //   1438: iload 9
    //   1440: aload 20
    //   1442: aload 8
    //   1444: aload 16
    //   1446: invokestatic 690	com/tencent/mobileqq/utils/HttpDownloadUtil:handleFinally	(ILjava/io/OutputStream;Ljava/io/File;Lorg/apache/http/HttpEntity;)V
    //   1449: goto +5 -> 1454
    //   1452: aload_0
    //   1453: athrow
    //   1454: goto -2 -> 1452
    //   1457: astore 17
    //   1459: goto +19 -> 1478
    //   1462: astore 16
    //   1464: goto -978 -> 486
    //   1467: astore 16
    //   1469: goto -980 -> 489
    //   1472: iconst_4
    //   1473: istore 9
    //   1475: goto -630 -> 845
    //   1478: lconst_0
    //   1479: lstore 12
    //   1481: goto -894 -> 587
    //   1484: iconst_5
    //   1485: istore 9
    //   1487: aload 18
    //   1489: astore 16
    //   1491: aload 17
    //   1493: astore 5
    //   1495: goto -107 -> 1388
    //   1498: astore 18
    //   1500: iconst_5
    //   1501: istore 10
    //   1503: aload 18
    //   1505: astore 19
    //   1507: aload 16
    //   1509: astore 17
    //   1511: aload 5
    //   1513: astore 18
    //   1515: goto -161 -> 1354
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1518	0	paramURL	URL
    //   0	1518	1	paramInt	int
    //   0	1518	2	paramLong	long
    //   0	1518	4	paramObject	Object
    //   0	1518	5	paramOutputStream	OutputStream
    //   0	1518	6	paramHttpGet	HttpGet
    //   0	1518	7	paramHttpParams	HttpParams
    //   0	1518	8	paramFile	File
    //   172	1314	9	i	int
    //   847	655	10	j	int
    //   8	1415	11	k	int
    //   325	1155	12	l1	long
    //   262	633	14	l2	long
    //   2	328	16	localObject1	Object
    //   429	1	16	localThrowable1	java.lang.Throwable
    //   434	1	16	localException1	Exception
    //   439	1	16	localIOException1	IOException
    //   452	1	16	localThrowable2	java.lang.Throwable
    //   461	1	16	localException2	Exception
    //   470	6	16	localIOException2	IOException
    //   481	522	16	localObject2	Object
    //   1027	1	16	localThrowable3	java.lang.Throwable
    //   1036	1	16	localException3	Exception
    //   1053	392	16	localObject3	Object
    //   1462	1	16	localFileNotFoundException1	java.io.FileNotFoundException
    //   1467	1	16	localFileNotFoundException2	java.io.FileNotFoundException
    //   1489	19	16	localObject4	Object
    //   103	949	17	localObject5	Object
    //   1077	7	17	localThrowable4	java.lang.Throwable
    //   1092	128	17	localOutputStream1	OutputStream
    //   1226	7	17	localException4	Exception
    //   1241	144	17	localOutputStream2	OutputStream
    //   1457	35	17	localFileNotFoundException3	java.io.FileNotFoundException
    //   1509	1	17	localObject6	Object
    //   87	954	18	localObject7	Object
    //   1049	1	18	localIOException3	IOException
    //   1081	407	18	localObject8	Object
    //   1498	6	18	localIOException4	IOException
    //   1513	1	18	localOutputStream3	OutputStream
    //   95	715	19	localObject9	Object
    //   966	1	19	localThrowable5	java.lang.Throwable
    //   983	1	19	localException5	Exception
    //   1000	39	19	localIOException5	IOException
    //   1096	410	19	localObject10	Object
    //   53	1388	20	localObject11	Object
    //   91	939	21	localOutputStream4	OutputStream
    //   99	944	22	localOutputStream5	OutputStream
    //   107	949	23	localOutputStream6	OutputStream
    //   57	1007	24	localOutputStream7	OutputStream
    //   62	416	25	localObject12	Object
    //   496	84	25	localIOException6	IOException
    //   626	209	25	localStringBuilder	StringBuilder
    //   83	37	26	localHttpHost	HttpHost
    // Exception table:
    //   from	to	target	type
    //   331	419	425	finally
    //   331	419	429	java/lang/Throwable
    //   331	419	434	java/lang/Exception
    //   331	419	439	java/io/IOException
    //   306	327	444	finally
    //   306	327	452	java/lang/Throwable
    //   306	327	461	java/lang/Exception
    //   306	327	470	java/io/IOException
    //   288	306	496	java/io/IOException
    //   868	947	954	finally
    //   868	947	966	java/lang/Throwable
    //   868	947	983	java/lang/Exception
    //   868	947	1000	java/io/IOException
    //   117	128	1027	java/lang/Throwable
    //   160	174	1027	java/lang/Throwable
    //   206	215	1027	java/lang/Throwable
    //   255	264	1027	java/lang/Throwable
    //   288	306	1027	java/lang/Throwable
    //   533	539	1027	java/lang/Throwable
    //   571	584	1027	java/lang/Throwable
    //   619	628	1027	java/lang/Throwable
    //   660	669	1027	java/lang/Throwable
    //   701	712	1027	java/lang/Throwable
    //   744	753	1027	java/lang/Throwable
    //   785	799	1027	java/lang/Throwable
    //   831	842	1027	java/lang/Throwable
    //   117	128	1036	java/lang/Exception
    //   160	174	1036	java/lang/Exception
    //   206	215	1036	java/lang/Exception
    //   255	264	1036	java/lang/Exception
    //   288	306	1036	java/lang/Exception
    //   533	539	1036	java/lang/Exception
    //   571	584	1036	java/lang/Exception
    //   619	628	1036	java/lang/Exception
    //   660	669	1036	java/lang/Exception
    //   701	712	1036	java/lang/Exception
    //   744	753	1036	java/lang/Exception
    //   785	799	1036	java/lang/Exception
    //   831	842	1036	java/lang/Exception
    //   117	128	1049	java/io/IOException
    //   160	174	1049	java/io/IOException
    //   206	215	1049	java/io/IOException
    //   255	264	1049	java/io/IOException
    //   533	539	1049	java/io/IOException
    //   571	584	1049	java/io/IOException
    //   619	628	1049	java/io/IOException
    //   660	669	1049	java/io/IOException
    //   701	712	1049	java/io/IOException
    //   744	753	1049	java/io/IOException
    //   785	799	1049	java/io/IOException
    //   831	842	1049	java/io/IOException
    //   59	64	1062	finally
    //   72	85	1062	finally
    //   117	128	1062	finally
    //   160	174	1062	finally
    //   206	215	1062	finally
    //   255	264	1062	finally
    //   288	306	1062	finally
    //   533	539	1062	finally
    //   571	584	1062	finally
    //   619	628	1062	finally
    //   660	669	1062	finally
    //   701	712	1062	finally
    //   744	753	1062	finally
    //   785	799	1062	finally
    //   831	842	1062	finally
    //   59	64	1077	java/lang/Throwable
    //   72	85	1077	java/lang/Throwable
    //   59	64	1226	java/lang/Exception
    //   72	85	1226	java/lang/Exception
    //   1110	1116	1433	finally
    //   1128	1137	1433	finally
    //   1149	1158	1433	finally
    //   1170	1177	1433	finally
    //   1189	1202	1433	finally
    //   1259	1265	1433	finally
    //   1277	1286	1433	finally
    //   1298	1307	1433	finally
    //   1319	1326	1433	finally
    //   1338	1351	1433	finally
    //   1366	1376	1433	finally
    //   288	306	1457	java/io/FileNotFoundException
    //   306	327	1462	java/io/FileNotFoundException
    //   331	419	1467	java/io/FileNotFoundException
    //   59	64	1498	java/io/IOException
    //   72	85	1498	java/io/IOException
  }
  
  private static int handleIOException(DownloadInfo paramDownloadInfo, HttpDownloadUtil.HttpDownloadListener paramHttpDownloadListener, URL paramURL, int paramInt, IOException paramIOException)
  {
    paramIOException.printStackTrace();
    if ((paramIOException instanceof UnknownHostException)) {
      paramInt = 10;
    } else if ((!(paramIOException instanceof ConnectTimeoutException)) && (!(paramIOException instanceof SocketTimeoutException)))
    {
      if ((paramIOException instanceof SocketException)) {
        paramDownloadInfo.resultCode = 11;
      } else {
        paramInt = 4;
      }
    }
    else {
      paramInt = 2;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Download fail resultCode=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(". url=");
    localStringBuilder.append(paramDownloadInfo.reqUrl);
    localStringBuilder.append(" exception:");
    localStringBuilder.append(paramIOException.getMessage());
    QLog.w("HttpDownloadUtil", 2, localStringBuilder.toString());
    if (paramHttpDownloadListener != null) {
      paramHttpDownloadListener.b(paramURL.toString(), paramInt);
    }
    return paramInt;
  }
  
  private static int handleQueryDownloadInfoException(int paramInt1, DownloadInfo paramDownloadInfo, int paramInt2, IOException paramIOException)
  {
    if (QLog.isColorLevel()) {
      paramIOException.printStackTrace();
    }
    int i = 5;
    if ((paramIOException instanceof UnknownHostException)) {}
    for (paramInt2 = 10;; paramInt2 = 13)
    {
      i = paramInt1;
      paramInt1 = paramInt2;
      paramInt2 = i;
      break label90;
      if (((paramIOException instanceof ConnectTimeoutException)) || ((paramIOException instanceof SocketTimeoutException))) {
        break label88;
      }
      if ((paramIOException instanceof SocketException))
      {
        paramDownloadInfo.resultCode = 11;
        paramInt1 = i;
        break label90;
      }
      if (!(paramIOException instanceof MalformedURLException)) {
        break;
      }
    }
    paramInt1 = 4;
    break label90;
    label88:
    paramInt1 = 2;
    label90:
    paramDownloadInfo.resultCode = paramInt1;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("queryDownloadInfo fail resultCode=");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" http code: ");
      localStringBuilder.append(paramDownloadInfo.httpRespCode);
      localStringBuilder.append(". url=");
      localStringBuilder.append(paramDownloadInfo.reqUrl);
      localStringBuilder.append(" IOexception:");
      localStringBuilder.append(paramIOException.toString());
      QLog.w("HttpDownloadUtil", 2, localStringBuilder.toString());
    }
    return paramInt2;
  }
  
  private static boolean handleResp200(HttpDownloadUtil.DownloadInfoListener paramDownloadInfoListener, DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfoListener != null)
    {
      paramDownloadInfo.resultCode = 0;
      if (paramDownloadInfoListener.onRespDownloadInfo(paramDownloadInfo))
      {
        paramDownloadInfo.resultCode = 0;
        return true;
      }
      paramDownloadInfo.resultCode = 4;
      return false;
    }
    paramDownloadInfo.resultCode = 0;
    return true;
  }
  
  private static void handleTags(DownloadInfo paramDownloadInfo, NetworkInfo paramNetworkInfo)
  {
    if (paramDownloadInfo.action != 10001)
    {
      if (NetworkUtil.isMobileNetworkInfo(paramNetworkInfo)) {
        return;
      }
      return;
    }
    if (NetworkUtil.isMobileNetworkInfo(paramNetworkInfo)) {}
  }
  
  private static boolean makeParentDirsFailed(DownloadInfo paramDownloadInfo, HttpDownloadUtil.HttpDownloadListener paramHttpDownloadListener, URL paramURL)
  {
    try
    {
      Object localObject = paramDownloadInfo.file.getParentFile();
      if ((localObject != null) && (!((File)localObject).exists()) && (!((File)localObject).mkdirs()))
      {
        if (paramHttpDownloadListener != null) {
          paramHttpDownloadListener.b(paramURL.toString(), 4);
        }
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("save file fail,info.url=");
          ((StringBuilder)localObject).append(paramDownloadInfo.reqUrl);
          QLog.d("HttpDownloadUtil", 2, ((StringBuilder)localObject).toString());
        }
        return true;
      }
      return false;
    }
    catch (Exception localException)
    {
      label86:
      break label86;
    }
    if (paramHttpDownloadListener != null) {
      paramHttpDownloadListener.b(paramURL.toString(), 4);
    }
    if (QLog.isColorLevel())
    {
      paramHttpDownloadListener = new StringBuilder();
      paramHttpDownloadListener.append("save file fail,info.url=");
      paramHttpDownloadListener.append(paramDownloadInfo.reqUrl);
      QLog.d("HttpDownloadUtil", 2, paramHttpDownloadListener.toString());
    }
    return true;
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
  
  private static DownloadInfo queryDownloadInfo(String paramString, HttpDownloadUtil.DownloadInfoListener paramDownloadInfoListener, List<Header> paramList, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, int paramInt4)
  {
    localDownloadInfo = new DownloadInfo(paramString, null, 0);
    if (paramInt2 >= 3)
    {
      if (QLog.isColorLevel()) {
        QLog.w("HttpDownloadUtil", 2, "download redirect times beyond.");
      }
      localDownloadInfo.resultCode = 20;
      return localDownloadInfo;
    }
    for (;;)
    {
      try
      {
        new URL(localDownloadInfo.reqUrl);
        str = localDownloadInfo.reqUrl;
      }
      catch (MalformedURLException paramString)
      {
        String str;
        if (QLog.isColorLevel()) {
          QLog.w("HttpDownloadUtil", 2, paramString.toString());
        }
        localDownloadInfo.errorDetail = String.valueOf(paramString);
        localDownloadInfo.resultCode = 13;
        if (paramDownloadInfoListener != null) {
          paramDownloadInfoListener.onRespDownloadInfo(localDownloadInfo);
        }
        return localDownloadInfo;
      }
      try
      {
        new HttpGet(str);
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        continue;
      }
      try
      {
        new HttpGet(getEscapeSequence(str));
        str = getEscapeSequence(str);
      }
      catch (IllegalArgumentException paramString)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w("HttpDownloadUtil", 2, paramString.toString());
        localDownloadInfo.resultCode = 13;
        if (paramDownloadInfoListener == null) {
          continue;
        }
        paramDownloadInfoListener.onRespDownloadInfo(localDownloadInfo);
        return localDownloadInfo;
      }
    }
    return startQueryDownloadInfo(paramString, paramDownloadInfoListener, paramList, paramInt1, paramBoolean, paramInt2, paramInt3, paramInt4, localDownloadInfo, str, new Object(), 5000L, null, 0);
  }
  
  public static boolean shutdownSniSupport()
  {
    if (!sShutdownSniSupportInited)
    {
      sShutdownSniSupportInited = true;
      try
      {
        Object localObject = UtilApi.b.a();
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
  
  /* Error */
  @NotNull
  private static DownloadInfo startQueryDownloadInfo(String paramString1, HttpDownloadUtil.DownloadInfoListener paramDownloadInfoListener, List<Header> paramList, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, int paramInt4, DownloadInfo paramDownloadInfo, String paramString2, Object paramObject, long paramLong, HttpURLConnection paramHttpURLConnection, int paramInt5)
  {
    // Byte code:
    //   0: aload_2
    //   1: astore 24
    //   3: invokestatic 558	com/tencent/mobileqq/msf/sdk/AppNetConnInfo:getRecentNetworkInfo	()Landroid/net/NetworkInfo;
    //   6: astore 25
    //   8: aload 25
    //   10: ifnonnull +88 -> 98
    //   13: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   16: ifeq +12 -> 28
    //   19: ldc 68
    //   21: iconst_2
    //   22: ldc_w 793
    //   25: invokestatic 564	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   28: aload 8
    //   30: iconst_1
    //   31: putfield 574	com/tencent/mobileqq/emoticon/DownloadInfo:resultCode	I
    //   34: iload 14
    //   36: iconst_1
    //   37: iadd
    //   38: istore 14
    //   40: iload 14
    //   42: iload_3
    //   43: if_icmplt +19 -> 62
    //   46: aload_1
    //   47: ifnull +12 -> 59
    //   50: aload_1
    //   51: aload 8
    //   53: invokeinterface 721 2 0
    //   58: pop
    //   59: aload 8
    //   61: areturn
    //   62: aload 10
    //   64: monitorenter
    //   65: aload 10
    //   67: lload 11
    //   69: invokevirtual 516	java/lang/Object:wait	(J)V
    //   72: lload 11
    //   74: ldc2_w 794
    //   77: lmul
    //   78: lstore 11
    //   80: goto +7 -> 87
    //   83: astore_0
    //   84: goto +9 -> 93
    //   87: aload 10
    //   89: monitorexit
    //   90: goto +1919 -> 2009
    //   93: aload 10
    //   95: monitorexit
    //   96: aload_0
    //   97: athrow
    //   98: aload 25
    //   100: ifnull +1949 -> 2049
    //   103: aload 13
    //   105: astore 20
    //   107: aload 13
    //   109: astore 21
    //   111: aload 13
    //   113: astore 22
    //   115: aload 25
    //   117: invokevirtual 324	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   120: astore 23
    //   122: aload 13
    //   124: astore 20
    //   126: aload 13
    //   128: astore 21
    //   130: aload 13
    //   132: astore 22
    //   134: aload 25
    //   136: invokevirtual 798	android/net/NetworkInfo:getType	()I
    //   139: istore 15
    //   141: goto +3 -> 144
    //   144: aload 13
    //   146: astore 20
    //   148: aload 13
    //   150: astore 21
    //   152: aload 13
    //   154: astore 22
    //   156: invokestatic 315	android/net/Proxy:getDefaultHost	()Ljava/lang/String;
    //   159: astore 25
    //   161: aload 13
    //   163: astore 20
    //   165: aload 13
    //   167: astore 21
    //   169: aload 13
    //   171: astore 22
    //   173: invokestatic 319	android/net/Proxy:getDefaultPort	()I
    //   176: istore 16
    //   178: aload 13
    //   180: astore 20
    //   182: aload 13
    //   184: astore 21
    //   186: aload 13
    //   188: astore 22
    //   190: aload 23
    //   192: invokestatic 803	com/tencent/mobileqq/utils/httputils/PkgTools:getApnType	(Ljava/lang/String;)Ljava/lang/String;
    //   195: astore 23
    //   197: aload 13
    //   199: astore 20
    //   201: aload 13
    //   203: astore 21
    //   205: aload 13
    //   207: astore 22
    //   209: aload 23
    //   211: getstatic 221	com/tencent/mobileqq/utils/HttpDownloadUtil:lastApn	Ljava/lang/String;
    //   214: invokevirtual 635	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   217: ifne +87 -> 304
    //   220: aload 13
    //   222: astore 20
    //   224: aload 13
    //   226: astore 21
    //   228: aload 13
    //   230: astore 22
    //   232: aload 23
    //   234: putstatic 221	com/tencent/mobileqq/utils/HttpDownloadUtil:lastApn	Ljava/lang/String;
    //   237: iload 15
    //   239: iconst_1
    //   240: if_icmpeq +48 -> 288
    //   243: aload 13
    //   245: astore 20
    //   247: aload 13
    //   249: astore 21
    //   251: aload 13
    //   253: astore 22
    //   255: aload 23
    //   257: getstatic 806	com/tencent/mobileqq/utils/httputils/PkgTools:APN_TYPE_CMWAP	Ljava/lang/String;
    //   260: invokevirtual 635	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   263: ifeq +6 -> 269
    //   266: goto +22 -> 288
    //   269: aload 13
    //   271: astore 20
    //   273: aload 13
    //   275: astore 21
    //   277: aload 13
    //   279: astore 22
    //   281: iconst_1
    //   282: putstatic 223	com/tencent/mobileqq/utils/HttpDownloadUtil:forceDirect	Z
    //   285: goto +19 -> 304
    //   288: aload 13
    //   290: astore 20
    //   292: aload 13
    //   294: astore 21
    //   296: aload 13
    //   298: astore 22
    //   300: iconst_0
    //   301: putstatic 223	com/tencent/mobileqq/utils/HttpDownloadUtil:forceDirect	Z
    //   304: iload 15
    //   306: iconst_1
    //   307: if_icmpne +65 -> 372
    //   310: aload 13
    //   312: astore 20
    //   314: aload 13
    //   316: astore 21
    //   318: aload 13
    //   320: astore 22
    //   322: ldc_w 808
    //   325: aload 25
    //   327: invokevirtual 635	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   330: ifne +26 -> 356
    //   333: aload 13
    //   335: astore 20
    //   337: aload 13
    //   339: astore 21
    //   341: aload 13
    //   343: astore 22
    //   345: ldc_w 810
    //   348: aload 25
    //   350: invokevirtual 635	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   353: ifeq +19 -> 372
    //   356: aload 13
    //   358: astore 20
    //   360: aload 13
    //   362: astore 21
    //   364: aload 13
    //   366: astore 22
    //   368: iconst_1
    //   369: putstatic 223	com/tencent/mobileqq/utils/HttpDownloadUtil:forceDirect	Z
    //   372: aload 13
    //   374: astore 20
    //   376: aload 13
    //   378: astore 21
    //   380: aload 13
    //   382: astore 22
    //   384: getstatic 223	com/tencent/mobileqq/utils/HttpDownloadUtil:forceDirect	Z
    //   387: ifne +186 -> 573
    //   390: aload 25
    //   392: ifnull +181 -> 573
    //   395: iload 16
    //   397: ifle +176 -> 573
    //   400: aload 13
    //   402: astore 20
    //   404: aload 13
    //   406: astore 21
    //   408: aload 13
    //   410: astore 22
    //   412: aload 23
    //   414: getstatic 806	com/tencent/mobileqq/utils/httputils/PkgTools:APN_TYPE_CMWAP	Ljava/lang/String;
    //   417: invokevirtual 635	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   420: ifne +127 -> 547
    //   423: aload 13
    //   425: astore 20
    //   427: aload 13
    //   429: astore 21
    //   431: aload 13
    //   433: astore 22
    //   435: aload 23
    //   437: getstatic 813	com/tencent/mobileqq/utils/httputils/PkgTools:APN_TYPE_UNIWAP	Ljava/lang/String;
    //   440: invokevirtual 635	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   443: ifne +104 -> 547
    //   446: aload 13
    //   448: astore 20
    //   450: aload 13
    //   452: astore 21
    //   454: aload 13
    //   456: astore 22
    //   458: aload 23
    //   460: getstatic 816	com/tencent/mobileqq/utils/httputils/PkgTools:APN_TYPE_3GWAP	Ljava/lang/String;
    //   463: invokevirtual 635	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   466: ifeq +6 -> 472
    //   469: goto +78 -> 547
    //   472: aload 13
    //   474: astore 20
    //   476: aload 13
    //   478: astore 21
    //   480: aload 13
    //   482: astore 22
    //   484: aload 23
    //   486: getstatic 819	com/tencent/mobileqq/utils/httputils/PkgTools:APN_TYPE_CTWAP	Ljava/lang/String;
    //   489: invokevirtual 635	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   492: ifeq +29 -> 521
    //   495: aload 13
    //   497: astore 20
    //   499: aload 13
    //   501: astore 21
    //   503: aload 13
    //   505: astore 22
    //   507: aload 9
    //   509: aload 25
    //   511: iload 16
    //   513: invokestatic 823	com/tencent/mobileqq/utils/httputils/PkgTools:getConnectionWithDefaultProxy	(Ljava/lang/String;Ljava/lang/String;I)Ljava/net/HttpURLConnection;
    //   516: astore 13
    //   518: goto +87 -> 605
    //   521: aload 13
    //   523: astore 20
    //   525: aload 13
    //   527: astore 21
    //   529: aload 13
    //   531: astore 22
    //   533: aload 9
    //   535: aload 25
    //   537: iload 16
    //   539: invokestatic 823	com/tencent/mobileqq/utils/httputils/PkgTools:getConnectionWithDefaultProxy	(Ljava/lang/String;Ljava/lang/String;I)Ljava/net/HttpURLConnection;
    //   542: astore 13
    //   544: goto +61 -> 605
    //   547: aload 13
    //   549: astore 20
    //   551: aload 13
    //   553: astore 21
    //   555: aload 13
    //   557: astore 22
    //   559: aload 9
    //   561: aload 25
    //   563: iload 16
    //   565: invokestatic 826	com/tencent/mobileqq/utils/httputils/PkgTools:getConnectionWithXOnlineHost	(Ljava/lang/String;Ljava/lang/String;I)Ljava/net/HttpURLConnection;
    //   568: astore 13
    //   570: goto +35 -> 605
    //   573: aload 13
    //   575: astore 20
    //   577: aload 13
    //   579: astore 21
    //   581: aload 13
    //   583: astore 22
    //   585: new 279	java/net/URL
    //   588: dup
    //   589: aload 9
    //   591: invokespecial 283	java/net/URL:<init>	(Ljava/lang/String;)V
    //   594: getstatic 832	java/net/Proxy:NO_PROXY	Ljava/net/Proxy;
    //   597: invokevirtual 836	java/net/URL:openConnection	(Ljava/net/Proxy;)Ljava/net/URLConnection;
    //   600: checkcast 253	java/net/HttpURLConnection
    //   603: astore 13
    //   605: aload 13
    //   607: astore 20
    //   609: aload 13
    //   611: astore 21
    //   613: aload 13
    //   615: astore 22
    //   617: aload 8
    //   619: aload 13
    //   621: putfield 840	com/tencent/mobileqq/emoticon/DownloadInfo:conn	Ljava/net/HttpURLConnection;
    //   624: aload 24
    //   626: ifnull +124 -> 750
    //   629: aload 13
    //   631: astore 20
    //   633: aload 13
    //   635: astore 21
    //   637: aload 13
    //   639: astore 22
    //   641: aload_2
    //   642: invokeinterface 843 1 0
    //   647: ifne +103 -> 750
    //   650: aload 13
    //   652: astore 20
    //   654: aload 13
    //   656: astore 21
    //   658: aload 13
    //   660: astore 22
    //   662: aload_2
    //   663: invokeinterface 847 1 0
    //   668: astore 23
    //   670: aload 13
    //   672: astore 20
    //   674: aload 13
    //   676: astore 21
    //   678: aload 13
    //   680: astore 22
    //   682: aload 23
    //   684: invokeinterface 852 1 0
    //   689: ifeq +61 -> 750
    //   692: aload 13
    //   694: astore 20
    //   696: aload 13
    //   698: astore 21
    //   700: aload 13
    //   702: astore 22
    //   704: aload 23
    //   706: invokeinterface 856 1 0
    //   711: checkcast 626	org/apache/http/Header
    //   714: astore 25
    //   716: aload 13
    //   718: astore 20
    //   720: aload 13
    //   722: astore 21
    //   724: aload 13
    //   726: astore 22
    //   728: aload 13
    //   730: aload 25
    //   732: invokeinterface 629 1 0
    //   737: aload 25
    //   739: invokeinterface 859 1 0
    //   744: invokevirtual 862	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   747: goto -77 -> 670
    //   750: aload 13
    //   752: astore 20
    //   754: aload 13
    //   756: astore 21
    //   758: aload 13
    //   760: astore 22
    //   762: aload 13
    //   764: ldc_w 864
    //   767: ldc_w 866
    //   770: invokevirtual 869	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   773: aload 13
    //   775: astore 20
    //   777: aload 13
    //   779: astore 21
    //   781: aload 13
    //   783: astore 22
    //   785: aload 13
    //   787: iload 6
    //   789: invokevirtual 873	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   792: aload 13
    //   794: astore 20
    //   796: aload 13
    //   798: astore 21
    //   800: aload 13
    //   802: astore 22
    //   804: aload 13
    //   806: iload 7
    //   808: invokevirtual 876	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   811: aload 13
    //   813: astore 20
    //   815: aload 13
    //   817: astore 21
    //   819: aload 13
    //   821: astore 22
    //   823: aload 13
    //   825: iconst_0
    //   826: invokevirtual 880	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   829: aload 13
    //   831: astore 20
    //   833: aload 13
    //   835: astore 21
    //   837: aload 13
    //   839: astore 22
    //   841: aload 13
    //   843: invokevirtual 883	java/net/HttpURLConnection:connect	()V
    //   846: aload 13
    //   848: astore 20
    //   850: aload 13
    //   852: astore 21
    //   854: aload 13
    //   856: astore 22
    //   858: aload 8
    //   860: aload 13
    //   862: invokevirtual 886	java/net/HttpURLConnection:getResponseCode	()I
    //   865: putfield 711	com/tencent/mobileqq/emoticon/DownloadInfo:httpRespCode	I
    //   868: aload 13
    //   870: astore 20
    //   872: aload 13
    //   874: astore 21
    //   876: aload 13
    //   878: astore 22
    //   880: aload 8
    //   882: aload 13
    //   884: invokevirtual 888	java/net/HttpURLConnection:getContentLength	()I
    //   887: putfield 891	com/tencent/mobileqq/emoticon/DownloadInfo:respContentLength	I
    //   890: aload 13
    //   892: astore 20
    //   894: aload 13
    //   896: astore 21
    //   898: aload 13
    //   900: astore 22
    //   902: aload 8
    //   904: aload 13
    //   906: invokevirtual 894	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
    //   909: putfield 897	com/tencent/mobileqq/emoticon/DownloadInfo:respContentType	Ljava/lang/String;
    //   912: aload 13
    //   914: astore 20
    //   916: aload 13
    //   918: astore 21
    //   920: aload 13
    //   922: astore 22
    //   924: aload 8
    //   926: aload 13
    //   928: invokevirtual 900	java/net/HttpURLConnection:getContentEncoding	()Ljava/lang/String;
    //   931: putfield 903	com/tencent/mobileqq/emoticon/DownloadInfo:respContentEncoding	Ljava/lang/String;
    //   934: aload 13
    //   936: astore 20
    //   938: aload 13
    //   940: astore 21
    //   942: aload 13
    //   944: astore 22
    //   946: aload 13
    //   948: aload 8
    //   950: invokestatic 905	com/tencent/mobileqq/utils/HttpDownloadUtil:copyRespHeader	(Ljava/net/HttpURLConnection;Lcom/tencent/mobileqq/emoticon/DownloadInfo;)V
    //   953: aload 13
    //   955: astore 20
    //   957: aload 13
    //   959: astore 21
    //   961: aload 13
    //   963: astore 22
    //   965: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   968: istore 17
    //   970: iload 17
    //   972: ifeq +1096 -> 2068
    //   975: aload 13
    //   977: astore 20
    //   979: new 436	java/lang/StringBuilder
    //   982: dup
    //   983: invokespecial 437	java/lang/StringBuilder:<init>	()V
    //   986: astore 23
    //   988: aload 13
    //   990: astore 20
    //   992: aload 23
    //   994: ldc_w 907
    //   997: invokevirtual 443	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1000: pop
    //   1001: aload 13
    //   1003: astore 20
    //   1005: aload 13
    //   1007: astore 21
    //   1009: aload 13
    //   1011: astore 22
    //   1013: aload 23
    //   1015: aload_0
    //   1016: invokevirtual 443	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1019: pop
    //   1020: aload 13
    //   1022: astore 20
    //   1024: aload 13
    //   1026: astore 21
    //   1028: aload 13
    //   1030: astore 22
    //   1032: aload 23
    //   1034: ldc_w 909
    //   1037: invokevirtual 443	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1040: pop
    //   1041: aload 13
    //   1043: astore 20
    //   1045: aload 13
    //   1047: astore 21
    //   1049: aload 13
    //   1051: astore 22
    //   1053: aload 23
    //   1055: aload 8
    //   1057: getfield 711	com/tencent/mobileqq/emoticon/DownloadInfo:httpRespCode	I
    //   1060: invokevirtual 449	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1063: pop
    //   1064: aload 13
    //   1066: astore 20
    //   1068: aload 13
    //   1070: astore 21
    //   1072: aload 13
    //   1074: astore 22
    //   1076: aload 23
    //   1078: ldc_w 911
    //   1081: invokevirtual 443	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1084: pop
    //   1085: aload 13
    //   1087: astore 20
    //   1089: aload 13
    //   1091: astore 21
    //   1093: aload 13
    //   1095: astore 22
    //   1097: aload 23
    //   1099: aload 8
    //   1101: getfield 891	com/tencent/mobileqq/emoticon/DownloadInfo:respContentLength	I
    //   1104: invokevirtual 449	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1107: pop
    //   1108: aload 13
    //   1110: astore 20
    //   1112: aload 13
    //   1114: astore 21
    //   1116: aload 13
    //   1118: astore 22
    //   1120: aload 23
    //   1122: ldc_w 913
    //   1125: invokevirtual 443	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1128: pop
    //   1129: aload 13
    //   1131: astore 20
    //   1133: aload 13
    //   1135: astore 21
    //   1137: aload 13
    //   1139: astore 22
    //   1141: aload 23
    //   1143: aload 8
    //   1145: getfield 897	com/tencent/mobileqq/emoticon/DownloadInfo:respContentType	Ljava/lang/String;
    //   1148: invokevirtual 443	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1151: pop
    //   1152: aload 13
    //   1154: astore 20
    //   1156: aload 13
    //   1158: astore 21
    //   1160: aload 13
    //   1162: astore 22
    //   1164: ldc 68
    //   1166: iconst_2
    //   1167: aload 23
    //   1169: invokevirtual 444	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1172: invokestatic 478	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1175: goto +3 -> 1178
    //   1178: iload 4
    //   1180: ifeq +59 -> 1239
    //   1183: aload 13
    //   1185: astore 20
    //   1187: aload 13
    //   1189: astore 21
    //   1191: aload 13
    //   1193: astore 22
    //   1195: aload 8
    //   1197: iconst_0
    //   1198: putfield 574	com/tencent/mobileqq/emoticon/DownloadInfo:resultCode	I
    //   1201: aload_1
    //   1202: ifnull +24 -> 1226
    //   1205: aload 13
    //   1207: astore 20
    //   1209: aload 13
    //   1211: astore 21
    //   1213: aload 13
    //   1215: astore 22
    //   1217: aload_1
    //   1218: aload 8
    //   1220: invokeinterface 721 2 0
    //   1225: pop
    //   1226: aload 13
    //   1228: ifnull +8 -> 1236
    //   1231: aload 13
    //   1233: invokevirtual 916	java/net/HttpURLConnection:disconnect	()V
    //   1236: aload 8
    //   1238: areturn
    //   1239: aload 13
    //   1241: astore 20
    //   1243: aload 13
    //   1245: astore 21
    //   1247: aload 13
    //   1249: astore 22
    //   1251: aload 8
    //   1253: getfield 711	com/tencent/mobileqq/emoticon/DownloadInfo:httpRespCode	I
    //   1256: sipush 200
    //   1259: if_icmpne +41 -> 1300
    //   1262: aload 13
    //   1264: astore 20
    //   1266: aload 13
    //   1268: astore 21
    //   1270: aload 13
    //   1272: astore 22
    //   1274: aload_1
    //   1275: aload 8
    //   1277: invokestatic 918	com/tencent/mobileqq/utils/HttpDownloadUtil:handleResp200	(Lcom/tencent/mobileqq/utils/HttpDownloadUtil$DownloadInfoListener;Lcom/tencent/mobileqq/emoticon/DownloadInfo;)Z
    //   1280: istore 17
    //   1282: iload 17
    //   1284: ifeq +87 -> 1371
    //   1287: aload 13
    //   1289: ifnull +8 -> 1297
    //   1292: aload 13
    //   1294: invokevirtual 916	java/net/HttpURLConnection:disconnect	()V
    //   1297: aload 8
    //   1299: areturn
    //   1300: aload 13
    //   1302: astore 20
    //   1304: aload 13
    //   1306: astore 21
    //   1308: aload 13
    //   1310: astore 22
    //   1312: aload 8
    //   1314: getfield 711	com/tencent/mobileqq/emoticon/DownloadInfo:httpRespCode	I
    //   1317: sipush 302
    //   1320: if_icmpeq +72 -> 1392
    //   1323: aload 13
    //   1325: astore 20
    //   1327: aload 13
    //   1329: astore 21
    //   1331: aload 13
    //   1333: astore 22
    //   1335: aload 8
    //   1337: getfield 711	com/tencent/mobileqq/emoticon/DownloadInfo:httpRespCode	I
    //   1340: sipush 301
    //   1343: if_icmpne +6 -> 1349
    //   1346: goto +46 -> 1392
    //   1349: aload 13
    //   1351: astore 20
    //   1353: aload 13
    //   1355: astore 21
    //   1357: aload 13
    //   1359: astore 22
    //   1361: aload 8
    //   1363: aload 8
    //   1365: getfield 711	com/tencent/mobileqq/emoticon/DownloadInfo:httpRespCode	I
    //   1368: putfield 574	com/tencent/mobileqq/emoticon/DownloadInfo:resultCode	I
    //   1371: aload 13
    //   1373: ifnull +8 -> 1381
    //   1376: aload 13
    //   1378: invokevirtual 916	java/net/HttpURLConnection:disconnect	()V
    //   1381: aload 13
    //   1383: astore 20
    //   1385: iload 14
    //   1387: istore 15
    //   1389: goto +543 -> 1932
    //   1392: aload 13
    //   1394: astore 20
    //   1396: aload 13
    //   1398: astore 21
    //   1400: aload 13
    //   1402: astore 22
    //   1404: aload 13
    //   1406: ldc_w 920
    //   1409: invokevirtual 257	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   1412: astore 23
    //   1414: aload 13
    //   1416: astore 20
    //   1418: aload 13
    //   1420: astore 21
    //   1422: aload 13
    //   1424: astore 22
    //   1426: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1429: ifeq +642 -> 2071
    //   1432: aload 13
    //   1434: astore 20
    //   1436: aload 13
    //   1438: astore 21
    //   1440: aload 13
    //   1442: astore 22
    //   1444: new 436	java/lang/StringBuilder
    //   1447: dup
    //   1448: invokespecial 437	java/lang/StringBuilder:<init>	()V
    //   1451: astore 25
    //   1453: aload 13
    //   1455: astore 20
    //   1457: aload 13
    //   1459: astore 21
    //   1461: aload 13
    //   1463: astore 22
    //   1465: aload 25
    //   1467: ldc_w 922
    //   1470: invokevirtual 443	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1473: pop
    //   1474: aload 13
    //   1476: astore 20
    //   1478: aload 13
    //   1480: astore 21
    //   1482: aload 13
    //   1484: astore 22
    //   1486: aload 25
    //   1488: aload 23
    //   1490: invokevirtual 443	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1493: pop
    //   1494: aload 13
    //   1496: astore 20
    //   1498: aload 13
    //   1500: astore 21
    //   1502: aload 13
    //   1504: astore 22
    //   1506: ldc 68
    //   1508: iconst_2
    //   1509: aload 25
    //   1511: invokevirtual 444	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1514: invokestatic 564	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1517: goto +3 -> 1520
    //   1520: aload 13
    //   1522: astore 20
    //   1524: aload 13
    //   1526: astore 21
    //   1528: aload 13
    //   1530: astore 22
    //   1532: aload 23
    //   1534: invokestatic 927	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1537: ifeq +35 -> 1572
    //   1540: aload 13
    //   1542: astore 20
    //   1544: aload 13
    //   1546: astore 21
    //   1548: aload 13
    //   1550: astore 22
    //   1552: aload 8
    //   1554: bipush 20
    //   1556: putfield 574	com/tencent/mobileqq/emoticon/DownloadInfo:resultCode	I
    //   1559: aload 13
    //   1561: ifnull +8 -> 1569
    //   1564: aload 13
    //   1566: invokevirtual 916	java/net/HttpURLConnection:disconnect	()V
    //   1569: aload 8
    //   1571: areturn
    //   1572: aload 13
    //   1574: astore 20
    //   1576: aload 13
    //   1578: astore 21
    //   1580: aload 13
    //   1582: astore 22
    //   1584: aload 13
    //   1586: invokevirtual 916	java/net/HttpURLConnection:disconnect	()V
    //   1589: aload 24
    //   1591: aload 23
    //   1593: invokestatic 929	com/tencent/mobileqq/utils/HttpDownloadUtil:handleAddHeaders	(Ljava/util/List;Ljava/lang/String;)V
    //   1596: aload 23
    //   1598: aload_1
    //   1599: aload_2
    //   1600: iload_3
    //   1601: iload 4
    //   1603: iload 5
    //   1605: iconst_1
    //   1606: iadd
    //   1607: iload 6
    //   1609: iload 7
    //   1611: invokestatic 750	com/tencent/mobileqq/utils/HttpDownloadUtil:queryDownloadInfo	(Ljava/lang/String;Lcom/tencent/mobileqq/utils/HttpDownloadUtil$DownloadInfoListener;Ljava/util/List;IZIII)Lcom/tencent/mobileqq/emoticon/DownloadInfo;
    //   1614: astore 13
    //   1616: aload 13
    //   1618: areturn
    //   1619: astore 13
    //   1621: goto +17 -> 1638
    //   1624: astore 13
    //   1626: goto +28 -> 1654
    //   1629: astore_0
    //   1630: aconst_null
    //   1631: astore 20
    //   1633: goto +388 -> 2021
    //   1636: astore 13
    //   1638: aconst_null
    //   1639: astore 20
    //   1641: aload 13
    //   1643: astore 21
    //   1645: aload 20
    //   1647: astore 13
    //   1649: goto +33 -> 1682
    //   1652: astore 13
    //   1654: aconst_null
    //   1655: astore 20
    //   1657: aload 13
    //   1659: astore 21
    //   1661: aload 20
    //   1663: astore 13
    //   1665: goto +235 -> 1900
    //   1668: astore_0
    //   1669: goto +352 -> 2021
    //   1672: astore 20
    //   1674: aload 21
    //   1676: astore 13
    //   1678: aload 20
    //   1680: astore 21
    //   1682: aload 13
    //   1684: astore 20
    //   1686: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1689: ifeq +12 -> 1701
    //   1692: aload 13
    //   1694: astore 20
    //   1696: aload 21
    //   1698: invokevirtual 502	java/lang/Exception:printStackTrace	()V
    //   1701: aload 13
    //   1703: astore 20
    //   1705: aload 8
    //   1707: iconst_5
    //   1708: putfield 574	com/tencent/mobileqq/emoticon/DownloadInfo:resultCode	I
    //   1711: aload 13
    //   1713: astore 20
    //   1715: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1718: ifeq +143 -> 1861
    //   1721: aload 13
    //   1723: astore 20
    //   1725: new 436	java/lang/StringBuilder
    //   1728: dup
    //   1729: invokespecial 437	java/lang/StringBuilder:<init>	()V
    //   1732: astore 22
    //   1734: aload 13
    //   1736: astore 20
    //   1738: aload 22
    //   1740: ldc_w 706
    //   1743: invokevirtual 443	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1746: pop
    //   1747: aload 13
    //   1749: astore 20
    //   1751: aload 22
    //   1753: aload 8
    //   1755: getfield 574	com/tencent/mobileqq/emoticon/DownloadInfo:resultCode	I
    //   1758: invokevirtual 449	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1761: pop
    //   1762: aload 13
    //   1764: astore 20
    //   1766: aload 22
    //   1768: ldc_w 931
    //   1771: invokevirtual 443	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1774: pop
    //   1775: aload 13
    //   1777: astore 20
    //   1779: aload 22
    //   1781: aload 8
    //   1783: getfield 711	com/tencent/mobileqq/emoticon/DownloadInfo:httpRespCode	I
    //   1786: invokevirtual 449	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1789: pop
    //   1790: aload 13
    //   1792: astore 20
    //   1794: aload 22
    //   1796: ldc_w 700
    //   1799: invokevirtual 443	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1802: pop
    //   1803: aload 13
    //   1805: astore 20
    //   1807: aload 22
    //   1809: aload 8
    //   1811: getfield 282	com/tencent/mobileqq/emoticon/DownloadInfo:reqUrl	Ljava/lang/String;
    //   1814: invokevirtual 443	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1817: pop
    //   1818: aload 13
    //   1820: astore 20
    //   1822: aload 22
    //   1824: ldc_w 702
    //   1827: invokevirtual 443	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1830: pop
    //   1831: aload 13
    //   1833: astore 20
    //   1835: aload 22
    //   1837: aload 21
    //   1839: invokevirtual 789	java/lang/Exception:toString	()Ljava/lang/String;
    //   1842: invokevirtual 443	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1845: pop
    //   1846: aload 13
    //   1848: astore 20
    //   1850: ldc 68
    //   1852: iconst_2
    //   1853: aload 22
    //   1855: invokevirtual 444	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1858: invokestatic 564	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1861: aload 13
    //   1863: astore 20
    //   1865: iload 14
    //   1867: istore 15
    //   1869: aload 13
    //   1871: ifnull +61 -> 1932
    //   1874: aload 13
    //   1876: invokevirtual 916	java/net/HttpURLConnection:disconnect	()V
    //   1879: aload 13
    //   1881: astore 20
    //   1883: iload 14
    //   1885: istore 15
    //   1887: goto +45 -> 1932
    //   1890: astore 20
    //   1892: aload 22
    //   1894: astore 13
    //   1896: aload 20
    //   1898: astore 21
    //   1900: aload 13
    //   1902: astore 20
    //   1904: iload_3
    //   1905: aload 8
    //   1907: iload 14
    //   1909: aload 21
    //   1911: invokestatic 933	com/tencent/mobileqq/utils/HttpDownloadUtil:handleQueryDownloadInfoException	(ILcom/tencent/mobileqq/emoticon/DownloadInfo;ILjava/io/IOException;)I
    //   1914: istore 14
    //   1916: aload 13
    //   1918: astore 20
    //   1920: iload 14
    //   1922: istore 15
    //   1924: aload 13
    //   1926: ifnull +6 -> 1932
    //   1929: goto -55 -> 1874
    //   1932: iload 15
    //   1934: iconst_1
    //   1935: iadd
    //   1936: istore 14
    //   1938: iload 14
    //   1940: iload_3
    //   1941: if_icmpge +39 -> 1980
    //   1944: aload 10
    //   1946: monitorenter
    //   1947: aload 10
    //   1949: lload 11
    //   1951: invokevirtual 516	java/lang/Object:wait	(J)V
    //   1954: lload 11
    //   1956: ldc2_w 794
    //   1959: lmul
    //   1960: lstore 11
    //   1962: goto +7 -> 1969
    //   1965: astore_0
    //   1966: goto +9 -> 1975
    //   1969: aload 10
    //   1971: monitorexit
    //   1972: goto +33 -> 2005
    //   1975: aload 10
    //   1977: monitorexit
    //   1978: aload_0
    //   1979: athrow
    //   1980: lload 11
    //   1982: lstore 18
    //   1984: lload 18
    //   1986: lstore 11
    //   1988: aload_1
    //   1989: ifnull +16 -> 2005
    //   1992: aload_1
    //   1993: aload 8
    //   1995: invokeinterface 721 2 0
    //   2000: pop
    //   2001: lload 18
    //   2003: lstore 11
    //   2005: aload 20
    //   2007: astore 13
    //   2009: iload 14
    //   2011: iload_3
    //   2012: if_icmplt +6 -> 2018
    //   2015: aload 8
    //   2017: areturn
    //   2018: goto -2018 -> 0
    //   2021: aload 20
    //   2023: ifnull +8 -> 2031
    //   2026: aload 20
    //   2028: invokevirtual 916	java/net/HttpURLConnection:disconnect	()V
    //   2031: goto +5 -> 2036
    //   2034: aload_0
    //   2035: athrow
    //   2036: goto -2 -> 2034
    //   2039: astore 20
    //   2041: goto -1954 -> 87
    //   2044: astore 13
    //   2046: goto -77 -> 1969
    //   2049: aconst_null
    //   2050: astore 23
    //   2052: iconst_m1
    //   2053: istore 15
    //   2055: goto -1911 -> 144
    //   2058: astore 20
    //   2060: goto -382 -> 1678
    //   2063: astore 20
    //   2065: goto -169 -> 1896
    //   2068: goto -890 -> 1178
    //   2071: goto -551 -> 1520
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2074	0	paramString1	String
    //   0	2074	1	paramDownloadInfoListener	HttpDownloadUtil.DownloadInfoListener
    //   0	2074	2	paramList	List<Header>
    //   0	2074	3	paramInt1	int
    //   0	2074	4	paramBoolean	boolean
    //   0	2074	5	paramInt2	int
    //   0	2074	6	paramInt3	int
    //   0	2074	7	paramInt4	int
    //   0	2074	8	paramDownloadInfo	DownloadInfo
    //   0	2074	9	paramString2	String
    //   0	2074	10	paramObject	Object
    //   0	2074	11	paramLong	long
    //   0	2074	13	paramHttpURLConnection	HttpURLConnection
    //   0	2074	14	paramInt5	int
    //   139	1915	15	i	int
    //   176	388	16	j	int
    //   968	315	17	bool	boolean
    //   1982	20	18	l	long
    //   105	1557	20	localHttpURLConnection1	HttpURLConnection
    //   1672	7	20	localException1	Exception
    //   1684	198	20	localHttpURLConnection2	HttpURLConnection
    //   1890	7	20	localIOException1	IOException
    //   1902	125	20	localHttpURLConnection3	HttpURLConnection
    //   2039	1	20	localInterruptedException	InterruptedException
    //   2058	1	20	localException2	Exception
    //   2063	1	20	localIOException2	IOException
    //   109	1801	21	localObject1	Object
    //   113	1780	22	localObject2	Object
    //   120	1931	23	localObject3	Object
    //   1	1589	24	localList	List<Header>
    //   6	1504	25	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   65	72	83	finally
    //   87	90	83	finally
    //   93	96	83	finally
    //   1596	1616	1619	java/lang/Exception
    //   1596	1616	1624	java/io/IOException
    //   1589	1596	1629	finally
    //   1596	1616	1629	finally
    //   1589	1596	1636	java/lang/Exception
    //   1589	1596	1652	java/io/IOException
    //   115	122	1668	finally
    //   134	141	1668	finally
    //   156	161	1668	finally
    //   173	178	1668	finally
    //   190	197	1668	finally
    //   209	220	1668	finally
    //   232	237	1668	finally
    //   255	266	1668	finally
    //   281	285	1668	finally
    //   300	304	1668	finally
    //   322	333	1668	finally
    //   345	356	1668	finally
    //   368	372	1668	finally
    //   384	390	1668	finally
    //   412	423	1668	finally
    //   435	446	1668	finally
    //   458	469	1668	finally
    //   484	495	1668	finally
    //   507	518	1668	finally
    //   533	544	1668	finally
    //   559	570	1668	finally
    //   585	605	1668	finally
    //   617	624	1668	finally
    //   641	650	1668	finally
    //   662	670	1668	finally
    //   682	692	1668	finally
    //   704	716	1668	finally
    //   728	747	1668	finally
    //   762	773	1668	finally
    //   785	792	1668	finally
    //   804	811	1668	finally
    //   823	829	1668	finally
    //   841	846	1668	finally
    //   858	868	1668	finally
    //   880	890	1668	finally
    //   902	912	1668	finally
    //   924	934	1668	finally
    //   946	953	1668	finally
    //   965	970	1668	finally
    //   979	988	1668	finally
    //   992	1001	1668	finally
    //   1013	1020	1668	finally
    //   1032	1041	1668	finally
    //   1053	1064	1668	finally
    //   1076	1085	1668	finally
    //   1097	1108	1668	finally
    //   1120	1129	1668	finally
    //   1141	1152	1668	finally
    //   1164	1175	1668	finally
    //   1195	1201	1668	finally
    //   1217	1226	1668	finally
    //   1251	1262	1668	finally
    //   1274	1282	1668	finally
    //   1312	1323	1668	finally
    //   1335	1346	1668	finally
    //   1361	1371	1668	finally
    //   1404	1414	1668	finally
    //   1426	1432	1668	finally
    //   1444	1453	1668	finally
    //   1465	1474	1668	finally
    //   1486	1494	1668	finally
    //   1506	1517	1668	finally
    //   1532	1540	1668	finally
    //   1552	1559	1668	finally
    //   1584	1589	1668	finally
    //   1686	1692	1668	finally
    //   1696	1701	1668	finally
    //   1705	1711	1668	finally
    //   1715	1721	1668	finally
    //   1725	1734	1668	finally
    //   1738	1747	1668	finally
    //   1751	1762	1668	finally
    //   1766	1775	1668	finally
    //   1779	1790	1668	finally
    //   1794	1803	1668	finally
    //   1807	1818	1668	finally
    //   1822	1831	1668	finally
    //   1835	1846	1668	finally
    //   1850	1861	1668	finally
    //   1904	1916	1668	finally
    //   115	122	1672	java/lang/Exception
    //   134	141	1672	java/lang/Exception
    //   156	161	1672	java/lang/Exception
    //   173	178	1672	java/lang/Exception
    //   190	197	1672	java/lang/Exception
    //   209	220	1672	java/lang/Exception
    //   232	237	1672	java/lang/Exception
    //   255	266	1672	java/lang/Exception
    //   281	285	1672	java/lang/Exception
    //   300	304	1672	java/lang/Exception
    //   322	333	1672	java/lang/Exception
    //   345	356	1672	java/lang/Exception
    //   368	372	1672	java/lang/Exception
    //   384	390	1672	java/lang/Exception
    //   412	423	1672	java/lang/Exception
    //   435	446	1672	java/lang/Exception
    //   458	469	1672	java/lang/Exception
    //   484	495	1672	java/lang/Exception
    //   507	518	1672	java/lang/Exception
    //   533	544	1672	java/lang/Exception
    //   559	570	1672	java/lang/Exception
    //   585	605	1672	java/lang/Exception
    //   617	624	1672	java/lang/Exception
    //   641	650	1672	java/lang/Exception
    //   662	670	1672	java/lang/Exception
    //   682	692	1672	java/lang/Exception
    //   704	716	1672	java/lang/Exception
    //   728	747	1672	java/lang/Exception
    //   762	773	1672	java/lang/Exception
    //   785	792	1672	java/lang/Exception
    //   804	811	1672	java/lang/Exception
    //   823	829	1672	java/lang/Exception
    //   841	846	1672	java/lang/Exception
    //   858	868	1672	java/lang/Exception
    //   880	890	1672	java/lang/Exception
    //   902	912	1672	java/lang/Exception
    //   924	934	1672	java/lang/Exception
    //   946	953	1672	java/lang/Exception
    //   965	970	1672	java/lang/Exception
    //   1013	1020	1672	java/lang/Exception
    //   1032	1041	1672	java/lang/Exception
    //   1053	1064	1672	java/lang/Exception
    //   1076	1085	1672	java/lang/Exception
    //   1097	1108	1672	java/lang/Exception
    //   1120	1129	1672	java/lang/Exception
    //   1141	1152	1672	java/lang/Exception
    //   1164	1175	1672	java/lang/Exception
    //   1195	1201	1672	java/lang/Exception
    //   1217	1226	1672	java/lang/Exception
    //   1251	1262	1672	java/lang/Exception
    //   1274	1282	1672	java/lang/Exception
    //   1312	1323	1672	java/lang/Exception
    //   1335	1346	1672	java/lang/Exception
    //   1361	1371	1672	java/lang/Exception
    //   1404	1414	1672	java/lang/Exception
    //   1426	1432	1672	java/lang/Exception
    //   1444	1453	1672	java/lang/Exception
    //   1465	1474	1672	java/lang/Exception
    //   1486	1494	1672	java/lang/Exception
    //   1506	1517	1672	java/lang/Exception
    //   1532	1540	1672	java/lang/Exception
    //   1552	1559	1672	java/lang/Exception
    //   1584	1589	1672	java/lang/Exception
    //   115	122	1890	java/io/IOException
    //   134	141	1890	java/io/IOException
    //   156	161	1890	java/io/IOException
    //   173	178	1890	java/io/IOException
    //   190	197	1890	java/io/IOException
    //   209	220	1890	java/io/IOException
    //   232	237	1890	java/io/IOException
    //   255	266	1890	java/io/IOException
    //   281	285	1890	java/io/IOException
    //   300	304	1890	java/io/IOException
    //   322	333	1890	java/io/IOException
    //   345	356	1890	java/io/IOException
    //   368	372	1890	java/io/IOException
    //   384	390	1890	java/io/IOException
    //   412	423	1890	java/io/IOException
    //   435	446	1890	java/io/IOException
    //   458	469	1890	java/io/IOException
    //   484	495	1890	java/io/IOException
    //   507	518	1890	java/io/IOException
    //   533	544	1890	java/io/IOException
    //   559	570	1890	java/io/IOException
    //   585	605	1890	java/io/IOException
    //   617	624	1890	java/io/IOException
    //   641	650	1890	java/io/IOException
    //   662	670	1890	java/io/IOException
    //   682	692	1890	java/io/IOException
    //   704	716	1890	java/io/IOException
    //   728	747	1890	java/io/IOException
    //   762	773	1890	java/io/IOException
    //   785	792	1890	java/io/IOException
    //   804	811	1890	java/io/IOException
    //   823	829	1890	java/io/IOException
    //   841	846	1890	java/io/IOException
    //   858	868	1890	java/io/IOException
    //   880	890	1890	java/io/IOException
    //   902	912	1890	java/io/IOException
    //   924	934	1890	java/io/IOException
    //   946	953	1890	java/io/IOException
    //   965	970	1890	java/io/IOException
    //   1013	1020	1890	java/io/IOException
    //   1032	1041	1890	java/io/IOException
    //   1053	1064	1890	java/io/IOException
    //   1076	1085	1890	java/io/IOException
    //   1097	1108	1890	java/io/IOException
    //   1120	1129	1890	java/io/IOException
    //   1141	1152	1890	java/io/IOException
    //   1164	1175	1890	java/io/IOException
    //   1195	1201	1890	java/io/IOException
    //   1217	1226	1890	java/io/IOException
    //   1251	1262	1890	java/io/IOException
    //   1274	1282	1890	java/io/IOException
    //   1312	1323	1890	java/io/IOException
    //   1335	1346	1890	java/io/IOException
    //   1361	1371	1890	java/io/IOException
    //   1404	1414	1890	java/io/IOException
    //   1426	1432	1890	java/io/IOException
    //   1444	1453	1890	java/io/IOException
    //   1465	1474	1890	java/io/IOException
    //   1486	1494	1890	java/io/IOException
    //   1506	1517	1890	java/io/IOException
    //   1532	1540	1890	java/io/IOException
    //   1552	1559	1890	java/io/IOException
    //   1584	1589	1890	java/io/IOException
    //   1947	1954	1965	finally
    //   1969	1972	1965	finally
    //   1975	1978	1965	finally
    //   65	72	2039	java/lang/InterruptedException
    //   1947	1954	2044	java/lang/InterruptedException
    //   979	988	2058	java/lang/Exception
    //   992	1001	2058	java/lang/Exception
    //   979	988	2063	java/io/IOException
    //   992	1001	2063	java/io/IOException
  }
  
  private static void waitBeforeRetry(URL paramURL, Object paramObject, int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Download. result=");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", url=");
      localStringBuilder.append(paramURL);
      QLog.d("HttpDownloadUtil", 2, localStringBuilder.toString());
    }
    if (paramInt1 != 0)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Download. result=");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", url=");
      localStringBuilder.append(paramURL);
      localStringBuilder.append(", tryCount=");
      localStringBuilder.append(paramInt2);
      QLog.d("HttpDownloadUtil", 1, localStringBuilder.toString());
    }
    if ((paramInt1 != 0) && (paramInt2 < 2)) {}
    try
    {
      try
      {
        paramObject.wait(500L);
      }
      finally
      {
        break label158;
      }
    }
    catch (InterruptedException paramURL)
    {
      label155:
      break label155;
    }
    return;
    label158:
    throw paramURL;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.HttpDownloadUtil
 * JD-Core Version:    0.7.0.1
 */