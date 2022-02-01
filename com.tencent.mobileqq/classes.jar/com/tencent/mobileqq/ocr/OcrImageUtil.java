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
  public static String b;
  public static String c;
  public static boolean d = true;
  
  static
  {
    File localFile1 = new File(AppConstants.SDCARD_PATH, "ocr");
    a = localFile1.getAbsolutePath();
    if ((!localFile1.exists()) && (!localFile1.mkdir()))
    {
      d = false;
      QLog.d("Q.ocr.image", 1, "WTF! mk ocr dir failed!");
    }
    if (localFile1.exists())
    {
      File localFile2 = new File(a, "preview");
      b = localFile2.getAbsolutePath();
      if ((!localFile2.exists()) && (!localFile2.mkdir())) {
        QLog.d("Q.ocr.image", 1, "WTF! mk ocr preview dir failed!");
      }
    }
    if (localFile1.exists())
    {
      localFile1 = new File(a, "cache");
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
  
  public static String a(String paramString, boolean paramBoolean)
  {
    try
    {
      Object localObject = new File(a);
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
        localObject = a;
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
      if ((localPicOcrResultBean != null) && (localPicOcrResultBean.a != null)) {
        localStringBuilder.append(localPicOcrResultBean.a);
      }
    }
    return localStringBuilder.toString().replace(" ", "");
  }
  
  /* Error */
  public static String a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    // Byte code:
    //   0: invokestatic 224	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +115 -> 118
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
    //   32: ldc 226
    //   34: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: pop
    //   38: aload 7
    //   40: lload 5
    //   42: invokevirtual 229	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: aload 7
    //   48: ldc 231
    //   50: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: aload 7
    //   56: iload_2
    //   57: invokevirtual 234	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   60: pop
    //   61: aload 7
    //   63: ldc 236
    //   65: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: pop
    //   69: aload 7
    //   71: iload_1
    //   72: invokevirtual 234	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   75: pop
    //   76: aload 7
    //   78: ldc 238
    //   80: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: pop
    //   84: aload 7
    //   86: iload_3
    //   87: invokevirtual 234	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   90: pop
    //   91: aload 7
    //   93: ldc 240
    //   95: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: pop
    //   99: aload 7
    //   101: iload 4
    //   103: invokevirtual 234	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   106: pop
    //   107: ldc 43
    //   109: iconst_2
    //   110: aload 7
    //   112: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: invokestatic 50	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   118: aload_0
    //   119: ifnonnull +5 -> 124
    //   122: aconst_null
    //   123: areturn
    //   124: invokestatic 242	com/tencent/mobileqq/ocr/OcrImageUtil:a	()Ljava/lang/String;
    //   127: iconst_1
    //   128: invokestatic 244	com/tencent/mobileqq/ocr/OcrImageUtil:a	(Ljava/lang/String;Z)Ljava/lang/String;
    //   131: astore 9
    //   133: iload_2
    //   134: ifle +500 -> 634
    //   137: iload_1
    //   138: ifle +496 -> 634
    //   141: iload_3
    //   142: bipush 17
    //   144: if_icmpeq +12 -> 156
    //   147: iload_3
    //   148: bipush 20
    //   150: if_icmpeq +6 -> 156
    //   153: goto +481 -> 634
    //   156: aload 9
    //   158: new 246	android/graphics/YuvImage
    //   161: dup
    //   162: aload_0
    //   163: iload_3
    //   164: iload_1
    //   165: iload_2
    //   166: aconst_null
    //   167: invokespecial 249	android/graphics/YuvImage:<init>	([BIII[I)V
    //   170: bipush 100
    //   172: invokestatic 252	com/tencent/mobileqq/ocr/OcrImageUtil:a	(Ljava/lang/String;Landroid/graphics/YuvImage;I)Z
    //   175: ifne +13 -> 188
    //   178: ldc 43
    //   180: iconst_1
    //   181: ldc 254
    //   183: invokestatic 50	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   186: aconst_null
    //   187: areturn
    //   188: aload 9
    //   190: invokestatic 257	com/tencent/mobileqq/ocr/OcrImageUtil:a	(Ljava/lang/String;)[B
    //   193: astore_0
    //   194: aload_0
    //   195: ifnonnull +15 -> 210
    //   198: ldc 43
    //   200: iconst_1
    //   201: ldc_w 259
    //   204: invokestatic 50	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   207: aload 9
    //   209: areturn
    //   210: new 261	android/graphics/Rect
    //   213: dup
    //   214: iconst_0
    //   215: iconst_0
    //   216: getstatic 266	com/tencent/mobileqq/shortvideo/util/ScreenUtil:SCREEN_WIDTH	I
    //   219: getstatic 269	com/tencent/mobileqq/shortvideo/util/ScreenUtil:SCREEN_HIGHT	I
    //   222: invokespecial 272	android/graphics/Rect:<init>	(IIII)V
    //   225: astore 7
    //   227: ldc_w 274
    //   230: invokestatic 280	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   233: checkcast 274	com/tencent/mobileqq/qqcamera/api/ICameraUtils
    //   236: aload_0
    //   237: aload 7
    //   239: iconst_0
    //   240: iconst_0
    //   241: invokeinterface 284 5 0
    //   246: astore 8
    //   248: aload 8
    //   250: ifnonnull +28 -> 278
    //   253: ldc 43
    //   255: iconst_1
    //   256: ldc_w 286
    //   259: invokestatic 50	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   262: new 15	java/io/File
    //   265: dup
    //   266: aload 9
    //   268: invokespecial 183	java/io/File:<init>	(Ljava/lang/String;)V
    //   271: invokevirtual 36	java/io/File:exists	()Z
    //   274: pop
    //   275: aload 9
    //   277: areturn
    //   278: ldc_w 274
    //   281: invokestatic 280	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   284: checkcast 274	com/tencent/mobileqq/qqcamera/api/ICameraUtils
    //   287: aload 8
    //   289: iload 4
    //   291: iconst_1
    //   292: invokeinterface 290 4 0
    //   297: astore 7
    //   299: aload 7
    //   301: astore_0
    //   302: invokestatic 224	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   305: ifeq +52 -> 357
    //   308: aload 7
    //   310: astore_0
    //   311: new 164	java/lang/StringBuilder
    //   314: dup
    //   315: invokespecial 165	java/lang/StringBuilder:<init>	()V
    //   318: astore 10
    //   320: aload 7
    //   322: astore_0
    //   323: aload 10
    //   325: ldc_w 292
    //   328: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: pop
    //   332: aload 7
    //   334: astore_0
    //   335: aload 10
    //   337: iload 4
    //   339: invokevirtual 234	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   342: pop
    //   343: aload 7
    //   345: astore_0
    //   346: ldc 43
    //   348: iconst_2
    //   349: aload 10
    //   351: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   354: invokestatic 50	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   357: aload 7
    //   359: ifnonnull +38 -> 397
    //   362: aload 7
    //   364: astore_0
    //   365: aload 8
    //   367: bipush 100
    //   369: new 15	java/io/File
    //   372: dup
    //   373: aload 9
    //   375: invokespecial 183	java/io/File:<init>	(Ljava/lang/String;)V
    //   378: invokestatic 297	com/tencent/mobileqq/utils/BaseImageUtil:b	(Landroid/graphics/Bitmap;ILjava/io/File;)Z
    //   381: pop
    //   382: aload 7
    //   384: astore_0
    //   385: ldc 43
    //   387: iconst_1
    //   388: ldc_w 299
    //   391: invokestatic 50	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   394: goto +23 -> 417
    //   397: aload 7
    //   399: astore_0
    //   400: aload 7
    //   402: bipush 100
    //   404: new 15	java/io/File
    //   407: dup
    //   408: aload 9
    //   410: invokespecial 183	java/io/File:<init>	(Ljava/lang/String;)V
    //   413: invokestatic 297	com/tencent/mobileqq/utils/BaseImageUtil:b	(Landroid/graphics/Bitmap;ILjava/io/File;)Z
    //   416: pop
    //   417: new 15	java/io/File
    //   420: dup
    //   421: aload 9
    //   423: invokespecial 183	java/io/File:<init>	(Ljava/lang/String;)V
    //   426: invokevirtual 36	java/io/File:exists	()Z
    //   429: ifeq +153 -> 582
    //   432: aload 7
    //   434: ifnull +148 -> 582
    //   437: goto +68 -> 505
    //   440: astore 8
    //   442: goto +15 -> 457
    //   445: astore 7
    //   447: aconst_null
    //   448: astore_0
    //   449: goto +153 -> 602
    //   452: astore 8
    //   454: aconst_null
    //   455: astore 7
    //   457: aload 7
    //   459: astore_0
    //   460: aload 8
    //   462: invokevirtual 300	java/io/IOException:printStackTrace	()V
    //   465: aload 7
    //   467: astore_0
    //   468: ldc_w 274
    //   471: invokestatic 280	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   474: checkcast 274	com/tencent/mobileqq/qqcamera/api/ICameraUtils
    //   477: aload 7
    //   479: invokeinterface 304 2 0
    //   484: pop
    //   485: new 15	java/io/File
    //   488: dup
    //   489: aload 9
    //   491: invokespecial 183	java/io/File:<init>	(Ljava/lang/String;)V
    //   494: invokevirtual 36	java/io/File:exists	()Z
    //   497: ifeq +85 -> 582
    //   500: aload 7
    //   502: ifnull +80 -> 582
    //   505: getstatic 309	com/tencent/mobileqq/app/GlobalImageCache:a	Landroid/support/v4/util/MQLruCache;
    //   508: aload 9
    //   510: aload 7
    //   512: invokevirtual 315	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   515: pop
    //   516: goto +66 -> 582
    //   519: astore 7
    //   521: goto +81 -> 602
    //   524: aconst_null
    //   525: astore 7
    //   527: aload 7
    //   529: astore_0
    //   530: ldc 43
    //   532: iconst_1
    //   533: ldc_w 317
    //   536: invokestatic 320	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   539: aload 7
    //   541: astore_0
    //   542: ldc_w 274
    //   545: invokestatic 280	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   548: checkcast 274	com/tencent/mobileqq/qqcamera/api/ICameraUtils
    //   551: aload 7
    //   553: invokeinterface 304 2 0
    //   558: pop
    //   559: new 15	java/io/File
    //   562: dup
    //   563: aload 9
    //   565: invokespecial 183	java/io/File:<init>	(Ljava/lang/String;)V
    //   568: invokevirtual 36	java/io/File:exists	()Z
    //   571: ifeq +11 -> 582
    //   574: aload 7
    //   576: ifnull +6 -> 582
    //   579: goto -74 -> 505
    //   582: new 15	java/io/File
    //   585: dup
    //   586: aload 9
    //   588: invokespecial 183	java/io/File:<init>	(Ljava/lang/String;)V
    //   591: invokevirtual 36	java/io/File:exists	()Z
    //   594: ifeq +6 -> 600
    //   597: aload 9
    //   599: areturn
    //   600: aconst_null
    //   601: areturn
    //   602: new 15	java/io/File
    //   605: dup
    //   606: aload 9
    //   608: invokespecial 183	java/io/File:<init>	(Ljava/lang/String;)V
    //   611: invokevirtual 36	java/io/File:exists	()Z
    //   614: ifeq +17 -> 631
    //   617: aload_0
    //   618: ifnull +13 -> 631
    //   621: getstatic 309	com/tencent/mobileqq/app/GlobalImageCache:a	Landroid/support/v4/util/MQLruCache;
    //   624: aload 9
    //   626: aload_0
    //   627: invokevirtual 315	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   630: pop
    //   631: aload 7
    //   633: athrow
    //   634: ldc 43
    //   636: iconst_1
    //   637: ldc_w 322
    //   640: invokestatic 50	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   643: aconst_null
    //   644: areturn
    //   645: astore_0
    //   646: goto -122 -> 524
    //   649: astore_0
    //   650: goto -123 -> 527
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	653	0	paramArrayOfByte	byte[]
    //   0	653	1	paramInt1	int
    //   0	653	2	paramInt2	int
    //   0	653	3	paramInt3	int
    //   0	653	4	paramInt4	int
    //   13	28	5	l	long
    //   28	405	7	localObject1	Object
    //   445	1	7	localObject2	Object
    //   455	56	7	localBitmap1	Bitmap
    //   519	1	7	localObject3	Object
    //   525	107	7	localBitmap2	Bitmap
    //   246	120	8	localBitmap3	Bitmap
    //   440	1	8	localIOException1	java.io.IOException
    //   452	9	8	localIOException2	java.io.IOException
    //   131	494	9	str	String
    //   318	32	10	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   302	308	440	java/io/IOException
    //   311	320	440	java/io/IOException
    //   323	332	440	java/io/IOException
    //   335	343	440	java/io/IOException
    //   346	357	440	java/io/IOException
    //   365	382	440	java/io/IOException
    //   385	394	440	java/io/IOException
    //   400	417	440	java/io/IOException
    //   210	248	445	finally
    //   253	262	445	finally
    //   278	299	445	finally
    //   210	248	452	java/io/IOException
    //   253	262	452	java/io/IOException
    //   278	299	452	java/io/IOException
    //   302	308	519	finally
    //   311	320	519	finally
    //   323	332	519	finally
    //   335	343	519	finally
    //   346	357	519	finally
    //   365	382	519	finally
    //   385	394	519	finally
    //   400	417	519	finally
    //   460	465	519	finally
    //   468	485	519	finally
    //   530	539	519	finally
    //   542	559	519	finally
    //   210	248	645	java/lang/OutOfMemoryError
    //   253	262	645	java/lang/OutOfMemoryError
    //   278	299	645	java/lang/OutOfMemoryError
    //   302	308	649	java/lang/OutOfMemoryError
    //   311	320	649	java/lang/OutOfMemoryError
    //   323	332	649	java/lang/OutOfMemoryError
    //   335	343	649	java/lang/OutOfMemoryError
    //   346	357	649	java/lang/OutOfMemoryError
    //   365	382	649	java/lang/OutOfMemoryError
    //   385	394	649	java/lang/OutOfMemoryError
    //   400	417	649	java/lang/OutOfMemoryError
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
    //   9: invokestatic 224	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12: ifeq +137 -> 149
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
    //   43: ldc 226
    //   45: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: pop
    //   49: aload 16
    //   51: lload 13
    //   53: invokevirtual 229	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: aload 16
    //   59: ldc 231
    //   61: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: pop
    //   65: aload 16
    //   67: iload 11
    //   69: invokevirtual 234	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: aload 16
    //   75: ldc 236
    //   77: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: pop
    //   81: aload 16
    //   83: iload 12
    //   85: invokevirtual 234	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   88: pop
    //   89: aload 16
    //   91: ldc 238
    //   93: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: pop
    //   97: aload 16
    //   99: iload_3
    //   100: invokevirtual 234	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   103: pop
    //   104: aload 16
    //   106: ldc_w 330
    //   109: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: pop
    //   113: aload 16
    //   115: iload 5
    //   117: invokevirtual 234	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   120: pop
    //   121: aload 16
    //   123: ldc_w 332
    //   126: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: pop
    //   130: aload 16
    //   132: aload 6
    //   134: invokevirtual 335	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   137: pop
    //   138: ldc 43
    //   140: iconst_2
    //   141: aload 16
    //   143: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   146: invokestatic 50	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   149: aload 15
    //   151: ifnonnull +5 -> 156
    //   154: aconst_null
    //   155: areturn
    //   156: invokestatic 242	com/tencent/mobileqq/ocr/OcrImageUtil:a	()Ljava/lang/String;
    //   159: iconst_1
    //   160: invokestatic 244	com/tencent/mobileqq/ocr/OcrImageUtil:a	(Ljava/lang/String;Z)Ljava/lang/String;
    //   163: astore 19
    //   165: iload 7
    //   167: ifeq +6 -> 173
    //   170: goto +67 -> 237
    //   173: iload 11
    //   175: ifle +1095 -> 1270
    //   178: iload 12
    //   180: ifle +1090 -> 1270
    //   183: iload_3
    //   184: bipush 17
    //   186: if_icmpeq +12 -> 198
    //   189: iload_3
    //   190: bipush 20
    //   192: if_icmpeq +6 -> 198
    //   195: goto +1075 -> 1270
    //   198: aload 19
    //   200: new 246	android/graphics/YuvImage
    //   203: dup
    //   204: aload_0
    //   205: iload_3
    //   206: iload_1
    //   207: iload_2
    //   208: aconst_null
    //   209: invokespecial 249	android/graphics/YuvImage:<init>	([BIII[I)V
    //   212: bipush 100
    //   214: invokestatic 252	com/tencent/mobileqq/ocr/OcrImageUtil:a	(Ljava/lang/String;Landroid/graphics/YuvImage;I)Z
    //   217: ifne +13 -> 230
    //   220: ldc 43
    //   222: iconst_1
    //   223: ldc 254
    //   225: invokestatic 50	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   228: aconst_null
    //   229: areturn
    //   230: aload 19
    //   232: invokestatic 257	com/tencent/mobileqq/ocr/OcrImageUtil:a	(Ljava/lang/String;)[B
    //   235: astore 15
    //   237: aload 15
    //   239: ifnonnull +15 -> 254
    //   242: ldc 43
    //   244: iconst_1
    //   245: ldc_w 259
    //   248: invokestatic 50	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   251: aload 19
    //   253: areturn
    //   254: new 261	android/graphics/Rect
    //   257: dup
    //   258: iconst_0
    //   259: iconst_0
    //   260: getstatic 266	com/tencent/mobileqq/shortvideo/util/ScreenUtil:SCREEN_WIDTH	I
    //   263: getstatic 269	com/tencent/mobileqq/shortvideo/util/ScreenUtil:SCREEN_HIGHT	I
    //   266: invokespecial 272	android/graphics/Rect:<init>	(IIII)V
    //   269: astore_0
    //   270: ldc_w 274
    //   273: invokestatic 280	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   276: checkcast 274	com/tencent/mobileqq/qqcamera/api/ICameraUtils
    //   279: aload 15
    //   281: aload_0
    //   282: iconst_0
    //   283: iconst_0
    //   284: invokeinterface 284 5 0
    //   289: astore 20
    //   291: aload 20
    //   293: ifnonnull +28 -> 321
    //   296: ldc 43
    //   298: iconst_1
    //   299: ldc_w 286
    //   302: invokestatic 50	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   305: new 15	java/io/File
    //   308: dup
    //   309: aload 19
    //   311: invokespecial 183	java/io/File:<init>	(Ljava/lang/String;)V
    //   314: invokevirtual 36	java/io/File:exists	()Z
    //   317: pop
    //   318: aload 19
    //   320: areturn
    //   321: ldc_w 274
    //   324: invokestatic 280	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   327: checkcast 274	com/tencent/mobileqq/qqcamera/api/ICameraUtils
    //   330: iload 4
    //   332: iload 5
    //   334: invokeinterface 339 3 0
    //   339: istore_1
    //   340: ldc_w 274
    //   343: invokestatic 280	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   346: checkcast 274	com/tencent/mobileqq/qqcamera/api/ICameraUtils
    //   349: aload 20
    //   351: iload_1
    //   352: iconst_1
    //   353: invokeinterface 290 4 0
    //   358: astore 16
    //   360: aload 16
    //   362: astore 17
    //   364: aload 16
    //   366: astore 15
    //   368: aload 16
    //   370: astore 18
    //   372: invokestatic 224	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   375: ifeq +83 -> 458
    //   378: aload 16
    //   380: astore 17
    //   382: aload 16
    //   384: astore 15
    //   386: aload 16
    //   388: astore 18
    //   390: new 164	java/lang/StringBuilder
    //   393: dup
    //   394: invokespecial 165	java/lang/StringBuilder:<init>	()V
    //   397: astore_0
    //   398: aload 16
    //   400: astore 17
    //   402: aload 16
    //   404: astore 15
    //   406: aload 16
    //   408: astore 18
    //   410: aload_0
    //   411: ldc_w 292
    //   414: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   417: pop
    //   418: aload 16
    //   420: astore 17
    //   422: aload 16
    //   424: astore 15
    //   426: aload 16
    //   428: astore 18
    //   430: aload_0
    //   431: iload_1
    //   432: invokevirtual 234	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   435: pop
    //   436: aload 16
    //   438: astore 17
    //   440: aload 16
    //   442: astore 15
    //   444: aload 16
    //   446: astore 18
    //   448: ldc 43
    //   450: iconst_2
    //   451: aload_0
    //   452: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   455: invokestatic 50	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   458: aload 16
    //   460: astore_0
    //   461: aload 6
    //   463: ifnull +519 -> 982
    //   466: aload 16
    //   468: astore_0
    //   469: aload 16
    //   471: ifnull +511 -> 982
    //   474: iload 12
    //   476: iload 11
    //   478: if_icmple +814 -> 1292
    //   481: aload 16
    //   483: astore 17
    //   485: aload 16
    //   487: astore 15
    //   489: aload 16
    //   491: astore 18
    //   493: aload 16
    //   495: invokevirtual 345	android/graphics/Bitmap:getWidth	()I
    //   498: aload 16
    //   500: invokevirtual 348	android/graphics/Bitmap:getHeight	()I
    //   503: if_icmpge +789 -> 1292
    //   506: iload 11
    //   508: istore_1
    //   509: goto +3 -> 512
    //   512: aload 16
    //   514: astore 17
    //   516: aload 16
    //   518: astore 15
    //   520: aload 16
    //   522: astore 18
    //   524: aload 6
    //   526: getfield 353	android/graphics/RectF:left	F
    //   529: fstore 9
    //   531: iload_1
    //   532: i2f
    //   533: fstore 8
    //   535: aload 16
    //   537: astore 17
    //   539: aload 16
    //   541: astore 15
    //   543: aload 16
    //   545: astore 18
    //   547: fload 9
    //   549: fload 8
    //   551: fmul
    //   552: ldc_w 354
    //   555: fadd
    //   556: iload_1
    //   557: aload 16
    //   559: invokevirtual 345	android/graphics/Bitmap:getWidth	()I
    //   562: isub
    //   563: iconst_2
    //   564: idiv
    //   565: i2f
    //   566: fsub
    //   567: f2i
    //   568: istore_2
    //   569: aload 16
    //   571: astore 17
    //   573: aload 16
    //   575: astore 15
    //   577: aload 16
    //   579: astore 18
    //   581: aload 6
    //   583: getfield 357	android/graphics/RectF:top	F
    //   586: fstore 9
    //   588: iload 12
    //   590: i2f
    //   591: fstore 10
    //   593: aload 16
    //   595: astore 17
    //   597: aload 16
    //   599: astore 15
    //   601: aload 16
    //   603: astore 18
    //   605: fload 9
    //   607: fload 10
    //   609: fmul
    //   610: ldc_w 354
    //   613: fadd
    //   614: iload 12
    //   616: aload 16
    //   618: invokevirtual 348	android/graphics/Bitmap:getHeight	()I
    //   621: isub
    //   622: iconst_2
    //   623: idiv
    //   624: i2f
    //   625: fsub
    //   626: f2i
    //   627: istore 4
    //   629: iload_2
    //   630: ifgt +26 -> 656
    //   633: aload 16
    //   635: astore 17
    //   637: aload 16
    //   639: astore 15
    //   641: aload 16
    //   643: astore 18
    //   645: aload 16
    //   647: invokevirtual 345	android/graphics/Bitmap:getWidth	()I
    //   650: istore_1
    //   651: iconst_0
    //   652: istore_2
    //   653: goto +29 -> 682
    //   656: aload 16
    //   658: astore 17
    //   660: aload 16
    //   662: astore 15
    //   664: aload 16
    //   666: astore 18
    //   668: aload 6
    //   670: invokevirtual 360	android/graphics/RectF:width	()F
    //   673: fload 8
    //   675: fmul
    //   676: ldc_w 354
    //   679: fadd
    //   680: f2i
    //   681: istore_1
    //   682: iload 4
    //   684: ifgt +27 -> 711
    //   687: aload 16
    //   689: astore 17
    //   691: aload 16
    //   693: astore 15
    //   695: aload 16
    //   697: astore 18
    //   699: aload 16
    //   701: invokevirtual 348	android/graphics/Bitmap:getHeight	()I
    //   704: istore_3
    //   705: iconst_0
    //   706: istore 4
    //   708: goto +29 -> 737
    //   711: aload 16
    //   713: astore 17
    //   715: aload 16
    //   717: astore 15
    //   719: aload 16
    //   721: astore 18
    //   723: aload 6
    //   725: invokevirtual 363	android/graphics/RectF:height	()F
    //   728: fload 10
    //   730: fmul
    //   731: ldc_w 354
    //   734: fadd
    //   735: f2i
    //   736: istore_3
    //   737: aload 16
    //   739: astore 17
    //   741: aload 16
    //   743: astore 15
    //   745: aload 16
    //   747: astore 18
    //   749: aload 16
    //   751: iload_2
    //   752: iload 4
    //   754: iload_1
    //   755: iload_3
    //   756: invokestatic 367	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIII)Landroid/graphics/Bitmap;
    //   759: astore_0
    //   760: aload 16
    //   762: astore 17
    //   764: aload 16
    //   766: astore 15
    //   768: aload 16
    //   770: astore 18
    //   772: invokestatic 224	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   775: ifeq +113 -> 888
    //   778: aload 16
    //   780: astore 17
    //   782: aload 16
    //   784: astore 15
    //   786: aload 16
    //   788: astore 18
    //   790: new 164	java/lang/StringBuilder
    //   793: dup
    //   794: invokespecial 165	java/lang/StringBuilder:<init>	()V
    //   797: astore 6
    //   799: aload 16
    //   801: astore 17
    //   803: aload 16
    //   805: astore 15
    //   807: aload 16
    //   809: astore 18
    //   811: aload 6
    //   813: ldc_w 369
    //   816: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   819: pop
    //   820: aload 16
    //   822: astore 17
    //   824: aload 16
    //   826: astore 15
    //   828: aload 16
    //   830: astore 18
    //   832: aload 6
    //   834: aload_0
    //   835: invokevirtual 345	android/graphics/Bitmap:getWidth	()I
    //   838: invokevirtual 234	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   841: pop
    //   842: aload 16
    //   844: astore 17
    //   846: aload 16
    //   848: astore 15
    //   850: aload 16
    //   852: astore 18
    //   854: ldc 43
    //   856: iconst_2
    //   857: iconst_3
    //   858: anewarray 4	java/lang/Object
    //   861: dup
    //   862: iconst_0
    //   863: aload 6
    //   865: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   868: aastore
    //   869: dup
    //   870: iconst_1
    //   871: ldc_w 371
    //   874: aastore
    //   875: dup
    //   876: iconst_2
    //   877: aload_0
    //   878: invokevirtual 348	android/graphics/Bitmap:getHeight	()I
    //   881: invokestatic 377	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   884: aastore
    //   885: invokestatic 380	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   888: goto +94 -> 982
    //   891: astore_0
    //   892: aload 16
    //   894: astore 17
    //   896: aload 16
    //   898: astore 15
    //   900: aload 16
    //   902: astore 18
    //   904: new 164	java/lang/StringBuilder
    //   907: dup
    //   908: invokespecial 165	java/lang/StringBuilder:<init>	()V
    //   911: astore 6
    //   913: aload 16
    //   915: astore 17
    //   917: aload 16
    //   919: astore 15
    //   921: aload 16
    //   923: astore 18
    //   925: aload 6
    //   927: ldc_w 382
    //   930: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   933: pop
    //   934: aload 16
    //   936: astore 17
    //   938: aload 16
    //   940: astore 15
    //   942: aload 16
    //   944: astore 18
    //   946: aload 6
    //   948: aload_0
    //   949: invokevirtual 385	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   952: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   955: pop
    //   956: aload 16
    //   958: astore 17
    //   960: aload 16
    //   962: astore 15
    //   964: aload 16
    //   966: astore 18
    //   968: ldc 43
    //   970: iconst_1
    //   971: aload 6
    //   973: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   976: invokestatic 320	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   979: aload 16
    //   981: astore_0
    //   982: aload_0
    //   983: ifnonnull +50 -> 1033
    //   986: aload_0
    //   987: astore 17
    //   989: aload_0
    //   990: astore 15
    //   992: aload_0
    //   993: astore 18
    //   995: aload 20
    //   997: bipush 100
    //   999: new 15	java/io/File
    //   1002: dup
    //   1003: aload 19
    //   1005: invokespecial 183	java/io/File:<init>	(Ljava/lang/String;)V
    //   1008: invokestatic 297	com/tencent/mobileqq/utils/BaseImageUtil:b	(Landroid/graphics/Bitmap;ILjava/io/File;)Z
    //   1011: pop
    //   1012: aload_0
    //   1013: astore 17
    //   1015: aload_0
    //   1016: astore 15
    //   1018: aload_0
    //   1019: astore 18
    //   1021: ldc 43
    //   1023: iconst_1
    //   1024: ldc_w 299
    //   1027: invokestatic 50	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1030: goto +28 -> 1058
    //   1033: aload_0
    //   1034: astore 17
    //   1036: aload_0
    //   1037: astore 15
    //   1039: aload_0
    //   1040: astore 18
    //   1042: aload_0
    //   1043: bipush 100
    //   1045: new 15	java/io/File
    //   1048: dup
    //   1049: aload 19
    //   1051: invokespecial 183	java/io/File:<init>	(Ljava/lang/String;)V
    //   1054: invokestatic 297	com/tencent/mobileqq/utils/BaseImageUtil:b	(Landroid/graphics/Bitmap;ILjava/io/File;)Z
    //   1057: pop
    //   1058: new 15	java/io/File
    //   1061: dup
    //   1062: aload 19
    //   1064: invokespecial 183	java/io/File:<init>	(Ljava/lang/String;)V
    //   1067: invokevirtual 36	java/io/File:exists	()Z
    //   1070: ifeq +147 -> 1217
    //   1073: aload_0
    //   1074: ifnull +143 -> 1217
    //   1077: goto +68 -> 1145
    //   1080: astore 6
    //   1082: aload 17
    //   1084: astore_0
    //   1085: goto +14 -> 1099
    //   1088: astore_0
    //   1089: aconst_null
    //   1090: astore 15
    //   1092: goto +145 -> 1237
    //   1095: astore 6
    //   1097: aconst_null
    //   1098: astore_0
    //   1099: aload_0
    //   1100: astore 15
    //   1102: aload 6
    //   1104: invokevirtual 300	java/io/IOException:printStackTrace	()V
    //   1107: aload_0
    //   1108: astore 15
    //   1110: ldc_w 274
    //   1113: invokestatic 280	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   1116: checkcast 274	com/tencent/mobileqq/qqcamera/api/ICameraUtils
    //   1119: aload_0
    //   1120: invokeinterface 304 2 0
    //   1125: pop
    //   1126: new 15	java/io/File
    //   1129: dup
    //   1130: aload 19
    //   1132: invokespecial 183	java/io/File:<init>	(Ljava/lang/String;)V
    //   1135: invokevirtual 36	java/io/File:exists	()Z
    //   1138: ifeq +79 -> 1217
    //   1141: aload_0
    //   1142: ifnull +75 -> 1217
    //   1145: getstatic 309	com/tencent/mobileqq/app/GlobalImageCache:a	Landroid/support/v4/util/MQLruCache;
    //   1148: aload 19
    //   1150: aload_0
    //   1151: invokevirtual 315	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1154: pop
    //   1155: goto +62 -> 1217
    //   1158: astore_0
    //   1159: goto +78 -> 1237
    //   1162: aconst_null
    //   1163: astore_0
    //   1164: aload_0
    //   1165: astore 15
    //   1167: ldc 43
    //   1169: iconst_1
    //   1170: ldc_w 317
    //   1173: invokestatic 320	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1176: aload_0
    //   1177: astore 15
    //   1179: ldc_w 274
    //   1182: invokestatic 280	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   1185: checkcast 274	com/tencent/mobileqq/qqcamera/api/ICameraUtils
    //   1188: aload_0
    //   1189: invokeinterface 304 2 0
    //   1194: pop
    //   1195: new 15	java/io/File
    //   1198: dup
    //   1199: aload 19
    //   1201: invokespecial 183	java/io/File:<init>	(Ljava/lang/String;)V
    //   1204: invokevirtual 36	java/io/File:exists	()Z
    //   1207: ifeq +10 -> 1217
    //   1210: aload_0
    //   1211: ifnull +6 -> 1217
    //   1214: goto -69 -> 1145
    //   1217: new 15	java/io/File
    //   1220: dup
    //   1221: aload 19
    //   1223: invokespecial 183	java/io/File:<init>	(Ljava/lang/String;)V
    //   1226: invokevirtual 36	java/io/File:exists	()Z
    //   1229: ifeq +6 -> 1235
    //   1232: aload 19
    //   1234: areturn
    //   1235: aconst_null
    //   1236: areturn
    //   1237: new 15	java/io/File
    //   1240: dup
    //   1241: aload 19
    //   1243: invokespecial 183	java/io/File:<init>	(Ljava/lang/String;)V
    //   1246: invokevirtual 36	java/io/File:exists	()Z
    //   1249: ifeq +19 -> 1268
    //   1252: aload 15
    //   1254: ifnull +14 -> 1268
    //   1257: getstatic 309	com/tencent/mobileqq/app/GlobalImageCache:a	Landroid/support/v4/util/MQLruCache;
    //   1260: aload 19
    //   1262: aload 15
    //   1264: invokevirtual 315	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1267: pop
    //   1268: aload_0
    //   1269: athrow
    //   1270: ldc 43
    //   1272: iconst_1
    //   1273: ldc_w 322
    //   1276: invokestatic 50	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1279: aconst_null
    //   1280: areturn
    //   1281: astore_0
    //   1282: goto -120 -> 1162
    //   1285: astore_0
    //   1286: aload 18
    //   1288: astore_0
    //   1289: goto -125 -> 1164
    //   1292: iload 12
    //   1294: istore_1
    //   1295: iload 11
    //   1297: istore 12
    //   1299: goto -787 -> 512
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1302	0	paramArrayOfByte	byte[]
    //   0	1302	1	paramInt1	int
    //   0	1302	2	paramInt2	int
    //   0	1302	3	paramInt3	int
    //   0	1302	4	paramInt4	int
    //   0	1302	5	paramInt5	int
    //   0	1302	6	paramRectF	android.graphics.RectF
    //   0	1302	7	paramBoolean	boolean
    //   533	141	8	f1	float
    //   529	77	9	f2	float
    //   591	138	10	f3	float
    //   7	1289	11	i	int
    //   4	1294	12	j	int
    //   24	28	13	l	long
    //   1	1262	15	localObject1	Object
    //   39	941	16	localObject2	Object
    //   362	721	17	localObject3	Object
    //   370	917	18	localObject4	Object
    //   163	1098	19	str	String
    //   289	707	20	localBitmap	Bitmap
    // Exception table:
    //   from	to	target	type
    //   493	506	891	java/lang/Throwable
    //   524	531	891	java/lang/Throwable
    //   547	569	891	java/lang/Throwable
    //   581	588	891	java/lang/Throwable
    //   605	629	891	java/lang/Throwable
    //   645	651	891	java/lang/Throwable
    //   668	682	891	java/lang/Throwable
    //   699	705	891	java/lang/Throwable
    //   723	737	891	java/lang/Throwable
    //   749	760	891	java/lang/Throwable
    //   772	778	891	java/lang/Throwable
    //   790	799	891	java/lang/Throwable
    //   811	820	891	java/lang/Throwable
    //   832	842	891	java/lang/Throwable
    //   854	888	891	java/lang/Throwable
    //   372	378	1080	java/io/IOException
    //   390	398	1080	java/io/IOException
    //   410	418	1080	java/io/IOException
    //   430	436	1080	java/io/IOException
    //   448	458	1080	java/io/IOException
    //   493	506	1080	java/io/IOException
    //   524	531	1080	java/io/IOException
    //   547	569	1080	java/io/IOException
    //   581	588	1080	java/io/IOException
    //   605	629	1080	java/io/IOException
    //   645	651	1080	java/io/IOException
    //   668	682	1080	java/io/IOException
    //   699	705	1080	java/io/IOException
    //   723	737	1080	java/io/IOException
    //   749	760	1080	java/io/IOException
    //   772	778	1080	java/io/IOException
    //   790	799	1080	java/io/IOException
    //   811	820	1080	java/io/IOException
    //   832	842	1080	java/io/IOException
    //   854	888	1080	java/io/IOException
    //   904	913	1080	java/io/IOException
    //   925	934	1080	java/io/IOException
    //   946	956	1080	java/io/IOException
    //   968	979	1080	java/io/IOException
    //   995	1012	1080	java/io/IOException
    //   1021	1030	1080	java/io/IOException
    //   1042	1058	1080	java/io/IOException
    //   254	291	1088	finally
    //   296	305	1088	finally
    //   321	360	1088	finally
    //   254	291	1095	java/io/IOException
    //   296	305	1095	java/io/IOException
    //   321	360	1095	java/io/IOException
    //   372	378	1158	finally
    //   390	398	1158	finally
    //   410	418	1158	finally
    //   430	436	1158	finally
    //   448	458	1158	finally
    //   493	506	1158	finally
    //   524	531	1158	finally
    //   547	569	1158	finally
    //   581	588	1158	finally
    //   605	629	1158	finally
    //   645	651	1158	finally
    //   668	682	1158	finally
    //   699	705	1158	finally
    //   723	737	1158	finally
    //   749	760	1158	finally
    //   772	778	1158	finally
    //   790	799	1158	finally
    //   811	820	1158	finally
    //   832	842	1158	finally
    //   854	888	1158	finally
    //   904	913	1158	finally
    //   925	934	1158	finally
    //   946	956	1158	finally
    //   968	979	1158	finally
    //   995	1012	1158	finally
    //   1021	1030	1158	finally
    //   1042	1058	1158	finally
    //   1102	1107	1158	finally
    //   1110	1126	1158	finally
    //   1167	1176	1158	finally
    //   1179	1195	1158	finally
    //   254	291	1281	java/lang/OutOfMemoryError
    //   296	305	1281	java/lang/OutOfMemoryError
    //   321	360	1281	java/lang/OutOfMemoryError
    //   372	378	1285	java/lang/OutOfMemoryError
    //   390	398	1285	java/lang/OutOfMemoryError
    //   410	418	1285	java/lang/OutOfMemoryError
    //   430	436	1285	java/lang/OutOfMemoryError
    //   448	458	1285	java/lang/OutOfMemoryError
    //   493	506	1285	java/lang/OutOfMemoryError
    //   524	531	1285	java/lang/OutOfMemoryError
    //   547	569	1285	java/lang/OutOfMemoryError
    //   581	588	1285	java/lang/OutOfMemoryError
    //   605	629	1285	java/lang/OutOfMemoryError
    //   645	651	1285	java/lang/OutOfMemoryError
    //   668	682	1285	java/lang/OutOfMemoryError
    //   699	705	1285	java/lang/OutOfMemoryError
    //   723	737	1285	java/lang/OutOfMemoryError
    //   749	760	1285	java/lang/OutOfMemoryError
    //   772	778	1285	java/lang/OutOfMemoryError
    //   790	799	1285	java/lang/OutOfMemoryError
    //   811	820	1285	java/lang/OutOfMemoryError
    //   832	842	1285	java/lang/OutOfMemoryError
    //   854	888	1285	java/lang/OutOfMemoryError
    //   904	913	1285	java/lang/OutOfMemoryError
    //   925	934	1285	java/lang/OutOfMemoryError
    //   946	956	1285	java/lang/OutOfMemoryError
    //   968	979	1285	java/lang/OutOfMemoryError
    //   995	1012	1285	java/lang/OutOfMemoryError
    //   1021	1030	1285	java/lang/OutOfMemoryError
    //   1042	1058	1285	java/lang/OutOfMemoryError
  }
  
  /* Error */
  public static boolean a(Bitmap paramBitmap, String paramString, Bitmap.CompressFormat paramCompressFormat, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: new 15	java/io/File
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
    //   31: new 388	java/io/BufferedOutputStream
    //   34: dup
    //   35: new 390	java/io/FileOutputStream
    //   38: dup
    //   39: aload 12
    //   41: invokespecial 393	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   44: invokespecial 396	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   47: astore 12
    //   49: aload_0
    //   50: aload_2
    //   51: iload_3
    //   52: aload 12
    //   54: invokevirtual 400	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   57: istore 5
    //   59: iload 5
    //   61: istore 6
    //   63: iload 5
    //   65: istore 7
    //   67: aload 12
    //   69: invokevirtual 403	java/io/BufferedOutputStream:flush	()V
    //   72: iload 4
    //   74: ifeq +15 -> 89
    //   77: iload 5
    //   79: istore 6
    //   81: iload 5
    //   83: istore 7
    //   85: aload_0
    //   86: invokevirtual 406	android/graphics/Bitmap:recycle	()V
    //   89: iload 5
    //   91: istore 4
    //   93: aload 12
    //   95: invokevirtual 409	java/io/BufferedOutputStream:close	()V
    //   98: iload 5
    //   100: istore 4
    //   102: goto +127 -> 229
    //   105: astore_0
    //   106: aload_0
    //   107: invokevirtual 300	java/io/IOException:printStackTrace	()V
    //   110: goto +119 -> 229
    //   113: astore_0
    //   114: aload 12
    //   116: astore 11
    //   118: goto +236 -> 354
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
    //   148: goto +206 -> 354
    //   151: aload_0
    //   152: astore 11
    //   154: ldc 43
    //   156: iconst_1
    //   157: ldc_w 411
    //   160: invokestatic 320	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   163: iload 5
    //   165: istore 4
    //   167: aload_0
    //   168: ifnull +61 -> 229
    //   171: iload 5
    //   173: istore 4
    //   175: aload_0
    //   176: invokevirtual 409	java/io/BufferedOutputStream:close	()V
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
    //   198: ldc 43
    //   200: iconst_1
    //   201: ldc_w 413
    //   204: aload 12
    //   206: invokestatic 416	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   209: iload 5
    //   211: istore 4
    //   213: aload_0
    //   214: ifnull +15 -> 229
    //   217: iload 5
    //   219: istore 4
    //   221: aload_0
    //   222: invokevirtual 409	java/io/BufferedOutputStream:close	()V
    //   225: iload 5
    //   227: istore 4
    //   229: invokestatic 224	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   232: ifeq +119 -> 351
    //   235: lconst_0
    //   236: lstore 9
    //   238: new 15	java/io/File
    //   241: dup
    //   242: aload_1
    //   243: invokespecial 183	java/io/File:<init>	(Ljava/lang/String;)V
    //   246: invokevirtual 36	java/io/File:exists	()Z
    //   249: ifeq +20 -> 269
    //   252: new 15	java/io/File
    //   255: dup
    //   256: aload_1
    //   257: invokespecial 183	java/io/File:<init>	(Ljava/lang/String;)V
    //   260: invokevirtual 419	java/io/File:length	()J
    //   263: ldc2_w 420
    //   266: ldiv
    //   267: lstore 9
    //   269: new 164	java/lang/StringBuilder
    //   272: dup
    //   273: invokespecial 165	java/lang/StringBuilder:<init>	()V
    //   276: astore_0
    //   277: aload_0
    //   278: ldc_w 423
    //   281: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: pop
    //   285: aload_0
    //   286: aload_1
    //   287: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: pop
    //   291: aload_0
    //   292: ldc 238
    //   294: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: pop
    //   298: aload_0
    //   299: aload_2
    //   300: invokevirtual 335	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   303: pop
    //   304: aload_0
    //   305: ldc_w 425
    //   308: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: pop
    //   312: aload_0
    //   313: iload_3
    //   314: invokevirtual 234	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   317: pop
    //   318: aload_0
    //   319: ldc_w 427
    //   322: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: pop
    //   326: aload_0
    //   327: lload 9
    //   329: invokevirtual 229	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   332: pop
    //   333: aload_0
    //   334: ldc_w 429
    //   337: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: pop
    //   341: ldc 43
    //   343: iconst_2
    //   344: aload_0
    //   345: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   348: invokestatic 50	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   351: iload 4
    //   353: ireturn
    //   354: aload 11
    //   356: ifnull +16 -> 372
    //   359: aload 11
    //   361: invokevirtual 409	java/io/BufferedOutputStream:close	()V
    //   364: goto +8 -> 372
    //   367: astore_1
    //   368: aload_1
    //   369: invokevirtual 300	java/io/IOException:printStackTrace	()V
    //   372: aload_0
    //   373: athrow
    //   374: astore_0
    //   375: aload 14
    //   377: astore_0
    //   378: goto -227 -> 151
    //   381: astore_0
    //   382: goto -261 -> 121
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	385	0	paramBitmap	Bitmap
    //   0	385	1	paramString	String
    //   0	385	2	paramCompressFormat	Bitmap.CompressFormat
    //   0	385	3	paramInt	int
    //   0	385	4	paramBoolean	boolean
    //   11	215	5	bool1	boolean
    //   20	117	6	bool2	boolean
    //   17	108	7	bool3	boolean
    //   14	178	8	bool4	boolean
    //   236	92	9	l	long
    //   29	88	11	localObject1	Object
    //   131	10	11	localException1	Exception
    //   152	208	11	localBitmap	Bitmap
    //   8	135	12	localObject2	Object
    //   186	19	12	localException2	Exception
    //   26	163	13	localObject3	Object
    //   23	353	14	localObject4	Object
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
    //   359	364	367	java/io/IOException
    //   31	49	374	java/lang/OutOfMemoryError
    //   49	59	381	java/lang/OutOfMemoryError
    //   67	72	381	java/lang/OutOfMemoryError
    //   85	89	381	java/lang/OutOfMemoryError
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
    //   8: new 390	java/io/FileOutputStream
    //   11: dup
    //   12: aload_0
    //   13: invokespecial 430	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   16: astore_0
    //   17: aload_1
    //   18: ifnull +27 -> 45
    //   21: aload_1
    //   22: new 261	android/graphics/Rect
    //   25: dup
    //   26: iconst_0
    //   27: iconst_0
    //   28: aload_1
    //   29: invokevirtual 431	android/graphics/YuvImage:getWidth	()I
    //   32: aload_1
    //   33: invokevirtual 432	android/graphics/YuvImage:getHeight	()I
    //   36: invokespecial 272	android/graphics/Rect:<init>	(IIII)V
    //   39: iload_2
    //   40: aload_0
    //   41: invokevirtual 436	android/graphics/YuvImage:compressToJpeg	(Landroid/graphics/Rect;ILjava/io/OutputStream;)Z
    //   44: pop
    //   45: aload_0
    //   46: invokevirtual 437	java/io/FileOutputStream:flush	()V
    //   49: iconst_1
    //   50: istore_3
    //   51: aload_0
    //   52: invokevirtual 438	java/io/FileOutputStream:close	()V
    //   55: iconst_1
    //   56: ireturn
    //   57: astore_0
    //   58: aload_0
    //   59: invokevirtual 300	java/io/IOException:printStackTrace	()V
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
    //   95: invokevirtual 438	java/io/FileOutputStream:close	()V
    //   98: iconst_0
    //   99: ireturn
    //   100: aload_0
    //   101: ifnull +15 -> 116
    //   104: aload_0
    //   105: invokevirtual 438	java/io/FileOutputStream:close	()V
    //   108: goto +8 -> 116
    //   111: astore_0
    //   112: aload_0
    //   113: invokevirtual 300	java/io/IOException:printStackTrace	()V
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
    if (OcrDpc.b() != null)
    {
      if (OcrDpc.b().e < 400) {
        j = 400;
      } else {
        j = OcrDpc.b().e;
      }
      if (OcrDpc.b().d < 10) {
        i = 10;
      } else {
        i = OcrDpc.b().d;
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
    //   0: new 15	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 183	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: aload_0
    //   10: invokevirtual 419	java/io/File:length	()J
    //   13: l2i
    //   14: newarray byte
    //   16: astore_2
    //   17: new 508	java/io/BufferedInputStream
    //   20: dup
    //   21: new 510	java/io/FileInputStream
    //   24: dup
    //   25: aload_0
    //   26: invokespecial 511	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   29: invokespecial 514	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   32: astore_1
    //   33: aload_1
    //   34: astore_0
    //   35: aload_1
    //   36: aload_2
    //   37: iconst_0
    //   38: aload_2
    //   39: arraylength
    //   40: invokevirtual 518	java/io/BufferedInputStream:read	([BII)I
    //   43: pop
    //   44: aload_1
    //   45: astore_0
    //   46: aload_1
    //   47: invokevirtual 519	java/io/BufferedInputStream:close	()V
    //   50: aload_1
    //   51: invokevirtual 519	java/io/BufferedInputStream:close	()V
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
    //   89: invokevirtual 300	java/io/IOException:printStackTrace	()V
    //   92: aload_1
    //   93: invokevirtual 519	java/io/BufferedInputStream:close	()V
    //   96: goto +28 -> 124
    //   99: astore_0
    //   100: goto +20 -> 120
    //   103: astore_2
    //   104: aconst_null
    //   105: astore_1
    //   106: aload_1
    //   107: astore_0
    //   108: aload_2
    //   109: invokevirtual 520	java/io/FileNotFoundException:printStackTrace	()V
    //   112: aload_1
    //   113: invokevirtual 519	java/io/BufferedInputStream:close	()V
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
    //   140: ldc 43
    //   142: iconst_1
    //   143: ldc_w 522
    //   146: invokestatic 50	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   149: aconst_null
    //   150: areturn
    //   151: astore_1
    //   152: aload_0
    //   153: invokevirtual 519	java/io/BufferedInputStream:close	()V
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
  
  public static boolean b(String paramString)
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
  
  public static String c(String paramString)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OcrImageUtil
 * JD-Core Version:    0.7.0.1
 */