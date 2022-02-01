package com.tencent.tavcut.view;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.RectF;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"calcDistance", "", "a", "Landroid/graphics/PointF;", "b", "calculateBitmap", "Landroid/graphics/RectF;", "containerWidth", "containerHeight", "bitmap", "Landroid/graphics/Bitmap;", "libtavcut_debug"}, k=2, mv={1, 1, 16})
public final class TAVCutImageViewKt
{
  public static final float a(@NotNull PointF paramPointF1, @NotNull PointF paramPointF2)
  {
    Intrinsics.checkParameterIsNotNull(paramPointF1, "a");
    Intrinsics.checkParameterIsNotNull(paramPointF2, "b");
    double d1 = paramPointF1.x - paramPointF2.x;
    double d2 = 2;
    return (float)Math.sqrt((float)Math.pow(d1, d2) + (float)Math.pow(paramPointF1.y - paramPointF2.y, d2));
  }
  
  @Nullable
  public static final RectF a(float paramFloat1, float paramFloat2, @NotNull Bitmap paramBitmap)
  {
    Intrinsics.checkParameterIsNotNull(paramBitmap, "bitmap");
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    float f2 = i;
    float f3 = paramFloat1 / f2;
    float f1 = j;
    f3 = Math.min(f3, paramFloat2 / f1);
    f2 *= f3;
    f1 *= f3;
    f3 = 2;
    return new RectF((paramFloat1 - f2) / f3, (paramFloat2 - f1) / f3, (paramFloat1 + f2) / f3, (paramFloat2 + f1) / f3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavcut.view.TAVCutImageViewKt
 * JD-Core Version:    0.7.0.1
 */