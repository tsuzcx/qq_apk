package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.view.Window;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.utils.DiySecureFileHelper;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.emosm.OnRemoteRespObserver;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.theme.diy.ThemeDiyStyleLogic;
import com.tencent.mobileqq.vas.util.ChatBackgroundUtil;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class ChatBackgroundJsPlugin
  extends VasWebviewJsPlugin
{
  public static final String BUSINESS_NAME = "chatBg";
  public static final int COMPRESS_HD = 2;
  public static final int COMPRESS_NORMAL = 0;
  public static final int COMPRESS_RAW = 3;
  public static final String FROM_CHATBACKGROUNDJS = "fromChatBackgroundJsPlugin";
  public static final String ISFROMPHOTO = "isFromPhoto";
  private static final String TAG = "ChatBackgroundJsPlugin";
  private BrowserAppInterface browserApp;
  String mId;
  private Bundle mReqBundle;
  String mUrl;
  
  public ChatBackgroundJsPlugin()
  {
    this.mPluginNameSpace = "chatBg";
  }
  
  /* Error */
  public static boolean compressBitmapToFile(android.content.Context paramContext, int paramInt1, android.graphics.Bitmap paramBitmap, String paramString, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt2)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +5 -> 6
    //   4: iconst_0
    //   5: ireturn
    //   6: iload_1
    //   7: invokestatic 50	com/tencent/mobileqq/vaswebviewplugin/ChatBackgroundJsPlugin:getCompressType	(I)I
    //   10: istore_1
    //   11: fload 4
    //   13: fload 6
    //   15: fadd
    //   16: ldc 51
    //   18: fcmpl
    //   19: ifle +13 -> 32
    //   22: ldc 51
    //   24: fload 6
    //   26: fsub
    //   27: fstore 4
    //   29: goto +3 -> 32
    //   32: iload 7
    //   34: ifeq +72 -> 106
    //   37: new 53	android/graphics/Matrix
    //   40: dup
    //   41: invokespecial 54	android/graphics/Matrix:<init>	()V
    //   44: astore 14
    //   46: aload 14
    //   48: iload 7
    //   50: i2f
    //   51: aload_2
    //   52: invokevirtual 60	android/graphics/Bitmap:getWidth	()I
    //   55: i2f
    //   56: fconst_2
    //   57: fdiv
    //   58: aload_2
    //   59: invokevirtual 63	android/graphics/Bitmap:getHeight	()I
    //   62: i2f
    //   63: fconst_2
    //   64: fdiv
    //   65: invokevirtual 67	android/graphics/Matrix:postRotate	(FFF)Z
    //   68: pop
    //   69: aload_2
    //   70: iconst_0
    //   71: iconst_0
    //   72: aload_2
    //   73: invokevirtual 60	android/graphics/Bitmap:getWidth	()I
    //   76: aload_2
    //   77: invokevirtual 63	android/graphics/Bitmap:getHeight	()I
    //   80: aload 14
    //   82: iconst_0
    //   83: invokestatic 71	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   86: astore 14
    //   88: aload_2
    //   89: invokevirtual 74	android/graphics/Bitmap:recycle	()V
    //   92: aload 14
    //   94: astore_2
    //   95: goto +11 -> 106
    //   98: astore_0
    //   99: aload_0
    //   100: invokevirtual 78	java/lang/OutOfMemoryError:fillInStackTrace	()Ljava/lang/Throwable;
    //   103: pop
    //   104: iconst_0
    //   105: ireturn
    //   106: aload_2
    //   107: invokevirtual 60	android/graphics/Bitmap:getWidth	()I
    //   110: i2f
    //   111: fload 6
    //   113: ldc 51
    //   115: fdiv
    //   116: fmul
    //   117: fstore 12
    //   119: aload_0
    //   120: invokevirtual 84	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   123: invokevirtual 90	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   126: getfield 95	android/util/DisplayMetrics:heightPixels	I
    //   129: i2f
    //   130: fload 12
    //   132: fmul
    //   133: aload_0
    //   134: invokevirtual 84	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   137: invokevirtual 90	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   140: getfield 98	android/util/DisplayMetrics:widthPixels	I
    //   143: i2f
    //   144: fdiv
    //   145: fstore 6
    //   147: fload 5
    //   149: ldc 51
    //   151: fdiv
    //   152: aload_2
    //   153: invokevirtual 60	android/graphics/Bitmap:getWidth	()I
    //   156: i2f
    //   157: fmul
    //   158: fstore 13
    //   160: fload 6
    //   162: fstore 5
    //   164: fload 6
    //   166: fload 13
    //   168: fadd
    //   169: aload_2
    //   170: invokevirtual 63	android/graphics/Bitmap:getHeight	()I
    //   173: i2f
    //   174: fcmpl
    //   175: ifle +13 -> 188
    //   178: aload_2
    //   179: invokevirtual 63	android/graphics/Bitmap:getHeight	()I
    //   182: i2f
    //   183: fload 13
    //   185: fsub
    //   186: fstore 5
    //   188: fload 4
    //   190: ldc 51
    //   192: fdiv
    //   193: fstore 4
    //   195: aload_2
    //   196: fload 4
    //   198: aload_2
    //   199: invokevirtual 60	android/graphics/Bitmap:getWidth	()I
    //   202: i2f
    //   203: fmul
    //   204: f2i
    //   205: fload 13
    //   207: f2i
    //   208: fload 12
    //   210: f2i
    //   211: fload 5
    //   213: f2i
    //   214: invokestatic 101	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIII)Landroid/graphics/Bitmap;
    //   217: astore 17
    //   219: aload 17
    //   221: ifnonnull +15 -> 236
    //   224: aload 17
    //   226: aload_2
    //   227: if_acmpeq +7 -> 234
    //   230: aload_2
    //   231: invokevirtual 74	android/graphics/Bitmap:recycle	()V
    //   234: iconst_0
    //   235: ireturn
    //   236: aload 17
    //   238: aload_2
    //   239: if_acmpeq +7 -> 246
    //   242: aload_2
    //   243: invokevirtual 74	android/graphics/Bitmap:recycle	()V
    //   246: new 103	java/io/File
    //   249: dup
    //   250: aload_3
    //   251: invokespecial 106	java/io/File:<init>	(Ljava/lang/String;)V
    //   254: astore_2
    //   255: aload_2
    //   256: invokevirtual 110	java/io/File:getParentFile	()Ljava/io/File;
    //   259: invokevirtual 114	java/io/File:exists	()Z
    //   262: ifne +11 -> 273
    //   265: aload_2
    //   266: invokevirtual 110	java/io/File:getParentFile	()Ljava/io/File;
    //   269: invokevirtual 117	java/io/File:mkdirs	()Z
    //   272: pop
    //   273: aconst_null
    //   274: astore 15
    //   276: aconst_null
    //   277: astore 16
    //   279: aconst_null
    //   280: astore_2
    //   281: new 119	java/io/FileOutputStream
    //   284: dup
    //   285: aload_3
    //   286: invokespecial 120	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   289: astore 14
    //   291: aload 17
    //   293: getstatic 126	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   296: bipush 100
    //   298: aload 14
    //   300: invokevirtual 130	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   303: pop
    //   304: aload 14
    //   306: invokevirtual 133	java/io/FileOutputStream:close	()V
    //   309: aload 17
    //   311: invokevirtual 74	android/graphics/Bitmap:recycle	()V
    //   314: aload 14
    //   316: invokevirtual 133	java/io/FileOutputStream:close	()V
    //   319: goto +45 -> 364
    //   322: astore_2
    //   323: invokestatic 138	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   326: ifeq +38 -> 364
    //   329: new 140	java/lang/StringBuilder
    //   332: dup
    //   333: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   336: astore 15
    //   338: aload 15
    //   340: ldc 143
    //   342: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: pop
    //   346: aload 15
    //   348: aload_2
    //   349: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   352: pop
    //   353: ldc 24
    //   355: iconst_1
    //   356: aload 15
    //   358: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   361: invokestatic 158	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   364: aload 14
    //   366: astore_2
    //   367: goto +181 -> 548
    //   370: astore_0
    //   371: aload 14
    //   373: astore_2
    //   374: goto +541 -> 915
    //   377: astore 15
    //   379: goto +20 -> 399
    //   382: astore 15
    //   384: goto +106 -> 490
    //   387: astore_0
    //   388: goto +527 -> 915
    //   391: astore_2
    //   392: aload 15
    //   394: astore 14
    //   396: aload_2
    //   397: astore 15
    //   399: aload 14
    //   401: astore_2
    //   402: aload 15
    //   404: invokevirtual 161	java/io/IOException:printStackTrace	()V
    //   407: aload 17
    //   409: invokevirtual 74	android/graphics/Bitmap:recycle	()V
    //   412: aload 14
    //   414: astore_2
    //   415: aload 14
    //   417: ifnull +131 -> 548
    //   420: aload 14
    //   422: invokevirtual 133	java/io/FileOutputStream:close	()V
    //   425: aload 14
    //   427: astore_2
    //   428: goto +120 -> 548
    //   431: astore 15
    //   433: aload 14
    //   435: astore_2
    //   436: invokestatic 138	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   439: ifeq +109 -> 548
    //   442: new 140	java/lang/StringBuilder
    //   445: dup
    //   446: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   449: astore 16
    //   451: aload 14
    //   453: astore_2
    //   454: aload 16
    //   456: ldc 143
    //   458: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   461: pop
    //   462: aload 16
    //   464: aload 15
    //   466: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   469: pop
    //   470: ldc 24
    //   472: iconst_1
    //   473: aload 16
    //   475: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   478: invokestatic 158	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   481: goto +67 -> 548
    //   484: astore 15
    //   486: aload 16
    //   488: astore 14
    //   490: aload 14
    //   492: astore_2
    //   493: aload 15
    //   495: invokevirtual 162	java/io/FileNotFoundException:printStackTrace	()V
    //   498: aload 17
    //   500: invokevirtual 74	android/graphics/Bitmap:recycle	()V
    //   503: aload 14
    //   505: astore_2
    //   506: aload 14
    //   508: ifnull +40 -> 548
    //   511: aload 14
    //   513: invokevirtual 133	java/io/FileOutputStream:close	()V
    //   516: aload 14
    //   518: astore_2
    //   519: goto +29 -> 548
    //   522: astore 15
    //   524: aload 14
    //   526: astore_2
    //   527: invokestatic 138	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   530: ifeq +18 -> 548
    //   533: new 140	java/lang/StringBuilder
    //   536: dup
    //   537: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   540: astore 16
    //   542: aload 14
    //   544: astore_2
    //   545: goto -91 -> 454
    //   548: ldc 164
    //   550: invokestatic 170	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   553: checkcast 164	com/tencent/qzonehub/api/webview/IQzoneWebViewPluginHelper
    //   556: aload_3
    //   557: invokeinterface 174 2 0
    //   562: astore 14
    //   564: aload 14
    //   566: ifnonnull +5 -> 571
    //   569: iconst_0
    //   570: ireturn
    //   571: ldc 164
    //   573: invokestatic 170	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   576: checkcast 164	com/tencent/qzonehub/api/webview/IQzoneWebViewPluginHelper
    //   579: aload_0
    //   580: iload_1
    //   581: aload 14
    //   583: invokeinterface 178 4 0
    //   588: dstore 8
    //   590: dload 8
    //   592: dconst_0
    //   593: dcmpl
    //   594: ifle +53 -> 647
    //   597: aload 14
    //   599: getfield 183	cooperation/qzone/model/Size:width	I
    //   602: i2d
    //   603: dstore 10
    //   605: dload 10
    //   607: invokestatic 189	java/lang/Double:isNaN	(D)Z
    //   610: pop
    //   611: aload 14
    //   613: dload 10
    //   615: dload 8
    //   617: ddiv
    //   618: d2i
    //   619: putfield 183	cooperation/qzone/model/Size:width	I
    //   622: aload 14
    //   624: getfield 192	cooperation/qzone/model/Size:height	I
    //   627: i2d
    //   628: dstore 10
    //   630: dload 10
    //   632: invokestatic 189	java/lang/Double:isNaN	(D)Z
    //   635: pop
    //   636: aload 14
    //   638: dload 10
    //   640: dload 8
    //   642: ddiv
    //   643: d2i
    //   644: putfield 192	cooperation/qzone/model/Size:height	I
    //   647: ldc 164
    //   649: invokestatic 170	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   652: checkcast 164	com/tencent/qzonehub/api/webview/IQzoneWebViewPluginHelper
    //   655: aload_3
    //   656: aload 14
    //   658: getfield 183	cooperation/qzone/model/Size:width	I
    //   661: aload 14
    //   663: getfield 192	cooperation/qzone/model/Size:height	I
    //   666: invokeinterface 196 4 0
    //   671: iconst_2
    //   672: invokestatic 202	android/util/Base64:decode	(Ljava/lang/String;I)[B
    //   675: astore 14
    //   677: aload_2
    //   678: astore_0
    //   679: new 119	java/io/FileOutputStream
    //   682: dup
    //   683: aload_3
    //   684: invokespecial 120	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   687: astore_3
    //   688: aload_3
    //   689: aload 14
    //   691: invokevirtual 206	java/io/FileOutputStream:write	([B)V
    //   694: aload_3
    //   695: invokevirtual 133	java/io/FileOutputStream:close	()V
    //   698: aload_3
    //   699: invokevirtual 133	java/io/FileOutputStream:close	()V
    //   702: iconst_1
    //   703: ireturn
    //   704: astore_0
    //   705: invokestatic 138	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   708: ifeq +34 -> 742
    //   711: new 140	java/lang/StringBuilder
    //   714: dup
    //   715: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   718: astore_2
    //   719: aload_2
    //   720: ldc 208
    //   722: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   725: pop
    //   726: aload_2
    //   727: aload_0
    //   728: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   731: pop
    //   732: ldc 24
    //   734: iconst_1
    //   735: aload_2
    //   736: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   739: invokestatic 158	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   742: iconst_1
    //   743: ireturn
    //   744: astore_2
    //   745: aload_3
    //   746: astore_0
    //   747: goto +117 -> 864
    //   750: astore_0
    //   751: aload_3
    //   752: astore_2
    //   753: aload_0
    //   754: astore_3
    //   755: goto +16 -> 771
    //   758: astore_0
    //   759: aload_3
    //   760: astore_2
    //   761: aload_0
    //   762: astore_3
    //   763: goto +65 -> 828
    //   766: astore_2
    //   767: goto +97 -> 864
    //   770: astore_3
    //   771: aload_2
    //   772: astore_0
    //   773: aload_3
    //   774: invokevirtual 161	java/io/IOException:printStackTrace	()V
    //   777: aload_2
    //   778: ifnull +84 -> 862
    //   781: aload_2
    //   782: invokevirtual 133	java/io/FileOutputStream:close	()V
    //   785: iconst_0
    //   786: ireturn
    //   787: astore_2
    //   788: invokestatic 138	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   791: ifeq +71 -> 862
    //   794: new 140	java/lang/StringBuilder
    //   797: dup
    //   798: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   801: astore_0
    //   802: aload_0
    //   803: ldc 208
    //   805: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   808: pop
    //   809: aload_0
    //   810: aload_2
    //   811: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   814: pop
    //   815: ldc 24
    //   817: iconst_1
    //   818: aload_0
    //   819: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   822: invokestatic 158	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   825: iconst_0
    //   826: ireturn
    //   827: astore_3
    //   828: aload_2
    //   829: astore_0
    //   830: aload_3
    //   831: invokevirtual 162	java/io/FileNotFoundException:printStackTrace	()V
    //   834: aload_2
    //   835: ifnull +27 -> 862
    //   838: aload_2
    //   839: invokevirtual 133	java/io/FileOutputStream:close	()V
    //   842: iconst_0
    //   843: ireturn
    //   844: astore_2
    //   845: invokestatic 138	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   848: ifeq +14 -> 862
    //   851: new 140	java/lang/StringBuilder
    //   854: dup
    //   855: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   858: astore_0
    //   859: goto -57 -> 802
    //   862: iconst_0
    //   863: ireturn
    //   864: aload_0
    //   865: ifnull +48 -> 913
    //   868: aload_0
    //   869: invokevirtual 133	java/io/FileOutputStream:close	()V
    //   872: goto +41 -> 913
    //   875: astore_0
    //   876: invokestatic 138	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   879: ifeq +34 -> 913
    //   882: new 140	java/lang/StringBuilder
    //   885: dup
    //   886: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   889: astore_3
    //   890: aload_3
    //   891: ldc 208
    //   893: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   896: pop
    //   897: aload_3
    //   898: aload_0
    //   899: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   902: pop
    //   903: ldc 24
    //   905: iconst_1
    //   906: aload_3
    //   907: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   910: invokestatic 158	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   913: aload_2
    //   914: athrow
    //   915: aload 17
    //   917: invokevirtual 74	android/graphics/Bitmap:recycle	()V
    //   920: aload_2
    //   921: ifnull +48 -> 969
    //   924: aload_2
    //   925: invokevirtual 133	java/io/FileOutputStream:close	()V
    //   928: goto +41 -> 969
    //   931: astore_2
    //   932: invokestatic 138	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   935: ifeq +34 -> 969
    //   938: new 140	java/lang/StringBuilder
    //   941: dup
    //   942: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   945: astore_3
    //   946: aload_3
    //   947: ldc 143
    //   949: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   952: pop
    //   953: aload_3
    //   954: aload_2
    //   955: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   958: pop
    //   959: ldc 24
    //   961: iconst_1
    //   962: aload_3
    //   963: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   966: invokestatic 158	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   969: aload_0
    //   970: athrow
    //   971: astore_0
    //   972: goto +19 -> 991
    //   975: astore_0
    //   976: aload_0
    //   977: invokevirtual 78	java/lang/OutOfMemoryError:fillInStackTrace	()Ljava/lang/Throwable;
    //   980: pop
    //   981: aload_2
    //   982: ifnull +7 -> 989
    //   985: aload_2
    //   986: invokevirtual 74	android/graphics/Bitmap:recycle	()V
    //   989: iconst_0
    //   990: ireturn
    //   991: aload_2
    //   992: ifnull +7 -> 999
    //   995: aload_2
    //   996: invokevirtual 74	android/graphics/Bitmap:recycle	()V
    //   999: goto +5 -> 1004
    //   1002: aload_0
    //   1003: athrow
    //   1004: goto -2 -> 1002
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1007	0	paramContext	android.content.Context
    //   0	1007	1	paramInt1	int
    //   0	1007	2	paramBitmap	android.graphics.Bitmap
    //   0	1007	3	paramString	String
    //   0	1007	4	paramFloat1	float
    //   0	1007	5	paramFloat2	float
    //   0	1007	6	paramFloat3	float
    //   0	1007	7	paramInt2	int
    //   588	53	8	d1	double
    //   603	36	10	d2	double
    //   117	92	12	f1	float
    //   158	48	13	f2	float
    //   44	646	14	localObject	Object
    //   274	83	15	localStringBuilder1	StringBuilder
    //   377	1	15	localIOException1	java.io.IOException
    //   382	11	15	localFileNotFoundException1	java.io.FileNotFoundException
    //   397	6	15	localBitmap1	android.graphics.Bitmap
    //   431	34	15	localIOException2	java.io.IOException
    //   484	10	15	localFileNotFoundException2	java.io.FileNotFoundException
    //   522	1	15	localIOException3	java.io.IOException
    //   277	264	16	localStringBuilder2	StringBuilder
    //   217	699	17	localBitmap2	android.graphics.Bitmap
    // Exception table:
    //   from	to	target	type
    //   69	92	98	java/lang/OutOfMemoryError
    //   314	319	322	java/io/IOException
    //   291	309	370	finally
    //   291	309	377	java/io/IOException
    //   291	309	382	java/io/FileNotFoundException
    //   281	291	387	finally
    //   402	407	387	finally
    //   493	498	387	finally
    //   281	291	391	java/io/IOException
    //   420	425	431	java/io/IOException
    //   281	291	484	java/io/FileNotFoundException
    //   511	516	522	java/io/IOException
    //   698	702	704	java/io/IOException
    //   688	698	744	finally
    //   688	698	750	java/io/IOException
    //   688	698	758	java/io/FileNotFoundException
    //   679	688	766	finally
    //   773	777	766	finally
    //   830	834	766	finally
    //   679	688	770	java/io/IOException
    //   781	785	787	java/io/IOException
    //   679	688	827	java/io/FileNotFoundException
    //   838	842	844	java/io/IOException
    //   868	872	875	java/io/IOException
    //   924	928	931	java/io/IOException
    //   195	219	971	finally
    //   976	981	971	finally
    //   195	219	975	java/lang/OutOfMemoryError
  }
  
  private void custom(String paramString)
  {
    Object localObject = this.mRuntime.d().getIntent();
    String str = getCustomImageFilePath();
    Rect localRect = new Rect();
    this.mRuntime.d().getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
    ((Intent)localObject).putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
    ((Intent)localObject).putExtra("isFromPhoto", true);
    ((Intent)localObject).putExtra("fromChatBackgroundJsPlugin", true);
    ((Intent)localObject).putExtra("onNewIntentReDoStateMachine", false);
    PhotoUtils.startPhotoListEdit((Intent)localObject, this.mRuntime.d(), QQBrowserActivity.class.getName(), localRect.width() / 5 * 4, localRect.height() / 5 * 4, localRect.width(), localRect.height(), str);
    localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("result", 0);
      super.callJs(paramString, new String[] { ((JSONObject)localObject).toString() });
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      callJsOnError(paramString, localJSONException.getMessage());
    }
  }
  
  private static int getCompressType(int paramInt)
  {
    int i = 2;
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return 0;
      }
      i = 3;
    }
    return i;
  }
  
  private String getCustomImageFilePath()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(ThemeDiyStyleLogic.b());
    localStringBuilder.append(DiySecureFileHelper.a(this.browserApp.getAccount()));
    localStringBuilder.append("/");
    localStringBuilder.append(System.currentTimeMillis());
    localStringBuilder.append(".jpg");
    return localStringBuilder.toString();
  }
  
  private void handleCustomPic(Intent paramIntent)
  {
    if (paramIntent == null)
    {
      QLog.d("ChatBackgroundJsPlugin", 2, "handleCustomPic intent = null");
      return;
    }
    boolean bool = paramIntent.getBooleanExtra("isFromPhoto", false);
    String str = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
    handleCustomPic(paramIntent.getStringExtra("chatbg_intent_frinedUin"), 0, str, 0, bool);
  }
  
  private void handleCustomPic(String paramString1, int paramInt1, String paramString2, int paramInt2, boolean paramBoolean)
  {
    if ((paramBoolean) && (paramString2 != null) && (this.browserApp != null))
    {
      Intent localIntent = new Intent();
      localIntent.setAction("chatbgBroadcast");
      localIntent.setPackage(this.browserApp.getApp().getPackageName());
      localIntent.putExtra("friendUin", paramString1);
      localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", paramString2);
      localIntent.putExtra("effectId", paramInt2);
      localIntent.putExtra("uinType", paramInt1);
      this.browserApp.getApp().sendBroadcast(localIntent);
      QQToast.makeText(this.mRuntime.d(), 2131892731, 0).show();
      ReportController.b(null, "CliOper", "", "", "chatbackground", "BjIDShezhi", 0, 0, "1", "", "", "");
    }
  }
  
  protected long getPluginBusiness()
  {
    return 2181038080L;
  }
  
  public long getWebViewEventByNameSpace(String paramString)
  {
    return 131L;
  }
  
  protected boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if (paramLong == 128L)
    {
      Object localObject = paramMap.get("intent");
      if ((localObject != null) && ((localObject instanceof Intent)))
      {
        localObject = (Intent)localObject;
        if (((Intent)localObject).getBooleanExtra("fromChatBackgroundJsPlugin", false))
        {
          handleCustomPic((Intent)localObject);
          return true;
        }
      }
    }
    return super.handleEvent(paramString, paramLong, paramMap);
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel())
    {
      paramJsBridgeListener = new StringBuilder();
      paramJsBridgeListener.append("handleJsRequest, url=");
      paramJsBridgeListener.append(paramString1);
      paramJsBridgeListener.append(", pkgName=");
      paramJsBridgeListener.append(paramString2);
      paramJsBridgeListener.append(", methodName=");
      paramJsBridgeListener.append(paramString3);
      QLog.d("ChatBackgroundJsPlugin", 2, paramJsBridgeListener.toString());
    }
    String str1;
    boolean bool;
    if ((paramString1 != null) && ("chatBg".equals(paramString2)) && (paramString3 != null))
    {
      Object localObject1 = WebViewPlugin.getJsonFromJSBridge(paramString1);
      if (localObject1 == null) {
        return true;
      }
      if (QLog.isColorLevel())
      {
        paramJsBridgeListener = new StringBuilder();
        paramJsBridgeListener.append("handleJsRequest JSON = ");
        paramJsBridgeListener.append(((JSONObject)localObject1).toString());
        QLog.d("ChatBackgroundJsPlugin", 2, paramJsBridgeListener.toString());
      }
      str1 = ((JSONObject)localObject1).optString("callback");
      if (TextUtils.isEmpty(str1))
      {
        QLog.e("ChatBackgroundJsPlugin", 1, "callback id is null, so return");
        return true;
      }
      bool = "getCurrentChatBgId".equals(paramString3);
      paramVarArgs = "";
      int j;
      int i;
      if (bool)
      {
        paramString1 = this.mRuntime.d().getIntent().getStringExtra("chatbg_intent_frinedUin");
        paramJsBridgeListener = paramString1;
        if (paramString1 == null) {
          paramJsBridgeListener = "none";
        }
        j = this.mRuntime.d().getIntent().getIntExtra("uintype", -1);
        i = j;
        if (j == 3000) {
          i = 1;
        }
        this.mReqBundle.clear();
        this.mReqBundle.putString("friendUin", paramJsBridgeListener);
        this.mReqBundle.putInt("uinType", i);
        paramJsBridgeListener = "chatbackground_getCurrentId";
      }
      for (;;)
      {
        break label1726;
        Object localObject2;
        if ("startDownload".equals(paramString3))
        {
          paramJsBridgeListener = paramVarArgs;
          try
          {
            paramString2 = ((JSONObject)localObject1).getString("id");
            paramJsBridgeListener = paramVarArgs;
            paramString3 = ((JSONObject)localObject1).getString("url");
            paramJsBridgeListener = paramVarArgs;
            this.mId = paramString2;
            paramJsBridgeListener = paramVarArgs;
            this.mUrl = paramString3;
            paramJsBridgeListener = paramVarArgs;
            localObject2 = ((JSONObject)localObject1).getString("name");
            paramJsBridgeListener = paramVarArgs;
            paramVarArgs = ((JSONObject)localObject1).getString("thumbUrl");
            paramString1 = "chatbackground_startDownload";
            paramJsBridgeListener = paramString1;
            this.mReqBundle.clear();
            paramJsBridgeListener = paramString1;
            this.mReqBundle.putString("id", paramString2);
            paramJsBridgeListener = paramString1;
            this.mReqBundle.putString("url", paramString3);
            paramJsBridgeListener = paramString1;
            this.mReqBundle.putString("name", (String)localObject2);
            paramJsBridgeListener = paramString1;
            this.mReqBundle.putString("thumbUrl", paramVarArgs);
            paramJsBridgeListener = paramString1;
          }
          catch (JSONException paramString1)
          {
            paramString1.printStackTrace();
          }
        }
        else if ("stopDownload".equals(paramString3))
        {
          paramJsBridgeListener = paramVarArgs;
          try
          {
            paramString2 = ((JSONObject)localObject1).getString("id");
            paramJsBridgeListener = paramVarArgs;
            paramString3 = ((JSONObject)localObject1).getString("url");
            paramString1 = "chatbackground_stopdownload";
            paramJsBridgeListener = paramString1;
            this.mReqBundle.clear();
            paramJsBridgeListener = paramString1;
            this.mReqBundle.putString("id", paramString2);
            paramJsBridgeListener = paramString1;
            this.mReqBundle.putString("url", paramString3);
            paramJsBridgeListener = paramString1;
          }
          catch (JSONException paramString1)
          {
            paramString1.printStackTrace();
          }
        }
        else if ("queryInfo".equals(paramString3))
        {
          paramJsBridgeListener = paramVarArgs;
          try
          {
            paramString2 = ((JSONObject)localObject1).getString("id");
            paramJsBridgeListener = paramVarArgs;
            paramString3 = ((JSONObject)localObject1).getString("url");
            paramString1 = "chatbackground_querinfo";
            paramJsBridgeListener = paramString1;
            this.mReqBundle.clear();
            paramJsBridgeListener = paramString1;
            this.mReqBundle.putString("id", paramString2);
            paramJsBridgeListener = paramString1;
            this.mReqBundle.putString("url", paramString3);
            paramJsBridgeListener = paramString1;
          }
          catch (JSONException paramString1)
          {
            paramString1.printStackTrace();
          }
        }
        else if ("setChatBg".equals(paramString3))
        {
          paramString3 = "chatbackground_setbg";
          try
          {
            paramVarArgs = ((JSONObject)localObject1).getString("id");
            if (paramVarArgs.startsWith("theme")) {
              paramString1 = "null";
            } else {
              paramString1 = ChatBackgroundUtil.a(true, paramVarArgs);
            }
            localObject2 = this.mRuntime.d().getIntent();
            if (!((JSONObject)localObject1).has("friendUin")) {
              break label1753;
            }
            paramJsBridgeListener = ((JSONObject)localObject1).getString("friendUin");
            paramString2 = paramJsBridgeListener;
            if ("none".equals(paramJsBridgeListener)) {
              paramString2 = null;
            }
            paramJsBridgeListener = ((JSONObject)localObject1).optString("name");
            localObject1 = ((JSONObject)localObject1).optString("feeType");
            this.mReqBundle.clear();
            this.mReqBundle.putString("path", paramString1);
            this.mReqBundle.putString("friendUin", paramString2);
            this.mReqBundle.putString("from", "chatbgJs");
            this.mReqBundle.putString("name", paramJsBridgeListener);
            this.mReqBundle.putString("feeType", (String)localObject1);
            this.mReqBundle.putString("id", paramVarArgs);
            if ((!TextUtils.isEmpty(this.mId)) && (this.mId.equals(paramVarArgs))) {
              this.mReqBundle.putString("url", this.mUrl);
            }
            this.mReqBundle.putParcelable("intent", (Parcelable)localObject2);
            paramJsBridgeListener = paramString3;
          }
          catch (JSONException paramJsBridgeListener)
          {
            paramJsBridgeListener.printStackTrace();
            paramJsBridgeListener = paramString3;
          }
        }
        else
        {
          if ("custom".equals(paramString3))
          {
            custom(str1);
            return true;
          }
          if ("openPage".equals(paramString3)) {
            try
            {
              paramJsBridgeListener = new Intent();
              paramJsBridgeListener.putExtra("bg_replace_entrance", 8);
              paramJsBridgeListener.putExtra("selfSet_leftViewText", this.mRuntime.d().getString(2131887625));
              paramJsBridgeListener.putExtra("hide_left_button", false);
              paramJsBridgeListener.putExtra("show_right_close_button", false);
              paramJsBridgeListener.putExtra("startOpenPageTime", System.currentTimeMillis());
              VasWebviewUtil.b(this.mRuntime.d(), IndividuationUrlHelper.a(this.mRuntime.d(), "background", ""), 33554432L, paramJsBridgeListener, false, -1);
              paramJsBridgeListener = new JSONObject();
              paramJsBridgeListener.put("result", 0);
              super.callJs(str1, new String[] { paramJsBridgeListener.toString() });
              return true;
            }
            catch (Exception paramJsBridgeListener)
            {
              paramJsBridgeListener.printStackTrace();
              super.callJs(str1, new String[] { paramJsBridgeListener.getMessage() });
              return true;
            }
          }
          if ("isSupportDynamic".equals(paramString3))
          {
            j = ChatBackgroundManager.a();
            if ((j & 0x1) != 0) {
              i = 1;
            } else {
              i = 0;
            }
            if ((j & 0x2) != 0) {
              j = 1;
            } else {
              j = 0;
            }
            try
            {
              paramJsBridgeListener = new JSONObject();
              paramJsBridgeListener.put("result", 0);
              paramJsBridgeListener.put("isDeviceEnable", i);
              paramJsBridgeListener.put("isWebviewEnable", j);
              if (QLog.isColorLevel())
              {
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append("isSupportDynamic deviceEnable:");
                ((StringBuilder)localObject1).append(i);
                ((StringBuilder)localObject1).append(", webViewEnable:");
                ((StringBuilder)localObject1).append(j);
                QLog.i("ChatBackgroundJsPlugin", 2, ((StringBuilder)localObject1).toString());
              }
              localObject1 = new JSONObject();
              ((JSONObject)localObject1).put("result", 0);
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("isSupportDynamic return deviceEnable:");
              ((StringBuilder)localObject2).append(i);
              ((StringBuilder)localObject2).append(", webViewEnable:");
              ((StringBuilder)localObject2).append(j);
              ((JSONObject)localObject1).put("message", ((StringBuilder)localObject2).toString());
              ((JSONObject)localObject1).put("data", paramJsBridgeListener);
              super.callJs(str1, new String[] { ((JSONObject)localObject1).toString() });
              paramJsBridgeListener = paramVarArgs;
            }
            catch (JSONException paramJsBridgeListener)
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("handleJsRequest exception url=");
              ((StringBuilder)localObject1).append(paramString1);
              ((StringBuilder)localObject1).append(", pkgName=");
              ((StringBuilder)localObject1).append(paramString2);
              ((StringBuilder)localObject1).append(", methodName=");
              ((StringBuilder)localObject1).append(paramString3);
              QLog.e("ChatBackgroundJsPlugin", 1, ((StringBuilder)localObject1).toString(), paramJsBridgeListener);
              paramJsBridgeListener = paramVarArgs;
            }
          }
          else
          {
            paramJsBridgeListener = paramVarArgs;
            if ("setDIYConfig".equals(paramString3))
            {
              String str4 = ((JSONObject)localObject1).optString("identifier");
              paramString2 = ((JSONObject)localObject1).optString("compressType");
              paramString3 = ((JSONObject)localObject1).optString("effectId");
              paramString1 = ((JSONObject)localObject1).optString("callback");
              localObject2 = ((JSONObject)localObject1).optString("originX");
              String str2 = ((JSONObject)localObject1).optString("originY");
              String str3 = ((JSONObject)localObject1).optString("uinType");
              if (((JSONObject)localObject1).has("friendUin")) {
                paramJsBridgeListener = ((JSONObject)localObject1).optString("friendUin");
              } else {
                paramJsBridgeListener = null;
              }
              localObject1 = ((JSONObject)localObject1).optString("imageWidth");
              if (TextUtils.isEmpty(str4))
              {
                QLog.w("ChatBackgroundJsPlugin", 2, "@coverOptimize  identifier is null or size is 0 ");
                return false;
              }
              str4 = new String(Base64.decode(str4, 2));
              String str5 = getCustomImageFilePath();
              i = ImageUtil.h(str4);
              bool = compressBitmapToFile(this.mRuntime.d(), Integer.parseInt(paramString2), BitmapFactory.decodeFile(str4), str5, Float.parseFloat((String)localObject2), Float.parseFloat(str2), Float.parseFloat((String)localObject1), i);
              if (bool) {
                handleCustomPic(paramJsBridgeListener, Integer.parseInt(str3), str5, Integer.parseInt(paramString3), true);
              }
              paramString2 = new JSONObject();
              if (!bool) {
                break label1760;
              }
              paramJsBridgeListener = "0";
            }
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        paramString2.put("code", paramJsBridgeListener);
        if (!bool) {
          paramString2.put("msg", HardCodeUtil.a(2131899815));
        }
      }
      catch (JSONException paramJsBridgeListener)
      {
        paramJsBridgeListener.printStackTrace();
      }
      if (bool) {
        paramJsBridgeListener = "0";
      } else {
        paramJsBridgeListener = "1";
      }
      super.callJs(paramString1, new String[] { paramJsBridgeListener });
      paramJsBridgeListener = paramVarArgs;
      label1726:
      super.sendRemoteReq(DataFactory.a(paramJsBridgeListener, str1, this.mOnRemoteResp.key, this.mReqBundle), false, true);
      return true;
      return false;
      label1753:
      paramJsBridgeListener = "none";
      break;
      label1760:
      paramJsBridgeListener = "1";
    }
  }
  
  protected void onCreate()
  {
    super.onCreate();
    this.mReqBundle = new Bundle();
    AppInterface localAppInterface = this.mRuntime.b();
    if ((localAppInterface instanceof BrowserAppInterface))
    {
      this.browserApp = ((BrowserAppInterface)localAppInterface);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("ChatBackgroundJsPlugin", 2, "ERROR!!! chatbg market is not running in web process!");
    }
  }
  
  void onPushMsg(Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onPushMsg=");
      ((StringBuilder)localObject).append(paramBundle);
      QLog.i("ChatBackgroundJsPlugin", 2, ((StringBuilder)localObject).toString());
    }
    int i = paramBundle.getInt("id");
    int j = paramBundle.getInt("result");
    paramBundle = paramBundle.getString("callbackId");
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("id", i);
      ((JSONObject)localObject).put("result", j);
      label95:
      super.callJs(paramBundle, new String[] { ((JSONObject)localObject).toString() });
      return;
    }
    catch (JSONException localJSONException)
    {
      break label95;
    }
  }
  
  protected void onResponse(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    if (paramBundle.getInt("respkey", 0) == this.mOnRemoteResp.key)
    {
      String str = paramBundle.getString("cmd");
      try
      {
        localObject = paramBundle.getString("callbackid");
        paramBundle = paramBundle.getBundle("response");
        JSONObject localJSONObject = new JSONObject();
        boolean bool = "chatbackground_getCurrentId".equals(str);
        if (bool)
        {
          localJSONObject.put("id", paramBundle.getString("id"));
          localJSONObject.put("result", paramBundle.getInt("result"));
          localJSONObject.put("uinType", paramBundle.getInt("uinType"));
          localJSONObject.put("friendUin", paramBundle.getString("friendUin"));
          localJSONObject.put("themeId", paramBundle.getString("themeId"));
          localJSONObject.put("url", paramBundle.getString("url"));
          localJSONObject.put("isDIYTheme", paramBundle.getString("isDIYTheme"));
          super.callJs((String)localObject, new String[] { localJSONObject.toString() });
          return;
        }
        if ("chatbackground_setbg".equals(str))
        {
          localJSONObject.put("result", paramBundle.getInt("result"));
          super.callJs((String)localObject, new String[] { localJSONObject.toString() });
          return;
        }
        if ("chatbackground_querinfo".equals(str))
        {
          localJSONObject.put("status", paramBundle.getInt("status"));
          localJSONObject.put("id", paramBundle.getString("id"));
          localJSONObject.put("message", paramBundle.getString("message"));
          localJSONObject.put("result", paramBundle.getInt("result"));
          localJSONObject.put("progress", paramBundle.getInt("progress"));
          super.callJs((String)localObject, new String[] { localJSONObject.toString() });
          return;
        }
        if ("chatbackground_stopdownload".equals(str))
        {
          localJSONObject.put("id", paramBundle.getString("id"));
          localJSONObject.put("result", 0);
          super.callJs((String)localObject, new String[] { localJSONObject.toString() });
          return;
        }
      }
      catch (Exception paramBundle)
      {
        Object localObject;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Failed to handle cmd ");
          ((StringBuilder)localObject).append(str);
          ((StringBuilder)localObject).append(", exception: ");
          ((StringBuilder)localObject).append(paramBundle.getMessage());
          QLog.e("ChatBackgroundJsPlugin", 2, ((StringBuilder)localObject).toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ChatBackgroundJsPlugin
 * JD-Core Version:    0.7.0.1
 */