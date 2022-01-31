package com.tencent.tavcut.util;

import android.graphics.Bitmap;
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
import java.io.IOException;

public class BitmapUtil
{
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
  
  public static boolean saveBitmap(Bitmap paramBitmap, int paramInt, String paramString)
  {
    return saveBitmap(paramBitmap, paramInt, paramString, null);
  }
  
  /* Error */
  public static boolean saveBitmap(Bitmap paramBitmap, int paramInt, String paramString, ExifInterface paramExifInterface)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 6
    //   3: iconst_0
    //   4: istore 4
    //   6: aload_0
    //   7: invokestatic 38	com/tencent/tavcut/util/BitmapUtil:isValidBitmap	(Landroid/graphics/Bitmap;)Z
    //   10: ifne +13 -> 23
    //   13: getstatic 16	com/tencent/tavcut/util/BitmapUtil:TAG	Ljava/lang/String;
    //   16: ldc 160
    //   18: invokestatic 163	com/tencent/tavcut/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: iconst_0
    //   22: ireturn
    //   23: aconst_null
    //   24: astore 8
    //   26: new 165	java/io/FileOutputStream
    //   29: dup
    //   30: new 167	java/io/File
    //   33: dup
    //   34: aload_2
    //   35: invokespecial 168	java/io/File:<init>	(Ljava/lang/String;)V
    //   38: invokespecial 171	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   41: astore 9
    //   43: aload 9
    //   45: astore 8
    //   47: aload_0
    //   48: getstatic 177	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   51: iload_1
    //   52: aload 9
    //   54: invokevirtual 181	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   57: pop
    //   58: aload 9
    //   60: ifnull +237 -> 297
    //   63: aload 9
    //   65: invokevirtual 184	java/io/FileOutputStream:flush	()V
    //   68: aload 9
    //   70: invokevirtual 187	java/io/FileOutputStream:close	()V
    //   73: aload_3
    //   74: ifnull +198 -> 272
    //   77: new 111	android/media/ExifInterface
    //   80: dup
    //   81: aload_2
    //   82: invokespecial 114	android/media/ExifInterface:<init>	(Ljava/lang/String;)V
    //   85: astore_0
    //   86: ldc 111
    //   88: invokevirtual 191	java/lang/Class:getFields	()[Ljava/lang/reflect/Field;
    //   91: astore_2
    //   92: aload_2
    //   93: arraylength
    //   94: istore 5
    //   96: iload 4
    //   98: istore_1
    //   99: iload_1
    //   100: iload 5
    //   102: if_icmpge +173 -> 275
    //   105: aload_2
    //   106: iload_1
    //   107: aaload
    //   108: astore 8
    //   110: aload 8
    //   112: invokevirtual 196	java/lang/reflect/Field:getName	()Ljava/lang/String;
    //   115: astore 9
    //   117: aload 9
    //   119: invokestatic 202	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   122: ifne +39 -> 161
    //   125: aload 9
    //   127: ldc 203
    //   129: invokevirtual 209	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   132: ifeq +29 -> 161
    //   135: aload 8
    //   137: ldc 111
    //   139: invokevirtual 213	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   142: invokevirtual 216	java/lang/Object:toString	()Ljava/lang/String;
    //   145: astore 8
    //   147: aload 8
    //   149: ldc 116
    //   151: invokevirtual 220	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   154: istore 7
    //   156: iload 7
    //   158: ifeq +85 -> 243
    //   161: iload_1
    //   162: iconst_1
    //   163: iadd
    //   164: istore_1
    //   165: goto -66 -> 99
    //   168: astore_0
    //   169: aload_0
    //   170: invokestatic 91	com/tencent/tavcut/util/Logger:e	(Ljava/lang/Throwable;)V
    //   173: iconst_0
    //   174: istore 6
    //   176: goto -103 -> 73
    //   179: astore 10
    //   181: aconst_null
    //   182: astore_0
    //   183: aload_0
    //   184: astore 8
    //   186: aload 10
    //   188: invokestatic 91	com/tencent/tavcut/util/Logger:e	(Ljava/lang/Throwable;)V
    //   191: aload_0
    //   192: ifnull +105 -> 297
    //   195: aload_0
    //   196: invokevirtual 184	java/io/FileOutputStream:flush	()V
    //   199: aload_0
    //   200: invokevirtual 187	java/io/FileOutputStream:close	()V
    //   203: goto -130 -> 73
    //   206: astore_0
    //   207: aload_0
    //   208: invokestatic 91	com/tencent/tavcut/util/Logger:e	(Ljava/lang/Throwable;)V
    //   211: iconst_0
    //   212: istore 6
    //   214: goto -141 -> 73
    //   217: astore_0
    //   218: aload 8
    //   220: astore_2
    //   221: aload_2
    //   222: ifnull +11 -> 233
    //   225: aload_2
    //   226: invokevirtual 184	java/io/FileOutputStream:flush	()V
    //   229: aload_2
    //   230: invokevirtual 187	java/io/FileOutputStream:close	()V
    //   233: aload_0
    //   234: athrow
    //   235: astore_2
    //   236: aload_2
    //   237: invokestatic 91	com/tencent/tavcut/util/Logger:e	(Ljava/lang/Throwable;)V
    //   240: goto -7 -> 233
    //   243: aload_3
    //   244: aload 8
    //   246: invokevirtual 224	android/media/ExifInterface:getAttribute	(Ljava/lang/String;)Ljava/lang/String;
    //   249: astore 9
    //   251: aload 9
    //   253: ifnull -92 -> 161
    //   256: aload_0
    //   257: aload 8
    //   259: aload 9
    //   261: invokevirtual 227	android/media/ExifInterface:setAttribute	(Ljava/lang/String;Ljava/lang/String;)V
    //   264: goto -103 -> 161
    //   267: astore_0
    //   268: aload_0
    //   269: invokestatic 91	com/tencent/tavcut/util/Logger:e	(Ljava/lang/Throwable;)V
    //   272: iload 6
    //   274: ireturn
    //   275: aload_0
    //   276: invokevirtual 230	android/media/ExifInterface:saveAttributes	()V
    //   279: goto -7 -> 272
    //   282: astore_0
    //   283: aload 8
    //   285: astore_2
    //   286: goto -65 -> 221
    //   289: astore 10
    //   291: aload 9
    //   293: astore_0
    //   294: goto -111 -> 183
    //   297: iconst_0
    //   298: istore 6
    //   300: goto -227 -> 73
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	303	0	paramBitmap	Bitmap
    //   0	303	1	paramInt	int
    //   0	303	2	paramString	String
    //   0	303	3	paramExifInterface	ExifInterface
    //   4	93	4	i	int
    //   94	9	5	j	int
    //   1	298	6	bool1	boolean
    //   154	3	7	bool2	boolean
    //   24	260	8	localObject1	Object
    //   41	251	9	localObject2	Object
    //   179	8	10	localIOException1	IOException
    //   289	1	10	localIOException2	IOException
    // Exception table:
    //   from	to	target	type
    //   63	73	168	java/io/IOException
    //   26	43	179	java/io/IOException
    //   195	203	206	java/io/IOException
    //   26	43	217	finally
    //   225	233	235	java/io/IOException
    //   77	96	267	java/lang/Exception
    //   110	156	267	java/lang/Exception
    //   243	251	267	java/lang/Exception
    //   256	264	267	java/lang/Exception
    //   275	279	267	java/lang/Exception
    //   47	58	282	finally
    //   186	191	282	finally
    //   47	58	289	java/io/IOException
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tavcut.util.BitmapUtil
 * JD-Core Version:    0.7.0.1
 */