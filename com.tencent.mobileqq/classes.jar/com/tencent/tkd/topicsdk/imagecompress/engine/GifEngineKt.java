package com.tencent.tkd.topicsdk.imagecompress.engine;

import android.graphics.Bitmap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"scale", "Landroid/graphics/Bitmap;", "scaleSize", "", "topicsdk_release"}, k=2, mv={1, 1, 16})
public final class GifEngineKt
{
  private static final Bitmap b(@NotNull Bitmap paramBitmap, float paramFloat)
  {
    Bitmap localBitmap = Bitmap.createScaledBitmap(paramBitmap, (int)(paramBitmap.getWidth() * paramFloat), (int)(paramBitmap.getHeight() * paramFloat), true);
    paramBitmap.recycle();
    Intrinsics.checkExpressionValueIsNotNull(localBitmap, "result");
    return localBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.imagecompress.engine.GifEngineKt
 * JD-Core Version:    0.7.0.1
 */