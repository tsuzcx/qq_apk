package cooperation.qzone.util;

import android.net.NetworkInfo;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.QLog;
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
    //   15: ifnonnull +13 -> 28
    //   18: ldc 30
    //   20: iconst_1
    //   21: ldc 100
    //   23: invokestatic 106	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   26: iconst_4
    //   27: ireturn
    //   28: iload 4
    //   30: istore 12
    //   32: iload 4
    //   34: ifge +6 -> 40
    //   37: iconst_2
    //   38: istore 12
    //   40: aload_2
    //   41: invokevirtual 112	java/io/File:getParentFile	()Ljava/io/File;
    //   44: astore_0
    //   45: aload_0
    //   46: ifnull +15 -> 61
    //   49: aload_0
    //   50: invokevirtual 116	java/io/File:exists	()Z
    //   53: ifne +8 -> 61
    //   56: aload_0
    //   57: invokevirtual 119	java/io/File:mkdirs	()Z
    //   60: pop
    //   61: aconst_null
    //   62: astore_0
    //   63: aload_1
    //   64: invokevirtual 125	java/net/URL:toString	()Ljava/lang/String;
    //   67: astore 30
    //   69: aload 30
    //   71: ldc 127
    //   73: invokestatic 131	cooperation/qzone/util/QZoneHttpDownloadUtil:getValueByName	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   76: astore 32
    //   78: new 133	org/apache/http/client/methods/HttpGet
    //   81: dup
    //   82: aload 30
    //   84: invokespecial 136	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   87: astore 28
    //   89: new 138	org/apache/http/params/BasicHttpParams
    //   92: dup
    //   93: invokespecial 139	org/apache/http/params/BasicHttpParams:<init>	()V
    //   96: astore 33
    //   98: sipush 20000
    //   101: istore 7
    //   103: ldc 140
    //   105: istore 4
    //   107: aload_3
    //   108: ifnull +101 -> 209
    //   111: invokestatic 145	android/net/Proxy:getDefaultHost	()Ljava/lang/String;
    //   114: astore 23
    //   116: invokestatic 149	android/net/Proxy:getDefaultPort	()I
    //   119: istore 4
    //   121: aload_3
    //   122: invokevirtual 154	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   125: astore 24
    //   127: aload_3
    //   128: invokestatic 160	com/tencent/mobileqq/utils/NetworkUtil:isMobileNetworkInfo	(Landroid/net/NetworkInfo;)Z
    //   131: ifeq +49 -> 180
    //   134: aload 24
    //   136: ifnull +13 -> 149
    //   139: aload 24
    //   141: ldc 162
    //   143: invokevirtual 166	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   146: ifeq +34 -> 180
    //   149: aload 23
    //   151: ifnull +29 -> 180
    //   154: iload 4
    //   156: ifle +24 -> 180
    //   159: aload 33
    //   161: ldc 168
    //   163: new 170	org/apache/http/HttpHost
    //   166: dup
    //   167: aload 23
    //   169: iload 4
    //   171: invokespecial 173	org/apache/http/HttpHost:<init>	(Ljava/lang/String;I)V
    //   174: invokeinterface 179 3 0
    //   179: pop
    //   180: aload_3
    //   181: invokestatic 160	com/tencent/mobileqq/utils/NetworkUtil:isMobileNetworkInfo	(Landroid/net/NetworkInfo;)Z
    //   184: ifeq +2217 -> 2401
    //   187: sipush 20000
    //   190: istore 7
    //   192: ldc 140
    //   194: istore 4
    //   196: aload 33
    //   198: ldc 181
    //   200: sipush 2048
    //   203: invokeinterface 185 3 0
    //   208: pop
    //   209: aload 33
    //   211: ldc 187
    //   213: iload 7
    //   215: invokestatic 193	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   218: invokeinterface 179 3 0
    //   223: pop
    //   224: aload 33
    //   226: ldc 195
    //   228: iload 4
    //   230: invokestatic 193	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   233: invokeinterface 179 3 0
    //   238: pop
    //   239: aload 28
    //   241: aload 33
    //   243: invokevirtual 199	org/apache/http/client/methods/HttpGet:setParams	(Lorg/apache/http/params/HttpParams;)V
    //   246: new 108	java/io/File
    //   249: dup
    //   250: new 201	java/lang/StringBuilder
    //   253: dup
    //   254: invokespecial 202	java/lang/StringBuilder:<init>	()V
    //   257: aload_2
    //   258: invokevirtual 205	java/io/File:getPath	()Ljava/lang/String;
    //   261: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: ldc 211
    //   266: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   272: invokespecial 213	java/io/File:<init>	(Ljava/lang/String;)V
    //   275: astore 34
    //   277: aload_2
    //   278: ifnull +15 -> 293
    //   281: aload_2
    //   282: invokevirtual 116	java/io/File:exists	()Z
    //   285: ifeq +8 -> 293
    //   288: aload_2
    //   289: invokevirtual 216	java/io/File:delete	()Z
    //   292: pop
    //   293: aload 34
    //   295: ifnull +17 -> 312
    //   298: aload 34
    //   300: invokevirtual 116	java/io/File:exists	()Z
    //   303: ifeq +9 -> 312
    //   306: aload 34
    //   308: invokevirtual 216	java/io/File:delete	()Z
    //   311: pop
    //   312: aconst_null
    //   313: astore_3
    //   314: iconst_m1
    //   315: istore 13
    //   317: iload 13
    //   319: ifne +35 -> 354
    //   322: aload 33
    //   324: ldc 168
    //   326: new 170	org/apache/http/HttpHost
    //   329: dup
    //   330: aload_1
    //   331: invokevirtual 219	java/net/URL:getHost	()Ljava/lang/String;
    //   334: aload_1
    //   335: invokevirtual 222	java/net/URL:getPort	()I
    //   338: invokespecial 173	org/apache/http/HttpHost:<init>	(Ljava/lang/String;I)V
    //   341: invokeinterface 179 3 0
    //   346: pop
    //   347: aload 28
    //   349: aload 33
    //   351: invokevirtual 199	org/apache/http/client/methods/HttpGet:setParams	(Lorg/apache/http/params/HttpParams;)V
    //   354: iconst_5
    //   355: istore 4
    //   357: aload_3
    //   358: astore 26
    //   360: aload_0
    //   361: astore 25
    //   363: iload 4
    //   365: istore 8
    //   367: aload 30
    //   369: iload 6
    //   371: invokestatic 228	cooperation/qzone/webviewplugin/QzoneOfflinePluginJsForQQ:getMimeTypeFromUrl	(Ljava/lang/String;I)Ljava/lang/String;
    //   374: astore 23
    //   376: aload 23
    //   378: ifnull +55 -> 433
    //   381: aload_3
    //   382: astore 26
    //   384: aload_0
    //   385: astore 25
    //   387: iload 4
    //   389: istore 8
    //   391: aload 28
    //   393: ldc 230
    //   395: aload 23
    //   397: invokevirtual 234	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   400: aload_3
    //   401: astore 26
    //   403: aload_0
    //   404: astore 25
    //   406: iload 4
    //   408: istore 8
    //   410: new 201	java/lang/StringBuilder
    //   413: dup
    //   414: invokespecial 202	java/lang/StringBuilder:<init>	()V
    //   417: ldc 236
    //   419: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   422: aload 23
    //   424: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   430: invokestatic 239	cooperation/qzone/webviewplugin/QzoneOfflinePluginJsForQQ:detaillog	(Ljava/lang/String;)V
    //   433: aload_3
    //   434: astore 26
    //   436: aload_0
    //   437: astore 25
    //   439: iload 4
    //   441: istore 8
    //   443: invokestatic 242	cooperation/qzone/webviewplugin/QzoneOfflinePluginJsForQQ:isSupportGZIP	()Z
    //   446: ifeq +22 -> 468
    //   449: aload_3
    //   450: astore 26
    //   452: aload_0
    //   453: astore 25
    //   455: iload 4
    //   457: istore 8
    //   459: aload 28
    //   461: ldc 244
    //   463: ldc 246
    //   465: invokevirtual 234	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   468: aload_3
    //   469: astore 26
    //   471: aload_0
    //   472: astore 25
    //   474: iload 4
    //   476: istore 8
    //   478: aload 28
    //   480: ldc 248
    //   482: aload 5
    //   484: invokevirtual 234	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   487: aload_3
    //   488: astore 26
    //   490: aload_0
    //   491: astore 25
    //   493: iload 4
    //   495: istore 8
    //   497: new 201	java/lang/StringBuilder
    //   500: dup
    //   501: invokespecial 202	java/lang/StringBuilder:<init>	()V
    //   504: ldc 250
    //   506: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   509: aload 5
    //   511: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   514: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   517: invokestatic 239	cooperation/qzone/webviewplugin/QzoneOfflinePluginJsForQQ:detaillog	(Ljava/lang/String;)V
    //   520: aload_3
    //   521: astore 26
    //   523: aload_0
    //   524: astore 25
    //   526: iload 4
    //   528: istore 8
    //   530: getstatic 254	cooperation/qzone/util/QZoneHttpDownloadUtil:client	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   533: new 170	org/apache/http/HttpHost
    //   536: dup
    //   537: aload_1
    //   538: invokevirtual 219	java/net/URL:getHost	()Ljava/lang/String;
    //   541: invokespecial 255	org/apache/http/HttpHost:<init>	(Ljava/lang/String;)V
    //   544: aload 28
    //   546: invokevirtual 261	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/HttpHost;Lorg/apache/http/HttpRequest;)Lorg/apache/http/HttpResponse;
    //   549: astore 23
    //   551: aload_3
    //   552: astore 26
    //   554: aload_0
    //   555: astore 25
    //   557: iload 4
    //   559: istore 8
    //   561: aload 23
    //   563: invokeinterface 267 1 0
    //   568: astore 24
    //   570: aload_3
    //   571: astore 26
    //   573: aload_0
    //   574: astore 25
    //   576: iload 4
    //   578: istore 8
    //   580: aload 23
    //   582: invokeinterface 271 1 0
    //   587: astore 35
    //   589: aload_3
    //   590: astore 26
    //   592: aload_0
    //   593: astore 25
    //   595: iload 4
    //   597: istore 8
    //   599: new 273	java/util/HashMap
    //   602: dup
    //   603: invokespecial 274	java/util/HashMap:<init>	()V
    //   606: astore 36
    //   608: aload_3
    //   609: astore 26
    //   611: aload_0
    //   612: astore 25
    //   614: iload 4
    //   616: istore 8
    //   618: aload 24
    //   620: invokeinterface 279 1 0
    //   625: istore 9
    //   627: aload_3
    //   628: astore 26
    //   630: aload_0
    //   631: astore 25
    //   633: iload 4
    //   635: istore 8
    //   637: aload 23
    //   639: invokeinterface 283 1 0
    //   644: astore 23
    //   646: aload 23
    //   648: astore_3
    //   649: iload 9
    //   651: istore 7
    //   653: aload_0
    //   654: astore 24
    //   656: sipush 200
    //   659: iload 9
    //   661: if_icmpne +1482 -> 2143
    //   664: aload_0
    //   665: astore 23
    //   667: iload 4
    //   669: istore 9
    //   671: aload_0
    //   672: astore 25
    //   674: iload 4
    //   676: istore 10
    //   678: aload_0
    //   679: astore 27
    //   681: iload 4
    //   683: istore 11
    //   685: aload_0
    //   686: astore 24
    //   688: iload 4
    //   690: istore 8
    //   692: aload_3
    //   693: astore 26
    //   695: aload_3
    //   696: invokeinterface 288 1 0
    //   701: lstore 20
    //   703: lconst_0
    //   704: lstore 14
    //   706: aload_0
    //   707: astore 25
    //   709: iload 4
    //   711: istore 10
    //   713: aload_0
    //   714: astore 27
    //   716: iload 4
    //   718: istore 11
    //   720: aload_0
    //   721: astore 24
    //   723: iload 4
    //   725: istore 8
    //   727: aload_3
    //   728: astore 26
    //   730: new 290	java/io/BufferedOutputStream
    //   733: dup
    //   734: new 292	java/io/FileOutputStream
    //   737: dup
    //   738: aload_2
    //   739: invokespecial 295	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   742: invokespecial 298	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   745: astore 23
    //   747: aload 23
    //   749: astore 24
    //   751: iload 4
    //   753: istore 8
    //   755: aload 23
    //   757: astore 25
    //   759: iload 4
    //   761: istore 7
    //   763: aload 23
    //   765: astore 26
    //   767: iload 4
    //   769: istore 9
    //   771: aload_3
    //   772: aload 23
    //   774: invokeinterface 301 2 0
    //   779: aload 23
    //   781: astore 24
    //   783: iload 4
    //   785: istore 8
    //   787: aload 23
    //   789: astore 25
    //   791: iload 4
    //   793: istore 7
    //   795: aload 23
    //   797: astore 26
    //   799: iload 4
    //   801: istore 9
    //   803: aload 23
    //   805: invokevirtual 306	java/io/OutputStream:flush	()V
    //   808: aload 23
    //   810: astore 24
    //   812: iload 4
    //   814: istore 8
    //   816: aload 23
    //   818: astore 25
    //   820: iload 4
    //   822: istore 7
    //   824: aload 23
    //   826: astore 26
    //   828: iload 4
    //   830: istore 9
    //   832: aload_2
    //   833: invokevirtual 309	java/io/File:length	()J
    //   836: lstore 16
    //   838: lload 16
    //   840: lstore 14
    //   842: aload 23
    //   844: astore 24
    //   846: iload 4
    //   848: istore 8
    //   850: aload 23
    //   852: astore 25
    //   854: iload 4
    //   856: istore 7
    //   858: aload 23
    //   860: astore 26
    //   862: iload 4
    //   864: istore 9
    //   866: aload_2
    //   867: invokestatic 95	java/lang/System:currentTimeMillis	()J
    //   870: invokevirtual 313	java/io/File:setLastModified	(J)Z
    //   873: pop
    //   874: aload 23
    //   876: astore 24
    //   878: iload 4
    //   880: istore 8
    //   882: aload 23
    //   884: astore 25
    //   886: iload 4
    //   888: istore 7
    //   890: aload 23
    //   892: astore 26
    //   894: iload 4
    //   896: istore 9
    //   898: invokestatic 316	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   901: ifeq +79 -> 980
    //   904: aload 23
    //   906: astore 24
    //   908: iload 4
    //   910: istore 8
    //   912: aload 23
    //   914: astore 25
    //   916: iload 4
    //   918: istore 7
    //   920: aload 23
    //   922: astore 26
    //   924: iload 4
    //   926: istore 9
    //   928: ldc 30
    //   930: iconst_2
    //   931: new 201	java/lang/StringBuilder
    //   934: dup
    //   935: invokespecial 202	java/lang/StringBuilder:<init>	()V
    //   938: ldc_w 318
    //   941: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   944: invokestatic 95	java/lang/System:currentTimeMillis	()J
    //   947: lload 18
    //   949: lsub
    //   950: invokevirtual 321	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   953: ldc_w 323
    //   956: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   959: lload 14
    //   961: invokevirtual 321	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   964: ldc_w 325
    //   967: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   970: aload_1
    //   971: invokevirtual 328	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   974: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   977: invokestatic 331	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   980: iconst_0
    //   981: istore 7
    //   983: iload 7
    //   985: istore 4
    //   987: aload 32
    //   989: ifnull +99 -> 1088
    //   992: iload 7
    //   994: istore 4
    //   996: aload 32
    //   998: invokevirtual 333	java/lang/String:length	()I
    //   1001: ifeq +87 -> 1088
    //   1004: aload_2
    //   1005: invokevirtual 336	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1008: ldc 246
    //   1010: aload 35
    //   1012: ldc_w 338
    //   1015: invokestatic 342	cooperation/qzone/util/QZoneHttpDownloadUtil:getHeaderValue	([Lorg/apache/http/Header;Ljava/lang/String;)Ljava/lang/String;
    //   1018: invokevirtual 345	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1021: invokestatic 349	cooperation/qzone/util/QZoneHttpDownloadUtil:sourceFileMd5	(Ljava/lang/String;Z)Ljava/lang/String;
    //   1024: astore_0
    //   1025: iload 7
    //   1027: istore 4
    //   1029: aload_0
    //   1030: ifnull +58 -> 1088
    //   1033: iload 7
    //   1035: istore 4
    //   1037: aload_0
    //   1038: aload 32
    //   1040: invokevirtual 353	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1043: ifne +45 -> 1088
    //   1046: ldc 30
    //   1048: iconst_2
    //   1049: new 201	java/lang/StringBuilder
    //   1052: dup
    //   1053: invokespecial 202	java/lang/StringBuilder:<init>	()V
    //   1056: ldc_w 355
    //   1059: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1062: aload 30
    //   1064: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1067: ldc_w 357
    //   1070: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1073: aload_0
    //   1074: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1077: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1080: invokestatic 360	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1083: sipush -999
    //   1086: istore 4
    //   1088: aload 23
    //   1090: astore_0
    //   1091: iload 4
    //   1093: istore 7
    //   1095: lload 20
    //   1097: lconst_0
    //   1098: lcmp
    //   1099: ifle +136 -> 1235
    //   1102: iload 4
    //   1104: istore 7
    //   1106: lload 14
    //   1108: lload 20
    //   1110: lcmp
    //   1111: ifge +124 -> 1235
    //   1114: aload_0
    //   1115: astore 23
    //   1117: iload 4
    //   1119: istore 9
    //   1121: aload_0
    //   1122: astore 25
    //   1124: iload 4
    //   1126: istore 10
    //   1128: aload_0
    //   1129: astore 27
    //   1131: iload 4
    //   1133: istore 11
    //   1135: aload_0
    //   1136: astore 24
    //   1138: iload 4
    //   1140: istore 8
    //   1142: aload_3
    //   1143: astore 26
    //   1145: invokestatic 316	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1148: ifeq +2849 -> 3997
    //   1151: aload_0
    //   1152: astore 23
    //   1154: iload 4
    //   1156: istore 9
    //   1158: aload_0
    //   1159: astore 25
    //   1161: iload 4
    //   1163: istore 10
    //   1165: aload_0
    //   1166: astore 27
    //   1168: iload 4
    //   1170: istore 11
    //   1172: aload_0
    //   1173: astore 24
    //   1175: iload 4
    //   1177: istore 8
    //   1179: aload_3
    //   1180: astore 26
    //   1182: ldc 30
    //   1184: iconst_2
    //   1185: new 201	java/lang/StringBuilder
    //   1188: dup
    //   1189: invokespecial 202	java/lang/StringBuilder:<init>	()V
    //   1192: ldc_w 362
    //   1195: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1198: lload 20
    //   1200: invokevirtual 321	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1203: ldc_w 364
    //   1206: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1209: aload_2
    //   1210: invokevirtual 309	java/io/File:length	()J
    //   1213: invokevirtual 321	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1216: ldc_w 366
    //   1219: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1222: aload_1
    //   1223: invokevirtual 328	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1226: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1229: invokestatic 360	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1232: goto +2765 -> 3997
    //   1235: iload 7
    //   1237: ifne +2117 -> 3354
    //   1240: aload_0
    //   1241: astore 23
    //   1243: iload 7
    //   1245: istore 9
    //   1247: aload_0
    //   1248: astore 25
    //   1250: iload 7
    //   1252: istore 10
    //   1254: aload_0
    //   1255: astore 27
    //   1257: iload 7
    //   1259: istore 11
    //   1261: aload_0
    //   1262: astore 24
    //   1264: iload 7
    //   1266: istore 8
    //   1268: aload_3
    //   1269: astore 26
    //   1271: ldc 26
    //   1273: aload 35
    //   1275: ldc_w 368
    //   1278: invokestatic 342	cooperation/qzone/util/QZoneHttpDownloadUtil:getHeaderValue	([Lorg/apache/http/Header;Ljava/lang/String;)Ljava/lang/String;
    //   1281: invokevirtual 353	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1284: ifeq +813 -> 2097
    //   1287: aload_0
    //   1288: astore 23
    //   1290: iload 7
    //   1292: istore 9
    //   1294: aload_0
    //   1295: astore 25
    //   1297: iload 7
    //   1299: istore 10
    //   1301: aload_0
    //   1302: astore 27
    //   1304: iload 7
    //   1306: istore 11
    //   1308: aload_0
    //   1309: astore 24
    //   1311: iload 7
    //   1313: istore 8
    //   1315: aload_3
    //   1316: astore 26
    //   1318: invokestatic 374	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1321: invokestatic 380	bjkq:a	(Landroid/content/Context;)Z
    //   1324: ifeq +1780 -> 3104
    //   1327: aload_0
    //   1328: astore 23
    //   1330: iload 7
    //   1332: istore 9
    //   1334: aload_0
    //   1335: astore 25
    //   1337: iload 7
    //   1339: istore 10
    //   1341: aload_0
    //   1342: astore 27
    //   1344: iload 7
    //   1346: istore 11
    //   1348: aload_0
    //   1349: astore 24
    //   1351: iload 7
    //   1353: istore 8
    //   1355: aload_3
    //   1356: astore 26
    //   1358: aload 30
    //   1360: invokestatic 384	cooperation/qzone/webviewplugin/QzoneOfflinePluginJsForQQ:getFileExt	(Ljava/lang/String;)Ljava/lang/String;
    //   1363: astore 38
    //   1365: aload_0
    //   1366: astore 23
    //   1368: iload 7
    //   1370: istore 9
    //   1372: aload_0
    //   1373: astore 25
    //   1375: iload 7
    //   1377: istore 10
    //   1379: aload_0
    //   1380: astore 27
    //   1382: iload 7
    //   1384: istore 11
    //   1386: aload_0
    //   1387: astore 24
    //   1389: iload 7
    //   1391: istore 8
    //   1393: aload_3
    //   1394: astore 26
    //   1396: ldc 14
    //   1398: aload 38
    //   1400: invokevirtual 353	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1403: ifne +85 -> 1488
    //   1406: aload_0
    //   1407: astore 23
    //   1409: iload 7
    //   1411: istore 9
    //   1413: aload_0
    //   1414: astore 25
    //   1416: iload 7
    //   1418: istore 10
    //   1420: aload_0
    //   1421: astore 27
    //   1423: iload 7
    //   1425: istore 11
    //   1427: aload_0
    //   1428: astore 24
    //   1430: iload 7
    //   1432: istore 8
    //   1434: aload_3
    //   1435: astore 26
    //   1437: ldc 11
    //   1439: aload 38
    //   1441: invokevirtual 353	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1444: ifne +44 -> 1488
    //   1447: aload_0
    //   1448: astore 23
    //   1450: iload 7
    //   1452: istore 9
    //   1454: aload_0
    //   1455: astore 25
    //   1457: iload 7
    //   1459: istore 10
    //   1461: aload_0
    //   1462: astore 27
    //   1464: iload 7
    //   1466: istore 11
    //   1468: aload_0
    //   1469: astore 24
    //   1471: iload 7
    //   1473: istore 8
    //   1475: aload_3
    //   1476: astore 26
    //   1478: ldc 17
    //   1480: aload 38
    //   1482: invokevirtual 353	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1485: ifeq +612 -> 2097
    //   1488: aload_0
    //   1489: astore 23
    //   1491: iload 7
    //   1493: istore 9
    //   1495: aload_0
    //   1496: astore 25
    //   1498: iload 7
    //   1500: istore 10
    //   1502: aload_0
    //   1503: astore 27
    //   1505: iload 7
    //   1507: istore 11
    //   1509: aload_0
    //   1510: astore 24
    //   1512: iload 7
    //   1514: istore 8
    //   1516: aload_3
    //   1517: astore 26
    //   1519: aload_2
    //   1520: invokevirtual 336	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1523: astore 37
    //   1525: aload_0
    //   1526: astore 23
    //   1528: iload 7
    //   1530: istore 9
    //   1532: aload_0
    //   1533: astore 25
    //   1535: iload 7
    //   1537: istore 10
    //   1539: aload_0
    //   1540: astore 27
    //   1542: iload 7
    //   1544: istore 11
    //   1546: aload_0
    //   1547: astore 24
    //   1549: iload 7
    //   1551: istore 8
    //   1553: aload_3
    //   1554: astore 26
    //   1556: aload_2
    //   1557: invokestatic 387	bjkq:a	(Ljava/io/File;)Ljava/io/File;
    //   1560: astore 39
    //   1562: aload_0
    //   1563: astore 23
    //   1565: iload 7
    //   1567: istore 9
    //   1569: aload_0
    //   1570: astore 25
    //   1572: iload 7
    //   1574: istore 10
    //   1576: aload_0
    //   1577: astore 27
    //   1579: iload 7
    //   1581: istore 11
    //   1583: aload_0
    //   1584: astore 24
    //   1586: iload 7
    //   1588: istore 8
    //   1590: aload_3
    //   1591: astore 26
    //   1593: aload 39
    //   1595: invokevirtual 336	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1598: invokestatic 393	com/tencent/sharpP/SharpPUtil:decodeSharpPByFilePath	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   1601: astore 40
    //   1603: aload_0
    //   1604: astore 23
    //   1606: iload 7
    //   1608: istore 9
    //   1610: aload_0
    //   1611: astore 25
    //   1613: iload 7
    //   1615: istore 10
    //   1617: aload_0
    //   1618: astore 27
    //   1620: iload 7
    //   1622: istore 11
    //   1624: aload_0
    //   1625: astore 24
    //   1627: iload 7
    //   1629: istore 8
    //   1631: aload_3
    //   1632: astore 26
    //   1634: new 108	java/io/File
    //   1637: dup
    //   1638: aload 37
    //   1640: invokespecial 213	java/io/File:<init>	(Ljava/lang/String;)V
    //   1643: astore 41
    //   1645: aload 40
    //   1647: ifnull +1243 -> 2890
    //   1650: aload_0
    //   1651: astore 23
    //   1653: iload 7
    //   1655: istore 9
    //   1657: aload_0
    //   1658: astore 25
    //   1660: iload 7
    //   1662: istore 10
    //   1664: aload_0
    //   1665: astore 27
    //   1667: iload 7
    //   1669: istore 11
    //   1671: aload_0
    //   1672: astore 24
    //   1674: iload 7
    //   1676: istore 8
    //   1678: aload_3
    //   1679: astore 26
    //   1681: ldc 17
    //   1683: aload 38
    //   1685: invokevirtual 353	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1688: ifeq +878 -> 2566
    //   1691: aload_0
    //   1692: astore 23
    //   1694: iload 7
    //   1696: istore 9
    //   1698: aload_0
    //   1699: astore 25
    //   1701: iload 7
    //   1703: istore 10
    //   1705: aload_0
    //   1706: astore 27
    //   1708: iload 7
    //   1710: istore 11
    //   1712: aload_0
    //   1713: astore 24
    //   1715: iload 7
    //   1717: istore 8
    //   1719: aload_3
    //   1720: astore 26
    //   1722: getstatic 399	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   1725: astore 29
    //   1727: aload_0
    //   1728: astore 23
    //   1730: iload 7
    //   1732: istore 9
    //   1734: aload_0
    //   1735: astore 25
    //   1737: iload 7
    //   1739: istore 10
    //   1741: aload_0
    //   1742: astore 27
    //   1744: iload 7
    //   1746: istore 11
    //   1748: aload_0
    //   1749: astore 24
    //   1751: iload 7
    //   1753: istore 8
    //   1755: aload_3
    //   1756: astore 26
    //   1758: aload 40
    //   1760: aload 37
    //   1762: aload 29
    //   1764: getstatic 48	cooperation/qzone/util/QZoneHttpDownloadUtil:PHOTO_DECODE_QUALITY	I
    //   1767: iconst_1
    //   1768: invokestatic 405	cooperation/qzone/util/PhotoUtils:saveBitmapToFile	(Landroid/graphics/Bitmap;Ljava/lang/String;Landroid/graphics/Bitmap$CompressFormat;IZ)Z
    //   1771: ifeq +834 -> 2605
    //   1774: aload_0
    //   1775: astore 23
    //   1777: iload 7
    //   1779: istore 9
    //   1781: aload_0
    //   1782: astore 25
    //   1784: iload 7
    //   1786: istore 10
    //   1788: aload_0
    //   1789: astore 27
    //   1791: iload 7
    //   1793: istore 11
    //   1795: aload_0
    //   1796: astore 24
    //   1798: iload 7
    //   1800: istore 8
    //   1802: aload_3
    //   1803: astore 26
    //   1805: aload 39
    //   1807: invokestatic 411	cooperation/qzone/util/FileUtils:deleteFile	(Ljava/io/File;)Z
    //   1810: pop
    //   1811: aload_0
    //   1812: astore 23
    //   1814: iload 7
    //   1816: istore 9
    //   1818: aload_0
    //   1819: astore 25
    //   1821: iload 7
    //   1823: istore 10
    //   1825: aload_0
    //   1826: astore 27
    //   1828: iload 7
    //   1830: istore 11
    //   1832: aload_0
    //   1833: astore 24
    //   1835: iload 7
    //   1837: istore 8
    //   1839: aload_3
    //   1840: astore 26
    //   1842: aload 41
    //   1844: invokevirtual 309	java/io/File:length	()J
    //   1847: lstore 14
    //   1849: aload_0
    //   1850: astore 23
    //   1852: iload 7
    //   1854: istore 9
    //   1856: aload_0
    //   1857: astore 25
    //   1859: iload 7
    //   1861: istore 10
    //   1863: aload_0
    //   1864: astore 27
    //   1866: iload 7
    //   1868: istore 11
    //   1870: aload_0
    //   1871: astore 24
    //   1873: iload 7
    //   1875: istore 8
    //   1877: aload_3
    //   1878: astore 26
    //   1880: ldc 17
    //   1882: aload 38
    //   1884: invokevirtual 353	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1887: ifeq +2117 -> 4004
    //   1890: ldc 23
    //   1892: astore 29
    //   1894: aload_0
    //   1895: astore 23
    //   1897: iload 7
    //   1899: istore 9
    //   1901: aload_0
    //   1902: astore 25
    //   1904: iload 7
    //   1906: istore 10
    //   1908: aload_0
    //   1909: astore 27
    //   1911: iload 7
    //   1913: istore 11
    //   1915: aload_0
    //   1916: astore 24
    //   1918: iload 7
    //   1920: istore 8
    //   1922: aload_3
    //   1923: astore 26
    //   1925: aload 36
    //   1927: ldc_w 368
    //   1930: aload 29
    //   1932: invokevirtual 415	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1935: pop
    //   1936: aload_0
    //   1937: astore 23
    //   1939: iload 7
    //   1941: istore 9
    //   1943: aload_0
    //   1944: astore 25
    //   1946: iload 7
    //   1948: istore 10
    //   1950: aload_0
    //   1951: astore 27
    //   1953: iload 7
    //   1955: istore 11
    //   1957: aload_0
    //   1958: astore 24
    //   1960: iload 7
    //   1962: istore 8
    //   1964: aload_3
    //   1965: astore 26
    //   1967: aload 36
    //   1969: ldc_w 417
    //   1972: lload 14
    //   1974: invokestatic 420	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1977: invokevirtual 415	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1980: pop
    //   1981: aload_0
    //   1982: astore 23
    //   1984: iload 7
    //   1986: istore 9
    //   1988: aload_0
    //   1989: astore 25
    //   1991: iload 7
    //   1993: istore 10
    //   1995: aload_0
    //   1996: astore 27
    //   1998: iload 7
    //   2000: istore 11
    //   2002: aload_0
    //   2003: astore 24
    //   2005: iload 7
    //   2007: istore 8
    //   2009: aload_3
    //   2010: astore 26
    //   2012: invokestatic 423	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2015: ifeq +82 -> 2097
    //   2018: aload_0
    //   2019: astore 23
    //   2021: iload 7
    //   2023: istore 9
    //   2025: aload_0
    //   2026: astore 25
    //   2028: iload 7
    //   2030: istore 10
    //   2032: aload_0
    //   2033: astore 27
    //   2035: iload 7
    //   2037: istore 11
    //   2039: aload_0
    //   2040: astore 24
    //   2042: iload 7
    //   2044: istore 8
    //   2046: aload_3
    //   2047: astore 26
    //   2049: ldc 30
    //   2051: iconst_4
    //   2052: new 201	java/lang/StringBuilder
    //   2055: dup
    //   2056: invokespecial 202	java/lang/StringBuilder:<init>	()V
    //   2059: ldc_w 425
    //   2062: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2065: lload 14
    //   2067: invokevirtual 321	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2070: ldc_w 427
    //   2073: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2076: aload_1
    //   2077: invokevirtual 328	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2080: ldc_w 429
    //   2083: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2086: aload 37
    //   2088: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2091: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2094: invokestatic 331	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2097: aload_0
    //   2098: astore 23
    //   2100: iload 7
    //   2102: istore 9
    //   2104: aload_0
    //   2105: astore 25
    //   2107: iload 7
    //   2109: istore 10
    //   2111: aload_0
    //   2112: astore 27
    //   2114: iload 7
    //   2116: istore 11
    //   2118: aload_0
    //   2119: astore 24
    //   2121: iload 7
    //   2123: istore 8
    //   2125: aload_3
    //   2126: astore 26
    //   2128: aload 35
    //   2130: aload 34
    //   2132: aload 30
    //   2134: aload 36
    //   2136: invokestatic 433	cooperation/qzone/util/QZoneHttpDownloadUtil:saveHeadersToFile	([Lorg/apache/http/Header;Ljava/io/File;Ljava/lang/String;Ljava/util/HashMap;)Z
    //   2139: pop
    //   2140: aload_0
    //   2141: astore 24
    //   2143: aload_3
    //   2144: ifnull +9 -> 2153
    //   2147: aload_3
    //   2148: invokeinterface 436 1 0
    //   2153: aload 24
    //   2155: invokestatic 441	cooperation/qzone/util/DataUtils:closeDataObject	(Ljava/lang/Object;)Z
    //   2158: pop
    //   2159: iload 7
    //   2161: ifeq +1831 -> 3992
    //   2164: aload_2
    //   2165: ifnull +75 -> 2240
    //   2168: aload_2
    //   2169: invokevirtual 112	java/io/File:getParentFile	()Ljava/io/File;
    //   2172: astore_0
    //   2173: aload_0
    //   2174: ifnull +15 -> 2189
    //   2177: aload_0
    //   2178: invokevirtual 116	java/io/File:exists	()Z
    //   2181: ifne +8 -> 2189
    //   2184: aload_0
    //   2185: invokevirtual 119	java/io/File:mkdirs	()Z
    //   2188: pop
    //   2189: aload_2
    //   2190: invokevirtual 116	java/io/File:exists	()Z
    //   2193: ifeq +47 -> 2240
    //   2196: aload_2
    //   2197: invokevirtual 216	java/io/File:delete	()Z
    //   2200: istore 22
    //   2202: ldc 30
    //   2204: iconst_1
    //   2205: new 201	java/lang/StringBuilder
    //   2208: dup
    //   2209: invokespecial 202	java/lang/StringBuilder:<init>	()V
    //   2212: ldc_w 443
    //   2215: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2218: iload 22
    //   2220: invokevirtual 446	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2223: ldc_w 448
    //   2226: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2229: aload 30
    //   2231: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2234: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2237: invokestatic 106	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2240: aload_3
    //   2241: astore_0
    //   2242: iload 13
    //   2244: iconst_1
    //   2245: iadd
    //   2246: istore 13
    //   2248: iload 7
    //   2250: ifeq +1479 -> 3729
    //   2253: ldc 30
    //   2255: iconst_1
    //   2256: new 201	java/lang/StringBuilder
    //   2259: dup
    //   2260: invokespecial 202	java/lang/StringBuilder:<init>	()V
    //   2263: ldc_w 450
    //   2266: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2269: iload 7
    //   2271: invokevirtual 453	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2274: ldc_w 366
    //   2277: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2280: aload_1
    //   2281: invokevirtual 328	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2284: ldc_w 455
    //   2287: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2290: iload 13
    //   2292: invokevirtual 453	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2295: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2298: invokestatic 360	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   2301: iload 7
    //   2303: ifeq +31 -> 2334
    //   2306: iload 7
    //   2308: sipush -999
    //   2311: if_icmpeq +23 -> 2334
    //   2314: iload 13
    //   2316: iconst_2
    //   2317: if_icmpge +17 -> 2334
    //   2320: aload 31
    //   2322: monitorenter
    //   2323: aload 31
    //   2325: ldc2_w 456
    //   2328: invokevirtual 461	java/lang/Object:wait	(J)V
    //   2331: aload 31
    //   2333: monitorexit
    //   2334: iload 7
    //   2336: ifeq +18 -> 2354
    //   2339: iload 7
    //   2341: sipush -999
    //   2344: if_icmpeq +10 -> 2354
    //   2347: iload 13
    //   2349: iload 12
    //   2351: if_icmplt +1633 -> 3984
    //   2354: iload 7
    //   2356: ireturn
    //   2357: astore_0
    //   2358: ldc 30
    //   2360: iconst_1
    //   2361: ldc_w 463
    //   2364: invokestatic 106	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2367: iconst_4
    //   2368: ireturn
    //   2369: astore 23
    //   2371: new 133	org/apache/http/client/methods/HttpGet
    //   2374: dup
    //   2375: aload 30
    //   2377: invokestatic 466	cooperation/qzone/util/QZoneHttpDownloadUtil:getEscapeSequence	(Ljava/lang/String;)Ljava/lang/String;
    //   2380: invokespecial 136	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   2383: astore 28
    //   2385: goto -2296 -> 89
    //   2388: astore_0
    //   2389: ldc 30
    //   2391: iconst_1
    //   2392: ldc_w 468
    //   2395: invokestatic 106	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2398: bipush 13
    //   2400: ireturn
    //   2401: sipush 10000
    //   2404: istore 7
    //   2406: sipush 30000
    //   2409: istore 4
    //   2411: aload 33
    //   2413: ldc 181
    //   2415: sipush 4096
    //   2418: invokeinterface 185 3 0
    //   2423: pop
    //   2424: goto -2215 -> 209
    //   2427: astore 24
    //   2429: aload 23
    //   2431: astore_0
    //   2432: iconst_5
    //   2433: istore 4
    //   2435: aload 24
    //   2437: astore 23
    //   2439: ldc 30
    //   2441: iconst_1
    //   2442: new 201	java/lang/StringBuilder
    //   2445: dup
    //   2446: invokespecial 202	java/lang/StringBuilder:<init>	()V
    //   2449: ldc_w 470
    //   2452: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2455: aload_2
    //   2456: invokevirtual 116	java/io/File:exists	()Z
    //   2459: invokevirtual 446	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2462: ldc_w 472
    //   2465: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2468: aload_2
    //   2469: invokevirtual 112	java/io/File:getParentFile	()Ljava/io/File;
    //   2472: invokevirtual 116	java/io/File:exists	()Z
    //   2475: invokevirtual 446	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2478: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2481: aload 23
    //   2483: invokestatic 475	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2486: goto -1395 -> 1091
    //   2489: astore_0
    //   2490: lconst_0
    //   2491: lstore 14
    //   2493: aload 23
    //   2495: astore 24
    //   2497: iload 4
    //   2499: istore 8
    //   2501: aload 23
    //   2503: astore 25
    //   2505: iload 4
    //   2507: istore 7
    //   2509: aload 23
    //   2511: astore 26
    //   2513: iload 4
    //   2515: istore 9
    //   2517: invokestatic 316	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2520: ifeq +37 -> 2557
    //   2523: aload 23
    //   2525: astore 24
    //   2527: iload 4
    //   2529: istore 8
    //   2531: aload 23
    //   2533: astore 25
    //   2535: iload 4
    //   2537: istore 7
    //   2539: aload 23
    //   2541: astore 26
    //   2543: iload 4
    //   2545: istore 9
    //   2547: ldc 30
    //   2549: iconst_2
    //   2550: ldc_w 477
    //   2553: aload_0
    //   2554: invokestatic 475	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2557: iconst_4
    //   2558: istore 4
    //   2560: aload 23
    //   2562: astore_0
    //   2563: goto -1472 -> 1091
    //   2566: aload_0
    //   2567: astore 23
    //   2569: iload 7
    //   2571: istore 9
    //   2573: aload_0
    //   2574: astore 25
    //   2576: iload 7
    //   2578: istore 10
    //   2580: aload_0
    //   2581: astore 27
    //   2583: iload 7
    //   2585: istore 11
    //   2587: aload_0
    //   2588: astore 24
    //   2590: iload 7
    //   2592: istore 8
    //   2594: aload_3
    //   2595: astore 26
    //   2597: getstatic 480	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   2600: astore 29
    //   2602: goto -875 -> 1727
    //   2605: aload_0
    //   2606: astore 23
    //   2608: iload 7
    //   2610: istore 9
    //   2612: aload_0
    //   2613: astore 25
    //   2615: iload 7
    //   2617: istore 10
    //   2619: aload_0
    //   2620: astore 27
    //   2622: iload 7
    //   2624: istore 11
    //   2626: aload_0
    //   2627: astore 24
    //   2629: iload 7
    //   2631: istore 8
    //   2633: aload_3
    //   2634: astore 26
    //   2636: aload 39
    //   2638: aload 41
    //   2640: invokevirtual 483	java/io/File:renameTo	(Ljava/io/File;)Z
    //   2643: pop
    //   2644: goto -547 -> 2097
    //   2647: astore 24
    //   2649: iload 9
    //   2651: istore 4
    //   2653: aload_3
    //   2654: astore 26
    //   2656: aload 23
    //   2658: astore 25
    //   2660: iload 4
    //   2662: istore 8
    //   2664: invokestatic 316	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2667: ifeq +42 -> 2709
    //   2670: aload_3
    //   2671: astore 26
    //   2673: aload 23
    //   2675: astore 25
    //   2677: iload 4
    //   2679: istore 8
    //   2681: ldc 30
    //   2683: iconst_2
    //   2684: new 201	java/lang/StringBuilder
    //   2687: dup
    //   2688: invokespecial 202	java/lang/StringBuilder:<init>	()V
    //   2691: ldc_w 485
    //   2694: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2697: aload_1
    //   2698: invokevirtual 328	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2701: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2704: aload 24
    //   2706: invokestatic 475	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2709: aload_3
    //   2710: astore 26
    //   2712: aload 23
    //   2714: astore 25
    //   2716: iload 4
    //   2718: istore 8
    //   2720: aload 24
    //   2722: instanceof 487
    //   2725: istore 22
    //   2727: iload 22
    //   2729: ifeq +847 -> 3576
    //   2732: bipush 10
    //   2734: istore 4
    //   2736: aload_3
    //   2737: ifnull +9 -> 2746
    //   2740: aload_3
    //   2741: invokeinterface 436 1 0
    //   2746: aload 23
    //   2748: invokestatic 441	cooperation/qzone/util/DataUtils:closeDataObject	(Ljava/lang/Object;)Z
    //   2751: pop
    //   2752: iload 4
    //   2754: istore 7
    //   2756: aload_3
    //   2757: astore_0
    //   2758: aload 23
    //   2760: astore 24
    //   2762: iload 4
    //   2764: ifeq -522 -> 2242
    //   2767: iload 4
    //   2769: istore 7
    //   2771: aload_3
    //   2772: astore_0
    //   2773: aload 23
    //   2775: astore 24
    //   2777: aload_2
    //   2778: ifnull -536 -> 2242
    //   2781: aload_2
    //   2782: invokevirtual 112	java/io/File:getParentFile	()Ljava/io/File;
    //   2785: astore_0
    //   2786: aload_0
    //   2787: ifnull +15 -> 2802
    //   2790: aload_0
    //   2791: invokevirtual 116	java/io/File:exists	()Z
    //   2794: ifne +8 -> 2802
    //   2797: aload_0
    //   2798: invokevirtual 119	java/io/File:mkdirs	()Z
    //   2801: pop
    //   2802: iload 4
    //   2804: istore 7
    //   2806: aload_3
    //   2807: astore_0
    //   2808: aload 23
    //   2810: astore 24
    //   2812: aload_2
    //   2813: invokevirtual 116	java/io/File:exists	()Z
    //   2816: ifeq -574 -> 2242
    //   2819: aload_2
    //   2820: invokevirtual 216	java/io/File:delete	()Z
    //   2823: istore 22
    //   2825: ldc 30
    //   2827: iconst_1
    //   2828: new 201	java/lang/StringBuilder
    //   2831: dup
    //   2832: invokespecial 202	java/lang/StringBuilder:<init>	()V
    //   2835: ldc_w 443
    //   2838: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2841: iload 22
    //   2843: invokevirtual 446	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2846: ldc_w 448
    //   2849: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2852: aload 30
    //   2854: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2857: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2860: invokestatic 106	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2863: iload 4
    //   2865: istore 7
    //   2867: aload_3
    //   2868: astore_0
    //   2869: aload 23
    //   2871: astore 24
    //   2873: goto -631 -> 2242
    //   2876: astore_0
    //   2877: iload 4
    //   2879: istore 7
    //   2881: aload_3
    //   2882: astore_0
    //   2883: aload 23
    //   2885: astore 24
    //   2887: goto -645 -> 2242
    //   2890: aload_0
    //   2891: astore 23
    //   2893: iload 7
    //   2895: istore 9
    //   2897: aload_0
    //   2898: astore 25
    //   2900: iload 7
    //   2902: istore 10
    //   2904: aload_0
    //   2905: astore 27
    //   2907: iload 7
    //   2909: istore 11
    //   2911: aload_0
    //   2912: astore 24
    //   2914: iload 7
    //   2916: istore 8
    //   2918: aload_3
    //   2919: astore 26
    //   2921: aload 39
    //   2923: aload 41
    //   2925: invokevirtual 483	java/io/File:renameTo	(Ljava/io/File;)Z
    //   2928: pop
    //   2929: goto -832 -> 2097
    //   2932: astore_0
    //   2933: iload 10
    //   2935: istore 4
    //   2937: aload 25
    //   2939: astore 23
    //   2941: aload_0
    //   2942: astore 25
    //   2944: aload 23
    //   2946: astore 24
    //   2948: iload 4
    //   2950: istore 8
    //   2952: aload_3
    //   2953: astore 26
    //   2955: invokestatic 316	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2958: ifeq +42 -> 3000
    //   2961: aload 23
    //   2963: astore 24
    //   2965: iload 4
    //   2967: istore 8
    //   2969: aload_3
    //   2970: astore 26
    //   2972: ldc 30
    //   2974: iconst_2
    //   2975: new 201	java/lang/StringBuilder
    //   2978: dup
    //   2979: invokespecial 202	java/lang/StringBuilder:<init>	()V
    //   2982: ldc_w 489
    //   2985: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2988: aload_1
    //   2989: invokevirtual 328	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2992: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2995: aload 25
    //   2997: invokestatic 475	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3000: iconst_5
    //   3001: istore 7
    //   3003: aload_3
    //   3004: ifnull +9 -> 3013
    //   3007: aload_3
    //   3008: invokeinterface 436 1 0
    //   3013: aload 23
    //   3015: invokestatic 441	cooperation/qzone/util/DataUtils:closeDataObject	(Ljava/lang/Object;)Z
    //   3018: pop
    //   3019: aload_2
    //   3020: ifnull +75 -> 3095
    //   3023: aload_2
    //   3024: invokevirtual 112	java/io/File:getParentFile	()Ljava/io/File;
    //   3027: astore_0
    //   3028: aload_0
    //   3029: ifnull +15 -> 3044
    //   3032: aload_0
    //   3033: invokevirtual 116	java/io/File:exists	()Z
    //   3036: ifne +8 -> 3044
    //   3039: aload_0
    //   3040: invokevirtual 119	java/io/File:mkdirs	()Z
    //   3043: pop
    //   3044: aload_2
    //   3045: invokevirtual 116	java/io/File:exists	()Z
    //   3048: ifeq +47 -> 3095
    //   3051: aload_2
    //   3052: invokevirtual 216	java/io/File:delete	()Z
    //   3055: istore 22
    //   3057: ldc 30
    //   3059: iconst_1
    //   3060: new 201	java/lang/StringBuilder
    //   3063: dup
    //   3064: invokespecial 202	java/lang/StringBuilder:<init>	()V
    //   3067: ldc_w 443
    //   3070: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3073: iload 22
    //   3075: invokevirtual 446	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3078: ldc_w 448
    //   3081: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3084: aload 30
    //   3086: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3089: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3092: invokestatic 106	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3095: aload_3
    //   3096: astore_0
    //   3097: aload 23
    //   3099: astore 24
    //   3101: goto -859 -> 2242
    //   3104: aload_0
    //   3105: astore 23
    //   3107: iload 7
    //   3109: istore 9
    //   3111: aload_0
    //   3112: astore 25
    //   3114: iload 7
    //   3116: istore 10
    //   3118: aload_0
    //   3119: astore 27
    //   3121: iload 7
    //   3123: istore 11
    //   3125: aload_0
    //   3126: astore 24
    //   3128: iload 7
    //   3130: istore 8
    //   3132: aload_3
    //   3133: astore 26
    //   3135: invokestatic 423	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   3138: ifeq -1041 -> 2097
    //   3141: aload_0
    //   3142: astore 23
    //   3144: iload 7
    //   3146: istore 9
    //   3148: aload_0
    //   3149: astore 25
    //   3151: iload 7
    //   3153: istore 10
    //   3155: aload_0
    //   3156: astore 27
    //   3158: iload 7
    //   3160: istore 11
    //   3162: aload_0
    //   3163: astore 24
    //   3165: iload 7
    //   3167: istore 8
    //   3169: aload_3
    //   3170: astore 26
    //   3172: ldc 30
    //   3174: iconst_4
    //   3175: ldc_w 491
    //   3178: invokestatic 331	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3181: goto -1084 -> 2097
    //   3184: astore 25
    //   3186: iload 11
    //   3188: istore 4
    //   3190: aload 27
    //   3192: astore 23
    //   3194: aload 23
    //   3196: astore 24
    //   3198: iload 4
    //   3200: istore 8
    //   3202: aload_3
    //   3203: astore 26
    //   3205: invokestatic 316	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3208: ifeq +42 -> 3250
    //   3211: aload 23
    //   3213: astore 24
    //   3215: iload 4
    //   3217: istore 8
    //   3219: aload_3
    //   3220: astore 26
    //   3222: ldc 30
    //   3224: iconst_2
    //   3225: new 201	java/lang/StringBuilder
    //   3228: dup
    //   3229: invokespecial 202	java/lang/StringBuilder:<init>	()V
    //   3232: ldc_w 489
    //   3235: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3238: aload_1
    //   3239: invokevirtual 328	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3242: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3245: aload 25
    //   3247: invokestatic 494	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3250: iconst_5
    //   3251: istore 7
    //   3253: aload_3
    //   3254: ifnull +9 -> 3263
    //   3257: aload_3
    //   3258: invokeinterface 436 1 0
    //   3263: aload 23
    //   3265: invokestatic 441	cooperation/qzone/util/DataUtils:closeDataObject	(Ljava/lang/Object;)Z
    //   3268: pop
    //   3269: aload_2
    //   3270: ifnull +75 -> 3345
    //   3273: aload_2
    //   3274: invokevirtual 112	java/io/File:getParentFile	()Ljava/io/File;
    //   3277: astore_0
    //   3278: aload_0
    //   3279: ifnull +15 -> 3294
    //   3282: aload_0
    //   3283: invokevirtual 116	java/io/File:exists	()Z
    //   3286: ifne +8 -> 3294
    //   3289: aload_0
    //   3290: invokevirtual 119	java/io/File:mkdirs	()Z
    //   3293: pop
    //   3294: aload_2
    //   3295: invokevirtual 116	java/io/File:exists	()Z
    //   3298: ifeq +47 -> 3345
    //   3301: aload_2
    //   3302: invokevirtual 216	java/io/File:delete	()Z
    //   3305: istore 22
    //   3307: ldc 30
    //   3309: iconst_1
    //   3310: new 201	java/lang/StringBuilder
    //   3313: dup
    //   3314: invokespecial 202	java/lang/StringBuilder:<init>	()V
    //   3317: ldc_w 443
    //   3320: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3323: iload 22
    //   3325: invokevirtual 446	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3328: ldc_w 448
    //   3331: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3334: aload 30
    //   3336: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3339: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3342: invokestatic 106	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3345: aload_3
    //   3346: astore_0
    //   3347: aload 23
    //   3349: astore 24
    //   3351: goto -1109 -> 2242
    //   3354: aload_0
    //   3355: astore 23
    //   3357: iload 7
    //   3359: istore 9
    //   3361: aload_0
    //   3362: astore 25
    //   3364: iload 7
    //   3366: istore 10
    //   3368: aload_0
    //   3369: astore 27
    //   3371: iload 7
    //   3373: istore 11
    //   3375: aload_0
    //   3376: astore 24
    //   3378: iload 7
    //   3380: istore 8
    //   3382: aload_3
    //   3383: astore 26
    //   3385: invokestatic 316	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3388: ifeq -1248 -> 2140
    //   3391: aload_0
    //   3392: astore 23
    //   3394: iload 7
    //   3396: istore 9
    //   3398: aload_0
    //   3399: astore 25
    //   3401: iload 7
    //   3403: istore 10
    //   3405: aload_0
    //   3406: astore 27
    //   3408: iload 7
    //   3410: istore 11
    //   3412: aload_0
    //   3413: astore 24
    //   3415: iload 7
    //   3417: istore 8
    //   3419: aload_3
    //   3420: astore 26
    //   3422: ldc 30
    //   3424: iconst_2
    //   3425: new 201	java/lang/StringBuilder
    //   3428: dup
    //   3429: invokespecial 202	java/lang/StringBuilder:<init>	()V
    //   3432: ldc_w 496
    //   3435: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3438: aload_1
    //   3439: invokevirtual 328	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3442: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3445: invokestatic 106	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3448: goto -1308 -> 2140
    //   3451: astore_1
    //   3452: aload 26
    //   3454: astore_3
    //   3455: aload 24
    //   3457: astore_0
    //   3458: aload_3
    //   3459: ifnull +9 -> 3468
    //   3462: aload_3
    //   3463: invokeinterface 436 1 0
    //   3468: aload_0
    //   3469: invokestatic 441	cooperation/qzone/util/DataUtils:closeDataObject	(Ljava/lang/Object;)Z
    //   3472: pop
    //   3473: iload 8
    //   3475: ifeq +79 -> 3554
    //   3478: aload_2
    //   3479: ifnull +75 -> 3554
    //   3482: aload_2
    //   3483: invokevirtual 112	java/io/File:getParentFile	()Ljava/io/File;
    //   3486: astore_0
    //   3487: aload_0
    //   3488: ifnull +15 -> 3503
    //   3491: aload_0
    //   3492: invokevirtual 116	java/io/File:exists	()Z
    //   3495: ifne +8 -> 3503
    //   3498: aload_0
    //   3499: invokevirtual 119	java/io/File:mkdirs	()Z
    //   3502: pop
    //   3503: aload_2
    //   3504: invokevirtual 116	java/io/File:exists	()Z
    //   3507: ifeq +47 -> 3554
    //   3510: aload_2
    //   3511: invokevirtual 216	java/io/File:delete	()Z
    //   3514: istore 22
    //   3516: ldc 30
    //   3518: iconst_1
    //   3519: new 201	java/lang/StringBuilder
    //   3522: dup
    //   3523: invokespecial 202	java/lang/StringBuilder:<init>	()V
    //   3526: ldc_w 443
    //   3529: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3532: iload 22
    //   3534: invokevirtual 446	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3537: ldc_w 448
    //   3540: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3543: aload 30
    //   3545: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3548: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3551: invokestatic 106	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3554: aload_1
    //   3555: athrow
    //   3556: astore_0
    //   3557: ldc 30
    //   3559: iconst_1
    //   3560: ldc_w 498
    //   3563: aload_0
    //   3564: invokestatic 500	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3567: goto -1414 -> 2153
    //   3570: astore_0
    //   3571: aload_3
    //   3572: astore_0
    //   3573: goto -1331 -> 2242
    //   3576: aload_3
    //   3577: astore 26
    //   3579: aload 23
    //   3581: astore 25
    //   3583: iload 4
    //   3585: istore 8
    //   3587: aload 24
    //   3589: instanceof 502
    //   3592: ifne +419 -> 4011
    //   3595: aload_3
    //   3596: astore 26
    //   3598: aload 23
    //   3600: astore 25
    //   3602: iload 4
    //   3604: istore 8
    //   3606: aload 24
    //   3608: instanceof 504
    //   3611: ifeq +6 -> 3617
    //   3614: goto +397 -> 4011
    //   3617: aload_3
    //   3618: astore 26
    //   3620: aload 23
    //   3622: astore 25
    //   3624: iload 4
    //   3626: istore 8
    //   3628: aload 24
    //   3630: instanceof 506
    //   3633: istore 22
    //   3635: iload 22
    //   3637: ifeq +10 -> 3647
    //   3640: bipush 11
    //   3642: istore 4
    //   3644: goto -908 -> 2736
    //   3647: iconst_4
    //   3648: istore 4
    //   3650: goto -914 -> 2736
    //   3653: astore_0
    //   3654: ldc 30
    //   3656: iconst_1
    //   3657: ldc_w 498
    //   3660: aload_0
    //   3661: invokestatic 500	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3664: goto -918 -> 2746
    //   3667: astore_0
    //   3668: ldc 30
    //   3670: iconst_1
    //   3671: ldc_w 498
    //   3674: aload_0
    //   3675: invokestatic 500	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3678: goto -665 -> 3013
    //   3681: astore_0
    //   3682: aload_3
    //   3683: astore_0
    //   3684: aload 23
    //   3686: astore 24
    //   3688: goto -1446 -> 2242
    //   3691: astore_0
    //   3692: ldc 30
    //   3694: iconst_1
    //   3695: ldc_w 498
    //   3698: aload_0
    //   3699: invokestatic 500	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3702: goto -439 -> 3263
    //   3705: astore_0
    //   3706: aload_3
    //   3707: astore_0
    //   3708: aload 23
    //   3710: astore 24
    //   3712: goto -1470 -> 2242
    //   3715: astore_3
    //   3716: ldc 30
    //   3718: iconst_1
    //   3719: ldc_w 498
    //   3722: aload_3
    //   3723: invokestatic 500	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3726: goto -258 -> 3468
    //   3729: invokestatic 316	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3732: ifeq -1431 -> 2301
    //   3735: ldc 30
    //   3737: iconst_2
    //   3738: new 201	java/lang/StringBuilder
    //   3741: dup
    //   3742: invokespecial 202	java/lang/StringBuilder:<init>	()V
    //   3745: ldc_w 450
    //   3748: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3751: iload 7
    //   3753: invokevirtual 453	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3756: ldc_w 366
    //   3759: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3762: aload_1
    //   3763: invokevirtual 328	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3766: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3769: invokestatic 106	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3772: goto -1471 -> 2301
    //   3775: astore_0
    //   3776: aload 31
    //   3778: monitorexit
    //   3779: aload_0
    //   3780: athrow
    //   3781: astore_3
    //   3782: goto -1451 -> 2331
    //   3785: astore_0
    //   3786: goto -232 -> 3554
    //   3789: astore_1
    //   3790: aload 24
    //   3792: astore_0
    //   3793: goto -335 -> 3458
    //   3796: astore_1
    //   3797: aload 23
    //   3799: astore_0
    //   3800: iconst_0
    //   3801: istore 8
    //   3803: goto -345 -> 3458
    //   3806: astore_1
    //   3807: iload 4
    //   3809: istore 8
    //   3811: goto -353 -> 3458
    //   3814: astore_1
    //   3815: aload 26
    //   3817: astore_3
    //   3818: aload 25
    //   3820: astore_0
    //   3821: goto -363 -> 3458
    //   3824: astore_0
    //   3825: aload 25
    //   3827: astore 23
    //   3829: aload_0
    //   3830: astore 25
    //   3832: iload 7
    //   3834: istore 4
    //   3836: goto -642 -> 3194
    //   3839: astore 25
    //   3841: iconst_0
    //   3842: istore 4
    //   3844: goto -650 -> 3194
    //   3847: astore 25
    //   3849: aload_0
    //   3850: astore 23
    //   3852: goto -658 -> 3194
    //   3855: astore 25
    //   3857: aload_0
    //   3858: astore 23
    //   3860: goto -666 -> 3194
    //   3863: astore 25
    //   3865: aload 26
    //   3867: astore 23
    //   3869: iload 9
    //   3871: istore 4
    //   3873: goto -929 -> 2944
    //   3876: astore 25
    //   3878: iconst_0
    //   3879: istore 4
    //   3881: goto -937 -> 2944
    //   3884: astore 25
    //   3886: aload_0
    //   3887: astore 23
    //   3889: goto -945 -> 2944
    //   3892: astore 25
    //   3894: aload_0
    //   3895: astore 23
    //   3897: goto -953 -> 2944
    //   3900: astore 24
    //   3902: aload_0
    //   3903: astore 23
    //   3905: goto -1252 -> 2653
    //   3908: astore 24
    //   3910: goto -1257 -> 2653
    //   3913: astore 24
    //   3915: aload_0
    //   3916: astore 23
    //   3918: goto -1265 -> 2653
    //   3921: astore_0
    //   3922: goto -1429 -> 2493
    //   3925: astore_0
    //   3926: iconst_0
    //   3927: istore 4
    //   3929: goto -1436 -> 2493
    //   3932: astore 24
    //   3934: aload_0
    //   3935: astore 23
    //   3937: lconst_0
    //   3938: lstore 14
    //   3940: aload 24
    //   3942: astore_0
    //   3943: goto -1450 -> 2493
    //   3946: astore 24
    //   3948: aload 23
    //   3950: astore_0
    //   3951: iconst_5
    //   3952: istore 4
    //   3954: aload 24
    //   3956: astore 23
    //   3958: goto -1519 -> 2439
    //   3961: astore 24
    //   3963: aload 23
    //   3965: astore_0
    //   3966: iconst_0
    //   3967: istore 4
    //   3969: aload 24
    //   3971: astore 23
    //   3973: goto -1534 -> 2439
    //   3976: astore 23
    //   3978: iconst_5
    //   3979: istore 4
    //   3981: goto -1542 -> 2439
    //   3984: aload_0
    //   3985: astore_3
    //   3986: aload 24
    //   3988: astore_0
    //   3989: goto -3672 -> 317
    //   3992: aload_3
    //   3993: astore_0
    //   3994: goto -1752 -> 2242
    //   3997: bipush 8
    //   3999: istore 7
    //   4001: goto -2766 -> 1235
    //   4004: ldc 20
    //   4006: astore 29
    //   4008: goto -2114 -> 1894
    //   4011: iconst_2
    //   4012: istore 4
    //   4014: goto -1278 -> 2736
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	4017	0	paramAppInterface	AppInterface
    //   0	4017	1	paramURL	URL
    //   0	4017	2	paramFile	File
    //   0	4017	3	paramNetworkInfo	NetworkInfo
    //   0	4017	4	paramInt1	int
    //   0	4017	5	paramString	String
    //   0	4017	6	paramInt2	int
    //   101	3899	7	i	int
    //   365	3445	8	j	int
    //   625	3245	9	k	int
    //   676	2728	10	m	int
    //   683	2728	11	n	int
    //   30	2322	12	i1	int
    //   315	2037	13	i2	int
    //   704	3235	14	l1	long
    //   836	3	16	l2	long
    //   3	945	18	l3	long
    //   701	498	20	l4	long
    //   2200	1436	22	bool	boolean
    //   114	1985	23	localObject1	Object
    //   2369	61	23	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   2437	1535	23	localObject2	Object
    //   3976	1	23	localFileNotFoundException1	java.io.FileNotFoundException
    //   125	2029	24	localObject3	Object
    //   2427	9	24	localFileNotFoundException2	java.io.FileNotFoundException
    //   2495	133	24	localObject4	Object
    //   2647	74	24	localIOException1	java.io.IOException
    //   2760	1031	24	localObject5	Object
    //   3900	1	24	localIOException2	java.io.IOException
    //   3908	1	24	localIOException3	java.io.IOException
    //   3913	1	24	localIOException4	java.io.IOException
    //   3932	9	24	localIOException5	java.io.IOException
    //   3946	9	24	localFileNotFoundException3	java.io.FileNotFoundException
    //   3961	26	24	localFileNotFoundException4	java.io.FileNotFoundException
    //   361	2789	25	localObject6	Object
    //   3184	62	25	localThrowable1	java.lang.Throwable
    //   3362	469	25	localObject7	Object
    //   3839	1	25	localThrowable2	java.lang.Throwable
    //   3847	1	25	localThrowable3	java.lang.Throwable
    //   3855	1	25	localThrowable4	java.lang.Throwable
    //   3863	1	25	localException1	Exception
    //   3876	1	25	localException2	Exception
    //   3884	1	25	localException3	Exception
    //   3892	1	25	localException4	Exception
    //   358	3508	26	localObject8	Object
    //   679	2728	27	localAppInterface	AppInterface
    //   87	2297	28	localHttpGet	org.apache.http.client.methods.HttpGet
    //   1725	2282	29	localObject9	Object
    //   67	3477	30	str1	String
    //   12	3765	31	localObject10	Object
    //   76	963	32	str2	String
    //   96	2316	33	localBasicHttpParams	org.apache.http.params.BasicHttpParams
    //   275	1856	34	localFile1	File
    //   587	1542	35	arrayOfHeader	Header[]
    //   606	1529	36	localHashMap	java.util.HashMap
    //   1523	564	37	str3	String
    //   1363	520	38	str4	String
    //   1560	1362	39	localFile2	File
    //   1601	158	40	localBitmap	android.graphics.Bitmap
    //   1643	1281	41	localFile3	File
    // Exception table:
    //   from	to	target	type
    //   40	45	2357	java/lang/Exception
    //   49	61	2357	java/lang/Exception
    //   78	89	2369	java/lang/IllegalArgumentException
    //   2371	2385	2388	java/lang/IllegalArgumentException
    //   771	779	2427	java/io/FileNotFoundException
    //   803	808	2427	java/io/FileNotFoundException
    //   832	838	2427	java/io/FileNotFoundException
    //   771	779	2489	java/io/IOException
    //   803	808	2489	java/io/IOException
    //   832	838	2489	java/io/IOException
    //   695	703	2647	java/io/IOException
    //   1145	1151	2647	java/io/IOException
    //   1182	1232	2647	java/io/IOException
    //   1271	1287	2647	java/io/IOException
    //   1318	1327	2647	java/io/IOException
    //   1358	1365	2647	java/io/IOException
    //   1396	1406	2647	java/io/IOException
    //   1437	1447	2647	java/io/IOException
    //   1478	1488	2647	java/io/IOException
    //   1519	1525	2647	java/io/IOException
    //   1556	1562	2647	java/io/IOException
    //   1593	1603	2647	java/io/IOException
    //   1634	1645	2647	java/io/IOException
    //   1681	1691	2647	java/io/IOException
    //   1722	1727	2647	java/io/IOException
    //   1758	1774	2647	java/io/IOException
    //   1805	1811	2647	java/io/IOException
    //   1842	1849	2647	java/io/IOException
    //   1880	1890	2647	java/io/IOException
    //   1925	1936	2647	java/io/IOException
    //   1967	1981	2647	java/io/IOException
    //   2012	2018	2647	java/io/IOException
    //   2049	2097	2647	java/io/IOException
    //   2128	2140	2647	java/io/IOException
    //   2597	2602	2647	java/io/IOException
    //   2636	2644	2647	java/io/IOException
    //   2921	2929	2647	java/io/IOException
    //   3135	3141	2647	java/io/IOException
    //   3172	3181	2647	java/io/IOException
    //   3385	3391	2647	java/io/IOException
    //   3422	3448	2647	java/io/IOException
    //   2781	2786	2876	java/lang/Exception
    //   2790	2802	2876	java/lang/Exception
    //   2812	2863	2876	java/lang/Exception
    //   695	703	2932	java/lang/Exception
    //   730	747	2932	java/lang/Exception
    //   1145	1151	2932	java/lang/Exception
    //   1182	1232	2932	java/lang/Exception
    //   1271	1287	2932	java/lang/Exception
    //   1318	1327	2932	java/lang/Exception
    //   1358	1365	2932	java/lang/Exception
    //   1396	1406	2932	java/lang/Exception
    //   1437	1447	2932	java/lang/Exception
    //   1478	1488	2932	java/lang/Exception
    //   1519	1525	2932	java/lang/Exception
    //   1556	1562	2932	java/lang/Exception
    //   1593	1603	2932	java/lang/Exception
    //   1634	1645	2932	java/lang/Exception
    //   1681	1691	2932	java/lang/Exception
    //   1722	1727	2932	java/lang/Exception
    //   1758	1774	2932	java/lang/Exception
    //   1805	1811	2932	java/lang/Exception
    //   1842	1849	2932	java/lang/Exception
    //   1880	1890	2932	java/lang/Exception
    //   1925	1936	2932	java/lang/Exception
    //   1967	1981	2932	java/lang/Exception
    //   2012	2018	2932	java/lang/Exception
    //   2049	2097	2932	java/lang/Exception
    //   2128	2140	2932	java/lang/Exception
    //   2597	2602	2932	java/lang/Exception
    //   2636	2644	2932	java/lang/Exception
    //   2921	2929	2932	java/lang/Exception
    //   3135	3141	2932	java/lang/Exception
    //   3172	3181	2932	java/lang/Exception
    //   3385	3391	2932	java/lang/Exception
    //   3422	3448	2932	java/lang/Exception
    //   695	703	3184	java/lang/Throwable
    //   730	747	3184	java/lang/Throwable
    //   1145	1151	3184	java/lang/Throwable
    //   1182	1232	3184	java/lang/Throwable
    //   1271	1287	3184	java/lang/Throwable
    //   1318	1327	3184	java/lang/Throwable
    //   1358	1365	3184	java/lang/Throwable
    //   1396	1406	3184	java/lang/Throwable
    //   1437	1447	3184	java/lang/Throwable
    //   1478	1488	3184	java/lang/Throwable
    //   1519	1525	3184	java/lang/Throwable
    //   1556	1562	3184	java/lang/Throwable
    //   1593	1603	3184	java/lang/Throwable
    //   1634	1645	3184	java/lang/Throwable
    //   1681	1691	3184	java/lang/Throwable
    //   1722	1727	3184	java/lang/Throwable
    //   1758	1774	3184	java/lang/Throwable
    //   1805	1811	3184	java/lang/Throwable
    //   1842	1849	3184	java/lang/Throwable
    //   1880	1890	3184	java/lang/Throwable
    //   1925	1936	3184	java/lang/Throwable
    //   1967	1981	3184	java/lang/Throwable
    //   2012	2018	3184	java/lang/Throwable
    //   2049	2097	3184	java/lang/Throwable
    //   2128	2140	3184	java/lang/Throwable
    //   2597	2602	3184	java/lang/Throwable
    //   2636	2644	3184	java/lang/Throwable
    //   2921	2929	3184	java/lang/Throwable
    //   3135	3141	3184	java/lang/Throwable
    //   3172	3181	3184	java/lang/Throwable
    //   3385	3391	3184	java/lang/Throwable
    //   3422	3448	3184	java/lang/Throwable
    //   695	703	3451	finally
    //   730	747	3451	finally
    //   1145	1151	3451	finally
    //   1182	1232	3451	finally
    //   1271	1287	3451	finally
    //   1318	1327	3451	finally
    //   1358	1365	3451	finally
    //   1396	1406	3451	finally
    //   1437	1447	3451	finally
    //   1478	1488	3451	finally
    //   1519	1525	3451	finally
    //   1556	1562	3451	finally
    //   1593	1603	3451	finally
    //   1634	1645	3451	finally
    //   1681	1691	3451	finally
    //   1722	1727	3451	finally
    //   1758	1774	3451	finally
    //   1805	1811	3451	finally
    //   1842	1849	3451	finally
    //   1880	1890	3451	finally
    //   1925	1936	3451	finally
    //   1967	1981	3451	finally
    //   2012	2018	3451	finally
    //   2049	2097	3451	finally
    //   2128	2140	3451	finally
    //   2597	2602	3451	finally
    //   2636	2644	3451	finally
    //   2921	2929	3451	finally
    //   2955	2961	3451	finally
    //   2972	3000	3451	finally
    //   3135	3141	3451	finally
    //   3172	3181	3451	finally
    //   3205	3211	3451	finally
    //   3222	3250	3451	finally
    //   3385	3391	3451	finally
    //   3422	3448	3451	finally
    //   2147	2153	3556	java/io/IOException
    //   2168	2173	3570	java/lang/Exception
    //   2177	2189	3570	java/lang/Exception
    //   2189	2240	3570	java/lang/Exception
    //   2740	2746	3653	java/io/IOException
    //   3007	3013	3667	java/io/IOException
    //   3023	3028	3681	java/lang/Exception
    //   3032	3044	3681	java/lang/Exception
    //   3044	3095	3681	java/lang/Exception
    //   3257	3263	3691	java/io/IOException
    //   3273	3278	3705	java/lang/Exception
    //   3282	3294	3705	java/lang/Exception
    //   3294	3345	3705	java/lang/Exception
    //   3462	3468	3715	java/io/IOException
    //   2323	2331	3775	finally
    //   2331	2334	3775	finally
    //   3776	3779	3775	finally
    //   2323	2331	3781	java/lang/InterruptedException
    //   3482	3487	3785	java/lang/Exception
    //   3491	3503	3785	java/lang/Exception
    //   3503	3554	3785	java/lang/Exception
    //   771	779	3789	finally
    //   803	808	3789	finally
    //   832	838	3789	finally
    //   866	874	3789	finally
    //   898	904	3789	finally
    //   928	980	3789	finally
    //   2517	2523	3789	finally
    //   2547	2557	3789	finally
    //   996	1025	3796	finally
    //   1037	1083	3796	finally
    //   2439	2486	3806	finally
    //   367	376	3814	finally
    //   391	400	3814	finally
    //   410	433	3814	finally
    //   443	449	3814	finally
    //   459	468	3814	finally
    //   478	487	3814	finally
    //   497	520	3814	finally
    //   530	551	3814	finally
    //   561	570	3814	finally
    //   580	589	3814	finally
    //   599	608	3814	finally
    //   618	627	3814	finally
    //   637	646	3814	finally
    //   2664	2670	3814	finally
    //   2681	2709	3814	finally
    //   2720	2727	3814	finally
    //   3587	3595	3814	finally
    //   3606	3614	3814	finally
    //   3628	3635	3814	finally
    //   771	779	3824	java/lang/Throwable
    //   803	808	3824	java/lang/Throwable
    //   832	838	3824	java/lang/Throwable
    //   866	874	3824	java/lang/Throwable
    //   898	904	3824	java/lang/Throwable
    //   928	980	3824	java/lang/Throwable
    //   2517	2523	3824	java/lang/Throwable
    //   2547	2557	3824	java/lang/Throwable
    //   996	1025	3839	java/lang/Throwable
    //   1037	1083	3839	java/lang/Throwable
    //   2439	2486	3847	java/lang/Throwable
    //   367	376	3855	java/lang/Throwable
    //   391	400	3855	java/lang/Throwable
    //   410	433	3855	java/lang/Throwable
    //   443	449	3855	java/lang/Throwable
    //   459	468	3855	java/lang/Throwable
    //   478	487	3855	java/lang/Throwable
    //   497	520	3855	java/lang/Throwable
    //   530	551	3855	java/lang/Throwable
    //   561	570	3855	java/lang/Throwable
    //   580	589	3855	java/lang/Throwable
    //   599	608	3855	java/lang/Throwable
    //   618	627	3855	java/lang/Throwable
    //   637	646	3855	java/lang/Throwable
    //   771	779	3863	java/lang/Exception
    //   803	808	3863	java/lang/Exception
    //   832	838	3863	java/lang/Exception
    //   866	874	3863	java/lang/Exception
    //   898	904	3863	java/lang/Exception
    //   928	980	3863	java/lang/Exception
    //   2517	2523	3863	java/lang/Exception
    //   2547	2557	3863	java/lang/Exception
    //   996	1025	3876	java/lang/Exception
    //   1037	1083	3876	java/lang/Exception
    //   2439	2486	3884	java/lang/Exception
    //   367	376	3892	java/lang/Exception
    //   391	400	3892	java/lang/Exception
    //   410	433	3892	java/lang/Exception
    //   443	449	3892	java/lang/Exception
    //   459	468	3892	java/lang/Exception
    //   478	487	3892	java/lang/Exception
    //   497	520	3892	java/lang/Exception
    //   530	551	3892	java/lang/Exception
    //   561	570	3892	java/lang/Exception
    //   580	589	3892	java/lang/Exception
    //   599	608	3892	java/lang/Exception
    //   618	627	3892	java/lang/Exception
    //   637	646	3892	java/lang/Exception
    //   2439	2486	3900	java/io/IOException
    //   2517	2523	3908	java/io/IOException
    //   2547	2557	3908	java/io/IOException
    //   367	376	3913	java/io/IOException
    //   391	400	3913	java/io/IOException
    //   410	433	3913	java/io/IOException
    //   443	449	3913	java/io/IOException
    //   459	468	3913	java/io/IOException
    //   478	487	3913	java/io/IOException
    //   497	520	3913	java/io/IOException
    //   530	551	3913	java/io/IOException
    //   561	570	3913	java/io/IOException
    //   580	589	3913	java/io/IOException
    //   599	608	3913	java/io/IOException
    //   618	627	3913	java/io/IOException
    //   637	646	3913	java/io/IOException
    //   866	874	3921	java/io/IOException
    //   898	904	3921	java/io/IOException
    //   928	980	3921	java/io/IOException
    //   996	1025	3925	java/io/IOException
    //   1037	1083	3925	java/io/IOException
    //   730	747	3932	java/io/IOException
    //   866	874	3946	java/io/FileNotFoundException
    //   898	904	3946	java/io/FileNotFoundException
    //   928	980	3946	java/io/FileNotFoundException
    //   996	1025	3961	java/io/FileNotFoundException
    //   1037	1083	3961	java/io/FileNotFoundException
    //   730	747	3976	java/io/FileNotFoundException
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
        break label215;
      }
      str2 = paramString;
      localObject1 = localObject2;
      paramString = new GZIPInputStream((InputStream)localObject3);
    }
    catch (Exception paramString) {}finally
    {
      int i;
      String str1;
      DataUtils.closeDataObject(str1);
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
    //   15: new 626	org/json/JSONObject
    //   18: dup
    //   19: invokespecial 627	org/json/JSONObject:<init>	()V
    //   22: astore 13
    //   24: aconst_null
    //   25: astore 10
    //   27: aload_0
    //   28: arraylength
    //   29: istore 5
    //   31: iload 5
    //   33: ifle -20 -> 13
    //   36: new 292	java/io/FileOutputStream
    //   39: dup
    //   40: aload_1
    //   41: invokespecial 295	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   44: astore 9
    //   46: iconst_0
    //   47: istore 4
    //   49: iload 4
    //   51: iload 5
    //   53: if_icmpge +296 -> 349
    //   56: aload_0
    //   57: iload 4
    //   59: aaload
    //   60: astore 11
    //   62: iload 6
    //   64: istore 7
    //   66: aload 9
    //   68: astore 10
    //   70: aload 11
    //   72: invokeinterface 599 1 0
    //   77: astore 14
    //   79: iload 6
    //   81: istore 7
    //   83: aload 9
    //   85: astore 10
    //   87: aload 11
    //   89: invokeinterface 602 1 0
    //   94: astore 12
    //   96: aload 12
    //   98: astore 11
    //   100: aload_3
    //   101: ifnull +43 -> 144
    //   104: aload 12
    //   106: astore 11
    //   108: iload 6
    //   110: istore 7
    //   112: aload 9
    //   114: astore 10
    //   116: aload_3
    //   117: aload 14
    //   119: invokevirtual 630	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   122: ifeq +22 -> 144
    //   125: iload 6
    //   127: istore 7
    //   129: aload 9
    //   131: astore 10
    //   133: aload_3
    //   134: aload 14
    //   136: invokevirtual 634	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   139: checkcast 72	java/lang/String
    //   142: astore 11
    //   144: iload 6
    //   146: istore 7
    //   148: aload 9
    //   150: astore 10
    //   152: ldc_w 636
    //   155: aload 14
    //   157: invokevirtual 345	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   160: ifne +407 -> 567
    //   163: iload 6
    //   165: istore 7
    //   167: aload 9
    //   169: astore 10
    //   171: ldc_w 638
    //   174: aload 14
    //   176: invokevirtual 345	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   179: ifne +388 -> 567
    //   182: iload 6
    //   184: istore 7
    //   186: aload 9
    //   188: astore 10
    //   190: ldc_w 640
    //   193: aload 14
    //   195: invokevirtual 345	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   198: ifeq +6 -> 204
    //   201: goto +366 -> 567
    //   204: iload 6
    //   206: istore 7
    //   208: aload 9
    //   210: astore 10
    //   212: aload_2
    //   213: invokestatic 643	cooperation/qzone/webviewplugin/QzoneOfflinePluginJsForQQ:checkDownloadFont	(Ljava/lang/String;)Z
    //   216: ifeq +29 -> 245
    //   219: iload 6
    //   221: istore 7
    //   223: aload 9
    //   225: astore 10
    //   227: ldc_w 338
    //   230: aload 14
    //   232: invokevirtual 345	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   235: istore 8
    //   237: iload 8
    //   239: ifeq +6 -> 245
    //   242: goto +325 -> 567
    //   245: iload 6
    //   247: istore 7
    //   249: aload 9
    //   251: astore 10
    //   253: aload 13
    //   255: aload 14
    //   257: aload 11
    //   259: invokevirtual 646	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   262: pop
    //   263: iload 6
    //   265: istore 7
    //   267: aload 9
    //   269: astore 10
    //   271: new 201	java/lang/StringBuilder
    //   274: dup
    //   275: invokespecial 202	java/lang/StringBuilder:<init>	()V
    //   278: ldc_w 648
    //   281: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: aload 14
    //   286: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: ldc_w 650
    //   292: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: aload 11
    //   297: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   303: invokestatic 239	cooperation/qzone/webviewplugin/QzoneOfflinePluginJsForQQ:detaillog	(Ljava/lang/String;)V
    //   306: goto +261 -> 567
    //   309: astore 11
    //   311: iload 6
    //   313: istore 7
    //   315: aload 9
    //   317: astore 10
    //   319: invokestatic 316	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   322: ifeq +254 -> 576
    //   325: iload 6
    //   327: istore 7
    //   329: aload 9
    //   331: astore 10
    //   333: ldc 30
    //   335: iconst_2
    //   336: aload 11
    //   338: invokevirtual 653	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   341: aload 11
    //   343: invokestatic 475	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   346: goto +230 -> 576
    //   349: iload 6
    //   351: ifeq +56 -> 407
    //   354: iload 6
    //   356: istore 7
    //   358: aload 9
    //   360: astore 10
    //   362: aload 9
    //   364: aload 13
    //   366: invokevirtual 654	org/json/JSONObject:toString	()Ljava/lang/String;
    //   369: ldc_w 656
    //   372: invokevirtual 660	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   375: invokevirtual 664	java/io/FileOutputStream:write	([B)V
    //   378: iload 6
    //   380: istore 7
    //   382: aload 9
    //   384: astore 10
    //   386: aload 9
    //   388: invokevirtual 665	java/io/FileOutputStream:flush	()V
    //   391: iload 6
    //   393: istore 7
    //   395: aload 9
    //   397: astore 10
    //   399: aload_1
    //   400: invokestatic 95	java/lang/System:currentTimeMillis	()J
    //   403: invokevirtual 313	java/io/File:setLastModified	(J)Z
    //   406: pop
    //   407: aload 9
    //   409: invokestatic 441	cooperation/qzone/util/DataUtils:closeDataObject	(Ljava/lang/Object;)Z
    //   412: pop
    //   413: iload 6
    //   415: ireturn
    //   416: astore_0
    //   417: iload 7
    //   419: istore 6
    //   421: aload 10
    //   423: astore_0
    //   424: ldc 30
    //   426: iconst_1
    //   427: new 201	java/lang/StringBuilder
    //   430: dup
    //   431: invokespecial 202	java/lang/StringBuilder:<init>	()V
    //   434: ldc_w 470
    //   437: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   440: aload_1
    //   441: invokevirtual 116	java/io/File:exists	()Z
    //   444: invokevirtual 446	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   447: ldc_w 472
    //   450: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   453: aload_1
    //   454: invokevirtual 112	java/io/File:getParentFile	()Ljava/io/File;
    //   457: invokevirtual 116	java/io/File:exists	()Z
    //   460: invokevirtual 446	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   463: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   466: invokestatic 106	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   469: aload_0
    //   470: invokestatic 441	cooperation/qzone/util/DataUtils:closeDataObject	(Ljava/lang/Object;)Z
    //   473: pop
    //   474: iconst_0
    //   475: ireturn
    //   476: astore_0
    //   477: aconst_null
    //   478: astore 9
    //   480: iload 8
    //   482: istore 6
    //   484: iload 6
    //   486: istore 7
    //   488: aload 9
    //   490: astore 10
    //   492: invokestatic 316	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   495: ifeq +22 -> 517
    //   498: iload 6
    //   500: istore 7
    //   502: aload 9
    //   504: astore 10
    //   506: ldc 30
    //   508: iconst_2
    //   509: aload_0
    //   510: invokevirtual 666	java/io/IOException:getMessage	()Ljava/lang/String;
    //   513: aload_0
    //   514: invokestatic 475	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   517: aload 9
    //   519: invokestatic 441	cooperation/qzone/util/DataUtils:closeDataObject	(Ljava/lang/Object;)Z
    //   522: pop
    //   523: iconst_0
    //   524: ireturn
    //   525: astore_0
    //   526: iconst_1
    //   527: istore 6
    //   529: aconst_null
    //   530: astore 10
    //   532: aload 10
    //   534: invokestatic 441	cooperation/qzone/util/DataUtils:closeDataObject	(Ljava/lang/Object;)Z
    //   537: pop
    //   538: iload 6
    //   540: ireturn
    //   541: astore_0
    //   542: iload 7
    //   544: istore 6
    //   546: goto -14 -> 532
    //   549: astore_1
    //   550: aload_0
    //   551: astore 10
    //   553: goto -21 -> 532
    //   556: astore_0
    //   557: goto -73 -> 484
    //   560: astore_0
    //   561: aload 9
    //   563: astore_0
    //   564: goto -140 -> 424
    //   567: iload 4
    //   569: iconst_1
    //   570: iadd
    //   571: istore 4
    //   573: goto -524 -> 49
    //   576: iconst_0
    //   577: istore 6
    //   579: goto -12 -> 567
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	582	0	paramArrayOfHeader	Header[]
    //   0	582	1	paramFile	File
    //   0	582	2	paramString	String
    //   0	582	3	paramHashMap	java.util.HashMap<String, String>
    //   47	525	4	i	int
    //   29	25	5	j	int
    //   7	571	6	bool1	boolean
    //   1	542	7	bool2	boolean
    //   4	477	8	bool3	boolean
    //   44	518	9	localFileOutputStream	java.io.FileOutputStream
    //   25	527	10	localObject1	Object
    //   60	236	11	localObject2	Object
    //   309	33	11	localJSONException	org.json.JSONException
    //   94	11	12	str1	String
    //   22	343	13	localJSONObject	org.json.JSONObject
    //   77	208	14	str2	String
    // Exception table:
    //   from	to	target	type
    //   253	263	309	org/json/JSONException
    //   271	306	309	org/json/JSONException
    //   36	46	416	java/io/FileNotFoundException
    //   36	46	476	java/io/IOException
    //   36	46	525	finally
    //   70	79	541	finally
    //   87	96	541	finally
    //   116	125	541	finally
    //   133	144	541	finally
    //   152	163	541	finally
    //   171	182	541	finally
    //   190	201	541	finally
    //   212	219	541	finally
    //   227	237	541	finally
    //   253	263	541	finally
    //   271	306	541	finally
    //   319	325	541	finally
    //   333	346	541	finally
    //   362	378	541	finally
    //   386	391	541	finally
    //   399	407	541	finally
    //   492	498	541	finally
    //   506	517	541	finally
    //   424	469	549	finally
    //   70	79	556	java/io/IOException
    //   87	96	556	java/io/IOException
    //   116	125	556	java/io/IOException
    //   133	144	556	java/io/IOException
    //   152	163	556	java/io/IOException
    //   171	182	556	java/io/IOException
    //   190	201	556	java/io/IOException
    //   212	219	556	java/io/IOException
    //   227	237	556	java/io/IOException
    //   253	263	556	java/io/IOException
    //   271	306	556	java/io/IOException
    //   319	325	556	java/io/IOException
    //   333	346	556	java/io/IOException
    //   362	378	556	java/io/IOException
    //   386	391	556	java/io/IOException
    //   399	407	556	java/io/IOException
    //   70	79	560	java/io/FileNotFoundException
    //   87	96	560	java/io/FileNotFoundException
    //   116	125	560	java/io/FileNotFoundException
    //   133	144	560	java/io/FileNotFoundException
    //   152	163	560	java/io/FileNotFoundException
    //   171	182	560	java/io/FileNotFoundException
    //   190	201	560	java/io/FileNotFoundException
    //   212	219	560	java/io/FileNotFoundException
    //   227	237	560	java/io/FileNotFoundException
    //   253	263	560	java/io/FileNotFoundException
    //   271	306	560	java/io/FileNotFoundException
    //   319	325	560	java/io/FileNotFoundException
    //   333	346	560	java/io/FileNotFoundException
    //   362	378	560	java/io/FileNotFoundException
    //   386	391	560	java/io/FileNotFoundException
    //   399	407	560	java/io/FileNotFoundException
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.util.QZoneHttpDownloadUtil
 * JD-Core Version:    0.7.0.1
 */