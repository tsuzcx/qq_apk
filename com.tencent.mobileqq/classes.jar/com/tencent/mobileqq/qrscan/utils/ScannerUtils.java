package com.tencent.mobileqq.qrscan.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import com.dataline.util.DBNetworkUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.AIRect;
import com.tencent.mobileqq.qrscan.QBarConstants;
import com.tencent.mobileqq.qrscan.QRScanUtil;
import com.tencent.mobileqq.qrscan.ScannerResult;
import com.tencent.mobileqq.qrscan.api.IImgProcessApi;
import com.tencent.mobileqq.qrscan.api.IMiniCodeApi;
import com.tencent.mobileqq.qrscan.api.IQRCodeApi;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.WtloginManager;
import org.json.JSONObject;

public class ScannerUtils
{
  private static int a()
  {
    int i = -1;
    try
    {
      int j = ((IQRCodeApi)QRoute.api(IQRCodeApi.class)).init(1, "ANY", "UTF-8");
      int k = ((IQRCodeApi)QRoute.api(IQRCodeApi.class)).setReaders(QBarConstants.c);
      String str = ((IQRCodeApi)QRoute.api(IQRCodeApi.class)).getVersion();
      if (QLog.isDevelopLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("initQbar init_result1:");
        localStringBuilder.append(j);
        localStringBuilder.append(",init_result2:");
        localStringBuilder.append(k);
        localStringBuilder.append("version:");
        localStringBuilder.append(str);
        QLog.d("IQRScanConst_ScannerUtils", 4, localStringBuilder.toString());
      }
      if (j >= 0)
      {
        if (k < 0) {
          return -1;
        }
        i = 0;
      }
      return i;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("IQRScanConst_ScannerUtils", 1, "initQbar failed:", localThrowable);
    }
    return -1;
  }
  
