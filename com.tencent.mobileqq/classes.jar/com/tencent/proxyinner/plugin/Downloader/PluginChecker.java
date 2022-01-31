package com.tencent.proxyinner.plugin.Downloader;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.proxyinner.log.XLog;
import com.tencent.proxyinner.plugin.LocalPlugin;
import com.tencent.proxyinner.utility.DeviceUtil;
import com.tencent.proxyinner.utility.UtilMisc;
import com.tencent.txproxy.HostInterface;

public class PluginChecker
{
  private static final String CONFIGURL_ACNOW = "http://now.qq.com/cgi-bin/now/web/version/now_ver?apptype=acnow&platform=2";
  private static final String CONFIGURL_DEFAULT_HUAYANG = "http://tiantian.qq.com/cgi-bin/hylove/version?platform=2&apptype=";
  private static final String CONFIGURL_DEFAULT_NOW = "http://now.qq.com/cgi-bin/now/web/version/now_ver?platform=2&apptype=";
  private static final String CONFIGURL_HY = "http://tiantian.qq.com/cgi-bin/hylove/version?apptype=hy&platform=2";
  private static final String CONFIGURL_LIVE = "http://now.qq.com/cgi-bin/now/web/version/now_ver?apptype=now&platform=2";
  private static final String CONFIGURL_OD = "http://tiantian.qq.com/cgi-bin/hylove/version?apptype=od&platform=2";
  private static final String CONFIGURL_QZNOW = "http://now.qq.com/cgi-bin/now/web/version/now_ver?apptype=qznow&platform=2";
  public static final int CS_CHECKED = 2;
  public static final int CS_CHECKING = 1;
  public static final int CS_NO_CHECK = 0;
  private static final String NOW_DOMAIN = "now.qq.com";
  private static final String TAG = "ODSDK | PluginChecker";
  String mAppId;
  Event mEvent = null;
  private Handler mHandler = new Handler(Looper.getMainLooper());
  private HostInterface mHostInterface;
  protected boolean mIsLastReqIpConn = false;
  String mJson = "";
  String mLastError;
  String mLastHeadInfo;
  int mLastHttpResponseCode;
  long mLastUpdateTime = 0L;
  String mReqUrl;
  int mStatus = 0;
  long mUin;
  UpdateParam mUpdateParam = new UpdateParam();
  LocalPlugin pluginMgr;
  
  public PluginChecker(LocalPlugin paramLocalPlugin, String paramString)
  {
    this.mAppId = paramString;
    this.pluginMgr = paramLocalPlugin;
  }
  
