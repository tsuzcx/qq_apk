package com.tencent.mobileqq.utils;

import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.text.TextUtils;
import asid;
import bhed;
import bhee;
import bhef;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.transfile.FMTSrvAddrProvider;
import com.tencent.mobileqq.transfile.HttpDownloader;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.TlsSniSocketFactory;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
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
        if ((Build.VERSION.SDK_INT < 23) && (!HttpDownloader.shutdownSniSupport())) {
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
      PROTOCOL_HTTPS = "https://";
      return;
      ((SchemeRegistry)localObject).register(new Scheme("https", new TlsSniSocketFactory(HttpDownloadUtil.class.getSimpleName()), 443));
    }
  }
  
  private static boolean checkValid(asid paramasid)
  {
    if (paramasid == null) {
      if (QLog.isColorLevel()) {
        QLog.d("HttpDownloadUtil", 2, "DownloadInfo is null.");
      }
    }
    do
    {
      return false;
      if (paramasid.jdField_a_of_type_JavaIoFile != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("HttpDownloadUtil", 2, "DownloadInfo.file is null.");
    return false;
    return true;
  }
  
  static void copyRespHeader(HttpURLConnection paramHttpURLConnection, asid paramasid)
  {
    if ((paramHttpURLConnection == null) || (paramasid == null)) {}
    do
    {
      return;
      if (paramHttpURLConnection.getHeaderField("X-FailNo") != null) {
        paramasid.j = paramHttpURLConnection.getHeaderField("X-FailNo");
      }
    } while (paramHttpURLConnection.getHeaderField("X-ErrNo") == null);
    paramasid.k = paramHttpURLConnection.getHeaderField("X-ErrNo");
  }
  
  /* Error */
  private static int download(AppInterface paramAppInterface, asid paramasid, NetworkInfo paramNetworkInfo, bhee parambhee)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 269	com/tencent/mobileqq/utils/HttpDownloadUtil:checkValid	(Lasid;)Z
    //   4: ifne +9 -> 13
    //   7: iconst_5
    //   8: istore 6
    //   10: iload 6
    //   12: ireturn
    //   13: new 271	java/net/URL
    //   16: dup
    //   17: aload_1
    //   18: getfield 274	asid:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   21: invokespecial 275	java/net/URL:<init>	(Ljava/lang/String;)V
    //   24: astore 27
    //   26: invokestatic 86	java/lang/System:currentTimeMillis	()J
    //   29: lstore 12
    //   31: new 4	java/lang/Object
    //   34: dup
    //   35: invokespecial 223	java/lang/Object:<init>	()V
    //   38: astore 28
    //   40: aload_1
    //   41: getfield 237	asid:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   44: invokevirtual 281	java/io/File:getParentFile	()Ljava/io/File;
    //   47: astore 17
    //   49: aload 17
    //   51: ifnull +141 -> 192
    //   54: aload 17
    //   56: invokevirtual 284	java/io/File:exists	()Z
    //   59: ifne +133 -> 192
    //   62: aload 17
    //   64: invokevirtual 287	java/io/File:mkdirs	()Z
    //   67: ifne +125 -> 192
    //   70: aload_3
    //   71: ifnull +15 -> 86
    //   74: aload_3
    //   75: aload 27
    //   77: invokevirtual 290	java/net/URL:toString	()Ljava/lang/String;
    //   80: iconst_4
    //   81: invokeinterface 295 3 0
    //   86: invokestatic 215	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   89: ifeq +32 -> 121
    //   92: ldc 64
    //   94: iconst_2
    //   95: new 297	java/lang/StringBuilder
    //   98: dup
    //   99: invokespecial 298	java/lang/StringBuilder:<init>	()V
    //   102: ldc_w 300
    //   105: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: aload_1
    //   109: getfield 274	asid:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   112: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: invokevirtual 305	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: invokestatic 231	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   121: iconst_4
    //   122: ireturn
    //   123: astore_0
    //   124: aload_0
    //   125: invokevirtual 308	java/net/MalformedURLException:printStackTrace	()V
    //   128: aload_1
    //   129: aload_0
    //   130: invokestatic 314	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   133: putfield 316	asid:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   136: iconst_5
    //   137: ireturn
    //   138: astore_0
    //   139: aload_3
    //   140: ifnull +15 -> 155
    //   143: aload_3
    //   144: aload 27
    //   146: invokevirtual 290	java/net/URL:toString	()Ljava/lang/String;
    //   149: iconst_4
    //   150: invokeinterface 295 3 0
    //   155: invokestatic 215	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   158: ifeq +32 -> 190
    //   161: ldc 64
    //   163: iconst_2
    //   164: new 297	java/lang/StringBuilder
    //   167: dup
    //   168: invokespecial 298	java/lang/StringBuilder:<init>	()V
    //   171: ldc_w 300
    //   174: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: aload_1
    //   178: getfield 274	asid:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   181: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: invokevirtual 305	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   187: invokestatic 231	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   190: iconst_4
    //   191: ireturn
    //   192: aconst_null
    //   193: astore 19
    //   195: aload_1
    //   196: getfield 274	asid:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   199: astore 17
    //   201: new 318	org/apache/http/client/methods/HttpGet
    //   204: dup
    //   205: aload 17
    //   207: invokespecial 319	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   210: astore 26
    //   212: new 90	org/apache/http/params/BasicHttpParams
    //   215: dup
    //   216: invokespecial 93	org/apache/http/params/BasicHttpParams:<init>	()V
    //   219: astore 29
    //   221: aload 29
    //   223: ldc_w 321
    //   226: ldc_w 322
    //   229: invokestatic 327	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   232: invokeinterface 333 3 0
    //   237: pop
    //   238: aload 29
    //   240: ldc_w 335
    //   243: ldc_w 322
    //   246: invokestatic 327	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   249: invokeinterface 333 3 0
    //   254: pop
    //   255: invokestatic 340	android/net/Proxy:getDefaultHost	()Ljava/lang/String;
    //   258: astore 17
    //   260: invokestatic 344	android/net/Proxy:getDefaultPort	()I
    //   263: istore 5
    //   265: iconst_0
    //   266: istore 4
    //   268: aload_2
    //   269: ifnull +96 -> 365
    //   272: aload_2
    //   273: invokevirtual 349	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   276: astore 18
    //   278: aload_2
    //   279: invokestatic 355	com/tencent/mobileqq/utils/NetworkUtil:isMobileNetworkInfo	(Landroid/net/NetworkInfo;)Z
    //   282: ifeq +51 -> 333
    //   285: aload 18
    //   287: ifnull +14 -> 301
    //   290: aload 18
    //   292: ldc_w 357
    //   295: invokevirtual 361	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   298: ifeq +35 -> 333
    //   301: aload 17
    //   303: ifnull +30 -> 333
    //   306: iload 5
    //   308: ifle +25 -> 333
    //   311: aload 29
    //   313: ldc_w 363
    //   316: new 365	org/apache/http/HttpHost
    //   319: dup
    //   320: aload 17
    //   322: iload 5
    //   324: invokespecial 367	org/apache/http/HttpHost:<init>	(Ljava/lang/String;I)V
    //   327: invokeinterface 333 3 0
    //   332: pop
    //   333: aload_2
    //   334: invokestatic 355	com/tencent/mobileqq/utils/NetworkUtil:isMobileNetworkInfo	(Landroid/net/NetworkInfo;)Z
    //   337: ifeq +574 -> 911
    //   340: sipush 2048
    //   343: istore 4
    //   345: aload 29
    //   347: ldc_w 369
    //   350: iload 4
    //   352: invokeinterface 373 3 0
    //   357: pop
    //   358: aload 26
    //   360: aload 29
    //   362: invokevirtual 377	org/apache/http/client/methods/HttpGet:setParams	(Lorg/apache/http/params/HttpParams;)V
    //   365: new 277	java/io/File
    //   368: dup
    //   369: aload_1
    //   370: invokevirtual 379	asid:a	()Ljava/lang/String;
    //   373: invokespecial 380	java/io/File:<init>	(Ljava/lang/String;)V
    //   376: astore 30
    //   378: aload 30
    //   380: invokevirtual 284	java/io/File:exists	()Z
    //   383: ifeq +9 -> 392
    //   386: aload 30
    //   388: invokevirtual 383	java/io/File:delete	()Z
    //   391: pop
    //   392: aconst_null
    //   393: astore 17
    //   395: iconst_m1
    //   396: istore 9
    //   398: iconst_5
    //   399: istore 10
    //   401: iload 9
    //   403: ifne +38 -> 441
    //   406: aload 29
    //   408: ldc_w 363
    //   411: new 365	org/apache/http/HttpHost
    //   414: dup
    //   415: aload 27
    //   417: invokevirtual 386	java/net/URL:getHost	()Ljava/lang/String;
    //   420: aload 27
    //   422: invokevirtual 389	java/net/URL:getPort	()I
    //   425: invokespecial 367	org/apache/http/HttpHost:<init>	(Ljava/lang/String;I)V
    //   428: invokeinterface 333 3 0
    //   433: pop
    //   434: aload 26
    //   436: aload 29
    //   438: invokevirtual 377	org/apache/http/client/methods/HttpGet:setParams	(Lorg/apache/http/params/HttpParams;)V
    //   441: aload 19
    //   443: astore 24
    //   445: aload 17
    //   447: astore 20
    //   449: iload 4
    //   451: istore 6
    //   453: aload 19
    //   455: astore 23
    //   457: aload 17
    //   459: astore 21
    //   461: iload 4
    //   463: istore 8
    //   465: aload 19
    //   467: astore 25
    //   469: aload 17
    //   471: astore 22
    //   473: iload 10
    //   475: istore 7
    //   477: getstatic 173	com/tencent/mobileqq/utils/HttpDownloadUtil:client	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   480: new 365	org/apache/http/HttpHost
    //   483: dup
    //   484: aload 27
    //   486: invokevirtual 386	java/net/URL:getHost	()Ljava/lang/String;
    //   489: invokespecial 390	org/apache/http/HttpHost:<init>	(Ljava/lang/String;)V
    //   492: aload 26
    //   494: invokevirtual 394	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/HttpHost;Lorg/apache/http/HttpRequest;)Lorg/apache/http/HttpResponse;
    //   497: astore 18
    //   499: aload 19
    //   501: astore 24
    //   503: aload 17
    //   505: astore 20
    //   507: iload 4
    //   509: istore 6
    //   511: aload 19
    //   513: astore 23
    //   515: aload 17
    //   517: astore 21
    //   519: iload 4
    //   521: istore 8
    //   523: aload 19
    //   525: astore 25
    //   527: aload 17
    //   529: astore 22
    //   531: iload 10
    //   533: istore 7
    //   535: aload 18
    //   537: invokeinterface 400 1 0
    //   542: astore 31
    //   544: aload 19
    //   546: astore 24
    //   548: aload 17
    //   550: astore 20
    //   552: iload 4
    //   554: istore 6
    //   556: aload 19
    //   558: astore 23
    //   560: aload 17
    //   562: astore 21
    //   564: iload 4
    //   566: istore 8
    //   568: aload 19
    //   570: astore 25
    //   572: aload 17
    //   574: astore 22
    //   576: iload 10
    //   578: istore 7
    //   580: aload 18
    //   582: invokeinterface 404 1 0
    //   587: pop
    //   588: aload 19
    //   590: astore 24
    //   592: aload 17
    //   594: astore 20
    //   596: iload 4
    //   598: istore 6
    //   600: aload 19
    //   602: astore 23
    //   604: aload 17
    //   606: astore 21
    //   608: iload 4
    //   610: istore 8
    //   612: aload 19
    //   614: astore 25
    //   616: aload 17
    //   618: astore 22
    //   620: iload 10
    //   622: istore 7
    //   624: aload 31
    //   626: invokeinterface 409 1 0
    //   631: istore 5
    //   633: aload_3
    //   634: ifnull +52 -> 686
    //   637: aload 19
    //   639: astore 24
    //   641: aload 17
    //   643: astore 20
    //   645: iload 4
    //   647: istore 6
    //   649: aload 19
    //   651: astore 23
    //   653: aload 17
    //   655: astore 21
    //   657: iload 4
    //   659: istore 8
    //   661: aload 19
    //   663: astore 25
    //   665: aload 17
    //   667: astore 22
    //   669: iload 10
    //   671: istore 7
    //   673: aload_3
    //   674: aload 27
    //   676: invokevirtual 290	java/net/URL:toString	()Ljava/lang/String;
    //   679: iload 5
    //   681: invokeinterface 411 3 0
    //   686: aload 19
    //   688: astore 24
    //   690: aload 17
    //   692: astore 20
    //   694: iload 4
    //   696: istore 6
    //   698: aload 19
    //   700: astore 23
    //   702: aload 17
    //   704: astore 21
    //   706: iload 4
    //   708: istore 8
    //   710: aload 19
    //   712: astore 25
    //   714: aload 17
    //   716: astore 22
    //   718: iload 10
    //   720: istore 7
    //   722: aload 18
    //   724: invokeinterface 415 1 0
    //   729: astore 17
    //   731: sipush 200
    //   734: iload 5
    //   736: if_icmpne +1389 -> 2125
    //   739: aload 19
    //   741: astore 24
    //   743: aload 17
    //   745: astore 20
    //   747: iload 4
    //   749: istore 6
    //   751: aload 19
    //   753: astore 23
    //   755: aload 17
    //   757: astore 21
    //   759: iload 4
    //   761: istore 8
    //   763: aload 19
    //   765: astore 25
    //   767: aload 17
    //   769: astore 22
    //   771: iload 10
    //   773: istore 7
    //   775: aload 17
    //   777: invokeinterface 420 1 0
    //   782: lstore 14
    //   784: aconst_null
    //   785: astore 20
    //   787: iconst_0
    //   788: istore 5
    //   790: new 422	java/io/FileOutputStream
    //   793: dup
    //   794: aload 30
    //   796: invokespecial 425	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   799: astore 18
    //   801: aload 17
    //   803: invokeinterface 429 1 0
    //   808: astore 19
    //   810: aload 19
    //   812: astore 20
    //   814: iload 4
    //   816: ifne +1844 -> 2660
    //   819: sipush 2048
    //   822: istore 4
    //   824: iload 4
    //   826: newarray byte
    //   828: astore 19
    //   830: iload 5
    //   832: i2l
    //   833: lload 14
    //   835: lcmp
    //   836: ifge +83 -> 919
    //   839: aload 20
    //   841: aload 19
    //   843: invokevirtual 435	java/io/InputStream:read	([B)I
    //   846: istore 6
    //   848: aload 18
    //   850: aload 19
    //   852: iconst_0
    //   853: iload 6
    //   855: invokevirtual 441	java/io/OutputStream:write	([BII)V
    //   858: iload 5
    //   860: iload 6
    //   862: iadd
    //   863: istore 5
    //   865: aload_3
    //   866: ifnull +1791 -> 2657
    //   869: aload_3
    //   870: aload 27
    //   872: invokevirtual 290	java/net/URL:toString	()Ljava/lang/String;
    //   875: lload 14
    //   877: iload 5
    //   879: i2l
    //   880: invokeinterface 444 6 0
    //   885: goto -55 -> 830
    //   888: astore 18
    //   890: new 318	org/apache/http/client/methods/HttpGet
    //   893: dup
    //   894: aload 17
    //   896: invokestatic 447	com/tencent/mobileqq/utils/HttpDownloadUtil:getEscapeSequence	(Ljava/lang/String;)Ljava/lang/String;
    //   899: invokespecial 319	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   902: astore 26
    //   904: goto -692 -> 212
    //   907: astore_0
    //   908: bipush 13
    //   910: ireturn
    //   911: sipush 4096
    //   914: istore 4
    //   916: goto -571 -> 345
    //   919: iload 5
    //   921: i2l
    //   922: lload 14
    //   924: lcmp
    //   925: ifne +611 -> 1536
    //   928: iconst_0
    //   929: istore 10
    //   931: iconst_0
    //   932: istore 11
    //   934: iconst_0
    //   935: istore 8
    //   937: iload 8
    //   939: istore 5
    //   941: iload 10
    //   943: istore 6
    //   945: iload 11
    //   947: istore 7
    //   949: invokestatic 215	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   952: ifeq +44 -> 996
    //   955: iload 10
    //   957: istore 6
    //   959: iload 11
    //   961: istore 7
    //   963: ldc 64
    //   965: iconst_2
    //   966: new 297	java/lang/StringBuilder
    //   969: dup
    //   970: invokespecial 298	java/lang/StringBuilder:<init>	()V
    //   973: ldc_w 449
    //   976: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   979: aload_1
    //   980: getfield 274	asid:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   983: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   986: invokevirtual 305	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   989: invokestatic 231	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   992: iload 8
    //   994: istore 5
    //   996: iload 5
    //   998: istore 6
    //   1000: iload 5
    //   1002: istore 7
    //   1004: invokestatic 215	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1007: ifeq +53 -> 1060
    //   1010: iload 5
    //   1012: istore 6
    //   1014: iload 5
    //   1016: istore 7
    //   1018: ldc_w 450
    //   1021: iconst_2
    //   1022: new 297	java/lang/StringBuilder
    //   1025: dup
    //   1026: invokespecial 298	java/lang/StringBuilder:<init>	()V
    //   1029: ldc_w 452
    //   1032: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1035: invokestatic 86	java/lang/System:currentTimeMillis	()J
    //   1038: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1041: ldc_w 457
    //   1044: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1047: aload_1
    //   1048: getfield 274	asid:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1051: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1054: invokevirtual 305	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1057: invokestatic 231	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1060: iload 5
    //   1062: istore 6
    //   1064: iload 5
    //   1066: istore 7
    //   1068: aload_1
    //   1069: getfield 459	asid:jdField_a_of_type_Int	I
    //   1072: tableswitch	default:+1591 -> 2663, 10001:+624->1696
    //   1093: iconst_2
    //   1094: istore 6
    //   1096: iload 5
    //   1098: istore 7
    //   1100: aload_2
    //   1101: invokestatic 355	com/tencent/mobileqq/utils/NetworkUtil:isMobileNetworkInfo	(Landroid/net/NetworkInfo;)Z
    //   1104: ifeq +958 -> 2062
    //   1107: iload 5
    //   1109: istore 6
    //   1111: iload 5
    //   1113: istore 7
    //   1115: iconst_3
    //   1116: anewarray 310	java/lang/String
    //   1119: astore 19
    //   1121: aload 19
    //   1123: iconst_0
    //   1124: ldc_w 461
    //   1127: aastore
    //   1128: aload 19
    //   1130: iconst_1
    //   1131: ldc_w 463
    //   1134: aastore
    //   1135: aload 19
    //   1137: iconst_2
    //   1138: ldc_w 465
    //   1141: aastore
    //   1142: aload 19
    //   1144: ifnull +23 -> 1167
    //   1147: iload 5
    //   1149: istore 6
    //   1151: iload 5
    //   1153: istore 7
    //   1155: aload_0
    //   1156: aload_0
    //   1157: invokevirtual 470	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1160: aload 19
    //   1162: lload 14
    //   1164: invokevirtual 474	com/tencent/common/app/AppInterface:sendAppDataIncerment	(Ljava/lang/String;[Ljava/lang/String;J)V
    //   1167: iload 5
    //   1169: istore 6
    //   1171: iload 5
    //   1173: istore 7
    //   1175: aload 30
    //   1177: invokestatic 86	java/lang/System:currentTimeMillis	()J
    //   1180: invokevirtual 478	java/io/File:setLastModified	(J)Z
    //   1183: pop
    //   1184: iload 5
    //   1186: istore 6
    //   1188: iload 5
    //   1190: istore 7
    //   1192: invokestatic 215	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1195: ifeq +66 -> 1261
    //   1198: iload 5
    //   1200: istore 6
    //   1202: iload 5
    //   1204: istore 7
    //   1206: ldc 64
    //   1208: iconst_2
    //   1209: new 297	java/lang/StringBuilder
    //   1212: dup
    //   1213: invokespecial 298	java/lang/StringBuilder:<init>	()V
    //   1216: ldc_w 480
    //   1219: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1222: invokestatic 86	java/lang/System:currentTimeMillis	()J
    //   1225: lload 12
    //   1227: lsub
    //   1228: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1231: ldc_w 482
    //   1234: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1237: lload 14
    //   1239: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1242: ldc_w 484
    //   1245: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1248: aload_1
    //   1249: getfield 274	asid:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1252: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1255: invokevirtual 305	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1258: invokestatic 487	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1261: aload 20
    //   1263: ifnull +1391 -> 2654
    //   1266: iload 5
    //   1268: istore 7
    //   1270: iload 4
    //   1272: istore 6
    //   1274: aload 18
    //   1276: astore 21
    //   1278: iload 4
    //   1280: istore 8
    //   1282: aload 18
    //   1284: astore 22
    //   1286: aload 18
    //   1288: astore 23
    //   1290: aload 20
    //   1292: invokevirtual 490	java/io/InputStream:close	()V
    //   1295: iload 5
    //   1297: ifne +49 -> 1346
    //   1300: aload 18
    //   1302: astore 24
    //   1304: aload 17
    //   1306: astore 20
    //   1308: iload 4
    //   1310: istore 6
    //   1312: aload 18
    //   1314: astore 23
    //   1316: aload 17
    //   1318: astore 21
    //   1320: iload 4
    //   1322: istore 8
    //   1324: aload 18
    //   1326: astore 25
    //   1328: aload 17
    //   1330: astore 22
    //   1332: iload 5
    //   1334: istore 7
    //   1336: aload 30
    //   1338: aload_1
    //   1339: getfield 237	asid:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   1342: invokevirtual 494	java/io/File:renameTo	(Ljava/io/File;)Z
    //   1345: pop
    //   1346: aload_3
    //   1347: ifnull +52 -> 1399
    //   1350: aload 18
    //   1352: astore 24
    //   1354: aload 17
    //   1356: astore 20
    //   1358: iload 4
    //   1360: istore 6
    //   1362: aload 18
    //   1364: astore 23
    //   1366: aload 17
    //   1368: astore 21
    //   1370: iload 4
    //   1372: istore 8
    //   1374: aload 18
    //   1376: astore 25
    //   1378: aload 17
    //   1380: astore 22
    //   1382: iload 5
    //   1384: istore 7
    //   1386: aload_3
    //   1387: aload 27
    //   1389: invokevirtual 290	java/net/URL:toString	()Ljava/lang/String;
    //   1392: iload 5
    //   1394: invokeinterface 295 3 0
    //   1399: aload 17
    //   1401: ifnull +10 -> 1411
    //   1404: aload 17
    //   1406: invokeinterface 497 1 0
    //   1411: aload 18
    //   1413: ifnull +1227 -> 2640
    //   1416: aload 18
    //   1418: invokevirtual 498	java/io/OutputStream:close	()V
    //   1421: aload 18
    //   1423: astore 20
    //   1425: aload 17
    //   1427: astore 19
    //   1429: iload 9
    //   1431: iconst_1
    //   1432: iadd
    //   1433: istore 9
    //   1435: invokestatic 215	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1438: ifeq +43 -> 1481
    //   1441: ldc 64
    //   1443: iconst_2
    //   1444: new 297	java/lang/StringBuilder
    //   1447: dup
    //   1448: invokespecial 298	java/lang/StringBuilder:<init>	()V
    //   1451: ldc_w 500
    //   1454: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1457: iload 5
    //   1459: invokevirtual 503	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1462: ldc_w 505
    //   1465: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1468: aload_1
    //   1469: getfield 274	asid:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1472: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1475: invokevirtual 305	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1478: invokestatic 231	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1481: iload 9
    //   1483: iconst_2
    //   1484: if_icmpge +22 -> 1506
    //   1487: iload 5
    //   1489: ifeq +17 -> 1506
    //   1492: aload 28
    //   1494: monitorenter
    //   1495: aload 28
    //   1497: ldc2_w 506
    //   1500: invokevirtual 511	java/lang/Object:wait	(J)V
    //   1503: aload 28
    //   1505: monitorexit
    //   1506: iload 5
    //   1508: istore 6
    //   1510: iload 5
    //   1512: ifeq -1502 -> 10
    //   1515: iload 5
    //   1517: istore 6
    //   1519: iload 9
    //   1521: iconst_2
    //   1522: if_icmpge -1512 -> 10
    //   1525: aload 19
    //   1527: astore 17
    //   1529: aload 20
    //   1531: astore 19
    //   1533: goto -1135 -> 398
    //   1536: bipush 8
    //   1538: istore 8
    //   1540: iload 8
    //   1542: istore 6
    //   1544: iload 8
    //   1546: istore 7
    //   1548: invokestatic 215	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1551: ifeq +62 -> 1613
    //   1554: iload 8
    //   1556: istore 6
    //   1558: iload 8
    //   1560: istore 7
    //   1562: ldc 64
    //   1564: iconst_2
    //   1565: new 297	java/lang/StringBuilder
    //   1568: dup
    //   1569: invokespecial 298	java/lang/StringBuilder:<init>	()V
    //   1572: ldc_w 513
    //   1575: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1578: iload 5
    //   1580: invokevirtual 503	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1583: ldc_w 515
    //   1586: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1589: lload 14
    //   1591: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1594: ldc_w 517
    //   1597: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1600: aload_1
    //   1601: getfield 274	asid:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1604: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1607: invokevirtual 305	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1610: invokestatic 231	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1613: iload 8
    //   1615: istore 5
    //   1617: iload 8
    //   1619: istore 6
    //   1621: iload 8
    //   1623: istore 7
    //   1625: aload 30
    //   1627: invokevirtual 284	java/io/File:exists	()Z
    //   1630: ifeq -634 -> 996
    //   1633: iload 8
    //   1635: istore 6
    //   1637: iload 8
    //   1639: istore 7
    //   1641: aload 30
    //   1643: invokevirtual 383	java/io/File:delete	()Z
    //   1646: pop
    //   1647: iload 8
    //   1649: istore 5
    //   1651: goto -655 -> 996
    //   1654: astore 19
    //   1656: iload 6
    //   1658: istore 5
    //   1660: aload 19
    //   1662: instanceof 519
    //   1665: ifne +15 -> 1680
    //   1668: aload 19
    //   1670: instanceof 521
    //   1673: istore 16
    //   1675: iload 16
    //   1677: ifeq +423 -> 2100
    //   1680: iconst_3
    //   1681: istore 5
    //   1683: aload 20
    //   1685: ifnull +966 -> 2651
    //   1688: aload 20
    //   1690: invokevirtual 490	java/io/InputStream:close	()V
    //   1693: goto -398 -> 1295
    //   1696: iload 5
    //   1698: istore 6
    //   1700: iload 5
    //   1702: istore 7
    //   1704: aload_2
    //   1705: invokestatic 355	com/tencent/mobileqq/utils/NetworkUtil:isMobileNetworkInfo	(Landroid/net/NetworkInfo;)Z
    //   1708: ifeq +316 -> 2024
    //   1711: iload 5
    //   1713: istore 6
    //   1715: iload 5
    //   1717: istore 7
    //   1719: iconst_3
    //   1720: anewarray 310	java/lang/String
    //   1723: astore 19
    //   1725: aload 19
    //   1727: iconst_0
    //   1728: ldc_w 523
    //   1731: aastore
    //   1732: aload 19
    //   1734: iconst_1
    //   1735: ldc_w 463
    //   1738: aastore
    //   1739: aload 19
    //   1741: iconst_2
    //   1742: ldc_w 465
    //   1745: aastore
    //   1746: goto -604 -> 1142
    //   1749: astore 19
    //   1751: iload 7
    //   1753: istore 5
    //   1755: aload 20
    //   1757: ifnull +32 -> 1789
    //   1760: iload 5
    //   1762: istore 7
    //   1764: iload 4
    //   1766: istore 6
    //   1768: aload 18
    //   1770: astore 21
    //   1772: iload 4
    //   1774: istore 8
    //   1776: aload 18
    //   1778: astore 22
    //   1780: aload 18
    //   1782: astore 23
    //   1784: aload 20
    //   1786: invokevirtual 490	java/io/InputStream:close	()V
    //   1789: iload 5
    //   1791: istore 7
    //   1793: iload 4
    //   1795: istore 6
    //   1797: aload 18
    //   1799: astore 21
    //   1801: iload 4
    //   1803: istore 8
    //   1805: aload 18
    //   1807: astore 22
    //   1809: aload 18
    //   1811: astore 23
    //   1813: aload 19
    //   1815: athrow
    //   1816: astore 19
    //   1818: aload 21
    //   1820: astore 18
    //   1822: iload 7
    //   1824: istore 5
    //   1826: aload 17
    //   1828: astore 21
    //   1830: aload 18
    //   1832: astore 20
    //   1834: aload 19
    //   1836: invokevirtual 524	java/io/IOException:printStackTrace	()V
    //   1839: aload 17
    //   1841: astore 21
    //   1843: aload 18
    //   1845: astore 20
    //   1847: aload 19
    //   1849: instanceof 526
    //   1852: ifeq +340 -> 2192
    //   1855: bipush 10
    //   1857: istore 7
    //   1859: aload 17
    //   1861: astore 21
    //   1863: aload 18
    //   1865: astore 20
    //   1867: ldc 64
    //   1869: iconst_2
    //   1870: new 297	java/lang/StringBuilder
    //   1873: dup
    //   1874: invokespecial 298	java/lang/StringBuilder:<init>	()V
    //   1877: ldc_w 528
    //   1880: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1883: iload 7
    //   1885: invokevirtual 503	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1888: ldc_w 530
    //   1891: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1894: aload_1
    //   1895: getfield 274	asid:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1898: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1901: ldc_w 532
    //   1904: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1907: aload 19
    //   1909: invokevirtual 535	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1912: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1915: invokevirtual 305	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1918: invokestatic 538	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1921: aload_3
    //   1922: ifnull +24 -> 1946
    //   1925: aload 17
    //   1927: astore 21
    //   1929: aload 18
    //   1931: astore 20
    //   1933: aload_3
    //   1934: aload 27
    //   1936: invokevirtual 290	java/net/URL:toString	()Ljava/lang/String;
    //   1939: iload 7
    //   1941: invokeinterface 295 3 0
    //   1946: aload 17
    //   1948: ifnull +10 -> 1958
    //   1951: aload 17
    //   1953: invokeinterface 497 1 0
    //   1958: aload 17
    //   1960: astore 19
    //   1962: iload 6
    //   1964: istore 4
    //   1966: aload 18
    //   1968: astore 20
    //   1970: iload 7
    //   1972: istore 5
    //   1974: aload 18
    //   1976: ifnull -547 -> 1429
    //   1979: aload 18
    //   1981: invokevirtual 498	java/io/OutputStream:close	()V
    //   1984: aload 17
    //   1986: astore 19
    //   1988: iload 6
    //   1990: istore 4
    //   1992: aload 18
    //   1994: astore 20
    //   1996: iload 7
    //   1998: istore 5
    //   2000: goto -571 -> 1429
    //   2003: astore 19
    //   2005: aload 17
    //   2007: astore 19
    //   2009: iload 6
    //   2011: istore 4
    //   2013: aload 18
    //   2015: astore 20
    //   2017: iload 7
    //   2019: istore 5
    //   2021: goto -592 -> 1429
    //   2024: iload 5
    //   2026: istore 6
    //   2028: iload 5
    //   2030: istore 7
    //   2032: iconst_3
    //   2033: anewarray 310	java/lang/String
    //   2036: astore 19
    //   2038: aload 19
    //   2040: iconst_0
    //   2041: ldc_w 540
    //   2044: aastore
    //   2045: aload 19
    //   2047: iconst_1
    //   2048: ldc_w 542
    //   2051: aastore
    //   2052: aload 19
    //   2054: iconst_2
    //   2055: ldc_w 465
    //   2058: aastore
    //   2059: goto -917 -> 1142
    //   2062: iload 5
    //   2064: istore 6
    //   2066: iload 5
    //   2068: istore 7
    //   2070: iconst_3
    //   2071: anewarray 310	java/lang/String
    //   2074: astore 19
    //   2076: aload 19
    //   2078: iconst_0
    //   2079: ldc_w 544
    //   2082: aastore
    //   2083: aload 19
    //   2085: iconst_1
    //   2086: ldc_w 542
    //   2089: aastore
    //   2090: aload 19
    //   2092: iconst_2
    //   2093: ldc_w 465
    //   2096: aastore
    //   2097: goto -955 -> 1142
    //   2100: aload 19
    //   2102: instanceof 546
    //   2105: istore 16
    //   2107: iload 16
    //   2109: ifeq +10 -> 2119
    //   2112: bipush 11
    //   2114: istore 5
    //   2116: goto -433 -> 1683
    //   2119: iconst_4
    //   2120: istore 5
    //   2122: goto -439 -> 1683
    //   2125: aload_3
    //   2126: ifnull +36 -> 2162
    //   2129: aload 19
    //   2131: astore 24
    //   2133: aload 17
    //   2135: astore 20
    //   2137: iload 4
    //   2139: istore 6
    //   2141: aload 19
    //   2143: astore 23
    //   2145: aload 17
    //   2147: astore 21
    //   2149: aload_3
    //   2150: aload 27
    //   2152: invokevirtual 290	java/net/URL:toString	()Ljava/lang/String;
    //   2155: iload 5
    //   2157: invokeinterface 295 3 0
    //   2162: aload 19
    //   2164: astore 18
    //   2166: goto -767 -> 1399
    //   2169: astore 19
    //   2171: aload 19
    //   2173: invokevirtual 524	java/io/IOException:printStackTrace	()V
    //   2176: goto -765 -> 1411
    //   2179: astore 19
    //   2181: aload 17
    //   2183: astore 19
    //   2185: aload 18
    //   2187: astore 20
    //   2189: goto -760 -> 1429
    //   2192: aload 17
    //   2194: astore 21
    //   2196: aload 18
    //   2198: astore 20
    //   2200: aload 19
    //   2202: instanceof 519
    //   2205: ifne +461 -> 2666
    //   2208: aload 17
    //   2210: astore 21
    //   2212: aload 18
    //   2214: astore 20
    //   2216: aload 19
    //   2218: instanceof 521
    //   2221: ifeq +6 -> 2227
    //   2224: goto +442 -> 2666
    //   2227: aload 17
    //   2229: astore 21
    //   2231: aload 18
    //   2233: astore 20
    //   2235: aload 19
    //   2237: instanceof 546
    //   2240: ifeq +24 -> 2264
    //   2243: aload 17
    //   2245: astore 21
    //   2247: aload 18
    //   2249: astore 20
    //   2251: aload_1
    //   2252: bipush 11
    //   2254: putfield 548	asid:jdField_b_of_type_Int	I
    //   2257: iload 5
    //   2259: istore 7
    //   2261: goto -402 -> 1859
    //   2264: iconst_4
    //   2265: istore 7
    //   2267: goto -408 -> 1859
    //   2270: astore 19
    //   2272: aload 19
    //   2274: invokevirtual 524	java/io/IOException:printStackTrace	()V
    //   2277: goto -319 -> 1958
    //   2280: astore 19
    //   2282: iload 8
    //   2284: istore 6
    //   2286: aload 22
    //   2288: astore 18
    //   2290: aload 17
    //   2292: astore 21
    //   2294: aload 18
    //   2296: astore 20
    //   2298: aload 19
    //   2300: invokevirtual 549	java/lang/Exception:printStackTrace	()V
    //   2303: iconst_5
    //   2304: istore 7
    //   2306: aload_3
    //   2307: ifnull +23 -> 2330
    //   2310: aload 17
    //   2312: astore 21
    //   2314: aload 18
    //   2316: astore 20
    //   2318: aload_3
    //   2319: aload 27
    //   2321: invokevirtual 290	java/net/URL:toString	()Ljava/lang/String;
    //   2324: iconst_5
    //   2325: invokeinterface 295 3 0
    //   2330: aload 17
    //   2332: ifnull +10 -> 2342
    //   2335: aload 17
    //   2337: invokeinterface 497 1 0
    //   2342: aload 17
    //   2344: astore 19
    //   2346: iload 6
    //   2348: istore 4
    //   2350: aload 18
    //   2352: astore 20
    //   2354: iload 7
    //   2356: istore 5
    //   2358: aload 18
    //   2360: ifnull -931 -> 1429
    //   2363: aload 18
    //   2365: invokevirtual 498	java/io/OutputStream:close	()V
    //   2368: aload 17
    //   2370: astore 19
    //   2372: iload 6
    //   2374: istore 4
    //   2376: aload 18
    //   2378: astore 20
    //   2380: iload 7
    //   2382: istore 5
    //   2384: goto -955 -> 1429
    //   2387: astore 19
    //   2389: aload 17
    //   2391: astore 19
    //   2393: iload 6
    //   2395: istore 4
    //   2397: aload 18
    //   2399: astore 20
    //   2401: iload 7
    //   2403: istore 5
    //   2405: goto -976 -> 1429
    //   2408: astore 19
    //   2410: aload 19
    //   2412: invokevirtual 524	java/io/IOException:printStackTrace	()V
    //   2415: goto -73 -> 2342
    //   2418: astore_0
    //   2419: aload 23
    //   2421: astore_1
    //   2422: aload 17
    //   2424: ifnull +10 -> 2434
    //   2427: aload 17
    //   2429: invokeinterface 497 1 0
    //   2434: aload_1
    //   2435: ifnull +7 -> 2442
    //   2438: aload_1
    //   2439: invokevirtual 498	java/io/OutputStream:close	()V
    //   2442: aload_0
    //   2443: athrow
    //   2444: astore_2
    //   2445: aload_2
    //   2446: invokevirtual 524	java/io/IOException:printStackTrace	()V
    //   2449: goto -15 -> 2434
    //   2452: astore_0
    //   2453: aload 28
    //   2455: monitorexit
    //   2456: aload_0
    //   2457: athrow
    //   2458: astore_1
    //   2459: goto -17 -> 2442
    //   2462: astore 17
    //   2464: goto -961 -> 1503
    //   2467: astore_0
    //   2468: aload 18
    //   2470: astore_1
    //   2471: goto -49 -> 2422
    //   2474: astore_0
    //   2475: aload 24
    //   2477: astore_1
    //   2478: aload 20
    //   2480: astore 17
    //   2482: goto -60 -> 2422
    //   2485: astore_0
    //   2486: aload 21
    //   2488: astore 17
    //   2490: aload 20
    //   2492: astore_1
    //   2493: goto -71 -> 2422
    //   2496: astore 19
    //   2498: iload 4
    //   2500: istore 6
    //   2502: goto -212 -> 2290
    //   2505: astore 19
    //   2507: aload 23
    //   2509: astore 18
    //   2511: aload 21
    //   2513: astore 17
    //   2515: goto -225 -> 2290
    //   2518: astore 19
    //   2520: iload 4
    //   2522: istore 6
    //   2524: goto -698 -> 1826
    //   2527: astore 19
    //   2529: iload 8
    //   2531: istore 6
    //   2533: aload 25
    //   2535: astore 18
    //   2537: aload 22
    //   2539: astore 17
    //   2541: iload 7
    //   2543: istore 5
    //   2545: goto -719 -> 1826
    //   2548: astore 20
    //   2550: aload 19
    //   2552: astore 18
    //   2554: aload 20
    //   2556: astore 19
    //   2558: iload 4
    //   2560: istore 6
    //   2562: goto -736 -> 1826
    //   2565: astore 19
    //   2567: iconst_5
    //   2568: istore 5
    //   2570: goto -815 -> 1755
    //   2573: astore 19
    //   2575: goto -820 -> 1755
    //   2578: astore 21
    //   2580: aconst_null
    //   2581: astore 20
    //   2583: aload 19
    //   2585: astore 18
    //   2587: iconst_5
    //   2588: istore 5
    //   2590: aload 21
    //   2592: astore 19
    //   2594: goto -839 -> 1755
    //   2597: astore 19
    //   2599: aconst_null
    //   2600: astore 20
    //   2602: iconst_5
    //   2603: istore 5
    //   2605: goto -850 -> 1755
    //   2608: astore 19
    //   2610: iconst_5
    //   2611: istore 5
    //   2613: goto -953 -> 1660
    //   2616: astore 21
    //   2618: aload 19
    //   2620: astore 18
    //   2622: iconst_5
    //   2623: istore 5
    //   2625: aload 21
    //   2627: astore 19
    //   2629: goto -969 -> 1660
    //   2632: astore 19
    //   2634: iconst_5
    //   2635: istore 5
    //   2637: goto -977 -> 1660
    //   2640: aload 17
    //   2642: astore 19
    //   2644: aload 18
    //   2646: astore 20
    //   2648: goto -1219 -> 1429
    //   2651: goto -1356 -> 1295
    //   2654: goto -1359 -> 1295
    //   2657: goto -1827 -> 830
    //   2660: goto -1836 -> 824
    //   2663: goto -1571 -> 1092
    //   2666: iconst_2
    //   2667: istore 7
    //   2669: goto -810 -> 1859
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2672	0	paramAppInterface	AppInterface
    //   0	2672	1	paramasid	asid
    //   0	2672	2	paramNetworkInfo	NetworkInfo
    //   0	2672	3	parambhee	bhee
    //   266	2293	4	i	int
    //   263	2373	5	j	int
    //   8	2553	6	k	int
    //   475	2193	7	m	int
    //   463	2067	8	n	int
    //   396	1127	9	i1	int
    //   399	557	10	i2	int
    //   932	28	11	i3	int
    //   29	1197	12	l1	long
    //   782	808	14	l2	long
    //   1673	435	16	bool	boolean
    //   47	2381	17	localObject1	Object
    //   2462	1	17	localInterruptedException	java.lang.InterruptedException
    //   2480	161	17	localObject2	Object
    //   276	573	18	localObject3	Object
    //   888	922	18	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   1820	825	18	localObject4	Object
    //   193	1339	19	localObject5	Object
    //   1654	15	19	localIOException1	java.io.IOException
    //   1723	17	19	arrayOfString	String[]
    //   1749	65	19	localObject6	Object
    //   1816	92	19	localIOException2	java.io.IOException
    //   1960	27	19	localObject7	Object
    //   2003	1	19	localIOException3	java.io.IOException
    //   2007	156	19	localObject8	Object
    //   2169	3	19	localIOException4	java.io.IOException
    //   2179	1	19	localIOException5	java.io.IOException
    //   2183	53	19	localObject9	Object
    //   2270	3	19	localIOException6	java.io.IOException
    //   2280	19	19	localException1	Exception
    //   2344	27	19	localObject10	Object
    //   2387	1	19	localIOException7	java.io.IOException
    //   2391	1	19	localObject11	Object
    //   2408	3	19	localIOException8	java.io.IOException
    //   2496	1	19	localException2	Exception
    //   2505	1	19	localException3	Exception
    //   2518	1	19	localIOException9	java.io.IOException
    //   2527	24	19	localIOException10	java.io.IOException
    //   2556	1	19	localObject12	Object
    //   2565	1	19	localObject13	Object
    //   2573	11	19	localObject14	Object
    //   2592	1	19	localObject15	Object
    //   2597	1	19	localObject16	Object
    //   2608	11	19	localIOException11	java.io.IOException
    //   2627	1	19	localObject17	Object
    //   2632	1	19	localIOException12	java.io.IOException
    //   2642	1	19	localObject18	Object
    //   447	2044	20	localObject19	Object
    //   2548	7	20	localIOException13	java.io.IOException
    //   2581	66	20	localObject20	Object
    //   459	2053	21	localObject21	Object
    //   2578	13	21	localObject22	Object
    //   2616	10	21	localIOException14	java.io.IOException
    //   471	2067	22	localObject23	Object
    //   455	2053	23	localObject24	Object
    //   443	2033	24	localObject25	Object
    //   467	2067	25	localObject26	Object
    //   210	693	26	localHttpGet	org.apache.http.client.methods.HttpGet
    //   24	2296	27	localURL	URL
    //   38	2416	28	localObject27	Object
    //   219	218	29	localBasicHttpParams	BasicHttpParams
    //   376	1266	30	localFile	File
    //   542	83	31	localStatusLine	org.apache.http.StatusLine
    // Exception table:
    //   from	to	target	type
    //   13	26	123	java/net/MalformedURLException
    //   40	49	138	java/lang/Exception
    //   54	70	138	java/lang/Exception
    //   74	86	138	java/lang/Exception
    //   86	121	138	java/lang/Exception
    //   201	212	888	java/lang/IllegalArgumentException
    //   890	904	907	java/lang/IllegalArgumentException
    //   949	955	1654	java/io/IOException
    //   963	992	1654	java/io/IOException
    //   1004	1010	1654	java/io/IOException
    //   1018	1060	1654	java/io/IOException
    //   1068	1092	1654	java/io/IOException
    //   1100	1107	1654	java/io/IOException
    //   1115	1121	1654	java/io/IOException
    //   1155	1167	1654	java/io/IOException
    //   1175	1184	1654	java/io/IOException
    //   1192	1198	1654	java/io/IOException
    //   1206	1261	1654	java/io/IOException
    //   1548	1554	1654	java/io/IOException
    //   1562	1613	1654	java/io/IOException
    //   1625	1633	1654	java/io/IOException
    //   1641	1647	1654	java/io/IOException
    //   1704	1711	1654	java/io/IOException
    //   1719	1725	1654	java/io/IOException
    //   2032	2038	1654	java/io/IOException
    //   2070	2076	1654	java/io/IOException
    //   949	955	1749	finally
    //   963	992	1749	finally
    //   1004	1010	1749	finally
    //   1018	1060	1749	finally
    //   1068	1092	1749	finally
    //   1100	1107	1749	finally
    //   1115	1121	1749	finally
    //   1155	1167	1749	finally
    //   1175	1184	1749	finally
    //   1192	1198	1749	finally
    //   1206	1261	1749	finally
    //   1548	1554	1749	finally
    //   1562	1613	1749	finally
    //   1625	1633	1749	finally
    //   1641	1647	1749	finally
    //   1704	1711	1749	finally
    //   1719	1725	1749	finally
    //   2032	2038	1749	finally
    //   2070	2076	1749	finally
    //   1290	1295	1816	java/io/IOException
    //   1784	1789	1816	java/io/IOException
    //   1813	1816	1816	java/io/IOException
    //   1979	1984	2003	java/io/IOException
    //   1404	1411	2169	java/io/IOException
    //   1416	1421	2179	java/io/IOException
    //   1951	1958	2270	java/io/IOException
    //   1290	1295	2280	java/lang/Exception
    //   1784	1789	2280	java/lang/Exception
    //   1813	1816	2280	java/lang/Exception
    //   2363	2368	2387	java/io/IOException
    //   2335	2342	2408	java/io/IOException
    //   1290	1295	2418	finally
    //   1784	1789	2418	finally
    //   1813	1816	2418	finally
    //   2427	2434	2444	java/io/IOException
    //   1495	1503	2452	finally
    //   1503	1506	2452	finally
    //   2453	2456	2452	finally
    //   2438	2442	2458	java/io/IOException
    //   1495	1503	2462	java/lang/InterruptedException
    //   1688	1693	2467	finally
    //   477	499	2474	finally
    //   535	544	2474	finally
    //   580	588	2474	finally
    //   624	633	2474	finally
    //   673	686	2474	finally
    //   722	731	2474	finally
    //   775	784	2474	finally
    //   1336	1346	2474	finally
    //   1386	1399	2474	finally
    //   2149	2162	2474	finally
    //   1834	1839	2485	finally
    //   1847	1855	2485	finally
    //   1867	1921	2485	finally
    //   1933	1946	2485	finally
    //   2200	2208	2485	finally
    //   2216	2224	2485	finally
    //   2235	2243	2485	finally
    //   2251	2257	2485	finally
    //   2298	2303	2485	finally
    //   2318	2330	2485	finally
    //   1688	1693	2496	java/lang/Exception
    //   477	499	2505	java/lang/Exception
    //   535	544	2505	java/lang/Exception
    //   580	588	2505	java/lang/Exception
    //   624	633	2505	java/lang/Exception
    //   673	686	2505	java/lang/Exception
    //   722	731	2505	java/lang/Exception
    //   775	784	2505	java/lang/Exception
    //   1336	1346	2505	java/lang/Exception
    //   1386	1399	2505	java/lang/Exception
    //   2149	2162	2505	java/lang/Exception
    //   1688	1693	2518	java/io/IOException
    //   477	499	2527	java/io/IOException
    //   535	544	2527	java/io/IOException
    //   580	588	2527	java/io/IOException
    //   624	633	2527	java/io/IOException
    //   673	686	2527	java/io/IOException
    //   722	731	2527	java/io/IOException
    //   775	784	2527	java/io/IOException
    //   1336	1346	2527	java/io/IOException
    //   1386	1399	2527	java/io/IOException
    //   2149	2162	2548	java/io/IOException
    //   824	830	2565	finally
    //   839	858	2565	finally
    //   869	885	2565	finally
    //   1660	1675	2573	finally
    //   2100	2107	2573	finally
    //   790	801	2578	finally
    //   801	810	2597	finally
    //   824	830	2608	java/io/IOException
    //   839	858	2608	java/io/IOException
    //   869	885	2608	java/io/IOException
    //   790	801	2616	java/io/IOException
    //   801	810	2632	java/io/IOException
  }
  
  public static int download(AppInterface paramAppInterface, URL paramURL, File paramFile, NetworkInfo paramNetworkInfo)
  {
    return download(paramAppInterface, paramURL, paramFile, paramNetworkInfo, 2);
  }
  
  /* Error */
  private static int download(AppInterface paramAppInterface, URL paramURL, File paramFile, NetworkInfo paramNetworkInfo, int paramInt)
  {
    // Byte code:
    //   0: invokestatic 86	java/lang/System:currentTimeMillis	()J
    //   3: lstore 14
    //   5: iconst_5
    //   6: istore 5
    //   8: new 4	java/lang/Object
    //   11: dup
    //   12: invokespecial 223	java/lang/Object:<init>	()V
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
    //   37: invokevirtual 281	java/io/File:getParentFile	()Ljava/io/File;
    //   40: astore_0
    //   41: aload_0
    //   42: ifnull +15 -> 57
    //   45: aload_0
    //   46: invokevirtual 284	java/io/File:exists	()Z
    //   49: ifne +8 -> 57
    //   52: aload_0
    //   53: invokevirtual 287	java/io/File:mkdirs	()Z
    //   56: pop
    //   57: aconst_null
    //   58: astore_0
    //   59: aload_1
    //   60: invokevirtual 290	java/net/URL:toString	()Ljava/lang/String;
    //   63: astore 19
    //   65: new 318	org/apache/http/client/methods/HttpGet
    //   68: dup
    //   69: aload 19
    //   71: invokespecial 319	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   74: astore 27
    //   76: new 90	org/apache/http/params/BasicHttpParams
    //   79: dup
    //   80: invokespecial 93	org/apache/http/params/BasicHttpParams:<init>	()V
    //   83: astore 30
    //   85: sipush 20000
    //   88: istore 5
    //   90: ldc_w 322
    //   93: istore 4
    //   95: aload_3
    //   96: ifnull +105 -> 201
    //   99: invokestatic 340	android/net/Proxy:getDefaultHost	()Ljava/lang/String;
    //   102: astore 19
    //   104: invokestatic 344	android/net/Proxy:getDefaultPort	()I
    //   107: istore 4
    //   109: aload_3
    //   110: invokevirtual 349	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   113: astore 20
    //   115: aload_3
    //   116: invokestatic 355	com/tencent/mobileqq/utils/NetworkUtil:isMobileNetworkInfo	(Landroid/net/NetworkInfo;)Z
    //   119: ifeq +51 -> 170
    //   122: aload 20
    //   124: ifnull +14 -> 138
    //   127: aload 20
    //   129: ldc_w 357
    //   132: invokevirtual 361	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   135: ifeq +35 -> 170
    //   138: aload 19
    //   140: ifnull +30 -> 170
    //   143: iload 4
    //   145: ifle +25 -> 170
    //   148: aload 30
    //   150: ldc_w 363
    //   153: new 365	org/apache/http/HttpHost
    //   156: dup
    //   157: aload 19
    //   159: iload 4
    //   161: invokespecial 367	org/apache/http/HttpHost:<init>	(Ljava/lang/String;I)V
    //   164: invokeinterface 333 3 0
    //   169: pop
    //   170: aload_3
    //   171: invokestatic 355	com/tencent/mobileqq/utils/NetworkUtil:isMobileNetworkInfo	(Landroid/net/NetworkInfo;)Z
    //   174: ifeq +903 -> 1077
    //   177: sipush 20000
    //   180: istore 5
    //   182: ldc_w 322
    //   185: istore 4
    //   187: aload 30
    //   189: ldc_w 369
    //   192: sipush 2048
    //   195: invokeinterface 373 3 0
    //   200: pop
    //   201: aload 30
    //   203: ldc_w 321
    //   206: iload 5
    //   208: invokestatic 327	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   211: invokeinterface 333 3 0
    //   216: pop
    //   217: aload 30
    //   219: ldc_w 335
    //   222: iload 4
    //   224: invokestatic 327	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   227: invokeinterface 333 3 0
    //   232: pop
    //   233: aload 27
    //   235: aload 30
    //   237: invokevirtual 377	org/apache/http/client/methods/HttpGet:setParams	(Lorg/apache/http/params/HttpParams;)V
    //   240: aload_2
    //   241: invokevirtual 284	java/io/File:exists	()Z
    //   244: ifeq +8 -> 252
    //   247: aload_2
    //   248: invokevirtual 383	java/io/File:delete	()Z
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
    //   270: ldc_w 363
    //   273: new 365	org/apache/http/HttpHost
    //   276: dup
    //   277: aload_1
    //   278: invokevirtual 386	java/net/URL:getHost	()Ljava/lang/String;
    //   281: aload_1
    //   282: invokevirtual 389	java/net/URL:getPort	()I
    //   285: invokespecial 367	org/apache/http/HttpHost:<init>	(Ljava/lang/String;I)V
    //   288: invokeinterface 333 3 0
    //   293: pop
    //   294: aload 27
    //   296: aload 30
    //   298: invokevirtual 377	org/apache/http/client/methods/HttpGet:setParams	(Lorg/apache/http/params/HttpParams;)V
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
    //   328: getstatic 173	com/tencent/mobileqq/utils/HttpDownloadUtil:client	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   331: new 365	org/apache/http/HttpHost
    //   334: dup
    //   335: aload_1
    //   336: invokevirtual 386	java/net/URL:getHost	()Ljava/lang/String;
    //   339: invokespecial 390	org/apache/http/HttpHost:<init>	(Ljava/lang/String;)V
    //   342: aload 27
    //   344: invokevirtual 394	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/HttpHost;Lorg/apache/http/HttpRequest;)Lorg/apache/http/HttpResponse;
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
    //   375: invokeinterface 400 1 0
    //   380: invokeinterface 409 1 0
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
    //   413: invokeinterface 415 1 0
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
    //   452: invokeinterface 420 1 0
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
    //   480: new 559	java/io/BufferedOutputStream
    //   483: dup
    //   484: new 422	java/io/FileOutputStream
    //   487: dup
    //   488: aload_2
    //   489: invokespecial 425	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   492: invokespecial 562	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
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
    //   520: invokeinterface 565 2 0
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
    //   547: invokevirtual 568	java/io/OutputStream:flush	()V
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
    //   571: invokevirtual 571	java/io/File:length	()J
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
    //   597: invokestatic 86	java/lang/System:currentTimeMillis	()J
    //   600: invokevirtual 478	java/io/File:setLastModified	(J)Z
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
    //   624: invokestatic 215	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
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
    //   650: ldc 64
    //   652: iconst_2
    //   653: new 297	java/lang/StringBuilder
    //   656: dup
    //   657: invokespecial 298	java/lang/StringBuilder:<init>	()V
    //   660: ldc_w 480
    //   663: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   666: invokestatic 86	java/lang/System:currentTimeMillis	()J
    //   669: lload 14
    //   671: lsub
    //   672: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   675: ldc_w 573
    //   678: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   681: lload 8
    //   683: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   686: ldc_w 484
    //   689: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   692: aload_1
    //   693: invokevirtual 576	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   696: invokevirtual 305	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   699: invokestatic 487	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   731: invokestatic 215	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   734: ifeq +53 -> 787
    //   737: ldc 64
    //   739: iconst_2
    //   740: new 297	java/lang/StringBuilder
    //   743: dup
    //   744: invokespecial 298	java/lang/StringBuilder:<init>	()V
    //   747: ldc_w 578
    //   750: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   753: lload 16
    //   755: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   758: ldc_w 580
    //   761: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   764: aload_2
    //   765: invokevirtual 571	java/io/File:length	()J
    //   768: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   771: ldc_w 505
    //   774: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   777: aload_1
    //   778: invokevirtual 576	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   781: invokevirtual 305	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   784: invokestatic 538	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   787: bipush 8
    //   789: istore 5
    //   791: iload 5
    //   793: istore 4
    //   795: aload_0
    //   796: ifnull +9 -> 805
    //   799: aload_0
    //   800: invokeinterface 497 1 0
    //   805: aload_3
    //   806: ifnull +7 -> 813
    //   809: aload_3
    //   810: invokevirtual 498	java/io/OutputStream:close	()V
    //   813: iload 4
    //   815: ifeq +1368 -> 2183
    //   818: aload_2
    //   819: invokevirtual 281	java/io/File:getParentFile	()Ljava/io/File;
    //   822: astore 19
    //   824: aload 19
    //   826: ifnull +17 -> 843
    //   829: aload 19
    //   831: invokevirtual 284	java/io/File:exists	()Z
    //   834: ifne +9 -> 843
    //   837: aload 19
    //   839: invokevirtual 287	java/io/File:mkdirs	()Z
    //   842: pop
    //   843: aload_2
    //   844: invokevirtual 284	java/io/File:exists	()Z
    //   847: ifeq +36 -> 883
    //   850: aload_2
    //   851: invokevirtual 383	java/io/File:delete	()Z
    //   854: istore 18
    //   856: ldc 64
    //   858: iconst_1
    //   859: new 297	java/lang/StringBuilder
    //   862: dup
    //   863: invokespecial 298	java/lang/StringBuilder:<init>	()V
    //   866: ldc_w 582
    //   869: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   872: iload 18
    //   874: invokevirtual 585	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   877: invokevirtual 305	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   880: invokestatic 231	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   883: iload 7
    //   885: iconst_1
    //   886: iadd
    //   887: istore 7
    //   889: invokestatic 215	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   892: ifeq +40 -> 932
    //   895: ldc 64
    //   897: iconst_2
    //   898: new 297	java/lang/StringBuilder
    //   901: dup
    //   902: invokespecial 298	java/lang/StringBuilder:<init>	()V
    //   905: ldc_w 500
    //   908: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   911: iload 4
    //   913: invokevirtual 503	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   916: ldc_w 505
    //   919: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   922: aload_1
    //   923: invokevirtual 576	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   926: invokevirtual 305	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   929: invokestatic 231	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   932: iload 4
    //   934: ifeq +51 -> 985
    //   937: ldc 64
    //   939: iconst_1
    //   940: new 297	java/lang/StringBuilder
    //   943: dup
    //   944: invokespecial 298	java/lang/StringBuilder:<init>	()V
    //   947: ldc_w 500
    //   950: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   953: iload 4
    //   955: invokevirtual 503	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   958: ldc_w 505
    //   961: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   964: aload_1
    //   965: invokevirtual 576	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   968: ldc_w 587
    //   971: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   974: iload 7
    //   976: invokevirtual 503	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   979: invokevirtual 305	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   982: invokestatic 231	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   985: iload 4
    //   987: ifeq +23 -> 1010
    //   990: iload 7
    //   992: iconst_2
    //   993: if_icmpge +17 -> 1010
    //   996: aload 29
    //   998: monitorenter
    //   999: aload 29
    //   1001: ldc2_w 588
    //   1004: invokevirtual 511	java/lang/Object:wait	(J)V
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
    //   1034: ldc 64
    //   1036: iconst_1
    //   1037: ldc_w 591
    //   1040: invokestatic 231	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1043: iconst_4
    //   1044: ireturn
    //   1045: astore 20
    //   1047: new 318	org/apache/http/client/methods/HttpGet
    //   1050: dup
    //   1051: aload 19
    //   1053: invokestatic 447	com/tencent/mobileqq/utils/HttpDownloadUtil:getEscapeSequence	(Ljava/lang/String;)Ljava/lang/String;
    //   1056: invokespecial 319	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   1059: astore 27
    //   1061: goto -985 -> 76
    //   1064: astore_0
    //   1065: ldc 64
    //   1067: iconst_1
    //   1068: ldc_w 593
    //   1071: invokestatic 231	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1074: bipush 13
    //   1076: ireturn
    //   1077: sipush 10000
    //   1080: istore 5
    //   1082: sipush 30000
    //   1085: istore 4
    //   1087: aload 30
    //   1089: ldc_w 369
    //   1092: sipush 4096
    //   1095: invokeinterface 373 3 0
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
    //   1121: ldc 64
    //   1123: iconst_1
    //   1124: new 297	java/lang/StringBuilder
    //   1127: dup
    //   1128: invokespecial 298	java/lang/StringBuilder:<init>	()V
    //   1131: ldc_w 595
    //   1134: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1137: aload_2
    //   1138: invokevirtual 284	java/io/File:exists	()Z
    //   1141: invokevirtual 585	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1144: ldc_w 597
    //   1147: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1150: aload_2
    //   1151: invokevirtual 281	java/io/File:getParentFile	()Ljava/io/File;
    //   1154: invokevirtual 284	java/io/File:exists	()Z
    //   1157: invokevirtual 585	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1160: invokevirtual 305	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1163: invokestatic 231	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   1205: invokestatic 215	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
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
    //   1235: ldc 64
    //   1237: iconst_2
    //   1238: aload 28
    //   1240: invokevirtual 535	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1243: aload 28
    //   1245: invokestatic 599	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1248: iconst_4
    //   1249: istore 4
    //   1251: goto -543 -> 708
    //   1254: iload 5
    //   1256: istore 4
    //   1258: goto -463 -> 795
    //   1261: astore 19
    //   1263: aload 19
    //   1265: invokevirtual 524	java/io/IOException:printStackTrace	()V
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
    //   1290: invokestatic 215	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1293: ifeq +30 -> 1323
    //   1296: ldc 64
    //   1298: iconst_2
    //   1299: new 297	java/lang/StringBuilder
    //   1302: dup
    //   1303: invokespecial 298	java/lang/StringBuilder:<init>	()V
    //   1306: ldc_w 601
    //   1309: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1312: aload_1
    //   1313: invokevirtual 576	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1316: invokevirtual 305	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1319: aload_0
    //   1320: invokestatic 599	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1323: aload_0
    //   1324: instanceof 526
    //   1327: istore 18
    //   1329: iload 18
    //   1331: ifeq +142 -> 1473
    //   1334: bipush 10
    //   1336: istore 5
    //   1338: aload 19
    //   1340: ifnull +10 -> 1350
    //   1343: aload 19
    //   1345: invokeinterface 497 1 0
    //   1350: aload 20
    //   1352: ifnull +8 -> 1360
    //   1355: aload 20
    //   1357: invokevirtual 498	java/io/OutputStream:close	()V
    //   1360: aload 19
    //   1362: astore_0
    //   1363: aload 20
    //   1365: astore_3
    //   1366: iload 5
    //   1368: istore 4
    //   1370: iload 5
    //   1372: ifeq -489 -> 883
    //   1375: aload_2
    //   1376: invokevirtual 281	java/io/File:getParentFile	()Ljava/io/File;
    //   1379: astore_0
    //   1380: aload_0
    //   1381: ifnull +15 -> 1396
    //   1384: aload_0
    //   1385: invokevirtual 284	java/io/File:exists	()Z
    //   1388: ifne +8 -> 1396
    //   1391: aload_0
    //   1392: invokevirtual 287	java/io/File:mkdirs	()Z
    //   1395: pop
    //   1396: aload 19
    //   1398: astore_0
    //   1399: aload 20
    //   1401: astore_3
    //   1402: iload 5
    //   1404: istore 4
    //   1406: aload_2
    //   1407: invokevirtual 284	java/io/File:exists	()Z
    //   1410: ifeq -527 -> 883
    //   1413: aload_2
    //   1414: invokevirtual 383	java/io/File:delete	()Z
    //   1417: istore 18
    //   1419: ldc 64
    //   1421: iconst_1
    //   1422: new 297	java/lang/StringBuilder
    //   1425: dup
    //   1426: invokespecial 298	java/lang/StringBuilder:<init>	()V
    //   1429: ldc_w 582
    //   1432: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1435: iload 18
    //   1437: invokevirtual 585	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1440: invokevirtual 305	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1443: invokestatic 231	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   1474: instanceof 519
    //   1477: ifne +709 -> 2186
    //   1480: aload_0
    //   1481: instanceof 521
    //   1484: ifeq +6 -> 1490
    //   1487: goto +699 -> 2186
    //   1490: aload_0
    //   1491: instanceof 546
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
    //   1516: invokevirtual 524	java/io/IOException:printStackTrace	()V
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
    //   1547: invokestatic 215	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1550: ifeq +41 -> 1591
    //   1553: aload 19
    //   1555: astore_0
    //   1556: aload 20
    //   1558: astore_3
    //   1559: iload 5
    //   1561: istore 4
    //   1563: ldc 64
    //   1565: iconst_2
    //   1566: new 297	java/lang/StringBuilder
    //   1569: dup
    //   1570: invokespecial 298	java/lang/StringBuilder:<init>	()V
    //   1573: ldc_w 603
    //   1576: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1579: aload_1
    //   1580: invokevirtual 576	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1583: invokevirtual 305	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1586: aload 21
    //   1588: invokestatic 599	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1591: iconst_5
    //   1592: istore 5
    //   1594: aload 19
    //   1596: ifnull +10 -> 1606
    //   1599: aload 19
    //   1601: invokeinterface 497 1 0
    //   1606: aload 20
    //   1608: ifnull +8 -> 1616
    //   1611: aload 20
    //   1613: invokevirtual 498	java/io/OutputStream:close	()V
    //   1616: aload_2
    //   1617: invokevirtual 281	java/io/File:getParentFile	()Ljava/io/File;
    //   1620: astore_0
    //   1621: aload_0
    //   1622: ifnull +15 -> 1637
    //   1625: aload_0
    //   1626: invokevirtual 284	java/io/File:exists	()Z
    //   1629: ifne +8 -> 1637
    //   1632: aload_0
    //   1633: invokevirtual 287	java/io/File:mkdirs	()Z
    //   1636: pop
    //   1637: aload 19
    //   1639: astore_0
    //   1640: aload 20
    //   1642: astore_3
    //   1643: iload 5
    //   1645: istore 4
    //   1647: aload_2
    //   1648: invokevirtual 284	java/io/File:exists	()Z
    //   1651: ifeq -768 -> 883
    //   1654: aload_2
    //   1655: invokevirtual 383	java/io/File:delete	()Z
    //   1658: istore 18
    //   1660: ldc 64
    //   1662: iconst_1
    //   1663: new 297	java/lang/StringBuilder
    //   1666: dup
    //   1667: invokespecial 298	java/lang/StringBuilder:<init>	()V
    //   1670: ldc_w 582
    //   1673: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1676: iload 18
    //   1678: invokevirtual 585	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1681: invokevirtual 305	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1684: invokestatic 231	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   1716: invokevirtual 524	java/io/IOException:printStackTrace	()V
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
    //   1745: invokestatic 215	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1748: ifeq +41 -> 1789
    //   1751: aload 19
    //   1753: astore_0
    //   1754: aload 20
    //   1756: astore_3
    //   1757: iload 5
    //   1759: istore 4
    //   1761: ldc 64
    //   1763: iconst_2
    //   1764: new 297	java/lang/StringBuilder
    //   1767: dup
    //   1768: invokespecial 298	java/lang/StringBuilder:<init>	()V
    //   1771: ldc_w 603
    //   1774: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1777: aload_1
    //   1778: invokevirtual 576	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1781: invokevirtual 305	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1784: aload 21
    //   1786: invokestatic 599	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1789: iconst_5
    //   1790: istore 5
    //   1792: aload 19
    //   1794: ifnull +10 -> 1804
    //   1797: aload 19
    //   1799: invokeinterface 497 1 0
    //   1804: aload 20
    //   1806: ifnull +8 -> 1814
    //   1809: aload 20
    //   1811: invokevirtual 498	java/io/OutputStream:close	()V
    //   1814: aload_2
    //   1815: invokevirtual 281	java/io/File:getParentFile	()Ljava/io/File;
    //   1818: astore_0
    //   1819: aload_0
    //   1820: ifnull +15 -> 1835
    //   1823: aload_0
    //   1824: invokevirtual 284	java/io/File:exists	()Z
    //   1827: ifne +8 -> 1835
    //   1830: aload_0
    //   1831: invokevirtual 287	java/io/File:mkdirs	()Z
    //   1834: pop
    //   1835: aload 19
    //   1837: astore_0
    //   1838: aload 20
    //   1840: astore_3
    //   1841: iload 5
    //   1843: istore 4
    //   1845: aload_2
    //   1846: invokevirtual 284	java/io/File:exists	()Z
    //   1849: ifeq -966 -> 883
    //   1852: aload_2
    //   1853: invokevirtual 383	java/io/File:delete	()Z
    //   1856: istore 18
    //   1858: ldc 64
    //   1860: iconst_1
    //   1861: new 297	java/lang/StringBuilder
    //   1864: dup
    //   1865: invokespecial 298	java/lang/StringBuilder:<init>	()V
    //   1868: ldc_w 582
    //   1871: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1874: iload 18
    //   1876: invokevirtual 585	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1879: invokevirtual 305	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1882: invokestatic 231	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   1914: invokevirtual 524	java/io/IOException:printStackTrace	()V
    //   1917: goto -113 -> 1804
    //   1920: astore_1
    //   1921: aload 20
    //   1923: astore_3
    //   1924: aload_0
    //   1925: ifnull +9 -> 1934
    //   1928: aload_0
    //   1929: invokeinterface 497 1 0
    //   1934: aload_3
    //   1935: ifnull +7 -> 1942
    //   1938: aload_3
    //   1939: invokevirtual 498	java/io/OutputStream:close	()V
    //   1942: iload 4
    //   1944: ifeq +64 -> 2008
    //   1947: aload_2
    //   1948: invokevirtual 281	java/io/File:getParentFile	()Ljava/io/File;
    //   1951: astore_0
    //   1952: aload_0
    //   1953: ifnull +15 -> 1968
    //   1956: aload_0
    //   1957: invokevirtual 284	java/io/File:exists	()Z
    //   1960: ifne +8 -> 1968
    //   1963: aload_0
    //   1964: invokevirtual 287	java/io/File:mkdirs	()Z
    //   1967: pop
    //   1968: aload_2
    //   1969: invokevirtual 284	java/io/File:exists	()Z
    //   1972: ifeq +36 -> 2008
    //   1975: aload_2
    //   1976: invokevirtual 383	java/io/File:delete	()Z
    //   1979: istore 18
    //   1981: ldc 64
    //   1983: iconst_1
    //   1984: new 297	java/lang/StringBuilder
    //   1987: dup
    //   1988: invokespecial 298	java/lang/StringBuilder:<init>	()V
    //   1991: ldc_w 582
    //   1994: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1997: iload 18
    //   1999: invokevirtual 585	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2002: invokevirtual 305	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2005: invokestatic 231	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2008: aload_1
    //   2009: athrow
    //   2010: astore_0
    //   2011: aload_0
    //   2012: invokevirtual 524	java/io/IOException:printStackTrace	()V
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
    //   0	2192	0	paramAppInterface	AppInterface
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
    //   1282	618	19	localAppInterface1	AppInterface
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
    //   2092	1	21	localAppInterface2	AppInterface
    //   2101	1	21	localThrowable2	java.lang.Throwable
    //   2116	1	21	localException2	Exception
    //   2133	1	21	localException3	Exception
    //   2159	9	21	localIOException4	java.io.IOException
    //   320	1803	22	localObject7	Object
    //   308	1748	23	localNetworkInfo1	NetworkInfo
    //   311	1773	24	localAppInterface3	AppInterface
    //   317	1802	25	localAppInterface4	AppInterface
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
  
  public static boolean download(AppInterface paramAppInterface, String paramString, File paramFile)
  {
    return downloadData(paramAppInterface, paramString, paramFile) == 0;
  }
  
  public static boolean download(AppInterface paramAppInterface, URL paramURL, File paramFile)
  {
    return download(paramAppInterface, paramURL, paramFile, AppNetConnInfo.getRecentNetworkInfo(), 2) == 0;
  }
  
  public static int downloadData(AppInterface paramAppInterface, asid paramasid, bhee parambhee)
  {
    NetworkInfo localNetworkInfo = AppNetConnInfo.getRecentNetworkInfo();
    if (localNetworkInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("HttpDownloadUtil", 2, "Download failed-----------activeNetworkInfo is null");
      }
      return 9;
    }
    return download(paramAppInterface, paramasid, localNetworkInfo, parambhee);
  }
  
  public static int downloadData(AppInterface paramAppInterface, String paramString, File paramFile)
  {
    return downloadData(paramAppInterface, paramString, paramFile, 2);
  }
  
  public static int downloadData(AppInterface paramAppInterface, String paramString, File paramFile, int paramInt)
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
      return download(paramAppInterface, paramString, paramFile, localNetworkInfo, paramInt);
    }
    catch (MalformedURLException paramAppInterface)
    {
      paramAppInterface.printStackTrace();
    }
    return 5;
  }
  
  private static boolean emoNeed2Try(asid paramasid, int paramInt1, int paramInt2)
  {
    if (paramasid == null) {
      if (paramInt1 > paramInt2) {}
    }
    while ((paramasid.jdField_b_of_type_Int != 0) && (paramInt1 <= paramInt2) && (paramasid.jdField_b_of_type_Int != 16) && (paramasid.jdField_b_of_type_Int != 6) && (NetworkUtil.isNetSupport(BaseApplication.getContext())))
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
  
  public static asid queryDownloadInfo(String paramString, bhed parambhed)
  {
    return queryDownloadInfo(paramString, parambhed, null, 2, true);
  }
  
  public static asid queryDownloadInfo(String paramString, bhed parambhed, List<Header> paramList, int paramInt, boolean paramBoolean)
  {
    int i = NetworkCenter.getInstance().getNetType();
    return queryDownloadInfo(paramString, parambhed, paramList, paramInt, paramBoolean, 0, bhef.b(i), bhef.a(i));
  }
  
  public static asid queryDownloadInfo(String paramString, bhed parambhed, List<Header> paramList, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3)
  {
    return queryDownloadInfo(paramString, parambhed, paramList, paramInt1, paramBoolean, 0, paramInt2, paramInt3);
  }
  
  /* Error */
  private static asid queryDownloadInfo(String paramString, bhed parambhed, List<Header> paramList, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, int paramInt4)
  {
    // Byte code:
    //   0: new 233	asid
    //   3: dup
    //   4: aload_0
    //   5: aconst_null
    //   6: iconst_0
    //   7: invokespecial 682	asid:<init>	(Ljava/lang/String;Ljava/io/File;I)V
    //   10: astore 20
    //   12: iload 5
    //   14: iconst_3
    //   15: if_icmplt +30 -> 45
    //   18: invokestatic 215	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   21: ifeq +12 -> 33
    //   24: ldc 64
    //   26: iconst_2
    //   27: ldc_w 684
    //   30: invokestatic 538	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   33: aload 20
    //   35: bipush 20
    //   37: putfield 548	asid:jdField_b_of_type_Int	I
    //   40: aload 20
    //   42: astore_0
    //   43: aload_0
    //   44: areturn
    //   45: new 271	java/net/URL
    //   48: dup
    //   49: aload 20
    //   51: getfield 274	asid:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   54: invokespecial 275	java/net/URL:<init>	(Ljava/lang/String;)V
    //   57: pop
    //   58: aload 20
    //   60: getfield 274	asid:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   63: astore 18
    //   65: new 318	org/apache/http/client/methods/HttpGet
    //   68: dup
    //   69: aload 18
    //   71: invokespecial 319	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   74: pop
    //   75: new 4	java/lang/Object
    //   78: dup
    //   79: invokespecial 223	java/lang/Object:<init>	()V
    //   82: astore 21
    //   84: aconst_null
    //   85: astore 14
    //   87: iconst_0
    //   88: istore 9
    //   90: ldc2_w 506
    //   93: lstore 11
    //   95: invokestatic 615	com/tencent/mobileqq/msf/sdk/AppNetConnInfo:getRecentNetworkInfo	()Landroid/net/NetworkInfo;
    //   98: astore 22
    //   100: aload 22
    //   102: ifnonnull +196 -> 298
    //   105: invokestatic 215	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   108: ifeq +12 -> 120
    //   111: ldc 64
    //   113: iconst_2
    //   114: ldc_w 686
    //   117: invokestatic 538	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   120: aload 20
    //   122: iconst_1
    //   123: putfield 548	asid:jdField_b_of_type_Int	I
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
    //   145: invokeinterface 691 2 0
    //   150: pop
    //   151: aload 20
    //   153: areturn
    //   154: astore_0
    //   155: invokestatic 215	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   158: ifeq +13 -> 171
    //   161: ldc 64
    //   163: iconst_2
    //   164: aload_0
    //   165: invokevirtual 692	java/net/MalformedURLException:toString	()Ljava/lang/String;
    //   168: invokestatic 538	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   171: aload 20
    //   173: aload_0
    //   174: invokestatic 314	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   177: putfield 316	asid:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   180: aload 20
    //   182: bipush 13
    //   184: putfield 548	asid:jdField_b_of_type_Int	I
    //   187: aload_1
    //   188: ifnull +12 -> 200
    //   191: aload_1
    //   192: aload 20
    //   194: invokeinterface 691 2 0
    //   199: pop
    //   200: aload 20
    //   202: areturn
    //   203: astore 14
    //   205: new 318	org/apache/http/client/methods/HttpGet
    //   208: dup
    //   209: aload 18
    //   211: invokestatic 447	com/tencent/mobileqq/utils/HttpDownloadUtil:getEscapeSequence	(Ljava/lang/String;)Ljava/lang/String;
    //   214: invokespecial 319	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   217: pop
    //   218: aload 18
    //   220: invokestatic 447	com/tencent/mobileqq/utils/HttpDownloadUtil:getEscapeSequence	(Ljava/lang/String;)Ljava/lang/String;
    //   223: astore 18
    //   225: goto -150 -> 75
    //   228: astore_0
    //   229: invokestatic 215	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   232: ifeq +13 -> 245
    //   235: ldc 64
    //   237: iconst_2
    //   238: aload_0
    //   239: invokevirtual 693	java/lang/IllegalArgumentException:toString	()Ljava/lang/String;
    //   242: invokestatic 538	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   245: aload 20
    //   247: bipush 13
    //   249: putfield 548	asid:jdField_b_of_type_Int	I
    //   252: aload_1
    //   253: ifnull +12 -> 265
    //   256: aload_1
    //   257: aload 20
    //   259: invokeinterface 691 2 0
    //   264: pop
    //   265: aload 20
    //   267: areturn
    //   268: aload 21
    //   270: monitorenter
    //   271: aload 21
    //   273: lload 11
    //   275: invokevirtual 511	java/lang/Object:wait	(J)V
    //   278: lload 11
    //   280: ldc2_w 694
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
    //   311: astore 16
    //   313: aload 14
    //   315: astore 17
    //   317: aload 14
    //   319: astore 15
    //   321: aload 22
    //   323: invokevirtual 349	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   326: astore 19
    //   328: aload 14
    //   330: astore 16
    //   332: aload 14
    //   334: astore 17
    //   336: aload 14
    //   338: astore 15
    //   340: aload 22
    //   342: invokevirtual 698	android/net/NetworkInfo:getType	()I
    //   345: istore 8
    //   347: aload 14
    //   349: astore 16
    //   351: aload 14
    //   353: astore 17
    //   355: aload 14
    //   357: astore 15
    //   359: invokestatic 340	android/net/Proxy:getDefaultHost	()Ljava/lang/String;
    //   362: astore 22
    //   364: aload 14
    //   366: astore 16
    //   368: aload 14
    //   370: astore 17
    //   372: aload 14
    //   374: astore 15
    //   376: invokestatic 344	android/net/Proxy:getDefaultPort	()I
    //   379: istore 10
    //   381: aload 14
    //   383: astore 16
    //   385: aload 14
    //   387: astore 17
    //   389: aload 14
    //   391: astore 15
    //   393: aload 19
    //   395: invokestatic 703	com/tencent/mobileqq/utils/httputils/PkgTools:getApnType	(Ljava/lang/String;)Ljava/lang/String;
    //   398: astore 19
    //   400: aload 14
    //   402: astore 16
    //   404: aload 14
    //   406: astore 17
    //   408: aload 14
    //   410: astore 15
    //   412: aload 19
    //   414: getstatic 705	com/tencent/mobileqq/utils/HttpDownloadUtil:lastApn	Ljava/lang/String;
    //   417: invokevirtual 709	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   420: ifne +65 -> 485
    //   423: aload 14
    //   425: astore 16
    //   427: aload 14
    //   429: astore 17
    //   431: aload 14
    //   433: astore 15
    //   435: aload 19
    //   437: putstatic 705	com/tencent/mobileqq/utils/HttpDownloadUtil:lastApn	Ljava/lang/String;
    //   440: iload 8
    //   442: iconst_1
    //   443: if_icmpeq +26 -> 469
    //   446: aload 14
    //   448: astore 16
    //   450: aload 14
    //   452: astore 17
    //   454: aload 14
    //   456: astore 15
    //   458: aload 19
    //   460: getstatic 712	com/tencent/mobileqq/utils/httputils/PkgTools:APN_TYPE_CMWAP	Ljava/lang/String;
    //   463: invokevirtual 709	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   466: ifeq +562 -> 1028
    //   469: aload 14
    //   471: astore 16
    //   473: aload 14
    //   475: astore 17
    //   477: aload 14
    //   479: astore 15
    //   481: iconst_0
    //   482: putstatic 714	com/tencent/mobileqq/utils/HttpDownloadUtil:forceDirect	Z
    //   485: iload 8
    //   487: iconst_1
    //   488: if_icmpne +65 -> 553
    //   491: aload 14
    //   493: astore 16
    //   495: aload 14
    //   497: astore 17
    //   499: aload 14
    //   501: astore 15
    //   503: ldc_w 716
    //   506: aload 22
    //   508: invokevirtual 709	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   511: ifne +26 -> 537
    //   514: aload 14
    //   516: astore 16
    //   518: aload 14
    //   520: astore 17
    //   522: aload 14
    //   524: astore 15
    //   526: ldc_w 718
    //   529: aload 22
    //   531: invokevirtual 709	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   534: ifeq +19 -> 553
    //   537: aload 14
    //   539: astore 16
    //   541: aload 14
    //   543: astore 17
    //   545: aload 14
    //   547: astore 15
    //   549: iconst_1
    //   550: putstatic 714	com/tencent/mobileqq/utils/HttpDownloadUtil:forceDirect	Z
    //   553: aload 14
    //   555: astore 16
    //   557: aload 14
    //   559: astore 17
    //   561: aload 14
    //   563: astore 15
    //   565: getstatic 714	com/tencent/mobileqq/utils/HttpDownloadUtil:forceDirect	Z
    //   568: ifne +704 -> 1272
    //   571: aload 22
    //   573: ifnull +699 -> 1272
    //   576: iload 10
    //   578: ifle +694 -> 1272
    //   581: aload 14
    //   583: astore 16
    //   585: aload 14
    //   587: astore 17
    //   589: aload 14
    //   591: astore 15
    //   593: aload 19
    //   595: getstatic 712	com/tencent/mobileqq/utils/httputils/PkgTools:APN_TYPE_CMWAP	Ljava/lang/String;
    //   598: invokevirtual 709	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   601: ifne +49 -> 650
    //   604: aload 14
    //   606: astore 16
    //   608: aload 14
    //   610: astore 17
    //   612: aload 14
    //   614: astore 15
    //   616: aload 19
    //   618: getstatic 721	com/tencent/mobileqq/utils/httputils/PkgTools:APN_TYPE_UNIWAP	Ljava/lang/String;
    //   621: invokevirtual 709	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   624: ifne +26 -> 650
    //   627: aload 14
    //   629: astore 16
    //   631: aload 14
    //   633: astore 17
    //   635: aload 14
    //   637: astore 15
    //   639: aload 19
    //   641: getstatic 724	com/tencent/mobileqq/utils/httputils/PkgTools:APN_TYPE_3GWAP	Ljava/lang/String;
    //   644: invokevirtual 709	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   647: ifeq +550 -> 1197
    //   650: aload 14
    //   652: astore 16
    //   654: aload 14
    //   656: astore 17
    //   658: aload 14
    //   660: astore 15
    //   662: aload 18
    //   664: aload 22
    //   666: iload 10
    //   668: invokestatic 728	com/tencent/mobileqq/utils/httputils/PkgTools:getConnectionWithXOnlineHost	(Ljava/lang/String;Ljava/lang/String;I)Ljava/net/HttpURLConnection;
    //   671: astore 14
    //   673: aload 14
    //   675: astore 16
    //   677: aload 14
    //   679: astore 17
    //   681: aload 14
    //   683: astore 15
    //   685: aload 20
    //   687: aload 14
    //   689: putfield 731	asid:jdField_a_of_type_JavaNetHttpURLConnection	Ljava/net/HttpURLConnection;
    //   692: aload_2
    //   693: ifnull +614 -> 1307
    //   696: aload 14
    //   698: astore 16
    //   700: aload 14
    //   702: astore 17
    //   704: aload 14
    //   706: astore 15
    //   708: aload_2
    //   709: invokeinterface 736 1 0
    //   714: ifne +593 -> 1307
    //   717: aload 14
    //   719: astore 16
    //   721: aload 14
    //   723: astore 17
    //   725: aload 14
    //   727: astore 15
    //   729: aload_2
    //   730: invokeinterface 740 1 0
    //   735: astore 19
    //   737: aload 14
    //   739: astore 16
    //   741: aload 14
    //   743: astore 17
    //   745: aload 14
    //   747: astore 15
    //   749: aload 19
    //   751: invokeinterface 745 1 0
    //   756: ifeq +551 -> 1307
    //   759: aload 14
    //   761: astore 16
    //   763: aload 14
    //   765: astore 17
    //   767: aload 14
    //   769: astore 15
    //   771: aload 19
    //   773: invokeinterface 749 1 0
    //   778: checkcast 751	org/apache/http/Header
    //   781: astore 22
    //   783: aload 14
    //   785: astore 16
    //   787: aload 14
    //   789: astore 17
    //   791: aload 14
    //   793: astore 15
    //   795: aload 14
    //   797: aload 22
    //   799: invokeinterface 754 1 0
    //   804: aload 22
    //   806: invokeinterface 757 1 0
    //   811: invokevirtual 761	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   814: goto -77 -> 737
    //   817: astore 15
    //   819: aload 16
    //   821: astore 14
    //   823: aload 15
    //   825: astore 16
    //   827: aload 14
    //   829: astore 15
    //   831: invokestatic 215	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   834: ifeq +12 -> 846
    //   837: aload 14
    //   839: astore 15
    //   841: aload 16
    //   843: invokevirtual 524	java/io/IOException:printStackTrace	()V
    //   846: iconst_5
    //   847: istore 8
    //   849: aload 14
    //   851: astore 15
    //   853: aload 16
    //   855: instanceof 526
    //   858: ifeq +1353 -> 2211
    //   861: bipush 10
    //   863: istore 8
    //   865: iload_3
    //   866: istore 9
    //   868: aload 14
    //   870: astore 15
    //   872: aload 20
    //   874: iload 8
    //   876: putfield 548	asid:jdField_b_of_type_Int	I
    //   879: aload 14
    //   881: astore 15
    //   883: invokestatic 215	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   886: ifeq +76 -> 962
    //   889: aload 14
    //   891: astore 15
    //   893: ldc 64
    //   895: iconst_2
    //   896: new 297	java/lang/StringBuilder
    //   899: dup
    //   900: invokespecial 298	java/lang/StringBuilder:<init>	()V
    //   903: ldc_w 763
    //   906: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   909: iload 8
    //   911: invokevirtual 503	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   914: ldc_w 765
    //   917: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   920: aload 20
    //   922: getfield 768	asid:jdField_c_of_type_Int	I
    //   925: invokevirtual 503	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   928: ldc_w 530
    //   931: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   934: aload 20
    //   936: getfield 274	asid:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   939: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   942: ldc_w 770
    //   945: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   948: aload 16
    //   950: invokevirtual 771	java/io/IOException:toString	()Ljava/lang/String;
    //   953: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   956: invokevirtual 305	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   959: invokestatic 538	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   962: aload 14
    //   964: astore 15
    //   966: iload 9
    //   968: istore 8
    //   970: aload 14
    //   972: ifnull +16 -> 988
    //   975: aload 14
    //   977: invokevirtual 774	java/net/HttpURLConnection:disconnect	()V
    //   980: iload 9
    //   982: istore 8
    //   984: aload 14
    //   986: astore 15
    //   988: iload 8
    //   990: iconst_1
    //   991: iadd
    //   992: istore 8
    //   994: iload 8
    //   996: iload_3
    //   997: if_icmpge +1305 -> 2302
    //   1000: aload 21
    //   1002: monitorenter
    //   1003: aload 21
    //   1005: lload 11
    //   1007: invokevirtual 511	java/lang/Object:wait	(J)V
    //   1010: lload 11
    //   1012: ldc2_w 694
    //   1015: lmul
    //   1016: lstore 11
    //   1018: aload 21
    //   1020: monitorexit
    //   1021: aload 15
    //   1023: astore 14
    //   1025: goto +1337 -> 2362
    //   1028: aload 14
    //   1030: astore 16
    //   1032: aload 14
    //   1034: astore 17
    //   1036: aload 14
    //   1038: astore 15
    //   1040: iconst_1
    //   1041: putstatic 714	com/tencent/mobileqq/utils/HttpDownloadUtil:forceDirect	Z
    //   1044: goto -559 -> 485
    //   1047: astore 16
    //   1049: aload 17
    //   1051: astore 14
    //   1053: aload 14
    //   1055: astore 15
    //   1057: invokestatic 215	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1060: ifeq +12 -> 1072
    //   1063: aload 14
    //   1065: astore 15
    //   1067: aload 16
    //   1069: invokevirtual 549	java/lang/Exception:printStackTrace	()V
    //   1072: aload 14
    //   1074: astore 15
    //   1076: aload 20
    //   1078: iconst_5
    //   1079: putfield 548	asid:jdField_b_of_type_Int	I
    //   1082: aload 14
    //   1084: astore 15
    //   1086: invokestatic 215	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1089: ifeq +79 -> 1168
    //   1092: aload 14
    //   1094: astore 15
    //   1096: ldc 64
    //   1098: iconst_2
    //   1099: new 297	java/lang/StringBuilder
    //   1102: dup
    //   1103: invokespecial 298	java/lang/StringBuilder:<init>	()V
    //   1106: ldc_w 763
    //   1109: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1112: aload 20
    //   1114: getfield 548	asid:jdField_b_of_type_Int	I
    //   1117: invokevirtual 503	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1120: ldc_w 776
    //   1123: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1126: aload 20
    //   1128: getfield 768	asid:jdField_c_of_type_Int	I
    //   1131: invokevirtual 503	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1134: ldc_w 530
    //   1137: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1140: aload 20
    //   1142: getfield 274	asid:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1145: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1148: ldc_w 532
    //   1151: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1154: aload 16
    //   1156: invokevirtual 777	java/lang/Exception:toString	()Ljava/lang/String;
    //   1159: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1162: invokevirtual 305	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1165: invokestatic 538	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1168: aload 14
    //   1170: astore 15
    //   1172: iload 9
    //   1174: istore 8
    //   1176: aload 14
    //   1178: ifnull -190 -> 988
    //   1181: aload 14
    //   1183: invokevirtual 774	java/net/HttpURLConnection:disconnect	()V
    //   1186: aload 14
    //   1188: astore 15
    //   1190: iload 9
    //   1192: istore 8
    //   1194: goto -206 -> 988
    //   1197: aload 14
    //   1199: astore 16
    //   1201: aload 14
    //   1203: astore 17
    //   1205: aload 14
    //   1207: astore 15
    //   1209: aload 19
    //   1211: getstatic 780	com/tencent/mobileqq/utils/httputils/PkgTools:APN_TYPE_CTWAP	Ljava/lang/String;
    //   1214: invokevirtual 709	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1217: ifeq +29 -> 1246
    //   1220: aload 14
    //   1222: astore 16
    //   1224: aload 14
    //   1226: astore 17
    //   1228: aload 14
    //   1230: astore 15
    //   1232: aload 18
    //   1234: aload 22
    //   1236: iload 10
    //   1238: invokestatic 783	com/tencent/mobileqq/utils/httputils/PkgTools:getConnectionWithDefaultProxy	(Ljava/lang/String;Ljava/lang/String;I)Ljava/net/HttpURLConnection;
    //   1241: astore 14
    //   1243: goto -570 -> 673
    //   1246: aload 14
    //   1248: astore 16
    //   1250: aload 14
    //   1252: astore 17
    //   1254: aload 14
    //   1256: astore 15
    //   1258: aload 18
    //   1260: aload 22
    //   1262: iload 10
    //   1264: invokestatic 783	com/tencent/mobileqq/utils/httputils/PkgTools:getConnectionWithDefaultProxy	(Ljava/lang/String;Ljava/lang/String;I)Ljava/net/HttpURLConnection;
    //   1267: astore 14
    //   1269: goto -596 -> 673
    //   1272: aload 14
    //   1274: astore 16
    //   1276: aload 14
    //   1278: astore 17
    //   1280: aload 14
    //   1282: astore 15
    //   1284: new 271	java/net/URL
    //   1287: dup
    //   1288: aload 18
    //   1290: invokespecial 275	java/net/URL:<init>	(Ljava/lang/String;)V
    //   1293: getstatic 789	java/net/Proxy:NO_PROXY	Ljava/net/Proxy;
    //   1296: invokevirtual 793	java/net/URL:openConnection	(Ljava/net/Proxy;)Ljava/net/URLConnection;
    //   1299: checkcast 245	java/net/HttpURLConnection
    //   1302: astore 14
    //   1304: goto -631 -> 673
    //   1307: aload 14
    //   1309: astore 16
    //   1311: aload 14
    //   1313: astore 17
    //   1315: aload 14
    //   1317: astore 15
    //   1319: aload 14
    //   1321: ldc_w 795
    //   1324: ldc_w 797
    //   1327: invokevirtual 800	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1330: aload 14
    //   1332: astore 16
    //   1334: aload 14
    //   1336: astore 17
    //   1338: aload 14
    //   1340: astore 15
    //   1342: aload 14
    //   1344: iload 6
    //   1346: invokevirtual 804	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   1349: aload 14
    //   1351: astore 16
    //   1353: aload 14
    //   1355: astore 17
    //   1357: aload 14
    //   1359: astore 15
    //   1361: aload 14
    //   1363: iload 7
    //   1365: invokevirtual 807	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   1368: aload 14
    //   1370: astore 16
    //   1372: aload 14
    //   1374: astore 17
    //   1376: aload 14
    //   1378: astore 15
    //   1380: aload 14
    //   1382: iconst_0
    //   1383: invokevirtual 811	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   1386: aload 14
    //   1388: astore 16
    //   1390: aload 14
    //   1392: astore 17
    //   1394: aload 14
    //   1396: astore 15
    //   1398: aload 14
    //   1400: invokevirtual 814	java/net/HttpURLConnection:connect	()V
    //   1403: aload 14
    //   1405: astore 16
    //   1407: aload 14
    //   1409: astore 17
    //   1411: aload 14
    //   1413: astore 15
    //   1415: aload 20
    //   1417: aload 14
    //   1419: invokevirtual 817	java/net/HttpURLConnection:getResponseCode	()I
    //   1422: putfield 768	asid:jdField_c_of_type_Int	I
    //   1425: aload 14
    //   1427: astore 16
    //   1429: aload 14
    //   1431: astore 17
    //   1433: aload 14
    //   1435: astore 15
    //   1437: aload 20
    //   1439: aload 14
    //   1441: invokevirtual 819	java/net/HttpURLConnection:getContentLength	()I
    //   1444: putfield 821	asid:jdField_e_of_type_Int	I
    //   1447: aload 14
    //   1449: astore 16
    //   1451: aload 14
    //   1453: astore 17
    //   1455: aload 14
    //   1457: astore 15
    //   1459: aload 20
    //   1461: aload 14
    //   1463: invokevirtual 824	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
    //   1466: putfield 827	asid:h	Ljava/lang/String;
    //   1469: aload 14
    //   1471: astore 16
    //   1473: aload 14
    //   1475: astore 17
    //   1477: aload 14
    //   1479: astore 15
    //   1481: aload 20
    //   1483: aload 14
    //   1485: invokevirtual 830	java/net/HttpURLConnection:getContentEncoding	()Ljava/lang/String;
    //   1488: putfield 832	asid:i	Ljava/lang/String;
    //   1491: aload 14
    //   1493: astore 16
    //   1495: aload 14
    //   1497: astore 17
    //   1499: aload 14
    //   1501: astore 15
    //   1503: aload 14
    //   1505: aload 20
    //   1507: invokestatic 834	com/tencent/mobileqq/utils/HttpDownloadUtil:copyRespHeader	(Ljava/net/HttpURLConnection;Lasid;)V
    //   1510: aload 14
    //   1512: astore 16
    //   1514: aload 14
    //   1516: astore 17
    //   1518: aload 14
    //   1520: astore 15
    //   1522: invokestatic 215	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1525: ifeq +83 -> 1608
    //   1528: aload 14
    //   1530: astore 16
    //   1532: aload 14
    //   1534: astore 17
    //   1536: aload 14
    //   1538: astore 15
    //   1540: ldc 64
    //   1542: iconst_2
    //   1543: new 297	java/lang/StringBuilder
    //   1546: dup
    //   1547: invokespecial 298	java/lang/StringBuilder:<init>	()V
    //   1550: ldc_w 836
    //   1553: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1556: aload_0
    //   1557: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1560: ldc_w 838
    //   1563: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1566: aload 20
    //   1568: getfield 768	asid:jdField_c_of_type_Int	I
    //   1571: invokevirtual 503	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1574: ldc_w 840
    //   1577: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1580: aload 20
    //   1582: getfield 821	asid:jdField_e_of_type_Int	I
    //   1585: invokevirtual 503	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1588: ldc_w 842
    //   1591: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1594: aload 20
    //   1596: getfield 827	asid:h	Ljava/lang/String;
    //   1599: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1602: invokevirtual 305	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1605: invokestatic 487	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1608: iload 4
    //   1610: ifeq +59 -> 1669
    //   1613: aload 14
    //   1615: astore 16
    //   1617: aload 14
    //   1619: astore 17
    //   1621: aload 14
    //   1623: astore 15
    //   1625: aload 20
    //   1627: iconst_0
    //   1628: putfield 548	asid:jdField_b_of_type_Int	I
    //   1631: aload_1
    //   1632: ifnull +24 -> 1656
    //   1635: aload 14
    //   1637: astore 16
    //   1639: aload 14
    //   1641: astore 17
    //   1643: aload 14
    //   1645: astore 15
    //   1647: aload_1
    //   1648: aload 20
    //   1650: invokeinterface 691 2 0
    //   1655: pop
    //   1656: aload 14
    //   1658: ifnull +8 -> 1666
    //   1661: aload 14
    //   1663: invokevirtual 774	java/net/HttpURLConnection:disconnect	()V
    //   1666: aload 20
    //   1668: areturn
    //   1669: aload 14
    //   1671: astore 16
    //   1673: aload 14
    //   1675: astore 17
    //   1677: aload 14
    //   1679: astore 15
    //   1681: aload 20
    //   1683: getfield 768	asid:jdField_c_of_type_Int	I
    //   1686: sipush 200
    //   1689: if_icmpne +157 -> 1846
    //   1692: aload_1
    //   1693: ifnull +122 -> 1815
    //   1696: aload 14
    //   1698: astore 16
    //   1700: aload 14
    //   1702: astore 17
    //   1704: aload 14
    //   1706: astore 15
    //   1708: aload 20
    //   1710: iconst_0
    //   1711: putfield 548	asid:jdField_b_of_type_Int	I
    //   1714: aload 14
    //   1716: astore 16
    //   1718: aload 14
    //   1720: astore 17
    //   1722: aload 14
    //   1724: astore 15
    //   1726: aload_1
    //   1727: aload 20
    //   1729: invokeinterface 691 2 0
    //   1734: ifeq +34 -> 1768
    //   1737: aload 14
    //   1739: astore 16
    //   1741: aload 14
    //   1743: astore 17
    //   1745: aload 14
    //   1747: astore 15
    //   1749: aload 20
    //   1751: iconst_0
    //   1752: putfield 548	asid:jdField_b_of_type_Int	I
    //   1755: aload 14
    //   1757: ifnull +8 -> 1765
    //   1760: aload 14
    //   1762: invokevirtual 774	java/net/HttpURLConnection:disconnect	()V
    //   1765: aload 20
    //   1767: areturn
    //   1768: aload 14
    //   1770: astore 16
    //   1772: aload 14
    //   1774: astore 17
    //   1776: aload 14
    //   1778: astore 15
    //   1780: aload 20
    //   1782: iconst_4
    //   1783: putfield 548	asid:jdField_b_of_type_Int	I
    //   1786: aload 14
    //   1788: astore 15
    //   1790: iload 9
    //   1792: istore 8
    //   1794: aload 14
    //   1796: ifnull -808 -> 988
    //   1799: aload 14
    //   1801: invokevirtual 774	java/net/HttpURLConnection:disconnect	()V
    //   1804: aload 14
    //   1806: astore 15
    //   1808: iload 9
    //   1810: istore 8
    //   1812: goto -824 -> 988
    //   1815: aload 14
    //   1817: astore 16
    //   1819: aload 14
    //   1821: astore 17
    //   1823: aload 14
    //   1825: astore 15
    //   1827: aload 20
    //   1829: iconst_0
    //   1830: putfield 548	asid:jdField_b_of_type_Int	I
    //   1833: aload 14
    //   1835: ifnull +8 -> 1843
    //   1838: aload 14
    //   1840: invokevirtual 774	java/net/HttpURLConnection:disconnect	()V
    //   1843: aload 20
    //   1845: areturn
    //   1846: aload 14
    //   1848: astore 16
    //   1850: aload 14
    //   1852: astore 17
    //   1854: aload 14
    //   1856: astore 15
    //   1858: aload 20
    //   1860: getfield 768	asid:jdField_c_of_type_Int	I
    //   1863: sipush 302
    //   1866: if_icmpeq +26 -> 1892
    //   1869: aload 14
    //   1871: astore 16
    //   1873: aload 14
    //   1875: astore 17
    //   1877: aload 14
    //   1879: astore 15
    //   1881: aload 20
    //   1883: getfield 768	asid:jdField_c_of_type_Int	I
    //   1886: sipush 301
    //   1889: if_icmpne +284 -> 2173
    //   1892: aload 14
    //   1894: astore 16
    //   1896: aload 14
    //   1898: astore 17
    //   1900: aload 14
    //   1902: astore 15
    //   1904: aload 14
    //   1906: ldc_w 844
    //   1909: invokevirtual 249	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   1912: astore 19
    //   1914: aload 14
    //   1916: astore 16
    //   1918: aload 14
    //   1920: astore 17
    //   1922: aload 14
    //   1924: astore 15
    //   1926: invokestatic 215	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1929: ifeq +42 -> 1971
    //   1932: aload 14
    //   1934: astore 16
    //   1936: aload 14
    //   1938: astore 17
    //   1940: aload 14
    //   1942: astore 15
    //   1944: ldc 64
    //   1946: iconst_2
    //   1947: new 297	java/lang/StringBuilder
    //   1950: dup
    //   1951: invokespecial 298	java/lang/StringBuilder:<init>	()V
    //   1954: ldc_w 846
    //   1957: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1960: aload 19
    //   1962: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1965: invokevirtual 305	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1968: invokestatic 538	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1971: aload 14
    //   1973: astore 16
    //   1975: aload 14
    //   1977: astore 17
    //   1979: aload 14
    //   1981: astore 15
    //   1983: aload 19
    //   1985: invokestatic 851	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1988: ifeq +35 -> 2023
    //   1991: aload 14
    //   1993: astore 16
    //   1995: aload 14
    //   1997: astore 17
    //   1999: aload 14
    //   2001: astore 15
    //   2003: aload 20
    //   2005: bipush 20
    //   2007: putfield 548	asid:jdField_b_of_type_Int	I
    //   2010: aload 14
    //   2012: ifnull +8 -> 2020
    //   2015: aload 14
    //   2017: invokevirtual 774	java/net/HttpURLConnection:disconnect	()V
    //   2020: aload 20
    //   2022: areturn
    //   2023: aload 14
    //   2025: astore 16
    //   2027: aload 14
    //   2029: astore 17
    //   2031: aload 14
    //   2033: astore 15
    //   2035: aload 14
    //   2037: invokevirtual 774	java/net/HttpURLConnection:disconnect	()V
    //   2040: aload_2
    //   2041: ifnull +88 -> 2129
    //   2044: aload_2
    //   2045: invokeinterface 854 1 0
    //   2050: istore 10
    //   2052: iconst_0
    //   2053: istore 8
    //   2055: iload 8
    //   2057: iload 10
    //   2059: if_icmpge +41 -> 2100
    //   2062: aload_2
    //   2063: iload 8
    //   2065: invokeinterface 858 2 0
    //   2070: checkcast 751	org/apache/http/Header
    //   2073: astore 14
    //   2075: aload 14
    //   2077: invokeinterface 754 1 0
    //   2082: ldc_w 860
    //   2085: invokevirtual 709	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2088: ifeq +76 -> 2164
    //   2091: aload_2
    //   2092: aload 14
    //   2094: invokeinterface 863 2 0
    //   2099: pop
    //   2100: aload_2
    //   2101: new 865	org/apache/http/message/BasicHeader
    //   2104: dup
    //   2105: ldc_w 860
    //   2108: new 271	java/net/URL
    //   2111: dup
    //   2112: aload 19
    //   2114: invokespecial 275	java/net/URL:<init>	(Ljava/lang/String;)V
    //   2117: invokevirtual 386	java/net/URL:getHost	()Ljava/lang/String;
    //   2120: invokespecial 867	org/apache/http/message/BasicHeader:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   2123: invokeinterface 870 2 0
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
    //   2144: invokestatic 675	com/tencent/mobileqq/utils/HttpDownloadUtil:queryDownloadInfo	(Ljava/lang/String;Lbhed;Ljava/util/List;IZIII)Lasid;
    //   2147: astore 14
    //   2149: aload 14
    //   2151: astore_0
    //   2152: iconst_0
    //   2153: ifeq -2110 -> 43
    //   2156: new 872	java/lang/NullPointerException
    //   2159: dup
    //   2160: invokespecial 873	java/lang/NullPointerException:<init>	()V
    //   2163: athrow
    //   2164: iload 8
    //   2166: iconst_1
    //   2167: iadd
    //   2168: istore 8
    //   2170: goto -115 -> 2055
    //   2173: aload 14
    //   2175: astore 16
    //   2177: aload 14
    //   2179: astore 17
    //   2181: aload 14
    //   2183: astore 15
    //   2185: aload 20
    //   2187: aload 20
    //   2189: getfield 768	asid:jdField_c_of_type_Int	I
    //   2192: putfield 548	asid:jdField_b_of_type_Int	I
    //   2195: goto -409 -> 1786
    //   2198: astore_0
    //   2199: aload 15
    //   2201: ifnull +8 -> 2209
    //   2204: aload 15
    //   2206: invokevirtual 774	java/net/HttpURLConnection:disconnect	()V
    //   2209: aload_0
    //   2210: athrow
    //   2211: aload 14
    //   2213: astore 15
    //   2215: aload 16
    //   2217: instanceof 519
    //   2220: ifne +151 -> 2371
    //   2223: aload 14
    //   2225: astore 15
    //   2227: aload 16
    //   2229: instanceof 521
    //   2232: ifeq +6 -> 2238
    //   2235: goto +136 -> 2371
    //   2238: aload 14
    //   2240: astore 15
    //   2242: aload 16
    //   2244: instanceof 546
    //   2247: ifeq +17 -> 2264
    //   2250: aload 14
    //   2252: astore 15
    //   2254: aload 20
    //   2256: bipush 11
    //   2258: putfield 548	asid:jdField_b_of_type_Int	I
    //   2261: goto -1393 -> 868
    //   2264: aload 14
    //   2266: astore 15
    //   2268: aload 16
    //   2270: instanceof 261
    //   2273: istore 13
    //   2275: iload 13
    //   2277: ifeq +13 -> 2290
    //   2280: bipush 13
    //   2282: istore 8
    //   2284: iload_3
    //   2285: istore 9
    //   2287: goto -1419 -> 868
    //   2290: iconst_4
    //   2291: istore 8
    //   2293: goto -1425 -> 868
    //   2296: astore_0
    //   2297: aload 21
    //   2299: monitorexit
    //   2300: aload_0
    //   2301: athrow
    //   2302: aload_1
    //   2303: ifnull +12 -> 2315
    //   2306: aload_1
    //   2307: aload 20
    //   2309: invokeinterface 691 2 0
    //   2314: pop
    //   2315: aload 15
    //   2317: astore 14
    //   2319: goto +43 -> 2362
    //   2322: astore 15
    //   2324: goto -2038 -> 286
    //   2327: astore 14
    //   2329: goto -1311 -> 1018
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
    //   2352: goto -1525 -> 827
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
    //   2374: goto -1506 -> 868
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2377	0	paramString	String
    //   0	2377	1	parambhed	bhed
    //   0	2377	2	paramList	List<Header>
    //   0	2377	3	paramInt1	int
    //   0	2377	4	paramBoolean	boolean
    //   0	2377	5	paramInt2	int
    //   0	2377	6	paramInt3	int
    //   0	2377	7	paramInt4	int
    //   130	2243	8	i	int
    //   88	2270	9	j	int
    //   379	1681	10	k	int
    //   93	924	11	l	long
    //   2273	3	13	bool	boolean
    //   85	1	14	localObject1	Object
    //   203	456	14	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   671	1647	14	localObject2	Object
    //   2327	1	14	localInterruptedException1	java.lang.InterruptedException
    //   2342	9	14	localObject3	Object
    //   319	475	15	localObject4	Object
    //   817	7	15	localIOException1	java.io.IOException
    //   829	1487	15	localObject5	Object
    //   2322	1	15	localInterruptedException2	java.lang.InterruptedException
    //   2334	1	15	localObject6	Object
    //   311	720	16	localObject7	Object
    //   1047	108	16	localException1	Exception
    //   1199	1070	16	localObject8	Object
    //   2339	1	16	localException2	Exception
    //   2347	1	16	localIOException2	java.io.IOException
    //   315	1865	17	localObject9	Object
    //   63	1226	18	str	String
    //   299	1831	19	localObject10	Object
    //   10	2359	20	localasid	asid
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
    //   1040	1044	817	java/io/IOException
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
    //   321	328	1047	java/lang/Exception
    //   340	347	1047	java/lang/Exception
    //   359	364	1047	java/lang/Exception
    //   376	381	1047	java/lang/Exception
    //   393	400	1047	java/lang/Exception
    //   412	423	1047	java/lang/Exception
    //   435	440	1047	java/lang/Exception
    //   458	469	1047	java/lang/Exception
    //   481	485	1047	java/lang/Exception
    //   503	514	1047	java/lang/Exception
    //   526	537	1047	java/lang/Exception
    //   549	553	1047	java/lang/Exception
    //   565	571	1047	java/lang/Exception
    //   593	604	1047	java/lang/Exception
    //   616	627	1047	java/lang/Exception
    //   639	650	1047	java/lang/Exception
    //   662	673	1047	java/lang/Exception
    //   685	692	1047	java/lang/Exception
    //   708	717	1047	java/lang/Exception
    //   729	737	1047	java/lang/Exception
    //   749	759	1047	java/lang/Exception
    //   771	783	1047	java/lang/Exception
    //   795	814	1047	java/lang/Exception
    //   1040	1044	1047	java/lang/Exception
    //   1209	1220	1047	java/lang/Exception
    //   1232	1243	1047	java/lang/Exception
    //   1258	1269	1047	java/lang/Exception
    //   1284	1304	1047	java/lang/Exception
    //   1319	1330	1047	java/lang/Exception
    //   1342	1349	1047	java/lang/Exception
    //   1361	1368	1047	java/lang/Exception
    //   1380	1386	1047	java/lang/Exception
    //   1398	1403	1047	java/lang/Exception
    //   1415	1425	1047	java/lang/Exception
    //   1437	1447	1047	java/lang/Exception
    //   1459	1469	1047	java/lang/Exception
    //   1481	1491	1047	java/lang/Exception
    //   1503	1510	1047	java/lang/Exception
    //   1522	1528	1047	java/lang/Exception
    //   1540	1608	1047	java/lang/Exception
    //   1625	1631	1047	java/lang/Exception
    //   1647	1656	1047	java/lang/Exception
    //   1681	1692	1047	java/lang/Exception
    //   1708	1714	1047	java/lang/Exception
    //   1726	1737	1047	java/lang/Exception
    //   1749	1755	1047	java/lang/Exception
    //   1780	1786	1047	java/lang/Exception
    //   1827	1833	1047	java/lang/Exception
    //   1858	1869	1047	java/lang/Exception
    //   1881	1892	1047	java/lang/Exception
    //   1904	1914	1047	java/lang/Exception
    //   1926	1932	1047	java/lang/Exception
    //   1944	1971	1047	java/lang/Exception
    //   1983	1991	1047	java/lang/Exception
    //   2003	2010	1047	java/lang/Exception
    //   2035	2040	1047	java/lang/Exception
    //   2185	2195	1047	java/lang/Exception
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
    //   831	837	2198	finally
    //   841	846	2198	finally
    //   853	861	2198	finally
    //   872	879	2198	finally
    //   883	889	2198	finally
    //   893	962	2198	finally
    //   1040	1044	2198	finally
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
    //   1003	1010	2296	finally
    //   1018	1021	2296	finally
    //   2297	2300	2296	finally
    //   271	278	2322	java/lang/InterruptedException
    //   1003	1010	2327	java/lang/InterruptedException
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
  
  public static void replaceDomainWithIP(asid paramasid)
  {
    if ((paramasid == null) || (paramasid.jdField_a_of_type_JavaLangString == null) || (paramasid.jdField_a_of_type_JavaLangString.length() == 0)) {}
    label33:
    int i;
    int j;
    String str2;
    do
    {
      return;
      if (!paramasid.jdField_b_of_type_Boolean) {
        break;
      }
      localObject = PROTOCOL_HTTPS;
      i = ((String)localObject).length();
      j = paramasid.jdField_a_of_type_JavaLangString.indexOf("/", i);
      str2 = paramasid.jdField_a_of_type_JavaLangString.substring(i, j);
    } while ((j <= i) && (TextUtils.isEmpty(str2)));
    label88:
    String str1;
    if ("imgcache.qq.com".equalsIgnoreCase(str2))
    {
      i = 12;
      str1 = (String)localObject + "[^/\\s]*/";
      String str3 = FMTSrvAddrProvider.getInstance().getSrvAddr(i);
      if ((str3 == null) || (str3.length() <= 0)) {
        break label413;
      }
      str1 = paramasid.jdField_a_of_type_JavaLangString.replaceFirst(str1, str3);
      if ((!paramasid.jdField_b_of_type_Boolean) || (TextUtils.isEmpty(str1)) || (!str1.startsWith("http://"))) {
        break label474;
      }
    }
    label413:
    label474:
    for (Object localObject = (String)localObject + str1.substring("http://".length());; localObject = str1)
    {
      paramasid.jdField_c_of_type_JavaLangString = str2;
      paramasid.jdField_b_of_type_JavaLangString = ((String)localObject);
      paramasid.jdField_a_of_type_Boolean = true;
      paramasid.d = i;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.emoji.EmoDown", 2, "replaceDomainWithIp " + paramasid.jdField_a_of_type_Boolean + " url[" + paramasid.jdField_a_of_type_JavaLangString + "] resetIP[" + (String)localObject + "] host[" + paramasid.jdField_c_of_type_JavaLangString + "]");
      return;
      localObject = "http://";
      break label33;
      if ("imgcache.gtimg.cn".equalsIgnoreCase(str2))
      {
        i = 13;
        break label88;
      }
      if ("i.gtimg.cn".equalsIgnoreCase(str2))
      {
        i = 14;
        break label88;
      }
      if ("cmshow.gtimg.cn".equalsIgnoreCase(str2))
      {
        i = 17;
        break label88;
      }
      paramasid.jdField_c_of_type_JavaLangString = null;
      paramasid.jdField_b_of_type_JavaLangString = paramasid.jdField_a_of_type_JavaLangString;
      paramasid.jdField_a_of_type_Boolean = false;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.emoji.EmoDown", 2, "unknow domain url=" + paramasid.jdField_a_of_type_Boolean);
      return;
      paramasid.jdField_c_of_type_JavaLangString = null;
      paramasid.jdField_b_of_type_JavaLangString = paramasid.jdField_a_of_type_JavaLangString;
      paramasid.jdField_a_of_type_Boolean = false;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.emoji.EmoDown", 2, "replaceDomainWithIp false.url[" + paramasid.jdField_b_of_type_JavaLangString + "]");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.HttpDownloadUtil
 * JD-Core Version:    0.7.0.1
 */