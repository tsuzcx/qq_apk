package com.tencent.ttpic.baseutils.bitmap;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import android.text.TextUtils;
import android.view.View;
import com.tencent.ttpic.AEBaseConfig;
import com.tencent.ttpic.baseutils.api.ApiHelper;
import com.tencent.ttpic.baseutils.encrypt.FileEncryptUtils;
import com.tencent.ttpic.baseutils.io.IOUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.baseutils.report.ReportUtil;
import com.tencent.ttpic.baseutils.url.UriUtils;
import com.tencent.ttpic.baseutils.zip.ZipUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.ByteBuffer;

@SuppressLint({"NewApi"})
public class BitmapUtils
{
  private static final String ASSETS_RAW_DIR = "raw";
  public static final int DEFAULT_COMPRESS_QUALITY = 90;
  private static final int DEFAULT_SIZE = 1000;
  private static final int DEFAULT_SIZE_SMALL = 500;
  public static boolean ENABLE_DEBUG = false;
  public static boolean ENABLE_PROFILE = false;
  private static final String[] IMAGE_PROJECTION = { "orientation" };
  private static final int INDEX_ORIENTATION = 0;
  public static final int JPEG_QUALITY = 99;
  private static final String[] PATH_PROJECTION = { "_data" };
  public static final String RES_PREFIX_ASSETS = "assets://";
  public static final String RES_PREFIX_HTTP = "http://";
  public static final String RES_PREFIX_HTTPS = "https://";
  public static final String RES_PREFIX_STORAGE = "/";
  private static final String TAG = BitmapUtils.class.getSimpleName();
  public static int currentShareIndex;
  private static final float[] mMatrixValues = new float[16];
  private static final float[] mTempMatrix = new float[32];
  
  static
  {
    ENABLE_DEBUG = false;
    ENABLE_PROFILE = true;
    currentShareIndex = -1;
  }
  
  public static Bitmap RGBA2Bitmap(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    localBitmap.copyPixelsFromBuffer(ByteBuffer.wrap(paramArrayOfByte));
    return localBitmap;
  }
  
  public static byte[] bitmap2RGBA(Bitmap paramBitmap)
  {
    if (!isLegal(paramBitmap)) {
      return null;
    }
    int i = paramBitmap.getByteCount();
    try
    {
      ByteBuffer localByteBuffer = ByteBuffer.allocate(i);
      paramBitmap.copyPixelsToBuffer(localByteBuffer);
      return localByteBuffer.array();
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      LogUtils.e(TAG, "bitmap2RGBA OOM! " + localOutOfMemoryError.getMessage());
      ReportUtil.report(String.format("OutOfMemoryError! copy. width = %d, height = %d", new Object[] { Integer.valueOf(paramBitmap.getWidth()), Integer.valueOf(paramBitmap.getHeight()) }));
    }
    return null;
  }
  
  public static boolean bitmapExists(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((!paramString.startsWith("assets://")) && (!new File(paramString).exists())) {
      return false;
    }
    return true;
  }
  
  public static byte[] bmpToByteArray(Bitmap paramBitmap, boolean paramBoolean)
  {
    if (!isLegal(paramBitmap)) {
      return null;
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.PNG, 80, localByteArrayOutputStream);
    if (paramBoolean) {
      paramBitmap.recycle();
    }
    paramBitmap = localByteArrayOutputStream.toByteArray();
    try
    {
      localByteArrayOutputStream.close();
      return paramBitmap;
    }
    catch (Exception localException)
    {
      LogUtils.e(localException);
    }
    return paramBitmap;
  }
  
