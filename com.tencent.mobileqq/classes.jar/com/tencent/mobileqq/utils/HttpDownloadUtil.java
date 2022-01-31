package com.tencent.mobileqq.utils;

import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.emoticon.DownloadInfo;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.transfile.FMTSrvAddrProvider;
import com.tencent.mobileqq.transfile.HttpDownloader;
import com.tencent.mobileqq.transfile.TlsSniSocketFactory;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
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
  static long jdField_a_of_type_Long = ;
  static HttpDownloadUtil.IdleConnectionMonitorThread jdField_a_of_type_ComTencentMobileqqUtilsHttpDownloadUtil$IdleConnectionMonitorThread;
  public static String a;
  public static final DefaultHttpClient a;
  private static boolean jdField_a_of_type_Boolean;
  private static String b;
  
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
        if ((Build.VERSION.SDK_INT < 23) && (!HttpDownloader.c())) {
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
      jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient = new DefaultHttpClient((ClientConnectionManager)localObject, localBasicHttpParams);
      jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient.setHttpRequestRetryHandler(new DefaultHttpRequestRetryHandler());
      jdField_a_of_type_ComTencentMobileqqUtilsHttpDownloadUtil$IdleConnectionMonitorThread = new HttpDownloadUtil.IdleConnectionMonitorThread((ClientConnectionManager)localObject);
      jdField_a_of_type_ComTencentMobileqqUtilsHttpDownloadUtil$IdleConnectionMonitorThread.setName("IdleConnectionMonitorThread");
      jdField_a_of_type_ComTencentMobileqqUtilsHttpDownloadUtil$IdleConnectionMonitorThread.start();
      jdField_a_of_type_JavaLangString = "https://";
      return;
      ((SchemeRegistry)localObject).register(new Scheme("https", new TlsSniSocketFactory(HttpDownloadUtil.class.getSimpleName()), 443));
    }
  }
  
  /* Error */
  private static int a(AppInterface paramAppInterface, DownloadInfo paramDownloadInfo, NetworkInfo paramNetworkInfo, HttpDownloadUtil.HttpDownloadListener paramHttpDownloadListener)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +23 -> 24
    //   4: invokestatic 151	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7: ifeq +11 -> 18
    //   10: ldc 153
    //   12: iconst_2
    //   13: ldc 172
    //   15: invokestatic 176	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   18: iconst_5
    //   19: istore 6
    //   21: iload 6
    //   23: ireturn
    //   24: new 178	java/net/URL
    //   27: dup
    //   28: aload_1
    //   29: getfield 182	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   32: invokespecial 183	java/net/URL:<init>	(Ljava/lang/String;)V
    //   35: astore 27
    //   37: invokestatic 21	java/lang/System:currentTimeMillis	()J
    //   40: lstore 12
    //   42: new 4	java/lang/Object
    //   45: dup
    //   46: invokespecial 161	java/lang/Object:<init>	()V
    //   49: astore 28
    //   51: aload_1
    //   52: getfield 186	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   55: invokevirtual 192	java/io/File:getParentFile	()Ljava/io/File;
    //   58: astore 17
    //   60: aload 17
    //   62: ifnull +139 -> 201
    //   65: aload 17
    //   67: invokevirtual 195	java/io/File:exists	()Z
    //   70: ifne +131 -> 201
    //   73: aload 17
    //   75: invokevirtual 198	java/io/File:mkdirs	()Z
    //   78: ifne +123 -> 201
    //   81: aload_3
    //   82: ifnull +15 -> 97
    //   85: aload_3
    //   86: aload 27
    //   88: invokevirtual 201	java/net/URL:toString	()Ljava/lang/String;
    //   91: iconst_4
    //   92: invokeinterface 206 3 0
    //   97: invokestatic 151	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   100: ifeq +31 -> 131
    //   103: ldc 153
    //   105: iconst_2
    //   106: new 208	java/lang/StringBuilder
    //   109: dup
    //   110: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   113: ldc 211
    //   115: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: aload_1
    //   119: getfield 182	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   122: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: invokestatic 176	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   131: iconst_4
    //   132: ireturn
    //   133: astore_0
    //   134: aload_0
    //   135: invokevirtual 219	java/net/MalformedURLException:printStackTrace	()V
    //   138: aload_1
    //   139: aload_0
    //   140: invokestatic 225	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   143: putfield 227	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   146: iconst_5
    //   147: ireturn
    //   148: astore_0
    //   149: aload_3
    //   150: ifnull +15 -> 165
    //   153: aload_3
    //   154: aload 27
    //   156: invokevirtual 201	java/net/URL:toString	()Ljava/lang/String;
    //   159: iconst_4
    //   160: invokeinterface 206 3 0
    //   165: invokestatic 151	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   168: ifeq +31 -> 199
    //   171: ldc 153
    //   173: iconst_2
    //   174: new 208	java/lang/StringBuilder
    //   177: dup
    //   178: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   181: ldc 211
    //   183: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: aload_1
    //   187: getfield 182	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   190: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   196: invokestatic 176	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   199: iconst_4
    //   200: ireturn
    //   201: aconst_null
    //   202: astore 19
    //   204: aload_1
    //   205: getfield 182	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   208: astore 17
    //   210: new 229	org/apache/http/client/methods/HttpGet
    //   213: dup
    //   214: aload 17
    //   216: invokespecial 230	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   219: astore 26
    //   221: new 25	org/apache/http/params/BasicHttpParams
    //   224: dup
    //   225: invokespecial 28	org/apache/http/params/BasicHttpParams:<init>	()V
    //   228: astore 29
    //   230: aload 29
    //   232: ldc 232
    //   234: ldc 233
    //   236: invokestatic 238	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   239: invokeinterface 244 3 0
    //   244: pop
    //   245: aload 29
    //   247: ldc 246
    //   249: ldc 233
    //   251: invokestatic 238	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   254: invokeinterface 244 3 0
    //   259: pop
    //   260: invokestatic 251	android/net/Proxy:getDefaultHost	()Ljava/lang/String;
    //   263: astore 17
    //   265: invokestatic 255	android/net/Proxy:getDefaultPort	()I
    //   268: istore 5
    //   270: iconst_0
    //   271: istore 4
    //   273: aload_2
    //   274: ifnull +96 -> 370
    //   277: aload_2
    //   278: invokevirtual 260	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   281: astore 18
    //   283: aload_2
    //   284: invokestatic 265	com/tencent/mobileqq/utils/NetworkUtil:a	(Landroid/net/NetworkInfo;)Z
    //   287: ifeq +51 -> 338
    //   290: aload 18
    //   292: ifnull +14 -> 306
    //   295: aload 18
    //   297: ldc_w 267
    //   300: invokevirtual 271	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   303: ifeq +35 -> 338
    //   306: aload 17
    //   308: ifnull +30 -> 338
    //   311: iload 5
    //   313: ifle +25 -> 338
    //   316: aload 29
    //   318: ldc_w 273
    //   321: new 275	org/apache/http/HttpHost
    //   324: dup
    //   325: aload 17
    //   327: iload 5
    //   329: invokespecial 277	org/apache/http/HttpHost:<init>	(Ljava/lang/String;I)V
    //   332: invokeinterface 244 3 0
    //   337: pop
    //   338: aload_2
    //   339: invokestatic 265	com/tencent/mobileqq/utils/NetworkUtil:a	(Landroid/net/NetworkInfo;)Z
    //   342: ifeq +574 -> 916
    //   345: sipush 2048
    //   348: istore 4
    //   350: aload 29
    //   352: ldc_w 279
    //   355: iload 4
    //   357: invokeinterface 283 3 0
    //   362: pop
    //   363: aload 26
    //   365: aload 29
    //   367: invokevirtual 287	org/apache/http/client/methods/HttpGet:setParams	(Lorg/apache/http/params/HttpParams;)V
    //   370: new 188	java/io/File
    //   373: dup
    //   374: aload_1
    //   375: invokevirtual 289	com/tencent/mobileqq/emoticon/DownloadInfo:a	()Ljava/lang/String;
    //   378: invokespecial 290	java/io/File:<init>	(Ljava/lang/String;)V
    //   381: astore 30
    //   383: aload 30
    //   385: invokevirtual 195	java/io/File:exists	()Z
    //   388: ifeq +9 -> 397
    //   391: aload 30
    //   393: invokevirtual 293	java/io/File:delete	()Z
    //   396: pop
    //   397: aconst_null
    //   398: astore 17
    //   400: iconst_m1
    //   401: istore 9
    //   403: iconst_5
    //   404: istore 10
    //   406: iload 9
    //   408: ifne +38 -> 446
    //   411: aload 29
    //   413: ldc_w 273
    //   416: new 275	org/apache/http/HttpHost
    //   419: dup
    //   420: aload 27
    //   422: invokevirtual 296	java/net/URL:getHost	()Ljava/lang/String;
    //   425: aload 27
    //   427: invokevirtual 299	java/net/URL:getPort	()I
    //   430: invokespecial 277	org/apache/http/HttpHost:<init>	(Ljava/lang/String;I)V
    //   433: invokeinterface 244 3 0
    //   438: pop
    //   439: aload 26
    //   441: aload 29
    //   443: invokevirtual 287	org/apache/http/client/methods/HttpGet:setParams	(Lorg/apache/http/params/HttpParams;)V
    //   446: aload 19
    //   448: astore 24
    //   450: aload 17
    //   452: astore 20
    //   454: iload 4
    //   456: istore 6
    //   458: aload 19
    //   460: astore 23
    //   462: aload 17
    //   464: astore 21
    //   466: iload 4
    //   468: istore 8
    //   470: aload 19
    //   472: astore 25
    //   474: aload 17
    //   476: astore 22
    //   478: iload 10
    //   480: istore 7
    //   482: getstatic 109	com/tencent/mobileqq/utils/HttpDownloadUtil:jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   485: new 275	org/apache/http/HttpHost
    //   488: dup
    //   489: aload 27
    //   491: invokevirtual 296	java/net/URL:getHost	()Ljava/lang/String;
    //   494: invokespecial 300	org/apache/http/HttpHost:<init>	(Ljava/lang/String;)V
    //   497: aload 26
    //   499: invokevirtual 304	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/HttpHost;Lorg/apache/http/HttpRequest;)Lorg/apache/http/HttpResponse;
    //   502: astore 18
    //   504: aload 19
    //   506: astore 24
    //   508: aload 17
    //   510: astore 20
    //   512: iload 4
    //   514: istore 6
    //   516: aload 19
    //   518: astore 23
    //   520: aload 17
    //   522: astore 21
    //   524: iload 4
    //   526: istore 8
    //   528: aload 19
    //   530: astore 25
    //   532: aload 17
    //   534: astore 22
    //   536: iload 10
    //   538: istore 7
    //   540: aload 18
    //   542: invokeinterface 310 1 0
    //   547: astore 31
    //   549: aload 19
    //   551: astore 24
    //   553: aload 17
    //   555: astore 20
    //   557: iload 4
    //   559: istore 6
    //   561: aload 19
    //   563: astore 23
    //   565: aload 17
    //   567: astore 21
    //   569: iload 4
    //   571: istore 8
    //   573: aload 19
    //   575: astore 25
    //   577: aload 17
    //   579: astore 22
    //   581: iload 10
    //   583: istore 7
    //   585: aload 18
    //   587: invokeinterface 314 1 0
    //   592: pop
    //   593: aload 19
    //   595: astore 24
    //   597: aload 17
    //   599: astore 20
    //   601: iload 4
    //   603: istore 6
    //   605: aload 19
    //   607: astore 23
    //   609: aload 17
    //   611: astore 21
    //   613: iload 4
    //   615: istore 8
    //   617: aload 19
    //   619: astore 25
    //   621: aload 17
    //   623: astore 22
    //   625: iload 10
    //   627: istore 7
    //   629: aload 31
    //   631: invokeinterface 319 1 0
    //   636: istore 5
    //   638: aload_3
    //   639: ifnull +52 -> 691
    //   642: aload 19
    //   644: astore 24
    //   646: aload 17
    //   648: astore 20
    //   650: iload 4
    //   652: istore 6
    //   654: aload 19
    //   656: astore 23
    //   658: aload 17
    //   660: astore 21
    //   662: iload 4
    //   664: istore 8
    //   666: aload 19
    //   668: astore 25
    //   670: aload 17
    //   672: astore 22
    //   674: iload 10
    //   676: istore 7
    //   678: aload_3
    //   679: aload 27
    //   681: invokevirtual 201	java/net/URL:toString	()Ljava/lang/String;
    //   684: iload 5
    //   686: invokeinterface 321 3 0
    //   691: aload 19
    //   693: astore 24
    //   695: aload 17
    //   697: astore 20
    //   699: iload 4
    //   701: istore 6
    //   703: aload 19
    //   705: astore 23
    //   707: aload 17
    //   709: astore 21
    //   711: iload 4
    //   713: istore 8
    //   715: aload 19
    //   717: astore 25
    //   719: aload 17
    //   721: astore 22
    //   723: iload 10
    //   725: istore 7
    //   727: aload 18
    //   729: invokeinterface 325 1 0
    //   734: astore 17
    //   736: sipush 200
    //   739: iload 5
    //   741: if_icmpne +1435 -> 2176
    //   744: aload 19
    //   746: astore 24
    //   748: aload 17
    //   750: astore 20
    //   752: iload 4
    //   754: istore 6
    //   756: aload 19
    //   758: astore 23
    //   760: aload 17
    //   762: astore 21
    //   764: iload 4
    //   766: istore 8
    //   768: aload 19
    //   770: astore 25
    //   772: aload 17
    //   774: astore 22
    //   776: iload 10
    //   778: istore 7
    //   780: aload 17
    //   782: invokeinterface 330 1 0
    //   787: lstore 14
    //   789: aconst_null
    //   790: astore 20
    //   792: iconst_0
    //   793: istore 5
    //   795: new 332	java/io/FileOutputStream
    //   798: dup
    //   799: aload 30
    //   801: invokespecial 335	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   804: astore 18
    //   806: aload 17
    //   808: invokeinterface 339 1 0
    //   813: astore 19
    //   815: aload 19
    //   817: astore 20
    //   819: iload 4
    //   821: ifne +1890 -> 2711
    //   824: sipush 2048
    //   827: istore 4
    //   829: iload 4
    //   831: newarray byte
    //   833: astore 19
    //   835: iload 5
    //   837: i2l
    //   838: lload 14
    //   840: lcmp
    //   841: ifge +83 -> 924
    //   844: aload 20
    //   846: aload 19
    //   848: invokevirtual 345	java/io/InputStream:read	([B)I
    //   851: istore 6
    //   853: aload 18
    //   855: aload 19
    //   857: iconst_0
    //   858: iload 6
    //   860: invokevirtual 351	java/io/OutputStream:write	([BII)V
    //   863: iload 5
    //   865: iload 6
    //   867: iadd
    //   868: istore 5
    //   870: aload_3
    //   871: ifnull +1837 -> 2708
    //   874: aload_3
    //   875: aload 27
    //   877: invokevirtual 201	java/net/URL:toString	()Ljava/lang/String;
    //   880: lload 14
    //   882: iload 5
    //   884: i2l
    //   885: invokeinterface 354 6 0
    //   890: goto -55 -> 835
    //   893: astore 18
    //   895: new 229	org/apache/http/client/methods/HttpGet
    //   898: dup
    //   899: aload 17
    //   901: invokestatic 357	com/tencent/mobileqq/utils/HttpDownloadUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   904: invokespecial 230	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   907: astore 26
    //   909: goto -688 -> 221
    //   912: astore_0
    //   913: bipush 13
    //   915: ireturn
    //   916: sipush 4096
    //   919: istore 4
    //   921: goto -571 -> 350
    //   924: iload 5
    //   926: i2l
    //   927: lload 14
    //   929: lcmp
    //   930: ifne +657 -> 1587
    //   933: iconst_0
    //   934: istore 10
    //   936: iconst_0
    //   937: istore 11
    //   939: iconst_0
    //   940: istore 8
    //   942: iload 8
    //   944: istore 5
    //   946: iload 10
    //   948: istore 6
    //   950: iload 11
    //   952: istore 7
    //   954: invokestatic 151	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   957: ifeq +44 -> 1001
    //   960: iload 10
    //   962: istore 6
    //   964: iload 11
    //   966: istore 7
    //   968: ldc 153
    //   970: iconst_2
    //   971: new 208	java/lang/StringBuilder
    //   974: dup
    //   975: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   978: ldc_w 359
    //   981: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   984: aload_1
    //   985: getfield 182	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   988: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   991: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   994: invokestatic 176	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   997: iload 8
    //   999: istore 5
    //   1001: iload 5
    //   1003: istore 6
    //   1005: iload 5
    //   1007: istore 7
    //   1009: invokestatic 151	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1012: ifeq +53 -> 1065
    //   1015: iload 5
    //   1017: istore 6
    //   1019: iload 5
    //   1021: istore 7
    //   1023: ldc_w 361
    //   1026: iconst_2
    //   1027: new 208	java/lang/StringBuilder
    //   1030: dup
    //   1031: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   1034: ldc_w 363
    //   1037: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1040: invokestatic 21	java/lang/System:currentTimeMillis	()J
    //   1043: invokevirtual 366	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1046: ldc_w 368
    //   1049: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1052: aload_1
    //   1053: getfield 182	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1056: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1059: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1062: invokestatic 176	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1065: aload_1
    //   1066: ifnull +109 -> 1175
    //   1069: iload 5
    //   1071: istore 6
    //   1073: iload 5
    //   1075: istore 7
    //   1077: aload_1
    //   1078: getfield 370	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_a_of_type_Int	I
    //   1081: tableswitch	default:+1633 -> 2714, 10001:+666->1747
    //   1101: iconst_2
    //   1102: istore 6
    //   1104: iload 5
    //   1106: istore 7
    //   1108: aload_2
    //   1109: invokestatic 265	com/tencent/mobileqq/utils/NetworkUtil:a	(Landroid/net/NetworkInfo;)Z
    //   1112: ifeq +1001 -> 2113
    //   1115: iload 5
    //   1117: istore 6
    //   1119: iload 5
    //   1121: istore 7
    //   1123: iconst_3
    //   1124: anewarray 221	java/lang/String
    //   1127: astore 19
    //   1129: aload 19
    //   1131: iconst_0
    //   1132: ldc_w 372
    //   1135: aastore
    //   1136: aload 19
    //   1138: iconst_1
    //   1139: ldc_w 374
    //   1142: aastore
    //   1143: aload 19
    //   1145: iconst_2
    //   1146: ldc_w 376
    //   1149: aastore
    //   1150: aload 19
    //   1152: ifnull +23 -> 1175
    //   1155: iload 5
    //   1157: istore 6
    //   1159: iload 5
    //   1161: istore 7
    //   1163: aload_0
    //   1164: aload_0
    //   1165: invokevirtual 381	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1168: aload 19
    //   1170: lload 14
    //   1172: invokevirtual 385	com/tencent/common/app/AppInterface:sendAppDataIncerment	(Ljava/lang/String;[Ljava/lang/String;J)V
    //   1175: iload 5
    //   1177: istore 6
    //   1179: iload 5
    //   1181: istore 7
    //   1183: aload 30
    //   1185: invokestatic 21	java/lang/System:currentTimeMillis	()J
    //   1188: invokevirtual 389	java/io/File:setLastModified	(J)Z
    //   1191: pop
    //   1192: iload 5
    //   1194: istore 6
    //   1196: iload 5
    //   1198: istore 7
    //   1200: invokestatic 151	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1203: ifeq +66 -> 1269
    //   1206: iload 5
    //   1208: istore 6
    //   1210: iload 5
    //   1212: istore 7
    //   1214: ldc 153
    //   1216: iconst_2
    //   1217: new 208	java/lang/StringBuilder
    //   1220: dup
    //   1221: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   1224: ldc_w 391
    //   1227: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1230: invokestatic 21	java/lang/System:currentTimeMillis	()J
    //   1233: lload 12
    //   1235: lsub
    //   1236: invokevirtual 366	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1239: ldc_w 393
    //   1242: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1245: lload 14
    //   1247: invokevirtual 366	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1250: ldc_w 395
    //   1253: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1256: aload_1
    //   1257: getfield 182	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1260: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1263: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1266: invokestatic 398	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1269: aload 20
    //   1271: ifnull +1434 -> 2705
    //   1274: iload 5
    //   1276: istore 7
    //   1278: iload 4
    //   1280: istore 6
    //   1282: aload 18
    //   1284: astore 21
    //   1286: iload 4
    //   1288: istore 8
    //   1290: aload 18
    //   1292: astore 22
    //   1294: aload 18
    //   1296: astore 23
    //   1298: aload 20
    //   1300: invokevirtual 401	java/io/InputStream:close	()V
    //   1303: iload 5
    //   1305: ifne +92 -> 1397
    //   1308: aload 18
    //   1310: astore 24
    //   1312: aload 17
    //   1314: astore 20
    //   1316: iload 4
    //   1318: istore 6
    //   1320: aload 18
    //   1322: astore 23
    //   1324: aload 17
    //   1326: astore 21
    //   1328: iload 4
    //   1330: istore 8
    //   1332: aload 18
    //   1334: astore 25
    //   1336: aload 17
    //   1338: astore 22
    //   1340: iload 5
    //   1342: istore 7
    //   1344: aload_1
    //   1345: getfield 186	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   1348: ifnull +49 -> 1397
    //   1351: aload 18
    //   1353: astore 24
    //   1355: aload 17
    //   1357: astore 20
    //   1359: iload 4
    //   1361: istore 6
    //   1363: aload 18
    //   1365: astore 23
    //   1367: aload 17
    //   1369: astore 21
    //   1371: iload 4
    //   1373: istore 8
    //   1375: aload 18
    //   1377: astore 25
    //   1379: aload 17
    //   1381: astore 22
    //   1383: iload 5
    //   1385: istore 7
    //   1387: aload 30
    //   1389: aload_1
    //   1390: getfield 186	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   1393: invokevirtual 405	java/io/File:renameTo	(Ljava/io/File;)Z
    //   1396: pop
    //   1397: aload_3
    //   1398: ifnull +52 -> 1450
    //   1401: aload 18
    //   1403: astore 24
    //   1405: aload 17
    //   1407: astore 20
    //   1409: iload 4
    //   1411: istore 6
    //   1413: aload 18
    //   1415: astore 23
    //   1417: aload 17
    //   1419: astore 21
    //   1421: iload 4
    //   1423: istore 8
    //   1425: aload 18
    //   1427: astore 25
    //   1429: aload 17
    //   1431: astore 22
    //   1433: iload 5
    //   1435: istore 7
    //   1437: aload_3
    //   1438: aload 27
    //   1440: invokevirtual 201	java/net/URL:toString	()Ljava/lang/String;
    //   1443: iload 5
    //   1445: invokeinterface 206 3 0
    //   1450: aload 17
    //   1452: ifnull +10 -> 1462
    //   1455: aload 17
    //   1457: invokeinterface 408 1 0
    //   1462: aload 18
    //   1464: ifnull +1227 -> 2691
    //   1467: aload 18
    //   1469: invokevirtual 409	java/io/OutputStream:close	()V
    //   1472: aload 18
    //   1474: astore 20
    //   1476: aload 17
    //   1478: astore 19
    //   1480: iload 9
    //   1482: iconst_1
    //   1483: iadd
    //   1484: istore 9
    //   1486: invokestatic 151	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1489: ifeq +43 -> 1532
    //   1492: ldc 153
    //   1494: iconst_2
    //   1495: new 208	java/lang/StringBuilder
    //   1498: dup
    //   1499: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   1502: ldc_w 411
    //   1505: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1508: iload 5
    //   1510: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1513: ldc_w 416
    //   1516: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1519: aload_1
    //   1520: getfield 182	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1523: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1526: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1529: invokestatic 176	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1532: iload 9
    //   1534: iconst_2
    //   1535: if_icmpge +22 -> 1557
    //   1538: iload 5
    //   1540: ifeq +17 -> 1557
    //   1543: aload 28
    //   1545: monitorenter
    //   1546: aload 28
    //   1548: ldc2_w 417
    //   1551: invokevirtual 422	java/lang/Object:wait	(J)V
    //   1554: aload 28
    //   1556: monitorexit
    //   1557: iload 5
    //   1559: istore 6
    //   1561: iload 5
    //   1563: ifeq -1542 -> 21
    //   1566: iload 5
    //   1568: istore 6
    //   1570: iload 9
    //   1572: iconst_2
    //   1573: if_icmpge -1552 -> 21
    //   1576: aload 19
    //   1578: astore 17
    //   1580: aload 20
    //   1582: astore 19
    //   1584: goto -1181 -> 403
    //   1587: bipush 8
    //   1589: istore 8
    //   1591: iload 8
    //   1593: istore 6
    //   1595: iload 8
    //   1597: istore 7
    //   1599: invokestatic 151	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1602: ifeq +62 -> 1664
    //   1605: iload 8
    //   1607: istore 6
    //   1609: iload 8
    //   1611: istore 7
    //   1613: ldc 153
    //   1615: iconst_2
    //   1616: new 208	java/lang/StringBuilder
    //   1619: dup
    //   1620: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   1623: ldc_w 424
    //   1626: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1629: iload 5
    //   1631: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1634: ldc_w 426
    //   1637: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1640: lload 14
    //   1642: invokevirtual 366	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1645: ldc_w 428
    //   1648: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1651: aload_1
    //   1652: getfield 182	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1655: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1658: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1661: invokestatic 176	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1664: iload 8
    //   1666: istore 5
    //   1668: iload 8
    //   1670: istore 6
    //   1672: iload 8
    //   1674: istore 7
    //   1676: aload 30
    //   1678: invokevirtual 195	java/io/File:exists	()Z
    //   1681: ifeq -680 -> 1001
    //   1684: iload 8
    //   1686: istore 6
    //   1688: iload 8
    //   1690: istore 7
    //   1692: aload 30
    //   1694: invokevirtual 293	java/io/File:delete	()Z
    //   1697: pop
    //   1698: iload 8
    //   1700: istore 5
    //   1702: goto -701 -> 1001
    //   1705: astore 19
    //   1707: iload 6
    //   1709: istore 5
    //   1711: aload 19
    //   1713: instanceof 430
    //   1716: ifne +15 -> 1731
    //   1719: aload 19
    //   1721: instanceof 432
    //   1724: istore 16
    //   1726: iload 16
    //   1728: ifeq +423 -> 2151
    //   1731: iconst_3
    //   1732: istore 5
    //   1734: aload 20
    //   1736: ifnull +966 -> 2702
    //   1739: aload 20
    //   1741: invokevirtual 401	java/io/InputStream:close	()V
    //   1744: goto -441 -> 1303
    //   1747: iload 5
    //   1749: istore 6
    //   1751: iload 5
    //   1753: istore 7
    //   1755: aload_2
    //   1756: invokestatic 265	com/tencent/mobileqq/utils/NetworkUtil:a	(Landroid/net/NetworkInfo;)Z
    //   1759: ifeq +316 -> 2075
    //   1762: iload 5
    //   1764: istore 6
    //   1766: iload 5
    //   1768: istore 7
    //   1770: iconst_3
    //   1771: anewarray 221	java/lang/String
    //   1774: astore 19
    //   1776: aload 19
    //   1778: iconst_0
    //   1779: ldc_w 434
    //   1782: aastore
    //   1783: aload 19
    //   1785: iconst_1
    //   1786: ldc_w 374
    //   1789: aastore
    //   1790: aload 19
    //   1792: iconst_2
    //   1793: ldc_w 376
    //   1796: aastore
    //   1797: goto -647 -> 1150
    //   1800: astore 19
    //   1802: iload 7
    //   1804: istore 5
    //   1806: aload 20
    //   1808: ifnull +32 -> 1840
    //   1811: iload 5
    //   1813: istore 7
    //   1815: iload 4
    //   1817: istore 6
    //   1819: aload 18
    //   1821: astore 21
    //   1823: iload 4
    //   1825: istore 8
    //   1827: aload 18
    //   1829: astore 22
    //   1831: aload 18
    //   1833: astore 23
    //   1835: aload 20
    //   1837: invokevirtual 401	java/io/InputStream:close	()V
    //   1840: iload 5
    //   1842: istore 7
    //   1844: iload 4
    //   1846: istore 6
    //   1848: aload 18
    //   1850: astore 21
    //   1852: iload 4
    //   1854: istore 8
    //   1856: aload 18
    //   1858: astore 22
    //   1860: aload 18
    //   1862: astore 23
    //   1864: aload 19
    //   1866: athrow
    //   1867: astore 19
    //   1869: aload 21
    //   1871: astore 18
    //   1873: iload 7
    //   1875: istore 5
    //   1877: aload 17
    //   1879: astore 21
    //   1881: aload 18
    //   1883: astore 20
    //   1885: aload 19
    //   1887: invokevirtual 435	java/io/IOException:printStackTrace	()V
    //   1890: aload 17
    //   1892: astore 21
    //   1894: aload 18
    //   1896: astore 20
    //   1898: aload 19
    //   1900: instanceof 437
    //   1903: ifeq +340 -> 2243
    //   1906: bipush 10
    //   1908: istore 7
    //   1910: aload 17
    //   1912: astore 21
    //   1914: aload 18
    //   1916: astore 20
    //   1918: ldc 153
    //   1920: iconst_2
    //   1921: new 208	java/lang/StringBuilder
    //   1924: dup
    //   1925: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   1928: ldc_w 439
    //   1931: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1934: iload 7
    //   1936: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1939: ldc_w 441
    //   1942: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1945: aload_1
    //   1946: getfield 182	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1949: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1952: ldc_w 443
    //   1955: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1958: aload 19
    //   1960: invokevirtual 446	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1963: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1966: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1969: invokestatic 449	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1972: aload_3
    //   1973: ifnull +24 -> 1997
    //   1976: aload 17
    //   1978: astore 21
    //   1980: aload 18
    //   1982: astore 20
    //   1984: aload_3
    //   1985: aload 27
    //   1987: invokevirtual 201	java/net/URL:toString	()Ljava/lang/String;
    //   1990: iload 7
    //   1992: invokeinterface 206 3 0
    //   1997: aload 17
    //   1999: ifnull +10 -> 2009
    //   2002: aload 17
    //   2004: invokeinterface 408 1 0
    //   2009: aload 17
    //   2011: astore 19
    //   2013: iload 6
    //   2015: istore 4
    //   2017: aload 18
    //   2019: astore 20
    //   2021: iload 7
    //   2023: istore 5
    //   2025: aload 18
    //   2027: ifnull -547 -> 1480
    //   2030: aload 18
    //   2032: invokevirtual 409	java/io/OutputStream:close	()V
    //   2035: aload 17
    //   2037: astore 19
    //   2039: iload 6
    //   2041: istore 4
    //   2043: aload 18
    //   2045: astore 20
    //   2047: iload 7
    //   2049: istore 5
    //   2051: goto -571 -> 1480
    //   2054: astore 19
    //   2056: aload 17
    //   2058: astore 19
    //   2060: iload 6
    //   2062: istore 4
    //   2064: aload 18
    //   2066: astore 20
    //   2068: iload 7
    //   2070: istore 5
    //   2072: goto -592 -> 1480
    //   2075: iload 5
    //   2077: istore 6
    //   2079: iload 5
    //   2081: istore 7
    //   2083: iconst_3
    //   2084: anewarray 221	java/lang/String
    //   2087: astore 19
    //   2089: aload 19
    //   2091: iconst_0
    //   2092: ldc_w 451
    //   2095: aastore
    //   2096: aload 19
    //   2098: iconst_1
    //   2099: ldc_w 453
    //   2102: aastore
    //   2103: aload 19
    //   2105: iconst_2
    //   2106: ldc_w 376
    //   2109: aastore
    //   2110: goto -960 -> 1150
    //   2113: iload 5
    //   2115: istore 6
    //   2117: iload 5
    //   2119: istore 7
    //   2121: iconst_3
    //   2122: anewarray 221	java/lang/String
    //   2125: astore 19
    //   2127: aload 19
    //   2129: iconst_0
    //   2130: ldc_w 455
    //   2133: aastore
    //   2134: aload 19
    //   2136: iconst_1
    //   2137: ldc_w 453
    //   2140: aastore
    //   2141: aload 19
    //   2143: iconst_2
    //   2144: ldc_w 376
    //   2147: aastore
    //   2148: goto -998 -> 1150
    //   2151: aload 19
    //   2153: instanceof 457
    //   2156: istore 16
    //   2158: iload 16
    //   2160: ifeq +10 -> 2170
    //   2163: bipush 11
    //   2165: istore 5
    //   2167: goto -433 -> 1734
    //   2170: iconst_4
    //   2171: istore 5
    //   2173: goto -439 -> 1734
    //   2176: aload_3
    //   2177: ifnull +36 -> 2213
    //   2180: aload 19
    //   2182: astore 24
    //   2184: aload 17
    //   2186: astore 20
    //   2188: iload 4
    //   2190: istore 6
    //   2192: aload 19
    //   2194: astore 23
    //   2196: aload 17
    //   2198: astore 21
    //   2200: aload_3
    //   2201: aload 27
    //   2203: invokevirtual 201	java/net/URL:toString	()Ljava/lang/String;
    //   2206: iload 5
    //   2208: invokeinterface 206 3 0
    //   2213: aload 19
    //   2215: astore 18
    //   2217: goto -767 -> 1450
    //   2220: astore 19
    //   2222: aload 19
    //   2224: invokevirtual 435	java/io/IOException:printStackTrace	()V
    //   2227: goto -765 -> 1462
    //   2230: astore 19
    //   2232: aload 17
    //   2234: astore 19
    //   2236: aload 18
    //   2238: astore 20
    //   2240: goto -760 -> 1480
    //   2243: aload 17
    //   2245: astore 21
    //   2247: aload 18
    //   2249: astore 20
    //   2251: aload 19
    //   2253: instanceof 430
    //   2256: ifne +461 -> 2717
    //   2259: aload 17
    //   2261: astore 21
    //   2263: aload 18
    //   2265: astore 20
    //   2267: aload 19
    //   2269: instanceof 432
    //   2272: ifeq +6 -> 2278
    //   2275: goto +442 -> 2717
    //   2278: aload 17
    //   2280: astore 21
    //   2282: aload 18
    //   2284: astore 20
    //   2286: aload 19
    //   2288: instanceof 457
    //   2291: ifeq +24 -> 2315
    //   2294: aload 17
    //   2296: astore 21
    //   2298: aload 18
    //   2300: astore 20
    //   2302: aload_1
    //   2303: bipush 11
    //   2305: putfield 459	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   2308: iload 5
    //   2310: istore 7
    //   2312: goto -402 -> 1910
    //   2315: iconst_4
    //   2316: istore 7
    //   2318: goto -408 -> 1910
    //   2321: astore 19
    //   2323: aload 19
    //   2325: invokevirtual 435	java/io/IOException:printStackTrace	()V
    //   2328: goto -319 -> 2009
    //   2331: astore 19
    //   2333: iload 8
    //   2335: istore 6
    //   2337: aload 22
    //   2339: astore 18
    //   2341: aload 17
    //   2343: astore 21
    //   2345: aload 18
    //   2347: astore 20
    //   2349: aload 19
    //   2351: invokevirtual 460	java/lang/Exception:printStackTrace	()V
    //   2354: iconst_5
    //   2355: istore 7
    //   2357: aload_3
    //   2358: ifnull +23 -> 2381
    //   2361: aload 17
    //   2363: astore 21
    //   2365: aload 18
    //   2367: astore 20
    //   2369: aload_3
    //   2370: aload 27
    //   2372: invokevirtual 201	java/net/URL:toString	()Ljava/lang/String;
    //   2375: iconst_5
    //   2376: invokeinterface 206 3 0
    //   2381: aload 17
    //   2383: ifnull +10 -> 2393
    //   2386: aload 17
    //   2388: invokeinterface 408 1 0
    //   2393: aload 17
    //   2395: astore 19
    //   2397: iload 6
    //   2399: istore 4
    //   2401: aload 18
    //   2403: astore 20
    //   2405: iload 7
    //   2407: istore 5
    //   2409: aload 18
    //   2411: ifnull -931 -> 1480
    //   2414: aload 18
    //   2416: invokevirtual 409	java/io/OutputStream:close	()V
    //   2419: aload 17
    //   2421: astore 19
    //   2423: iload 6
    //   2425: istore 4
    //   2427: aload 18
    //   2429: astore 20
    //   2431: iload 7
    //   2433: istore 5
    //   2435: goto -955 -> 1480
    //   2438: astore 19
    //   2440: aload 17
    //   2442: astore 19
    //   2444: iload 6
    //   2446: istore 4
    //   2448: aload 18
    //   2450: astore 20
    //   2452: iload 7
    //   2454: istore 5
    //   2456: goto -976 -> 1480
    //   2459: astore 19
    //   2461: aload 19
    //   2463: invokevirtual 435	java/io/IOException:printStackTrace	()V
    //   2466: goto -73 -> 2393
    //   2469: astore_0
    //   2470: aload 23
    //   2472: astore_1
    //   2473: aload 17
    //   2475: ifnull +10 -> 2485
    //   2478: aload 17
    //   2480: invokeinterface 408 1 0
    //   2485: aload_1
    //   2486: ifnull +7 -> 2493
    //   2489: aload_1
    //   2490: invokevirtual 409	java/io/OutputStream:close	()V
    //   2493: aload_0
    //   2494: athrow
    //   2495: astore_2
    //   2496: aload_2
    //   2497: invokevirtual 435	java/io/IOException:printStackTrace	()V
    //   2500: goto -15 -> 2485
    //   2503: astore_0
    //   2504: aload 28
    //   2506: monitorexit
    //   2507: aload_0
    //   2508: athrow
    //   2509: astore_1
    //   2510: goto -17 -> 2493
    //   2513: astore 17
    //   2515: goto -961 -> 1554
    //   2518: astore_0
    //   2519: aload 18
    //   2521: astore_1
    //   2522: goto -49 -> 2473
    //   2525: astore_0
    //   2526: aload 24
    //   2528: astore_1
    //   2529: aload 20
    //   2531: astore 17
    //   2533: goto -60 -> 2473
    //   2536: astore_0
    //   2537: aload 21
    //   2539: astore 17
    //   2541: aload 20
    //   2543: astore_1
    //   2544: goto -71 -> 2473
    //   2547: astore 19
    //   2549: iload 4
    //   2551: istore 6
    //   2553: goto -212 -> 2341
    //   2556: astore 19
    //   2558: aload 23
    //   2560: astore 18
    //   2562: aload 21
    //   2564: astore 17
    //   2566: goto -225 -> 2341
    //   2569: astore 19
    //   2571: iload 4
    //   2573: istore 6
    //   2575: goto -698 -> 1877
    //   2578: astore 19
    //   2580: iload 8
    //   2582: istore 6
    //   2584: aload 25
    //   2586: astore 18
    //   2588: aload 22
    //   2590: astore 17
    //   2592: iload 7
    //   2594: istore 5
    //   2596: goto -719 -> 1877
    //   2599: astore 20
    //   2601: aload 19
    //   2603: astore 18
    //   2605: aload 20
    //   2607: astore 19
    //   2609: iload 4
    //   2611: istore 6
    //   2613: goto -736 -> 1877
    //   2616: astore 19
    //   2618: iconst_5
    //   2619: istore 5
    //   2621: goto -815 -> 1806
    //   2624: astore 19
    //   2626: goto -820 -> 1806
    //   2629: astore 21
    //   2631: aconst_null
    //   2632: astore 20
    //   2634: aload 19
    //   2636: astore 18
    //   2638: iconst_5
    //   2639: istore 5
    //   2641: aload 21
    //   2643: astore 19
    //   2645: goto -839 -> 1806
    //   2648: astore 19
    //   2650: aconst_null
    //   2651: astore 20
    //   2653: iconst_5
    //   2654: istore 5
    //   2656: goto -850 -> 1806
    //   2659: astore 19
    //   2661: iconst_5
    //   2662: istore 5
    //   2664: goto -953 -> 1711
    //   2667: astore 21
    //   2669: aload 19
    //   2671: astore 18
    //   2673: iconst_5
    //   2674: istore 5
    //   2676: aload 21
    //   2678: astore 19
    //   2680: goto -969 -> 1711
    //   2683: astore 19
    //   2685: iconst_5
    //   2686: istore 5
    //   2688: goto -977 -> 1711
    //   2691: aload 17
    //   2693: astore 19
    //   2695: aload 18
    //   2697: astore 20
    //   2699: goto -1219 -> 1480
    //   2702: goto -1399 -> 1303
    //   2705: goto -1402 -> 1303
    //   2708: goto -1873 -> 835
    //   2711: goto -1882 -> 829
    //   2714: goto -1614 -> 1100
    //   2717: iconst_2
    //   2718: istore 7
    //   2720: goto -810 -> 1910
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2723	0	paramAppInterface	AppInterface
    //   0	2723	1	paramDownloadInfo	DownloadInfo
    //   0	2723	2	paramNetworkInfo	NetworkInfo
    //   0	2723	3	paramHttpDownloadListener	HttpDownloadUtil.HttpDownloadListener
    //   271	2339	4	i	int
    //   268	2419	5	j	int
    //   19	2593	6	k	int
    //   480	2239	7	m	int
    //   468	2113	8	n	int
    //   401	1173	9	i1	int
    //   404	557	10	i2	int
    //   937	28	11	i3	int
    //   40	1194	12	l1	long
    //   787	854	14	l2	long
    //   1724	435	16	bool	boolean
    //   58	2421	17	localObject1	Object
    //   2513	1	17	localInterruptedException	java.lang.InterruptedException
    //   2531	161	17	localObject2	Object
    //   281	573	18	localObject3	Object
    //   893	968	18	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   1871	825	18	localObject4	Object
    //   202	1381	19	localObject5	Object
    //   1705	15	19	localIOException1	java.io.IOException
    //   1774	17	19	arrayOfString	String[]
    //   1800	65	19	localObject6	Object
    //   1867	92	19	localIOException2	java.io.IOException
    //   2011	27	19	localObject7	Object
    //   2054	1	19	localIOException3	java.io.IOException
    //   2058	156	19	localObject8	Object
    //   2220	3	19	localIOException4	java.io.IOException
    //   2230	1	19	localIOException5	java.io.IOException
    //   2234	53	19	localObject9	Object
    //   2321	3	19	localIOException6	java.io.IOException
    //   2331	19	19	localException1	Exception
    //   2395	27	19	localObject10	Object
    //   2438	1	19	localIOException7	java.io.IOException
    //   2442	1	19	localObject11	Object
    //   2459	3	19	localIOException8	java.io.IOException
    //   2547	1	19	localException2	Exception
    //   2556	1	19	localException3	Exception
    //   2569	1	19	localIOException9	java.io.IOException
    //   2578	24	19	localIOException10	java.io.IOException
    //   2607	1	19	localObject12	Object
    //   2616	1	19	localObject13	Object
    //   2624	11	19	localObject14	Object
    //   2643	1	19	localObject15	Object
    //   2648	1	19	localObject16	Object
    //   2659	11	19	localIOException11	java.io.IOException
    //   2678	1	19	localObject17	Object
    //   2683	1	19	localIOException12	java.io.IOException
    //   2693	1	19	localObject18	Object
    //   452	2090	20	localObject19	Object
    //   2599	7	20	localIOException13	java.io.IOException
    //   2632	66	20	localObject20	Object
    //   464	2099	21	localObject21	Object
    //   2629	13	21	localObject22	Object
    //   2667	10	21	localIOException14	java.io.IOException
    //   476	2113	22	localObject23	Object
    //   460	2099	23	localObject24	Object
    //   448	2079	24	localObject25	Object
    //   472	2113	25	localObject26	Object
    //   219	689	26	localHttpGet	org.apache.http.client.methods.HttpGet
    //   35	2336	27	localURL	URL
    //   49	2456	28	localObject27	Object
    //   228	214	29	localBasicHttpParams	BasicHttpParams
    //   381	1312	30	localFile	File
    //   547	83	31	localStatusLine	org.apache.http.StatusLine
    // Exception table:
    //   from	to	target	type
    //   24	37	133	java/net/MalformedURLException
    //   51	60	148	java/lang/Exception
    //   65	81	148	java/lang/Exception
    //   85	97	148	java/lang/Exception
    //   97	131	148	java/lang/Exception
    //   210	221	893	java/lang/IllegalArgumentException
    //   895	909	912	java/lang/IllegalArgumentException
    //   954	960	1705	java/io/IOException
    //   968	997	1705	java/io/IOException
    //   1009	1015	1705	java/io/IOException
    //   1023	1065	1705	java/io/IOException
    //   1077	1100	1705	java/io/IOException
    //   1108	1115	1705	java/io/IOException
    //   1123	1129	1705	java/io/IOException
    //   1163	1175	1705	java/io/IOException
    //   1183	1192	1705	java/io/IOException
    //   1200	1206	1705	java/io/IOException
    //   1214	1269	1705	java/io/IOException
    //   1599	1605	1705	java/io/IOException
    //   1613	1664	1705	java/io/IOException
    //   1676	1684	1705	java/io/IOException
    //   1692	1698	1705	java/io/IOException
    //   1755	1762	1705	java/io/IOException
    //   1770	1776	1705	java/io/IOException
    //   2083	2089	1705	java/io/IOException
    //   2121	2127	1705	java/io/IOException
    //   954	960	1800	finally
    //   968	997	1800	finally
    //   1009	1015	1800	finally
    //   1023	1065	1800	finally
    //   1077	1100	1800	finally
    //   1108	1115	1800	finally
    //   1123	1129	1800	finally
    //   1163	1175	1800	finally
    //   1183	1192	1800	finally
    //   1200	1206	1800	finally
    //   1214	1269	1800	finally
    //   1599	1605	1800	finally
    //   1613	1664	1800	finally
    //   1676	1684	1800	finally
    //   1692	1698	1800	finally
    //   1755	1762	1800	finally
    //   1770	1776	1800	finally
    //   2083	2089	1800	finally
    //   2121	2127	1800	finally
    //   1298	1303	1867	java/io/IOException
    //   1835	1840	1867	java/io/IOException
    //   1864	1867	1867	java/io/IOException
    //   2030	2035	2054	java/io/IOException
    //   1455	1462	2220	java/io/IOException
    //   1467	1472	2230	java/io/IOException
    //   2002	2009	2321	java/io/IOException
    //   1298	1303	2331	java/lang/Exception
    //   1835	1840	2331	java/lang/Exception
    //   1864	1867	2331	java/lang/Exception
    //   2414	2419	2438	java/io/IOException
    //   2386	2393	2459	java/io/IOException
    //   1298	1303	2469	finally
    //   1835	1840	2469	finally
    //   1864	1867	2469	finally
    //   2478	2485	2495	java/io/IOException
    //   1546	1554	2503	finally
    //   1554	1557	2503	finally
    //   2504	2507	2503	finally
    //   2489	2493	2509	java/io/IOException
    //   1546	1554	2513	java/lang/InterruptedException
    //   1739	1744	2518	finally
    //   482	504	2525	finally
    //   540	549	2525	finally
    //   585	593	2525	finally
    //   629	638	2525	finally
    //   678	691	2525	finally
    //   727	736	2525	finally
    //   780	789	2525	finally
    //   1344	1351	2525	finally
    //   1387	1397	2525	finally
    //   1437	1450	2525	finally
    //   2200	2213	2525	finally
    //   1885	1890	2536	finally
    //   1898	1906	2536	finally
    //   1918	1972	2536	finally
    //   1984	1997	2536	finally
    //   2251	2259	2536	finally
    //   2267	2275	2536	finally
    //   2286	2294	2536	finally
    //   2302	2308	2536	finally
    //   2349	2354	2536	finally
    //   2369	2381	2536	finally
    //   1739	1744	2547	java/lang/Exception
    //   482	504	2556	java/lang/Exception
    //   540	549	2556	java/lang/Exception
    //   585	593	2556	java/lang/Exception
    //   629	638	2556	java/lang/Exception
    //   678	691	2556	java/lang/Exception
    //   727	736	2556	java/lang/Exception
    //   780	789	2556	java/lang/Exception
    //   1344	1351	2556	java/lang/Exception
    //   1387	1397	2556	java/lang/Exception
    //   1437	1450	2556	java/lang/Exception
    //   2200	2213	2556	java/lang/Exception
    //   1739	1744	2569	java/io/IOException
    //   482	504	2578	java/io/IOException
    //   540	549	2578	java/io/IOException
    //   585	593	2578	java/io/IOException
    //   629	638	2578	java/io/IOException
    //   678	691	2578	java/io/IOException
    //   727	736	2578	java/io/IOException
    //   780	789	2578	java/io/IOException
    //   1344	1351	2578	java/io/IOException
    //   1387	1397	2578	java/io/IOException
    //   1437	1450	2578	java/io/IOException
    //   2200	2213	2599	java/io/IOException
    //   829	835	2616	finally
    //   844	863	2616	finally
    //   874	890	2616	finally
    //   1711	1726	2624	finally
    //   2151	2158	2624	finally
    //   795	806	2629	finally
    //   806	815	2648	finally
    //   829	835	2659	java/io/IOException
    //   844	863	2659	java/io/IOException
    //   874	890	2659	java/io/IOException
    //   795	806	2667	java/io/IOException
    //   806	815	2683	java/io/IOException
  }
  
  public static int a(AppInterface paramAppInterface, DownloadInfo paramDownloadInfo, HttpDownloadUtil.HttpDownloadListener paramHttpDownloadListener)
  {
    NetworkInfo localNetworkInfo = AppNetConnInfo.getRecentNetworkInfo();
    if (localNetworkInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("HttpDownloadUtil", 2, "Download failed-----------activeNetworkInfo is null");
      }
      return 9;
    }
    return a(paramAppInterface, paramDownloadInfo, localNetworkInfo, paramHttpDownloadListener);
  }
  
  public static int a(AppInterface paramAppInterface, String paramString, File paramFile)
  {
    return a(paramAppInterface, paramString, paramFile, 2);
  }
  
  public static int a(AppInterface paramAppInterface, String paramString, File paramFile, int paramInt)
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
      return a(paramAppInterface, paramString, paramFile, localNetworkInfo, paramInt);
    }
    catch (MalformedURLException paramAppInterface)
    {
      paramAppInterface.printStackTrace();
    }
    return 5;
  }
  
  /* Error */
  private static int a(AppInterface paramAppInterface, URL paramURL, File paramFile, NetworkInfo paramNetworkInfo, int paramInt)
  {
    // Byte code:
    //   0: invokestatic 21	java/lang/System:currentTimeMillis	()J
    //   3: lstore 14
    //   5: new 4	java/lang/Object
    //   8: dup
    //   9: invokespecial 161	java/lang/Object:<init>	()V
    //   12: astore 29
    //   14: iload 4
    //   16: istore 6
    //   18: iload 4
    //   20: ifge +6 -> 26
    //   23: iconst_2
    //   24: istore 6
    //   26: aload_2
    //   27: invokevirtual 192	java/io/File:getParentFile	()Ljava/io/File;
    //   30: astore_0
    //   31: aload_0
    //   32: ifnull +15 -> 47
    //   35: aload_0
    //   36: invokevirtual 195	java/io/File:exists	()Z
    //   39: ifne +8 -> 47
    //   42: aload_0
    //   43: invokevirtual 198	java/io/File:mkdirs	()Z
    //   46: pop
    //   47: aconst_null
    //   48: astore_0
    //   49: aload_1
    //   50: invokevirtual 201	java/net/URL:toString	()Ljava/lang/String;
    //   53: astore 19
    //   55: new 229	org/apache/http/client/methods/HttpGet
    //   58: dup
    //   59: aload 19
    //   61: invokespecial 230	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   64: astore 27
    //   66: new 25	org/apache/http/params/BasicHttpParams
    //   69: dup
    //   70: invokespecial 28	org/apache/http/params/BasicHttpParams:<init>	()V
    //   73: astore 30
    //   75: sipush 20000
    //   78: istore 5
    //   80: ldc 233
    //   82: istore 4
    //   84: aload_3
    //   85: ifnull +104 -> 189
    //   88: invokestatic 251	android/net/Proxy:getDefaultHost	()Ljava/lang/String;
    //   91: astore 19
    //   93: invokestatic 255	android/net/Proxy:getDefaultPort	()I
    //   96: istore 4
    //   98: aload_3
    //   99: invokevirtual 260	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   102: astore 20
    //   104: aload_3
    //   105: invokestatic 265	com/tencent/mobileqq/utils/NetworkUtil:a	(Landroid/net/NetworkInfo;)Z
    //   108: ifeq +51 -> 159
    //   111: aload 20
    //   113: ifnull +14 -> 127
    //   116: aload 20
    //   118: ldc_w 267
    //   121: invokevirtual 271	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   124: ifeq +35 -> 159
    //   127: aload 19
    //   129: ifnull +30 -> 159
    //   132: iload 4
    //   134: ifle +25 -> 159
    //   137: aload 30
    //   139: ldc_w 273
    //   142: new 275	org/apache/http/HttpHost
    //   145: dup
    //   146: aload 19
    //   148: iload 4
    //   150: invokespecial 277	org/apache/http/HttpHost:<init>	(Ljava/lang/String;I)V
    //   153: invokeinterface 244 3 0
    //   158: pop
    //   159: aload_3
    //   160: invokestatic 265	com/tencent/mobileqq/utils/NetworkUtil:a	(Landroid/net/NetworkInfo;)Z
    //   163: ifeq +896 -> 1059
    //   166: sipush 20000
    //   169: istore 5
    //   171: ldc 233
    //   173: istore 4
    //   175: aload 30
    //   177: ldc_w 279
    //   180: sipush 2048
    //   183: invokeinterface 283 3 0
    //   188: pop
    //   189: aload 30
    //   191: ldc 232
    //   193: iload 5
    //   195: invokestatic 238	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   198: invokeinterface 244 3 0
    //   203: pop
    //   204: aload 30
    //   206: ldc 246
    //   208: iload 4
    //   210: invokestatic 238	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   213: invokeinterface 244 3 0
    //   218: pop
    //   219: aload 27
    //   221: aload 30
    //   223: invokevirtual 287	org/apache/http/client/methods/HttpGet:setParams	(Lorg/apache/http/params/HttpParams;)V
    //   226: aload_2
    //   227: ifnull +15 -> 242
    //   230: aload_2
    //   231: invokevirtual 195	java/io/File:exists	()Z
    //   234: ifeq +8 -> 242
    //   237: aload_2
    //   238: invokevirtual 293	java/io/File:delete	()Z
    //   241: pop
    //   242: aconst_null
    //   243: astore 19
    //   245: iconst_m1
    //   246: istore 7
    //   248: aload_0
    //   249: astore_3
    //   250: aload 19
    //   252: astore_0
    //   253: iload 7
    //   255: ifne +36 -> 291
    //   258: aload 30
    //   260: ldc_w 273
    //   263: new 275	org/apache/http/HttpHost
    //   266: dup
    //   267: aload_1
    //   268: invokevirtual 296	java/net/URL:getHost	()Ljava/lang/String;
    //   271: aload_1
    //   272: invokevirtual 299	java/net/URL:getPort	()I
    //   275: invokespecial 277	org/apache/http/HttpHost:<init>	(Ljava/lang/String;I)V
    //   278: invokeinterface 244 3 0
    //   283: pop
    //   284: aload 27
    //   286: aload 30
    //   288: invokevirtual 287	org/apache/http/client/methods/HttpGet:setParams	(Lorg/apache/http/params/HttpParams;)V
    //   291: iconst_5
    //   292: istore 4
    //   294: aload_0
    //   295: astore 20
    //   297: aload_3
    //   298: astore 23
    //   300: aload_0
    //   301: astore 24
    //   303: aload_3
    //   304: astore 21
    //   306: aload_0
    //   307: astore 25
    //   309: aload_3
    //   310: astore 22
    //   312: aload_0
    //   313: astore 19
    //   315: aload_3
    //   316: astore 26
    //   318: getstatic 109	com/tencent/mobileqq/utils/HttpDownloadUtil:jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   321: new 275	org/apache/http/HttpHost
    //   324: dup
    //   325: aload_1
    //   326: invokevirtual 296	java/net/URL:getHost	()Ljava/lang/String;
    //   329: invokespecial 300	org/apache/http/HttpHost:<init>	(Ljava/lang/String;)V
    //   332: aload 27
    //   334: invokevirtual 304	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/HttpHost;Lorg/apache/http/HttpRequest;)Lorg/apache/http/HttpResponse;
    //   337: astore 28
    //   339: aload_0
    //   340: astore 20
    //   342: aload_3
    //   343: astore 23
    //   345: aload_0
    //   346: astore 24
    //   348: aload_3
    //   349: astore 21
    //   351: aload_0
    //   352: astore 25
    //   354: aload_3
    //   355: astore 22
    //   357: aload_0
    //   358: astore 19
    //   360: aload_3
    //   361: astore 26
    //   363: aload 28
    //   365: invokeinterface 310 1 0
    //   370: invokeinterface 319 1 0
    //   375: istore 5
    //   377: aload_0
    //   378: astore 20
    //   380: aload_3
    //   381: astore 23
    //   383: aload_0
    //   384: astore 24
    //   386: aload_3
    //   387: astore 21
    //   389: aload_0
    //   390: astore 25
    //   392: aload_3
    //   393: astore 22
    //   395: aload_0
    //   396: astore 19
    //   398: aload_3
    //   399: astore 26
    //   401: aload 28
    //   403: invokeinterface 325 1 0
    //   408: astore_0
    //   409: sipush 200
    //   412: iload 5
    //   414: if_icmpne +822 -> 1236
    //   417: aload_0
    //   418: astore 20
    //   420: aload_3
    //   421: astore 23
    //   423: aload_0
    //   424: astore 24
    //   426: aload_3
    //   427: astore 21
    //   429: aload_0
    //   430: astore 25
    //   432: aload_3
    //   433: astore 22
    //   435: aload_0
    //   436: astore 19
    //   438: aload_3
    //   439: astore 26
    //   441: aload_0
    //   442: invokeinterface 330 1 0
    //   447: lstore 16
    //   449: lconst_0
    //   450: lstore 8
    //   452: aload_0
    //   453: astore 20
    //   455: aload_3
    //   456: astore 23
    //   458: aload_0
    //   459: astore 24
    //   461: aload_3
    //   462: astore 21
    //   464: aload_0
    //   465: astore 25
    //   467: aload_3
    //   468: astore 22
    //   470: new 484	java/io/BufferedOutputStream
    //   473: dup
    //   474: new 332	java/io/FileOutputStream
    //   477: dup
    //   478: aload_2
    //   479: invokespecial 335	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   482: invokespecial 487	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   485: astore 19
    //   487: lload 8
    //   489: lstore 10
    //   491: lload 8
    //   493: lstore 12
    //   495: aload 19
    //   497: astore 21
    //   499: aload 19
    //   501: astore 22
    //   503: aload 19
    //   505: astore 20
    //   507: aload_0
    //   508: aload 19
    //   510: invokeinterface 490 2 0
    //   515: lload 8
    //   517: lstore 10
    //   519: lload 8
    //   521: lstore 12
    //   523: aload 19
    //   525: astore 21
    //   527: aload 19
    //   529: astore 22
    //   531: aload 19
    //   533: astore 20
    //   535: aload 19
    //   537: invokevirtual 493	java/io/OutputStream:flush	()V
    //   540: lload 8
    //   542: lstore 10
    //   544: lload 8
    //   546: lstore 12
    //   548: aload 19
    //   550: astore 21
    //   552: aload 19
    //   554: astore 22
    //   556: aload 19
    //   558: astore 20
    //   560: aload_2
    //   561: invokevirtual 496	java/io/File:length	()J
    //   564: lstore 8
    //   566: lload 8
    //   568: lstore 10
    //   570: lload 8
    //   572: lstore 12
    //   574: aload 19
    //   576: astore 21
    //   578: aload 19
    //   580: astore 22
    //   582: aload 19
    //   584: astore 20
    //   586: aload_2
    //   587: invokestatic 21	java/lang/System:currentTimeMillis	()J
    //   590: invokevirtual 389	java/io/File:setLastModified	(J)Z
    //   593: pop
    //   594: lload 8
    //   596: lstore 10
    //   598: lload 8
    //   600: lstore 12
    //   602: aload 19
    //   604: astore 21
    //   606: aload 19
    //   608: astore 22
    //   610: aload 19
    //   612: astore 20
    //   614: invokestatic 151	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   617: ifeq +75 -> 692
    //   620: lload 8
    //   622: lstore 10
    //   624: lload 8
    //   626: lstore 12
    //   628: aload 19
    //   630: astore 21
    //   632: aload 19
    //   634: astore 22
    //   636: aload 19
    //   638: astore 20
    //   640: ldc 153
    //   642: iconst_2
    //   643: new 208	java/lang/StringBuilder
    //   646: dup
    //   647: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   650: ldc_w 391
    //   653: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   656: invokestatic 21	java/lang/System:currentTimeMillis	()J
    //   659: lload 14
    //   661: lsub
    //   662: invokevirtual 366	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   665: ldc_w 498
    //   668: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   671: lload 8
    //   673: invokevirtual 366	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   676: ldc_w 395
    //   679: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   682: aload_1
    //   683: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   686: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   689: invokestatic 398	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   692: aload 19
    //   694: astore_3
    //   695: iconst_0
    //   696: istore 4
    //   698: iload 4
    //   700: istore 5
    //   702: lload 16
    //   704: lconst_0
    //   705: lcmp
    //   706: ifle +75 -> 781
    //   709: iload 4
    //   711: istore 5
    //   713: lload 8
    //   715: lload 16
    //   717: lcmp
    //   718: ifge +63 -> 781
    //   721: invokestatic 151	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   724: ifeq +53 -> 777
    //   727: ldc 153
    //   729: iconst_2
    //   730: new 208	java/lang/StringBuilder
    //   733: dup
    //   734: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   737: ldc_w 503
    //   740: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   743: lload 16
    //   745: invokevirtual 366	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   748: ldc_w 505
    //   751: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   754: aload_2
    //   755: invokevirtual 496	java/io/File:length	()J
    //   758: invokevirtual 366	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   761: ldc_w 416
    //   764: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   767: aload_1
    //   768: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   771: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   774: invokestatic 449	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   777: bipush 8
    //   779: istore 5
    //   781: aload_0
    //   782: ifnull +9 -> 791
    //   785: aload_0
    //   786: invokeinterface 408 1 0
    //   791: aload_3
    //   792: ifnull +7 -> 799
    //   795: aload_3
    //   796: invokevirtual 409	java/io/OutputStream:close	()V
    //   799: iload 5
    //   801: ifeq +1409 -> 2210
    //   804: aload_2
    //   805: ifnull +68 -> 873
    //   808: aload_2
    //   809: invokevirtual 192	java/io/File:getParentFile	()Ljava/io/File;
    //   812: astore 19
    //   814: aload 19
    //   816: ifnull +17 -> 833
    //   819: aload 19
    //   821: invokevirtual 195	java/io/File:exists	()Z
    //   824: ifne +9 -> 833
    //   827: aload 19
    //   829: invokevirtual 198	java/io/File:mkdirs	()Z
    //   832: pop
    //   833: aload_2
    //   834: invokevirtual 195	java/io/File:exists	()Z
    //   837: ifeq +36 -> 873
    //   840: aload_2
    //   841: invokevirtual 293	java/io/File:delete	()Z
    //   844: istore 18
    //   846: ldc 153
    //   848: iconst_1
    //   849: new 208	java/lang/StringBuilder
    //   852: dup
    //   853: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   856: ldc_w 507
    //   859: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   862: iload 18
    //   864: invokevirtual 510	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   867: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   870: invokestatic 176	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   873: iload 7
    //   875: iconst_1
    //   876: iadd
    //   877: istore 7
    //   879: invokestatic 151	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   882: ifeq +40 -> 922
    //   885: ldc 153
    //   887: iconst_2
    //   888: new 208	java/lang/StringBuilder
    //   891: dup
    //   892: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   895: ldc_w 411
    //   898: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   901: iload 5
    //   903: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   906: ldc_w 416
    //   909: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   912: aload_1
    //   913: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   916: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   919: invokestatic 176	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   922: iload 5
    //   924: ifeq +51 -> 975
    //   927: ldc 153
    //   929: iconst_1
    //   930: new 208	java/lang/StringBuilder
    //   933: dup
    //   934: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   937: ldc_w 411
    //   940: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   943: iload 5
    //   945: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   948: ldc_w 416
    //   951: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   954: aload_1
    //   955: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   958: ldc_w 512
    //   961: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   964: iload 7
    //   966: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   969: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   972: invokestatic 176	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   975: iload 5
    //   977: ifeq +23 -> 1000
    //   980: iload 7
    //   982: iconst_2
    //   983: if_icmpge +17 -> 1000
    //   986: aload 29
    //   988: monitorenter
    //   989: aload 29
    //   991: ldc2_w 513
    //   994: invokevirtual 422	java/lang/Object:wait	(J)V
    //   997: aload 29
    //   999: monitorexit
    //   1000: iload 5
    //   1002: ifeq +10 -> 1012
    //   1005: iload 7
    //   1007: iload 6
    //   1009: if_icmplt +1198 -> 2207
    //   1012: iload 5
    //   1014: ireturn
    //   1015: astore_0
    //   1016: ldc 153
    //   1018: iconst_1
    //   1019: ldc_w 516
    //   1022: invokestatic 176	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1025: iconst_4
    //   1026: ireturn
    //   1027: astore 20
    //   1029: new 229	org/apache/http/client/methods/HttpGet
    //   1032: dup
    //   1033: aload 19
    //   1035: invokestatic 357	com/tencent/mobileqq/utils/HttpDownloadUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1038: invokespecial 230	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   1041: astore 27
    //   1043: goto -977 -> 66
    //   1046: astore_0
    //   1047: ldc 153
    //   1049: iconst_1
    //   1050: ldc_w 518
    //   1053: invokestatic 176	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1056: bipush 13
    //   1058: ireturn
    //   1059: sipush 10000
    //   1062: istore 5
    //   1064: sipush 30000
    //   1067: istore 4
    //   1069: aload 30
    //   1071: ldc_w 279
    //   1074: sipush 4096
    //   1077: invokeinterface 283 3 0
    //   1082: pop
    //   1083: goto -894 -> 189
    //   1086: astore_3
    //   1087: lload 10
    //   1089: lstore 8
    //   1091: aload 19
    //   1093: astore_3
    //   1094: aload_3
    //   1095: astore 21
    //   1097: aload_3
    //   1098: astore 22
    //   1100: aload_3
    //   1101: astore 20
    //   1103: ldc 153
    //   1105: iconst_1
    //   1106: new 208	java/lang/StringBuilder
    //   1109: dup
    //   1110: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   1113: ldc_w 520
    //   1116: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1119: aload_2
    //   1120: invokevirtual 195	java/io/File:exists	()Z
    //   1123: invokevirtual 510	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1126: ldc_w 522
    //   1129: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1132: aload_2
    //   1133: invokevirtual 192	java/io/File:getParentFile	()Ljava/io/File;
    //   1136: invokevirtual 195	java/io/File:exists	()Z
    //   1139: invokevirtual 510	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1142: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1145: invokestatic 176	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1148: iconst_5
    //   1149: istore 4
    //   1151: goto -453 -> 698
    //   1154: astore 28
    //   1156: aload 19
    //   1158: astore_3
    //   1159: lload 12
    //   1161: lstore 8
    //   1163: aload_0
    //   1164: astore 20
    //   1166: aload_3
    //   1167: astore 23
    //   1169: aload_0
    //   1170: astore 24
    //   1172: aload_3
    //   1173: astore 21
    //   1175: aload_0
    //   1176: astore 25
    //   1178: aload_3
    //   1179: astore 22
    //   1181: aload_0
    //   1182: astore 19
    //   1184: aload_3
    //   1185: astore 26
    //   1187: invokestatic 151	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1190: ifeq +40 -> 1230
    //   1193: aload_0
    //   1194: astore 20
    //   1196: aload_3
    //   1197: astore 23
    //   1199: aload_0
    //   1200: astore 24
    //   1202: aload_3
    //   1203: astore 21
    //   1205: aload_0
    //   1206: astore 25
    //   1208: aload_3
    //   1209: astore 22
    //   1211: aload_0
    //   1212: astore 19
    //   1214: aload_3
    //   1215: astore 26
    //   1217: ldc 153
    //   1219: iconst_2
    //   1220: aload 28
    //   1222: invokevirtual 446	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1225: aload 28
    //   1227: invokestatic 524	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1230: iconst_4
    //   1231: istore 4
    //   1233: goto -535 -> 698
    //   1236: goto -455 -> 781
    //   1239: astore 19
    //   1241: aload 19
    //   1243: invokevirtual 435	java/io/IOException:printStackTrace	()V
    //   1246: goto -455 -> 791
    //   1249: astore 19
    //   1251: goto -378 -> 873
    //   1254: astore 20
    //   1256: iconst_5
    //   1257: istore 4
    //   1259: aload_0
    //   1260: astore 19
    //   1262: aload 20
    //   1264: astore_0
    //   1265: aload_3
    //   1266: astore 20
    //   1268: invokestatic 151	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1271: ifeq +30 -> 1301
    //   1274: ldc 153
    //   1276: iconst_2
    //   1277: new 208	java/lang/StringBuilder
    //   1280: dup
    //   1281: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   1284: ldc_w 526
    //   1287: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1290: aload_1
    //   1291: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1294: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1297: aload_0
    //   1298: invokestatic 524	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1301: aload_0
    //   1302: instanceof 437
    //   1305: istore 18
    //   1307: iload 18
    //   1309: ifeq +156 -> 1465
    //   1312: bipush 10
    //   1314: istore 4
    //   1316: aload 19
    //   1318: ifnull +10 -> 1328
    //   1321: aload 19
    //   1323: invokeinterface 408 1 0
    //   1328: aload 20
    //   1330: ifnull +8 -> 1338
    //   1333: aload 20
    //   1335: invokevirtual 409	java/io/OutputStream:close	()V
    //   1338: aload 19
    //   1340: astore_0
    //   1341: aload 20
    //   1343: astore_3
    //   1344: iload 4
    //   1346: istore 5
    //   1348: iload 4
    //   1350: ifeq -477 -> 873
    //   1353: aload 19
    //   1355: astore_0
    //   1356: aload 20
    //   1358: astore_3
    //   1359: iload 4
    //   1361: istore 5
    //   1363: aload_2
    //   1364: ifnull -491 -> 873
    //   1367: aload_2
    //   1368: invokevirtual 192	java/io/File:getParentFile	()Ljava/io/File;
    //   1371: astore_0
    //   1372: aload_0
    //   1373: ifnull +15 -> 1388
    //   1376: aload_0
    //   1377: invokevirtual 195	java/io/File:exists	()Z
    //   1380: ifne +8 -> 1388
    //   1383: aload_0
    //   1384: invokevirtual 198	java/io/File:mkdirs	()Z
    //   1387: pop
    //   1388: aload 19
    //   1390: astore_0
    //   1391: aload 20
    //   1393: astore_3
    //   1394: iload 4
    //   1396: istore 5
    //   1398: aload_2
    //   1399: invokevirtual 195	java/io/File:exists	()Z
    //   1402: ifeq -529 -> 873
    //   1405: aload_2
    //   1406: invokevirtual 293	java/io/File:delete	()Z
    //   1409: istore 18
    //   1411: ldc 153
    //   1413: iconst_1
    //   1414: new 208	java/lang/StringBuilder
    //   1417: dup
    //   1418: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   1421: ldc_w 507
    //   1424: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1427: iload 18
    //   1429: invokevirtual 510	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1432: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1435: invokestatic 176	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1438: aload 19
    //   1440: astore_0
    //   1441: aload 20
    //   1443: astore_3
    //   1444: iload 4
    //   1446: istore 5
    //   1448: goto -575 -> 873
    //   1451: astore_0
    //   1452: aload 19
    //   1454: astore_0
    //   1455: aload 20
    //   1457: astore_3
    //   1458: iload 4
    //   1460: istore 5
    //   1462: goto -589 -> 873
    //   1465: aload_0
    //   1466: instanceof 430
    //   1469: ifne +744 -> 2213
    //   1472: aload_0
    //   1473: instanceof 432
    //   1476: ifeq +6 -> 1482
    //   1479: goto +734 -> 2213
    //   1482: aload_0
    //   1483: instanceof 457
    //   1486: istore 18
    //   1488: iload 18
    //   1490: ifeq +10 -> 1500
    //   1493: bipush 11
    //   1495: istore 4
    //   1497: goto -181 -> 1316
    //   1500: iconst_4
    //   1501: istore 4
    //   1503: goto -187 -> 1316
    //   1506: astore_0
    //   1507: aload_0
    //   1508: invokevirtual 435	java/io/IOException:printStackTrace	()V
    //   1511: goto -183 -> 1328
    //   1514: astore_3
    //   1515: aload 21
    //   1517: astore 20
    //   1519: iload 4
    //   1521: istore 5
    //   1523: aload_3
    //   1524: astore 21
    //   1526: aload_0
    //   1527: astore 19
    //   1529: aload 19
    //   1531: astore_0
    //   1532: aload 20
    //   1534: astore_3
    //   1535: iload 5
    //   1537: istore 4
    //   1539: invokestatic 151	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1542: ifeq +41 -> 1583
    //   1545: aload 19
    //   1547: astore_0
    //   1548: aload 20
    //   1550: astore_3
    //   1551: iload 5
    //   1553: istore 4
    //   1555: ldc 153
    //   1557: iconst_2
    //   1558: new 208	java/lang/StringBuilder
    //   1561: dup
    //   1562: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   1565: ldc_w 528
    //   1568: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1571: aload_1
    //   1572: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1575: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1578: aload 21
    //   1580: invokestatic 524	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1583: iconst_5
    //   1584: istore 4
    //   1586: aload 19
    //   1588: ifnull +10 -> 1598
    //   1591: aload 19
    //   1593: invokeinterface 408 1 0
    //   1598: aload 20
    //   1600: ifnull +8 -> 1608
    //   1603: aload 20
    //   1605: invokevirtual 409	java/io/OutputStream:close	()V
    //   1608: aload 19
    //   1610: astore_0
    //   1611: aload 20
    //   1613: astore_3
    //   1614: iload 4
    //   1616: istore 5
    //   1618: aload_2
    //   1619: ifnull -746 -> 873
    //   1622: aload_2
    //   1623: invokevirtual 192	java/io/File:getParentFile	()Ljava/io/File;
    //   1626: astore_0
    //   1627: aload_0
    //   1628: ifnull +15 -> 1643
    //   1631: aload_0
    //   1632: invokevirtual 195	java/io/File:exists	()Z
    //   1635: ifne +8 -> 1643
    //   1638: aload_0
    //   1639: invokevirtual 198	java/io/File:mkdirs	()Z
    //   1642: pop
    //   1643: aload 19
    //   1645: astore_0
    //   1646: aload 20
    //   1648: astore_3
    //   1649: iload 4
    //   1651: istore 5
    //   1653: aload_2
    //   1654: invokevirtual 195	java/io/File:exists	()Z
    //   1657: ifeq -784 -> 873
    //   1660: aload_2
    //   1661: invokevirtual 293	java/io/File:delete	()Z
    //   1664: istore 18
    //   1666: ldc 153
    //   1668: iconst_1
    //   1669: new 208	java/lang/StringBuilder
    //   1672: dup
    //   1673: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   1676: ldc_w 507
    //   1679: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1682: iload 18
    //   1684: invokevirtual 510	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1687: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1690: invokestatic 176	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1693: aload 19
    //   1695: astore_0
    //   1696: aload 20
    //   1698: astore_3
    //   1699: iload 4
    //   1701: istore 5
    //   1703: goto -830 -> 873
    //   1706: astore_0
    //   1707: aload 19
    //   1709: astore_0
    //   1710: aload 20
    //   1712: astore_3
    //   1713: iload 4
    //   1715: istore 5
    //   1717: goto -844 -> 873
    //   1720: astore_0
    //   1721: aload_0
    //   1722: invokevirtual 435	java/io/IOException:printStackTrace	()V
    //   1725: goto -127 -> 1598
    //   1728: astore 21
    //   1730: aload 22
    //   1732: astore 20
    //   1734: iload 4
    //   1736: istore 5
    //   1738: aload_0
    //   1739: astore 19
    //   1741: aload 19
    //   1743: astore_0
    //   1744: aload 20
    //   1746: astore_3
    //   1747: iload 5
    //   1749: istore 4
    //   1751: invokestatic 151	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1754: ifeq +41 -> 1795
    //   1757: aload 19
    //   1759: astore_0
    //   1760: aload 20
    //   1762: astore_3
    //   1763: iload 5
    //   1765: istore 4
    //   1767: ldc 153
    //   1769: iconst_2
    //   1770: new 208	java/lang/StringBuilder
    //   1773: dup
    //   1774: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   1777: ldc_w 528
    //   1780: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1783: aload_1
    //   1784: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1787: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1790: aload 21
    //   1792: invokestatic 524	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1795: iconst_5
    //   1796: istore 4
    //   1798: aload 19
    //   1800: ifnull +10 -> 1810
    //   1803: aload 19
    //   1805: invokeinterface 408 1 0
    //   1810: aload 20
    //   1812: ifnull +8 -> 1820
    //   1815: aload 20
    //   1817: invokevirtual 409	java/io/OutputStream:close	()V
    //   1820: aload 19
    //   1822: astore_0
    //   1823: aload 20
    //   1825: astore_3
    //   1826: iload 4
    //   1828: istore 5
    //   1830: aload_2
    //   1831: ifnull -958 -> 873
    //   1834: aload_2
    //   1835: invokevirtual 192	java/io/File:getParentFile	()Ljava/io/File;
    //   1838: astore_0
    //   1839: aload_0
    //   1840: ifnull +15 -> 1855
    //   1843: aload_0
    //   1844: invokevirtual 195	java/io/File:exists	()Z
    //   1847: ifne +8 -> 1855
    //   1850: aload_0
    //   1851: invokevirtual 198	java/io/File:mkdirs	()Z
    //   1854: pop
    //   1855: aload 19
    //   1857: astore_0
    //   1858: aload 20
    //   1860: astore_3
    //   1861: iload 4
    //   1863: istore 5
    //   1865: aload_2
    //   1866: invokevirtual 195	java/io/File:exists	()Z
    //   1869: ifeq -996 -> 873
    //   1872: aload_2
    //   1873: invokevirtual 293	java/io/File:delete	()Z
    //   1876: istore 18
    //   1878: ldc 153
    //   1880: iconst_1
    //   1881: new 208	java/lang/StringBuilder
    //   1884: dup
    //   1885: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   1888: ldc_w 507
    //   1891: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1894: iload 18
    //   1896: invokevirtual 510	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1899: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1902: invokestatic 176	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1905: aload 19
    //   1907: astore_0
    //   1908: aload 20
    //   1910: astore_3
    //   1911: iload 4
    //   1913: istore 5
    //   1915: goto -1042 -> 873
    //   1918: astore_0
    //   1919: aload 19
    //   1921: astore_0
    //   1922: aload 20
    //   1924: astore_3
    //   1925: iload 4
    //   1927: istore 5
    //   1929: goto -1056 -> 873
    //   1932: astore_0
    //   1933: aload_0
    //   1934: invokevirtual 435	java/io/IOException:printStackTrace	()V
    //   1937: goto -127 -> 1810
    //   1940: astore_1
    //   1941: aload 20
    //   1943: astore_3
    //   1944: aload_0
    //   1945: ifnull +9 -> 1954
    //   1948: aload_0
    //   1949: invokeinterface 408 1 0
    //   1954: aload_3
    //   1955: ifnull +7 -> 1962
    //   1958: aload_3
    //   1959: invokevirtual 409	java/io/OutputStream:close	()V
    //   1962: iload 4
    //   1964: ifeq +68 -> 2032
    //   1967: aload_2
    //   1968: ifnull +64 -> 2032
    //   1971: aload_2
    //   1972: invokevirtual 192	java/io/File:getParentFile	()Ljava/io/File;
    //   1975: astore_0
    //   1976: aload_0
    //   1977: ifnull +15 -> 1992
    //   1980: aload_0
    //   1981: invokevirtual 195	java/io/File:exists	()Z
    //   1984: ifne +8 -> 1992
    //   1987: aload_0
    //   1988: invokevirtual 198	java/io/File:mkdirs	()Z
    //   1991: pop
    //   1992: aload_2
    //   1993: invokevirtual 195	java/io/File:exists	()Z
    //   1996: ifeq +36 -> 2032
    //   1999: aload_2
    //   2000: invokevirtual 293	java/io/File:delete	()Z
    //   2003: istore 18
    //   2005: ldc 153
    //   2007: iconst_1
    //   2008: new 208	java/lang/StringBuilder
    //   2011: dup
    //   2012: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   2015: ldc_w 507
    //   2018: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2021: iload 18
    //   2023: invokevirtual 510	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2026: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2029: invokestatic 176	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2032: aload_1
    //   2033: athrow
    //   2034: astore_0
    //   2035: aload_0
    //   2036: invokevirtual 435	java/io/IOException:printStackTrace	()V
    //   2039: goto -85 -> 1954
    //   2042: astore_0
    //   2043: aload 29
    //   2045: monitorexit
    //   2046: aload_0
    //   2047: athrow
    //   2048: astore 19
    //   2050: goto -1251 -> 799
    //   2053: astore_0
    //   2054: goto -716 -> 1338
    //   2057: astore_0
    //   2058: goto -450 -> 1608
    //   2061: astore_0
    //   2062: goto -242 -> 1820
    //   2065: astore_0
    //   2066: goto -104 -> 1962
    //   2069: astore 19
    //   2071: goto -1074 -> 997
    //   2074: astore_0
    //   2075: goto -43 -> 2032
    //   2078: astore_1
    //   2079: aload 23
    //   2081: astore_3
    //   2082: aload 20
    //   2084: astore_0
    //   2085: goto -141 -> 1944
    //   2088: astore_1
    //   2089: goto -145 -> 1944
    //   2092: astore_1
    //   2093: aload 19
    //   2095: astore_0
    //   2096: aload 20
    //   2098: astore_3
    //   2099: goto -155 -> 1944
    //   2102: astore_1
    //   2103: goto -159 -> 1944
    //   2106: astore_0
    //   2107: aload 24
    //   2109: astore 19
    //   2111: aload 21
    //   2113: astore 20
    //   2115: aload_0
    //   2116: astore 21
    //   2118: iload 4
    //   2120: istore 5
    //   2122: goto -381 -> 1741
    //   2125: astore 21
    //   2127: aload_0
    //   2128: astore 19
    //   2130: aload_3
    //   2131: astore 20
    //   2133: iload 4
    //   2135: istore 5
    //   2137: goto -396 -> 1741
    //   2140: astore 21
    //   2142: aload 25
    //   2144: astore 19
    //   2146: aload 22
    //   2148: astore 20
    //   2150: iload 4
    //   2152: istore 5
    //   2154: goto -625 -> 1529
    //   2157: astore 21
    //   2159: aload_0
    //   2160: astore 19
    //   2162: aload_3
    //   2163: astore 20
    //   2165: iload 4
    //   2167: istore 5
    //   2169: goto -640 -> 1529
    //   2172: astore_0
    //   2173: iconst_5
    //   2174: istore 4
    //   2176: aload 26
    //   2178: astore 20
    //   2180: goto -912 -> 1268
    //   2183: astore 21
    //   2185: aload_0
    //   2186: astore 19
    //   2188: aload_3
    //   2189: astore 20
    //   2191: aload 21
    //   2193: astore_0
    //   2194: goto -926 -> 1268
    //   2197: astore 28
    //   2199: goto -1036 -> 1163
    //   2202: astore 19
    //   2204: goto -1110 -> 1094
    //   2207: goto -1954 -> 253
    //   2210: goto -1337 -> 873
    //   2213: iconst_2
    //   2214: istore 4
    //   2216: goto -900 -> 1316
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2219	0	paramAppInterface	AppInterface
    //   0	2219	1	paramURL	URL
    //   0	2219	2	paramFile	File
    //   0	2219	3	paramNetworkInfo	NetworkInfo
    //   0	2219	4	paramInt	int
    //   78	2090	5	i	int
    //   16	994	6	j	int
    //   246	764	7	k	int
    //   450	712	8	l1	long
    //   489	599	10	l2	long
    //   493	667	12	l3	long
    //   3	657	14	l4	long
    //   447	297	16	l5	long
    //   844	1178	18	bool	boolean
    //   53	1160	19	localObject1	Object
    //   1239	3	19	localIOException1	java.io.IOException
    //   1249	1	19	localException1	Exception
    //   1260	660	19	localAppInterface1	AppInterface
    //   2048	1	19	localIOException2	java.io.IOException
    //   2069	25	19	localInterruptedException	java.lang.InterruptedException
    //   2109	78	19	localObject2	Object
    //   2202	1	19	localFileNotFoundException	java.io.FileNotFoundException
    //   102	537	20	localObject3	Object
    //   1027	1	20	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   1101	94	20	localObject4	Object
    //   1254	9	20	localIOException3	java.io.IOException
    //   1266	924	20	localObject5	Object
    //   304	1275	21	localObject6	Object
    //   1728	384	21	localThrowable1	java.lang.Throwable
    //   2116	1	21	localAppInterface2	AppInterface
    //   2125	1	21	localThrowable2	java.lang.Throwable
    //   2140	1	21	localException2	Exception
    //   2157	1	21	localException3	Exception
    //   2183	9	21	localIOException4	java.io.IOException
    //   310	1837	22	localObject7	Object
    //   298	1782	23	localNetworkInfo1	NetworkInfo
    //   301	1807	24	localAppInterface3	AppInterface
    //   307	1836	25	localAppInterface4	AppInterface
    //   316	1861	26	localNetworkInfo2	NetworkInfo
    //   64	978	27	localHttpGet	org.apache.http.client.methods.HttpGet
    //   337	65	28	localHttpResponse	org.apache.http.HttpResponse
    //   1154	72	28	localIOException5	java.io.IOException
    //   2197	1	28	localIOException6	java.io.IOException
    //   12	2032	29	localObject8	Object
    //   73	997	30	localBasicHttpParams	BasicHttpParams
    // Exception table:
    //   from	to	target	type
    //   26	31	1015	java/lang/Exception
    //   35	47	1015	java/lang/Exception
    //   55	66	1027	java/lang/IllegalArgumentException
    //   1029	1043	1046	java/lang/IllegalArgumentException
    //   507	515	1086	java/io/FileNotFoundException
    //   535	540	1086	java/io/FileNotFoundException
    //   560	566	1086	java/io/FileNotFoundException
    //   586	594	1086	java/io/FileNotFoundException
    //   614	620	1086	java/io/FileNotFoundException
    //   640	692	1086	java/io/FileNotFoundException
    //   507	515	1154	java/io/IOException
    //   535	540	1154	java/io/IOException
    //   560	566	1154	java/io/IOException
    //   586	594	1154	java/io/IOException
    //   614	620	1154	java/io/IOException
    //   640	692	1154	java/io/IOException
    //   785	791	1239	java/io/IOException
    //   808	814	1249	java/lang/Exception
    //   819	833	1249	java/lang/Exception
    //   833	873	1249	java/lang/Exception
    //   1103	1148	1254	java/io/IOException
    //   1367	1372	1451	java/lang/Exception
    //   1376	1388	1451	java/lang/Exception
    //   1398	1438	1451	java/lang/Exception
    //   1321	1328	1506	java/io/IOException
    //   507	515	1514	java/lang/Exception
    //   535	540	1514	java/lang/Exception
    //   560	566	1514	java/lang/Exception
    //   586	594	1514	java/lang/Exception
    //   614	620	1514	java/lang/Exception
    //   640	692	1514	java/lang/Exception
    //   1103	1148	1514	java/lang/Exception
    //   1622	1627	1706	java/lang/Exception
    //   1631	1643	1706	java/lang/Exception
    //   1653	1693	1706	java/lang/Exception
    //   1591	1598	1720	java/io/IOException
    //   507	515	1728	java/lang/Throwable
    //   535	540	1728	java/lang/Throwable
    //   560	566	1728	java/lang/Throwable
    //   586	594	1728	java/lang/Throwable
    //   614	620	1728	java/lang/Throwable
    //   640	692	1728	java/lang/Throwable
    //   1103	1148	1728	java/lang/Throwable
    //   1834	1839	1918	java/lang/Exception
    //   1843	1855	1918	java/lang/Exception
    //   1865	1905	1918	java/lang/Exception
    //   1803	1810	1932	java/io/IOException
    //   507	515	1940	finally
    //   535	540	1940	finally
    //   560	566	1940	finally
    //   586	594	1940	finally
    //   614	620	1940	finally
    //   640	692	1940	finally
    //   1103	1148	1940	finally
    //   1948	1954	2034	java/io/IOException
    //   989	997	2042	finally
    //   997	1000	2042	finally
    //   2043	2046	2042	finally
    //   795	799	2048	java/io/IOException
    //   1333	1338	2053	java/io/IOException
    //   1603	1608	2057	java/io/IOException
    //   1815	1820	2061	java/io/IOException
    //   1958	1962	2065	java/io/IOException
    //   989	997	2069	java/lang/InterruptedException
    //   1971	1976	2074	java/lang/Exception
    //   1980	1992	2074	java/lang/Exception
    //   1992	2032	2074	java/lang/Exception
    //   318	339	2078	finally
    //   363	377	2078	finally
    //   401	409	2078	finally
    //   441	449	2078	finally
    //   470	487	2078	finally
    //   1187	1193	2078	finally
    //   1217	1230	2078	finally
    //   721	777	2088	finally
    //   1268	1301	2092	finally
    //   1301	1307	2092	finally
    //   1465	1479	2092	finally
    //   1482	1488	2092	finally
    //   1539	1545	2102	finally
    //   1555	1583	2102	finally
    //   1751	1757	2102	finally
    //   1767	1795	2102	finally
    //   318	339	2106	java/lang/Throwable
    //   363	377	2106	java/lang/Throwable
    //   401	409	2106	java/lang/Throwable
    //   441	449	2106	java/lang/Throwable
    //   470	487	2106	java/lang/Throwable
    //   1187	1193	2106	java/lang/Throwable
    //   1217	1230	2106	java/lang/Throwable
    //   721	777	2125	java/lang/Throwable
    //   318	339	2140	java/lang/Exception
    //   363	377	2140	java/lang/Exception
    //   401	409	2140	java/lang/Exception
    //   441	449	2140	java/lang/Exception
    //   470	487	2140	java/lang/Exception
    //   1187	1193	2140	java/lang/Exception
    //   1217	1230	2140	java/lang/Exception
    //   721	777	2157	java/lang/Exception
    //   318	339	2172	java/io/IOException
    //   363	377	2172	java/io/IOException
    //   401	409	2172	java/io/IOException
    //   441	449	2172	java/io/IOException
    //   1187	1193	2172	java/io/IOException
    //   1217	1230	2172	java/io/IOException
    //   721	777	2183	java/io/IOException
    //   470	487	2197	java/io/IOException
    //   470	487	2202	java/io/FileNotFoundException
  }
  
  public static DownloadInfo a(String paramString, HttpDownloadUtil.DownloadInfoListener paramDownloadInfoListener)
  {
    return a(paramString, paramDownloadInfoListener, null, 2, true);
  }
  
  public static DownloadInfo a(String paramString, HttpDownloadUtil.DownloadInfoListener paramDownloadInfoListener, List paramList, int paramInt, boolean paramBoolean)
  {
    return a(paramString, paramDownloadInfoListener, paramList, paramInt, paramBoolean, 0);
  }
  
  /* Error */
  private static DownloadInfo a(String paramString, HttpDownloadUtil.DownloadInfoListener paramDownloadInfoListener, List paramList, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    // Byte code:
    //   0: new 180	com/tencent/mobileqq/emoticon/DownloadInfo
    //   3: dup
    //   4: aload_0
    //   5: aconst_null
    //   6: iconst_0
    //   7: invokespecial 538	com/tencent/mobileqq/emoticon/DownloadInfo:<init>	(Ljava/lang/String;Ljava/io/File;I)V
    //   10: astore 18
    //   12: iload 5
    //   14: iconst_3
    //   15: if_icmplt +30 -> 45
    //   18: invokestatic 151	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   21: ifeq +12 -> 33
    //   24: ldc 153
    //   26: iconst_2
    //   27: ldc_w 540
    //   30: invokestatic 449	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   33: aload 18
    //   35: bipush 20
    //   37: putfield 459	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   40: aload 18
    //   42: astore_0
    //   43: aload_0
    //   44: areturn
    //   45: new 178	java/net/URL
    //   48: dup
    //   49: aload 18
    //   51: getfield 182	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   54: invokespecial 183	java/net/URL:<init>	(Ljava/lang/String;)V
    //   57: pop
    //   58: aload 18
    //   60: getfield 182	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   63: astore 16
    //   65: new 229	org/apache/http/client/methods/HttpGet
    //   68: dup
    //   69: aload 16
    //   71: invokespecial 230	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   74: pop
    //   75: new 4	java/lang/Object
    //   78: dup
    //   79: invokespecial 161	java/lang/Object:<init>	()V
    //   82: astore 19
    //   84: aconst_null
    //   85: astore 12
    //   87: iconst_0
    //   88: istore 7
    //   90: ldc2_w 417
    //   93: lstore 9
    //   95: invokestatic 467	com/tencent/mobileqq/msf/sdk/AppNetConnInfo:getRecentNetworkInfo	()Landroid/net/NetworkInfo;
    //   98: astore 20
    //   100: aload 20
    //   102: ifnonnull +196 -> 298
    //   105: invokestatic 151	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   108: ifeq +12 -> 120
    //   111: ldc 153
    //   113: iconst_2
    //   114: ldc_w 542
    //   117: invokestatic 449	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   120: aload 18
    //   122: iconst_1
    //   123: putfield 459	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   126: iload 7
    //   128: iconst_1
    //   129: iadd
    //   130: istore 6
    //   132: iload 6
    //   134: iload_3
    //   135: if_icmplt +133 -> 268
    //   138: aload_1
    //   139: ifnull +12 -> 151
    //   142: aload_1
    //   143: aload 18
    //   145: invokeinterface 547 2 0
    //   150: pop
    //   151: aload 18
    //   153: areturn
    //   154: astore_0
    //   155: invokestatic 151	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   158: ifeq +13 -> 171
    //   161: ldc 153
    //   163: iconst_2
    //   164: aload_0
    //   165: invokevirtual 548	java/net/MalformedURLException:toString	()Ljava/lang/String;
    //   168: invokestatic 449	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   171: aload 18
    //   173: aload_0
    //   174: invokestatic 225	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   177: putfield 227	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   180: aload 18
    //   182: bipush 13
    //   184: putfield 459	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   187: aload_1
    //   188: ifnull +12 -> 200
    //   191: aload_1
    //   192: aload 18
    //   194: invokeinterface 547 2 0
    //   199: pop
    //   200: aload 18
    //   202: areturn
    //   203: astore 12
    //   205: new 229	org/apache/http/client/methods/HttpGet
    //   208: dup
    //   209: aload 16
    //   211: invokestatic 357	com/tencent/mobileqq/utils/HttpDownloadUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   214: invokespecial 230	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   217: pop
    //   218: aload 16
    //   220: invokestatic 357	com/tencent/mobileqq/utils/HttpDownloadUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   223: astore 16
    //   225: goto -150 -> 75
    //   228: astore_0
    //   229: invokestatic 151	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   232: ifeq +13 -> 245
    //   235: ldc 153
    //   237: iconst_2
    //   238: aload_0
    //   239: invokevirtual 549	java/lang/IllegalArgumentException:toString	()Ljava/lang/String;
    //   242: invokestatic 449	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   245: aload 18
    //   247: bipush 13
    //   249: putfield 459	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   252: aload_1
    //   253: ifnull +12 -> 265
    //   256: aload_1
    //   257: aload 18
    //   259: invokeinterface 547 2 0
    //   264: pop
    //   265: aload 18
    //   267: areturn
    //   268: aload 19
    //   270: monitorenter
    //   271: aload 19
    //   273: lload 9
    //   275: invokevirtual 422	java/lang/Object:wait	(J)V
    //   278: lload 9
    //   280: ldc2_w 550
    //   283: lmul
    //   284: lstore 9
    //   286: aload 19
    //   288: monitorexit
    //   289: goto +2095 -> 2384
    //   292: astore_0
    //   293: aload 19
    //   295: monitorexit
    //   296: aload_0
    //   297: athrow
    //   298: aconst_null
    //   299: astore 17
    //   301: iconst_m1
    //   302: istore 6
    //   304: aload 20
    //   306: ifnull +41 -> 347
    //   309: aload 12
    //   311: astore 15
    //   313: aload 12
    //   315: astore 14
    //   317: aload 12
    //   319: astore 13
    //   321: aload 20
    //   323: invokevirtual 260	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   326: astore 17
    //   328: aload 12
    //   330: astore 15
    //   332: aload 12
    //   334: astore 14
    //   336: aload 12
    //   338: astore 13
    //   340: aload 20
    //   342: invokevirtual 554	android/net/NetworkInfo:getType	()I
    //   345: istore 6
    //   347: aload 12
    //   349: astore 15
    //   351: aload 12
    //   353: astore 14
    //   355: aload 12
    //   357: astore 13
    //   359: invokestatic 251	android/net/Proxy:getDefaultHost	()Ljava/lang/String;
    //   362: astore 20
    //   364: aload 12
    //   366: astore 15
    //   368: aload 12
    //   370: astore 14
    //   372: aload 12
    //   374: astore 13
    //   376: invokestatic 255	android/net/Proxy:getDefaultPort	()I
    //   379: istore 8
    //   381: aload 12
    //   383: astore 15
    //   385: aload 12
    //   387: astore 14
    //   389: aload 12
    //   391: astore 13
    //   393: aload 17
    //   395: invokestatic 558	com/tencent/mobileqq/utils/httputils/PkgTools:b	(Ljava/lang/String;)Ljava/lang/String;
    //   398: astore 17
    //   400: aload 12
    //   402: astore 15
    //   404: aload 12
    //   406: astore 14
    //   408: aload 12
    //   410: astore 13
    //   412: aload 17
    //   414: getstatic 559	com/tencent/mobileqq/utils/HttpDownloadUtil:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   417: invokevirtual 563	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   420: ifne +65 -> 485
    //   423: aload 12
    //   425: astore 15
    //   427: aload 12
    //   429: astore 14
    //   431: aload 12
    //   433: astore 13
    //   435: aload 17
    //   437: putstatic 559	com/tencent/mobileqq/utils/HttpDownloadUtil:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   440: iload 6
    //   442: iconst_1
    //   443: if_icmpeq +26 -> 469
    //   446: aload 12
    //   448: astore 15
    //   450: aload 12
    //   452: astore 14
    //   454: aload 12
    //   456: astore 13
    //   458: aload 17
    //   460: getstatic 565	com/tencent/mobileqq/utils/httputils/PkgTools:d	Ljava/lang/String;
    //   463: invokevirtual 563	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   466: ifeq +558 -> 1024
    //   469: aload 12
    //   471: astore 15
    //   473: aload 12
    //   475: astore 14
    //   477: aload 12
    //   479: astore 13
    //   481: iconst_0
    //   482: putstatic 567	com/tencent/mobileqq/utils/HttpDownloadUtil:jdField_a_of_type_Boolean	Z
    //   485: iload 6
    //   487: iconst_1
    //   488: if_icmpne +65 -> 553
    //   491: aload 12
    //   493: astore 15
    //   495: aload 12
    //   497: astore 14
    //   499: aload 12
    //   501: astore 13
    //   503: ldc_w 569
    //   506: aload 20
    //   508: invokevirtual 563	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   511: ifne +26 -> 537
    //   514: aload 12
    //   516: astore 15
    //   518: aload 12
    //   520: astore 14
    //   522: aload 12
    //   524: astore 13
    //   526: ldc_w 571
    //   529: aload 20
    //   531: invokevirtual 563	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   534: ifeq +19 -> 553
    //   537: aload 12
    //   539: astore 15
    //   541: aload 12
    //   543: astore 14
    //   545: aload 12
    //   547: astore 13
    //   549: iconst_1
    //   550: putstatic 567	com/tencent/mobileqq/utils/HttpDownloadUtil:jdField_a_of_type_Boolean	Z
    //   553: aload 12
    //   555: astore 15
    //   557: aload 12
    //   559: astore 14
    //   561: aload 12
    //   563: astore 13
    //   565: getstatic 567	com/tencent/mobileqq/utils/HttpDownloadUtil:jdField_a_of_type_Boolean	Z
    //   568: ifne +704 -> 1272
    //   571: aload 20
    //   573: ifnull +699 -> 1272
    //   576: iload 8
    //   578: ifle +694 -> 1272
    //   581: aload 12
    //   583: astore 15
    //   585: aload 12
    //   587: astore 14
    //   589: aload 12
    //   591: astore 13
    //   593: aload 17
    //   595: getstatic 565	com/tencent/mobileqq/utils/httputils/PkgTools:d	Ljava/lang/String;
    //   598: invokevirtual 563	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   601: ifne +49 -> 650
    //   604: aload 12
    //   606: astore 15
    //   608: aload 12
    //   610: astore 14
    //   612: aload 12
    //   614: astore 13
    //   616: aload 17
    //   618: getstatic 574	com/tencent/mobileqq/utils/httputils/PkgTools:f	Ljava/lang/String;
    //   621: invokevirtual 563	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   624: ifne +26 -> 650
    //   627: aload 12
    //   629: astore 15
    //   631: aload 12
    //   633: astore 14
    //   635: aload 12
    //   637: astore 13
    //   639: aload 17
    //   641: getstatic 577	com/tencent/mobileqq/utils/httputils/PkgTools:h	Ljava/lang/String;
    //   644: invokevirtual 563	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   647: ifeq +550 -> 1197
    //   650: aload 12
    //   652: astore 15
    //   654: aload 12
    //   656: astore 14
    //   658: aload 12
    //   660: astore 13
    //   662: aload 16
    //   664: aload 20
    //   666: iload 8
    //   668: invokestatic 580	com/tencent/mobileqq/utils/httputils/PkgTools:b	(Ljava/lang/String;Ljava/lang/String;I)Ljava/net/HttpURLConnection;
    //   671: astore 12
    //   673: aload 12
    //   675: astore 15
    //   677: aload 12
    //   679: astore 14
    //   681: aload 12
    //   683: astore 13
    //   685: aload 18
    //   687: aload 12
    //   689: putfield 583	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_a_of_type_JavaNetHttpURLConnection	Ljava/net/HttpURLConnection;
    //   692: aload_2
    //   693: ifnull +614 -> 1307
    //   696: aload 12
    //   698: astore 15
    //   700: aload 12
    //   702: astore 14
    //   704: aload 12
    //   706: astore 13
    //   708: aload_2
    //   709: invokeinterface 588 1 0
    //   714: ifne +593 -> 1307
    //   717: aload 12
    //   719: astore 15
    //   721: aload 12
    //   723: astore 14
    //   725: aload 12
    //   727: astore 13
    //   729: aload_2
    //   730: invokeinterface 592 1 0
    //   735: astore 17
    //   737: aload 12
    //   739: astore 15
    //   741: aload 12
    //   743: astore 14
    //   745: aload 12
    //   747: astore 13
    //   749: aload 17
    //   751: invokeinterface 597 1 0
    //   756: ifeq +551 -> 1307
    //   759: aload 12
    //   761: astore 15
    //   763: aload 12
    //   765: astore 14
    //   767: aload 12
    //   769: astore 13
    //   771: aload 17
    //   773: invokeinterface 601 1 0
    //   778: checkcast 603	org/apache/http/Header
    //   781: astore 20
    //   783: aload 12
    //   785: astore 15
    //   787: aload 12
    //   789: astore 14
    //   791: aload 12
    //   793: astore 13
    //   795: aload 12
    //   797: aload 20
    //   799: invokeinterface 606 1 0
    //   804: aload 20
    //   806: invokeinterface 609 1 0
    //   811: invokevirtual 615	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   814: goto -77 -> 737
    //   817: astore 14
    //   819: aload 15
    //   821: astore 12
    //   823: aload 12
    //   825: astore 13
    //   827: invokestatic 151	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   830: ifeq +12 -> 842
    //   833: aload 12
    //   835: astore 13
    //   837: aload 14
    //   839: invokevirtual 435	java/io/IOException:printStackTrace	()V
    //   842: iconst_5
    //   843: istore 6
    //   845: aload 12
    //   847: astore 13
    //   849: aload 14
    //   851: instanceof 437
    //   854: ifeq +1379 -> 2233
    //   857: bipush 10
    //   859: istore 6
    //   861: iload_3
    //   862: istore 7
    //   864: aload 12
    //   866: astore 13
    //   868: aload 18
    //   870: iload 6
    //   872: putfield 459	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   875: aload 12
    //   877: astore 13
    //   879: invokestatic 151	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   882: ifeq +76 -> 958
    //   885: aload 12
    //   887: astore 13
    //   889: ldc 153
    //   891: iconst_2
    //   892: new 208	java/lang/StringBuilder
    //   895: dup
    //   896: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   899: ldc_w 617
    //   902: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   905: iload 6
    //   907: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   910: ldc_w 619
    //   913: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   916: aload 18
    //   918: getfield 621	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_c_of_type_Int	I
    //   921: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   924: ldc_w 441
    //   927: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   930: aload 18
    //   932: getfield 182	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   935: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   938: ldc_w 623
    //   941: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   944: aload 14
    //   946: invokevirtual 624	java/io/IOException:toString	()Ljava/lang/String;
    //   949: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   952: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   955: invokestatic 449	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   958: aload 12
    //   960: astore 13
    //   962: iload 7
    //   964: istore 6
    //   966: aload 12
    //   968: ifnull +16 -> 984
    //   971: aload 12
    //   973: invokevirtual 627	java/net/HttpURLConnection:disconnect	()V
    //   976: iload 7
    //   978: istore 6
    //   980: aload 12
    //   982: astore 13
    //   984: iload 6
    //   986: iconst_1
    //   987: iadd
    //   988: istore 6
    //   990: iload 6
    //   992: iload_3
    //   993: if_icmpge +1331 -> 2324
    //   996: aload 19
    //   998: monitorenter
    //   999: aload 19
    //   1001: lload 9
    //   1003: invokevirtual 422	java/lang/Object:wait	(J)V
    //   1006: lload 9
    //   1008: ldc2_w 550
    //   1011: lmul
    //   1012: lstore 9
    //   1014: aload 19
    //   1016: monitorexit
    //   1017: aload 13
    //   1019: astore 12
    //   1021: goto +1363 -> 2384
    //   1024: aload 12
    //   1026: astore 15
    //   1028: aload 12
    //   1030: astore 14
    //   1032: aload 12
    //   1034: astore 13
    //   1036: iconst_1
    //   1037: putstatic 567	com/tencent/mobileqq/utils/HttpDownloadUtil:jdField_a_of_type_Boolean	Z
    //   1040: goto -555 -> 485
    //   1043: astore 13
    //   1045: aload 14
    //   1047: astore 12
    //   1049: aload 13
    //   1051: astore 14
    //   1053: aload 12
    //   1055: astore 13
    //   1057: invokestatic 151	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1060: ifeq +12 -> 1072
    //   1063: aload 12
    //   1065: astore 13
    //   1067: aload 14
    //   1069: invokevirtual 460	java/lang/Exception:printStackTrace	()V
    //   1072: aload 12
    //   1074: astore 13
    //   1076: aload 18
    //   1078: iconst_5
    //   1079: putfield 459	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   1082: aload 12
    //   1084: astore 13
    //   1086: invokestatic 151	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1089: ifeq +79 -> 1168
    //   1092: aload 12
    //   1094: astore 13
    //   1096: ldc 153
    //   1098: iconst_2
    //   1099: new 208	java/lang/StringBuilder
    //   1102: dup
    //   1103: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   1106: ldc_w 617
    //   1109: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1112: aload 18
    //   1114: getfield 459	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   1117: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1120: ldc_w 629
    //   1123: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1126: aload 18
    //   1128: getfield 621	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_c_of_type_Int	I
    //   1131: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1134: ldc_w 441
    //   1137: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1140: aload 18
    //   1142: getfield 182	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1145: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1148: ldc_w 443
    //   1151: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1154: aload 14
    //   1156: invokevirtual 630	java/lang/Exception:toString	()Ljava/lang/String;
    //   1159: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1162: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1165: invokestatic 449	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1168: aload 12
    //   1170: astore 13
    //   1172: iload 7
    //   1174: istore 6
    //   1176: aload 12
    //   1178: ifnull -194 -> 984
    //   1181: aload 12
    //   1183: invokevirtual 627	java/net/HttpURLConnection:disconnect	()V
    //   1186: aload 12
    //   1188: astore 13
    //   1190: iload 7
    //   1192: istore 6
    //   1194: goto -210 -> 984
    //   1197: aload 12
    //   1199: astore 15
    //   1201: aload 12
    //   1203: astore 14
    //   1205: aload 12
    //   1207: astore 13
    //   1209: aload 17
    //   1211: getstatic 631	com/tencent/mobileqq/utils/httputils/PkgTools:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1214: invokevirtual 563	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1217: ifeq +29 -> 1246
    //   1220: aload 12
    //   1222: astore 15
    //   1224: aload 12
    //   1226: astore 14
    //   1228: aload 12
    //   1230: astore 13
    //   1232: aload 16
    //   1234: aload 20
    //   1236: iload 8
    //   1238: invokestatic 633	com/tencent/mobileqq/utils/httputils/PkgTools:a	(Ljava/lang/String;Ljava/lang/String;I)Ljava/net/HttpURLConnection;
    //   1241: astore 12
    //   1243: goto -570 -> 673
    //   1246: aload 12
    //   1248: astore 15
    //   1250: aload 12
    //   1252: astore 14
    //   1254: aload 12
    //   1256: astore 13
    //   1258: aload 16
    //   1260: aload 20
    //   1262: iload 8
    //   1264: invokestatic 633	com/tencent/mobileqq/utils/httputils/PkgTools:a	(Ljava/lang/String;Ljava/lang/String;I)Ljava/net/HttpURLConnection;
    //   1267: astore 12
    //   1269: goto -596 -> 673
    //   1272: aload 12
    //   1274: astore 15
    //   1276: aload 12
    //   1278: astore 14
    //   1280: aload 12
    //   1282: astore 13
    //   1284: new 178	java/net/URL
    //   1287: dup
    //   1288: aload 16
    //   1290: invokespecial 183	java/net/URL:<init>	(Ljava/lang/String;)V
    //   1293: getstatic 639	java/net/Proxy:NO_PROXY	Ljava/net/Proxy;
    //   1296: invokevirtual 643	java/net/URL:openConnection	(Ljava/net/Proxy;)Ljava/net/URLConnection;
    //   1299: checkcast 611	java/net/HttpURLConnection
    //   1302: astore 12
    //   1304: goto -631 -> 673
    //   1307: aload 12
    //   1309: astore 15
    //   1311: aload 12
    //   1313: astore 14
    //   1315: aload 12
    //   1317: astore 13
    //   1319: aload 12
    //   1321: ldc_w 645
    //   1324: ldc_w 647
    //   1327: invokevirtual 650	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1330: aload 12
    //   1332: astore 15
    //   1334: aload 12
    //   1336: astore 14
    //   1338: aload 12
    //   1340: astore 13
    //   1342: invokestatic 655	com/tencent/mobileqq/transfile/NetworkCenter:a	()Lcom/tencent/mobileqq/transfile/NetworkCenter;
    //   1345: invokevirtual 657	com/tencent/mobileqq/transfile/NetworkCenter:a	()I
    //   1348: istore 6
    //   1350: aload 12
    //   1352: astore 15
    //   1354: aload 12
    //   1356: astore 14
    //   1358: aload 12
    //   1360: astore 13
    //   1362: aload 12
    //   1364: iload 6
    //   1366: invokestatic 662	com/tencent/mobileqq/utils/HttpDownloadUtil$TimeoutParam:b	(I)I
    //   1369: invokevirtual 666	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   1372: aload 12
    //   1374: astore 15
    //   1376: aload 12
    //   1378: astore 14
    //   1380: aload 12
    //   1382: astore 13
    //   1384: aload 12
    //   1386: iload 6
    //   1388: invokestatic 668	com/tencent/mobileqq/utils/HttpDownloadUtil$TimeoutParam:a	(I)I
    //   1391: invokevirtual 671	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   1394: aload 12
    //   1396: astore 15
    //   1398: aload 12
    //   1400: astore 14
    //   1402: aload 12
    //   1404: astore 13
    //   1406: aload 12
    //   1408: iconst_0
    //   1409: invokevirtual 675	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   1412: aload 12
    //   1414: astore 15
    //   1416: aload 12
    //   1418: astore 14
    //   1420: aload 12
    //   1422: astore 13
    //   1424: aload 12
    //   1426: invokevirtual 678	java/net/HttpURLConnection:connect	()V
    //   1429: aload 12
    //   1431: astore 15
    //   1433: aload 12
    //   1435: astore 14
    //   1437: aload 12
    //   1439: astore 13
    //   1441: aload 18
    //   1443: aload 12
    //   1445: invokevirtual 681	java/net/HttpURLConnection:getResponseCode	()I
    //   1448: putfield 621	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_c_of_type_Int	I
    //   1451: aload 12
    //   1453: astore 15
    //   1455: aload 12
    //   1457: astore 14
    //   1459: aload 12
    //   1461: astore 13
    //   1463: aload 18
    //   1465: aload 12
    //   1467: invokevirtual 683	java/net/HttpURLConnection:getContentLength	()I
    //   1470: putfield 685	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_e_of_type_Int	I
    //   1473: aload 12
    //   1475: astore 15
    //   1477: aload 12
    //   1479: astore 14
    //   1481: aload 12
    //   1483: astore 13
    //   1485: aload 18
    //   1487: aload 12
    //   1489: invokevirtual 688	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
    //   1492: putfield 689	com/tencent/mobileqq/emoticon/DownloadInfo:h	Ljava/lang/String;
    //   1495: aload 12
    //   1497: astore 15
    //   1499: aload 12
    //   1501: astore 14
    //   1503: aload 12
    //   1505: astore 13
    //   1507: aload 18
    //   1509: aload 12
    //   1511: invokevirtual 692	java/net/HttpURLConnection:getContentEncoding	()Ljava/lang/String;
    //   1514: putfield 694	com/tencent/mobileqq/emoticon/DownloadInfo:i	Ljava/lang/String;
    //   1517: aload 12
    //   1519: astore 15
    //   1521: aload 12
    //   1523: astore 14
    //   1525: aload 12
    //   1527: astore 13
    //   1529: aload 12
    //   1531: aload 18
    //   1533: invokestatic 697	com/tencent/mobileqq/utils/HttpDownloadUtil:a	(Ljava/net/HttpURLConnection;Lcom/tencent/mobileqq/emoticon/DownloadInfo;)V
    //   1536: aload 12
    //   1538: astore 15
    //   1540: aload 12
    //   1542: astore 14
    //   1544: aload 12
    //   1546: astore 13
    //   1548: invokestatic 151	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1551: ifeq +83 -> 1634
    //   1554: aload 12
    //   1556: astore 15
    //   1558: aload 12
    //   1560: astore 14
    //   1562: aload 12
    //   1564: astore 13
    //   1566: ldc 153
    //   1568: iconst_2
    //   1569: new 208	java/lang/StringBuilder
    //   1572: dup
    //   1573: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   1576: ldc_w 699
    //   1579: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1582: aload_0
    //   1583: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1586: ldc_w 701
    //   1589: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1592: aload 18
    //   1594: getfield 621	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_c_of_type_Int	I
    //   1597: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1600: ldc_w 703
    //   1603: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1606: aload 18
    //   1608: getfield 685	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_e_of_type_Int	I
    //   1611: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1614: ldc_w 705
    //   1617: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1620: aload 18
    //   1622: getfield 689	com/tencent/mobileqq/emoticon/DownloadInfo:h	Ljava/lang/String;
    //   1625: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1628: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1631: invokestatic 398	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1634: iload 4
    //   1636: ifeq +59 -> 1695
    //   1639: aload 12
    //   1641: astore 15
    //   1643: aload 12
    //   1645: astore 14
    //   1647: aload 12
    //   1649: astore 13
    //   1651: aload 18
    //   1653: iconst_0
    //   1654: putfield 459	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   1657: aload_1
    //   1658: ifnull +24 -> 1682
    //   1661: aload 12
    //   1663: astore 15
    //   1665: aload 12
    //   1667: astore 14
    //   1669: aload 12
    //   1671: astore 13
    //   1673: aload_1
    //   1674: aload 18
    //   1676: invokeinterface 547 2 0
    //   1681: pop
    //   1682: aload 12
    //   1684: ifnull +8 -> 1692
    //   1687: aload 12
    //   1689: invokevirtual 627	java/net/HttpURLConnection:disconnect	()V
    //   1692: aload 18
    //   1694: areturn
    //   1695: aload 12
    //   1697: astore 15
    //   1699: aload 12
    //   1701: astore 14
    //   1703: aload 12
    //   1705: astore 13
    //   1707: aload 18
    //   1709: getfield 621	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_c_of_type_Int	I
    //   1712: sipush 200
    //   1715: if_icmpne +157 -> 1872
    //   1718: aload_1
    //   1719: ifnull +122 -> 1841
    //   1722: aload 12
    //   1724: astore 15
    //   1726: aload 12
    //   1728: astore 14
    //   1730: aload 12
    //   1732: astore 13
    //   1734: aload 18
    //   1736: iconst_0
    //   1737: putfield 459	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   1740: aload 12
    //   1742: astore 15
    //   1744: aload 12
    //   1746: astore 14
    //   1748: aload 12
    //   1750: astore 13
    //   1752: aload_1
    //   1753: aload 18
    //   1755: invokeinterface 547 2 0
    //   1760: ifeq +34 -> 1794
    //   1763: aload 12
    //   1765: astore 15
    //   1767: aload 12
    //   1769: astore 14
    //   1771: aload 12
    //   1773: astore 13
    //   1775: aload 18
    //   1777: iconst_0
    //   1778: putfield 459	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   1781: aload 12
    //   1783: ifnull +8 -> 1791
    //   1786: aload 12
    //   1788: invokevirtual 627	java/net/HttpURLConnection:disconnect	()V
    //   1791: aload 18
    //   1793: areturn
    //   1794: aload 12
    //   1796: astore 15
    //   1798: aload 12
    //   1800: astore 14
    //   1802: aload 12
    //   1804: astore 13
    //   1806: aload 18
    //   1808: iconst_4
    //   1809: putfield 459	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   1812: aload 12
    //   1814: astore 13
    //   1816: iload 7
    //   1818: istore 6
    //   1820: aload 12
    //   1822: ifnull -838 -> 984
    //   1825: aload 12
    //   1827: invokevirtual 627	java/net/HttpURLConnection:disconnect	()V
    //   1830: aload 12
    //   1832: astore 13
    //   1834: iload 7
    //   1836: istore 6
    //   1838: goto -854 -> 984
    //   1841: aload 12
    //   1843: astore 15
    //   1845: aload 12
    //   1847: astore 14
    //   1849: aload 12
    //   1851: astore 13
    //   1853: aload 18
    //   1855: iconst_0
    //   1856: putfield 459	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   1859: aload 12
    //   1861: ifnull +8 -> 1869
    //   1864: aload 12
    //   1866: invokevirtual 627	java/net/HttpURLConnection:disconnect	()V
    //   1869: aload 18
    //   1871: areturn
    //   1872: aload 12
    //   1874: astore 15
    //   1876: aload 12
    //   1878: astore 14
    //   1880: aload 12
    //   1882: astore 13
    //   1884: aload 18
    //   1886: getfield 621	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_c_of_type_Int	I
    //   1889: sipush 302
    //   1892: if_icmpeq +26 -> 1918
    //   1895: aload 12
    //   1897: astore 15
    //   1899: aload 12
    //   1901: astore 14
    //   1903: aload 12
    //   1905: astore 13
    //   1907: aload 18
    //   1909: getfield 621	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_c_of_type_Int	I
    //   1912: sipush 301
    //   1915: if_icmpne +280 -> 2195
    //   1918: aload 12
    //   1920: astore 15
    //   1922: aload 12
    //   1924: astore 14
    //   1926: aload 12
    //   1928: astore 13
    //   1930: aload 12
    //   1932: ldc_w 707
    //   1935: invokevirtual 710	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   1938: astore 17
    //   1940: aload 12
    //   1942: astore 15
    //   1944: aload 12
    //   1946: astore 14
    //   1948: aload 12
    //   1950: astore 13
    //   1952: invokestatic 151	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1955: ifeq +42 -> 1997
    //   1958: aload 12
    //   1960: astore 15
    //   1962: aload 12
    //   1964: astore 14
    //   1966: aload 12
    //   1968: astore 13
    //   1970: ldc 153
    //   1972: iconst_2
    //   1973: new 208	java/lang/StringBuilder
    //   1976: dup
    //   1977: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   1980: ldc_w 712
    //   1983: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1986: aload 17
    //   1988: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1991: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1994: invokestatic 449	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1997: aload 12
    //   1999: astore 15
    //   2001: aload 12
    //   2003: astore 14
    //   2005: aload 12
    //   2007: astore 13
    //   2009: aload 17
    //   2011: invokestatic 717	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2014: ifeq +35 -> 2049
    //   2017: aload 12
    //   2019: astore 15
    //   2021: aload 12
    //   2023: astore 14
    //   2025: aload 12
    //   2027: astore 13
    //   2029: aload 18
    //   2031: bipush 20
    //   2033: putfield 459	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   2036: aload 12
    //   2038: ifnull +8 -> 2046
    //   2041: aload 12
    //   2043: invokevirtual 627	java/net/HttpURLConnection:disconnect	()V
    //   2046: aload 18
    //   2048: areturn
    //   2049: aload 12
    //   2051: astore 15
    //   2053: aload 12
    //   2055: astore 14
    //   2057: aload 12
    //   2059: astore 13
    //   2061: aload 12
    //   2063: invokevirtual 627	java/net/HttpURLConnection:disconnect	()V
    //   2066: aload_2
    //   2067: ifnull +88 -> 2155
    //   2070: aload_2
    //   2071: invokeinterface 720 1 0
    //   2076: istore 8
    //   2078: iconst_0
    //   2079: istore 6
    //   2081: iload 6
    //   2083: iload 8
    //   2085: if_icmpge +41 -> 2126
    //   2088: aload_2
    //   2089: iload 6
    //   2091: invokeinterface 724 2 0
    //   2096: checkcast 603	org/apache/http/Header
    //   2099: astore 12
    //   2101: aload 12
    //   2103: invokeinterface 606 1 0
    //   2108: ldc_w 726
    //   2111: invokevirtual 563	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2114: ifeq +72 -> 2186
    //   2117: aload_2
    //   2118: aload 12
    //   2120: invokeinterface 729 2 0
    //   2125: pop
    //   2126: aload_2
    //   2127: new 731	org/apache/http/message/BasicHeader
    //   2130: dup
    //   2131: ldc_w 726
    //   2134: new 178	java/net/URL
    //   2137: dup
    //   2138: aload 17
    //   2140: invokespecial 183	java/net/URL:<init>	(Ljava/lang/String;)V
    //   2143: invokevirtual 296	java/net/URL:getHost	()Ljava/lang/String;
    //   2146: invokespecial 733	org/apache/http/message/BasicHeader:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   2149: invokeinterface 736 2 0
    //   2154: pop
    //   2155: aload 17
    //   2157: aload_1
    //   2158: aload_2
    //   2159: iload_3
    //   2160: iload 4
    //   2162: iload 5
    //   2164: iconst_1
    //   2165: iadd
    //   2166: invokestatic 535	com/tencent/mobileqq/utils/HttpDownloadUtil:a	(Ljava/lang/String;Lcom/tencent/mobileqq/utils/HttpDownloadUtil$DownloadInfoListener;Ljava/util/List;IZI)Lcom/tencent/mobileqq/emoticon/DownloadInfo;
    //   2169: astore 12
    //   2171: aload 12
    //   2173: astore_0
    //   2174: iconst_0
    //   2175: ifeq -2132 -> 43
    //   2178: new 738	java/lang/NullPointerException
    //   2181: dup
    //   2182: invokespecial 739	java/lang/NullPointerException:<init>	()V
    //   2185: athrow
    //   2186: iload 6
    //   2188: iconst_1
    //   2189: iadd
    //   2190: istore 6
    //   2192: goto -111 -> 2081
    //   2195: aload 12
    //   2197: astore 15
    //   2199: aload 12
    //   2201: astore 14
    //   2203: aload 12
    //   2205: astore 13
    //   2207: aload 18
    //   2209: aload 18
    //   2211: getfield 621	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_c_of_type_Int	I
    //   2214: putfield 459	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   2217: goto -405 -> 1812
    //   2220: astore_0
    //   2221: aload 13
    //   2223: ifnull +8 -> 2231
    //   2226: aload 13
    //   2228: invokevirtual 627	java/net/HttpURLConnection:disconnect	()V
    //   2231: aload_0
    //   2232: athrow
    //   2233: aload 12
    //   2235: astore 13
    //   2237: aload 14
    //   2239: instanceof 430
    //   2242: ifne +151 -> 2393
    //   2245: aload 12
    //   2247: astore 13
    //   2249: aload 14
    //   2251: instanceof 432
    //   2254: ifeq +6 -> 2260
    //   2257: goto +136 -> 2393
    //   2260: aload 12
    //   2262: astore 13
    //   2264: aload 14
    //   2266: instanceof 457
    //   2269: ifeq +17 -> 2286
    //   2272: aload 12
    //   2274: astore 13
    //   2276: aload 18
    //   2278: bipush 11
    //   2280: putfield 459	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   2283: goto -1419 -> 864
    //   2286: aload 12
    //   2288: astore 13
    //   2290: aload 14
    //   2292: instanceof 164
    //   2295: istore 11
    //   2297: iload 11
    //   2299: ifeq +13 -> 2312
    //   2302: bipush 13
    //   2304: istore 6
    //   2306: iload_3
    //   2307: istore 7
    //   2309: goto -1445 -> 864
    //   2312: iconst_4
    //   2313: istore 6
    //   2315: goto -1451 -> 864
    //   2318: astore_0
    //   2319: aload 19
    //   2321: monitorexit
    //   2322: aload_0
    //   2323: athrow
    //   2324: aload_1
    //   2325: ifnull +12 -> 2337
    //   2328: aload_1
    //   2329: aload 18
    //   2331: invokeinterface 547 2 0
    //   2336: pop
    //   2337: aload 13
    //   2339: astore 12
    //   2341: goto +43 -> 2384
    //   2344: astore 13
    //   2346: goto -2060 -> 286
    //   2349: astore 12
    //   2351: goto -1337 -> 1014
    //   2354: astore_0
    //   2355: aconst_null
    //   2356: astore 13
    //   2358: goto -137 -> 2221
    //   2361: astore 14
    //   2363: aconst_null
    //   2364: astore 12
    //   2366: goto -1313 -> 1053
    //   2369: astore 14
    //   2371: aconst_null
    //   2372: astore 12
    //   2374: goto -1551 -> 823
    //   2377: iload 6
    //   2379: istore 7
    //   2381: goto -2286 -> 95
    //   2384: iload 6
    //   2386: iload_3
    //   2387: if_icmplt -10 -> 2377
    //   2390: aload 18
    //   2392: areturn
    //   2393: iconst_2
    //   2394: istore 6
    //   2396: goto -1532 -> 864
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2399	0	paramString	String
    //   0	2399	1	paramDownloadInfoListener	HttpDownloadUtil.DownloadInfoListener
    //   0	2399	2	paramList	List
    //   0	2399	3	paramInt1	int
    //   0	2399	4	paramBoolean	boolean
    //   0	2399	5	paramInt2	int
    //   130	2265	6	i	int
    //   88	2292	7	j	int
    //   379	1707	8	k	int
    //   93	920	9	l	long
    //   2295	3	11	bool	boolean
    //   85	1	12	localObject1	Object
    //   203	456	12	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   671	1669	12	localObject2	Object
    //   2349	1	12	localInterruptedException1	java.lang.InterruptedException
    //   2364	9	12	localObject3	Object
    //   319	716	13	localObject4	Object
    //   1043	7	13	localException1	Exception
    //   1055	1283	13	localObject5	Object
    //   2344	1	13	localInterruptedException2	java.lang.InterruptedException
    //   2356	1	13	localObject6	Object
    //   315	475	14	localObject7	Object
    //   817	128	14	localIOException1	java.io.IOException
    //   1030	1261	14	localObject8	Object
    //   2361	1	14	localException2	Exception
    //   2369	1	14	localIOException2	java.io.IOException
    //   311	1887	15	localObject9	Object
    //   63	1226	16	str	String
    //   299	1857	17	localObject10	Object
    //   10	2381	18	localDownloadInfo	DownloadInfo
    //   82	2238	19	localObject11	Object
    //   98	1163	20	localObject12	Object
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
    //   1342	1350	817	java/io/IOException
    //   1362	1372	817	java/io/IOException
    //   1384	1394	817	java/io/IOException
    //   1406	1412	817	java/io/IOException
    //   1424	1429	817	java/io/IOException
    //   1441	1451	817	java/io/IOException
    //   1463	1473	817	java/io/IOException
    //   1485	1495	817	java/io/IOException
    //   1507	1517	817	java/io/IOException
    //   1529	1536	817	java/io/IOException
    //   1548	1554	817	java/io/IOException
    //   1566	1634	817	java/io/IOException
    //   1651	1657	817	java/io/IOException
    //   1673	1682	817	java/io/IOException
    //   1707	1718	817	java/io/IOException
    //   1734	1740	817	java/io/IOException
    //   1752	1763	817	java/io/IOException
    //   1775	1781	817	java/io/IOException
    //   1806	1812	817	java/io/IOException
    //   1853	1859	817	java/io/IOException
    //   1884	1895	817	java/io/IOException
    //   1907	1918	817	java/io/IOException
    //   1930	1940	817	java/io/IOException
    //   1952	1958	817	java/io/IOException
    //   1970	1997	817	java/io/IOException
    //   2009	2017	817	java/io/IOException
    //   2029	2036	817	java/io/IOException
    //   2061	2066	817	java/io/IOException
    //   2207	2217	817	java/io/IOException
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
    //   1342	1350	1043	java/lang/Exception
    //   1362	1372	1043	java/lang/Exception
    //   1384	1394	1043	java/lang/Exception
    //   1406	1412	1043	java/lang/Exception
    //   1424	1429	1043	java/lang/Exception
    //   1441	1451	1043	java/lang/Exception
    //   1463	1473	1043	java/lang/Exception
    //   1485	1495	1043	java/lang/Exception
    //   1507	1517	1043	java/lang/Exception
    //   1529	1536	1043	java/lang/Exception
    //   1548	1554	1043	java/lang/Exception
    //   1566	1634	1043	java/lang/Exception
    //   1651	1657	1043	java/lang/Exception
    //   1673	1682	1043	java/lang/Exception
    //   1707	1718	1043	java/lang/Exception
    //   1734	1740	1043	java/lang/Exception
    //   1752	1763	1043	java/lang/Exception
    //   1775	1781	1043	java/lang/Exception
    //   1806	1812	1043	java/lang/Exception
    //   1853	1859	1043	java/lang/Exception
    //   1884	1895	1043	java/lang/Exception
    //   1907	1918	1043	java/lang/Exception
    //   1930	1940	1043	java/lang/Exception
    //   1952	1958	1043	java/lang/Exception
    //   1970	1997	1043	java/lang/Exception
    //   2009	2017	1043	java/lang/Exception
    //   2029	2036	1043	java/lang/Exception
    //   2061	2066	1043	java/lang/Exception
    //   2207	2217	1043	java/lang/Exception
    //   321	328	2220	finally
    //   340	347	2220	finally
    //   359	364	2220	finally
    //   376	381	2220	finally
    //   393	400	2220	finally
    //   412	423	2220	finally
    //   435	440	2220	finally
    //   458	469	2220	finally
    //   481	485	2220	finally
    //   503	514	2220	finally
    //   526	537	2220	finally
    //   549	553	2220	finally
    //   565	571	2220	finally
    //   593	604	2220	finally
    //   616	627	2220	finally
    //   639	650	2220	finally
    //   662	673	2220	finally
    //   685	692	2220	finally
    //   708	717	2220	finally
    //   729	737	2220	finally
    //   749	759	2220	finally
    //   771	783	2220	finally
    //   795	814	2220	finally
    //   827	833	2220	finally
    //   837	842	2220	finally
    //   849	857	2220	finally
    //   868	875	2220	finally
    //   879	885	2220	finally
    //   889	958	2220	finally
    //   1036	1040	2220	finally
    //   1057	1063	2220	finally
    //   1067	1072	2220	finally
    //   1076	1082	2220	finally
    //   1086	1092	2220	finally
    //   1096	1168	2220	finally
    //   1209	1220	2220	finally
    //   1232	1243	2220	finally
    //   1258	1269	2220	finally
    //   1284	1304	2220	finally
    //   1319	1330	2220	finally
    //   1342	1350	2220	finally
    //   1362	1372	2220	finally
    //   1384	1394	2220	finally
    //   1406	1412	2220	finally
    //   1424	1429	2220	finally
    //   1441	1451	2220	finally
    //   1463	1473	2220	finally
    //   1485	1495	2220	finally
    //   1507	1517	2220	finally
    //   1529	1536	2220	finally
    //   1548	1554	2220	finally
    //   1566	1634	2220	finally
    //   1651	1657	2220	finally
    //   1673	1682	2220	finally
    //   1707	1718	2220	finally
    //   1734	1740	2220	finally
    //   1752	1763	2220	finally
    //   1775	1781	2220	finally
    //   1806	1812	2220	finally
    //   1853	1859	2220	finally
    //   1884	1895	2220	finally
    //   1907	1918	2220	finally
    //   1930	1940	2220	finally
    //   1952	1958	2220	finally
    //   1970	1997	2220	finally
    //   2009	2017	2220	finally
    //   2029	2036	2220	finally
    //   2061	2066	2220	finally
    //   2207	2217	2220	finally
    //   2237	2245	2220	finally
    //   2249	2257	2220	finally
    //   2264	2272	2220	finally
    //   2276	2283	2220	finally
    //   2290	2297	2220	finally
    //   999	1006	2318	finally
    //   1014	1017	2318	finally
    //   2319	2322	2318	finally
    //   271	278	2344	java/lang/InterruptedException
    //   999	1006	2349	java/lang/InterruptedException
    //   2070	2078	2354	finally
    //   2088	2126	2354	finally
    //   2126	2155	2354	finally
    //   2155	2171	2354	finally
    //   2070	2078	2361	java/lang/Exception
    //   2088	2126	2361	java/lang/Exception
    //   2126	2155	2361	java/lang/Exception
    //   2155	2171	2361	java/lang/Exception
    //   2070	2078	2369	java/io/IOException
    //   2088	2126	2369	java/io/IOException
    //   2126	2155	2369	java/io/IOException
    //   2155	2171	2369	java/io/IOException
  }
  
  public static String a(String paramString)
  {
    return paramString.replaceAll("\\{", "%7B").replaceAll("\\}", "%7D").replaceAll("\\|", "%7C");
  }
  
  public static void a(DownloadInfo paramDownloadInfo)
  {
    if ((paramDownloadInfo == null) || (paramDownloadInfo.jdField_a_of_type_JavaLangString == null) || (paramDownloadInfo.jdField_a_of_type_JavaLangString.length() == 0)) {}
    label33:
    int i;
    int j;
    String str2;
    do
    {
      return;
      if (!paramDownloadInfo.jdField_b_of_type_Boolean) {
        break;
      }
      localObject = jdField_a_of_type_JavaLangString;
      i = ((String)localObject).length();
      j = paramDownloadInfo.jdField_a_of_type_JavaLangString.indexOf("/", i);
      str2 = paramDownloadInfo.jdField_a_of_type_JavaLangString.substring(i, j);
    } while ((j <= i) && (TextUtils.isEmpty(str2)));
    label88:
    String str1;
    if ("imgcache.qq.com".equalsIgnoreCase(str2))
    {
      i = 12;
      str1 = (String)localObject + "[^/\\s]*/";
      String str3 = FMTSrvAddrProvider.a().b(i);
      if ((str3 == null) || (str3.length() <= 0)) {
        break label413;
      }
      str1 = paramDownloadInfo.jdField_a_of_type_JavaLangString.replaceFirst(str1, str3);
      if ((!paramDownloadInfo.jdField_b_of_type_Boolean) || (TextUtils.isEmpty(str1)) || (!str1.startsWith("http://"))) {
        break label474;
      }
    }
    label413:
    label474:
    for (Object localObject = (String)localObject + str1.substring("http://".length());; localObject = str1)
    {
      paramDownloadInfo.jdField_c_of_type_JavaLangString = str2;
      paramDownloadInfo.jdField_b_of_type_JavaLangString = ((String)localObject);
      paramDownloadInfo.jdField_a_of_type_Boolean = true;
      paramDownloadInfo.d = i;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.emoji.EmoDown", 2, "replaceDomainWithIp " + paramDownloadInfo.jdField_a_of_type_Boolean + " url[" + paramDownloadInfo.jdField_a_of_type_JavaLangString + "] resetIP[" + (String)localObject + "] host[" + paramDownloadInfo.jdField_c_of_type_JavaLangString + "]");
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
      paramDownloadInfo.jdField_c_of_type_JavaLangString = null;
      paramDownloadInfo.jdField_b_of_type_JavaLangString = paramDownloadInfo.jdField_a_of_type_JavaLangString;
      paramDownloadInfo.jdField_a_of_type_Boolean = false;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.emoji.EmoDown", 2, "unknow domain url=" + paramDownloadInfo.jdField_a_of_type_Boolean);
      return;
      paramDownloadInfo.jdField_c_of_type_JavaLangString = null;
      paramDownloadInfo.jdField_b_of_type_JavaLangString = paramDownloadInfo.jdField_a_of_type_JavaLangString;
      paramDownloadInfo.jdField_a_of_type_Boolean = false;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.emoji.EmoDown", 2, "replaceDomainWithIp false.url[" + paramDownloadInfo.jdField_b_of_type_JavaLangString + "]");
      return;
    }
  }
  
  static void a(HttpURLConnection paramHttpURLConnection, DownloadInfo paramDownloadInfo)
  {
    if ((paramHttpURLConnection == null) || (paramDownloadInfo == null)) {}
    do
    {
      return;
      if (paramHttpURLConnection.getHeaderField("X-FailNo") != null) {
        paramDownloadInfo.j = paramHttpURLConnection.getHeaderField("X-FailNo");
      }
    } while (paramHttpURLConnection.getHeaderField("X-ErrNo") == null);
    paramDownloadInfo.k = paramHttpURLConnection.getHeaderField("X-ErrNo");
  }
  
  public static boolean a(AppInterface paramAppInterface, String paramString, File paramFile)
  {
    return a(paramAppInterface, paramString, paramFile) == 0;
  }
  
  public static boolean a(AppInterface paramAppInterface, URL paramURL, File paramFile)
  {
    return a(paramAppInterface, paramURL, paramFile, AppNetConnInfo.getRecentNetworkInfo(), 2) == 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.utils.HttpDownloadUtil
 * JD-Core Version:    0.7.0.1
 */