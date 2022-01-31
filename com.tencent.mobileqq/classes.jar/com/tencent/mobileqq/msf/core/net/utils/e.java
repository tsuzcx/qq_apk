package com.tencent.mobileqq.msf.core.net.utils;

import android.os.Build.VERSION;
import com.tencent.qphone.base.util.QLog;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;

public class e
{
  public static final String a = "HttpDownloadUtil";
  public static final int b = 2;
  public static final int c = 0;
  public static final int d = 1;
  public static final int e = 2;
  public static final int f = 4;
  public static final int g = 5;
  public static final int h = 7;
  public static final int i = 8;
  public static final int j = 10;
  public static final int k = 11;
  public static final int l = 13;
  
  /* Error */
  private static int a(java.net.URL paramURL, java.io.File paramFile, android.net.NetworkInfo paramNetworkInfo, int paramInt)
  {
    // Byte code:
    //   0: invokestatic 54	java/lang/System:currentTimeMillis	()J
    //   3: lstore 14
    //   5: new 4	java/lang/Object
    //   8: dup
    //   9: invokespecial 34	java/lang/Object:<init>	()V
    //   12: astore 30
    //   14: iload_3
    //   15: istore 6
    //   17: iload_3
    //   18: ifge +6 -> 24
    //   21: iconst_2
    //   22: istore 6
    //   24: aload_1
    //   25: invokevirtual 60	java/io/File:getParentFile	()Ljava/io/File;
    //   28: astore 19
    //   30: aload 19
    //   32: ifnull +17 -> 49
    //   35: aload 19
    //   37: invokevirtual 64	java/io/File:exists	()Z
    //   40: ifne +9 -> 49
    //   43: aload 19
    //   45: invokevirtual 67	java/io/File:mkdirs	()Z
    //   48: pop
    //   49: aconst_null
    //   50: astore 19
    //   52: aload_0
    //   53: invokevirtual 73	java/net/URL:toString	()Ljava/lang/String;
    //   56: astore 20
    //   58: new 75	org/apache/http/client/methods/HttpGet
    //   61: dup
    //   62: aload 20
    //   64: invokespecial 78	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   67: astore 28
    //   69: new 80	org/apache/http/params/BasicHttpParams
    //   72: dup
    //   73: invokespecial 81	org/apache/http/params/BasicHttpParams:<init>	()V
    //   76: astore 31
    //   78: sipush 20000
    //   81: istore 4
    //   83: ldc 82
    //   85: istore_3
    //   86: aload_2
    //   87: ifnull +97 -> 184
    //   90: invokestatic 87	android/net/Proxy:getDefaultHost	()Ljava/lang/String;
    //   93: astore 20
    //   95: invokestatic 91	android/net/Proxy:getDefaultPort	()I
    //   98: istore_3
    //   99: aload_2
    //   100: invokevirtual 96	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   103: astore 21
    //   105: aload_2
    //   106: invokestatic 102	com/tencent/mobileqq/msf/core/NetConnInfoCenter:isMobileNetworkInfo	(Landroid/net/NetworkInfo;)Z
    //   109: ifeq +47 -> 156
    //   112: aload 21
    //   114: ifnull +13 -> 127
    //   117: aload 21
    //   119: ldc 104
    //   121: invokevirtual 110	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   124: ifeq +32 -> 156
    //   127: aload 20
    //   129: ifnull +27 -> 156
    //   132: iload_3
    //   133: ifle +23 -> 156
    //   136: aload 31
    //   138: ldc 112
    //   140: new 114	org/apache/http/HttpHost
    //   143: dup
    //   144: aload 20
    //   146: iload_3
    //   147: invokespecial 117	org/apache/http/HttpHost:<init>	(Ljava/lang/String;I)V
    //   150: invokeinterface 123 3 0
    //   155: pop
    //   156: aload_2
    //   157: invokestatic 102	com/tencent/mobileqq/msf/core/NetConnInfoCenter:isMobileNetworkInfo	(Landroid/net/NetworkInfo;)Z
    //   160: ifeq +904 -> 1064
    //   163: sipush 20000
    //   166: istore 4
    //   168: ldc 82
    //   170: istore_3
    //   171: aload 31
    //   173: ldc 125
    //   175: sipush 2048
    //   178: invokeinterface 129 3 0
    //   183: pop
    //   184: aload 31
    //   186: ldc 131
    //   188: iload 4
    //   190: invokestatic 137	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   193: invokeinterface 123 3 0
    //   198: pop
    //   199: aload 31
    //   201: ldc 139
    //   203: iload_3
    //   204: invokestatic 137	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   207: invokeinterface 123 3 0
    //   212: pop
    //   213: aload 28
    //   215: aload 31
    //   217: invokevirtual 143	org/apache/http/client/methods/HttpGet:setParams	(Lorg/apache/http/params/HttpParams;)V
    //   220: aload_1
    //   221: ifnull +15 -> 236
    //   224: aload_1
    //   225: invokevirtual 64	java/io/File:exists	()Z
    //   228: ifeq +8 -> 236
    //   231: aload_1
    //   232: invokevirtual 146	java/io/File:delete	()Z
    //   235: pop
    //   236: aconst_null
    //   237: astore_2
    //   238: iconst_m1
    //   239: istore 7
    //   241: iload 7
    //   243: ifne +35 -> 278
    //   246: aload 31
    //   248: ldc 112
    //   250: new 114	org/apache/http/HttpHost
    //   253: dup
    //   254: aload_0
    //   255: invokevirtual 149	java/net/URL:getHost	()Ljava/lang/String;
    //   258: aload_0
    //   259: invokevirtual 152	java/net/URL:getPort	()I
    //   262: invokespecial 117	org/apache/http/HttpHost:<init>	(Ljava/lang/String;I)V
    //   265: invokeinterface 123 3 0
    //   270: pop
    //   271: aload 28
    //   273: aload 31
    //   275: invokevirtual 143	org/apache/http/client/methods/HttpGet:setParams	(Lorg/apache/http/params/HttpParams;)V
    //   278: iconst_5
    //   279: istore_3
    //   280: aload_2
    //   281: astore 21
    //   283: aload 19
    //   285: astore 24
    //   287: aload_2
    //   288: astore 25
    //   290: aload 19
    //   292: astore 22
    //   294: aload_2
    //   295: astore 26
    //   297: aload 19
    //   299: astore 23
    //   301: aload_2
    //   302: astore 20
    //   304: aload 19
    //   306: astore 27
    //   308: invokestatic 155	com/tencent/mobileqq/msf/core/net/utils/e:a	()Lorg/apache/http/client/HttpClient;
    //   311: new 114	org/apache/http/HttpHost
    //   314: dup
    //   315: aload_0
    //   316: invokevirtual 149	java/net/URL:getHost	()Ljava/lang/String;
    //   319: invokespecial 156	org/apache/http/HttpHost:<init>	(Ljava/lang/String;)V
    //   322: aload 28
    //   324: invokeinterface 162 3 0
    //   329: astore 29
    //   331: aload_2
    //   332: astore 21
    //   334: aload 19
    //   336: astore 24
    //   338: aload_2
    //   339: astore 25
    //   341: aload 19
    //   343: astore 22
    //   345: aload_2
    //   346: astore 26
    //   348: aload 19
    //   350: astore 23
    //   352: aload_2
    //   353: astore 20
    //   355: aload 19
    //   357: astore 27
    //   359: aload 29
    //   361: invokeinterface 168 1 0
    //   366: invokeinterface 173 1 0
    //   371: istore 4
    //   373: aload_2
    //   374: astore 21
    //   376: aload 19
    //   378: astore 24
    //   380: aload_2
    //   381: astore 25
    //   383: aload 19
    //   385: astore 22
    //   387: aload_2
    //   388: astore 26
    //   390: aload 19
    //   392: astore 23
    //   394: aload_2
    //   395: astore 20
    //   397: aload 19
    //   399: astore 27
    //   401: aload 29
    //   403: invokeinterface 177 1 0
    //   408: astore_2
    //   409: sipush 200
    //   412: iload 4
    //   414: if_icmpne +837 -> 1251
    //   417: aload_2
    //   418: astore 21
    //   420: aload 19
    //   422: astore 24
    //   424: aload_2
    //   425: astore 25
    //   427: aload 19
    //   429: astore 22
    //   431: aload_2
    //   432: astore 26
    //   434: aload 19
    //   436: astore 23
    //   438: aload_2
    //   439: astore 20
    //   441: aload 19
    //   443: astore 27
    //   445: aload_2
    //   446: invokeinterface 182 1 0
    //   451: lstore 16
    //   453: lconst_0
    //   454: lstore 8
    //   456: aload_2
    //   457: astore 21
    //   459: aload 19
    //   461: astore 24
    //   463: aload_2
    //   464: astore 25
    //   466: aload 19
    //   468: astore 22
    //   470: aload_2
    //   471: astore 26
    //   473: aload 19
    //   475: astore 23
    //   477: new 184	java/io/BufferedOutputStream
    //   480: dup
    //   481: new 186	java/io/FileOutputStream
    //   484: dup
    //   485: aload_1
    //   486: invokespecial 189	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   489: invokespecial 192	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   492: astore 20
    //   494: lload 8
    //   496: lstore 10
    //   498: lload 8
    //   500: lstore 12
    //   502: aload 20
    //   504: astore 22
    //   506: aload 20
    //   508: astore 23
    //   510: aload 20
    //   512: astore 21
    //   514: aload_2
    //   515: aload 20
    //   517: invokeinterface 195 2 0
    //   522: lload 8
    //   524: lstore 10
    //   526: lload 8
    //   528: lstore 12
    //   530: aload 20
    //   532: astore 22
    //   534: aload 20
    //   536: astore 23
    //   538: aload 20
    //   540: astore 21
    //   542: aload 20
    //   544: invokevirtual 200	java/io/OutputStream:flush	()V
    //   547: lload 8
    //   549: lstore 10
    //   551: lload 8
    //   553: lstore 12
    //   555: aload 20
    //   557: astore 22
    //   559: aload 20
    //   561: astore 23
    //   563: aload 20
    //   565: astore 21
    //   567: aload_1
    //   568: invokevirtual 203	java/io/File:length	()J
    //   571: lstore 8
    //   573: lload 8
    //   575: lstore 10
    //   577: lload 8
    //   579: lstore 12
    //   581: aload 20
    //   583: astore 22
    //   585: aload 20
    //   587: astore 23
    //   589: aload 20
    //   591: astore 21
    //   593: aload_1
    //   594: invokestatic 54	java/lang/System:currentTimeMillis	()J
    //   597: invokevirtual 207	java/io/File:setLastModified	(J)Z
    //   600: pop
    //   601: lload 8
    //   603: lstore 10
    //   605: lload 8
    //   607: lstore 12
    //   609: aload 20
    //   611: astore 22
    //   613: aload 20
    //   615: astore 23
    //   617: aload 20
    //   619: astore 21
    //   621: invokestatic 212	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   624: ifeq +72 -> 696
    //   627: lload 8
    //   629: lstore 10
    //   631: lload 8
    //   633: lstore 12
    //   635: aload 20
    //   637: astore 22
    //   639: aload 20
    //   641: astore 23
    //   643: aload 20
    //   645: astore 21
    //   647: ldc 8
    //   649: iconst_2
    //   650: new 214	java/lang/StringBuilder
    //   653: dup
    //   654: invokespecial 215	java/lang/StringBuilder:<init>	()V
    //   657: ldc 217
    //   659: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   662: invokestatic 54	java/lang/System:currentTimeMillis	()J
    //   665: lload 14
    //   667: lsub
    //   668: invokevirtual 224	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   671: ldc 226
    //   673: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   676: lload 8
    //   678: invokevirtual 224	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   681: ldc 228
    //   683: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   686: aload_0
    //   687: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   690: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   693: invokestatic 235	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   696: aload 20
    //   698: astore 19
    //   700: iconst_0
    //   701: istore_3
    //   702: iload_3
    //   703: istore 4
    //   705: lload 16
    //   707: lconst_0
    //   708: lcmp
    //   709: ifle +71 -> 780
    //   712: iload_3
    //   713: istore 4
    //   715: lload 8
    //   717: lload 16
    //   719: lcmp
    //   720: ifge +60 -> 780
    //   723: invokestatic 212	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   726: ifeq +50 -> 776
    //   729: ldc 8
    //   731: iconst_2
    //   732: new 214	java/lang/StringBuilder
    //   735: dup
    //   736: invokespecial 215	java/lang/StringBuilder:<init>	()V
    //   739: ldc 237
    //   741: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   744: lload 16
    //   746: invokevirtual 224	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   749: ldc 239
    //   751: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   754: aload_1
    //   755: invokevirtual 203	java/io/File:length	()J
    //   758: invokevirtual 224	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   761: ldc 241
    //   763: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   766: aload_0
    //   767: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   770: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   773: invokestatic 244	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   776: bipush 8
    //   778: istore 4
    //   780: aload_2
    //   781: ifnull +9 -> 790
    //   784: aload_2
    //   785: invokeinterface 247 1 0
    //   790: aload 19
    //   792: ifnull +8 -> 800
    //   795: aload 19
    //   797: invokevirtual 250	java/io/OutputStream:close	()V
    //   800: iload 4
    //   802: ifeq +71 -> 873
    //   805: aload_1
    //   806: ifnull +67 -> 873
    //   809: aload_1
    //   810: invokevirtual 60	java/io/File:getParentFile	()Ljava/io/File;
    //   813: astore 20
    //   815: aload 20
    //   817: ifnull +17 -> 834
    //   820: aload 20
    //   822: invokevirtual 64	java/io/File:exists	()Z
    //   825: ifne +9 -> 834
    //   828: aload 20
    //   830: invokevirtual 67	java/io/File:mkdirs	()Z
    //   833: pop
    //   834: aload_1
    //   835: invokevirtual 64	java/io/File:exists	()Z
    //   838: ifeq +35 -> 873
    //   841: aload_1
    //   842: invokevirtual 146	java/io/File:delete	()Z
    //   845: istore 18
    //   847: ldc 8
    //   849: iconst_1
    //   850: new 214	java/lang/StringBuilder
    //   853: dup
    //   854: invokespecial 215	java/lang/StringBuilder:<init>	()V
    //   857: ldc 252
    //   859: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   862: iload 18
    //   864: invokevirtual 255	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   867: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   870: invokestatic 257	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   873: aload 19
    //   875: astore 21
    //   877: aload_2
    //   878: astore 20
    //   880: iload 7
    //   882: iconst_1
    //   883: iadd
    //   884: istore 7
    //   886: invokestatic 212	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   889: ifeq +39 -> 928
    //   892: ldc 8
    //   894: iconst_2
    //   895: new 214	java/lang/StringBuilder
    //   898: dup
    //   899: invokespecial 215	java/lang/StringBuilder:<init>	()V
    //   902: ldc_w 259
    //   905: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   908: iload 4
    //   910: invokevirtual 262	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   913: ldc 241
    //   915: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   918: aload_0
    //   919: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   922: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   925: invokestatic 257	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   928: iload 4
    //   930: ifeq +50 -> 980
    //   933: ldc 8
    //   935: iconst_1
    //   936: new 214	java/lang/StringBuilder
    //   939: dup
    //   940: invokespecial 215	java/lang/StringBuilder:<init>	()V
    //   943: ldc_w 259
    //   946: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   949: iload 4
    //   951: invokevirtual 262	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   954: ldc 241
    //   956: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   959: aload_0
    //   960: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   963: ldc_w 264
    //   966: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   969: iload 7
    //   971: invokevirtual 262	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   974: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   977: invokestatic 257	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   980: iload 4
    //   982: ifeq +23 -> 1005
    //   985: iload 7
    //   987: iconst_2
    //   988: if_icmpge +17 -> 1005
    //   991: aload 30
    //   993: monitorenter
    //   994: aload 30
    //   996: ldc2_w 265
    //   999: invokevirtual 270	java/lang/Object:wait	(J)V
    //   1002: aload 30
    //   1004: monitorexit
    //   1005: iload 4
    //   1007: ifeq +10 -> 1017
    //   1010: iload 7
    //   1012: iload 6
    //   1014: if_icmplt +1341 -> 2355
    //   1017: iload 4
    //   1019: ireturn
    //   1020: astore_0
    //   1021: ldc 8
    //   1023: iconst_1
    //   1024: ldc_w 272
    //   1027: invokestatic 257	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1030: iconst_4
    //   1031: ireturn
    //   1032: astore 21
    //   1034: new 75	org/apache/http/client/methods/HttpGet
    //   1037: dup
    //   1038: aload 20
    //   1040: invokestatic 275	com/tencent/mobileqq/msf/core/net/utils/e:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1043: invokespecial 78	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   1046: astore 28
    //   1048: goto -979 -> 69
    //   1051: astore_0
    //   1052: ldc 8
    //   1054: iconst_1
    //   1055: ldc_w 277
    //   1058: invokestatic 257	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1061: bipush 13
    //   1063: ireturn
    //   1064: sipush 10000
    //   1067: istore 4
    //   1069: sipush 30000
    //   1072: istore_3
    //   1073: aload 31
    //   1075: ldc 125
    //   1077: sipush 4096
    //   1080: invokeinterface 129 3 0
    //   1085: pop
    //   1086: goto -902 -> 184
    //   1089: astore 19
    //   1091: lload 10
    //   1093: lstore 8
    //   1095: aload 20
    //   1097: astore 19
    //   1099: aload 19
    //   1101: astore 22
    //   1103: aload 19
    //   1105: astore 23
    //   1107: aload 19
    //   1109: astore 21
    //   1111: ldc 8
    //   1113: iconst_1
    //   1114: new 214	java/lang/StringBuilder
    //   1117: dup
    //   1118: invokespecial 215	java/lang/StringBuilder:<init>	()V
    //   1121: ldc_w 279
    //   1124: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1127: aload_1
    //   1128: invokevirtual 64	java/io/File:exists	()Z
    //   1131: invokevirtual 255	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1134: ldc_w 281
    //   1137: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1140: aload_1
    //   1141: invokevirtual 60	java/io/File:getParentFile	()Ljava/io/File;
    //   1144: invokevirtual 64	java/io/File:exists	()Z
    //   1147: invokevirtual 255	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1150: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1153: invokestatic 257	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1156: iconst_5
    //   1157: istore_3
    //   1158: goto -456 -> 702
    //   1161: astore 29
    //   1163: aload 20
    //   1165: astore 19
    //   1167: lload 12
    //   1169: lstore 8
    //   1171: aload_2
    //   1172: astore 21
    //   1174: aload 19
    //   1176: astore 24
    //   1178: aload_2
    //   1179: astore 25
    //   1181: aload 19
    //   1183: astore 22
    //   1185: aload_2
    //   1186: astore 26
    //   1188: aload 19
    //   1190: astore 23
    //   1192: aload_2
    //   1193: astore 20
    //   1195: aload 19
    //   1197: astore 27
    //   1199: invokestatic 212	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1202: ifeq +44 -> 1246
    //   1205: aload_2
    //   1206: astore 21
    //   1208: aload 19
    //   1210: astore 24
    //   1212: aload_2
    //   1213: astore 25
    //   1215: aload 19
    //   1217: astore 22
    //   1219: aload_2
    //   1220: astore 26
    //   1222: aload 19
    //   1224: astore 23
    //   1226: aload_2
    //   1227: astore 20
    //   1229: aload 19
    //   1231: astore 27
    //   1233: ldc 8
    //   1235: iconst_2
    //   1236: aload 29
    //   1238: invokevirtual 284	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1241: aload 29
    //   1243: invokestatic 287	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1246: iconst_4
    //   1247: istore_3
    //   1248: goto -546 -> 702
    //   1251: goto -471 -> 780
    //   1254: astore 20
    //   1256: iconst_5
    //   1257: istore_3
    //   1258: invokestatic 212	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1261: ifeq +31 -> 1292
    //   1264: ldc 8
    //   1266: iconst_2
    //   1267: new 214	java/lang/StringBuilder
    //   1270: dup
    //   1271: invokespecial 215	java/lang/StringBuilder:<init>	()V
    //   1274: ldc_w 289
    //   1277: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1280: aload_0
    //   1281: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1284: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1287: aload 20
    //   1289: invokestatic 287	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1292: aload 20
    //   1294: instanceof 291
    //   1297: istore 18
    //   1299: iload 18
    //   1301: ifeq +217 -> 1518
    //   1304: bipush 10
    //   1306: istore_3
    //   1307: aload_2
    //   1308: ifnull +9 -> 1317
    //   1311: aload_2
    //   1312: invokeinterface 247 1 0
    //   1317: aload 19
    //   1319: ifnull +8 -> 1327
    //   1322: aload 19
    //   1324: invokevirtual 250	java/io/OutputStream:close	()V
    //   1327: aload_2
    //   1328: astore 20
    //   1330: aload 19
    //   1332: astore 21
    //   1334: iload_3
    //   1335: istore 4
    //   1337: iload_3
    //   1338: ifeq -458 -> 880
    //   1341: aload_2
    //   1342: astore 20
    //   1344: aload 19
    //   1346: astore 21
    //   1348: iload_3
    //   1349: istore 4
    //   1351: aload_1
    //   1352: ifnull -472 -> 880
    //   1355: aload_2
    //   1356: astore 22
    //   1358: aload 19
    //   1360: astore 23
    //   1362: iload_3
    //   1363: istore 5
    //   1365: aload_1
    //   1366: invokevirtual 60	java/io/File:getParentFile	()Ljava/io/File;
    //   1369: astore 20
    //   1371: aload 20
    //   1373: ifnull +37 -> 1410
    //   1376: aload_2
    //   1377: astore 22
    //   1379: aload 19
    //   1381: astore 23
    //   1383: iload_3
    //   1384: istore 5
    //   1386: aload 20
    //   1388: invokevirtual 64	java/io/File:exists	()Z
    //   1391: ifne +19 -> 1410
    //   1394: aload_2
    //   1395: astore 22
    //   1397: aload 19
    //   1399: astore 23
    //   1401: iload_3
    //   1402: istore 5
    //   1404: aload 20
    //   1406: invokevirtual 67	java/io/File:mkdirs	()Z
    //   1409: pop
    //   1410: aload_2
    //   1411: astore 20
    //   1413: aload 19
    //   1415: astore 21
    //   1417: iload_3
    //   1418: istore 4
    //   1420: aload_2
    //   1421: astore 22
    //   1423: aload 19
    //   1425: astore 23
    //   1427: iload_3
    //   1428: istore 5
    //   1430: aload_1
    //   1431: invokevirtual 64	java/io/File:exists	()Z
    //   1434: ifeq -554 -> 880
    //   1437: aload_2
    //   1438: astore 22
    //   1440: aload 19
    //   1442: astore 23
    //   1444: iload_3
    //   1445: istore 5
    //   1447: aload_1
    //   1448: invokevirtual 146	java/io/File:delete	()Z
    //   1451: istore 18
    //   1453: aload_2
    //   1454: astore 22
    //   1456: aload 19
    //   1458: astore 23
    //   1460: iload_3
    //   1461: istore 5
    //   1463: ldc 8
    //   1465: iconst_1
    //   1466: new 214	java/lang/StringBuilder
    //   1469: dup
    //   1470: invokespecial 215	java/lang/StringBuilder:<init>	()V
    //   1473: ldc 252
    //   1475: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1478: iload 18
    //   1480: invokevirtual 255	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1483: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1486: invokestatic 257	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1489: aload_2
    //   1490: astore 20
    //   1492: aload 19
    //   1494: astore 21
    //   1496: iload_3
    //   1497: istore 4
    //   1499: goto -619 -> 880
    //   1502: astore_2
    //   1503: aload 22
    //   1505: astore 20
    //   1507: aload 23
    //   1509: astore 21
    //   1511: iload 5
    //   1513: istore 4
    //   1515: goto -635 -> 880
    //   1518: aload 20
    //   1520: instanceof 293
    //   1523: ifne +842 -> 2365
    //   1526: aload 20
    //   1528: instanceof 295
    //   1531: ifeq +6 -> 1537
    //   1534: goto +831 -> 2365
    //   1537: aload 20
    //   1539: instanceof 297
    //   1542: istore 18
    //   1544: iload 18
    //   1546: ifeq +9 -> 1555
    //   1549: bipush 11
    //   1551: istore_3
    //   1552: goto -245 -> 1307
    //   1555: iconst_4
    //   1556: istore_3
    //   1557: goto -250 -> 1307
    //   1560: astore 20
    //   1562: aload 22
    //   1564: astore 19
    //   1566: iload_3
    //   1567: istore 4
    //   1569: aload 20
    //   1571: astore 22
    //   1573: aload_2
    //   1574: astore 20
    //   1576: aload 19
    //   1578: astore 21
    //   1580: iload 4
    //   1582: istore_3
    //   1583: invokestatic 212	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1586: ifeq +41 -> 1627
    //   1589: aload_2
    //   1590: astore 20
    //   1592: aload 19
    //   1594: astore 21
    //   1596: iload 4
    //   1598: istore_3
    //   1599: ldc 8
    //   1601: iconst_2
    //   1602: new 214	java/lang/StringBuilder
    //   1605: dup
    //   1606: invokespecial 215	java/lang/StringBuilder:<init>	()V
    //   1609: ldc_w 299
    //   1612: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1615: aload_0
    //   1616: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1619: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1622: aload 22
    //   1624: invokestatic 287	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1627: iconst_5
    //   1628: istore_3
    //   1629: aload_2
    //   1630: ifnull +9 -> 1639
    //   1633: aload_2
    //   1634: invokeinterface 247 1 0
    //   1639: aload 19
    //   1641: ifnull +8 -> 1649
    //   1644: aload 19
    //   1646: invokevirtual 250	java/io/OutputStream:close	()V
    //   1649: aload_2
    //   1650: astore 20
    //   1652: aload 19
    //   1654: astore 21
    //   1656: iload_3
    //   1657: istore 4
    //   1659: aload_1
    //   1660: ifnull -780 -> 880
    //   1663: aload_2
    //   1664: astore 22
    //   1666: aload 19
    //   1668: astore 23
    //   1670: iload_3
    //   1671: istore 5
    //   1673: aload_1
    //   1674: invokevirtual 60	java/io/File:getParentFile	()Ljava/io/File;
    //   1677: astore 20
    //   1679: aload 20
    //   1681: ifnull +37 -> 1718
    //   1684: aload_2
    //   1685: astore 22
    //   1687: aload 19
    //   1689: astore 23
    //   1691: iload_3
    //   1692: istore 5
    //   1694: aload 20
    //   1696: invokevirtual 64	java/io/File:exists	()Z
    //   1699: ifne +19 -> 1718
    //   1702: aload_2
    //   1703: astore 22
    //   1705: aload 19
    //   1707: astore 23
    //   1709: iload_3
    //   1710: istore 5
    //   1712: aload 20
    //   1714: invokevirtual 67	java/io/File:mkdirs	()Z
    //   1717: pop
    //   1718: aload_2
    //   1719: astore 20
    //   1721: aload 19
    //   1723: astore 21
    //   1725: iload_3
    //   1726: istore 4
    //   1728: aload_2
    //   1729: astore 22
    //   1731: aload 19
    //   1733: astore 23
    //   1735: iload_3
    //   1736: istore 5
    //   1738: aload_1
    //   1739: invokevirtual 64	java/io/File:exists	()Z
    //   1742: ifeq -862 -> 880
    //   1745: aload_2
    //   1746: astore 22
    //   1748: aload 19
    //   1750: astore 23
    //   1752: iload_3
    //   1753: istore 5
    //   1755: aload_1
    //   1756: invokevirtual 146	java/io/File:delete	()Z
    //   1759: istore 18
    //   1761: aload_2
    //   1762: astore 22
    //   1764: aload 19
    //   1766: astore 23
    //   1768: iload_3
    //   1769: istore 5
    //   1771: ldc 8
    //   1773: iconst_1
    //   1774: new 214	java/lang/StringBuilder
    //   1777: dup
    //   1778: invokespecial 215	java/lang/StringBuilder:<init>	()V
    //   1781: ldc 252
    //   1783: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1786: iload 18
    //   1788: invokevirtual 255	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1791: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1794: invokestatic 257	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1797: aload_2
    //   1798: astore 20
    //   1800: aload 19
    //   1802: astore 21
    //   1804: iload_3
    //   1805: istore 4
    //   1807: goto -927 -> 880
    //   1810: astore 22
    //   1812: aload 23
    //   1814: astore 19
    //   1816: iload_3
    //   1817: istore 4
    //   1819: aload_2
    //   1820: astore 20
    //   1822: aload 19
    //   1824: astore 21
    //   1826: iload 4
    //   1828: istore_3
    //   1829: invokestatic 212	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1832: ifeq +41 -> 1873
    //   1835: aload_2
    //   1836: astore 20
    //   1838: aload 19
    //   1840: astore 21
    //   1842: iload 4
    //   1844: istore_3
    //   1845: ldc 8
    //   1847: iconst_2
    //   1848: new 214	java/lang/StringBuilder
    //   1851: dup
    //   1852: invokespecial 215	java/lang/StringBuilder:<init>	()V
    //   1855: ldc_w 299
    //   1858: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1861: aload_0
    //   1862: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1865: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1868: aload 22
    //   1870: invokestatic 287	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1873: iconst_5
    //   1874: istore_3
    //   1875: aload_2
    //   1876: ifnull +9 -> 1885
    //   1879: aload_2
    //   1880: invokeinterface 247 1 0
    //   1885: aload 19
    //   1887: ifnull +8 -> 1895
    //   1890: aload 19
    //   1892: invokevirtual 250	java/io/OutputStream:close	()V
    //   1895: aload_2
    //   1896: astore 20
    //   1898: aload 19
    //   1900: astore 21
    //   1902: iload_3
    //   1903: istore 4
    //   1905: aload_1
    //   1906: ifnull -1026 -> 880
    //   1909: aload_2
    //   1910: astore 22
    //   1912: aload 19
    //   1914: astore 23
    //   1916: iload_3
    //   1917: istore 5
    //   1919: aload_1
    //   1920: invokevirtual 60	java/io/File:getParentFile	()Ljava/io/File;
    //   1923: astore 20
    //   1925: aload 20
    //   1927: ifnull +37 -> 1964
    //   1930: aload_2
    //   1931: astore 22
    //   1933: aload 19
    //   1935: astore 23
    //   1937: iload_3
    //   1938: istore 5
    //   1940: aload 20
    //   1942: invokevirtual 64	java/io/File:exists	()Z
    //   1945: ifne +19 -> 1964
    //   1948: aload_2
    //   1949: astore 22
    //   1951: aload 19
    //   1953: astore 23
    //   1955: iload_3
    //   1956: istore 5
    //   1958: aload 20
    //   1960: invokevirtual 67	java/io/File:mkdirs	()Z
    //   1963: pop
    //   1964: aload_2
    //   1965: astore 20
    //   1967: aload 19
    //   1969: astore 21
    //   1971: iload_3
    //   1972: istore 4
    //   1974: aload_2
    //   1975: astore 22
    //   1977: aload 19
    //   1979: astore 23
    //   1981: iload_3
    //   1982: istore 5
    //   1984: aload_1
    //   1985: invokevirtual 64	java/io/File:exists	()Z
    //   1988: ifeq -1108 -> 880
    //   1991: aload_2
    //   1992: astore 22
    //   1994: aload 19
    //   1996: astore 23
    //   1998: iload_3
    //   1999: istore 5
    //   2001: aload_1
    //   2002: invokevirtual 146	java/io/File:delete	()Z
    //   2005: istore 18
    //   2007: aload_2
    //   2008: astore 22
    //   2010: aload 19
    //   2012: astore 23
    //   2014: iload_3
    //   2015: istore 5
    //   2017: ldc 8
    //   2019: iconst_1
    //   2020: new 214	java/lang/StringBuilder
    //   2023: dup
    //   2024: invokespecial 215	java/lang/StringBuilder:<init>	()V
    //   2027: ldc 252
    //   2029: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2032: iload 18
    //   2034: invokevirtual 255	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2037: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2040: invokestatic 257	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2043: aload_2
    //   2044: astore 20
    //   2046: aload 19
    //   2048: astore 21
    //   2050: iload_3
    //   2051: istore 4
    //   2053: goto -1173 -> 880
    //   2056: astore_0
    //   2057: aload 21
    //   2059: astore 19
    //   2061: aload_2
    //   2062: ifnull +9 -> 2071
    //   2065: aload_2
    //   2066: invokeinterface 247 1 0
    //   2071: aload 19
    //   2073: ifnull +8 -> 2081
    //   2076: aload 19
    //   2078: invokevirtual 250	java/io/OutputStream:close	()V
    //   2081: iload_3
    //   2082: ifeq +67 -> 2149
    //   2085: aload_1
    //   2086: ifnull +63 -> 2149
    //   2089: aload_1
    //   2090: invokevirtual 60	java/io/File:getParentFile	()Ljava/io/File;
    //   2093: astore_2
    //   2094: aload_2
    //   2095: ifnull +15 -> 2110
    //   2098: aload_2
    //   2099: invokevirtual 64	java/io/File:exists	()Z
    //   2102: ifne +8 -> 2110
    //   2105: aload_2
    //   2106: invokevirtual 67	java/io/File:mkdirs	()Z
    //   2109: pop
    //   2110: aload_1
    //   2111: invokevirtual 64	java/io/File:exists	()Z
    //   2114: ifeq +35 -> 2149
    //   2117: aload_1
    //   2118: invokevirtual 146	java/io/File:delete	()Z
    //   2121: istore 18
    //   2123: ldc 8
    //   2125: iconst_1
    //   2126: new 214	java/lang/StringBuilder
    //   2129: dup
    //   2130: invokespecial 215	java/lang/StringBuilder:<init>	()V
    //   2133: ldc 252
    //   2135: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2138: iload 18
    //   2140: invokevirtual 255	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2143: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2146: invokestatic 257	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2149: aload_0
    //   2150: athrow
    //   2151: astore_0
    //   2152: aload 30
    //   2154: monitorexit
    //   2155: aload_0
    //   2156: athrow
    //   2157: astore_2
    //   2158: goto -1156 -> 1002
    //   2161: astore_2
    //   2162: aload_2
    //   2163: invokevirtual 302	java/io/IOException:printStackTrace	()V
    //   2166: goto -95 -> 2071
    //   2169: astore_2
    //   2170: goto -89 -> 2081
    //   2173: astore 20
    //   2175: aload 20
    //   2177: invokevirtual 302	java/io/IOException:printStackTrace	()V
    //   2180: goto -863 -> 1317
    //   2183: astore 20
    //   2185: goto -858 -> 1327
    //   2188: astore 20
    //   2190: aload 20
    //   2192: invokevirtual 302	java/io/IOException:printStackTrace	()V
    //   2195: goto -556 -> 1639
    //   2198: astore 20
    //   2200: goto -551 -> 1649
    //   2203: astore 20
    //   2205: aload 20
    //   2207: invokevirtual 302	java/io/IOException:printStackTrace	()V
    //   2210: goto -325 -> 1885
    //   2213: astore 20
    //   2215: goto -320 -> 1895
    //   2218: astore 20
    //   2220: aload 20
    //   2222: invokevirtual 302	java/io/IOException:printStackTrace	()V
    //   2225: goto -1435 -> 790
    //   2228: astore 20
    //   2230: goto -1430 -> 800
    //   2233: astore 20
    //   2235: goto -1362 -> 873
    //   2238: astore_1
    //   2239: goto -90 -> 2149
    //   2242: astore_0
    //   2243: aload 24
    //   2245: astore 19
    //   2247: aload 21
    //   2249: astore_2
    //   2250: goto -189 -> 2061
    //   2253: astore_0
    //   2254: goto -193 -> 2061
    //   2257: astore_0
    //   2258: goto -197 -> 2061
    //   2261: astore_0
    //   2262: aload 21
    //   2264: astore 19
    //   2266: aload 20
    //   2268: astore_2
    //   2269: goto -208 -> 2061
    //   2272: astore 20
    //   2274: aload 25
    //   2276: astore_2
    //   2277: aload 22
    //   2279: astore 19
    //   2281: aload 20
    //   2283: astore 22
    //   2285: iload_3
    //   2286: istore 4
    //   2288: goto -469 -> 1819
    //   2291: astore 22
    //   2293: iload_3
    //   2294: istore 4
    //   2296: goto -477 -> 1819
    //   2299: astore 22
    //   2301: aload 26
    //   2303: astore_2
    //   2304: aload 23
    //   2306: astore 19
    //   2308: iload_3
    //   2309: istore 4
    //   2311: goto -738 -> 1573
    //   2314: astore 22
    //   2316: iload_3
    //   2317: istore 4
    //   2319: goto -746 -> 1573
    //   2322: astore 21
    //   2324: iconst_5
    //   2325: istore_3
    //   2326: aload 27
    //   2328: astore 19
    //   2330: aload 20
    //   2332: astore_2
    //   2333: aload 21
    //   2335: astore 20
    //   2337: goto -1079 -> 1258
    //   2340: astore 20
    //   2342: goto -1084 -> 1258
    //   2345: astore 29
    //   2347: goto -1176 -> 1171
    //   2350: astore 20
    //   2352: goto -1253 -> 1099
    //   2355: aload 21
    //   2357: astore 19
    //   2359: aload 20
    //   2361: astore_2
    //   2362: goto -2121 -> 241
    //   2365: iconst_2
    //   2366: istore_3
    //   2367: goto -1060 -> 1307
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2370	0	paramURL	java.net.URL
    //   0	2370	1	paramFile	java.io.File
    //   0	2370	2	paramNetworkInfo	android.net.NetworkInfo
    //   0	2370	3	paramInt	int
    //   81	2237	4	m	int
    //   1363	653	5	n	int
    //   15	1000	6	i1	int
    //   239	776	7	i2	int
    //   454	716	8	l1	long
    //   496	596	10	l2	long
    //   500	668	12	l3	long
    //   3	663	14	l4	long
    //   451	294	16	l5	long
    //   845	1294	18	bool	boolean
    //   28	846	19	localObject1	Object
    //   1089	1	19	localFileNotFoundException1	java.io.FileNotFoundException
    //   1097	1261	19	localObject2	Object
    //   56	1172	20	localObject3	Object
    //   1254	39	20	localIOException1	java.io.IOException
    //   1328	210	20	localObject4	Object
    //   1560	10	20	localException1	Exception
    //   1574	471	20	localObject5	Object
    //   2173	3	20	localIOException2	java.io.IOException
    //   2183	1	20	localIOException3	java.io.IOException
    //   2188	3	20	localIOException4	java.io.IOException
    //   2198	1	20	localIOException5	java.io.IOException
    //   2203	3	20	localIOException6	java.io.IOException
    //   2213	1	20	localIOException7	java.io.IOException
    //   2218	3	20	localIOException8	java.io.IOException
    //   2228	1	20	localIOException9	java.io.IOException
    //   2233	34	20	localException2	Exception
    //   2272	59	20	localThrowable1	java.lang.Throwable
    //   2335	1	20	localObject6	Object
    //   2340	1	20	localIOException10	java.io.IOException
    //   2350	10	20	localFileNotFoundException2	java.io.FileNotFoundException
    //   103	773	21	localObject7	Object
    //   1032	1	21	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   1109	1154	21	localObject8	Object
    //   2322	34	21	localIOException11	java.io.IOException
    //   292	1471	22	localObject9	Object
    //   1810	59	22	localThrowable2	java.lang.Throwable
    //   1910	374	22	localObject10	Object
    //   2291	1	22	localThrowable3	java.lang.Throwable
    //   2299	1	22	localException3	Exception
    //   2314	1	22	localException4	Exception
    //   299	2006	23	localObject11	Object
    //   285	1959	24	localObject12	Object
    //   288	1987	25	localNetworkInfo1	android.net.NetworkInfo
    //   295	2007	26	localNetworkInfo2	android.net.NetworkInfo
    //   306	2021	27	localObject13	Object
    //   67	980	28	localHttpGet	org.apache.http.client.methods.HttpGet
    //   329	73	29	localHttpResponse	org.apache.http.HttpResponse
    //   1161	81	29	localIOException12	java.io.IOException
    //   2345	1	29	localIOException13	java.io.IOException
    //   12	2141	30	localObject14	Object
    //   76	998	31	localBasicHttpParams	BasicHttpParams
    // Exception table:
    //   from	to	target	type
    //   24	30	1020	java/lang/Exception
    //   35	49	1020	java/lang/Exception
    //   58	69	1032	java/lang/IllegalArgumentException
    //   1034	1048	1051	java/lang/IllegalArgumentException
    //   514	522	1089	java/io/FileNotFoundException
    //   542	547	1089	java/io/FileNotFoundException
    //   567	573	1089	java/io/FileNotFoundException
    //   593	601	1089	java/io/FileNotFoundException
    //   621	627	1089	java/io/FileNotFoundException
    //   647	696	1089	java/io/FileNotFoundException
    //   514	522	1161	java/io/IOException
    //   542	547	1161	java/io/IOException
    //   567	573	1161	java/io/IOException
    //   593	601	1161	java/io/IOException
    //   621	627	1161	java/io/IOException
    //   647	696	1161	java/io/IOException
    //   1111	1156	1254	java/io/IOException
    //   1365	1371	1502	java/lang/Exception
    //   1386	1394	1502	java/lang/Exception
    //   1404	1410	1502	java/lang/Exception
    //   1430	1437	1502	java/lang/Exception
    //   1447	1453	1502	java/lang/Exception
    //   1463	1489	1502	java/lang/Exception
    //   1673	1679	1502	java/lang/Exception
    //   1694	1702	1502	java/lang/Exception
    //   1712	1718	1502	java/lang/Exception
    //   1738	1745	1502	java/lang/Exception
    //   1755	1761	1502	java/lang/Exception
    //   1771	1797	1502	java/lang/Exception
    //   1919	1925	1502	java/lang/Exception
    //   1940	1948	1502	java/lang/Exception
    //   1958	1964	1502	java/lang/Exception
    //   1984	1991	1502	java/lang/Exception
    //   2001	2007	1502	java/lang/Exception
    //   2017	2043	1502	java/lang/Exception
    //   514	522	1560	java/lang/Exception
    //   542	547	1560	java/lang/Exception
    //   567	573	1560	java/lang/Exception
    //   593	601	1560	java/lang/Exception
    //   621	627	1560	java/lang/Exception
    //   647	696	1560	java/lang/Exception
    //   1111	1156	1560	java/lang/Exception
    //   514	522	1810	java/lang/Throwable
    //   542	547	1810	java/lang/Throwable
    //   567	573	1810	java/lang/Throwable
    //   593	601	1810	java/lang/Throwable
    //   621	627	1810	java/lang/Throwable
    //   647	696	1810	java/lang/Throwable
    //   1111	1156	1810	java/lang/Throwable
    //   514	522	2056	finally
    //   542	547	2056	finally
    //   567	573	2056	finally
    //   593	601	2056	finally
    //   621	627	2056	finally
    //   647	696	2056	finally
    //   1111	1156	2056	finally
    //   994	1002	2151	finally
    //   1002	1005	2151	finally
    //   2152	2155	2151	finally
    //   994	1002	2157	java/lang/InterruptedException
    //   2065	2071	2161	java/io/IOException
    //   2076	2081	2169	java/io/IOException
    //   1311	1317	2173	java/io/IOException
    //   1322	1327	2183	java/io/IOException
    //   1633	1639	2188	java/io/IOException
    //   1644	1649	2198	java/io/IOException
    //   1879	1885	2203	java/io/IOException
    //   1890	1895	2213	java/io/IOException
    //   784	790	2218	java/io/IOException
    //   795	800	2228	java/io/IOException
    //   809	815	2233	java/lang/Exception
    //   820	834	2233	java/lang/Exception
    //   834	873	2233	java/lang/Exception
    //   2089	2094	2238	java/lang/Exception
    //   2098	2110	2238	java/lang/Exception
    //   2110	2149	2238	java/lang/Exception
    //   308	331	2242	finally
    //   359	373	2242	finally
    //   401	409	2242	finally
    //   445	453	2242	finally
    //   477	494	2242	finally
    //   1199	1205	2242	finally
    //   1233	1246	2242	finally
    //   723	776	2253	finally
    //   1258	1292	2257	finally
    //   1292	1299	2257	finally
    //   1518	1534	2257	finally
    //   1537	1544	2257	finally
    //   1583	1589	2261	finally
    //   1599	1627	2261	finally
    //   1829	1835	2261	finally
    //   1845	1873	2261	finally
    //   308	331	2272	java/lang/Throwable
    //   359	373	2272	java/lang/Throwable
    //   401	409	2272	java/lang/Throwable
    //   445	453	2272	java/lang/Throwable
    //   477	494	2272	java/lang/Throwable
    //   1199	1205	2272	java/lang/Throwable
    //   1233	1246	2272	java/lang/Throwable
    //   723	776	2291	java/lang/Throwable
    //   308	331	2299	java/lang/Exception
    //   359	373	2299	java/lang/Exception
    //   401	409	2299	java/lang/Exception
    //   445	453	2299	java/lang/Exception
    //   477	494	2299	java/lang/Exception
    //   1199	1205	2299	java/lang/Exception
    //   1233	1246	2299	java/lang/Exception
    //   723	776	2314	java/lang/Exception
    //   308	331	2322	java/io/IOException
    //   359	373	2322	java/io/IOException
    //   401	409	2322	java/io/IOException
    //   445	453	2322	java/io/IOException
    //   1199	1205	2322	java/io/IOException
    //   1233	1246	2322	java/io/IOException
    //   723	776	2340	java/io/IOException
    //   477	494	2345	java/io/IOException
    //   477	494	2350	java/io/FileNotFoundException
  }
  
