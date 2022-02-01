package com.tencent.tavcut.util;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.media.ExifInterface;
import android.support.annotation.NonNull;
import com.tencent.tavcut.bean.CropConfig;
import com.tencent.tavcut.bean.Size;
import java.io.File;
import java.io.IOException;

public class BitmapUtil
{
  public static final int BUFFER_SIZE_DECODE_BITMAP = 8192;
  public static final int BUFFER_SIZE_DECODE_BOUND = 2048;
  private static final String TAG = BitmapUtil.class.getSimpleName();
  
  public static Bitmap cropBitmap(String paramString, CropConfig paramCropConfig)
  {
    return cropBitmap(paramString, paramCropConfig, 1);
  }
  
  public static Bitmap cropBitmap(String paramString, @NonNull CropConfig paramCropConfig, int paramInt)
  {
    try
    {
      paramString = decodeBitmap(paramString, paramInt);
      if (!isValidBitmap(paramString)) {
        return null;
      }
      Bitmap localBitmap = Bitmap.createBitmap((int)(paramString.getWidth() * paramCropConfig.getWidth()), (int)(paramString.getHeight() * paramCropConfig.getHeight()), paramString.getConfig());
      new Canvas(localBitmap).drawBitmap(paramString, new Rect((int)(paramString.getWidth() * paramCropConfig.getX()), (int)(paramString.getHeight() * paramCropConfig.getY()), (int)(paramString.getWidth() * (paramCropConfig.getX() + paramCropConfig.getWidth())), (int)(paramString.getHeight() * (paramCropConfig.getY() + paramCropConfig.getHeight()))), new Rect(0, 0, localBitmap.getWidth(), localBitmap.getHeight()), new Paint());
      return localBitmap;
    }
    catch (Exception paramString)
    {
      Logger.e(paramString);
      return null;
    }
    catch (Error paramString)
    {
      Logger.e(paramString);
    }
    return null;
  }
  
