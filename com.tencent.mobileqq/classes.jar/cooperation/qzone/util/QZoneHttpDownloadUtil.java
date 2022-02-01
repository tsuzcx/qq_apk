package cooperation.qzone.util;

import android.net.NetworkInfo;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.http.Header;

public class QZoneHttpDownloadUtil
  extends HttpDownloadUtil
{
  public static final int DOWNLOAD_MD5_FAILED = -999;
  private static final String FILE_EXT_JPG_LONG = "jpeg";
  private static final String FILE_EXT_JPG_SHORT = "jpg";
  private static final String FILE_EXT_PNG = "png";
  private static final String MIME_TYPE_JPEG = "image/jpeg";
  private static final String MIME_TYPE_PNG = "image/png";
  private static final String MIME_TYPE_SHARPP = "image/sharpp";
  private static final int PHOTO_DECODE_QUALITY = QzoneConfig.getInstance().getConfig("QZoneSetting", "QzoneOfflineDecodePhotoQuality", 90);
  public static final String TAG = "QZoneHttpDownloadUtil";
  
  private static String byteArrayToHex(byte[] paramArrayOfByte)
  {
    char[] arrayOfChar1 = new char[16];
    char[] tmp8_6 = arrayOfChar1;
    tmp8_6[0] = 48;
    char[] tmp13_8 = tmp8_6;
    tmp13_8[1] = 49;
    char[] tmp18_13 = tmp13_8;
    tmp18_13[2] = 50;
    char[] tmp23_18 = tmp18_13;
    tmp23_18[3] = 51;
    char[] tmp28_23 = tmp23_18;
    tmp28_23[4] = 52;
    char[] tmp33_28 = tmp28_23;
    tmp33_28[5] = 53;
    char[] tmp38_33 = tmp33_28;
    tmp38_33[6] = 54;
    char[] tmp44_38 = tmp38_33;
    tmp44_38[7] = 55;
    char[] tmp50_44 = tmp44_38;
    tmp50_44[8] = 56;
    char[] tmp56_50 = tmp50_44;
    tmp56_50[9] = 57;
    char[] tmp62_56 = tmp56_50;
    tmp62_56[10] = 65;
    char[] tmp68_62 = tmp62_56;
    tmp68_62[11] = 66;
    char[] tmp74_68 = tmp68_62;
    tmp74_68[12] = 67;
    char[] tmp80_74 = tmp74_68;
    tmp80_74[13] = 68;
    char[] tmp86_80 = tmp80_74;
    tmp86_80[14] = 69;
    char[] tmp92_86 = tmp86_80;
    tmp92_86[15] = 70;
    tmp92_86;
    char[] arrayOfChar2 = new char[paramArrayOfByte.length * 2];
    int k = paramArrayOfByte.length;
    int i = 0;
    int j = 0;
    while (i < k)
    {
      int m = paramArrayOfByte[i];
      int n = j + 1;
      arrayOfChar2[j] = arrayOfChar1[(m >>> 4 & 0xF)];
      j = n + 1;
      arrayOfChar2[n] = arrayOfChar1[(m & 0xF)];
      i += 1;
    }
    return new String(arrayOfChar2);
  }
  
  /* Error */
  private static int download(AppInterface paramAppInterface, URL paramURL, File paramFile, NetworkInfo paramNetworkInfo, int paramInt1, String paramString, int paramInt2)
  {
    // Byte code:
    //   0: aload_2
    //   1: astore 22
    //   3: invokestatic 95	java/lang/System:currentTimeMillis	()J
    //   6: lstore 15
    //   8: new 97	java/lang/Object
    //   11: dup
    //   12: invokespecial 98	java/lang/Object:<init>	()V
    //   15: astore 33
    //   17: aload 22
    //   19: ifnonnull +13 -> 32
    //   22: ldc 30
    //   24: iconst_1
    //   25: ldc 100
    //   27: invokestatic 106	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   30: iconst_4
    //   31: ireturn
    //   32: iload 4
    //   34: ifge +9 -> 43
    //   37: iconst_2
    //   38: istore 4
    //   40: goto +3 -> 43
    //   43: aload_2
    //   44: invokevirtual 112	java/io/File:getParentFile	()Ljava/io/File;
    //   47: astore_0
    //   48: aload_0
    //   49: ifnull +15 -> 64
    //   52: aload_0
    //   53: invokevirtual 116	java/io/File:exists	()Z
    //   56: ifne +8 -> 64
    //   59: aload_0
    //   60: invokevirtual 119	java/io/File:mkdirs	()Z
    //   63: pop
    //   64: aload_1
    //   65: invokevirtual 125	java/net/URL:toString	()Ljava/lang/String;
    //   68: astore 32
    //   70: aload 32
    //   72: ldc 127
    //   74: invokestatic 131	cooperation/qzone/util/QZoneHttpDownloadUtil:getValueByName	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   77: astore 34
    //   79: new 133	org/apache/http/client/methods/HttpGet
    //   82: dup
    //   83: aload 32
    //   85: invokespecial 136	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   88: astore_0
    //   89: goto +16 -> 105
    //   92: new 133	org/apache/http/client/methods/HttpGet
    //   95: dup
    //   96: aload 32
    //   98: invokestatic 140	cooperation/qzone/util/QZoneHttpDownloadUtil:getEscapeSequence	(Ljava/lang/String;)Ljava/lang/String;
    //   101: invokespecial 136	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   104: astore_0
    //   105: new 142	org/apache/http/params/BasicHttpParams
    //   108: dup
    //   109: invokespecial 143	org/apache/http/params/BasicHttpParams:<init>	()V
    //   112: astore 30
    //   114: sipush 20000
    //   117: istore 8
    //   119: aload_3
    //   120: ifnull +121 -> 241
    //   123: invokestatic 148	android/net/Proxy:getDefaultHost	()Ljava/lang/String;
    //   126: astore 23
    //   128: invokestatic 152	android/net/Proxy:getDefaultPort	()I
    //   131: istore 7
    //   133: aload_3
    //   134: invokevirtual 157	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   137: astore 24
    //   139: aload_3
    //   140: invokestatic 163	com/tencent/mobileqq/utils/NetworkUtil:isMobileNetworkInfo	(Landroid/net/NetworkInfo;)Z
    //   143: ifeq +49 -> 192
    //   146: aload 24
    //   148: ifnull +13 -> 161
    //   151: aload 24
    //   153: ldc 165
    //   155: invokevirtual 169	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   158: ifeq +34 -> 192
    //   161: aload 23
    //   163: ifnull +29 -> 192
    //   166: iload 7
    //   168: ifle +24 -> 192
    //   171: aload 30
    //   173: ldc 171
    //   175: new 173	org/apache/http/HttpHost
    //   178: dup
    //   179: aload 23
    //   181: iload 7
    //   183: invokespecial 176	org/apache/http/HttpHost:<init>	(Ljava/lang/String;I)V
    //   186: invokeinterface 182 3 0
    //   191: pop
    //   192: aload_3
    //   193: invokestatic 163	com/tencent/mobileqq/utils/NetworkUtil:isMobileNetworkInfo	(Landroid/net/NetworkInfo;)Z
    //   196: ifeq +19 -> 215
    //   199: aload 30
    //   201: ldc 184
    //   203: sipush 2048
    //   206: invokeinterface 188 3 0
    //   211: pop
    //   212: goto +29 -> 241
    //   215: sipush 10000
    //   218: istore 8
    //   220: sipush 30000
    //   223: istore 7
    //   225: aload 30
    //   227: ldc 184
    //   229: sipush 4096
    //   232: invokeinterface 188 3 0
    //   237: pop
    //   238: goto +7 -> 245
    //   241: ldc 189
    //   243: istore 7
    //   245: aload 30
    //   247: ldc 191
    //   249: iload 8
    //   251: invokestatic 197	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   254: invokeinterface 182 3 0
    //   259: pop
    //   260: aload 30
    //   262: ldc 199
    //   264: iload 7
    //   266: invokestatic 197	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   269: invokeinterface 182 3 0
    //   274: pop
    //   275: aload_0
    //   276: aload 30
    //   278: invokevirtual 203	org/apache/http/client/methods/HttpGet:setParams	(Lorg/apache/http/params/HttpParams;)V
    //   281: new 205	java/lang/StringBuilder
    //   284: dup
    //   285: invokespecial 206	java/lang/StringBuilder:<init>	()V
    //   288: astore_3
    //   289: aload_3
    //   290: aload_2
    //   291: invokevirtual 209	java/io/File:getPath	()Ljava/lang/String;
    //   294: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: pop
    //   298: aload_3
    //   299: ldc 215
    //   301: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: pop
    //   305: new 108	java/io/File
    //   308: dup
    //   309: aload_3
    //   310: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   313: invokespecial 217	java/io/File:<init>	(Ljava/lang/String;)V
    //   316: astore_3
    //   317: aload 22
    //   319: ifnull +15 -> 334
    //   322: aload_2
    //   323: invokevirtual 116	java/io/File:exists	()Z
    //   326: ifeq +8 -> 334
    //   329: aload_2
    //   330: invokevirtual 220	java/io/File:delete	()Z
    //   333: pop
    //   334: aload_3
    //   335: invokevirtual 116	java/io/File:exists	()Z
    //   338: ifeq +8 -> 346
    //   341: aload_3
    //   342: invokevirtual 220	java/io/File:delete	()Z
    //   345: pop
    //   346: iconst_m1
    //   347: istore 11
    //   349: aconst_null
    //   350: astore 22
    //   352: aconst_null
    //   353: astore 23
    //   355: aload_0
    //   356: astore 29
    //   358: aload_3
    //   359: astore_0
    //   360: aload 5
    //   362: astore_3
    //   363: aload_2
    //   364: astore 26
    //   366: iload 11
    //   368: ifne +38 -> 406
    //   371: aload 30
    //   373: ldc 171
    //   375: new 173	org/apache/http/HttpHost
    //   378: dup
    //   379: aload_1
    //   380: invokevirtual 223	java/net/URL:getHost	()Ljava/lang/String;
    //   383: aload_1
    //   384: invokevirtual 226	java/net/URL:getPort	()I
    //   387: invokespecial 176	org/apache/http/HttpHost:<init>	(Ljava/lang/String;I)V
    //   390: invokeinterface 182 3 0
    //   395: pop
    //   396: aload 29
    //   398: aload 30
    //   400: invokevirtual 203	org/apache/http/client/methods/HttpGet:setParams	(Lorg/apache/http/params/HttpParams;)V
    //   403: goto +3 -> 406
    //   406: iload 4
    //   408: istore 12
    //   410: aload 32
    //   412: iload 6
    //   414: invokestatic 232	cooperation/qzone/webviewplugin/QzoneOfflinePluginJsForQQ:getMimeTypeFromUrl	(Ljava/lang/String;I)Ljava/lang/String;
    //   417: astore 24
    //   419: aload 24
    //   421: ifnull +110 -> 531
    //   424: aload 29
    //   426: ldc 234
    //   428: aload 24
    //   430: invokevirtual 238	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   433: new 205	java/lang/StringBuilder
    //   436: dup
    //   437: invokespecial 206	java/lang/StringBuilder:<init>	()V
    //   440: astore 25
    //   442: aload 25
    //   444: ldc 240
    //   446: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   449: pop
    //   450: aload 25
    //   452: aload 24
    //   454: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   457: pop
    //   458: aload 25
    //   460: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   463: invokestatic 243	cooperation/qzone/webviewplugin/QzoneOfflinePluginJsForQQ:detaillog	(Ljava/lang/String;)V
    //   466: goto +65 -> 531
    //   469: astore_3
    //   470: aload 22
    //   472: astore 24
    //   474: aload 23
    //   476: astore 25
    //   478: aload_0
    //   479: astore 22
    //   481: aload_3
    //   482: astore 23
    //   484: aload 24
    //   486: astore_0
    //   487: aload 25
    //   489: astore_3
    //   490: goto +2522 -> 3012
    //   493: astore_3
    //   494: aload 22
    //   496: astore 24
    //   498: aload 23
    //   500: astore 25
    //   502: aload_0
    //   503: astore 22
    //   505: aload_3
    //   506: astore 23
    //   508: aload 24
    //   510: astore_0
    //   511: aload 25
    //   513: astore_3
    //   514: goto +2887 -> 3401
    //   517: astore_3
    //   518: aload 23
    //   520: astore 24
    //   522: aload_3
    //   523: astore 23
    //   525: aload 24
    //   527: astore_3
    //   528: goto +3283 -> 3811
    //   531: invokestatic 246	cooperation/qzone/webviewplugin/QzoneOfflinePluginJsForQQ:isSupportGZIP	()Z
    //   534: istore 21
    //   536: iload 21
    //   538: ifeq +27 -> 565
    //   541: aload 29
    //   543: ldc 248
    //   545: ldc 250
    //   547: invokevirtual 238	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   550: goto +15 -> 565
    //   553: astore_3
    //   554: goto -84 -> 470
    //   557: astore_3
    //   558: goto -64 -> 494
    //   561: astore_3
    //   562: goto -44 -> 518
    //   565: aload 29
    //   567: ldc 252
    //   569: aload_3
    //   570: invokevirtual 238	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   573: new 205	java/lang/StringBuilder
    //   576: dup
    //   577: invokespecial 206	java/lang/StringBuilder:<init>	()V
    //   580: astore 24
    //   582: aload 24
    //   584: ldc 254
    //   586: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   589: pop
    //   590: aload 24
    //   592: aload_3
    //   593: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   596: pop
    //   597: aload 24
    //   599: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   602: invokestatic 243	cooperation/qzone/webviewplugin/QzoneOfflinePluginJsForQQ:detaillog	(Ljava/lang/String;)V
    //   605: getstatic 258	cooperation/qzone/util/QZoneHttpDownloadUtil:CLIENT	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   608: new 173	org/apache/http/HttpHost
    //   611: dup
    //   612: aload_1
    //   613: invokevirtual 223	java/net/URL:getHost	()Ljava/lang/String;
    //   616: invokespecial 259	org/apache/http/HttpHost:<init>	(Ljava/lang/String;)V
    //   619: aload 29
    //   621: invokevirtual 265	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/HttpHost;Lorg/apache/http/HttpRequest;)Lorg/apache/http/HttpResponse;
    //   624: astore_3
    //   625: aload_3
    //   626: invokeinterface 271 1 0
    //   631: astore 24
    //   633: aload_3
    //   634: invokeinterface 275 1 0
    //   639: astore 35
    //   641: new 277	java/util/HashMap
    //   644: dup
    //   645: invokespecial 278	java/util/HashMap:<init>	()V
    //   648: astore 31
    //   650: aload 24
    //   652: invokeinterface 283 1 0
    //   657: istore 7
    //   659: aload_3
    //   660: invokeinterface 287 1 0
    //   665: astore_3
    //   666: sipush 200
    //   669: iload 7
    //   671: if_icmpne +2135 -> 2806
    //   674: aload_3
    //   675: invokeinterface 292 1 0
    //   680: lstore 17
    //   682: aload_0
    //   683: astore 24
    //   685: new 294	java/io/BufferedOutputStream
    //   688: dup
    //   689: new 296	java/io/FileOutputStream
    //   692: dup
    //   693: aload 26
    //   695: invokespecial 299	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   698: invokespecial 302	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   701: astore 23
    //   703: aload_3
    //   704: aload 23
    //   706: invokeinterface 305 2 0
    //   711: aload 23
    //   713: invokevirtual 310	java/io/OutputStream:flush	()V
    //   716: aload_3
    //   717: astore 25
    //   719: aload 23
    //   721: astore 22
    //   723: aload_2
    //   724: invokevirtual 313	java/io/File:length	()J
    //   727: lstore 13
    //   729: aload 26
    //   731: invokestatic 95	java/lang/System:currentTimeMillis	()J
    //   734: invokevirtual 317	java/io/File:setLastModified	(J)Z
    //   737: pop
    //   738: invokestatic 320	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   741: ifeq +94 -> 835
    //   744: new 205	java/lang/StringBuilder
    //   747: dup
    //   748: invokespecial 206	java/lang/StringBuilder:<init>	()V
    //   751: astore 26
    //   753: aload 26
    //   755: ldc_w 322
    //   758: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   761: pop
    //   762: invokestatic 95	java/lang/System:currentTimeMillis	()J
    //   765: lstore 19
    //   767: aload 26
    //   769: lload 19
    //   771: lload 15
    //   773: lsub
    //   774: invokevirtual 325	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   777: pop
    //   778: aload 26
    //   780: ldc_w 327
    //   783: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   786: pop
    //   787: aload 26
    //   789: lload 13
    //   791: invokevirtual 325	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   794: pop
    //   795: aload 26
    //   797: ldc_w 329
    //   800: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   803: pop
    //   804: aload 26
    //   806: aload_1
    //   807: invokevirtual 332	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   810: pop
    //   811: ldc 30
    //   813: iconst_2
    //   814: aload 26
    //   816: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   819: invokestatic 335	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   822: goto +13 -> 835
    //   825: astore 23
    //   827: goto +203 -> 1030
    //   830: astore 23
    //   832: goto +203 -> 1035
    //   835: aload 34
    //   837: ifnull +185 -> 1022
    //   840: aload 34
    //   842: invokevirtual 337	java/lang/String:length	()I
    //   845: ifeq +177 -> 1022
    //   848: aload_2
    //   849: invokevirtual 340	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   852: ldc 250
    //   854: aload 35
    //   856: ldc_w 342
    //   859: invokestatic 346	cooperation/qzone/util/QZoneHttpDownloadUtil:getHeaderValue	([Lorg/apache/http/Header;Ljava/lang/String;)Ljava/lang/String;
    //   862: invokevirtual 349	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   865: invokestatic 353	cooperation/qzone/util/QZoneHttpDownloadUtil:sourceFileMd5	(Ljava/lang/String;Z)Ljava/lang/String;
    //   868: astore 23
    //   870: aload 23
    //   872: ifnull +150 -> 1022
    //   875: aload 23
    //   877: aload 34
    //   879: invokevirtual 357	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   882: ifne +140 -> 1022
    //   885: new 205	java/lang/StringBuilder
    //   888: dup
    //   889: invokespecial 206	java/lang/StringBuilder:<init>	()V
    //   892: astore 26
    //   894: aload 26
    //   896: ldc_w 359
    //   899: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   902: pop
    //   903: aload 26
    //   905: aload 32
    //   907: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   910: pop
    //   911: aload 26
    //   913: ldc_w 361
    //   916: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   919: pop
    //   920: aload 26
    //   922: aload 23
    //   924: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   927: pop
    //   928: ldc 30
    //   930: iconst_2
    //   931: aload 26
    //   933: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   936: invokestatic 364	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   939: sipush -999
    //   942: istore 4
    //   944: goto +81 -> 1025
    //   947: astore_0
    //   948: iconst_0
    //   949: istore 4
    //   951: aload 22
    //   953: astore 23
    //   955: goto +3496 -> 4451
    //   958: astore_0
    //   959: aload 25
    //   961: astore_3
    //   962: aload 22
    //   964: astore 23
    //   966: iconst_0
    //   967: istore 7
    //   969: aload 24
    //   971: astore 22
    //   973: aload_0
    //   974: astore 25
    //   976: aload 23
    //   978: astore_0
    //   979: goto +2040 -> 3019
    //   982: astore_0
    //   983: aload 25
    //   985: astore_3
    //   986: aload 22
    //   988: astore 23
    //   990: iconst_0
    //   991: istore 7
    //   993: aload 24
    //   995: astore 22
    //   997: aload_0
    //   998: astore 25
    //   1000: aload 23
    //   1002: astore_0
    //   1003: goto +2405 -> 3408
    //   1006: astore 25
    //   1008: iconst_0
    //   1009: istore 4
    //   1011: goto +160 -> 1171
    //   1014: astore 28
    //   1016: iconst_0
    //   1017: istore 4
    //   1019: goto +275 -> 1294
    //   1022: iconst_0
    //   1023: istore 4
    //   1025: goto +503 -> 1528
    //   1028: astore 23
    //   1030: goto +134 -> 1164
    //   1033: astore 23
    //   1035: goto +252 -> 1287
    //   1038: astore_0
    //   1039: goto +22 -> 1061
    //   1042: astore_0
    //   1043: goto +25 -> 1068
    //   1046: astore_0
    //   1047: goto +39 -> 1086
    //   1050: astore 23
    //   1052: goto +109 -> 1161
    //   1055: astore 23
    //   1057: goto +227 -> 1284
    //   1060: astore_0
    //   1061: aload_3
    //   1062: astore 25
    //   1064: goto +1921 -> 2985
    //   1067: astore_0
    //   1068: aload 24
    //   1070: astore 22
    //   1072: aload 23
    //   1074: astore 24
    //   1076: aload_0
    //   1077: astore 23
    //   1079: aload 24
    //   1081: astore_0
    //   1082: goto +1930 -> 3012
    //   1085: astore_0
    //   1086: aload 24
    //   1088: astore 22
    //   1090: aload 23
    //   1092: astore 24
    //   1094: aload_0
    //   1095: astore 23
    //   1097: aload 24
    //   1099: astore_0
    //   1100: goto +2301 -> 3401
    //   1103: astore 24
    //   1105: aload 23
    //   1107: astore 22
    //   1109: aload 24
    //   1111: astore 23
    //   1113: goto +48 -> 1161
    //   1116: astore 24
    //   1118: aload 23
    //   1120: astore 22
    //   1122: aload 24
    //   1124: astore 23
    //   1126: goto +158 -> 1284
    //   1129: astore 23
    //   1131: goto +20 -> 1151
    //   1134: astore 23
    //   1136: goto +20 -> 1156
    //   1139: astore 23
    //   1141: goto +20 -> 1161
    //   1144: astore 23
    //   1146: goto +138 -> 1284
    //   1149: astore 24
    //   1151: goto +1622 -> 2773
    //   1154: astore 24
    //   1156: goto +1632 -> 2788
    //   1159: astore 24
    //   1161: lconst_0
    //   1162: lstore 13
    //   1164: iconst_5
    //   1165: istore 4
    //   1167: aload 23
    //   1169: astore 25
    //   1171: aload_0
    //   1172: astore 23
    //   1174: invokestatic 320	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1177: ifeq +45 -> 1222
    //   1180: iload 4
    //   1182: istore 7
    //   1184: aload 22
    //   1186: astore 24
    //   1188: ldc 30
    //   1190: iconst_2
    //   1191: ldc_w 366
    //   1194: aload 25
    //   1196: invokestatic 369	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1199: goto +23 -> 1222
    //   1202: astore_0
    //   1203: aload 24
    //   1205: astore 22
    //   1207: goto +26 -> 1233
    //   1210: astore_0
    //   1211: goto +30 -> 1241
    //   1214: astore_0
    //   1215: goto +40 -> 1255
    //   1218: astore_0
    //   1219: goto +50 -> 1269
    //   1222: iconst_4
    //   1223: istore 4
    //   1225: goto +303 -> 1528
    //   1228: astore_0
    //   1229: iload 4
    //   1231: istore 7
    //   1233: iload 7
    //   1235: istore 4
    //   1237: goto +1427 -> 2664
    //   1240: astore_0
    //   1241: aload_0
    //   1242: astore 24
    //   1244: aload 23
    //   1246: astore_0
    //   1247: aload 24
    //   1249: astore 23
    //   1251: goto +1432 -> 2683
    //   1254: astore_0
    //   1255: aload_0
    //   1256: astore 24
    //   1258: aload 23
    //   1260: astore_0
    //   1261: aload 24
    //   1263: astore 23
    //   1265: goto +1448 -> 2713
    //   1268: astore_0
    //   1269: aload_0
    //   1270: astore 24
    //   1272: aload 23
    //   1274: astore_0
    //   1275: aload 24
    //   1277: astore 23
    //   1279: goto +1464 -> 2743
    //   1282: astore 24
    //   1284: lconst_0
    //   1285: lstore 13
    //   1287: iconst_5
    //   1288: istore 4
    //   1290: aload 23
    //   1292: astore 28
    //   1294: aload_0
    //   1295: astore 23
    //   1297: iload 4
    //   1299: istore 10
    //   1301: aload 22
    //   1303: astore 27
    //   1305: new 205	java/lang/StringBuilder
    //   1308: dup
    //   1309: invokespecial 206	java/lang/StringBuilder:<init>	()V
    //   1312: astore 36
    //   1314: iload 4
    //   1316: istore 7
    //   1318: aload 22
    //   1320: astore 24
    //   1322: iload 4
    //   1324: istore 8
    //   1326: aload 22
    //   1328: astore 25
    //   1330: iload 4
    //   1332: istore 9
    //   1334: aload 22
    //   1336: astore 26
    //   1338: iload 4
    //   1340: istore 10
    //   1342: aload 22
    //   1344: astore 27
    //   1346: aload 36
    //   1348: ldc_w 371
    //   1351: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1354: pop
    //   1355: iload 4
    //   1357: istore 7
    //   1359: aload 22
    //   1361: astore 24
    //   1363: iload 4
    //   1365: istore 8
    //   1367: aload 22
    //   1369: astore 25
    //   1371: iload 4
    //   1373: istore 9
    //   1375: aload 22
    //   1377: astore 26
    //   1379: iload 4
    //   1381: istore 10
    //   1383: aload 22
    //   1385: astore 27
    //   1387: aload 36
    //   1389: aload_2
    //   1390: invokevirtual 116	java/io/File:exists	()Z
    //   1393: invokevirtual 374	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1396: pop
    //   1397: iload 4
    //   1399: istore 7
    //   1401: aload 22
    //   1403: astore 24
    //   1405: iload 4
    //   1407: istore 8
    //   1409: aload 22
    //   1411: astore 25
    //   1413: iload 4
    //   1415: istore 9
    //   1417: aload 22
    //   1419: astore 26
    //   1421: iload 4
    //   1423: istore 10
    //   1425: aload 22
    //   1427: astore 27
    //   1429: aload 36
    //   1431: ldc_w 376
    //   1434: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1437: pop
    //   1438: iload 4
    //   1440: istore 7
    //   1442: aload 22
    //   1444: astore 24
    //   1446: iload 4
    //   1448: istore 8
    //   1450: aload 22
    //   1452: astore 25
    //   1454: iload 4
    //   1456: istore 9
    //   1458: aload 22
    //   1460: astore 26
    //   1462: iload 4
    //   1464: istore 10
    //   1466: aload 22
    //   1468: astore 27
    //   1470: aload 36
    //   1472: aload_2
    //   1473: invokevirtual 112	java/io/File:getParentFile	()Ljava/io/File;
    //   1476: invokevirtual 116	java/io/File:exists	()Z
    //   1479: invokevirtual 374	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1482: pop
    //   1483: iload 4
    //   1485: istore 7
    //   1487: aload 22
    //   1489: astore 24
    //   1491: iload 4
    //   1493: istore 8
    //   1495: aload 22
    //   1497: astore 25
    //   1499: iload 4
    //   1501: istore 9
    //   1503: aload 22
    //   1505: astore 26
    //   1507: iload 4
    //   1509: istore 10
    //   1511: aload 22
    //   1513: astore 27
    //   1515: ldc 30
    //   1517: iconst_1
    //   1518: aload 36
    //   1520: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1523: aload 28
    //   1525: invokestatic 369	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1528: aload_0
    //   1529: astore 23
    //   1531: aload 31
    //   1533: astore 28
    //   1535: lload 17
    //   1537: lconst_0
    //   1538: lcmp
    //   1539: ifle +384 -> 1923
    //   1542: lload 13
    //   1544: lload 17
    //   1546: lcmp
    //   1547: ifge +376 -> 1923
    //   1550: iload 4
    //   1552: istore 7
    //   1554: aload 22
    //   1556: astore 24
    //   1558: iload 4
    //   1560: istore 8
    //   1562: aload 22
    //   1564: astore 25
    //   1566: iload 4
    //   1568: istore 9
    //   1570: aload 22
    //   1572: astore 26
    //   1574: iload 4
    //   1576: istore 10
    //   1578: aload 22
    //   1580: astore 27
    //   1582: invokestatic 320	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1585: ifeq +331 -> 1916
    //   1588: iload 4
    //   1590: istore 7
    //   1592: aload 22
    //   1594: astore 24
    //   1596: iload 4
    //   1598: istore 8
    //   1600: aload 22
    //   1602: astore 25
    //   1604: iload 4
    //   1606: istore 9
    //   1608: aload 22
    //   1610: astore 26
    //   1612: iload 4
    //   1614: istore 10
    //   1616: aload 22
    //   1618: astore 27
    //   1620: new 205	java/lang/StringBuilder
    //   1623: dup
    //   1624: invokespecial 206	java/lang/StringBuilder:<init>	()V
    //   1627: astore 31
    //   1629: iload 4
    //   1631: istore 7
    //   1633: aload 22
    //   1635: astore 24
    //   1637: iload 4
    //   1639: istore 8
    //   1641: aload 22
    //   1643: astore 25
    //   1645: iload 4
    //   1647: istore 9
    //   1649: aload 22
    //   1651: astore 26
    //   1653: iload 4
    //   1655: istore 10
    //   1657: aload 22
    //   1659: astore 27
    //   1661: aload 31
    //   1663: ldc_w 378
    //   1666: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1669: pop
    //   1670: iload 4
    //   1672: istore 7
    //   1674: aload 22
    //   1676: astore 24
    //   1678: iload 4
    //   1680: istore 8
    //   1682: aload 22
    //   1684: astore 25
    //   1686: iload 4
    //   1688: istore 9
    //   1690: aload 22
    //   1692: astore 26
    //   1694: iload 4
    //   1696: istore 10
    //   1698: aload 22
    //   1700: astore 27
    //   1702: aload 31
    //   1704: lload 17
    //   1706: invokevirtual 325	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1709: pop
    //   1710: iload 4
    //   1712: istore 7
    //   1714: aload 22
    //   1716: astore 24
    //   1718: iload 4
    //   1720: istore 8
    //   1722: aload 22
    //   1724: astore 25
    //   1726: iload 4
    //   1728: istore 9
    //   1730: aload 22
    //   1732: astore 26
    //   1734: iload 4
    //   1736: istore 10
    //   1738: aload 22
    //   1740: astore 27
    //   1742: aload 31
    //   1744: ldc_w 380
    //   1747: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1750: pop
    //   1751: iload 4
    //   1753: istore 7
    //   1755: aload 22
    //   1757: astore 24
    //   1759: iload 4
    //   1761: istore 8
    //   1763: aload 22
    //   1765: astore 25
    //   1767: iload 4
    //   1769: istore 9
    //   1771: aload 22
    //   1773: astore 26
    //   1775: iload 4
    //   1777: istore 10
    //   1779: aload 22
    //   1781: astore 27
    //   1783: aload 31
    //   1785: aload_2
    //   1786: invokevirtual 313	java/io/File:length	()J
    //   1789: invokevirtual 325	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1792: pop
    //   1793: iload 4
    //   1795: istore 7
    //   1797: aload 22
    //   1799: astore 24
    //   1801: iload 4
    //   1803: istore 8
    //   1805: aload 22
    //   1807: astore 25
    //   1809: iload 4
    //   1811: istore 9
    //   1813: aload 22
    //   1815: astore 26
    //   1817: iload 4
    //   1819: istore 10
    //   1821: aload 22
    //   1823: astore 27
    //   1825: aload 31
    //   1827: ldc_w 382
    //   1830: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1833: pop
    //   1834: iload 4
    //   1836: istore 7
    //   1838: aload 22
    //   1840: astore 24
    //   1842: iload 4
    //   1844: istore 8
    //   1846: aload 22
    //   1848: astore 25
    //   1850: iload 4
    //   1852: istore 9
    //   1854: aload 22
    //   1856: astore 26
    //   1858: iload 4
    //   1860: istore 10
    //   1862: aload 22
    //   1864: astore 27
    //   1866: aload 31
    //   1868: aload_1
    //   1869: invokevirtual 332	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1872: pop
    //   1873: iload 4
    //   1875: istore 7
    //   1877: aload 22
    //   1879: astore 24
    //   1881: iload 4
    //   1883: istore 8
    //   1885: aload 22
    //   1887: astore 25
    //   1889: iload 4
    //   1891: istore 9
    //   1893: aload 22
    //   1895: astore 26
    //   1897: iload 4
    //   1899: istore 10
    //   1901: aload 22
    //   1903: astore 27
    //   1905: ldc 30
    //   1907: iconst_2
    //   1908: aload 31
    //   1910: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1913: invokestatic 364	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1916: bipush 8
    //   1918: istore 4
    //   1920: goto +3 -> 1923
    //   1923: iload 4
    //   1925: ifne +553 -> 2478
    //   1928: ldc 26
    //   1930: aload 35
    //   1932: ldc_w 384
    //   1935: invokestatic 346	cooperation/qzone/util/QZoneHttpDownloadUtil:getHeaderValue	([Lorg/apache/http/Header;Ljava/lang/String;)Ljava/lang/String;
    //   1938: invokevirtual 357	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1941: istore 21
    //   1943: iload 21
    //   1945: ifeq +510 -> 2455
    //   1948: invokestatic 390	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1951: invokestatic 396	com/tencent/qqsharpP/QQSharpPUtil:a	(Landroid/content/Context;)Z
    //   1954: ifeq +439 -> 2393
    //   1957: aload 32
    //   1959: invokestatic 399	cooperation/qzone/webviewplugin/QzoneOfflinePluginJsForQQ:getFileExt	(Ljava/lang/String;)Ljava/lang/String;
    //   1962: astore 25
    //   1964: ldc 14
    //   1966: aload 25
    //   1968: invokevirtual 357	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1971: istore 21
    //   1973: iload 21
    //   1975: ifne +46 -> 2021
    //   1978: ldc 11
    //   1980: aload 25
    //   1982: invokevirtual 357	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1985: ifne +36 -> 2021
    //   1988: ldc 17
    //   1990: aload 25
    //   1992: invokevirtual 357	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1995: istore 21
    //   1997: iload 21
    //   1999: ifeq +456 -> 2455
    //   2002: goto +19 -> 2021
    //   2005: astore_0
    //   2006: goto -769 -> 1237
    //   2009: astore_0
    //   2010: goto +434 -> 2444
    //   2013: astore_0
    //   2014: goto +434 -> 2448
    //   2017: astore_0
    //   2018: goto +434 -> 2452
    //   2021: aload_2
    //   2022: invokevirtual 340	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   2025: astore 26
    //   2027: aload_2
    //   2028: invokestatic 402	com/tencent/qqsharpP/QQSharpPUtil:a	(Ljava/io/File;)Ljava/io/File;
    //   2031: astore 27
    //   2033: aload 27
    //   2035: invokevirtual 340	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   2038: invokestatic 408	com/tencent/sharpP/SharpPUtil:decodeSharpPByFilePath	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   2041: astore 31
    //   2043: new 108	java/io/File
    //   2046: dup
    //   2047: aload 26
    //   2049: invokespecial 217	java/io/File:<init>	(Ljava/lang/String;)V
    //   2052: astore 36
    //   2054: aload 31
    //   2056: ifnull +318 -> 2374
    //   2059: ldc 17
    //   2061: aload 25
    //   2063: invokevirtual 357	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2066: istore 21
    //   2068: iload 21
    //   2070: ifeq +10 -> 2080
    //   2073: getstatic 414	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   2076: astore_0
    //   2077: goto +7 -> 2084
    //   2080: getstatic 417	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   2083: astore_0
    //   2084: getstatic 48	cooperation/qzone/util/QZoneHttpDownloadUtil:PHOTO_DECODE_QUALITY	I
    //   2087: istore 9
    //   2089: iload 4
    //   2091: istore 8
    //   2093: aload 22
    //   2095: astore 24
    //   2097: iload 8
    //   2099: istore 7
    //   2101: aload 31
    //   2103: aload 26
    //   2105: aload_0
    //   2106: iload 9
    //   2108: iconst_1
    //   2109: invokestatic 423	cooperation/qzone/util/PhotoUtils:saveBitmapToFile	(Landroid/graphics/Bitmap;Ljava/lang/String;Landroid/graphics/Bitmap$CompressFormat;IZ)Z
    //   2112: ifeq +243 -> 2355
    //   2115: aload 22
    //   2117: astore 24
    //   2119: iload 8
    //   2121: istore 7
    //   2123: aload 27
    //   2125: invokestatic 429	cooperation/qzone/util/FileUtils:deleteFile	(Ljava/io/File;)Z
    //   2128: pop
    //   2129: aload 22
    //   2131: astore 24
    //   2133: iload 8
    //   2135: istore 7
    //   2137: aload 36
    //   2139: invokevirtual 313	java/io/File:length	()J
    //   2142: lstore 13
    //   2144: aload 22
    //   2146: astore 24
    //   2148: iload 8
    //   2150: istore 7
    //   2152: ldc 17
    //   2154: aload 25
    //   2156: invokevirtual 357	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2159: ifeq +2511 -> 4670
    //   2162: ldc 23
    //   2164: astore_0
    //   2165: goto +3 -> 2168
    //   2168: aload 28
    //   2170: astore 25
    //   2172: aload 22
    //   2174: astore 24
    //   2176: iload 8
    //   2178: istore 7
    //   2180: aload 25
    //   2182: ldc_w 384
    //   2185: aload_0
    //   2186: invokevirtual 433	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2189: pop
    //   2190: aload 22
    //   2192: astore 24
    //   2194: iload 8
    //   2196: istore 7
    //   2198: aload 25
    //   2200: ldc_w 435
    //   2203: lload 13
    //   2205: invokestatic 438	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   2208: invokevirtual 433	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2211: pop
    //   2212: aload 22
    //   2214: astore 24
    //   2216: iload 8
    //   2218: istore 7
    //   2220: invokestatic 441	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2223: ifeq +232 -> 2455
    //   2226: aload 22
    //   2228: astore 24
    //   2230: iload 8
    //   2232: istore 7
    //   2234: new 205	java/lang/StringBuilder
    //   2237: dup
    //   2238: invokespecial 206	java/lang/StringBuilder:<init>	()V
    //   2241: astore_0
    //   2242: aload 22
    //   2244: astore 24
    //   2246: iload 8
    //   2248: istore 7
    //   2250: aload_0
    //   2251: ldc_w 443
    //   2254: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2257: pop
    //   2258: aload 22
    //   2260: astore 24
    //   2262: iload 8
    //   2264: istore 7
    //   2266: aload_0
    //   2267: lload 13
    //   2269: invokevirtual 325	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2272: pop
    //   2273: aload 22
    //   2275: astore 24
    //   2277: iload 8
    //   2279: istore 7
    //   2281: aload_0
    //   2282: ldc_w 445
    //   2285: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2288: pop
    //   2289: aload 22
    //   2291: astore 24
    //   2293: iload 8
    //   2295: istore 7
    //   2297: aload_0
    //   2298: aload_1
    //   2299: invokevirtual 332	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2302: pop
    //   2303: aload 22
    //   2305: astore 24
    //   2307: iload 8
    //   2309: istore 7
    //   2311: aload_0
    //   2312: ldc_w 447
    //   2315: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2318: pop
    //   2319: aload 22
    //   2321: astore 24
    //   2323: iload 8
    //   2325: istore 7
    //   2327: aload_0
    //   2328: aload 26
    //   2330: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2333: pop
    //   2334: aload 22
    //   2336: astore 24
    //   2338: iload 8
    //   2340: istore 7
    //   2342: ldc 30
    //   2344: iconst_4
    //   2345: aload_0
    //   2346: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2349: invokestatic 335	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2352: goto +103 -> 2455
    //   2355: aload 22
    //   2357: astore 24
    //   2359: iload 8
    //   2361: istore 7
    //   2363: aload 27
    //   2365: aload 36
    //   2367: invokevirtual 450	java/io/File:renameTo	(Ljava/io/File;)Z
    //   2370: pop
    //   2371: goto +84 -> 2455
    //   2374: iload 4
    //   2376: istore 7
    //   2378: aload 22
    //   2380: astore 24
    //   2382: aload 27
    //   2384: aload 36
    //   2386: invokevirtual 450	java/io/File:renameTo	(Ljava/io/File;)Z
    //   2389: pop
    //   2390: goto +65 -> 2455
    //   2393: iload 4
    //   2395: istore 8
    //   2397: aload 22
    //   2399: astore 24
    //   2401: iload 8
    //   2403: istore 7
    //   2405: invokestatic 441	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2408: ifeq +47 -> 2455
    //   2411: aload 22
    //   2413: astore 24
    //   2415: iload 8
    //   2417: istore 7
    //   2419: ldc 30
    //   2421: iconst_4
    //   2422: ldc_w 452
    //   2425: invokestatic 335	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2428: goto +27 -> 2455
    //   2431: astore_0
    //   2432: goto +12 -> 2444
    //   2435: astore_0
    //   2436: goto +12 -> 2448
    //   2439: astore_0
    //   2440: goto +12 -> 2452
    //   2443: astore_0
    //   2444: goto +131 -> 2575
    //   2447: astore_0
    //   2448: goto +141 -> 2589
    //   2451: astore_0
    //   2452: goto +151 -> 2603
    //   2455: iload 4
    //   2457: istore 7
    //   2459: aload 22
    //   2461: astore 24
    //   2463: aload 35
    //   2465: aload 23
    //   2467: aload 32
    //   2469: aload 28
    //   2471: invokestatic 456	cooperation/qzone/util/QZoneHttpDownloadUtil:saveHeadersToFile	([Lorg/apache/http/Header;Ljava/io/File;Ljava/lang/String;Ljava/util/HashMap;)Z
    //   2474: pop
    //   2475: goto +85 -> 2560
    //   2478: iload 4
    //   2480: istore 8
    //   2482: aload 22
    //   2484: astore 24
    //   2486: iload 8
    //   2488: istore 7
    //   2490: invokestatic 320	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2493: ifeq +67 -> 2560
    //   2496: aload 22
    //   2498: astore 24
    //   2500: iload 8
    //   2502: istore 7
    //   2504: new 205	java/lang/StringBuilder
    //   2507: dup
    //   2508: invokespecial 206	java/lang/StringBuilder:<init>	()V
    //   2511: astore_0
    //   2512: aload 22
    //   2514: astore 24
    //   2516: iload 8
    //   2518: istore 7
    //   2520: aload_0
    //   2521: ldc_w 458
    //   2524: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2527: pop
    //   2528: aload 22
    //   2530: astore 24
    //   2532: iload 8
    //   2534: istore 7
    //   2536: aload_0
    //   2537: aload_1
    //   2538: invokevirtual 332	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2541: pop
    //   2542: aload 22
    //   2544: astore 24
    //   2546: iload 8
    //   2548: istore 7
    //   2550: ldc 30
    //   2552: iconst_2
    //   2553: aload_0
    //   2554: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2557: invokestatic 106	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2560: aload 22
    //   2562: astore_0
    //   2563: aload 23
    //   2565: astore 25
    //   2567: iload 4
    //   2569: istore 7
    //   2571: goto +241 -> 2812
    //   2574: astore_0
    //   2575: aload_0
    //   2576: astore 24
    //   2578: aload 23
    //   2580: astore_0
    //   2581: aload 24
    //   2583: astore 23
    //   2585: goto +98 -> 2683
    //   2588: astore_0
    //   2589: aload_0
    //   2590: astore 24
    //   2592: aload 23
    //   2594: astore_0
    //   2595: aload 24
    //   2597: astore 23
    //   2599: goto +114 -> 2713
    //   2602: astore_0
    //   2603: aload_0
    //   2604: astore 24
    //   2606: aload 23
    //   2608: astore_0
    //   2609: aload 24
    //   2611: astore 23
    //   2613: goto +130 -> 2743
    //   2616: astore 23
    //   2618: iload 7
    //   2620: istore 4
    //   2622: aload 24
    //   2624: astore 22
    //   2626: goto +57 -> 2683
    //   2629: astore 23
    //   2631: iload 8
    //   2633: istore 4
    //   2635: aload 25
    //   2637: astore 22
    //   2639: goto +74 -> 2713
    //   2642: astore 23
    //   2644: iload 9
    //   2646: istore 4
    //   2648: aload 26
    //   2650: astore 22
    //   2652: goto +91 -> 2743
    //   2655: astore_0
    //   2656: iload 10
    //   2658: istore 4
    //   2660: aload 27
    //   2662: astore 22
    //   2664: aload 22
    //   2666: astore 23
    //   2668: aload_3
    //   2669: astore 25
    //   2671: goto +1780 -> 4451
    //   2674: astore 24
    //   2676: aload 23
    //   2678: astore_0
    //   2679: aload 24
    //   2681: astore 23
    //   2683: aload 22
    //   2685: astore 24
    //   2687: aload_0
    //   2688: astore 22
    //   2690: aload 23
    //   2692: astore 25
    //   2694: aload 24
    //   2696: astore_0
    //   2697: iload 4
    //   2699: istore 7
    //   2701: goto +318 -> 3019
    //   2704: astore 24
    //   2706: aload 23
    //   2708: astore_0
    //   2709: aload 24
    //   2711: astore 23
    //   2713: aload 22
    //   2715: astore 24
    //   2717: aload_0
    //   2718: astore 22
    //   2720: aload 23
    //   2722: astore 25
    //   2724: aload 24
    //   2726: astore_0
    //   2727: iload 4
    //   2729: istore 7
    //   2731: goto +677 -> 3408
    //   2734: astore 24
    //   2736: aload 23
    //   2738: astore_0
    //   2739: aload 24
    //   2741: astore 23
    //   2743: aload 22
    //   2745: astore 24
    //   2747: aload_0
    //   2748: astore 22
    //   2750: aload 23
    //   2752: astore 25
    //   2754: aload 24
    //   2756: astore_0
    //   2757: iload 4
    //   2759: istore 7
    //   2761: goto +1067 -> 3828
    //   2764: astore_0
    //   2765: aload_3
    //   2766: astore 25
    //   2768: goto +213 -> 2981
    //   2771: astore 23
    //   2773: aload 22
    //   2775: astore 24
    //   2777: aload_0
    //   2778: astore 22
    //   2780: aload 24
    //   2782: astore_0
    //   2783: goto +229 -> 3012
    //   2786: astore 23
    //   2788: aload 22
    //   2790: astore 24
    //   2792: aload_0
    //   2793: astore 22
    //   2795: aload 24
    //   2797: astore_0
    //   2798: goto +603 -> 3401
    //   2801: astore 23
    //   2803: goto +1008 -> 3811
    //   2806: aload_0
    //   2807: astore 25
    //   2809: aload 22
    //   2811: astore_0
    //   2812: aload_3
    //   2813: ifnull +25 -> 2838
    //   2816: aload_3
    //   2817: invokeinterface 461 1 0
    //   2822: goto +16 -> 2838
    //   2825: astore 22
    //   2827: ldc 30
    //   2829: iconst_1
    //   2830: ldc_w 463
    //   2833: aload 22
    //   2835: invokestatic 465	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2838: ldc_w 467
    //   2841: invokestatic 473	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   2844: checkcast 467	com/tencent/qzonehub/api/IDataUtils
    //   2847: aload_0
    //   2848: invokeinterface 476 2 0
    //   2853: pop
    //   2854: iload 7
    //   2856: ifeq +99 -> 2955
    //   2859: aload_2
    //   2860: ifnull +95 -> 2955
    //   2863: aload_2
    //   2864: invokevirtual 112	java/io/File:getParentFile	()Ljava/io/File;
    //   2867: astore 22
    //   2869: aload 22
    //   2871: ifnull +17 -> 2888
    //   2874: aload 22
    //   2876: invokevirtual 116	java/io/File:exists	()Z
    //   2879: ifne +9 -> 2888
    //   2882: aload 22
    //   2884: invokevirtual 119	java/io/File:mkdirs	()Z
    //   2887: pop
    //   2888: aload_2
    //   2889: invokevirtual 116	java/io/File:exists	()Z
    //   2892: ifeq +63 -> 2955
    //   2895: aload_2
    //   2896: invokevirtual 220	java/io/File:delete	()Z
    //   2899: istore 21
    //   2901: new 205	java/lang/StringBuilder
    //   2904: dup
    //   2905: invokespecial 206	java/lang/StringBuilder:<init>	()V
    //   2908: astore 22
    //   2910: aload 22
    //   2912: ldc_w 478
    //   2915: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2918: pop
    //   2919: aload 22
    //   2921: iload 21
    //   2923: invokevirtual 374	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2926: pop
    //   2927: aload 22
    //   2929: ldc_w 480
    //   2932: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2935: pop
    //   2936: aload 22
    //   2938: aload 32
    //   2940: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2943: pop
    //   2944: ldc 30
    //   2946: iconst_1
    //   2947: aload 22
    //   2949: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2952: invokestatic 106	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2955: aload_0
    //   2956: astore 24
    //   2958: aload_3
    //   2959: astore 23
    //   2961: goto +1265 -> 4226
    //   2964: astore_3
    //   2965: goto +27 -> 2992
    //   2968: astore_3
    //   2969: goto +412 -> 3381
    //   2972: astore_3
    //   2973: goto +828 -> 3801
    //   2976: astore_0
    //   2977: aload 23
    //   2979: astore 25
    //   2981: aload 22
    //   2983: astore 23
    //   2985: iconst_5
    //   2986: istore 4
    //   2988: goto +1463 -> 4451
    //   2991: astore_3
    //   2992: aload_0
    //   2993: astore 24
    //   2995: aload 22
    //   2997: astore_0
    //   2998: aload 23
    //   3000: astore 22
    //   3002: aload_3
    //   3003: astore 23
    //   3005: aload 22
    //   3007: astore_3
    //   3008: aload 24
    //   3010: astore 22
    //   3012: iconst_5
    //   3013: istore 7
    //   3015: aload 23
    //   3017: astore 25
    //   3019: aload_0
    //   3020: astore 23
    //   3022: iload 7
    //   3024: istore 4
    //   3026: aload_3
    //   3027: astore 24
    //   3029: invokestatic 320	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3032: ifeq +81 -> 3113
    //   3035: aload_0
    //   3036: astore 23
    //   3038: iload 7
    //   3040: istore 4
    //   3042: aload_3
    //   3043: astore 24
    //   3045: new 205	java/lang/StringBuilder
    //   3048: dup
    //   3049: invokespecial 206	java/lang/StringBuilder:<init>	()V
    //   3052: astore 26
    //   3054: aload_0
    //   3055: astore 23
    //   3057: iload 7
    //   3059: istore 4
    //   3061: aload_3
    //   3062: astore 24
    //   3064: aload 26
    //   3066: ldc_w 482
    //   3069: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3072: pop
    //   3073: aload_0
    //   3074: astore 23
    //   3076: iload 7
    //   3078: istore 4
    //   3080: aload_3
    //   3081: astore 24
    //   3083: aload 26
    //   3085: aload_1
    //   3086: invokevirtual 332	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3089: pop
    //   3090: aload_0
    //   3091: astore 23
    //   3093: iload 7
    //   3095: istore 4
    //   3097: aload_3
    //   3098: astore 24
    //   3100: ldc 30
    //   3102: iconst_2
    //   3103: aload 26
    //   3105: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3108: aload 25
    //   3110: invokestatic 485	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3113: aload_3
    //   3114: ifnull +25 -> 3139
    //   3117: aload_3
    //   3118: invokeinterface 461 1 0
    //   3123: goto +16 -> 3139
    //   3126: astore 23
    //   3128: ldc 30
    //   3130: iconst_1
    //   3131: ldc_w 463
    //   3134: aload 23
    //   3136: invokestatic 465	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3139: ldc_w 467
    //   3142: invokestatic 473	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   3145: checkcast 467	com/tencent/qzonehub/api/IDataUtils
    //   3148: aload_0
    //   3149: invokeinterface 476 2 0
    //   3154: pop
    //   3155: aload 22
    //   3157: astore 25
    //   3159: aload_0
    //   3160: astore 24
    //   3162: aload_3
    //   3163: astore 23
    //   3165: aload_2
    //   3166: ifnull +628 -> 3794
    //   3169: aload 22
    //   3171: astore 26
    //   3173: aload_0
    //   3174: astore 27
    //   3176: aload_3
    //   3177: astore 28
    //   3179: aload_2
    //   3180: invokevirtual 112	java/io/File:getParentFile	()Ljava/io/File;
    //   3183: astore 23
    //   3185: aload 23
    //   3187: ifnull +37 -> 3224
    //   3190: aload 22
    //   3192: astore 26
    //   3194: aload_0
    //   3195: astore 27
    //   3197: aload_3
    //   3198: astore 28
    //   3200: aload 23
    //   3202: invokevirtual 116	java/io/File:exists	()Z
    //   3205: ifne +19 -> 3224
    //   3208: aload 22
    //   3210: astore 26
    //   3212: aload_0
    //   3213: astore 27
    //   3215: aload_3
    //   3216: astore 28
    //   3218: aload 23
    //   3220: invokevirtual 119	java/io/File:mkdirs	()Z
    //   3223: pop
    //   3224: aload 22
    //   3226: astore 25
    //   3228: aload_0
    //   3229: astore 24
    //   3231: aload_3
    //   3232: astore 23
    //   3234: aload 22
    //   3236: astore 26
    //   3238: aload_0
    //   3239: astore 27
    //   3241: aload_3
    //   3242: astore 28
    //   3244: aload_2
    //   3245: invokevirtual 116	java/io/File:exists	()Z
    //   3248: ifeq +546 -> 3794
    //   3251: aload 22
    //   3253: astore 26
    //   3255: aload_0
    //   3256: astore 27
    //   3258: aload_3
    //   3259: astore 28
    //   3261: aload_2
    //   3262: invokevirtual 220	java/io/File:delete	()Z
    //   3265: istore 21
    //   3267: aload 22
    //   3269: astore 26
    //   3271: aload_0
    //   3272: astore 27
    //   3274: aload_3
    //   3275: astore 28
    //   3277: new 205	java/lang/StringBuilder
    //   3280: dup
    //   3281: invokespecial 206	java/lang/StringBuilder:<init>	()V
    //   3284: astore 23
    //   3286: aload 22
    //   3288: astore 26
    //   3290: aload_0
    //   3291: astore 27
    //   3293: aload_3
    //   3294: astore 28
    //   3296: aload 23
    //   3298: ldc_w 478
    //   3301: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3304: pop
    //   3305: aload 22
    //   3307: astore 26
    //   3309: aload_0
    //   3310: astore 27
    //   3312: aload_3
    //   3313: astore 28
    //   3315: aload 23
    //   3317: iload 21
    //   3319: invokevirtual 374	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3322: pop
    //   3323: aload 22
    //   3325: astore 26
    //   3327: aload_0
    //   3328: astore 27
    //   3330: aload_3
    //   3331: astore 28
    //   3333: aload 23
    //   3335: ldc_w 480
    //   3338: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3341: pop
    //   3342: aload 22
    //   3344: astore 26
    //   3346: aload_0
    //   3347: astore 27
    //   3349: aload_3
    //   3350: astore 28
    //   3352: aload 23
    //   3354: aload 32
    //   3356: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3359: pop
    //   3360: aload 22
    //   3362: astore 26
    //   3364: aload_0
    //   3365: astore 27
    //   3367: aload_3
    //   3368: astore 28
    //   3370: aload 23
    //   3372: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3375: astore 23
    //   3377: goto +389 -> 3766
    //   3380: astore_3
    //   3381: aload_0
    //   3382: astore 24
    //   3384: aload 22
    //   3386: astore_0
    //   3387: aload 23
    //   3389: astore 22
    //   3391: aload_3
    //   3392: astore 23
    //   3394: aload 22
    //   3396: astore_3
    //   3397: aload 24
    //   3399: astore 22
    //   3401: iconst_5
    //   3402: istore 7
    //   3404: aload 23
    //   3406: astore 25
    //   3408: aload_0
    //   3409: astore 23
    //   3411: iload 7
    //   3413: istore 4
    //   3415: aload_3
    //   3416: astore 24
    //   3418: invokestatic 320	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3421: ifeq +81 -> 3502
    //   3424: aload_0
    //   3425: astore 23
    //   3427: iload 7
    //   3429: istore 4
    //   3431: aload_3
    //   3432: astore 24
    //   3434: new 205	java/lang/StringBuilder
    //   3437: dup
    //   3438: invokespecial 206	java/lang/StringBuilder:<init>	()V
    //   3441: astore 26
    //   3443: aload_0
    //   3444: astore 23
    //   3446: iload 7
    //   3448: istore 4
    //   3450: aload_3
    //   3451: astore 24
    //   3453: aload 26
    //   3455: ldc_w 482
    //   3458: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3461: pop
    //   3462: aload_0
    //   3463: astore 23
    //   3465: iload 7
    //   3467: istore 4
    //   3469: aload_3
    //   3470: astore 24
    //   3472: aload 26
    //   3474: aload_1
    //   3475: invokevirtual 332	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3478: pop
    //   3479: aload_0
    //   3480: astore 23
    //   3482: iload 7
    //   3484: istore 4
    //   3486: aload_3
    //   3487: astore 24
    //   3489: ldc 30
    //   3491: iconst_2
    //   3492: aload 26
    //   3494: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3497: aload 25
    //   3499: invokestatic 369	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3502: aload_3
    //   3503: ifnull +25 -> 3528
    //   3506: aload_3
    //   3507: invokeinterface 461 1 0
    //   3512: goto +16 -> 3528
    //   3515: astore 23
    //   3517: ldc 30
    //   3519: iconst_1
    //   3520: ldc_w 463
    //   3523: aload 23
    //   3525: invokestatic 465	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3528: ldc_w 467
    //   3531: invokestatic 473	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   3534: checkcast 467	com/tencent/qzonehub/api/IDataUtils
    //   3537: aload_0
    //   3538: invokeinterface 476 2 0
    //   3543: pop
    //   3544: aload 22
    //   3546: astore 25
    //   3548: aload_0
    //   3549: astore 24
    //   3551: aload_3
    //   3552: astore 23
    //   3554: aload_2
    //   3555: ifnull +239 -> 3794
    //   3558: aload 22
    //   3560: astore 26
    //   3562: aload_0
    //   3563: astore 27
    //   3565: aload_3
    //   3566: astore 28
    //   3568: aload_2
    //   3569: invokevirtual 112	java/io/File:getParentFile	()Ljava/io/File;
    //   3572: astore 23
    //   3574: aload 23
    //   3576: ifnull +37 -> 3613
    //   3579: aload 22
    //   3581: astore 26
    //   3583: aload_0
    //   3584: astore 27
    //   3586: aload_3
    //   3587: astore 28
    //   3589: aload 23
    //   3591: invokevirtual 116	java/io/File:exists	()Z
    //   3594: ifne +19 -> 3613
    //   3597: aload 22
    //   3599: astore 26
    //   3601: aload_0
    //   3602: astore 27
    //   3604: aload_3
    //   3605: astore 28
    //   3607: aload 23
    //   3609: invokevirtual 119	java/io/File:mkdirs	()Z
    //   3612: pop
    //   3613: aload 22
    //   3615: astore 25
    //   3617: aload_0
    //   3618: astore 24
    //   3620: aload_3
    //   3621: astore 23
    //   3623: aload 22
    //   3625: astore 26
    //   3627: aload_0
    //   3628: astore 27
    //   3630: aload_3
    //   3631: astore 28
    //   3633: aload_2
    //   3634: invokevirtual 116	java/io/File:exists	()Z
    //   3637: ifeq +157 -> 3794
    //   3640: aload 22
    //   3642: astore 26
    //   3644: aload_0
    //   3645: astore 27
    //   3647: aload_3
    //   3648: astore 28
    //   3650: aload_2
    //   3651: invokevirtual 220	java/io/File:delete	()Z
    //   3654: istore 21
    //   3656: aload 22
    //   3658: astore 26
    //   3660: aload_0
    //   3661: astore 27
    //   3663: aload_3
    //   3664: astore 28
    //   3666: new 205	java/lang/StringBuilder
    //   3669: dup
    //   3670: invokespecial 206	java/lang/StringBuilder:<init>	()V
    //   3673: astore 23
    //   3675: aload 22
    //   3677: astore 26
    //   3679: aload_0
    //   3680: astore 27
    //   3682: aload_3
    //   3683: astore 28
    //   3685: aload 23
    //   3687: ldc_w 478
    //   3690: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3693: pop
    //   3694: aload 22
    //   3696: astore 26
    //   3698: aload_0
    //   3699: astore 27
    //   3701: aload_3
    //   3702: astore 28
    //   3704: aload 23
    //   3706: iload 21
    //   3708: invokevirtual 374	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3711: pop
    //   3712: aload 22
    //   3714: astore 26
    //   3716: aload_0
    //   3717: astore 27
    //   3719: aload_3
    //   3720: astore 28
    //   3722: aload 23
    //   3724: ldc_w 480
    //   3727: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3730: pop
    //   3731: aload 22
    //   3733: astore 26
    //   3735: aload_0
    //   3736: astore 27
    //   3738: aload_3
    //   3739: astore 28
    //   3741: aload 23
    //   3743: aload 32
    //   3745: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3748: pop
    //   3749: aload 22
    //   3751: astore 26
    //   3753: aload_0
    //   3754: astore 27
    //   3756: aload_3
    //   3757: astore 28
    //   3759: aload 23
    //   3761: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3764: astore 23
    //   3766: aload 22
    //   3768: astore 26
    //   3770: aload_0
    //   3771: astore 27
    //   3773: aload_3
    //   3774: astore 28
    //   3776: ldc 30
    //   3778: iconst_1
    //   3779: aload 23
    //   3781: invokestatic 106	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3784: aload_3
    //   3785: astore 23
    //   3787: aload_0
    //   3788: astore 24
    //   3790: aload 22
    //   3792: astore 25
    //   3794: iconst_5
    //   3795: istore 7
    //   3797: goto +429 -> 4226
    //   3800: astore_3
    //   3801: aload_3
    //   3802: astore 24
    //   3804: aload 23
    //   3806: astore_3
    //   3807: aload 24
    //   3809: astore 23
    //   3811: aload 22
    //   3813: astore 24
    //   3815: aload_0
    //   3816: astore 22
    //   3818: iconst_5
    //   3819: istore 7
    //   3821: aload 24
    //   3823: astore_0
    //   3824: aload 23
    //   3826: astore 25
    //   3828: aload_0
    //   3829: astore 23
    //   3831: iload 7
    //   3833: istore 4
    //   3835: aload_3
    //   3836: astore 24
    //   3838: invokestatic 320	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3841: ifeq +81 -> 3922
    //   3844: aload_0
    //   3845: astore 23
    //   3847: iload 7
    //   3849: istore 4
    //   3851: aload_3
    //   3852: astore 24
    //   3854: new 205	java/lang/StringBuilder
    //   3857: dup
    //   3858: invokespecial 206	java/lang/StringBuilder:<init>	()V
    //   3861: astore 26
    //   3863: aload_0
    //   3864: astore 23
    //   3866: iload 7
    //   3868: istore 4
    //   3870: aload_3
    //   3871: astore 24
    //   3873: aload 26
    //   3875: ldc_w 487
    //   3878: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3881: pop
    //   3882: aload_0
    //   3883: astore 23
    //   3885: iload 7
    //   3887: istore 4
    //   3889: aload_3
    //   3890: astore 24
    //   3892: aload 26
    //   3894: aload_1
    //   3895: invokevirtual 332	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3898: pop
    //   3899: aload_0
    //   3900: astore 23
    //   3902: iload 7
    //   3904: istore 4
    //   3906: aload_3
    //   3907: astore 24
    //   3909: ldc 30
    //   3911: iconst_2
    //   3912: aload 26
    //   3914: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3917: aload 25
    //   3919: invokestatic 369	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3922: aload_0
    //   3923: astore 23
    //   3925: iload 7
    //   3927: istore 4
    //   3929: aload_3
    //   3930: astore 24
    //   3932: aload 25
    //   3934: instanceof 489
    //   3937: ifeq +10 -> 3947
    //   3940: bipush 10
    //   3942: istore 4
    //   3944: goto +80 -> 4024
    //   3947: aload_0
    //   3948: astore 23
    //   3950: iload 7
    //   3952: istore 4
    //   3954: aload_3
    //   3955: astore 24
    //   3957: aload 25
    //   3959: instanceof 491
    //   3962: ifne +59 -> 4021
    //   3965: aload_0
    //   3966: astore 23
    //   3968: iload 7
    //   3970: istore 4
    //   3972: aload_3
    //   3973: astore 24
    //   3975: aload 25
    //   3977: instanceof 493
    //   3980: ifeq +6 -> 3986
    //   3983: goto +38 -> 4021
    //   3986: aload_0
    //   3987: astore 23
    //   3989: iload 7
    //   3991: istore 4
    //   3993: aload_3
    //   3994: astore 24
    //   3996: aload 25
    //   3998: instanceof 495
    //   4001: istore 21
    //   4003: iload 21
    //   4005: ifeq +10 -> 4015
    //   4008: bipush 11
    //   4010: istore 4
    //   4012: goto +12 -> 4024
    //   4015: iconst_4
    //   4016: istore 4
    //   4018: goto +6 -> 4024
    //   4021: iconst_2
    //   4022: istore 4
    //   4024: aload_3
    //   4025: ifnull +25 -> 4050
    //   4028: aload_3
    //   4029: invokeinterface 461 1 0
    //   4034: goto +16 -> 4050
    //   4037: astore 23
    //   4039: ldc 30
    //   4041: iconst_1
    //   4042: ldc_w 463
    //   4045: aload 23
    //   4047: invokestatic 465	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   4050: ldc_w 467
    //   4053: invokestatic 473	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   4056: checkcast 467	com/tencent/qzonehub/api/IDataUtils
    //   4059: aload_0
    //   4060: invokeinterface 476 2 0
    //   4065: pop
    //   4066: aload 22
    //   4068: astore 25
    //   4070: aload_0
    //   4071: astore 24
    //   4073: iload 4
    //   4075: istore 7
    //   4077: aload_3
    //   4078: astore 23
    //   4080: iload 4
    //   4082: ifeq +144 -> 4226
    //   4085: aload 22
    //   4087: astore 25
    //   4089: aload_0
    //   4090: astore 24
    //   4092: iload 4
    //   4094: istore 7
    //   4096: aload_3
    //   4097: astore 23
    //   4099: aload_2
    //   4100: ifnull +126 -> 4226
    //   4103: aload_2
    //   4104: invokevirtual 112	java/io/File:getParentFile	()Ljava/io/File;
    //   4107: astore 23
    //   4109: aload 23
    //   4111: ifnull +17 -> 4128
    //   4114: aload 23
    //   4116: invokevirtual 116	java/io/File:exists	()Z
    //   4119: ifne +9 -> 4128
    //   4122: aload 23
    //   4124: invokevirtual 119	java/io/File:mkdirs	()Z
    //   4127: pop
    //   4128: aload 22
    //   4130: astore 25
    //   4132: aload_0
    //   4133: astore 24
    //   4135: iload 4
    //   4137: istore 7
    //   4139: aload_3
    //   4140: astore 23
    //   4142: aload_2
    //   4143: invokevirtual 116	java/io/File:exists	()Z
    //   4146: ifeq +80 -> 4226
    //   4149: aload_2
    //   4150: invokevirtual 220	java/io/File:delete	()Z
    //   4153: istore 21
    //   4155: new 205	java/lang/StringBuilder
    //   4158: dup
    //   4159: invokespecial 206	java/lang/StringBuilder:<init>	()V
    //   4162: astore 23
    //   4164: aload 23
    //   4166: ldc_w 478
    //   4169: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4172: pop
    //   4173: aload 23
    //   4175: iload 21
    //   4177: invokevirtual 374	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4180: pop
    //   4181: aload 23
    //   4183: ldc_w 480
    //   4186: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4189: pop
    //   4190: aload 23
    //   4192: aload 32
    //   4194: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4197: pop
    //   4198: ldc 30
    //   4200: iconst_1
    //   4201: aload 23
    //   4203: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4206: invokestatic 106	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4209: aload 22
    //   4211: astore 25
    //   4213: aload_0
    //   4214: astore 24
    //   4216: iload 4
    //   4218: istore 7
    //   4220: aload_3
    //   4221: astore 23
    //   4223: goto +3 -> 4226
    //   4226: iload 11
    //   4228: iconst_1
    //   4229: iadd
    //   4230: istore 11
    //   4232: iload 7
    //   4234: ifeq +68 -> 4302
    //   4237: new 205	java/lang/StringBuilder
    //   4240: dup
    //   4241: invokespecial 206	java/lang/StringBuilder:<init>	()V
    //   4244: astore_0
    //   4245: aload_0
    //   4246: ldc_w 497
    //   4249: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4252: pop
    //   4253: aload_0
    //   4254: iload 7
    //   4256: invokevirtual 500	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4259: pop
    //   4260: aload_0
    //   4261: ldc_w 382
    //   4264: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4267: pop
    //   4268: aload_0
    //   4269: aload_1
    //   4270: invokevirtual 332	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4273: pop
    //   4274: aload_0
    //   4275: ldc_w 502
    //   4278: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4281: pop
    //   4282: aload_0
    //   4283: iload 11
    //   4285: invokevirtual 500	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4288: pop
    //   4289: ldc 30
    //   4291: iconst_1
    //   4292: aload_0
    //   4293: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4296: invokestatic 364	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   4299: goto +59 -> 4358
    //   4302: invokestatic 320	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4305: ifeq +53 -> 4358
    //   4308: new 205	java/lang/StringBuilder
    //   4311: dup
    //   4312: invokespecial 206	java/lang/StringBuilder:<init>	()V
    //   4315: astore_0
    //   4316: aload_0
    //   4317: ldc_w 497
    //   4320: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4323: pop
    //   4324: aload_0
    //   4325: iload 7
    //   4327: invokevirtual 500	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4330: pop
    //   4331: aload_0
    //   4332: ldc_w 382
    //   4335: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4338: pop
    //   4339: aload_0
    //   4340: aload_1
    //   4341: invokevirtual 332	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4344: pop
    //   4345: ldc 30
    //   4347: iconst_2
    //   4348: aload_0
    //   4349: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4352: invokestatic 106	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4355: goto +3 -> 4358
    //   4358: iload 7
    //   4360: ifeq +46 -> 4406
    //   4363: iload 7
    //   4365: sipush -999
    //   4368: if_icmpeq +38 -> 4406
    //   4371: iload 11
    //   4373: iconst_2
    //   4374: if_icmpge +32 -> 4406
    //   4377: aload 33
    //   4379: monitorenter
    //   4380: aload 33
    //   4382: ldc2_w 503
    //   4385: invokevirtual 508	java/lang/Object:wait	(J)V
    //   4388: goto +7 -> 4395
    //   4391: astore_0
    //   4392: goto +9 -> 4401
    //   4395: aload 33
    //   4397: monitorexit
    //   4398: goto +8 -> 4406
    //   4401: aload 33
    //   4403: monitorexit
    //   4404: aload_0
    //   4405: athrow
    //   4406: iload 7
    //   4408: ifeq +35 -> 4443
    //   4411: iload 7
    //   4413: sipush -999
    //   4416: if_icmpeq +27 -> 4443
    //   4419: iload 11
    //   4421: iload 12
    //   4423: if_icmplt +6 -> 4429
    //   4426: iload 7
    //   4428: ireturn
    //   4429: aload 25
    //   4431: astore_0
    //   4432: iload 12
    //   4434: istore 4
    //   4436: aload 24
    //   4438: astore 22
    //   4440: goto -4080 -> 360
    //   4443: iload 7
    //   4445: ireturn
    //   4446: astore_0
    //   4447: aload 24
    //   4449: astore 25
    //   4451: aload 25
    //   4453: ifnull +24 -> 4477
    //   4456: aload 25
    //   4458: invokeinterface 461 1 0
    //   4463: goto +14 -> 4477
    //   4466: astore_1
    //   4467: ldc 30
    //   4469: iconst_1
    //   4470: ldc_w 463
    //   4473: aload_1
    //   4474: invokestatic 465	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   4477: ldc_w 467
    //   4480: invokestatic 473	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   4483: checkcast 467	com/tencent/qzonehub/api/IDataUtils
    //   4486: aload 23
    //   4488: invokeinterface 476 2 0
    //   4493: pop
    //   4494: iload 4
    //   4496: ifeq +89 -> 4585
    //   4499: aload_2
    //   4500: ifnull +85 -> 4585
    //   4503: aload_2
    //   4504: invokevirtual 112	java/io/File:getParentFile	()Ljava/io/File;
    //   4507: astore_1
    //   4508: aload_1
    //   4509: ifnull +15 -> 4524
    //   4512: aload_1
    //   4513: invokevirtual 116	java/io/File:exists	()Z
    //   4516: ifne +8 -> 4524
    //   4519: aload_1
    //   4520: invokevirtual 119	java/io/File:mkdirs	()Z
    //   4523: pop
    //   4524: aload_2
    //   4525: invokevirtual 116	java/io/File:exists	()Z
    //   4528: ifeq +57 -> 4585
    //   4531: aload_2
    //   4532: invokevirtual 220	java/io/File:delete	()Z
    //   4535: istore 21
    //   4537: new 205	java/lang/StringBuilder
    //   4540: dup
    //   4541: invokespecial 206	java/lang/StringBuilder:<init>	()V
    //   4544: astore_1
    //   4545: aload_1
    //   4546: ldc_w 478
    //   4549: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4552: pop
    //   4553: aload_1
    //   4554: iload 21
    //   4556: invokevirtual 374	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4559: pop
    //   4560: aload_1
    //   4561: ldc_w 480
    //   4564: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4567: pop
    //   4568: aload_1
    //   4569: aload 32
    //   4571: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4574: pop
    //   4575: ldc 30
    //   4577: iconst_1
    //   4578: aload_1
    //   4579: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4582: invokestatic 106	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4585: aload_0
    //   4586: athrow
    //   4587: ldc 30
    //   4589: iconst_1
    //   4590: ldc_w 510
    //   4593: invokestatic 106	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4596: bipush 13
    //   4598: ireturn
    //   4599: ldc 30
    //   4601: iconst_1
    //   4602: ldc_w 512
    //   4605: invokestatic 106	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4608: iconst_4
    //   4609: ireturn
    //   4610: astore_0
    //   4611: goto -12 -> 4599
    //   4614: astore_0
    //   4615: goto -4523 -> 92
    //   4618: astore_0
    //   4619: goto -32 -> 4587
    //   4622: astore 22
    //   4624: goto -1669 -> 2955
    //   4627: astore_0
    //   4628: aload 26
    //   4630: astore 25
    //   4632: aload 27
    //   4634: astore 24
    //   4636: aload 28
    //   4638: astore 23
    //   4640: goto -846 -> 3794
    //   4643: astore 23
    //   4645: aload 22
    //   4647: astore 25
    //   4649: aload_0
    //   4650: astore 24
    //   4652: iload 4
    //   4654: istore 7
    //   4656: aload_3
    //   4657: astore 23
    //   4659: goto -433 -> 4226
    //   4662: astore_0
    //   4663: goto -268 -> 4395
    //   4666: astore_1
    //   4667: goto -82 -> 4585
    //   4670: ldc 20
    //   4672: astore_0
    //   4673: goto -2505 -> 2168
    //   4676: astore_0
    //   4677: goto -3440 -> 1237
    //   4680: astore_0
    //   4681: goto -2106 -> 2575
    //   4684: astore_0
    //   4685: goto -2096 -> 2589
    //   4688: astore_0
    //   4689: goto -2086 -> 2603
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	4692	0	paramAppInterface	AppInterface
    //   0	4692	1	paramURL	URL
    //   0	4692	2	paramFile	File
    //   0	4692	3	paramNetworkInfo	NetworkInfo
    //   0	4692	4	paramInt1	int
    //   0	4692	5	paramString	String
    //   0	4692	6	paramInt2	int
    //   131	861	7	i	int
    //   117	133	8	j	int
    //   347	20	11	k	int
    //   408	1	12	m	int
    //   727	63	13	l1	long
    //   6	766	15	l2	long
    //   680	1	17	l3	long
    //   765	5	19	l4	long
    //   534	3	21	bool	boolean
    //   1	1120	22	localObject1	java.lang.Object
    //   126	594	23	localObject2	java.lang.Object
    //   825	1	23	localIOException1	java.io.IOException
    //   830	1	23	localFileNotFoundException1	java.io.FileNotFoundException
    //   868	133	23	localObject3	java.lang.Object
    //   1028	1	23	localIOException2	java.io.IOException
    //   1033	1	23	localFileNotFoundException2	java.io.FileNotFoundException
    //   1050	1	23	localIOException3	java.io.IOException
    //   1055	18	23	localFileNotFoundException3	java.io.FileNotFoundException
    //   1077	48	23	localObject4	java.lang.Object
    //   1129	1	23	localThrowable	java.lang.Throwable
    //   1134	1	23	localException	java.lang.Exception
    //   1139	1	23	localIOException4	java.io.IOException
    //   1144	1	23	localFileNotFoundException4	java.io.FileNotFoundException
    //   137	961	24	localObject5	java.lang.Object
    //   1103	7	24	localIOException5	java.io.IOException
    //   1116	7	24	localFileNotFoundException5	java.io.FileNotFoundException
    //   440	559	25	localObject6	java.lang.Object
    //   1006	1	25	localIOException6	java.io.IOException
    //   1062	1	25	localNetworkInfo	NetworkInfo
    //   364	568	26	localObject7	java.lang.Object
    //   1014	1	28	localFileNotFoundException6	java.io.FileNotFoundException
    //   356	264	29	localAppInterface	AppInterface
    //   112	287	30	localBasicHttpParams	org.apache.http.params.BasicHttpParams
    //   648	1	31	localHashMap	java.util.HashMap
    //   68	838	32	str1	String
    //   15	1	33	localObject8	java.lang.Object
    //   77	801	34	str2	String
    //   639	216	35	arrayOfHeader	Header[]
    // Exception table:
    //   from	to	target	type
    //   424	442	469	java/lang/Throwable
    //   424	442	493	java/lang/Exception
    //   424	442	517	java/io/IOException
    //   442	466	553	java/lang/Throwable
    //   541	550	553	java/lang/Throwable
    //   442	466	557	java/lang/Exception
    //   541	550	557	java/lang/Exception
    //   442	466	561	java/io/IOException
    //   541	550	561	java/io/IOException
    //   767	822	825	java/io/IOException
    //   767	822	830	java/io/FileNotFoundException
    //   840	870	947	finally
    //   875	939	947	finally
    //   840	870	958	java/lang/Throwable
    //   875	939	958	java/lang/Throwable
    //   840	870	982	java/lang/Exception
    //   875	939	982	java/lang/Exception
    //   840	870	1006	java/io/IOException
    //   875	939	1006	java/io/IOException
    //   840	870	1014	java/io/FileNotFoundException
    //   875	939	1014	java/io/FileNotFoundException
    //   729	767	1028	java/io/IOException
    //   729	767	1033	java/io/FileNotFoundException
    //   723	729	1038	finally
    //   729	767	1038	finally
    //   767	822	1038	finally
    //   723	729	1042	java/lang/Throwable
    //   729	767	1042	java/lang/Throwable
    //   767	822	1042	java/lang/Throwable
    //   723	729	1046	java/lang/Exception
    //   729	767	1046	java/lang/Exception
    //   767	822	1046	java/lang/Exception
    //   723	729	1050	java/io/IOException
    //   723	729	1055	java/io/FileNotFoundException
    //   703	716	1060	finally
    //   703	716	1067	java/lang/Throwable
    //   703	716	1085	java/lang/Exception
    //   703	716	1103	java/io/IOException
    //   703	716	1116	java/io/FileNotFoundException
    //   685	703	1129	java/lang/Throwable
    //   685	703	1134	java/lang/Exception
    //   685	703	1139	java/io/IOException
    //   685	703	1144	java/io/FileNotFoundException
    //   1188	1199	1202	finally
    //   2101	2115	1202	finally
    //   2123	2129	1202	finally
    //   2137	2144	1202	finally
    //   2152	2162	1202	finally
    //   2180	2190	1202	finally
    //   2198	2212	1202	finally
    //   2220	2226	1202	finally
    //   2234	2242	1202	finally
    //   2250	2258	1202	finally
    //   2266	2273	1202	finally
    //   2281	2289	1202	finally
    //   2297	2303	1202	finally
    //   2311	2319	1202	finally
    //   2327	2334	1202	finally
    //   2342	2352	1202	finally
    //   2363	2371	1202	finally
    //   2382	2390	1202	finally
    //   2405	2411	1202	finally
    //   2419	2428	1202	finally
    //   2463	2475	1202	finally
    //   2490	2496	1202	finally
    //   2504	2512	1202	finally
    //   2520	2528	1202	finally
    //   2536	2542	1202	finally
    //   2550	2560	1202	finally
    //   1188	1199	1210	java/lang/Throwable
    //   1188	1199	1214	java/lang/Exception
    //   1188	1199	1218	java/io/IOException
    //   1174	1180	1228	finally
    //   1174	1180	1240	java/lang/Throwable
    //   1174	1180	1254	java/lang/Exception
    //   1174	1180	1268	java/io/IOException
    //   1978	1997	2005	finally
    //   2073	2077	2005	finally
    //   1978	1997	2009	java/lang/Throwable
    //   2073	2077	2009	java/lang/Throwable
    //   1978	1997	2013	java/lang/Exception
    //   2073	2077	2013	java/lang/Exception
    //   1978	1997	2017	java/io/IOException
    //   2073	2077	2017	java/io/IOException
    //   2101	2115	2431	java/lang/Throwable
    //   2123	2129	2431	java/lang/Throwable
    //   2137	2144	2431	java/lang/Throwable
    //   2152	2162	2431	java/lang/Throwable
    //   2180	2190	2431	java/lang/Throwable
    //   2198	2212	2431	java/lang/Throwable
    //   2220	2226	2431	java/lang/Throwable
    //   2234	2242	2431	java/lang/Throwable
    //   2250	2258	2431	java/lang/Throwable
    //   2266	2273	2431	java/lang/Throwable
    //   2281	2289	2431	java/lang/Throwable
    //   2297	2303	2431	java/lang/Throwable
    //   2311	2319	2431	java/lang/Throwable
    //   2327	2334	2431	java/lang/Throwable
    //   2342	2352	2431	java/lang/Throwable
    //   2363	2371	2431	java/lang/Throwable
    //   2382	2390	2431	java/lang/Throwable
    //   2405	2411	2431	java/lang/Throwable
    //   2419	2428	2431	java/lang/Throwable
    //   2101	2115	2435	java/lang/Exception
    //   2123	2129	2435	java/lang/Exception
    //   2137	2144	2435	java/lang/Exception
    //   2152	2162	2435	java/lang/Exception
    //   2180	2190	2435	java/lang/Exception
    //   2198	2212	2435	java/lang/Exception
    //   2220	2226	2435	java/lang/Exception
    //   2234	2242	2435	java/lang/Exception
    //   2250	2258	2435	java/lang/Exception
    //   2266	2273	2435	java/lang/Exception
    //   2281	2289	2435	java/lang/Exception
    //   2297	2303	2435	java/lang/Exception
    //   2311	2319	2435	java/lang/Exception
    //   2327	2334	2435	java/lang/Exception
    //   2342	2352	2435	java/lang/Exception
    //   2363	2371	2435	java/lang/Exception
    //   2382	2390	2435	java/lang/Exception
    //   2405	2411	2435	java/lang/Exception
    //   2419	2428	2435	java/lang/Exception
    //   2101	2115	2439	java/io/IOException
    //   2123	2129	2439	java/io/IOException
    //   2137	2144	2439	java/io/IOException
    //   2152	2162	2439	java/io/IOException
    //   2180	2190	2439	java/io/IOException
    //   2198	2212	2439	java/io/IOException
    //   2220	2226	2439	java/io/IOException
    //   2234	2242	2439	java/io/IOException
    //   2250	2258	2439	java/io/IOException
    //   2266	2273	2439	java/io/IOException
    //   2281	2289	2439	java/io/IOException
    //   2297	2303	2439	java/io/IOException
    //   2311	2319	2439	java/io/IOException
    //   2327	2334	2439	java/io/IOException
    //   2342	2352	2439	java/io/IOException
    //   2363	2371	2439	java/io/IOException
    //   2382	2390	2439	java/io/IOException
    //   2405	2411	2439	java/io/IOException
    //   2419	2428	2439	java/io/IOException
    //   1948	1973	2443	java/lang/Throwable
    //   2021	2054	2443	java/lang/Throwable
    //   2059	2068	2443	java/lang/Throwable
    //   2080	2084	2443	java/lang/Throwable
    //   2084	2089	2443	java/lang/Throwable
    //   1948	1973	2447	java/lang/Exception
    //   2021	2054	2447	java/lang/Exception
    //   2059	2068	2447	java/lang/Exception
    //   2080	2084	2447	java/lang/Exception
    //   2084	2089	2447	java/lang/Exception
    //   1948	1973	2451	java/io/IOException
    //   2021	2054	2451	java/io/IOException
    //   2059	2068	2451	java/io/IOException
    //   2080	2084	2451	java/io/IOException
    //   2084	2089	2451	java/io/IOException
    //   2463	2475	2574	java/lang/Throwable
    //   2490	2496	2574	java/lang/Throwable
    //   2504	2512	2574	java/lang/Throwable
    //   2520	2528	2574	java/lang/Throwable
    //   2536	2542	2574	java/lang/Throwable
    //   2550	2560	2574	java/lang/Throwable
    //   2463	2475	2588	java/lang/Exception
    //   2490	2496	2588	java/lang/Exception
    //   2504	2512	2588	java/lang/Exception
    //   2520	2528	2588	java/lang/Exception
    //   2536	2542	2588	java/lang/Exception
    //   2550	2560	2588	java/lang/Exception
    //   2463	2475	2602	java/io/IOException
    //   2490	2496	2602	java/io/IOException
    //   2504	2512	2602	java/io/IOException
    //   2520	2528	2602	java/io/IOException
    //   2536	2542	2602	java/io/IOException
    //   2550	2560	2602	java/io/IOException
    //   1346	1355	2616	java/lang/Throwable
    //   1387	1397	2616	java/lang/Throwable
    //   1429	1438	2616	java/lang/Throwable
    //   1470	1483	2616	java/lang/Throwable
    //   1515	1528	2616	java/lang/Throwable
    //   1582	1588	2616	java/lang/Throwable
    //   1620	1629	2616	java/lang/Throwable
    //   1661	1670	2616	java/lang/Throwable
    //   1702	1710	2616	java/lang/Throwable
    //   1742	1751	2616	java/lang/Throwable
    //   1783	1793	2616	java/lang/Throwable
    //   1825	1834	2616	java/lang/Throwable
    //   1866	1873	2616	java/lang/Throwable
    //   1905	1916	2616	java/lang/Throwable
    //   1346	1355	2629	java/lang/Exception
    //   1387	1397	2629	java/lang/Exception
    //   1429	1438	2629	java/lang/Exception
    //   1470	1483	2629	java/lang/Exception
    //   1515	1528	2629	java/lang/Exception
    //   1582	1588	2629	java/lang/Exception
    //   1620	1629	2629	java/lang/Exception
    //   1661	1670	2629	java/lang/Exception
    //   1702	1710	2629	java/lang/Exception
    //   1742	1751	2629	java/lang/Exception
    //   1783	1793	2629	java/lang/Exception
    //   1825	1834	2629	java/lang/Exception
    //   1866	1873	2629	java/lang/Exception
    //   1905	1916	2629	java/lang/Exception
    //   1346	1355	2642	java/io/IOException
    //   1387	1397	2642	java/io/IOException
    //   1429	1438	2642	java/io/IOException
    //   1470	1483	2642	java/io/IOException
    //   1515	1528	2642	java/io/IOException
    //   1582	1588	2642	java/io/IOException
    //   1620	1629	2642	java/io/IOException
    //   1661	1670	2642	java/io/IOException
    //   1702	1710	2642	java/io/IOException
    //   1742	1751	2642	java/io/IOException
    //   1783	1793	2642	java/io/IOException
    //   1825	1834	2642	java/io/IOException
    //   1866	1873	2642	java/io/IOException
    //   1905	1916	2642	java/io/IOException
    //   1305	1314	2655	finally
    //   1346	1355	2655	finally
    //   1387	1397	2655	finally
    //   1429	1438	2655	finally
    //   1470	1483	2655	finally
    //   1515	1528	2655	finally
    //   1582	1588	2655	finally
    //   1620	1629	2655	finally
    //   1661	1670	2655	finally
    //   1702	1710	2655	finally
    //   1742	1751	2655	finally
    //   1783	1793	2655	finally
    //   1825	1834	2655	finally
    //   1866	1873	2655	finally
    //   1905	1916	2655	finally
    //   1305	1314	2674	java/lang/Throwable
    //   1305	1314	2704	java/lang/Exception
    //   1305	1314	2734	java/io/IOException
    //   674	682	2764	finally
    //   685	703	2764	finally
    //   674	682	2771	java/lang/Throwable
    //   674	682	2786	java/lang/Exception
    //   674	682	2801	java/io/IOException
    //   2816	2822	2825	java/io/IOException
    //   531	536	2964	java/lang/Throwable
    //   565	666	2964	java/lang/Throwable
    //   531	536	2968	java/lang/Exception
    //   565	666	2968	java/lang/Exception
    //   531	536	2972	java/io/IOException
    //   565	666	2972	java/io/IOException
    //   410	419	2976	finally
    //   424	442	2976	finally
    //   442	466	2976	finally
    //   531	536	2976	finally
    //   541	550	2976	finally
    //   565	666	2976	finally
    //   410	419	2991	java/lang/Throwable
    //   3117	3123	3126	java/io/IOException
    //   410	419	3380	java/lang/Exception
    //   3506	3512	3515	java/io/IOException
    //   410	419	3800	java/io/IOException
    //   4028	4034	4037	java/io/IOException
    //   4380	4388	4391	finally
    //   4395	4398	4391	finally
    //   4401	4404	4391	finally
    //   3029	3035	4446	finally
    //   3045	3054	4446	finally
    //   3064	3073	4446	finally
    //   3083	3090	4446	finally
    //   3100	3113	4446	finally
    //   3418	3424	4446	finally
    //   3434	3443	4446	finally
    //   3453	3462	4446	finally
    //   3472	3479	4446	finally
    //   3489	3502	4446	finally
    //   3838	3844	4446	finally
    //   3854	3863	4446	finally
    //   3873	3882	4446	finally
    //   3892	3899	4446	finally
    //   3909	3922	4446	finally
    //   3932	3940	4446	finally
    //   3957	3965	4446	finally
    //   3975	3983	4446	finally
    //   3996	4003	4446	finally
    //   4456	4463	4466	java/io/IOException
    //   43	48	4610	java/lang/Exception
    //   52	64	4610	java/lang/Exception
    //   79	89	4614	java/lang/IllegalArgumentException
    //   92	105	4618	java/lang/IllegalArgumentException
    //   2863	2869	4622	java/lang/Exception
    //   2874	2888	4622	java/lang/Exception
    //   2888	2955	4622	java/lang/Exception
    //   3179	3185	4627	java/lang/Exception
    //   3200	3208	4627	java/lang/Exception
    //   3218	3224	4627	java/lang/Exception
    //   3244	3251	4627	java/lang/Exception
    //   3261	3267	4627	java/lang/Exception
    //   3277	3286	4627	java/lang/Exception
    //   3296	3305	4627	java/lang/Exception
    //   3315	3323	4627	java/lang/Exception
    //   3333	3342	4627	java/lang/Exception
    //   3352	3360	4627	java/lang/Exception
    //   3370	3377	4627	java/lang/Exception
    //   3568	3574	4627	java/lang/Exception
    //   3589	3597	4627	java/lang/Exception
    //   3607	3613	4627	java/lang/Exception
    //   3633	3640	4627	java/lang/Exception
    //   3650	3656	4627	java/lang/Exception
    //   3666	3675	4627	java/lang/Exception
    //   3685	3694	4627	java/lang/Exception
    //   3704	3712	4627	java/lang/Exception
    //   3722	3731	4627	java/lang/Exception
    //   3741	3749	4627	java/lang/Exception
    //   3759	3766	4627	java/lang/Exception
    //   3776	3784	4627	java/lang/Exception
    //   4103	4109	4643	java/lang/Exception
    //   4114	4128	4643	java/lang/Exception
    //   4142	4209	4643	java/lang/Exception
    //   4380	4388	4662	java/lang/InterruptedException
    //   4503	4508	4666	java/lang/Exception
    //   4512	4524	4666	java/lang/Exception
    //   4524	4585	4666	java/lang/Exception
    //   1928	1943	4676	finally
    //   1948	1973	4676	finally
    //   2021	2054	4676	finally
    //   2059	2068	4676	finally
    //   2080	2084	4676	finally
    //   2084	2089	4676	finally
    //   1928	1943	4680	java/lang/Throwable
    //   1928	1943	4684	java/lang/Exception
    //   1928	1943	4688	java/io/IOException
  }
  
  public static boolean download(AppInterface paramAppInterface, String paramString1, File paramFile, String paramString2, int paramInt)
  {
    NetworkInfo localNetworkInfo = AppNetConnInfo.getRecentNetworkInfo();
    boolean bool = false;
    if (localNetworkInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("QZoneHttpDownloadUtil", 2, "Download failed-----------activeNetworkInfo is null");
      }
      return false;
    }
    paramString1 = getFilterUrl(paramString1);
    try
    {
      paramString1 = new URL(paramString1);
      paramInt = download(paramAppInterface, paramString1, paramFile, localNetworkInfo, 2, paramString2, paramInt);
      if (QLog.isColorLevel())
      {
        paramAppInterface = new StringBuilder();
        paramAppInterface.append(paramString2);
        paramAppInterface.append("\nurl = ");
        paramAppInterface.append(paramString1.toString());
        paramAppInterface.append("\nRESULT_CODE = ");
        paramAppInterface.append(paramInt);
        QLog.i("QZoneHttpDownloadUtil", 2, paramAppInterface.toString());
      }
      if (paramInt == 0) {
        bool = true;
      }
      return bool;
    }
    catch (MalformedURLException paramAppInterface)
    {
      paramAppInterface.printStackTrace();
    }
    return false;
  }
  
  /* Error */
  private static String encodeFile(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc_w 541
    //   3: astore 6
    //   5: aload_0
    //   6: ifnull +301 -> 307
    //   9: aload_0
    //   10: invokevirtual 337	java/lang/String:length	()I
    //   13: ifne +7 -> 20
    //   16: ldc_w 541
    //   19: areturn
    //   20: new 108	java/io/File
    //   23: dup
    //   24: aload_0
    //   25: invokespecial 217	java/io/File:<init>	(Ljava/lang/String;)V
    //   28: astore 7
    //   30: aload 7
    //   32: invokevirtual 116	java/io/File:exists	()Z
    //   35: ifeq +240 -> 275
    //   38: aload 7
    //   40: invokevirtual 544	java/io/File:isFile	()Z
    //   43: ifne +6 -> 49
    //   46: goto +229 -> 275
    //   49: aconst_null
    //   50: astore 5
    //   52: aconst_null
    //   53: astore_0
    //   54: aload_0
    //   55: astore 4
    //   57: aload 5
    //   59: astore_3
    //   60: new 546	java/io/BufferedInputStream
    //   63: dup
    //   64: new 548	java/io/FileInputStream
    //   67: dup
    //   68: aload 7
    //   70: invokespecial 549	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   73: sipush 8192
    //   76: invokespecial 552	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   79: astore 7
    //   81: iload_1
    //   82: ifeq +233 -> 315
    //   85: aload_0
    //   86: astore 4
    //   88: aload 5
    //   90: astore_3
    //   91: new 554	java/util/zip/GZIPInputStream
    //   94: dup
    //   95: aload 7
    //   97: invokespecial 557	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   100: astore_0
    //   101: goto +3 -> 104
    //   104: aload_0
    //   105: astore 4
    //   107: aload_0
    //   108: astore_3
    //   109: ldc_w 559
    //   112: invokestatic 564	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   115: astore 7
    //   117: aload_0
    //   118: astore 4
    //   120: aload_0
    //   121: astore_3
    //   122: sipush 16384
    //   125: newarray byte
    //   127: astore 5
    //   129: goto +15 -> 144
    //   132: aload_0
    //   133: astore 4
    //   135: aload_0
    //   136: astore_3
    //   137: sipush 4096
    //   140: newarray byte
    //   142: astore 5
    //   144: aload_0
    //   145: astore 4
    //   147: aload_0
    //   148: astore_3
    //   149: aload_0
    //   150: aload 5
    //   152: invokevirtual 570	java/io/InputStream:read	([B)I
    //   155: istore_2
    //   156: iload_2
    //   157: iconst_m1
    //   158: if_icmpeq +20 -> 178
    //   161: aload_0
    //   162: astore 4
    //   164: aload_0
    //   165: astore_3
    //   166: aload 7
    //   168: aload 5
    //   170: iconst_0
    //   171: iload_2
    //   172: invokevirtual 574	java/security/MessageDigest:update	([BII)V
    //   175: goto -31 -> 144
    //   178: aload_0
    //   179: astore 4
    //   181: aload_0
    //   182: astore_3
    //   183: aload 7
    //   185: invokevirtual 578	java/security/MessageDigest:digest	()[B
    //   188: invokestatic 580	cooperation/qzone/util/QZoneHttpDownloadUtil:byteArrayToHex	([B)Ljava/lang/String;
    //   191: astore 5
    //   193: goto +44 -> 237
    //   196: astore_0
    //   197: goto +59 -> 256
    //   200: astore 7
    //   202: aload_3
    //   203: astore 4
    //   205: aload 6
    //   207: astore 5
    //   209: aload_3
    //   210: astore_0
    //   211: invokestatic 320	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   214: ifeq +23 -> 237
    //   217: aload_3
    //   218: astore 4
    //   220: ldc 30
    //   222: iconst_2
    //   223: ldc_w 582
    //   226: aload 7
    //   228: invokestatic 485	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   231: aload_3
    //   232: astore_0
    //   233: aload 6
    //   235: astore 5
    //   237: ldc_w 467
    //   240: invokestatic 473	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   243: checkcast 467	com/tencent/qzonehub/api/IDataUtils
    //   246: aload_0
    //   247: invokeinterface 476 2 0
    //   252: pop
    //   253: aload 5
    //   255: areturn
    //   256: ldc_w 467
    //   259: invokestatic 473	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   262: checkcast 467	com/tencent/qzonehub/api/IDataUtils
    //   265: aload 4
    //   267: invokeinterface 476 2 0
    //   272: pop
    //   273: aload_0
    //   274: athrow
    //   275: new 205	java/lang/StringBuilder
    //   278: dup
    //   279: invokespecial 206	java/lang/StringBuilder:<init>	()V
    //   282: astore_3
    //   283: aload_3
    //   284: ldc_w 584
    //   287: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: pop
    //   291: aload_3
    //   292: aload_0
    //   293: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: pop
    //   297: ldc 30
    //   299: iconst_2
    //   300: aload_3
    //   301: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   304: invokestatic 364	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   307: ldc_w 541
    //   310: areturn
    //   311: astore_3
    //   312: goto -180 -> 132
    //   315: aload 7
    //   317: astore_0
    //   318: goto -214 -> 104
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	321	0	paramString	String
    //   0	321	1	paramBoolean	boolean
    //   155	17	2	i	int
    //   59	242	3	localObject1	java.lang.Object
    //   311	1	3	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   55	211	4	localObject2	java.lang.Object
    //   50	204	5	localObject3	java.lang.Object
    //   3	231	6	str	String
    //   28	156	7	localObject4	java.lang.Object
    //   200	116	7	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   60	81	196	finally
    //   91	101	196	finally
    //   109	117	196	finally
    //   122	129	196	finally
    //   137	144	196	finally
    //   149	156	196	finally
    //   166	175	196	finally
    //   183	193	196	finally
    //   211	217	196	finally
    //   220	231	196	finally
    //   60	81	200	java/lang/Exception
    //   91	101	200	java/lang/Exception
    //   109	117	200	java/lang/Exception
    //   122	129	200	java/lang/Exception
    //   137	144	200	java/lang/Exception
    //   149	156	200	java/lang/Exception
    //   166	175	200	java/lang/Exception
    //   183	193	200	java/lang/Exception
    //   122	129	311	java/lang/OutOfMemoryError
  }
  
  public static String getFilterUrl(String paramString)
  {
    String str = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      int i = paramString.indexOf("#");
      str = paramString;
      if (i > -1) {
        str = paramString.substring(0, i);
      }
    }
    return str;
  }
  
  private static String getHeaderValue(Header[] paramArrayOfHeader, String paramString)
  {
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        return null;
      }
      if (paramArrayOfHeader != null)
      {
        int j = paramArrayOfHeader.length;
        int i = 0;
        while (i < j)
        {
          Header localHeader = paramArrayOfHeader[i];
          if ((localHeader != null) && (paramString.equals(localHeader.getName()))) {
            return localHeader.getValue();
          }
          i += 1;
        }
      }
    }
    return null;
  }
  
  public static String getValueByName(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString1.length() != 0) && (paramString2 != null))
    {
      if (paramString2.length() == 0) {
        return "";
      }
      String[] arrayOfString = paramString1.substring(paramString1.indexOf("?") + 1).split("\\&");
      int j = arrayOfString.length;
      int i = 0;
      paramString1 = "";
      while (i < j)
      {
        String str = arrayOfString[i];
        if (str.contains(paramString2))
        {
          paramString1 = new StringBuilder();
          paramString1.append(paramString2);
          paramString1.append("=");
          paramString1 = str.replace(paramString1.toString(), "");
        }
        i += 1;
      }
      return paramString1;
    }
    return "";
  }
  
  /* Error */
  private static boolean saveHeadersToFile(Header[] paramArrayOfHeader, File paramFile, String paramString, java.util.HashMap<String, String> paramHashMap)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +5 -> 6
    //   4: iconst_0
    //   5: ireturn
    //   6: new 632	org/json/JSONObject
    //   9: dup
    //   10: invokespecial 633	org/json/JSONObject:<init>	()V
    //   13: astore 11
    //   15: aconst_null
    //   16: astore 10
    //   18: aconst_null
    //   19: astore 9
    //   21: aload_0
    //   22: arraylength
    //   23: istore 5
    //   25: iload 5
    //   27: ifgt +5 -> 32
    //   30: iconst_0
    //   31: ireturn
    //   32: iconst_1
    //   33: istore 6
    //   35: new 296	java/io/FileOutputStream
    //   38: dup
    //   39: aload_1
    //   40: invokespecial 299	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   43: astore 8
    //   45: iconst_0
    //   46: istore 4
    //   48: iconst_1
    //   49: istore 6
    //   51: iload 4
    //   53: iload 5
    //   55: if_icmpge +228 -> 283
    //   58: aload_0
    //   59: iload 4
    //   61: aaload
    //   62: astore 9
    //   64: aload 9
    //   66: invokeinterface 605 1 0
    //   71: astore 12
    //   73: aload 9
    //   75: invokeinterface 608 1 0
    //   80: astore 10
    //   82: aload 10
    //   84: astore 9
    //   86: aload_3
    //   87: ifnull +27 -> 114
    //   90: aload 10
    //   92: astore 9
    //   94: aload_3
    //   95: aload 12
    //   97: invokevirtual 636	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   100: ifeq +14 -> 114
    //   103: aload_3
    //   104: aload 12
    //   106: invokevirtual 640	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   109: checkcast 72	java/lang/String
    //   112: astore 9
    //   114: iload 6
    //   116: istore 7
    //   118: ldc_w 642
    //   121: aload 12
    //   123: invokevirtual 349	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   126: ifne +389 -> 515
    //   129: iload 6
    //   131: istore 7
    //   133: ldc_w 644
    //   136: aload 12
    //   138: invokevirtual 349	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   141: ifne +374 -> 515
    //   144: ldc_w 646
    //   147: aload 12
    //   149: invokevirtual 349	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   152: ifeq +10 -> 162
    //   155: iload 6
    //   157: istore 7
    //   159: goto +356 -> 515
    //   162: aload_2
    //   163: invokestatic 649	cooperation/qzone/webviewplugin/QzoneOfflinePluginJsForQQ:checkDownloadFont	(Ljava/lang/String;)Z
    //   166: ifeq +25 -> 191
    //   169: ldc_w 342
    //   172: aload 12
    //   174: invokevirtual 349	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   177: istore 7
    //   179: iload 7
    //   181: ifeq +10 -> 191
    //   184: iload 6
    //   186: istore 7
    //   188: goto +327 -> 515
    //   191: aload 11
    //   193: aload 12
    //   195: aload 9
    //   197: invokevirtual 652	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   200: pop
    //   201: new 205	java/lang/StringBuilder
    //   204: dup
    //   205: invokespecial 206	java/lang/StringBuilder:<init>	()V
    //   208: astore 10
    //   210: aload 10
    //   212: ldc_w 654
    //   215: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: pop
    //   219: aload 10
    //   221: aload 12
    //   223: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: pop
    //   227: aload 10
    //   229: ldc_w 656
    //   232: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: pop
    //   236: aload 10
    //   238: aload 9
    //   240: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: pop
    //   244: aload 10
    //   246: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   249: invokestatic 243	cooperation/qzone/webviewplugin/QzoneOfflinePluginJsForQQ:detaillog	(Ljava/lang/String;)V
    //   252: iload 6
    //   254: istore 7
    //   256: goto +259 -> 515
    //   259: astore 9
    //   261: invokestatic 320	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   264: ifeq +248 -> 512
    //   267: ldc 30
    //   269: iconst_2
    //   270: aload 9
    //   272: invokevirtual 659	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   275: aload 9
    //   277: invokestatic 369	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   280: goto +232 -> 512
    //   283: aload 8
    //   285: astore_0
    //   286: iload 6
    //   288: istore 7
    //   290: iload 6
    //   292: ifeq +39 -> 331
    //   295: aload 8
    //   297: aload 11
    //   299: invokevirtual 660	org/json/JSONObject:toString	()Ljava/lang/String;
    //   302: ldc_w 662
    //   305: invokevirtual 666	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   308: invokevirtual 670	java/io/FileOutputStream:write	([B)V
    //   311: aload 8
    //   313: invokevirtual 671	java/io/FileOutputStream:flush	()V
    //   316: aload_1
    //   317: invokestatic 95	java/lang/System:currentTimeMillis	()J
    //   320: invokevirtual 317	java/io/File:setLastModified	(J)Z
    //   323: pop
    //   324: iload 6
    //   326: istore 7
    //   328: aload 8
    //   330: astore_0
    //   331: ldc_w 467
    //   334: invokestatic 473	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   337: checkcast 467	com/tencent/qzonehub/api/IDataUtils
    //   340: aload_0
    //   341: invokeinterface 476 2 0
    //   346: pop
    //   347: iload 7
    //   349: ireturn
    //   350: aconst_null
    //   351: astore_0
    //   352: iconst_1
    //   353: istore 7
    //   355: goto -24 -> 331
    //   358: astore_1
    //   359: aload 9
    //   361: astore_0
    //   362: aload_0
    //   363: astore_2
    //   364: invokestatic 320	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   367: ifeq +16 -> 383
    //   370: ldc 30
    //   372: iconst_2
    //   373: aload_1
    //   374: invokevirtual 672	java/io/IOException:getMessage	()Ljava/lang/String;
    //   377: aload_1
    //   378: invokestatic 369	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   381: aload_0
    //   382: astore_2
    //   383: ldc_w 467
    //   386: invokestatic 473	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   389: checkcast 467	com/tencent/qzonehub/api/IDataUtils
    //   392: aload_2
    //   393: invokeinterface 476 2 0
    //   398: pop
    //   399: iconst_0
    //   400: ireturn
    //   401: iload 6
    //   403: istore 7
    //   405: goto -74 -> 331
    //   408: iconst_1
    //   409: istore 6
    //   411: aload 10
    //   413: astore_0
    //   414: new 205	java/lang/StringBuilder
    //   417: dup
    //   418: invokespecial 206	java/lang/StringBuilder:<init>	()V
    //   421: astore_2
    //   422: aload_2
    //   423: ldc_w 371
    //   426: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   429: pop
    //   430: aload_2
    //   431: aload_1
    //   432: invokevirtual 116	java/io/File:exists	()Z
    //   435: invokevirtual 374	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   438: pop
    //   439: aload_2
    //   440: ldc_w 376
    //   443: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   446: pop
    //   447: aload_2
    //   448: aload_1
    //   449: invokevirtual 112	java/io/File:getParentFile	()Ljava/io/File;
    //   452: invokevirtual 116	java/io/File:exists	()Z
    //   455: invokevirtual 374	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   458: pop
    //   459: ldc 30
    //   461: iconst_1
    //   462: aload_2
    //   463: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   466: invokestatic 106	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   469: aload_0
    //   470: astore_2
    //   471: goto -88 -> 383
    //   474: iload 6
    //   476: istore 7
    //   478: goto -147 -> 331
    //   481: astore_0
    //   482: goto -74 -> 408
    //   485: astore_0
    //   486: goto -136 -> 350
    //   489: astore_0
    //   490: goto +45 -> 535
    //   493: astore_0
    //   494: aload 8
    //   496: astore_0
    //   497: iload 6
    //   499: istore 7
    //   501: goto -170 -> 331
    //   504: astore_1
    //   505: goto -104 -> 401
    //   508: astore_1
    //   509: goto -35 -> 474
    //   512: iconst_0
    //   513: istore 7
    //   515: iload 4
    //   517: iconst_1
    //   518: iadd
    //   519: istore 4
    //   521: iload 7
    //   523: istore 6
    //   525: goto -474 -> 51
    //   528: astore_1
    //   529: aload 8
    //   531: astore_0
    //   532: goto -170 -> 362
    //   535: aload 8
    //   537: astore_0
    //   538: goto -124 -> 414
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	541	0	paramArrayOfHeader	Header[]
    //   0	541	1	paramFile	File
    //   0	541	2	paramString	String
    //   0	541	3	paramHashMap	java.util.HashMap<String, String>
    //   46	474	4	i	int
    //   23	33	5	j	int
    //   33	491	6	bool1	boolean
    //   116	406	7	bool2	boolean
    //   43	493	8	localFileOutputStream	java.io.FileOutputStream
    //   19	220	9	localObject1	java.lang.Object
    //   259	101	9	localJSONException	org.json.JSONException
    //   16	396	10	localObject2	java.lang.Object
    //   13	285	11	localJSONObject	org.json.JSONObject
    //   71	151	12	str	String
    // Exception table:
    //   from	to	target	type
    //   191	252	259	org/json/JSONException
    //   35	45	358	java/io/IOException
    //   35	45	481	java/io/FileNotFoundException
    //   35	45	485	finally
    //   64	82	489	java/io/FileNotFoundException
    //   94	114	489	java/io/FileNotFoundException
    //   118	129	489	java/io/FileNotFoundException
    //   133	155	489	java/io/FileNotFoundException
    //   162	179	489	java/io/FileNotFoundException
    //   191	252	489	java/io/FileNotFoundException
    //   261	280	489	java/io/FileNotFoundException
    //   295	324	489	java/io/FileNotFoundException
    //   64	82	493	finally
    //   94	114	493	finally
    //   118	129	493	finally
    //   133	155	493	finally
    //   162	179	493	finally
    //   191	252	493	finally
    //   261	280	493	finally
    //   295	324	493	finally
    //   364	381	504	finally
    //   414	469	508	finally
    //   64	82	528	java/io/IOException
    //   94	114	528	java/io/IOException
    //   118	129	528	java/io/IOException
    //   133	155	528	java/io/IOException
    //   162	179	528	java/io/IOException
    //   191	252	528	java/io/IOException
    //   261	280	528	java/io/IOException
    //   295	324	528	java/io/IOException
  }
  
  public static String sourceFileMd5(String paramString, boolean paramBoolean)
  {
    paramString = encodeFile(paramString, paramBoolean);
    if (paramString != null) {
      return paramString.toLowerCase();
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.util.QZoneHttpDownloadUtil
 * JD-Core Version:    0.7.0.1
 */