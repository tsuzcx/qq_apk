package cooperation.qzone.util;

import android.net.NetworkInfo;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IDataUtils;
import common.config.service.QzoneConfig;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.util.zip.GZIPInputStream;
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
    int i = 0;
    char[] arrayOfChar1 = new char[16];
    char[] tmp10_8 = arrayOfChar1;
    tmp10_8[0] = 48;
    char[] tmp15_10 = tmp10_8;
    tmp15_10[1] = 49;
    char[] tmp20_15 = tmp15_10;
    tmp20_15[2] = 50;
    char[] tmp25_20 = tmp20_15;
    tmp25_20[3] = 51;
    char[] tmp30_25 = tmp25_20;
    tmp30_25[4] = 52;
    char[] tmp35_30 = tmp30_25;
    tmp35_30[5] = 53;
    char[] tmp40_35 = tmp35_30;
    tmp40_35[6] = 54;
    char[] tmp46_40 = tmp40_35;
    tmp46_40[7] = 55;
    char[] tmp52_46 = tmp46_40;
    tmp52_46[8] = 56;
    char[] tmp58_52 = tmp52_46;
    tmp58_52[9] = 57;
    char[] tmp64_58 = tmp58_52;
    tmp64_58[10] = 65;
    char[] tmp70_64 = tmp64_58;
    tmp70_64[11] = 66;
    char[] tmp76_70 = tmp70_64;
    tmp76_70[12] = 67;
    char[] tmp82_76 = tmp76_70;
    tmp82_76[13] = 68;
    char[] tmp88_82 = tmp82_76;
    tmp88_82[14] = 69;
    char[] tmp94_88 = tmp88_82;
    tmp94_88[15] = 70;
    tmp94_88;
    char[] arrayOfChar2 = new char[paramArrayOfByte.length * 2];
    int k = paramArrayOfByte.length;
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
    //   0: invokestatic 95	java/lang/System:currentTimeMillis	()J
    //   3: lstore 18
    //   5: new 97	java/lang/Object
    //   8: dup
    //   9: invokespecial 98	java/lang/Object:<init>	()V
    //   12: astore 31
    //   14: aload_2
    //   15: ifnonnull +17 -> 32
    //   18: ldc 30
    //   20: iconst_1
    //   21: ldc 100
    //   23: invokestatic 106	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   26: iconst_4
    //   27: istore 7
    //   29: iload 7
    //   31: ireturn
    //   32: iload 4
    //   34: istore 12
    //   36: iload 4
    //   38: ifge +6 -> 44
    //   41: iconst_2
    //   42: istore 12
    //   44: aload_2
    //   45: invokevirtual 112	java/io/File:getParentFile	()Ljava/io/File;
    //   48: astore_0
    //   49: aload_0
    //   50: ifnull +15 -> 65
    //   53: aload_0
    //   54: invokevirtual 116	java/io/File:exists	()Z
    //   57: ifne +8 -> 65
    //   60: aload_0
    //   61: invokevirtual 119	java/io/File:mkdirs	()Z
    //   64: pop
    //   65: aconst_null
    //   66: astore_0
    //   67: aload_1
    //   68: invokevirtual 125	java/net/URL:toString	()Ljava/lang/String;
    //   71: astore 30
    //   73: aload 30
    //   75: ldc 127
    //   77: invokestatic 131	cooperation/qzone/util/QZoneHttpDownloadUtil:getValueByName	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   80: astore 32
    //   82: new 133	org/apache/http/client/methods/HttpGet
    //   85: dup
    //   86: aload 30
    //   88: invokespecial 136	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   91: astore 28
    //   93: new 138	org/apache/http/params/BasicHttpParams
    //   96: dup
    //   97: invokespecial 139	org/apache/http/params/BasicHttpParams:<init>	()V
    //   100: astore 33
    //   102: sipush 20000
    //   105: istore 7
    //   107: ldc 140
    //   109: istore 4
    //   111: aload_3
    //   112: ifnull +101 -> 213
    //   115: invokestatic 145	android/net/Proxy:getDefaultHost	()Ljava/lang/String;
    //   118: astore 23
    //   120: invokestatic 149	android/net/Proxy:getDefaultPort	()I
    //   123: istore 4
    //   125: aload_3
    //   126: invokevirtual 154	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   129: astore 24
    //   131: aload_3
    //   132: invokestatic 160	com/tencent/mobileqq/utils/NetworkUtil:a	(Landroid/net/NetworkInfo;)Z
    //   135: ifeq +49 -> 184
    //   138: aload 24
    //   140: ifnull +13 -> 153
    //   143: aload 24
    //   145: ldc 162
    //   147: invokevirtual 166	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   150: ifeq +34 -> 184
    //   153: aload 23
    //   155: ifnull +29 -> 184
    //   158: iload 4
    //   160: ifle +24 -> 184
    //   163: aload 33
    //   165: ldc 168
    //   167: new 170	org/apache/http/HttpHost
    //   170: dup
    //   171: aload 23
    //   173: iload 4
    //   175: invokespecial 173	org/apache/http/HttpHost:<init>	(Ljava/lang/String;I)V
    //   178: invokeinterface 179 3 0
    //   183: pop
    //   184: aload_3
    //   185: invokestatic 160	com/tencent/mobileqq/utils/NetworkUtil:a	(Landroid/net/NetworkInfo;)Z
    //   188: ifeq +2242 -> 2430
    //   191: sipush 20000
    //   194: istore 7
    //   196: ldc 140
    //   198: istore 4
    //   200: aload 33
    //   202: ldc 181
    //   204: sipush 2048
    //   207: invokeinterface 185 3 0
    //   212: pop
    //   213: aload 33
    //   215: ldc 187
    //   217: iload 7
    //   219: invokestatic 193	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   222: invokeinterface 179 3 0
    //   227: pop
    //   228: aload 33
    //   230: ldc 195
    //   232: iload 4
    //   234: invokestatic 193	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   237: invokeinterface 179 3 0
    //   242: pop
    //   243: aload 28
    //   245: aload 33
    //   247: invokevirtual 199	org/apache/http/client/methods/HttpGet:setParams	(Lorg/apache/http/params/HttpParams;)V
    //   250: new 108	java/io/File
    //   253: dup
    //   254: new 201	java/lang/StringBuilder
    //   257: dup
    //   258: invokespecial 202	java/lang/StringBuilder:<init>	()V
    //   261: aload_2
    //   262: invokevirtual 205	java/io/File:getPath	()Ljava/lang/String;
    //   265: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: ldc 211
    //   270: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   276: invokespecial 213	java/io/File:<init>	(Ljava/lang/String;)V
    //   279: astore 34
    //   281: aload_2
    //   282: ifnull +15 -> 297
    //   285: aload_2
    //   286: invokevirtual 116	java/io/File:exists	()Z
    //   289: ifeq +8 -> 297
    //   292: aload_2
    //   293: invokevirtual 216	java/io/File:delete	()Z
    //   296: pop
    //   297: aload 34
    //   299: ifnull +17 -> 316
    //   302: aload 34
    //   304: invokevirtual 116	java/io/File:exists	()Z
    //   307: ifeq +9 -> 316
    //   310: aload 34
    //   312: invokevirtual 216	java/io/File:delete	()Z
    //   315: pop
    //   316: aconst_null
    //   317: astore_3
    //   318: iconst_m1
    //   319: istore 13
    //   321: iload 13
    //   323: ifne +35 -> 358
    //   326: aload 33
    //   328: ldc 168
    //   330: new 170	org/apache/http/HttpHost
    //   333: dup
    //   334: aload_1
    //   335: invokevirtual 219	java/net/URL:getHost	()Ljava/lang/String;
    //   338: aload_1
    //   339: invokevirtual 222	java/net/URL:getPort	()I
    //   342: invokespecial 173	org/apache/http/HttpHost:<init>	(Ljava/lang/String;I)V
    //   345: invokeinterface 179 3 0
    //   350: pop
    //   351: aload 28
    //   353: aload 33
    //   355: invokevirtual 199	org/apache/http/client/methods/HttpGet:setParams	(Lorg/apache/http/params/HttpParams;)V
    //   358: iconst_5
    //   359: istore 4
    //   361: aload_3
    //   362: astore 26
    //   364: aload_0
    //   365: astore 25
    //   367: iload 4
    //   369: istore 8
    //   371: aload 30
    //   373: iload 6
    //   375: invokestatic 228	cooperation/qzone/webviewplugin/QzoneOfflinePluginJsForQQ:getMimeTypeFromUrl	(Ljava/lang/String;I)Ljava/lang/String;
    //   378: astore 23
    //   380: aload 23
    //   382: ifnull +55 -> 437
    //   385: aload_3
    //   386: astore 26
    //   388: aload_0
    //   389: astore 25
    //   391: iload 4
    //   393: istore 8
    //   395: aload 28
    //   397: ldc 230
    //   399: aload 23
    //   401: invokevirtual 234	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   404: aload_3
    //   405: astore 26
    //   407: aload_0
    //   408: astore 25
    //   410: iload 4
    //   412: istore 8
    //   414: new 201	java/lang/StringBuilder
    //   417: dup
    //   418: invokespecial 202	java/lang/StringBuilder:<init>	()V
    //   421: ldc 236
    //   423: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   426: aload 23
    //   428: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   431: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   434: invokestatic 239	cooperation/qzone/webviewplugin/QzoneOfflinePluginJsForQQ:detaillog	(Ljava/lang/String;)V
    //   437: aload_3
    //   438: astore 26
    //   440: aload_0
    //   441: astore 25
    //   443: iload 4
    //   445: istore 8
    //   447: invokestatic 242	cooperation/qzone/webviewplugin/QzoneOfflinePluginJsForQQ:isSupportGZIP	()Z
    //   450: ifeq +22 -> 472
    //   453: aload_3
    //   454: astore 26
    //   456: aload_0
    //   457: astore 25
    //   459: iload 4
    //   461: istore 8
    //   463: aload 28
    //   465: ldc 244
    //   467: ldc 246
    //   469: invokevirtual 234	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   472: aload_3
    //   473: astore 26
    //   475: aload_0
    //   476: astore 25
    //   478: iload 4
    //   480: istore 8
    //   482: aload 28
    //   484: ldc 248
    //   486: aload 5
    //   488: invokevirtual 234	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   491: aload_3
    //   492: astore 26
    //   494: aload_0
    //   495: astore 25
    //   497: iload 4
    //   499: istore 8
    //   501: new 201	java/lang/StringBuilder
    //   504: dup
    //   505: invokespecial 202	java/lang/StringBuilder:<init>	()V
    //   508: ldc 250
    //   510: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   513: aload 5
    //   515: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   518: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   521: invokestatic 239	cooperation/qzone/webviewplugin/QzoneOfflinePluginJsForQQ:detaillog	(Ljava/lang/String;)V
    //   524: aload_3
    //   525: astore 26
    //   527: aload_0
    //   528: astore 25
    //   530: iload 4
    //   532: istore 8
    //   534: getstatic 254	cooperation/qzone/util/QZoneHttpDownloadUtil:client	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   537: new 170	org/apache/http/HttpHost
    //   540: dup
    //   541: aload_1
    //   542: invokevirtual 219	java/net/URL:getHost	()Ljava/lang/String;
    //   545: invokespecial 255	org/apache/http/HttpHost:<init>	(Ljava/lang/String;)V
    //   548: aload 28
    //   550: invokevirtual 261	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/HttpHost;Lorg/apache/http/HttpRequest;)Lorg/apache/http/HttpResponse;
    //   553: astore 23
    //   555: aload_3
    //   556: astore 26
    //   558: aload_0
    //   559: astore 25
    //   561: iload 4
    //   563: istore 8
    //   565: aload 23
    //   567: invokeinterface 267 1 0
    //   572: astore 24
    //   574: aload_3
    //   575: astore 26
    //   577: aload_0
    //   578: astore 25
    //   580: iload 4
    //   582: istore 8
    //   584: aload 23
    //   586: invokeinterface 271 1 0
    //   591: astore 35
    //   593: aload_3
    //   594: astore 26
    //   596: aload_0
    //   597: astore 25
    //   599: iload 4
    //   601: istore 8
    //   603: new 273	java/util/HashMap
    //   606: dup
    //   607: invokespecial 274	java/util/HashMap:<init>	()V
    //   610: astore 36
    //   612: aload_3
    //   613: astore 26
    //   615: aload_0
    //   616: astore 25
    //   618: iload 4
    //   620: istore 8
    //   622: aload 24
    //   624: invokeinterface 279 1 0
    //   629: istore 7
    //   631: aload_3
    //   632: astore 26
    //   634: aload_0
    //   635: astore 25
    //   637: iload 4
    //   639: istore 8
    //   641: aload 23
    //   643: invokeinterface 283 1 0
    //   648: astore 23
    //   650: aload 23
    //   652: astore_3
    //   653: sipush 200
    //   656: iload 7
    //   658: if_icmpne +2911 -> 3569
    //   661: aload_0
    //   662: astore 23
    //   664: iload 4
    //   666: istore 9
    //   668: aload_0
    //   669: astore 25
    //   671: iload 4
    //   673: istore 10
    //   675: aload_0
    //   676: astore 27
    //   678: iload 4
    //   680: istore 11
    //   682: aload_0
    //   683: astore 24
    //   685: iload 4
    //   687: istore 8
    //   689: aload_3
    //   690: astore 26
    //   692: aload_3
    //   693: invokeinterface 288 1 0
    //   698: lstore 20
    //   700: lconst_0
    //   701: lstore 14
    //   703: aload_0
    //   704: astore 25
    //   706: iload 4
    //   708: istore 10
    //   710: aload_0
    //   711: astore 27
    //   713: iload 4
    //   715: istore 11
    //   717: aload_0
    //   718: astore 24
    //   720: iload 4
    //   722: istore 8
    //   724: aload_3
    //   725: astore 26
    //   727: new 290	java/io/BufferedOutputStream
    //   730: dup
    //   731: new 292	java/io/FileOutputStream
    //   734: dup
    //   735: aload_2
    //   736: invokespecial 295	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   739: invokespecial 298	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   742: astore 23
    //   744: aload 23
    //   746: astore 24
    //   748: iload 4
    //   750: istore 8
    //   752: aload 23
    //   754: astore 25
    //   756: iload 4
    //   758: istore 7
    //   760: aload 23
    //   762: astore 26
    //   764: iload 4
    //   766: istore 9
    //   768: aload_3
    //   769: aload 23
    //   771: invokeinterface 301 2 0
    //   776: aload 23
    //   778: astore 24
    //   780: iload 4
    //   782: istore 8
    //   784: aload 23
    //   786: astore 25
    //   788: iload 4
    //   790: istore 7
    //   792: aload 23
    //   794: astore 26
    //   796: iload 4
    //   798: istore 9
    //   800: aload 23
    //   802: invokevirtual 306	java/io/OutputStream:flush	()V
    //   805: aload 23
    //   807: astore 24
    //   809: iload 4
    //   811: istore 8
    //   813: aload 23
    //   815: astore 25
    //   817: iload 4
    //   819: istore 7
    //   821: aload 23
    //   823: astore 26
    //   825: iload 4
    //   827: istore 9
    //   829: aload_2
    //   830: invokevirtual 309	java/io/File:length	()J
    //   833: lstore 16
    //   835: lload 16
    //   837: lstore 14
    //   839: aload 23
    //   841: astore 24
    //   843: iload 4
    //   845: istore 8
    //   847: aload 23
    //   849: astore 25
    //   851: iload 4
    //   853: istore 7
    //   855: aload 23
    //   857: astore 26
    //   859: iload 4
    //   861: istore 9
    //   863: aload_2
    //   864: invokestatic 95	java/lang/System:currentTimeMillis	()J
    //   867: invokevirtual 313	java/io/File:setLastModified	(J)Z
    //   870: pop
    //   871: aload 23
    //   873: astore 24
    //   875: iload 4
    //   877: istore 8
    //   879: aload 23
    //   881: astore 25
    //   883: iload 4
    //   885: istore 7
    //   887: aload 23
    //   889: astore 26
    //   891: iload 4
    //   893: istore 9
    //   895: invokestatic 316	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   898: ifeq +79 -> 977
    //   901: aload 23
    //   903: astore 24
    //   905: iload 4
    //   907: istore 8
    //   909: aload 23
    //   911: astore 25
    //   913: iload 4
    //   915: istore 7
    //   917: aload 23
    //   919: astore 26
    //   921: iload 4
    //   923: istore 9
    //   925: ldc 30
    //   927: iconst_2
    //   928: new 201	java/lang/StringBuilder
    //   931: dup
    //   932: invokespecial 202	java/lang/StringBuilder:<init>	()V
    //   935: ldc_w 318
    //   938: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   941: invokestatic 95	java/lang/System:currentTimeMillis	()J
    //   944: lload 18
    //   946: lsub
    //   947: invokevirtual 321	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   950: ldc_w 323
    //   953: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   956: lload 14
    //   958: invokevirtual 321	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   961: ldc_w 325
    //   964: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   967: aload_1
    //   968: invokevirtual 328	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   971: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   974: invokestatic 331	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   977: iconst_0
    //   978: istore 7
    //   980: iload 7
    //   982: istore 4
    //   984: aload 32
    //   986: ifnull +99 -> 1085
    //   989: iload 7
    //   991: istore 4
    //   993: aload 32
    //   995: invokevirtual 333	java/lang/String:length	()I
    //   998: ifeq +87 -> 1085
    //   1001: aload_2
    //   1002: invokevirtual 336	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1005: ldc 246
    //   1007: aload 35
    //   1009: ldc_w 338
    //   1012: invokestatic 342	cooperation/qzone/util/QZoneHttpDownloadUtil:getHeaderValue	([Lorg/apache/http/Header;Ljava/lang/String;)Ljava/lang/String;
    //   1015: invokevirtual 345	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1018: invokestatic 349	cooperation/qzone/util/QZoneHttpDownloadUtil:sourceFileMd5	(Ljava/lang/String;Z)Ljava/lang/String;
    //   1021: astore_0
    //   1022: iload 7
    //   1024: istore 4
    //   1026: aload_0
    //   1027: ifnull +58 -> 1085
    //   1030: iload 7
    //   1032: istore 4
    //   1034: aload_0
    //   1035: aload 32
    //   1037: invokevirtual 353	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1040: ifne +45 -> 1085
    //   1043: ldc 30
    //   1045: iconst_2
    //   1046: new 201	java/lang/StringBuilder
    //   1049: dup
    //   1050: invokespecial 202	java/lang/StringBuilder:<init>	()V
    //   1053: ldc_w 355
    //   1056: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1059: aload 30
    //   1061: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1064: ldc_w 357
    //   1067: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1070: aload_0
    //   1071: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1074: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1077: invokestatic 360	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1080: sipush -999
    //   1083: istore 4
    //   1085: aload 23
    //   1087: astore_0
    //   1088: iload 4
    //   1090: istore 7
    //   1092: lload 20
    //   1094: lconst_0
    //   1095: lcmp
    //   1096: ifle +136 -> 1232
    //   1099: iload 4
    //   1101: istore 7
    //   1103: lload 14
    //   1105: lload 20
    //   1107: lcmp
    //   1108: ifge +124 -> 1232
    //   1111: aload_0
    //   1112: astore 23
    //   1114: iload 4
    //   1116: istore 9
    //   1118: aload_0
    //   1119: astore 25
    //   1121: iload 4
    //   1123: istore 10
    //   1125: aload_0
    //   1126: astore 27
    //   1128: iload 4
    //   1130: istore 11
    //   1132: aload_0
    //   1133: astore 24
    //   1135: iload 4
    //   1137: istore 8
    //   1139: aload_3
    //   1140: astore 26
    //   1142: invokestatic 316	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1145: ifeq +2876 -> 4021
    //   1148: aload_0
    //   1149: astore 23
    //   1151: iload 4
    //   1153: istore 9
    //   1155: aload_0
    //   1156: astore 25
    //   1158: iload 4
    //   1160: istore 10
    //   1162: aload_0
    //   1163: astore 27
    //   1165: iload 4
    //   1167: istore 11
    //   1169: aload_0
    //   1170: astore 24
    //   1172: iload 4
    //   1174: istore 8
    //   1176: aload_3
    //   1177: astore 26
    //   1179: ldc 30
    //   1181: iconst_2
    //   1182: new 201	java/lang/StringBuilder
    //   1185: dup
    //   1186: invokespecial 202	java/lang/StringBuilder:<init>	()V
    //   1189: ldc_w 362
    //   1192: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1195: lload 20
    //   1197: invokevirtual 321	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1200: ldc_w 364
    //   1203: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1206: aload_2
    //   1207: invokevirtual 309	java/io/File:length	()J
    //   1210: invokevirtual 321	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1213: ldc_w 366
    //   1216: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1219: aload_1
    //   1220: invokevirtual 328	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1223: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1226: invokestatic 360	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1229: goto +2792 -> 4021
    //   1232: iload 7
    //   1234: ifne +2122 -> 3356
    //   1237: aload_0
    //   1238: astore 23
    //   1240: iload 7
    //   1242: istore 9
    //   1244: aload_0
    //   1245: astore 25
    //   1247: iload 7
    //   1249: istore 10
    //   1251: aload_0
    //   1252: astore 27
    //   1254: iload 7
    //   1256: istore 11
    //   1258: aload_0
    //   1259: astore 24
    //   1261: iload 7
    //   1263: istore 8
    //   1265: aload_3
    //   1266: astore 26
    //   1268: ldc 26
    //   1270: aload 35
    //   1272: ldc_w 368
    //   1275: invokestatic 342	cooperation/qzone/util/QZoneHttpDownloadUtil:getHeaderValue	([Lorg/apache/http/Header;Ljava/lang/String;)Ljava/lang/String;
    //   1278: invokevirtual 353	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1281: ifeq +813 -> 2094
    //   1284: aload_0
    //   1285: astore 23
    //   1287: iload 7
    //   1289: istore 9
    //   1291: aload_0
    //   1292: astore 25
    //   1294: iload 7
    //   1296: istore 10
    //   1298: aload_0
    //   1299: astore 27
    //   1301: iload 7
    //   1303: istore 11
    //   1305: aload_0
    //   1306: astore 24
    //   1308: iload 7
    //   1310: istore 8
    //   1312: aload_3
    //   1313: astore 26
    //   1315: invokestatic 374	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1318: invokestatic 379	com/tencent/qqsharpP/QQSharpPUtil:a	(Landroid/content/Context;)Z
    //   1321: ifeq +1778 -> 3099
    //   1324: aload_0
    //   1325: astore 23
    //   1327: iload 7
    //   1329: istore 9
    //   1331: aload_0
    //   1332: astore 25
    //   1334: iload 7
    //   1336: istore 10
    //   1338: aload_0
    //   1339: astore 27
    //   1341: iload 7
    //   1343: istore 11
    //   1345: aload_0
    //   1346: astore 24
    //   1348: iload 7
    //   1350: istore 8
    //   1352: aload_3
    //   1353: astore 26
    //   1355: aload 30
    //   1357: invokestatic 383	cooperation/qzone/webviewplugin/QzoneOfflinePluginJsForQQ:getFileExt	(Ljava/lang/String;)Ljava/lang/String;
    //   1360: astore 38
    //   1362: aload_0
    //   1363: astore 23
    //   1365: iload 7
    //   1367: istore 9
    //   1369: aload_0
    //   1370: astore 25
    //   1372: iload 7
    //   1374: istore 10
    //   1376: aload_0
    //   1377: astore 27
    //   1379: iload 7
    //   1381: istore 11
    //   1383: aload_0
    //   1384: astore 24
    //   1386: iload 7
    //   1388: istore 8
    //   1390: aload_3
    //   1391: astore 26
    //   1393: ldc 14
    //   1395: aload 38
    //   1397: invokevirtual 353	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1400: ifne +85 -> 1485
    //   1403: aload_0
    //   1404: astore 23
    //   1406: iload 7
    //   1408: istore 9
    //   1410: aload_0
    //   1411: astore 25
    //   1413: iload 7
    //   1415: istore 10
    //   1417: aload_0
    //   1418: astore 27
    //   1420: iload 7
    //   1422: istore 11
    //   1424: aload_0
    //   1425: astore 24
    //   1427: iload 7
    //   1429: istore 8
    //   1431: aload_3
    //   1432: astore 26
    //   1434: ldc 11
    //   1436: aload 38
    //   1438: invokevirtual 353	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1441: ifne +44 -> 1485
    //   1444: aload_0
    //   1445: astore 23
    //   1447: iload 7
    //   1449: istore 9
    //   1451: aload_0
    //   1452: astore 25
    //   1454: iload 7
    //   1456: istore 10
    //   1458: aload_0
    //   1459: astore 27
    //   1461: iload 7
    //   1463: istore 11
    //   1465: aload_0
    //   1466: astore 24
    //   1468: iload 7
    //   1470: istore 8
    //   1472: aload_3
    //   1473: astore 26
    //   1475: ldc 17
    //   1477: aload 38
    //   1479: invokevirtual 353	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1482: ifeq +612 -> 2094
    //   1485: aload_0
    //   1486: astore 23
    //   1488: iload 7
    //   1490: istore 9
    //   1492: aload_0
    //   1493: astore 25
    //   1495: iload 7
    //   1497: istore 10
    //   1499: aload_0
    //   1500: astore 27
    //   1502: iload 7
    //   1504: istore 11
    //   1506: aload_0
    //   1507: astore 24
    //   1509: iload 7
    //   1511: istore 8
    //   1513: aload_3
    //   1514: astore 26
    //   1516: aload_2
    //   1517: invokevirtual 336	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1520: astore 37
    //   1522: aload_0
    //   1523: astore 23
    //   1525: iload 7
    //   1527: istore 9
    //   1529: aload_0
    //   1530: astore 25
    //   1532: iload 7
    //   1534: istore 10
    //   1536: aload_0
    //   1537: astore 27
    //   1539: iload 7
    //   1541: istore 11
    //   1543: aload_0
    //   1544: astore 24
    //   1546: iload 7
    //   1548: istore 8
    //   1550: aload_3
    //   1551: astore 26
    //   1553: aload_2
    //   1554: invokestatic 386	com/tencent/qqsharpP/QQSharpPUtil:a	(Ljava/io/File;)Ljava/io/File;
    //   1557: astore 39
    //   1559: aload_0
    //   1560: astore 23
    //   1562: iload 7
    //   1564: istore 9
    //   1566: aload_0
    //   1567: astore 25
    //   1569: iload 7
    //   1571: istore 10
    //   1573: aload_0
    //   1574: astore 27
    //   1576: iload 7
    //   1578: istore 11
    //   1580: aload_0
    //   1581: astore 24
    //   1583: iload 7
    //   1585: istore 8
    //   1587: aload_3
    //   1588: astore 26
    //   1590: aload 39
    //   1592: invokevirtual 336	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1595: invokestatic 392	com/tencent/sharpP/SharpPUtil:decodeSharpPByFilePath	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   1598: astore 40
    //   1600: aload_0
    //   1601: astore 23
    //   1603: iload 7
    //   1605: istore 9
    //   1607: aload_0
    //   1608: astore 25
    //   1610: iload 7
    //   1612: istore 10
    //   1614: aload_0
    //   1615: astore 27
    //   1617: iload 7
    //   1619: istore 11
    //   1621: aload_0
    //   1622: astore 24
    //   1624: iload 7
    //   1626: istore 8
    //   1628: aload_3
    //   1629: astore 26
    //   1631: new 108	java/io/File
    //   1634: dup
    //   1635: aload 37
    //   1637: invokespecial 213	java/io/File:<init>	(Ljava/lang/String;)V
    //   1640: astore 41
    //   1642: aload 40
    //   1644: ifnull +1234 -> 2878
    //   1647: aload_0
    //   1648: astore 23
    //   1650: iload 7
    //   1652: istore 9
    //   1654: aload_0
    //   1655: astore 25
    //   1657: iload 7
    //   1659: istore 10
    //   1661: aload_0
    //   1662: astore 27
    //   1664: iload 7
    //   1666: istore 11
    //   1668: aload_0
    //   1669: astore 24
    //   1671: iload 7
    //   1673: istore 8
    //   1675: aload_3
    //   1676: astore 26
    //   1678: ldc 17
    //   1680: aload 38
    //   1682: invokevirtual 353	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1685: ifeq +910 -> 2595
    //   1688: aload_0
    //   1689: astore 23
    //   1691: iload 7
    //   1693: istore 9
    //   1695: aload_0
    //   1696: astore 25
    //   1698: iload 7
    //   1700: istore 10
    //   1702: aload_0
    //   1703: astore 27
    //   1705: iload 7
    //   1707: istore 11
    //   1709: aload_0
    //   1710: astore 24
    //   1712: iload 7
    //   1714: istore 8
    //   1716: aload_3
    //   1717: astore 26
    //   1719: getstatic 398	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   1722: astore 29
    //   1724: aload_0
    //   1725: astore 23
    //   1727: iload 7
    //   1729: istore 9
    //   1731: aload_0
    //   1732: astore 25
    //   1734: iload 7
    //   1736: istore 10
    //   1738: aload_0
    //   1739: astore 27
    //   1741: iload 7
    //   1743: istore 11
    //   1745: aload_0
    //   1746: astore 24
    //   1748: iload 7
    //   1750: istore 8
    //   1752: aload_3
    //   1753: astore 26
    //   1755: aload 40
    //   1757: aload 37
    //   1759: aload 29
    //   1761: getstatic 48	cooperation/qzone/util/QZoneHttpDownloadUtil:PHOTO_DECODE_QUALITY	I
    //   1764: iconst_1
    //   1765: invokestatic 404	cooperation/qzone/util/PhotoUtils:saveBitmapToFile	(Landroid/graphics/Bitmap;Ljava/lang/String;Landroid/graphics/Bitmap$CompressFormat;IZ)Z
    //   1768: ifeq +866 -> 2634
    //   1771: aload_0
    //   1772: astore 23
    //   1774: iload 7
    //   1776: istore 9
    //   1778: aload_0
    //   1779: astore 25
    //   1781: iload 7
    //   1783: istore 10
    //   1785: aload_0
    //   1786: astore 27
    //   1788: iload 7
    //   1790: istore 11
    //   1792: aload_0
    //   1793: astore 24
    //   1795: iload 7
    //   1797: istore 8
    //   1799: aload_3
    //   1800: astore 26
    //   1802: aload 39
    //   1804: invokestatic 410	cooperation/qzone/util/FileUtils:deleteFile	(Ljava/io/File;)Z
    //   1807: pop
    //   1808: aload_0
    //   1809: astore 23
    //   1811: iload 7
    //   1813: istore 9
    //   1815: aload_0
    //   1816: astore 25
    //   1818: iload 7
    //   1820: istore 10
    //   1822: aload_0
    //   1823: astore 27
    //   1825: iload 7
    //   1827: istore 11
    //   1829: aload_0
    //   1830: astore 24
    //   1832: iload 7
    //   1834: istore 8
    //   1836: aload_3
    //   1837: astore 26
    //   1839: aload 41
    //   1841: invokevirtual 309	java/io/File:length	()J
    //   1844: lstore 14
    //   1846: aload_0
    //   1847: astore 23
    //   1849: iload 7
    //   1851: istore 9
    //   1853: aload_0
    //   1854: astore 25
    //   1856: iload 7
    //   1858: istore 10
    //   1860: aload_0
    //   1861: astore 27
    //   1863: iload 7
    //   1865: istore 11
    //   1867: aload_0
    //   1868: astore 24
    //   1870: iload 7
    //   1872: istore 8
    //   1874: aload_3
    //   1875: astore 26
    //   1877: ldc 17
    //   1879: aload 38
    //   1881: invokevirtual 353	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1884: ifeq +2144 -> 4028
    //   1887: ldc 23
    //   1889: astore 29
    //   1891: aload_0
    //   1892: astore 23
    //   1894: iload 7
    //   1896: istore 9
    //   1898: aload_0
    //   1899: astore 25
    //   1901: iload 7
    //   1903: istore 10
    //   1905: aload_0
    //   1906: astore 27
    //   1908: iload 7
    //   1910: istore 11
    //   1912: aload_0
    //   1913: astore 24
    //   1915: iload 7
    //   1917: istore 8
    //   1919: aload_3
    //   1920: astore 26
    //   1922: aload 36
    //   1924: ldc_w 368
    //   1927: aload 29
    //   1929: invokevirtual 414	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1932: pop
    //   1933: aload_0
    //   1934: astore 23
    //   1936: iload 7
    //   1938: istore 9
    //   1940: aload_0
    //   1941: astore 25
    //   1943: iload 7
    //   1945: istore 10
    //   1947: aload_0
    //   1948: astore 27
    //   1950: iload 7
    //   1952: istore 11
    //   1954: aload_0
    //   1955: astore 24
    //   1957: iload 7
    //   1959: istore 8
    //   1961: aload_3
    //   1962: astore 26
    //   1964: aload 36
    //   1966: ldc_w 416
    //   1969: lload 14
    //   1971: invokestatic 419	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1974: invokevirtual 414	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1977: pop
    //   1978: aload_0
    //   1979: astore 23
    //   1981: iload 7
    //   1983: istore 9
    //   1985: aload_0
    //   1986: astore 25
    //   1988: iload 7
    //   1990: istore 10
    //   1992: aload_0
    //   1993: astore 27
    //   1995: iload 7
    //   1997: istore 11
    //   1999: aload_0
    //   2000: astore 24
    //   2002: iload 7
    //   2004: istore 8
    //   2006: aload_3
    //   2007: astore 26
    //   2009: invokestatic 422	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2012: ifeq +82 -> 2094
    //   2015: aload_0
    //   2016: astore 23
    //   2018: iload 7
    //   2020: istore 9
    //   2022: aload_0
    //   2023: astore 25
    //   2025: iload 7
    //   2027: istore 10
    //   2029: aload_0
    //   2030: astore 27
    //   2032: iload 7
    //   2034: istore 11
    //   2036: aload_0
    //   2037: astore 24
    //   2039: iload 7
    //   2041: istore 8
    //   2043: aload_3
    //   2044: astore 26
    //   2046: ldc 30
    //   2048: iconst_4
    //   2049: new 201	java/lang/StringBuilder
    //   2052: dup
    //   2053: invokespecial 202	java/lang/StringBuilder:<init>	()V
    //   2056: ldc_w 424
    //   2059: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2062: lload 14
    //   2064: invokevirtual 321	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2067: ldc_w 426
    //   2070: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2073: aload_1
    //   2074: invokevirtual 328	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2077: ldc_w 428
    //   2080: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2083: aload 37
    //   2085: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2088: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2091: invokestatic 331	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2094: aload_0
    //   2095: astore 23
    //   2097: iload 7
    //   2099: istore 9
    //   2101: aload_0
    //   2102: astore 25
    //   2104: iload 7
    //   2106: istore 10
    //   2108: aload_0
    //   2109: astore 27
    //   2111: iload 7
    //   2113: istore 11
    //   2115: aload_0
    //   2116: astore 24
    //   2118: iload 7
    //   2120: istore 8
    //   2122: aload_3
    //   2123: astore 26
    //   2125: aload 35
    //   2127: aload 34
    //   2129: aload 30
    //   2131: aload 36
    //   2133: invokestatic 432	cooperation/qzone/util/QZoneHttpDownloadUtil:saveHeadersToFile	([Lorg/apache/http/Header;Ljava/io/File;Ljava/lang/String;Ljava/util/HashMap;)Z
    //   2136: pop
    //   2137: iload 7
    //   2139: istore 4
    //   2141: aload_0
    //   2142: astore 23
    //   2144: aload_3
    //   2145: ifnull +9 -> 2154
    //   2148: aload_3
    //   2149: invokeinterface 435 1 0
    //   2154: ldc_w 437
    //   2157: invokestatic 443	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   2160: checkcast 437	com/tencent/qzonehub/api/IDataUtils
    //   2163: aload 23
    //   2165: invokeinterface 446 2 0
    //   2170: pop
    //   2171: iload 4
    //   2173: ifeq +1843 -> 4016
    //   2176: aload_2
    //   2177: ifnull +75 -> 2252
    //   2180: aload_2
    //   2181: invokevirtual 112	java/io/File:getParentFile	()Ljava/io/File;
    //   2184: astore_0
    //   2185: aload_0
    //   2186: ifnull +15 -> 2201
    //   2189: aload_0
    //   2190: invokevirtual 116	java/io/File:exists	()Z
    //   2193: ifne +8 -> 2201
    //   2196: aload_0
    //   2197: invokevirtual 119	java/io/File:mkdirs	()Z
    //   2200: pop
    //   2201: aload_2
    //   2202: invokevirtual 116	java/io/File:exists	()Z
    //   2205: ifeq +47 -> 2252
    //   2208: aload_2
    //   2209: invokevirtual 216	java/io/File:delete	()Z
    //   2212: istore 22
    //   2214: ldc 30
    //   2216: iconst_1
    //   2217: new 201	java/lang/StringBuilder
    //   2220: dup
    //   2221: invokespecial 202	java/lang/StringBuilder:<init>	()V
    //   2224: ldc_w 448
    //   2227: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2230: iload 22
    //   2232: invokevirtual 451	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2235: ldc_w 453
    //   2238: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2241: aload 30
    //   2243: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2246: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2249: invokestatic 106	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2252: aload_3
    //   2253: astore_0
    //   2254: iload 13
    //   2256: iconst_1
    //   2257: iadd
    //   2258: istore 13
    //   2260: iload 4
    //   2262: ifeq +1494 -> 3756
    //   2265: ldc 30
    //   2267: iconst_1
    //   2268: new 201	java/lang/StringBuilder
    //   2271: dup
    //   2272: invokespecial 202	java/lang/StringBuilder:<init>	()V
    //   2275: ldc_w 455
    //   2278: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2281: iload 4
    //   2283: invokevirtual 458	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2286: ldc_w 366
    //   2289: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2292: aload_1
    //   2293: invokevirtual 328	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2296: ldc_w 460
    //   2299: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2302: iload 13
    //   2304: invokevirtual 458	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2307: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2310: invokestatic 360	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   2313: iload 4
    //   2315: ifeq +31 -> 2346
    //   2318: iload 4
    //   2320: sipush -999
    //   2323: if_icmpeq +23 -> 2346
    //   2326: iload 13
    //   2328: iconst_2
    //   2329: if_icmpge +17 -> 2346
    //   2332: aload 31
    //   2334: monitorenter
    //   2335: aload 31
    //   2337: ldc2_w 461
    //   2340: invokevirtual 466	java/lang/Object:wait	(J)V
    //   2343: aload 31
    //   2345: monitorexit
    //   2346: iload 4
    //   2348: istore 7
    //   2350: iload 4
    //   2352: ifeq -2323 -> 29
    //   2355: iload 4
    //   2357: istore 7
    //   2359: iload 4
    //   2361: sipush -999
    //   2364: if_icmpeq -2335 -> 29
    //   2367: iload 4
    //   2369: istore 7
    //   2371: iload 13
    //   2373: iload 12
    //   2375: if_icmpge -2346 -> 29
    //   2378: aload_0
    //   2379: astore_3
    //   2380: aload 23
    //   2382: astore_0
    //   2383: goto -2062 -> 321
    //   2386: astore_0
    //   2387: ldc 30
    //   2389: iconst_1
    //   2390: ldc_w 468
    //   2393: invokestatic 106	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2396: iconst_4
    //   2397: ireturn
    //   2398: astore 23
    //   2400: new 133	org/apache/http/client/methods/HttpGet
    //   2403: dup
    //   2404: aload 30
    //   2406: invokestatic 471	cooperation/qzone/util/QZoneHttpDownloadUtil:getEscapeSequence	(Ljava/lang/String;)Ljava/lang/String;
    //   2409: invokespecial 136	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   2412: astore 28
    //   2414: goto -2321 -> 93
    //   2417: astore_0
    //   2418: ldc 30
    //   2420: iconst_1
    //   2421: ldc_w 473
    //   2424: invokestatic 106	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2427: bipush 13
    //   2429: ireturn
    //   2430: sipush 10000
    //   2433: istore 7
    //   2435: sipush 30000
    //   2438: istore 4
    //   2440: aload 33
    //   2442: ldc 181
    //   2444: sipush 4096
    //   2447: invokeinterface 185 3 0
    //   2452: pop
    //   2453: goto -2240 -> 213
    //   2456: astore 24
    //   2458: aload 23
    //   2460: astore_0
    //   2461: iconst_5
    //   2462: istore 4
    //   2464: aload 24
    //   2466: astore 23
    //   2468: ldc 30
    //   2470: iconst_1
    //   2471: new 201	java/lang/StringBuilder
    //   2474: dup
    //   2475: invokespecial 202	java/lang/StringBuilder:<init>	()V
    //   2478: ldc_w 475
    //   2481: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2484: aload_2
    //   2485: invokevirtual 116	java/io/File:exists	()Z
    //   2488: invokevirtual 451	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2491: ldc_w 477
    //   2494: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2497: aload_2
    //   2498: invokevirtual 112	java/io/File:getParentFile	()Ljava/io/File;
    //   2501: invokevirtual 116	java/io/File:exists	()Z
    //   2504: invokevirtual 451	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2507: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2510: aload 23
    //   2512: invokestatic 480	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2515: goto -1427 -> 1088
    //   2518: astore_0
    //   2519: lconst_0
    //   2520: lstore 14
    //   2522: aload 23
    //   2524: astore 24
    //   2526: iload 4
    //   2528: istore 8
    //   2530: aload 23
    //   2532: astore 25
    //   2534: iload 4
    //   2536: istore 7
    //   2538: aload 23
    //   2540: astore 26
    //   2542: iload 4
    //   2544: istore 9
    //   2546: invokestatic 316	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2549: ifeq +37 -> 2586
    //   2552: aload 23
    //   2554: astore 24
    //   2556: iload 4
    //   2558: istore 8
    //   2560: aload 23
    //   2562: astore 25
    //   2564: iload 4
    //   2566: istore 7
    //   2568: aload 23
    //   2570: astore 26
    //   2572: iload 4
    //   2574: istore 9
    //   2576: ldc 30
    //   2578: iconst_2
    //   2579: ldc_w 482
    //   2582: aload_0
    //   2583: invokestatic 480	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2586: iconst_4
    //   2587: istore 4
    //   2589: aload 23
    //   2591: astore_0
    //   2592: goto -1504 -> 1088
    //   2595: aload_0
    //   2596: astore 23
    //   2598: iload 7
    //   2600: istore 9
    //   2602: aload_0
    //   2603: astore 25
    //   2605: iload 7
    //   2607: istore 10
    //   2609: aload_0
    //   2610: astore 27
    //   2612: iload 7
    //   2614: istore 11
    //   2616: aload_0
    //   2617: astore 24
    //   2619: iload 7
    //   2621: istore 8
    //   2623: aload_3
    //   2624: astore 26
    //   2626: getstatic 485	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   2629: astore 29
    //   2631: goto -907 -> 1724
    //   2634: aload_0
    //   2635: astore 23
    //   2637: iload 7
    //   2639: istore 9
    //   2641: aload_0
    //   2642: astore 25
    //   2644: iload 7
    //   2646: istore 10
    //   2648: aload_0
    //   2649: astore 27
    //   2651: iload 7
    //   2653: istore 11
    //   2655: aload_0
    //   2656: astore 24
    //   2658: iload 7
    //   2660: istore 8
    //   2662: aload_3
    //   2663: astore 26
    //   2665: aload 39
    //   2667: aload 41
    //   2669: invokevirtual 488	java/io/File:renameTo	(Ljava/io/File;)Z
    //   2672: pop
    //   2673: goto -579 -> 2094
    //   2676: astore 24
    //   2678: iload 9
    //   2680: istore 4
    //   2682: aload_3
    //   2683: astore 26
    //   2685: aload 23
    //   2687: astore 25
    //   2689: iload 4
    //   2691: istore 8
    //   2693: invokestatic 316	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2696: ifeq +42 -> 2738
    //   2699: aload_3
    //   2700: astore 26
    //   2702: aload 23
    //   2704: astore 25
    //   2706: iload 4
    //   2708: istore 8
    //   2710: ldc 30
    //   2712: iconst_2
    //   2713: new 201	java/lang/StringBuilder
    //   2716: dup
    //   2717: invokespecial 202	java/lang/StringBuilder:<init>	()V
    //   2720: ldc_w 490
    //   2723: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2726: aload_1
    //   2727: invokevirtual 328	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2730: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2733: aload 24
    //   2735: invokestatic 480	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2738: aload_3
    //   2739: astore 26
    //   2741: aload 23
    //   2743: astore 25
    //   2745: iload 4
    //   2747: istore 8
    //   2749: aload 24
    //   2751: instanceof 492
    //   2754: istore 22
    //   2756: iload 22
    //   2758: ifeq +841 -> 3599
    //   2761: bipush 10
    //   2763: istore 4
    //   2765: aload_3
    //   2766: ifnull +9 -> 2775
    //   2769: aload_3
    //   2770: invokeinterface 435 1 0
    //   2775: ldc_w 437
    //   2778: invokestatic 443	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   2781: checkcast 437	com/tencent/qzonehub/api/IDataUtils
    //   2784: aload 23
    //   2786: invokeinterface 446 2 0
    //   2791: pop
    //   2792: iload 4
    //   2794: ifeq +1217 -> 4011
    //   2797: aload_2
    //   2798: ifnull +75 -> 2873
    //   2801: aload_2
    //   2802: invokevirtual 112	java/io/File:getParentFile	()Ljava/io/File;
    //   2805: astore_0
    //   2806: aload_0
    //   2807: ifnull +15 -> 2822
    //   2810: aload_0
    //   2811: invokevirtual 116	java/io/File:exists	()Z
    //   2814: ifne +8 -> 2822
    //   2817: aload_0
    //   2818: invokevirtual 119	java/io/File:mkdirs	()Z
    //   2821: pop
    //   2822: aload_2
    //   2823: invokevirtual 116	java/io/File:exists	()Z
    //   2826: ifeq +47 -> 2873
    //   2829: aload_2
    //   2830: invokevirtual 216	java/io/File:delete	()Z
    //   2833: istore 22
    //   2835: ldc 30
    //   2837: iconst_1
    //   2838: new 201	java/lang/StringBuilder
    //   2841: dup
    //   2842: invokespecial 202	java/lang/StringBuilder:<init>	()V
    //   2845: ldc_w 448
    //   2848: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2851: iload 22
    //   2853: invokevirtual 451	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2856: ldc_w 453
    //   2859: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2862: aload 30
    //   2864: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2867: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2870: invokestatic 106	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2873: aload_3
    //   2874: astore_0
    //   2875: goto -621 -> 2254
    //   2878: aload_0
    //   2879: astore 23
    //   2881: iload 7
    //   2883: istore 9
    //   2885: aload_0
    //   2886: astore 25
    //   2888: iload 7
    //   2890: istore 10
    //   2892: aload_0
    //   2893: astore 27
    //   2895: iload 7
    //   2897: istore 11
    //   2899: aload_0
    //   2900: astore 24
    //   2902: iload 7
    //   2904: istore 8
    //   2906: aload_3
    //   2907: astore 26
    //   2909: aload 39
    //   2911: aload 41
    //   2913: invokevirtual 488	java/io/File:renameTo	(Ljava/io/File;)Z
    //   2916: pop
    //   2917: goto -823 -> 2094
    //   2920: astore_0
    //   2921: iload 10
    //   2923: istore 4
    //   2925: aload 25
    //   2927: astore 23
    //   2929: aload_0
    //   2930: astore 25
    //   2932: aload 23
    //   2934: astore 24
    //   2936: iload 4
    //   2938: istore 8
    //   2940: aload_3
    //   2941: astore 26
    //   2943: invokestatic 316	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2946: ifeq +42 -> 2988
    //   2949: aload 23
    //   2951: astore 24
    //   2953: iload 4
    //   2955: istore 8
    //   2957: aload_3
    //   2958: astore 26
    //   2960: ldc 30
    //   2962: iconst_2
    //   2963: new 201	java/lang/StringBuilder
    //   2966: dup
    //   2967: invokespecial 202	java/lang/StringBuilder:<init>	()V
    //   2970: ldc_w 494
    //   2973: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2976: aload_1
    //   2977: invokevirtual 328	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2980: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2983: aload 25
    //   2985: invokestatic 480	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2988: aload_3
    //   2989: ifnull +9 -> 2998
    //   2992: aload_3
    //   2993: invokeinterface 435 1 0
    //   2998: ldc_w 437
    //   3001: invokestatic 443	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   3004: checkcast 437	com/tencent/qzonehub/api/IDataUtils
    //   3007: aload 23
    //   3009: invokeinterface 446 2 0
    //   3014: pop
    //   3015: aload_2
    //   3016: ifnull +75 -> 3091
    //   3019: aload_2
    //   3020: invokevirtual 112	java/io/File:getParentFile	()Ljava/io/File;
    //   3023: astore_0
    //   3024: aload_0
    //   3025: ifnull +15 -> 3040
    //   3028: aload_0
    //   3029: invokevirtual 116	java/io/File:exists	()Z
    //   3032: ifne +8 -> 3040
    //   3035: aload_0
    //   3036: invokevirtual 119	java/io/File:mkdirs	()Z
    //   3039: pop
    //   3040: aload_2
    //   3041: invokevirtual 116	java/io/File:exists	()Z
    //   3044: ifeq +47 -> 3091
    //   3047: aload_2
    //   3048: invokevirtual 216	java/io/File:delete	()Z
    //   3051: istore 22
    //   3053: ldc 30
    //   3055: iconst_1
    //   3056: new 201	java/lang/StringBuilder
    //   3059: dup
    //   3060: invokespecial 202	java/lang/StringBuilder:<init>	()V
    //   3063: ldc_w 448
    //   3066: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3069: iload 22
    //   3071: invokevirtual 451	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3074: ldc_w 453
    //   3077: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3080: aload 30
    //   3082: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3085: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3088: invokestatic 106	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3091: iconst_5
    //   3092: istore 4
    //   3094: aload_3
    //   3095: astore_0
    //   3096: goto -842 -> 2254
    //   3099: aload_0
    //   3100: astore 23
    //   3102: iload 7
    //   3104: istore 9
    //   3106: aload_0
    //   3107: astore 25
    //   3109: iload 7
    //   3111: istore 10
    //   3113: aload_0
    //   3114: astore 27
    //   3116: iload 7
    //   3118: istore 11
    //   3120: aload_0
    //   3121: astore 24
    //   3123: iload 7
    //   3125: istore 8
    //   3127: aload_3
    //   3128: astore 26
    //   3130: invokestatic 422	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   3133: ifeq -1039 -> 2094
    //   3136: aload_0
    //   3137: astore 23
    //   3139: iload 7
    //   3141: istore 9
    //   3143: aload_0
    //   3144: astore 25
    //   3146: iload 7
    //   3148: istore 10
    //   3150: aload_0
    //   3151: astore 27
    //   3153: iload 7
    //   3155: istore 11
    //   3157: aload_0
    //   3158: astore 24
    //   3160: iload 7
    //   3162: istore 8
    //   3164: aload_3
    //   3165: astore 26
    //   3167: ldc 30
    //   3169: iconst_4
    //   3170: ldc_w 496
    //   3173: invokestatic 331	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3176: goto -1082 -> 2094
    //   3179: astore 25
    //   3181: iload 11
    //   3183: istore 4
    //   3185: aload 27
    //   3187: astore 23
    //   3189: aload 23
    //   3191: astore 24
    //   3193: iload 4
    //   3195: istore 8
    //   3197: aload_3
    //   3198: astore 26
    //   3200: invokestatic 316	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3203: ifeq +42 -> 3245
    //   3206: aload 23
    //   3208: astore 24
    //   3210: iload 4
    //   3212: istore 8
    //   3214: aload_3
    //   3215: astore 26
    //   3217: ldc 30
    //   3219: iconst_2
    //   3220: new 201	java/lang/StringBuilder
    //   3223: dup
    //   3224: invokespecial 202	java/lang/StringBuilder:<init>	()V
    //   3227: ldc_w 494
    //   3230: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3233: aload_1
    //   3234: invokevirtual 328	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3237: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3240: aload 25
    //   3242: invokestatic 499	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3245: aload_3
    //   3246: ifnull +9 -> 3255
    //   3249: aload_3
    //   3250: invokeinterface 435 1 0
    //   3255: ldc_w 437
    //   3258: invokestatic 443	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   3261: checkcast 437	com/tencent/qzonehub/api/IDataUtils
    //   3264: aload 23
    //   3266: invokeinterface 446 2 0
    //   3271: pop
    //   3272: aload_2
    //   3273: ifnull +75 -> 3348
    //   3276: aload_2
    //   3277: invokevirtual 112	java/io/File:getParentFile	()Ljava/io/File;
    //   3280: astore_0
    //   3281: aload_0
    //   3282: ifnull +15 -> 3297
    //   3285: aload_0
    //   3286: invokevirtual 116	java/io/File:exists	()Z
    //   3289: ifne +8 -> 3297
    //   3292: aload_0
    //   3293: invokevirtual 119	java/io/File:mkdirs	()Z
    //   3296: pop
    //   3297: aload_2
    //   3298: invokevirtual 116	java/io/File:exists	()Z
    //   3301: ifeq +47 -> 3348
    //   3304: aload_2
    //   3305: invokevirtual 216	java/io/File:delete	()Z
    //   3308: istore 22
    //   3310: ldc 30
    //   3312: iconst_1
    //   3313: new 201	java/lang/StringBuilder
    //   3316: dup
    //   3317: invokespecial 202	java/lang/StringBuilder:<init>	()V
    //   3320: ldc_w 448
    //   3323: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3326: iload 22
    //   3328: invokevirtual 451	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3331: ldc_w 453
    //   3334: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3337: aload 30
    //   3339: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3342: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3345: invokestatic 106	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3348: iconst_5
    //   3349: istore 4
    //   3351: aload_3
    //   3352: astore_0
    //   3353: goto -1099 -> 2254
    //   3356: aload_0
    //   3357: astore 23
    //   3359: iload 7
    //   3361: istore 9
    //   3363: aload_0
    //   3364: astore 25
    //   3366: iload 7
    //   3368: istore 10
    //   3370: aload_0
    //   3371: astore 27
    //   3373: iload 7
    //   3375: istore 11
    //   3377: aload_0
    //   3378: astore 24
    //   3380: iload 7
    //   3382: istore 8
    //   3384: aload_3
    //   3385: astore 26
    //   3387: invokestatic 316	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3390: ifeq -1253 -> 2137
    //   3393: aload_0
    //   3394: astore 23
    //   3396: iload 7
    //   3398: istore 9
    //   3400: aload_0
    //   3401: astore 25
    //   3403: iload 7
    //   3405: istore 10
    //   3407: aload_0
    //   3408: astore 27
    //   3410: iload 7
    //   3412: istore 11
    //   3414: aload_0
    //   3415: astore 24
    //   3417: iload 7
    //   3419: istore 8
    //   3421: aload_3
    //   3422: astore 26
    //   3424: ldc 30
    //   3426: iconst_2
    //   3427: new 201	java/lang/StringBuilder
    //   3430: dup
    //   3431: invokespecial 202	java/lang/StringBuilder:<init>	()V
    //   3434: ldc_w 501
    //   3437: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3440: aload_1
    //   3441: invokevirtual 328	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3444: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3447: invokestatic 106	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3450: goto -1313 -> 2137
    //   3453: astore_1
    //   3454: aload 26
    //   3456: astore_3
    //   3457: aload 24
    //   3459: astore_0
    //   3460: aload_3
    //   3461: ifnull +9 -> 3470
    //   3464: aload_3
    //   3465: invokeinterface 435 1 0
    //   3470: ldc_w 437
    //   3473: invokestatic 443	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   3476: checkcast 437	com/tencent/qzonehub/api/IDataUtils
    //   3479: aload_0
    //   3480: invokeinterface 446 2 0
    //   3485: pop
    //   3486: iload 8
    //   3488: ifeq +79 -> 3567
    //   3491: aload_2
    //   3492: ifnull +75 -> 3567
    //   3495: aload_2
    //   3496: invokevirtual 112	java/io/File:getParentFile	()Ljava/io/File;
    //   3499: astore_0
    //   3500: aload_0
    //   3501: ifnull +15 -> 3516
    //   3504: aload_0
    //   3505: invokevirtual 116	java/io/File:exists	()Z
    //   3508: ifne +8 -> 3516
    //   3511: aload_0
    //   3512: invokevirtual 119	java/io/File:mkdirs	()Z
    //   3515: pop
    //   3516: aload_2
    //   3517: invokevirtual 116	java/io/File:exists	()Z
    //   3520: ifeq +47 -> 3567
    //   3523: aload_2
    //   3524: invokevirtual 216	java/io/File:delete	()Z
    //   3527: istore 22
    //   3529: ldc 30
    //   3531: iconst_1
    //   3532: new 201	java/lang/StringBuilder
    //   3535: dup
    //   3536: invokespecial 202	java/lang/StringBuilder:<init>	()V
    //   3539: ldc_w 448
    //   3542: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3545: iload 22
    //   3547: invokevirtual 451	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3550: ldc_w 453
    //   3553: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3556: aload 30
    //   3558: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3561: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3564: invokestatic 106	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3567: aload_1
    //   3568: athrow
    //   3569: iload 7
    //   3571: istore 4
    //   3573: aload_0
    //   3574: astore 23
    //   3576: goto -1432 -> 2144
    //   3579: astore_0
    //   3580: ldc 30
    //   3582: iconst_1
    //   3583: ldc_w 503
    //   3586: aload_0
    //   3587: invokestatic 505	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3590: goto -1436 -> 2154
    //   3593: astore_0
    //   3594: aload_3
    //   3595: astore_0
    //   3596: goto -1342 -> 2254
    //   3599: aload_3
    //   3600: astore 26
    //   3602: aload 23
    //   3604: astore 25
    //   3606: iload 4
    //   3608: istore 8
    //   3610: aload 24
    //   3612: instanceof 507
    //   3615: ifne +420 -> 4035
    //   3618: aload_3
    //   3619: astore 26
    //   3621: aload 23
    //   3623: astore 25
    //   3625: iload 4
    //   3627: istore 8
    //   3629: aload 24
    //   3631: instanceof 509
    //   3634: ifeq +6 -> 3640
    //   3637: goto +398 -> 4035
    //   3640: aload_3
    //   3641: astore 26
    //   3643: aload 23
    //   3645: astore 25
    //   3647: iload 4
    //   3649: istore 8
    //   3651: aload 24
    //   3653: instanceof 511
    //   3656: istore 22
    //   3658: iload 22
    //   3660: ifeq +10 -> 3670
    //   3663: bipush 11
    //   3665: istore 4
    //   3667: goto -902 -> 2765
    //   3670: iconst_4
    //   3671: istore 4
    //   3673: goto -908 -> 2765
    //   3676: astore_0
    //   3677: ldc 30
    //   3679: iconst_1
    //   3680: ldc_w 503
    //   3683: aload_0
    //   3684: invokestatic 505	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3687: goto -912 -> 2775
    //   3690: astore_0
    //   3691: aload_3
    //   3692: astore_0
    //   3693: goto -1439 -> 2254
    //   3696: astore_0
    //   3697: ldc 30
    //   3699: iconst_1
    //   3700: ldc_w 503
    //   3703: aload_0
    //   3704: invokestatic 505	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3707: goto -709 -> 2998
    //   3710: astore_0
    //   3711: iconst_5
    //   3712: istore 4
    //   3714: aload_3
    //   3715: astore_0
    //   3716: goto -1462 -> 2254
    //   3719: astore_0
    //   3720: ldc 30
    //   3722: iconst_1
    //   3723: ldc_w 503
    //   3726: aload_0
    //   3727: invokestatic 505	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3730: goto -475 -> 3255
    //   3733: astore_0
    //   3734: iconst_5
    //   3735: istore 4
    //   3737: aload_3
    //   3738: astore_0
    //   3739: goto -1485 -> 2254
    //   3742: astore_3
    //   3743: ldc 30
    //   3745: iconst_1
    //   3746: ldc_w 503
    //   3749: aload_3
    //   3750: invokestatic 505	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3753: goto -283 -> 3470
    //   3756: invokestatic 316	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3759: ifeq -1446 -> 2313
    //   3762: ldc 30
    //   3764: iconst_2
    //   3765: new 201	java/lang/StringBuilder
    //   3768: dup
    //   3769: invokespecial 202	java/lang/StringBuilder:<init>	()V
    //   3772: ldc_w 455
    //   3775: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3778: iload 4
    //   3780: invokevirtual 458	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3783: ldc_w 366
    //   3786: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3789: aload_1
    //   3790: invokevirtual 328	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3793: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3796: invokestatic 106	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3799: goto -1486 -> 2313
    //   3802: astore_0
    //   3803: aload 31
    //   3805: monitorexit
    //   3806: aload_0
    //   3807: athrow
    //   3808: astore_3
    //   3809: goto -1466 -> 2343
    //   3812: astore_0
    //   3813: goto -246 -> 3567
    //   3816: astore_1
    //   3817: aload 24
    //   3819: astore_0
    //   3820: goto -360 -> 3460
    //   3823: astore_1
    //   3824: aload 23
    //   3826: astore_0
    //   3827: iconst_0
    //   3828: istore 8
    //   3830: goto -370 -> 3460
    //   3833: astore_1
    //   3834: iload 4
    //   3836: istore 8
    //   3838: goto -378 -> 3460
    //   3841: astore_1
    //   3842: aload 26
    //   3844: astore_3
    //   3845: aload 25
    //   3847: astore_0
    //   3848: goto -388 -> 3460
    //   3851: astore_0
    //   3852: aload 25
    //   3854: astore 23
    //   3856: aload_0
    //   3857: astore 25
    //   3859: iload 7
    //   3861: istore 4
    //   3863: goto -674 -> 3189
    //   3866: astore 25
    //   3868: iconst_0
    //   3869: istore 4
    //   3871: goto -682 -> 3189
    //   3874: astore 25
    //   3876: aload_0
    //   3877: astore 23
    //   3879: goto -690 -> 3189
    //   3882: astore 25
    //   3884: aload_0
    //   3885: astore 23
    //   3887: goto -698 -> 3189
    //   3890: astore 25
    //   3892: aload 26
    //   3894: astore 23
    //   3896: iload 9
    //   3898: istore 4
    //   3900: goto -968 -> 2932
    //   3903: astore 25
    //   3905: iconst_0
    //   3906: istore 4
    //   3908: goto -976 -> 2932
    //   3911: astore 25
    //   3913: aload_0
    //   3914: astore 23
    //   3916: goto -984 -> 2932
    //   3919: astore 25
    //   3921: aload_0
    //   3922: astore 23
    //   3924: goto -992 -> 2932
    //   3927: astore 24
    //   3929: aload_0
    //   3930: astore 23
    //   3932: goto -1250 -> 2682
    //   3935: astore 24
    //   3937: goto -1255 -> 2682
    //   3940: astore 24
    //   3942: aload_0
    //   3943: astore 23
    //   3945: goto -1263 -> 2682
    //   3948: astore_0
    //   3949: goto -1427 -> 2522
    //   3952: astore_0
    //   3953: iconst_0
    //   3954: istore 4
    //   3956: goto -1434 -> 2522
    //   3959: astore 24
    //   3961: aload_0
    //   3962: astore 23
    //   3964: lconst_0
    //   3965: lstore 14
    //   3967: aload 24
    //   3969: astore_0
    //   3970: goto -1448 -> 2522
    //   3973: astore 24
    //   3975: aload 23
    //   3977: astore_0
    //   3978: iconst_5
    //   3979: istore 4
    //   3981: aload 24
    //   3983: astore 23
    //   3985: goto -1517 -> 2468
    //   3988: astore 24
    //   3990: aload 23
    //   3992: astore_0
    //   3993: iconst_0
    //   3994: istore 4
    //   3996: aload 24
    //   3998: astore 23
    //   4000: goto -1532 -> 2468
    //   4003: astore 23
    //   4005: iconst_5
    //   4006: istore 4
    //   4008: goto -1540 -> 2468
    //   4011: aload_3
    //   4012: astore_0
    //   4013: goto -1759 -> 2254
    //   4016: aload_3
    //   4017: astore_0
    //   4018: goto -1764 -> 2254
    //   4021: bipush 8
    //   4023: istore 7
    //   4025: goto -2793 -> 1232
    //   4028: ldc 20
    //   4030: astore 29
    //   4032: goto -2141 -> 1891
    //   4035: iconst_2
    //   4036: istore 4
    //   4038: goto -1273 -> 2765
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	4041	0	paramAppInterface	AppInterface
    //   0	4041	1	paramURL	URL
    //   0	4041	2	paramFile	File
    //   0	4041	3	paramNetworkInfo	NetworkInfo
    //   0	4041	4	paramInt1	int
    //   0	4041	5	paramString	String
    //   0	4041	6	paramInt2	int
    //   27	3997	7	i	int
    //   369	3468	8	j	int
    //   666	3231	9	k	int
    //   673	2733	10	m	int
    //   680	2733	11	n	int
    //   34	2342	12	i1	int
    //   319	2057	13	i2	int
    //   701	3265	14	l1	long
    //   833	3	16	l2	long
    //   3	942	18	l3	long
    //   698	498	20	l4	long
    //   2212	1447	22	bool	boolean
    //   118	2263	23	localObject1	Object
    //   2398	61	23	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   2466	1533	23	localObject2	Object
    //   4003	1	23	localFileNotFoundException1	java.io.FileNotFoundException
    //   129	1988	24	localObject3	Object
    //   2456	9	24	localFileNotFoundException2	java.io.FileNotFoundException
    //   2524	133	24	localObject4	Object
    //   2676	74	24	localIOException1	java.io.IOException
    //   2900	918	24	localObject5	Object
    //   3927	1	24	localIOException2	java.io.IOException
    //   3935	1	24	localIOException3	java.io.IOException
    //   3940	1	24	localIOException4	java.io.IOException
    //   3959	9	24	localIOException5	java.io.IOException
    //   3973	9	24	localFileNotFoundException3	java.io.FileNotFoundException
    //   3988	9	24	localFileNotFoundException4	java.io.FileNotFoundException
    //   365	2780	25	localObject6	Object
    //   3179	62	25	localThrowable1	java.lang.Throwable
    //   3364	494	25	localObject7	Object
    //   3866	1	25	localThrowable2	java.lang.Throwable
    //   3874	1	25	localThrowable3	java.lang.Throwable
    //   3882	1	25	localThrowable4	java.lang.Throwable
    //   3890	1	25	localException1	Exception
    //   3903	1	25	localException2	Exception
    //   3911	1	25	localException3	Exception
    //   3919	1	25	localException4	Exception
    //   362	3531	26	localObject8	Object
    //   676	2733	27	localAppInterface	AppInterface
    //   91	2322	28	localHttpGet	org.apache.http.client.methods.HttpGet
    //   1722	2309	29	localObject9	Object
    //   71	3486	30	str1	String
    //   12	3792	31	localObject10	Object
    //   80	956	32	str2	String
    //   100	2341	33	localBasicHttpParams	org.apache.http.params.BasicHttpParams
    //   279	1849	34	localFile1	File
    //   591	1535	35	arrayOfHeader	Header[]
    //   610	1522	36	localHashMap	java.util.HashMap
    //   1520	564	37	str3	String
    //   1360	520	38	str4	String
    //   1557	1353	39	localFile2	File
    //   1598	158	40	localBitmap	android.graphics.Bitmap
    //   1640	1272	41	localFile3	File
    // Exception table:
    //   from	to	target	type
    //   44	49	2386	java/lang/Exception
    //   53	65	2386	java/lang/Exception
    //   82	93	2398	java/lang/IllegalArgumentException
    //   2400	2414	2417	java/lang/IllegalArgumentException
    //   768	776	2456	java/io/FileNotFoundException
    //   800	805	2456	java/io/FileNotFoundException
    //   829	835	2456	java/io/FileNotFoundException
    //   768	776	2518	java/io/IOException
    //   800	805	2518	java/io/IOException
    //   829	835	2518	java/io/IOException
    //   692	700	2676	java/io/IOException
    //   1142	1148	2676	java/io/IOException
    //   1179	1229	2676	java/io/IOException
    //   1268	1284	2676	java/io/IOException
    //   1315	1324	2676	java/io/IOException
    //   1355	1362	2676	java/io/IOException
    //   1393	1403	2676	java/io/IOException
    //   1434	1444	2676	java/io/IOException
    //   1475	1485	2676	java/io/IOException
    //   1516	1522	2676	java/io/IOException
    //   1553	1559	2676	java/io/IOException
    //   1590	1600	2676	java/io/IOException
    //   1631	1642	2676	java/io/IOException
    //   1678	1688	2676	java/io/IOException
    //   1719	1724	2676	java/io/IOException
    //   1755	1771	2676	java/io/IOException
    //   1802	1808	2676	java/io/IOException
    //   1839	1846	2676	java/io/IOException
    //   1877	1887	2676	java/io/IOException
    //   1922	1933	2676	java/io/IOException
    //   1964	1978	2676	java/io/IOException
    //   2009	2015	2676	java/io/IOException
    //   2046	2094	2676	java/io/IOException
    //   2125	2137	2676	java/io/IOException
    //   2626	2631	2676	java/io/IOException
    //   2665	2673	2676	java/io/IOException
    //   2909	2917	2676	java/io/IOException
    //   3130	3136	2676	java/io/IOException
    //   3167	3176	2676	java/io/IOException
    //   3387	3393	2676	java/io/IOException
    //   3424	3450	2676	java/io/IOException
    //   692	700	2920	java/lang/Exception
    //   727	744	2920	java/lang/Exception
    //   1142	1148	2920	java/lang/Exception
    //   1179	1229	2920	java/lang/Exception
    //   1268	1284	2920	java/lang/Exception
    //   1315	1324	2920	java/lang/Exception
    //   1355	1362	2920	java/lang/Exception
    //   1393	1403	2920	java/lang/Exception
    //   1434	1444	2920	java/lang/Exception
    //   1475	1485	2920	java/lang/Exception
    //   1516	1522	2920	java/lang/Exception
    //   1553	1559	2920	java/lang/Exception
    //   1590	1600	2920	java/lang/Exception
    //   1631	1642	2920	java/lang/Exception
    //   1678	1688	2920	java/lang/Exception
    //   1719	1724	2920	java/lang/Exception
    //   1755	1771	2920	java/lang/Exception
    //   1802	1808	2920	java/lang/Exception
    //   1839	1846	2920	java/lang/Exception
    //   1877	1887	2920	java/lang/Exception
    //   1922	1933	2920	java/lang/Exception
    //   1964	1978	2920	java/lang/Exception
    //   2009	2015	2920	java/lang/Exception
    //   2046	2094	2920	java/lang/Exception
    //   2125	2137	2920	java/lang/Exception
    //   2626	2631	2920	java/lang/Exception
    //   2665	2673	2920	java/lang/Exception
    //   2909	2917	2920	java/lang/Exception
    //   3130	3136	2920	java/lang/Exception
    //   3167	3176	2920	java/lang/Exception
    //   3387	3393	2920	java/lang/Exception
    //   3424	3450	2920	java/lang/Exception
    //   692	700	3179	java/lang/Throwable
    //   727	744	3179	java/lang/Throwable
    //   1142	1148	3179	java/lang/Throwable
    //   1179	1229	3179	java/lang/Throwable
    //   1268	1284	3179	java/lang/Throwable
    //   1315	1324	3179	java/lang/Throwable
    //   1355	1362	3179	java/lang/Throwable
    //   1393	1403	3179	java/lang/Throwable
    //   1434	1444	3179	java/lang/Throwable
    //   1475	1485	3179	java/lang/Throwable
    //   1516	1522	3179	java/lang/Throwable
    //   1553	1559	3179	java/lang/Throwable
    //   1590	1600	3179	java/lang/Throwable
    //   1631	1642	3179	java/lang/Throwable
    //   1678	1688	3179	java/lang/Throwable
    //   1719	1724	3179	java/lang/Throwable
    //   1755	1771	3179	java/lang/Throwable
    //   1802	1808	3179	java/lang/Throwable
    //   1839	1846	3179	java/lang/Throwable
    //   1877	1887	3179	java/lang/Throwable
    //   1922	1933	3179	java/lang/Throwable
    //   1964	1978	3179	java/lang/Throwable
    //   2009	2015	3179	java/lang/Throwable
    //   2046	2094	3179	java/lang/Throwable
    //   2125	2137	3179	java/lang/Throwable
    //   2626	2631	3179	java/lang/Throwable
    //   2665	2673	3179	java/lang/Throwable
    //   2909	2917	3179	java/lang/Throwable
    //   3130	3136	3179	java/lang/Throwable
    //   3167	3176	3179	java/lang/Throwable
    //   3387	3393	3179	java/lang/Throwable
    //   3424	3450	3179	java/lang/Throwable
    //   692	700	3453	finally
    //   727	744	3453	finally
    //   1142	1148	3453	finally
    //   1179	1229	3453	finally
    //   1268	1284	3453	finally
    //   1315	1324	3453	finally
    //   1355	1362	3453	finally
    //   1393	1403	3453	finally
    //   1434	1444	3453	finally
    //   1475	1485	3453	finally
    //   1516	1522	3453	finally
    //   1553	1559	3453	finally
    //   1590	1600	3453	finally
    //   1631	1642	3453	finally
    //   1678	1688	3453	finally
    //   1719	1724	3453	finally
    //   1755	1771	3453	finally
    //   1802	1808	3453	finally
    //   1839	1846	3453	finally
    //   1877	1887	3453	finally
    //   1922	1933	3453	finally
    //   1964	1978	3453	finally
    //   2009	2015	3453	finally
    //   2046	2094	3453	finally
    //   2125	2137	3453	finally
    //   2626	2631	3453	finally
    //   2665	2673	3453	finally
    //   2909	2917	3453	finally
    //   2943	2949	3453	finally
    //   2960	2988	3453	finally
    //   3130	3136	3453	finally
    //   3167	3176	3453	finally
    //   3200	3206	3453	finally
    //   3217	3245	3453	finally
    //   3387	3393	3453	finally
    //   3424	3450	3453	finally
    //   2148	2154	3579	java/io/IOException
    //   2180	2185	3593	java/lang/Exception
    //   2189	2201	3593	java/lang/Exception
    //   2201	2252	3593	java/lang/Exception
    //   2769	2775	3676	java/io/IOException
    //   2801	2806	3690	java/lang/Exception
    //   2810	2822	3690	java/lang/Exception
    //   2822	2873	3690	java/lang/Exception
    //   2992	2998	3696	java/io/IOException
    //   3019	3024	3710	java/lang/Exception
    //   3028	3040	3710	java/lang/Exception
    //   3040	3091	3710	java/lang/Exception
    //   3249	3255	3719	java/io/IOException
    //   3276	3281	3733	java/lang/Exception
    //   3285	3297	3733	java/lang/Exception
    //   3297	3348	3733	java/lang/Exception
    //   3464	3470	3742	java/io/IOException
    //   2335	2343	3802	finally
    //   2343	2346	3802	finally
    //   3803	3806	3802	finally
    //   2335	2343	3808	java/lang/InterruptedException
    //   3495	3500	3812	java/lang/Exception
    //   3504	3516	3812	java/lang/Exception
    //   3516	3567	3812	java/lang/Exception
    //   768	776	3816	finally
    //   800	805	3816	finally
    //   829	835	3816	finally
    //   863	871	3816	finally
    //   895	901	3816	finally
    //   925	977	3816	finally
    //   2546	2552	3816	finally
    //   2576	2586	3816	finally
    //   993	1022	3823	finally
    //   1034	1080	3823	finally
    //   2468	2515	3833	finally
    //   371	380	3841	finally
    //   395	404	3841	finally
    //   414	437	3841	finally
    //   447	453	3841	finally
    //   463	472	3841	finally
    //   482	491	3841	finally
    //   501	524	3841	finally
    //   534	555	3841	finally
    //   565	574	3841	finally
    //   584	593	3841	finally
    //   603	612	3841	finally
    //   622	631	3841	finally
    //   641	650	3841	finally
    //   2693	2699	3841	finally
    //   2710	2738	3841	finally
    //   2749	2756	3841	finally
    //   3610	3618	3841	finally
    //   3629	3637	3841	finally
    //   3651	3658	3841	finally
    //   768	776	3851	java/lang/Throwable
    //   800	805	3851	java/lang/Throwable
    //   829	835	3851	java/lang/Throwable
    //   863	871	3851	java/lang/Throwable
    //   895	901	3851	java/lang/Throwable
    //   925	977	3851	java/lang/Throwable
    //   2546	2552	3851	java/lang/Throwable
    //   2576	2586	3851	java/lang/Throwable
    //   993	1022	3866	java/lang/Throwable
    //   1034	1080	3866	java/lang/Throwable
    //   2468	2515	3874	java/lang/Throwable
    //   371	380	3882	java/lang/Throwable
    //   395	404	3882	java/lang/Throwable
    //   414	437	3882	java/lang/Throwable
    //   447	453	3882	java/lang/Throwable
    //   463	472	3882	java/lang/Throwable
    //   482	491	3882	java/lang/Throwable
    //   501	524	3882	java/lang/Throwable
    //   534	555	3882	java/lang/Throwable
    //   565	574	3882	java/lang/Throwable
    //   584	593	3882	java/lang/Throwable
    //   603	612	3882	java/lang/Throwable
    //   622	631	3882	java/lang/Throwable
    //   641	650	3882	java/lang/Throwable
    //   768	776	3890	java/lang/Exception
    //   800	805	3890	java/lang/Exception
    //   829	835	3890	java/lang/Exception
    //   863	871	3890	java/lang/Exception
    //   895	901	3890	java/lang/Exception
    //   925	977	3890	java/lang/Exception
    //   2546	2552	3890	java/lang/Exception
    //   2576	2586	3890	java/lang/Exception
    //   993	1022	3903	java/lang/Exception
    //   1034	1080	3903	java/lang/Exception
    //   2468	2515	3911	java/lang/Exception
    //   371	380	3919	java/lang/Exception
    //   395	404	3919	java/lang/Exception
    //   414	437	3919	java/lang/Exception
    //   447	453	3919	java/lang/Exception
    //   463	472	3919	java/lang/Exception
    //   482	491	3919	java/lang/Exception
    //   501	524	3919	java/lang/Exception
    //   534	555	3919	java/lang/Exception
    //   565	574	3919	java/lang/Exception
    //   584	593	3919	java/lang/Exception
    //   603	612	3919	java/lang/Exception
    //   622	631	3919	java/lang/Exception
    //   641	650	3919	java/lang/Exception
    //   2468	2515	3927	java/io/IOException
    //   2546	2552	3935	java/io/IOException
    //   2576	2586	3935	java/io/IOException
    //   371	380	3940	java/io/IOException
    //   395	404	3940	java/io/IOException
    //   414	437	3940	java/io/IOException
    //   447	453	3940	java/io/IOException
    //   463	472	3940	java/io/IOException
    //   482	491	3940	java/io/IOException
    //   501	524	3940	java/io/IOException
    //   534	555	3940	java/io/IOException
    //   565	574	3940	java/io/IOException
    //   584	593	3940	java/io/IOException
    //   603	612	3940	java/io/IOException
    //   622	631	3940	java/io/IOException
    //   641	650	3940	java/io/IOException
    //   863	871	3948	java/io/IOException
    //   895	901	3948	java/io/IOException
    //   925	977	3948	java/io/IOException
    //   993	1022	3952	java/io/IOException
    //   1034	1080	3952	java/io/IOException
    //   727	744	3959	java/io/IOException
    //   863	871	3973	java/io/FileNotFoundException
    //   895	901	3973	java/io/FileNotFoundException
    //   925	977	3973	java/io/FileNotFoundException
    //   993	1022	3988	java/io/FileNotFoundException
    //   1034	1080	3988	java/io/FileNotFoundException
    //   727	744	4003	java/io/FileNotFoundException
  }
  
  public static boolean download(AppInterface paramAppInterface, String paramString1, File paramFile, String paramString2, int paramInt)
  {
    NetworkInfo localNetworkInfo = AppNetConnInfo.getRecentNetworkInfo();
    if (localNetworkInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("QZoneHttpDownloadUtil", 2, "Download failed-----------activeNetworkInfo is null");
      }
      return false;
    }
    paramString1 = getFilterUrl(paramString1);
    for (;;)
    {
      try
      {
        paramString1 = new URL(paramString1);
        paramInt = download(paramAppInterface, paramString1, paramFile, localNetworkInfo, 2, paramString2, paramInt);
        if (QLog.isColorLevel()) {
          QLog.i("QZoneHttpDownloadUtil", 2, paramString2 + "\nurl = " + paramString1.toString() + "\nRESULT_CODE = " + paramInt);
        }
        if (paramInt == 0)
        {
          bool = true;
          return bool;
        }
      }
      catch (MalformedURLException paramAppInterface)
      {
        paramAppInterface.printStackTrace();
        return false;
      }
      boolean bool = false;
    }
  }
  
  private static String encodeFile(String paramString, boolean paramBoolean)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return "";
    }
    localObject3 = new File(paramString);
    if ((!((File)localObject3).exists()) || (!((File)localObject3).isFile()))
    {
      QLog.w("QZoneHttpDownloadUtil", 2, "encode-File does not exist or is not file:" + paramString);
      return "";
    }
    localObject2 = null;
    paramString = null;
    str2 = paramString;
    localObject1 = localObject2;
    try
    {
      localObject3 = new BufferedInputStream(new FileInputStream((File)localObject3), 8192);
      if (!paramBoolean) {
        break label226;
      }
      str2 = paramString;
      localObject1 = localObject2;
      paramString = new GZIPInputStream((InputStream)localObject3);
    }
    catch (Exception paramString) {}finally
    {
      int i;
      String str1;
      ((IDataUtils)QRoute.api(IDataUtils.class)).closeDataObject(str1);
    }
    str2 = paramString;
    localObject1 = paramString;
    localObject3 = MessageDigest.getInstance("MD5");
    str2 = paramString;
    localObject1 = paramString;
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
    if ((paramString == null) || (paramString.length() == 0)) {}
    for (;;)
    {
      return null;
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
  }
  
  public static String getValueByName(String paramString1, String paramString2)
  {
    String str2 = "";
    String str1 = str2;
    if (paramString1 != null)
    {
      str1 = str2;
      if (paramString1.length() != 0)
      {
        str1 = str2;
        if (paramString2 != null)
        {
          if (paramString2.length() != 0) {
            break label46;
          }
          str1 = str2;
        }
      }
    }
    return str1;
    label46:
    String[] arrayOfString = paramString1.substring(paramString1.indexOf("?") + 1).split("\\&");
    int j = arrayOfString.length;
    int i = 0;
    paramString1 = str2;
    for (;;)
    {
      str1 = paramString1;
      if (i >= j) {
        break;
      }
      str1 = arrayOfString[i];
      if (str1.contains(paramString2)) {
        paramString1 = str1.replace(paramString2 + "=", "");
      }
      i += 1;
    }
  }
  
  /* Error */
  private static boolean saveHeadersToFile(Header[] paramArrayOfHeader, File paramFile, String paramString, java.util.HashMap<String, String> paramHashMap)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 7
    //   3: iconst_1
    //   4: istore 8
    //   6: iconst_1
    //   7: istore 6
    //   9: aload_0
    //   10: ifnonnull +5 -> 15
    //   13: iconst_0
    //   14: ireturn
    //   15: new 631	org/json/JSONObject
    //   18: dup
    //   19: invokespecial 632	org/json/JSONObject:<init>	()V
    //   22: astore 13
    //   24: aload_0
    //   25: arraylength
    //   26: istore 5
    //   28: iload 5
    //   30: ifle -17 -> 13
    //   33: new 292	java/io/FileOutputStream
    //   36: dup
    //   37: aload_1
    //   38: invokespecial 295	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   41: astore 10
    //   43: iconst_0
    //   44: istore 4
    //   46: iload 4
    //   48: iload 5
    //   50: if_icmpge +296 -> 346
    //   53: aload_0
    //   54: iload 4
    //   56: aaload
    //   57: astore 11
    //   59: iload 6
    //   61: istore 7
    //   63: aload 10
    //   65: astore 9
    //   67: aload 11
    //   69: invokeinterface 604 1 0
    //   74: astore 14
    //   76: iload 6
    //   78: istore 7
    //   80: aload 10
    //   82: astore 9
    //   84: aload 11
    //   86: invokeinterface 607 1 0
    //   91: astore 12
    //   93: aload 12
    //   95: astore 11
    //   97: aload_3
    //   98: ifnull +43 -> 141
    //   101: aload 12
    //   103: astore 11
    //   105: iload 6
    //   107: istore 7
    //   109: aload 10
    //   111: astore 9
    //   113: aload_3
    //   114: aload 14
    //   116: invokevirtual 635	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   119: ifeq +22 -> 141
    //   122: iload 6
    //   124: istore 7
    //   126: aload 10
    //   128: astore 9
    //   130: aload_3
    //   131: aload 14
    //   133: invokevirtual 639	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   136: checkcast 72	java/lang/String
    //   139: astore 11
    //   141: iload 6
    //   143: istore 7
    //   145: aload 10
    //   147: astore 9
    //   149: ldc_w 641
    //   152: aload 14
    //   154: invokevirtual 345	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   157: ifne +450 -> 607
    //   160: iload 6
    //   162: istore 7
    //   164: aload 10
    //   166: astore 9
    //   168: ldc_w 643
    //   171: aload 14
    //   173: invokevirtual 345	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   176: ifne +431 -> 607
    //   179: iload 6
    //   181: istore 7
    //   183: aload 10
    //   185: astore 9
    //   187: ldc_w 645
    //   190: aload 14
    //   192: invokevirtual 345	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   195: ifeq +6 -> 201
    //   198: goto +409 -> 607
    //   201: iload 6
    //   203: istore 7
    //   205: aload 10
    //   207: astore 9
    //   209: aload_2
    //   210: invokestatic 648	cooperation/qzone/webviewplugin/QzoneOfflinePluginJsForQQ:checkDownloadFont	(Ljava/lang/String;)Z
    //   213: ifeq +29 -> 242
    //   216: iload 6
    //   218: istore 7
    //   220: aload 10
    //   222: astore 9
    //   224: ldc_w 338
    //   227: aload 14
    //   229: invokevirtual 345	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   232: istore 8
    //   234: iload 8
    //   236: ifeq +6 -> 242
    //   239: goto +368 -> 607
    //   242: iload 6
    //   244: istore 7
    //   246: aload 10
    //   248: astore 9
    //   250: aload 13
    //   252: aload 14
    //   254: aload 11
    //   256: invokevirtual 651	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   259: pop
    //   260: iload 6
    //   262: istore 7
    //   264: aload 10
    //   266: astore 9
    //   268: new 201	java/lang/StringBuilder
    //   271: dup
    //   272: invokespecial 202	java/lang/StringBuilder:<init>	()V
    //   275: ldc_w 653
    //   278: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: aload 14
    //   283: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: ldc_w 655
    //   289: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: aload 11
    //   294: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   300: invokestatic 239	cooperation/qzone/webviewplugin/QzoneOfflinePluginJsForQQ:detaillog	(Ljava/lang/String;)V
    //   303: goto +304 -> 607
    //   306: astore 11
    //   308: iload 6
    //   310: istore 7
    //   312: aload 10
    //   314: astore 9
    //   316: invokestatic 316	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   319: ifeq +297 -> 616
    //   322: iload 6
    //   324: istore 7
    //   326: aload 10
    //   328: astore 9
    //   330: ldc 30
    //   332: iconst_2
    //   333: aload 11
    //   335: invokevirtual 658	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   338: aload 11
    //   340: invokestatic 480	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   343: goto +273 -> 616
    //   346: iload 6
    //   348: ifeq +56 -> 404
    //   351: iload 6
    //   353: istore 7
    //   355: aload 10
    //   357: astore 9
    //   359: aload 10
    //   361: aload 13
    //   363: invokevirtual 659	org/json/JSONObject:toString	()Ljava/lang/String;
    //   366: ldc_w 661
    //   369: invokevirtual 665	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   372: invokevirtual 669	java/io/FileOutputStream:write	([B)V
    //   375: iload 6
    //   377: istore 7
    //   379: aload 10
    //   381: astore 9
    //   383: aload 10
    //   385: invokevirtual 670	java/io/FileOutputStream:flush	()V
    //   388: iload 6
    //   390: istore 7
    //   392: aload 10
    //   394: astore 9
    //   396: aload_1
    //   397: invokestatic 95	java/lang/System:currentTimeMillis	()J
    //   400: invokevirtual 313	java/io/File:setLastModified	(J)Z
    //   403: pop
    //   404: ldc_w 437
    //   407: invokestatic 443	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   410: checkcast 437	com/tencent/qzonehub/api/IDataUtils
    //   413: aload 10
    //   415: invokeinterface 446 2 0
    //   420: pop
    //   421: iload 6
    //   423: ireturn
    //   424: astore_0
    //   425: aconst_null
    //   426: astore 10
    //   428: iload 7
    //   430: istore 6
    //   432: iload 6
    //   434: istore 7
    //   436: aload 10
    //   438: astore 9
    //   440: ldc 30
    //   442: iconst_1
    //   443: new 201	java/lang/StringBuilder
    //   446: dup
    //   447: invokespecial 202	java/lang/StringBuilder:<init>	()V
    //   450: ldc_w 475
    //   453: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   456: aload_1
    //   457: invokevirtual 116	java/io/File:exists	()Z
    //   460: invokevirtual 451	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   463: ldc_w 477
    //   466: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   469: aload_1
    //   470: invokevirtual 112	java/io/File:getParentFile	()Ljava/io/File;
    //   473: invokevirtual 116	java/io/File:exists	()Z
    //   476: invokevirtual 451	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   479: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   482: invokestatic 106	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   485: ldc_w 437
    //   488: invokestatic 443	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   491: checkcast 437	com/tencent/qzonehub/api/IDataUtils
    //   494: aload 10
    //   496: invokeinterface 446 2 0
    //   501: pop
    //   502: iconst_0
    //   503: ireturn
    //   504: astore_0
    //   505: aconst_null
    //   506: astore 10
    //   508: iload 8
    //   510: istore 6
    //   512: iload 6
    //   514: istore 7
    //   516: aload 10
    //   518: astore 9
    //   520: invokestatic 316	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   523: ifeq +22 -> 545
    //   526: iload 6
    //   528: istore 7
    //   530: aload 10
    //   532: astore 9
    //   534: ldc 30
    //   536: iconst_2
    //   537: aload_0
    //   538: invokevirtual 671	java/io/IOException:getMessage	()Ljava/lang/String;
    //   541: aload_0
    //   542: invokestatic 480	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   545: ldc_w 437
    //   548: invokestatic 443	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   551: checkcast 437	com/tencent/qzonehub/api/IDataUtils
    //   554: aload 10
    //   556: invokeinterface 446 2 0
    //   561: pop
    //   562: iconst_0
    //   563: ireturn
    //   564: astore_0
    //   565: iconst_1
    //   566: istore 6
    //   568: aconst_null
    //   569: astore 9
    //   571: ldc_w 437
    //   574: invokestatic 443	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   577: checkcast 437	com/tencent/qzonehub/api/IDataUtils
    //   580: aload 9
    //   582: invokeinterface 446 2 0
    //   587: pop
    //   588: iload 6
    //   590: ireturn
    //   591: astore_0
    //   592: iload 7
    //   594: istore 6
    //   596: goto -25 -> 571
    //   599: astore_0
    //   600: goto -88 -> 512
    //   603: astore_0
    //   604: goto -172 -> 432
    //   607: iload 4
    //   609: iconst_1
    //   610: iadd
    //   611: istore 4
    //   613: goto -567 -> 46
    //   616: iconst_0
    //   617: istore 6
    //   619: goto -12 -> 607
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	622	0	paramArrayOfHeader	Header[]
    //   0	622	1	paramFile	File
    //   0	622	2	paramString	String
    //   0	622	3	paramHashMap	java.util.HashMap<String, String>
    //   44	568	4	i	int
    //   26	25	5	j	int
    //   7	611	6	bool1	boolean
    //   1	592	7	bool2	boolean
    //   4	505	8	bool3	boolean
    //   65	516	9	localFileOutputStream1	java.io.FileOutputStream
    //   41	514	10	localFileOutputStream2	java.io.FileOutputStream
    //   57	236	11	localObject	Object
    //   306	33	11	localJSONException	org.json.JSONException
    //   91	11	12	str1	String
    //   22	340	13	localJSONObject	org.json.JSONObject
    //   74	208	14	str2	String
    // Exception table:
    //   from	to	target	type
    //   250	260	306	org/json/JSONException
    //   268	303	306	org/json/JSONException
    //   33	43	424	java/io/FileNotFoundException
    //   33	43	504	java/io/IOException
    //   33	43	564	finally
    //   67	76	591	finally
    //   84	93	591	finally
    //   113	122	591	finally
    //   130	141	591	finally
    //   149	160	591	finally
    //   168	179	591	finally
    //   187	198	591	finally
    //   209	216	591	finally
    //   224	234	591	finally
    //   250	260	591	finally
    //   268	303	591	finally
    //   316	322	591	finally
    //   330	343	591	finally
    //   359	375	591	finally
    //   383	388	591	finally
    //   396	404	591	finally
    //   440	485	591	finally
    //   520	526	591	finally
    //   534	545	591	finally
    //   67	76	599	java/io/IOException
    //   84	93	599	java/io/IOException
    //   113	122	599	java/io/IOException
    //   130	141	599	java/io/IOException
    //   149	160	599	java/io/IOException
    //   168	179	599	java/io/IOException
    //   187	198	599	java/io/IOException
    //   209	216	599	java/io/IOException
    //   224	234	599	java/io/IOException
    //   250	260	599	java/io/IOException
    //   268	303	599	java/io/IOException
    //   316	322	599	java/io/IOException
    //   330	343	599	java/io/IOException
    //   359	375	599	java/io/IOException
    //   383	388	599	java/io/IOException
    //   396	404	599	java/io/IOException
    //   67	76	603	java/io/FileNotFoundException
    //   84	93	603	java/io/FileNotFoundException
    //   113	122	603	java/io/FileNotFoundException
    //   130	141	603	java/io/FileNotFoundException
    //   149	160	603	java/io/FileNotFoundException
    //   168	179	603	java/io/FileNotFoundException
    //   187	198	603	java/io/FileNotFoundException
    //   209	216	603	java/io/FileNotFoundException
    //   224	234	603	java/io/FileNotFoundException
    //   250	260	603	java/io/FileNotFoundException
    //   268	303	603	java/io/FileNotFoundException
    //   316	322	603	java/io/FileNotFoundException
    //   330	343	603	java/io/FileNotFoundException
    //   359	375	603	java/io/FileNotFoundException
    //   383	388	603	java/io/FileNotFoundException
    //   396	404	603	java/io/FileNotFoundException
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.util.QZoneHttpDownloadUtil
 * JD-Core Version:    0.7.0.1
 */