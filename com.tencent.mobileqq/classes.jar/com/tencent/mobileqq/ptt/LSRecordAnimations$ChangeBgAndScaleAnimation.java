package com.tencent.mobileqq.ptt;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import com.tencent.qphone.base.util.QLog;

public class LSRecordAnimations$ChangeBgAndScaleAnimation
  extends ScaleAnimation
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private GradientDrawable jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable;
  private Animation.AnimationListener jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener;
  private LSRecordAnimations.TrackInfo jdField_a_of_type_ComTencentMobileqqPttLSRecordAnimations$TrackInfo;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  
  public LSRecordAnimations$ChangeBgAndScaleAnimation(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt1, float paramFloat5, int paramInt2, float paramFloat6, LSRecordAnimations.TrackInfo paramTrackInfo)
  {
    super(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramInt1, paramFloat5, paramInt2, paramFloat6);
    this.jdField_a_of_type_Float = paramFloat1;
    this.jdField_b_of_type_Float = (paramFloat2 - paramFloat1);
    this.jdField_a_of_type_ComTencentMobileqqPttLSRecordAnimations$TrackInfo = paramTrackInfo;
  }
  
  public void a(GradientDrawable paramGradientDrawable, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable = paramGradientDrawable;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    if (QLog.isDevelopLevel())
    {
      paramGradientDrawable = new StringBuilder();
      paramGradientDrawable.append("LS setColorChanger: ");
      paramGradientDrawable.append(paramInt1);
      paramGradientDrawable.append(" --> ");
      paramGradientDrawable.append(paramInt2);
      QLog.d("LsRecord", 4, paramGradientDrawable.toString());
    }
  }
  
  public void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    super.applyTransformation(paramFloat, paramTransformation);
    paramTransformation = this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener;
    if ((paramTransformation != null) && ((paramTransformation instanceof LSRecordAnimations.LSRecordAnimationCallback))) {
      ((LSRecordAnimations.LSRecordAnimationCallback)paramTransformation).a(this, paramFloat);
    }
    this.jdField_a_of_type_ComTencentMobileqqPttLSRecordAnimations$TrackInfo.jdField_a_of_type_Float = (this.jdField_a_of_type_Float + this.jdField_b_of_type_Float * paramFloat);
    if (QLog.isDevelopLevel())
    {
      paramTransformation = new StringBuilder();
      paramTransformation.append("LS applyTransformation: ");
      paramTransformation.append(paramFloat);
      paramTransformation.append(" F: ");
      paramTransformation.append(this.jdField_a_of_type_ComTencentMobileqqPttLSRecordAnimations$TrackInfo.jdField_a_of_type_Float);
      QLog.d("LsRecord", 4, paramTransformation.toString());
    }
    paramTransformation = this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable;
    if (paramTransformation != null)
    {
      int i = this.jdField_b_of_type_Int;
      if (paramFloat < 1.0F)
      {
        i = Color.argb((int)(Color.alpha(this.jdField_a_of_type_Int) + (Color.alpha(this.jdField_b_of_type_Int) - Color.alpha(this.jdField_a_of_type_Int)) * paramFloat), (int)(Color.red(this.jdField_a_of_type_Int) + (Color.red(this.jdField_b_of_type_Int) - Color.red(this.jdField_a_of_type_Int)) * paramFloat), (int)(Color.green(this.jdField_a_of_type_Int) + (Color.green(this.jdField_b_of_type_Int) - Color.green(this.jdField_a_of_type_Int)) * paramFloat), (int)(Color.blue(this.jdField_a_of_type_Int) + (Color.blue(this.jdField_b_of_type_Int) - Color.blue(this.jdField_a_of_type_Int)) * paramFloat));
        this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable.setColor(i);
      }
      else
      {
        paramTransformation.setColor(i);
        this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable = null;
      }
      this.jdField_a_of_type_ComTencentMobileqqPttLSRecordAnimations$TrackInfo.jdField_a_of_type_Int = i;
    }
    if (QLog.isDevelopLevel())
    {
      paramTransformation = new StringBuilder();
      paramTransformation.append("LS applyTransformation: ");
      paramTransformation.append(paramFloat);
      paramTransformation.append(" CLR: ");
      paramTransformation.append(this.jdField_a_of_type_ComTencentMobileqqPttLSRecordAnimations$TrackInfo.jdField_a_of_type_Int);
      QLog.d("LsRecord", 4, paramTransformation.toString());
    }
  }
  
  public void setAnimationListener(Animation.AnimationListener paramAnimationListener)
  {
    super.setAnimationListener(paramAnimationListener);
    this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener = paramAnimationListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ptt.LSRecordAnimations.ChangeBgAndScaleAnimation
 * JD-Core Version:    0.7.0.1
 */