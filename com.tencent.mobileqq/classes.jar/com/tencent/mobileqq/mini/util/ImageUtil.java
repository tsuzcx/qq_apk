package com.tencent.mobileqq.mini.util;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.media.ExifInterface;
import android.text.TextUtils;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.mobileqq.minigame.utils.PathUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ImageUtil
{
  public static final float BITMAP_QUALITY_COMPRESS_HEIGHT_BOUNDARY = 4000.0F;
  public static final float BITMAP_QUALITY_COMPRESS_WIDTH_BOUNDARY = 1440.0F;
  public static final int DEFAULT_FILE_BUFFER_SIZE = 8192;
  public static final int SIZE_1KB = 1024;
  public static final String TAG = "ImageUtil";
  
  public static int calculateInSampleSize(BitmapFactory.Options paramOptions, float paramFloat1, float paramFloat2)
  {
    int j = 1;
    int i = 1;
    if (paramOptions == null) {
      return 1;
    }
    int k = paramOptions.outHeight;
    int m = paramOptions.outWidth;
    if ((k > paramFloat2) || (m > paramFloat1))
    {
      float f1 = k / 2;
      float f2 = m / 2;
      for (;;)
      {
        float f3 = i;
        j = i;
        if (f1 / f3 < paramFloat2) {
          break;
        }
        j = i;
        if (f2 / f3 < paramFloat1) {
          break;
        }
        i *= 2;
      }
    }
    return j;
  }
  
  /* Error */
  public static Bitmap compressBitmap(Bitmap paramBitmap, Bitmap.CompressFormat paramCompressFormat)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +205 -> 206
    //   4: aload_1
    //   5: ifnull +201 -> 206
    //   8: getstatic 45	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   11: aload_1
    //   12: if_acmpne +5 -> 17
    //   15: aload_0
    //   16: areturn
    //   17: bipush 100
    //   19: istore_3
    //   20: ldc 9
    //   22: aload_0
    //   23: invokevirtual 51	android/graphics/Bitmap:getWidth	()I
    //   26: i2f
    //   27: fdiv
    //   28: ldc 7
    //   30: aload_0
    //   31: invokevirtual 54	android/graphics/Bitmap:getHeight	()I
    //   34: i2f
    //   35: fdiv
    //   36: invokestatic 60	java/lang/Math:min	(FF)F
    //   39: fstore_2
    //   40: fload_2
    //   41: fconst_1
    //   42: fcmpg
    //   43: ifge +10 -> 53
    //   46: bipush 100
    //   48: i2f
    //   49: fload_2
    //   50: fmul
    //   51: f2i
    //   52: istore_3
    //   53: aconst_null
    //   54: astore 6
    //   56: aconst_null
    //   57: astore 4
    //   59: new 62	java/io/ByteArrayOutputStream
    //   62: dup
    //   63: invokespecial 63	java/io/ByteArrayOutputStream:<init>	()V
    //   66: astore 5
    //   68: aload_0
    //   69: aload_1
    //   70: iload_3
    //   71: aload 5
    //   73: invokevirtual 67	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   76: pop
    //   77: aload 5
    //   79: invokevirtual 71	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   82: astore_1
    //   83: aload_1
    //   84: iconst_0
    //   85: aload_1
    //   86: arraylength
    //   87: invokestatic 77	android/graphics/BitmapFactory:decodeByteArray	([BII)Landroid/graphics/Bitmap;
    //   90: astore_1
    //   91: aload 5
    //   93: invokevirtual 80	java/io/ByteArrayOutputStream:close	()V
    //   96: aload_1
    //   97: areturn
    //   98: astore_0
    //   99: aload 5
    //   101: astore 4
    //   103: goto +91 -> 194
    //   106: astore 4
    //   108: aload 5
    //   110: astore_1
    //   111: aload 4
    //   113: astore 5
    //   115: goto +12 -> 127
    //   118: astore_0
    //   119: goto +75 -> 194
    //   122: astore 5
    //   124: aload 6
    //   126: astore_1
    //   127: aload_1
    //   128: astore 4
    //   130: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   133: ifeq +51 -> 184
    //   136: aload_1
    //   137: astore 4
    //   139: new 88	java/lang/StringBuilder
    //   142: dup
    //   143: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   146: astore 6
    //   148: aload_1
    //   149: astore 4
    //   151: aload 6
    //   153: ldc 91
    //   155: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: pop
    //   159: aload_1
    //   160: astore 4
    //   162: aload 6
    //   164: aload 5
    //   166: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   169: pop
    //   170: aload_1
    //   171: astore 4
    //   173: ldc 18
    //   175: iconst_2
    //   176: aload 6
    //   178: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   181: invokestatic 106	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   184: aload_1
    //   185: ifnull +7 -> 192
    //   188: aload_1
    //   189: invokevirtual 80	java/io/ByteArrayOutputStream:close	()V
    //   192: aload_0
    //   193: areturn
    //   194: aload 4
    //   196: ifnull +8 -> 204
    //   199: aload 4
    //   201: invokevirtual 80	java/io/ByteArrayOutputStream:close	()V
    //   204: aload_0
    //   205: athrow
    //   206: aload_0
    //   207: areturn
    //   208: astore_0
    //   209: aload_1
    //   210: areturn
    //   211: astore_1
    //   212: aload_0
    //   213: areturn
    //   214: astore_1
    //   215: goto -11 -> 204
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	218	0	paramBitmap	Bitmap
    //   0	218	1	paramCompressFormat	Bitmap.CompressFormat
    //   39	11	2	f	float
    //   19	52	3	i	int
    //   57	45	4	localObject1	Object
    //   106	6	4	localThrowable1	Throwable
    //   128	72	4	localCompressFormat	Bitmap.CompressFormat
    //   66	48	5	localObject2	Object
    //   122	43	5	localThrowable2	Throwable
    //   54	123	6	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   68	91	98	finally
    //   68	91	106	java/lang/Throwable
    //   59	68	118	finally
    //   130	136	118	finally
    //   139	148	118	finally
    //   151	159	118	finally
    //   162	170	118	finally
    //   173	184	118	finally
    //   59	68	122	java/lang/Throwable
    //   91	96	208	java/lang/Exception
    //   188	192	211	java/lang/Exception
    //   199	204	214	java/lang/Exception
  }
  
  public static byte[] compressImage(Bitmap paramBitmap, int paramInt)
  {
    return compressImage(paramBitmap, paramInt, true);
  }
  
  public static byte[] compressImage(Bitmap paramBitmap, int paramInt, boolean paramBoolean)
  {
    if ((paramBitmap != null) && (paramInt >= 1))
    {
      int i = 100;
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
      for (byte[] arrayOfByte = localByteArrayOutputStream.toByteArray(); (i > 70) && (arrayOfByte.length / 1024 > paramInt); arrayOfByte = localByteArrayOutputStream.toByteArray())
      {
        localByteArrayOutputStream.reset();
        paramBitmap.compress(Bitmap.CompressFormat.PNG, i, localByteArrayOutputStream);
        i -= 5;
      }
      if (paramBoolean) {
        paramBitmap.recycle();
      }
      return arrayOfByte;
    }
    return null;
  }
  
  public static Bitmap cutOutImg(Bitmap paramBitmap, float paramFloat1, float paramFloat2)
  {
    Bitmap localBitmap = null;
    if (paramBitmap != null) {}
    for (;;)
    {
      float f1;
      float f4;
      try
      {
        f1 = paramBitmap.getWidth();
        float f2 = paramBitmap.getHeight();
        float f3 = paramFloat1 / f1;
        f4 = paramFloat2 / f2;
        if (f3 > f4)
        {
          j = (int)paramFloat1;
          i = (int)(f3 * f2);
          Matrix localMatrix = new Matrix();
          f3 = j;
          localMatrix.postScale(f3 / f1, i / f2);
          localMatrix.postTranslate((paramFloat1 - f3) / 2.0F, 0.0F);
          localBitmap = Bitmap.createBitmap((int)paramFloat1, (int)paramFloat2, Bitmap.Config.ARGB_4444);
          new Canvas(localBitmap).drawBitmap(paramBitmap, localMatrix, null);
          return localBitmap;
        }
      }
      catch (Exception|OutOfMemoryError paramBitmap)
      {
        return null;
      }
      int j = (int)(f4 * f1);
      int i = (int)paramFloat2;
    }
  }
  
  public static Bitmap drawableToBitmap(Drawable paramDrawable)
  {
    Object localObject;
    if ((paramDrawable instanceof BitmapDrawable))
    {
      localObject = (BitmapDrawable)paramDrawable;
      if (((BitmapDrawable)localObject).getBitmap() != null) {
        return ((BitmapDrawable)localObject).getBitmap();
      }
    }
    if ((paramDrawable.getIntrinsicWidth() > 0) && (paramDrawable.getIntrinsicHeight() > 0)) {
      localObject = Bitmap.createBitmap(paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
    } else {
      localObject = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
    }
    Canvas localCanvas = new Canvas((Bitmap)localObject);
    paramDrawable.setBounds(0, 0, localCanvas.getWidth(), localCanvas.getHeight());
    paramDrawable.draw(localCanvas);
    return localObject;
  }
  
  public static Drawable getDrawable(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mFailedDrawable = new ColorDrawable(0);
      localURLDrawableOptions.mLoadingDrawable = new ColorDrawable(0);
      localURLDrawableOptions.mPlayGifImage = true;
      if (PathUtil.isNetworkUrl(paramString)) {
        return URLDrawable.getDrawable(paramString, localURLDrawableOptions);
      }
      return URLDrawable.getFileDrawable(MiniAppFileManager.getInstance().getAbsolutePath(paramString), localURLDrawableOptions);
    }
    return null;
  }
  
  public static int getExifOrientation(String paramString)
  {
    boolean bool = isPngFile(paramString);
    int j = 0;
    if (bool) {
      return 0;
    }
    Object localObject = null;
    try
    {
      paramString = new ExifInterface(paramString);
      int i = j;
      if (paramString != null)
      {
        int k = paramString.getAttributeInt("Orientation", -1);
        i = j;
        if (k != -1)
        {
          if (k != 3)
          {
            if (k != 6)
            {
              if (k != 8) {
                return 0;
              }
              return 270;
            }
            return 90;
          }
          i = 180;
        }
      }
      return i;
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        paramString = localObject;
      }
    }
  }
  
  /* Error */
  public static Bitmap getLocalBitmap(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 259	com/tencent/mobileqq/utils/StringUtil:isEmpty	(Ljava/lang/String;)Z
    //   4: istore_1
    //   5: aconst_null
    //   6: astore_3
    //   7: aconst_null
    //   8: astore 4
    //   10: iload_1
    //   11: ifeq +5 -> 16
    //   14: aconst_null
    //   15: areturn
    //   16: new 261	java/io/FileInputStream
    //   19: dup
    //   20: aload_0
    //   21: invokespecial 262	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   24: astore_0
    //   25: new 264	java/io/BufferedInputStream
    //   28: dup
    //   29: aload_0
    //   30: sipush 8192
    //   33: invokespecial 267	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   36: astore_2
    //   37: aload_2
    //   38: invokestatic 271	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   41: astore 5
    //   43: aload 5
    //   45: astore_3
    //   46: aload_0
    //   47: invokevirtual 272	java/io/FileInputStream:close	()V
    //   50: aload 5
    //   52: astore_3
    //   53: aload_2
    //   54: invokevirtual 273	java/io/BufferedInputStream:close	()V
    //   57: aload 5
    //   59: areturn
    //   60: astore_0
    //   61: aload_0
    //   62: invokevirtual 276	java/io/IOException:printStackTrace	()V
    //   65: aload_3
    //   66: areturn
    //   67: astore 4
    //   69: aload_2
    //   70: astore_3
    //   71: aload_0
    //   72: astore_2
    //   73: aload 4
    //   75: astore_0
    //   76: goto +26 -> 102
    //   79: astore 4
    //   81: aload_0
    //   82: astore_2
    //   83: aload 4
    //   85: astore_0
    //   86: goto +16 -> 102
    //   89: aconst_null
    //   90: astore_2
    //   91: goto +43 -> 134
    //   94: aconst_null
    //   95: astore_2
    //   96: goto +62 -> 158
    //   99: astore_0
    //   100: aconst_null
    //   101: astore_2
    //   102: aload_2
    //   103: ifnull +10 -> 113
    //   106: aload_2
    //   107: invokevirtual 272	java/io/FileInputStream:close	()V
    //   110: goto +3 -> 113
    //   113: aload_3
    //   114: ifnull +14 -> 128
    //   117: aload_3
    //   118: invokevirtual 273	java/io/BufferedInputStream:close	()V
    //   121: goto +7 -> 128
    //   124: aload_2
    //   125: invokevirtual 276	java/io/IOException:printStackTrace	()V
    //   128: aload_0
    //   129: athrow
    //   130: aconst_null
    //   131: astore_2
    //   132: aload_2
    //   133: astore_0
    //   134: aload_0
    //   135: ifnull +10 -> 145
    //   138: aload 4
    //   140: astore_3
    //   141: aload_0
    //   142: invokevirtual 272	java/io/FileInputStream:close	()V
    //   145: aload_2
    //   146: ifnull +34 -> 180
    //   149: aload 4
    //   151: astore_3
    //   152: aload_2
    //   153: invokevirtual 273	java/io/BufferedInputStream:close	()V
    //   156: aconst_null
    //   157: areturn
    //   158: aload_0
    //   159: ifnull +10 -> 169
    //   162: aload 4
    //   164: astore_3
    //   165: aload_0
    //   166: invokevirtual 272	java/io/FileInputStream:close	()V
    //   169: aload_2
    //   170: ifnull +10 -> 180
    //   173: aload 4
    //   175: astore_3
    //   176: aload_2
    //   177: invokevirtual 273	java/io/BufferedInputStream:close	()V
    //   180: aconst_null
    //   181: areturn
    //   182: astore_0
    //   183: goto +27 -> 210
    //   186: astore_0
    //   187: goto -57 -> 130
    //   190: astore_2
    //   191: goto -97 -> 94
    //   194: astore_2
    //   195: goto -106 -> 89
    //   198: astore_3
    //   199: goto -41 -> 158
    //   202: astore_3
    //   203: goto -69 -> 134
    //   206: astore_2
    //   207: goto -83 -> 124
    //   210: aconst_null
    //   211: astore_2
    //   212: aload_2
    //   213: astore_0
    //   214: goto -56 -> 158
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	217	0	paramString	String
    //   4	7	1	bool	boolean
    //   36	141	2	localObject1	Object
    //   190	1	2	localOutOfMemoryError1	OutOfMemoryError
    //   194	1	2	localFileNotFoundException1	FileNotFoundException
    //   206	1	2	localIOException	IOException
    //   211	2	2	localObject2	Object
    //   6	170	3	localObject3	Object
    //   198	1	3	localOutOfMemoryError2	OutOfMemoryError
    //   202	1	3	localFileNotFoundException2	FileNotFoundException
    //   8	1	4	localObject4	Object
    //   67	7	4	localObject5	Object
    //   79	95	4	localObject6	Object
    //   41	17	5	localBitmap	Bitmap
    // Exception table:
    //   from	to	target	type
    //   46	50	60	java/io/IOException
    //   53	57	60	java/io/IOException
    //   141	145	60	java/io/IOException
    //   152	156	60	java/io/IOException
    //   165	169	60	java/io/IOException
    //   176	180	60	java/io/IOException
    //   37	43	67	finally
    //   25	37	79	finally
    //   16	25	99	finally
    //   16	25	182	java/lang/OutOfMemoryError
    //   16	25	186	java/io/FileNotFoundException
    //   25	37	190	java/lang/OutOfMemoryError
    //   25	37	194	java/io/FileNotFoundException
    //   37	43	198	java/lang/OutOfMemoryError
    //   37	43	202	java/io/FileNotFoundException
    //   106	110	206	java/io/IOException
    //   117	121	206	java/io/IOException
  }
  
  public static Bitmap getLocalCompressedBitmap(String paramString, BitmapFactory.Options paramOptions)
  {
    if (!StringUtil.isEmpty(paramString))
    {
      if (paramOptions == null) {
        return null;
      }
      try
      {
        if (isPngFile(paramString)) {
          paramOptions.inPreferredConfig = Bitmap.Config.ARGB_4444;
        } else {
          paramOptions.inPreferredConfig = Bitmap.Config.RGB_565;
        }
        paramOptions = BitmapFactory.decodeFile(paramString, paramOptions);
        if (isJpgFile(paramString)) {
          return compressBitmap(paramOptions, Bitmap.CompressFormat.JPEG);
        }
        if (isWebpFile(paramString)) {
          return compressBitmap(paramOptions, Bitmap.CompressFormat.WEBP);
        }
        return paramOptions;
      }
      catch (Throwable paramString)
      {
        if (QLog.isColorLevel())
        {
          paramOptions = new StringBuilder();
          paramOptions.append("getLocalBitmap error! ");
          paramOptions.append(paramString);
          QLog.e("ImageUtil", 2, paramOptions.toString());
        }
      }
    }
    else
    {
      return null;
    }
    return paramString;
  }
  
  public static InputStream getLocalImageStream(String paramString, boolean paramBoolean)
  {
    Object localObject1 = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject1).inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject1);
    int k = getExifOrientation(paramString);
    int i = Math.max(((BitmapFactory.Options)localObject1).outWidth, ((BitmapFactory.Options)localObject1).outHeight);
    int j = 1;
    while (i > 4000)
    {
      j *= 2;
      i /= 2;
    }
    Object localObject2;
    if (j > 1)
    {
      QLog.w("ImageUtil", 2, "getLocalImageStream: start to crop image");
      ((BitmapFactory.Options)localObject1).inJustDecodeBounds = false;
      ((BitmapFactory.Options)localObject1).inSampleSize = j;
      localObject2 = BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject1);
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (k == 0) {}
      }
    }
    try
    {
      localObject1 = rotaingImageView(k, (Bitmap)localObject2);
    }
    catch (Exception localException)
    {
      label122:
      ByteArrayOutputStream localByteArrayOutputStream;
      break label122;
    }
    QLog.w("ImageUtil", 2, "getLocalImageStream: failed to rotate bitmap");
    localObject1 = localObject2;
    localByteArrayOutputStream = new ByteArrayOutputStream();
    if (paramBoolean) {
      localObject2 = Bitmap.CompressFormat.PNG;
    } else {
      localObject2 = Bitmap.CompressFormat.JPEG;
    }
    if (((Bitmap)localObject1).compress((Bitmap.CompressFormat)localObject2, 80, localByteArrayOutputStream))
    {
      paramString = localByteArrayOutputStream.toByteArray();
      ((Bitmap)localObject1).recycle();
      return new ByteArrayInputStream(paramString);
    }
    ((Bitmap)localObject1).recycle();
    QLog.w("ImageUtil", 2, "getLocalImageStream: failed to compress bitmap");
    if ((j == 1) && (k != 0)) {}
    try
    {
      localObject2 = rotaingImageView(k, BitmapFactory.decodeFile(paramString, null));
      localByteArrayOutputStream = new ByteArrayOutputStream();
      if (paramBoolean) {
        localObject1 = Bitmap.CompressFormat.PNG;
      } else {
        localObject1 = Bitmap.CompressFormat.JPEG;
      }
      if (((Bitmap)localObject2).compress((Bitmap.CompressFormat)localObject1, 100, localByteArrayOutputStream))
      {
        paramString = localByteArrayOutputStream.toByteArray();
        ((Bitmap)localObject2).recycle();
        return new ByteArrayInputStream(paramString);
      }
      ((Bitmap)localObject2).recycle();
      paramString = new BufferedInputStream(new FileInputStream(paramString));
      return paramString;
    }
    catch (FileNotFoundException paramString)
    {
      label314:
      break label314;
    }
    QLog.w("ImageUtil", 2, "getLocalImageStream: failed to read file");
    return null;
  }
  
  /* Error */
  public static ByteArrayInputStream getLocalNoBitmapImageStream(String paramString)
  {
    // Byte code:
    //   0: new 345	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 346	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: aload_0
    //   10: invokevirtual 349	java/io/File:exists	()Z
    //   13: ifne +5 -> 18
    //   16: aconst_null
    //   17: areturn
    //   18: new 261	java/io/FileInputStream
    //   21: dup
    //   22: aload_0
    //   23: invokespecial 352	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   26: astore_0
    //   27: new 264	java/io/BufferedInputStream
    //   30: dup
    //   31: aload_0
    //   32: sipush 8192
    //   35: invokespecial 267	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   38: astore 4
    //   40: new 62	java/io/ByteArrayOutputStream
    //   43: dup
    //   44: invokespecial 63	java/io/ByteArrayOutputStream:<init>	()V
    //   47: astore 6
    //   49: aload 4
    //   51: astore_2
    //   52: aload 6
    //   54: astore_3
    //   55: aload_0
    //   56: astore 5
    //   58: sipush 1024
    //   61: newarray byte
    //   63: astore 7
    //   65: aload 4
    //   67: astore_2
    //   68: aload 6
    //   70: astore_3
    //   71: aload_0
    //   72: astore 5
    //   74: aload 4
    //   76: aload 7
    //   78: invokevirtual 356	java/io/BufferedInputStream:read	([B)I
    //   81: istore_1
    //   82: iload_1
    //   83: iconst_m1
    //   84: if_icmpeq +24 -> 108
    //   87: aload 4
    //   89: astore_2
    //   90: aload 6
    //   92: astore_3
    //   93: aload_0
    //   94: astore 5
    //   96: aload 6
    //   98: aload 7
    //   100: iconst_0
    //   101: iload_1
    //   102: invokevirtual 360	java/io/ByteArrayOutputStream:write	([BII)V
    //   105: goto -40 -> 65
    //   108: aload 4
    //   110: astore_2
    //   111: aload 6
    //   113: astore_3
    //   114: aload_0
    //   115: astore 5
    //   117: new 331	java/io/ByteArrayInputStream
    //   120: dup
    //   121: aload 6
    //   123: invokevirtual 71	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   126: invokespecial 334	java/io/ByteArrayInputStream:<init>	([B)V
    //   129: astore 7
    //   131: aload 6
    //   133: invokevirtual 80	java/io/ByteArrayOutputStream:close	()V
    //   136: aload 4
    //   138: invokevirtual 273	java/io/BufferedInputStream:close	()V
    //   141: aload_0
    //   142: invokevirtual 272	java/io/FileInputStream:close	()V
    //   145: aload 7
    //   147: areturn
    //   148: astore_0
    //   149: aload_0
    //   150: invokevirtual 276	java/io/IOException:printStackTrace	()V
    //   153: aload 7
    //   155: areturn
    //   156: astore_2
    //   157: aload 4
    //   159: astore 7
    //   161: aload 6
    //   163: astore 4
    //   165: aload_2
    //   166: astore 6
    //   168: goto +102 -> 270
    //   171: astore_2
    //   172: aload 4
    //   174: astore 7
    //   176: aload 6
    //   178: astore 4
    //   180: aload_2
    //   181: astore 6
    //   183: goto +141 -> 324
    //   186: astore_3
    //   187: aconst_null
    //   188: astore 5
    //   190: aload 4
    //   192: astore_2
    //   193: aload 5
    //   195: astore 4
    //   197: goto +191 -> 388
    //   200: astore 6
    //   202: aconst_null
    //   203: astore_2
    //   204: aload 4
    //   206: astore 7
    //   208: aload_2
    //   209: astore 4
    //   211: goto +59 -> 270
    //   214: astore 6
    //   216: aconst_null
    //   217: astore_2
    //   218: aload 4
    //   220: astore 7
    //   222: aload_2
    //   223: astore 4
    //   225: goto +99 -> 324
    //   228: astore_3
    //   229: aconst_null
    //   230: astore 4
    //   232: aload 4
    //   234: astore_2
    //   235: goto +153 -> 388
    //   238: astore 6
    //   240: goto +24 -> 264
    //   243: astore 6
    //   245: goto +73 -> 318
    //   248: astore_3
    //   249: aconst_null
    //   250: astore_2
    //   251: aload_2
    //   252: astore 4
    //   254: aload 4
    //   256: astore_0
    //   257: goto +131 -> 388
    //   260: astore 6
    //   262: aconst_null
    //   263: astore_0
    //   264: aconst_null
    //   265: astore 7
    //   267: aconst_null
    //   268: astore 4
    //   270: aload 7
    //   272: astore_2
    //   273: aload 4
    //   275: astore_3
    //   276: aload_0
    //   277: astore 5
    //   279: aload 6
    //   281: invokevirtual 276	java/io/IOException:printStackTrace	()V
    //   284: aload 4
    //   286: ifnull +8 -> 294
    //   289: aload 4
    //   291: invokevirtual 80	java/io/ByteArrayOutputStream:close	()V
    //   294: aload 7
    //   296: ifnull +8 -> 304
    //   299: aload 7
    //   301: invokevirtual 273	java/io/BufferedInputStream:close	()V
    //   304: aload_0
    //   305: ifnull +70 -> 375
    //   308: aload_0
    //   309: invokevirtual 272	java/io/FileInputStream:close	()V
    //   312: aconst_null
    //   313: areturn
    //   314: astore 6
    //   316: aconst_null
    //   317: astore_0
    //   318: aconst_null
    //   319: astore 7
    //   321: aconst_null
    //   322: astore 4
    //   324: aload 7
    //   326: astore_2
    //   327: aload 4
    //   329: astore_3
    //   330: aload_0
    //   331: astore 5
    //   333: aload 6
    //   335: invokevirtual 361	java/io/FileNotFoundException:printStackTrace	()V
    //   338: aload 4
    //   340: ifnull +11 -> 351
    //   343: aload 4
    //   345: invokevirtual 80	java/io/ByteArrayOutputStream:close	()V
    //   348: goto +3 -> 351
    //   351: aload 7
    //   353: ifnull +8 -> 361
    //   356: aload 7
    //   358: invokevirtual 273	java/io/BufferedInputStream:close	()V
    //   361: aload_0
    //   362: ifnull +13 -> 375
    //   365: aload_0
    //   366: invokevirtual 272	java/io/FileInputStream:close	()V
    //   369: aconst_null
    //   370: areturn
    //   371: aload_0
    //   372: invokevirtual 276	java/io/IOException:printStackTrace	()V
    //   375: aconst_null
    //   376: areturn
    //   377: astore 6
    //   379: aload 5
    //   381: astore_0
    //   382: aload_3
    //   383: astore 4
    //   385: aload 6
    //   387: astore_3
    //   388: aload 4
    //   390: ifnull +11 -> 401
    //   393: aload 4
    //   395: invokevirtual 80	java/io/ByteArrayOutputStream:close	()V
    //   398: goto +3 -> 401
    //   401: aload_2
    //   402: ifnull +7 -> 409
    //   405: aload_2
    //   406: invokevirtual 273	java/io/BufferedInputStream:close	()V
    //   409: aload_0
    //   410: ifnull +14 -> 424
    //   413: aload_0
    //   414: invokevirtual 272	java/io/FileInputStream:close	()V
    //   417: goto +7 -> 424
    //   420: aload_0
    //   421: invokevirtual 276	java/io/IOException:printStackTrace	()V
    //   424: goto +5 -> 429
    //   427: aload_3
    //   428: athrow
    //   429: goto -2 -> 427
    //   432: astore_0
    //   433: goto -62 -> 371
    //   436: astore_0
    //   437: goto -17 -> 420
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	440	0	paramString	String
    //   81	21	1	i	int
    //   51	60	2	localObject1	Object
    //   156	10	2	localIOException1	IOException
    //   171	10	2	localFileNotFoundException1	FileNotFoundException
    //   192	214	2	localObject2	Object
    //   54	60	3	localObject3	Object
    //   186	1	3	localObject4	Object
    //   228	1	3	localObject5	Object
    //   248	1	3	localObject6	Object
    //   275	153	3	localObject7	Object
    //   38	356	4	localObject8	Object
    //   56	324	5	str	String
    //   47	135	6	localObject9	Object
    //   200	1	6	localIOException2	IOException
    //   214	1	6	localFileNotFoundException2	FileNotFoundException
    //   238	1	6	localIOException3	IOException
    //   243	1	6	localFileNotFoundException3	FileNotFoundException
    //   260	20	6	localIOException4	IOException
    //   314	20	6	localFileNotFoundException4	FileNotFoundException
    //   377	9	6	localObject10	Object
    //   63	294	7	localObject11	Object
    // Exception table:
    //   from	to	target	type
    //   131	145	148	java/io/IOException
    //   58	65	156	java/io/IOException
    //   74	82	156	java/io/IOException
    //   96	105	156	java/io/IOException
    //   117	131	156	java/io/IOException
    //   58	65	171	java/io/FileNotFoundException
    //   74	82	171	java/io/FileNotFoundException
    //   96	105	171	java/io/FileNotFoundException
    //   117	131	171	java/io/FileNotFoundException
    //   40	49	186	finally
    //   40	49	200	java/io/IOException
    //   40	49	214	java/io/FileNotFoundException
    //   27	40	228	finally
    //   27	40	238	java/io/IOException
    //   27	40	243	java/io/FileNotFoundException
    //   18	27	248	finally
    //   18	27	260	java/io/IOException
    //   18	27	314	java/io/FileNotFoundException
    //   58	65	377	finally
    //   74	82	377	finally
    //   96	105	377	finally
    //   117	131	377	finally
    //   279	284	377	finally
    //   333	338	377	finally
    //   289	294	432	java/io/IOException
    //   299	304	432	java/io/IOException
    //   308	312	432	java/io/IOException
    //   343	348	432	java/io/IOException
    //   356	361	432	java/io/IOException
    //   365	369	432	java/io/IOException
    //   393	398	436	java/io/IOException
    //   405	409	436	java/io/IOException
    //   413	417	436	java/io/IOException
  }
  
  public static String getType(BitmapFactory.Options paramOptions)
  {
    paramOptions = paramOptions.outMimeType;
    if (paramOptions == null) {
      return "unknown";
    }
    paramOptions = paramOptions.toLowerCase();
    if (paramOptions.indexOf("jpg") >= 0) {
      return "jpg";
    }
    if (paramOptions.indexOf("jpeg") >= 0) {
      return "jpeg";
    }
    if (paramOptions.indexOf("png") >= 0) {
      return "png";
    }
    if (paramOptions.indexOf("gif") >= 0) {
      return "gif";
    }
    if (paramOptions.indexOf("webp") >= 0) {
      return "webp";
    }
    return "unknown";
  }
  
  public static boolean isJpgFile(String paramString)
  {
    boolean bool2 = TextUtils.isEmpty(paramString);
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    if ((paramString.endsWith("jpg")) || (paramString.endsWith("jpeg")) || (paramString.endsWith("JPG")) || (paramString.endsWith("JPEG"))) {
      bool1 = true;
    }
    return bool1;
  }
  
  public static boolean isPngFile(String paramString)
  {
    boolean bool2 = TextUtils.isEmpty(paramString);
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    if ((paramString.endsWith("png")) || (paramString.endsWith("PNG"))) {
      bool1 = true;
    }
    return bool1;
  }
  
  public static boolean isWebpFile(String paramString)
  {
    boolean bool2 = TextUtils.isEmpty(paramString);
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    if ((paramString.endsWith("webp")) || (paramString.endsWith("WEBP"))) {
      bool1 = true;
    }
    return bool1;
  }
  
  public static Bitmap rotaingImageView(int paramInt, Bitmap paramBitmap)
  {
    Matrix localMatrix = new Matrix();
    localMatrix.postRotate(paramInt);
    return Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), localMatrix, true);
  }
  
  /* Error */
  public static void saveBitmapToFile(Bitmap paramBitmap, java.io.File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +178 -> 179
    //   4: aload_1
    //   5: ifnonnull +4 -> 9
    //   8: return
    //   9: new 345	java/io/File
    //   12: dup
    //   13: aload_1
    //   14: invokevirtual 406	java/io/File:getParent	()Ljava/lang/String;
    //   17: invokespecial 346	java/io/File:<init>	(Ljava/lang/String;)V
    //   20: astore_2
    //   21: aload_2
    //   22: invokevirtual 349	java/io/File:exists	()Z
    //   25: ifeq +10 -> 35
    //   28: aload_2
    //   29: invokevirtual 409	java/io/File:isDirectory	()Z
    //   32: ifne +8 -> 40
    //   35: aload_2
    //   36: invokevirtual 412	java/io/File:mkdirs	()Z
    //   39: pop
    //   40: aload_1
    //   41: invokevirtual 349	java/io/File:exists	()Z
    //   44: ifeq +10 -> 54
    //   47: aload_1
    //   48: invokevirtual 415	java/io/File:isFile	()Z
    //   51: ifne +8 -> 59
    //   54: aload_1
    //   55: invokevirtual 418	java/io/File:createNewFile	()Z
    //   58: pop
    //   59: aconst_null
    //   60: astore_3
    //   61: aconst_null
    //   62: astore_2
    //   63: new 420	java/io/BufferedOutputStream
    //   66: dup
    //   67: new 422	java/io/FileOutputStream
    //   70: dup
    //   71: aload_1
    //   72: invokespecial 423	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   75: invokespecial 426	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   78: astore_1
    //   79: aload_0
    //   80: getstatic 293	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   83: bipush 90
    //   85: aload_1
    //   86: invokevirtual 67	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   89: pop
    //   90: aload_1
    //   91: invokevirtual 429	java/io/BufferedOutputStream:flush	()V
    //   94: aload_1
    //   95: invokevirtual 430	java/io/BufferedOutputStream:close	()V
    //   98: return
    //   99: astore_0
    //   100: aload_1
    //   101: astore_2
    //   102: goto +67 -> 169
    //   105: astore_2
    //   106: aload_1
    //   107: astore_0
    //   108: aload_2
    //   109: astore_1
    //   110: goto +10 -> 120
    //   113: astore_0
    //   114: goto +55 -> 169
    //   117: astore_1
    //   118: aload_3
    //   119: astore_0
    //   120: aload_0
    //   121: astore_2
    //   122: new 88	java/lang/StringBuilder
    //   125: dup
    //   126: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   129: astore_3
    //   130: aload_0
    //   131: astore_2
    //   132: aload_3
    //   133: ldc_w 432
    //   136: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: pop
    //   140: aload_0
    //   141: astore_2
    //   142: aload_3
    //   143: aload_1
    //   144: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   147: pop
    //   148: aload_0
    //   149: astore_2
    //   150: ldc 18
    //   152: iconst_1
    //   153: aload_3
    //   154: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: invokestatic 106	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   160: aload_0
    //   161: ifnull +7 -> 168
    //   164: aload_0
    //   165: invokevirtual 430	java/io/BufferedOutputStream:close	()V
    //   168: return
    //   169: aload_2
    //   170: ifnull +7 -> 177
    //   173: aload_2
    //   174: invokevirtual 430	java/io/BufferedOutputStream:close	()V
    //   177: aload_0
    //   178: athrow
    //   179: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	180	0	paramBitmap	Bitmap
    //   0	180	1	paramFile	java.io.File
    //   20	82	2	localFile	java.io.File
    //   105	4	2	localIOException	IOException
    //   121	53	2	localBitmap	Bitmap
    //   60	94	3	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   79	94	99	finally
    //   79	94	105	java/io/IOException
    //   63	79	113	finally
    //   122	130	113	finally
    //   132	140	113	finally
    //   142	148	113	finally
    //   150	160	113	finally
    //   63	79	117	java/io/IOException
  }
  
  /* Error */
  public static boolean saveBitmapToFile(byte[] paramArrayOfByte, java.io.File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +191 -> 192
    //   4: aload_0
    //   5: arraylength
    //   6: iconst_1
    //   7: if_icmplt +185 -> 192
    //   10: aload_1
    //   11: ifnonnull +5 -> 16
    //   14: iconst_0
    //   15: ireturn
    //   16: aconst_null
    //   17: astore_3
    //   18: aconst_null
    //   19: astore 4
    //   21: aload 4
    //   23: astore_2
    //   24: new 345	java/io/File
    //   27: dup
    //   28: aload_1
    //   29: invokevirtual 406	java/io/File:getParent	()Ljava/lang/String;
    //   32: invokespecial 346	java/io/File:<init>	(Ljava/lang/String;)V
    //   35: astore 5
    //   37: aload 4
    //   39: astore_2
    //   40: aload 5
    //   42: invokevirtual 349	java/io/File:exists	()Z
    //   45: ifeq +14 -> 59
    //   48: aload 4
    //   50: astore_2
    //   51: aload 5
    //   53: invokevirtual 409	java/io/File:isDirectory	()Z
    //   56: ifne +12 -> 68
    //   59: aload 4
    //   61: astore_2
    //   62: aload 5
    //   64: invokevirtual 412	java/io/File:mkdirs	()Z
    //   67: pop
    //   68: aload 4
    //   70: astore_2
    //   71: aload_1
    //   72: invokevirtual 349	java/io/File:exists	()Z
    //   75: ifeq +13 -> 88
    //   78: aload 4
    //   80: astore_2
    //   81: aload_1
    //   82: invokevirtual 415	java/io/File:isFile	()Z
    //   85: ifne +11 -> 96
    //   88: aload 4
    //   90: astore_2
    //   91: aload_1
    //   92: invokevirtual 418	java/io/File:createNewFile	()Z
    //   95: pop
    //   96: aload 4
    //   98: astore_2
    //   99: new 422	java/io/FileOutputStream
    //   102: dup
    //   103: aload_1
    //   104: invokespecial 423	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   107: astore_1
    //   108: aload_1
    //   109: aload_0
    //   110: invokevirtual 435	java/io/FileOutputStream:write	([B)V
    //   113: aload_1
    //   114: invokevirtual 436	java/io/FileOutputStream:flush	()V
    //   117: aload_1
    //   118: invokevirtual 437	java/io/FileOutputStream:close	()V
    //   121: iconst_1
    //   122: ireturn
    //   123: astore_0
    //   124: aload_0
    //   125: invokevirtual 438	java/lang/Exception:printStackTrace	()V
    //   128: iconst_1
    //   129: ireturn
    //   130: astore_0
    //   131: aload_1
    //   132: astore_2
    //   133: goto +41 -> 174
    //   136: astore_2
    //   137: aload_1
    //   138: astore_0
    //   139: aload_2
    //   140: astore_1
    //   141: goto +10 -> 151
    //   144: astore_0
    //   145: goto +29 -> 174
    //   148: astore_1
    //   149: aload_3
    //   150: astore_0
    //   151: aload_0
    //   152: astore_2
    //   153: aload_1
    //   154: invokevirtual 276	java/io/IOException:printStackTrace	()V
    //   157: aload_0
    //   158: ifnull +14 -> 172
    //   161: aload_0
    //   162: invokevirtual 437	java/io/FileOutputStream:close	()V
    //   165: iconst_0
    //   166: ireturn
    //   167: astore_0
    //   168: aload_0
    //   169: invokevirtual 438	java/lang/Exception:printStackTrace	()V
    //   172: iconst_0
    //   173: ireturn
    //   174: aload_2
    //   175: ifnull +15 -> 190
    //   178: aload_2
    //   179: invokevirtual 437	java/io/FileOutputStream:close	()V
    //   182: goto +8 -> 190
    //   185: astore_1
    //   186: aload_1
    //   187: invokevirtual 438	java/lang/Exception:printStackTrace	()V
    //   190: aload_0
    //   191: athrow
    //   192: iconst_0
    //   193: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	194	0	paramArrayOfByte	byte[]
    //   0	194	1	paramFile	java.io.File
    //   23	110	2	localObject1	Object
    //   136	4	2	localIOException	IOException
    //   152	27	2	arrayOfByte	byte[]
    //   17	133	3	localObject2	Object
    //   19	78	4	localObject3	Object
    //   35	28	5	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   117	121	123	java/lang/Exception
    //   108	117	130	finally
    //   108	117	136	java/io/IOException
    //   24	37	144	finally
    //   40	48	144	finally
    //   51	59	144	finally
    //   62	68	144	finally
    //   71	78	144	finally
    //   81	88	144	finally
    //   91	96	144	finally
    //   99	108	144	finally
    //   153	157	144	finally
    //   24	37	148	java/io/IOException
    //   40	48	148	java/io/IOException
    //   51	59	148	java/io/IOException
    //   62	68	148	java/io/IOException
    //   71	78	148	java/io/IOException
    //   81	88	148	java/io/IOException
    //   91	96	148	java/io/IOException
    //   99	108	148	java/io/IOException
    //   161	165	167	java/lang/Exception
    //   178	182	185	java/lang/Exception
  }
  
  public static BitmapFactory.Options scaleBitmap(String paramString, int paramInt)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    int m = 1;
    localOptions.inJustDecodeBounds = true;
    SafeBitmapFactory.decodeFile(paramString, localOptions);
    int j = localOptions.outHeight;
    int k = localOptions.outWidth;
    int i = 1;
    while ((j > paramInt) && (k > paramInt))
    {
      float f1 = j;
      float f2 = paramInt;
      if (Math.min(Math.round(f1 / f2), Math.round(k / f2)) >= 2)
      {
        k /= 2;
        j /= 2;
        if ((k >= paramInt) && (j >= paramInt))
        {
          if ((k != paramInt) && (j != paramInt)) {
            i *= 2;
          } else {
            localOptions.inSampleSize = (i * 2);
          }
        }
        else {
          localOptions.inSampleSize = i;
        }
      }
      else
      {
        localOptions.inSampleSize = i;
      }
    }
    localOptions.inJustDecodeBounds = false;
    paramInt = m;
    if (localOptions.inSampleSize >= 1) {
      paramInt = localOptions.inSampleSize;
    }
    localOptions.inSampleSize = paramInt;
    return localOptions;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.util.ImageUtil
 * JD-Core Version:    0.7.0.1
 */