  /* Error */
  private static int a(Context paramContext, Uri paramUri, int paramInt1, int paramInt2, ScannerResult paramScannerResult)
  {
    // Byte code:
    //   0: iload_2
    //   1: iload_3
    //   2: iconst_2
    //   3: imul
    //   4: if_icmplt +16 -> 20
    //   7: iload_3
    //   8: sipush 1280
    //   11: if_icmpge +9 -> 20
    //   14: iconst_1
    //   15: istore 10
    //   17: goto +6 -> 23
    //   20: iconst_0
    //   21: istore 10
    //   23: iload_2
    //   24: iconst_2
    //   25: imul
    //   26: iload_3
    //   27: if_icmpgt +16 -> 43
    //   30: iload_2
    //   31: sipush 1280
    //   34: if_icmpge +9 -> 43
    //   37: iconst_1
    //   38: istore 11
    //   40: goto +6 -> 46
    //   43: iconst_0
    //   44: istore 11
    //   46: aload_0
    //   47: invokevirtual 87	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   50: astore 13
    //   52: iload 11
    //   54: ifeq +225 -> 279
    //   57: aload 13
    //   59: aload_1
    //   60: invokevirtual 93	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   63: astore_0
    //   64: aload_0
    //   65: invokestatic 99	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   68: astore 12
    //   70: aload_0
    //   71: invokevirtual 104	java/io/InputStream:close	()V
    //   74: iload_2
    //   75: iload_2
    //   76: imul
    //   77: istore 7
    //   79: iload 7
    //   81: newarray int
    //   83: astore_0
    //   84: aload 12
    //   86: aload_0
    //   87: iconst_0
    //   88: iload_2
    //   89: iconst_0
    //   90: iconst_0
    //   91: iload_2
    //   92: iload_2
    //   93: invokevirtual 110	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   96: iload 7
    //   98: newarray byte
    //   100: astore 14
    //   102: ldc 112
    //   104: invokestatic 21	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   107: checkcast 112	com/tencent/mobileqq/qrscan/api/IImgProcessApi
    //   110: aload_0
    //   111: aload 14
    //   113: iload_2
    //   114: iload_2
    //   115: invokeinterface 116 5 0
    //   120: pop
    //   121: aload_0
    //   122: aload 14
    //   124: iload_2
    //   125: iload_2
    //   126: aload 4
    //   128: invokestatic 119	com/tencent/mobileqq/qrscan/utils/ScannerUtils:a	([I[BIILcom/tencent/mobileqq/qrscan/ScannerResult;)I
    //   131: istore 7
    //   133: iload 7
    //   135: iconst_0
    //   136: ior
    //   137: istore 8
    //   139: aload 4
    //   141: invokevirtual 123	com/tencent/mobileqq/qrscan/ScannerResult:d	()Z
    //   144: ifne +58 -> 202
    //   147: aload 12
    //   149: aload_0
    //   150: iconst_0
    //   151: iload_2
    //   152: iconst_0
    //   153: iload_3
    //   154: iload_2
    //   155: isub
    //   156: iload_2
    //   157: iload_2
    //   158: invokevirtual 110	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   161: ldc 112
    //   163: invokestatic 21	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   166: checkcast 112	com/tencent/mobileqq/qrscan/api/IImgProcessApi
    //   169: aload_0
    //   170: aload 14
    //   172: iload_2
    //   173: iload_2
    //   174: invokeinterface 116 5 0
    //   179: pop
    //   180: aload_0
    //   181: aload 14
    //   183: iload_2
    //   184: iload_2
    //   185: aload 4
    //   187: invokestatic 119	com/tencent/mobileqq/qrscan/utils/ScannerUtils:a	([I[BIILcom/tencent/mobileqq/qrscan/ScannerResult;)I
    //   190: istore 7
    //   192: iload 8
    //   194: iload 7
    //   196: ior
    //   197: istore 7
    //   199: goto +7 -> 206
    //   202: iload 8
    //   204: istore 7
    //   206: aload 12
    //   208: invokevirtual 126	android/graphics/Bitmap:recycle	()V
    //   211: goto +305 -> 516
    //   214: astore_1
    //   215: goto +8 -> 223
    //   218: astore_1
    //   219: iload 8
    //   221: istore 7
    //   223: aconst_null
    //   224: astore_0
    //   225: goto +496 -> 721
    //   228: astore_1
    //   229: goto +42 -> 271
    //   232: astore_1
    //   233: aload_0
    //   234: astore 12
    //   236: ldc 67
    //   238: astore 13
    //   240: ldc 128
    //   242: astore 4
    //   244: aload_1
    //   245: astore_0
    //   246: aload 13
    //   248: astore_1
    //   249: goto +460 -> 709
    //   252: astore_1
    //   253: goto +20 -> 273
    //   256: astore_0
    //   257: ldc 67
    //   259: astore_1
    //   260: ldc 128
    //   262: astore 4
    //   264: aconst_null
    //   265: astore 12
    //   267: goto +606 -> 873
    //   270: astore_1
    //   271: aconst_null
    //   272: astore_0
    //   273: iconst_0
    //   274: istore 7
    //   276: goto +445 -> 721
    //   279: iload 10
    //   281: ifeq +232 -> 513
    //   284: aload 13
    //   286: aload_1
    //   287: invokevirtual 93	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   290: astore 12
    //   292: aload 12
    //   294: astore_0
    //   295: aload 12
    //   297: invokestatic 99	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   300: astore 14
    //   302: aload 12
    //   304: astore_0
    //   305: aload 12
    //   307: invokevirtual 104	java/io/InputStream:close	()V
    //   310: iload_3
    //   311: iload_3
    //   312: imul
    //   313: istore 7
    //   315: iload 7
    //   317: newarray int
    //   319: astore_0
    //   320: aload 14
    //   322: aload_0
    //   323: iconst_0
    //   324: iload_3
    //   325: iconst_0
    //   326: iconst_0
    //   327: iload_3
    //   328: iload_3
    //   329: invokevirtual 110	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   332: iload 7
    //   334: newarray byte
    //   336: astore 12
    //   338: ldc 112
    //   340: invokestatic 21	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   343: checkcast 112	com/tencent/mobileqq/qrscan/api/IImgProcessApi
    //   346: aload_0
    //   347: aload 12
    //   349: iload_3
    //   350: iload_3
    //   351: invokeinterface 116 5 0
    //   356: pop
    //   357: aload_0
    //   358: aload 12
    //   360: iload_3
    //   361: iload_3
    //   362: aload 4
    //   364: invokestatic 119	com/tencent/mobileqq/qrscan/utils/ScannerUtils:a	([I[BIILcom/tencent/mobileqq/qrscan/ScannerResult;)I
    //   367: istore 7
    //   369: iload 7
    //   371: iconst_0
    //   372: ior
    //   373: istore 9
    //   375: iload 9
    //   377: istore 7
    //   379: iload 9
    //   381: istore 8
    //   383: aload 4
    //   385: invokevirtual 123	com/tencent/mobileqq/qrscan/ScannerResult:d	()Z
    //   388: ifne +63 -> 451
    //   391: iload 9
    //   393: istore 8
    //   395: aload 14
    //   397: aload_0
    //   398: iconst_0
    //   399: iload_3
    //   400: iload_2
    //   401: iload_3
    //   402: isub
    //   403: iconst_0
    //   404: iload_3
    //   405: iload_3
    //   406: invokevirtual 110	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   409: iload 9
    //   411: istore 8
    //   413: ldc 112
    //   415: invokestatic 21	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   418: checkcast 112	com/tencent/mobileqq/qrscan/api/IImgProcessApi
    //   421: aload_0
    //   422: aload 12
    //   424: iload_3
    //   425: iload_3
    //   426: invokeinterface 116 5 0
    //   431: pop
    //   432: iload 9
    //   434: istore 8
    //   436: iload 9
    //   438: aload_0
    //   439: aload 12
    //   441: iload_3
    //   442: iload_3
    //   443: aload 4
    //   445: invokestatic 119	com/tencent/mobileqq/qrscan/utils/ScannerUtils:a	([I[BIILcom/tencent/mobileqq/qrscan/ScannerResult;)I
    //   448: ior
    //   449: istore 7
    //   451: iload 7
    //   453: istore 8
    //   455: aload 14
    //   457: invokevirtual 126	android/graphics/Bitmap:recycle	()V
    //   460: goto +56 -> 516
    //   463: astore_1
    //   464: goto -245 -> 219
    //   467: astore_1
    //   468: goto +42 -> 510
    //   471: astore_1
    //   472: aload_0
    //   473: astore 12
    //   475: ldc 67
    //   477: astore 13
    //   479: ldc 128
    //   481: astore 4
    //   483: aload_1
    //   484: astore_0
    //   485: aload 13
    //   487: astore_1
    //   488: goto +385 -> 873
    //   491: astore_1
    //   492: aload 12
    //   494: astore_0
    //   495: goto -222 -> 273
    //   498: astore_0
    //   499: ldc 67
    //   501: astore_1
    //   502: ldc 128
    //   504: astore 4
    //   506: goto -242 -> 264
    //   509: astore_1
    //   510: goto -239 -> 271
    //   513: iconst_0
    //   514: istore 7
    //   516: iload_2
    //   517: iload_3
    //   518: invokestatic 134	java/lang/Math:min	(II)I
    //   521: istore_2
    //   522: aload 4
    //   524: invokevirtual 123	com/tencent/mobileqq/qrscan/ScannerResult:d	()Z
    //   527: ifne +390 -> 917
    //   530: iload_2
    //   531: sipush 250
    //   534: if_icmple +383 -> 917
    //   537: new 136	android/graphics/BitmapFactory$Options
    //   540: dup
    //   541: invokespecial 137	android/graphics/BitmapFactory$Options:<init>	()V
    //   544: astore 14
    //   546: iload_2
    //   547: i2d
    //   548: dstore 5
    //   550: dload 5
    //   552: invokestatic 143	java/lang/Double:isNaN	(D)Z
    //   555: pop
    //   556: dload 5
    //   558: ldc2_w 144
    //   561: ddiv
    //   562: dstore 5
    //   564: aload 14
    //   566: dload 5
    //   568: invokestatic 149	java/lang/Math:ceil	(D)D
    //   571: d2i
    //   572: putfield 153	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   575: aload 13
    //   577: aload_1
    //   578: invokevirtual 93	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   581: astore 12
    //   583: aload 12
    //   585: astore_0
    //   586: aload 12
    //   588: aconst_null
    //   589: aload 14
    //   591: invokestatic 156	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   594: astore_1
    //   595: aload 12
    //   597: astore_0
    //   598: aload 12
    //   600: invokevirtual 104	java/io/InputStream:close	()V
    //   603: iload 7
    //   605: istore_2
    //   606: aload_1
    //   607: invokevirtual 159	android/graphics/Bitmap:getWidth	()I
    //   610: istore_3
    //   611: iload 7
    //   613: istore_2
    //   614: aload_1
    //   615: invokevirtual 162	android/graphics/Bitmap:getHeight	()I
    //   618: istore 8
    //   620: iload 7
    //   622: istore_2
    //   623: iload_3
    //   624: iload 8
    //   626: imul
    //   627: newarray int
    //   629: astore_0
    //   630: iload 7
    //   632: istore_2
    //   633: aload_1
    //   634: aload_0
    //   635: iconst_0
    //   636: iload_3
    //   637: iconst_0
    //   638: iconst_0
    //   639: iload_3
    //   640: iload 8
    //   642: invokevirtual 110	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   645: iload 7
    //   647: istore_2
    //   648: aload_1
    //   649: invokevirtual 126	android/graphics/Bitmap:recycle	()V
    //   652: iload 7
    //   654: istore_2
    //   655: aload_0
    //   656: aconst_null
    //   657: iload_3
    //   658: iload 8
    //   660: aload 4
    //   662: invokestatic 119	com/tencent/mobileqq/qrscan/utils/ScannerUtils:a	([I[BIILcom/tencent/mobileqq/qrscan/ScannerResult;)I
    //   665: iload 7
    //   667: ior
    //   668: istore 7
    //   670: goto +3 -> 673
    //   673: iload 7
    //   675: istore_2
    //   676: aload 4
    //   678: invokevirtual 164	com/tencent/mobileqq/qrscan/ScannerResult:a	()V
    //   681: ldc 67
    //   683: astore_1
    //   684: iload 7
    //   686: istore_2
    //   687: goto +94 -> 781
    //   690: astore_0
    //   691: goto +8 -> 699
    //   694: astore_1
    //   695: goto +21 -> 716
    //   698: astore_0
    //   699: aconst_null
    //   700: astore 12
    //   702: ldc 67
    //   704: astore_1
    //   705: ldc 128
    //   707: astore 4
    //   709: goto +164 -> 873
    //   712: astore_1
    //   713: iload 7
    //   715: istore_2
    //   716: aconst_null
    //   717: astore_0
    //   718: iload_2
    //   719: istore 7
    //   721: aload_1
    //   722: invokevirtual 167	java/lang/Throwable:printStackTrace	()V
    //   725: ldc 67
    //   727: astore 12
    //   729: aload 12
    //   731: iconst_1
    //   732: ldc 169
    //   734: aload_1
    //   735: invokestatic 172	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   738: aload 12
    //   740: astore_1
    //   741: iload 7
    //   743: istore_2
    //   744: aload_0
    //   745: ifnull +36 -> 781
    //   748: aload_0
    //   749: invokevirtual 104	java/io/InputStream:close	()V
    //   752: aload 12
    //   754: astore_1
    //   755: iload 7
    //   757: istore_2
    //   758: goto +23 -> 781
    //   761: astore_0
    //   762: aload_0
    //   763: invokevirtual 167	java/lang/Throwable:printStackTrace	()V
    //   766: aload 12
    //   768: iconst_1
    //   769: ldc 128
    //   771: aload_0
    //   772: invokestatic 172	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   775: iload 7
    //   777: istore_2
    //   778: aload 12
    //   780: astore_1
    //   781: invokestatic 175	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   784: ifeq +62 -> 846
    //   787: new 51	java/lang/StringBuilder
    //   790: dup
    //   791: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   794: astore_0
    //   795: aload_0
    //   796: ldc 177
    //   798: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   801: pop
    //   802: aload_0
    //   803: iload 10
    //   805: invokevirtual 180	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   808: pop
    //   809: aload_0
    //   810: ldc 182
    //   812: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   815: pop
    //   816: aload_0
    //   817: iload 11
    //   819: invokevirtual 180	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   822: pop
    //   823: aload_0
    //   824: ldc 184
    //   826: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   829: pop
    //   830: aload_0
    //   831: aload 4
    //   833: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   836: pop
    //   837: aload_1
    //   838: iconst_2
    //   839: aload_0
    //   840: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   843: invokestatic 74	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   846: iload_2
    //   847: ireturn
    //   848: astore_1
    //   849: goto +4 -> 853
    //   852: astore_1
    //   853: ldc 67
    //   855: astore 14
    //   857: ldc 128
    //   859: astore 4
    //   861: aload_1
    //   862: astore 13
    //   864: aload_0
    //   865: astore 12
    //   867: aload 14
    //   869: astore_1
    //   870: aload 13
    //   872: astore_0
    //   873: aload 12
    //   875: ifnull +27 -> 902
    //   878: aload 12
    //   880: invokevirtual 104	java/io/InputStream:close	()V
    //   883: goto +19 -> 902
    //   886: astore 12
    //   888: aload 12
    //   890: invokevirtual 167	java/lang/Throwable:printStackTrace	()V
    //   893: aload_1
    //   894: iconst_1
    //   895: aload 4
    //   897: aload 12
    //   899: invokestatic 172	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   902: goto +5 -> 907
    //   905: aload_0
    //   906: athrow
    //   907: goto -2 -> 905
    //   910: astore_1
    //   911: aload 12
    //   913: astore_0
    //   914: goto -193 -> 721
    //   917: goto -244 -> 673
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	920	0	paramContext	Context
    //   0	920	1	paramUri	Uri
    //   0	920	2	paramInt1	int
    //   0	920	3	paramInt2	int
    //   0	920	4	paramScannerResult	ScannerResult
    //   548	19	5	d	double
    //   77	699	7	i	int
    //   137	522	8	j	int
    //   373	76	9	k	int
    //   15	789	10	bool1	boolean
    //   38	780	11	bool2	boolean
    //   68	811	12	localObject1	Object
    //   886	26	12	localThrowable	Throwable
    //   50	821	13	localObject2	Object
    //   100	768	14	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   206	211	214	java/lang/Throwable
    //   139	192	218	java/lang/Throwable
    //   84	133	228	java/lang/Throwable
    //   64	74	232	finally
    //   64	74	252	java/lang/Throwable
    //   57	64	256	finally
    //   79	84	256	finally
    //   57	64	270	java/lang/Throwable
    //   79	84	270	java/lang/Throwable
    //   383	391	463	java/lang/Throwable
    //   395	409	463	java/lang/Throwable
    //   413	432	463	java/lang/Throwable
    //   436	451	463	java/lang/Throwable
    //   455	460	463	java/lang/Throwable
    //   320	369	467	java/lang/Throwable
    //   295	302	471	finally
    //   305	310	471	finally
    //   586	595	471	finally
    //   598	603	471	finally
    //   295	302	491	java/lang/Throwable
    //   305	310	491	java/lang/Throwable
    //   84	133	498	finally
    //   139	192	498	finally
    //   206	211	498	finally
    //   284	292	498	finally
    //   315	320	498	finally
    //   320	369	498	finally
    //   383	391	498	finally
    //   395	409	498	finally
    //   413	432	498	finally
    //   436	451	498	finally
    //   455	460	498	finally
    //   284	292	509	java/lang/Throwable
    //   315	320	509	java/lang/Throwable
    //   606	611	690	finally
    //   614	620	690	finally
    //   623	630	690	finally
    //   633	645	690	finally
    //   648	652	690	finally
    //   655	670	690	finally
    //   676	681	690	finally
    //   606	611	694	java/lang/Throwable
    //   614	620	694	java/lang/Throwable
    //   623	630	694	java/lang/Throwable
    //   633	645	694	java/lang/Throwable
    //   648	652	694	java/lang/Throwable
    //   655	670	694	java/lang/Throwable
    //   676	681	694	java/lang/Throwable
    //   516	530	698	finally
    //   537	546	698	finally
    //   564	583	698	finally
    //   516	530	712	java/lang/Throwable
    //   537	546	712	java/lang/Throwable
    //   564	583	712	java/lang/Throwable
    //   748	752	761	java/lang/Throwable
    //   729	738	848	finally
    //   721	725	852	finally
    //   878	883	886	java/lang/Throwable
    //   586	595	910	java/lang/Throwable
    //   598	603	910	java/lang/Throwable
  }
  
