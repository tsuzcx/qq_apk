package com.tencent.mobileqq.vaswebviewplugin;

import ajya;
import akvt;
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
import anqq;
import anqu;
import axqy;
import bbef;
import bbqd;
import bcdp;
import bcql;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.theme.diy.ThemeDiyStyleLogic;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
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
    //   1: ifnonnull +9 -> 10
    //   4: iconst_0
    //   5: istore 12
    //   7: iload 12
    //   9: ireturn
    //   10: iload_1
    //   11: invokestatic 50	com/tencent/mobileqq/vaswebviewplugin/ChatBackgroundJsPlugin:getCompressType	(I)I
    //   14: istore_1
    //   15: fload 4
    //   17: fstore 10
    //   19: fload 4
    //   21: fload 6
    //   23: fadd
    //   24: ldc 51
    //   26: fcmpl
    //   27: ifle +10 -> 37
    //   30: ldc 51
    //   32: fload 6
    //   34: fsub
    //   35: fstore 10
    //   37: aload_2
    //   38: astore 14
    //   40: iload 7
    //   42: ifeq +58 -> 100
    //   45: new 53	android/graphics/Matrix
    //   48: dup
    //   49: invokespecial 54	android/graphics/Matrix:<init>	()V
    //   52: astore 14
    //   54: aload 14
    //   56: iload 7
    //   58: i2f
    //   59: aload_2
    //   60: invokevirtual 60	android/graphics/Bitmap:getWidth	()I
    //   63: i2f
    //   64: fconst_2
    //   65: fdiv
    //   66: aload_2
    //   67: invokevirtual 63	android/graphics/Bitmap:getHeight	()I
    //   70: i2f
    //   71: fconst_2
    //   72: fdiv
    //   73: invokevirtual 67	android/graphics/Matrix:postRotate	(FFF)Z
    //   76: pop
    //   77: aload_2
    //   78: iconst_0
    //   79: iconst_0
    //   80: aload_2
    //   81: invokevirtual 60	android/graphics/Bitmap:getWidth	()I
    //   84: aload_2
    //   85: invokevirtual 63	android/graphics/Bitmap:getHeight	()I
    //   88: aload 14
    //   90: iconst_0
    //   91: invokestatic 71	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   94: astore 14
    //   96: aload_2
    //   97: invokevirtual 74	android/graphics/Bitmap:recycle	()V
    //   100: aload 14
    //   102: invokevirtual 60	android/graphics/Bitmap:getWidth	()I
    //   105: i2f
    //   106: fstore 4
    //   108: fload 6
    //   110: ldc 51
    //   112: fdiv
    //   113: fload 4
    //   115: fmul
    //   116: fstore 11
    //   118: aload_0
    //   119: invokevirtual 80	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   122: invokevirtual 86	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   125: getfield 91	android/util/DisplayMetrics:heightPixels	I
    //   128: i2f
    //   129: fload 11
    //   131: fmul
    //   132: aload_0
    //   133: invokevirtual 80	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   136: invokevirtual 86	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   139: getfield 94	android/util/DisplayMetrics:widthPixels	I
    //   142: i2f
    //   143: fdiv
    //   144: fstore 6
    //   146: fload 5
    //   148: ldc 51
    //   150: fdiv
    //   151: aload 14
    //   153: invokevirtual 60	android/graphics/Bitmap:getWidth	()I
    //   156: i2f
    //   157: fmul
    //   158: fstore 5
    //   160: fload 6
    //   162: fstore 4
    //   164: fload 6
    //   166: fload 5
    //   168: fadd
    //   169: aload 14
    //   171: invokevirtual 63	android/graphics/Bitmap:getHeight	()I
    //   174: i2f
    //   175: fcmpl
    //   176: ifle +14 -> 190
    //   179: aload 14
    //   181: invokevirtual 63	android/graphics/Bitmap:getHeight	()I
    //   184: i2f
    //   185: fload 5
    //   187: fsub
    //   188: fstore 4
    //   190: fload 10
    //   192: ldc 51
    //   194: fdiv
    //   195: fstore 6
    //   197: aload 14
    //   199: fload 6
    //   201: aload 14
    //   203: invokevirtual 60	android/graphics/Bitmap:getWidth	()I
    //   206: i2f
    //   207: fmul
    //   208: f2i
    //   209: fload 5
    //   211: f2i
    //   212: fload 11
    //   214: f2i
    //   215: fload 4
    //   217: f2i
    //   218: invokestatic 97	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIII)Landroid/graphics/Bitmap;
    //   221: astore 16
    //   223: aload 16
    //   225: ifnonnull +18 -> 243
    //   228: aload 14
    //   230: invokevirtual 74	android/graphics/Bitmap:recycle	()V
    //   233: iconst_0
    //   234: ireturn
    //   235: astore_0
    //   236: aload_0
    //   237: invokevirtual 101	java/lang/OutOfMemoryError:fillInStackTrace	()Ljava/lang/Throwable;
    //   240: pop
    //   241: iconst_0
    //   242: ireturn
    //   243: aload 14
    //   245: invokevirtual 74	android/graphics/Bitmap:recycle	()V
    //   248: new 103	java/io/File
    //   251: dup
    //   252: aload_3
    //   253: invokespecial 106	java/io/File:<init>	(Ljava/lang/String;)V
    //   256: astore_2
    //   257: aload_2
    //   258: invokevirtual 110	java/io/File:getParentFile	()Ljava/io/File;
    //   261: invokevirtual 114	java/io/File:exists	()Z
    //   264: ifne +11 -> 275
    //   267: aload_2
    //   268: invokevirtual 110	java/io/File:getParentFile	()Ljava/io/File;
    //   271: invokevirtual 117	java/io/File:mkdirs	()Z
    //   274: pop
    //   275: aconst_null
    //   276: astore_2
    //   277: new 119	java/io/FileOutputStream
    //   280: dup
    //   281: aload_3
    //   282: invokespecial 120	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   285: astore 14
    //   287: aload 14
    //   289: astore_2
    //   290: aload 16
    //   292: getstatic 126	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   295: bipush 100
    //   297: aload 14
    //   299: invokevirtual 130	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   302: pop
    //   303: aload 14
    //   305: astore_2
    //   306: aload 14
    //   308: invokevirtual 133	java/io/FileOutputStream:close	()V
    //   311: aload 16
    //   313: invokevirtual 74	android/graphics/Bitmap:recycle	()V
    //   316: aload 14
    //   318: astore_2
    //   319: aload 14
    //   321: ifnull +11 -> 332
    //   324: aload 14
    //   326: invokevirtual 133	java/io/FileOutputStream:close	()V
    //   329: aload 14
    //   331: astore_2
    //   332: aload_3
    //   333: invokestatic 139	bhsc:a	(Ljava/lang/String;)Lbhsf;
    //   336: astore 14
    //   338: aload 14
    //   340: ifnonnull +280 -> 620
    //   343: iconst_0
    //   344: ireturn
    //   345: astore_0
    //   346: aload_0
    //   347: invokevirtual 101	java/lang/OutOfMemoryError:fillInStackTrace	()Ljava/lang/Throwable;
    //   350: pop
    //   351: aload 14
    //   353: invokevirtual 74	android/graphics/Bitmap:recycle	()V
    //   356: iconst_0
    //   357: ireturn
    //   358: astore_0
    //   359: aload 14
    //   361: invokevirtual 74	android/graphics/Bitmap:recycle	()V
    //   364: aload_0
    //   365: athrow
    //   366: astore 15
    //   368: aload 14
    //   370: astore_2
    //   371: invokestatic 144	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   374: ifeq -42 -> 332
    //   377: ldc 24
    //   379: iconst_1
    //   380: new 146	java/lang/StringBuilder
    //   383: dup
    //   384: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   387: ldc 149
    //   389: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   392: aload 15
    //   394: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   397: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   400: invokestatic 164	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   403: aload 14
    //   405: astore_2
    //   406: goto -74 -> 332
    //   409: astore 15
    //   411: aconst_null
    //   412: astore 14
    //   414: aload 14
    //   416: astore_2
    //   417: aload 15
    //   419: invokevirtual 167	java/io/FileNotFoundException:printStackTrace	()V
    //   422: aload 16
    //   424: invokevirtual 74	android/graphics/Bitmap:recycle	()V
    //   427: aload 14
    //   429: astore_2
    //   430: aload 14
    //   432: ifnull -100 -> 332
    //   435: aload 14
    //   437: invokevirtual 133	java/io/FileOutputStream:close	()V
    //   440: aload 14
    //   442: astore_2
    //   443: goto -111 -> 332
    //   446: astore 15
    //   448: aload 14
    //   450: astore_2
    //   451: invokestatic 144	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   454: ifeq -122 -> 332
    //   457: ldc 24
    //   459: iconst_1
    //   460: new 146	java/lang/StringBuilder
    //   463: dup
    //   464: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   467: ldc 149
    //   469: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   472: aload 15
    //   474: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   477: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   480: invokestatic 164	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   483: aload 14
    //   485: astore_2
    //   486: goto -154 -> 332
    //   489: astore 15
    //   491: aconst_null
    //   492: astore 14
    //   494: aload 14
    //   496: astore_2
    //   497: aload 15
    //   499: invokevirtual 168	java/io/IOException:printStackTrace	()V
    //   502: aload 16
    //   504: invokevirtual 74	android/graphics/Bitmap:recycle	()V
    //   507: aload 14
    //   509: astore_2
    //   510: aload 14
    //   512: ifnull -180 -> 332
    //   515: aload 14
    //   517: invokevirtual 133	java/io/FileOutputStream:close	()V
    //   520: aload 14
    //   522: astore_2
    //   523: goto -191 -> 332
    //   526: astore 15
    //   528: aload 14
    //   530: astore_2
    //   531: invokestatic 144	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   534: ifeq -202 -> 332
    //   537: ldc 24
    //   539: iconst_1
    //   540: new 146	java/lang/StringBuilder
    //   543: dup
    //   544: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   547: ldc 149
    //   549: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   552: aload 15
    //   554: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   557: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   560: invokestatic 164	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   563: aload 14
    //   565: astore_2
    //   566: goto -234 -> 332
    //   569: astore_0
    //   570: aload 16
    //   572: invokevirtual 74	android/graphics/Bitmap:recycle	()V
    //   575: aload_2
    //   576: ifnull +7 -> 583
    //   579: aload_2
    //   580: invokevirtual 133	java/io/FileOutputStream:close	()V
    //   583: aload_0
    //   584: athrow
    //   585: astore_2
    //   586: invokestatic 144	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   589: ifeq -6 -> 583
    //   592: ldc 24
    //   594: iconst_1
    //   595: new 146	java/lang/StringBuilder
    //   598: dup
    //   599: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   602: ldc 149
    //   604: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   607: aload_2
    //   608: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   611: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   614: invokestatic 164	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   617: goto -34 -> 583
    //   620: aload_0
    //   621: iload_1
    //   622: aload 14
    //   624: invokestatic 173	bhso:a	(Landroid/content/Context;ILbhsf;)D
    //   627: dstore 8
    //   629: dload 8
    //   631: dconst_0
    //   632: dcmpl
    //   633: ifle +33 -> 666
    //   636: aload 14
    //   638: aload 14
    //   640: getfield 177	bhsf:a	I
    //   643: i2d
    //   644: dload 8
    //   646: ddiv
    //   647: d2i
    //   648: putfield 177	bhsf:a	I
    //   651: aload 14
    //   653: aload 14
    //   655: getfield 180	bhsf:b	I
    //   658: i2d
    //   659: dload 8
    //   661: ddiv
    //   662: d2i
    //   663: putfield 180	bhsf:b	I
    //   666: aload_3
    //   667: aload 14
    //   669: getfield 177	bhsf:a	I
    //   672: aload 14
    //   674: getfield 180	bhsf:b	I
    //   677: invokestatic 183	bhsc:a	(Ljava/lang/String;II)Ljava/lang/String;
    //   680: iconst_2
    //   681: invokestatic 189	android/util/Base64:decode	(Ljava/lang/String;I)[B
    //   684: astore 14
    //   686: new 119	java/io/FileOutputStream
    //   689: dup
    //   690: aload_3
    //   691: invokespecial 120	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   694: astore_3
    //   695: aload_3
    //   696: astore_0
    //   697: aload_3
    //   698: aload 14
    //   700: invokevirtual 193	java/io/FileOutputStream:write	([B)V
    //   703: aload_3
    //   704: astore_0
    //   705: aload_3
    //   706: invokevirtual 133	java/io/FileOutputStream:close	()V
    //   709: iconst_1
    //   710: istore 13
    //   712: iload 13
    //   714: istore 12
    //   716: aload_3
    //   717: ifnull -710 -> 7
    //   720: aload_3
    //   721: invokevirtual 133	java/io/FileOutputStream:close	()V
    //   724: iconst_1
    //   725: ireturn
    //   726: astore_0
    //   727: iload 13
    //   729: istore 12
    //   731: invokestatic 144	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   734: ifeq -727 -> 7
    //   737: ldc 24
    //   739: iconst_1
    //   740: new 146	java/lang/StringBuilder
    //   743: dup
    //   744: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   747: ldc 195
    //   749: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   752: aload_0
    //   753: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   756: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   759: invokestatic 164	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   762: iconst_1
    //   763: ireturn
    //   764: astore_0
    //   765: aload_2
    //   766: astore_3
    //   767: aload_0
    //   768: astore_2
    //   769: aload_3
    //   770: astore_0
    //   771: aload_2
    //   772: invokevirtual 167	java/io/FileNotFoundException:printStackTrace	()V
    //   775: aload_3
    //   776: ifnull +7 -> 783
    //   779: aload_3
    //   780: invokevirtual 133	java/io/FileOutputStream:close	()V
    //   783: iconst_0
    //   784: ireturn
    //   785: astore_0
    //   786: invokestatic 144	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   789: ifeq -6 -> 783
    //   792: ldc 24
    //   794: iconst_1
    //   795: new 146	java/lang/StringBuilder
    //   798: dup
    //   799: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   802: ldc 195
    //   804: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   807: aload_0
    //   808: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   811: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   814: invokestatic 164	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   817: goto -34 -> 783
    //   820: astore_0
    //   821: aload_2
    //   822: astore_3
    //   823: aload_0
    //   824: astore_2
    //   825: aload_3
    //   826: astore_0
    //   827: aload_2
    //   828: invokevirtual 168	java/io/IOException:printStackTrace	()V
    //   831: aload_3
    //   832: ifnull -49 -> 783
    //   835: aload_3
    //   836: invokevirtual 133	java/io/FileOutputStream:close	()V
    //   839: goto -56 -> 783
    //   842: astore_0
    //   843: invokestatic 144	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   846: ifeq -63 -> 783
    //   849: ldc 24
    //   851: iconst_1
    //   852: new 146	java/lang/StringBuilder
    //   855: dup
    //   856: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   859: ldc 195
    //   861: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   864: aload_0
    //   865: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   868: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   871: invokestatic 164	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   874: goto -91 -> 783
    //   877: astore_0
    //   878: aload_2
    //   879: astore_3
    //   880: aload_0
    //   881: astore_2
    //   882: aload_3
    //   883: ifnull +7 -> 890
    //   886: aload_3
    //   887: invokevirtual 133	java/io/FileOutputStream:close	()V
    //   890: aload_2
    //   891: athrow
    //   892: astore_0
    //   893: invokestatic 144	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   896: ifeq -6 -> 890
    //   899: ldc 24
    //   901: iconst_1
    //   902: new 146	java/lang/StringBuilder
    //   905: dup
    //   906: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   909: ldc 195
    //   911: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   914: aload_0
    //   915: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   918: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   921: invokestatic 164	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   924: goto -34 -> 890
    //   927: astore_2
    //   928: aload_0
    //   929: astore_3
    //   930: goto -48 -> 882
    //   933: astore_2
    //   934: goto -109 -> 825
    //   937: astore_2
    //   938: goto -169 -> 769
    //   941: astore_0
    //   942: goto -372 -> 570
    //   945: astore 15
    //   947: goto -453 -> 494
    //   950: astore 15
    //   952: goto -538 -> 414
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	955	0	paramContext	android.content.Context
    //   0	955	1	paramInt1	int
    //   0	955	2	paramBitmap	android.graphics.Bitmap
    //   0	955	3	paramString	String
    //   0	955	4	paramFloat1	float
    //   0	955	5	paramFloat2	float
    //   0	955	6	paramFloat3	float
    //   0	955	7	paramInt2	int
    //   627	33	8	d	double
    //   17	174	10	f1	float
    //   116	97	11	f2	float
    //   5	725	12	bool1	boolean
    //   710	18	13	bool2	boolean
    //   38	661	14	localObject	Object
    //   366	27	15	localIOException1	java.io.IOException
    //   409	9	15	localFileNotFoundException1	java.io.FileNotFoundException
    //   446	27	15	localIOException2	java.io.IOException
    //   489	9	15	localIOException3	java.io.IOException
    //   526	27	15	localIOException4	java.io.IOException
    //   945	1	15	localIOException5	java.io.IOException
    //   950	1	15	localFileNotFoundException2	java.io.FileNotFoundException
    //   221	350	16	localBitmap	android.graphics.Bitmap
    // Exception table:
    //   from	to	target	type
    //   77	100	235	java/lang/OutOfMemoryError
    //   197	223	345	java/lang/OutOfMemoryError
    //   197	223	358	finally
    //   346	351	358	finally
    //   324	329	366	java/io/IOException
    //   277	287	409	java/io/FileNotFoundException
    //   435	440	446	java/io/IOException
    //   277	287	489	java/io/IOException
    //   515	520	526	java/io/IOException
    //   277	287	569	finally
    //   579	583	585	java/io/IOException
    //   720	724	726	java/io/IOException
    //   686	695	764	java/io/FileNotFoundException
    //   779	783	785	java/io/IOException
    //   686	695	820	java/io/IOException
    //   835	839	842	java/io/IOException
    //   686	695	877	finally
    //   886	890	892	java/io/IOException
    //   697	703	927	finally
    //   705	709	927	finally
    //   771	775	927	finally
    //   827	831	927	finally
    //   697	703	933	java/io/IOException
    //   705	709	933	java/io/IOException
    //   697	703	937	java/io/FileNotFoundException
    //   705	709	937	java/io/FileNotFoundException
    //   290	303	941	finally
    //   306	311	941	finally
    //   417	422	941	finally
    //   497	502	941	finally
    //   290	303	945	java/io/IOException
    //   306	311	945	java/io/IOException
    //   290	303	950	java/io/FileNotFoundException
    //   306	311	950	java/io/FileNotFoundException
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
    PhotoUtils.a((Intent)localObject, this.mRuntime.a(), QQBrowserActivity.class.getName(), localRect.width() / 5 * 4, localRect.height() / 5 * 4, localRect.width(), localRect.height(), str);
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
    switch (paramInt)
    {
    default: 
      return 0;
    case 1: 
      return 2;
    }
    return 3;
  }
  
  private String getCustomImageFilePath()
  {
    return ThemeDiyStyleLogic.getDataDIYDir() + akvt.a(this.browserApp.getAccount()) + "/" + System.currentTimeMillis() + ".jpg";
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
      bcql.a(this.mRuntime.a(), 2131695347, 0).a();
      axqy.b(null, "CliOper", "", "", "chatbackground", "BjIDShezhi", 0, 0, "1", "", "", "");
    }
  }
  
  protected long getPluginBusiness()
  {
    return 2181038080L;
  }
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
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
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatBackgroundJsPlugin", 2, "handleJsRequest, url=" + paramString1 + ", pkgName=" + paramString2 + ", methodName=" + paramString3);
    }
    if ((paramString1 == null) || (!"chatBg".equals(paramString2)) || (paramString3 == null)) {
      return false;
    }
    Object localObject1 = WebViewPlugin.getJsonFromJSBridge(paramString1);
    if (localObject1 == null) {
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ChatBackgroundJsPlugin", 2, "handleJsRequest JSON = " + ((JSONObject)localObject1).toString());
    }
    paramVarArgs = ((JSONObject)localObject1).optString("callback");
    if (TextUtils.isEmpty(paramVarArgs))
    {
      QLog.e("ChatBackgroundJsPlugin", 1, "callback id is null, so return");
      return true;
    }
    int j;
    int i;
    if ("getCurrentChatBgId".equals(paramString3))
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
      super.sendRemoteReq(anqu.a(paramJsBridgeListener, paramVarArgs, this.mOnRemoteResp.key, this.mReqBundle), false, true);
      return true;
      if ("startDownload".equals(paramString3)) {}
      try
      {
        paramString1 = ((JSONObject)localObject1).getString("id");
        paramString2 = ((JSONObject)localObject1).getString("url");
        this.mId = paramString1;
        this.mUrl = paramString2;
        paramString3 = ((JSONObject)localObject1).getString("name");
        localObject1 = ((JSONObject)localObject1).getString("thumbUrl");
        paramJsBridgeListener = "chatbackground_startDownload";
        try
        {
          this.mReqBundle.clear();
          this.mReqBundle.putString("id", paramString1);
          this.mReqBundle.putString("url", paramString2);
          this.mReqBundle.putString("name", paramString3);
          this.mReqBundle.putString("thumbUrl", (String)localObject1);
        }
        catch (JSONException paramString1) {}
      }
      catch (JSONException paramString1)
      {
        for (;;)
        {
          paramJsBridgeListener = "";
        }
      }
      paramString1.printStackTrace();
      continue;
      if ("stopDownload".equals(paramString3)) {}
      try
      {
        paramString1 = ((JSONObject)localObject1).getString("id");
        paramString2 = ((JSONObject)localObject1).getString("url");
        paramJsBridgeListener = "chatbackground_stopdownload";
        try
        {
          this.mReqBundle.clear();
          this.mReqBundle.putString("id", paramString1);
          this.mReqBundle.putString("url", paramString2);
        }
        catch (JSONException paramString1) {}
      }
      catch (JSONException paramString1)
      {
        for (;;)
        {
          paramJsBridgeListener = "";
        }
      }
      paramString1.printStackTrace();
      continue;
      if (!"queryInfo".equals(paramString3)) {
        break;
      }
      try
      {
        paramString1 = ((JSONObject)localObject1).getString("id");
        paramString2 = ((JSONObject)localObject1).getString("url");
        paramJsBridgeListener = "chatbackground_querinfo";
        try
        {
          this.mReqBundle.clear();
          this.mReqBundle.putString("id", paramString1);
          this.mReqBundle.putString("url", paramString2);
        }
        catch (JSONException paramString1) {}
      }
      catch (JSONException paramString1)
      {
        for (;;)
        {
          String str1;
          Object localObject2;
          String str3;
          String str2;
          String str4;
          boolean bool;
          paramJsBridgeListener = "";
        }
      }
      paramString1.printStackTrace();
    }
    if ("setChatBg".equals(paramString3))
    {
      paramString3 = "chatbackground_setbg";
      for (;;)
      {
        try
        {
          str1 = ((JSONObject)localObject1).getString("id");
          if (!str1.startsWith("theme")) {
            break label803;
          }
          paramString1 = "null";
          localObject2 = this.mRuntime.a().getIntent();
          if (!((JSONObject)localObject1).has("friendUin")) {
            break label813;
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
          this.mReqBundle.putString("id", str1);
          if ((!TextUtils.isEmpty(this.mId)) && (this.mId.equals(str1))) {
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
        break;
        label803:
        paramString1 = ChatBackgroundManager.a(true, str1);
        continue;
        label813:
        paramJsBridgeListener = "none";
      }
    }
    if ("custom".equals(paramString3))
    {
      custom(paramVarArgs);
      return true;
    }
    if ("openPage".equals(paramString3)) {
      try
      {
        paramJsBridgeListener = new Intent();
        paramJsBridgeListener.putExtra("bg_replace_entrance", 8);
        paramJsBridgeListener.putExtra("selfSet_leftViewText", this.mRuntime.a().getString(2131690572));
        paramJsBridgeListener.putExtra("hide_left_button", false);
        paramJsBridgeListener.putExtra("show_right_close_button", false);
        paramJsBridgeListener.putExtra("startOpenPageTime", System.currentTimeMillis());
        VasWebviewUtil.openQQBrowserWithoutAD(this.mRuntime.a(), bbqd.a(this.mRuntime.a(), "background", ""), 33554432L, paramJsBridgeListener, false, -1);
        paramJsBridgeListener = new JSONObject();
        paramJsBridgeListener.put("result", 0);
        super.callJs(paramVarArgs, new String[] { paramJsBridgeListener.toString() });
        return true;
      }
      catch (Exception paramJsBridgeListener)
      {
        for (;;)
        {
          paramJsBridgeListener.printStackTrace();
          super.callJs(paramVarArgs, new String[] { paramJsBridgeListener.getMessage() });
        }
      }
    }
    if ("isSupportDynamic".equals(paramString3))
    {
      j = ChatBackgroundManager.a();
      if ((j & 0x1) != 0)
      {
        i = 1;
        label1037:
        if ((j & 0x2) == 0) {
          break label1229;
        }
      }
      for (j = 1;; j = 0)
      {
        try
        {
          paramJsBridgeListener = new JSONObject();
          paramJsBridgeListener.put("result", 0);
          paramJsBridgeListener.put("isDeviceEnable", i);
          paramJsBridgeListener.put("isWebviewEnable", j);
          if (QLog.isColorLevel()) {
            QLog.i("ChatBackgroundJsPlugin", 2, "isSupportDynamic deviceEnable:" + i + ", webViewEnable:" + j);
          }
          localObject1 = new JSONObject();
          ((JSONObject)localObject1).put("result", 0);
          ((JSONObject)localObject1).put("message", "isSupportDynamic return deviceEnable:" + i + ", webViewEnable:" + j);
          ((JSONObject)localObject1).put("data", paramJsBridgeListener);
          super.callJs(paramVarArgs, new String[] { ((JSONObject)localObject1).toString() });
        }
        catch (JSONException paramJsBridgeListener)
        {
          for (;;)
          {
            label1229:
            QLog.e("ChatBackgroundJsPlugin", 1, "handleJsRequest exception url=" + paramString1 + ", pkgName=" + paramString2 + ", methodName=" + paramString3, paramJsBridgeListener);
          }
        }
        paramJsBridgeListener = "";
        break;
        i = 0;
        break label1037;
      }
    }
    if ("setDIYConfig".equals(paramString3))
    {
      str3 = ((JSONObject)localObject1).optString("identifier");
      paramString2 = ((JSONObject)localObject1).optString("compressType");
      paramString3 = ((JSONObject)localObject1).optString("effectId");
      paramString1 = ((JSONObject)localObject1).optString("callback");
      str1 = ((JSONObject)localObject1).optString("originX");
      localObject2 = ((JSONObject)localObject1).optString("originY");
      str2 = ((JSONObject)localObject1).optString("uinType");
      if (((JSONObject)localObject1).has("friendUin")) {}
      for (paramJsBridgeListener = ((JSONObject)localObject1).optString("friendUin");; paramJsBridgeListener = null)
      {
        localObject1 = ((JSONObject)localObject1).optString("imageWidth");
        if (!TextUtils.isEmpty(str3)) {
          break;
        }
        QLog.w("ChatBackgroundJsPlugin", 2, "@coverOptimize  identifier is null or size is 0 ");
        return false;
      }
      str3 = new String(Base64.decode(str3, 2));
      str4 = getCustomImageFilePath();
      i = bbef.b(str3);
      bool = compressBitmapToFile(this.mRuntime.a(), Integer.parseInt(paramString2), BitmapFactory.decodeFile(str3), str4, Float.parseFloat(str1), Float.parseFloat((String)localObject2), Float.parseFloat((String)localObject1), i);
      if (bool) {
        handleCustomPic(paramJsBridgeListener, Integer.parseInt(str2), str4, Integer.parseInt(paramString3), true);
      }
      paramString2 = new JSONObject();
      if (!bool) {
        break label1585;
      }
    }
    for (paramJsBridgeListener = "0";; paramJsBridgeListener = "1")
    {
      try
      {
        paramString2.put("code", paramJsBridgeListener);
        if (!bool) {
          paramString2.put("msg", ajya.a(2131701584));
        }
      }
      catch (JSONException paramJsBridgeListener)
      {
        for (;;)
        {
          label1585:
          paramJsBridgeListener.printStackTrace();
          continue;
          paramJsBridgeListener = "1";
        }
      }
      if (!bool) {
        break label1600;
      }
      paramJsBridgeListener = "0";
      super.callJs(paramString1, new String[] { paramJsBridgeListener });
      paramJsBridgeListener = "";
      break;
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.mReqBundle = new Bundle();
    AppInterface localAppInterface = this.mRuntime.a();
    if ((localAppInterface instanceof BrowserAppInterface)) {
      this.browserApp = ((BrowserAppInterface)localAppInterface);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e("ChatBackgroundJsPlugin", 2, "ERROR!!! chatbg market is not running in web process!");
  }
  
  void onPushMsg(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ChatBackgroundJsPlugin", 2, "onPushMsg=" + paramBundle);
    }
    int i = paramBundle.getInt("id");
    int j = paramBundle.getInt("result");
    paramBundle = paramBundle.getString("callbackId");
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("id", i);
      localJSONObject.put("result", j);
      label85:
      super.callJs(paramBundle, new String[] { localJSONObject.toString() });
      return;
    }
    catch (JSONException localJSONException)
    {
      break label85;
    }
  }
  
  protected void onResponse(Bundle paramBundle)
  {
    if (paramBundle == null) {}
    String str1;
    String str2;
    JSONObject localJSONObject;
    do
    {
      do
      {
        do
        {
          return;
        } while (paramBundle.getInt("respkey", 0) != this.mOnRemoteResp.key);
        str1 = paramBundle.getString("cmd");
        try
        {
          str2 = paramBundle.getString("callbackid");
          paramBundle = paramBundle.getBundle("response");
          localJSONObject = new JSONObject();
          if (!"chatbackground_getCurrentId".equals(str1)) {
            break;
          }
          localJSONObject.put("id", paramBundle.getString("id"));
          localJSONObject.put("result", paramBundle.getInt("result"));
          localJSONObject.put("uinType", paramBundle.getInt("uinType"));
          localJSONObject.put("friendUin", paramBundle.getString("friendUin"));
          localJSONObject.put("themeId", paramBundle.getString("themeId"));
          localJSONObject.put("url", paramBundle.getString("url"));
          localJSONObject.put("isDIYTheme", paramBundle.getString("isDIYTheme"));
          super.callJs(str2, new String[] { localJSONObject.toString() });
          return;
        }
        catch (Exception paramBundle) {}
      } while (!QLog.isColorLevel());
      QLog.e("ChatBackgroundJsPlugin", 2, "Failed to handle cmd " + str1 + ", exception: " + paramBundle.getMessage());
      return;
      if ("chatbackground_setbg".equals(str1))
      {
        localJSONObject.put("result", paramBundle.getInt("result"));
        super.callJs(str2, new String[] { localJSONObject.toString() });
        return;
      }
      if ("chatbackground_querinfo".equals(str1))
      {
        localJSONObject.put("status", paramBundle.getInt("status"));
        localJSONObject.put("id", paramBundle.getString("id"));
        localJSONObject.put("message", paramBundle.getString("message"));
        localJSONObject.put("result", paramBundle.getInt("result"));
        localJSONObject.put("progress", paramBundle.getInt("progress"));
        super.callJs(str2, new String[] { localJSONObject.toString() });
        return;
      }
    } while (!"chatbackground_stopdownload".equals(str1));
    localJSONObject.put("id", paramBundle.getString("id"));
    localJSONObject.put("result", 0);
    super.callJs(str2, new String[] { localJSONObject.toString() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ChatBackgroundJsPlugin
 * JD-Core Version:    0.7.0.1
 */