package com.tencent.qcircle.tavcut.util;

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
import com.tencent.qcircle.tavcut.bean.CropConfig;
import com.tencent.qcircle.tavcut.bean.Size;
import java.io.File;
import java.io.IOException;

public class BitmapUtil
{
  public static final int BUFFER_SIZE_DECODE_BITMAP = 8192;
  public static final int BUFFER_SIZE_DECODE_BOUND = 2048;
  private static final String TAG = "BitmapUtil";
  
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
    catch (Error paramString)
    {
      Logger.e(paramString);
      return null;
    }
    catch (Exception paramString)
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
    catch (Error paramString)
    {
      Logger.e(paramString);
    }
    catch (Exception paramString)
    {
      Logger.e(paramString);
    }
    return null;
  }
  
  public static Bitmap decodeBitmapWithCrop(String paramString, CropConfig paramCropConfig)
  {
    for (;;)
    {
      try
      {
        if (!new File(paramString).exists()) {
          return null;
        }
        localOptions = new BitmapFactory.Options();
        localOptions.inJustDecodeBounds = true;
        decodeFileWithBuffer(paramString, localOptions);
        localOptions.inJustDecodeBounds = false;
        i = Math.max(localOptions.outWidth, localOptions.outHeight);
        if (i <= 2560) {
          break label307;
        }
        i = i / 2560 + 1;
      }
      catch (Error paramString)
      {
        BitmapFactory.Options localOptions;
        Object localObject1;
        Object localObject2;
        Logger.e(paramString);
        return null;
      }
      catch (Exception paramString)
      {
        Logger.e(paramString);
        return null;
      }
      localObject1 = TAG;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("decodeBitmapWithCrop... samplesize = ");
      ((StringBuilder)localObject2).append(j);
      Logger.i((String)localObject1, ((StringBuilder)localObject2).toString());
      localOptions.inSampleSize = j;
      localOptions.inMutable = true;
      localObject2 = retryOptionBitmap(localOptions, paramString, true);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        Logger.i(TAG, "decodeBitmapWithCrop... bitmap is null");
        localOptions.inSampleSize += 1;
        localObject1 = retryOptionBitmap(localOptions, paramString);
      }
      if (localObject1 == null)
      {
        Logger.i(TAG, "decodeBitmapWithCrop... bitmap == null");
        return null;
      }
      paramCropConfig = Bitmap.createBitmap((Bitmap)localObject1, (int)(((Bitmap)localObject1).getWidth() * paramCropConfig.getX()), (int)(((Bitmap)localObject1).getHeight() * paramCropConfig.getY()), (int)(((Bitmap)localObject1).getWidth() * paramCropConfig.getWidth()), (int)(((Bitmap)localObject1).getHeight() * paramCropConfig.getHeight()));
      int i = getImageRotation(paramString);
      if (i != 0)
      {
        paramString = new Matrix();
        paramString.setRotate(i);
        paramString = retryMatrixBitmap(paramCropConfig, paramCropConfig.getWidth(), paramCropConfig.getHeight(), paramString, false);
        if ((paramString != paramCropConfig) && (paramString != null)) {
          return paramString;
        }
      }
      return paramCropConfig;
      label307:
      i = 1;
      int j = i;
      if (i < 1) {
        j = 1;
      }
    }
  }
  
  /* Error */
  public static Bitmap decodeFileWithBuffer(String paramString, BitmapFactory.Options paramOptions)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 190	java/io/FileInputStream
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 191	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   10: astore_0
    //   11: aload_1
    //   12: ifnull +34 -> 46
    //   15: aload_0
    //   16: astore_2
    //   17: aload_1
    //   18: getfield 117	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   21: ifeq +25 -> 46
    //   24: aload_0
    //   25: astore_2
    //   26: new 193	java/io/BufferedInputStream
    //   29: dup
    //   30: aload_0
    //   31: sipush 2048
    //   34: invokespecial 196	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   37: aconst_null
    //   38: aload_1
    //   39: invokestatic 200	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   42: astore_1
    //   43: goto +22 -> 65
    //   46: aload_0
    //   47: astore_2
    //   48: new 193	java/io/BufferedInputStream
    //   51: dup
    //   52: aload_0
    //   53: sipush 8192
    //   56: invokespecial 196	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   59: aconst_null
    //   60: aload_1
    //   61: invokestatic 200	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   64: astore_1
    //   65: aload_0
    //   66: invokevirtual 205	java/io/InputStream:close	()V
    //   69: aload_1
    //   70: areturn
    //   71: astore_1
    //   72: goto +12 -> 84
    //   75: astore_0
    //   76: aconst_null
    //   77: astore_2
    //   78: goto +30 -> 108
    //   81: astore_1
    //   82: aconst_null
    //   83: astore_0
    //   84: aload_0
    //   85: astore_2
    //   86: getstatic 134	com/tencent/qcircle/tavcut/util/BitmapUtil:TAG	Ljava/lang/String;
    //   89: aload_1
    //   90: invokevirtual 206	java/lang/Exception:toString	()Ljava/lang/String;
    //   93: invokestatic 208	com/tencent/qcircle/tavcut/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   96: aload_0
    //   97: ifnull +8 -> 105
    //   100: aload_3
    //   101: astore_1
    //   102: goto -37 -> 65
    //   105: aconst_null
    //   106: areturn
    //   107: astore_0
    //   108: aload_2
    //   109: ifnull +7 -> 116
    //   112: aload_2
    //   113: invokevirtual 205	java/io/InputStream:close	()V
    //   116: goto +5 -> 121
    //   119: aload_0
    //   120: athrow
    //   121: goto -2 -> 119
    //   124: astore_0
    //   125: aload_1
    //   126: areturn
    //   127: astore_1
    //   128: goto -12 -> 116
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	131	0	paramString	String
    //   0	131	1	paramOptions	BitmapFactory.Options
    //   16	97	2	str	String
    //   1	100	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   17	24	71	java/lang/Exception
    //   26	43	71	java/lang/Exception
    //   48	65	71	java/lang/Exception
    //   2	11	75	finally
    //   2	11	81	java/lang/Exception
    //   17	24	107	finally
    //   26	43	107	finally
    //   48	65	107	finally
    //   86	96	107	finally
    //   65	69	124	java/io/IOException
    //   112	116	127	java/io/IOException
  }
  
  public static Bitmap getBitmapWithSize(String paramString, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!new File(paramString).exists()) {
      return null;
    }
    int k = getImageRotation(paramString);
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
    if ((f2 > 1.0F) && (f3 > 1.0F))
    {
      if (k == 0) {
        return localBitmap1;
      }
      paramString = new Matrix();
      paramString.postRotate(k, localBitmap1.getWidth() / 2.0F, localBitmap1.getHeight() / 2.0F);
      return retryMatrixBitmap(localBitmap1, i, j, paramString, true);
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
    else
    {
      paramString.postScale(f2, f3);
    }
    if (k != 0) {
      paramString.postRotate(k, localBitmap1.getWidth() / 2.0F, localBitmap1.getHeight() / 2.0F);
    }
    return retryMatrixBitmap(localBitmap1, i, j, paramString, true);
  }
  
  public static int getImageRotation(String paramString)
  {
    try
    {
      int i = new ExifInterface(paramString).getAttributeInt("Orientation", 1);
      if (i != 3)
      {
        if (i != 6)
        {
          if (i != 8) {
            return 0;
          }
          return 270;
        }
        return 90;
      }
      return 180;
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
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("catch out of mem Matrix ");
      localStringBuilder.append(paramBoolean);
      Logger.e(str, localStringBuilder.toString(), localOutOfMemoryError);
      if (paramBoolean) {
        return retryMatrixBitmap(paramBitmap, paramInt1, paramInt2, paramMatrix, false);
      }
    }
    return null;
  }
  
  private static Bitmap retryOptionBitmap(BitmapFactory.Options paramOptions, String paramString)
  {
    Object localObject = null;
    int i = 0;
    for (;;)
    {
      if ((i > 0) && (paramOptions.inSampleSize > 7)) {
        return localObject;
      }
      try
      {
        Bitmap localBitmap = decodeFileWithBuffer(paramString, paramOptions);
        localObject = localBitmap;
        StringBuilder localStringBuilder = new StringBuilder();
        localObject = localBitmap;
        localStringBuilder.append("options.inSampleSize ： ");
        localObject = localBitmap;
        localStringBuilder.append(paramOptions.inSampleSize);
        localObject = localBitmap;
        Logger.i("QZoneUpload", localStringBuilder.toString());
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
    try
    {
      Bitmap localBitmap = decodeFileWithBuffer(paramString, paramOptions);
      return localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("catch out of mem Option ");
      localStringBuilder.append(paramBoolean);
      Logger.e(str, localStringBuilder.toString(), localOutOfMemoryError);
      if (paramBoolean) {
        return retryOptionBitmap(paramOptions, paramString, false);
      }
    }
    return null;
  }
  
  public static boolean saveBitmap(Bitmap paramBitmap, int paramInt, String paramString)
  {
    return saveBitmap(paramBitmap, Bitmap.CompressFormat.JPEG, paramInt, paramString, null);
  }
  
  /* Error */
  public static boolean saveBitmap(Bitmap paramBitmap, Bitmap.CompressFormat paramCompressFormat, int paramInt, String paramString, ExifInterface paramExifInterface)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 37	com/tencent/qcircle/tavcut/util/BitmapUtil:isValidBitmap	(Landroid/graphics/Bitmap;)Z
    //   4: istore 7
    //   6: iconst_0
    //   7: istore 5
    //   9: iload 7
    //   11: ifne +14 -> 25
    //   14: getstatic 134	com/tencent/qcircle/tavcut/util/BitmapUtil:TAG	Ljava/lang/String;
    //   17: ldc_w 289
    //   20: invokestatic 208	com/tencent/qcircle/tavcut/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   23: iconst_0
    //   24: ireturn
    //   25: aconst_null
    //   26: astore 10
    //   28: aconst_null
    //   29: astore 8
    //   31: iconst_1
    //   32: istore 7
    //   34: new 291	java/io/FileOutputStream
    //   37: dup
    //   38: new 106	java/io/File
    //   41: dup
    //   42: aload_3
    //   43: invokespecial 109	java/io/File:<init>	(Ljava/lang/String;)V
    //   46: invokespecial 294	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   49: astore 9
    //   51: aload_0
    //   52: aload_1
    //   53: iload_2
    //   54: aload 9
    //   56: invokevirtual 298	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   59: pop
    //   60: aload 9
    //   62: invokevirtual 301	java/io/FileOutputStream:flush	()V
    //   65: aload 9
    //   67: invokevirtual 302	java/io/FileOutputStream:close	()V
    //   70: goto +56 -> 126
    //   73: astore_0
    //   74: aload 9
    //   76: astore 8
    //   78: goto +170 -> 248
    //   81: astore_1
    //   82: aload 9
    //   84: astore_0
    //   85: goto +11 -> 96
    //   88: astore_0
    //   89: goto +159 -> 248
    //   92: astore_1
    //   93: aload 10
    //   95: astore_0
    //   96: aload_0
    //   97: astore 8
    //   99: aload_1
    //   100: invokestatic 90	com/tencent/qcircle/tavcut/util/Logger:e	(Ljava/lang/Throwable;)V
    //   103: aload_0
    //   104: ifnull +19 -> 123
    //   107: aload_0
    //   108: invokevirtual 301	java/io/FileOutputStream:flush	()V
    //   111: aload_0
    //   112: invokevirtual 302	java/io/FileOutputStream:close	()V
    //   115: goto +11 -> 126
    //   118: astore_0
    //   119: aload_0
    //   120: invokestatic 90	com/tencent/qcircle/tavcut/util/Logger:e	(Ljava/lang/Throwable;)V
    //   123: iconst_0
    //   124: istore 7
    //   126: aload 4
    //   128: ifnull +117 -> 245
    //   131: new 228	android/media/ExifInterface
    //   134: dup
    //   135: aload_3
    //   136: invokespecial 229	android/media/ExifInterface:<init>	(Ljava/lang/String;)V
    //   139: astore_0
    //   140: ldc 228
    //   142: invokevirtual 308	java/lang/Class:getFields	()[Ljava/lang/reflect/Field;
    //   145: astore_1
    //   146: aload_1
    //   147: arraylength
    //   148: istore 6
    //   150: iload 5
    //   152: istore_2
    //   153: iload_2
    //   154: iload 6
    //   156: if_icmpge +77 -> 233
    //   159: aload_1
    //   160: iload_2
    //   161: aaload
    //   162: astore_3
    //   163: aload_3
    //   164: invokevirtual 313	java/lang/reflect/Field:getName	()Ljava/lang/String;
    //   167: astore 8
    //   169: aload 8
    //   171: invokestatic 319	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   174: ifne +105 -> 279
    //   177: aload 8
    //   179: ldc_w 320
    //   182: invokevirtual 326	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   185: ifeq +94 -> 279
    //   188: aload_3
    //   189: ldc 228
    //   191: invokevirtual 330	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   194: invokevirtual 331	java/lang/Object:toString	()Ljava/lang/String;
    //   197: astore_3
    //   198: aload_3
    //   199: ldc 231
    //   201: invokevirtual 335	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   204: ifeq +6 -> 210
    //   207: goto +72 -> 279
    //   210: aload 4
    //   212: aload_3
    //   213: invokevirtual 339	android/media/ExifInterface:getAttribute	(Ljava/lang/String;)Ljava/lang/String;
    //   216: astore 8
    //   218: aload 8
    //   220: ifnull +59 -> 279
    //   223: aload_0
    //   224: aload_3
    //   225: aload 8
    //   227: invokevirtual 342	android/media/ExifInterface:setAttribute	(Ljava/lang/String;Ljava/lang/String;)V
    //   230: goto +49 -> 279
    //   233: aload_0
    //   234: invokevirtual 345	android/media/ExifInterface:saveAttributes	()V
    //   237: iload 7
    //   239: ireturn
    //   240: astore_0
    //   241: aload_0
    //   242: invokestatic 90	com/tencent/qcircle/tavcut/util/Logger:e	(Ljava/lang/Throwable;)V
    //   245: iload 7
    //   247: ireturn
    //   248: aload 8
    //   250: ifnull +21 -> 271
    //   253: aload 8
    //   255: invokevirtual 301	java/io/FileOutputStream:flush	()V
    //   258: aload 8
    //   260: invokevirtual 302	java/io/FileOutputStream:close	()V
    //   263: goto +8 -> 271
    //   266: astore_1
    //   267: aload_1
    //   268: invokestatic 90	com/tencent/qcircle/tavcut/util/Logger:e	(Ljava/lang/Throwable;)V
    //   271: goto +5 -> 276
    //   274: aload_0
    //   275: athrow
    //   276: goto -2 -> 274
    //   279: iload_2
    //   280: iconst_1
    //   281: iadd
    //   282: istore_2
    //   283: goto -130 -> 153
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	286	0	paramBitmap	Bitmap
    //   0	286	1	paramCompressFormat	Bitmap.CompressFormat
    //   0	286	2	paramInt	int
    //   0	286	3	paramString	String
    //   0	286	4	paramExifInterface	ExifInterface
    //   7	144	5	i	int
    //   148	9	6	j	int
    //   4	242	7	bool	boolean
    //   29	230	8	localObject1	Object
    //   49	34	9	localFileOutputStream	java.io.FileOutputStream
    //   26	68	10	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   51	60	73	finally
    //   51	60	81	java/io/IOException
    //   34	51	88	finally
    //   99	103	88	finally
    //   34	51	92	java/io/IOException
    //   60	70	118	java/io/IOException
    //   107	115	118	java/io/IOException
    //   131	150	240	java/lang/Exception
    //   163	207	240	java/lang/Exception
    //   210	218	240	java/lang/Exception
    //   223	230	240	java/lang/Exception
    //   233	237	240	java/lang/Exception
    //   253	263	266	java/io/IOException
  }
  
  public static Bitmap scaleBitmap(Bitmap paramBitmap, int paramInt)
  {
    try
    {
      if (!isValidBitmap(paramBitmap)) {
        return null;
      }
      int i = Math.max(paramBitmap.getWidth(), paramBitmap.getHeight());
      Object localObject = paramBitmap;
      if (i > paramInt)
      {
        float f = paramInt * 1.0F / i;
        localObject = new Matrix();
        ((Matrix)localObject).postScale(f, f);
        localObject = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), (Matrix)localObject, false);
      }
      return localObject;
    }
    catch (Error paramBitmap)
    {
      Logger.e(paramBitmap);
      return null;
    }
    catch (Exception paramBitmap)
    {
      Logger.e(paramBitmap);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.tavcut.util.BitmapUtil
 * JD-Core Version:    0.7.0.1
 */