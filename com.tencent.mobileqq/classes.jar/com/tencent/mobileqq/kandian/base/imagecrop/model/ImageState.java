package com.tencent.mobileqq.kandian.base.imagecrop.model;

import android.graphics.RectF;
import android.support.annotation.NonNull;

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
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("cropRect:");
    localStringBuilder.append(this.jdField_a_of_type_AndroidGraphicsRectF);
    localStringBuilder.append(" ,imageRect:");
    localStringBuilder.append(this.jdField_b_of_type_AndroidGraphicsRectF);
    localStringBuilder.append(" ,scale:");
    localStringBuilder.append(this.jdField_a_of_type_Float);
    localStringBuilder.append(" ,angle:");
    localStringBuilder.append(this.jdField_b_of_type_Float);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.imagecrop.model.ImageState
 * JD-Core Version:    0.7.0.1
 */