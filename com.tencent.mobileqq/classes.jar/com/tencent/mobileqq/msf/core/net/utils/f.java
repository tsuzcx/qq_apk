package com.tencent.mobileqq.msf.core.net.utils;

import android.net.NetworkInfo;
import android.os.Build.VERSION;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
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

public class f
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
  private static int a(URL paramURL, File paramFile, NetworkInfo paramNetworkInfo, int paramInt)
  {
    // Byte code:
    //   0: invokestatic 54	java/lang/System:currentTimeMillis	()J
    //   3: lstore 11
    //   5: new 4	java/lang/Object
    //   8: dup
    //   9: invokespecial 34	java/lang/Object:<init>	()V
    //   12: astore 25
    //   14: iload_3
    //   15: ifge +8 -> 23
    //   18: iconst_2
    //   19: istore_3
    //   20: goto +3 -> 23
    //   23: aload_1
    //   24: invokevirtual 60	java/io/File:getParentFile	()Ljava/io/File;
    //   27: astore 16
    //   29: aload 16
    //   31: ifnull +17 -> 48
    //   34: aload 16
    //   36: invokevirtual 64	java/io/File:exists	()Z
    //   39: ifne +9 -> 48
    //   42: aload 16
    //   44: invokevirtual 67	java/io/File:mkdirs	()Z
    //   47: pop
    //   48: aload_0
    //   49: invokevirtual 73	java/net/URL:toString	()Ljava/lang/String;
    //   52: astore 16
    //   54: new 75	org/apache/http/client/methods/HttpGet
    //   57: dup
    //   58: aload 16
    //   60: invokespecial 78	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   63: astore 17
    //   65: goto +17 -> 82
    //   68: new 75	org/apache/http/client/methods/HttpGet
    //   71: dup
    //   72: aload 16
    //   74: invokestatic 81	com/tencent/mobileqq/msf/core/net/utils/f:a	(Ljava/lang/String;)Ljava/lang/String;
    //   77: invokespecial 78	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   80: astore 17
    //   82: new 83	org/apache/http/params/BasicHttpParams
    //   85: dup
    //   86: invokespecial 84	org/apache/http/params/BasicHttpParams:<init>	()V
    //   89: astore 22
    //   91: sipush 20000
    //   94: istore 5
    //   96: aload_2
    //   97: ifnull +121 -> 218
    //   100: invokestatic 89	android/net/Proxy:getDefaultHost	()Ljava/lang/String;
    //   103: astore 16
    //   105: invokestatic 93	android/net/Proxy:getDefaultPort	()I
    //   108: istore 4
    //   110: aload_2
    //   111: invokevirtual 98	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   114: astore 18
    //   116: aload_2
    //   117: invokestatic 104	com/tencent/mobileqq/msf/core/NetConnInfoCenter:isMobileNetworkInfo	(Landroid/net/NetworkInfo;)Z
    //   120: ifeq +49 -> 169
    //   123: aload 18
    //   125: ifnull +13 -> 138
    //   128: aload 18
    //   130: ldc 106
    //   132: invokevirtual 112	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   135: ifeq +34 -> 169
    //   138: aload 16
    //   140: ifnull +29 -> 169
    //   143: iload 4
    //   145: ifle +24 -> 169
    //   148: aload 22
    //   150: ldc 114
    //   152: new 116	org/apache/http/HttpHost
    //   155: dup
    //   156: aload 16
    //   158: iload 4
    //   160: invokespecial 119	org/apache/http/HttpHost:<init>	(Ljava/lang/String;I)V
    //   163: invokeinterface 125 3 0
    //   168: pop
    //   169: aload_2
    //   170: invokestatic 104	com/tencent/mobileqq/msf/core/NetConnInfoCenter:isMobileNetworkInfo	(Landroid/net/NetworkInfo;)Z
    //   173: ifeq +19 -> 192
    //   176: aload 22
    //   178: ldc 127
    //   180: sipush 2048
    //   183: invokeinterface 131 3 0
    //   188: pop
    //   189: goto +29 -> 218
    //   192: sipush 10000
    //   195: istore 5
    //   197: sipush 30000
    //   200: istore 4
    //   202: aload 22
    //   204: ldc 127
    //   206: sipush 4096
    //   209: invokeinterface 131 3 0
    //   214: pop
    //   215: goto +7 -> 222
    //   218: ldc 132
    //   220: istore 4
    //   222: aload 22
    //   224: ldc 134
    //   226: iload 5
    //   228: invokestatic 140	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   231: invokeinterface 125 3 0
    //   236: pop
    //   237: aload 22
    //   239: ldc 142
    //   241: iload 4
    //   243: invokestatic 140	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   246: invokeinterface 125 3 0
    //   251: pop
    //   252: aload 17
    //   254: aload 22
    //   256: invokevirtual 146	org/apache/http/client/methods/HttpGet:setParams	(Lorg/apache/http/params/HttpParams;)V
    //   259: aload_1
    //   260: ifnull +15 -> 275
    //   263: aload_1
    //   264: invokevirtual 64	java/io/File:exists	()Z
    //   267: ifeq +8 -> 275
    //   270: aload_1
    //   271: invokevirtual 149	java/io/File:delete	()Z
    //   274: pop
    //   275: aconst_null
    //   276: astore 16
    //   278: aload 16
    //   280: astore 18
    //   282: iconst_m1
    //   283: istore 8
    //   285: aload 17
    //   287: astore 23
    //   289: iload_3
    //   290: istore 7
    //   292: iload 8
    //   294: ifne +35 -> 329
    //   297: aload 22
    //   299: ldc 114
    //   301: new 116	org/apache/http/HttpHost
    //   304: dup
    //   305: aload_0
    //   306: invokevirtual 152	java/net/URL:getHost	()Ljava/lang/String;
    //   309: aload_0
    //   310: invokevirtual 155	java/net/URL:getPort	()I
    //   313: invokespecial 119	org/apache/http/HttpHost:<init>	(Ljava/lang/String;I)V
    //   316: invokeinterface 125 3 0
    //   321: pop
    //   322: aload 23
    //   324: aload 22
    //   326: invokevirtual 146	org/apache/http/client/methods/HttpGet:setParams	(Lorg/apache/http/params/HttpParams;)V
    //   329: aload 16
    //   331: astore 19
    //   333: aload 18
    //   335: astore 20
    //   337: invokestatic 158	com/tencent/mobileqq/msf/core/net/utils/f:a	()Lorg/apache/http/client/HttpClient;
    //   340: new 116	org/apache/http/HttpHost
    //   343: dup
    //   344: aload_0
    //   345: invokevirtual 152	java/net/URL:getHost	()Ljava/lang/String;
    //   348: invokespecial 159	org/apache/http/HttpHost:<init>	(Ljava/lang/String;)V
    //   351: aload 23
    //   353: invokeinterface 165 3 0
    //   358: astore_2
    //   359: aload 16
    //   361: astore 19
    //   363: aload 18
    //   365: astore 20
    //   367: aload_2
    //   368: invokeinterface 171 1 0
    //   373: invokeinterface 176 1 0
    //   378: istore 4
    //   380: aload 16
    //   382: astore 19
    //   384: aload 18
    //   386: astore 20
    //   388: aload_2
    //   389: invokeinterface 180 1 0
    //   394: astore_2
    //   395: sipush 200
    //   398: iload 4
    //   400: if_icmpne +770 -> 1170
    //   403: aload 16
    //   405: astore 19
    //   407: aload_2
    //   408: astore 20
    //   410: aload_2
    //   411: invokeinterface 185 1 0
    //   416: lstore 13
    //   418: aload 16
    //   420: astore 19
    //   422: aload_2
    //   423: astore 20
    //   425: new 187	java/io/BufferedOutputStream
    //   428: dup
    //   429: new 189	java/io/FileOutputStream
    //   432: dup
    //   433: aload_1
    //   434: invokespecial 192	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   437: invokespecial 195	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   440: astore 17
    //   442: aload_2
    //   443: aload 17
    //   445: invokeinterface 198 2 0
    //   450: aload 17
    //   452: invokevirtual 203	java/io/OutputStream:flush	()V
    //   455: aload_1
    //   456: invokevirtual 206	java/io/File:length	()J
    //   459: lstore 9
    //   461: aload_1
    //   462: invokestatic 54	java/lang/System:currentTimeMillis	()J
    //   465: invokevirtual 210	java/io/File:setLastModified	(J)Z
    //   468: pop
    //   469: invokestatic 215	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   472: ifeq +74 -> 546
    //   475: new 217	java/lang/StringBuilder
    //   478: dup
    //   479: invokespecial 218	java/lang/StringBuilder:<init>	()V
    //   482: astore 16
    //   484: aload 16
    //   486: ldc 220
    //   488: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   491: pop
    //   492: aload 16
    //   494: invokestatic 54	java/lang/System:currentTimeMillis	()J
    //   497: lload 11
    //   499: lsub
    //   500: invokevirtual 227	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   503: pop
    //   504: aload 16
    //   506: ldc 229
    //   508: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   511: pop
    //   512: aload 16
    //   514: lload 9
    //   516: invokevirtual 227	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   519: pop
    //   520: aload 16
    //   522: ldc 231
    //   524: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   527: pop
    //   528: aload 16
    //   530: aload_0
    //   531: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   534: pop
    //   535: ldc 8
    //   537: iconst_2
    //   538: aload 16
    //   540: invokevirtual 235	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   543: invokestatic 238	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   546: aload 17
    //   548: astore 16
    //   550: iconst_0
    //   551: istore_3
    //   552: goto +354 -> 906
    //   555: astore 16
    //   557: goto +49 -> 606
    //   560: astore 16
    //   562: goto +61 -> 623
    //   565: astore 24
    //   567: aload 17
    //   569: astore 16
    //   571: goto +100 -> 671
    //   574: aload 17
    //   576: astore 16
    //   578: goto +153 -> 731
    //   581: astore 16
    //   583: goto +23 -> 606
    //   586: astore 16
    //   588: goto +35 -> 623
    //   591: astore 16
    //   593: goto +47 -> 640
    //   596: astore_0
    //   597: aload 17
    //   599: astore 19
    //   601: goto +875 -> 1476
    //   604: astore 16
    //   606: aload 17
    //   608: astore 18
    //   610: aload 16
    //   612: astore 17
    //   614: aload 18
    //   616: astore 16
    //   618: goto +873 -> 1491
    //   621: astore 16
    //   623: aload 17
    //   625: astore 18
    //   627: aload 16
    //   629: astore 17
    //   631: aload 18
    //   633: astore 16
    //   635: goto +1146 -> 1781
    //   638: astore 16
    //   640: aload 17
    //   642: astore 18
    //   644: aload 16
    //   646: astore 17
    //   648: aload 18
    //   650: astore 16
    //   652: goto +12 -> 664
    //   655: aload 17
    //   657: astore 16
    //   659: goto +2287 -> 2946
    //   662: astore 17
    //   664: lconst_0
    //   665: lstore 9
    //   667: aload 17
    //   669: astore 24
    //   671: aload 16
    //   673: astore 18
    //   675: aload 16
    //   677: astore 21
    //   679: aload 16
    //   681: astore 17
    //   683: aload 16
    //   685: astore 19
    //   687: aload_2
    //   688: astore 20
    //   690: invokestatic 215	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   693: ifeq +2248 -> 2941
    //   696: aload 16
    //   698: astore 18
    //   700: aload 16
    //   702: astore 21
    //   704: aload 16
    //   706: astore 17
    //   708: aload 16
    //   710: astore 19
    //   712: aload_2
    //   713: astore 20
    //   715: ldc 8
    //   717: iconst_2
    //   718: aload 24
    //   720: invokevirtual 241	java/io/IOException:getMessage	()Ljava/lang/String;
    //   723: aload 24
    //   725: invokestatic 244	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   728: goto +2213 -> 2941
    //   731: aload 16
    //   733: astore 18
    //   735: aload 16
    //   737: astore 21
    //   739: aload 16
    //   741: astore 17
    //   743: aload 16
    //   745: astore 19
    //   747: aload_2
    //   748: astore 20
    //   750: new 217	java/lang/StringBuilder
    //   753: dup
    //   754: invokespecial 218	java/lang/StringBuilder:<init>	()V
    //   757: astore 24
    //   759: aload 16
    //   761: astore 18
    //   763: aload 16
    //   765: astore 21
    //   767: aload 16
    //   769: astore 17
    //   771: aload 16
    //   773: astore 19
    //   775: aload_2
    //   776: astore 20
    //   778: aload 24
    //   780: ldc 246
    //   782: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   785: pop
    //   786: aload 16
    //   788: astore 18
    //   790: aload 16
    //   792: astore 21
    //   794: aload 16
    //   796: astore 17
    //   798: aload 16
    //   800: astore 19
    //   802: aload_2
    //   803: astore 20
    //   805: aload 24
    //   807: aload_1
    //   808: invokevirtual 64	java/io/File:exists	()Z
    //   811: invokevirtual 249	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   814: pop
    //   815: aload 16
    //   817: astore 18
    //   819: aload 16
    //   821: astore 21
    //   823: aload 16
    //   825: astore 17
    //   827: aload 16
    //   829: astore 19
    //   831: aload_2
    //   832: astore 20
    //   834: aload 24
    //   836: ldc 251
    //   838: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   841: pop
    //   842: aload 16
    //   844: astore 18
    //   846: aload 16
    //   848: astore 21
    //   850: aload 16
    //   852: astore 17
    //   854: aload 16
    //   856: astore 19
    //   858: aload_2
    //   859: astore 20
    //   861: aload 24
    //   863: aload_1
    //   864: invokevirtual 60	java/io/File:getParentFile	()Ljava/io/File;
    //   867: invokevirtual 64	java/io/File:exists	()Z
    //   870: invokevirtual 249	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   873: pop
    //   874: aload 16
    //   876: astore 18
    //   878: aload 16
    //   880: astore 21
    //   882: aload 16
    //   884: astore 17
    //   886: aload 16
    //   888: astore 19
    //   890: aload_2
    //   891: astore 20
    //   893: ldc 8
    //   895: iconst_1
    //   896: aload 24
    //   898: invokevirtual 235	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   901: invokestatic 253	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   904: iconst_5
    //   905: istore_3
    //   906: iload_3
    //   907: istore 4
    //   909: aload 16
    //   911: astore 19
    //   913: lload 13
    //   915: lconst_0
    //   916: lcmp
    //   917: ifle +257 -> 1174
    //   920: iload_3
    //   921: istore 4
    //   923: aload 16
    //   925: astore 19
    //   927: lload 9
    //   929: lload 13
    //   931: lcmp
    //   932: ifge +242 -> 1174
    //   935: iload_3
    //   936: istore 4
    //   938: aload 16
    //   940: astore 17
    //   942: aload_2
    //   943: astore 18
    //   945: invokestatic 215	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   948: ifeq +154 -> 1102
    //   951: iload_3
    //   952: istore 4
    //   954: aload 16
    //   956: astore 17
    //   958: aload_2
    //   959: astore 18
    //   961: new 217	java/lang/StringBuilder
    //   964: dup
    //   965: invokespecial 218	java/lang/StringBuilder:<init>	()V
    //   968: astore 19
    //   970: iload_3
    //   971: istore 4
    //   973: aload 16
    //   975: astore 17
    //   977: aload_2
    //   978: astore 18
    //   980: aload 19
    //   982: ldc 255
    //   984: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   987: pop
    //   988: iload_3
    //   989: istore 4
    //   991: aload 16
    //   993: astore 17
    //   995: aload_2
    //   996: astore 18
    //   998: aload 19
    //   1000: lload 13
    //   1002: invokevirtual 227	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1005: pop
    //   1006: iload_3
    //   1007: istore 4
    //   1009: aload 16
    //   1011: astore 17
    //   1013: aload_2
    //   1014: astore 18
    //   1016: aload 19
    //   1018: ldc_w 257
    //   1021: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1024: pop
    //   1025: iload_3
    //   1026: istore 4
    //   1028: aload 16
    //   1030: astore 17
    //   1032: aload_2
    //   1033: astore 18
    //   1035: aload 19
    //   1037: aload_1
    //   1038: invokevirtual 206	java/io/File:length	()J
    //   1041: invokevirtual 227	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1044: pop
    //   1045: iload_3
    //   1046: istore 4
    //   1048: aload 16
    //   1050: astore 17
    //   1052: aload_2
    //   1053: astore 18
    //   1055: aload 19
    //   1057: ldc_w 259
    //   1060: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1063: pop
    //   1064: iload_3
    //   1065: istore 4
    //   1067: aload 16
    //   1069: astore 17
    //   1071: aload_2
    //   1072: astore 18
    //   1074: aload 19
    //   1076: aload_0
    //   1077: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1080: pop
    //   1081: iload_3
    //   1082: istore 4
    //   1084: aload 16
    //   1086: astore 17
    //   1088: aload_2
    //   1089: astore 18
    //   1091: ldc 8
    //   1093: iconst_2
    //   1094: aload 19
    //   1096: invokevirtual 235	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1099: invokestatic 262	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1102: bipush 8
    //   1104: istore 4
    //   1106: aload 16
    //   1108: astore 19
    //   1110: goto +64 -> 1174
    //   1113: astore 19
    //   1115: goto +382 -> 1497
    //   1118: astore 19
    //   1120: goto +667 -> 1787
    //   1123: astore 19
    //   1125: goto +981 -> 2106
    //   1128: astore 17
    //   1130: aload 18
    //   1132: astore 16
    //   1134: goto +357 -> 1491
    //   1137: astore 17
    //   1139: aload 21
    //   1141: astore 16
    //   1143: goto +638 -> 1781
    //   1146: astore 18
    //   1148: aload 17
    //   1150: astore 16
    //   1152: goto +948 -> 2100
    //   1155: astore 17
    //   1157: goto +334 -> 1491
    //   1160: astore 17
    //   1162: goto +619 -> 1781
    //   1165: astore 18
    //   1167: goto +933 -> 2100
    //   1170: aload 16
    //   1172: astore 19
    //   1174: aload_2
    //   1175: ifnull +19 -> 1194
    //   1178: aload_2
    //   1179: invokeinterface 265 1 0
    //   1184: goto +10 -> 1194
    //   1187: astore 16
    //   1189: aload 16
    //   1191: invokevirtual 268	java/io/IOException:printStackTrace	()V
    //   1194: aload 19
    //   1196: ifnull +11 -> 1207
    //   1199: aload 19
    //   1201: invokevirtual 271	java/io/OutputStream:close	()V
    //   1204: goto +3 -> 1207
    //   1207: iload 4
    //   1209: istore 5
    //   1211: aload 19
    //   1213: astore 17
    //   1215: aload_2
    //   1216: astore 18
    //   1218: iload 4
    //   1220: ifeq +1313 -> 2533
    //   1223: iload 4
    //   1225: istore 5
    //   1227: aload 19
    //   1229: astore 17
    //   1231: aload_2
    //   1232: astore 18
    //   1234: aload_1
    //   1235: ifnull +1298 -> 2533
    //   1238: iload 4
    //   1240: istore 6
    //   1242: aload 19
    //   1244: astore 20
    //   1246: aload_2
    //   1247: astore 21
    //   1249: aload_1
    //   1250: invokevirtual 60	java/io/File:getParentFile	()Ljava/io/File;
    //   1253: astore 16
    //   1255: aload 16
    //   1257: ifnull +39 -> 1296
    //   1260: iload 4
    //   1262: istore 6
    //   1264: aload 19
    //   1266: astore 20
    //   1268: aload_2
    //   1269: astore 21
    //   1271: aload 16
    //   1273: invokevirtual 64	java/io/File:exists	()Z
    //   1276: ifne +20 -> 1296
    //   1279: iload 4
    //   1281: istore 6
    //   1283: aload 19
    //   1285: astore 20
    //   1287: aload_2
    //   1288: astore 21
    //   1290: aload 16
    //   1292: invokevirtual 67	java/io/File:mkdirs	()Z
    //   1295: pop
    //   1296: iload 4
    //   1298: istore 5
    //   1300: aload 19
    //   1302: astore 17
    //   1304: aload_2
    //   1305: astore 18
    //   1307: iload 4
    //   1309: istore 6
    //   1311: aload 19
    //   1313: astore 20
    //   1315: aload_2
    //   1316: astore 21
    //   1318: aload_1
    //   1319: invokevirtual 64	java/io/File:exists	()Z
    //   1322: ifeq +1211 -> 2533
    //   1325: iload 4
    //   1327: istore 6
    //   1329: aload 19
    //   1331: astore 20
    //   1333: aload_2
    //   1334: astore 21
    //   1336: aload_1
    //   1337: invokevirtual 149	java/io/File:delete	()Z
    //   1340: istore 15
    //   1342: iload 4
    //   1344: istore 6
    //   1346: aload 19
    //   1348: astore 20
    //   1350: aload_2
    //   1351: astore 21
    //   1353: new 217	java/lang/StringBuilder
    //   1356: dup
    //   1357: invokespecial 218	java/lang/StringBuilder:<init>	()V
    //   1360: astore 16
    //   1362: iload 4
    //   1364: istore 6
    //   1366: aload 19
    //   1368: astore 20
    //   1370: aload_2
    //   1371: astore 21
    //   1373: aload 16
    //   1375: ldc_w 273
    //   1378: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1381: pop
    //   1382: iload 4
    //   1384: istore 6
    //   1386: aload 19
    //   1388: astore 20
    //   1390: aload_2
    //   1391: astore 21
    //   1393: aload 16
    //   1395: iload 15
    //   1397: invokevirtual 249	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1400: pop
    //   1401: iload 4
    //   1403: istore 6
    //   1405: aload 19
    //   1407: astore 20
    //   1409: aload_2
    //   1410: astore 21
    //   1412: aload 16
    //   1414: invokevirtual 235	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1417: astore 17
    //   1419: aload 19
    //   1421: astore 16
    //   1423: iload 4
    //   1425: istore_3
    //   1426: iload_3
    //   1427: istore 6
    //   1429: aload 16
    //   1431: astore 20
    //   1433: aload_2
    //   1434: astore 21
    //   1436: ldc 8
    //   1438: iconst_1
    //   1439: aload 17
    //   1441: invokestatic 253	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1444: iload_3
    //   1445: istore 5
    //   1447: aload 16
    //   1449: astore 17
    //   1451: aload_2
    //   1452: astore 18
    //   1454: goto +1079 -> 2533
    //   1457: iload 6
    //   1459: istore 5
    //   1461: aload 20
    //   1463: astore 17
    //   1465: aload 21
    //   1467: astore 18
    //   1469: goto +1064 -> 2533
    //   1472: astore_0
    //   1473: aload 20
    //   1475: astore_2
    //   1476: iconst_5
    //   1477: istore 4
    //   1479: aload 19
    //   1481: astore 17
    //   1483: goto +1245 -> 2728
    //   1486: astore 17
    //   1488: aload 18
    //   1490: astore_2
    //   1491: iconst_5
    //   1492: istore_3
    //   1493: aload 17
    //   1495: astore 19
    //   1497: iload_3
    //   1498: istore 4
    //   1500: aload 16
    //   1502: astore 17
    //   1504: aload_2
    //   1505: astore 18
    //   1507: invokestatic 215	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1510: ifeq +81 -> 1591
    //   1513: iload_3
    //   1514: istore 4
    //   1516: aload 16
    //   1518: astore 17
    //   1520: aload_2
    //   1521: astore 18
    //   1523: new 217	java/lang/StringBuilder
    //   1526: dup
    //   1527: invokespecial 218	java/lang/StringBuilder:<init>	()V
    //   1530: astore 20
    //   1532: iload_3
    //   1533: istore 4
    //   1535: aload 16
    //   1537: astore 17
    //   1539: aload_2
    //   1540: astore 18
    //   1542: aload 20
    //   1544: ldc_w 275
    //   1547: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1550: pop
    //   1551: iload_3
    //   1552: istore 4
    //   1554: aload 16
    //   1556: astore 17
    //   1558: aload_2
    //   1559: astore 18
    //   1561: aload 20
    //   1563: aload_0
    //   1564: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1567: pop
    //   1568: iload_3
    //   1569: istore 4
    //   1571: aload 16
    //   1573: astore 17
    //   1575: aload_2
    //   1576: astore 18
    //   1578: ldc 8
    //   1580: iconst_2
    //   1581: aload 20
    //   1583: invokevirtual 235	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1586: aload 19
    //   1588: invokestatic 244	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1591: aload_2
    //   1592: ifnull +19 -> 1611
    //   1595: aload_2
    //   1596: invokeinterface 265 1 0
    //   1601: goto +10 -> 1611
    //   1604: astore 17
    //   1606: aload 17
    //   1608: invokevirtual 268	java/io/IOException:printStackTrace	()V
    //   1611: aload 16
    //   1613: ifnull +8 -> 1621
    //   1616: aload 16
    //   1618: invokevirtual 271	java/io/OutputStream:close	()V
    //   1621: aload 16
    //   1623: astore 17
    //   1625: aload_2
    //   1626: astore 18
    //   1628: aload_1
    //   1629: ifnull +456 -> 2085
    //   1632: aload 16
    //   1634: astore 19
    //   1636: aload_2
    //   1637: astore 20
    //   1639: aload_1
    //   1640: invokevirtual 60	java/io/File:getParentFile	()Ljava/io/File;
    //   1643: astore 17
    //   1645: aload 17
    //   1647: ifnull +31 -> 1678
    //   1650: aload 16
    //   1652: astore 19
    //   1654: aload_2
    //   1655: astore 20
    //   1657: aload 17
    //   1659: invokevirtual 64	java/io/File:exists	()Z
    //   1662: ifne +16 -> 1678
    //   1665: aload 16
    //   1667: astore 19
    //   1669: aload_2
    //   1670: astore 20
    //   1672: aload 17
    //   1674: invokevirtual 67	java/io/File:mkdirs	()Z
    //   1677: pop
    //   1678: aload 16
    //   1680: astore 17
    //   1682: aload_2
    //   1683: astore 18
    //   1685: aload 16
    //   1687: astore 19
    //   1689: aload_2
    //   1690: astore 20
    //   1692: aload_1
    //   1693: invokevirtual 64	java/io/File:exists	()Z
    //   1696: ifeq +389 -> 2085
    //   1699: aload 16
    //   1701: astore 19
    //   1703: aload_2
    //   1704: astore 20
    //   1706: aload_1
    //   1707: invokevirtual 149	java/io/File:delete	()Z
    //   1710: istore 15
    //   1712: aload 16
    //   1714: astore 19
    //   1716: aload_2
    //   1717: astore 20
    //   1719: new 217	java/lang/StringBuilder
    //   1722: dup
    //   1723: invokespecial 218	java/lang/StringBuilder:<init>	()V
    //   1726: astore 17
    //   1728: aload 16
    //   1730: astore 19
    //   1732: aload_2
    //   1733: astore 20
    //   1735: aload 17
    //   1737: ldc_w 273
    //   1740: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1743: pop
    //   1744: aload 16
    //   1746: astore 19
    //   1748: aload_2
    //   1749: astore 20
    //   1751: aload 17
    //   1753: iload 15
    //   1755: invokevirtual 249	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1758: pop
    //   1759: aload 16
    //   1761: astore 19
    //   1763: aload_2
    //   1764: astore 20
    //   1766: aload 17
    //   1768: invokevirtual 235	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1771: astore 17
    //   1773: goto +290 -> 2063
    //   1776: astore 17
    //   1778: aload 18
    //   1780: astore_2
    //   1781: iconst_5
    //   1782: istore_3
    //   1783: aload 17
    //   1785: astore 19
    //   1787: iload_3
    //   1788: istore 4
    //   1790: aload 16
    //   1792: astore 17
    //   1794: aload_2
    //   1795: astore 18
    //   1797: invokestatic 215	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1800: ifeq +81 -> 1881
    //   1803: iload_3
    //   1804: istore 4
    //   1806: aload 16
    //   1808: astore 17
    //   1810: aload_2
    //   1811: astore 18
    //   1813: new 217	java/lang/StringBuilder
    //   1816: dup
    //   1817: invokespecial 218	java/lang/StringBuilder:<init>	()V
    //   1820: astore 20
    //   1822: iload_3
    //   1823: istore 4
    //   1825: aload 16
    //   1827: astore 17
    //   1829: aload_2
    //   1830: astore 18
    //   1832: aload 20
    //   1834: ldc_w 275
    //   1837: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1840: pop
    //   1841: iload_3
    //   1842: istore 4
    //   1844: aload 16
    //   1846: astore 17
    //   1848: aload_2
    //   1849: astore 18
    //   1851: aload 20
    //   1853: aload_0
    //   1854: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1857: pop
    //   1858: iload_3
    //   1859: istore 4
    //   1861: aload 16
    //   1863: astore 17
    //   1865: aload_2
    //   1866: astore 18
    //   1868: ldc 8
    //   1870: iconst_2
    //   1871: aload 20
    //   1873: invokevirtual 235	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1876: aload 19
    //   1878: invokestatic 244	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1881: aload_2
    //   1882: ifnull +19 -> 1901
    //   1885: aload_2
    //   1886: invokeinterface 265 1 0
    //   1891: goto +10 -> 1901
    //   1894: astore 17
    //   1896: aload 17
    //   1898: invokevirtual 268	java/io/IOException:printStackTrace	()V
    //   1901: aload 16
    //   1903: ifnull +8 -> 1911
    //   1906: aload 16
    //   1908: invokevirtual 271	java/io/OutputStream:close	()V
    //   1911: aload 16
    //   1913: astore 17
    //   1915: aload_2
    //   1916: astore 18
    //   1918: aload_1
    //   1919: ifnull +166 -> 2085
    //   1922: aload 16
    //   1924: astore 19
    //   1926: aload_2
    //   1927: astore 20
    //   1929: aload_1
    //   1930: invokevirtual 60	java/io/File:getParentFile	()Ljava/io/File;
    //   1933: astore 17
    //   1935: aload 17
    //   1937: ifnull +31 -> 1968
    //   1940: aload 16
    //   1942: astore 19
    //   1944: aload_2
    //   1945: astore 20
    //   1947: aload 17
    //   1949: invokevirtual 64	java/io/File:exists	()Z
    //   1952: ifne +16 -> 1968
    //   1955: aload 16
    //   1957: astore 19
    //   1959: aload_2
    //   1960: astore 20
    //   1962: aload 17
    //   1964: invokevirtual 67	java/io/File:mkdirs	()Z
    //   1967: pop
    //   1968: aload 16
    //   1970: astore 17
    //   1972: aload_2
    //   1973: astore 18
    //   1975: aload 16
    //   1977: astore 19
    //   1979: aload_2
    //   1980: astore 20
    //   1982: aload_1
    //   1983: invokevirtual 64	java/io/File:exists	()Z
    //   1986: ifeq +99 -> 2085
    //   1989: aload 16
    //   1991: astore 19
    //   1993: aload_2
    //   1994: astore 20
    //   1996: aload_1
    //   1997: invokevirtual 149	java/io/File:delete	()Z
    //   2000: istore 15
    //   2002: aload 16
    //   2004: astore 19
    //   2006: aload_2
    //   2007: astore 20
    //   2009: new 217	java/lang/StringBuilder
    //   2012: dup
    //   2013: invokespecial 218	java/lang/StringBuilder:<init>	()V
    //   2016: astore 17
    //   2018: aload 16
    //   2020: astore 19
    //   2022: aload_2
    //   2023: astore 20
    //   2025: aload 17
    //   2027: ldc_w 273
    //   2030: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2033: pop
    //   2034: aload 16
    //   2036: astore 19
    //   2038: aload_2
    //   2039: astore 20
    //   2041: aload 17
    //   2043: iload 15
    //   2045: invokevirtual 249	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2048: pop
    //   2049: aload 16
    //   2051: astore 19
    //   2053: aload_2
    //   2054: astore 20
    //   2056: aload 17
    //   2058: invokevirtual 235	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2061: astore 17
    //   2063: aload 16
    //   2065: astore 19
    //   2067: aload_2
    //   2068: astore 20
    //   2070: ldc 8
    //   2072: iconst_1
    //   2073: aload 17
    //   2075: invokestatic 253	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2078: aload_2
    //   2079: astore 18
    //   2081: aload 16
    //   2083: astore 17
    //   2085: iconst_5
    //   2086: istore 5
    //   2088: goto +445 -> 2533
    //   2091: astore 17
    //   2093: aload 18
    //   2095: astore_2
    //   2096: aload 17
    //   2098: astore 18
    //   2100: iconst_5
    //   2101: istore_3
    //   2102: aload 18
    //   2104: astore 19
    //   2106: iload_3
    //   2107: istore 4
    //   2109: aload 16
    //   2111: astore 17
    //   2113: aload_2
    //   2114: astore 18
    //   2116: invokestatic 215	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2119: ifeq +81 -> 2200
    //   2122: iload_3
    //   2123: istore 4
    //   2125: aload 16
    //   2127: astore 17
    //   2129: aload_2
    //   2130: astore 18
    //   2132: new 217	java/lang/StringBuilder
    //   2135: dup
    //   2136: invokespecial 218	java/lang/StringBuilder:<init>	()V
    //   2139: astore 20
    //   2141: iload_3
    //   2142: istore 4
    //   2144: aload 16
    //   2146: astore 17
    //   2148: aload_2
    //   2149: astore 18
    //   2151: aload 20
    //   2153: ldc_w 277
    //   2156: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2159: pop
    //   2160: iload_3
    //   2161: istore 4
    //   2163: aload 16
    //   2165: astore 17
    //   2167: aload_2
    //   2168: astore 18
    //   2170: aload 20
    //   2172: aload_0
    //   2173: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2176: pop
    //   2177: iload_3
    //   2178: istore 4
    //   2180: aload 16
    //   2182: astore 17
    //   2184: aload_2
    //   2185: astore 18
    //   2187: ldc 8
    //   2189: iconst_2
    //   2190: aload 20
    //   2192: invokevirtual 235	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2195: aload 19
    //   2197: invokestatic 244	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2200: iload_3
    //   2201: istore 4
    //   2203: aload 16
    //   2205: astore 17
    //   2207: aload_2
    //   2208: astore 18
    //   2210: aload 19
    //   2212: instanceof 279
    //   2215: ifeq +9 -> 2224
    //   2218: bipush 10
    //   2220: istore_3
    //   2221: goto +77 -> 2298
    //   2224: iload_3
    //   2225: istore 4
    //   2227: aload 16
    //   2229: astore 17
    //   2231: aload_2
    //   2232: astore 18
    //   2234: aload 19
    //   2236: instanceof 281
    //   2239: ifne +57 -> 2296
    //   2242: iload_3
    //   2243: istore 4
    //   2245: aload 16
    //   2247: astore 17
    //   2249: aload_2
    //   2250: astore 18
    //   2252: aload 19
    //   2254: instanceof 283
    //   2257: ifeq +6 -> 2263
    //   2260: goto +36 -> 2296
    //   2263: iload_3
    //   2264: istore 4
    //   2266: aload 16
    //   2268: astore 17
    //   2270: aload_2
    //   2271: astore 18
    //   2273: aload 19
    //   2275: instanceof 285
    //   2278: istore 15
    //   2280: iload 15
    //   2282: ifeq +9 -> 2291
    //   2285: bipush 11
    //   2287: istore_3
    //   2288: goto +10 -> 2298
    //   2291: iconst_4
    //   2292: istore_3
    //   2293: goto +5 -> 2298
    //   2296: iconst_2
    //   2297: istore_3
    //   2298: aload_2
    //   2299: ifnull +19 -> 2318
    //   2302: aload_2
    //   2303: invokeinterface 265 1 0
    //   2308: goto +10 -> 2318
    //   2311: astore 17
    //   2313: aload 17
    //   2315: invokevirtual 268	java/io/IOException:printStackTrace	()V
    //   2318: aload 16
    //   2320: ifnull +11 -> 2331
    //   2323: aload 16
    //   2325: invokevirtual 271	java/io/OutputStream:close	()V
    //   2328: goto +3 -> 2331
    //   2331: iload_3
    //   2332: istore 5
    //   2334: aload 16
    //   2336: astore 17
    //   2338: aload_2
    //   2339: astore 18
    //   2341: iload_3
    //   2342: ifeq +191 -> 2533
    //   2345: iload_3
    //   2346: istore 5
    //   2348: aload 16
    //   2350: astore 17
    //   2352: aload_2
    //   2353: astore 18
    //   2355: aload_1
    //   2356: ifnull +177 -> 2533
    //   2359: iload_3
    //   2360: istore 6
    //   2362: aload 16
    //   2364: astore 20
    //   2366: aload_2
    //   2367: astore 21
    //   2369: aload_1
    //   2370: invokevirtual 60	java/io/File:getParentFile	()Ljava/io/File;
    //   2373: astore 17
    //   2375: aload 17
    //   2377: ifnull +37 -> 2414
    //   2380: iload_3
    //   2381: istore 6
    //   2383: aload 16
    //   2385: astore 20
    //   2387: aload_2
    //   2388: astore 21
    //   2390: aload 17
    //   2392: invokevirtual 64	java/io/File:exists	()Z
    //   2395: ifne +19 -> 2414
    //   2398: iload_3
    //   2399: istore 6
    //   2401: aload 16
    //   2403: astore 20
    //   2405: aload_2
    //   2406: astore 21
    //   2408: aload 17
    //   2410: invokevirtual 67	java/io/File:mkdirs	()Z
    //   2413: pop
    //   2414: iload_3
    //   2415: istore 5
    //   2417: aload 16
    //   2419: astore 17
    //   2421: aload_2
    //   2422: astore 18
    //   2424: iload_3
    //   2425: istore 6
    //   2427: aload 16
    //   2429: astore 20
    //   2431: aload_2
    //   2432: astore 21
    //   2434: aload_1
    //   2435: invokevirtual 64	java/io/File:exists	()Z
    //   2438: ifeq +95 -> 2533
    //   2441: iload_3
    //   2442: istore 6
    //   2444: aload 16
    //   2446: astore 20
    //   2448: aload_2
    //   2449: astore 21
    //   2451: aload_1
    //   2452: invokevirtual 149	java/io/File:delete	()Z
    //   2455: istore 15
    //   2457: iload_3
    //   2458: istore 6
    //   2460: aload 16
    //   2462: astore 20
    //   2464: aload_2
    //   2465: astore 21
    //   2467: new 217	java/lang/StringBuilder
    //   2470: dup
    //   2471: invokespecial 218	java/lang/StringBuilder:<init>	()V
    //   2474: astore 17
    //   2476: iload_3
    //   2477: istore 6
    //   2479: aload 16
    //   2481: astore 20
    //   2483: aload_2
    //   2484: astore 21
    //   2486: aload 17
    //   2488: ldc_w 273
    //   2491: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2494: pop
    //   2495: iload_3
    //   2496: istore 6
    //   2498: aload 16
    //   2500: astore 20
    //   2502: aload_2
    //   2503: astore 21
    //   2505: aload 17
    //   2507: iload 15
    //   2509: invokevirtual 249	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2512: pop
    //   2513: iload_3
    //   2514: istore 6
    //   2516: aload 16
    //   2518: astore 20
    //   2520: aload_2
    //   2521: astore 21
    //   2523: aload 17
    //   2525: invokevirtual 235	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2528: astore 17
    //   2530: goto -1104 -> 1426
    //   2533: iload 8
    //   2535: iconst_1
    //   2536: iadd
    //   2537: istore 8
    //   2539: invokestatic 215	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2542: ifeq +50 -> 2592
    //   2545: new 217	java/lang/StringBuilder
    //   2548: dup
    //   2549: invokespecial 218	java/lang/StringBuilder:<init>	()V
    //   2552: astore_2
    //   2553: aload_2
    //   2554: ldc_w 287
    //   2557: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2560: pop
    //   2561: aload_2
    //   2562: iload 5
    //   2564: invokevirtual 290	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2567: pop
    //   2568: aload_2
    //   2569: ldc_w 259
    //   2572: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2575: pop
    //   2576: aload_2
    //   2577: aload_0
    //   2578: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2581: pop
    //   2582: ldc 8
    //   2584: iconst_2
    //   2585: aload_2
    //   2586: invokevirtual 235	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2589: invokestatic 253	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2592: iload 5
    //   2594: ifeq +65 -> 2659
    //   2597: new 217	java/lang/StringBuilder
    //   2600: dup
    //   2601: invokespecial 218	java/lang/StringBuilder:<init>	()V
    //   2604: astore_2
    //   2605: aload_2
    //   2606: ldc_w 287
    //   2609: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2612: pop
    //   2613: aload_2
    //   2614: iload 5
    //   2616: invokevirtual 290	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2619: pop
    //   2620: aload_2
    //   2621: ldc_w 259
    //   2624: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2627: pop
    //   2628: aload_2
    //   2629: aload_0
    //   2630: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2633: pop
    //   2634: aload_2
    //   2635: ldc_w 292
    //   2638: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2641: pop
    //   2642: aload_2
    //   2643: iload 8
    //   2645: invokevirtual 290	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2648: pop
    //   2649: ldc 8
    //   2651: iconst_1
    //   2652: aload_2
    //   2653: invokevirtual 235	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2656: invokestatic 253	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2659: iload 5
    //   2661: ifeq +38 -> 2699
    //   2664: iload 8
    //   2666: iconst_2
    //   2667: if_icmpge +32 -> 2699
    //   2670: aload 25
    //   2672: monitorenter
    //   2673: aload 25
    //   2675: ldc2_w 293
    //   2678: invokevirtual 298	java/lang/Object:wait	(J)V
    //   2681: goto +7 -> 2688
    //   2684: astore_0
    //   2685: goto +9 -> 2694
    //   2688: aload 25
    //   2690: monitorexit
    //   2691: goto +8 -> 2699
    //   2694: aload 25
    //   2696: monitorexit
    //   2697: aload_0
    //   2698: athrow
    //   2699: iload 5
    //   2701: ifeq +20 -> 2721
    //   2704: iload 8
    //   2706: iload 7
    //   2708: if_icmplt +6 -> 2714
    //   2711: iload 5
    //   2713: ireturn
    //   2714: aload 17
    //   2716: astore 16
    //   2718: goto -2426 -> 292
    //   2721: iload 5
    //   2723: ireturn
    //   2724: astore_0
    //   2725: aload 18
    //   2727: astore_2
    //   2728: aload_2
    //   2729: ifnull +17 -> 2746
    //   2732: aload_2
    //   2733: invokeinterface 265 1 0
    //   2738: goto +8 -> 2746
    //   2741: astore_2
    //   2742: aload_2
    //   2743: invokevirtual 268	java/io/IOException:printStackTrace	()V
    //   2746: aload 17
    //   2748: ifnull +11 -> 2759
    //   2751: aload 17
    //   2753: invokevirtual 271	java/io/OutputStream:close	()V
    //   2756: goto +3 -> 2759
    //   2759: iload 4
    //   2761: ifeq +74 -> 2835
    //   2764: aload_1
    //   2765: ifnull +70 -> 2835
    //   2768: aload_1
    //   2769: invokevirtual 60	java/io/File:getParentFile	()Ljava/io/File;
    //   2772: astore_2
    //   2773: aload_2
    //   2774: ifnull +15 -> 2789
    //   2777: aload_2
    //   2778: invokevirtual 64	java/io/File:exists	()Z
    //   2781: ifne +8 -> 2789
    //   2784: aload_2
    //   2785: invokevirtual 67	java/io/File:mkdirs	()Z
    //   2788: pop
    //   2789: aload_1
    //   2790: invokevirtual 64	java/io/File:exists	()Z
    //   2793: ifeq +42 -> 2835
    //   2796: aload_1
    //   2797: invokevirtual 149	java/io/File:delete	()Z
    //   2800: istore 15
    //   2802: new 217	java/lang/StringBuilder
    //   2805: dup
    //   2806: invokespecial 218	java/lang/StringBuilder:<init>	()V
    //   2809: astore_1
    //   2810: aload_1
    //   2811: ldc_w 273
    //   2814: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2817: pop
    //   2818: aload_1
    //   2819: iload 15
    //   2821: invokevirtual 249	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2824: pop
    //   2825: ldc 8
    //   2827: iconst_1
    //   2828: aload_1
    //   2829: invokevirtual 235	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2832: invokestatic 253	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2835: aload_0
    //   2836: athrow
    //   2837: ldc 8
    //   2839: iconst_1
    //   2840: ldc_w 300
    //   2843: invokestatic 253	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2846: bipush 13
    //   2848: ireturn
    //   2849: ldc 8
    //   2851: iconst_1
    //   2852: ldc_w 302
    //   2855: invokestatic 253	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2858: iconst_4
    //   2859: ireturn
    //   2860: astore_0
    //   2861: goto -12 -> 2849
    //   2864: astore 17
    //   2866: goto -2798 -> 68
    //   2869: astore_0
    //   2870: goto -33 -> 2837
    //   2873: astore 17
    //   2875: goto +71 -> 2946
    //   2878: astore 16
    //   2880: goto -2225 -> 655
    //   2883: astore 16
    //   2885: goto -2230 -> 655
    //   2888: astore 16
    //   2890: goto -2316 -> 574
    //   2893: astore 16
    //   2895: goto -1688 -> 1207
    //   2898: astore_2
    //   2899: goto -1442 -> 1457
    //   2902: astore 17
    //   2904: goto -1283 -> 1621
    //   2907: astore_2
    //   2908: aload 19
    //   2910: astore 17
    //   2912: aload 20
    //   2914: astore 18
    //   2916: goto -831 -> 2085
    //   2919: astore 17
    //   2921: goto -1010 -> 1911
    //   2924: astore 17
    //   2926: goto -595 -> 2331
    //   2929: astore_2
    //   2930: goto -242 -> 2688
    //   2933: astore_2
    //   2934: goto -175 -> 2759
    //   2937: astore_1
    //   2938: goto -103 -> 2835
    //   2941: iconst_4
    //   2942: istore_3
    //   2943: goto -2037 -> 906
    //   2946: lconst_0
    //   2947: lstore 9
    //   2949: goto -2218 -> 731
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2952	0	paramURL	URL
    //   0	2952	1	paramFile	File
    //   0	2952	2	paramNetworkInfo	NetworkInfo
    //   0	2952	3	paramInt	int
    //   108	2652	4	m	int
    //   94	2628	5	n	int
    //   1240	1275	6	i1	int
    //   290	2419	7	i2	int
    //   283	2426	8	i3	int
    //   459	2489	9	l1	long
    //   3	495	11	l2	long
    //   416	585	13	l3	long
    //   1340	1480	15	bool	boolean
    //   27	522	16	localObject1	Object
    //   555	1	16	localThrowable1	java.lang.Throwable
    //   560	1	16	localException1	Exception
    //   569	8	16	localObject2	Object
    //   581	1	16	localThrowable2	java.lang.Throwable
    //   586	1	16	localException2	Exception
    //   591	1	16	localIOException1	java.io.IOException
    //   604	7	16	localThrowable3	java.lang.Throwable
    //   616	1	16	localObject3	Object
    //   621	7	16	localException3	Exception
    //   633	1	16	localObject4	Object
    //   638	7	16	localIOException2	java.io.IOException
    //   650	521	16	localObject5	Object
    //   1187	3	16	localIOException3	java.io.IOException
    //   1253	1464	16	localObject6	Object
    //   2878	1	16	localFileNotFoundException1	java.io.FileNotFoundException
    //   2883	1	16	localFileNotFoundException2	java.io.FileNotFoundException
    //   2888	1	16	localFileNotFoundException3	java.io.FileNotFoundException
    //   2893	1	16	localIOException4	java.io.IOException
    //   63	593	17	localObject7	Object
    //   662	6	17	localIOException5	java.io.IOException
    //   681	406	17	localObject8	Object
    //   1128	1	17	localThrowable4	java.lang.Throwable
    //   1137	12	17	localException4	Exception
    //   1155	1	17	localThrowable5	java.lang.Throwable
    //   1160	1	17	localException5	Exception
    //   1213	269	17	localObject9	Object
    //   1486	8	17	localThrowable6	java.lang.Throwable
    //   1502	72	17	localObject10	Object
    //   1604	3	17	localIOException6	java.io.IOException
    //   1623	149	17	localObject11	Object
    //   1776	8	17	localException6	Exception
    //   1792	72	17	localObject12	Object
    //   1894	3	17	localIOException7	java.io.IOException
    //   1913	171	17	localObject13	Object
    //   2091	6	17	localIOException8	java.io.IOException
    //   2111	158	17	localObject14	Object
    //   2311	3	17	localIOException9	java.io.IOException
    //   2336	416	17	localObject15	Object
    //   2864	1	17	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   2873	1	17	localFileNotFoundException4	java.io.FileNotFoundException
    //   2902	1	17	localIOException10	java.io.IOException
    //   2910	1	17	localObject16	Object
    //   2919	1	17	localIOException11	java.io.IOException
    //   2924	1	17	localIOException12	java.io.IOException
    //   114	1017	18	localObject17	Object
    //   1146	1	18	localIOException13	java.io.IOException
    //   1165	1	18	localIOException14	java.io.IOException
    //   1216	1699	18	localObject18	Object
    //   331	778	19	localObject19	Object
    //   1113	1	19	localThrowable7	java.lang.Throwable
    //   1118	1	19	localException7	Exception
    //   1123	1	19	localIOException15	java.io.IOException
    //   1172	1737	19	localObject20	Object
    //   335	2578	20	localObject21	Object
    //   677	1845	21	localObject22	Object
    //   89	236	22	localBasicHttpParams	BasicHttpParams
    //   287	65	23	localObject23	Object
    //   565	1	24	localIOException16	java.io.IOException
    //   669	228	24	localObject24	Object
    //   12	2683	25	localObject25	Object
    // Exception table:
    //   from	to	target	type
    //   461	546	555	java/lang/Throwable
    //   461	546	560	java/lang/Exception
    //   461	546	565	java/io/IOException
    //   455	461	581	java/lang/Throwable
    //   455	461	586	java/lang/Exception
    //   455	461	591	java/io/IOException
    //   442	455	596	finally
    //   455	461	596	finally
    //   461	546	596	finally
    //   442	455	604	java/lang/Throwable
    //   442	455	621	java/lang/Exception
    //   442	455	638	java/io/IOException
    //   425	442	662	java/io/IOException
    //   945	951	1113	java/lang/Throwable
    //   961	970	1113	java/lang/Throwable
    //   980	988	1113	java/lang/Throwable
    //   998	1006	1113	java/lang/Throwable
    //   1016	1025	1113	java/lang/Throwable
    //   1035	1045	1113	java/lang/Throwable
    //   1055	1064	1113	java/lang/Throwable
    //   1074	1081	1113	java/lang/Throwable
    //   1091	1102	1113	java/lang/Throwable
    //   945	951	1118	java/lang/Exception
    //   961	970	1118	java/lang/Exception
    //   980	988	1118	java/lang/Exception
    //   998	1006	1118	java/lang/Exception
    //   1016	1025	1118	java/lang/Exception
    //   1035	1045	1118	java/lang/Exception
    //   1055	1064	1118	java/lang/Exception
    //   1074	1081	1118	java/lang/Exception
    //   1091	1102	1118	java/lang/Exception
    //   945	951	1123	java/io/IOException
    //   961	970	1123	java/io/IOException
    //   980	988	1123	java/io/IOException
    //   998	1006	1123	java/io/IOException
    //   1016	1025	1123	java/io/IOException
    //   1035	1045	1123	java/io/IOException
    //   1055	1064	1123	java/io/IOException
    //   1074	1081	1123	java/io/IOException
    //   1091	1102	1123	java/io/IOException
    //   690	696	1128	java/lang/Throwable
    //   715	728	1128	java/lang/Throwable
    //   750	759	1128	java/lang/Throwable
    //   778	786	1128	java/lang/Throwable
    //   805	815	1128	java/lang/Throwable
    //   834	842	1128	java/lang/Throwable
    //   861	874	1128	java/lang/Throwable
    //   893	904	1128	java/lang/Throwable
    //   690	696	1137	java/lang/Exception
    //   715	728	1137	java/lang/Exception
    //   750	759	1137	java/lang/Exception
    //   778	786	1137	java/lang/Exception
    //   805	815	1137	java/lang/Exception
    //   834	842	1137	java/lang/Exception
    //   861	874	1137	java/lang/Exception
    //   893	904	1137	java/lang/Exception
    //   690	696	1146	java/io/IOException
    //   715	728	1146	java/io/IOException
    //   750	759	1146	java/io/IOException
    //   778	786	1146	java/io/IOException
    //   805	815	1146	java/io/IOException
    //   834	842	1146	java/io/IOException
    //   861	874	1146	java/io/IOException
    //   893	904	1146	java/io/IOException
    //   410	418	1155	java/lang/Throwable
    //   425	442	1155	java/lang/Throwable
    //   410	418	1160	java/lang/Exception
    //   425	442	1160	java/lang/Exception
    //   410	418	1165	java/io/IOException
    //   1178	1184	1187	java/io/IOException
    //   337	359	1472	finally
    //   367	380	1472	finally
    //   388	395	1472	finally
    //   410	418	1472	finally
    //   425	442	1472	finally
    //   690	696	1472	finally
    //   715	728	1472	finally
    //   750	759	1472	finally
    //   778	786	1472	finally
    //   805	815	1472	finally
    //   834	842	1472	finally
    //   861	874	1472	finally
    //   893	904	1472	finally
    //   337	359	1486	java/lang/Throwable
    //   367	380	1486	java/lang/Throwable
    //   388	395	1486	java/lang/Throwable
    //   1595	1601	1604	java/io/IOException
    //   337	359	1776	java/lang/Exception
    //   367	380	1776	java/lang/Exception
    //   388	395	1776	java/lang/Exception
    //   1885	1891	1894	java/io/IOException
    //   337	359	2091	java/io/IOException
    //   367	380	2091	java/io/IOException
    //   388	395	2091	java/io/IOException
    //   2302	2308	2311	java/io/IOException
    //   2673	2681	2684	finally
    //   2688	2691	2684	finally
    //   2694	2697	2684	finally
    //   945	951	2724	finally
    //   961	970	2724	finally
    //   980	988	2724	finally
    //   998	1006	2724	finally
    //   1016	1025	2724	finally
    //   1035	1045	2724	finally
    //   1055	1064	2724	finally
    //   1074	1081	2724	finally
    //   1091	1102	2724	finally
    //   1507	1513	2724	finally
    //   1523	1532	2724	finally
    //   1542	1551	2724	finally
    //   1561	1568	2724	finally
    //   1578	1591	2724	finally
    //   1797	1803	2724	finally
    //   1813	1822	2724	finally
    //   1832	1841	2724	finally
    //   1851	1858	2724	finally
    //   1868	1881	2724	finally
    //   2116	2122	2724	finally
    //   2132	2141	2724	finally
    //   2151	2160	2724	finally
    //   2170	2177	2724	finally
    //   2187	2200	2724	finally
    //   2210	2218	2724	finally
    //   2234	2242	2724	finally
    //   2252	2260	2724	finally
    //   2273	2280	2724	finally
    //   2732	2738	2741	java/io/IOException
    //   23	29	2860	java/lang/Exception
    //   34	48	2860	java/lang/Exception
    //   54	65	2864	java/lang/IllegalArgumentException
    //   68	82	2869	java/lang/IllegalArgumentException
    //   425	442	2873	java/io/FileNotFoundException
    //   442	455	2878	java/io/FileNotFoundException
    //   455	461	2883	java/io/FileNotFoundException
    //   461	546	2888	java/io/FileNotFoundException
    //   1199	1204	2893	java/io/IOException
    //   1249	1255	2898	java/lang/Exception
    //   1271	1279	2898	java/lang/Exception
    //   1290	1296	2898	java/lang/Exception
    //   1318	1325	2898	java/lang/Exception
    //   1336	1342	2898	java/lang/Exception
    //   1353	1362	2898	java/lang/Exception
    //   1373	1382	2898	java/lang/Exception
    //   1393	1401	2898	java/lang/Exception
    //   1412	1419	2898	java/lang/Exception
    //   1436	1444	2898	java/lang/Exception
    //   2369	2375	2898	java/lang/Exception
    //   2390	2398	2898	java/lang/Exception
    //   2408	2414	2898	java/lang/Exception
    //   2434	2441	2898	java/lang/Exception
    //   2451	2457	2898	java/lang/Exception
    //   2467	2476	2898	java/lang/Exception
    //   2486	2495	2898	java/lang/Exception
    //   2505	2513	2898	java/lang/Exception
    //   2523	2530	2898	java/lang/Exception
    //   1616	1621	2902	java/io/IOException
    //   1639	1645	2907	java/lang/Exception
    //   1657	1665	2907	java/lang/Exception
    //   1672	1678	2907	java/lang/Exception
    //   1692	1699	2907	java/lang/Exception
    //   1706	1712	2907	java/lang/Exception
    //   1719	1728	2907	java/lang/Exception
    //   1735	1744	2907	java/lang/Exception
    //   1751	1759	2907	java/lang/Exception
    //   1766	1773	2907	java/lang/Exception
    //   1929	1935	2907	java/lang/Exception
    //   1947	1955	2907	java/lang/Exception
    //   1962	1968	2907	java/lang/Exception
    //   1982	1989	2907	java/lang/Exception
    //   1996	2002	2907	java/lang/Exception
    //   2009	2018	2907	java/lang/Exception
    //   2025	2034	2907	java/lang/Exception
    //   2041	2049	2907	java/lang/Exception
    //   2056	2063	2907	java/lang/Exception
    //   2070	2078	2907	java/lang/Exception
    //   1906	1911	2919	java/io/IOException
    //   2323	2328	2924	java/io/IOException
    //   2673	2681	2929	java/lang/InterruptedException
    //   2751	2756	2933	java/io/IOException
    //   2768	2773	2937	java/lang/Exception
    //   2777	2789	2937	java/lang/Exception
    //   2789	2835	2937	java/lang/Exception
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
      int m = Build.VERSION.SDK_INT;
      if (m >= 23)
      {
        SSLSocketFactory localSSLSocketFactory = SSLSocketFactory.getSocketFactory();
        localSSLSocketFactory.setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
        localSchemeRegistry.register(new Scheme("https", localSSLSocketFactory, 443));
      }
      else
      {
        localSchemeRegistry.register(new Scheme("https", new g(f.class.getSimpleName()), 443));
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("HttpDownloadUtil", 2, "createHttpClient():Can't support https on this devices.", localException);
      }
    }
    localObject = new DefaultHttpClient(new ThreadSafeClientConnManager((HttpParams)localObject, localSchemeRegistry), (HttpParams)localObject);
    ((DefaultHttpClient)localObject).setHttpRequestRetryHandler(new DefaultHttpRequestRetryHandler());
    return localObject;
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    NetworkInfo localNetworkInfo = AppNetConnInfo.getRecentNetworkInfo();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append(System.currentTimeMillis());
    ((StringBuilder)localObject).append(".tmp");
    localObject = new File(((StringBuilder)localObject).toString());
    try
    {
      paramString1 = new URL(paramString1);
      boolean bool;
      if (a(paramString1, (File)localObject, localNetworkInfo, 2) == 0) {
        bool = true;
      } else {
        bool = false;
      }
      if (bool) {
        try
        {
          ((File)localObject).renameTo(new File(paramString2));
          return bool;
        }
        catch (Exception paramString1)
        {
          paramString1.printStackTrace();
          return false;
        }
      }
      return bool;
    }
    catch (MalformedURLException paramString1)
    {
      paramString1.printStackTrace();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.utils.f
 * JD-Core Version:    0.7.0.1
 */