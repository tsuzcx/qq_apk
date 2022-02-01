package com.tencent.mobileqq.kandian.base.view.widget;

import android.graphics.drawable.Drawable;
import android.view.animation.Transformation;
import android.widget.ImageView;
import com.tencent.mobileqq.widget.Rotate3dAnimation;

public class ReadinjoyRotate3dAnimation
  extends Rotate3dAnimation
{
  private final float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private final float jdField_b_of_type_Float;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    super.applyTransformation(paramFloat, paramTransformation);
    float f = this.jdField_a_of_type_Float;
    paramFloat = f + (this.jdField_b_of_type_Float - f) * paramFloat;
    paramTransformation = this.jdField_a_of_type_AndroidWidgetImageView;
    if ((paramTransformation != null) && (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null))
    {
      Drawable localDrawable = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
      if (localDrawable != null) {
        if ((paramFloat > 90.0F) && (paramFloat < 270.0F))
        {
          if (this.jdField_a_of_type_Int != 1)
          {
            paramTransformation.setImageDrawable(localDrawable);
            this.jdField_a_of_type_Int = 1;
          }
        }
        else if (this.jdField_a_of_type_Int != 0)
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
          this.jdField_a_of_type_Int = 0;
        }
      }
    }
  }
  
  public void cancel()
  {
    super.cancel();
    this.jdField_a_of_type_AndroidWidgetImageView = null;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.ReadinjoyRotate3dAnimation
 * JD-Core Version:    0.7.0.1
 */