package com.tencent.mobileqq.shortvideo.cover;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Matrix;
import com.tencent.mobileqq.shortvideo.common.GloableValue;
import com.tencent.mobileqq.shortvideo.util.VidUtil;
import java.io.File;

public class RecordThumbnailUtils
{
  public static Bitmap a(Bitmap paramBitmap, int paramInt)
  {
    Matrix localMatrix = new Matrix();
    localMatrix.setRotate(paramInt, paramBitmap.getWidth() / 2.0F, paramBitmap.getHeight() / 2.0F);
    try
    {
      paramBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), localMatrix, true);
      return paramBitmap;
    }
    catch (OutOfMemoryError paramBitmap)
    {
      paramBitmap.printStackTrace();
    }
    return null;
  }
  
  /* Error */
  public static String a(int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2, int paramInt4)
  {
    // Byte code:
    //   0: iload_2
    //   1: iload_3
    //   2: imul
    //   3: istore 6
    //   5: iload 6
    //   7: iconst_3
    //   8: imul
    //   9: iconst_2
    //   10: idiv
    //   11: newarray byte
    //   13: astore 11
    //   15: iload 6
    //   17: newarray int
    //   19: astore 12
    //   21: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   24: ifeq +38 -> 62
    //   27: new 49	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   34: astore 10
    //   36: aload 10
    //   38: ldc 52
    //   40: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: pop
    //   44: aload 10
    //   46: aload_1
    //   47: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: ldc 58
    //   53: iconst_2
    //   54: aload 10
    //   56: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: invokestatic 66	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   62: new 68	java/io/File
    //   65: dup
    //   66: aload_1
    //   67: invokespecial 71	java/io/File:<init>	(Ljava/lang/String;)V
    //   70: astore 10
    //   72: aload 10
    //   74: invokevirtual 74	java/io/File:exists	()Z
    //   77: ifeq +612 -> 689
    //   80: aload 10
    //   82: invokevirtual 77	java/io/File:isDirectory	()Z
    //   85: ifne +6 -> 91
    //   88: goto +601 -> 689
    //   91: aload 10
    //   93: invokevirtual 81	java/io/File:list	()[Ljava/lang/String;
    //   96: astore 13
    //   98: aload 13
    //   100: ifnull +552 -> 652
    //   103: aload 13
    //   105: arraylength
    //   106: ifgt +6 -> 112
    //   109: goto +543 -> 652
    //   112: aload 13
    //   114: arraylength
    //   115: istore 7
    //   117: iconst_0
    //   118: istore 6
    //   120: iload 6
    //   122: iload 7
    //   124: if_icmpge +72 -> 196
    //   127: aload 13
    //   129: iload 6
    //   131: aaload
    //   132: astore 10
    //   134: aload 10
    //   136: ldc 83
    //   138: invokevirtual 89	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   141: ifeq +46 -> 187
    //   144: new 49	java/lang/StringBuilder
    //   147: dup
    //   148: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   151: astore 13
    //   153: aload 13
    //   155: aload_1
    //   156: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: pop
    //   160: aload 13
    //   162: getstatic 93	java/io/File:separator	Ljava/lang/String;
    //   165: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: pop
    //   169: aload 13
    //   171: aload 10
    //   173: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: pop
    //   177: aload 13
    //   179: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   182: astore 10
    //   184: goto +15 -> 199
    //   187: iload 6
    //   189: iconst_1
    //   190: iadd
    //   191: istore 6
    //   193: goto -73 -> 120
    //   196: aconst_null
    //   197: astore 10
    //   199: aload 10
    //   201: ifnonnull +40 -> 241
    //   204: new 49	java/lang/StringBuilder
    //   207: dup
    //   208: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   211: astore 4
    //   213: aload 4
    //   215: ldc 95
    //   217: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: pop
    //   221: aload 4
    //   223: aload_1
    //   224: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: pop
    //   228: ldc 58
    //   230: iconst_2
    //   231: aload 4
    //   233: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   236: invokestatic 98	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   239: aconst_null
    //   240: areturn
    //   241: aload 10
    //   243: invokestatic 104	com/tencent/maxvideo/activity/CoverNative:openFile	(Ljava/lang/String;)J
    //   246: lstore 8
    //   248: lload 8
    //   250: lconst_0
    //   251: lcmp
    //   252: ifne +37 -> 289
    //   255: new 49	java/lang/StringBuilder
    //   258: dup
    //   259: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   262: astore_1
    //   263: aload_1
    //   264: ldc 106
    //   266: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: pop
    //   270: aload_1
    //   271: aload 10
    //   273: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: pop
    //   277: ldc 58
    //   279: iconst_2
    //   280: aload_1
    //   281: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   284: invokestatic 98	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   287: aconst_null
    //   288: areturn
    //   289: lload 8
    //   291: aconst_null
    //   292: iload_0
    //   293: aload 11
    //   295: iload_2
    //   296: iload_3
    //   297: invokestatic 110	com/tencent/maxvideo/activity/CoverNative:getFrameYuv	(JLjava/lang/String;I[BII)Z
    //   300: ifne +37 -> 337
    //   303: new 49	java/lang/StringBuilder
    //   306: dup
    //   307: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   310: astore_1
    //   311: aload_1
    //   312: ldc 112
    //   314: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: pop
    //   318: aload_1
    //   319: aload 10
    //   321: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: pop
    //   325: ldc 58
    //   327: iconst_2
    //   328: aload_1
    //   329: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   332: invokestatic 98	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   335: aconst_null
    //   336: areturn
    //   337: lload 8
    //   339: invokestatic 116	com/tencent/maxvideo/activity/CoverNative:closeFile	(J)V
    //   342: aload 12
    //   344: aload 11
    //   346: iload_2
    //   347: iload_3
    //   348: invokestatic 121	com/tencent/mobileqq/shortvideo/util/ImageUtil:a	([I[BII)V
    //   351: aload 12
    //   353: iload_2
    //   354: iload_3
    //   355: getstatic 127	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   358: invokestatic 130	android/graphics/Bitmap:createBitmap	([IIILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   361: astore_1
    //   362: aload_1
    //   363: ifnull +220 -> 583
    //   366: aload_1
    //   367: astore 10
    //   369: iload 5
    //   371: ifeq +22 -> 393
    //   374: aload_1
    //   375: astore 10
    //   377: iload 5
    //   379: invokestatic 133	com/tencent/mobileqq/shortvideo/cover/RecordThumbnailUtils:a	(I)Z
    //   382: ifne +11 -> 393
    //   385: aload_1
    //   386: iload 5
    //   388: invokestatic 135	com/tencent/mobileqq/shortvideo/cover/RecordThumbnailUtils:a	(Landroid/graphics/Bitmap;I)Landroid/graphics/Bitmap;
    //   391: astore 10
    //   393: new 68	java/io/File
    //   396: dup
    //   397: aload 4
    //   399: invokespecial 71	java/io/File:<init>	(Ljava/lang/String;)V
    //   402: astore_1
    //   403: new 137	java/io/BufferedOutputStream
    //   406: dup
    //   407: new 139	java/io/FileOutputStream
    //   410: dup
    //   411: aload_1
    //   412: invokespecial 142	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   415: invokespecial 145	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   418: astore 11
    //   420: aload 10
    //   422: ifnull +39 -> 461
    //   425: aload 11
    //   427: astore_1
    //   428: aload 10
    //   430: getstatic 151	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   433: bipush 80
    //   435: aload 11
    //   437: invokevirtual 155	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   440: pop
    //   441: aload 11
    //   443: astore_1
    //   444: aload 11
    //   446: invokevirtual 158	java/io/BufferedOutputStream:flush	()V
    //   449: goto +12 -> 461
    //   452: astore 12
    //   454: aload 11
    //   456: astore 10
    //   458: goto +23 -> 481
    //   461: aload 11
    //   463: invokevirtual 161	java/io/BufferedOutputStream:close	()V
    //   466: aload 4
    //   468: areturn
    //   469: astore_1
    //   470: aconst_null
    //   471: astore 4
    //   473: goto +98 -> 571
    //   476: astore 12
    //   478: aconst_null
    //   479: astore 10
    //   481: aload 10
    //   483: astore_1
    //   484: new 49	java/lang/StringBuilder
    //   487: dup
    //   488: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   491: astore 11
    //   493: aload 10
    //   495: astore_1
    //   496: aload 11
    //   498: ldc 163
    //   500: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   503: pop
    //   504: aload 10
    //   506: astore_1
    //   507: aload 11
    //   509: aload 4
    //   511: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   514: pop
    //   515: aload 10
    //   517: astore_1
    //   518: aload 11
    //   520: ldc 165
    //   522: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   525: pop
    //   526: aload 10
    //   528: astore_1
    //   529: aload 11
    //   531: aload 12
    //   533: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   536: pop
    //   537: aload 10
    //   539: astore_1
    //   540: ldc 58
    //   542: iconst_2
    //   543: aload 11
    //   545: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   548: invokestatic 171	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   551: aload 10
    //   553: ifnull +8 -> 561
    //   556: aload 10
    //   558: invokevirtual 161	java/io/BufferedOutputStream:close	()V
    //   561: aconst_null
    //   562: areturn
    //   563: astore 10
    //   565: aload_1
    //   566: astore 4
    //   568: aload 10
    //   570: astore_1
    //   571: aload 4
    //   573: ifnull +8 -> 581
    //   576: aload 4
    //   578: invokevirtual 161	java/io/BufferedOutputStream:close	()V
    //   581: aload_1
    //   582: athrow
    //   583: new 49	java/lang/StringBuilder
    //   586: dup
    //   587: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   590: astore_1
    //   591: aload_1
    //   592: ldc 173
    //   594: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   597: pop
    //   598: aload_1
    //   599: aload 10
    //   601: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   604: pop
    //   605: ldc 58
    //   607: iconst_2
    //   608: aload_1
    //   609: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   612: invokestatic 98	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   615: aload 4
    //   617: areturn
    //   618: new 49	java/lang/StringBuilder
    //   621: dup
    //   622: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   625: astore_1
    //   626: aload_1
    //   627: ldc 175
    //   629: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   632: pop
    //   633: aload_1
    //   634: aload 10
    //   636: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   639: pop
    //   640: ldc 58
    //   642: iconst_2
    //   643: aload_1
    //   644: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   647: invokestatic 98	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   650: aconst_null
    //   651: areturn
    //   652: new 49	java/lang/StringBuilder
    //   655: dup
    //   656: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   659: astore 4
    //   661: aload 4
    //   663: ldc 177
    //   665: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   668: pop
    //   669: aload 4
    //   671: aload_1
    //   672: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   675: pop
    //   676: ldc 58
    //   678: iconst_2
    //   679: aload 4
    //   681: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   684: invokestatic 98	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   687: aconst_null
    //   688: areturn
    //   689: new 49	java/lang/StringBuilder
    //   692: dup
    //   693: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   696: astore 4
    //   698: aload 4
    //   700: ldc 179
    //   702: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   705: pop
    //   706: aload 4
    //   708: aload_1
    //   709: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   712: pop
    //   713: ldc 58
    //   715: iconst_2
    //   716: aload 4
    //   718: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   721: invokestatic 98	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   724: aconst_null
    //   725: areturn
    //   726: astore_1
    //   727: goto -109 -> 618
    //   730: astore_1
    //   731: aload 4
    //   733: areturn
    //   734: astore_1
    //   735: goto -174 -> 561
    //   738: astore 4
    //   740: goto -159 -> 581
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	743	0	paramInt1	int
    //   0	743	1	paramString1	String
    //   0	743	2	paramInt2	int
    //   0	743	3	paramInt3	int
    //   0	743	4	paramString2	String
    //   0	743	5	paramInt4	int
    //   3	189	6	i	int
    //   115	10	7	j	int
    //   246	92	8	l	long
    //   34	523	10	localObject1	Object
    //   563	72	10	str	String
    //   13	531	11	localObject2	Object
    //   19	333	12	arrayOfInt	int[]
    //   452	1	12	localIOException1	java.io.IOException
    //   476	56	12	localIOException2	java.io.IOException
    //   96	82	13	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   428	441	452	java/io/IOException
    //   444	449	452	java/io/IOException
    //   403	420	469	finally
    //   403	420	476	java/io/IOException
    //   428	441	563	finally
    //   444	449	563	finally
    //   484	493	563	finally
    //   496	504	563	finally
    //   507	515	563	finally
    //   518	526	563	finally
    //   529	537	563	finally
    //   540	551	563	finally
    //   351	362	726	java/lang/Throwable
    //   461	466	730	java/io/IOException
    //   556	561	734	java/io/IOException
    //   576	581	738	java/io/IOException
  }
  
  public static String a(String paramString, int paramInt1, int paramInt2, int paramInt3, Bitmap.Config paramConfig)
  {
    File localFile = new File(paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(GloableValue.a);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(VidUtil.getVidFromSourceDirFile(localFile));
    localStringBuilder.append(".jpg");
    return a(paramString, paramInt1, paramInt2, localStringBuilder.toString(), paramInt3, paramConfig);
  }
  
  /* Error */
  public static String a(String paramString1, int paramInt1, int paramInt2, String paramString2, int paramInt3, Bitmap.Config paramConfig)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 7
    //   6: iload_1
    //   7: iload_2
    //   8: aload 5
    //   10: invokestatic 200	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   13: astore 9
    //   15: aload 9
    //   17: iload_1
    //   18: iload_2
    //   19: invokestatic 204	com/tencent/mobileqq/shortvideo/cover/RecordThumbnailUtils:nativeGenCover	(Landroid/graphics/Bitmap;II)I
    //   22: istore 6
    //   24: goto +44 -> 68
    //   27: astore 5
    //   29: new 49	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   36: astore 10
    //   38: aload 10
    //   40: ldc 206
    //   42: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: aload 10
    //   48: aload 5
    //   50: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: ldc 58
    //   56: iconst_2
    //   57: aload 10
    //   59: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   62: invokestatic 171	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   65: iconst_m1
    //   66: istore 6
    //   68: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   71: ifeq +55 -> 126
    //   74: new 49	java/lang/StringBuilder
    //   77: dup
    //   78: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   81: astore 5
    //   83: aload 5
    //   85: ldc 208
    //   87: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: pop
    //   91: aload 5
    //   93: iload 6
    //   95: invokevirtual 211	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   98: pop
    //   99: aload 5
    //   101: ldc 213
    //   103: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: pop
    //   107: aload 5
    //   109: aload 9
    //   111: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   114: pop
    //   115: ldc 58
    //   117: iconst_2
    //   118: aload 5
    //   120: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   123: invokestatic 66	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   126: iload 6
    //   128: ifeq +14 -> 142
    //   131: iconst_0
    //   132: aload_0
    //   133: iload_1
    //   134: iload_2
    //   135: aload_3
    //   136: iload 4
    //   138: invokestatic 215	com/tencent/mobileqq/shortvideo/cover/RecordThumbnailUtils:a	(ILjava/lang/String;IILjava/lang/String;I)Ljava/lang/String;
    //   141: areturn
    //   142: aload 9
    //   144: ifnull +197 -> 341
    //   147: aload 9
    //   149: astore 5
    //   151: iload 4
    //   153: ifeq +24 -> 177
    //   156: aload 9
    //   158: astore 5
    //   160: iload 4
    //   162: invokestatic 133	com/tencent/mobileqq/shortvideo/cover/RecordThumbnailUtils:a	(I)Z
    //   165: ifne +12 -> 177
    //   168: aload 9
    //   170: iload 4
    //   172: invokestatic 135	com/tencent/mobileqq/shortvideo/cover/RecordThumbnailUtils:a	(Landroid/graphics/Bitmap;I)Landroid/graphics/Bitmap;
    //   175: astore 5
    //   177: new 68	java/io/File
    //   180: dup
    //   181: aload_3
    //   182: invokespecial 71	java/io/File:<init>	(Ljava/lang/String;)V
    //   185: astore 9
    //   187: aload 7
    //   189: astore_0
    //   190: new 137	java/io/BufferedOutputStream
    //   193: dup
    //   194: new 139	java/io/FileOutputStream
    //   197: dup
    //   198: aload 9
    //   200: invokespecial 142	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   203: invokespecial 145	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   206: astore 7
    //   208: aload 5
    //   210: ifnull +42 -> 252
    //   213: aload 5
    //   215: getstatic 151	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   218: bipush 80
    //   220: aload 7
    //   222: invokevirtual 155	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   225: pop
    //   226: aload 7
    //   228: invokevirtual 158	java/io/BufferedOutputStream:flush	()V
    //   231: goto +21 -> 252
    //   234: astore_3
    //   235: aload 7
    //   237: astore_0
    //   238: goto +93 -> 331
    //   241: astore_0
    //   242: aload 7
    //   244: astore 5
    //   246: aload_0
    //   247: astore 7
    //   249: goto +21 -> 270
    //   252: aload 7
    //   254: invokevirtual 161	java/io/BufferedOutputStream:close	()V
    //   257: goto +92 -> 349
    //   260: astore_3
    //   261: goto +70 -> 331
    //   264: astore 7
    //   266: aload 8
    //   268: astore 5
    //   270: aload 5
    //   272: astore_0
    //   273: new 49	java/lang/StringBuilder
    //   276: dup
    //   277: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   280: astore 8
    //   282: aload 5
    //   284: astore_0
    //   285: aload 8
    //   287: ldc 217
    //   289: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: pop
    //   293: aload 5
    //   295: astore_0
    //   296: aload 8
    //   298: aload 7
    //   300: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   303: pop
    //   304: aload 5
    //   306: astore_0
    //   307: ldc 58
    //   309: iconst_2
    //   310: aload 8
    //   312: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   315: invokestatic 98	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   318: aload 5
    //   320: ifnull +29 -> 349
    //   323: aload 5
    //   325: invokevirtual 161	java/io/BufferedOutputStream:close	()V
    //   328: goto +21 -> 349
    //   331: aload_0
    //   332: ifnull +7 -> 339
    //   335: aload_0
    //   336: invokevirtual 161	java/io/BufferedOutputStream:close	()V
    //   339: aload_3
    //   340: athrow
    //   341: ldc 58
    //   343: iconst_2
    //   344: ldc 219
    //   346: invokestatic 98	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   349: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   352: ifeq +50 -> 402
    //   355: new 49	java/lang/StringBuilder
    //   358: dup
    //   359: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   362: astore_0
    //   363: aload_0
    //   364: ldc 221
    //   366: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   369: pop
    //   370: aload_0
    //   371: aload_3
    //   372: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: pop
    //   376: aload_0
    //   377: ldc 223
    //   379: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   382: pop
    //   383: aload_0
    //   384: aload_3
    //   385: invokestatic 228	com/tencent/mobileqq/utils/FileUtils:fileExistsAndNotEmpty	(Ljava/lang/String;)Z
    //   388: invokevirtual 231	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   391: pop
    //   392: ldc 58
    //   394: iconst_2
    //   395: aload_0
    //   396: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   399: invokestatic 66	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   402: aload_3
    //   403: areturn
    //   404: ldc 58
    //   406: iconst_2
    //   407: ldc 206
    //   409: invokestatic 171	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   412: aconst_null
    //   413: areturn
    //   414: ldc 58
    //   416: iconst_2
    //   417: ldc 233
    //   419: invokestatic 171	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   422: invokestatic 238	com/tencent/image/URLDrawable:clearMemoryCache	()V
    //   425: invokestatic 243	java/lang/System:gc	()V
    //   428: aconst_null
    //   429: areturn
    //   430: astore_0
    //   431: goto -17 -> 414
    //   434: astore_0
    //   435: goto -31 -> 404
    //   438: astore_0
    //   439: goto -90 -> 349
    //   442: astore_0
    //   443: goto -104 -> 339
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	446	0	paramString1	String
    //   0	446	1	paramInt1	int
    //   0	446	2	paramInt2	int
    //   0	446	3	paramString2	String
    //   0	446	4	paramInt3	int
    //   0	446	5	paramConfig	Bitmap.Config
    //   22	105	6	i	int
    //   4	249	7	localObject1	Object
    //   264	35	7	localIOException	java.io.IOException
    //   1	310	8	localStringBuilder1	StringBuilder
    //   13	186	9	localObject2	Object
    //   36	22	10	localStringBuilder2	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   15	24	27	java/lang/UnsatisfiedLinkError
    //   213	231	234	finally
    //   213	231	241	java/io/IOException
    //   190	208	260	finally
    //   273	282	260	finally
    //   285	293	260	finally
    //   296	304	260	finally
    //   307	318	260	finally
    //   190	208	264	java/io/IOException
    //   6	15	430	java/lang/OutOfMemoryError
    //   6	15	434	java/lang/Throwable
    //   252	257	438	java/io/IOException
    //   323	328	438	java/io/IOException
    //   335	339	442	java/io/IOException
  }
  
  public static boolean a(int paramInt)
  {
    return paramInt == 180;
  }
  
  private static native int nativeGenCover(Bitmap paramBitmap, int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.cover.RecordThumbnailUtils
 * JD-Core Version:    0.7.0.1
 */