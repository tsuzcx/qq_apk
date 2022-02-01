package com.tencent.tkd.topicsdk.ucrop.model;

import android.graphics.RectF;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/ucrop/model/ImageState;", "", "cropRect", "Landroid/graphics/RectF;", "currentImageRect", "currentScale", "", "currentAngle", "(Landroid/graphics/RectF;Landroid/graphics/RectF;FF)V", "getCropRect", "()Landroid/graphics/RectF;", "getCurrentAngle", "()F", "getCurrentImageRect", "getCurrentScale", "topicsdk-ucrop_release"}, k=1, mv={1, 1, 16})
public final class ImageState
{
  private final float jdField_a_of_type_Float;
  @NotNull
  private final RectF jdField_a_of_type_AndroidGraphicsRectF;
  private final float jdField_b_of_type_Float;
  @NotNull
  private final RectF jdField_b_of_type_AndroidGraphicsRectF;
  
  public ImageState(@NotNull RectF paramRectF1, @NotNull RectF paramRectF2, float paramFloat1, float paramFloat2)
  {
    this.jdField_a_of_type_AndroidGraphicsRectF = paramRectF1;
    this.jdField_b_of_type_AndroidGraphicsRectF = paramRectF2;
    this.jdField_a_of_type_Float = paramFloat1;
    this.jdField_b_of_type_Float = paramFloat2;
  }
  
  public final float a()
  {
    return this.jdField_a_of_type_Float;
  }
  
  @NotNull
  public final RectF a()
  {
    return this.jdField_a_of_type_AndroidGraphicsRectF;
  }
  
  @NotNull
  public final RectF b()
  {
    return this.jdField_b_of_type_AndroidGraphicsRectF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.ucrop.model.ImageState
 * JD-Core Version:    0.7.0.1
 */