package com.tencent.ttpic.util;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.graphics.Point;
import android.media.ExifInterface;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.ttpic.cache.ImageMemoryManager;
import java.io.IOException;

public class VideoBitmapUtil
{
  private static final int SAVE_FAILED = -1;
  private static final int SAVE_OOM = -2;
  private static final int SAVE_SUCCESS = 0;
  private static final String TAG = VideoBitmapUtil.class.getSimpleName();
  
  public static int calculateInSampleSize(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int k = paramOptions.outHeight;
    int m = paramOptions.outWidth;
    int i = 1;
    int j;
    if ((paramInt2 <= 0) || (k <= paramInt2))
    {
      j = i;
      if (paramInt1 > 0)
      {
        j = i;
        if (m <= paramInt1) {}
      }
    }
    else
    {
      i = Math.round(k / paramInt2);
      j = Math.round(m / paramInt1);
      if (i < j) {}
      for (;;)
      {
        float f1 = m * k;
        float f2 = paramInt1 * paramInt2 * 2;
        for (;;)
        {
          j = i;
          if (f1 / (i * i) <= f2) {
            break;
          }
          i += 1;
        }
        i = j;
      }
    }
    return j;
  }
  
  public static Bitmap decodeSampleBitmap(Context paramContext, String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      if (paramString.startsWith("assets://")) {
        return decodeSampleBitmapFromAssets(paramContext, VideoUtil.getRealPath(paramString), paramInt);
      }
    } while (!VideoFileUtil.exists(paramString));
    return decodeSampledBitmapFromFile(paramString, paramInt);
  }
  
  public static Bitmap decodeSampleBitmap(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      if (paramString.startsWith("assets://")) {
        return decodeSampleBitmapFromAssets(paramContext, VideoUtil.getRealPath(paramString), paramInt1, paramInt2);
      }
    } while (!VideoFileUtil.exists(paramString));
    return decodeSampledBitmapFromFile(paramString, paramInt1, paramInt2);
  }
  
  /* Error */
  public static Bitmap decodeSampleBitmapFromAssets(Context paramContext, String paramString, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_1
    //   3: invokestatic 51	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: ifeq +7 -> 13
    //   9: aload_3
    //   10: astore_0
    //   11: aload_0
    //   12: areturn
    //   13: aload_0
    //   14: invokevirtual 93	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   17: astore_0
    //   18: aload_0
    //   19: aload_1
    //   20: invokevirtual 99	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   23: astore_3
    //   24: new 31	android/graphics/BitmapFactory$Options
    //   27: dup
    //   28: invokespecial 100	android/graphics/BitmapFactory$Options:<init>	()V
    //   31: astore 5
    //   33: aload 5
    //   35: iconst_0
    //   36: putfield 104	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   39: aload 5
    //   41: iload_2
    //   42: putfield 107	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   45: aload 5
    //   47: iconst_1
    //   48: putfield 110	android/graphics/BitmapFactory$Options:inPreferQualityOverSpeed	Z
    //   51: aconst_null
    //   52: astore_1
    //   53: aconst_null
    //   54: astore_0
    //   55: aload_3
    //   56: invokevirtual 115	java/io/InputStream:reset	()V
    //   59: aload_3
    //   60: aconst_null
    //   61: aload 5
    //   63: invokestatic 121	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   66: astore 4
    //   68: aload 4
    //   70: astore_1
    //   71: aload_1
    //   72: astore_0
    //   73: aload_3
    //   74: ifnull -63 -> 11
    //   77: aload_3
    //   78: invokevirtual 124	java/io/InputStream:close	()V
    //   81: aload_1
    //   82: areturn
    //   83: astore_0
    //   84: aload_1
    //   85: areturn
    //   86: astore_3
    //   87: aload_0
    //   88: new 126	java/lang/StringBuilder
    //   91: dup
    //   92: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   95: aload_1
    //   96: iconst_0
    //   97: aload_1
    //   98: bipush 46
    //   100: invokevirtual 131	java/lang/String:lastIndexOf	(I)I
    //   103: iconst_1
    //   104: iadd
    //   105: invokevirtual 135	java/lang/String:substring	(II)Ljava/lang/String;
    //   108: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: ldc 141
    //   113: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: invokevirtual 99	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   122: astore_3
    //   123: goto -99 -> 24
    //   126: astore_0
    //   127: getstatic 23	com/tencent/ttpic/util/VideoBitmapUtil:TAG	Ljava/lang/String;
    //   130: aload_0
    //   131: invokevirtual 145	java/io/IOException:toString	()Ljava/lang/String;
    //   134: invokestatic 151	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   137: pop
    //   138: aconst_null
    //   139: areturn
    //   140: astore_1
    //   141: getstatic 23	com/tencent/ttpic/util/VideoBitmapUtil:TAG	Ljava/lang/String;
    //   144: aload_1
    //   145: invokevirtual 145	java/io/IOException:toString	()Ljava/lang/String;
    //   148: invokestatic 151	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   151: pop
    //   152: aload_3
    //   153: ifnull -142 -> 11
    //   156: aload_3
    //   157: invokevirtual 124	java/io/InputStream:close	()V
    //   160: aconst_null
    //   161: areturn
    //   162: astore_0
    //   163: aconst_null
    //   164: areturn
    //   165: astore_0
    //   166: aload 5
    //   168: aload 5
    //   170: getfield 107	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   173: iconst_1
    //   174: ishl
    //   175: putfield 107	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   178: aload_3
    //   179: invokevirtual 115	java/io/InputStream:reset	()V
    //   182: aload_3
    //   183: aconst_null
    //   184: aload 5
    //   186: invokestatic 121	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   189: astore_0
    //   190: aload_0
    //   191: astore_1
    //   192: aload_1
    //   193: astore_0
    //   194: aload_3
    //   195: ifnull -184 -> 11
    //   198: aload_3
    //   199: invokevirtual 124	java/io/InputStream:close	()V
    //   202: aload_1
    //   203: areturn
    //   204: astore_0
    //   205: aload_1
    //   206: areturn
    //   207: astore_0
    //   208: getstatic 23	com/tencent/ttpic/util/VideoBitmapUtil:TAG	Ljava/lang/String;
    //   211: aload_0
    //   212: invokevirtual 154	java/lang/Throwable:toString	()Ljava/lang/String;
    //   215: invokestatic 151	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   218: pop
    //   219: goto -27 -> 192
    //   222: astore_0
    //   223: aload_3
    //   224: ifnull +7 -> 231
    //   227: aload_3
    //   228: invokevirtual 124	java/io/InputStream:close	()V
    //   231: aload_0
    //   232: athrow
    //   233: astore_0
    //   234: goto -26 -> 208
    //   237: astore_1
    //   238: goto -7 -> 231
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	241	0	paramContext	Context
    //   0	241	1	paramString	String
    //   0	241	2	paramInt	int
    //   1	77	3	localInputStream1	java.io.InputStream
    //   86	1	3	localIOException	IOException
    //   122	106	3	localInputStream2	java.io.InputStream
    //   66	3	4	localBitmap	Bitmap
    //   31	154	5	localOptions	BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   77	81	83	java/io/IOException
    //   18	24	86	java/io/IOException
    //   87	123	126	java/io/IOException
    //   55	68	140	java/io/IOException
    //   156	160	162	java/io/IOException
    //   55	68	165	java/lang/OutOfMemoryError
    //   198	202	204	java/io/IOException
    //   178	190	207	java/io/IOException
    //   55	68	222	finally
    //   141	152	222	finally
    //   166	178	222	finally
    //   178	190	222	finally
    //   208	219	222	finally
    //   178	190	233	java/lang/OutOfMemoryError
    //   227	231	237	java/io/IOException
  }
  
  /* Error */
  public static Bitmap decodeSampleBitmapFromAssets(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_1
    //   4: invokestatic 51	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: ifeq +8 -> 15
    //   10: aload 4
    //   12: astore_0
    //   13: aload_0
    //   14: areturn
    //   15: aload_0
    //   16: invokevirtual 93	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   19: astore_0
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 99	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   25: astore 4
    //   27: new 31	android/graphics/BitmapFactory$Options
    //   30: dup
    //   31: invokespecial 100	android/graphics/BitmapFactory$Options:<init>	()V
    //   34: astore 6
    //   36: aload 6
    //   38: iconst_1
    //   39: putfield 104	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   42: aload 4
    //   44: aconst_null
    //   45: aload 6
    //   47: invokestatic 121	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   50: pop
    //   51: aload 6
    //   53: iconst_0
    //   54: putfield 104	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   57: aload 6
    //   59: aload 6
    //   61: iload_2
    //   62: iload_3
    //   63: invokestatic 156	com/tencent/ttpic/util/VideoBitmapUtil:calculateInSampleSize	(Landroid/graphics/BitmapFactory$Options;II)I
    //   66: putfield 107	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   69: aload 6
    //   71: iconst_1
    //   72: putfield 110	android/graphics/BitmapFactory$Options:inPreferQualityOverSpeed	Z
    //   75: aconst_null
    //   76: astore_1
    //   77: aconst_null
    //   78: astore_0
    //   79: aload 4
    //   81: invokevirtual 115	java/io/InputStream:reset	()V
    //   84: aload 4
    //   86: aconst_null
    //   87: aload 6
    //   89: invokestatic 121	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   92: astore 5
    //   94: aload 5
    //   96: astore_1
    //   97: aload_1
    //   98: astore_0
    //   99: aload 4
    //   101: ifnull -88 -> 13
    //   104: aload 4
    //   106: invokevirtual 124	java/io/InputStream:close	()V
    //   109: aload_1
    //   110: areturn
    //   111: astore_0
    //   112: aload_1
    //   113: areturn
    //   114: astore 4
    //   116: aload_0
    //   117: new 126	java/lang/StringBuilder
    //   120: dup
    //   121: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   124: aload_1
    //   125: iconst_0
    //   126: aload_1
    //   127: bipush 46
    //   129: invokevirtual 131	java/lang/String:lastIndexOf	(I)I
    //   132: iconst_1
    //   133: iadd
    //   134: invokevirtual 135	java/lang/String:substring	(II)Ljava/lang/String;
    //   137: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: ldc 141
    //   142: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   148: invokevirtual 99	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   151: astore 4
    //   153: goto -126 -> 27
    //   156: astore_0
    //   157: getstatic 23	com/tencent/ttpic/util/VideoBitmapUtil:TAG	Ljava/lang/String;
    //   160: aload_0
    //   161: invokevirtual 145	java/io/IOException:toString	()Ljava/lang/String;
    //   164: invokestatic 151	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   167: pop
    //   168: aconst_null
    //   169: areturn
    //   170: astore_1
    //   171: getstatic 23	com/tencent/ttpic/util/VideoBitmapUtil:TAG	Ljava/lang/String;
    //   174: aload_1
    //   175: invokevirtual 145	java/io/IOException:toString	()Ljava/lang/String;
    //   178: invokestatic 151	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   181: pop
    //   182: aload 4
    //   184: ifnull -171 -> 13
    //   187: aload 4
    //   189: invokevirtual 124	java/io/InputStream:close	()V
    //   192: aconst_null
    //   193: areturn
    //   194: astore_0
    //   195: aconst_null
    //   196: areturn
    //   197: astore_0
    //   198: aload 6
    //   200: aload 6
    //   202: getfield 107	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   205: iconst_1
    //   206: ishl
    //   207: putfield 107	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   210: aload 4
    //   212: invokevirtual 115	java/io/InputStream:reset	()V
    //   215: aload 4
    //   217: aconst_null
    //   218: aload 6
    //   220: invokestatic 121	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   223: astore_0
    //   224: aload_0
    //   225: astore_1
    //   226: aload_1
    //   227: astore_0
    //   228: aload 4
    //   230: ifnull -217 -> 13
    //   233: aload 4
    //   235: invokevirtual 124	java/io/InputStream:close	()V
    //   238: aload_1
    //   239: areturn
    //   240: astore_0
    //   241: aload_1
    //   242: areturn
    //   243: astore_0
    //   244: getstatic 23	com/tencent/ttpic/util/VideoBitmapUtil:TAG	Ljava/lang/String;
    //   247: aload_0
    //   248: invokevirtual 154	java/lang/Throwable:toString	()Ljava/lang/String;
    //   251: invokestatic 151	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   254: pop
    //   255: goto -29 -> 226
    //   258: astore_0
    //   259: aload 4
    //   261: ifnull +8 -> 269
    //   264: aload 4
    //   266: invokevirtual 124	java/io/InputStream:close	()V
    //   269: aload_0
    //   270: athrow
    //   271: astore_0
    //   272: goto -28 -> 244
    //   275: astore_1
    //   276: goto -7 -> 269
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	279	0	paramContext	Context
    //   0	279	1	paramString	String
    //   0	279	2	paramInt1	int
    //   0	279	3	paramInt2	int
    //   1	104	4	localInputStream1	java.io.InputStream
    //   114	1	4	localIOException	IOException
    //   151	114	4	localInputStream2	java.io.InputStream
    //   92	3	5	localBitmap	Bitmap
    //   34	185	6	localOptions	BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   104	109	111	java/io/IOException
    //   20	27	114	java/io/IOException
    //   116	153	156	java/io/IOException
    //   79	94	170	java/io/IOException
    //   187	192	194	java/io/IOException
    //   79	94	197	java/lang/OutOfMemoryError
    //   233	238	240	java/io/IOException
    //   210	224	243	java/io/IOException
    //   79	94	258	finally
    //   171	182	258	finally
    //   198	210	258	finally
    //   210	224	258	finally
    //   244	255	258	finally
    //   210	224	271	java/lang/OutOfMemoryError
    //   264	269	275	java/io/IOException
  }
  
  public static Bitmap decodeSampledBitmapFromFile(String paramString, int paramInt)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inSampleSize = paramInt;
    localOptions.inJustDecodeBounds = false;
    localOptions.inPreferQualityOverSpeed = true;
    try
    {
      Bitmap localBitmap = BitmapFactory.decodeFile(paramString, localOptions);
      return localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      ImageMemoryManager.getInstance().evictAll();
      localOptions.inSampleSize <<= 1;
      try
      {
        paramString = BitmapFactory.decodeFile(paramString, localOptions);
        return paramString;
      }
      catch (OutOfMemoryError paramString)
      {
        Log.e(TAG, paramString.toString());
      }
    }
    return null;
  }
  
  public static Bitmap decodeSampledBitmapFromFile(String paramString, int paramInt1, int paramInt2)
  {
    Object localObject;
    if (!VideoFileUtil.exists(paramString)) {
      localObject = null;
    }
    for (;;)
    {
      return localObject;
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      BitmapFactory.decodeFile(paramString, localOptions);
      localOptions.inSampleSize = calculateInSampleSize(localOptions, paramInt1, paramInt2);
      localOptions.inJustDecodeBounds = false;
      localOptions.inPreferQualityOverSpeed = true;
      localObject = null;
      try
      {
        Bitmap localBitmap = BitmapFactory.decodeFile(paramString, localOptions);
        localObject = localBitmap;
        if (0 != 0)
        {
          localObject = localBitmap;
          localBitmap = rotate(localBitmap, 0);
          return localBitmap;
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        ImageMemoryManager.getInstance().evictAll();
        localOptions.inSampleSize <<= 1;
        try
        {
          paramString = BitmapFactory.decodeFile(paramString, localOptions);
          localObject = paramString;
          if (0 != 0)
          {
            localObject = paramString;
            paramString = rotate(paramString, 0);
            return paramString;
          }
        }
        catch (OutOfMemoryError paramString)
        {
          Log.e(TAG, paramString.toString());
        }
      }
    }
    return localObject;
  }
  
  public static Point getBitmapSize(Context paramContext, String paramString)
  {
    if (paramString.startsWith("assets://")) {
      return getBitmapSizeFromAssets(paramContext, VideoUtil.getRealPath(paramString));
    }
    return getBitmapSizeFromFile(paramString);
  }
  
  private static Point getBitmapSizeFromAssets(Context paramContext, String paramString)
  {
    Point localPoint = new Point(0, 0);
    if (TextUtils.isEmpty(paramString)) {
      return localPoint;
    }
    AssetManager localAssetManager = paramContext.getAssets();
    try
    {
      paramContext = localAssetManager.open(paramString);
      paramString = new BitmapFactory.Options();
      paramString.inJustDecodeBounds = true;
      BitmapFactory.decodeStream(paramContext, null, paramString);
      return new Point(paramString.outWidth, paramString.outHeight);
    }
    catch (IOException paramContext)
    {
      try
      {
        paramContext = localAssetManager.open(paramString.substring(0, paramString.lastIndexOf('.') + 1) + "webp");
      }
      catch (IOException paramContext)
      {
        Log.e(TAG, paramContext.toString());
      }
    }
    return localPoint;
  }
  
  private static Point getBitmapSizeFromFile(String paramString)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions);
    return new Point(localOptions.outWidth, localOptions.outHeight);
  }
  
  public static int getDegree(String paramString)
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
          int i = getDegreeFromOrientation(paramString.getAttributeInt("Orientation", 0));
          return i;
        }
      }
      catch (Exception paramString) {}
    }
    return 0;
  }
  
  public static int getDegreeFromOrientation(int paramInt)
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
  
  public static boolean isKtxPath(String paramString)
  {
    return paramString.endsWith(".ktx");
  }
  
  public static boolean isLegal(Bitmap paramBitmap)
  {
    return (paramBitmap != null) && (!paramBitmap.isRecycled());
  }
  
  public static boolean isPngPath(String paramString)
  {
    return paramString.endsWith(".png");
  }
  
  public static Bitmap rotate(Bitmap paramBitmap, int paramInt)
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
        paramBitmap.recycle();
        localObject = localBitmap;
      }
      return localObject;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      Log.e(TAG, "OutOfMemoryError. " + localOutOfMemoryError);
    }
    return paramBitmap;
  }
  
  /* Error */
  public static int saveBitmap2PNG(Bitmap paramBitmap, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore_3
    //   8: aload 5
    //   10: astore_2
    //   11: new 253	java/io/File
    //   14: dup
    //   15: aload_1
    //   16: invokespecial 254	java/io/File:<init>	(Ljava/lang/String;)V
    //   19: astore 6
    //   21: aload 5
    //   23: astore_2
    //   24: aload 6
    //   26: invokevirtual 258	java/io/File:getParentFile	()Ljava/io/File;
    //   29: astore 7
    //   31: aload 5
    //   33: astore_2
    //   34: aload 7
    //   36: invokevirtual 260	java/io/File:exists	()Z
    //   39: ifne +12 -> 51
    //   42: aload 5
    //   44: astore_2
    //   45: aload 7
    //   47: invokevirtual 263	java/io/File:mkdirs	()Z
    //   50: pop
    //   51: aload 5
    //   53: astore_2
    //   54: aload 6
    //   56: invokevirtual 260	java/io/File:exists	()Z
    //   59: ifne +12 -> 71
    //   62: aload 5
    //   64: astore_2
    //   65: aload 6
    //   67: invokevirtual 266	java/io/File:createNewFile	()Z
    //   70: pop
    //   71: aload 5
    //   73: astore_2
    //   74: new 268	java/io/FileOutputStream
    //   77: dup
    //   78: aload_1
    //   79: invokespecial 269	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   82: astore_1
    //   83: aload_0
    //   84: ifnull +18 -> 102
    //   87: aload_0
    //   88: getstatic 275	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   91: bipush 95
    //   93: aload_1
    //   94: invokevirtual 279	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   97: pop
    //   98: aload_1
    //   99: invokevirtual 282	java/io/FileOutputStream:flush	()V
    //   102: aload_1
    //   103: invokestatic 288	com/tencent/util/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   106: iconst_0
    //   107: ireturn
    //   108: astore_1
    //   109: aload_3
    //   110: astore_0
    //   111: aload_0
    //   112: astore_2
    //   113: getstatic 23	com/tencent/ttpic/util/VideoBitmapUtil:TAG	Ljava/lang/String;
    //   116: aload_1
    //   117: invokevirtual 289	java/lang/Exception:toString	()Ljava/lang/String;
    //   120: invokestatic 151	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   123: pop
    //   124: aload_0
    //   125: invokestatic 288	com/tencent/util/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   128: iconst_m1
    //   129: ireturn
    //   130: astore_1
    //   131: aload 4
    //   133: astore_0
    //   134: aload_0
    //   135: astore_2
    //   136: getstatic 23	com/tencent/ttpic/util/VideoBitmapUtil:TAG	Ljava/lang/String;
    //   139: aload_1
    //   140: invokevirtual 170	java/lang/OutOfMemoryError:toString	()Ljava/lang/String;
    //   143: invokestatic 151	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   146: pop
    //   147: aload_0
    //   148: invokestatic 288	com/tencent/util/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   151: bipush 254
    //   153: ireturn
    //   154: astore_0
    //   155: aload_2
    //   156: invokestatic 288	com/tencent/util/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   159: aload_0
    //   160: athrow
    //   161: astore_0
    //   162: aload_1
    //   163: astore_2
    //   164: goto -9 -> 155
    //   167: astore_2
    //   168: aload_1
    //   169: astore_0
    //   170: aload_2
    //   171: astore_1
    //   172: goto -38 -> 134
    //   175: astore_2
    //   176: aload_1
    //   177: astore_0
    //   178: aload_2
    //   179: astore_1
    //   180: goto -69 -> 111
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	183	0	paramBitmap	Bitmap
    //   0	183	1	paramString	String
    //   10	154	2	localObject1	Object
    //   167	4	2	localOutOfMemoryError	OutOfMemoryError
    //   175	4	2	localException	Exception
    //   7	103	3	localObject2	Object
    //   1	131	4	localObject3	Object
    //   4	68	5	localObject4	Object
    //   19	47	6	localFile1	java.io.File
    //   29	17	7	localFile2	java.io.File
    // Exception table:
    //   from	to	target	type
    //   11	21	108	java/lang/Exception
    //   24	31	108	java/lang/Exception
    //   34	42	108	java/lang/Exception
    //   45	51	108	java/lang/Exception
    //   54	62	108	java/lang/Exception
    //   65	71	108	java/lang/Exception
    //   74	83	108	java/lang/Exception
    //   11	21	130	java/lang/OutOfMemoryError
    //   24	31	130	java/lang/OutOfMemoryError
    //   34	42	130	java/lang/OutOfMemoryError
    //   45	51	130	java/lang/OutOfMemoryError
    //   54	62	130	java/lang/OutOfMemoryError
    //   65	71	130	java/lang/OutOfMemoryError
    //   74	83	130	java/lang/OutOfMemoryError
    //   11	21	154	finally
    //   24	31	154	finally
    //   34	42	154	finally
    //   45	51	154	finally
    //   54	62	154	finally
    //   65	71	154	finally
    //   74	83	154	finally
    //   113	124	154	finally
    //   136	147	154	finally
    //   87	102	161	finally
    //   87	102	167	java/lang/OutOfMemoryError
    //   87	102	175	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.util.VideoBitmapUtil
 * JD-Core Version:    0.7.0.1
 */