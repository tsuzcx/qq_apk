package com.tencent.mobileqq.debug;

import android.content.Context;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONObject;

public class CIOSubmitUtils$UploadFileUtil
{
  Context a;
  String b;
  String c;
  JSONObject d;
  private ConcurrentHashMap<String, String> e = new ConcurrentHashMap();
  private ConcurrentLinkedQueue<String[]> f = new ConcurrentLinkedQueue();
  
  public CIOSubmitUtils$UploadFileUtil()
  {
    this.e.put("username", "JLLLCKCOAODOBJFK");
    this.e.put("password", "ALFLMLILPLBJFK");
  }
  
  public CIOSubmitUtils$UploadFileUtil(Context paramContext)
  {
    this.a = paramContext;
  }
  
  /* Error */
  public String a()
  {
    // Byte code:
    //   0: invokestatic 58	com/tencent/mobileqq/msf/sdk/AppNetConnInfo:isNetSupport	()Z
    //   3: ifne +5 -> 8
    //   6: aconst_null
    //   7: areturn
    //   8: new 60	java/net/URL
    //   11: dup
    //   12: ldc 62
    //   14: invokespecial 65	java/net/URL:<init>	(Ljava/lang/String;)V
    //   17: invokevirtual 69	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   20: checkcast 71	java/net/HttpURLConnection
    //   23: astore 5
    //   25: aload 5
    //   27: ldc 73
    //   29: ldc 75
    //   31: invokevirtual 79	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   34: aload 5
    //   36: ldc 81
    //   38: ldc 83
    //   40: invokevirtual 79	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   43: aload 5
    //   45: iconst_1
    //   46: invokevirtual 87	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   49: aload 5
    //   51: iconst_1
    //   52: invokevirtual 90	java/net/HttpURLConnection:setDoInput	(Z)V
    //   55: aload 5
    //   57: iconst_0
    //   58: invokevirtual 93	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   61: aload 5
    //   63: ldc 95
    //   65: invokevirtual 98	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   68: aload 5
    //   70: invokevirtual 102	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   73: astore 7
    //   75: new 104	java/lang/StringBuffer
    //   78: dup
    //   79: ldc 106
    //   81: invokespecial 107	java/lang/StringBuffer:<init>	(Ljava/lang/String;)V
    //   84: astore 4
    //   86: new 109	java/lang/StringBuilder
    //   89: dup
    //   90: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   93: astore 6
    //   95: aload 6
    //   97: ldc 112
    //   99: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: pop
    //   103: aload 6
    //   105: ldc 118
    //   107: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: pop
    //   111: aload 6
    //   113: ldc 120
    //   115: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: pop
    //   119: aload 6
    //   121: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   124: astore 8
    //   126: aload_0
    //   127: getfield 26	com/tencent/mobileqq/debug/CIOSubmitUtils$UploadFileUtil:e	Ljava/util/concurrent/ConcurrentHashMap;
    //   130: astore 6
    //   132: aload 6
    //   134: ifnull +128 -> 262
    //   137: aload_0
    //   138: getfield 26	com/tencent/mobileqq/debug/CIOSubmitUtils$UploadFileUtil:e	Ljava/util/concurrent/ConcurrentHashMap;
    //   141: invokevirtual 127	java/util/concurrent/ConcurrentHashMap:keySet	()Ljava/util/Set;
    //   144: invokeinterface 133 1 0
    //   149: astore 6
    //   151: aload 6
    //   153: invokeinterface 138 1 0
    //   158: ifeq +104 -> 262
    //   161: aload 6
    //   163: invokeinterface 142 1 0
    //   168: checkcast 144	java/lang/String
    //   171: astore 9
    //   173: aload_0
    //   174: getfield 26	com/tencent/mobileqq/debug/CIOSubmitUtils$UploadFileUtil:e	Ljava/util/concurrent/ConcurrentHashMap;
    //   177: aload 9
    //   179: invokevirtual 148	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   182: checkcast 144	java/lang/String
    //   185: astore 10
    //   187: aload 4
    //   189: ldc 150
    //   191: invokevirtual 153	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   194: pop
    //   195: aload 4
    //   197: aload 9
    //   199: invokevirtual 153	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   202: pop
    //   203: aload 4
    //   205: ldc 155
    //   207: invokevirtual 153	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   210: pop
    //   211: aload 4
    //   213: ldc 106
    //   215: invokevirtual 153	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   218: pop
    //   219: aload 4
    //   221: aload 10
    //   223: invokevirtual 153	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   226: pop
    //   227: aload 4
    //   229: ldc 106
    //   231: invokevirtual 153	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   234: pop
    //   235: aload 4
    //   237: ldc 157
    //   239: invokevirtual 153	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   242: pop
    //   243: aload 4
    //   245: ldc 118
    //   247: invokevirtual 153	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   250: pop
    //   251: aload 4
    //   253: ldc 106
    //   255: invokevirtual 153	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   258: pop
    //   259: goto -108 -> 151
    //   262: aload 4
    //   264: invokevirtual 158	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   267: astore 4
    //   269: new 109	java/lang/StringBuilder
    //   272: dup
    //   273: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   276: astore 6
    //   278: aload 6
    //   280: ldc 157
    //   282: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: pop
    //   286: aload 6
    //   288: ldc 118
    //   290: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: pop
    //   294: aload 6
    //   296: aload 4
    //   298: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: pop
    //   302: aload 7
    //   304: aload 6
    //   306: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   309: ldc 160
    //   311: invokevirtual 164	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   314: invokevirtual 170	java/io/OutputStream:write	([B)V
    //   317: new 104	java/lang/StringBuffer
    //   320: dup
    //   321: invokespecial 171	java/lang/StringBuffer:<init>	()V
    //   324: astore 9
    //   326: aload_0
    //   327: getfield 31	com/tencent/mobileqq/debug/CIOSubmitUtils$UploadFileUtil:f	Ljava/util/concurrent/ConcurrentLinkedQueue;
    //   330: ifnull +289 -> 619
    //   333: aload_0
    //   334: getfield 31	com/tencent/mobileqq/debug/CIOSubmitUtils$UploadFileUtil:f	Ljava/util/concurrent/ConcurrentLinkedQueue;
    //   337: invokevirtual 175	java/util/concurrent/ConcurrentLinkedQueue:size	()I
    //   340: istore_2
    //   341: iconst_0
    //   342: istore_1
    //   343: aconst_null
    //   344: astore 4
    //   346: iload_1
    //   347: iload_2
    //   348: if_icmpge +268 -> 616
    //   351: aload_0
    //   352: getfield 31	com/tencent/mobileqq/debug/CIOSubmitUtils$UploadFileUtil:f	Ljava/util/concurrent/ConcurrentLinkedQueue;
    //   355: invokevirtual 178	java/util/concurrent/ConcurrentLinkedQueue:poll	()Ljava/lang/Object;
    //   358: checkcast 180	[Ljava/lang/String;
    //   361: astore 12
    //   363: aload 12
    //   365: iconst_0
    //   366: aaload
    //   367: astore 6
    //   369: aload 12
    //   371: iconst_1
    //   372: aaload
    //   373: astore 10
    //   375: aload 12
    //   377: iconst_2
    //   378: aaload
    //   379: astore 11
    //   381: aload 12
    //   383: iconst_3
    //   384: aaload
    //   385: astore 12
    //   387: aload 9
    //   389: ldc 150
    //   391: invokevirtual 153	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   394: pop
    //   395: aload 9
    //   397: aload 6
    //   399: invokevirtual 153	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   402: pop
    //   403: aload 9
    //   405: ldc 182
    //   407: invokevirtual 153	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   410: pop
    //   411: aload 9
    //   413: aload 10
    //   415: invokevirtual 153	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   418: pop
    //   419: aload 9
    //   421: ldc 155
    //   423: invokevirtual 153	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   426: pop
    //   427: aload 9
    //   429: ldc 184
    //   431: invokevirtual 153	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   434: pop
    //   435: aload 9
    //   437: aload 11
    //   439: invokevirtual 153	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   442: pop
    //   443: aload 9
    //   445: ldc 186
    //   447: invokevirtual 153	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   450: pop
    //   451: aload 7
    //   453: aload 9
    //   455: invokevirtual 158	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   458: ldc 160
    //   460: invokevirtual 164	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   463: invokevirtual 170	java/io/OutputStream:write	([B)V
    //   466: new 188	java/io/DataInputStream
    //   469: dup
    //   470: new 190	java/io/FileInputStream
    //   473: dup
    //   474: new 192	java/io/File
    //   477: dup
    //   478: aload 12
    //   480: invokespecial 193	java/io/File:<init>	(Ljava/lang/String;)V
    //   483: invokespecial 196	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   486: invokespecial 199	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   489: astore 6
    //   491: sipush 5120
    //   494: newarray byte
    //   496: astore 4
    //   498: aload 6
    //   500: aload 4
    //   502: invokevirtual 203	java/io/DataInputStream:read	([B)I
    //   505: istore_3
    //   506: iload_3
    //   507: iconst_m1
    //   508: if_icmpeq +15 -> 523
    //   511: aload 7
    //   513: aload 4
    //   515: iconst_0
    //   516: iload_3
    //   517: invokevirtual 206	java/io/OutputStream:write	([BII)V
    //   520: goto -22 -> 498
    //   523: iload_1
    //   524: iload_2
    //   525: iconst_1
    //   526: isub
    //   527: if_icmpge +15 -> 542
    //   530: aload 7
    //   532: aload 8
    //   534: ldc 160
    //   536: invokevirtual 164	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   539: invokevirtual 170	java/io/OutputStream:write	([B)V
    //   542: aload 6
    //   544: invokevirtual 209	java/io/DataInputStream:close	()V
    //   547: iload_1
    //   548: iconst_1
    //   549: iadd
    //   550: istore_1
    //   551: aload 6
    //   553: astore 4
    //   555: goto -209 -> 346
    //   558: astore 4
    //   560: aload 6
    //   562: astore 7
    //   564: aload 4
    //   566: astore 6
    //   568: aload 7
    //   570: astore 4
    //   572: goto +280 -> 852
    //   575: astore 7
    //   577: aload 6
    //   579: astore 4
    //   581: aload 7
    //   583: astore 6
    //   585: goto +275 -> 860
    //   588: astore 7
    //   590: aload 6
    //   592: astore 4
    //   594: aload 7
    //   596: astore 6
    //   598: goto +274 -> 872
    //   601: astore 6
    //   603: goto +249 -> 852
    //   606: astore 6
    //   608: goto +252 -> 860
    //   611: astore 6
    //   613: goto +259 -> 872
    //   616: goto +6 -> 622
    //   619: aconst_null
    //   620: astore 4
    //   622: aload 7
    //   624: aload 8
    //   626: ldc 160
    //   628: invokevirtual 164	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   631: invokevirtual 170	java/io/OutputStream:write	([B)V
    //   634: aload 7
    //   636: invokevirtual 210	java/io/OutputStream:close	()V
    //   639: aload 5
    //   641: invokevirtual 213	java/net/HttpURLConnection:getResponseCode	()I
    //   644: istore_1
    //   645: new 109	java/lang/StringBuilder
    //   648: dup
    //   649: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   652: astore 6
    //   654: aload 6
    //   656: ldc 215
    //   658: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   661: pop
    //   662: aload 6
    //   664: iload_1
    //   665: invokevirtual 218	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   668: pop
    //   669: ldc 220
    //   671: iconst_2
    //   672: aload 6
    //   674: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   677: invokestatic 225	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   680: aload 5
    //   682: invokevirtual 229	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   685: astore 9
    //   687: aload 9
    //   689: astore 7
    //   691: aload 5
    //   693: astore 6
    //   695: aload 4
    //   697: astore 8
    //   699: new 104	java/lang/StringBuffer
    //   702: dup
    //   703: invokespecial 171	java/lang/StringBuffer:<init>	()V
    //   706: astore 10
    //   708: aload 9
    //   710: astore 7
    //   712: aload 5
    //   714: astore 6
    //   716: aload 4
    //   718: astore 8
    //   720: aload 9
    //   722: invokevirtual 233	java/io/InputStream:read	()I
    //   725: istore_1
    //   726: iload_1
    //   727: iconst_m1
    //   728: if_icmpeq +26 -> 754
    //   731: aload 9
    //   733: astore 7
    //   735: aload 5
    //   737: astore 6
    //   739: aload 4
    //   741: astore 8
    //   743: aload 10
    //   745: iload_1
    //   746: i2c
    //   747: invokevirtual 236	java/lang/StringBuffer:append	(C)Ljava/lang/StringBuffer;
    //   750: pop
    //   751: goto -43 -> 708
    //   754: aload 9
    //   756: astore 7
    //   758: aload 5
    //   760: astore 6
    //   762: aload 4
    //   764: astore 8
    //   766: ldc 238
    //   768: aload 10
    //   770: invokevirtual 158	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   773: invokestatic 244	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   776: pop
    //   777: aload 9
    //   779: astore 7
    //   781: aload 5
    //   783: astore 6
    //   785: aload 4
    //   787: astore 8
    //   789: aload 10
    //   791: invokevirtual 158	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   794: astore 10
    //   796: aload 4
    //   798: ifnull +11 -> 809
    //   801: aload 4
    //   803: invokevirtual 209	java/io/DataInputStream:close	()V
    //   806: goto +3 -> 809
    //   809: aload 9
    //   811: ifnull +8 -> 819
    //   814: aload 9
    //   816: invokevirtual 245	java/io/InputStream:close	()V
    //   819: aload 5
    //   821: ifnull +16 -> 837
    //   824: aload 5
    //   826: invokevirtual 248	java/net/HttpURLConnection:disconnect	()V
    //   829: aload 10
    //   831: areturn
    //   832: aload 4
    //   834: invokevirtual 251	java/lang/Exception:printStackTrace	()V
    //   837: aload 10
    //   839: areturn
    //   840: astore 10
    //   842: goto +80 -> 922
    //   845: astore 10
    //   847: goto +146 -> 993
    //   850: astore 6
    //   852: aconst_null
    //   853: astore 7
    //   855: goto +216 -> 1071
    //   858: astore 6
    //   860: aconst_null
    //   861: astore 9
    //   863: aload 6
    //   865: astore 10
    //   867: goto +55 -> 922
    //   870: astore 6
    //   872: aconst_null
    //   873: astore 9
    //   875: aload 6
    //   877: astore 10
    //   879: goto +114 -> 993
    //   882: astore 6
    //   884: goto +18 -> 902
    //   887: astore 10
    //   889: goto +27 -> 916
    //   892: astore 10
    //   894: goto +93 -> 987
    //   897: astore 6
    //   899: aconst_null
    //   900: astore 5
    //   902: aconst_null
    //   903: astore 7
    //   905: aconst_null
    //   906: astore 4
    //   908: goto +163 -> 1071
    //   911: astore 10
    //   913: aconst_null
    //   914: astore 5
    //   916: aconst_null
    //   917: astore 9
    //   919: aconst_null
    //   920: astore 4
    //   922: aload 9
    //   924: astore 7
    //   926: aload 5
    //   928: astore 6
    //   930: aload 4
    //   932: astore 8
    //   934: aload 10
    //   936: invokevirtual 252	java/lang/OutOfMemoryError:printStackTrace	()V
    //   939: aload 4
    //   941: ifnull +11 -> 952
    //   944: aload 4
    //   946: invokevirtual 209	java/io/DataInputStream:close	()V
    //   949: goto +3 -> 952
    //   952: aload 9
    //   954: ifnull +8 -> 962
    //   957: aload 9
    //   959: invokevirtual 245	java/io/InputStream:close	()V
    //   962: aload 5
    //   964: ifnull +16 -> 980
    //   967: aload 5
    //   969: invokevirtual 248	java/net/HttpURLConnection:disconnect	()V
    //   972: goto +8 -> 980
    //   975: aload 4
    //   977: invokevirtual 251	java/lang/Exception:printStackTrace	()V
    //   980: aconst_null
    //   981: areturn
    //   982: astore 10
    //   984: aconst_null
    //   985: astore 5
    //   987: aconst_null
    //   988: astore 9
    //   990: aconst_null
    //   991: astore 4
    //   993: aload 9
    //   995: astore 7
    //   997: aload 5
    //   999: astore 6
    //   1001: aload 4
    //   1003: astore 8
    //   1005: aload 10
    //   1007: invokevirtual 251	java/lang/Exception:printStackTrace	()V
    //   1010: aload 4
    //   1012: ifnull +11 -> 1023
    //   1015: aload 4
    //   1017: invokevirtual 209	java/io/DataInputStream:close	()V
    //   1020: goto +3 -> 1023
    //   1023: aload 9
    //   1025: ifnull +8 -> 1033
    //   1028: aload 9
    //   1030: invokevirtual 245	java/io/InputStream:close	()V
    //   1033: aload 5
    //   1035: ifnull +16 -> 1051
    //   1038: aload 5
    //   1040: invokevirtual 248	java/net/HttpURLConnection:disconnect	()V
    //   1043: goto +8 -> 1051
    //   1046: aload 4
    //   1048: invokevirtual 251	java/lang/Exception:printStackTrace	()V
    //   1051: aconst_null
    //   1052: areturn
    //   1053: astore 5
    //   1055: aload 8
    //   1057: astore 4
    //   1059: aload 5
    //   1061: astore 8
    //   1063: aload 6
    //   1065: astore 5
    //   1067: aload 8
    //   1069: astore 6
    //   1071: aload 4
    //   1073: ifnull +11 -> 1084
    //   1076: aload 4
    //   1078: invokevirtual 209	java/io/DataInputStream:close	()V
    //   1081: goto +3 -> 1084
    //   1084: aload 7
    //   1086: ifnull +8 -> 1094
    //   1089: aload 7
    //   1091: invokevirtual 245	java/io/InputStream:close	()V
    //   1094: aload 5
    //   1096: ifnull +16 -> 1112
    //   1099: aload 5
    //   1101: invokevirtual 248	java/net/HttpURLConnection:disconnect	()V
    //   1104: goto +8 -> 1112
    //   1107: aload 4
    //   1109: invokevirtual 251	java/lang/Exception:printStackTrace	()V
    //   1112: goto +6 -> 1118
    //   1115: aload 6
    //   1117: athrow
    //   1118: goto -3 -> 1115
    //   1121: astore 4
    //   1123: goto -291 -> 832
    //   1126: astore 4
    //   1128: goto -153 -> 975
    //   1131: astore 4
    //   1133: goto -87 -> 1046
    //   1136: astore 4
    //   1138: goto -31 -> 1107
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1141	0	this	UploadFileUtil
    //   342	404	1	i	int
    //   340	187	2	j	int
    //   505	12	3	k	int
    //   84	470	4	localObject1	Object
    //   558	7	4	localObject2	Object
    //   570	538	4	localObject3	Object
    //   1121	1	4	localException1	java.lang.Exception
    //   1126	1	4	localException2	java.lang.Exception
    //   1131	1	4	localException3	java.lang.Exception
    //   1136	1	4	localException4	java.lang.Exception
    //   23	1016	5	localHttpURLConnection	java.net.HttpURLConnection
    //   1053	7	5	localObject4	Object
    //   1065	35	5	localObject5	Object
    //   93	504	6	localObject6	Object
    //   601	1	6	localObject7	Object
    //   606	1	6	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   611	1	6	localException5	java.lang.Exception
    //   652	132	6	localObject8	Object
    //   850	1	6	localObject9	Object
    //   858	6	6	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   870	6	6	localException6	java.lang.Exception
    //   882	1	6	localObject10	Object
    //   897	1	6	localObject11	Object
    //   928	188	6	localObject12	Object
    //   73	496	7	localObject13	Object
    //   575	7	7	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   588	47	7	localException7	java.lang.Exception
    //   689	401	7	localObject14	Object
    //   124	944	8	localObject15	Object
    //   171	858	9	localObject16	Object
    //   185	653	10	localObject17	Object
    //   840	1	10	localOutOfMemoryError4	java.lang.OutOfMemoryError
    //   845	1	10	localException8	java.lang.Exception
    //   865	13	10	localObject18	Object
    //   887	1	10	localOutOfMemoryError5	java.lang.OutOfMemoryError
    //   892	1	10	localException9	java.lang.Exception
    //   911	24	10	localOutOfMemoryError6	java.lang.OutOfMemoryError
    //   982	24	10	localException10	java.lang.Exception
    //   379	59	11	str	String
    //   361	118	12	localObject19	Object
    // Exception table:
    //   from	to	target	type
    //   491	498	558	finally
    //   498	506	558	finally
    //   511	520	558	finally
    //   530	542	558	finally
    //   542	547	558	finally
    //   491	498	575	java/lang/OutOfMemoryError
    //   498	506	575	java/lang/OutOfMemoryError
    //   511	520	575	java/lang/OutOfMemoryError
    //   530	542	575	java/lang/OutOfMemoryError
    //   542	547	575	java/lang/OutOfMemoryError
    //   491	498	588	java/lang/Exception
    //   498	506	588	java/lang/Exception
    //   511	520	588	java/lang/Exception
    //   530	542	588	java/lang/Exception
    //   542	547	588	java/lang/Exception
    //   351	363	601	finally
    //   387	491	601	finally
    //   351	363	606	java/lang/OutOfMemoryError
    //   387	491	606	java/lang/OutOfMemoryError
    //   351	363	611	java/lang/Exception
    //   387	491	611	java/lang/Exception
    //   699	708	840	java/lang/OutOfMemoryError
    //   720	726	840	java/lang/OutOfMemoryError
    //   743	751	840	java/lang/OutOfMemoryError
    //   766	777	840	java/lang/OutOfMemoryError
    //   789	796	840	java/lang/OutOfMemoryError
    //   699	708	845	java/lang/Exception
    //   720	726	845	java/lang/Exception
    //   743	751	845	java/lang/Exception
    //   766	777	845	java/lang/Exception
    //   789	796	845	java/lang/Exception
    //   622	687	850	finally
    //   622	687	858	java/lang/OutOfMemoryError
    //   622	687	870	java/lang/Exception
    //   25	132	882	finally
    //   137	151	882	finally
    //   151	259	882	finally
    //   262	341	882	finally
    //   25	132	887	java/lang/OutOfMemoryError
    //   137	151	887	java/lang/OutOfMemoryError
    //   151	259	887	java/lang/OutOfMemoryError
    //   262	341	887	java/lang/OutOfMemoryError
    //   25	132	892	java/lang/Exception
    //   137	151	892	java/lang/Exception
    //   151	259	892	java/lang/Exception
    //   262	341	892	java/lang/Exception
    //   8	25	897	finally
    //   8	25	911	java/lang/OutOfMemoryError
    //   8	25	982	java/lang/Exception
    //   699	708	1053	finally
    //   720	726	1053	finally
    //   743	751	1053	finally
    //   766	777	1053	finally
    //   789	796	1053	finally
    //   934	939	1053	finally
    //   1005	1010	1053	finally
    //   801	806	1121	java/lang/Exception
    //   814	819	1121	java/lang/Exception
    //   824	829	1121	java/lang/Exception
    //   944	949	1126	java/lang/Exception
    //   957	962	1126	java/lang/Exception
    //   967	972	1126	java/lang/Exception
    //   1015	1020	1131	java/lang/Exception
    //   1028	1033	1131	java/lang/Exception
    //   1038	1043	1131	java/lang/Exception
    //   1076	1081	1136	java/lang/Exception
    //   1089	1094	1136	java/lang/Exception
    //   1099	1104	1136	java/lang/Exception
  }
  
  public void a(String paramString)
  {
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        return;
      }
      int i = this.f.size();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("file");
      ((StringBuilder)localObject).append(i);
      localObject = ((StringBuilder)localObject).toString();
      String str = paramString.substring(paramString.lastIndexOf("/") + 1);
      this.f.add(new String[] { localObject, str, "application/x-zip-compressed", paramString });
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString2 != null) && (paramString1.length() != 0))
    {
      if (paramString2.length() == 0) {
        return;
      }
      this.e.put(paramString1, paramString2);
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    this.d = paramJSONObject;
  }
  
  public void b(String paramString)
  {
    this.b = paramString;
    this.c = "27182818284590452353602874713526";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.debug.CIOSubmitUtils.UploadFileUtil
 * JD-Core Version:    0.7.0.1
 */