package com.tencent.tkd.topicsdk.ucrop.util;

import android.graphics.Bitmap;
import android.graphics.RectF;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/ucrop/util/BitmapUtils;", "", "()V", "resizeAndCrop", "Landroid/graphics/Bitmap;", "bitmap", "cropRect", "Landroid/graphics/RectF;", "currentImageRect", "currentScale", "", "shouldCrop", "", "width", "", "height", "topicsdk-ucrop_release"}, k=1, mv={1, 1, 16})
public final class BitmapUtils
{
  public static final BitmapUtils a = new BitmapUtils();
  
  @JvmStatic
  @Nullable
  public static final Bitmap a(@NotNull Bitmap paramBitmap, @NotNull RectF paramRectF1, @NotNull RectF paramRectF2, float paramFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramBitmap, "bitmap");
    Intrinsics.checkParameterIsNotNull(paramRectF1, "cropRect");
    Intrinsics.checkParameterIsNotNull(paramRectF2, "currentImageRect");
    int i = (int)((paramRectF1.left - paramRectF2.left) / paramFloat);
    int j = (int)((paramRectF1.top - paramRectF2.top) / paramFloat);
    int k = (int)(paramRectF1.width() / paramFloat);
    int m = (int)(paramRectF1.height() / paramFloat);
    Bitmap localBitmap = paramBitmap;
    if (a.a(paramRectF1, paramRectF2, k, m)) {}
    try
    {
      paramBitmap = Bitmap.createBitmap(paramBitmap, i, j, k, m);
      return paramBitmap;
    }
    catch (Throwable paramBitmap)
    {
      label97:
      break label97;
    }
    localBitmap = null;
    return localBitmap;
  }
  
  private final boolean a(RectF paramRectF1, RectF paramRectF2, int paramInt1, int paramInt2)
  {
    paramInt1 = Math.max(paramInt1, paramInt2) / (int)1000.0F;
    boolean bool2 = true;
    float f1 = Math.abs(paramRectF1.left - paramRectF2.left);
    float f2 = paramInt1 + 1;
    boolean bool1 = bool2;
    if (f1 <= f2)
    {
      bool1 = bool2;
      if (Math.abs(paramRectF1.top - paramRectF2.top) <= f2)
      {
        bool1 = bool2;
        if (Math.abs(paramRectF1.bottom - paramRectF2.bottom) <= f2)
        {
          if (Math.abs(paramRectF1.right - paramRectF2.right) > f2) {
            return true;
          }
          bool1 = false;
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.ucrop.util.BitmapUtils
 * JD-Core Version:    0.7.0.1
 */