  public static Bitmap decodeBitmap(String paramString, int paramInt)
  {
    try
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inSampleSize = paramInt;
      paramString = BitmapFactory.decodeFile(paramString, localOptions);
      return paramString;
    }
    catch (Exception paramString)
    {
      Logger.e(paramString);
      return null;
    }
    catch (Error paramString)
    {
      for (;;)
      {
        Logger.e(paramString);
      }
    }
  }
  
  /* Error */
  public static Bitmap decodeFileWithBuffer(String paramString, BitmapFactory.Options paramOptions)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 114	java/io/FileInputStream
    //   6: dup
    //   7: aload_0
    //   8: invokespecial 117	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   11: astore_2
    //   12: aload_1
    //   13: ifnull +47 -> 60
    //   16: aload_2
    //   17: astore_0
    //   18: aload_1
    //   19: getfield 121	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   22: ifeq +38 -> 60
    //   25: aload_2
    //   26: astore_0
    //   27: new 123	java/io/BufferedInputStream
    //   30: dup
    //   31: aload_2
    //   32: sipush 2048
    //   35: invokespecial 126	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   38: aconst_null
    //   39: aload_1
    //   40: invokestatic 130	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   43: astore_1
    //   44: aload_1
    //   45: astore_0
    //   46: aload_0
    //   47: astore_3
    //   48: aload_2
    //   49: ifnull +9 -> 58
    //   52: aload_2
    //   53: invokevirtual 135	java/io/InputStream:close	()V
    //   56: aload_0
    //   57: astore_3
    //   58: aload_3
    //   59: areturn
    //   60: aload_2
    //   61: astore_0
    //   62: new 123	java/io/BufferedInputStream
    //   65: dup
    //   66: aload_2
    //   67: sipush 8192
    //   70: invokespecial 126	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   73: aconst_null
    //   74: aload_1
    //   75: invokestatic 130	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   78: astore_1
    //   79: aload_1
    //   80: astore_0
    //   81: goto -35 -> 46
    //   84: astore_3
    //   85: aconst_null
    //   86: astore_1
    //   87: aload_1
    //   88: astore_0
    //   89: getstatic 21	com/tencent/tavcut/util/BitmapUtil:TAG	Ljava/lang/String;
    //   92: aload_3
    //   93: invokevirtual 138	java/lang/Exception:toString	()Ljava/lang/String;
    //   96: invokestatic 141	com/tencent/tavcut/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   99: aload 4
    //   101: astore_3
    //   102: aload_1
    //   103: ifnull -45 -> 58
    //   106: aload_1
    //   107: invokevirtual 135	java/io/InputStream:close	()V
    //   110: aconst_null
    //   111: areturn
    //   112: astore_0
    //   113: aconst_null
    //   114: areturn
    //   115: astore_1
    //   116: aconst_null
    //   117: astore_0
    //   118: aload_0
    //   119: ifnull +7 -> 126
    //   122: aload_0
    //   123: invokevirtual 135	java/io/InputStream:close	()V
    //   126: aload_1
    //   127: athrow
    //   128: astore_1
    //   129: aload_0
    //   130: areturn
    //   131: astore_0
    //   132: goto -6 -> 126
    //   135: astore_1
    //   136: goto -18 -> 118
    //   139: astore_3
    //   140: aload_2
    //   141: astore_1
    //   142: goto -55 -> 87
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	145	0	paramString	String
    //   0	145	1	paramOptions	BitmapFactory.Options
    //   11	130	2	localFileInputStream	java.io.FileInputStream
    //   47	12	3	str	String
    //   84	9	3	localException1	Exception
    //   101	1	3	localObject1	Object
    //   139	1	3	localException2	Exception
    //   1	99	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   3	12	84	java/lang/Exception
    //   106	110	112	java/io/IOException
    //   3	12	115	finally
    //   52	56	128	java/io/IOException
    //   122	126	131	java/io/IOException
    //   18	25	135	finally
    //   27	44	135	finally
    //   62	79	135	finally
    //   89	99	135	finally
    //   18	25	139	java/lang/Exception
    //   27	44	139	java/lang/Exception
    //   62	79	139	java/lang/Exception
  }
  
  public static Bitmap getBitmapWithSize(String paramString, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!new File(paramString).exists()) {
      return null;
    }
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    decodeFileWithBuffer(paramString, localOptions);
    localOptions.inJustDecodeBounds = false;
    int i = localOptions.outWidth;
    int j = localOptions.outHeight;
    j = Math.min(i / paramInt1, j / paramInt2);
    i = j;
    if (j < 1) {
      i = 1;
    }
    localOptions.inSampleSize = i;
    Bitmap localBitmap2 = retryOptionBitmap(localOptions, paramString, true);
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null)
    {
      localOptions.inSampleSize += 1;
      localBitmap1 = retryOptionBitmap(localOptions, paramString);
    }
    if (localBitmap1 == null) {
      return null;
    }
    i = localBitmap1.getWidth();
    j = localBitmap1.getHeight();
    float f2 = paramInt1 / i;
    float f3 = paramInt2 / j;
    if ((f2 > 1.0F) && (f3 > 1.0F)) {
      return localBitmap1;
    }
    paramString = new Matrix();
    if (paramBoolean1)
    {
      float f1 = Math.min(f2, f3);
      if (paramBoolean2) {
        f1 = Math.max(f2, f3);
      }
      paramString.postScale(f1, f1);
    }
    for (;;)
    {
      return retryMatrixBitmap(localBitmap1, i, j, paramString, true);
      paramString.postScale(f2, f3);
    }
  }
  
  public static int getImageRotation(String paramString)
  {
    try
    {
      int i = new ExifInterface(paramString).getAttributeInt("Orientation", 1);
      switch (i)
      {
      case 4: 
      case 5: 
      case 7: 
      default: 
        return 0;
      case 6: 
        return 90;
      case 3: 
        return 180;
      }
      return 270;
    }
    catch (IOException paramString)
    {
      Logger.e(paramString);
    }
    return 0;
  }
  
  public static Size getImageSize(@NonNull String paramString)
  {
    return getImageSize(paramString, true);
  }
  
  public static Size getImageSize(@NonNull String paramString, boolean paramBoolean)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions);
    Size localSize = new Size(localOptions.outWidth, localOptions.outHeight);
    if (paramBoolean)
    {
      int i = getImageRotation(paramString);
      if ((i == 90) || (i == 270))
      {
        localSize.setWidth(localOptions.outHeight);
        localSize.setHeight(localOptions.outWidth);
      }
    }
    return localSize;
  }
  
  public static boolean isValidBitmap(Bitmap paramBitmap)
  {
    return (paramBitmap != null) && (!paramBitmap.isRecycled());
  }
  
  public static Bitmap retryMatrixBitmap(Bitmap paramBitmap, int paramInt1, int paramInt2, Matrix paramMatrix, boolean paramBoolean)
  {
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, paramInt1, paramInt2, paramMatrix, true);
      return localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      Logger.e(TAG, "catch out of mem Matrix " + paramBoolean, localOutOfMemoryError);
      if (paramBoolean) {
        return retryMatrixBitmap(paramBitmap, paramInt1, paramInt2, paramMatrix, false);
      }
    }
    return null;
  }
  
  private static Bitmap retryOptionBitmap(BitmapFactory.Options paramOptions, String paramString)
  {
    int i = 0;
    Object localObject = null;
    for (;;)
    {
      if ((i > 0) && (paramOptions.inSampleSize > 7)) {
        return localObject;
      }
      try
      {
        Bitmap localBitmap = decodeFileWithBuffer(paramString, paramOptions);
        localObject = localBitmap;
        Logger.i("QZoneUpload", "options.inSampleSize ： " + paramOptions.inSampleSize);
        return localBitmap;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        Logger.e(TAG, "catch out of mem Option small options", localOutOfMemoryError);
        paramOptions.inSampleSize += 1;
        i += 1;
      }
    }
  }
  
  private static Bitmap retryOptionBitmap(BitmapFactory.Options paramOptions, String paramString, boolean paramBoolean)
  {
    Object localObject = null;
    try
    {
      Bitmap localBitmap = decodeFileWithBuffer(paramString, paramOptions);
      localObject = localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      do
      {
        Logger.e(TAG, "catch out of mem Option " + paramBoolean, localOutOfMemoryError);
      } while (!paramBoolean);
    }
    return localObject;
    return retryOptionBitmap(paramOptions, paramString, false);
  }
  
  public static boolean saveBitmap(Bitmap paramBitmap, int paramInt, String paramString)
  {
    return saveBitmap(paramBitmap, Bitmap.CompressFormat.JPEG, paramInt, paramString, null);
  }
  
  /* Error */
  public static boolean saveBitmap(Bitmap paramBitmap, Bitmap.CompressFormat paramCompressFormat, int paramInt, String paramString, ExifInterface paramExifInterface)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 7
    //   3: iconst_0
    //   4: istore 5
    //   6: aload_0
    //   7: invokestatic 43	com/tencent/tavcut/util/BitmapUtil:isValidBitmap	(Landroid/graphics/Bitmap;)Z
    //   10: ifne +14 -> 24
    //   13: getstatic 21	com/tencent/tavcut/util/BitmapUtil:TAG	Ljava/lang/String;
    //   16: ldc_w 269
    //   19: invokestatic 141	com/tencent/tavcut/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   22: iconst_0
    //   23: ireturn
    //   24: aconst_null
    //   25: astore 9
    //   27: new 271	java/io/FileOutputStream
    //   30: dup
    //   31: new 145	java/io/File
    //   34: dup
    //   35: aload_3
    //   36: invokespecial 146	java/io/File:<init>	(Ljava/lang/String;)V
    //   39: invokespecial 274	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   42: astore 10
    //   44: aload 10
    //   46: astore 9
    //   48: aload_0
    //   49: aload_1
    //   50: iload_2
    //   51: aload 10
    //   53: invokevirtual 278	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   56: pop
    //   57: aload 10
    //   59: ifnull +230 -> 289
    //   62: aload 10
    //   64: invokevirtual 281	java/io/FileOutputStream:flush	()V
    //   67: aload 10
    //   69: invokevirtual 282	java/io/FileOutputStream:close	()V
    //   72: aload 4
    //   74: ifnull +191 -> 265
    //   77: new 192	android/media/ExifInterface
    //   80: dup
    //   81: aload_3
    //   82: invokespecial 193	android/media/ExifInterface:<init>	(Ljava/lang/String;)V
    //   85: astore_0
    //   86: ldc 192
    //   88: invokevirtual 286	java/lang/Class:getFields	()[Ljava/lang/reflect/Field;
    //   91: astore_1
    //   92: aload_1
    //   93: arraylength
    //   94: istore 6
    //   96: iload 5
    //   98: istore_2
    //   99: iload_2
    //   100: iload 6
    //   102: if_icmpge +166 -> 268
    //   105: aload_1
    //   106: iload_2
    //   107: aaload
    //   108: astore_3
    //   109: aload_3
    //   110: invokevirtual 291	java/lang/reflect/Field:getName	()Ljava/lang/String;
    //   113: astore 9
    //   115: aload 9
    //   117: invokestatic 297	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   120: ifne +37 -> 157
    //   123: aload 9
    //   125: ldc_w 298
    //   128: invokevirtual 304	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   131: ifeq +26 -> 157
    //   134: aload_3
    //   135: ldc 192
    //   137: invokevirtual 308	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   140: invokevirtual 309	java/lang/Object:toString	()Ljava/lang/String;
    //   143: astore_3
    //   144: aload_3
    //   145: ldc 195
    //   147: invokevirtual 313	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   150: istore 8
    //   152: iload 8
    //   154: ifeq +83 -> 237
    //   157: iload_2
    //   158: iconst_1
    //   159: iadd
    //   160: istore_2
    //   161: goto -62 -> 99
    //   164: astore_0
    //   165: aload_0
    //   166: invokestatic 96	com/tencent/tavcut/util/Logger:e	(Ljava/lang/Throwable;)V
    //   169: iconst_0
    //   170: istore 7
    //   172: goto -100 -> 72
    //   175: astore_1
    //   176: aconst_null
    //   177: astore_0
    //   178: aload_0
    //   179: astore 9
    //   181: aload_1
    //   182: invokestatic 96	com/tencent/tavcut/util/Logger:e	(Ljava/lang/Throwable;)V
    //   185: aload_0
    //   186: ifnull +103 -> 289
    //   189: aload_0
    //   190: invokevirtual 281	java/io/FileOutputStream:flush	()V
    //   193: aload_0
    //   194: invokevirtual 282	java/io/FileOutputStream:close	()V
    //   197: goto -125 -> 72
    //   200: astore_0
    //   201: aload_0
    //   202: invokestatic 96	com/tencent/tavcut/util/Logger:e	(Ljava/lang/Throwable;)V
    //   205: iconst_0
    //   206: istore 7
    //   208: goto -136 -> 72
    //   211: astore_0
    //   212: aload 9
    //   214: astore_1
    //   215: aload_1
    //   216: ifnull +11 -> 227
    //   219: aload_1
    //   220: invokevirtual 281	java/io/FileOutputStream:flush	()V
    //   223: aload_1
    //   224: invokevirtual 282	java/io/FileOutputStream:close	()V
    //   227: aload_0
    //   228: athrow
    //   229: astore_1
    //   230: aload_1
    //   231: invokestatic 96	com/tencent/tavcut/util/Logger:e	(Ljava/lang/Throwable;)V
    //   234: goto -7 -> 227
    //   237: aload 4
    //   239: aload_3
    //   240: invokevirtual 317	android/media/ExifInterface:getAttribute	(Ljava/lang/String;)Ljava/lang/String;
    //   243: astore 9
    //   245: aload 9
    //   247: ifnull -90 -> 157
    //   250: aload_0
    //   251: aload_3
    //   252: aload 9
    //   254: invokevirtual 320	android/media/ExifInterface:setAttribute	(Ljava/lang/String;Ljava/lang/String;)V
    //   257: goto -100 -> 157
    //   260: astore_0
    //   261: aload_0
    //   262: invokestatic 96	com/tencent/tavcut/util/Logger:e	(Ljava/lang/Throwable;)V
    //   265: iload 7
    //   267: ireturn
    //   268: aload_0
    //   269: invokevirtual 323	android/media/ExifInterface:saveAttributes	()V
    //   272: goto -7 -> 265
    //   275: astore_0
    //   276: aload 9
    //   278: astore_1
    //   279: goto -64 -> 215
    //   282: astore_1
    //   283: aload 10
    //   285: astore_0
    //   286: goto -108 -> 178
    //   289: iconst_0
    //   290: istore 7
    //   292: goto -220 -> 72
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	295	0	paramBitmap	Bitmap
    //   0	295	1	paramCompressFormat	Bitmap.CompressFormat
    //   0	295	2	paramInt	int
    //   0	295	3	paramString	String
    //   0	295	4	paramExifInterface	ExifInterface
    //   4	93	5	i	int
    //   94	9	6	j	int
    //   1	290	7	bool1	boolean
    //   150	3	8	bool2	boolean
    //   25	252	9	localObject	Object
    //   42	242	10	localFileOutputStream	java.io.FileOutputStream
    // Exception table:
    //   from	to	target	type
    //   62	72	164	java/io/IOException
    //   27	44	175	java/io/IOException
    //   189	197	200	java/io/IOException
    //   27	44	211	finally
    //   219	227	229	java/io/IOException
    //   77	96	260	java/lang/Exception
    //   109	152	260	java/lang/Exception
    //   237	245	260	java/lang/Exception
    //   250	257	260	java/lang/Exception
    //   268	272	260	java/lang/Exception
    //   48	57	275	finally
    //   181	185	275	finally
    //   48	57	282	java/io/IOException
  }
  
  public static Bitmap scaleBitmap(Bitmap paramBitmap, int paramInt)
  {
    try
    {
      if (!isValidBitmap(paramBitmap)) {
        return null;
      }
      int i = Math.max(paramBitmap.getWidth(), paramBitmap.getHeight());
      if (i > paramInt)
      {
        float f = paramInt * 1.0F / i;
        Matrix localMatrix = new Matrix();
        localMatrix.postScale(f, f);
        paramBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), localMatrix, false);
        return paramBitmap;
      }
    }
    catch (Exception paramBitmap)
    {
      Logger.e(paramBitmap);
      return null;
    }
    catch (Error paramBitmap)
    {
      for (;;)
      {
        Logger.e(paramBitmap);
      }
    }
    return paramBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavcut.util.BitmapUtil
 * JD-Core Version:    0.7.0.1
 */