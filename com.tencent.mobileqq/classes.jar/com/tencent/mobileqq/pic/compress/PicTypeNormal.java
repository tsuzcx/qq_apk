package com.tencent.mobileqq.pic.compress;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.Logger;

public class PicTypeNormal
  extends PicType
{
  public static final int l;
  
  static
  {
    Resources localResources = BaseApplicationImpl.sApplication.getResources();
    int i = localResources.getDisplayMetrics().heightPixels;
    int j = localResources.getDisplayMetrics().widthPixels;
    if (i > j) {}
    for (;;)
    {
      l = i;
      return;
      i = j;
    }
  }
  
  PicTypeNormal(CompressInfo paramCompressInfo)
  {
    super(paramCompressInfo);
  }
  
  protected int a(CompressInfo paramCompressInfo)
  {
    switch (paramCompressInfo.jdField_g_of_type_Int)
    {
    default: 
      return -1;
    case 0: 
    case 1: 
      return 0;
    }
    return 2;
  }
  
  protected final int[] a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_g_of_type_Int == 2) {
      return null;
    }
    int[] arrayOfInt = new int[2];
    int j = PicType.e;
    int i = j;
    if (j > l) {
      i = l;
    }
    arrayOfInt[0] = i;
    arrayOfInt[1] = (arrayOfInt[0] * 2);
    Logger.a("PicTypeNormal", "getScaleLargerSide", "PicType.SendPhotoMaxLongSide = " + arrayOfInt[0]);
    return arrayOfInt;
  }
  
  /* Error */
  protected boolean d()
  {
    // Byte code:
    //   0: fconst_1
    //   1: fstore_1
    //   2: iconst_0
    //   3: istore 6
    //   5: aload_0
    //   6: getfield 90	com/tencent/mobileqq/pic/compress/PicTypeNormal:k	I
    //   9: ifne +903 -> 912
    //   12: aload_0
    //   13: getfield 50	com/tencent/mobileqq/pic/compress/PicTypeNormal:jdField_a_of_type_ComTencentMobileqqPicCompressInfo	Lcom/tencent/mobileqq/pic/CompressInfo;
    //   16: getfield 93	com/tencent/mobileqq/pic/CompressInfo:jdField_g_of_type_Boolean	Z
    //   19: ifeq +105 -> 124
    //   22: aload_0
    //   23: getfield 50	com/tencent/mobileqq/pic/compress/PicTypeNormal:jdField_a_of_type_ComTencentMobileqqPicCompressInfo	Lcom/tencent/mobileqq/pic/CompressInfo;
    //   26: getfield 97	com/tencent/mobileqq/pic/CompressInfo:c	Ljava/lang/String;
    //   29: invokestatic 103	com/tencent/mobileqq/pic/compress/Utils:b	(Ljava/lang/String;)Z
    //   32: ifeq +92 -> 124
    //   35: aload_0
    //   36: getfield 50	com/tencent/mobileqq/pic/compress/PicTypeNormal:jdField_a_of_type_ComTencentMobileqqPicCompressInfo	Lcom/tencent/mobileqq/pic/CompressInfo;
    //   39: aload_0
    //   40: getfield 50	com/tencent/mobileqq/pic/compress/PicTypeNormal:jdField_a_of_type_ComTencentMobileqqPicCompressInfo	Lcom/tencent/mobileqq/pic/CompressInfo;
    //   43: getfield 97	com/tencent/mobileqq/pic/CompressInfo:c	Ljava/lang/String;
    //   46: putfield 105	com/tencent/mobileqq/pic/CompressInfo:e	Ljava/lang/String;
    //   49: aload_0
    //   50: getfield 50	com/tencent/mobileqq/pic/compress/PicTypeNormal:jdField_a_of_type_ComTencentMobileqqPicCompressInfo	Lcom/tencent/mobileqq/pic/CompressInfo;
    //   53: new 59	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   60: aload_0
    //   61: getfield 107	com/tencent/mobileqq/pic/compress/PicTypeNormal:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   64: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: aload_0
    //   68: getfield 50	com/tencent/mobileqq/pic/compress/PicTypeNormal:jdField_a_of_type_ComTencentMobileqqPicCompressInfo	Lcom/tencent/mobileqq/pic/CompressInfo;
    //   71: getfield 108	com/tencent/mobileqq/pic/CompressInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   74: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: ldc 110
    //   79: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   85: putfield 113	com/tencent/mobileqq/pic/CompressInfo:f	Ljava/lang/String;
    //   88: aload_0
    //   89: getfield 107	com/tencent/mobileqq/pic/compress/PicTypeNormal:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   92: new 59	java/lang/StringBuilder
    //   95: dup
    //   96: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   99: aload_0
    //   100: getfield 50	com/tencent/mobileqq/pic/compress/PicTypeNormal:jdField_a_of_type_ComTencentMobileqqPicCompressInfo	Lcom/tencent/mobileqq/pic/CompressInfo;
    //   103: getfield 108	com/tencent/mobileqq/pic/CompressInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   106: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: ldc 115
    //   111: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   117: ldc 117
    //   119: invokestatic 79	com/tencent/mobileqq/pic/Logger:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   122: iconst_1
    //   123: ireturn
    //   124: aload_0
    //   125: invokevirtual 119	com/tencent/mobileqq/pic/compress/PicTypeNormal:a	()[I
    //   128: astore 9
    //   130: aload 9
    //   132: ifnonnull +39 -> 171
    //   135: aload_0
    //   136: getfield 107	com/tencent/mobileqq/pic/compress/PicTypeNormal:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   139: ldc 121
    //   141: new 59	java/lang/StringBuilder
    //   144: dup
    //   145: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   148: aload_0
    //   149: getfield 50	com/tencent/mobileqq/pic/compress/PicTypeNormal:jdField_a_of_type_ComTencentMobileqqPicCompressInfo	Lcom/tencent/mobileqq/pic/CompressInfo;
    //   152: getfield 108	com/tencent/mobileqq/pic/CompressInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   155: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: ldc 123
    //   160: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   166: invokestatic 125	com/tencent/mobileqq/pic/Logger:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   169: iconst_0
    //   170: ireturn
    //   171: aload 9
    //   173: iconst_0
    //   174: iaload
    //   175: istore 7
    //   177: aload 9
    //   179: iconst_1
    //   180: iaload
    //   181: istore_2
    //   182: aload_0
    //   183: getfield 50	com/tencent/mobileqq/pic/compress/PicTypeNormal:jdField_a_of_type_ComTencentMobileqqPicCompressInfo	Lcom/tencent/mobileqq/pic/CompressInfo;
    //   186: aload_0
    //   187: getfield 50	com/tencent/mobileqq/pic/compress/PicTypeNormal:jdField_a_of_type_ComTencentMobileqqPicCompressInfo	Lcom/tencent/mobileqq/pic/CompressInfo;
    //   190: getfield 97	com/tencent/mobileqq/pic/CompressInfo:c	Ljava/lang/String;
    //   193: aload_0
    //   194: getfield 50	com/tencent/mobileqq/pic/compress/PicTypeNormal:jdField_a_of_type_ComTencentMobileqqPicCompressInfo	Lcom/tencent/mobileqq/pic/CompressInfo;
    //   197: getfield 46	com/tencent/mobileqq/pic/CompressInfo:jdField_g_of_type_Int	I
    //   200: invokestatic 128	com/tencent/mobileqq/pic/compress/Utils:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   203: putfield 105	com/tencent/mobileqq/pic/CompressInfo:e	Ljava/lang/String;
    //   206: aload_0
    //   207: getfield 50	com/tencent/mobileqq/pic/compress/PicTypeNormal:jdField_a_of_type_ComTencentMobileqqPicCompressInfo	Lcom/tencent/mobileqq/pic/CompressInfo;
    //   210: getfield 105	com/tencent/mobileqq/pic/CompressInfo:e	Ljava/lang/String;
    //   213: invokestatic 134	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   216: ifeq +39 -> 255
    //   219: aload_0
    //   220: getfield 107	com/tencent/mobileqq/pic/compress/PicTypeNormal:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   223: ldc 121
    //   225: new 59	java/lang/StringBuilder
    //   228: dup
    //   229: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   232: aload_0
    //   233: getfield 50	com/tencent/mobileqq/pic/compress/PicTypeNormal:jdField_a_of_type_ComTencentMobileqqPicCompressInfo	Lcom/tencent/mobileqq/pic/CompressInfo;
    //   236: getfield 108	com/tencent/mobileqq/pic/CompressInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   239: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: ldc 136
    //   244: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   250: invokestatic 125	com/tencent/mobileqq/pic/Logger:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   253: iconst_0
    //   254: ireturn
    //   255: aload_0
    //   256: getfield 50	com/tencent/mobileqq/pic/compress/PicTypeNormal:jdField_a_of_type_ComTencentMobileqqPicCompressInfo	Lcom/tencent/mobileqq/pic/CompressInfo;
    //   259: getfield 105	com/tencent/mobileqq/pic/CompressInfo:e	Ljava/lang/String;
    //   262: invokestatic 139	com/tencent/mobileqq/utils/FileUtils:b	(Ljava/lang/String;)Z
    //   265: ifeq +39 -> 304
    //   268: aload_0
    //   269: getfield 107	com/tencent/mobileqq/pic/compress/PicTypeNormal:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   272: ldc 121
    //   274: new 59	java/lang/StringBuilder
    //   277: dup
    //   278: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   281: aload_0
    //   282: getfield 50	com/tencent/mobileqq/pic/compress/PicTypeNormal:jdField_a_of_type_ComTencentMobileqqPicCompressInfo	Lcom/tencent/mobileqq/pic/CompressInfo;
    //   285: getfield 108	com/tencent/mobileqq/pic/CompressInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   288: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: ldc 141
    //   293: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   299: invokestatic 125	com/tencent/mobileqq/pic/Logger:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   302: iconst_1
    //   303: ireturn
    //   304: new 143	android/graphics/BitmapFactory$Options
    //   307: dup
    //   308: invokespecial 144	android/graphics/BitmapFactory$Options:<init>	()V
    //   311: astore 9
    //   313: aload 9
    //   315: aload_0
    //   316: getfield 50	com/tencent/mobileqq/pic/compress/PicTypeNormal:jdField_a_of_type_ComTencentMobileqqPicCompressInfo	Lcom/tencent/mobileqq/pic/CompressInfo;
    //   319: getfield 97	com/tencent/mobileqq/pic/CompressInfo:c	Ljava/lang/String;
    //   322: iload_2
    //   323: iload 7
    //   325: invokestatic 147	com/tencent/mobileqq/pic/compress/Utils:a	(Landroid/graphics/BitmapFactory$Options;Ljava/lang/String;II)Z
    //   328: ifne +39 -> 367
    //   331: aload_0
    //   332: getfield 107	com/tencent/mobileqq/pic/compress/PicTypeNormal:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   335: ldc 121
    //   337: new 59	java/lang/StringBuilder
    //   340: dup
    //   341: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   344: aload_0
    //   345: getfield 50	com/tencent/mobileqq/pic/compress/PicTypeNormal:jdField_a_of_type_ComTencentMobileqqPicCompressInfo	Lcom/tencent/mobileqq/pic/CompressInfo;
    //   348: getfield 108	com/tencent/mobileqq/pic/CompressInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   351: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   354: ldc 149
    //   356: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   362: invokestatic 125	com/tencent/mobileqq/pic/Logger:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   365: iconst_0
    //   366: ireturn
    //   367: aload_0
    //   368: getfield 50	com/tencent/mobileqq/pic/compress/PicTypeNormal:jdField_a_of_type_ComTencentMobileqqPicCompressInfo	Lcom/tencent/mobileqq/pic/CompressInfo;
    //   371: getfield 97	com/tencent/mobileqq/pic/CompressInfo:c	Ljava/lang/String;
    //   374: aload 9
    //   376: invokestatic 154	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   379: astore 10
    //   381: aload 10
    //   383: ifnonnull +102 -> 485
    //   386: aload_0
    //   387: getfield 107	com/tencent/mobileqq/pic/compress/PicTypeNormal:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   390: ldc 121
    //   392: new 59	java/lang/StringBuilder
    //   395: dup
    //   396: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   399: aload_0
    //   400: getfield 50	com/tencent/mobileqq/pic/compress/PicTypeNormal:jdField_a_of_type_ComTencentMobileqqPicCompressInfo	Lcom/tencent/mobileqq/pic/CompressInfo;
    //   403: getfield 108	com/tencent/mobileqq/pic/CompressInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   406: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   409: ldc 156
    //   411: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   414: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   417: invokestatic 125	com/tencent/mobileqq/pic/Logger:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   420: iconst_0
    //   421: ireturn
    //   422: astore 9
    //   424: aload_0
    //   425: getfield 50	com/tencent/mobileqq/pic/compress/PicTypeNormal:jdField_a_of_type_ComTencentMobileqqPicCompressInfo	Lcom/tencent/mobileqq/pic/CompressInfo;
    //   428: iconst_1
    //   429: invokevirtual 159	com/tencent/mobileqq/pic/CompressInfo:a	(Z)V
    //   432: aload 9
    //   434: invokevirtual 162	java/lang/OutOfMemoryError:printStackTrace	()V
    //   437: aload_0
    //   438: getfield 107	com/tencent/mobileqq/pic/compress/PicTypeNormal:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   441: ldc 121
    //   443: new 59	java/lang/StringBuilder
    //   446: dup
    //   447: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   450: aload_0
    //   451: getfield 50	com/tencent/mobileqq/pic/compress/PicTypeNormal:jdField_a_of_type_ComTencentMobileqqPicCompressInfo	Lcom/tencent/mobileqq/pic/CompressInfo;
    //   454: getfield 108	com/tencent/mobileqq/pic/CompressInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   457: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   460: ldc 164
    //   462: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   465: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   468: invokestatic 125	com/tencent/mobileqq/pic/Logger:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   471: aload_0
    //   472: getfield 50	com/tencent/mobileqq/pic/compress/PicTypeNormal:jdField_a_of_type_ComTencentMobileqqPicCompressInfo	Lcom/tencent/mobileqq/pic/CompressInfo;
    //   475: ldc 166
    //   477: putfield 105	com/tencent/mobileqq/pic/CompressInfo:e	Ljava/lang/String;
    //   480: aload_0
    //   481: invokevirtual 168	com/tencent/mobileqq/pic/compress/PicTypeNormal:c	()Z
    //   484: ireturn
    //   485: aload 10
    //   487: invokevirtual 174	android/graphics/Bitmap:getWidth	()I
    //   490: istore_2
    //   491: aload 10
    //   493: invokevirtual 177	android/graphics/Bitmap:getHeight	()I
    //   496: istore_3
    //   497: new 179	android/graphics/Matrix
    //   500: dup
    //   501: invokespecial 180	android/graphics/Matrix:<init>	()V
    //   504: astore 11
    //   506: iload_2
    //   507: iload_3
    //   508: if_icmple +258 -> 766
    //   511: iload_2
    //   512: istore 4
    //   514: iload_3
    //   515: istore 5
    //   517: iload 4
    //   519: iload 7
    //   521: if_icmple +393 -> 914
    //   524: iload 7
    //   526: i2f
    //   527: fconst_1
    //   528: iload 4
    //   530: i2f
    //   531: fmul
    //   532: fdiv
    //   533: fstore_1
    //   534: iload 5
    //   536: i2f
    //   537: fload_1
    //   538: fmul
    //   539: f2i
    //   540: istore 5
    //   542: iload 4
    //   544: i2f
    //   545: fload_1
    //   546: fmul
    //   547: f2i
    //   548: istore 4
    //   550: iconst_1
    //   551: istore 4
    //   553: iload_2
    //   554: iload_3
    //   555: if_icmple +3 -> 558
    //   558: aload_0
    //   559: getfield 50	com/tencent/mobileqq/pic/compress/PicTypeNormal:jdField_a_of_type_ComTencentMobileqqPicCompressInfo	Lcom/tencent/mobileqq/pic/CompressInfo;
    //   562: getfield 97	com/tencent/mobileqq/pic/CompressInfo:c	Ljava/lang/String;
    //   565: invokestatic 186	com/tencent/image/JpegExifReader:getRotationDegree	(Ljava/lang/String;)I
    //   568: istore 7
    //   570: iload 6
    //   572: istore 5
    //   574: aload_0
    //   575: getfield 50	com/tencent/mobileqq/pic/compress/PicTypeNormal:jdField_a_of_type_ComTencentMobileqqPicCompressInfo	Lcom/tencent/mobileqq/pic/CompressInfo;
    //   578: getfield 188	com/tencent/mobileqq/pic/CompressInfo:d	Z
    //   581: ifeq +44 -> 625
    //   584: iload 6
    //   586: istore 5
    //   588: iload 7
    //   590: ifeq +35 -> 625
    //   593: iload 6
    //   595: istore 5
    //   597: iload 7
    //   599: bipush 90
    //   601: irem
    //   602: ifne +23 -> 625
    //   605: aload 11
    //   607: iload 7
    //   609: i2f
    //   610: iload_2
    //   611: iconst_1
    //   612: ishr
    //   613: i2f
    //   614: iload_3
    //   615: iconst_1
    //   616: ishr
    //   617: i2f
    //   618: invokevirtual 192	android/graphics/Matrix:postRotate	(FFF)Z
    //   621: pop
    //   622: iconst_1
    //   623: istore 5
    //   625: iload 4
    //   627: ifeq +11 -> 638
    //   630: aload 11
    //   632: fload_1
    //   633: fload_1
    //   634: invokevirtual 196	android/graphics/Matrix:postScale	(FF)Z
    //   637: pop
    //   638: iload 5
    //   640: ifne +12 -> 652
    //   643: aload 10
    //   645: astore 9
    //   647: iload 4
    //   649: ifeq +17 -> 666
    //   652: aload 10
    //   654: iconst_0
    //   655: iconst_0
    //   656: iload_2
    //   657: iload_3
    //   658: aload 11
    //   660: iconst_1
    //   661: invokestatic 200	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   664: astore 9
    //   666: aload_0
    //   667: getfield 50	com/tencent/mobileqq/pic/compress/PicTypeNormal:jdField_a_of_type_ComTencentMobileqqPicCompressInfo	Lcom/tencent/mobileqq/pic/CompressInfo;
    //   670: getfield 105	com/tencent/mobileqq/pic/CompressInfo:e	Ljava/lang/String;
    //   673: aload 9
    //   675: aload_0
    //   676: invokevirtual 202	com/tencent/mobileqq/pic/compress/PicTypeNormal:a	()I
    //   679: aload_0
    //   680: getfield 50	com/tencent/mobileqq/pic/compress/PicTypeNormal:jdField_a_of_type_ComTencentMobileqqPicCompressInfo	Lcom/tencent/mobileqq/pic/CompressInfo;
    //   683: getfield 108	com/tencent/mobileqq/pic/CompressInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   686: aload_0
    //   687: getfield 50	com/tencent/mobileqq/pic/compress/PicTypeNormal:jdField_a_of_type_ComTencentMobileqqPicCompressInfo	Lcom/tencent/mobileqq/pic/CompressInfo;
    //   690: invokestatic 205	com/tencent/mobileqq/pic/compress/Utils:a	(Ljava/lang/String;Landroid/graphics/Bitmap;ILjava/lang/String;Lcom/tencent/mobileqq/pic/CompressInfo;)Z
    //   693: istore 8
    //   695: aload_0
    //   696: getfield 50	com/tencent/mobileqq/pic/compress/PicTypeNormal:jdField_a_of_type_ComTencentMobileqqPicCompressInfo	Lcom/tencent/mobileqq/pic/CompressInfo;
    //   699: getfield 97	com/tencent/mobileqq/pic/CompressInfo:c	Ljava/lang/String;
    //   702: invokestatic 208	com/tencent/image/JpegExifReader:isCrashJpeg	(Ljava/lang/String;)Z
    //   705: ifne +193 -> 898
    //   708: new 210	android/media/ExifInterface
    //   711: dup
    //   712: aload_0
    //   713: getfield 50	com/tencent/mobileqq/pic/compress/PicTypeNormal:jdField_a_of_type_ComTencentMobileqqPicCompressInfo	Lcom/tencent/mobileqq/pic/CompressInfo;
    //   716: getfield 97	com/tencent/mobileqq/pic/CompressInfo:c	Ljava/lang/String;
    //   719: invokespecial 213	android/media/ExifInterface:<init>	(Ljava/lang/String;)V
    //   722: new 210	android/media/ExifInterface
    //   725: dup
    //   726: aload_0
    //   727: getfield 50	com/tencent/mobileqq/pic/compress/PicTypeNormal:jdField_a_of_type_ComTencentMobileqqPicCompressInfo	Lcom/tencent/mobileqq/pic/CompressInfo;
    //   730: getfield 105	com/tencent/mobileqq/pic/CompressInfo:e	Ljava/lang/String;
    //   733: invokespecial 213	android/media/ExifInterface:<init>	(Ljava/lang/String;)V
    //   736: invokestatic 216	com/tencent/mobileqq/utils/ImageUtil:a	(Landroid/media/ExifInterface;Landroid/media/ExifInterface;)Z
    //   739: ifne +14 -> 753
    //   742: aload_0
    //   743: getfield 107	com/tencent/mobileqq/pic/compress/PicTypeNormal:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   746: ldc 121
    //   748: ldc 218
    //   750: invokestatic 125	com/tencent/mobileqq/pic/Logger:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   753: aload 9
    //   755: ifnull +8 -> 763
    //   758: aload 9
    //   760: invokevirtual 221	android/graphics/Bitmap:recycle	()V
    //   763: iload 8
    //   765: ireturn
    //   766: iload_3
    //   767: istore 4
    //   769: iload_2
    //   770: istore 5
    //   772: goto -255 -> 517
    //   775: astore 9
    //   777: aload_0
    //   778: getfield 107	com/tencent/mobileqq/pic/compress/PicTypeNormal:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   781: ldc 121
    //   783: new 59	java/lang/StringBuilder
    //   786: dup
    //   787: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   790: aload_0
    //   791: getfield 50	com/tencent/mobileqq/pic/compress/PicTypeNormal:jdField_a_of_type_ComTencentMobileqqPicCompressInfo	Lcom/tencent/mobileqq/pic/CompressInfo;
    //   794: getfield 108	com/tencent/mobileqq/pic/CompressInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   797: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   800: ldc 223
    //   802: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   805: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   808: invokestatic 125	com/tencent/mobileqq/pic/Logger:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   811: aload 10
    //   813: astore 9
    //   815: goto -149 -> 666
    //   818: astore 9
    //   820: aload_0
    //   821: getfield 107	com/tencent/mobileqq/pic/compress/PicTypeNormal:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   824: ldc 121
    //   826: new 59	java/lang/StringBuilder
    //   829: dup
    //   830: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   833: aload_0
    //   834: getfield 50	com/tencent/mobileqq/pic/compress/PicTypeNormal:jdField_a_of_type_ComTencentMobileqqPicCompressInfo	Lcom/tencent/mobileqq/pic/CompressInfo;
    //   837: getfield 108	com/tencent/mobileqq/pic/CompressInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   840: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   843: ldc 225
    //   845: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   848: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   851: invokestatic 125	com/tencent/mobileqq/pic/Logger:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   854: aload 10
    //   856: astore 9
    //   858: goto -192 -> 666
    //   861: astore 10
    //   863: aload_0
    //   864: getfield 107	com/tencent/mobileqq/pic/compress/PicTypeNormal:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   867: ldc 121
    //   869: new 59	java/lang/StringBuilder
    //   872: dup
    //   873: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   876: ldc 227
    //   878: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   881: aload 10
    //   883: invokevirtual 230	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   886: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   889: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   892: invokestatic 125	com/tencent/mobileqq/pic/Logger:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   895: goto -142 -> 753
    //   898: aload_0
    //   899: getfield 107	com/tencent/mobileqq/pic/compress/PicTypeNormal:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   902: ldc 121
    //   904: ldc 232
    //   906: invokestatic 125	com/tencent/mobileqq/pic/Logger:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   909: goto -156 -> 753
    //   912: iconst_0
    //   913: ireturn
    //   914: iconst_0
    //   915: istore 4
    //   917: goto -364 -> 553
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	920	0	this	PicTypeNormal
    //   1	633	1	f	float
    //   181	589	2	i	int
    //   496	271	3	j	int
    //   512	404	4	k	int
    //   515	256	5	m	int
    //   3	591	6	n	int
    //   175	433	7	i1	int
    //   693	71	8	bool	boolean
    //   128	247	9	localObject1	java.lang.Object
    //   422	11	9	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   645	114	9	localObject2	java.lang.Object
    //   775	1	9	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   813	1	9	localObject3	java.lang.Object
    //   818	1	9	localNullPointerException	java.lang.NullPointerException
    //   856	1	9	localObject4	java.lang.Object
    //   379	476	10	localBitmap	android.graphics.Bitmap
    //   861	21	10	localThrowable	java.lang.Throwable
    //   504	155	11	localMatrix	android.graphics.Matrix
    // Exception table:
    //   from	to	target	type
    //   367	381	422	java/lang/OutOfMemoryError
    //   386	420	422	java/lang/OutOfMemoryError
    //   652	666	775	java/lang/OutOfMemoryError
    //   652	666	818	java/lang/NullPointerException
    //   708	753	861	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.pic.compress.PicTypeNormal
 * JD-Core Version:    0.7.0.1
 */