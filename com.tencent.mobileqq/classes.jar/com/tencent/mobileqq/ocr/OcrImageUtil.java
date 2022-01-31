package com.tencent.mobileqq.ocr;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.ocr.data.OcrDpc;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OcrImageUtil
{
  public static String a;
  public static boolean a;
  public static String b;
  
  static
  {
    jdField_a_of_type_Boolean = true;
    File localFile = new File(AppConstants.aK, "ocr");
    jdField_a_of_type_JavaLangString = localFile.getAbsolutePath();
    if ((!localFile.exists()) && (!localFile.mkdir()))
    {
      jdField_a_of_type_Boolean = false;
      QLog.d("Q.ocr.image", 1, "WTF! mk ocr dir failed!");
    }
    if (localFile.exists())
    {
      localFile = new File(jdField_a_of_type_JavaLangString, "preview");
      b = localFile.getAbsolutePath();
      if ((!localFile.exists()) && (!localFile.mkdir())) {
        QLog.d("Q.ocr.image", 1, "WTF! mk ocr preview dir failed!");
      }
    }
  }
  
  public static Bitmap a(String paramString, BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    Object localObject = null;
    try
    {
      Bitmap localBitmap = BitmapFactory.decodeFile(paramString, paramOptions);
      localObject = localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      while (paramInt1 >= paramInt2) {}
      paramOptions.inSampleSize += 1;
    }
    return localObject;
    return a(paramString, paramOptions, paramInt1 + 1, paramInt2);
  }
  
  private static String a()
  {
    try
    {
      Object localObject = new SimpleDateFormat("yyyyMMddHHmmss");
      Date localDate = new Date(System.currentTimeMillis());
      localObject = ((SimpleDateFormat)localObject).format(localDate) + ".jpg";
      return localObject;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  public static String a(String paramString, boolean paramBoolean)
  {
    try
    {
      Object localObject = new File(jdField_a_of_type_JavaLangString);
      File localFile = new File(b);
      if ((!((File)localObject).exists()) && (!((File)localObject).mkdir())) {
        QLog.d("Q.ocr.image", 1, "getImagePath WTF! mk ocr dir failed!");
      }
      if ((!localFile.exists()) && (!localFile.mkdir())) {
        QLog.d("Q.ocr.image", 1, "getImagePath WTF! mk ocr preview dir failed!");
      }
      if (paramBoolean) {}
      for (localObject = b;; localObject = jdField_a_of_type_JavaLangString) {
        return new File((String)localObject, paramString).getAbsolutePath();
      }
      return null;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static String a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    return a(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, null, false);
  }
  
  /* Error */
  public static String a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, android.graphics.RectF paramRectF, boolean paramBoolean)
  {
    // Byte code:
    //   0: invokestatic 130	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +85 -> 88
    //   6: aload_0
    //   7: ifnull +87 -> 94
    //   10: aload_0
    //   11: arraylength
    //   12: i2l
    //   13: lstore 9
    //   15: ldc 40
    //   17: iconst_2
    //   18: new 96	java/lang/StringBuilder
    //   21: dup
    //   22: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   25: ldc 132
    //   27: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: lload 9
    //   32: invokevirtual 135	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   35: ldc 137
    //   37: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: iload_2
    //   41: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   44: ldc 142
    //   46: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: iload_1
    //   50: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   53: ldc 144
    //   55: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: iload_3
    //   59: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   62: ldc 146
    //   64: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: iload 5
    //   69: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   72: ldc 148
    //   74: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: aload 6
    //   79: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   82: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   85: invokestatic 48	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   88: aload_0
    //   89: ifnonnull +11 -> 100
    //   92: aconst_null
    //   93: areturn
    //   94: lconst_0
    //   95: lstore 9
    //   97: goto -82 -> 15
    //   100: invokestatic 153	com/tencent/mobileqq/ocr/OcrImageUtil:a	()Ljava/lang/String;
    //   103: iconst_1
    //   104: invokestatic 155	com/tencent/mobileqq/ocr/OcrImageUtil:a	(Ljava/lang/String;Z)Ljava/lang/String;
    //   107: astore 13
    //   109: iload 7
    //   111: ifeq +22 -> 133
    //   114: aload_0
    //   115: astore 11
    //   117: aload 11
    //   119: ifnonnull +86 -> 205
    //   122: ldc 40
    //   124: iconst_1
    //   125: ldc 157
    //   127: invokestatic 48	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   130: aload 13
    //   132: areturn
    //   133: iload_2
    //   134: ifle +19 -> 153
    //   137: iload_1
    //   138: ifle +15 -> 153
    //   141: iload_3
    //   142: bipush 17
    //   144: if_icmpeq +19 -> 163
    //   147: iload_3
    //   148: bipush 20
    //   150: if_icmpeq +13 -> 163
    //   153: ldc 40
    //   155: iconst_1
    //   156: ldc 159
    //   158: invokestatic 48	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   161: aconst_null
    //   162: areturn
    //   163: aload 13
    //   165: new 161	android/graphics/YuvImage
    //   168: dup
    //   169: aload_0
    //   170: iload_3
    //   171: iload_1
    //   172: iload_2
    //   173: aconst_null
    //   174: invokespecial 164	android/graphics/YuvImage:<init>	([BIII[I)V
    //   177: bipush 100
    //   179: invokestatic 167	com/tencent/mobileqq/ocr/OcrImageUtil:a	(Ljava/lang/String;Landroid/graphics/YuvImage;I)Z
    //   182: ifne +13 -> 195
    //   185: ldc 40
    //   187: iconst_1
    //   188: ldc 169
    //   190: invokestatic 48	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   193: aconst_null
    //   194: areturn
    //   195: aload 13
    //   197: invokestatic 172	com/tencent/mobileqq/ocr/OcrImageUtil:a	(Ljava/lang/String;)[B
    //   200: astore 11
    //   202: goto -85 -> 117
    //   205: aconst_null
    //   206: astore 12
    //   208: aload 12
    //   210: astore_0
    //   211: aload 11
    //   213: new 174	android/graphics/Rect
    //   216: dup
    //   217: iconst_0
    //   218: iconst_0
    //   219: getstatic 178	com/tencent/mobileqq/shortvideo/util/ScreenUtil:a	I
    //   222: getstatic 180	com/tencent/mobileqq/shortvideo/util/ScreenUtil:b	I
    //   225: invokespecial 183	android/graphics/Rect:<init>	(IIII)V
    //   228: iconst_0
    //   229: iconst_0
    //   230: invokestatic 188	com/tencent/mobileqq/camera/utils/CameraUtils:a	([BLandroid/graphics/Rect;ZI)Landroid/graphics/Bitmap;
    //   233: astore 14
    //   235: aload 14
    //   237: ifnonnull +46 -> 283
    //   240: aload 12
    //   242: astore_0
    //   243: ldc 40
    //   245: iconst_1
    //   246: ldc 190
    //   248: invokestatic 48	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   251: new 14	java/io/File
    //   254: dup
    //   255: aload 13
    //   257: invokespecial 115	java/io/File:<init>	(Ljava/lang/String;)V
    //   260: invokevirtual 35	java/io/File:exists	()Z
    //   263: ifeq +17 -> 280
    //   266: iconst_0
    //   267: ifeq +13 -> 280
    //   270: getstatic 196	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   273: aload 13
    //   275: aconst_null
    //   276: invokevirtual 202	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   279: pop
    //   280: aload 13
    //   282: areturn
    //   283: aload 12
    //   285: astore_0
    //   286: invokestatic 207	com/tencent/mobileqq/camera/CameraHolder:a	()Lcom/tencent/mobileqq/camera/CameraHolder;
    //   289: iload 4
    //   291: iload 5
    //   293: invokestatic 210	com/tencent/mobileqq/camera/utils/CameraUtils:a	(Lcom/tencent/mobileqq/camera/CameraHolder;II)I
    //   296: istore_3
    //   297: aload 12
    //   299: astore_0
    //   300: aload 14
    //   302: iload_3
    //   303: iconst_1
    //   304: invokestatic 213	com/tencent/mobileqq/camera/utils/CameraUtils:a	(Landroid/graphics/Bitmap;IZ)Landroid/graphics/Bitmap;
    //   307: astore 11
    //   309: aload 11
    //   311: astore_0
    //   312: aload_0
    //   313: astore 11
    //   315: invokestatic 130	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   318: ifeq +31 -> 349
    //   321: aload_0
    //   322: astore 11
    //   324: ldc 40
    //   326: iconst_2
    //   327: new 96	java/lang/StringBuilder
    //   330: dup
    //   331: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   334: ldc 215
    //   336: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: iload_3
    //   340: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   343: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   346: invokestatic 48	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   349: aload 6
    //   351: ifnull +388 -> 739
    //   354: aload_0
    //   355: ifnull +384 -> 739
    //   358: iload_1
    //   359: istore 4
    //   361: iload_2
    //   362: istore_3
    //   363: iload_1
    //   364: iload_2
    //   365: if_icmple +27 -> 392
    //   368: iload_1
    //   369: istore 4
    //   371: iload_2
    //   372: istore_3
    //   373: aload_0
    //   374: astore 11
    //   376: aload_0
    //   377: invokevirtual 221	android/graphics/Bitmap:getWidth	()I
    //   380: aload_0
    //   381: invokevirtual 224	android/graphics/Bitmap:getHeight	()I
    //   384: if_icmpge +8 -> 392
    //   387: iload_1
    //   388: istore_3
    //   389: iload_2
    //   390: istore 4
    //   392: aload_0
    //   393: astore 11
    //   395: aload 6
    //   397: getfield 230	android/graphics/RectF:left	F
    //   400: iload 4
    //   402: i2f
    //   403: fmul
    //   404: ldc 231
    //   406: fadd
    //   407: iload 4
    //   409: aload_0
    //   410: invokevirtual 221	android/graphics/Bitmap:getWidth	()I
    //   413: isub
    //   414: iconst_2
    //   415: idiv
    //   416: i2f
    //   417: fsub
    //   418: f2i
    //   419: istore_1
    //   420: aload_0
    //   421: astore 11
    //   423: aload 6
    //   425: getfield 234	android/graphics/RectF:top	F
    //   428: iload_3
    //   429: i2f
    //   430: fmul
    //   431: ldc 231
    //   433: fadd
    //   434: iload_3
    //   435: aload_0
    //   436: invokevirtual 224	android/graphics/Bitmap:getHeight	()I
    //   439: isub
    //   440: iconst_2
    //   441: idiv
    //   442: i2f
    //   443: fsub
    //   444: f2i
    //   445: istore 5
    //   447: iload_1
    //   448: ifgt +209 -> 657
    //   451: aload_0
    //   452: astore 11
    //   454: aload_0
    //   455: invokevirtual 221	android/graphics/Bitmap:getWidth	()I
    //   458: istore_2
    //   459: iconst_0
    //   460: istore_1
    //   461: iload 5
    //   463: ifgt +214 -> 677
    //   466: iconst_0
    //   467: istore_3
    //   468: aload_0
    //   469: astore 11
    //   471: aload_0
    //   472: invokevirtual 224	android/graphics/Bitmap:getHeight	()I
    //   475: istore 4
    //   477: aload_0
    //   478: astore 11
    //   480: aload_0
    //   481: iload_1
    //   482: iload_3
    //   483: iload_2
    //   484: iload 4
    //   486: invokestatic 238	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIII)Landroid/graphics/Bitmap;
    //   489: astore 12
    //   491: aload 12
    //   493: astore 6
    //   495: aload_0
    //   496: astore 11
    //   498: invokestatic 130	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   501: ifeq +62 -> 563
    //   504: aload_0
    //   505: astore 11
    //   507: ldc 40
    //   509: iconst_2
    //   510: iconst_3
    //   511: anewarray 4	java/lang/Object
    //   514: dup
    //   515: iconst_0
    //   516: new 96	java/lang/StringBuilder
    //   519: dup
    //   520: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   523: ldc 240
    //   525: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   528: aload 12
    //   530: invokevirtual 221	android/graphics/Bitmap:getWidth	()I
    //   533: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   536: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   539: aastore
    //   540: dup
    //   541: iconst_1
    //   542: ldc 242
    //   544: aastore
    //   545: dup
    //   546: iconst_2
    //   547: aload 12
    //   549: invokevirtual 224	android/graphics/Bitmap:getHeight	()I
    //   552: invokestatic 248	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   555: aastore
    //   556: invokestatic 251	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   559: aload 12
    //   561: astore 6
    //   563: aload 6
    //   565: ifnonnull +180 -> 745
    //   568: aload 6
    //   570: astore_0
    //   571: aload 6
    //   573: astore 11
    //   575: aload 14
    //   577: bipush 100
    //   579: new 14	java/io/File
    //   582: dup
    //   583: aload 13
    //   585: invokespecial 115	java/io/File:<init>	(Ljava/lang/String;)V
    //   588: invokestatic 256	com/tencent/mobileqq/utils/ImageUtil:a	(Landroid/graphics/Bitmap;ILjava/io/File;)Z
    //   591: pop
    //   592: aload 6
    //   594: astore_0
    //   595: aload 6
    //   597: astore 11
    //   599: ldc 40
    //   601: iconst_1
    //   602: ldc_w 258
    //   605: invokestatic 48	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   608: new 14	java/io/File
    //   611: dup
    //   612: aload 13
    //   614: invokespecial 115	java/io/File:<init>	(Ljava/lang/String;)V
    //   617: invokevirtual 35	java/io/File:exists	()Z
    //   620: ifeq +19 -> 639
    //   623: aload 6
    //   625: ifnull +14 -> 639
    //   628: getstatic 196	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   631: aload 13
    //   633: aload 6
    //   635: invokevirtual 202	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   638: pop
    //   639: new 14	java/io/File
    //   642: dup
    //   643: aload 13
    //   645: invokespecial 115	java/io/File:<init>	(Ljava/lang/String;)V
    //   648: invokevirtual 35	java/io/File:exists	()Z
    //   651: ifeq +264 -> 915
    //   654: aload 13
    //   656: areturn
    //   657: aload_0
    //   658: astore 11
    //   660: aload 6
    //   662: invokevirtual 262	android/graphics/RectF:width	()F
    //   665: iload 4
    //   667: i2f
    //   668: fmul
    //   669: ldc 231
    //   671: fadd
    //   672: f2i
    //   673: istore_2
    //   674: goto -213 -> 461
    //   677: aload_0
    //   678: astore 11
    //   680: aload 6
    //   682: invokevirtual 265	android/graphics/RectF:height	()F
    //   685: fstore 8
    //   687: fload 8
    //   689: iload_3
    //   690: i2f
    //   691: fmul
    //   692: ldc 231
    //   694: fadd
    //   695: f2i
    //   696: istore 4
    //   698: iload 5
    //   700: istore_3
    //   701: goto -224 -> 477
    //   704: astore 6
    //   706: aload_0
    //   707: astore 11
    //   709: ldc 40
    //   711: iconst_1
    //   712: new 96	java/lang/StringBuilder
    //   715: dup
    //   716: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   719: ldc_w 267
    //   722: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   725: aload 6
    //   727: invokevirtual 270	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   730: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   733: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   736: invokestatic 273	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   739: aload_0
    //   740: astore 6
    //   742: goto -179 -> 563
    //   745: aload 6
    //   747: astore_0
    //   748: aload 6
    //   750: astore 11
    //   752: aload 6
    //   754: bipush 100
    //   756: new 14	java/io/File
    //   759: dup
    //   760: aload 13
    //   762: invokespecial 115	java/io/File:<init>	(Ljava/lang/String;)V
    //   765: invokestatic 256	com/tencent/mobileqq/utils/ImageUtil:a	(Landroid/graphics/Bitmap;ILjava/io/File;)Z
    //   768: pop
    //   769: goto -161 -> 608
    //   772: astore 6
    //   774: aload_0
    //   775: astore 11
    //   777: ldc 40
    //   779: iconst_1
    //   780: ldc_w 275
    //   783: invokestatic 273	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   786: aload_0
    //   787: astore 11
    //   789: aload_0
    //   790: invokestatic 278	com/tencent/mobileqq/camera/utils/CameraUtils:a	(Landroid/graphics/Bitmap;)Z
    //   793: pop
    //   794: new 14	java/io/File
    //   797: dup
    //   798: aload 13
    //   800: invokespecial 115	java/io/File:<init>	(Ljava/lang/String;)V
    //   803: invokevirtual 35	java/io/File:exists	()Z
    //   806: ifeq -167 -> 639
    //   809: aload_0
    //   810: ifnull -171 -> 639
    //   813: getstatic 196	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   816: aload 13
    //   818: aload_0
    //   819: invokevirtual 202	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   822: pop
    //   823: goto -184 -> 639
    //   826: astore 6
    //   828: aconst_null
    //   829: astore_0
    //   830: aload_0
    //   831: astore 11
    //   833: aload 6
    //   835: invokevirtual 279	java/io/IOException:printStackTrace	()V
    //   838: aload_0
    //   839: astore 11
    //   841: aload_0
    //   842: invokestatic 278	com/tencent/mobileqq/camera/utils/CameraUtils:a	(Landroid/graphics/Bitmap;)Z
    //   845: pop
    //   846: new 14	java/io/File
    //   849: dup
    //   850: aload 13
    //   852: invokespecial 115	java/io/File:<init>	(Ljava/lang/String;)V
    //   855: invokevirtual 35	java/io/File:exists	()Z
    //   858: ifeq -219 -> 639
    //   861: aload_0
    //   862: ifnull -223 -> 639
    //   865: getstatic 196	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   868: aload 13
    //   870: aload_0
    //   871: invokevirtual 202	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   874: pop
    //   875: goto -236 -> 639
    //   878: astore_0
    //   879: aconst_null
    //   880: astore 11
    //   882: new 14	java/io/File
    //   885: dup
    //   886: aload 13
    //   888: invokespecial 115	java/io/File:<init>	(Ljava/lang/String;)V
    //   891: invokevirtual 35	java/io/File:exists	()Z
    //   894: ifeq +19 -> 913
    //   897: aload 11
    //   899: ifnull +14 -> 913
    //   902: getstatic 196	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   905: aload 13
    //   907: aload 11
    //   909: invokevirtual 202	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   912: pop
    //   913: aload_0
    //   914: athrow
    //   915: aconst_null
    //   916: areturn
    //   917: astore_0
    //   918: goto -36 -> 882
    //   921: astore_0
    //   922: goto -40 -> 882
    //   925: astore 6
    //   927: goto -97 -> 830
    //   930: astore 11
    //   932: aload 6
    //   934: astore_0
    //   935: aload 11
    //   937: astore 6
    //   939: goto -109 -> 830
    //   942: astore 6
    //   944: goto -170 -> 774
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	947	0	paramArrayOfByte	byte[]
    //   0	947	1	paramInt1	int
    //   0	947	2	paramInt2	int
    //   0	947	3	paramInt3	int
    //   0	947	4	paramInt4	int
    //   0	947	5	paramInt5	int
    //   0	947	6	paramRectF	android.graphics.RectF
    //   0	947	7	paramBoolean	boolean
    //   685	3	8	f	float
    //   13	83	9	l	long
    //   115	793	11	localObject	Object
    //   930	6	11	localIOException	java.io.IOException
    //   206	354	12	localBitmap1	Bitmap
    //   107	799	13	str	String
    //   233	343	14	localBitmap2	Bitmap
    // Exception table:
    //   from	to	target	type
    //   376	387	704	java/lang/Throwable
    //   395	420	704	java/lang/Throwable
    //   423	447	704	java/lang/Throwable
    //   454	459	704	java/lang/Throwable
    //   471	477	704	java/lang/Throwable
    //   480	491	704	java/lang/Throwable
    //   498	504	704	java/lang/Throwable
    //   507	559	704	java/lang/Throwable
    //   660	674	704	java/lang/Throwable
    //   680	687	704	java/lang/Throwable
    //   211	235	772	java/lang/OutOfMemoryError
    //   243	251	772	java/lang/OutOfMemoryError
    //   286	297	772	java/lang/OutOfMemoryError
    //   300	309	772	java/lang/OutOfMemoryError
    //   575	592	772	java/lang/OutOfMemoryError
    //   599	608	772	java/lang/OutOfMemoryError
    //   752	769	772	java/lang/OutOfMemoryError
    //   211	235	826	java/io/IOException
    //   243	251	826	java/io/IOException
    //   286	297	826	java/io/IOException
    //   300	309	826	java/io/IOException
    //   211	235	878	finally
    //   243	251	878	finally
    //   286	297	878	finally
    //   300	309	878	finally
    //   315	321	917	finally
    //   324	349	917	finally
    //   376	387	917	finally
    //   395	420	917	finally
    //   423	447	917	finally
    //   454	459	917	finally
    //   471	477	917	finally
    //   480	491	917	finally
    //   498	504	917	finally
    //   507	559	917	finally
    //   660	674	917	finally
    //   680	687	917	finally
    //   709	739	917	finally
    //   833	838	917	finally
    //   841	846	917	finally
    //   575	592	921	finally
    //   599	608	921	finally
    //   752	769	921	finally
    //   777	786	921	finally
    //   789	794	921	finally
    //   315	321	925	java/io/IOException
    //   324	349	925	java/io/IOException
    //   376	387	925	java/io/IOException
    //   395	420	925	java/io/IOException
    //   423	447	925	java/io/IOException
    //   454	459	925	java/io/IOException
    //   471	477	925	java/io/IOException
    //   480	491	925	java/io/IOException
    //   498	504	925	java/io/IOException
    //   507	559	925	java/io/IOException
    //   660	674	925	java/io/IOException
    //   680	687	925	java/io/IOException
    //   709	739	925	java/io/IOException
    //   575	592	930	java/io/IOException
    //   599	608	930	java/io/IOException
    //   752	769	930	java/io/IOException
    //   315	321	942	java/lang/OutOfMemoryError
    //   324	349	942	java/lang/OutOfMemoryError
    //   376	387	942	java/lang/OutOfMemoryError
    //   395	420	942	java/lang/OutOfMemoryError
    //   423	447	942	java/lang/OutOfMemoryError
    //   454	459	942	java/lang/OutOfMemoryError
    //   471	477	942	java/lang/OutOfMemoryError
    //   480	491	942	java/lang/OutOfMemoryError
    //   498	504	942	java/lang/OutOfMemoryError
    //   507	559	942	java/lang/OutOfMemoryError
    //   660	674	942	java/lang/OutOfMemoryError
    //   680	687	942	java/lang/OutOfMemoryError
    //   709	739	942	java/lang/OutOfMemoryError
  }
  
  /* Error */
  public static boolean a(Bitmap paramBitmap, String paramString, Bitmap.CompressFormat paramCompressFormat, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: new 14	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 115	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore 8
    //   10: aconst_null
    //   11: astore 9
    //   13: aconst_null
    //   14: astore 10
    //   16: new 282	java/io/BufferedOutputStream
    //   19: dup
    //   20: new 284	java/io/FileOutputStream
    //   23: dup
    //   24: aload 8
    //   26: invokespecial 287	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   29: invokespecial 290	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   32: astore 8
    //   34: aload 8
    //   36: astore 9
    //   38: aload_0
    //   39: aload_2
    //   40: iload_3
    //   41: aload 8
    //   43: invokevirtual 294	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   46: istore 5
    //   48: aload 8
    //   50: astore 9
    //   52: aload 8
    //   54: invokevirtual 297	java/io/BufferedOutputStream:flush	()V
    //   57: iload 4
    //   59: ifeq +11 -> 70
    //   62: aload 8
    //   64: astore 9
    //   66: aload_0
    //   67: invokevirtual 300	android/graphics/Bitmap:recycle	()V
    //   70: iload 5
    //   72: istore 4
    //   74: aload 8
    //   76: ifnull +12 -> 88
    //   79: aload 8
    //   81: invokevirtual 303	java/io/BufferedOutputStream:close	()V
    //   84: iload 5
    //   86: istore 4
    //   88: invokestatic 130	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   91: ifeq +99 -> 190
    //   94: lconst_0
    //   95: lstore 6
    //   97: new 14	java/io/File
    //   100: dup
    //   101: aload_1
    //   102: invokespecial 115	java/io/File:<init>	(Ljava/lang/String;)V
    //   105: invokevirtual 35	java/io/File:exists	()Z
    //   108: ifeq +20 -> 128
    //   111: new 14	java/io/File
    //   114: dup
    //   115: aload_1
    //   116: invokespecial 115	java/io/File:<init>	(Ljava/lang/String;)V
    //   119: invokevirtual 306	java/io/File:length	()J
    //   122: ldc2_w 307
    //   125: ldiv
    //   126: lstore 6
    //   128: ldc 40
    //   130: iconst_2
    //   131: new 96	java/lang/StringBuilder
    //   134: dup
    //   135: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   138: ldc_w 310
    //   141: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: aload_1
    //   145: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: ldc 144
    //   150: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: aload_2
    //   154: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   157: ldc_w 312
    //   160: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: iload_3
    //   164: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   167: ldc_w 314
    //   170: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: lload 6
    //   175: invokevirtual 135	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   178: ldc_w 316
    //   181: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   187: invokestatic 48	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   190: iload 4
    //   192: ireturn
    //   193: astore_0
    //   194: aload_0
    //   195: invokevirtual 279	java/io/IOException:printStackTrace	()V
    //   198: iload 5
    //   200: istore 4
    //   202: goto -114 -> 88
    //   205: astore_0
    //   206: aconst_null
    //   207: astore 8
    //   209: iconst_0
    //   210: istore 5
    //   212: aload 8
    //   214: astore 9
    //   216: ldc 40
    //   218: iconst_1
    //   219: ldc_w 318
    //   222: aload_0
    //   223: invokestatic 321	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   226: iload 5
    //   228: istore 4
    //   230: aload 8
    //   232: ifnull -144 -> 88
    //   235: aload 8
    //   237: invokevirtual 303	java/io/BufferedOutputStream:close	()V
    //   240: iload 5
    //   242: istore 4
    //   244: goto -156 -> 88
    //   247: astore_0
    //   248: aload_0
    //   249: invokevirtual 279	java/io/IOException:printStackTrace	()V
    //   252: iload 5
    //   254: istore 4
    //   256: goto -168 -> 88
    //   259: astore_0
    //   260: iconst_0
    //   261: istore 5
    //   263: aload 10
    //   265: astore_0
    //   266: aload_0
    //   267: astore 9
    //   269: ldc 40
    //   271: iconst_1
    //   272: ldc_w 323
    //   275: invokestatic 273	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   278: iload 5
    //   280: istore 4
    //   282: aload_0
    //   283: ifnull -195 -> 88
    //   286: aload_0
    //   287: invokevirtual 303	java/io/BufferedOutputStream:close	()V
    //   290: iload 5
    //   292: istore 4
    //   294: goto -206 -> 88
    //   297: astore_0
    //   298: aload_0
    //   299: invokevirtual 279	java/io/IOException:printStackTrace	()V
    //   302: iload 5
    //   304: istore 4
    //   306: goto -218 -> 88
    //   309: astore_0
    //   310: aload 9
    //   312: ifnull +8 -> 320
    //   315: aload 9
    //   317: invokevirtual 303	java/io/BufferedOutputStream:close	()V
    //   320: aload_0
    //   321: athrow
    //   322: astore_1
    //   323: aload_1
    //   324: invokevirtual 279	java/io/IOException:printStackTrace	()V
    //   327: goto -7 -> 320
    //   330: astore_0
    //   331: goto -21 -> 310
    //   334: astore_0
    //   335: aload 8
    //   337: astore_0
    //   338: iconst_0
    //   339: istore 5
    //   341: goto -75 -> 266
    //   344: astore_0
    //   345: aload 8
    //   347: astore_0
    //   348: goto -82 -> 266
    //   351: astore_0
    //   352: iconst_0
    //   353: istore 5
    //   355: goto -143 -> 212
    //   358: astore_0
    //   359: goto -147 -> 212
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	362	0	paramBitmap	Bitmap
    //   0	362	1	paramString	String
    //   0	362	2	paramCompressFormat	Bitmap.CompressFormat
    //   0	362	3	paramInt	int
    //   0	362	4	paramBoolean	boolean
    //   46	308	5	bool	boolean
    //   95	79	6	l	long
    //   8	338	8	localObject1	Object
    //   11	305	9	localObject2	Object
    //   14	250	10	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   79	84	193	java/io/IOException
    //   16	34	205	java/lang/Exception
    //   235	240	247	java/io/IOException
    //   16	34	259	java/lang/OutOfMemoryError
    //   286	290	297	java/io/IOException
    //   16	34	309	finally
    //   269	278	309	finally
    //   315	320	322	java/io/IOException
    //   38	48	330	finally
    //   52	57	330	finally
    //   66	70	330	finally
    //   216	226	330	finally
    //   38	48	334	java/lang/OutOfMemoryError
    //   52	57	344	java/lang/OutOfMemoryError
    //   66	70	344	java/lang/OutOfMemoryError
    //   38	48	351	java/lang/Exception
    //   52	57	358	java/lang/Exception
    //   66	70	358	java/lang/Exception
  }
  
  public static boolean a(String paramString)
  {
    paramString = PhotoUtils.a(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("Q.ocr.image", 2, "checkImageFormat format:" + paramString);
    }
    return (!TextUtils.isEmpty(paramString)) || ("image/bmp".equalsIgnoreCase(paramString)) || ("image/jpeg".equalsIgnoreCase(paramString)) || ("image/png".equalsIgnoreCase(paramString));
  }
  
  /* Error */
  public static boolean a(String paramString, android.graphics.YuvImage paramYuvImage, int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: new 284	java/io/FileOutputStream
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 349	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   10: astore 5
    //   12: aload_1
    //   13: ifnull +31 -> 44
    //   16: aload 5
    //   18: astore_0
    //   19: aload_1
    //   20: new 174	android/graphics/Rect
    //   23: dup
    //   24: iconst_0
    //   25: iconst_0
    //   26: aload_1
    //   27: invokevirtual 350	android/graphics/YuvImage:getWidth	()I
    //   30: aload_1
    //   31: invokevirtual 351	android/graphics/YuvImage:getHeight	()I
    //   34: invokespecial 183	android/graphics/Rect:<init>	(IIII)V
    //   37: iload_2
    //   38: aload 5
    //   40: invokevirtual 355	android/graphics/YuvImage:compressToJpeg	(Landroid/graphics/Rect;ILjava/io/OutputStream;)Z
    //   43: pop
    //   44: aload 5
    //   46: astore_0
    //   47: aload 5
    //   49: invokevirtual 356	java/io/FileOutputStream:flush	()V
    //   52: iconst_1
    //   53: istore 4
    //   55: iload 4
    //   57: istore_3
    //   58: aload 5
    //   60: ifnull +11 -> 71
    //   63: aload 5
    //   65: invokevirtual 357	java/io/FileOutputStream:close	()V
    //   68: iload 4
    //   70: istore_3
    //   71: iload_3
    //   72: ireturn
    //   73: astore_0
    //   74: aload_0
    //   75: invokevirtual 279	java/io/IOException:printStackTrace	()V
    //   78: iconst_1
    //   79: ireturn
    //   80: astore 6
    //   82: aconst_null
    //   83: astore_1
    //   84: aload_1
    //   85: astore_0
    //   86: aload 6
    //   88: invokevirtual 113	java/lang/Exception:printStackTrace	()V
    //   91: aload_1
    //   92: ifnull -21 -> 71
    //   95: aload_1
    //   96: invokevirtual 357	java/io/FileOutputStream:close	()V
    //   99: iconst_0
    //   100: ireturn
    //   101: astore_0
    //   102: aload_0
    //   103: invokevirtual 279	java/io/IOException:printStackTrace	()V
    //   106: iconst_0
    //   107: ireturn
    //   108: astore_1
    //   109: aconst_null
    //   110: astore_0
    //   111: aload_0
    //   112: ifnull +7 -> 119
    //   115: aload_0
    //   116: invokevirtual 357	java/io/FileOutputStream:close	()V
    //   119: aload_1
    //   120: athrow
    //   121: astore_0
    //   122: aload_0
    //   123: invokevirtual 279	java/io/IOException:printStackTrace	()V
    //   126: goto -7 -> 119
    //   129: astore_1
    //   130: goto -19 -> 111
    //   133: astore 6
    //   135: aload 5
    //   137: astore_1
    //   138: goto -54 -> 84
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	141	0	paramString	String
    //   0	141	1	paramYuvImage	android.graphics.YuvImage
    //   0	141	2	paramInt	int
    //   1	71	3	bool1	boolean
    //   53	16	4	bool2	boolean
    //   10	126	5	localFileOutputStream	java.io.FileOutputStream
    //   80	7	6	localException1	Exception
    //   133	1	6	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   63	68	73	java/io/IOException
    //   2	12	80	java/lang/Exception
    //   95	99	101	java/io/IOException
    //   2	12	108	finally
    //   115	119	121	java/io/IOException
    //   19	44	129	finally
    //   47	52	129	finally
    //   86	91	129	finally
    //   19	44	133	java/lang/Exception
    //   47	52	133	java/lang/Exception
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    int j = 10;
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString1, (BitmapFactory.Options)localObject);
    int n = ((BitmapFactory.Options)localObject).outHeight;
    int m = ((BitmapFactory.Options)localObject).outWidth;
    int i;
    label73:
    int k;
    if (OcrDpc.a() != null) {
      if (OcrDpc.a().c < 400)
      {
        i = 400;
        if (OcrDpc.a().b >= 10) {
          break label374;
        }
        k = i;
        i = j;
      }
    }
    for (;;)
    {
      float f;
      if ((m > n) && (n > k)) {
        f = k * 1.0F / n;
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.ocr.image", 2, "compressImage radio:" + f + ",source file size:" + new File(paramString1).length() + ",shortSide:" + k + ",picQuality:" + i);
        }
        j = (int)(n * f);
        k = (int)(m * f);
        Matrix localMatrix = new Matrix();
        localMatrix.setScale(f, f);
        ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
        localObject = a(paramString1, (BitmapFactory.Options)localObject, 1, 2);
        if (localObject != null)
        {
          if (((Bitmap)localObject).getHeight() <= j)
          {
            paramString1 = (String)localObject;
            if (((Bitmap)localObject).getWidth() <= k) {
              break label291;
            }
          }
          try
          {
            paramString1 = Bitmap.createBitmap((Bitmap)localObject, 0, 0, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight(), localMatrix, false);
            if ((localObject != null) && (!((Bitmap)localObject).isRecycled())) {
              ((Bitmap)localObject).recycle();
            }
          }
          catch (OutOfMemoryError paramString1)
          {
            for (;;)
            {
              paramString1.printStackTrace();
              paramString1 = (String)localObject;
            }
          }
          catch (Exception paramString1)
          {
            for (;;)
            {
              label291:
              label374:
              paramString1.printStackTrace();
              paramString1 = (String)localObject;
            }
          }
          if (paramString1 != null)
          {
            j = paramString1.getRowBytes();
            k = paramString1.getHeight();
            if (QLog.isColorLevel()) {
              QLog.d("Q.ocr.image", 2, "compressImage target bmp size:" + j * k / 1024 + "KB");
            }
            return a(paramString1, paramString2, Bitmap.CompressFormat.JPEG, i, true);
            i = OcrDpc.a().c;
            break;
            j = OcrDpc.a().b;
            break label73;
            if ((m >= n) || (m <= k)) {
              break label436;
            }
            f = k * 1.0F / m;
            continue;
          }
        }
        return false;
        label436:
        f = 1.0F;
      }
      i = 70;
      k = 800;
    }
  }
  
  /* Error */
  public static byte[] a(String paramString)
  {
    // Byte code:
    //   0: new 14	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 115	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: aload_0
    //   10: invokevirtual 306	java/io/File:length	()J
    //   13: l2i
    //   14: newarray byte
    //   16: astore_2
    //   17: new 419	java/io/BufferedInputStream
    //   20: dup
    //   21: new 421	java/io/FileInputStream
    //   24: dup
    //   25: aload_0
    //   26: invokespecial 422	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   29: invokespecial 425	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   32: astore_1
    //   33: aload_1
    //   34: astore_0
    //   35: aload_1
    //   36: aload_2
    //   37: iconst_0
    //   38: aload_2
    //   39: arraylength
    //   40: invokevirtual 429	java/io/BufferedInputStream:read	([BII)I
    //   43: pop
    //   44: aload_1
    //   45: astore_0
    //   46: aload_1
    //   47: invokevirtual 430	java/io/BufferedInputStream:close	()V
    //   50: aload_1
    //   51: invokevirtual 430	java/io/BufferedInputStream:close	()V
    //   54: aload_2
    //   55: astore_0
    //   56: aload_0
    //   57: ifnull +10 -> 67
    //   60: aload_0
    //   61: astore_1
    //   62: aload_0
    //   63: arraylength
    //   64: ifne +14 -> 78
    //   67: ldc 40
    //   69: iconst_1
    //   70: ldc_w 432
    //   73: invokestatic 48	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   76: aconst_null
    //   77: astore_1
    //   78: aload_1
    //   79: areturn
    //   80: astore_0
    //   81: aload_0
    //   82: invokevirtual 113	java/lang/Exception:printStackTrace	()V
    //   85: aload_2
    //   86: astore_0
    //   87: goto -31 -> 56
    //   90: astore_2
    //   91: aconst_null
    //   92: astore_1
    //   93: aload_1
    //   94: astore_0
    //   95: aload_2
    //   96: invokevirtual 433	java/io/FileNotFoundException:printStackTrace	()V
    //   99: aload_1
    //   100: invokevirtual 430	java/io/BufferedInputStream:close	()V
    //   103: aconst_null
    //   104: astore_0
    //   105: goto -49 -> 56
    //   108: astore_0
    //   109: aload_0
    //   110: invokevirtual 113	java/lang/Exception:printStackTrace	()V
    //   113: aconst_null
    //   114: astore_0
    //   115: goto -59 -> 56
    //   118: astore_2
    //   119: aconst_null
    //   120: astore_1
    //   121: aload_1
    //   122: astore_0
    //   123: aload_2
    //   124: invokevirtual 279	java/io/IOException:printStackTrace	()V
    //   127: aload_1
    //   128: invokevirtual 430	java/io/BufferedInputStream:close	()V
    //   131: aconst_null
    //   132: astore_0
    //   133: goto -77 -> 56
    //   136: astore_0
    //   137: aload_0
    //   138: invokevirtual 113	java/lang/Exception:printStackTrace	()V
    //   141: aconst_null
    //   142: astore_0
    //   143: goto -87 -> 56
    //   146: astore_1
    //   147: aconst_null
    //   148: astore_0
    //   149: aload_0
    //   150: invokevirtual 430	java/io/BufferedInputStream:close	()V
    //   153: aload_1
    //   154: athrow
    //   155: astore_0
    //   156: aload_0
    //   157: invokevirtual 113	java/lang/Exception:printStackTrace	()V
    //   160: goto -7 -> 153
    //   163: astore_1
    //   164: goto -15 -> 149
    //   167: astore_2
    //   168: goto -47 -> 121
    //   171: astore_2
    //   172: goto -79 -> 93
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	175	0	paramString	String
    //   32	96	1	localObject1	Object
    //   146	8	1	localObject2	Object
    //   163	1	1	localObject3	Object
    //   16	70	2	arrayOfByte	byte[]
    //   90	6	2	localFileNotFoundException1	java.io.FileNotFoundException
    //   118	6	2	localIOException1	java.io.IOException
    //   167	1	2	localIOException2	java.io.IOException
    //   171	1	2	localFileNotFoundException2	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   50	54	80	java/lang/Exception
    //   17	33	90	java/io/FileNotFoundException
    //   99	103	108	java/lang/Exception
    //   17	33	118	java/io/IOException
    //   127	131	136	java/lang/Exception
    //   17	33	146	finally
    //   149	153	155	java/lang/Exception
    //   35	44	163	finally
    //   46	50	163	finally
    //   95	99	163	finally
    //   123	127	163	finally
    //   35	44	167	java/io/IOException
    //   46	50	167	java/io/IOException
    //   35	44	171	java/io/FileNotFoundException
    //   46	50	171	java/io/FileNotFoundException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OcrImageUtil
 * JD-Core Version:    0.7.0.1
 */