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
    //   221: ifnonnull +9 -> 230
    //   224: aload_2
    //   225: invokevirtual 74	android/graphics/Bitmap:recycle	()V
    //   228: iconst_0
    //   229: ireturn
    //   230: aload_2
    //   231: invokevirtual 74	android/graphics/Bitmap:recycle	()V
    //   234: new 103	java/io/File
    //   237: dup
    //   238: aload_3
    //   239: invokespecial 106	java/io/File:<init>	(Ljava/lang/String;)V
    //   242: astore_2
    //   243: aload_2
    //   244: invokevirtual 110	java/io/File:getParentFile	()Ljava/io/File;
    //   247: invokevirtual 114	java/io/File:exists	()Z
    //   250: ifne +11 -> 261
    //   253: aload_2
    //   254: invokevirtual 110	java/io/File:getParentFile	()Ljava/io/File;
    //   257: invokevirtual 117	java/io/File:mkdirs	()Z
    //   260: pop
    //   261: aconst_null
    //   262: astore 15
    //   264: aconst_null
    //   265: astore 16
    //   267: aconst_null
    //   268: astore_2
    //   269: new 119	java/io/FileOutputStream
    //   272: dup
    //   273: aload_3
    //   274: invokespecial 120	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   277: astore 14
    //   279: aload 17
    //   281: getstatic 126	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   284: bipush 100
    //   286: aload 14
    //   288: invokevirtual 130	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   291: pop
    //   292: aload 14
    //   294: invokevirtual 133	java/io/FileOutputStream:close	()V
    //   297: aload 17
    //   299: invokevirtual 74	android/graphics/Bitmap:recycle	()V
    //   302: aload 14
    //   304: invokevirtual 133	java/io/FileOutputStream:close	()V
    //   307: goto +45 -> 352
    //   310: astore_2
    //   311: invokestatic 138	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   314: ifeq +38 -> 352
    //   317: new 140	java/lang/StringBuilder
    //   320: dup
    //   321: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   324: astore 15
    //   326: aload 15
    //   328: ldc 143
    //   330: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: pop
    //   334: aload 15
    //   336: aload_2
    //   337: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   340: pop
    //   341: ldc 24
    //   343: iconst_1
    //   344: aload 15
    //   346: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   349: invokestatic 158	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   352: aload 14
    //   354: astore_2
    //   355: goto +181 -> 536
    //   358: astore_0
    //   359: aload 14
    //   361: astore_2
    //   362: goto +541 -> 903
    //   365: astore 15
    //   367: goto +20 -> 387
    //   370: astore 15
    //   372: goto +106 -> 478
    //   375: astore_0
    //   376: goto +527 -> 903
    //   379: astore_2
    //   380: aload 15
    //   382: astore 14
    //   384: aload_2
    //   385: astore 15
    //   387: aload 14
    //   389: astore_2
    //   390: aload 15
    //   392: invokevirtual 161	java/io/IOException:printStackTrace	()V
    //   395: aload 17
    //   397: invokevirtual 74	android/graphics/Bitmap:recycle	()V
    //   400: aload 14
    //   402: astore_2
    //   403: aload 14
    //   405: ifnull +131 -> 536
    //   408: aload 14
    //   410: invokevirtual 133	java/io/FileOutputStream:close	()V
    //   413: aload 14
    //   415: astore_2
    //   416: goto +120 -> 536
    //   419: astore 15
    //   421: aload 14
    //   423: astore_2
    //   424: invokestatic 138	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   427: ifeq +109 -> 536
    //   430: new 140	java/lang/StringBuilder
    //   433: dup
    //   434: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   437: astore 16
    //   439: aload 14
    //   441: astore_2
    //   442: aload 16
    //   444: ldc 143
    //   446: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   449: pop
    //   450: aload 16
    //   452: aload 15
    //   454: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   457: pop
    //   458: ldc 24
    //   460: iconst_1
    //   461: aload 16
    //   463: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   466: invokestatic 158	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   469: goto +67 -> 536
    //   472: astore 15
    //   474: aload 16
    //   476: astore 14
    //   478: aload 14
    //   480: astore_2
    //   481: aload 15
    //   483: invokevirtual 162	java/io/FileNotFoundException:printStackTrace	()V
    //   486: aload 17
    //   488: invokevirtual 74	android/graphics/Bitmap:recycle	()V
    //   491: aload 14
    //   493: astore_2
    //   494: aload 14
    //   496: ifnull +40 -> 536
    //   499: aload 14
    //   501: invokevirtual 133	java/io/FileOutputStream:close	()V
    //   504: aload 14
    //   506: astore_2
    //   507: goto +29 -> 536
    //   510: astore 15
    //   512: aload 14
    //   514: astore_2
    //   515: invokestatic 138	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   518: ifeq +18 -> 536
    //   521: new 140	java/lang/StringBuilder
    //   524: dup
    //   525: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   528: astore 16
    //   530: aload 14
    //   532: astore_2
    //   533: goto -91 -> 442
    //   536: ldc 164
    //   538: invokestatic 170	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   541: checkcast 164	com/tencent/qzonehub/api/webview/IQzoneWebViewPluginHelper
    //   544: aload_3
    //   545: invokeinterface 174 2 0
    //   550: astore 14
    //   552: aload 14
    //   554: ifnonnull +5 -> 559
    //   557: iconst_0
    //   558: ireturn
    //   559: ldc 164
    //   561: invokestatic 170	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   564: checkcast 164	com/tencent/qzonehub/api/webview/IQzoneWebViewPluginHelper
    //   567: aload_0
    //   568: iload_1
    //   569: aload 14
    //   571: invokeinterface 178 4 0
    //   576: dstore 8
    //   578: dload 8
    //   580: dconst_0
    //   581: dcmpl
    //   582: ifle +53 -> 635
    //   585: aload 14
    //   587: getfield 183	cooperation/qzone/model/Size:width	I
    //   590: i2d
    //   591: dstore 10
    //   593: dload 10
    //   595: invokestatic 189	java/lang/Double:isNaN	(D)Z
    //   598: pop
    //   599: aload 14
    //   601: dload 10
    //   603: dload 8
    //   605: ddiv
    //   606: d2i
    //   607: putfield 183	cooperation/qzone/model/Size:width	I
    //   610: aload 14
    //   612: getfield 192	cooperation/qzone/model/Size:height	I
    //   615: i2d
    //   616: dstore 10
    //   618: dload 10
    //   620: invokestatic 189	java/lang/Double:isNaN	(D)Z
    //   623: pop
    //   624: aload 14
    //   626: dload 10
    //   628: dload 8
    //   630: ddiv
    //   631: d2i
    //   632: putfield 192	cooperation/qzone/model/Size:height	I
    //   635: ldc 164
    //   637: invokestatic 170	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   640: checkcast 164	com/tencent/qzonehub/api/webview/IQzoneWebViewPluginHelper
    //   643: aload_3
    //   644: aload 14
    //   646: getfield 183	cooperation/qzone/model/Size:width	I
    //   649: aload 14
    //   651: getfield 192	cooperation/qzone/model/Size:height	I
    //   654: invokeinterface 196 4 0
    //   659: iconst_2
    //   660: invokestatic 202	android/util/Base64:decode	(Ljava/lang/String;I)[B
    //   663: astore 14
    //   665: aload_2
    //   666: astore_0
    //   667: new 119	java/io/FileOutputStream
    //   670: dup
    //   671: aload_3
    //   672: invokespecial 120	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   675: astore_3
    //   676: aload_3
    //   677: aload 14
    //   679: invokevirtual 206	java/io/FileOutputStream:write	([B)V
    //   682: aload_3
    //   683: invokevirtual 133	java/io/FileOutputStream:close	()V
    //   686: aload_3
    //   687: invokevirtual 133	java/io/FileOutputStream:close	()V
    //   690: iconst_1
    //   691: ireturn
    //   692: astore_0
    //   693: invokestatic 138	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   696: ifeq +34 -> 730
    //   699: new 140	java/lang/StringBuilder
    //   702: dup
    //   703: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   706: astore_2
    //   707: aload_2
    //   708: ldc 208
    //   710: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   713: pop
    //   714: aload_2
    //   715: aload_0
    //   716: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   719: pop
    //   720: ldc 24
    //   722: iconst_1
    //   723: aload_2
    //   724: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   727: invokestatic 158	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   730: iconst_1
    //   731: ireturn
    //   732: astore_2
    //   733: aload_3
    //   734: astore_0
    //   735: goto +117 -> 852
    //   738: astore_0
    //   739: aload_3
    //   740: astore_2
    //   741: aload_0
    //   742: astore_3
    //   743: goto +16 -> 759
    //   746: astore_0
    //   747: aload_3
    //   748: astore_2
    //   749: aload_0
    //   750: astore_3
    //   751: goto +65 -> 816
    //   754: astore_2
    //   755: goto +97 -> 852
    //   758: astore_3
    //   759: aload_2
    //   760: astore_0
    //   761: aload_3
    //   762: invokevirtual 161	java/io/IOException:printStackTrace	()V
    //   765: aload_2
    //   766: ifnull +84 -> 850
    //   769: aload_2
    //   770: invokevirtual 133	java/io/FileOutputStream:close	()V
    //   773: iconst_0
    //   774: ireturn
    //   775: astore_2
    //   776: invokestatic 138	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   779: ifeq +71 -> 850
    //   782: new 140	java/lang/StringBuilder
    //   785: dup
    //   786: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   789: astore_0
    //   790: aload_0
    //   791: ldc 208
    //   793: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   796: pop
    //   797: aload_0
    //   798: aload_2
    //   799: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   802: pop
    //   803: ldc 24
    //   805: iconst_1
    //   806: aload_0
    //   807: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   810: invokestatic 158	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   813: iconst_0
    //   814: ireturn
    //   815: astore_3
    //   816: aload_2
    //   817: astore_0
    //   818: aload_3
    //   819: invokevirtual 162	java/io/FileNotFoundException:printStackTrace	()V
    //   822: aload_2
    //   823: ifnull +27 -> 850
    //   826: aload_2
    //   827: invokevirtual 133	java/io/FileOutputStream:close	()V
    //   830: iconst_0
    //   831: ireturn
    //   832: astore_2
    //   833: invokestatic 138	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   836: ifeq +14 -> 850
    //   839: new 140	java/lang/StringBuilder
    //   842: dup
    //   843: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   846: astore_0
    //   847: goto -57 -> 790
    //   850: iconst_0
    //   851: ireturn
    //   852: aload_0
    //   853: ifnull +48 -> 901
    //   856: aload_0
    //   857: invokevirtual 133	java/io/FileOutputStream:close	()V
    //   860: goto +41 -> 901
    //   863: astore_0
    //   864: invokestatic 138	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   867: ifeq +34 -> 901
    //   870: new 140	java/lang/StringBuilder
    //   873: dup
    //   874: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   877: astore_3
    //   878: aload_3
    //   879: ldc 208
    //   881: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   884: pop
    //   885: aload_3
    //   886: aload_0
    //   887: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   890: pop
    //   891: ldc 24
    //   893: iconst_1
    //   894: aload_3
    //   895: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   898: invokestatic 158	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   901: aload_2
    //   902: athrow
    //   903: aload 17
    //   905: invokevirtual 74	android/graphics/Bitmap:recycle	()V
    //   908: aload_2
    //   909: ifnull +48 -> 957
    //   912: aload_2
    //   913: invokevirtual 133	java/io/FileOutputStream:close	()V
    //   916: goto +41 -> 957
    //   919: astore_2
    //   920: invokestatic 138	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   923: ifeq +34 -> 957
    //   926: new 140	java/lang/StringBuilder
    //   929: dup
    //   930: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   933: astore_3
    //   934: aload_3
    //   935: ldc 143
    //   937: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   940: pop
    //   941: aload_3
    //   942: aload_2
    //   943: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   946: pop
    //   947: ldc 24
    //   949: iconst_1
    //   950: aload_3
    //   951: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   954: invokestatic 158	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   957: aload_0
    //   958: athrow
    //   959: astore_0
    //   960: goto +15 -> 975
    //   963: astore_0
    //   964: aload_0
    //   965: invokevirtual 78	java/lang/OutOfMemoryError:fillInStackTrace	()Ljava/lang/Throwable;
    //   968: pop
    //   969: aload_2
    //   970: invokevirtual 74	android/graphics/Bitmap:recycle	()V
    //   973: iconst_0
    //   974: ireturn
    //   975: aload_2
    //   976: invokevirtual 74	android/graphics/Bitmap:recycle	()V
    //   979: goto +5 -> 984
    //   982: aload_0
    //   983: athrow
    //   984: goto -2 -> 982
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	987	0	paramContext	android.content.Context
    //   0	987	1	paramInt1	int
    //   0	987	2	paramBitmap	android.graphics.Bitmap
    //   0	987	3	paramString	String
    //   0	987	4	paramFloat1	float
    //   0	987	5	paramFloat2	float
    //   0	987	6	paramFloat3	float
    //   0	987	7	paramInt2	int
    //   576	53	8	d1	double
    //   591	36	10	d2	double
    //   117	92	12	f1	float
    //   158	48	13	f2	float
    //   44	634	14	localObject	Object
    //   262	83	15	localStringBuilder1	StringBuilder
    //   365	1	15	localIOException1	java.io.IOException
    //   370	11	15	localFileNotFoundException1	java.io.FileNotFoundException
    //   385	6	15	localBitmap1	android.graphics.Bitmap
    //   419	34	15	localIOException2	java.io.IOException
    //   472	10	15	localFileNotFoundException2	java.io.FileNotFoundException
    //   510	1	15	localIOException3	java.io.IOException
    //   265	264	16	localStringBuilder2	StringBuilder
    //   217	687	17	localBitmap2	android.graphics.Bitmap
    // Exception table:
    //   from	to	target	type
    //   69	92	98	java/lang/OutOfMemoryError
    //   302	307	310	java/io/IOException
    //   279	297	358	finally
    //   279	297	365	java/io/IOException
    //   279	297	370	java/io/FileNotFoundException
    //   269	279	375	finally
    //   390	395	375	finally
    //   481	486	375	finally
    //   269	279	379	java/io/IOException
    //   408	413	419	java/io/IOException
    //   269	279	472	java/io/FileNotFoundException
    //   499	504	510	java/io/IOException
    //   686	690	692	java/io/IOException
    //   676	686	732	finally
    //   676	686	738	java/io/IOException
    //   676	686	746	java/io/FileNotFoundException
    //   667	676	754	finally
    //   761	765	754	finally
    //   818	822	754	finally
    //   667	676	758	java/io/IOException
    //   769	773	775	java/io/IOException
    //   667	676	815	java/io/FileNotFoundException
    //   826	830	832	java/io/IOException
    //   856	860	863	java/io/IOException
    //   912	916	919	java/io/IOException
    //   195	219	959	finally
    //   964	969	959	finally
    //   195	219	963	java/lang/OutOfMemoryError
  }
  
  private void custom(String paramString)
  {
    Object localObject = this.mRuntime.a().getIntent();
    String str = getCustomImageFilePath();
    Rect localRect = new Rect();
    this.mRuntime.a().getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
    ((Intent)localObject).putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
    ((Intent)localObject).putExtra("isFromPhoto", true);
    ((Intent)localObject).putExtra("fromChatBackgroundJsPlugin", true);
    ((Intent)localObject).putExtra("onNewIntentReDoStateMachine", false);
    PhotoUtils.startPhotoListEdit((Intent)localObject, this.mRuntime.a(), QQBrowserActivity.class.getName(), localRect.width() / 5 * 4, localRect.height() / 5 * 4, localRect.width(), localRect.height(), str);
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
      QQToast.a(this.mRuntime.a(), 2131695003, 0).a();
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
        paramString1 = this.mRuntime.a().getIntent().getStringExtra("chatbg_intent_frinedUin");
        paramJsBridgeListener = paramString1;
        if (paramString1 == null) {
          paramJsBridgeListener = "none";
        }
        j = this.mRuntime.a().getIntent().getIntExtra("uintype", -1);
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
            localObject2 = this.mRuntime.a().getIntent();
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
              paramJsBridgeListener.putExtra("selfSet_leftViewText", this.mRuntime.a().getString(2131690706));
              paramJsBridgeListener.putExtra("hide_left_button", false);
              paramJsBridgeListener.putExtra("show_right_close_button", false);
              paramJsBridgeListener.putExtra("startOpenPageTime", System.currentTimeMillis());
              VasWebviewUtil.b(this.mRuntime.a(), IndividuationUrlHelper.a(this.mRuntime.a(), "background", ""), 33554432L, paramJsBridgeListener, false, -1);
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
              i = ImageUtil.c(str4);
              bool = compressBitmapToFile(this.mRuntime.a(), Integer.parseInt(paramString2), BitmapFactory.decodeFile(str4), str5, Float.parseFloat((String)localObject2), Float.parseFloat(str2), Float.parseFloat((String)localObject1), i);
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
          paramString2.put("msg", HardCodeUtil.a(2131701797));
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
    AppInterface localAppInterface = this.mRuntime.a();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ChatBackgroundJsPlugin
 * JD-Core Version:    0.7.0.1
 */