  public static Bitmap bytesArray2Bimap(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length != 0) {
      return BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length);
    }
    return null;
  }
  
  private static BitmapUtils.Size calcNewSize(BitmapUtils.Size paramSize, int paramInt1, int paramInt2)
  {
    int j;
    if (paramSize.height / paramSize.width >= 1.0D) {
      j = paramSize.height;
    }
    for (int i = paramSize.width;; i = paramSize.height)
    {
      return getNewSize(i, j, paramInt1, paramInt2);
      j = paramSize.width;
    }
  }
  
  public static int calculateInSampleSize(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int m = paramOptions.outHeight;
    int n = paramOptions.outWidth;
    int j = 1;
    int i;
    float f1;
    float f2;
    if ((paramInt2 <= 0) || (m <= paramInt2))
    {
      i = j;
      if (paramInt1 > 0)
      {
        i = j;
        if (n <= paramInt1) {}
      }
    }
    else
    {
      i = Math.round(m / paramInt2);
      j = Math.round(n / paramInt1);
      if (paramBoolean)
      {
        if (i < j) {}
        for (;;)
        {
          f1 = n * m;
          f2 = paramInt1 * paramInt2 * 2;
          j = i;
          if (!ApiHelper.hasNougat()) {
            break label306;
          }
          j = i;
          while (f1 / (j * j) >= f2) {
            j += 1;
          }
          i = j;
        }
      }
      if (i < j) {
        i = j;
      }
      for (;;)
      {
        break;
      }
      i = j;
      if (paramBoolean) {
        if (n / j <= paramInt1 * 1.5D)
        {
          i = j;
          if (m / j <= paramInt2 * 1.5D) {}
        }
        else
        {
          i = n / paramInt1;
          j = m / paramInt2;
          if (i <= j) {
            break label299;
          }
        }
      }
    }
    for (;;)
    {
      LogUtils.d(TAG, "[calculateInSampleSize] source size = " + n + " * " + m + ", request size = " + paramInt1 + " * " + paramInt2 + ", inSampleSize = " + i + ", preferLarge = " + paramBoolean);
      return i;
      label299:
      i = j;
      continue;
      label306:
      while (f1 / (j * j) > f2) {
        j += 1;
      }
      if (!isPowerOf2(j))
      {
        i = j;
        for (;;)
        {
          k = i;
          if (i <= 2) {
            break;
          }
          k = i;
          if (isPowerOf2(i)) {
            break;
          }
          i -= 1;
        }
      }
      int k = j;
      i = j;
      if (paramBoolean) {
        if (n / k <= paramInt1 * 1.5D)
        {
          i = j;
          if (m / k <= paramInt2 * 1.5D) {}
        }
        else
        {
          i = k * 2;
        }
      }
    }
  }
  
  public static int calculateInSampleSizeNew(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i = paramOptions.outHeight;
    int j = paramOptions.outWidth;
    float f1 = Math.max(j, i);
    float f2 = Math.min(j, i);
    float f3 = Math.max(paramInt1, paramInt2);
    if ((Math.min(paramInt1, paramInt2) <= 0.0F) || (f1 <= f3)) {
      paramInt1 = 1;
    }
    do
    {
      do
      {
        return paramInt1;
        if (f1 / f2 <= 2.0F) {
          break;
        }
        f1 = i * j;
        f2 = paramInt1 * paramInt2;
        if (!ApiHelper.hasNougat()) {
          break label252;
        }
        paramInt2 = 1;
        while (f1 / (paramInt2 * paramInt2) >= f2) {
          paramInt2 += 1;
        }
        paramInt1 = paramInt2;
      } while (!paramBoolean);
      paramInt1 = paramInt2;
    } while (paramInt2 <= 1);
    return paramInt2 - 1;
    for (;;)
    {
      if (f1 / (paramInt2 * paramInt2) >= f2)
      {
        paramInt2 *= 2;
      }
      else
      {
        paramInt1 = paramInt2;
        if (!paramBoolean) {
          break;
        }
        paramInt1 = paramInt2;
        if (paramInt2 <= 1) {
          break;
        }
        return paramInt2 / 2;
        if (ApiHelper.hasNougat())
        {
          paramInt2 = 1;
          while (f1 / paramInt2 >= f3) {
            paramInt2 += 1;
          }
          paramInt1 = paramInt2;
          if (!paramBoolean) {
            break;
          }
          paramInt1 = paramInt2;
          if (paramInt2 <= 1) {
            break;
          }
          return paramInt2 - 1;
        }
        for (;;)
        {
          if (f1 / paramInt2 >= f3)
          {
            paramInt2 *= 2;
          }
          else
          {
            paramInt1 = paramInt2;
            if (!paramBoolean) {
              break;
            }
            paramInt1 = paramInt2;
            if (paramInt2 <= 1) {
              break;
            }
            return paramInt2 / 2;
            paramInt2 = 1;
          }
        }
        label252:
        paramInt2 = 1;
      }
    }
  }
  
  public static String compressImage(String paramString, BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    try
    {
      paramString = compressImageFile(paramString, getScaledOpt(paramOptions, paramInt1, paramInt2), new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separatorChar + "Pitu"));
      return paramString;
    }
    catch (Exception paramString)
    {
      LogUtils.e(paramString);
    }
    return null;
  }
  
  /* Error */
  private static String compressImageFile(String paramString, BitmapFactory.Options paramOptions, File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: getstatic 55	com/tencent/ttpic/baseutils/bitmap/BitmapUtils:TAG	Ljava/lang/String;
    //   6: ldc_w 326
    //   9: iconst_3
    //   10: anewarray 4	java/lang/Object
    //   13: dup
    //   14: iconst_0
    //   15: aload_0
    //   16: aastore
    //   17: dup
    //   18: iconst_1
    //   19: aload_1
    //   20: aastore
    //   21: dup
    //   22: iconst_2
    //   23: aload_2
    //   24: invokevirtual 309	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   27: aastore
    //   28: invokestatic 329	com/tencent/ttpic/baseutils/log/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   31: aload_2
    //   32: invokevirtual 190	java/io/File:exists	()Z
    //   35: ifne +8 -> 43
    //   38: aload_2
    //   39: invokevirtual 332	java/io/File:mkdirs	()Z
    //   42: pop
    //   43: new 128	java/lang/StringBuilder
    //   46: dup
    //   47: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   50: aload_2
    //   51: invokevirtual 309	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   54: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: getstatic 335	java/io/File:separator	Ljava/lang/String;
    //   60: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: ldc_w 337
    //   66: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: new 339	java/util/Date
    //   72: dup
    //   73: invokespecial 340	java/util/Date:<init>	()V
    //   76: invokevirtual 344	java/util/Date:getTime	()J
    //   79: invokevirtual 347	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   82: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   85: astore 5
    //   87: new 184	java/io/File
    //   90: dup
    //   91: aload 5
    //   93: invokespecial 186	java/io/File:<init>	(Ljava/lang/String;)V
    //   96: astore_2
    //   97: aload_2
    //   98: invokevirtual 190	java/io/File:exists	()Z
    //   101: ifne +8 -> 109
    //   104: aload_2
    //   105: invokevirtual 350	java/io/File:createNewFile	()Z
    //   108: pop
    //   109: new 352	java/io/FileOutputStream
    //   112: dup
    //   113: aload_2
    //   114: invokespecial 355	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   117: astore_3
    //   118: aload_3
    //   119: astore_2
    //   120: aload_1
    //   121: getfield 358	android/graphics/BitmapFactory$Options:outMimeType	Ljava/lang/String;
    //   124: invokestatic 361	com/tencent/ttpic/baseutils/bitmap/BitmapUtils:isSupportImgType	(Ljava/lang/String;)Z
    //   127: ifne +61 -> 188
    //   130: aload_3
    //   131: astore_2
    //   132: aload_1
    //   133: getstatic 364	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   136: putfield 367	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   139: aload_3
    //   140: astore_2
    //   141: aload_1
    //   142: iconst_1
    //   143: putfield 370	android/graphics/BitmapFactory$Options:inPurgeable	Z
    //   146: aload_3
    //   147: astore_2
    //   148: aload_1
    //   149: iconst_1
    //   150: putfield 373	android/graphics/BitmapFactory$Options:inInputShareable	Z
    //   153: aload_3
    //   154: astore_2
    //   155: aload_0
    //   156: aload_1
    //   157: invokestatic 377	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   160: astore 6
    //   162: aload 6
    //   164: astore_0
    //   165: aload_0
    //   166: ifnull +94 -> 260
    //   169: aload_3
    //   170: astore_2
    //   171: aload_0
    //   172: getstatic 380	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   175: bipush 90
    //   177: aload_3
    //   178: invokevirtual 207	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   181: pop
    //   182: aload_3
    //   183: astore_2
    //   184: aload_0
    //   185: invokevirtual 210	android/graphics/Bitmap:recycle	()V
    //   188: aload_3
    //   189: astore_2
    //   190: aload_3
    //   191: invokevirtual 383	java/io/OutputStream:close	()V
    //   194: aload_3
    //   195: ifnull +7 -> 202
    //   198: aload_3
    //   199: invokevirtual 383	java/io/OutputStream:close	()V
    //   202: aload 5
    //   204: astore_1
    //   205: aload_1
    //   206: areturn
    //   207: astore 6
    //   209: aload_3
    //   210: astore_2
    //   211: aload 6
    //   213: invokestatic 219	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   216: aload_3
    //   217: astore_2
    //   218: ldc_w 385
    //   221: iconst_3
    //   222: anewarray 4	java/lang/Object
    //   225: dup
    //   226: iconst_0
    //   227: aload_0
    //   228: aastore
    //   229: dup
    //   230: iconst_1
    //   231: aload_1
    //   232: getfield 250	android/graphics/BitmapFactory$Options:outWidth	I
    //   235: invokestatic 158	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   238: aastore
    //   239: dup
    //   240: iconst_2
    //   241: aload_1
    //   242: getfield 247	android/graphics/BitmapFactory$Options:outHeight	I
    //   245: invokestatic 158	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   248: aastore
    //   249: invokestatic 165	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   252: invokestatic 171	com/tencent/ttpic/baseutils/report/ReportUtil:report	(Ljava/lang/String;)V
    //   255: aconst_null
    //   256: astore_0
    //   257: goto -92 -> 165
    //   260: aload 4
    //   262: astore_1
    //   263: aload_3
    //   264: ifnull -59 -> 205
    //   267: aload_3
    //   268: invokevirtual 383	java/io/OutputStream:close	()V
    //   271: aconst_null
    //   272: areturn
    //   273: astore_0
    //   274: aconst_null
    //   275: areturn
    //   276: astore_1
    //   277: aconst_null
    //   278: astore_0
    //   279: aload_0
    //   280: astore_2
    //   281: aload_1
    //   282: invokestatic 219	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   285: aload 4
    //   287: astore_1
    //   288: aload_0
    //   289: ifnull -84 -> 205
    //   292: aload_0
    //   293: invokevirtual 383	java/io/OutputStream:close	()V
    //   296: aconst_null
    //   297: areturn
    //   298: astore_0
    //   299: aconst_null
    //   300: areturn
    //   301: astore_0
    //   302: aconst_null
    //   303: astore_2
    //   304: aload_2
    //   305: ifnull +7 -> 312
    //   308: aload_2
    //   309: invokevirtual 383	java/io/OutputStream:close	()V
    //   312: aload_0
    //   313: athrow
    //   314: astore_0
    //   315: goto -113 -> 202
    //   318: astore_1
    //   319: goto -7 -> 312
    //   322: astore_0
    //   323: goto -19 -> 304
    //   326: astore_1
    //   327: aload_3
    //   328: astore_0
    //   329: goto -50 -> 279
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	332	0	paramString	String
    //   0	332	1	paramOptions	BitmapFactory.Options
    //   0	332	2	paramFile	File
    //   117	211	3	localFileOutputStream	java.io.FileOutputStream
    //   1	285	4	localObject	Object
    //   85	118	5	str	String
    //   160	3	6	localBitmap	Bitmap
    //   207	5	6	localOutOfMemoryError	OutOfMemoryError
    // Exception table:
    //   from	to	target	type
    //   155	162	207	java/lang/OutOfMemoryError
    //   267	271	273	java/io/IOException
    //   97	109	276	java/lang/Exception
    //   109	118	276	java/lang/Exception
    //   292	296	298	java/io/IOException
    //   97	109	301	finally
    //   109	118	301	finally
    //   198	202	314	java/io/IOException
    //   308	312	318	java/io/IOException
    //   120	130	322	finally
    //   132	139	322	finally
    //   141	146	322	finally
    //   148	153	322	finally
    //   155	162	322	finally
    //   171	182	322	finally
    //   184	188	322	finally
    //   190	194	322	finally
    //   211	216	322	finally
    //   218	255	322	finally
    //   281	285	322	finally
    //   120	130	326	java/lang/Exception
    //   132	139	326	java/lang/Exception
    //   141	146	326	java/lang/Exception
    //   148	153	326	java/lang/Exception
    //   155	162	326	java/lang/Exception
    //   171	182	326	java/lang/Exception
    //   184	188	326	java/lang/Exception
    //   190	194	326	java/lang/Exception
    //   211	216	326	java/lang/Exception
    //   218	255	326	java/lang/Exception
  }
  
  public static Bitmap convertToSRGB(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return null;
    }
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), paramBitmap.getConfig());
      new Canvas(localBitmap).drawBitmap(paramBitmap, 0.0F, 0.0F, new Paint());
      paramBitmap.recycle();
      return localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      LogUtils.e(localOutOfMemoryError);
      ReportUtil.report(String.format("OutOfMemoryError! convertToSRGB. width = %d, height = %d", new Object[] { Integer.valueOf(paramBitmap.getWidth()), Integer.valueOf(paramBitmap.getHeight()) }));
    }
    return paramBitmap;
  }
  
  public static Bitmap copy(Bitmap paramBitmap, boolean paramBoolean)
  {
    Bitmap localBitmap = null;
    try
    {
      if (isLegal(paramBitmap)) {
        localBitmap = paramBitmap.copy(paramBitmap.getConfig(), paramBoolean);
      }
      return localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      LogUtils.e(TAG, "bitmap copy OOM!");
      ReportUtil.report(String.format("OutOfMemoryError! copy. width = %d, height = %d", new Object[] { Integer.valueOf(paramBitmap.getWidth()), Integer.valueOf(paramBitmap.getHeight()) }));
    }
    return null;
  }
  
  public static Bitmap correctImageToFitIn(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    Bitmap localBitmap = null;
    int i;
    int j;
    if (paramBitmap != null)
    {
      i = paramBitmap.getWidth();
      j = paramBitmap.getHeight();
      if ((i <= paramInt1) && (j <= paramInt2)) {
        localBitmap = Bitmap.createScaledBitmap(paramBitmap, i, j, true);
      }
    }
    else
    {
      return localBitmap;
    }
    if (paramInt2 * 1.0D / j > paramInt1 * 1.0D / i)
    {
      d = paramInt1 * 1.0D / i;
      return Bitmap.createScaledBitmap(paramBitmap, paramInt1, (int)(j * d), true);
    }
    double d = paramInt2 * 1.0D / j;
    return Bitmap.createScaledBitmap(paramBitmap, (int)(i * d), paramInt2, true);
  }
  
  public static Bitmap createBitmap(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Matrix paramMatrix)
  {
    Object localObject2 = null;
    if ((paramBitmap == null) || (paramBitmap.isRecycled())) {
      return null;
    }
    Canvas localCanvas = new Canvas();
    if ((paramMatrix == null) || (paramMatrix.isIdentity())) {}
    for (;;)
    {
      try
      {
        localObject1 = Bitmap.createBitmap(paramInt3, paramInt4, paramBitmap.getConfig());
        ((Bitmap)localObject1).setDensity(paramBitmap.getDensity());
        localCanvas.setBitmap((Bitmap)localObject1);
        localCanvas.drawBitmap(paramBitmap, new Rect(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4), new RectF(0.0F, 0.0F, paramInt3, paramInt4), (Paint)localObject2);
        return localObject1;
      }
      catch (OutOfMemoryError paramBitmap)
      {
        LogUtils.e(paramBitmap);
        return null;
      }
      catch (NullPointerException paramBitmap)
      {
        LogUtils.e(paramBitmap);
        return null;
      }
      Object localObject1 = new RectF(0.0F, 0.0F, paramInt3, paramInt4);
      paramMatrix.mapRect((RectF)localObject1);
      try
      {
        Bitmap localBitmap = Bitmap.createBitmap(Math.round(((RectF)localObject1).width()), Math.round(((RectF)localObject1).height()), paramBitmap.getConfig());
        localCanvas.translate(-((RectF)localObject1).left, -((RectF)localObject1).top);
        localCanvas.concat(paramMatrix);
        Paint localPaint = new Paint(2);
        localObject2 = localPaint;
        localObject1 = localBitmap;
        if (!paramMatrix.rectStaysRect())
        {
          localPaint.setAntiAlias(true);
          localObject2 = localPaint;
          localObject1 = localBitmap;
        }
      }
      catch (OutOfMemoryError paramBitmap)
      {
        LogUtils.e(paramBitmap);
      }
    }
    return null;
  }
  
  public static Bitmap cropCenter(Bitmap paramBitmap, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    long l = System.currentTimeMillis();
    int j = paramBitmap.getWidth();
    int k = paramBitmap.getHeight();
    int i = 0;
    try
    {
      localObject = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      i = 1;
    }
    catch (OutOfMemoryError localOutOfMemoryError1)
    {
      for (;;)
      {
        Object localObject;
        localBitmap1 = null;
      }
    }
    if (i == 0) {}
    for (;;)
    {
      try
      {
        Bitmap localBitmap2 = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.RGB_565);
        localObject = localBitmap2;
        i = 1;
      }
      catch (OutOfMemoryError localOutOfMemoryError2)
      {
        Bitmap localBitmap1;
        continue;
        Canvas localCanvas = new Canvas(localBitmap1);
        localCanvas.translate((paramInt1 - j) / 2, (paramInt2 - k) / 2);
        localCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, new Paint(2));
        if (!paramBoolean) {
          continue;
        }
        paramBitmap.recycle();
        LogUtils.d(TAG, "crop bitmap - " + (System.currentTimeMillis() - l));
        return localBitmap1;
      }
      if ((i == 0) || (localObject == null)) {
        return null;
      }
    }
  }
  
  public static Bitmap decodeBitmap(String paramString)
  {
    return decodeBitmap(paramString, false, null, -1, -1);
  }
  
  public static Bitmap decodeBitmap(String paramString, Bitmap.Config paramConfig)
  {
    return decodeBitmap(paramString, false, paramConfig, -1, -1);
  }
  
  public static Bitmap decodeBitmap(String paramString, boolean paramBoolean)
  {
    return decodeBitmap(paramString, paramBoolean, null, -1, -1);
  }
  
  public static Bitmap decodeBitmap(String paramString, boolean paramBoolean, Bitmap.Config paramConfig, int paramInt1, int paramInt2)
  {
    if (paramBoolean) {}
    Object localObject1;
    for (;;)
    {
      try
      {
        localObject2 = new FileInputStream(paramString);
        localObject1 = FileEncryptUtils.decryptFile((InputStream)localObject2);
      }
      catch (Exception localException1)
      {
        Object localObject2;
        localObject1 = null;
      }
      try
      {
        IOUtils.closeQuietly((InputStream)localObject2);
        if (localObject1 != null) {
          break;
        }
        LogUtils.w(TAG, "[" + paramString + "] decrypted buffer is null.");
        return null;
      }
      catch (Exception localException2)
      {
        Paint localPaint;
        break label79;
      }
      localObject2 = getInputStreamByName(paramString);
      continue;
      label79:
      LogUtils.e(TAG, localException1.getStackTrace().toString());
    }
    paramString = new BitmapFactory.Options();
    if (paramConfig != null) {
      paramString.inPreferredConfig = paramConfig;
    }
    try
    {
      for (;;)
      {
        paramString = BitmapFactory.decodeByteArray((byte[])localObject1, 0, localObject1.length, paramString);
        if (paramInt1 == -1) {
          break;
        }
        paramConfig = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
        localObject1 = new Canvas(paramConfig);
        localPaint = new Paint(6);
        ((Canvas)localObject1).drawBitmap(paramString, new Rect(0, 0, paramString.getWidth(), paramString.getHeight()), new Rect(0, 0, paramInt1, paramInt2), localPaint);
        paramString.recycle();
        return paramConfig;
        paramString.inPreferredConfig = Bitmap.Config.ARGB_8888;
      }
    }
    catch (OutOfMemoryError paramString)
    {
      for (;;)
      {
        paramString = null;
      }
    }
    return paramString;
  }
  
  public static Bitmap decodeBitmapFromFileExtForShare(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    LogUtils.d(TAG, "decodeBitmapFromFileExtForShare(%s, %d, %d, %d)", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (!new File(paramString).exists()) {
      return null;
    }
    int k = getDegreeByExif(paramString);
    Object localObject1 = null;
    if (paramInt1 < paramInt2) {}
    for (;;)
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      BitmapFactory.decodeFile(paramString, localOptions);
      int j;
      if (localOptions.outWidth > localOptions.outHeight)
      {
        i = localOptions.outWidth;
        if (localOptions.outWidth >= localOptions.outHeight) {
          break label192;
        }
        j = localOptions.outWidth;
        localOptions.inJustDecodeBounds = false;
        localOptions.inSampleSize = 1;
      }
      label192:
      Object localObject2;
      for (;;)
      {
        try
        {
          Bitmap localBitmap = BitmapFactory.decodeFile(paramString, localOptions);
          if (localBitmap != null)
          {
            if ((localBitmap == null) || (k == 0)) {
              break label332;
            }
            return rotateBitmap(localBitmap, k);
            i = localOptions.outHeight;
            break;
            j = localOptions.outHeight;
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          localOptions.inSampleSize *= 2;
          LogUtils.w(TAG, "[decodeBitmapFromFileExtForShare] " + localOutOfMemoryError.getMessage());
          ReportUtil.report(String.format("OutOfMemoryError! path = %s, width = %d, height = %d.", new Object[] { paramString, Integer.valueOf(localOptions.outWidth), Integer.valueOf(localOptions.outHeight) }));
          localObject2 = localObject1;
          continue;
          if ((i / localOptions.inSampleSize < paramInt2) && (j / localOptions.inSampleSize < paramInt1)) {
            continue;
          }
          localObject1 = localObject2;
        }
        if (localOptions.inSampleSize <= paramInt3) {}
      }
      label332:
      return localObject2;
      int i = paramInt1;
      paramInt1 = paramInt2;
      paramInt2 = i;
    }
  }
  
  public static Bitmap decodeBitmapFromFileForShare(String paramString, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    LogUtils.d(TAG, "decodeBitmapFromFileForShare(%s, %d, %d, %s)", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramArrayOfInt });
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return null;
      if (!new File(paramString).exists()) {
        continue;
      }
      int j = getDegreeByExif(paramString);
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      try
      {
        localOptions.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(paramString, localOptions);
        Object localObject = new BitmapUtils.Size(localOptions.outWidth, localOptions.outHeight);
        LogUtils.v(TAG, "decodeBitmapFromFileForShare(), outer width = " + localOptions.outWidth + ", height = " + localOptions.outHeight);
        if ((paramArrayOfInt != null) && (paramArrayOfInt.length == 2))
        {
          paramArrayOfInt[0] = localOptions.outWidth;
          paramArrayOfInt[1] = localOptions.outHeight;
        }
        boolean bool = shouldResize((BitmapUtils.Size)localObject, paramInt1, paramInt2);
        paramArrayOfInt = (int[])localObject;
        if (bool) {
          paramArrayOfInt = calcNewSize((BitmapUtils.Size)localObject, paramInt1, paramInt2);
        }
        localOptions.inJustDecodeBounds = false;
        if (bool) {}
        for (int i = calculateInSampleSizeNew(localOptions, paramArrayOfInt.width, paramArrayOfInt.height, true);; i = 1)
        {
          LogUtils.v(TAG, "decodeBitmapFromFileForShare(), inSampleSize = " + i);
          localOptions.inSampleSize = i;
          localObject = BitmapFactory.decodeFile(paramString, localOptions);
          paramArrayOfInt = (int[])localObject;
          if (j != 0) {
            paramArrayOfInt = rotateBitmap((Bitmap)localObject, j);
          }
          if (paramArrayOfInt == null) {
            break;
          }
          paramArrayOfInt = getFinalBitmap(paramArrayOfInt, paramInt1, paramInt2);
          return paramArrayOfInt;
        }
        return null;
      }
      catch (Exception paramString)
      {
        LogUtils.e(paramString);
        return null;
      }
      catch (OutOfMemoryError paramArrayOfInt)
      {
        LogUtils.e(paramArrayOfInt);
        ReportUtil.report(String.format("OutOfMemoryError! path = %s, width = %d, height = %d.", new Object[] { paramString, Integer.valueOf(localOptions.outWidth), Integer.valueOf(localOptions.outHeight) }));
      }
    }
  }
  
  public static Bitmap decodeSampleBitmap(Context paramContext, String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      if (paramString.startsWith("assets://")) {
        return decodeSampleBitmapFromAssets(paramContext, getRealPath(paramString), paramInt);
      }
    } while (!bitmapExists(paramString));
    return decodeSampledBitmapFromFile(paramString, paramInt);
  }
  
  public static Bitmap decodeSampleBitmap(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      if (paramString.startsWith("assets://")) {
        return decodeSampledBitmapFromAssets(paramContext, getRealPath(paramString), paramInt1, paramInt2);
      }
    } while (!bitmapExists(paramString));
    return decodeSampledBitmapFromFile(paramString, paramInt1, paramInt2);
  }
  
  /* Error */
  public static Bitmap decodeSampleBitmapFromAssets(Context paramContext, String paramString, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: aload 5
    //   8: astore_3
    //   9: aload_1
    //   10: invokestatic 179	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   13: ifne +10 -> 23
    //   16: aload_0
    //   17: ifnonnull +8 -> 25
    //   20: aload 5
    //   22: astore_3
    //   23: aload_3
    //   24: areturn
    //   25: aload_0
    //   26: invokevirtual 616	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   29: astore_0
    //   30: aload_0
    //   31: aload_1
    //   32: invokevirtual 621	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   35: astore 6
    //   37: new 244	android/graphics/BitmapFactory$Options
    //   40: dup
    //   41: invokespecial 533	android/graphics/BitmapFactory$Options:<init>	()V
    //   44: astore_3
    //   45: aload_3
    //   46: iconst_0
    //   47: putfield 550	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   50: aload_3
    //   51: iload_2
    //   52: putfield 553	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   55: aload 6
    //   57: aconst_null
    //   58: aload_3
    //   59: invokestatic 625	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   62: astore_0
    //   63: aload_0
    //   64: astore_3
    //   65: aload 6
    //   67: ifnull -44 -> 23
    //   70: aload 6
    //   72: invokevirtual 628	java/io/InputStream:close	()V
    //   75: aload_0
    //   76: areturn
    //   77: astore_1
    //   78: aload_0
    //   79: areturn
    //   80: astore_0
    //   81: getstatic 55	com/tencent/ttpic/baseutils/bitmap/BitmapUtils:TAG	Ljava/lang/String;
    //   84: aload_0
    //   85: invokevirtual 629	java/io/IOException:toString	()Ljava/lang/String;
    //   88: invokestatic 147	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   91: aconst_null
    //   92: areturn
    //   93: astore_0
    //   94: getstatic 55	com/tencent/ttpic/baseutils/bitmap/BitmapUtils:TAG	Ljava/lang/String;
    //   97: aload_0
    //   98: invokevirtual 630	java/lang/Exception:toString	()Ljava/lang/String;
    //   101: invokestatic 147	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   104: aload 5
    //   106: astore_3
    //   107: aload 6
    //   109: ifnull -86 -> 23
    //   112: aload 6
    //   114: invokevirtual 628	java/io/InputStream:close	()V
    //   117: aconst_null
    //   118: areturn
    //   119: astore_0
    //   120: aconst_null
    //   121: areturn
    //   122: astore_0
    //   123: aload_3
    //   124: aload_3
    //   125: getfield 553	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   128: iconst_1
    //   129: ishl
    //   130: putfield 553	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   133: aload 6
    //   135: invokevirtual 633	java/io/InputStream:reset	()V
    //   138: aload 6
    //   140: aconst_null
    //   141: aload_3
    //   142: invokestatic 625	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   145: astore_0
    //   146: aload_0
    //   147: astore_3
    //   148: aload 6
    //   150: ifnull -127 -> 23
    //   153: aload 6
    //   155: invokevirtual 628	java/io/InputStream:close	()V
    //   158: aload_0
    //   159: areturn
    //   160: astore_1
    //   161: aload_0
    //   162: areturn
    //   163: astore_0
    //   164: getstatic 55	com/tencent/ttpic/baseutils/bitmap/BitmapUtils:TAG	Ljava/lang/String;
    //   167: aload_0
    //   168: invokevirtual 636	java/lang/Throwable:toString	()Ljava/lang/String;
    //   171: invokestatic 147	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   174: ldc_w 561
    //   177: iconst_3
    //   178: anewarray 4	java/lang/Object
    //   181: dup
    //   182: iconst_0
    //   183: aload_1
    //   184: aastore
    //   185: dup
    //   186: iconst_1
    //   187: aload_3
    //   188: getfield 250	android/graphics/BitmapFactory$Options:outWidth	I
    //   191: invokestatic 158	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   194: aastore
    //   195: dup
    //   196: iconst_2
    //   197: aload_3
    //   198: getfield 247	android/graphics/BitmapFactory$Options:outHeight	I
    //   201: invokestatic 158	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   204: aastore
    //   205: invokestatic 165	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   208: invokestatic 171	com/tencent/ttpic/baseutils/report/ReportUtil:report	(Ljava/lang/String;)V
    //   211: aload 4
    //   213: astore_0
    //   214: goto -68 -> 146
    //   217: astore_0
    //   218: aload 6
    //   220: ifnull +8 -> 228
    //   223: aload 6
    //   225: invokevirtual 628	java/io/InputStream:close	()V
    //   228: aload_0
    //   229: athrow
    //   230: astore_1
    //   231: goto -3 -> 228
    //   234: astore_0
    //   235: goto -71 -> 164
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	238	0	paramContext	Context
    //   0	238	1	paramString	String
    //   0	238	2	paramInt	int
    //   8	190	3	localObject1	Object
    //   1	211	4	localObject2	Object
    //   4	101	5	localObject3	Object
    //   35	189	6	localInputStream	InputStream
    // Exception table:
    //   from	to	target	type
    //   70	75	77	java/io/IOException
    //   30	37	80	java/io/IOException
    //   55	63	93	java/lang/Exception
    //   112	117	119	java/io/IOException
    //   55	63	122	java/lang/OutOfMemoryError
    //   153	158	160	java/io/IOException
    //   133	146	163	java/lang/OutOfMemoryError
    //   55	63	217	finally
    //   94	104	217	finally
    //   123	133	217	finally
    //   133	146	217	finally
    //   164	211	217	finally
    //   223	228	230	java/io/IOException
    //   133	146	234	java/io/IOException
  }
  
  public static Bitmap decodeSampleBitmapFromOption(Context paramContext, String paramString, int paramInt1, int paramInt2, BitmapFactory.Options paramOptions)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      if (paramOptions == null) {
        return decodeSampleBitmap(paramContext, paramString, paramInt1, paramInt2);
      }
      if (paramString.startsWith("assets://")) {
        return decodeSampledBitmapFromAssets(paramContext, getRealPath(paramString), paramOptions);
      }
    } while (!bitmapExists(paramString));
    return decodeSampledBitmapFromFile(paramString, paramOptions);
  }
  
  public static Bitmap decodeSampledBitmapFromAssets(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramContext == null)) {
      return null;
    }
    paramContext = paramContext.getAssets();
    for (;;)
    {
      BitmapFactory.Options localOptions;
      InputStream localInputStream2;
      try
      {
        localInputStream1 = paramContext.open(paramString);
        localOptions = new BitmapFactory.Options();
        localOptions.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(localInputStream1, null, localOptions);
        localOptions.inSampleSize = calculateInSampleSizeNew(localOptions, paramInt1, paramInt2, true);
        localOptions.inJustDecodeBounds = false;
      }
      catch (IOException localIOException)
      {
        try
        {
          InputStream localInputStream1;
          localInputStream1.reset();
          paramContext = BitmapFactory.decodeStream(localInputStream1, null, localOptions);
          IOUtils.closeQuietly(localInputStream1);
          return paramContext;
          localIOException = localIOException;
          try
          {
            localInputStream2 = paramContext.open(paramString.substring(0, paramString.lastIndexOf('.') + 1) + "webp");
          }
          catch (IOException paramContext)
          {
            LogUtils.i(TAG, "", paramContext, new Object[0]);
            return null;
          }
        }
        catch (IOException paramContext)
        {
          LogUtils.e(TAG, paramContext);
          paramContext = null;
          continue;
        }
        catch (OutOfMemoryError paramContext)
        {
          localOptions.inSampleSize <<= 1;
        }
      }
      try
      {
        localInputStream2.reset();
        paramContext = BitmapFactory.decodeStream(localInputStream2, null, localOptions);
      }
      catch (OutOfMemoryError paramContext)
      {
        LogUtils.e(TAG, paramContext);
        ReportUtil.report(String.format("OutOfMemoryError! path = %s, width = %d, height = %d.", new Object[] { paramString, Integer.valueOf(localOptions.outWidth), Integer.valueOf(localOptions.outHeight) }));
        paramContext = null;
      }
      catch (IOException paramContext)
      {
        label193:
        break label193;
      }
    }
  }
  
  public static Bitmap decodeSampledBitmapFromAssets(Context paramContext, String paramString, BitmapFactory.Options paramOptions)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramContext == null)) {
      return null;
    }
    paramContext = paramContext.getAssets();
    for (;;)
    {
      InputStream localInputStream2;
      try
      {
        localInputStream1 = paramContext.open(paramString);
      }
      catch (IOException localIOException)
      {
        try
        {
          InputStream localInputStream1;
          localInputStream1.reset();
          paramContext = BitmapFactory.decodeStream(localInputStream1, null, paramOptions);
          IOUtils.closeQuietly(localInputStream1);
          return paramContext;
          localIOException = localIOException;
          try
          {
            localInputStream2 = paramContext.open(paramString.substring(0, paramString.lastIndexOf('.') + 1) + "webp");
          }
          catch (IOException paramContext)
          {
            LogUtils.i(TAG, "", paramContext, new Object[0]);
            return null;
          }
        }
        catch (IOException paramContext)
        {
          LogUtils.e(TAG, paramContext);
          paramContext = null;
          continue;
        }
        catch (OutOfMemoryError paramContext)
        {
          paramOptions.inSampleSize <<= 1;
        }
      }
      try
      {
        localInputStream2.reset();
        paramContext = BitmapFactory.decodeStream(localInputStream2, null, paramOptions);
      }
      catch (OutOfMemoryError paramContext)
      {
        LogUtils.e(TAG, paramContext);
        ReportUtil.report(String.format("OutOfMemoryError! path = %s, width = %d, height = %d.", new Object[] { paramString, Integer.valueOf(paramOptions.outWidth), Integer.valueOf(paramOptions.outHeight) }));
        paramContext = null;
      }
      catch (IOException paramContext)
      {
        label138:
        break label138;
      }
    }
  }
  
  public static Bitmap decodeSampledBitmapFromDescriptor(FileDescriptor paramFileDescriptor, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFileDescriptor(paramFileDescriptor, null, localOptions);
    localOptions.inSampleSize = calculateInSampleSizeNew(localOptions, paramInt1, paramInt2, true);
    localOptions.inJustDecodeBounds = false;
    try
    {
      Bitmap localBitmap1 = BitmapFactory.decodeFileDescriptor(paramFileDescriptor, null, localOptions);
      return localBitmap1;
    }
    catch (OutOfMemoryError localOutOfMemoryError1)
    {
      localOptions.inSampleSize <<= 1;
      try
      {
        Bitmap localBitmap2 = BitmapFactory.decodeFileDescriptor(paramFileDescriptor, null, localOptions);
        return localBitmap2;
      }
      catch (OutOfMemoryError localOutOfMemoryError2)
      {
        LogUtils.e(localOutOfMemoryError1);
        ReportUtil.report(String.format("OutOfMemoryError! fileDescriptor = %s, width = %d, height = %d.", new Object[] { paramFileDescriptor, Integer.valueOf(localOptions.outWidth), Integer.valueOf(localOptions.outHeight) }));
        return null;
      }
    }
    catch (Exception paramFileDescriptor) {}
    return null;
  }
  
  public static Bitmap decodeSampledBitmapFromFile(String paramString, int paramInt)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inSampleSize = paramInt;
    localOptions.inJustDecodeBounds = false;
    try
    {
      Bitmap localBitmap1 = BitmapFactory.decodeFile(paramString, localOptions);
      return localBitmap1;
    }
    catch (OutOfMemoryError localOutOfMemoryError1)
    {
      localOptions.inSampleSize <<= 1;
      try
      {
        Bitmap localBitmap2 = BitmapFactory.decodeFile(paramString, localOptions);
        return localBitmap2;
      }
      catch (OutOfMemoryError localOutOfMemoryError2)
      {
        LogUtils.e(TAG, localOutOfMemoryError2.toString());
        ReportUtil.report(String.format("OutOfMemoryError! path = %s, width = %d, height = %d.", new Object[] { paramString, Integer.valueOf(localOptions.outWidth), Integer.valueOf(localOptions.outHeight) }));
      }
    }
    return null;
  }
  
  public static Bitmap decodeSampledBitmapFromFile(String paramString, int paramInt1, int paramInt2)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions);
    localOptions.inSampleSize = calculateInSampleSizeNew(localOptions, paramInt1, paramInt2, true);
    localOptions.inJustDecodeBounds = false;
    if (ApiHelper.hasHoneycomb()) {}
    try
    {
      Bitmap localBitmap1 = BitmapFactory.decodeFile(paramString, localOptions);
      return localBitmap1;
    }
    catch (OutOfMemoryError localOutOfMemoryError1)
    {
      localOptions.inSampleSize <<= 1;
      try
      {
        Bitmap localBitmap2 = BitmapFactory.decodeFile(paramString, localOptions);
        return localBitmap2;
      }
      catch (OutOfMemoryError localOutOfMemoryError2)
      {
        LogUtils.e(localOutOfMemoryError2);
        ReportUtil.report(String.format("OutOfMemoryError! path = %s, width = %d, height = %d.", new Object[] { paramString, Integer.valueOf(localOptions.outWidth), Integer.valueOf(localOptions.outHeight) }));
      }
    }
    return null;
  }
  
  public static Bitmap decodeSampledBitmapFromFile(String paramString, BitmapFactory.Options paramOptions)
  {
    try
    {
      Bitmap localBitmap1 = BitmapFactory.decodeFile(paramString, paramOptions);
      return localBitmap1;
    }
    catch (OutOfMemoryError localOutOfMemoryError1)
    {
      paramOptions.inSampleSize <<= 1;
      try
      {
        Bitmap localBitmap2 = BitmapFactory.decodeFile(paramString, paramOptions);
        return localBitmap2;
      }
      catch (OutOfMemoryError localOutOfMemoryError2)
      {
        LogUtils.e(localOutOfMemoryError2);
        ReportUtil.report(String.format("OutOfMemoryError! path = %s, width = %d, height = %d.", new Object[] { paramString, Integer.valueOf(paramOptions.outWidth), Integer.valueOf(paramOptions.outHeight) }));
        return null;
      }
    }
    catch (Exception paramString)
    {
      LogUtils.e(paramString);
    }
    return null;
  }
  
  public static Bitmap decodeSampledBitmapFromFileCheckExif(String paramString, int paramInt1, int paramInt2)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions);
    localOptions.inSampleSize = calculateInSampleSizeNew(localOptions, paramInt1, paramInt2, true);
    localOptions.inJustDecodeBounds = false;
    paramInt1 = getDegreeByExif(paramString) % 360;
    Object localObject = null;
    try
    {
      Bitmap localBitmap1 = BitmapFactory.decodeFile(paramString, localOptions);
      localObject = localBitmap1;
      if (paramInt1 != 0)
      {
        localObject = localBitmap1;
        localBitmap1 = rotateBitmap(localBitmap1, paramInt1);
        localObject = localBitmap1;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError1)
    {
      for (;;)
      {
        localOptions.inSampleSize <<= 1;
        try
        {
          Bitmap localBitmap2 = BitmapFactory.decodeFile(paramString, localOptions);
          localObject = localBitmap2;
          if (paramInt1 == 0) {
            continue;
          }
          localObject = localBitmap2;
          localBitmap2 = rotateBitmap(localBitmap2, paramInt1);
          return localBitmap2;
        }
        catch (OutOfMemoryError localOutOfMemoryError2)
        {
          LogUtils.e(localOutOfMemoryError2);
          ReportUtil.report(String.format("OutOfMemoryError! path = %s, width = %d, height = %d.", new Object[] { paramString, Integer.valueOf(localOptions.outWidth), Integer.valueOf(localOptions.outHeight) }));
        }
      }
    }
    return localObject;
    return localObject;
  }
  
  public static Bitmap decodeSampledBitmapFromResource(Resources paramResources, int paramInt1, int paramInt2, int paramInt3)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeResource(paramResources, paramInt1, localOptions);
    localOptions.inSampleSize = calculateInSampleSizeNew(localOptions, paramInt2, paramInt3, true);
    localOptions.inJustDecodeBounds = false;
    try
    {
      Bitmap localBitmap1 = BitmapFactory.decodeResource(paramResources, paramInt1, localOptions);
      return localBitmap1;
    }
    catch (Exception paramResources)
    {
      LogUtils.e(paramResources);
      return null;
    }
    catch (OutOfMemoryError localOutOfMemoryError1)
    {
      LogUtils.e(localOutOfMemoryError1);
      try
      {
        localOptions.inSampleSize *= 2;
        Bitmap localBitmap2 = BitmapFactory.decodeResource(paramResources, paramInt1, localOptions);
        return localBitmap2;
      }
      catch (OutOfMemoryError localOutOfMemoryError2)
      {
        localOutOfMemoryError2.printStackTrace();
        ReportUtil.report(String.format("OutOfMemoryError! res = %s, width = %d, height = %d.", new Object[] { paramResources, Integer.valueOf(localOptions.outWidth), Integer.valueOf(localOptions.outHeight) }));
      }
    }
    return null;
  }
  
  /* Error */
  public static Bitmap decodeSampledBitmapFromUri(Context paramContext, Uri paramUri, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +252 -> 253
    //   4: aload_1
    //   5: invokevirtual 699	android/net/Uri:getScheme	()Ljava/lang/String;
    //   8: astore 4
    //   10: aload 4
    //   12: ifnull +152 -> 164
    //   15: aload_0
    //   16: invokevirtual 703	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   19: aload_1
    //   20: invokevirtual 709	android/content/ContentResolver:getType	(Landroid/net/Uri;)Ljava/lang/String;
    //   23: pop
    //   24: aload_0
    //   25: aload_1
    //   26: invokestatic 715	com/tencent/ttpic/baseutils/url/UriUtils:getFileProviderUriToPath	(Landroid/content/Context;Landroid/net/Uri;)Ljava/lang/String;
    //   29: astore_0
    //   30: getstatic 55	com/tencent/ttpic/baseutils/bitmap/BitmapUtils:TAG	Ljava/lang/String;
    //   33: new 128	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   40: ldc_w 717
    //   43: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: aload_0
    //   47: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: invokestatic 575	com/tencent/ttpic/baseutils/log/LogUtils:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   56: aload_0
    //   57: iload_2
    //   58: iload_3
    //   59: invokestatic 719	com/tencent/ttpic/baseutils/bitmap/BitmapUtils:decodeSampledBitmapFromFileCheckExif	(Ljava/lang/String;II)Landroid/graphics/Bitmap;
    //   62: astore_0
    //   63: aload_0
    //   64: ifnull +45 -> 109
    //   67: getstatic 55	com/tencent/ttpic/baseutils/bitmap/BitmapUtils:TAG	Ljava/lang/String;
    //   70: new 128	java/lang/StringBuilder
    //   73: dup
    //   74: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   77: ldc_w 721
    //   80: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: aload_0
    //   84: invokevirtual 152	android/graphics/Bitmap:getWidth	()I
    //   87: invokevirtual 268	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   90: ldc_w 572
    //   93: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: aload_0
    //   97: invokevirtual 161	android/graphics/Bitmap:getHeight	()I
    //   100: invokevirtual 268	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   103: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   106: invokestatic 575	com/tencent/ttpic/baseutils/log/LogUtils:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   109: aconst_null
    //   110: invokestatic 516	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   113: aconst_null
    //   114: invokestatic 516	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   117: aload_0
    //   118: areturn
    //   119: astore_0
    //   120: aload_1
    //   121: invokevirtual 722	android/net/Uri:toString	()Ljava/lang/String;
    //   124: invokestatic 725	android/net/Uri:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   127: astore_0
    //   128: getstatic 55	com/tencent/ttpic/baseutils/bitmap/BitmapUtils:TAG	Ljava/lang/String;
    //   131: new 128	java/lang/StringBuilder
    //   134: dup
    //   135: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   138: ldc_w 727
    //   141: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: aload_0
    //   145: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   151: invokestatic 575	com/tencent/ttpic/baseutils/log/LogUtils:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   154: aload_0
    //   155: iload_2
    //   156: iload_3
    //   157: invokestatic 719	com/tencent/ttpic/baseutils/bitmap/BitmapUtils:decodeSampledBitmapFromFileCheckExif	(Ljava/lang/String;II)Landroid/graphics/Bitmap;
    //   160: astore_0
    //   161: goto -98 -> 63
    //   164: aload_1
    //   165: ifnull +83 -> 248
    //   168: aload_1
    //   169: invokevirtual 722	android/net/Uri:toString	()Ljava/lang/String;
    //   172: invokestatic 725	android/net/Uri:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   175: astore_0
    //   176: getstatic 55	com/tencent/ttpic/baseutils/bitmap/BitmapUtils:TAG	Ljava/lang/String;
    //   179: new 128	java/lang/StringBuilder
    //   182: dup
    //   183: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   186: ldc_w 727
    //   189: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: aload_0
    //   193: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   199: invokestatic 575	com/tencent/ttpic/baseutils/log/LogUtils:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   202: aload_0
    //   203: iload_2
    //   204: iload_3
    //   205: invokestatic 719	com/tencent/ttpic/baseutils/bitmap/BitmapUtils:decodeSampledBitmapFromFileCheckExif	(Ljava/lang/String;II)Landroid/graphics/Bitmap;
    //   208: astore_0
    //   209: goto -146 -> 63
    //   212: astore_1
    //   213: aconst_null
    //   214: astore_0
    //   215: aload_1
    //   216: invokestatic 219	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   219: aconst_null
    //   220: invokestatic 516	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   223: aconst_null
    //   224: invokestatic 516	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   227: aload_0
    //   228: areturn
    //   229: astore_0
    //   230: aconst_null
    //   231: invokestatic 516	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   234: aconst_null
    //   235: invokestatic 516	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   238: aload_0
    //   239: athrow
    //   240: astore_1
    //   241: goto -26 -> 215
    //   244: astore_0
    //   245: goto -125 -> 120
    //   248: aconst_null
    //   249: astore_0
    //   250: goto -187 -> 63
    //   253: aconst_null
    //   254: astore 4
    //   256: goto -246 -> 10
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	259	0	paramContext	Context
    //   0	259	1	paramUri	Uri
    //   0	259	2	paramInt1	int
    //   0	259	3	paramInt2	int
    //   8	247	4	str	String
    // Exception table:
    //   from	to	target	type
    //   15	63	119	java/lang/IllegalArgumentException
    //   4	10	212	java/lang/Exception
    //   15	63	212	java/lang/Exception
    //   120	161	212	java/lang/Exception
    //   168	209	212	java/lang/Exception
    //   4	10	229	finally
    //   15	63	229	finally
    //   67	109	229	finally
    //   120	161	229	finally
    //   168	209	229	finally
    //   215	219	229	finally
    //   67	109	240	java/lang/Exception
    //   15	63	244	java/lang/SecurityException
  }
  
  public static void drawRepeatBitmap(Bitmap paramBitmap, Rect paramRect1, Rect paramRect2, Canvas paramCanvas, float paramFloat, Paint paramPaint)
  {
    int k = paramRect2.top;
    int m = paramRect2.bottom;
    int n = paramRect2.left;
    int i1 = paramRect2.right;
    int i2 = (int)(paramRect2.width() / paramFloat / paramRect1.width() + 1.0F);
    int i3 = (int)(paramRect2.height() / paramFloat / paramRect1.height() + 1.0F);
    paramCanvas.save();
    paramCanvas.clipRect(paramRect2);
    int i = 0;
    while (i < i3)
    {
      int j = 0;
      while (j < i2)
      {
        paramRect2.set((int)(n + paramRect1.width() * j * paramFloat), (int)(k + paramRect1.height() * i * paramFloat), (int)(n + paramRect1.width() * j * paramFloat + paramRect1.width() * paramFloat), (int)(k + paramRect1.height() * i * paramFloat + paramRect1.height() * paramFloat));
        paramCanvas.drawBitmap(paramBitmap, paramRect1, paramRect2, paramPaint);
        j += 1;
      }
      i += 1;
    }
    paramCanvas.restore();
    paramRect2.set(n, k, i1, m);
  }
  
  public static void fixBgRepeatY(View paramView)
  {
    paramView = paramView.getBackground();
    if ((paramView != null) && ((paramView instanceof BitmapDrawable)))
    {
      paramView = (BitmapDrawable)paramView;
      paramView.mutate();
      paramView.setTileModeY(Shader.TileMode.REPEAT);
    }
  }
  
  public static Bitmap flipBitmap(Bitmap paramBitmap, boolean paramBoolean)
  {
    Object localObject = paramBitmap;
    if (paramBitmap != null)
    {
      localObject = new Matrix();
      if (!paramBoolean) {
        break label58;
      }
      ((Matrix)localObject).setScale(1.0F, -1.0F);
    }
    for (;;)
    {
      try
      {
        Bitmap localBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), (Matrix)localObject, true);
        localObject = paramBitmap;
        if (paramBitmap != localBitmap)
        {
          paramBitmap.recycle();
          localObject = localBitmap;
        }
        return localObject;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        label58:
        LogUtils.e(TAG, "OutOfMemoryError. " + localOutOfMemoryError);
      }
      ((Matrix)localObject).setScale(-1.0F, 1.0F);
    }
    return paramBitmap;
  }
  
  /* Error */
  public static String getBase64FromBitmap(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +18 -> 19
    //   4: getstatic 55	com/tencent/ttpic/baseutils/bitmap/BitmapUtils:TAG	Ljava/lang/String;
    //   7: ldc_w 797
    //   10: invokestatic 282	com/tencent/ttpic/baseutils/log/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   13: ldc_w 657
    //   16: astore_0
    //   17: aload_0
    //   18: areturn
    //   19: ldc_w 657
    //   22: astore 4
    //   24: new 196	java/io/ByteArrayOutputStream
    //   27: dup
    //   28: invokespecial 197	java/io/ByteArrayOutputStream:<init>	()V
    //   31: astore_3
    //   32: aload_0
    //   33: getstatic 380	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   36: iload_2
    //   37: aload_3
    //   38: invokevirtual 207	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   41: pop
    //   42: aload_3
    //   43: invokevirtual 213	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   46: iload_1
    //   47: invokestatic 803	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   50: astore_0
    //   51: aload_0
    //   52: astore 4
    //   54: aload 4
    //   56: astore_0
    //   57: aload_3
    //   58: ifnull -41 -> 17
    //   61: aload_3
    //   62: invokevirtual 216	java/io/ByteArrayOutputStream:close	()V
    //   65: aload 4
    //   67: areturn
    //   68: astore_0
    //   69: aload_0
    //   70: invokestatic 219	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   73: aload 4
    //   75: areturn
    //   76: astore_0
    //   77: aconst_null
    //   78: astore_3
    //   79: aload 4
    //   81: astore_0
    //   82: aload_3
    //   83: ifnull -66 -> 17
    //   86: aload_3
    //   87: invokevirtual 216	java/io/ByteArrayOutputStream:close	()V
    //   90: ldc_w 657
    //   93: areturn
    //   94: astore_0
    //   95: aload_0
    //   96: invokestatic 219	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   99: ldc_w 657
    //   102: areturn
    //   103: astore_0
    //   104: aconst_null
    //   105: astore_3
    //   106: aload 4
    //   108: astore_0
    //   109: aload_3
    //   110: ifnull -93 -> 17
    //   113: aload_3
    //   114: invokevirtual 216	java/io/ByteArrayOutputStream:close	()V
    //   117: ldc_w 657
    //   120: areturn
    //   121: astore_0
    //   122: aload_0
    //   123: invokestatic 219	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   126: ldc_w 657
    //   129: areturn
    //   130: astore_0
    //   131: goto -25 -> 106
    //   134: astore_0
    //   135: goto -56 -> 79
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	138	0	paramBitmap	Bitmap
    //   0	138	1	paramInt1	int
    //   0	138	2	paramInt2	int
    //   31	83	3	localByteArrayOutputStream	ByteArrayOutputStream
    //   22	85	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   61	65	68	java/io/IOException
    //   24	32	76	java/lang/Exception
    //   86	90	94	java/io/IOException
    //   24	32	103	finally
    //   113	117	121	java/io/IOException
    //   32	51	130	finally
    //   32	51	134	java/lang/Exception
  }
  
  /* Error */
  public static Bitmap getBitmapFromEncryptedFile(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 179	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: aload_1
    //   10: ldc 31
    //   12: invokevirtual 182	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   15: ifeq +54 -> 69
    //   18: aload_0
    //   19: invokevirtual 616	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   22: aload_1
    //   23: invokestatic 808	com/tencent/ttpic/baseutils/io/FileUtils:getRealPath	(Ljava/lang/String;)Ljava/lang/String;
    //   26: invokevirtual 621	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   29: astore_1
    //   30: aload_1
    //   31: invokestatic 510	com/tencent/ttpic/baseutils/encrypt/FileEncryptUtils:decryptFile	(Ljava/io/InputStream;)[B
    //   34: astore_0
    //   35: aload_1
    //   36: invokestatic 516	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   39: aload_0
    //   40: ifnull -33 -> 7
    //   43: new 244	android/graphics/BitmapFactory$Options
    //   46: dup
    //   47: invokespecial 533	android/graphics/BitmapFactory$Options:<init>	()V
    //   50: astore_1
    //   51: aload_1
    //   52: getstatic 87	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   55: putfield 367	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   58: aload_0
    //   59: iconst_0
    //   60: aload_0
    //   61: arraylength
    //   62: aload_1
    //   63: invokestatic 536	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   66: astore_0
    //   67: aload_0
    //   68: areturn
    //   69: new 503	java/io/FileInputStream
    //   72: dup
    //   73: aload_1
    //   74: invokespecial 504	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   77: astore_1
    //   78: goto -48 -> 30
    //   81: astore_1
    //   82: aconst_null
    //   83: astore_0
    //   84: ldc_w 810
    //   87: ldc_w 812
    //   90: aload_1
    //   91: iconst_0
    //   92: anewarray 4	java/lang/Object
    //   95: invokestatic 814	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;[Ljava/lang/Object;)V
    //   98: goto -59 -> 39
    //   101: astore_0
    //   102: ldc_w 810
    //   105: ldc_w 815
    //   108: aload_0
    //   109: iconst_0
    //   110: anewarray 4	java/lang/Object
    //   113: invokestatic 814	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;[Ljava/lang/Object;)V
    //   116: aconst_null
    //   117: areturn
    //   118: astore_1
    //   119: goto -35 -> 84
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	122	0	paramContext	Context
    //   0	122	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   9	30	81	java/lang/Exception
    //   30	35	81	java/lang/Exception
    //   69	78	81	java/lang/Exception
    //   58	67	101	java/lang/OutOfMemoryError
    //   35	39	118	java/lang/Exception
  }
  
  public static Bitmap getBitmapFromURL(String paramString)
  {
    try
    {
      paramString = (HttpURLConnection)new URL(paramString).openConnection();
      paramString.setDoInput(true);
      paramString.connect();
      paramString = BitmapFactory.decodeStream(paramString.getInputStream());
      return paramString;
    }
    catch (IOException paramString) {}
    return null;
  }
  
  public static BitmapFactory.Options getBitmapOptionsFromAssets(Context paramContext, String paramString)
  {
    AssetManager localAssetManager = paramContext.getAssets();
    try
    {
      paramContext = localAssetManager.open(paramString);
      paramString = new BitmapFactory.Options();
      paramString.inJustDecodeBounds = true;
      BitmapFactory.decodeStream(paramContext, null, paramString);
      try
      {
        paramContext.reset();
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          LogUtils.e(TAG, localIOException);
          if (paramContext != null) {
            IOUtils.closeQuietly(paramContext);
          }
        }
      }
      finally
      {
        if (paramContext == null) {
          break label124;
        }
        IOUtils.closeQuietly(paramContext);
      }
      return paramString;
    }
    catch (IOException paramContext)
    {
      try
      {
        paramContext = localAssetManager.open(paramString.substring(0, paramString.lastIndexOf('.') + 1) + "webp");
      }
      catch (IOException paramContext)
      {
        LogUtils.e(TAG, paramContext);
        return null;
      }
    }
  }
  
  public static BitmapFactory.Options getBitmapOptionsFromFile(String paramString)
  {
    if (paramString == null) {}
    while (!new File(paramString).exists()) {
      return null;
    }
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions);
    return localOptions;
  }
  
  public static BitmapFactory.Options getBitmapOptionsFromResource(Resources paramResources, int paramInt)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeResource(paramResources, paramInt, localOptions);
    return localOptions;
  }
  
  public static BitmapFactory.Options getBitmapOptionsFromUri(Context paramContext, Uri paramUri)
  {
    Object localObject = null;
    if (paramUri != null) {}
    for (String str = paramUri.getScheme();; str = null)
    {
      if (str != null) {}
      try
      {
        paramContext.getContentResolver().getType(paramUri);
        paramContext = UriUtils.getFileProviderUriToPath(paramContext, paramUri);
        LogUtils.v(TAG, "[getBitmapOptionsFromUri] file = " + paramContext);
        paramContext = getBitmapOptionsFromFile(paramContext);
        return paramContext;
      }
      catch (IllegalArgumentException paramContext)
      {
        do
        {
          do
          {
            paramContext = localObject;
          } while (paramUri == null);
          paramContext = Uri.decode(paramUri.toString());
          LogUtils.v(TAG, "[getBitmapOptionsFromUri] in else , file = " + paramContext);
          return getBitmapOptionsFromFile(paramContext);
          paramContext = localObject;
        } while (paramUri == null);
        paramContext = Uri.decode(paramUri.toString());
        LogUtils.v(TAG, "[getBitmapOptionsFromUri] in else , file = " + paramContext);
        return getBitmapOptionsFromFile(paramContext);
      }
      catch (SecurityException paramContext)
      {
        label64:
        break label64;
      }
    }
  }
  
  public static Point getBitmapSize(Context paramContext, String paramString)
  {
    if (paramString.startsWith("assets://")) {
      return getBitmapSizeFromAssets(paramContext, getRealPath(paramString));
    }
    return getBitmapSizeFromFile(paramString);
  }
  
  private static Point getBitmapSizeFromAssets(Context paramContext, String paramString)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    Point localPoint = new Point(0, 0);
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return localPoint;
      AssetManager localAssetManager = paramContext.getAssets();
      paramContext = (Context)localObject2;
      try
      {
        paramString = localAssetManager.open(paramString);
        paramContext = paramString;
        localObject1 = paramString;
        localObject2 = new BitmapFactory.Options();
        paramContext = paramString;
        localObject1 = paramString;
        ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
        paramContext = paramString;
        localObject1 = paramString;
        BitmapFactory.decodeStream(paramString, null, (BitmapFactory.Options)localObject2);
        paramContext = paramString;
        localObject1 = paramString;
        localObject2 = new Point(((BitmapFactory.Options)localObject2).outWidth, ((BitmapFactory.Options)localObject2).outHeight);
        if (paramString != null) {}
        try
        {
          paramString.close();
          return localObject2;
        }
        catch (IOException paramContext)
        {
          for (;;)
          {
            paramContext.printStackTrace();
          }
        }
      }
      catch (IOException paramString)
      {
        localObject1 = paramContext;
        LogUtils.e(TAG, paramString.toString());
        if (paramContext != null) {
          try
          {
            paramContext.close();
            return localPoint;
          }
          catch (IOException paramContext)
          {
            paramContext.printStackTrace();
            return localPoint;
          }
        }
      }
      finally
      {
        if (localObject1 == null) {}
      }
    }
    try
    {
      ((InputStream)localObject1).close();
      throw paramContext;
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  private static Point getBitmapSizeFromFile(String paramString)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions);
    return new Point(localOptions.outWidth, localOptions.outHeight);
  }
  
  @SuppressLint({"NewApi"})
  public static int getBitmapSizeInBytes(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return 0;
    }
    if (Build.VERSION.SDK_INT > 19) {
      try
      {
        int i = paramBitmap.getAllocationByteCount();
        return i;
      }
      catch (NullPointerException localNullPointerException) {}
    }
    if (Build.VERSION.SDK_INT >= 12) {
      return paramBitmap.getByteCount();
    }
    return paramBitmap.getWidth() * paramBitmap.getRowBytes();
  }
  
  public static int getDegreeByExif(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return 0;
      try
      {
        paramString = new ExifInterface(paramString);
        if (paramString != null)
        {
          int i = getDegreeByOrientation(paramString.getAttributeInt("Orientation", 0));
          return i;
        }
      }
      catch (Exception paramString) {}
    }
    return 0;
  }
  
  public static int getDegreeByOrientation(int paramInt)
  {
    switch (paramInt)
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
  
  private static Bitmap getFinalBitmap(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    int i = Math.max(paramBitmap.getWidth(), paramBitmap.getHeight());
    int j = Math.min(paramBitmap.getWidth(), paramBitmap.getHeight());
    Bitmap localBitmap;
    if (i <= paramInt2)
    {
      localBitmap = paramBitmap;
      if (j <= paramInt1) {}
    }
    else
    {
      float f = Math.min(paramInt2 / i, paramInt1 / j);
      Matrix localMatrix = new Matrix();
      localMatrix.setScale(f, f);
      localBitmap = Bitmap.createBitmap((int)(paramBitmap.getWidth() * f), (int)(f * paramBitmap.getHeight()), Bitmap.Config.ARGB_8888);
      Paint localPaint = new Paint();
      localPaint.setAntiAlias(true);
      localPaint.setDither(true);
      localPaint.setFilterBitmap(true);
      new Canvas(localBitmap).drawBitmap(paramBitmap, localMatrix, localPaint);
      recycle(paramBitmap);
    }
    return localBitmap;
  }
  
  /* Error */
  public static Bitmap getImageFromPathWithDecode(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: aload_1
    //   7: invokestatic 179	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10: ifeq +5 -> 15
    //   13: aconst_null
    //   14: areturn
    //   15: iconst_0
    //   16: ifne +377 -> 393
    //   19: sipush 960
    //   22: istore_2
    //   23: aload_1
    //   24: ldc 40
    //   26: invokevirtual 182	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   29: istore_3
    //   30: iload_3
    //   31: ifeq +179 -> 210
    //   34: new 503	java/io/FileInputStream
    //   37: dup
    //   38: aload_1
    //   39: invokespecial 504	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   42: astore_0
    //   43: aload_0
    //   44: ifnull +229 -> 273
    //   47: aload_0
    //   48: astore_1
    //   49: aload_0
    //   50: invokestatic 510	com/tencent/ttpic/baseutils/encrypt/FileEncryptUtils:decryptFile	(Ljava/io/InputStream;)[B
    //   53: astore 4
    //   55: aload_0
    //   56: astore_1
    //   57: new 244	android/graphics/BitmapFactory$Options
    //   60: dup
    //   61: invokespecial 533	android/graphics/BitmapFactory$Options:<init>	()V
    //   64: astore 6
    //   66: aload_0
    //   67: astore_1
    //   68: aload 6
    //   70: getstatic 87	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   73: putfield 367	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   76: aload 6
    //   78: iconst_1
    //   79: putfield 550	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   82: aload 4
    //   84: iconst_0
    //   85: aload 4
    //   87: arraylength
    //   88: aload 6
    //   90: invokestatic 536	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   93: pop
    //   94: aload 6
    //   96: aload 6
    //   98: iload_2
    //   99: iload_2
    //   100: iconst_0
    //   101: invokestatic 583	com/tencent/ttpic/baseutils/bitmap/BitmapUtils:calculateInSampleSizeNew	(Landroid/graphics/BitmapFactory$Options;IIZ)I
    //   104: putfield 553	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   107: aload 6
    //   109: iconst_0
    //   110: putfield 550	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   113: aload 6
    //   115: iconst_1
    //   116: putfield 909	android/graphics/BitmapFactory$Options:inPreferQualityOverSpeed	Z
    //   119: aload 4
    //   121: iconst_0
    //   122: aload 4
    //   124: arraylength
    //   125: aload 6
    //   127: invokestatic 536	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   130: astore 5
    //   132: aload_0
    //   133: astore_1
    //   134: aload_0
    //   135: invokestatic 516	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   138: aload 5
    //   140: ifnonnull +177 -> 317
    //   143: aload_0
    //   144: invokestatic 516	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   147: aconst_null
    //   148: areturn
    //   149: astore_0
    //   150: new 503	java/io/FileInputStream
    //   153: dup
    //   154: new 128	java/lang/StringBuilder
    //   157: dup
    //   158: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   161: aload_1
    //   162: iconst_0
    //   163: aload_1
    //   164: bipush 46
    //   166: invokevirtual 649	java/lang/String:lastIndexOf	(I)I
    //   169: iconst_1
    //   170: iadd
    //   171: invokevirtual 653	java/lang/String:substring	(II)Ljava/lang/String;
    //   174: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: ldc_w 655
    //   180: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   186: invokespecial 504	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   189: astore_0
    //   190: goto -147 -> 43
    //   193: astore 4
    //   195: aconst_null
    //   196: astore_0
    //   197: aload_0
    //   198: astore_1
    //   199: aload 4
    //   201: invokestatic 219	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   204: aload_0
    //   205: invokestatic 516	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   208: aconst_null
    //   209: areturn
    //   210: aload_0
    //   211: invokevirtual 616	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   214: aload_1
    //   215: invokevirtual 621	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   218: astore 5
    //   220: aload 5
    //   222: astore_0
    //   223: goto -180 -> 43
    //   226: astore 5
    //   228: new 128	java/lang/StringBuilder
    //   231: dup
    //   232: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   235: aload_1
    //   236: iconst_0
    //   237: aload_1
    //   238: bipush 46
    //   240: invokevirtual 649	java/lang/String:lastIndexOf	(I)I
    //   243: iconst_1
    //   244: iadd
    //   245: invokevirtual 653	java/lang/String:substring	(II)Ljava/lang/String;
    //   248: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: ldc_w 655
    //   254: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   260: astore_1
    //   261: aload_0
    //   262: invokevirtual 616	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   265: aload_1
    //   266: invokevirtual 621	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   269: astore_0
    //   270: goto -227 -> 43
    //   273: aload_0
    //   274: invokestatic 516	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   277: aconst_null
    //   278: areturn
    //   279: astore_1
    //   280: iload_2
    //   281: i2f
    //   282: ldc_w 910
    //   285: fdiv
    //   286: f2i
    //   287: istore_2
    //   288: aload_0
    //   289: astore_1
    //   290: aload_0
    //   291: invokestatic 516	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   294: goto -218 -> 76
    //   297: astore 4
    //   299: aload_0
    //   300: astore_1
    //   301: aload_0
    //   302: invokestatic 516	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   305: aload_0
    //   306: astore_1
    //   307: aload 4
    //   309: athrow
    //   310: astore_0
    //   311: aload_1
    //   312: invokestatic 516	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   315: aload_0
    //   316: athrow
    //   317: aload_0
    //   318: astore_1
    //   319: aload 5
    //   321: invokevirtual 391	android/graphics/Bitmap:getConfig	()Landroid/graphics/Bitmap$Config;
    //   324: astore 4
    //   326: aload_0
    //   327: astore_1
    //   328: getstatic 87	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   331: astore 6
    //   333: aload 4
    //   335: aload 6
    //   337: if_acmpne +10 -> 347
    //   340: aload_0
    //   341: invokestatic 516	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   344: aload 5
    //   346: areturn
    //   347: aload_0
    //   348: astore_1
    //   349: aload 5
    //   351: getstatic 87	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   354: iconst_0
    //   355: invokevirtual 410	android/graphics/Bitmap:copy	(Landroid/graphics/Bitmap$Config;Z)Landroid/graphics/Bitmap;
    //   358: astore 4
    //   360: aload 4
    //   362: aload 5
    //   364: if_acmpeq +11 -> 375
    //   367: aload_0
    //   368: astore_1
    //   369: aload 5
    //   371: invokestatic 905	com/tencent/ttpic/baseutils/bitmap/BitmapUtils:recycle	(Landroid/graphics/Bitmap;)Z
    //   374: pop
    //   375: aload_0
    //   376: astore_1
    //   377: aload 4
    //   379: astore_0
    //   380: aload_1
    //   381: invokestatic 516	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   384: aload_0
    //   385: areturn
    //   386: astore_0
    //   387: aload 4
    //   389: astore_1
    //   390: goto -79 -> 311
    //   393: aconst_null
    //   394: astore_0
    //   395: aload 5
    //   397: astore_1
    //   398: goto -18 -> 380
    //   401: astore 4
    //   403: goto -206 -> 197
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	406	0	paramContext	Context
    //   0	406	1	paramString	String
    //   22	266	2	i	int
    //   29	2	3	bool	boolean
    //   4	119	4	arrayOfByte	byte[]
    //   193	7	4	localException1	Exception
    //   297	11	4	localObject1	Object
    //   324	64	4	localObject2	Object
    //   401	1	4	localException2	Exception
    //   1	220	5	localObject3	Object
    //   226	170	5	localIOException	IOException
    //   64	272	6	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   34	43	149	java/io/IOException
    //   23	30	193	java/lang/Exception
    //   34	43	193	java/lang/Exception
    //   150	190	193	java/lang/Exception
    //   210	220	193	java/lang/Exception
    //   228	270	193	java/lang/Exception
    //   210	220	226	java/io/IOException
    //   76	132	279	java/lang/OutOfMemoryError
    //   76	132	297	finally
    //   49	55	310	finally
    //   57	66	310	finally
    //   68	76	310	finally
    //   134	138	310	finally
    //   199	204	310	finally
    //   290	294	310	finally
    //   301	305	310	finally
    //   307	310	310	finally
    //   319	326	310	finally
    //   328	333	310	finally
    //   349	360	310	finally
    //   369	375	310	finally
    //   23	30	386	finally
    //   34	43	386	finally
    //   150	190	386	finally
    //   210	220	386	finally
    //   228	270	386	finally
    //   49	55	401	java/lang/Exception
    //   57	66	401	java/lang/Exception
    //   68	76	401	java/lang/Exception
    //   134	138	401	java/lang/Exception
    //   290	294	401	java/lang/Exception
    //   301	305	401	java/lang/Exception
    //   307	310	401	java/lang/Exception
    //   319	326	401	java/lang/Exception
    //   328	333	401	java/lang/Exception
    //   349	360	401	java/lang/Exception
    //   369	375	401	java/lang/Exception
  }
  
  public static int[] getImageSize(String paramString, int paramInt1, int paramInt2)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions);
    paramInt2 = calculateInSampleSizeNew(localOptions, paramInt1, paramInt2, true);
    paramInt1 = 1;
    while (Math.pow(2.0D, paramInt1) < paramInt2) {
      paramInt1 += 1;
    }
    paramInt2 = (int)Math.pow(2.0D, paramInt1 - 1);
    paramInt1 = localOptions.outWidth / paramInt2;
    int i = localOptions.outHeight / paramInt2;
    int k = getDegreeByExif(paramString);
    int j;
    if (k != 90)
    {
      j = i;
      paramInt2 = paramInt1;
      if (k != 270) {}
    }
    else
    {
      paramInt2 = i;
      j = paramInt1;
    }
    return new int[] { paramInt2, j };
  }
  
  public static InputStream getInputStreamByName(String paramString)
  {
    AssetManager localAssetManager = AEBaseConfig.getContext().getAssets();
    try
    {
      InputStream localInputStream = localAssetManager.open(paramString);
      return localInputStream;
    }
    catch (IOException localIOException) {}finally
    {
      try
      {
        paramString = localAssetManager.open("raw" + File.separator + paramString);
        return paramString;
      }
      catch (IOException paramString) {}
      paramString = finally;
    }
    return null;
  }
  
  private static BitmapUtils.Size getNewSize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    float f = Math.min(paramInt3 / paramInt1, paramInt4 / paramInt2);
    if (f < 1.0D) {}
    for (BitmapUtils.Size localSize = new BitmapUtils.Size((int)(paramInt1 * f), (int)(f * paramInt2));; localSize = new BitmapUtils.Size(paramInt1, paramInt2))
    {
      localSize.width = Math.max(localSize.width, 1);
      localSize.height = Math.max(localSize.height, 1);
      return localSize;
    }
  }
  
  public static String getRealPath(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (!paramString.startsWith("assets://")) {
      return paramString;
    }
    return paramString.substring("assets://".length());
  }
  
  private static BitmapFactory.Options getScaledOpt(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inSampleSize = calculateInSampleSizeNew(paramOptions, paramInt1, paramInt2, false);
    localOptions.inJustDecodeBounds = false;
    return localOptions;
  }
  
  public static boolean isLegal(Bitmap paramBitmap)
  {
    return (paramBitmap != null) && (!paramBitmap.isRecycled());
  }
  
  private static boolean isPowerOf2(int paramInt)
  {
    return (paramInt - 1 & paramInt) == 0;
  }
  
  private static boolean isSizeInRange(int paramInt)
  {
    return (paramInt >= 1000) && (paramInt <= 4000);
  }
  
  public static boolean isSizeLeagle(int paramInt1, int paramInt2)
  {
    return (isSizeInRange(paramInt1)) && (isSizeInRange(paramInt2));
  }
  
  private static boolean isSupportImgType(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString != null) {
      if ((!paramString.equalsIgnoreCase("image/jpeg")) && (!paramString.equalsIgnoreCase("image/png")))
      {
        bool1 = bool2;
        if (!paramString.equalsIgnoreCase("image/gif")) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean recycle(Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      paramBitmap.recycle();
      return true;
    }
    return false;
  }
  
  public static Bitmap resize4ShortSide(Bitmap paramBitmap, int paramInt)
  {
    Bitmap localBitmap;
    if (paramBitmap.getWidth() <= paramInt)
    {
      localBitmap = paramBitmap;
      if (paramBitmap.getHeight() <= paramInt) {}
    }
    else
    {
      if (paramBitmap.getWidth() <= paramBitmap.getHeight()) {
        break label127;
      }
      LogUtils.d(TAG, "resize4ShortSide: (" + paramBitmap.getWidth() + ", " + paramBitmap.getHeight() + ") => (" + paramBitmap.getWidth() * paramInt / paramBitmap.getHeight() + ", " + paramInt + ")");
      localBitmap = Bitmap.createScaledBitmap(paramBitmap, paramBitmap.getWidth() * paramInt / paramBitmap.getHeight(), paramInt, false);
    }
    return localBitmap;
    label127:
    LogUtils.d(TAG, "resize4ShortSide: (" + paramBitmap.getWidth() + ", " + paramBitmap.getHeight() + ") => (" + paramInt + ", " + paramBitmap.getHeight() * paramInt / paramBitmap.getWidth() + ")");
    return Bitmap.createScaledBitmap(paramBitmap, paramInt, paramBitmap.getHeight() * paramInt / paramBitmap.getWidth(), false);
  }
  
  public static Bitmap resizeBySidesRange(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    int j;
    if (paramBitmap.getHeight() / paramBitmap.getWidth() >= 1.0D) {
      j = paramBitmap.getHeight();
    }
    for (int i = paramBitmap.getWidth();; i = paramBitmap.getHeight())
    {
      Object localObject;
      if (i < paramInt1)
      {
        localObject = paramBitmap;
        if (j < paramInt2) {}
      }
      else
      {
        localObject = getNewSize(i, j, paramInt1, paramInt2);
        localObject = Bitmap.createScaledBitmap(paramBitmap, ((BitmapUtils.Size)localObject).width, ((BitmapUtils.Size)localObject).height, false);
      }
      return localObject;
      j = paramBitmap.getWidth();
    }
  }
  
  public static Bitmap rotateBitmap(Bitmap paramBitmap, int paramInt)
  {
    return rotateBitmap(paramBitmap, paramInt, true);
  }
  
  public static Bitmap rotateBitmap(Bitmap paramBitmap, int paramInt, boolean paramBoolean)
  {
    Object localObject = paramBitmap;
    if (paramBitmap != null)
    {
      localObject = new Matrix();
      ((Matrix)localObject).setRotate(paramInt, paramBitmap.getWidth() / 2.0F, paramBitmap.getHeight() / 2.0F);
    }
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), (Matrix)localObject, true);
      localObject = paramBitmap;
      if (paramBitmap != localBitmap)
      {
        if (paramBoolean) {
          paramBitmap.recycle();
        }
        localObject = localBitmap;
      }
      return localObject;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localOutOfMemoryError.printStackTrace();
    }
    return paramBitmap;
  }
  
  public static Bitmap roundRectBitmap(Bitmap paramBitmap, int paramInt)
  {
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    localPaint.setFilterBitmap(true);
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    RectF localRectF = new RectF(0.0F, 0.0F, i, j);
    Rect localRect = new Rect(0, 0, i, j);
    Canvas localCanvas = new Canvas(paramBitmap);
    localPaint.setXfermode(null);
    localCanvas.drawRoundRect(localRectF, paramInt, paramInt, localPaint);
    localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    localCanvas.drawBitmap(paramBitmap, localRect, localRectF, localPaint);
    return paramBitmap;
  }
  
  /* Error */
  public static BitmapUtils.SAVE_STATUS saveBitmap(Bitmap paramBitmap, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore_3
    //   5: aconst_null
    //   6: astore 4
    //   8: aload_3
    //   9: astore_2
    //   10: new 184	java/io/File
    //   13: dup
    //   14: aload_1
    //   15: invokespecial 186	java/io/File:<init>	(Ljava/lang/String;)V
    //   18: astore 6
    //   20: aload_3
    //   21: astore_2
    //   22: aload 6
    //   24: invokevirtual 986	java/io/File:getParentFile	()Ljava/io/File;
    //   27: astore 7
    //   29: aload_3
    //   30: astore_2
    //   31: aload 7
    //   33: invokevirtual 190	java/io/File:exists	()Z
    //   36: ifne +11 -> 47
    //   39: aload_3
    //   40: astore_2
    //   41: aload 7
    //   43: invokevirtual 332	java/io/File:mkdirs	()Z
    //   46: pop
    //   47: aload_3
    //   48: astore_2
    //   49: aload 6
    //   51: invokevirtual 190	java/io/File:exists	()Z
    //   54: ifne +11 -> 65
    //   57: aload_3
    //   58: astore_2
    //   59: aload 6
    //   61: invokevirtual 350	java/io/File:createNewFile	()Z
    //   64: pop
    //   65: aload_3
    //   66: astore_2
    //   67: new 352	java/io/FileOutputStream
    //   70: dup
    //   71: aload_1
    //   72: invokespecial 987	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   75: astore_3
    //   76: aload_0
    //   77: ifnull +18 -> 95
    //   80: aload_0
    //   81: getstatic 380	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   84: bipush 99
    //   86: aload_3
    //   87: invokevirtual 207	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   90: pop
    //   91: aload_3
    //   92: invokevirtual 990	java/io/FileOutputStream:flush	()V
    //   95: aload_3
    //   96: invokestatic 993	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   99: getstatic 999	com/tencent/ttpic/baseutils/bitmap/BitmapUtils$SAVE_STATUS:SAVE_SUCCESS	Lcom/tencent/ttpic/baseutils/bitmap/BitmapUtils$SAVE_STATUS;
    //   102: areturn
    //   103: astore_1
    //   104: aload 4
    //   106: astore_0
    //   107: aload_0
    //   108: astore_2
    //   109: aload_1
    //   110: invokestatic 219	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   113: aload_0
    //   114: astore_2
    //   115: getstatic 1002	com/tencent/ttpic/baseutils/bitmap/BitmapUtils$SAVE_STATUS:SAVE_FAILED	Lcom/tencent/ttpic/baseutils/bitmap/BitmapUtils$SAVE_STATUS;
    //   118: astore_1
    //   119: aload_0
    //   120: invokestatic 993	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   123: aload_1
    //   124: areturn
    //   125: astore 4
    //   127: aload 5
    //   129: astore_3
    //   130: aload_3
    //   131: astore_2
    //   132: aload 4
    //   134: invokestatic 219	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   137: aload_3
    //   138: astore_2
    //   139: ldc_w 1004
    //   142: iconst_3
    //   143: anewarray 4	java/lang/Object
    //   146: dup
    //   147: iconst_0
    //   148: aload_1
    //   149: aastore
    //   150: dup
    //   151: iconst_1
    //   152: aload_0
    //   153: invokevirtual 152	android/graphics/Bitmap:getWidth	()I
    //   156: invokestatic 158	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   159: aastore
    //   160: dup
    //   161: iconst_2
    //   162: aload_0
    //   163: invokevirtual 161	android/graphics/Bitmap:getHeight	()I
    //   166: invokestatic 158	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   169: aastore
    //   170: invokestatic 165	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   173: invokestatic 171	com/tencent/ttpic/baseutils/report/ReportUtil:report	(Ljava/lang/String;)V
    //   176: aload_3
    //   177: astore_2
    //   178: getstatic 1007	com/tencent/ttpic/baseutils/bitmap/BitmapUtils$SAVE_STATUS:SAVE_OOM	Lcom/tencent/ttpic/baseutils/bitmap/BitmapUtils$SAVE_STATUS;
    //   181: astore_0
    //   182: aload_3
    //   183: invokestatic 993	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   186: aload_0
    //   187: areturn
    //   188: astore_0
    //   189: aload_2
    //   190: invokestatic 993	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   193: aload_0
    //   194: athrow
    //   195: astore_0
    //   196: aload_3
    //   197: astore_2
    //   198: goto -9 -> 189
    //   201: astore 4
    //   203: goto -73 -> 130
    //   206: astore_1
    //   207: aload_3
    //   208: astore_0
    //   209: goto -102 -> 107
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	212	0	paramBitmap	Bitmap
    //   0	212	1	paramString	String
    //   9	189	2	localObject1	Object
    //   4	204	3	localObject2	Object
    //   6	99	4	localObject3	Object
    //   125	8	4	localOutOfMemoryError1	OutOfMemoryError
    //   201	1	4	localOutOfMemoryError2	OutOfMemoryError
    //   1	127	5	localObject4	Object
    //   18	42	6	localFile1	File
    //   27	15	7	localFile2	File
    // Exception table:
    //   from	to	target	type
    //   10	20	103	java/lang/Exception
    //   22	29	103	java/lang/Exception
    //   31	39	103	java/lang/Exception
    //   41	47	103	java/lang/Exception
    //   49	57	103	java/lang/Exception
    //   59	65	103	java/lang/Exception
    //   67	76	103	java/lang/Exception
    //   10	20	125	java/lang/OutOfMemoryError
    //   22	29	125	java/lang/OutOfMemoryError
    //   31	39	125	java/lang/OutOfMemoryError
    //   41	47	125	java/lang/OutOfMemoryError
    //   49	57	125	java/lang/OutOfMemoryError
    //   59	65	125	java/lang/OutOfMemoryError
    //   67	76	125	java/lang/OutOfMemoryError
    //   10	20	188	finally
    //   22	29	188	finally
    //   31	39	188	finally
    //   41	47	188	finally
    //   49	57	188	finally
    //   59	65	188	finally
    //   67	76	188	finally
    //   109	113	188	finally
    //   115	119	188	finally
    //   132	137	188	finally
    //   139	176	188	finally
    //   178	182	188	finally
    //   80	95	195	finally
    //   80	95	201	java/lang/OutOfMemoryError
    //   80	95	206	java/lang/Exception
  }
  
  /* Error */
  public static File saveBitmap(Context paramContext, Bitmap paramBitmap, String paramString1, String paramString2, Bitmap.CompressFormat paramCompressFormat, String paramString3)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 9
    //   3: aload_2
    //   4: ifnonnull +122 -> 126
    //   7: aload_2
    //   8: astore 8
    //   10: aload_0
    //   11: ifnull +21 -> 32
    //   14: aload_0
    //   15: invokevirtual 1011	android/content/Context:getCacheDir	()Ljava/io/File;
    //   18: astore_0
    //   19: aload_2
    //   20: astore 8
    //   22: aload_0
    //   23: ifnull +9 -> 32
    //   26: aload_0
    //   27: invokevirtual 309	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   30: astore 8
    //   32: iconst_0
    //   33: istore 7
    //   35: aload 4
    //   37: getstatic 203	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   40: if_acmpne +117 -> 157
    //   43: new 128	java/lang/StringBuilder
    //   46: dup
    //   47: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   50: aload_3
    //   51: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: ldc_w 1013
    //   57: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: astore_0
    //   64: new 184	java/io/File
    //   67: dup
    //   68: aload 8
    //   70: aload_0
    //   71: invokespecial 1015	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   74: astore_3
    //   75: new 352	java/io/FileOutputStream
    //   78: dup
    //   79: aload_3
    //   80: invokespecial 355	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   83: astore_0
    //   84: aload_0
    //   85: astore_2
    //   86: aload 4
    //   88: getstatic 380	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   91: if_acmpne +90 -> 181
    //   94: aload 5
    //   96: ifnull +85 -> 181
    //   99: aload_0
    //   100: astore_2
    //   101: aload 5
    //   103: invokevirtual 927	java/lang/String:length	()I
    //   106: istore 6
    //   108: iload 6
    //   110: ifle +71 -> 181
    //   113: aload_0
    //   114: invokestatic 993	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   117: aload_3
    //   118: astore_0
    //   119: iload 7
    //   121: ifeq +109 -> 230
    //   124: aload_0
    //   125: areturn
    //   126: new 184	java/io/File
    //   129: dup
    //   130: aload_2
    //   131: invokespecial 186	java/io/File:<init>	(Ljava/lang/String;)V
    //   134: astore_0
    //   135: aload_2
    //   136: astore 8
    //   138: aload_0
    //   139: invokevirtual 1018	java/io/File:isDirectory	()Z
    //   142: ifne -110 -> 32
    //   145: aload_2
    //   146: astore 8
    //   148: aload_0
    //   149: invokevirtual 332	java/io/File:mkdirs	()Z
    //   152: ifne -120 -> 32
    //   155: aconst_null
    //   156: areturn
    //   157: new 128	java/lang/StringBuilder
    //   160: dup
    //   161: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   164: aload_3
    //   165: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: ldc_w 1020
    //   171: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   177: astore_0
    //   178: goto -114 -> 64
    //   181: aload_0
    //   182: astore_2
    //   183: aload_1
    //   184: aload 4
    //   186: bipush 99
    //   188: aload_0
    //   189: invokevirtual 207	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   192: istore 7
    //   194: goto -81 -> 113
    //   197: astore_1
    //   198: aconst_null
    //   199: astore_0
    //   200: aconst_null
    //   201: astore_3
    //   202: aload_0
    //   203: astore_2
    //   204: aload_1
    //   205: invokestatic 219	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   208: aload_0
    //   209: invokestatic 993	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   212: iconst_0
    //   213: istore 7
    //   215: aload_3
    //   216: astore_0
    //   217: goto -98 -> 119
    //   220: astore_0
    //   221: aload 9
    //   223: astore_1
    //   224: aload_1
    //   225: invokestatic 993	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   228: aload_0
    //   229: athrow
    //   230: aconst_null
    //   231: astore_0
    //   232: goto -108 -> 124
    //   235: astore_0
    //   236: aload_2
    //   237: astore_1
    //   238: goto -14 -> 224
    //   241: astore_1
    //   242: aconst_null
    //   243: astore_0
    //   244: goto -42 -> 202
    //   247: astore_1
    //   248: goto -46 -> 202
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	251	0	paramContext	Context
    //   0	251	1	paramBitmap	Bitmap
    //   0	251	2	paramString1	String
    //   0	251	3	paramString2	String
    //   0	251	4	paramCompressFormat	Bitmap.CompressFormat
    //   0	251	5	paramString3	String
    //   106	3	6	i	int
    //   33	181	7	bool	boolean
    //   8	139	8	str	String
    //   1	221	9	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   35	64	197	java/lang/Exception
    //   64	75	197	java/lang/Exception
    //   157	178	197	java/lang/Exception
    //   35	64	220	finally
    //   64	75	220	finally
    //   75	84	220	finally
    //   157	178	220	finally
    //   86	94	235	finally
    //   101	108	235	finally
    //   183	194	235	finally
    //   204	208	235	finally
    //   75	84	241	java/lang/Exception
    //   86	94	247	java/lang/Exception
    //   101	108	247	java/lang/Exception
    //   183	194	247	java/lang/Exception
  }
  
  /* Error */
  public static BitmapUtils.SAVE_STATUS saveBitmap2JPG(Bitmap paramBitmap, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore_3
    //   5: aconst_null
    //   6: astore 4
    //   8: aload_3
    //   9: astore_2
    //   10: new 184	java/io/File
    //   13: dup
    //   14: aload_1
    //   15: invokespecial 186	java/io/File:<init>	(Ljava/lang/String;)V
    //   18: astore 6
    //   20: aload_3
    //   21: astore_2
    //   22: aload 6
    //   24: invokevirtual 986	java/io/File:getParentFile	()Ljava/io/File;
    //   27: astore 7
    //   29: aload_3
    //   30: astore_2
    //   31: aload 7
    //   33: invokevirtual 190	java/io/File:exists	()Z
    //   36: ifne +11 -> 47
    //   39: aload_3
    //   40: astore_2
    //   41: aload 7
    //   43: invokevirtual 332	java/io/File:mkdirs	()Z
    //   46: pop
    //   47: aload_3
    //   48: astore_2
    //   49: aload 6
    //   51: invokevirtual 190	java/io/File:exists	()Z
    //   54: ifne +11 -> 65
    //   57: aload_3
    //   58: astore_2
    //   59: aload 6
    //   61: invokevirtual 350	java/io/File:createNewFile	()Z
    //   64: pop
    //   65: aload_3
    //   66: astore_2
    //   67: new 352	java/io/FileOutputStream
    //   70: dup
    //   71: aload_1
    //   72: invokespecial 987	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   75: astore_3
    //   76: aload_0
    //   77: ifnull +18 -> 95
    //   80: aload_0
    //   81: getstatic 380	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   84: bipush 99
    //   86: aload_3
    //   87: invokevirtual 207	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   90: pop
    //   91: aload_3
    //   92: invokevirtual 990	java/io/FileOutputStream:flush	()V
    //   95: aload_3
    //   96: invokestatic 993	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   99: getstatic 999	com/tencent/ttpic/baseutils/bitmap/BitmapUtils$SAVE_STATUS:SAVE_SUCCESS	Lcom/tencent/ttpic/baseutils/bitmap/BitmapUtils$SAVE_STATUS;
    //   102: areturn
    //   103: astore_1
    //   104: aload 4
    //   106: astore_0
    //   107: aload_0
    //   108: astore_2
    //   109: aload_1
    //   110: invokestatic 219	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   113: aload_0
    //   114: astore_2
    //   115: getstatic 1002	com/tencent/ttpic/baseutils/bitmap/BitmapUtils$SAVE_STATUS:SAVE_FAILED	Lcom/tencent/ttpic/baseutils/bitmap/BitmapUtils$SAVE_STATUS;
    //   118: astore_1
    //   119: aload_0
    //   120: invokestatic 993	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   123: aload_1
    //   124: areturn
    //   125: astore 4
    //   127: aload 5
    //   129: astore_3
    //   130: aload_3
    //   131: astore_2
    //   132: aload 4
    //   134: invokestatic 219	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   137: aload_3
    //   138: astore_2
    //   139: ldc_w 561
    //   142: iconst_3
    //   143: anewarray 4	java/lang/Object
    //   146: dup
    //   147: iconst_0
    //   148: aload_1
    //   149: aastore
    //   150: dup
    //   151: iconst_1
    //   152: aload_0
    //   153: invokevirtual 152	android/graphics/Bitmap:getWidth	()I
    //   156: invokestatic 158	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   159: aastore
    //   160: dup
    //   161: iconst_2
    //   162: aload_0
    //   163: invokevirtual 161	android/graphics/Bitmap:getHeight	()I
    //   166: invokestatic 158	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   169: aastore
    //   170: invokestatic 165	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   173: invokestatic 171	com/tencent/ttpic/baseutils/report/ReportUtil:report	(Ljava/lang/String;)V
    //   176: aload_3
    //   177: astore_2
    //   178: getstatic 1007	com/tencent/ttpic/baseutils/bitmap/BitmapUtils$SAVE_STATUS:SAVE_OOM	Lcom/tencent/ttpic/baseutils/bitmap/BitmapUtils$SAVE_STATUS;
    //   181: astore_0
    //   182: aload_3
    //   183: invokestatic 993	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   186: aload_0
    //   187: areturn
    //   188: astore_0
    //   189: aload_2
    //   190: invokestatic 993	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   193: aload_0
    //   194: athrow
    //   195: astore_0
    //   196: aload_3
    //   197: astore_2
    //   198: goto -9 -> 189
    //   201: astore 4
    //   203: goto -73 -> 130
    //   206: astore_1
    //   207: aload_3
    //   208: astore_0
    //   209: goto -102 -> 107
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	212	0	paramBitmap	Bitmap
    //   0	212	1	paramString	String
    //   9	189	2	localObject1	Object
    //   4	204	3	localObject2	Object
    //   6	99	4	localObject3	Object
    //   125	8	4	localOutOfMemoryError1	OutOfMemoryError
    //   201	1	4	localOutOfMemoryError2	OutOfMemoryError
    //   1	127	5	localObject4	Object
    //   18	42	6	localFile1	File
    //   27	15	7	localFile2	File
    // Exception table:
    //   from	to	target	type
    //   10	20	103	java/lang/Exception
    //   22	29	103	java/lang/Exception
    //   31	39	103	java/lang/Exception
    //   41	47	103	java/lang/Exception
    //   49	57	103	java/lang/Exception
    //   59	65	103	java/lang/Exception
    //   67	76	103	java/lang/Exception
    //   10	20	125	java/lang/OutOfMemoryError
    //   22	29	125	java/lang/OutOfMemoryError
    //   31	39	125	java/lang/OutOfMemoryError
    //   41	47	125	java/lang/OutOfMemoryError
    //   49	57	125	java/lang/OutOfMemoryError
    //   59	65	125	java/lang/OutOfMemoryError
    //   67	76	125	java/lang/OutOfMemoryError
    //   10	20	188	finally
    //   22	29	188	finally
    //   31	39	188	finally
    //   41	47	188	finally
    //   49	57	188	finally
    //   59	65	188	finally
    //   67	76	188	finally
    //   109	113	188	finally
    //   115	119	188	finally
    //   132	137	188	finally
    //   139	176	188	finally
    //   178	182	188	finally
    //   80	95	195	finally
    //   80	95	201	java/lang/OutOfMemoryError
    //   80	95	206	java/lang/Exception
  }
  
  /* Error */
  public static byte[] saveBitmap2JpgByteArray(Bitmap paramBitmap)
  {
    // Byte code:
    //   0: iconst_0
    //   1: newarray byte
    //   3: astore 4
    //   5: new 196	java/io/ByteArrayOutputStream
    //   8: dup
    //   9: invokespecial 197	java/io/ByteArrayOutputStream:<init>	()V
    //   12: astore_2
    //   13: aload 4
    //   15: astore_1
    //   16: aload_0
    //   17: ifnull +31 -> 48
    //   20: aload_2
    //   21: astore_1
    //   22: aload_0
    //   23: getstatic 203	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   26: bipush 99
    //   28: aload_2
    //   29: invokevirtual 207	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   32: pop
    //   33: aload_2
    //   34: astore_1
    //   35: aload_2
    //   36: invokevirtual 1023	java/io/ByteArrayOutputStream:flush	()V
    //   39: aload_2
    //   40: astore_1
    //   41: aload_2
    //   42: invokevirtual 213	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   45: astore_3
    //   46: aload_3
    //   47: astore_1
    //   48: aload_2
    //   49: invokestatic 993	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   52: aload_1
    //   53: areturn
    //   54: astore_0
    //   55: aconst_null
    //   56: astore_2
    //   57: aload_2
    //   58: astore_1
    //   59: aload_0
    //   60: invokestatic 219	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   63: aload_2
    //   64: invokestatic 993	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   67: aload 4
    //   69: areturn
    //   70: astore_3
    //   71: aconst_null
    //   72: astore_2
    //   73: aload_2
    //   74: astore_1
    //   75: aload_3
    //   76: invokestatic 219	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   79: aload_2
    //   80: astore_1
    //   81: ldc_w 1025
    //   84: iconst_2
    //   85: anewarray 4	java/lang/Object
    //   88: dup
    //   89: iconst_0
    //   90: aload_0
    //   91: invokevirtual 152	android/graphics/Bitmap:getWidth	()I
    //   94: invokestatic 158	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   97: aastore
    //   98: dup
    //   99: iconst_1
    //   100: aload_0
    //   101: invokevirtual 161	android/graphics/Bitmap:getHeight	()I
    //   104: invokestatic 158	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   107: aastore
    //   108: invokestatic 165	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   111: invokestatic 171	com/tencent/ttpic/baseutils/report/ReportUtil:report	(Ljava/lang/String;)V
    //   114: aload_2
    //   115: invokestatic 993	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   118: aload 4
    //   120: areturn
    //   121: astore_0
    //   122: aconst_null
    //   123: astore_1
    //   124: aload_1
    //   125: invokestatic 993	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   128: aload_0
    //   129: athrow
    //   130: astore_0
    //   131: goto -7 -> 124
    //   134: astore_3
    //   135: goto -62 -> 73
    //   138: astore_0
    //   139: goto -82 -> 57
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	142	0	paramBitmap	Bitmap
    //   15	110	1	localObject	Object
    //   12	103	2	localByteArrayOutputStream	ByteArrayOutputStream
    //   45	2	3	arrayOfByte1	byte[]
    //   70	6	3	localOutOfMemoryError1	OutOfMemoryError
    //   134	1	3	localOutOfMemoryError2	OutOfMemoryError
    //   3	116	4	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   5	13	54	java/lang/Exception
    //   5	13	70	java/lang/OutOfMemoryError
    //   5	13	121	finally
    //   22	33	130	finally
    //   35	39	130	finally
    //   41	46	130	finally
    //   59	63	130	finally
    //   75	79	130	finally
    //   81	114	130	finally
    //   22	33	134	java/lang/OutOfMemoryError
    //   35	39	134	java/lang/OutOfMemoryError
    //   41	46	134	java/lang/OutOfMemoryError
    //   22	33	138	java/lang/Exception
    //   35	39	138	java/lang/Exception
    //   41	46	138	java/lang/Exception
  }
  
  /* Error */
  public static BitmapUtils.SAVE_STATUS saveBitmap2PNG(Bitmap paramBitmap, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore_3
    //   5: aconst_null
    //   6: astore 4
    //   8: aload_3
    //   9: astore_2
    //   10: new 184	java/io/File
    //   13: dup
    //   14: aload_1
    //   15: invokespecial 186	java/io/File:<init>	(Ljava/lang/String;)V
    //   18: astore 6
    //   20: aload_3
    //   21: astore_2
    //   22: aload 6
    //   24: invokevirtual 986	java/io/File:getParentFile	()Ljava/io/File;
    //   27: astore 7
    //   29: aload_3
    //   30: astore_2
    //   31: aload 7
    //   33: invokevirtual 190	java/io/File:exists	()Z
    //   36: ifne +11 -> 47
    //   39: aload_3
    //   40: astore_2
    //   41: aload 7
    //   43: invokevirtual 332	java/io/File:mkdirs	()Z
    //   46: pop
    //   47: aload_3
    //   48: astore_2
    //   49: aload 6
    //   51: invokevirtual 190	java/io/File:exists	()Z
    //   54: ifne +11 -> 65
    //   57: aload_3
    //   58: astore_2
    //   59: aload 6
    //   61: invokevirtual 350	java/io/File:createNewFile	()Z
    //   64: pop
    //   65: aload_3
    //   66: astore_2
    //   67: new 352	java/io/FileOutputStream
    //   70: dup
    //   71: aload_1
    //   72: invokespecial 987	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   75: astore_3
    //   76: aload_0
    //   77: ifnull +18 -> 95
    //   80: aload_0
    //   81: getstatic 203	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   84: bipush 99
    //   86: aload_3
    //   87: invokevirtual 207	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   90: pop
    //   91: aload_3
    //   92: invokevirtual 990	java/io/FileOutputStream:flush	()V
    //   95: aload_3
    //   96: invokestatic 993	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   99: getstatic 999	com/tencent/ttpic/baseutils/bitmap/BitmapUtils$SAVE_STATUS:SAVE_SUCCESS	Lcom/tencent/ttpic/baseutils/bitmap/BitmapUtils$SAVE_STATUS;
    //   102: areturn
    //   103: astore_1
    //   104: aload 4
    //   106: astore_0
    //   107: aload_0
    //   108: astore_2
    //   109: aload_1
    //   110: invokestatic 219	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   113: aload_0
    //   114: astore_2
    //   115: getstatic 1002	com/tencent/ttpic/baseutils/bitmap/BitmapUtils$SAVE_STATUS:SAVE_FAILED	Lcom/tencent/ttpic/baseutils/bitmap/BitmapUtils$SAVE_STATUS;
    //   118: astore_1
    //   119: aload_0
    //   120: invokestatic 993	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   123: aload_1
    //   124: areturn
    //   125: astore 4
    //   127: aload 5
    //   129: astore_3
    //   130: aload_3
    //   131: astore_2
    //   132: aload 4
    //   134: invokestatic 219	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   137: aload_3
    //   138: astore_2
    //   139: ldc_w 561
    //   142: iconst_3
    //   143: anewarray 4	java/lang/Object
    //   146: dup
    //   147: iconst_0
    //   148: aload_1
    //   149: aastore
    //   150: dup
    //   151: iconst_1
    //   152: aload_0
    //   153: invokevirtual 152	android/graphics/Bitmap:getWidth	()I
    //   156: invokestatic 158	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   159: aastore
    //   160: dup
    //   161: iconst_2
    //   162: aload_0
    //   163: invokevirtual 161	android/graphics/Bitmap:getHeight	()I
    //   166: invokestatic 158	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   169: aastore
    //   170: invokestatic 165	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   173: invokestatic 171	com/tencent/ttpic/baseutils/report/ReportUtil:report	(Ljava/lang/String;)V
    //   176: aload_3
    //   177: astore_2
    //   178: getstatic 1007	com/tencent/ttpic/baseutils/bitmap/BitmapUtils$SAVE_STATUS:SAVE_OOM	Lcom/tencent/ttpic/baseutils/bitmap/BitmapUtils$SAVE_STATUS;
    //   181: astore_0
    //   182: aload_3
    //   183: invokestatic 993	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   186: aload_0
    //   187: areturn
    //   188: astore_0
    //   189: aload_2
    //   190: invokestatic 993	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   193: aload_0
    //   194: athrow
    //   195: astore_0
    //   196: aload_3
    //   197: astore_2
    //   198: goto -9 -> 189
    //   201: astore 4
    //   203: goto -73 -> 130
    //   206: astore_1
    //   207: aload_3
    //   208: astore_0
    //   209: goto -102 -> 107
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	212	0	paramBitmap	Bitmap
    //   0	212	1	paramString	String
    //   9	189	2	localObject1	Object
    //   4	204	3	localObject2	Object
    //   6	99	4	localObject3	Object
    //   125	8	4	localOutOfMemoryError1	OutOfMemoryError
    //   201	1	4	localOutOfMemoryError2	OutOfMemoryError
    //   1	127	5	localObject4	Object
    //   18	42	6	localFile1	File
    //   27	15	7	localFile2	File
    // Exception table:
    //   from	to	target	type
    //   10	20	103	java/lang/Exception
    //   22	29	103	java/lang/Exception
    //   31	39	103	java/lang/Exception
    //   41	47	103	java/lang/Exception
    //   49	57	103	java/lang/Exception
    //   59	65	103	java/lang/Exception
    //   67	76	103	java/lang/Exception
    //   10	20	125	java/lang/OutOfMemoryError
    //   22	29	125	java/lang/OutOfMemoryError
    //   31	39	125	java/lang/OutOfMemoryError
    //   41	47	125	java/lang/OutOfMemoryError
    //   49	57	125	java/lang/OutOfMemoryError
    //   59	65	125	java/lang/OutOfMemoryError
    //   67	76	125	java/lang/OutOfMemoryError
    //   10	20	188	finally
    //   22	29	188	finally
    //   31	39	188	finally
    //   41	47	188	finally
    //   49	57	188	finally
    //   59	65	188	finally
    //   67	76	188	finally
    //   109	113	188	finally
    //   115	119	188	finally
    //   132	137	188	finally
    //   139	176	188	finally
    //   178	182	188	finally
    //   80	95	195	finally
    //   80	95	201	java/lang/OutOfMemoryError
    //   80	95	206	java/lang/Exception
  }
  
  public static Bitmap scaleBitmap(Bitmap paramBitmap, float paramFloat, boolean paramBoolean)
  {
    if (isLegal(paramBitmap))
    {
      Object localObject = new Matrix();
      ((Matrix)localObject).postScale(paramFloat, paramFloat);
      try
      {
        localObject = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), (Matrix)localObject, true);
        if ((localObject != paramBitmap) && (paramBoolean)) {
          recycle(paramBitmap);
        }
        return localObject;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        localOutOfMemoryError.printStackTrace();
        ReportUtil.report(String.format("OutOfMemoryError! scaleBitmap. width = %d, height = %d.", new Object[] { Integer.valueOf(paramBitmap.getWidth()), Integer.valueOf(paramBitmap.getHeight()) }));
        return paramBitmap;
      }
    }
    return null;
  }
  
  public static void scaleBitmap(Bitmap paramBitmap, Canvas paramCanvas, int paramInt1, int paramInt2, double paramDouble1, double paramDouble2, Point paramPoint, Paint paramPaint)
  {
    if (!isLegal(paramBitmap)) {}
    Matrix localMatrix;
    do
    {
      return;
      localMatrix = new Matrix();
      int i = (int)(paramInt1 - paramPoint.x * paramDouble2);
      int j = (int)(paramInt2 - paramPoint.y * paramDouble2);
      localMatrix.postScale((float)paramDouble2, (float)paramDouble2);
      if ((i != 0) || (j != 0)) {
        localMatrix.postTranslate(i, j);
      }
      if (paramDouble1 != 0.0D) {
        localMatrix.postRotate((float)paramDouble1, paramInt1, paramInt2);
      }
    } while (paramPaint == null);
    paramCanvas.drawBitmap(paramBitmap, localMatrix, paramPaint);
  }
  
  public static Bitmap scaleBitmapUnderLimit(Bitmap paramBitmap, int paramInt)
  {
    int i = 0;
    float f = 1.0F;
    ByteArrayOutputStream localByteArrayOutputStream;
    Bitmap localBitmap;
    if (i == 0)
    {
      localByteArrayOutputStream = new ByteArrayOutputStream();
      localBitmap = paramBitmap;
    }
    for (;;)
    {
      try
      {
        paramBitmap = scaleBitmap(paramBitmap, f, false);
        localBitmap = paramBitmap;
        paramBitmap.compress(Bitmap.CompressFormat.JPEG, 85, localByteArrayOutputStream);
        localBitmap = paramBitmap;
        int j = localByteArrayOutputStream.toByteArray().length;
        if (j <= paramInt) {
          i = 1;
        }
        f *= 0.7F;
        break;
      }
      catch (OutOfMemoryError paramBitmap)
      {
        paramBitmap = paramBitmap;
        if ((localBitmap.getHeight() < 10) || (localBitmap.getWidth() < 10)) {
          break label146;
        }
        ReportUtil.report(String.format("OutOfMemoryError! scaleBitmapUnderLimit. width = %d, height = %d.", new Object[] { Integer.valueOf(localBitmap.getWidth()), Integer.valueOf(localBitmap.getHeight()) }));
        f *= 0.7F;
        paramBitmap = localBitmap;
        break;
      }
      finally {}
      return paramBitmap;
      label146:
      i = 1;
    }
  }
  
  private static boolean shouldResize(BitmapUtils.Size paramSize, int paramInt1, int paramInt2)
  {
    int j;
    if (paramSize.height / paramSize.width >= 1.0D) {
      j = paramSize.height;
    }
    for (int i = paramSize.width; (i >= paramInt1) || (j >= paramInt2); i = paramSize.height)
    {
      return true;
      j = paramSize.width;
    }
    return false;
  }
  
  public static Bitmap unZip(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    return RGBA2Bitmap(ZipUtils.unZip(paramArrayOfByte), paramInt1, paramInt2);
  }
  
  public static byte[] zip(Bitmap paramBitmap)
  {
    if (!isLegal(paramBitmap)) {
      return null;
    }
    return ZipUtils.zip(bitmap2RGBA(paramBitmap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.baseutils.bitmap.BitmapUtils
 * JD-Core Version:    0.7.0.1
 */