  public static int a(Bitmap paramBitmap, int paramInt, SparseArray<Object> paramSparseArray)
  {
    paramBitmap = a(paramBitmap, paramInt);
    if (paramBitmap != null)
    {
      paramBitmap.a(paramSparseArray);
      return paramBitmap.a();
    }
    return 0;
  }
  
  private static int a(Bitmap paramBitmap, int[] paramArrayOfInt, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, ScannerResult paramScannerResult)
  {
    byte[] arrayOfByte = paramArrayOfByte;
    if (paramArrayOfByte == null)
    {
      arrayOfByte = new byte[paramInt1 * paramInt2];
      ((IImgProcessApi)QRoute.api(IImgProcessApi.class)).TransBytes(paramArrayOfInt, arrayOfByte, paramInt1, paramInt2);
    }
    int i = 0;
    if ((paramInt3 & 0x1) == 1) {
      i = 0x0 | a(paramArrayOfInt, arrayOfByte, paramInt1, paramInt2, paramScannerResult);
    }
    int j = i;
    if ((paramInt3 & 0x2) == 2) {
      j = i | a(paramBitmap, paramArrayOfInt, arrayOfByte, paramInt1, paramInt2, paramScannerResult);
    }
    return j;
  }
  
  private static int a(Bitmap paramBitmap, int[] paramArrayOfInt, byte[] paramArrayOfByte, int paramInt1, int paramInt2, ScannerResult paramScannerResult)
  {
    int i = paramInt1;
    int j = paramInt2;
    long l = System.currentTimeMillis();
    if (paramArrayOfByte == null)
    {
      paramArrayOfByte = new byte[i * j];
      ((IImgProcessApi)QRoute.api(IImgProcessApi.class)).TransBytes(paramArrayOfInt, paramArrayOfByte, i, j);
    }
    boolean bool1;
    if ((((IMiniCodeApi)QRoute.api(IMiniCodeApi.class)).getSupportDetectType() > 0) && (((IMiniCodeApi)QRoute.api(IMiniCodeApi.class)).isDetectInited())) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    Object localObject1 = "IQRScanConst_ScannerUtils";
    if (bool1)
    {
      paramScannerResult.jdField_a_of_type_Boolean = true;
      Object localObject2 = new ArrayList();
      boolean bool2 = ((IMiniCodeApi)QRoute.api(IMiniCodeApi.class)).detectSync(paramBitmap, (ArrayList)localObject2);
      if (QLog.isColorLevel()) {
        QLog.i("IQRScanConst_ScannerUtils", 2, String.format("parseMiniCode exec=%b, detectRects=%s", new Object[] { Boolean.valueOf(bool2), localObject2 }));
      }
      if ((bool2) && (!((ArrayList)localObject2).isEmpty()))
      {
        localObject2 = ((ArrayList)localObject2).iterator();
        i = 0;
        j = 0;
        paramBitmap = (Bitmap)localObject1;
        while (((Iterator)localObject2).hasNext())
        {
          localObject1 = (AIRect)((Iterator)localObject2).next();
          if (((AIRect)localObject1).jdField_a_of_type_Int == 2)
          {
            Rect localRect = new Rect();
            QRScanUtil.a(((AIRect)localObject1).jdField_a_of_type_AndroidGraphicsRect, localRect, paramInt1, paramInt2, 1.2F);
            StringBuilder localStringBuilder = new StringBuilder();
            int m = a(paramArrayOfInt, paramArrayOfByte, paramInt1, paramInt2, localRect.left, localRect.top, localRect.width(), localRect.height(), localStringBuilder);
            k = j;
            if ((m & 0x2) != 0)
            {
              k = j + 1;
              paramScannerResult.a(localStringBuilder.toString(), ((AIRect)localObject1).jdField_a_of_type_AndroidGraphicsRect, ((AIRect)localObject1).jdField_a_of_type_Float, paramInt1, paramInt2);
            }
            i |= m;
            j = k;
          }
        }
        break label359;
      }
    }
    paramBitmap = "IQRScanConst_ScannerUtils";
    j = 0;
    i = 0;
    label359:
    int k = i;
    if (j == 0)
    {
      paramScannerResult.jdField_a_of_type_Boolean = false;
      localObject1 = new StringBuilder();
      paramInt1 = i | a(paramArrayOfInt, paramArrayOfByte, paramInt1, paramInt2, 0, 0, 0, 0, (StringBuilder)localObject1);
      k = paramInt1;
      if ((paramInt1 & 0x2) != 0)
      {
        paramScannerResult.a(((StringBuilder)localObject1).toString());
        k = paramInt1;
      }
    }
    if (QLog.isColorLevel())
    {
      paramArrayOfInt = new StringBuilder();
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("parseMiniCode cost：");
      paramArrayOfByte.append(System.currentTimeMillis() - l);
      paramArrayOfInt.append(String.format(paramArrayOfByte.toString(), new Object[0]));
      paramArrayOfInt.append(" returnResult:");
      paramArrayOfInt.append(k);
      paramArrayOfInt.append(" supportDetect:");
      paramArrayOfInt.append(bool1);
      paramArrayOfInt.append(" aiDetectCnt:");
      paramArrayOfInt.append(j);
      QLog.i(paramBitmap, 2, paramArrayOfInt.toString());
    }
    return k;
  }
  
