package com.tencent.xaction.api.util;

import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.util.DisplayMetrics;
import com.tencent.xaction.api.IMemoryLruCache;
import com.tencent.xaction.impl.XAEngine;
import com.tencent.xaction.impl.XAEngine.Companion;
import com.tencent.xaction.log.QLog;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/api/util/BitmapUtil$Companion;", "", "()V", "calculateInSampleSize", "", "options", "Landroid/graphics/BitmapFactory$Options;", "reqWidth", "reqHeight", "getInputStream", "Ljava/io/InputStream;", "resources", "Landroid/content/res/Resources;", "isAssets", "", "path", "", "loadBitmap", "Landroid/graphics/Bitmap;", "wh", "", "inputStream", "locadBitmapCache", "XActionCore_release"}, k=1, mv={1, 1, 16})
public final class BitmapUtil$Companion
{
  private final InputStream a(Resources paramResources, boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      if (paramResources == null) {
        return null;
      }
    }
    try
    {
      return (InputStream)new BufferedInputStream(paramResources.getAssets().open(paramString));
    }
    catch (OutOfMemoryError paramResources)
    {
      QLog.a("loadBitmap", 1, "getInputStream oom", (Throwable)paramResources);
      return null;
    }
    catch (Exception paramResources)
    {
      QLog.a("loadBitmap", 1, "getInputStream exception", (Throwable)paramResources);
    }
    if (!new File(paramString).exists()) {
      return null;
    }
    paramResources = (InputStream)new BufferedInputStream((InputStream)new FileInputStream(paramString));
    return paramResources;
    return null;
  }
  
  @JvmStatic
  public final int a(@NotNull BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramOptions, "options");
    int j = 1;
    int i = 1;
    int m = j;
    if (paramInt1 != 0)
    {
      m = j;
      if (paramInt2 != 0)
      {
        m = j;
        if (paramInt1 != ScreenUnit.a.a())
        {
          if (paramInt2 == ScreenUnit.a.a()) {
            return 1;
          }
          j = paramOptions.outHeight;
          int k = paramOptions.outWidth;
          for (;;)
          {
            m = i;
            if (j <= paramInt2) {
              break;
            }
            m = i;
            if (k <= paramInt1) {
              break;
            }
            int n = MathKt.roundToInt(j / paramInt2);
            m = MathKt.roundToInt(k / paramInt1);
            if (n <= m) {
              n = m;
            }
            m = i;
            if (n < 2) {
              break;
            }
            k >>= 1;
            j >>= 1;
            i <<= 1;
          }
        }
      }
    }
    return m;
  }
  
  @Nullable
  public final Bitmap a(@Nullable Resources paramResources, @NotNull String paramString, @NotNull BitmapFactory.Options paramOptions, boolean paramBoolean, @Nullable int[] paramArrayOfInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "path");
    Intrinsics.checkParameterIsNotNull(paramOptions, "options");
    Bitmap localBitmap = XAEngine.Companion.e().a(paramString);
    Object localObject = localBitmap;
    if (localBitmap == null)
    {
      paramResources = ((Companion)this).b(paramResources, paramString, paramOptions, paramBoolean, paramArrayOfInt);
      localObject = paramResources;
      if (paramResources != null)
      {
        XAEngine.Companion.e().a(paramString, paramResources);
        localObject = paramResources;
      }
    }
    return localObject;
  }
  
  /* Error */
  @JvmStatic
  @Nullable
  public final Bitmap a(@NotNull InputStream paramInputStream, @NotNull BitmapFactory.Options paramOptions, @Nullable int[] paramArrayOfInt)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 158
    //   3: invokestatic 100	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   6: aload_2
    //   7: ldc 94
    //   9: invokestatic 100	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   12: aconst_null
    //   13: checkcast 160	android/graphics/Bitmap
    //   16: astore 4
    //   18: aload_3
    //   19: ifnull +68 -> 87
    //   22: aload_3
    //   23: arraylength
    //   24: iconst_2
    //   25: if_icmpne +62 -> 87
    //   28: aload_3
    //   29: iconst_0
    //   30: iaload
    //   31: ifle +56 -> 87
    //   34: aload_3
    //   35: iconst_1
    //   36: iaload
    //   37: ifle +50 -> 87
    //   40: aload_2
    //   41: iconst_1
    //   42: putfield 164	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   45: aload_1
    //   46: aload_1
    //   47: invokevirtual 167	java/io/InputStream:available	()I
    //   50: invokevirtual 171	java/io/InputStream:mark	(I)V
    //   53: aload_1
    //   54: aconst_null
    //   55: aload_2
    //   56: invokestatic 177	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   59: pop
    //   60: aload_2
    //   61: iconst_0
    //   62: putfield 164	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   65: aload_1
    //   66: invokevirtual 180	java/io/InputStream:reset	()V
    //   69: aload_2
    //   70: aload_0
    //   71: checkcast 2	com/tencent/xaction/api/util/BitmapUtil$Companion
    //   74: aload_2
    //   75: aload_3
    //   76: iconst_0
    //   77: iaload
    //   78: aload_3
    //   79: iconst_1
    //   80: iaload
    //   81: invokevirtual 182	com/tencent/xaction/api/util/BitmapUtil$Companion:a	(Landroid/graphics/BitmapFactory$Options;II)I
    //   84: putfield 185	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   87: aload_1
    //   88: aconst_null
    //   89: aload_2
    //   90: invokestatic 177	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   93: astore_3
    //   94: aload_3
    //   95: astore_2
    //   96: aload_1
    //   97: invokevirtual 188	java/io/InputStream:close	()V
    //   100: aload_3
    //   101: areturn
    //   102: astore_1
    //   103: aload_1
    //   104: invokevirtual 191	java/io/IOException:printStackTrace	()V
    //   107: aload_2
    //   108: areturn
    //   109: astore_2
    //   110: goto +49 -> 159
    //   113: astore_2
    //   114: ldc 79
    //   116: iconst_1
    //   117: ldc 193
    //   119: aload_2
    //   120: checkcast 83	java/lang/Throwable
    //   123: invokestatic 88	com/tencent/xaction/log/QLog:a	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   126: aload 4
    //   128: astore_2
    //   129: aload_1
    //   130: invokevirtual 188	java/io/InputStream:close	()V
    //   133: aload 4
    //   135: areturn
    //   136: astore_2
    //   137: ldc 79
    //   139: iconst_1
    //   140: ldc 195
    //   142: aload_2
    //   143: checkcast 83	java/lang/Throwable
    //   146: invokestatic 88	com/tencent/xaction/log/QLog:a	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   149: aload 4
    //   151: astore_2
    //   152: aload_1
    //   153: invokevirtual 188	java/io/InputStream:close	()V
    //   156: aload 4
    //   158: areturn
    //   159: aload_1
    //   160: invokevirtual 188	java/io/InputStream:close	()V
    //   163: goto +8 -> 171
    //   166: astore_1
    //   167: aload_1
    //   168: invokevirtual 191	java/io/IOException:printStackTrace	()V
    //   171: aload_2
    //   172: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	173	0	this	Companion
    //   0	173	1	paramInputStream	InputStream
    //   0	173	2	paramOptions	BitmapFactory.Options
    //   0	173	3	paramArrayOfInt	int[]
    //   16	141	4	localBitmap	Bitmap
    // Exception table:
    //   from	to	target	type
    //   96	100	102	java/io/IOException
    //   129	133	102	java/io/IOException
    //   152	156	102	java/io/IOException
    //   22	28	109	finally
    //   40	87	109	finally
    //   87	94	109	finally
    //   114	126	109	finally
    //   137	149	109	finally
    //   22	28	113	java/lang/OutOfMemoryError
    //   40	87	113	java/lang/OutOfMemoryError
    //   87	94	113	java/lang/OutOfMemoryError
    //   22	28	136	java/lang/Exception
    //   40	87	136	java/lang/Exception
    //   87	94	136	java/lang/Exception
    //   159	163	166	java/io/IOException
  }
  
  @JvmStatic
  @Nullable
  public final Bitmap b(@Nullable Resources paramResources, @NotNull String paramString, @NotNull BitmapFactory.Options paramOptions, boolean paramBoolean, @Nullable int[] paramArrayOfInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "path");
    Intrinsics.checkParameterIsNotNull(paramOptions, "options");
    paramOptions.inDensity = 320;
    if (paramResources != null) {
      paramOptions.inTargetDensity = paramResources.getDisplayMetrics().densityDpi;
    }
    paramResources = ((Companion)this).a(paramResources, paramBoolean, paramString);
    if (paramResources != null) {
      return BitmapUtil.a.a(paramResources, paramOptions, paramArrayOfInt);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.api.util.BitmapUtil.Companion
 * JD-Core Version:    0.7.0.1
 */