  public static String a(String paramString)
  {
    return paramString.replaceAll("\\{", "%7B").replaceAll("\\}", "%7D").replaceAll("\\|", "%7C");
  }
  
  private static HttpClient a()
  {
    Object localObject = new BasicHttpParams();
    HttpProtocolParams.setVersion((HttpParams)localObject, HttpVersion.HTTP_1_1);
    HttpProtocolParams.setContentCharset((HttpParams)localObject, "ISO-8859-1");
    HttpProtocolParams.setUseExpectContinue((HttpParams)localObject, true);
    SchemeRegistry localSchemeRegistry = new SchemeRegistry();
    localSchemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
    try
    {
      if (Build.VERSION.SDK_INT >= 23)
      {
        SSLSocketFactory localSSLSocketFactory = SSLSocketFactory.getSocketFactory();
        localSSLSocketFactory.setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
        localSchemeRegistry.register(new Scheme("https", localSSLSocketFactory, 443));
      }
      for (;;)
      {
        localObject = new DefaultHttpClient(new ThreadSafeClientConnManager((HttpParams)localObject, localSchemeRegistry), (HttpParams)localObject);
        ((DefaultHttpClient)localObject).setHttpRequestRetryHandler(new DefaultHttpRequestRetryHandler());
        return localObject;
        localSchemeRegistry.register(new Scheme("https", new f(e.class.getSimpleName()), 443));
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("HttpDownloadUtil", 2, "createHttpClient():Can't support https on this devices.", localException);
        }
      }
    }
  }
  
  /* Error */
  public static boolean a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: invokestatic 418	com/tencent/mobileqq/msf/sdk/AppNetConnInfo:getRecentNetworkInfo	()Landroid/net/NetworkInfo;
    //   3: astore_3
    //   4: new 56	java/io/File
    //   7: dup
    //   8: new 214	java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial 215	java/lang/StringBuilder:<init>	()V
    //   15: aload_1
    //   16: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: invokestatic 54	java/lang/System:currentTimeMillis	()J
    //   22: invokevirtual 224	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   25: ldc_w 420
    //   28: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: invokespecial 421	java/io/File:<init>	(Ljava/lang/String;)V
    //   37: astore 4
    //   39: new 69	java/net/URL
    //   42: dup
    //   43: aload_0
    //   44: invokespecial 422	java/net/URL:<init>	(Ljava/lang/String;)V
    //   47: astore_0
    //   48: aload_0
    //   49: aload 4
    //   51: aload_3
    //   52: iconst_2
    //   53: invokestatic 424	com/tencent/mobileqq/msf/core/net/utils/e:a	(Ljava/net/URL;Ljava/io/File;Landroid/net/NetworkInfo;I)I
    //   56: ifne +32 -> 88
    //   59: iconst_1
    //   60: istore_2
    //   61: iload_2
    //   62: ifeq +17 -> 79
    //   65: aload 4
    //   67: new 56	java/io/File
    //   70: dup
    //   71: aload_1
    //   72: invokespecial 421	java/io/File:<init>	(Ljava/lang/String;)V
    //   75: invokevirtual 428	java/io/File:renameTo	(Ljava/io/File;)Z
    //   78: pop
    //   79: iload_2
    //   80: ireturn
    //   81: astore_0
    //   82: aload_0
    //   83: invokevirtual 429	java/net/MalformedURLException:printStackTrace	()V
    //   86: iconst_0
    //   87: ireturn
    //   88: iconst_0
    //   89: istore_2
    //   90: goto -29 -> 61
    //   93: astore_0
    //   94: aload_0
    //   95: invokevirtual 430	java/lang/Exception:printStackTrace	()V
    //   98: iconst_0
    //   99: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	paramString1	String
    //   0	100	1	paramString2	String
    //   60	30	2	bool	boolean
    //   3	49	3	localNetworkInfo	android.net.NetworkInfo
    //   37	29	4	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   39	48	81	java/net/MalformedURLException
    //   65	79	93	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.utils.e
 * JD-Core Version:    0.7.0.1
 */