  /* Error */
  private String downloadBuffer(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: invokestatic 123	java/lang/System:currentTimeMillis	()J
    //   3: lstore 16
    //   5: ldc 46
    //   7: new 125	java/lang/StringBuilder
    //   10: dup
    //   11: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   14: ldc 128
    //   16: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: aload_1
    //   20: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   26: invokestatic 142	com/tencent/proxyinner/log/XLog:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   29: pop
    //   30: aconst_null
    //   31: astore 21
    //   33: aconst_null
    //   34: astore 20
    //   36: iconst_0
    //   37: istore_3
    //   38: iconst_0
    //   39: istore 5
    //   41: iconst_0
    //   42: istore 4
    //   44: lconst_0
    //   45: lstore 14
    //   47: lload 14
    //   49: lstore 12
    //   51: aload 20
    //   53: astore 18
    //   55: new 144	java/net/URL
    //   58: dup
    //   59: aload_1
    //   60: invokespecial 147	java/net/URL:<init>	(Ljava/lang/String;)V
    //   63: astore 22
    //   65: lload 14
    //   67: lstore 12
    //   69: aload 22
    //   71: invokevirtual 150	java/net/URL:getHost	()Ljava/lang/String;
    //   74: astore 25
    //   76: ldc 79
    //   78: astore 24
    //   80: ldc 79
    //   82: astore 23
    //   84: iconst_0
    //   85: istore 8
    //   87: lload 14
    //   89: lstore 12
    //   91: aload_0
    //   92: getfield 152	com/tencent/proxyinner/plugin/Downloader/PluginChecker:mHostInterface	Lcom/tencent/txproxy/HostInterface;
    //   95: ifnull +18 -> 113
    //   98: lload 14
    //   100: lstore 12
    //   102: aload_0
    //   103: getfield 152	com/tencent/proxyinner/plugin/Downloader/PluginChecker:mHostInterface	Lcom/tencent/txproxy/HostInterface;
    //   106: invokeinterface 158 1 0
    //   111: istore 8
    //   113: lload 14
    //   115: lstore 12
    //   117: invokestatic 163	com/tencent/proxyinner/utility/NetworkUtil:hasProxy	()Z
    //   120: istore 9
    //   122: lload 14
    //   124: lstore 10
    //   126: aload 24
    //   128: astore 18
    //   130: aload 23
    //   132: astore 19
    //   134: iload_2
    //   135: ifeq +168 -> 303
    //   138: lload 14
    //   140: lstore 10
    //   142: aload 24
    //   144: astore 18
    //   146: aload 23
    //   148: astore 19
    //   150: iload 8
    //   152: ifeq +151 -> 303
    //   155: lload 14
    //   157: lstore 10
    //   159: aload 24
    //   161: astore 18
    //   163: aload 23
    //   165: astore 19
    //   167: iload 9
    //   169: ifne +134 -> 303
    //   172: lload 14
    //   174: lstore 10
    //   176: aload 24
    //   178: astore 18
    //   180: aload 23
    //   182: astore 19
    //   184: lload 14
    //   186: lstore 12
    //   188: aload_0
    //   189: getfield 152	com/tencent/proxyinner/plugin/Downloader/PluginChecker:mHostInterface	Lcom/tencent/txproxy/HostInterface;
    //   192: ifnull +111 -> 303
    //   195: lload 14
    //   197: lstore 10
    //   199: aload 24
    //   201: astore 18
    //   203: aload 23
    //   205: astore 19
    //   207: lload 14
    //   209: lstore 12
    //   211: ldc 43
    //   213: aload 25
    //   215: invokevirtual 169	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   218: ifeq +85 -> 303
    //   221: lload 14
    //   223: lstore 12
    //   225: invokestatic 123	java/lang/System:currentTimeMillis	()J
    //   228: lstore 10
    //   230: lload 14
    //   232: lstore 12
    //   234: aload_0
    //   235: getfield 152	com/tencent/proxyinner/plugin/Downloader/PluginChecker:mHostInterface	Lcom/tencent/txproxy/HostInterface;
    //   238: aload 25
    //   240: invokeinterface 173 2 0
    //   245: astore 24
    //   247: lload 14
    //   249: lstore 12
    //   251: invokestatic 123	java/lang/System:currentTimeMillis	()J
    //   254: lload 10
    //   256: lsub
    //   257: lstore 14
    //   259: lload 14
    //   261: lstore 10
    //   263: aload 24
    //   265: astore 18
    //   267: aload 23
    //   269: astore 19
    //   271: lload 14
    //   273: lstore 12
    //   275: aload 24
    //   277: invokestatic 179	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   280: ifne +23 -> 303
    //   283: lload 14
    //   285: lstore 12
    //   287: aload_1
    //   288: aload 24
    //   290: invokestatic 183	com/tencent/proxyinner/utility/NetworkUtil:replaceDomainWithIp	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   293: astore 19
    //   295: aload 24
    //   297: astore 18
    //   299: lload 14
    //   301: lstore 10
    //   303: lload 10
    //   305: lstore 12
    //   307: ldc 46
    //   309: new 125	java/lang/StringBuilder
    //   312: dup
    //   313: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   316: ldc 185
    //   318: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: iload_2
    //   322: invokevirtual 188	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   325: ldc 190
    //   327: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: iload 8
    //   332: invokevirtual 188	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   335: ldc 192
    //   337: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: iload 9
    //   342: invokevirtual 188	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   345: ldc 194
    //   347: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: aload 25
    //   352: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: ldc 196
    //   357: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   360: aload 18
    //   362: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: ldc 198
    //   367: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   370: lload 10
    //   372: invokevirtual 201	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   375: ldc 203
    //   377: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   380: aload 19
    //   382: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   385: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   388: invokestatic 142	com/tencent/proxyinner/log/XLog:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   391: pop
    //   392: lload 10
    //   394: lstore 12
    //   396: aload 19
    //   398: invokestatic 179	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   401: ifne +722 -> 1123
    //   404: lload 10
    //   406: lstore 12
    //   408: new 144	java/net/URL
    //   411: dup
    //   412: aload 19
    //   414: invokespecial 147	java/net/URL:<init>	(Ljava/lang/String;)V
    //   417: astore_1
    //   418: iconst_1
    //   419: istore_3
    //   420: iconst_1
    //   421: istore 4
    //   423: lload 10
    //   425: lstore 12
    //   427: aload 20
    //   429: astore 18
    //   431: aload_0
    //   432: iconst_1
    //   433: putfield 90	com/tencent/proxyinner/plugin/Downloader/PluginChecker:mIsLastReqIpConn	Z
    //   436: lload 10
    //   438: lstore 12
    //   440: aload 20
    //   442: astore 18
    //   444: iload 4
    //   446: istore_3
    //   447: ldc 46
    //   449: ldc 205
    //   451: invokestatic 142	com/tencent/proxyinner/log/XLog:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   454: pop
    //   455: lload 10
    //   457: lstore 12
    //   459: aload 20
    //   461: astore 18
    //   463: iload 4
    //   465: istore_3
    //   466: aload_1
    //   467: invokevirtual 209	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   470: astore 19
    //   472: lload 10
    //   474: lstore 12
    //   476: aload 19
    //   478: astore 18
    //   480: iload 4
    //   482: istore_3
    //   483: ldc 46
    //   485: ldc 211
    //   487: invokestatic 142	com/tencent/proxyinner/log/XLog:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   490: pop
    //   491: lload 10
    //   493: lstore 12
    //   495: aload 19
    //   497: astore 18
    //   499: iload 4
    //   501: istore_3
    //   502: aload 19
    //   504: iconst_0
    //   505: invokevirtual 217	java/net/URLConnection:setUseCaches	(Z)V
    //   508: iload 4
    //   510: ifeq +60 -> 570
    //   513: lload 10
    //   515: lstore 12
    //   517: aload 19
    //   519: astore 18
    //   521: iload 4
    //   523: istore_3
    //   524: aload 19
    //   526: ldc 219
    //   528: aload 25
    //   530: invokevirtual 223	java/net/URLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   533: lload 10
    //   535: lstore 12
    //   537: aload 19
    //   539: astore 18
    //   541: iload 4
    //   543: istore_3
    //   544: ldc 46
    //   546: new 125	java/lang/StringBuilder
    //   549: dup
    //   550: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   553: ldc 225
    //   555: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   558: aload 25
    //   560: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   563: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   566: invokestatic 142	com/tencent/proxyinner/log/XLog:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   569: pop
    //   570: lload 10
    //   572: lstore 12
    //   574: aload 19
    //   576: astore 18
    //   578: iload 4
    //   580: istore_3
    //   581: aload 19
    //   583: ldc 227
    //   585: ldc 229
    //   587: invokevirtual 223	java/net/URLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   590: lload 10
    //   592: lstore 12
    //   594: aload 19
    //   596: astore 18
    //   598: iload 4
    //   600: istore_3
    //   601: ldc 46
    //   603: ldc 231
    //   605: invokestatic 142	com/tencent/proxyinner/log/XLog:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   608: pop
    //   609: lload 10
    //   611: lstore 12
    //   613: aload 19
    //   615: astore 18
    //   617: iload 4
    //   619: istore_3
    //   620: aload 19
    //   622: checkcast 233	java/net/HttpURLConnection
    //   625: astore_1
    //   626: aload_1
    //   627: ifnull +22 -> 649
    //   630: lload 10
    //   632: lstore 12
    //   634: aload 19
    //   636: astore 18
    //   638: iload 4
    //   640: istore_3
    //   641: aload_0
    //   642: aload_1
    //   643: invokevirtual 237	java/net/HttpURLConnection:getResponseCode	()I
    //   646: putfield 239	com/tencent/proxyinner/plugin/Downloader/PluginChecker:mLastHttpResponseCode	I
    //   649: lload 10
    //   651: lstore 12
    //   653: aload 19
    //   655: astore 18
    //   657: iload 4
    //   659: istore_3
    //   660: ldc 46
    //   662: new 125	java/lang/StringBuilder
    //   665: dup
    //   666: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   669: ldc 241
    //   671: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   674: aload_0
    //   675: getfield 239	com/tencent/proxyinner/plugin/Downloader/PluginChecker:mLastHttpResponseCode	I
    //   678: invokevirtual 244	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   681: ldc 246
    //   683: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   686: aload_1
    //   687: invokevirtual 249	java/net/HttpURLConnection:getContentLength	()I
    //   690: invokevirtual 244	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   693: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   696: invokestatic 142	com/tencent/proxyinner/log/XLog:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   699: pop
    //   700: lload 10
    //   702: lstore 12
    //   704: aload 19
    //   706: astore 18
    //   708: iload 4
    //   710: istore_3
    //   711: aload 19
    //   713: invokevirtual 252	java/net/URLConnection:getContentEncoding	()Ljava/lang/String;
    //   716: pop
    //   717: lload 10
    //   719: lstore 12
    //   721: aload 19
    //   723: astore 18
    //   725: iload 4
    //   727: istore_3
    //   728: ldc 254
    //   730: aload 19
    //   732: invokevirtual 252	java/net/URLConnection:getContentEncoding	()Ljava/lang/String;
    //   735: invokevirtual 169	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   738: ifeq +400 -> 1138
    //   741: lload 10
    //   743: lstore 12
    //   745: aload 19
    //   747: astore 18
    //   749: iload 4
    //   751: istore_3
    //   752: new 256	java/io/InputStreamReader
    //   755: dup
    //   756: new 258	java/util/zip/GZIPInputStream
    //   759: dup
    //   760: aload 19
    //   762: invokevirtual 262	java/net/URLConnection:getInputStream	()Ljava/io/InputStream;
    //   765: invokespecial 265	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   768: invokespecial 266	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   771: astore_1
    //   772: lload 10
    //   774: lstore 12
    //   776: aload 19
    //   778: astore 18
    //   780: iload 4
    //   782: istore_3
    //   783: new 268	java/io/BufferedReader
    //   786: dup
    //   787: aload_1
    //   788: invokespecial 271	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   791: astore_1
    //   792: lload 10
    //   794: lstore 12
    //   796: aload 19
    //   798: astore 18
    //   800: iload 4
    //   802: istore_3
    //   803: new 125	java/lang/StringBuilder
    //   806: dup
    //   807: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   810: astore 20
    //   812: lload 10
    //   814: lstore 12
    //   816: aload 19
    //   818: astore 18
    //   820: iload 4
    //   822: istore_3
    //   823: aload_1
    //   824: invokevirtual 274	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   827: astore 21
    //   829: aload 21
    //   831: ifnull +334 -> 1165
    //   834: lload 10
    //   836: lstore 12
    //   838: aload 19
    //   840: astore 18
    //   842: iload 4
    //   844: istore_3
    //   845: aload 20
    //   847: aload 21
    //   849: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   852: pop
    //   853: goto -41 -> 812
    //   856: astore_1
    //   857: invokestatic 123	java/lang/System:currentTimeMillis	()J
    //   860: lstore 10
    //   862: aload 18
    //   864: ifnull +146 -> 1010
    //   867: aload 18
    //   869: invokevirtual 278	java/net/URLConnection:getHeaderFields	()Ljava/util/Map;
    //   872: astore 19
    //   874: ldc 46
    //   876: ldc_w 280
    //   879: invokestatic 142	com/tencent/proxyinner/log/XLog:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   882: pop
    //   883: new 125	java/lang/StringBuilder
    //   886: dup
    //   887: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   890: astore 18
    //   892: aload 19
    //   894: ifnull +482 -> 1376
    //   897: aload 19
    //   899: invokeinterface 286 1 0
    //   904: invokeinterface 292 1 0
    //   909: astore 19
    //   911: aload 19
    //   913: invokeinterface 297 1 0
    //   918: ifeq +458 -> 1376
    //   921: aload 19
    //   923: invokeinterface 301 1 0
    //   928: checkcast 303	java/util/Map$Entry
    //   931: astore 20
    //   933: aload 20
    //   935: ifnull -24 -> 911
    //   938: aload 18
    //   940: new 125	java/lang/StringBuilder
    //   943: dup
    //   944: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   947: aload 20
    //   949: invokeinterface 306 1 0
    //   954: invokevirtual 309	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   957: ldc_w 311
    //   960: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   963: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   966: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   969: pop
    //   970: goto -59 -> 911
    //   973: astore 18
    //   975: aload 18
    //   977: invokevirtual 314	java/lang/Exception:printStackTrace	()V
    //   980: ldc 46
    //   982: new 125	java/lang/StringBuilder
    //   985: dup
    //   986: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   989: ldc_w 316
    //   992: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   995: aload 18
    //   997: invokevirtual 317	java/lang/Exception:toString	()Ljava/lang/String;
    //   1000: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1003: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1006: invokestatic 142	com/tencent/proxyinner/log/XLog:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   1009: pop
    //   1010: aload_0
    //   1011: aload_1
    //   1012: invokevirtual 317	java/lang/Exception:toString	()Ljava/lang/String;
    //   1015: putfield 319	com/tencent/proxyinner/plugin/Downloader/PluginChecker:mLastError	Ljava/lang/String;
    //   1018: aload_1
    //   1019: invokevirtual 314	java/lang/Exception:printStackTrace	()V
    //   1022: ldc 46
    //   1024: new 125	java/lang/StringBuilder
    //   1027: dup
    //   1028: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   1031: ldc_w 321
    //   1034: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1037: aload_1
    //   1038: invokevirtual 317	java/lang/Exception:toString	()Ljava/lang/String;
    //   1041: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1044: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1047: invokestatic 142	com/tencent/proxyinner/log/XLog:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   1050: pop
    //   1051: iload_3
    //   1052: ifeq +336 -> 1388
    //   1055: iconst_1
    //   1056: istore 4
    //   1058: iconst_0
    //   1059: istore_3
    //   1060: aload_0
    //   1061: getfield 152	com/tencent/proxyinner/plugin/Downloader/PluginChecker:mHostInterface	Lcom/tencent/txproxy/HostInterface;
    //   1064: ifnull +17 -> 1081
    //   1067: aload_0
    //   1068: getfield 152	com/tencent/proxyinner/plugin/Downloader/PluginChecker:mHostInterface	Lcom/tencent/txproxy/HostInterface;
    //   1071: invokeinterface 324 1 0
    //   1076: ifeq +318 -> 1394
    //   1079: iconst_0
    //   1080: istore_3
    //   1081: aload_0
    //   1082: getfield 239	com/tencent/proxyinner/plugin/Downloader/PluginChecker:mLastHttpResponseCode	I
    //   1085: sipush 200
    //   1088: if_icmpne +311 -> 1399
    //   1091: iconst_0
    //   1092: istore 5
    //   1094: aload_0
    //   1095: getfield 105	com/tencent/proxyinner/plugin/Downloader/PluginChecker:mAppId	Ljava/lang/String;
    //   1098: invokestatic 330	com/tencent/proxyinner/report/DataReport:getInstance	(Ljava/lang/String;)Lcom/tencent/proxyinner/report/DataReport;
    //   1101: lload 10
    //   1103: lload 16
    //   1105: lsub
    //   1106: lload 12
    //   1108: iload 5
    //   1110: iload 4
    //   1112: aload_0
    //   1113: getfield 319	com/tencent/proxyinner/plugin/Downloader/PluginChecker:mLastError	Ljava/lang/String;
    //   1116: iload_3
    //   1117: invokevirtual 334	com/tencent/proxyinner/report/DataReport:reportConfigCheck	(JJIILjava/lang/String;I)V
    //   1120: ldc 79
    //   1122: areturn
    //   1123: lload 10
    //   1125: lstore 12
    //   1127: aload_0
    //   1128: iconst_0
    //   1129: putfield 90	com/tencent/proxyinner/plugin/Downloader/PluginChecker:mIsLastReqIpConn	Z
    //   1132: aload 22
    //   1134: astore_1
    //   1135: goto -699 -> 436
    //   1138: lload 10
    //   1140: lstore 12
    //   1142: aload 19
    //   1144: astore 18
    //   1146: iload 4
    //   1148: istore_3
    //   1149: new 256	java/io/InputStreamReader
    //   1152: dup
    //   1153: aload 19
    //   1155: invokevirtual 262	java/net/URLConnection:getInputStream	()Ljava/io/InputStream;
    //   1158: invokespecial 266	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   1161: astore_1
    //   1162: goto -390 -> 772
    //   1165: lload 10
    //   1167: lstore 12
    //   1169: aload 19
    //   1171: astore 18
    //   1173: iload 4
    //   1175: istore_3
    //   1176: aload 20
    //   1178: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1181: astore_1
    //   1182: lload 10
    //   1184: lstore 12
    //   1186: aload 19
    //   1188: astore 18
    //   1190: iload 4
    //   1192: istore_3
    //   1193: invokestatic 123	java/lang/System:currentTimeMillis	()J
    //   1196: lstore 14
    //   1198: lload 10
    //   1200: lstore 12
    //   1202: aload 19
    //   1204: astore 18
    //   1206: iload 4
    //   1208: istore_3
    //   1209: ldc 46
    //   1211: new 125	java/lang/StringBuilder
    //   1214: dup
    //   1215: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   1218: ldc_w 336
    //   1221: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1224: lload 14
    //   1226: lload 16
    //   1228: lsub
    //   1229: invokevirtual 201	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1232: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1235: invokestatic 142	com/tencent/proxyinner/log/XLog:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   1238: pop
    //   1239: iload 4
    //   1241: ifeq +178 -> 1419
    //   1244: iconst_1
    //   1245: istore 6
    //   1247: iconst_0
    //   1248: istore 5
    //   1250: lload 10
    //   1252: lstore 12
    //   1254: aload 19
    //   1256: astore 18
    //   1258: iload 4
    //   1260: istore_3
    //   1261: aload_0
    //   1262: getfield 152	com/tencent/proxyinner/plugin/Downloader/PluginChecker:mHostInterface	Lcom/tencent/txproxy/HostInterface;
    //   1265: ifnull +29 -> 1294
    //   1268: lload 10
    //   1270: lstore 12
    //   1272: aload 19
    //   1274: astore 18
    //   1276: iload 4
    //   1278: istore_3
    //   1279: aload_0
    //   1280: getfield 152	com/tencent/proxyinner/plugin/Downloader/PluginChecker:mHostInterface	Lcom/tencent/txproxy/HostInterface;
    //   1283: invokeinterface 324 1 0
    //   1288: ifeq +137 -> 1425
    //   1291: iconst_0
    //   1292: istore 5
    //   1294: lload 10
    //   1296: lstore 12
    //   1298: aload 19
    //   1300: astore 18
    //   1302: iload 4
    //   1304: istore_3
    //   1305: aload_0
    //   1306: getfield 239	com/tencent/proxyinner/plugin/Downloader/PluginChecker:mLastHttpResponseCode	I
    //   1309: sipush 200
    //   1312: if_icmpne +44 -> 1356
    //   1315: iconst_0
    //   1316: istore 7
    //   1318: lload 10
    //   1320: lstore 12
    //   1322: aload 19
    //   1324: astore 18
    //   1326: iload 4
    //   1328: istore_3
    //   1329: aload_0
    //   1330: getfield 105	com/tencent/proxyinner/plugin/Downloader/PluginChecker:mAppId	Ljava/lang/String;
    //   1333: invokestatic 330	com/tencent/proxyinner/report/DataReport:getInstance	(Ljava/lang/String;)Lcom/tencent/proxyinner/report/DataReport;
    //   1336: lload 14
    //   1338: lload 16
    //   1340: lsub
    //   1341: lload 10
    //   1343: iload 7
    //   1345: iload 6
    //   1347: ldc 79
    //   1349: iload 5
    //   1351: invokevirtual 334	com/tencent/proxyinner/report/DataReport:reportConfigCheck	(JJIILjava/lang/String;I)V
    //   1354: aload_1
    //   1355: areturn
    //   1356: lload 10
    //   1358: lstore 12
    //   1360: aload 19
    //   1362: astore 18
    //   1364: iload 4
    //   1366: istore_3
    //   1367: aload_0
    //   1368: getfield 239	com/tencent/proxyinner/plugin/Downloader/PluginChecker:mLastHttpResponseCode	I
    //   1371: istore 7
    //   1373: goto -55 -> 1318
    //   1376: aload_0
    //   1377: aload 18
    //   1379: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1382: putfield 338	com/tencent/proxyinner/plugin/Downloader/PluginChecker:mLastHeadInfo	Ljava/lang/String;
    //   1385: goto -375 -> 1010
    //   1388: iconst_0
    //   1389: istore 4
    //   1391: goto -333 -> 1058
    //   1394: iconst_1
    //   1395: istore_3
    //   1396: goto -315 -> 1081
    //   1399: aload_0
    //   1400: getfield 239	com/tencent/proxyinner/plugin/Downloader/PluginChecker:mLastHttpResponseCode	I
    //   1403: istore 5
    //   1405: goto -311 -> 1094
    //   1408: astore_1
    //   1409: aload 21
    //   1411: astore 18
    //   1413: iload 5
    //   1415: istore_3
    //   1416: goto -559 -> 857
    //   1419: iconst_0
    //   1420: istore 6
    //   1422: goto -175 -> 1247
    //   1425: iconst_1
    //   1426: istore 5
    //   1428: goto -134 -> 1294
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1431	0	this	PluginChecker
    //   0	1431	1	paramString	String
    //   0	1431	2	paramBoolean	boolean
    //   37	1379	3	i	int
    //   42	1348	4	j	int
    //   39	1388	5	k	int
    //   1245	176	6	m	int
    //   1316	56	7	n	int
    //   85	246	8	bool1	boolean
    //   120	221	9	bool2	boolean
    //   124	1233	10	l1	long
    //   49	1310	12	l2	long
    //   45	1292	14	l3	long
    //   3	1336	16	l4	long
    //   53	886	18	localObject1	Object
    //   973	23	18	localException	Exception
    //   1144	268	18	localObject2	Object
    //   132	1229	19	localObject3	Object
    //   34	1143	20	localObject4	Object
    //   31	1379	21	str1	String
    //   63	1070	22	localURL	java.net.URL
    //   82	186	23	str2	String
    //   78	218	24	str3	String
    //   74	485	25	str4	String
    // Exception table:
    //   from	to	target	type
    //   55	65	856	java/lang/Exception
    //   431	436	856	java/lang/Exception
    //   447	455	856	java/lang/Exception
    //   466	472	856	java/lang/Exception
    //   483	491	856	java/lang/Exception
    //   502	508	856	java/lang/Exception
    //   524	533	856	java/lang/Exception
    //   544	570	856	java/lang/Exception
    //   581	590	856	java/lang/Exception
    //   601	609	856	java/lang/Exception
    //   620	626	856	java/lang/Exception
    //   641	649	856	java/lang/Exception
    //   660	700	856	java/lang/Exception
    //   711	717	856	java/lang/Exception
    //   728	741	856	java/lang/Exception
    //   752	772	856	java/lang/Exception
    //   783	792	856	java/lang/Exception
    //   803	812	856	java/lang/Exception
    //   823	829	856	java/lang/Exception
    //   845	853	856	java/lang/Exception
    //   1149	1162	856	java/lang/Exception
    //   1176	1182	856	java/lang/Exception
    //   1193	1198	856	java/lang/Exception
    //   1209	1239	856	java/lang/Exception
    //   1261	1268	856	java/lang/Exception
    //   1279	1291	856	java/lang/Exception
    //   1305	1315	856	java/lang/Exception
    //   1329	1354	856	java/lang/Exception
    //   1367	1373	856	java/lang/Exception
    //   867	892	973	java/lang/Exception
    //   897	911	973	java/lang/Exception
    //   911	933	973	java/lang/Exception
    //   938	970	973	java/lang/Exception
    //   1376	1385	973	java/lang/Exception
    //   69	76	1408	java/lang/Exception
    //   91	98	1408	java/lang/Exception
    //   102	113	1408	java/lang/Exception
    //   117	122	1408	java/lang/Exception
    //   188	195	1408	java/lang/Exception
    //   211	221	1408	java/lang/Exception
    //   225	230	1408	java/lang/Exception
    //   234	247	1408	java/lang/Exception
    //   251	259	1408	java/lang/Exception
    //   275	283	1408	java/lang/Exception
    //   287	295	1408	java/lang/Exception
    //   307	392	1408	java/lang/Exception
    //   396	404	1408	java/lang/Exception
    //   408	418	1408	java/lang/Exception
    //   1127	1132	1408	java/lang/Exception
  }
  
