package com.tencent.mobileqq.ocr;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Point;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.gallery.picocr.PicOcrResultBean;
import com.tencent.mobileqq.ocr.data.OcrDpc;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class OcrImageUtil
{
  public static String a;
  public static boolean a;
  public static String b;
  public static String c;
  
  static
  {
    jdField_a_of_type_Boolean = true;
    File localFile1 = new File(AppConstants.SDCARD_PATH, "ocr");
    jdField_a_of_type_JavaLangString = localFile1.getAbsolutePath();
    if ((!localFile1.exists()) && (!localFile1.mkdir()))
    {
      jdField_a_of_type_Boolean = false;
      QLog.d("Q.ocr.image", 1, "WTF! mk ocr dir failed!");
    }
    if (localFile1.exists())
    {
      File localFile2 = new File(jdField_a_of_type_JavaLangString, "preview");
      b = localFile2.getAbsolutePath();
      if ((!localFile2.exists()) && (!localFile2.mkdir())) {
        QLog.d("Q.ocr.image", 1, "WTF! mk ocr preview dir failed!");
      }
    }
    if (localFile1.exists())
    {
      localFile1 = new File(jdField_a_of_type_JavaLangString, "cache");
      c = localFile1.getAbsolutePath();
      if ((!localFile1.exists()) && (!localFile1.mkdir())) {
        QLog.d("Q.ocr.image", 1, "mkdir cache dir failed!");
      }
    }
  }
  
  public static float a(int paramInt1, int paramInt2, String paramString, Paint paramPaint)
  {
    float f2 = paramPaint.getTextSize();
    float f3 = paramPaint.measureText(paramString);
    if (f3 > paramInt1) {
      for (;;)
      {
        f1 = f2;
        if (f3 <= paramInt1) {
          break;
        }
        f2 -= 1.0F;
        paramPaint.setTextSize(f2);
        f3 = paramPaint.measureText(paramString);
      }
    }
    float f1 = f2;
    if (f3 < paramInt1 * 0.97F)
    {
      while (f3 < paramInt1 * 0.97F)
      {
        f2 += 1.0F;
        paramPaint.setTextSize(f2);
        f3 = paramPaint.measureText(paramString);
      }
      f1 = f2;
      if (f3 > paramInt1) {
        f1 = f2 - 1.0F;
      }
    }
    paramString = paramPaint.getFontMetrics();
    f2 = paramString.descent;
    f3 = paramString.ascent;
    f3 = f2 - f3;
    f2 = f1;
    for (f1 = f3; f1 > paramInt2; f1 = paramString.descent - paramString.ascent)
    {
      f2 -= 1.0F;
      paramPaint.setTextSize(f2);
      paramString = paramPaint.getFontMetrics();
    }
    return f2;
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
  
  public static Point a(Point paramPoint1, Point paramPoint2, Point paramPoint3, Point paramPoint4)
  {
    double d2 = paramPoint2.x - paramPoint1.x;
    double d1 = paramPoint3.x - paramPoint4.x;
    double d3 = paramPoint2.y - paramPoint1.y;
    double d7 = paramPoint3.y - paramPoint4.y;
    double d4 = paramPoint3.x - paramPoint1.x;
    double d5 = paramPoint3.y - paramPoint1.y;
    double d6 = d2 * d7 - d1 * d3;
    if (Math.abs(d6) < 0.001D) {
      return null;
    }
    d1 = (d7 * d4 - d1 * d5) / d6;
    d2 = (d2 * d5 + -d3 * d4) / d6;
    d2 = paramPoint1.x;
    d2 = (paramPoint2.x - paramPoint1.x) * d1 + d2;
    d3 = paramPoint1.y;
    d1 = d1 * (paramPoint2.y - paramPoint1.y) + d3;
    if ((Math.abs(d2 - paramPoint4.x) < 5.0D) && (Math.abs(d1 - paramPoint4.y) < 5.0D)) {
      return new Point(paramPoint4);
    }
    return new Point((int)d2, (int)d1);
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
  
  public static String a(String paramString)
  {
    try
    {
      String str3 = new File(paramString).getName();
      int i = str3.lastIndexOf('.');
      str1 = str3;
      if (i > -1)
      {
        str1 = str3;
        if (i < str3.length()) {
          str1 = str3.substring(0, i);
        }
      }
      str1 = str1 + "_" + System.currentTimeMillis() + ".tmp";
      str1 = new File(c, str1).getAbsolutePath();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str1;
        localException.printStackTrace();
        String str2 = "";
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.ocr.image", 2, String.format("getCachePath oldPath: %s, newPath: %s", new Object[] { paramString, str1 }));
    }
    return str1;
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
  
  public static String a(List<PicOcrResultBean> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      PicOcrResultBean localPicOcrResultBean = (PicOcrResultBean)paramList.next();
      if ((localPicOcrResultBean != null) && (localPicOcrResultBean.jdField_a_of_type_JavaLangString != null)) {
        localStringBuilder.append(localPicOcrResultBean.jdField_a_of_type_JavaLangString);
      }
    }
    return localStringBuilder.toString().replace(" ", "");
  }
  
  /* Error */
  public static String a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: invokestatic 203	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +77 -> 83
    //   9: aload_0
    //   10: ifnull +79 -> 89
    //   13: aload_0
    //   14: arraylength
    //   15: i2l
    //   16: lstore 5
    //   18: ldc 41
    //   20: iconst_2
    //   21: new 157	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   28: ldc 247
    //   30: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: lload 5
    //   35: invokevirtual 198	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   38: ldc 249
    //   40: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: iload_2
    //   44: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   47: ldc 254
    //   49: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: iload_1
    //   53: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   56: ldc_w 256
    //   59: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: iload_3
    //   63: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   66: ldc_w 258
    //   69: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: iload 4
    //   74: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   77: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: invokestatic 49	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   83: aload_0
    //   84: ifnonnull +11 -> 95
    //   87: aconst_null
    //   88: areturn
    //   89: lconst_0
    //   90: lstore 5
    //   92: goto -74 -> 18
    //   95: invokestatic 260	com/tencent/mobileqq/ocr/OcrImageUtil:a	()Ljava/lang/String;
    //   98: iconst_1
    //   99: invokestatic 262	com/tencent/mobileqq/ocr/OcrImageUtil:a	(Ljava/lang/String;Z)Ljava/lang/String;
    //   102: astore 9
    //   104: iload_2
    //   105: ifle +19 -> 124
    //   108: iload_1
    //   109: ifle +15 -> 124
    //   112: iload_3
    //   113: bipush 17
    //   115: if_icmpeq +20 -> 135
    //   118: iload_3
    //   119: bipush 20
    //   121: if_icmpeq +14 -> 135
    //   124: ldc 41
    //   126: iconst_1
    //   127: ldc_w 264
    //   130: invokestatic 49	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   133: aconst_null
    //   134: areturn
    //   135: aload 9
    //   137: new 266	android/graphics/YuvImage
    //   140: dup
    //   141: aload_0
    //   142: iload_3
    //   143: iload_1
    //   144: iload_2
    //   145: aconst_null
    //   146: invokespecial 269	android/graphics/YuvImage:<init>	([BIII[I)V
    //   149: bipush 100
    //   151: invokestatic 272	com/tencent/mobileqq/ocr/OcrImageUtil:a	(Ljava/lang/String;Landroid/graphics/YuvImage;I)Z
    //   154: ifne +14 -> 168
    //   157: ldc 41
    //   159: iconst_1
    //   160: ldc_w 274
    //   163: invokestatic 49	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   166: aconst_null
    //   167: areturn
    //   168: aload 9
    //   170: invokestatic 277	com/tencent/mobileqq/ocr/OcrImageUtil:a	(Ljava/lang/String;)[B
    //   173: astore_0
    //   174: aload_0
    //   175: ifnonnull +15 -> 190
    //   178: ldc 41
    //   180: iconst_1
    //   181: ldc_w 279
    //   184: invokestatic 49	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   187: aload 9
    //   189: areturn
    //   190: aload_0
    //   191: new 281	android/graphics/Rect
    //   194: dup
    //   195: iconst_0
    //   196: iconst_0
    //   197: getstatic 286	com/tencent/mobileqq/shortvideo/util/ScreenUtil:SCREEN_WIDTH	I
    //   200: getstatic 289	com/tencent/mobileqq/shortvideo/util/ScreenUtil:SCREEN_HIGHT	I
    //   203: invokespecial 292	android/graphics/Rect:<init>	(IIII)V
    //   206: iconst_0
    //   207: iconst_0
    //   208: invokestatic 297	com/tencent/mobileqq/camera/utils/CameraUtils:a	([BLandroid/graphics/Rect;ZI)Landroid/graphics/Bitmap;
    //   211: astore 8
    //   213: aload 8
    //   215: ifnonnull +44 -> 259
    //   218: ldc 41
    //   220: iconst_1
    //   221: ldc_w 299
    //   224: invokestatic 49	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   227: new 15	java/io/File
    //   230: dup
    //   231: aload 9
    //   233: invokespecial 176	java/io/File:<init>	(Ljava/lang/String;)V
    //   236: invokevirtual 36	java/io/File:exists	()Z
    //   239: ifeq +17 -> 256
    //   242: iconst_0
    //   243: ifeq +13 -> 256
    //   246: getstatic 304	com/tencent/mobileqq/app/GlobalImageCache:a	Landroid/support/v4/util/MQLruCache;
    //   249: aload 9
    //   251: aconst_null
    //   252: invokevirtual 310	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   255: pop
    //   256: aload 9
    //   258: areturn
    //   259: aload 8
    //   261: iload 4
    //   263: iconst_1
    //   264: invokestatic 313	com/tencent/mobileqq/camera/utils/CameraUtils:a	(Landroid/graphics/Bitmap;IZ)Landroid/graphics/Bitmap;
    //   267: astore_0
    //   268: aload_0
    //   269: astore 7
    //   271: invokestatic 203	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   274: ifeq +33 -> 307
    //   277: aload_0
    //   278: astore 7
    //   280: ldc 41
    //   282: iconst_2
    //   283: new 157	java/lang/StringBuilder
    //   286: dup
    //   287: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   290: ldc_w 315
    //   293: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: iload 4
    //   298: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   301: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   304: invokestatic 49	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   307: aload_0
    //   308: ifnonnull +82 -> 390
    //   311: aload_0
    //   312: astore 7
    //   314: aload 8
    //   316: bipush 100
    //   318: new 15	java/io/File
    //   321: dup
    //   322: aload 9
    //   324: invokespecial 176	java/io/File:<init>	(Ljava/lang/String;)V
    //   327: invokestatic 320	com/tencent/mobileqq/utils/ImageUtil:b	(Landroid/graphics/Bitmap;ILjava/io/File;)Z
    //   330: pop
    //   331: aload_0
    //   332: astore 7
    //   334: ldc 41
    //   336: iconst_1
    //   337: ldc_w 322
    //   340: invokestatic 49	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   343: new 15	java/io/File
    //   346: dup
    //   347: aload 9
    //   349: invokespecial 176	java/io/File:<init>	(Ljava/lang/String;)V
    //   352: invokevirtual 36	java/io/File:exists	()Z
    //   355: ifeq +17 -> 372
    //   358: aload_0
    //   359: ifnull +13 -> 372
    //   362: getstatic 304	com/tencent/mobileqq/app/GlobalImageCache:a	Landroid/support/v4/util/MQLruCache;
    //   365: aload 9
    //   367: aload_0
    //   368: invokevirtual 310	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   371: pop
    //   372: new 15	java/io/File
    //   375: dup
    //   376: aload 9
    //   378: invokespecial 176	java/io/File:<init>	(Ljava/lang/String;)V
    //   381: invokevirtual 36	java/io/File:exists	()Z
    //   384: ifeq -297 -> 87
    //   387: aload 9
    //   389: areturn
    //   390: aload_0
    //   391: astore 7
    //   393: aload_0
    //   394: bipush 100
    //   396: new 15	java/io/File
    //   399: dup
    //   400: aload 9
    //   402: invokespecial 176	java/io/File:<init>	(Ljava/lang/String;)V
    //   405: invokestatic 320	com/tencent/mobileqq/utils/ImageUtil:b	(Landroid/graphics/Bitmap;ILjava/io/File;)Z
    //   408: pop
    //   409: goto -66 -> 343
    //   412: astore 7
    //   414: aload_0
    //   415: astore 7
    //   417: ldc 41
    //   419: iconst_1
    //   420: ldc_w 324
    //   423: invokestatic 327	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   426: aload_0
    //   427: astore 7
    //   429: aload_0
    //   430: invokestatic 330	com/tencent/mobileqq/camera/utils/CameraUtils:a	(Landroid/graphics/Bitmap;)Z
    //   433: pop
    //   434: new 15	java/io/File
    //   437: dup
    //   438: aload 9
    //   440: invokespecial 176	java/io/File:<init>	(Ljava/lang/String;)V
    //   443: invokevirtual 36	java/io/File:exists	()Z
    //   446: ifeq -74 -> 372
    //   449: aload_0
    //   450: ifnull -78 -> 372
    //   453: getstatic 304	com/tencent/mobileqq/app/GlobalImageCache:a	Landroid/support/v4/util/MQLruCache;
    //   456: aload 9
    //   458: aload_0
    //   459: invokevirtual 310	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   462: pop
    //   463: goto -91 -> 372
    //   466: astore 7
    //   468: aconst_null
    //   469: astore_0
    //   470: aload 7
    //   472: invokevirtual 331	java/io/IOException:printStackTrace	()V
    //   475: aload_0
    //   476: invokestatic 330	com/tencent/mobileqq/camera/utils/CameraUtils:a	(Landroid/graphics/Bitmap;)Z
    //   479: pop
    //   480: new 15	java/io/File
    //   483: dup
    //   484: aload 9
    //   486: invokespecial 176	java/io/File:<init>	(Ljava/lang/String;)V
    //   489: invokevirtual 36	java/io/File:exists	()Z
    //   492: ifeq -120 -> 372
    //   495: aload_0
    //   496: ifnull -124 -> 372
    //   499: getstatic 304	com/tencent/mobileqq/app/GlobalImageCache:a	Landroid/support/v4/util/MQLruCache;
    //   502: aload 9
    //   504: aload_0
    //   505: invokevirtual 310	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   508: pop
    //   509: goto -137 -> 372
    //   512: astore_0
    //   513: new 15	java/io/File
    //   516: dup
    //   517: aload 9
    //   519: invokespecial 176	java/io/File:<init>	(Ljava/lang/String;)V
    //   522: invokevirtual 36	java/io/File:exists	()Z
    //   525: ifeq +19 -> 544
    //   528: aload 7
    //   530: ifnull +14 -> 544
    //   533: getstatic 304	com/tencent/mobileqq/app/GlobalImageCache:a	Landroid/support/v4/util/MQLruCache;
    //   536: aload 9
    //   538: aload 7
    //   540: invokevirtual 310	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   543: pop
    //   544: aload_0
    //   545: athrow
    //   546: astore_0
    //   547: goto -34 -> 513
    //   550: astore 8
    //   552: aload_0
    //   553: astore 7
    //   555: aload 8
    //   557: astore_0
    //   558: goto -45 -> 513
    //   561: astore 7
    //   563: goto -93 -> 470
    //   566: astore_0
    //   567: aconst_null
    //   568: astore_0
    //   569: goto -155 -> 414
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	572	0	paramArrayOfByte	byte[]
    //   0	572	1	paramInt1	int
    //   0	572	2	paramInt2	int
    //   0	572	3	paramInt3	int
    //   0	572	4	paramInt4	int
    //   16	75	5	l	long
    //   1	391	7	arrayOfByte1	byte[]
    //   412	1	7	localOutOfMemoryError	OutOfMemoryError
    //   415	13	7	arrayOfByte2	byte[]
    //   466	73	7	localIOException1	java.io.IOException
    //   553	1	7	arrayOfByte3	byte[]
    //   561	1	7	localIOException2	java.io.IOException
    //   211	104	8	localBitmap	Bitmap
    //   550	6	8	localObject	Object
    //   102	435	9	str	String
    // Exception table:
    //   from	to	target	type
    //   271	277	412	java/lang/OutOfMemoryError
    //   280	307	412	java/lang/OutOfMemoryError
    //   314	331	412	java/lang/OutOfMemoryError
    //   334	343	412	java/lang/OutOfMemoryError
    //   393	409	412	java/lang/OutOfMemoryError
    //   190	213	466	java/io/IOException
    //   218	227	466	java/io/IOException
    //   259	268	466	java/io/IOException
    //   190	213	512	finally
    //   218	227	512	finally
    //   259	268	512	finally
    //   271	277	546	finally
    //   280	307	546	finally
    //   314	331	546	finally
    //   334	343	546	finally
    //   393	409	546	finally
    //   417	426	546	finally
    //   429	434	546	finally
    //   470	480	550	finally
    //   271	277	561	java/io/IOException
    //   280	307	561	java/io/IOException
    //   314	331	561	java/io/IOException
    //   334	343	561	java/io/IOException
    //   393	409	561	java/io/IOException
    //   190	213	566	java/lang/OutOfMemoryError
    //   218	227	566	java/lang/OutOfMemoryError
    //   259	268	566	java/lang/OutOfMemoryError
  }
  
  public static String a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    return a(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, null, false);
  }
  
  /* Error */
  public static String a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, android.graphics.RectF paramRectF, boolean paramBoolean)
  {
    // Byte code:
    //   0: invokestatic 203	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +88 -> 91
    //   6: aload_0
    //   7: ifnull +90 -> 97
    //   10: aload_0
    //   11: arraylength
    //   12: i2l
    //   13: lstore 9
    //   15: ldc 41
    //   17: iconst_2
    //   18: new 157	java/lang/StringBuilder
    //   21: dup
    //   22: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   25: ldc 247
    //   27: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: lload 9
    //   32: invokevirtual 198	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   35: ldc 249
    //   37: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: iload_2
    //   41: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   44: ldc 254
    //   46: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: iload_1
    //   50: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   53: ldc_w 256
    //   56: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: iload_3
    //   60: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   63: ldc_w 339
    //   66: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: iload 5
    //   71: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   74: ldc_w 341
    //   77: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: aload 6
    //   82: invokevirtual 344	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   85: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: invokestatic 49	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   91: aload_0
    //   92: ifnonnull +11 -> 103
    //   95: aconst_null
    //   96: areturn
    //   97: lconst_0
    //   98: lstore 9
    //   100: goto -85 -> 15
    //   103: invokestatic 260	com/tencent/mobileqq/ocr/OcrImageUtil:a	()Ljava/lang/String;
    //   106: iconst_1
    //   107: invokestatic 262	com/tencent/mobileqq/ocr/OcrImageUtil:a	(Ljava/lang/String;Z)Ljava/lang/String;
    //   110: astore 13
    //   112: iload 7
    //   114: ifeq +23 -> 137
    //   117: aload_0
    //   118: astore 11
    //   120: aload 11
    //   122: ifnonnull +89 -> 211
    //   125: ldc 41
    //   127: iconst_1
    //   128: ldc_w 279
    //   131: invokestatic 49	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   134: aload 13
    //   136: areturn
    //   137: iload_2
    //   138: ifle +19 -> 157
    //   141: iload_1
    //   142: ifle +15 -> 157
    //   145: iload_3
    //   146: bipush 17
    //   148: if_icmpeq +20 -> 168
    //   151: iload_3
    //   152: bipush 20
    //   154: if_icmpeq +14 -> 168
    //   157: ldc 41
    //   159: iconst_1
    //   160: ldc_w 264
    //   163: invokestatic 49	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   166: aconst_null
    //   167: areturn
    //   168: aload 13
    //   170: new 266	android/graphics/YuvImage
    //   173: dup
    //   174: aload_0
    //   175: iload_3
    //   176: iload_1
    //   177: iload_2
    //   178: aconst_null
    //   179: invokespecial 269	android/graphics/YuvImage:<init>	([BIII[I)V
    //   182: bipush 100
    //   184: invokestatic 272	com/tencent/mobileqq/ocr/OcrImageUtil:a	(Ljava/lang/String;Landroid/graphics/YuvImage;I)Z
    //   187: ifne +14 -> 201
    //   190: ldc 41
    //   192: iconst_1
    //   193: ldc_w 274
    //   196: invokestatic 49	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   199: aconst_null
    //   200: areturn
    //   201: aload 13
    //   203: invokestatic 277	com/tencent/mobileqq/ocr/OcrImageUtil:a	(Ljava/lang/String;)[B
    //   206: astore 11
    //   208: goto -88 -> 120
    //   211: aconst_null
    //   212: astore 12
    //   214: aload 12
    //   216: astore_0
    //   217: aload 11
    //   219: new 281	android/graphics/Rect
    //   222: dup
    //   223: iconst_0
    //   224: iconst_0
    //   225: getstatic 286	com/tencent/mobileqq/shortvideo/util/ScreenUtil:SCREEN_WIDTH	I
    //   228: getstatic 289	com/tencent/mobileqq/shortvideo/util/ScreenUtil:SCREEN_HIGHT	I
    //   231: invokespecial 292	android/graphics/Rect:<init>	(IIII)V
    //   234: iconst_0
    //   235: iconst_0
    //   236: invokestatic 297	com/tencent/mobileqq/camera/utils/CameraUtils:a	([BLandroid/graphics/Rect;ZI)Landroid/graphics/Bitmap;
    //   239: astore 14
    //   241: aload 14
    //   243: ifnonnull +47 -> 290
    //   246: aload 12
    //   248: astore_0
    //   249: ldc 41
    //   251: iconst_1
    //   252: ldc_w 299
    //   255: invokestatic 49	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   258: new 15	java/io/File
    //   261: dup
    //   262: aload 13
    //   264: invokespecial 176	java/io/File:<init>	(Ljava/lang/String;)V
    //   267: invokevirtual 36	java/io/File:exists	()Z
    //   270: ifeq +17 -> 287
    //   273: iconst_0
    //   274: ifeq +13 -> 287
    //   277: getstatic 304	com/tencent/mobileqq/app/GlobalImageCache:a	Landroid/support/v4/util/MQLruCache;
    //   280: aload 13
    //   282: aconst_null
    //   283: invokevirtual 310	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   286: pop
    //   287: aload 13
    //   289: areturn
    //   290: aload 12
    //   292: astore_0
    //   293: invokestatic 349	com/tencent/mobileqq/camera/CameraHolder:a	()Lcom/tencent/mobileqq/camera/CameraHolder;
    //   296: iload 4
    //   298: iload 5
    //   300: invokestatic 352	com/tencent/mobileqq/camera/utils/CameraUtils:a	(Lcom/tencent/mobileqq/camera/CameraHolder;II)I
    //   303: istore_3
    //   304: aload 12
    //   306: astore_0
    //   307: aload 14
    //   309: iload_3
    //   310: iconst_1
    //   311: invokestatic 313	com/tencent/mobileqq/camera/utils/CameraUtils:a	(Landroid/graphics/Bitmap;IZ)Landroid/graphics/Bitmap;
    //   314: astore 11
    //   316: aload 11
    //   318: astore_0
    //   319: aload_0
    //   320: astore 11
    //   322: invokestatic 203	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   325: ifeq +32 -> 357
    //   328: aload_0
    //   329: astore 11
    //   331: ldc 41
    //   333: iconst_2
    //   334: new 157	java/lang/StringBuilder
    //   337: dup
    //   338: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   341: ldc_w 315
    //   344: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: iload_3
    //   348: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   351: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   354: invokestatic 49	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   357: aload 6
    //   359: ifnull +394 -> 753
    //   362: aload_0
    //   363: ifnull +390 -> 753
    //   366: iload_1
    //   367: istore 4
    //   369: iload_2
    //   370: istore_3
    //   371: iload_1
    //   372: iload_2
    //   373: if_icmple +27 -> 400
    //   376: iload_1
    //   377: istore 4
    //   379: iload_2
    //   380: istore_3
    //   381: aload_0
    //   382: astore 11
    //   384: aload_0
    //   385: invokevirtual 357	android/graphics/Bitmap:getWidth	()I
    //   388: aload_0
    //   389: invokevirtual 360	android/graphics/Bitmap:getHeight	()I
    //   392: if_icmpge +8 -> 400
    //   395: iload_1
    //   396: istore_3
    //   397: iload_2
    //   398: istore 4
    //   400: aload_0
    //   401: astore 11
    //   403: aload 6
    //   405: getfield 365	android/graphics/RectF:left	F
    //   408: iload 4
    //   410: i2f
    //   411: fmul
    //   412: ldc_w 366
    //   415: fadd
    //   416: iload 4
    //   418: aload_0
    //   419: invokevirtual 357	android/graphics/Bitmap:getWidth	()I
    //   422: isub
    //   423: iconst_2
    //   424: idiv
    //   425: i2f
    //   426: fsub
    //   427: f2i
    //   428: istore_1
    //   429: aload_0
    //   430: astore 11
    //   432: aload 6
    //   434: getfield 369	android/graphics/RectF:top	F
    //   437: iload_3
    //   438: i2f
    //   439: fmul
    //   440: ldc_w 366
    //   443: fadd
    //   444: iload_3
    //   445: aload_0
    //   446: invokevirtual 360	android/graphics/Bitmap:getHeight	()I
    //   449: isub
    //   450: iconst_2
    //   451: idiv
    //   452: i2f
    //   453: fsub
    //   454: f2i
    //   455: istore 5
    //   457: iload_1
    //   458: ifgt +211 -> 669
    //   461: aload_0
    //   462: astore 11
    //   464: aload_0
    //   465: invokevirtual 357	android/graphics/Bitmap:getWidth	()I
    //   468: istore_2
    //   469: iconst_0
    //   470: istore_1
    //   471: iload 5
    //   473: ifgt +217 -> 690
    //   476: iconst_0
    //   477: istore_3
    //   478: aload_0
    //   479: astore 11
    //   481: aload_0
    //   482: invokevirtual 360	android/graphics/Bitmap:getHeight	()I
    //   485: istore 4
    //   487: aload_0
    //   488: astore 11
    //   490: aload_0
    //   491: iload_1
    //   492: iload_3
    //   493: iload_2
    //   494: iload 4
    //   496: invokestatic 373	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIII)Landroid/graphics/Bitmap;
    //   499: astore 12
    //   501: aload 12
    //   503: astore 6
    //   505: aload_0
    //   506: astore 11
    //   508: invokestatic 203	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   511: ifeq +64 -> 575
    //   514: aload_0
    //   515: astore 11
    //   517: ldc 41
    //   519: iconst_2
    //   520: iconst_3
    //   521: anewarray 4	java/lang/Object
    //   524: dup
    //   525: iconst_0
    //   526: new 157	java/lang/StringBuilder
    //   529: dup
    //   530: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   533: ldc_w 375
    //   536: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   539: aload 12
    //   541: invokevirtual 357	android/graphics/Bitmap:getWidth	()I
    //   544: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   547: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   550: aastore
    //   551: dup
    //   552: iconst_1
    //   553: ldc_w 377
    //   556: aastore
    //   557: dup
    //   558: iconst_2
    //   559: aload 12
    //   561: invokevirtual 360	android/graphics/Bitmap:getHeight	()I
    //   564: invokestatic 383	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   567: aastore
    //   568: invokestatic 386	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   571: aload 12
    //   573: astore 6
    //   575: aload 6
    //   577: ifnonnull +182 -> 759
    //   580: aload 6
    //   582: astore_0
    //   583: aload 6
    //   585: astore 11
    //   587: aload 14
    //   589: bipush 100
    //   591: new 15	java/io/File
    //   594: dup
    //   595: aload 13
    //   597: invokespecial 176	java/io/File:<init>	(Ljava/lang/String;)V
    //   600: invokestatic 320	com/tencent/mobileqq/utils/ImageUtil:b	(Landroid/graphics/Bitmap;ILjava/io/File;)Z
    //   603: pop
    //   604: aload 6
    //   606: astore_0
    //   607: aload 6
    //   609: astore 11
    //   611: ldc 41
    //   613: iconst_1
    //   614: ldc_w 322
    //   617: invokestatic 49	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   620: new 15	java/io/File
    //   623: dup
    //   624: aload 13
    //   626: invokespecial 176	java/io/File:<init>	(Ljava/lang/String;)V
    //   629: invokevirtual 36	java/io/File:exists	()Z
    //   632: ifeq +19 -> 651
    //   635: aload 6
    //   637: ifnull +14 -> 651
    //   640: getstatic 304	com/tencent/mobileqq/app/GlobalImageCache:a	Landroid/support/v4/util/MQLruCache;
    //   643: aload 13
    //   645: aload 6
    //   647: invokevirtual 310	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   650: pop
    //   651: new 15	java/io/File
    //   654: dup
    //   655: aload 13
    //   657: invokespecial 176	java/io/File:<init>	(Ljava/lang/String;)V
    //   660: invokevirtual 36	java/io/File:exists	()Z
    //   663: ifeq +266 -> 929
    //   666: aload 13
    //   668: areturn
    //   669: aload_0
    //   670: astore 11
    //   672: aload 6
    //   674: invokevirtual 389	android/graphics/RectF:width	()F
    //   677: iload 4
    //   679: i2f
    //   680: fmul
    //   681: ldc_w 366
    //   684: fadd
    //   685: f2i
    //   686: istore_2
    //   687: goto -216 -> 471
    //   690: aload_0
    //   691: astore 11
    //   693: aload 6
    //   695: invokevirtual 392	android/graphics/RectF:height	()F
    //   698: fstore 8
    //   700: fload 8
    //   702: iload_3
    //   703: i2f
    //   704: fmul
    //   705: ldc_w 366
    //   708: fadd
    //   709: f2i
    //   710: istore 4
    //   712: iload 5
    //   714: istore_3
    //   715: goto -228 -> 487
    //   718: astore 6
    //   720: aload_0
    //   721: astore 11
    //   723: ldc 41
    //   725: iconst_1
    //   726: new 157	java/lang/StringBuilder
    //   729: dup
    //   730: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   733: ldc_w 394
    //   736: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   739: aload 6
    //   741: invokevirtual 397	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   744: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   747: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   750: invokestatic 327	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   753: aload_0
    //   754: astore 6
    //   756: goto -181 -> 575
    //   759: aload 6
    //   761: astore_0
    //   762: aload 6
    //   764: astore 11
    //   766: aload 6
    //   768: bipush 100
    //   770: new 15	java/io/File
    //   773: dup
    //   774: aload 13
    //   776: invokespecial 176	java/io/File:<init>	(Ljava/lang/String;)V
    //   779: invokestatic 320	com/tencent/mobileqq/utils/ImageUtil:b	(Landroid/graphics/Bitmap;ILjava/io/File;)Z
    //   782: pop
    //   783: goto -163 -> 620
    //   786: astore 6
    //   788: aload_0
    //   789: astore 11
    //   791: ldc 41
    //   793: iconst_1
    //   794: ldc_w 324
    //   797: invokestatic 327	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   800: aload_0
    //   801: astore 11
    //   803: aload_0
    //   804: invokestatic 330	com/tencent/mobileqq/camera/utils/CameraUtils:a	(Landroid/graphics/Bitmap;)Z
    //   807: pop
    //   808: new 15	java/io/File
    //   811: dup
    //   812: aload 13
    //   814: invokespecial 176	java/io/File:<init>	(Ljava/lang/String;)V
    //   817: invokevirtual 36	java/io/File:exists	()Z
    //   820: ifeq -169 -> 651
    //   823: aload_0
    //   824: ifnull -173 -> 651
    //   827: getstatic 304	com/tencent/mobileqq/app/GlobalImageCache:a	Landroid/support/v4/util/MQLruCache;
    //   830: aload 13
    //   832: aload_0
    //   833: invokevirtual 310	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   836: pop
    //   837: goto -186 -> 651
    //   840: astore 6
    //   842: aconst_null
    //   843: astore_0
    //   844: aload_0
    //   845: astore 11
    //   847: aload 6
    //   849: invokevirtual 331	java/io/IOException:printStackTrace	()V
    //   852: aload_0
    //   853: astore 11
    //   855: aload_0
    //   856: invokestatic 330	com/tencent/mobileqq/camera/utils/CameraUtils:a	(Landroid/graphics/Bitmap;)Z
    //   859: pop
    //   860: new 15	java/io/File
    //   863: dup
    //   864: aload 13
    //   866: invokespecial 176	java/io/File:<init>	(Ljava/lang/String;)V
    //   869: invokevirtual 36	java/io/File:exists	()Z
    //   872: ifeq -221 -> 651
    //   875: aload_0
    //   876: ifnull -225 -> 651
    //   879: getstatic 304	com/tencent/mobileqq/app/GlobalImageCache:a	Landroid/support/v4/util/MQLruCache;
    //   882: aload 13
    //   884: aload_0
    //   885: invokevirtual 310	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   888: pop
    //   889: goto -238 -> 651
    //   892: astore_0
    //   893: aconst_null
    //   894: astore 11
    //   896: new 15	java/io/File
    //   899: dup
    //   900: aload 13
    //   902: invokespecial 176	java/io/File:<init>	(Ljava/lang/String;)V
    //   905: invokevirtual 36	java/io/File:exists	()Z
    //   908: ifeq +19 -> 927
    //   911: aload 11
    //   913: ifnull +14 -> 927
    //   916: getstatic 304	com/tencent/mobileqq/app/GlobalImageCache:a	Landroid/support/v4/util/MQLruCache;
    //   919: aload 13
    //   921: aload 11
    //   923: invokevirtual 310	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   926: pop
    //   927: aload_0
    //   928: athrow
    //   929: aconst_null
    //   930: areturn
    //   931: astore_0
    //   932: goto -36 -> 896
    //   935: astore_0
    //   936: goto -40 -> 896
    //   939: astore 6
    //   941: goto -97 -> 844
    //   944: astore 11
    //   946: aload 6
    //   948: astore_0
    //   949: aload 11
    //   951: astore 6
    //   953: goto -109 -> 844
    //   956: astore 6
    //   958: goto -170 -> 788
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	961	0	paramArrayOfByte	byte[]
    //   0	961	1	paramInt1	int
    //   0	961	2	paramInt2	int
    //   0	961	3	paramInt3	int
    //   0	961	4	paramInt4	int
    //   0	961	5	paramInt5	int
    //   0	961	6	paramRectF	android.graphics.RectF
    //   0	961	7	paramBoolean	boolean
    //   698	3	8	f	float
    //   13	86	9	l	long
    //   118	804	11	localObject	Object
    //   944	6	11	localIOException	java.io.IOException
    //   212	360	12	localBitmap1	Bitmap
    //   110	810	13	str	String
    //   239	349	14	localBitmap2	Bitmap
    // Exception table:
    //   from	to	target	type
    //   384	395	718	java/lang/Throwable
    //   403	429	718	java/lang/Throwable
    //   432	457	718	java/lang/Throwable
    //   464	469	718	java/lang/Throwable
    //   481	487	718	java/lang/Throwable
    //   490	501	718	java/lang/Throwable
    //   508	514	718	java/lang/Throwable
    //   517	571	718	java/lang/Throwable
    //   672	687	718	java/lang/Throwable
    //   693	700	718	java/lang/Throwable
    //   217	241	786	java/lang/OutOfMemoryError
    //   249	258	786	java/lang/OutOfMemoryError
    //   293	304	786	java/lang/OutOfMemoryError
    //   307	316	786	java/lang/OutOfMemoryError
    //   587	604	786	java/lang/OutOfMemoryError
    //   611	620	786	java/lang/OutOfMemoryError
    //   766	783	786	java/lang/OutOfMemoryError
    //   217	241	840	java/io/IOException
    //   249	258	840	java/io/IOException
    //   293	304	840	java/io/IOException
    //   307	316	840	java/io/IOException
    //   217	241	892	finally
    //   249	258	892	finally
    //   293	304	892	finally
    //   307	316	892	finally
    //   322	328	931	finally
    //   331	357	931	finally
    //   384	395	931	finally
    //   403	429	931	finally
    //   432	457	931	finally
    //   464	469	931	finally
    //   481	487	931	finally
    //   490	501	931	finally
    //   508	514	931	finally
    //   517	571	931	finally
    //   672	687	931	finally
    //   693	700	931	finally
    //   723	753	931	finally
    //   847	852	931	finally
    //   855	860	931	finally
    //   587	604	935	finally
    //   611	620	935	finally
    //   766	783	935	finally
    //   791	800	935	finally
    //   803	808	935	finally
    //   322	328	939	java/io/IOException
    //   331	357	939	java/io/IOException
    //   384	395	939	java/io/IOException
    //   403	429	939	java/io/IOException
    //   432	457	939	java/io/IOException
    //   464	469	939	java/io/IOException
    //   481	487	939	java/io/IOException
    //   490	501	939	java/io/IOException
    //   508	514	939	java/io/IOException
    //   517	571	939	java/io/IOException
    //   672	687	939	java/io/IOException
    //   693	700	939	java/io/IOException
    //   723	753	939	java/io/IOException
    //   587	604	944	java/io/IOException
    //   611	620	944	java/io/IOException
    //   766	783	944	java/io/IOException
    //   322	328	956	java/lang/OutOfMemoryError
    //   331	357	956	java/lang/OutOfMemoryError
    //   384	395	956	java/lang/OutOfMemoryError
    //   403	429	956	java/lang/OutOfMemoryError
    //   432	457	956	java/lang/OutOfMemoryError
    //   464	469	956	java/lang/OutOfMemoryError
    //   481	487	956	java/lang/OutOfMemoryError
    //   490	501	956	java/lang/OutOfMemoryError
    //   508	514	956	java/lang/OutOfMemoryError
    //   517	571	956	java/lang/OutOfMemoryError
    //   672	687	956	java/lang/OutOfMemoryError
    //   693	700	956	java/lang/OutOfMemoryError
    //   723	753	956	java/lang/OutOfMemoryError
  }
  
  /* Error */
  public static boolean a(Bitmap paramBitmap, String paramString, Bitmap.CompressFormat paramCompressFormat, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: new 15	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 176	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore 8
    //   10: aconst_null
    //   11: astore 9
    //   13: aconst_null
    //   14: astore 10
    //   16: new 400	java/io/BufferedOutputStream
    //   19: dup
    //   20: new 402	java/io/FileOutputStream
    //   23: dup
    //   24: aload 8
    //   26: invokespecial 405	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   29: invokespecial 408	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   32: astore 8
    //   34: aload 8
    //   36: astore 9
    //   38: aload_0
    //   39: aload_2
    //   40: iload_3
    //   41: aload 8
    //   43: invokevirtual 412	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   46: istore 5
    //   48: aload 8
    //   50: astore 9
    //   52: aload 8
    //   54: invokevirtual 415	java/io/BufferedOutputStream:flush	()V
    //   57: iload 4
    //   59: ifeq +11 -> 70
    //   62: aload 8
    //   64: astore 9
    //   66: aload_0
    //   67: invokevirtual 418	android/graphics/Bitmap:recycle	()V
    //   70: iload 5
    //   72: istore 4
    //   74: aload 8
    //   76: ifnull +12 -> 88
    //   79: aload 8
    //   81: invokevirtual 421	java/io/BufferedOutputStream:close	()V
    //   84: iload 5
    //   86: istore 4
    //   88: invokestatic 203	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   91: ifeq +100 -> 191
    //   94: lconst_0
    //   95: lstore 6
    //   97: new 15	java/io/File
    //   100: dup
    //   101: aload_1
    //   102: invokespecial 176	java/io/File:<init>	(Ljava/lang/String;)V
    //   105: invokevirtual 36	java/io/File:exists	()Z
    //   108: ifeq +20 -> 128
    //   111: new 15	java/io/File
    //   114: dup
    //   115: aload_1
    //   116: invokespecial 176	java/io/File:<init>	(Ljava/lang/String;)V
    //   119: invokevirtual 423	java/io/File:length	()J
    //   122: ldc2_w 424
    //   125: ldiv
    //   126: lstore 6
    //   128: ldc 41
    //   130: iconst_2
    //   131: new 157	java/lang/StringBuilder
    //   134: dup
    //   135: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   138: ldc_w 427
    //   141: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: aload_1
    //   145: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: ldc_w 256
    //   151: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: aload_2
    //   155: invokevirtual 344	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   158: ldc_w 429
    //   161: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: iload_3
    //   165: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   168: ldc_w 431
    //   171: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: lload 6
    //   176: invokevirtual 198	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   179: ldc_w 433
    //   182: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   188: invokestatic 49	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   191: iload 4
    //   193: ireturn
    //   194: astore_0
    //   195: aload_0
    //   196: invokevirtual 331	java/io/IOException:printStackTrace	()V
    //   199: iload 5
    //   201: istore 4
    //   203: goto -115 -> 88
    //   206: astore_0
    //   207: aconst_null
    //   208: astore 8
    //   210: iconst_0
    //   211: istore 5
    //   213: aload 8
    //   215: astore 9
    //   217: ldc 41
    //   219: iconst_1
    //   220: ldc_w 435
    //   223: aload_0
    //   224: invokestatic 438	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   227: iload 5
    //   229: istore 4
    //   231: aload 8
    //   233: ifnull -145 -> 88
    //   236: aload 8
    //   238: invokevirtual 421	java/io/BufferedOutputStream:close	()V
    //   241: iload 5
    //   243: istore 4
    //   245: goto -157 -> 88
    //   248: astore_0
    //   249: aload_0
    //   250: invokevirtual 331	java/io/IOException:printStackTrace	()V
    //   253: iload 5
    //   255: istore 4
    //   257: goto -169 -> 88
    //   260: astore_0
    //   261: iconst_0
    //   262: istore 5
    //   264: aload 10
    //   266: astore_0
    //   267: aload_0
    //   268: astore 9
    //   270: ldc 41
    //   272: iconst_1
    //   273: ldc_w 440
    //   276: invokestatic 327	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   279: iload 5
    //   281: istore 4
    //   283: aload_0
    //   284: ifnull -196 -> 88
    //   287: aload_0
    //   288: invokevirtual 421	java/io/BufferedOutputStream:close	()V
    //   291: iload 5
    //   293: istore 4
    //   295: goto -207 -> 88
    //   298: astore_0
    //   299: aload_0
    //   300: invokevirtual 331	java/io/IOException:printStackTrace	()V
    //   303: iload 5
    //   305: istore 4
    //   307: goto -219 -> 88
    //   310: astore_0
    //   311: aload 9
    //   313: ifnull +8 -> 321
    //   316: aload 9
    //   318: invokevirtual 421	java/io/BufferedOutputStream:close	()V
    //   321: aload_0
    //   322: athrow
    //   323: astore_1
    //   324: aload_1
    //   325: invokevirtual 331	java/io/IOException:printStackTrace	()V
    //   328: goto -7 -> 321
    //   331: astore_0
    //   332: goto -21 -> 311
    //   335: astore_0
    //   336: aload 8
    //   338: astore_0
    //   339: iconst_0
    //   340: istore 5
    //   342: goto -75 -> 267
    //   345: astore_0
    //   346: aload 8
    //   348: astore_0
    //   349: goto -82 -> 267
    //   352: astore_0
    //   353: iconst_0
    //   354: istore 5
    //   356: goto -143 -> 213
    //   359: astore_0
    //   360: goto -147 -> 213
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	363	0	paramBitmap	Bitmap
    //   0	363	1	paramString	String
    //   0	363	2	paramCompressFormat	Bitmap.CompressFormat
    //   0	363	3	paramInt	int
    //   0	363	4	paramBoolean	boolean
    //   46	309	5	bool	boolean
    //   95	80	6	l	long
    //   8	339	8	localObject1	Object
    //   11	306	9	localObject2	Object
    //   14	251	10	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   79	84	194	java/io/IOException
    //   16	34	206	java/lang/Exception
    //   236	241	248	java/io/IOException
    //   16	34	260	java/lang/OutOfMemoryError
    //   287	291	298	java/io/IOException
    //   16	34	310	finally
    //   270	279	310	finally
    //   316	321	323	java/io/IOException
    //   38	48	331	finally
    //   52	57	331	finally
    //   66	70	331	finally
    //   217	227	331	finally
    //   38	48	335	java/lang/OutOfMemoryError
    //   52	57	345	java/lang/OutOfMemoryError
    //   66	70	345	java/lang/OutOfMemoryError
    //   38	48	352	java/lang/Exception
    //   52	57	359	java/lang/Exception
    //   66	70	359	java/lang/Exception
  }
  
  public static boolean a(String paramString)
  {
    paramString = PhotoUtils.getImageMimeType(paramString);
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
    //   2: new 402	java/io/FileOutputStream
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 464	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   10: astore 5
    //   12: aload_1
    //   13: ifnull +31 -> 44
    //   16: aload 5
    //   18: astore_0
    //   19: aload_1
    //   20: new 281	android/graphics/Rect
    //   23: dup
    //   24: iconst_0
    //   25: iconst_0
    //   26: aload_1
    //   27: invokevirtual 465	android/graphics/YuvImage:getWidth	()I
    //   30: aload_1
    //   31: invokevirtual 466	android/graphics/YuvImage:getHeight	()I
    //   34: invokespecial 292	android/graphics/Rect:<init>	(IIII)V
    //   37: iload_2
    //   38: aload 5
    //   40: invokevirtual 470	android/graphics/YuvImage:compressToJpeg	(Landroid/graphics/Rect;ILjava/io/OutputStream;)Z
    //   43: pop
    //   44: aload 5
    //   46: astore_0
    //   47: aload 5
    //   49: invokevirtual 471	java/io/FileOutputStream:flush	()V
    //   52: iconst_1
    //   53: istore 4
    //   55: iload 4
    //   57: istore_3
    //   58: aload 5
    //   60: ifnull +11 -> 71
    //   63: aload 5
    //   65: invokevirtual 472	java/io/FileOutputStream:close	()V
    //   68: iload 4
    //   70: istore_3
    //   71: iload_3
    //   72: ireturn
    //   73: astore_0
    //   74: aload_0
    //   75: invokevirtual 331	java/io/IOException:printStackTrace	()V
    //   78: iconst_1
    //   79: ireturn
    //   80: astore 6
    //   82: aconst_null
    //   83: astore_1
    //   84: aload_1
    //   85: astore_0
    //   86: aload 6
    //   88: invokevirtual 174	java/lang/Exception:printStackTrace	()V
    //   91: aload_1
    //   92: ifnull -21 -> 71
    //   95: aload_1
    //   96: invokevirtual 472	java/io/FileOutputStream:close	()V
    //   99: iconst_0
    //   100: ireturn
    //   101: astore_0
    //   102: aload_0
    //   103: invokevirtual 331	java/io/IOException:printStackTrace	()V
    //   106: iconst_0
    //   107: ireturn
    //   108: astore_1
    //   109: aconst_null
    //   110: astore_0
    //   111: aload_0
    //   112: ifnull +7 -> 119
    //   115: aload_0
    //   116: invokevirtual 472	java/io/FileOutputStream:close	()V
    //   119: aload_1
    //   120: athrow
    //   121: astore_0
    //   122: aload_0
    //   123: invokevirtual 331	java/io/IOException:printStackTrace	()V
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
    if (TextUtils.isEmpty(paramString2))
    {
      QLog.d("Q.ocr.image", 1, "compressImage, newImagePath is empty");
      return false;
    }
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString1, (BitmapFactory.Options)localObject);
    int n = ((BitmapFactory.Options)localObject).outHeight;
    int m = ((BitmapFactory.Options)localObject).outWidth;
    int i;
    label91:
    int k;
    if (OcrDpc.a() != null) {
      if (OcrDpc.a().c < 400)
      {
        i = 400;
        if (OcrDpc.a().b >= 10) {
          break label392;
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
              break label309;
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
              label309:
              paramString1.printStackTrace();
              label392:
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
            break label91;
            if ((m >= n) || (m <= k)) {
              break label454;
            }
            f = k * 1.0F / m;
            continue;
          }
        }
        return false;
        label454:
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
    //   0: new 15	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 176	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: aload_0
    //   10: invokevirtual 423	java/io/File:length	()J
    //   13: l2i
    //   14: newarray byte
    //   16: astore_2
    //   17: new 536	java/io/BufferedInputStream
    //   20: dup
    //   21: new 538	java/io/FileInputStream
    //   24: dup
    //   25: aload_0
    //   26: invokespecial 539	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   29: invokespecial 542	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   32: astore_1
    //   33: aload_1
    //   34: astore_0
    //   35: aload_1
    //   36: aload_2
    //   37: iconst_0
    //   38: aload_2
    //   39: arraylength
    //   40: invokevirtual 546	java/io/BufferedInputStream:read	([BII)I
    //   43: pop
    //   44: aload_1
    //   45: astore_0
    //   46: aload_1
    //   47: invokevirtual 547	java/io/BufferedInputStream:close	()V
    //   50: aload_1
    //   51: invokevirtual 547	java/io/BufferedInputStream:close	()V
    //   54: aload_2
    //   55: astore_0
    //   56: aload_0
    //   57: ifnull +10 -> 67
    //   60: aload_0
    //   61: astore_1
    //   62: aload_0
    //   63: arraylength
    //   64: ifne +14 -> 78
    //   67: ldc 41
    //   69: iconst_1
    //   70: ldc_w 549
    //   73: invokestatic 49	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   76: aconst_null
    //   77: astore_1
    //   78: aload_1
    //   79: areturn
    //   80: astore_0
    //   81: aload_0
    //   82: invokevirtual 174	java/lang/Exception:printStackTrace	()V
    //   85: aload_2
    //   86: astore_0
    //   87: goto -31 -> 56
    //   90: astore_2
    //   91: aconst_null
    //   92: astore_1
    //   93: aload_1
    //   94: astore_0
    //   95: aload_2
    //   96: invokevirtual 550	java/io/FileNotFoundException:printStackTrace	()V
    //   99: aload_1
    //   100: invokevirtual 547	java/io/BufferedInputStream:close	()V
    //   103: aconst_null
    //   104: astore_0
    //   105: goto -49 -> 56
    //   108: astore_0
    //   109: aload_0
    //   110: invokevirtual 174	java/lang/Exception:printStackTrace	()V
    //   113: aconst_null
    //   114: astore_0
    //   115: goto -59 -> 56
    //   118: astore_2
    //   119: aconst_null
    //   120: astore_1
    //   121: aload_1
    //   122: astore_0
    //   123: aload_2
    //   124: invokevirtual 331	java/io/IOException:printStackTrace	()V
    //   127: aload_1
    //   128: invokevirtual 547	java/io/BufferedInputStream:close	()V
    //   131: aconst_null
    //   132: astore_0
    //   133: goto -77 -> 56
    //   136: astore_0
    //   137: aload_0
    //   138: invokevirtual 174	java/lang/Exception:printStackTrace	()V
    //   141: aconst_null
    //   142: astore_0
    //   143: goto -87 -> 56
    //   146: astore_1
    //   147: aconst_null
    //   148: astore_0
    //   149: aload_0
    //   150: invokevirtual 547	java/io/BufferedInputStream:close	()V
    //   153: aload_1
    //   154: athrow
    //   155: astore_0
    //   156: aload_0
    //   157: invokevirtual 174	java/lang/Exception:printStackTrace	()V
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OcrImageUtil
 * JD-Core Version:    0.7.0.1
 */