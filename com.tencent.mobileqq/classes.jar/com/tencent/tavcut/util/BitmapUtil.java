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
    //   7: invokestatic 38	com/tencent/tavcut/util/BitmapUtil:isValidBitmap	(Landroid/graphics/Bitmap;)Z
    //   10: ifne +13 -> 23
    //   13: getstatic 16	com/tencent/tavcut/util/BitmapUtil:TAG	Ljava/lang/String;
    //   16: ldc 166
    //   18: invokestatic 169	com/tencent/tavcut/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: iconst_0
    //   22: ireturn
    //   23: aconst_null
    //   24: astore 9
    //   26: new 171	java/io/FileOutputStream
    //   29: dup
    //   30: new 173	java/io/File
    //   33: dup
    //   34: aload_3
    //   35: invokespecial 174	java/io/File:<init>	(Ljava/lang/String;)V
    //   38: invokespecial 177	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   41: astore 10
    //   43: aload 10
    //   45: astore 9
    //   47: aload_0
    //   48: aload_1
    //   49: iload_2
    //   50: aload 10
    //   52: invokevirtual 181	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   55: pop
    //   56: aload 10
    //   58: ifnull +229 -> 287
    //   61: aload 10
    //   63: invokevirtual 184	java/io/FileOutputStream:flush	()V
    //   66: aload 10
    //   68: invokevirtual 187	java/io/FileOutputStream:close	()V
    //   71: aload 4
    //   73: ifnull +190 -> 263
    //   76: new 111	android/media/ExifInterface
    //   79: dup
    //   80: aload_3
    //   81: invokespecial 114	android/media/ExifInterface:<init>	(Ljava/lang/String;)V
    //   84: astore_0
    //   85: ldc 111
    //   87: invokevirtual 191	java/lang/Class:getFields	()[Ljava/lang/reflect/Field;
    //   90: astore_1
    //   91: aload_1
    //   92: arraylength
    //   93: istore 6
    //   95: iload 5
    //   97: istore_2
    //   98: iload_2
    //   99: iload 6
    //   101: if_icmpge +165 -> 266
    //   104: aload_1
    //   105: iload_2
    //   106: aaload
    //   107: astore_3
    //   108: aload_3
    //   109: invokevirtual 196	java/lang/reflect/Field:getName	()Ljava/lang/String;
    //   112: astore 9
    //   114: aload 9
    //   116: invokestatic 202	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   119: ifne +36 -> 155
    //   122: aload 9
    //   124: ldc 203
    //   126: invokevirtual 209	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   129: ifeq +26 -> 155
    //   132: aload_3
    //   133: ldc 111
    //   135: invokevirtual 213	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   138: invokevirtual 216	java/lang/Object:toString	()Ljava/lang/String;
    //   141: astore_3
    //   142: aload_3
    //   143: ldc 116
    //   145: invokevirtual 220	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   148: istore 8
    //   150: iload 8
    //   152: ifeq +83 -> 235
    //   155: iload_2
    //   156: iconst_1
    //   157: iadd
    //   158: istore_2
    //   159: goto -61 -> 98
    //   162: astore_0
    //   163: aload_0
    //   164: invokestatic 91	com/tencent/tavcut/util/Logger:e	(Ljava/lang/Throwable;)V
    //   167: iconst_0
    //   168: istore 7
    //   170: goto -99 -> 71
    //   173: astore_1
    //   174: aconst_null
    //   175: astore_0
    //   176: aload_0
    //   177: astore 9
    //   179: aload_1
    //   180: invokestatic 91	com/tencent/tavcut/util/Logger:e	(Ljava/lang/Throwable;)V
    //   183: aload_0
    //   184: ifnull +103 -> 287
    //   187: aload_0
    //   188: invokevirtual 184	java/io/FileOutputStream:flush	()V
    //   191: aload_0
    //   192: invokevirtual 187	java/io/FileOutputStream:close	()V
    //   195: goto -124 -> 71
    //   198: astore_0
    //   199: aload_0
    //   200: invokestatic 91	com/tencent/tavcut/util/Logger:e	(Ljava/lang/Throwable;)V
    //   203: iconst_0
    //   204: istore 7
    //   206: goto -135 -> 71
    //   209: astore_0
    //   210: aload 9
    //   212: astore_1
    //   213: aload_1
    //   214: ifnull +11 -> 225
    //   217: aload_1
    //   218: invokevirtual 184	java/io/FileOutputStream:flush	()V
    //   221: aload_1
    //   222: invokevirtual 187	java/io/FileOutputStream:close	()V
    //   225: aload_0
    //   226: athrow
    //   227: astore_1
    //   228: aload_1
    //   229: invokestatic 91	com/tencent/tavcut/util/Logger:e	(Ljava/lang/Throwable;)V
    //   232: goto -7 -> 225
    //   235: aload 4
    //   237: aload_3
    //   238: invokevirtual 224	android/media/ExifInterface:getAttribute	(Ljava/lang/String;)Ljava/lang/String;
    //   241: astore 9
    //   243: aload 9
    //   245: ifnull -90 -> 155
    //   248: aload_0
    //   249: aload_3
    //   250: aload 9
    //   252: invokevirtual 227	android/media/ExifInterface:setAttribute	(Ljava/lang/String;Ljava/lang/String;)V
    //   255: goto -100 -> 155
    //   258: astore_0
    //   259: aload_0
    //   260: invokestatic 91	com/tencent/tavcut/util/Logger:e	(Ljava/lang/Throwable;)V
    //   263: iload 7
    //   265: ireturn
    //   266: aload_0
    //   267: invokevirtual 230	android/media/ExifInterface:saveAttributes	()V
    //   270: goto -7 -> 263
    //   273: astore_0
    //   274: aload 9
    //   276: astore_1
    //   277: goto -64 -> 213
    //   280: astore_1
    //   281: aload 10
    //   283: astore_0
    //   284: goto -108 -> 176
    //   287: iconst_0
    //   288: istore 7
    //   290: goto -219 -> 71
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	293	0	paramBitmap	Bitmap
    //   0	293	1	paramCompressFormat	Bitmap.CompressFormat
    //   0	293	2	paramInt	int
    //   0	293	3	paramString	String
    //   0	293	4	paramExifInterface	ExifInterface
    //   4	92	5	i	int
    //   93	9	6	j	int
    //   1	288	7	bool1	boolean
    //   148	3	8	bool2	boolean
    //   24	251	9	localObject	Object
    //   41	241	10	localFileOutputStream	java.io.FileOutputStream
    // Exception table:
    //   from	to	target	type
    //   61	71	162	java/io/IOException
    //   26	43	173	java/io/IOException
    //   187	195	198	java/io/IOException
    //   26	43	209	finally
    //   217	225	227	java/io/IOException
    //   76	95	258	java/lang/Exception
    //   108	150	258	java/lang/Exception
    //   235	243	258	java/lang/Exception
    //   248	255	258	java/lang/Exception
    //   266	270	258	java/lang/Exception
    //   47	56	273	finally
    //   179	183	273	finally
    //   47	56	280	java/io/IOException
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