  public static int a(Uri paramUri, Context paramContext, int paramInt, SparseArray<Object> paramSparseArray)
  {
    paramUri = a(paramUri, paramContext, paramInt);
    if (paramUri != null)
    {
      paramUri.a(paramSparseArray);
      return paramUri.a();
    }
    return 0;
  }
  
  /* Error */
  private static int a(Uri paramUri, Context paramContext, int paramInt, ScannerResult paramScannerResult)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: iconst_0
    //   4: istore 5
    //   6: iconst_0
    //   7: istore 6
    //   9: iload_2
    //   10: iconst_3
    //   11: iand
    //   12: ifne +5 -> 17
    //   15: iconst_0
    //   16: ireturn
    //   17: ldc2_w 317
    //   20: lstore 8
    //   22: ldc_w 320
    //   25: invokestatic 21	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   28: checkcast 320	com/tencent/mobileqq/qrscan/api/IQRScanTempApi
    //   31: aload_0
    //   32: invokevirtual 325	android/net/Uri:getPath	()Ljava/lang/String;
    //   35: invokeinterface 329 2 0
    //   40: astore_0
    //   41: invokestatic 49	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   44: ifeq +35 -> 79
    //   47: new 51	java/lang/StringBuilder
    //   50: dup
    //   51: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   54: astore_1
    //   55: aload_1
    //   56: ldc_w 331
    //   59: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: pop
    //   63: aload_1
    //   64: aload_0
    //   65: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   68: pop
    //   69: ldc 67
    //   71: iconst_4
    //   72: aload_1
    //   73: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   76: invokestatic 74	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   79: aload_0
    //   80: ifnull +250 -> 330
    //   83: aload_0
    //   84: invokevirtual 159	android/graphics/Bitmap:getWidth	()I
    //   87: istore 6
    //   89: aload_0
    //   90: invokevirtual 162	android/graphics/Bitmap:getHeight	()I
    //   93: istore 7
    //   95: ldc 15
    //   97: invokestatic 21	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   100: checkcast 15	com/tencent/mobileqq/qrscan/api/IQRCodeApi
    //   103: iload 6
    //   105: iload 7
    //   107: invokeinterface 335 3 0
    //   112: ifne +5 -> 117
    //   115: iconst_0
    //   116: ireturn
    //   117: iload_2
    //   118: iconst_1
    //   119: iand
    //   120: iconst_1
    //   121: if_icmpne +13 -> 134
    //   124: invokestatic 336	com/tencent/mobileqq/qrscan/utils/ScannerUtils:a	()I
    //   127: pop
    //   128: iconst_1
    //   129: istore 4
    //   131: goto +6 -> 137
    //   134: iconst_0
    //   135: istore 4
    //   137: iload_2
    //   138: iconst_2
    //   139: iand
    //   140: iconst_2
    //   141: if_icmpne +60 -> 201
    //   144: lload 8
    //   146: lstore 10
    //   148: lload 8
    //   150: lstore 12
    //   152: invokestatic 208	java/lang/System:currentTimeMillis	()J
    //   155: lstore 8
    //   157: lload 8
    //   159: lstore 10
    //   161: lload 8
    //   163: lstore 12
    //   165: lload 8
    //   167: ldc_w 338
    //   170: invokestatic 341	com/tencent/mobileqq/qrscan/utils/ScannerUtils:a	(JLjava/lang/String;)V
    //   173: iconst_1
    //   174: istore 5
    //   176: goto +33 -> 209
    //   179: astore_0
    //   180: iload 4
    //   182: istore_2
    //   183: lload 10
    //   185: lstore 8
    //   187: goto +180 -> 367
    //   190: astore_0
    //   191: iload 4
    //   193: istore_2
    //   194: lload 12
    //   196: lstore 8
    //   198: goto +179 -> 377
    //   201: ldc2_w 317
    //   204: lstore 8
    //   206: iconst_0
    //   207: istore 5
    //   209: iload 6
    //   211: iload 7
    //   213: imul
    //   214: newarray int
    //   216: astore_1
    //   217: aload_0
    //   218: aload_1
    //   219: iconst_0
    //   220: iload 6
    //   222: iconst_0
    //   223: iconst_0
    //   224: iload 6
    //   226: iload 7
    //   228: invokevirtual 110	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   231: aload_0
    //   232: aload_1
    //   233: aconst_null
    //   234: iload 6
    //   236: iload 7
    //   238: iload_2
    //   239: aload_3
    //   240: invokestatic 343	com/tencent/mobileqq/qrscan/utils/ScannerUtils:a	(Landroid/graphics/Bitmap;[I[BIIILcom/tencent/mobileqq/qrscan/ScannerResult;)I
    //   243: istore 6
    //   245: iload 6
    //   247: iconst_0
    //   248: ior
    //   249: istore 6
    //   251: invokestatic 49	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   254: ifeq +38 -> 292
    //   257: ldc 67
    //   259: iconst_4
    //   260: ldc_w 345
    //   263: iconst_3
    //   264: anewarray 4	java/lang/Object
    //   267: dup
    //   268: iconst_0
    //   269: iload_2
    //   270: invokestatic 350	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   273: aastore
    //   274: dup
    //   275: iconst_1
    //   276: iload 6
    //   278: invokestatic 350	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   281: aastore
    //   282: dup
    //   283: iconst_2
    //   284: aload_3
    //   285: aastore
    //   286: invokestatic 240	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   289: invokestatic 74	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   292: aload_0
    //   293: invokevirtual 126	android/graphics/Bitmap:recycle	()V
    //   296: iload 6
    //   298: istore_2
    //   299: goto +40 -> 339
    //   302: astore_0
    //   303: iload 4
    //   305: istore_2
    //   306: iload 6
    //   308: istore 4
    //   310: goto +73 -> 383
    //   313: astore_0
    //   314: iload 4
    //   316: istore_2
    //   317: goto +105 -> 422
    //   320: astore_0
    //   321: iload 4
    //   323: istore_2
    //   324: iconst_0
    //   325: istore 4
    //   327: goto +56 -> 383
    //   330: iconst_0
    //   331: istore 4
    //   333: iconst_0
    //   334: istore 5
    //   336: iload 6
    //   338: istore_2
    //   339: iload 4
    //   341: ifeq +7 -> 348
    //   344: invokestatic 353	com/tencent/mobileqq/qrscan/utils/ScannerUtils:b	()I
    //   347: pop
    //   348: iload 5
    //   350: ifeq +11 -> 361
    //   353: lload 8
    //   355: ldc_w 338
    //   358: invokestatic 355	com/tencent/mobileqq/qrscan/utils/ScannerUtils:b	(JLjava/lang/String;)V
    //   361: iload_2
    //   362: ireturn
    //   363: astore_0
    //   364: iload 4
    //   366: istore_2
    //   367: iconst_0
    //   368: istore 5
    //   370: goto +52 -> 422
    //   373: astore_0
    //   374: iload 5
    //   376: istore_2
    //   377: iconst_0
    //   378: istore 4
    //   380: iconst_0
    //   381: istore 5
    //   383: aload_0
    //   384: invokevirtual 167	java/lang/Throwable:printStackTrace	()V
    //   387: ldc 67
    //   389: iconst_1
    //   390: ldc_w 357
    //   393: aload_0
    //   394: invokestatic 172	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   397: iload_2
    //   398: ifeq +7 -> 405
    //   401: invokestatic 353	com/tencent/mobileqq/qrscan/utils/ScannerUtils:b	()I
    //   404: pop
    //   405: iload 5
    //   407: ifeq +11 -> 418
    //   410: lload 8
    //   412: ldc_w 338
    //   415: invokestatic 355	com/tencent/mobileqq/qrscan/utils/ScannerUtils:b	(JLjava/lang/String;)V
    //   418: iload 4
    //   420: ireturn
    //   421: astore_0
    //   422: iload_2
    //   423: ifeq +7 -> 430
    //   426: invokestatic 353	com/tencent/mobileqq/qrscan/utils/ScannerUtils:b	()I
    //   429: pop
    //   430: iload 5
    //   432: ifeq +11 -> 443
    //   435: lload 8
    //   437: ldc_w 338
    //   440: invokestatic 355	com/tencent/mobileqq/qrscan/utils/ScannerUtils:b	(JLjava/lang/String;)V
    //   443: aload_0
    //   444: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	445	0	paramUri	Uri
    //   0	445	1	paramContext	Context
    //   0	445	2	paramInt	int
    //   0	445	3	paramScannerResult	ScannerResult
    //   1	418	4	i	int
    //   4	427	5	j	int
    //   7	330	6	k	int
    //   93	144	7	m	int
    //   20	416	8	l1	long
    //   146	38	10	l2	long
    //   150	45	12	l3	long
    // Exception table:
    //   from	to	target	type
    //   152	157	179	finally
    //   165	173	179	finally
    //   152	157	190	java/lang/Throwable
    //   165	173	190	java/lang/Throwable
    //   251	292	302	java/lang/Throwable
    //   292	296	302	java/lang/Throwable
    //   209	245	313	finally
    //   251	292	313	finally
    //   292	296	313	finally
    //   209	245	320	java/lang/Throwable
    //   22	79	363	finally
    //   83	115	363	finally
    //   124	128	363	finally
    //   22	79	373	java/lang/Throwable
    //   83	115	373	java/lang/Throwable
    //   124	128	373	java/lang/Throwable
    //   383	397	421	finally
  }
  
  private static int a(int[] paramArrayOfInt, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, StringBuilder paramStringBuilder)
  {
    paramArrayOfInt = ((IMiniCodeApi)QRoute.api(IMiniCodeApi.class)).decode(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, 1);
    if (((IMiniCodeApi)QRoute.api(IMiniCodeApi.class)).bValidDecodeResult(paramArrayOfInt))
    {
      if (paramStringBuilder.length() > 0) {
        paramStringBuilder.delete(0, paramStringBuilder.length());
      }
      paramStringBuilder.append(paramArrayOfInt);
      return 2;
    }
    return 0;
  }
  
  private static int a(int[] paramArrayOfInt, byte[] paramArrayOfByte, int paramInt1, int paramInt2, ScannerResult paramScannerResult)
  {
    long l = System.currentTimeMillis();
    byte[] arrayOfByte = paramArrayOfByte;
    if (paramArrayOfByte == null)
    {
      arrayOfByte = new byte[paramInt1 * paramInt2];
      ((IImgProcessApi)QRoute.api(IImgProcessApi.class)).TransBytes(paramArrayOfInt, arrayOfByte, paramInt1, paramInt2);
    }
    paramInt2 = ((IQRCodeApi)QRoute.api(IQRCodeApi.class)).scanImage(arrayOfByte, paramInt1, paramInt2);
    paramInt1 = 1;
    if (paramInt2 == 1) {
      paramScannerResult.jdField_a_of_type_JavaUtilArrayList = ((IQRCodeApi)QRoute.api(IQRCodeApi.class)).getResult();
    } else {
      paramInt1 = 0;
    }
    if (QLog.isColorLevel())
    {
      paramArrayOfInt = new StringBuilder();
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("parseQRCode cost：");
      paramArrayOfByte.append(System.currentTimeMillis() - l);
      paramArrayOfInt.append(String.format(paramArrayOfByte.toString(), new Object[0]));
      paramArrayOfInt.append(" returnResult:");
      paramArrayOfInt.append(paramInt1);
      QLog.i("IQRScanConst_ScannerUtils", 2, paramArrayOfInt.toString());
    }
    return paramInt1;
  }
  
  public static Pair<StringBuilder, StringBuilder> a(Uri paramUri, Context paramContext)
  {
    paramUri = a(paramUri, paramContext, 1);
    if (paramUri != null) {
      return paramUri.a();
    }
    return null;
  }
  
  /* Error */
  public static ScannerResult a(Bitmap paramBitmap, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: ldc 15
    //   8: invokestatic 21	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   11: checkcast 15	com/tencent/mobileqq/qrscan/api/IQRCodeApi
    //   14: aload_0
    //   15: invokevirtual 159	android/graphics/Bitmap:getWidth	()I
    //   18: aload_0
    //   19: invokevirtual 162	android/graphics/Bitmap:getHeight	()I
    //   22: invokeinterface 335 3 0
    //   27: ifne +5 -> 32
    //   30: aconst_null
    //   31: areturn
    //   32: invokestatic 49	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   35: istore 6
    //   37: iconst_0
    //   38: istore_2
    //   39: iload 6
    //   41: ifeq +39 -> 80
    //   44: ldc 67
    //   46: iconst_4
    //   47: ldc_w 392
    //   50: iconst_2
    //   51: anewarray 4	java/lang/Object
    //   54: dup
    //   55: iconst_0
    //   56: aload_0
    //   57: invokevirtual 159	android/graphics/Bitmap:getWidth	()I
    //   60: invokestatic 350	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   63: aastore
    //   64: dup
    //   65: iconst_1
    //   66: aload_0
    //   67: invokevirtual 162	android/graphics/Bitmap:getHeight	()I
    //   70: invokestatic 350	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   73: aastore
    //   74: invokestatic 240	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   77: invokestatic 74	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   80: invokestatic 208	java/lang/System:currentTimeMillis	()J
    //   83: lstore 13
    //   85: ldc2_w 317
    //   88: lstore 7
    //   90: new 121	com/tencent/mobileqq/qrscan/ScannerResult
    //   93: dup
    //   94: invokespecial 393	com/tencent/mobileqq/qrscan/ScannerResult:<init>	()V
    //   97: astore 15
    //   99: iload_1
    //   100: iconst_1
    //   101: iand
    //   102: iconst_1
    //   103: if_icmpne +33 -> 136
    //   106: invokestatic 336	com/tencent/mobileqq/qrscan/utils/ScannerUtils:a	()I
    //   109: pop
    //   110: iconst_1
    //   111: istore_2
    //   112: goto +26 -> 138
    //   115: astore_0
    //   116: ldc2_w 317
    //   119: lstore 7
    //   121: iconst_0
    //   122: istore_2
    //   123: iconst_0
    //   124: istore_3
    //   125: goto +306 -> 431
    //   128: astore_0
    //   129: iload_2
    //   130: istore_1
    //   131: iconst_0
    //   132: istore_3
    //   133: goto +204 -> 337
    //   136: iconst_0
    //   137: istore_2
    //   138: iload_1
    //   139: iconst_2
    //   140: iand
    //   141: iconst_2
    //   142: if_icmpne +55 -> 197
    //   145: lload 7
    //   147: lstore 9
    //   149: lload 7
    //   151: lstore 11
    //   153: invokestatic 208	java/lang/System:currentTimeMillis	()J
    //   156: lstore 7
    //   158: lload 7
    //   160: lstore 9
    //   162: lload 7
    //   164: lstore 11
    //   166: lload 7
    //   168: ldc_w 395
    //   171: invokestatic 341	com/tencent/mobileqq/qrscan/utils/ScannerUtils:a	(JLjava/lang/String;)V
    //   174: iconst_1
    //   175: istore_3
    //   176: goto +23 -> 199
    //   179: astore_0
    //   180: lload 9
    //   182: lstore 7
    //   184: goto -61 -> 123
    //   187: astore_0
    //   188: iload_2
    //   189: istore_1
    //   190: lload 11
    //   192: lstore 7
    //   194: goto -63 -> 131
    //   197: iconst_0
    //   198: istore_3
    //   199: aload_0
    //   200: invokevirtual 159	android/graphics/Bitmap:getWidth	()I
    //   203: istore 4
    //   205: aload_0
    //   206: invokevirtual 162	android/graphics/Bitmap:getHeight	()I
    //   209: istore 5
    //   211: iload 4
    //   213: iload 5
    //   215: imul
    //   216: newarray int
    //   218: astore 16
    //   220: aload_0
    //   221: aload 16
    //   223: iconst_0
    //   224: iload 4
    //   226: iconst_0
    //   227: iconst_0
    //   228: iload 4
    //   230: iload 5
    //   232: invokevirtual 110	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   235: aload_0
    //   236: aload 16
    //   238: aconst_null
    //   239: iload 4
    //   241: iload 5
    //   243: iload_1
    //   244: aload 15
    //   246: invokestatic 343	com/tencent/mobileqq/qrscan/utils/ScannerUtils:a	(Landroid/graphics/Bitmap;[I[BIIILcom/tencent/mobileqq/qrscan/ScannerResult;)I
    //   249: istore 4
    //   251: aload_0
    //   252: invokevirtual 126	android/graphics/Bitmap:recycle	()V
    //   255: invokestatic 49	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   258: ifeq +41 -> 299
    //   261: ldc 67
    //   263: iconst_4
    //   264: ldc_w 397
    //   267: iconst_3
    //   268: anewarray 4	java/lang/Object
    //   271: dup
    //   272: iconst_0
    //   273: iload_1
    //   274: invokestatic 350	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   277: aastore
    //   278: dup
    //   279: iconst_1
    //   280: iload 4
    //   282: iconst_0
    //   283: ior
    //   284: invokestatic 350	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   287: aastore
    //   288: dup
    //   289: iconst_2
    //   290: aload 15
    //   292: aastore
    //   293: invokestatic 240	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   296: invokestatic 74	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   299: iload_2
    //   300: ifeq +7 -> 307
    //   303: invokestatic 353	com/tencent/mobileqq/qrscan/utils/ScannerUtils:b	()I
    //   306: pop
    //   307: iload_3
    //   308: ifeq +63 -> 371
    //   311: lload 7
    //   313: ldc_w 395
    //   316: invokestatic 355	com/tencent/mobileqq/qrscan/utils/ScannerUtils:b	(JLjava/lang/String;)V
    //   319: goto +52 -> 371
    //   322: astore_0
    //   323: goto +108 -> 431
    //   326: astore_0
    //   327: goto +8 -> 335
    //   330: astore_0
    //   331: goto +100 -> 431
    //   334: astore_0
    //   335: iload_2
    //   336: istore_1
    //   337: aload_0
    //   338: invokevirtual 167	java/lang/Throwable:printStackTrace	()V
    //   341: ldc 67
    //   343: iconst_1
    //   344: ldc_w 399
    //   347: aload_0
    //   348: invokestatic 172	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   351: iload_1
    //   352: ifeq +7 -> 359
    //   355: invokestatic 353	com/tencent/mobileqq/qrscan/utils/ScannerUtils:b	()I
    //   358: pop
    //   359: iload_3
    //   360: ifeq +11 -> 371
    //   363: lload 7
    //   365: ldc_w 395
    //   368: invokestatic 355	com/tencent/mobileqq/qrscan/utils/ScannerUtils:b	(JLjava/lang/String;)V
    //   371: invokestatic 49	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   374: ifeq +41 -> 415
    //   377: new 51	java/lang/StringBuilder
    //   380: dup
    //   381: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   384: astore_0
    //   385: aload_0
    //   386: ldc_w 401
    //   389: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   392: pop
    //   393: aload_0
    //   394: invokestatic 208	java/lang/System:currentTimeMillis	()J
    //   397: lload 13
    //   399: lsub
    //   400: invokevirtual 304	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   403: pop
    //   404: ldc_w 395
    //   407: iconst_4
    //   408: aload_0
    //   409: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   412: invokestatic 74	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   415: aload 15
    //   417: invokevirtual 403	com/tencent/mobileqq/qrscan/ScannerResult:b	()Z
    //   420: ifeq +6 -> 426
    //   423: aload 15
    //   425: areturn
    //   426: aconst_null
    //   427: areturn
    //   428: astore_0
    //   429: iload_1
    //   430: istore_2
    //   431: iload_2
    //   432: ifeq +7 -> 439
    //   435: invokestatic 353	com/tencent/mobileqq/qrscan/utils/ScannerUtils:b	()I
    //   438: pop
    //   439: iload_3
    //   440: ifeq +11 -> 451
    //   443: lload 7
    //   445: ldc_w 395
    //   448: invokestatic 355	com/tencent/mobileqq/qrscan/utils/ScannerUtils:b	(JLjava/lang/String;)V
    //   451: goto +5 -> 456
    //   454: aload_0
    //   455: athrow
    //   456: goto -2 -> 454
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	459	0	paramBitmap	Bitmap
    //   0	459	1	paramInt	int
    //   38	394	2	i	int
    //   124	316	3	j	int
    //   203	81	4	k	int
    //   209	33	5	m	int
    //   35	5	6	bool	boolean
    //   88	356	7	l1	long
    //   147	34	9	l2	long
    //   151	40	11	l3	long
    //   83	315	13	l4	long
    //   97	327	15	localScannerResult	ScannerResult
    //   218	19	16	arrayOfInt	int[]
    // Exception table:
    //   from	to	target	type
    //   106	110	115	finally
    //   106	110	128	java/lang/Throwable
    //   153	158	179	finally
    //   166	174	179	finally
    //   153	158	187	java/lang/Throwable
    //   166	174	187	java/lang/Throwable
    //   235	299	322	finally
    //   235	299	326	java/lang/Throwable
    //   199	235	330	finally
    //   199	235	334	java/lang/Throwable
    //   337	351	428	finally
  }
  
  public static ScannerResult a(Uri paramUri, Context paramContext, int paramInt)
  {
    return a(paramUri, paramContext, paramInt, false);
  }
  
  public static ScannerResult a(Uri paramUri, Context paramContext, int paramInt, boolean paramBoolean)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramUri != null)
    {
      if (paramContext == null) {
        return null;
      }
      long l = System.currentTimeMillis();
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("detectQQCode isSharpP:");
        ((StringBuilder)localObject1).append(paramBoolean);
        ((StringBuilder)localObject1).append(" mode:");
        ((StringBuilder)localObject1).append(paramInt);
        QLog.d("IQRScanConst_ScannerUtils", 2, ((StringBuilder)localObject1).toString());
      }
      ScannerResult localScannerResult = new ScannerResult();
      if (paramBoolean) {
        paramInt = a(paramUri, paramContext, paramInt, localScannerResult);
      } else {
        paramInt = b(paramUri, paramContext, paramInt, localScannerResult);
      }
      if (QLog.isDevelopLevel())
      {
        paramUri = new StringBuilder();
        paramUri.append("detectQQCode cost: ");
        paramUri.append(System.currentTimeMillis() - l);
        paramUri.append(" result:");
        paramUri.append(paramInt | 0x0);
        paramUri.append("\n scannerResult:");
        paramUri.append(localScannerResult);
        QLog.d("IQRScanConst_ScannerUtils", 4, paramUri.toString());
      }
      localObject1 = localObject2;
      if (localScannerResult.b()) {
        localObject1 = localScannerResult;
      }
    }
    return localObject1;
  }
  
  public static String a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("type", paramInt);
      if (MobileQQ.getMobileQQ() != null)
      {
        Object localObject = MobileQQ.getMobileQQ().waitAppRuntime(null);
        if (localObject != null)
        {
          localObject = (WtloginManager)((AppRuntime)localObject).getManager(1);
          if (localObject != null)
          {
            localObject = ((WtloginManager)localObject).getGUID();
            if ((localObject != null) && (localObject.length > 0))
            {
              localObject = HexUtil.bytes2HexStr((byte[])localObject);
              if (!TextUtils.isEmpty((CharSequence)localObject)) {
                localJSONObject.put("guid", ((String)localObject).toUpperCase());
              }
            }
          }
        }
      }
      if (!TextUtils.isEmpty(paramString1)) {
        localJSONObject.put("md5", paramString1.toUpperCase());
      }
      if ((!TextUtils.isEmpty(paramString2)) && (paramString2.length() < 512)) {
        localJSONObject.put("url", paramString2);
      } else if (!TextUtils.isEmpty(paramString3)) {
        localJSONObject.put("uuid", paramString3);
      }
      if (!TextUtils.isEmpty(paramString4)) {
        localJSONObject.put("fromuin", paramString4);
      }
      if (!TextUtils.isEmpty(paramString5)) {
        localJSONObject.put("touin", paramString5);
      }
      paramString1 = DeviceInfoUtil.a();
      if (!TextUtils.isEmpty(paramString1)) {
        localJSONObject.put("imei", paramString1.toUpperCase());
      }
      paramString1 = DBNetworkUtil.a();
      if (!TextUtils.isEmpty(paramString1)) {
        localJSONObject.put("ip", paramString1);
      }
    }
    catch (Throwable paramString1)
    {
      paramString2 = new StringBuilder();
      paramString2.append("buildQRScanReportParams error: ");
      paramString2.append(paramString1.getMessage());
      QLog.i("ScannerUtils", 1, paramString2.toString());
    }
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append("buildQRScanReportParams json: ");
      paramString1.append(localJSONObject.toString());
      QLog.i("ScannerUtils", 2, paramString1.toString());
    }
    return localJSONObject.toString();
  }
  
  private static void a(long paramLong, String paramString)
  {
    ((IMiniCodeApi)QRoute.api(IMiniCodeApi.class)).init(MobileQQ.getContext(), paramLong, paramString);
    if (QLog.isColorLevel()) {
      QLog.i(paramString, 2, String.format("initQMini minicode=%b busiHash=%d", new Object[] { Boolean.valueOf(((IMiniCodeApi)QRoute.api(IMiniCodeApi.class)).isDecodeInited()), Long.valueOf(paramLong) }));
    }
  }
  
  private static int b()
  {
    try
    {
      int i = ((IQRCodeApi)QRoute.api(IQRCodeApi.class)).release();
      if (i < 0) {
        return -1;
      }
      return 0;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("IQRScanConst_ScannerUtils", 1, "releaseQbar failed:", localThrowable);
    }
    return -1;
  }
  
  /* Error */
  private static int b(Uri paramUri, Context paramContext, int paramInt, ScannerResult paramScannerResult)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 7
    //   3: iconst_0
    //   4: istore 8
    //   6: iconst_0
    //   7: istore 9
    //   9: iconst_0
    //   10: istore 6
    //   12: aconst_null
    //   13: astore 21
    //   15: ldc2_w 317
    //   18: lstore 13
    //   20: aload_1
    //   21: invokevirtual 87	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   24: astore 23
    //   26: aload 23
    //   28: aload_0
    //   29: invokevirtual 93	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   32: astore 20
    //   34: aload 20
    //   36: ifnonnull +32 -> 68
    //   39: aload 20
    //   41: ifnull +25 -> 66
    //   44: aload 20
    //   46: invokevirtual 104	java/io/InputStream:close	()V
    //   49: iconst_0
    //   50: ireturn
    //   51: astore_0
    //   52: aload_0
    //   53: invokevirtual 167	java/lang/Throwable:printStackTrace	()V
    //   56: ldc 67
    //   58: iconst_1
    //   59: ldc_w 527
    //   62: aload_0
    //   63: invokestatic 172	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   66: iconst_0
    //   67: ireturn
    //   68: new 136	android/graphics/BitmapFactory$Options
    //   71: dup
    //   72: invokespecial 137	android/graphics/BitmapFactory$Options:<init>	()V
    //   75: astore 22
    //   77: aload 22
    //   79: iconst_1
    //   80: putfield 530	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   83: aload 20
    //   85: aconst_null
    //   86: aload 22
    //   88: invokestatic 156	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   91: pop
    //   92: aload 20
    //   94: invokevirtual 104	java/io/InputStream:close	()V
    //   97: aload 22
    //   99: getfield 533	android/graphics/BitmapFactory$Options:outWidth	I
    //   102: istore 10
    //   104: aload 22
    //   106: getfield 536	android/graphics/BitmapFactory$Options:outHeight	I
    //   109: istore 11
    //   111: aload 22
    //   113: iconst_0
    //   114: putfield 530	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   117: iload 10
    //   119: sipush 12800
    //   122: if_icmpgt +449 -> 571
    //   125: iload 11
    //   127: sipush 12800
    //   130: if_icmple +5 -> 135
    //   133: iconst_0
    //   134: ireturn
    //   135: ldc 15
    //   137: invokestatic 21	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   140: checkcast 15	com/tencent/mobileqq/qrscan/api/IQRCodeApi
    //   143: iload 10
    //   145: iload 11
    //   147: invokeinterface 335 3 0
    //   152: istore 19
    //   154: iload 19
    //   156: ifne +5 -> 161
    //   159: iconst_0
    //   160: ireturn
    //   161: iload 10
    //   163: iload 11
    //   165: imul
    //   166: istore 12
    //   168: iload 12
    //   170: ldc_w 537
    //   173: if_icmple +53 -> 226
    //   176: iload 12
    //   178: i2d
    //   179: dstore 4
    //   181: aload 22
    //   183: dload 4
    //   185: invokestatic 540	java/lang/Math:sqrt	(D)D
    //   188: ldc2_w 541
    //   191: ddiv
    //   192: invokestatic 149	java/lang/Math:ceil	(D)D
    //   195: d2i
    //   196: putfield 153	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   199: goto +33 -> 232
    //   202: astore_0
    //   203: ldc2_w 317
    //   206: lstore 13
    //   208: aconst_null
    //   209: astore_1
    //   210: iload 7
    //   212: istore_2
    //   213: goto +396 -> 609
    //   216: astore_0
    //   217: iload 6
    //   219: istore_2
    //   220: aload 21
    //   222: astore_1
    //   223: goto +372 -> 595
    //   226: aload 22
    //   228: iconst_1
    //   229: putfield 153	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   232: aload 23
    //   234: aload_0
    //   235: invokevirtual 93	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   238: astore 20
    //   240: aload 20
    //   242: aconst_null
    //   243: aload 22
    //   245: invokestatic 156	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   248: astore 22
    //   250: aload 20
    //   252: invokevirtual 104	java/io/InputStream:close	()V
    //   255: aload 22
    //   257: ifnonnull +5 -> 262
    //   260: iconst_0
    //   261: ireturn
    //   262: iload_2
    //   263: iconst_1
    //   264: iand
    //   265: istore 9
    //   267: iload 9
    //   269: iconst_1
    //   270: if_icmpne +13 -> 283
    //   273: invokestatic 336	com/tencent/mobileqq/qrscan/utils/ScannerUtils:a	()I
    //   276: pop
    //   277: iconst_1
    //   278: istore 6
    //   280: goto +6 -> 286
    //   283: iconst_0
    //   284: istore 6
    //   286: iload_2
    //   287: iconst_2
    //   288: iand
    //   289: iconst_2
    //   290: if_icmpne +65 -> 355
    //   293: lload 13
    //   295: lstore 15
    //   297: lload 13
    //   299: lstore 17
    //   301: invokestatic 208	java/lang/System:currentTimeMillis	()J
    //   304: lstore 13
    //   306: lload 13
    //   308: lstore 15
    //   310: lload 13
    //   312: lstore 17
    //   314: lload 13
    //   316: ldc_w 544
    //   319: invokestatic 341	com/tencent/mobileqq/qrscan/utils/ScannerUtils:a	(JLjava/lang/String;)V
    //   322: iconst_1
    //   323: istore 7
    //   325: goto +38 -> 363
    //   328: astore_0
    //   329: lload 15
    //   331: lstore 13
    //   333: aconst_null
    //   334: astore_1
    //   335: iload 6
    //   337: istore_2
    //   338: goto +271 -> 609
    //   341: astore_0
    //   342: iload 6
    //   344: istore_2
    //   345: lload 17
    //   347: lstore 13
    //   349: aload 21
    //   351: astore_1
    //   352: goto +243 -> 595
    //   355: ldc2_w 317
    //   358: lstore 13
    //   360: iconst_0
    //   361: istore 7
    //   363: aload 22
    //   365: invokevirtual 159	android/graphics/Bitmap:getWidth	()I
    //   368: istore 8
    //   370: aload 22
    //   372: invokevirtual 162	android/graphics/Bitmap:getHeight	()I
    //   375: istore 12
    //   377: iload 8
    //   379: iload 12
    //   381: imul
    //   382: newarray int
    //   384: astore 20
    //   386: aload 22
    //   388: aload 20
    //   390: iconst_0
    //   391: iload 8
    //   393: iconst_0
    //   394: iconst_0
    //   395: iload 8
    //   397: iload 12
    //   399: invokevirtual 110	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   402: aload 22
    //   404: aload 20
    //   406: aconst_null
    //   407: iload 8
    //   409: iload 12
    //   411: iload_2
    //   412: aload_3
    //   413: invokestatic 343	com/tencent/mobileqq/qrscan/utils/ScannerUtils:a	(Landroid/graphics/Bitmap;[I[BIIILcom/tencent/mobileqq/qrscan/ScannerResult;)I
    //   416: istore_2
    //   417: iconst_0
    //   418: iload_2
    //   419: ior
    //   420: istore_2
    //   421: aload 22
    //   423: invokevirtual 126	android/graphics/Bitmap:recycle	()V
    //   426: iload_2
    //   427: istore 8
    //   429: iload 9
    //   431: iconst_1
    //   432: if_icmpne +47 -> 479
    //   435: iload_2
    //   436: istore 8
    //   438: aload_3
    //   439: invokevirtual 403	com/tencent/mobileqq/qrscan/ScannerResult:b	()Z
    //   442: ifne +37 -> 479
    //   445: aload_1
    //   446: aload_0
    //   447: iload 10
    //   449: iload 11
    //   451: aload_3
    //   452: invokestatic 546	com/tencent/mobileqq/qrscan/utils/ScannerUtils:a	(Landroid/content/Context;Landroid/net/Uri;IILcom/tencent/mobileqq/qrscan/ScannerResult;)I
    //   455: istore 8
    //   457: iload_2
    //   458: iload 8
    //   460: ior
    //   461: istore 8
    //   463: goto +16 -> 479
    //   466: astore_0
    //   467: iload 6
    //   469: istore_2
    //   470: aconst_null
    //   471: astore_1
    //   472: goto +223 -> 695
    //   475: astore_0
    //   476: goto +52 -> 528
    //   479: iload 6
    //   481: ifeq +7 -> 488
    //   484: invokestatic 353	com/tencent/mobileqq/qrscan/utils/ScannerUtils:b	()I
    //   487: pop
    //   488: iload 7
    //   490: ifeq +11 -> 501
    //   493: lload 13
    //   495: ldc_w 544
    //   498: invokestatic 355	com/tencent/mobileqq/qrscan/utils/ScannerUtils:b	(JLjava/lang/String;)V
    //   501: iload 8
    //   503: ireturn
    //   504: astore_0
    //   505: goto +23 -> 528
    //   508: astore_0
    //   509: goto +8 -> 517
    //   512: astore_0
    //   513: goto +13 -> 526
    //   516: astore_0
    //   517: iload 6
    //   519: istore_2
    //   520: aconst_null
    //   521: astore_1
    //   522: goto +90 -> 612
    //   525: astore_0
    //   526: iconst_0
    //   527: istore_2
    //   528: iload 6
    //   530: istore 8
    //   532: aconst_null
    //   533: astore_1
    //   534: iload_2
    //   535: istore 6
    //   537: iload 8
    //   539: istore_2
    //   540: goto +87 -> 627
    //   543: astore_0
    //   544: aload 20
    //   546: astore_1
    //   547: iconst_0
    //   548: istore 7
    //   550: ldc2_w 317
    //   553: lstore 13
    //   555: iload 8
    //   557: istore_2
    //   558: goto +54 -> 612
    //   561: astore_0
    //   562: aload 20
    //   564: astore_1
    //   565: iload 6
    //   567: istore_2
    //   568: goto +27 -> 595
    //   571: iconst_0
    //   572: ireturn
    //   573: astore_0
    //   574: ldc2_w 317
    //   577: lstore 13
    //   579: aload 20
    //   581: astore_1
    //   582: iload 7
    //   584: istore_2
    //   585: goto +24 -> 609
    //   588: astore_0
    //   589: aload 20
    //   591: astore_1
    //   592: iload 6
    //   594: istore_2
    //   595: goto +26 -> 621
    //   598: astore_0
    //   599: ldc2_w 317
    //   602: lstore 13
    //   604: aconst_null
    //   605: astore_1
    //   606: iload 7
    //   608: istore_2
    //   609: iconst_0
    //   610: istore 7
    //   612: goto +83 -> 695
    //   615: astore_0
    //   616: aconst_null
    //   617: astore_1
    //   618: iload 9
    //   620: istore_2
    //   621: iconst_0
    //   622: istore 6
    //   624: iconst_0
    //   625: istore 7
    //   627: aload_0
    //   628: invokevirtual 167	java/lang/Throwable:printStackTrace	()V
    //   631: ldc 67
    //   633: iconst_1
    //   634: ldc_w 548
    //   637: aload_0
    //   638: invokestatic 172	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   641: iload_2
    //   642: ifeq +7 -> 649
    //   645: invokestatic 353	com/tencent/mobileqq/qrscan/utils/ScannerUtils:b	()I
    //   648: pop
    //   649: iload 7
    //   651: ifeq +11 -> 662
    //   654: lload 13
    //   656: ldc_w 544
    //   659: invokestatic 355	com/tencent/mobileqq/qrscan/utils/ScannerUtils:b	(JLjava/lang/String;)V
    //   662: aload_1
    //   663: ifnull +25 -> 688
    //   666: aload_1
    //   667: invokevirtual 104	java/io/InputStream:close	()V
    //   670: iload 6
    //   672: ireturn
    //   673: astore_0
    //   674: aload_0
    //   675: invokevirtual 167	java/lang/Throwable:printStackTrace	()V
    //   678: ldc 67
    //   680: iconst_1
    //   681: ldc_w 527
    //   684: aload_0
    //   685: invokestatic 172	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   688: iload 6
    //   690: ireturn
    //   691: astore_0
    //   692: goto -80 -> 612
    //   695: iload_2
    //   696: ifeq +7 -> 703
    //   699: invokestatic 353	com/tencent/mobileqq/qrscan/utils/ScannerUtils:b	()I
    //   702: pop
    //   703: iload 7
    //   705: ifeq +11 -> 716
    //   708: lload 13
    //   710: ldc_w 544
    //   713: invokestatic 355	com/tencent/mobileqq/qrscan/utils/ScannerUtils:b	(JLjava/lang/String;)V
    //   716: aload_1
    //   717: ifnull +25 -> 742
    //   720: aload_1
    //   721: invokevirtual 104	java/io/InputStream:close	()V
    //   724: goto +18 -> 742
    //   727: astore_1
    //   728: aload_1
    //   729: invokevirtual 167	java/lang/Throwable:printStackTrace	()V
    //   732: ldc 67
    //   734: iconst_1
    //   735: ldc_w 527
    //   738: aload_1
    //   739: invokestatic 172	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   742: goto +5 -> 747
    //   745: aload_0
    //   746: athrow
    //   747: goto -2 -> 745
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	750	0	paramUri	Uri
    //   0	750	1	paramContext	Context
    //   0	750	2	paramInt	int
    //   0	750	3	paramScannerResult	ScannerResult
    //   179	5	4	d	double
    //   10	679	6	i	int
    //   1	703	7	j	int
    //   4	552	8	k	int
    //   7	612	9	m	int
    //   102	346	10	n	int
    //   109	341	11	i1	int
    //   166	244	12	i2	int
    //   18	691	13	l1	long
    //   295	35	15	l2	long
    //   299	47	17	l3	long
    //   152	3	19	bool	boolean
    //   32	558	20	localObject1	Object
    //   13	337	21	localObject2	Object
    //   75	347	22	localObject3	Object
    //   24	209	23	localContentResolver	android.content.ContentResolver
    // Exception table:
    //   from	to	target	type
    //   44	49	51	java/lang/Throwable
    //   181	199	202	finally
    //   273	277	202	finally
    //   181	199	216	java/lang/Throwable
    //   273	277	216	java/lang/Throwable
    //   301	306	328	finally
    //   314	322	328	finally
    //   301	306	341	java/lang/Throwable
    //   314	322	341	java/lang/Throwable
    //   438	457	466	finally
    //   438	457	475	java/lang/Throwable
    //   421	426	504	java/lang/Throwable
    //   402	417	508	finally
    //   421	426	508	finally
    //   402	417	512	java/lang/Throwable
    //   363	402	516	finally
    //   363	402	525	java/lang/Throwable
    //   240	255	543	finally
    //   240	255	561	java/lang/Throwable
    //   68	97	573	finally
    //   68	97	588	java/lang/Throwable
    //   20	34	598	finally
    //   97	117	598	finally
    //   135	154	598	finally
    //   226	232	598	finally
    //   232	240	598	finally
    //   20	34	615	java/lang/Throwable
    //   97	117	615	java/lang/Throwable
    //   135	154	615	java/lang/Throwable
    //   226	232	615	java/lang/Throwable
    //   232	240	615	java/lang/Throwable
    //   666	670	673	java/lang/Throwable
    //   627	641	691	finally
    //   720	724	727	java/lang/Throwable
  }
  
  private static void b(long paramLong, String paramString)
  {
    ((IMiniCodeApi)QRoute.api(IMiniCodeApi.class)).unInit(paramLong, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.utils.ScannerUtils
 * JD-Core Version:    0.7.0.1
 */