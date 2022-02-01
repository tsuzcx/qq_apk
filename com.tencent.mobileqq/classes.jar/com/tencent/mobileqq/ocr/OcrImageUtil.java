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
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.gallery.picocr.PicOcrResultBean;
import com.tencent.mobileqq.ocr.data.OcrDpc;
import com.tencent.mobileqq.utils.BasePhotoUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class OcrImageUtil
{
  public static String a;
  public static boolean a = true;
  public static String b;
  public static String c;
  
  static
  {
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
    float f4 = paramInt1;
    if (f3 > f4) {
      for (;;)
      {
        f1 = f2;
        if (f3 <= f4) {
          break;
        }
        f2 -= 1.0F;
        paramPaint.setTextSize(f2);
        f3 = paramPaint.measureText(paramString);
      }
    }
    float f5 = 0.97F * f4;
    float f1 = f2;
    if (f3 < f5)
    {
      while (f3 < f5)
      {
        f2 += 1.0F;
        paramPaint.setTextSize(f2);
        f3 = paramPaint.measureText(paramString);
      }
      f1 = f2;
      if (f3 > f4) {
        f1 = f2 - 1.0F;
      }
    }
    paramString = paramPaint.getFontMetrics();
    f3 = paramString.descent;
    for (f2 = paramString.ascent; f3 - f2 > paramInt2; f2 = paramString.ascent)
    {
      f1 -= 1.0F;
      paramPaint.setTextSize(f1);
      paramString = paramPaint.getFontMetrics();
      f3 = paramString.descent;
    }
    return f1;
  }
  
  public static Bitmap a(String paramString, BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    try
    {
      Bitmap localBitmap = BitmapFactory.decodeFile(paramString, paramOptions);
      return localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      label10:
      break label10;
    }
    if (paramInt1 < paramInt2)
    {
      paramOptions.inSampleSize += 1;
      return a(paramString, paramOptions, paramInt1 + 1, paramInt2);
    }
    return null;
  }
  
  public static Point a(Point paramPoint1, Point paramPoint2, Point paramPoint3, Point paramPoint4)
  {
    double d5 = paramPoint2.x - paramPoint1.x;
    double d1 = paramPoint3.x - paramPoint4.x;
    double d6 = paramPoint2.y - paramPoint1.y;
    double d2 = paramPoint3.y - paramPoint4.y;
    double d3 = paramPoint3.x - paramPoint1.x;
    double d4 = paramPoint3.y - paramPoint1.y;
    Double.isNaN(d5);
    Double.isNaN(d2);
    Double.isNaN(d1);
    Double.isNaN(d6);
    d5 = d5 * d2 - d6 * d1;
    if (Math.abs(d5) < 0.001D) {
      return null;
    }
    Double.isNaN(d2);
    Double.isNaN(d3);
    Double.isNaN(d1);
    Double.isNaN(d4);
    d2 = (d2 * d3 - d1 * d4) / d5;
    d1 = paramPoint1.x;
    d3 = paramPoint2.x - paramPoint1.x;
    Double.isNaN(d3);
    Double.isNaN(d1);
    d1 += d3 * d2;
    d3 = paramPoint1.y;
    d4 = paramPoint2.y - paramPoint1.y;
    Double.isNaN(d4);
    Double.isNaN(d3);
    d2 = d3 + d2 * d4;
    d3 = paramPoint4.x;
    Double.isNaN(d3);
    if (Math.abs(d1 - d3) < 5.0D)
    {
      d3 = paramPoint4.y;
      Double.isNaN(d3);
      if (Math.abs(d2 - d3) < 5.0D) {
        return new Point(paramPoint4);
      }
    }
    return new Point((int)d1, (int)d2);
  }
  
  private static String a()
  {
    try
    {
      Object localObject = new SimpleDateFormat("yyyyMMddHHmmss");
      Date localDate = new Date(System.currentTimeMillis());
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(((SimpleDateFormat)localObject).format(localDate));
      localStringBuilder.append(".jpg");
      localObject = localStringBuilder.toString();
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
    String str;
    try
    {
      Object localObject2 = new File(paramString).getName();
      int i = ((String)localObject2).lastIndexOf('.');
      Object localObject1 = localObject2;
      if (i > -1)
      {
        localObject1 = localObject2;
        if (i < ((String)localObject2).length()) {
          localObject1 = ((String)localObject2).substring(0, i);
        }
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("_");
      ((StringBuilder)localObject2).append(System.currentTimeMillis());
      ((StringBuilder)localObject2).append(".tmp");
      localObject1 = ((StringBuilder)localObject2).toString();
      localObject1 = new File(c, (String)localObject1).getAbsolutePath();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      str = "";
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.ocr.image", 2, String.format("getCachePath oldPath: %s, newPath: %s", new Object[] { paramString, str }));
    }
    return str;
  }
  
  public static String a(String paramString, boolean paramBoolean)
  {
    try
    {
      Object localObject = new File(jdField_a_of_type_JavaLangString);
      File localFile = new File(b);
      boolean bool = ((File)localObject).exists();
      if ((!bool) && (!((File)localObject).mkdir())) {
        QLog.d("Q.ocr.image", 1, "getImagePath WTF! mk ocr dir failed!");
      }
      if ((!localFile.exists()) && (!localFile.mkdir())) {
        QLog.d("Q.ocr.image", 1, "getImagePath WTF! mk ocr preview dir failed!");
      }
      if (paramBoolean) {
        localObject = b;
      } else {
        localObject = jdField_a_of_type_JavaLangString;
      }
      paramString = new File((String)localObject, paramString).getAbsolutePath();
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
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
    //   0: invokestatic 212	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +119 -> 122
    //   6: aload_0
    //   7: ifnull +11 -> 18
    //   10: aload_0
    //   11: arraylength
    //   12: i2l
    //   13: lstore 5
    //   15: goto +6 -> 21
    //   18: lconst_0
    //   19: lstore 5
    //   21: new 164	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 165	java/lang/StringBuilder:<init>	()V
    //   28: astore 7
    //   30: aload 7
    //   32: ldc 254
    //   34: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: pop
    //   38: aload 7
    //   40: lload 5
    //   42: invokevirtual 205	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: aload 7
    //   48: ldc_w 256
    //   51: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: pop
    //   55: aload 7
    //   57: iload_2
    //   58: invokevirtual 259	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: aload 7
    //   64: ldc_w 261
    //   67: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: aload 7
    //   73: iload_1
    //   74: invokevirtual 259	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   77: pop
    //   78: aload 7
    //   80: ldc_w 263
    //   83: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: pop
    //   87: aload 7
    //   89: iload_3
    //   90: invokevirtual 259	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   93: pop
    //   94: aload 7
    //   96: ldc_w 265
    //   99: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: pop
    //   103: aload 7
    //   105: iload 4
    //   107: invokevirtual 259	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   110: pop
    //   111: ldc 42
    //   113: iconst_2
    //   114: aload 7
    //   116: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: invokestatic 50	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   122: aload_0
    //   123: ifnonnull +5 -> 128
    //   126: aconst_null
    //   127: areturn
    //   128: invokestatic 267	com/tencent/mobileqq/ocr/OcrImageUtil:a	()Ljava/lang/String;
    //   131: iconst_1
    //   132: invokestatic 269	com/tencent/mobileqq/ocr/OcrImageUtil:a	(Ljava/lang/String;Z)Ljava/lang/String;
    //   135: astore 9
    //   137: iload_2
    //   138: ifle +501 -> 639
    //   141: iload_1
    //   142: ifle +497 -> 639
    //   145: iload_3
    //   146: bipush 17
    //   148: if_icmpeq +12 -> 160
    //   151: iload_3
    //   152: bipush 20
    //   154: if_icmpeq +6 -> 160
    //   157: goto +482 -> 639
    //   160: aload 9
    //   162: new 271	android/graphics/YuvImage
    //   165: dup
    //   166: aload_0
    //   167: iload_3
    //   168: iload_1
    //   169: iload_2
    //   170: aconst_null
    //   171: invokespecial 274	android/graphics/YuvImage:<init>	([BIII[I)V
    //   174: bipush 100
    //   176: invokestatic 277	com/tencent/mobileqq/ocr/OcrImageUtil:a	(Ljava/lang/String;Landroid/graphics/YuvImage;I)Z
    //   179: ifne +14 -> 193
    //   182: ldc 42
    //   184: iconst_1
    //   185: ldc_w 279
    //   188: invokestatic 50	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   191: aconst_null
    //   192: areturn
    //   193: aload 9
    //   195: invokestatic 282	com/tencent/mobileqq/ocr/OcrImageUtil:a	(Ljava/lang/String;)[B
    //   198: astore_0
    //   199: aload_0
    //   200: ifnonnull +15 -> 215
    //   203: ldc 42
    //   205: iconst_1
    //   206: ldc_w 284
    //   209: invokestatic 50	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   212: aload 9
    //   214: areturn
    //   215: new 286	android/graphics/Rect
    //   218: dup
    //   219: iconst_0
    //   220: iconst_0
    //   221: getstatic 291	com/tencent/mobileqq/shortvideo/util/ScreenUtil:SCREEN_WIDTH	I
    //   224: getstatic 294	com/tencent/mobileqq/shortvideo/util/ScreenUtil:SCREEN_HIGHT	I
    //   227: invokespecial 297	android/graphics/Rect:<init>	(IIII)V
    //   230: astore 7
    //   232: ldc_w 299
    //   235: invokestatic 305	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   238: checkcast 299	com/tencent/mobileqq/qqcamera/api/ICameraUtils
    //   241: aload_0
    //   242: aload 7
    //   244: iconst_0
    //   245: iconst_0
    //   246: invokeinterface 309 5 0
    //   251: astore 8
    //   253: aload 8
    //   255: ifnonnull +28 -> 283
    //   258: ldc 42
    //   260: iconst_1
    //   261: ldc_w 311
    //   264: invokestatic 50	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   267: new 14	java/io/File
    //   270: dup
    //   271: aload 9
    //   273: invokespecial 183	java/io/File:<init>	(Ljava/lang/String;)V
    //   276: invokevirtual 35	java/io/File:exists	()Z
    //   279: pop
    //   280: aload 9
    //   282: areturn
    //   283: ldc_w 299
    //   286: invokestatic 305	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   289: checkcast 299	com/tencent/mobileqq/qqcamera/api/ICameraUtils
    //   292: aload 8
    //   294: iload 4
    //   296: iconst_1
    //   297: invokeinterface 315 4 0
    //   302: astore 7
    //   304: aload 7
    //   306: astore_0
    //   307: invokestatic 212	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   310: ifeq +52 -> 362
    //   313: aload 7
    //   315: astore_0
    //   316: new 164	java/lang/StringBuilder
    //   319: dup
    //   320: invokespecial 165	java/lang/StringBuilder:<init>	()V
    //   323: astore 10
    //   325: aload 7
    //   327: astore_0
    //   328: aload 10
    //   330: ldc_w 317
    //   333: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   336: pop
    //   337: aload 7
    //   339: astore_0
    //   340: aload 10
    //   342: iload 4
    //   344: invokevirtual 259	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   347: pop
    //   348: aload 7
    //   350: astore_0
    //   351: ldc 42
    //   353: iconst_2
    //   354: aload 10
    //   356: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   359: invokestatic 50	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   362: aload 7
    //   364: ifnonnull +38 -> 402
    //   367: aload 7
    //   369: astore_0
    //   370: aload 8
    //   372: bipush 100
    //   374: new 14	java/io/File
    //   377: dup
    //   378: aload 9
    //   380: invokespecial 183	java/io/File:<init>	(Ljava/lang/String;)V
    //   383: invokestatic 322	com/tencent/mobileqq/utils/BaseImageUtil:b	(Landroid/graphics/Bitmap;ILjava/io/File;)Z
    //   386: pop
    //   387: aload 7
    //   389: astore_0
    //   390: ldc 42
    //   392: iconst_1
    //   393: ldc_w 324
    //   396: invokestatic 50	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   399: goto +23 -> 422
    //   402: aload 7
    //   404: astore_0
    //   405: aload 7
    //   407: bipush 100
    //   409: new 14	java/io/File
    //   412: dup
    //   413: aload 9
    //   415: invokespecial 183	java/io/File:<init>	(Ljava/lang/String;)V
    //   418: invokestatic 322	com/tencent/mobileqq/utils/BaseImageUtil:b	(Landroid/graphics/Bitmap;ILjava/io/File;)Z
    //   421: pop
    //   422: new 14	java/io/File
    //   425: dup
    //   426: aload 9
    //   428: invokespecial 183	java/io/File:<init>	(Ljava/lang/String;)V
    //   431: invokevirtual 35	java/io/File:exists	()Z
    //   434: ifeq +153 -> 587
    //   437: aload 7
    //   439: ifnull +148 -> 587
    //   442: goto +68 -> 510
    //   445: astore 8
    //   447: goto +15 -> 462
    //   450: astore 7
    //   452: aconst_null
    //   453: astore_0
    //   454: goto +153 -> 607
    //   457: astore 8
    //   459: aconst_null
    //   460: astore 7
    //   462: aload 7
    //   464: astore_0
    //   465: aload 8
    //   467: invokevirtual 325	java/io/IOException:printStackTrace	()V
    //   470: aload 7
    //   472: astore_0
    //   473: ldc_w 299
    //   476: invokestatic 305	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   479: checkcast 299	com/tencent/mobileqq/qqcamera/api/ICameraUtils
    //   482: aload 7
    //   484: invokeinterface 329 2 0
    //   489: pop
    //   490: new 14	java/io/File
    //   493: dup
    //   494: aload 9
    //   496: invokespecial 183	java/io/File:<init>	(Ljava/lang/String;)V
    //   499: invokevirtual 35	java/io/File:exists	()Z
    //   502: ifeq +85 -> 587
    //   505: aload 7
    //   507: ifnull +80 -> 587
    //   510: getstatic 334	com/tencent/mobileqq/app/GlobalImageCache:a	Landroid/support/v4/util/MQLruCache;
    //   513: aload 9
    //   515: aload 7
    //   517: invokevirtual 340	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   520: pop
    //   521: goto +66 -> 587
    //   524: astore 7
    //   526: goto +81 -> 607
    //   529: aconst_null
    //   530: astore 7
    //   532: aload 7
    //   534: astore_0
    //   535: ldc 42
    //   537: iconst_1
    //   538: ldc_w 342
    //   541: invokestatic 345	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   544: aload 7
    //   546: astore_0
    //   547: ldc_w 299
    //   550: invokestatic 305	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   553: checkcast 299	com/tencent/mobileqq/qqcamera/api/ICameraUtils
    //   556: aload 7
    //   558: invokeinterface 329 2 0
    //   563: pop
    //   564: new 14	java/io/File
    //   567: dup
    //   568: aload 9
    //   570: invokespecial 183	java/io/File:<init>	(Ljava/lang/String;)V
    //   573: invokevirtual 35	java/io/File:exists	()Z
    //   576: ifeq +11 -> 587
    //   579: aload 7
    //   581: ifnull +6 -> 587
    //   584: goto -74 -> 510
    //   587: new 14	java/io/File
    //   590: dup
    //   591: aload 9
    //   593: invokespecial 183	java/io/File:<init>	(Ljava/lang/String;)V
    //   596: invokevirtual 35	java/io/File:exists	()Z
    //   599: ifeq +6 -> 605
    //   602: aload 9
    //   604: areturn
    //   605: aconst_null
    //   606: areturn
    //   607: new 14	java/io/File
    //   610: dup
    //   611: aload 9
    //   613: invokespecial 183	java/io/File:<init>	(Ljava/lang/String;)V
    //   616: invokevirtual 35	java/io/File:exists	()Z
    //   619: ifeq +17 -> 636
    //   622: aload_0
    //   623: ifnull +13 -> 636
    //   626: getstatic 334	com/tencent/mobileqq/app/GlobalImageCache:a	Landroid/support/v4/util/MQLruCache;
    //   629: aload 9
    //   631: aload_0
    //   632: invokevirtual 340	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   635: pop
    //   636: aload 7
    //   638: athrow
    //   639: ldc 42
    //   641: iconst_1
    //   642: ldc_w 347
    //   645: invokestatic 50	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   648: aconst_null
    //   649: areturn
    //   650: astore_0
    //   651: goto -122 -> 529
    //   654: astore_0
    //   655: goto -123 -> 532
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	658	0	paramArrayOfByte	byte[]
    //   0	658	1	paramInt1	int
    //   0	658	2	paramInt2	int
    //   0	658	3	paramInt3	int
    //   0	658	4	paramInt4	int
    //   13	28	5	l	long
    //   28	410	7	localObject1	Object
    //   450	1	7	localObject2	Object
    //   460	56	7	localBitmap1	Bitmap
    //   524	1	7	localObject3	Object
    //   530	107	7	localBitmap2	Bitmap
    //   251	120	8	localBitmap3	Bitmap
    //   445	1	8	localIOException1	java.io.IOException
    //   457	9	8	localIOException2	java.io.IOException
    //   135	495	9	str	String
    //   323	32	10	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   307	313	445	java/io/IOException
    //   316	325	445	java/io/IOException
    //   328	337	445	java/io/IOException
    //   340	348	445	java/io/IOException
    //   351	362	445	java/io/IOException
    //   370	387	445	java/io/IOException
    //   390	399	445	java/io/IOException
    //   405	422	445	java/io/IOException
    //   215	253	450	finally
    //   258	267	450	finally
    //   283	304	450	finally
    //   215	253	457	java/io/IOException
    //   258	267	457	java/io/IOException
    //   283	304	457	java/io/IOException
    //   307	313	524	finally
    //   316	325	524	finally
    //   328	337	524	finally
    //   340	348	524	finally
    //   351	362	524	finally
    //   370	387	524	finally
    //   390	399	524	finally
    //   405	422	524	finally
    //   465	470	524	finally
    //   473	490	524	finally
    //   535	544	524	finally
    //   547	564	524	finally
    //   215	253	650	java/lang/OutOfMemoryError
    //   258	267	650	java/lang/OutOfMemoryError
    //   283	304	650	java/lang/OutOfMemoryError
    //   307	313	654	java/lang/OutOfMemoryError
    //   316	325	654	java/lang/OutOfMemoryError
    //   328	337	654	java/lang/OutOfMemoryError
    //   340	348	654	java/lang/OutOfMemoryError
    //   351	362	654	java/lang/OutOfMemoryError
    //   370	387	654	java/lang/OutOfMemoryError
    //   390	399	654	java/lang/OutOfMemoryError
    //   405	422	654	java/lang/OutOfMemoryError
  }
  
  public static String a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    return a(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, null, false);
  }
  
  /* Error */
  public static String a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, android.graphics.RectF paramRectF, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: astore 15
    //   3: iload_1
    //   4: istore 12
    //   6: iload_2
    //   7: istore 11
    //   9: invokestatic 212	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12: ifeq +140 -> 152
    //   15: aload 15
    //   17: ifnull +12 -> 29
    //   20: aload 15
    //   22: arraylength
    //   23: i2l
    //   24: lstore 13
    //   26: goto +6 -> 32
    //   29: lconst_0
    //   30: lstore 13
    //   32: new 164	java/lang/StringBuilder
    //   35: dup
    //   36: invokespecial 165	java/lang/StringBuilder:<init>	()V
    //   39: astore 16
    //   41: aload 16
    //   43: ldc 254
    //   45: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: pop
    //   49: aload 16
    //   51: lload 13
    //   53: invokevirtual 205	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: aload 16
    //   59: ldc_w 256
    //   62: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: pop
    //   66: aload 16
    //   68: iload 11
    //   70: invokevirtual 259	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   73: pop
    //   74: aload 16
    //   76: ldc_w 261
    //   79: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: pop
    //   83: aload 16
    //   85: iload 12
    //   87: invokevirtual 259	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   90: pop
    //   91: aload 16
    //   93: ldc_w 263
    //   96: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: pop
    //   100: aload 16
    //   102: iload_3
    //   103: invokevirtual 259	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   106: pop
    //   107: aload 16
    //   109: ldc_w 355
    //   112: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: pop
    //   116: aload 16
    //   118: iload 5
    //   120: invokevirtual 259	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   123: pop
    //   124: aload 16
    //   126: ldc_w 357
    //   129: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: pop
    //   133: aload 16
    //   135: aload 6
    //   137: invokevirtual 360	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   140: pop
    //   141: ldc 42
    //   143: iconst_2
    //   144: aload 16
    //   146: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   149: invokestatic 50	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   152: aload 15
    //   154: ifnonnull +5 -> 159
    //   157: aconst_null
    //   158: areturn
    //   159: invokestatic 267	com/tencent/mobileqq/ocr/OcrImageUtil:a	()Ljava/lang/String;
    //   162: iconst_1
    //   163: invokestatic 269	com/tencent/mobileqq/ocr/OcrImageUtil:a	(Ljava/lang/String;Z)Ljava/lang/String;
    //   166: astore 19
    //   168: iload 7
    //   170: ifeq +6 -> 176
    //   173: goto +68 -> 241
    //   176: iload 11
    //   178: ifle +1096 -> 1274
    //   181: iload 12
    //   183: ifle +1091 -> 1274
    //   186: iload_3
    //   187: bipush 17
    //   189: if_icmpeq +12 -> 201
    //   192: iload_3
    //   193: bipush 20
    //   195: if_icmpeq +6 -> 201
    //   198: goto +1076 -> 1274
    //   201: aload 19
    //   203: new 271	android/graphics/YuvImage
    //   206: dup
    //   207: aload_0
    //   208: iload_3
    //   209: iload_1
    //   210: iload_2
    //   211: aconst_null
    //   212: invokespecial 274	android/graphics/YuvImage:<init>	([BIII[I)V
    //   215: bipush 100
    //   217: invokestatic 277	com/tencent/mobileqq/ocr/OcrImageUtil:a	(Ljava/lang/String;Landroid/graphics/YuvImage;I)Z
    //   220: ifne +14 -> 234
    //   223: ldc 42
    //   225: iconst_1
    //   226: ldc_w 279
    //   229: invokestatic 50	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   232: aconst_null
    //   233: areturn
    //   234: aload 19
    //   236: invokestatic 282	com/tencent/mobileqq/ocr/OcrImageUtil:a	(Ljava/lang/String;)[B
    //   239: astore 15
    //   241: aload 15
    //   243: ifnonnull +15 -> 258
    //   246: ldc 42
    //   248: iconst_1
    //   249: ldc_w 284
    //   252: invokestatic 50	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   255: aload 19
    //   257: areturn
    //   258: new 286	android/graphics/Rect
    //   261: dup
    //   262: iconst_0
    //   263: iconst_0
    //   264: getstatic 291	com/tencent/mobileqq/shortvideo/util/ScreenUtil:SCREEN_WIDTH	I
    //   267: getstatic 294	com/tencent/mobileqq/shortvideo/util/ScreenUtil:SCREEN_HIGHT	I
    //   270: invokespecial 297	android/graphics/Rect:<init>	(IIII)V
    //   273: astore_0
    //   274: ldc_w 299
    //   277: invokestatic 305	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   280: checkcast 299	com/tencent/mobileqq/qqcamera/api/ICameraUtils
    //   283: aload 15
    //   285: aload_0
    //   286: iconst_0
    //   287: iconst_0
    //   288: invokeinterface 309 5 0
    //   293: astore 20
    //   295: aload 20
    //   297: ifnonnull +28 -> 325
    //   300: ldc 42
    //   302: iconst_1
    //   303: ldc_w 311
    //   306: invokestatic 50	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   309: new 14	java/io/File
    //   312: dup
    //   313: aload 19
    //   315: invokespecial 183	java/io/File:<init>	(Ljava/lang/String;)V
    //   318: invokevirtual 35	java/io/File:exists	()Z
    //   321: pop
    //   322: aload 19
    //   324: areturn
    //   325: ldc_w 299
    //   328: invokestatic 305	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   331: checkcast 299	com/tencent/mobileqq/qqcamera/api/ICameraUtils
    //   334: iload 4
    //   336: iload 5
    //   338: invokeinterface 364 3 0
    //   343: istore_1
    //   344: ldc_w 299
    //   347: invokestatic 305	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   350: checkcast 299	com/tencent/mobileqq/qqcamera/api/ICameraUtils
    //   353: aload 20
    //   355: iload_1
    //   356: iconst_1
    //   357: invokeinterface 315 4 0
    //   362: astore 16
    //   364: aload 16
    //   366: astore 17
    //   368: aload 16
    //   370: astore 15
    //   372: aload 16
    //   374: astore 18
    //   376: invokestatic 212	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   379: ifeq +83 -> 462
    //   382: aload 16
    //   384: astore 17
    //   386: aload 16
    //   388: astore 15
    //   390: aload 16
    //   392: astore 18
    //   394: new 164	java/lang/StringBuilder
    //   397: dup
    //   398: invokespecial 165	java/lang/StringBuilder:<init>	()V
    //   401: astore_0
    //   402: aload 16
    //   404: astore 17
    //   406: aload 16
    //   408: astore 15
    //   410: aload 16
    //   412: astore 18
    //   414: aload_0
    //   415: ldc_w 317
    //   418: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   421: pop
    //   422: aload 16
    //   424: astore 17
    //   426: aload 16
    //   428: astore 15
    //   430: aload 16
    //   432: astore 18
    //   434: aload_0
    //   435: iload_1
    //   436: invokevirtual 259	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   439: pop
    //   440: aload 16
    //   442: astore 17
    //   444: aload 16
    //   446: astore 15
    //   448: aload 16
    //   450: astore 18
    //   452: ldc 42
    //   454: iconst_2
    //   455: aload_0
    //   456: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   459: invokestatic 50	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   462: aload 16
    //   464: astore_0
    //   465: aload 6
    //   467: ifnull +519 -> 986
    //   470: aload 16
    //   472: astore_0
    //   473: aload 16
    //   475: ifnull +511 -> 986
    //   478: iload 12
    //   480: iload 11
    //   482: if_icmple +814 -> 1296
    //   485: aload 16
    //   487: astore 17
    //   489: aload 16
    //   491: astore 15
    //   493: aload 16
    //   495: astore 18
    //   497: aload 16
    //   499: invokevirtual 369	android/graphics/Bitmap:getWidth	()I
    //   502: aload 16
    //   504: invokevirtual 372	android/graphics/Bitmap:getHeight	()I
    //   507: if_icmpge +789 -> 1296
    //   510: iload 11
    //   512: istore_1
    //   513: goto +3 -> 516
    //   516: aload 16
    //   518: astore 17
    //   520: aload 16
    //   522: astore 15
    //   524: aload 16
    //   526: astore 18
    //   528: aload 6
    //   530: getfield 377	android/graphics/RectF:left	F
    //   533: fstore 9
    //   535: iload_1
    //   536: i2f
    //   537: fstore 8
    //   539: aload 16
    //   541: astore 17
    //   543: aload 16
    //   545: astore 15
    //   547: aload 16
    //   549: astore 18
    //   551: fload 9
    //   553: fload 8
    //   555: fmul
    //   556: ldc_w 378
    //   559: fadd
    //   560: iload_1
    //   561: aload 16
    //   563: invokevirtual 369	android/graphics/Bitmap:getWidth	()I
    //   566: isub
    //   567: iconst_2
    //   568: idiv
    //   569: i2f
    //   570: fsub
    //   571: f2i
    //   572: istore_2
    //   573: aload 16
    //   575: astore 17
    //   577: aload 16
    //   579: astore 15
    //   581: aload 16
    //   583: astore 18
    //   585: aload 6
    //   587: getfield 381	android/graphics/RectF:top	F
    //   590: fstore 9
    //   592: iload 12
    //   594: i2f
    //   595: fstore 10
    //   597: aload 16
    //   599: astore 17
    //   601: aload 16
    //   603: astore 15
    //   605: aload 16
    //   607: astore 18
    //   609: fload 9
    //   611: fload 10
    //   613: fmul
    //   614: ldc_w 378
    //   617: fadd
    //   618: iload 12
    //   620: aload 16
    //   622: invokevirtual 372	android/graphics/Bitmap:getHeight	()I
    //   625: isub
    //   626: iconst_2
    //   627: idiv
    //   628: i2f
    //   629: fsub
    //   630: f2i
    //   631: istore 4
    //   633: iload_2
    //   634: ifgt +26 -> 660
    //   637: aload 16
    //   639: astore 17
    //   641: aload 16
    //   643: astore 15
    //   645: aload 16
    //   647: astore 18
    //   649: aload 16
    //   651: invokevirtual 369	android/graphics/Bitmap:getWidth	()I
    //   654: istore_1
    //   655: iconst_0
    //   656: istore_2
    //   657: goto +29 -> 686
    //   660: aload 16
    //   662: astore 17
    //   664: aload 16
    //   666: astore 15
    //   668: aload 16
    //   670: astore 18
    //   672: aload 6
    //   674: invokevirtual 384	android/graphics/RectF:width	()F
    //   677: fload 8
    //   679: fmul
    //   680: ldc_w 378
    //   683: fadd
    //   684: f2i
    //   685: istore_1
    //   686: iload 4
    //   688: ifgt +27 -> 715
    //   691: aload 16
    //   693: astore 17
    //   695: aload 16
    //   697: astore 15
    //   699: aload 16
    //   701: astore 18
    //   703: aload 16
    //   705: invokevirtual 372	android/graphics/Bitmap:getHeight	()I
    //   708: istore_3
    //   709: iconst_0
    //   710: istore 4
    //   712: goto +29 -> 741
    //   715: aload 16
    //   717: astore 17
    //   719: aload 16
    //   721: astore 15
    //   723: aload 16
    //   725: astore 18
    //   727: aload 6
    //   729: invokevirtual 387	android/graphics/RectF:height	()F
    //   732: fload 10
    //   734: fmul
    //   735: ldc_w 378
    //   738: fadd
    //   739: f2i
    //   740: istore_3
    //   741: aload 16
    //   743: astore 17
    //   745: aload 16
    //   747: astore 15
    //   749: aload 16
    //   751: astore 18
    //   753: aload 16
    //   755: iload_2
    //   756: iload 4
    //   758: iload_1
    //   759: iload_3
    //   760: invokestatic 391	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIII)Landroid/graphics/Bitmap;
    //   763: astore_0
    //   764: aload 16
    //   766: astore 17
    //   768: aload 16
    //   770: astore 15
    //   772: aload 16
    //   774: astore 18
    //   776: invokestatic 212	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   779: ifeq +113 -> 892
    //   782: aload 16
    //   784: astore 17
    //   786: aload 16
    //   788: astore 15
    //   790: aload 16
    //   792: astore 18
    //   794: new 164	java/lang/StringBuilder
    //   797: dup
    //   798: invokespecial 165	java/lang/StringBuilder:<init>	()V
    //   801: astore 6
    //   803: aload 16
    //   805: astore 17
    //   807: aload 16
    //   809: astore 15
    //   811: aload 16
    //   813: astore 18
    //   815: aload 6
    //   817: ldc_w 393
    //   820: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   823: pop
    //   824: aload 16
    //   826: astore 17
    //   828: aload 16
    //   830: astore 15
    //   832: aload 16
    //   834: astore 18
    //   836: aload 6
    //   838: aload_0
    //   839: invokevirtual 369	android/graphics/Bitmap:getWidth	()I
    //   842: invokevirtual 259	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   845: pop
    //   846: aload 16
    //   848: astore 17
    //   850: aload 16
    //   852: astore 15
    //   854: aload 16
    //   856: astore 18
    //   858: ldc 42
    //   860: iconst_2
    //   861: iconst_3
    //   862: anewarray 4	java/lang/Object
    //   865: dup
    //   866: iconst_0
    //   867: aload 6
    //   869: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   872: aastore
    //   873: dup
    //   874: iconst_1
    //   875: ldc_w 395
    //   878: aastore
    //   879: dup
    //   880: iconst_2
    //   881: aload_0
    //   882: invokevirtual 372	android/graphics/Bitmap:getHeight	()I
    //   885: invokestatic 401	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   888: aastore
    //   889: invokestatic 404	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   892: goto +94 -> 986
    //   895: astore_0
    //   896: aload 16
    //   898: astore 17
    //   900: aload 16
    //   902: astore 15
    //   904: aload 16
    //   906: astore 18
    //   908: new 164	java/lang/StringBuilder
    //   911: dup
    //   912: invokespecial 165	java/lang/StringBuilder:<init>	()V
    //   915: astore 6
    //   917: aload 16
    //   919: astore 17
    //   921: aload 16
    //   923: astore 15
    //   925: aload 16
    //   927: astore 18
    //   929: aload 6
    //   931: ldc_w 406
    //   934: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   937: pop
    //   938: aload 16
    //   940: astore 17
    //   942: aload 16
    //   944: astore 15
    //   946: aload 16
    //   948: astore 18
    //   950: aload 6
    //   952: aload_0
    //   953: invokevirtual 409	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   956: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   959: pop
    //   960: aload 16
    //   962: astore 17
    //   964: aload 16
    //   966: astore 15
    //   968: aload 16
    //   970: astore 18
    //   972: ldc 42
    //   974: iconst_1
    //   975: aload 6
    //   977: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   980: invokestatic 345	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   983: aload 16
    //   985: astore_0
    //   986: aload_0
    //   987: ifnonnull +50 -> 1037
    //   990: aload_0
    //   991: astore 17
    //   993: aload_0
    //   994: astore 15
    //   996: aload_0
    //   997: astore 18
    //   999: aload 20
    //   1001: bipush 100
    //   1003: new 14	java/io/File
    //   1006: dup
    //   1007: aload 19
    //   1009: invokespecial 183	java/io/File:<init>	(Ljava/lang/String;)V
    //   1012: invokestatic 322	com/tencent/mobileqq/utils/BaseImageUtil:b	(Landroid/graphics/Bitmap;ILjava/io/File;)Z
    //   1015: pop
    //   1016: aload_0
    //   1017: astore 17
    //   1019: aload_0
    //   1020: astore 15
    //   1022: aload_0
    //   1023: astore 18
    //   1025: ldc 42
    //   1027: iconst_1
    //   1028: ldc_w 324
    //   1031: invokestatic 50	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1034: goto +28 -> 1062
    //   1037: aload_0
    //   1038: astore 17
    //   1040: aload_0
    //   1041: astore 15
    //   1043: aload_0
    //   1044: astore 18
    //   1046: aload_0
    //   1047: bipush 100
    //   1049: new 14	java/io/File
    //   1052: dup
    //   1053: aload 19
    //   1055: invokespecial 183	java/io/File:<init>	(Ljava/lang/String;)V
    //   1058: invokestatic 322	com/tencent/mobileqq/utils/BaseImageUtil:b	(Landroid/graphics/Bitmap;ILjava/io/File;)Z
    //   1061: pop
    //   1062: new 14	java/io/File
    //   1065: dup
    //   1066: aload 19
    //   1068: invokespecial 183	java/io/File:<init>	(Ljava/lang/String;)V
    //   1071: invokevirtual 35	java/io/File:exists	()Z
    //   1074: ifeq +147 -> 1221
    //   1077: aload_0
    //   1078: ifnull +143 -> 1221
    //   1081: goto +68 -> 1149
    //   1084: astore 6
    //   1086: aload 17
    //   1088: astore_0
    //   1089: goto +14 -> 1103
    //   1092: astore_0
    //   1093: aconst_null
    //   1094: astore 15
    //   1096: goto +145 -> 1241
    //   1099: astore 6
    //   1101: aconst_null
    //   1102: astore_0
    //   1103: aload_0
    //   1104: astore 15
    //   1106: aload 6
    //   1108: invokevirtual 325	java/io/IOException:printStackTrace	()V
    //   1111: aload_0
    //   1112: astore 15
    //   1114: ldc_w 299
    //   1117: invokestatic 305	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   1120: checkcast 299	com/tencent/mobileqq/qqcamera/api/ICameraUtils
    //   1123: aload_0
    //   1124: invokeinterface 329 2 0
    //   1129: pop
    //   1130: new 14	java/io/File
    //   1133: dup
    //   1134: aload 19
    //   1136: invokespecial 183	java/io/File:<init>	(Ljava/lang/String;)V
    //   1139: invokevirtual 35	java/io/File:exists	()Z
    //   1142: ifeq +79 -> 1221
    //   1145: aload_0
    //   1146: ifnull +75 -> 1221
    //   1149: getstatic 334	com/tencent/mobileqq/app/GlobalImageCache:a	Landroid/support/v4/util/MQLruCache;
    //   1152: aload 19
    //   1154: aload_0
    //   1155: invokevirtual 340	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1158: pop
    //   1159: goto +62 -> 1221
    //   1162: astore_0
    //   1163: goto +78 -> 1241
    //   1166: aconst_null
    //   1167: astore_0
    //   1168: aload_0
    //   1169: astore 15
    //   1171: ldc 42
    //   1173: iconst_1
    //   1174: ldc_w 342
    //   1177: invokestatic 345	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1180: aload_0
    //   1181: astore 15
    //   1183: ldc_w 299
    //   1186: invokestatic 305	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   1189: checkcast 299	com/tencent/mobileqq/qqcamera/api/ICameraUtils
    //   1192: aload_0
    //   1193: invokeinterface 329 2 0
    //   1198: pop
    //   1199: new 14	java/io/File
    //   1202: dup
    //   1203: aload 19
    //   1205: invokespecial 183	java/io/File:<init>	(Ljava/lang/String;)V
    //   1208: invokevirtual 35	java/io/File:exists	()Z
    //   1211: ifeq +10 -> 1221
    //   1214: aload_0
    //   1215: ifnull +6 -> 1221
    //   1218: goto -69 -> 1149
    //   1221: new 14	java/io/File
    //   1224: dup
    //   1225: aload 19
    //   1227: invokespecial 183	java/io/File:<init>	(Ljava/lang/String;)V
    //   1230: invokevirtual 35	java/io/File:exists	()Z
    //   1233: ifeq +6 -> 1239
    //   1236: aload 19
    //   1238: areturn
    //   1239: aconst_null
    //   1240: areturn
    //   1241: new 14	java/io/File
    //   1244: dup
    //   1245: aload 19
    //   1247: invokespecial 183	java/io/File:<init>	(Ljava/lang/String;)V
    //   1250: invokevirtual 35	java/io/File:exists	()Z
    //   1253: ifeq +19 -> 1272
    //   1256: aload 15
    //   1258: ifnull +14 -> 1272
    //   1261: getstatic 334	com/tencent/mobileqq/app/GlobalImageCache:a	Landroid/support/v4/util/MQLruCache;
    //   1264: aload 19
    //   1266: aload 15
    //   1268: invokevirtual 340	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1271: pop
    //   1272: aload_0
    //   1273: athrow
    //   1274: ldc 42
    //   1276: iconst_1
    //   1277: ldc_w 347
    //   1280: invokestatic 50	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1283: aconst_null
    //   1284: areturn
    //   1285: astore_0
    //   1286: goto -120 -> 1166
    //   1289: astore_0
    //   1290: aload 18
    //   1292: astore_0
    //   1293: goto -125 -> 1168
    //   1296: iload 12
    //   1298: istore_1
    //   1299: iload 11
    //   1301: istore 12
    //   1303: goto -787 -> 516
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1306	0	paramArrayOfByte	byte[]
    //   0	1306	1	paramInt1	int
    //   0	1306	2	paramInt2	int
    //   0	1306	3	paramInt3	int
    //   0	1306	4	paramInt4	int
    //   0	1306	5	paramInt5	int
    //   0	1306	6	paramRectF	android.graphics.RectF
    //   0	1306	7	paramBoolean	boolean
    //   537	141	8	f1	float
    //   533	77	9	f2	float
    //   595	138	10	f3	float
    //   7	1293	11	i	int
    //   4	1298	12	j	int
    //   24	28	13	l	long
    //   1	1266	15	localObject1	Object
    //   39	945	16	localObject2	Object
    //   366	721	17	localObject3	Object
    //   374	917	18	localObject4	Object
    //   166	1099	19	str	String
    //   293	707	20	localBitmap	Bitmap
    // Exception table:
    //   from	to	target	type
    //   497	510	895	java/lang/Throwable
    //   528	535	895	java/lang/Throwable
    //   551	573	895	java/lang/Throwable
    //   585	592	895	java/lang/Throwable
    //   609	633	895	java/lang/Throwable
    //   649	655	895	java/lang/Throwable
    //   672	686	895	java/lang/Throwable
    //   703	709	895	java/lang/Throwable
    //   727	741	895	java/lang/Throwable
    //   753	764	895	java/lang/Throwable
    //   776	782	895	java/lang/Throwable
    //   794	803	895	java/lang/Throwable
    //   815	824	895	java/lang/Throwable
    //   836	846	895	java/lang/Throwable
    //   858	892	895	java/lang/Throwable
    //   376	382	1084	java/io/IOException
    //   394	402	1084	java/io/IOException
    //   414	422	1084	java/io/IOException
    //   434	440	1084	java/io/IOException
    //   452	462	1084	java/io/IOException
    //   497	510	1084	java/io/IOException
    //   528	535	1084	java/io/IOException
    //   551	573	1084	java/io/IOException
    //   585	592	1084	java/io/IOException
    //   609	633	1084	java/io/IOException
    //   649	655	1084	java/io/IOException
    //   672	686	1084	java/io/IOException
    //   703	709	1084	java/io/IOException
    //   727	741	1084	java/io/IOException
    //   753	764	1084	java/io/IOException
    //   776	782	1084	java/io/IOException
    //   794	803	1084	java/io/IOException
    //   815	824	1084	java/io/IOException
    //   836	846	1084	java/io/IOException
    //   858	892	1084	java/io/IOException
    //   908	917	1084	java/io/IOException
    //   929	938	1084	java/io/IOException
    //   950	960	1084	java/io/IOException
    //   972	983	1084	java/io/IOException
    //   999	1016	1084	java/io/IOException
    //   1025	1034	1084	java/io/IOException
    //   1046	1062	1084	java/io/IOException
    //   258	295	1092	finally
    //   300	309	1092	finally
    //   325	364	1092	finally
    //   258	295	1099	java/io/IOException
    //   300	309	1099	java/io/IOException
    //   325	364	1099	java/io/IOException
    //   376	382	1162	finally
    //   394	402	1162	finally
    //   414	422	1162	finally
    //   434	440	1162	finally
    //   452	462	1162	finally
    //   497	510	1162	finally
    //   528	535	1162	finally
    //   551	573	1162	finally
    //   585	592	1162	finally
    //   609	633	1162	finally
    //   649	655	1162	finally
    //   672	686	1162	finally
    //   703	709	1162	finally
    //   727	741	1162	finally
    //   753	764	1162	finally
    //   776	782	1162	finally
    //   794	803	1162	finally
    //   815	824	1162	finally
    //   836	846	1162	finally
    //   858	892	1162	finally
    //   908	917	1162	finally
    //   929	938	1162	finally
    //   950	960	1162	finally
    //   972	983	1162	finally
    //   999	1016	1162	finally
    //   1025	1034	1162	finally
    //   1046	1062	1162	finally
    //   1106	1111	1162	finally
    //   1114	1130	1162	finally
    //   1171	1180	1162	finally
    //   1183	1199	1162	finally
    //   258	295	1285	java/lang/OutOfMemoryError
    //   300	309	1285	java/lang/OutOfMemoryError
    //   325	364	1285	java/lang/OutOfMemoryError
    //   376	382	1289	java/lang/OutOfMemoryError
    //   394	402	1289	java/lang/OutOfMemoryError
    //   414	422	1289	java/lang/OutOfMemoryError
    //   434	440	1289	java/lang/OutOfMemoryError
    //   452	462	1289	java/lang/OutOfMemoryError
    //   497	510	1289	java/lang/OutOfMemoryError
    //   528	535	1289	java/lang/OutOfMemoryError
    //   551	573	1289	java/lang/OutOfMemoryError
    //   585	592	1289	java/lang/OutOfMemoryError
    //   609	633	1289	java/lang/OutOfMemoryError
    //   649	655	1289	java/lang/OutOfMemoryError
    //   672	686	1289	java/lang/OutOfMemoryError
    //   703	709	1289	java/lang/OutOfMemoryError
    //   727	741	1289	java/lang/OutOfMemoryError
    //   753	764	1289	java/lang/OutOfMemoryError
    //   776	782	1289	java/lang/OutOfMemoryError
    //   794	803	1289	java/lang/OutOfMemoryError
    //   815	824	1289	java/lang/OutOfMemoryError
    //   836	846	1289	java/lang/OutOfMemoryError
    //   858	892	1289	java/lang/OutOfMemoryError
    //   908	917	1289	java/lang/OutOfMemoryError
    //   929	938	1289	java/lang/OutOfMemoryError
    //   950	960	1289	java/lang/OutOfMemoryError
    //   972	983	1289	java/lang/OutOfMemoryError
    //   999	1016	1289	java/lang/OutOfMemoryError
    //   1025	1034	1289	java/lang/OutOfMemoryError
    //   1046	1062	1289	java/lang/OutOfMemoryError
  }
  
  /* Error */
  public static boolean a(Bitmap paramBitmap, String paramString, Bitmap.CompressFormat paramCompressFormat, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: new 14	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 183	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore 12
    //   10: iconst_0
    //   11: istore 5
    //   13: iconst_0
    //   14: istore 8
    //   16: iconst_0
    //   17: istore 7
    //   19: iconst_0
    //   20: istore 6
    //   22: aconst_null
    //   23: astore 14
    //   25: aconst_null
    //   26: astore 13
    //   28: aconst_null
    //   29: astore 11
    //   31: new 412	java/io/BufferedOutputStream
    //   34: dup
    //   35: new 414	java/io/FileOutputStream
    //   38: dup
    //   39: aload 12
    //   41: invokespecial 417	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   44: invokespecial 420	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   47: astore 12
    //   49: aload_0
    //   50: aload_2
    //   51: iload_3
    //   52: aload 12
    //   54: invokevirtual 424	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   57: istore 5
    //   59: iload 5
    //   61: istore 6
    //   63: iload 5
    //   65: istore 7
    //   67: aload 12
    //   69: invokevirtual 427	java/io/BufferedOutputStream:flush	()V
    //   72: iload 4
    //   74: ifeq +15 -> 89
    //   77: iload 5
    //   79: istore 6
    //   81: iload 5
    //   83: istore 7
    //   85: aload_0
    //   86: invokevirtual 430	android/graphics/Bitmap:recycle	()V
    //   89: iload 5
    //   91: istore 4
    //   93: aload 12
    //   95: invokevirtual 433	java/io/BufferedOutputStream:close	()V
    //   98: iload 5
    //   100: istore 4
    //   102: goto +127 -> 229
    //   105: astore_0
    //   106: aload_0
    //   107: invokevirtual 325	java/io/IOException:printStackTrace	()V
    //   110: goto +119 -> 229
    //   113: astore_0
    //   114: aload 12
    //   116: astore 11
    //   118: goto +237 -> 355
    //   121: aload 12
    //   123: astore_0
    //   124: iload 7
    //   126: istore 5
    //   128: goto +23 -> 151
    //   131: astore 11
    //   133: aload 12
    //   135: astore_0
    //   136: iload 6
    //   138: istore 5
    //   140: aload 11
    //   142: astore 12
    //   144: goto +51 -> 195
    //   147: astore_0
    //   148: goto +207 -> 355
    //   151: aload_0
    //   152: astore 11
    //   154: ldc 42
    //   156: iconst_1
    //   157: ldc_w 435
    //   160: invokestatic 345	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   163: iload 5
    //   165: istore 4
    //   167: aload_0
    //   168: ifnull +61 -> 229
    //   171: iload 5
    //   173: istore 4
    //   175: aload_0
    //   176: invokevirtual 433	java/io/BufferedOutputStream:close	()V
    //   179: iload 5
    //   181: istore 4
    //   183: goto +46 -> 229
    //   186: astore 12
    //   188: aload 13
    //   190: astore_0
    //   191: iload 8
    //   193: istore 5
    //   195: aload_0
    //   196: astore 11
    //   198: ldc 42
    //   200: iconst_1
    //   201: ldc_w 437
    //   204: aload 12
    //   206: invokestatic 440	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   209: iload 5
    //   211: istore 4
    //   213: aload_0
    //   214: ifnull +15 -> 229
    //   217: iload 5
    //   219: istore 4
    //   221: aload_0
    //   222: invokevirtual 433	java/io/BufferedOutputStream:close	()V
    //   225: iload 5
    //   227: istore 4
    //   229: invokestatic 212	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   232: ifeq +120 -> 352
    //   235: lconst_0
    //   236: lstore 9
    //   238: new 14	java/io/File
    //   241: dup
    //   242: aload_1
    //   243: invokespecial 183	java/io/File:<init>	(Ljava/lang/String;)V
    //   246: invokevirtual 35	java/io/File:exists	()Z
    //   249: ifeq +20 -> 269
    //   252: new 14	java/io/File
    //   255: dup
    //   256: aload_1
    //   257: invokespecial 183	java/io/File:<init>	(Ljava/lang/String;)V
    //   260: invokevirtual 442	java/io/File:length	()J
    //   263: ldc2_w 443
    //   266: ldiv
    //   267: lstore 9
    //   269: new 164	java/lang/StringBuilder
    //   272: dup
    //   273: invokespecial 165	java/lang/StringBuilder:<init>	()V
    //   276: astore_0
    //   277: aload_0
    //   278: ldc_w 446
    //   281: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: pop
    //   285: aload_0
    //   286: aload_1
    //   287: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: pop
    //   291: aload_0
    //   292: ldc_w 263
    //   295: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: pop
    //   299: aload_0
    //   300: aload_2
    //   301: invokevirtual 360	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   304: pop
    //   305: aload_0
    //   306: ldc_w 448
    //   309: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: pop
    //   313: aload_0
    //   314: iload_3
    //   315: invokevirtual 259	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   318: pop
    //   319: aload_0
    //   320: ldc_w 450
    //   323: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: pop
    //   327: aload_0
    //   328: lload 9
    //   330: invokevirtual 205	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   333: pop
    //   334: aload_0
    //   335: ldc_w 452
    //   338: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: pop
    //   342: ldc 42
    //   344: iconst_2
    //   345: aload_0
    //   346: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   349: invokestatic 50	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   352: iload 4
    //   354: ireturn
    //   355: aload 11
    //   357: ifnull +16 -> 373
    //   360: aload 11
    //   362: invokevirtual 433	java/io/BufferedOutputStream:close	()V
    //   365: goto +8 -> 373
    //   368: astore_1
    //   369: aload_1
    //   370: invokevirtual 325	java/io/IOException:printStackTrace	()V
    //   373: aload_0
    //   374: athrow
    //   375: astore_0
    //   376: aload 14
    //   378: astore_0
    //   379: goto -228 -> 151
    //   382: astore_0
    //   383: goto -262 -> 121
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	386	0	paramBitmap	Bitmap
    //   0	386	1	paramString	String
    //   0	386	2	paramCompressFormat	Bitmap.CompressFormat
    //   0	386	3	paramInt	int
    //   0	386	4	paramBoolean	boolean
    //   11	215	5	bool1	boolean
    //   20	117	6	bool2	boolean
    //   17	108	7	bool3	boolean
    //   14	178	8	bool4	boolean
    //   236	93	9	l	long
    //   29	88	11	localObject1	Object
    //   131	10	11	localException1	Exception
    //   152	209	11	localBitmap	Bitmap
    //   8	135	12	localObject2	Object
    //   186	19	12	localException2	Exception
    //   26	163	13	localObject3	Object
    //   23	354	14	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   93	98	105	java/io/IOException
    //   175	179	105	java/io/IOException
    //   221	225	105	java/io/IOException
    //   49	59	113	finally
    //   67	72	113	finally
    //   85	89	113	finally
    //   49	59	131	java/lang/Exception
    //   67	72	131	java/lang/Exception
    //   85	89	131	java/lang/Exception
    //   31	49	147	finally
    //   154	163	147	finally
    //   198	209	147	finally
    //   31	49	186	java/lang/Exception
    //   360	365	368	java/io/IOException
    //   31	49	375	java/lang/OutOfMemoryError
    //   49	59	382	java/lang/OutOfMemoryError
    //   67	72	382	java/lang/OutOfMemoryError
    //   85	89	382	java/lang/OutOfMemoryError
  }
  
  public static boolean a(String paramString)
  {
    paramString = BasePhotoUtils.getImageMimeType(paramString);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkImageFormat format:");
      localStringBuilder.append(paramString);
      QLog.d("Q.ocr.image", 2, localStringBuilder.toString());
    }
    return (!TextUtils.isEmpty(paramString)) || ("image/bmp".equalsIgnoreCase(paramString)) || ("image/jpeg".equalsIgnoreCase(paramString)) || ("image/png".equalsIgnoreCase(paramString));
  }
  
  /* Error */
  public static boolean a(String paramString, android.graphics.YuvImage paramYuvImage, int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aconst_null
    //   3: astore 5
    //   5: aconst_null
    //   6: astore 4
    //   8: new 414	java/io/FileOutputStream
    //   11: dup
    //   12: aload_0
    //   13: invokespecial 476	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   16: astore_0
    //   17: aload_1
    //   18: ifnull +27 -> 45
    //   21: aload_1
    //   22: new 286	android/graphics/Rect
    //   25: dup
    //   26: iconst_0
    //   27: iconst_0
    //   28: aload_1
    //   29: invokevirtual 477	android/graphics/YuvImage:getWidth	()I
    //   32: aload_1
    //   33: invokevirtual 478	android/graphics/YuvImage:getHeight	()I
    //   36: invokespecial 297	android/graphics/Rect:<init>	(IIII)V
    //   39: iload_2
    //   40: aload_0
    //   41: invokevirtual 482	android/graphics/YuvImage:compressToJpeg	(Landroid/graphics/Rect;ILjava/io/OutputStream;)Z
    //   44: pop
    //   45: aload_0
    //   46: invokevirtual 483	java/io/FileOutputStream:flush	()V
    //   49: iconst_1
    //   50: istore_3
    //   51: aload_0
    //   52: invokevirtual 484	java/io/FileOutputStream:close	()V
    //   55: iconst_1
    //   56: ireturn
    //   57: astore_0
    //   58: aload_0
    //   59: invokevirtual 325	java/io/IOException:printStackTrace	()V
    //   62: iload_3
    //   63: ireturn
    //   64: astore_1
    //   65: goto +35 -> 100
    //   68: astore_1
    //   69: goto +14 -> 83
    //   72: astore_1
    //   73: aload 4
    //   75: astore_0
    //   76: goto +24 -> 100
    //   79: astore_1
    //   80: aload 5
    //   82: astore_0
    //   83: aload_0
    //   84: astore 4
    //   86: aload_1
    //   87: invokevirtual 181	java/lang/Exception:printStackTrace	()V
    //   90: aload_0
    //   91: ifnull +7 -> 98
    //   94: aload_0
    //   95: invokevirtual 484	java/io/FileOutputStream:close	()V
    //   98: iconst_0
    //   99: ireturn
    //   100: aload_0
    //   101: ifnull +15 -> 116
    //   104: aload_0
    //   105: invokevirtual 484	java/io/FileOutputStream:close	()V
    //   108: goto +8 -> 116
    //   111: astore_0
    //   112: aload_0
    //   113: invokevirtual 325	java/io/IOException:printStackTrace	()V
    //   116: aload_1
    //   117: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	118	0	paramString	String
    //   0	118	1	paramYuvImage	android.graphics.YuvImage
    //   0	118	2	paramInt	int
    //   1	62	3	bool	boolean
    //   6	79	4	str	String
    //   3	78	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   51	55	57	java/io/IOException
    //   94	98	57	java/io/IOException
    //   21	45	64	finally
    //   45	49	64	finally
    //   21	45	68	java/lang/Exception
    //   45	49	68	java/lang/Exception
    //   8	17	72	finally
    //   86	90	72	finally
    //   8	17	79	java/lang/Exception
    //   104	108	111	java/io/IOException
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2))
    {
      QLog.d("Q.ocr.image", 1, "compressImage, newImagePath is empty");
      return false;
    }
    Object localObject1 = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject1).inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString1, (BitmapFactory.Options)localObject1);
    int m = ((BitmapFactory.Options)localObject1).outHeight;
    int k = ((BitmapFactory.Options)localObject1).outWidth;
    int j = 800;
    int i = 70;
    if (OcrDpc.a() != null)
    {
      if (OcrDpc.a().c < 400) {
        j = 400;
      } else {
        j = OcrDpc.a().c;
      }
      if (OcrDpc.a().b < 10) {
        i = 10;
      } else {
        i = OcrDpc.a().b;
      }
    }
    float f2 = 1.0F;
    if ((k > m) && (m > j)) {
      f2 = j * 1.0F;
    }
    for (float f1 = m;; f1 = k)
    {
      f1 = f2 / f1;
      break;
      f1 = f2;
      if (k >= m) {
        break;
      }
      f1 = f2;
      if (k <= j) {
        break;
      }
      f2 = j * 1.0F;
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("compressImage radio:");
      ((StringBuilder)localObject2).append(f1);
      ((StringBuilder)localObject2).append(",source file size:");
      ((StringBuilder)localObject2).append(new File(paramString1).length());
      ((StringBuilder)localObject2).append(",shortSide:");
      ((StringBuilder)localObject2).append(j);
      ((StringBuilder)localObject2).append(",picQuality:");
      ((StringBuilder)localObject2).append(i);
      QLog.d("Q.ocr.image", 2, ((StringBuilder)localObject2).toString());
    }
    j = (int)(m * f1);
    k = (int)(k * f1);
    Object localObject2 = new Matrix();
    ((Matrix)localObject2).setScale(f1, f1);
    ((BitmapFactory.Options)localObject1).inJustDecodeBounds = false;
    localObject1 = a(paramString1, (BitmapFactory.Options)localObject1, 1, 2);
    if (localObject1 != null)
    {
      if ((((Bitmap)localObject1).getHeight() > j) || (((Bitmap)localObject1).getWidth() > k)) {
        try
        {
          localObject2 = Bitmap.createBitmap((Bitmap)localObject1, 0, 0, ((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight(), (Matrix)localObject2, false);
          paramString1 = (String)localObject2;
          if (localObject1 == null) {
            break label430;
          }
          paramString1 = (String)localObject2;
          if (((Bitmap)localObject1).isRecycled()) {
            break label430;
          }
          ((Bitmap)localObject1).recycle();
          paramString1 = (String)localObject2;
        }
        catch (Exception paramString1)
        {
          paramString1.printStackTrace();
        }
        catch (OutOfMemoryError paramString1)
        {
          paramString1.printStackTrace();
        }
      } else {
        paramString1 = (String)localObject1;
      }
      label430:
      if (paramString1 != null)
      {
        j = paramString1.getRowBytes();
        k = paramString1.getHeight();
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("compressImage target bmp size:");
          ((StringBuilder)localObject1).append(j * k / 1024);
          ((StringBuilder)localObject1).append("KB");
          QLog.d("Q.ocr.image", 2, ((StringBuilder)localObject1).toString());
        }
        return a(paramString1, paramString2, Bitmap.CompressFormat.JPEG, i, true);
      }
    }
    return false;
  }
  
  /* Error */
  public static byte[] a(String paramString)
  {
    // Byte code:
    //   0: new 14	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 183	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: aload_0
    //   10: invokevirtual 442	java/io/File:length	()J
    //   13: l2i
    //   14: newarray byte
    //   16: astore_2
    //   17: new 548	java/io/BufferedInputStream
    //   20: dup
    //   21: new 550	java/io/FileInputStream
    //   24: dup
    //   25: aload_0
    //   26: invokespecial 551	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   29: invokespecial 554	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   32: astore_1
    //   33: aload_1
    //   34: astore_0
    //   35: aload_1
    //   36: aload_2
    //   37: iconst_0
    //   38: aload_2
    //   39: arraylength
    //   40: invokevirtual 558	java/io/BufferedInputStream:read	([BII)I
    //   43: pop
    //   44: aload_1
    //   45: astore_0
    //   46: aload_1
    //   47: invokevirtual 559	java/io/BufferedInputStream:close	()V
    //   50: aload_1
    //   51: invokevirtual 559	java/io/BufferedInputStream:close	()V
    //   54: aload_2
    //   55: astore_0
    //   56: goto +70 -> 126
    //   59: astore_0
    //   60: aload_0
    //   61: invokevirtual 181	java/lang/Exception:printStackTrace	()V
    //   64: aload_2
    //   65: astore_0
    //   66: goto +60 -> 126
    //   69: astore_2
    //   70: goto +16 -> 86
    //   73: astore_2
    //   74: goto +32 -> 106
    //   77: astore_1
    //   78: aconst_null
    //   79: astore_0
    //   80: goto +72 -> 152
    //   83: astore_2
    //   84: aconst_null
    //   85: astore_1
    //   86: aload_1
    //   87: astore_0
    //   88: aload_2
    //   89: invokevirtual 325	java/io/IOException:printStackTrace	()V
    //   92: aload_1
    //   93: invokevirtual 559	java/io/BufferedInputStream:close	()V
    //   96: goto +28 -> 124
    //   99: astore_0
    //   100: goto +20 -> 120
    //   103: astore_2
    //   104: aconst_null
    //   105: astore_1
    //   106: aload_1
    //   107: astore_0
    //   108: aload_2
    //   109: invokevirtual 560	java/io/FileNotFoundException:printStackTrace	()V
    //   112: aload_1
    //   113: invokevirtual 559	java/io/BufferedInputStream:close	()V
    //   116: goto +8 -> 124
    //   119: astore_0
    //   120: aload_0
    //   121: invokevirtual 181	java/lang/Exception:printStackTrace	()V
    //   124: aconst_null
    //   125: astore_0
    //   126: aload_0
    //   127: ifnull +13 -> 140
    //   130: aload_0
    //   131: arraylength
    //   132: ifne +6 -> 138
    //   135: goto +5 -> 140
    //   138: aload_0
    //   139: areturn
    //   140: ldc 42
    //   142: iconst_1
    //   143: ldc_w 562
    //   146: invokestatic 50	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   149: aconst_null
    //   150: areturn
    //   151: astore_1
    //   152: aload_0
    //   153: invokevirtual 559	java/io/BufferedInputStream:close	()V
    //   156: goto +8 -> 164
    //   159: astore_0
    //   160: aload_0
    //   161: invokevirtual 181	java/lang/Exception:printStackTrace	()V
    //   164: aload_1
    //   165: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	166	0	paramString	String
    //   32	19	1	localBufferedInputStream	java.io.BufferedInputStream
    //   77	1	1	localObject1	Object
    //   85	28	1	localObject2	Object
    //   151	14	1	localObject3	Object
    //   16	49	2	arrayOfByte	byte[]
    //   69	1	2	localIOException1	java.io.IOException
    //   73	1	2	localFileNotFoundException1	java.io.FileNotFoundException
    //   83	6	2	localIOException2	java.io.IOException
    //   103	6	2	localFileNotFoundException2	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   50	54	59	java/lang/Exception
    //   35	44	69	java/io/IOException
    //   46	50	69	java/io/IOException
    //   35	44	73	java/io/FileNotFoundException
    //   46	50	73	java/io/FileNotFoundException
    //   17	33	77	finally
    //   17	33	83	java/io/IOException
    //   92	96	99	java/lang/Exception
    //   17	33	103	java/io/FileNotFoundException
    //   112	116	119	java/lang/Exception
    //   35	44	151	finally
    //   46	50	151	finally
    //   88	92	151	finally
    //   108	112	151	finally
    //   152	156	159	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OcrImageUtil
 * JD-Core Version:    0.7.0.1
 */