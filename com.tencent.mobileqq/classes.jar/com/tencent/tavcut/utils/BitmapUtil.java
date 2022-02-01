package com.tencent.tavcut.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.util.Size;
import com.tencent.tavcut.render.log.TavLogger;
import java.io.File;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/utils/BitmapUtil;", "", "()V", "TAG", "", "calculateInSampleSize", "", "options", "Landroid/graphics/BitmapFactory$Options;", "reqWidth", "reqHeight", "compressBitmap", "Landroid/graphics/Bitmap;", "path", "size", "Landroid/util/Size;", "lib_tavcut_release"}, k=1, mv={1, 1, 16})
public final class BitmapUtil
{
  public static final BitmapUtil a = new BitmapUtil();
  
  private final int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    paramOptions = TuplesKt.to(Integer.valueOf(paramOptions.outHeight), Integer.valueOf(paramOptions.outWidth));
    int k = ((Number)paramOptions.component1()).intValue();
    int m = ((Number)paramOptions.component2()).intValue();
    int j = 1;
    int i = 1;
    if ((k > paramInt2) || (m > paramInt1))
    {
      k /= 2;
      m /= 2;
      for (;;)
      {
        j = i;
        if (k / i < paramInt2) {
          break;
        }
        j = i;
        if (m / i < paramInt1) {
          break;
        }
        i *= 2;
      }
    }
    return j;
  }
  
  @Nullable
  public final Bitmap a(@NotNull String paramString, @NotNull Size paramSize)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "path");
    Intrinsics.checkParameterIsNotNull(paramSize, "size");
    if (!new File(paramString).exists())
    {
      TavLogger.e("BitmapUtils", "target file not exit");
      return null;
    }
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions);
    localOptions.inSampleSize = a.a(localOptions, paramSize.getWidth(), paramSize.getHeight());
    localOptions.inJustDecodeBounds = false;
    return BitmapFactory.decodeFile(paramString, localOptions);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.utils.BitmapUtil
 * JD-Core Version:    0.7.0.1
 */