  private String getConfigUrl()
  {
    int j = this.pluginMgr.getMaxSdkVersion();
    Object localObject;
    if (this.mAppId.equals("Live"))
    {
      localObject = "http://now.qq.com/cgi-bin/now/web/version/now_ver?apptype=now&platform=2";
      if (!UtilMisc.isTestEnv(this.mAppId)) {
        break label276;
      }
    }
    label276:
    for (int i = 1;; i = 0)
    {
      String str = (String)localObject + "&mode=" + i + "&frameversion=" + 7 + "&cursdkversion=" + j + "&uin=" + this.mUin;
      localObject = str;
      if (UtilMisc.getTargetSdkVersion(this.mAppId) != 0) {
        localObject = str + "&targetSdkVersion=" + UtilMisc.getTargetSdkVersion(this.mAppId);
      }
      this.mReqUrl = ((String)localObject);
      Log.i("ODSDK | PluginChecker", "checkurl= " + (String)localObject);
      return localObject;
      if (this.mAppId.equals("Hy"))
      {
        localObject = "http://tiantian.qq.com/cgi-bin/hylove/version?apptype=hy&platform=2";
        break;
      }
      if (this.mAppId.equals("Od"))
      {
        localObject = "http://tiantian.qq.com/cgi-bin/hylove/version?apptype=od&platform=2";
        break;
      }
      if (this.mAppId.equals("qznow"))
      {
        localObject = "http://now.qq.com/cgi-bin/now/web/version/now_ver?apptype=qznow&platform=2";
        break;
      }
      if (this.mAppId.equals("acnow"))
      {
        localObject = "http://now.qq.com/cgi-bin/now/web/version/now_ver?apptype=acnow&platform=2";
        break;
      }
      localObject = "http://now.qq.com/cgi-bin/now/web/version/now_ver?platform=2&apptype=" + this.mAppId;
      break;
    }
  }
  
