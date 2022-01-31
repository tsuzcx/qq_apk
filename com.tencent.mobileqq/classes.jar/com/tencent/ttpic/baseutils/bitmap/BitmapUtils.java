package com.tencent.ttpic.baseutils.bitmap;

import android.annotation.SuppressLint;
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
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.ExifInterface;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.ttpic.AEBaseConfig;
import com.tencent.ttpic.baseutils.api.ApiHelper;
import com.tencent.ttpic.baseutils.encrypt.FileEncryptUtils;
import com.tencent.ttpic.baseutils.io.IOUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.baseutils.report.ReportUtil;
import com.tencent.ttpic.baseutils.zip.ZipUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
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
  
  /* Error */
  private static String compressImageFile(String paramString, BitmapFactory.Options paramOptions, File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: getstatic 55	com/tencent/ttpic/baseutils/bitmap/BitmapUtils:TAG	Ljava/lang/String;
    //   6: ldc_w 256
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
    //   24: invokevirtual 259	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   27: aastore
    //   28: invokestatic 263	com/tencent/ttpic/baseutils/log/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   31: aload_2
    //   32: invokevirtual 190	java/io/File:exists	()Z
    //   35: ifne +8 -> 43
    //   38: aload_2
    //   39: invokevirtual 266	java/io/File:mkdirs	()Z
    //   42: pop
    //   43: new 128	java/lang/StringBuilder
    //   46: dup
    //   47: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   50: aload_2
    //   51: invokevirtual 259	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   54: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: getstatic 269	java/io/File:separator	Ljava/lang/String;
    //   60: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: ldc_w 271
    //   66: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: new 273	java/util/Date
    //   72: dup
    //   73: invokespecial 274	java/util/Date:<init>	()V
    //   76: invokevirtual 278	java/util/Date:getTime	()J
    //   79: invokevirtual 281	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
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
    //   105: invokevirtual 284	java/io/File:createNewFile	()Z
    //   108: pop
    //   109: new 286	java/io/FileOutputStream
    //   112: dup
    //   113: aload_2
    //   114: invokespecial 289	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   117: astore_3
    //   118: aload_3
    //   119: astore_2
    //   120: aload_1
    //   121: getfield 292	android/graphics/BitmapFactory$Options:outMimeType	Ljava/lang/String;
    //   124: invokestatic 295	com/tencent/ttpic/baseutils/bitmap/BitmapUtils:isSupportImgType	(Ljava/lang/String;)Z
    //   127: ifne +61 -> 188
    //   130: aload_3
    //   131: astore_2
    //   132: aload_1
    //   133: getstatic 298	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   136: putfield 301	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   139: aload_3
    //   140: astore_2
    //   141: aload_1
    //   142: iconst_1
    //   143: putfield 304	android/graphics/BitmapFactory$Options:inPurgeable	Z
    //   146: aload_3
    //   147: astore_2
    //   148: aload_1
    //   149: iconst_1
    //   150: putfield 307	android/graphics/BitmapFactory$Options:inInputShareable	Z
    //   153: aload_3
    //   154: astore_2
    //   155: aload_0
    //   156: aload_1
    //   157: invokestatic 311	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   160: astore 6
    //   162: aload 6
    //   164: astore_0
    //   165: aload_0
    //   166: ifnull +94 -> 260
    //   169: aload_3
    //   170: astore_2
    //   171: aload_0
    //   172: getstatic 314	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
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
    //   191: invokevirtual 317	java/io/OutputStream:close	()V
    //   194: aload_3
    //   195: ifnull +7 -> 202
    //   198: aload_3
    //   199: invokevirtual 317	java/io/OutputStream:close	()V
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
    //   218: ldc_w 319
    //   221: iconst_3
    //   222: anewarray 4	java/lang/Object
    //   225: dup
    //   226: iconst_0
    //   227: aload_0
    //   228: aastore
    //   229: dup
    //   230: iconst_1
    //   231: aload_1
    //   232: getfield 236	android/graphics/BitmapFactory$Options:outWidth	I
    //   235: invokestatic 158	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   238: aastore
    //   239: dup
    //   240: iconst_2
    //   241: aload_1
    //   242: getfield 233	android/graphics/BitmapFactory$Options:outHeight	I
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
    //   268: invokevirtual 317	java/io/OutputStream:close	()V
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
    //   293: invokevirtual 317	java/io/OutputStream:close	()V
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
    //   309: invokevirtual 317	java/io/OutputStream:close	()V
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
    //   26: invokevirtual 499	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   29: astore_0
    //   30: aload_0
    //   31: aload_1
    //   32: invokevirtual 504	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   35: astore 6
    //   37: new 230	android/graphics/BitmapFactory$Options
    //   40: dup
    //   41: invokespecial 465	android/graphics/BitmapFactory$Options:<init>	()V
    //   44: astore_3
    //   45: aload_3
    //   46: iconst_0
    //   47: putfield 507	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   50: aload_3
    //   51: iload_2
    //   52: putfield 510	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   55: aload 6
    //   57: aconst_null
    //   58: aload_3
    //   59: invokestatic 514	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   62: astore_0
    //   63: aload_0
    //   64: astore_3
    //   65: aload 6
    //   67: ifnull -44 -> 23
    //   70: aload 6
    //   72: invokevirtual 517	java/io/InputStream:close	()V
    //   75: aload_0
    //   76: areturn
    //   77: astore_1
    //   78: aload_0
    //   79: areturn
    //   80: astore_0
    //   81: getstatic 55	com/tencent/ttpic/baseutils/bitmap/BitmapUtils:TAG	Ljava/lang/String;
    //   84: aload_0
    //   85: invokevirtual 518	java/io/IOException:toString	()Ljava/lang/String;
    //   88: invokestatic 147	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   91: aconst_null
    //   92: areturn
    //   93: astore_0
    //   94: getstatic 55	com/tencent/ttpic/baseutils/bitmap/BitmapUtils:TAG	Ljava/lang/String;
    //   97: aload_0
    //   98: invokevirtual 519	java/lang/Exception:toString	()Ljava/lang/String;
    //   101: invokestatic 147	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   104: aload 5
    //   106: astore_3
    //   107: aload 6
    //   109: ifnull -86 -> 23
    //   112: aload 6
    //   114: invokevirtual 517	java/io/InputStream:close	()V
    //   117: aconst_null
    //   118: areturn
    //   119: astore_0
    //   120: aconst_null
    //   121: areturn
    //   122: astore_0
    //   123: aload_3
    //   124: aload_3
    //   125: getfield 510	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   128: iconst_1
    //   129: ishl
    //   130: putfield 510	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   133: aload 6
    //   135: invokevirtual 522	java/io/InputStream:reset	()V
    //   138: aload 6
    //   140: aconst_null
    //   141: aload_3
    //   142: invokestatic 514	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   145: astore_0
    //   146: aload_0
    //   147: astore_3
    //   148: aload 6
    //   150: ifnull -127 -> 23
    //   153: aload 6
    //   155: invokevirtual 517	java/io/InputStream:close	()V
    //   158: aload_0
    //   159: areturn
    //   160: astore_1
    //   161: aload_0
    //   162: areturn
    //   163: astore_0
    //   164: getstatic 55	com/tencent/ttpic/baseutils/bitmap/BitmapUtils:TAG	Ljava/lang/String;
    //   167: aload_0
    //   168: invokevirtual 525	java/lang/Throwable:toString	()Ljava/lang/String;
    //   171: invokestatic 147	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   174: ldc_w 527
    //   177: iconst_3
    //   178: anewarray 4	java/lang/Object
    //   181: dup
    //   182: iconst_0
    //   183: aload_1
    //   184: aastore
    //   185: dup
    //   186: iconst_1
    //   187: aload_3
    //   188: getfield 236	android/graphics/BitmapFactory$Options:outWidth	I
    //   191: invokestatic 158	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   194: aastore
    //   195: dup
    //   196: iconst_2
    //   197: aload_3
    //   198: getfield 233	android/graphics/BitmapFactory$Options:outHeight	I
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
    //   225: invokevirtual 517	java/io/InputStream:close	()V
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
  public static String getBase64FromBitmap(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +18 -> 19
    //   4: getstatic 55	com/tencent/ttpic/baseutils/bitmap/BitmapUtils:TAG	Ljava/lang/String;
    //   7: ldc_w 585
    //   10: invokestatic 426	com/tencent/ttpic/baseutils/log/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   13: ldc_w 550
    //   16: astore_0
    //   17: aload_0
    //   18: areturn
    //   19: ldc_w 550
    //   22: astore 4
    //   24: new 196	java/io/ByteArrayOutputStream
    //   27: dup
    //   28: invokespecial 197	java/io/ByteArrayOutputStream:<init>	()V
    //   31: astore_3
    //   32: aload_0
    //   33: getstatic 314	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   36: iload_2
    //   37: aload_3
    //   38: invokevirtual 207	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   41: pop
    //   42: aload_3
    //   43: invokevirtual 213	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   46: iload_1
    //   47: invokestatic 591	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
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
    //   90: ldc_w 550
    //   93: areturn
    //   94: astore_0
    //   95: aload_0
    //   96: invokestatic 219	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   99: ldc_w 550
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
    //   117: ldc_w 550
    //   120: areturn
    //   121: astore_0
    //   122: aload_0
    //   123: invokestatic 219	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   126: ldc_w 550
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
    //   19: invokevirtual 499	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   22: aload_1
    //   23: invokestatic 596	com/tencent/ttpic/baseutils/io/FileUtils:getRealPath	(Ljava/lang/String;)Ljava/lang/String;
    //   26: invokevirtual 504	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   29: astore_1
    //   30: aload_1
    //   31: invokestatic 442	com/tencent/ttpic/baseutils/encrypt/FileEncryptUtils:decryptFile	(Ljava/io/InputStream;)[B
    //   34: astore_0
    //   35: aload_1
    //   36: invokestatic 448	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   39: aload_0
    //   40: ifnull -33 -> 7
    //   43: new 230	android/graphics/BitmapFactory$Options
    //   46: dup
    //   47: invokespecial 465	android/graphics/BitmapFactory$Options:<init>	()V
    //   50: astore_1
    //   51: aload_1
    //   52: getstatic 87	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   55: putfield 301	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   58: aload_0
    //   59: iconst_0
    //   60: aload_0
    //   61: arraylength
    //   62: aload_1
    //   63: invokestatic 468	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   66: astore_0
    //   67: aload_0
    //   68: areturn
    //   69: new 435	java/io/FileInputStream
    //   72: dup
    //   73: aload_1
    //   74: invokespecial 436	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   77: astore_1
    //   78: goto -48 -> 30
    //   81: astore_1
    //   82: aconst_null
    //   83: astore_0
    //   84: ldc_w 598
    //   87: ldc_w 600
    //   90: aload_1
    //   91: iconst_0
    //   92: anewarray 4	java/lang/Object
    //   95: invokestatic 602	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;[Ljava/lang/Object;)V
    //   98: goto -59 -> 39
    //   101: astore_0
    //   102: ldc_w 598
    //   105: ldc_w 603
    //   108: aload_0
    //   109: iconst_0
    //   110: anewarray 4	java/lang/Object
    //   113: invokestatic 602	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;[Ljava/lang/Object;)V
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
    //   34: new 435	java/io/FileInputStream
    //   37: dup
    //   38: aload_1
    //   39: invokespecial 436	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   42: astore_0
    //   43: aload_0
    //   44: ifnull +229 -> 273
    //   47: aload_0
    //   48: astore_1
    //   49: aload_0
    //   50: invokestatic 442	com/tencent/ttpic/baseutils/encrypt/FileEncryptUtils:decryptFile	(Ljava/io/InputStream;)[B
    //   53: astore 4
    //   55: aload_0
    //   56: astore_1
    //   57: new 230	android/graphics/BitmapFactory$Options
    //   60: dup
    //   61: invokespecial 465	android/graphics/BitmapFactory$Options:<init>	()V
    //   64: astore 6
    //   66: aload_0
    //   67: astore_1
    //   68: aload 6
    //   70: getstatic 87	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   73: putfield 301	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   76: aload 6
    //   78: iconst_1
    //   79: putfield 507	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   82: aload 4
    //   84: iconst_0
    //   85: aload 4
    //   87: arraylength
    //   88: aload 6
    //   90: invokestatic 468	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   93: pop
    //   94: aload 6
    //   96: aload 6
    //   98: iload_2
    //   99: iload_2
    //   100: iconst_0
    //   101: invokestatic 538	com/tencent/ttpic/baseutils/bitmap/BitmapUtils:calculateInSampleSizeNew	(Landroid/graphics/BitmapFactory$Options;IIZ)I
    //   104: putfield 510	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   107: aload 6
    //   109: iconst_0
    //   110: putfield 507	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   113: aload 6
    //   115: iconst_1
    //   116: putfield 648	android/graphics/BitmapFactory$Options:inPreferQualityOverSpeed	Z
    //   119: aload 4
    //   121: iconst_0
    //   122: aload 4
    //   124: arraylength
    //   125: aload 6
    //   127: invokestatic 468	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   130: astore 5
    //   132: aload_0
    //   133: astore_1
    //   134: aload_0
    //   135: invokestatic 448	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   138: aload 5
    //   140: ifnonnull +177 -> 317
    //   143: aload_0
    //   144: invokestatic 448	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   147: aconst_null
    //   148: areturn
    //   149: astore_0
    //   150: new 435	java/io/FileInputStream
    //   153: dup
    //   154: new 128	java/lang/StringBuilder
    //   157: dup
    //   158: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   161: aload_1
    //   162: iconst_0
    //   163: aload_1
    //   164: bipush 46
    //   166: invokevirtual 542	java/lang/String:lastIndexOf	(I)I
    //   169: iconst_1
    //   170: iadd
    //   171: invokevirtual 546	java/lang/String:substring	(II)Ljava/lang/String;
    //   174: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: ldc_w 548
    //   180: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   186: invokespecial 436	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
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
    //   205: invokestatic 448	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   208: aconst_null
    //   209: areturn
    //   210: aload_0
    //   211: invokevirtual 499	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   214: aload_1
    //   215: invokevirtual 504	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
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
    //   240: invokevirtual 542	java/lang/String:lastIndexOf	(I)I
    //   243: iconst_1
    //   244: iadd
    //   245: invokevirtual 546	java/lang/String:substring	(II)Ljava/lang/String;
    //   248: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: ldc_w 548
    //   254: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   260: astore_1
    //   261: aload_0
    //   262: invokevirtual 499	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   265: aload_1
    //   266: invokevirtual 504	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   269: astore_0
    //   270: goto -227 -> 43
    //   273: aload_0
    //   274: invokestatic 448	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   277: aconst_null
    //   278: areturn
    //   279: astore_1
    //   280: iload_2
    //   281: i2f
    //   282: ldc_w 649
    //   285: fdiv
    //   286: f2i
    //   287: istore_2
    //   288: aload_0
    //   289: astore_1
    //   290: aload_0
    //   291: invokestatic 448	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   294: goto -218 -> 76
    //   297: astore 4
    //   299: aload_0
    //   300: astore_1
    //   301: aload_0
    //   302: invokestatic 448	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   305: aload_0
    //   306: astore_1
    //   307: aload 4
    //   309: athrow
    //   310: astore_0
    //   311: aload_1
    //   312: invokestatic 448	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   315: aload_0
    //   316: athrow
    //   317: aload_0
    //   318: astore_1
    //   319: aload 5
    //   321: invokevirtual 325	android/graphics/Bitmap:getConfig	()Landroid/graphics/Bitmap$Config;
    //   324: astore 4
    //   326: aload_0
    //   327: astore_1
    //   328: getstatic 87	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   331: astore 6
    //   333: aload 4
    //   335: aload 6
    //   337: if_acmpne +10 -> 347
    //   340: aload_0
    //   341: invokestatic 448	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   344: aload 5
    //   346: areturn
    //   347: aload_0
    //   348: astore_1
    //   349: aload 5
    //   351: getstatic 87	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   354: iconst_0
    //   355: invokevirtual 328	android/graphics/Bitmap:copy	(Landroid/graphics/Bitmap$Config;Z)Landroid/graphics/Bitmap;
    //   358: astore 4
    //   360: aload 4
    //   362: aload 5
    //   364: if_acmpeq +11 -> 375
    //   367: aload_0
    //   368: astore_1
    //   369: aload 5
    //   371: invokestatic 651	com/tencent/ttpic/baseutils/bitmap/BitmapUtils:recycle	(Landroid/graphics/Bitmap;)Z
    //   374: pop
    //   375: aload_0
    //   376: astore_1
    //   377: aload 4
    //   379: astore_0
    //   380: aload_1
    //   381: invokestatic 448	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
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
  
  public static String getRealPath(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (!paramString.startsWith("assets://")) {
      return paramString;
    }
    return paramString.substring("assets://".length());
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
    //   24: invokevirtual 704	java/io/File:getParentFile	()Ljava/io/File;
    //   27: astore 7
    //   29: aload_3
    //   30: astore_2
    //   31: aload 7
    //   33: invokevirtual 190	java/io/File:exists	()Z
    //   36: ifne +11 -> 47
    //   39: aload_3
    //   40: astore_2
    //   41: aload 7
    //   43: invokevirtual 266	java/io/File:mkdirs	()Z
    //   46: pop
    //   47: aload_3
    //   48: astore_2
    //   49: aload 6
    //   51: invokevirtual 190	java/io/File:exists	()Z
    //   54: ifne +11 -> 65
    //   57: aload_3
    //   58: astore_2
    //   59: aload 6
    //   61: invokevirtual 284	java/io/File:createNewFile	()Z
    //   64: pop
    //   65: aload_3
    //   66: astore_2
    //   67: new 286	java/io/FileOutputStream
    //   70: dup
    //   71: aload_1
    //   72: invokespecial 705	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   75: astore_3
    //   76: aload_0
    //   77: ifnull +18 -> 95
    //   80: aload_0
    //   81: getstatic 314	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   84: bipush 99
    //   86: aload_3
    //   87: invokevirtual 207	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   90: pop
    //   91: aload_3
    //   92: invokevirtual 708	java/io/FileOutputStream:flush	()V
    //   95: aload_3
    //   96: invokestatic 711	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   99: getstatic 717	com/tencent/ttpic/baseutils/bitmap/BitmapUtils$SAVE_STATUS:SAVE_SUCCESS	Lcom/tencent/ttpic/baseutils/bitmap/BitmapUtils$SAVE_STATUS;
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
    //   115: getstatic 720	com/tencent/ttpic/baseutils/bitmap/BitmapUtils$SAVE_STATUS:SAVE_FAILED	Lcom/tencent/ttpic/baseutils/bitmap/BitmapUtils$SAVE_STATUS;
    //   118: astore_1
    //   119: aload_0
    //   120: invokestatic 711	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
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
    //   139: ldc_w 722
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
    //   178: getstatic 725	com/tencent/ttpic/baseutils/bitmap/BitmapUtils$SAVE_STATUS:SAVE_OOM	Lcom/tencent/ttpic/baseutils/bitmap/BitmapUtils$SAVE_STATUS;
    //   181: astore_0
    //   182: aload_3
    //   183: invokestatic 711	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   186: aload_0
    //   187: areturn
    //   188: astore_0
    //   189: aload_2
    //   190: invokestatic 711	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
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
    //   15: invokevirtual 729	android/content/Context:getCacheDir	()Ljava/io/File;
    //   18: astore_0
    //   19: aload_2
    //   20: astore 8
    //   22: aload_0
    //   23: ifnull +9 -> 32
    //   26: aload_0
    //   27: invokevirtual 259	java/io/File:getAbsolutePath	()Ljava/lang/String;
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
    //   54: ldc_w 731
    //   57: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: astore_0
    //   64: new 184	java/io/File
    //   67: dup
    //   68: aload 8
    //   70: aload_0
    //   71: invokespecial 733	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   74: astore_3
    //   75: new 286	java/io/FileOutputStream
    //   78: dup
    //   79: aload_3
    //   80: invokespecial 289	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   83: astore_0
    //   84: aload_0
    //   85: astore_2
    //   86: aload 4
    //   88: getstatic 314	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   91: if_acmpne +90 -> 181
    //   94: aload 5
    //   96: ifnull +85 -> 181
    //   99: aload_0
    //   100: astore_2
    //   101: aload 5
    //   103: invokevirtual 668	java/lang/String:length	()I
    //   106: istore 6
    //   108: iload 6
    //   110: ifle +71 -> 181
    //   113: aload_0
    //   114: invokestatic 711	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
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
    //   139: invokevirtual 736	java/io/File:isDirectory	()Z
    //   142: ifne -110 -> 32
    //   145: aload_2
    //   146: astore 8
    //   148: aload_0
    //   149: invokevirtual 266	java/io/File:mkdirs	()Z
    //   152: ifne -120 -> 32
    //   155: aconst_null
    //   156: areturn
    //   157: new 128	java/lang/StringBuilder
    //   160: dup
    //   161: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   164: aload_3
    //   165: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: ldc_w 738
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
    //   209: invokestatic 711	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   212: iconst_0
    //   213: istore 7
    //   215: aload_3
    //   216: astore_0
    //   217: goto -98 -> 119
    //   220: astore_0
    //   221: aload 9
    //   223: astore_1
    //   224: aload_1
    //   225: invokestatic 711	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
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
    //   24: invokevirtual 704	java/io/File:getParentFile	()Ljava/io/File;
    //   27: astore 7
    //   29: aload_3
    //   30: astore_2
    //   31: aload 7
    //   33: invokevirtual 190	java/io/File:exists	()Z
    //   36: ifne +11 -> 47
    //   39: aload_3
    //   40: astore_2
    //   41: aload 7
    //   43: invokevirtual 266	java/io/File:mkdirs	()Z
    //   46: pop
    //   47: aload_3
    //   48: astore_2
    //   49: aload 6
    //   51: invokevirtual 190	java/io/File:exists	()Z
    //   54: ifne +11 -> 65
    //   57: aload_3
    //   58: astore_2
    //   59: aload 6
    //   61: invokevirtual 284	java/io/File:createNewFile	()Z
    //   64: pop
    //   65: aload_3
    //   66: astore_2
    //   67: new 286	java/io/FileOutputStream
    //   70: dup
    //   71: aload_1
    //   72: invokespecial 705	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   75: astore_3
    //   76: aload_0
    //   77: ifnull +18 -> 95
    //   80: aload_0
    //   81: getstatic 314	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   84: bipush 99
    //   86: aload_3
    //   87: invokevirtual 207	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   90: pop
    //   91: aload_3
    //   92: invokevirtual 708	java/io/FileOutputStream:flush	()V
    //   95: aload_3
    //   96: invokestatic 711	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   99: getstatic 717	com/tencent/ttpic/baseutils/bitmap/BitmapUtils$SAVE_STATUS:SAVE_SUCCESS	Lcom/tencent/ttpic/baseutils/bitmap/BitmapUtils$SAVE_STATUS;
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
    //   115: getstatic 720	com/tencent/ttpic/baseutils/bitmap/BitmapUtils$SAVE_STATUS:SAVE_FAILED	Lcom/tencent/ttpic/baseutils/bitmap/BitmapUtils$SAVE_STATUS;
    //   118: astore_1
    //   119: aload_0
    //   120: invokestatic 711	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
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
    //   139: ldc_w 527
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
    //   178: getstatic 725	com/tencent/ttpic/baseutils/bitmap/BitmapUtils$SAVE_STATUS:SAVE_OOM	Lcom/tencent/ttpic/baseutils/bitmap/BitmapUtils$SAVE_STATUS;
    //   181: astore_0
    //   182: aload_3
    //   183: invokestatic 711	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   186: aload_0
    //   187: areturn
    //   188: astore_0
    //   189: aload_2
    //   190: invokestatic 711	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
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
    //   36: invokevirtual 741	java/io/ByteArrayOutputStream:flush	()V
    //   39: aload_2
    //   40: astore_1
    //   41: aload_2
    //   42: invokevirtual 213	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   45: astore_3
    //   46: aload_3
    //   47: astore_1
    //   48: aload_2
    //   49: invokestatic 711	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
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
    //   64: invokestatic 711	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
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
    //   81: ldc_w 743
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
    //   115: invokestatic 711	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   118: aload 4
    //   120: areturn
    //   121: astore_0
    //   122: aconst_null
    //   123: astore_1
    //   124: aload_1
    //   125: invokestatic 711	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
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
    //   24: invokevirtual 704	java/io/File:getParentFile	()Ljava/io/File;
    //   27: astore 7
    //   29: aload_3
    //   30: astore_2
    //   31: aload 7
    //   33: invokevirtual 190	java/io/File:exists	()Z
    //   36: ifne +11 -> 47
    //   39: aload_3
    //   40: astore_2
    //   41: aload 7
    //   43: invokevirtual 266	java/io/File:mkdirs	()Z
    //   46: pop
    //   47: aload_3
    //   48: astore_2
    //   49: aload 6
    //   51: invokevirtual 190	java/io/File:exists	()Z
    //   54: ifne +11 -> 65
    //   57: aload_3
    //   58: astore_2
    //   59: aload 6
    //   61: invokevirtual 284	java/io/File:createNewFile	()Z
    //   64: pop
    //   65: aload_3
    //   66: astore_2
    //   67: new 286	java/io/FileOutputStream
    //   70: dup
    //   71: aload_1
    //   72: invokespecial 705	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
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
    //   92: invokevirtual 708	java/io/FileOutputStream:flush	()V
    //   95: aload_3
    //   96: invokestatic 711	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   99: getstatic 717	com/tencent/ttpic/baseutils/bitmap/BitmapUtils$SAVE_STATUS:SAVE_SUCCESS	Lcom/tencent/ttpic/baseutils/bitmap/BitmapUtils$SAVE_STATUS;
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
    //   115: getstatic 720	com/tencent/ttpic/baseutils/bitmap/BitmapUtils$SAVE_STATUS:SAVE_FAILED	Lcom/tencent/ttpic/baseutils/bitmap/BitmapUtils$SAVE_STATUS;
    //   118: astore_1
    //   119: aload_0
    //   120: invokestatic 711	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
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
    //   139: ldc_w 527
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
    //   178: getstatic 725	com/tencent/ttpic/baseutils/bitmap/BitmapUtils$SAVE_STATUS:SAVE_OOM	Lcom/tencent/ttpic/baseutils/bitmap/BitmapUtils$SAVE_STATUS;
    //   181: astore_0
    //   182: aload_3
    //   183: invokestatic 711	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   186: aload_0
    //   187: areturn
    //   188: astore_0
    //   189: aload_2
    //   190: invokestatic 711	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
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