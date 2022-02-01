package com.tencent.mobileqq.teamwork;

import android.text.TextUtils;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.qphone.base.util.QLog;
import java.net.URLEncoder;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public class TeamWorkHttpUtils
{
  private static long a()
  {
    boolean bool = SystemUtil.a();
    long l1 = SystemUtil.b();
    long l2 = SystemUtil.c();
    if ((bool) && (l1 != 0L)) {
      return l1 * 1024L;
    }
    return l2 * 1024L;
  }
  
  /* Error */
  public static final String a(com.tencent.common.app.AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 35	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +1273 -> 1277
    //   7: aload 5
    //   9: invokestatic 35	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   12: ifne +1265 -> 1277
    //   15: aload_0
    //   16: ifnonnull +6 -> 22
    //   19: goto +1258 -> 1277
    //   22: aload_0
    //   23: ldc 37
    //   25: invokestatic 43	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   28: checkcast 37	com/tencent/mobileqq/teamwork/api/ITeamWorkFacadeCreator
    //   31: invokeinterface 47 1 0
    //   36: invokevirtual 53	com/tencent/common/app/AppInterface:getBusinessHandler	(Ljava/lang/String;)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   39: checkcast 55	com/tencent/mobileqq/teamwork/api/ITeamWorkFileExportHandler
    //   42: astore 15
    //   44: new 57	java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   51: astore 14
    //   53: aload 14
    //   55: aload_1
    //   56: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: pop
    //   60: aload 14
    //   62: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: astore 16
    //   67: new 67	com/tencent/mobileqq/teamwork/CustomX509TrustManager
    //   70: dup
    //   71: invokespecial 68	com/tencent/mobileqq/teamwork/CustomX509TrustManager:<init>	()V
    //   74: astore_1
    //   75: ldc 70
    //   77: invokestatic 76	javax/net/ssl/SSLContext:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    //   80: astore 14
    //   82: aload 14
    //   84: aconst_null
    //   85: iconst_1
    //   86: anewarray 78	javax/net/ssl/TrustManager
    //   89: dup
    //   90: iconst_0
    //   91: aload_1
    //   92: aastore
    //   93: aconst_null
    //   94: invokevirtual 82	javax/net/ssl/SSLContext:init	([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Ljava/security/SecureRandom;)V
    //   97: new 84	com/tencent/mobileqq/teamwork/NoSSLv3SocketFactory
    //   100: dup
    //   101: aload 14
    //   103: invokevirtual 88	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   106: invokespecial 91	com/tencent/mobileqq/teamwork/NoSSLv3SocketFactory:<init>	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   109: astore 17
    //   111: aload 17
    //   113: invokestatic 96	javax/net/ssl/HttpsURLConnection:setDefaultSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   116: new 98	java/net/URL
    //   119: dup
    //   120: aload 16
    //   122: invokespecial 101	java/net/URL:<init>	(Ljava/lang/String;)V
    //   125: invokevirtual 105	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   128: checkcast 93	javax/net/ssl/HttpsURLConnection
    //   131: astore_1
    //   132: aload_1
    //   133: astore 14
    //   135: aload_1
    //   136: aload 17
    //   138: invokevirtual 108	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   141: aload_1
    //   142: astore 14
    //   144: aload_1
    //   145: sipush 5000
    //   148: invokevirtual 112	javax/net/ssl/HttpsURLConnection:setConnectTimeout	(I)V
    //   151: aload_1
    //   152: astore 14
    //   154: aload_1
    //   155: sipush 30000
    //   158: invokevirtual 115	javax/net/ssl/HttpsURLConnection:setReadTimeout	(I)V
    //   161: aload_1
    //   162: astore 14
    //   164: aload_1
    //   165: iconst_1
    //   166: invokevirtual 119	javax/net/ssl/HttpsURLConnection:setDoInput	(Z)V
    //   169: aload_1
    //   170: astore 14
    //   172: aload_1
    //   173: iconst_0
    //   174: invokevirtual 122	javax/net/ssl/HttpsURLConnection:setUseCaches	(Z)V
    //   177: aload_1
    //   178: astore 14
    //   180: aload_1
    //   181: ldc 124
    //   183: invokevirtual 127	javax/net/ssl/HttpsURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   186: aload_1
    //   187: astore 14
    //   189: aload_1
    //   190: ldc 129
    //   192: ldc 131
    //   194: invokevirtual 135	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   197: aload_1
    //   198: astore 14
    //   200: new 57	java/lang/StringBuilder
    //   203: dup
    //   204: ldc 137
    //   206: invokespecial 138	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   209: astore 17
    //   211: aload_1
    //   212: astore 14
    //   214: aload 17
    //   216: ldc 140
    //   218: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: pop
    //   222: aload_1
    //   223: astore 14
    //   225: aload 17
    //   227: getstatic 146	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   230: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: pop
    //   234: aload_1
    //   235: astore 14
    //   237: aload 17
    //   239: ldc 140
    //   241: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: pop
    //   245: aload_1
    //   246: astore 14
    //   248: aload 17
    //   250: getstatic 151	android/os/Build:DEVICE	Ljava/lang/String;
    //   253: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: pop
    //   257: aload_1
    //   258: astore 14
    //   260: aload 17
    //   262: ldc 140
    //   264: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: pop
    //   268: aload_1
    //   269: astore 14
    //   271: aload 17
    //   273: getstatic 154	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   276: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: pop
    //   280: aload_1
    //   281: astore 14
    //   283: aload 17
    //   285: ldc 140
    //   287: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: pop
    //   291: aload_1
    //   292: astore 14
    //   294: aload 17
    //   296: ldc 156
    //   298: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: pop
    //   302: aload_1
    //   303: astore 14
    //   305: aload 17
    //   307: ldc 140
    //   309: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: pop
    //   313: aload_1
    //   314: astore 14
    //   316: aload 17
    //   318: ldc 158
    //   320: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: pop
    //   324: aload_1
    //   325: astore 14
    //   327: aload 17
    //   329: ldc 160
    //   331: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   334: pop
    //   335: aload_1
    //   336: astore 14
    //   338: aload_1
    //   339: ldc 162
    //   341: aload 17
    //   343: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   346: invokevirtual 135	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   349: aload_1
    //   350: astore 14
    //   352: aload_1
    //   353: ldc 164
    //   355: ldc 166
    //   357: invokevirtual 135	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   360: aload_1
    //   361: astore 14
    //   363: new 57	java/lang/StringBuilder
    //   366: dup
    //   367: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   370: astore 17
    //   372: aload_1
    //   373: astore 14
    //   375: aload 17
    //   377: ldc 168
    //   379: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   382: pop
    //   383: aload_1
    //   384: astore 14
    //   386: aload 17
    //   388: ldc 170
    //   390: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: pop
    //   394: aload_1
    //   395: astore 14
    //   397: aload_1
    //   398: ldc 172
    //   400: aload 17
    //   402: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   405: invokevirtual 135	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   408: aload_1
    //   409: astore 14
    //   411: new 174	java/util/HashMap
    //   414: dup
    //   415: invokespecial 175	java/util/HashMap:<init>	()V
    //   418: astore 17
    //   420: aload_1
    //   421: astore 14
    //   423: aload 17
    //   425: ldc 129
    //   427: ldc 177
    //   429: invokeinterface 183 3 0
    //   434: pop
    //   435: aload_1
    //   436: astore 14
    //   438: aload 17
    //   440: ldc 185
    //   442: aload_3
    //   443: invokeinterface 183 3 0
    //   448: pop
    //   449: aload_1
    //   450: astore 14
    //   452: aload_0
    //   453: iconst_2
    //   454: invokevirtual 189	com/tencent/common/app/AppInterface:getManager	(I)Lmqq/manager/Manager;
    //   457: checkcast 191	mqq/manager/TicketManager
    //   460: astore_0
    //   461: aload_1
    //   462: astore 14
    //   464: aload_0
    //   465: aload 5
    //   467: invokeinterface 195 2 0
    //   472: pop
    //   473: aload_1
    //   474: astore 14
    //   476: aload 16
    //   478: invokestatic 35	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   481: ifne +859 -> 1340
    //   484: aload_1
    //   485: astore 14
    //   487: aload_0
    //   488: aload 5
    //   490: ldc 197
    //   492: invokeinterface 201 3 0
    //   497: astore_0
    //   498: goto +3 -> 501
    //   501: aload_1
    //   502: astore 14
    //   504: aload_0
    //   505: invokestatic 35	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   508: ifeq +47 -> 555
    //   511: aload_1
    //   512: astore 14
    //   514: ldc 203
    //   516: iconst_1
    //   517: ldc 205
    //   519: invokestatic 211	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   522: aload_1
    //   523: astore 14
    //   525: invokestatic 216	com/tencent/smtt/sdk/CookieManager:getInstance	()Lcom/tencent/smtt/sdk/CookieManager;
    //   528: astore_0
    //   529: aload_0
    //   530: ifnull +60 -> 590
    //   533: aload_1
    //   534: astore 14
    //   536: aload 17
    //   538: ldc 218
    //   540: aload_0
    //   541: aload 16
    //   543: invokevirtual 221	com/tencent/smtt/sdk/CookieManager:getCookie	(Ljava/lang/String;)Ljava/lang/String;
    //   546: invokeinterface 183 3 0
    //   551: pop
    //   552: goto +38 -> 590
    //   555: aload 4
    //   557: ifnonnull +788 -> 1345
    //   560: ldc 223
    //   562: astore_0
    //   563: goto +3 -> 566
    //   566: aload_1
    //   567: astore 14
    //   569: aload 17
    //   571: ldc 225
    //   573: new 57	java/lang/StringBuilder
    //   576: dup
    //   577: aload_0
    //   578: invokespecial 138	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   581: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   584: invokeinterface 183 3 0
    //   589: pop
    //   590: aload_1
    //   591: astore 14
    //   593: aload 17
    //   595: invokeinterface 229 1 0
    //   600: invokeinterface 235 1 0
    //   605: astore_0
    //   606: aload_1
    //   607: astore 14
    //   609: aload_0
    //   610: invokeinterface 240 1 0
    //   615: ifeq +47 -> 662
    //   618: aload_1
    //   619: astore 14
    //   621: aload_0
    //   622: invokeinterface 244 1 0
    //   627: checkcast 246	java/util/Map$Entry
    //   630: astore 4
    //   632: aload_1
    //   633: astore 14
    //   635: aload_1
    //   636: aload 4
    //   638: invokeinterface 249 1 0
    //   643: checkcast 251	java/lang/String
    //   646: aload 4
    //   648: invokeinterface 254 1 0
    //   653: checkcast 251	java/lang/String
    //   656: invokevirtual 135	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   659: goto -53 -> 606
    //   662: aload_1
    //   663: astore 14
    //   665: aload_1
    //   666: invokevirtual 257	javax/net/ssl/HttpsURLConnection:connect	()V
    //   669: aload_1
    //   670: astore 14
    //   672: aload_1
    //   673: invokevirtual 261	javax/net/ssl/HttpsURLConnection:getContentLength	()I
    //   676: istore 8
    //   678: aload_1
    //   679: astore 14
    //   681: invokestatic 263	com/tencent/mobileqq/teamwork/TeamWorkHttpUtils:a	()J
    //   684: lstore 10
    //   686: iload 8
    //   688: i2l
    //   689: lload 10
    //   691: lcmp
    //   692: ifle +35 -> 727
    //   695: aload_1
    //   696: astore 14
    //   698: aload 15
    //   700: iconst_1
    //   701: iconst_1
    //   702: iconst_2
    //   703: anewarray 4	java/lang/Object
    //   706: dup
    //   707: iconst_0
    //   708: ldc_w 264
    //   711: invokestatic 269	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   714: aastore
    //   715: dup
    //   716: iconst_1
    //   717: aload_3
    //   718: aastore
    //   719: invokeinterface 273 4 0
    //   724: goto +635 -> 1359
    //   727: aload_1
    //   728: astore 14
    //   730: aload_1
    //   731: invokevirtual 277	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   734: astore 5
    //   736: aload_1
    //   737: astore 14
    //   739: new 279	java/io/ByteArrayOutputStream
    //   742: dup
    //   743: invokespecial 280	java/io/ByteArrayOutputStream:<init>	()V
    //   746: astore 16
    //   748: sipush 10240
    //   751: newarray byte
    //   753: astore_0
    //   754: lconst_0
    //   755: lstore 10
    //   757: iconst_0
    //   758: istore 6
    //   760: aload 5
    //   762: aload_0
    //   763: invokevirtual 286	java/io/InputStream:read	([B)I
    //   766: istore 9
    //   768: iload 9
    //   770: iconst_m1
    //   771: if_icmpeq +78 -> 849
    //   774: iload 6
    //   776: iload 9
    //   778: iadd
    //   779: istore 7
    //   781: aload 16
    //   783: aload_0
    //   784: iconst_0
    //   785: iload 9
    //   787: invokevirtual 290	java/io/ByteArrayOutputStream:write	([BII)V
    //   790: invokestatic 295	java/lang/System:currentTimeMillis	()J
    //   793: lstore 12
    //   795: iload 7
    //   797: istore 6
    //   799: lload 12
    //   801: lload 10
    //   803: lsub
    //   804: ldc2_w 296
    //   807: lcmp
    //   808: iflt -48 -> 760
    //   811: aload 15
    //   813: iconst_4
    //   814: iconst_1
    //   815: iconst_1
    //   816: anewarray 4	java/lang/Object
    //   819: dup
    //   820: iconst_0
    //   821: iload 7
    //   823: bipush 100
    //   825: imul
    //   826: iload 8
    //   828: idiv
    //   829: invokestatic 303	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   832: aastore
    //   833: invokeinterface 273 4 0
    //   838: lload 12
    //   840: lstore 10
    //   842: iload 7
    //   844: istore 6
    //   846: goto -86 -> 760
    //   849: aload 16
    //   851: invokevirtual 306	java/io/ByteArrayOutputStream:close	()V
    //   854: aload 16
    //   856: invokevirtual 310	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   859: astore 4
    //   861: new 57	java/lang/StringBuilder
    //   864: dup
    //   865: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   868: astore_0
    //   869: aload_0
    //   870: getstatic 315	com/tencent/mobileqq/app/AppConstants:SDCARD_FILE_SAVE_PATH	Ljava/lang/String;
    //   873: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   876: pop
    //   877: aload_0
    //   878: aload_2
    //   879: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   882: pop
    //   883: aload_0
    //   884: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   887: invokestatic 320	com/tencent/mobileqq/filemanager/util/QQFileManagerUtil:t	(Ljava/lang/String;)Ljava/lang/String;
    //   890: astore 14
    //   892: new 322	java/io/FileOutputStream
    //   895: dup
    //   896: new 324	java/io/File
    //   899: dup
    //   900: aload 14
    //   902: invokespecial 325	java/io/File:<init>	(Ljava/lang/String;)V
    //   905: invokespecial 328	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   908: astore_2
    //   909: aload_2
    //   910: astore_0
    //   911: aload_2
    //   912: aload 4
    //   914: invokevirtual 331	java/io/FileOutputStream:write	([B)V
    //   917: iload 6
    //   919: iload 8
    //   921: if_icmplt +30 -> 951
    //   924: aload_2
    //   925: astore_0
    //   926: aload 15
    //   928: iconst_3
    //   929: iconst_1
    //   930: iconst_2
    //   931: anewarray 4	java/lang/Object
    //   934: dup
    //   935: iconst_0
    //   936: aload 14
    //   938: aastore
    //   939: dup
    //   940: iconst_1
    //   941: aload_3
    //   942: aastore
    //   943: invokeinterface 273 4 0
    //   948: goto +31 -> 979
    //   951: aload_2
    //   952: astore_0
    //   953: aload 15
    //   955: iconst_1
    //   956: iconst_1
    //   957: iconst_2
    //   958: anewarray 4	java/lang/Object
    //   961: dup
    //   962: iconst_0
    //   963: ldc_w 332
    //   966: invokestatic 269	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   969: aastore
    //   970: dup
    //   971: iconst_1
    //   972: aload_3
    //   973: aastore
    //   974: invokeinterface 273 4 0
    //   979: aload_1
    //   980: astore 14
    //   982: aload 16
    //   984: invokevirtual 306	java/io/ByteArrayOutputStream:close	()V
    //   987: aload_1
    //   988: astore 14
    //   990: aload_2
    //   991: invokevirtual 333	java/io/FileOutputStream:close	()V
    //   994: aload 5
    //   996: ifnull +363 -> 1359
    //   999: aload_1
    //   1000: astore 14
    //   1002: aload 5
    //   1004: invokevirtual 334	java/io/InputStream:close	()V
    //   1007: goto +352 -> 1359
    //   1010: astore 4
    //   1012: goto +13 -> 1025
    //   1015: astore_2
    //   1016: aconst_null
    //   1017: astore_0
    //   1018: goto +106 -> 1124
    //   1021: astore 4
    //   1023: aconst_null
    //   1024: astore_2
    //   1025: aload_2
    //   1026: astore_0
    //   1027: new 57	java/lang/StringBuilder
    //   1030: dup
    //   1031: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   1034: astore 14
    //   1036: aload_2
    //   1037: astore_0
    //   1038: aload 14
    //   1040: ldc_w 336
    //   1043: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1046: pop
    //   1047: aload_2
    //   1048: astore_0
    //   1049: aload 14
    //   1051: aload 4
    //   1053: invokevirtual 337	java/io/IOException:toString	()Ljava/lang/String;
    //   1056: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1059: pop
    //   1060: aload_2
    //   1061: astore_0
    //   1062: ldc_w 339
    //   1065: iconst_1
    //   1066: aload 14
    //   1068: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1071: invokestatic 342	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1074: aload_2
    //   1075: astore_0
    //   1076: aload 15
    //   1078: iconst_1
    //   1079: iconst_1
    //   1080: iconst_2
    //   1081: anewarray 4	java/lang/Object
    //   1084: dup
    //   1085: iconst_0
    //   1086: ldc_w 343
    //   1089: invokestatic 269	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   1092: aastore
    //   1093: dup
    //   1094: iconst_1
    //   1095: aload_3
    //   1096: aastore
    //   1097: invokeinterface 273 4 0
    //   1102: aload_1
    //   1103: astore 14
    //   1105: aload 16
    //   1107: invokevirtual 306	java/io/ByteArrayOutputStream:close	()V
    //   1110: aload_2
    //   1111: ifnull +240 -> 1351
    //   1114: aload_1
    //   1115: astore 14
    //   1117: aload_2
    //   1118: invokevirtual 333	java/io/FileOutputStream:close	()V
    //   1121: goto +230 -> 1351
    //   1124: aload_1
    //   1125: astore 14
    //   1127: aload 16
    //   1129: invokevirtual 306	java/io/ByteArrayOutputStream:close	()V
    //   1132: aload_0
    //   1133: ifnull +10 -> 1143
    //   1136: aload_1
    //   1137: astore 14
    //   1139: aload_0
    //   1140: invokevirtual 333	java/io/FileOutputStream:close	()V
    //   1143: aload 5
    //   1145: ifnull +11 -> 1156
    //   1148: aload_1
    //   1149: astore 14
    //   1151: aload 5
    //   1153: invokevirtual 334	java/io/InputStream:close	()V
    //   1156: aload_1
    //   1157: astore 14
    //   1159: aload_2
    //   1160: athrow
    //   1161: astore_2
    //   1162: aload_1
    //   1163: astore_0
    //   1164: goto +13 -> 1177
    //   1167: astore_0
    //   1168: aconst_null
    //   1169: astore 14
    //   1171: goto +94 -> 1265
    //   1174: astore_2
    //   1175: aconst_null
    //   1176: astore_0
    //   1177: aload_0
    //   1178: astore 14
    //   1180: new 57	java/lang/StringBuilder
    //   1183: dup
    //   1184: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   1187: astore_1
    //   1188: aload_0
    //   1189: astore 14
    //   1191: aload_1
    //   1192: ldc_w 345
    //   1195: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1198: pop
    //   1199: aload_0
    //   1200: astore 14
    //   1202: aload_1
    //   1203: aload_2
    //   1204: invokevirtual 346	java/lang/Exception:toString	()Ljava/lang/String;
    //   1207: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1210: pop
    //   1211: aload_0
    //   1212: astore 14
    //   1214: ldc_w 339
    //   1217: iconst_1
    //   1218: aload_1
    //   1219: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1222: invokestatic 342	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1225: aload_0
    //   1226: astore 14
    //   1228: aload 15
    //   1230: iconst_1
    //   1231: iconst_1
    //   1232: iconst_2
    //   1233: anewarray 4	java/lang/Object
    //   1236: dup
    //   1237: iconst_0
    //   1238: ldc_w 347
    //   1241: invokestatic 269	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   1244: aastore
    //   1245: dup
    //   1246: iconst_1
    //   1247: aload_3
    //   1248: aastore
    //   1249: invokeinterface 273 4 0
    //   1254: aload_0
    //   1255: ifnull +7 -> 1262
    //   1258: aload_0
    //   1259: invokevirtual 350	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   1262: aconst_null
    //   1263: areturn
    //   1264: astore_0
    //   1265: aload 14
    //   1267: ifnull +8 -> 1275
    //   1270: aload 14
    //   1272: invokevirtual 350	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   1275: aload_0
    //   1276: athrow
    //   1277: new 57	java/lang/StringBuilder
    //   1280: dup
    //   1281: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   1284: astore_2
    //   1285: aload_2
    //   1286: ldc_w 352
    //   1289: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1292: pop
    //   1293: aload_2
    //   1294: aload_1
    //   1295: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1298: pop
    //   1299: aload_2
    //   1300: ldc_w 354
    //   1303: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1306: pop
    //   1307: aload_2
    //   1308: aload 5
    //   1310: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1313: pop
    //   1314: aload_2
    //   1315: ldc_w 356
    //   1318: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1321: pop
    //   1322: aload_2
    //   1323: aload_0
    //   1324: invokevirtual 359	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1327: pop
    //   1328: ldc 203
    //   1330: iconst_1
    //   1331: aload_2
    //   1332: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1335: invokestatic 211	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1338: aconst_null
    //   1339: areturn
    //   1340: aconst_null
    //   1341: astore_0
    //   1342: goto -841 -> 501
    //   1345: aload 4
    //   1347: astore_0
    //   1348: goto -782 -> 566
    //   1351: aload 5
    //   1353: ifnull +6 -> 1359
    //   1356: goto -357 -> 999
    //   1359: aload_1
    //   1360: ifnull -98 -> 1262
    //   1363: aload_1
    //   1364: astore_0
    //   1365: goto -107 -> 1258
    //   1368: astore_2
    //   1369: goto -245 -> 1124
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1372	0	paramAppInterface	com.tencent.common.app.AppInterface
    //   0	1372	1	paramString1	String
    //   0	1372	2	paramString2	String
    //   0	1372	3	paramString3	String
    //   0	1372	4	paramString4	String
    //   0	1372	5	paramString5	String
    //   758	164	6	i	int
    //   779	64	7	j	int
    //   676	246	8	k	int
    //   766	20	9	m	int
    //   684	157	10	l1	long
    //   793	46	12	l2	long
    //   51	1220	14	localObject1	Object
    //   42	1187	15	localITeamWorkFileExportHandler	com.tencent.mobileqq.teamwork.api.ITeamWorkFileExportHandler
    //   65	1063	16	localObject2	Object
    //   109	485	17	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   911	917	1010	java/io/IOException
    //   926	948	1010	java/io/IOException
    //   953	979	1010	java/io/IOException
    //   748	754	1015	finally
    //   760	768	1015	finally
    //   781	795	1015	finally
    //   811	838	1015	finally
    //   849	909	1015	finally
    //   748	754	1021	java/io/IOException
    //   760	768	1021	java/io/IOException
    //   781	795	1021	java/io/IOException
    //   811	838	1021	java/io/IOException
    //   849	909	1021	java/io/IOException
    //   135	141	1161	java/lang/Exception
    //   144	151	1161	java/lang/Exception
    //   154	161	1161	java/lang/Exception
    //   164	169	1161	java/lang/Exception
    //   172	177	1161	java/lang/Exception
    //   180	186	1161	java/lang/Exception
    //   189	197	1161	java/lang/Exception
    //   200	211	1161	java/lang/Exception
    //   214	222	1161	java/lang/Exception
    //   225	234	1161	java/lang/Exception
    //   237	245	1161	java/lang/Exception
    //   248	257	1161	java/lang/Exception
    //   260	268	1161	java/lang/Exception
    //   271	280	1161	java/lang/Exception
    //   283	291	1161	java/lang/Exception
    //   294	302	1161	java/lang/Exception
    //   305	313	1161	java/lang/Exception
    //   316	324	1161	java/lang/Exception
    //   327	335	1161	java/lang/Exception
    //   338	349	1161	java/lang/Exception
    //   352	360	1161	java/lang/Exception
    //   363	372	1161	java/lang/Exception
    //   375	383	1161	java/lang/Exception
    //   386	394	1161	java/lang/Exception
    //   397	408	1161	java/lang/Exception
    //   411	420	1161	java/lang/Exception
    //   423	435	1161	java/lang/Exception
    //   438	449	1161	java/lang/Exception
    //   452	461	1161	java/lang/Exception
    //   464	473	1161	java/lang/Exception
    //   476	484	1161	java/lang/Exception
    //   487	498	1161	java/lang/Exception
    //   504	511	1161	java/lang/Exception
    //   514	522	1161	java/lang/Exception
    //   525	529	1161	java/lang/Exception
    //   536	552	1161	java/lang/Exception
    //   569	590	1161	java/lang/Exception
    //   593	606	1161	java/lang/Exception
    //   609	618	1161	java/lang/Exception
    //   621	632	1161	java/lang/Exception
    //   635	659	1161	java/lang/Exception
    //   665	669	1161	java/lang/Exception
    //   672	678	1161	java/lang/Exception
    //   681	686	1161	java/lang/Exception
    //   698	724	1161	java/lang/Exception
    //   730	736	1161	java/lang/Exception
    //   739	748	1161	java/lang/Exception
    //   982	987	1161	java/lang/Exception
    //   990	994	1161	java/lang/Exception
    //   1002	1007	1161	java/lang/Exception
    //   1105	1110	1161	java/lang/Exception
    //   1117	1121	1161	java/lang/Exception
    //   1127	1132	1161	java/lang/Exception
    //   1139	1143	1161	java/lang/Exception
    //   1151	1156	1161	java/lang/Exception
    //   1159	1161	1161	java/lang/Exception
    //   67	132	1167	finally
    //   67	132	1174	java/lang/Exception
    //   135	141	1264	finally
    //   144	151	1264	finally
    //   154	161	1264	finally
    //   164	169	1264	finally
    //   172	177	1264	finally
    //   180	186	1264	finally
    //   189	197	1264	finally
    //   200	211	1264	finally
    //   214	222	1264	finally
    //   225	234	1264	finally
    //   237	245	1264	finally
    //   248	257	1264	finally
    //   260	268	1264	finally
    //   271	280	1264	finally
    //   283	291	1264	finally
    //   294	302	1264	finally
    //   305	313	1264	finally
    //   316	324	1264	finally
    //   327	335	1264	finally
    //   338	349	1264	finally
    //   352	360	1264	finally
    //   363	372	1264	finally
    //   375	383	1264	finally
    //   386	394	1264	finally
    //   397	408	1264	finally
    //   411	420	1264	finally
    //   423	435	1264	finally
    //   438	449	1264	finally
    //   452	461	1264	finally
    //   464	473	1264	finally
    //   476	484	1264	finally
    //   487	498	1264	finally
    //   504	511	1264	finally
    //   514	522	1264	finally
    //   525	529	1264	finally
    //   536	552	1264	finally
    //   569	590	1264	finally
    //   593	606	1264	finally
    //   609	618	1264	finally
    //   621	632	1264	finally
    //   635	659	1264	finally
    //   665	669	1264	finally
    //   672	678	1264	finally
    //   681	686	1264	finally
    //   698	724	1264	finally
    //   730	736	1264	finally
    //   739	748	1264	finally
    //   982	987	1264	finally
    //   990	994	1264	finally
    //   1002	1007	1264	finally
    //   1105	1110	1264	finally
    //   1117	1121	1264	finally
    //   1127	1132	1264	finally
    //   1139	1143	1264	finally
    //   1151	1156	1264	finally
    //   1159	1161	1264	finally
    //   1180	1188	1264	finally
    //   1191	1199	1264	finally
    //   1202	1211	1264	finally
    //   1214	1225	1264	finally
    //   1228	1254	1264	finally
    //   911	917	1368	finally
    //   926	948	1368	finally
    //   953	979	1368	finally
    //   1027	1036	1368	finally
    //   1038	1047	1368	finally
    //   1049	1060	1368	finally
    //   1062	1074	1368	finally
    //   1076	1102	1368	finally
  }
  
  /* Error */
  public static final String a(TeamWorkFileImportInfo paramTeamWorkFileImportInfo, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aload_0
    //   4: ifnull +1517 -> 1521
    //   7: aload_0
    //   8: getfield 366	com/tencent/mobileqq/teamwork/bean/TeamWorkFileImportInfo:d	Ljava/lang/String;
    //   11: invokestatic 35	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   14: ifne +1507 -> 1521
    //   17: aload_1
    //   18: invokestatic 35	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   21: ifeq +6 -> 27
    //   24: goto +1497 -> 1521
    //   27: aload_0
    //   28: getfield 366	com/tencent/mobileqq/teamwork/bean/TeamWorkFileImportInfo:d	Ljava/lang/String;
    //   31: astore 9
    //   33: new 57	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   40: astore 5
    //   42: new 324	java/io/File
    //   45: dup
    //   46: aload 9
    //   48: invokespecial 325	java/io/File:<init>	(Ljava/lang/String;)V
    //   51: astore 8
    //   53: aload 8
    //   55: invokevirtual 369	java/io/File:exists	()Z
    //   58: ifeq +1452 -> 1510
    //   61: aload 9
    //   63: invokestatic 371	com/tencent/mobileqq/teamwork/TeamWorkHttpUtils:a	(Ljava/lang/String;)Ljava/lang/String;
    //   66: astore 4
    //   68: aload 5
    //   70: ldc_w 373
    //   73: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: pop
    //   77: aload 5
    //   79: aload_1
    //   80: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: pop
    //   84: aload 5
    //   86: ldc_w 375
    //   89: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: pop
    //   93: aload 5
    //   95: ldc_w 377
    //   98: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: pop
    //   102: aload 5
    //   104: aload 4
    //   106: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: pop
    //   110: aload 5
    //   112: ldc_w 379
    //   115: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: pop
    //   119: aload 5
    //   121: aload 8
    //   123: invokevirtual 382	java/io/File:getName	()Ljava/lang/String;
    //   126: ldc_w 384
    //   129: invokestatic 389	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   132: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: pop
    //   136: aload 5
    //   138: ldc_w 391
    //   141: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: pop
    //   145: aload 5
    //   147: ldc_w 393
    //   150: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: pop
    //   154: aload 5
    //   156: ldc_w 395
    //   159: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: pop
    //   163: aload_0
    //   164: getfield 398	com/tencent/mobileqq/teamwork/bean/TeamWorkFileImportInfo:D	Ljava/lang/String;
    //   167: ifnull +9 -> 176
    //   170: aload_0
    //   171: getfield 398	com/tencent/mobileqq/teamwork/bean/TeamWorkFileImportInfo:D	Ljava/lang/String;
    //   174: astore 4
    //   176: aload 5
    //   178: aload 4
    //   180: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: pop
    //   184: aload 5
    //   186: ldc_w 400
    //   189: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: pop
    //   193: aload 5
    //   195: aload_0
    //   196: getfield 404	com/tencent/mobileqq/teamwork/bean/TeamWorkFileImportInfo:E	I
    //   199: invokevirtual 407	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   202: pop
    //   203: aload 5
    //   205: ldc_w 409
    //   208: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: pop
    //   212: aload 5
    //   214: aload_0
    //   215: getfield 412	com/tencent/mobileqq/teamwork/bean/TeamWorkFileImportInfo:B	I
    //   218: invokevirtual 407	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   221: pop
    //   222: aload 5
    //   224: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   227: astore 10
    //   229: new 67	com/tencent/mobileqq/teamwork/CustomX509TrustManager
    //   232: dup
    //   233: invokespecial 68	com/tencent/mobileqq/teamwork/CustomX509TrustManager:<init>	()V
    //   236: astore 4
    //   238: ldc 70
    //   240: invokestatic 76	javax/net/ssl/SSLContext:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    //   243: astore 5
    //   245: aload 5
    //   247: aconst_null
    //   248: iconst_1
    //   249: anewarray 78	javax/net/ssl/TrustManager
    //   252: dup
    //   253: iconst_0
    //   254: aload 4
    //   256: aastore
    //   257: aconst_null
    //   258: invokevirtual 82	javax/net/ssl/SSLContext:init	([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Ljava/security/SecureRandom;)V
    //   261: new 84	com/tencent/mobileqq/teamwork/NoSSLv3SocketFactory
    //   264: dup
    //   265: aload 5
    //   267: invokevirtual 88	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   270: invokespecial 91	com/tencent/mobileqq/teamwork/NoSSLv3SocketFactory:<init>	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   273: astore 5
    //   275: aload 5
    //   277: invokestatic 96	javax/net/ssl/HttpsURLConnection:setDefaultSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   280: new 98	java/net/URL
    //   283: dup
    //   284: aload 10
    //   286: invokespecial 101	java/net/URL:<init>	(Ljava/lang/String;)V
    //   289: invokevirtual 105	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   292: checkcast 93	javax/net/ssl/HttpsURLConnection
    //   295: astore 4
    //   297: aload 4
    //   299: aload 5
    //   301: invokevirtual 108	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   304: aload 4
    //   306: sipush 5000
    //   309: invokevirtual 112	javax/net/ssl/HttpsURLConnection:setConnectTimeout	(I)V
    //   312: aload 4
    //   314: sipush 30000
    //   317: invokevirtual 115	javax/net/ssl/HttpsURLConnection:setReadTimeout	(I)V
    //   320: aload 4
    //   322: iconst_1
    //   323: invokevirtual 415	javax/net/ssl/HttpsURLConnection:setDoOutput	(Z)V
    //   326: aload 4
    //   328: iconst_1
    //   329: invokevirtual 119	javax/net/ssl/HttpsURLConnection:setDoInput	(Z)V
    //   332: aload 4
    //   334: iconst_0
    //   335: invokevirtual 122	javax/net/ssl/HttpsURLConnection:setUseCaches	(Z)V
    //   338: aload 4
    //   340: ldc_w 417
    //   343: invokevirtual 127	javax/net/ssl/HttpsURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   346: aload 4
    //   348: ldc 129
    //   350: ldc 131
    //   352: invokevirtual 135	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   355: new 57	java/lang/StringBuilder
    //   358: dup
    //   359: ldc 137
    //   361: invokespecial 138	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   364: astore 5
    //   366: aload 5
    //   368: ldc 140
    //   370: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: pop
    //   374: aload 5
    //   376: getstatic 146	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   379: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   382: pop
    //   383: aload 5
    //   385: ldc 140
    //   387: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   390: pop
    //   391: aload 5
    //   393: getstatic 151	android/os/Build:DEVICE	Ljava/lang/String;
    //   396: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   399: pop
    //   400: aload 5
    //   402: ldc 140
    //   404: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: pop
    //   408: aload 5
    //   410: getstatic 154	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   413: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   416: pop
    //   417: aload 5
    //   419: ldc 140
    //   421: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   424: pop
    //   425: aload 5
    //   427: ldc 156
    //   429: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   432: pop
    //   433: aload 5
    //   435: ldc 140
    //   437: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   440: pop
    //   441: aload 5
    //   443: ldc 158
    //   445: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   448: pop
    //   449: aload 5
    //   451: ldc 160
    //   453: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   456: pop
    //   457: aload 4
    //   459: ldc 162
    //   461: aload 5
    //   463: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   466: invokevirtual 135	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   469: aload 4
    //   471: ldc 164
    //   473: ldc 166
    //   475: invokevirtual 135	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   478: new 57	java/lang/StringBuilder
    //   481: dup
    //   482: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   485: astore 5
    //   487: aload 5
    //   489: ldc 168
    //   491: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   494: pop
    //   495: aload 5
    //   497: ldc 170
    //   499: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   502: pop
    //   503: aload 4
    //   505: ldc 172
    //   507: aload 5
    //   509: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   512: invokevirtual 135	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   515: new 174	java/util/HashMap
    //   518: dup
    //   519: invokespecial 175	java/util/HashMap:<init>	()V
    //   522: astore 11
    //   524: aload 11
    //   526: ldc 129
    //   528: ldc 177
    //   530: invokeinterface 183 3 0
    //   535: pop
    //   536: aload 11
    //   538: ldc 185
    //   540: aload 10
    //   542: invokeinterface 183 3 0
    //   547: pop
    //   548: getstatic 423	mqq/app/MobileQQ:sMobileQQ	Lmqq/app/MobileQQ;
    //   551: aconst_null
    //   552: invokevirtual 427	mqq/app/MobileQQ:waitAppRuntime	(Lmqq/app/BaseActivity;)Lmqq/app/AppRuntime;
    //   555: iconst_2
    //   556: invokevirtual 430	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   559: checkcast 191	mqq/manager/TicketManager
    //   562: astore 6
    //   564: aload 6
    //   566: aload_1
    //   567: invokeinterface 195 2 0
    //   572: astore 12
    //   574: aload 10
    //   576: invokestatic 35	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   579: istore_3
    //   580: iload_3
    //   581: ifne +29 -> 610
    //   584: aload 7
    //   586: astore 5
    //   588: aload 6
    //   590: aload_1
    //   591: ldc 197
    //   593: invokeinterface 201 3 0
    //   598: astore 6
    //   600: goto +13 -> 613
    //   603: astore_1
    //   604: aload 4
    //   606: astore_0
    //   607: goto +796 -> 1403
    //   610: aconst_null
    //   611: astore 6
    //   613: aload 8
    //   615: invokevirtual 369	java/io/File:exists	()Z
    //   618: istore_3
    //   619: iload_3
    //   620: ifeq +21 -> 641
    //   623: aload 7
    //   625: astore 5
    //   627: aload 9
    //   629: invokestatic 371	com/tencent/mobileqq/teamwork/TeamWorkHttpUtils:a	(Ljava/lang/String;)Ljava/lang/String;
    //   632: astore 7
    //   634: aload 7
    //   636: astore 5
    //   638: goto +6 -> 644
    //   641: aconst_null
    //   642: astore 5
    //   644: aload 6
    //   646: invokestatic 35	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   649: istore_3
    //   650: iload_3
    //   651: ifeq +39 -> 690
    //   654: ldc 203
    //   656: iconst_1
    //   657: ldc_w 432
    //   660: invokestatic 211	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   663: invokestatic 216	com/tencent/smtt/sdk/CookieManager:getInstance	()Lcom/tencent/smtt/sdk/CookieManager;
    //   666: astore_1
    //   667: aload_1
    //   668: ifnull +149 -> 817
    //   671: aload 11
    //   673: ldc 225
    //   675: aload_1
    //   676: aload 10
    //   678: invokevirtual 221	com/tencent/smtt/sdk/CookieManager:getCookie	(Ljava/lang/String;)Ljava/lang/String;
    //   681: invokeinterface 183 3 0
    //   686: pop
    //   687: goto +130 -> 817
    //   690: new 57	java/lang/StringBuilder
    //   693: dup
    //   694: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   697: astore 7
    //   699: aload 7
    //   701: ldc_w 434
    //   704: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   707: pop
    //   708: aload 7
    //   710: aload 6
    //   712: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   715: pop
    //   716: aload 7
    //   718: ldc_w 436
    //   721: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   724: pop
    //   725: aload 7
    //   727: aload_1
    //   728: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   731: pop
    //   732: aload 7
    //   734: ldc_w 438
    //   737: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   740: pop
    //   741: aload 7
    //   743: aload 12
    //   745: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   748: pop
    //   749: new 57	java/lang/StringBuilder
    //   752: dup
    //   753: aload 7
    //   755: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   758: invokespecial 138	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   761: astore_1
    //   762: aload 5
    //   764: ifnull +39 -> 803
    //   767: new 57	java/lang/StringBuilder
    //   770: dup
    //   771: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   774: astore 6
    //   776: aload 6
    //   778: ldc_w 440
    //   781: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   784: pop
    //   785: aload 6
    //   787: aload 5
    //   789: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   792: pop
    //   793: aload_1
    //   794: aload 6
    //   796: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   799: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   802: pop
    //   803: aload 11
    //   805: ldc 225
    //   807: aload_1
    //   808: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   811: invokeinterface 183 3 0
    //   816: pop
    //   817: aload 11
    //   819: invokeinterface 229 1 0
    //   824: invokeinterface 235 1 0
    //   829: astore_1
    //   830: aload_1
    //   831: invokeinterface 240 1 0
    //   836: ifeq +42 -> 878
    //   839: aload_1
    //   840: invokeinterface 244 1 0
    //   845: checkcast 246	java/util/Map$Entry
    //   848: astore 5
    //   850: aload 4
    //   852: aload 5
    //   854: invokeinterface 249 1 0
    //   859: checkcast 251	java/lang/String
    //   862: aload 5
    //   864: invokeinterface 254 1 0
    //   869: checkcast 251	java/lang/String
    //   872: invokevirtual 135	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   875: goto -45 -> 830
    //   878: aload_0
    //   879: getfield 412	com/tencent/mobileqq/teamwork/bean/TeamWorkFileImportInfo:B	I
    //   882: iconst_1
    //   883: if_icmpeq +362 -> 1245
    //   886: new 442	java/io/DataOutputStream
    //   889: dup
    //   890: aload 4
    //   892: invokevirtual 446	javax/net/ssl/HttpsURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   895: invokespecial 449	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   898: astore_0
    //   899: new 451	java/lang/StringBuffer
    //   902: dup
    //   903: invokespecial 452	java/lang/StringBuffer:<init>	()V
    //   906: astore_1
    //   907: aload_1
    //   908: ldc_w 454
    //   911: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   914: pop
    //   915: aload_1
    //   916: ldc_w 459
    //   919: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   922: pop
    //   923: aload_1
    //   924: ldc 170
    //   926: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   929: pop
    //   930: aload_1
    //   931: ldc_w 454
    //   934: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   937: pop
    //   938: aload_1
    //   939: ldc_w 461
    //   942: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   945: pop
    //   946: aload_1
    //   947: ldc_w 463
    //   950: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   953: pop
    //   954: aload_1
    //   955: ldc_w 465
    //   958: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   961: pop
    //   962: aload_1
    //   963: aload 8
    //   965: invokevirtual 382	java/io/File:getName	()Ljava/lang/String;
    //   968: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   971: pop
    //   972: aload_1
    //   973: ldc_w 467
    //   976: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   979: pop
    //   980: aload_1
    //   981: ldc_w 454
    //   984: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   987: pop
    //   988: new 57	java/lang/StringBuilder
    //   991: dup
    //   992: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   995: astore 5
    //   997: aload 5
    //   999: ldc_w 469
    //   1002: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1005: pop
    //   1006: aload 5
    //   1008: ldc_w 471
    //   1011: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1014: pop
    //   1015: aload 5
    //   1017: ldc_w 473
    //   1020: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1023: pop
    //   1024: aload_1
    //   1025: aload 5
    //   1027: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1030: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1033: pop
    //   1034: aload_0
    //   1035: aload_1
    //   1036: invokevirtual 474	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   1039: invokevirtual 477	java/lang/String:getBytes	()[B
    //   1042: invokevirtual 480	java/io/OutputStream:write	([B)V
    //   1045: new 482	java/io/BufferedInputStream
    //   1048: dup
    //   1049: new 482	java/io/BufferedInputStream
    //   1052: dup
    //   1053: new 484	java/io/FileInputStream
    //   1056: dup
    //   1057: aload 8
    //   1059: invokespecial 485	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   1062: invokespecial 488	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   1065: invokespecial 488	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   1068: astore_1
    //   1069: sipush 3072
    //   1072: newarray byte
    //   1074: astore 5
    //   1076: aload_1
    //   1077: aload 5
    //   1079: invokevirtual 489	java/io/BufferedInputStream:read	([B)I
    //   1082: istore_2
    //   1083: iload_2
    //   1084: iconst_m1
    //   1085: if_icmpeq +14 -> 1099
    //   1088: aload_0
    //   1089: aload 5
    //   1091: iconst_0
    //   1092: iload_2
    //   1093: invokevirtual 490	java/io/OutputStream:write	([BII)V
    //   1096: goto -20 -> 1076
    //   1099: aload_1
    //   1100: invokevirtual 491	java/io/BufferedInputStream:close	()V
    //   1103: new 57	java/lang/StringBuilder
    //   1106: dup
    //   1107: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   1110: astore_1
    //   1111: aload_1
    //   1112: ldc_w 493
    //   1115: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1118: pop
    //   1119: aload_1
    //   1120: ldc 170
    //   1122: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1125: pop
    //   1126: aload_1
    //   1127: ldc_w 495
    //   1130: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1133: pop
    //   1134: aload_0
    //   1135: aload_1
    //   1136: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1139: invokevirtual 477	java/lang/String:getBytes	()[B
    //   1142: invokevirtual 480	java/io/OutputStream:write	([B)V
    //   1145: aload_0
    //   1146: invokevirtual 498	java/io/OutputStream:flush	()V
    //   1149: aload_0
    //   1150: invokevirtual 499	java/io/OutputStream:close	()V
    //   1153: goto +92 -> 1245
    //   1156: astore_0
    //   1157: goto +82 -> 1239
    //   1160: new 57	java/lang/StringBuilder
    //   1163: dup
    //   1164: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   1167: astore 5
    //   1169: aload 5
    //   1171: ldc_w 501
    //   1174: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1177: pop
    //   1178: aload 5
    //   1180: aload 8
    //   1182: invokevirtual 504	java/io/File:length	()J
    //   1185: invokevirtual 507	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1188: pop
    //   1189: aload 5
    //   1191: ldc_w 509
    //   1194: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1197: pop
    //   1198: aload 5
    //   1200: aload 8
    //   1202: invokevirtual 512	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1205: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1208: pop
    //   1209: ldc 203
    //   1211: iconst_1
    //   1212: aload 5
    //   1214: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1217: invokestatic 211	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1220: aload_0
    //   1221: invokevirtual 498	java/io/OutputStream:flush	()V
    //   1224: aload_0
    //   1225: invokevirtual 499	java/io/OutputStream:close	()V
    //   1228: aload 4
    //   1230: invokevirtual 350	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   1233: aload_1
    //   1234: invokevirtual 491	java/io/BufferedInputStream:close	()V
    //   1237: aconst_null
    //   1238: areturn
    //   1239: aload_1
    //   1240: invokevirtual 491	java/io/BufferedInputStream:close	()V
    //   1243: aload_0
    //   1244: athrow
    //   1245: new 451	java/lang/StringBuffer
    //   1248: dup
    //   1249: invokespecial 452	java/lang/StringBuffer:<init>	()V
    //   1252: astore_0
    //   1253: aload 4
    //   1255: invokevirtual 515	javax/net/ssl/HttpsURLConnection:getResponseCode	()I
    //   1258: istore_2
    //   1259: iload_2
    //   1260: sipush 200
    //   1263: if_icmpeq +43 -> 1306
    //   1266: new 57	java/lang/StringBuilder
    //   1269: dup
    //   1270: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   1273: astore_1
    //   1274: aload_1
    //   1275: ldc_w 517
    //   1278: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1281: pop
    //   1282: aload_1
    //   1283: iload_2
    //   1284: invokevirtual 407	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1287: pop
    //   1288: aload_1
    //   1289: ldc_w 519
    //   1292: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1295: pop
    //   1296: ldc 203
    //   1298: iconst_1
    //   1299: aload_1
    //   1300: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1303: invokestatic 522	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1306: new 524	java/io/BufferedReader
    //   1309: dup
    //   1310: new 526	java/io/InputStreamReader
    //   1313: dup
    //   1314: aload 4
    //   1316: invokevirtual 277	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   1319: invokespecial 527	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   1322: invokespecial 530	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   1325: astore_1
    //   1326: aload_1
    //   1327: invokevirtual 533	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   1330: astore 5
    //   1332: aload 5
    //   1334: ifnull +21 -> 1355
    //   1337: aload_0
    //   1338: aload 5
    //   1340: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1343: pop
    //   1344: aload_0
    //   1345: ldc_w 535
    //   1348: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1351: pop
    //   1352: goto -26 -> 1326
    //   1355: aload_0
    //   1356: invokevirtual 474	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   1359: astore_0
    //   1360: aload_0
    //   1361: astore 5
    //   1363: aload_1
    //   1364: invokevirtual 536	java/io/BufferedReader:close	()V
    //   1367: aload 4
    //   1369: ifnull +8 -> 1377
    //   1372: aload 4
    //   1374: invokevirtual 350	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   1377: aload_0
    //   1378: areturn
    //   1379: astore_0
    //   1380: goto +80 -> 1460
    //   1383: astore_1
    //   1384: aload 4
    //   1386: astore_0
    //   1387: goto +13 -> 1400
    //   1390: astore_0
    //   1391: aconst_null
    //   1392: astore 4
    //   1394: goto +66 -> 1460
    //   1397: astore_1
    //   1398: aconst_null
    //   1399: astore_0
    //   1400: aconst_null
    //   1401: astore 5
    //   1403: new 57	java/lang/StringBuilder
    //   1406: dup
    //   1407: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   1410: astore 4
    //   1412: aload 4
    //   1414: ldc_w 538
    //   1417: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1420: pop
    //   1421: aload 4
    //   1423: aload_1
    //   1424: invokevirtual 346	java/lang/Exception:toString	()Ljava/lang/String;
    //   1427: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1430: pop
    //   1431: ldc_w 339
    //   1434: iconst_1
    //   1435: aload 4
    //   1437: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1440: invokestatic 342	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1443: aload_0
    //   1444: ifnull +7 -> 1451
    //   1447: aload_0
    //   1448: invokevirtual 350	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   1451: aload 5
    //   1453: areturn
    //   1454: astore_1
    //   1455: aload_0
    //   1456: astore 4
    //   1458: aload_1
    //   1459: astore_0
    //   1460: aload 4
    //   1462: ifnull +8 -> 1470
    //   1465: aload 4
    //   1467: invokevirtual 350	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   1470: aload_0
    //   1471: athrow
    //   1472: astore_0
    //   1473: new 57	java/lang/StringBuilder
    //   1476: dup
    //   1477: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   1480: astore_1
    //   1481: aload_1
    //   1482: ldc_w 540
    //   1485: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1488: pop
    //   1489: aload_1
    //   1490: aload_0
    //   1491: invokevirtual 346	java/lang/Exception:toString	()Ljava/lang/String;
    //   1494: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1497: pop
    //   1498: ldc 203
    //   1500: iconst_1
    //   1501: aload_1
    //   1502: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1505: invokestatic 211	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1508: aconst_null
    //   1509: areturn
    //   1510: ldc 203
    //   1512: iconst_1
    //   1513: ldc_w 542
    //   1516: invokestatic 211	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1519: aconst_null
    //   1520: areturn
    //   1521: ldc 203
    //   1523: iconst_1
    //   1524: ldc_w 544
    //   1527: invokestatic 211	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1530: aconst_null
    //   1531: areturn
    //   1532: astore 5
    //   1534: goto -374 -> 1160
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1537	0	paramTeamWorkFileImportInfo	TeamWorkFileImportInfo
    //   0	1537	1	paramString	String
    //   1082	202	2	i	int
    //   579	72	3	bool	boolean
    //   66	1400	4	localObject1	Object
    //   40	1412	5	localObject2	Object
    //   1532	1	5	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   562	233	6	localObject3	Object
    //   1	753	7	localObject4	Object
    //   51	1150	8	localFile	java.io.File
    //   31	597	9	str1	String
    //   227	450	10	str2	String
    //   522	296	11	localHashMap	java.util.HashMap
    //   572	172	12	str3	String
    // Exception table:
    //   from	to	target	type
    //   588	600	603	java/lang/Exception
    //   627	634	603	java/lang/Exception
    //   1363	1367	603	java/lang/Exception
    //   1076	1083	1156	finally
    //   1088	1096	1156	finally
    //   1160	1233	1156	finally
    //   297	580	1379	finally
    //   588	600	1379	finally
    //   613	619	1379	finally
    //   627	634	1379	finally
    //   644	650	1379	finally
    //   654	667	1379	finally
    //   671	687	1379	finally
    //   690	762	1379	finally
    //   767	803	1379	finally
    //   803	817	1379	finally
    //   817	830	1379	finally
    //   830	875	1379	finally
    //   878	1076	1379	finally
    //   1099	1153	1379	finally
    //   1239	1245	1379	finally
    //   1245	1259	1379	finally
    //   1266	1306	1379	finally
    //   1306	1326	1379	finally
    //   1326	1332	1379	finally
    //   1337	1352	1379	finally
    //   1355	1360	1379	finally
    //   1363	1367	1379	finally
    //   297	580	1383	java/lang/Exception
    //   613	619	1383	java/lang/Exception
    //   644	650	1383	java/lang/Exception
    //   654	667	1383	java/lang/Exception
    //   671	687	1383	java/lang/Exception
    //   690	762	1383	java/lang/Exception
    //   767	803	1383	java/lang/Exception
    //   803	817	1383	java/lang/Exception
    //   817	830	1383	java/lang/Exception
    //   830	875	1383	java/lang/Exception
    //   878	1076	1383	java/lang/Exception
    //   1099	1153	1383	java/lang/Exception
    //   1239	1245	1383	java/lang/Exception
    //   1245	1259	1383	java/lang/Exception
    //   1266	1306	1383	java/lang/Exception
    //   1306	1326	1383	java/lang/Exception
    //   1326	1332	1383	java/lang/Exception
    //   1337	1352	1383	java/lang/Exception
    //   1355	1360	1383	java/lang/Exception
    //   229	297	1390	finally
    //   1233	1237	1390	finally
    //   229	297	1397	java/lang/Exception
    //   1233	1237	1397	java/lang/Exception
    //   1403	1443	1454	finally
    //   61	163	1472	java/lang/Exception
    //   163	176	1472	java/lang/Exception
    //   176	222	1472	java/lang/Exception
    //   1076	1083	1532	java/lang/OutOfMemoryError
    //   1088	1096	1532	java/lang/OutOfMemoryError
  }
  
  /* Error */
  public static final String a(String paramString)
  {
    // Byte code:
    //   0: new 324	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 325	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: invokevirtual 369	java/io/File:exists	()Z
    //   11: istore 4
    //   13: aconst_null
    //   14: astore 7
    //   16: iload 4
    //   18: ifeq +360 -> 378
    //   21: ldc_w 546
    //   24: invokestatic 551	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   27: astore 6
    //   29: new 484	java/io/FileInputStream
    //   32: dup
    //   33: aload_0
    //   34: invokespecial 552	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   37: astore 5
    //   39: aload 5
    //   41: astore_0
    //   42: sipush 1024
    //   45: newarray byte
    //   47: astore 8
    //   49: aload 5
    //   51: astore_0
    //   52: aload 5
    //   54: aload 8
    //   56: invokevirtual 553	java/io/FileInputStream:read	([B)I
    //   59: istore_2
    //   60: iconst_0
    //   61: istore_1
    //   62: iload_2
    //   63: iconst_m1
    //   64: if_icmpeq +18 -> 82
    //   67: aload 5
    //   69: astore_0
    //   70: aload 6
    //   72: aload 8
    //   74: iconst_0
    //   75: iload_2
    //   76: invokevirtual 556	java/security/MessageDigest:update	([BII)V
    //   79: goto -30 -> 49
    //   82: aload 5
    //   84: astore_0
    //   85: aload 5
    //   87: invokevirtual 557	java/io/FileInputStream:close	()V
    //   90: aload 5
    //   92: astore_0
    //   93: new 57	java/lang/StringBuilder
    //   96: dup
    //   97: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   100: astore 8
    //   102: aload 5
    //   104: astore_0
    //   105: aload 6
    //   107: invokevirtual 560	java/security/MessageDigest:digest	()[B
    //   110: astore 9
    //   112: aload 5
    //   114: astore_0
    //   115: aload 9
    //   117: arraylength
    //   118: istore_2
    //   119: goto +261 -> 380
    //   122: aload 5
    //   124: astore_0
    //   125: aload 8
    //   127: aload 6
    //   129: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: pop
    //   133: aload 5
    //   135: astore_0
    //   136: aload 8
    //   138: iload_3
    //   139: invokestatic 563	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   142: invokevirtual 566	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   145: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: pop
    //   149: iload_1
    //   150: iconst_1
    //   151: iadd
    //   152: istore_1
    //   153: goto +227 -> 380
    //   156: aload 5
    //   158: astore_0
    //   159: aload 8
    //   161: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   164: astore 8
    //   166: aload 5
    //   168: invokevirtual 557	java/io/FileInputStream:close	()V
    //   171: aload 8
    //   173: areturn
    //   174: astore 6
    //   176: new 57	java/lang/StringBuilder
    //   179: dup
    //   180: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   183: astore 5
    //   185: aload 8
    //   187: astore_0
    //   188: aload 5
    //   190: ldc_w 568
    //   193: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: pop
    //   197: aload 5
    //   199: aload 6
    //   201: invokevirtual 346	java/lang/Exception:toString	()Ljava/lang/String;
    //   204: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: pop
    //   208: ldc_w 570
    //   211: iconst_1
    //   212: aload 5
    //   214: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   217: invokestatic 211	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   220: aload_0
    //   221: areturn
    //   222: astore 6
    //   224: goto +15 -> 239
    //   227: astore 5
    //   229: aconst_null
    //   230: astore_0
    //   231: goto +92 -> 323
    //   234: astore 6
    //   236: aconst_null
    //   237: astore 5
    //   239: aload 5
    //   241: astore_0
    //   242: new 57	java/lang/StringBuilder
    //   245: dup
    //   246: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   249: astore 8
    //   251: aload 5
    //   253: astore_0
    //   254: aload 8
    //   256: ldc_w 572
    //   259: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: pop
    //   263: aload 5
    //   265: astore_0
    //   266: aload 8
    //   268: aload 6
    //   270: invokevirtual 346	java/lang/Exception:toString	()Ljava/lang/String;
    //   273: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: pop
    //   277: aload 5
    //   279: astore_0
    //   280: ldc_w 570
    //   283: iconst_1
    //   284: aload 8
    //   286: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   289: invokestatic 211	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   292: aload 5
    //   294: ifnull +84 -> 378
    //   297: aload 5
    //   299: invokevirtual 557	java/io/FileInputStream:close	()V
    //   302: aconst_null
    //   303: areturn
    //   304: astore 6
    //   306: new 57	java/lang/StringBuilder
    //   309: dup
    //   310: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   313: astore 5
    //   315: aload 7
    //   317: astore_0
    //   318: goto -130 -> 188
    //   321: astore 5
    //   323: aload_0
    //   324: ifnull +51 -> 375
    //   327: aload_0
    //   328: invokevirtual 557	java/io/FileInputStream:close	()V
    //   331: goto +44 -> 375
    //   334: astore_0
    //   335: new 57	java/lang/StringBuilder
    //   338: dup
    //   339: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   342: astore 6
    //   344: aload 6
    //   346: ldc_w 568
    //   349: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   352: pop
    //   353: aload 6
    //   355: aload_0
    //   356: invokevirtual 346	java/lang/Exception:toString	()Ljava/lang/String;
    //   359: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: pop
    //   363: ldc_w 570
    //   366: iconst_1
    //   367: aload 6
    //   369: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   372: invokestatic 211	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   375: aload 5
    //   377: athrow
    //   378: aconst_null
    //   379: areturn
    //   380: iload_1
    //   381: iload_2
    //   382: if_icmpge -226 -> 156
    //   385: aload 9
    //   387: iload_1
    //   388: baload
    //   389: sipush 255
    //   392: iand
    //   393: istore_3
    //   394: iload_3
    //   395: bipush 16
    //   397: if_icmpge +11 -> 408
    //   400: ldc_w 574
    //   403: astore 6
    //   405: goto -283 -> 122
    //   408: ldc 223
    //   410: astore 6
    //   412: goto -290 -> 122
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	415	0	paramString	String
    //   61	327	1	i	int
    //   59	324	2	j	int
    //   138	260	3	k	int
    //   11	6	4	bool	boolean
    //   37	176	5	localObject1	Object
    //   227	1	5	localObject2	Object
    //   237	77	5	localStringBuilder	StringBuilder
    //   321	55	5	localObject3	Object
    //   27	101	6	localMessageDigest	java.security.MessageDigest
    //   174	26	6	localException1	java.lang.Exception
    //   222	1	6	localException2	java.lang.Exception
    //   234	35	6	localException3	java.lang.Exception
    //   304	1	6	localException4	java.lang.Exception
    //   342	69	6	localObject4	Object
    //   14	302	7	localObject5	Object
    //   47	238	8	localObject6	Object
    //   110	276	9	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   166	171	174	java/lang/Exception
    //   42	49	222	java/lang/Exception
    //   52	60	222	java/lang/Exception
    //   70	79	222	java/lang/Exception
    //   85	90	222	java/lang/Exception
    //   93	102	222	java/lang/Exception
    //   105	112	222	java/lang/Exception
    //   115	119	222	java/lang/Exception
    //   125	133	222	java/lang/Exception
    //   136	149	222	java/lang/Exception
    //   159	166	222	java/lang/Exception
    //   21	39	227	finally
    //   21	39	234	java/lang/Exception
    //   297	302	304	java/lang/Exception
    //   42	49	321	finally
    //   52	60	321	finally
    //   70	79	321	finally
    //   85	90	321	finally
    //   93	102	321	finally
    //   105	112	321	finally
    //   115	119	321	finally
    //   125	133	321	finally
    //   136	149	321	finally
    //   159	166	321	finally
    //   242	251	321	finally
    //   254	263	321	finally
    //   266	277	321	finally
    //   280	292	321	finally
    //   327	331	334	java/lang/Exception
  }
  
  public static String a(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return "";
      }
      try
      {
        String str = UUID.randomUUID().toString().replaceAll("-", "");
        StringBuilder localStringBuilder = new StringBuilder("https://docs.qq.com/cgi-go/discuss/get_unread_reddot");
        localStringBuilder.append('?');
        localStringBuilder.append("globalPadId=");
        localStringBuilder.append(paramString1);
        localStringBuilder.append("&type=0");
        localStringBuilder.append("&xsrf=");
        localStringBuilder.append(str);
        paramString1 = new StringBuilder();
        paramString1.append("TOK=");
        paramString1.append(str);
        paramString1 = a(paramString2, localStringBuilder.toString(), "docs.qq.com", paramString1.toString());
        if (paramString1 != null)
        {
          paramString2 = new JSONObject(paramString1);
          if (paramString2.optInt("ret", -1) != 0)
          {
            if (QLog.isColorLevel())
            {
              paramString2 = new StringBuilder();
              paramString2.append("setPolicy4AllByHttp failed result");
              paramString2.append(paramString1);
              QLog.e("TeamWorkHttpUtils", 2, paramString2.toString());
              return "";
            }
          }
          else
          {
            paramString1 = paramString2.getString("data");
            return paramString1;
          }
        }
      }
      catch (JSONException paramString1)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TeamWorkHttpUtils", 2, paramString1, new Object[0]);
        }
      }
    }
    return "";
  }
  
  public static String a(String paramString1, String paramString2, String paramString3)
  {
    return a(paramString1, paramString2, paramString3, null);
  }
  
  /* Error */
  public static String a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 10
    //   3: aconst_null
    //   4: astore 7
    //   6: aconst_null
    //   7: astore 8
    //   9: aconst_null
    //   10: astore 11
    //   12: aconst_null
    //   13: astore 9
    //   15: aload 7
    //   17: astore 6
    //   19: new 67	com/tencent/mobileqq/teamwork/CustomX509TrustManager
    //   22: dup
    //   23: invokespecial 68	com/tencent/mobileqq/teamwork/CustomX509TrustManager:<init>	()V
    //   26: astore 12
    //   28: aload 7
    //   30: astore 6
    //   32: ldc 70
    //   34: invokestatic 76	javax/net/ssl/SSLContext:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    //   37: astore 13
    //   39: aload 7
    //   41: astore 6
    //   43: aload 13
    //   45: aconst_null
    //   46: iconst_1
    //   47: anewarray 78	javax/net/ssl/TrustManager
    //   50: dup
    //   51: iconst_0
    //   52: aload 12
    //   54: aastore
    //   55: aconst_null
    //   56: invokevirtual 82	javax/net/ssl/SSLContext:init	([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Ljava/security/SecureRandom;)V
    //   59: aload 7
    //   61: astore 6
    //   63: new 84	com/tencent/mobileqq/teamwork/NoSSLv3SocketFactory
    //   66: dup
    //   67: aload 13
    //   69: invokevirtual 88	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   72: invokespecial 91	com/tencent/mobileqq/teamwork/NoSSLv3SocketFactory:<init>	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   75: astore 12
    //   77: aload 7
    //   79: astore 6
    //   81: aload 12
    //   83: invokestatic 96	javax/net/ssl/HttpsURLConnection:setDefaultSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   86: aload 7
    //   88: astore 6
    //   90: new 98	java/net/URL
    //   93: dup
    //   94: aload_1
    //   95: invokespecial 101	java/net/URL:<init>	(Ljava/lang/String;)V
    //   98: invokevirtual 105	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   101: checkcast 93	javax/net/ssl/HttpsURLConnection
    //   104: astore 7
    //   106: aload 9
    //   108: astore 6
    //   110: aload 10
    //   112: astore 8
    //   114: aload 7
    //   116: aload 12
    //   118: invokevirtual 108	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   121: aload 9
    //   123: astore 6
    //   125: aload 10
    //   127: astore 8
    //   129: aload 7
    //   131: sipush 5000
    //   134: invokevirtual 112	javax/net/ssl/HttpsURLConnection:setConnectTimeout	(I)V
    //   137: aload 9
    //   139: astore 6
    //   141: aload 10
    //   143: astore 8
    //   145: aload 7
    //   147: sipush 15000
    //   150: invokevirtual 115	javax/net/ssl/HttpsURLConnection:setReadTimeout	(I)V
    //   153: aload 9
    //   155: astore 6
    //   157: aload 10
    //   159: astore 8
    //   161: aload 7
    //   163: iconst_1
    //   164: invokevirtual 119	javax/net/ssl/HttpsURLConnection:setDoInput	(Z)V
    //   167: aload 9
    //   169: astore 6
    //   171: aload 10
    //   173: astore 8
    //   175: aload 7
    //   177: iconst_0
    //   178: invokevirtual 122	javax/net/ssl/HttpsURLConnection:setUseCaches	(Z)V
    //   181: aload 9
    //   183: astore 6
    //   185: aload 10
    //   187: astore 8
    //   189: aload 7
    //   191: ldc 124
    //   193: invokevirtual 127	javax/net/ssl/HttpsURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   196: aload 9
    //   198: astore 6
    //   200: aload 10
    //   202: astore 8
    //   204: aload 7
    //   206: ldc 129
    //   208: ldc 131
    //   210: invokevirtual 135	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   213: aload 9
    //   215: astore 6
    //   217: aload 10
    //   219: astore 8
    //   221: new 57	java/lang/StringBuilder
    //   224: dup
    //   225: ldc 137
    //   227: invokespecial 138	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   230: astore 11
    //   232: aload 9
    //   234: astore 6
    //   236: aload 10
    //   238: astore 8
    //   240: aload 11
    //   242: ldc 140
    //   244: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: pop
    //   248: aload 9
    //   250: astore 6
    //   252: aload 10
    //   254: astore 8
    //   256: aload 11
    //   258: getstatic 146	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   261: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: pop
    //   265: aload 9
    //   267: astore 6
    //   269: aload 10
    //   271: astore 8
    //   273: aload 11
    //   275: ldc 140
    //   277: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: pop
    //   281: aload 9
    //   283: astore 6
    //   285: aload 10
    //   287: astore 8
    //   289: aload 11
    //   291: getstatic 151	android/os/Build:DEVICE	Ljava/lang/String;
    //   294: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: pop
    //   298: aload 9
    //   300: astore 6
    //   302: aload 10
    //   304: astore 8
    //   306: aload 11
    //   308: ldc 140
    //   310: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: pop
    //   314: aload 9
    //   316: astore 6
    //   318: aload 10
    //   320: astore 8
    //   322: aload 11
    //   324: getstatic 154	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   327: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: pop
    //   331: aload 9
    //   333: astore 6
    //   335: aload 10
    //   337: astore 8
    //   339: aload 11
    //   341: ldc 140
    //   343: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: pop
    //   347: aload 9
    //   349: astore 6
    //   351: aload 10
    //   353: astore 8
    //   355: aload 11
    //   357: ldc 156
    //   359: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: pop
    //   363: aload 9
    //   365: astore 6
    //   367: aload 10
    //   369: astore 8
    //   371: aload 11
    //   373: ldc 140
    //   375: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   378: pop
    //   379: aload 9
    //   381: astore 6
    //   383: aload 10
    //   385: astore 8
    //   387: aload 11
    //   389: ldc 158
    //   391: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   394: pop
    //   395: aload 9
    //   397: astore 6
    //   399: aload 10
    //   401: astore 8
    //   403: aload 11
    //   405: ldc 160
    //   407: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   410: pop
    //   411: aload 9
    //   413: astore 6
    //   415: aload 10
    //   417: astore 8
    //   419: aload 7
    //   421: ldc 162
    //   423: aload 11
    //   425: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   428: invokevirtual 135	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   431: aload 9
    //   433: astore 6
    //   435: aload 10
    //   437: astore 8
    //   439: aload 7
    //   441: ldc 172
    //   443: ldc_w 629
    //   446: invokevirtual 135	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   449: aload 9
    //   451: astore 6
    //   453: aload 10
    //   455: astore 8
    //   457: aload 7
    //   459: ldc 164
    //   461: ldc 166
    //   463: invokevirtual 135	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   466: aload 9
    //   468: astore 6
    //   470: aload 10
    //   472: astore 8
    //   474: aload 7
    //   476: ldc_w 631
    //   479: ldc_w 384
    //   482: invokevirtual 135	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   485: aload 9
    //   487: astore 6
    //   489: aload 10
    //   491: astore 8
    //   493: new 174	java/util/HashMap
    //   496: dup
    //   497: invokespecial 175	java/util/HashMap:<init>	()V
    //   500: astore 11
    //   502: aload 9
    //   504: astore 6
    //   506: aload 10
    //   508: astore 8
    //   510: aload 11
    //   512: ldc 129
    //   514: ldc 177
    //   516: invokeinterface 183 3 0
    //   521: pop
    //   522: aload 9
    //   524: astore 6
    //   526: aload 10
    //   528: astore 8
    //   530: aload 11
    //   532: ldc 185
    //   534: aload_1
    //   535: invokeinterface 183 3 0
    //   540: pop
    //   541: aload 9
    //   543: astore 6
    //   545: aload 10
    //   547: astore 8
    //   549: getstatic 423	mqq/app/MobileQQ:sMobileQQ	Lmqq/app/MobileQQ;
    //   552: aconst_null
    //   553: invokevirtual 427	mqq/app/MobileQQ:waitAppRuntime	(Lmqq/app/BaseActivity;)Lmqq/app/AppRuntime;
    //   556: iconst_2
    //   557: invokevirtual 430	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   560: checkcast 191	mqq/manager/TicketManager
    //   563: astore 13
    //   565: aload 9
    //   567: astore 6
    //   569: aload 10
    //   571: astore 8
    //   573: aload 13
    //   575: aload_0
    //   576: invokeinterface 195 2 0
    //   581: astore 12
    //   583: aload 9
    //   585: astore 6
    //   587: aload 10
    //   589: astore 8
    //   591: aload_1
    //   592: invokestatic 35	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   595: ifne +780 -> 1375
    //   598: aload 9
    //   600: astore 6
    //   602: aload 10
    //   604: astore 8
    //   606: aload 13
    //   608: aload_0
    //   609: aload_2
    //   610: invokeinterface 201 3 0
    //   615: astore_2
    //   616: goto +3 -> 619
    //   619: aload 9
    //   621: astore 6
    //   623: aload 10
    //   625: astore 8
    //   627: aload_2
    //   628: invokestatic 35	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   631: istore 5
    //   633: iload 5
    //   635: ifeq +62 -> 697
    //   638: aload 9
    //   640: astore 6
    //   642: aload 10
    //   644: astore 8
    //   646: ldc 203
    //   648: iconst_1
    //   649: ldc_w 633
    //   652: invokestatic 211	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   655: aload 9
    //   657: astore 6
    //   659: aload 10
    //   661: astore 8
    //   663: invokestatic 216	com/tencent/smtt/sdk/CookieManager:getInstance	()Lcom/tencent/smtt/sdk/CookieManager;
    //   666: astore_0
    //   667: aload_0
    //   668: ifnull +202 -> 870
    //   671: aload 9
    //   673: astore 6
    //   675: aload 10
    //   677: astore 8
    //   679: aload 11
    //   681: ldc 225
    //   683: aload_0
    //   684: aload_1
    //   685: invokevirtual 221	com/tencent/smtt/sdk/CookieManager:getCookie	(Ljava/lang/String;)Ljava/lang/String;
    //   688: invokeinterface 183 3 0
    //   693: pop
    //   694: goto +176 -> 870
    //   697: aload 9
    //   699: astore 6
    //   701: aload 10
    //   703: astore 8
    //   705: new 57	java/lang/StringBuilder
    //   708: dup
    //   709: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   712: astore_1
    //   713: aload 9
    //   715: astore 6
    //   717: aload 10
    //   719: astore 8
    //   721: aload_1
    //   722: ldc_w 434
    //   725: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   728: pop
    //   729: aload 9
    //   731: astore 6
    //   733: aload 10
    //   735: astore 8
    //   737: aload_1
    //   738: aload_2
    //   739: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   742: pop
    //   743: aload 9
    //   745: astore 6
    //   747: aload 10
    //   749: astore 8
    //   751: aload_1
    //   752: ldc_w 436
    //   755: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   758: pop
    //   759: aload 9
    //   761: astore 6
    //   763: aload 10
    //   765: astore 8
    //   767: aload_1
    //   768: aload_0
    //   769: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   772: pop
    //   773: aload 9
    //   775: astore 6
    //   777: aload 10
    //   779: astore 8
    //   781: aload_1
    //   782: ldc_w 438
    //   785: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   788: pop
    //   789: aload 9
    //   791: astore 6
    //   793: aload 10
    //   795: astore 8
    //   797: aload_1
    //   798: aload 12
    //   800: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   803: pop
    //   804: aload 9
    //   806: astore 6
    //   808: aload 10
    //   810: astore 8
    //   812: aload_3
    //   813: invokestatic 35	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   816: ifne +32 -> 848
    //   819: aload 9
    //   821: astore 6
    //   823: aload 10
    //   825: astore 8
    //   827: aload_1
    //   828: bipush 59
    //   830: invokevirtual 593	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   833: pop
    //   834: aload 9
    //   836: astore 6
    //   838: aload 10
    //   840: astore 8
    //   842: aload_1
    //   843: aload_3
    //   844: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   847: pop
    //   848: aload 9
    //   850: astore 6
    //   852: aload 10
    //   854: astore 8
    //   856: aload 11
    //   858: ldc 225
    //   860: aload_1
    //   861: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   864: invokeinterface 183 3 0
    //   869: pop
    //   870: aload 9
    //   872: astore 6
    //   874: aload 10
    //   876: astore 8
    //   878: aload 11
    //   880: invokeinterface 229 1 0
    //   885: invokeinterface 235 1 0
    //   890: astore_0
    //   891: aload 9
    //   893: astore 6
    //   895: aload 10
    //   897: astore 8
    //   899: aload_0
    //   900: invokeinterface 240 1 0
    //   905: ifeq +55 -> 960
    //   908: aload 9
    //   910: astore 6
    //   912: aload 10
    //   914: astore 8
    //   916: aload_0
    //   917: invokeinterface 244 1 0
    //   922: checkcast 246	java/util/Map$Entry
    //   925: astore_1
    //   926: aload 9
    //   928: astore 6
    //   930: aload 10
    //   932: astore 8
    //   934: aload 7
    //   936: aload_1
    //   937: invokeinterface 249 1 0
    //   942: checkcast 251	java/lang/String
    //   945: aload_1
    //   946: invokeinterface 254 1 0
    //   951: checkcast 251	java/lang/String
    //   954: invokevirtual 135	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   957: goto -66 -> 891
    //   960: aload 9
    //   962: astore 6
    //   964: aload 10
    //   966: astore 8
    //   968: new 451	java/lang/StringBuffer
    //   971: dup
    //   972: invokespecial 452	java/lang/StringBuffer:<init>	()V
    //   975: astore_0
    //   976: aload 9
    //   978: astore 6
    //   980: aload 10
    //   982: astore 8
    //   984: aload 7
    //   986: invokevirtual 515	javax/net/ssl/HttpsURLConnection:getResponseCode	()I
    //   989: istore 4
    //   991: iload 4
    //   993: sipush 200
    //   996: if_icmpeq +84 -> 1080
    //   999: aload 9
    //   1001: astore 6
    //   1003: aload 10
    //   1005: astore 8
    //   1007: new 57	java/lang/StringBuilder
    //   1010: dup
    //   1011: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   1014: astore_1
    //   1015: aload 9
    //   1017: astore 6
    //   1019: aload 10
    //   1021: astore 8
    //   1023: aload_1
    //   1024: ldc_w 635
    //   1027: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1030: pop
    //   1031: aload 9
    //   1033: astore 6
    //   1035: aload 10
    //   1037: astore 8
    //   1039: aload_1
    //   1040: iload 4
    //   1042: invokevirtual 407	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1045: pop
    //   1046: aload 9
    //   1048: astore 6
    //   1050: aload 10
    //   1052: astore 8
    //   1054: aload_1
    //   1055: ldc_w 519
    //   1058: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1061: pop
    //   1062: aload 9
    //   1064: astore 6
    //   1066: aload 10
    //   1068: astore 8
    //   1070: ldc 203
    //   1072: iconst_1
    //   1073: aload_1
    //   1074: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1077: invokestatic 522	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1080: aload 9
    //   1082: astore 6
    //   1084: aload 10
    //   1086: astore 8
    //   1088: new 524	java/io/BufferedReader
    //   1091: dup
    //   1092: new 526	java/io/InputStreamReader
    //   1095: dup
    //   1096: aload 7
    //   1098: invokevirtual 277	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   1101: invokespecial 527	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   1104: invokespecial 530	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   1107: astore_1
    //   1108: aload 9
    //   1110: astore 6
    //   1112: aload 10
    //   1114: astore 8
    //   1116: aload_1
    //   1117: invokevirtual 533	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   1120: astore_2
    //   1121: aload_2
    //   1122: ifnull +36 -> 1158
    //   1125: aload 9
    //   1127: astore 6
    //   1129: aload 10
    //   1131: astore 8
    //   1133: aload_0
    //   1134: aload_2
    //   1135: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1138: pop
    //   1139: aload 9
    //   1141: astore 6
    //   1143: aload 10
    //   1145: astore 8
    //   1147: aload_0
    //   1148: ldc_w 535
    //   1151: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1154: pop
    //   1155: goto -47 -> 1108
    //   1158: aload 9
    //   1160: astore 6
    //   1162: aload 10
    //   1164: astore 8
    //   1166: aload_0
    //   1167: invokevirtual 474	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   1170: astore_0
    //   1171: aload_0
    //   1172: astore 6
    //   1174: aload_0
    //   1175: astore 8
    //   1177: aload_1
    //   1178: invokevirtual 536	java/io/BufferedReader:close	()V
    //   1181: aload 7
    //   1183: ifnull +8 -> 1191
    //   1186: aload 7
    //   1188: invokevirtual 350	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   1191: aload_0
    //   1192: areturn
    //   1193: astore_0
    //   1194: goto +163 -> 1357
    //   1197: astore_2
    //   1198: aload 6
    //   1200: astore_1
    //   1201: aload 7
    //   1203: astore_0
    //   1204: goto +27 -> 1231
    //   1207: astore_2
    //   1208: aload 8
    //   1210: astore_0
    //   1211: aload 7
    //   1213: astore_1
    //   1214: goto +83 -> 1297
    //   1217: astore_0
    //   1218: aload 6
    //   1220: astore 7
    //   1222: goto +135 -> 1357
    //   1225: astore_2
    //   1226: aconst_null
    //   1227: astore_1
    //   1228: aload 8
    //   1230: astore_0
    //   1231: aload_0
    //   1232: astore 6
    //   1234: new 57	java/lang/StringBuilder
    //   1237: dup
    //   1238: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   1241: astore_3
    //   1242: aload_0
    //   1243: astore 6
    //   1245: aload_3
    //   1246: ldc_w 637
    //   1249: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1252: pop
    //   1253: aload_0
    //   1254: astore 6
    //   1256: aload_3
    //   1257: aload_2
    //   1258: invokevirtual 359	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1261: pop
    //   1262: aload_0
    //   1263: astore 6
    //   1265: ldc 203
    //   1267: iconst_1
    //   1268: aload_3
    //   1269: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1272: invokestatic 342	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1275: aload_1
    //   1276: astore_2
    //   1277: aload_0
    //   1278: ifnull +77 -> 1355
    //   1281: aload_1
    //   1282: astore_2
    //   1283: aload_0
    //   1284: astore_1
    //   1285: aload_1
    //   1286: invokevirtual 350	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   1289: aload_2
    //   1290: areturn
    //   1291: astore_2
    //   1292: aconst_null
    //   1293: astore_0
    //   1294: aload 11
    //   1296: astore_1
    //   1297: aload_1
    //   1298: astore 6
    //   1300: new 57	java/lang/StringBuilder
    //   1303: dup
    //   1304: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   1307: astore_3
    //   1308: aload_1
    //   1309: astore 6
    //   1311: aload_3
    //   1312: ldc_w 639
    //   1315: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1318: pop
    //   1319: aload_1
    //   1320: astore 6
    //   1322: aload_3
    //   1323: aload_2
    //   1324: invokevirtual 346	java/lang/Exception:toString	()Ljava/lang/String;
    //   1327: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1330: pop
    //   1331: aload_1
    //   1332: astore 6
    //   1334: ldc 203
    //   1336: iconst_1
    //   1337: aload_3
    //   1338: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1341: invokestatic 342	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1344: aload_0
    //   1345: astore_2
    //   1346: aload_1
    //   1347: ifnull +8 -> 1355
    //   1350: aload_0
    //   1351: astore_2
    //   1352: goto -67 -> 1285
    //   1355: aload_2
    //   1356: areturn
    //   1357: aload 7
    //   1359: ifnull +8 -> 1367
    //   1362: aload 7
    //   1364: invokevirtual 350	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   1367: goto +5 -> 1372
    //   1370: aload_0
    //   1371: athrow
    //   1372: goto -2 -> 1370
    //   1375: aconst_null
    //   1376: astore_2
    //   1377: goto -758 -> 619
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1380	0	paramString1	String
    //   0	1380	1	paramString2	String
    //   0	1380	2	paramString3	String
    //   0	1380	3	paramString4	String
    //   989	52	4	i	int
    //   631	3	5	bool	boolean
    //   17	1316	6	localObject1	Object
    //   4	1359	7	localObject2	Object
    //   7	1222	8	localObject3	Object
    //   13	1146	9	localObject4	Object
    //   1	1162	10	localObject5	Object
    //   10	1285	11	localObject6	Object
    //   26	773	12	localObject7	Object
    //   37	570	13	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   114	121	1193	finally
    //   129	137	1193	finally
    //   145	153	1193	finally
    //   161	167	1193	finally
    //   175	181	1193	finally
    //   189	196	1193	finally
    //   204	213	1193	finally
    //   221	232	1193	finally
    //   240	248	1193	finally
    //   256	265	1193	finally
    //   273	281	1193	finally
    //   289	298	1193	finally
    //   306	314	1193	finally
    //   322	331	1193	finally
    //   339	347	1193	finally
    //   355	363	1193	finally
    //   371	379	1193	finally
    //   387	395	1193	finally
    //   403	411	1193	finally
    //   419	431	1193	finally
    //   439	449	1193	finally
    //   457	466	1193	finally
    //   474	485	1193	finally
    //   493	502	1193	finally
    //   510	522	1193	finally
    //   530	541	1193	finally
    //   549	565	1193	finally
    //   573	583	1193	finally
    //   591	598	1193	finally
    //   606	616	1193	finally
    //   627	633	1193	finally
    //   646	655	1193	finally
    //   663	667	1193	finally
    //   679	694	1193	finally
    //   705	713	1193	finally
    //   721	729	1193	finally
    //   737	743	1193	finally
    //   751	759	1193	finally
    //   767	773	1193	finally
    //   781	789	1193	finally
    //   797	804	1193	finally
    //   812	819	1193	finally
    //   827	834	1193	finally
    //   842	848	1193	finally
    //   856	870	1193	finally
    //   878	891	1193	finally
    //   899	908	1193	finally
    //   916	926	1193	finally
    //   934	957	1193	finally
    //   968	976	1193	finally
    //   984	991	1193	finally
    //   1007	1015	1193	finally
    //   1023	1031	1193	finally
    //   1039	1046	1193	finally
    //   1054	1062	1193	finally
    //   1070	1080	1193	finally
    //   1088	1108	1193	finally
    //   1116	1121	1193	finally
    //   1133	1139	1193	finally
    //   1147	1155	1193	finally
    //   1166	1171	1193	finally
    //   1177	1181	1193	finally
    //   114	121	1197	java/lang/OutOfMemoryError
    //   129	137	1197	java/lang/OutOfMemoryError
    //   145	153	1197	java/lang/OutOfMemoryError
    //   161	167	1197	java/lang/OutOfMemoryError
    //   175	181	1197	java/lang/OutOfMemoryError
    //   189	196	1197	java/lang/OutOfMemoryError
    //   204	213	1197	java/lang/OutOfMemoryError
    //   221	232	1197	java/lang/OutOfMemoryError
    //   240	248	1197	java/lang/OutOfMemoryError
    //   256	265	1197	java/lang/OutOfMemoryError
    //   273	281	1197	java/lang/OutOfMemoryError
    //   289	298	1197	java/lang/OutOfMemoryError
    //   306	314	1197	java/lang/OutOfMemoryError
    //   322	331	1197	java/lang/OutOfMemoryError
    //   339	347	1197	java/lang/OutOfMemoryError
    //   355	363	1197	java/lang/OutOfMemoryError
    //   371	379	1197	java/lang/OutOfMemoryError
    //   387	395	1197	java/lang/OutOfMemoryError
    //   403	411	1197	java/lang/OutOfMemoryError
    //   419	431	1197	java/lang/OutOfMemoryError
    //   439	449	1197	java/lang/OutOfMemoryError
    //   457	466	1197	java/lang/OutOfMemoryError
    //   474	485	1197	java/lang/OutOfMemoryError
    //   493	502	1197	java/lang/OutOfMemoryError
    //   510	522	1197	java/lang/OutOfMemoryError
    //   530	541	1197	java/lang/OutOfMemoryError
    //   549	565	1197	java/lang/OutOfMemoryError
    //   573	583	1197	java/lang/OutOfMemoryError
    //   591	598	1197	java/lang/OutOfMemoryError
    //   606	616	1197	java/lang/OutOfMemoryError
    //   627	633	1197	java/lang/OutOfMemoryError
    //   646	655	1197	java/lang/OutOfMemoryError
    //   663	667	1197	java/lang/OutOfMemoryError
    //   679	694	1197	java/lang/OutOfMemoryError
    //   705	713	1197	java/lang/OutOfMemoryError
    //   721	729	1197	java/lang/OutOfMemoryError
    //   737	743	1197	java/lang/OutOfMemoryError
    //   751	759	1197	java/lang/OutOfMemoryError
    //   767	773	1197	java/lang/OutOfMemoryError
    //   781	789	1197	java/lang/OutOfMemoryError
    //   797	804	1197	java/lang/OutOfMemoryError
    //   812	819	1197	java/lang/OutOfMemoryError
    //   827	834	1197	java/lang/OutOfMemoryError
    //   842	848	1197	java/lang/OutOfMemoryError
    //   856	870	1197	java/lang/OutOfMemoryError
    //   878	891	1197	java/lang/OutOfMemoryError
    //   899	908	1197	java/lang/OutOfMemoryError
    //   916	926	1197	java/lang/OutOfMemoryError
    //   934	957	1197	java/lang/OutOfMemoryError
    //   968	976	1197	java/lang/OutOfMemoryError
    //   984	991	1197	java/lang/OutOfMemoryError
    //   1007	1015	1197	java/lang/OutOfMemoryError
    //   1023	1031	1197	java/lang/OutOfMemoryError
    //   1039	1046	1197	java/lang/OutOfMemoryError
    //   1054	1062	1197	java/lang/OutOfMemoryError
    //   1070	1080	1197	java/lang/OutOfMemoryError
    //   1088	1108	1197	java/lang/OutOfMemoryError
    //   1116	1121	1197	java/lang/OutOfMemoryError
    //   1133	1139	1197	java/lang/OutOfMemoryError
    //   1147	1155	1197	java/lang/OutOfMemoryError
    //   1166	1171	1197	java/lang/OutOfMemoryError
    //   1177	1181	1197	java/lang/OutOfMemoryError
    //   114	121	1207	java/lang/Exception
    //   129	137	1207	java/lang/Exception
    //   145	153	1207	java/lang/Exception
    //   161	167	1207	java/lang/Exception
    //   175	181	1207	java/lang/Exception
    //   189	196	1207	java/lang/Exception
    //   204	213	1207	java/lang/Exception
    //   221	232	1207	java/lang/Exception
    //   240	248	1207	java/lang/Exception
    //   256	265	1207	java/lang/Exception
    //   273	281	1207	java/lang/Exception
    //   289	298	1207	java/lang/Exception
    //   306	314	1207	java/lang/Exception
    //   322	331	1207	java/lang/Exception
    //   339	347	1207	java/lang/Exception
    //   355	363	1207	java/lang/Exception
    //   371	379	1207	java/lang/Exception
    //   387	395	1207	java/lang/Exception
    //   403	411	1207	java/lang/Exception
    //   419	431	1207	java/lang/Exception
    //   439	449	1207	java/lang/Exception
    //   457	466	1207	java/lang/Exception
    //   474	485	1207	java/lang/Exception
    //   493	502	1207	java/lang/Exception
    //   510	522	1207	java/lang/Exception
    //   530	541	1207	java/lang/Exception
    //   549	565	1207	java/lang/Exception
    //   573	583	1207	java/lang/Exception
    //   591	598	1207	java/lang/Exception
    //   606	616	1207	java/lang/Exception
    //   627	633	1207	java/lang/Exception
    //   646	655	1207	java/lang/Exception
    //   663	667	1207	java/lang/Exception
    //   679	694	1207	java/lang/Exception
    //   705	713	1207	java/lang/Exception
    //   721	729	1207	java/lang/Exception
    //   737	743	1207	java/lang/Exception
    //   751	759	1207	java/lang/Exception
    //   767	773	1207	java/lang/Exception
    //   781	789	1207	java/lang/Exception
    //   797	804	1207	java/lang/Exception
    //   812	819	1207	java/lang/Exception
    //   827	834	1207	java/lang/Exception
    //   842	848	1207	java/lang/Exception
    //   856	870	1207	java/lang/Exception
    //   878	891	1207	java/lang/Exception
    //   899	908	1207	java/lang/Exception
    //   916	926	1207	java/lang/Exception
    //   934	957	1207	java/lang/Exception
    //   968	976	1207	java/lang/Exception
    //   984	991	1207	java/lang/Exception
    //   1007	1015	1207	java/lang/Exception
    //   1023	1031	1207	java/lang/Exception
    //   1039	1046	1207	java/lang/Exception
    //   1054	1062	1207	java/lang/Exception
    //   1070	1080	1207	java/lang/Exception
    //   1088	1108	1207	java/lang/Exception
    //   1116	1121	1207	java/lang/Exception
    //   1133	1139	1207	java/lang/Exception
    //   1147	1155	1207	java/lang/Exception
    //   1166	1171	1207	java/lang/Exception
    //   1177	1181	1207	java/lang/Exception
    //   19	28	1217	finally
    //   32	39	1217	finally
    //   43	59	1217	finally
    //   63	77	1217	finally
    //   81	86	1217	finally
    //   90	106	1217	finally
    //   1234	1242	1217	finally
    //   1245	1253	1217	finally
    //   1256	1262	1217	finally
    //   1265	1275	1217	finally
    //   1300	1308	1217	finally
    //   1311	1319	1217	finally
    //   1322	1331	1217	finally
    //   1334	1344	1217	finally
    //   19	28	1225	java/lang/OutOfMemoryError
    //   32	39	1225	java/lang/OutOfMemoryError
    //   43	59	1225	java/lang/OutOfMemoryError
    //   63	77	1225	java/lang/OutOfMemoryError
    //   81	86	1225	java/lang/OutOfMemoryError
    //   90	106	1225	java/lang/OutOfMemoryError
    //   19	28	1291	java/lang/Exception
    //   32	39	1291	java/lang/Exception
    //   43	59	1291	java/lang/Exception
    //   63	77	1291	java/lang/Exception
    //   81	86	1291	java/lang/Exception
    //   90	106	1291	java/lang/Exception
  }
  
  /* Error */
  public static String a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, java.util.Map<String, String> paramMap, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 641	java/lang/String:toString	()Ljava/lang/String;
    //   4: astore 11
    //   6: aconst_null
    //   7: astore 8
    //   9: aconst_null
    //   10: astore 10
    //   12: aconst_null
    //   13: astore 9
    //   15: aload 8
    //   17: astore_2
    //   18: new 67	com/tencent/mobileqq/teamwork/CustomX509TrustManager
    //   21: dup
    //   22: invokespecial 68	com/tencent/mobileqq/teamwork/CustomX509TrustManager:<init>	()V
    //   25: astore 12
    //   27: aload 8
    //   29: astore_2
    //   30: ldc 70
    //   32: invokestatic 76	javax/net/ssl/SSLContext:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    //   35: astore 13
    //   37: aload 8
    //   39: astore_2
    //   40: aload 13
    //   42: aconst_null
    //   43: iconst_1
    //   44: anewarray 78	javax/net/ssl/TrustManager
    //   47: dup
    //   48: iconst_0
    //   49: aload 12
    //   51: aastore
    //   52: aconst_null
    //   53: invokevirtual 82	javax/net/ssl/SSLContext:init	([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Ljava/security/SecureRandom;)V
    //   56: aload 8
    //   58: astore_2
    //   59: new 84	com/tencent/mobileqq/teamwork/NoSSLv3SocketFactory
    //   62: dup
    //   63: aload 13
    //   65: invokevirtual 88	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   68: invokespecial 91	com/tencent/mobileqq/teamwork/NoSSLv3SocketFactory:<init>	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   71: astore 12
    //   73: aload 8
    //   75: astore_2
    //   76: aload 12
    //   78: invokestatic 96	javax/net/ssl/HttpsURLConnection:setDefaultSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   81: aload 8
    //   83: astore_2
    //   84: new 98	java/net/URL
    //   87: dup
    //   88: aload 11
    //   90: invokespecial 101	java/net/URL:<init>	(Ljava/lang/String;)V
    //   93: invokevirtual 105	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   96: checkcast 93	javax/net/ssl/HttpsURLConnection
    //   99: astore 8
    //   101: aload 9
    //   103: astore_2
    //   104: aload 8
    //   106: aload 12
    //   108: invokevirtual 108	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   111: aload 9
    //   113: astore_2
    //   114: aload 8
    //   116: sipush 5000
    //   119: invokevirtual 112	javax/net/ssl/HttpsURLConnection:setConnectTimeout	(I)V
    //   122: aload 9
    //   124: astore_2
    //   125: aload 8
    //   127: sipush 30000
    //   130: invokevirtual 115	javax/net/ssl/HttpsURLConnection:setReadTimeout	(I)V
    //   133: aload 9
    //   135: astore_2
    //   136: aload 8
    //   138: iconst_1
    //   139: invokevirtual 415	javax/net/ssl/HttpsURLConnection:setDoOutput	(Z)V
    //   142: aload 9
    //   144: astore_2
    //   145: aload 8
    //   147: iconst_1
    //   148: invokevirtual 119	javax/net/ssl/HttpsURLConnection:setDoInput	(Z)V
    //   151: aload 9
    //   153: astore_2
    //   154: aload 8
    //   156: iconst_0
    //   157: invokevirtual 122	javax/net/ssl/HttpsURLConnection:setUseCaches	(Z)V
    //   160: aload 9
    //   162: astore_2
    //   163: aload 8
    //   165: ldc_w 417
    //   168: invokevirtual 127	javax/net/ssl/HttpsURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   171: aload 9
    //   173: astore_2
    //   174: aload 8
    //   176: ldc 129
    //   178: ldc 131
    //   180: invokevirtual 135	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   183: aload 9
    //   185: astore_2
    //   186: new 57	java/lang/StringBuilder
    //   189: dup
    //   190: ldc 137
    //   192: invokespecial 138	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   195: astore 10
    //   197: aload 9
    //   199: astore_2
    //   200: aload 10
    //   202: ldc 140
    //   204: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: pop
    //   208: aload 9
    //   210: astore_2
    //   211: aload 10
    //   213: getstatic 146	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   216: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: pop
    //   220: aload 9
    //   222: astore_2
    //   223: aload 10
    //   225: ldc 140
    //   227: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: pop
    //   231: aload 9
    //   233: astore_2
    //   234: aload 10
    //   236: getstatic 151	android/os/Build:DEVICE	Ljava/lang/String;
    //   239: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: pop
    //   243: aload 9
    //   245: astore_2
    //   246: aload 10
    //   248: ldc 140
    //   250: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: pop
    //   254: aload 9
    //   256: astore_2
    //   257: aload 10
    //   259: getstatic 154	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   262: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: pop
    //   266: aload 9
    //   268: astore_2
    //   269: aload 10
    //   271: ldc 140
    //   273: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: pop
    //   277: aload 9
    //   279: astore_2
    //   280: aload 10
    //   282: ldc 156
    //   284: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: pop
    //   288: aload 9
    //   290: astore_2
    //   291: aload 10
    //   293: ldc 140
    //   295: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: pop
    //   299: aload 9
    //   301: astore_2
    //   302: aload 10
    //   304: ldc 158
    //   306: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: pop
    //   310: aload 9
    //   312: astore_2
    //   313: aload 10
    //   315: ldc 160
    //   317: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: pop
    //   321: aload 9
    //   323: astore_2
    //   324: aload 8
    //   326: ldc 162
    //   328: aload 10
    //   330: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   333: invokevirtual 135	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   336: iload 6
    //   338: ifeq +19 -> 357
    //   341: aload 9
    //   343: astore_2
    //   344: aload 8
    //   346: ldc 172
    //   348: ldc_w 629
    //   351: invokevirtual 135	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   354: goto +16 -> 370
    //   357: aload 9
    //   359: astore_2
    //   360: aload 8
    //   362: ldc 172
    //   364: ldc_w 643
    //   367: invokevirtual 135	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   370: aload 9
    //   372: astore_2
    //   373: aload 8
    //   375: ldc 164
    //   377: ldc 166
    //   379: invokevirtual 135	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   382: aload 9
    //   384: astore_2
    //   385: aload 8
    //   387: ldc_w 631
    //   390: ldc_w 384
    //   393: invokevirtual 135	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   396: aload 5
    //   398: ifnull +79 -> 477
    //   401: aload 9
    //   403: astore_2
    //   404: aload 5
    //   406: invokeinterface 229 1 0
    //   411: invokeinterface 235 1 0
    //   416: astore 5
    //   418: aload 9
    //   420: astore_2
    //   421: aload 5
    //   423: invokeinterface 240 1 0
    //   428: ifeq +49 -> 477
    //   431: aload 9
    //   433: astore_2
    //   434: aload 5
    //   436: invokeinterface 244 1 0
    //   441: checkcast 246	java/util/Map$Entry
    //   444: astore 10
    //   446: aload 9
    //   448: astore_2
    //   449: aload 8
    //   451: aload 10
    //   453: invokeinterface 249 1 0
    //   458: checkcast 251	java/lang/String
    //   461: aload 10
    //   463: invokeinterface 254 1 0
    //   468: checkcast 251	java/lang/String
    //   471: invokevirtual 135	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   474: goto -56 -> 418
    //   477: aload 9
    //   479: astore_2
    //   480: new 174	java/util/HashMap
    //   483: dup
    //   484: invokespecial 175	java/util/HashMap:<init>	()V
    //   487: astore 5
    //   489: aload 9
    //   491: astore_2
    //   492: aload 5
    //   494: ldc 129
    //   496: ldc 177
    //   498: invokeinterface 183 3 0
    //   503: pop
    //   504: aload 9
    //   506: astore_2
    //   507: aload 5
    //   509: ldc 185
    //   511: aload 11
    //   513: invokeinterface 183 3 0
    //   518: pop
    //   519: aload 9
    //   521: astore_2
    //   522: getstatic 423	mqq/app/MobileQQ:sMobileQQ	Lmqq/app/MobileQQ;
    //   525: aconst_null
    //   526: invokevirtual 427	mqq/app/MobileQQ:waitAppRuntime	(Lmqq/app/BaseActivity;)Lmqq/app/AppRuntime;
    //   529: iconst_2
    //   530: invokevirtual 430	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   533: checkcast 191	mqq/manager/TicketManager
    //   536: astore 12
    //   538: aload 9
    //   540: astore_2
    //   541: aload 12
    //   543: aload_1
    //   544: invokeinterface 195 2 0
    //   549: astore 10
    //   551: aload 9
    //   553: astore_2
    //   554: aload 11
    //   556: invokestatic 35	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   559: ifne +604 -> 1163
    //   562: aload 9
    //   564: astore_2
    //   565: aload 12
    //   567: aload_1
    //   568: aload_3
    //   569: invokeinterface 201 3 0
    //   574: astore_3
    //   575: goto +3 -> 578
    //   578: aload 9
    //   580: astore_2
    //   581: aload_3
    //   582: invokestatic 35	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   585: istore 6
    //   587: iload 6
    //   589: ifeq +48 -> 637
    //   592: aload 9
    //   594: astore_2
    //   595: ldc 203
    //   597: iconst_1
    //   598: ldc_w 633
    //   601: invokestatic 211	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   604: aload 9
    //   606: astore_2
    //   607: invokestatic 216	com/tencent/smtt/sdk/CookieManager:getInstance	()Lcom/tencent/smtt/sdk/CookieManager;
    //   610: astore_1
    //   611: aload_1
    //   612: ifnull +155 -> 767
    //   615: aload 9
    //   617: astore_2
    //   618: aload 5
    //   620: ldc 225
    //   622: aload_1
    //   623: aload 11
    //   625: invokevirtual 221	com/tencent/smtt/sdk/CookieManager:getCookie	(Ljava/lang/String;)Ljava/lang/String;
    //   628: invokeinterface 183 3 0
    //   633: pop
    //   634: goto +133 -> 767
    //   637: aload 9
    //   639: astore_2
    //   640: new 57	java/lang/StringBuilder
    //   643: dup
    //   644: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   647: astore 11
    //   649: aload 9
    //   651: astore_2
    //   652: aload 11
    //   654: ldc_w 434
    //   657: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   660: pop
    //   661: aload 9
    //   663: astore_2
    //   664: aload 11
    //   666: aload_3
    //   667: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   670: pop
    //   671: aload 9
    //   673: astore_2
    //   674: aload 11
    //   676: ldc_w 436
    //   679: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   682: pop
    //   683: aload 9
    //   685: astore_2
    //   686: aload 11
    //   688: aload_1
    //   689: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   692: pop
    //   693: aload 9
    //   695: astore_2
    //   696: aload 11
    //   698: ldc_w 438
    //   701: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   704: pop
    //   705: aload 9
    //   707: astore_2
    //   708: aload 11
    //   710: aload 10
    //   712: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   715: pop
    //   716: aload 9
    //   718: astore_2
    //   719: aload 4
    //   721: invokestatic 35	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   724: ifne +25 -> 749
    //   727: aload 9
    //   729: astore_2
    //   730: aload 11
    //   732: bipush 59
    //   734: invokevirtual 593	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   737: pop
    //   738: aload 9
    //   740: astore_2
    //   741: aload 11
    //   743: aload 4
    //   745: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   748: pop
    //   749: aload 9
    //   751: astore_2
    //   752: aload 5
    //   754: ldc 225
    //   756: aload 11
    //   758: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   761: invokeinterface 183 3 0
    //   766: pop
    //   767: aload 9
    //   769: astore_2
    //   770: aload 5
    //   772: invokeinterface 229 1 0
    //   777: invokeinterface 235 1 0
    //   782: astore_1
    //   783: aload 9
    //   785: astore_2
    //   786: aload_1
    //   787: invokeinterface 240 1 0
    //   792: ifeq +45 -> 837
    //   795: aload 9
    //   797: astore_2
    //   798: aload_1
    //   799: invokeinterface 244 1 0
    //   804: checkcast 246	java/util/Map$Entry
    //   807: astore_3
    //   808: aload 9
    //   810: astore_2
    //   811: aload 8
    //   813: aload_3
    //   814: invokeinterface 249 1 0
    //   819: checkcast 251	java/lang/String
    //   822: aload_3
    //   823: invokeinterface 254 1 0
    //   828: checkcast 251	java/lang/String
    //   831: invokevirtual 135	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   834: goto -51 -> 783
    //   837: aload 9
    //   839: astore_2
    //   840: new 442	java/io/DataOutputStream
    //   843: dup
    //   844: aload 8
    //   846: invokevirtual 446	javax/net/ssl/HttpsURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   849: invokespecial 449	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   852: astore_1
    //   853: aload_1
    //   854: aload_0
    //   855: ldc_w 384
    //   858: invokevirtual 646	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   861: invokevirtual 480	java/io/OutputStream:write	([B)V
    //   864: aload_1
    //   865: invokevirtual 498	java/io/OutputStream:flush	()V
    //   868: aload_1
    //   869: invokevirtual 499	java/io/OutputStream:close	()V
    //   872: aload 9
    //   874: astore_2
    //   875: new 451	java/lang/StringBuffer
    //   878: dup
    //   879: invokespecial 452	java/lang/StringBuffer:<init>	()V
    //   882: astore_0
    //   883: aload 9
    //   885: astore_2
    //   886: aload 8
    //   888: invokevirtual 515	javax/net/ssl/HttpsURLConnection:getResponseCode	()I
    //   891: istore 7
    //   893: iload 7
    //   895: sipush 200
    //   898: if_icmpeq +59 -> 957
    //   901: aload 9
    //   903: astore_2
    //   904: new 57	java/lang/StringBuilder
    //   907: dup
    //   908: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   911: astore_1
    //   912: aload 9
    //   914: astore_2
    //   915: aload_1
    //   916: ldc_w 635
    //   919: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   922: pop
    //   923: aload 9
    //   925: astore_2
    //   926: aload_1
    //   927: iload 7
    //   929: invokevirtual 407	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   932: pop
    //   933: aload 9
    //   935: astore_2
    //   936: aload_1
    //   937: ldc_w 519
    //   940: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   943: pop
    //   944: aload 9
    //   946: astore_2
    //   947: ldc 203
    //   949: iconst_1
    //   950: aload_1
    //   951: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   954: invokestatic 522	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   957: aload 9
    //   959: astore_2
    //   960: new 524	java/io/BufferedReader
    //   963: dup
    //   964: new 526	java/io/InputStreamReader
    //   967: dup
    //   968: aload 8
    //   970: invokevirtual 277	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   973: invokespecial 527	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   976: invokespecial 530	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   979: astore_1
    //   980: aload 9
    //   982: astore_2
    //   983: aload_1
    //   984: invokevirtual 533	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   987: astore_3
    //   988: aload_3
    //   989: ifnull +26 -> 1015
    //   992: aload 9
    //   994: astore_2
    //   995: aload_0
    //   996: aload_3
    //   997: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1000: pop
    //   1001: aload 9
    //   1003: astore_2
    //   1004: aload_0
    //   1005: ldc_w 535
    //   1008: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1011: pop
    //   1012: goto -32 -> 980
    //   1015: aload 9
    //   1017: astore_2
    //   1018: aload_0
    //   1019: invokevirtual 474	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   1022: astore_0
    //   1023: aload_0
    //   1024: astore_2
    //   1025: aload_1
    //   1026: invokevirtual 536	java/io/BufferedReader:close	()V
    //   1029: aload 8
    //   1031: ifnull +8 -> 1039
    //   1034: aload 8
    //   1036: invokevirtual 350	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   1039: aload_0
    //   1040: areturn
    //   1041: aload 9
    //   1043: astore_2
    //   1044: aload_1
    //   1045: invokevirtual 499	java/io/OutputStream:close	()V
    //   1048: aload 8
    //   1050: ifnull +8 -> 1058
    //   1053: aload 8
    //   1055: invokevirtual 350	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   1058: aconst_null
    //   1059: areturn
    //   1060: astore_0
    //   1061: aload 8
    //   1063: astore_2
    //   1064: goto +79 -> 1143
    //   1067: astore_1
    //   1068: aload 8
    //   1070: astore_0
    //   1071: aload_2
    //   1072: astore_3
    //   1073: goto +13 -> 1086
    //   1076: astore_0
    //   1077: goto +66 -> 1143
    //   1080: astore_1
    //   1081: aconst_null
    //   1082: astore_3
    //   1083: aload 10
    //   1085: astore_0
    //   1086: aload_0
    //   1087: astore_2
    //   1088: new 57	java/lang/StringBuilder
    //   1091: dup
    //   1092: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   1095: astore 4
    //   1097: aload_0
    //   1098: astore_2
    //   1099: aload 4
    //   1101: ldc_w 639
    //   1104: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1107: pop
    //   1108: aload_0
    //   1109: astore_2
    //   1110: aload 4
    //   1112: aload_1
    //   1113: invokevirtual 346	java/lang/Exception:toString	()Ljava/lang/String;
    //   1116: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1119: pop
    //   1120: aload_0
    //   1121: astore_2
    //   1122: ldc 203
    //   1124: iconst_1
    //   1125: aload 4
    //   1127: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1130: invokestatic 342	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1133: aload_0
    //   1134: ifnull +7 -> 1141
    //   1137: aload_0
    //   1138: invokevirtual 350	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   1141: aload_3
    //   1142: areturn
    //   1143: aload_2
    //   1144: ifnull +7 -> 1151
    //   1147: aload_2
    //   1148: invokevirtual 350	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   1151: goto +5 -> 1156
    //   1154: aload_0
    //   1155: athrow
    //   1156: goto -2 -> 1154
    //   1159: astore_0
    //   1160: goto -119 -> 1041
    //   1163: aconst_null
    //   1164: astore_3
    //   1165: goto -587 -> 578
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1168	0	paramString1	String
    //   0	1168	1	paramString2	String
    //   0	1168	2	paramString3	String
    //   0	1168	3	paramString4	String
    //   0	1168	4	paramString5	String
    //   0	1168	5	paramMap	java.util.Map<String, String>
    //   0	1168	6	paramBoolean	boolean
    //   891	37	7	i	int
    //   7	1062	8	localHttpsURLConnection	javax.net.ssl.HttpsURLConnection
    //   13	1029	9	localObject1	Object
    //   10	1074	10	localObject2	Object
    //   4	753	11	localObject3	Object
    //   25	541	12	localObject4	Object
    //   35	29	13	localSSLContext	javax.net.ssl.SSLContext
    // Exception table:
    //   from	to	target	type
    //   104	111	1060	finally
    //   114	122	1060	finally
    //   125	133	1060	finally
    //   136	142	1060	finally
    //   145	151	1060	finally
    //   154	160	1060	finally
    //   163	171	1060	finally
    //   174	183	1060	finally
    //   186	197	1060	finally
    //   200	208	1060	finally
    //   211	220	1060	finally
    //   223	231	1060	finally
    //   234	243	1060	finally
    //   246	254	1060	finally
    //   257	266	1060	finally
    //   269	277	1060	finally
    //   280	288	1060	finally
    //   291	299	1060	finally
    //   302	310	1060	finally
    //   313	321	1060	finally
    //   324	336	1060	finally
    //   344	354	1060	finally
    //   360	370	1060	finally
    //   373	382	1060	finally
    //   385	396	1060	finally
    //   404	418	1060	finally
    //   421	431	1060	finally
    //   434	446	1060	finally
    //   449	474	1060	finally
    //   480	489	1060	finally
    //   492	504	1060	finally
    //   507	519	1060	finally
    //   522	538	1060	finally
    //   541	551	1060	finally
    //   554	562	1060	finally
    //   565	575	1060	finally
    //   581	587	1060	finally
    //   595	604	1060	finally
    //   607	611	1060	finally
    //   618	634	1060	finally
    //   640	649	1060	finally
    //   652	661	1060	finally
    //   664	671	1060	finally
    //   674	683	1060	finally
    //   686	693	1060	finally
    //   696	705	1060	finally
    //   708	716	1060	finally
    //   719	727	1060	finally
    //   730	738	1060	finally
    //   741	749	1060	finally
    //   752	767	1060	finally
    //   770	783	1060	finally
    //   786	795	1060	finally
    //   798	808	1060	finally
    //   811	834	1060	finally
    //   840	853	1060	finally
    //   853	872	1060	finally
    //   875	883	1060	finally
    //   886	893	1060	finally
    //   904	912	1060	finally
    //   915	923	1060	finally
    //   926	933	1060	finally
    //   936	944	1060	finally
    //   947	957	1060	finally
    //   960	980	1060	finally
    //   983	988	1060	finally
    //   995	1001	1060	finally
    //   1004	1012	1060	finally
    //   1018	1023	1060	finally
    //   1025	1029	1060	finally
    //   1044	1048	1060	finally
    //   104	111	1067	java/lang/Exception
    //   114	122	1067	java/lang/Exception
    //   125	133	1067	java/lang/Exception
    //   136	142	1067	java/lang/Exception
    //   145	151	1067	java/lang/Exception
    //   154	160	1067	java/lang/Exception
    //   163	171	1067	java/lang/Exception
    //   174	183	1067	java/lang/Exception
    //   186	197	1067	java/lang/Exception
    //   200	208	1067	java/lang/Exception
    //   211	220	1067	java/lang/Exception
    //   223	231	1067	java/lang/Exception
    //   234	243	1067	java/lang/Exception
    //   246	254	1067	java/lang/Exception
    //   257	266	1067	java/lang/Exception
    //   269	277	1067	java/lang/Exception
    //   280	288	1067	java/lang/Exception
    //   291	299	1067	java/lang/Exception
    //   302	310	1067	java/lang/Exception
    //   313	321	1067	java/lang/Exception
    //   324	336	1067	java/lang/Exception
    //   344	354	1067	java/lang/Exception
    //   360	370	1067	java/lang/Exception
    //   373	382	1067	java/lang/Exception
    //   385	396	1067	java/lang/Exception
    //   404	418	1067	java/lang/Exception
    //   421	431	1067	java/lang/Exception
    //   434	446	1067	java/lang/Exception
    //   449	474	1067	java/lang/Exception
    //   480	489	1067	java/lang/Exception
    //   492	504	1067	java/lang/Exception
    //   507	519	1067	java/lang/Exception
    //   522	538	1067	java/lang/Exception
    //   541	551	1067	java/lang/Exception
    //   554	562	1067	java/lang/Exception
    //   565	575	1067	java/lang/Exception
    //   581	587	1067	java/lang/Exception
    //   595	604	1067	java/lang/Exception
    //   607	611	1067	java/lang/Exception
    //   618	634	1067	java/lang/Exception
    //   640	649	1067	java/lang/Exception
    //   652	661	1067	java/lang/Exception
    //   664	671	1067	java/lang/Exception
    //   674	683	1067	java/lang/Exception
    //   686	693	1067	java/lang/Exception
    //   696	705	1067	java/lang/Exception
    //   708	716	1067	java/lang/Exception
    //   719	727	1067	java/lang/Exception
    //   730	738	1067	java/lang/Exception
    //   741	749	1067	java/lang/Exception
    //   752	767	1067	java/lang/Exception
    //   770	783	1067	java/lang/Exception
    //   786	795	1067	java/lang/Exception
    //   798	808	1067	java/lang/Exception
    //   811	834	1067	java/lang/Exception
    //   840	853	1067	java/lang/Exception
    //   875	883	1067	java/lang/Exception
    //   886	893	1067	java/lang/Exception
    //   904	912	1067	java/lang/Exception
    //   915	923	1067	java/lang/Exception
    //   926	933	1067	java/lang/Exception
    //   936	944	1067	java/lang/Exception
    //   947	957	1067	java/lang/Exception
    //   960	980	1067	java/lang/Exception
    //   983	988	1067	java/lang/Exception
    //   995	1001	1067	java/lang/Exception
    //   1004	1012	1067	java/lang/Exception
    //   1018	1023	1067	java/lang/Exception
    //   1025	1029	1067	java/lang/Exception
    //   1044	1048	1067	java/lang/Exception
    //   18	27	1076	finally
    //   30	37	1076	finally
    //   40	56	1076	finally
    //   59	73	1076	finally
    //   76	81	1076	finally
    //   84	101	1076	finally
    //   1088	1097	1076	finally
    //   1099	1108	1076	finally
    //   1110	1120	1076	finally
    //   1122	1133	1076	finally
    //   18	27	1080	java/lang/Exception
    //   30	37	1080	java/lang/Exception
    //   40	56	1080	java/lang/Exception
    //   59	73	1080	java/lang/Exception
    //   76	81	1080	java/lang/Exception
    //   84	101	1080	java/lang/Exception
    //   853	872	1159	java/lang/Exception
  }
  
  /* Error */
  public static final String a(JSONObject paramJSONObject, TeamWorkFileImportInfo paramTeamWorkFileImportInfo, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 6
    //   6: aconst_null
    //   7: astore 7
    //   9: aload_0
    //   10: ifnull +1110 -> 1120
    //   13: aload_2
    //   14: invokestatic 35	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   17: ifeq +6 -> 23
    //   20: goto +1100 -> 1120
    //   23: new 57	java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   30: astore 8
    //   32: aload 8
    //   34: ldc_w 373
    //   37: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: pop
    //   41: aload 8
    //   43: aload_2
    //   44: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: pop
    //   48: aload 8
    //   50: getstatic 654	com/tencent/mobileqq/teamwork/TeamWorkConstants:p	Ljava/lang/String;
    //   53: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: aload_1
    //   58: getfield 657	com/tencent/mobileqq/teamwork/bean/TeamWorkFileImportInfo:v	Ljava/lang/String;
    //   61: astore_1
    //   62: aload_1
    //   63: invokestatic 35	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   66: ifne +19 -> 85
    //   69: aload 8
    //   71: ldc_w 659
    //   74: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: pop
    //   78: aload 8
    //   80: aload_1
    //   81: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: pop
    //   85: aload 8
    //   87: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   90: astore 8
    //   92: aload 5
    //   94: astore_1
    //   95: new 67	com/tencent/mobileqq/teamwork/CustomX509TrustManager
    //   98: dup
    //   99: invokespecial 68	com/tencent/mobileqq/teamwork/CustomX509TrustManager:<init>	()V
    //   102: astore 9
    //   104: aload 5
    //   106: astore_1
    //   107: ldc 70
    //   109: invokestatic 76	javax/net/ssl/SSLContext:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    //   112: astore 10
    //   114: aload 5
    //   116: astore_1
    //   117: aload 10
    //   119: aconst_null
    //   120: iconst_1
    //   121: anewarray 78	javax/net/ssl/TrustManager
    //   124: dup
    //   125: iconst_0
    //   126: aload 9
    //   128: aastore
    //   129: aconst_null
    //   130: invokevirtual 82	javax/net/ssl/SSLContext:init	([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Ljava/security/SecureRandom;)V
    //   133: aload 5
    //   135: astore_1
    //   136: new 84	com/tencent/mobileqq/teamwork/NoSSLv3SocketFactory
    //   139: dup
    //   140: aload 10
    //   142: invokevirtual 88	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   145: invokespecial 91	com/tencent/mobileqq/teamwork/NoSSLv3SocketFactory:<init>	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   148: astore 9
    //   150: aload 5
    //   152: astore_1
    //   153: aload 9
    //   155: invokestatic 96	javax/net/ssl/HttpsURLConnection:setDefaultSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   158: aload 5
    //   160: astore_1
    //   161: new 98	java/net/URL
    //   164: dup
    //   165: aload 8
    //   167: invokespecial 101	java/net/URL:<init>	(Ljava/lang/String;)V
    //   170: invokevirtual 105	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   173: checkcast 93	javax/net/ssl/HttpsURLConnection
    //   176: astore 5
    //   178: aload 7
    //   180: astore_1
    //   181: aload 5
    //   183: aload 9
    //   185: invokevirtual 108	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   188: aload 7
    //   190: astore_1
    //   191: aload 5
    //   193: sipush 5000
    //   196: invokevirtual 112	javax/net/ssl/HttpsURLConnection:setConnectTimeout	(I)V
    //   199: aload 7
    //   201: astore_1
    //   202: aload 5
    //   204: sipush 30000
    //   207: invokevirtual 115	javax/net/ssl/HttpsURLConnection:setReadTimeout	(I)V
    //   210: aload 7
    //   212: astore_1
    //   213: aload 5
    //   215: iconst_1
    //   216: invokevirtual 415	javax/net/ssl/HttpsURLConnection:setDoOutput	(Z)V
    //   219: aload 7
    //   221: astore_1
    //   222: aload 5
    //   224: iconst_1
    //   225: invokevirtual 119	javax/net/ssl/HttpsURLConnection:setDoInput	(Z)V
    //   228: aload 7
    //   230: astore_1
    //   231: aload 5
    //   233: iconst_0
    //   234: invokevirtual 122	javax/net/ssl/HttpsURLConnection:setUseCaches	(Z)V
    //   237: aload 7
    //   239: astore_1
    //   240: aload 5
    //   242: ldc_w 417
    //   245: invokevirtual 127	javax/net/ssl/HttpsURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   248: aload 7
    //   250: astore_1
    //   251: aload 5
    //   253: ldc 129
    //   255: ldc 131
    //   257: invokevirtual 135	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   260: aload 7
    //   262: astore_1
    //   263: new 57	java/lang/StringBuilder
    //   266: dup
    //   267: ldc 137
    //   269: invokespecial 138	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   272: astore 6
    //   274: aload 7
    //   276: astore_1
    //   277: aload 6
    //   279: ldc 140
    //   281: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: pop
    //   285: aload 7
    //   287: astore_1
    //   288: aload 6
    //   290: getstatic 146	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   293: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: pop
    //   297: aload 7
    //   299: astore_1
    //   300: aload 6
    //   302: ldc 140
    //   304: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: pop
    //   308: aload 7
    //   310: astore_1
    //   311: aload 6
    //   313: getstatic 151	android/os/Build:DEVICE	Ljava/lang/String;
    //   316: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: pop
    //   320: aload 7
    //   322: astore_1
    //   323: aload 6
    //   325: ldc 140
    //   327: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: pop
    //   331: aload 7
    //   333: astore_1
    //   334: aload 6
    //   336: getstatic 154	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   339: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: pop
    //   343: aload 7
    //   345: astore_1
    //   346: aload 6
    //   348: ldc 140
    //   350: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: pop
    //   354: aload 7
    //   356: astore_1
    //   357: aload 6
    //   359: ldc 156
    //   361: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   364: pop
    //   365: aload 7
    //   367: astore_1
    //   368: aload 6
    //   370: ldc 140
    //   372: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: pop
    //   376: aload 7
    //   378: astore_1
    //   379: aload 6
    //   381: ldc 158
    //   383: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   386: pop
    //   387: aload 7
    //   389: astore_1
    //   390: aload 6
    //   392: ldc 160
    //   394: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: pop
    //   398: aload 7
    //   400: astore_1
    //   401: aload 5
    //   403: ldc 162
    //   405: aload 6
    //   407: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   410: invokevirtual 135	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   413: aload 7
    //   415: astore_1
    //   416: aload 5
    //   418: ldc 172
    //   420: ldc_w 629
    //   423: invokevirtual 135	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   426: aload 7
    //   428: astore_1
    //   429: aload 5
    //   431: ldc 164
    //   433: ldc 166
    //   435: invokevirtual 135	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   438: aload 7
    //   440: astore_1
    //   441: aload 5
    //   443: ldc_w 631
    //   446: ldc_w 384
    //   449: invokevirtual 135	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   452: aload 7
    //   454: astore_1
    //   455: new 174	java/util/HashMap
    //   458: dup
    //   459: invokespecial 175	java/util/HashMap:<init>	()V
    //   462: astore 9
    //   464: aload 7
    //   466: astore_1
    //   467: aload 9
    //   469: ldc 129
    //   471: ldc 177
    //   473: invokeinterface 183 3 0
    //   478: pop
    //   479: aload 7
    //   481: astore_1
    //   482: aload 9
    //   484: ldc 185
    //   486: aload 8
    //   488: invokeinterface 183 3 0
    //   493: pop
    //   494: aload 7
    //   496: astore_1
    //   497: getstatic 423	mqq/app/MobileQQ:sMobileQQ	Lmqq/app/MobileQQ;
    //   500: aconst_null
    //   501: invokevirtual 427	mqq/app/MobileQQ:waitAppRuntime	(Lmqq/app/BaseActivity;)Lmqq/app/AppRuntime;
    //   504: iconst_2
    //   505: invokevirtual 430	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   508: checkcast 191	mqq/manager/TicketManager
    //   511: astore 6
    //   513: aload 7
    //   515: astore_1
    //   516: aload 6
    //   518: aload_2
    //   519: invokeinterface 195 2 0
    //   524: astore 10
    //   526: aload 7
    //   528: astore_1
    //   529: aload 8
    //   531: invokestatic 35	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   534: ifne +601 -> 1135
    //   537: aload 7
    //   539: astore_1
    //   540: aload 6
    //   542: aload_2
    //   543: ldc 197
    //   545: invokeinterface 201 3 0
    //   550: astore 6
    //   552: goto +3 -> 555
    //   555: aload 7
    //   557: astore_1
    //   558: aload 6
    //   560: invokestatic 35	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   563: istore 4
    //   565: iload 4
    //   567: ifeq +48 -> 615
    //   570: aload 7
    //   572: astore_1
    //   573: ldc 203
    //   575: iconst_1
    //   576: ldc_w 633
    //   579: invokestatic 211	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   582: aload 7
    //   584: astore_1
    //   585: invokestatic 216	com/tencent/smtt/sdk/CookieManager:getInstance	()Lcom/tencent/smtt/sdk/CookieManager;
    //   588: astore_2
    //   589: aload_2
    //   590: ifnull +133 -> 723
    //   593: aload 7
    //   595: astore_1
    //   596: aload 9
    //   598: ldc 225
    //   600: aload_2
    //   601: aload 8
    //   603: invokevirtual 221	com/tencent/smtt/sdk/CookieManager:getCookie	(Ljava/lang/String;)Ljava/lang/String;
    //   606: invokeinterface 183 3 0
    //   611: pop
    //   612: goto +111 -> 723
    //   615: aload 7
    //   617: astore_1
    //   618: new 57	java/lang/StringBuilder
    //   621: dup
    //   622: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   625: astore 8
    //   627: aload 7
    //   629: astore_1
    //   630: aload 8
    //   632: ldc_w 434
    //   635: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   638: pop
    //   639: aload 7
    //   641: astore_1
    //   642: aload 8
    //   644: aload 6
    //   646: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   649: pop
    //   650: aload 7
    //   652: astore_1
    //   653: aload 8
    //   655: ldc_w 436
    //   658: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   661: pop
    //   662: aload 7
    //   664: astore_1
    //   665: aload 8
    //   667: aload_2
    //   668: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   671: pop
    //   672: aload 7
    //   674: astore_1
    //   675: aload 8
    //   677: ldc_w 438
    //   680: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   683: pop
    //   684: aload 7
    //   686: astore_1
    //   687: aload 8
    //   689: aload 10
    //   691: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   694: pop
    //   695: aload 7
    //   697: astore_1
    //   698: aload 9
    //   700: ldc 225
    //   702: new 57	java/lang/StringBuilder
    //   705: dup
    //   706: aload 8
    //   708: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   711: invokespecial 138	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   714: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   717: invokeinterface 183 3 0
    //   722: pop
    //   723: aload 7
    //   725: astore_1
    //   726: aload 9
    //   728: invokeinterface 229 1 0
    //   733: invokeinterface 235 1 0
    //   738: astore_2
    //   739: aload 7
    //   741: astore_1
    //   742: aload_2
    //   743: invokeinterface 240 1 0
    //   748: ifeq +48 -> 796
    //   751: aload 7
    //   753: astore_1
    //   754: aload_2
    //   755: invokeinterface 244 1 0
    //   760: checkcast 246	java/util/Map$Entry
    //   763: astore 6
    //   765: aload 7
    //   767: astore_1
    //   768: aload 5
    //   770: aload 6
    //   772: invokeinterface 249 1 0
    //   777: checkcast 251	java/lang/String
    //   780: aload 6
    //   782: invokeinterface 254 1 0
    //   787: checkcast 251	java/lang/String
    //   790: invokevirtual 135	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   793: goto -54 -> 739
    //   796: aload 7
    //   798: astore_1
    //   799: new 442	java/io/DataOutputStream
    //   802: dup
    //   803: aload 5
    //   805: invokevirtual 446	javax/net/ssl/HttpsURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   808: invokespecial 449	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   811: astore_2
    //   812: aload_2
    //   813: aload_0
    //   814: invokevirtual 660	org/json/JSONObject:toString	()Ljava/lang/String;
    //   817: ldc_w 384
    //   820: invokevirtual 646	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   823: invokevirtual 480	java/io/OutputStream:write	([B)V
    //   826: aload_2
    //   827: invokevirtual 498	java/io/OutputStream:flush	()V
    //   830: aload_2
    //   831: invokevirtual 499	java/io/OutputStream:close	()V
    //   834: aload 7
    //   836: astore_1
    //   837: new 451	java/lang/StringBuffer
    //   840: dup
    //   841: invokespecial 452	java/lang/StringBuffer:<init>	()V
    //   844: astore_0
    //   845: aload 7
    //   847: astore_1
    //   848: aload 5
    //   850: invokevirtual 515	javax/net/ssl/HttpsURLConnection:getResponseCode	()I
    //   853: istore_3
    //   854: iload_3
    //   855: sipush 200
    //   858: if_icmpeq +58 -> 916
    //   861: aload 7
    //   863: astore_1
    //   864: new 57	java/lang/StringBuilder
    //   867: dup
    //   868: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   871: astore_2
    //   872: aload 7
    //   874: astore_1
    //   875: aload_2
    //   876: ldc_w 662
    //   879: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   882: pop
    //   883: aload 7
    //   885: astore_1
    //   886: aload_2
    //   887: iload_3
    //   888: invokevirtual 407	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   891: pop
    //   892: aload 7
    //   894: astore_1
    //   895: aload_2
    //   896: ldc_w 519
    //   899: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   902: pop
    //   903: aload 7
    //   905: astore_1
    //   906: ldc 203
    //   908: iconst_1
    //   909: aload_2
    //   910: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   913: invokestatic 522	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   916: aload 7
    //   918: astore_1
    //   919: new 524	java/io/BufferedReader
    //   922: dup
    //   923: new 526	java/io/InputStreamReader
    //   926: dup
    //   927: aload 5
    //   929: invokevirtual 277	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   932: invokespecial 527	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   935: invokespecial 530	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   938: astore_2
    //   939: aload 7
    //   941: astore_1
    //   942: aload_2
    //   943: invokevirtual 533	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   946: astore 6
    //   948: aload 6
    //   950: ifnull +27 -> 977
    //   953: aload 7
    //   955: astore_1
    //   956: aload_0
    //   957: aload 6
    //   959: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   962: pop
    //   963: aload 7
    //   965: astore_1
    //   966: aload_0
    //   967: ldc_w 535
    //   970: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   973: pop
    //   974: goto -35 -> 939
    //   977: aload 7
    //   979: astore_1
    //   980: aload_0
    //   981: invokevirtual 474	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   984: astore_0
    //   985: aload_0
    //   986: astore_1
    //   987: aload_2
    //   988: invokevirtual 536	java/io/BufferedReader:close	()V
    //   991: aload 5
    //   993: ifnull +8 -> 1001
    //   996: aload 5
    //   998: invokevirtual 350	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   1001: aload_0
    //   1002: areturn
    //   1003: aload 7
    //   1005: astore_1
    //   1006: aload_2
    //   1007: invokevirtual 499	java/io/OutputStream:close	()V
    //   1010: aload 5
    //   1012: ifnull +8 -> 1020
    //   1015: aload 5
    //   1017: invokevirtual 350	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   1020: aconst_null
    //   1021: areturn
    //   1022: astore_0
    //   1023: goto +85 -> 1108
    //   1026: astore_2
    //   1027: aload 5
    //   1029: astore_0
    //   1030: aload_1
    //   1031: astore 5
    //   1033: goto +17 -> 1050
    //   1036: astore_0
    //   1037: aload_1
    //   1038: astore 5
    //   1040: goto +68 -> 1108
    //   1043: astore_2
    //   1044: aconst_null
    //   1045: astore 5
    //   1047: aload 6
    //   1049: astore_0
    //   1050: aload_0
    //   1051: astore_1
    //   1052: new 57	java/lang/StringBuilder
    //   1055: dup
    //   1056: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   1059: astore 6
    //   1061: aload_0
    //   1062: astore_1
    //   1063: aload 6
    //   1065: ldc_w 664
    //   1068: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1071: pop
    //   1072: aload_0
    //   1073: astore_1
    //   1074: aload 6
    //   1076: aload_2
    //   1077: invokevirtual 346	java/lang/Exception:toString	()Ljava/lang/String;
    //   1080: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1083: pop
    //   1084: aload_0
    //   1085: astore_1
    //   1086: ldc 203
    //   1088: iconst_1
    //   1089: aload 6
    //   1091: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1094: invokestatic 342	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1097: aload_0
    //   1098: ifnull +7 -> 1105
    //   1101: aload_0
    //   1102: invokevirtual 350	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   1105: aload 5
    //   1107: areturn
    //   1108: aload 5
    //   1110: ifnull +8 -> 1118
    //   1113: aload 5
    //   1115: invokevirtual 350	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   1118: aload_0
    //   1119: athrow
    //   1120: ldc 203
    //   1122: iconst_1
    //   1123: ldc_w 666
    //   1126: invokestatic 211	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1129: aconst_null
    //   1130: areturn
    //   1131: astore_0
    //   1132: goto -129 -> 1003
    //   1135: aconst_null
    //   1136: astore 6
    //   1138: goto -583 -> 555
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1141	0	paramJSONObject	JSONObject
    //   0	1141	1	paramTeamWorkFileImportInfo	TeamWorkFileImportInfo
    //   0	1141	2	paramString	String
    //   853	35	3	i	int
    //   563	3	4	bool	boolean
    //   1	1113	5	localObject1	Object
    //   4	1133	6	localObject2	Object
    //   7	997	7	localObject3	Object
    //   30	677	8	localObject4	Object
    //   102	625	9	localObject5	Object
    //   112	578	10	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   181	188	1022	finally
    //   191	199	1022	finally
    //   202	210	1022	finally
    //   213	219	1022	finally
    //   222	228	1022	finally
    //   231	237	1022	finally
    //   240	248	1022	finally
    //   251	260	1022	finally
    //   263	274	1022	finally
    //   277	285	1022	finally
    //   288	297	1022	finally
    //   300	308	1022	finally
    //   311	320	1022	finally
    //   323	331	1022	finally
    //   334	343	1022	finally
    //   346	354	1022	finally
    //   357	365	1022	finally
    //   368	376	1022	finally
    //   379	387	1022	finally
    //   390	398	1022	finally
    //   401	413	1022	finally
    //   416	426	1022	finally
    //   429	438	1022	finally
    //   441	452	1022	finally
    //   455	464	1022	finally
    //   467	479	1022	finally
    //   482	494	1022	finally
    //   497	513	1022	finally
    //   516	526	1022	finally
    //   529	537	1022	finally
    //   540	552	1022	finally
    //   558	565	1022	finally
    //   573	582	1022	finally
    //   585	589	1022	finally
    //   596	612	1022	finally
    //   618	627	1022	finally
    //   630	639	1022	finally
    //   642	650	1022	finally
    //   653	662	1022	finally
    //   665	672	1022	finally
    //   675	684	1022	finally
    //   687	695	1022	finally
    //   698	723	1022	finally
    //   726	739	1022	finally
    //   742	751	1022	finally
    //   754	765	1022	finally
    //   768	793	1022	finally
    //   799	812	1022	finally
    //   812	834	1022	finally
    //   837	845	1022	finally
    //   848	854	1022	finally
    //   864	872	1022	finally
    //   875	883	1022	finally
    //   886	892	1022	finally
    //   895	903	1022	finally
    //   906	916	1022	finally
    //   919	939	1022	finally
    //   942	948	1022	finally
    //   956	963	1022	finally
    //   966	974	1022	finally
    //   980	985	1022	finally
    //   987	991	1022	finally
    //   1006	1010	1022	finally
    //   181	188	1026	java/lang/Exception
    //   191	199	1026	java/lang/Exception
    //   202	210	1026	java/lang/Exception
    //   213	219	1026	java/lang/Exception
    //   222	228	1026	java/lang/Exception
    //   231	237	1026	java/lang/Exception
    //   240	248	1026	java/lang/Exception
    //   251	260	1026	java/lang/Exception
    //   263	274	1026	java/lang/Exception
    //   277	285	1026	java/lang/Exception
    //   288	297	1026	java/lang/Exception
    //   300	308	1026	java/lang/Exception
    //   311	320	1026	java/lang/Exception
    //   323	331	1026	java/lang/Exception
    //   334	343	1026	java/lang/Exception
    //   346	354	1026	java/lang/Exception
    //   357	365	1026	java/lang/Exception
    //   368	376	1026	java/lang/Exception
    //   379	387	1026	java/lang/Exception
    //   390	398	1026	java/lang/Exception
    //   401	413	1026	java/lang/Exception
    //   416	426	1026	java/lang/Exception
    //   429	438	1026	java/lang/Exception
    //   441	452	1026	java/lang/Exception
    //   455	464	1026	java/lang/Exception
    //   467	479	1026	java/lang/Exception
    //   482	494	1026	java/lang/Exception
    //   497	513	1026	java/lang/Exception
    //   516	526	1026	java/lang/Exception
    //   529	537	1026	java/lang/Exception
    //   540	552	1026	java/lang/Exception
    //   558	565	1026	java/lang/Exception
    //   573	582	1026	java/lang/Exception
    //   585	589	1026	java/lang/Exception
    //   596	612	1026	java/lang/Exception
    //   618	627	1026	java/lang/Exception
    //   630	639	1026	java/lang/Exception
    //   642	650	1026	java/lang/Exception
    //   653	662	1026	java/lang/Exception
    //   665	672	1026	java/lang/Exception
    //   675	684	1026	java/lang/Exception
    //   687	695	1026	java/lang/Exception
    //   698	723	1026	java/lang/Exception
    //   726	739	1026	java/lang/Exception
    //   742	751	1026	java/lang/Exception
    //   754	765	1026	java/lang/Exception
    //   768	793	1026	java/lang/Exception
    //   799	812	1026	java/lang/Exception
    //   837	845	1026	java/lang/Exception
    //   848	854	1026	java/lang/Exception
    //   864	872	1026	java/lang/Exception
    //   875	883	1026	java/lang/Exception
    //   886	892	1026	java/lang/Exception
    //   895	903	1026	java/lang/Exception
    //   906	916	1026	java/lang/Exception
    //   919	939	1026	java/lang/Exception
    //   942	948	1026	java/lang/Exception
    //   956	963	1026	java/lang/Exception
    //   966	974	1026	java/lang/Exception
    //   980	985	1026	java/lang/Exception
    //   987	991	1026	java/lang/Exception
    //   1006	1010	1026	java/lang/Exception
    //   95	104	1036	finally
    //   107	114	1036	finally
    //   117	133	1036	finally
    //   136	150	1036	finally
    //   153	158	1036	finally
    //   161	178	1036	finally
    //   1052	1061	1036	finally
    //   1063	1072	1036	finally
    //   1074	1084	1036	finally
    //   1086	1097	1036	finally
    //   95	104	1043	java/lang/Exception
    //   107	114	1043	java/lang/Exception
    //   117	133	1043	java/lang/Exception
    //   136	150	1043	java/lang/Exception
    //   153	158	1043	java/lang/Exception
    //   161	178	1043	java/lang/Exception
    //   812	834	1131	java/lang/Exception
  }
  
  /* Error */
  public static final String a(JSONObject paramJSONObject, String paramString, com.tencent.common.app.AppInterface paramAppInterface)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 8
    //   6: aconst_null
    //   7: astore 7
    //   9: aload_0
    //   10: ifnull +1148 -> 1158
    //   13: aload_1
    //   14: invokestatic 35	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   17: ifne +1141 -> 1158
    //   20: aload_2
    //   21: ifnonnull +6 -> 27
    //   24: goto +1134 -> 1158
    //   27: new 57	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   34: astore 5
    //   36: aload 5
    //   38: ldc_w 373
    //   41: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: pop
    //   45: aload 5
    //   47: aload_1
    //   48: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: pop
    //   52: aload 5
    //   54: ldc_w 375
    //   57: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: pop
    //   61: aload 5
    //   63: ldc_w 669
    //   66: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: pop
    //   70: aload 5
    //   72: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: astore 9
    //   77: aload 6
    //   79: astore 5
    //   81: new 67	com/tencent/mobileqq/teamwork/CustomX509TrustManager
    //   84: dup
    //   85: invokespecial 68	com/tencent/mobileqq/teamwork/CustomX509TrustManager:<init>	()V
    //   88: astore 10
    //   90: aload 6
    //   92: astore 5
    //   94: ldc 70
    //   96: invokestatic 76	javax/net/ssl/SSLContext:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    //   99: astore 11
    //   101: aload 6
    //   103: astore 5
    //   105: aload 11
    //   107: aconst_null
    //   108: iconst_1
    //   109: anewarray 78	javax/net/ssl/TrustManager
    //   112: dup
    //   113: iconst_0
    //   114: aload 10
    //   116: aastore
    //   117: aconst_null
    //   118: invokevirtual 82	javax/net/ssl/SSLContext:init	([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Ljava/security/SecureRandom;)V
    //   121: aload 6
    //   123: astore 5
    //   125: new 84	com/tencent/mobileqq/teamwork/NoSSLv3SocketFactory
    //   128: dup
    //   129: aload 11
    //   131: invokevirtual 88	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   134: invokespecial 91	com/tencent/mobileqq/teamwork/NoSSLv3SocketFactory:<init>	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   137: astore 10
    //   139: aload 6
    //   141: astore 5
    //   143: aload 10
    //   145: invokestatic 96	javax/net/ssl/HttpsURLConnection:setDefaultSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   148: aload 6
    //   150: astore 5
    //   152: new 98	java/net/URL
    //   155: dup
    //   156: aload 9
    //   158: invokespecial 101	java/net/URL:<init>	(Ljava/lang/String;)V
    //   161: invokevirtual 105	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   164: checkcast 93	javax/net/ssl/HttpsURLConnection
    //   167: astore 6
    //   169: aload 7
    //   171: astore 5
    //   173: aload 6
    //   175: aload 10
    //   177: invokevirtual 108	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   180: aload 7
    //   182: astore 5
    //   184: aload 6
    //   186: sipush 5000
    //   189: invokevirtual 112	javax/net/ssl/HttpsURLConnection:setConnectTimeout	(I)V
    //   192: aload 7
    //   194: astore 5
    //   196: aload 6
    //   198: sipush 30000
    //   201: invokevirtual 115	javax/net/ssl/HttpsURLConnection:setReadTimeout	(I)V
    //   204: aload 7
    //   206: astore 5
    //   208: aload 6
    //   210: iconst_1
    //   211: invokevirtual 415	javax/net/ssl/HttpsURLConnection:setDoOutput	(Z)V
    //   214: aload 7
    //   216: astore 5
    //   218: aload 6
    //   220: iconst_1
    //   221: invokevirtual 119	javax/net/ssl/HttpsURLConnection:setDoInput	(Z)V
    //   224: aload 7
    //   226: astore 5
    //   228: aload 6
    //   230: iconst_0
    //   231: invokevirtual 122	javax/net/ssl/HttpsURLConnection:setUseCaches	(Z)V
    //   234: aload 7
    //   236: astore 5
    //   238: aload 6
    //   240: ldc_w 417
    //   243: invokevirtual 127	javax/net/ssl/HttpsURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   246: aload 7
    //   248: astore 5
    //   250: aload 6
    //   252: ldc 129
    //   254: ldc 131
    //   256: invokevirtual 135	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   259: aload 7
    //   261: astore 5
    //   263: new 57	java/lang/StringBuilder
    //   266: dup
    //   267: ldc 137
    //   269: invokespecial 138	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   272: astore 8
    //   274: aload 7
    //   276: astore 5
    //   278: aload 8
    //   280: ldc 140
    //   282: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: pop
    //   286: aload 7
    //   288: astore 5
    //   290: aload 8
    //   292: getstatic 146	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   295: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: pop
    //   299: aload 7
    //   301: astore 5
    //   303: aload 8
    //   305: ldc 140
    //   307: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: pop
    //   311: aload 7
    //   313: astore 5
    //   315: aload 8
    //   317: getstatic 151	android/os/Build:DEVICE	Ljava/lang/String;
    //   320: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: pop
    //   324: aload 7
    //   326: astore 5
    //   328: aload 8
    //   330: ldc 140
    //   332: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: pop
    //   336: aload 7
    //   338: astore 5
    //   340: aload 8
    //   342: getstatic 154	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   345: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   348: pop
    //   349: aload 7
    //   351: astore 5
    //   353: aload 8
    //   355: ldc 140
    //   357: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   360: pop
    //   361: aload 7
    //   363: astore 5
    //   365: aload 8
    //   367: ldc 156
    //   369: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   372: pop
    //   373: aload 7
    //   375: astore 5
    //   377: aload 8
    //   379: ldc 140
    //   381: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: pop
    //   385: aload 7
    //   387: astore 5
    //   389: aload 8
    //   391: ldc 158
    //   393: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   396: pop
    //   397: aload 7
    //   399: astore 5
    //   401: aload 8
    //   403: ldc 160
    //   405: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   408: pop
    //   409: aload 7
    //   411: astore 5
    //   413: aload 6
    //   415: ldc 162
    //   417: aload 8
    //   419: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   422: invokevirtual 135	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   425: aload 7
    //   427: astore 5
    //   429: aload 6
    //   431: ldc 172
    //   433: ldc_w 629
    //   436: invokevirtual 135	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   439: aload 7
    //   441: astore 5
    //   443: aload 6
    //   445: ldc 164
    //   447: ldc 166
    //   449: invokevirtual 135	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   452: aload 7
    //   454: astore 5
    //   456: aload 6
    //   458: ldc_w 631
    //   461: ldc_w 384
    //   464: invokevirtual 135	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   467: aload 7
    //   469: astore 5
    //   471: new 174	java/util/HashMap
    //   474: dup
    //   475: invokespecial 175	java/util/HashMap:<init>	()V
    //   478: astore 8
    //   480: aload 7
    //   482: astore 5
    //   484: aload 8
    //   486: ldc 129
    //   488: ldc 177
    //   490: invokeinterface 183 3 0
    //   495: pop
    //   496: aload 7
    //   498: astore 5
    //   500: aload 8
    //   502: ldc 185
    //   504: aload 9
    //   506: invokeinterface 183 3 0
    //   511: pop
    //   512: aload 7
    //   514: astore 5
    //   516: aload_2
    //   517: iconst_2
    //   518: invokevirtual 189	com/tencent/common/app/AppInterface:getManager	(I)Lmqq/manager/Manager;
    //   521: checkcast 191	mqq/manager/TicketManager
    //   524: astore_2
    //   525: aload 7
    //   527: astore 5
    //   529: aload_2
    //   530: aload_1
    //   531: invokeinterface 195 2 0
    //   536: astore 10
    //   538: aload 7
    //   540: astore 5
    //   542: aload 9
    //   544: invokestatic 35	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   547: ifne +649 -> 1196
    //   550: aload 7
    //   552: astore 5
    //   554: aload_2
    //   555: aload_1
    //   556: ldc 197
    //   558: invokeinterface 201 3 0
    //   563: astore_2
    //   564: goto +3 -> 567
    //   567: aload 7
    //   569: astore 5
    //   571: aload_2
    //   572: invokestatic 35	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   575: istore 4
    //   577: iload 4
    //   579: ifeq +51 -> 630
    //   582: aload 7
    //   584: astore 5
    //   586: ldc 203
    //   588: iconst_1
    //   589: ldc_w 633
    //   592: invokestatic 211	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   595: aload 7
    //   597: astore 5
    //   599: invokestatic 216	com/tencent/smtt/sdk/CookieManager:getInstance	()Lcom/tencent/smtt/sdk/CookieManager;
    //   602: astore_1
    //   603: aload_1
    //   604: ifnull +141 -> 745
    //   607: aload 7
    //   609: astore 5
    //   611: aload 8
    //   613: ldc 225
    //   615: aload_1
    //   616: aload 9
    //   618: invokevirtual 221	com/tencent/smtt/sdk/CookieManager:getCookie	(Ljava/lang/String;)Ljava/lang/String;
    //   621: invokeinterface 183 3 0
    //   626: pop
    //   627: goto +118 -> 745
    //   630: aload 7
    //   632: astore 5
    //   634: new 57	java/lang/StringBuilder
    //   637: dup
    //   638: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   641: astore 9
    //   643: aload 7
    //   645: astore 5
    //   647: aload 9
    //   649: ldc_w 434
    //   652: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   655: pop
    //   656: aload 7
    //   658: astore 5
    //   660: aload 9
    //   662: aload_2
    //   663: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   666: pop
    //   667: aload 7
    //   669: astore 5
    //   671: aload 9
    //   673: ldc_w 436
    //   676: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   679: pop
    //   680: aload 7
    //   682: astore 5
    //   684: aload 9
    //   686: aload_1
    //   687: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   690: pop
    //   691: aload 7
    //   693: astore 5
    //   695: aload 9
    //   697: ldc_w 438
    //   700: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   703: pop
    //   704: aload 7
    //   706: astore 5
    //   708: aload 9
    //   710: aload 10
    //   712: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   715: pop
    //   716: aload 7
    //   718: astore 5
    //   720: aload 8
    //   722: ldc 225
    //   724: new 57	java/lang/StringBuilder
    //   727: dup
    //   728: aload 9
    //   730: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   733: invokespecial 138	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   736: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   739: invokeinterface 183 3 0
    //   744: pop
    //   745: aload 7
    //   747: astore 5
    //   749: aload 8
    //   751: invokeinterface 229 1 0
    //   756: invokeinterface 235 1 0
    //   761: astore_1
    //   762: aload 7
    //   764: astore 5
    //   766: aload_1
    //   767: invokeinterface 240 1 0
    //   772: ifeq +47 -> 819
    //   775: aload 7
    //   777: astore 5
    //   779: aload_1
    //   780: invokeinterface 244 1 0
    //   785: checkcast 246	java/util/Map$Entry
    //   788: astore_2
    //   789: aload 7
    //   791: astore 5
    //   793: aload 6
    //   795: aload_2
    //   796: invokeinterface 249 1 0
    //   801: checkcast 251	java/lang/String
    //   804: aload_2
    //   805: invokeinterface 254 1 0
    //   810: checkcast 251	java/lang/String
    //   813: invokevirtual 135	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   816: goto -54 -> 762
    //   819: aload 7
    //   821: astore 5
    //   823: new 442	java/io/DataOutputStream
    //   826: dup
    //   827: aload 6
    //   829: invokevirtual 446	javax/net/ssl/HttpsURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   832: invokespecial 449	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   835: astore_1
    //   836: aload_1
    //   837: aload_0
    //   838: invokevirtual 660	org/json/JSONObject:toString	()Ljava/lang/String;
    //   841: ldc_w 384
    //   844: invokevirtual 646	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   847: invokevirtual 480	java/io/OutputStream:write	([B)V
    //   850: aload_1
    //   851: invokevirtual 498	java/io/OutputStream:flush	()V
    //   854: aload_1
    //   855: invokevirtual 499	java/io/OutputStream:close	()V
    //   858: aload 7
    //   860: astore 5
    //   862: new 451	java/lang/StringBuffer
    //   865: dup
    //   866: invokespecial 452	java/lang/StringBuffer:<init>	()V
    //   869: astore_0
    //   870: aload 7
    //   872: astore 5
    //   874: aload 6
    //   876: invokevirtual 515	javax/net/ssl/HttpsURLConnection:getResponseCode	()I
    //   879: istore_3
    //   880: iload_3
    //   881: sipush 200
    //   884: if_icmpeq +63 -> 947
    //   887: aload 7
    //   889: astore 5
    //   891: new 57	java/lang/StringBuilder
    //   894: dup
    //   895: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   898: astore_1
    //   899: aload 7
    //   901: astore 5
    //   903: aload_1
    //   904: ldc_w 662
    //   907: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   910: pop
    //   911: aload 7
    //   913: astore 5
    //   915: aload_1
    //   916: iload_3
    //   917: invokevirtual 407	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   920: pop
    //   921: aload 7
    //   923: astore 5
    //   925: aload_1
    //   926: ldc_w 519
    //   929: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   932: pop
    //   933: aload 7
    //   935: astore 5
    //   937: ldc 203
    //   939: iconst_1
    //   940: aload_1
    //   941: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   944: invokestatic 522	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   947: aload 7
    //   949: astore 5
    //   951: new 524	java/io/BufferedReader
    //   954: dup
    //   955: new 526	java/io/InputStreamReader
    //   958: dup
    //   959: aload 6
    //   961: invokevirtual 277	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   964: invokespecial 527	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   967: invokespecial 530	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   970: astore_1
    //   971: aload 7
    //   973: astore 5
    //   975: aload_1
    //   976: invokevirtual 533	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   979: astore_2
    //   980: aload_2
    //   981: ifnull +28 -> 1009
    //   984: aload 7
    //   986: astore 5
    //   988: aload_0
    //   989: aload_2
    //   990: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   993: pop
    //   994: aload 7
    //   996: astore 5
    //   998: aload_0
    //   999: ldc_w 535
    //   1002: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1005: pop
    //   1006: goto -35 -> 971
    //   1009: aload 7
    //   1011: astore 5
    //   1013: aload_0
    //   1014: invokevirtual 474	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   1017: astore_0
    //   1018: aload_0
    //   1019: astore 5
    //   1021: aload_1
    //   1022: invokevirtual 536	java/io/BufferedReader:close	()V
    //   1025: aload 6
    //   1027: ifnull +8 -> 1035
    //   1030: aload 6
    //   1032: invokevirtual 350	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   1035: aload_0
    //   1036: areturn
    //   1037: aload 7
    //   1039: astore 5
    //   1041: aload_1
    //   1042: invokevirtual 499	java/io/OutputStream:close	()V
    //   1045: aload 6
    //   1047: ifnull +8 -> 1055
    //   1050: aload 6
    //   1052: invokevirtual 350	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   1055: aconst_null
    //   1056: areturn
    //   1057: astore_0
    //   1058: goto +88 -> 1146
    //   1061: astore_1
    //   1062: aload 5
    //   1064: astore_2
    //   1065: aload 6
    //   1067: astore_0
    //   1068: goto +17 -> 1085
    //   1071: astore_0
    //   1072: aload 5
    //   1074: astore 6
    //   1076: goto +70 -> 1146
    //   1079: astore_1
    //   1080: aconst_null
    //   1081: astore_2
    //   1082: aload 8
    //   1084: astore_0
    //   1085: aload_0
    //   1086: astore 5
    //   1088: new 57	java/lang/StringBuilder
    //   1091: dup
    //   1092: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   1095: astore 6
    //   1097: aload_0
    //   1098: astore 5
    //   1100: aload 6
    //   1102: ldc_w 664
    //   1105: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1108: pop
    //   1109: aload_0
    //   1110: astore 5
    //   1112: aload 6
    //   1114: aload_1
    //   1115: invokevirtual 346	java/lang/Exception:toString	()Ljava/lang/String;
    //   1118: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1121: pop
    //   1122: aload_0
    //   1123: astore 5
    //   1125: ldc 203
    //   1127: iconst_1
    //   1128: aload 6
    //   1130: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1133: invokestatic 342	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1136: aload_0
    //   1137: ifnull +7 -> 1144
    //   1140: aload_0
    //   1141: invokevirtual 350	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   1144: aload_2
    //   1145: areturn
    //   1146: aload 6
    //   1148: ifnull +8 -> 1156
    //   1151: aload 6
    //   1153: invokevirtual 350	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   1156: aload_0
    //   1157: athrow
    //   1158: new 57	java/lang/StringBuilder
    //   1161: dup
    //   1162: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   1165: astore_0
    //   1166: aload_0
    //   1167: ldc_w 671
    //   1170: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1173: pop
    //   1174: aload_0
    //   1175: aload_2
    //   1176: invokevirtual 359	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1179: pop
    //   1180: ldc 203
    //   1182: iconst_1
    //   1183: aload_0
    //   1184: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1187: invokestatic 211	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1190: aconst_null
    //   1191: areturn
    //   1192: astore_0
    //   1193: goto -156 -> 1037
    //   1196: aconst_null
    //   1197: astore_2
    //   1198: goto -631 -> 567
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1201	0	paramJSONObject	JSONObject
    //   0	1201	1	paramString	String
    //   0	1201	2	paramAppInterface	com.tencent.common.app.AppInterface
    //   879	38	3	i	int
    //   575	3	4	bool	boolean
    //   34	1090	5	localObject1	Object
    //   1	1151	6	localObject2	Object
    //   7	1031	7	localObject3	Object
    //   4	1079	8	localObject4	Object
    //   75	654	9	localObject5	Object
    //   88	623	10	localObject6	Object
    //   99	31	11	localSSLContext	javax.net.ssl.SSLContext
    // Exception table:
    //   from	to	target	type
    //   173	180	1057	finally
    //   184	192	1057	finally
    //   196	204	1057	finally
    //   208	214	1057	finally
    //   218	224	1057	finally
    //   228	234	1057	finally
    //   238	246	1057	finally
    //   250	259	1057	finally
    //   263	274	1057	finally
    //   278	286	1057	finally
    //   290	299	1057	finally
    //   303	311	1057	finally
    //   315	324	1057	finally
    //   328	336	1057	finally
    //   340	349	1057	finally
    //   353	361	1057	finally
    //   365	373	1057	finally
    //   377	385	1057	finally
    //   389	397	1057	finally
    //   401	409	1057	finally
    //   413	425	1057	finally
    //   429	439	1057	finally
    //   443	452	1057	finally
    //   456	467	1057	finally
    //   471	480	1057	finally
    //   484	496	1057	finally
    //   500	512	1057	finally
    //   516	525	1057	finally
    //   529	538	1057	finally
    //   542	550	1057	finally
    //   554	564	1057	finally
    //   571	577	1057	finally
    //   586	595	1057	finally
    //   599	603	1057	finally
    //   611	627	1057	finally
    //   634	643	1057	finally
    //   647	656	1057	finally
    //   660	667	1057	finally
    //   671	680	1057	finally
    //   684	691	1057	finally
    //   695	704	1057	finally
    //   708	716	1057	finally
    //   720	745	1057	finally
    //   749	762	1057	finally
    //   766	775	1057	finally
    //   779	789	1057	finally
    //   793	816	1057	finally
    //   823	836	1057	finally
    //   836	858	1057	finally
    //   862	870	1057	finally
    //   874	880	1057	finally
    //   891	899	1057	finally
    //   903	911	1057	finally
    //   915	921	1057	finally
    //   925	933	1057	finally
    //   937	947	1057	finally
    //   951	971	1057	finally
    //   975	980	1057	finally
    //   988	994	1057	finally
    //   998	1006	1057	finally
    //   1013	1018	1057	finally
    //   1021	1025	1057	finally
    //   1041	1045	1057	finally
    //   173	180	1061	java/lang/Exception
    //   184	192	1061	java/lang/Exception
    //   196	204	1061	java/lang/Exception
    //   208	214	1061	java/lang/Exception
    //   218	224	1061	java/lang/Exception
    //   228	234	1061	java/lang/Exception
    //   238	246	1061	java/lang/Exception
    //   250	259	1061	java/lang/Exception
    //   263	274	1061	java/lang/Exception
    //   278	286	1061	java/lang/Exception
    //   290	299	1061	java/lang/Exception
    //   303	311	1061	java/lang/Exception
    //   315	324	1061	java/lang/Exception
    //   328	336	1061	java/lang/Exception
    //   340	349	1061	java/lang/Exception
    //   353	361	1061	java/lang/Exception
    //   365	373	1061	java/lang/Exception
    //   377	385	1061	java/lang/Exception
    //   389	397	1061	java/lang/Exception
    //   401	409	1061	java/lang/Exception
    //   413	425	1061	java/lang/Exception
    //   429	439	1061	java/lang/Exception
    //   443	452	1061	java/lang/Exception
    //   456	467	1061	java/lang/Exception
    //   471	480	1061	java/lang/Exception
    //   484	496	1061	java/lang/Exception
    //   500	512	1061	java/lang/Exception
    //   516	525	1061	java/lang/Exception
    //   529	538	1061	java/lang/Exception
    //   542	550	1061	java/lang/Exception
    //   554	564	1061	java/lang/Exception
    //   571	577	1061	java/lang/Exception
    //   586	595	1061	java/lang/Exception
    //   599	603	1061	java/lang/Exception
    //   611	627	1061	java/lang/Exception
    //   634	643	1061	java/lang/Exception
    //   647	656	1061	java/lang/Exception
    //   660	667	1061	java/lang/Exception
    //   671	680	1061	java/lang/Exception
    //   684	691	1061	java/lang/Exception
    //   695	704	1061	java/lang/Exception
    //   708	716	1061	java/lang/Exception
    //   720	745	1061	java/lang/Exception
    //   749	762	1061	java/lang/Exception
    //   766	775	1061	java/lang/Exception
    //   779	789	1061	java/lang/Exception
    //   793	816	1061	java/lang/Exception
    //   823	836	1061	java/lang/Exception
    //   862	870	1061	java/lang/Exception
    //   874	880	1061	java/lang/Exception
    //   891	899	1061	java/lang/Exception
    //   903	911	1061	java/lang/Exception
    //   915	921	1061	java/lang/Exception
    //   925	933	1061	java/lang/Exception
    //   937	947	1061	java/lang/Exception
    //   951	971	1061	java/lang/Exception
    //   975	980	1061	java/lang/Exception
    //   988	994	1061	java/lang/Exception
    //   998	1006	1061	java/lang/Exception
    //   1013	1018	1061	java/lang/Exception
    //   1021	1025	1061	java/lang/Exception
    //   1041	1045	1061	java/lang/Exception
    //   81	90	1071	finally
    //   94	101	1071	finally
    //   105	121	1071	finally
    //   125	139	1071	finally
    //   143	148	1071	finally
    //   152	169	1071	finally
    //   1088	1097	1071	finally
    //   1100	1109	1071	finally
    //   1112	1122	1071	finally
    //   1125	1136	1071	finally
    //   81	90	1079	java/lang/Exception
    //   94	101	1079	java/lang/Exception
    //   105	121	1079	java/lang/Exception
    //   125	139	1079	java/lang/Exception
    //   143	148	1079	java/lang/Exception
    //   152	169	1079	java/lang/Exception
    //   836	858	1192	java/lang/Exception
  }
  
  /* Error */
  public static final String a(JSONObject paramJSONObject, String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 35	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: istore 5
    //   6: aconst_null
    //   7: astore 8
    //   9: iload 5
    //   11: ifne +1452 -> 1463
    //   14: aload_3
    //   15: invokestatic 35	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   18: ifeq +6 -> 24
    //   21: goto +1442 -> 1463
    //   24: new 57	java/lang/StringBuilder
    //   27: dup
    //   28: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   31: astore 6
    //   33: new 324	java/io/File
    //   36: dup
    //   37: aload_1
    //   38: invokespecial 325	java/io/File:<init>	(Ljava/lang/String;)V
    //   41: astore 9
    //   43: aload 9
    //   45: invokevirtual 369	java/io/File:exists	()Z
    //   48: ifeq +1404 -> 1452
    //   51: aload 6
    //   53: aload_2
    //   54: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: pop
    //   58: aload 6
    //   60: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: astore 10
    //   65: new 67	com/tencent/mobileqq/teamwork/CustomX509TrustManager
    //   68: dup
    //   69: invokespecial 68	com/tencent/mobileqq/teamwork/CustomX509TrustManager:<init>	()V
    //   72: astore_2
    //   73: ldc 70
    //   75: invokestatic 76	javax/net/ssl/SSLContext:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    //   78: astore 6
    //   80: aload 6
    //   82: aconst_null
    //   83: iconst_1
    //   84: anewarray 78	javax/net/ssl/TrustManager
    //   87: dup
    //   88: iconst_0
    //   89: aload_2
    //   90: aastore
    //   91: aconst_null
    //   92: invokevirtual 82	javax/net/ssl/SSLContext:init	([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Ljava/security/SecureRandom;)V
    //   95: new 84	com/tencent/mobileqq/teamwork/NoSSLv3SocketFactory
    //   98: dup
    //   99: aload 6
    //   101: invokevirtual 88	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   104: invokespecial 91	com/tencent/mobileqq/teamwork/NoSSLv3SocketFactory:<init>	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   107: astore 6
    //   109: aload 6
    //   111: invokestatic 96	javax/net/ssl/HttpsURLConnection:setDefaultSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   114: new 98	java/net/URL
    //   117: dup
    //   118: aload 10
    //   120: invokespecial 101	java/net/URL:<init>	(Ljava/lang/String;)V
    //   123: invokevirtual 105	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   126: checkcast 93	javax/net/ssl/HttpsURLConnection
    //   129: astore_2
    //   130: aload_2
    //   131: aload 6
    //   133: invokevirtual 108	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   136: aload_2
    //   137: sipush 5000
    //   140: invokevirtual 112	javax/net/ssl/HttpsURLConnection:setConnectTimeout	(I)V
    //   143: aload_2
    //   144: sipush 30000
    //   147: invokevirtual 115	javax/net/ssl/HttpsURLConnection:setReadTimeout	(I)V
    //   150: aload_2
    //   151: iconst_1
    //   152: invokevirtual 415	javax/net/ssl/HttpsURLConnection:setDoOutput	(Z)V
    //   155: aload_2
    //   156: iconst_1
    //   157: invokevirtual 119	javax/net/ssl/HttpsURLConnection:setDoInput	(Z)V
    //   160: aload_2
    //   161: iconst_0
    //   162: invokevirtual 122	javax/net/ssl/HttpsURLConnection:setUseCaches	(Z)V
    //   165: aload_2
    //   166: ldc_w 417
    //   169: invokevirtual 127	javax/net/ssl/HttpsURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   172: aload_2
    //   173: ldc 129
    //   175: ldc 131
    //   177: invokevirtual 135	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   180: new 57	java/lang/StringBuilder
    //   183: dup
    //   184: ldc 137
    //   186: invokespecial 138	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   189: astore 6
    //   191: aload 6
    //   193: ldc 140
    //   195: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: pop
    //   199: aload 6
    //   201: getstatic 146	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   204: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: pop
    //   208: aload 6
    //   210: ldc 140
    //   212: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: pop
    //   216: aload 6
    //   218: getstatic 151	android/os/Build:DEVICE	Ljava/lang/String;
    //   221: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: pop
    //   225: aload 6
    //   227: ldc 140
    //   229: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: pop
    //   233: aload 6
    //   235: getstatic 154	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   238: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: pop
    //   242: aload 6
    //   244: ldc 140
    //   246: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: pop
    //   250: aload 6
    //   252: ldc 156
    //   254: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: pop
    //   258: aload 6
    //   260: ldc 140
    //   262: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: pop
    //   266: aload 6
    //   268: ldc 158
    //   270: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: pop
    //   274: aload 6
    //   276: ldc 160
    //   278: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: pop
    //   282: aload_2
    //   283: ldc 162
    //   285: aload 6
    //   287: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   290: invokevirtual 135	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   293: aload_2
    //   294: ldc 164
    //   296: ldc 166
    //   298: invokevirtual 135	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   301: new 57	java/lang/StringBuilder
    //   304: dup
    //   305: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   308: astore 6
    //   310: aload 6
    //   312: ldc 168
    //   314: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: pop
    //   318: aload 6
    //   320: ldc 170
    //   322: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: pop
    //   326: aload_2
    //   327: ldc 172
    //   329: aload 6
    //   331: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   334: invokevirtual 135	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   337: new 174	java/util/HashMap
    //   340: dup
    //   341: invokespecial 175	java/util/HashMap:<init>	()V
    //   344: astore 11
    //   346: aload 11
    //   348: ldc 129
    //   350: ldc 177
    //   352: invokeinterface 183 3 0
    //   357: pop
    //   358: aload 11
    //   360: ldc 185
    //   362: aload 10
    //   364: invokeinterface 183 3 0
    //   369: pop
    //   370: getstatic 423	mqq/app/MobileQQ:sMobileQQ	Lmqq/app/MobileQQ;
    //   373: aconst_null
    //   374: invokevirtual 427	mqq/app/MobileQQ:waitAppRuntime	(Lmqq/app/BaseActivity;)Lmqq/app/AppRuntime;
    //   377: iconst_2
    //   378: invokevirtual 430	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   381: checkcast 191	mqq/manager/TicketManager
    //   384: astore 7
    //   386: aload 7
    //   388: aload_3
    //   389: invokeinterface 195 2 0
    //   394: astore 12
    //   396: aload 10
    //   398: invokestatic 35	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   401: istore 5
    //   403: iload 5
    //   405: ifne +28 -> 433
    //   408: aload 8
    //   410: astore 6
    //   412: aload 7
    //   414: aload_3
    //   415: ldc 197
    //   417: invokeinterface 201 3 0
    //   422: astore 7
    //   424: goto +12 -> 436
    //   427: astore_1
    //   428: aload_2
    //   429: astore_0
    //   430: goto +922 -> 1352
    //   433: aconst_null
    //   434: astore 7
    //   436: aload 9
    //   438: invokevirtual 369	java/io/File:exists	()Z
    //   441: istore 5
    //   443: iload 5
    //   445: ifeq +15 -> 460
    //   448: aload 8
    //   450: astore 6
    //   452: aload_1
    //   453: invokestatic 371	com/tencent/mobileqq/teamwork/TeamWorkHttpUtils:a	(Ljava/lang/String;)Ljava/lang/String;
    //   456: astore_1
    //   457: goto +5 -> 462
    //   460: aconst_null
    //   461: astore_1
    //   462: aload 7
    //   464: invokestatic 35	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   467: istore 5
    //   469: iload 5
    //   471: ifeq +51 -> 522
    //   474: aload 8
    //   476: astore 6
    //   478: ldc 203
    //   480: iconst_1
    //   481: ldc_w 432
    //   484: invokestatic 211	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   487: aload 8
    //   489: astore 6
    //   491: invokestatic 216	com/tencent/smtt/sdk/CookieManager:getInstance	()Lcom/tencent/smtt/sdk/CookieManager;
    //   494: astore_1
    //   495: aload_1
    //   496: ifnull +151 -> 647
    //   499: aload 8
    //   501: astore 6
    //   503: aload 11
    //   505: ldc 225
    //   507: aload_1
    //   508: aload 10
    //   510: invokevirtual 221	com/tencent/smtt/sdk/CookieManager:getCookie	(Ljava/lang/String;)Ljava/lang/String;
    //   513: invokeinterface 183 3 0
    //   518: pop
    //   519: goto +128 -> 647
    //   522: new 57	java/lang/StringBuilder
    //   525: dup
    //   526: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   529: astore 6
    //   531: aload 6
    //   533: ldc_w 434
    //   536: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   539: pop
    //   540: aload 6
    //   542: aload 7
    //   544: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   547: pop
    //   548: aload 6
    //   550: ldc_w 436
    //   553: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   556: pop
    //   557: aload 6
    //   559: aload_3
    //   560: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   563: pop
    //   564: aload 6
    //   566: ldc_w 438
    //   569: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   572: pop
    //   573: aload 6
    //   575: aload 12
    //   577: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   580: pop
    //   581: new 57	java/lang/StringBuilder
    //   584: dup
    //   585: aload 6
    //   587: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   590: invokespecial 138	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   593: astore_3
    //   594: aload_1
    //   595: ifnull +38 -> 633
    //   598: new 57	java/lang/StringBuilder
    //   601: dup
    //   602: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   605: astore 6
    //   607: aload 6
    //   609: ldc_w 440
    //   612: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   615: pop
    //   616: aload 6
    //   618: aload_1
    //   619: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   622: pop
    //   623: aload_3
    //   624: aload 6
    //   626: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   629: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   632: pop
    //   633: aload 11
    //   635: ldc 225
    //   637: aload_3
    //   638: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   641: invokeinterface 183 3 0
    //   646: pop
    //   647: aload 11
    //   649: invokeinterface 229 1 0
    //   654: invokeinterface 235 1 0
    //   659: astore_1
    //   660: aload_1
    //   661: invokeinterface 240 1 0
    //   666: ifeq +38 -> 704
    //   669: aload_1
    //   670: invokeinterface 244 1 0
    //   675: checkcast 246	java/util/Map$Entry
    //   678: astore_3
    //   679: aload_2
    //   680: aload_3
    //   681: invokeinterface 249 1 0
    //   686: checkcast 251	java/lang/String
    //   689: aload_3
    //   690: invokeinterface 254 1 0
    //   695: checkcast 251	java/lang/String
    //   698: invokevirtual 135	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   701: goto -41 -> 660
    //   704: new 442	java/io/DataOutputStream
    //   707: dup
    //   708: aload_2
    //   709: invokevirtual 446	javax/net/ssl/HttpsURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   712: invokespecial 449	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   715: astore_1
    //   716: aload_0
    //   717: ifnull +152 -> 869
    //   720: new 57	java/lang/StringBuilder
    //   723: dup
    //   724: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   727: astore_3
    //   728: aload_0
    //   729: invokevirtual 675	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   732: astore 6
    //   734: aload 6
    //   736: invokeinterface 240 1 0
    //   741: ifeq +117 -> 858
    //   744: aload 6
    //   746: invokeinterface 244 1 0
    //   751: checkcast 251	java/lang/String
    //   754: astore 7
    //   756: aload_0
    //   757: aload 7
    //   759: invokevirtual 623	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   762: astore 8
    //   764: aload 8
    //   766: ifnonnull +6 -> 772
    //   769: goto -35 -> 734
    //   772: aload_3
    //   773: ldc_w 454
    //   776: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   779: pop
    //   780: aload_3
    //   781: ldc_w 459
    //   784: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   787: pop
    //   788: aload_3
    //   789: ldc 170
    //   791: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   794: pop
    //   795: aload_3
    //   796: ldc_w 454
    //   799: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   802: pop
    //   803: new 57	java/lang/StringBuilder
    //   806: dup
    //   807: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   810: astore 10
    //   812: aload 10
    //   814: ldc_w 461
    //   817: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   820: pop
    //   821: aload 10
    //   823: aload 7
    //   825: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   828: pop
    //   829: aload 10
    //   831: ldc_w 677
    //   834: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   837: pop
    //   838: aload_3
    //   839: aload 10
    //   841: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   844: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   847: pop
    //   848: aload_3
    //   849: aload 8
    //   851: invokevirtual 359	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   854: pop
    //   855: goto -121 -> 734
    //   858: aload_1
    //   859: aload_3
    //   860: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   863: invokevirtual 477	java/lang/String:getBytes	()[B
    //   866: invokevirtual 480	java/io/OutputStream:write	([B)V
    //   869: new 451	java/lang/StringBuffer
    //   872: dup
    //   873: invokespecial 452	java/lang/StringBuffer:<init>	()V
    //   876: astore_0
    //   877: aload_0
    //   878: ldc_w 454
    //   881: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   884: pop
    //   885: aload_0
    //   886: ldc_w 459
    //   889: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   892: pop
    //   893: aload_0
    //   894: ldc 170
    //   896: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   899: pop
    //   900: aload_0
    //   901: ldc_w 454
    //   904: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   907: pop
    //   908: aload_0
    //   909: ldc_w 461
    //   912: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   915: pop
    //   916: aload_0
    //   917: ldc_w 463
    //   920: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   923: pop
    //   924: aload_0
    //   925: ldc_w 465
    //   928: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   931: pop
    //   932: aload_0
    //   933: aload 9
    //   935: invokevirtual 382	java/io/File:getName	()Ljava/lang/String;
    //   938: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   941: pop
    //   942: aload_0
    //   943: ldc_w 467
    //   946: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   949: pop
    //   950: aload_0
    //   951: ldc_w 454
    //   954: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   957: pop
    //   958: new 57	java/lang/StringBuilder
    //   961: dup
    //   962: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   965: astore_3
    //   966: aload_3
    //   967: ldc_w 469
    //   970: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   973: pop
    //   974: aload_3
    //   975: ldc_w 471
    //   978: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   981: pop
    //   982: aload_3
    //   983: ldc_w 473
    //   986: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   989: pop
    //   990: aload_0
    //   991: aload_3
    //   992: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   995: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   998: pop
    //   999: aload_1
    //   1000: aload_0
    //   1001: invokevirtual 474	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   1004: invokevirtual 477	java/lang/String:getBytes	()[B
    //   1007: invokevirtual 480	java/io/OutputStream:write	([B)V
    //   1010: new 482	java/io/BufferedInputStream
    //   1013: dup
    //   1014: new 482	java/io/BufferedInputStream
    //   1017: dup
    //   1018: new 484	java/io/FileInputStream
    //   1021: dup
    //   1022: aload 9
    //   1024: invokespecial 485	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   1027: invokespecial 488	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   1030: invokespecial 488	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   1033: astore_0
    //   1034: sipush 3072
    //   1037: newarray byte
    //   1039: astore_3
    //   1040: aload_0
    //   1041: aload_3
    //   1042: invokevirtual 489	java/io/BufferedInputStream:read	([B)I
    //   1045: istore 4
    //   1047: iload 4
    //   1049: iconst_m1
    //   1050: if_icmpeq +14 -> 1064
    //   1053: aload_1
    //   1054: aload_3
    //   1055: iconst_0
    //   1056: iload 4
    //   1058: invokevirtual 490	java/io/OutputStream:write	([BII)V
    //   1061: goto -21 -> 1040
    //   1064: aload_0
    //   1065: invokevirtual 491	java/io/BufferedInputStream:close	()V
    //   1068: new 57	java/lang/StringBuilder
    //   1071: dup
    //   1072: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   1075: astore_0
    //   1076: aload_0
    //   1077: ldc_w 493
    //   1080: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1083: pop
    //   1084: aload_0
    //   1085: ldc 170
    //   1087: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1090: pop
    //   1091: aload_0
    //   1092: ldc_w 495
    //   1095: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1098: pop
    //   1099: aload_1
    //   1100: aload_0
    //   1101: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1104: invokevirtual 477	java/lang/String:getBytes	()[B
    //   1107: invokevirtual 480	java/io/OutputStream:write	([B)V
    //   1110: aload_1
    //   1111: invokevirtual 498	java/io/OutputStream:flush	()V
    //   1114: aload_1
    //   1115: invokevirtual 499	java/io/OutputStream:close	()V
    //   1118: new 451	java/lang/StringBuffer
    //   1121: dup
    //   1122: invokespecial 452	java/lang/StringBuffer:<init>	()V
    //   1125: astore_0
    //   1126: aload_2
    //   1127: invokevirtual 515	javax/net/ssl/HttpsURLConnection:getResponseCode	()I
    //   1130: istore 4
    //   1132: iload 4
    //   1134: sipush 200
    //   1137: if_icmpeq +44 -> 1181
    //   1140: new 57	java/lang/StringBuilder
    //   1143: dup
    //   1144: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   1147: astore_1
    //   1148: aload_1
    //   1149: ldc_w 517
    //   1152: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1155: pop
    //   1156: aload_1
    //   1157: iload 4
    //   1159: invokevirtual 407	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1162: pop
    //   1163: aload_1
    //   1164: ldc_w 519
    //   1167: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1170: pop
    //   1171: ldc 203
    //   1173: iconst_1
    //   1174: aload_1
    //   1175: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1178: invokestatic 522	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1181: new 524	java/io/BufferedReader
    //   1184: dup
    //   1185: new 526	java/io/InputStreamReader
    //   1188: dup
    //   1189: aload_2
    //   1190: invokevirtual 277	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   1193: invokespecial 527	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   1196: invokespecial 530	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   1199: astore_1
    //   1200: aload_1
    //   1201: invokevirtual 533	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   1204: astore_3
    //   1205: aload_3
    //   1206: ifnull +20 -> 1226
    //   1209: aload_0
    //   1210: aload_3
    //   1211: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1214: pop
    //   1215: aload_0
    //   1216: ldc_w 535
    //   1219: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1222: pop
    //   1223: goto -23 -> 1200
    //   1226: aload_0
    //   1227: invokevirtual 474	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   1230: astore_0
    //   1231: aload_0
    //   1232: astore 6
    //   1234: aload_1
    //   1235: invokevirtual 536	java/io/BufferedReader:close	()V
    //   1238: aload_2
    //   1239: ifnull +7 -> 1246
    //   1242: aload_2
    //   1243: invokevirtual 350	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   1246: aload_0
    //   1247: areturn
    //   1248: astore_1
    //   1249: goto +75 -> 1324
    //   1252: new 57	java/lang/StringBuilder
    //   1255: dup
    //   1256: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   1259: astore_3
    //   1260: aload_3
    //   1261: ldc_w 501
    //   1264: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1267: pop
    //   1268: aload_3
    //   1269: aload 9
    //   1271: invokevirtual 504	java/io/File:length	()J
    //   1274: invokevirtual 507	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1277: pop
    //   1278: aload_3
    //   1279: ldc_w 509
    //   1282: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1285: pop
    //   1286: aload_3
    //   1287: aload 9
    //   1289: invokevirtual 512	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1292: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1295: pop
    //   1296: ldc 203
    //   1298: iconst_1
    //   1299: aload_3
    //   1300: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1303: invokestatic 211	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1306: aload_1
    //   1307: invokevirtual 498	java/io/OutputStream:flush	()V
    //   1310: aload_1
    //   1311: invokevirtual 499	java/io/OutputStream:close	()V
    //   1314: aload_2
    //   1315: invokevirtual 350	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   1318: aload_0
    //   1319: invokevirtual 491	java/io/BufferedInputStream:close	()V
    //   1322: aconst_null
    //   1323: areturn
    //   1324: aload_0
    //   1325: invokevirtual 491	java/io/BufferedInputStream:close	()V
    //   1328: aload_1
    //   1329: athrow
    //   1330: astore_0
    //   1331: goto +73 -> 1404
    //   1334: astore_1
    //   1335: aload_2
    //   1336: astore_0
    //   1337: goto +12 -> 1349
    //   1340: astore_0
    //   1341: aconst_null
    //   1342: astore_2
    //   1343: goto +61 -> 1404
    //   1346: astore_1
    //   1347: aconst_null
    //   1348: astore_0
    //   1349: aconst_null
    //   1350: astore 6
    //   1352: new 57	java/lang/StringBuilder
    //   1355: dup
    //   1356: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   1359: astore_2
    //   1360: aload_2
    //   1361: ldc_w 538
    //   1364: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1367: pop
    //   1368: aload_2
    //   1369: aload_1
    //   1370: invokevirtual 346	java/lang/Exception:toString	()Ljava/lang/String;
    //   1373: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1376: pop
    //   1377: ldc_w 339
    //   1380: iconst_1
    //   1381: aload_2
    //   1382: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1385: invokestatic 342	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1388: aload_0
    //   1389: ifnull +7 -> 1396
    //   1392: aload_0
    //   1393: invokevirtual 350	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   1396: aload 6
    //   1398: areturn
    //   1399: astore_1
    //   1400: aload_0
    //   1401: astore_2
    //   1402: aload_1
    //   1403: astore_0
    //   1404: aload_2
    //   1405: ifnull +7 -> 1412
    //   1408: aload_2
    //   1409: invokevirtual 350	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   1412: aload_0
    //   1413: athrow
    //   1414: astore_0
    //   1415: new 57	java/lang/StringBuilder
    //   1418: dup
    //   1419: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   1422: astore_1
    //   1423: aload_1
    //   1424: ldc_w 540
    //   1427: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1430: pop
    //   1431: aload_1
    //   1432: aload_0
    //   1433: invokevirtual 346	java/lang/Exception:toString	()Ljava/lang/String;
    //   1436: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1439: pop
    //   1440: ldc 203
    //   1442: iconst_1
    //   1443: aload_1
    //   1444: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1447: invokestatic 211	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1450: aconst_null
    //   1451: areturn
    //   1452: ldc 203
    //   1454: iconst_1
    //   1455: ldc_w 542
    //   1458: invokestatic 211	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1461: aconst_null
    //   1462: areturn
    //   1463: ldc 203
    //   1465: iconst_1
    //   1466: ldc_w 544
    //   1469: invokestatic 211	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1472: aconst_null
    //   1473: areturn
    //   1474: astore_3
    //   1475: goto -223 -> 1252
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1478	0	paramJSONObject	JSONObject
    //   0	1478	1	paramString1	String
    //   0	1478	2	paramString2	String
    //   0	1478	3	paramString3	String
    //   1045	113	4	i	int
    //   4	466	5	bool	boolean
    //   31	1366	6	localObject1	Object
    //   384	440	7	localObject2	Object
    //   7	843	8	str1	String
    //   41	1247	9	localFile	java.io.File
    //   63	777	10	localObject3	Object
    //   344	304	11	localHashMap	java.util.HashMap
    //   394	182	12	str2	String
    // Exception table:
    //   from	to	target	type
    //   412	424	427	java/lang/Exception
    //   452	457	427	java/lang/Exception
    //   478	487	427	java/lang/Exception
    //   491	495	427	java/lang/Exception
    //   503	519	427	java/lang/Exception
    //   1234	1238	427	java/lang/Exception
    //   1040	1047	1248	finally
    //   1053	1061	1248	finally
    //   1252	1318	1248	finally
    //   130	403	1330	finally
    //   412	424	1330	finally
    //   436	443	1330	finally
    //   452	457	1330	finally
    //   462	469	1330	finally
    //   478	487	1330	finally
    //   491	495	1330	finally
    //   503	519	1330	finally
    //   522	594	1330	finally
    //   598	633	1330	finally
    //   633	647	1330	finally
    //   647	660	1330	finally
    //   660	701	1330	finally
    //   704	716	1330	finally
    //   720	734	1330	finally
    //   734	764	1330	finally
    //   772	855	1330	finally
    //   858	869	1330	finally
    //   869	1040	1330	finally
    //   1064	1132	1330	finally
    //   1140	1181	1330	finally
    //   1181	1200	1330	finally
    //   1200	1205	1330	finally
    //   1209	1223	1330	finally
    //   1226	1231	1330	finally
    //   1234	1238	1330	finally
    //   1324	1330	1330	finally
    //   130	403	1334	java/lang/Exception
    //   436	443	1334	java/lang/Exception
    //   462	469	1334	java/lang/Exception
    //   522	594	1334	java/lang/Exception
    //   598	633	1334	java/lang/Exception
    //   633	647	1334	java/lang/Exception
    //   647	660	1334	java/lang/Exception
    //   660	701	1334	java/lang/Exception
    //   704	716	1334	java/lang/Exception
    //   720	734	1334	java/lang/Exception
    //   734	764	1334	java/lang/Exception
    //   772	855	1334	java/lang/Exception
    //   858	869	1334	java/lang/Exception
    //   869	1040	1334	java/lang/Exception
    //   1064	1132	1334	java/lang/Exception
    //   1140	1181	1334	java/lang/Exception
    //   1181	1200	1334	java/lang/Exception
    //   1200	1205	1334	java/lang/Exception
    //   1209	1223	1334	java/lang/Exception
    //   1226	1231	1334	java/lang/Exception
    //   1324	1330	1334	java/lang/Exception
    //   65	130	1340	finally
    //   1318	1322	1340	finally
    //   65	130	1346	java/lang/Exception
    //   1318	1322	1346	java/lang/Exception
    //   1352	1388	1399	finally
    //   51	58	1414	java/lang/Exception
    //   1040	1047	1474	java/lang/OutOfMemoryError
    //   1053	1061	1474	java/lang/OutOfMemoryError
  }
  
  public static String a(JSONObject paramJSONObject, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    return a(paramJSONObject.toString(), paramString1, paramString2, paramString3, paramString4, null, true);
  }
  
  /* Error */
  public static final JSONObject a(com.tencent.common.app.AppInterface paramAppInterface, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 35	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: istore 7
    //   6: aconst_null
    //   7: astore 16
    //   9: aconst_null
    //   10: astore 15
    //   12: iload 7
    //   14: ifne +1449 -> 1463
    //   17: aload_2
    //   18: invokestatic 35	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   21: ifeq +6 -> 27
    //   24: goto +1439 -> 1463
    //   27: aload_0
    //   28: ldc_w 683
    //   31: invokevirtual 686	java/lang/Class:getName	()Ljava/lang/String;
    //   34: invokevirtual 53	com/tencent/common/app/AppInterface:getBusinessHandler	(Ljava/lang/String;)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   37: checkcast 683	com/tencent/mobileqq/teamwork/TenDocOCRExportHandler
    //   40: astore 17
    //   42: aload 17
    //   44: iconst_2
    //   45: iconst_1
    //   46: aconst_null
    //   47: invokevirtual 687	com/tencent/mobileqq/teamwork/TenDocOCRExportHandler:notifyUI	(IZLjava/lang/Object;)V
    //   50: aload 17
    //   52: iconst_4
    //   53: iconst_1
    //   54: iconst_1
    //   55: anewarray 4	java/lang/Object
    //   58: dup
    //   59: iconst_0
    //   60: bipush 20
    //   62: invokestatic 303	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   65: aastore
    //   66: invokevirtual 687	com/tencent/mobileqq/teamwork/TenDocOCRExportHandler:notifyUI	(IZLjava/lang/Object;)V
    //   69: new 57	java/lang/StringBuilder
    //   72: dup
    //   73: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   76: astore_0
    //   77: aload_0
    //   78: ldc_w 689
    //   81: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: pop
    //   85: aload_0
    //   86: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   89: astore 19
    //   91: new 324	java/io/File
    //   94: dup
    //   95: aload_1
    //   96: invokespecial 325	java/io/File:<init>	(Ljava/lang/String;)V
    //   99: astore 18
    //   101: new 67	com/tencent/mobileqq/teamwork/CustomX509TrustManager
    //   104: dup
    //   105: invokespecial 68	com/tencent/mobileqq/teamwork/CustomX509TrustManager:<init>	()V
    //   108: astore_0
    //   109: ldc 70
    //   111: invokestatic 76	javax/net/ssl/SSLContext:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    //   114: astore 12
    //   116: aload 12
    //   118: aconst_null
    //   119: iconst_1
    //   120: anewarray 78	javax/net/ssl/TrustManager
    //   123: dup
    //   124: iconst_0
    //   125: aload_0
    //   126: aastore
    //   127: aconst_null
    //   128: invokevirtual 82	javax/net/ssl/SSLContext:init	([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Ljava/security/SecureRandom;)V
    //   131: new 84	com/tencent/mobileqq/teamwork/NoSSLv3SocketFactory
    //   134: dup
    //   135: aload 12
    //   137: invokevirtual 88	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   140: invokespecial 91	com/tencent/mobileqq/teamwork/NoSSLv3SocketFactory:<init>	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   143: astore_0
    //   144: aload_0
    //   145: invokestatic 96	javax/net/ssl/HttpsURLConnection:setDefaultSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   148: new 98	java/net/URL
    //   151: dup
    //   152: aload 19
    //   154: invokespecial 101	java/net/URL:<init>	(Ljava/lang/String;)V
    //   157: invokevirtual 105	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   160: checkcast 93	javax/net/ssl/HttpsURLConnection
    //   163: astore 12
    //   165: aload 12
    //   167: aload_0
    //   168: invokevirtual 108	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   171: aload 12
    //   173: sipush 5000
    //   176: invokevirtual 112	javax/net/ssl/HttpsURLConnection:setConnectTimeout	(I)V
    //   179: aload 12
    //   181: sipush 30000
    //   184: invokevirtual 115	javax/net/ssl/HttpsURLConnection:setReadTimeout	(I)V
    //   187: aload 12
    //   189: iconst_1
    //   190: invokevirtual 415	javax/net/ssl/HttpsURLConnection:setDoOutput	(Z)V
    //   193: aload 12
    //   195: iconst_1
    //   196: invokevirtual 119	javax/net/ssl/HttpsURLConnection:setDoInput	(Z)V
    //   199: aload 12
    //   201: iconst_0
    //   202: invokevirtual 122	javax/net/ssl/HttpsURLConnection:setUseCaches	(Z)V
    //   205: aload 12
    //   207: ldc_w 417
    //   210: invokevirtual 127	javax/net/ssl/HttpsURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   213: aload 12
    //   215: ldc 129
    //   217: ldc 131
    //   219: invokevirtual 135	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   222: new 57	java/lang/StringBuilder
    //   225: dup
    //   226: ldc 137
    //   228: invokespecial 138	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   231: astore_0
    //   232: aload_0
    //   233: ldc 140
    //   235: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: pop
    //   239: aload_0
    //   240: getstatic 146	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   243: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: pop
    //   247: aload_0
    //   248: ldc 140
    //   250: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: pop
    //   254: aload_0
    //   255: getstatic 151	android/os/Build:DEVICE	Ljava/lang/String;
    //   258: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: pop
    //   262: aload_0
    //   263: ldc 140
    //   265: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: pop
    //   269: aload_0
    //   270: getstatic 154	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   273: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: pop
    //   277: aload_0
    //   278: ldc 140
    //   280: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: pop
    //   284: aload_0
    //   285: ldc 156
    //   287: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: pop
    //   291: aload_0
    //   292: ldc 140
    //   294: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: pop
    //   298: aload_0
    //   299: ldc 158
    //   301: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: pop
    //   305: aload_0
    //   306: ldc 160
    //   308: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: pop
    //   312: aload 12
    //   314: ldc 162
    //   316: aload_0
    //   317: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   320: invokevirtual 135	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   323: aload 12
    //   325: ldc 164
    //   327: ldc 166
    //   329: invokevirtual 135	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   332: new 57	java/lang/StringBuilder
    //   335: dup
    //   336: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   339: astore_0
    //   340: aload_0
    //   341: ldc 168
    //   343: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: pop
    //   347: aload_0
    //   348: ldc 170
    //   350: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: pop
    //   354: aload 12
    //   356: ldc 172
    //   358: aload_0
    //   359: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   362: invokevirtual 135	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   365: new 174	java/util/HashMap
    //   368: dup
    //   369: invokespecial 175	java/util/HashMap:<init>	()V
    //   372: astore 20
    //   374: aload 20
    //   376: ldc 129
    //   378: ldc 177
    //   380: invokeinterface 183 3 0
    //   385: pop
    //   386: aload 20
    //   388: ldc 185
    //   390: aload 19
    //   392: invokeinterface 183 3 0
    //   397: pop
    //   398: getstatic 423	mqq/app/MobileQQ:sMobileQQ	Lmqq/app/MobileQQ;
    //   401: aconst_null
    //   402: invokevirtual 427	mqq/app/MobileQQ:waitAppRuntime	(Lmqq/app/BaseActivity;)Lmqq/app/AppRuntime;
    //   405: iconst_2
    //   406: invokevirtual 430	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   409: checkcast 191	mqq/manager/TicketManager
    //   412: astore_0
    //   413: aload_0
    //   414: aload_2
    //   415: invokeinterface 195 2 0
    //   420: astore 21
    //   422: aload 19
    //   424: invokestatic 35	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   427: istore 7
    //   429: iload 7
    //   431: ifne +31 -> 462
    //   434: aload 16
    //   436: astore 14
    //   438: aload 12
    //   440: astore 13
    //   442: aload_0
    //   443: aload_2
    //   444: ldc 197
    //   446: invokeinterface 201 3 0
    //   451: astore_0
    //   452: goto +12 -> 464
    //   455: astore_1
    //   456: aload 15
    //   458: astore_0
    //   459: goto +945 -> 1404
    //   462: aconst_null
    //   463: astore_0
    //   464: aload 18
    //   466: invokevirtual 369	java/io/File:exists	()Z
    //   469: istore 7
    //   471: iload 7
    //   473: ifeq +19 -> 492
    //   476: aload 16
    //   478: astore 14
    //   480: aload 12
    //   482: astore 13
    //   484: aload_1
    //   485: invokestatic 371	com/tencent/mobileqq/teamwork/TeamWorkHttpUtils:a	(Ljava/lang/String;)Ljava/lang/String;
    //   488: astore_1
    //   489: goto +5 -> 494
    //   492: aconst_null
    //   493: astore_1
    //   494: aload_0
    //   495: invokestatic 35	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   498: istore 7
    //   500: iload 7
    //   502: ifeq +39 -> 541
    //   505: ldc 203
    //   507: iconst_1
    //   508: ldc_w 432
    //   511: invokestatic 211	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   514: invokestatic 216	com/tencent/smtt/sdk/CookieManager:getInstance	()Lcom/tencent/smtt/sdk/CookieManager;
    //   517: astore_0
    //   518: aload_0
    //   519: ifnull +142 -> 661
    //   522: aload 20
    //   524: ldc 225
    //   526: aload_0
    //   527: aload 19
    //   529: invokevirtual 221	com/tencent/smtt/sdk/CookieManager:getCookie	(Ljava/lang/String;)Ljava/lang/String;
    //   532: invokeinterface 183 3 0
    //   537: pop
    //   538: goto +123 -> 661
    //   541: new 57	java/lang/StringBuilder
    //   544: dup
    //   545: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   548: astore 13
    //   550: aload 13
    //   552: ldc_w 434
    //   555: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   558: pop
    //   559: aload 13
    //   561: aload_0
    //   562: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   565: pop
    //   566: aload 13
    //   568: ldc_w 436
    //   571: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   574: pop
    //   575: aload 13
    //   577: aload_2
    //   578: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   581: pop
    //   582: aload 13
    //   584: ldc_w 438
    //   587: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   590: pop
    //   591: aload 13
    //   593: aload 21
    //   595: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   598: pop
    //   599: new 57	java/lang/StringBuilder
    //   602: dup
    //   603: aload 13
    //   605: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   608: invokespecial 138	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   611: astore_0
    //   612: aload_1
    //   613: ifnull +34 -> 647
    //   616: new 57	java/lang/StringBuilder
    //   619: dup
    //   620: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   623: astore_2
    //   624: aload_2
    //   625: ldc_w 440
    //   628: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   631: pop
    //   632: aload_2
    //   633: aload_1
    //   634: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   637: pop
    //   638: aload_0
    //   639: aload_2
    //   640: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   643: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   646: pop
    //   647: aload 20
    //   649: ldc 225
    //   651: aload_0
    //   652: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   655: invokeinterface 183 3 0
    //   660: pop
    //   661: aload 20
    //   663: invokeinterface 229 1 0
    //   668: invokeinterface 235 1 0
    //   673: astore_0
    //   674: aload_0
    //   675: invokeinterface 240 1 0
    //   680: ifeq +39 -> 719
    //   683: aload_0
    //   684: invokeinterface 244 1 0
    //   689: checkcast 246	java/util/Map$Entry
    //   692: astore_1
    //   693: aload 12
    //   695: aload_1
    //   696: invokeinterface 249 1 0
    //   701: checkcast 251	java/lang/String
    //   704: aload_1
    //   705: invokeinterface 254 1 0
    //   710: checkcast 251	java/lang/String
    //   713: invokevirtual 135	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   716: goto -42 -> 674
    //   719: new 442	java/io/DataOutputStream
    //   722: dup
    //   723: aload 12
    //   725: invokevirtual 446	javax/net/ssl/HttpsURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   728: invokespecial 449	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   731: astore_1
    //   732: new 451	java/lang/StringBuffer
    //   735: dup
    //   736: invokespecial 452	java/lang/StringBuffer:<init>	()V
    //   739: astore_0
    //   740: aload_0
    //   741: ldc_w 454
    //   744: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   747: pop
    //   748: aload_0
    //   749: ldc_w 459
    //   752: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   755: pop
    //   756: aload_0
    //   757: ldc 170
    //   759: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   762: pop
    //   763: aload_0
    //   764: ldc_w 454
    //   767: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   770: pop
    //   771: aload_0
    //   772: ldc_w 461
    //   775: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   778: pop
    //   779: aload_0
    //   780: ldc_w 463
    //   783: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   786: pop
    //   787: aload_0
    //   788: ldc_w 465
    //   791: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   794: pop
    //   795: aload_0
    //   796: aload 18
    //   798: invokevirtual 382	java/io/File:getName	()Ljava/lang/String;
    //   801: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   804: pop
    //   805: aload_0
    //   806: ldc_w 467
    //   809: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   812: pop
    //   813: aload_0
    //   814: ldc_w 454
    //   817: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   820: pop
    //   821: new 57	java/lang/StringBuilder
    //   824: dup
    //   825: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   828: astore_2
    //   829: aload_2
    //   830: ldc_w 469
    //   833: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   836: pop
    //   837: aload_2
    //   838: ldc_w 471
    //   841: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   844: pop
    //   845: aload_2
    //   846: ldc_w 473
    //   849: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   852: pop
    //   853: aload_0
    //   854: aload_2
    //   855: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   858: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   861: pop
    //   862: aload_1
    //   863: aload_0
    //   864: invokevirtual 474	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   867: invokevirtual 477	java/lang/String:getBytes	()[B
    //   870: invokevirtual 480	java/io/OutputStream:write	([B)V
    //   873: new 482	java/io/BufferedInputStream
    //   876: dup
    //   877: new 482	java/io/BufferedInputStream
    //   880: dup
    //   881: new 484	java/io/FileInputStream
    //   884: dup
    //   885: aload 18
    //   887: invokespecial 485	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   890: invokespecial 488	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   893: invokespecial 488	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   896: astore_0
    //   897: sipush 3072
    //   900: newarray byte
    //   902: astore_2
    //   903: aload 18
    //   905: invokevirtual 504	java/io/File:length	()J
    //   908: lstore 8
    //   910: lload 8
    //   912: l2i
    //   913: istore 5
    //   915: lconst_0
    //   916: lstore 8
    //   918: iconst_0
    //   919: istore_3
    //   920: aload_0
    //   921: aload_2
    //   922: invokevirtual 489	java/io/BufferedInputStream:read	([B)I
    //   925: istore 6
    //   927: iload 6
    //   929: iconst_m1
    //   930: if_icmpeq +72 -> 1002
    //   933: iload_3
    //   934: iload 6
    //   936: iadd
    //   937: istore 4
    //   939: aload_1
    //   940: aload_2
    //   941: iconst_0
    //   942: iload 6
    //   944: invokevirtual 490	java/io/OutputStream:write	([BII)V
    //   947: invokestatic 295	java/lang/System:currentTimeMillis	()J
    //   950: lstore 10
    //   952: iload 4
    //   954: istore_3
    //   955: lload 10
    //   957: lload 8
    //   959: lsub
    //   960: ldc2_w 296
    //   963: lcmp
    //   964: iflt -44 -> 920
    //   967: aload 17
    //   969: iconst_4
    //   970: iconst_1
    //   971: iconst_1
    //   972: anewarray 4	java/lang/Object
    //   975: dup
    //   976: iconst_0
    //   977: iload 4
    //   979: bipush 30
    //   981: imul
    //   982: iload 5
    //   984: idiv
    //   985: invokestatic 303	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   988: aastore
    //   989: invokevirtual 687	com/tencent/mobileqq/teamwork/TenDocOCRExportHandler:notifyUI	(IZLjava/lang/Object;)V
    //   992: lload 10
    //   994: lstore 8
    //   996: iload 4
    //   998: istore_3
    //   999: goto -79 -> 920
    //   1002: aload_0
    //   1003: invokevirtual 491	java/io/BufferedInputStream:close	()V
    //   1006: iconst_1
    //   1007: newarray int
    //   1009: astore_2
    //   1010: aload_2
    //   1011: iconst_0
    //   1012: bipush 50
    //   1014: iastore
    //   1015: aload 17
    //   1017: iconst_4
    //   1018: iconst_1
    //   1019: iconst_1
    //   1020: anewarray 4	java/lang/Object
    //   1023: dup
    //   1024: iconst_0
    //   1025: aload_2
    //   1026: iconst_0
    //   1027: iaload
    //   1028: invokestatic 303	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1031: aastore
    //   1032: invokevirtual 687	com/tencent/mobileqq/teamwork/TenDocOCRExportHandler:notifyUI	(IZLjava/lang/Object;)V
    //   1035: new 691	java/util/Timer
    //   1038: dup
    //   1039: invokespecial 692	java/util/Timer:<init>	()V
    //   1042: astore_0
    //   1043: aload_0
    //   1044: new 694	com/tencent/mobileqq/teamwork/TeamWorkHttpUtils$1
    //   1047: dup
    //   1048: aload_2
    //   1049: aload 17
    //   1051: invokespecial 697	com/tencent/mobileqq/teamwork/TeamWorkHttpUtils$1:<init>	([ILcom/tencent/mobileqq/teamwork/TenDocOCRExportHandler;)V
    //   1054: lconst_0
    //   1055: ldc2_w 296
    //   1058: invokevirtual 701	java/util/Timer:schedule	(Ljava/util/TimerTask;JJ)V
    //   1061: new 57	java/lang/StringBuilder
    //   1064: dup
    //   1065: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   1068: astore_2
    //   1069: aload_2
    //   1070: ldc_w 493
    //   1073: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1076: pop
    //   1077: aload_2
    //   1078: ldc 170
    //   1080: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1083: pop
    //   1084: aload_2
    //   1085: ldc_w 495
    //   1088: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1091: pop
    //   1092: aload_1
    //   1093: aload_2
    //   1094: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1097: invokevirtual 477	java/lang/String:getBytes	()[B
    //   1100: invokevirtual 480	java/io/OutputStream:write	([B)V
    //   1103: aload_1
    //   1104: invokevirtual 498	java/io/OutputStream:flush	()V
    //   1107: aload_1
    //   1108: invokevirtual 499	java/io/OutputStream:close	()V
    //   1111: new 451	java/lang/StringBuffer
    //   1114: dup
    //   1115: invokespecial 452	java/lang/StringBuffer:<init>	()V
    //   1118: astore_1
    //   1119: aload 12
    //   1121: invokevirtual 515	javax/net/ssl/HttpsURLConnection:getResponseCode	()I
    //   1124: istore_3
    //   1125: iload_3
    //   1126: sipush 200
    //   1129: if_icmpeq +43 -> 1172
    //   1132: new 57	java/lang/StringBuilder
    //   1135: dup
    //   1136: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   1139: astore_2
    //   1140: aload_2
    //   1141: ldc_w 517
    //   1144: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1147: pop
    //   1148: aload_2
    //   1149: iload_3
    //   1150: invokevirtual 407	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1153: pop
    //   1154: aload_2
    //   1155: ldc_w 519
    //   1158: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1161: pop
    //   1162: ldc 203
    //   1164: iconst_1
    //   1165: aload_2
    //   1166: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1169: invokestatic 522	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1172: new 524	java/io/BufferedReader
    //   1175: dup
    //   1176: new 526	java/io/InputStreamReader
    //   1179: dup
    //   1180: aload 12
    //   1182: invokevirtual 277	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   1185: invokespecial 527	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   1188: invokespecial 530	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   1191: astore_2
    //   1192: aload_2
    //   1193: invokevirtual 533	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   1196: astore 13
    //   1198: aload 13
    //   1200: ifnull +21 -> 1221
    //   1203: aload_1
    //   1204: aload 13
    //   1206: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1209: pop
    //   1210: aload_1
    //   1211: ldc_w 535
    //   1214: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1217: pop
    //   1218: goto -26 -> 1192
    //   1221: aload_1
    //   1222: invokevirtual 474	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   1225: astore_1
    //   1226: aload_2
    //   1227: invokevirtual 536	java/io/BufferedReader:close	()V
    //   1230: aload 17
    //   1232: iconst_4
    //   1233: iconst_1
    //   1234: iconst_1
    //   1235: anewarray 4	java/lang/Object
    //   1238: dup
    //   1239: iconst_0
    //   1240: bipush 100
    //   1242: invokestatic 303	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1245: aastore
    //   1246: invokevirtual 687	com/tencent/mobileqq/teamwork/TenDocOCRExportHandler:notifyUI	(IZLjava/lang/Object;)V
    //   1249: new 606	org/json/JSONObject
    //   1252: dup
    //   1253: aload_1
    //   1254: invokespecial 607	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1257: astore_1
    //   1258: goto +10 -> 1268
    //   1261: astore_1
    //   1262: aload_1
    //   1263: invokevirtual 704	java/lang/Exception:printStackTrace	()V
    //   1266: aconst_null
    //   1267: astore_1
    //   1268: aload_0
    //   1269: invokevirtual 707	java/util/Timer:cancel	()V
    //   1272: aload 12
    //   1274: ifnull +8 -> 1282
    //   1277: aload 12
    //   1279: invokevirtual 350	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   1282: aload_1
    //   1283: areturn
    //   1284: astore_2
    //   1285: aload_0
    //   1286: astore_1
    //   1287: aload_2
    //   1288: astore_0
    //   1289: goto +154 -> 1443
    //   1292: astore_1
    //   1293: goto +111 -> 1404
    //   1296: astore_1
    //   1297: goto +76 -> 1373
    //   1300: new 57	java/lang/StringBuilder
    //   1303: dup
    //   1304: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   1307: astore_2
    //   1308: aload_2
    //   1309: ldc_w 501
    //   1312: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1315: pop
    //   1316: aload_2
    //   1317: aload 18
    //   1319: invokevirtual 504	java/io/File:length	()J
    //   1322: invokevirtual 507	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1325: pop
    //   1326: aload_2
    //   1327: ldc_w 509
    //   1330: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1333: pop
    //   1334: aload_2
    //   1335: aload 18
    //   1337: invokevirtual 512	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1340: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1343: pop
    //   1344: ldc 203
    //   1346: iconst_1
    //   1347: aload_2
    //   1348: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1351: invokestatic 211	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1354: aload_1
    //   1355: invokevirtual 498	java/io/OutputStream:flush	()V
    //   1358: aload_1
    //   1359: invokevirtual 499	java/io/OutputStream:close	()V
    //   1362: aload 12
    //   1364: invokevirtual 350	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   1367: aload_0
    //   1368: invokevirtual 491	java/io/BufferedInputStream:close	()V
    //   1371: aconst_null
    //   1372: areturn
    //   1373: aload_0
    //   1374: invokevirtual 491	java/io/BufferedInputStream:close	()V
    //   1377: aload_1
    //   1378: athrow
    //   1379: astore_0
    //   1380: goto +13 -> 1393
    //   1383: astore_1
    //   1384: aconst_null
    //   1385: astore_0
    //   1386: goto +18 -> 1404
    //   1389: astore_0
    //   1390: aconst_null
    //   1391: astore 12
    //   1393: aconst_null
    //   1394: astore_1
    //   1395: goto +48 -> 1443
    //   1398: astore_1
    //   1399: aconst_null
    //   1400: astore_0
    //   1401: aconst_null
    //   1402: astore 12
    //   1404: aload_0
    //   1405: astore 14
    //   1407: aload 12
    //   1409: astore 13
    //   1411: aload_1
    //   1412: invokevirtual 704	java/lang/Exception:printStackTrace	()V
    //   1415: aload_0
    //   1416: ifnull +7 -> 1423
    //   1419: aload_0
    //   1420: invokevirtual 707	java/util/Timer:cancel	()V
    //   1423: aload 12
    //   1425: ifnull +8 -> 1433
    //   1428: aload 12
    //   1430: invokevirtual 350	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   1433: aconst_null
    //   1434: areturn
    //   1435: astore_0
    //   1436: aload 14
    //   1438: astore_1
    //   1439: aload 13
    //   1441: astore 12
    //   1443: aload_1
    //   1444: ifnull +7 -> 1451
    //   1447: aload_1
    //   1448: invokevirtual 707	java/util/Timer:cancel	()V
    //   1451: aload 12
    //   1453: ifnull +8 -> 1461
    //   1456: aload 12
    //   1458: invokevirtual 350	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   1461: aload_0
    //   1462: athrow
    //   1463: ldc 203
    //   1465: iconst_1
    //   1466: ldc_w 709
    //   1469: invokestatic 211	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1472: aconst_null
    //   1473: areturn
    //   1474: astore_2
    //   1475: goto -175 -> 1300
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1478	0	paramAppInterface	com.tencent.common.app.AppInterface
    //   0	1478	1	paramString1	String
    //   0	1478	2	paramString2	String
    //   919	231	3	i	int
    //   937	60	4	j	int
    //   913	72	5	k	int
    //   925	18	6	m	int
    //   4	497	7	bool	boolean
    //   908	87	8	l1	long
    //   950	43	10	l2	long
    //   114	1343	12	localObject1	Object
    //   440	1000	13	localObject2	Object
    //   436	1001	14	localObject3	Object
    //   10	447	15	localObject4	Object
    //   7	470	16	localObject5	Object
    //   40	1191	17	localTenDocOCRExportHandler	TenDocOCRExportHandler
    //   99	1237	18	localFile	java.io.File
    //   89	439	19	str1	String
    //   372	290	20	localHashMap	java.util.HashMap
    //   420	174	21	str2	String
    // Exception table:
    //   from	to	target	type
    //   442	452	455	java/lang/Exception
    //   484	489	455	java/lang/Exception
    //   1249	1258	1261	java/lang/Exception
    //   1043	1125	1284	finally
    //   1132	1172	1284	finally
    //   1172	1192	1284	finally
    //   1192	1198	1284	finally
    //   1203	1218	1284	finally
    //   1221	1249	1284	finally
    //   1249	1258	1284	finally
    //   1262	1266	1284	finally
    //   1043	1125	1292	java/lang/Exception
    //   1132	1172	1292	java/lang/Exception
    //   1172	1192	1292	java/lang/Exception
    //   1192	1198	1292	java/lang/Exception
    //   1203	1218	1292	java/lang/Exception
    //   1221	1249	1292	java/lang/Exception
    //   1262	1266	1292	java/lang/Exception
    //   920	927	1296	finally
    //   939	952	1296	finally
    //   967	992	1296	finally
    //   1300	1367	1296	finally
    //   165	429	1379	finally
    //   464	471	1379	finally
    //   494	500	1379	finally
    //   505	518	1379	finally
    //   522	538	1379	finally
    //   541	612	1379	finally
    //   616	647	1379	finally
    //   647	661	1379	finally
    //   661	674	1379	finally
    //   674	716	1379	finally
    //   719	910	1379	finally
    //   1002	1010	1379	finally
    //   1015	1043	1379	finally
    //   1373	1379	1379	finally
    //   165	429	1383	java/lang/Exception
    //   464	471	1383	java/lang/Exception
    //   494	500	1383	java/lang/Exception
    //   505	518	1383	java/lang/Exception
    //   522	538	1383	java/lang/Exception
    //   541	612	1383	java/lang/Exception
    //   616	647	1383	java/lang/Exception
    //   647	661	1383	java/lang/Exception
    //   661	674	1383	java/lang/Exception
    //   674	716	1383	java/lang/Exception
    //   719	910	1383	java/lang/Exception
    //   1002	1010	1383	java/lang/Exception
    //   1015	1043	1383	java/lang/Exception
    //   1373	1379	1383	java/lang/Exception
    //   101	165	1389	finally
    //   1367	1371	1389	finally
    //   101	165	1398	java/lang/Exception
    //   1367	1371	1398	java/lang/Exception
    //   442	452	1435	finally
    //   484	489	1435	finally
    //   1411	1415	1435	finally
    //   920	927	1474	java/lang/OutOfMemoryError
    //   939	952	1474	java/lang/OutOfMemoryError
    //   967	992	1474	java/lang/OutOfMemoryError
  }
  
  public static String b(TeamWorkFileImportInfo paramTeamWorkFileImportInfo, String paramString)
  {
    if ((paramTeamWorkFileImportInfo != null) && (!TextUtils.isEmpty(paramTeamWorkFileImportInfo.k)))
    {
      if (TextUtils.isEmpty(paramString)) {
        return "";
      }
      String str = UUID.randomUUID().toString().replaceAll("-", "");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("TOK=");
      localStringBuilder.append(str);
      Object localObject2 = paramTeamWorkFileImportInfo.k;
      Object localObject1;
      try
      {
        localObject1 = URLEncoder.encode((String)localObject2, "UTF-8");
      }
      catch (Throwable localThrowable)
      {
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          QLog.e("TeamWorkHttpUtils", 2, "url2Doc error", localThrowable);
          localObject1 = localObject2;
        }
      }
      localObject2 = new StringBuilder("https://docs.qq.com/cgi-go/imp/import_url2doc");
      ((StringBuilder)localObject2).append("?xsrf=");
      ((StringBuilder)localObject2).append(str);
      if (!TextUtils.isEmpty(paramTeamWorkFileImportInfo.v))
      {
        ((StringBuilder)localObject2).append("&folderId=");
        ((StringBuilder)localObject2).append(paramTeamWorkFileImportInfo.v);
      }
      ((StringBuilder)localObject2).append("&url=");
      ((StringBuilder)localObject2).append((String)localObject1);
      return a(paramString, ((StringBuilder)localObject2).toString(), "docs.qq.com", localStringBuilder.toString());
    }
    return "";
  }
  
  /* Error */
  public static final String b(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 35	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: istore_3
    //   5: aconst_null
    //   6: astore 4
    //   8: aconst_null
    //   9: astore 7
    //   11: aconst_null
    //   12: astore 6
    //   14: iload_3
    //   15: ifeq +14 -> 29
    //   18: ldc 203
    //   20: iconst_1
    //   21: ldc_w 729
    //   24: invokestatic 211	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   27: aconst_null
    //   28: areturn
    //   29: new 57	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   36: astore 5
    //   38: aload 5
    //   40: ldc_w 373
    //   43: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: pop
    //   47: aload 5
    //   49: aload_1
    //   50: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: new 57	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   61: astore 8
    //   63: aload 8
    //   65: ldc_w 731
    //   68: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: pop
    //   72: aload 8
    //   74: aload_0
    //   75: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: pop
    //   79: aload 5
    //   81: aload 8
    //   83: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   86: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: pop
    //   90: aload 5
    //   92: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: astore 8
    //   97: aload 4
    //   99: astore_0
    //   100: new 67	com/tencent/mobileqq/teamwork/CustomX509TrustManager
    //   103: dup
    //   104: invokespecial 68	com/tencent/mobileqq/teamwork/CustomX509TrustManager:<init>	()V
    //   107: astore 5
    //   109: aload 4
    //   111: astore_0
    //   112: ldc 70
    //   114: invokestatic 76	javax/net/ssl/SSLContext:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    //   117: astore 9
    //   119: aload 4
    //   121: astore_0
    //   122: aload 9
    //   124: aconst_null
    //   125: iconst_1
    //   126: anewarray 78	javax/net/ssl/TrustManager
    //   129: dup
    //   130: iconst_0
    //   131: aload 5
    //   133: aastore
    //   134: aconst_null
    //   135: invokevirtual 82	javax/net/ssl/SSLContext:init	([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Ljava/security/SecureRandom;)V
    //   138: aload 4
    //   140: astore_0
    //   141: new 84	com/tencent/mobileqq/teamwork/NoSSLv3SocketFactory
    //   144: dup
    //   145: aload 9
    //   147: invokevirtual 88	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   150: invokespecial 91	com/tencent/mobileqq/teamwork/NoSSLv3SocketFactory:<init>	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   153: astore 5
    //   155: aload 4
    //   157: astore_0
    //   158: aload 5
    //   160: invokestatic 96	javax/net/ssl/HttpsURLConnection:setDefaultSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   163: aload 4
    //   165: astore_0
    //   166: new 98	java/net/URL
    //   169: dup
    //   170: aload 8
    //   172: invokespecial 101	java/net/URL:<init>	(Ljava/lang/String;)V
    //   175: invokevirtual 105	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   178: checkcast 93	javax/net/ssl/HttpsURLConnection
    //   181: astore 4
    //   183: aload 6
    //   185: astore_0
    //   186: aload 4
    //   188: aload 5
    //   190: invokevirtual 108	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   193: aload 6
    //   195: astore_0
    //   196: aload 4
    //   198: sipush 5000
    //   201: invokevirtual 112	javax/net/ssl/HttpsURLConnection:setConnectTimeout	(I)V
    //   204: aload 6
    //   206: astore_0
    //   207: aload 4
    //   209: sipush 30000
    //   212: invokevirtual 115	javax/net/ssl/HttpsURLConnection:setReadTimeout	(I)V
    //   215: aload 6
    //   217: astore_0
    //   218: aload 4
    //   220: iconst_1
    //   221: invokevirtual 415	javax/net/ssl/HttpsURLConnection:setDoOutput	(Z)V
    //   224: aload 6
    //   226: astore_0
    //   227: aload 4
    //   229: iconst_1
    //   230: invokevirtual 119	javax/net/ssl/HttpsURLConnection:setDoInput	(Z)V
    //   233: aload 6
    //   235: astore_0
    //   236: aload 4
    //   238: iconst_0
    //   239: invokevirtual 122	javax/net/ssl/HttpsURLConnection:setUseCaches	(Z)V
    //   242: aload 6
    //   244: astore_0
    //   245: aload 4
    //   247: ldc 124
    //   249: invokevirtual 127	javax/net/ssl/HttpsURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   252: aload 6
    //   254: astore_0
    //   255: aload 4
    //   257: ldc 129
    //   259: ldc 131
    //   261: invokevirtual 135	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   264: aload 6
    //   266: astore_0
    //   267: new 57	java/lang/StringBuilder
    //   270: dup
    //   271: ldc 137
    //   273: invokespecial 138	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   276: astore 5
    //   278: aload 6
    //   280: astore_0
    //   281: aload 5
    //   283: ldc 140
    //   285: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: pop
    //   289: aload 6
    //   291: astore_0
    //   292: aload 5
    //   294: getstatic 146	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   297: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: pop
    //   301: aload 6
    //   303: astore_0
    //   304: aload 5
    //   306: ldc 140
    //   308: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: pop
    //   312: aload 6
    //   314: astore_0
    //   315: aload 5
    //   317: getstatic 151	android/os/Build:DEVICE	Ljava/lang/String;
    //   320: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: pop
    //   324: aload 6
    //   326: astore_0
    //   327: aload 5
    //   329: ldc 140
    //   331: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   334: pop
    //   335: aload 6
    //   337: astore_0
    //   338: aload 5
    //   340: getstatic 154	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   343: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: pop
    //   347: aload 6
    //   349: astore_0
    //   350: aload 5
    //   352: ldc 140
    //   354: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   357: pop
    //   358: aload 6
    //   360: astore_0
    //   361: aload 5
    //   363: ldc 156
    //   365: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   368: pop
    //   369: aload 6
    //   371: astore_0
    //   372: aload 5
    //   374: ldc 140
    //   376: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   379: pop
    //   380: aload 6
    //   382: astore_0
    //   383: aload 5
    //   385: ldc 158
    //   387: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   390: pop
    //   391: aload 6
    //   393: astore_0
    //   394: aload 5
    //   396: ldc 160
    //   398: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: pop
    //   402: aload 6
    //   404: astore_0
    //   405: aload 4
    //   407: ldc 162
    //   409: aload 5
    //   411: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   414: invokevirtual 135	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   417: aload 6
    //   419: astore_0
    //   420: aload 4
    //   422: ldc 172
    //   424: ldc_w 629
    //   427: invokevirtual 135	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   430: aload 6
    //   432: astore_0
    //   433: aload 4
    //   435: ldc 164
    //   437: ldc 166
    //   439: invokevirtual 135	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   442: aload 6
    //   444: astore_0
    //   445: aload 4
    //   447: ldc_w 631
    //   450: ldc_w 384
    //   453: invokevirtual 135	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   456: aload 6
    //   458: astore_0
    //   459: new 174	java/util/HashMap
    //   462: dup
    //   463: invokespecial 175	java/util/HashMap:<init>	()V
    //   466: astore 7
    //   468: aload 6
    //   470: astore_0
    //   471: aload 7
    //   473: ldc 129
    //   475: ldc 177
    //   477: invokeinterface 183 3 0
    //   482: pop
    //   483: aload 6
    //   485: astore_0
    //   486: aload 7
    //   488: ldc 185
    //   490: aload 8
    //   492: invokeinterface 183 3 0
    //   497: pop
    //   498: aload 6
    //   500: astore_0
    //   501: getstatic 423	mqq/app/MobileQQ:sMobileQQ	Lmqq/app/MobileQQ;
    //   504: aconst_null
    //   505: invokevirtual 427	mqq/app/MobileQQ:waitAppRuntime	(Lmqq/app/BaseActivity;)Lmqq/app/AppRuntime;
    //   508: iconst_2
    //   509: invokevirtual 430	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   512: checkcast 191	mqq/manager/TicketManager
    //   515: astore 5
    //   517: aload 6
    //   519: astore_0
    //   520: aload 5
    //   522: aload_1
    //   523: invokeinterface 195 2 0
    //   528: astore 9
    //   530: aload 6
    //   532: astore_0
    //   533: aload 8
    //   535: invokestatic 35	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   538: ifne +541 -> 1079
    //   541: aload 6
    //   543: astore_0
    //   544: aload 5
    //   546: aload_1
    //   547: ldc 197
    //   549: invokeinterface 201 3 0
    //   554: astore 5
    //   556: goto +3 -> 559
    //   559: aload 6
    //   561: astore_0
    //   562: aload 5
    //   564: invokestatic 35	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   567: istore_3
    //   568: iload_3
    //   569: ifeq +48 -> 617
    //   572: aload 6
    //   574: astore_0
    //   575: ldc 203
    //   577: iconst_1
    //   578: ldc_w 633
    //   581: invokestatic 211	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   584: aload 6
    //   586: astore_0
    //   587: invokestatic 216	com/tencent/smtt/sdk/CookieManager:getInstance	()Lcom/tencent/smtt/sdk/CookieManager;
    //   590: astore_1
    //   591: aload_1
    //   592: ifnull +123 -> 715
    //   595: aload 6
    //   597: astore_0
    //   598: aload 7
    //   600: ldc 225
    //   602: aload_1
    //   603: aload 8
    //   605: invokevirtual 221	com/tencent/smtt/sdk/CookieManager:getCookie	(Ljava/lang/String;)Ljava/lang/String;
    //   608: invokeinterface 183 3 0
    //   613: pop
    //   614: goto +101 -> 715
    //   617: aload 6
    //   619: astore_0
    //   620: new 57	java/lang/StringBuilder
    //   623: dup
    //   624: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   627: astore 8
    //   629: aload 6
    //   631: astore_0
    //   632: aload 8
    //   634: ldc_w 434
    //   637: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   640: pop
    //   641: aload 6
    //   643: astore_0
    //   644: aload 8
    //   646: aload 5
    //   648: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   651: pop
    //   652: aload 6
    //   654: astore_0
    //   655: aload 8
    //   657: ldc_w 436
    //   660: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   663: pop
    //   664: aload 6
    //   666: astore_0
    //   667: aload 8
    //   669: aload_1
    //   670: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   673: pop
    //   674: aload 6
    //   676: astore_0
    //   677: aload 8
    //   679: ldc_w 438
    //   682: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   685: pop
    //   686: aload 6
    //   688: astore_0
    //   689: aload 8
    //   691: aload 9
    //   693: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   696: pop
    //   697: aload 6
    //   699: astore_0
    //   700: aload 7
    //   702: ldc 225
    //   704: aload 8
    //   706: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   709: invokeinterface 183 3 0
    //   714: pop
    //   715: aload 6
    //   717: astore_0
    //   718: aload 7
    //   720: invokeinterface 229 1 0
    //   725: invokeinterface 235 1 0
    //   730: astore_1
    //   731: aload 6
    //   733: astore_0
    //   734: aload_1
    //   735: invokeinterface 240 1 0
    //   740: ifeq +48 -> 788
    //   743: aload 6
    //   745: astore_0
    //   746: aload_1
    //   747: invokeinterface 244 1 0
    //   752: checkcast 246	java/util/Map$Entry
    //   755: astore 5
    //   757: aload 6
    //   759: astore_0
    //   760: aload 4
    //   762: aload 5
    //   764: invokeinterface 249 1 0
    //   769: checkcast 251	java/lang/String
    //   772: aload 5
    //   774: invokeinterface 254 1 0
    //   779: checkcast 251	java/lang/String
    //   782: invokevirtual 135	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   785: goto -54 -> 731
    //   788: aload 6
    //   790: astore_0
    //   791: new 451	java/lang/StringBuffer
    //   794: dup
    //   795: invokespecial 452	java/lang/StringBuffer:<init>	()V
    //   798: astore_1
    //   799: aload 6
    //   801: astore_0
    //   802: aload 4
    //   804: invokevirtual 515	javax/net/ssl/HttpsURLConnection:getResponseCode	()I
    //   807: istore_2
    //   808: iload_2
    //   809: sipush 200
    //   812: if_icmpeq +63 -> 875
    //   815: aload 6
    //   817: astore_0
    //   818: new 57	java/lang/StringBuilder
    //   821: dup
    //   822: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   825: astore 5
    //   827: aload 6
    //   829: astore_0
    //   830: aload 5
    //   832: ldc_w 733
    //   835: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   838: pop
    //   839: aload 6
    //   841: astore_0
    //   842: aload 5
    //   844: iload_2
    //   845: invokevirtual 407	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   848: pop
    //   849: aload 6
    //   851: astore_0
    //   852: aload 5
    //   854: ldc_w 519
    //   857: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   860: pop
    //   861: aload 6
    //   863: astore_0
    //   864: ldc 203
    //   866: iconst_1
    //   867: aload 5
    //   869: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   872: invokestatic 522	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   875: aload 6
    //   877: astore_0
    //   878: new 524	java/io/BufferedReader
    //   881: dup
    //   882: new 526	java/io/InputStreamReader
    //   885: dup
    //   886: aload 4
    //   888: invokevirtual 277	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   891: invokespecial 527	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   894: invokespecial 530	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   897: astore 5
    //   899: aload 6
    //   901: astore_0
    //   902: aload 5
    //   904: invokevirtual 533	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   907: astore 7
    //   909: aload 7
    //   911: ifnull +27 -> 938
    //   914: aload 6
    //   916: astore_0
    //   917: aload_1
    //   918: aload 7
    //   920: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   923: pop
    //   924: aload 6
    //   926: astore_0
    //   927: aload_1
    //   928: ldc_w 535
    //   931: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   934: pop
    //   935: goto -36 -> 899
    //   938: aload 6
    //   940: astore_0
    //   941: aload_1
    //   942: invokevirtual 474	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   945: astore_1
    //   946: aload_1
    //   947: astore_0
    //   948: aload 5
    //   950: invokevirtual 536	java/io/BufferedReader:close	()V
    //   953: aload 4
    //   955: ifnull +8 -> 963
    //   958: aload 4
    //   960: invokevirtual 350	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   963: aload_1
    //   964: areturn
    //   965: astore_0
    //   966: goto +95 -> 1061
    //   969: astore 5
    //   971: aload 4
    //   973: astore_1
    //   974: aload 5
    //   976: astore 4
    //   978: aload_0
    //   979: astore 5
    //   981: goto +20 -> 1001
    //   984: astore_1
    //   985: aload_0
    //   986: astore 4
    //   988: aload_1
    //   989: astore_0
    //   990: goto +71 -> 1061
    //   993: astore 4
    //   995: aconst_null
    //   996: astore 5
    //   998: aload 7
    //   1000: astore_1
    //   1001: aload_1
    //   1002: astore_0
    //   1003: new 57	java/lang/StringBuilder
    //   1006: dup
    //   1007: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   1010: astore 6
    //   1012: aload_1
    //   1013: astore_0
    //   1014: aload 6
    //   1016: ldc_w 664
    //   1019: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1022: pop
    //   1023: aload_1
    //   1024: astore_0
    //   1025: aload 6
    //   1027: aload 4
    //   1029: invokevirtual 346	java/lang/Exception:toString	()Ljava/lang/String;
    //   1032: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1035: pop
    //   1036: aload_1
    //   1037: astore_0
    //   1038: ldc_w 735
    //   1041: iconst_1
    //   1042: aload 6
    //   1044: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1047: invokestatic 342	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1050: aload_1
    //   1051: ifnull +7 -> 1058
    //   1054: aload_1
    //   1055: invokevirtual 350	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   1058: aload 5
    //   1060: areturn
    //   1061: aload 4
    //   1063: ifnull +8 -> 1071
    //   1066: aload 4
    //   1068: invokevirtual 350	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   1071: goto +5 -> 1076
    //   1074: aload_0
    //   1075: athrow
    //   1076: goto -2 -> 1074
    //   1079: aconst_null
    //   1080: astore 5
    //   1082: goto -523 -> 559
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1085	0	paramString1	String
    //   0	1085	1	paramString2	String
    //   807	38	2	i	int
    //   4	565	3	bool	boolean
    //   6	981	4	localObject1	Object
    //   993	74	4	localException1	java.lang.Exception
    //   36	913	5	localObject2	Object
    //   969	6	5	localException2	java.lang.Exception
    //   979	102	5	str	String
    //   12	1031	6	localStringBuilder	StringBuilder
    //   9	990	7	localObject3	Object
    //   61	644	8	localObject4	Object
    //   117	575	9	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   186	193	965	finally
    //   196	204	965	finally
    //   207	215	965	finally
    //   218	224	965	finally
    //   227	233	965	finally
    //   236	242	965	finally
    //   245	252	965	finally
    //   255	264	965	finally
    //   267	278	965	finally
    //   281	289	965	finally
    //   292	301	965	finally
    //   304	312	965	finally
    //   315	324	965	finally
    //   327	335	965	finally
    //   338	347	965	finally
    //   350	358	965	finally
    //   361	369	965	finally
    //   372	380	965	finally
    //   383	391	965	finally
    //   394	402	965	finally
    //   405	417	965	finally
    //   420	430	965	finally
    //   433	442	965	finally
    //   445	456	965	finally
    //   459	468	965	finally
    //   471	483	965	finally
    //   486	498	965	finally
    //   501	517	965	finally
    //   520	530	965	finally
    //   533	541	965	finally
    //   544	556	965	finally
    //   562	568	965	finally
    //   575	584	965	finally
    //   587	591	965	finally
    //   598	614	965	finally
    //   620	629	965	finally
    //   632	641	965	finally
    //   644	652	965	finally
    //   655	664	965	finally
    //   667	674	965	finally
    //   677	686	965	finally
    //   689	697	965	finally
    //   700	715	965	finally
    //   718	731	965	finally
    //   734	743	965	finally
    //   746	757	965	finally
    //   760	785	965	finally
    //   791	799	965	finally
    //   802	808	965	finally
    //   818	827	965	finally
    //   830	839	965	finally
    //   842	849	965	finally
    //   852	861	965	finally
    //   864	875	965	finally
    //   878	899	965	finally
    //   902	909	965	finally
    //   917	924	965	finally
    //   927	935	965	finally
    //   941	946	965	finally
    //   948	953	965	finally
    //   186	193	969	java/lang/Exception
    //   196	204	969	java/lang/Exception
    //   207	215	969	java/lang/Exception
    //   218	224	969	java/lang/Exception
    //   227	233	969	java/lang/Exception
    //   236	242	969	java/lang/Exception
    //   245	252	969	java/lang/Exception
    //   255	264	969	java/lang/Exception
    //   267	278	969	java/lang/Exception
    //   281	289	969	java/lang/Exception
    //   292	301	969	java/lang/Exception
    //   304	312	969	java/lang/Exception
    //   315	324	969	java/lang/Exception
    //   327	335	969	java/lang/Exception
    //   338	347	969	java/lang/Exception
    //   350	358	969	java/lang/Exception
    //   361	369	969	java/lang/Exception
    //   372	380	969	java/lang/Exception
    //   383	391	969	java/lang/Exception
    //   394	402	969	java/lang/Exception
    //   405	417	969	java/lang/Exception
    //   420	430	969	java/lang/Exception
    //   433	442	969	java/lang/Exception
    //   445	456	969	java/lang/Exception
    //   459	468	969	java/lang/Exception
    //   471	483	969	java/lang/Exception
    //   486	498	969	java/lang/Exception
    //   501	517	969	java/lang/Exception
    //   520	530	969	java/lang/Exception
    //   533	541	969	java/lang/Exception
    //   544	556	969	java/lang/Exception
    //   562	568	969	java/lang/Exception
    //   575	584	969	java/lang/Exception
    //   587	591	969	java/lang/Exception
    //   598	614	969	java/lang/Exception
    //   620	629	969	java/lang/Exception
    //   632	641	969	java/lang/Exception
    //   644	652	969	java/lang/Exception
    //   655	664	969	java/lang/Exception
    //   667	674	969	java/lang/Exception
    //   677	686	969	java/lang/Exception
    //   689	697	969	java/lang/Exception
    //   700	715	969	java/lang/Exception
    //   718	731	969	java/lang/Exception
    //   734	743	969	java/lang/Exception
    //   746	757	969	java/lang/Exception
    //   760	785	969	java/lang/Exception
    //   791	799	969	java/lang/Exception
    //   802	808	969	java/lang/Exception
    //   818	827	969	java/lang/Exception
    //   830	839	969	java/lang/Exception
    //   842	849	969	java/lang/Exception
    //   852	861	969	java/lang/Exception
    //   864	875	969	java/lang/Exception
    //   878	899	969	java/lang/Exception
    //   902	909	969	java/lang/Exception
    //   917	924	969	java/lang/Exception
    //   927	935	969	java/lang/Exception
    //   941	946	969	java/lang/Exception
    //   948	953	969	java/lang/Exception
    //   100	109	984	finally
    //   112	119	984	finally
    //   122	138	984	finally
    //   141	155	984	finally
    //   158	163	984	finally
    //   166	183	984	finally
    //   1003	1012	984	finally
    //   1014	1023	984	finally
    //   1025	1036	984	finally
    //   1038	1050	984	finally
    //   100	109	993	java/lang/Exception
    //   112	119	993	java/lang/Exception
    //   122	138	993	java/lang/Exception
    //   141	155	993	java/lang/Exception
    //   158	163	993	java/lang/Exception
    //   166	183	993	java/lang/Exception
  }
  
  public static String b(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    return a(paramString1, paramString2, paramString3, paramString4, null, null, false);
  }
  
  public static String b(JSONObject paramJSONObject, String paramString1, String paramString2, String paramString3)
  {
    return a(paramJSONObject.toString(), paramString1, paramString2, paramString3, null, null, true);
  }
  
  /* Error */
  public static final String c(TeamWorkFileImportInfo paramTeamWorkFileImportInfo, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 366	com/tencent/mobileqq/teamwork/bean/TeamWorkFileImportInfo:d	Ljava/lang/String;
    //   4: invokestatic 35	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: istore_3
    //   8: aconst_null
    //   9: astore 7
    //   11: iload_3
    //   12: ifne +1382 -> 1394
    //   15: aload_1
    //   16: invokestatic 35	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   19: ifeq +6 -> 25
    //   22: goto +1372 -> 1394
    //   25: new 57	java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   32: astore 4
    //   34: new 324	java/io/File
    //   37: dup
    //   38: aload_0
    //   39: getfield 366	com/tencent/mobileqq/teamwork/bean/TeamWorkFileImportInfo:d	Ljava/lang/String;
    //   42: invokespecial 325	java/io/File:<init>	(Ljava/lang/String;)V
    //   45: astore 8
    //   47: aload_0
    //   48: getfield 657	com/tencent/mobileqq/teamwork/bean/TeamWorkFileImportInfo:v	Ljava/lang/String;
    //   51: astore 5
    //   53: aload 8
    //   55: invokevirtual 369	java/io/File:exists	()Z
    //   58: ifeq +1325 -> 1383
    //   61: aload 4
    //   63: ldc_w 373
    //   66: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: pop
    //   70: aload 4
    //   72: aload_1
    //   73: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: pop
    //   77: aload 4
    //   79: getstatic 738	com/tencent/mobileqq/teamwork/TeamWorkConstants:o	Ljava/lang/String;
    //   82: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: pop
    //   86: aload 5
    //   88: invokestatic 35	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   91: ifne +20 -> 111
    //   94: aload 4
    //   96: ldc_w 659
    //   99: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: pop
    //   103: aload 4
    //   105: aload 5
    //   107: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: pop
    //   111: aload 4
    //   113: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   116: astore 9
    //   118: new 67	com/tencent/mobileqq/teamwork/CustomX509TrustManager
    //   121: dup
    //   122: invokespecial 68	com/tencent/mobileqq/teamwork/CustomX509TrustManager:<init>	()V
    //   125: astore 4
    //   127: ldc 70
    //   129: invokestatic 76	javax/net/ssl/SSLContext:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    //   132: astore 5
    //   134: aload 5
    //   136: aconst_null
    //   137: iconst_1
    //   138: anewarray 78	javax/net/ssl/TrustManager
    //   141: dup
    //   142: iconst_0
    //   143: aload 4
    //   145: aastore
    //   146: aconst_null
    //   147: invokevirtual 82	javax/net/ssl/SSLContext:init	([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Ljava/security/SecureRandom;)V
    //   150: new 84	com/tencent/mobileqq/teamwork/NoSSLv3SocketFactory
    //   153: dup
    //   154: aload 5
    //   156: invokevirtual 88	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   159: invokespecial 91	com/tencent/mobileqq/teamwork/NoSSLv3SocketFactory:<init>	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   162: astore 5
    //   164: aload 5
    //   166: invokestatic 96	javax/net/ssl/HttpsURLConnection:setDefaultSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   169: new 98	java/net/URL
    //   172: dup
    //   173: aload 9
    //   175: invokespecial 101	java/net/URL:<init>	(Ljava/lang/String;)V
    //   178: invokevirtual 105	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   181: checkcast 93	javax/net/ssl/HttpsURLConnection
    //   184: astore 4
    //   186: aload 4
    //   188: aload 5
    //   190: invokevirtual 108	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   193: aload 4
    //   195: sipush 5000
    //   198: invokevirtual 112	javax/net/ssl/HttpsURLConnection:setConnectTimeout	(I)V
    //   201: aload 4
    //   203: sipush 30000
    //   206: invokevirtual 115	javax/net/ssl/HttpsURLConnection:setReadTimeout	(I)V
    //   209: aload 4
    //   211: iconst_1
    //   212: invokevirtual 415	javax/net/ssl/HttpsURLConnection:setDoOutput	(Z)V
    //   215: aload 4
    //   217: iconst_1
    //   218: invokevirtual 119	javax/net/ssl/HttpsURLConnection:setDoInput	(Z)V
    //   221: aload 4
    //   223: iconst_0
    //   224: invokevirtual 122	javax/net/ssl/HttpsURLConnection:setUseCaches	(Z)V
    //   227: aload 4
    //   229: ldc_w 417
    //   232: invokevirtual 127	javax/net/ssl/HttpsURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   235: aload 4
    //   237: ldc 129
    //   239: ldc 131
    //   241: invokevirtual 135	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   244: new 57	java/lang/StringBuilder
    //   247: dup
    //   248: ldc 137
    //   250: invokespecial 138	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   253: astore 5
    //   255: aload 5
    //   257: ldc 140
    //   259: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: pop
    //   263: aload 5
    //   265: getstatic 146	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   268: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: pop
    //   272: aload 5
    //   274: ldc 140
    //   276: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: pop
    //   280: aload 5
    //   282: getstatic 151	android/os/Build:DEVICE	Ljava/lang/String;
    //   285: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: pop
    //   289: aload 5
    //   291: ldc 140
    //   293: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: pop
    //   297: aload 5
    //   299: getstatic 154	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   302: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: pop
    //   306: aload 5
    //   308: ldc 140
    //   310: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: pop
    //   314: aload 5
    //   316: ldc 156
    //   318: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: pop
    //   322: aload 5
    //   324: ldc 140
    //   326: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: pop
    //   330: aload 5
    //   332: ldc 158
    //   334: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: pop
    //   338: aload 5
    //   340: ldc 160
    //   342: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: pop
    //   346: aload 4
    //   348: ldc 162
    //   350: aload 5
    //   352: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   355: invokevirtual 135	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   358: aload 4
    //   360: ldc 164
    //   362: ldc 166
    //   364: invokevirtual 135	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   367: new 57	java/lang/StringBuilder
    //   370: dup
    //   371: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   374: astore 5
    //   376: aload 5
    //   378: ldc 168
    //   380: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   383: pop
    //   384: aload 5
    //   386: ldc 170
    //   388: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   391: pop
    //   392: aload 4
    //   394: ldc 172
    //   396: aload 5
    //   398: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   401: invokevirtual 135	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   404: new 174	java/util/HashMap
    //   407: dup
    //   408: invokespecial 175	java/util/HashMap:<init>	()V
    //   411: astore 10
    //   413: aload 10
    //   415: ldc 129
    //   417: ldc 177
    //   419: invokeinterface 183 3 0
    //   424: pop
    //   425: aload 10
    //   427: ldc 185
    //   429: aload 9
    //   431: invokeinterface 183 3 0
    //   436: pop
    //   437: getstatic 423	mqq/app/MobileQQ:sMobileQQ	Lmqq/app/MobileQQ;
    //   440: aconst_null
    //   441: invokevirtual 427	mqq/app/MobileQQ:waitAppRuntime	(Lmqq/app/BaseActivity;)Lmqq/app/AppRuntime;
    //   444: iconst_2
    //   445: invokevirtual 430	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   448: checkcast 191	mqq/manager/TicketManager
    //   451: astore 6
    //   453: aload 6
    //   455: aload_1
    //   456: invokeinterface 195 2 0
    //   461: astore 11
    //   463: aload 9
    //   465: invokestatic 35	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   468: istore_3
    //   469: iload_3
    //   470: ifne +29 -> 499
    //   473: aload 7
    //   475: astore 5
    //   477: aload 6
    //   479: aload_1
    //   480: ldc 197
    //   482: invokeinterface 201 3 0
    //   487: astore 6
    //   489: goto +13 -> 502
    //   492: astore_1
    //   493: aload 4
    //   495: astore_0
    //   496: goto +780 -> 1276
    //   499: aconst_null
    //   500: astore 6
    //   502: aload 8
    //   504: invokevirtual 369	java/io/File:exists	()Z
    //   507: istore_3
    //   508: iload_3
    //   509: ifeq +18 -> 527
    //   512: aload 7
    //   514: astore 5
    //   516: aload_0
    //   517: getfield 366	com/tencent/mobileqq/teamwork/bean/TeamWorkFileImportInfo:d	Ljava/lang/String;
    //   520: invokestatic 371	com/tencent/mobileqq/teamwork/TeamWorkHttpUtils:a	(Ljava/lang/String;)Ljava/lang/String;
    //   523: astore_0
    //   524: goto +5 -> 529
    //   527: aconst_null
    //   528: astore_0
    //   529: aload 6
    //   531: invokestatic 35	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   534: istore_3
    //   535: iload_3
    //   536: ifeq +51 -> 587
    //   539: aload 7
    //   541: astore 5
    //   543: ldc 203
    //   545: iconst_1
    //   546: ldc_w 432
    //   549: invokestatic 211	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   552: aload 7
    //   554: astore 5
    //   556: invokestatic 216	com/tencent/smtt/sdk/CookieManager:getInstance	()Lcom/tencent/smtt/sdk/CookieManager;
    //   559: astore_0
    //   560: aload_0
    //   561: ifnull +151 -> 712
    //   564: aload 7
    //   566: astore 5
    //   568: aload 10
    //   570: ldc 225
    //   572: aload_0
    //   573: aload 9
    //   575: invokevirtual 221	com/tencent/smtt/sdk/CookieManager:getCookie	(Ljava/lang/String;)Ljava/lang/String;
    //   578: invokeinterface 183 3 0
    //   583: pop
    //   584: goto +128 -> 712
    //   587: new 57	java/lang/StringBuilder
    //   590: dup
    //   591: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   594: astore 5
    //   596: aload 5
    //   598: ldc_w 434
    //   601: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   604: pop
    //   605: aload 5
    //   607: aload 6
    //   609: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   612: pop
    //   613: aload 5
    //   615: ldc_w 436
    //   618: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   621: pop
    //   622: aload 5
    //   624: aload_1
    //   625: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   628: pop
    //   629: aload 5
    //   631: ldc_w 438
    //   634: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   637: pop
    //   638: aload 5
    //   640: aload 11
    //   642: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   645: pop
    //   646: new 57	java/lang/StringBuilder
    //   649: dup
    //   650: aload 5
    //   652: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   655: invokespecial 138	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   658: astore_1
    //   659: aload_0
    //   660: ifnull +38 -> 698
    //   663: new 57	java/lang/StringBuilder
    //   666: dup
    //   667: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   670: astore 5
    //   672: aload 5
    //   674: ldc_w 440
    //   677: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   680: pop
    //   681: aload 5
    //   683: aload_0
    //   684: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   687: pop
    //   688: aload_1
    //   689: aload 5
    //   691: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   694: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   697: pop
    //   698: aload 10
    //   700: ldc 225
    //   702: aload_1
    //   703: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   706: invokeinterface 183 3 0
    //   711: pop
    //   712: aload 10
    //   714: invokeinterface 229 1 0
    //   719: invokeinterface 235 1 0
    //   724: astore_0
    //   725: aload_0
    //   726: invokeinterface 240 1 0
    //   731: ifeq +39 -> 770
    //   734: aload_0
    //   735: invokeinterface 244 1 0
    //   740: checkcast 246	java/util/Map$Entry
    //   743: astore_1
    //   744: aload 4
    //   746: aload_1
    //   747: invokeinterface 249 1 0
    //   752: checkcast 251	java/lang/String
    //   755: aload_1
    //   756: invokeinterface 254 1 0
    //   761: checkcast 251	java/lang/String
    //   764: invokevirtual 135	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   767: goto -42 -> 725
    //   770: new 442	java/io/DataOutputStream
    //   773: dup
    //   774: aload 4
    //   776: invokevirtual 446	javax/net/ssl/HttpsURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   779: invokespecial 449	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   782: astore_0
    //   783: new 451	java/lang/StringBuffer
    //   786: dup
    //   787: invokespecial 452	java/lang/StringBuffer:<init>	()V
    //   790: astore_1
    //   791: aload_1
    //   792: ldc_w 454
    //   795: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   798: pop
    //   799: aload_1
    //   800: ldc_w 459
    //   803: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   806: pop
    //   807: aload_1
    //   808: ldc 170
    //   810: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   813: pop
    //   814: aload_1
    //   815: ldc_w 454
    //   818: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   821: pop
    //   822: aload_1
    //   823: ldc_w 461
    //   826: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   829: pop
    //   830: aload_1
    //   831: ldc_w 463
    //   834: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   837: pop
    //   838: aload_1
    //   839: ldc_w 465
    //   842: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   845: pop
    //   846: aload_1
    //   847: aload 8
    //   849: invokevirtual 382	java/io/File:getName	()Ljava/lang/String;
    //   852: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   855: pop
    //   856: aload_1
    //   857: ldc_w 740
    //   860: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   863: pop
    //   864: new 57	java/lang/StringBuilder
    //   867: dup
    //   868: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   871: astore 5
    //   873: aload 5
    //   875: ldc_w 469
    //   878: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   881: pop
    //   882: aload 5
    //   884: ldc_w 471
    //   887: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   890: pop
    //   891: aload 5
    //   893: ldc_w 473
    //   896: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   899: pop
    //   900: aload_1
    //   901: aload 5
    //   903: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   906: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   909: pop
    //   910: aload_0
    //   911: aload_1
    //   912: invokevirtual 474	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   915: invokevirtual 477	java/lang/String:getBytes	()[B
    //   918: invokevirtual 480	java/io/OutputStream:write	([B)V
    //   921: new 482	java/io/BufferedInputStream
    //   924: dup
    //   925: new 482	java/io/BufferedInputStream
    //   928: dup
    //   929: new 484	java/io/FileInputStream
    //   932: dup
    //   933: aload 8
    //   935: invokespecial 485	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   938: invokespecial 488	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   941: invokespecial 488	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   944: astore_1
    //   945: sipush 3072
    //   948: newarray byte
    //   950: astore 5
    //   952: aload_1
    //   953: aload 5
    //   955: invokevirtual 489	java/io/BufferedInputStream:read	([B)I
    //   958: istore_2
    //   959: iload_2
    //   960: iconst_m1
    //   961: if_icmpeq +14 -> 975
    //   964: aload_0
    //   965: aload 5
    //   967: iconst_0
    //   968: iload_2
    //   969: invokevirtual 490	java/io/OutputStream:write	([BII)V
    //   972: goto -20 -> 952
    //   975: aload_1
    //   976: invokevirtual 491	java/io/BufferedInputStream:close	()V
    //   979: new 57	java/lang/StringBuilder
    //   982: dup
    //   983: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   986: astore_1
    //   987: aload_1
    //   988: ldc_w 493
    //   991: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   994: pop
    //   995: aload_1
    //   996: ldc 170
    //   998: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1001: pop
    //   1002: aload_1
    //   1003: ldc_w 495
    //   1006: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1009: pop
    //   1010: aload_0
    //   1011: aload_1
    //   1012: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1015: invokevirtual 477	java/lang/String:getBytes	()[B
    //   1018: invokevirtual 480	java/io/OutputStream:write	([B)V
    //   1021: aload_0
    //   1022: invokevirtual 498	java/io/OutputStream:flush	()V
    //   1025: aload_0
    //   1026: invokevirtual 499	java/io/OutputStream:close	()V
    //   1029: new 451	java/lang/StringBuffer
    //   1032: dup
    //   1033: invokespecial 452	java/lang/StringBuffer:<init>	()V
    //   1036: astore_0
    //   1037: aload 4
    //   1039: invokevirtual 515	javax/net/ssl/HttpsURLConnection:getResponseCode	()I
    //   1042: istore_2
    //   1043: iload_2
    //   1044: sipush 200
    //   1047: if_icmpeq +43 -> 1090
    //   1050: new 57	java/lang/StringBuilder
    //   1053: dup
    //   1054: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   1057: astore_1
    //   1058: aload_1
    //   1059: ldc_w 517
    //   1062: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1065: pop
    //   1066: aload_1
    //   1067: iload_2
    //   1068: invokevirtual 407	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1071: pop
    //   1072: aload_1
    //   1073: ldc_w 519
    //   1076: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1079: pop
    //   1080: ldc 203
    //   1082: iconst_1
    //   1083: aload_1
    //   1084: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1087: invokestatic 522	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1090: new 524	java/io/BufferedReader
    //   1093: dup
    //   1094: new 526	java/io/InputStreamReader
    //   1097: dup
    //   1098: aload 4
    //   1100: invokevirtual 277	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   1103: invokespecial 527	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   1106: invokespecial 530	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   1109: astore_1
    //   1110: aload_1
    //   1111: invokevirtual 533	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   1114: astore 5
    //   1116: aload 5
    //   1118: ifnull +21 -> 1139
    //   1121: aload_0
    //   1122: aload 5
    //   1124: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1127: pop
    //   1128: aload_0
    //   1129: ldc_w 535
    //   1132: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1135: pop
    //   1136: goto -26 -> 1110
    //   1139: aload_0
    //   1140: invokevirtual 474	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   1143: astore_0
    //   1144: aload_0
    //   1145: astore 5
    //   1147: aload_1
    //   1148: invokevirtual 536	java/io/BufferedReader:close	()V
    //   1151: aload 4
    //   1153: ifnull +8 -> 1161
    //   1156: aload 4
    //   1158: invokevirtual 350	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   1161: aload_0
    //   1162: areturn
    //   1163: astore_0
    //   1164: goto +82 -> 1246
    //   1167: new 57	java/lang/StringBuilder
    //   1170: dup
    //   1171: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   1174: astore 5
    //   1176: aload 5
    //   1178: ldc_w 501
    //   1181: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1184: pop
    //   1185: aload 5
    //   1187: aload 8
    //   1189: invokevirtual 504	java/io/File:length	()J
    //   1192: invokevirtual 507	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1195: pop
    //   1196: aload 5
    //   1198: ldc_w 509
    //   1201: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1204: pop
    //   1205: aload 5
    //   1207: aload 8
    //   1209: invokevirtual 512	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1212: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1215: pop
    //   1216: ldc 203
    //   1218: iconst_1
    //   1219: aload 5
    //   1221: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1224: invokestatic 211	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1227: aload_0
    //   1228: invokevirtual 498	java/io/OutputStream:flush	()V
    //   1231: aload_0
    //   1232: invokevirtual 499	java/io/OutputStream:close	()V
    //   1235: aload 4
    //   1237: invokevirtual 350	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   1240: aload_1
    //   1241: invokevirtual 491	java/io/BufferedInputStream:close	()V
    //   1244: aconst_null
    //   1245: areturn
    //   1246: aload_1
    //   1247: invokevirtual 491	java/io/BufferedInputStream:close	()V
    //   1250: aload_0
    //   1251: athrow
    //   1252: astore_0
    //   1253: goto +80 -> 1333
    //   1256: astore_1
    //   1257: aload 4
    //   1259: astore_0
    //   1260: goto +13 -> 1273
    //   1263: astore_0
    //   1264: aconst_null
    //   1265: astore 4
    //   1267: goto +66 -> 1333
    //   1270: astore_1
    //   1271: aconst_null
    //   1272: astore_0
    //   1273: aconst_null
    //   1274: astore 5
    //   1276: new 57	java/lang/StringBuilder
    //   1279: dup
    //   1280: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   1283: astore 4
    //   1285: aload 4
    //   1287: ldc_w 538
    //   1290: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1293: pop
    //   1294: aload 4
    //   1296: aload_1
    //   1297: invokevirtual 346	java/lang/Exception:toString	()Ljava/lang/String;
    //   1300: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1303: pop
    //   1304: ldc_w 339
    //   1307: iconst_1
    //   1308: aload 4
    //   1310: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1313: invokestatic 342	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1316: aload_0
    //   1317: ifnull +7 -> 1324
    //   1320: aload_0
    //   1321: invokevirtual 350	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   1324: aload 5
    //   1326: areturn
    //   1327: astore_1
    //   1328: aload_0
    //   1329: astore 4
    //   1331: aload_1
    //   1332: astore_0
    //   1333: aload 4
    //   1335: ifnull +8 -> 1343
    //   1338: aload 4
    //   1340: invokevirtual 350	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   1343: aload_0
    //   1344: athrow
    //   1345: astore_0
    //   1346: new 57	java/lang/StringBuilder
    //   1349: dup
    //   1350: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   1353: astore_1
    //   1354: aload_1
    //   1355: ldc_w 540
    //   1358: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1361: pop
    //   1362: aload_1
    //   1363: aload_0
    //   1364: invokevirtual 346	java/lang/Exception:toString	()Ljava/lang/String;
    //   1367: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1370: pop
    //   1371: ldc 203
    //   1373: iconst_1
    //   1374: aload_1
    //   1375: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1378: invokestatic 211	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1381: aconst_null
    //   1382: areturn
    //   1383: ldc 203
    //   1385: iconst_1
    //   1386: ldc_w 542
    //   1389: invokestatic 211	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1392: aconst_null
    //   1393: areturn
    //   1394: ldc 203
    //   1396: iconst_1
    //   1397: ldc_w 742
    //   1400: invokestatic 211	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1403: aconst_null
    //   1404: areturn
    //   1405: astore 5
    //   1407: goto -240 -> 1167
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1410	0	paramTeamWorkFileImportInfo	TeamWorkFileImportInfo
    //   0	1410	1	paramString	String
    //   958	110	2	i	int
    //   7	529	3	bool	boolean
    //   32	1307	4	localObject1	Object
    //   51	1274	5	localObject2	Object
    //   1405	1	5	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   451	157	6	localObject3	Object
    //   9	556	7	localObject4	Object
    //   45	1163	8	localFile	java.io.File
    //   116	458	9	str1	String
    //   411	302	10	localHashMap	java.util.HashMap
    //   461	180	11	str2	String
    // Exception table:
    //   from	to	target	type
    //   477	489	492	java/lang/Exception
    //   516	524	492	java/lang/Exception
    //   543	552	492	java/lang/Exception
    //   556	560	492	java/lang/Exception
    //   568	584	492	java/lang/Exception
    //   1147	1151	492	java/lang/Exception
    //   952	959	1163	finally
    //   964	972	1163	finally
    //   1167	1240	1163	finally
    //   186	469	1252	finally
    //   477	489	1252	finally
    //   502	508	1252	finally
    //   516	524	1252	finally
    //   529	535	1252	finally
    //   543	552	1252	finally
    //   556	560	1252	finally
    //   568	584	1252	finally
    //   587	659	1252	finally
    //   663	698	1252	finally
    //   698	712	1252	finally
    //   712	725	1252	finally
    //   725	767	1252	finally
    //   770	952	1252	finally
    //   975	1043	1252	finally
    //   1050	1090	1252	finally
    //   1090	1110	1252	finally
    //   1110	1116	1252	finally
    //   1121	1136	1252	finally
    //   1139	1144	1252	finally
    //   1147	1151	1252	finally
    //   1246	1252	1252	finally
    //   186	469	1256	java/lang/Exception
    //   502	508	1256	java/lang/Exception
    //   529	535	1256	java/lang/Exception
    //   587	659	1256	java/lang/Exception
    //   663	698	1256	java/lang/Exception
    //   698	712	1256	java/lang/Exception
    //   712	725	1256	java/lang/Exception
    //   725	767	1256	java/lang/Exception
    //   770	952	1256	java/lang/Exception
    //   975	1043	1256	java/lang/Exception
    //   1050	1090	1256	java/lang/Exception
    //   1090	1110	1256	java/lang/Exception
    //   1110	1116	1256	java/lang/Exception
    //   1121	1136	1256	java/lang/Exception
    //   1139	1144	1256	java/lang/Exception
    //   1246	1252	1256	java/lang/Exception
    //   118	186	1263	finally
    //   1240	1244	1263	finally
    //   118	186	1270	java/lang/Exception
    //   1240	1244	1270	java/lang/Exception
    //   1276	1316	1327	finally
    //   61	111	1345	java/lang/Exception
    //   952	959	1405	java/lang/OutOfMemoryError
    //   964	972	1405	java/lang/OutOfMemoryError
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkHttpUtils
 * JD-Core Version:    0.7.0.1
 */