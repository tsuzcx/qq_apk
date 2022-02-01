package com.tencent.xaction.api.util;

import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.util.DisplayMetrics;
import com.tencent.xaction.log.QLog;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/api/util/BitmapUtil$Companion;", "", "()V", "calculateInSampleSize", "", "options", "Landroid/graphics/BitmapFactory$Options;", "reqWidth", "reqHeight", "loadBitmap", "Landroid/graphics/Bitmap;", "resources", "Landroid/content/res/Resources;", "path", "", "isAssets", "", "wh", "", "XActionEngine_release"}, k=1, mv={1, 1, 16})
public final class BitmapUtil$Companion
{
  @JvmStatic
  public final int a(@NotNull BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int i = 1;
    int j = 1;
    Intrinsics.checkParameterIsNotNull(paramOptions, "options");
    int m = j;
    if (paramInt1 != 0)
    {
      m = j;
      if (paramInt2 != 0)
      {
        m = j;
        if (paramInt1 != -1)
        {
          if (paramInt2 != -1) {
            break label49;
          }
          m = j;
        }
      }
    }
    label49:
    int k;
    label61:
    do
    {
      do
      {
        return m;
        j = paramOptions.outHeight;
        k = paramOptions.outWidth;
        m = i;
      } while (j <= paramInt2);
      m = i;
    } while (k <= paramInt1);
    int n = MathKt.roundToInt(j / paramInt2);
    m = MathKt.roundToInt(k / paramInt1);
    if (n > m) {}
    for (;;)
    {
      m = i;
      if (n < 2) {
        break;
      }
      i <<= 1;
      k >>= 1;
      j >>= 1;
      break label61;
      n = m;
    }
  }
  
  @JvmStatic
  @Nullable
  public final Bitmap a(@Nullable Resources paramResources, @NotNull String paramString, @NotNull BitmapFactory.Options paramOptions, boolean paramBoolean, @Nullable int[] paramArrayOfInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "path");
    Intrinsics.checkParameterIsNotNull(paramOptions, "options");
    if (!new File(paramString).exists()) {
      return null;
    }
    paramOptions.inDensity = 320;
    if (paramResources != null) {
      paramOptions.inTargetDensity = paramResources.getDisplayMetrics().densityDpi;
    }
    if (paramBoolean)
    {
      if (paramResources == null) {
        return null;
      }
      paramOptions.inTargetDensity = paramResources.getDisplayMetrics().densityDpi;
      paramResources = (InputStream)new BufferedInputStream(paramResources.getAssets().open(paramString));
    }
    for (;;)
    {
      if (paramArrayOfInt != null) {}
      try
      {
        paramOptions.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(paramString, paramOptions);
        paramOptions.inJustDecodeBounds = false;
        paramOptions.inSampleSize = ((Companion)this).a(paramOptions, paramArrayOfInt[0], paramArrayOfInt[1]);
        paramString = BitmapFactory.decodeStream(paramResources, null, paramOptions);
        Intrinsics.checkExpressionValueIsNotNull(paramString, "BitmapFactory.decodeStream(stream, null, options)");
        try
        {
          paramResources.close();
          return paramString;
          paramResources = (InputStream)new BufferedInputStream((InputStream)new FileInputStream(paramString));
        }
        catch (IOException paramResources)
        {
          for (;;)
          {
            paramResources.printStackTrace();
          }
        }
        return null;
      }
      catch (OutOfMemoryError paramResources)
      {
        QLog.a("loadBitmap", 1, "loadbitmap oom", (Throwable)paramResources);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.xaction.api.util.BitmapUtil.Companion
 * JD-Core Version:    0.7.0.1
 */