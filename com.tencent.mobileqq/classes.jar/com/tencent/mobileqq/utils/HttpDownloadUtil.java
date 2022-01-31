package com.tencent.mobileqq.utils;

import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.text.TextUtils;
import apnb;
import baoc;
import bapk;
import baqx;
import batt;
import bdcx;
import bdcy;
import bdcz;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
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
        if ((Build.VERSION.SDK_INT < 23) && (!bapk.c())) {
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
      ((SchemeRegistry)localObject).register(new Scheme("https", new batt(HttpDownloadUtil.class.getSimpleName()), 443));
    }
  }
  
  /* Error */
  private static int a(AppInterface paramAppInterface, apnb paramapnb, NetworkInfo paramNetworkInfo, bdcy parambdcy)
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
    //   29: getfield 182	apnb:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   32: invokespecial 183	java/net/URL:<init>	(Ljava/lang/String;)V
    //   35: astore 27
    //   37: invokestatic 21	java/lang/System:currentTimeMillis	()J
    //   40: lstore 12
    //   42: new 4	java/lang/Object
    //   45: dup
    //   46: invokespecial 161	java/lang/Object:<init>	()V
    //   49: astore 28
    //   51: aload_1
    //   52: getfield 186	apnb:jdField_a_of_type_JavaIoFile	Ljava/io/File;
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
    //   119: getfield 182	apnb:jdField_b_of_type_JavaLangString	Ljava/lang/String;
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
    //   143: putfield 227	apnb:jdField_e_of_type_JavaLangString	Ljava/lang/String;
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
    //   187: getfield 182	apnb:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   190: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   196: invokestatic 176	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   199: iconst_4
    //   200: ireturn
    //   201: aconst_null
    //   202: astore 19
    //   204: aload_1
    //   205: getfield 182	apnb:jdField_b_of_type_JavaLangString	Ljava/lang/String;
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
    //   284: invokestatic 265	bdee:a	(Landroid/net/NetworkInfo;)Z
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
    //   339: invokestatic 265	bdee:a	(Landroid/net/NetworkInfo;)Z
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
    //   375: invokevirtual 289	apnb:a	()Ljava/lang/String;
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
    //   985: getfield 182	apnb:jdField_b_of_type_JavaLangString	Ljava/lang/String;
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
    //   1053: getfield 182	apnb:jdField_b_of_type_JavaLangString	Ljava/lang/String;
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
    //   1078: getfield 370	apnb:jdField_a_of_type_Int	I
    //   1081: tableswitch	default:+1633 -> 2714, 10001:+666->1747
    //   1101: iconst_2
    //   1102: istore 6
    //   1104: iload 5
    //   1106: istore 7
    //   1108: aload_2
    //   1109: invokestatic 265	bdee:a	(Landroid/net/NetworkInfo;)Z
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
    //   1257: getfield 182	apnb:jdField_b_of_type_JavaLangString	Ljava/lang/String;
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
    //   1345: getfield 186	apnb:jdField_a_of_type_JavaIoFile	Ljava/io/File;
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
    //   1390: getfield 186	apnb:jdField_a_of_type_JavaIoFile	Ljava/io/File;
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
    //   1520: getfield 182	apnb:jdField_b_of_type_JavaLangString	Ljava/lang/String;
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
    //   1652: getfield 182	apnb:jdField_b_of_type_JavaLangString	Ljava/lang/String;
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
    //   1756: invokestatic 265	bdee:a	(Landroid/net/NetworkInfo;)Z
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
    //   1946: getfield 182	apnb:jdField_b_of_type_JavaLangString	Ljava/lang/String;
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
    //   2305: putfield 459	apnb:jdField_b_of_type_Int	I
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
    //   0	2723	1	paramapnb	apnb
    //   0	2723	2	paramNetworkInfo	NetworkInfo
    //   0	2723	3	parambdcy	bdcy
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
  
  public static int a(AppInterface paramAppInterface, apnb paramapnb, bdcy parambdcy)
  {
    NetworkInfo localNetworkInfo = AppNetConnInfo.getRecentNetworkInfo();
    if (localNetworkInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("HttpDownloadUtil", 2, "Download failed-----------activeNetworkInfo is null");
      }
      return 9;
    }
    return a(paramAppInterface, paramapnb, localNetworkInfo, parambdcy);
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
    //   105: invokestatic 265	bdee:a	(Landroid/net/NetworkInfo;)Z
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
    //   160: invokestatic 265	bdee:a	(Landroid/net/NetworkInfo;)Z
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
  
  public static apnb a(String paramString, bdcx parambdcx)
  {
    return a(paramString, parambdcx, null, 2, true);
  }
  
  public static apnb a(String paramString, bdcx parambdcx, List<Header> paramList, int paramInt, boolean paramBoolean)
  {
    int i = baqx.a().a();
    return a(paramString, parambdcx, paramList, paramInt, paramBoolean, 0, bdcz.b(i), bdcz.a(i));
  }
  
  public static apnb a(String paramString, bdcx parambdcx, List<Header> paramList, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3)
  {
    return a(paramString, parambdcx, paramList, paramInt1, paramBoolean, 0, paramInt2, paramInt3);
  }
  
  /* Error */
  private static apnb a(String paramString, bdcx parambdcx, List<Header> paramList, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, int paramInt4)
  {
    // Byte code:
    //   0: new 180	apnb
    //   3: dup
    //   4: aload_0
    //   5: aconst_null
    //   6: iconst_0
    //   7: invokespecial 556	apnb:<init>	(Ljava/lang/String;Ljava/io/File;I)V
    //   10: astore 20
    //   12: iload 5
    //   14: iconst_3
    //   15: if_icmplt +30 -> 45
    //   18: invokestatic 151	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   21: ifeq +12 -> 33
    //   24: ldc 153
    //   26: iconst_2
    //   27: ldc_w 558
    //   30: invokestatic 449	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   33: aload 20
    //   35: bipush 20
    //   37: putfield 459	apnb:jdField_b_of_type_Int	I
    //   40: aload 20
    //   42: astore_0
    //   43: aload_0
    //   44: areturn
    //   45: new 178	java/net/URL
    //   48: dup
    //   49: aload 20
    //   51: getfield 182	apnb:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   54: invokespecial 183	java/net/URL:<init>	(Ljava/lang/String;)V
    //   57: pop
    //   58: aload 20
    //   60: getfield 182	apnb:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   63: astore 18
    //   65: new 229	org/apache/http/client/methods/HttpGet
    //   68: dup
    //   69: aload 18
    //   71: invokespecial 230	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   74: pop
    //   75: new 4	java/lang/Object
    //   78: dup
    //   79: invokespecial 161	java/lang/Object:<init>	()V
    //   82: astore 21
    //   84: aconst_null
    //   85: astore 14
    //   87: iconst_0
    //   88: istore 9
    //   90: ldc2_w 417
    //   93: lstore 12
    //   95: invokestatic 467	com/tencent/mobileqq/msf/sdk/AppNetConnInfo:getRecentNetworkInfo	()Landroid/net/NetworkInfo;
    //   98: astore 22
    //   100: aload 22
    //   102: ifnonnull +196 -> 298
    //   105: invokestatic 151	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   108: ifeq +12 -> 120
    //   111: ldc 153
    //   113: iconst_2
    //   114: ldc_w 560
    //   117: invokestatic 449	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   120: aload 20
    //   122: iconst_1
    //   123: putfield 459	apnb:jdField_b_of_type_Int	I
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
    //   145: invokeinterface 565 2 0
    //   150: pop
    //   151: aload 20
    //   153: areturn
    //   154: astore_0
    //   155: invokestatic 151	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   158: ifeq +13 -> 171
    //   161: ldc 153
    //   163: iconst_2
    //   164: aload_0
    //   165: invokevirtual 566	java/net/MalformedURLException:toString	()Ljava/lang/String;
    //   168: invokestatic 449	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   171: aload 20
    //   173: aload_0
    //   174: invokestatic 225	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   177: putfield 227	apnb:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   180: aload 20
    //   182: bipush 13
    //   184: putfield 459	apnb:jdField_b_of_type_Int	I
    //   187: aload_1
    //   188: ifnull +12 -> 200
    //   191: aload_1
    //   192: aload 20
    //   194: invokeinterface 565 2 0
    //   199: pop
    //   200: aload 20
    //   202: areturn
    //   203: astore 14
    //   205: new 229	org/apache/http/client/methods/HttpGet
    //   208: dup
    //   209: aload 18
    //   211: invokestatic 357	com/tencent/mobileqq/utils/HttpDownloadUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   214: invokespecial 230	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   217: pop
    //   218: aload 18
    //   220: invokestatic 357	com/tencent/mobileqq/utils/HttpDownloadUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   223: astore 18
    //   225: goto -150 -> 75
    //   228: astore_0
    //   229: invokestatic 151	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   232: ifeq +13 -> 245
    //   235: ldc 153
    //   237: iconst_2
    //   238: aload_0
    //   239: invokevirtual 567	java/lang/IllegalArgumentException:toString	()Ljava/lang/String;
    //   242: invokestatic 449	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   245: aload 20
    //   247: bipush 13
    //   249: putfield 459	apnb:jdField_b_of_type_Int	I
    //   252: aload_1
    //   253: ifnull +12 -> 265
    //   256: aload_1
    //   257: aload 20
    //   259: invokeinterface 565 2 0
    //   264: pop
    //   265: aload 20
    //   267: areturn
    //   268: aload 21
    //   270: monitorenter
    //   271: aload 21
    //   273: lload 12
    //   275: invokevirtual 422	java/lang/Object:wait	(J)V
    //   278: lload 12
    //   280: ldc2_w 568
    //   283: lmul
    //   284: lstore 12
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
    //   323: invokevirtual 260	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   326: astore 19
    //   328: aload 14
    //   330: astore 16
    //   332: aload 14
    //   334: astore 17
    //   336: aload 14
    //   338: astore 15
    //   340: aload 22
    //   342: invokevirtual 572	android/net/NetworkInfo:getType	()I
    //   345: istore 8
    //   347: aload 14
    //   349: astore 16
    //   351: aload 14
    //   353: astore 17
    //   355: aload 14
    //   357: astore 15
    //   359: invokestatic 251	android/net/Proxy:getDefaultHost	()Ljava/lang/String;
    //   362: astore 22
    //   364: aload 14
    //   366: astore 16
    //   368: aload 14
    //   370: astore 17
    //   372: aload 14
    //   374: astore 15
    //   376: invokestatic 255	android/net/Proxy:getDefaultPort	()I
    //   379: istore 10
    //   381: aload 14
    //   383: astore 16
    //   385: aload 14
    //   387: astore 17
    //   389: aload 14
    //   391: astore 15
    //   393: aload 19
    //   395: invokestatic 576	bdlr:b	(Ljava/lang/String;)Ljava/lang/String;
    //   398: astore 19
    //   400: aload 14
    //   402: astore 16
    //   404: aload 14
    //   406: astore 17
    //   408: aload 14
    //   410: astore 15
    //   412: aload 19
    //   414: getstatic 577	com/tencent/mobileqq/utils/HttpDownloadUtil:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   417: invokevirtual 581	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   420: ifne +65 -> 485
    //   423: aload 14
    //   425: astore 16
    //   427: aload 14
    //   429: astore 17
    //   431: aload 14
    //   433: astore 15
    //   435: aload 19
    //   437: putstatic 577	com/tencent/mobileqq/utils/HttpDownloadUtil:jdField_b_of_type_JavaLangString	Ljava/lang/String;
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
    //   460: getstatic 583	bdlr:d	Ljava/lang/String;
    //   463: invokevirtual 581	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   466: ifeq +562 -> 1028
    //   469: aload 14
    //   471: astore 16
    //   473: aload 14
    //   475: astore 17
    //   477: aload 14
    //   479: astore 15
    //   481: iconst_0
    //   482: putstatic 585	com/tencent/mobileqq/utils/HttpDownloadUtil:jdField_a_of_type_Boolean	Z
    //   485: iload 8
    //   487: iconst_1
    //   488: if_icmpne +65 -> 553
    //   491: aload 14
    //   493: astore 16
    //   495: aload 14
    //   497: astore 17
    //   499: aload 14
    //   501: astore 15
    //   503: ldc_w 587
    //   506: aload 22
    //   508: invokevirtual 581	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   511: ifne +26 -> 537
    //   514: aload 14
    //   516: astore 16
    //   518: aload 14
    //   520: astore 17
    //   522: aload 14
    //   524: astore 15
    //   526: ldc_w 589
    //   529: aload 22
    //   531: invokevirtual 581	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   534: ifeq +19 -> 553
    //   537: aload 14
    //   539: astore 16
    //   541: aload 14
    //   543: astore 17
    //   545: aload 14
    //   547: astore 15
    //   549: iconst_1
    //   550: putstatic 585	com/tencent/mobileqq/utils/HttpDownloadUtil:jdField_a_of_type_Boolean	Z
    //   553: aload 14
    //   555: astore 16
    //   557: aload 14
    //   559: astore 17
    //   561: aload 14
    //   563: astore 15
    //   565: getstatic 585	com/tencent/mobileqq/utils/HttpDownloadUtil:jdField_a_of_type_Boolean	Z
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
    //   595: getstatic 583	bdlr:d	Ljava/lang/String;
    //   598: invokevirtual 581	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   601: ifne +49 -> 650
    //   604: aload 14
    //   606: astore 16
    //   608: aload 14
    //   610: astore 17
    //   612: aload 14
    //   614: astore 15
    //   616: aload 19
    //   618: getstatic 592	bdlr:f	Ljava/lang/String;
    //   621: invokevirtual 581	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   624: ifne +26 -> 650
    //   627: aload 14
    //   629: astore 16
    //   631: aload 14
    //   633: astore 17
    //   635: aload 14
    //   637: astore 15
    //   639: aload 19
    //   641: getstatic 595	bdlr:h	Ljava/lang/String;
    //   644: invokevirtual 581	java/lang/String:equals	(Ljava/lang/Object;)Z
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
    //   668: invokestatic 598	bdlr:b	(Ljava/lang/String;Ljava/lang/String;I)Ljava/net/HttpURLConnection;
    //   671: astore 14
    //   673: aload 14
    //   675: astore 16
    //   677: aload 14
    //   679: astore 17
    //   681: aload 14
    //   683: astore 15
    //   685: aload 20
    //   687: aload 14
    //   689: putfield 601	apnb:jdField_a_of_type_JavaNetHttpURLConnection	Ljava/net/HttpURLConnection;
    //   692: aload_2
    //   693: ifnull +614 -> 1307
    //   696: aload 14
    //   698: astore 16
    //   700: aload 14
    //   702: astore 17
    //   704: aload 14
    //   706: astore 15
    //   708: aload_2
    //   709: invokeinterface 606 1 0
    //   714: ifne +593 -> 1307
    //   717: aload 14
    //   719: astore 16
    //   721: aload 14
    //   723: astore 17
    //   725: aload 14
    //   727: astore 15
    //   729: aload_2
    //   730: invokeinterface 610 1 0
    //   735: astore 19
    //   737: aload 14
    //   739: astore 16
    //   741: aload 14
    //   743: astore 17
    //   745: aload 14
    //   747: astore 15
    //   749: aload 19
    //   751: invokeinterface 615 1 0
    //   756: ifeq +551 -> 1307
    //   759: aload 14
    //   761: astore 16
    //   763: aload 14
    //   765: astore 17
    //   767: aload 14
    //   769: astore 15
    //   771: aload 19
    //   773: invokeinterface 619 1 0
    //   778: checkcast 621	org/apache/http/Header
    //   781: astore 22
    //   783: aload 14
    //   785: astore 16
    //   787: aload 14
    //   789: astore 17
    //   791: aload 14
    //   793: astore 15
    //   795: aload 14
    //   797: aload 22
    //   799: invokeinterface 624 1 0
    //   804: aload 22
    //   806: invokeinterface 627 1 0
    //   811: invokevirtual 633	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   814: goto -77 -> 737
    //   817: astore 15
    //   819: aload 16
    //   821: astore 14
    //   823: aload 15
    //   825: astore 16
    //   827: aload 14
    //   829: astore 15
    //   831: invokestatic 151	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   834: ifeq +12 -> 846
    //   837: aload 14
    //   839: astore 15
    //   841: aload 16
    //   843: invokevirtual 435	java/io/IOException:printStackTrace	()V
    //   846: iconst_5
    //   847: istore 8
    //   849: aload 14
    //   851: astore 15
    //   853: aload 16
    //   855: instanceof 437
    //   858: ifeq +1353 -> 2211
    //   861: bipush 10
    //   863: istore 8
    //   865: iload_3
    //   866: istore 9
    //   868: aload 14
    //   870: astore 15
    //   872: aload 20
    //   874: iload 8
    //   876: putfield 459	apnb:jdField_b_of_type_Int	I
    //   879: aload 14
    //   881: astore 15
    //   883: invokestatic 151	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   886: ifeq +76 -> 962
    //   889: aload 14
    //   891: astore 15
    //   893: ldc 153
    //   895: iconst_2
    //   896: new 208	java/lang/StringBuilder
    //   899: dup
    //   900: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   903: ldc_w 635
    //   906: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   909: iload 8
    //   911: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   914: ldc_w 637
    //   917: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   920: aload 20
    //   922: getfield 639	apnb:jdField_c_of_type_Int	I
    //   925: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   928: ldc_w 441
    //   931: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   934: aload 20
    //   936: getfield 182	apnb:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   939: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   942: ldc_w 641
    //   945: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   948: aload 16
    //   950: invokevirtual 642	java/io/IOException:toString	()Ljava/lang/String;
    //   953: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   956: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   959: invokestatic 449	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   962: aload 14
    //   964: astore 15
    //   966: iload 9
    //   968: istore 8
    //   970: aload 14
    //   972: ifnull +16 -> 988
    //   975: aload 14
    //   977: invokevirtual 645	java/net/HttpURLConnection:disconnect	()V
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
    //   1005: lload 12
    //   1007: invokevirtual 422	java/lang/Object:wait	(J)V
    //   1010: lload 12
    //   1012: ldc2_w 568
    //   1015: lmul
    //   1016: lstore 12
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
    //   1041: putstatic 585	com/tencent/mobileqq/utils/HttpDownloadUtil:jdField_a_of_type_Boolean	Z
    //   1044: goto -559 -> 485
    //   1047: astore 16
    //   1049: aload 17
    //   1051: astore 14
    //   1053: aload 14
    //   1055: astore 15
    //   1057: invokestatic 151	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1060: ifeq +12 -> 1072
    //   1063: aload 14
    //   1065: astore 15
    //   1067: aload 16
    //   1069: invokevirtual 460	java/lang/Exception:printStackTrace	()V
    //   1072: aload 14
    //   1074: astore 15
    //   1076: aload 20
    //   1078: iconst_5
    //   1079: putfield 459	apnb:jdField_b_of_type_Int	I
    //   1082: aload 14
    //   1084: astore 15
    //   1086: invokestatic 151	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1089: ifeq +79 -> 1168
    //   1092: aload 14
    //   1094: astore 15
    //   1096: ldc 153
    //   1098: iconst_2
    //   1099: new 208	java/lang/StringBuilder
    //   1102: dup
    //   1103: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   1106: ldc_w 635
    //   1109: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1112: aload 20
    //   1114: getfield 459	apnb:jdField_b_of_type_Int	I
    //   1117: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1120: ldc_w 647
    //   1123: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1126: aload 20
    //   1128: getfield 639	apnb:jdField_c_of_type_Int	I
    //   1131: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1134: ldc_w 441
    //   1137: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1140: aload 20
    //   1142: getfield 182	apnb:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1145: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1148: ldc_w 443
    //   1151: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1154: aload 16
    //   1156: invokevirtual 648	java/lang/Exception:toString	()Ljava/lang/String;
    //   1159: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1162: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1165: invokestatic 449	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1168: aload 14
    //   1170: astore 15
    //   1172: iload 9
    //   1174: istore 8
    //   1176: aload 14
    //   1178: ifnull -190 -> 988
    //   1181: aload 14
    //   1183: invokevirtual 645	java/net/HttpURLConnection:disconnect	()V
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
    //   1211: getstatic 649	bdlr:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1214: invokevirtual 581	java/lang/String:equals	(Ljava/lang/Object;)Z
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
    //   1238: invokestatic 651	bdlr:a	(Ljava/lang/String;Ljava/lang/String;I)Ljava/net/HttpURLConnection;
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
    //   1264: invokestatic 651	bdlr:a	(Ljava/lang/String;Ljava/lang/String;I)Ljava/net/HttpURLConnection;
    //   1267: astore 14
    //   1269: goto -596 -> 673
    //   1272: aload 14
    //   1274: astore 16
    //   1276: aload 14
    //   1278: astore 17
    //   1280: aload 14
    //   1282: astore 15
    //   1284: new 178	java/net/URL
    //   1287: dup
    //   1288: aload 18
    //   1290: invokespecial 183	java/net/URL:<init>	(Ljava/lang/String;)V
    //   1293: getstatic 657	java/net/Proxy:NO_PROXY	Ljava/net/Proxy;
    //   1296: invokevirtual 661	java/net/URL:openConnection	(Ljava/net/Proxy;)Ljava/net/URLConnection;
    //   1299: checkcast 629	java/net/HttpURLConnection
    //   1302: astore 14
    //   1304: goto -631 -> 673
    //   1307: aload 14
    //   1309: astore 16
    //   1311: aload 14
    //   1313: astore 17
    //   1315: aload 14
    //   1317: astore 15
    //   1319: aload 14
    //   1321: ldc_w 663
    //   1324: ldc_w 665
    //   1327: invokevirtual 668	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1330: aload 14
    //   1332: astore 16
    //   1334: aload 14
    //   1336: astore 17
    //   1338: aload 14
    //   1340: astore 15
    //   1342: aload 14
    //   1344: iload 6
    //   1346: invokevirtual 672	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   1349: aload 14
    //   1351: astore 16
    //   1353: aload 14
    //   1355: astore 17
    //   1357: aload 14
    //   1359: astore 15
    //   1361: aload 14
    //   1363: iload 7
    //   1365: invokevirtual 675	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   1368: aload 14
    //   1370: astore 16
    //   1372: aload 14
    //   1374: astore 17
    //   1376: aload 14
    //   1378: astore 15
    //   1380: aload 14
    //   1382: iconst_0
    //   1383: invokevirtual 679	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   1386: aload 14
    //   1388: astore 16
    //   1390: aload 14
    //   1392: astore 17
    //   1394: aload 14
    //   1396: astore 15
    //   1398: aload 14
    //   1400: invokevirtual 682	java/net/HttpURLConnection:connect	()V
    //   1403: aload 14
    //   1405: astore 16
    //   1407: aload 14
    //   1409: astore 17
    //   1411: aload 14
    //   1413: astore 15
    //   1415: aload 20
    //   1417: aload 14
    //   1419: invokevirtual 685	java/net/HttpURLConnection:getResponseCode	()I
    //   1422: putfield 639	apnb:jdField_c_of_type_Int	I
    //   1425: aload 14
    //   1427: astore 16
    //   1429: aload 14
    //   1431: astore 17
    //   1433: aload 14
    //   1435: astore 15
    //   1437: aload 20
    //   1439: aload 14
    //   1441: invokevirtual 687	java/net/HttpURLConnection:getContentLength	()I
    //   1444: putfield 689	apnb:jdField_e_of_type_Int	I
    //   1447: aload 14
    //   1449: astore 16
    //   1451: aload 14
    //   1453: astore 17
    //   1455: aload 14
    //   1457: astore 15
    //   1459: aload 20
    //   1461: aload 14
    //   1463: invokevirtual 692	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
    //   1466: putfield 693	apnb:h	Ljava/lang/String;
    //   1469: aload 14
    //   1471: astore 16
    //   1473: aload 14
    //   1475: astore 17
    //   1477: aload 14
    //   1479: astore 15
    //   1481: aload 20
    //   1483: aload 14
    //   1485: invokevirtual 696	java/net/HttpURLConnection:getContentEncoding	()Ljava/lang/String;
    //   1488: putfield 698	apnb:i	Ljava/lang/String;
    //   1491: aload 14
    //   1493: astore 16
    //   1495: aload 14
    //   1497: astore 17
    //   1499: aload 14
    //   1501: astore 15
    //   1503: aload 14
    //   1505: aload 20
    //   1507: invokestatic 701	com/tencent/mobileqq/utils/HttpDownloadUtil:a	(Ljava/net/HttpURLConnection;Lapnb;)V
    //   1510: aload 14
    //   1512: astore 16
    //   1514: aload 14
    //   1516: astore 17
    //   1518: aload 14
    //   1520: astore 15
    //   1522: invokestatic 151	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1525: ifeq +83 -> 1608
    //   1528: aload 14
    //   1530: astore 16
    //   1532: aload 14
    //   1534: astore 17
    //   1536: aload 14
    //   1538: astore 15
    //   1540: ldc 153
    //   1542: iconst_2
    //   1543: new 208	java/lang/StringBuilder
    //   1546: dup
    //   1547: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   1550: ldc_w 703
    //   1553: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1556: aload_0
    //   1557: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1560: ldc_w 705
    //   1563: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1566: aload 20
    //   1568: getfield 639	apnb:jdField_c_of_type_Int	I
    //   1571: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1574: ldc_w 707
    //   1577: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1580: aload 20
    //   1582: getfield 689	apnb:jdField_e_of_type_Int	I
    //   1585: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1588: ldc_w 709
    //   1591: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1594: aload 20
    //   1596: getfield 693	apnb:h	Ljava/lang/String;
    //   1599: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1602: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1605: invokestatic 398	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   1628: putfield 459	apnb:jdField_b_of_type_Int	I
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
    //   1650: invokeinterface 565 2 0
    //   1655: pop
    //   1656: aload 14
    //   1658: ifnull +8 -> 1666
    //   1661: aload 14
    //   1663: invokevirtual 645	java/net/HttpURLConnection:disconnect	()V
    //   1666: aload 20
    //   1668: areturn
    //   1669: aload 14
    //   1671: astore 16
    //   1673: aload 14
    //   1675: astore 17
    //   1677: aload 14
    //   1679: astore 15
    //   1681: aload 20
    //   1683: getfield 639	apnb:jdField_c_of_type_Int	I
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
    //   1711: putfield 459	apnb:jdField_b_of_type_Int	I
    //   1714: aload 14
    //   1716: astore 16
    //   1718: aload 14
    //   1720: astore 17
    //   1722: aload 14
    //   1724: astore 15
    //   1726: aload_1
    //   1727: aload 20
    //   1729: invokeinterface 565 2 0
    //   1734: ifeq +34 -> 1768
    //   1737: aload 14
    //   1739: astore 16
    //   1741: aload 14
    //   1743: astore 17
    //   1745: aload 14
    //   1747: astore 15
    //   1749: aload 20
    //   1751: iconst_0
    //   1752: putfield 459	apnb:jdField_b_of_type_Int	I
    //   1755: aload 14
    //   1757: ifnull +8 -> 1765
    //   1760: aload 14
    //   1762: invokevirtual 645	java/net/HttpURLConnection:disconnect	()V
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
    //   1783: putfield 459	apnb:jdField_b_of_type_Int	I
    //   1786: aload 14
    //   1788: astore 15
    //   1790: iload 9
    //   1792: istore 8
    //   1794: aload 14
    //   1796: ifnull -808 -> 988
    //   1799: aload 14
    //   1801: invokevirtual 645	java/net/HttpURLConnection:disconnect	()V
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
    //   1830: putfield 459	apnb:jdField_b_of_type_Int	I
    //   1833: aload 14
    //   1835: ifnull +8 -> 1843
    //   1838: aload 14
    //   1840: invokevirtual 645	java/net/HttpURLConnection:disconnect	()V
    //   1843: aload 20
    //   1845: areturn
    //   1846: aload 14
    //   1848: astore 16
    //   1850: aload 14
    //   1852: astore 17
    //   1854: aload 14
    //   1856: astore 15
    //   1858: aload 20
    //   1860: getfield 639	apnb:jdField_c_of_type_Int	I
    //   1863: sipush 302
    //   1866: if_icmpeq +26 -> 1892
    //   1869: aload 14
    //   1871: astore 16
    //   1873: aload 14
    //   1875: astore 17
    //   1877: aload 14
    //   1879: astore 15
    //   1881: aload 20
    //   1883: getfield 639	apnb:jdField_c_of_type_Int	I
    //   1886: sipush 301
    //   1889: if_icmpne +284 -> 2173
    //   1892: aload 14
    //   1894: astore 16
    //   1896: aload 14
    //   1898: astore 17
    //   1900: aload 14
    //   1902: astore 15
    //   1904: aload 14
    //   1906: ldc_w 711
    //   1909: invokevirtual 714	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   1912: astore 19
    //   1914: aload 14
    //   1916: astore 16
    //   1918: aload 14
    //   1920: astore 17
    //   1922: aload 14
    //   1924: astore 15
    //   1926: invokestatic 151	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1929: ifeq +42 -> 1971
    //   1932: aload 14
    //   1934: astore 16
    //   1936: aload 14
    //   1938: astore 17
    //   1940: aload 14
    //   1942: astore 15
    //   1944: ldc 153
    //   1946: iconst_2
    //   1947: new 208	java/lang/StringBuilder
    //   1950: dup
    //   1951: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   1954: ldc_w 716
    //   1957: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1960: aload 19
    //   1962: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1965: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1968: invokestatic 449	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1971: aload 14
    //   1973: astore 16
    //   1975: aload 14
    //   1977: astore 17
    //   1979: aload 14
    //   1981: astore 15
    //   1983: aload 19
    //   1985: invokestatic 721	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1988: ifeq +35 -> 2023
    //   1991: aload 14
    //   1993: astore 16
    //   1995: aload 14
    //   1997: astore 17
    //   1999: aload 14
    //   2001: astore 15
    //   2003: aload 20
    //   2005: bipush 20
    //   2007: putfield 459	apnb:jdField_b_of_type_Int	I
    //   2010: aload 14
    //   2012: ifnull +8 -> 2020
    //   2015: aload 14
    //   2017: invokevirtual 645	java/net/HttpURLConnection:disconnect	()V
    //   2020: aload 20
    //   2022: areturn
    //   2023: aload 14
    //   2025: astore 16
    //   2027: aload 14
    //   2029: astore 17
    //   2031: aload 14
    //   2033: astore 15
    //   2035: aload 14
    //   2037: invokevirtual 645	java/net/HttpURLConnection:disconnect	()V
    //   2040: aload_2
    //   2041: ifnull +88 -> 2129
    //   2044: aload_2
    //   2045: invokeinterface 724 1 0
    //   2050: istore 10
    //   2052: iconst_0
    //   2053: istore 8
    //   2055: iload 8
    //   2057: iload 10
    //   2059: if_icmpge +41 -> 2100
    //   2062: aload_2
    //   2063: iload 8
    //   2065: invokeinterface 728 2 0
    //   2070: checkcast 621	org/apache/http/Header
    //   2073: astore 14
    //   2075: aload 14
    //   2077: invokeinterface 624 1 0
    //   2082: ldc_w 730
    //   2085: invokevirtual 581	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2088: ifeq +76 -> 2164
    //   2091: aload_2
    //   2092: aload 14
    //   2094: invokeinterface 733 2 0
    //   2099: pop
    //   2100: aload_2
    //   2101: new 735	org/apache/http/message/BasicHeader
    //   2104: dup
    //   2105: ldc_w 730
    //   2108: new 178	java/net/URL
    //   2111: dup
    //   2112: aload 19
    //   2114: invokespecial 183	java/net/URL:<init>	(Ljava/lang/String;)V
    //   2117: invokevirtual 296	java/net/URL:getHost	()Ljava/lang/String;
    //   2120: invokespecial 737	org/apache/http/message/BasicHeader:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   2123: invokeinterface 740 2 0
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
    //   2144: invokestatic 549	com/tencent/mobileqq/utils/HttpDownloadUtil:a	(Ljava/lang/String;Lbdcx;Ljava/util/List;IZIII)Lapnb;
    //   2147: astore 14
    //   2149: aload 14
    //   2151: astore_0
    //   2152: iconst_0
    //   2153: ifeq -2110 -> 43
    //   2156: new 742	java/lang/NullPointerException
    //   2159: dup
    //   2160: invokespecial 743	java/lang/NullPointerException:<init>	()V
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
    //   2189: getfield 639	apnb:jdField_c_of_type_Int	I
    //   2192: putfield 459	apnb:jdField_b_of_type_Int	I
    //   2195: goto -409 -> 1786
    //   2198: astore_0
    //   2199: aload 15
    //   2201: ifnull +8 -> 2209
    //   2204: aload 15
    //   2206: invokevirtual 645	java/net/HttpURLConnection:disconnect	()V
    //   2209: aload_0
    //   2210: athrow
    //   2211: aload 14
    //   2213: astore 15
    //   2215: aload 16
    //   2217: instanceof 430
    //   2220: ifne +151 -> 2371
    //   2223: aload 14
    //   2225: astore 15
    //   2227: aload 16
    //   2229: instanceof 432
    //   2232: ifeq +6 -> 2238
    //   2235: goto +136 -> 2371
    //   2238: aload 14
    //   2240: astore 15
    //   2242: aload 16
    //   2244: instanceof 457
    //   2247: ifeq +17 -> 2264
    //   2250: aload 14
    //   2252: astore 15
    //   2254: aload 20
    //   2256: bipush 11
    //   2258: putfield 459	apnb:jdField_b_of_type_Int	I
    //   2261: goto -1393 -> 868
    //   2264: aload 14
    //   2266: astore 15
    //   2268: aload 16
    //   2270: instanceof 164
    //   2273: istore 11
    //   2275: iload 11
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
    //   2309: invokeinterface 565 2 0
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
    //   0	2377	1	parambdcx	bdcx
    //   0	2377	2	paramList	List<Header>
    //   0	2377	3	paramInt1	int
    //   0	2377	4	paramBoolean	boolean
    //   0	2377	5	paramInt2	int
    //   0	2377	6	paramInt3	int
    //   0	2377	7	paramInt4	int
    //   130	2243	8	i	int
    //   88	2270	9	j	int
    //   379	1681	10	k	int
    //   2273	3	11	bool	boolean
    //   93	924	12	l	long
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
    //   10	2359	20	localapnb	apnb
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
  
  public static String a(String paramString)
  {
    return paramString.replaceAll("\\{", "%7B").replaceAll("\\}", "%7D").replaceAll("\\|", "%7C");
  }
  
  public static void a(apnb paramapnb)
  {
    if ((paramapnb == null) || (paramapnb.jdField_a_of_type_JavaLangString == null) || (paramapnb.jdField_a_of_type_JavaLangString.length() == 0)) {}
    label33:
    int i;
    int j;
    String str2;
    do
    {
      return;
      if (!paramapnb.jdField_b_of_type_Boolean) {
        break;
      }
      localObject = jdField_a_of_type_JavaLangString;
      i = ((String)localObject).length();
      j = paramapnb.jdField_a_of_type_JavaLangString.indexOf("/", i);
      str2 = paramapnb.jdField_a_of_type_JavaLangString.substring(i, j);
    } while ((j <= i) && (TextUtils.isEmpty(str2)));
    label88:
    String str1;
    if ("imgcache.qq.com".equalsIgnoreCase(str2))
    {
      i = 12;
      str1 = (String)localObject + "[^/\\s]*/";
      String str3 = baoc.a().b(i);
      if ((str3 == null) || (str3.length() <= 0)) {
        break label413;
      }
      str1 = paramapnb.jdField_a_of_type_JavaLangString.replaceFirst(str1, str3);
      if ((!paramapnb.jdField_b_of_type_Boolean) || (TextUtils.isEmpty(str1)) || (!str1.startsWith("http://"))) {
        break label474;
      }
    }
    label413:
    label474:
    for (Object localObject = (String)localObject + str1.substring("http://".length());; localObject = str1)
    {
      paramapnb.jdField_c_of_type_JavaLangString = str2;
      paramapnb.jdField_b_of_type_JavaLangString = ((String)localObject);
      paramapnb.jdField_a_of_type_Boolean = true;
      paramapnb.d = i;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.emoji.EmoDown", 2, "replaceDomainWithIp " + paramapnb.jdField_a_of_type_Boolean + " url[" + paramapnb.jdField_a_of_type_JavaLangString + "] resetIP[" + (String)localObject + "] host[" + paramapnb.jdField_c_of_type_JavaLangString + "]");
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
      paramapnb.jdField_c_of_type_JavaLangString = null;
      paramapnb.jdField_b_of_type_JavaLangString = paramapnb.jdField_a_of_type_JavaLangString;
      paramapnb.jdField_a_of_type_Boolean = false;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.emoji.EmoDown", 2, "unknow domain url=" + paramapnb.jdField_a_of_type_Boolean);
      return;
      paramapnb.jdField_c_of_type_JavaLangString = null;
      paramapnb.jdField_b_of_type_JavaLangString = paramapnb.jdField_a_of_type_JavaLangString;
      paramapnb.jdField_a_of_type_Boolean = false;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.emoji.EmoDown", 2, "replaceDomainWithIp false.url[" + paramapnb.jdField_b_of_type_JavaLangString + "]");
      return;
    }
  }
  
  static void a(HttpURLConnection paramHttpURLConnection, apnb paramapnb)
  {
    if ((paramHttpURLConnection == null) || (paramapnb == null)) {}
    do
    {
      return;
      if (paramHttpURLConnection.getHeaderField("X-FailNo") != null) {
        paramapnb.j = paramHttpURLConnection.getHeaderField("X-FailNo");
      }
    } while (paramHttpURLConnection.getHeaderField("X-ErrNo") == null);
    paramapnb.k = paramHttpURLConnection.getHeaderField("X-ErrNo");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.HttpDownloadUtil
 * JD-Core Version:    0.7.0.1
 */