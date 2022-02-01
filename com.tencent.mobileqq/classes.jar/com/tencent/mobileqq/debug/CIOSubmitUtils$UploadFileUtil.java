package com.tencent.mobileqq.debug;

import android.content.Context;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONObject;

public class CIOSubmitUtils$UploadFileUtil
{
  Context jdField_a_of_type_AndroidContentContext;
  String jdField_a_of_type_JavaLangString;
  private ConcurrentHashMap<String, String> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private ConcurrentLinkedQueue<String[]> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  JSONObject jdField_a_of_type_OrgJsonJSONObject;
  String b;
  
  public CIOSubmitUtils$UploadFileUtil()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put("username", "JLLLCKCOAODOBJFK");
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put("password", "ALFLMLILPLBJFK");
  }
  
  public CIOSubmitUtils$UploadFileUtil(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  /* Error */
  public String a()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 13
    //   6: aconst_null
    //   7: astore 7
    //   9: aconst_null
    //   10: astore 11
    //   12: aconst_null
    //   13: astore 10
    //   15: aconst_null
    //   16: astore 14
    //   18: aconst_null
    //   19: astore 9
    //   21: aconst_null
    //   22: astore 6
    //   24: aconst_null
    //   25: astore 5
    //   27: aconst_null
    //   28: astore 12
    //   30: invokestatic 54	com/tencent/mobileqq/msf/sdk/AppNetConnInfo:isNetSupport	()Z
    //   33: ifne +5 -> 38
    //   36: aconst_null
    //   37: areturn
    //   38: new 56	java/net/URL
    //   41: dup
    //   42: ldc 58
    //   44: invokespecial 61	java/net/URL:<init>	(Ljava/lang/String;)V
    //   47: invokevirtual 65	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   50: checkcast 67	java/net/HttpURLConnection
    //   53: astore 4
    //   55: aload 6
    //   57: astore 8
    //   59: aload 5
    //   61: astore 7
    //   63: aload 4
    //   65: ldc 69
    //   67: ldc 71
    //   69: invokevirtual 75	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   72: aload 6
    //   74: astore 8
    //   76: aload 5
    //   78: astore 7
    //   80: aload 4
    //   82: ldc 77
    //   84: ldc 79
    //   86: invokevirtual 75	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   89: aload 6
    //   91: astore 8
    //   93: aload 5
    //   95: astore 7
    //   97: aload 4
    //   99: iconst_1
    //   100: invokevirtual 83	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   103: aload 6
    //   105: astore 8
    //   107: aload 5
    //   109: astore 7
    //   111: aload 4
    //   113: iconst_1
    //   114: invokevirtual 86	java/net/HttpURLConnection:setDoInput	(Z)V
    //   117: aload 6
    //   119: astore 8
    //   121: aload 5
    //   123: astore 7
    //   125: aload 4
    //   127: iconst_0
    //   128: invokevirtual 89	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   131: aload 6
    //   133: astore 8
    //   135: aload 5
    //   137: astore 7
    //   139: aload 4
    //   141: ldc 91
    //   143: invokevirtual 94	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   146: aload 6
    //   148: astore 8
    //   150: aload 5
    //   152: astore 7
    //   154: aload 4
    //   156: invokevirtual 98	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   159: astore 13
    //   161: aload 6
    //   163: astore 8
    //   165: aload 5
    //   167: astore 7
    //   169: new 100	java/lang/StringBuffer
    //   172: dup
    //   173: ldc 102
    //   175: invokespecial 103	java/lang/StringBuffer:<init>	(Ljava/lang/String;)V
    //   178: astore 17
    //   180: aload 6
    //   182: astore 8
    //   184: aload 5
    //   186: astore 7
    //   188: new 105	java/lang/StringBuilder
    //   191: dup
    //   192: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   195: ldc 108
    //   197: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: ldc 114
    //   202: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: ldc 116
    //   207: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   213: astore 14
    //   215: aload 6
    //   217: astore 8
    //   219: aload 5
    //   221: astore 7
    //   223: aload_0
    //   224: getfield 22	com/tencent/mobileqq/debug/CIOSubmitUtils$UploadFileUtil:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   227: ifnull +218 -> 445
    //   230: aload 6
    //   232: astore 8
    //   234: aload 5
    //   236: astore 7
    //   238: aload_0
    //   239: getfield 22	com/tencent/mobileqq/debug/CIOSubmitUtils$UploadFileUtil:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   242: invokevirtual 123	java/util/concurrent/ConcurrentHashMap:keySet	()Ljava/util/Set;
    //   245: invokeinterface 129 1 0
    //   250: astore 9
    //   252: aload 6
    //   254: astore 8
    //   256: aload 5
    //   258: astore 7
    //   260: aload 9
    //   262: invokeinterface 134 1 0
    //   267: ifeq +178 -> 445
    //   270: aload 6
    //   272: astore 8
    //   274: aload 5
    //   276: astore 7
    //   278: aload 9
    //   280: invokeinterface 138 1 0
    //   285: checkcast 140	java/lang/String
    //   288: astore 16
    //   290: aload 6
    //   292: astore 8
    //   294: aload 5
    //   296: astore 7
    //   298: aload_0
    //   299: getfield 22	com/tencent/mobileqq/debug/CIOSubmitUtils$UploadFileUtil:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   302: aload 16
    //   304: invokevirtual 144	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   307: checkcast 140	java/lang/String
    //   310: astore 15
    //   312: aload 6
    //   314: astore 8
    //   316: aload 5
    //   318: astore 7
    //   320: aload 17
    //   322: ldc 146
    //   324: invokevirtual 149	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   327: aload 16
    //   329: invokevirtual 149	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   332: ldc 151
    //   334: invokevirtual 149	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   337: ldc 102
    //   339: invokevirtual 149	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   342: aload 15
    //   344: invokevirtual 149	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   347: ldc 102
    //   349: invokevirtual 149	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   352: ldc 153
    //   354: invokevirtual 149	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   357: ldc 114
    //   359: invokevirtual 149	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   362: ldc 102
    //   364: invokevirtual 149	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   367: pop
    //   368: goto -116 -> 252
    //   371: astore 7
    //   373: aconst_null
    //   374: astore 5
    //   376: aconst_null
    //   377: astore 8
    //   379: aload 4
    //   381: astore 6
    //   383: aload 8
    //   385: astore 4
    //   387: aload 7
    //   389: invokevirtual 156	java/lang/Exception:printStackTrace	()V
    //   392: aload 4
    //   394: ifnull +8 -> 402
    //   397: aload 4
    //   399: invokevirtual 161	java/io/DataInputStream:close	()V
    //   402: iconst_0
    //   403: ifeq +11 -> 414
    //   406: new 163	java/lang/NullPointerException
    //   409: dup
    //   410: invokespecial 164	java/lang/NullPointerException:<init>	()V
    //   413: athrow
    //   414: aload 5
    //   416: ifnull +8 -> 424
    //   419: aload 5
    //   421: invokevirtual 167	java/io/InputStream:close	()V
    //   424: aload 6
    //   426: ifnull -390 -> 36
    //   429: aload 6
    //   431: invokevirtual 170	java/net/HttpURLConnection:disconnect	()V
    //   434: aconst_null
    //   435: areturn
    //   436: astore 4
    //   438: aload 4
    //   440: invokevirtual 156	java/lang/Exception:printStackTrace	()V
    //   443: aconst_null
    //   444: areturn
    //   445: aload 6
    //   447: astore 8
    //   449: aload 5
    //   451: astore 7
    //   453: aload 17
    //   455: invokevirtual 171	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   458: astore 9
    //   460: aload 6
    //   462: astore 8
    //   464: aload 5
    //   466: astore 7
    //   468: aload 13
    //   470: new 105	java/lang/StringBuilder
    //   473: dup
    //   474: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   477: ldc 153
    //   479: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   482: ldc 114
    //   484: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   487: aload 9
    //   489: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   492: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   495: ldc 173
    //   497: invokevirtual 177	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   500: invokevirtual 183	java/io/OutputStream:write	([B)V
    //   503: aload 6
    //   505: astore 8
    //   507: aload 5
    //   509: astore 7
    //   511: new 100	java/lang/StringBuffer
    //   514: dup
    //   515: invokespecial 184	java/lang/StringBuffer:<init>	()V
    //   518: astore 15
    //   520: aload 6
    //   522: astore 8
    //   524: aload 5
    //   526: astore 7
    //   528: aload_0
    //   529: getfield 27	com/tencent/mobileqq/debug/CIOSubmitUtils$UploadFileUtil:jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue	Ljava/util/concurrent/ConcurrentLinkedQueue;
    //   532: ifnull +821 -> 1353
    //   535: aload 6
    //   537: astore 8
    //   539: aload 5
    //   541: astore 7
    //   543: aload_0
    //   544: getfield 27	com/tencent/mobileqq/debug/CIOSubmitUtils$UploadFileUtil:jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue	Ljava/util/concurrent/ConcurrentLinkedQueue;
    //   547: invokevirtual 188	java/util/concurrent/ConcurrentLinkedQueue:size	()I
    //   550: istore_2
    //   551: iconst_0
    //   552: istore_1
    //   553: aload 12
    //   555: astore 5
    //   557: iload_1
    //   558: iload_2
    //   559: if_icmpge +824 -> 1383
    //   562: aload 5
    //   564: astore 8
    //   566: aload 5
    //   568: astore 7
    //   570: aload_0
    //   571: getfield 27	com/tencent/mobileqq/debug/CIOSubmitUtils$UploadFileUtil:jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue	Ljava/util/concurrent/ConcurrentLinkedQueue;
    //   574: invokevirtual 191	java/util/concurrent/ConcurrentLinkedQueue:poll	()Ljava/lang/Object;
    //   577: checkcast 193	[Ljava/lang/String;
    //   580: astore 16
    //   582: aload 16
    //   584: iconst_0
    //   585: aaload
    //   586: astore 9
    //   588: aload 16
    //   590: iconst_1
    //   591: aaload
    //   592: astore 12
    //   594: aload 16
    //   596: iconst_2
    //   597: aaload
    //   598: astore 6
    //   600: aload 16
    //   602: iconst_3
    //   603: aaload
    //   604: astore 16
    //   606: aload 5
    //   608: astore 8
    //   610: aload 5
    //   612: astore 7
    //   614: aload 15
    //   616: ldc 146
    //   618: invokevirtual 149	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   621: aload 9
    //   623: invokevirtual 149	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   626: ldc 195
    //   628: invokevirtual 149	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   631: aload 12
    //   633: invokevirtual 149	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   636: ldc 151
    //   638: invokevirtual 149	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   641: ldc 197
    //   643: invokevirtual 149	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   646: aload 6
    //   648: invokevirtual 149	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   651: ldc 199
    //   653: invokevirtual 149	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   656: pop
    //   657: aload 5
    //   659: astore 8
    //   661: aload 5
    //   663: astore 7
    //   665: aload 13
    //   667: aload 15
    //   669: invokevirtual 171	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   672: ldc 173
    //   674: invokevirtual 177	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   677: invokevirtual 183	java/io/OutputStream:write	([B)V
    //   680: aload 5
    //   682: astore 8
    //   684: aload 5
    //   686: astore 7
    //   688: new 158	java/io/DataInputStream
    //   691: dup
    //   692: new 201	java/io/FileInputStream
    //   695: dup
    //   696: new 203	java/io/File
    //   699: dup
    //   700: aload 16
    //   702: invokespecial 204	java/io/File:<init>	(Ljava/lang/String;)V
    //   705: invokespecial 207	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   708: invokespecial 210	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   711: astore 6
    //   713: aload 6
    //   715: astore 9
    //   717: aload 6
    //   719: astore 8
    //   721: aload 6
    //   723: astore 7
    //   725: sipush 5120
    //   728: newarray byte
    //   730: astore 5
    //   732: aload 6
    //   734: astore 9
    //   736: aload 6
    //   738: astore 8
    //   740: aload 6
    //   742: astore 7
    //   744: aload 6
    //   746: aload 5
    //   748: invokevirtual 214	java/io/DataInputStream:read	([B)I
    //   751: istore_3
    //   752: iload_3
    //   753: iconst_m1
    //   754: if_icmpeq +27 -> 781
    //   757: aload 6
    //   759: astore 9
    //   761: aload 6
    //   763: astore 8
    //   765: aload 6
    //   767: astore 7
    //   769: aload 13
    //   771: aload 5
    //   773: iconst_0
    //   774: iload_3
    //   775: invokevirtual 217	java/io/OutputStream:write	([BII)V
    //   778: goto -46 -> 732
    //   781: iload_1
    //   782: iload_2
    //   783: iconst_1
    //   784: isub
    //   785: if_icmpge +27 -> 812
    //   788: aload 6
    //   790: astore 9
    //   792: aload 6
    //   794: astore 8
    //   796: aload 6
    //   798: astore 7
    //   800: aload 13
    //   802: aload 14
    //   804: ldc 173
    //   806: invokevirtual 177	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   809: invokevirtual 183	java/io/OutputStream:write	([B)V
    //   812: aload 6
    //   814: astore 9
    //   816: aload 6
    //   818: astore 8
    //   820: aload 6
    //   822: astore 7
    //   824: aload 6
    //   826: invokevirtual 161	java/io/DataInputStream:close	()V
    //   829: iload_1
    //   830: iconst_1
    //   831: iadd
    //   832: istore_1
    //   833: aload 6
    //   835: astore 5
    //   837: goto -280 -> 557
    //   840: aload 5
    //   842: astore 9
    //   844: aload 5
    //   846: astore 8
    //   848: aload 5
    //   850: astore 7
    //   852: aload 13
    //   854: aload 14
    //   856: ldc 173
    //   858: invokevirtual 177	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   861: invokevirtual 183	java/io/OutputStream:write	([B)V
    //   864: aload 5
    //   866: astore 9
    //   868: aload 5
    //   870: astore 8
    //   872: aload 5
    //   874: astore 7
    //   876: aload 13
    //   878: invokevirtual 218	java/io/OutputStream:close	()V
    //   881: aload 5
    //   883: astore 9
    //   885: aload 5
    //   887: astore 8
    //   889: aload 5
    //   891: astore 7
    //   893: aload 4
    //   895: invokevirtual 221	java/net/HttpURLConnection:getResponseCode	()I
    //   898: istore_1
    //   899: aload 5
    //   901: astore 9
    //   903: aload 5
    //   905: astore 8
    //   907: aload 5
    //   909: astore 7
    //   911: ldc 223
    //   913: iconst_2
    //   914: new 105	java/lang/StringBuilder
    //   917: dup
    //   918: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   921: ldc 225
    //   923: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   926: iload_1
    //   927: invokevirtual 228	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   930: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   933: invokestatic 234	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   936: aload 5
    //   938: astore 9
    //   940: aload 5
    //   942: astore 8
    //   944: aload 5
    //   946: astore 7
    //   948: aload 4
    //   950: invokevirtual 238	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   953: astore 6
    //   955: new 100	java/lang/StringBuffer
    //   958: dup
    //   959: invokespecial 184	java/lang/StringBuffer:<init>	()V
    //   962: astore 7
    //   964: aload 6
    //   966: invokevirtual 240	java/io/InputStream:read	()I
    //   969: istore_1
    //   970: iload_1
    //   971: iconst_m1
    //   972: if_icmpeq +14 -> 986
    //   975: aload 7
    //   977: iload_1
    //   978: i2c
    //   979: invokevirtual 243	java/lang/StringBuffer:append	(C)Ljava/lang/StringBuffer;
    //   982: pop
    //   983: goto -19 -> 964
    //   986: ldc 245
    //   988: aload 7
    //   990: invokevirtual 171	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   993: invokestatic 251	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   996: pop
    //   997: aload 7
    //   999: invokevirtual 171	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   1002: astore 7
    //   1004: aload 5
    //   1006: ifnull +8 -> 1014
    //   1009: aload 5
    //   1011: invokevirtual 161	java/io/DataInputStream:close	()V
    //   1014: iconst_0
    //   1015: ifeq +11 -> 1026
    //   1018: new 163	java/lang/NullPointerException
    //   1021: dup
    //   1022: invokespecial 164	java/lang/NullPointerException:<init>	()V
    //   1025: athrow
    //   1026: aload 6
    //   1028: ifnull +8 -> 1036
    //   1031: aload 6
    //   1033: invokevirtual 167	java/io/InputStream:close	()V
    //   1036: aload 4
    //   1038: ifnull +8 -> 1046
    //   1041: aload 4
    //   1043: invokevirtual 170	java/net/HttpURLConnection:disconnect	()V
    //   1046: aload 7
    //   1048: areturn
    //   1049: astore 4
    //   1051: aload 4
    //   1053: invokevirtual 156	java/lang/Exception:printStackTrace	()V
    //   1056: goto -10 -> 1046
    //   1059: astore 6
    //   1061: aload 14
    //   1063: astore 5
    //   1065: aload 13
    //   1067: astore 4
    //   1069: aload 4
    //   1071: astore 8
    //   1073: aload 5
    //   1075: astore 9
    //   1077: aload 10
    //   1079: astore 7
    //   1081: aload 6
    //   1083: invokevirtual 252	java/lang/OutOfMemoryError:printStackTrace	()V
    //   1086: aload 5
    //   1088: ifnull +8 -> 1096
    //   1091: aload 5
    //   1093: invokevirtual 161	java/io/DataInputStream:close	()V
    //   1096: iconst_0
    //   1097: ifeq +11 -> 1108
    //   1100: new 163	java/lang/NullPointerException
    //   1103: dup
    //   1104: invokespecial 164	java/lang/NullPointerException:<init>	()V
    //   1107: athrow
    //   1108: aload 10
    //   1110: ifnull +8 -> 1118
    //   1113: aload 10
    //   1115: invokevirtual 167	java/io/InputStream:close	()V
    //   1118: aload 4
    //   1120: ifnull -1084 -> 36
    //   1123: aload 4
    //   1125: invokevirtual 170	java/net/HttpURLConnection:disconnect	()V
    //   1128: aconst_null
    //   1129: areturn
    //   1130: astore 4
    //   1132: aload 4
    //   1134: invokevirtual 156	java/lang/Exception:printStackTrace	()V
    //   1137: aconst_null
    //   1138: areturn
    //   1139: astore 4
    //   1141: aload 9
    //   1143: astore 6
    //   1145: aload 8
    //   1147: astore 5
    //   1149: aload 6
    //   1151: ifnull +8 -> 1159
    //   1154: aload 6
    //   1156: invokevirtual 161	java/io/DataInputStream:close	()V
    //   1159: iconst_0
    //   1160: ifeq +11 -> 1171
    //   1163: new 163	java/lang/NullPointerException
    //   1166: dup
    //   1167: invokespecial 164	java/lang/NullPointerException:<init>	()V
    //   1170: athrow
    //   1171: aload 7
    //   1173: ifnull +8 -> 1181
    //   1176: aload 7
    //   1178: invokevirtual 167	java/io/InputStream:close	()V
    //   1181: aload 5
    //   1183: ifnull +8 -> 1191
    //   1186: aload 5
    //   1188: invokevirtual 170	java/net/HttpURLConnection:disconnect	()V
    //   1191: aload 4
    //   1193: athrow
    //   1194: astore 5
    //   1196: aload 5
    //   1198: invokevirtual 156	java/lang/Exception:printStackTrace	()V
    //   1201: goto -10 -> 1191
    //   1204: astore 6
    //   1206: aload 4
    //   1208: astore 5
    //   1210: aload 6
    //   1212: astore 4
    //   1214: aload 8
    //   1216: astore 6
    //   1218: aload 11
    //   1220: astore 7
    //   1222: goto -73 -> 1149
    //   1225: astore 7
    //   1227: aload 9
    //   1229: astore 6
    //   1231: aload 4
    //   1233: astore 5
    //   1235: aload 7
    //   1237: astore 4
    //   1239: aload 11
    //   1241: astore 7
    //   1243: goto -94 -> 1149
    //   1246: astore 8
    //   1248: aload 6
    //   1250: astore 7
    //   1252: aload 5
    //   1254: astore 6
    //   1256: aload 4
    //   1258: astore 5
    //   1260: aload 8
    //   1262: astore 4
    //   1264: goto -115 -> 1149
    //   1267: astore 8
    //   1269: aload 5
    //   1271: astore 7
    //   1273: aload 6
    //   1275: astore 5
    //   1277: aload 4
    //   1279: astore 6
    //   1281: aload 8
    //   1283: astore 4
    //   1285: goto -136 -> 1149
    //   1288: astore 6
    //   1290: aload 7
    //   1292: astore 5
    //   1294: goto -225 -> 1069
    //   1297: astore 6
    //   1299: aload 8
    //   1301: astore 5
    //   1303: goto -234 -> 1069
    //   1306: astore 7
    //   1308: aload 6
    //   1310: astore 10
    //   1312: aload 7
    //   1314: astore 6
    //   1316: goto -247 -> 1069
    //   1319: astore 7
    //   1321: aconst_null
    //   1322: astore 5
    //   1324: aconst_null
    //   1325: astore 6
    //   1327: aconst_null
    //   1328: astore 4
    //   1330: goto -943 -> 387
    //   1333: astore 7
    //   1335: aconst_null
    //   1336: astore 8
    //   1338: aload 4
    //   1340: astore 6
    //   1342: aload 5
    //   1344: astore 4
    //   1346: aload 8
    //   1348: astore 5
    //   1350: goto -963 -> 387
    //   1353: aconst_null
    //   1354: astore 5
    //   1356: goto -516 -> 840
    //   1359: astore 5
    //   1361: aload 4
    //   1363: astore 6
    //   1365: aload 7
    //   1367: astore 4
    //   1369: aconst_null
    //   1370: astore 8
    //   1372: aload 5
    //   1374: astore 7
    //   1376: aload 8
    //   1378: astore 5
    //   1380: goto -993 -> 387
    //   1383: goto -543 -> 840
    //   1386: astore 7
    //   1388: aload 6
    //   1390: astore 8
    //   1392: aload 4
    //   1394: astore 6
    //   1396: aload 5
    //   1398: astore 4
    //   1400: aload 8
    //   1402: astore 5
    //   1404: goto -1017 -> 387
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1407	0	this	UploadFileUtil
    //   552	426	1	i	int
    //   550	235	2	j	int
    //   751	24	3	k	int
    //   53	345	4	localObject1	Object
    //   436	606	4	localException1	java.lang.Exception
    //   1049	3	4	localException2	java.lang.Exception
    //   1067	57	4	localOutputStream1	java.io.OutputStream
    //   1130	3	4	localException3	java.lang.Exception
    //   1139	68	4	localObject2	Object
    //   1212	187	4	localObject3	Object
    //   25	1162	5	localObject4	Object
    //   1194	3	5	localException4	java.lang.Exception
    //   1208	147	5	localObject5	Object
    //   1359	14	5	localException5	java.lang.Exception
    //   1378	25	5	localObject6	Object
    //   22	1010	6	localObject7	Object
    //   1059	23	6	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   1143	12	6	localObject8	Object
    //   1204	7	6	localObject9	Object
    //   1216	64	6	localObject10	Object
    //   1288	1	6	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   1297	12	6	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   1314	81	6	localObject11	Object
    //   7	312	7	localObject12	Object
    //   371	17	7	localException6	java.lang.Exception
    //   451	770	7	localObject13	Object
    //   1225	11	7	localObject14	Object
    //   1241	50	7	localObject15	Object
    //   1306	7	7	localOutOfMemoryError4	java.lang.OutOfMemoryError
    //   1319	1	7	localException7	java.lang.Exception
    //   1333	33	7	localException8	java.lang.Exception
    //   1374	1	7	localObject16	Object
    //   1386	1	7	localException9	java.lang.Exception
    //   1	1214	8	localObject17	Object
    //   1246	15	8	localObject18	Object
    //   1267	33	8	localObject19	Object
    //   1336	65	8	localObject20	Object
    //   19	1209	9	localObject21	Object
    //   13	1298	10	localObject22	Object
    //   10	1230	11	localObject23	Object
    //   28	604	12	str1	String
    //   4	1062	13	localOutputStream2	java.io.OutputStream
    //   16	1046	14	str2	String
    //   310	358	15	localObject24	Object
    //   288	413	16	localObject25	Object
    //   178	276	17	localStringBuffer	java.lang.StringBuffer
    // Exception table:
    //   from	to	target	type
    //   63	72	371	java/lang/Exception
    //   80	89	371	java/lang/Exception
    //   97	103	371	java/lang/Exception
    //   111	117	371	java/lang/Exception
    //   125	131	371	java/lang/Exception
    //   139	146	371	java/lang/Exception
    //   154	161	371	java/lang/Exception
    //   169	180	371	java/lang/Exception
    //   188	215	371	java/lang/Exception
    //   223	230	371	java/lang/Exception
    //   238	252	371	java/lang/Exception
    //   260	270	371	java/lang/Exception
    //   278	290	371	java/lang/Exception
    //   298	312	371	java/lang/Exception
    //   320	368	371	java/lang/Exception
    //   453	460	371	java/lang/Exception
    //   468	503	371	java/lang/Exception
    //   511	520	371	java/lang/Exception
    //   528	535	371	java/lang/Exception
    //   543	551	371	java/lang/Exception
    //   397	402	436	java/lang/Exception
    //   406	414	436	java/lang/Exception
    //   419	424	436	java/lang/Exception
    //   429	434	436	java/lang/Exception
    //   1009	1014	1049	java/lang/Exception
    //   1018	1026	1049	java/lang/Exception
    //   1031	1036	1049	java/lang/Exception
    //   1041	1046	1049	java/lang/Exception
    //   38	55	1059	java/lang/OutOfMemoryError
    //   1091	1096	1130	java/lang/Exception
    //   1100	1108	1130	java/lang/Exception
    //   1113	1118	1130	java/lang/Exception
    //   1123	1128	1130	java/lang/Exception
    //   38	55	1139	finally
    //   1081	1086	1139	finally
    //   1154	1159	1194	java/lang/Exception
    //   1163	1171	1194	java/lang/Exception
    //   1176	1181	1194	java/lang/Exception
    //   1186	1191	1194	java/lang/Exception
    //   63	72	1204	finally
    //   80	89	1204	finally
    //   97	103	1204	finally
    //   111	117	1204	finally
    //   125	131	1204	finally
    //   139	146	1204	finally
    //   154	161	1204	finally
    //   169	180	1204	finally
    //   188	215	1204	finally
    //   223	230	1204	finally
    //   238	252	1204	finally
    //   260	270	1204	finally
    //   278	290	1204	finally
    //   298	312	1204	finally
    //   320	368	1204	finally
    //   453	460	1204	finally
    //   468	503	1204	finally
    //   511	520	1204	finally
    //   528	535	1204	finally
    //   543	551	1204	finally
    //   570	582	1204	finally
    //   614	657	1204	finally
    //   665	680	1204	finally
    //   688	713	1204	finally
    //   725	732	1225	finally
    //   744	752	1225	finally
    //   769	778	1225	finally
    //   800	812	1225	finally
    //   824	829	1225	finally
    //   852	864	1225	finally
    //   876	881	1225	finally
    //   893	899	1225	finally
    //   911	936	1225	finally
    //   948	955	1225	finally
    //   955	964	1246	finally
    //   964	970	1246	finally
    //   975	983	1246	finally
    //   986	1004	1246	finally
    //   387	392	1267	finally
    //   63	72	1288	java/lang/OutOfMemoryError
    //   80	89	1288	java/lang/OutOfMemoryError
    //   97	103	1288	java/lang/OutOfMemoryError
    //   111	117	1288	java/lang/OutOfMemoryError
    //   125	131	1288	java/lang/OutOfMemoryError
    //   139	146	1288	java/lang/OutOfMemoryError
    //   154	161	1288	java/lang/OutOfMemoryError
    //   169	180	1288	java/lang/OutOfMemoryError
    //   188	215	1288	java/lang/OutOfMemoryError
    //   223	230	1288	java/lang/OutOfMemoryError
    //   238	252	1288	java/lang/OutOfMemoryError
    //   260	270	1288	java/lang/OutOfMemoryError
    //   278	290	1288	java/lang/OutOfMemoryError
    //   298	312	1288	java/lang/OutOfMemoryError
    //   320	368	1288	java/lang/OutOfMemoryError
    //   453	460	1288	java/lang/OutOfMemoryError
    //   468	503	1288	java/lang/OutOfMemoryError
    //   511	520	1288	java/lang/OutOfMemoryError
    //   528	535	1288	java/lang/OutOfMemoryError
    //   543	551	1288	java/lang/OutOfMemoryError
    //   570	582	1288	java/lang/OutOfMemoryError
    //   614	657	1288	java/lang/OutOfMemoryError
    //   665	680	1288	java/lang/OutOfMemoryError
    //   688	713	1288	java/lang/OutOfMemoryError
    //   725	732	1297	java/lang/OutOfMemoryError
    //   744	752	1297	java/lang/OutOfMemoryError
    //   769	778	1297	java/lang/OutOfMemoryError
    //   800	812	1297	java/lang/OutOfMemoryError
    //   824	829	1297	java/lang/OutOfMemoryError
    //   852	864	1297	java/lang/OutOfMemoryError
    //   876	881	1297	java/lang/OutOfMemoryError
    //   893	899	1297	java/lang/OutOfMemoryError
    //   911	936	1297	java/lang/OutOfMemoryError
    //   948	955	1297	java/lang/OutOfMemoryError
    //   955	964	1306	java/lang/OutOfMemoryError
    //   964	970	1306	java/lang/OutOfMemoryError
    //   975	983	1306	java/lang/OutOfMemoryError
    //   986	1004	1306	java/lang/OutOfMemoryError
    //   38	55	1319	java/lang/Exception
    //   570	582	1333	java/lang/Exception
    //   614	657	1333	java/lang/Exception
    //   665	680	1333	java/lang/Exception
    //   688	713	1333	java/lang/Exception
    //   725	732	1359	java/lang/Exception
    //   744	752	1359	java/lang/Exception
    //   769	778	1359	java/lang/Exception
    //   800	812	1359	java/lang/Exception
    //   824	829	1359	java/lang/Exception
    //   852	864	1359	java/lang/Exception
    //   876	881	1359	java/lang/Exception
    //   893	899	1359	java/lang/Exception
    //   911	936	1359	java/lang/Exception
    //   948	955	1359	java/lang/Exception
    //   955	964	1386	java/lang/Exception
    //   964	970	1386	java/lang/Exception
    //   975	983	1386	java/lang/Exception
    //   986	1004	1386	java/lang/Exception
  }
  
  public void a(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return;
    }
    int i = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size();
    String str1 = "file" + i;
    String str2 = paramString.substring(paramString.lastIndexOf("/") + 1);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(new String[] { str1, str2, "application/x-zip-compressed", paramString });
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null) || (paramString1.length() == 0) || (paramString2.length() == 0)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString1, paramString2);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_OrgJsonJSONObject = paramJSONObject;
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.b = "27182818284590452353602874713526";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.debug.CIOSubmitUtils.UploadFileUtil
 * JD-Core Version:    0.7.0.1
 */