  private void postCallback(final boolean paramBoolean)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 1001;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localMessage.arg1 = i;
      this.mHandler.post(new Runnable()
      {
        public void run()
        {
          PluginChecker localPluginChecker;
          if (PluginChecker.this.mEvent != null)
          {
            localPluginChecker = PluginChecker.this;
            if (!paramBoolean) {
              break label53;
            }
          }
          label53:
          for (int i = 2;; i = 0)
          {
            localPluginChecker.mStatus = i;
            PluginChecker.this.mEvent.onCheckCompleted(paramBoolean, PluginChecker.this.mUpdateParam);
            return;
          }
        }
      });
      return;
    }
  }
  
  private void runImpl()
  {
    String str3 = getConfigUrl();
    XLog.e("ODSDK | PluginChecker", "runImpl, request first time, enable ip");
    String str2 = downloadBuffer(str3, true);
    String str1 = str2;
    if (this.mIsLastReqIpConn)
    {
      if (!TextUtils.isEmpty(str2)) {
        break label102;
      }
      XLog.e("ODSDK | PluginChecker", "runImpl, ret is empty, request again, disable ip");
      str1 = downloadBuffer(str3, false);
    }
    for (;;)
    {
      this.mJson = str1;
      if ((str1 != null) && (!TextUtils.isEmpty(str1))) {
        break;
      }
      this.mLastError += " mJson == null";
      postCallback(false);
      return;
      label102:
      String str4 = new UpdateParam().update(str2);
      str1 = str2;
      if (str4 != null)
      {
        XLog.e("ODSDK | PluginChecker", "runImpl, parse json failed, request again, disable ip:" + str4);
        str1 = downloadBuffer(str3, false);
      }
    }
    XLog.e("ODSDK | PluginChecker", "check 收到回包 ，json = " + str1);
    str1 = this.mUpdateParam.update(str1);
    if (str1 != null)
    {
      this.mLastError = (this.mLastError + "parse json fail,exception = " + str1);
      postCallback(false);
      return;
    }
    this.mLastUpdateTime = System.currentTimeMillis();
    postCallback(true);
  }
  
  public String getCheckUrl()
  {
    return this.mReqUrl;
  }
  
  public String getJsonString()
  {
    return this.mJson;
  }
  
  public String getLastError()
  {
    return this.mLastError + " json = " + this.mJson;
  }
  
  public String getLastHeadInfo()
  {
    return this.mLastHeadInfo;
  }
  
  public int getLastHttpResponseCode()
  {
    return this.mLastHttpResponseCode;
  }
  
  public int getMaxLoadRetryTimes()
  {
    if ((this.mUpdateParam != null) && (this.mUpdateParam.loadRetry >= 0) && (this.mUpdateParam.loadRetry <= 5)) {
      return this.mUpdateParam.loadRetry;
    }
    return 0;
  }
  
  public String getPackName()
  {
    UpdateParam.ApkParam localApkParam2 = this.mUpdateParam.getFirstTagParam();
    UpdateParam.ApkParam localApkParam1 = localApkParam2;
    if (localApkParam2 == null) {
      localApkParam1 = this.mUpdateParam.getFirstCurParam();
    }
    if (localApkParam1 == null) {
      return "";
    }
    return localApkParam1.name;
  }
  
  public int getStatus()
  {
    return this.mStatus;
  }
  
  String hardCodeName(String paramString)
  {
    String str;
    if (paramString.equals("Live")) {
      str = "com.tencent.now";
    }
    do
    {
      return str;
      if (paramString.equals("Hy")) {
        return "com.tencent.intervideo.xplatform";
      }
      str = paramString;
    } while (!paramString.equals("Od"));
    return "com.tencent.mobileqq";
  }
  
  public boolean isForceDownload()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.mUpdateParam != null)
    {
      bool1 = bool2;
      if (!this.mUpdateParam.curVersionExit)
      {
        bool1 = bool2;
        if (this.mUpdateParam.newVersionExit) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public boolean isVersionInfoExpired()
  {
    long l2 = System.currentTimeMillis();
    long l3 = this.mLastUpdateTime;
    long l1 = 86400000L;
    if (UtilMisc.isTestEnv(this.mAppId)) {
      l1 = 60000L;
    }
    return l2 - l3 > l1;
  }
  
  public void resetStatus()
  {
    this.mStatus = 0;
    this.mLastUpdateTime = 0L;
  }
  
  public void run(String paramString1, Context paramContext, String paramString2, Event paramEvent)
  {
    if (paramEvent != null) {
      this.mEvent = paramEvent;
    }
    for (;;)
    {
      try
      {
        if (!TextUtils.isEmpty(paramString1)) {
          continue;
        }
        l = DeviceUtil.getDeviceIdHash(paramContext);
        this.mUin = l;
      }
      catch (Exception paramString1)
      {
        long l;
        this.mUin = 0L;
        continue;
        if ((this.mStatus != 0) && (!isVersionInfoExpired())) {
          continue;
        }
        this.mStatus = 1;
        new Thread("nowlive_check_version")
        {
          public void run()
          {
            PluginChecker.this.runImpl();
          }
        }.start();
        return;
        postCallback(true);
      }
      this.mAppId = paramString2;
      if (this.mStatus != 1) {
        continue;
      }
      return;
      l = Long.parseLong(paramString1);
    }
  }
  
  public void setHostInterface(HostInterface paramHostInterface)
  {
    this.mHostInterface = paramHostInterface;
  }
  
  public static abstract interface Event
  {
    public abstract void onCheckCompleted(boolean paramBoolean, UpdateParam paramUpdateParam);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.proxyinner.plugin.Downloader.PluginChecker
 * JD-Core Version:    0.7.0.1
 */