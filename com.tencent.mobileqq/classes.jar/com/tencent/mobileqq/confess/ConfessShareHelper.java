package com.tencent.mobileqq.confess;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import com.google.zxing.common.BitMatrix;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.common.util.NetworkUtil;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.armap.INonMainProcAvatarLoader;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import mqq.manager.TicketManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ConfessShareHelper
{
  public static final String[] a = { "#B45EFF", "#3C8DFE", "#00B0C7", "#FF6565" };
  
  /* Error */
  public static Bitmap a(AppInterface paramAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3, JSONArray paramJSONArray, INonMainProcAvatarLoader paramINonMainProcAvatarLoader)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 17
    //   3: aconst_null
    //   4: astore 18
    //   6: aconst_null
    //   7: astore 16
    //   9: aload 18
    //   11: astore 15
    //   13: aload 8
    //   15: ifnull +972 -> 987
    //   18: aload 8
    //   20: invokevirtual 35	org/json/JSONArray:length	()I
    //   23: istore 11
    //   25: iconst_1
    //   26: istore 14
    //   28: aload 18
    //   30: astore 15
    //   32: iload 11
    //   34: iconst_1
    //   35: if_icmplt +952 -> 987
    //   38: aload_1
    //   39: ifnonnull +5 -> 44
    //   42: aconst_null
    //   43: areturn
    //   44: iload_2
    //   45: iflt +14 -> 59
    //   48: iload_2
    //   49: iconst_4
    //   50: if_icmplt +6 -> 56
    //   53: goto +6 -> 59
    //   56: goto +5 -> 61
    //   59: iconst_0
    //   60: istore_2
    //   61: iload_3
    //   62: iflt +14 -> 76
    //   65: iload_3
    //   66: iconst_4
    //   67: if_icmplt +6 -> 73
    //   70: goto +6 -> 76
    //   73: goto +5 -> 78
    //   76: iconst_0
    //   77: istore_3
    //   78: iload 4
    //   80: iflt +15 -> 95
    //   83: iload 4
    //   85: iconst_2
    //   86: if_icmplt +6 -> 92
    //   89: goto +6 -> 95
    //   92: goto +6 -> 98
    //   95: iconst_0
    //   96: istore 4
    //   98: iload_3
    //   99: ifeq +9 -> 108
    //   102: iconst_1
    //   103: istore 13
    //   105: goto +6 -> 111
    //   108: iconst_0
    //   109: istore 13
    //   111: iload 13
    //   113: iconst_1
    //   114: if_icmpne +16 -> 130
    //   117: sipush 1334
    //   120: istore 11
    //   122: sipush 750
    //   125: istore 12
    //   127: goto +13 -> 140
    //   130: sipush 290
    //   133: istore 11
    //   135: sipush 515
    //   138: istore 12
    //   140: aload_0
    //   141: invokestatic 38	com/tencent/mobileqq/confess/ConfessShareHelper:a	(Lcom/tencent/common/app/AppInterface;)Ljava/lang/String;
    //   144: ldc 39
    //   146: invokestatic 42	com/tencent/mobileqq/confess/ConfessShareHelper:a	(Ljava/lang/String;F)Ljava/lang/String;
    //   149: astore 21
    //   151: iload 12
    //   153: iload 11
    //   155: getstatic 48	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   158: invokestatic 54	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   161: astore 18
    //   163: aload 18
    //   165: astore 15
    //   167: new 56	android/graphics/Canvas
    //   170: dup
    //   171: aload 15
    //   173: invokespecial 59	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   176: astore 19
    //   178: new 61	android/graphics/Paint
    //   181: dup
    //   182: iconst_1
    //   183: invokespecial 64	android/graphics/Paint:<init>	(I)V
    //   186: astore 20
    //   188: aload_1
    //   189: aload 19
    //   191: iload_2
    //   192: iload 13
    //   194: fconst_1
    //   195: invokestatic 67	com/tencent/mobileqq/confess/ConfessShareHelper:a	(Landroid/content/Context;Landroid/graphics/Canvas;IIF)Z
    //   198: pop
    //   199: aload 20
    //   201: iconst_m1
    //   202: invokevirtual 70	android/graphics/Paint:setColor	(I)V
    //   205: iload 13
    //   207: ifne +425 -> 632
    //   210: iload 4
    //   212: ifne +26 -> 238
    //   215: aload 15
    //   217: astore 16
    //   219: aload 15
    //   221: astore 17
    //   223: aload 8
    //   225: iconst_0
    //   226: invokevirtual 74	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   229: ldc 76
    //   231: invokevirtual 82	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   234: astore_0
    //   235: goto +62 -> 297
    //   238: aload 15
    //   240: astore 16
    //   242: aload 15
    //   244: astore 17
    //   246: new 84	java/lang/StringBuilder
    //   249: dup
    //   250: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   253: astore_0
    //   254: aload 15
    //   256: astore 16
    //   258: aload 15
    //   260: astore 17
    //   262: aload_0
    //   263: aload 21
    //   265: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: pop
    //   269: aload 15
    //   271: astore 16
    //   273: aload 15
    //   275: astore 17
    //   277: aload_0
    //   278: ldc 91
    //   280: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: pop
    //   284: aload 15
    //   286: astore 16
    //   288: aload 15
    //   290: astore 17
    //   292: aload_0
    //   293: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   296: astore_0
    //   297: aload 15
    //   299: astore 16
    //   301: aload 15
    //   303: astore 17
    //   305: aload 20
    //   307: ldc 96
    //   309: invokevirtual 100	android/graphics/Paint:setTextSize	(F)V
    //   312: aload 15
    //   314: astore 16
    //   316: aload 15
    //   318: astore 17
    //   320: aload 20
    //   322: iconst_1
    //   323: invokevirtual 104	android/graphics/Paint:setFakeBoldText	(Z)V
    //   326: aload 15
    //   328: astore 16
    //   330: aload 15
    //   332: astore 17
    //   334: aload 20
    //   336: fconst_2
    //   337: fconst_0
    //   338: fconst_1
    //   339: ldc 105
    //   341: invokevirtual 109	android/graphics/Paint:setShadowLayer	(FFFI)V
    //   344: aload 15
    //   346: astore 16
    //   348: aload 15
    //   350: astore 17
    //   352: aload 20
    //   354: getstatic 115	android/graphics/Paint$Align:CENTER	Landroid/graphics/Paint$Align;
    //   357: invokevirtual 119	android/graphics/Paint:setTextAlign	(Landroid/graphics/Paint$Align;)V
    //   360: aload 15
    //   362: astore 16
    //   364: aload 15
    //   366: astore 17
    //   368: aload_0
    //   369: ldc 121
    //   371: invokevirtual 125	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   374: ifne +616 -> 990
    //   377: iload 14
    //   379: istore_2
    //   380: goto +3 -> 383
    //   383: aload 15
    //   385: astore 16
    //   387: aload 15
    //   389: astore 17
    //   391: new 127	android/graphics/Rect
    //   394: dup
    //   395: bipush 48
    //   397: sipush 144
    //   400: sipush 467
    //   403: sipush 246
    //   406: invokespecial 130	android/graphics/Rect:<init>	(IIII)V
    //   409: astore_1
    //   410: iload_2
    //   411: istore_3
    //   412: iload_2
    //   413: ifeq +65 -> 478
    //   416: aload 15
    //   418: astore 16
    //   420: aload 15
    //   422: astore 17
    //   424: new 127	android/graphics/Rect
    //   427: dup
    //   428: invokespecial 131	android/graphics/Rect:<init>	()V
    //   431: astore 5
    //   433: aload 15
    //   435: astore 16
    //   437: aload 15
    //   439: astore 17
    //   441: aload 20
    //   443: aload_0
    //   444: iconst_0
    //   445: aload_0
    //   446: invokevirtual 132	java/lang/String:length	()I
    //   449: aload 5
    //   451: invokevirtual 136	android/graphics/Paint:getTextBounds	(Ljava/lang/String;IILandroid/graphics/Rect;)V
    //   454: iload_2
    //   455: istore_3
    //   456: aload 15
    //   458: astore 16
    //   460: aload 15
    //   462: astore 17
    //   464: aload_1
    //   465: invokevirtual 139	android/graphics/Rect:width	()I
    //   468: aload 5
    //   470: invokevirtual 139	android/graphics/Rect:width	()I
    //   473: if_icmpgt +5 -> 478
    //   476: iconst_0
    //   477: istore_3
    //   478: iload_3
    //   479: ifeq +28 -> 507
    //   482: aload 15
    //   484: astore 16
    //   486: aload 15
    //   488: astore 17
    //   490: aload 19
    //   492: aload 20
    //   494: aload_1
    //   495: aload_0
    //   496: getstatic 115	android/graphics/Paint$Align:CENTER	Landroid/graphics/Paint$Align;
    //   499: bipush 48
    //   501: invokestatic 142	com/tencent/mobileqq/confess/ConfessShareHelper:a	(Landroid/graphics/Canvas;Landroid/graphics/Paint;Landroid/graphics/Rect;Ljava/lang/String;Landroid/graphics/Paint$Align;I)V
    //   504: goto +491 -> 995
    //   507: aload 15
    //   509: astore 16
    //   511: aload 15
    //   513: astore 17
    //   515: aload_0
    //   516: bipush 18
    //   518: invokestatic 145	com/tencent/mobileqq/confess/ConfessShareHelper:a	(Ljava/lang/String;I)Landroid/util/Pair;
    //   521: astore_0
    //   522: aload 15
    //   524: astore 16
    //   526: aload 15
    //   528: astore 17
    //   530: aload 19
    //   532: aload 20
    //   534: new 127	android/graphics/Rect
    //   537: dup
    //   538: bipush 48
    //   540: sipush 144
    //   543: sipush 467
    //   546: sipush 186
    //   549: invokespecial 130	android/graphics/Rect:<init>	(IIII)V
    //   552: aload_0
    //   553: getfield 151	android/util/Pair:first	Ljava/lang/Object;
    //   556: checkcast 10	java/lang/String
    //   559: getstatic 115	android/graphics/Paint$Align:CENTER	Landroid/graphics/Paint$Align;
    //   562: bipush 42
    //   564: invokestatic 142	com/tencent/mobileqq/confess/ConfessShareHelper:a	(Landroid/graphics/Canvas;Landroid/graphics/Paint;Landroid/graphics/Rect;Ljava/lang/String;Landroid/graphics/Paint$Align;I)V
    //   567: aload 15
    //   569: astore 16
    //   571: aload 15
    //   573: astore 17
    //   575: aload 19
    //   577: aload 20
    //   579: new 127	android/graphics/Rect
    //   582: dup
    //   583: bipush 48
    //   585: sipush 202
    //   588: sipush 467
    //   591: sipush 246
    //   594: invokespecial 130	android/graphics/Rect:<init>	(IIII)V
    //   597: aload_0
    //   598: getfield 154	android/util/Pair:second	Ljava/lang/Object;
    //   601: checkcast 10	java/lang/String
    //   604: getstatic 115	android/graphics/Paint$Align:CENTER	Landroid/graphics/Paint$Align;
    //   607: bipush 42
    //   609: invokestatic 142	com/tencent/mobileqq/confess/ConfessShareHelper:a	(Landroid/graphics/Canvas;Landroid/graphics/Paint;Landroid/graphics/Rect;Ljava/lang/String;Landroid/graphics/Paint$Align;I)V
    //   612: goto +383 -> 995
    //   615: aload 15
    //   617: astore 16
    //   619: aload 15
    //   621: astore 17
    //   623: aload 20
    //   625: iconst_0
    //   626: invokevirtual 104	android/graphics/Paint:setFakeBoldText	(Z)V
    //   629: goto +276 -> 905
    //   632: bipush 80
    //   634: istore 13
    //   636: iload 4
    //   638: iconst_1
    //   639: if_icmpne +15 -> 654
    //   642: bipush 100
    //   644: istore 13
    //   646: sipush 240
    //   649: istore 14
    //   651: goto +8 -> 659
    //   654: sipush 290
    //   657: istore 14
    //   659: aload 20
    //   661: iconst_m1
    //   662: invokevirtual 70	android/graphics/Paint:setColor	(I)V
    //   665: aload_0
    //   666: aload_1
    //   667: iload_2
    //   668: iload_3
    //   669: iload 4
    //   671: aload 5
    //   673: aload 6
    //   675: aload 7
    //   677: aload 8
    //   679: aload 9
    //   681: iload 12
    //   683: iload 11
    //   685: iload 13
    //   687: iload 14
    //   689: aload 21
    //   691: aload 19
    //   693: aload 20
    //   695: invokestatic 157	com/tencent/mobileqq/confess/ConfessShareHelper:a	(Lcom/tencent/common/app/AppInterface;Landroid/content/Context;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONArray;Lcom/tencent/mobileqq/armap/INonMainProcAvatarLoader;IIIILjava/lang/String;Landroid/graphics/Canvas;Landroid/graphics/Paint;)V
    //   698: aload 20
    //   700: sipush 255
    //   703: invokevirtual 160	android/graphics/Paint:setAlpha	(I)V
    //   706: aload 20
    //   708: iconst_m1
    //   709: invokevirtual 70	android/graphics/Paint:setColor	(I)V
    //   712: aload 20
    //   714: iconst_0
    //   715: invokevirtual 104	android/graphics/Paint:setFakeBoldText	(Z)V
    //   718: iload 12
    //   720: iconst_2
    //   721: idiv
    //   722: bipush 125
    //   724: isub
    //   725: i2f
    //   726: fstore 10
    //   728: iload 11
    //   730: sipush 164
    //   733: isub
    //   734: istore_2
    //   735: aload 19
    //   737: new 162	android/graphics/RectF
    //   740: dup
    //   741: fload 10
    //   743: iload_2
    //   744: sipush 250
    //   747: isub
    //   748: i2f
    //   749: iload 12
    //   751: iconst_2
    //   752: idiv
    //   753: bipush 125
    //   755: iadd
    //   756: i2f
    //   757: iload_2
    //   758: i2f
    //   759: invokespecial 165	android/graphics/RectF:<init>	(FFFF)V
    //   762: ldc 39
    //   764: ldc 39
    //   766: aload 20
    //   768: invokevirtual 169	android/graphics/Canvas:drawRoundRect	(Landroid/graphics/RectF;FFLandroid/graphics/Paint;)V
    //   771: iload 12
    //   773: iconst_2
    //   774: idiv
    //   775: istore_2
    //   776: iload 11
    //   778: sipush 173
    //   781: isub
    //   782: istore_3
    //   783: aload 7
    //   785: aload 19
    //   787: new 127	android/graphics/Rect
    //   790: dup
    //   791: iload_2
    //   792: bipush 116
    //   794: isub
    //   795: iload_3
    //   796: sipush 232
    //   799: isub
    //   800: iload 12
    //   802: iconst_2
    //   803: idiv
    //   804: bipush 116
    //   806: iadd
    //   807: iload_3
    //   808: invokespecial 130	android/graphics/Rect:<init>	(IIII)V
    //   811: invokestatic 172	com/tencent/mobileqq/confess/ConfessShareHelper:a	(Ljava/lang/String;Landroid/graphics/Canvas;Landroid/graphics/Rect;)V
    //   814: aload_1
    //   815: invokevirtual 178	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   818: ldc 179
    //   820: invokevirtual 185	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   823: astore_0
    //   824: iload 12
    //   826: iconst_2
    //   827: idiv
    //   828: istore_2
    //   829: iload 11
    //   831: bipush 102
    //   833: isub
    //   834: istore_3
    //   835: aload_0
    //   836: iload_2
    //   837: bipush 45
    //   839: isub
    //   840: iload_3
    //   841: bipush 42
    //   843: isub
    //   844: iload 12
    //   846: iconst_2
    //   847: idiv
    //   848: bipush 45
    //   850: iadd
    //   851: iload_3
    //   852: invokevirtual 190	android/graphics/drawable/Drawable:setBounds	(IIII)V
    //   855: aload_0
    //   856: aload 19
    //   858: invokevirtual 194	android/graphics/drawable/Drawable:draw	(Landroid/graphics/Canvas;)V
    //   861: ldc 195
    //   863: invokestatic 200	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   866: astore_0
    //   867: aload 20
    //   869: invokevirtual 203	android/graphics/Paint:clearShadowLayer	()V
    //   872: aload 19
    //   874: aload 20
    //   876: new 127	android/graphics/Rect
    //   879: dup
    //   880: iconst_0
    //   881: iload 11
    //   883: bipush 82
    //   885: isub
    //   886: iload 12
    //   888: iload 11
    //   890: bipush 54
    //   892: isub
    //   893: invokespecial 130	android/graphics/Rect:<init>	(IIII)V
    //   896: aload_0
    //   897: getstatic 115	android/graphics/Paint$Align:CENTER	Landroid/graphics/Paint$Align;
    //   900: bipush 28
    //   902: invokestatic 142	com/tencent/mobileqq/confess/ConfessShareHelper:a	(Landroid/graphics/Canvas;Landroid/graphics/Paint;Landroid/graphics/Rect;Ljava/lang/String;Landroid/graphics/Paint$Align;I)V
    //   905: aload 18
    //   907: areturn
    //   908: astore_0
    //   909: aload 15
    //   911: astore_1
    //   912: goto +28 -> 940
    //   915: astore_0
    //   916: aload 15
    //   918: astore_1
    //   919: goto +46 -> 965
    //   922: astore_0
    //   923: aload 15
    //   925: astore_1
    //   926: goto +14 -> 940
    //   929: astore_0
    //   930: aload 15
    //   932: astore_1
    //   933: goto +32 -> 965
    //   936: astore_0
    //   937: aload 16
    //   939: astore_1
    //   940: aload_1
    //   941: astore 15
    //   943: invokestatic 209	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   946: ifeq +41 -> 987
    //   949: ldc 211
    //   951: iconst_2
    //   952: aload_0
    //   953: invokevirtual 214	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   956: invokestatic 218	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   959: aload_1
    //   960: areturn
    //   961: astore_0
    //   962: aload 17
    //   964: astore_1
    //   965: aload_1
    //   966: astore 15
    //   968: invokestatic 209	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   971: ifeq +16 -> 987
    //   974: ldc 211
    //   976: iconst_2
    //   977: aload_0
    //   978: invokevirtual 219	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   981: invokestatic 218	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   984: aload_1
    //   985: astore 15
    //   987: aload 15
    //   989: areturn
    //   990: iconst_0
    //   991: istore_2
    //   992: goto -609 -> 383
    //   995: goto -380 -> 615
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	998	0	paramAppInterface	AppInterface
    //   0	998	1	paramContext	Context
    //   0	998	2	paramInt1	int
    //   0	998	3	paramInt2	int
    //   0	998	4	paramInt3	int
    //   0	998	5	paramString1	String
    //   0	998	6	paramString2	String
    //   0	998	7	paramString3	String
    //   0	998	8	paramJSONArray	JSONArray
    //   0	998	9	paramINonMainProcAvatarLoader	INonMainProcAvatarLoader
    //   726	16	10	f	float
    //   23	870	11	i	int
    //   125	762	12	j	int
    //   103	583	13	k	int
    //   26	662	14	m	int
    //   11	977	15	localObject1	Object
    //   7	931	16	localObject2	Object
    //   1	962	17	localObject3	Object
    //   4	902	18	localBitmap	Bitmap
    //   176	697	19	localCanvas	Canvas
    //   186	689	20	localPaint	Paint
    //   149	541	21	str	String
    // Exception table:
    //   from	to	target	type
    //   665	728	908	java/lang/Exception
    //   735	776	908	java/lang/Exception
    //   783	829	908	java/lang/Exception
    //   835	905	908	java/lang/Exception
    //   665	728	915	java/lang/OutOfMemoryError
    //   735	776	915	java/lang/OutOfMemoryError
    //   783	829	915	java/lang/OutOfMemoryError
    //   835	905	915	java/lang/OutOfMemoryError
    //   167	205	922	java/lang/Exception
    //   659	665	922	java/lang/Exception
    //   167	205	929	java/lang/OutOfMemoryError
    //   659	665	929	java/lang/OutOfMemoryError
    //   151	163	936	java/lang/Exception
    //   223	235	936	java/lang/Exception
    //   246	254	936	java/lang/Exception
    //   262	269	936	java/lang/Exception
    //   277	284	936	java/lang/Exception
    //   292	297	936	java/lang/Exception
    //   305	312	936	java/lang/Exception
    //   320	326	936	java/lang/Exception
    //   334	344	936	java/lang/Exception
    //   352	360	936	java/lang/Exception
    //   368	377	936	java/lang/Exception
    //   391	410	936	java/lang/Exception
    //   424	433	936	java/lang/Exception
    //   441	454	936	java/lang/Exception
    //   464	476	936	java/lang/Exception
    //   490	504	936	java/lang/Exception
    //   515	522	936	java/lang/Exception
    //   530	567	936	java/lang/Exception
    //   575	612	936	java/lang/Exception
    //   623	629	936	java/lang/Exception
    //   151	163	961	java/lang/OutOfMemoryError
    //   223	235	961	java/lang/OutOfMemoryError
    //   246	254	961	java/lang/OutOfMemoryError
    //   262	269	961	java/lang/OutOfMemoryError
    //   277	284	961	java/lang/OutOfMemoryError
    //   292	297	961	java/lang/OutOfMemoryError
    //   305	312	961	java/lang/OutOfMemoryError
    //   320	326	961	java/lang/OutOfMemoryError
    //   334	344	961	java/lang/OutOfMemoryError
    //   352	360	961	java/lang/OutOfMemoryError
    //   368	377	961	java/lang/OutOfMemoryError
    //   391	410	961	java/lang/OutOfMemoryError
    //   424	433	961	java/lang/OutOfMemoryError
    //   441	454	961	java/lang/OutOfMemoryError
    //   464	476	961	java/lang/OutOfMemoryError
    //   490	504	961	java/lang/OutOfMemoryError
    //   515	522	961	java/lang/OutOfMemoryError
    //   530	567	961	java/lang/OutOfMemoryError
    //   575	612	961	java/lang/OutOfMemoryError
    //   623	629	961	java/lang/OutOfMemoryError
  }
  
  public static Pair<String, String> a(String paramString, int paramInt)
  {
    String str4 = a(paramString, paramInt);
    boolean bool = str4.contains("\n");
    String str2 = "";
    if (bool)
    {
      paramString = str4.split("\n");
      if (paramString.length >= 2)
      {
        str2 = paramString[0];
        str3 = paramString[1];
        break label55;
      }
    }
    String str3 = "";
    label55:
    paramString = str2;
    String str1 = str3;
    if (TextUtils.isEmpty(str2))
    {
      paramString = str2;
      str1 = str3;
      if (TextUtils.isEmpty(str3))
      {
        paramInt = str4.length();
        int i;
        if (paramInt >= 16)
        {
          i = (paramInt + 1) / 2;
          paramString = str4.substring(0, i);
          str1 = str4.substring(i, paramInt);
        }
        else if (paramInt >= 12)
        {
          paramString = str4.substring(0, 8);
          str1 = str4.substring(8, paramInt);
        }
        else
        {
          i = paramInt * 6 / 10;
          paramString = str4.substring(0, i);
          str1 = str4.substring(i, paramInt);
        }
      }
    }
    return new Pair(paramString, str1);
  }
  
  /* Error */
  public static final String a(AppInterface paramAppInterface)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 244	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   4: astore 7
    //   6: aload_0
    //   7: invokevirtual 248	com/tencent/common/app/AppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   10: astore_0
    //   11: new 84	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   18: astore_1
    //   19: aload_1
    //   20: getstatic 254	mqq/app/Constants$PropertiesKey:nickName	Lmqq/app/Constants$PropertiesKey;
    //   23: invokevirtual 255	mqq/app/Constants$PropertiesKey:toString	()Ljava/lang/String;
    //   26: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: aload_1
    //   31: aload 7
    //   33: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: pop
    //   37: aload_0
    //   38: aload_1
    //   39: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: invokevirtual 260	mqq/app/MobileQQ:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   45: astore_3
    //   46: aload_3
    //   47: astore_0
    //   48: aload_3
    //   49: invokestatic 230	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   52: ifeq +406 -> 458
    //   55: invokestatic 266	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   58: invokevirtual 272	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   61: astore 6
    //   63: aconst_null
    //   64: astore 4
    //   66: aconst_null
    //   67: astore_0
    //   68: aload_0
    //   69: astore 5
    //   71: aload 4
    //   73: astore_2
    //   74: aload_3
    //   75: astore_1
    //   76: new 84	java/lang/StringBuilder
    //   79: dup
    //   80: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   83: astore 8
    //   85: aload_0
    //   86: astore 5
    //   88: aload 4
    //   90: astore_2
    //   91: aload_3
    //   92: astore_1
    //   93: aload 8
    //   95: ldc_w 274
    //   98: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: pop
    //   102: aload_0
    //   103: astore 5
    //   105: aload 4
    //   107: astore_2
    //   108: aload_3
    //   109: astore_1
    //   110: aload 8
    //   112: aload 7
    //   114: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: pop
    //   118: aload_0
    //   119: astore 5
    //   121: aload 4
    //   123: astore_2
    //   124: aload_3
    //   125: astore_1
    //   126: aload 6
    //   128: aload 8
    //   130: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   133: invokestatic 280	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   136: aconst_null
    //   137: ldc_w 282
    //   140: iconst_1
    //   141: anewarray 10	java/lang/String
    //   144: dup
    //   145: iconst_0
    //   146: aload 7
    //   148: aastore
    //   149: aconst_null
    //   150: invokevirtual 288	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   153: astore 6
    //   155: aload_3
    //   156: astore 4
    //   158: aload 6
    //   160: ifnull +189 -> 349
    //   163: aload_3
    //   164: astore 4
    //   166: aload 6
    //   168: astore 5
    //   170: aload 6
    //   172: astore_2
    //   173: aload_3
    //   174: astore_1
    //   175: aload 6
    //   177: invokeinterface 293 1 0
    //   182: ifeq +167 -> 349
    //   185: aload 6
    //   187: astore 5
    //   189: aload 6
    //   191: astore_2
    //   192: aload_3
    //   193: astore_1
    //   194: aload 6
    //   196: aload 6
    //   198: ldc_w 295
    //   201: invokeinterface 299 2 0
    //   206: invokeinterface 302 2 0
    //   211: astore 4
    //   213: aload_3
    //   214: astore_0
    //   215: aload 6
    //   217: astore 5
    //   219: aload 6
    //   221: astore_2
    //   222: aload_3
    //   223: astore_1
    //   224: aload 4
    //   226: invokestatic 230	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   229: ifne +31 -> 260
    //   232: aload 6
    //   234: astore 5
    //   236: aload 6
    //   238: astore_2
    //   239: aload_3
    //   240: astore_1
    //   241: new 10	java/lang/String
    //   244: dup
    //   245: aload 4
    //   247: invokevirtual 306	java/lang/String:getBytes	()[B
    //   250: ldc_w 308
    //   253: invokespecial 311	java/lang/String:<init>	([BLjava/lang/String;)V
    //   256: invokestatic 316	com/tencent/mobileqq/utils/SecurityUtile:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   259: astore_0
    //   260: aload_0
    //   261: astore 4
    //   263: aload 6
    //   265: astore 5
    //   267: aload 6
    //   269: astore_2
    //   270: aload_0
    //   271: astore_1
    //   272: invokestatic 209	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   275: ifeq +74 -> 349
    //   278: aload 6
    //   280: astore 5
    //   282: aload 6
    //   284: astore_2
    //   285: aload_0
    //   286: astore_1
    //   287: new 84	java/lang/StringBuilder
    //   290: dup
    //   291: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   294: astore_3
    //   295: aload 6
    //   297: astore 5
    //   299: aload 6
    //   301: astore_2
    //   302: aload_0
    //   303: astore_1
    //   304: aload_3
    //   305: ldc_w 318
    //   308: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: pop
    //   312: aload 6
    //   314: astore 5
    //   316: aload 6
    //   318: astore_2
    //   319: aload_0
    //   320: astore_1
    //   321: aload_3
    //   322: aload_0
    //   323: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: pop
    //   327: aload 6
    //   329: astore 5
    //   331: aload 6
    //   333: astore_2
    //   334: aload_0
    //   335: astore_1
    //   336: ldc 211
    //   338: iconst_2
    //   339: aload_3
    //   340: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   343: invokestatic 218	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   346: aload_0
    //   347: astore 4
    //   349: aload 4
    //   351: astore_0
    //   352: aload 6
    //   354: ifnull +104 -> 458
    //   357: aload 4
    //   359: astore_0
    //   360: aload 6
    //   362: astore_2
    //   363: aload_2
    //   364: invokeinterface 321 1 0
    //   369: goto +89 -> 458
    //   372: astore_0
    //   373: goto +71 -> 444
    //   376: astore_0
    //   377: aload_2
    //   378: astore 5
    //   380: invokestatic 209	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   383: ifeq +50 -> 433
    //   386: aload_2
    //   387: astore 5
    //   389: new 84	java/lang/StringBuilder
    //   392: dup
    //   393: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   396: astore_3
    //   397: aload_2
    //   398: astore 5
    //   400: aload_3
    //   401: ldc_w 323
    //   404: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: pop
    //   408: aload_2
    //   409: astore 5
    //   411: aload_3
    //   412: aload_0
    //   413: invokestatic 327	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   416: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   419: pop
    //   420: aload_2
    //   421: astore 5
    //   423: ldc 211
    //   425: iconst_2
    //   426: aload_3
    //   427: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   430: invokestatic 330	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   433: aload_1
    //   434: astore_0
    //   435: aload_2
    //   436: ifnull +22 -> 458
    //   439: aload_1
    //   440: astore_0
    //   441: goto -78 -> 363
    //   444: aload 5
    //   446: ifnull +10 -> 456
    //   449: aload 5
    //   451: invokeinterface 321 1 0
    //   456: aload_0
    //   457: athrow
    //   458: aload_0
    //   459: astore_1
    //   460: aload_0
    //   461: invokestatic 230	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   464: ifeq +6 -> 470
    //   467: aload 7
    //   469: astore_1
    //   470: invokestatic 209	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   473: ifeq +35 -> 508
    //   476: new 84	java/lang/StringBuilder
    //   479: dup
    //   480: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   483: astore_0
    //   484: aload_0
    //   485: ldc_w 332
    //   488: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   491: pop
    //   492: aload_0
    //   493: aload_1
    //   494: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   497: pop
    //   498: ldc 211
    //   500: iconst_2
    //   501: aload_0
    //   502: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   505: invokestatic 330	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   508: aload_1
    //   509: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	510	0	paramAppInterface	AppInterface
    //   18	491	1	localObject1	Object
    //   73	363	2	localObject2	Object
    //   45	382	3	localObject3	Object
    //   64	294	4	localObject4	Object
    //   69	381	5	localObject5	Object
    //   61	300	6	localObject6	Object
    //   4	464	7	str	String
    //   83	46	8	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   76	85	372	finally
    //   93	102	372	finally
    //   110	118	372	finally
    //   126	155	372	finally
    //   175	185	372	finally
    //   194	213	372	finally
    //   224	232	372	finally
    //   241	260	372	finally
    //   272	278	372	finally
    //   287	295	372	finally
    //   304	312	372	finally
    //   321	327	372	finally
    //   336	346	372	finally
    //   380	386	372	finally
    //   389	397	372	finally
    //   400	408	372	finally
    //   411	420	372	finally
    //   423	433	372	finally
    //   76	85	376	java/lang/Exception
    //   93	102	376	java/lang/Exception
    //   110	118	376	java/lang/Exception
    //   126	155	376	java/lang/Exception
    //   175	185	376	java/lang/Exception
    //   194	213	376	java/lang/Exception
    //   224	232	376	java/lang/Exception
    //   241	260	376	java/lang/Exception
    //   272	278	376	java/lang/Exception
    //   287	295	376	java/lang/Exception
    //   304	312	376	java/lang/Exception
    //   321	327	376	java/lang/Exception
    //   336	346	376	java/lang/Exception
  }
  
  public static String a(AppInterface paramAppInterface, Context paramContext, Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()) && (paramAppInterface != null))
    {
      if (paramContext == null) {
        return null;
      }
      try
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("temp_qrcode_share_");
        ((StringBuilder)localObject).append(System.currentTimeMillis());
        ((StringBuilder)localObject).append(paramAppInterface.getCurrentAccountUin());
        ((StringBuilder)localObject).append(".png");
        localObject = ((StringBuilder)localObject).toString();
        paramContext = QRUtils.a(paramContext, (String)localObject, paramBitmap);
        paramAppInterface = paramContext;
        if (QLog.isColorLevel())
        {
          paramAppInterface = new StringBuilder();
          paramAppInterface.append("filename = ");
          paramAppInterface.append((String)localObject);
          paramAppInterface.append("  path = ");
          paramAppInterface.append(paramContext);
          QLog.d("ConfessShareHelper", 2, paramAppInterface.toString());
          return paramContext;
        }
      }
      catch (OutOfMemoryError paramAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.i("ConfessShareHelper", 2, paramAppInterface.getMessage());
        }
        paramAppInterface = null;
      }
      return paramAppInterface;
    }
    return null;
  }
  
  public static String a(String paramString, float paramFloat)
  {
    Object localObject = paramString;
    if (TagUtils.a(paramString) > paramFloat)
    {
      int i = Math.max(0, (int)(paramFloat - 3.0F));
      int j = i;
      while (i < paramString.length())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString.substring(0, i));
        ((StringBuilder)localObject).append("…");
        if (TagUtils.a(((StringBuilder)localObject).toString()) > paramFloat) {
          break;
        }
        j = i;
        i += 1;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString.substring(0, j));
      ((StringBuilder)localObject).append("…");
      localObject = ((StringBuilder)localObject).toString();
    }
    return localObject;
  }
  
  public static String a(String paramString, AppInterface paramAppInterface)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = localObject3;
    String str1;
    if (paramAppInterface != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return null;
      }
      HashMap localHashMap1 = new HashMap();
      localHashMap1.put("Connection", "keep-alive");
      localHashMap1.put("Referer", "http://www.qq.com");
      localHashMap1.put("Host", "cgi.connect.qq.com");
      localObject1 = (TicketManager)paramAppInterface.getManager(2);
      String str2 = paramAppInterface.getCurrentAccountUin();
      String str3 = ((TicketManager)localObject1).getSkey(str2);
      paramAppInterface = ((TicketManager)localObject1).getPskey(str2, "cgi.connect.qq.com");
      if (!TextUtils.isEmpty(paramAppInterface))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("p_uin=");
        ((StringBuilder)localObject1).append(str2);
        ((StringBuilder)localObject1).append(";p_skey=");
        ((StringBuilder)localObject1).append(paramAppInterface);
        localHashMap1.put("Cookie", ((StringBuilder)localObject1).toString());
      }
      HashMap localHashMap2 = new HashMap();
      localHashMap2.put("share_image", paramString);
      localObject1 = HttpUtil.uploadImageWithHttps(NetworkUtil.a("https://cgi.connect.qq.com/qqconnectopen/upload_share_image", 1007), "cgi.connect.qq.com", str2, str3, null, localHashMap2, localHashMap1, false);
      paramAppInterface = (AppInterface)localObject1;
      if (localObject1 == null) {
        paramAppInterface = HttpUtil.uploadImageWithHttps("https://cgi.connect.qq.com/qqconnectopen/upload_share_image", "cgi.connect.qq.com", str2, str3, null, localHashMap2, localHashMap1, true);
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("urlResult = ");
        ((StringBuilder)localObject1).append(paramAppInterface);
        ((StringBuilder)localObject1).append("  filePath = ");
        ((StringBuilder)localObject1).append(paramString);
        QLog.d("ConfessShareHelper", 2, ((StringBuilder)localObject1).toString());
      }
      localObject1 = localObject3;
      if (paramAppInterface != null)
      {
        try
        {
          paramAppInterface = new JSONObject(paramAppInterface);
          localObject1 = localObject3;
          if (paramAppInterface.getInt("retcode") != 0) {
            return localObject1;
          }
          localObject1 = localObject3;
          if (!paramAppInterface.has("result")) {
            return localObject1;
          }
          paramAppInterface = paramAppInterface.getJSONObject("result").getString("url");
          try
          {
            if ((!TextUtils.isEmpty(paramAppInterface)) && (QLog.isColorLevel()))
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("filePath = ");
              ((StringBuilder)localObject1).append(paramString);
              ((StringBuilder)localObject1).append(" imageUrl=");
              ((StringBuilder)localObject1).append(paramAppInterface);
              QLog.d("ConfessShareHelper", 2, ((StringBuilder)localObject1).toString());
            }
            return paramAppInterface;
          }
          catch (JSONException localJSONException)
          {
            paramString = paramAppInterface;
            paramAppInterface = localJSONException;
          }
          str1 = paramString;
        }
        catch (JSONException paramAppInterface)
        {
          paramString = localObject2;
        }
        if (QLog.isColorLevel())
        {
          QLog.d("ConfessShareHelper", 2, paramAppInterface.getMessage());
          str1 = paramString;
        }
      }
    }
    return str1;
  }
  
  public static ArrayList<TagUtils.TagOriginal> a(JSONArray paramJSONArray)
  {
    ArrayList localArrayList = new ArrayList();
    int j = paramJSONArray.length();
    HashSet localHashSet = new HashSet();
    int i = 0;
    while (i < j)
    {
      String str = paramJSONArray.optJSONObject(i).optString("confess");
      if (!localHashSet.contains(str))
      {
        localHashSet.add(str);
        localArrayList.add(new TagUtils.TagOriginal(str));
        if (localArrayList.size() >= 10) {
          break;
        }
      }
      i += 1;
    }
    localHashSet.clear();
    return localArrayList;
  }
  
  public static void a(Canvas paramCanvas, Paint paramPaint, Rect paramRect, String paramString, Paint.Align paramAlign, int paramInt)
  {
    a(paramCanvas, paramPaint, paramRect, paramString, paramAlign, 0, paramInt);
  }
  
  public static void a(Canvas paramCanvas, Paint paramPaint, Rect paramRect, String paramString, Paint.Align paramAlign, int paramInt1, int paramInt2)
  {
    paramPaint.setTextSize(paramInt2);
    paramPaint.setTextAlign(paramAlign);
    Paint.FontMetricsInt localFontMetricsInt = paramPaint.getFontMetricsInt();
    int i = (paramRect.bottom + paramRect.top - localFontMetricsInt.bottom - localFontMetricsInt.top) / 2;
    if (paramInt1 == -1) {
      i = (paramRect.top + (paramInt2 + paramRect.top + paramRect.bottom) / 2 - localFontMetricsInt.bottom - localFontMetricsInt.top) / 2;
    } else if (paramInt1 == 1) {
      i = (paramRect.bottom + (paramRect.bottom - paramInt2 + paramRect.top) / 2 - localFontMetricsInt.bottom - localFontMetricsInt.top) / 2;
    }
    paramInt1 = paramRect.centerX();
    if (paramAlign == Paint.Align.LEFT) {
      paramInt1 = paramRect.left;
    } else if (paramAlign == Paint.Align.RIGHT) {
      paramInt1 = paramRect.right;
    }
    paramCanvas.drawText(paramString, paramInt1, i, paramPaint);
  }
  
  public static void a(AppInterface paramAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3, JSONArray paramJSONArray, INonMainProcAvatarLoader paramINonMainProcAvatarLoader, int paramInt4, int paramInt5, int paramInt6, int paramInt7, String paramString4, Canvas paramCanvas, Paint paramPaint)
  {
    paramInt2 = 1;
    if (paramInt3 == 0)
    {
      paramString1 = paramJSONArray.optJSONObject(0);
      paramInt1 = paramString1.optInt("anonymous_icon_type");
      paramAppInterface = paramString1.optString("confess");
      paramString1 = paramString1.optString("anonymous_name");
      paramContext = paramContext.getResources();
      if (paramInt1 == 0) {
        paramInt1 = 2130844976;
      } else {
        paramInt1 = 2130844977;
      }
      paramContext = paramContext.getDrawable(paramInt1);
      paramContext.setBounds(paramInt6, paramInt7, paramInt6 + 48, paramInt7 + 48);
      paramContext.draw(paramCanvas);
      paramPaint.setShadowLayer(4.0F, 0.0F, 2.0F, -7829368);
      paramPaint.setAntiAlias(true);
      paramPaint.setFakeBoldText(false);
      paramContext = a(paramString1, 15.0F);
      paramInt3 = paramInt4 - paramInt6;
      a(paramCanvas, paramPaint, new Rect(paramInt6 + 60, paramInt7 + 6, paramInt3, paramInt7 + 42), paramContext, Paint.Align.LEFT, 36);
      paramPaint.setFakeBoldText(true);
      a(paramCanvas, paramPaint, new Rect(paramInt6, paramInt7 + 174, paramInt3, paramInt7 + 246), paramString4, Paint.Align.CENTER, 72);
      paramPaint.setTextSize(72.0F);
      paramInt2 = paramAppInterface.contains("\n") ^ true;
      paramInt4 = paramInt7 + 288;
      paramInt5 = paramInt7 + 360;
      paramContext = new Rect(paramInt6, paramInt4, paramInt3, paramInt5);
      paramInt1 = paramInt2;
      if (paramInt2 != 0)
      {
        paramString1 = new Rect();
        paramPaint.getTextBounds(paramAppInterface, 0, paramAppInterface.length(), paramString1);
        paramInt1 = paramInt2;
        if (paramContext.width() <= paramString1.width()) {
          paramInt1 = 0;
        }
      }
      if (paramInt1 != 0)
      {
        a(paramCanvas, paramPaint, paramContext, paramAppInterface, Paint.Align.CENTER, 72);
      }
      else
      {
        paramAppInterface = a(paramAppInterface, 18);
        a(paramCanvas, paramPaint, new Rect(paramInt6, paramInt4, paramInt3, paramInt5), (String)paramAppInterface.first, Paint.Align.CENTER, 72);
        a(paramCanvas, paramPaint, new Rect(paramInt6, paramInt7 + 388, paramInt3, paramInt7 + 460), (String)paramAppInterface.second, Paint.Align.CENTER, 72);
      }
      paramPaint.setFakeBoldText(false);
      return;
    }
    paramString1 = a(paramJSONArray);
    paramString3 = new Rect(0, 0, 550, 550);
    paramString2 = new Rect(paramString3.centerX() - 66, paramString3.centerY() - 66, paramString3.centerX() + 66, paramString3.centerY() + 66);
    Object localObject1 = new TagUtils.TagArrangementEngine();
    Object localObject2 = new ArrayList();
    ((ArrayList)localObject2).add(paramString2);
    paramString2 = ((TagUtils.TagArrangementEngine)localObject1).a(paramString1, paramString3, (ArrayList)localObject2);
    paramString1 = paramString2;
    Object localObject3;
    if (((TagUtils.TagArrangementEngine)localObject1).b.size() > 1)
    {
      paramString1 = ((TagUtils.TagArrangementEngine)localObject1).b.iterator();
      paramInt1 = 0;
      while (paramString1.hasNext())
      {
        localObject3 = (Rect)paramString1.next();
        paramInt3 = ((Rect)localObject3).width();
        paramInt3 = ((Rect)localObject3).height() * paramInt3;
        if (paramInt3 > paramInt1) {
          paramInt1 = paramInt3;
        }
      }
      paramString1 = paramString2;
      if (paramInt1 > 1152) {
        paramString1 = ((TagUtils.TagArrangementEngine)localObject1).a(a(paramJSONArray), paramString3, (ArrayList)localObject2);
      }
    }
    paramInt3 = paramInt4 / 2;
    paramString2 = new Rect(paramInt3 - 275, paramInt7, paramInt3 + 275, 550 + paramInt7);
    paramString3 = new Rect();
    paramPaint.clearShadowLayer();
    paramPaint.setAntiAlias(true);
    paramJSONArray = paramString1.iterator();
    if (paramJSONArray.hasNext())
    {
      localObject1 = (TagUtils.Tag)paramJSONArray.next();
      localObject2 = ((TagUtils.Tag)localObject1).jdField_a_of_type_JavaUtilArrayList.iterator();
      for (paramInt1 = paramInt2;; paramInt1 = 1)
      {
        paramInt2 = paramInt1;
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localObject3 = (TagUtils.Tag.Child)((Iterator)localObject2).next();
        paramString3.left = (((TagUtils.Tag.Child)localObject3).jdField_a_of_type_AndroidGraphicsRect.left + paramString2.left + paramInt1);
        paramString3.top = (((TagUtils.Tag.Child)localObject3).jdField_a_of_type_AndroidGraphicsRect.top + paramString2.top + paramInt1);
        paramString3.right = (((TagUtils.Tag.Child)localObject3).jdField_a_of_type_AndroidGraphicsRect.right + paramString2.left - 2);
        paramString3.bottom = (((TagUtils.Tag.Child)localObject3).jdField_a_of_type_AndroidGraphicsRect.bottom + paramString2.top - 2);
        paramPaint.setColor(((TagUtils.Tag)localObject1).jdField_a_of_type_Int);
        if (((TagUtils.Tag)localObject1).jdField_b_of_type_Boolean) {
          paramInt2 = 178;
        } else {
          paramInt2 = 255;
        }
        paramPaint.setAlpha(paramInt2);
        paramPaint.setFakeBoldText(((TagUtils.Tag)localObject1).jdField_a_of_type_Boolean);
        paramString1 = Paint.Align.CENTER;
        if (((TagUtils.Tag)localObject1).c == -1) {
          paramString1 = Paint.Align.LEFT;
        } else if (((TagUtils.Tag)localObject1).c == paramInt1) {
          paramString1 = Paint.Align.RIGHT;
        }
        a(paramCanvas, paramPaint, paramString3, ((TagUtils.Tag.Child)localObject3).jdField_a_of_type_JavaLangString, paramString1, ((TagUtils.Tag)localObject1).d, ((TagUtils.Tag)localObject1).jdField_b_of_type_Int);
      }
    }
    paramPaint.setFakeBoldText(false);
    paramPaint.setColor(-1);
    paramPaint.setAlpha(178);
    paramCanvas.drawCircle(paramString2.centerX(), paramString2.centerY(), 54.0F, paramPaint);
    paramPaint.setAlpha(255);
    if (paramINonMainProcAvatarLoader != null)
    {
      paramAppInterface = paramINonMainProcAvatarLoader.a(paramAppInterface.getCurrentAccountUin(), true);
      paramContext = new StringBuilder();
      paramContext.append("preLoadQQSelfHeaderBitmap ");
      paramContext.append(paramAppInterface);
      QLog.i("ConfessShareHelper", 4, paramContext.toString());
      paramAppInterface = new BitmapDrawable(paramAppInterface);
    }
    else
    {
      paramAppInterface = paramContext.getResources().getDrawable(2130844994);
    }
    paramAppInterface.setBounds(paramString2.centerX() - 50, paramString2.centerY() - 50, paramString2.centerX() + 50, paramString2.centerY() + 50);
    paramAppInterface.draw(paramCanvas);
    paramPaint.setTextSize(24.0F);
    paramAppInterface = new Rect();
    paramContext = new StringBuilder();
    paramContext.append(a(paramString4, 8.0F));
    paramContext.append(HardCodeUtil.a(2131702605));
    paramContext = paramContext.toString();
    paramPaint.getTextBounds(paramContext, 0, paramContext.length(), paramAppInterface);
    paramPaint.setStrokeWidth(1.0F);
    paramPaint.setAlpha(128);
    paramCanvas.drawLine(paramString2.left + 6, paramString2.bottom + 38, paramInt3 - paramAppInterface.width() / 2 - 12, paramString2.bottom + 38, paramPaint);
    paramCanvas.drawLine(paramInt3 + paramAppInterface.width() / 2 + 12, paramString2.bottom + 38, paramString2.right - 6, paramString2.bottom + 38, paramPaint);
    paramPaint.setAlpha(255);
    paramPaint.setStrokeWidth(0.0F);
    a(paramCanvas, paramPaint, new Rect(paramString2.left, paramString2.bottom + 26, paramString2.right, paramString2.bottom + 50), paramContext, Paint.Align.CENTER, 24);
  }
  
  public static final void a(String paramString, Canvas paramCanvas, Rect paramRect)
  {
    int m;
    int i;
    int j;
    int k;
    try
    {
      localObject = QRUtils.a(paramString, -1);
      m = ((BitMatrix)localObject).a();
      paramString = new int[m * m];
      i = 0;
    }
    catch (Exception paramString)
    {
      Object localObject;
      if (!QLog.isColorLevel()) {
        break label180;
      }
      paramCanvas = new StringBuilder();
      paramCanvas.append("drawQRBitmap e:");
      paramCanvas.append(paramString.getMessage());
      QLog.i("ConfessShareHelper", 2, paramCanvas.toString());
      return;
    }
    catch (OutOfMemoryError paramString)
    {
      if (!QLog.isColorLevel()) {
        break label180;
      }
      paramCanvas = new StringBuilder();
      paramCanvas.append("drawQRBitmap e:");
      paramCanvas.append(paramString.getMessage());
      QLog.i("ConfessShareHelper", 2, paramCanvas.toString());
    }
    if (j < m) {
      if (((BitMatrix)localObject).a(j, i)) {
        k = -16777216;
      }
    }
    label180:
    label221:
    for (;;)
    {
      localObject = Bitmap.createBitmap(m, m, Bitmap.Config.ARGB_8888);
      ((Bitmap)localObject).setPixels(paramString, 0, m, 0, 0, m, m);
      paramCanvas.drawBitmap((Bitmap)localObject, null, paramRect, null);
      ((Bitmap)localObject).recycle();
      return;
      return;
      for (;;)
      {
        if (i >= m) {
          break label221;
        }
        j = 0;
        break;
        k = -1;
        paramString[(i * m + j)] = k;
        j += 1;
        break;
        i += 1;
      }
    }
  }
  
  public static boolean a(Context paramContext, Canvas paramCanvas, int paramInt1, int paramInt2, float paramFloat)
  {
    int i = Color.parseColor(a[paramInt1]);
    paramCanvas.drawColor(i);
    float f1 = paramContext.getResources().getDisplayMetrics().density;
    if (f1 > 0.05F) {
      f1 = 2.0F / f1;
    } else {
      f1 = 1.0F;
    }
    ConfessShareHelper.BgElement[] arrayOfBgElement = a(paramInt2, paramInt1);
    paramInt2 = arrayOfBgElement.length;
    paramInt1 = 0;
    ConfessShareHelper.BgElement localBgElement;
    if (paramInt1 < paramInt2) {
      localBgElement = arrayOfBgElement[paramInt1];
    }
    for (;;)
    {
      try
      {
        localObject2 = paramContext.getResources().getDrawable(localBgElement.jdField_a_of_type_Int);
        if (localBgElement.jdField_a_of_type_Int == 2130845003) {
          break label335;
        }
        if (localBgElement.jdField_a_of_type_Int != 2130844996) {
          break label328;
        }
      }
      catch (Exception localException)
      {
        int k;
        int j;
        float f4;
        float f3;
        float f5;
        Object localObject1;
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(" drawConfessShareBitmapBG e: ");
        ((StringBuilder)localObject2).append(localException.getMessage());
        QLog.e("ConfessShareHelper", 1, ((StringBuilder)localObject2).toString());
      }
      k = ((Drawable)localObject2).getIntrinsicWidth();
      j = ((Drawable)localObject2).getIntrinsicHeight();
      f4 = localBgElement.jdField_b_of_type_Int;
      f3 = k;
      k = (int)(f4 - localBgElement.jdField_a_of_type_Float * f3 * f1 / 2.0F);
      f4 = localBgElement.c;
      f5 = j;
      ((Drawable)localObject2).setBounds(k, (int)(f4 * localObject1 - localBgElement.jdField_a_of_type_Float * f5 * f1 / 2.0F), (int)(localBgElement.jdField_b_of_type_Int + f3 * localBgElement.jdField_a_of_type_Float * f1 / 2.0F), (int)(localBgElement.c * localObject1 + f5 * localBgElement.jdField_a_of_type_Float * f1 / 2.0F));
      if (localBgElement.jdField_a_of_type_Boolean)
      {
        ((Drawable)localObject2).setAlpha(77);
        ((Drawable)localObject2).setColorFilter(i, PorterDuff.Mode.MULTIPLY);
      }
      ((Drawable)localObject2).draw(paramCanvas);
      paramInt1 += 1;
      break;
      return true;
      label328:
      float f2 = paramFloat;
      continue;
      label335:
      f2 = 1.0F;
    }
  }
  
  public static ConfessShareHelper.BgElement[] a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0)
    {
      if (paramInt2 != 0)
      {
        if (paramInt2 != 1)
        {
          if (paramInt2 != 2)
          {
            if (paramInt2 == 3) {
              return new ConfessShareHelper.BgElement[] { new ConfessShareHelper.BgElement(2130844974, 138, 88, true, 0.75F), new ConfessShareHelper.BgElement(2130844968, 68, 232, true, 0.75F), new ConfessShareHelper.BgElement(2130844972, 298, 206, true, 0.75F), new ConfessShareHelper.BgElement(2130844975, 480, 140, true, 0.75F), new ConfessShareHelper.BgElement(2130845004, 382, 140, true, 0.75F), new ConfessShareHelper.BgElement(2130844999, 60, 90, true, 0.75F), new ConfessShareHelper.BgElement(2130844997, 182, 64, true, 0.75F), new ConfessShareHelper.BgElement(2130844997, 440, 210, true, 0.75F), new ConfessShareHelper.BgElement(2130844999, 440, 30, true, 0.75F), new ConfessShareHelper.BgElement(2130844999, 190, 200, true, 0.75F), new ConfessShareHelper.BgElement(2130844996, 257, 82, false, 1.0F) };
            }
          }
          else {
            return new ConfessShareHelper.BgElement[] { new ConfessShareHelper.BgElement(2130844968, 174, 58, true, 0.75F), new ConfessShareHelper.BgElement(2130844970, 70, 146, true, 0.75F), new ConfessShareHelper.BgElement(2130844972, 390, 106, true, 0.75F), new ConfessShareHelper.BgElement(2130844967, 206, 240, true, 0.75F), new ConfessShareHelper.BgElement(2130844969, 470, 225, true, 0.75F), new ConfessShareHelper.BgElement(2130845000, 120, 88, true, 0.75F), new ConfessShareHelper.BgElement(2130845000, 480, 70, true, 0.75F), new ConfessShareHelper.BgElement(2130844997, 110, 230, true, 0.75F), new ConfessShareHelper.BgElement(2130844999, 340, 210, true, 0.75F), new ConfessShareHelper.BgElement(2130844996, 257, 82, false, 1.0F) };
          }
        }
        else {
          return new ConfessShareHelper.BgElement[] { new ConfessShareHelper.BgElement(2130844975, 60, 88, true, 0.75F), new ConfessShareHelper.BgElement(2130844967, 226, 56, true, 0.75F), new ConfessShareHelper.BgElement(2130844974, 480, 140, true, 0.75F), new ConfessShareHelper.BgElement(2130844972, 330, 198, true, 0.75F), new ConfessShareHelper.BgElement(2130844973, 168, 244, true, 0.75F), new ConfessShareHelper.BgElement(2130844999, 300, 50, true, 0.75F), new ConfessShareHelper.BgElement(2130845000, 460, 50, true, 0.75F), new ConfessShareHelper.BgElement(2130844997, 60, 230, true, 0.75F), new ConfessShareHelper.BgElement(2130844999, 120, 120, true, 0.75F), new ConfessShareHelper.BgElement(2130844999, 440, 270, true, 0.75F), new ConfessShareHelper.BgElement(2130844996, 257, 82, false, 1.0F) };
        }
      }
      else {
        return new ConfessShareHelper.BgElement[] { new ConfessShareHelper.BgElement(2130844968, 60, 60, true, 0.75F), new ConfessShareHelper.BgElement(2130844973, 458, 84, true, 0.75F), new ConfessShareHelper.BgElement(2130844974, 142, 250, true, 0.75F), new ConfessShareHelper.BgElement(2130844968, 368, 188, true, 0.75F), new ConfessShareHelper.BgElement(2130844966, 168, 120, true, 0.75F), new ConfessShareHelper.BgElement(2130844999, 120, 40, true, 0.75F), new ConfessShareHelper.BgElement(2130845000, 120, 110, true, 0.75F), new ConfessShareHelper.BgElement(2130844997, 30, 150, true, 0.75F), new ConfessShareHelper.BgElement(2130844997, 180, 200, true, 0.75F), new ConfessShareHelper.BgElement(2130844999, 420, 160, true, 0.75F), new ConfessShareHelper.BgElement(2130845000, 495, 150, true, 0.75F), new ConfessShareHelper.BgElement(2130844996, 257, 82, false, 1.0F) };
      }
    }
    else if (paramInt1 == 1)
    {
      if (paramInt2 != 0)
      {
        if (paramInt2 != 1)
        {
          if (paramInt2 != 2)
          {
            if (paramInt2 == 3) {
              return new ConfessShareHelper.BgElement[] { new ConfessShareHelper.BgElement(2130844968, 104, 278, true, 1.0F), new ConfessShareHelper.BgElement(2130844971, 588, 200, true, 1.0F), new ConfessShareHelper.BgElement(2130844967, 690, 390, true, 1.0F), new ConfessShareHelper.BgElement(2130844970, 420, 534, true, 1.0F), new ConfessShareHelper.BgElement(2130844969, 92, 592, true, 1.0F), new ConfessShareHelper.BgElement(2130844973, 660, 624, true, 1.0F), new ConfessShareHelper.BgElement(2130844968, 475, 735, true, 1.0F), new ConfessShareHelper.BgElement(2130844974, 192, 818, true, 1.0F), new ConfessShareHelper.BgElement(2130844975, 696, 880, true, 1.0F), new ConfessShareHelper.BgElement(2130844972, 430, 990, true, 1.0F), new ConfessShareHelper.BgElement(2130844967, 64, 1034, true, 1.0F), new ConfessShareHelper.BgElement(2130844967, 272, 1250, true, 1.0F), new ConfessShareHelper.BgElement(2130844971, 584, 1205, true, 1.0F), new ConfessShareHelper.BgElement(2130844966, 254, 638, true, 1.0F), new ConfessShareHelper.BgElement(2130844997, 200, 320, true, 1.0F), new ConfessShareHelper.BgElement(2130844997, 260, 780, true, 1.0F), new ConfessShareHelper.BgElement(2130844997, 620, 1000, true, 1.0F), new ConfessShareHelper.BgElement(2130844997, 150, 1250, true, 1.0F), new ConfessShareHelper.BgElement(2130844998, 70, 420, true, 1.0F), new ConfessShareHelper.BgElement(2130844998, 460, 590, true, 1.0F), new ConfessShareHelper.BgElement(2130844998, 630, 450, true, 1.0F), new ConfessShareHelper.BgElement(2130844999, 70, 800, true, 1.0F), new ConfessShareHelper.BgElement(2130844999, 280, 980, true, 1.0F), new ConfessShareHelper.BgElement(2130844999, 610, 720, true, 1.0F), new ConfessShareHelper.BgElement(2130844999, 480, 1220, true, 1.0F), new ConfessShareHelper.BgElement(2130845000, 170, 590, true, 1.0F), new ConfessShareHelper.BgElement(2130845000, 330, 1160, true, 1.0F), new ConfessShareHelper.BgElement(2130845000, 700, 680, true, 1.0F), new ConfessShareHelper.BgElement(2130845000, 660, 290, true, 1.0F), new ConfessShareHelper.BgElement(2130845003, 375, 134, false, 1.0F) };
            }
          }
          else {
            return new ConfessShareHelper.BgElement[] { new ConfessShareHelper.BgElement(2130844968, 110, 220, true, 1.0F), new ConfessShareHelper.BgElement(2130844974, 654, 240, true, 1.0F), new ConfessShareHelper.BgElement(2130844972, 562, 482, true, 1.0F), new ConfessShareHelper.BgElement(2130844970, 95, 537, true, 1.0F), new ConfessShareHelper.BgElement(2130844967, 295, 672, true, 1.0F), new ConfessShareHelper.BgElement(2130844969, 683, 660, true, 1.0F), new ConfessShareHelper.BgElement(2130844971, 60, 850, true, 1.0F), new ConfessShareHelper.BgElement(2130844973, 442, 872, true, 1.0F), new ConfessShareHelper.BgElement(2130844967, 114, 1046, true, 1.0F), new ConfessShareHelper.BgElement(2130844968, 680, 950, true, 1.0F), new ConfessShareHelper.BgElement(2130844973, 230, 1197, true, 1.0F), new ConfessShareHelper.BgElement(2130844975, 480, 1260, true, 1.0F), new ConfessShareHelper.BgElement(2130845004, 670, 1200, true, 1.0F), new ConfessShareHelper.BgElement(2130844997, 140, 630, true, 1.0F), new ConfessShareHelper.BgElement(2130844997, 500, 960, true, 1.0F), new ConfessShareHelper.BgElement(2130844997, 330, 1050, true, 1.0F), new ConfessShareHelper.BgElement(2130844997, 50, 1150, true, 1.0F), new ConfessShareHelper.BgElement(2130844998, 290, 430, true, 1.0F), new ConfessShareHelper.BgElement(2130844998, 330, 760, true, 1.0F), new ConfessShareHelper.BgElement(2130844999, 60, 310, true, 1.0F), new ConfessShareHelper.BgElement(2130844999, 480, 580, true, 1.0F), new ConfessShareHelper.BgElement(2130844999, 220, 820, true, 1.0F), new ConfessShareHelper.BgElement(2130845000, 600, 150, true, 1.0F), new ConfessShareHelper.BgElement(2130845000, 700, 410, true, 1.0F), new ConfessShareHelper.BgElement(2130845000, 25, 900, true, 1.0F), new ConfessShareHelper.BgElement(2130845000, 150, 430, true, 1.0F), new ConfessShareHelper.BgElement(2130845003, 375, 134, false, 1.0F) };
          }
        }
        else {
          return new ConfessShareHelper.BgElement[] { new ConfessShareHelper.BgElement(2130844972, 110, 368, true, 1.0F), new ConfessShareHelper.BgElement(2130844973, 570, 256, true, 1.0F), new ConfessShareHelper.BgElement(2130844968, 655, 475, true, 1.0F), new ConfessShareHelper.BgElement(2130844975, 75, 740, true, 1.0F), new ConfessShareHelper.BgElement(2130844967, 320, 686, true, 1.0F), new ConfessShareHelper.BgElement(2130844974, 670, 832, true, 1.0F), new ConfessShareHelper.BgElement(2130844972, 505, 955, true, 1.0F), new ConfessShareHelper.BgElement(2130844973, 260, 1020, true, 1.0F), new ConfessShareHelper.BgElement(2130844971, 75, 1216, true, 1.0F), new ConfessShareHelper.BgElement(2130844967, 565, 1235, true, 1.0F), new ConfessShareHelper.BgElement(2130845004, 430, 355, true, 1.0F), new ConfessShareHelper.BgElement(2130844966, 110, 174, true, 1.0F), new ConfessShareHelper.BgElement(2130844997, 140, 250, true, 1.0F), new ConfessShareHelper.BgElement(2130845000, 640, 195, true, 1.0F), new ConfessShareHelper.BgElement(2130844997, 170, 450, true, 1.0F), new ConfessShareHelper.BgElement(2130844999, 490, 1220, true, 1.0F), new ConfessShareHelper.BgElement(2130844998, 350, 520, true, 1.0F), new ConfessShareHelper.BgElement(2130844998, 630, 410, true, 1.0F), new ConfessShareHelper.BgElement(2130845000, 60, 500, true, 1.0F), new ConfessShareHelper.BgElement(2130845000, 680, 655, true, 1.0F), new ConfessShareHelper.BgElement(2130845000, 310, 1110, true, 1.0F), new ConfessShareHelper.BgElement(2130844999, 470, 660, true, 1.0F), new ConfessShareHelper.BgElement(2130844999, 190, 780, true, 1.0F), new ConfessShareHelper.BgElement(2130844999, 680, 1060, true, 1.0F), new ConfessShareHelper.BgElement(2130844997, 180, 1230, true, 1.0F), new ConfessShareHelper.BgElement(2130845003, 375, 134, false, 1.0F) };
        }
      }
      else {
        return new ConfessShareHelper.BgElement[] { new ConfessShareHelper.BgElement(2130844969, 110, 230, true, 1.0F), new ConfessShareHelper.BgElement(2130844972, 656, 170, true, 1.0F), new ConfessShareHelper.BgElement(2130844967, 516, 350, true, 1.0F), new ConfessShareHelper.BgElement(2130844968, 84, 550, true, 1.0F), new ConfessShareHelper.BgElement(2130844973, 656, 586, true, 1.0F), new ConfessShareHelper.BgElement(2130844968, 526, 735, true, 1.0F), new ConfessShareHelper.BgElement(2130844974, 198, 830, true, 1.0F), new ConfessShareHelper.BgElement(2130844970, 70, 1016, true, 1.0F), new ConfessShareHelper.BgElement(2130844972, 397, 952, true, 1.0F), new ConfessShareHelper.BgElement(2130844975, 670, 880, true, 1.0F), new ConfessShareHelper.BgElement(2130844967, 220, 1257, true, 1.0F), new ConfessShareHelper.BgElement(2130844971, 606, 1220, true, 1.0F), new ConfessShareHelper.BgElement(2130845004, 452, 475, true, 1.0F), new ConfessShareHelper.BgElement(2130844966, 240, 645, true, 1.0F), new ConfessShareHelper.BgElement(2130844997, 160, 300, true, 1.0F), new ConfessShareHelper.BgElement(2130845000, 660, 330, true, 1.0F), new ConfessShareHelper.BgElement(2130844998, 620, 450, true, 1.0F), new ConfessShareHelper.BgElement(2130844999, 175, 500, true, 1.0F), new ConfessShareHelper.BgElement(2130844999, 460, 570, true, 1.0F), new ConfessShareHelper.BgElement(2130845000, 180, 630, true, 1.0F), new ConfessShareHelper.BgElement(2130844997, 40, 690, true, 1.0F), new ConfessShareHelper.BgElement(2130844997, 260, 750, true, 1.0F), new ConfessShareHelper.BgElement(2130845000, 710, 600, true, 1.0F), new ConfessShareHelper.BgElement(2130844999, 600, 710, true, 1.0F), new ConfessShareHelper.BgElement(2130844999, 140, 970, true, 1.0F), new ConfessShareHelper.BgElement(2130844997, 85, 1200, true, 1.0F), new ConfessShareHelper.BgElement(2130844997, 600, 1050, true, 1.0F), new ConfessShareHelper.BgElement(2130845000, 420, 1100, true, 1.0F), new ConfessShareHelper.BgElement(2130844999, 540, 1250, true, 1.0F), new ConfessShareHelper.BgElement(2130845003, 375, 134, false, 1.0F) };
      }
    }
    else if (paramInt1 == 2) {
      return new ConfessShareHelper.BgElement[] { new ConfessShareHelper.BgElement(2130844969, 110, 310, true, 1.0F), new ConfessShareHelper.BgElement(2130844972, 650, 216, true, 1.0F), new ConfessShareHelper.BgElement(2130844967, 516, 350, true, 1.0F), new ConfessShareHelper.BgElement(2130844969, 92, 592, true, 1.0F), new ConfessShareHelper.BgElement(2130844973, 656, 586, true, 1.0F), new ConfessShareHelper.BgElement(2130844968, 470, 716, true, 1.0F), new ConfessShareHelper.BgElement(2130844974, 198, 830, true, 1.0F), new ConfessShareHelper.BgElement(2130844975, 670, 980, true, 1.0F), new ConfessShareHelper.BgElement(2130844972, 397, 1060, true, 1.0F), new ConfessShareHelper.BgElement(2130844970, 70, 1016, true, 1.0F), new ConfessShareHelper.BgElement(2130844997, 200, 320, true, 1.0F), new ConfessShareHelper.BgElement(2130844966, 240, 438, true, 1.0F), new ConfessShareHelper.BgElement(2130845004, 452, 475, true, 0.75F), new ConfessShareHelper.BgElement(2130844997, 200, 600, true, 1.0F), new ConfessShareHelper.BgElement(2130844997, 1000, 620, true, 1.0F), new ConfessShareHelper.BgElement(2130844998, 70, 420, true, 1.0F) };
    }
    return new ConfessShareHelper.BgElement[0];
  }
  
  public static Bitmap b(AppInterface paramAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3, JSONArray paramJSONArray, INonMainProcAvatarLoader paramINonMainProcAvatarLoader)
  {
    if ((paramJSONArray != null) && (paramJSONArray.length() >= 1) && (paramContext != null))
    {
      if ((paramInt3 >= 0) && (paramInt3 < 2)) {
        break label41;
      }
      paramInt3 = 0;
      label41:
      int i;
      int j;
      if (paramInt3 == 1)
      {
        i = 560;
        j = 612;
      }
      else
      {
        i = 600;
        j = 470;
      }
      String str = a(a(paramAppInterface), 8.0F);
      try
      {
        paramString1 = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
        try
        {
          Canvas localCanvas = new Canvas(paramString1);
          Paint localPaint = new Paint(1);
          localPaint.setColor(-1);
          try
          {
            a(paramAppInterface, paramContext, paramInt1, paramInt2, paramInt3, null, paramString2, paramString3, paramJSONArray, paramINonMainProcAvatarLoader, i, j, 5, 5, str, localCanvas, localPaint);
            localPaint.setAlpha(255);
            localPaint.setColor(-1);
            return paramString1;
          }
          catch (Exception paramAppInterface) {}catch (OutOfMemoryError paramAppInterface) {}
          paramContext = paramString1;
        }
        catch (Exception paramAppInterface)
        {
          paramContext = paramString1;
          paramString1 = paramAppInterface;
          paramAppInterface = paramContext;
        }
        catch (OutOfMemoryError paramAppInterface) {}
        paramString1 = paramAppInterface;
        paramAppInterface = paramContext;
      }
      catch (Exception paramString1)
      {
        paramAppInterface = null;
        paramContext = paramAppInterface;
        if (!QLog.isColorLevel()) {
          break label249;
        }
        QLog.i("ConfessShareHelper", 2, paramString1.getMessage());
        return paramAppInterface;
      }
      catch (OutOfMemoryError paramString1)
      {
        paramAppInterface = null;
      }
      paramContext = paramAppInterface;
      if (QLog.isColorLevel())
      {
        QLog.i("ConfessShareHelper", 2, paramString1.getMessage());
        paramContext = paramAppInterface;
      }
      label249:
      return paramContext;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.confess.ConfessShareHelper
 * JD-Core Version:    0.7.0.1
 */