package com.tencent.util;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;

public class BitmapUtils
{
  public static final int DEFAULT_COMPRESS_QUALITY = 90;
  private static final int DEFAULT_SIZE = 1000;
  private static final int DEFAULT_SIZE_SMALL = 500;
  private static final String[] IMAGE_PROJECTION = { "orientation" };
  private static final int INDEX_ORIENTATION = 0;
  private static final String[] PATH_PROJECTION = { "_data" };
  private static final String TAG = "BitmapUtils";
  private static final float[] mMatrixValues = new float[16];
  private static final float[] mTempMatrix = new float[32];
  private final Context context;
  
  public BitmapUtils(Context paramContext)
  {
    this.context = paramContext;
  }
  
  private void closeStream(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable)
    {
      paramCloseable.printStackTrace();
    }
  }
  
  private static int computeInitialSampleSize(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    double d1 = paramOptions.outWidth;
    double d2 = paramOptions.outHeight;
    int i;
    int j;
    if (paramInt2 < 0)
    {
      i = 1;
      if (paramInt1 >= 0) {
        break label58;
      }
      j = 128;
      label29:
      if (j >= i) {
        break label82;
      }
    }
    label58:
    label82:
    do
    {
      return i;
      i = (int)Math.ceil(Math.sqrt(d1 * d2 / paramInt2));
      break;
      j = (int)Math.min(Math.floor(d1 / paramInt1), Math.floor(d2 / paramInt1));
      break label29;
      if ((paramInt2 < 0) && (paramInt1 < 0)) {
        return 1;
      }
    } while (paramInt1 < 0);
    return j;
  }
  
  public static int computeSampleSize(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int i = computeInitialSampleSize(paramOptions, paramInt1, paramInt2);
    if (i <= 8)
    {
      paramInt1 = 1;
      for (;;)
      {
        paramInt2 = paramInt1;
        if (paramInt1 >= i) {
          break;
        }
        paramInt1 <<= 1;
      }
    }
    paramInt2 = (i + 7) / 8 * 8;
    return paramInt2;
  }
  
  public static int computeSampleSizeLarger(int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt1 = Math.max(paramInt1 / paramInt3, paramInt2 / paramInt3);
    if (paramInt1 <= 1) {
      return 1;
    }
    if (paramInt1 <= 8) {
      return prevPowerOf2(paramInt1);
    }
    return paramInt1 / 8 * 8;
  }
  
  public static int computeSampleSizeSmaller(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int k = 1000;
    if (paramBoolean) {
      k = 500;
    }
    int m = Math.max(paramInt1 / k, paramInt2 / k);
    if (m <= 8)
    {
      int i = 1;
      for (;;)
      {
        j = i;
        if (i >= m) {
          break;
        }
        i <<= 1;
      }
    }
    int j = (m + 7) / 8 * 8;
    while ((j > 0) && (Math.max(paramInt1 / j, paramInt2 / j) < k)) {
      j /= 2;
    }
    return j;
  }
  
  public static Bitmap createBitmap(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4, android.graphics.Matrix paramMatrix)
  {
    Canvas localCanvas = new Canvas();
    Object localObject2;
    Object localObject1;
    if ((paramMatrix == null) || (paramMatrix.isIdentity()))
    {
      localObject2 = Bitmap.createBitmap(paramInt3, paramInt4, paramBitmap.getConfig());
      localObject1 = null;
    }
    for (;;)
    {
      ((Bitmap)localObject2).setDensity(paramBitmap.getDensity());
      localCanvas.setBitmap((Bitmap)localObject2);
      localCanvas.drawBitmap(paramBitmap, new Rect(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4), new RectF(0.0F, 0.0F, paramInt3, paramInt4), (Paint)localObject1);
      return localObject2;
      localObject1 = new RectF(0.0F, 0.0F, paramInt3, paramInt4);
      paramMatrix.mapRect((RectF)localObject1);
      try
      {
        Bitmap localBitmap = Bitmap.createBitmap(Math.round(((RectF)localObject1).width()), Math.round(((RectF)localObject1).height()), paramBitmap.getConfig());
        localCanvas.translate(-((RectF)localObject1).left, -((RectF)localObject1).top);
        localCanvas.concat(paramMatrix);
        Paint localPaint = new Paint(2);
        localObject2 = localBitmap;
        localObject1 = localPaint;
        if (!paramMatrix.rectStaysRect())
        {
          localPaint.setAntiAlias(true);
          localObject2 = localBitmap;
          localObject1 = localPaint;
        }
      }
      catch (OutOfMemoryError paramBitmap)
      {
        paramBitmap.printStackTrace();
      }
    }
    return null;
  }
  
  public static Bitmap createBitmapSmaller(Bitmap paramBitmap, float paramFloat, android.graphics.Matrix paramMatrix)
  {
    int i = Math.round(paramBitmap.getWidth() * paramFloat);
    int j = Math.round(paramBitmap.getHeight() * paramFloat);
    if ((i == paramBitmap.getWidth()) && (j == paramBitmap.getHeight())) {
      return paramBitmap;
    }
    Bitmap localBitmap = Bitmap.createBitmap(i, j, getConfig(paramBitmap));
    Canvas localCanvas = new Canvas(localBitmap);
    localCanvas.scale(paramFloat, paramFloat);
    localCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, new Paint(6));
    if (paramMatrix != null)
    {
      paramBitmap = createBitmap(localBitmap, 0, 0, localBitmap.getWidth(), localBitmap.getHeight(), paramMatrix);
      localBitmap.recycle();
      return paramBitmap;
    }
    return localBitmap;
  }
  
  public static Bitmap createBitmapSmaller(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat, android.graphics.Matrix paramMatrix)
  {
    Canvas localCanvas = new Canvas();
    if ((paramMatrix == null) || (paramMatrix.isIdentity())) {
      paramMatrix = Bitmap.createBitmap(Math.round(paramInt3 * paramFloat), Math.round(paramInt4 * paramFloat), paramBitmap.getConfig());
    }
    Object localObject2;
    for (Object localObject1 = null;; localObject1 = localObject2)
    {
      localCanvas.setBitmap(paramMatrix);
      localCanvas.drawBitmap(paramBitmap, new Rect(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4), new RectF(0.0F, 0.0F, Math.round(paramInt4 * paramFloat), Math.round(paramInt3 * paramFloat)), (Paint)localObject1);
      return paramMatrix;
      localObject2 = new RectF(0.0F, 0.0F, Math.round(paramInt4 * paramFloat), Math.round(paramInt3 * paramFloat));
      paramMatrix.mapRect((RectF)localObject2);
      localObject1 = Bitmap.createBitmap(Math.round(((RectF)localObject2).height()), Math.round(((RectF)localObject2).width()), paramBitmap.getConfig());
      localCanvas.scale(paramFloat, paramFloat);
      localCanvas.translate(-((RectF)localObject2).left, -((RectF)localObject2).top);
      localCanvas.concat(paramMatrix);
      localObject2 = new Paint(6);
      paramMatrix = (android.graphics.Matrix)localObject1;
    }
  }
  
  public static Bitmap cropCenter(Bitmap paramBitmap, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    long l = System.currentTimeMillis();
    int k = paramBitmap.getWidth();
    int m = paramBitmap.getHeight();
    localObject1 = null;
    i = 0;
    try
    {
      localObject2 = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      localObject1 = localObject2;
      i = 1;
    }
    catch (OutOfMemoryError localOutOfMemoryError2)
    {
      Object localObject2;
      label40:
      int j;
      break label40;
    }
    j = i;
    localObject2 = localObject1;
    if (i == 0) {}
    try
    {
      localObject2 = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.RGB_565);
      j = 1;
    }
    catch (OutOfMemoryError localOutOfMemoryError1)
    {
      for (;;)
      {
        j = i;
        Object localObject3 = localObject1;
      }
    }
    if ((j == 0) || (localObject2 == null)) {
      return null;
    }
    localObject1 = new Canvas((Bitmap)localObject2);
    ((Canvas)localObject1).translate((paramInt1 - k) / 2, (paramInt2 - m) / 2);
    ((Canvas)localObject1).drawBitmap(paramBitmap, 0.0F, 0.0F, new Paint(2));
    if (paramBoolean) {
      paramBitmap.recycle();
    }
    LogUtil.d("BitmapUtils", "crop bitmap - " + (System.currentTimeMillis() - l));
    return localObject2;
  }
  
  public static Bitmap cropFromTop(Bitmap paramBitmap, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    long l = System.currentTimeMillis();
    int k = paramBitmap.getWidth();
    paramBitmap.getHeight();
    localObject1 = null;
    i = 0;
    try
    {
      localObject2 = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      localObject1 = localObject2;
      i = 1;
    }
    catch (OutOfMemoryError localOutOfMemoryError2)
    {
      Object localObject2;
      label39:
      int j;
      break label39;
    }
    j = i;
    localObject2 = localObject1;
    if (i == 0) {}
    try
    {
      localObject2 = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.RGB_565);
      j = 1;
    }
    catch (OutOfMemoryError localOutOfMemoryError1)
    {
      for (;;)
      {
        j = i;
        Object localObject3 = localObject1;
      }
    }
    if (j == 0) {
      return null;
    }
    localObject1 = new Canvas((Bitmap)localObject2);
    ((Canvas)localObject1).translate((paramInt1 - k) / 2, 0.0F);
    ((Canvas)localObject1).drawBitmap(paramBitmap, 0.0F, 0.0F, new Paint(2));
    if (paramBoolean) {
      paramBitmap.recycle();
    }
    LogUtil.d("BitmapUtils", "crop bitmap - " + (System.currentTimeMillis() - l));
    return localObject2;
  }
  
  public static Bitmap decodeBitmap(Resources paramResources, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inPreferredConfig = Bitmap.Config.ARGB_8888;
    paramResources = BitmapFactory.decodeResource(paramResources, paramInt1, (BitmapFactory.Options)localObject);
    localObject = Bitmap.createBitmap(paramInt2, paramInt3, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas((Bitmap)localObject);
    Paint localPaint = new Paint(6);
    localCanvas.drawBitmap(paramResources, new Rect(0, 0, paramResources.getWidth(), paramResources.getHeight()), new Rect(0, 0, paramInt2, paramInt3), localPaint);
    paramResources.recycle();
    return localObject;
  }
  
  /* Error */
  private Bitmap decodeBitmapWithoutResize(Uri paramUri)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 10
    //   3: iconst_1
    //   4: istore 6
    //   6: iconst_m1
    //   7: istore_2
    //   8: aconst_null
    //   9: astore 9
    //   11: iload_2
    //   12: istore_3
    //   13: iload_2
    //   14: istore 4
    //   16: iload_2
    //   17: istore 5
    //   19: aload_0
    //   20: aload_1
    //   21: invokespecial 281	com/tencent/util/BitmapUtils:getBitmapBounds	(Landroid/net/Uri;)Landroid/graphics/Rect;
    //   24: astore 11
    //   26: iload_2
    //   27: istore_3
    //   28: iload_2
    //   29: istore 4
    //   31: iload_2
    //   32: istore 5
    //   34: aload 11
    //   36: invokevirtual 283	android/graphics/Rect:width	()I
    //   39: istore 7
    //   41: iload_2
    //   42: istore_3
    //   43: iload_2
    //   44: istore 4
    //   46: iload_2
    //   47: istore 5
    //   49: aload 11
    //   51: invokevirtual 285	android/graphics/Rect:height	()I
    //   54: istore 8
    //   56: iload_2
    //   57: istore_3
    //   58: iload_2
    //   59: istore 4
    //   61: iload_2
    //   62: istore 5
    //   64: new 64	android/graphics/BitmapFactory$Options
    //   67: dup
    //   68: invokespecial 259	android/graphics/BitmapFactory$Options:<init>	()V
    //   71: astore 12
    //   73: iload_2
    //   74: iconst_m1
    //   75: if_icmpne +168 -> 243
    //   78: iload_2
    //   79: istore_3
    //   80: iload_2
    //   81: istore 4
    //   83: iload_2
    //   84: istore 5
    //   86: aload 12
    //   88: iload 7
    //   90: iload 8
    //   92: invokestatic 291	com/tencent/util/PhoneProperty:instance	()Lcom/tencent/util/PhoneProperty;
    //   95: invokevirtual 294	com/tencent/util/PhoneProperty:isUseSmallPicture	()Z
    //   98: invokestatic 296	com/tencent/util/BitmapUtils:computeSampleSizeSmaller	(IIZ)I
    //   101: putfield 299	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   104: iload_2
    //   105: istore_3
    //   106: iload_2
    //   107: istore 4
    //   109: iload_2
    //   110: istore 5
    //   112: aload 12
    //   114: getstatic 230	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   117: putfield 262	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   120: iload_2
    //   121: istore_3
    //   122: iload_2
    //   123: istore 4
    //   125: iload_2
    //   126: istore 5
    //   128: aload_1
    //   129: invokevirtual 304	android/net/Uri:getScheme	()Ljava/lang/String;
    //   132: invokevirtual 307	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   135: ldc_w 309
    //   138: invokevirtual 313	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   141: ifeq +138 -> 279
    //   144: iload_2
    //   145: istore_3
    //   146: iload_2
    //   147: istore 4
    //   149: iload_2
    //   150: istore 5
    //   152: new 315	java/io/FileInputStream
    //   155: dup
    //   156: aload_1
    //   157: invokevirtual 316	android/net/Uri:toString	()Ljava/lang/String;
    //   160: ldc_w 318
    //   163: invokevirtual 321	java/lang/String:length	()I
    //   166: invokevirtual 325	java/lang/String:substring	(I)Ljava/lang/String;
    //   169: invokespecial 328	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   172: astore 11
    //   174: aload 11
    //   176: astore 9
    //   178: aload 9
    //   180: aconst_null
    //   181: aload 12
    //   183: invokestatic 332	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   186: astore 11
    //   188: aload 11
    //   190: astore 10
    //   192: iconst_0
    //   193: istore_3
    //   194: aload_0
    //   195: aload 9
    //   197: invokespecial 334	com/tencent/util/BitmapUtils:closeStream	(Ljava/io/Closeable;)V
    //   200: iload_3
    //   201: ifne +168 -> 369
    //   204: aload 10
    //   206: astore_1
    //   207: aload 10
    //   209: ifnull +32 -> 241
    //   212: aload 10
    //   214: astore_1
    //   215: aload 10
    //   217: invokevirtual 120	android/graphics/Bitmap:getConfig	()Landroid/graphics/Bitmap$Config;
    //   220: getstatic 230	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   223: if_acmpeq +18 -> 241
    //   226: aload 10
    //   228: getstatic 230	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   231: iconst_1
    //   232: invokevirtual 338	android/graphics/Bitmap:copy	(Landroid/graphics/Bitmap$Config;Z)Landroid/graphics/Bitmap;
    //   235: astore_1
    //   236: aload 10
    //   238: invokevirtual 215	android/graphics/Bitmap:recycle	()V
    //   241: aload_1
    //   242: areturn
    //   243: iload_2
    //   244: iconst_2
    //   245: imul
    //   246: istore_2
    //   247: iload_2
    //   248: istore_3
    //   249: iload_2
    //   250: istore 4
    //   252: iload_2
    //   253: istore 5
    //   255: aload 12
    //   257: iload_2
    //   258: putfield 299	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   261: goto -157 -> 104
    //   264: astore 11
    //   266: iload_3
    //   267: istore_2
    //   268: iconst_0
    //   269: istore_3
    //   270: aload_0
    //   271: aload 9
    //   273: invokespecial 334	com/tencent/util/BitmapUtils:closeStream	(Ljava/io/Closeable;)V
    //   276: goto -76 -> 200
    //   279: iload_2
    //   280: istore_3
    //   281: iload_2
    //   282: istore 4
    //   284: iload_2
    //   285: istore 5
    //   287: aload_0
    //   288: getfield 48	com/tencent/util/BitmapUtils:context	Landroid/content/Context;
    //   291: invokevirtual 344	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   294: aload_1
    //   295: invokevirtual 350	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   298: astore 11
    //   300: aload 11
    //   302: astore 9
    //   304: goto -126 -> 178
    //   307: astore 11
    //   309: iload 4
    //   311: istore_2
    //   312: aload_0
    //   313: aload 9
    //   315: invokespecial 334	com/tencent/util/BitmapUtils:closeStream	(Ljava/io/Closeable;)V
    //   318: iload 6
    //   320: istore_3
    //   321: goto -121 -> 200
    //   324: astore 11
    //   326: iload 5
    //   328: istore_2
    //   329: aload_0
    //   330: aload 9
    //   332: invokespecial 334	com/tencent/util/BitmapUtils:closeStream	(Ljava/io/Closeable;)V
    //   335: iload 6
    //   337: istore_3
    //   338: goto -138 -> 200
    //   341: astore_1
    //   342: aload_0
    //   343: aload 9
    //   345: invokespecial 334	com/tencent/util/BitmapUtils:closeStream	(Ljava/io/Closeable;)V
    //   348: aload_1
    //   349: athrow
    //   350: astore_1
    //   351: goto -9 -> 342
    //   354: astore 11
    //   356: goto -27 -> 329
    //   359: astore 11
    //   361: goto -49 -> 312
    //   364: astore 11
    //   366: goto -98 -> 268
    //   369: iload_3
    //   370: istore 6
    //   372: goto -361 -> 11
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	375	0	this	BitmapUtils
    //   0	375	1	paramUri	Uri
    //   7	322	2	i	int
    //   12	358	3	j	int
    //   14	296	4	k	int
    //   17	310	5	m	int
    //   4	367	6	n	int
    //   39	50	7	i1	int
    //   54	37	8	i2	int
    //   9	335	9	localObject1	Object
    //   1	236	10	localObject2	Object
    //   24	165	11	localObject3	Object
    //   264	1	11	localFileNotFoundException1	java.io.FileNotFoundException
    //   298	3	11	localInputStream	java.io.InputStream
    //   307	1	11	localOutOfMemoryError1	OutOfMemoryError
    //   324	1	11	localException1	Exception
    //   354	1	11	localException2	Exception
    //   359	1	11	localOutOfMemoryError2	OutOfMemoryError
    //   364	1	11	localFileNotFoundException2	java.io.FileNotFoundException
    //   71	185	12	localOptions	BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   19	26	264	java/io/FileNotFoundException
    //   34	41	264	java/io/FileNotFoundException
    //   49	56	264	java/io/FileNotFoundException
    //   64	73	264	java/io/FileNotFoundException
    //   86	104	264	java/io/FileNotFoundException
    //   112	120	264	java/io/FileNotFoundException
    //   128	144	264	java/io/FileNotFoundException
    //   152	174	264	java/io/FileNotFoundException
    //   255	261	264	java/io/FileNotFoundException
    //   287	300	264	java/io/FileNotFoundException
    //   19	26	307	java/lang/OutOfMemoryError
    //   34	41	307	java/lang/OutOfMemoryError
    //   49	56	307	java/lang/OutOfMemoryError
    //   64	73	307	java/lang/OutOfMemoryError
    //   86	104	307	java/lang/OutOfMemoryError
    //   112	120	307	java/lang/OutOfMemoryError
    //   128	144	307	java/lang/OutOfMemoryError
    //   152	174	307	java/lang/OutOfMemoryError
    //   255	261	307	java/lang/OutOfMemoryError
    //   287	300	307	java/lang/OutOfMemoryError
    //   19	26	324	java/lang/Exception
    //   34	41	324	java/lang/Exception
    //   49	56	324	java/lang/Exception
    //   64	73	324	java/lang/Exception
    //   86	104	324	java/lang/Exception
    //   112	120	324	java/lang/Exception
    //   128	144	324	java/lang/Exception
    //   152	174	324	java/lang/Exception
    //   255	261	324	java/lang/Exception
    //   287	300	324	java/lang/Exception
    //   19	26	341	finally
    //   34	41	341	finally
    //   49	56	341	finally
    //   64	73	341	finally
    //   86	104	341	finally
    //   112	120	341	finally
    //   128	144	341	finally
    //   152	174	341	finally
    //   255	261	341	finally
    //   287	300	341	finally
    //   178	188	350	finally
    //   178	188	354	java/lang/Exception
    //   178	188	359	java/lang/OutOfMemoryError
    //   178	188	364	java/io/FileNotFoundException
  }
  
  public static void deletePicture(ContentResolver paramContentResolver, Uri paramUri)
  {
    Object localObject4 = null;
    Object localObject2 = null;
    Object localObject1 = null;
    try
    {
      Cursor localCursor = paramContentResolver.query(paramUri, PATH_PROJECTION, null, null, null);
      Object localObject3 = localObject4;
      if (localCursor != null)
      {
        localObject3 = localObject4;
        localObject1 = localCursor;
        localObject2 = localCursor;
        if (localCursor.moveToNext())
        {
          localObject1 = localCursor;
          localObject2 = localCursor;
          localObject3 = localCursor.getString(0);
        }
      }
      if (localObject3 != null)
      {
        localObject1 = localCursor;
        localObject2 = localCursor;
        localObject3 = new File((String)localObject3);
        localObject1 = localCursor;
        localObject2 = localCursor;
        if (((File)localObject3).isFile())
        {
          localObject1 = localCursor;
          localObject2 = localCursor;
          if (((File)localObject3).exists())
          {
            localObject1 = localCursor;
            localObject2 = localCursor;
            ((File)localObject3).delete();
          }
        }
      }
      localObject1 = localCursor;
      localObject2 = localCursor;
      paramContentResolver.delete(paramUri, null, null);
      return;
    }
    catch (Exception paramContentResolver)
    {
      localObject2 = localObject1;
      paramContentResolver.printStackTrace();
      return;
    }
    finally
    {
      if (localObject2 != null) {
        localObject2.close();
      }
    }
  }
  
  /* Error */
  private Rect getBitmapBounds(Uri paramUri)
  {
    // Byte code:
    //   0: new 137	android/graphics/Rect
    //   3: dup
    //   4: invokespecial 382	android/graphics/Rect:<init>	()V
    //   7: astore 6
    //   9: aconst_null
    //   10: astore 5
    //   12: aconst_null
    //   13: astore 4
    //   15: aload 4
    //   17: astore_3
    //   18: aload 5
    //   20: astore_2
    //   21: aload_1
    //   22: invokevirtual 304	android/net/Uri:getScheme	()Ljava/lang/String;
    //   25: invokevirtual 307	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   28: ldc_w 309
    //   31: invokevirtual 313	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   34: ifeq +101 -> 135
    //   37: aload 4
    //   39: astore_3
    //   40: aload 5
    //   42: astore_2
    //   43: new 315	java/io/FileInputStream
    //   46: dup
    //   47: aload_1
    //   48: invokevirtual 316	android/net/Uri:toString	()Ljava/lang/String;
    //   51: ldc_w 318
    //   54: invokevirtual 321	java/lang/String:length	()I
    //   57: invokevirtual 325	java/lang/String:substring	(I)Ljava/lang/String;
    //   60: invokespecial 328	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   63: astore_1
    //   64: aload_1
    //   65: astore_3
    //   66: aload_1
    //   67: astore_2
    //   68: new 64	android/graphics/BitmapFactory$Options
    //   71: dup
    //   72: invokespecial 259	android/graphics/BitmapFactory$Options:<init>	()V
    //   75: astore 4
    //   77: aload_1
    //   78: astore_3
    //   79: aload_1
    //   80: astore_2
    //   81: aload 4
    //   83: iconst_1
    //   84: putfield 386	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   87: aload_1
    //   88: astore_3
    //   89: aload_1
    //   90: astore_2
    //   91: aload_1
    //   92: aconst_null
    //   93: aload 4
    //   95: invokestatic 332	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   98: pop
    //   99: aload_1
    //   100: astore_3
    //   101: aload_1
    //   102: astore_2
    //   103: aload 6
    //   105: aload 4
    //   107: getfield 67	android/graphics/BitmapFactory$Options:outWidth	I
    //   110: putfield 389	android/graphics/Rect:right	I
    //   113: aload_1
    //   114: astore_3
    //   115: aload_1
    //   116: astore_2
    //   117: aload 6
    //   119: aload 4
    //   121: getfield 70	android/graphics/BitmapFactory$Options:outHeight	I
    //   124: putfield 392	android/graphics/Rect:bottom	I
    //   127: aload_0
    //   128: aload_1
    //   129: invokespecial 334	com/tencent/util/BitmapUtils:closeStream	(Ljava/io/Closeable;)V
    //   132: aload 6
    //   134: areturn
    //   135: aload 4
    //   137: astore_3
    //   138: aload 5
    //   140: astore_2
    //   141: aload_0
    //   142: getfield 48	com/tencent/util/BitmapUtils:context	Landroid/content/Context;
    //   145: invokevirtual 344	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   148: aload_1
    //   149: invokevirtual 350	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   152: astore_1
    //   153: goto -89 -> 64
    //   156: astore_1
    //   157: aload_3
    //   158: astore_2
    //   159: aload_1
    //   160: invokevirtual 393	java/io/FileNotFoundException:printStackTrace	()V
    //   163: aload_0
    //   164: aload_3
    //   165: invokespecial 334	com/tencent/util/BitmapUtils:closeStream	(Ljava/io/Closeable;)V
    //   168: aload 6
    //   170: areturn
    //   171: astore_1
    //   172: aload_0
    //   173: aload_2
    //   174: invokespecial 334	com/tencent/util/BitmapUtils:closeStream	(Ljava/io/Closeable;)V
    //   177: aload_1
    //   178: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	179	0	this	BitmapUtils
    //   0	179	1	paramUri	Uri
    //   20	154	2	localObject1	Object
    //   17	148	3	localObject2	Object
    //   13	123	4	localOptions	BitmapFactory.Options
    //   10	129	5	localObject3	Object
    //   7	162	6	localRect	Rect
    // Exception table:
    //   from	to	target	type
    //   21	37	156	java/io/FileNotFoundException
    //   43	64	156	java/io/FileNotFoundException
    //   68	77	156	java/io/FileNotFoundException
    //   81	87	156	java/io/FileNotFoundException
    //   91	99	156	java/io/FileNotFoundException
    //   103	113	156	java/io/FileNotFoundException
    //   117	127	156	java/io/FileNotFoundException
    //   141	153	156	java/io/FileNotFoundException
    //   21	37	171	finally
    //   43	64	171	finally
    //   68	77	171	finally
    //   81	87	171	finally
    //   91	99	171	finally
    //   103	113	171	finally
    //   117	127	171	finally
    //   141	153	171	finally
    //   159	163	171	finally
  }
  
  public static Bitmap getBitmapResource(Context paramContext, int paramInt)
  {
    try
    {
      paramContext = BitmapFactory.decodeResource(paramContext.getResources(), paramInt);
      return paramContext;
    }
    catch (OutOfMemoryError paramContext) {}
    return null;
  }
  
  public static Bitmap getBitmapTailor(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    boolean bool = false;
    if (Math.abs(paramInt1 / paramInt2 - paramBitmap.getWidth() / paramBitmap.getHeight()) < 0.01F) {
      return resizeBitmapByScale(paramBitmap, paramInt1 / paramBitmap.getWidth(), false);
    }
    if ((paramInt1 >= paramBitmap.getWidth()) || (paramInt2 >= paramBitmap.getHeight())) {}
    for (Bitmap localBitmap = resizeBitmapByScale(paramBitmap, Math.max(paramInt1 / paramBitmap.getWidth(), paramInt2 / paramBitmap.getHeight()), false); localBitmap == null; localBitmap = resizeBitmapByScale(paramBitmap, Math.max(paramInt1 / paramBitmap.getWidth(), paramInt2 / paramBitmap.getHeight()), false)) {
      return null;
    }
    if (localBitmap != paramBitmap) {
      bool = true;
    }
    return cropCenter(localBitmap, paramInt1, paramInt2, bool);
  }
  
  private static Bitmap.Config getConfig(Bitmap paramBitmap)
  {
    Bitmap.Config localConfig = paramBitmap.getConfig();
    paramBitmap = localConfig;
    if (localConfig == null) {
      paramBitmap = Bitmap.Config.ARGB_8888;
    }
    return paramBitmap;
  }
  
  public static Bitmap makeBitmap(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramArrayOfByte == null) {}
    for (;;)
    {
      return null;
      try
      {
        Object localObject = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length, (BitmapFactory.Options)localObject);
        if ((!((BitmapFactory.Options)localObject).mCancel) && (((BitmapFactory.Options)localObject).outWidth != -1) && (((BitmapFactory.Options)localObject).outHeight != -1))
        {
          ((BitmapFactory.Options)localObject).inSampleSize = computeSampleSize((BitmapFactory.Options)localObject, paramInt1, paramInt3);
          ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
          ((BitmapFactory.Options)localObject).inDither = false;
          ((BitmapFactory.Options)localObject).inPreferredConfig = Bitmap.Config.ARGB_4444;
          paramArrayOfByte = BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length, (BitmapFactory.Options)localObject);
          if (paramInt2 != 0)
          {
            localObject = new android.graphics.Matrix();
            ((android.graphics.Matrix)localObject).setRotate(paramInt2);
            localObject = createBitmap(paramArrayOfByte, 0, 0, paramArrayOfByte.getWidth(), paramArrayOfByte.getHeight(), (android.graphics.Matrix)localObject);
            paramArrayOfByte.recycle();
            return localObject;
          }
        }
      }
      catch (OutOfMemoryError paramArrayOfByte)
      {
        return null;
      }
    }
    return paramArrayOfByte;
  }
  
  public static Bitmap makeFitBitmap(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    Object localObject1 = null;
    if (paramArrayOfByte == null) {
      return null;
    }
    int k = 1;
    int j = -1;
    int i = j;
    for (;;)
    {
      try
      {
        localObject2 = new BitmapFactory.Options();
        i = j;
        ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
        i = j;
        BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length, (BitmapFactory.Options)localObject2);
        i = j;
        if (((BitmapFactory.Options)localObject2).mCancel) {
          break label372;
        }
        i = j;
        if (((BitmapFactory.Options)localObject2).outWidth == -1) {
          break label372;
        }
        i = j;
        if (((BitmapFactory.Options)localObject2).outHeight == -1) {
          break label372;
        }
        if (j != -1) {
          continue;
        }
        i = j;
        ((BitmapFactory.Options)localObject2).inSampleSize = computeSampleSizeSmaller(((BitmapFactory.Options)localObject2).outWidth, ((BitmapFactory.Options)localObject2).outHeight, paramBoolean);
        i = j;
        j = ((BitmapFactory.Options)localObject2).inSampleSize;
        i = j;
        ((BitmapFactory.Options)localObject2).inJustDecodeBounds = false;
        i = j;
        ((BitmapFactory.Options)localObject2).inDither = false;
        i = j;
        ((BitmapFactory.Options)localObject2).inPreferredConfig = Bitmap.Config.ARGB_8888;
        i = j;
        localObject2 = BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length, (BitmapFactory.Options)localObject2);
        m = 0;
        i = j;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        Object localObject2;
        float f;
        Object localObject3 = localObject1;
        int m = k;
        continue;
        return localObject3;
      }
      localObject1 = localObject2;
      k = m;
      j = i;
      if (m != 0) {
        break;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0) && (paramInt3 == 0)) {
        continue;
      }
      paramArrayOfByte = new android.graphics.Matrix();
      f = ((Bitmap)localObject2).getWidth();
      if (paramInt2 == 1) {
        paramArrayOfByte.setValues(new float[] { -1.0F, 0.0F, f, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F });
      }
      if (paramInt1 != 0) {
        paramArrayOfByte.preRotate(paramInt1);
      }
      if (paramInt3 != 0) {
        paramArrayOfByte.postRotate(paramInt3);
      }
      paramArrayOfByte = createBitmap((Bitmap)localObject2, 0, 0, ((Bitmap)localObject2).getWidth(), ((Bitmap)localObject2).getHeight(), paramArrayOfByte);
      ((Bitmap)localObject2).recycle();
      return paramArrayOfByte;
      j *= 2;
      i = j;
      ((BitmapFactory.Options)localObject2).inSampleSize = j;
    }
    label372:
    return null;
  }
  
  public static Bitmap makeFitBitmap(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
  {
    Object localObject1 = null;
    if (paramArrayOfByte == null) {
      return null;
    }
    int k = 1;
    int j = -1;
    label15:
    int i = j;
    for (;;)
    {
      try
      {
        localObject2 = new BitmapFactory.Options();
        i = j;
        ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
        i = j;
        BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length, (BitmapFactory.Options)localObject2);
        i = j;
        if (((BitmapFactory.Options)localObject2).mCancel) {
          break;
        }
        i = j;
        if (((BitmapFactory.Options)localObject2).outWidth == -1) {
          break;
        }
        i = j;
        if (((BitmapFactory.Options)localObject2).outHeight == -1) {
          break;
        }
        if (j != -1) {
          continue;
        }
        i = j;
        ((BitmapFactory.Options)localObject2).inSampleSize = computeSampleSizeSmaller(((BitmapFactory.Options)localObject2).outWidth, ((BitmapFactory.Options)localObject2).outHeight, paramBoolean);
        i = j;
        j = ((BitmapFactory.Options)localObject2).inSampleSize;
        i = j;
        ((BitmapFactory.Options)localObject2).inJustDecodeBounds = false;
        i = j;
        ((BitmapFactory.Options)localObject2).inDither = false;
        i = j;
        ((BitmapFactory.Options)localObject2).inPreferredConfig = Bitmap.Config.ARGB_8888;
        i = j;
        localObject2 = BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length, (BitmapFactory.Options)localObject2);
        m = 0;
        i = j;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        Object localObject2;
        localObject3 = localObject1;
        int m = k;
        continue;
        localObject3.recycle();
        return paramArrayOfByte;
      }
      localObject1 = localObject2;
      k = m;
      j = i;
      if (m != 0) {
        break label15;
      }
      if (paramInt == 0) {
        break label270;
      }
      paramArrayOfByte = new android.graphics.Matrix();
      paramArrayOfByte.setRotate(paramInt);
      paramArrayOfByte = createBitmap((Bitmap)localObject2, 0, 0, ((Bitmap)localObject2).getWidth(), ((Bitmap)localObject2).getHeight(), paramArrayOfByte);
      if (paramArrayOfByte != null) {
        continue;
      }
      return localObject2;
      j *= 2;
      i = j;
      ((BitmapFactory.Options)localObject2).inSampleSize = j;
    }
    Object localObject3;
    label270:
    return localObject3;
  }
  
  public static Bitmap makeLimitedBitmap(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    Object localObject2 = null;
    Object localObject1;
    try
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length, localOptions);
      localObject1 = localObject2;
      if (!localOptions.mCancel)
      {
        localObject1 = localObject2;
        if (localOptions.outWidth != -1)
        {
          if (localOptions.outHeight == -1) {
            return null;
          }
          localOptions.inSampleSize = computeSampleSize(localOptions, -1, paramInt1);
          localOptions.inJustDecodeBounds = false;
          localOptions.inDither = false;
          localOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;
          localObject1 = BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length, localOptions);
          if (paramInt2 != 0)
          {
            paramArrayOfByte = new android.graphics.Matrix();
            paramArrayOfByte.setRotate(paramInt2);
            paramArrayOfByte = createBitmap((Bitmap)localObject1, 0, 0, ((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight(), paramArrayOfByte);
            ((Bitmap)localObject1).recycle();
            return paramArrayOfByte;
          }
        }
      }
    }
    catch (OutOfMemoryError paramArrayOfByte)
    {
      return null;
    }
    return localObject1;
  }
  
  public static int prevPowerOf2(int paramInt)
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException();
    }
    return Integer.highestOneBit(paramInt);
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
  
  public static Bitmap resizeBitmapByScale(Bitmap paramBitmap, float paramFloat, boolean paramBoolean)
  {
    int i = Math.round(paramBitmap.getWidth() * paramFloat);
    int j = Math.round(paramBitmap.getHeight() * paramFloat);
    if ((i == paramBitmap.getWidth()) && (j == paramBitmap.getHeight())) {
      return paramBitmap;
    }
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(i, j, getConfig(paramBitmap));
      localObject = new Canvas(localBitmap);
      ((Canvas)localObject).scale(paramFloat, paramFloat);
      Paint localPaint = new Paint(6);
      localPaint.setAntiAlias(true);
      ((Canvas)localObject).drawBitmap(paramBitmap, 0.0F, 0.0F, localPaint);
      localObject = localBitmap;
      if (paramBoolean)
      {
        paramBitmap.recycle();
        localObject = localBitmap;
      }
    }
    catch (OutOfMemoryError paramBitmap)
    {
      for (;;)
      {
        localObject = null;
      }
    }
    catch (Exception paramBitmap)
    {
      for (;;)
      {
        Object localObject = null;
      }
    }
    return localObject;
  }
  
  public static Bitmap resizeBitmapByScale2(Bitmap paramBitmap, float paramFloat, boolean paramBoolean)
  {
    int i = Math.round(paramBitmap.getWidth() * paramFloat);
    int j = Math.round(paramBitmap.getHeight() * paramFloat);
    if ((i == paramBitmap.getWidth()) && (j == paramBitmap.getHeight())) {
      return paramBitmap;
    }
    Object localObject = new android.graphics.Matrix();
    ((android.graphics.Matrix)localObject).postScale(paramFloat, paramFloat);
    localObject = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), (android.graphics.Matrix)localObject, true);
    if (paramBoolean) {
      paramBitmap.recycle();
    }
    return localObject;
  }
  
  public static Bitmap resizeDownAndCropCenter(Bitmap paramBitmap, int paramInt, boolean paramBoolean)
  {
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    int k = Math.min(i, j);
    if ((i == j) && (k <= paramInt)) {
      return paramBitmap;
    }
    paramInt = Math.min(paramInt, k);
    float f = Math.max(paramInt / paramBitmap.getWidth(), paramInt / paramBitmap.getHeight());
    Bitmap localBitmap = Bitmap.createBitmap(paramInt, paramInt, getConfig(paramBitmap));
    i = Math.round(paramBitmap.getWidth() * f);
    j = Math.round(paramBitmap.getHeight() * f);
    Canvas localCanvas = new Canvas(localBitmap);
    localCanvas.translate((paramInt - i) / 2.0F, (paramInt - j) / 2.0F);
    localCanvas.scale(f, f);
    localCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, new Paint(6));
    if (paramBoolean) {
      paramBitmap.recycle();
    }
    return localBitmap;
  }
  
  public static Bitmap resizeDownBySideLength(Bitmap paramBitmap, int paramInt, boolean paramBoolean)
  {
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    float f = Math.min(paramInt / i, paramInt / j);
    if (f >= 1.0F) {
      return paramBitmap;
    }
    return resizeBitmapByScale(paramBitmap, f, paramBoolean);
  }
  
  public static Bitmap resizeFromTop(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    boolean bool = false;
    if (Math.abs(paramInt1 / paramInt2 - paramBitmap.getWidth() / paramBitmap.getHeight()) < 0.01F) {
      return resizeBitmapByScale(paramBitmap, paramInt1 / paramBitmap.getWidth(), false);
    }
    if ((paramInt1 >= paramBitmap.getWidth()) || (paramInt2 >= paramBitmap.getHeight())) {}
    for (Bitmap localBitmap = resizeBitmapByScale(paramBitmap, Math.max(paramInt1 / paramBitmap.getWidth(), paramInt2 / paramBitmap.getHeight()), false); localBitmap == null; localBitmap = resizeBitmapByScale(paramBitmap, Math.max(paramInt1 / paramBitmap.getWidth(), paramInt2 / paramBitmap.getHeight()), false)) {
      return null;
    }
    if (localBitmap != paramBitmap) {
      bool = true;
    }
    return cropCenter(localBitmap, paramInt1, paramInt2, bool);
  }
  
  private static void rotate(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if (paramFloat1 == 0.0F) {
      return;
    }
    float[] arrayOfFloat = mTempMatrix;
    android.opengl.Matrix.setRotateM(arrayOfFloat, 0, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    android.opengl.Matrix.multiplyMM(arrayOfFloat, 16, mMatrixValues, 0, arrayOfFloat, 0);
    System.arraycopy(arrayOfFloat, 16, mMatrixValues, 0, 16);
  }
  
  private static void rotate(int paramInt)
  {
    if (paramInt == 0) {
      return;
    }
    rotate(paramInt, 0.0F, 0.0F, 1.0F);
  }
  
  private static Bitmap rotateAndFlipY(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = new android.graphics.Matrix();
    float f = paramBitmap.getWidth();
    if (paramInt2 == 1) {
      ((android.graphics.Matrix)localObject).setValues(new float[] { -1.0F, 0.0F, f, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F });
    }
    if (paramInt1 != 0) {
      ((android.graphics.Matrix)localObject).preRotate(paramInt1);
    }
    if (paramInt3 != 0) {
      ((android.graphics.Matrix)localObject).postRotate(paramInt3);
    }
    localObject = createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), (android.graphics.Matrix)localObject);
    if (localObject == null) {
      return paramBitmap;
    }
    paramBitmap.recycle();
    return localObject;
  }
  
  public static Bitmap rotateAndFlipY(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Bitmap localBitmap;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      localBitmap = paramBitmap;
      if (0 == 0) {}
    }
    else
    {
      if (paramInt2 != 0) {
        break label31;
      }
      localBitmap = rotateAndFlipY(paramBitmap, paramInt1, paramInt2, 0);
    }
    return localBitmap;
    label31:
    return rotateAndFlipY(paramBitmap, paramInt1, paramInt2, 0);
  }
  
  public static float[] rotateAndFlipYMatrix(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    android.opengl.Matrix.setIdentityM(mMatrixValues, 0);
    rotate(paramInt1);
    if (paramInt2 % 2 == 1)
    {
      if (paramInt1 % 180 != 0) {
        break label50;
      }
      android.opengl.Matrix.scaleM(mMatrixValues, 0, -1.0F, 1.0F, 1.0F);
    }
    for (;;)
    {
      if (0 != 0) {
        rotate(0);
      }
      return mMatrixValues;
      label50:
      android.opengl.Matrix.scaleM(mMatrixValues, 0, 1.0F, -1.0F, 1.0F);
    }
  }
  
  /* Error */
  public Bitmap decodeBitmap(Uri paramUri, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 13
    //   3: iconst_1
    //   4: istore 8
    //   6: iconst_m1
    //   7: istore 5
    //   9: aconst_null
    //   10: astore 12
    //   12: iload 5
    //   14: istore 6
    //   16: iload 5
    //   18: istore 7
    //   20: aload_0
    //   21: aload_1
    //   22: invokespecial 281	com/tencent/util/BitmapUtils:getBitmapBounds	(Landroid/net/Uri;)Landroid/graphics/Rect;
    //   25: astore 14
    //   27: iload 5
    //   29: istore 6
    //   31: iload 5
    //   33: istore 7
    //   35: aload 14
    //   37: invokevirtual 283	android/graphics/Rect:width	()I
    //   40: istore 10
    //   42: iload 5
    //   44: istore 6
    //   46: iload 5
    //   48: istore 7
    //   50: aload 14
    //   52: invokevirtual 285	android/graphics/Rect:height	()I
    //   55: istore 11
    //   57: iload 5
    //   59: istore 6
    //   61: iload 5
    //   63: istore 7
    //   65: new 64	android/graphics/BitmapFactory$Options
    //   68: dup
    //   69: invokespecial 259	android/graphics/BitmapFactory$Options:<init>	()V
    //   72: astore 15
    //   74: iload 5
    //   76: iconst_m1
    //   77: if_icmpne +290 -> 367
    //   80: iload_2
    //   81: iload_3
    //   82: if_icmple +279 -> 361
    //   85: iload_2
    //   86: istore 9
    //   88: iload 5
    //   90: istore 6
    //   92: iload 5
    //   94: istore 7
    //   96: aload 15
    //   98: iload 10
    //   100: iload 11
    //   102: iload 9
    //   104: invokestatic 522	com/tencent/util/BitmapUtils:computeSampleSizeLarger	(III)I
    //   107: putfield 299	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   110: iload 5
    //   112: istore 6
    //   114: iload 5
    //   116: istore 7
    //   118: aload 15
    //   120: getfield 299	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   123: istore 5
    //   125: iload 5
    //   127: istore 6
    //   129: iload 5
    //   131: istore 7
    //   133: aload 15
    //   135: getstatic 230	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   138: putfield 262	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   141: iload 5
    //   143: istore 6
    //   145: iload 5
    //   147: istore 7
    //   149: aload_1
    //   150: invokevirtual 304	android/net/Uri:getScheme	()Ljava/lang/String;
    //   153: invokevirtual 307	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   156: ldc_w 309
    //   159: invokevirtual 313	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   162: ifeq +247 -> 409
    //   165: iload 5
    //   167: istore 6
    //   169: iload 5
    //   171: istore 7
    //   173: new 315	java/io/FileInputStream
    //   176: dup
    //   177: aload_1
    //   178: invokevirtual 316	android/net/Uri:toString	()Ljava/lang/String;
    //   181: ldc_w 318
    //   184: invokevirtual 321	java/lang/String:length	()I
    //   187: invokevirtual 325	java/lang/String:substring	(I)Ljava/lang/String;
    //   190: invokespecial 328	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   193: astore 14
    //   195: aload 14
    //   197: astore 12
    //   199: aload 12
    //   201: aconst_null
    //   202: aload 15
    //   204: invokestatic 332	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   207: astore 14
    //   209: aload 14
    //   211: astore 13
    //   213: iconst_0
    //   214: istore 6
    //   216: aload_0
    //   217: aload 12
    //   219: invokespecial 334	com/tencent/util/BitmapUtils:closeStream	(Ljava/io/Closeable;)V
    //   222: iload 6
    //   224: ifne +257 -> 481
    //   227: aload 13
    //   229: astore_1
    //   230: aload 13
    //   232: ifnull +32 -> 264
    //   235: aload 13
    //   237: astore_1
    //   238: aload 13
    //   240: invokevirtual 120	android/graphics/Bitmap:getConfig	()Landroid/graphics/Bitmap$Config;
    //   243: getstatic 230	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   246: if_acmpeq +18 -> 264
    //   249: aload 13
    //   251: getstatic 230	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   254: iconst_1
    //   255: invokevirtual 338	android/graphics/Bitmap:copy	(Landroid/graphics/Bitmap$Config;Z)Landroid/graphics/Bitmap;
    //   258: astore_1
    //   259: aload 13
    //   261: invokevirtual 215	android/graphics/Bitmap:recycle	()V
    //   264: aload_1
    //   265: ifnull +200 -> 465
    //   268: iload_2
    //   269: i2f
    //   270: aload_1
    //   271: invokevirtual 196	android/graphics/Bitmap:getWidth	()I
    //   274: i2f
    //   275: fdiv
    //   276: iload_3
    //   277: i2f
    //   278: aload_1
    //   279: invokevirtual 199	android/graphics/Bitmap:getHeight	()I
    //   282: i2f
    //   283: fdiv
    //   284: invokestatic 484	java/lang/Math:min	(FF)F
    //   287: iload_3
    //   288: i2f
    //   289: aload_1
    //   290: invokevirtual 196	android/graphics/Bitmap:getWidth	()I
    //   293: i2f
    //   294: fdiv
    //   295: iload_2
    //   296: i2f
    //   297: aload_1
    //   298: invokevirtual 199	android/graphics/Bitmap:getHeight	()I
    //   301: i2f
    //   302: fdiv
    //   303: invokestatic 484	java/lang/Math:min	(FF)F
    //   306: invokestatic 416	java/lang/Math:max	(FF)F
    //   309: fstore 4
    //   311: fload 4
    //   313: fconst_1
    //   314: fcmpg
    //   315: ifge +150 -> 465
    //   318: new 110	android/graphics/Matrix
    //   321: dup
    //   322: invokespecial 436	android/graphics/Matrix:<init>	()V
    //   325: astore 12
    //   327: aload 12
    //   329: fload 4
    //   331: fload 4
    //   333: invokevirtual 525	android/graphics/Matrix:setScale	(FF)V
    //   336: aload_1
    //   337: iconst_0
    //   338: iconst_0
    //   339: aload_1
    //   340: invokevirtual 196	android/graphics/Bitmap:getWidth	()I
    //   343: aload_1
    //   344: invokevirtual 199	android/graphics/Bitmap:getHeight	()I
    //   347: aload 12
    //   349: invokestatic 212	com/tencent/util/BitmapUtils:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;)Landroid/graphics/Bitmap;
    //   352: astore 12
    //   354: aload_1
    //   355: invokevirtual 215	android/graphics/Bitmap:recycle	()V
    //   358: aload 12
    //   360: areturn
    //   361: iload_3
    //   362: istore 9
    //   364: goto -276 -> 88
    //   367: iload 5
    //   369: iconst_2
    //   370: imul
    //   371: istore 5
    //   373: iload 5
    //   375: istore 6
    //   377: iload 5
    //   379: istore 7
    //   381: aload 15
    //   383: iload 5
    //   385: putfield 299	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   388: goto -263 -> 125
    //   391: astore 14
    //   393: iload 6
    //   395: istore 5
    //   397: iconst_0
    //   398: istore 6
    //   400: aload_0
    //   401: aload 12
    //   403: invokespecial 334	com/tencent/util/BitmapUtils:closeStream	(Ljava/io/Closeable;)V
    //   406: goto -184 -> 222
    //   409: iload 5
    //   411: istore 6
    //   413: iload 5
    //   415: istore 7
    //   417: aload_0
    //   418: getfield 48	com/tencent/util/BitmapUtils:context	Landroid/content/Context;
    //   421: invokevirtual 344	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   424: aload_1
    //   425: invokevirtual 350	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   428: astore 14
    //   430: aload 14
    //   432: astore 12
    //   434: goto -235 -> 199
    //   437: astore 14
    //   439: iload 7
    //   441: istore 5
    //   443: aload_0
    //   444: aload 12
    //   446: invokespecial 334	com/tencent/util/BitmapUtils:closeStream	(Ljava/io/Closeable;)V
    //   449: iload 8
    //   451: istore 6
    //   453: goto -231 -> 222
    //   456: astore_1
    //   457: aload_0
    //   458: aload 12
    //   460: invokespecial 334	com/tencent/util/BitmapUtils:closeStream	(Ljava/io/Closeable;)V
    //   463: aload_1
    //   464: athrow
    //   465: aload_1
    //   466: areturn
    //   467: astore_1
    //   468: goto -11 -> 457
    //   471: astore 14
    //   473: goto -30 -> 443
    //   476: astore 14
    //   478: goto -81 -> 397
    //   481: iload 6
    //   483: istore 8
    //   485: goto -473 -> 12
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	488	0	this	BitmapUtils
    //   0	488	1	paramUri	Uri
    //   0	488	2	paramInt1	int
    //   0	488	3	paramInt2	int
    //   309	23	4	f	float
    //   7	435	5	i	int
    //   14	468	6	j	int
    //   18	422	7	k	int
    //   4	480	8	m	int
    //   86	277	9	n	int
    //   40	59	10	i1	int
    //   55	46	11	i2	int
    //   10	449	12	localObject1	Object
    //   1	259	13	localObject2	Object
    //   25	185	14	localObject3	Object
    //   391	1	14	localFileNotFoundException1	java.io.FileNotFoundException
    //   428	3	14	localInputStream	java.io.InputStream
    //   437	1	14	localOutOfMemoryError1	OutOfMemoryError
    //   471	1	14	localOutOfMemoryError2	OutOfMemoryError
    //   476	1	14	localFileNotFoundException2	java.io.FileNotFoundException
    //   72	310	15	localOptions	BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   20	27	391	java/io/FileNotFoundException
    //   35	42	391	java/io/FileNotFoundException
    //   50	57	391	java/io/FileNotFoundException
    //   65	74	391	java/io/FileNotFoundException
    //   96	110	391	java/io/FileNotFoundException
    //   118	125	391	java/io/FileNotFoundException
    //   133	141	391	java/io/FileNotFoundException
    //   149	165	391	java/io/FileNotFoundException
    //   173	195	391	java/io/FileNotFoundException
    //   381	388	391	java/io/FileNotFoundException
    //   417	430	391	java/io/FileNotFoundException
    //   20	27	437	java/lang/OutOfMemoryError
    //   35	42	437	java/lang/OutOfMemoryError
    //   50	57	437	java/lang/OutOfMemoryError
    //   65	74	437	java/lang/OutOfMemoryError
    //   96	110	437	java/lang/OutOfMemoryError
    //   118	125	437	java/lang/OutOfMemoryError
    //   133	141	437	java/lang/OutOfMemoryError
    //   149	165	437	java/lang/OutOfMemoryError
    //   173	195	437	java/lang/OutOfMemoryError
    //   381	388	437	java/lang/OutOfMemoryError
    //   417	430	437	java/lang/OutOfMemoryError
    //   20	27	456	finally
    //   35	42	456	finally
    //   50	57	456	finally
    //   65	74	456	finally
    //   96	110	456	finally
    //   118	125	456	finally
    //   133	141	456	finally
    //   149	165	456	finally
    //   173	195	456	finally
    //   381	388	456	finally
    //   417	430	456	finally
    //   199	209	467	finally
    //   199	209	471	java/lang/OutOfMemoryError
    //   199	209	476	java/io/FileNotFoundException
  }
  
  public Bitmap getBitmap(Uri paramUri, int paramInt1, int paramInt2)
  {
    Bitmap localBitmap = decodeBitmap(paramUri, paramInt1, paramInt2);
    if (localBitmap != null)
    {
      paramInt1 = getOrientation(paramUri);
      if (paramInt1 != 0)
      {
        paramUri = new android.graphics.Matrix();
        paramUri.setRotate(paramInt1);
        paramUri = createBitmap(localBitmap, 0, 0, localBitmap.getWidth(), localBitmap.getHeight(), paramUri);
        localBitmap.recycle();
        return paramUri;
      }
    }
    return localBitmap;
  }
  
  public Bitmap getBitmapWithoutResize(Uri paramUri)
  {
    Bitmap localBitmap = decodeBitmapWithoutResize(paramUri);
    if (localBitmap != null)
    {
      int i = getOrientation(paramUri);
      if (i != 0)
      {
        paramUri = new android.graphics.Matrix();
        paramUri.setRotate(i);
        paramUri = createBitmap(localBitmap, 0, 0, localBitmap.getWidth(), localBitmap.getHeight(), paramUri);
        localBitmap.recycle();
        return paramUri;
      }
    }
    return localBitmap;
  }
  
  /* Error */
  public int getOrientation(Uri paramUri)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: iconst_0
    //   4: istore_3
    //   5: aload_1
    //   6: invokevirtual 304	android/net/Uri:getScheme	()Ljava/lang/String;
    //   9: invokevirtual 307	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   12: ldc_w 309
    //   15: invokevirtual 539	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   18: ifeq +220 -> 238
    //   21: aload_1
    //   22: invokevirtual 542	android/net/Uri:getPath	()Ljava/lang/String;
    //   25: astore_1
    //   26: iload_3
    //   27: istore_2
    //   28: aload_1
    //   29: ifnull +142 -> 171
    //   32: aload_1
    //   33: invokevirtual 307	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   36: ldc_w 544
    //   39: invokevirtual 547	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   42: ifne +18 -> 60
    //   45: iload_3
    //   46: istore_2
    //   47: aload_1
    //   48: invokevirtual 307	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   51: ldc_w 549
    //   54: invokevirtual 547	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   57: ifeq +114 -> 171
    //   60: new 366	java/io/File
    //   63: dup
    //   64: aload_1
    //   65: invokespecial 367	java/io/File:<init>	(Ljava/lang/String;)V
    //   68: astore 5
    //   70: aconst_null
    //   71: astore 7
    //   73: aconst_null
    //   74: astore_1
    //   75: aconst_null
    //   76: astore 6
    //   78: aconst_null
    //   79: astore 9
    //   81: aconst_null
    //   82: astore 11
    //   84: aconst_null
    //   85: astore 10
    //   87: aconst_null
    //   88: astore 8
    //   90: new 315	java/io/FileInputStream
    //   93: dup
    //   94: aload 5
    //   96: invokespecial 552	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   99: astore 5
    //   101: aload 11
    //   103: astore_1
    //   104: aload 10
    //   106: astore 6
    //   108: aload 5
    //   110: invokevirtual 557	java/io/InputStream:available	()I
    //   113: invokestatic 563	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   116: astore 7
    //   118: aload 7
    //   120: astore_1
    //   121: aload 7
    //   123: astore 6
    //   125: aload 5
    //   127: aload 7
    //   129: invokevirtual 567	java/nio/ByteBuffer:array	()[B
    //   132: invokevirtual 571	java/io/InputStream:read	([B)I
    //   135: pop
    //   136: aload 5
    //   138: invokestatic 577	com/tencent/util/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   141: aload 7
    //   143: astore 5
    //   145: iload_3
    //   146: istore_2
    //   147: aload 5
    //   149: ifnull +22 -> 171
    //   152: iload_3
    //   153: istore_2
    //   154: aload 5
    //   156: invokevirtual 567	java/nio/ByteBuffer:array	()[B
    //   159: ifnull +12 -> 171
    //   162: aload 5
    //   164: invokevirtual 567	java/nio/ByteBuffer:array	()[B
    //   167: invokestatic 581	com/tencent/util/ExifUtils:getOrientation	([B)I
    //   170: istore_2
    //   171: iload_2
    //   172: ireturn
    //   173: astore 7
    //   175: aload 8
    //   177: astore 5
    //   179: aload 6
    //   181: astore_1
    //   182: aload 7
    //   184: invokevirtual 393	java/io/FileNotFoundException:printStackTrace	()V
    //   187: aload 6
    //   189: invokestatic 577	com/tencent/util/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   192: goto -47 -> 145
    //   195: astore_1
    //   196: aload 7
    //   198: astore 6
    //   200: aload_1
    //   201: astore 7
    //   203: aload 9
    //   205: astore 5
    //   207: aload 6
    //   209: astore_1
    //   210: aload 7
    //   212: invokevirtual 60	java/io/IOException:printStackTrace	()V
    //   215: aload 6
    //   217: invokestatic 577	com/tencent/util/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   220: goto -75 -> 145
    //   223: astore 6
    //   225: aload_1
    //   226: astore 5
    //   228: aload 6
    //   230: astore_1
    //   231: aload 5
    //   233: invokestatic 577	com/tencent/util/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   236: aload_1
    //   237: athrow
    //   238: aconst_null
    //   239: astore 6
    //   241: aconst_null
    //   242: astore 5
    //   244: aload_0
    //   245: getfield 48	com/tencent/util/BitmapUtils:context	Landroid/content/Context;
    //   248: invokevirtual 344	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   251: aload_1
    //   252: getstatic 33	com/tencent/util/BitmapUtils:IMAGE_PROJECTION	[Ljava/lang/String;
    //   255: aconst_null
    //   256: aconst_null
    //   257: aconst_null
    //   258: invokevirtual 356	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   261: astore_1
    //   262: iload 4
    //   264: istore_2
    //   265: aload_1
    //   266: ifnull +35 -> 301
    //   269: iload 4
    //   271: istore_2
    //   272: aload_1
    //   273: astore 5
    //   275: aload_1
    //   276: astore 6
    //   278: aload_1
    //   279: invokeinterface 361 1 0
    //   284: ifeq +17 -> 301
    //   287: aload_1
    //   288: astore 5
    //   290: aload_1
    //   291: astore 6
    //   293: aload_1
    //   294: iconst_0
    //   295: invokeinterface 584 2 0
    //   300: istore_2
    //   301: aload_1
    //   302: invokestatic 587	com/tencent/util/IOUtils:closeQuietly	(Landroid/database/Cursor;)V
    //   305: iload_2
    //   306: ireturn
    //   307: astore_1
    //   308: aload 5
    //   310: astore 6
    //   312: aload_1
    //   313: invokevirtual 381	java/lang/Exception:printStackTrace	()V
    //   316: aload 5
    //   318: invokestatic 587	com/tencent/util/IOUtils:closeQuietly	(Landroid/database/Cursor;)V
    //   321: iconst_0
    //   322: ireturn
    //   323: astore_1
    //   324: aload 6
    //   326: invokestatic 587	com/tencent/util/IOUtils:closeQuietly	(Landroid/database/Cursor;)V
    //   329: aload_1
    //   330: athrow
    //   331: astore_1
    //   332: goto -101 -> 231
    //   335: astore 7
    //   337: aload 5
    //   339: astore 6
    //   341: aload_1
    //   342: astore 5
    //   344: goto -137 -> 207
    //   347: astore 7
    //   349: aload 5
    //   351: astore_1
    //   352: aload 6
    //   354: astore 5
    //   356: aload_1
    //   357: astore 6
    //   359: goto -180 -> 179
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	362	0	this	BitmapUtils
    //   0	362	1	paramUri	Uri
    //   27	279	2	i	int
    //   4	149	3	j	int
    //   1	269	4	k	int
    //   68	287	5	localObject1	Object
    //   76	140	6	localObject2	Object
    //   223	6	6	localObject3	Object
    //   239	119	6	localObject4	Object
    //   71	71	7	localByteBuffer	java.nio.ByteBuffer
    //   173	24	7	localFileNotFoundException1	java.io.FileNotFoundException
    //   201	10	7	localUri	Uri
    //   335	1	7	localIOException	IOException
    //   347	1	7	localFileNotFoundException2	java.io.FileNotFoundException
    //   88	88	8	localObject5	Object
    //   79	125	9	localObject6	Object
    //   85	20	10	localObject7	Object
    //   82	20	11	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   90	101	173	java/io/FileNotFoundException
    //   90	101	195	java/io/IOException
    //   90	101	223	finally
    //   182	187	223	finally
    //   210	215	223	finally
    //   244	262	307	java/lang/Exception
    //   278	287	307	java/lang/Exception
    //   293	301	307	java/lang/Exception
    //   244	262	323	finally
    //   278	287	323	finally
    //   293	301	323	finally
    //   312	316	323	finally
    //   108	118	331	finally
    //   125	136	331	finally
    //   108	118	335	java/io/IOException
    //   125	136	335	java/io/IOException
    //   108	118	347	java/io/FileNotFoundException
    //   125	136	347	java/io/FileNotFoundException
  }
  
  /* Error */
  public File saveBitmap(Bitmap paramBitmap, String paramString1, String paramString2, android.graphics.Bitmap.CompressFormat paramCompressFormat, String paramString3)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 10
    //   3: aload_2
    //   4: ifnonnull +139 -> 143
    //   7: aload_0
    //   8: getfield 48	com/tencent/util/BitmapUtils:context	Landroid/content/Context;
    //   11: invokevirtual 593	android/content/Context:getCacheDir	()Ljava/io/File;
    //   14: invokevirtual 596	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   17: astore 9
    //   19: aconst_null
    //   20: astore 12
    //   22: aconst_null
    //   23: astore 14
    //   25: aconst_null
    //   26: astore 13
    //   28: aconst_null
    //   29: astore 11
    //   31: iconst_0
    //   32: istore 7
    //   34: iconst_0
    //   35: istore 8
    //   37: aload 14
    //   39: astore_2
    //   40: aload 4
    //   42: getstatic 602	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   45: if_acmpne +132 -> 177
    //   48: aload 14
    //   50: astore_2
    //   51: new 235	java/lang/StringBuilder
    //   54: dup
    //   55: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   58: aload_3
    //   59: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: ldc_w 604
    //   65: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   71: astore_3
    //   72: aload 14
    //   74: astore_2
    //   75: new 366	java/io/File
    //   78: dup
    //   79: aload 9
    //   81: aload_3
    //   82: invokespecial 607	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   85: astore_3
    //   86: new 609	java/io/FileOutputStream
    //   89: dup
    //   90: aload_3
    //   91: invokespecial 610	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   94: astore_2
    //   95: aload 4
    //   97: getstatic 613	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   100: if_acmpne +104 -> 204
    //   103: aload 5
    //   105: ifnull +99 -> 204
    //   108: aload 5
    //   110: invokevirtual 321	java/lang/String:length	()I
    //   113: istore 6
    //   115: iload 6
    //   117: ifle +87 -> 204
    //   120: iload 8
    //   122: istore 7
    //   124: aload_0
    //   125: aload_2
    //   126: invokespecial 334	com/tencent/util/BitmapUtils:closeStream	(Ljava/io/Closeable;)V
    //   129: aload_3
    //   130: astore_1
    //   131: aload 10
    //   133: astore_2
    //   134: iload 7
    //   136: ifeq +5 -> 141
    //   139: aload_1
    //   140: astore_2
    //   141: aload_2
    //   142: areturn
    //   143: new 366	java/io/File
    //   146: dup
    //   147: aload_2
    //   148: invokespecial 367	java/io/File:<init>	(Ljava/lang/String;)V
    //   151: astore 11
    //   153: aload_2
    //   154: astore 9
    //   156: aload 11
    //   158: invokevirtual 616	java/io/File:isDirectory	()Z
    //   161: ifne -142 -> 19
    //   164: aload_2
    //   165: astore 9
    //   167: aload 11
    //   169: invokevirtual 619	java/io/File:mkdirs	()Z
    //   172: ifne -153 -> 19
    //   175: aconst_null
    //   176: areturn
    //   177: aload 14
    //   179: astore_2
    //   180: new 235	java/lang/StringBuilder
    //   183: dup
    //   184: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   187: aload_3
    //   188: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: ldc_w 621
    //   194: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   200: astore_3
    //   201: goto -129 -> 72
    //   204: aload_1
    //   205: aload 4
    //   207: bipush 90
    //   209: aload_2
    //   210: invokevirtual 625	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   213: istore 8
    //   215: iload 8
    //   217: istore 7
    //   219: goto -95 -> 124
    //   222: astore_3
    //   223: aload 11
    //   225: astore 4
    //   227: aload 12
    //   229: astore_1
    //   230: aload 4
    //   232: astore_2
    //   233: aload_3
    //   234: invokevirtual 381	java/lang/Exception:printStackTrace	()V
    //   237: aload_0
    //   238: aload 4
    //   240: invokespecial 334	com/tencent/util/BitmapUtils:closeStream	(Ljava/io/Closeable;)V
    //   243: goto -112 -> 131
    //   246: astore_1
    //   247: aload_0
    //   248: aload_2
    //   249: invokespecial 334	com/tencent/util/BitmapUtils:closeStream	(Ljava/io/Closeable;)V
    //   252: aload_1
    //   253: athrow
    //   254: astore_1
    //   255: aload 13
    //   257: astore_2
    //   258: goto -11 -> 247
    //   261: astore_1
    //   262: goto -15 -> 247
    //   265: astore_2
    //   266: aload_3
    //   267: astore_1
    //   268: aload_2
    //   269: astore_3
    //   270: aload 11
    //   272: astore 4
    //   274: goto -44 -> 230
    //   277: astore 4
    //   279: aload_3
    //   280: astore_1
    //   281: aload 4
    //   283: astore_3
    //   284: aload_2
    //   285: astore 4
    //   287: goto -57 -> 230
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	290	0	this	BitmapUtils
    //   0	290	1	paramBitmap	Bitmap
    //   0	290	2	paramString1	String
    //   0	290	3	paramString2	String
    //   0	290	4	paramCompressFormat	android.graphics.Bitmap.CompressFormat
    //   0	290	5	paramString3	String
    //   113	3	6	i	int
    //   32	186	7	j	int
    //   35	181	8	bool	boolean
    //   17	149	9	str	String
    //   1	131	10	localObject1	Object
    //   29	242	11	localFile	File
    //   20	208	12	localObject2	Object
    //   26	230	13	localObject3	Object
    //   23	155	14	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   40	48	222	java/lang/Exception
    //   51	72	222	java/lang/Exception
    //   75	86	222	java/lang/Exception
    //   180	201	222	java/lang/Exception
    //   40	48	246	finally
    //   51	72	246	finally
    //   75	86	246	finally
    //   180	201	246	finally
    //   233	237	246	finally
    //   86	95	254	finally
    //   95	103	261	finally
    //   108	115	261	finally
    //   204	215	261	finally
    //   86	95	265	java/lang/Exception
    //   95	103	277	java/lang/Exception
    //   108	115	277	java/lang/Exception
    //   204	215	277	java/lang/Exception
  }
  
  /* Error */
  public File saveJpegData(byte[] paramArrayOfByte, String paramString1, String paramString2, android.graphics.Bitmap.CompressFormat paramCompressFormat, String paramString3)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +119 -> 120
    //   4: aload_0
    //   5: getfield 48	com/tencent/util/BitmapUtils:context	Landroid/content/Context;
    //   8: invokevirtual 593	android/content/Context:getCacheDir	()Ljava/io/File;
    //   11: invokevirtual 596	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   14: astore 7
    //   16: aconst_null
    //   17: astore 9
    //   19: aconst_null
    //   20: astore 11
    //   22: aconst_null
    //   23: astore 10
    //   25: aconst_null
    //   26: astore 8
    //   28: aload 11
    //   30: astore_2
    //   31: aload 4
    //   33: getstatic 602	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   36: if_acmpne +118 -> 154
    //   39: aload 11
    //   41: astore_2
    //   42: new 235	java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   49: aload_3
    //   50: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: ldc_w 604
    //   56: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   62: astore_3
    //   63: aload 11
    //   65: astore_2
    //   66: new 366	java/io/File
    //   69: dup
    //   70: aload 7
    //   72: aload_3
    //   73: invokespecial 607	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   76: astore_3
    //   77: new 609	java/io/FileOutputStream
    //   80: dup
    //   81: aload_3
    //   82: invokespecial 610	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   85: astore_2
    //   86: aload 4
    //   88: getstatic 613	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   91: if_acmpne +90 -> 181
    //   94: aload 5
    //   96: ifnull +85 -> 181
    //   99: aload 5
    //   101: invokevirtual 321	java/lang/String:length	()I
    //   104: istore 6
    //   106: iload 6
    //   108: ifle +73 -> 181
    //   111: aload_0
    //   112: aload_2
    //   113: invokespecial 334	com/tencent/util/BitmapUtils:closeStream	(Ljava/io/Closeable;)V
    //   116: aload_3
    //   117: astore_1
    //   118: aload_1
    //   119: areturn
    //   120: new 366	java/io/File
    //   123: dup
    //   124: aload_2
    //   125: invokespecial 367	java/io/File:<init>	(Ljava/lang/String;)V
    //   128: astore 8
    //   130: aload_2
    //   131: astore 7
    //   133: aload 8
    //   135: invokevirtual 616	java/io/File:isDirectory	()Z
    //   138: ifne -122 -> 16
    //   141: aload_2
    //   142: astore 7
    //   144: aload 8
    //   146: invokevirtual 619	java/io/File:mkdirs	()Z
    //   149: ifne -133 -> 16
    //   152: aconst_null
    //   153: areturn
    //   154: aload 11
    //   156: astore_2
    //   157: new 235	java/lang/StringBuilder
    //   160: dup
    //   161: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   164: aload_3
    //   165: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: ldc_w 621
    //   171: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   177: astore_3
    //   178: goto -115 -> 63
    //   181: aload_2
    //   182: aload_1
    //   183: invokevirtual 633	java/io/OutputStream:write	([B)V
    //   186: goto -75 -> 111
    //   189: astore 5
    //   191: aload_3
    //   192: astore_1
    //   193: aload_2
    //   194: astore 4
    //   196: aload 5
    //   198: astore_3
    //   199: aload 4
    //   201: astore_2
    //   202: aload_3
    //   203: invokevirtual 381	java/lang/Exception:printStackTrace	()V
    //   206: aload_0
    //   207: aload 4
    //   209: invokespecial 334	com/tencent/util/BitmapUtils:closeStream	(Ljava/io/Closeable;)V
    //   212: goto -94 -> 118
    //   215: astore_1
    //   216: aload_0
    //   217: aload_2
    //   218: invokespecial 334	com/tencent/util/BitmapUtils:closeStream	(Ljava/io/Closeable;)V
    //   221: aload_1
    //   222: athrow
    //   223: astore_1
    //   224: aload 10
    //   226: astore_2
    //   227: goto -11 -> 216
    //   230: astore_1
    //   231: goto -15 -> 216
    //   234: astore_3
    //   235: aload 9
    //   237: astore_1
    //   238: aload 8
    //   240: astore 4
    //   242: goto -43 -> 199
    //   245: astore_2
    //   246: aload_3
    //   247: astore_1
    //   248: aload_2
    //   249: astore_3
    //   250: aload 8
    //   252: astore 4
    //   254: goto -55 -> 199
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	257	0	this	BitmapUtils
    //   0	257	1	paramArrayOfByte	byte[]
    //   0	257	2	paramString1	String
    //   0	257	3	paramString2	String
    //   0	257	4	paramCompressFormat	android.graphics.Bitmap.CompressFormat
    //   0	257	5	paramString3	String
    //   104	3	6	i	int
    //   14	129	7	str	String
    //   26	225	8	localFile	File
    //   17	219	9	localObject1	Object
    //   23	202	10	localObject2	Object
    //   20	135	11	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   86	94	189	java/lang/Exception
    //   99	106	189	java/lang/Exception
    //   181	186	189	java/lang/Exception
    //   31	39	215	finally
    //   42	63	215	finally
    //   66	77	215	finally
    //   157	178	215	finally
    //   202	206	215	finally
    //   77	86	223	finally
    //   86	94	230	finally
    //   99	106	230	finally
    //   181	186	230	finally
    //   31	39	234	java/lang/Exception
    //   42	63	234	java/lang/Exception
    //   66	77	234	java/lang/Exception
    //   157	178	234	java/lang/Exception
    //   77	86	245	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.util.BitmapUtils
 * JD-Core Version:    0.7.0.1
 */