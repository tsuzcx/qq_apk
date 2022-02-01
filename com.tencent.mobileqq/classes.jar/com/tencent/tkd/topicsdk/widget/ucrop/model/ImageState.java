package com.tencent.tkd.topicsdk.widget.ucrop.model;

import android.graphics.RectF;
import org.jetbrains.annotations.NotNull;

public class ImageState
{
  private float jdField_a_of_type_Float;
  private RectF jdField_a_of_type_AndroidGraphicsRectF;
  private float jdField_b_of_type_Float;
  private RectF jdField_b_of_type_AndroidGraphicsRectF;
  
  public ImageState(RectF paramRectF1, RectF paramRectF2, float paramFloat1, float paramFloat2)
  {
    this.jdField_a_of_type_AndroidGraphicsRectF = paramRectF1;
    this.jdField_b_of_type_AndroidGraphicsRectF = paramRectF2;
    this.jdField_a_of_type_Float = paramFloat1;
    this.jdField_b_of_type_Float = paramFloat2;
  }
  
  public float a()
  {
    return this.jdField_a_of_type_Float;
  }
  
  public RectF a()
  {
    return this.jdField_a_of_type_AndroidGraphicsRectF;
  }
  
  public RectF b()
  {
    return this.jdField_b_of_type_AndroidGraphicsRectF;
  }
  
  @NotNull
  public String toString()
  {
    return "cropRect:" + this.jdField_a_of_type_AndroidGraphicsRectF + " ,imageRect:" + this.jdField_b_of_type_AndroidGraphicsRectF + " ,scale:" + this.jdField_a_of_type_Float + " ,angle:" + this.jdField_b_of_type_Float;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.ucrop.model.ImageState
 * JD-Core Version:    0.7.0.1
 */