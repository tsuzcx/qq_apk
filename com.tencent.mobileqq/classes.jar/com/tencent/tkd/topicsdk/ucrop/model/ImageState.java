package com.tencent.tkd.topicsdk.ucrop.model;

import android.graphics.RectF;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/ucrop/model/ImageState;", "", "cropRect", "Landroid/graphics/RectF;", "currentImageRect", "currentScale", "", "currentAngle", "(Landroid/graphics/RectF;Landroid/graphics/RectF;FF)V", "getCropRect", "()Landroid/graphics/RectF;", "getCurrentAngle", "()F", "getCurrentImageRect", "getCurrentScale", "topicsdk-ucrop_release"}, k=1, mv={1, 1, 16})
public final class ImageState
{
  @NotNull
  private final RectF a;
  @NotNull
  private final RectF b;
  private final float c;
  private final float d;
  
  public ImageState(@NotNull RectF paramRectF1, @NotNull RectF paramRectF2, float paramFloat1, float paramFloat2)
  {
    this.a = paramRectF1;
    this.b = paramRectF2;
    this.c = paramFloat1;
    this.d = paramFloat2;
  }
  
  @NotNull
  public final RectF a()
  {
    return this.a;
  }
  
  @NotNull
  public final RectF b()
  {
    return this.b;
  }
  
  public final float c()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.ucrop.model.ImageState
 * JD-Core Version:    0.7.0.1
 */