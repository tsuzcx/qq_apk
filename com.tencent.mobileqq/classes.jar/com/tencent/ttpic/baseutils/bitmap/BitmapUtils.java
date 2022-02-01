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
import com.tencent.ttpic.baseutils.api.ApiHelper;
import com.tencent.ttpic.baseutils.encrypt.FileEncryptUtils;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.baseutils.io.IOUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.baseutils.report.ReportUtil;
import com.tencent.ttpic.baseutils.zip.ZipUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
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
  public static boolean ENABLE_PROFILE = true;
  private static final String[] IMAGE_PROJECTION = { "orientation" };
  private static final int INDEX_ORIENTATION = 0;
  public static final int JPEG_QUALITY = 99;
  private static final String[] PATH_PROJECTION = { "_data" };
  public static final String RES_PREFIX_ASSETS = "assets://";
  public static final String RES_PREFIX_HTTP = "http://";
  public static final String RES_PREFIX_HTTPS = "https://";
  public static final String RES_PREFIX_STORAGE = "/";
  private static final String TAG = "BitmapUtils";
  public static int currentShareIndex = -1;
  private static final float[] mMatrixValues = new float[16];
  private static final float[] mTempMatrix = new float[32];
  
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
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("bitmap2RGBA OOM! ");
      localStringBuilder.append(localOutOfMemoryError.getMessage());
      LogUtils.e(str, localStringBuilder.toString());
      ReportUtil.report(String.format("OutOfMemoryError! copy. width = %d, height = %d", new Object[] { Integer.valueOf(paramBitmap.getWidth()), Integer.valueOf(paramBitmap.getHeight()) }));
    }
    return null;
  }
  
  public static boolean bitmapExists(String paramString)
  {
    boolean bool2 = TextUtils.isEmpty(paramString);
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    if ((paramString.startsWith("assets://")) || (new File(paramString).exists())) {
      bool1 = true;
    }
    return bool1;
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
    if (Math.min(paramInt1, paramInt2) > 0.0F)
    {
      if (f1 <= f3) {
        return 1;
      }
      if (f1 / f2 > 2.0F)
      {
        f1 = j * i;
        f2 = paramInt1 * paramInt2;
        if (ApiHelper.hasNougat())
        {
          paramInt2 = 1;
          while (f1 / (paramInt2 * paramInt2) >= f2) {
            paramInt2 += 1;
          }
          paramInt1 = paramInt2;
          if (!paramBoolean) {
            break label248;
          }
          paramInt1 = paramInt2;
          if (paramInt2 <= 1) {
            break label248;
          }
        }
        else
        {
          paramInt2 = 1;
          while (f1 / (paramInt2 * paramInt2) >= f2) {
            paramInt2 *= 2;
          }
          paramInt1 = paramInt2;
          if (!paramBoolean) {
            break label248;
          }
          paramInt1 = paramInt2;
          if (paramInt2 <= 1) {
            break label248;
          }
          return paramInt2 / 2;
        }
      }
      else
      {
        if (!ApiHelper.hasNougat()) {
          break label211;
        }
        paramInt2 = 1;
        while (f1 / paramInt2 >= f3) {
          paramInt2 += 1;
        }
        paramInt1 = paramInt2;
        if (!paramBoolean) {
          break label248;
        }
        paramInt1 = paramInt2;
        if (paramInt2 <= 1) {
          break label248;
        }
      }
      return paramInt2 - 1;
      label211:
      paramInt2 = 1;
      while (f1 / paramInt2 >= f3) {
        paramInt2 *= 2;
      }
      paramInt1 = paramInt2;
      if (paramBoolean)
      {
        paramInt1 = paramInt2;
        if (paramInt2 > 1) {
          paramInt1 = paramInt2 / 2;
        }
      }
      label248:
      return paramInt1;
    }
    return 1;
  }
  
  /* Error */
  private static String compressImageFile(String paramString, BitmapFactory.Options paramOptions, File paramFile)
  {
    // Byte code:
    //   0: getstatic 118	com/tencent/ttpic/baseutils/bitmap/BitmapUtils:TAG	Ljava/lang/String;
    //   3: ldc 249
    //   5: iconst_3
    //   6: anewarray 4	java/lang/Object
    //   9: dup
    //   10: iconst_0
    //   11: aload_0
    //   12: aastore
    //   13: dup
    //   14: iconst_1
    //   15: aload_1
    //   16: aastore
    //   17: dup
    //   18: iconst_2
    //   19: aload_2
    //   20: invokevirtual 252	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   23: aastore
    //   24: invokestatic 256	com/tencent/ttpic/baseutils/log/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   27: aload_2
    //   28: invokevirtual 183	java/io/File:exists	()Z
    //   31: ifne +8 -> 39
    //   34: aload_2
    //   35: invokevirtual 259	java/io/File:mkdirs	()Z
    //   38: pop
    //   39: new 120	java/lang/StringBuilder
    //   42: dup
    //   43: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   46: astore_3
    //   47: aload_3
    //   48: aload_2
    //   49: invokevirtual 252	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   52: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: pop
    //   56: aload_3
    //   57: getstatic 262	java/io/File:separator	Ljava/lang/String;
    //   60: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: pop
    //   64: aload_3
    //   65: ldc_w 264
    //   68: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: pop
    //   72: aload_3
    //   73: new 266	java/util/Date
    //   76: dup
    //   77: invokespecial 267	java/util/Date:<init>	()V
    //   80: invokevirtual 271	java/util/Date:getTime	()J
    //   83: invokevirtual 274	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   86: pop
    //   87: aload_3
    //   88: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   91: astore 5
    //   93: new 177	java/io/File
    //   96: dup
    //   97: aload 5
    //   99: invokespecial 179	java/io/File:<init>	(Ljava/lang/String;)V
    //   102: astore_2
    //   103: aload_2
    //   104: invokevirtual 183	java/io/File:exists	()Z
    //   107: ifne +8 -> 115
    //   110: aload_2
    //   111: invokevirtual 277	java/io/File:createNewFile	()Z
    //   114: pop
    //   115: new 279	java/io/FileOutputStream
    //   118: dup
    //   119: aload_2
    //   120: invokespecial 282	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   123: astore_3
    //   124: aload_3
    //   125: astore_2
    //   126: aload_1
    //   127: getfield 285	android/graphics/BitmapFactory$Options:outMimeType	Ljava/lang/String;
    //   130: invokestatic 288	com/tencent/ttpic/baseutils/bitmap/BitmapUtils:isSupportImgType	(Ljava/lang/String;)Z
    //   133: ifne +123 -> 256
    //   136: aload_3
    //   137: astore_2
    //   138: aload_1
    //   139: getstatic 291	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   142: putfield 294	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   145: aload_3
    //   146: astore_2
    //   147: aload_1
    //   148: iconst_1
    //   149: putfield 297	android/graphics/BitmapFactory$Options:inPurgeable	Z
    //   152: aload_3
    //   153: astore_2
    //   154: aload_1
    //   155: iconst_1
    //   156: putfield 300	android/graphics/BitmapFactory$Options:inInputShareable	Z
    //   159: aload_3
    //   160: astore_2
    //   161: aload_0
    //   162: aload_1
    //   163: invokestatic 304	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   166: astore 4
    //   168: aload 4
    //   170: astore_0
    //   171: goto +53 -> 224
    //   174: astore 4
    //   176: aload_3
    //   177: astore_2
    //   178: aload 4
    //   180: invokestatic 212	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   183: aload_3
    //   184: astore_2
    //   185: ldc_w 306
    //   188: iconst_3
    //   189: anewarray 4	java/lang/Object
    //   192: dup
    //   193: iconst_0
    //   194: aload_0
    //   195: aastore
    //   196: dup
    //   197: iconst_1
    //   198: aload_1
    //   199: getfield 229	android/graphics/BitmapFactory$Options:outWidth	I
    //   202: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   205: aastore
    //   206: dup
    //   207: iconst_2
    //   208: aload_1
    //   209: getfield 226	android/graphics/BitmapFactory$Options:outHeight	I
    //   212: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   215: aastore
    //   216: invokestatic 158	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   219: invokestatic 164	com/tencent/ttpic/baseutils/report/ReportUtil:report	(Ljava/lang/String;)V
    //   222: aconst_null
    //   223: astore_0
    //   224: aload_0
    //   225: ifnull +25 -> 250
    //   228: aload_3
    //   229: astore_2
    //   230: aload_0
    //   231: getstatic 309	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   234: bipush 90
    //   236: aload_3
    //   237: invokevirtual 200	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   240: pop
    //   241: aload_3
    //   242: astore_2
    //   243: aload_0
    //   244: invokevirtual 203	android/graphics/Bitmap:recycle	()V
    //   247: goto +9 -> 256
    //   250: aload_3
    //   251: invokevirtual 312	java/io/OutputStream:close	()V
    //   254: aconst_null
    //   255: areturn
    //   256: aload_3
    //   257: astore_2
    //   258: aload_3
    //   259: invokevirtual 312	java/io/OutputStream:close	()V
    //   262: aload_3
    //   263: invokevirtual 312	java/io/OutputStream:close	()V
    //   266: aload 5
    //   268: areturn
    //   269: astore_1
    //   270: aload_3
    //   271: astore_0
    //   272: goto +12 -> 284
    //   275: astore_0
    //   276: aconst_null
    //   277: astore_2
    //   278: goto +23 -> 301
    //   281: astore_1
    //   282: aconst_null
    //   283: astore_0
    //   284: aload_0
    //   285: astore_2
    //   286: aload_1
    //   287: invokestatic 212	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   290: aload_0
    //   291: ifnull +7 -> 298
    //   294: aload_0
    //   295: invokevirtual 312	java/io/OutputStream:close	()V
    //   298: aconst_null
    //   299: areturn
    //   300: astore_0
    //   301: aload_2
    //   302: ifnull +7 -> 309
    //   305: aload_2
    //   306: invokevirtual 312	java/io/OutputStream:close	()V
    //   309: aload_0
    //   310: athrow
    //   311: astore_0
    //   312: aconst_null
    //   313: areturn
    //   314: astore_0
    //   315: aload 5
    //   317: areturn
    //   318: astore_0
    //   319: aconst_null
    //   320: areturn
    //   321: astore_1
    //   322: goto -13 -> 309
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	325	0	paramString	String
    //   0	325	1	paramOptions	BitmapFactory.Options
    //   0	325	2	paramFile	File
    //   46	225	3	localObject	Object
    //   166	3	4	localBitmap	Bitmap
    //   174	5	4	localOutOfMemoryError	OutOfMemoryError
    //   91	225	5	str	String
    // Exception table:
    //   from	to	target	type
    //   161	168	174	java/lang/OutOfMemoryError
    //   126	136	269	java/lang/Exception
    //   138	145	269	java/lang/Exception
    //   147	152	269	java/lang/Exception
    //   154	159	269	java/lang/Exception
    //   161	168	269	java/lang/Exception
    //   178	183	269	java/lang/Exception
    //   185	222	269	java/lang/Exception
    //   230	241	269	java/lang/Exception
    //   243	247	269	java/lang/Exception
    //   258	262	269	java/lang/Exception
    //   103	115	275	finally
    //   115	124	275	finally
    //   103	115	281	java/lang/Exception
    //   115	124	281	java/lang/Exception
    //   126	136	300	finally
    //   138	145	300	finally
    //   147	152	300	finally
    //   154	159	300	finally
    //   161	168	300	finally
    //   178	183	300	finally
    //   185	222	300	finally
    //   230	241	300	finally
    //   243	247	300	finally
    //   258	262	300	finally
    //   286	290	300	finally
    //   250	254	311	java/io/IOException
    //   262	266	314	java/io/IOException
    //   294	298	318	java/io/IOException
    //   305	309	321	java/io/IOException
  }
  
  public static Bitmap copy(Bitmap paramBitmap, boolean paramBoolean)
  {
    try
    {
      if (!isLegal(paramBitmap)) {
        break label60;
      }
      Bitmap localBitmap = paramBitmap.copy(paramBitmap.getConfig(), paramBoolean);
      return localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      label19:
      label60:
      break label19;
    }
    LogUtils.e(TAG, "bitmap copy OOM!");
    ReportUtil.report(String.format("OutOfMemoryError! copy. width = %d, height = %d", new Object[] { Integer.valueOf(paramBitmap.getWidth()), Integer.valueOf(paramBitmap.getHeight()) }));
    return null;
  }
  
  public static Bitmap createBitmap(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Matrix paramMatrix)
  {
    Object localObject1 = null;
    if (paramBitmap != null)
    {
      if (paramBitmap.isRecycled()) {
        return null;
      }
      Canvas localCanvas = new Canvas();
      if ((paramMatrix != null) && (!paramMatrix.isIdentity()))
      {
        Object localObject2 = new RectF(0.0F, 0.0F, paramInt3, paramInt4);
        paramMatrix.mapRect((RectF)localObject2);
        try
        {
          localObject1 = Bitmap.createBitmap(Math.round(((RectF)localObject2).width()), Math.round(((RectF)localObject2).height()), paramBitmap.getConfig());
          localCanvas.translate(-((RectF)localObject2).left, -((RectF)localObject2).top);
          localCanvas.concat(paramMatrix);
          localObject2 = new Paint(2);
          if (!paramMatrix.rectStaysRect()) {
            ((Paint)localObject2).setAntiAlias(true);
          }
          paramMatrix = (Matrix)localObject1;
          localObject1 = localObject2;
        }
        catch (OutOfMemoryError paramBitmap)
        {
          LogUtils.e(paramBitmap);
          return null;
        }
      }
      try
      {
        paramMatrix = Bitmap.createBitmap(paramInt3, paramInt4, paramBitmap.getConfig());
        paramMatrix.setDensity(paramBitmap.getDensity());
        localCanvas.setBitmap(paramMatrix);
        localCanvas.drawBitmap(paramBitmap, new Rect(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4), new RectF(0.0F, 0.0F, paramInt3, paramInt4), (Paint)localObject1);
        return paramMatrix;
      }
      catch (NullPointerException paramBitmap)
      {
        LogUtils.e(paramBitmap);
        return null;
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
    int k = paramBitmap.getWidth();
    int m = paramBitmap.getHeight();
    int j = 1;
    try
    {
      localObject1 = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      i = 1;
    }
    catch (OutOfMemoryError localOutOfMemoryError1)
    {
      Object localObject1;
      int i;
      label36:
      break label36;
    }
    i = 0;
    localObject1 = null;
    if (i == 0) {}
    try
    {
      localObject2 = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.RGB_565);
      i = j;
      localObject1 = localObject2;
    }
    catch (OutOfMemoryError localOutOfMemoryError2)
    {
      Object localObject2;
      label68:
      break label68;
    }
    if (i != 0)
    {
      if (localObject1 == null) {
        return null;
      }
      localObject2 = new Canvas((Bitmap)localObject1);
      ((Canvas)localObject2).translate((paramInt1 - k) / 2, (paramInt2 - m) / 2);
      ((Canvas)localObject2).drawBitmap(paramBitmap, 0.0F, 0.0F, new Paint(2));
      if (paramBoolean) {
        paramBitmap.recycle();
      }
      paramBitmap = TAG;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("crop bitmap - ");
      ((StringBuilder)localObject2).append(System.currentTimeMillis() - l);
      LogUtils.d(paramBitmap, ((StringBuilder)localObject2).toString());
      return localObject1;
    }
    return null;
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
    Object localObject3 = null;
    if (paramBoolean) {}
    label26:
    Object localObject1;
    try
    {
      Object localObject2 = new FileInputStream(paramString);
      break label26;
      localObject2 = getInputStreamByName(paramString);
      localObject1 = FileEncryptUtils.decryptFile((InputStream)localObject2);
      try
      {
        IOUtils.closeQuietly((InputStream)localObject2);
      }
      catch (Exception localException1) {}
      LogUtils.e(TAG, localException2.getStackTrace().toString());
    }
    catch (Exception localException2)
    {
      localObject1 = null;
    }
    if (localObject1 == null)
    {
      paramConfig = TAG;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append("] decrypted buffer is null.");
      LogUtils.w(paramConfig, ((StringBuilder)localObject1).toString());
      return null;
    }
    paramString = new BitmapFactory.Options();
    if (paramConfig != null) {
      paramString.inPreferredConfig = paramConfig;
    } else {
      paramString.inPreferredConfig = Bitmap.Config.ARGB_8888;
    }
    try
    {
      paramString = BitmapFactory.decodeByteArray((byte[])localObject1, 0, localObject1.length, paramString);
      if (paramInt1 != -1)
      {
        paramConfig = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
        localObject1 = new Canvas(paramConfig);
        Paint localPaint = new Paint(6);
        ((Canvas)localObject1).drawBitmap(paramString, new Rect(0, 0, paramString.getWidth(), paramString.getHeight()), new Rect(0, 0, paramInt1, paramInt2), localPaint);
        paramString.recycle();
        return paramConfig;
      }
      return paramString;
    }
    catch (OutOfMemoryError paramString)
    {
      for (;;)
      {
        paramString = localObject3;
      }
    }
  }
  
  public static Bitmap decodeSampleBitmap(Context paramContext, String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (paramString.startsWith("assets://")) {
      return decodeSampleBitmapFromAssets(paramContext, getRealPath(paramString), paramInt);
    }
    if (bitmapExists(paramString)) {
      return decodeSampledBitmapFromFile(paramString, paramInt);
    }
    return null;
  }
  
  public static Bitmap decodeSampleBitmap(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (paramString.startsWith("assets://")) {
      return decodeSampledBitmapFromAssets(paramContext, getRealPath(paramString), paramInt1, paramInt2);
    }
    if (bitmapExists(paramString)) {
      return decodeSampledBitmapFromFile(paramString, paramInt1, paramInt2);
    }
    return null;
  }
  
  /* Error */
  public static Bitmap decodeSampleBitmapFromAssets(Context paramContext, String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 172	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: istore_3
    //   5: aconst_null
    //   6: astore 6
    //   8: aconst_null
    //   9: astore 4
    //   11: aconst_null
    //   12: astore 5
    //   14: iload_3
    //   15: ifne +208 -> 223
    //   18: aload_0
    //   19: ifnonnull +5 -> 24
    //   22: aconst_null
    //   23: areturn
    //   24: aload_0
    //   25: invokevirtual 492	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   28: astore_0
    //   29: aload_0
    //   30: aload_1
    //   31: invokevirtual 497	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   34: astore 7
    //   36: new 223	android/graphics/BitmapFactory$Options
    //   39: dup
    //   40: invokespecial 458	android/graphics/BitmapFactory$Options:<init>	()V
    //   43: astore 8
    //   45: aload 8
    //   47: iconst_0
    //   48: putfield 500	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   51: aload 8
    //   53: iload_2
    //   54: putfield 503	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   57: aload 7
    //   59: aconst_null
    //   60: aload 8
    //   62: invokestatic 507	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   65: astore_0
    //   66: aload_0
    //   67: astore_1
    //   68: aload 7
    //   70: ifnull +128 -> 198
    //   73: aload 7
    //   75: invokevirtual 510	java/io/InputStream:close	()V
    //   78: aload_0
    //   79: areturn
    //   80: astore_0
    //   81: goto +119 -> 200
    //   84: aload 8
    //   86: aload 8
    //   88: getfield 503	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   91: iconst_1
    //   92: ishl
    //   93: putfield 503	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   96: aload 7
    //   98: invokevirtual 513	java/io/InputStream:reset	()V
    //   101: aload 7
    //   103: aconst_null
    //   104: aload 8
    //   106: invokestatic 507	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   109: astore_0
    //   110: goto +126 -> 236
    //   113: astore_0
    //   114: goto +4 -> 118
    //   117: astore_0
    //   118: getstatic 118	com/tencent/ttpic/baseutils/bitmap/BitmapUtils:TAG	Ljava/lang/String;
    //   121: aload_0
    //   122: invokevirtual 516	java/lang/Throwable:toString	()Ljava/lang/String;
    //   125: invokestatic 140	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   128: ldc_w 518
    //   131: iconst_3
    //   132: anewarray 4	java/lang/Object
    //   135: dup
    //   136: iconst_0
    //   137: aload_1
    //   138: aastore
    //   139: dup
    //   140: iconst_1
    //   141: aload 8
    //   143: getfield 229	android/graphics/BitmapFactory$Options:outWidth	I
    //   146: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   149: aastore
    //   150: dup
    //   151: iconst_2
    //   152: aload 8
    //   154: getfield 226	android/graphics/BitmapFactory$Options:outHeight	I
    //   157: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   160: aastore
    //   161: invokestatic 158	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   164: invokestatic 164	com/tencent/ttpic/baseutils/report/ReportUtil:report	(Ljava/lang/String;)V
    //   167: aload 4
    //   169: astore_0
    //   170: goto +66 -> 236
    //   173: astore_0
    //   174: getstatic 118	com/tencent/ttpic/baseutils/bitmap/BitmapUtils:TAG	Ljava/lang/String;
    //   177: aload_0
    //   178: invokevirtual 519	java/lang/Exception:toString	()Ljava/lang/String;
    //   181: invokestatic 140	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   184: aload 6
    //   186: astore_1
    //   187: aload 7
    //   189: ifnull +9 -> 198
    //   192: aload 5
    //   194: astore_0
    //   195: goto -122 -> 73
    //   198: aload_1
    //   199: areturn
    //   200: aload 7
    //   202: ifnull +8 -> 210
    //   205: aload 7
    //   207: invokevirtual 510	java/io/InputStream:close	()V
    //   210: aload_0
    //   211: athrow
    //   212: astore_0
    //   213: getstatic 118	com/tencent/ttpic/baseutils/bitmap/BitmapUtils:TAG	Ljava/lang/String;
    //   216: aload_0
    //   217: invokevirtual 520	java/io/IOException:toString	()Ljava/lang/String;
    //   220: invokestatic 140	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   223: aconst_null
    //   224: areturn
    //   225: astore_0
    //   226: goto -142 -> 84
    //   229: astore_1
    //   230: aload_0
    //   231: areturn
    //   232: astore_1
    //   233: goto -23 -> 210
    //   236: aload_0
    //   237: astore_1
    //   238: aload 7
    //   240: ifnull -42 -> 198
    //   243: goto -170 -> 73
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	246	0	paramContext	Context
    //   0	246	1	paramString	String
    //   0	246	2	paramInt	int
    //   4	11	3	bool	boolean
    //   9	159	4	localObject1	Object
    //   12	181	5	localObject2	Object
    //   6	179	6	localObject3	Object
    //   34	205	7	localInputStream	InputStream
    //   43	110	8	localOptions	BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   57	66	80	finally
    //   84	96	80	finally
    //   96	110	80	finally
    //   118	167	80	finally
    //   174	184	80	finally
    //   96	110	113	java/lang/OutOfMemoryError
    //   96	110	117	java/io/IOException
    //   57	66	173	java/lang/Exception
    //   29	36	212	java/io/IOException
    //   57	66	225	java/lang/OutOfMemoryError
    //   73	78	229	java/io/IOException
    //   205	210	232	java/io/IOException
  }
  
  public static Bitmap decodeSampleBitmapFromOption(Context paramContext, String paramString, int paramInt1, int paramInt2, BitmapFactory.Options paramOptions)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (paramOptions == null) {
      return decodeSampleBitmap(paramContext, paramString, paramInt1, paramInt2);
    }
    if (paramString.startsWith("assets://")) {
      return decodeSampledBitmapFromAssets(paramContext, getRealPath(paramString), paramOptions);
    }
    if (bitmapExists(paramString)) {
      return decodeSampledBitmapFromFile(paramString, paramOptions);
    }
    return null;
  }
  
  /* Error */
  public static Bitmap decodeSampledBitmapFromAssets(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 172	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: istore 4
    //   6: aconst_null
    //   7: astore 6
    //   9: iload 4
    //   11: ifne +251 -> 262
    //   14: aload_0
    //   15: ifnonnull +5 -> 20
    //   18: aconst_null
    //   19: areturn
    //   20: aload_0
    //   21: invokevirtual 492	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   24: astore_0
    //   25: aload_0
    //   26: aload_1
    //   27: invokevirtual 497	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   30: astore 5
    //   32: goto +51 -> 83
    //   35: new 120	java/lang/StringBuilder
    //   38: dup
    //   39: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   42: astore 5
    //   44: aload 5
    //   46: aload_1
    //   47: iconst_0
    //   48: aload_1
    //   49: bipush 46
    //   51: invokevirtual 533	java/lang/String:lastIndexOf	(I)I
    //   54: iconst_1
    //   55: iadd
    //   56: invokevirtual 537	java/lang/String:substring	(II)Ljava/lang/String;
    //   59: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: pop
    //   63: aload 5
    //   65: ldc_w 539
    //   68: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: pop
    //   72: aload_0
    //   73: aload 5
    //   75: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: invokevirtual 497	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   81: astore 5
    //   83: new 223	android/graphics/BitmapFactory$Options
    //   86: dup
    //   87: invokespecial 458	android/graphics/BitmapFactory$Options:<init>	()V
    //   90: astore 7
    //   92: aload 7
    //   94: iconst_1
    //   95: putfield 500	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   98: aload 5
    //   100: aconst_null
    //   101: aload 7
    //   103: invokestatic 507	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   106: pop
    //   107: aload 7
    //   109: aload 7
    //   111: iload_2
    //   112: iload_3
    //   113: iconst_1
    //   114: invokestatic 541	com/tencent/ttpic/baseutils/bitmap/BitmapUtils:calculateInSampleSizeNew	(Landroid/graphics/BitmapFactory$Options;IIZ)I
    //   117: putfield 503	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   120: aload 7
    //   122: iconst_0
    //   123: putfield 500	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   126: aload 5
    //   128: invokevirtual 513	java/io/InputStream:reset	()V
    //   131: aload 5
    //   133: aconst_null
    //   134: aload 7
    //   136: invokestatic 507	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   139: astore_0
    //   140: goto +100 -> 240
    //   143: aload 7
    //   145: aload 7
    //   147: getfield 503	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   150: iconst_1
    //   151: ishl
    //   152: putfield 503	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   155: aload 5
    //   157: invokevirtual 513	java/io/InputStream:reset	()V
    //   160: aload 5
    //   162: aconst_null
    //   163: aload 7
    //   165: invokestatic 507	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   168: astore_0
    //   169: goto +71 -> 240
    //   172: astore_0
    //   173: goto +4 -> 177
    //   176: astore_0
    //   177: getstatic 118	com/tencent/ttpic/baseutils/bitmap/BitmapUtils:TAG	Ljava/lang/String;
    //   180: aload_0
    //   181: invokestatic 544	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   184: ldc_w 518
    //   187: iconst_3
    //   188: anewarray 4	java/lang/Object
    //   191: dup
    //   192: iconst_0
    //   193: aload_1
    //   194: aastore
    //   195: dup
    //   196: iconst_1
    //   197: aload 7
    //   199: getfield 229	android/graphics/BitmapFactory$Options:outWidth	I
    //   202: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   205: aastore
    //   206: dup
    //   207: iconst_2
    //   208: aload 7
    //   210: getfield 226	android/graphics/BitmapFactory$Options:outHeight	I
    //   213: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   216: aastore
    //   217: invokestatic 158	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   220: invokestatic 164	com/tencent/ttpic/baseutils/report/ReportUtil:report	(Ljava/lang/String;)V
    //   223: aload 6
    //   225: astore_0
    //   226: goto +14 -> 240
    //   229: astore_0
    //   230: getstatic 118	com/tencent/ttpic/baseutils/bitmap/BitmapUtils:TAG	Ljava/lang/String;
    //   233: aload_0
    //   234: invokestatic 544	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   237: aload 6
    //   239: astore_0
    //   240: aload 5
    //   242: invokestatic 445	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   245: aload_0
    //   246: areturn
    //   247: astore_0
    //   248: getstatic 118	com/tencent/ttpic/baseutils/bitmap/BitmapUtils:TAG	Ljava/lang/String;
    //   251: ldc_w 546
    //   254: aload_0
    //   255: iconst_0
    //   256: anewarray 4	java/lang/Object
    //   259: invokestatic 550	com/tencent/ttpic/baseutils/log/LogUtils:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;[Ljava/lang/Object;)V
    //   262: aconst_null
    //   263: areturn
    //   264: astore 5
    //   266: goto -231 -> 35
    //   269: astore_0
    //   270: goto -127 -> 143
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	273	0	paramContext	Context
    //   0	273	1	paramString	String
    //   0	273	2	paramInt1	int
    //   0	273	3	paramInt2	int
    //   4	6	4	bool	boolean
    //   30	211	5	localObject1	Object
    //   264	1	5	localIOException	java.io.IOException
    //   7	231	6	localObject2	Object
    //   90	119	7	localOptions	BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   155	169	172	java/lang/OutOfMemoryError
    //   155	169	176	java/io/IOException
    //   126	140	229	java/io/IOException
    //   35	83	247	java/io/IOException
    //   25	32	264	java/io/IOException
    //   126	140	269	java/lang/OutOfMemoryError
  }
  
  /* Error */
  public static Bitmap decodeSampledBitmapFromAssets(Context paramContext, String paramString, BitmapFactory.Options paramOptions)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 172	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: istore_3
    //   5: aconst_null
    //   6: astore 5
    //   8: iload_3
    //   9: ifne +202 -> 211
    //   12: aload_0
    //   13: ifnonnull +5 -> 18
    //   16: aconst_null
    //   17: areturn
    //   18: aload_0
    //   19: invokevirtual 492	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   22: astore_0
    //   23: aload_0
    //   24: aload_1
    //   25: invokevirtual 497	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   28: astore 4
    //   30: goto +51 -> 81
    //   33: new 120	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   40: astore 4
    //   42: aload 4
    //   44: aload_1
    //   45: iconst_0
    //   46: aload_1
    //   47: bipush 46
    //   49: invokevirtual 533	java/lang/String:lastIndexOf	(I)I
    //   52: iconst_1
    //   53: iadd
    //   54: invokevirtual 537	java/lang/String:substring	(II)Ljava/lang/String;
    //   57: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: pop
    //   61: aload 4
    //   63: ldc_w 539
    //   66: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: pop
    //   70: aload_0
    //   71: aload 4
    //   73: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   76: invokevirtual 497	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   79: astore 4
    //   81: aload 4
    //   83: invokevirtual 513	java/io/InputStream:reset	()V
    //   86: aload 4
    //   88: aconst_null
    //   89: aload_2
    //   90: invokestatic 507	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   93: astore_0
    //   94: goto +95 -> 189
    //   97: aload_2
    //   98: aload_2
    //   99: getfield 503	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   102: iconst_1
    //   103: ishl
    //   104: putfield 503	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   107: aload 4
    //   109: invokevirtual 513	java/io/InputStream:reset	()V
    //   112: aload 4
    //   114: aconst_null
    //   115: aload_2
    //   116: invokestatic 507	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   119: astore_0
    //   120: goto +69 -> 189
    //   123: astore_0
    //   124: goto +4 -> 128
    //   127: astore_0
    //   128: getstatic 118	com/tencent/ttpic/baseutils/bitmap/BitmapUtils:TAG	Ljava/lang/String;
    //   131: aload_0
    //   132: invokestatic 544	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   135: ldc_w 518
    //   138: iconst_3
    //   139: anewarray 4	java/lang/Object
    //   142: dup
    //   143: iconst_0
    //   144: aload_1
    //   145: aastore
    //   146: dup
    //   147: iconst_1
    //   148: aload_2
    //   149: getfield 229	android/graphics/BitmapFactory$Options:outWidth	I
    //   152: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   155: aastore
    //   156: dup
    //   157: iconst_2
    //   158: aload_2
    //   159: getfield 226	android/graphics/BitmapFactory$Options:outHeight	I
    //   162: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   165: aastore
    //   166: invokestatic 158	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   169: invokestatic 164	com/tencent/ttpic/baseutils/report/ReportUtil:report	(Ljava/lang/String;)V
    //   172: aload 5
    //   174: astore_0
    //   175: goto +14 -> 189
    //   178: astore_0
    //   179: getstatic 118	com/tencent/ttpic/baseutils/bitmap/BitmapUtils:TAG	Ljava/lang/String;
    //   182: aload_0
    //   183: invokestatic 544	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   186: aload 5
    //   188: astore_0
    //   189: aload 4
    //   191: invokestatic 445	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   194: aload_0
    //   195: areturn
    //   196: astore_0
    //   197: getstatic 118	com/tencent/ttpic/baseutils/bitmap/BitmapUtils:TAG	Ljava/lang/String;
    //   200: ldc_w 546
    //   203: aload_0
    //   204: iconst_0
    //   205: anewarray 4	java/lang/Object
    //   208: invokestatic 550	com/tencent/ttpic/baseutils/log/LogUtils:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;[Ljava/lang/Object;)V
    //   211: aconst_null
    //   212: areturn
    //   213: astore 4
    //   215: goto -182 -> 33
    //   218: astore_0
    //   219: goto -122 -> 97
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	222	0	paramContext	Context
    //   0	222	1	paramString	String
    //   0	222	2	paramOptions	BitmapFactory.Options
    //   4	5	3	bool	boolean
    //   28	162	4	localObject1	Object
    //   213	1	4	localIOException	java.io.IOException
    //   6	181	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   107	120	123	java/lang/OutOfMemoryError
    //   107	120	127	java/io/IOException
    //   81	94	178	java/io/IOException
    //   33	81	196	java/io/IOException
    //   23	30	213	java/io/IOException
    //   81	94	218	java/lang/OutOfMemoryError
  }
  
  public static Bitmap decodeSampledBitmapFromFile(String paramString, int paramInt)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inSampleSize = paramInt;
    localOptions.inJustDecodeBounds = false;
    try
    {
      localBitmap = BitmapFactory.decodeFile(paramString, localOptions);
      return localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError2)
    {
      Bitmap localBitmap;
      label26:
      break label26;
    }
    localOptions.inSampleSize <<= 1;
    try
    {
      localBitmap = BitmapFactory.decodeFile(paramString, localOptions);
      return localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError1)
    {
      LogUtils.e(TAG, localOutOfMemoryError1.toString());
      ReportUtil.report(String.format("OutOfMemoryError! path = %s, width = %d, height = %d.", new Object[] { paramString, Integer.valueOf(localOptions.outWidth), Integer.valueOf(localOptions.outHeight) }));
      return null;
    }
  }
  
  public static Bitmap decodeSampledBitmapFromFile(String paramString, int paramInt1, int paramInt2)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions);
    localOptions.inSampleSize = calculateInSampleSizeNew(localOptions, paramInt1, paramInt2, true);
    localOptions.inJustDecodeBounds = false;
    ApiHelper.hasHoneycomb();
    try
    {
      localBitmap = BitmapFactory.decodeFile(paramString, localOptions);
      return localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError2)
    {
      Bitmap localBitmap;
      label49:
      break label49;
    }
    localOptions.inSampleSize <<= 1;
    try
    {
      localBitmap = BitmapFactory.decodeFile(paramString, localOptions);
      return localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError1)
    {
      LogUtils.e(localOutOfMemoryError1);
      ReportUtil.report(String.format("OutOfMemoryError! path = %s, width = %d, height = %d.", new Object[] { paramString, Integer.valueOf(localOptions.outWidth), Integer.valueOf(localOptions.outHeight) }));
      return null;
    }
  }
  
  public static Bitmap decodeSampledBitmapFromFile(String paramString, BitmapFactory.Options paramOptions)
  {
    try
    {
      localBitmap = BitmapFactory.decodeFile(paramString, paramOptions);
      return localBitmap;
    }
    catch (Exception paramString)
    {
      Bitmap localBitmap;
      LogUtils.e(paramString);
      return null;
      paramOptions.inSampleSize <<= 1;
      try
      {
        localBitmap = BitmapFactory.decodeFile(paramString, paramOptions);
        return localBitmap;
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        LogUtils.e(localOutOfMemoryError1);
        ReportUtil.report(String.format("OutOfMemoryError! path = %s, width = %d, height = %d.", new Object[] { paramString, Integer.valueOf(paramOptions.outWidth), Integer.valueOf(paramOptions.outHeight) }));
        return null;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError2)
    {
      label15:
      break label15;
    }
  }
  
  public static Bitmap decodeSampledBitmapFromFileCheckExif(String paramString, int paramInt1, int paramInt2)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions);
    localOptions.inSampleSize = calculateInSampleSizeNew(localOptions, paramInt1, paramInt2, true);
    localOptions.inJustDecodeBounds = false;
    paramInt1 = getDegreeByExif(paramString) % 360;
    try
    {
      localBitmap2 = BitmapFactory.decodeFile(paramString, localOptions);
      localBitmap1 = localBitmap2;
      if (paramInt1 == 0) {}
    }
    catch (OutOfMemoryError localOutOfMemoryError1)
    {
      Bitmap localBitmap2;
      Bitmap localBitmap1;
      label74:
      break label74;
    }
    try
    {
      localBitmap1 = rotateBitmap(localBitmap2, paramInt1);
      return localBitmap1;
    }
    catch (OutOfMemoryError localOutOfMemoryError2)
    {
      OutOfMemoryError localOutOfMemoryError3 = localOutOfMemoryError4;
      break label76;
    }
    localBitmap1 = null;
    label76:
    localOptions.inSampleSize <<= 1;
    try
    {
      localBitmap2 = BitmapFactory.decodeFile(paramString, localOptions);
      localBitmap1 = localBitmap2;
      if (paramInt1 != 0)
      {
        localBitmap1 = localBitmap2;
        localBitmap2 = rotateBitmap(localBitmap2, paramInt1);
        return localBitmap2;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError4)
    {
      LogUtils.e(localOutOfMemoryError4);
      ReportUtil.report(String.format("OutOfMemoryError! path = %s, width = %d, height = %d.", new Object[] { paramString, Integer.valueOf(localOptions.outWidth), Integer.valueOf(localOptions.outHeight) }));
    }
    return localBitmap1;
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
    catch (Exception paramResources)
    {
      LogUtils.e(paramResources);
    }
    return null;
  }
  
  /* Error */
  public static String getBase64FromBitmap(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +16 -> 17
    //   4: getstatic 118	com/tencent/ttpic/baseutils/bitmap/BitmapUtils:TAG	Ljava/lang/String;
    //   7: ldc_w 578
    //   10: invokestatic 419	com/tencent/ttpic/baseutils/log/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   13: ldc_w 546
    //   16: areturn
    //   17: new 189	java/io/ByteArrayOutputStream
    //   20: dup
    //   21: invokespecial 190	java/io/ByteArrayOutputStream:<init>	()V
    //   24: astore_3
    //   25: aload_0
    //   26: getstatic 309	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   29: iload_2
    //   30: aload_3
    //   31: invokevirtual 200	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   34: pop
    //   35: aload_3
    //   36: invokevirtual 206	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   39: iload_1
    //   40: invokestatic 584	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   43: astore_0
    //   44: aload_3
    //   45: invokevirtual 209	java/io/ByteArrayOutputStream:close	()V
    //   48: aload_0
    //   49: areturn
    //   50: astore_3
    //   51: aload_3
    //   52: invokestatic 212	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   55: aload_0
    //   56: areturn
    //   57: goto +8 -> 65
    //   60: goto +28 -> 88
    //   63: aconst_null
    //   64: astore_3
    //   65: aload_3
    //   66: ifnull +16 -> 82
    //   69: aload_3
    //   70: invokevirtual 209	java/io/ByteArrayOutputStream:close	()V
    //   73: ldc_w 546
    //   76: areturn
    //   77: astore_0
    //   78: aload_0
    //   79: invokestatic 212	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   82: ldc_w 546
    //   85: areturn
    //   86: aconst_null
    //   87: astore_3
    //   88: aload_3
    //   89: ifnull +16 -> 105
    //   92: aload_3
    //   93: invokevirtual 209	java/io/ByteArrayOutputStream:close	()V
    //   96: ldc_w 546
    //   99: areturn
    //   100: astore_0
    //   101: aload_0
    //   102: invokestatic 212	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   105: ldc_w 546
    //   108: areturn
    //   109: astore_0
    //   110: goto -24 -> 86
    //   113: astore_0
    //   114: goto -51 -> 63
    //   117: astore_0
    //   118: goto -58 -> 60
    //   121: astore_0
    //   122: goto -65 -> 57
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	125	0	paramBitmap	Bitmap
    //   0	125	1	paramInt1	int
    //   0	125	2	paramInt2	int
    //   24	21	3	localByteArrayOutputStream	ByteArrayOutputStream
    //   50	2	3	localIOException	java.io.IOException
    //   64	29	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   44	48	50	java/io/IOException
    //   69	73	77	java/io/IOException
    //   92	96	100	java/io/IOException
    //   17	25	109	java/lang/Exception
    //   17	25	113	finally
    //   25	44	117	java/lang/Exception
    //   25	44	121	finally
  }
  
  public static Bitmap getBitmapFromEncryptedFile(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      if (paramString.startsWith("assets://")) {
        paramString = paramContext.getAssets().open(FileUtils.getRealPath(paramString));
      } else {
        paramString = new FileInputStream(paramString);
      }
      paramContext = FileEncryptUtils.decryptFile(paramString);
      try
      {
        IOUtils.closeQuietly(paramString);
      }
      catch (Exception paramString) {}
      LogUtils.e("BitmapUtils", "decodeBitmap  getStream", paramString, new Object[0]);
    }
    catch (Exception paramString)
    {
      paramContext = null;
    }
    if (paramContext == null) {
      return null;
    }
    paramString = new BitmapFactory.Options();
    paramString.inPreferredConfig = Bitmap.Config.ARGB_8888;
    try
    {
      paramContext = BitmapFactory.decodeByteArray(paramContext, 0, paramContext.length, paramString);
      return paramContext;
    }
    catch (OutOfMemoryError paramContext)
    {
      LogUtils.e("BitmapUtils", "decodeByteArray", paramContext, new Object[0]);
    }
    return null;
  }
  
  public static Point getBitmapSize(Context paramContext, String paramString)
  {
    if (paramString.startsWith("assets://")) {
      return getBitmapSizeFromAssets(paramContext, getRealPath(paramString));
    }
    return getBitmapSizeFromFile(paramString);
  }
  
  /* Error */
  private static Point getBitmapSizeFromAssets(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: new 605	android/graphics/Point
    //   3: dup
    //   4: iconst_0
    //   5: iconst_0
    //   6: invokespecial 608	android/graphics/Point:<init>	(II)V
    //   9: astore 4
    //   11: aload_1
    //   12: invokestatic 172	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   15: ifeq +6 -> 21
    //   18: aload 4
    //   20: areturn
    //   21: aload_0
    //   22: invokevirtual 492	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   25: astore_2
    //   26: aconst_null
    //   27: astore_3
    //   28: aconst_null
    //   29: astore_0
    //   30: aload_2
    //   31: aload_1
    //   32: invokevirtual 497	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   35: astore_1
    //   36: new 223	android/graphics/BitmapFactory$Options
    //   39: dup
    //   40: invokespecial 458	android/graphics/BitmapFactory$Options:<init>	()V
    //   43: astore_0
    //   44: aload_0
    //   45: iconst_1
    //   46: putfield 500	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   49: aload_1
    //   50: aconst_null
    //   51: aload_0
    //   52: invokestatic 507	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   55: pop
    //   56: new 605	android/graphics/Point
    //   59: dup
    //   60: aload_0
    //   61: getfield 229	android/graphics/BitmapFactory$Options:outWidth	I
    //   64: aload_0
    //   65: getfield 226	android/graphics/BitmapFactory$Options:outHeight	I
    //   68: invokespecial 608	android/graphics/Point:<init>	(II)V
    //   71: astore_0
    //   72: aload_1
    //   73: ifnull +14 -> 87
    //   76: aload_1
    //   77: invokevirtual 510	java/io/InputStream:close	()V
    //   80: aload_0
    //   81: areturn
    //   82: astore_1
    //   83: aload_1
    //   84: invokevirtual 609	java/io/IOException:printStackTrace	()V
    //   87: aload_0
    //   88: areturn
    //   89: astore_0
    //   90: goto +49 -> 139
    //   93: astore_2
    //   94: goto +14 -> 108
    //   97: astore_2
    //   98: aload_0
    //   99: astore_1
    //   100: aload_2
    //   101: astore_0
    //   102: goto +37 -> 139
    //   105: astore_2
    //   106: aload_3
    //   107: astore_1
    //   108: aload_1
    //   109: astore_0
    //   110: getstatic 118	com/tencent/ttpic/baseutils/bitmap/BitmapUtils:TAG	Ljava/lang/String;
    //   113: aload_2
    //   114: invokevirtual 520	java/io/IOException:toString	()Ljava/lang/String;
    //   117: invokestatic 140	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   120: aload_1
    //   121: ifnull +15 -> 136
    //   124: aload_1
    //   125: invokevirtual 510	java/io/InputStream:close	()V
    //   128: aload 4
    //   130: areturn
    //   131: astore_0
    //   132: aload_0
    //   133: invokevirtual 609	java/io/IOException:printStackTrace	()V
    //   136: aload 4
    //   138: areturn
    //   139: aload_1
    //   140: ifnull +15 -> 155
    //   143: aload_1
    //   144: invokevirtual 510	java/io/InputStream:close	()V
    //   147: goto +8 -> 155
    //   150: astore_1
    //   151: aload_1
    //   152: invokevirtual 609	java/io/IOException:printStackTrace	()V
    //   155: aload_0
    //   156: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	157	0	paramContext	Context
    //   0	157	1	paramString	String
    //   25	6	2	localAssetManager	AssetManager
    //   93	1	2	localIOException1	java.io.IOException
    //   97	4	2	localObject1	Object
    //   105	9	2	localIOException2	java.io.IOException
    //   27	80	3	localObject2	Object
    //   9	128	4	localPoint	Point
    // Exception table:
    //   from	to	target	type
    //   76	80	82	java/io/IOException
    //   36	72	89	finally
    //   36	72	93	java/io/IOException
    //   30	36	97	finally
    //   110	120	97	finally
    //   30	36	105	java/io/IOException
    //   124	128	131	java/io/IOException
    //   143	147	150	java/io/IOException
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
    if (Build.VERSION.SDK_INT > 19) {}
    try
    {
      int i = paramBitmap.getAllocationByteCount();
      return i;
    }
    catch (NullPointerException localNullPointerException)
    {
      label21:
      break label21;
    }
    if (Build.VERSION.SDK_INT >= 12) {
      return paramBitmap.getByteCount();
    }
    return paramBitmap.getWidth() * paramBitmap.getRowBytes();
  }
  
  public static int getDegreeByExif(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0;
    }
    try
    {
      int i = getDegreeByOrientation(new ExifInterface(paramString).getAttributeInt("Orientation", 0));
      return i;
    }
    catch (Exception paramString) {}
    return 0;
  }
  
  public static int getDegreeByOrientation(int paramInt)
  {
    if (paramInt != 3)
    {
      if (paramInt != 6)
      {
        if (paramInt != 8) {
          return 0;
        }
        return 270;
      }
      return 90;
    }
    return 180;
  }
  
  /* Error */
  public static Bitmap getImageFromPathWithDecode(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 172	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: istore_3
    //   5: aconst_null
    //   6: astore 4
    //   8: iload_3
    //   9: ifeq +5 -> 14
    //   12: aconst_null
    //   13: areturn
    //   14: sipush 960
    //   17: istore_2
    //   18: aload_1
    //   19: ldc 41
    //   21: invokevirtual 175	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   24: istore_3
    //   25: iload_3
    //   26: ifeq +64 -> 90
    //   29: new 428	java/io/FileInputStream
    //   32: dup
    //   33: aload_1
    //   34: invokespecial 429	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   37: astore_0
    //   38: goto +120 -> 158
    //   41: new 120	java/lang/StringBuilder
    //   44: dup
    //   45: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   48: astore_0
    //   49: aload_0
    //   50: aload_1
    //   51: iconst_0
    //   52: aload_1
    //   53: bipush 46
    //   55: invokevirtual 533	java/lang/String:lastIndexOf	(I)I
    //   58: iconst_1
    //   59: iadd
    //   60: invokevirtual 537	java/lang/String:substring	(II)Ljava/lang/String;
    //   63: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: pop
    //   67: aload_0
    //   68: ldc_w 539
    //   71: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: pop
    //   75: new 428	java/io/FileInputStream
    //   78: dup
    //   79: aload_0
    //   80: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: invokespecial 429	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   86: astore_0
    //   87: goto +71 -> 158
    //   90: aload_0
    //   91: invokevirtual 492	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   94: aload_1
    //   95: invokevirtual 497	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   98: astore 5
    //   100: aload 5
    //   102: astore_0
    //   103: goto +55 -> 158
    //   106: new 120	java/lang/StringBuilder
    //   109: dup
    //   110: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   113: astore 5
    //   115: aload 5
    //   117: aload_1
    //   118: iconst_0
    //   119: aload_1
    //   120: bipush 46
    //   122: invokevirtual 533	java/lang/String:lastIndexOf	(I)I
    //   125: iconst_1
    //   126: iadd
    //   127: invokevirtual 537	java/lang/String:substring	(II)Ljava/lang/String;
    //   130: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: pop
    //   134: aload 5
    //   136: ldc_w 539
    //   139: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: pop
    //   143: aload 5
    //   145: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   148: astore_1
    //   149: aload_0
    //   150: invokevirtual 492	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   153: aload_1
    //   154: invokevirtual 497	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   157: astore_0
    //   158: aload_0
    //   159: ifnull +177 -> 336
    //   162: aload_0
    //   163: invokestatic 439	com/tencent/ttpic/baseutils/encrypt/FileEncryptUtils:decryptFile	(Ljava/io/InputStream;)[B
    //   166: astore 4
    //   168: new 223	android/graphics/BitmapFactory$Options
    //   171: dup
    //   172: invokespecial 458	android/graphics/BitmapFactory$Options:<init>	()V
    //   175: astore 5
    //   177: aload 5
    //   179: getstatic 77	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   182: putfield 294	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   185: aload 5
    //   187: iconst_1
    //   188: putfield 500	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   191: aload 4
    //   193: iconst_0
    //   194: aload 4
    //   196: arraylength
    //   197: aload 5
    //   199: invokestatic 461	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   202: pop
    //   203: aload 5
    //   205: aload 5
    //   207: iload_2
    //   208: iload_2
    //   209: iconst_0
    //   210: invokestatic 541	com/tencent/ttpic/baseutils/bitmap/BitmapUtils:calculateInSampleSizeNew	(Landroid/graphics/BitmapFactory$Options;IIZ)I
    //   213: putfield 503	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   216: aload 5
    //   218: iconst_0
    //   219: putfield 500	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   222: aload 5
    //   224: iconst_1
    //   225: putfield 639	android/graphics/BitmapFactory$Options:inPreferQualityOverSpeed	Z
    //   228: aload 4
    //   230: iconst_0
    //   231: aload 4
    //   233: arraylength
    //   234: aload 5
    //   236: invokestatic 461	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   239: astore_1
    //   240: aload_0
    //   241: invokestatic 445	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   244: aload_1
    //   245: ifnonnull +9 -> 254
    //   248: aload_0
    //   249: invokestatic 445	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   252: aconst_null
    //   253: areturn
    //   254: aload_1
    //   255: invokevirtual 318	android/graphics/Bitmap:getConfig	()Landroid/graphics/Bitmap$Config;
    //   258: astore 4
    //   260: getstatic 77	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   263: astore 5
    //   265: aload 4
    //   267: aload 5
    //   269: if_acmpne +9 -> 278
    //   272: aload_0
    //   273: invokestatic 445	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   276: aload_1
    //   277: areturn
    //   278: aload_1
    //   279: getstatic 77	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   282: iconst_0
    //   283: invokevirtual 321	android/graphics/Bitmap:copy	(Landroid/graphics/Bitmap$Config;Z)Landroid/graphics/Bitmap;
    //   286: astore 4
    //   288: aload 4
    //   290: aload_1
    //   291: if_acmpeq +8 -> 299
    //   294: aload_1
    //   295: invokestatic 641	com/tencent/ttpic/baseutils/bitmap/BitmapUtils:recycle	(Landroid/graphics/Bitmap;)Z
    //   298: pop
    //   299: aload_0
    //   300: invokestatic 445	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   303: aload 4
    //   305: areturn
    //   306: astore_1
    //   307: aload_0
    //   308: invokestatic 445	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   311: aload_1
    //   312: athrow
    //   313: iload_2
    //   314: i2f
    //   315: ldc_w 642
    //   318: fdiv
    //   319: f2i
    //   320: istore_2
    //   321: aload_0
    //   322: invokestatic 445	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   325: goto -140 -> 185
    //   328: astore_1
    //   329: goto +34 -> 363
    //   332: astore_1
    //   333: goto +19 -> 352
    //   336: aload_0
    //   337: invokestatic 445	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   340: aconst_null
    //   341: areturn
    //   342: astore_1
    //   343: aload 4
    //   345: astore_0
    //   346: goto +17 -> 363
    //   349: astore_1
    //   350: aconst_null
    //   351: astore_0
    //   352: aload_1
    //   353: invokestatic 212	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   356: aload_0
    //   357: invokestatic 445	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   360: aconst_null
    //   361: areturn
    //   362: astore_1
    //   363: aload_0
    //   364: invokestatic 445	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   367: goto +5 -> 372
    //   370: aload_1
    //   371: athrow
    //   372: goto -2 -> 370
    //   375: astore_0
    //   376: goto -335 -> 41
    //   379: astore 5
    //   381: goto -275 -> 106
    //   384: astore_1
    //   385: goto -72 -> 313
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	388	0	paramContext	Context
    //   0	388	1	paramString	String
    //   17	304	2	i	int
    //   4	22	3	bool	boolean
    //   6	338	4	localObject1	Object
    //   98	170	5	localObject2	Object
    //   379	1	5	localIOException	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   185	240	306	finally
    //   162	185	328	finally
    //   240	244	328	finally
    //   254	265	328	finally
    //   278	288	328	finally
    //   294	299	328	finally
    //   307	313	328	finally
    //   313	325	328	finally
    //   162	185	332	java/lang/Exception
    //   240	244	332	java/lang/Exception
    //   254	265	332	java/lang/Exception
    //   278	288	332	java/lang/Exception
    //   294	299	332	java/lang/Exception
    //   307	313	332	java/lang/Exception
    //   313	325	332	java/lang/Exception
    //   18	25	342	finally
    //   29	38	342	finally
    //   41	87	342	finally
    //   90	100	342	finally
    //   106	158	342	finally
    //   18	25	349	java/lang/Exception
    //   29	38	349	java/lang/Exception
    //   41	87	349	java/lang/Exception
    //   90	100	349	java/lang/Exception
    //   106	158	349	java/lang/Exception
    //   352	356	362	finally
    //   29	38	375	java/io/IOException
    //   90	100	379	java/io/IOException
    //   185	240	384	java/lang/OutOfMemoryError
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
    int j = i;
    paramInt2 = paramInt1;
    if (k != 90) {
      if (k == 270)
      {
        j = i;
        paramInt2 = paramInt1;
      }
      else
      {
        paramInt2 = i;
        j = paramInt1;
      }
    }
    return new int[] { j, paramInt2 };
  }
  
  /* Error */
  public static InputStream getInputStreamByName(String paramString)
  {
    // Byte code:
    //   0: invokestatic 656	com/tencent/ttpic/AEBaseConfig:getContext	()Landroid/content/Context;
    //   3: invokevirtual 492	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   6: astore_1
    //   7: aload_1
    //   8: aload_0
    //   9: invokevirtual 497	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   12: astore_2
    //   13: aload_2
    //   14: areturn
    //   15: astore_0
    //   16: goto +43 -> 59
    //   19: new 120	java/lang/StringBuilder
    //   22: dup
    //   23: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   26: astore_2
    //   27: aload_2
    //   28: ldc 11
    //   30: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: pop
    //   34: aload_2
    //   35: getstatic 262	java/io/File:separator	Ljava/lang/String;
    //   38: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: pop
    //   42: aload_2
    //   43: aload_0
    //   44: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: pop
    //   48: aload_1
    //   49: aload_2
    //   50: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: invokevirtual 497	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   56: astore_0
    //   57: aload_0
    //   58: areturn
    //   59: aload_0
    //   60: athrow
    //   61: aconst_null
    //   62: areturn
    //   63: astore_2
    //   64: goto -45 -> 19
    //   67: astore_0
    //   68: goto -7 -> 61
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	71	0	paramString	String
    //   6	43	1	localAssetManager	AssetManager
    //   12	38	2	localObject	Object
    //   63	1	2	localIOException	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   7	13	15	finally
    //   19	57	15	finally
    //   7	13	63	java/io/IOException
    //   19	57	67	java/io/IOException
  }
  
  private static BitmapUtils.Size getNewSize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    float f2 = paramInt3;
    float f1 = paramInt1;
    float f3 = f2 / f1;
    float f4 = paramInt4;
    f2 = paramInt2;
    f3 = Math.min(f3, f4 / f2);
    BitmapUtils.Size localSize;
    if (f3 < 1.0D) {
      localSize = new BitmapUtils.Size((int)(f1 * f3), (int)(f2 * f3));
    } else {
      localSize = new BitmapUtils.Size(paramInt1, paramInt2);
    }
    localSize.width = Math.max(localSize.width, 1);
    localSize.height = Math.max(localSize.height, 1);
    return localSize;
  }
  
  public static String getRealPath(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    String str = paramString;
    if (paramString.startsWith("assets://")) {
      str = paramString.substring(9);
    }
    return str;
  }
  
  public static boolean isLegal(Bitmap paramBitmap)
  {
    return (paramBitmap != null) && (!paramBitmap.isRecycled());
  }
  
  private static boolean isPowerOf2(int paramInt)
  {
    return (paramInt & paramInt - 1) == 0;
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
    return (paramString != null) && ((paramString.equalsIgnoreCase("image/jpeg")) || (paramString.equalsIgnoreCase("image/png")) || (paramString.equalsIgnoreCase("image/gif")));
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
  
  public static Bitmap resizeBySidesRange(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    int i;
    int j;
    if (paramBitmap.getHeight() / paramBitmap.getWidth() >= 1.0D)
    {
      i = paramBitmap.getHeight();
      j = paramBitmap.getWidth();
    }
    else
    {
      i = paramBitmap.getWidth();
      j = paramBitmap.getHeight();
    }
    if ((j < paramInt1) && (i < paramInt2)) {
      return paramBitmap;
    }
    BitmapUtils.Size localSize = getNewSize(j, i, paramInt1, paramInt2);
    return Bitmap.createScaledBitmap(paramBitmap, localSize.width, localSize.height, false);
  }
  
  public static Bitmap rotateBitmap(Bitmap paramBitmap, int paramInt)
  {
    return rotateBitmap(paramBitmap, paramInt, true);
  }
  
  public static Bitmap rotateBitmap(Bitmap paramBitmap, int paramInt, boolean paramBoolean)
  {
    if (paramBitmap != null)
    {
      Object localObject = new Matrix();
      ((Matrix)localObject).setRotate(paramInt, paramBitmap.getWidth() / 2.0F, paramBitmap.getHeight() / 2.0F);
      try
      {
        localObject = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), (Matrix)localObject, true);
        if (paramBitmap != localObject)
        {
          if (paramBoolean) {
            paramBitmap.recycle();
          }
          return localObject;
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        localOutOfMemoryError.printStackTrace();
      }
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
    //   4: astore 4
    //   6: aconst_null
    //   7: astore_3
    //   8: aload_3
    //   9: astore_2
    //   10: new 177	java/io/File
    //   13: dup
    //   14: aload_1
    //   15: invokespecial 179	java/io/File:<init>	(Ljava/lang/String;)V
    //   18: astore 6
    //   20: aload_3
    //   21: astore_2
    //   22: aload 6
    //   24: invokevirtual 711	java/io/File:getParentFile	()Ljava/io/File;
    //   27: astore 7
    //   29: aload_3
    //   30: astore_2
    //   31: aload 7
    //   33: invokevirtual 183	java/io/File:exists	()Z
    //   36: ifne +11 -> 47
    //   39: aload_3
    //   40: astore_2
    //   41: aload 7
    //   43: invokevirtual 259	java/io/File:mkdirs	()Z
    //   46: pop
    //   47: aload_3
    //   48: astore_2
    //   49: aload 6
    //   51: invokevirtual 183	java/io/File:exists	()Z
    //   54: ifne +11 -> 65
    //   57: aload_3
    //   58: astore_2
    //   59: aload 6
    //   61: invokevirtual 277	java/io/File:createNewFile	()Z
    //   64: pop
    //   65: aload_3
    //   66: astore_2
    //   67: new 279	java/io/FileOutputStream
    //   70: dup
    //   71: aload_1
    //   72: invokespecial 712	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   75: astore_3
    //   76: aload_0
    //   77: ifnull +40 -> 117
    //   80: aload_0
    //   81: getstatic 309	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   84: bipush 99
    //   86: aload_3
    //   87: invokevirtual 200	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   90: pop
    //   91: aload_3
    //   92: invokevirtual 715	java/io/FileOutputStream:flush	()V
    //   95: goto +22 -> 117
    //   98: astore_0
    //   99: aload_3
    //   100: astore_2
    //   101: goto +113 -> 214
    //   104: astore_2
    //   105: aload_2
    //   106: astore 4
    //   108: goto +26 -> 134
    //   111: astore_1
    //   112: aload_3
    //   113: astore_0
    //   114: goto +82 -> 196
    //   117: aload_3
    //   118: invokestatic 718	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   121: getstatic 724	com/tencent/ttpic/baseutils/bitmap/BitmapUtils$SAVE_STATUS:SAVE_SUCCESS	Lcom/tencent/ttpic/baseutils/bitmap/BitmapUtils$SAVE_STATUS;
    //   124: areturn
    //   125: astore_0
    //   126: goto +88 -> 214
    //   129: astore 4
    //   131: aload 5
    //   133: astore_3
    //   134: aload_3
    //   135: astore_2
    //   136: aload 4
    //   138: invokestatic 212	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   141: aload_3
    //   142: astore_2
    //   143: ldc_w 726
    //   146: iconst_3
    //   147: anewarray 4	java/lang/Object
    //   150: dup
    //   151: iconst_0
    //   152: aload_1
    //   153: aastore
    //   154: dup
    //   155: iconst_1
    //   156: aload_0
    //   157: invokevirtual 145	android/graphics/Bitmap:getWidth	()I
    //   160: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   163: aastore
    //   164: dup
    //   165: iconst_2
    //   166: aload_0
    //   167: invokevirtual 154	android/graphics/Bitmap:getHeight	()I
    //   170: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   173: aastore
    //   174: invokestatic 158	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   177: invokestatic 164	com/tencent/ttpic/baseutils/report/ReportUtil:report	(Ljava/lang/String;)V
    //   180: aload_3
    //   181: astore_2
    //   182: getstatic 729	com/tencent/ttpic/baseutils/bitmap/BitmapUtils$SAVE_STATUS:SAVE_OOM	Lcom/tencent/ttpic/baseutils/bitmap/BitmapUtils$SAVE_STATUS;
    //   185: astore_0
    //   186: aload_3
    //   187: invokestatic 718	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   190: aload_0
    //   191: areturn
    //   192: astore_1
    //   193: aload 4
    //   195: astore_0
    //   196: aload_0
    //   197: astore_2
    //   198: aload_1
    //   199: invokestatic 212	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   202: aload_0
    //   203: astore_2
    //   204: getstatic 732	com/tencent/ttpic/baseutils/bitmap/BitmapUtils$SAVE_STATUS:SAVE_FAILED	Lcom/tencent/ttpic/baseutils/bitmap/BitmapUtils$SAVE_STATUS;
    //   207: astore_1
    //   208: aload_0
    //   209: invokestatic 718	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   212: aload_1
    //   213: areturn
    //   214: aload_2
    //   215: invokestatic 718	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   218: aload_0
    //   219: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	220	0	paramBitmap	Bitmap
    //   0	220	1	paramString	String
    //   9	92	2	localObject1	Object
    //   104	2	2	localOutOfMemoryError1	OutOfMemoryError
    //   135	80	2	localObject2	Object
    //   7	180	3	localObject3	Object
    //   4	103	4	localObject4	Object
    //   129	65	4	localOutOfMemoryError2	OutOfMemoryError
    //   1	131	5	localObject5	Object
    //   18	42	6	localFile1	File
    //   27	15	7	localFile2	File
    // Exception table:
    //   from	to	target	type
    //   80	95	98	finally
    //   80	95	104	java/lang/OutOfMemoryError
    //   80	95	111	java/lang/Exception
    //   10	20	125	finally
    //   22	29	125	finally
    //   31	39	125	finally
    //   41	47	125	finally
    //   49	57	125	finally
    //   59	65	125	finally
    //   67	76	125	finally
    //   136	141	125	finally
    //   143	180	125	finally
    //   182	186	125	finally
    //   198	202	125	finally
    //   204	208	125	finally
    //   10	20	129	java/lang/OutOfMemoryError
    //   22	29	129	java/lang/OutOfMemoryError
    //   31	39	129	java/lang/OutOfMemoryError
    //   41	47	129	java/lang/OutOfMemoryError
    //   49	57	129	java/lang/OutOfMemoryError
    //   59	65	129	java/lang/OutOfMemoryError
    //   67	76	129	java/lang/OutOfMemoryError
    //   10	20	192	java/lang/Exception
    //   22	29	192	java/lang/Exception
    //   31	39	192	java/lang/Exception
    //   41	47	192	java/lang/Exception
    //   49	57	192	java/lang/Exception
    //   59	65	192	java/lang/Exception
    //   67	76	192	java/lang/Exception
  }
  
  /* Error */
  public static File saveBitmap(Context paramContext, Bitmap paramBitmap, String paramString1, String paramString2, Bitmap.CompressFormat paramCompressFormat, String paramString3)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 10
    //   3: aconst_null
    //   4: astore 9
    //   6: aload_2
    //   7: ifnonnull +31 -> 38
    //   10: aload_2
    //   11: astore 8
    //   13: aload_0
    //   14: ifnull +55 -> 69
    //   17: aload_0
    //   18: invokevirtual 736	android/content/Context:getCacheDir	()Ljava/io/File;
    //   21: astore_0
    //   22: aload_2
    //   23: astore 8
    //   25: aload_0
    //   26: ifnull +43 -> 69
    //   29: aload_0
    //   30: invokevirtual 252	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   33: astore 8
    //   35: goto +34 -> 69
    //   38: new 177	java/io/File
    //   41: dup
    //   42: aload_2
    //   43: invokespecial 179	java/io/File:<init>	(Ljava/lang/String;)V
    //   46: astore_0
    //   47: aload_2
    //   48: astore 8
    //   50: aload_0
    //   51: invokevirtual 739	java/io/File:isDirectory	()Z
    //   54: ifne +15 -> 69
    //   57: aload_2
    //   58: astore 8
    //   60: aload_0
    //   61: invokevirtual 259	java/io/File:mkdirs	()Z
    //   64: ifne +5 -> 69
    //   67: aconst_null
    //   68: areturn
    //   69: iconst_0
    //   70: istore 6
    //   72: aload 4
    //   74: getstatic 196	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   77: if_acmpne +33 -> 110
    //   80: new 120	java/lang/StringBuilder
    //   83: dup
    //   84: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   87: astore_0
    //   88: aload_0
    //   89: aload_3
    //   90: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: pop
    //   94: aload_0
    //   95: ldc_w 741
    //   98: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: pop
    //   102: aload_0
    //   103: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   106: astore_0
    //   107: goto +28 -> 135
    //   110: new 120	java/lang/StringBuilder
    //   113: dup
    //   114: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   117: astore_0
    //   118: aload_0
    //   119: aload_3
    //   120: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: pop
    //   124: aload_0
    //   125: ldc_w 743
    //   128: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: pop
    //   132: goto -30 -> 102
    //   135: new 177	java/io/File
    //   138: dup
    //   139: aload 8
    //   141: aload_0
    //   142: invokespecial 745	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   145: astore_3
    //   146: new 279	java/io/FileOutputStream
    //   149: dup
    //   150: aload_3
    //   151: invokespecial 282	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   154: astore_0
    //   155: aload_0
    //   156: astore_2
    //   157: aload 4
    //   159: getstatic 309	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   162: if_acmpne +23 -> 185
    //   165: aload 5
    //   167: ifnull +18 -> 185
    //   170: aload_0
    //   171: astore_2
    //   172: aload 5
    //   174: invokevirtual 748	java/lang/String:length	()I
    //   177: ifle +8 -> 185
    //   180: aload_3
    //   181: astore_1
    //   182: goto +61 -> 243
    //   185: aload_0
    //   186: astore_2
    //   187: aload_1
    //   188: aload 4
    //   190: bipush 99
    //   192: aload_0
    //   193: invokevirtual 200	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   196: istore 7
    //   198: aload_3
    //   199: astore_1
    //   200: iload 7
    //   202: istore 6
    //   204: goto +39 -> 243
    //   207: astore_2
    //   208: aload_3
    //   209: astore_1
    //   210: aload_2
    //   211: astore_3
    //   212: goto +25 -> 237
    //   215: astore_2
    //   216: aconst_null
    //   217: astore_0
    //   218: aload_3
    //   219: astore_1
    //   220: aload_2
    //   221: astore_3
    //   222: goto +15 -> 237
    //   225: astore_0
    //   226: aload 10
    //   228: astore_2
    //   229: goto +31 -> 260
    //   232: astore_3
    //   233: aconst_null
    //   234: astore_0
    //   235: aload_0
    //   236: astore_1
    //   237: aload_0
    //   238: astore_2
    //   239: aload_3
    //   240: invokestatic 212	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   243: aload_0
    //   244: invokestatic 718	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   247: aload 9
    //   249: astore_0
    //   250: iload 6
    //   252: ifeq +5 -> 257
    //   255: aload_1
    //   256: astore_0
    //   257: aload_0
    //   258: areturn
    //   259: astore_0
    //   260: aload_2
    //   261: invokestatic 718	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   264: goto +5 -> 269
    //   267: aload_0
    //   268: athrow
    //   269: goto -2 -> 267
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	272	0	paramContext	Context
    //   0	272	1	paramBitmap	Bitmap
    //   0	272	2	paramString1	String
    //   0	272	3	paramString2	String
    //   0	272	4	paramCompressFormat	Bitmap.CompressFormat
    //   0	272	5	paramString3	String
    //   70	181	6	i	int
    //   196	5	7	bool	boolean
    //   11	129	8	str	String
    //   4	244	9	localObject1	Object
    //   1	226	10	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   157	165	207	java/lang/Exception
    //   172	180	207	java/lang/Exception
    //   187	198	207	java/lang/Exception
    //   146	155	215	java/lang/Exception
    //   72	102	225	finally
    //   102	107	225	finally
    //   110	132	225	finally
    //   135	146	225	finally
    //   146	155	225	finally
    //   72	102	232	java/lang/Exception
    //   102	107	232	java/lang/Exception
    //   110	132	232	java/lang/Exception
    //   135	146	232	java/lang/Exception
    //   157	165	259	finally
    //   172	180	259	finally
    //   187	198	259	finally
    //   239	243	259	finally
  }
  
  /* Error */
  public static BitmapUtils.SAVE_STATUS saveBitmap2JPG(Bitmap paramBitmap, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: aconst_null
    //   7: astore_3
    //   8: aload_3
    //   9: astore_2
    //   10: new 177	java/io/File
    //   13: dup
    //   14: aload_1
    //   15: invokespecial 179	java/io/File:<init>	(Ljava/lang/String;)V
    //   18: astore 6
    //   20: aload_3
    //   21: astore_2
    //   22: aload 6
    //   24: invokevirtual 711	java/io/File:getParentFile	()Ljava/io/File;
    //   27: astore 7
    //   29: aload_3
    //   30: astore_2
    //   31: aload 7
    //   33: invokevirtual 183	java/io/File:exists	()Z
    //   36: ifne +11 -> 47
    //   39: aload_3
    //   40: astore_2
    //   41: aload 7
    //   43: invokevirtual 259	java/io/File:mkdirs	()Z
    //   46: pop
    //   47: aload_3
    //   48: astore_2
    //   49: aload 6
    //   51: invokevirtual 183	java/io/File:exists	()Z
    //   54: ifne +11 -> 65
    //   57: aload_3
    //   58: astore_2
    //   59: aload 6
    //   61: invokevirtual 277	java/io/File:createNewFile	()Z
    //   64: pop
    //   65: aload_3
    //   66: astore_2
    //   67: new 279	java/io/FileOutputStream
    //   70: dup
    //   71: aload_1
    //   72: invokespecial 712	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   75: astore_3
    //   76: aload_0
    //   77: ifnull +40 -> 117
    //   80: aload_0
    //   81: getstatic 309	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   84: bipush 99
    //   86: aload_3
    //   87: invokevirtual 200	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   90: pop
    //   91: aload_3
    //   92: invokevirtual 715	java/io/FileOutputStream:flush	()V
    //   95: goto +22 -> 117
    //   98: astore_0
    //   99: aload_3
    //   100: astore_2
    //   101: goto +113 -> 214
    //   104: astore_2
    //   105: aload_2
    //   106: astore 4
    //   108: goto +26 -> 134
    //   111: astore_1
    //   112: aload_3
    //   113: astore_0
    //   114: goto +82 -> 196
    //   117: aload_3
    //   118: invokestatic 718	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   121: getstatic 724	com/tencent/ttpic/baseutils/bitmap/BitmapUtils$SAVE_STATUS:SAVE_SUCCESS	Lcom/tencent/ttpic/baseutils/bitmap/BitmapUtils$SAVE_STATUS;
    //   124: areturn
    //   125: astore_0
    //   126: goto +88 -> 214
    //   129: astore 4
    //   131: aload 5
    //   133: astore_3
    //   134: aload_3
    //   135: astore_2
    //   136: aload 4
    //   138: invokestatic 212	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   141: aload_3
    //   142: astore_2
    //   143: ldc_w 518
    //   146: iconst_3
    //   147: anewarray 4	java/lang/Object
    //   150: dup
    //   151: iconst_0
    //   152: aload_1
    //   153: aastore
    //   154: dup
    //   155: iconst_1
    //   156: aload_0
    //   157: invokevirtual 145	android/graphics/Bitmap:getWidth	()I
    //   160: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   163: aastore
    //   164: dup
    //   165: iconst_2
    //   166: aload_0
    //   167: invokevirtual 154	android/graphics/Bitmap:getHeight	()I
    //   170: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   173: aastore
    //   174: invokestatic 158	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   177: invokestatic 164	com/tencent/ttpic/baseutils/report/ReportUtil:report	(Ljava/lang/String;)V
    //   180: aload_3
    //   181: astore_2
    //   182: getstatic 729	com/tencent/ttpic/baseutils/bitmap/BitmapUtils$SAVE_STATUS:SAVE_OOM	Lcom/tencent/ttpic/baseutils/bitmap/BitmapUtils$SAVE_STATUS;
    //   185: astore_0
    //   186: aload_3
    //   187: invokestatic 718	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   190: aload_0
    //   191: areturn
    //   192: astore_1
    //   193: aload 4
    //   195: astore_0
    //   196: aload_0
    //   197: astore_2
    //   198: aload_1
    //   199: invokestatic 212	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   202: aload_0
    //   203: astore_2
    //   204: getstatic 732	com/tencent/ttpic/baseutils/bitmap/BitmapUtils$SAVE_STATUS:SAVE_FAILED	Lcom/tencent/ttpic/baseutils/bitmap/BitmapUtils$SAVE_STATUS;
    //   207: astore_1
    //   208: aload_0
    //   209: invokestatic 718	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   212: aload_1
    //   213: areturn
    //   214: aload_2
    //   215: invokestatic 718	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   218: aload_0
    //   219: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	220	0	paramBitmap	Bitmap
    //   0	220	1	paramString	String
    //   9	92	2	localObject1	Object
    //   104	2	2	localOutOfMemoryError1	OutOfMemoryError
    //   135	80	2	localObject2	Object
    //   7	180	3	localObject3	Object
    //   4	103	4	localObject4	Object
    //   129	65	4	localOutOfMemoryError2	OutOfMemoryError
    //   1	131	5	localObject5	Object
    //   18	42	6	localFile1	File
    //   27	15	7	localFile2	File
    // Exception table:
    //   from	to	target	type
    //   80	95	98	finally
    //   80	95	104	java/lang/OutOfMemoryError
    //   80	95	111	java/lang/Exception
    //   10	20	125	finally
    //   22	29	125	finally
    //   31	39	125	finally
    //   41	47	125	finally
    //   49	57	125	finally
    //   59	65	125	finally
    //   67	76	125	finally
    //   136	141	125	finally
    //   143	180	125	finally
    //   182	186	125	finally
    //   198	202	125	finally
    //   204	208	125	finally
    //   10	20	129	java/lang/OutOfMemoryError
    //   22	29	129	java/lang/OutOfMemoryError
    //   31	39	129	java/lang/OutOfMemoryError
    //   41	47	129	java/lang/OutOfMemoryError
    //   49	57	129	java/lang/OutOfMemoryError
    //   59	65	129	java/lang/OutOfMemoryError
    //   67	76	129	java/lang/OutOfMemoryError
    //   10	20	192	java/lang/Exception
    //   22	29	192	java/lang/Exception
    //   31	39	192	java/lang/Exception
    //   41	47	192	java/lang/Exception
    //   49	57	192	java/lang/Exception
    //   59	65	192	java/lang/Exception
    //   67	76	192	java/lang/Exception
  }
  
  /* Error */
  public static byte[] saveBitmap2JpgByteArray(Bitmap paramBitmap)
  {
    // Byte code:
    //   0: iconst_0
    //   1: newarray byte
    //   3: astore 4
    //   5: aconst_null
    //   6: astore_3
    //   7: aconst_null
    //   8: astore_2
    //   9: new 189	java/io/ByteArrayOutputStream
    //   12: dup
    //   13: invokespecial 190	java/io/ByteArrayOutputStream:<init>	()V
    //   16: astore_1
    //   17: aload 4
    //   19: astore_2
    //   20: aload_1
    //   21: astore_3
    //   22: aload_0
    //   23: ifnull +48 -> 71
    //   26: aload_1
    //   27: astore_2
    //   28: aload_0
    //   29: getstatic 196	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   32: bipush 99
    //   34: aload_1
    //   35: invokevirtual 200	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   38: pop
    //   39: aload_1
    //   40: astore_2
    //   41: aload_1
    //   42: invokevirtual 751	java/io/ByteArrayOutputStream:flush	()V
    //   45: aload_1
    //   46: astore_2
    //   47: aload_1
    //   48: invokevirtual 206	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   51: astore_3
    //   52: aload_3
    //   53: astore_2
    //   54: aload_1
    //   55: astore_3
    //   56: goto +15 -> 71
    //   59: astore_3
    //   60: goto +24 -> 84
    //   63: astore_2
    //   64: aload_1
    //   65: astore_0
    //   66: aload_2
    //   67: astore_1
    //   68: goto +72 -> 140
    //   71: aload_3
    //   72: invokestatic 718	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   75: aload_2
    //   76: areturn
    //   77: astore_0
    //   78: goto +75 -> 153
    //   81: astore_3
    //   82: aconst_null
    //   83: astore_1
    //   84: aload_1
    //   85: astore_2
    //   86: aload_3
    //   87: invokestatic 212	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   90: aload_1
    //   91: astore_2
    //   92: ldc_w 753
    //   95: iconst_2
    //   96: anewarray 4	java/lang/Object
    //   99: dup
    //   100: iconst_0
    //   101: aload_0
    //   102: invokevirtual 145	android/graphics/Bitmap:getWidth	()I
    //   105: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   108: aastore
    //   109: dup
    //   110: iconst_1
    //   111: aload_0
    //   112: invokevirtual 154	android/graphics/Bitmap:getHeight	()I
    //   115: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   118: aastore
    //   119: invokestatic 158	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   122: invokestatic 164	com/tencent/ttpic/baseutils/report/ReportUtil:report	(Ljava/lang/String;)V
    //   125: aload 4
    //   127: astore_2
    //   128: aload_1
    //   129: astore_3
    //   130: goto -59 -> 71
    //   133: astore_0
    //   134: goto +19 -> 153
    //   137: astore_1
    //   138: aload_3
    //   139: astore_0
    //   140: aload_0
    //   141: astore_2
    //   142: aload_1
    //   143: invokestatic 212	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   146: aload_0
    //   147: invokestatic 718	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   150: aload 4
    //   152: areturn
    //   153: aload_2
    //   154: invokestatic 718	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   157: goto +5 -> 162
    //   160: aload_0
    //   161: athrow
    //   162: goto -2 -> 160
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	165	0	paramBitmap	Bitmap
    //   16	113	1	localObject1	Object
    //   137	6	1	localException1	Exception
    //   8	46	2	localObject2	Object
    //   63	13	2	localException2	Exception
    //   85	69	2	localObject3	Object
    //   6	50	3	localObject4	Object
    //   59	13	3	localOutOfMemoryError1	OutOfMemoryError
    //   81	6	3	localOutOfMemoryError2	OutOfMemoryError
    //   129	10	3	localObject5	Object
    //   3	148	4	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   28	39	59	java/lang/OutOfMemoryError
    //   41	45	59	java/lang/OutOfMemoryError
    //   47	52	59	java/lang/OutOfMemoryError
    //   28	39	63	java/lang/Exception
    //   41	45	63	java/lang/Exception
    //   47	52	63	java/lang/Exception
    //   9	17	77	finally
    //   142	146	77	finally
    //   9	17	81	java/lang/OutOfMemoryError
    //   28	39	133	finally
    //   41	45	133	finally
    //   47	52	133	finally
    //   86	90	133	finally
    //   92	125	133	finally
    //   9	17	137	java/lang/Exception
  }
  
  /* Error */
  public static BitmapUtils.SAVE_STATUS saveBitmap2PNG(Bitmap paramBitmap, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: aconst_null
    //   7: astore_3
    //   8: aload_3
    //   9: astore_2
    //   10: new 177	java/io/File
    //   13: dup
    //   14: aload_1
    //   15: invokespecial 179	java/io/File:<init>	(Ljava/lang/String;)V
    //   18: astore 6
    //   20: aload_3
    //   21: astore_2
    //   22: aload 6
    //   24: invokevirtual 711	java/io/File:getParentFile	()Ljava/io/File;
    //   27: astore 7
    //   29: aload_3
    //   30: astore_2
    //   31: aload 7
    //   33: invokevirtual 183	java/io/File:exists	()Z
    //   36: ifne +11 -> 47
    //   39: aload_3
    //   40: astore_2
    //   41: aload 7
    //   43: invokevirtual 259	java/io/File:mkdirs	()Z
    //   46: pop
    //   47: aload_3
    //   48: astore_2
    //   49: aload 6
    //   51: invokevirtual 183	java/io/File:exists	()Z
    //   54: ifne +11 -> 65
    //   57: aload_3
    //   58: astore_2
    //   59: aload 6
    //   61: invokevirtual 277	java/io/File:createNewFile	()Z
    //   64: pop
    //   65: aload_3
    //   66: astore_2
    //   67: new 279	java/io/FileOutputStream
    //   70: dup
    //   71: aload_1
    //   72: invokespecial 712	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   75: astore_3
    //   76: aload_0
    //   77: ifnull +40 -> 117
    //   80: aload_0
    //   81: getstatic 196	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   84: bipush 99
    //   86: aload_3
    //   87: invokevirtual 200	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   90: pop
    //   91: aload_3
    //   92: invokevirtual 715	java/io/FileOutputStream:flush	()V
    //   95: goto +22 -> 117
    //   98: astore_0
    //   99: aload_3
    //   100: astore_2
    //   101: goto +113 -> 214
    //   104: astore_2
    //   105: aload_2
    //   106: astore 4
    //   108: goto +26 -> 134
    //   111: astore_1
    //   112: aload_3
    //   113: astore_0
    //   114: goto +82 -> 196
    //   117: aload_3
    //   118: invokestatic 718	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   121: getstatic 724	com/tencent/ttpic/baseutils/bitmap/BitmapUtils$SAVE_STATUS:SAVE_SUCCESS	Lcom/tencent/ttpic/baseutils/bitmap/BitmapUtils$SAVE_STATUS;
    //   124: areturn
    //   125: astore_0
    //   126: goto +88 -> 214
    //   129: astore 4
    //   131: aload 5
    //   133: astore_3
    //   134: aload_3
    //   135: astore_2
    //   136: aload 4
    //   138: invokestatic 212	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   141: aload_3
    //   142: astore_2
    //   143: ldc_w 518
    //   146: iconst_3
    //   147: anewarray 4	java/lang/Object
    //   150: dup
    //   151: iconst_0
    //   152: aload_1
    //   153: aastore
    //   154: dup
    //   155: iconst_1
    //   156: aload_0
    //   157: invokevirtual 145	android/graphics/Bitmap:getWidth	()I
    //   160: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   163: aastore
    //   164: dup
    //   165: iconst_2
    //   166: aload_0
    //   167: invokevirtual 154	android/graphics/Bitmap:getHeight	()I
    //   170: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   173: aastore
    //   174: invokestatic 158	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   177: invokestatic 164	com/tencent/ttpic/baseutils/report/ReportUtil:report	(Ljava/lang/String;)V
    //   180: aload_3
    //   181: astore_2
    //   182: getstatic 729	com/tencent/ttpic/baseutils/bitmap/BitmapUtils$SAVE_STATUS:SAVE_OOM	Lcom/tencent/ttpic/baseutils/bitmap/BitmapUtils$SAVE_STATUS;
    //   185: astore_0
    //   186: aload_3
    //   187: invokestatic 718	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   190: aload_0
    //   191: areturn
    //   192: astore_1
    //   193: aload 4
    //   195: astore_0
    //   196: aload_0
    //   197: astore_2
    //   198: aload_1
    //   199: invokestatic 212	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   202: aload_0
    //   203: astore_2
    //   204: getstatic 732	com/tencent/ttpic/baseutils/bitmap/BitmapUtils$SAVE_STATUS:SAVE_FAILED	Lcom/tencent/ttpic/baseutils/bitmap/BitmapUtils$SAVE_STATUS;
    //   207: astore_1
    //   208: aload_0
    //   209: invokestatic 718	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   212: aload_1
    //   213: areturn
    //   214: aload_2
    //   215: invokestatic 718	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   218: aload_0
    //   219: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	220	0	paramBitmap	Bitmap
    //   0	220	1	paramString	String
    //   9	92	2	localObject1	Object
    //   104	2	2	localOutOfMemoryError1	OutOfMemoryError
    //   135	80	2	localObject2	Object
    //   7	180	3	localObject3	Object
    //   4	103	4	localObject4	Object
    //   129	65	4	localOutOfMemoryError2	OutOfMemoryError
    //   1	131	5	localObject5	Object
    //   18	42	6	localFile1	File
    //   27	15	7	localFile2	File
    // Exception table:
    //   from	to	target	type
    //   80	95	98	finally
    //   80	95	104	java/lang/OutOfMemoryError
    //   80	95	111	java/lang/Exception
    //   10	20	125	finally
    //   22	29	125	finally
    //   31	39	125	finally
    //   41	47	125	finally
    //   49	57	125	finally
    //   59	65	125	finally
    //   67	76	125	finally
    //   136	141	125	finally
    //   143	180	125	finally
    //   182	186	125	finally
    //   198	202	125	finally
    //   204	208	125	finally
    //   10	20	129	java/lang/OutOfMemoryError
    //   22	29	129	java/lang/OutOfMemoryError
    //   31	39	129	java/lang/OutOfMemoryError
    //   41	47	129	java/lang/OutOfMemoryError
    //   49	57	129	java/lang/OutOfMemoryError
    //   59	65	129	java/lang/OutOfMemoryError
    //   67	76	129	java/lang/OutOfMemoryError
    //   10	20	192	java/lang/Exception
    //   22	29	192	java/lang/Exception
    //   31	39	192	java/lang/Exception
    //   41	47	192	java/lang/Exception
    //   49	57	192	java/lang/Exception
    //   59	65	192	java/lang/Exception
    //   67	76	192	java/lang/Exception
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.baseutils.bitmap.BitmapUtils
 * JD-Core Version:    0.7.0.1
 */